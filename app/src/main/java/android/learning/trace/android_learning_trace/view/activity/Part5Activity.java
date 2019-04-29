package android.learning.trace.android_learning_trace.view.activity;

import android.content.Context;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class Part5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part5);
        initGridView();
    }

    private void initGridView() {
        GridView gridView = findViewById(R.id.gdv_p5);
        gridView.setAdapter(new GridViewAdapter(this));


    }


    /**
     * Customized adapter
     * Create a adapter which extends to BaseAdapter.
     * Methods:
     * getCount: Get the total number of the items which you want to display.
     * getItem: Get each item.
     * getItemId: Item selected ID.
     * getView: Return the fill view for each grid.
     */
    static class GridViewAdapter extends BaseAdapter {

        private Context context;
        private int[] images = {
                R.mipmap.p1,
                R.mipmap.p2,
                R.mipmap.p3,
                R.mipmap.p4,
                R.mipmap.p5,
                R.mipmap.p6,
                R.mipmap.p7,
                R.mipmap.p8,
                R.mipmap.p9,
                R.mipmap.p10,
                R.mipmap.p11,
                R.mipmap.p12,
                R.mipmap.p13};


        GridViewAdapter(Context context) {
            super();
            this.context = context;
        }

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return images[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView iv = new ImageView(context);
            iv.setImageResource(images[position]);
            return iv;
        }
    }
}
