package com.hw1.boialex.hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = (LinearLayout) findViewById(R.id.main);
        getSupportFragmentManager()
                .beginTransaction()
                .add(layout.getId(), new MainFragment(), MainFragment.class.getSimpleName())
                .commit();
    }
}
