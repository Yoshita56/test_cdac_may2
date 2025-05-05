package in.cdac.mhealth.service;

import in.cdac.mhealth.login.business.LoginBO;
import in.cdac.mhealth.login.business.PatientLoginBO;

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
	@GET
	@Path("/otp")
	@Produces(MediaType.TEXT_PLAIN)
	public String getOTP(@QueryParam("hCode") String hcode,@QueryParam("mobileNo") String mobileNo){
		PatientLoginBO patientLoginBO = new PatientLoginBO();
		return patientLoginBO.getOTP(mobileNo, hcode);
	}
	
	@POST
	@Path("/otp")
	@Produces(MediaType.TEXT_PLAIN)
	public String getOTPPost(@FormParam("hCode") String hcode,@FormParam("mobileNo") String mobileNo){
		PatientLoginBO patientLoginBO = new PatientLoginBO();
		return patientLoginBO.getOTP(mobileNo, hcode);
}
	@GET
	@Path("/otpfromcr")
	@Produces(MediaType.TEXT_PLAIN)
	public String getOTPFromCr(@QueryParam("hCode") String hcode,@QueryParam("crno") String mobileNo){
		PatientLoginBO patientLoginBO = new PatientLoginBO();
		return patientLoginBO.getOTPFromCr(mobileNo, hcode);
	}
	
	@POST
	@Path("/otpfromcr")
	@Produces(MediaType.TEXT_PLAIN)
	public String getOTPFromCrPost(@FormParam("hCode") String hcode,@FormParam("crno") String mobileNo){
		PatientLoginBO patientLoginBO = new PatientLoginBO();
		return patientLoginBO.getOTPFromCr(mobileNo, hcode);
}
}

