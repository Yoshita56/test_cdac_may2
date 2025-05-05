package in.cdac.rajashthan.filter;

import java.io.IOException;
import java.util.StringTokenizer;

import javax.xml.bind.DatatypeConverter;

public class AuthService {
	public String authenticate(String authCredentials) {

		if (null == authCredentials)
			return "NO_CREDENTIALS";
		// header value format will be "Basic encodedstring" for Basic
		// authentication. Example "Basic YWRtaW46YWRtaW4="
		final String encodedUserPassword = authCredentials.replaceFirst("Basic"
				+ " ", "");
		String usernameAndPassword = null;
		try {
			byte[] decodedBytes = DatatypeConverter.parseBase64Binary(encodedUserPassword) ;
			usernameAndPassword = new String(decodedBytes, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		final StringTokenizer tokenizer = new StringTokenizer(
				usernameAndPassword, ":");
		
		if(usernameAndPassword.length() <= 1)
			return "NO_CREDENTIALS";
		
		final String username = tokenizer.nextToken();
		final String password = tokenizer.nextToken();

		// we have fixed the userid and password as admin
		// call some UserService/LDAP here
	/*	boolean authenticationStatus = "raj_ws_client".equals(username)
				&& "r@a@t_C|ient".equals(password);
	*/	
		//RMSC
		//Rajsthnan
		boolean authenticationStatus = "user".equals(username)
				&& "password".equals(password);
		
		
		/*MGMIS
		boolean authenticationStatus = "mgm_ws_client".equals(username)
				&& "m@g@m_C|ient".equals(password);  */
		
		if(authenticationStatus){
			
			return "SUCCESS";
			
		}else{
			
			return "FAILURE";
		}
		
		 
	}
}