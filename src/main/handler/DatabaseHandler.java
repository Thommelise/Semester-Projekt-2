package main.handler;


import main.varelager.Lager;
import main.varelager.Spild;
import main.varelager.Vare;

import java.util.ArrayList;

public class DatabaseHandler {

    private static DatabaseHandler objDatabase = null;

    public synchronized static DatabaseHandler initDatabaseHandler(){
        if(objDatabase == null) {
            objDatabase = new DatabaseHandler();
        }
        return objDatabase;
    }

    public synchronized ArrayList<Spild> getSpild() {
        Lager lager = new Lager();
        return lager.getSpild();
    }

    public synchronized void getVare(String vare, double antal) {
        Lager lager = new Lager();
        lager.hentVare(vare,antal);
    }

    public synchronized void registrereSpild(String vare, int mængde) {
        Lager lager = new Lager();
        lager.registrereSpild(vare,mængde);
    }

    public synchronized void registrereBestilteVare(String vare, int mængde) {
        Lager lager = new Lager();
        lager.registrereBestilteVare(vare, mængde);
    }

    public synchronized boolean opretVare(Vare vare, int antal) {
        Lager lager = new Lager();
        return lager.opretVare(vare, antal);
    }

    public synchronized boolean sletVare(String vare) {
        Lager lager = new Lager();
        return lager.sletVare(vare);
    }
}
