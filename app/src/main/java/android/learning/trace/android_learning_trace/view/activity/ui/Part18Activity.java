package android.learning.trace.android_learning_trace.view.activity.ui;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * Popup window
 */

public class Part18Activity extends AppCompatActivity {

    private Button btnShowPopupWindow;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part18);
        init();
    }

    private void init() {
        btnShowPopupWindow = findViewById(R.id.btn_part18_show_window);

        btnShowPopupWindow.setOnClickListener((v -> {
            View view = getLayoutInflater().inflate(R.layout.layout_popwindow_part18, null);
            //Create a popup window.
            popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            //Set background.
            popupWindow.setBackgroundDrawable(getResources().getDrawable(android.R.drawable.btn_default, this.getTheme()));
            popupWindow.getBackground().setAlpha(100);

            //Set animation.
            popupWindow.setAnimationStyle(android.R.style.Animation_Translucent);

            //Set touch action.
            popupWindow.setOutsideTouchable(true);
            popupWindow.setTouchable(true);
            popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

            //Show popup window.
            popupWindow.showAtLocation(v, Gravity.BOTTOM, 0, 0);


        }));
    }
}
