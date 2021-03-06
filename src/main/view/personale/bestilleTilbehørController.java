
package main.view.personale;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import main.control.UI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import main.handler.BestillingHandler;

import java.io.IOException;
import java.net.URL;

public class bestilleTilbehørController {

    @FXML
    private Button OnionRings;

    private BestillingHandler bestillingHandler = BestillingHandler.bestilMad();

    @FXML
    void OnionRings (javafx.event.ActionEvent event) {
        try {
            bestillingHandler.tilføjRet(OnionRings.getId());
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
    void bestilleHovedretBnt (javafx.event.ActionEvent event) {

        try{

            URL bestilleHovedretBnt = getClass().getResource("/main/view/personale/BestilleHovedret.fxml");
            BorderPane HovedretSceen = FXMLLoader.load(bestilleHovedretBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(HovedretSceen);
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

