package main.restaurant;

import main.varelager.Vare;

import java.util.ArrayList;
import java.util.HashMap;

public class Ret {

    private String retnavn;
    private ArrayList<Vare> retter = new ArrayList<Vare>();
    private HashMap<Integer, Vare> ret;
    private Menukort menukort = new Menukort();

    public Ret(String retnavn) {
        this.retnavn = retnavn;
    }

    public String getVarenavn() {
        return retnavn;
    }

    public void setVarenavn(String retnavne) {
        retnavn = retnavne;
    }

    public ArrayList<String> fåVare(String retnavn) {
        return menukort.findVare(retnavn);
    }

    public ArrayList<Vare> vareObjekt () {
        ArrayList<String> antalVare = fåVare(this.retnavn);
        ArrayList<Vare> VareObjekter = new ArrayList<Vare>();
        for (int i = 0; i < antalVare.size(); i++) {
            VareObjekter.add(menukort.tilObjekt(antalVare.get(i)));
        }
        return VareObjekter;
    }

    public ArrayList<String> test() {
        ArrayList<String> antalVare = fåVare(this.retnavn);
        for (int i = 0; i < antalVare.size(); i++) {
            System.out.println(antalVare.get(i));
        }
        return null;
    }
}
