package hissso.controller.action;

import hisglobal.config.HISConfig;
import hissso.controller.actionsupport.LoginSUP;
import hissso.controller.util.LoginUTL;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
//import sun.misc.BASE64Encoder;
public class LoginACT extends LoginSUP
{
	private static final long serialVersionUID = 0L;
	//private static final String PAGE_INITIAL = "INITIAL"; // Only SSO Part
	private static final String PAGE_MAIN = "MAIN";
	private static final String PAGE_HIS_LOGIN_DESK = "DESK";
	private static final String PAGE_ERROR = "ERROR";
	private static final String PAGE_HIS_LOGIN_CHANGE_PASSWORD = "CHNAGEPASSWORD";
	
	public String execute() throws Exception
	{
		return init();
	}

	@SuppressWarnings("unchecked")
	public String init() throws Exception
	{
		// Check if request Already have a Valid User Token
			// if exists, then forward to already Login Tasks, Done through Request Filter
	//	System.out.println("---------------------"+HISConfig.CAPTCHA_IMPLEMENTATION);
		// Otherwise Initialize setup for new User Login		
		if(LoginUTL.setInititals(this, objRequest, objResponse))
			return PAGE_MAIN;//PAGE_INITIAL;			
		else
			return PAGE_ERROR;
	}

	@SuppressWarnings("unchecked")
	public String login() throws Exception
	{
		HttpSession objSession = null;
		objSession = objRequest.getSession();
		String parm = this.getCaptchaResponse();
	    String c= (String)objSession.getAttribute("CAPTCHA_KEY") ;
	    if(parm!=null && !parm.equals(c) )
	    {
	      LoginUTL.setInititals(this, objRequest, objResponse);
	      addActionError("Invalid Captcha! Please try again!");
	       return PAGE_MAIN;
	    }
	    if(this.varUserName!=null && !this.varUserName.isEmpty() && !this.varUserName.matches("[A-Za-z0-9_]+") || this.varUserName.length()>20)
		{
	    	addActionError("Invalid User Name!");
	    	return PAGE_MAIN;
		}
	    //Login User Against Entered Credentials
	    /* Start of COde added by Garima for fixing Security Vulnerabilities*/
		if((this.varUserName!=null && !this.varUserName.isEmpty() && this.varPassword!=null && !this.varPassword.isEmpty())) //&& LoginUTL.loginUser(this, objRequest, objResponse))
				{
			// If User Successfully Logged In, then Forward to HIS User Desk
			//return PAGE_HIS_LOGIN_DESK;
			
			/* Start of COde added by Garima for fixing Security Vulnerabilities*/
			if ("POST".equalsIgnoreCase(objRequest.getMethod())) {

				// If User Successfully Logged In, then Forward to HIS User Desk
				if (LoginUTL.loginUser(this, objRequest, objResponse)) {
						return PAGE_HIS_LOGIN_DESK;

					} else {
						return PAGE_MAIN;// PAGE_INITIAL;
					}

		
			} else {

				objRequest.setAttribute("message", "Not a Valid Request !");
				LoginUTL.setInititals(this, objRequest, objResponse);
				return PAGE_MAIN;// PAGE_INITIAL;

			}
			/* End of COde added by Garima for fixing Security Vulnerabilities*/
		}
		else
		{
			// If Not, then forward to login Window for Re-Login and Error Message
			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_MAIN;//PAGE_INITIAL;
		}
	}

	@SuppressWarnings("unchecked")
	public String logout() throws Exception
	{
		if(LoginUTL.logoutUser(this, objRequest, objResponse))
		{
			LoginUTL.setInititals(this, objRequest, objResponse);
			return PAGE_MAIN;//PAGE_INITIAL;
		}
		else
			return PAGE_MAIN;//PAGE_INITIAL;
	}

	public String desk() throws Exception
	{
		return PAGE_HIS_LOGIN_DESK;
	}

	@SuppressWarnings("unchecked")
	public String firstLogin() throws Exception
	{
		if(LoginUTL.setEssentialforFirstLogin(this, objRequest, objResponse))
			return PAGE_HIS_LOGIN_CHANGE_PASSWORD;
		else
			return PAGE_ERROR;
	}
	
	  public void captcha() throws ServletException, IOException {
	   		  
		  LoginUTL.setCaptcha(this,objRequest, objResponse);
		  
	  }
	  /*public void fileDownload() throws Exception
	  {
		  System.out.println("Inside Download folder");
		  LoginUTL.getFileDownload(this,objRequest, objResponse);
	  }*/
}
