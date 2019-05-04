package android.learning.trace.android_learning_trace.view.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Part24OrientationActivity extends Activity {

    TextView tvOrientation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Remove title.
        requestWindowFeature(Window.FEATURE_NO_TITLE);


        setContentView(R.layout.activity_part24_orientation);
        tvOrientation = findViewById(R.id.tv_p24_orientation);
    }

    public void switchOrientaion(View view) {
        int orientation = getRequestedOrientation();
        switch (orientation) {
            case ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                tvOrientation.setText("PORTRAIT");
                break;
            case ActivityInfo.SCREEN_ORIENTATION_BEHIND:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_FULL_USER:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_LOCKED:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_NOSENSOR:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_PORTRAIT:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                tvOrientation.setText("LANDSCAPE");
                break;
            case ActivityInfo.SCREEN_ORIENTATION_REVERSE_LANDSCAPE:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_REVERSE_PORTRAIT:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_SENSOR:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT:
                break;
            case ActivityInfo.SCREEN_ORIENTATION_USER:
                break;
        }
    }

    public void switchFullScreen(View view) {

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        tvOrientation.setText("Full screen");


    }
}
