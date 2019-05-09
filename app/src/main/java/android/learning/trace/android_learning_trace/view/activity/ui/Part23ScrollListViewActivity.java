package android.learning.trace.android_learning_trace.view.activity.ui;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

//Solve the conflict between the ScrollView and ListView nest.

public class Part23ScrollListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part23_scroll_list_view);
    }
}
