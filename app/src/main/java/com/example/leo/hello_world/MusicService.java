package com.example.leo.hello_world;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by leo on 29/12/15.
 */
public class MusicService extends Service {
    MediaPlayer musicPlayer;
    @Override
    public IBinder onBind(Intent arg0) {
        //TODO
        return null;
    }
    @Override
    public void onCreate() {
        Toast.makeText(this, "Music Service has been Created", Toast.LENGTH_SHORT).show();
        musicPlayer = MediaPlayer.create(this, R.raw.music);
        musicPlayer.setLooping(true);
    }
    public int onStartCommand(Intent intent, int flags, int startid) {
        Toast.makeText(this, "Music Service is Started", Toast.LENGTH_SHORT).show();
        musicPlayer.start();
        return START_NOT_STICKY;
    }
    @Override
    public void onDestroy() {
        Toast.makeText(this, "Music Service has been Stopped", Toast.LENGTH_SHORT).show();
        musicPlayer.stop();
    }
}
