package com.example.sio.ppe7;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.drm.DrmStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Harichandra on 25/04/2018.
 */

public class DeletePatient extends Activity{

    private EditText etId;
    private Button valider;
    private SQLiteDatabase db;
    private DatabasePatient databasePatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deletepatient);

        etId = findViewById(R.id.edDelID);
        valider = findViewById(R.id.btDelValider);
        valider.setOnClickListener(btnCompareListener);
    }

    private View.OnClickListener btnCompareListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String id = etId.getText().toString();

            String req = "DELETE FROM tab_patient WHERE id='"+id+"'";

            databasePatient = new DatabasePatient(getBaseContext(), "dbPatient.db", null, 1);
            db = databasePatient.getWritableDatabase();
            db.setLockingEnabled(false);
            db.execSQL(req);

            Intent intent = new Intent(DeletePatient.this, Patients.class);
            startActivity(intent);
        }
    };
}
