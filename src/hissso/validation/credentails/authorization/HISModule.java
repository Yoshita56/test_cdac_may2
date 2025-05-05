package hissso.validation.credentails.authorization;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * This is HIS Module Object. Having Module Specific Basic Information.
 */
@XmlRootElement
public class HISModule
{
	protected String moduleName;
	protected String moduleId;
	protected String moduleContext;
	protected String description;

	public String getModuleName()
	{
		return moduleName;
	}

	public void setModuleName(String moduleName)
	{
		this.moduleName = moduleName;
	}

	public String getModuleId()
	{
		return moduleId;
	}

	public void setModuleId(String moduleId)
	{
		this.moduleId = moduleId;
	}

	public String getModuleContext()
	{
		return moduleContext;
	}

	public void setModuleContext(String moduleContext)
	{
		this.moduleContext = moduleContext;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

}