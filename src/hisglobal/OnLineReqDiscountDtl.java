package hisglobal;

import hisglobal.exceptions.HisException;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.sql.rowset.WebRowSet;

import billing.BillingBO;
import billing.BillingVO;

public class OnLineReqDiscountDtl implements Tag {
	PageContext pageContext;

	public String tmp = "";
	private String crNo = "0";
	private String mode = "1";
	private String deptCode = "0";
	
	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getCrNo() {
		return crNo;
	}

	public void setCrNo(String crNo) {
		this.crNo = crNo;
	}

	public int doEndTag() throws JspException {
		// TODO Auto-generated method stub
		return EVAL_PAGE;
	}

	public int doStartTag() throws JspException {

		JspWriter jw = pageContext.getOut();

		try {
			if (this.getMode().equals("2") || this.getMode().equals("6") || this.getMode().equals("7")) {
				
				if (this.getCrNo().length() > 1) jw.print(this.getOnlineRequestDtls());

			} else {
				jw.print(this.getOnLineCashDetailsView());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public WebRowSet getOnLineRequestWs() throws Exception {

		WebRowSet ws = null;
		BillingBO boObj = new BillingBO();
		BillingVO voObj = new BillingVO();
		voObj.setStrValue1(this.getCrNo());
		voObj.setStrValue3(pageContext.getSession().getAttribute("HOSPITAL_CODE").toString());
		voObj.setStrValue4(this.getDeptCode());
		try
		{
			
			boObj.getOnLineReqDiscount(voObj, this.getMode());
			
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}else{
				
				ws = voObj.getGblWs2();
				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			new HisException("Discount Approval Transaction",
					"OnLineReqDtl Tag.getOnLineRequestWs() -->", e
							.getMessage());
		}
		
		return ws;

	}

	public String getOnlineRequestDtls() 
	{
		// int rowSize = 0;
		String temp[] = new String[25];
		StringBuffer sb = new StringBuffer();
		WebRowSet wb = null;
		
		try {
			wb = getOnLineRequestWs();
			
			//if (onLineTemp.equals(this.getCrNo()))
			//{
				if (wb != null && wb.size() > 0) 
				{
					try 
					{
						// rowSize = wb.size();
						sb.append("<table class='TABLEWIDTH' align='center' border='0'> ");
						sb.append("<input type='hidden' name='tmpMsg' value="+tmp+">");
						sb.append("<tr><td colspan='6' class='TITLE'>OnLine Request</td></tr>");
						// HEADER
						sb.append("<tr><td width='5%' class='multiLabel'></td>");
						sb.append("<td width='16%' class='multiLabel'>Req No</td>");
						sb.append("<td width='16%' class='multiLabel'>Req Date</td>");
						sb.append("<td width='16%' class='multiLabel'>Dept/Ward</td>");
						sb.append("<td width='16%' class='multiLabel'>Hospital Service</td>");
						sb.append("<td width='16%' class='multiLabel'>Request Type</td></tr>");
						
					
						for (int i = 0; wb.next(); i++) 
						  {
							// Appended Value is   REQ_NO +"@"+ SBLNUM_BSERVICE_ID +"@"+HBLNUM_PATACCOUNT_NO+"@"+Hidden Value;
							String strChk = wb.getString(1) + "@" + wb.getString(5) + "@" + wb.getString(13)+"@"+wb.getString(20);
							  
							String strTemp[] = strChk.replace('@', '#').split("#");
							String strReqNo = wb.getString(1);
							String strReqDate = wb.getString(2);
							//System.out.println("OnLineReqDiscountDtl getOnlineRequestDtls wb.getString(3)"+wb.getString(3));
							String strDeptName = wb.getString(17);
							String strHospitalService = wb.getString(15);
							String strBId = wb.getString(5);
							String strReqType = wb.getString(16);
									
							String strHidVal = wb.getString(20);
							temp = strHidVal.replace("^", "#").split("#");
							String Temp[] = wb.getString(20).replace('^', '#').split("#");
							//System.out.println("wb.getString(20)Hidden Val--->"+wb.getString(20));
							String strName = strDeptName+"/"+Temp[17];
					
							if (strReqNo == null)
								strReqNo = "";
							if (strReqDate == null)
								strReqDate = "";
							if (strHospitalService == null)
								strHospitalService = "";
							if (strReqType == null)
								strReqType = "";
							if (strName == null)
								strName = "";
							
							sb.append("<input type='hidden' name='strName'  value='"+strName+"'>");
							sb.append("<input type='hidden' name='strBId'  value='"+wb.getString(5)+"'>");
							sb.append("<input type='hidden' name='strReqNo' value="+wb.getString(1)+">");
							sb.append("<input type='hidden' name='strChk' value="+strChk+">");
							sb.append("<input type='hidden' name='strHospService' value="+wb.getString(4)+">");
							sb.append("<input type='hidden' name='strReqType' value="+wb.getString(19)+">");
							sb.append("<tr><td width='5%' class='multiLabel'><input type='radio' style='cursor:pointer;cursor:hand' name='strChk_values' id='strChk_values' value=\""+strChk+"\"  onClick='groupCheck(this,"+i+");'");
							if (i == 0) 
							{
								sb.append("checked></td>");
							} 
							else 
							{
								sb.append("</td>");
							}
							sb.append("<td width='16%' class='multiControl'>");
							sb.append(strReqNo);
							sb.append("</td>");
							sb.append("<td width='16%' class='multiControl'>");
							sb.append(strReqDate);
							sb.append("</td>");
							sb.append("<td width='16%' class='multiControl'>");
							sb.append(strName);
							sb.append("</td>");
							sb.append("<td width='16%' class='multiControl'>");
							sb.append(strHospitalService);
							sb.append("</td>");
							sb.append("<td width='16%' class='multiControl'>");
							sb.append(strReqType);
							sb.append("</td></tr>");
						}
						sb.append(" </table> ");
					} catch (SQLException e) {
						e.printStackTrace();
						new HisException("Discount Approval Transaction",
								"OnLineReqDtl Tag.doStartTag() -->", e
										.getMessage());
					}
				}else{
					
					sb.append("<table class='TABLEWIDTH' align='center' border='0'> ");
					sb.append("<tr><td colspan='6' class='TITLE'>OnLine Request</td></tr>");
					sb.append("<tr><td colspan='6' width='5%' class='multiControl'><font style='color:red'>Request Not Available</font></td>");
					sb.append("</td></tr></table>");
					
				}
			//} else {

			//	sb.append("<input type='hidden' name='tmpMsg' value=" + tmp
						//+ ">");

			//}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			new HisException("Discount Approval Transaction",
					"OnLineReqDtl Tag.doStartTag() -->", e.getMessage());

		}
		finally
		{
			if (wb != null)
			{
				try {
					wb.close();
				}catch(Exception e) {}
				wb = null;
			}
		}
		
		return sb.toString();
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getOnLineCashDetailsView() {

		WebRowSet ws = null;

		StringBuffer sb = new StringBuffer("");
		boolean flag = true;
		try
		{
			ws = this.getOnLineRequestWs();

			if (ws != null) {

				sb.append("<table width='75%'>");

				while (ws.next()) {

					String strRequestNo = ws.getString(1);
					String strRequestDt = ws.getString(2);
					String strDeptCode = ws.getString(3);
					String strChargeTypeId = ws.getString(4);
					String strBServiceId = ws.getString(5);
					String strServiceId = ws.getString(6);
					String strGblReqNo = ws.getString(7);
					String strBillNo = ws.getString(8);
					String strPatCatCode = ws.getString(9);
					String strEpisodeCode = ws.getString(10);
					String strAdminNo = ws.getString(12);
					String strPatAccNo = ws.getString(13);
					String strApprovalId = ws.getString(14);
					String strHospServiceName = ws.getString(15);
					String strReqFor = ws.getString(16);
					String strDeptName = ws.getString(17);
					String strTreatCatName = ws.getString(18);

					if (strRequestNo == null)
						strRequestNo = "0";
					if (strRequestDt == null)
						strRequestDt = "";
					if (strDeptCode == null)
						strDeptCode = "0";
					if (strChargeTypeId == null)
						strChargeTypeId = "0";
					if (strBServiceId == null)
						strBServiceId = "0";
					if (strServiceId == null)
						strServiceId = "0";
					if (strGblReqNo == null)
						strGblReqNo = "0";
					if (strBillNo == null)
						strBillNo = "0";
					if (strPatCatCode == null)
						strPatCatCode = "0";
					if (strEpisodeCode == null)
						strEpisodeCode = "0";
					if (strAdminNo == null)
						strAdminNo = "";
					if (strPatAccNo == null)
						strPatAccNo = "";
					if (strApprovalId == null)
						strApprovalId = "0";
					if (strHospServiceName == null)
						strHospServiceName = "";
					if (strReqFor == null)
						strReqFor = "";
					if (strDeptName == null)
						strDeptName = "";
					if (strTreatCatName == null)
						strTreatCatName = "";

					sb.append("<tr>");
					if (flag) {
						sb
								.append("<td class='multiControl' width='6%'><input type='radio' checked='checked'");

						flag = false;
					} else {
						sb
								.append("<td class='multiControl' width='6%'><input type='radio'");
					}
					sb
							.append("onClick='setClientDetails(this,\"1\");' name='strOnLineData'");
					sb.append(" value='").append(strRequestNo).append("^")
							.append(strRequestDt).append("^").append(
									strDeptCode).append("^").append(
									strChargeTypeId).append("^").append(
									strBServiceId).append("^").append(
									strServiceId).append("^").append(
									strGblReqNo).append("^").append(strBillNo)
							.append("^").append(strPatCatCode).append("^")
							.append(strEpisodeCode).append("^").append(
									strAdminNo).append("^").append(strPatAccNo)
							.append("^").append(strApprovalId).append("^")
							.append(strTreatCatName).append("^").append(
									strReqFor).append("' >");
					sb.append("</td>");
					sb.append("<td class='multiControl' width='20%'>"
							+ strRequestNo + "</td>");
					sb.append("<td class='multiControl' width='20%'>"
							+ strRequestDt + "</td>");
					sb.append("<td class='multiControl' width='20%'>"
							+ strDeptName + "</td>");
					sb.append("<td class='multiControl' width='20%'>"
							+ strHospServiceName + "</td>");
					sb.append("<td class='multiControl' width='20%'>"
							+ strReqFor + "</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
			} else {
				sb.append("");
			}

		} catch (SQLException e) {
			new HisException("Global Tag",
					"OnLineReqDisountDtl.getOnLineDetailsView()-->", e
							.getMessage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new HisException("Global Tag",
					"OnLineReqDisountDtl.getOnLineDetailsView()-->", e
							.getMessage());
		}

		return sb.toString();
	}

}
