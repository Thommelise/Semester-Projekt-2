package main.view.kok;
import main.control.UI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;

public class KokController {
UI ui = new UI();

    @FXML
    void SpildBnt (javafx.event.ActionEvent event) {

        try{

            URL spildBnt = getClass().getResource("RegistererSpild.fxml");
            BorderPane spild = FXMLLoader.load(spildBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(spild);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}

    @FXML
    void registereVareBnt (javafx.event.ActionEvent event) {

        try{

            URL registrereVareBnt = getClass().getResource("RegistrereVare.fxml");
            BorderPane registrereSceen = FXMLLoader.load(registrereVareBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(registrereSceen);
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

    @FXML
    void BestilMad (javafx.event.ActionEvent event) {

        try{

            URL bestilHovedret = getClass().getResource("/main/view/personale/BestilleHovedret.Fxml");
            BorderPane hovedretSceen = FXMLLoader.load(bestilHovedret);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(hovedretSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}
}
