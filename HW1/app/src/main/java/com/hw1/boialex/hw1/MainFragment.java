/**
 * Created by boyalex on 10.03.17.
 */
package com.hw1.boialex.hw1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.Calendar;


public class MainFragment extends Fragment {
    public static final String TAG = MainFragment.class.getSimpleName();
    public TextView date;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        final LinearLayout layout = (LinearLayout)inflater.inflate(R.layout.fragment_main_layout, container, false);
        final EditText firstName = (EditText)layout.findViewById(R.id.FirstName);
        final EditText lastName = (EditText)layout.findViewById(R.id.LastName);

        date = (TextView)layout.findViewById(R.id.Date);
        final Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);
        int day = today.get(Calendar.DAY_OF_MONTH);
        String dateString = String.valueOf(day) + '.' + String.valueOf(month) + '.' + String.valueOf(year);
        date.setText(dateString);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DateDialogFragment();
                newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
            }
        });

        final Button save = (Button)layout.findViewById(R.id.Save);
        save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent currentIntent = new Intent(getActivity(), InfoActivity.class);
                currentIntent.putExtra("first", firstName.getText().toString());
                currentIntent.putExtra("last", lastName.getText().toString());
                currentIntent.putExtra("date", date.getText().toString());
                startActivity(currentIntent);
            }
        });

        return layout;
    }

}
