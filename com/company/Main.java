import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(1092);


        Socket link = serverSocket.accept();
        Scanner input = new Scanner(link.getInputStream());
        PrintWriter output = new PrintWriter(link.getOutputStream());

        output.println("awaiting for data ...");
        String myinput =  input.nextLine();

        link.close();
     }
}
