package main.view.restaurantchef;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import main.control.UI;
import main.handler.DatabaseHandler;

import java.io.IOException;
import java.net.URL;

public class ÆndreSortimentController {

    @FXML
    private TextField varenavn;

    private DatabaseHandler databaseHandler = DatabaseHandler.initDatabaseHandler();

    @FXML
    void sletVare(javafx.event.ActionEvent event) {
        try {

            if (databaseHandler.sletVare(varenavn.getText())) {
                varenavn.clear();
            }
        } catch (Exception e) {
            varenavn.setText("Skal være bogstaver");
        }
    }

    @FXML
    void tilføjVareBnt (javafx.event.ActionEvent event) {

        try{

            URL tilbageBnt = getClass().getResource("/main/view/restaurantchef/TilføjVare.fxml");
            BorderPane kokSceen = FXMLLoader.load(tilbageBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(kokSceen);
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
