package android.learning.trace.android_learning_trace.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.widget.Toast;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * Service:
 * Service only can be created once.
 * Service can be stopped by calling stopService or stopSelf.
 * When a service start, it will call the onStartCommand to deal with the business.
 * In the default situation, the service will run in the main thread.
 * When there is a time consuming task, we need to create another thread to avoid blocking the main UI thread.
 */

public class Part26Service extends Service {
    public Part26Service() {
    }

    static int compuletesum() {

        int nResult = 0;

        for (int i = 0; i < 10; i++) {

            nResult += i;

            try {

                Thread.sleep(500);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return nResult;


    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Called by the system when the service is first created.  Do not call this method directly.
     */
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Part26Service onCreate.");
    }

    /**
     * Called by the system every time a client explicitly starts the service by calling
     * {@link Context#startService}, providing the arguments it supplied and a
     * unique integer token representing the start request.  Do not call this method directly.
     * <p>
     * <p>For backwards compatibility, the default implementation calls
     * {@link #onStart} and returns either {@link #START_STICKY}
     * or {@link #START_STICKY_COMPATIBILITY}.
     * <p>
     * <p>If you need your application to run on platform versions prior to API
     * level 5, you can use the following model to handle the older {@link #onStart}
     * callback in that case.  The <code>handleCommand</code> method is implemented by
     * you as appropriate:
     * <p>
     * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/ForegroundService.java
     * start_compatibility}
     * <p>
     * <p class="caution">Note that the system calls this on your
     * service's main thread.  A service's main thread is the same
     * thread where UI operations take place for Activities running in the
     * same process.  You should always avoid stalling the main
     * thread's event loop.  When doing long-running operations,
     * network calls, or heavy disk I/O, you should kick off a new
     * thread, or use {@link AsyncTask}.</p>
     *
     * @param intent  The Intent supplied to {@link Context#startService},
     *                as given.  This may be null if the service is being restarted after
     *                its process has gone away, and it had previously returned anything
     *                except {@link #START_STICKY_COMPATIBILITY}.
     * @param flags   Additional data about this start request.
     * @param startId A unique integer representing this specific request to
     *                start.  Use with {@link #stopSelfResult(int)}.
     * @return The return value indicates what semantics the system should
     * use for the service's current started state.  It may be one of the
     * constants associated with the {@link #START_CONTINUATION_MASK} bits.
     * @see #stopSelfResult(int)
     */
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Toast.makeText(this, intent.getStringExtra("TestMessage"), Toast.LENGTH_SHORT).show();

        System.out.println("Part26Service onStartCommand:"
                + ", with startID: " + startId
                + ", with threadName: " + Thread.currentThread().getName());


        //Use threadPool with FutureTask.
//        ExecutorService executor = Executors.newCachedThreadPool();
//        ServiceThread serviceThread = new ServiceThread();
//        for(int i = 0; i < 10; i++){
//            FutureTask<Integer> futureTask = new FutureTask<>(serviceThread);
//            executor.submit(futureTask);
//
//            /*
//            //Stop itself.
//            if(i == 30){
//                this.stopSelf();
//            }
//            */
//        }
//        executor.shutdown();


        //Use thread pool with CompletableFuture.
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {

            for (int i = 0; i < 10; i++) {
                CompletableFuture<Integer> future = CompletableFuture.supplyAsync(Part26Service::compuletesum);
                Future<Integer> f = future.whenComplete((value, e) -> {
                    System.out.println(value);
                    if (e != null) {
                        e.printStackTrace();
                    }
                });
            }

        }


        return super.onStartCommand(intent, flags, startId);
    }

    /**
     * Called by the system to notify a Service that it is no longer used and is being removed.  The
     * service should clean up any resources it holds (threads, registered
     * receivers, etc) at this point.  Upon return, there will be no more calls
     * in to this Service object and it is effectively dead.  Do not call this method directly.
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Part26Service onDestroy.");
    }

    private class ServiceThread implements Callable<Integer> {

        /**
         * Computes a result, or throws an exception if unable to do so.
         *
         * @return computed result
         * @throws Exception if unable to compute a result
         */
        @Override
        public Integer call() throws Exception {
            int nResult = 0;

            for (int i = 0; i < 100; i++) {
                nResult += i;
                Thread.sleep(1);
            }
            System.out.println(nResult);
            return nResult;
        }
    }
}
