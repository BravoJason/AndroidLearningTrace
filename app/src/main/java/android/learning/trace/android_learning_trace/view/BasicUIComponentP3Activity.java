package android.learning.trace.android_learning_trace.view;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class BasicUIComponentP3Activity extends AppCompatActivity {

    Spinner spinner_city, spinner_province;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_uicomponent_p3);
        initSpinner();
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
}
