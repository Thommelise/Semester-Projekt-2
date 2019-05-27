package main.view.personale;

import javafx.scene.control.Button;
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
    void Spareribs (javafx.event.ActionEvent event) {
        try {
            BestillingHandler bestillingHandler = BestillingHandler.bestilMad();
            bestillingHandler.tilføjRet(Spareribs.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void burger (javafx.event.ActionEvent event) {
        try {
            BestillingHandler bestillingHandler = BestillingHandler.bestilMad();
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


}
