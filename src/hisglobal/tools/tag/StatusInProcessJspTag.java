package hisglobal.tools.tag;

import hisglobal.hisconfig.Config;
import hisglobal.presentation.Status;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class StatusInProcessJspTag extends TagSupport
{

	public int doStartTag() throws JspTagException
	{
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Status objStatus = (Status) request.getAttribute(Config.STATUS_OBJECT);
		if (objStatus != null)
		{
			HashSet statuslist = objStatus.getStatusList();
			if (statuslist.contains(objStatus.INPROCESS))
			{
				return EVAL_BODY_INCLUDE;
			}
		}
		return SKIP_BODY;
	}
}
