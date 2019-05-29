package main.view.restaurantchef;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.handler.DatabaseHandler;
import main.varelager.Spild;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class SeSpildController implements Initializable {

    @FXML
    private TableView seSpild;

    @FXML
    private TableColumn<Spild, String> Varenavn;

    @FXML
    private TableColumn<Spild, Integer> Antal;



    @FXML
    void insetSpild() {

    }

    DatabaseHandler databaseHandler = DatabaseHandler.initDatabaseHandler();

    @Override
    public void initialize(URL url, ResourceBundle rb){
        Varenavn.setCellValueFactory(new PropertyValueFactory<Spild, String>("Varenavn"));
        Antal.setCellValueFactory(new PropertyValueFactory<Spild, Integer>("Antal"));

        seSpild.setItems(getSpild());
    }

    public ObservableList<Spild> getSpild() {
        ObservableList<Spild> spilds = FXCollections.observableArrayList();
        ArrayList<Spild> databaseSpild = databaseHandler.getSpild();

        for (int i = 0; i < databaseSpild.size(); i++) {
            spilds.add(databaseSpild.get(i));
        }

        return spilds;
    }
}
