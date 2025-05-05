package hisglobal.tools.tag;

import java.util.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.TagSupport;

public class DatePicker extends TagSupport
{
	private String name = "";

	private String value = "";
	private String dateFormate = "";
	private String onchange = "";
	private String id = "";
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public java.lang.String getDateFormate()
	{
		return dateFormate;
	}

	public void setDateFormate(java.lang.String dateFormate)
	{
		this.dateFormate = dateFormate;
	}

	public java.lang.String getValue()
	{
		return value;
	}

	public void setValue(java.lang.String value)
	{
		this.value = value;
	}

	public java.lang.String getName()
	{
		return name;
	}

	public void setName(java.lang.String name)
	{
		this.name = name;
	}

	public int doStartTag() throws JspTagException
	{
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspTagException
	{
		String onChangeString = "";
		String dateString = new Date().toString();
		if (!getOnchange().equalsIgnoreCase(""))
		{
			onChangeString = "onchange=" + getOnchange();
		
		   
		}
		if (dateFormate.equals("") || dateFormate == null) dateFormate = "%d-%b-%Y";
		if (value == null || value.equals(""))
			value = "";

		try
		{
			// pageContext.getOut().write("Hello World<br>"+getName()+"<br>");
			pageContext.getOut().write(
					"<input type=\"text\" class=\"textBoxCss\"     name=\"" + getName() + "\" id=\"" + getId()+getName() + "\"readonly value='" + getValue() + "'" + onChangeString
							+ "  size='12'> " + "	<img onkeypress='if(event.keyCode==13) this.click()' align='top' src=\"/INVMGM/hisglobal/images/imgDatepicker.png\" id=\"" + (getId().equals("")?getName()+"1":getId())+"\""
							+ " style=\"cursor: pointer; border: 1px solid red;\"  " + "	title=\"Date selector\"  tabindex=\"1\""
							+ "	onmouseover=\"this.style.background='red';\"  " + "	 onmouseout=\"this.style.background=''\" > "
							+ "	<script language=\"JavaScript\" > " + "Calendar.setup" + "(" + " {" + " inputField     :    \"" + getId()+getName() + "\"," +

							"mapkey : '32', ifFormat       :    \"" + getDateFormate() + "\"," + " button         :    \"" + (getId().equals("")?getName()+"1":getId()) + "\" ,"
							+ " singleClick    :    true" +  " }" + ");	</script>");
			// pageContext.getOut().write("Myname is "+getClass().getName()+"and it's "+dateString+"<p/>");
		}
		catch (Exception ex)
		{
			throw new JspTagException("Fatal error:helloTag could not write to JspOut");
		}
		return EVAL_PAGE;
	}

	public String getOnchange()
	{
		return onchange;
	}

	public void setOnchange(String onchange)
	{
		this.onchange = onchange;
	}

}
