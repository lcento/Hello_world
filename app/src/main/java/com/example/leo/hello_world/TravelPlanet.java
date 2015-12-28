package com.example.leo.hello_world;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
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

        getSupportActionBar().setIcon(R.drawable.helloworldicon);

        Uri videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.mars270);
        VideoView travelVideo = (VideoView)findViewById(R.id.travelVideoView);
        travelVideo.setVideoURI(videoUri);
        MediaController videoMediaController = new MediaController(this);
        videoMediaController.setAnchorView(travelVideo);
        travelVideo.setMediaController(videoMediaController);
        travelVideo.bringToFront();
        travelVideo.requestFocus();
        travelVideo.start();
        Button travelButton = (Button)findViewById(R.id.travelButton);
        travelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(TravelPlanet.this, "Going Home", Toast.LENGTH_SHORT).show();
                finish();
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
