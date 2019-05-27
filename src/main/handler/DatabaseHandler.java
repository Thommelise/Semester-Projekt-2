package main.handler;


import main.varelager.Lager;
import main.varelager.Spild;
import main.varelager.Vare;

import java.util.ArrayList;

public class DatabaseHandler {

    public static ArrayList<Spild> getSpild() {
        Lager lager = new Lager();
        return lager.getSpild();
    }

    public static ArrayList<Vare> getVare(String vare) {
        Lager lager = new Lager();
        return lager.hentVare(vare);
    }

    public static void registrereSpild(String vare, int mængde) {
        Lager lager = new Lager();
        lager.registrereSpild(vare,mængde);
    }

    public static void registrereBestilteVare(String vare, int mængde) {
        Lager lager = new Lager();
        lager.registrereBestilteVare(vare, mængde);
    }

    public static void opretVare(Vare vare) {
        Lager lager = new Lager();
        lager.opretVare(vare);
    }

    public static void sletVare(String vare) {
        Lager lager = new Lager();
        lager.sletVare(vare);
    }
}
