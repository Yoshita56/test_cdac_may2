package billing;
import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.sql.rowset.WebRowSet;

public class ClientDetail implements Tag
{
	PageContext pageContext;

	private WebRowSet webrowset = null;
	
	public WebRowSet getWebrowset() {
		return webrowset;
	}

	public void setWebrowset(WebRowSet webrowset) 
	{
		this.webrowset = webrowset;
	}

	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	public int doStartTag() throws JspException {

		try {
               
			if (this.getWebrowset() != null) 
			{
				try {
					
					boolean t = this.getWebrowset().next();
					if (t)
					{
		
						 JspWriter jw = pageContext.getOut();
				         
						 String strClientName  = this.getWebrowset().getString(1);
						 String strClientType  = this.getWebrowset().getString(2);
						 String strPaymentType = this.getWebrowset().getString(9);
						 String strRegNo       = this.getWebrowset().getString(3);
						 String strAddress     = this.getWebrowset().getString(5);
						 String strContactPerson = this.getWebrowset().getString(4);
						 String strContacNo      = this.getWebrowset().getString(6);
						 String strIsOPD = this.getWebrowset().getString(10);
						 String strIsIPD = this.getWebrowset().getString(11);
						 String strIsEME = this.getWebrowset().getString(12);
				 	     String strClientID = this.getWebrowset().getString(13);
				 	    						 
				 	    if(strClientID == null) 
				 	    	strClientID = "";
						if(strClientName == null) 
							strClientName = "";
						if(strClientType == null) 
							strClientType = "";
						if(strPaymentType == null) 
							strPaymentType = "";
						if(strRegNo == null)
							strRegNo = "";
						if(strAddress == null) 
							strAddress = "";
						if(strContactPerson == null)
							strContactPerson = "";
						if(strContacNo == null)
							strContacNo = "";
						if(strIsOPD == null) 
							strIsOPD = "";
						if(strIsIPD == null) 
							strIsIPD = "";
						if(strIsEME == null) 
							strIsEME = "";
					
						
						jw.print("<input type='hidden' name='strPaymentType' value="+strPaymentType+">");
						jw.print("<input type='hidden' name='strClientID' value="+strClientID+">");
						jw.print("<tr><td width='25%' class='LABEL'>Client Name</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strClientName);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'>Client Type</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strClientType);
   					    jw.print("</td></tr>");
    					jw.print("<tr><td width='25%' class='LABEL'>Reg No:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strRegNo);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'>Contact Person:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strContactPerson);
						jw.print("</td></tr>");
						jw.print("<tr><td width='25%' class='LABEL'>Address:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strAddress);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'>Contact No:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strContacNo);   
						jw.print("</td></tr>");
						jw.print("<tr><td width='25%' class='LABEL'>Payment Type:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strPaymentType);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'></td>");
						jw.print("<td width='25%' class='CONTROL'>");
						jw.print("</td></tr>");

						jw.print("<tr><td colspan='4' class='TITLE'>Client Covers</td></tr>");
                        
						jw.print("<tr><td colspan='4'>");
                        jw.print("<table width='100%' align='center'>");
                      
                        if(strIsOPD.trim().equals("1")&& strIsIPD.trim().equals("0")&& strIsEME.trim().equals("0"))
                        {
                        	jw.print("<tr><td width='33%'  class='CONTROL'><input type='checkbox' name='isOPD' value='1' checked disabled>OPD Covers</td>");
                            jw.print("<td width='33%'class='CONTROL'><input type='checkbox' name='isIPD' value='0' disabled>IPD Covers</td>");
                            jw.print("<td width='33%' class='CONTROL'><input type='checkbox' name='isEME' value='0' disabled>Emergency Covers</td>");
                        }
                        if(strIsOPD.trim().equals("0")&& strIsIPD.trim().equals("1")&& strIsEME.trim().equals("0"))
                        {
                        	jw.print("<tr><td class='LABEL'><input type='checkbox' name='isOPD' value='1'  disabled>OPD Covers</td>");
                            jw.print("<td class='LABEL'><input type='checkbox' name='isIPD' value='0' checked disabled>IPD Covers</td>");
                            jw.print("<td class='LABEL'><input type='checkbox' name='isEME' value='0' disabled>Emergency Covers</td>");
                        }
                        if(strIsOPD.trim().equals("0")&& strIsIPD.trim().equals("0") && strIsEME.trim().equals("1"))
                        {
                        	jw.print("<tr><td class='LABEL'><input type='checkbox' name='isOPD' value='1' disabled>OPD Covers</td>");
                            jw.print("<td class='LABEL'><input type='checkbox' name='isIPD' value='0' disabled>IPD Covers</td>");
                            jw.print("<td class='LABEL'><input type='checkbox' name='isEME' value='0' checked disabled>Emergency Covers</td>");
                        }
					    jw.print("</tr>");
					    jw.print("</table>");
					    jw.print("</td></tr>");
					  }

				} catch (SQLException e)
				{
			 
					new HisException("Client Verific Transaction","Client Detail Tag.doStartTag() -->",e.getMessage());
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
		 
			new HisException("Client Verific Transaction","Client Detail Tag.doStartTag() -->",e.getMessage());

		}

		return EVAL_BODY_INCLUDE;
	}

	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void release() {
		// TODO Auto-generated method stub

	}

	public void setPageContext(PageContext pageContext) {

		this.pageContext = pageContext;

	}

	public void setParent(Tag tag) {
		// TODO Auto-generated method stub

	}

}
