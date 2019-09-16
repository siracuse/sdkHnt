package com.example.sio.ppe7;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.Locale;

import data.hnt.unPatient;

public class Patients extends Activity {

    private DatabasePatient databasePatient;
    private ListView listPatient;
    private PatientAdapter adapterPatient;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.patients);


        Button btaddPatient = (Button) findViewById(R.id.btAddPatient);
        btaddPatient.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Log.i ("DEBUG", "Bouton Test hematies");
                Intent intent = new Intent(Patients.this, AddPatient.class);
                startActivity(intent);
            }
        });

        Button btDelPatient = (Button) findViewById(R.id.btDel);
        btDelPatient.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                Log.i ("DEBUG", "Bouton Supprimer");
                Intent intent = new Intent(Patients.this, DeletePatient.class);
                startActivity(intent);
            }
        });


        listPatient = (ListView)findViewById(R.id.listPatient);
        databasePatient = new DatabasePatient(getBaseContext(), "dbPatient.db", null, 1);
        SQLiteDatabase db = databasePatient.getReadableDatabase();
        db.setLocale(Locale.FRENCH);
        String req = "SELECT nom_patient, prenom_patient, date_naiss_patient, taux_hematies_patient FROM tab_patient";
        Cursor result = db.rawQuery(req, null);
        Log.i("HNT", "Nbr data patient = " + String.valueOf(result.getCount()));

        if (result.getCount() > 0) {
            adapterPatient = new PatientAdapter(this, R.layout.lignepatient);
            result.moveToFirst();
            while (!result.isAfterLast()) {
                unPatient patient = new unPatient();

                String nom_patient = result.getString(0);
                patient.setNom(nom_patient);
                Log.i("HNT", "Nom = " + nom_patient);

                String prenom_patient = result.getString(1);
                patient.setPrenom(prenom_patient);
                Log.i("HNT", "Prenom = " + prenom_patient);

                String date_patient = result.getString(2);
                patient.setDateNaiss(date_patient);
                Log.i("HNT", "date = " + date_patient);

                int taux = result.getInt(3);
                patient.setTauxHematies(taux);
                Log.i("HNT", "taux = " + taux);

                adapterPatient.add(patient);
                result.moveToNext();
            }
            listPatient.setAdapter(adapterPatient);
        }
    }
}
