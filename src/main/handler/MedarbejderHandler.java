package main.handler;

import main.medarbejder.Ansat;
import main.medarbejder.MedarbejderListe;

import java.util.ArrayList;

public class MedarbejderHandler {

    private static MedarbejderHandler objMedarbejde = null;

    public synchronized static MedarbejderHandler initMedarbejderHandler(){
        if(objMedarbejde == null) {
            objMedarbejde = new MedarbejderHandler();
        }
        return objMedarbejde;
    }

    public synchronized ArrayList<Ansat> seMedarbejder() {
        MedarbejderListe medarbejderListe = new MedarbejderListe();
        return medarbejderListe.seMearbejder();
    }

    public synchronized boolean opretMedarbejder(String navn, String cpr, int id, String stilling) {
        Ansat ansat = new Ansat(navn,cpr,id,stilling);
        MedarbejderListe medarbejderListe = new MedarbejderListe();
        return medarbejderListe.opretMedarbejder(ansat);
    }

    public synchronized boolean sletMedarbejder(String cpr) {
        MedarbejderListe medarbejderListe = new MedarbejderListe();
        return medarbejderListe.sletMedarbejder(cpr);
    }

    public synchronized Ansat seEnkelMedarbejder(String cpr) {
        MedarbejderListe medarbejderListe = new MedarbejderListe();
        return medarbejderListe.seEnkelMearbejder(cpr);
    }

    public synchronized String checkStilling (int id) {
        ArrayList<Ansat> alleAnsat = seMedarbejder();
        for (Ansat i:alleAnsat) {
            if (id == i.getId()) {
                return i.getStilling();
            }
        }
        return "Ugyldig";
    }
}
