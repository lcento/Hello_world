package com.example.leo.hello_world;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    WorldGen earth = new WorldGen("Earth", 5973, 9.78);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setStartUpWorldValues();
        setStartUpScreenText();
        setStartUpScreenAnim();
        setStartUpScreenAudio();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setIcon(R.drawable.helloworldicon);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setStartUpScreenAudio() {
        MediaPlayer audioPlayer = MediaPlayer.create(getApplicationContext(), R.raw.ambient);
        audioPlayer.setLooping(true);
        audioPlayer.start();
    }

    private void setStartUpScreenAnim() {
        //ImageView homePlanet = (ImageView)findViewById(R.id.imageEarth);
        //homePlanet.setBackgroundResource(R.drawable.anim_forcefield);
        //AnimationDrawable forceFieldAnimation = (AnimationDrawable)homePlanet.getBackground();
        //forceFieldAnimation.start();
        ImageView effectPlanet = (ImageView)findViewById(R.id.planetEffect);
        Animation animSetRing = AnimationUtils.loadAnimation(this,R.anim.anim_set_ring);
        effectPlanet.startAnimation(animSetRing);
    }
    protected void setStartUpWorldValues() {
        earth.setPlanetColonies(1);
        earth.setPlanetMilitary(1);
        earth.setColonyImmigration(1000);
        earth.setBaseProtection(100);
        earth.turnForceFieldOn();
    }
    private void setStartUpScreenText() {
        TextView planetNameValue = (TextView)findViewById(R.id.dataView1);
        planetNameValue.setText(earth.planetName);
        TextView planetMassValue = (TextView)findViewById(R.id.dataView2);
        planetMassValue.setText(String.valueOf(earth.planetMass));
        TextView planetGravityValue = (TextView)findViewById(R.id.dataView3);
        planetGravityValue.setText(String.valueOf(earth.planetGravity));
        TextView planetColoniesValue = (TextView)findViewById(R.id.dataView4);
        planetColoniesValue.setText(String.valueOf(earth.planetColonies));
        TextView planetPopulationValue = (TextView)findViewById(R.id.dataView5);
        planetPopulationValue.setText(String.valueOf(earth.planetPopulation));
        TextView planetMilitaryValue = (TextView)findViewById(R.id.dataView6);
        planetMilitaryValue.setText(String.valueOf(earth.planetMilitary));
        TextView planetBaseValue = (TextView)findViewById(R.id.dataView7);
        planetBaseValue.setText(String.valueOf(earth.planetBases));
        TextView planetForceFieldValue = (TextView)findViewById(R.id.dataView8);
        planetForceFieldValue.setText(String.valueOf(earth.planetProtection));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement
        switch(item.getItemId()) {
            case R.id.menu_add:
                Intent intent_add = new Intent(this, NewPlanet.class);
                this.startActivity(intent_add);
                break;
            case R.id.menu_config:
                Intent intent_config = new Intent(this, ConfigPlanet.class);
                this.startActivity(intent_config);
                break;
            case R.id.menu_travel:
                Intent intent_travel = new Intent(this, TravelPlanet.class);
                this.startActivity(intent_travel);
                break;
            case R.id.menu_attack:
                Intent intent_attack = new Intent(this, AttackPlanet.class);
                this.startActivity(intent_attack);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
