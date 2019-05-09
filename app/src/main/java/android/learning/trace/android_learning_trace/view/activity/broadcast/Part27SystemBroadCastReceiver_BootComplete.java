package android.learning.trace.android_learning_trace.view.activity.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Part27SystemBroadCastReceiver_BootComplete extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "Got system broadcast.", Toast.LENGTH_SHORT).show();
        System.out.println("Got system broadcast.");
    }
}
