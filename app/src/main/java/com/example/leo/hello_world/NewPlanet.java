package com.example.leo.hello_world;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by leo on 02/12/15.
 */
public class NewPlanet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setIcon(R.drawable.helloworldicon);

        Button doneButton = (Button)findViewById(R.id.doneAddingButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ImageView marsImage = (ImageView)findViewById(R.id.imageMars);
        marsImage.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                WorldGen mars = new WorldGen("Mars", 642, 3.7);
                mars.setPlanetColonies(1);
                Toast.makeText(NewPlanet.this, "Mars Created", Toast.LENGTH_SHORT).show();
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
