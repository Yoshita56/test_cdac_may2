package hisglobal;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.sql.rowset.WebRowSet;

import billing.BillingBO;
import billing.BillingVO;
import hisglobal.exceptions.HisException;

public class AccountDtl implements Tag
{
	PageContext pageContext;

	public String tmp="";
	
	private String acctNo = "0";
	
	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	public int doStartTag() throws JspException {
		
		
		try {
			WebRowSet ws =   getAccountDtlWs();
			JspWriter jw = pageContext.getOut();
			if (ws != null)
			  {
				try 
				  {
					if (ws.next())
					{
						String strChargeTypeID = ws.getString(1);
						String strPatientCatCode = ws.getString(7);
						String strTreatmentCatg =	ws.getString(2);
						String strAddmnNo = 		ws.getString(5);
						String strAddmnDate = ws.getString(9);
						String strDeptName =			ws.getString(10);
						String strWardName =		new String("------");
						String strAccountNo =		this.getAcctNo();
						String strAccountType =				ws.getString(8);
						String strClientName  = ws.getString(26);
						String strApprovalNo  = ws.getString(24);
						String strSancAmt     = ws.getString(13);
						String strTotalRecdAmt = ws.getString(12);
						String strTotalExpAmt  = ws.getString(13);
						if(strTreatmentCatg == null) strTreatmentCatg = "";
						if(strAddmnNo == null) strAddmnNo = "";
						if(strAddmnDate == null) strAddmnDate = "";
						if(strDeptName == null) strDeptName = "";
						if(strWardName == null) strWardName = "";
						if(strAccountNo == null) strAccountNo = "";
						if(strAccountType == null) strAccountType = "";
						if(strClientName == null) strClientName = "";
						if(strApprovalNo == null) strApprovalNo = "";
						if(strSancAmt == null) strSancAmt = "";
						if(strTotalRecdAmt == null) strTotalRecdAmt = "";
						if(strTotalExpAmt == null) strTotalExpAmt = "";
						
						jw.print("<input type='hidden' name='strChargeTypeID' value="+strChargeTypeID+">");
						jw.print("<input type='hidden' name='strPatientCatCode' value="+strPatientCatCode+">");
						jw.print("<tr><td width='25%' class='LABEL'>TreatmentCategory:</td>");
						jw.print("<td colspan='3' width='25%' class='CONTROL'> ");
						   jw.print(strTreatmentCatg);
						jw.print("</td></tr>");
						jw.print("<tr><td width='25%' class='LABEL'>Addmission No:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strAddmnNo);
						jw.print("<td width='25%' class='LABEL'>Dept/Ward:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strDeptName);jw.print("/");jw.print(strWardName);
						jw.print("</td></tr>");
						jw.print("<tr><td width='25%' class='LABEL'>Addmission Date:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strAddmnDate);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'>Account No:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strAccountNo);
						jw.print("</td></tr>");
						jw.print("<tr><td width='25%' class='LABEL'>Account Type:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strAccountType);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'>Client Name:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strClientName);
						jw.print("</td></tr>");
						jw.print("<tr><td width='25%' class='LABEL'>Approval No:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strApprovalNo);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'>Sanc.Amt:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strSancAmt);
						jw.print("</td></tr>");
						jw.print("<tr><td width='25%' class='LABEL'>Total Recd Amt:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strTotalRecdAmt);
						jw.print("</td>");
						jw.print("<td width='25%' class='LABEL'>Total Expense Amt:</td>");
						jw.print("<td width='25%' class='CONTROL'>");
						   jw.print(strTotalExpAmt);
						jw.print("</td></tr>");
						
					}

				} 
				catch (SQLException e)
				{
					e.printStackTrace();
					new HisException("IPD Bill Management Transaction","AccountDtl.doStartTag() -->",e.getMessage());
				}
			}
		 
		 else
		 {
			// System.out.println("Cr.No. not matching");
			 jw.print("<input type='hidden' name='tmpMsg' value="+tmp+">");
			 
			//wb=null;
		 }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			new HisException("Discount Approval Transaction","OnLineReqDtl Tag.doStartTag() -->",e.getMessage());

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
	
public WebRowSet getAccountDtlWs()throws Exception{
		
		WebRowSet ws = null;
		BillingBO boObj = new BillingBO();
		BillingVO voObj = new BillingVO();
		
		voObj.setStrValue2(this.getAcctNo());
	
      //System.out.println("Acct No in JSP TLD:"+voObj.getStrValue2()); 
      
        if(this.getAcctNo()!=null)
        {
          boObj.getAccountDtlAcctNo(voObj);
        }
        else
        {
        	throw new Exception("invalid Account Number");
        }
        
		if(voObj.getStrMsgType().equals("0"))
		{
		try{
			if(voObj.getGblWs3().size() == 0)
			{
				throw new Exception("invalid Account Number");
				
			}
				
			else{
				
				ws = voObj.getGblWs3();
				
			}
			}catch(Exception e)
			{
				e.printStackTrace();
				new HisException("Discount Approval Transaction","OnLineReqDtl Tag.getOnLineRequestWs() -->",e.getMessage());	
			}
		}
		
		return ws;
		
	}



	
}
