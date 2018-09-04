package com;  // This is required to provided in servlet mapping

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

@Path("/restServ") // After Project name this has to appended in URL
public class ServletApi {

	@GET
	@Produces(MediaType.TEXT_XML) // Type of Object returned
	// To call this: http://localhost:8080/RestLoginService/api/restServ
	public String sayHello(){
		return "<Hello>Rest Service is up</Hello>";
	}
	
	@GET
	@Path("/sum")
	@Produces(MediaType.TEXT_XML) // Type of Object returned
	// To call this: http://localhost:8080/RestLoginService/api/restServ/sum?a=10&b=20
	public String sum(@QueryParam("a") int a,@QueryParam("b") int b){
		return "<Sum>"+(a-b)+"</Sum>";
	}
	
	@SuppressWarnings("unchecked")
	@GET
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON) // Type of Object returned
	public String login(@QueryParam("username") String username,@QueryParam("password") String password){
		JSONObject obj = new JSONObject();
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
			obj.put("Login", true);
			obj.put("Message", "Welcome "+username);
		}
		else {
			obj.put("Login", false);
			obj.put("Message", "Login unsuccessful. Please enter correct username and password.");
		}
		return obj.toJSONString();
	}
}
