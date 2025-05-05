package mms.transactions.controller.hlp;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import com.ibm.icu.math.BigDecimal;

import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.GlobalVO;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.transactions.controller.fb.PatientReturnTransFB;
import mms.transactions.vo.PatientReturnTransVO;

public class PatientReturnTransHLP {

	public static int printLine = 0;
	public static final char FORMFEED = 12;
	public static int isServiceDiscountReq = 1;

	public static final char ESCAPECHAR = 27;
	public static final String BOLDON = ESCAPECHAR + "" + 'E';
	public static final String BOLDOFF = ESCAPECHAR + "" + 'F';

	public static String patientInjectioAdministrationDtl(String strHospitalCode,WebRowSet wb,PatientReturnTransVO voObj) throws Exception {
		StringBuffer sBuffer = new StringBuffer("");
		

		String strReturnUnitCombo = "";
		HisUtil hisutil = null;
		
		String strHiddenId = "";//total cost^unit id
		String unitId = "";
		String strBrdName = "";
		String strBtchSlNo = "";
		String strExpiryDt = "";
		String strBalQty = "";
//		String totalCost = "";
		String rateUnit = "";
		String rate = "";
		String rateUnitId ="";
		String manufDate = "";
		String consumable = "";
		String issueUnit = "";
		String returnUnit = "";
		String baseValue = "";
		String issueNo = "";
		String strOrgIssueStore="";
		
		int i = 0;
		
		try {

			if (wb != null && wb.size() > 0) {
				sBuffer.append("<table class='table' id='data-table'><thead>");
				sBuffer.append("<tr><th width= '25%'>Drug Name");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '12%'>Batch");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '10%'>Expiry Date");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '10%'>Balance Qty");
				sBuffer.append("</th>");
				sBuffer.append("<th width= '12%' ><font color='red'>*</font>Return Qty");
				sBuffer.append("</th>");
				
				sBuffer.append("<th width= '10%' ><font color='red'>*</font>Return Qty Unit");
				sBuffer.append("</th>");
				
				sBuffer.append("<th width= '5%'>Cost(Rs.)");
				sBuffer.append("</th>");
				sBuffer.append("</tr></thead>");

				while(wb.next())
				{		     	
					    strHiddenId   = wb.getString(1); //item id^itemBrandId^groupId^subGroupId 
													//total cost^unit id^rate unit^rate^rateunitid^base value
													//^manufdate^consumable^issueUnit^returnUnit
						strBrdName       = wb.getString(2);
						strBtchSlNo      = wb.getString(3);
						strExpiryDt      = wb.getString(4);
						strBalQty        = wb.getString(5);
						issueNo       	 = wb.getString(6);
						strOrgIssueStore = wb.getString(7);
						
						String[] temp = strHiddenId.replace("^", "#").split("#");
						
					//	totalCost = temp[4];
						unitId       = temp[5];
						rateUnit     = temp[6];
						rate         = temp[7];
						rateUnitId   = temp[8];
						baseValue    = temp[9];
						manufDate    = temp[10];
						consumable   = temp[11];
						issueUnit    = temp[12];
						returnUnit   = temp[13];
						
	  					
						//vo.setStrIssueQtyUnitId(unitId);
						voObj.setStrHospitalCode(strHospitalCode);
						
										  					
	  					if (voObj.getStrMsgType().equals("1")) {
							throw new Exception(voObj.getStrMsgString());
						}
	  					strReturnUnitCombo = "<option title='No.' selected='' value='6301^1^0'>No.</option>";  	
	  					
	  					if(strExpiryDt == null || strExpiryDt.equals("null") || strExpiryDt.equals(""))strExpiryDt = "---";
	  					if(strBrdName == null || strBrdName.equals("null") || strBrdName.equals("") )strBrdName = "---";
	  					if(strBtchSlNo == null || strBtchSlNo.equals("null") || strBtchSlNo.equals(""))strBtchSlNo = "---";
	  					if(strBalQty == null || strBalQty.equals("null") || strBalQty.equals(""))strBalQty = "---";
	  					
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width= '25%' align='left'>");
	  					sBuffer.append(strBrdName+""+"<input type='hidden' name='strItem' id='strItem" + i
		  							+"' value='"+ rateUnit+ '@'+ manufDate +'@'+ consumable +"'/>");
	  					sBuffer.append("</td>");
	  					
	  					sBuffer.append("<td width= '12%' align='center'>");
	  					sBuffer.append(strBtchSlNo);
	  					sBuffer.append("</td>");
	  					
	  					sBuffer.append("<td width= '15%' align='center'>");
	  					sBuffer.append(strExpiryDt);
	  					sBuffer.append("</td>");
	  					
	  					sBuffer.append("<td width= '10%' align='center' name='strBalanceQty' id='strBalanceQty'"+i+"'>");
	  					sBuffer.append(strBalQty+"<input type='hidden' name='balQty' id='balQty" + i
							+"' value='"+ issueUnit+ '@'+ returnUnit +"'/><input type='hidden' name='strBalQty' id='strBalQty" + i
							+"' value='"+ strBalQty+"'/></td>");
	  					 		
				 		sBuffer.append("<input type='hidden' name='strIssueNoList' id='strIssueNoList" + i +"' value='"+ issueNo+"'/>");
				 		sBuffer.append("<input type='hidden' name='strOrgIssueStoreList' id='strOrgIssueStoreList" + i +"' value='"+ strOrgIssueStore+"'/>");
				 		
					
	  					 sBuffer.append("<td width= '10%' align='center'>");
	  					 	sBuffer.append(
	  							"<input type='text' maxlength='8' autocomplete='off' onkeypress='return validateData(event,7);', onkeyup='quantityUnitValue("+i+");'"  +
	  							"name='strReturnQty' id='strReturnQty"
								+ i
								+ "' class='form-control' value='0'>");
	  					 sBuffer.append("</td>");
	  					 
	  					sBuffer.append("<td WIDTH='10%' align='center'>" +
	  							"<Select name='strReturnQtyUnitId' disabled='disabled' id='strReturnQtyUnitId"   
								+ i 
								+ "' onchange='quantityUnitValue("+i+");'>"
								+ strReturnUnitCombo + "</select></td>");
	  					
	  					 
	  					sBuffer.append("<td width= '5%' align='center'>");
	  					sBuffer.append("<div id='strTotalCostDivId"+i+"'>0.00</div>" +
	  							"<input type='hidden' name='strTotalCost' id='strTotalCost" + i
	  							+"' value='0'/><input type='hidden' name='strRate' id='strRate" + i
	  							+"' value='"+ rate+"@"+ rateUnitId+"@"+baseValue+"'/><input type='hidden' name='strHidParamVal' id='strHidParamVal" + i
	  							+"' value='"+wb.getString(1)+"'/>");	  					
	 					sBuffer.append("</td></tr>");
	  					i++;  						
	  				}
					 sBuffer.append("</td></tr></table>");

				sBuffer.append("<br><div class='row rowFlex reFlex'>");
				sBuffer.append("<div class='col-md-8'>");
				sBuffer.append("</div>");
				sBuffer.append("<div class='col-md-2'>Net Cost(Rs):");
				sBuffer.append("</div>");
				
				sBuffer.append("<div class='col-md-2' style='color: red; font-weight: bold'>"
								+ "<div id='strNetCostDivId' align='center'>0.00</div>"
								+ "<input type='hidden' name='strNetCost' id='strNetCost' value='0'/>");
				sBuffer.append("</div>");
				
				sBuffer.append("</div>");
			 } else {
				 sBuffer.append("<div class='row rowFlex reFlex'>");
				 sBuffer.append("<div class='col-md-12' style='text-align: center;color: red;'>No Record Available to Place Return Request");
				 sBuffer.append("</div>");
				 sBuffer.append("</div>");
			 }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
				return "ERROR";
	     }
	    return sBuffer.toString();
	 	}
	
	public static String getReturnDetailNEW(WebRowSet wb)throws SQLException 
	 {
			StringBuffer br = new StringBuffer();

		    String strPatName = "";
			String strCrNo = "";
			String strReturnStore = "";
			String strReturnNo = "";
			String strReturnDate = "";
			String strStoreId = "";
			
			int i = 0;
			
			try 
			{
			/*br.append("<div><hr><p class='subHeaders mb-0 text-left'>"
			+ "<i class='fas fa-th-list iround' style='font-size: 16px; color: #28a745' title=''></i>"
			+ "&nbsp;Return Records</p></div>");*/

				br.append("<table class='table' id='data-table'>");
				br.append("<thead>");
				br.append("<tr>");
				br.append("<th  width='15%' align='center' >Patient Name</th>");
				br.append("<th  width='20%' align='center' >CR No</th>");
				br.append("<th  WIDTH='20%' align='center' >Return To Store</th>");
				br.append("<th  width='20%' align='center' >Return No</th>");
				br.append("<th  width='15%' align='center' >Return Date</th>");
				br.append("<th  width='10%' align='center' >#</th>");
				br.append("</tr>");
				br.append("</thead>");
			
				if (wb.size() != 0) 
				{
					while (wb.next()) 
					{
						strPatName        = wb.getString(1);
						strCrNo           = wb.getString(2);
						strReturnStore    = wb.getString(3);
						strReturnNo       = wb.getString(4);
						strReturnDate     = wb.getString(5);
						strStoreId        = wb.getString(8);

						br.append("<input type='hidden' name='strHlpCrNo'        id='strHlpCrNo" +i+ "'     value=" + strCrNo + " />");
						br.append("<input type='hidden' name='strHlpReturnNo'    id='strHlpReturnNo" +i+ "' value=" + strReturnNo + " />");
						br.append("<input type='hidden' name='strHlpStoreId'     id='strHlpStoreId" +i+ "'  value=" + strStoreId + " />");
						
						br.append("<tr>");	
						br.append("<td width='15%' align='center' >"  + strPatName + "</td>");
						br.append("<td width='20%' align='center'>");
						br.append("<input type='hidden' name='flag' id='flag" +i+ "' value=" + "0" + " />");
						br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
						br.append("<a align='center' style='cursor:pointer;font-weight:350 !important ;font-size:16px;' title='Issue No Item Details' onClick='showPopUp(this,\""+ i + "\");'>" + strCrNo + "</a></td>");
						br.append("</td>");
						br.append("<td width='20%' align='left'    >"	+ strReturnStore + "</td>");
						br.append("<td width='20%' align='center'  >"	+ strReturnNo + "</td>");
						br.append("<td width='15%' align='center'  >"	+ strReturnDate + "</td>");
					/*br.append("<td width='10%' align='center'  >"
							+ "<img src='../../hisglobal/images/search_icon1.gif' onclick='generateIssueReportFunc(this,\""+ i + "\");' "
							+ "style='cursor: pointer;' title='Print Issue Item Details'>"
							+ "</td>");*/

						br.append("<td width='10%' align='center'>"
							     + "<button type='button' id='row" + i + "' "
							     + "class='btn btn-sm btn-success rounded-sm' "
							     + "title='View Return Voucher' onclick='generateIssueReportFunc(this, " + i + ");'>"
							     + "<i class='fa fa-fw fa-eye' aria-hidden='true'></i>"
							     + "</td>");
						br.append("</tr>");
						i++;
					}
				
				} else {
		    	  	 br.append("<tr style='text-align:center; color:red;'> <td colspan='5'>No Records to Display</td> </tr>");
				}

				br.append("</table> ");
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return "ERROR";

			}

			return br.toString();
		}
	
	public static String getIssueRptForDotMatrix(PatientReturnTransFB formBean)
			throws SQLException, UnsupportedEncodingException {
		String rptContents = "";
		WebRowSet ws = formBean.getWsIssueDetails();
		int i = 1;
		if (ws != null && ws.size() > 0) {
			/*
			 * Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line
			 * Issue Voucher) 1.Hospital Name ^ DDC Name ^ Prescribe For ^ Issue No ^ Issued
			 * By Doctor ^ Date ^ PIN ^ Hindi Text 2.Drug Name 3.Batch No 4.Exp Date 5.Issue
			 * Qty
			 */
			rptContents = "";
			rptContents += "                             Testing Slip "
					+ "                          Government of Rajasthan"
					+ "                      Mukhyamantri Nishulk Dava Yojna";
			rptContents += "     Hospital      :" + MakeRptStr(formBean.getStrHospitalName(), 30) + " DDC      :"
					+ formBean.getStrStoreName() + " " + "     Presc For     :"
					+ MakeRptStr(formBean.getStrPatientName(), 30) + " Issue No.:" + formBean.getStrIssueNo()
					+ "     By Doctor     :" + MakeRptStr(formBean.getStrPrescribedBy(), 30) + " Date     :"
					+ formBean.getStrIssueDate() + "     PIN.        :" + MakeRptStr(formBean.getStrCrNo(), 30)
					+ "\t";

			rptContents += "   ---------------------------------------------------------------------------"
					+ "   S.No  Drug Name                             Batch No.   Exp Date  Issue Qty"
					+ "   ---------------------------------------------------------------------------";
			while (ws.next()) {
				rptContents += MakeRptStr(String.valueOf(i) + ".", 3) + "" + MakeTariffStr(ws.getString(2), 40, 5) + " "
						+ MakeRptStr(ws.getString(3), 8) + "  " + MakeRptStr(ws.getString(4), 10) + " "
						+ MakeRptStr(ws.getString(5), 4) + "";
				i++;
			}
			rptContents += "   ---------------------------------------------------------------------------";
			rptContents += formBean.getStrHindiText();

			// Form Feed
			rptContents += String.valueOf((char) 12);

		}
		return rptContents;

	}

	public static String MakeRptStr(String tempString, int len) {
		if (tempString.length() < len) {
			int len1 = tempString.length();
			for (int i = 0; i < (len - len1); i++)
				tempString += " ";
		}

		return tempString;
	}

	/******************************************************* end ****/
	public static String MakeTariffStr(String Tname, int len, int prevSpace) {
		String Tname1 = "";
		String Tname2 = "";
		int i = 0;
		int len1 = 0;

		if (Tname.trim().length() > len) {
			Tname1 = Tname.substring(0, len) + "";
			for (i = 0; i < prevSpace; i++)
				Tname1 += " ";

			Tname2 = "-" + Tname.substring(len);
			len1 = Tname2.length();
			if (len1 > len) {
				Tname2 = "-" + Tname.substring(len, len - 1);
				len1 = Tname2.length();
			}

			Tname1 += Tname2;
		} else {
			Tname1 = Tname;
			len1 = Tname1.length();
		}
		//
		for (i = 0; i < (len - len1); i++)
			Tname1 += " ";

		return Tname1;
	}

	/**
	 * This method is used to show issued item Details on VIEW PAGE2
	 * 
	 * @param wb
	 * @param strItemCategory
	 * @param strHospitalCode
	 * @return
	 */
	public static String getIssuedDetail(WebRowSet wb) throws SQLException {
		StringBuffer br = new StringBuffer();

		String strIssueDate = "";
		String strIssueNo = "";
		String strIndentingStore = "";
		String strIndentNo = "";
		String strIndentDate = "";

		int i = 0;

		try {

			br.append(
					"<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellpadding='1px' cellspacing='1px'>");
			br.append("<tr>");
			br.append("<td class='multiRPTLabel' WIDTH='10%' align='CENTER'>#</td>");
			br.append("<td class='multiRPTLabel' WIDTH='15%' align='CENTER'>Issue Date</td>");
			br.append("<td class='multiRPTLabel' WIDTH='10%' align='CENTER'>Issue No</td>");
			br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>Issuing Store</td>");
			br.append("<td class='multiRPTLabel' WIDTH='15%' align='CENTER'>PIN</td>");
			br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>Patient Name</td>");
			// br.append("<td class='multiRPTLabel' WIDTH='10%' align='CENTER'>#</td>");
			br.append("</tr>");

			if (wb.size() != 0) {

				while (wb.next()) {
					strIssueDate = wb.getString(2);
					strIssueNo = wb.getString(1);
					strIndentingStore = wb.getString(3);
					strIndentNo = wb.getString(4);
					strIndentDate = wb.getString(5);
					br.append("<input type='hidden' name='strHlpIssueNo' id='strHlpIssueNo" + i + "' value="
							+ strIssueNo + " />");
					br.append("<input type='hidden' name='strHlpIndentNo' id='strHlpIndentNo" + i + "' value="
							+ strIndentNo + " />");
					br.append("<input type='hidden' name='strHlpIndentDate' id='strHlpIndentDate" + i + "' value="
							+ strIndentDate + " />");
					br.append("<input type='hidden' name='strHlpCrNo' id='strHlpCrNo" + i + "' value=" + wb.getString(6)
							+ " />");
					br.append("<input type='hidden' name='strHlpPatientName' id='strHlpPatientName" + i + "' value="
							+ wb.getString(7) + " />");

					br.append("<tr id='roww" + i + "'>");
					if (wb.isFirst())
						br.append("<td WIDTH='10%' CLASS='multiPOControl' ><div name='plus' id='plusdiv" + i
								+ "'><input type='radio' name='gender' checked onclick='validateIssue(\"" + i
								+ "\");' style='cursor: pointer;' title='Click to show item details'></div></td>");
					else
						br.append("<td WIDTH='10%' CLASS='multiPOControl' ><div name='plus' id='plusdiv" + i
								+ "'><input type='radio' name='gender'   onclick='validateIssue(\"" + i
								+ "\");' style='cursor: pointer;' title='Click to show item details'></div></td>");
					br.append("<td WIDTH='15%' CLASS='multiPOControl' >" + strIssueDate + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiPOControl' >");
					br.append("<input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
					br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
					br.append(strIssueNo);
					br.append("</td>");
					br.append("<td WIDTH='10%' CLASS='multiPOControl' >" + strIndentingStore + "</td>");
					br.append("<td WIDTH='15%' CLASS='multiPOControl' >" + wb.getString(6) + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiPOControl' >" + wb.getString(7) + "</td>");
					// br.append("<td WIDTH='10%' CLASS='multiPOControl' ><a href='#'
					// onclick='addnewtab();'>New Request</a> </td>");
					// br.append("<td WIDTH='10%' CLASS='multiPOControl' ><img height='20px'
					// width='30px' src='../../hisglobal/transactionutil/images/IssueOnDesk.png'
					// onclick='validateIssue(\""+ i + "\");' style='cursor: pointer;' title='Click
					// to Issue'><img src='../../hisglobal/images/search_icon1.gif'
					// onclick='generateIssueReportFunc(this,\""+ i + "\");' style='cursor:
					// pointer;' title='Print Issue Item Details'></td>");
					// br.append("<td WIDTH='10%' CLASS='multiPOControl' ><div name='plus'
					// id='plusdiv"+i+"'><img height='20px' width='20px'
					// src='../../hisglobal/images/plus.png' onclick='validateIssue(\""+ i + "\");'
					// style='cursor: pointer;' title='Click to show item details'><img
					// height='20px' width='20px' src='../../hisglobal/images/delete_on.gif'
					// onclick='deleteIssue(\""+ i + "\");' style='cursor: pointer;' title='Click to
					// delete issue req'></div></td>");

					br.append("</tr>");
					i++;
				}

				br.append("</table> ");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td  CLASS='multiControl' colspan='5'>" + "No Record Found" + "</td>");
				br.append("</tr>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}

	
	public static String getRequestDetails(WebRowSet ws) {

		StringBuffer sb = new StringBuffer("");

		try {

			if (ws != null && ws.size() > 0) {
				if (ws.next()) {

					String strDeptName = ws.getString(1);
					String strUnitName = ws.getString(2);
					String strPrescribedBy = ws.getString(3);
					String strPrescriptionFor = ws.getString(4);
					String strPrescriptionDate = ws.getString(5);
					String strPrescriptionFrom = ws.getString(9);

					String strDeptId = ws.getString(6);
					String strUnitId = ws.getString(7);
					String strConsultantId = ws.getString(8);
					String strEpisodeCode = ws.getString(10);
					String strVisitNo = ws.getString(11);
					String strWardCode = ws.getString(12);
					String strAdmissionNo = ws.getString(13);
					String strEmployeeNo = ws.getString(14);
					String strVisitTypeId = ws.getString(15);
					String strReqDate = ws.getString(16);

					String strHidReqVal = strDeptId + "^" + strUnitId + "^" + strConsultantId + "^" + strPrescribedBy
							+ "^" + strPrescriptionFor + "^" + strPrescriptionFrom + "^" + strEpisodeCode + "^"
							+ strVisitNo + "^" + strWardCode + "^" + strAdmissionNo + "^" + strEmployeeNo + "^"
							+ strVisitTypeId + "^" + strReqDate;

					if (strDeptName == null)
						strDeptName = "----";
					if (strUnitName == null)
						strUnitName = "----";
					if (strPrescribedBy == null)
						strPrescribedBy = "----";
					if (strPrescriptionFor == null)
						strPrescriptionFor = "----";
					if (strPrescriptionDate == null)
						strPrescriptionDate = "----";
					if (strPrescriptionFrom == null)
						strPrescriptionFrom = "----";

					sb.append("<input type='hidden' name ='strHidReqVal'  value='" + strHidReqVal + "'>");

					sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px' >");
					sb.append("<input type='hidden' name='strReqDate' id='strReqDate' value='" + strPrescriptionDate
							+ "'>");
					sb.append("<tr><td class='TITLE' colspan='4'>Request Details</td></tr>");
					sb.append("<tr><td width='25%'  class='LABEL'>Department</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strDeptName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Unit</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strUnitName);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Prescribed By</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPrescribedBy);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Prescription For</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPrescriptionFor);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Prescription Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPrescriptionDate);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Prescription From</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strPrescriptionFrom);
					sb.append("</td></tr>");
					sb.append("</table>");

				}
			} else {

				sb.append("<TR>");
				sb.append("<TD WIDTH='25%' CLASS='multiControl' colspan='5'><font color = 'red'>" + "No Record Found"
						+ "</font></TD>");
				sb.append("</TR>");

			}
		} catch (Exception e) {

			throw new HisException("Issue Transaction", "InjAdministrationTransHLP.getRequestDetails()-->",
					e.getMessage());
		}
		return sb.toString();
	}

	public static String getItemDetails(String hosCode, WebRowSet wb) throws SQLException {
		StringBuffer br = new StringBuffer();

		// InjAdministrationTransBO bo = null;
		PatientReturnTransVO vo = null;
		// HisUtil hisutil = null;

		// String strUnitValues = "";
		int i = 0;

		try {
			// hisutil = new HisUtil("mms", "InjAdministrationTransHLP");
			// bo = new InjAdministrationTransBO();
			vo = new PatientReturnTransVO();

			br.append("<div id = 'itemDetailDivId' style='display:none'>");
			br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' >");
			br.append("<tr><td class='TITLE' colspan='7'>Item Details(Online)</td></tr>");
			br.append("</table> ");
			br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' bgcolor='#6097BC'>");
			br.append("<tr><td width='15%' class='multiLabel'>Item Name</td>");
			br.append("<td width='13%' class='multiLabel'>Avl Qty</td>");
			br.append("<td width='12%' class='multiLabel'>Balance Qty</td>");
			br.append("<td width='15%' class='multiLabel'>Dosage</td>");
			br.append("<td width='15%' class='multiLabel'>Frequency</td>");
			br.append("<td width='15%' class='multiLabel'>Days</td>");
			br.append("<td width='15%' class='multiLabel'>Quantity</td></tr>");

			if (wb != null && wb.size() > 0) {

				while (wb.next()) {

					String strItemName = wb.getString(1);
					String strAvlQty = wb.getString(2);
					String strBalQty = wb.getString(3);
					String strReqQty = wb.getString(4);
					String strReqQtyUnitId = wb.getString(5);
					String strIssueQty = wb.getString(6);
					// String strIssueQtyUnitId = wb.getString(7);
					String strGenItemId = wb.getString(8);
					String strItemBrandId = wb.getString(9);
					String strIssueQtyBaseVal = wb.getString(10);
					String strGroupId = wb.getString(11);
					String strSubGroupId = wb.getString(12);
					String strBalanceQty = wb.getString(13);

					String strDosageName = wb.getString(17);
					String strFrequencyName = wb.getString(18);
					String strDays = wb.getString(19);
					String strQuantity = wb.getString(20);

					String strHiddenDosageFreq = wb.getString(15) + "^" + wb.getString(16) + "^" + strDays + "^"
							+ strQuantity;

					String strHidVal = strIssueQtyBaseVal + "^" + strGenItemId + "^" + strItemBrandId + "^" + strBalQty
							+ "^" + strGroupId + "^" + strSubGroupId + "^" + strReqQtyUnitId + "^" + strBalanceQty;

					String strBalQtyDtl = strReqQty + "^" + strIssueQty;

					String[] temp = strAvlQty.replace('@', '#').split("#");

					String[] strAvailableQty = temp[0].split("\\^");
					String[] strUnitId = temp[1].split("\\^");
					vo.setStrIssueUnitId(strUnitId[0]);

					br.append(
							"<input type='hidden' name='strAvlQty' id='strAvlQty" + i + "' value='" + strAvlQty + "'>");
					br.append("<input type='hidden' name='strHidValue' id='strHidValue" + i + "' value='" + strHidVal
							+ "'>");
					br.append("<input type='hidden' name='strBalQtyDtl' id='strBalQtyDtl" + i + "' value="
							+ strBalQtyDtl + " >");
					br.append("<input type='hidden' name='strHiddenDosageFreq' id='strHiddenDosageFreq" + i
							+ "' value='" + strHiddenDosageFreq + "'>");
					br.append("<TR>");

					br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >" + strItemName + "</TD>");
					br.append("<TD WIDTH='13%' colspan='1' CLASS='multiControl' >" + strAvailableQty[0] + "</TD>");
					br.append("<TD WIDTH='12%' colspan='1' CLASS='multiControl' ><a name='strBalQty' id='strBalQty" + i
							+ "' STYLE='CURSOR:POINTER;color:blue' onClick='balQtyDtl(this,\"" + i + "\");'>"
							+ strBalQty + "</a></TD>");

					br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >" + strDosageName + "</TD>");
					br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >" + strFrequencyName + "</TD>");
					br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >" + strDays + "</TD>");
					br.append("<TD WIDTH='15%' colspan='1' CLASS='multiControl' >" + strQuantity + " No. </TD>");

					br.append("</TR>");
					i++;
				}

				br.append("</table> ");
				br.append("</div> ");
			} else {
				br.append("<div id = 'itemDetailDivId' style='display:none'>");
				br.append("<TR>");
				br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='6'><font color = 'red'>" + "No Record Found"
						+ "</font></TD>");
				br.append("</TR>");
				br.append("</div> ");
			}

		} catch (Exception e) {

			throw new HisException("Issue Transaction", "InjAdministrationTransHLP .getItemDetails() -->",
					e.getMessage());

		}

		return br.toString();
	}

	public static String getIssueDetails(WebRowSet ws) throws SQLException {
		StringBuffer sb = new StringBuffer();

		int i = 0;

		try {

			if (ws != null && ws.size() > 0) {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");

				while (ws.next()) {

					String strIssueNo = ws.getString(1);
					String strIssueDate = ws.getString(2);
					String strIssueSoreID = ws.getString(3);
					if (strIssueNo == null)
						strIssueNo = "----";
					if (strIssueDate == null)
						strIssueDate = "----";

					sb.append("<input type='hidden' name='strIssueNo' id='strIssueNo" + i + "' value=" + strIssueNo
							+ " >");
					sb.append("<input type='hidden' name='strIssueSoreID' id='strIssueSoreID" + i + "' value="
							+ strIssueSoreID + " >");
					sb.append("<tr><td width='50%' colspan ='2'  class='LABEL'>IssueNo. / IssueDate</td>");
					sb.append(
							"<td width='50%' colspan ='2' class='CONTROL'><a name='strIssueDtl' id='strIssueDtl' STYLE='CURSOR:POINTER;color:blue' onClick='getIssuePopUp(this, \""
									+ i + "\" );'>");
					sb.append(strIssueNo + "/" + strIssueDate);
					sb.append("</td></tr>");

					i++;
				}

				sb.append("</table>");
			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
				sb.append("<TR>");
				sb.append("<TD WIDTH='25%' CLASS='multiControl' colspan='4'><font color = 'red'>" + "No Record Found"
						+ "</font></TD>");
				sb.append("</TR>");
				sb.append("</table>");

			}
		} catch (Exception e) {

			throw new HisException("Issue Transaction", "InjAdministrationTransHLP .getIssueDetails() -->",
					e.getMessage());

		}

		return sb.toString();
	}

	public static String getBilledItemDtls(PatientReturnTransVO vo) throws SQLException {
		StringBuffer br = new StringBuffer();
		WebRowSet wb = vo.getStrBilledItemDetailWs();

		String strIssueDate = "";
		String strIssueNo = "";
		String strIndentingStore = "";
		String strIndentNo = "";
		String strIndentDate = "";
		float tot = 0;

		int i = 0;

		try {
			br.append("<table class='TABLEWIDTH' align='center' cellpadding='1' cellspacing='1'>");
			br.append("<tr>");
			br.append("<td class='TITLE' colspan='2'><div id='minusdiv' style=''>");
			if (wb.size() != 0) {
				wb.next();
				br.append("&nbsp;Billed Item Details against Receipt no. "
						+ wb.getString(8).replace("^", "#").split("#")[0] + " & Issue No : " + wb.getString(1)
						+ "</div>");
			} else
				br.append("&nbsp;Billed Item Details </div>");

			br.append("</td></tr></table>");

			br.append(
					"<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellpadding='1px' cellspacing='1px'>");
			br.append("<tr>");
			br.append("<td class='multiRPTLabel' WIDTH='35%' align='CENTER'>Item Name</td>");
			br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>Billed Qty</td>");
			br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>Batch/Serial No.</td>");
			br.append("<td class='multiRPTLabel' WIDTH='20%' align='CENTER'>M.R.P.</td>");
			br.append("</tr>");
			wb.beforeFirst();
			if (wb.size() != 0) {

				while (wb.next()) {
					strIssueDate = wb.getString(2);
					strIssueNo = wb.getString(1);
					strIndentingStore = wb.getString(3);
					strIndentNo = wb.getString(4);
					strIndentDate = wb.getString(5);
					br.append("<input type='hidden' name='strHlpIssueNo' id='strHlpIssueNo" + i + "' value="
							+ strIssueNo + " />");
					br.append("<input type='hidden' name='strHlpIndentNo' id='strHlpIndentNo" + i + "' value="
							+ strIndentNo + " />");
					br.append("<input type='hidden' name='strHlpIndentDate' id='strHlpIndentDate" + i + "' value="
							+ strIndentDate + " />");
					br.append("<input type='hidden' name='strHlpCrNo' id='strHlpCrNo" + i + "' value=" + wb.getString(6)
							+ " />");
					br.append("<input type='hidden' name='strHlpPatientName' id='strHlpPatientName" + i + "' value="
							+ wb.getString(7) + " />");
					br.append("<input type='hidden' name='strHlpBillDtl' id='strHlpBillDtl" + i + "' value="
							+ wb.getString(8) + " />");

					br.append("<tr>");
					br.append("<td WIDTH='25%' CLASS='multiPOControl' >" + wb.getString(9) + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiPOControl' >"
							+ wb.getString(8).replace("^", "#").split("#")[1] + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiPOControl' >" + wb.getString(10) + "</td>");
					br.append("<td WIDTH='20%' CLASS='multiPOControl' >" + wb.getString(11) + "</td>");

					br.append("</tr>");
					i++;
					tot += Float.parseFloat(wb.getString(8).replace("^", "#").split("#")[1].split(" ")[0])
							* Float.parseFloat(wb.getString(11).split("/")[0]);
				}
				br.append("<tr>");
				br.append("<td colspan='4' CLASS='multiPOControl' ><div align='right'><b> Total Cost : " + tot
						+ "</b></div></td>");
				br.append("</tr>");
				br.append("<tr>");
				br.append(
						"<td colspan='4' CLASS='multiPOControl' ><div align='right'><a href='#' class='button' onclick='save();'><span class='issue'><div align='center'>Issue</div></span></a></div></td>");
				br.append("</tr>");
				br.append("</table> ");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td  CLASS='multiControl' colspan='5'>" + "No Record Found" + "</td>");
				br.append("</tr>");
				br.append("</table> ");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";

		}

		return br.toString();
	}

	/*
	 * replace with below HLP method getIssueDetailsBS >>
	 * getPreviousIssueDetails==Issue no & date
	 */
	public static String getIssueDetailsBS(WebRowSet ws) throws SQLException {
		StringBuffer sb = new StringBuffer();

		int i = 0, j = 1;

		try {

			if (ws != null && ws.size() > 0) {
				sb.append("<div class='row'>");

				sb.append(
						"<div class='col-sm-1'><i class='fas fa-angle-double-left' onclick='nxtChunk(\"prev\")'></i></div>");
				sb.append("<div class='col-sm-10' id='chunks'>");

				while (ws.next()) {

					if (i == 0) {
						sb.append("<div class='row'  id='0-chunk' >");
					}
					if (i == (3 * j)) {
						sb.append("<div class='row'  id='" + j + "-chunk' style='display:none;'>");
						j++;
					}

					/*
					 * if(i>0) { if(3%(i)==0) { if(j>1)
					 * sb.append("<div class='row'  id='"+j+"-chunk' style='display:none;'>"); }
					 * }else sb.append("<div class='row'  id='1-chunk' >");
					 */

					sb.append("<div class='col-sm-4'>");
					String strIssueNo = ws.getString(1);
					String strIssueDate = ws.getString(2);
					String strIssueSoreID = ws.getString(3);
					if (strIssueNo == null)
						strIssueNo = "----";
					if (strIssueDate == null)
						strIssueDate = "----";

					sb.append("<input type='hidden' name='strIssueNo' id='strIssueNo" + i + "' value=" + strIssueNo
							+ " >");
					sb.append("<input type='hidden' name='strIssueSoreID' id='strIssueSoreID" + i + "' value="
							+ strIssueSoreID + " >");
					sb.append(
							"<p align='center'><i class='fa fa-folder fa-2x' style='color:blue' onclick='callIssuePop(this)'></i></p>");
					sb.append(
							"<a name='strIssueDtl' id='strIssueDtl' STYLE='CURSOR:POINTER;color:rgba(75,75,75, 0.7)' onClick='getIssuePopUp(this, \""
									+ i + "\" );'><p align='center'>");
					sb.append(strIssueNo + "</p><p align='center'>" + strIssueDate);
					sb.append("</p></a>");
					sb.append("</div>");

					/*
					 * if(i>0) { if(3%(i)==0) { if(j>1) sb.append("</div>"); j++; }} else
					 * sb.append("</div>");
					 */
					// if(ws.size()>=((3*j)-1))
					if (i == ((3 * j) - 1)) {
						sb.append("</div>");

					} else {
						if (i == (ws.size() - 1))
							sb.append("</div>");
					}

					i++;

				}
				sb.append(
						"</div><div class='col-sm-1'><i class='fas fa-angle-double-right' onclick='nxtChunk(\"nxt\")'></i></div>");

				sb.append("</div>");
			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
				sb.append("<TR>");
				sb.append("<TD WIDTH='25%' align='center' colspan='4'><font color = 'red'>" + "No Record Found"
						+ "</font></TD>");
				sb.append("</TR>");
				sb.append("</table>");

			}
		} catch (Exception e) {
			e.printStackTrace();
			;
			throw new HisException("Issue Transaction", "InjAdministrationTransHLP .getIssueDetails() -->",
					e.getMessage());

		}

		return sb.toString();
	}

	/* == new added for printing Issue no & date == */
	public static String getPreviousIssueDetails(PatientReturnTransVO vo, WebRowSet ws) {
		StringBuffer sb = new StringBuffer("");

		/*
		 *  1.ISSUE_DATE, 
		 *  2.ISSUE _TO
		 *  3.STORE_NAME,
		 *  4.BRAND_ITEM_NAME,  
		 *  5.BATCH_NO,
		 *  6.EXPIRY_DATE,
		 *  7.ISSUE_BY,
		 *  8.ADMINISTER_MODE, 
		 *  9.ADMINISTER_TYPE,
		 *  10.Doses
		 */
		WebRowSet ws1 = vo.getStrIssueDetailWs();
		int i = 1;

		try {
			HttpServletRequest request=null;
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(vo.getStrHospitalCode());
			Map require =new HashMap();
		    require.put("REQUEST", request);
		    require.put("FORMAT", "html");
		    require.put("HOSPCODE", vo.getStrHospitalCode());

			String strHeader=hisUtil.getHospitalHeaderMain(require); 
			System.out.println("------strHeader.toString()-----"+strHeader.toString());
			sb.append("<br>");
			sb.append("<table align='center' border='0' cellspacing='0' cellpadding='0' height='10'> ");
			sb.append(
					"<tr><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printData12(2);' /></div></td>");
			sb.append("</tr>");
			sb.append(strHeader.toString());
			sb.append("</table> ");
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
			
			sb.append("</table>");	
			sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
					"<tr> "
					+ " <td colspan='3'></td>"
					+ " <td colspan='3'align='center' style='font-size:15px'><b>Previous Issued Details</b></td>"
					+ " <td colspan='3'></td>");
			sb.append("</tr>");
			
			sb.append("<tr>"
					+ "<td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
				);
			
			sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Date ::<b>"
					+ vo.getStrFromDate() + "</b>  to  <b>"
					+ vo.getStrToDate() + "</b></font></td><td align='center' colspan='2'></td></tr>");
			
			/*
			 * sb.append(" <tr><td align='center' colspan='3'></td> " +
			 * "<td align='center' colspan='3'>" +
			 * "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
			 * "For Patient ::<b>" + vo.getStrPatientName() +
			 * "</b></font></td><td align='center' colspan='2'></td></tr>");
			 */
			sb.append(" <tr> "
			        + " <td colspan='3'></td>"
					+ " <td colspan='3'></td>"
					+ " <td colspan='3'><br></td>");
			sb.append("</tr>");
			
			sb.append("</table>");
			

			sb.append("<div class='row'>");
			sb.append("<div class='col-md-12'>");
			sb.append("<table class='table text-uppercase' align='center'  border='1px' cellpadding='0px' cellspacing='0px'>");
			sb.append("<thead class='thead-dark'>");
//			sb.append("<thead >");
			sb.append("<tr>");
			sb.append(
					"<th width='5%'  style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>S.No</b></th>");
			sb.append(
					"<th width='15%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b> Issue To /<br> Issue Date </b></th>");
//			sb.append(
//					"<th  width='10%' style='font-weight:350 !important ;font-size: 16px !important;text-align:center;'><b>Issue To</b></th>");
			sb.append(
					"<th  width='25%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Item Name</b></th>");
			sb.append(
					"<th  width='10%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Batch No</b></th>");
			sb.append(
					"<th  width='5%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Admn Mode</b></th>");
			sb.append(
					"<th  width='5%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Admn Type</b></th>");
			sb.append(
					"<th  width='5%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Expiry Date</b></th>");
			sb.append(
					"<th  width='15%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Doses</b></th>");
			sb.append(
					"<th  width='15%' style='font-weight:350 !important ;font-size: 14px !important;text-align:center;'><b>Issue By</b></th>");
			sb.append("</tr>");
			sb.append("</thead>");

			/*
			 * String strIssueNo = ws1.getString(1); String strIssueDate = ws1.getString(2);
			 * String strIssueStoreID = ws1.getString(3);
			 * 
			 * if (strIssueNo == null) strIssueNo = "----"; if (strIssueDate == null)
			 * strIssueDate = "----";
			 * 
			 * 
			 */

			if (ws1.size() != 0) {
				while (ws1.next()) {
					
					
					/*   pkg_mms_view2.proc_hrgt_patient_inj_advice_dtl [ Mode - 2]
			    
	                    
					  */
					/* 
					 * pkg_mms_view2.proc_hrgt_patient_inj_advice_dtl [ Mode - 3]
					 * 
					 *  1.ISSUE_DATE, 
					 *  2.ISSUE _TO
					 *  3.STORE_NAME,
					 *  4.BRAND_ITEM_NAME,  
					 *  5.BATCH_NO,
					 *  6.EXPIRY_DATE,
					 *  7.ISSUE_BY,
					 *  8.ADMINISTER_MODE, 
					 *  9.ADMINISTER_TYPE,
					 *  10.Doses
					 */
	    			
						
						sb.append("<tr>");	
						
						sb.append("<td   style='width:5%;font-weight: 400; font-size: 0.8rem; text-align:center;color:black;'>");
						sb.append(i);			
						sb.append("</td>");
						
						sb.append("<td   style='width:15%;font-weight: 400; font-size: 0.8rem; text-align:left;color:black;'>");
						sb.append(ws.getString(2));			
						sb.append(" /<br>");
						sb.append(ws.getString(1));
						sb.append("</td>");
					/*
					 * sb.
					 * append("<td   style='width:10%;font-weight: 400; font-size: 0.8rem; text-align:left;color:black;'>"
					 * ); sb.append(ws.getString(2));
					 */		
						sb.append("</td>");
						sb.append("<td   style='width:25%;font-weight: 400; font-size: 0.8rem; color:black;text-align:left;'>");
						sb.append(ws.getString(4));			
						sb.append("</td>");
						
						sb.append("<td   style='width:10%;font-weight: 400; font-size: 0.8rem; color: black;text-align:left;'>");
						sb.append(ws.getString(5));													
						sb.append("</td>");
						
						String admnType = "";
						if(ws.getString(9).equals("10")) {
							admnType = "Whole";
						}
						else if(ws.getString(9).equals("11")) {
							admnType = "Partial";
						}
						
						sb.append("<td   style='width:5%;font-weight: 400; font-size: 0.8rem; color: black;text-align:left;'>");
						sb.append(ws.getString(8));
						//sb.append(" / <br>");
						//sb.append(admnType);
						sb.append("</td>");
						
					 
					  sb.append("<td   style='width:5%;font-weight: 400; font-size: 0.8rem; color: black;text-align:left;'>"); 
					  sb.append(admnType); 
					  sb.append("</td>");
		
						sb.append("<td   style='width:5%;font-weight: 400; font-size: 0.8rem; color: black;text-align:center;'>");
						sb.append(ws.getString(6));			
						sb.append("</td>");
						
						sb.append("<td   style='width:15%;font-weight: 400; font-size: 0.8rem; color: black;text-align:left;'>");
						sb.append(ws.getString(10));													
						sb.append("</td>");
						
						sb.append("<td   style='width:15%;font-weight: 400; font-size: 0.8rem; color: black;text-align:left;'>");
						sb.append(ws.getString(7));			
						sb.append("</td>");
						
															
						sb.append("</tr>");
					i++;
				}

				sb.append("</table> ");
				sb.append("</div>");
				sb.append("</div>");
			} else {
				sb.append("<div class='row'>");
				sb.append("<div class='col-md-12'>");
				sb.append("<table class='table' style='font-weight:350 !important ;font-size: 16px !important;'>");
				sb.append("<tr>");
				sb.append(
						"<td colspan='5' align='center' style='font-weight:350 !important ;font-size: 16px !important;color:red;'>"
								+ "No Record Found" + "</td>");
				sb.append("</tr>");
				sb.append("</table> ");
				sb.append("</div>");
				sb.append("</div>");
				sb.append("</div>");
			}
		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Local Purchase Report", "BreakageItemDtlTransHLP.getBreakageDetails()-->",
					e.getMessage());
		}
		// System.out.println("sb"+sb);
		return sb.toString();
	}

	public static String getIssuedDetailNEW(WebRowSet wb) throws SQLException {
		StringBuffer br = new StringBuffer();
		String strIssueDate = "";
		String strIssueNo = "";
		String strIndentingStore = "";
		String strIndentNo = "";
		String strIndentDate = "";

		int i = 0;

		try {
			br.append("<div class='row'>");
			br.append("<table class='table'>");
			br.append("<tr>");
			br.append("<td colspan='2'>");
			br.append(
					"<div id='' style='font-weight:350 !important ;font-size: 16px !important;'>&nbsp;Issue Details </div>");
			br.append("</td></tr></table>");
			br.append("</div>");

			br.append("<div class='row'>");
			br.append("<div class='col-md-12'>");
			br.append("<table class='table text-uppercase' align='center'>");
			br.append("<tr>");
			br.append("<thead class='thead-dark'>");
			br.append(
					"<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Drug Name</td>");
			br.append(
					"<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Issue/Return Qty</td>");
			br.append(
					"<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Rate/Unit</td>");
			br.append(
					"<td  WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Cost</td>");
			br.append("</thead>");
			br.append("</tr>");

			if (wb.size() != 0) {

				while (wb.next()) {
					strIssueDate = wb.getString(2);
					strIssueNo = wb.getString(1);
					strIndentingStore = wb.getString(3);
					strIndentNo = wb.getString(4);
					strIndentDate = wb.getString(5);

					br.append("<input type='hidden' name='strHlpIssueNo' id='strHlpIssueNo" + i + "' value="
							+ strIssueNo + " />");
					br.append("<input type='hidden' name='strHlpIndentNo' id='strHlpIndentNo" + i + "' value="
							+ strIndentNo + " />");
					br.append("<input type='hidden' name='strHlpIndentDate' id='strHlpIndentDate" + i + "' value="
							+ strIndentDate + " />");

					br.append("<tr>");
					br.append(
							"<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"
									+ strIssueDate + "</td>");
					br.append("<td WIDTH='20%' align='center'>");
					br.append("<input type='hidden' name='flag' id='flag" + i + "' value=" + "0" + " />");
					br.append("<div class='popup' id='IssueItempopup' style='display: none'></div>");
					br.append(
							"<a align='center' style='cursor:pointer;color:blue;font-weight:350 !important ;font-size:16px;' title='Issue No Item Details' onClick='showPopUp(this,\""
									+ i + "\");'>" + strIssueNo + "</a></td>");
					br.append("</td>");
					br.append(
							"<td WIDTH='20%' align='left'   style='font-weight:350 !important ;font-size: 16px !important;' >"
									+ strIndentingStore + "</td>");
					br.append(
							"<td WIDTH='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"
									+ strIndentNo + "</td>");
					br.append(
							"<td WIDTH='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"
									+ strIndentDate + "</td>");
					br.append(
							"<td WIDTH='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' ><img src='../../hisglobal/images/search_icon1.gif' onclick='generateIssueReportFunc(this,\""
									+ i + "\");' style='cursor: pointer;' title='Print Issue Item Details'></td>");
					br.append("</tr>");
					i++;
				}

				br.append("</table> ");
				br.append("</div>");
				br.append("</div>");
			} else {
				br.append("<div class='row'>");
				br.append("<div class='col-md-12'>");
				br.append("<table class='table' style='font-weight:350 !important ;font-size: 16px !important;'>");
				br.append("<tr>");
				br.append(
						"<td colspan='5' align='center' style='font-weight:350 !important ;font-size: 16px !important;color:red;'>"
								+ "No Record Found" + "</td>");
				br.append("</tr>");
				br.append("</table> ");
				br.append("</div>");
				br.append("</div>");
				br.append("</div>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
		return br.toString();
	}

	
	
public static String getAfterSaveVoucher(PatientReturnTransVO vo, String mode) throws Exception {
StringBuffer sb = new StringBuffer("");
int i = 1;
WebRowSet ws = null;
String strCurrentDate ="";
double dis, markedprice, salePrice, per;
float NetAmount = 0.0F;

try {
	 HisUtil hisUtil = new HisUtil("Global", "ReportUtil");
        
     strCurrentDate = hisUtil.getASDate("dd-MMM-yyyy hh:mm"); 

     HospitalMstVO hospitalVO = hisUtil.getHospitalDetail(vo.getStrHospitalCode());
			
 sb.append("<table class='invoice-table-header-dtls' style='width:100%; font-size: 14px;'>");
    
 sb.append("<tr>")
        .append("<td colspan='12' style='text-align: right;'>")
        .append("<div id='printImg' style='display: inline-block;'>")
        .append("<img style='cursor: pointer; margin-right: 5px;' title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onclick='printData();' />")
        .append("<img style='cursor: pointer;' title='Close Page' src='../../hisglobal/images/stop.png' onclick='hideIssuePopup();' />")
        .append("</div>")
        .append("</td>")
    .append("</tr>");

    sb.append("<tr>");
        sb.append("<td style='width:20%;'></td>");  
        sb.append("<td style='width:60%; text-align:center;'>");  
        sb.append("<b>");
        sb.append(hospitalVO.getHospitalName());
        sb.append("</b></td>");
        sb.append("<td style='width:20%;'></td>");  
    sb.append("</tr>");

    sb.append("<tr>");
        sb.append("<td style='width:20%;'></td>");  
        sb.append("<td style='width:60%; text-align:center; font-size: 12px; font-weight:normal;'>");
        sb.append("<b>");
        sb.append(((hospitalVO.getAddress1() == "" || hospitalVO.getAddress1() == null) ? " "
                : (hospitalVO.getAddress1() + ",")) +
                ((hospitalVO.getAddress2() == "" || hospitalVO.getAddress2() == null) ? " "
                : (hospitalVO.getAddress2() + ",")) +
                ((hospitalVO.getCity() == "" || hospitalVO.getCity() == null) ? " "
                : (hospitalVO.getCity() + ",")) +
                ((hospitalVO.getPinCode() == "" || hospitalVO.getPinCode() == null) ? " "
                : (hospitalVO.getPinCode())));
        sb.append("</b></td>");
        sb.append("<td style='width:20%;'></td>");  

    sb.append("</tr>");

    sb.append("<tr>");
        sb.append("<td style='width:20%;'></td>");  
        sb.append("<td style='width:60%; text-align:center;'>");
        sb.append("<b>");
        sb.append("Return Invoice</b>");
        sb.append("</td>");
        sb.append("<td style='width:20%;'></td>");  
    sb.append("</tr>");
    
    sb.append("<tr>");
        sb.append("<td style='width:20%;'></td>");  
        sb.append("<td style='width:60%; text-align:center; font-size: 12px;'>");
        sb.append("Print Date & Time: <b>").append(strCurrentDate).append("</b>");
        sb.append("</td>");
        sb.append("<td style='width:20%;'></td>");  
    sb.append("</tr>");
    
sb.append("</table>");

sb.append("<table class='invoice-table-header-dtls' style='width:100%; font-size: 12px; line-height: 1; border-spacing: 0;' align='center' cellpadding='1' cellspacing='1'>")

//Return Number and Return Date
.append("<tr><td style='width:25%; text-align:right; padding:2px;'><strong>Return No:</strong></td>")
.append("<td style='width:25%; padding:2px;'>").append(vo.getStrReturnNo()).append("</td>")
.append("<td style='width:25%; text-align:right; padding:2px;'><strong>Return Date:</strong></td>")
.append("<td style='width:25%; padding:2px;'>").append(vo.getStrReturnDate()).append("</td></tr>")

//CR and Store 
.append("<tr><td style='width:25%; text-align:right; padding:2px;'><strong>CR No:</strong></td>")
.append("<td style='width:25%; padding:2px;'>").append(vo.getStrCrNo()).append("</td>")
.append("<td style='width:25%; text-align:right; padding:2px;'><strong>Return To(Store):</strong></td>")
.append("<td style='width:25%; padding:2px;'>").append(vo.getStrStoreName()).append("</td></tr>")

.append("</table>");

sb.append("<hr style='margin-top: 0rem; border-top: 1px solid rgb(0, 0, 0); border-block-style: dashed;'>");

//Construct Patient Details table with the same reduced spacing
sb.append("<table class='invoice-table-header-dtls' style='width:100%; font-size: 12px; line-height: 1; border-spacing: 0;' align='center' cellpadding='1' cellspacing='1'>")
.append("<tr><td style='text-align:center; padding:2px;'>").append(vo.getStrPatientDtl()).append("</td></tr>")
.append("</table>");

sb.append("<table class='invoice-table' style='font-size: 12px;'>");
sb.append("<thead><tr>");
sb.append("<th width='2%'>S.No.</th>");
sb.append("<th width='35%'>Product</th>");
sb.append("<th width='15%'>Batch</th>");
sb.append("<th width='10%'>Expiry</th>");
sb.append("<th width='8%'>Qty</th>");
sb.append("<th width='5%'>MRP</th>");
sb.append("<th width='10%'>Rate</th>");
sb.append("<th width='5%'>Disc(%)</th>");
sb.append("<th width='10%'>Cost</th>");
sb.append("</tr></thead>");

ws = vo.getWsIssueDetails();

if (ws != null && ws.size() > 0) {
	while (ws.next()) {
		markedprice = Double.parseDouble(ws.getString(29));
		salePrice = Double.parseDouble(ws.getString(16));
		if (markedprice == 0) {
		    dis = 0;  
		    per = 0;  
		} else {
		    dis = markedprice - salePrice;
		    per = (dis / markedprice) * 100;
		}
					sb.append("<tr style='font-size: 12px;'> ");
					sb.append("<td 	style='text-align:center;' width='2%'>");//SNo
					sb.append(i);
					sb.append("</td> ");
					sb.append("<td 	style='text-align:left;'   width='35%'>"); // Product
					sb.append(ws.getString(6));
					sb.append("</td> ");
					sb.append("<td 	style='text-align:center;' width='15%'>"); // Batch
					sb.append(ws.getString(7));
					sb.append("</td> ");
					sb.append("<td style='text-align:center;' width='10%'>"); // Expiry
					sb.append(ws.getString(8));
					sb.append("</td> ");
					sb.append("<td style='text-align:center;' width='8%'>"); // Qty
					sb.append(ws.getString(10));
					sb.append("</td> ");
					sb.append("<td style='text-align:center;' width='5%'>"); // MRP
					sb.append(ws.getString(29));
					sb.append("</td> ");
					sb.append("<td style='text-align:center;' width='10%'>"); // Rate
					sb.append(ws.getString(16));
					sb.append("</td> ");
					sb.append("<td style='text-align:center;' width='5%'>"); // Disc %
					sb.append(Math.round(per));
					sb.append("</td> ");
					sb.append("<td style='text-align:center;' width='10%'>"); // Cost
					sb.append(ws.getString(30));
					sb.append("</td> ");
					sb.append("</tr> ");
					
					//		NetAmount = NetAmount + Float.parseFloat(ws.getString(30));
					String strNetAmount = ws.getString(30);
					if (strNetAmount != null && !strNetAmount.isEmpty()) {
					    NetAmount = NetAmount + Float.parseFloat(strNetAmount);
					} else {
					    // Handle the case where the value is null or empty
					    NetAmount = NetAmount + 0.0f;  // or decide on another default value
					}

					i++;
	}

/*sb.append("<tr><td colspan='9'>"
			+ "<hr size='1' style='margin-top: 0rem;border-top: 1px solid rgb(0, 0, 0);border-block-style: dashed;'>"
			+ "</td></tr>");*/	
				
sb.append("<tr>");
sb.append("<td colspan='8' style='text-align:right;'><font face='Verdana, Arial, Helvetica, sans-serif' style='font-size: 11px;'><b>GRAND TOTAL</b></font></td>");
sb.append("<td colspan='1' style='font-weight: bold;text-align:center;'><font face='Verdana, Arial, Helvetica, sans-serif' style='font-size: 11px;'>");
sb.append(Math.round(NetAmount));
sb.append("</font></td>");
sb.append("</tr>");

} else {
	
	sb.append("<tr>");
    sb.append("<td colspan='12' style='text-align: center; padding:20px; color: red;'>No Records Found</td>");
    sb.append("</tr>");
}
sb.append("</table> ");

sb.append("<br><br>");

sb.append("<table style='width:100%; >");
if(vo.getStrHospitalCode().equals("10811"))	
{
	sb.append("<tr>");
	sb.append("<td colspan='6' style='text-align:left;'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></u></td>");
	sb.append("<td colspan='6' style='text-align:right;'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>FOR I.G.I.M.S CENTRAL PHARMACY</font></td>");					
	sb.append("</tr>");
}
else
{
	sb.append("<tr>");
	sb.append("<td colspan='12' style='text-align:left;'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></u></td>");
	sb.append("</tr>");
}

sb.append("<tr>");
sb.append("<td colspan='12' style='text-align:left;'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Any unused medicine must be returned prior to discharge.</font></td>");
sb.append("</tr>");	

sb.append("<tr>");
sb.append("<td colspan='6' style='text-align:left;'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>User: " + vo.getStrUserName() + "</font></td>");
sb.append("<td colspan='6' style='text-align:right;'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Authorised Signatory</font></td>");	
sb.append("</tr>");

sb.append("<tr>");
sb.append("<td colspan='12' style='text-align:left;'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>User Sign</font></td>");	
sb.append("</tr>");
sb.append("</table>");

	
} catch (Exception var16) {
	var16.printStackTrace();
	throw var16;
} finally {
	if (ws != null) {
		ws.close();
		ws = null;
	}
}
	return sb.toString();
}

}
