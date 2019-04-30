package main.control;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;



import java.io.IOException;
import java.net.URL;

public class UI extends Application {



    private static BorderPane root = new BorderPane();

    public static BorderPane getRoot() {
        return root;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {


        URL loginUrl = getClass().getResource("/view/personale/Login.fxml");
        BorderPane loginSceen = FXMLLoader.load(loginUrl);


        root.setCenter(loginSceen);


        Scene scene = new Scene(root, 740, 520);

        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

    }
}
