package hissso.validation.credentails.authorization;

import hisglobal.config.HISConfig.APP_TYPE;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * This is HIS Service Object. Each WAR in AHIMS EAR will have a HISService Object set in its Servlet Context.
 * This Object will be created at the time of Application Context Initialization and set in Context. 
 * Each time when the WAR is need to be referenced, this object can be used.
 * WAR Application/Module/Group related information will be kept in this Object.
 */
@XmlRootElement
public class HISService
{
	// Application Detail
	protected String context;
	protected String description;
	protected APP_TYPE appType;
	protected String applicationURL; // Application Base URL For referencing
										// Application
	protected String servicesURL; // Application Services Access URL For
									// accessing Services of this WAR
	protected String serverURL; // Server URL For referencing other Applications
								// on same server

	// Module(s)
	//protected Map<String, HISModule> mapModules = new HashMap<String, HISModule>();

	public String getContext()
	{
		return context;
	}

	public void setContext(String context)
	{
		this.context = context;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public APP_TYPE getAppType()
	{
		return appType;
	}

	public void setAppType(APP_TYPE appType)
	{
		this.appType = appType;
	}

	public String getApplicationURL()
	{
		return applicationURL;
	}

	public void setApplicationURL(String applicationURL)
	{
		this.applicationURL = applicationURL;
	}

	public String getServicesURL()
	{
		return servicesURL;
	}

	public void setServicesURL(String servicesURL)
	{
		this.servicesURL = servicesURL;
	}

	public String getServerURL()
	{
		return serverURL;
	}

	public void setServerURL(String serverURL)
	{
		this.serverURL = serverURL;
	}

	/*public List<HISModule> getModules()
	{
		return (List<HISModule>) mapModules.values();
	}

	public void addModule(String moduleId, HISModule module)
	{
		this.mapModules.put(moduleId, module);
	}*/
}