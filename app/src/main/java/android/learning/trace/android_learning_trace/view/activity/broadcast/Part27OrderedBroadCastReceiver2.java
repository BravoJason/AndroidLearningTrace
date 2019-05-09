package android.learning.trace.android_learning_trace.view.activity.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Part27OrderedBroadCastReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "Ordered broadcast test. Coming from Part27OrderedBroadCastReceiver2.", Toast.LENGTH_SHORT).show();
//        //Stop the broadcast.
//        this.abortBroadcast();

        //Pass data to next receiver.
        Bundle bundle = new Bundle();
        bundle.putString("Info", "This is a message coming from Part27OrderedBroadCastReceiver2");
        this.setResultExtras(bundle);
    }
}
