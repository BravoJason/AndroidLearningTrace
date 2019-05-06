package android.learning.trace.android_learning_trace.service;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.widget.Toast;

/*
 *  IntentService:
 *      1. IntentService has a worker thread to finish a time consuming task.
 *      2. Put the logic in the onHandleIntent.
 *      3. When the IntentService finish the task, it will stop automatically.
 *      4. When the IntentService has multi tasks, the IntentService will put the tasks into a queue and linear execute them.
 */
public class Part26IntentService extends IntentService {

    public Part26IntentService() {
        super("Part26IntentService");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public Part26IntentService(String name) {
        super(name);
    }

    /**
     * This method is invoked on the worker thread with a request to process.
     * Only one Intent is processed at a time, but the processing happens on a
     * worker thread that runs independently from other application logic.
     * So, if this code takes a long time, it will hold up other requests to
     * the same IntentService, but it will not hold up anything else.
     * When all requests have been handled, the IntentService stops itself,
     * so you should not call {@link #stopSelf}.
     *
     * @param intent The value passed to {@link
     *               Context#startService(Intent)}.
     *               This may be null if the service is being restarted after
     *               its process has gone away; see
     *               {@link Service#onStartCommand}
     *               for details.
     */
    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        Toast.makeText(this, intent.getStringExtra("TestMessage"), Toast.LENGTH_SHORT).show();

        for (int i = 0; i < 50; i++) {
            System.out.println("onHandleIntent: " + i + ", current thread id: " + Thread.currentThread().getId());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
