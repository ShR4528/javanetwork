package com.company;

import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException{
        String web = "https://en.wikipedia.org/wiki/URL#Citations";

        URL myUrl = new URL(web);

        getURL(myUrl);


    }
    static void getURL(URL url){
        System.out.println("PATH = " +  url.getPath());
        System.out.println("Host = " + url.getHost());
        System.out.println("REF = " + url.getRef());
        
    }
}
