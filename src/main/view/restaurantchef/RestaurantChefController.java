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



}
