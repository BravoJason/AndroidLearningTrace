package android.learning.trace.android_learning_trace.module;

import android.learning.trace.android_learning_trace.module.entity.News;

import java.util.Vector;

public abstract class LocalNews {
    private Vector<News> newsVector;

    protected LocalNews() {
        newsVector = new Vector<>();
    }

    public void mockGenerateLocalNews(int maxIndex) {
        for (int i = 1; i <= maxIndex; i++) {
            News aNews = new News("title--" + i, "content--" + i);
            newsVector.add(aNews);
        }
    }

    public Vector<News> getNewsVector() {
        return newsVector;
    }

    public void setNewsVector(Vector<News> newsVector) {
        this.newsVector = newsVector;
    }

    public abstract void onLoadComplete();

    public void loadMoreNews() {
        new MockUpdateLocalNews().start();

    }


    class MockUpdateLocalNews extends Thread {
        @Override
        public void run() {
            super.run();
            mockGenerateLocalNews(10);
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            onLoadComplete();


        }
    }
}
