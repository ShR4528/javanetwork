import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;




public class Main {

    private static final int PORT = 2082;

    private static DatagramSocket datagramSocket;

    private static DatagramPacket inPacket, ouPacket;

    private static byte[] buffer;

    public static void main(String[] args) throws IOException {

        System.out.println("PORT OPEN ... \n");

        try{
            datagramSocket = new DatagramSocket(PORT);

        } catch(SocketException socketException) {
            System.out.println("Unable to open port : " );
            System.out.println(socketException.getMessage());
            System.out.println(socketException.getMessage());
            System.exit(1);
        }
        handleClient();

    }
    private static void handleClient() {
        try{
            String messageIn;
            int numMessages = 0; // number of messages received from client
            String messageOut;
            InetAddress clientAddress = null;
            int clientPort;
            do {
                buffer = new byte[256];
                inPacket = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(inPacket);

                clientAddress = inPacket.getAddress();
                clientPort = inPacket.getPort();

                messageIn = new String(inPacket.getData(), 0, inPacket.getLength());
                System.out.println("MESSAGE RECEIVED : " + messageIn);
                numMessages++;
                messageOut = "MESSAGE NUM " + numMessages + " : " + messageIn;

                ouPacket = new DatagramPacket(messageOut.getBytes(),messageOut.length(), clientAddress, clientPort);
                datagramSocket.send(ouPacket);
            } while (true);


        } catch (IOException ioException){
            ioException.printStackTrace();
        } 
        finally {
            System.out.println("\n CLOSING THE CONNECTION");
            datagramSocket.close();
        }
    }
        
        // Create a new DatagramSocket with the specified port number (2082)
        //DatagramSocket datagramSocket = new DatagramSocket(2082);

        // Initialize a byte array buffer with a length of 256
       // byte[] buffer = new byte[256];


        // Create a new DatagramPacket with the buffer and its length
       // DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

        // Receive a datagram packet through the datagram socket
        //datagramSocket.receive(datagramPacket);

        // Get the InetAddress of the client from the datagram socket
        //InetAddress clinetAddress = datagramSocket.getInetAddress();

        // Get the port number of the client from the datagram socket
        //String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

         
       // DatagramPacket outPacket = new DatagramPacket(message.getBytes(), message.length(),clinetAddress, datagramPacket.getPort());

       // datagramSocket.send(outPacket);

        //datagramSocket.close();

    

}
