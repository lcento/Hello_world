package com.example.leo.hello_world;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by leo on 03/12/15.
 */
public class ConfigPlanet extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EditText colonyText = (EditText)findViewById(R.id.editTextColonies);
        colonyText.setText("1", EditText.BufferType.EDITABLE);
        EditText colonistText = (EditText)findViewById(R.id.editTextColonists);
        colonistText.setText("100", EditText.BufferType.EDITABLE);
        EditText basesText = (EditText)findViewById(R.id.editTextBases);
        basesText.setText("1", EditText.BufferType.EDITABLE);
        EditText militaryText = (EditText)findViewById(R.id.editTextMilitary);
        militaryText.setText("10", EditText.BufferType.EDITABLE);
        EditText forcefieldOnText = (EditText)findViewById(R.id.editForcefieldOn);
        forcefieldOnText.setText("", EditText.BufferType.EDITABLE);
        EditText forcefieldOffText = (EditText)findViewById(R.id.editForcefieldOff);
        forcefieldOffText.setText("Forcefield is Off", EditText.BufferType.EDITABLE);

        Button colonyButton = (Button)findViewById(R.id.coloniesButton);
        colonyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button colonistButton = (Button)findViewById(R.id.colonistsButton);
        colonistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button baseButton = (Button)findViewById(R.id.basesButton);
        baseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button militaryButton = (Button)findViewById(R.id.militaryButton);
        militaryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button forceFieldOnButton = (Button)findViewById(R.id.ffonButton);
        forceFieldOnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button forceFieldOffButton = (Button)findViewById(R.id.ffonButton);
        forceFieldOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        Button doneButton = (Button)findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
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
