package com.example.sio.ppe7;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import data.hnt.unPatient;

/**
 * Created by user on 22/04/2018.
 */

public class PatientAdapter extends ArrayAdapter<unPatient> {

    public PatientAdapter(Context context, int textViewRessourceId) {
        super(context, textViewRessourceId);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View result = convertView;
        if (convertView == null) {
            result = LayoutInflater.from(getContext()).inflate(R.layout.lignepatient, parent, false);
        }
        unPatient patient = getItem(position);

        TextView nom = (TextView) result.findViewById(R.id.nomPatient);
        nom.setText(patient.getNom());

        TextView prenom = (TextView) result.findViewById(R.id.prenomPatient);
        prenom.setText(patient.getPrenom());

        TextView taux = (TextView) result.findViewById(R.id.taux);
        taux.setText(Integer.toString(patient.getTauxHematies()));

        TextView date = (TextView) result.findViewById(R.id.datePatient);
        date.setText(patient.getDateNaiss());

        return result;
    }

    public void updateData() {
        this.notifyDataSetChanged();
    }

}

