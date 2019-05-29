package main.view.restaurantchef;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import main.control.UI;
import main.handler.MedarbejderHandler;

import java.io.IOException;
import java.net.URL;

public class OpretMedarbejderController {

    @FXML
    private TextField navn;

    @FXML
    private TextField cprNummer;

    @FXML
    private TextField id;

    @FXML
    private TextField stilling;

    private MedarbejderHandler medarbejderHandler = MedarbejderHandler.initMedarbejderHandler();

    @FXML
    void tilføjMedarbejder(javafx.event.ActionEvent event) {
        try {
            if (medarbejderHandler.opretMedarbejder(navn.getText(),cprNummer.getText(),Integer.parseInt(id.getText()),stilling.getText())) {

                navn.clear();
                cprNummer.clear();
                id.clear();
                stilling.clear();
            } else {
                navn.setText("Skal være bogstaver");
                cprNummer.setText("Skal være tal");
                id.setText("skal være tal");
                stilling.setText("Skal være bogstaver");
            }
        } catch (Exception e) {
            navn.setText("Skal være bogstaver");
            cprNummer.setText("Skal være tal");
            id.setText("skal være tal");
            stilling.setText("Skal være bogstaver");
        }
    }

    @FXML
    void tilbageBnt (javafx.event.ActionEvent event) {

        try{

            URL tilbageBnt = getClass().getResource("/main/view/restaurantchef/AdministrereAnsatte.fxml");
            BorderPane kokSceen = FXMLLoader.load(tilbageBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(kokSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}
}
