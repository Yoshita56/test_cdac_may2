package hisglobal.tools.tag;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.TagSupport;

public class SelectTree extends TagSupport
{

	private String beanName;
	private String propertyName;

	public String getBeanName()
	{
		return beanName;
	}

	public void setBeanName(String beanName)
	{
		this.beanName = beanName;
	}

	public String getPropertyName()
	{
		return propertyName;
	}

	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}

	public int doStartTag() throws JspTagException
	{

		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspTagException
	{
		try
		{
		}

		catch (Exception ex)
		{
			ex.printStackTrace();
			throw new JspTagException("Fatal error:helloTag could not write to JspOut");
		}
		return EVAL_PAGE;
	}
}
