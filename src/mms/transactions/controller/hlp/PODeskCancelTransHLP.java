/**
 * 
 */
package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.PODeskCancelTransBO;
import mms.transactions.controller.fb.PODeskCancelTransFB;
import mms.transactions.vo.PODeskCancelTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskCancelTransHLP {
	public static String getForeignPODetails(
			PODeskCancelTransFB _poDeskCancelTransFB) {

		StringBuffer br = new StringBuffer("");
		try {
			br.append("<tr>");
			br.append("<td width='25%' class='LABEL'>Agent Name</td>");
			br.append("<td width='25%' class='CONTROL'>");
			br.append(_poDeskCancelTransFB.getStrAgentName());
			br.append("<input type=hidden name=strAgentId value='");
			br.append(_poDeskCancelTransFB.getStrAgentId());
			br.append("'></td><td width='25%' class='LABEL'>CA Agent Name</td>");
			br.append("<td width='25%' class='CONTROL'>");
			br.append(_poDeskCancelTransFB.getStrCAAgentName());
			br.append("<input type=hidden name=strAgentId value='");
			br.append(_poDeskCancelTransFB.getStrCAAgent());
			br.append("'></td></tr>");
			br.append("<tr>");
			br.append("<td width='25%' class='LABEL'>Currency</td>");
			br.append("<td width='75%' colspan=3 class='CONTROL'>");
			br.append(_poDeskCancelTransFB.getStrCurrency());
			br.append("<input type=hidden name=strAgentId value='");
			br.append(_poDeskCancelTransFB.getStrCurrencyCode());
			br.append("'></td></tr>");

		} catch (Exception _err) {
			_poDeskCancelTransFB
					.setStrMsg("PODeskCancelTransHLP.getForeignPODetails() --> "
							+ _err.getMessage());
			_poDeskCancelTransFB.setStrMsgType("1");
		}
		return br.toString();
	}

	public static String getScheduleDetails(
			PODeskCancelTransFB _poDeskCancelTransFB) {

		StringBuffer br = new StringBuffer("");
		StringBuffer br1 = new StringBuffer("");
		WebRowSet wbResult = null;
		PODeskCancelTransBO poDeskCancelTransBO =null;
		PODeskCancelTransVO poDeskCancelTransVO =null;
		try {
			poDeskCancelTransBO = new PODeskCancelTransBO();
			poDeskCancelTransVO = new PODeskCancelTransVO();
			poDeskCancelTransVO.setStrHospitalCode(_poDeskCancelTransFB.getStrHospitalCode());
			poDeskCancelTransVO.setStrPONo(_poDeskCancelTransFB.getStrPONo());
			poDeskCancelTransVO.setStrStoreId(_poDeskCancelTransFB.getStrStoreId());
			int nTmpJ = 0;
		
			
			poDeskCancelTransBO.getScheduleDetails(poDeskCancelTransVO);
			
			if (poDeskCancelTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskCancelTransVO.getStrMsgString());
			wbResult = poDeskCancelTransVO.getWbScheduleDetail();
			while (wbResult.next()) {
				br1.append("<tr>");
				//br1.append("<td width='5%' class='multiControl'>");
				//br1.append("<input type='radio' name='strDScheduleNo' onclick='disOldDate(this)' disabled value='");
				//br1.append(wbResult.getString(1));
				//br1.append("'>");
				br1.append("</td><td width='35%' class='multiControl'>");
				br1.append(wbResult.getString(1));
				br1.append("</td><td width='30%' class='multiControl'>");
				br1.append(wbResult.getString(2));
				br1.append("<input type=hidden name=strDOldDeliveryDate disabled value='"+wbResult.getString(4)+"'><input type=hidden name='strDScheduleNo'  value='"+wbResult.getString(1)+"'>");
				br1.append("</td><td width='35%' class='multiControl'>");
				br1.append(wbResult.getString(3));
			//	br1.append("</td><td width='25%' class='multiControl'>");
				//br1.append(wbResult.getString(4));
				br1.append("</td></tr>");
				nTmpJ++;
			}
			if (wbResult.size() > 0) {
					br.append("<table class='TABLEWIDTH' bgcolor='black' align='center' cellpadding='1px'");
					br.append("cellspacing='1px'>");
					br.append("<tr>");
					//br.append("<td width='5%' class='multiLabel'>#");
					br.append("</td><td width='35%' class='multiLabel'>Schedule No");
					br.append("</td><td width='30%' class='multiLabel'>Schedule Date");
					br.append("</td><td width='35%' class='multiLabel'>Schedule Type");
				//	br.append("</td><td width='25%' class='multiLabel'>Delivery Date");
					br.append("</td></tr>");
					br.append("</table>");
					
					br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellpadding='1px'");
					br.append("cellspacing='1px'>");
					
					br.append(br1.toString());
					
					br.append("</table>");
					br.append("</div>");
			}

		} catch (Exception _err) {
			_err.printStackTrace();
			_poDeskCancelTransFB
					.setStrMsgString("PODeskCancelTransHLP.getScheduleDetails() --> "
							+ _err.getMessage());
			_poDeskCancelTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
	
	public static String getScheduleDetailsBS(
			PODeskCancelTransFB _poDeskCancelTransFB) {

		StringBuffer br = new StringBuffer("");
		StringBuffer br1 = new StringBuffer("");
		WebRowSet wbResult = null;
		PODeskCancelTransBO poDeskCancelTransBO =null;
		PODeskCancelTransVO poDeskCancelTransVO =null;
		try {
			poDeskCancelTransBO = new PODeskCancelTransBO();
			poDeskCancelTransVO = new PODeskCancelTransVO();
			poDeskCancelTransVO.setStrHospitalCode(_poDeskCancelTransFB.getStrHospitalCode());
			poDeskCancelTransVO.setStrPONo(_poDeskCancelTransFB.getStrPONo());
			poDeskCancelTransVO.setStrStoreId(_poDeskCancelTransFB.getStrStoreId());
			int nTmpJ = 0;
		
			
			poDeskCancelTransBO.getScheduleDetails(poDeskCancelTransVO);
			
			if (poDeskCancelTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskCancelTransVO.getStrMsgString());
			wbResult = poDeskCancelTransVO.getWbScheduleDetail();
			while (wbResult.next()) {
				br1.append("<tr>");
				//br1.append("<td width='5%' class='multiControl'>");
				//br1.append("<input type='radio' name='strDScheduleNo' onclick='disOldDate(this)' disabled value='");
				//br1.append(wbResult.getString(1));
				//br1.append("'>");
				br1.append("</td><td>");
				br1.append(wbResult.getString(1));
				br1.append("</td><td>");
				br1.append(wbResult.getString(2));
				br1.append("<input type=hidden name=strDOldDeliveryDate disabled value='"+wbResult.getString(4)+"'><input type=hidden name='strDScheduleNo'  value='"+wbResult.getString(1)+"'>");
				br1.append("</td><td>");
				br1.append(wbResult.getString(3));
			//	br1.append("</td><td width='25%' class='multiControl'>");
				//br1.append(wbResult.getString(4));
				br1.append("</td></tr>");
				nTmpJ++;
			}
			if (wbResult.size() > 0) {
					br.append("<table class='table'>");
					br.append("<thead>");
					br.append("<tr>");
					//br.append("<th width='5%' class='multiLabel'>#");
					br.append("</th><th>Schedule No");
					br.append("</th><th>Schedule Date");
					br.append("</th><th>Schedule Type");
				//	br.append("</th><th width='25%' class='multiLabel'>Delivery Date");
					br.append("</th></tr>");
					br.append("<tbody>");
					br.append(br1.toString());
					br.append("</tbody></table>");
					//br.append("</div>");
			}

		} catch (Exception _err) {
			_err.printStackTrace();
			_poDeskCancelTransFB
					.setStrMsgString("PODeskCancelTransHLP.getScheduleDetails() --> "
							+ _err.getMessage());
			_poDeskCancelTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
}
