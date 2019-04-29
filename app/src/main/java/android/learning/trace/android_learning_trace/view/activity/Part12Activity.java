package android.learning.trace.android_learning_trace.view.activity;

import android.app.Activity;
import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.adapter.Part12ListViewAdapter;
import android.learning.trace.android_learning_trace.presenter.Part12Presenter;
import android.learning.trace.android_learning_trace.utility.constant.Part12HandlerMessage;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.lang.ref.WeakReference;

public class Part12Activity extends AppCompatActivity implements AbsListView.OnScrollListener {

    Part12Presenter part12Presenter;
    ListView listView;
    UpdateHandler updateHandler;
    private int visibleLastIndex;
    private Part12ListViewAdapter part12ListViewAdapter;

    public Part12ListViewAdapter getPart12ListViewAdapter() {
        return part12ListViewAdapter;
    }

    public void setPart12ListViewAdapter(Part12ListViewAdapter part12ListViewAdapter) {
        this.part12ListViewAdapter = part12ListViewAdapter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part12);
        initListView();
    }

    private void initListView() {
        listView = findViewById(R.id.lv_p12);
        View view = getLayoutInflater().inflate(R.layout.layout_loading_p12, null);
        listView.addFooterView(view);
        part12Presenter = new Part12Presenter(this);
        updateHandler = new UpdateHandler(this);
        part12Presenter.load();

        listView.setOnScrollListener(this);

    }

    public void showListView(Part12ListViewAdapter part12ListViewAdapter) {
        this.part12ListViewAdapter = part12ListViewAdapter;
        listView.setAdapter(part12ListViewAdapter);
    }


    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (
                scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE
                        &&
                        visibleLastIndex == part12ListViewAdapter.getCount()) {
            part12Presenter.loadMoreNews();

        }

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        visibleLastIndex = firstVisibleItem + visibleItemCount - 1;

    }

    public void updateListViewData() {
        updateHandler.sendEmptyMessage(Part12HandlerMessage.DATA_UPDATE);

    }

    static private class UpdateHandler extends Handler {
        private WeakReference<Activity> reference;

        UpdateHandler(Activity activity) {
            reference = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            Part12Activity part12Activity = (Part12Activity) reference.get();
            super.handleMessage(msg);
            if (part12Activity != null) {
                switch (msg.what) {
                    case Part12HandlerMessage.DATA_UPDATE:
                        part12Activity.getPart12ListViewAdapter().notifyDataSetChanged();
                        break;
                }
            }

        }
    }


}
