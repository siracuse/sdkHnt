package com.example.sio.ppe7;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;


/**
 * Created by user on 22/04/2018.
 */

public class AddPatient extends Activity {

    private EditText etNom;
    private EditText etPrenom;
    private EditText etDate;
    private Button valider;
    private SQLiteDatabase db;
    private DatabasePatient databasePatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addpatient);

        etNom = findViewById(R.id.etNomPatient);
        etPrenom = findViewById(R.id.etPrenomPatient);
        etDate = findViewById(R.id.etDatePatient);
        valider = findViewById(R.id.btValider);

        valider.setOnClickListener(btnCompareListener);
    }

    private View.OnClickListener btnCompareListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String nom = etNom.getText().toString();
            String prenom = etPrenom.getText().toString();
            String date = etDate.getText().toString();

            String req = "INSERT INTO tab_patient (nom_patient, prenom_patient, date_naiss_patient, taux_hematies_patient) VALUES ('" + nom + "', '" + prenom + "', '" + date + "', 00)";

            databasePatient = new DatabasePatient(getBaseContext(), "dbPatient.db", null, 1);
            db = databasePatient.getWritableDatabase();
            db.setLockingEnabled(false);
            db.execSQL(req);

            Intent intent = new Intent(AddPatient.this, Patients.class);
            startActivity(intent);


        }
    };


}
