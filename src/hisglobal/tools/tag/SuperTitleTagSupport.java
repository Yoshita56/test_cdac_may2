package hisglobal.tools.tag;

import hisglobal.hisconfig.Config;
import hisglobal.persistence.HelperMethodsDAO;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

abstract class SuperTitleTagSupport extends TagSupport
{
	public int doStartTag() throws JspTagException
	{
		// Getting Page Context
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			if (this.name != null) out.println(getFrontBar(request));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_BODY_INCLUDE;
	}

	public int doAfterBody()
	{
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			// if (this.name == null) throw new IllegalArgumentException("Name is null");
			out.println(getEndBar(request));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_PAGE;
	}

	abstract String getFrontBar(HttpServletRequest _request);

	abstract String getEndBar(HttpServletRequest _request);

	private String name;
	private String key;

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		if (key != null)
		{
			try
			{
				this.name = HelperMethodsDAO.getQuery(Config.RESOURCE_BUNDLE_PROPERTY_FILE_PATH, key);
				System.out.println("");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		if (name == null) this.name = "";
		else this.name = name;
	}

	String DEFAULT_WIDTH = "800";

	private String width;

	public String getWidth()
	{
		return width;
	}

	public void setWidth(String width)
	{
		this.width = width;
	}

	public String getRequiredWidth()
	{
		if (this.width == null) return DEFAULT_WIDTH;
		return this.width;
	}
}
