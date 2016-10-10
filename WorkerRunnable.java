import java.io.*;
import java.net.Socket;
import java.lang.*;
/**
 * Created by Dylan on 10/6/2016.
 */
public class WorkerRunnable implements Runnable {
    protected Socket clientSocket = null;

    public WorkerRunnable(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        String output = "echo";
        try {
            Reader clientStream = new InputStreamReader(clientSocket.getInputStream());
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(),true);
            writer.println("type ^ to end the connection to the server");
            while (true) {
                char arr[]=new char[1];
                int done =clientStream.read(arr);
                if (arr[0]=='^') {
                    writer.println("Client Disconnected");
                    System.out.println("Client Disconnected");
                    clientSocket.close();
                    break;
                }
                System.out.print(arr);
                writer.printf("%c",arr[0]);
            }
        } catch (IOException err) {
            System.out.println("IO error");
        }
    }
}
