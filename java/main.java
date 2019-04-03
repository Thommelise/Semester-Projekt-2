import Handler.DatabaseHandler;
import Medarbejder.Restaurantchef;
import Restaurant.Ret;
import Varelager.Spild;
import Varelager.Vare;

public class main {

    public static void main(String[] args) {
        Restaurantchef restaurantchef = new Restaurantchef("Morten",181818,19,"RC");

        System.out.println(restaurantchef.seSpild());

        Ret retter = new Ret();
        retter.setVarenavn("burger bøf");
        System.out.println(DatabaseHandler.getVare(retter));
        System.out.println(DatabaseHandler.registrereSpild(new Vare("Kylling",20,"kg",100),20));
        System.out.println(DatabaseHandler.registrereBestilteVare(new Vare("burger bøf",20,"kg",150),10));
    }
}
