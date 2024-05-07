//package out;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientSide {
    
    private static InetAddress host;

    private static final int PORT = 1234;

    public static void main(String[] args){
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException unknownHostException) {
            System.err.println("Don't know about host!:  " + unknownHostException.getMessage());
            System.exit(-1);
        }
        accessServer();
    }
    private static void accessServer(){
        Socket link = null;
        try {
            link = new Socket(host, PORT);
            Scanner input = new Scanner(link.getInputStream());
            PrintWriter output  =  new PrintWriter(link.getOutputStream(),true);
            Scanner userEntry = new Scanner(System.in);
            String message;
            String response;
            do {
                System.out.println("ENTER MESSage:  ");
                message = userEntry.nextLine();
                output.println(message);
                response = input.nextLine();
                System.out.println("\nRESPONSE > " + response);
            } while(!message.equals("CLoSES"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        finally {
            try{
                System.out.println("\n closing conection...");
                link.close();
            } catch (IOException ioException){
                System.out.println("unable to disconect error : " + ioException.getMessage());
                System.exit(1);
                

            }
        }
    }


}
