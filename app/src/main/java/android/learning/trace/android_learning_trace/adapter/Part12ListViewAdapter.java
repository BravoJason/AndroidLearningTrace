package android.learning.trace.android_learning_trace.adapter;

import android.content.Context;
import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.model.LocalNews;
import android.learning.trace.android_learning_trace.view.viewholder.Part12ListViewViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class Part12ListViewAdapter extends BaseAdapter {

    private LocalNews localNews;
    private Context context;

    public Part12ListViewAdapter(Context context, LocalNews localNews) {
        this.context = context;
        this.localNews = localNews;

    }

    @Override
    public int getCount() {
        return localNews.getNewsVector().size();
    }

    @Override
    public Object getItem(int position) {
        return localNews.getNewsVector().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Part12ListViewViewHolder vh;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.layout_list_item_p12, null);
            vh = new Part12ListViewViewHolder(
                    convertView.findViewById(R.id.tv_p12_lv_title),
                    convertView.findViewById(R.id.tv_p12_lv_content));
            convertView.setTag(vh);
        } else {
            vh = (Part12ListViewViewHolder) convertView.getTag();
        }

        vh.getTvTitle().setText(localNews.getNewsVector().get(position).getTitle());
        vh.getTvContent().setText(localNews.getNewsVector().get(position).getContent());

        return convertView;
    }
}
