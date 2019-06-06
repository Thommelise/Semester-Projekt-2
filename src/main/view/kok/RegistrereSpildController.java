package main.view.kok;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import main.control.Client;
import main.control.UI;
import main.handler.DatabaseHandler;
import javafx.scene.control.TextField;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class RegistrereSpildController {

    @FXML
    private TextField varenavn;

    @FXML
    private TextField antal;

    private DatabaseHandler databaseHandler = DatabaseHandler.initDatabaseHandler();

    @FXML
    void tilføjSpild(javafx.event.ActionEvent event) {
        try {
            databaseHandler.registrereSpild(varenavn.getText(),Integer.parseInt(antal.getText()));

        } catch (Exception e) {
            varenavn.setText("Skal være bogstaver");
            antal.setText("Skal være nummer");
        }
    }

    @FXML
    void tilbageBnt (javafx.event.ActionEvent event) {
        if (Client.getStilling().equals("Kok")) {
            try {
                URL tilbageBnt = getClass().getResource("/main/view/kok/kok.fxml");
                BorderPane kokSceen = FXMLLoader.load(tilbageBnt);
                BorderPane borderPane = UI.getRoot();
                borderPane.setCenter(kokSceen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                URL tilbageBnt = getClass().getResource("/main/view/restaurantchef/RestaurantChef.fxml");
                BorderPane restaurantchefSceen = FXMLLoader.load(tilbageBnt);
                BorderPane borderPane = UI.getRoot();
                borderPane.setCenter(restaurantchefSceen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
