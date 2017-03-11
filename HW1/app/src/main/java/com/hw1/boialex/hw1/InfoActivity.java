package com.hw1.boialex.hw1;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {
    public static final String TAG = InfoActivity.class.getSimpleName();
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        layout = (LinearLayout)findViewById(R.id.info);
        final TextView infoFirstName = (TextView)layout.findViewById(R.id.InfoFirstName);
        final TextView infoLastName = (TextView)layout.findViewById(R.id.InfoLastName);
        final TextView infoDate = (TextView)layout.findViewById(R.id.InfoDate);
        final Button edit = (Button)layout.findViewById(R.id.Edit);
        Intent previosIntent = getIntent();
        infoFirstName.setText(previosIntent.getStringExtra("first"));
        infoLastName.setText(previosIntent.getStringExtra("last"));
        infoDate.setText(previosIntent.getStringExtra("date"));

        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finistAndStart();
            }
        });
    }

    private void finistAndStart() {
        final TextView infoFirstName = (TextView)layout.findViewById(R.id.InfoFirstName);
        final TextView infoLastName = (TextView)layout.findViewById(R.id.InfoLastName);
        final TextView infoDate = (TextView)layout.findViewById(R.id.InfoDate);

        Intent currentIntent = new Intent(this, MainActivity.class);
        currentIntent.putExtra("first", infoFirstName.getText().toString());
        currentIntent.putExtra("last", infoLastName.getText().toString());
        currentIntent.putExtra("date", infoDate.getText().toString());
        startActivity(currentIntent);
        finish();
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
