package main.restaurant;

import main.varelager.Vare;

import java.util.ArrayList;
import java.util.HashMap;

public class Ret {

    private String retnavn;
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


}
