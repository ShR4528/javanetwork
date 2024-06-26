import java.io.IOException;
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

    private static byte[] buffer;

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
                System.out.println("Enter a message : ");
                message = userEntry.nextLine();
                if (!message.equals("CLOSE")){
                    outPacket = new DatagramPacket(message.getBytes(),message.length(),host,PORT);
                    datagramSocket.send(outPacket);
                    buffer = new byte[256];
                    inPacket = new DatagramPacket(buffer,buffer.length);
                    datagramSocket.receive(inPacket);
                    response = new String(inPacket.getData(),0,inPacket.getLength());
                    System.out.println("\n SERVER Response > " + response);
                    System.out.println("MESSAGE : " + message);
                }

            } while(!message.equals("CLOSE"));  

        } catch (IOException ioException) {
            ioException.printStackTrace();
            System.out.println("Error : " + ioException.getMessage());
            } finally {
                System.out.println("\n CLOSING THE CONNECTION...");
                datagramSocket.close();
            }
    }
}
