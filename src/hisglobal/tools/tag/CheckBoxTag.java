package hisglobal.tools.tag;

import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.util.RequestUtils;

public class CheckBoxTag extends TagSupport
{
	private String name = "";
	private String property = "";
	private String value = "";
	private String onClick = "";
	private String readonly = "";
	private String disabled = "";

	public String getOnClick()
	{
		return onClick;
	}

	public void setOnClick(String onClick)
	{
		this.onClick = onClick;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getProperty()
	{
		return property;
	}

	public void setProperty(String property)
	{
		this.property = property;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}

	public int doStartTag() throws JspTagException
	{

		try
		{
			JspWriter out = pageContext.getOut();
			String checkedString = "";
			Object bean = RequestUtils.lookup(pageContext, getName(), null);
			String myCheck[] = BeanUtils.getArrayProperty(bean, getProperty());
			myCheck = ((myCheck == null) ? new String[]
			{} : myCheck);
			String value = getValue();
			// System.out.println("myCheck:::"+myCheck.length);
			String strCheck = "<input type='checkbox' name='"+getProperty()+"' value='"+getValue()+"'  tabindex='1'  onClick='"+getOnClick()+"' ";
			for (int i = 0; myCheck != null && i < myCheck.length; i++)
			{
				if (myCheck[i].equals(value)) 
					strCheck = strCheck + " checked ";
			}
			if (getDisabled().equalsIgnoreCase("true")) strCheck = strCheck + " disabled";

			out.write(strCheck + "/>");

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return EVAL_BODY_INCLUDE;
	}// end of method

	public String getReadonly()
	{
		return readonly;
	}

	public void setReadonly(String readonly)
	{
		this.readonly = readonly;
	}

	public String getDisabled()
	{
		return disabled;
	}

	public void setDisabled(String disabled)
	{
		this.disabled = disabled;
	}
}//end of class
