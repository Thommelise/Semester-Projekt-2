package main.view.personale;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import main.control.Client;
import main.control.UI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import main.handler.BestillingHandler;

import java.io.IOException;
import java.net.URL;

public class bestilleHovedRetController {

    @FXML
    private Button Spareribs;

    @FXML
    private Button burger;

    @FXML
    private TextField errorMessage;

    private BestillingHandler bestillingHandler = BestillingHandler.bestilMad();

    @FXML
    void Spareribs (javafx.event.ActionEvent event) {
        try {
            bestillingHandler.tilføjRet(Spareribs.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void burger (javafx.event.ActionEvent event) {
        try {
            bestillingHandler.tilføjRet(burger.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @FXML
    void bestilleDringBnt (javafx.event.ActionEvent event) {

        try{

            URL bestilleDrinkBnt = getClass().getResource("/main/view/personale/BestilleDrink.fxml");
            BorderPane bestilleDrinkSceen = FXMLLoader.load(bestilleDrinkBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(bestilleDrinkSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}

    @FXML
    void bestilleTilbehørBnt (javafx.event.ActionEvent event) {

        try{

            URL bestilleTilbehørBnt = getClass().getResource("/main/view/personale/BestilleTilbehør.fxml");
            BorderPane bestilleTilbehørSceen = FXMLLoader.load(bestilleTilbehørBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(bestilleTilbehørSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}

    @FXML
    void checkoutBnt (javafx.event.ActionEvent event) {

        try{

            URL checkoutBnt = getClass().getResource("/main/view/personale/Checkout.fxml");
            BorderPane checkoutSceen = FXMLLoader.load(checkoutBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(checkoutSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}

    @FXML
    void tilbageBnt(javafx.event.ActionEvent event) {

        if (Client.getStilling().equals("Kok")) {
            try {
                URL tilbageBnt = getClass().getResource("/main/view/kok/kok.fxml");
                BorderPane kokSceen = FXMLLoader.load(tilbageBnt);
                BorderPane borderPane = UI.getRoot();
                borderPane.setCenter(kokSceen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (Client.getStilling().equals("Chef")){
            try {
                URL tilbageBnt = getClass().getResource("/main/view/restaurantchef/RestaurantChef.fxml");
                BorderPane restaurantchefSceen = FXMLLoader.load(tilbageBnt);
                BorderPane borderPane = UI.getRoot();
                borderPane.setCenter(restaurantchefSceen);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
                errorMessage.setText("Ingen tilladelse");
        }
    }

    @FXML
    void logudBnt (javafx.event.ActionEvent event) {

        try{

            URL logudBnt = getClass().getResource("/main/view/personale/Login.fxml");
            BorderPane loginSceen = FXMLLoader.load(logudBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(loginSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}
}
