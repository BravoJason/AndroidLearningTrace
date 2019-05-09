package android.learning.trace.android_learning_trace.view.activity.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class Part27SystemBroadCastReceiver_Battery_Change extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        int current = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        int total = intent.getIntExtra(BatteryManager.EXTRA_SCALE, 1);
        int percentage = current * 100 / total;
        Toast.makeText(context, "Current battery level: " + percentage, Toast.LENGTH_SHORT).show();

    }
}
