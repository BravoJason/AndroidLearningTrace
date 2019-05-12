package android.learning.trace.android_learning_trace.view.activity.actionBar;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.WindowManager;
import android.widget.TextView;

public class Part29PhoneListenerReceiver extends BroadcastReceiver {

    static WindowManager wm = null;

    @Override
    public void onReceive(Context context, Intent intent) {

        TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            System.out.println("Register telephone listener.");
            tm.listen(new MyPhoneStateListener(context), PhoneStateListener.LISTEN_CALL_STATE);
        }
    }

    private static class MyPhoneStateListener extends PhoneStateListener {
        Context context;
        TextView textView;

        MyPhoneStateListener(Context context) {
            this.context = context;
            System.out.println("MyPhoneStateListener -- Constructor");
        }


        /**
         * Callback invoked when device call state changes.
         *
         * @param state          call state
         * @param incomingNumber incoming call phone number. If application does not have
         *                       {@link Manifest.permission#READ_PHONE_STATE READ_PHONE_STATE} permission, an empty
         *                       string will be passed as an argument.
         * @see TelephonyManager#CALL_STATE_IDLE
         * @see TelephonyManager#CALL_STATE_RINGING
         * @see TelephonyManager#CALL_STATE_OFFHOOK
         */
        @Override
        public void onCallStateChanged(int state, String incomingNumber) {
            super.onCallStateChanged(state, incomingNumber);
            System.out.println(incomingNumber);
            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING:
                    wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                    WindowManager.LayoutParams params = new WindowManager.LayoutParams();
                    //Set overlay attribute.
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
                    } else {
                        params.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
                    }

                    //Set non-touch and non-focus.
                    params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;

                    params.width = WindowManager.LayoutParams.WRAP_CONTENT;
                    params.height = WindowManager.LayoutParams.WRAP_CONTENT;

                    textView = new TextView(context);
                    textView.setText("Current incoming number" + incomingNumber);
                    textView.setTextColor(Color.rgb(0xff, 0x00, 0x00));
                    wm.addView(textView, params);

                    System.out.println("Add incoming phone number view.");
                    break;
                case TelephonyManager.CALL_STATE_IDLE:
                    if (wm != null) {
                        wm.removeView(textView);
                        wm = null;
                    }
                    break;
            }
        }


    }
}
