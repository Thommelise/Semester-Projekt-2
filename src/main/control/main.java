package main.control;

import javafx.application.Application;
import javafx.stage.Stage;
import main.handler.DatabaseHandler;
import main.handler.MedarbejderHandler;
import main.medarbejder.Restaurantchef;
import main.restaurant.Menukort;
import main.varelager.Lager;
import main.varelager.Spild;
import main.varelager.Vare;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static javafx.application.Application.launch;

public class main {

    public static void main(String[] args) {
        /*launch();*/
        /*Restaurantchef restaurantchef = new Restaurantchef("Morten","1818181818",19,"RC");

        System.out.println(restaurantchef.seSpild());*/

        /*Ret retter = new Ret();
        retter.setVarenavn("burger bøf");
        System.out.println(DatabaseHandler.getVare(retter));
        System.out.println(DatabaseHandler.registrereSpild(new Vare("Kylling",20,"kg",100),20));
        System.out.println(DatabaseHandler.registrereBestilteVare(new Vare("burger bøf",20,"kg",150),10));*/



        /*MedarbejderHandler.opretMedarbejder("Oscar", "1020304050", 3, "Restauranchef");*/
        /*MedarbejderHandler.sletMedarbejder("1020304050");*/
        /*System.out.println(MedarbejderHandler.seEnkelMedarbejder("1020304050"));*/

        /*Ret ret = new Ret("burger");
        System.out.println(ret.vareObjekt());*/

        /*Vare vare = new Vare("testVare",3,"kasse",7);
        DatabaseHandler.getVare(vare);*/

        /*Menukort menukort = new Menukort();
        System.out.println(menukort.findVare("Spareribs"));*/

        /*System.out.println(MedarbejderHandler.checkStilling(1));*/

      //  DatabaseHandler.registrereSpild("fisk",20);
        System.out.println(DatabaseHandler.getSpild());
        ArrayList<Spild> spilds = DatabaseHandler.getSpild();
        Spild spild = new Spild("fisk",20);
        System.out.println(Arrays.asList(spilds).contains(spild));
    }
    }

