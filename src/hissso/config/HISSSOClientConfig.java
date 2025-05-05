package hissso.config;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

public abstract class HISSSOClientConfig
{
	// Configuration Settings
		// Ticket Essentials
	public static String SSO_ST_SERVICE_URL = "/HISSSOClientService";
	
	
	
	// Initializing HISSSO Configurations  
	public static void initializeSSOClient(ServletContext objContext)
	{
		// Set SSO ST Register
		HISSSOSupport.initializeSSORegister(objContext);
		
		// Set Service Ticket
		HISSSOSupport.initHISServiceObject(objContext);
	}

	// Call on Session SSO ST Expiration 
	public static void onSessionExpiration(HttpSession objSession)
	{
		HISSSOSupport.onSSOSTSessionExpiration(objSession);
	}
}
