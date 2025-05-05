/*Developed By Sanjeev Kumar
Date=17-04-2006
*/

package hisglobal.backutil;

import java.util.*;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.TagSupport;


public class DatePicker extends TagSupport
{
	private String name="";
	
	private String value="";
	private String dateFormate="";

	public java.lang.String getDateFormate( )
	{
		return dateFormate;
	}

	public void setDateFormate( java.lang.String dateFormate )
	{
		this.dateFormate = dateFormate;
	}


	public java.lang.String getValue( )
	{
		return value;
	}

	public void setValue( java.lang.String value )
	{
		this.value = value;
	}
	public java.lang.String getName( )
	{
		return name;
	}

	public void setName( java.lang.String name )
	{
		this.name = name;
	}


	public int doStartTag() throws JspTagException
		{
			return EVAL_BODY_INCLUDE;
		}

	public int doEndTag() throws JspTagException
		{
			String dateString=new Date().toString();
			if(dateFormate.equals("")||dateFormate==null)
				dateFormate= "%d-%b-%Y";
			if(value.equals("")||value==null)
				value="";

			try{
					//pageContext.getOut().write("Hello World<br>"+getName()+"<br>");
					pageContext.getOut().write("<input type=\"text\" name=\""+getName()+"\" id=\""+getName()+"\"readonly value='"+getValue()+"'> "+
					"	<img src=\"/AHIMS/hisglobal/images/iconPicDate.gif\" id=\""+getName()+"1\" style=\"cursor: pointer; border: 1px solid red;\"  "+
					"	title=\"Date selector\"  "+
					"	onmouseover=\"this.style.background='red';\"  "+
					"	 onmouseout=\"this.style.background=''\"> "+
					"	<script language=\"JavaScript\" > "+
					"Calendar.setup"+
					"("+
					" {"+
					" inputField     :    \""+getName()+"\","+

					" ifFormat       :    \""+getDateFormate()+"\","+
					" button         :    \""+getName()+"1\","+
					" singleClick    :    true"+
					" }"+
					");	</script>");
					//pageContext.getOut().write("Myname is "+getClass().getName()+"and it's "+dateString+"<p/>");
				}catch(Exception ex)
				{
					throw new JspTagException("Fatal error:helloTag could not write to JspOut");
				}
		return EVAL_PAGE;
		}

}
