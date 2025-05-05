package hisglobal.tools.tag;

import hisglobal.hisconfig.Config;
import hisglobal.presentation.Status;

import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.tagext.TagSupport;

public class StatusNewTag extends TagSupport
{

	public int doStartTag() throws JspTagException
	{
		//System.out.println("inside StatusNewTag");
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		Status objStatus = (Status) request.getAttribute(Config.STATUS_OBJECT);
		// System.out.println("objStatusobjStatus"+objStatus.getStatusList());
		if (objStatus != null)
		{
			HashSet statuslist = objStatus.getStatusList();
			if (statuslist.contains(objStatus.NEW))
			{
				//System.out.println("Evaluated");
				return EVAL_BODY_INCLUDE;
			}
		}
		return SKIP_BODY;

	}
}// end of class
