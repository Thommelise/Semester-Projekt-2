package view.personale;

import control.UI;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class LoginController {
    UI ui = new UI();
BorderPane borderPane;

    @FXML
    void LoginBnt (javafx.event.ActionEvent event) {

        try{

            URL loginBnt = getClass().getResource("../kok/kok.fxml");
            BorderPane kokSceen = FXMLLoader.load(loginBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(kokSceen);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}




}
