package android.learning.trace.android_learning_trace.view.activity.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Part27NormalBroadCastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        System.out.println("Part27NormalBroadCastReceiver onReceive");
        Toast.makeText(context, intent.getStringExtra("Info"), Toast.LENGTH_SHORT).show();

    }
}
