
package android.learning.trace.android_learning_trace.view;

import android.content.Intent;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {


    private Button btnShowBasicUIActivity;
    private Intent basicUIIntent;


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
        //Init button view.
        btnShowBasicUIActivity = findViewById(R.id.btn_basicUI_show);

        //Init Basic UI activity intent.
        basicUIIntent = new Intent(getApplicationContext(), BasicUIComponentActivity.class);

        //Set button onClick callback listener.
        btnShowBasicUIActivity.setOnClickListener(v -> startActivity(basicUIIntent));

    }
}
