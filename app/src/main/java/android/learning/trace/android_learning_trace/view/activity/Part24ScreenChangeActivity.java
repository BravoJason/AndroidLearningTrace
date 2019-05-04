package android.learning.trace.android_learning_trace.view.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.orhanobut.logger.Logger;

/**
 * When the screen change the orientation, it will re-create the Activity.
 * We need to save the previous variable states and recover them after creating the Activity.
 */
public class Part24ScreenChangeActivity extends Activity {

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part24_screen_change);
        if (savedInstanceState != null) {
            count = savedInstanceState.getInt("count", 0);
        }
        Logger.i("onCreate");
    }

    public void IncreaseCounter(View view) {
        count++;
        Toast.makeText(getApplicationContext(), String.valueOf(count), Toast.LENGTH_SHORT).show();
    }

    //Save the data before killed.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Logger.i("onSaveInstanceState");
        outState.putInt("count", count);
    }

    /**
     * Called by the system when the device configuration changes while your
     * activity is running.  Note that this will <em>only</em> be called if
     * you have selected configurations you would like to handle with the
     * {@link android.R.attr#configChanges} attribute in your manifest.  If
     * any configuration change occurs that is not selected to be reported
     * by that attribute, then instead of reporting it the system will stop
     * and restart the activity (to have it launched with the new
     * configuration).
     * <p>
     * <p>At the time that this function has been called, your Resources
     * object will have been updated to return resource values matching the
     * new configuration.
     *
     * @param newConfig The new device configuration.
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Logger.i("onConfigurationChanged");
    }
}
