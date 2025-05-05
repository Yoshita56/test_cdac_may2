package hisglobal.tools.tag;

import hisglobal.hisconfig.Config;
import hisglobal.presentation.Status;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class StatusInProcessTag extends SimpleTagSupport
{
	public void doTag() throws JspException, IOException
	{
		PageContext pc = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pc.getRequest();
		Status objStatus = (Status) request.getAttribute(Config.STATUS_OBJECT);
		if (objStatus != null)
		{
			Set statuslist = objStatus.getStatusList();
			if (statuslist.contains(objStatus.INPROCESS))
			{
				getJspBody().invoke(null);
			}
		}
	}
}
