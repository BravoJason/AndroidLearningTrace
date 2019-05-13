package android.learning.trace.android_learning_trace.view.activity.handler;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Handler mechanism.
 * 1. Message object use linked list to implement a message pool to avoid create lots of duplicated message objects.
 * 2. Handler use itself to save the message object into message queue.
 * Handler also use handlerMessage function to deal with the message.
 * 3. MessageQueue is used to save the message objects. First in first out.
 * 4. Looper is used to check the MessageQueue and grab the message object from MessageQueue and put the object into handlerMessage function.
 * <p>
 * Handler memory leak:
 * 1. When define a inner class, the inner class will hold the outer class reference.So, it better define a static inner class.
 * 2. Reference strength: strong reference > soft reference > weak reference > phantom reference
 */

public class Part30HandlerActivity extends AppCompatActivity {

    private final static int MSG_FINISH_DOWNLOAD = 0x100;
    private TextView tvDownloadState;
    //Use weak reference to avoid handler memory leak.
    private MyHandler myHandler = new MyHandler(this);
    private DownloadHandler downloadHandler = new DownloadHandler(this);


    //Memory leak.
//    private static Handler mHandler = new Handler(){
//
//
//        @Override
//        public void handleMessage(Message msg) {
//
//        }
//    };

    public TextView getTvDownloadState() {
        return tvDownloadState;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part30_handler);
        tvDownloadState = findViewById(R.id.tv_part30_downlaod_text);
        //Memory leak.
//        mHandler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//            }
//        }, 1000*60*10);


    }

    public void DownloadTextClick(View view) {

        //Mock download.
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }

                //Send a empty message marked as MSG_FINISH_DOWNLOAD.
                //handler.sendEmptyMessage(MSG_FINISH_DOWNLOAD);

                /**
                 * Message use a linked list to save a message pool.
                 * The default size is 50.
                 */

                //Get a message object.
                Message msg = downloadHandler.obtainMessage();
                msg.what = MSG_FINISH_DOWNLOAD;
                msg.obj = "Finish download.";
                downloadHandler.sendMessage(msg);

                //Send message with a latency time.
                Message msg1 = downloadHandler.obtainMessage();
                msg1.what = MSG_FINISH_DOWNLOAD;
                msg1.obj = "Finish download after 1 second.";
                downloadHandler.sendMessageAtTime(msg1, SystemClock.uptimeMillis() + 1000);

                Message msg2 = downloadHandler.obtainMessage();
                msg2.what = MSG_FINISH_DOWNLOAD;
                msg2.obj = "Finish download after 3 second.";
                downloadHandler.sendMessageDelayed(msg2, 3000);

            }
        }).start();
    }

    private static class MyHandler extends Handler {
        WeakReference<Part30HandlerActivity> weakReference;

        public MyHandler(Part30HandlerActivity activity) {
            weakReference = new WeakReference<Part30HandlerActivity>(activity);
        }

        /**
         * Subclasses must implement this to receive messages.
         *
         * @param msg
         */
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Part30HandlerActivity activity = weakReference.get();
            if (activity != null) {
                System.out.println("Activity is existing.");
            }
        }
    }

    // Memory leak.
//    private Handler handler = new Handler(){
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what){
//                case MSG_FINISH_DOWNLOAD:
//                    tvDownloadState.setText((String)msg.obj);
//                    break;
//            }
//        }
//    };

    private static class DownloadHandler extends Handler {
        WeakReference<Part30HandlerActivity> weakReference;

        public DownloadHandler(Part30HandlerActivity activity) {
            weakReference = new WeakReference<Part30HandlerActivity>(activity);
        }

        /**
         * Subclasses must implement this to receive messages.
         *
         * @param msg
         */
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Part30HandlerActivity activity = weakReference.get();

            if (activity != null) {
                switch (msg.what) {
                    case MSG_FINISH_DOWNLOAD:
                        activity.getTvDownloadState().setText((String) msg.obj);
                        break;
                }
            }
        }
    }
}
