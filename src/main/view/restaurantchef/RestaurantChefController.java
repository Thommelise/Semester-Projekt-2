package main.view.restaurantchef;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import main.control.UI;

import java.io.IOException;
import java.net.URL;

public class RestaurantChefController {

    @FXML
    void administrereAnsatteBnt (javafx.event.ActionEvent event) {

        try{

            URL administrereAnsatteBnt = getClass().getResource("/main/view/restaurantchef/AdministrereAnsatte.fxml");
            BorderPane administrereAnsatteSceen = FXMLLoader.load(administrereAnsatteBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(administrereAnsatteSceen);
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
    void bestilMadBnt (javafx.event.ActionEvent event) {

        try{

            URL tilbageBnt = getClass().getResource("/main/view/personale/bestilleHovedRet.fxml");
            BorderPane kokSceen = FXMLLoader.load(tilbageBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(kokSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}

    @FXML
    void ændreSortimentBnt (javafx.event.ActionEvent event) {

        try{

            URL tilbageBnt = getClass().getResource("/main/view/restaurantchef/ÆndreSortiment.fxml");
            BorderPane kokSceen = FXMLLoader.load(tilbageBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(kokSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}


    @FXML
    void seSpildbnt (javafx.event.ActionEvent event) {

        try{

            URL tilbageBnt = getClass().getResource("/main/view/restaurantchef/SeSpild.fxml");
            BorderPane kokSceen = FXMLLoader.load(tilbageBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(kokSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}

    @FXML
    void registrereSpildBnt (javafx.event.ActionEvent event) {

        try{

            URL spildBnt = getClass().getResource("/main/view/kok/RegistererSpild.fxml");
            BorderPane spild = FXMLLoader.load(spildBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(spild);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}

    @FXML
    void registrereVareBnt (javafx.event.ActionEvent event) {

        try{

            URL registrereVareBnt = getClass().getResource("/main/view/kok/RegistrereVare.fxml");
            BorderPane registrereSceen = FXMLLoader.load(registrereVareBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(registrereSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}
}
