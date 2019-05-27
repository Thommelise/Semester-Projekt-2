package main.view.restaurantchef;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import main.control.UI;
import main.handler.MedarbejderHandler;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class AdministrereAnsatteController {

    @FXML
    private TextField cprNummer;

    @FXML
    void fjernMedarbejder(javafx.event.ActionEvent event) {
        try {
            if (MedarbejderHandler.sletMedarbejder(cprNummer.getText())) {

                cprNummer.setText("");
            } else {
                cprNummer.setText("Ugyldig CPR.");
            }
        } catch (Exception e) {
            cprNummer.setText("Skal være tal");
        }
    }

    @FXML
    void opretMedarbejderBnt (javafx.event.ActionEvent event) {

        try{

            URL opretMedarbejderBnt = getClass().getResource("/main/view/restaurantchef/OpretMedarbejder.fxml");
            BorderPane opretMedarbejderSceen = FXMLLoader.load(opretMedarbejderBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(opretMedarbejderSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}

    @FXML
    void tilbageBnt (javafx.event.ActionEvent event) {

        try{

            URL tilbageBnt = getClass().getResource("/main/view/restaurantchef/RestaurantChef.fxml");
            BorderPane kokSceen = FXMLLoader.load(tilbageBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(kokSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}
}
