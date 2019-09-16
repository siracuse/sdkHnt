package com.example.sio.ppe7;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import android.util.Log;
import data.hnt.unMembre;

import java.util.Locale;

public class Membres extends Activity{

    private DatabaseMembre databaseMembre;
    private ListView listMembre;
    private MembreAdapter adapterMembre;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.membres);
        listMembre = (ListView)findViewById(R.id.listMembre);

        databaseMembre = new DatabaseMembre(getBaseContext(), "dbMembre.db", null, 1);
        SQLiteDatabase db = databaseMembre.getReadableDatabase();
        db.setLocale(Locale.FRENCH);
        String req = "SELECT nom_membre, prenom_membre, img FROM tab_membre";
        Cursor result = db.rawQuery(req, null);
        Log.i("LocDVD", "Nbr data = " + String.valueOf(result.getCount()));

        if (result.getCount() > 0) {
            adapterMembre = new MembreAdapter(this, R.layout.ligne);
            result.moveToFirst();
            while (!result.isAfterLast()) {
                unMembre membres = new unMembre();

//                int id = result.getInt(0);
//                Log.i ("LocDVD", "Id = " + String.valueOf(id));

                String nom_membre = result.getString(0);
                membres.setNom(nom_membre);
                Log.i("LocDVD", "Nom = " + nom_membre);

                String prenom_membre = result.getString(1);
                membres.setPrenom(prenom_membre);
                Log.i("LocDVD", "Prenom = " + prenom_membre);

                String strImg = result.getString(2);
//                Log.i("LocDVD ", "Titre = " + strImg);
                String path = getPackageName() + ":drawable/" + strImg;
                int resID = getResources().getIdentifier(path, null, null);
                membres.setImg(resID);
                Log.i("LocDVD", "Img = " + strImg);

                adapterMembre.add(membres);
                result.moveToNext();
            }
            listMembre.setAdapter(adapterMembre);
        }
    }
}
