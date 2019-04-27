package android.learning.trace.android_learning_trace.view;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

public class BasicUIComponentP3Activity extends AppCompatActivity {

    Spinner spinner_city, spinner_province;
    AutoCompleteTextView autoCompleteTextView;
    Button btnShowProgressBar, btnIncreaseProgressBar;
    ProgressBar progressBar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_uicomponent_p3);
        initSpinner();
        initAutoCompleteTextView();
        initProgressBar();
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


}
