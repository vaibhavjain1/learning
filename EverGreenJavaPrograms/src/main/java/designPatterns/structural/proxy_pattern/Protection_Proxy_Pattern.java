package designPatterns.structural.proxy_pattern;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/proxy-design-pattern/
class Proxy_Pattern {
	
	private static List<String> bannedSites;
    
    static
    {
        bannedSites = new ArrayList<String>();
        bannedSites.add("abc.com");
        bannedSites.add("def.com");
        bannedSites.add("ijk.com");
        bannedSites.add("lnm.com");
    }
	
    public void connectTo(String serverhost) throws Exception
    {
        if(bannedSites.contains(serverhost.toLowerCase()))
        {
            throw new Exception("Access Denied");
        }
          
        new URL(serverhost).openConnection();
    }
}

public class Protection_Proxy_Pattern {

	public static void main(String[] args) {
		Proxy_Pattern internet = new Proxy_Pattern();
        try
        {
            internet.connectTo("geeksforgeeks.org");
            internet.connectTo("abc.com");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
	}

}
