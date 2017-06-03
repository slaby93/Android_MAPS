package com.example.slaby.android_maps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BroadcastReceiver br = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                System.out.println("RECEIVED " + intent.toString());
            }
        };
        IntentFilter filter =
                new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(br, filter);
    }

    public void onMapaClick(View view) {
        System.out.println("Going to Map");
        Intent myIntent = new Intent(this, MapsActivity.class);
        Double lat = Double.valueOf(((TextView) findViewById(R.id.lat)).getText().toString());
        Double lng = Double.valueOf(((TextView) findViewById(R.id.lng)).getText().toString());
        myIntent.putExtra("TASK", "PROVIDED");
        myIntent.putExtra("lat", lat);
        myIntent.putExtra("lng", lng);
        startActivity(myIntent);
    }

    public void onMyLocationClick(View view) {
        System.out.println("Going to Map");
        Intent myIntent = new Intent(this, MapsActivity.class);
        myIntent.putExtra("TASK", "FIND");
        startActivity(myIntent);
    }
}
