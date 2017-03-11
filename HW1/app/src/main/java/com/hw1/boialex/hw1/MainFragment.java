/**
 * Created by boyalex on 10.03.17.
 */
package com.hw1.boialex.hw1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringDef;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
    private LinearLayout layout;

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
        layout = (LinearLayout)inflater.inflate(R.layout.fragment_main_layout, container, false);
        final EditText firstName = (EditText)layout.findViewById(R.id.FirstName);
        final EditText lastName = (EditText)layout.findViewById(R.id.LastName);
        final Button save = (Button)layout.findViewById(R.id.Save);
        save.setEnabled(false);
        date = (TextView)layout.findViewById(R.id.Date);
        Intent previousIntent = getActivity().getIntent();
        if (previousIntent.getStringExtra("first") != null) {
            firstName.setText(previousIntent.getStringExtra("first"));
            lastName.setText(previousIntent.getStringExtra("last"));
            date.setText(previousIntent.getStringExtra("date"));
            updateSignInButtonState();
        }

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DateDialogFragment();
                newFragment.show(getActivity().getSupportFragmentManager(), "datePicker");
            }
        });

        save.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent currentIntent = new Intent(getActivity(), InfoActivity.class);
                currentIntent.putExtra("first", firstName.getText().toString());
                currentIntent.putExtra("last", lastName.getText().toString());
                currentIntent.putExtra("date", date.getText().toString());
                startActivity(currentIntent);
                getActivity().finish();
            }
        });

        return layout;
    }

    @Override
    public void onResume() {
        super.onResume();
        TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                updateSignInButtonState();
            }
        };

        final EditText firstName = (EditText) layout.findViewById(R.id.FirstName);
        final EditText lastName = (EditText) layout.findViewById(R.id.LastName);

        date = (TextView) layout.findViewById(R.id.Date);
        firstName.addTextChangedListener(tw);
        lastName.addTextChangedListener(tw);
        date.addTextChangedListener(tw);
    }

    private void updateSignInButtonState() {
        final EditText firstName = (EditText)layout.findViewById(R.id.FirstName);
        final EditText lastName = (EditText)layout.findViewById(R.id.LastName);
        date = (TextView) layout.findViewById(R.id.Date);
        final Button save = (Button)layout.findViewById(R.id.Save);
        save.setEnabled(firstName.getText().length() > 0 &&
                        lastName.getText().length() > 0 &&
                        date.getText().length() > 0);
    }
}
