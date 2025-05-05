package hisglobal.tools.tag;

import hisglobal.hisconfig.Config;
import hisglobal.presentation.Status;
import hisglobal.utility.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.*;
import java.util.HashSet;
import java.util.Iterator;

public class StatusTag extends SimpleTagSupport
{
	private String src = "";

	public void doTag() throws JspException, IOException
	{
		PageContext pc = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pc.getRequest();
		Status objStatus = (Status) request.getAttribute(Config.STATUS_OBJECT);
		//System.out.println("objStatus:::" + objStatus);
		if (objStatus != null)
		{
			HashSet statuslist = objStatus.getStatusList();
			Iterator it = statuslist.iterator();
			while (it.hasNext())
			{
				Entry objEntry = (Entry) it.next();
				String str = "<br><font color='#FF0000' size='2' face='Verdana, Arial, Helvetica, sans-serif'><b>" + objEntry.getLabel()
						+ "</b></font>";
				this.getJspContext().getOut().write(str);
				//System.out.println("objEntry.getLabel   " + objEntry.getLabel());
			}
		}
	}

	public void setSrc(String _src)
	{
		this.src = _src;
	}
}
