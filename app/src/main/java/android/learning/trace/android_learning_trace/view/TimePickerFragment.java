package android.learning.trace.android_learning_trace.view;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.learning.trace.android_learning_trace.presenter.ITimeSetter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.TimePicker;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    int nHour;
    int nMinute;
    ITimeSetter timerSetter;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        timerSetter = (ITimeSetter) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar c = Calendar.getInstance();
        nHour = c.get(Calendar.HOUR_OF_DAY);
        nMinute = c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(), this, nHour, nMinute, true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        this.nHour = hourOfDay;
        this.nMinute = minute;
        timerSetter.setTimeValue(hourOfDay, minute);

    }
}
