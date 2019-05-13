package android.learning.trace.android_learning_trace.view.activity.asynctask;

import android.learning.trace.android_learning_trace.R;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class Part31AsyncTaskActivity extends AppCompatActivity {


    private static final int MARK_SET_TOTAL_SIZE = 0x0;
    private static final int MARK_SET_CURRENT_SIZE = 0x1;
    private static final int MARK_FINISH = 0x2;
    private static final int MARK_BEGIN_DOWNLOADING = 0x3;
    private TextView tvAsyncTaskResult, tvDownloadStatus;
    private MyAsyncTask myAsyncTask;
    private ProgressBar progressbarDownload;
    private DownloadAsyncTask downloadAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part31_async_task_acitivity);
        tvAsyncTaskResult = findViewById(R.id.tv_part31_async_result);
        tvDownloadStatus = findViewById(R.id.tv_part31_download_status);
        myAsyncTask = new MyAsyncTask(this);
        downloadAsyncTask = new DownloadAsyncTask(this);
        progressbarDownload = findViewById(R.id.progressbar_part31_download);
    }

    public TextView getTvAsyncTaskResult() {
        return tvAsyncTaskResult;
    }

    public void StartAsyncClick(View view) {


        try {
            myAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

    }

    public void AsyncDownloadClick(View view) {
        try {

            downloadAsyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "https://www.google.ca/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png");
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onDestroy() {


        super.onDestroy();
    }

    @Override
    protected void onStop() {
        if (myAsyncTask != null) {
            myAsyncTask.cancel(true);
            myAsyncTask = null;
        }

        if (downloadAsyncTask != null) {
            downloadAsyncTask.cancel(true);
            downloadAsyncTask = null;
        }
        super.onStop();
    }

    private static class DownloadAsyncTask extends AsyncTask<String, Integer, Integer> {
        WeakReference<Part31AsyncTaskActivity> weakReference;

        DownloadAsyncTask(Part31AsyncTaskActivity activity) {
            weakReference = new WeakReference<>(activity);
        }

        /**
         * Runs on the UI thread before {@link #doInBackground}.
         *
         * @see #onPostExecute
         * @see #doInBackground
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Part31AsyncTaskActivity activity = weakReference.get();
            if (activity != null) {
                activity.progressbarDownload.setProgress(0);
            }
        }

        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param strings The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected Integer doInBackground(String... strings) {
            FileOutputStream out = null;
            InputStream in = null;
            try {
                URL url = new URL(strings[0]);
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                //Get the total size of the image.
                int size = conn.getContentLength();
                System.out.println(size);
                publishProgress(MARK_SET_TOTAL_SIZE, size);
                byte[] trunk = new byte[1];
                int len = -1;
                in = conn.getInputStream();
                out = new FileOutputStream("/sdcard/" + System.currentTimeMillis() + ".png");
                publishProgress(MARK_BEGIN_DOWNLOADING);
                while ((len = in.read(trunk)) != -1 && !isCancelled()) {
                    out.write(trunk, 0, len);
                    publishProgress(MARK_SET_CURRENT_SIZE, len);
                    out.flush();
                    //Thread.sleep(5);
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

            return MARK_FINISH;
        }

        /**
         * Runs on the UI thread after {@link #publishProgress} is invoked.
         * The specified values are the values passed to {@link #publishProgress}.
         *
         * @param values The values indicating progress.
         * @see #publishProgress
         * @see #doInBackground
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            Part31AsyncTaskActivity activity = weakReference.get();
            if (activity != null) {
                switch (values[0]) {
                    case MARK_SET_TOTAL_SIZE:
                        activity.progressbarDownload.setMax(values[1]);
                        break;
                    case MARK_SET_CURRENT_SIZE:
                        activity.progressbarDownload.incrementProgressBy(values[1]);
                        break;
                    case MARK_BEGIN_DOWNLOADING:
                        activity.tvDownloadStatus.setText("Downloading");
                        break;
                }
            }
        }

        /**
         * <p>Runs on the UI thread after {@link #doInBackground}. The
         * specified result is the value returned by {@link #doInBackground}.</p>
         *
         * <p>This method won't be invoked if the task was cancelled.</p>
         *
         * @param integer The result of the operation computed by {@link #doInBackground}.
         * @see #onPreExecute
         * @see #doInBackground
         * @see #onCancelled(Object)
         */
        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Part31AsyncTaskActivity activity = weakReference.get();
            if (activity != null) {
                if (integer == MARK_FINISH) {
                    activity.tvDownloadStatus.setText("Download finished.");
                } else {
                    activity.tvDownloadStatus.setText("Download error.");
                }

            }
        }
    }

    //AsyncTask<Parameter, Progress, Result>
    private static class MyAsyncTask extends AsyncTask<String, Integer, String> {
        WeakReference<Part31AsyncTaskActivity> weakReference;

        MyAsyncTask(Part31AsyncTaskActivity activity) {
            this.weakReference = new WeakReference<Part31AsyncTaskActivity>(activity);

        }

        /**
         * Runs on the UI thread before {@link #doInBackground}.
         *
         * @see #onPostExecute
         * @see #doInBackground
         */
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            System.out.println("onPreExecute");
        }

        /**
         * Override this method to perform a computation on a background thread. The
         * specified parameters are the parameters passed to {@link #execute}
         * by the caller of this task.
         * <p>
         * This method can call {@link #publishProgress} to publish updates
         * on the UI thread.
         *
         * @param strings The parameters of the task.
         * @return A result, defined by the subclass of this task.
         * @see #onPreExecute()
         * @see #onPostExecute
         * @see #publishProgress
         */
        @Override
        protected String doInBackground(String... strings) {

            for (int i = 0; i < 100; i++) {
                if (!isCancelled()) {
                    System.out.println(i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //Update progress.
                    publishProgress(i);
                } else {
                    break;
                }

            }

            return "Success";
        }

        /**
         * Runs on the UI thread after {@link #publishProgress} is invoked.
         * The specified values are the values passed to {@link #publishProgress}.
         *
         * @param values The values indicating progress.
         * @see #publishProgress
         * @see #doInBackground
         */
        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Part31AsyncTaskActivity activity = weakReference.get();
            if (activity != null) {
                activity.getTvAsyncTaskResult().setText("Current progress:" + values[0]);

            }
        }

        /**
         * <p>Runs on the UI thread after {@link #doInBackground}. The
         * specified result is the value returned by {@link #doInBackground}.</p>
         *
         * <p>This method won't be invoked if the task was cancelled.</p>
         *
         * @param s The result of the operation computed by {@link #doInBackground}.
         * @see #onPreExecute
         * @see #doInBackground
         * @see #onCancelled(Object)
         */
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Part31AsyncTaskActivity activity = weakReference.get();
            if (activity != null) {
                activity.getTvAsyncTaskResult().setText(s);
            }
        }
    }
}
