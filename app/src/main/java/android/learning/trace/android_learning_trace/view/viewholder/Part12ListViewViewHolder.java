package android.learning.trace.android_learning_trace.view.viewholder;

import android.widget.TextView;

public class Part12ListViewViewHolder {

    private TextView tvTitle;
    private TextView tvContent;

    public Part12ListViewViewHolder(TextView tvTitle, TextView tvContent) {
        this.tvTitle = tvTitle;
        this.tvContent = tvContent;
    }


    public TextView getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(TextView tvTitle) {
        this.tvTitle = tvTitle;
    }

    public TextView getTvContent() {
        return tvContent;
    }

    public void setTvContent(TextView tvContent) {
        this.tvContent = tvContent;
    }
}
