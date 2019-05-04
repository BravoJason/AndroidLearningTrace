package android.learning.trace.android_learning_trace.view.activity;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.orhanobut.logger.Logger;

public class Part25IntentTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part25_intent_test);

        Logger.i("Part25IntentTestActivity onCreate");
    }

}
