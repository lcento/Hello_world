package com.example.leo.hello_world;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by leo on 29/12/15.
 */
public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context arg0, Intent arg1 ) {
        Toast.makeText(arg0, "ALARM NOTIFICATION", Toast.LENGTH_SHORT).show();
    }
}
