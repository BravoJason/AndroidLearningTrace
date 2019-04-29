package android.learning.trace.android_learning_trace.view;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part10Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part10);
        initListView();
    }

    void initListView() {
        ListView listView = findViewById(R.id.lv_p10);

        Map<String, Object> title1 = new HashMap<>();
        title1.put("title", "title1");
        title1.put("icon", android.R.drawable.btn_star);
        Map<String, Object> title2 = new HashMap<>();
        title2.put("title", "title2");
        title2.put("icon", R.mipmap.ic_launcher);
        Map<String, Object> title3 = new HashMap<>();
        title3.put("title", "title3");
        title3.put("icon", R.drawable.ic_launcher_background);


        List<Map<String, Object>> list = new ArrayList<>();
        list.add(title1);
        list.add(title2);
        list.add(title3);

        SimpleAdapter simpleAdapter =
                new SimpleAdapter(
                        this,
                        list,
                        R.layout.layout_list_item_p10,
                        new String[]{"title", "icon"},
                        new int[]{R.id.tv_p10_lv, R.id.iv_p10_lv});

        listView.setAdapter(simpleAdapter);


        //SimpleAdapter<List<Map<String, String>>> simpleAdapter = new SimpleAdapter()

    }
}
