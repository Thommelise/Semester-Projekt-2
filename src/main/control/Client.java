package main.control;

import javafx.application.Application;

import java.net.Socket;


import static javafx.application.Application.launch;

public class Client {

    //Stilling bliver brugt til at se hvilket GUI der skal loades
    private static String stilling;
    public static void main(String[] args) {
        UI ui = new UI();
        try {
            //Clienten tilkobler sig serveren
            Socket socket = new Socket("localhost", 2910);
            //Client starter UIen
            Application.launch(ui.getClass());


        } catch (Exception e) {

        }


    }

    public static String getStilling() {
        return stilling;
    }

    public static void setStilling(String stilling) {
        Client.stilling = stilling;
    }
}
