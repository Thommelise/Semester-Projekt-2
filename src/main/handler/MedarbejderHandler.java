package main.handler;

import main.medarbejder.Ansat;
import main.medarbejder.MedarbejderListe;

import java.util.ArrayList;

public class MedarbejderHandler {

    public static ArrayList<Ansat> seMedarbejder() {
        MedarbejderListe medarbejderListe = new MedarbejderListe();
        return medarbejderListe.seMearbejder();
    }

    public static void opretMedarbejder(String navn, String cpr, int id, String stilling) {
        Ansat ansat = new Ansat(navn,cpr,id,stilling);
        MedarbejderListe medarbejderListe = new MedarbejderListe();
        medarbejderListe.opretMedarbejder(ansat);
    }

    public static void sletMedarbejder(String cpr) {
        MedarbejderListe medarbejderListe = new MedarbejderListe();
        medarbejderListe.sletMedarbejder(cpr);
    }

    public static Ansat seEnkelMedarbejder(String cpr) {
        MedarbejderListe medarbejderListe = new MedarbejderListe();
        return medarbejderListe.seEnkelMearbejder(cpr);
    }
}
