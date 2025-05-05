/**
 * 
 */
package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import mms.transactions.controller.fb.AgendaDeskModifyTransFB;

/**
 * @author Pankaj Kumar
 *
 */
public class AgendaDeskModifyTransHLP {

public static String getIndentDetails(AgendaDeskModifyTransFB _agendaFB){
	
	StringBuffer br = new StringBuffer("");
	WebRowSet wb = null;
	try {
		wb = _agendaFB.getWbIndentDetail();
		if(wb.size() != 0){
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			br.append("<tr>");
			br.append("<td width='5%' class='multiLabel'><input type='checkbox' name='strCheckAll' onclick='checkAll();'>");
			br.append("</td><td width='20%' class='multiLabel'>Indent No.");
			br.append("</td><td width='25%' class='multiLabel'>Indent Date");
			br.append("</td><td width='20%' class='multiLabel'>Item Category");
			br.append("</td><td width='25%' class='multiLabel'>Raising Store");
			br.append("</td><td width='5%' class='multiLabel'>#");
			br.append("</td></tr>");
			int nTmpI=0;
			while (wb.next()){
				br.append("<tr>");
				br.append("<td width='5%' class='multiControl'>");
				br.append("<input type='checkbox' name='strCheckBox' onclick='checkData();' value='");
				br.append(wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"'>");
				br.append("<input type='hidden' name='strCatCode"+nTmpI+"' value='"+wb.getString(4)+"'>");
				
				br.append("<div class='popup' id='indentDtlPopup"+nTmpI+"' style='display:none'>");
				br.append("<table width='400' border='0' cellspacing ='1' cellpModifying='1'>");
				br.append("<tr class='HEADER'>"); 
				br.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' title='To Close PopUp' src='../../hisglobal/images/popUp_cancel.JPG'");
				br.append("onClick='hide_popup_menu(\"indentDtlPopup"+nTmpI+"\");'></th>");
				br.append("</tr>");
				br.append("</table>");  
				br.append("<table width='400' border='0' cellspacing ='1' cellpModifying='1'>");
				br.append("<tr>");
				br.append("<td colspan='1' class='multiLabel'>Item Name</td>");
				br.append("<td colspan='1' class='multiLabel'>Brand Name</td>");
				br.append("<td colspan='1' class='multiLabel'>Required Qty</td>");
				br.append("<td colspan='1' class='multiLabel'>Available Qty</td>");
				br.append("</tr><tr>");
				br.append("<td colspan='1' class='multiControl'><div id ='1'></div></td>");
				br.append("<td colspan='1' class='multiControl'><div id ='2'></div></td>");
				br.append("<td colspan='1' class='multiControl'><div id ='3'></div></td>");
				br.append("<td colspan='1' class='multiControl'><div id ='4'></div></td>");
				br.append("</tr></table></div>");
				
				br.append("</td><td width='20%' class='multiControl'>");
				br.append(wb.getString(1));
				br.append("</td><td width='25%' class='multiControl'>");
				br.append(wb.getString(8));
				br.append("</td><td width='20%' class='multiControl'>");
				br.append(wb.getString(4));
				br.append("</td><td width='25%' class='multiControl'>");
				br.append(wb.getString(11));
				br.append("</td><td width='5%' class='multiControl'>");
				br.append("<img src='../../hisglobal/images/Check_List.png'  style='pointer:hand' onClick='getIndentDtlPopup(this,\"indentDtlPopup"+nTmpI+"\");'/>");
				br.append("</td></tr>");
				nTmpI++;
			}
			br.append("</table>");
		}else {
			    br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			    br.append("<tr>");
			    br.append("<td colspan='5'  CLASS='multiControl' ><DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED STORE NAME OR ITEM CATEGORY </div></TD>");

			    br.append("</tr>");
			    br.append("</table>");
				
		}
	}catch(Exception _e){
		_agendaFB.setStrMsg("AgendaDeskModifyTransHLP.getIndentDetails() --> "
					+_e.getMessage());
		_agendaFB.setStrMsgType("1");
	}
return br.toString();
}
}
