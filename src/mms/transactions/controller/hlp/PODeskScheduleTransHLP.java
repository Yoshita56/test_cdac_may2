/**
 * 
 */
package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.PODeskScheduleTransBO;
import mms.transactions.controller.fb.PODeskScheduleTransFB;
import mms.transactions.vo.PODeskScheduleTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskScheduleTransHLP {
	public static String getForeignPODetails(
			PODeskScheduleTransFB _poDeskScheduleTransFB) {

		StringBuffer br = new StringBuffer("");
		try {
			br.append("<tr>");
			br.append("<td width='25%' class='LABEL'>Agent Name</td>");
			br.append("<td width='25%' class='CONTROL'>");
			br.append(_poDeskScheduleTransFB.getStrAgentName());
			br.append("<input type=hidden name=strAgentId value='");
			br.append(_poDeskScheduleTransFB.getStrAgentId());
			br.append("'></td><td width='25%' class='LABEL'>CA Agent Name</td>");
			br.append("<td width='25%' class='CONTROL'>");
			br.append(_poDeskScheduleTransFB.getStrCAAgentName());
			br.append("<input type=hidden name=strAgentId value='");
			br.append(_poDeskScheduleTransFB.getStrCAAgent());
			br.append("'></td></tr>");
			br.append("<tr>");
			br.append("<td width='25%' class='LABEL'>Currency</td>");
			br.append("<td width='75%' colspan=3 class='CONTROL'>");
			br.append(_poDeskScheduleTransFB.getStrCurrency());
			br.append("<input type=hidden name=strAgentId value='");
			br.append(_poDeskScheduleTransFB.getStrCurrencyCode());
			br.append("'></td></tr>");

		} catch (Exception _err) {
			_poDeskScheduleTransFB
					.setStrMsg("PODeskScheduleTransHLP.getForeignPODetails() --> "
							+ _err.getMessage());
			_poDeskScheduleTransFB.setStrMsgType("1");
		}
		return br.toString();
	}

	public static String getPOItemDetails(
			PODeskScheduleTransFB _poDeskScheduleTransFB) {

		StringBuffer br = new StringBuffer("");
		StringBuffer br1 = new StringBuffer("");
		WebRowSet wbResult = null;
		int nNoOfSchedule = 0;
		PODeskScheduleTransBO poDeskScheduleTransBO =null;
		PODeskScheduleTransVO poDeskScheduleTransVO =null;
		try 
		{
			poDeskScheduleTransBO = new PODeskScheduleTransBO();
			poDeskScheduleTransVO = new PODeskScheduleTransVO();
			poDeskScheduleTransVO.setStrHospitalCode(_poDeskScheduleTransFB.getStrHospitalCode());
			nNoOfSchedule = Integer.parseInt(_poDeskScheduleTransFB.getStrDNoOfSchedule());
			wbResult = _poDeskScheduleTransFB.getWbPOItemDetail();
			int nTmpJ = 0;
			while (wbResult.next()) 
			{
				poDeskScheduleTransVO.setStrInventoryUnitId(wbResult.getString(11));
				poDeskScheduleTransVO.setStrMatchUnitCmb(wbResult.getString(10));
				// Calling BO Method for Unit Combo
				poDeskScheduleTransBO.setStrScheduledQtyUnitValues(poDeskScheduleTransVO);
				
				if (poDeskScheduleTransVO.getStrMsgType().equals("1"))
					throw new Exception(poDeskScheduleTransVO.getStrMsgString());
				
				br1.append("<tr>");
				br1.append("<td width='5%' class='multiLabel'>");
				br1.append("<input type='checkbox' name='strCheckBox' onclick='checkData(this);' value='");
				br1.append(wbResult.getString(1) + "^" + wbResult.getString(2)+"^"+wbResult.getString(3)+"^"+wbResult.getString(4)+"^"+wbResult.getString(8)+"^"+wbResult.getString(10));
				br1.append("'><input type=hidden name=strDScheduleNo value='#index#' disabled=true>");
				
				
				br1.append("<input type='hidden' name='strDGroupId' value='"+ wbResult.getString(12) + "' disabled=true>");
				br1.append("<input type='hidden' name='strDSubGroupId' value='"+ wbResult.getString(13) + "' disabled=true>");
				br1.append("<input type='hidden' name='strDItemBrandId' value='"+ wbResult.getString(1) + "' disabled=true>");
				br1.append("<input type='hidden' name='strDItemId' value='"+ wbResult.getString(2) + "' disabled=true>");
				br1.append("<input type='hidden' name='strDOrderQty' value='"+ wbResult.getString(3).replace(" ", "#").split("#")[0] + "' disabled=true>");
				br1.append("<input type='hidden' name='strDOrderQtyUnitId' value='"+ wbResult.getString(4) + "' disabled=true>");
				br1.append("<input type='hidden' name='strDRate' value='"+ wbResult.getString(6).replace(" ", "#").split("#")[0] + "' disabled=true>");
				br1.append("<input type='hidden' name='strDRateUnitId' value='"+ wbResult.getString(10) + "' disabled=true>");
				br1.append("<input type='hidden' name='strDItemTax' value='"+ wbResult.getString(7) + "' disabled=true>");
				br1.append("<input type='hidden' name='strDManufacturerId' value='"+ wbResult.getString(8) + "' disabled=true>");
				br1.append("<input type='hidden' name='strDRemarks' value='"+ wbResult.getString(16) + "' disabled=true>");
				br1.append("<input type='hidden' name='strDWarrentyReq' value='"+ wbResult.getString(14) + "' disabled=true>");
				br1.append("<input type='hidden' name='strDInstallationReq' value='"+ wbResult.getString(15) + "' disabled=true>");
				br1.append("<input type='hidden' name='strBaseValue' value='"+ wbResult.getString(17) + "' disabled=true>");
				br1.append("<input type='hidden' name='strOrderUnitWithBaseValue' value='"+ wbResult.getString(18) + "'>");
				br1.append("<input type='hidden' name='strItemName' value='"+ wbResult.getString(5) + "' disabled=true>");
				br1.append("<input type='hidden' name='strRateUnitWithBaseValue' value='"+ wbResult.getString(19) + "'>");
				
				
				br1.append("</td><td width='50%' class='multiControl'>");
				br1.append("<a STYLE='CURSOR:POINTER;' onClick='display_popup_menu(this,\"item"+nTmpJ+"DtlPopup");
				br1.append("#index#");
				br1.append("\",\"250\",\"\");'>");
				br1.append(wbResult.getString(5));
				br1.append("</a>");
				/***********************START Here We Create Pop-UP we get After Clicking Item Name  *************Commented By Amit Kr 7-jan-2011*********************/
				br1.append("<div class='popup' id='item"+nTmpJ+"DtlPopup");
				br1.append("#index#");
				br1.append("' style='display:none'>");
				br1.append("<table width='400' border='0' cellspacing ='1' cellpGenerateing='1'>");
				br1.append("<tr class='HEADER'>");
				br1.append("<th align='left'>"+wbResult.getString(5)+" :: Details</th>");
				br1.append("<th align='right' colspan=4><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG'");
				br1.append("onClick='hide_popup_menu(\"item"+nTmpJ+"DtlPopup");
				br1.append("#index#");
				br1.append("\");'></th>");
				br1.append("</tr>");
				br1.append("</table>");
				br1.append("<table width='400' border='0' cellspacing ='1' cellpGenerateing='1' bgcolor='#6097BC'>");
				br1.append("<tr>");
				br1.append("<td width='25%' class='LABEL'>Rate/ Unit");
				br1.append("</td><td width='25%' class='CONTROL'>");
				br1.append(wbResult.getString(6));
				br1.append("</td><td width='25%' class='LABEL'>Manufacturer Name");
				br1.append("</td><td width='25%' class='CONTROL'>");
				br1.append(wbResult.getString(9));
				br1.append("</td></tr>");
				br1.append("<tr>");
				br1.append("<td width='25%' class='LABEL'>Item Tax");
				br1.append("</td><td width='75%' colspan=3 class='CONTROL'>");
				br1.append(wbResult.getString(7));
				br1.append("%</td></tr>");
				br1.append("</table>");
				br1.append("</div>");
				/***********************END Here We Create Pop-UP we get After Clicking Item Name  *************Commented By Amit Kr 7-jan-2011*********************/
				br1.append("</td><td width='15%' class='multiControl'>");
				br1.append(wbResult.getString(3));
				br1.append("</td><td width='20%' class='multiControl'>");
				br1.append("<input type=text  maxlength='9' onkeypress='return validateData(event,7);' onkeyup='checkOrderQty(this)' autocomplete='off' name=strDScheduledQty class=txtFldNormal disabled=true>");
				br1.append("</td><td width='10%' class='multiControl'>");
				br1.append("<select name=strDScheduledQtyUnit onchange='checkOrderQty(this)' disabled=true>");
				br1.append(poDeskScheduleTransVO.getStrScheduledQtyUnitValues());
				br1.append("</select></td></tr>");
				nTmpJ++;
			}
			if (wbResult.size() > 0) 
			{
				for (int nTmpI = 1; nTmpI <= nNoOfSchedule; nTmpI++) 
				{
							
					br.append("<table class='TABLEWIDTH' align='center'  cellpadding='1px'  cellspacing='1px'>");
					br.append("<tr>");
					br.append("<td class='TITLE' colspan=5>");
					br.append("<div id='divSchedule"
									+ nTmpI
									+ "PlusID' style='display: none;color:blue;' align='left'><img");
					br.append(" src='../../hisglobal/images/plus.gif' onclick='hideAllOtherSchedule(this);' style='cursor: pointer;color:blue;'>");
					br.append(" Schedule "+nTmpI+"</div><div id='divSchedule"
									+ nTmpI
									+ "MinusID' style='display: block;color:blue;' align='left'><img");
					br.append(" src='../../hisglobal/images/minus.gif' style='cursor: pointer;color:blue;'");
					br.append(" onclick='showDiv(\"divSchedule"+nTmpI+"PlusID\"),hideDiv(\"divSchedule"+nTmpI+"MinusID\"),hideDiv(\"divSchedule"+nTmpI+"\")'");
					br.append(">  Schedule "+nTmpI+"</div></td>");
					br.append("</table>");
					br.append("<div id='divSchedule"+nTmpI+"'>");
					br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'");
					br.append("cellspacing='1px'>");
					br.append("<td class='LABEL' colspan=4><font color='red'>*</font>Delivery Days");
					br.append("</td><td class='CONTROL' colspan=2>");
					//br.append(HisUtil.getDatePicker("strDDeliveryDate"+nTmpI, _poDeskScheduleTransFB.getStrPODeliveryDate(), true));
					br.append("<input type=\"text\" name='strDDeliveryDays' value=\"45\"	maxlength=\"2\" onkeypress='return validateData(event,5);' size='5' > (Allowed 7-60 )");
					br.append("<input type='hidden' name='strDDeliveryDate' value='"+_poDeskScheduleTransFB.getStrPODeliveryDate()+"'>");
					br.append("<select  name= 'strDeliveryLocation' id= 'strDeliveryLocation"+nTmpI+"' >");
					br.append(_poDeskScheduleTransFB.getStrDeliveryLocationValues());
					br.append("</select>");
					br.append("</td></tr> ");
					//br.append("<tr>");
					br.append("</table>");
					br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'");
					br.append("cellspacing='1px' bgcolor='black'>");
					br.append("<td width='5%' class='multiLabel'><input type='checkbox' name='strCheckAll' onclick='checkAll(this);'>");
					br.append("</td><td width='50%' class='multiLabel'>Item Name");
					br.append("</td><td width='15%' class='multiLabel'>Order Qty.");
					br.append("</td><td width='20%' class='multiLabel'>Scheduled Qty.");
					br.append("</td><td width='10%' class='multiLabel'>Unit Name");
					br.append("</td></tr>");
					br.append("</table>");
					/**************Comment By Amit Kr 7-jan-2011 Here We Add Schedule Item Details*****************/
					br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px'");
					br.append("cellspacing='1px' bgcolor='#6097BC'>");
					br.append(br1.toString().replace("#index#", ""+nTmpI));
					
					br.append("</table>");
					br.append("</div>");
				}
			}

		} catch (Exception _err) {
			_err.printStackTrace();
			_poDeskScheduleTransFB
					.setStrMsg("PODeskScheduleTransHLP.getPOItemDetails() --> "
							+ _err.getMessage());
			_poDeskScheduleTransFB.setStrMsgType("1");
		}
		return br.toString();
	}
}
