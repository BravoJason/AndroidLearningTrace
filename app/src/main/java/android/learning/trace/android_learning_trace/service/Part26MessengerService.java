package android.learning.trace.android_learning_trace.service;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.widget.Toast;

import java.lang.ref.WeakReference;

public class Part26MessengerService extends Service {



    public Part26MessengerService(){
    }

    public static final int SAY_HELLO = 0x1;

    private Handler handler = new ServiceHandler(this);

    static private class ServiceHandler extends Handler{
        private WeakReference<Service> reference;
        ServiceHandler(Service service){
            reference = new WeakReference<>(service);
        }

        @Override
        public void handleMessage(Message msg) {
            Service service = reference.get();
            if(service != null){
                switch (msg.what){
                    case SAY_HELLO:
                        String info = (String) msg.obj;
                        Toast.makeText(service, info, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }
    }


    private Messenger messenger = new Messenger(handler);
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }




}
