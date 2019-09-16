package com.example.sio.ppe7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import data.hnt.unMembre;


/**
 * Created by Harichandra on 15/04/2018.
 */

public class MembreAdapter extends ArrayAdapter<unMembre> {
    public MembreAdapter(Context context, int textViewRessourceId) {
        super(context, textViewRessourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View result = convertView;
        if (convertView == null) {
            result = LayoutInflater.from(getContext()).inflate(R.layout.ligne, parent, false);
        }
        unMembre membre = getItem(position);

        TextView nom = (TextView) result.findViewById(R.id.nomMembre);
        nom.setText(membre.getNom());

        TextView prenom = (TextView) result.findViewById(R.id.prenomMembre);
        prenom.setText(membre.getPrenom());

        ImageView imageView = (ImageView)result.findViewById(R.id.Image);
        imageView.setImageResource(membre.getImg());

        return result;
    }

    public void updateData() {
        this.notifyDataSetChanged();
    }
}

