package com.hw1.boialex.hw1;

import android.app.DatePickerDialog;
import android.app.Dialog;
import java.util.Calendar;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

/**
 * Created by boyalex on 10.03.17.
 */

public class DateDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private static final String TAG = DateDialogFragment.class.getSimpleName();

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);
        int day = today.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {
        String dateString = String.valueOf(day) + '.' + String.valueOf(month) + '.' + String.valueOf(year);
        ((MainFragment)getActivity()
                .getSupportFragmentManager()
                .findFragmentByTag(MainFragment.class.getSimpleName()))
                .setDateText(dateString);
    }

}
