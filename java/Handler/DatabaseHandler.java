package Handler;

import Restaurant.Ret;
import Varelager.Lager;
import Varelager.Spild;
import Varelager.Vare;

import java.util.ArrayList;

public class DatabaseHandler {

    public static ArrayList<Spild> getSpild() {
        Lager lager = new Lager();
        return lager.getSpild();
    }

    public static ArrayList<Vare> getVare(Ret ret) {
        Lager lager = new Lager();
        return lager.hentVare(ret);
    }
}
