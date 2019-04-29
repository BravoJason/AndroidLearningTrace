package android.learning.trace.android_learning_trace.view.activity;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class BasicUIComponentP3Activity extends AppCompatActivity {

    Spinner spinner_city, spinner_province;
    AutoCompleteTextView autoCompleteTextView;
    Button btnShowProgressBar, btnIncreaseProgressBar;
    ProgressBar progressBar2;
    Button btnShowAlertDialog,
            btnShowListAlertDialog,
            btnShowMultiChoiceDialog,
            btnShowSingleChoiceDialog,
            btnShowCustomizedDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_uicomponent_p3);
        initSpinner();
        initAutoCompleteTextView();
        initProgressBar();
        initAlertDialog();
    }

    private void initSpinner() {
        spinner_province = findViewById(R.id.spinner_province);
        spinner_city = findViewById(R.id.spinner_city);
        String[] provinces = {"ON", "BC", "AB"};
        //Create an ArrayAdapter.
        //Method 1: by constructor.
        ArrayAdapter<String> provinceAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                android.R.id.text1,
                provinces);

        //Method 2: by String resource.
        ArrayAdapter cityAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.city,
                android.R.layout.simple_spinner_dropdown_item);

        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);


        spinner_province.setAdapter(provinceAdapter);
    }

    private void initAutoCompleteTextView() {
        //Find AutoCompleteTextView.
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        ArrayAdapter emailProvider = ArrayAdapter.createFromResource(
                this,
                R.array.email_surfix,
                android.R.layout.simple_dropdown_item_1line
        );
        autoCompleteTextView.setAdapter(emailProvider);

    }

    private void initProgressBar() {
        progressBar2 = findViewById(R.id.progressBar2);
        btnShowProgressBar = findViewById(R.id.btn_BasicUI_showProgress);
        btnIncreaseProgressBar = findViewById(R.id.btn_BasicUI_increaseProgress);
        class ProgresBarInfo {
            private int majorMax;
            private int majorProgress;
            private int secondaryProgress;
            private ProgressBar progressBar;

            private ProgresBarInfo(ProgressBar progressBar) {
                this.progressBar = progressBar;
                updateInfo();
            }

            private void updateInfo() {
                if (progressBar != null) {
                    majorMax = progressBar.getMax();
                    majorProgress = progressBar.getProgress();
                    secondaryProgress = progressBar.getSecondaryProgress();
                }
            }

            @Override
            public String toString() {
                return "Max progress: " + majorMax + ", major progress: " + majorProgress
                        + ", secondary progress:" + secondaryProgress;
            }
        }

        btnShowProgressBar.setOnClickListener(v -> {
            ProgresBarInfo progresBarInfo = new ProgresBarInfo(progressBar2);

            Toast.makeText(getApplicationContext(), progresBarInfo.toString(), Toast.LENGTH_SHORT).show();
        });

        btnIncreaseProgressBar.setOnClickListener(v -> {
            progressBar2.incrementProgressBy(10);
            progressBar2.incrementSecondaryProgressBy(20);
            ProgresBarInfo progresBarInfo = new ProgresBarInfo(progressBar2);
            Toast.makeText(this, progresBarInfo.toString(), Toast.LENGTH_SHORT).show();
        });


    }

    private void initAlertDialog() {
        btnShowAlertDialog = findViewById(R.id.btn_BasicUI_showAlertDialog);

        btnShowAlertDialog.setOnClickListener(v -> {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Title");
            builder.setMessage("This is the message.");
            builder.setIcon(R.drawable.ic_launcher_background);
            builder.setPositiveButton("Yes", (dialog, which) -> Toast.makeText(BasicUIComponentP3Activity.this, "Yes button is clicked.", Toast.LENGTH_SHORT).show());

            builder.setNegativeButton("No", (dialog, which) -> {
                Toast.makeText(this, "No button is clicked.", Toast.LENGTH_SHORT).show();
            });

            builder.setNeutralButton("Neutral", (dialog, which) -> {
                Toast.makeText(this, "Neutral button is clicked.", Toast.LENGTH_SHORT).show();
            });

            AlertDialog dialog = builder.create();
            dialog.show();

        });

        btnShowListAlertDialog = findViewById(R.id.btn_BasicUI_show_list_alertdialog);

        btnShowListAlertDialog.setOnClickListener(v -> {
            //Notice: When the activity deal with the dialog,
            // the context should use this, not getApplicationContext().
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Mobile Platform");
            String[] items = {"Android", "iOS", "Windows Phone"};
            builder.setItems(items, ((dialog, which) -> {
                Toast.makeText(this, items[which], Toast.LENGTH_SHORT).show();
            }));
            AlertDialog dialog = builder.create();
            dialog.show();
        });

        btnShowMultiChoiceDialog = findViewById(R.id.btn_BasicUI_show_multichoice_alertdialog);
        btnShowMultiChoiceDialog.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Multichoice dialog");
            String[] items = {"Java", "C++", "Python"};
            final ArrayList<String> results = new ArrayList<>();
            builder.setMultiChoiceItems(items, null, (dialog, which, isChecked) -> {
                if (isChecked) {
                    results.add(items[which]);
                } else {
                    results.remove(items[which]);
                }
            });

            builder.setIcon(R.drawable.ic_launcher_background);
            builder.setPositiveButton("Yes", (dialog, which) -> {
                Toast.makeText(BasicUIComponentP3Activity.this, results.toString(), Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            });

            builder.setNegativeButton("No", (dialog, which) -> {
                Toast.makeText(this, "No button is clicked.", Toast.LENGTH_SHORT).show();
                results.clear();
            });

            builder.show();


        });

        btnShowSingleChoiceDialog = findViewById(R.id.btn_BasicUI_show_singlechoice_alertdialog);

        btnShowSingleChoiceDialog.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            String[] items = {"Orange", "Apple", "Banana"};
            final int[] result = {0};
            builder.setSingleChoiceItems(items, 0, (dialog, which) -> {
                result[0] = which;
            });

            builder.setPositiveButton("Yes", (dialog, which) -> {
                if (result[0] != -1) {
                    Toast.makeText(this, items[result[0]], Toast.LENGTH_SHORT).show();
                }
                dialog.dismiss();
            });

            builder.setNegativeButton("Cancel", ((dialog, which) -> {
                result[0] = -1;
            }));

            builder.show();
        });

        btnShowCustomizedDialog = findViewById(R.id.btn_BasicUI_show_customized_alertdialog);
        btnShowCustomizedDialog.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("This is a customized dialog");
            //Only for API 21 and above.
            //builder.setView(R.layout.layout_customized_dialog);

            //For all versions.
            View view = getLayoutInflater().inflate(R.layout.layout_customized_dialog, null);
            builder.setView(view);

            builder.setPositiveButton("Login", (dialog, which) -> {
                EditText editTextUsername = view.findViewById(R.id.editText_username);
                EditText editTextPassword = view.findViewById(R.id.editText_password);
                Toast.makeText(this,
                        "Username: " +
                                editTextUsername.getText().toString() +
                                " Password: " +
                                editTextPassword.getText().toString(),
                        Toast.LENGTH_SHORT).show();
            });

            builder.setNegativeButton("Cancel", ((dialog, which) -> {
                dialog.dismiss();
            }));

            builder.show();

        });

    }


}
