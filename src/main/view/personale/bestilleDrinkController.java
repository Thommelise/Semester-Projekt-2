package main.view.personale;

import main.control.UI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;

public class bestilleDrinkController {

    @FXML
    void bestilleTilbehørBnt (javafx.event.ActionEvent event) {

        try{

            URL bestilleTilbehørBnt = getClass().getResource("/view/personale/BestilleTilbehør.fxml");
            BorderPane bestilleTilbehørSceen = FXMLLoader.load(bestilleTilbehørBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(bestilleTilbehørSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}

    @FXML
    void logudBnt (javafx.event.ActionEvent event) {

        try{

            URL logudBnt = getClass().getResource("/view/personale/Login.fxml");
            BorderPane loginSceen = FXMLLoader.load(logudBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(loginSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}

    @FXML
    void bestilleHovedretBnt (javafx.event.ActionEvent event) {

        try{

            URL bestilleHovedretBnt = getClass().getResource("/view/personale/BestilleHovedret.fxml");
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

            URL checkoutBnt = getClass().getResource("/view/personale/Checkout.fxml");
            BorderPane checkoutSceen = FXMLLoader.load(checkoutBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(checkoutSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}

}
