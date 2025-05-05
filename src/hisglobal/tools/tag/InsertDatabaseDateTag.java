package hisglobal.tools.tag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;


public class InsertDatabaseDateTag extends TagSupport
{
	private String date;
	private Date sysdate;

	public int doStartTag() throws JspException
	{

		try
		{
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			String check = this.getName();
			date = "";
			sysdate = null;
			// boolean isStatusNew = TagUtil.isStatusNew((Status)(TagUtil.getAttribute(this.pageContext,
			// Config.STATUS_OBJECT)));
			int y = sysdate.getYear();
			int m = sysdate.getMonth();
			int d = sysdate.getDate();
			int d1 = sysdate.getDay();
			int t1 = sysdate.getHours();
			int t2 = sysdate.getMinutes();
			JspWriter out = this.pageContext.getOut();
			out.println(this.getTab());

		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return this.EVAL_BODY_INCLUDE;
	}

	public String getTab()
	{
		String strReturn = "";
		strReturn = "<td id='dateTdId' align='right'><b><font color='#000000' size='2'"
				+ "face='Verdana, Arial, Helvetica, sans-serif'> Date And Time " + date + "</font></b></td>"
				+ "<input type='hidden' name='date' value=\"" + sysdate + "\"" + "/>" + "<input type='hidden' name='dateAsString' value=\"" + date
				+ "\"" + "/>";

		return strReturn;
	}

	String name;
	Object bean;

	public Object getBean()
	{
		return bean;
	}

	public void setBean() throws JspException
	{
		this.bean = TagUtil.getAttribute(this.pageContext, this.getName());
		if (this.bean == null) throw new RuntimeException("No bean with name: " + this.getName());
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name) throws JspException
	{
		this.name = name;
		this.setBean();
	}

}
