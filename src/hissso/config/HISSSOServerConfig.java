package hissso.config;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class HISSSOServerConfig extends HISSSOConfig
{
	// Configuration Settings
		// Secure Key Sizes
	public static int LOGIN_PASSWORD_HASH_BYTE_SIZE = 24;	// Good Size
	public static int LOGIN_SESSION_SALT_BYTE_SIZE = 24;	// Good Size
	
		// Ticket Essentials
	//public static String SSO_LOGGEDIN_USERDESK_URL = "/hislogin/loadUserDesk.action";
	//Changed by Garima for extension change
	public static String SSO_LOGGEDIN_USERDESK_URL = "/hislogin/loadUserDesk";
	public static String SSO_ST_SERVICE_URL = "/HISSSO_STService";
	
	// Keys
		// For Login
	public static String LOGIN_SESSION_SALT = "keyLoginSessionSalt";
	public static String LOGIN_FEATURES_SESSION_SALT = "keyLoginFeaturesSessionSalt";

	public static String LOGIN_TAB_KEY = "keyLoginTab";

	private static Set<String> setAllowedActionURIs;
	
	// Initializing HISSSO Configurations  
	public static void initializeSSOServer(ServletContext objContext)
	{
		// Set SSO TGT Register
		HISSSOSupport.initializeSSORegister(objContext);

		// Set Ticket Expiration From Context
		if(objContext.getInitParameter("SSO_TICKET_EXPIRATION_TGT_SECONDS")!=null)
			SSO_TICKET_EXPIRY_IN_SECONDS_TGT = Integer.parseInt(objContext.getInitParameter("SSO_TICKET_EXPIRATION_TGT_SECONDS"));

		if(objContext.getInitParameter("SSO_TICKET_EXPIRATION_ST_SECONDS")!=null)
			SSO_TICKET_EXPIRY_IN_SECONDS_ST = Integer.parseInt(objContext.getInitParameter("SSO_TICKET_EXPIRATION_ST_SECONDS"));
	
		// Set Service Ticket
		HISSSOSupport.initHISServiceObject(objContext);

		// Set Set of Allowed URIs (Patterns)
		setAllowedActionURIs = new HashSet<String>();
		//setAllowedActionURIs.add("/AHIMSG5/hissso/Login.action"); 
		//setAllowedActionURIs.add("/AHIMSG5/hissso/initLogin.action");
		//setAllowedActionURIs.add("/AHIMSG5/hissso/loginLogin.action");
		//setAllowedActionURIs.add("/AHIMSG5/hislogin/[a-zA-Z]*ForgetPasswordLgnFtr.action");
		//setAllowedActionURIs.add("/AHIMSG5/hissso/captchaLogin.action");
		//setAllowedActionURIs.add("/AHIMSG5/hislogin/captchaLgnFtr.action");
		//setAllowedActionURIs.add("/AHIMSG5/hissso/fileDownloadLogin.action");
		
		//Changed by Garima for extension change
		
		setAllowedActionURIs.add("/AHIMSG5/hissso/Login"); 
		setAllowedActionURIs.add("/AHIMSG5/hissso/initLogin");
		setAllowedActionURIs.add("/AHIMSG5/hissso/loginLogin");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/[a-zA-Z]*ForgetPasswordLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hissso/captchaLogin");
		setAllowedActionURIs.add("/AHIMSG5/hislogin/captchaLgnFtr");
		setAllowedActionURIs.add("/AHIMSG5/hissso/fileDownloadLogin");
		
		//setAllowedActionURIs.add("/AHIMSG5/hissso/forgetPasswordLogin.action");
	}

	// Check Allowed Request 
	public static boolean onServerCheckAllowedRequest(HttpServletRequest objRequest)
	{
		String strURI = objRequest.getRequestURI();
		for(String str : setAllowedActionURIs)
		{
			if(strURI.matches(str))
			{
				return true;
			}
		}
		return false;
	}

	// Authenticate Request 
	public static boolean onServerCheckAuthenticateRequest(HttpServletRequest objRequest)
	{
		return HISSSOSupport.onServerCheckAuthenticateRequest(objRequest);
	}

	// Call on Session SSO TGT Expiration 
	public static void onSessionExpiration(HttpSession objSession)
	{
		HISSSOSupport.onSSOTGTSessionExpiration(objSession);
	}
}
