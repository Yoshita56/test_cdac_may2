package application.listeners;

import java.util.Date;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HISApplicationSessionListener implements HttpSessionListener
{

	public void sessionCreated(HttpSessionEvent objSessionEvent)
	{
		// Nothing to do right now
	}

	public void sessionDestroyed(HttpSessionEvent objSessionEvent)
	{
		// Nothing to do right now
		System.out.println("******************  INVMGM sessionDestroyed in HISApplicationSessionListener************Stack Trace  ************************ @ >> "+ new Date());
		Thread.currentThread().getStackTrace();
		
		
		
		
		System.out.println("*********************************************  INVMGM Stack Dump  ************************************  @ >> "+ new Date());
		Thread.dumpStack();
	}
}
 