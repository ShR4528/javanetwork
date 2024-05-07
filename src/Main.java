import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;



public class Main {
    public static void main(String[] args) throws IOException {

        // Create a new DatagramSocket with the specified port number (2082)
        DatagramSocket datagramSocket = new DatagramSocket(2082);

          // Initialize a byte array buffer with a length of 256
        byte[] buffer = new byte[256];


        // Create a new DatagramPacket with the buffer and its length
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);

        // Receive a datagram packet through the datagram socket
        datagramSocket.receive(datagramPacket);

        // Get the InetAddress of the client from the datagram socket
        InetAddress clinetAddress = datagramSocket.getInetAddress();

        // Get the port number of the client from the datagram socket
        String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

         
        DatagramPacket outPacket = new DatagramPacket(message.getBytes(), message.length(),clinetAddress, datagramPacket.getPort());

        datagramSocket.send(outPacket);

        datagramSocket.close();

    
    }
}
