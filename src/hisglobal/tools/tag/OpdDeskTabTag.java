package hisglobal.tools.tag;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class OpdDeskTabTag extends TagSupport
{
	private String color;
	// private String fontStyle;
	private String userDeskMenuName;
	private String deskMenuId;
	private String deskUrl;

	public int doStartTag() throws JspException
	{

		try
		{

			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			this.color = ((String) TagUtil.invokeGetterFor(this.getBean(), "Color"));
			// this.fontStyle=((String)TagUtil.invokeGetterFor(this.getBean(), "FontStyle"));
			this.userDeskMenuName = ((String) TagUtil.invokeGetterFor(this.getBean(), "UserDeskMenuName"));
			this.deskMenuId = ((String) TagUtil.invokeGetterFor(this.getBean(), "DeskMenuId"));
			this.deskUrl = ((String) TagUtil.invokeGetterFor(this.getBean(), "DeskUrl"));
			// boolean isStatusNew = TagUtil.isStatusNew((Status)(TagUtil.getAttribute(this.pageContext,
			// Config.STATUS_OBJECT)));
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
		strReturn = "<td  width='100%' class='tdfonthead' ><button id='" + this.deskUrl
				+ "' class='button' style='width:100%;font-weight:normal;font-size:normal;"
				+ "font-family: sans-serif;font:Times New Roman;background-color:" + this.color + ";border-color:#CCCCFF;"
				+ "border-width:thin;border-collapse:collapse;elevation:above' onClick=submitFormOnValidateButton('" + this.deskUrl + "','"
				+ this.deskMenuId + "',event)>" + this.userDeskMenuName + "</button> " + "" + "</td>";
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
