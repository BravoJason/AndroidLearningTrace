package android.learning.trace.android_learning_trace.view;

import android.content.Context;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Part6Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part6);
        initGridView();
    }

    private void initGridView() {

        GridView gridView = findViewById(R.id.gv_p6);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this);
        gridView.setAdapter(gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = view.findViewById(R.id.tv_p6_gv);
                Toast.makeText(Part6Activity.this, textView.getText(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    static class GridViewAdapter extends BaseAdapter {

        Context context;
        private String[] appNames = {"Facebook", "Google", "Youtube", "Being", "Microsoft"};
        private int[] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

        GridViewAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return appNames.length;
        }

        @Override
        public Object getItem(int position) {
            return appNames[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.layout_p6_gridview, null);
            ImageView imageView = view.findViewById(R.id.iv_p6_gv);
            TextView textView = view.findViewById(R.id.tv_p6_gv);
            imageView.setImageResource(images[position]);
            textView.setText(appNames[position]);
            return view;
        }
    }
}
