package in.cdac.invWebServices.service;

import in.cdac.invWebServices.login.business.LoginBO;

import java.security.SecureRandom;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/login")
public class LoginService {

	public static final int SALT_SIZE = 24;
	
	@POST
	@Path("/check")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String checkLogin(@FormParam("user") String userName,
							 @FormParam("pass") String passWord,
							 @FormParam("salt") String salt,
							 @FormParam("hcode") String hcode){
		if (userName == null || passWord == null || salt == null || hcode == null)
			return "{\"error\": \"Null Parameter\"}";
		LoginBO objLoginBO = new LoginBO();
		return objLoginBO.checkLogin(userName, passWord, salt, hcode);
	}
	
	@GET
	@Path("/check")
	@Produces(MediaType.APPLICATION_JSON)
	public String checkLoginPost(@QueryParam("user") String userName,
							 @QueryParam("pass") String passWord,
							 @QueryParam("salt") String salt,
							 @QueryParam("hcode") String hcode){
		if (userName == null || passWord == null || salt == null || hcode == null)
			return "{\"error\": \"Null Parameter\"}";
		LoginBO objLoginBO = new LoginBO();
		return objLoginBO.checkLogin(userName, passWord, salt, hcode);
	}
	
	@GET
	@Path("/salt")
	@Produces(MediaType.TEXT_PLAIN)
	public String generateSalt(){
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[SALT_SIZE];
		random.nextBytes(salt);
		return salt.toString();
	}
	
	@POST
	@Path("/salt")
	@Produces(MediaType.TEXT_PLAIN)
	public String generateSaltPost(){
		SecureRandom random = new SecureRandom();
		byte[] salt = new byte[SALT_SIZE];
		random.nextBytes(salt);
		return salt.toString();
	}
}
