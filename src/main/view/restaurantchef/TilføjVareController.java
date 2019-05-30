package main.view.restaurantchef;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.handler.DatabaseHandler;
import main.varelager.Vare;

public class TilføjVareController {

    @FXML
    private TextField varenavn;

    @FXML
    private TextField antal;

    @FXML
    private TextField enhed;

    @FXML
    private TextField pris;

    private DatabaseHandler databaseHandler = DatabaseHandler.initDatabaseHandler();

    @FXML
    void tilføjVare(javafx.event.ActionEvent event) {
        try {
            Vare vare = new Vare(varenavn.getText(),enhed.getText(),Integer.parseInt(pris.getText()));
            if (databaseHandler.opretVare(vare,Integer.parseInt(antal.getText()))) {
                varenavn.clear();
                antal.clear();
                enhed.clear();
                pris.clear();
            }
        } catch (Exception e) {
            varenavn.setText("Skal være bogstaver");
            antal.setText("Skal være tal");
            enhed.setText("Skal være bogstaver");
            pris.setText("skal være tal");
        }
    }
}
