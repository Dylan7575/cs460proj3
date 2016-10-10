import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Dylan on 10/6/2016.
 */
public class JavaServer {
    private static int port = 23666;
    private static ServerSocket serversocket;


    public static void main(String[] args) throws Exception{
        JavaServer.serversocket = new ServerSocket(port);
        System.out.printf("Server Started\n");
        Socket clientSocket=null;
        while(true){
            clientSocket=serversocket.accept();
            if(clientSocket!=null){
                System.out.println("Client accepted");
            }
            (new Thread(new WorkerRunnable(clientSocket))).start();

        }
    }
}