package hissso.client.listener;

import hissso.config.HISSSOClientConfig;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HISSSOClientSessionListener implements HttpSessionListener
{

	public void sessionCreated(HttpSessionEvent objSessionEvent)
	{
		// Nothing to do right now for HIS
	}

	public void sessionDestroyed(HttpSessionEvent objSessionEvent)
	{
		HttpSession objSession = objSessionEvent.getSession();

		// Check for SSO TGT Expiration
		HISSSOClientConfig.onSessionExpiration(objSession);
	}
}
