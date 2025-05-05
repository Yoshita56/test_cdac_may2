/**
 * 
 */
package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.AgendaDeskAddTransBO;
import mms.transactions.controller.fb.AgendaDeskAddTransFB;
import mms.transactions.vo.AgendaDeskAddTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 8-4-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */

public class AgendaDeskAddTransHLP {

	public static String getIndentDetails(AgendaDeskAddTransFB _agendaFB) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wb = null;
		try {
			wb = _agendaFB.getWbIndentDetail();
			if (wb.size() != 0) {
				br.append("<table class='TABLEWIDTH' align='center' bgcolor='black' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='5%' class='multiLabel'><input type='checkbox' name='strCheckAll' onclick='checkAll();'>");
				if(_agendaFB.getStrAgendaType().equals("1"))
					br.append("</td><td width='20%' class='LABEL'>CR/Admission No.");
				else
					br.append("</td><td width='20%' class='LABEL'>Request Period");
				br.append("</td><td width='20%' class='LABEL'>Request No.<div class='popup' id='divPopup' style='display:none'></div>");
				br.append("</td><td width='25%' class='LABEL'>Request Date");
				br.append("</td><td width='25%' class='LABEL'>Raising Store");
				br.append("</td><td width='5%' class='LABEL'>#");
				br.append("</td></tr>");
				br.append("</table>");
				br.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellspacing='1px'>");
				int nTmpI = 0;
				while (wb.next()) {
					br.append("<tr>");
					br.append("<td width='5%' class='CONTROL'>");
					br.append("<input type='checkbox' name='strCheckBox' onclick='checkData();' value='");
					br.append(wb.getString(1));
					br.append("'>");
					
					br.append("<input type='hidden' name='strDReqestNo' value='"+wb.getString(1)+"'>");
					br.append("<input type='hidden' name='strDReqestDate' value='"+wb.getString(2)+"'>");
					br.append("<input type='hidden' name='strDReqestPeriod' value='"+wb.getString(4)+"'>");
					br.append("<input type='hidden' name='strDRaisingStore' value='"+wb.getString(6)+"'>");
					if(_agendaFB.getStrAgendaType().equals("1"))
						br.append("<input type='hidden' name='strDCrAdmNo' value='"+wb.getString(9)+"/ "+wb.getString(10)+"'>");
					br.append("</td><td width='20%' align='center' class='CONTROL'>");
					if(_agendaFB.getStrAgendaType().equals("1"))
						br.append(wb.getString(9)+"/ "+wb.getString(10));
					else
						br.append(wb.getString(8));
					br.append("</td><td width='20%' align='center' class='CONTROL'>");
					br.append(wb.getString(1));
					br.append("</td><td width='25%' align='center' class='CONTROL'>");
					br.append(wb.getString(7));
					br.append("</td><td width='25%' align='center' class='CONTROL'>");
					br.append(wb.getString(5));
					br.append("</td><td width='5%' align='center' class='CONTROL'>");
					br.append("<img src='../../hisglobal/images/Check_List.png' name='imageList' title='Get Item's Detail'  id='DtlPopup"
									+ nTmpI
									+ "' style='cursor: pointer;' onClick='getIndentDtlPopup(this,\""
									+ wb.getString(1) + "\");'/>");
					br.append("</td></tr>");
					nTmpI++;
				}
				br.append("</table>");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				br.append("<tr>");
				br.append("<td colspan='5'  CLASS='CONTROL' ><DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED STORE NAME OR ITEM CATEGORY </div></TD>");

				br.append("</tr>");
				br.append("</table>");

			}
		} catch (Exception _e) {
			_e.printStackTrace();
			_agendaFB.setStrMsg("AgendaDeskAddTransHLP.getIndentDetails() --> "
					+ _e.getMessage());
			_agendaFB.setStrMsgType("1");
		}
		return br.toString();
	}
	
	public static String getIndentItemDetails(AgendaDeskAddTransFB _agendaFB) {

		StringBuffer br = new StringBuffer("");
		AgendaDeskAddTransVO agendaDeskAddTransVO = null;
		AgendaDeskAddTransBO agendaDeskAddTransBO = null;
		WebRowSet wb = null;
		try {
			agendaDeskAddTransVO = new AgendaDeskAddTransVO();
			agendaDeskAddTransBO = new AgendaDeskAddTransBO();
			wb = _agendaFB.getWbIndentItemDetail();
			if (wb.size() != 0) {
				br.append("<table class='TABLEWIDTH' align='center' bgcolor='black' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='5%' class='multiLabel'><input type='checkbox' name='strCheckAllItem' onclick='checkAllItem();'>");
				br.append("</td><td width='35%' class='LABEL'><div align = 'left'>Item Name</div>");
				br.append("</td><td width='15%' class='LABEL'>Available Qty");
				br.append("</td><td width='15%' class='LABEL'>Compiled Qty");
				br.append("</td><td width='15%' class='LABEL'>Approximate Rate");
				br.append("</td><td width='15%' class='LABEL'><div align = 'center'>Rate/Unit</div>");
				br.append("</td></tr>");
				br.append("</table>");
				br.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellspacing='1px'>");
				int nTmpI = 0;
				while (wb.next()) {
					agendaDeskAddTransVO.setStrInventoryUnitId(wb.getString(7));
					agendaDeskAddTransVO.setStrHospitalCode(_agendaFB.getStrHospitalCode());
					agendaDeskAddTransVO.setStrItemId(wb.getString(1));
					agendaDeskAddTransBO.getItemPopupData(agendaDeskAddTransVO);
					if (agendaDeskAddTransVO.getStrMsgType().equals("1"))
						throw new Exception(agendaDeskAddTransVO.getStrMsgString());

					_agendaFB.setStrItemPopupData(agendaDeskAddTransVO.getStrItemPopupData()+"^"+wb.getString(6));
					_agendaFB.setStrItemName(wb.getString(2));
					br.append("<tr>");
					br.append("<td width='5%' class='CONTROL'>");
					br.append("<input type='checkbox' onclick='checkDataItem(this)' name='strCheckBoxItem' id='tdId1"+nTmpI+"' value='");
					br.append(wb.getString(1));
					br.append("#");
					br.append(wb.getString(6));
					br.append("'>");
					br.append("<input type='hidden' name='strDitemId' value='"+wb.getString(10)+"'>");
					br.append("<input type='hidden' name='strDitemBrandId' value='"+wb.getString(1)+"'>");	
					br.append("<input type='hidden' name='strDGroupId' value='"+wb.getString(8).replace("^", "#").split("#")[0]+"'>");
					br.append("<input type='hidden' name='strDSubGroupId' value='"+wb.getString(8).replace("^", "#").split("#")[1]+"'>");
					br.append("<input type='hidden' name='strDCompiledQty' value='"+wb.getString(5)+"'>");
					br.append("<input type='hidden' name='strDCompiledQtyUnit' value='"+wb.getString(9)+"'>");
					
					
					br.append("</td><td width='35%' class='CONTROL'  id='tdId2"+nTmpI+"'>");
					br.append("<a STYLE='CURSOR:POINTER;color:blue' onClick='display_popup_menu(this,\"itemDtlPopup");
					br.append( nTmpI);
					br.append("\",\"250\",\"\");'>");
					br.append(wb.getString(2));
					br.append("</a>");
					br.append("<div class='popup' id='itemDtlPopup");
					br.append(nTmpI);
					br.append("' style='display:none'>");
					br.append(getItemPopupData(_agendaFB,"itemDtlPopup"+nTmpI));
					br.append("</div></td><td width='15%' class='multiControl'  id='tdId3"+nTmpI+"'><div align = 'right'>");
					br.append(wb.getString(3));
					br.append(" ");
					br.append(wb.getString(4));
					br.append("</div></td><td width='15%' class='multiControl'  id='tdId4"+nTmpI+"'><div align = 'right'>");
					br.append(wb.getString(5));
					br.append(" ");
					br.append(wb.getString(4));
					br.append("</div></td><td width='15%' class='multiControl'  id='tdId5"+nTmpI+"'><div align = 'right'>");
					 br.append("<input type='hidden' name ='strDApproxRate' value='"+ wb.getString(11) + "' disabled=true>");
					br.append(wb.getString(11));
					//br.append("<input type=text disabled class='txtFldMin' maxlength=14 onkeyup='notGreaterThan(this,9999999)' onkeypress='return validateData(event,7);' name='strDApproxRate'>");
					br.append("</div></td><td width='15%' class='CONTROL' id='tdId6"+nTmpI+"'><div align = 'center'>");
					agendaDeskAddTransBO.setRateUnitValues(agendaDeskAddTransVO);
					br.append("<select disabled name='strDApproxRateUnit'>");
					br.append(agendaDeskAddTransVO.getStrRateUnitValues());
					br.append("</select></div></td></tr>");
					//System.out.println("agendaDeskAddTransVO.getStrIndentNo().substring(0, 2)==>"+agendaDeskAddTransVO.getStrIndentNo().substring(0, 2));
					//System.out.println("agendaDeskAddTransVO.getStrItemPopupData()"+agendaDeskAddTransVO.getStrItemPopupData().split("\\^")[10]);
					if(agendaDeskAddTransVO.getStrItemId().equals("10"))
					{	
					  br.append("<input type='hidden' name ='strSDFFlag' value='"+ agendaDeskAddTransVO.getStrItemPopupData().split("\\^")[10] + "'>");
					}  
					
					nTmpI++;
				}
				br.append("</table>");
			} else {
				br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>");
				br.append("<tr>");
				br.append("<td colspan='5'  CLASS='multiControl' ><DIV class='errMsg' align='center'>No Record Found</div></TD>");
				br.append("</tr>");
				br.append("</table>");
			}
		} catch (Exception _e) {
			_e.printStackTrace();
			_agendaFB.setStrMsg("AgendaDeskAddTransHLP.getIndentDetails() --> "
					+ _e.getMessage());
			_agendaFB.setStrMsgType("1");
		}
		return br.toString();
	}

	public static String getIndentPopupDetails(AgendaDeskAddTransFB _agendaFB) {

		StringBuffer br = new StringBuffer("");
		WebRowSet wb = null;
		try 
		{
			String reqNo = _agendaFB.getStrIndentNo();
			wb = _agendaFB.getWbIndentDetail();
			if (wb.size() != 0) {
				br.append("<table width='400' border='0' cellspacing ='1' cellpadding='1'>");
				br.append("<tr class='HEADER'>");
				br.append("<th align='left'>Request No::["+reqNo+"]::Item Details</th>");
				br.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp' src='../../hisglobal/images/popUp_cancel.JPG'");
				br.append("onClick='hide_popup_menu(\"divPopup\");'></th>");
				br.append("</tr>");
				br.append("</table>");
				br.append("<table width='400' border='0' bgcolor='#6097BC' cellspacing ='1' cellpadding='1'>");
				br.append("<tr>");
				br.append("<td colspan='1' class='multiLabel'>Item Name</td>");
				br.append("<td colspan='1' class='multiLabel'>Available Qty</td>");
				br.append("<td colspan='1' class='multiLabel'>Sanction Qty</td>");
				br.append("</tr>");
				int nTmpI = 0;
				while (wb.next()) {
					br.append("<tr>");
					br.append("<td colspan='1' class='multiControl'>");
					br.append(wb.getString(2));
					br.append("</td><td colspan='1' class='multiControl'>");
					br.append(wb.getString(3));
					br.append("</td><td colspan='1' class='multiControl'>");
					br.append(wb.getString(4));
					br.append("</td></tr>");
					nTmpI++;
				}
				br.append("</table>");
			}
		} catch (Exception _e) {
			_agendaFB.setStrMsg("AgendaDeskAddTransHLP.getIndentDetails() --> "
					+ _e.getMessage());
			_agendaFB.setStrMsgType("1");
		}
		return br.toString();
	}
	
	public static String getItemPopupData(AgendaDeskAddTransFB _agendaFB,String _strPopupId) {

		StringBuffer br = new StringBuffer("");
		String[] strPopupData = null;
		try {
			strPopupData = _agendaFB.getStrItemPopupData().replace("^", "#").split("#");
			br.append("<table width='550' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
			br.append("<tr  class='HEADER'>");
			br.append("<th colspan='2' align='left'>"+_agendaFB.getStrItemName()+"::: Details</th>");
			br.append("<th colspan='6' align='right'><img  style='cursor:pointer;cursor:pointer'  title='To Close PopUp' src='../../hisglobal/images/popUp_cancel.JPG'");
			br.append("onClick='hide_popup_menu(\"");
			br.append(_strPopupId);
			br.append("\");'></th>");
			br.append("</tr>");
			br.append("</table>");
			br.append("<table width='550' border='0' cellspacing ='1px' cellpadding='1px'>");
			br.append("<tr>");
			br.append("<td width='25%' class='LABEL'>Last Order No.");
			br.append("</td><td width='25%' class='CONTROL'>");
			br.append(strPopupData[0]);
			br.append("</td><td width='25%' class='LABEL'>Last Order Date");
			br.append("</td><td width='25%' class='CONTROL'>");
			br.append(strPopupData[1]);
			br.append("</td></tr>");
			br.append("<tr>");
			br.append("<td width='25%' class='LABEL'>Last Received Qty");
			br.append("</td><td width='25%' class='CONTROL'>");
			br.append(strPopupData[2]);
			br.append("</td><td width='25%' class='LABEL'>Last Received Date");
			br.append("</td><td width='25%' class='CONTROL'>");
			br.append(strPopupData[5]);
			br.append("</td></tr>");
			br.append("<tr>");
			br.append("<td width='25%' class='LABEL'>Last Consumption Qty");
			br.append("</td><td width='25%' class='CONTROL'>");
			br.append(strPopupData[9]);
			br.append("</td><td width='25%' class='LABEL'>Last Purchase Rate/Unit");
			br.append("</td><td width='25%' class='CONTROL'>");
			br.append(strPopupData[3]);
			br.append("</td></tr>");
			br.append("<tr>");
			br.append("<td width='25%' class='LABEL'>Last Supplied By");
			br.append("</td><td width='75%' colspan='3' class='CONTROL'>");
			br.append(strPopupData[4]);
			br.append("</td></tr>");
			br.append("</table>");			
			br.append("<input type='hidden' name='strDLstPoNo' value='"+strPopupData[0]+"'>");
			br.append("<input type='hidden' name='strDLstPoDate' value='"+strPopupData[1]+"'>");
			br.append("<input type='hidden' name='strDLstSupplierId' value='"+strPopupData[6]+"'>");
			br.append("<input type='hidden' name='strDLstRecQty' value='"+strPopupData[2].replace(" ", "#").split("#")[0]+"'>");
			br.append("<input type='hidden' name='strDLstRecQtyUnit' value='"+strPopupData[7]+"'>");
			br.append("<input type='hidden' name='strDLstRecDate' value='"+strPopupData[5]+"'>");
			br.append("<input type='hidden' name='strDLstPurRate' value='"+strPopupData[3].replace("/", "#").split("#")[0]+"'>");
			br.append("<input type='hidden' name='strDLstPurRateUnit' value='"+strPopupData[8]+"'>");
		} catch (Exception _e) {
			_e.printStackTrace();
			_agendaFB.setStrMsg("AgendaDeskAddTransHLP.getItemPopupData() --> "
					+ _e.getMessage());
			_agendaFB.setStrMsgType("1");
		}
		return br.toString();
	}

}
