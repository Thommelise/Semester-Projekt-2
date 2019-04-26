package view.kok;
import control.UI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import java.io.IOException;
import java.net.URL;

public class KokController {
UI ui = new UI();

    @FXML
    void  SpildBnt (javafx.event.ActionEvent event) {

        try{

            URL spildBnt = getClass().getResource("RegistererSpild.fxml");
            BorderPane spild = FXMLLoader.load(spildBnt);
            BorderPane borderPane = UI.getRoot();
            borderPane.setCenter(spild);
        }
        catch (IOException e) {
            e.printStackTrace();
        }}

}
