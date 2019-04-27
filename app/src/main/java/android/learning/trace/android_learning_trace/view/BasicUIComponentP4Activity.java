package android.learning.trace.android_learning_trace.view;


import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.presenter.ITimeSetter;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class BasicUIComponentP4Activity extends AppCompatActivity implements ITimeSetter {

    TextView tv_Time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_uicomponent_p4);
        initTimePicker();
    }

    private void initTimePicker() {
        Button btnShowTimePickerDialog = findViewById(R.id.btn_p4_showTimePicker);
        tv_Time = findViewById(R.id.tv_time);
        btnShowTimePickerDialog.setOnClickListener(v -> {
            DialogFragment timepickerFragment = new TimePickerFragment();
            timepickerFragment.show(getSupportFragmentManager(), "timePicker");

        });
    }

    @Override
    public void setTimeValue(int nHour, int nMinute) {
        tv_Time.setText("time:" + nHour + ":" + nMinute);
    }
}
