package hissso.ticket.expiration;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

public interface HISExpiration extends Serializable
{
	public int getExpiry();

	public boolean setExpiry();

	public boolean refershExpiry();

	public HttpSession getSessionObject();

	public boolean associateSessionObject(HttpSession objSession);
}
