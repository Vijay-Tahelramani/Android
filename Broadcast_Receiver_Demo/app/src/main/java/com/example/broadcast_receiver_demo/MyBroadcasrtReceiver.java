package com.example.broadcast_receiver_demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyBroadcasrtReceiver extends BroadcastReceiver {

    public MyBroadcasrtReceiver(){}
    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();


        if (("android.net.conn.CONNECTIVITY_CHANGE").equals(action)) {
            Toast.makeText(context, "Network Connectivity Changed!", Toast.LENGTH_SHORT).show();
        }

    }
}
