package android.learning.trace.android_learning_trace.view.activity.actionBar;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.learning.trace.android_learning_trace.R;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.ShareActionProvider;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Part29ActionBarActivity extends AppCompatActivity {

    public static int OVERLAY_PERMISSION_REQ_CODE = 1;
    ShareActionProvider shareActionProvider;
    TextView tvPhoneState;
    TelephonyManager telephonyManager;
    MyPhoneStateListener myPhoneStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part29_action_bar);
        ActionBar actionBar = getSupportActionBar();


        if (actionBar != null) {
            //Set the navigation icon as enable.
            actionBar.setDisplayHomeAsUpEnabled(true);
            //Hide action bar.
            //actionBar.hide();
        }

        tvPhoneState = findViewById(R.id.tv_p29_phone_state);

        telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        myPhoneStateListener = new MyPhoneStateListener(tvPhoneState);
        applyOverLayWindowPermission();

        Intent phoneListenerIntent = new Intent(this, Part29PhoneListenerReceiver.class);
        sendBroadcast(phoneListenerIntent);


    }


    private void applyOverLayWindowPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.canDrawOverlays(this)) {
                Toast.makeText(this, "can not DrawOverlays", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + this.getPackageName()));
                startActivityForResult(intent, OVERLAY_PERMISSION_REQ_CODE);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == OVERLAY_PERMISSION_REQ_CODE) {
            if (!Settings.canDrawOverlays(this)) {
                // SYSTEM_ALERT_WINDOW permission not granted...
                Toast.makeText(this, "Permission Denieddd by user.Please Check it in Settings", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission Allowed", Toast.LENGTH_SHORT).show();
                // Already hold the SYSTEM_ALERT_WINDOW permission, do addview or something.
            }
        }
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
        //Register the phone listener.
        if (telephonyManager != null) {
            telephonyManager.listen(myPhoneStateListener, PhoneStateListener.LISTEN_CALL_STATE);
        }
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        //Unregister the phone listener.
        if (telephonyManager != null) {
            telephonyManager.listen(myPhoneStateListener, PhoneStateListener.LISTEN_NONE);
        }
        super.onPause();
    }

    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.
     * <p>
     * <p>This is only called once, the first time the options menu is
     * displayed.  To update the menu every time it is displayed, see
     * {@link #onPrepareOptionsMenu}.
     * <p>
     * <p>The default implementation populates the menu with standard system
     * menu items.  These are placed in the {@link Menu#CATEGORY_SYSTEM} group so that
     * they will be correctly ordered with application-defined menu items.
     * Deriving classes should always call through to the base implementation.
     * <p>
     * <p>You can safely hold on to <var>menu</var> (and any items created
     * from it), making modifications to it as desired, until the next
     * time onCreateOptionsMenu() is called.
     * <p>
     * <p>When you add items to the menu, you can implement the Activity's
     * {@link #onOptionsItemSelected} method to handle them there.
     *
     * @param menu The options menu in which you place your items.
     * @return You must return true for the menu to be displayed;
     * if you return false it will not be shown.
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_part29_actionbar, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(Part29ActionBarActivity.this, query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        MenuItem shareItem = menu.findItem(R.id.action_share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "This is a shared message from a ShareActionProvider.");

        shareActionProvider.setShareIntent(intent);


        return true;
    }

    private Intent getDefaultIntent() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        return intent;
    }

    //Share text message.
    public void ShareTextClick(View view) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, "Share text message test message.");
        //startActivity(intent);
        startActivity(Intent.createChooser(intent, "Intent chooser title"));

    }

    public void ShareImageClick(View view) {
        Uri uri = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.mipmap.ic_android_robot);

        System.out.println(uri);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(intent, "Share image."));
    }

    public void ShareMultipleImageClick(View view) {
        Uri uri1 = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.mipmap.ic_android_robot);
        Uri uri2 = Uri.parse("android.resource://" + getApplicationContext().getPackageName() + "/" + R.mipmap.ic_android_robot_blue);
        ArrayList<Uri> resourceList = new ArrayList<>();
        resourceList.add(uri1);
        resourceList.add(uri2);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND_MULTIPLE);
        intent.setType("image/*");
        intent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, resourceList);
        startActivity(Intent.createChooser(intent, "Share multiple images"));

    }

    private static class MyPhoneStateListener extends PhoneStateListener {
        private TextView tvPhoneState;

        MyPhoneStateListener(TextView tvPhoneState) {
            super();
            this.tvPhoneState = tvPhoneState;

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

            switch (state) {
                case TelephonyManager.CALL_STATE_IDLE:

                    tvPhoneState.setText("Phone state: " + "CALL_STATE_IDLE");
                    break;
                case TelephonyManager.CALL_STATE_RINGING:
                    tvPhoneState.setText("Phone state: " + "CALL_STATE_RINGING");
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK:
                    tvPhoneState.setText("Phone state: " + "CALL_STATE_OFFHOOK");
                    break;
            }

            super.onCallStateChanged(state, incomingNumber);
        }
    }
}
