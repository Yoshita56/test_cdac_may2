package hisglobal.tools.tag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class NameTag extends BodyTagSupport
{
	public int doEndTag() throws JspException
	{
		if (bodyContent != null)
		{
			// get the body content (the JavaScript code)
			String content = bodyContent.getString();

			// now find the parent tag
			SuperTitleTagSupport tag = (SuperTitleTagSupport) (getParent());

			// and add the event handler to the select tag
			try
			{
				if (tag != null)
				{
					String strName = tag.getName();
					if (strName == null)
					{
						tag.setName(content);
						JspWriter out = this.pageContext.getOut();
						HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();

						out.println(tag.getFrontBar(request));
					}
				}
			}
			catch (Exception e)
			{
				System.out.println("exception: NameTag " + e);
			}
		}
		return super.doEndTag();
	}
}
