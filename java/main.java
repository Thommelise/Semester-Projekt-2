import handler.DatabaseHandler;
import medarbejder.Restaurantchef;
import varelager.Vare;

import static javafx.application.Application.launch;

public class main {

    public static void main(String[] args) {
        launch();
        Restaurantchef restaurantchef = new Restaurantchef("Morten","1818181818",19,"RC");

        /*System.out.println(restaurantchef.seSpild());

        Ret retter = new Ret();
        retter.setVarenavn("burger bøf");
        System.out.println(DatabaseHandler.getVare(retter));
        System.out.println(DatabaseHandler.registrereSpild(new Vare("Kylling",20,"kg",100),20));
        System.out.println(DatabaseHandler.registrereBestilteVare(new Vare("burger bøf",20,"kg",150),10));*/



        /*MedarbejderHandler.opretMedarbejder("Oscar", "1020304050", 3, "Restauranchef");*/
        /*MedarbejderHandler.sletMedarbejder("1020304050");*/
        /*System.out.println(MedarbejderHandler.seEnkelMedarbejder("1020304050"));*/

        /*Ret ret = new Ret("burger");
        System.out.println(ret.vareObjekt());*/

        Vare vare = new Vare("testVare",3,"kasse",7);
        DatabaseHandler.sletVare(vare);
    }
}
