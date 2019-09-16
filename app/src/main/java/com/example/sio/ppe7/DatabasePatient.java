package com.example.sio.ppe7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 22/04/2018.
 */

public class DatabasePatient extends SQLiteOpenHelper{

    public DatabasePatient(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strReq = "CREATE TABLE tab_patient (id INTEGER PRIMARY KEY AUTOINCREMENT, nom_patient TEXT ,prenom_patient TEXT ,date_naiss_patient DATE ,taux_hematies_patient INTEGER);";
        db.execSQL(strReq);
    }

    @Override
    public void onUpgrade (SQLiteDatabase arg0, int arg1, int arg2) {
    }
}
