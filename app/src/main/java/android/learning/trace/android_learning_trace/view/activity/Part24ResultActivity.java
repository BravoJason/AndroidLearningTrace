package android.learning.trace.android_learning_trace.view.activity;

import android.content.Intent;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Part24ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part24_result);
    }

    public void returnResult(View v) {
        String result = String.valueOf(((EditText) findViewById(R.id.etv_p24_result)).getText());
        Intent intent = new Intent();
        intent.putExtra("result", result);
        //Set current result.
        setResult(RESULT_OK, intent);
        //Finish current activity.
        finish();

    }

}
