package hisglobal.backutil;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.*;


public class JavaScriptTag extends SimpleTagSupport{
	
	private String src;
	
	public void doTag() throws JspException,IOException
	{
		PageContext pc = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pc.getRequest();
		String strContextPath= request.getContextPath();
		String path = strContextPath+(this.src.startsWith("/")?"":"/")+this.src;
		getJspContext().getOut().write("<script language=\"javaScript\"  src=\""+path+"\"></script>");			
	}
	
	public void setSrc(String _src)	
	{
		this.src=_src;		
	}

}
