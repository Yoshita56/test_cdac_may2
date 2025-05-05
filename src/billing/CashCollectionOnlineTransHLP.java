package billing;

import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.PatientDtlHLP;
import hisglobal.utility.HisUtil;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

import billing.BillConfigUtil;
import billing.BillingVO;
import billing.HLPbilling;

public class CashCollectionOnlineTransHLP {

	private static final String strColor = "red";
	private static final String defaultColor = "blue";
	//public static String treatcat="";
	/**
	 * returns the required Online Details View (HTML) in String format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Details View
	 */
	
	public static String getOnLineDetailsView_BS(CashCollectionOnlineTransVO voObj) 
	{
		WebRowSet ws = voObj.getOnlineDetails();
		StringBuffer sb = new StringBuffer("");
		boolean flag = true;
		int trfIndex=0;

		try 
		{
			if (ws != null && ws.size()>0) 
			{
				
				while (ws.next()) 
				{
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
					String strReqType = ws.getString(19);
					String strHiddenValue = ws.getString(20)+"^"+ws.getString(21)+"^"+ws.getString(22);
					String strProcessPenelty = ws.getString(21);
					String billcancelchk=ws.getString(22);
					/*strHiddenValue=REQNO||'^'||REQDATE||'^'||DEPTCODE||'^'||CHARGETYPE||'^'||BSERVICEID||'^'||SERVICEID||'^'||GSTRREQNO||'^'||BILLNO||'^'||
					CATCODE||'^'||EPISODECODE||'^'||ADMNO||'^'||ACCNO||'^'||APPID||'^'||REQTYPE||'^'||CATNAME|| '^'||RCPTNAME || '/' ||
					BSERVICENAME||'^'||IPDCHARGETYPENAME || '^' ||WARDNAME|| '^' || IPDCHARGETYPEID || '^' ||WARDCODE||'^'||RCPTNO||'^' ||
					STATUS||'^'||APPDTL ||'^'||CLIENTDTL||'^'||CLIENTDTLS||'^'||STRPACKAGEID*/
					

					String temp[] = strHiddenValue.replace("^", "#").split("#");
					String strWardName = temp[17];
					String strRequestStatus = temp[21];
			//		String strDate = temp[22];
			//		String strEmpName = temp[23];
					String strRemarks = temp[24];
					String reqType="";
					
					
					if(strServiceId.equals("1")||strServiceId.equals("4"))
						reqType="<i class='fas fa-flask text-success' title='LAB'></i><label class='labelcaps text-success'>&nbsp;LABS</label>";
						
					//if(strServiceId.equals("0")||strServiceId.equals("1"))
							
					else if(strServiceId.equals("3"))
						reqType="<i class='fas fa-burn text-danger' title='BLOOD BANK'></i><label class='labelcaps text-danger'>&nbsp;BLOOD BANK</label>";
					else	if(strServiceId.equals("5"))
						reqType="<i class='fas fa-cart-plus text-primary' title='INVENTORY'></i><label class='labelcaps text-primary'>&nbsp;INVENTORY</label>";
					else	if(strServiceId.equals("6"))
						reqType="<i class='fas fa-heartbeat text-warning' title='OT'></i><label class='labelcaps text-warning'>&nbsp;OT</label>";
					else if (strReqFor.contains("Refund"))
						reqType="<i class='fas fa-undo text-info' title='REFUND'></i><label class='labelcaps text-info'>&nbsp;REFUND</label>";
					else
						reqType="<i class='fas fa-bed text-success' title='IPD'></i><label class='labelcaps text-success'>&nbsp;IPD</label>";
					
					
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
					if (strWardName == null)
						strWardName = "";
					if (strProcessPenelty == null)
						strProcessPenelty = "";
					
						sb.append("<tr>");
					
					if(strRequestStatus.equals("1"))
					{					
							if (flag) 
							{		
								voObj.setStrBillNo(strBillNo);
								voObj.setStrBillingService(strBServiceId);
								voObj.setStrRequestType(strReqType);
								voObj.setStrRequestNo(strRequestNo);		
								
								sb.append("<td><label class='container'><input type='radio' checked='checked' name='onLineDataRadio'");		
								flag = false;
							} 
							else 
							{
								sb.append("<td><label class='container'><input type='radio' name='onLineDataRadio'");		
							}	
							
							System.out.println("strServiceId"+strServiceId+"reqType"+reqType+"strReqFor"+strReqFor);
							sb.append("onClick='setClientDetails(this,\"1\");' name='strOnLineData'");
							
							
							sb.append(" value='").append(strHiddenValue).append("' >");
							sb.append("<span class='checkmark'></span></label></td>");
					
							if(!billcancelchk.equals("0"))
							{
								sb.append("<td class='labelcaps'>"+ reqType + "</td>");
								sb.append("<td class='labelcaps'>"+ strRequestNo + "</td>");
								sb.append("<td class='labelcaps'>"+ strRequestDt + "</td>");
								sb.append("<td class='labelcaps'>"+ strDeptName + "/" + strWardName + "</td>");
								sb.append("<td class='labelcaps'>"+ strHospServiceName + "</td>");
								sb.append("<td class='labelcaps'>"+ strReqFor + "</td>");
								sb.append("<td>"+ strProcessPenelty + "</td>");
							}
							else
							{
								sb.append("<td class='labelcaps'>"+ reqType + "</td>");
								sb.append("<td class='labelcaps'>"+ strRequestNo + "</td>");
								sb.append("<td class='labelcaps'>"+ strRequestDt + "</td>");
								sb.append("<td class='labelcaps'>"+ strDeptName + "/" + strWardName + "</td>");
								sb.append("<td class='labelcaps'>"+ strHospServiceName + "</td>");
								sb.append("<td class='labelcaps'>"+ strReqFor + "</td>");
								sb.append("<td class='labelcaps'>"+ strProcessPenelty + "</td>");
							}
							
							sb.append("<input type='hidden' name='strProcessPenelty' id='strProcessPenelty"+ trfIndex+ "'  value='"+strProcessPenelty+"' >");
							sb.append("<input type='hidden' name='billcancelchk' id='billcancelchk"+ trfIndex+ "'  value='"+billcancelchk+"' >");
							
					}
					else
					{						
						sb.append("<td class='labelcaps'>");
						sb.append("<img onkeypress='onPressingEnter(this,event)' style='cursor: pointer;' onmouseover='Tip(\""+strRemarks+"\",SHADOW,true)' onmouseout='UnTip()'  src='../../hisglobal/images/info.png' align='middle'>");

						sb.append("</td>");
						
						if(!billcancelchk.equals("0"))
						{
							sb.append("<td style='color:red;' class='labelcaps'>"+ strRequestNo + "</td>");
							sb.append("<td style='color:red;' class='labelcaps'>"+ strRequestDt + "</td>");
							sb.append("<td style='color:red;' class='labelcaps'>"+ strDeptName + "/" + strWardName + "</td>");
							sb.append("<td style='color:red;' class='labelcaps'>"+ strHospServiceName + "</td>");
							sb.append("<td style='color:red;' class='labelcaps'>"+ strReqFor + "</td>");
							sb.append("<td style='color:red;' class='labelcaps'>"+ strProcessPenelty + "</td>");
						}
						else
						{

							sb.append("<td style='color:red;' class='labelcaps'>"+ strRequestNo + "</td>");
							sb.append("<td style='color:red;' class='labelcaps'>"+ strRequestDt + "</td>");
							sb.append("<td style='color:red;' class='labelcaps'>"+ strDeptName + "/" + strWardName + "</td>");
							sb.append("<td style='color:red;' class='labelcaps'>"+ strHospServiceName + "</td>");
							sb.append("<td style='color:red;' class='labelcaps'>"+ strReqFor + "</td>");
							sb.append("<td style='color:red;' class='labelcaps'>"+ strProcessPenelty + "</td>");
						}
						sb.append("<input type='hidden' name='strProcessPenelty' id='strProcessPenelty"+ trfIndex+ "'  value='"+strProcessPenelty+"' >");
						sb.append("<input type='hidden' name='billcancelchk' id='billcancelchk"+ trfIndex+ "'  value='"+billcancelchk+"' >");
					}					
					sb.append("</tr>");
					trfIndex++;
				}
				
				
			} 
			else 
			{
				sb.append("");
			}
		} catch (SQLException e) {
			new HisException("Cash Collection Trans","CashCollectionTransHLP.getOnLineDetailsView()-->", e.getMessage());
		}

		return sb.toString();
	}

	
	
	public static String getOnLineDetailsView(CashCollectionOnlineTransVO voObj) 
	{
		WebRowSet ws = voObj.getOnlineDetails();
		StringBuffer sb = new StringBuffer("");
		boolean flag = true;
		int trfIndex=0;

		try 
		{
			if (ws != null && ws.size()>0) 
			{
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");

				while (ws.next()) 
				{
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
					String strReqType = ws.getString(19);
					String strHiddenValue = ws.getString(20)+"^"+ws.getString(21)+"^"+ws.getString(22);
					String strProcessPenelty = ws.getString(21);
					String billcancelchk=ws.getString(22);
					/*strHiddenValue=REQNO||'^'||REQDATE||'^'||DEPTCODE||'^'||CHARGETYPE||'^'||BSERVICEID||'^'||SERVICEID||'^'||GSTRREQNO||'^'||BILLNO||'^'||
					CATCODE||'^'||EPISODECODE||'^'||ADMNO||'^'||ACCNO||'^'||APPID||'^'||REQTYPE||'^'||CATNAME|| '^'||RCPTNAME || '/' ||
					BSERVICENAME||'^'||IPDCHARGETYPENAME || '^' ||WARDNAME|| '^' || IPDCHARGETYPEID || '^' ||WARDCODE||'^'||RCPTNO||'^' ||
					STATUS||'^'||APPDTL ||'^'||CLIENTDTL||'^'||CLIENTDTLS||'^'||STRPACKAGEID*/
					

					String temp[] = strHiddenValue.replace("^", "#").split("#");
					String strWardName = temp[17];
					String strRequestStatus = temp[21];
			//		String strDate = temp[22];
			//		String strEmpName = temp[23];
					String strRemarks = temp[24];
					
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
					if (strWardName == null)
						strWardName = "";
					if (strProcessPenelty == null)
						strProcessPenelty = "";
					
						sb.append("<tr>");
					
					if(strRequestStatus.equals("1"))
					{					
							if (flag) 
							{		
								voObj.setStrBillNo(strBillNo);
								voObj.setStrBillingService(strBServiceId);
								voObj.setStrRequestType(strReqType);
								voObj.setStrRequestNo(strRequestNo);		
								
								sb.append("<td class='multiLabel' width='6%'><input type='radio' checked='checked' name='onLineDataRadio'");		
								flag = false;
							} 
							else 
							{
								sb.append("<td class='multiLabel' width='6%'><input type='radio' name='onLineDataRadio'");		
							}							
							sb.append("onClick='setClientDetails(this,\"1\");' name='strOnLineData'");
							
							
							sb.append(" value='").append(strHiddenValue).append("' >");
							sb.append("</td>");
					
							if(!billcancelchk.equals("0"))
							{
								sb.append("<td class='multiControlRed' width='20%'>"+ strRequestNo + "</td>");
								sb.append("<td class='multiControlRed' width='20%'>"+ strRequestDt + "</td>");
								sb.append("<td class='multiControlRed' width='20%'>"+ strDeptName + "/" + strWardName + "</td>");
								sb.append("<td class='multiControlRed' width='10%'>"+ strHospServiceName + "</td>");
								sb.append("<td class='multiControlRed' width='20%'>"+ strReqFor + "</td>");
								sb.append("<td class='multiControlRed' width='10%'>"+ strProcessPenelty + "</td>");
							}
							else
							{
								sb.append("<td class='multiControl' width='20%'>"+ strRequestNo + "</td>");
								sb.append("<td class='multiControl' width='20%'>"+ strRequestDt + "</td>");
								sb.append("<td class='multiControl' width='20%'>"+ strDeptName + "/" + strWardName + "</td>");
								sb.append("<td class='multiControl' width='10%'>"+ strHospServiceName + "</td>");
								sb.append("<td class='multiControl' width='20%'>"+ strReqFor + "</td>");
								sb.append("<td class='multiControl' width='10%'>"+ strProcessPenelty + "</td>");
							}
							
							sb.append("<input type='hidden' name='strProcessPenelty' id='strProcessPenelty"+ trfIndex+ "'  value='"+strProcessPenelty+"' >");
							sb.append("<input type='hidden' name='billcancelchk' id='billcancelchk"+ trfIndex+ "'  value='"+billcancelchk+"' >");
							
					}else
					{						
						sb.append("<td class='multiLabel' width='6%'>");
						sb.append("<img onkeypress='onPressingEnter(this,event)' style='cursor: pointer;' onmouseover='Tip(\""+strRemarks+"\",SHADOW,true)' onmouseout='UnTip()'  src='../../hisglobal/images/info.png' align='middle'>");

						sb.append("</td>");
						
						if(!billcancelchk.equals("0"))
						{
							sb.append("<td class='multiControlRed' width='20%' style='color:red;'>"+ strRequestNo + "</td>");
							sb.append("<td class='multiControlRed' width='20%' style='color:red;'>"+ strRequestDt + "</td>");
							sb.append("<td class='multiControlRed' width='20%' style='color:red;'>"+ strDeptName + "/" + strWardName + "</td>");
							sb.append("<td class='multiControlRed' width='10%' style='color:red;'>"+ strHospServiceName + "</td>");
							sb.append("<td class='multiControlRed' width='20%' style='color:red;'>"+ strReqFor + "</td>");
							sb.append("<td class='multiControlRed' width='10%' style='color:red;'>"+ strProcessPenelty + "</td>");
						}
						else
						{

							sb.append("<td class='multiControl' width='20%' style='color:red;'>"+ strRequestNo + "</td>");
							sb.append("<td class='multiControl' width='20%' style='color:red;'>"+ strRequestDt + "</td>");
							sb.append("<td class='multiControl' width='20%' style='color:red;'>"+ strDeptName + "/" + strWardName + "</td>");
							sb.append("<td class='multiControl' width='10%' style='color:red;'>"+ strHospServiceName + "</td>");
							sb.append("<td class='multiControl' width='20%' style='color:red;'>"+ strReqFor + "</td>");
							sb.append("<td class='multiControl' width='10%' style='color:red;'>"+ strProcessPenelty + "</td>");
						}
						sb.append("<input type='hidden' name='strProcessPenelty' id='strProcessPenelty"+ trfIndex+ "'  value='"+strProcessPenelty+"' >");
						sb.append("<input type='hidden' name='billcancelchk' id='billcancelchk"+ trfIndex+ "'  value='"+billcancelchk+"' >");
					}					
					sb.append("</tr>");
					trfIndex++;
				}
				
				sb.append("</table>");
			} 
			else 
			{
				sb.append("");
			}

		} catch (SQLException e) {
			new HisException("Cash Collection Trans","CashCollectionTransHLP.getOnLineDetailsView()-->", e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the required Online Client Details View (HTML) in String format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Client Details View
	 */
	public static String getOnLineClientDetailsView(CashCollectionOnlineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		/*WebRowSet wsClientDetails = voObj.getOnlineClientDetails();

		try {

			sb
					.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td class='TITLE' width='20'> ");
			sb
					.append("<div id='plusonLineClientDtlId' ><img style='cursor: hand; cursor: pointer' ");
			sb
					.append("	src='../../hisglobal/images/plus.gif' name='plusonLineClientDtl' ");
			sb.append("align='middle'  ");
			sb
					.append("onclick='showCltDetails(\"onLineClientDtlId\");' /></div> ");
			sb
					.append("<div id='minusonLineClientDtlId' style='display: none'><img  style='cursor: hand; cursor: pointer'    ");
			sb
					.append("src='../../hisglobal/images/minus.gif' name='minusonLineClientDtl' ");
			// sb.append("width='10' height='10' ");
			sb
					.append("onclick='hideCltDetails(\"onLineClientDtlId\");'></div> ");
			sb.append("</td> ");
			sb.append("<td colspan='3' class='TITLE'>Client Details</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			sb.append("<div id='onLineClientDtlId' style='display: none'>");
			sb.append("<table class='TABLEWIDTH' align='center'>");

			if (wsClientDetails != null && wsClientDetails.size() > 0) {

				if (wsClientDetails.next()) {

					String strClientName = wsClientDetails.getString(3);
					String strClientType = wsClientDetails.getString(4);
					String strApprovalNo = wsClientDetails.getString(5);
					String strSancAmount = wsClientDetails.getString(7);
					String strBalanceAmount = wsClientDetails.getString(9);
					String strPaidByClient = wsClientDetails.getString(18)
							.replace("^", "#").split("#")[2];

					if (strClientName == null)
						strClientName = "";
					if (strClientType == null)
						strClientType = "";
					if (strSancAmount == null)
						strSancAmount = "";
					// if(strClientName == null) strClientName = "";
					if (strBalanceAmount == null)
						strBalanceAmount = "";
					if (strApprovalNo == null)
						strApprovalNo = "";

					voObj.setStrClientName(strClientName);
					voObj.setStrClientType(strClientType);
					voObj.setStrClientApprovalNo(strApprovalNo);
					voObj.setStrSancAmount(strSancAmount);
					voObj.setStrClientBalance(strBalanceAmount);

					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABEL'>Client Name<input type='hidden' name='strOnlineClientDetails' value='"
									+ strClientName
									+ "^"
									+ strClientType
									+ "^"
									+ strSancAmount
									+ "^"
									+ strBalanceAmount
									+ "^" + strApprovalNo + "^"+strPaidByClient+"'></td>");
					sb.append("<td width='25%' class='CONTROL'>"
							+ strClientName + "</td>");
					sb.append("<td width='25%' class='LABEL'>Client Type</td>");
					sb.append("<td width='25%' class='CONTROL'>"
							+ strClientType + "</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABEL'>Sanction Amount</td>");
					sb.append("<td width='25%' class='CONTROL'>"
							+ strSancAmount + "</td>");
					sb
							.append("<td width='25%' class='LABEL'>Approval No.</td>");
					sb.append("<td width='25%' class='CONTROL'>"
							+ strApprovalNo + "</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb
							.append("<td width='25%' class='LABEL'>Balance Amount</td>");
					sb.append("<td width='25%' class='CONTROL'>"
							+ strBalanceAmount + "</td>");
					sb
							.append("<td width='25%' class='LABEL'>Paid by Client</td>");
					sb.append("<td class='CONTROL'>" + strPaidByClient
							+ "</td>");
					sb.append("</tr>");
				}

				sb.append("</table>");
				sb.append("</div>");

			} else {
				sb = new StringBuffer("");
			}

		} catch (SQLException e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getOnLineClientDetailsView()-->", e
							.getMessage());
		}*/

		return sb.toString();
	}

	/**
	 * returns the required Online Other Details View (HTML) in String format.
	 * 
	 * @param voObj
	 * @return
	 */
	public static String getOnlineOtherDetails(CashCollectionOnlineTransVO voObj) 
	{
		String strAccNo = voObj.getStrAccountNo();
		String strTreatCat = voObj.getStrTreatmentCategory();

		StringBuffer sb = new StringBuffer("");

		if (!strAccNo.equals("0") && !strTreatCat.equals("")) 
		{
		/*	sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			sb.append("<tr>");

			sb.append("<td class='TITLE' width='20'> ");
			sb.append("<div id='plusonLineOtherDtlId' ><img  style='cursor: hand; cursor: pointer'    ");
			sb.append("src='../../hisglobal/images/plus.gif' name='plusonLineOtherDtl' ");
			sb.append("align='middle' ");
			sb.append("onclick='showCltDetails(\"onLineOtherDtlId\");' /></div> ");
			sb.append("<div id='minusonLineOtherDtlId' style='display: none'><img  style='cursor: hand; cursor: pointer'    ");
			sb.append("src='../../hisglobal/images/minus.gif' name='minusonLineOtherDtl' ");
			sb.append("onclick='hideCltDetails(\"onLineOtherDtlId\");'></div> ");
			sb.append("</td> ");
			sb.append("<td colspan='3' class='TITLE'>Other Details</td>");
			sb.append("</tr>");
			sb.append("</table>");

			sb.append("<div id='onLineOtherDtlId' style='display: none'>");
			sb.append("<table class='TABLEWIDTH' align='center'>");
			sb.append("<tr>");

			sb.append("<td width='25%' class='LABEL'>Account No.</td>");
			sb.append("<td width='25%' class='CONTROL'>" + strAccNo + "</td>");

			sb.append("<td width='25%' class='LABEL'>Treatment Category</td>");
			sb.append("<td width='25%' class='CONTROL'>" + strTreatCat+ "</td>");

			sb.append("</tr>");

			sb.append("</table>");
			sb.append("</div>");*/

		}

		return sb.toString();

	}

	/**
	 * returns the required Online Tariff Details View (HTML) in String format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Tariff Details View
	 */
	
	public static String getOnLineTariffDetailsView(CashCollectionOnlineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");
		String temp="";
		int trfIndex = 0;
		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();
		BillConfigUtil bcu=null;

		try 
		{
			bcu=new BillConfigUtil(voObj.getStrHospitalCode());
			if (wsTariffDetails != null) 
			{
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr><td colspan='11'><div class='line'><label class='DIVLABEL'>Tariff Detail</label></div></td></tr>");
				sb.append("<tr>");
				sb.append("<td class='multiLabel'><div align='left'><input type='checkbox' onclick='selectAllCheckBoxes(this)' name='selectAllChk'>All</div></td>");
				sb.append("<td class='multiLabel'>S.No.</td>");
				sb.append("<td class='multiLabel'>Tariff Name</td>");
				sb.append("<td class='multiLabel'>Rate/Unit</td>");
				sb.append("<td class='multiLabel'>Req Qty<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' ></td>");
				sb.append("<td class='multiLabel'>Billed Qty<input type='hidden' class='txtFldMin' name='strTotalTariffDiscountAmount' value='0' ></td></td>");
				sb.append("<td class='multiLabel'>Unit<input type='hidden' class='txtFldMin' name='strTotalTariffActualAmount' value='0' ></td></td>");
				sb.append("<td class='multiLabel'>Discount/Waived Amt</td>");
				sb.append("<td class='multiLabel'>Payment Type</td>");
				if(bcu.getStrCreditCashlessAppRequired().equals("1"))
				{
					sb.append("<td class='multiLabel'>Letter No/Date/Client/Limit/Card-Emp No./Emp Name</td>");
				}
				else					
					sb.append("<td class='multiLabel'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details</label></td>");//<input type='checkbox' name='strSameCreditDtlsChk' onclick='applySameCreditDtls(this)'>Apply All</td>");
				
				sb.append("<td class='multiLabel'>Net Tariff Amt(<font color='red'>*</font>)</td>");				
				sb.append("</tr>");
				int i =0;
				if(wsTariffDetails.size() == 0)
				{
					sb.append("<tr><td colspan='9'><div align='center'><b><font color='red'>NO DATA FOUND/CREDIT BILL NOT APPROVED</font></b></div></td></tr>");
				}				
				while (wsTariffDetails.next()) 
				{
					i++;
					
					trfIndex = trfIndex + 1;

					String strGroupId = wsTariffDetails.getString(1);
					String strTariffId = wsTariffDetails.getString(2);
					String strChargeTypeId = wsTariffDetails.getString(3);
					String strGblTariffId = wsTariffDetails.getString(4);
					String strRateUnitId = wsTariffDetails.getString(5);
					String strApprovalId = wsTariffDetails.getString(6);
					// String strBserviceType = wsTariffDetails.getString(7);
					String strTariffName = wsTariffDetails.getString(7);

					// String strGroupName = wsTariffDetails.getString(9);
					String strUnitName = wsTariffDetails.getString(10);
					String strReqQty = wsTariffDetails.getString(11);
					String strBillQty = wsTariffDetails.getString(12);
					String strTariffRate = wsTariffDetails.getString(13);
					String strDisountUnit = wsTariffDetails.getString(14);
					String strDiscountType = wsTariffDetails.getString(15);
					String strQtyUnitName = wsTariffDetails.getString(18);
					String strQtyUnitId = wsTariffDetails.getString(19);
					String strIsPackage = wsTariffDetails.getString(20);
					String strServiceTax = wsTariffDetails.getString(21);
					String strPenelty = wsTariffDetails.getString(22);
					String strApprovalDtl = wsTariffDetails.getString(23);
					// String strQtyType = wsTariffDetails.getString(24);
					String strRateBaseVal = wsTariffDetails.getString(25);
					String strQtyBaseVal = wsTariffDetails.getString(26);
					String strNetCost = wsTariffDetails.getString(27);
					String strReceiptNo = wsTariffDetails.getString(28);
					String strActualRate = wsTariffDetails.getString(29);
					String strServiceId  = wsTariffDetails.getString(30);
					String strConsumableCharge  = wsTariffDetails.getString(32);
					String strClNo  = wsTariffDetails.getString(33);
					String strClDate  = wsTariffDetails.getString(34);
					String strPaidByPat  = wsTariffDetails.getString(35);
					String strPaidByClient  = wsTariffDetails.getString(36);
					String strCreditBillFlag  = wsTariffDetails.getString(37);
					String strCreditFilePath  = wsTariffDetails.getString(38);
					String strCreditClientNo  = wsTariffDetails.getString(39);
					String strCreditBillStatus  = wsTariffDetails.getString(40);
					String strCreditClientName  = wsTariffDetails.getString(41);
					String strCatGroup  	= wsTariffDetails.getString(47);//3,4- Credit,0-Paid
					String wchFlag = wsTariffDetails.getString(48);
					String urgentFlag = wsTariffDetails.getString(49);
					// String strDisountType =
					// wsTariffDetails.getString(15);

					if (strGroupId == null)
						strGroupId = "";
					if (strTariffId == null)
						strTariffId = "";
					if (strChargeTypeId == null)
						strChargeTypeId = "";
					if (strGblTariffId == null)
						strGblTariffId = "";
					if (strRateUnitId == null)
						strRateUnitId = "";
					if (strApprovalId == null)
						strApprovalId = "";
					if (strTariffName == null)
						strTariffName = "";
					if (strReqQty == null)
						strReqQty = "0";
					if (strBillQty == null)
						strBillQty = "0";
					if (strTariffRate == null)
						strTariffRate = "0";
					if (strDisountUnit == null)
						strDisountUnit = "0";
					if (strRateBaseVal == null)
						strRateBaseVal = "";
					if (strQtyBaseVal == null)
						strQtyBaseVal = "";

					String strHiddenVal = strTariffId + "^" + strReqQty + "*"
							+ strQtyBaseVal + "^" + strQtyUnitId + "^"
							+ strTariffRate + "^" + strRateUnitId + "^"
							+ strGroupId + "^" + strActualRate + "^"
							+ strServiceTax + "^" + strDisountUnit + "^"
							+ strDiscountType + "^" + strGblTariffId + "^"
							+ strApprovalId + "^" + strUnitName + "^"
							+ strRateBaseVal + "^" + strIsPackage + "^"
							+ strNetCost + "^" + strPenelty + "^" + "0^"
							+ strReceiptNo + "^" + strApprovalDtl+"^"+strServiceId+"^"+strConsumableCharge;
					
					sb.append("<tr>");
					sb.append("<td class='multiControl'><div align='left'><input type='checkbox' name='strTariffDetailsId' value='"+strHiddenVal+"' id='strTariffDetailsChkId"+trfIndex+"' onclick='setOnlineTariffDetails(this, \""+ trfIndex + "\")'></div></td>");
					
					sb.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffSno' id='strTariffSno"+ trfIndex+ "' value='"+ trfIndex+ "' disabled='disabled'>"+ trfIndex+ "</td>");
					sb.append("<td class='multiControl'><a name='strBillTariffName' id='strBillTariffName"+ trfIndex+ "' style='cursor:pointer; color:blue' value='"+ strHiddenVal+ "'  onClick='showTariffPopup(this,\""+ strHiddenVal+ "\");'>"+ strTariffName+ "</a><input type='hidden' class='txtFldMin' name='strTariffServiceTaxAmt' id='strTariffServiceTaxAmt"+ trfIndex+ "' value='' disabled='disabled'></td>");
					sb.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffRate' id='strTariffRate"+ trfIndex+ "' value='"+ strTariffRate+ "' disabled='disabled'>"+ strTariffRate+ "/"+ strUnitName+ "<input type='hidden' class='txtFldMin' name='strTariffActualAmt' id='strTariffActualAmt"+ trfIndex+ "' value='0' disabled='disabled'></td>");
					sb.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffReqQty' id='strTariffReqQty"+ trfIndex+ "' value='"+ strReqQty+ "' disabled='disabled'>"+ strReqQty+ "/" + strQtyUnitName + "</td>");
					sb.append("<td class='multiControl'><input type='text' class='txtFldMin' name='strTariffBilledQty' id='strTariffBilledQty"+ trfIndex+ "' onkeyup='setOnlineTariffDltsOnQtyChange(this, \""+ strHiddenVal+ "\", \""+ trfIndex+ "\");' value='0' disabled='disabled'></td>");

					sb.append("<td width='10%' class='multiControl'>");

					sb.append("<select class='comboMin'  onchange='setOnlineTariffDltsOnQtyUnitChange(this, \""+ strHiddenVal+ "\", \""+ trfIndex+ "\");'  "
									+ "name='strBillTariffUnit' id='strBillTariffUnit"+ trfIndex + "' disabled='disabled' > ");

					voObj.setStrOffLineTariffUnitTempId(strQtyUnitId);
					/*voObj.setStrTreatmentCategory("68");
					voObj.setStrTempTrfId(strTariffId);
					voObj.setStrTempTrfQty(strReqQty);				
					
					CashCollectionOnlineTransDAO.getOnlineTrfPackageAvailedList(voObj);
					
					if (voObj.getStrTempPkgWb() != null && voObj.getStrTempPkgWb().size() > 0) 
					{
						temp=new HisUtil("", "").getOptionValue(voObj.getStrTempPkgWb(), "", "", false);
					}*/

					/*CashCollectionOnlineTransDAO.getOffLineTariffUnitList(voObj);

					if (voObj.getOfflineTariffUnit() != null && voObj.getOfflineTariffUnit().size() > 0) 
					{
						sb.append(new HisUtil("", "").getOptionValue(voObj.getOfflineTariffUnit(), strQtyUnitId + "^"+ strQtyBaseVal, "0^Select Value", false));
					} 
					else 
					{
						sb.append("<option value='0'>Select Value</option>");
					}*/
					sb.append(BillConfigUtil.getDefaultUnitComboWithBaseValue(strQtyUnitId + "^"+ strQtyBaseVal));

					sb.append("</select>");
					sb.append("</td>");

					sb.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffDiscountAmt' id='strTariffDiscountAmt"+ trfIndex+ "' value='0' disabled='disabled'><div id='strTariffDiscountAmtDivId"+ trfIndex + "'>0.00</div></td>");
					
					//adding credit letter details
					
					
					if(bcu.getStrCreditCashlessAppRequired().equals("1"))
					{
						sb.append("<td width='10%' class='multiControl'>");
						sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType"+ trfIndex + "' disabled='disabled' > ");
						/*if(!temp.equals(""))
							sb.append(temp);*/
						if(urgentFlag.equals("2"))
							sb.append("<option value='12'>Paid(Urgent)</option>");
						else
						{
							sb.append("<option value='10'>Paid</option>");
						}
						sb.append("</select>");
						sb.append("</td>");
				
						sb.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strCreditLetterNo' id='strCreditLetterNo"+ trfIndex+ "' value='"+ strClNo+ "' >"+ strClNo+ "/"+ strClDate+ "");
						sb.append("<input type='hidden' class='txtFldMin' name='strCreditLetterDate' id='strCreditLetterDate"+ trfIndex+ "' value='"+strClDate+"' >");
						sb.append("<input type='hidden' class='txtFldMin' name='strPaidByPat' id='strPaidByPat"+ trfIndex+ "' value='"+strPaidByPat+"' disabled='disabled'>");
						sb.append("<input type='hidden' class='txtFldMin' name='strPaidByClient' id='strPaidByClient"+ trfIndex+ "' value='"+strPaidByClient+"' disabled='disabled'>");
						sb.append("<input type='hidden' class='txtFldMin' name='strCreditBillFlag' id='strCreditBillFlag"+ trfIndex+ "' value='"+strCreditBillFlag+"'>");
						sb.append("<input type='hidden' class='txtFldMin' name='strCreditFilePath' id='strCreditFilePath"+ trfIndex+ "' value='"+strCreditFilePath+"'>");
						sb.append("<input type='hidden' class='txtFldMin' name='strCreditClientNo' id='strCreditClientNo"+ trfIndex+ "' value='"+strCreditClientNo+"'>");
						sb.append("<input type='hidden' class='txtFldMin' name='strCreditBillStatus' id='strCreditBillStatus"+ trfIndex+ "' value='"+strCreditBillStatus+"'>");
						sb.append("<input type='hidden' class='txtFldMin' name='strCreditClientName' id='strCreditClientName"+ trfIndex+ "' value='"+strCreditClientName+"' ></td>");
					}
					else if(strCatGroup.equals("3") || strCatGroup.equals("4"))
					{
						//CashCollectionOnlineTransDAO.getCreditLettersList(voObj);
						
						
						
						//adding Credit Client Details ....
						
						BillingVO voBilling=new BillingVO();
						voBilling.setStrValue1(voObj.getStrCrNo());
						voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
						voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
						voBilling.setStrServiceType("1");//1-OP CONSULATION ONLY,OP & INV ,2-IP ONLY & IP & INV
						String creditListCombo=HLPbilling.getCreditLetterListComboOnline(voBilling,Integer.toString(trfIndex),true,true); 
						
						
						
						
						
						
						sb.append("<td width='10%' class='CONTROL'>");
						sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType"+ trfIndex + "' disabled='disabled' onchange='calcCreditAmount(this,\""+trfIndex+"\");'> ");
						/*if(!temp.equals(""))
							sb.append(temp);*/
						if(wchFlag.equals("1"))
						{
							if(urgentFlag.equals("2"))
								sb.append("<option value='12'>Paid(Urgent)</option>");
							else
							{
								sb.append("<option value='10'>Paid</option>");
							}
						}
						else
						{
							if(urgentFlag.equals("2"))
							{
								sb.append("<option value='13'>Credit(Urgent)</option>");
								sb.append("<option value='12'>Paid(Urgent)</option>");
							}
							else
							{
								sb.append("<option value='11'>Credit</option>");
								sb.append("<option value='10'>Paid</option>");
							}
						}
						sb.append("</select>");
						sb.append("</td>");
						
						sb.append("<td class='CONTROL'><div align='center'>");
						sb.append(creditListCombo);
						
						/*sb.append("<td class='multiControl'>");						
						sb.append("<select class='comboMax' name='strCreditLetterNo' id='strCreditLetterNo"+ trfIndex + "' disabled='disabled'> ");
						
						if (voObj.getCreditLettersWS() != null && voObj.getCreditLettersWS().size() > 0) 
						{
							sb.append(new HisUtil("Billing", "CashCollectionOnlineHLP").getOptionValue(voObj.getCreditLettersWS(), "", "0^Select Value", false));
							sb.append("</select>");
						} 
						else 
						{
							sb.append("<option value='0'>Select Value</option>");
							sb.append("</select>");
							if(trfIndex==1)//GIVE PLUS BUTTON ON FIRST ROW ONLY. IN ONE BILL ONLY ONE CREDIT LETTER WILL BE CONSUMED.IF ALREADY CREDIT LETTER PRESENT THEN USER NOT ALLOWED TO ADD NEW LETTER
							sb.append("<img onkeypress='onPressingEnter(this,event)' id='addCreditLetter"+ trfIndex + "' style='cursor: pointer;' onclick='addNewCreditLetter(this)' src='../../hisglobal/images/plus.gif' align='middle'>");
						}	*/					
						
						
						//sb.append("<td class='multiControl'><input type='text' class='txtFldMin' name='strCreditLetterNo' id='strCreditLetterNo"+ trfIndex+ "' value='"+ strClNo+ "' >");
						//sb.append("<input type='text' class='txtFldMin' name='strCreditLetterDate' id='strCreditLetterDate"+ trfIndex+ "' value='"+strClDate+"'>");
						//sb.append(HisUtil.getDatePickerMultiRowTLD("strCreditLetterDate", "", true,(trfIndex-1)));
						sb.append("<input type='hidden' class='txtFldMin' name='strPaidByPat' id='strPaidByPat"	+ trfIndex+ "' value='"	+strPaidByPat+"' disabled='disabled'>");
						sb.append("<input type='hidden' class='txtFldMin' name='strPaidByClient' id='strPaidByClient"+ trfIndex+ "' value='"+strPaidByClient+"' disabled='disabled'>");
						//sb.append("<input type='hidden' class='txtFldMin' name='strCreditBillFlag' id='strCreditBillFlag"+ trfIndex+ "' value='"+strCreditBillFlag+"' >");
						//sb.append("<input type='hidden' class='txtFldMin' name='strCreditFilePath' id='strCreditFilePath"+ trfIndex	+ "' value='"+strCreditFilePath	+"' >");
						//sb.append("<input type='hidden' class='txtFldMin' name='strCreditClientNo' id='strCreditClientNo"+ trfIndex+ "' value='"+strCreditClientNo+"' >");
						//sb.append("<input type='hidden' class='txtFldMin' name='strCreditBillStatus' id='strCreditBillStatus"+ trfIndex	+ "' value='"+strCreditBillStatus+"' >");
						//sb.append("<input type='hidden' class='txtFldMin' name='strCreditClientName' id='strCreditClientName"+ trfIndex+ "' value='" +strCreditClientName+"' >");
						sb.append("</div></td>");
					}
					else
					{
					
						sb.append("<td width='10%' class='multiControl'>");
						sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType"+ trfIndex + "' disabled='disabled' > ");
						
						/*if(!temp.equals(""))
							sb.append(temp);*/
						
						if(urgentFlag.equals("2"))
							sb.append("<option value='12'>Paid(Urgent)</option>");
						else
						{
							sb.append("<option value='10'>Paid</option>");
						}
						sb.append("</select>");
						sb.append("</td>");
						
						BillingVO voBilling=new BillingVO();
						voBilling.setStrValue1(voObj.getStrCrNo());
						voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
						voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
						voBilling.setStrServiceType("1");//1-OP CONSULATION ONLY,OP & INV ,2-IP ONLY & IP & INV
						String creditListCombo=HLPbilling.getCreditLetterListComboEmpty(voBilling,Integer.toString(trfIndex),true,true); 
						
						sb.append("<td class='CONTROL'><div align='center'>");
						sb.append(creditListCombo);
				
						//sb.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strCreditLetterNo' id='strCreditLetterNo"+ trfIndex+ "' value='"+ strClNo+ "' >"+ strClNo+ "/"+ strClDate+ "");
						//sb.append("<input type='hidden' class='txtFldMin' name='strCreditLetterDate' id='strCreditLetterDate"+ trfIndex+ "' value='"+strClDate+"'>");
						sb.append("<input type='hidden' class='txtFldMin' name='strPaidByPat' id='strPaidByPat"+ trfIndex+ "' value='"+strPaidByPat+"' disabled='disabled'>");
						sb.append("<input type='hidden' class='txtFldMin' name='strPaidByClient' id='strPaidByClient"+ trfIndex+ "' value='"+strPaidByClient+"' disabled='disabled'>");
						//sb.append("<input type='hidden' class='txtFldMin' name='strCreditBillFlag' id='strCreditBillFlag"+ trfIndex+ "' value='"+strCreditBillFlag+"'>");
						//sb.append("<input type='hidden' class='txtFldMin' name='strCreditFilePath' id='strCreditFilePath"+ trfIndex+ "' value='"+strCreditFilePath+"'>");
						//sb.append("<input type='hidden' class='txtFldMin' name='strCreditClientNo' id='strCreditClientNo"+ trfIndex+ "' value='"+strCreditClientNo+"'>");
						//sb.append("<input type='hidden' class='txtFldMin' name='strCreditBillStatus' id='strCreditBillStatus"+ trfIndex+ "' value='"+strCreditBillStatus+"'>");
						//sb.append("<input type='hidden' class='txtFldMin' name='strCreditClientName' id='strCreditClientName"+ trfIndex+ "' value='"+strCreditClientName+"' ></td>");
						
						sb.append("</td>");
					}
					
					
					sb.append("<td class='multiControl' style='font-weight:bold'>");
					sb.append("<input type='hidden' class='txtFldMin' name='strTariffNetAmt' id='strTariffNetAmt"+ trfIndex+ "' value='0' disabled='disabled'>");
					sb.append("<div id='strTariffNetAmtDivId"+ trfIndex + "'>0.00</div></td>");
					if(i==wsTariffDetails.size())
					{
						i++;
						System.out.println("i"+i);
						//sb.append("<input type='hidden' name='strTariffDetailsId'  id='strTariffDetailsChkId"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strCreditPaymentType'  id='strCreditPaymentType"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strCreditLetterNo'  id='strCreditLetterNo"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strTariffBilledQty'  id='strTariffBilledQty"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strBillTariffUnit'  id='strBillTariffUnit"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strTariffDiscountAmt'  id='strTariffDiscountAmt"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strTariffServiceTaxAmt'  id='strTariffServiceTaxAmt"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strTariffNetAmt'  id='strTariffNetAmt"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strPaidByPat'  id='strPaidByPat"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strPaidByClient'  id='strPaidByClient"+i+"' value='0'>");
					}
					sb.append("</tr>");

				}
				sb.append("</table>");
                
			}
		} 
		catch (Exception e) 
		{
			new HisException("Billing","CashCollectionTransHLP.getOnLineTariffDetailsView()-->", e.getMessage());
		}

		return sb.toString();
	}
	
	
	public static String getOnLineTariffDetailsView_BS(CashCollectionOnlineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");
		String temp="";
		int trfIndex = 0;
		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();
		BillConfigUtil bcu=null;

		try 
		{
			bcu=new BillConfigUtil(voObj.getStrHospitalCode());
			if (wsTariffDetails != null) 
			{
				sb.append("<div class='subHeaders'><i class=\"fas fa-clipboard-list\" style=\"font-size: 26px;\">&nbsp;</i>&nbsp;Tariff Details</div>");
				
				sb.append("<table class='table'>");
				sb.append("<thead>");
				sb.append("<tr>");
				
				sb.append("<th><div class=\"form-group\"><input type='checkbox' onclick='selectAllCheckBoxes(this)' name='selectAllChk' id='selectAllChk'><label for='selectAllChk'></label></div></th>");
				 
				//sb.append("<th>#</th>");
				sb.append("<th>Tariff Name</th>");
				sb.append("<th>Rate/Unit</th>");
				sb.append("<th>Req Qty<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' ></th>");
				sb.append("<th>Billed Qty<input type='hidden' class='txtFldMin' name='strTotalTariffDiscountAmount' value='0' ></th>");
				sb.append("<th>Unit<input type='hidden' class='txtFldMin' name='strTotalTariffActualAmount' value='0' ></th>");
				sb.append("<th>Disc. Amt</th>");
				sb.append("<th style='display:none;'>Payment Type</th>");
				if(bcu.getStrCreditCashlessAppRequired().equals("1"))
				{
					sb.append("<th>Letter No/Date/Client/Limit/Card-Emp No./Emp Name</th>");
				}
				else					
					sb.append("<th><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='margin-bottom: 0;'>Credit Details</label></th>");//<input type='checkbox' name='strSameCredithtlsChk' onclick='applySameCredithtls(this)'>Apply All</th>");
				
				sb.append("<th style='text-align:right'>Net Amt(<font color='red'>*</font>)</th>");				
				sb.append("</tr>");
				sb.append("</thead>");
				sb.append("<tbody>");
				int i =0;
				if(wsTariffDetails.size() == 0)
				{
					sb.append("<tr><td colspan='9'><div align='center'><b><font color='red'>NO DATA FOUND/CREDIT BILL NOT APPROVED</b></div></td></tr>");
				}				
				while (wsTariffDetails.next()) 
				{
					i++;
					
					trfIndex = trfIndex + 1;

					String strGroupId = wsTariffDetails.getString(1);
					String strTariffId = wsTariffDetails.getString(2);
					String strChargeTypeId = wsTariffDetails.getString(3);
					String strGblTariffId = wsTariffDetails.getString(4);
					String strRateUnitId = wsTariffDetails.getString(5);
					String strApprovalId = wsTariffDetails.getString(6);
					String strTariffName = wsTariffDetails.getString(7);

					String strUnitName = wsTariffDetails.getString(10);
					String strReqQty = wsTariffDetails.getString(11);
					String strBillQty = wsTariffDetails.getString(12);
					String strTariffRate = wsTariffDetails.getString(13);
					String strDisountUnit = wsTariffDetails.getString(14);
					String strDiscountType = wsTariffDetails.getString(15);
					String strQtyUnitName = wsTariffDetails.getString(18);
					String strQtyUnitId = wsTariffDetails.getString(19);
					String strIsPackage = wsTariffDetails.getString(20);
					String strServiceTax = wsTariffDetails.getString(21);
					String strPenelty = wsTariffDetails.getString(22);
					String strApprovalDtl = wsTariffDetails.getString(23);
					String strRateBaseVal = wsTariffDetails.getString(25);
					String strQtyBaseVal = wsTariffDetails.getString(26);
					String strNetCost = wsTariffDetails.getString(27);
					String strReceiptNo = wsTariffDetails.getString(28);
					String strActualRate = wsTariffDetails.getString(29);
					String strServiceId  = wsTariffDetails.getString(30);
					String strConsumableCharge  = wsTariffDetails.getString(32);
					String strClNo  = wsTariffDetails.getString(33);
					String strClDate  = wsTariffDetails.getString(34);
					String strPaidByPat  = wsTariffDetails.getString(35);
					String strPaidByClient  = wsTariffDetails.getString(36);
					String strCreditBillFlag  = wsTariffDetails.getString(37);
					String strCreditFilePath  = wsTariffDetails.getString(38);
					String strCreditClientNo  = wsTariffDetails.getString(39);
					String strCreditBillStatus  = wsTariffDetails.getString(40);
					String strCreditClientName  = wsTariffDetails.getString(41);
					String strCatGroup  	= wsTariffDetails.getString(47);//3,4- Credit,0-Paid
					String wchFlag = wsTariffDetails.getString(48);
					String urgentFlag = wsTariffDetails.getString(49);
			
					if (strGroupId == null)
						strGroupId = "";
					if (strTariffId == null)
						strTariffId = "";
					if (strChargeTypeId == null)
						strChargeTypeId = "";
					if (strGblTariffId == null)
						strGblTariffId = "";
					if (strRateUnitId == null)
						strRateUnitId = "";
					if (strApprovalId == null)
						strApprovalId = "";
					if (strTariffName == null)
						strTariffName = "";
					if (strReqQty == null)
						strReqQty = "0";
					if (strBillQty == null)
						strBillQty = "0";
					if (strTariffRate == null)
						strTariffRate = "0";
					if (strDisountUnit == null)
						strDisountUnit = "0";
					if (strRateBaseVal == null)
						strRateBaseVal = "";
					if (strQtyBaseVal == null)
						strQtyBaseVal = "";

					String strHiddenVal = strTariffId + "^" + strReqQty + "*"
							+ strQtyBaseVal + "^" + strQtyUnitId + "^"
							+ strTariffRate + "^" + strRateUnitId + "^"
							+ strGroupId + "^" + strActualRate + "^"
							+ strServiceTax + "^" + strDisountUnit + "^"
							+ strDiscountType + "^" + strGblTariffId + "^"
							+ strApprovalId + "^" + strUnitName + "^"
							+ strRateBaseVal + "^" + strIsPackage + "^"
							+ strNetCost + "^" + strPenelty + "^" + "0^"
							+ strReceiptNo + "^" + strApprovalDtl+"^"+strServiceId+"^"+strConsumableCharge;
					
					sb.append("<tr>");
					sb.append("<td style='width:1%'><div class=\"form-group\"><input type='checkbox' name='strTariffDetailsId' value='"+strHiddenVal+"' id='strTariffDetailsChkId"+trfIndex+"' onclick='setOnlineTariffDetails(this, \""+ trfIndex + "\")'><label for='strTariffDetailsChkId"+trfIndex+"'></label></div></td>");
					sb.append("<td style='width:30%;text-align:left;'><a name='strBillTariffName'  id='strBillTariffName"+ trfIndex+ "' style='cursor:pointer; color:#4285f4' value='"+ strHiddenVal+ "'  onClick='showTariffPopup(this,\""+ strHiddenVal+ "\");'>"+ strTariffName+ "</a><input type='hidden' class='txtFldMin' name='strTariffServiceTaxAmt' id='strTariffServiceTaxAmt"+ trfIndex+ "' value='' disabled='disabled'></td>");
					sb.append("<td style='width:5%'><input type='hidden' class='browser-default custom-select' name='strTariffRate' id='strTariffRate"+ trfIndex+ "' value='"+ strTariffRate+ "' disabled='disabled'>"+ strTariffRate+ "/"+ strUnitName+ "<input type='hidden' class='txtFldMin' name='strTariffActualAmt' id='strTariffActualAmt"+ trfIndex+ "' value='0' disabled='disabled'></td>");
					sb.append("<td style='width:5%'><input type='hidden' class='browser-default custom-select' name='strTariffReqQty' id='strTariffReqQty"+ trfIndex+ "' value='"+ strReqQty+ "' disabled='disabled'>"+ strReqQty+ "/" + strQtyUnitName + "</td>");
					sb.append("<td style='width:8%'><input type='text' class='form-control smalltext' name='strTariffBilledQty' id='strTariffBilledQty"+ trfIndex+ "' onkeyup='setOnlineTariffDltsOnQtyChange(this, \""+ strHiddenVal+ "\", \""+ trfIndex+ "\");' value='0' disabled='disabled'></td>");

					sb.append("<td style='width:8%'>");

					sb.append("<select class='browser-default custom-select smallCombo'  onchange='setOnlineTariffDltsOnQtyUnitChange(this, \""+ strHiddenVal+ "\", \""+ trfIndex+ "\");'  "
									+ "name='strBillTariffUnit' id='strBillTariffUnit"+ trfIndex + "' disabled='disabled' > ");

					voObj.setStrOffLineTariffUnitTempId(strQtyUnitId);
			
					sb.append(BillConfigUtil.getDefaultUnitComboWithBaseValue(strQtyUnitId + "^"+ strQtyBaseVal));

					sb.append("</select>");
					sb.append("</td>");

					sb.append("<td style='width:13%'><input type='hidden' class='txtFldMin' name='strTariffDiscountAmt' id='strTariffDiscountAmt"+ trfIndex+ "' value='0' disabled='disabled'><div id='strTariffDiscountAmtDivId"+ trfIndex + "'>0.00</div></td>");
					
					//adding credit letter details
					
					
					if(bcu.getStrCreditCashlessAppRequired().equals("1"))
					{
						sb.append("<td style='display:none;'>");
						sb.append("<select class='browser-default custom-select' name='strCreditPaymentType' id='strCreditPaymentType"+ trfIndex + "' disabled='disabled' > ");
							if(urgentFlag.equals("2"))
							sb.append("<option value='12'>Paid(Urgent)</option>");
						else
						{
							sb.append("<option value='10'>Paid</option>");
						}
						sb.append("</select>");
						sb.append("</td>");
				
						sb.append("<td style='width:6%'><input type='hidden' class='txtFldMin' name='strCreditLetterNo' id='strCreditLetterNo"+ trfIndex+ "' value='"+ strClNo+ "' >"+ strClNo+ "/"+ strClDate+ "");
						sb.append("<input type='hidden' class='browser-default custom-select' name='strCreditLetterDate' id='strCreditLetterDate"+ trfIndex+ "' value='"+strClDate+"' >");
						sb.append("<input type='hidden' class='browser-default custom-select' name='strPaidByPat' id='strPaidByPat"+ trfIndex+ "' value='"+strPaidByPat+"' disabled='disabled'>");
						sb.append("<input type='hidden' class='browser-default custom-select' name='strPaidByClient' id='strPaidByClient"+ trfIndex+ "' value='"+strPaidByClient+"' disabled='disabled'>");
						sb.append("<input type='hidden' class='browser-default custom-select' name='strCreditBillFlag' id='strCreditBillFlag"+ trfIndex+ "' value='"+strCreditBillFlag+"'>");
						sb.append("<input type='hidden' class='browser-default custom-select' name='strCreditFilePath' id='strCreditFilePath"+ trfIndex+ "' value='"+strCreditFilePath+"'>");
						sb.append("<input type='hidden' class='browser-default custom-select' name='strCreditClientNo' id='strCreditClientNo"+ trfIndex+ "' value='"+strCreditClientNo+"'>");
						sb.append("<input type='hidden' class='browser-default custom-select' name='strCreditBillStatus' id='strCreditBillStatus"+ trfIndex+ "' value='"+strCreditBillStatus+"'>");
						sb.append("<input type='hidden' class='browser-default custom-select' name='strCreditClientName' id='strCreditClientName"+ trfIndex+ "' value='"+strCreditClientName+"' ></td>");
					}
					else if(strCatGroup.equals("3") || strCatGroup.equals("4"))
					{
						
						
						//adding Credit Client Details ....
						
						BillingVO voBilling=new BillingVO();
						voBilling.setStrValue1(voObj.getStrCrNo());
						voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
						voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
						voBilling.setStrServiceType("1");//1-OP CONSULATION ONLY,OP & INV ,2-IP ONLY & IP & INV
						String creditListCombo=HLPbilling.getCreditLetterListComboOnline(voBilling,Integer.toString(trfIndex),true,true); 
						
						
						
						
						
						
						sb.append("<td style='display:none;'>");
						sb.append("<select class='browser-default custom-select' name='strCreditPaymentType' id='strCreditPaymentType"+ trfIndex + "' disabled='disabled' onchange='calcCreditAmount(this,\""+trfIndex+"\");'> ");
						if(wchFlag.equals("1"))
						{
							if(urgentFlag.equals("2"))
								sb.append("<option value='12'>Paid(Urgent)</option>");
							else
							{
								sb.append("<option value='10'>Paid</option>");
							}
						}
						else
						{
							if(urgentFlag.equals("2"))
							{
								sb.append("<option value='13'>Credit(Urgent)</option>");
								sb.append("<option value='12'>Paid(Urgent)</option>");
							}
							else
							{
								sb.append("<option value='11'>Credit</option>");
								sb.append("<option value='10'>Paid</option>");
							}
						}
						sb.append("</select>");
						sb.append("</td>");
						
						sb.append("<td style='width:10%'><div align='center'>");
						sb.append(creditListCombo);
						
									
						
						
						sb.append("<input type='hidden' class='browser-default custom-select' name='strPaidByPat' id='strPaidByPat"	+ trfIndex+ "' value='"	+strPaidByPat+"' disabled='disabled'>");
						sb.append("<input type='hidden' class='browser-default custom-select' name='strPaidByClient' id='strPaidByClient"+ trfIndex+ "' value='"+strPaidByClient+"' disabled='disabled'>");
						sb.append("</div></td>");
					}
					else
					{
					
						sb.append("<td style='display:none;'>");
						sb.append("<select class='browser-default custom-select' name='strCreditPaymentType' id='strCreditPaymentType"+ trfIndex + "' disabled='disabled' > ");
						
						
						if(urgentFlag.equals("2"))
							sb.append("<option value='12'>Paid(Urgent)</option>");
						else
						{
							sb.append("<option value='10'>Paid</option>");
						}
						sb.append("</select>");
						sb.append("</td>");
						
						BillingVO voBilling=new BillingVO();
						voBilling.setStrValue1(voObj.getStrCrNo());
						voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
						voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
						voBilling.setStrServiceType("1");//1-OP CONSULATION ONLY,OP & INV ,2-IP ONLY & IP & INV
						String creditListCombo=HLPbilling.getCreditLetterListComboEmpty(voBilling,Integer.toString(trfIndex),true,true); 
						
						sb.append("<td style='width:10%'><div align='center'>");
						sb.append(creditListCombo);
				
						sb.append("<input type='hidden'  name='strPaidByPat' id='strPaidByPat"+ trfIndex+ "' value='"+strPaidByPat+"' disabled='disabled'>");
						sb.append("<input type='hidden'  name='strPaidByClient' id='strPaidByClient"+ trfIndex+ "' value='"+strPaidByClient+"' disabled='disabled'>");
						sb.append("</td>");
					}
					
					
					sb.append("<td style='width:10%;text-align:right'>");
					sb.append("<input type='hidden' class='browser-default custom-select' name='strTariffNetAmt' id='strTariffNetAmt"+ trfIndex+ "' value='0' disabled='disabled'>");
					sb.append("<div id='strTariffNetAmtDivId"+ trfIndex + "'>0.00</div></td>");
					if(i==wsTariffDetails.size())
					{
						i++;
						System.out.println("i"+i);
						sb.append("<input type='hidden' name='strCreditPaymentType'  id='strCreditPaymentType"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strCreditLetterNo'  id='strCreditLetterNo"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strTariffBilledQty'  id='strTariffBilledQty"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strBillTariffUnit'  id='strBillTariffUnit"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strTariffDiscountAmt'  id='strTariffDiscountAmt"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strTariffServiceTaxAmt'  id='strTariffServiceTaxAmt"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strTariffNetAmt'  id='strTariffNetAmt"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strPaidByPat'  id='strPaidByPat"+i+"' value='0'>");
						sb.append("<input type='hidden' name='strPaidByClient'  id='strPaidByClient"+i+"' value='0'>");
					}
					sb.append("</tr>");

				}
				sb.append("</tbody>");
				sb.append("</table>");
                
			}
		} 
		catch (Exception e) 
		{
			new HisException("Billing","CashCollectionTransHLP.getOnLineTariffDetailsView()-->", e.getMessage());
		}

		return sb.toString();
	}


	
	
	/**
	 * returns the required Online Tariff Details View (HTML) in String format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Tariff Details View
	 */
	
	public static String getOnLineRefundTariffDetailsView_BS(CashCollectionOnlineTransVO voObj) 
	{
		StringBuffer sb = new StringBuffer("");
		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		int count = 0;
		try 
		{
			if (wsTariffDetails != null) 
			{
				sb.append("<div class='subHeaders'><i class=\"fas fa-clipboard-list\" style=\"font-size: 26px;\">&nbsp;</i>Tariff Detail</div>");
				sb.append("<table class='table'>");	
				sb.append("<thead>");
				sb.append("<tr>");
				sb.append("<th>#</th>");
				sb.append("<th><font style='font-size: 14px;' size='2' face='Helvetica Neue, Helvetica, Arial, sans-serif' >Tariff Name<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' > <input type='hidden' class='txtFldMin' name='strTotalTariffActualAmount' value='0' > </th>");
				sb.append("<th><font style='font-size: 14px;' size='2' face='Helvetica Neue, Helvetica, Arial, sans-serif' >Refund Qty<input type='hidden' class='txtFldMin' name='strTotalTariffDiscountAmount' value='0' >  <input type='hidden' class='txtFldMin' name='strTotalTariffPenaltyAmount' value='0' ></th>");
				//sb.append("<th class='multiLabel'>Refund Qty </th>");
				//sb.append("<th class='multiLabel'>Unit </th>");
				sb.append("<th><font style='font-size: 14px;' size='2' face='Helvetica Neue, Helvetica, Arial, sans-serif' >Refund Cost (<i class='fas fa-rupee-sign'><//i>)</th>");
				sb.append("<th><font style='font-size: 14px;' size='2' face='Helvetica Neue, Helvetica, Arial, sans-serif' >Credit Letter No/Date/Amount</th>");
				sb.append("</tr>");
				sb.append("</thead>");
				sb.append("<tbody>");



				while (wsTariffDetails.next()) 
				{
					count = count + 1;
					String strGroupId = wsTariffDetails.getString(1);
					String strTariffId = wsTariffDetails.getString(2);
					String strChargeTypeId = wsTariffDetails.getString(3);
					String strGblTariffId = wsTariffDetails.getString(4);
					String strRateUnitId = wsTariffDetails.getString(5);
					String strApprovalId = wsTariffDetails.getString(6);
					// String strBserviceType = wsTariffDetails.getString(7);
					String strTariffName = wsTariffDetails.getString(7);

					// String strGroupName = wsTariffDetails.getString(9);
					String strUnitName = wsTariffDetails.getString(10);
					String strReqQty = wsTariffDetails.getString(11);
					String strBillQty = wsTariffDetails.getString(12);
					String strTariffRate = wsTariffDetails.getString(13);
					String strDisountUnit = wsTariffDetails.getString(14);
					String strDiscountType = wsTariffDetails.getString(15);
				//	String strQtyUnitName = wsTariffDetails.getString(18);
					String strQtyUnitId = wsTariffDetails.getString(19);
					String strIsPackage = wsTariffDetails.getString(20);
					String strServiceTax = wsTariffDetails.getString(21);
					String strPenelty = wsTariffDetails.getString(22);
					String strApprovalDtl = wsTariffDetails.getString(23);
					// String strQtyType = wsTariffDetails.getString(24);
					String strRateBaseVal = wsTariffDetails.getString(25);
					String strQtyBaseVal = wsTariffDetails.getString(26);
					String strNetCost = wsTariffDetails.getString(27);
					String strReceiptNo = wsTariffDetails.getString(28);
					String strActualRate = wsTariffDetails.getString(29);
					String strClDetails= wsTariffDetails.getString(33)+"/"+wsTariffDetails.getString(34)+"/"+wsTariffDetails.getString(36);
					// String strDisountType =
					// wsTariffDetails.getString(15);

					if (strGroupId == null)
						strGroupId = "";
					if (strTariffId == null)
						strTariffId = "";
					if (strChargeTypeId == null)
						strChargeTypeId = "";
					if (strGblTariffId == null)
						strGblTariffId = "";
					if (strRateUnitId == null)
						strRateUnitId = "";
					if (strApprovalId == null)
						strApprovalId = "";
					if (strTariffName == null)
						strTariffName = "";
					if (strReqQty == null)
						strReqQty = "0";
					if (strBillQty == null)
						strBillQty = "0";
					if (strTariffRate == null)
						strTariffRate = "0";
					if (strDisountUnit == null)
						strDisountUnit = "0";
					if (strRateBaseVal == null)
						strRateBaseVal = "";
					if (strQtyBaseVal == null)
						strQtyBaseVal = "";

					String strHiddenVal = strTariffId + "^" + strReqQty + "*"
							+ strQtyBaseVal + "^" + strQtyUnitId + "^"
							+ strTariffRate + "^" + strRateUnitId + "^"
							+ strGroupId + "^" + strActualRate + "^"
							+ strServiceTax + "^" + strDisountUnit + "^"
							+ strDiscountType + "^" + strGblTariffId + "^"
							+ strApprovalId + "^" + strUnitName + "^"
							+ strRateBaseVal + "^" + strIsPackage + "^"
							+ strNetCost + "^" + strPenelty + "^" + "0^"
							+ strReceiptNo + "^" + strApprovalDtl;

					sb.append("<tr>");
					sb.append("<td><input type='hidden' class='txtFldMin' name='strTariffPenaltyAmt' id='strTariffPenaltyAmt"
									+ count
									+ "' value='0' disabled='disabled'><div class='form-group'><input type='checkbox' name='strTariffRefundDetailsId' id='strTariffRefundDetailsId"
									+ count
									+ "' onclick='activateTariffRefundDtls(this,\""
									+ count + "\");'  value='");
					sb.append(strHiddenVal).append("^");

					sb.append("' onclick='setOnlineTariffDetails(this, \""
							+ count + "\")'><label for='strTariffRefundDetailsId"+ count+"'></label></div></td>");
					sb.append("<td><font style='font-size: 14px;' size='2' face='Helvetica Neue, Helvetica, Arial, sans-serif' ><input type='hidden' class='txtFldMin' name='strTariffServiceTaxAmt' id='strTariffServiceTaxAmt"
									+ count
									+ "'  value='0' disabled='disabled' > <a  data-toggle='modal' data-target='#refundModel' onclick='showRefundTariffPopup(this,\""
									+ strHiddenVal
									+ "\");'>"
									+ strTariffName
									+ "</a>  <input disabled='disabled'  type='hidden' name='strRefundTariffDetails' id='strRefundTariffDetails"
									+ count
									+ "' value='"
									+ strHiddenVal
									+ "'/></td>");
					sb.append("<td><font style='font-size: 14px;' size='2' face='Helvetica Neue, Helvetica, Arial, sans-serif' ><input type='hidden' name='strTariffToBeRefundQty' id='strTariffToBeRefundQty"
									+ count
									+ "' disabled='disabled' class='txtFldNormal' value='"
									+ strReqQty
									+ "'>"
									+ strReqQty
									+ " "
									+ strUnitName
									+ "<input type='hidden' class='txtFldMin' name='strTariffActualAmt' id='strTariffActualAmt"
									+ count
									+ "' value='0' disabled='disabled'>  <input style='display:none' type='text' name='strTariffRefundQty' id='strTariffRefundQty"
									+ count
									+ "' disabled='disabled' class='txtFldNormal' value='0' onkeyup='calcRefundTariffAmount(\""
									+ count + "\")'>  <input type='hidden' class='txtFldMin' name='strTariffDiscountAmt' id='strTariffDiscountAmt"
									+ count
									+ "' value='0' disabled='disabled'>  <select style='display:none' name='strTariffRefundUnit' id='strTariffRefundUnit"
									+ count
									+ "' disabled='disabled' class='comboMin'>");
					voObj.setStrOffLineTariffUnitTempId(strQtyUnitId);

					if (strQtyUnitId.equals("0")) 
					{
						sb.append("<option value='0'>Select Value</option>");
					}
					else 
					{
						sb.append(BillConfigUtil.getDefaultUnitComboWithBaseValue(strQtyUnitId + "^"+ strQtyBaseVal));
					}

					/*if (voObj.getOfflineTariffUnit() != null && voObj.getOfflineTariffUnit().size() > 0) 
					{
						sb.append(new HisUtil("", "").getOptionValue(voObj.getOfflineTariffUnit(), strQtyUnitId + "^"+ strQtyBaseVal, "0^Select Value", false));
					} 
					else 
					{
						sb.append("<option value='0'>Select Value</option>");
					}*/
					sb.append("</select></td>");
					//sb.append("<td class='multiControl'></td>");
					//sb.append("<td class='multiControl'></td>");
					sb.append("<td><font style='font-size: 14px;' size='2' face='Helvetica Neue, Helvetica, Arial, sans-serif' ><div id='strTariffRefundCostDivId"+ count+ "'>0.00</div><input type='hidden' name='strTariffRefundCost' id='strTariffRefundCost"+ count	+ "' disabled='disabled' class='txtFldNormal' value='0.00' ></font</td>");
					
					//new credit field
					sb.append("<td><div id='strCreditDetails"
							+ count
							+ "'>"
							+ strClDetails
							+ "</div><input type='hidden' name='strCreditLetterNo' id='strCreditLetterNo"
							+ count
							+ "'  class='txtFldNormal' value='"
							+ wsTariffDetails.getString(33)
							+ "' ></font</td>");
					sb.append("</tr>");
				}
				sb.append("</tbody>");
				sb.append("</table>");
			}
		} 
		catch (Exception e) 
		{
			new HisException("Billing","CashCollectionTransHLP.getOnLineRefundTariffDetailsView()-->",e.getMessage());
		}

		return sb.toString();
	}

	
	
	public static String getOnLineRefundTariffDetailsView(CashCollectionOnlineTransVO voObj) 
	{
		StringBuffer sb = new StringBuffer("");
		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		int count = 0;
		try 
		{
			if (wsTariffDetails != null) 
			{
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr>");
				sb.append("<td class='TITLE' colspan='7'>Tariff Detail</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td class='multiLabel'></td>");
				sb.append("<td class='multiLabel'>Tariff Name<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' > <input type='hidden' class='txtFldMin' name='strTotalTariffActualAmount' value='0' > </td>");
				sb.append("<td class='multiLabel'>Refund Qty<input type='hidden' class='txtFldMin' name='strTotalTariffDiscountAmount' value='0' >  <input type='hidden' class='txtFldMin' name='strTotalTariffPenaltyAmount' value='0' ></td>");
				//sb.append("<td class='multiLabel'>Refund Qty </td>");
				//sb.append("<td class='multiLabel'>Unit </td>");
				sb.append("<td class='multiLabel'>Refund Cost (<img src='/HBIMS/hisglobal/images/INR.png'>)</td>");
				
				sb.append("<td class='multiLabel'>Credit Letter No/Date/Amount</td>");
				
				sb.append("</tr>");

				while (wsTariffDetails.next()) 
				{
					count = count + 1;
					String strGroupId = wsTariffDetails.getString(1);
					String strTariffId = wsTariffDetails.getString(2);
					String strChargeTypeId = wsTariffDetails.getString(3);
					String strGblTariffId = wsTariffDetails.getString(4);
					String strRateUnitId = wsTariffDetails.getString(5);
					String strApprovalId = wsTariffDetails.getString(6);
					// String strBserviceType = wsTariffDetails.getString(7);
					String strTariffName = wsTariffDetails.getString(7);

					// String strGroupName = wsTariffDetails.getString(9);
					String strUnitName = wsTariffDetails.getString(10);
					String strReqQty = wsTariffDetails.getString(11);
					String strBillQty = wsTariffDetails.getString(12);
					String strTariffRate = wsTariffDetails.getString(13);
					String strDisountUnit = wsTariffDetails.getString(14);
					String strDiscountType = wsTariffDetails.getString(15);
				//	String strQtyUnitName = wsTariffDetails.getString(18);
					String strQtyUnitId = wsTariffDetails.getString(19);
					String strIsPackage = wsTariffDetails.getString(20);
					String strServiceTax = wsTariffDetails.getString(21);
					String strPenelty = wsTariffDetails.getString(22);
					String strApprovalDtl = wsTariffDetails.getString(23);
					// String strQtyType = wsTariffDetails.getString(24);
					String strRateBaseVal = wsTariffDetails.getString(25);
					String strQtyBaseVal = wsTariffDetails.getString(26);
					String strNetCost = wsTariffDetails.getString(27);
					String strReceiptNo = wsTariffDetails.getString(28);
					String strActualRate = wsTariffDetails.getString(29);
					String strClDetails= wsTariffDetails.getString(33)+"/"+wsTariffDetails.getString(34)+"/"+wsTariffDetails.getString(36);
					// String strDisountType =
					// wsTariffDetails.getString(15);

					if (strGroupId == null)
						strGroupId = "";
					if (strTariffId == null)
						strTariffId = "";
					if (strChargeTypeId == null)
						strChargeTypeId = "";
					if (strGblTariffId == null)
						strGblTariffId = "";
					if (strRateUnitId == null)
						strRateUnitId = "";
					if (strApprovalId == null)
						strApprovalId = "";
					if (strTariffName == null)
						strTariffName = "";
					if (strReqQty == null)
						strReqQty = "0";
					if (strBillQty == null)
						strBillQty = "0";
					if (strTariffRate == null)
						strTariffRate = "0";
					if (strDisountUnit == null)
						strDisountUnit = "0";
					if (strRateBaseVal == null)
						strRateBaseVal = "";
					if (strQtyBaseVal == null)
						strQtyBaseVal = "";

					String strHiddenVal = strTariffId + "^" + strReqQty + "*"
							+ strQtyBaseVal + "^" + strQtyUnitId + "^"
							+ strTariffRate + "^" + strRateUnitId + "^"
							+ strGroupId + "^" + strActualRate + "^"
							+ strServiceTax + "^" + strDisountUnit + "^"
							+ strDiscountType + "^" + strGblTariffId + "^"
							+ strApprovalId + "^" + strUnitName + "^"
							+ strRateBaseVal + "^" + strIsPackage + "^"
							+ strNetCost + "^" + strPenelty + "^" + "0^"
							+ strReceiptNo + "^" + strApprovalDtl;

					sb.append("<tr>");
					sb.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffPenaltyAmt' id='strTariffPenaltyAmt"
									+ count
									+ "' value='0' disabled='disabled'><input type='checkbox' name='strTariffRefundDetailsId' id='strTariffRefundDetailsId"
									+ count
									+ "' onclick='activateTariffRefundDtls(this,\""
									+ count + "\");'  value='");
					sb.append(strHiddenVal).append("^");

					sb.append("' onclick='setOnlineTariffDetails(this, \""
							+ count + "\")'></td>");
					sb.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffServiceTaxAmt' id='strTariffServiceTaxAmt"
									+ count
									+ "'  value='0' disabled='disabled' > <a STYLE='CURSOR:POINTER; color:blue' data-toggle='modal' data-target='#refundModel' onclick='showRefundTariffPopup(this,\""
									+ strHiddenVal
									+ "\");'>"
									+ strTariffName
									+ "</a>  <input disabled='disabled'  type='hidden' name='strRefundTariffDetails' id='strRefundTariffDetails"
									+ count
									+ "' value='"
									+ strHiddenVal
									+ "'/></td>");
					sb.append("<td class='multiControl'><input type='hidden' name='strTariffToBeRefundQty' id='strTariffToBeRefundQty"
									+ count
									+ "' disabled='disabled' class='txtFldNormal' value='"
									+ strReqQty
									+ "'>"
									+ strReqQty
									+ " "
									+ strUnitName
									+ "<input type='hidden' class='txtFldMin' name='strTariffActualAmt' id='strTariffActualAmt"
									+ count
									+ "' value='0' disabled='disabled'>  <input style='display:none' type='text' name='strTariffRefundQty' id='strTariffRefundQty"
									+ count
									+ "' disabled='disabled' class='txtFldNormal' value='0' onkeyup='calcRefundTariffAmount(\""
									+ count + "\")'>  <input type='hidden' class='txtFldMin' name='strTariffDiscountAmt' id='strTariffDiscountAmt"
									+ count
									+ "' value='0' disabled='disabled'>  <select style='display:none' name='strTariffRefundUnit' id='strTariffRefundUnit"
									+ count
									+ "' disabled='disabled' class='comboMin'>");
					voObj.setStrOffLineTariffUnitTempId(strQtyUnitId);

					if (strQtyUnitId.equals("0")) 
					{
						sb.append("<option value='0'>Select Value</option>");
					}
					else 
					{
						sb.append(BillConfigUtil.getDefaultUnitComboWithBaseValue(strQtyUnitId + "^"+ strQtyBaseVal));
					}

					/*if (voObj.getOfflineTariffUnit() != null && voObj.getOfflineTariffUnit().size() > 0) 
					{
						sb.append(new HisUtil("", "").getOptionValue(voObj.getOfflineTariffUnit(), strQtyUnitId + "^"+ strQtyBaseVal, "0^Select Value", false));
					} 
					else 
					{
						sb.append("<option value='0'>Select Value</option>");
					}*/
					sb.append("</select>  </td>");
					//sb.append("<td class='multiControl'></td>");
					//sb.append("<td class='multiControl'></td>");
					sb.append("<td class='multiControl' style='font-weight: bold'><div id='strTariffRefundCostDivId"+ count+ "'>0.00</div><input type='hidden' name='strTariffRefundCost' id='strTariffRefundCost"+ count	+ "' disabled='disabled' class='txtFldNormal' value='0.00' ></td>");
					
					//new credit field
					sb.append("<td class='multiControl' style='font-weight: bold'><div id='strCreditDetails"
							+ count
							+ "'>"
							+ strClDetails
							+ "</div><input type='hidden' name='strCreditLetterNo' id='strCreditLetterNo"
							+ count
							+ "'  class='txtFldNormal' value='"
							+ wsTariffDetails.getString(33)
							+ "' ></td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
			}
		} 
		catch (Exception e) 
		{
			new HisException("Billing","CashCollectionTransHLP.getOnLineRefundTariffDetailsView()-->",e.getMessage());
		}

		return sb.toString();
	}

	public static String getOnLineRefundAdvanceView(CashCollectionOnlineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		try {

			if (wsTariffDetails != null) {

				sb
						.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr>");
				sb
						.append("<td class='TITLE' colspan='2'>Refund Advance Detail</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb
						.append("<td class='multiLabel' width='75%'>Tariff Name<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' ></td>");

				sb
						.append("<td class='multiLabel'  width='25%'>Refund Cost (<img src='/HBIMS/hisglobal/images/INR.png'>)</td>");
				sb.append("</tr>");

				if (wsTariffDetails != null && wsTariffDetails.size() > 0) {
					while (wsTariffDetails.next()) {

						/*
						 * String strGroupId = wsTariffDetails.getString(1);
						 * String strTariffId = wsTariffDetails.getString(2);
						 * String strChargeTypeId =
						 * wsTariffDetails.getString(3); String strGblTariffId =
						 * wsTariffDetails.getString(4); String strRateUnitId =
						 * wsTariffDetails.getString(5); String strApprovalId =
						 * wsTariffDetails.getString(6); String strBserviceType =
						 * wsTariffDetails.getString(7);
						 */
						String strTariffName = wsTariffDetails.getString(7);
						String strPenelty = wsTariffDetails.getString(22);
						String strTariffRate = wsTariffDetails.getString(13);
						/*
						 * // String strGroupName =
						 * wsTariffDetails.getString(9); String strUnitName =
						 * wsTariffDetails.getString(10); String strReqQty =
						 * wsTariffDetails.getString(11); String strBillQty =
						 * wsTariffDetails.getString(12); String strTariffRate =
						 * wsTariffDetails.getString(13); String strDisountUnit =
						 * wsTariffDetails.getString(14); String strDiscountType =
						 * wsTariffDetails.getString(15); //String
						 * strQtyUnitName = wsTariffDetails.getString(18);
						 * String strQtyUnitId = wsTariffDetails.getString(19);
						 * String strIsPackage = wsTariffDetails.getString(20);
						 * String strServiceTax = wsTariffDetails.getString(21);
						 * 
						 * String strApprovalDtl =
						 * wsTariffDetails.getString(23); // String strQtyType =
						 * wsTariffDetails.getString(24); String strRateBaseVal =
						 * wsTariffDetails.getString(25); String strQtyBaseVal =
						 * wsTariffDetails.getString(26);
						 * 
						 * String strReceiptNo = wsTariffDetails.getString(28);
						 * String strActualRate = wsTariffDetails.getString(29); //
						 * String strDisountType = //
						 * wsTariffDetails.getString(15);
						 */
						if (strTariffName == null)
							strTariffName = "";
						if (strTariffRate == null)
							strTariffRate = "0.00";
						if (strPenelty == null)
							strPenelty = "0";

						float netAmt = Float.parseFloat(strTariffRate);
						float penelty = Float.parseFloat(strPenelty);
						float peneltyAmt = (netAmt * penelty) / (100 - penelty);

						strTariffRate = HisUtil.getAmountWithDecimal(strTariffRate, 2);
						
						sb.append("<tr>");
						sb
								.append("<td class='multiControl'><input type='hidden' name='strRefundAdvancePenelty' value='"
										+ strPenelty
										+ "'><input type='hidden' name='strTotalTariffPenaltyAmount' value='"
										+ peneltyAmt
										+ "'><a style='color:blue; cursor:pointer' onclick='showRefundAdvanceDtls(this , \""
										+ penelty
										+ "^"
										+ peneltyAmt
										+ "\");'>"
										+ strTariffName + "</a></td>");

						sb
								.append("<td class='multiControl' style='font-weight: bold'><div id='strTariffRefundCostDivId'>"
										+ strTariffRate
										+ "</div><input type='hidden' name='strTariffRefundCost' disabled='disabled' class='txtFldNormal' value='"
										+ strTariffRate + "' ></td>");
						sb.append("</tr>");

					}
					sb.append("</table>");

				} else {

					sb.append("<tr>");
					sb
							.append("<td class='CONTROL' colspan='2'>No Refund Advance Detail Available</td>");
					sb.append("</tr>");
					sb.append("</table>");
				}
			}
		} catch (Exception e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOnLineRefundTariffDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the required Online Part Payment Details View (HTML) in String
	 * format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Part Payment Details View
	 */
	public static String getOnLinePartPaymentDetailsView(
			CashCollectionOnlineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		try {

			if (wsTariffDetails != null) {

				sb
						.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
				sb.append("<tr>");
				sb
						.append("<td class='TITLE' colspan='2'>Part Payment Details</td>");
				sb.append("</tr>");

				if (wsTariffDetails.next()) {

					String strTariffRate = wsTariffDetails.getString(13);

					if (strTariffRate == null)
						strTariffRate = "0";

					sb.append("<tr>");
					sb
							.append("<td  class='LABELHIGHLITER' align='left'>Part Payment Amount</td>");
					sb.append("<td  class='CONTROL'>");
					sb
							.append("<input type='text' name='strPartPaymentAmount' maxlength='7' class='form-control' onchange='calcNetAmountPp();' value='");
					sb.append(strTariffRate);
					sb.append("'>");
					sb.append("</td>");
					sb.append("</tr>");
				}
				sb.append("</table>");
			}
		} catch (SQLException e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOnLinePartPaymentClientDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	/**
	 * returns the required Online Advance Details View (HTML) in String format.
	 * 
	 * @param voObj -
	 *            Value Object
	 * @return - required Online Advance Details View
	 */
	public static String getOnLineAdvanceDetailsView(CashCollectionOnlineTransVO voObj) 
	{
		StringBuffer sb = new StringBuffer("");
		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();
		String strClientPatientNo=voObj.getStrClientPatientNo();
		BillConfigUtil bcu=null;

		try 
		{
			sb.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			sb.append("<tr>");
			sb.append("<td colspan='8'><div class='line'><label class='DIVLABEL'>Advance Details</label></div></td>");
			sb.append("</tr>");

			if (wsTariffDetails.next()) 
			{
				String strTariffRate = wsTariffDetails.getString(13);
				String strClPath=wsTariffDetails.getString(38);
				String strClientNo=wsTariffDetails.getString(39);
				String strClCardNoId=wsTariffDetails.getString(43);
				String strClCardHolderName=wsTariffDetails.getString(44);
				String strCreditRelationWithStaff=wsTariffDetails.getString(45);
				String strClValidity=wsTariffDetails.getString(46);
				String strCatGroup  	= wsTariffDetails.getString(47);//3,4- Credit,0-Paid

				if (strTariffRate == null) strTariffRate = "0";

				
				
				bcu=new BillConfigUtil(voObj.getStrHospitalCode());
				
				if(bcu.getStrCreditCashlessAppRequired().equals("1"))
				{
					sb.append("<tr>");
					sb.append("<td width='12%' class='LABEL'>Advance Amount</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strAdvanceAmount' maxlength='7'  class='txtFldNormal' onkeypress='return validateData(event,7);' onkeyup='calcNetAmount();' value='"+strTariffRate+"'>");
					sb.append("</td>");
					sb.append("<td width='12%' class='LABEL'>Payment Type</td>");
					sb.append("<td width='10%' class='CONTROL'>");
					sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' disabled='disabled' > ");
					sb.append("<option value='11'>Credit</option>");
					//sb.append("<option value='13'>Credit(Urgent)</option>");
					sb.append("</select>");
					sb.append("</td>");
					
					//adding Credit Client Details ....
					sb.append("<td width='12%' class='LABEL'>Credit Letter No.</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strCreditLetterNo' readonly='readonly' class='txtFldNormal' value='"+wsTariffDetails.getString(33)+"' >");
					sb.append("</td>");
					
					sb.append("<td width='12%' class='LABEL'>Credit Letter Date</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strCreditLetterDate' readonly='readonly' class='txtFldNormal' value='"+wsTariffDetails.getString(34)+"'>");
					sb.append("<input type='hidden' name='strClientPatientNo' value='"+strClientPatientNo+"'>");
					sb.append("<input type='hidden' name='strCreditFilePath'  value='"+strClPath+"'>");
					sb.append("<input type='hidden' name='strCreditClientNo'  value='"+strClientNo+"'>");
				//	sb.append("<input type='hidden' name='strEmployeeId'  value='"+strClCardNoId+"'>");
				//	sb.append("<input type='hidden' name='strEmployeeName' value='"+strClCardHolderName+"'>");
				//	sb.append("<input type='hidden' name='strRalationId' value='"+strCreditRelationWithStaff+"'>");
				//	sb.append("<input type='hidden' name='strCardValidity' value='"+strClValidity+"'>");
					sb.append("<input type='hidden' name='strCreditBillApprovalDone' value='1'>");//Approval Done
					sb.append("</td>");
					
					sb.append("</tr>");
				}
				else if(strCatGroup.equals("3") || strCatGroup.equals("4"))//Credit
				{
					sb.append("<tr>");
					sb.append("<td width='12%' class='LABEL'>Advance Amount</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strAdvanceAmount' maxlength='7' class='txtFldNormal' onkeypress='return validateData(event,7);' onkeyup='calcNetAmount();' value='"+strTariffRate+"'>");
					sb.append("</td>");
					sb.append("<td width='12%' class='LABEL'>Payment Type</td>");
					sb.append("<td width='10%' class='CONTROL'>");
					sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this)'> ");
					sb.append("<option value='11'>Credit</option>");
					sb.append("<option value='10'>Paid</option>");
					/*sb.append("<option value='12'>Paid(Urgent)</option>");
					sb.append("<option value='13'>Credit(Urgent)</option>");*/
					sb.append("</select>");
					sb.append("</td>");
					//adding Credit Client Details ....
					
					BillingVO voBilling=new BillingVO();
					voBilling.setStrValue1(voObj.getStrCrNo());
					voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
					voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
					voBilling.setStrServiceType("2");//1-OP CONSULATION ONLY,OP & INV ,2-IP ONLY & IP & INV
					String creditListCombo=HLPbilling.getCreditLetterListComboOnline(voBilling,"1",false,true); 
					
					
					sb.append("<td width='35%' class='LABEL'><label title='Format:Letter Or Counter Or TG No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details<font color='red' size='1px'>(Letter No/Date/Client/Limit/Card-Emp No./Emp Name)</font></label></td>");
					sb.append("<td class='CONTROL'>");
					sb.append(creditListCombo);
					sb.append("</td>");					
					sb.append("</tr>");
				}
				else//NOn Credit
				{
					sb.append("<tr>");
					sb.append("<td width='12%' class='LABEL'>Advance Amount</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strAdvanceAmount' maxlength='7' class='txtFldNormal' onkeypress='return validateData(event,7);' onkeyup='calcNetAmount();' value='"+strTariffRate+"'>");
					sb.append("</td>");
					sb.append("<td width='12%' class='LABEL'>Payment Type</td>");
					sb.append("<td width='10%' class='CONTROL'>");
					sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' disabled='disabled' > ");
					sb.append("<option value='10'>Paid</option>");
					//sb.append("<option value='12'>Paid(Urgent)</option>");
					sb.append("</select>");
					sb.append("</td>");
					sb.append("<td width='35%' class='LABEL'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details<font color='red' size='1px'>(Letter No/Date/Client/Limit/Card-Emp No./Emp Name)</font></label></td>");
					sb.append("<td class='CONTROL'>");
					BillingVO voBilling=new BillingVO();
					voBilling.setStrValue1(voObj.getStrCrNo());
					voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
					voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
					String creditListCombo=HLPbilling.getCreditLetterListComboEmpty(voBilling,"1",true,true);										
					sb.append(creditListCombo);
					sb.append("</td>");					
					sb.append("</tr>");
				}
			}
			else
				sb.append("<tr><td width='100%' class='CONTROL'><div align='center'><font color='red'><b>No Advance Details Found/Credit Bill Not Approved</b></font></div></td></tr>");
			
			sb.append("</table>");

		} 
		catch (SQLException e) 
		{
			new HisException("Billing","CashCollectionTransHLP.getOnLinePartPaymentClientDetailsView()-->",e.getMessage());
		}

		return sb.toString();
	}

	/*public static String getOnLineThirdPartyAmountDtlView(String strBServiceId,
			String strMode) {

		StringBuffer sb = new StringBuffer("");

		if (strMode.equals("1")) {

			sb
					.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb
					.append("<td width='60%' class='LABEL'>Max Benefit From Client (<img src='/HBIMS/hisglobal/images/INR.png'>)</td> ");
			sb.append("<td width='15%' class='CONTROL' > ");
			sb
					.append("<table><tr><td><input type='hidden' name='strOnlineMaxClientBenefitAmount' id='strOnlineMaxClientBenefitAmount' value='0.00'></td> ");
			sb
					.append("<td  class='CONTROL' style='font-weight: bold'><div id='onlineMaxClientBenefitDivId'>0.00</div> </td></tr></table>");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			if (strBServiceId.equals("21")) {

				sb
						.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb
						.append("<td width='60%' class='LABEL'>Discount Amount </td> ");
				sb
						.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
				sb
						.append("<table><tr><td><input type='hidden' name='strOnlineDiscountAmount' id='strOnlineDiscountAmount' value='0.00'></td> ");
				sb
						.append("<td  class='CONTROL' style='font-weight: bold'><div id='onlineDiscountAmountDivId'>0.00</div> </td></tr></table>");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				sb
						.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb
						.append("<td width='60%' class='LABEL'>Service Tax Amount</td> ");
				sb
						.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
				sb
						.append("<table><tr><td><input type='hidden' name='strOnlineServiceTaxAmount' id='strOnlineServiceTaxAmount' value='0.00'></td> ");
				sb
						.append("<td  class='CONTROL' style='font-weight: bold'><div id='onlineServiceTaxAmountDivId'>0.00</div> </td></tr></table>");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

			}
			sb
					.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb
					.append("<td width='60%' class='LABEL'>Net Payable Amount By Patient (<img src='/HBIMS/hisglobal/images/INR.png'>)</td> ");
			sb
					.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
			sb
					.append("<table><tr><td><input type='hidden' name='strOnlinePatNetPayAmount' id='strOnlinePatNetPayAmount' value='0.00'></td> ");
			sb
					.append("<td  class='CONTROL' style='font-weight: bold'><div id='onlinePatNetPayDivId'>0.00</div> </td></tr></table>");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

		} else {

			sb
					.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td width='60%' class='LABEL'>Discount Amount </td> ");
			sb
					.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
			sb
					.append("<table><tr><td><input type='hidden' name='strOnlineDiscountAmount' id='strOnlineDiscountAmount' value='0.00'></td> ");
			sb
					.append("<td  class='CONTROL' style='font-weight: bold'><div id='onlineDiscountAmountDivId'>0.00</div> </td></tr></table>");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb
					.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td width='60%' class='LABEL'>Service Tax Amount</td> ");
			sb
					.append("<td width='15%' class='CONTROL' style='font-weight: bold'> ");
			sb
					.append("<table><tr><td><input type='hidden' name='strOnlineServiceTaxAmount' id='strOnlineServiceTaxAmount' value='0.00'></td> ");
			sb
					.append("<td  class='CONTROL' style='font-weight: bold'><div id='onlineServiceTaxAmountDivId'>0.00</div> </td></tr></table>");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

		}

		return sb.toString();
	}
*/
	/*
	 * public static String getAccountHeader() {
	 * 
	 * StringBuffer sb = new StringBuffer("");
	 * 
	 * sb.append("<table class='TABLEWIDTH' align='center'> "); sb.append("<tr>
	 * "); sb.append("<td class='multiLabel' width='20'> "); sb.append("<div
	 * id='plusonLineAccId' ><img ");
	 * sb.append("src='../../hisglobal/images/plus.gif' name='plusonLine' ");
	 * sb.append("align='middle' width='10' height='10' ");
	 * sb.append("onclick='showCltDetails(\"onLineAccId\");' /></div> ");
	 * sb.append("<div id='minusonLineAccId' style='display: none'><img ");
	 * sb.append("src='../../hisglobal/images/minus.gif' name='minusonLine' ");
	 * sb.append("width='10' height='10' ");
	 * sb.append("onclick='hideCltDetails(\"onLineAccId\");'></div> ");
	 * sb.append("</td> "); sb.append("<td class='TITLE' colspan='3'>Account
	 * Detail</td> "); sb.append("</tr> "); sb.append("</table> ");
	 * 
	 * return sb.toString(); }
	 */

	public static String getRefundTariffPopUp(CashCollectionOnlineTransVO voObj) {
		StringBuffer sb = new StringBuffer("");

		String strValmode = voObj.getStrRefundTariffHiddenValue();

		String val[] = strValmode.replace('^', '#').split("#");

		String strRateUnit = val[3] + "/" + val[12];
		String strDiscountUnit = val[8];
		String strDiscountType = val[9];
		String strServiceTax = val[7];
		String strPenalty = val[16];

		if (strDiscountType.equals("2")) {
			strDiscountUnit = strDiscountUnit + " %";
		} else {
			strDiscountUnit = strDiscountUnit + " Fixed";
		}

		try {

			sb
					.append("<table width='400' align='center' cellpadding='0' cellspacing='0'>");
			sb
					.append("<tr class='HEADER' align='left'><td>&nbsp;Refund Cost Calculation Details</td>");
			sb
					.append("<td align='right'><img  style='cursor: hand; cursor: pointer'    src='../../hisglobal/images/stop.png' align='middle' onclick='hide_popup_menu(\"refundTariffPopupDetailsDivId\");'> </td></tr>");
			sb.append("</table> ");
			sb.append("<table width='400' align='center' cellspacing='1px'>");
			sb.append("<tr>");
			sb
					.append("<td class='multiLabel' width='25%'>Rate(Rs)/Unit</td><td class='multiControl'  width='25%'>"
							+ strRateUnit + "</td>");
			sb
					.append("<td class='multiLabel'  width='25%'>Discount/ Unit</td> <td class='multiControl'  width='25%'>"
							+ strDiscountUnit + "</td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb
					.append("<td class='multiLabel'  width='25%'>Service Tax (%) </td> <td class='multiControl'  width='25%'>"
							+ strServiceTax + "</td>");
			sb
					.append("<td class='multiLabel'  width='25%'>Penalty (%)</td> <td class='multiControl'  width='25%'>"
							+ strPenalty + "</td>");
			sb.append("</tr>");
			sb.append("</table>");
			sb.append("<table width='400' align='center' cellspacing='1px'>");
			sb.append("<tr class='FOOTER'>");
			sb.append("<td colspan='3'>&nbsp;</td>");
			sb.append("</tr></table>");
		} catch (Exception e) {

			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getPopUpDtl()-->", e.getMessage());
		}

		return sb.toString();

	}

	public static String getRefundTariffPopUp_BS(CashCollectionOnlineTransVO voObj) {
		StringBuffer sb = new StringBuffer("");

		String strValmode = voObj.getStrRefundTariffHiddenValue();

		String val[] = strValmode.replace('^', '#').split("#");

		String strRateUnit = val[3] + "/" + val[12];
		String strDiscountUnit = val[8];
		String strDiscountType = val[9];
		String strServiceTax = val[7];
		String strPenalty = val[16];

		if (strDiscountType.equals("2")) {
			strDiscountUnit = strDiscountUnit + " %";
		} else {
			strDiscountUnit = strDiscountUnit + " Fixed";
		}

		try {

			
			  sb.append("<div class='row'>");
    		  sb.append("<div class='col-sm-6' style='text-align:right'><label style='margin-bottom: 0;'>Rate(Rs)/Unit-</label></div>");
    		  sb.append("<div class='col-sm-6' style='text-align:left' >" + strRateUnit +"</div>");
    		  sb.append("</div>");
    		  sb.append("<div class='row'>");
    		  sb.append("<div class='col-sm-6' style='text-align:right'><label style='margin-bottom: 0;'>Discount(Rs)/Unit-</label></div>");
    		  sb.append("<div class='col-sm-6' style='text-align:left'>" + strDiscountUnit+ "</div>");
    		  sb.append("</div>");
    		  sb.append("<div class='row'>");
    		  sb.append("<div class='col-sm-6' style='text-align:right'><label style='margin-bottom: 0;'>Service Tax (%)- </label></div>");
    		  sb.append("<div class='col-sm-6' style='text-align:left'>" + strServiceTax + "</div>");
    		  sb.append("</div>");
    		  sb.append("<div class='row'>");
    		  sb.append("<div class='col-sm-6' style='text-align:right'><label style='margin-bottom: 0;'>Penalty (%)-</label></div>");
    		  sb.append("<div class='col-sm-6' style='text-align:left'>" + strPenalty+" %"+ "</div>");
    		  sb.append("</div>");
    		  
    		  
    		  
			/*
			 * sb.append("<table >"); sb.append("<tr>");
			 * sb.append("<td  width='25%'>Rate(Rs)/Unit-</td><td   width='25%'>" +
			 * strRateUnit + "</td>");
			 * sb.append("<td   width='25%'>Discount/ Unit-</td> <td  width='25%'>"+
			 * strDiscountUnit + "</td>"); sb.append("</tr>"); sb.append("<tr>");
			 * sb.append("<td   width='25%'>Service Tax (%)- </td> <td   width='25%'>"+
			 * strServiceTax + "</td>");
			 * sb.append("<td width='25%'>Penalty (%)-</td> <td   width='25%'>"+ strPenalty
			 * + "</td>"); sb.append("</tr>"); sb.append("</table>");
			 */
			  
			 
			/*
			 * sb.append("<div class='row'><div class='col-sm-3>'");
			 * sb.append("<label>Rate(Rs)/Unit</lable></div>");
			 * sb.append("<div class='col-sm-3>'"); sb.append(""+ strRateUnit +"");
			 * sb.append("</div><div class='col-sm-3>");
			 * sb.append("<label>Discount/ Unit</label></div><div class='col-sm-3>");
			 * sb.append(""+ strDiscountUnit +"</div></div>"); sb.append("</div></div>");
			 * 
			 * sb.append("<div class='row'><div class='col-sm-3>'");
			 * sb.append("<label>Service Tax (%) </lable></div>");
			 * sb.append("<div class='col-sm-3>'"); sb.append(""+ strServiceTax + "");
			 * sb.append("</div><div class='col-sm-3>");
			 * sb.append("<label>Penalty (%)</label></div><div class='col-sm-3>");
			 * sb.append(""+ strPenalty +""); sb.append("</div></div>");
			 */
			
			
		} catch (Exception e) {

			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getPopUpDtl()-->", e.getMessage());
		}

		return sb.toString();

	}
	public static String getBillListingView(CashCollectionOnlineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = voObj.getBillSearchList();

		try {

			int start = Integer.parseInt(voObj.getStrBillFromRow());
			int actualBlockSet = Integer.parseInt(voObj.getStrBillCtBlockSet());

			final int REC_PER_PAGE = Integer.parseInt(voObj
					.getStrBillRowPerPage());
			final int PAGE_PER_BLOCK = 10;

			int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
			int totalRecordsToManipulate = totalFetchRecord - 1;

			int previous = 1;
			int next = 0;

			if (ws != null) {

				if (ws.size() != 0) {

					int actualFetchRecord = ws.size();

					if (actualBlockSet == 1)
						actualBlockSet = actualBlockSet + 1;

					next = ((actualBlockSet * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1;
					previous = (((actualBlockSet - 2) * PAGE_PER_BLOCK) - PAGE_PER_BLOCK) + 1;

					if (totalFetchRecord != actualFetchRecord) {

						totalFetchRecord = actualFetchRecord;
						totalRecordsToManipulate = actualFetchRecord;
						next = 0;

					}

					int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
					int reminder = totalRecordsToManipulate % REC_PER_PAGE;

					if (reminder > 0)
						totalLayer = totalLayer + 1;

					sb
							.append("<table width='100%'align='center' cellspacing='1px'>");

					sb.append("<tr>");
					sb.append("<td class='LABEL'>&nbsp;");

					if (start != 1) {
						sb
								.append("<a STYLE='CURSOR:POINTER'  onClick='fetchPatientList(\""
										+ previous
										+ "\",\""
										+ (actualBlockSet - 1)
										+ "\");'> <FONT COLOR='"
										+ strColor
										+ "'> &lt;&lt; Previous</FONT> </a> &nbsp;");

					}
					for (int i = 1; i <= totalLayer; i++) {

						if (i == 1) {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ strColor + "' name='linId' id='linId" + i
									+ "' onClick='layerIndexNavigator(\"" + i
									+ "\",\"" + totalLayer + "\")'>");
							sb.append((i + start - 1));

						} else {
							sb.append("<a STYLE='CURSOR:POINTER; color:"
									+ defaultColor + "' name='linId' id='linId"
									+ i + "' onClick='layerIndexNavigator(\""
									+ i + "\",\"" + totalLayer + "\")'>");
							sb.append((i + start - 1));
						}
						sb.append("</a> &nbsp;");
					}

					if (next > 0)
						sb
								.append("<a STYLE='CURSOR:POINTER' onClick='fetchPatientList(\""
										+ next
										+ "\",\""
										+ (actualBlockSet + 1)
										+ "\");'> <FONT COLOR='"
										+ strColor
										+ "'> Next &gt;&gt;</FONT></a>");

					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");

					/*
					 * sb .append("<table width='100%'align='center'
					 * cellspacing='1px'>");
					 * 
					 * sb.append("<tr>"); sb.append("<td class='LABEL'>&nbsp;");
					 * 
					 * if (start != 1) { sb.append("<a href='#'
					 * onClick='fetchBillList(\"" + previous + "\",\"" +
					 * (actualBlockSet - 1) + "\");'> &lt;&lt; Previous</a>
					 * &nbsp;"); } for (int i = 1; i <= totalLayer; i++) {
					 * sb.append("<a href='#' onClick='layerIndexNavigator(\"" +
					 * i + "\",\"" + totalLayer + "\")'>" + (i + start - 1) + "</a>
					 * &nbsp;"); }
					 * 
					 * if (next > 0) sb.append("<a href='#'
					 * onClick='fetchBillList(\"" + next + "\",\"" +
					 * (actualBlockSet + 1) + "\");'> Next &gt;&gt;</a>");
					 * 
					 * sb.append("</td>"); sb.append("</tr>"); sb.append("</table>");
					 */
					sb
							.append("<table width='100%'align='center' cellspacing='1px'>");

					sb.append("<tr>");
					sb.append("<td width='5%'class='multiLabel'>");
					sb.append("</td>");
					sb
							.append("<td width='23%'class='multiLabel'>Patient Name");
					sb.append("</td>");
					sb.append("<td width='18%'class='multiLabel'>Bill No.");
					sb.append("</td>");
					sb.append("<td width='18%'class='multiLabel'>Bill Date");
					sb.append("</td>");
					sb.append("<td width='18%'class='multiLabel'>Bill Amount");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");

					for (int i = 1; i <= totalLayer; i++) {

						if (i < totalLayer
								|| (i == totalLayer && reminder == 0)) {
							if (i == 1) {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:block'>");
							} else {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:none'>");
							}

							sb
									.append("<table width='100%'align='center' cellspacing='1px'>");
							for (int j = 0; j < REC_PER_PAGE; j++) {
								ws.next();
								sb
										.append("<tr ><td class='multiLabel' width='5%'><input type='radio' name='strBillNo' value='");
								sb.append(ws.getString(2));
								sb.append("'></td>");
								sb
										.append("<td class='multiControl' width='23%'>");
								sb.append(ws.getString(1));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(2));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(3));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(4));
								sb.append("</td>");
								sb.append("</tr>");
							}
							sb.append("</table>");
							sb.append("</div>");

						} else {
							if (i == 1) {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:block'>");
							} else {
								sb.append("<div id='tariffDivId" + i
										+ "' style='display:none'>");
							}
							sb
									.append("<table width='100%'align='center' cellspacing='1px'>");
							for (int k = 0; k < reminder; k++) {
								ws.next();
								sb
										.append("<tr ><td class='multiLabel' width='5%'><input type='radio' name='strBillNo' value='");
								sb.append(ws.getString(2));
								sb.append("'></td>");
								sb
										.append("<td class='multiControl' width='23%'>");
								sb.append(ws.getString(1));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(2));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(3));
								sb.append("</td>");
								sb
										.append("<td class='multiControl' width='18%'>");
								sb.append(ws.getString(4));
								sb.append("</td>");
								sb.append("</tr>");
							}
							sb.append("</table>");
							sb.append("</div>");

						}

					}

					sb.append("</td>");
					sb.append("</'tr>");

					sb.append("</table>");

				} else {
					sb
							.append("<table width='100%'align='center' cellspacing='1px'>");
					sb
							.append("<tr><td class='multiControl'><font color='red'>No Matching Record Found</font></td></tr>");
					sb.append("</table>");
				}

			} else {

				throw new Exception("Patient List WebRowSet is Null");

			}

		} catch (Exception e) {
			new HisException("Cash Collection Trans",
					"CashCollectionTransHLP.getPatientListingView()-->", e
							.getMessage());
		}

		return sb.toString();

	}

	public static String getOnLineReconcileTariffDetailsView(
			CashCollectionOnlineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		String strTempQtyType = "";
		int trfIndex = 0;

		float fltTariffActAmt = 0;
		
		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		try {

			sb
			.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
	sb.append("<tr>");
	sb.append("<td class='TITLE' colspan='9'>Tariff Detail</td>");
	sb.append("</tr>");
	sb.append("<tr>");
	sb.append("<td class='multiLabel'></td>");
	sb.append("<td class='multiLabel'>Tariff Name</td>");
	sb.append("<td class='multiLabel'>Reconcile Type<input type='hidden' class='txtFldMin' name='strTotalTariffActualAmount' value='0' ></td>");
	sb.append("<td class='multiLabel'>Rate/Unit<input type='hidden' class='txtFldMin' name='strTotalTariffDiscountAmount' value='0' ></td>");
	sb
			.append("<td class='multiLabel'>Req. Qty.<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' ></td>");
/*	sb
			.append("<td class='multiLabel'>Billed Qty.</td></td>");
	sb
			.append("<td class='multiLabel'>Unit</td></td>");*/
	sb.append("<td class='multiLabel'>Discount Amt</td>");
	sb.append("<td class='multiLabel'>Net Tariff Amt</td>");
	sb.append("</tr>");

			sb.append("</tr>");

			if (wsTariffDetails != null && wsTariffDetails.size() > 0) {

				while (wsTariffDetails.next()) {

					trfIndex = trfIndex + 1;

					String strGroupId = wsTariffDetails.getString(1);
					String strTariffId = wsTariffDetails.getString(2);
					String strChargeTypeId = wsTariffDetails.getString(3);
					String strGblTariffId = wsTariffDetails.getString(4);
					String strRateUnitId = wsTariffDetails.getString(5);
					String strApprovalId = wsTariffDetails.getString(6);
					// String strBserviceType = wsTariffDetails.getString(7);
					String strTariffName = wsTariffDetails.getString(7);

					// String strGroupName = wsTariffDetails.getString(9);
					String strUnitName = wsTariffDetails.getString(10);
					String strReqQty = wsTariffDetails.getString(11);
					String strBillQty = wsTariffDetails.getString(12);
					String strTariffRate = wsTariffDetails.getString(13);
					String strDisountUnit = wsTariffDetails.getString(14);
					String strDiscountType = wsTariffDetails.getString(15);
					String strQtyUnitName = wsTariffDetails.getString(18);
					String strQtyUnitId = wsTariffDetails.getString(19);
					String strIsPackage = wsTariffDetails.getString(20);
					String strServiceTax = wsTariffDetails.getString(21);
					String strPenelty = wsTariffDetails.getString(22);
					String strApprovalDtl = wsTariffDetails.getString(23);
					String strQtyType = wsTariffDetails.getString(24);
					String strRateBaseVal = wsTariffDetails.getString(25);
					String strQtyBaseVal = wsTariffDetails.getString(26);
					String strNetCost = wsTariffDetails.getString(27);
					String strReceiptNo = wsTariffDetails.getString(28);
					String strActualRate = wsTariffDetails.getString(29);
					// String strDisountType =
					// wsTariffDetails.getString(15);

					if (strGroupId == null)
						strGroupId = "";
					if (strTariffId == null)
						strTariffId = "";
					if (strChargeTypeId == null)
						strChargeTypeId = "";
					if (strGblTariffId == null)
						strGblTariffId = "";
					if (strRateUnitId == null)
						strRateUnitId = "";
					if (strApprovalId == null)
						strApprovalId = "";
					if (strTariffName == null)
						strTariffName = "";
					if (strReqQty == null)
						strReqQty = "0";
					if (strBillQty == null)
						strBillQty = "0";
					if (strTariffRate == null)
						strTariffRate = "0";
					if (strDisountUnit == null)
						strDisountUnit = "0";
					if (strRateBaseVal == null)
						strRateBaseVal = "";
					if (strQtyBaseVal == null)
						strQtyBaseVal = "";

					if(strQtyType.equals("1")){
						strTempQtyType = "Services";
					}else{
						strTempQtyType = "Refund";
					}
					
					
					String strHiddenVal = strTariffId + "^" + strReqQty + "*"
							+ strQtyBaseVal + "^" + strQtyUnitId + "^"
							+ strTariffRate + "^" + strRateUnitId + "^"
							+ strGroupId + "^" + strActualRate + "^"
							+ strServiceTax + "^" + strDisountUnit + "^"
							+ strDiscountType + "^" + strGblTariffId + "^"
							+ strApprovalId + "^" + strUnitName + "^"
							+ strRateBaseVal + "^" + strIsPackage + "^"
							+ strNetCost + "^" + strPenelty + "^" + "0^"
							+ strReceiptNo + "^" + strApprovalDtl +"^"+strQtyType;


					fltTariffActAmt = Float.parseFloat(strTariffRate) * Float.parseFloat(strReqQty);
					
					
			sb.append("<tr>");
			sb
					.append("<td class='multiControl'><input type='checkbox' name='strTariffDetailsId' value='");
			sb.append(strHiddenVal);

			sb.append("' onclick='setOnlineReconcileTariffDetails(this, \""
					+ trfIndex + "\" , \""+strQtyType+"\")'></td>");
			sb
					.append("<td class='multiControl'><a name='strBillTariffName' id='strBillTariffName"
							+ trfIndex
							+ "' STYLE='CURSOR:POINTER; color:blue' value='"
							+ strHiddenVal
							+ "'  onClick='showTariffPopup(this,\""
							+ strHiddenVal
							+ "\");'>"
							+ strTariffName
							+ "</a><input type='hidden' class='txtFldMin' name='strTariffServiceTaxAmt' id='strTariffServiceTaxAmt"
							+ trfIndex
							+ "' value='' disabled='disabled'></td>");
			
			sb.append("<td class='multiControl'>"+strTempQtyType+"</td>");
			
			sb
					.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffRate' id='strTariffRate"
							+ trfIndex
							+ "' value='"
							+ strTariffRate
							+ "' disabled='disabled'>"
							+ strTariffRate
							+ "/"
							+ strUnitName
							+ "<input type='hidden' class='txtFldMin' name='strTariffActualAmt' id='strTariffActualAmt"
							+ trfIndex
							+ "' value='"+fltTariffActAmt+"' disabled='disabled'></td>");
			sb
					.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffReqQty' id='strTariffReqQty"
							+ trfIndex
							+ "' value='"
							+ strReqQty
							+ "' disabled='disabled'>"
							+ strReqQty
							+ "/" + strQtyUnitName + "</td>");
		/*	sb
					.append("<td class='multiControl'><input type='text' class='txtFldMin' name='strTariffBilledQty' id='strTariffBilledQty"
							+ trfIndex
							+ "' onkeyup='setOnlineReconcileTariffDltsOnQtyChange(this, \""
							+ strHiddenVal
							+ "\", \""
							+ trfIndex
							+ "\");' value='0' disabled='disabled'></td>");

			sb.append("<td width='10%' class='multiControl'>");

			sb
					.append("<select class='comboMin'  onchange='setOnlineReconcileTariffDltsOnQtyUnitChange(this, \""
							+ strHiddenVal
							+ "\", \""
							+ trfIndex
							+ "\");'  name='strBillTariffUnit' id='strBillTariffUnit"
							+ trfIndex + "' disabled='disabled' > ");

			voObj.setStrOffLineTariffUnitTempId(strQtyUnitId);

			CashCollectionOnlineTransDAO.getOffLineTariffUnitList(voObj);

			if (voObj.getOfflineTariffUnit() != null
					&& voObj.getOfflineTariffUnit().size() > 0) {
				sb.append(new HisUtil("", "").getOptionValue(voObj
						.getOfflineTariffUnit(), strQtyUnitId + "^"
						+ strQtyBaseVal, "0^Select Value", false));
			} else {
				sb.append("<option value='1701^1'>Select Value</option>");
			}

			sb.append("</select>");
			sb.append("</td>");*/

			sb
					.append("<td class='multiControl'><input type='hidden' class='txtFldMin' name='strTariffDiscountAmt' id='strTariffDiscountAmt"
							+ trfIndex
							+ "' value='0' disabled='disabled'><div id='strTariffDiscountAmtDivId"
							+ trfIndex + "'>0.00</div></td>");
			sb
					.append("<td class='multiControl' style='font-weight:bold'><input type='hidden' class='txtFldMin' name='strTariffNetAmt' id='strTariffNetAmt"
							+ trfIndex
							+ "' value='0' disabled='disabled'><div id='strTariffNetAmtDivId"
							+ trfIndex + "'>0.00</div></td>");
			sb.append("</tr>");

		}
		sb.append("</table>");

	/*	sb
		.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'><tr>");
		
		sb.append("<td class='LABEL' colspan='4' width='50%'>Bill Type</td><td class='CONTROL' width='50%' colspan='3'><select name='strBillType' class='comboNormal'><option value='1'>Consolidated</option><option value='1'>Detailed</option></selected></td>");
		
		sb.append("</tr></table>");*/
		
		}
			
		} catch (Exception e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOnLineReconcileTariffDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}

	/*public static String getOnLineReconcileTariffDetailsPopUp(
			CashCollectionOnlineTransVO voObj) {
		StringBuffer sb = new StringBuffer("");

		String strValmode = voObj.getStrOnLineReconcileTariffHiddenValue();

		String val[] = strValmode.replace('^', '#').split("#");

		String strTariffRatePerUnit = val[0];
		String strDisountUnit = val[1];
		String strServiceTax = val[3];
		if (val[2].equals("1")) {

			strDisountUnit = strDisountUnit + " Fixed";
		} else {
			strDisountUnit = strDisountUnit + " %";
		}

		try {

			sb
					.append("<table width='400' align='center' cellpadding='0' cellspacing='0'>");
			sb
					.append("<tr class='HEADER' align='left'><td>&nbsp;Refund Cost Calculation Details</td>");
			sb
					.append("<td align='right'><img  style='cursor: hand; cursor: pointer'    src='../../hisglobal/images/stop.png' align='middle' onclick='hide_popup_menu(\"reconcilTariffPopupDetailsDivId\");'> </td></tr>");
			sb.append("</table> ");
			sb.append("<table width='400' align='center' cellspacing='1px'>");
			sb.append("<tr>");
			sb.append("<td class='multiLabel' width='20%'>Rate(Rs)/Unit</td>");
			sb.append("<td class='multiControl' width='20%'>"
					+ strTariffRatePerUnit + "</td>");
			sb.append("<td class='multiLabel' width='20%'>Discount(Rs)</td>");
			sb.append("<td class='multiControl' width='20%'>" + strDisountUnit
					+ "</td>");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td class='multiLabel' width='20%'>Service Tax(%)</td>");
			sb.append("<td class='multiControl' width='20%'>" + strServiceTax
					+ "</td>");
			sb.append("<td class='multiLabel' colspan='2' width='20%'></td>");
			sb.append("</tr>");
			
			sb.append("</table>");
			sb.append("<table width='400' align='center'>");
			sb.append("<tr class='FOOTER'>");
			sb.append("<td colspan='3'>&nbsp;</td>");
			sb.append("</tr></table>");
		} catch (Exception e) {

			new HisException(
					"Cash Collection Trans ",
					"CashCollectionTransHLP.getOnLineReconcileTariffDetailsPopUp()-->",
					e.getMessage());
		}

		return sb.toString();

	}
*/
	public static String getAdmissionCancellationDetails(
			CashCollectionOnlineTransVO voObj, String mode) {
		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = null;

		try {

			ws = voObj.getAdmissionCancellationDetails();

			if (ws.next()) {

				String strAccountNo = ws.getString(1);
				String strReceivedAmt = ws.getString(2);
				String strExpenceAmt = ws.getString(3);
				String strRefundAmt = ws.getString(4);
				String strBillNo = ws.getString(7);

				sb
						.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<tr>");
				sb
						.append("<td colspan='4' class='TITLE'>Refund Advance Details</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb
						.append("<td class='LABEL' width='25%'>Received Amount (<img src='/HBIMS/hisglobal/images/INR.png'>)</td>");
				sb
						.append("<td class='CONTROL' width='25%' style='font-weight:bold'>"
								+ strReceivedAmt
								+ "<input type='hidden' name='strAdmissionCancellationReceivedAmount' value='"
								+ strReceivedAmt
								+ "'><input type='hidden' name='strBillNo' value='"
								+ strBillNo
								+ "'><input type='hidden' name='strRefundAdvancePaneltyAmt' value='0'></td>");
				sb
						.append("<td class='LABEL' width='25%'>Expense Amount (<img src='/HBIMS/hisglobal/images/INR.png'>)</td>");
				sb
						.append("<td class='CONTROL' width='25%' style='font-weight:bold'>"
								+ strExpenceAmt
								+ "<input type='hidden' name='strAdmissionCancellationExpenseAmount' value='"
								+ strExpenceAmt + "'></td>");
				sb.append("</tr>");
				sb.append("<tr>");
				if (mode.equals("2")) {
					sb.append("<td class='LABEL' width='25%'>Refund Type</td>");
					sb
							.append("<td class='CONTROL' width='25%'><select onchange='setAdmissionCancellationPenalty(this);' name='strAdmissionCancellationRefundType' ><option value='1'>Hospital Choice</option><option value='2'>Patient Choice</option></select></td>");
					sb.append("<td class='LABEL'  width='25%'>Penalty</td>");
					sb
							.append("<td class='CONTROL' width='25%' style='font-weight:bold'><input type='hidden' name='strAdmissionCancellationPenalty' value='0'><div id='strAdmissionCancellationPenaltyDivId'>0 %</div></td>");
				} else {
					sb.append("<td class='multiLabel'  width='25%'></td>");
					sb
							.append("<td class='CONTROL' width='25%' style='font-weight:bold'><input type='hidden' name='strAdmissionCancellationPenalty' value='0'><div id='strAdmissionCancellationPenaltyDivId'>0 %</div></td>");
					sb
							.append("<td class='CONTROL' colspan='3' width='20%'></td>");
				}
				sb.append("</tr>");
				sb.append("</table>");

				sb.append("^" + strRefundAmt + "^" + strAccountNo);

			}
		} catch (Exception e) {

			new HisException(
					"Cash Collection Trans ",
					"CashCollectionTransHLP.getAdmissionCancellationDetails()-->",
					e.getMessage());
		}

		return sb.toString();

	}
	
	public static String getOnLineRefundAdvanceView_BS(CashCollectionOnlineTransVO voObj) {

		StringBuffer sb = new StringBuffer("");

		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();

		try {

			if (wsTariffDetails != null) {

				sb.append("<div class='subHeaders'><i class='fas fa-university' style='font-size:26px;'></i>Refund Advance Detail</div>");
			//	sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sb.append("<table class='table'>");
				sb.append("<thead>");
				sb.append("<tr>");
				sb.append("<th>Tariff Name<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' > <input type='hidden' class='txtFldMin' name='strTotalTariffActualAmount' value='0' > </th>");
				sb.append("<th>Refund Cost (<img src='/HBIMS/hisglobal/images/INR.png'>)</th>");
				sb.append("</tr>");
				sb.append("</thead>");
				sb.append("<tbody>");
				
				
				/*
				 * sb.append("<tr>");
				 * sb.append("<td class='TITLE' colspan='2'>Refund Advance Detail</td>");
				 * sb.append("</tr>"); sb.append("<tr>"); sb
				 * .append("<td class='multiLabel' width='75%'>Tariff Name<input type='hidden' class='txtFldMin' name='strTotalTariffServiceTaxAmount' value='0' ></td>"
				 * );
				 * 
				 * sb
				 * .append("<td class='multiLabel'  width='25%'>Refund Cost (<img src='/HBIMS/hisglobal/images/INR.png'>)</td>"
				 * ); sb.append("</tr>");
				 */

				if (wsTariffDetails != null && wsTariffDetails.size() > 0) {
					while (wsTariffDetails.next()) {

						
						String strTariffName = wsTariffDetails.getString(7);
						String strPenelty = wsTariffDetails.getString(22);
						String strTariffRate = wsTariffDetails.getString(13);
						
						if (strTariffName == null)
							strTariffName = "";
						if (strTariffRate == null)
							strTariffRate = "0.00";
						if (strPenelty == null)
							strPenelty = "0";

						float netAmt = Float.parseFloat(strTariffRate);
						float penelty = Float.parseFloat(strPenelty);
						float peneltyAmt = (netAmt * penelty) / (100 - penelty);

						strTariffRate = HisUtil.getAmountWithDecimal(strTariffRate, 2);
						
						sb.append("<tr>");
						sb
								.append("<td><input type='hidden' name='strRefundAdvancePenelty' value='"
										+ strPenelty
										+ "'><input type='hidden' name='strTotalTariffPenaltyAmount' value='"
										+ peneltyAmt
										+ "'><a style='color:blue; cursor:pointer' onclick='showRefundAdvanceDtls(this , \""
										+ penelty
										+ "^"
										+ peneltyAmt
										+ "\");'>"
										+ strTariffName + "</a></td>");

						sb
								.append("<td><div id='strTariffRefundCostDivId'><b>"
										+ strTariffRate
										+ "</b></div><input type='hidden' name='strTariffRefundCost' disabled='disabled' class='txtFldNormal' value='"
										+ strTariffRate + "' ></td>");
						sb.append("</tr>");

					}
				

				} else {

					sb.append("<tr>");
					sb
							.append("<td>No Refund Advance Detail Available</td>");
					sb.append("</tr>");
				}
				sb.append("</tbody>");
				sb.append("</table>");
			}
		} catch (Exception e) {
			new HisException(
					"Cash Collection Trans",
					"CashCollectionTransHLP.getOnLineRefundTariffDetailsView()-->",
					e.getMessage());
		}

		return sb.toString();
	}
	
	public static String getOnLineAdvanceDetailsViewBS(CashCollectionOnlineTransVO voObj) 
	{
		StringBuffer sb = new StringBuffer("");
		WebRowSet wsTariffDetails = voObj.getOnlineTariffDetails();
		String strClientPatientNo=voObj.getStrClientPatientNo();
		BillConfigUtil bcu=null;

		try 
		{
			
			sb.append("<P class='subHeaders'>Advance Details</p>");
			
			sb.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px'>");
			

			if (wsTariffDetails.next()) 
			{
				String strTariffRate = wsTariffDetails.getString(13);
				String strClPath=wsTariffDetails.getString(38);
				String strClientNo=wsTariffDetails.getString(39);
				String strClCardNoId=wsTariffDetails.getString(43);
				String strClCardHolderName=wsTariffDetails.getString(44);
				String strCreditRelationWithStaff=wsTariffDetails.getString(45);
				String strClValidity=wsTariffDetails.getString(46);
				String strCatGroup  	= wsTariffDetails.getString(47);//3,4- Credit,0-Paid

				if (strTariffRate == null) strTariffRate = "0";

				
				
				bcu=new BillConfigUtil(voObj.getStrHospitalCode());
				
				if(bcu.getStrCreditCashlessAppRequired().equals("1"))
				{
					sb.append("<tr>");
					sb.append("<td width='12%' class='LABEL'>Advance Amount</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strAdvanceAmount' maxlength='7'  class='txtFldNormal' onkeypress='return validateData(event,7);' onkeyup='calcNetAmount();' value='"+strTariffRate+"'>");
					sb.append("</td>");
					sb.append("<td width='12%' class='LABEL'>Payment Type</td>");
					sb.append("<td width='10%' class='CONTROL'>");
					sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' disabled='disabled' > ");
					sb.append("<option value='11'>Credit</option>");
					//sb.append("<option value='13'>Credit(Urgent)</option>");
					sb.append("</select>");
					sb.append("</td>");
					
					//adding Credit Client Details ....
					sb.append("<td width='12%' class='LABEL'>Credit Letter No.</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strCreditLetterNo' readonly='readonly' class='txtFldNormal' value='"+wsTariffDetails.getString(33)+"' >");
					sb.append("</td>");
					
					sb.append("<td width='12%' class='LABEL'>Credit Letter Date</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strCreditLetterDate' readonly='readonly' class='txtFldNormal' value='"+wsTariffDetails.getString(34)+"'>");
					sb.append("<input type='hidden' name='strClientPatientNo' value='"+strClientPatientNo+"'>");
					sb.append("<input type='hidden' name='strCreditFilePath'  value='"+strClPath+"'>");
					sb.append("<input type='hidden' name='strCreditClientNo'  value='"+strClientNo+"'>");
				//	sb.append("<input type='hidden' name='strEmployeeId'  value='"+strClCardNoId+"'>");
				//	sb.append("<input type='hidden' name='strEmployeeName' value='"+strClCardHolderName+"'>");
				//	sb.append("<input type='hidden' name='strRalationId' value='"+strCreditRelationWithStaff+"'>");
				//	sb.append("<input type='hidden' name='strCardValidity' value='"+strClValidity+"'>");
					sb.append("<input type='hidden' name='strCreditBillApprovalDone' value='1'>");//Approval Done
					sb.append("</td>");
					
					sb.append("</tr>");
				}
				else if(strCatGroup.equals("3") || strCatGroup.equals("4"))//Credit
				{
					sb.append("<tr>");
					sb.append("<td width='12%' class='LABEL'>Advance Amount</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strAdvanceAmount' maxlength='7' class='txtFldNormal' onkeypress='return validateData(event,7);' onkeyup='calcNetAmount();' value='"+strTariffRate+"'>");
					sb.append("</td>");
					sb.append("<td width='12%' class='LABEL'>Payment Type</td>");
					sb.append("<td width='10%' class='CONTROL'>");
					sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' onchange='enableCreditDetails(this)'> ");
					sb.append("<option value='11'>Credit</option>");
					sb.append("<option value='10'>Paid</option>");
					/*sb.append("<option value='12'>Paid(Urgent)</option>");
					sb.append("<option value='13'>Credit(Urgent)</option>");*/
					sb.append("</select>");
					sb.append("</td>");
					//adding Credit Client Details ....
					
					BillingVO voBilling=new BillingVO();
					voBilling.setStrValue1(voObj.getStrCrNo());
					voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
					voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
					voBilling.setStrServiceType("2");//1-OP CONSULATION ONLY,OP & INV ,2-IP ONLY & IP & INV
					String creditListCombo=HLPbilling.getCreditLetterListComboOnline(voBilling,"1",false,true); 
					
					
					sb.append("<td width='35%' class='LABEL'><label title='Format:Letter Or Counter Or TG No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details<font color='red' size='1px'>(Letter No/Date/Client/Limit/Card-Emp No./Emp Name)</font></label></td>");
					sb.append("<td class='CONTROL'>");
					sb.append(creditListCombo);
					sb.append("</td>");					
					sb.append("</tr>");
				}
				else//NOn Credit
				{
					sb.append("<tr>");
					sb.append("<td width='12%' class='LABEL'>Advance Amount</td>");
					sb.append("<td width='12%' class='CONTROL'>");
					sb.append("<input type='text' name='strAdvanceAmount' maxlength='7' class='txtFldNormal' onkeypress='return validateData(event,7);' onkeyup='calcNetAmount();' value='"+strTariffRate+"'>");
					sb.append("</td>");
					sb.append("<td width='12%' class='LABEL'>Payment Type</td>");
					sb.append("<td width='10%' class='CONTROL'>");
					sb.append("<select class='comboMin' name='strCreditPaymentType' id='strCreditPaymentType' disabled='disabled' > ");
					sb.append("<option value='10'>Paid</option>");
					//sb.append("<option value='12'>Paid(Urgent)</option>");
					sb.append("</select>");
					sb.append("</td>");
					sb.append("<td width='35%' class='LABEL'><label title='Format:Letter No/Letter Date/Client Name/Credit Limit/Card-Emp No./Emp Name' style='cursor:pointer;'>Credit Details<font color='red' size='1px'>(Letter No/Date/Client/Limit/Card-Emp No./Emp Name)</font></label></td>");
					sb.append("<td class='CONTROL'>");
					BillingVO voBilling=new BillingVO();
					voBilling.setStrValue1(voObj.getStrCrNo());
					voBilling.setStrHospitalCode(voObj.getStrHospitalCode());
					voBilling.setStrCatCode(voObj.getStrOffLineTreatmentCategory());
					String creditListCombo=HLPbilling.getCreditLetterListComboEmpty(voBilling,"1",true,true);										
					sb.append(creditListCombo);
					sb.append("</td>");					
					sb.append("</tr>");
				}
			}
			else
				sb.append("<tr><td width='100%' class='CONTROL'><div align='center'><font color='red'><b>No Advance Details Found/Credit Bill Not Approved</b></font></div></td></tr>");
			
			sb.append("</table>");

		} 
		catch (SQLException e) 
		{
			new HisException("Billing","CashCollectionTransHLP.getOnLinePartPaymentClientDetailsView()-->",e.getMessage());
		}

		return sb.toString();
	}

}
