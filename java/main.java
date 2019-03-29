import Handler.DatabaseHandler;
import Medarbejder.Restaurantchef;
import Restaurant.Ret;

public class main {

    public static void main(String[] args) {
        Restaurantchef restaurantchef = new Restaurantchef("Morten",181818,19,"RC");

        System.out.println(restaurantchef.seSpild());

        Ret retter = new Ret();
        retter.setVarenavn("burgerboller");
        System.out.println(DatabaseHandler.getVare(retter));
    }
}
