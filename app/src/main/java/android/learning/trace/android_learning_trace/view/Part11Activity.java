package android.learning.trace.android_learning_trace.view;

import android.content.Context;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class Part11Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part11);
        initListView();
    }

    void initListView() {
        ListView listView = findViewById(R.id.lv_p11);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this);
        listView.setAdapter(listViewAdapter);
    }

    static class ListViewAdapter extends BaseAdapter {

        Context context;
        private String[] titles = {
                "title-1", "title-2", "title-3",
                "title-1", "title-2", "title-3",
                "title-1", "title-2", "title-3",
                "title-1", "title-2", "title-3",
                "title-1", "title-2", "title-3"};
        private int[] icons = {
                R.mipmap.ic_launcher, R.mipmap.ic_android_robot, R.mipmap.ic_launcher_round,
                R.mipmap.ic_launcher, R.mipmap.ic_android_robot, R.mipmap.ic_launcher_round,
                R.mipmap.ic_launcher, R.mipmap.ic_android_robot, R.mipmap.ic_launcher_round,
                R.mipmap.ic_launcher, R.mipmap.ic_android_robot, R.mipmap.ic_launcher_round,
                R.mipmap.ic_launcher, R.mipmap.ic_android_robot, R.mipmap.ic_launcher_round};

        ListViewAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder vh;

            //Using the recyclable convertView to optimize the memory occupation.
            if (convertView == null) {
                //It is the first time.
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(R.layout.layout_list_item_p10, null);
                vh = new ViewHolder();
                vh.iv_icon = convertView.findViewById(R.id.iv_p10_lv);
                vh.tv_title = convertView.findViewById(R.id.tv_p10_lv);

                //Save viewholder object.
                convertView.setTag(vh);
            } else {
                //Get view holder.
                //It is the second time.
                vh = (ViewHolder) convertView.getTag();
            }

            //TextView textView = convertView.findViewById(R.id.tv_p10_lv);
            //ImageView imageView = convertView.findViewById(R.id.iv_p10_lv);
            vh.tv_title.setText(titles[position]);
            vh.iv_icon.setImageResource(icons[position]);
            return convertView;
        }

        //Store the UI component to avoid searching in next time.
        static class ViewHolder {
            ImageView iv_icon;
            TextView tv_title;
        }
    }
}
