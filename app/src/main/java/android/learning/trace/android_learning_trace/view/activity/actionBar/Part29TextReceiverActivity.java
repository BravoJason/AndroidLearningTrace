package android.learning.trace.android_learning_trace.view.activity.actionBar;

import android.content.Intent;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Part29TextReceiverActivity extends AppCompatActivity {

    TextView tvSharedText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part29_text_receiver);
        tvSharedText = findViewById(R.id.tv_p29_receivedText);
        handlerContent();
    }

    private void handlerContent() {
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();

        if (action.equals(Intent.ACTION_SEND)) {
            if ("text/plain".equals(type)) {
                tvSharedText.setText(intent.getStringExtra(Intent.EXTRA_TEXT));

            }
        }
    }
}
