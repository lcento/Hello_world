package com.example.leo.hello_world;

import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by leo on 30/12/15.
 */
public class AlienContact extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setIcon(R.drawable.helloworldicon);

        Button aliensButton = (Button)findViewById(R.id.findAliens);
        aliensButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listAliens();
            }
        });
        Button spockButton = (Button)findViewById(R.id.addSpock);
        spockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToAlliance("Spock");
            }
        });
        Button worfButton = (Button)findViewById(R.id.addWorf);
        worfButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addToAlliance("worf");
            }
        });
        Button homeButton = (Button)findViewById(R.id.returnHome);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                finish();
            }
        });
    }

    private void addToAlliance(String newAlien) {
        ContentValues alienContact = new ContentValues();
        alienContact.put(ContactsContract.RawContacts.ACCOUNT_NAME, newAlien);
        alienContact.put(ContactsContract.RawContacts.ACCOUNT_TYPE, newAlien);
        Uri addUri = getContentResolver().insert(ContactsContract.RawContacts.CONTENT_URI, alienContact);
        long rawContactId = ContentUris.parseId(addUri);
        alienContact.clear();
        alienContact.put(ContactsContract.Data.RAW_CONTACT_ID, rawContactId);
        alienContact.put(ContactsContract.Data.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
        alienContact.put(ContactsContract.CommonDataKinds.StructuredName.DISPLAY_NAME, newAlien);
        getContentResolver().insert(ContactsContract.Data.CONTENT_URI, alienContact);
        Toast.makeText(this, "New Alliance Menber: " + newAlien, Toast.LENGTH_SHORT).show();
    }

    private void listAliens() {
        Cursor alienCur = getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while (alienCur.moveToNext()) {
            String alienName = alienCur.getString(alienCur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
            Toast.makeText(this, alienName, Toast.LENGTH_SHORT).show();
        }
        alienCur.close();
    }
}
