package com.example.sio.ppe7;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class Hematies extends Activity {

    private EditText nbHematies;
    private Button btCalcul;
    private TextView txtResultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hematies);

        nbHematies = findViewById(R.id.edTxtHematies);
        btCalcul = findViewById(R.id.btCalcul);
        txtResultat = findViewById(R.id.txtResultat);

        btCalcul.setOnClickListener(btnCompareListener);

        init();
    }


    private void init() {

    }

    private View.OnClickListener btnCompareListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Log.i("DEBUG", "OK OK");

            String strNumber = nbHematies.getText().toString();
            if (strNumber.equals("")) return;

            int enteredValue = Integer.parseInt(strNumber);

            int rouge = getResources().getColor(R.color.colorRouge);
            int vert = getResources().getColor(R.color.colorVert);

            RadioButton rbHomme = (RadioButton) findViewById(R.id.rbHomme);

            if (rbHomme.isChecked() == true) {
                if (enteredValue < 4600000) {
                    txtResultat.setText(R.string.txtAnemie);
                    txtResultat.setTextColor(rouge);
                } else if (enteredValue >= 4600000 && enteredValue <= 6200000) {
                    txtResultat.setText(R.string.txtResultatOk);
                    txtResultat.setTextColor(vert);
                } else {
                    txtResultat.setText(R.string.txtVaquez);
                    txtResultat.setTextColor(rouge);
                }
            } else {
                if (enteredValue < 4200000) {
                    txtResultat.setText(R.string.txtAnemieF);
                    txtResultat.setTextColor(rouge);
                } else if (enteredValue >= 4200000 && enteredValue <= 5400000) {
                    txtResultat.setText(R.string.txtResultatOkF);
                    txtResultat.setTextColor(vert);
                } else {
                    txtResultat.setText(R.string.txtVaquezF);
                    txtResultat.setTextColor(rouge);
                }
            }
        }
    };

}
