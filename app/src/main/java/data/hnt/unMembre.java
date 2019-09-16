package data.hnt;

import android.app.Activity;

/**
 * Created by sio on 17/04/2018.
 */

public class unMembre extends Activity {

    private String strNom = "";
    private String strPrenom = "";
    private String strDateNaiss = "";
    private int strTauxHematies = 0;
    private int iImg = 0;

    public unMembre(){
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
    public void setImg(int img){
        this.iImg = img;
    }


    public String getNom(){
        return this.strNom;
    }
    public String getPrenom(){
        return this.strPrenom;
    }
    public String getDataNaiss(){
        return this.strDateNaiss;
    }
    public int getTauxHematies () {
        return this.strTauxHematies;
    }
    public int getImg(){
        return this.iImg;
    }
}
