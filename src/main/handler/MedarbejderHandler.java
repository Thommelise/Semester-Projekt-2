package main.handler;

import main.medarbejder.Ansat;
import main.medarbejder.MedarbejderListe;

import java.util.ArrayList;

public class MedarbejderHandler {

    public static ArrayList<Ansat> seMedarbejder() {
        MedarbejderListe medarbejderListe = new MedarbejderListe();
        return medarbejderListe.seMearbejder();
    }

    public static boolean opretMedarbejder(String navn, String cpr, int id, String stilling) {
        Ansat ansat = new Ansat(navn,cpr,id,stilling);
        MedarbejderListe medarbejderListe = new MedarbejderListe();
        return medarbejderListe.opretMedarbejder(ansat);
    }

    public static boolean sletMedarbejder(String cpr) {
        MedarbejderListe medarbejderListe = new MedarbejderListe();
        return medarbejderListe.sletMedarbejder(cpr);
    }

    public static Ansat seEnkelMedarbejder(String cpr) {
        MedarbejderListe medarbejderListe = new MedarbejderListe();
        return medarbejderListe.seEnkelMearbejder(cpr);
    }

    public static String checkStilling (int id) {
        ArrayList<Ansat> alleAnsat = seMedarbejder();
        for (Ansat i:alleAnsat) {
            if (id == i.getId()) {
                return i.getStilling();
            }
        }
        return "Ugyldig";
    }
}
