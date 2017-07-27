package server.restClient;

import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.client.WebClient;

public class CxfRestClient {

	static final String REST_URI = "http://localhost/apache-cxf-sample/";
	static final String GET_ALL_PATH = "";
    static final String ADD_PATH = "rservice/accountservice";
    static final String SUB_PATH = "calc/sub";
    static final String MUL_PATH = "calc/mul";
    static final String DIV_PATH = "calc/div";
     
    public static void main(String[] args) {
        String a = "accounts";
        int b = 1;
        String s = "";
        
        /*WebClient xmlAddClient = WebClient.create(REST_URI);
        xmlAddClient.path(ADD_PATH).path(a + "/" + b).accept("text/xml");
        s = xmlAddClient.get(String.class);
        System.out.println(s);*/
        
        WebClient xmlAddClientgetall = WebClient.create(REST_URI);
        xmlAddClientgetall.path(ADD_PATH).path("accounts" + "/" + "getall").accept("text/xml");
        Response s1 = xmlAddClientgetall.post(null);
        System.out.println(s1.getEntity().getClass());
        /*WebClient plainAddClient = WebClient.create(REST_URI);
        plainAddClient.path(ADD_PATH).path(a + "/" + b).accept("text/plain");
        s = plainAddClient.get(String.class);
        System.out.println(s);
         
        WebClient xmlAddClient = WebClient.create(REST_URI);
        xmlAddClient.path(ADD_PATH).path(a + "/" + b).accept("text/xml");
        s = xmlAddClient.get(String.class);
        System.out.println(s);
         
        WebClient plainSubClient = WebClient.create(REST_URI);
        plainSubClient.path(SUB_PATH).path(a + "/" + b).accept("text/plain");
        s = plainSubClient.get(String.class);
        System.out.println(s);
         
        WebClient xmlSubClient = WebClient.create(REST_URI);
        xmlSubClient.path(SUB_PATH).path(a + "/" + b).accept("text/xml");
        s = xmlSubClient.get(String.class);
        System.out.println(s);*/
    }

}
