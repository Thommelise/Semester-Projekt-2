package main.view.personale;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import main.control.UI;

import java.io.IOException;
import java.net.URL;

public class KnappeController {

   public void logudBnt (javafx.event.ActionEvent event) {

        try{

            URL logudBnt = getClass().getResource("/main/view/personale/Login.fxml");
            BorderPane loginSceen = FXMLLoader.load(logudBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(loginSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}


};



