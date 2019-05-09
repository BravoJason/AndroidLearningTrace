package android.learning.trace.android_learning_trace.view.activity.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class Part27OrderedBroadCastReceiver1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(
                context,
                "Ordered broadcast test message coming from Part27OrderedBroadCastReceiver1."
                        + "Bundle info: " + this.getResultExtras(false).getString("Info"),
                Toast.LENGTH_SHORT).show();

    }
}
