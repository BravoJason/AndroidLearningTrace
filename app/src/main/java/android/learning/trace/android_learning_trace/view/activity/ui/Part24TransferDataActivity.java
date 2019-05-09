package android.learning.trace.android_learning_trace.view.activity.ui;

import android.content.Intent;
import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.model.entity.Friend;
import android.learning.trace.android_learning_trace.model.entity.News;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class Part24TransferDataActivity extends AppCompatActivity {

    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part24_transfer_data);
        tvData = findViewById(R.id.tv_p24_inputData);

        //Get a different intent with the same data.
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("dataBundle");
        if (bundle != null) {
            tvData.setText(bundle.getString("data", "No data from bundle"));
        } else {
            tvData.setText(intent.getStringExtra("data"));
            News news = (News) intent.getSerializableExtra("serializable");
            if (news != null) {
                Toast.makeText(this, news.toString(), Toast.LENGTH_SHORT).show();
            }

            Friend friend = intent.getParcelableExtra("parcelable");

            if (friend != null) {
                Toast.makeText(this, friend.toString(), Toast.LENGTH_SHORT).show();
            }
        }


    }
}
