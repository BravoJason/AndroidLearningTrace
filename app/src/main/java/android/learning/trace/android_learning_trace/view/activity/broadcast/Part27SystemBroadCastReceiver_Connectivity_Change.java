package android.learning.trace.android_learning_trace.view.activity.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class Part27SystemBroadCastReceiver_Connectivity_Change extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo info = cm.getActiveNetworkInfo();

            if (info != null) {
                String name = info.getTypeName();
                Toast.makeText(context, "Current Network state:" + name, Toast.LENGTH_SHORT).show();
            }

        }


    }
}
