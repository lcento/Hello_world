package com.example.leo.hello_world;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * Created by ${USER} on ${DATE}.
 */
public class TravelPlanet extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        VideoView travelVideo = (VideoView)findViewById(R.id.travelVideoView);
        travelVideo.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Toast.makeText(TravelPlanet.this, "Going Home", Toast.LENGTH_SHORT).show();
                finish();
                return true;
            }
        });
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_X) {
            finish();
            return true;
        }
        return false;
    }
}
