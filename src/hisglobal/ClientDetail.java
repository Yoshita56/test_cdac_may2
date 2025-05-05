package hisglobal;
import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.sql.rowset.WebRowSet;

import billing.BillingBO;
import billing.BillingVO;

public class ClientDetail implements Tag
{
	PageContext pageContext;

//	private WebRowSet webrowset = null;
	private String chk = "0";
	
		
	/*public WebRowSet getWebrowset() {
		return webrowset;
	}

	public void setWebrowset(WebRowSet webrowset) 
	{
		this.webrowset = webrowset;
	}*/

	public String getChk() {
		return chk;
	}

	public void setChk(String Chk)
	{
		this.chk = Chk;
	}

	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	public int doStartTag() throws JspException {

		try {
               
                  WebRowSet ws = getClientDtlsWs();
			
			
			if (ws != null) {

				try {
					if (ws.next()) {

		
						 JspWriter jw = pageContext.getOut();
				         
						 String strClientName  = ws.getString(1);
						 String strClientType  = ws.getString(2);
						 String strPaymentType = ws.getString(9);
						 String strRegNo       = ws.getString(3);
						 String strAddress     = ws.getString(5);
						 String strContactPerson = ws.getString(4);
						 String strContacNo      = ws.getString(6);
						 String strIsOPD = ws.getString(10);
						 String strIsIPD = ws.getString(11);
						 String strIsEME = ws.getString(12);
				 	     String strClientID = ws.getString(13);
				 	    						 
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
						jw.print("<tr><td width='25%' class='LABEL'>Client Name:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strClientName);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'>Client Type:</td>");
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

						jw.print("<tr><td colspan='4' class='TITLE'>Client Covers:</td></tr>");
                        
						jw.print("<tr><td colspan='4'>");
                        jw.print("<table width='100%' align='center'>");
                      
                        if(strIsOPD.trim().equals("1")&& strIsIPD.trim().equals("0")&& strIsEME.trim().equals("0"))
                        {
                        	jw.print("<tr><td width='33%'class='CONTROL'><input type='checkbox' name='isOPD' value='1' checked disabled>OPD Covers</td>");
                            jw.print("<td width='33%'class='CONTROL'><input type='checkbox' name='isIPD' value='0' disabled>IPD Covers</td>");
                            jw.print("<td width='33%' class='CONTROL'><input type='checkbox' name='isEME' value='0' disabled>Emergency Covers</td>");
                        }
                        if(strIsOPD.trim().equals("0")&& strIsIPD.trim().equals("1")&& strIsEME.trim().equals("0"))
                        {
                        	jw.print("<tr><td class='CONTROL'><input type='checkbox' name='isOPD' value='1'  disabled>OPD Covers</td>");
                            jw.print("<td class='CONTROL'><input type='checkbox' name='isIPD' value='0' checked disabled>IPD Covers</td>");
                            jw.print("<td class='CONTROL'><input type='checkbox' name='isEME' value='0' disabled>Emergency Covers</td>");
                        }
                        if(strIsOPD.trim().equals("0")&& strIsIPD.trim().equals("0") && strIsEME.trim().equals("1"))
                        {
                        	jw.print("<tr><td class='CONTROL'><input type='checkbox' name='isOPD' value='1' disabled>OPD Covers</td>");
                            jw.print("<td class='CONTROL'><input type='checkbox' name='isIPD' value='0' disabled>IPD Covers</td>");
                            jw.print("<td class='CONTROL'><input type='checkbox' name='isEME' value='0' checked disabled>Emergency Covers</td>");
                        }
					    jw.print("</tr>");
					    jw.print("</table>");
					    jw.print("</td></tr>");
					  }

				} catch (SQLException e)
				{
					e.printStackTrace();
					new HisException("Client Verific Transaction","Client Detail Tag.doStartTag() -->",e.getMessage());
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
public WebRowSet getClientDtlsWs()throws Exception{
		
		WebRowSet ws = null;
//		IpdBO boObj = new IpdBO();
//		IpdVO voObj = new IpdVO();
		BillingBO boObj = new BillingBO();
		BillingVO voObj = new BillingVO();
		
		voObj.setStrValue1(this.getChk());
		boObj.getClientDetails(voObj);
		
		if(voObj.getStrMsgType().equals("0")){
			
			if(voObj.getGblWs1().size() == 0){
				
				throw new Exception("invalid Chk Number");
				
			}
				
			else{
				
				ws = voObj.getGblWs1();
				
			}
		}
		
		return ws;
		
	}
}
