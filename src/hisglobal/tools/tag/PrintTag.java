/* **************************************************************************************
 * creates a div tag which cover the html which has to be print
 * call the printDialog.jsp on load which runs the applet PrintApplet
 *  
 ***************************************************************************************/
package hisglobal.tools.tag;

import hisglobal.presentation.WebUTIL;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PrintTag extends TagSupport
{

	private String copies;
	private String isCopiesEditable="true";

	public int doStartTag() throws JspTagException
	{
		//get page context
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			/*String js="<script>function printIt(){document.getElementsByName('htmlCode')[0].value=document.getElementById('htmlCode').innerHTML;"
						+"var htmlCode=document.getElementById('htmlCode').innerHTML; document.getElementById('print').innerHTML=null; document.getElementsByName(\"hmode\")[0].value=\"POPUP\"; "
						+"document.forms[0].submit();}"
						+"function callDialogOnLoad(){if(document.forms[0].hmode){var copies=document.getElementsByName(\"copies\")[0].value;"
						+"var isEditable=document.getElementsByName(\"isCopiesEditable\")[0].value;	if(document.forms[0].hmode.value==\"POPUP\"){"
						+"document.getElementById('print').innerHTML=null; var context=document.getElementsByName(\"context\")[0].value;"
						+"var url=context + \"/hisglobal/utility/print/printDialog.jsp?copies=\" + copies + \"&isCopiesEditable=\" + isEditable; "
						+"var myPopup=window.open(url ,\"Print\",\"width=400,height=220\" , \"scrollbars=no,resizable=false\");"
						+"if (!myPopup.opener)myPopup.opener = self;}}}</script>";*/
			String js="<script>function printIt(){document.getElementsByName('htmlCode')[0].value=document.getElementById('htmlCode').innerHTML;"
				+"var htmlCode=document.getElementById('htmlCode').innerHTML; document.getElementById('print').innerHTML=null;"
				+ "var url=\""+ request.getContextPath() +"/hisglobal/utility/print/printPopup.jsp\";"
				+ "var myPopup=window.open(url , \"Print\",\"width=400,height=220\" , \"scrollbars=no,resizable=false\");}"
				+"function callDialogOnLoad(){if(document.forms[0].hmode){var copies=document.getElementsByName(\"copies\")[0].value;"
				+"var isEditable=document.getElementsByName(\"isCopiesEditable\")[0].value;	if(document.forms[0].hmode.value==\"POPUP\"){"
				+"document.getElementById('print').innerHTML=null; var context=document.getElementsByName(\"context\")[0].value;"
				+"var url=context + \"/hisglobal/utility/print/printDialog.jsp?copies=\" + copies + \"&isCopiesEditable=\" + isEditable; "
				+"var myPopup=window.open(url ,\"Print\",\"width=400,height=220\" , \"scrollbars=no,resizable=false\");"
				+"if (!myPopup.opener)myPopup.opener = self;}}}</script>";
			String str="<table width=\"100%\"><tr><td><div id=\"print\" align=\"right\">" +
						//"<img src='"+request.getContextPath()+"/hisglobal/images/btn-pnt.png'"
						//+ "onKeyPress=\"if(window.event.keyCode==13)printIt();\" onClick='printIt()'></div><div id=\"htmlCode\">";
					"<input type=\"Button\" value=\"Print\" onKeyPress=\"if(window.event.keyCode==13)printIt();\" onClick='printIt()'></div><div id=\"htmlCode\">";
						
			out.println(js+ str);
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_BODY_INCLUDE;
		//String strDivBottom = getDivBottom();
	}

	public int doAfterBody()
	{
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			out.println("</div><input type=\"hidden\" name=\"copies\" value='" + getCopies()+ 
						"'><input type=\"hidden\" name=\"isCopiesEditable\" value= '" + getIsCopiesEditable() 
						+"'><input type=\"hidden\" name=\"context\" value="+ request.getContextPath() + "></td></tr></table>");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_PAGE;
	}

	public String getCopies() {
		return copies;
	}

	public void setCopies(String copies) {
		this.copies = copies;
	}

	public String getIsCopiesEditable() {
		return isCopiesEditable;
	}

	public void setIsCopiesEditable(String isCopiesEditable) {
		this.isCopiesEditable = isCopiesEditable;
	}


}
