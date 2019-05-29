package main.medarbejder;

import main.handler.DatabaseHandler;
import main.varelager.Spild;

import java.util.ArrayList;

public class Restaurantchef extends Ansat {

    private DatabaseHandler databaseHandler = DatabaseHandler.initDatabaseHandler();

    public Restaurantchef(String navn, String cpr, int id, String stilling) {
        super(navn, cpr, id, stilling);
    }

    public void administrereMedarbejder() {

    }

    public ArrayList<Spild> seSpild() {
        return databaseHandler.getSpild();
    }

    public Spild sortereSpild() {
        return null;
    }
}
