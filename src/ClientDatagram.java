import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ClientDatagram {

    private static final int PORT = 2082;
    private static DatagramPacket inPacket, outPacket;
    private static DatagramSocket datagramSocket;
    private static InetAddress host;

    private byte[] buffer;

    public static void main(String[] args) {
    try {
        host = InetAddress.getLocalHost();
    } catch (UnknownHostException unknownHostException) {
        System.out.println("Error : " + unknownHostException.getMessage());
        System.exit(1);
    }
    accessServer();

    }
    private static void accessServer(){
        try {
            datagramSocket = new DatagramSocket();
            Scanner userEntry = new Scanner(System.in);
            String message = "";
            String response = "";

            do {

            } while(!message.equals("CLOSE"));  

        } catch (Exception e) {
            
        }
    }
}
