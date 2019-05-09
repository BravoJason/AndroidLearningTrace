package android.learning.trace.android_learning_trace.view.activity.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class Part27SMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            Object[] objs = (Object[]) bundle.get("pdus");
            if (objs != null) {
                SmsMessage[] smsMessages = new SmsMessage[objs.length];

                for (int i = 0; i < objs.length; i++) {
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) objs[i]);
                    String fromNumber = smsMessages[i].getDisplayOriginatingAddress();
                    String content = smsMessages[i].getDisplayMessageBody();
                    Toast.makeText(context, fromNumber + "----" + content, Toast.LENGTH_SHORT).show();
                }
            }
        }


    }
}
