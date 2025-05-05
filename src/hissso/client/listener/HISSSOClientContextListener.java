package hissso.client.listener;

import hissso.config.HISSSOClientConfig;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import application.config.HISApplicationConfig;
import hisglobal.MyTimerTask;
import hisglobal.utility.HisUtil;

public class HISSSOClientContextListener implements ServletContextListener
{
	public void contextInitialized(ServletContextEvent objContextEvent)
	{
		ServletContext objContext = objContextEvent.getServletContext();
		
		// Application Initialization 
		new HISApplicationConfig().setApplictaionInitials(objContext);
		
		// SSO Client Initialization
		HISSSOClientConfig.initializeSSOClient(objContext);
		
		String jobSchFLag=HisUtil.getParameterFromHisPathXML("JOB_DATA_SCHEDULER");
		if(jobSchFLag.equalsIgnoreCase("ON"))
			MyTimerTask.startScheduler();
	}

	public void contextDestroyed(ServletContextEvent objContextEvent)
	{
		// Nothing to do right now for HIS
	}
}
