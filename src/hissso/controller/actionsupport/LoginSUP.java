package hissso.controller.actionsupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public abstract class LoginSUP extends ActionSupport implements ServletRequestAware, ServletResponseAware
{
	private static final long serialVersionUID = 1L;

	protected HttpServletRequest objRequest;
	protected HttpServletResponse objResponse;

	protected String varUserName;
	protected String varPassword;
	protected String varSSOTicketGrantingTicket;
	protected String captchaResponse;
	public LoginSUP()
	{
		varUserName = "";
		varPassword = "";
		varSSOTicketGrantingTicket = "";
	}

	public void clear()
	{
		varUserName = "";
		varPassword = "";
		varSSOTicketGrantingTicket = "";
	}

	public HttpServletRequest getObjRequest()
	{
		return objRequest;
	}

	public void setObjRequest(HttpServletRequest objRequest)
	{
		this.objRequest = objRequest;
	}

	public HttpServletResponse getObjResponse()
	{
		return objResponse;
	}

	public void setObjResponse(HttpServletResponse objResponse)
	{
		this.objResponse = objResponse;
	}

	public String getVarUserName()
	{
		return varUserName;
	}

	public void setVarUserName(String varUserName)
	{
		this.varUserName = varUserName;
	}

	public String getVarPassword()
	{
		return varPassword;
	}

	public void setVarPassword(String varPassword)
	{
		this.varPassword = varPassword;
	}

	/*
	 * @Override public CountryModel getModel() {
	 * System.out.println("Inside CountryAction ::: getModel()"); return
	 * modelCountry; }
	 */

	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.objRequest = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		this.objResponse = response;
	}

	public String getVarSSOTicketGrantingTicket()
	{
		return varSSOTicketGrantingTicket;
	}

	public void setVarSSOTicketGrantingTicket(String varSSOTicketGrantingTicket)
	{
		this.varSSOTicketGrantingTicket = varSSOTicketGrantingTicket;
	}
	public String getCaptchaResponse()
	{
		return captchaResponse;
	}

	public void setCaptchaResponse(String captchaResponse)
	{
		this.captchaResponse = captchaResponse;
	}

}
