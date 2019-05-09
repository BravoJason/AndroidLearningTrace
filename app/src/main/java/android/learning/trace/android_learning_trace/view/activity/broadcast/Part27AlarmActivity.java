package android.learning.trace.android_learning_trace.view.activity.broadcast;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.learning.trace.android_learning_trace.R;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class Part27AlarmActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part27_alarm);

    }

    @Override
    protected void onResume() {

        super.onResume();


        alarmDlg();

        wakeupScreen();


    }

    public void alarmDlg() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Alarm dialog test.");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).show();


    }


    public void wakeupScreen() {
        Window win = getWindow();
        win.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            setTurnScreenOn(true);
        } else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON | WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON);
        }

    }
}
