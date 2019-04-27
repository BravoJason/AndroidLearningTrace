package android.learning.trace.android_learning_trace.view;


import android.learning.trace.android_learning_trace.R;
import android.learning.trace.android_learning_trace.presenter.IDateSetter;
import android.learning.trace.android_learning_trace.presenter.ITimeSetter;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class BasicUIComponentP4Activity extends AppCompatActivity implements ITimeSetter, IDateSetter {

    TextView tvTime, tvDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_uicomponent_p4);
        initTimePicker();
        initDatePicker();
    }

    private void initTimePicker() {
        Button btnShowTimePickerDialog = findViewById(R.id.btn_p4_showTimePicker);
        tvTime = findViewById(R.id.tv_time);
        btnShowTimePickerDialog.setOnClickListener(v -> {
            DialogFragment timepickerFragment = new TimePickerFragment();
            timepickerFragment.show(getSupportFragmentManager(), "timePicker");

        });
    }

    @Override
    public void setTimeValue(int nHour, int nMinute) {
        tvTime.setText("time:" + nHour + ":" + nMinute);
    }

    private void initDatePicker() {

        tvDate = findViewById(R.id.tv_date);
        Button btnShowDatePicker = findViewById(R.id.btn_p4_showDatePicker);
        btnShowDatePicker.setOnClickListener(v -> {
            DialogFragment dialogFragment = new DatePickerFragment();
            dialogFragment.show(getSupportFragmentManager(), "datePicker");
        });


    }

    @Override
    public void setDateValue(int y, int m, int d) {

        tvDate.setText(y + "-" + m + "-" + d);
    }
}
