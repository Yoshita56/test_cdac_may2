package hisglobal.tools.tag;

import hisglobal.hisconfig.Config;
import hisglobal.presentation.WebUTIL;
import hisglobal.utility.Entry;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RegistrationAllAddedDeptMandatoryTag extends SimpleTagSupport
{
	private String property = "";
	private String length = "";
	

	public String getProperty()
	{
		return property;
	}

	public void setProperty(String property)
	{
		this.property = property;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public void doTag() throws JspException, IOException
	{
		String deptCode = "";
		String mandatoryValue = "";
		Entry entry = null;
		// String deptCode=(String)getJspContext().findAttribute(RegistrationConfig.DEPARTMENT_CODE);
		// String
		// mandatoryValue=WebUTIL.getValueFromPropertiesFile(Config.PROPERTIES_FILE_FOR_MANDATORY_FIELD,deptCode);
		List deptList = (List) getJspContext().findAttribute(Config.REGISTRATION_MANDATORY_DEPT_LIST);

		ListIterator iterator = null;
		if (deptList != null && deptList.size() > 0)
		{
			iterator = deptList.listIterator();
			while (iterator.hasNext())
			{
				// deptCode=(String)iterator.next();
				Object obj = iterator.next();
				if (obj instanceof Entry)
				{
					entry = (Entry) obj;

					if (entry != null) deptCode = entry.getValue();
				}
				else
				{
					if (obj instanceof String) deptCode = (String) obj;
				}
				mandatoryValue = WebUTIL.getValueFromPropertiesFile(Config.PROPERTIES_FILE_FOR_MANDATORY_FIELD, deptCode);
				if (mandatoryValue.equalsIgnoreCase(""))
				{

				}
				else
				{
					String[] control = mandatoryValue.split(",");
					String validationString = "";
					
	for(int j=0; j < Integer.parseInt(this.getLength());j++){
						
					validationString = validationString + " && ((document.getElementsByName('" + this.getProperty() + "')["+j+"].value == " + deptCode
							+ ") ? (( true ";
					for (int i = 0; i < control.length; i++)
					{
						String[] controlStr = control[i].split(":");
						String controlName = controlStr[0];
						String controlType = controlStr[1];
						String controlLabel = controlStr[2];

						if (controlType.equalsIgnoreCase("text")) validationString = validationString + " && isEmpty(document.forms[0]."
								+ controlName + ",\"" + controlLabel + "\")";
						if (controlType.equalsIgnoreCase("combo")) validationString = validationString + " && isSelected(document.forms[0]."
								+ controlName + ",\"" + controlLabel + "\")";
					}
					validationString = validationString + ") ?  true :  false ) : true )";
	}//outer for closed 	
														
					
					
					getJspContext().getOut().write(validationString);
				}
			}
		}
	}//end of dotag
}
