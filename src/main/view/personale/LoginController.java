package main.view.personale;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.control.UI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import main.handler.MedarbejderHandler;

import java.io.IOException;
import java.net.URL;

public class LoginController {


    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField errorMessage;

        @FXML
        void LoginBnt (javafx.event.ActionEvent event) {
            try {
                String stilling = MedarbejderHandler.checkStilling(Integer.parseInt(passwordField.getText()));
                if (stilling.equals("Ugyldig")) {
                    errorMessage.setText("Ugyldig id");
                }
                if (stilling.equals("Kok")) {
                    try {
                        URL kokBnt = getClass().getResource("/main/view/kok/Kok.fxml");
                        BorderPane kokSceen = FXMLLoader.load(kokBnt);
                        BorderPane borderPane = UI.getRoot();
                        borderPane.setCenter(kokSceen);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (stilling.equals("Chef")) {
                    try {
                        URL restaurantChefBnt = getClass().getResource("/main/view/restaurantchef/RestaurantChef.fxml");
                        BorderPane restaurantChefSceen = FXMLLoader.load(restaurantChefBnt);
                        BorderPane borderPane = UI.getRoot();
                        borderPane.setCenter(restaurantChefSceen);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (stilling.equals("Personale")) {
                    try {
                        URL personaleBnt = getClass().getResource("/main/view/personale/BestilleHovedRet.fxml");
                        BorderPane personaleSceen = FXMLLoader.load(personaleBnt);
                        BorderPane borderPane = UI.getRoot();
                        borderPane.setCenter(personaleSceen);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                errorMessage.setText("Skal være din id");
            }
        }
}
