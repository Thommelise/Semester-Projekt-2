package main.handler;

public class ServerHandler {

    private static ServerHandler objServer = null;

    public synchronized static ServerHandler initDatabaseHandler(){
        if(objServer == null) {
            objServer = new ServerHandler();
        }
        return objServer;
    }

    public static String toUpperCase(String answer){
        return answer.toUpperCase();
    }
}
