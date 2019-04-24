package android.learning.trace.android_learning_trace.view;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BasicUIComponentP2Activity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    CheckBox checkBox1;
    CheckBox checkBox2;
    CheckBox checkBox3;
    Button btnShowCheckboxStatus;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_uicomponent_p2);
        initImageView();
        initCheckBox();
        initRadioButton();
    }

    private void initImageView() {
        ImageView imageView = findViewById(R.id.imageView);
        ImageView imageView2 = findViewById(R.id.imageView2);
        imageView2.setAdjustViewBounds(false);

    }

    private void initCheckBox() {
        //Find checkbox views.
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        //Find the button view.
        btnShowCheckboxStatus = findViewById(R.id.btn_show_ct_status);
        //Register checkbox callback function.
        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(this, "You checked the checkbox 3.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "You unchecked the checkbox 3.", Toast.LENGTH_SHORT).show();
            }

        }));

        btnShowCheckboxStatus.setOnClickListener(v -> {
            StringBuffer strStatus = new StringBuffer();
            if (checkBox1.isChecked()) {
                strStatus.append("Checkbox 1");
            }

            if (checkBox2.isChecked()) {
                strStatus.append(" Checkbox 2");
            }

            if (checkBox3.isChecked()) {
                strStatus.append(" Checkbox 3");
            }

            if (strStatus.length() == 0) {
                strStatus.append("No checkbox is selected.");
            }

            Toast.makeText(this, strStatus, Toast.LENGTH_SHORT).show();

        });

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.checkBox1:
                if (isChecked) {
                    Toast.makeText(this, "You checked the checkbox 1.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "You unchecked the checkbox 1.", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.checkBox2:
                if (isChecked) {
                    Toast.makeText(this, "You checked the checkbox 2.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "You unchecked the checkbox 2.", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }

    }

    private void initRadioButton() {
        radioButton1 = findViewById(R.id.radioButton1);
        radioButton2 = findViewById(R.id.radioButton2);
        radioButton3 = findViewById(R.id.radioButton3);
        radioGroup = findViewById(R.id.radioGroup);

        radioButton1.setOnCheckedChangeListener(
                (buttonView, isChecked) -> Toast.makeText(
                        this,
                        "radioButton1 is checked.",
                        Toast.LENGTH_SHORT)
                        .show());

    }
}
