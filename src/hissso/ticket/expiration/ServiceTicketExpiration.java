package hissso.ticket.expiration;

import javax.servlet.http.HttpSession;
import javax.xml.bind.annotation.XmlRootElement;

import hissso.config.HISSSOConfig;

@XmlRootElement
public final class ServiceTicketExpiration implements HISExpiration
{
	// Serialization ID
	private static final long serialVersionUID = 5L;

	// Expiration Time in Seconds
	private int timeToExpireInSecond;

	// Session Object
	private HttpSession objSession;

	public ServiceTicketExpiration(HttpSession objSession)
	{
		timeToExpireInSecond = HISSSOConfig.SSO_TICKET_EXPIRY_IN_SECONDS_ST;
		this.objSession = objSession;
	}

	public ServiceTicketExpiration(int timetoExpire)
	{
		timeToExpireInSecond = timetoExpire;
	}

	public int getExpiry()
	{
		return this.timeToExpireInSecond;
	}

	public boolean setExpiry()
	{
		boolean flg = true;
		try
		{
			this.objSession.setMaxInactiveInterval(timeToExpireInSecond);
		}
		catch (Exception e)
		{
			flg = false;
		}
		return flg;
	}

	public boolean refershExpiry()
	{
		boolean flg = true;
		try
		{
			this.objSession.setMaxInactiveInterval(timeToExpireInSecond);
		}
		catch (Exception e)
		{
			flg = false;
		}
		return flg;
	}

	public HttpSession getSessionObject()
	{
		return this.objSession;
	}

	public boolean associateSessionObject(HttpSession objSession)
	{
		if(this.objSession != null)	return false;
		this.objSession = objSession;
		return true;
	}
}
