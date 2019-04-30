
package android.learning.trace.android_learning_trace.view.activity;

import android.content.Intent;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Logger.addLogAdapter(new AndroidLogAdapter());

        init();


    }


    /**
     * Function to initialize the UI member values.
     */
    private void init() {
        //Init button views.
        Button btnShowBasicUIP1Activity = findViewById(R.id.btn_basicUI_show_p1);
        Button btnShowBasicUIP2Activity = findViewById(R.id.btn_basicUI_show_p2);
        Button btnShowBasicUIP3Activity = findViewById(R.id.btn_basicUI_show_p3);
        Button btnShowBasicUIP4Activity = findViewById(R.id.btn_basicUI_show_p4);
        Button btnShowPart5 = findViewById(R.id.btn_main_showPart5);
        Button btnShowPart6 = findViewById(R.id.btn_main_showPart6);
        Button btnShowPart7 = findViewById(R.id.btn_main_showPart7);
        Button btnShowPart8 = findViewById(R.id.btn_main_showPart8);
        Button btnShowPart9 = findViewById(R.id.btn_main_showPart9);
        Button btnShowPart10 = findViewById(R.id.btn_main_showPart10);
        Button btnShowPart11 = findViewById(R.id.btn_main_showPart11);
        Button btnShowPart12 = findViewById(R.id.btn_main_showPart12);
        Button btnShowPart13 = findViewById(R.id.btn_main_showPart13);
        Button btnShowPart14 = findViewById(R.id.btn_main_showPart14);


        //Init Basic UI activity intent.
        Intent basicUIP1Intent = new Intent(getApplicationContext(), BasicUIComponentP1Activity.class);
        Intent basicUIP2Intent = new Intent(getApplicationContext(), BasicUIComponentP2Activity.class);
        Intent basicUIP3Intent = new Intent(this, BasicUIComponentP3Activity.class);
        Intent basicUIP4Intent = new Intent(this, BasicUIComponentP4Activity.class);
        Intent p5Intent = new Intent(this, Part5Activity.class);
        Intent p6Intent = new Intent(this, Part6Activity.class);
        Intent p7Intent = new Intent(this, Part7Activity.class);
        Intent p8Intent = new Intent(this, Part8Activity.class);
        Intent p9Intent = new Intent(this, Part9Activity.class);
        Intent p10Intent = new Intent(this, Part10Activity.class);
        Intent p11Intent = new Intent(this, Part11Activity.class);
        Intent p12Intent = new Intent(this, Part12Activity.class);
        Intent p13Intent = new Intent(this, Part13Activity.class);
        Intent p14Intent = new Intent(this, Part14Activity.class);


        //Set button onClick callback listener.
        btnShowBasicUIP1Activity.setOnClickListener(v -> startActivity(basicUIP1Intent));
        btnShowBasicUIP2Activity.setOnClickListener(v -> startActivity(basicUIP2Intent));
        btnShowBasicUIP3Activity.setOnClickListener(v -> startActivity(basicUIP3Intent));
        btnShowBasicUIP4Activity.setOnClickListener(v -> startActivity(basicUIP4Intent));
        btnShowPart5.setOnClickListener(v -> startActivity(p5Intent));
        btnShowPart6.setOnClickListener(v -> startActivity(p6Intent));
        btnShowPart7.setOnClickListener(v -> startActivity(p7Intent));
        btnShowPart8.setOnClickListener(v -> startActivity(p8Intent));
        btnShowPart9.setOnClickListener(v -> startActivity(p9Intent));
        btnShowPart10.setOnClickListener(v -> startActivity(p10Intent));
        btnShowPart11.setOnClickListener(v -> startActivity(p11Intent));
        btnShowPart12.setOnClickListener(v -> startActivity(p12Intent));
        btnShowPart13.setOnClickListener(v -> startActivity(p13Intent));
        btnShowPart14.setOnClickListener(v -> startActivity(p14Intent));

    }
}
