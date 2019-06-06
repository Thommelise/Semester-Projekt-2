package main.view.restaurantchef;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import main.control.UI;
import main.handler.DatabaseHandler;
import main.varelager.Vare;

import java.io.IOException;
import java.net.URL;

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

