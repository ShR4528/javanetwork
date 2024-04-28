import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    
    public static void main(String[] args) throws UnknownHostException {
        
       InetAddress oscalyWebsite = InetAddress.getByName("www.ocsaly.com");
        System.out.println(oscalyWebsite);
     
}
}