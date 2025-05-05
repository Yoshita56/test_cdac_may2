package hisglobal.tools.tag;
import hisglobal.presentation.WebUTIL;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;



public class ConfirmYesNoTag extends TagSupport
{
	String defaultSelected="";
	
	public String getDefaultSelected() {
		return defaultSelected;
	}

	public void setDefaultSelected(String defaultSelected) {
		this.defaultSelected = defaultSelected;
	}

	public int doStartTag() throws JspTagException
	{
		
		// get page context
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			out.println(getContent(request));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_BODY_INCLUDE;
		// String strDivBottom = getDivBottom();
	}

	public int doAfterBody()
	{
		try
		{
			JspWriter out = this.pageContext.getOut();
			HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
			out.println(getTransactionBottom(request));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_PAGE;
	}

	protected String getContent(HttpServletRequest _request)
	{
		String focus="document.getElementById('yesButton').focus();";
		if(getDefaultSelected().equalsIgnoreCase("NO"))
			focus="document.getElementById('noButton').focus();";
			
		
		
		String strDivTop = "\n<!-- Content Started -->\n " +
		" <div id=\"blanket\"  style=\"background-color:#111; opacity: 0.60; filter:alpha(opacity=60); position:absolute; z-index: 9001; top:0px; left:0px; width:100%;  height: 100%;display: none;\"></div>"+
		   " <div id=\"hisConfirm\" style=\"position:absolute;display:none;z-index: 9001;left: 30%;top:30%;height:128px;width:380px; background-image:url('../hisglobal/images/confirmYesNoImage.png'); \" > "+
		   " <div id=\"alertMessage1\" align=\"right\" style=\"position: absolute;left: 20%;top: 20%;\"></div>"+
		   " <div id=\"alertMessage2\" align=\"right\" style=\"position: absolute;left: 28%;top: 35%;\"></div>"+ 
		   
		   "<div id='yesNoButton' style='position:absolute;left: 33%; top: 58%;'><input type='button' value=' Yes ' onclick='confirmYesNo(true,event)' onkeyPress='if(event.keyCode=='13') confirmYesNo(true,event)' tabindex='1' id='yesButton' style='font-weight:bold;margin-right:10px;cursor:pointer;left: '><input type='button' value=' No ' tabindex='1' id='noButton'  style='font-weight:bold;margin-left:10px;cursor:pointer;' onclick='confirmYesNo(false,event)' onkeyPress='if(event.keyCode=='13') confirmYesNo(false,event)'></div>"+ 
		  " </div>	"+
		  "<script>var yesNoVar; function closehisConfirm(){document.getElementById('hisConfirm').style.display='none' ; disableBlanket();} " +
		  "function hisConfirm(msg1,msg2){ if(msg2=='undefined' || msg2==null)msg2=\"\";  " +
		  "if(msg1=='undefined' || msg1==null) {alert('Please Send  Some Message in the hisConfirm() function'); } " +
		  "else {  enableBlanket();document.getElementById('hisConfirm').style.display='block' ; " +
		  "document.getElementById('alertMessage1').innerHTML=\"<font color='Black' style='verdana' size='2'><strong>\"+msg1+\"</strong</font>\"; " +
		  "document.getElementById('alertMessage2').innerHTML=\"<font color='Black' style='verdana' size='2'><strong>\"+msg2+\"</strong</font>\";" +
		  focus+"}} " +
		  "function enableBlanket() { document.getElementById('blanket').style.display='block'; }" +
		  "function disableBlanket() { document.getElementById('blanket').style.display='none'; }</script>";
		
		return strDivTop;
	}

	protected String getTransactionBottom(HttpServletRequest _request)
	{
		String strDivBottom ="<!--Content of the Page ends -->";
		return strDivBottom;
	}



}
