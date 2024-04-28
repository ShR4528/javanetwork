import java.io.IOException;
import java.net.InetAddress;


public class Main {
    
    public static void main(String[] args) throws IOException {
        
       InetAddress oscaly = InetAddress.getByName("www.ocsaly.com");
       System.out.println("Host Address: " + oscaly.getHostAddress());
       System.out.println("Host Name: " + oscaly.getHostName());
       System.out.println("Canonical Host Name: " + oscaly.getCanonicalHostName());
       oscaly.isReachable(10000); // 10 seconds timeout
        

     
}
}