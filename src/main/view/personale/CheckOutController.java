package main.view.personale;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import main.control.UI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import main.handler.BestillingHandler;
import main.handler.DatabaseHandler;
import main.restaurant.Menukort;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class CheckOutController {

    @FXML
    private TextArea kvittering;

    @FXML
    void initialize(){
        BestillingHandler bestillingHandler = BestillingHandler.bestilMad();
        kvittering.setText(bestillingHandler.getRet().toString());
    }

      @FXML
    void bestilleDrinkBnt (javafx.event.ActionEvent event) {

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
    void bekæftBestilling (javafx.event.ActionEvent event) {

        try {
            BestillingHandler bestillingHandler = BestillingHandler.bestilMad();
            Menukort menukort = new Menukort();
            ArrayList<String> ingredienser = new ArrayList<>();
            for (int i = 0; i < bestillingHandler.ret.size(); i++) {
                ingredienser = menukort.findVare(bestillingHandler.ret.get(i));
                for (int j = 0; j < ingredienser.size(); j++) {
                    DatabaseHandler.getVare(ingredienser.get(j));
                }
            }


            bestillingHandler.sletRet();
            kvittering.clear();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void sletBestilling (javafx.event.ActionEvent event) {

        try {
            BestillingHandler bestillingHandler = BestillingHandler.bestilMad();
            bestillingHandler.sletRet();
            kvittering.clear();
        }
        catch (Exception e) {
            e.printStackTrace();
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
