package restaurant;

import handler.DatabaseHandler;
import varelager.Vare;


import java.util.ArrayList;

public class Bestilling {

    private String drink;
    private String sideordre;
    private String hovederet;

    public Bestilling(String drink, String sideordre, String hovederet) {
        this.drink = drink;
        this.sideordre = sideordre;
        this.hovederet = hovederet;
    }

    public Bestilling(String hovederet) {
        this.hovederet = hovederet;
    }

    public void lavBestilling() {
        restaurant.Ret ret = new restaurant.Ret(hovederet);
        ret.vareObjekt();
        ArrayList<Vare> alleVare = ret.vareObjekt();
        for (Vare currentVare: alleVare) {
            DatabaseHandler.getVare(currentVare);
        }
    }
}
