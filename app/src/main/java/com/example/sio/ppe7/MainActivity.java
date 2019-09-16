package com.example.sio.ppe7;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.xmlpull.v1.XmlPullParser;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private DatabaseMembre databaseMembre;
    private DatabasePatient databasePatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btHematies = (Button) findViewById(R.id.btTest);
        btHematies.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Log.i ("DEBUG", "Bouton Test hematies");
                Intent intent = new Intent(MainActivity.this, Hematies.class);
                startActivity(intent);
            }
        });

        Button btEntreprise = (Button) findViewById(R.id.btEntreprise);
        btEntreprise.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Log.i ("DEBUG", "Bouton entreprise");
                Intent intent = new Intent(MainActivity.this, Entreprise.class);
                startActivity(intent);
            }
        });

        Button btMembres = (Button) findViewById(R.id.btMembre);
        btMembres.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Log.i ("DEBUG", "Bouton membre");
                Intent intent = new Intent(MainActivity.this, Membres.class);
                startActivity(intent);
            }
        });

        Button btPatients = (Button) findViewById(R.id.btGestion);
        btPatients.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Log.i ("DEBUG", "Bouton gestion");
                Intent intent = new Intent(MainActivity.this, Patients.class);
                startActivity(intent);
            }
        });

        //BDD MEMBRE
        databaseMembre = new DatabaseMembre(getBaseContext(), "dbMembre.db", null, 1);
        db = databaseMembre.getWritableDatabase();
        db.setLockingEnabled(false);
        db.execSQL("DROP TABLE IF EXISTS tab_membre");
        databaseMembre.onCreate(db);

        //DEBUG   VERIF DE LA CREATION DE LA BDD
        Cursor result = db.rawQuery("SELECT * FROM tab_membre", null);
        int nbrCol = result.getColumnCount();
        Log.i("HNT", "Nbre de colonnes table membre= " + String.valueOf(nbrCol));

        //CHARGEMENT DES DONNEES MEMBRE
        try {
            XmlPullParser xmlPullParser = getResources().getXml(R.xml.membre);
            while (xmlPullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (xmlPullParser.getEventType() == XmlPullParser.START_TAG) {
                    if (xmlPullParser.getName().equals("membre")) {

                        ContentValues contentValues = new ContentValues();
                        contentValues.put("date_naiss", xmlPullParser.getAttributeValue(0));
                        contentValues.put("img", xmlPullParser.getAttributeValue(1));
                        contentValues.put("nom_membre", xmlPullParser.getAttributeValue(2));
                        contentValues.put("prenom_membre", xmlPullParser.getAttributeValue(3));
                        contentValues.put("taux_hematies", xmlPullParser.getAttributeValue(4));

                        Log.i("HNT", "Nom = " + contentValues.getAsString("img"));
                        db.insert("tab_membre", null, contentValues);
                    }
                }
                xmlPullParser.next();
            }
            db = databaseMembre.getReadableDatabase();
            result = db.rawQuery("SELECT * FROM tab_membre", null);
            int nbrData = result.getCount();
            Log.i ("HNT", "enregistrements = " + String.valueOf(nbrData));

        } catch (Exception e) {
            Log.i("HNT", "Erreur = " + e.getMessage());
            e.printStackTrace();
        }


        //BDD PATIENT
        databasePatient = new DatabasePatient(getBaseContext(), "dbPatient.db", null, 1);
        db = databasePatient.getWritableDatabase();
        db.setLockingEnabled(false);
        db.execSQL("DROP TABLE IF EXISTS tab_patient");
        databasePatient.onCreate(db);

        //DEBUG   VERIF DE LA CREATION DE LA BDD
        Cursor result2 = db.rawQuery("SELECT * FROM tab_patient", null);
        int nbrCol2 = result2.getColumnCount();
        Log.i("HNT", "Nbre de colonnes table patient = " + String.valueOf(nbrCol2));


        //CHARGEMENT DES DONNEES PATIENT
        try {
            XmlPullParser xmlPullParser = getResources().getXml(R.xml.patient);
            while (xmlPullParser.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (xmlPullParser.getEventType() == XmlPullParser.START_TAG) {
                    if (xmlPullParser.getName().equals("patient")) {

                        ContentValues contentValues = new ContentValues();
                        contentValues.put("date_naiss_patient", xmlPullParser.getAttributeValue(0));
                        contentValues.put("nom_patient", xmlPullParser.getAttributeValue(1));
                        contentValues.put("prenom_patient", xmlPullParser.getAttributeValue(2));
                        contentValues.put("taux_hematies_patient", xmlPullParser.getAttributeValue(3));
                        Log.i("HNT", "Nom patient = " + contentValues.getAsString("nom_patient"));
                        db.insert("tab_patient", null, contentValues);
                    }
                }
                xmlPullParser.next();
            }
            db = databasePatient.getReadableDatabase();
            result2 = db.rawQuery("SELECT * FROM tab_patient", null);
            int nbrData2 = result2.getCount();
            Log.i ("HNT", "enregistrements patient = " + String.valueOf(nbrData2));

        } catch (Exception e) {
            Log.i("HNT", "Erreur = " + e.getMessage());
            e.printStackTrace();
        }
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_game:
                Log.i("LocDVD", "Menu : Recherchez un film");
                return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    protected void onDestroy() {
        db.close();
        super.onDestroy();
    }
}
