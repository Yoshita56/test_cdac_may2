/**
 * 
 */
package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;





import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.PODeskGenerateTransBO;
import mms.transactions.controller.fb.PODeskGenerateTransFB;
import mms.transactions.vo.PODeskGenerateTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskGenerateTransHLP {

	public static String getRequestDetails(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {
		String strHLPString = null;
		try {
			if (_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("21")
					|| _poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("25")
					|| _poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("26")
					|| _poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("27") || _poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("87"))//87 is for LPO Purchase
				strHLPString = getLPRequestDetails(_poDeskGenerateTransFB);
			else if (_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("23")
					|| _poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("24"))
				strHLPString = getImpContiRequestDetails(_poDeskGenerateTransFB);
			else if (_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("22") )
				strHLPString = getAnnualRequestDetails(_poDeskGenerateTransFB);
		} catch (Exception _e) {
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getRequestDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return strHLPString;
	}
	
	public static String getRequestDetailsBS(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {
		String strHLPString = null;
		try {
			if (_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("21")
					|| _poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("25")
					|| _poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("26")
					|| _poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("27") || _poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("87"))//87 is for LPO Purchase
				strHLPString = getLPRequestDetailsBS(_poDeskGenerateTransFB);
			else if (_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("23")
					|| _poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("24"))
				strHLPString = getImpContiRequestDetails(_poDeskGenerateTransFB);
			else if (_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("22") )
				strHLPString = getAnnualRequestDetailsBS(_poDeskGenerateTransFB);
		} catch (Exception _e) {
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getRequestDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return strHLPString;
	}

	public static String getLPRequestDetails(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wb = null;
		try {
			wb = _poDeskGenerateTransFB.getWbRequestDetail();
			if (wb.size() != 0) {
				br.append("<table class='TABLEWIDTH' bgcolor='black' border='0'  align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='5%' class='multiLabel'><input type='checkbox' name='strCheckAll' onclick='checkAll();'>");
				br.append("</td><td width='15%' class='multiLabel'>Indent No.");
				br.append("</td><td width='15%' class='multiLabel'>Indent Date");
			//	br.append("</td><td width='15%' class='multiLabel'>Indent Type");
				br.append("</td><td width='15%' class='multiLabel'>Raising Store");
				if(_poDeskGenerateTransFB.getStrPOTypeId().equals("87"))
				{
					br.append("</td><td width='15%' class='multiLabel'>CR No.");
					br.append("</td><td width='20%' class='multiLabel'>Patient Name");
				}
				br.append("</td><td width='15%' class='multiLabel'>No. of Items");
				br.append("</td></tr>");
				br.append("</table>");
				br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' border='0'  align='center' cellspacing='1px'>");
				int nTmpI = 0;
				while (wb.next()) {
					br.append("<tr>");
					br.append("<td width='5%' class='multiControl'>");

					br
							.append("<input type='hidden' name='strDRequestNo' value='"
									+ wb.getString(1) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRaisingStore' value='"
									+ wb.getString(2) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestDate' value='"
									+ wb.getString(3) + "' disabled=true>");
					br.append("<input type='hidden' name='strDCRNo' value='"
							+ wb.getString(7) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestType' value='"
									+ wb.getString(5) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestPeriod' value='' disabled=true>");

					br
							.append("<input type='checkbox' name='strCheckBox' onclick='checkData(this);' value='");
					br.append(wb.getString(1) + "^" + wb.getString(2) + "^"
							+ wb.getString(3) + "^" + wb.getString(5) + "^"
							+ wb.getString(7) + "^/");
					br.append("'>");

					br.append("</td><td width='15%' class='multiControl'><a STYLE='CURSOR:POINTER;color:blue' onclick='getIndentDetails("+ wb.getString(1) +","+wb.getString(2)+");'>");
					br.append(wb.getString(1));
					br.append("</a></td><td width='15%' class='multiControl'>");
					br.append(wb.getString(3));
//					br.append("</td><td width='15%' class='multiControl'>");
//					br.append(wb.getString(6));
					br.append("</td><td width='15%' class='multiControl'>");
					br.append(wb.getString(4));
					if(_poDeskGenerateTransFB.getStrPOTypeId().equals("87"))
					{
						br.append("</td><td width='15%' class='multiControl'>");
						br.append(wb.getString(7));
						br.append("</td><td width='20%' class='multiControl'>");
						br.append(wb.getString(8));
					}
					br.append("</td><td width='15%' class='multiControl'>");
					br.append(wb.getString(9));
					br.append("</td></tr>");
					nTmpI++;
				}
				br.append("</table>");
			} else {
				br.append("<DIV class='alert alert-danger' align='center'> NO RECORD FOUND FOR SELECTED STORE NAME OR ITEM CATEGORY </div>");


			}
		} catch (Exception _e) {
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getLPRequestDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	public static String getLPRequestDetailsBS(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wb = null;
		try {
			wb = _poDeskGenerateTransFB.getWbRequestDetail();
			if (wb.size() != 0) {
				br.append("<table class='table'>");
				br.append("<thead>");
				br.append("<tr>");
				br.append("<th><input type='checkbox' name='strCheckAll' onclick='checkAll();'>");
				
				br.append("</th><th>Indent No.");
				br.append("</th><th>Indent Date");
			//	br.append("</th><th width='15%' class='multiLabel'>Indent Type");
				br.append("</th><th>Raising Store");
				if(_poDeskGenerateTransFB.getStrPOTypeId().equals("87"))
				{
					br.append("</th><th>CR No.");
					br.append("</th><th>Patient Name");
				}
				br.append("</th><th>No. of Items");
				br.append("</th></thead>");
				
				br.append("<tbody>");
				int nTmpI = 0;
				while (wb.next()) {
					br.append("<tr>");
					br.append("<td>");

					br
							.append("<input type='hidden' name='strDRequestNo' value='"
									+ wb.getString(1) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRaisingStore' value='"
									+ wb.getString(2) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestDate' value='"
									+ wb.getString(3) + "' disabled=true>");
					br.append("<input type='hidden' name='strDCRNo' value='"
							+ wb.getString(7) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestType' value='"
									+ wb.getString(5) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestPeriod' value='' disabled=true>");

					br
							.append("<input type='checkbox' name='strCheckBox' onclick='checkData(this);' value='");
					br.append(wb.getString(1) + "^" + wb.getString(2) + "^"
							+ wb.getString(3) + "^" + wb.getString(5) + "^"
							+ wb.getString(7) + "^/");
					br.append("'>");

					br.append("</td><td><a class='btn btn-info viewbill' data-toggle='modal' data-target='#tariffDtlsModal' onclick='getIndentDetails("+ wb.getString(1) +","+wb.getString(2)+");'>");
					br.append(wb.getString(1));
					br.append("</a></td><td>");
					br.append(wb.getString(3));
//					br.append("</td><td width='15%' class='multiControl'>");
//					br.append(wb.getString(6));
					br.append("</td><td>");
					br.append(wb.getString(4));
					if(_poDeskGenerateTransFB.getStrPOTypeId().equals("87"))
					{
						br.append("</td><td>");
						br.append(wb.getString(7));
						br.append("</td><td>");
						br.append(wb.getString(8));
					}
					br.append("</td><td>");
					br.append(wb.getString(9));
					br.append("</td></tr>");
					nTmpI++;
				}
				br.append("</tbody>");
				br.append("</table>");
			} else {
				
				br.append("<DIV class='alert alert-danger' align='center'> NO RECORD FOUND FOR SELECTED STORE NAME OR ITEM CATEGORY </div>");

			

			}
		} catch (Exception _e) {
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getLPRequestDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}

	public static String getImpContiRequestDetails(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wb = null;
		try {
			wb = _poDeskGenerateTransFB.getWbRequestDetail();
			if (wb.size() != 0) {
				br.append("<table class='TABLEWIDTH' bgcolor='black' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='5%' class='multiLabel'><input type='checkbox' name='strCheckAll' onclick='checkAll();'>");
				br.append("</td><td width='35%' class='multiLabel'>Indent No.");
				br.append("</td><td width='25%' class='multiLabel'>Indent Date");
				br.append("</td><td width='15%' class='multiLabel'>Indent Type");
				br.append("</td><td width='20%' class='multiLabel'>Raising Store");
				br.append("</td></tr>");
				
				br.append("</table>");
				br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'>");
				int nTmpI = 0;
				while (wb.next()) {
					br.append("<tr>");
					br.append("<td width='5%' class='multiControl'>");

					br.append("<input type='hidden' name='strDRequestNo' value='"
									+ wb.getString(1) + "' disabled=true>");
					br.append("<input type='hidden' name='strDRaisingStore' value='"
									+ wb.getString(2) + "' disabled=true>");
					br.append("<input type='hidden' name='strDRequestDate' value='"
									+ wb.getString(3) + "' disabled=true>");
					br.append("<input type='hidden' name='strDCRNo' value='' disabled=true>");
					br.append("<input type='hidden' name='strDRequestType' value='"
									+ wb.getString(5) + "' disabled=true>");
					br.append("<input type='hidden' name='strDRequestPeriod' value='' disabled=true>");

					br.append("<input type='checkbox' name='strCheckBox' onclick='checkData(this);' value='");
					br.append(wb.getString(1) + "^" + wb.getString(2) + "^"
							+ wb.getString(3) + "^/^" + wb.getString(5) + "^/");
					br.append("'>");

					br.append("</td><td width='35%' class='multiControl'>");
					br.append(wb.getString(1));
					br.append("</td><td width='25%' class='multiControl'>");
					br.append(wb.getString(3));
					br.append("</td><td width='15%' class='multiControl'>");
					br.append(wb.getString(6));
					br.append("</td><td width='20%' class='multiControl'>");
					br.append(wb.getString(4));
					br.append("</td></tr>");
					nTmpI++;
				}
				br.append("</table>");
			} else {
				br.append("<DIV class='alert alert-danger' align='center'> NO RECORD FOUND FOR SELECTED STORE NAME OR ITEM CATEGORY </div>");

			}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getImpContiRequestDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	public static String getAnnualRequestDetailsBS(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wb = null;
		try {
			wb = _poDeskGenerateTransFB.getWbRequestDetail();
			if (wb.size() != 0) {
				br.append("<table class='table'>");
				br.append("<thead>");
				br.append("<tr>");
				br.append("<th><input type='checkbox' name='strCheckAll' onclick='checkAll();'>");
				br.append("</th><th>Indent No.");
				br.append("</th><th>Indent Date");
				br.append("</th><th>Indent Type");
				br.append("</th><th >Indenting Store");
				br.append("</th><th>No. of Items");
		        br.append("</th></tr>");
				br.append("</thead>");
				br.append("<tbody>");//#CC9966 replaced with #6097BC
				int nTmpI = 0;
				while (wb.next()) {
					br.append("<tr>");
					br.append("<td>");

					br
							.append("<input type='hidden' name='strDRequestNo' value='"
									+ wb.getString(1) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRaisingStore' value='"
									+ wb.getString(2) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestDate' value='"
									+ wb.getString(3) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDCRNo' value='' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestType' value='"
									+ wb.getString(6) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestPeriod' value='"
									+ wb.getString(4) + "' disabled=true>");

					br
							.append("<input type='checkbox' name='strCheckBox' onclick='checkData(this);' value='");
					br.append(wb.getString(1) + "^" + wb.getString(2) + "^"
							+ wb.getString(3) + "^/^" + wb.getString(6) + "^"
							+ wb.getString(4));
					br.append("'>");

					br.append("</td><td><a class='btn btn-info viewbill' data-toggle=\"modal\" data-target=\"#tariffDtlsModal\"  STYLE='width: 43%;' onclick='getIndentDetails("+ wb.getString(1) +","+wb.getString(2)+");'>");
					br.append(wb.getString(1));
					br.append("</a></td><td>");
					br.append(wb.getString(3));
					br.append("</td><td>");
					br.append(wb.getString(6));
					//br.append("</td><td width='20%' class='multiControl'>");
				//	br.append(wb.getString(8));
					br.append("</td><td>");
					br.append(wb.getString(4));
					br.append("</td><td>");
					br.append(wb.getString(9));
					br.append("</td></tr>");
					nTmpI++;
				}
				br.append("</tbody></table>");
			} else {
				br.append("<DIV class='alert alert-danger' align='center'> NO RECORD FOUND FOR SELECTED STORE NAME OR ITEM CATEGORY </div>");

			}
		} catch (Exception _e) {
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getAnnualRequestDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	public static String getAnnualRequestDetails(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wb = null;
		try {
			wb = _poDeskGenerateTransFB.getWbRequestDetail();
			if (wb.size() != 0) {
				br
						.append("<table class='TABLEWIDTH' bgcolor='black' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br
						.append("<td width='5%' class='multiLabel'><input type='checkbox' name='strCheckAll' onclick='checkAll();'>");
				br.append("</td><td width='15%' class='multiLabel'>Indent No.");
				br
						.append("</td><td width='15%' class='multiLabel'>Indent Date");
				br
						.append("</td><td width='15%' class='multiLabel'>Indent Type");
				//br
				//		.append("</td><td width='20%' class='multiLabel'>Agenda Period");
				br
						.append("</td><td width='20%' class='multiLabel'>Indenting Store");
				//br.append("</td></tr>");
				br
				.append("</td><td width='10%' class='multiLabel'>No. of Items");
		br.append("</td></tr>");
				br.append("</table>");
				br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'>");//#CC9966 replaced with #6097BC
				int nTmpI = 0;
				while (wb.next()) {
					br.append("<tr>");
					br.append("<td width='5%' class='multiControl'>");

					br
							.append("<input type='hidden' name='strDRequestNo' value='"
									+ wb.getString(1) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRaisingStore' value='"
									+ wb.getString(2) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestDate' value='"
									+ wb.getString(3) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDCRNo' value='' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestType' value='"
									+ wb.getString(6) + "' disabled=true>");
					br
							.append("<input type='hidden' name='strDRequestPeriod' value='"
									+ wb.getString(4) + "' disabled=true>");

					br
							.append("<input type='checkbox' name='strCheckBox' onclick='checkData(this);' value='");
					br.append(wb.getString(1) + "^" + wb.getString(2) + "^"
							+ wb.getString(3) + "^/^" + wb.getString(6) + "^"
							+ wb.getString(4));
					br.append("'>");

					br.append("</td><td class='multiControl' width='15%'><a STYLE='CURSOR:POINTER;color:blue' onclick='getIndentDetails("+ wb.getString(1) +","+wb.getString(2)+");'>");
					br.append(wb.getString(1));
					br.append("</a></td><td width='15%' class='multiControl'>");
					br.append(wb.getString(3));
					br.append("</td><td width='15%' class='multiControl'>");
					br.append(wb.getString(6));
					//br.append("</td><td width='20%' class='multiControl'>");
				//	br.append(wb.getString(8));
					br.append("</td><td width='20%' class='multiControl'>");
					br.append(wb.getString(4));
					br.append("</td><td width='10%' class='multiControl'>");
					br.append(wb.getString(9));
					br.append("</td></tr>");
					nTmpI++;
				}
				br.append("</table>");
			} else {
				br.append("<DIV class='alert alert-danger' align='center'> NO RECORD FOUND FOR SELECTED STORE NAME OR ITEM CATEGORY </div>");

			}
		} catch (Exception _e) {
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getAnnualRequestDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	public static String getRequestItemDetails(	PODeskGenerateTransFB _poDeskGenerateTransFB)
	{

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		String strDivId = "";
		String strReqNo="";
		String strStores="";
		double tot=0.0,ratewidtax=0.0;;
		try 
		{
			System.out.println("--------------- PODeskGenerateTransHLP.getRequestItemDetails -------------------");
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			int nTmpI = 0;
			for (int nTmpJ = 0; nTmpJ < _poDeskGenerateTransFB
					.getStrRequestIds().replace("^", "#").split("#").length; nTmpJ++) 
			{
				strDivId = _poDeskGenerateTransFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ];
				if(strReqNo.equals(""))
				{
					strReqNo = _poDeskGenerateTransFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ];
				}
				else
				{
					strReqNo = strReqNo+","+_poDeskGenerateTransFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ];
				}
				
				if(strStores.equals(""))
				{
					strStores = _poDeskGenerateTransFB.getStrCheckData().replace("~", "#").split("#")[nTmpJ].replace("^", "#").split("#")[1];
				}
				else
				{
					strStores = strStores+","+_poDeskGenerateTransFB.getStrCheckData().replace("~", "#").split("#")[nTmpJ].replace("^", "#").split("#")[1];
				}
			}
			

				poDeskGenerateTransVO.setStrItemCat(_poDeskGenerateTransFB.getStrItemCat());
				poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());
				//poDeskGenerateTransVO.setStrRequestId(_poDeskGenerateTransFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ]);
				poDeskGenerateTransVO.setStrRequestId(strReqNo);
				poDeskGenerateTransVO.setStrSupplierId(_poDeskGenerateTransFB.getStrSupplierId().replace("^", "#").split("#")[0]);
				//System.out.println("_poDeskGenerateTransFB.getStrSupplierId().replace(^, #).split(#)[0]"+_poDeskGenerateTransFB.getStrSupplierId().replace("^", "#").split("#")[0]);
				//poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrCheckData().replace("~", "#").split("#")[nTmpJ].replace("^", "#").split("#")[1]);
				poDeskGenerateTransVO.setStrStoreId(strStores);
				poDeskGenerateTransVO.setStrContractType(_poDeskGenerateTransFB.getStrContractType());
				poDeskGenerateTransVO.setStrPOTypeId(_poDeskGenerateTransFB.getStrPOTypeId());

				poDeskGenerateTransBO.getRequestItemDetails(poDeskGenerateTransVO);

				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());

				_poDeskGenerateTransFB.setWbRequestItemDetail(poDeskGenerateTransVO.getWbRequestItemDetail());

				wb = _poDeskGenerateTransFB.getWbRequestItemDetail();
				
				if (wb.size() != 0) 
				{
					
					br.append("<div id="
							+ strReqNo.split(",")[nTmpI] + ">");
					br.append("<table class='TABLEWIDTH' bgcolor='black' align='center' cellspacing='1px'>");
					br.append("<tr>");
					//br.append("<td width='5%' class='multiLabel'><a onClick='selectAll()'>#</a>");
					br.append("<td width='5%' class='multiLabel'><input type='checkbox' name='strCheckAll' onclick='selectAll();'></a>");
					br.append("<td width='5%' class='multiLabel'>S.No.");
					br.append("</td><td width='20%' class='multiLabel'>Item Name");
					br.append("</td><td width='8%' class='multiLabel'>Total Qty");
					br.append("</td><td width='20%' class='multiLabel'><font color='red'>*</font>Supplier");
					br.append("</td><td width='6%' class='multiLabel'><font color='red'>*</font>Pack Size");
					br.append("</td><td width='6%' class='multiLabel'><font color='red'>*</font>Qty");
					br.append("</td><td width='5%' class='multiLabel'><font color='red'>*</font>Unit");
					br.append("</td><td width='6%' class='multiLabel'>Rate/Unit");
					br.append("</td><td width='6%' class='multiLabel'>Tax(%)");
					br.append("</td><td width='10%' class='multiLabel'><font color='red'>*</font>Total Cost");
					//if(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("22"))
					br.append("</td><td width='10%' class='multiLabel'><font color='red'>*</font>MRP");
					//br.append("</td><td width='8%' class='multiLabel'>Shelf Life");
					//br.append("</td><td width='10%' class='multiLabel'>");
					br.append("</td></tr>");
					
					br.append("</table>");
					
					
					while (wb.next()) 
					{
						br.append("<div id ='divIddd"+wb.getString(2)+"'><table class='TABLEWIDTH' id = 'divId"+wb.getString(2)+"'  bgcolor='#6097BC' align='center' cellspacing='1px'>");
						br.append("<tr>");
						br.append("<td width='5%' class='multiControl'>");
						br.append("<input type='checkbox' onclick='checkItem(this);' name='strCheckBoxItem' id ='CHK"+wb.getString(2)+""+0+"' value='"+strReqNo+"'>");
						br.append("<input type='hidden' name='strTmpReqNo' value='"
								+ strDivId + "' disabled=true>");
						br.append("<input type='hidden' name='strTmpBaseValue' value='"
								+ wb.getString(13) + "' disabled=true>");
						br.append("<input type='hidden' id='BQTY"+wb.getString(2)+"' name='strTmpBalQty' value='"
								+ wb.getString(9).replace(" ", "#").split("#")[0] + "' disabled=true>");
						br.append("<input type='hidden' name='strTmpRaisingStore' value='"+ strStores + "' disabled=true>");//+ strStores.replace(",", "#").split("#")[nTmpI] + "' disabled=true>");
						br.append("<input type='hidden' name='strDitemId' value='"	+ wb.getString(1) + "' disabled=true>");
						br.append("<input type='hidden' name='strDitemBrandId' value='"	+ wb.getString(2) + "' disabled=true>");

						br.append("<input type='hidden' name='strDGroupId' value='"	+ wb.getString(4) + "' disabled=true>");
						br.append("<input type='hidden' name='strDSubGroupId' value='"	+ wb.getString(5) + "' disabled=true>");
						br.append("<input type='hidden' name='strDSanctionQty' value='"	+ wb.getString(9).replace(" ", "#").split("#")[0]
										+ "' disabled=true>");
						br.append("<input type='hidden' name='strDSanctionQtyUnit' value='"	+ wb.getString(7) + "' disabled=true>");

						br.append("</td><td width='5%' class='multiControl'>"+(nTmpI+1)+"</td><td width='20%' class='multiControl' style=\"text-align:left;\" id='tdstrDitemBrandId"+wb.getString(2)+""+nTmpI+ "'  >");
						br.append(wb.getString(6));
						br.append("</td><td width='8%' class='multiControl' id='tdstrTmpBalQty"+wb.getString(2)+""+nTmpI+ "'><div id='testdiv' >");
						br.append("<a STYLE='CURSOR:POINTER;color:blue' id ='TQTY"+wb.getString(2)+""+0+"' onClick='get_item_details(this,"+nTmpI+");' > ");
						br.append(wb.getString(9));
						br.append("</a></div>");
						 /******* EnD -- Pop-Up Get After Clicking On Balance Qty*********/
						br.append("</td><td width='20%' class='multiControl' id='tdstrDSuppId"+wb.getString(2)+""+nTmpI+ "'>");
						poDeskGenerateTransVO.setStrItemIds(wb.getString(1));
						poDeskGenerateTransVO.setStrItemBrandIds(wb.getString(2));
						poDeskGenerateTransVO.setStrContractType("12");//hardcoded for B&S
						
						/***************************** Supplier Combo ******************************************/
						poDeskGenerateTransBO.setSupplierValuesBasedOnRC(poDeskGenerateTransVO);
						
						System.out.println("hstnum_supplier_id [ 0] @ hstnum_rate [1] @ hstnum_shelf_life [ 2 ] @ hstnum_tax [ 3 ] @ hstnum_supplier_interface_required [ 4 ]@ hststr_pack_size [ 5 ]--"+poDeskGenerateTransVO.getStrSupp());
						/***********************************************************************/
						
						//System.out.println("Supplier Dtls---->>>>"+poDeskGenerateTransVO.getStrSupp()); // 1010017@10.50@365@2.00@0@1 MLX2
						
						
						br.append("<select name=strDSuppId id ='CMBSUP"+wb.getString(2)+""+0+"' class='comboMax' onchange='checkOrderQty(this)'  disabled=true>"		
								+ poDeskGenerateTransVO.getStrSupplierValuesRC()
								+ "</select>");
						br.append("</td><td width='6%' class='multiControl' id='tdstrDPackSize"+wb.getString(2)+""+nTmpI+ "' >");
						br.append("<input type=text class=txtFldMin onkeypress='return validateData(event,9);' value="+poDeskGenerateTransVO.getStrSupp().split("@")[5]+"  autocomplete='off' maxlength=10 name='strDPackSize' id ='PACK"+wb.getString(2)+""+0+"'>");
						br.append("</td><td width='6%' class='multiControl' id='tdstrDOrderQty"+wb.getString(2)+""+nTmpI+ "' >");
						br.append("<input type=text class=txtFldMin disabled=true onkeypress='return validateData(event,5);' value="+wb.getString(9)+" onkeyup='calcTotalRate(this);' autocomplete='off' maxlength=7 name='strDOrderQty' id ='QTY"+wb.getString(2)+""+0+"'>");
						br.append("</td><td width='5%' class='multiControl' id='tdstrDOrderQtyUnitId"+wb.getString(2)+""+nTmpI+ "'>");

						
						poDeskGenerateTransVO.setStrInventoryUnitId(wb.getString(12));
						
						/********** Calling BO Method to Get Unit *************/
						poDeskGenerateTransBO.setUnitValues(poDeskGenerateTransVO);

						br.append("<select name=strDOrderQtyUnitId onchange='checkOrderQty(this)' disabled=true id ='CMBUNIT"+wb.getString(2)+""+0+"'>"
										+ poDeskGenerateTransVO.getStrRateUnitValues()
										+ "</select>");
						br.append("</td><td width='6%' class='multiControl' id='tdstrDRateUnit"+wb.getString(2)+""+nTmpI+ "'>");
						br.append("<input type=text class=txtFldMin onkeypress='return validateData(event,7);' maxlength=7 value="+poDeskGenerateTransVO.getStrSupp().split("@")[1]+" name=strDRateUnit onblur='getTotRate(this)'   id ='RATE"+wb.getString(2)+""+0+"'>");
						br.append("</td><td width='6%' class='multiControl'  id='tdstrDTax"+wb.getString(2)+""+nTmpI+ "'>");
						br.append("<input type=text class=txtFldMin onkeypress='return validateData(event,7);' maxlength=5 name=strDTax name=strDRateUnit  onblur='getTotRate1(this)' value="+poDeskGenerateTransVO.getStrSupp().split("@")[3]+"   id ='TAX"+wb.getString(2)+""+0+"'>");
						br.append("</td><td width='10%' class='multiControl'  id='tdstrDTotalRate"+wb.getString(2)+""+nTmpI+ "'>");
						//ratewidtax= (Math.round(Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1])+((Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[3])*Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1]))/100))*(Double.parseDouble(wb.getString(9).split(" ")[0])*100.0)/100.0);
						ratewidtax = Math.round((((Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1])+((Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1])*Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[3]))/100))*(Double.parseDouble(wb.getString(9).split(" ")[0])))*100.0)/100.0);
						br.append("<input type=text class=txtFldNormal onkeypress='return validateData(event,5);' value="+ratewidtax +"  name=strDTotalRate disabled=true id ='TRATE"+wb.getString(2)+""+0+"'>");
					
						//if(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("22"))
						//{
						String strMRP 		= poDeskGenerateTransVO.getStrSupp().split("@")[1] == null ? wb.getString(2) : poDeskGenerateTransVO.getStrSupp().split("@")[1];
                        System.out.println("Mrp-----"+strMRP);
						
							br.append("</td><td width='10%' class='multiControl'  id='tdstrDMRPCol"+wb.getString(2)+""+nTmpI+ "'>");
							br.append("<input type=text class=txtFldMin  onkeypress='return validateData(event,7);' value='0'  name=strDMRPCol id ='TMRP"+wb.getString(2)+""+0+"'>");
						//}
							nTmpI++;
						br.append("</td></table></div>");
						tot+=ratewidtax;
						
					}
					br.append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr>");
					br.append("<td width='25%' class='LABEL'><div align='right'><b>PO Date</b></div></td><td width='25%' class='CONTROL'> ");
					br.append("<div style='' id='divPODate'>");
					br.append(HisUtil.getDatePicker("strpoDate", _poDeskGenerateTransFB.getStrCurrentDate(), false));
					br.append("</div>");
					//br.append("<div id='divFrmDate' style='display:none;'>");
					//br.append(_poDeskGenerateTransFB.getStrCurrentDate());
					//br.append("</div>");
					br.append("</td>");
					//br.append("<td width='25%' class='LABEL'><div align='right'><b>To Date</b></div></td><td width='25%' class='CONTROL'> ");
					//br.append("<div style='' id='divToDate'>");
					//br.append(HisUtil.getDatePicker("strToDate", _poDeskGenerateTransFB.getStrCurrentDate(), false));
					//br.append("</div>");
					//br.append("<div id='divTDate' style='display:none;'>");
					//br.append(_poDeskGenerateTransFB.getStrCurrentDate());
					//br.append("</div>");
					//br.append("</td>");
					
					br.append("</tr></table>");
					/*if(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("21"))
					{
								br.append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr>");
								br.append("<td width='25%' class='LABEL'><div align='right'><b>From Date</b></div></td><td width='25%' class='CONTROL'> ");
								br.append("<div style='' id='divFromDate'>");
								br.append(HisUtil.getDatePicker("strFromDate", _poDeskGenerateTransFB.getStrCurrentDate(), false));
								br.append("</div>");
								br.append("<div id='divFrmDate' style='display:none;'>");
								br.append(_poDeskGenerateTransFB.getStrCurrentDate());
								br.append("</div>");
								br.append("</td>");
								br.append("<td width='25%' class='LABEL'><div align='right'><b>To Date</b></div></td><td width='25%' class='CONTROL'> ");
								br.append("<div style='' id='divToDate'>");
								br.append(HisUtil.getDatePicker("strToDate", _poDeskGenerateTransFB.getStrCurrentDate(), false));
								br.append("</div>");
								br.append("<div id='divTDate' style='display:none;'>");
								br.append(_poDeskGenerateTransFB.getStrCurrentDate());
								br.append("</div>");
								br.append("</td>");
								
								br.append("</tr></table>");
					
					}
					else
					{
						br.append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr>");
						br.append("<td width='75%' class='CONTROL'>");
						br.append("</td>");
						br.append("<td width='25%' class='CONTROL'>");
						br.append("<div id='divtot' align='right'><b>Total Cost </b>");
						br.append(tot);
						br.append("</div>");
						br.append("</td>");
						br.append("</tr></table>");
						
					}*/
					br.append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr>");
					br.append("<td class='CONTROL' colspan=4>");
					br.append("<div align=center id='compile_btn'><img src='../../hisglobal/images/proceed.png'");
					br.append("style='cursor: pointer; ' title='Save Record'");
					br.append("onClick='compile_supp_wise();' />");
					br.append(" <img src='../../hisglobal/images/btn-ccl.png'");
					br.append("style='cursor: pointer; ' title='Cancel Process'");
					br.append("onClick='cancelToDesk();'></center></div>");
					br.append("</td></tr></table>");
					br.append("</div>");
				} else {
					br.append("<div id="
							+ strReqNo.split("#")[nTmpI] + ">");
					br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
					br.append("<tr>");
					br.append("<td colspan='5'  CLASS='multiControl' ><DIV class='errMsg' align='center'>Either Item is not mapped with store or RC has not been done for Item or Approval required </div></TD>");
					br.append("</tr>");
					br.append("</table>");
					br.append("</div>");
				}
			//}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getIndentDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	
	public static String getRequestItemDetailsBS(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		String strDivId = "";
		String strReqNo="";
		String strStores="";
		double tot=0.0,ratewidtax=0.0;;
		try {
			
			System.out.println("----------- PODeskGenerateTransHLP . getRequestItemDetailsBS -----------");
			
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			int nTmpI = 0;
			for (int nTmpJ = 0; nTmpJ < _poDeskGenerateTransFB
					.getStrRequestIds().replace("^", "#").split("#").length; nTmpJ++) 
			{
				strDivId = _poDeskGenerateTransFB.getStrRequestIds().replace(
						"^", "#").split("#")[nTmpJ];
				if(strReqNo.equals(""))
					strReqNo = _poDeskGenerateTransFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ];
				else
					strReqNo = strReqNo+","+_poDeskGenerateTransFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ];
				
				if(strStores.equals(""))
					strStores = _poDeskGenerateTransFB.getStrCheckData().replace("~", "#").split("#")[nTmpJ].replace("^", "#").split("#")[1];
				else
					strStores = strStores+","+_poDeskGenerateTransFB.getStrCheckData().replace("~", "#").split("#")[nTmpJ].replace("^", "#").split("#")[1];
			}
			

				poDeskGenerateTransVO.setStrItemCat(_poDeskGenerateTransFB.getStrItemCat());
				poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());
				//poDeskGenerateTransVO.setStrRequestId(_poDeskGenerateTransFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ]);
				poDeskGenerateTransVO.setStrRequestId(strReqNo);
				poDeskGenerateTransVO.setStrSupplierId(_poDeskGenerateTransFB.getStrSupplierId().replace("^", "#").split("#")[0]);
				//System.out.println("_poDeskGenerateTransFB.getStrSupplierId().replace(^, #).split(#)[0]"+_poDeskGenerateTransFB.getStrSupplierId().replace("^", "#").split("#")[0]);
				//poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrCheckData().replace("~", "#").split("#")[nTmpJ].replace("^", "#").split("#")[1]);
				poDeskGenerateTransVO.setStrStoreId(strStores);
				poDeskGenerateTransVO.setStrContractType(_poDeskGenerateTransFB.getStrContractType());
				poDeskGenerateTransVO.setStrPOTypeId(_poDeskGenerateTransFB.getStrPOTypeId());
				
				System.out.println("----------- PO TYPE 21 - BULK PO , 22 - LOCAL PO  -----------");
				

				poDeskGenerateTransBO.getRequestItemDetails(poDeskGenerateTransVO);

				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());

				_poDeskGenerateTransFB.setWbRequestItemDetail(poDeskGenerateTransVO.getWbRequestItemDetail());

				wb = _poDeskGenerateTransFB.getWbRequestItemDetail();
				
				if (wb.size() != 0) {
					
					br.append("<div id="
							+ strReqNo.split(",")[nTmpI] + ">");
					br.append("<table class='table'>");
					br.append("<thead>");
					br.append("<tr>");
					br.append("<th><a onClick='selectAll()'>#</a></th>");
					br.append("<th>S.No.");
					br.append("</th><th>Item Name");
					br.append("</th><th>Total Qty");
					br.append("</th><th><font color='red'>*</font>Supplier");
					br.append("</th><th><font color='red'>*</font>Pack Size");
					br.append("</th><th><font color='red'>*</font>Qty");
					br.append("</th><th><font color='red'>*</font>Unit");
					br.append("</th><th>Rate/Unit");
					br.append("</th><th>Tax(%)");
					br.append("</th><th><font color='red'>*</font>Total Cost");
					//if(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("22"))
					br.append("</th><th>MRP");
				
					//br.append("</th><th width='8%' class='multiLabel'>Shelf Life");
					//br.append("</th><th width='10%' class='multiLabel'>");
					br.append("</th></tr></thead>");
					
					System.out.println("----------- PO TYPE 21 - BULK PO , 22 - LOCAL PO  -----------");
					
					
					while (wb.next()) 
					{
						br.append("<tbody  id = 'divId"+wb.getString(2)+"' >");
						br.append("<tr>");
						br.append("<td>");
						br.append("<input type='checkbox' onclick='checkItem(this);' name='strCheckBoxItem' id ='CHK"+wb.getString(2)+""+0+"' value='"+strReqNo+"'>");
						br.append("<input type='hidden' name='strTmpReqNo' 				value='"+ strDivId + "' disabled=true>");
						br.append("<input type='hidden' name='strTmpBaseValue' 			value='"+ wb.getString(13) + "' disabled=true>");
						br.append("<input type='hidden' name='strTmpBalQty'             value='"+ wb.getString(9).replace(" ", "#").split("#")[0] + "' id='BQTY"+wb.getString(2)+"' disabled=true>");
						br.append("<input type='hidden' name='strTmpRaisingStore' 		value='"+ strStores + "' disabled=true>");						
						br.append("<input type='hidden' name='strDitemId' 				value='"+ wb.getString(1) + "' disabled=true>");
						br.append("<input type='hidden' name='strDitemBrandId' 			value='"+ wb.getString(2) + "' disabled=true>");
						br.append("<input type='hidden' name='strDGroupId' 				value='"+ wb.getString(4) + "' disabled=true>");
						br.append("<input type='hidden' name='strDSubGroupId' 			value='"+ wb.getString(5) + "' disabled=true>");
						br.append("<input type='hidden' name='strDSanctionQty' 			value='"+ wb.getString(9).replace(" ", "#").split("#")[0]+ "' disabled=true>");
						br.append("<input type='hidden' name='strDSanctionQtyUnit' 		value='"+ wb.getString(7) + "' disabled=true>");

						br.append("</td><td>"+(nTmpI+1)+"</td><td id='tdstrDitemBrandId"+wb.getString(2)+""+nTmpI+ "'  >");
						br.append(wb.getString(6));
						br.append("</td><td id='tdstrTmpBalQty"+wb.getString(2)+""+nTmpI+ "' style='width:10%;'><div id='testdiv' >");
						br.append("<a class='btn btn-info viewbill' style='width: 100%;' data-toggle='modal' data-target='#tariffDtlsModal1' id ='TQTY"+wb.getString(2)+""+0+"' onClick='get_item_details(this,"+nTmpI+");' > ");
						br.append(wb.getString(9));
						br.append("</a></div>");
						 /******* EnD -- Pop-Up Get After Clicking On Balance Qty*********/
						br.append("</td><td id='tdstrDSuppId"+wb.getString(2)+""+nTmpI+ "'>");
						poDeskGenerateTransVO.setStrItemIds(wb.getString(1));
						poDeskGenerateTransVO.setStrItemBrandIds(wb.getString(2));
						poDeskGenerateTransVO.setStrContractType("12");//hardcoded for B&S
						
						/***************************  SUPP_BASED_RC_DTL **************************/
						poDeskGenerateTransBO.setSupplierValuesBasedOnRC(poDeskGenerateTransVO);
						/************************************************************************/
						br.append("<select name=strDSuppId id ='CMBSUP"+wb.getString(2)+""+0+"' class='browser-default custom-select' onchange='checkOrderQty(this)'  disabled=true>"		
								+ poDeskGenerateTransVO.getStrSupplierValuesRC()
								+ "</select>");
						br.append("</td><td id='tdstrDPackSize"+wb.getString(2)+""+nTmpI+ "' >");
						br.append("<input type=text class='form-control' onkeypress='return validateData(event,9);' value="+poDeskGenerateTransVO.getStrSupp().split("@")[5]+"  autocomplete='off' maxlength=10 name='strDPackSize' id ='PACK"+wb.getString(2)+""+0+"'>");
						br.append("</td><td id='tdstrDOrderQty"+wb.getString(2)+""+nTmpI+ "' >");
						br.append("<input type=text class='form-control' disabled=true onkeypress='return validateData(event,5);' value="+wb.getString(9)+" onkeyup='calcTotalRate(this);' autocomplete='off' maxlength=7 name='strDOrderQty' id ='QTY"+wb.getString(2)+""+0+"'>");
						br.append("</td><td id='tdstrDOrderQtyUnitId"+wb.getString(2)+""+nTmpI+ "'>");

						poDeskGenerateTransVO.setStrInventoryUnitId(wb.getString(12));
						
						/********** Calling BO Method to Get Unit *************/
						poDeskGenerateTransBO.setUnitValues(poDeskGenerateTransVO);

						br.append("<select name=strDOrderQtyUnitId onchange='checkOrderQty(this)' class='browser-default custom-select' disabled=true id ='CMBUNIT"+wb.getString(2)+""+0+"'>"
										+ poDeskGenerateTransVO.getStrRateUnitValues()
										+ "</select>");
						br.append("</td><td id='tdstrDRateUnit"+wb.getString(2)+""+nTmpI+ "'>");
						br.append("<input type=text class='form-control' onkeypress='return validateData(event,7);' maxlength=7 value="+poDeskGenerateTransVO.getStrSupp().split("@")[1]+" name=strDRateUnit onblur='getTotRate(this)'   id ='RATE"+wb.getString(2)+""+0+"'>");
						br.append("</td><td  id='tdstrDTax"+wb.getString(2)+""+nTmpI+ "'>");
						br.append("<input type=text class='form-control' onkeypress='return validateData(event,7);' maxlength=5 name=strDTax name=strDRateUnit  onblur='getTotRate1(this)' value="+poDeskGenerateTransVO.getStrSupp().split("@")[3]+"   id ='TAX"+wb.getString(2)+""+0+"'>");
						br.append("</td><td  id='tdstrDTotalRate"+wb.getString(2)+""+nTmpI+ "'>");
						ratewidtax = Math.round((((Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1])+((Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1])*Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[3]))/100))*(Double.parseDouble(wb.getString(9).split(" ")[0])))*100.0)/100.0);
						br.append("<input type=text class='form-control' onkeypress='return validateData(event,5);' value="+ratewidtax +"  name=strDTotalRate disabled=true id ='TRATE"+wb.getString(2)+""+0+"'>");
						//if(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("22"))
						//{
						String strMRP 		= poDeskGenerateTransVO.getStrSupp().split("@")[1] == null ? wb.getString(2) : poDeskGenerateTransVO.getStrSupp().split("@")[1];
                        System.out.println("Mrp-----"+strMRP);
                        
							br.append("</td><td id='tdstrDMRPCol"+wb.getString(2)+""+nTmpI+ "'>");
							br.append("<input type=text class='form-control'  onkeypress='return validateData(event,7);' value='"+strMRP+"'  name=strDMRPCol id ='TMRP"+wb.getString(2)+""+0+"'>");
						//}
						nTmpI++;
						br.append("</td></tbody>");
						tot+=ratewidtax;
						
					}
					br.append("</table>");
					br.append("<br>");
					br.append("<div class='row'>");
					br.append("<div class='col-sm-2'></div>");
					br.append("<div class='col-sm-2' align='right'><label>PO Date<label></div>");
					br.append("<div class='col-sm-2' ><input id='datepicker' class='form-control' name='strpoDate'></div>");
					br.append("<div class='col-sm-6' id='compile_btn' align='left'>");
					br.append("<button type='button' class='btn btn-info' onClick='compile_supp_wise();'>Proceed</button>");
					br.append("");
					br.append("</div>");
					br.append("</div>");				
					
					br.append("</div>");
				} else {
					br.append("<div id="
							+ strReqNo.split("#")[nTmpI] + ">");
					br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
					br.append("<tr>");
					br.append("<td colspan='5'  CLASS='multiControl' ><DIV class='errMsg' align='center'>Either Item is not mapped with store or RC has not been done for Item or Approval required </div></TD>");
					br.append("</tr>");
					br.append("</table>");
					br.append("</div>");
				}
			//}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getIndentDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	
	public static String getRequestModifyItemDetails(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		String strDivId = "";
		String strReqNo="";
		String strStores="";
		double tot=0.0,ratewidtax=0.0;;
		String PoDate=null;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			int nTmpI = 0;
			/*for (int nTmpJ = 0; nTmpJ < _poDeskGenerateTransFB
					.getStrRequestIds().replace("^", "#").split("#").length; nTmpJ++) {
				strDivId = _poDeskGenerateTransFB.getStrRequestIds().replace(
						"^", "#").split("#")[nTmpJ];
				if(strReqNo.equals(""))
					strReqNo = _poDeskGenerateTransFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ];
				else
					strReqNo = strReqNo+","+_poDeskGenerateTransFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ];
				
				if(strStores.equals(""))
					strStores = _poDeskGenerateTransFB.getStrCheckData().replace("~", "#").split("#")[nTmpJ].replace("^", "#").split("#")[1];
				else
					strStores = strStores+","+_poDeskGenerateTransFB.getStrCheckData().replace("~", "#").split("#")[nTmpJ].replace("^", "#").split("#")[1];
			}*/
			

				poDeskGenerateTransVO.setStrItemCat(_poDeskGenerateTransFB.getStrItemCat());
				poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());
				//poDeskGenerateTransVO.setStrRequestId(_poDeskGenerateTransFB.getStrRequestIds().replace("^", "#").split("#")[nTmpJ]);
				poDeskGenerateTransVO.setStrRequestId(strReqNo);
				poDeskGenerateTransVO.setStrSupplierId(_poDeskGenerateTransFB.getStrSupplierId().replace("^", "#").split("#")[0]);
				//System.out.println("_poDeskGenerateTransFB.getStrSupplierId().replace(^, #).split(#)[0]"+_poDeskGenerateTransFB.getStrSupplierId().replace("^", "#").split("#")[0]);
				//poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrCheckData().replace("~", "#").split("#")[nTmpJ].replace("^", "#").split("#")[1]);
				poDeskGenerateTransVO.setStrStoreId(strStores);
				poDeskGenerateTransVO.setStrContractType(_poDeskGenerateTransFB.getStrContractType());
				poDeskGenerateTransVO.setStrPOTypeId(_poDeskGenerateTransFB.getStrPOTypeId());
				poDeskGenerateTransVO.setStrPoNo(_poDeskGenerateTransFB.getStrPoNo());
				poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrStoreId());
				poDeskGenerateTransBO.getRequestModifyItemDetails(poDeskGenerateTransVO);

				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());

				_poDeskGenerateTransFB.setWbRequestItemDetail(poDeskGenerateTransVO.getWbRequestItemDetail());

				wb = _poDeskGenerateTransFB.getWbRequestItemDetail();
				
				if (wb.size() != 0) {
					
					br.append("<div id="
							+ strReqNo.split(",")[nTmpI] + ">");
					br.append("<table class='TABLEWIDTH' bgcolor='black' align='center' cellspacing='1px'>");
					br.append("<tr>");
					br.append("<td width='5%' class='multiLabel'><a onClick='selectAll()'>#</a>");
					br.append("<td width='5%' class='multiLabel'>S.No.");
					br.append("</td><td width='20%' class='multiLabel'>Item Name[Generic Name]");
					br.append("</td><td width='8%' class='multiLabel'>Total Qty");
					br.append("</td><td width='30%' class='multiLabel'><font color='red'>*</font>Supplier");
					br.append("</td><td width='6%' class='multiLabel'><font color='red'>*</font>Qty");
					br.append("</td><td width='5%' class='multiLabel'><font color='red'>*</font>Unit");
					br.append("</td><td width='6%' class='multiLabel'>Rate/Unit");
					br.append("</td><td width='6%' class='multiLabel'>Tax(%)");
					br.append("</td><td width='10%' class='multiLabel'><font color='red'>*</font>Total Cost");
					//br.append("</td><td width='8%' class='multiLabel'>Shelf Life");
					//br.append("</td><td width='10%' class='multiLabel'>");
					br.append("</td></tr>");
					
					br.append("</table>");
					
					
					while (wb.next()) {
						PoDate=wb.getString(16);
						br.append("<div id ='divIddd"+wb.getString(2)+"'><table class='TABLEWIDTH' id = 'divId"+wb.getString(2)+"'  bgcolor='#6097BC' align='center' cellspacing='1px'>");
						br.append("<tr>");
						br.append("<td width='5%' class='multiControl'>");
						br.append("<input type='checkbox' onclick='checkItem(this);' name='strCheckBoxItem' id ='CHK"+wb.getString(2)+""+0+"' value='"+strReqNo+"'>");
						br.append("<input type='hidden' name='strTmpReqNo' value='"
								+ strDivId + "' disabled=true>");
						br.append("<input type='hidden' name='strTmpBaseValue' value='"
								+ wb.getString(13) + "' disabled=true>");
						br.append("<input type='hidden' id='BQTY"+wb.getString(2)+"' name='strTmpBalQty' value='"
								+ wb.getString(9).replace(" ", "#").split("#")[0] + "' disabled=true>");
						br.append("<input type='hidden' name='strTmpRaisingStore' value='"
								+ strStores + "' disabled=true>");//+ strStores.replace(",", "#").split("#")[nTmpI] + "' disabled=true>");
						br.append("<input type='hidden' name='strDitemId' value='"
										+ wb.getString(1) + "' disabled=true>");
						br.append("<input type='hidden' name='strDitemBrandId' value='"
										+ wb.getString(2) + "' disabled=true>");

						br.append("<input type='hidden' name='strDGroupId' value='"
										+ wb.getString(4) + "' disabled=true>");
						br.append("<input type='hidden' name='strDSubGroupId' value='"
										+ wb.getString(5) + "' disabled=true>");
						br.append("<input type='hidden' name='strDSanctionQty' value='"
										+ wb.getString(9).replace(" ", "#").split("#")[0]
										+ "' disabled=true>");
						br.append("<input type='hidden' name='strDSanctionQtyUnit' value='"
										+ wb.getString(7) + "' disabled=true>");

						br.append("</td><td width='5%' class='multiControl'>"+(nTmpI+1)+"</td><td width='20%' class='multiControl' style=\"text-align:left;\" id='tdstrDitemBrandId"+wb.getString(2)+""+nTmpI+ "'  >");
						br.append(wb.getString(6));
						br.append("</td><td width='8%' class='multiControl' id='tdstrTmpBalQty"+wb.getString(2)+""+nTmpI+ "'><div id='testdiv' >");
						br.append("<a STYLE='CURSOR:POINTER;color:blue' data-toggle='modal' data-target='#tariffDtlsModal1' id ='TQTY"+wb.getString(2)+""+0+"' onClick='get_item_details(this,"+nTmpI+");' > ");
						br.append(wb.getString(9));
						br.append("</a></div>");
						 /******* EnD -- Pop-Up Get After Clicking On Balance Qty*********/
						br.append("</td><td width='30%' class='multiControl' id='tdstrDSuppId"+wb.getString(2)+""+nTmpI+ "'>");
						poDeskGenerateTransVO.setStrItemIds(wb.getString(1));
						poDeskGenerateTransVO.setStrItemBrandIds(wb.getString(2));
						poDeskGenerateTransVO.setStrContractType("12");//hardcoded for B&S
						poDeskGenerateTransBO.setSupplierValuesBasedOnRC(poDeskGenerateTransVO);
						
						br.append("<select name=strDSuppId id ='CMBSUP"+wb.getString(2)+""+0+"' class='comboBig' onchange='checkOrderQty(this)'  disabled=true>"		
								+ poDeskGenerateTransVO.getStrSupplierValuesRC()
								+ "</select>");
						br.append("</td><td width='6%' class='multiControl' id='tdstrDOrderQty"+wb.getString(2)+""+nTmpI+ "' >");
						br.append("<input type=text class=txtFldMin disabled=true onkeypress='return validateData(event,5);' value="+wb.getString(9)+" onkeyup='calcTotalRate(this);' autocomplete='off' maxlength=7 name='strDOrderQty' id ='QTY"+wb.getString(2)+""+0+"'>");
						br.append("</td><td width='5%' class='multiControl' id='tdstrDOrderQtyUnitId"+wb.getString(2)+""+nTmpI+ "'>");

						poDeskGenerateTransVO.setStrInventoryUnitId(wb.getString(12));
						
						/********** Calling BO Method to Get Unit *************/
						poDeskGenerateTransBO.setUnitValues(poDeskGenerateTransVO);

						br.append("<select name=strDOrderQtyUnitId onchange='checkOrderQty(this)' disabled=true id ='CMBUNIT"+wb.getString(2)+""+0+"'>"
										+ poDeskGenerateTransVO.getStrRateUnitValues()
										+ "</select>");
						br.append("</td><td width='6%' class='multiControl' id='tdstrDRateUnit"+wb.getString(2)+""+nTmpI+ "'>");
						br.append("<input type=text class=txtFldMin onkeypress='return validateData(event,7);' maxlength=7 value="+poDeskGenerateTransVO.getStrSupp().split("@")[1]+" name=strDRateUnit onblur='getTotRate(this)'   id ='RATE"+wb.getString(2)+""+0+"'>");
						br.append("</td><td width='6%' class='multiControl' id='tdstrDTax"+wb.getString(2)+""+nTmpI+ "'>");
						br.append("<input type=text class=txtFldMin onkeypress='return validateData(event,7);' maxlength=5 name=strDTax value="+poDeskGenerateTransVO.getStrSupp().split("@")[3]+"   id ='TAX"+wb.getString(2)+""+0+"'>");
						br.append("</td><td width='10%' class='multiControl'  id='tdstrDTotalRate"+wb.getString(2)+""+nTmpI+ "'>");
						//ratewidtax= (Math.round(Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1])+((Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[3])*Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1]))/100))*(Double.parseDouble(wb.getString(9).split(" ")[0])*100.0)/100.0);
						ratewidtax = Math.round((((Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1])+((Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1])*Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[3]))/100))*(Double.parseDouble(wb.getString(9).split(" ")[0])))*100.0)/100.0);
						br.append("<input type=text class=txtFldNormal onkeypress='return validateData(event,5);' value="+ratewidtax +"  name=strDTotalRate disabled=true id ='TRATE"+wb.getString(2)+""+0+"'>");
					//	br.append("</td><td width='8%' class='multiControl' >");
						//br.append("<input type=text class=txtFldNormal onkeypress='return validateData(event,5);' value="+poDeskGenerateTransVO.getStrSupp().split("@")[2]+"  name=strDShelfLife  id ='SLIFE"+wb.getString(2)+""+0+"'>");
						//br.append("</td><td width='10%' class='multiControl' >");
						//br.append("<div id='addSupp"+nTmpI+"'><img src='../../hisglobal/images/Add_Supplier.png' id ='BTN"+wb.getString(2)+""+0+"' title='Check List' style='cursor: pointer;' ");
						//br.append("title='Add Supplier' onclick='addSuppiler(this,0)'></div>");
						//br.append(nTmpI);
						//br.append("\")'>");
						nTmpI++;
						br.append("</td></table></div>");
						tot+=ratewidtax;
						
					}
					br.append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr>");
					br.append("<td width='25%' class='LABEL'><div align='right'><b>PO Date</b></div></td><td width='25%' class='CONTROL'> ");
					br.append("<div style='' id='divPODate'>");
					br.append(HisUtil.getDatePicker("strpoDate", PoDate, false));
					_poDeskGenerateTransFB.setStrCurrentDate(PoDate);
					br.append("</div>");
					//br.append("<div id='divFrmDate' style='display:none;'>");
					//br.append(_poDeskGenerateTransFB.getStrCurrentDate());
					//br.append("</div>");
					br.append("</td>");
					//br.append("<td width='25%' class='LABEL'><div align='right'><b>To Date</b></div></td><td width='25%' class='CONTROL'> ");
					//br.append("<div style='' id='divToDate'>");
					//br.append(HisUtil.getDatePicker("strToDate", _poDeskGenerateTransFB.getStrCurrentDate(), false));
					//br.append("</div>");
					//br.append("<div id='divTDate' style='display:none;'>");
					//br.append(_poDeskGenerateTransFB.getStrCurrentDate());
					//br.append("</div>");
					//br.append("</td>");
					
					br.append("</tr></table>");
					/*if(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("21"))
					{
								br.append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr>");
								br.append("<td width='25%' class='LABEL'><div align='right'><b>From Date</b></div></td><td width='25%' class='CONTROL'> ");
								br.append("<div style='' id='divFromDate'>");
								br.append(HisUtil.getDatePicker("strFromDate", _poDeskGenerateTransFB.getStrCurrentDate(), false));
								br.append("</div>");
								br.append("<div id='divFrmDate' style='display:none;'>");
								br.append(_poDeskGenerateTransFB.getStrCurrentDate());
								br.append("</div>");
								br.append("</td>");
								br.append("<td width='25%' class='LABEL'><div align='right'><b>To Date</b></div></td><td width='25%' class='CONTROL'> ");
								br.append("<div style='' id='divToDate'>");
								br.append(HisUtil.getDatePicker("strToDate", _poDeskGenerateTransFB.getStrCurrentDate(), false));
								br.append("</div>");
								br.append("<div id='divTDate' style='display:none;'>");
								br.append(_poDeskGenerateTransFB.getStrCurrentDate());
								br.append("</div>");
								br.append("</td>");
								
								br.append("</tr></table>");
					
					}
					else
					{
						br.append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr>");
						br.append("<td width='75%' class='CONTROL'>");
						br.append("</td>");
						br.append("<td width='25%' class='CONTROL'>");
						br.append("<div id='divtot' align='right'><b>Total Cost </b>");
						br.append(tot);
						br.append("</div>");
						br.append("</td>");
						br.append("</tr></table>");
						
					}*/
					br.append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr>");
					br.append("<td class='CONTROL' colspan=4>");
					br.append("<div align=center id='compile_btn'><img src='../../hisglobal/images/proceed.png'");
					br.append("style='cursor: pointer; ' title='Save Record'");
					br.append("onClick='compile_supp_wise();' />");
					br.append(" <img src='../../hisglobal/images/btn-ccl.png'");
					br.append("style='cursor: pointer; ' title='Cancel Process'");
					br.append("onClick='cancelToDesk();'></center></div>");
					br.append("</td></tr></table>");
					br.append("</div>");
				} else {
					br.append("<div id="
							+ strReqNo.split("#")[nTmpI] + ">");
					br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
					br.append("<tr>");
					br.append("<td colspan='5'  CLASS='multiControl' ><DIV class='errMsg' align='center'>Either Item is not mapped with store or RC has not been done for Item or Approval required </div></TD>");
					br.append("</tr>");
					br.append("</table>");
					br.append("</div>");
				}
			//}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getIndentDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	
	public static String getPOItemDetails(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		String strDivId = "";
		String strReqNo="";
		String strStores="";
		String[] poHid;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			int nTmpI = 0;
			
			//[10101107@10221500001@33101@22@10@1@$1]
					
				poDeskGenerateTransVO.setStrItemCat(_poDeskGenerateTransFB.getStrCheckData().replace("@","#").split("#")[4]);
				poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrCheckData().replace("@","#").split("#")[2]);
				poDeskGenerateTransVO.setStrPONo(_poDeskGenerateTransFB.getStrCheckData().replace("@","#").split("#")[1]);
				poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrCheckData().replace("@","#").split("#")[0]);
				poDeskGenerateTransVO.setStrPOTypeId(_poDeskGenerateTransFB.getStrCheckData().replace("@","#").split("#")[3]);

				poDeskGenerateTransBO.getPOItemDetails(poDeskGenerateTransVO);

				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());

				_poDeskGenerateTransFB.setWbRequestItemDetail(poDeskGenerateTransVO.getWbRequestItemDetail());

				wb = _poDeskGenerateTransFB.getWbRequestItemDetail();
				
				//for (int nTmpJ = 0; nTmpJ < _poDeskGenerateTransFB
				//		.getStrRequestIds().replace("^", "#").split("#").length; nTmpJ++) {
				if (wb.size() != 0) {
					
//					br.append("<div id="
//							+ strReqNo.split(",")[nTmpI] + ">");
					br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'>");
					br.append("<tr>");
					br.append("</td><td width='50%' class='LABEL' style=\"text-align:left;\">Item Name[Generic Name]");
					br.append("</td><td width='20%' class='LABEL' style=\"text-align:center;\">Ordered Qty");
					br.append("</td><td width='20%' class='LABEL' style=\"text-align:center;\"><font color='red'>*</font>Approved Qty");
					br.append("</td><td width='10%' class='LABEL' style=\"text-align:center;\">Unit");
					br.append("</td></tr>");
					br.append("</table>");
					
					poHid = new String[wb.size()];
					while (wb.next()) {
						
						poHid[nTmpI]=wb.getString(1);
						br.append("<table class='TABLEWIDTH' id = 'divId"+wb.getString(1)+"'  bgcolor='#6097BC' align='center' cellspacing='1px'>");
						br.append("<tr>");
						br.append("<input type='hidden' name='strPOHiddenVal' value='"+ wb.getString(1) + "'>");
						br.append("</td><td width='50%' class='CONTROL' style=\"text-align:left;\" >");
						br.append(wb.getString(2));
						br.append("</td><td width='20%' class='CONTROL' style=\"text-align:center;\">");
						br.append(wb.getString(3));
						br.append("</td><td width='20%' class='CONTROL' style=\"text-align:center;\">");
						br.append("<input type=text class=txtFldNormal onkeypress='return validateData(event,5);' value="+wb.getString(3).split(" ")[0]+" onkeyup='' autocomplete='off' name='strQrderQty' id ='QTY"+wb.getString(2)+""+0+"'>");
						br.append("</td><td width='10%' class='CONTROL' style=\"text-align:center;\" id='tdstrOrderQtyUnitId"+wb.getString(1)+""+nTmpI+ "'>");
						poDeskGenerateTransVO.setStrInventoryUnitId(wb.getString(4));
						
						/********** Calling BO Method to Get Unit *************/
						poDeskGenerateTransBO.setUnitValues(poDeskGenerateTransVO);

						br.append("<select name=strOrderQtyUnitId onchange='checkOrderQty(this)' disabled=true id ='CMBUNIT"+wb.getString(2)+""+0+"'>"
										+ poDeskGenerateTransVO.getStrRateUnitValues()
										+ "</select>");
						
						nTmpI++;
						br.append("</td></table>");
					}
					//_poDeskGenerateTransFB.setStrPOHiddenVal(poHid);
					//br.append("</div>");
				} else {
					//br.append("<div id='ApprovalData'>");
					br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
					br.append("<tr>");
					br.append("<td colspan='5'  CLASS='CONTROL' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
					br.append("</tr>");
					br.append("</table>");
					//br.append("</div>");
				}
			//}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getIndentDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}

	public static String getComponentDetail(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {
		StringBuffer sBuffer = null;

		try {
			sBuffer = new StringBuffer("");

			for (int nTmpI = 0; nTmpI < _poDeskGenerateTransFB
					.getStrComponentID().length; nTmpI++) {
				sBuffer
						.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing='1px'><tr>");
				sBuffer.append("<td width='30%' class='LABEL'>"
						+ _poDeskGenerateTransFB.getStrComponentName()[nTmpI]
						+ "</td>");
				sBuffer
						.append("<td width='70%' class='CONTROL'><input type='hidden' name='strDComponentId' value='"
								+ _poDeskGenerateTransFB.getStrComponentID()[nTmpI]
								+ "'><textarea name='strDComponentValue' style='width:300px; height:40px '>"
								+ _poDeskGenerateTransFB.getStrComponentValue()[nTmpI]
								+ "</textarea></td>");
				sBuffer.append("</tr></table>");
			}
			if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskGenerateTransFB.getStrMsgString());
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsgString("PODeskGenerateTransHLP.getComponentDetail() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return sBuffer.toString();
	}
	
	public static String getPOWithItemHLP(PODeskGenerateTransFB _poDeskGenerateTransFB) 
	{

		 StringBuffer br = new StringBuffer("");
		 String strJonalLocation ="";
		 WebRowSet wb = null;
		 double cltamt  = 0.00;
		 double totalCost = 0.00;
		 int    totalQty  = 0;
		 int   grandTotalQty = 0;
		 double totalGrandCost =0.00;
		 String strItemTotCost="0.00";
		 int count = 0;
		 NumberFormat formatter = new DecimalFormat("############.##"); 
		 DecimalFormat myFormatter = new DecimalFormat("0.00");
		try 
		{
						
				br.append("<table class='TABLEWIDTH' bgcolor='#1277B5' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='8%'  class='multiLabel'>Hospital</td>");
				br.append("<td width='12%' class='multiLabel'>Store</td>");
				br.append("<td width='7%'  class='multiLabel'>Quantity Demanded by Hospitals</td>");
				br.append("<td width='7%'  class='multiLabel'>Quantity Ordered by Hospital</td>");
				br.append("<td width='7%'  class='multiLabel'>Total Qty Supplied at Stores</td>");
				br.append("<td width='7%'  class='multiLabel'>Qty Issued to Sub Stores</td>");				
				br.append("<td width='7%'  class='multiLabel'>Qty in PipeLine(transit)</td>");				
				br.append("<td width='7%'  class='multiLabel'>Current Stock</td>");
				//br.append("<td width='7%'  class='multiLabel'>Qty in Quarntine</td>");
				br.append("<td width='7%'  class='multiLabel'>Qty in  Sub-Stores</td>");			
				br.append("<td width='8%'  class='multiLabel'>Re-Order Level</td>");
				br.append("<td width='10%' class='multiLabel'>Quantity to be Ordered</td>");
				br.append("<td width='8%'  class='multiLabel'>Value of Qty to be Ordered(Rs.)(Inc. Tax)</td>");
				
				br.append("</tr>");
				
				int i = 0;
				wb =  _poDeskGenerateTransFB.getWbsReqListPO();				
				if(_poDeskGenerateTransFB.getWbsReqListPO() != null && _poDeskGenerateTransFB.getWbsReqListPO().size() > 0)
				{					
					while(_poDeskGenerateTransFB.getWbsReqListPO().next())
					{			
							    if(i == 0)
							    {	
						          strJonalLocation = wb.getString(12);
							    }
						        if(strJonalLocation.equals(wb.getString(12)))
						        {	
						        	   
								        // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) + Order Qty(7) +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
								        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9)+"^"+wb.getString(10)+"^"+wb.getString(11)+"^"+wb.getString(12);	
								        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
								        //br.append("<input type='hidden' name='reOrderFlag' id='reOrderFlag"+i+"' value='"+wb.getString(11)+"'>");
							            br.append("<tr>");
							            if(i == 0)
										{
							                br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiLabel'  width='8%'><b>"+wb.getString(12)+"<b></td>");
										}
							            else
							            {
							            	br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiLabel'  width='8%'></td>");
							            }
										br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiControl'    width='12%'><b>"+wb.getString(1)+"</b></td>");
										br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(2)+"</td>");
										br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(3).split("\\#")[0]+"</td>");
										br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(3).split("\\#")[1]+"</td>");
										br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(4)+"</td>");
										br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(11)+"</td>");
										br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(5).split("\\#")[0]+"</td>");								
										//br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(5).split("\\#")[1]+"</td>");
										br.append("<td  name='td10' id='td90"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(10)+"</td>");								
										br.append("<td  name='td10' id='td110"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='8%'>"+wb.getString(6)+"</td>");
										if(_poDeskGenerateTransFB.getStrMode().equals("2"))
									  	{
											br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onBlur='POUtilityFunction("+i+");' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");	
										//br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onKeyUp='getValueofOrderQty("+i+");' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
										    br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiControl'  width='8%'><input type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+wb.getString(7).split("\\#")[1]+"></td>");
									  	}
										else
										{
											br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onBlur='POUtilityFunction("+i+");' class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
											//br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onKeyUp='getValueofOrderQty("+i+");' value='0' class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
											br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiControl'  width='8%'><input type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value='0'></td>");
								
										}							
								  	    br.append("</tr>");  
								  	    
								  	    //System.out.println(br);
								  	    
						        }
						        else
						        {
						        	strJonalLocation = wb.getString(12);
						        	// Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) + Order Qty(7) +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
							        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9)+"^"+wb.getString(10)+"^"+wb.getString(11)+"^"+wb.getString(12);	
							        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
							        //br.append("<input type='hidden' name='reOrderFlag' id='reOrderFlag"+i+"' value='"+wb.getString(11)+"'>");
						            br.append("<tr>");
						            br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiLabel'  width='8%'><b>"+wb.getString(12)+"<b></td>");
									br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiControl'    width='12%'><b>"+wb.getString(1)+"</b></td>");
									br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(2)+"</td>");
									br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(3).split("\\#")[0]+"</td>");
									br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(3).split("\\#")[1]+"</td>");
									br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(4)+"</td>");
									br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(11)+"</td>");
									br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(5).split("\\#")[0]+"</td>");								
							    	br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(5).split("\\#")[1]+"</td>");
									br.append("<td  name='td10' id='td90"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='7%'>"+wb.getString(10)+"</td>");								
									br.append("<td  name='td10' id='td110"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='8%'>"+wb.getString(6)+"</td>");
									if(_poDeskGenerateTransFB.getStrMode().equals("2"))
								  	{
										br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onBlur='POUtilityFunction("+i+");' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");	
									    br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiControl'  width='8%'><input type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+wb.getString(7).split("\\#")[1]+"></td>");
								  	}
									else
									{
										br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onBlur='POUtilityFunction("+i+");' class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
									    br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiControl'  width='8%'><input type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value='0'></td>");
							
									}							
							  	    br.append("</tr>");  
							  	    count++;
						        	
						        	
						        	
						        }						        
							  	if(_poDeskGenerateTransFB.getStrMode().equals("2"))
							  	{	
							  	  strItemTotCost = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[1]));  
						          cltamt = Double.parseDouble(strItemTotCost);							
						          totalGrandCost = totalGrandCost + cltamt;
						          
						          totalQty = Integer.parseInt(wb.getString(7).split("\\#")[0]);
						          grandTotalQty = grandTotalQty + totalQty;
						          //wb.getString(7).split("\\#")[0]
							  	}						  	    
					            i=i+1;					     
				   }
				}
				
				
				br.append("<tr>");			
//				br.append("<td colspan='1'  class='multiLabel'></td>");
//				br.append("<td colspan='1'  class='multiLabel'></td>");
//				br.append("<td colspan='1'  class='multiLabel'></td>");
//				br.append("<td colspan='1'  class='multiLabel'></td>");
//				br.append("<td colspan='1'  class='multiLabel'></td>");				
//				br.append("<td width='7%'  class='multiLabel'></td>");				
//				br.append("<td width='7%'  class='multiLabel'></td>");
//				br.append("<td width='7%'  class='multiLabel'></td>");
//				br.append("<td width='7%'  class='multiLabel'></td>");
				br.append("<td colspan='10' class='multiLabel'><div align='right'>Total Order Qty :: </div></td>");	
				if(_poDeskGenerateTransFB.getStrMode().equals("2"))
			  	{
				    br.append("<td colspan='1'  class='multiLabel'><input type='text' name='strTotalQrderQty' readonly  value='"+grandTotalQty+"' id='strTotalQrderQty'  class='txtFldNormal'></td>");
			  	}
				else
				{
					br.append("<td colspan='1'  class='multiLabel'><input type='text' name='strTotalQrderQty' readonly  value='0' id='strTotalQrderQty'  class='txtFldNormal'></td>");
				}
				br.append("<td colspan='1'  class='multiLabel'></td>");
				//br.append("<td colspan='1'  class='multiLabel'></td>");
				br.append("</tr>");
	
				
				br.append("</table>");
			
		} 
		catch (Exception _e) 
		{
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getImpContiRequestDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		if(_poDeskGenerateTransFB.getStrMode().equals("2"))
	  	{
			//System.out.println("In Modify 2:::"+br.toString()+"^^^2^^^"+totalGrandCost);
			String FinaltotalCost = formatter.format(new BigDecimal(totalGrandCost));  
		    return br.toString()+"^^^2^^^"+FinaltotalCost;
	  	}
		else
		{
			//System.out.println("In Generate:::"+br.toString()+"^^^1^^^0");
			return br.toString()+"^^^1^^^0";	
		}
		
		
	}
	
	public static String getPOWithItemHLPTWO(PODeskGenerateTransFB _poDeskGenerateTransFB) 
	{

		 StringBuffer br = new StringBuffer("");
		 String strJonalLocation ="";
		 WebRowSet wb = null;
		 double cltamt  = 0.00;
		 double totalCost = 0.00;
		 double    totalQty  = 0;
		 double   grandTotalQty = 0;
		 double totalGrandCost =0.00;
		 String strItemTotCost="0.00";
		 int count = 0;
		 NumberFormat formatter = new DecimalFormat("############.##"); 
		 DecimalFormat myFormatter = new DecimalFormat("0.00");
		 String strOrderQtyScheduleOne="0.00";
		 String strOrderQtyScheduleTwo="0.00";
		 String strOrderQtyScheduleThree="0.00";
		 String strOrderQtyScheduleFour="0.00";
		 
		 String strAcceptedQtyScheduleOne="0.00";
		 String strAcceptedQtyScheduleTwo="0.00";
		 String strAcceptedQtyScheduleThree="0.00";
		 String strAcceptedQtyScheduleFour="0.00";
		 
		 String strRejectedQtyScheduleOne="0.00";
		 String strRejectedQtyyScheduleTwo="0.00";
		 String strRejectedQtyScheduleThree="0.00";
		 String strRejectedQtyScheduleFour="0.00";
		 
		 String strOrderValScheduleOne="0.00";
		 String strOrderValScheduleTwo="0.00";
		 String strOrderValThree="0.00";
		 String strOrderValFour="0.00";
		 
		 int cltamtSchOne    = 0;
		 int cltamtSchTwo    = 0;
		 int cltamtSchThree  = 0;
		 int cltamtSchFour   = 0;
		 
		 
		 double valSchOne    = 0;
		 double valSchTwo    = 0;
		 double valSchThree  = 0;
		 double valSchFour   = 0;
		 
		 double totalValue =0;
		 
		 int totalGrandSchOne =0;
		 int totalGrandAcceptedQty =0;
		 int totalGrandRejectedQty =0;
		 int totalReceivedQty =0;
		 
		 String[] temp = null;
		 String[] strTemp = null;
		try 
		{
						
				br.append("<table class='TABLEWIDTH' bgcolor='#0099FF' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='8%'  class='multiLabel'>DIVISON</td>");
				br.append("<td width='12%' class='multiLabel'>Store</td>");
				br.append("<td width='9%'  class='multiLabel'>Prev Ordered Qty</td>");
				br.append("<td width='9%'  class='multiLabel'>Total Rece. Qty.</td>");
				//br.append("<td width='9%'  class='multiLabel'>Balance Qty.</td>");
				//br.append("<td width='9%'  class='multiLabel'>Schedule [I]</td>");				
				/* commented by shefali on 29 oct 2014
				br.append("<td width='9%'  class='multiLabel'>Schedule [II]</td>");				
				br.append("<td width='9%'  class='multiLabel'>Schedule [III]</td>");
				br.append("<td width='9%'  class='multiLabel'>Schedule [IV]</td>");
				
				*/
				
				br.append("<td width='10%' class='multiLabel'>Total Qty to be Ordered</td>");
				br.append("<td width='9%'  class='multiLabel'>Value of Qty to be Ordered(Rs.)(Inc. Tax)</td>");
				
				br.append("</tr>");
				
				int i = 0;
				wb =  _poDeskGenerateTransFB.getWbsReqListPO();				
				
					if(_poDeskGenerateTransFB.getWbsReqListPO() != null && _poDeskGenerateTransFB.getWbsReqListPO().size() > 0)
					{	
					 	while(_poDeskGenerateTransFB.getWbsReqListPO().next())
						{	
								    if(i == 0)
								    {	
							          strJonalLocation = wb.getString(12);
								    }
							        if(strJonalLocation.equals(wb.getString(12)))
							        {	
							        	   
							        	strOrderQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[0]));
										strOrderQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[4]));  
										strOrderQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[8]));  
										strOrderQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[12]));  
										//System.out.println("strOrderQtyScheduleOne==>"+strOrderQtyScheduleOne+":::strOrderQtyScheduleTwo:::"+strOrderQtyScheduleTwo +":::strOrderQtyScheduleThree:::"+strOrderQtyScheduleThree+"::strOrderQtyScheduleFour:::"+strOrderQtyScheduleFour);
										
										cltamtSchOne             = Integer.parseInt(strOrderQtyScheduleOne);
										cltamtSchTwo             = Integer.parseInt(strOrderQtyScheduleTwo);
										cltamtSchThree           = Integer.parseInt(strOrderQtyScheduleThree);
										cltamtSchFour            = Integer.parseInt(strOrderQtyScheduleFour);
										
										totalGrandSchOne         = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandSchOne==>"+totalGrandSchOne);
										/********************************************************************************/
										strAcceptedQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[2]));
										strAcceptedQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[6]));  
										strAcceptedQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[10]));  
										strAcceptedQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[14]));
										
										cltamtSchOne             	= Integer.parseInt(strAcceptedQtyScheduleOne);
										cltamtSchTwo             	= Integer.parseInt(strAcceptedQtyScheduleTwo);
										cltamtSchThree           	= Integer.parseInt(strAcceptedQtyScheduleThree);
										cltamtSchFour            	= Integer.parseInt(strAcceptedQtyScheduleFour);
										
										totalGrandAcceptedQty       = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandAcceptedQty==>"+totalGrandAcceptedQty);
										/********************************************************************************/
										
										
										strRejectedQtyScheduleOne    = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[3]));
										strRejectedQtyyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[7]));  
										strRejectedQtyScheduleThree  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[11]));  
										strRejectedQtyScheduleFour   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[15]));
										
										cltamtSchOne                 = Integer.parseInt(strRejectedQtyScheduleOne);
										cltamtSchTwo             	 = Integer.parseInt(strRejectedQtyyScheduleTwo);
										cltamtSchThree           	 = Integer.parseInt(strRejectedQtyScheduleThree);
										cltamtSchFour            	 = Integer.parseInt(strRejectedQtyScheduleFour);
										
										totalGrandRejectedQty    	 = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										
										totalReceivedQty             = totalGrandAcceptedQty  + totalGrandRejectedQty;
										
										/********************************************************************************/
										strOrderValScheduleOne       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[1]));
										strOrderValScheduleTwo       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[5]));  
										strOrderValThree             = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[9]));  
										strOrderValFour              = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[13]));
										
										valSchOne                    = Double.parseDouble(strOrderValScheduleOne);
										valSchTwo             	     = Double.parseDouble(strOrderValScheduleTwo);
										valSchThree           	     = Double.parseDouble(strOrderValThree);
										valSchFour            	     = Double.parseDouble(strOrderValFour);
										
										
										 totalValue    	 = valSchOne + valSchTwo + valSchThree + valSchFour;
										//System.out.println("totalGrandRejectedQty==>"+totalGrandRejectedQty);
										//System.out.println("totalReceivedQty==>"+totalReceivedQty);
							        	
									        // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) +[Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [I] +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
							        	    //                                                                                                                                         [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [II]
							        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [III]
							        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [IV]
									        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9)+"^"+wb.getString(10)+"^"+wb.getString(11)+"^"+wb.getString(12);	
									       
									        		        
									        br.append("<input type='hidden' name='strSchedulePopUpHidValue' id='strSchedulePopUpHidValue"+i+"' value='"+wb.getString(7)+"'>");
									        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
									        //br.append("<input type='hidden' name='reOrderFlag' id='reOrderFlag"+i+"' value='"+wb.getString(11)+"'>");
								            br.append("<tr>");
								            if(i == 0)
											{
								                br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiLabel'  width='15%'><b>"+wb.getString(12)+"<b></td>");
											}
								            else
								            {
								            	br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiLabel'  width='15%'></td>");
								            }
								            //
											br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiControl'  width='15%'><b><font color='blue'>"+wb.getString(1)+"</font></a></b></td>");
											br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='15%'>"+totalGrandSchOne+"</td>");
											br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='15%'>"+totalReceivedQty+"</b></td>");
										   //br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'>"+wb.getString(3).split("\\#")[1]+"</td>");
											/* commented by shefali on 29 oct 2014	
											 * br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='15%'><input  type='text' name='strScheduleOne'   id='strScheduleOne"+i+"'   onblur='POScheduleUtilityFunction("+i+",1);' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
											br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleTwo'   id='strScheduleTwo"+i+"'   onblur='POScheduleUtilityFunction("+i+",2);' value="+wb.getString(7).split("\\#")[4]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
											br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleThree' id='strScheduleThree"+i+"' onblur='POScheduleUtilityFunction("+i+",3);' value="+wb.getString(7).split("\\#")[8]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");								
											br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleFour'  id='strScheduleFour"+i+"'  onblur='POScheduleUtilityFunction("+i+",4);' value="+wb.getString(7).split("\\#")[12]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");*/
											
											br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiControl'  width='20%'><input type='text' name='strQrderQty'  id='strQrderQty"+i+"'      value="+totalGrandSchOne+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' onblur='POUtilityFunction(0);'</td>");	
											br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiControl'  width='20%'><input  type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+totalValue+"></td>");
										  	br.append("</tr>");  
									  	    
							        }
							        else
							        {
							        	strJonalLocation = wb.getString(12);
							        	
							        	strOrderQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[0]));
										strOrderQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[4]));  
										strOrderQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[8]));  
										strOrderQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[12]));  
										//System.out.println("strOrderQtyScheduleOne==>"+strOrderQtyScheduleOne+":::strOrderQtyScheduleTwo:::"+strOrderQtyScheduleTwo +":::strOrderQtyScheduleThree:::"+strOrderQtyScheduleThree+"::strOrderQtyScheduleFour:::"+strOrderQtyScheduleFour);
										
										cltamtSchOne             = Integer.parseInt(strOrderQtyScheduleOne);
										cltamtSchTwo             = Integer.parseInt(strOrderQtyScheduleTwo);
										cltamtSchThree           = Integer.parseInt(strOrderQtyScheduleThree);
										cltamtSchFour            = Integer.parseInt(strOrderQtyScheduleFour);
										
										totalGrandSchOne         = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandSchOne==>"+totalGrandSchOne);
										/********************************************************************************/
										strAcceptedQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[2]));
										strAcceptedQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[6]));  
										strAcceptedQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[10]));  
										strAcceptedQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[14]));
										
										cltamtSchOne             	= Integer.parseInt(strAcceptedQtyScheduleOne);
										cltamtSchTwo             	= Integer.parseInt(strAcceptedQtyScheduleTwo);
										cltamtSchThree           	= Integer.parseInt(strAcceptedQtyScheduleThree);
										cltamtSchFour            	= Integer.parseInt(strAcceptedQtyScheduleFour);
										
										totalGrandAcceptedQty       = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandAcceptedQty==>"+totalGrandAcceptedQty);
										/********************************************************************************/
										strRejectedQtyScheduleOne    = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[3]));
										strRejectedQtyyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[7]));  
										strRejectedQtyScheduleThree  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[11]));  
										strRejectedQtyScheduleFour   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[15]));
										
										cltamtSchOne                 = Integer.parseInt(strRejectedQtyScheduleOne);
										cltamtSchTwo             	 = Integer.parseInt(strRejectedQtyyScheduleTwo);
										cltamtSchThree           	 = Integer.parseInt(strRejectedQtyScheduleThree);
										cltamtSchFour            	 = Integer.parseInt(strRejectedQtyScheduleFour);
										
										totalGrandRejectedQty    	 = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										
										totalReceivedQty             = totalGrandAcceptedQty  + totalGrandRejectedQty;
										
										/********************************************************************************/
										strOrderValScheduleOne       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[1]));
										strOrderValScheduleTwo       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[5]));  
										strOrderValThree             = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[9]));  
										strOrderValFour              = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[13]));
										
										valSchOne                    = Double.parseDouble(strOrderValScheduleOne);
										valSchTwo             	     = Double.parseDouble(strOrderValScheduleTwo);
										valSchThree           	     = Double.parseDouble(strOrderValThree);
										valSchFour            	     = Double.parseDouble(strOrderValFour);
										
										
										 totalValue    	 = valSchOne + valSchTwo + valSchThree + valSchFour;
										
										//System.out.println("totalGrandRejectedQty==>"+totalGrandRejectedQty);
										//System.out.println("totalReceivedQty==>"+totalReceivedQty);
							        	
							        	   // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) +[Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [I] +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
						        	    //                                                                                                                                         [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [II]
						        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [III]
						        	 //  
								        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9)+"^"+wb.getString(10)+"^"+wb.getString(11)+"^"+wb.getString(12);	
								        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
								        br.append("<input type='hidden' name='strSchedulePopUpHidValue' id='strSchedulePopUpHidValue"+i+"' value='"+wb.getString(7)+"'>");
							            br.append("<tr>");
							            br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiLabel'   width='8%'><b>"+wb.getString(12)+"<b></td>");
							            br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiControl'  width='12%'><b><a value='' style='cursor:pointer;'onClick='callingPoPUp(this,"+i+");'title='Click here to Get PO Specefication'><font color='blue'>"+wb.getString(1)+"</font></a></b></td>");
										br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'>"+totalGrandSchOne+"</td>");
										br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><a value='' style='cursor:pointer;'onClick='callingPoPUpTwo(this,"+i+");'title='Click here to Get PO Schedule Detail(s)'><font color='blue'>"+totalReceivedQty+"</font></a></b></td>");
										//br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'>"+wb.getString(3).split("\\#")[1]+"</td>");
										br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleOne'   id='strScheduleOne"+i+"'  onblur='POScheduleUtilityFunction("+i+",1);' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='10' onkeypress='return validateData(event,7);'></td>");
										br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleTwo'   id='strScheduleTwo"+i+"'  onblur='POScheduleUtilityFunction("+i+",2);' value="+wb.getString(7).split("\\#")[4]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
										br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleThree' id='strScheduleThree"+i+"'onblur='POScheduleUtilityFunction("+i+",3);' value="+wb.getString(7).split("\\#")[8]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");								
										br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleFour'  id='strScheduleFour"+i+"' onblur='POScheduleUtilityFunction("+i+",4);' value="+wb.getString(7).split("\\#")[12]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
										br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiControl'  width='10%'><input type='text' name='strQrderQty'      id='strQrderQty"+i+"'     value="+totalGrandSchOne+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");	
										br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strOrdeCost'      id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+totalValue+"></td>");
									  	br.append("</tr>");  
								  	    count++;
							        	
							        	
							        	
							        }						        
							        if(_poDeskGenerateTransFB.getStrMode().equals("2"))
								  	{	
							        	
							          cltamt = Double.parseDouble(formatter.format(new BigDecimal(Double.parseDouble(wb.getString(7).split("\\#")[1])+Double.parseDouble(wb.getString(7).split("\\#")[5])+Double.parseDouble(wb.getString(7).split("\\#")[9])+Double.parseDouble(wb.getString(7).split("\\#")[13]))));						
							          totalGrandCost = totalGrandCost + cltamt;
							          
							          totalQty = Double.parseDouble(wb.getString(7).split("\\#")[0])+Double.parseDouble(wb.getString(7).split("\\#")[4])+Double.parseDouble(wb.getString(7).split("\\#")[8])+Double.parseDouble(wb.getString(7).split("\\#")[12]);
							          grandTotalQty = grandTotalQty + totalQty;
							          //wb.getString(7).split("\\#")[0]
								  	}						  	    
						            i=i+1;					     
					   }
				}
				
				
				br.append("<tr>");			
//				br.append("<td colspan='1'  class='multiLabel'></td>");
//				br.append("<td colspan='1'  class='multiLabel'></td>");
//				br.append("<td colspan='1'  class='multiLabel'></td>");
//				br.append("<td colspan='1'  class='multiLabel'></td>");
//				br.append("<td colspan='1'  class='multiLabel'></td>");				
//				br.append("<td width='7%'  class='multiLabel'></td>");				
//				br.append("<td width='7%'  class='multiLabel'></td>");
//				br.append("<td width='7%'  class='multiLabel'></td>");
//				br.append("<td width='7%'  class='multiLabel'></td>");
				br.append("<td colspan='5' class='multiLabel'><div align='right'>Total Order Qty :: </div></td>");	
				if(_poDeskGenerateTransFB.getStrMode().equals("2"))
			  	{
				    br.append("<td colspan='1'  class='multiLabel'><input type='text' name='strTotalQrderQty' readonly  value='"+grandTotalQty+"' id='strTotalQrderQty'  class='txtFldNormal'></td>");
			  	}
				else
				{
					br.append("<td colspan='1'  class='multiLabel'><input type='text' name='strTotalQrderQty' readonly  value='0' id='strTotalQrderQty'  class='txtFldNormal'></td>");
				}
				br.append("<td colspan='1'  class='multiLabel'></td>");
				//br.append("<td colspan='1'  class='multiLabel'></td>");
				br.append("</tr>");
	
				
				br.append("</table>");
			
		} 
		catch (Exception _e) 
		{
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getImpContiRequestDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		if(_poDeskGenerateTransFB.getStrMode().equals("2"))
	  	{
			//System.out.println("In Modify 2:::"+br.toString()+"^^^2^^^"+totalGrandCost);
			String FinaltotalCost = formatter.format(new BigDecimal(totalGrandCost));  
		    return br.toString()+"^^^2^^^"+FinaltotalCost;
	  	}
		else
		{
			//System.out.println("In Generate:::"+br.toString()+"^^^1^^^0");
			return br.toString()+"^^^1^^^0";	
		}
		
		
	}
	
	
	
	public static String getPOWithItemHLPForView(PODeskGenerateTransFB _poDeskGenerateTransFB) 
	{

		 StringBuffer br = new StringBuffer("");
		 String strJonalLocation ="";
		 WebRowSet wb = null;
		 double cltamt  = 0.00;
		 double totalCost = 0.00;
		 double    totalQty  = 0;
		 double   grandTotalQty = 0;
		 double totalGrandCost =0.00;
		 String strItemTotCost="0.00";
		 int count = 0;
		 NumberFormat formatter = new DecimalFormat("############.##"); 
		 DecimalFormat myFormatter = new DecimalFormat("0.00");
		 String strOrderQtyScheduleOne="0.00";
		 String strOrderQtyScheduleTwo="0.00";
		 String strOrderQtyScheduleThree="0.00";
		 String strOrderQtyScheduleFour="0.00";
		 
		 String strAcceptedQtyScheduleOne="0.00";
		 String strAcceptedQtyScheduleTwo="0.00";
		 String strAcceptedQtyScheduleThree="0.00";
		 String strAcceptedQtyScheduleFour="0.00";
		 
		 String strRejectedQtyScheduleOne="0.00";
		 String strRejectedQtyyScheduleTwo="0.00";
		 String strRejectedQtyScheduleThree="0.00";
		 String strRejectedQtyScheduleFour="0.00";
		 
		 String strOrderValScheduleOne="0.00";
		 String strOrderValScheduleTwo="0.00";
		 String strOrderValThree="0.00";
		 String strOrderValFour="0.00";
		 
		 int cltamtSchOne    = 0;
		 int cltamtSchTwo    = 0;
		 int cltamtSchThree  = 0;
		 int cltamtSchFour   = 0;
		 
		 
		 double valSchOne    = 0;
		 double valSchTwo    = 0;
		 double valSchThree  = 0;
		 double valSchFour   = 0;
		 
		 double totalValue =0;
		 
		 int totalGrandSchOne =0;
		 int totalGrandAcceptedQty =0;
		 int totalGrandRejectedQty =0;
		 int totalReceivedQty =0;
		 
		 String[] temp = null;
		 String[] strTemp = null;
		try 
		{
						
				br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='8%'  class='multiLabel'>DIVISON</td>");
				br.append("<td width='12%' class='multiLabel'>Store</td>");
				br.append("<td width='9%'  class='multiLabel'>Prev Ordered Qty</td>");
				br.append("<td width='9%'  class='multiLabel'>Total Rece. Qty.</td>");
				//br.append("<td width='9%'  class='multiLabel'>Balance Qty.</td>");
			/* COMMENTED by shefali garg on 31 oct 2014
			 * 	br.append("<td width='9%'  class='multiLabel'>Schedule [I]</td>");				
				br.append("<td width='9%'  class='multiLabel'>Schedule [II]</td>");				
				br.append("<td width='9%'  class='multiLabel'>Schedule [III]</td>");
				br.append("<td width='9%'  class='multiLabel'>Schedule [IV]</td>");*/
				br.append("<td width='10%' class='multiLabel'>Total Qty to be Ordered</td>");
				br.append("<td width='9%'  class='multiLabel'>Value of Qty to be Ordered(Rs.)(Inc. Tax)</td>");
				
				br.append("</tr>");
				
				int i = 0;
				wb =  _poDeskGenerateTransFB.getWbsReqListPO();				
				
					if(_poDeskGenerateTransFB.getWbsReqListPO() != null && _poDeskGenerateTransFB.getWbsReqListPO().size() > 0)
					{	
					 	while(_poDeskGenerateTransFB.getWbsReqListPO().next())
						{	
								    if(i == 0)
								    {	
							          strJonalLocation = wb.getString(12);
								    }
							        if(wb.getString(12)!=null && strJonalLocation.equals(wb.getString(12)))
							        {	
							        	   
							        	strOrderQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[0]));
										strOrderQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[4]));  
										strOrderQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[8]));  
										strOrderQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[12]));  
										//System.out.println("strOrderQtyScheduleOne==>"+strOrderQtyScheduleOne+":::strOrderQtyScheduleTwo:::"+strOrderQtyScheduleTwo +":::strOrderQtyScheduleThree:::"+strOrderQtyScheduleThree+"::strOrderQtyScheduleFour:::"+strOrderQtyScheduleFour);
										
										cltamtSchOne             = Integer.parseInt(strOrderQtyScheduleOne);
										cltamtSchTwo             = Integer.parseInt(strOrderQtyScheduleTwo);
										cltamtSchThree           = Integer.parseInt(strOrderQtyScheduleThree);
										cltamtSchFour            = Integer.parseInt(strOrderQtyScheduleFour);
										
										totalGrandSchOne         = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandSchOne==>"+totalGrandSchOne);
										/********************************************************************************/
										strAcceptedQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[2]));
										strAcceptedQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[6]));  
										strAcceptedQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[10]));  
										strAcceptedQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[14]));
										
										cltamtSchOne             	= Integer.parseInt(strAcceptedQtyScheduleOne);
										cltamtSchTwo             	= Integer.parseInt(strAcceptedQtyScheduleTwo);
										cltamtSchThree           	= Integer.parseInt(strAcceptedQtyScheduleThree);
										cltamtSchFour            	= Integer.parseInt(strAcceptedQtyScheduleFour);
										
										totalGrandAcceptedQty       = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandAcceptedQty==>"+totalGrandAcceptedQty);
										/********************************************************************************/
										
										
										strRejectedQtyScheduleOne    = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[3]));
										strRejectedQtyyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[7]));  
										strRejectedQtyScheduleThree  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[11]));  
										strRejectedQtyScheduleFour   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[15]));
										
										cltamtSchOne                 = Integer.parseInt(strRejectedQtyScheduleOne);
										cltamtSchTwo             	 = Integer.parseInt(strRejectedQtyyScheduleTwo);
										cltamtSchThree           	 = Integer.parseInt(strRejectedQtyScheduleThree);
										cltamtSchFour            	 = Integer.parseInt(strRejectedQtyScheduleFour);
										
										totalGrandRejectedQty    	 = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										
										totalReceivedQty             = totalGrandAcceptedQty  + totalGrandRejectedQty;
										
										/********************************************************************************/
										strOrderValScheduleOne       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[1]));
										strOrderValScheduleTwo       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[5]));  
										strOrderValThree             = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[9]));  
										strOrderValFour              = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[13]));
										
										valSchOne                    = Double.parseDouble(strOrderValScheduleOne);
										valSchTwo             	     = Double.parseDouble(strOrderValScheduleTwo);
										valSchThree           	     = Double.parseDouble(strOrderValThree);
										valSchFour            	     = Double.parseDouble(strOrderValFour);
										
										
										 totalValue    	 = valSchOne + valSchTwo + valSchThree + valSchFour;
										//System.out.println("totalGrandRejectedQty==>"+totalGrandRejectedQty);
										//System.out.println("totalReceivedQty==>"+totalReceivedQty);
							        	
									        // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) +[Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [I] +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
							        	    //                                                                                                                                         [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [II]
							        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [III]
							        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [IV]
									        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9)+"^"+wb.getString(10)+"^"+wb.getString(11)+"^"+wb.getString(12);	
									       
									        		        
									        br.append("<input type='hidden' name='strSchedulePopUpHidValue' id='strSchedulePopUpHidValue"+i+"' value='"+wb.getString(7)+"'>");
									        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
									        //br.append("<input type='hidden' name='reOrderFlag' id='reOrderFlag"+i+"' value='"+wb.getString(11)+"'>");
								            br.append("<tr>");
								            if(i == 0)
											{
								                br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiLabel'  width='8%'><b>"+wb.getString(12)+"<b></td>");
											}
								            else
								            {
								            	br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiLabel'  width='8%'></td>");
								            }
											br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiControl'  width='12%'><b><a value='' style='cursor:pointer;'onClick='callingPoPUp(this,"+i+");'title='Click here to Get PO Specification'><font color='blue'>"+wb.getString(1)+"</font></a></b></td>");
											br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'>"+totalGrandSchOne+"</td>");
											br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'>"+totalReceivedQty+"</font></b></td>");
											//br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'>"+wb.getString(3).split("\\#")[1]+"</td>");
										/*	br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleOne'   id='strScheduleOne"+i+"'   onblur='POScheduleUtilityFunction("+i+",1);' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");
											br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleTwo'   id='strScheduleTwo"+i+"'   onblur='POScheduleUtilityFunction("+i+",2);' value="+wb.getString(7).split("\\#")[4]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");
											br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleThree' id='strScheduleThree"+i+"' onblur='POScheduleUtilityFunction("+i+",3);' value="+wb.getString(7).split("\\#")[8]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");								
											br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleFour'  id='strScheduleFour"+i+"'  onblur='POScheduleUtilityFunction("+i+",4);' value="+wb.getString(7).split("\\#")[12]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");
										*/	br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiControl'  width='10%'><input type='text' name='strQrderQty'      id='strQrderQty"+i+"'      value="+totalGrandSchOne+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");	
											br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strOrdeCost'      id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+totalValue+"></td>");
										  	br.append("</tr>");  
									  	    
							        }
							        else
							        {
							        	strJonalLocation = wb.getString(12);
							        	
							        	strOrderQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[0]));
										strOrderQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[4]));  
										strOrderQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[8]));  
										strOrderQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[12]));  
										//System.out.println("strOrderQtyScheduleOne==>"+strOrderQtyScheduleOne+":::strOrderQtyScheduleTwo:::"+strOrderQtyScheduleTwo +":::strOrderQtyScheduleThree:::"+strOrderQtyScheduleThree+"::strOrderQtyScheduleFour:::"+strOrderQtyScheduleFour);
										
										cltamtSchOne             = Integer.parseInt(strOrderQtyScheduleOne);
										cltamtSchTwo             = Integer.parseInt(strOrderQtyScheduleTwo);
										cltamtSchThree           = Integer.parseInt(strOrderQtyScheduleThree);
										cltamtSchFour            = Integer.parseInt(strOrderQtyScheduleFour);
										
										totalGrandSchOne         = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandSchOne==>"+totalGrandSchOne);
										/********************************************************************************/
										strAcceptedQtyScheduleOne   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[2]));
										strAcceptedQtyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[6]));  
										strAcceptedQtyScheduleThree = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[10]));  
										strAcceptedQtyScheduleFour  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[14]));
										
										cltamtSchOne             	= Integer.parseInt(strAcceptedQtyScheduleOne);
										cltamtSchTwo             	= Integer.parseInt(strAcceptedQtyScheduleTwo);
										cltamtSchThree           	= Integer.parseInt(strAcceptedQtyScheduleThree);
										cltamtSchFour            	= Integer.parseInt(strAcceptedQtyScheduleFour);
										
										totalGrandAcceptedQty       = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										//System.out.println("totalGrandAcceptedQty==>"+totalGrandAcceptedQty);
										/********************************************************************************/
										strRejectedQtyScheduleOne    = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[3]));
										strRejectedQtyyScheduleTwo   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[7]));  
										strRejectedQtyScheduleThree  = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[11]));  
										strRejectedQtyScheduleFour   = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[15]));
										
										cltamtSchOne                 = Integer.parseInt(strRejectedQtyScheduleOne);
										cltamtSchTwo             	 = Integer.parseInt(strRejectedQtyyScheduleTwo);
										cltamtSchThree           	 = Integer.parseInt(strRejectedQtyScheduleThree);
										cltamtSchFour            	 = Integer.parseInt(strRejectedQtyScheduleFour);
										
										totalGrandRejectedQty    	 = cltamtSchOne + cltamtSchTwo + cltamtSchThree + cltamtSchFour;
										
										totalReceivedQty             = totalGrandAcceptedQty  + totalGrandRejectedQty;
										
										/********************************************************************************/
										strOrderValScheduleOne       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[1]));
										strOrderValScheduleTwo       = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[5]));  
										strOrderValThree             = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[9]));  
										strOrderValFour              = formatter.format(new BigDecimal(wb.getString(7).split("\\#")[13]));
										
										valSchOne                    = Double.parseDouble(strOrderValScheduleOne);
										valSchTwo             	     = Double.parseDouble(strOrderValScheduleTwo);
										valSchThree           	     = Double.parseDouble(strOrderValThree);
										valSchFour            	     = Double.parseDouble(strOrderValFour);
										
										
										 totalValue    	 = valSchOne + valSchTwo + valSchThree + valSchFour;
										
										//System.out.println("totalGrandRejectedQty==>"+totalGrandRejectedQty);
										//System.out.println("totalReceivedQty==>"+totalReceivedQty);
							        	
							        	   // Store Name (1)+ Demand Qty(2) + [PO_qty(3) # Tot_Issue_Qty(3)] +Tot_Issue Qty(4)+ [Active Qty(5) # Quarntine Qty(5)] + Re-Order Qty(6) +[Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [I] +  Budget Avl(8) + DDW_ID(9)+All Sub Store(Consolidated)[10] + Pipe Line Qty [11] + Location [12]
						        	    //                                                                                                                                         [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [II]
						        	 //                                                                                                                                            [Order Qty # Order Value #Accepted Qty # Rejected Qty ] SC [III]
						        	 //  
								        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9)+"^"+wb.getString(10)+"^"+wb.getString(11)+"^"+wb.getString(12);	
								        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
								        br.append("<input type='hidden' name='strSchedulePopUpHidValue' id='strSchedulePopUpHidValue"+i+"' value='"+wb.getString(7)+"'>");
							            br.append("<tr>");
							            br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiLabel'   width='8%'><b>"+wb.getString(12)+"<b></td>");
							            br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiControl'  width='12%'><b><a value='' style='cursor:pointer;'onClick='callingPoPUp(this,"+i+");'title='Click here to Get PO Specefication'><font color='blue'>"+wb.getString(1)+"</font></a></b></td>");
										br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'>"+totalGrandSchOne+"</td>");
										br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><a value='' style='cursor:pointer;'onClick='callingPoPUpTwo(this,"+i+");'title='Click here to Get PO Schedule Detail(s)'><font color='blue'>"+totalReceivedQty+"</font></a></b></td>");
										//br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'>"+wb.getString(3).split("\\#")[1]+"</td>");
										/*br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleOne'   id='strScheduleOne"+i+"'  onblur='POScheduleUtilityFunction("+i+",1);' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");
										br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleTwo'   id='strScheduleTwo"+i+"'  onblur='POScheduleUtilityFunction("+i+",2);' value="+wb.getString(7).split("\\#")[4]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");
										br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleThree' id='strScheduleThree"+i+"'onblur='POScheduleUtilityFunction("+i+",3);' value="+wb.getString(7).split("\\#")[8]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");								
										br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strScheduleFour'  id='strScheduleFour"+i+"' onblur='POScheduleUtilityFunction("+i+",4);' value="+wb.getString(7).split("\\#")[12]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");
									*/	br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiControl'  width='10%'><input type='text' name='strQrderQty'      id='strQrderQty"+i+"'     value="+totalGrandSchOne+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);' readonly></td>");	
										br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiControl'  width='9%'><input  type='text' name='strOrdeCost'      id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+totalValue+"></td>");
									  	br.append("</tr>");  
								  	    count++;
							        	
							        	
							        	
							        }						        
							        if(_poDeskGenerateTransFB.getStrMode().equals("2"))
								  	{	
							        	
							          cltamt = Double.parseDouble(formatter.format(new BigDecimal(Double.parseDouble(wb.getString(7).split("\\#")[1])+Double.parseDouble(wb.getString(7).split("\\#")[5])+Double.parseDouble(wb.getString(7).split("\\#")[9])+Double.parseDouble(wb.getString(7).split("\\#")[13]))));						
							          totalGrandCost = totalGrandCost + cltamt;
							          
							          totalQty = Double.parseDouble(wb.getString(7).split("\\#")[0])+Double.parseDouble(wb.getString(7).split("\\#")[4])+Double.parseDouble(wb.getString(7).split("\\#")[8])+Double.parseDouble(wb.getString(7).split("\\#")[12]);
							          grandTotalQty = grandTotalQty + totalQty;
							          //wb.getString(7).split("\\#")[0]
								  	}						  	    
						            i=i+1;					     
					   }
				}
				
				
				br.append("<tr>");			
//				br.append("<td colspan='1'  class='multiLabel'></td>");
//				br.append("<td colspan='1'  class='multiLabel'></td>");
//				br.append("<td colspan='1'  class='multiLabel'></td>");
//				br.append("<td colspan='1'  class='multiLabel'></td>");
//				br.append("<td colspan='1'  class='multiLabel'></td>");				
//				br.append("<td width='7%'  class='multiLabel'></td>");				
//				br.append("<td width='7%'  class='multiLabel'></td>");
//				br.append("<td width='7%'  class='multiLabel'></td>");
//				br.append("<td width='7%'  class='multiLabel'></td>");
				br.append("<td colspan='4' class='multiLabel'><div align='right'>Total Order Qty :: </div></td>");	
				if(_poDeskGenerateTransFB.getStrMode().equals("2"))
			  	{
				    br.append("<td colspan='1'  class='multiLabel'><input type='text' name='strTotalQrderQty' readonly  value='"+grandTotalQty+"' id='strTotalQrderQty'  class='txtFldNormal'></td>");
			  	}
				else
				{
					br.append("<td colspan='1'  class='multiLabel'><input type='text' name='strTotalQrderQty' readonly  value='0' id='strTotalQrderQty'  class='txtFldNormal'></td>");
				}
				br.append("<td colspan='1'  class='multiLabel'></td>");
				//br.append("<td colspan='1'  class='multiLabel'></td>");
				br.append("</tr>");
	
				
				br.append("</table>");
			
		} 
		catch (Exception _e) 
		{
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getImpContiRequestDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		if(_poDeskGenerateTransFB.getStrMode().equals("2"))
	  	{
			//System.out.println("In Modify 2:::"+br.toString()+"^^^2^^^"+totalGrandCost);
			String FinaltotalCost = formatter.format(new BigDecimal(totalGrandCost));  
		    return br.toString()+"^^^2^^^"+FinaltotalCost;
	  	}
		else
		{
			//System.out.println("In Generate:::"+br.toString()+"^^^1^^^0");
			return br.toString()+"^^^1^^^0";	
		}
		
		
	}
	
	public static String getItemDetails(PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		String strDivId = "";
		String strReqNo="";
		String strStores="";
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			
				poDeskGenerateTransVO.setStrItemId(_poDeskGenerateTransFB.getStrItemId());
				poDeskGenerateTransVO.setStrItemBrandIds(_poDeskGenerateTransFB.getStrItemBrandIds());
				poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());
				poDeskGenerateTransVO.setStrRequestId(_poDeskGenerateTransFB.getStrRequestId());
				poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrStoreId());
			

				poDeskGenerateTransBO.getItemDetails(poDeskGenerateTransVO);

				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());

				_poDeskGenerateTransFB.setWbItemDetail(poDeskGenerateTransVO.getWbItemDetail());

				wb = _poDeskGenerateTransFB.getWbItemDetail();
				
				//for (int nTmpJ = 0; nTmpJ < _poDeskGenerateTransFB
				//		.getStrRequestIds().replace("^", "#").split("#").length; nTmpJ++) {
				if (wb.size() != 0) {
					br.append("<table width='300' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr class='HEADER'>");
					
					//br.append("</tr>");
					//br.append("</table>");
					//br.append("<table width='700' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					//br.append("<tr>");
					br.append("<td width='79%' class='multiLabel'>CR/ Adm No.");
					br.append("</td><td width='25%' class='multiLabel'>Req. Qty");
					//br.append("</td><td width='25%' class='multiLabel'>Rate/Unit");
					br.append("</td>");
					br.append("<th align='right' colspan=2><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
					br.append("onClick='hide_popup_menu(\"divReqItemDtlId");
					//br.append(nTmpI);
					br.append("\");'></th></tr>");
					br.append("</table>");
					br.append("<table width='300' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					
					while (wb.next()) {
						br.append("<tr>");
						br.append("<td width='68%' class='multiControl'>");
						br.append(wb.getString(1));
						br.append("</td><td width='25%' class='multiControl'>");
						br.append(wb.getString(2));
						//br.append("</td><td width='29%' class='multiControl'>");
						//br.append(wb.getString(3));
						br.append("</td></tr>");
					}
					br.append("</table>");
					//br.append("</div>");
				} else {
					//br.append("<div id = 'divReqItemDtlId' class='popup'>");
					br.append("<table width='300' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr class='HEADER'>");
					br.append("<th align='right' colspan=4><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
					br.append("onClick='hide_popup_menu(\"divReqItemDtlId");
					//br.append(nTmpI);
					br.append("\");'></th>");
					br.append("</tr>");
					br.append("</table>");
					br.append("<table width='300' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr>");
					br.append("<td colspan='3'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
					br.append("</tr>");
					br.append("</table>");
				//	br.append("</div>");
				}
			//}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getItemDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	
	public static String getDeptItemDetails(PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		String strDivId = "";
		String strReqNo="";
		String strStores="";
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			
				poDeskGenerateTransVO.setStrItemId(_poDeskGenerateTransFB.getStrItemId());
				poDeskGenerateTransVO.setStrItemBrandIds(_poDeskGenerateTransFB.getStrItemBrandIds());
				poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());
				poDeskGenerateTransVO.setStrRequestId(_poDeskGenerateTransFB.getStrRequestId());
				poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrStoreId());
			

				poDeskGenerateTransBO.getDeptItemDetails(poDeskGenerateTransVO);

				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());

				_poDeskGenerateTransFB.setWbItemDetail(poDeskGenerateTransVO.getWbItemDetail());

				wb = _poDeskGenerateTransFB.getWbItemDetail();
				
				//for (int nTmpJ = 0; nTmpJ < _poDeskGenerateTransFB
				//		.getStrRequestIds().replace("^", "#").split("#").length; nTmpJ++) {
				if (wb.size() != 0) {
					br.append("<table class='table'>");
					br.append("<thead>");
					br.append("<tr>");
					//br.append("</tr>");
					//br.append("</table>");
					//br.append("<table width='700' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					//br.append("<tr>");
					br.append("<th style='border-top: white;'>Store");
					br.append("</th><th style='border-top: white;'>Req. Qty");
					//br.append("</th><th width='25%' class='multiLabel'>Rate/Unit");
					br.append("</th>");
					//br.append(nTmpI);
					br.append("</thead>");
					br.append("<tbody>");
					
					while (wb.next()) {
						br.append("<tr>");
						br.append("<td>");
						br.append(wb.getString(1));
						br.append("</td><td>");
						br.append(wb.getString(2));
						//br.append("</td><td width='29%' class='multiControl'>");
						//br.append(wb.getString(3));
						br.append("</td></tr>");
					}
					br.append("</tbody></table>");
					//br.append("</div>");
				} else {
					//br.append("<div id = 'divReqItemDtlId' class='popup'>");
					br.append("<table width='300' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr class='HEADER'>");
					br.append("<th align='right' colspan=4><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
					br.append("onClick='hide_popup_menu(\"divReqItemDtlId");
					//br.append(nTmpI);
					br.append("\");'></th>");
					br.append("</tr>");
					br.append("</table>");
					br.append("<table width='300' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr>");
					br.append("<td colspan='3'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
					br.append("</tr>");
					br.append("</table>");
				//	br.append("</div>");
				}
			//}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getItemDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	
	public static String getSupplierDetails(PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		String strDivId = "";
		String strReqNo="";
		String strStores="";
		
		int idx=Integer.parseInt(_poDeskGenerateTransFB.getStrIndex());
		idx++;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			
			poDeskGenerateTransVO.setStrItemBrandIds(_poDeskGenerateTransFB.getStrItemBrandIds());
			poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());
			poDeskGenerateTransVO.setStrRequestId(_poDeskGenerateTransFB.getStrRequestIds());
			poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrStoreId());
			poDeskGenerateTransVO.setStrItemCat(_poDeskGenerateTransFB.getStrItemCat());
			poDeskGenerateTransVO.setStrPOTypeId(_poDeskGenerateTransFB.getStrPOTypeId());
			poDeskGenerateTransVO.setStrContractType(_poDeskGenerateTransFB.getStrContractType());
			poDeskGenerateTransVO.setStrSupplierId(_poDeskGenerateTransFB.getStrSupplierId());
			poDeskGenerateTransVO.setStrInventoryUnitId(_poDeskGenerateTransFB.getStrTempUnit());
				poDeskGenerateTransBO.setSupplierDetailsBasedOnRC(poDeskGenerateTransVO);

				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());

				br.append(_poDeskGenerateTransFB.getStrDivId()+"#");
				if (poDeskGenerateTransVO.getSupplierDetail().length() != 0) {
						br.append("<td width='37%' class='multiControl'  colspan=3></td>");	
						br.append("<td width='12%' class='multiControl' id='tdstrDSuppId"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+ "'>");						
						br.append("<select name=strDSuppId id ='CMBSUP"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+"' onchange='checkOrderQty(this)' >"+ poDeskGenerateTransVO.getSupplierDetail()+ "</select>");
						br.append("</td><td width='6%' class='multiControl' id='tdstrDOrderQty"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+ "'>");
						br.append("<input type=text autocomplete=off id ='QTY"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+"' class=txtFldMin onkeypress='return validateData(event,5);' onkeyup='calcTotalRate(this,"+(idx-1)+");' maxlength=7 name=strDOrderQty >");
						br.append("</td><td width='5%' class='multiControl' id='tdstrDOrderQtyUnitId"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+ "'>");
						
						/********** Calling BO Method to Get Unit *************/
						poDeskGenerateTransBO.setUnitValues(poDeskGenerateTransVO);

						br.append("<select name=strDOrderQtyUnitId id ='CMBUNIT"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+"' onchange='checkOrderQty(this)' >"+ poDeskGenerateTransVO.getStrRateUnitValues()+ "</select>");
						br.append("</td><td width='6%' class='multiControl' id='tdstrDRateUnit"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+ "'>");
						br.append("<input type=text autocomplete=off class=txtFldMin id ='RATE"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+"' onkeypress='return validateData(event,5);' maxlength=7 name=strDRateUnit disabled=true>");
						br.append("</td><td width='6%' class='multiControl' id='tdstrDTax"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+ "'>");
						br.append("<input type=text class=txtFldMin onkeypress='return validateData(event,7);' maxlength=5 name=strDTax value=''   id ='TAX"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+"'>");
						br.append("</td><td width='10%' class='multiControl'id='tdstrDTotalRate"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+ "' >");
						br.append("<input type=text autocomplete=off class=txtFldNormal id ='TRATE"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+"' onkeypress='return validateData(event,5);' maxlength=7 name=strDTotalRate disabled=true>");
						br.append("</td><td width='8%' class='multiControl'  >");
						br.append("<input type=text class=txtFldNormal onkeypress='return validateData(event,5);' value=''  name=strDShelfLife  id ='SLIFE"+_poDeskGenerateTransFB.getStrItemBrandIds()+""+(idx)+"'>");
						br.append("</td><td width='10%' class='multiControl'  >");
						br.append("<div  id='addSup"+idx+"'><img style='display:none' src='../../hisglobal/images/Add_Supplier.png' id ='BTN"+_poDeskGenerateTransFB+""+(idx)+"' title='Check List' style='cursor: pointer;' ");
						br.append("title='Add Supplier' onclick='addSuppiler(this,0)'></div>");
						br.append("</td>");
						
				} else {
					br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'>");
					br.append("<tr class='HEADER'>");
					br.append("<th align='right' colspan=4><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
					br.append("onClick='hideDiv('divSuppId');'");
					br.append("'></th>");
					br.append("</tr>");
					br.append("</table>");
					br.append("<table width='500' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr>");
					br.append("<td colspan='3'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
					br.append("</tr>");
					br.append("</table>");
					br.append("</div>");
				}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getSupplierDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	
	public static String getSupplierWiseCompiledData(PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		String tmpsupp = "0",compData=null,supp="";
		double tmp = 0;
		
		try 
		{
			System.out.println("------------------- PODeskGenerateTransHLP.getSupplierWiseCompiledData-----------------------");
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
	
			poDeskGenerateTransVO.setStrDOrderQty(_poDeskGenerateTransFB.getStrDOrderQty());
			poDeskGenerateTransVO.setStrItemBrandIds(_poDeskGenerateTransFB.getStrItemBrandIds());
			poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());
			poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrStoreId());
			poDeskGenerateTransVO.setStrItemCat(_poDeskGenerateTransFB.getStrItemCat());
			poDeskGenerateTransVO.setStrPOTypeId(_poDeskGenerateTransFB.getStrPOTypeId());
			poDeskGenerateTransVO.setStrSupplierId(_poDeskGenerateTransFB.getStrSupplierId());
			poDeskGenerateTransVO.setStrDOrderQtyUnitId(_poDeskGenerateTransFB.getStrTempUnit().split(","));
			poDeskGenerateTransVO.setStrtQty(_poDeskGenerateTransFB.getStrtQty());
			poDeskGenerateTransVO.setStrRateUnitValues(_poDeskGenerateTransFB.getStrRateUnitValues());
			poDeskGenerateTransVO.setStrDRate(_poDeskGenerateTransFB.getStrDRate());
			poDeskGenerateTransVO.setStrItemId(_poDeskGenerateTransFB.getStrItemId());
			poDeskGenerateTransVO.setStrDTax(_poDeskGenerateTransFB.getStrDTax());
			poDeskGenerateTransVO.setStrDPackSize(_poDeskGenerateTransFB.getStrDPackSize());
			
			//System.out.println("--PACK_SIZE---->>"+_poDeskGenerateTransFB.getStrDPackSize());
			//if(poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("21"))
			//{
			//	poDeskGenerateTransVO.setStrFromDate(_poDeskGenerateTransFB.getStrFromDate());
			//	poDeskGenerateTransVO.setStrToDate(_poDeskGenerateTransFB.getStrToDate());
			//}
			poDeskGenerateTransVO.setStrPODate(_poDeskGenerateTransFB.getStrPODate());
			poDeskGenerateTransVO.setStrGroupId(_poDeskGenerateTransFB.getStrGroupId());
			if(poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("22"))
				poDeskGenerateTransVO.setStrDMRP(_poDeskGenerateTransFB.getStrDMRP());
			
			
			poDeskGenerateTransBO.getSupplierWiseCompiledData(poDeskGenerateTransVO);
				
				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());
				
				poDeskGenerateTransBO.getComponentDetail(poDeskGenerateTransVO);
				
				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());

				_poDeskGenerateTransFB.setStrComponentID(poDeskGenerateTransVO
						.getStrComponentID());
				_poDeskGenerateTransFB.setStrComponentName(poDeskGenerateTransVO
						.getStrComponentName());
				_poDeskGenerateTransFB.setStrComponentValue(poDeskGenerateTransVO
						.getStrComponentValue());
				compData = PODeskGenerateTransHLP
						.getComponentDetail(_poDeskGenerateTransFB);
				
				wb = poDeskGenerateTransVO.getWbTmpPoDtl();
				//br.append(_poDeskGenerateTransFB.getStrDivId()+"#");
				if (wb.size() != 0) 
				{
					br.append("<table class='TABLEWIDTH' align=center border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr class='HEADER'>");
					br.append("<td width='25%' class='multiLabel'>Generic/Item/Manufacture Name");
					br.append("<td width='7%' class='multiLabel'>Item Code");
					br.append("</td><td width='7%' class='multiLabel'>PO Date");
					br.append("</td><td width='7%' class='multiLabel'><div align='right'>Order Qty</div>");
					br.append("</td><td width='10%' class='multiLabel'><div align='right'>Rate/Unit</div>");
					br.append("</td><td width='12%' class='multiLabel'><div align='right'>Rate/Unit with Tax(%Tax)</div>");
					br.append("</td><td width='8%' class='multiLabel'><div align='right'>RC Price</div>");
					br.append("</td><td width='9%' class='multiLabel'><div align='right'>PO Price**</div>");
					if(poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("22"))
					{	
						br.append("</td><td width='10%' class='multiLabel'><div align='right'>MRP</div>");
					}
					br.append("</td><td width='10%' class='multiLabel'><div align='right'>Pack Size </div>");
					br.append("<input type='hidden' name='strFromDate' value='"+poDeskGenerateTransVO.getStrFromDate()+"'><input type='hidden' name='strToDate' value='"+poDeskGenerateTransVO.getStrToDate()+"'></td></tr>");
					br.append("</table>");
					br.append("<table class='TABLEWIDTH' align=center border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					
					while (wb.next())
					{
						_poDeskGenerateTransFB.setStrExclTax(wb.getString(13).replace("^", "#").split("#")[1]);
						if(tmpsupp.equals(wb.getString(2)))
						{
							/*
							 *  1.Supplier Name
							 *  2.Supplier Id
							 *  3.Item Name
							 *  4.PO Date
							 *  5.Order Qty
							 *  6.Rate
							 *  7.Rate Wth Tax( 9.0(2%))
							 *  8.PO Value
							 *  9.Item Id
							 * 10.Brand Id
							 * 11.Unit Id
							 * 12.Tax
							 * 13.Days
							 * 14.Supplier Phone @ Email
							 * 15.Item Id
							 * 16.MRP
							 * 17.PACK_SIZE
							 * 18.PO_DATE
							 * 
							 * */
							br.append("<tr>");
							br.append("<td width='25%' class='multiControl'><div align='left'>");
							br.append("<input type='hidden' name='strHiddenValue' value='"+ wb.getString(2) + "^"+ wb.getString(4) + "^"+ wb.getString(5) + "^"+ wb.getString(6) + "^"+ wb.getString(7) + "^"+ wb.getString(8) + "^"+ wb.getString(9) + "^"+ wb.getString(10) + "^"+ wb.getString(11) +"^"+ wb.getString(12) +"^"+ poDeskGenerateTransVO.getTmpPONO() +"^"+ wb.getString(13) +"^"+ wb.getString(16) + "^"+ wb.getString(17) + "^"+ wb.getString(18)+ "' >");
							br.append(wb.getString(3));
							br.append("</td><td width='7%' class='multiControl'><input type='hidden' name='strGroupId' value="+poDeskGenerateTransVO.getStrGroupId()+"><div align='center'>");
							br.append(wb.getString(15));
							br.append("</div></td><td width='7%' class='multiControl'><input type='hidden' name = 'strPODate' value='"+poDeskGenerateTransVO.getStrPODate()+"'>");
							br.append(poDeskGenerateTransVO.getStrPODate());
							br.append("</td><td width='7%' class='multiControl'><div align='right'>");
							br.append(wb.getString(5));
							br.append("</div></td><td width='10%' class='multiControl'><div align='right'>");
							
							if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								br.append(wb.getString(6));
							else
								br.append(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0+"("+wb.getString(6)+")");
							br.append("</div></td><td width='12%' class='multiControl'><div align='right'>");
							if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								br.append(wb.getString(7));
							else
								br.append(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round(((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0);
								//br.append(Math.round((((Double.parseDouble(wb.getString(6)))))+((Double.parseDouble(wb.getString(6))*100)/105)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0);
							br.append("</div></td><td width='8%' class='multiControl'><div align='right'>");
							br.append(Math.round((Double.parseDouble(wb.getString(5))*Double.parseDouble(wb.getString(6)))));
							br.append("</div></td><td width='9%' class='multiControl'><div align='right'>");
							if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								br.append(Double.parseDouble(wb.getString(8)));
							else
								br.append((Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round(((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0)*(Double.parseDouble(wb.getString(5))));
								//br.append(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round((((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0)*Math.round(Double.parseDouble(wb.getString(5))*100.0)/100.0);
							if(poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("22"))
							{
								br.append("</div></td><td width='10%' class='multiControl'><div align='right'>");
								br.append(wb.getString(16));
							}
							br.append("</div></td><td width='10%' class='multiControl'><div align='right'>");
							br.append(wb.getString(17));
							br.append("</div></td></tr>");
							if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								if(wb.getString(8) != null && !wb.getString(8).equals(""))
									tmp+=Double.parseDouble(wb.getString(8));
								else
									tmp+=0.0;
							else
								tmp+=(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round(((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0)*(Double.parseDouble(wb.getString(5)));
						}
						else
						{
							if(!wb.isFirst())
							{
								br.append("<tr class='HEADER'><td width = '100%' colspan=11 class = 'CONTROL'><input type='hidden' name='supptotamt' value='"+(Math.round(tmp * 100.0))/100.0+"'><div align=right>Total PO Cost : "+(Math.round(tmp * 100))/100.0+" </div></td></tr>");
								br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'cellspacing=1px><tr><td class='TITLE' colspan='10'>");
								br.append("<div id='divComponentPlusID"+tmpsupp +"' style='display: none;' align='left'><img src='../../hisglobal/images/plus.gif' onclick='hideDiv(\"divComponentPlusID"+ tmpsupp+"\"),showDiv(\"divComponentMinusID"+ tmpsupp+"\"),showDiv(\"divComponentDetails"+tmpsupp+"\");' style='cursor: pointer;'> Component Details of Supplier : "+ supp+"</div>");
								br.append("<div id='divComponentMinusID"+ tmpsupp +"' style='display: none;' align='left'><img src='../../hisglobal/images/minus.gif' onclick='hideDiv(\"divComponentMinusID"+ tmpsupp+"\"),hideDiv(\"divComponentDetails"+ tmpsupp+"\");' style='cursor: pointer;'> Component Details of Supplier : "+ supp+"</div>");
								br.append("</td></tr></table><div id='divComponentDetails"+ tmpsupp +"' style='display: none;'>"+compData+" </div>");
							}
							br.append("</table>");
							br.append("<table class='TABLEWIDTH' align=center border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
							br.append("<tr class='HEADER'><td width = '90%' colspan=10 class = 'CONTROL'><a href='#' onclick='showDiv(\"divComponentMinusID"+ wb.getString(2) +"\");showDiv(\"divComponentDetails"+ wb.getString(2) +"\");'><input type='hidden' name='strDPhoneEmail' value='"+ wb.getString(14) + "' ><input type='hidden' name='strDLstSupplierInterface' value="+ wb.getString(17) + " ><input type='hidden' name='strDLstSupplierId' value='"+ wb.getString(2) + "' ><input type='hidden' name='strDExpectedDeliveryDate' value='"+ wb.getString(15) + "' ><div align=left>"+wb.getString(1)+" (Expected Delivery Days :"+ (wb.getString(13)==null?"NA":wb.getString(13).replace("^", "#").split("#")[0]) +" )</div></a></td></tr><tr>");
							br.append("<td width='25%' class='multiControl'><div align='left'>");
							br.append("<input type='hidden' name='strHiddenValue' value='"+ wb.getString(2) + "^"+ wb.getString(4) + "^"+ wb.getString(5) + "^"+ wb.getString(6) + "^"+ wb.getString(7) + "^"+ wb.getString(8) + "^"+ wb.getString(9) + "^"+ wb.getString(10) +  "^"+ wb.getString(11) +"^"+ wb.getString(12) +"^"+ poDeskGenerateTransVO.getTmpPONO() +"^"+ wb.getString(13) + "^"+ wb.getString(16) + "^"+ wb.getString(17)+ "^"+ wb.getString(18) + "' >");
							br.append(wb.getString(3));
							br.append("</td><td width='7%' class='multiControl'><input type='hidden' name='strGroupId' value="+poDeskGenerateTransVO.getStrGroupId()+"><div align='center'>");
							br.append(wb.getString(15));
							br.append("</div></td><td width='7%' class='multiControl'><input type='hidden' name = 'strPODate' value='"+poDeskGenerateTransVO.getStrPODate()+"'>");
							br.append(poDeskGenerateTransVO.getStrPODate());
							br.append("</td><td width='7%' class='multiControl'><div align='right'>");
							br.append(wb.getString(5));
							br.append("</div></td><td width='10%' class='multiControl'><div align='right'>");
							if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								br.append(wb.getString(6));
							else
								br.append(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0+"("+wb.getString(6)+")");
							br.append("</div></td><td width='12%' class='multiControl'><div align='right'>");
							if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								br.append(wb.getString(7));
							else
								br.append(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round(((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0);
							br.append("</div></td><td width='8%' class='multiControl'><div align='right'>");
							br.append(Math.round((Double.parseDouble(wb.getString(5))*Double.parseDouble(wb.getString(6)))));
							br.append("</div></td><td width='9%' class='multiControl'><div align='right'>");
							if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								br.append(Double.parseDouble(wb.getString(8)));
							else
								br.append((Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round(((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0)*(Double.parseDouble(wb.getString(5))));
								//br.append(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round((((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0)*Math.round(Double.parseDouble(wb.getString(5))*100.0)/100.0);
							if(poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("22"))
							{
								br.append("</div></td><td width='10%' class='multiControl'><div align='right'>");
								br.append(wb.getString(16));
							}
							br.append("</div></td><td width='10%' class='multiControl'><div align='right'>");
							br.append(wb.getString(17));
							br.append("</div></td></tr>");
							
							if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								if(wb.getString(8) != null && !wb.getString(8).equals(""))
									tmp+=Double.parseDouble(wb.getString(8));
								else
									tmp+=0.0;
							else
								tmp+=(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round(((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0)*(Double.parseDouble(wb.getString(5)));
								
						}
						tmpsupp = wb.getString(2);//supplier id
						supp=wb.getString(1);//supplier name
					}
					br.append("<tr class='HEADER'><td colspan=6 class = 'CONTROL'><div align='left'></div></td><td colspan=4 class = 'CONTROL'><input type='hidden' name='supptotamt' value='"+(Math.round(tmp * 100.0))/100.0+"'><div align=right>Total PO Cost : "+(Math.round(tmp * 100.0))/100.0+" </div></td></tr>");
					br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'cellspacing=1px><tr><td class='TITLE' colspan='8'>");
					br.append("<div id='divComponentPlusID"+ tmpsupp +"' style='display: none;' align='left'><img src='../../hisglobal/images/plus.gif' onclick='hideDiv(\"divComponentPlusID"+ tmpsupp+"\"),showDiv(\"divComponentMinusID"+ tmpsupp+"\"),showDiv(\"divComponentDetails"+ tmpsupp+"\");' style='cursor: pointer;'> Component Details of Supplier : "+ supp +"</div>");
					br.append("<div id='divComponentMinusID"+ tmpsupp +"' style='display: none;' align='left'><img src='../../hisglobal/images/minus.gif' onclick='hideDiv(\"divComponentMinusID"+ tmpsupp+"\"),showDiv(\"divComponentPlusID"+ tmpsupp+"\"),hideDiv(\"divComponentDetails"+ tmpsupp+"\");' style='cursor: pointer;'> Component Details of Supplier : "+ supp +"</div>");
					br.append("</td></tr></table><div id='divComponentDetails"+ tmpsupp +"' style='display: none;'>"+compData+" </div>");
					br.append("</table>");
				} else {
					br.append("<table class='TABLEWIDTH' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr>");
					br.append("<td colspan='3'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
					br.append("</tr>");
					br.append("</table>");
				}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getSupplierDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		_poDeskGenerateTransFB.setTmpPONO(poDeskGenerateTransVO.getTmpPONO());
		return br.toString();
	}
	
	public static String getSupplierWiseCompiledDataBS(PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		String tmpsupp = "0",compData=null,supp="";
		double tmp = 0;
		
		try {
			
			System.out.println("----------- PODeskGenerateTransHLP . getSupplierWiseCompiledDataBS -----------");
			
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
	
			poDeskGenerateTransVO.setStrDOrderQty(_poDeskGenerateTransFB.getStrDOrderQty());
			poDeskGenerateTransVO.setStrItemBrandIds(_poDeskGenerateTransFB.getStrItemBrandIds());
			poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());
			poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrStoreId());
			poDeskGenerateTransVO.setStrItemCat(_poDeskGenerateTransFB.getStrItemCat());
			poDeskGenerateTransVO.setStrPOTypeId(_poDeskGenerateTransFB.getStrPOTypeId());
			poDeskGenerateTransVO.setStrSupplierId(_poDeskGenerateTransFB.getStrSupplierId());
			poDeskGenerateTransVO.setStrDOrderQtyUnitId(_poDeskGenerateTransFB.getStrTempUnit().split(","));
			poDeskGenerateTransVO.setStrtQty(_poDeskGenerateTransFB.getStrtQty());
			poDeskGenerateTransVO.setStrRateUnitValues(_poDeskGenerateTransFB.getStrRateUnitValues());
			poDeskGenerateTransVO.setStrDRate(_poDeskGenerateTransFB.getStrDRate());
			poDeskGenerateTransVO.setStrItemId(_poDeskGenerateTransFB.getStrItemId());
			poDeskGenerateTransVO.setStrDTax(_poDeskGenerateTransFB.getStrDTax());
			poDeskGenerateTransVO.setStrDPackSize(_poDeskGenerateTransFB.getStrDPackSize());
			//if(poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("21"))
			//{
			//	poDeskGenerateTransVO.setStrFromDate(_poDeskGenerateTransFB.getStrFromDate());
			//	poDeskGenerateTransVO.setStrToDate(_poDeskGenerateTransFB.getStrToDate());
			//}
			poDeskGenerateTransVO.setStrPODate(_poDeskGenerateTransFB.getStrPODate());
			poDeskGenerateTransVO.setStrGroupId(_poDeskGenerateTransFB.getStrGroupId());
			if(poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("22"))
			
				poDeskGenerateTransVO.setStrDMRP(_poDeskGenerateTransFB.getStrDMRP());
			    poDeskGenerateTransBO.getSupplierWiseCompiledData(poDeskGenerateTransVO);
				
				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());
				
				poDeskGenerateTransBO.getComponentDetail(poDeskGenerateTransVO);
				
				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());

				_poDeskGenerateTransFB.setStrComponentID(poDeskGenerateTransVO
						.getStrComponentID());
				_poDeskGenerateTransFB.setStrComponentName(poDeskGenerateTransVO
						.getStrComponentName());
				_poDeskGenerateTransFB.setStrComponentValue(poDeskGenerateTransVO
						.getStrComponentValue());
				compData = PODeskGenerateTransHLP.getComponentDetail(_poDeskGenerateTransFB);
				
				wb = poDeskGenerateTransVO.getWbTmpPoDtl();
				//br.append(_poDeskGenerateTransFB.getStrDivId()+"#");
				if (wb.size() != 0) 
				{
					br.append("<table class='table'>");
					br.append("<thead>");
					br.append("<tr>");
					br.append("<th style='width: 36%;'>Generic/Item/Manufacture Name");
					br.append("<th style='width: 7%;'>Item Code");
					br.append("</th><th style='width: 7%;'>PO Date");
					br.append("</th><th style='width: 7%;'>Order Qty");
					br.append("</th><th style='width: 7%;'>Rate/Unit");
					br.append("</th><th style='width: 15%;'>Rate/Unit with Tax(%Tax)");
					br.append("</th><th style='width: 7%;'>Value <br>Wthout TAX");
					br.append("</th><th style='width: 7%;'>Value <br>Wth TAX");
					if(poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("22"))
					{
					    br.append("</th><th style='width: 7%;'>MRP");
					}
				    br.append("</th><th style='width: 7%;'>Pack Size");
					br.append("<input type='hidden' name='strFromDate' value='"+poDeskGenerateTransVO.getStrFromDate()+"'><input type='hidden' name='strToDate' value='"+poDeskGenerateTransVO.getStrToDate()+"'></th></tr>");
					br.append("</thead>");
					br.append("<tbody>");
					
					while (wb.next()) 
					{
						
						 /*
				           1. Supp Name
				           2. Supplier Id
				           3. Item name
				           4. PO Date 
				           5. Order Qty
				           6. Rate
				           7. RATE_TAX e.g: 24.75(10.00%)
				           8. Total PO Value
				           9. ITEM_ID
				          10. BRAND_ID
				          11. ORDER QTY UNIT ID
				          12. TAX %
				          13. HSTNUM_DELIVERY_DAYS ^ hstnum_ratecontract_id 
				          14. Supplier Phone No ^ E-Mail
				          15. Item COde
				          16. MRP
				          17. PACK SIZE
				          18. RATE_WTH_TAX_VALUE
				          19. Delivery Date				           
				        */
												
						System.out.println("Hidden_Val -> supp_id ^ PO_Date ^ Order Qty ^ Rate ^ Rate Wuth Tax ^ PO_Value ^ ItemId ^ Barnd_ID ^ Order_Qty_unit ^ TAX ^ TEMP_PO_NO ^  Delivery Days ^ Rate Contract Id ^ MRP ^ PACK_SIZE ^ Delivery Date *");
						_poDeskGenerateTransFB.setStrExclTax(wb.getString(13).replace("^", "#").split("#")[1]);
						/***********************  Supplier Based Group   *****************************/
						if(tmpsupp.equals(wb.getString(2)))
						{
							br.append("<tr>");
							br.append("<td style='width: 36%;'>");
							br.append("<input type='hidden' name='strHiddenValue' value='"+ wb.getString(2) + "^"+ wb.getString(4) + "^"+ wb.getString(5) + "^"+ wb.getString(6) + "^"+ wb.getString(18) + "^"+ wb.getString(8) + "^"+ wb.getString(9) + "^"+ wb.getString(10) + "^"+ wb.getString(11) +"^"+ wb.getString(12) +"^"+ poDeskGenerateTransVO.getTmpPONO() +"^"+ wb.getString(13)  + "^"+ wb.getString(16) + "^"+ wb.getString(17) + "^"+ wb.getString(19) +"' ><input type='hidden' name='strDLstSupplierInterface' value="+ wb.getString(17) + " >");
							br.append(wb.getString(3));
							br.append("</td><td style='width: 7%;'><input type='hidden' name='strGroupId' value="+poDeskGenerateTransVO.getStrGroupId()+">");
							br.append(wb.getString(15));
							br.append("</td><td style='width: 7%;'><input type='hidden' name = 'strPODate' value='"+poDeskGenerateTransVO.getStrPODate()+"'>");
							br.append(poDeskGenerateTransVO.getStrPODate());
							br.append("</td><td style='width: 7%;'>");
							br.append(wb.getString(5));                 // Order Qty 
							br.append("</td><td style='width: 7%;'>");
							
							//if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
							//{
								br.append(wb.getString(6));            // Rate Without Tax
							//}
							//else
							//{
							//	br.append(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0+"("+wb.getString(6)+")");
							//}
							br.append("</td><td style='width: 15%;'>");
							//if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
							//{
								br.append(wb.getString(7));          // Rate With Tax  24.75(10.00%)
							//}
							//else
							//{
							//	br.append(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round(((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0);
							//}
							
							br.append("</td><td style='width: 7%;'>");  //  Value Without Tax
							br.append(Math.round((Double.parseDouble(wb.getString(5))*Double.parseDouble(wb.getString(6)))));
							br.append("</td><td style='width: 7%;'>");
							//if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
							//{
								br.append(Double.parseDouble(wb.getString(8)));  //  Value With Tax
							//}
							//else
							//{
							//	br.append((Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round(((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0)*(Double.parseDouble(wb.getString(5))));
							//}	
								//br.append(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round((((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0)*Math.round(Double.parseDouble(wb.getString(5))*100.0)/100.0);
							if(poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("22"))
							{
								br.append("</td><td style='width: 7%;'>");
								br.append(wb.getString(16));     //  MRP Value
							}
							br.append("</td><td style='width: 7%;'>");
							br.append(wb.getString(17));        //  PACK SIZE
							br.append("</td></tr>");
							//if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								if(wb.getString(8) != null && !wb.getString(8).equals(""))
									tmp+=Double.parseDouble(wb.getString(8));
								else
									tmp+=0.0;
							//else
							//	tmp+=(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round(((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0)*(Double.parseDouble(wb.getString(5)));
						}
						else
						{
							if(!wb.isFirst())
							{
								br.append("<tr><td><input type='hidden' name='supptotamt' value='"+(Math.round(tmp * 100.0))/100.0+"'><div align=right>Total PO Cost : "+(Math.round(tmp * 100))/100.0+" </div></td></tr>");
								br.append("<div id='divComponentPlusID"+tmpsupp +"' style='display: none;' align='left'><img src='../../hisglobal/images/plus.gif' onclick='hideDiv(\"divComponentPlusID"+ tmpsupp+"\"),showDiv(\"divComponentMinusID"+ tmpsupp+"\"),showDiv(\"divComponentDetails"+tmpsupp+"\");' style='cursor: pointer;'> Component Details of Supplier : "+ supp+"</div>");
								br.append("<div id='divComponentMinusID"+ tmpsupp +"' style='display: none;' align='left'><img src='../../hisglobal/images/minus.gif' onclick='hideDiv(\"divComponentMinusID"+ tmpsupp+"\"),hideDiv(\"divComponentDetails"+ tmpsupp+"\");' style='cursor: pointer;'> Component Details of Supplier : "+ supp+"</div>");
								br.append("</td></tr><div id='divComponentDetails"+ tmpsupp +"' style='display: none;'>"+compData+" </div>");
							}
							
							br.append("<tr><td><a href='#' onclick='showDiv(\"divComponentMinusID"+ wb.getString(2) +"\");showDiv(\"divComponentDetails"+ wb.getString(2) +"\");'><input type='hidden' name='strDPhoneEmail' value='"+ wb.getString(14) + "' ><input type='hidden' name='strDLstSupplierId' value='"+ wb.getString(2) + "' ><input type='hidden' name='strDExpectedDeliveryDate' value='"+ wb.getString(15) + "' >"+wb.getString(1)+" (Expected Delivery Days :"+ (wb.getString(13)==null?"NA":wb.getString(13).replace("^", "#").split("#")[0]) +" )</a></td></tr><tr>");
							br.append("<td style='width: 36%;'>");
							br.append("<input type='hidden' name='strHiddenValue' value='"+ wb.getString(2) + "^"+ wb.getString(4) + "^"+ wb.getString(5) + "^"+ wb.getString(6) + "^"+ wb.getString(7) + "^"+ wb.getString(8) + "^"+ wb.getString(9) + "^"+ wb.getString(10) +  "^"+ wb.getString(11) +"^"+ wb.getString(12) +"^"+ poDeskGenerateTransVO.getTmpPONO() +"^"+ wb.getString(13)  + "^"+ wb.getString(16) + "^"+ wb.getString(17) + "^"+ wb.getString(18) + "' ><input type='hidden' name='strDLstSupplierInterface' value="+ wb.getString(17) + " >");
							br.append(wb.getString(3));
							br.append("</td><td style='width: 7%;'><input type='hidden' name='strGroupId' value="+poDeskGenerateTransVO.getStrGroupId()+">");
							br.append(wb.getString(15));
							br.append("</td><td style='width: 7%;'><input type='hidden' name = 'strPODate' value='"+poDeskGenerateTransVO.getStrPODate()+"'>");
							br.append(poDeskGenerateTransVO.getStrPODate());
							br.append("</td><td style='width: 7%;'>");
							br.append(wb.getString(5));
							br.append("</td><td style='width: 7%;'>");
							//if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								br.append(wb.getString(6));
							//else
							//	br.append(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0+"("+wb.getString(6)+")");
							br.append("</td><td style='width: 15%;'>");
							//if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								br.append(wb.getString(7));
							//else
							//	br.append(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round(((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0);
							br.append("</td><td style='width: 7%;'>");
							br.append(Math.round((Double.parseDouble(wb.getString(5))*Double.parseDouble(wb.getString(6)))));
							br.append("</td><td style='width: 7%;'>");
							//if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								br.append(Double.parseDouble(wb.getString(8)));
							//else
							//	br.append((Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round(((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0)*(Double.parseDouble(wb.getString(5))));
								//br.append(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round((((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0)*Math.round(Double.parseDouble(wb.getString(5))*100.0)/100.0);
							if(poDeskGenerateTransVO.getStrPOTypeId().substring(0,2).equals("22"))
							{
								br.append("</td><td style='width: 7%;'>");
								br.append(wb.getString(16));
							}
							br.append("</td><td style='width: 7%;'>");
							br.append(wb.getString(17));
							br.append("</td></tr>");
							//System.out.println("wb.getString(8)"+wb.getString(8));
							if(!wb.getString(13).replace("^", "#").split("#")[1].equals("1"))
								if(wb.getString(8) != null && !wb.getString(8).equals(""))
									tmp+=Double.parseDouble(wb.getString(8));
								else
									tmp+=0.0;
							else
								tmp+=(Math.round(((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0 + Math.round(((((Double.parseDouble(wb.getString(6))*100)/105)*100.0)/100.0)*(Double.parseDouble(wb.getString(12))/100)*100.0)/100.0)*(Double.parseDouble(wb.getString(5)));
								
						}
						tmpsupp = wb.getString(2);//supplier id
						supp=wb.getString(1);//supplier name
					}
					
					br.append("</tbody>");
					br.append("</table>");
					br.append("<div class='row'><div class='col-sm-12' align='right'><input type='hidden' name='supptotamt' value='"+(Math.round(tmp * 100.0))/100.0+"'>Total PO Cost : "+(Math.round(tmp * 100.0))/100.0+" </div></div>");
					
									
					
				} else {
					br.append("<table class='TABLEWIDTH' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr>");
					br.append("<td colspan='3'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
					br.append("</tr>");
					br.append("</table>");
				}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getSupplierDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		_poDeskGenerateTransFB.setTmpPONO(poDeskGenerateTransVO.getTmpPONO());
		return br.toString();
	}
	
	public static String getOtherData(PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		String tmpsupp = "0",compData=null,supp="";
		double tmp = 0;
		
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
	
			poDeskGenerateTransVO.setStrDOrderQty(_poDeskGenerateTransFB.getStrDOrderQty());
			poDeskGenerateTransVO.setStrItemBrandIds(_poDeskGenerateTransFB.getStrItemBrandIds());
			poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());
			poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrStoreId());
			poDeskGenerateTransVO.setStrItemCat(_poDeskGenerateTransFB.getStrItemCat());
			poDeskGenerateTransVO.setStrPOTypeId(_poDeskGenerateTransFB.getStrPOTypeId());
			poDeskGenerateTransVO.setStrSupplierId(_poDeskGenerateTransFB.getStrSupplierId());
			poDeskGenerateTransVO.setStrDOrderQtyUnitId(_poDeskGenerateTransFB.getStrTempUnit().split(","));
			poDeskGenerateTransVO.setStrtQty(_poDeskGenerateTransFB.getStrtQty());
			poDeskGenerateTransVO.setStrRateUnitValues(_poDeskGenerateTransFB.getStrRateUnitValues());
			poDeskGenerateTransVO.setStrDRate(_poDeskGenerateTransFB.getStrDRate());
			poDeskGenerateTransVO.setStrItemId(_poDeskGenerateTransFB.getStrItemId());
			poDeskGenerateTransVO.setStrDTax(_poDeskGenerateTransFB.getStrDTax());
			poDeskGenerateTransVO.setStrFromDate(_poDeskGenerateTransFB.getStrFromDate());
			poDeskGenerateTransVO.setStrToDate(_poDeskGenerateTransFB.getStrToDate());
			poDeskGenerateTransVO.setTmpPONO(_poDeskGenerateTransFB.getTmpPONO());
				poDeskGenerateTransBO.getOtherData(poDeskGenerateTransVO);
				
				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());
				
				wb = poDeskGenerateTransVO.getWbOtherDtl();
				//br.append(_poDeskGenerateTransFB.getStrDivId()+"#");
				if (wb.size() != 0) {
					br.append("<table class='TABLEWIDTH' align=center border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr class='HEADER'>");
					br.append("<td width='10%' class='multiLabel'>Item Id");
					br.append("</td><td width='10%' class='multiLabel'>P.P.O. QTY");
					br.append("</td><td width='15%' class='multiLabel'><div align='right'>Op. Balance</div>");
					br.append("</td><td width='10%' class='multiLabel'><div align='right'>Received</div>");
					br.append("</td><td width='10%' class='multiLabel'><div align='right'>Issued</div>");
					br.append("</td><td width='15%' class='multiLabel'><div align='right'>Present Stock</div>");
					br.append("</td><td width='10%' class='multiLabel'><div align='right'>Req. Qty</div>");
					br.append("</td><td width='10%' class='multiLabel'><div align='right'>Price(L1 Supp.)</div>");
					br.append("</td><td width='10%' class='multiLabel'><div align='right'>Amount</div>");
					br.append("</td></tr>");
					br.append("</table>");
					br.append("<table class='TABLEWIDTH' align=center border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					
					while (wb.next()) {
							br.append("<tr>");
							br.append("<td width='10%' class='multiControl'>");
							br.append("<input type='hidden' name='strHiddenValuebulk' value='"+ wb.getString(1) + "^"+ wb.getString(2) + "^"+ wb.getString(3) + "^"+ wb.getString(4) + "^"+ wb.getString(5) + "^"+ wb.getString(6) + "' >");
							br.append(wb.getString(1));
							br.append("</td><td width='10%' class='multiControl'>");
							br.append(wb.getString(2));
							br.append("</td><td width='15%' class='multiControl'><div align='right'>");
							br.append(wb.getString(3));
							br.append("</div></td><td width='10%' class='multiControl'><div align='right'>");
							br.append(wb.getString(4).replace("$","#").split("#")[1]);
							br.append("</div></td><td width='10%' class='multiControl'><div align='right'>");
							br.append(wb.getString(4).replace("$","#").split("#")[0]);
							br.append("</div></td><td width='15%' class='multiControl'><div align='right'>");
							br.append(wb.getString(5));
							br.append("</div></td><td width='10%' class='multiControl'><div align='right'>");
							br.append(wb.getString(7).split("#")[0]);
							br.append("</div></td><td width='10%' class='multiControl'><div align='right'>");
							//if(!_poDeskGenerateTransFB.getStrExclTax().equals("1"))
								br.append(wb.getString(7).split("#")[1]);
							//else
								//br.append(Math.round((((Double.parseDouble(wb.getString(7).split("#")[1])*100)/105)+(((Double.parseDouble(wb.getString(7).split("#")[1])*100)/105)*(Double.parseDouble(wb.getString(7).split("#")[2])/100)))*100.0)/100.0);
							br.append("</div></td><td width='10%' class='multiControl'><div align='right'>");
							//"500#17.14#14.00"
							Double amt=(Double.parseDouble(wb.getString(7).split("#")[1]) * Double.parseDouble(wb.getString(7).split("#")[0]));
							double taxamt=((amt*Double.parseDouble(wb.getString(7).split("#")[2]))/100);
							br.append(HisUtil.getAmountWithDecimal((amt+taxamt), 2));
							//br.append(Math.round((((Double.parseDouble(wb.getString(7).split("#")[1])*100)/105)+Math.round(((((Double.parseDouble(wb.getString(7).split("#")[1])*100)/105)*(Double.parseDouble(wb.getString(7).split("#")[2])/100)))*100.0)/100.0)*Math.round((Double.parseDouble(wb.getString(7).split("#")[0])*100.0)/100.0)* 100.0) / 100.0);
							br.append("</div></td></tr>");
					}
					br.append("</table>");
				} 
				/*else {
					br.append("<table class='TABLEWIDTH' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr>");
					br.append("<td colspan='3'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
					br.append("</tr>");
					br.append("</table>");
				}*/
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getSupplierDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}

	public static String indentDetail(PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		String tmpsupp = "0",compData=null,supp="";
		double tmp = 0;
		
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
	
			
			poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());
			poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrStoreId());
			poDeskGenerateTransVO.setStrRequestId(_poDeskGenerateTransFB.getStrRequestId());
			
				poDeskGenerateTransBO.indentDetail(poDeskGenerateTransVO);
				
				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());
				
				
				wb = poDeskGenerateTransVO.getWbIndentItemDetail();
				//br.append(_poDeskGenerateTransFB.getStrDivId()+"#");
				if (wb.size() != 0) {
					br.append("<table width='400' align=center border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr class='HEADER'>");
					br.append("<td width='70%' class='multiLabel'>Item Name");
					br.append("</td><td width='30%' class='multiLabel'><div align='right'>Sanc. Qty</div>");
					br.append("</td>");
					br.append("<th align='right' colspan=2><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
					br.append("onClick='hide_popup_menu(\"divIndentNoDetail");
					//br.append(nTmpI);
					br.append("\");'></th></tr>");
					br.append("</table>");
					br.append("<table width='400' align=center border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					
					while (wb.next()) {
							br.append("<tr>");
							br.append("<td width='70%' class='multiControl'>");
							br.append(wb.getString(2));
							br.append("</td><td width='30%' class='multiControl'>");
							br.append(wb.getString(4));
							br.append("</td></tr>");
						}
				} else {
					br.append("<table width='400' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr>");
					br.append("<td colspan='2'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
					br.append("<th align='right' colspan=2><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
					br.append("onClick='hide_popup_menu(\"divIndentNoDetail");
					//br.append(nTmpI);
					br.append("\");'></th></tr>");
					br.append("</table>");
				}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getSupplierDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	public static String indentDetailBS(PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		String tmpsupp = "0",compData=null,supp="";
		double tmp = 0;
		
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
	
			
			poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());
			poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrStoreId());
			poDeskGenerateTransVO.setStrRequestId(_poDeskGenerateTransFB.getStrRequestId());
			
				poDeskGenerateTransBO.indentDetail(poDeskGenerateTransVO);
				
				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());
				
				
				wb = poDeskGenerateTransVO.getWbIndentItemDetail();
				//br.append(_poDeskGenerateTransFB.getStrDivId()+"#");
				if (wb.size() != 0) {
					br.append("<table class='table'>");
					br.append("<thead>");
					br.append("<tr>");
					br.append("<th style='border-top: white;'>Item Name");
					br.append("</th><th style='border-top: white;'>Sanc. Qty");
					br.append("</th>");
					br.append("</tr></thead>");
					
					
					while (wb.next()) {
						br.append("<tbody>");
							br.append("<tr>");
							br.append("<td>");
							br.append(wb.getString(2));
							br.append("</td><td>");
							br.append(wb.getString(4));
							br.append("</td></tr></tbody>");
						}
						
				} else {
					br.append("<table width='400' border='0' bgcolor='#6097BC' cellspacing ='1' cellpGenerateing='1'>");
					br.append("<tr>");
					br.append("<td colspan='2'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
					br.append("<th align='right' colspan=2><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
					br.append("onClick='hide_popup_menu(\"divIndentNoDetail");
					//br.append(nTmpI);
					br.append("\");'></th></tr>");
					br.append("</table>");
				}
				br.append("</table>");
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getSupplierDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	
	public static String finalizePO(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
 		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		//String strDivId = "";
		String strReqNo="";
		//String strStores="";
		String tmppo="0";
		double totamt;
		int i=0;
		try 
		{
			System.out.println("------------- PODeskGenerateTransHLP.finalizePO -----------------");
			
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			int nTmpI = 0;
				poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());				
				poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrStoreId());
				poDeskGenerateTransVO.setStrPOTypeId(_poDeskGenerateTransFB.getStrPOTypeId());
				poDeskGenerateTransVO.setStrPoNo(_poDeskGenerateTransFB.getStrPoNo());
 				poDeskGenerateTransVO.setStrItemCat(_poDeskGenerateTransFB.getStrItemCat());
				poDeskGenerateTransBO.finalizePO(poDeskGenerateTransVO);  // pkg_mms_view.proc_draft_po [Mode - 1 ]

				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());

				_poDeskGenerateTransFB.setWbRequestItemDetail(poDeskGenerateTransVO.getWbRequestItemDetail());

				wb = _poDeskGenerateTransFB.getWbRequestItemDetail();
				
				if (wb.size() != 0) 
				{
					
					
					br.append("<div id="
							+ _poDeskGenerateTransFB.getStrPoNo() + ">");
					br.append("<table class='TABLEWIDTH' bgcolor='black' align='center' cellspacing='1px'>");
					br.append("<tr>");
					br.append("<td width='5%' class='multiLabel'>S No.");
					br.append("</td><td width='30%' class='multiLabel'>Item Name[Item ID]");
					br.append("</td><td width='25%' class='multiLabel'><font color='red'>*</font>Supplier");
					br.append("</td><td width='10%' class='multiLabel'><font color='red'>*</font>Qty");
					br.append("</td><td width='10%' class='multiLabel'>Rate/Unit");
					br.append("</td><td width='10%' class='multiLabel'>Tax(%)");
					br.append("</td><td width='10%' class='multiLabel'><font color='red'>*</font>Total Cost");
					
					br.append("</td></tr>");
					
					br.append("</table>");
					
					
					while (wb.next()) 
					{
						
 						_poDeskGenerateTransFB.setStrStoreName(wb.getString(7));
						_poDeskGenerateTransFB.setStrItemCatName(wb.getString(8));
						_poDeskGenerateTransFB.setStrPOType(wb.getString(9));
						_poDeskGenerateTransFB.setStrPODate(wb.getString(10));
						_poDeskGenerateTransFB.setStrpoDateId(wb.getString(10));
						_poDeskGenerateTransFB.setStrDPhoneEmail(wb.getString(11).split("#"));
						poDeskGenerateTransVO.setStrSupplierId(wb.getString(1).split("#")[2]);
						br.append("<div id ='divIddd"+wb.getString(1).split("#")[1]+"'>");
						if(!tmppo.equals(poDeskGenerateTransVO.getStrSupplierId().split("@")[0]) && !tmppo.equals("0"))
						{
							br.append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr class='HEADER'><td width='100%' colspan='4'></td></tr><tr>");
							br.append("<td class='CONTROL' width='50%' colspan='2'><div align='right'>Comments</div></td><td class='CONTROL' width='50%' colspan='2'><div align='left'><textarea name='strDFinalNotes'></textarea></div></td></tr><tr class='HEADER'><td colspan=4></td></tr></table> ");
						}
						br.append("<table class='TABLEWIDTH' id = 'divId"+wb.getString(1).split("#")[1]+"'  bgcolor='#6097BC' align='center' cellspacing='1px'><tr>");
						br.append("<td width='5%' class='multiControl'>");
						br.append(++i);
						br.append("<input type='hidden' name='strDitemId'       value='"+ wb.getString(1).split("#")[0] + "' disabled=true>");
						br.append("<input type='hidden' name='strDPhoneEmail'   value='"+ wb.getString(11)  + "' >");
						br.append("<input type='hidden' name='strDitemBrandId'  value='"+ wb.getString(1).split("#")[1] + "' disabled=true>");
						br.append("<input type='hidden' id='BQTY"+wb.getString(1).split("#")[1]+"' name='strTmpBalQty' value='"	+ wb.getString(3) + "' disabled=true>");
						br.append("<input type='hidden' name='strHiddenValue' value='"+ wb.getString(1) + "' disabled=true>");						
						br.append("</td><td width='30%' class='multiControl' style=\"text-align:left;\" id='tdstrDitemBrandId"+wb.getString(1).split("#")[1]+""+nTmpI+ "'  >");
						br.append(wb.getString(2));						
						br.append("</td><td width='25%' class='multiControl' id='tdstrDSuppId"+wb.getString(1).split("#")[1]+""+nTmpI+ "'>");
						poDeskGenerateTransVO.setStrItemIds(wb.getString(1).split("#")[0]);
						poDeskGenerateTransVO.setStrItemBrandIds(wb.getString(1).split("#")[1]);
						poDeskGenerateTransVO.setStrContractType("12");//hardcoded for B&S
						
						poDeskGenerateTransBO.setSupplierValuesBasedOnRCDraftPO(poDeskGenerateTransVO);
						
						br.append("<select name=strDSuppId  id ='CMBSUP"+wb.getString(1).split("#")[1]+""+0+"' onchange='checkOrderQty(this)'  disabled=true>"		
								+ poDeskGenerateTransVO.getStrSupplierValuesRC()
								+ "</select>");
						br.append("</td><td width='10%' class='multiControl' id='tdstrDOrderQty"+wb.getString(1).split("#")[1]+""+nTmpI+ "' >");
						br.append("<input type=text class=txtFldNormal  onkeypress='return validateData(event,5);' value="+wb.getString(3)+" onkeyup='calcRatenAll(this);' autocomplete='off' maxlength=7 name='strDOrderQty' id ='QTY"+wb.getString(1).split("#")[1]+""+0+"'>");
						
						totamt = (Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1]) * Double.parseDouble(wb.getString(3).split(" ")[0])) + ((Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[3]) * Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1]) * Double.parseDouble(wb.getString(3).split(" ")[0]) )/100);
						
						br.append("</td><td width='10%' class='multiControl' id='tdstrDRateUnit"+wb.getString(1).split("#")[1]+""+nTmpI+ "'>");
						br.append("<input type=text class=txtFldNormal disabled=true onkeypress='return validateData(event,5);' maxlength=7 value="+poDeskGenerateTransVO.getStrSupp().split("@")[1]+" name=strDRateUnit onblur='getTotRate(this)'   id ='RATE"+wb.getString(1).split("#")[1]+""+0+"'>");
						br.append("</td><td width='10%' class='multiControl' id='tdstrDTax"+wb.getString(1).split("#")[1]+""+nTmpI+ "'>");
						br.append("<input type=text class=txtFldNormal disabled=true onkeypress='return validateData(event,7);' maxlength=5 name=strDTax value="+poDeskGenerateTransVO.getStrSupp().split("@")[3]+"   id ='TAX"+wb.getString(1).split("#")[1]+""+0+"'>");
						br.append("</td><td width='10%' class='multiControl'  id='tdstrDTotalRate"+wb.getString(1).split("#")[1]+""+nTmpI+ "'>");
						br.append("<input type=text class=txtFldNormal onkeypress='return validateData(event,5);' value="+ (Math.round(totamt*100.0)/100.0) +"  name=strDTotalRate disabled=true id ='TRATE"+wb.getString(1).split("#")[1]+""+0+"'>");
						
						nTmpI++;
						br.append("</td></tr>");
						br.append("</table></div>");
						
						tmppo=poDeskGenerateTransVO.getStrSupplierId().split("@")[0];
						
					}
					br.append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr class='HEADER'><td width='100%' colspan='4'></td></tr><tr>");
					br.append("<td class='CONTROL' width='50%' colspan='2'><div align='right'>Comments</div></td><td class='CONTROL' width='50%' colspan='2'><div align='left'><textarea name='strDFinalNotes'></textarea></div></td></tr></table> ");
					
					br.append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr class='HEADER'><td colspan='4' ><input type='hidden' name='i' value='"+i+"' disabled=true><div align='right'>If any item is to be removed then mark its Qty as 0</div></td></tr><tr>");
					br.append("<td class='CONTROL' colspan=4>");
					br.append("<div align=center id='compile_btn'><img src='../../hisglobal/images/Finalize.png'");
					br.append("style='cursor: pointer; ' title='Save Record'");
					br.append("onClick='save_draftpo();' />");
					br.append(" <img src='../../hisglobal/images/btn-ccl.png'");
					br.append("style='cursor: pointer; ' title='Cancel Process'");
					br.append("onClick='cancelToDesk();'></center></div>");
					br.append("</td></tr></table>");
					br.append("</div>");
				} else {
					br.append("<div id="
							+ strReqNo.split("#")[nTmpI] + ">");
					br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
					br.append("<tr>");
					br.append("<td colspan='5'  CLASS='multiControl' ><DIV class='errMsg' align='center'>FC Approval required for PO to be finalized</div></TD>");
					br.append("</tr>");
					br.append("</table>");
					br.append("</div>");
				}
			//}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getIndentDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	
	public static String finalizePOBS(
			PODeskGenerateTransFB _poDeskGenerateTransFB) {

		StringBuffer br = new StringBuffer("");
 		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		WebRowSet wb = null;
		//String strDivId = "";
		String strReqNo="";
		//String strStores="";
		String tmppo="0";
		double totamt;
		int i=0;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			int nTmpI = 0;
				poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB.getStrHospitalCode());				
				poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrStoreId());
				poDeskGenerateTransVO.setStrPOTypeId(_poDeskGenerateTransFB.getStrPOTypeId());
				poDeskGenerateTransVO.setStrPoNo(_poDeskGenerateTransFB.getStrPoNo());
 				poDeskGenerateTransVO.setStrItemCat(_poDeskGenerateTransFB.getStrItemCat());
				poDeskGenerateTransBO.finalizePO(poDeskGenerateTransVO);

				if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskGenerateTransVO.getStrMsgString());

				_poDeskGenerateTransFB.setWbRequestItemDetail(poDeskGenerateTransVO.getWbRequestItemDetail());

				wb = _poDeskGenerateTransFB.getWbRequestItemDetail();
				
				if (wb.size() != 0) {
					
					
					br.append("<div id="
							+ _poDeskGenerateTransFB.getStrPoNo() + ">");
					br.append("<table class='table' align='center'>");
					br.append("<tr>");
					br.append("<thead class='thead-dark'>");
					br.append("<th width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Sr No.</th>");
					br.append("<th width='30%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Item Name[Item ID]</th>");
					br.append("<th width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Supplier</th>");
					br.append("<th width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Qty</th>");
					br.append("<th width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Rate/Unit</th>");
					br.append("<th width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Tax(%)</th>");
					br.append("<th width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'><font color='red'>*</font>Total Cost</th>");
					br.append("</thead>");
					br.append("<tr>");
					//br.append("</table>");
					
					
					while (wb.next()) {
						
 						_poDeskGenerateTransFB.setStrStoreName(wb.getString(7));
						_poDeskGenerateTransFB.setStrItemCatName(wb.getString(8));
						_poDeskGenerateTransFB.setStrPOType(wb.getString(9));
						_poDeskGenerateTransFB.setStrPODate(wb.getString(10));
						_poDeskGenerateTransFB.setStrpoDateId(wb.getString(10));
						_poDeskGenerateTransFB.setStrDPhoneEmail(wb.getString(11).split("#"));
						poDeskGenerateTransVO.setStrSupplierId(wb.getString(1).split("#")[2]);
						br.append("<div id ='divIddd"+wb.getString(1).split("#")[1]+"'>");
						if(!tmppo.equals(poDeskGenerateTransVO.getStrSupplierId().split("@")[0]) && !tmppo.equals("0"))
						{
							br.append("<div class='row'><div class='col-sm-2'><label>Comments</label></div>");
							br.append("<div class='col-sm-10'><textarea class='form-control form-control-sm'name='strDFinalNotes'></textarea></div></div>");
						}
						//br.append("<table class='TABLEWIDTH' id = 'divId"+wb.getString(1).split("#")[1]+"'  bgcolor='#6097BC' align='center' cellspacing='1px'><tbody>");
						br.append("<tbody>");
						br.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>");
						br.append(++i);
						br.append("<input type='hidden' name='strDitemId' value='"
										+ wb.getString(1).split("#")[0] + "' disabled=true>");
						br.append("<input type='hidden' name='strDPhoneEmail' value='" + wb.getString(11)  + "' >");
						br.append("<input type='hidden' name='strDitemBrandId' value='"
										+ wb.getString(1).split("#")[1] + "' disabled=true>");
						br.append("<input type='hidden' id='BQTY"+wb.getString(1).split("#")[1]+"' name='strTmpBalQty' value='"
								+ wb.getString(3) + "' disabled=true>");
						br.append("<input type='hidden' name='strHiddenValue' value='"+ wb.getString(1) + "' disabled=true>");
						
						br.append("</td><td width='30%' align='left' style='font-weight:350 !important ;font-size: 16px !important;' id='tdstrDitemBrandId"+wb.getString(1).split("#")[1]+""+nTmpI+ "'  >");
						br.append(wb.getString(2));
						//br.append("</td><td width='10%' class='multiControl' id='tdstrTmpBalQty"+wb.getString(1).split("#")[1]+""+nTmpI+ "'><div id='testdiv' >");
						//br.append("<a STYLE='CURSOR:POINTER;color:blue' id ='TQTY"+wb.getString(1).split("#")[1]+""+0+"' onClick='get_item_details(this,"+nTmpI+");' > ");
						//br.append(wb.getString(3));
						//br.append("</a></div>");
						 /******* EnD -- Pop-Up Get After Clicking On Balance Qty*********/
						br.append("</td><td width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' id='tdstrDSuppId"+wb.getString(1).split("#")[1]+""+nTmpI+ "'>");
						poDeskGenerateTransVO.setStrItemIds(wb.getString(1).split("#")[0]);
						poDeskGenerateTransVO.setStrItemBrandIds(wb.getString(1).split("#")[1]);
						poDeskGenerateTransVO.setStrContractType("12");//hardcoded for B&S
						
						poDeskGenerateTransBO.setSupplierValuesBasedOnRCDraftPO(poDeskGenerateTransVO);
						
						br.append("<select name=strDSuppId class='form-control form-control-sm' id ='CMBSUP"+wb.getString(1).split("#")[1]+""+0+"' onchange='checkOrderQty(this)'  disabled=true>"		
								+ poDeskGenerateTransVO.getStrSupplierValuesRC()
								+ "</select>");
						br.append("</td><td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' id='tdstrDOrderQty"+wb.getString(1).split("#")[1]+""+nTmpI+ "' >");
						br.append("<input type=text class='form-control form-control-sm'   onkeypress='return validateData(event,5);' value="+wb.getString(3)+" onkeyup='calcRatenAll(this);' autocomplete='off' maxlength=7 name='strDOrderQty' id ='QTY"+wb.getString(1).split("#")[1]+""+0+"'>");
						
						totamt = (Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1]) * Double.parseDouble(wb.getString(3).split(" ")[0])) + ((Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[3]) * Double.parseDouble(poDeskGenerateTransVO.getStrSupp().split("@")[1]) * Double.parseDouble(wb.getString(3).split(" ")[0]) )/100);
						System.out.println("totamt:::::::::"+totamt);
						br.append("</td><td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' id='tdstrDRateUnit"+wb.getString(1).split("#")[1]+""+nTmpI+ "'>");
						br.append("<input type=text class='form-control form-control-sm' disabled=true onkeypress='return validateData(event,5);' maxlength=7 value="+poDeskGenerateTransVO.getStrSupp().split("@")[1]+" name=strDRateUnit onblur='getTotRate(this)'   id ='RATE"+wb.getString(1).split("#")[1]+""+0+"'>");
						br.append("</td><td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' id='tdstrDTax"+wb.getString(1).split("#")[1]+""+nTmpI+ "'>");
						br.append("<input type=text class='form-control form-control-sm' disabled=true onkeypress='return validateData(event,7);' maxlength=5 name=strDTax value="+poDeskGenerateTransVO.getStrSupp().split("@")[3]+"   id ='TAX"+wb.getString(1).split("#")[1]+""+0+"'>");
						br.append("</td><td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' id='tdstrDTotalRate"+wb.getString(1).split("#")[1]+""+nTmpI+ "'>");
						br.append("<input type=text class='form-control form-control-sm' onkeypress='return validateData(event,5);' value="+ (Math.round(totamt*100.0)/100.0) +"  name=strDTotalRate disabled=true id ='TRATE"+wb.getString(1).split("#")[1]+""+0+"'>");
						//br.append("</td><td width='8%' class='multiControl' >");
						//br.append("<input type=text class=txtFldNormal onkeypress='return validateData(event,5);' value="+poDeskGenerateTransVO.getStrSupp().split("@")[2]+"  name=strDShelfLife  id ='SLIFE"+wb.getString(1).split("#")[1]+""+0+"'>");
						//br.append("</td><td width='10%' class='multiControl' >");
						//br.append("<div id='addSupp"+nTmpI+"'><img src='../../hisglobal/images/Add_Supplier.png' id ='BTN"+wb.getString(2)+""+0+"' title='Check List' style='cursor: pointer;' ");
						//br.append("title='Add Supplier' onclick='addSuppiler(this,0)'></div>");
						//br.append(nTmpI); 
						//br.append("\")'>");
						nTmpI++;
						br.append("</td></tbody>");
						br.append("</div>");
						
						tmppo=poDeskGenerateTransVO.getStrSupplierId().split("@")[0];
						
					}
					br.append("</table>");
					//br.append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr class='HEADER'><td width='100%' colspan='4'></td></tr><tr>");
					br.append("<br><div class='row'><div class='col-sm-2'>Comments</div><div class='col-sm-10'><textarea class='form-control' name='strDFinalNotes'></textarea></div></div>");
					
				/*
				 * br.
				 * append("<table width='85%' bgcolor='white'  align='center' cellspacing='1px'><tr class='HEADER'><td colspan='4' ><input type='hidden' name='i' value='"
				 * +i+"' disabled=true><div align='right'>If any item is to be removed then mark its Qty as 0</div></td></tr><tr>"
				 * ); br.append("<td class='CONTROL' colspan=4>"); br.
				 * append("<div align=center id='compile_btn'><img src='../../hisglobal/images/Finalize.png'"
				 * ); br.append("style='cursor: pointer; ' title='Save Record'");
				 * br.append("onClick='save_draftpo();' />");
				 * br.append(" <img src='../../hisglobal/images/btn-ccl.png'");
				 * br.append("style='cursor: pointer; ' title='Cancel Process'");
				 * br.append("onClick='cancelToDesk();'></center></div>");
				 * br.append("</td></tr></table>");
				 */
					br.append("</div>");
				} else {
					br.append("<div id="
							+ strReqNo.split("#")[nTmpI] + ">");
					br.append("<table class='table' align='center'>");
					br.append("<tr>");
					br.append("<td colspan='5' style='font-weight:350 !important ;font-size: 16px !important;' ><DIV class='errMsg' align='center'>FC Approval required for PO to be finalized</div></TD>");
					br.append("</tr>");
					br.append("</table>");
					br.append("</div>");
				}
				
			//}
		} catch (Exception _e) {
			_e.printStackTrace();
			_poDeskGenerateTransFB
					.setStrMsg("PODeskGenerateTransHLP.getIndentDetails() --> "
							+ _e.getMessage());
			_poDeskGenerateTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
}
