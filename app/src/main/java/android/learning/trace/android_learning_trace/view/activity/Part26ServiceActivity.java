package android.learning.trace.android_learning_trace.view.activity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.service.IPart26AidlInterface;
import android.learning.trace.android_learning_trace.service.Part26BoundService;
import android.learning.trace.android_learning_trace.service.Part26IntentService;
import android.learning.trace.android_learning_trace.service.Part26MessengerService;
import android.learning.trace.android_learning_trace.service.Part26Service;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.telecom.Connection;
import android.view.View;
import android.widget.Toast;

/**
 * Service:
 * 1.Service only can be created once. Service can be stopped by calling stopService or stopSelf.
 * 2. When a service start, it will call the onStartCommand to deal with the business.
 * 3. In the default situation, the service will run in the main thread of the same process.
 * When there is a time consuming task, we need to create another thread to avoid blocking the main UI thread.
 * 4. When use startService function to start one service, it will run in the background.
 * <p>
 * IntentService:
 * 1. IntentService has a worker thread to finish a time consuming task.
 * 2. Put the logic in the onHandleIntent.
 * 3. When the IntentService finish the task, it will stop automatically.
 * 4. When the IntentService has multi tasks, the IntentService will put the tasks into a queue and linear execute them.
 * BoundService:
 * 1. Steps:
 * 1. Client user bindService() to bind a service object.
 * If bind successfully, it will callback the onServiceConnected() in serviceConnection interface.
 * 2. Use Service compound to expose the biz interface.
 * 3. Service side use create a *.aidl file to define an interface which can be called by the client side.
 * AIDL:
 * Can not have the access modifier.Like an interface syntax.
 * Support type: 8 basic data type. String, CharSequence, List<String>, Map, Customized type.
 *      Customized type:
 *          1. Implement the parcelable interface.
 *          2. Create an AIDL file to declare the type.
 *          3. Import it into other AIDL file and then use it.
 * 4. Server side need to provide an implement of the biz interface. Usually, extend the Stub class.
 * 5. Use onBind() in Service to return the bound biz object.
 * 6. If the client side binds successfully, the client side can call the functions like call the local functions as well.
 *
 * Start service will be existing in long time unless the user stop the service.
 * Bind service will be stop in the time when the user unbind the serivce.
 * Tips: Start the service and then bind service.
 */

public class Part26ServiceActivity extends AppCompatActivity {

    private IPart26AidlInterface part26AidlInterface;
    private Boolean mBound;
    private ServiceConnection conn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //When bind successfully, call this function.
            part26AidlInterface = IPart26AidlInterface.Stub.asInterface(service);
            System.out.println(part26AidlInterface);
            mBound = true;
            Toast.makeText(Part26ServiceActivity.this, "Bind successfully.", Toast.LENGTH_SHORT).show();


        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //When the service has exception, call this function.
            mBound = false;
            Toast.makeText(Part26ServiceActivity.this, "Bind failed.", Toast.LENGTH_SHORT).show();

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part26_service);
    }

    /**
     * Start the service
     *
     * @param view
     */
    public void StartService(View view) {

        Intent intent = new Intent(this, Part26Service.class);
        intent.putExtra("TestMessage", "Hello, this is a test message coming from the activity.");
        startService(intent);

    }

    /**
     * Stop the service
     *
     * @param view
     */
    public void StopService(View view) {
        Intent intent = new Intent(this, Part26Service.class);
        stopService(intent);
    }

    public void StartIntentService(View view) {
        Intent intent = new Intent(this, Part26IntentService.class);
        intent.putExtra("TestMessage", "This is the test message to an intent service.");
        startService(intent);
    }

    public void BindService(View view) {
        //Async bind the service.
        Intent intent = new Intent(this, Part26BoundService.class);

        bindService(intent, conn, Context.BIND_AUTO_CREATE);
    }

    public void UnbindService(View view) {
        if (mBound) {

            unbindService(conn);
            mBound = false;
            Toast.makeText(Part26ServiceActivity.this, "Unbind successfully.", Toast.LENGTH_SHORT).show();
        }

    }

    public void CallService(View view) throws RemoteException {
        if (part26AidlInterface != null) {
            part26AidlInterface.setName("Test Bound");
            Toast.makeText(this, part26AidlInterface.desc(), Toast.LENGTH_SHORT).show();
            Toast.makeText(this, part26AidlInterface.getServiceInfo().toString(), Toast.LENGTH_SHORT).show();
        }
    }

    Messenger messengerService;
    Boolean flag;

    public void BindMessengerService(View view) {

        Intent intent = new Intent(this, Part26MessengerService.class);
        bindService(intent, conn2, BIND_AUTO_CREATE);



    }

    private ServiceConnection conn2 = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            messengerService = new Messenger(service);
            flag = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            flag = false;
            messengerService = null;

        }
    };

    public void SendMessageToService(View view) {

        Message msg = Message.obtain();
        msg.what = Part26MessengerService.SAY_HELLO;
        msg.obj = "Message test info";
        try {
            messengerService.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
