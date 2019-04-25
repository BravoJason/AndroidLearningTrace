
package android.learning.trace.android_learning_trace.view;

import android.content.Intent;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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


        //Init Basic UI activity intent.
        Intent basicUIP1Intent = new Intent(getApplicationContext(), BasicUIComponentP1Activity.class);
        Intent basicUIP2Intent = new Intent(getApplicationContext(), BasicUIComponentP2Activity.class);
        Intent basicUIP3Intent = new Intent(this, BasicUIComponentP3Activity.class);


        //Set button onClick callback listener.
        btnShowBasicUIP1Activity.setOnClickListener(v -> startActivity(basicUIP1Intent));
        btnShowBasicUIP2Activity.setOnClickListener(v -> startActivity(basicUIP2Intent));
        btnShowBasicUIP3Activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(basicUIP3Intent);
            }
        });

    }
}
