package android.learning.trace.android_learning_trace.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.learning.trace.android_learning_trace.presenter.IDateSetter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.util.Calendar;

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    int y, m, d;
    IDateSetter iDateSetter;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        Calendar c = Calendar.getInstance();
        y = c.get(Calendar.YEAR);
        m = c.get(Calendar.MONTH);
        d = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(getActivity(), this, y, m, d);

        return dialog;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iDateSetter = (IDateSetter) context;

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        iDateSetter.setDateValue(year, month + 1, dayOfMonth);

    }
}
