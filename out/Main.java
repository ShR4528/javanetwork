import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.Scanner;

public class Main {

    private static ServerSocket serverSocket;

    private static final int PORT = 1234;
   public static void main(String[] args){

    System.out.println("OPENING PORT " +  PORT + "\n");
    try {
        serverSocket = new ServerSocket(PORT); // STEP 1
    } catch (IOException ioException) {
        System.out.println("UNABLE TO ATTACH TO PORT !Exceptiom :" + ioException.getMessage());
        System.exit(1);
    }
    do{
        handleClient();
    } while(true);
}


    private static void handleClient(){
    Socket link = null;
    try {
        link = serverSocket.accept();

        Scanner input = new Scanner(link.getInputStream());
        PrintWriter output  =  new PrintWriter(link.getOutputStream(),true);

        int numMessages = 0;
        String message = input.nextLine();
        while(!message.equals("CLoSES")) {
            System.out.println("MESSAGE RECEIVED : " + message);
            numMessages++;
            output.println("MESSAGE NUM " +  numMessages + " : " + message);
            message = input.nextLine();
           
        }
        output.println(numMessages +  " messages received ");
    } catch (IOException ioException) {
        ioException.printStackTrace();
        System.out.println(ioException.getMessage());
        }
        finally {
            try {
                System.out.println("\n* closing connection.....");
                link.close();
            } catch (IOException e){
                System.out.println("unable to disconnect  : "  + e.getMessage());
                System.exit(1);
            
            }
        }
    
   
}
   

}
