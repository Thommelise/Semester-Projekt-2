package main.view.kok;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import main.control.UI;
import main.handler.DatabaseHandler;
import javafx.scene.control.TextField;
import main.varelager.Vare;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

public class RegistrereVareController {

    @FXML
    private TextField varenavn;

    @FXML
    private TextField antal;

    private DatabaseHandler databaseHandler = DatabaseHandler.initDatabaseHandler();

    @FXML
    void registrereVarer(javafx.event.ActionEvent event) {
        try {
            databaseHandler.registrereBestilteVare(varenavn.getText(), Integer.parseInt(antal.getText()));
            varenavn.clear();
            antal.clear();
        } catch (Exception e) {
            varenavn.setText("Skal være bogstaver");
            antal.setText("Skal være nummer");
        }
    }

    @FXML
    void tilbageBnt (javafx.event.ActionEvent event) {

        try{

            URL tilbageBnt = getClass().getResource("/main/view/kok/Kok.fxml");
            BorderPane kokSceen = FXMLLoader.load(tilbageBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(kokSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}
}
