import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;




public class Main {
     // Port number on which the server will listen for incoming packets
    private static final int PORT = 2082;

     // DatagramSocket for sending and receiving UDP packets
    private static DatagramSocket datagramSocket;

    // DatagramPackets for receiving and sending data
    private static DatagramPacket inPacket, outPacket;

     // Buffer for storing incoming data
    private static byte[] buffer;

    public static void main(String[] args) throws IOException {

        System.out.println("PORT OPEN ... \n");

        try{
            // Create a new DatagramSocket bound to the specified port
            datagramSocket = new DatagramSocket(PORT);

        } catch(SocketException socketException) {
            System.out.println("Unable to open port : " );
            System.out.println(socketException.getMessage());
            System.out.println(socketException.getMessage());
            System.exit(1);
        }
          // Start handling client requests
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
                // Create a new buffer for incoming data
                buffer = new byte[256];

                // Create a new DatagramPacket for receiving data
                inPacket = new DatagramPacket(buffer, buffer.length);

                // Receive data from the client
                datagramSocket.receive(inPacket);


                // Get the client's address and port
                clientAddress = inPacket.getAddress();
                clientPort = inPacket.getPort();

                 // Convert the received data to a string
                messageIn = new String(inPacket.getData(), 0, inPacket.getLength());
                System.out.println("MESSAGE RECEIVED : " + messageIn);
                numMessages++;

                // Prepare the response message
                messageOut = "MESSAGE NUM " + numMessages + " : " + messageIn;

                 // Create a new DatagramPacket for sending data back to the client
                outPacket = new DatagramPacket(messageOut.getBytes(),messageOut.length(), clientAddress, clientPort);

                // Send the response back to the client
                datagramSocket.send(outPacket);
            } while (true);


        } catch (IOException ioException){
            ioException.printStackTrace();
        } 
        finally {
            System.out.println("\n CLOSING THE CONNECTION");

            // Close the DatagramSocket
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
