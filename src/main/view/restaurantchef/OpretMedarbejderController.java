package main.view.restaurantchef;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import main.handler.MedarbejderHandler;

public class OpretMedarbejderController {

    @FXML
    private TextField navn;

    @FXML
    private TextField cprNummer;

    @FXML
    private TextField id;

    @FXML
    private TextField stilling;

    @FXML
    void tilføjMedarbejder(javafx.event.ActionEvent event) {
        try {

            MedarbejderHandler.opretMedarbejder(navn.getText(),cprNummer.getText(),Integer.parseInt(id.getText()),stilling.getText());
            navn.clear();
            cprNummer.clear();
            id.clear();
            stilling.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
