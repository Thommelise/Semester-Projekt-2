package main.view.personale;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.control.Client;
import main.control.UI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import main.handler.MedarbejderHandler;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

public class LoginController {


    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField errorMessage;

    @FXML
    private Button closeBtn;

    private MedarbejderHandler medarbejderHandler = MedarbejderHandler.initMedarbejderHandler();

        @FXML
        void LoginBnt (javafx.event.ActionEvent event) {
            try {
                String stilling = medarbejderHandler.checkStilling(Integer.parseInt(passwordField.getText()));
                if (stilling.equals("Ugyldig")) {
                    errorMessage.setText("Ugyldig id");
                }
                if (stilling.equals("Kok")) {
                    try {
                        Client.setStilling("Kok");
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
                        Client.setStilling("Chef");
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
                        Client.setStilling("Personale");
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

    @FXML
    void closeApp (javafx.event.ActionEvent event) {

        Stage stage = (Stage) closeBtn.getScene().getWindow();
        stage.close();
    }
}
