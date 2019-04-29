package android.learning.trace.android_learning_trace.view.activity;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Part7Activity extends AppCompatActivity {


    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part7);
        initListView();
    }


    private void initListView() {
        listView = findViewById(R.id.lv_p7);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            //view is the TextView for the each item.
            Toast.makeText(this, ((TextView) view).getText(), Toast.LENGTH_SHORT).show();

        });
    }
}
