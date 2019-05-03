package android.learning.trace.android_learning_trace.model.entity;

import java.io.Serializable;

public class News implements Serializable {

    private String title;
    private String content;

    public News(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "title: " + title + " ,content: " + content;
    }
}
