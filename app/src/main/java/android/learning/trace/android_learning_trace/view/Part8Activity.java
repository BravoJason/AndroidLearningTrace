package android.learning.trace.android_learning_trace.view;

import android.app.ListActivity;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Part8Activity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter arrayAdapter =
                ArrayAdapter.createFromResource(
                        this,
                        R.array.name,
                        android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(this, ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
    }
}
