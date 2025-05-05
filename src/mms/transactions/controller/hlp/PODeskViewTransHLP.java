/**
 * 
 */
package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.PODeskViewTransBO;
import mms.transactions.controller.fb.PODeskViewTransFB;
import mms.transactions.vo.PODeskViewTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskViewTransHLP {
	public static String getForeignPODetails(
			PODeskViewTransFB _poDeskViewTransFB) {

		StringBuffer br = new StringBuffer("");
		try {
			br.append("<tr>");
			br.append("<td width='25%' class='LABEL'>Agent Name</td>");
			br.append("<td width='25%' class='CONTROL'>");
			br.append(_poDeskViewTransFB.getStrAgentName());
			br.append("<input type=hidden name=strAgentId value='");
			br.append(_poDeskViewTransFB.getStrAgentId());
			br.append("'></td><td width='25%' class='LABEL'>CA Agent Name</td>");
			br.append("<td width='25%' class='CONTROL'>");
			br.append(_poDeskViewTransFB.getStrCAAgentName());
			br.append("<input type=hidden name=strAgentId value='");
			br.append(_poDeskViewTransFB.getStrCAAgent());
			br.append("'></td></tr>");
			br.append("<tr>");
			br.append("<td width='25%' class='LABEL'>Currency</td>");
			br.append("<td width='75%' colspan=3 class='CONTROL'>");
			br.append(_poDeskViewTransFB.getStrCurrency());
			br.append("<input type=hidden name=strAgentId value='");
			br.append(_poDeskViewTransFB.getStrCurrencyCode());
			br.append("'></td></tr>");

		} catch (Exception _err) {
			_poDeskViewTransFB
					.setStrMsg("PODeskViewTransHLP.getForeignPODetails() --> "
							+ _err.getMessage());
			_poDeskViewTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	public static String getRequestDetails(
			PODeskViewTransFB _poDeskViewTransFB) {

		StringBuffer br = new StringBuffer("");
		StringBuffer br1 = new StringBuffer("");
		WebRowSet wbResult = null;
		PODeskViewTransBO poDeskViewTransBO =null;
		PODeskViewTransVO poDeskViewTransVO =null;
		try {
			poDeskViewTransBO = new PODeskViewTransBO();
			poDeskViewTransVO = new PODeskViewTransVO();
			poDeskViewTransVO.setStrHospitalCode(_poDeskViewTransFB.getStrHospitalCode());
			poDeskViewTransVO.setStrPONo(_poDeskViewTransFB.getStrPONo());
			poDeskViewTransVO.setStrStoreId(_poDeskViewTransFB.getStrStoreId());
			poDeskViewTransVO.setStrPOTypeId(_poDeskViewTransFB.getStrPOTypeId());
			poDeskViewTransVO.setStrpoStatus(_poDeskViewTransFB.getStrpoStatus());
			int nTmpJ = 0;
		
			System.out.println("----------- PODeskViewTransHLP.getRequestDetails -----------");
			
			poDeskViewTransBO.getRequestDetails(poDeskViewTransVO);
			
			if (poDeskViewTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskViewTransVO.getStrMsgString());
			wbResult = poDeskViewTransVO.getWbScheduleDetail();
			while (wbResult.next()) 
			{
				br1.append("<tr>");
				br1.append("<td width='25%' class='multiControl'>");
				br1.append(wbResult.getString(1));
				if(!_poDeskViewTransFB.getStrPOTypeId().equals("87") && !_poDeskViewTransFB.getStrPOTypeId().equals("22") && !_poDeskViewTransFB.getStrPOTypeId().equals("21") )
				{
					br1.append("</td><td width='25%' class='multiControl'>");
					br1.append(wbResult.getString(2));
					br1.append("</td><td width='25%' class='multiControl'>");
					br1.append(wbResult.getString(3));
				}
				br1.append("</td><td width='25%' class='multiControl'>");
				br1.append(wbResult.getString(4));
				br1.append("</td></tr>");
				nTmpJ++;
			}
			if (wbResult.size() > 0) 
			{
					br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'");
					br.append("cellspacing='1px' bgcolor='black'>");
					br.append("<tr>");
					br.append("<td width='25%' class='multiLabel'>Request No");
					if(!_poDeskViewTransFB.getStrPOTypeId().equals("87") && !_poDeskViewTransFB.getStrPOTypeId().equals("22") && !_poDeskViewTransFB.getStrPOTypeId().equals("21"))
					{
						br.append("</td><td width='25%' class='multiLabel'>Request Date");
						br.append("</td><td width='25%' class='multiLabel'>Request Period");
					}
					br.append("</td><td width='25%' class='multiLabel'>Raising Store");
					br.append("</td></tr>");
					br.append("</table>");
					br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'");
					br.append("cellspacing='1px' bgcolor='#6097BC'>");
					br.append(br1.toString());
					br.append("</table>");
					
					
			}

		} catch (Exception _err) {
			_err.printStackTrace();
			_poDeskViewTransFB
					.setStrMsgString("PODeskViewTransHLP.getRequestDetails() --> "
							+ _err.getMessage());
			_poDeskViewTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	public static String getRequestDetailsBS(
			PODeskViewTransFB _poDeskViewTransFB) {

		StringBuffer br = new StringBuffer("");
		StringBuffer br1 = new StringBuffer("");
		WebRowSet wbResult = null;
		PODeskViewTransBO poDeskViewTransBO =null;
		PODeskViewTransVO poDeskViewTransVO =null;
		try {
			poDeskViewTransBO = new PODeskViewTransBO();
			poDeskViewTransVO = new PODeskViewTransVO();
			poDeskViewTransVO.setStrHospitalCode(_poDeskViewTransFB.getStrHospitalCode());
			poDeskViewTransVO.setStrPONo(_poDeskViewTransFB.getStrPONo());
			poDeskViewTransVO.setStrStoreId(_poDeskViewTransFB.getStrStoreId());
			poDeskViewTransVO.setStrPOTypeId(_poDeskViewTransFB.getStrPOTypeId());
			poDeskViewTransVO.setStrpoStatus(_poDeskViewTransFB.getStrpoStatus());
			int nTmpJ = 0;
		
			
			poDeskViewTransBO.getRequestDetails(poDeskViewTransVO);
			
			if (poDeskViewTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskViewTransVO.getStrMsgString());
			wbResult = poDeskViewTransVO.getWbScheduleDetail();
			while (wbResult.next()) 
			{
				br1.append("<tr>");
				br1.append("<td>");
				br1.append(wbResult.getString(1));
				if(!_poDeskViewTransFB.getStrPOTypeId().equals("87") && !_poDeskViewTransFB.getStrPOTypeId().equals("22") && !_poDeskViewTransFB.getStrPOTypeId().equals("21") )
				{
					br1.append("</td><td>");
					br1.append(wbResult.getString(2));
					br1.append("</td><td>");
					br1.append(wbResult.getString(3));
				}
				br1.append("</td><td>");
				br1.append(wbResult.getString(4));
				br1.append("</td></tr>");
				nTmpJ++;
			}
			if (wbResult.size() > 0) 
			{
					br.append("<table class='table'>");
					br.append("<thead>");
					br.append("<tr>");
					br.append("<th>Request No");
					if(!_poDeskViewTransFB.getStrPOTypeId().equals("87") && !_poDeskViewTransFB.getStrPOTypeId().equals("22") && !_poDeskViewTransFB.getStrPOTypeId().equals("21"))
					{
						br.append("</th><th>Request Date");
						br.append("</th><th>Request Period");
					}
					br.append("</th><th>Raising Store");
					br.append("</th></tr>");
					br.append("</thead>");
					br.append("<tbody>");
					br.append(br1.toString());
					br.append("</tbody></table>");
					
					
			}

		} catch (Exception _err) {
			_err.printStackTrace();
			_poDeskViewTransFB
					.setStrMsgString("PODeskViewTransHLP.getRequestDetails() --> "
							+ _err.getMessage());
			_poDeskViewTransFB.setStrMsgType("1");
		}
		return br.toString();
	}

	public static String getItemDetails(
			PODeskViewTransFB _poDeskViewTransFB) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wbResult = null;
		PODeskViewTransBO poDeskViewTransBO =null;
		PODeskViewTransVO poDeskViewTransVO =null;
		String strPrevScheduleNo = "";
		try {
			poDeskViewTransBO = new PODeskViewTransBO();
			poDeskViewTransVO = new PODeskViewTransVO();
			poDeskViewTransVO.setStrHospitalCode(_poDeskViewTransFB.getStrHospitalCode());
			poDeskViewTransVO.setStrPONo(_poDeskViewTransFB.getStrPONo());
			poDeskViewTransVO.setStrStoreId(_poDeskViewTransFB.getStrStoreId());
			poDeskViewTransVO.setStrPOTypeId(_poDeskViewTransFB.getStrPOTypeId());
			poDeskViewTransVO.setStrpoStatus(_poDeskViewTransFB.getStrpoStatus());
			int nTmpJ = 1;
		
			System.out.println("----------- PODeskViewTransHLP.getItemDetails -----------");
			
			poDeskViewTransBO.getItemDetails(poDeskViewTransVO);
			
			if (poDeskViewTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskViewTransVO.getStrMsgString());
			wbResult = poDeskViewTransVO.getWbScheduleDetail();
			
			while (wbResult.next()) {
				if(!strPrevScheduleNo.equals(wbResult.getString(1))){
					if(nTmpJ!=1){
						br.append("</table>");
						br.append("</div>");
					}
					/*br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'");
					br.append("cellspacing='1px'>");
					br.append("<tr>");
					br.append("<td class='TITLE'><div id='divSchedule"+nTmpJ+"MinusId'  style='cursor:pointer;color:white;' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='../../hisglobal/images/minus.gif'");
					br.append("style='cursor:pointer;' onclick='hideDiv(\"divSchedule"+nTmpJ+"MinusId\"),hideDiv(\"divSchedule"+nTmpJ+"\"),showDiv(\"divSchedule"+nTmpJ+"PlusId\")'>");
					br.append("Schedule ");
					br.append(nTmpJ);
					br.append("/ Delivery Date  ");
					br.append(wbResult.getString(7));
					br.append("</div><div style='display:none;color:white;' id='divSchedule"+nTmpJ+"PlusId' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='../../hisglobal/images/plus.gif'");
					br.append("style='cursor:pointer;' onclick='showDiv(\"divSchedule"+nTmpJ+"MinusId\"),showDiv(\"divSchedule"+nTmpJ+"\"),hideDiv(\"divSchedule"+nTmpJ+"PlusId\")'>");
					br.append("Schedule ");
					br.append(nTmpJ);
					br.append("/ Delivery Date  ");
					br.append(wbResult.getString(7));
					br.append("</div>");
					br.append("</td></tr></table>");*/

					br.append("<div id='divSchedule"+nTmpJ+"'>");
					br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'");
					br.append("cellspacing='1px' bgcolor='black'>");
					br.append("<tr>");
					br.append("<td width='50%' class='multiLabel'>Item Name");
					br.append("</td><td width='25%' class='multiLabel'>Rate/ Unit");
					br.append("</td><td width='25%' class='multiLabel'>Order Qty");
					//br.append("</td><td width='15%' class='multiLabel'>Warranty Req.");
					//br.append("</td><td width='20%' class='multiLabel'>Installation Req.");
					br.append("</td></tr>");
					br.append("</table>");
					nTmpJ++;
					strPrevScheduleNo=wbResult.getString(1);
					br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'");
					br.append("cellspacing='1px' bgcolor='#6097BC'>");
				}
					
				
				br.append("<tr>");
				br.append("<td width='50%' class='multiControl'>");
				br.append(wbResult.getString(2));
				br.append("</td><td width='25%' class='multiControl'>");
				br.append(wbResult.getString(3));
				br.append("</td><td width='25%' class='multiControl'>");
				br.append(wbResult.getString(4));
				br.append("</td>");
				/*
				br.append("<td width='15%' class='multiControl'>");
				br.append(wbResult.getString(5));
				br.append("</td><td width='20%' class='multiControl'>");
				br.append(wbResult.getString(6));
				br.append("</td>");
				*/
				br.append("</tr>");
				
				
			}
			br.append("</table>");
			br.append("</div");

		} catch (Exception _err) {
			_err.printStackTrace();
			_poDeskViewTransFB
					.setStrMsgString("PODeskViewTransHLP.getItemDetails() --> "
							+ _err.getMessage());
			_poDeskViewTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	public static String getItemDetailsBS(
			PODeskViewTransFB _poDeskViewTransFB) {
		
		System.out.println("----------- PODeskViewTransHLP.getItemDetailsBS -----------");

		StringBuffer br = new StringBuffer("");
		WebRowSet wbResult = null;
		PODeskViewTransBO poDeskViewTransBO =null;
		PODeskViewTransVO poDeskViewTransVO =null;
		String strPrevScheduleNo = "";
		try {
			poDeskViewTransBO = new PODeskViewTransBO();
			poDeskViewTransVO = new PODeskViewTransVO();
			poDeskViewTransVO.setStrHospitalCode(_poDeskViewTransFB.getStrHospitalCode());
			poDeskViewTransVO.setStrPONo(_poDeskViewTransFB.getStrPONo());
			poDeskViewTransVO.setStrStoreId(_poDeskViewTransFB.getStrStoreId());
			poDeskViewTransVO.setStrPOTypeId(_poDeskViewTransFB.getStrPOTypeId());
			poDeskViewTransVO.setStrpoStatus(_poDeskViewTransFB.getStrpoStatus());
			int nTmpJ = 1;
		
			
			poDeskViewTransBO.getItemDetails(poDeskViewTransVO);
			
			if (poDeskViewTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskViewTransVO.getStrMsgString());
			wbResult = poDeskViewTransVO.getWbScheduleDetail();
			
			while (wbResult.next()) {
				if(!strPrevScheduleNo.equals(wbResult.getString(1))){
					if(nTmpJ!=1){
						br.append("</table>");
						br.append("</div>");
					}
					/*br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'");
					br.append("cellspacing='1px'>");
					br.append("<tr>");
					br.append("<td class='TITLE'><div id='divSchedule"+nTmpJ+"MinusId'  style='cursor:pointer;color:white;' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='../../hisglobal/images/minus.gif'");
					br.append("style='cursor:pointer;' onclick='hideDiv(\"divSchedule"+nTmpJ+"MinusId\"),hideDiv(\"divSchedule"+nTmpJ+"\"),showDiv(\"divSchedule"+nTmpJ+"PlusId\")'>");
					br.append("Schedule ");
					br.append(nTmpJ);
					br.append("/ Delivery Date  ");
					br.append(wbResult.getString(7));
					br.append("</div><div style='display:none;color:white;' id='divSchedule"+nTmpJ+"PlusId' >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='../../hisglobal/images/plus.gif'");
					br.append("style='cursor:pointer;' onclick='showDiv(\"divSchedule"+nTmpJ+"MinusId\"),showDiv(\"divSchedule"+nTmpJ+"\"),hideDiv(\"divSchedule"+nTmpJ+"PlusId\")'>");
					br.append("Schedule ");
					br.append(nTmpJ);
					br.append("/ Delivery Date  ");
					br.append(wbResult.getString(7));
					br.append("</div>");
					br.append("</td></tr></table>");*/

					br.append("<div id='divSchedule"+nTmpJ+"'>");
					br.append("<table class='table'>");
					br.append("<thead>");
					br.append("<tr>");
					br.append("<th>Item Name");
					br.append("</th><th>Rate/ Unit");
					br.append("</th><th>Order Qty");
					br.append("</th>");
					/*
					br.append("<th>Warranty Req.");
					br.append("</th><th>Installation Req.");
					br.append("</th>");
					*/
					br.append("</tr>");
					br.append("</thead>");
					nTmpJ++;
					strPrevScheduleNo=wbResult.getString(1);
					br.append("<tbody>");
				}
					
				
				br.append("<tr>");
				br.append("<td>");
				br.append(wbResult.getString(2));
				br.append("</td><td>");
				br.append(wbResult.getString(3));
				br.append("</td><td>");
				br.append(wbResult.getString(4));
				br.append("</td>");
				/*
				br.append("<td>");
				br.append(wbResult.getString(5));
				br.append("</td><td>");
				br.append(wbResult.getString(6));
				br.append("</td>");
				*/
				br.append("</tr>");
				
				
			}
			br.append("</tbody></table>");
			br.append("</div");

		} catch (Exception _err) {
			_err.printStackTrace();
			_poDeskViewTransFB
					.setStrMsgString("PODeskViewTransHLP.getItemDetails() --> "
							+ _err.getMessage());
			_poDeskViewTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
}
