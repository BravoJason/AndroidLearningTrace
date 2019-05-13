package android.learning.trace.android_learning_trace.view.activity.handler;

import android.app.Activity;
import android.content.Intent;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.lang.ref.WeakReference;

/**
 * Splash page view:
 * Function:
 * 1.Welcome page.
 * 2. Initialization work.
 */

public class Part30SplashActivity extends Activity {

    private static final int MSG_START_MAIN_ACTIVITY = 0x100;
    private SplashPageHandler splashPageHandler = new SplashPageHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part30_splash);
        splashPageHandler.sendEmptyMessageDelayed(MSG_START_MAIN_ACTIVITY, 3000);
    }

    void ShowMainActivity() {
        Intent mainIntent = new Intent(this, Part30HandlerActivity.class);
        startActivity(mainIntent);

    }

    private static class SplashPageHandler extends Handler {
        private WeakReference<Part30SplashActivity> weakReference;

        SplashPageHandler(Part30SplashActivity activity) {
            weakReference = new WeakReference<>(activity);
        }

        /**
         * Subclasses must implement this to receive messages.
         *
         * @param msg
         */
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Part30SplashActivity activity = weakReference.get();

            if (activity != null) {
                if (msg.what == MSG_START_MAIN_ACTIVITY) {
                    activity.ShowMainActivity();
                }
            }
        }
    }
}
