package com.example.anand.myoex;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import com.thalmic.myo.*;
import android.content.Intent;
import com.thalmic.myo.scanner.ScanActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Hub hub = Hub.getInstance();
        if (!hub.init(this)) {
            //Log.e(TAG, "Could not initialize the Hub.");
            System.out.println("Could not initialize Hub");
            finish();
            return;
        }

        // Launch the ScanActivity to scan for Myos to connect to.
//        Intent intent = new Intent(this, ScanActivity.class);
//        startActivity(intent);
        // Use this instead to connect with a Myo that is very near (ie. almost touching) the device
        Hub.getInstance().attachToAdjacentMyo();
    }

}
