package com.example.sio.ppe7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Harichandra on 15/04/2018.
 */

public class DatabaseMembre extends SQLiteOpenHelper {

    public DatabaseMembre(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String strReq = "CREATE TABLE tab_membre (id INTEGER PRIMARY KEY AUTOINCREMENT, nom_membre TEXT ,prenom_membre TEXT ,date_naiss DATE ,taux_hematies INTEGER, img TEXT);";
        db.execSQL(strReq);
    }

    @Override
    public void onUpgrade (SQLiteDatabase arg0, int arg1, int arg2) {
    }
}
