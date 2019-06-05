package main.control;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        System.out.println("starting server...");

        try{
            ServerSocket welcomeSocket = new ServerSocket(2910);

            while (true) {
                //Venter på clienter
                Socket socket = welcomeSocket.accept();
                System.out.println("Client connected");


            }
        } catch (Exception e) {

        }
    }
}
