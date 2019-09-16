package data.hnt;

import android.app.Activity;

/**
 * Created by user on 22/04/2018.
 */

public class unPatient extends Activity {
    private String strNom = "";
    private String strPrenom = "";
    private String strDateNaiss = "";
    private int strTauxHematies = 0;


    public unPatient(){
    }

    public void setNom(String nom){
        this.strNom = nom;
    }
    public void setPrenom(String prenom){
        this.strPrenom = prenom;
    }
    public void setDateNaiss(String datenaiss){
        this.strDateNaiss = datenaiss;
    }
    public void setTauxHematies(int taux_hematies) {
        this.strTauxHematies = taux_hematies;
    }


    public String getNom(){
        return this.strNom;
    }
    public String getPrenom(){
        return this.strPrenom;
    }
    public String getDateNaiss(){
        return this.strDateNaiss;
    }
    public int getTauxHematies () {
        return this.strTauxHematies;
    }

}
