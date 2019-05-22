package main.view.restaurantchef;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class SeSpildController implements Initializable {

    @FXML
    private TableView seSpild;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TableColumn Varenavn = new TableColumn("Varenavn");
        TableColumn Antal = new TableColumn("Antal");
        TableColumn Pris = new TableColumn("Pris");
        TableColumn PrisIAlt = new TableColumn("Pris i alt");

        seSpild.getColumns().addAll(Varenavn,Antal,Pris,PrisIAlt);


    }
}
