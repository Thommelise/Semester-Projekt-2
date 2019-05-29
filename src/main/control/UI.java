package main.control;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
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

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws IOException {


        URL loginUrl = getClass().getResource("/main/view/personale/Login.fxml");
        BorderPane loginSceen = FXMLLoader.load(loginUrl);


        root.setCenter(loginSceen);


        Scene scene = new Scene(root, 740, 520);

        primaryStage.setTitle("");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();

        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

    }
}
