package com.company;

import java.net.URI;
import java.net.*;
import java.net.URISyntaxException;
import java.net.UnknownHostException;


public class Main4 {
    public static void  main4(String[] args) throws UnknownHostException, URISyntaxException{

        String website = "https://techbiz.com/ecu-ecm-power-management/";
        URI webURI = new URI("https","techbinz.com","ecu-ecm-power-management");
        getURI(webURI)
    }
    static void getURI(URI myUri){
        System.out.println(myUri, getAuthority());
        System.out.println(myUri,getPath());
        System.out.println(myUri,getHost());
        System.out.println(myUri,getPort());


    }
}


