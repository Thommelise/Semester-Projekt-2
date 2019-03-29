package Handler;

import Varelager.Lager;
import Varelager.Spild;

import java.util.ArrayList;

public class DatabaseHandler {

    public static ArrayList<Spild> getSpild() {
        Lager lager = new Lager();
        return lager.getSpild();
    }
}
