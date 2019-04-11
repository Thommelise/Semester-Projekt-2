import handler.ServerHandler;

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
                Socket socket = welcomeSocket.accept();
                System.out.println("Client connected");

                ObjectInputStream inFromClient = new ObjectInputStream(socket.getInputStream());
                String o = (String)inFromClient.readObject();
                System.out.println("recieved: " + o);

                String answer = ServerHandler.toUpperCase(o);

                ObjectOutputStream outToClient = new ObjectOutputStream(socket.getOutputStream());
                outToClient.writeObject(answer);
            }
        } catch (Exception e) {

        }
    }
}
