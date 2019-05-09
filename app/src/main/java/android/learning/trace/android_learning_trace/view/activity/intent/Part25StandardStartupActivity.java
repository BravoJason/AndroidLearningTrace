package android.learning.trace.android_learning_trace.view.activity.intent;

import android.content.Intent;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Part25StandardStartupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part25_standard_startup);
    }

    public void StartActivityStandMode(View view) {
        Intent intent = new Intent(this, Part25StandardStartupActivity.class);
        startActivity(intent);
    }

    public void StartPart25IntentActivity(View view) {

        Intent intent = new Intent(this, Part25IntentActivity.class);
        startActivity(intent);
    }
}
