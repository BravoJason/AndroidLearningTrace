package android.learning.trace.android_learning_trace.presenter;

import android.learning.trace.android_learning_trace.adapter.Part12ListViewAdapter;
import android.learning.trace.android_learning_trace.model.LocalNews;
import android.learning.trace.android_learning_trace.view.activity.ui.Part12Activity;

public class Part12Presenter {

    private Part12Activity part12Activity;
    private LocalNews localNews;
    private Part12ListViewAdapter part12ListViewAdapter;


    public Part12Presenter(Part12Activity part12Activity) {
        this.part12Activity = part12Activity;
        localNews = new LocalNews() {
            @Override
            public void onLoadComplete() {
                part12Activity.updateListViewData();

            }
        };
        localNews.mockGenerateLocalNews(20);
        part12ListViewAdapter = new Part12ListViewAdapter(part12Activity, localNews);
    }

    public void load() {
        part12Activity.showListView(part12ListViewAdapter);
    }

    public void loadMoreNews() {
        localNews.loadMoreNews();
    }


}
