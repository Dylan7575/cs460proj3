import java.io.*;
import java.net.Socket;
import java.lang.*;
/**
 * Created by Dylan on 10/6/2016.
 */
public class WorkerRunnable implements Runnable {
    protected Socket clientSocket = null;
    public WorkerRunnable(Socket clientSocket){
        this.clientSocket=clientSocket;
    }
    public void run(){
        try {
            Reader ClientStream = new InputStreamReader(clientSocket.getInputStream());
            PrintWriter clientWriter = new PrintWriter(clientSocket.getOutputStream());
            try {
                characterReader(ClientStream);
            }
            catch(Exception err){
                System.out.println("y");
            }

        }
        catch(IOException err){
            System.out.println("IO error");
        }
    }
    public char[] characterReader (Reader stream)throws Exception{
        int length= clientSocket.getInputStream().available();
        char[] arr = new char[length];
        System.out.println(length);
        try{
            int f =stream.read();
             arr[0]=Character.forDigit(f,10);
        }
        catch(IOException err){
            System.out.println("error with input stream");
        }
        return arr;



    }

}
