import sun.security.provider.ConfigFile;

import java.util.ArrayList;

public class Restaurantchef extends Ansat{


    public Restaurantchef(String navn, int cpr, int id, String stilling) {
        super(navn, cpr, id, stilling);
    }

    public void administrereMedarbejder() {

    }

    public ArrayList<Spild> seSpild() {
        return DatabaseHandler.getSpild();
    }

    public Spild sortereSpild() {
        return null;
    }
}
