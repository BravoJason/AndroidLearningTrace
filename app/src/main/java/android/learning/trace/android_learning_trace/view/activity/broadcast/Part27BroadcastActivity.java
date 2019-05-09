package android.learning.trace.android_learning_trace.view.activity.broadcast;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Normal broadcast
 * <p>
 * Order broadcast
 * <p>
 * Sticky broadcast
 */

public class Part27BroadcastActivity extends AppCompatActivity {

    final static int MY_PERMISSION_SEND_SMS = 0x1024;
    final static int MY_PERMISSION_RECEIVE_SMS = 0x1025;

    Part27NormalBroadCastReceiver part27BroadCastReceiver;
    Part27OrderedBroadCastReceiver1 part27OrderedBroadCastReceiver1;
    Part27OrderedBroadCastReceiver2 part27OrderedBroadCastReceiver2;
    Part27SystemBroadCastReceiver_Connectivity_Change part27SystemBroadCastReceiver_connectivity_change;
    Part27SystemBroadCastReceiver_Battery_Change part27SystemBroadCastReceiver_battery_change;
    Part27SMSReceiver part27SMSReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part27_broadcast);


    }

    public void SendNormalBroadcast(View view) {
        Intent intent = new Intent("android.learning.trace.android_learning_trace.action.MY_BROADCAST");
        intent.putExtra("Info", "This is a broadcast test message.");
        this.sendBroadcast(intent);
    }

    @Override
    protected void onDestroy() {


        super.onDestroy();
    }

    public void RegisterNormalBroadcastReceiver(View view) {
        //For Android 8.0 and above, we can only use Context-register to register the broadcast receiver.
        IntentFilter intentFilter = new IntentFilter("android.learning.trace.android_learning_trace.action.MY_BROADCAST");
        part27BroadCastReceiver = new Part27NormalBroadCastReceiver();
        this.registerReceiver(part27BroadCastReceiver, intentFilter);
    }

    public void UnregisterNormalBroadcastReceiver(View view) {
        this.unregisterReceiver(part27BroadCastReceiver);
    }


    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter orderedBroadcastIntentFilter1 =
                new IntentFilter("android.learning.trace.action.MY_ORDERED_BROADCAST");
        orderedBroadcastIntentFilter1.setPriority(100);

        IntentFilter orderedBroadcastIntentFilter2 =
                new IntentFilter("android.learning.trace.action.MY_ORDERED_BROADCAST");
        orderedBroadcastIntentFilter2.setPriority(200);
        part27OrderedBroadCastReceiver1 = new Part27OrderedBroadCastReceiver1();
        part27OrderedBroadCastReceiver2 = new Part27OrderedBroadCastReceiver2();

        this.registerReceiver(part27OrderedBroadCastReceiver1, orderedBroadcastIntentFilter1);
        this.registerReceiver(part27OrderedBroadCastReceiver2, orderedBroadcastIntentFilter2);

        part27SystemBroadCastReceiver_connectivity_change = new Part27SystemBroadCastReceiver_Connectivity_Change();

        IntentFilter connectivityChangeIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        connectivityChangeIntentFilter.addCategory("android.intent.category.DEFAULT");
        this.registerReceiver(part27SystemBroadCastReceiver_connectivity_change, connectivityChangeIntentFilter);

        part27SystemBroadCastReceiver_battery_change = new Part27SystemBroadCastReceiver_Battery_Change();
        IntentFilter batteryChangeIntentFilter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        batteryChangeIntentFilter.addCategory("android.intent.category.DEFAULT");
        this.registerReceiver(part27SystemBroadCastReceiver_battery_change, batteryChangeIntentFilter);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.RECEIVE_SMS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.RECEIVE_SMS},
                        MY_PERMISSION_RECEIVE_SMS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            part27SMSReceiver = new Part27SMSReceiver();
            IntentFilter smsReceiverIntentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
            smsReceiverIntentFilter.addCategory(Intent.CATEGORY_DEFAULT);
            smsReceiverIntentFilter.setPriority(Integer.MAX_VALUE);
            this.registerReceiver(part27SMSReceiver, smsReceiverIntentFilter);
        }


    }

    public void SendOrderedBroadcast(View view) {

        Intent intent = new Intent("android.learning.trace.action.MY_ORDERED_BROADCAST");

        //Parameter: Intent, the permission for the receiver.
        this.sendOrderedBroadcast(intent, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.unregisterReceiver(part27OrderedBroadCastReceiver1);
        this.unregisterReceiver(part27OrderedBroadCastReceiver2);
        this.unregisterReceiver(part27SystemBroadCastReceiver_connectivity_change);
        this.unregisterReceiver(part27SystemBroadCastReceiver_battery_change);
        if (part27SMSReceiver != null) {
            this.unregisterReceiver(part27SMSReceiver);
            part27SMSReceiver = null;
        }
    }

    public void SendTextMessage(View view) {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.SEND_SMS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSION_SEND_SMS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            sendSMS();
        }


    }

    private void sendSMS() {
        EditText editTextPhone = findViewById(R.id.etv_p27_phone);
        EditText editTextMessage = findViewById(R.id.etv_p27_text);

        SmsManager smsManager = SmsManager.getDefault();

        String number = editTextPhone.getText().toString();
        String message = editTextMessage.getText().toString();

        ArrayList<String> list = smsManager.divideMessage(message);
        for (String str : list) {
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
            smsManager.sendTextMessage(number, null, str, null, null);
        }
    }

    /**
     * Callback for the result from requesting permissions. This method
     * is invoked for every call on {@link #requestPermissions(String[], int)}.
     * <p>
     * <strong>Note:</strong> It is possible that the permissions request interaction
     * with the user is interrupted. In this case you will receive empty permissions
     * and results arrays which should be treated as a cancellation.
     * </p>
     *
     * @param requestCode  The request code passed in {@link #requestPermissions(String[], int)}.
     * @param permissions  The requested permissions. Never null.
     * @param grantResults The grant results for the corresponding permissions
     *                     which is either {@link PackageManager#PERMISSION_GRANTED}
     *                     or {@link PackageManager#PERMISSION_DENIED}. Never null.
     * @see #requestPermissions(String[], int)
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_SEND_SMS:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Permission is grant.
                    sendSMS();
                } else {
                    //Permission is denied.
                }
                break;
            case MY_PERMISSION_RECEIVE_SMS:
                part27SMSReceiver = new Part27SMSReceiver();
                IntentFilter smsReceiverIntentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
                smsReceiverIntentFilter.setPriority(Integer.MAX_VALUE);
                this.registerReceiver(part27SMSReceiver, smsReceiverIntentFilter);
                break;
        }

    }

    public void SetAlarm(View view) {
        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(this, Part27AlarmReceiver.class);
        long triggerTime = System.currentTimeMillis() + 2000;
        PendingIntent op = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (am != null) {
            //Set once.
            //am.set(AlarmManager.RTC, triggerTime, op);

            //Set repeat.
            am.setRepeating(AlarmManager.RTC, triggerTime, 300, op);
        }
    }

    public void SetDialogAlarm(View view) {

        AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        long triggerTime = System.currentTimeMillis() + 2000;

        //Intent intent = new Intent(this, );
        Intent intent = new Intent(this, Part27AlarmActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        am.set(AlarmManager.RTC, triggerTime, pendingIntent);
    }
}
