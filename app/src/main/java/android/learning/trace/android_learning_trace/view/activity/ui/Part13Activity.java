package android.learning.trace.android_learning_trace.view.activity.ui;

import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.adapter.Part13ExpandableListAdapter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

public class Part13Activity extends AppCompatActivity {

    ExpandableListView expandableListView;
    Part13ExpandableListAdapter part13ExpandableListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part13);
        initExpandableListView();

    }

    void initExpandableListView() {
        expandableListView = findViewById(R.id.elv_p13);
        part13ExpandableListAdapter = new Part13ExpandableListAdapter(this);
        expandableListView.setAdapter(part13ExpandableListAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                Toast.makeText(Part13Activity.this,
                        ((TextView) v.findViewById(R.id.tv_p13_child)).getText() + " is clicked.",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }
}
