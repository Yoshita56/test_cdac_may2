package hissso.config;

import javax.servlet.ServletContext;

public abstract class HISSSOConfig
{
	// Configuration Settings
		// Secure Key Sizes
	public static int LOGIN_USER_SESSION_SALT_BYTE_SIZE = 24; // Good Size
		// Ticket Expiration
	public static int SSO_TICKET_EXPIRY_IN_SECONDS_TGT = 18000;		// 5 Hours
	public static int SSO_TICKET_EXPIRY_IN_SECONDS_ST = 7200;		// 2 Hours
		// Login Configurations
	public static int LOGIN_LOCK_AFTER_UNSUCCESSFUL_LOGIN_COUNT = 3; 
		// Authorization
	public static int AUTHORIZATION_URL_LEVEL_AT_APPLICATION_ON = 1; 
	public static int AUTHORIZATION_URL_LEVEL_AT_APPLICATION_OFF = 0; 
	public static int AUTHORIZATION_URL_LEVEL_AT_APPLICATION_STATUS = AUTHORIZATION_URL_LEVEL_AT_APPLICATION_OFF; 
	
		// Ticket Essentials
	public static String SSO_TGT_SERVICE_URL = "/HISSSOService";
	public static String SSO_TICKET_ID_INFO_SEPARATOR = "#";
	public static String SSO_LOGIN_URL = "/hissso/Login.action";
		// Error Page
	public static String SSO_AUTHENTICATION_ERROR_PAGE_URL = "/hissso/jsp/error/sso_error_login_authenticate.jsp";
	public static String SSO_AUTHORIZATION_ERROR_PAGE_URL = "/hissso/jsp/error/sso_error_login_authorize.jsp";
	public static String SSO_UNKNOWN_ERROR_PAGE_URL = "/hissso/jsp/error/sso_error_login_unknown.jsp";
	public static String SSO_ILLEGAL_ACTIVITY_ERROR_PAGE_URL = "/hissso/jsp/error/sso_error_login_illegalactivity.jsp";
		

	
	// Keys
		// Logged-in User Session Keys
	public static String LOGGEDIN_USER_GRANTING_TICKET_ID_VAR = "varSSOTicketGrantingTicket";
	public static String LOGGEDIN_USER_GRANTING_TICKET_ID = "keyLoggedInUserGrantingTicketId";
	public static String LOGGEDIN_USER_AUTHENTICATION_OBJECT = "keyLoggedInUserAuthenticationObject";
	public static String LOGGEDIN_USER_AUTHORIZATION_OBJECT = "keyLoggedInUserAuthorizationObject";
	public static String LOGGEDIN_USER_HASH_SALT = "keyLoggedInUserHashSalt";
	public static String LOGGEDIN_USER_SERVICE_TICKET_ID = "keyLoggedInUserServiceTicketId";
	
		// Logged-in User Session Keys for Specific
	public static String LOGGEDIN_USER_VO = "keyLoggedInUserVO";
	public static String LOGGEDIN_HOSPITALVO = "keyLoggedInHospitalVO";
	public static String LOGGEDIN_CURRENT_YEAR = "keyLoggedInCurrentYear";
	public static String LOGGEDIN_CURRENT_MONTH = "keyLoggedInCurrentMonth";
	public static String LOGGEDIN_SYSDATE_OBJECT = "keyLoggedInUserSystemDateObject";
	public static String LOGGEDIN_SYSDATE_STRING = "keyLoggedInUserSystemDateString";


		// SSO Registry
	public static String SSO_TICKET_REGITRY = "keySSOTicketRegistry";
	

	// Initializing HISSSO Configurations  
	public static void initializeSSOClient(ServletContext objContext)
	{
		// Set SSO ST Register
		HISSSOSupport.initializeSSORegister(objContext);
		
		// Set Service Ticket
		HISSSOSupport.initHISServiceObject(objContext);
	}
}
