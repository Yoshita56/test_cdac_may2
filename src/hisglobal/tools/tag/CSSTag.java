package hisglobal.tools.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class CSSTag extends SimpleTagSupport
{
	private String src;

	public void doTag() throws JspException, IOException
	{
		PageContext pc = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pc.getRequest();
		String strContextPath = request.getContextPath();
		String path = strContextPath + (this.src.startsWith("/") ? "" : "/") + this.src;
		getJspContext().getOut().write("<link href=\"" + path + "\" rel=\"stylesheet\" type=\"text/css\">");
	}

	public void setSrc(String _src)
	{
		this.src = _src;
	}
}
