package android.learning.trace.android_learning_trace.view.activity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.model.entity.Friend;
import android.learning.trace.android_learning_trace.model.entity.News;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.orhanobut.logger.Logger;


/**
 * Activity to show received data.
 */

public class Part24ActivityConceptActivity extends Activity {

    private static final int REQUESTCODE_1 = 0x1;
    Button btnTransferDataBundle, btnTransferDataIntent, btnTransferObjectSerializable,
            btnTransferObjectParcelable, btnActivityResultTest;
    EditText etDataView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /**
         * Load the layout
         * Register UI widget.
         * Register listener.
         */
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part24_activity_concept);
        init();


    }


    private void init() {
        //Find views.
        btnTransferDataBundle = findViewById(R.id.btn_p24_transferdata_bundle);
        btnTransferDataIntent = findViewById(R.id.btn_p24_transferdata_intent);
        btnTransferObjectSerializable = findViewById(R.id.btn_p24_transferObject_serializable);
        btnTransferObjectParcelable = findViewById(R.id.btn_p24_transferObject_parcelable);
        btnActivityResultTest = findViewById(R.id.btn_p24_activity_result);
        etDataView = findViewById(R.id.et_p24_data);


        //Create a activity intent.
        intent = new Intent(this, Part24TransferDataActivity.class);

        //Register OnClickListener to each button.
        btnTransferDataBundle.setOnClickListener(v -> {
            //Get input data.
            String data = getTextFromEditTextView(etDataView);
            data = "Set data from bundle: " + data;
            //Set bundle.
            Bundle bundle = new Bundle();
            bundle.putString("data", data);
            intent.removeExtra("data");
            intent.putExtra("dataBundle", bundle);
            startActivity(intent);

        });

        btnTransferDataIntent.setOnClickListener(v -> {
            String data = getTextFromEditTextView(etDataView);

            data = "Set data from Intent: " + data;

            intent.removeExtra("dataBundle");
            intent.putExtra("data", data);

            startActivity(intent);

        });

        btnTransferObjectSerializable.setOnClickListener(v -> {

            News news = new News("Serializable", "Serializable object");
            intent.removeExtra("parcelable");
            intent.putExtra("serializable", news);
            startActivity(intent);


        });

        btnTransferObjectParcelable.setOnClickListener(v -> {
            Friend friend = new Friend("Parcelable object");
            intent.removeExtra("serializable");
            intent.putExtra("parcelable", friend);
            startActivity(intent);
        });

        btnActivityResultTest.setOnClickListener(v -> {

            //Create an intent.
            Intent intent = new Intent(this, Part24ResultActivity.class);
            //Start activity.
            startActivityForResult(intent, REQUESTCODE_1);

        });
    }


    //Override the callback listener for receiving result..
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUESTCODE_1 && resultCode == RESULT_OK) {
            Toast.makeText(this, data.getStringExtra("result"), Toast.LENGTH_SHORT).show();
        }

    }

    private String getTextFromEditTextView(@Nullable EditText etv) {
        String data = etv.getText().toString();

        if (data.isEmpty()) {
            data = "No data";
        }

        return data;

    }


    /**
     * Called after {@link #onCreate} &mdash; or after {@link #onRestart} when
     * the activity had been stopped, but is now again being displayed to the
     * user.  It will be followed by {@link #onResume}.
     * <p>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onCreate
     * @see #onStop
     * @see #onResume
     */
    @Override
    protected void onStart() {
        /**
         * After onCreate, call this function.
         * Use it to show the UI
         */
        Logger.i("OnStart");
        super.onStart();


    }

    /**
     * Called after {@link #onRestoreInstanceState}, {@link #onRestart}, or
     * {@link #onPause}, for your activity to start interacting with the user.
     * This is a good place to begin animations, open exclusive-access devices
     * (such as the camera), etc.
     * <p>
     * <p>Keep in mind that onResume is not the best indicator that your activity
     * is visible to the user; a system window such as the keyguard may be in
     * front.  Use {@link #onWindowFocusChanged} to know for certain that your
     * activity is visible to the user (for example, to resume a game).
     * <p>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onRestoreInstanceState
     * @see #onRestart
     * @see #onPostResume
     * @see #onPause
     */
    @Override
    protected void onResume() {
        /**
         * After onStart, call this function.
         * Use it to interactive with users.
         * Activity get into resume state.
         *
         * When a paused activity is return, the system will call this function again.
         */

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder
                .setTitle("Test")
                .setMessage("LifeCycle test.")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
        */
        Logger.i("onResume");
        super.onResume();

    }

    /**
     * Called as part of the activity lifecycle when an activity is going into
     * the background, but has not (yet) been killed.  The counterpart to
     * {@link #onResume}.
     * <p>
     * <p>When activity B is launched in front of activity A, this callback will
     * be invoked on A.  B will not be created until A's {@link #onPause} returns,
     * so be sure to not do anything lengthy here.
     * <p>
     * <p>This callback is mostly used for saving any persistent state the
     * activity is editing, to present a "edit in place" model to the user and
     * making sure nothing is lost if there are not enough resources to start
     * the new activity without first killing this one.  This is also a good
     * place to do things like stop animations and other things that consume a
     * noticeable amount of CPU in order to make the switch to the next activity
     * as fast as possible, or to close resources that are exclusive access
     * such as the camera.
     * <p>
     * <p>In situations where the system needs more memory it may kill paused
     * processes to reclaim resources.  Because of this, you should be sure
     * that all of your state is saved by the time you return from
     * this function.  In general {@link #onSaveInstanceState} is used to save
     * per-instance state in the activity and this method is used to store
     * global persistent data (in content providers, files, etc.)
     * <p>
     * <p>After receiving this call you will usually receive a following call
     * to {@link #onStop} (after the next activity has been resumed and
     * displayed), however in some cases there will be a direct call back to
     * {@link #onResume} without going through the stopped state.
     * <p>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onResume
     * @see #onSaveInstanceState
     * @see #onStop
     */
    @Override
    protected void onPause() {
        Logger.i("onPause");
        super.onPause();
    }

    /**
     * Called when you are no longer visible to the user.  You will next
     * receive either {@link #onRestart}, {@link #onDestroy}, or nothing,
     * depending on later user activity.
     * <p>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onRestart
     * @see #onResume
     * @see #onSaveInstanceState
     * @see #onDestroy
     */
    @Override
    protected void onStop() {
        Logger.i("onStop");
        super.onStop();
    }

    /**
     * Perform any final cleanup before an activity is destroyed.  This can
     * happen either because the activity is finishing (someone called
     * {@link #finish} on it, or because the system is temporarily destroying
     * this instance of the activity to save space.  You can distinguish
     * between these two scenarios with the {@link #isFinishing} method.
     * <p>
     * <p><em>Note: do not count on this method being called as a place for
     * saving data! For example, if an activity is editing data in a content
     * provider, those edits should be committed in either {@link #onPause} or
     * {@link #onSaveInstanceState}, not here.</em> This method is usually implemented to
     * free resources like threads that are associated with an activity, so
     * that a destroyed activity does not leave such things around while the
     * rest of its application is still running.  There are situations where
     * the system will simply kill the activity's hosting process without
     * calling this method (or any others) in it, so it should not be used to
     * do things that are intended to remain around after the process goes
     * away.
     * <p>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onPause
     * @see #onStop
     * @see #finish
     * @see #isFinishing
     */
    @Override
    protected void onDestroy() {
        Logger.i("onDestroy");
        super.onDestroy();
    }

    /**
     * Called after {@link #onStop} when the current activity is being
     * re-displayed to the user (the user has navigated back to it).  It will
     * be followed by {@link #onStart} and then {@link #onResume}.
     * <p>
     * <p>For activities that are using raw {@link Cursor} objects (instead of
     * creating them through
     * {@link #managedQuery(Uri, String[], String, String[], String)},
     * this is usually the place
     * where the cursor should be requeried (because you had deactivated it in
     * {@link #onStop}.
     * <p>
     * <p><em>Derived classes must call through to the super class's
     * implementation of this method.  If they do not, an exception will be
     * thrown.</em></p>
     *
     * @see #onStop
     * @see #onStart
     * @see #onResume
     */
    @Override
    protected void onRestart() {
        Logger.i("onRestart");
        super.onRestart();
    }


    public void orientationTest(View view) {

        Intent intent = new Intent(this, Part24OrientationActivity.class);
        startActivity(intent);

    }

    public void ChangeOrientationTest(View view) {

        Intent intent = new Intent(this, Part24ScreenChangeActivity.class);
        startActivity(intent);
    }


    public void SaveData(View view) {

        Intent intent = new Intent(this, Part24SaveDataActivity.class);
        startActivity(intent);
    }
}
