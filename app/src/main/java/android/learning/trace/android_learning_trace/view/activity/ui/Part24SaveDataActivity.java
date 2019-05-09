package android.learning.trace.android_learning_trace.view.activity.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.learning.trace.android_learning_trace.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class Part24SaveDataActivity extends AppCompatActivity {

    private SharedPreferences sp;
    private EditText edvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part24_save_data);

        //Get current app SharedPreferences object.
        sp = getSharedPreferences("Part24SaveDataActivity", Context.MODE_PRIVATE);

        edvMessage = findViewById(R.id.etv_p24_message);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String msg = String.valueOf(edvMessage.getText());

        if (!TextUtils.isEmpty(msg)) {
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("message", msg);
            editor.apply();
        }


    }

    /**
     * Dispatch onResume() to fragments.  Note that for better inter-operation
     * with older versions of the platform, at the point of this call the
     * fragments attached to the activity are <em>not</em> resumed.  This means
     * that in some cases the previous state may still be saved, not allowing
     * fragment transactions that modify the state.  To correctly interact
     * with fragments in their proper state, you should instead override
     * {@link #onResumeFragments()}.
     */
    @Override
    protected void onResume() {
        super.onResume();
        edvMessage.setText(sp.getString("message", ""));
        sp.edit().remove("message").apply();

    }

    public void SaveMessage(View view) {
    }
}
