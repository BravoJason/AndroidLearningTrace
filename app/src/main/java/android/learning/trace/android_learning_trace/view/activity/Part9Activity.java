package android.learning.trace.android_learning_trace.view.activity;

import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Part9Activity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part9);
        initListView();
    }

    private void initListView() {
        listView = findViewById(R.id.lv_p9);

        //Single choice
        //Method 1:
        ArrayAdapter arrayAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.name,
                        android.R.layout.simple_list_item_single_choice);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(arrayAdapter);

        /*
        //Method 2:
        String[] arr = getResources().getStringArray(R.array.name);
        ArrayAdapter<String> arrayAdapter1 =
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_multiple_choice, arr);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        listView.setAdapter(arrayAdapter1);
        */


    }
}
