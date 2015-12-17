package com.example.leo.hello_world;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by leo on 04/12/15.
 */
public class AttackPlanet extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setIcon(R.drawable.helloworldicon);

        ImageButton bombButton = (ImageButton)findViewById(R.id.bombButton);
        Animation rotateBomb = AnimationUtils.loadAnimation(this, R.anim.anim_rot_bomb);
        bombButton.startAnimation(rotateBomb);
        bombButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AttackPlanet.this, "Bombs Away!", Toast.LENGTH_SHORT).show();
            }
        });
        ImageView invadeEffect = (ImageView)findViewById(R.id.invadeEffect);
        AnimationDrawable transporterEffect = (AnimationDrawable) invadeEffect.getBackground();
        transporterEffect.start();
        ImageButton invadeButton = (ImageButton)findViewById(R.id.invadeButton);
        Animation alphaInvade = AnimationUtils.loadAnimation(this, R.anim.anim_alpha_invade);
        invadeButton.startAnimation(alphaInvade);
        invadeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AttackPlanet.this, "Troops Sent!", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton infectButton = (ImageButton)findViewById(R.id.infectButton);
        Animation scaleVirus = AnimationUtils.loadAnimation(this,R.anim.anim_scale_virus);
        infectButton.startAnimation(scaleVirus);
        infectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AttackPlanet.this, "Virus Spread!", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton laserButton = (ImageButton)findViewById(R.id.laserButton);
        laserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AttackPlanet.this, "Laser Fired!", Toast.LENGTH_SHORT).show();
            }
        });
        ImageButton exitButton = (ImageButton)findViewById(R.id.exitButton);
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
