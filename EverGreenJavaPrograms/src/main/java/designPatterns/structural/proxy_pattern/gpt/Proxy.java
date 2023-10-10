package designPatterns.structural.proxy_pattern.gpt;

import java.util.HashSet;
import java.util.Set;

//The Subject interface
interface Internet {
 public void connectTo(String serverhost) throws Exception;
}

//The RealSubject class
class RealInternet implements Internet {
 public void connectTo(String serverhost) throws Exception {
     System.out.println("Connecting to " + serverhost);
 }
}

//The Proxy class
class InternetProxy implements Internet {
 private Internet internet = new RealInternet();
 private Set<String> bannedSites = new HashSet<String>();

 public InternetProxy() {
     bannedSites.add("www.facebook.com");
     bannedSites.add("www.youtube.com");
     bannedSites.add("www.twitter.com");
 }

 public void connectTo(String serverhost) throws Exception {
     if (bannedSites.contains(serverhost.toLowerCase())) {
         throw new Exception("Access Denied");
     }

     internet.connectTo(serverhost);
 }
}

//Example usage
public class Proxy {
 public static void main(String[] args) {
     Internet internet = new InternetProxy();

     try {
         internet.connectTo("www.google.com");
         internet.connectTo("www.facebook.com");
     } catch (Exception e) {
         System.out.println(e.getMessage());
     }
 }
}
