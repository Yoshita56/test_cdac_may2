package mms.transactions.controller.hlp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.global.controller.MmsFB;
import mms.transactions.controller.fb.ChallanProcessTransFB;
import mms.transactions.dao.ChallanProcessTransDAO;
import mms.transactions.vo.ChallanProcessTransVO;

public class ChallanProcessTransBSHLP {

	
	public static String getScheduleAndReceiveDtls(ChallanProcessTransFB formBean){
		
		StringBuffer sb = new StringBuffer("");
		sb.append("<input type='hidden' name='strScheduleNo' id='strScheduleNo' value='"+formBean.getStrScheduleNo()+"'>");
		sb.append("<input type='hidden' name='strScheduleDate' id='strScheduleDate' value='"+formBean.getStrScheduleDate()+"'>");
		sb.append("<input type='hidden' name='strScheduleTypeId' id='strScheduleTypeId' value='"+formBean.getStrScheduleTypeId()+"'>");
		sb.append("<input type='hidden' name='strDeliveryDate' id='strDeliveryDate' value='"+formBean.getStrDeliveryDate()+"'>");
		sb.append("<input type='hidden' name='strScheduleType' id='strScheduleType' value='"+formBean.getStrScheduleType()+"'>");
		
		sb.append(" <table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
		sb.append(" <tr> ");
		sb.append(" <td colspan='4' class='TITLE' width='25%'><div id='' style='display:block;'> Receive Detail(s)</div> </td> ");
		sb.append(" </tr> ");
		sb.append(" </table> ");
		sb.append(" <table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
		sb.append(" <tr> ");
		//sb.append(" <td class='LABEL' width='25%'><font color='red'>*</font>Shelf Life(In Days)</td> ");
		//sb.append(" <td class='CONTROL' width='25%'><input type='text' name='strShelfLife' autocomplete='off' class='txtFldNormal' onkeypress='return validateData(event,7);' tabindex='1' maxlength='4'></td> ");
		sb.append(" <td class='LABEL' width='25%'>Schedule Type</td> ");
		sb.append(" <td class='CONTROL' width='25%'>"+formBean.getStrScheduleType()+"</td> ");
		sb.append(" <td class='LABEL' width='25%'></td> ");
		sb.append(" <td class='CONTROL' width='25%'></td> ");
		sb.append(" </tr> ");
		sb.append(" </table> ");
		
		sb.append(" <table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
		if(formBean.getStrPoTypeId().trim().equals("24"))
		{
			sb.append(" <tr> ");
			sb.append(" <td class='LABEL' width='50%' colspan='2'><font color='red'>*</font>AWB No.</td> ");
			sb.append(" <td class='CONTROL' width='50%' colspan='2'><input type='text' name='strAwbNo' maxlength='15' class='txtFldNormal' onkeypress='return validateData(event,9);' > </td> ");
			sb.append(" </tr> ");
			sb.append(" <tr> ");
			sb.append(" <td class='LABEL' width='25%'><font color='red'>*</font>BE No.</td> ");
			sb.append(" <td class='CONTROL' colspan='1' width='25%'><input type='text' name='strBeNo'  maxlength='15' class='txtFldNormal' onkeypress='return validateData(event,9);' > </td> ");
			sb.append(" <td class='LABEL' width='25%'><font color='red'>*</font>BE Date</td> ");
			sb.append(" <td class='CONTROL' width='25%'> "+HisUtil.getDatePicker("strBeDate", formBean.getStrCtDate(), true)+"</td> ");
			sb.append(" </tr> ");
		}
		sb.append(" <tr> ");
		sb.append(" <td class='LABEL' width='25%'><font color='red'>*</font>No. of Packets</td> ");
		sb.append(" <td class='CONTROL' width='25%'><input type='text' name='strNoOfPackets' autocomplete='off' maxlength='5' class='txtFldNormal' onkeypress='return validateData(event,5);' /></td> ");
		sb.append(" <td class='LABEL' width='25%'>Package Weight (Kg)</td> ");
		sb.append(" <td class='CONTROL' width='25%'><input type='text' name='strPackageWeight' maxlength='6' autocomplete='off' class='txtFldNormal' onkeypress='return validateData(event,7);' /> ");
		sb.append(" </td> ");
		sb.append(" </tr> ");
		
//		sb.append(" <tr> ");
//		sb.append(" <td class='LABEL' width='25%'><font color='red'>*</font>Delivery Mode</td> ");
//		sb.append(" <td class='CONTROL' width='75%' colspan='3'> ");
//		sb.append(" <select name='strDeliveryMode' class='comboNormal'> ");
//		sb.append(formBean.getStrDeliveryModeValues());
//		sb.append(" </select> ");
//		sb.append(" </td> ");
//		sb.append(" </tr>  ");	
		
		
		sb.append(" <tr> "); 
		sb.append(" <td width='25%' class='LABEL'><font color='red'>*</font>Delivery Mode</td>");
		sb.append(" <td class='CONTROL' width='25%'> ");
        sb.append(" <select name='strDeliveryMode' onchange='checkValComboTwo(this);'>");
        sb.append(formBean.getStrDeliveryModeValues());
        sb.append(" </select> ");
        sb.append(" </td> ");
        sb.append(" <td class='CONTROL' width='25%' id='labelIdOne'>");
        sb.append(" <div id='labelNameIdOne'></div>");
        sb.append(" </td>");
        sb.append(" <td class='CONTROL' width='25%'>");
        sb.append(" <div id='nameOtherFldOne' style='display: none'>");
        sb.append(" <input type='text' name='strDeliveryModeText' value=''  maxlength='50'>");
        sb.append(" </div></td></tr>");	  
		
		sb.append(" </table> ");
				
		return sb.toString();
	}
	
	
	public static String getScheduleItemList(ChallanProcessTransFB formBean , ChallanProcessTransVO vo )throws Exception{
		
		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = null;
		HisUtil util = null;
		int count = 0;
		try{
		
			util = new HisUtil("ChallanProcessTrans","ChallanProcessTransHLP");
			
		sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
		sb.append("<tr> ");
		sb.append("<td colspan='4' class='TITLE' width='25%'><div id='' style='display:block;'>Item Detail(s)</div>");
		sb.append("</td> ");
		sb.append("</tr> ");
		sb.append("</table> ");
		sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px' bgcolor='black'> ");
		sb.append("<tr> ");
		sb.append("<td class='multiLabel' width='20%'>Item Name</td> ");
		sb.append("<td class='multiLabel' width='10%'>Ordered Qty.</td> ");
		sb.append(" <td class='multiLabel' width='20%'><font size='2' color='red'>*</font>Mfg. Date</td>");
		sb.append(" <td class='multiLabel' width='20%'><font size='2' color='red'>*</font>Exp. Date</td>");
		sb.append("<td class='multiLabel' width='10%'><font color='red'>*</font>Received Qty.</td> ");
		sb.append("<td class='multiLabel' width='20%'><font color='red'>*</font>Unit Name</td> ");
		sb.append("</tr> ");
		
		sb.append("</table> ");
		sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px' bgcolor='#1277b5'> ");
		ws = vo.getWsScheduleItemList();
		
		
		if(ws != null && ws.size() > 0){
			
			while(ws.next()){
				
				count = count + 1;
				
				String strHidden = ws.getString(1);
				String strItemName = ws.getString(2);
				String strBalQty = ws.getString(3);
				String strOrdQty = ws.getString(4);
				String strRecQty = ws.getString(5);
				String strManfName = ws.getString(6);
				String strRate		= ws.getString(7);
				
				String strUnit = strHidden.replace("^", "#").split("#")[3];
				String strReqQty = strHidden.replace("^", "#").split("#")[2];
				vo.setStrUnitId(strUnit);
				
				ChallanProcessTransDAO.unitNameCombo(vo);
				
				String unitValues = util.getOptionValue(vo.getWsUnitList(), strUnit, "0^Select Value", true , false);
				
				
				sb.append("<tr> ");
				sb.append("<td><input type='hidden' value='"+ws.getString(8)+"' name='strShelfLifeFromPO'></td>");
				sb.append("<td class='multiControl' width='20%'><input type='hidden' name='strItemDtls' id='strItemDtls"+count+"' value='"+strHidden+"' ><a style='color:blue;cursor: pointer' title='Get Item Detials' onclick='showItemDtls(this,\""+strManfName+"\",\""+strRate+"\",\""+strItemName+"\");' >"+strItemName+"</a></td> ");
				sb.append("<td class='multiControl' width='10%'><a style='color:blue;cursor: pointer' title='Get Balance Quantity Details' onclick='showBalQtyDtls(this,\""+strOrdQty+"\",\""+strRecQty+"\" ,\""+strItemName+"\");'>"+strBalQty+"</a></td> ");
				sb.append("<td CLASS='multiControl' width='20%'>"+HisUtil.getDatePicker("strMultiRowManufacterDate"+count+"", "", true) + "</td>");
				sb.append("<td CLASS='multiControl' width='20%'>"+HisUtil.getDatePicker("strMultiRowExpireDate"+count+"", "", true) + "</td>");
				sb.append("<td class='multiControl' width='10%'> <input type='text' name='strReceivedQty' id='strReceivedQty"+count+"' onkeyup='checkQtyDtls("+count+", \"strReceivedQty\", \"strReceivedUnitId\");' onkeypress='return validateData(event,5);' maxlength='11'  class='txtFldNormal' value='"+"0"+"' ></td> ");
				sb.append("<td class='multiControl' width='20%'> <select name='strReceivedUnitId' id='strReceivedUnitId"+count+"' onchange='checkQtyDtls("+count+", \"strReceivedQty\", \"strReceivedUnitId\");'  class='comboMin'>");
				sb.append(unitValues);
				sb.append("</select> </td> ");
				sb.append("</tr> ");
				
				
			}
			
		}else{
			
			sb.append("<tr> ");		 
			sb.append("<td colspan='4' class='multiControl' width='25%'><font color='red'>No Record Available </font> ");
			sb.append("</td> ");
			sb.append("</tr> ");
			
		}
		
		
		sb.append("<tr> ");		 
		sb.append("<td colspan='4' class='TITLE' width='25%'> ");
		sb.append("</td> ");
		sb.append("</tr> ");
		sb.append("</table> ");
		
		}catch (Exception e) {
			
			throw e;
			
		}finally{
			util = null;
		}
		
		return sb.toString();
	}
		
	
	public static String createMemberDetails(ChallanProcessTransFB formBean , WebRowSet ws )
	{ 
		StringBuffer br = new StringBuffer();
		WebRowSet wb1=null;
		int count=0;
			try{
				wb1= ws;
				br.append("<table width='400'>\n");
				br.append("<tr class='HEADER'>\n");
				br.append("<td colspan='2'>Committee Member Details</td>");
				br.append("</tr>\n");
				br.append("<tr>\n");
				br.append("<td class='multiLabel'>\n");
				br.append("Committe Member Name");
				br.append("</td>");
				br.append("<td class='multiLabel'>\n");
				br.append("Recommendation");
				br.append("</td>");
				br.append("</tr>\n");
				
				if(wb1!=null && wb1.size()!=0){
					
					
					while(wb1.next())
					{
						br.append("<tr>\n");
						br.append("<td class='multiControl'>\n");
						br.append("<input type='hidden' name='strCommitteeMemberHidden' value='"+wb1.getString(1)+"' id='strCommitteeMemberHiddenId="+(++count)+"'/>");
						br.append(wb1.getString(2)+"</td>");
						br.append("<td class='multiControl'>\n");
						br.append("<textarea rows='2' cols='15' name='strMemberRecommendation'></textarea>");
						br.append("</td>");
						br.append("</tr>\n");
					}
				}
				else
				{
					br.append("<tr>\n");
					br.append("<td class='multiControl' colspan='2'>\n");
					br.append("No Record Found");
					br.append("</tr>\n");
				}
				
				br.append("<tr class='FOOTER'>");
				br.append("<td colspan='2' align ='center'></td>");
				br.append("</tr>");
				br.append("<tr>\n");
				br.append("<td  colspan='2' align='center'>\n");
				br.append("<img src='../../hisglobal/images/btn-ok.png' 	onClick='closePopUpDiv();' style='cursor: pointer;' title='Click Here To Save Remarks'>&nbsp;");
				br.append("<img src='../../hisglobal/images/btn-clr.png' onClick='clearData();' style='cursor: pointer;' title='Click Here To Clear Data'>&nbsp;");
				br.append("<img src='../../hisglobal/images/close_tab.png' onClick='closePopUpDiv();' style='cursor: pointer;' title='Click Here To Close Popup'>");
				br.append("</tr>\n");
				br.append("</table>");
		
		}catch(Exception e){
			try{
				
				throw new Exception("ChallanProcessTransHLP.createMemberDetails--->"+e.getMessage());
			}
			catch(Exception e1)
			{}
		}
		
	return br.toString();
	}
	
	
	
	public static String getBalanceQtyDtls(ChallanProcessTransFB formBean){
		
		StringBuffer br = new StringBuffer("");
				
		br.append(" <table width='450' cellpadding='0' cellspacing='0'> ");
		br.append(" <tr class='HEADER'> ");
		br.append(" <td colspan='2' align='left'> ");
		br.append(" Ordered Qty. Details ");
		br.append(" </td> ");
		br.append(" <td align='right'><img ");
		br.append(" title='To Close PopUp Window' src='../../hisglobal/images/popUp_cancel.JPG' ");
		br.append(" style=' cursor: pointer' align='middle' ");
		br.append(" onclick='hide_popup_menu(\"balQtyDtlsDivId\");'></td> ");
		br.append(" </tr> ");
		br.append(" </table> ");
		br.append(" <table width='450' cellpadding='1px' cellspacing='1px'> ");
		br.append(" <tr> ");
		br.append(" <td width='200' class='LABEL'>Ordered Qty.</td> ");
		br.append(" <td width='200' colspan='2' class='CONTROL'> ");
		br.append(formBean.getStrOrderedQuantityView());
		br.append(" </td> ");
		br.append(" </tr> ");
		br.append(" <tr> "); 
		br.append(" <td width='200' class='LABEL'>Accepted Qty.</td> ");
		br.append(" <td width='200' colspan='2' class='CONTROL'> ");
		br.append(formBean.getStrAcceptedQuantityView());
		br.append(" </td> ");
		br.append(" </tr> ");
		br.append(" <tr> ");
		br.append(" <td width='200'  class='LABEL'>Rejected Qty.</td> ");
		br.append(" <td width='200' colspan='2' class='CONTROL'> ");
		br.append(formBean.getStrRejectedQuantityView());
		br.append(" </td> ");
		br.append(" </tr> ");
		br.append(" </tr> ");
		br.append(" <tr class='FOOTER'><td colspan='3'> ");
		br.append(" </td> ");
		br.append(" </tr> ");
		br.append(" </table> ");
						
		return br.toString();
	}
	
	public static String getChallanReceivedDetails(WebRowSet wb) {
		StringBuffer br = new StringBuffer();
		int i = 0;
							
		try
		{
			
			if (wb != null) 
			{
				if (wb.size() != 0) 
				{
					br.append("<div class='subHeaders'>Challan Received Detail(s)</div><br>");
					br.append("<table class='table'>");
					br.append("<thead class='thead-dark' align='center'>");
					br.append("<tr>");
					br.append("<th width='5%'  style='font-weight:350 !important ;font-size: 16px !important;'>#</th>");
					br.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Challan No</th>");
					br.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Received Date</th>");
					br.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Supp Receipt No</th>");					
					br.append("<th width='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Supp Receipt Date</th>");
					//br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Schedule Type</td>");
					//br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Delivery Mode</td>");
					br.append("</thead> ");
					br.append("</tr>");
					br.append("</table> ");
					while (wb.next()) 
					{
						/*
						 * 1.hstnum_store_id
						 * 2.ddw name
						 * 3.hstnum_po_no 
						 * 4.HSTNUM_CHALLAN_NO
						 * 5.hstdt_challan_date(Received Date)
						 * 6.HSTSTR_SUPP_RECIEPT_NO
						 * 7.HSTSTR_SUPP_RECIEPT_DATE 
						 * 8.HSTNUM_SCHEDULE_TYPE
						 * 9.DECODE(HSTNUM_SCHEDULE_TYPE , 1, 'Fresh Supply' , 2, 'Against Returned') 
						 * 10.HSTNUM_SUPPLIER_ID
						 * 11.Supplier Name
						 * 12.hstnum_deliverymode_id
						 * 13.hststr_delivery_mode_dtl(Delivery Mode Name Other)
						 * 14.delivery_mode_name
						 */
						br.append("<table class='table' cellspacing ='1px' cellpadding='1px'>");
					br.append("<input type='hidden' name='strHiddenChallanValue' id='strHiddenChallanValue"+i +"' value='"
							+ wb.getString(1)+ "$"+ wb.getString(2)+ "$"+ wb.getString(3)+ "$"+ wb.getString(4)+ "$"+ wb.getString(5)+ "$"
							+ wb.getString(6)+ "$"+ wb.getString(7)+ "$"+ wb.getString(8)+ "$"+ wb.getString(9)+ "$"	
							+ wb.getString(10)+ "$"	+ wb.getString(11)+ "$"	+ wb.getString(12)+ "$"	+ wb.getString(13)+ "$"	+ wb.getString(14) + "'/>");	
												
					br.append("<tbody>");												
					br.append("<td width='5%' align='center' id='check"+i+"'>"
							+ "<input type='radio' title='Select One' name='strCheckOne' value='' id='strCheckOne"+i+"' onclick='selectRecord(this,\""+ i + "\"),fetchReceivedItemDetail(this,\""+ i + "\");'></td>");
					br.append("</td>");						
					br.append("<td width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'  >"+ wb.getString(4) + "</td>");
					br.append("<td width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"+ wb.getString(5) + "</td>");
					br.append("<td width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'  >"+ wb.getString(6) + "</td>");
					br.append("<td width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"+ wb.getString(7) + "</td>");
					//br.append("<TD WIDTH='12%'  colspan='1' CLASS='multiControl'>"+ wb.getString(9) + "</TD>");						
					//br.append("<TD WIDTH='12%'  colspan='1' CLASS='multiControl'>"+ wb.getString(14) + "</TD>");
					br.append("</tbody>");
					i++;
				}                  
					br.append("</table> ");
				}				
			}
			if (wb.size() == 0) 
			{
				
				br.append("<div class='subHeaders'>Challan Received Detail(s)</div><br>");
				br.append("<table class='table' align='center' border='0' bgcolor='#1277b5' cellspacing ='1px' cellpadding='1px'>");
				
				br.append("<thead>");
				br.append("<th width='5%'  style='font-weight:350 !important ;font-size: 16px !important;'>#</th>");
				br.append("<th WIDTH='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Challan No</th>");
				br.append("<th WIDTH='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Received Date</th>");
				br.append("<th WIDTH='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Supp Receipt No</th>");					
				br.append("<th WIDTH='20%' style='font-weight:350 !important ;font-size: 16px !important;'>Supp Receipt Date</th>");
				//br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Schedule Type</td>");
				//br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Delivery Mode</td>");
				br.append("</thead> ");
				br.append("</table> ");
				
				br.append("<table class='table' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				br.append("<tbody>");
				br.append("<td colspan='7><b><div id='id' align='center' color='Red'>No Challan Received Detail Found</div></b></td>");
				br.append("</tbody>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {

		}
		//System.out.println(" Challan Received detail in hlp: "+br.toString());
		return br.toString();
	}
	
	
	public static String getReceivedItemDetails(WebRowSet wb) {
		StringBuffer br = new StringBuffer();
		int i = 0;
							
		try
		{
			
			if (wb != null) 
			{
				if (wb.size() != 0) 
				{
					br.append("<div class='row'>");
					br.append("<div class='col-sm-4 subHeaders'>Received Item Detail(s)</div>");
					br.append("</div>");
					br.append("<table class='table' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
					br.append("<thead> ");
					//br.append("<td WIDTH='5%'   colspan='1' class='multiLabel'>#</td>");
					br.append("<th>Received Date</th>");
					br.append("<th>Drug Name</th>");
					br.append("<th>Received Qty</th>");					
					//br.append("<td WIDTH='15%'  colspan='1' class='multiLabel'>Status</td>");
					br.append("</thead> ");
					//br.append("</table> ");
					while (wb.next()) 
					{
						 /*1. REC_DATE
					      *2. CANCEL_DATE 
					      *3. FREEZ_DATE
					      *4. ITEM_NAME 
					      *5. GEN_ITEM_NAME
					      *6. REC_QTY 
					      *7. BAL_QTY 
					      *8. ACCQTY 
					      *9. REJQTY 
					      *10.BRKQTY 
					      *11.STATUS 
					      *12.NVL(HSTNUM_RECIEVED_QTY_UNITID,0) 
					      *13.NVL(HSTNUM_BALQTY_UNITID,0) 
					      *14.NVL(HSTNUM_EXCESSQTY_UNITID,0) 
					      *15.RECQTY_BASE_VAL 
					      *16.BAL_BASE_VAL 
					      *17.HSTNUM_GROUP_ID 
					      *18.GRP_NAME 
					      *19.HSTNUM_SUBGROUP_ID 
					      *20.SUBGRP_NAME*/
						//br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#1277b5 ' cellspacing ='1px' cellpadding='1px'>");

					br.append("<input type='hidden' name='strHiddenReceivedItems' id='strHiddenReceivedItems"+i +"' value='"
							+ wb.getString(1)+ "$"+ wb.getString(2)+ "$"+ wb.getString(3)+ "$"+ wb.getString(4)+ "$"+ wb.getString(5)+ "$"
							+ wb.getString(6)+ "$"+ wb.getString(7)+ "$"+ wb.getString(8)+ "$"+ wb.getString(9)+ "$"	
							+ wb.getString(10)+ "$"	+ wb.getString(11)+ "$"	+ wb.getString(12)+ "$"	+ wb.getString(13)+ "$"	
							+ wb.getString(14)+ "$"	+ wb.getString(15)+ "$"	+ wb.getString(16)+ "$"	+ wb.getString(17)+ "$"	
							+ wb.getString(18)+ "$"	+ wb.getString(19)+ "$"	+ wb.getString(20)+ "$"	+ wb.getString(21)+ "$"	
							+ wb.getString(22)+ "$"	+ wb.getString(23)+ "$"	+ wb.getString(24)+ "$"	+ wb.getString(25)+ "$"	
							+ wb.getString(26)+ "'/>");	
												
					br.append("<tbody>");										
					//br.append("<td width='5%' class='multiLabel' id='check"+i+"'><input type='radio' title='View' name='strRecvdItems' value='' id='strRecvdItems"+i+"' onclick='fetchVerifiedItemDetail(this,\""+ i + "\");'></td>");
					//br.append("</td>");						
					br.append("<TD>"+ wb.getString(1) + "</TD>");
					br.append("<TD>"+ wb.getString(4) + "</TD>");
					br.append("<TD>"+ wb.getString(6) + "</TD>");
					//br.append("<TD WIDTH='15%'  colspan='1' CLASS='multiControl'>"+ wb.getString(11)+ "</TD>");
					br.append("</tbody>");
					i++;
				}          
					br.append("</table> ");

				}				

			}
			if (wb.size() == 0) 
			{
				br.append("<div class='row'>");
				br.append("<div class='col-sm-4 subHeader'>Received Item Detail(s)</div>");
				br.append("</div>");
				br.append("<table class='table' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
				br.append("<thead> ");
				//br.append("<td WIDTH='5%'   colspan='1' class='multiLabel'>#</td>");
				br.append("<th>Received Date</th>");
				br.append("<th>Drug Name</th>");
				br.append("<th>Received Qty</th>");					
				//br.append("<td WIDTH='15%'  colspan='1' class='multiLabel'>Status</td>");
				br.append("</thead> ");
				//br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				br.append("<tbody>");
				br.append("<td colspan='7><b><div id='id' align='center' color='Red'>No Received Item Detail Found</div></b></td>");
				br.append("</tbody>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {

		}
//		System.out.println("getReceivedItemDetails in hlp: "+br.toString());
		return br.toString();
	}
	
	public static String getVerifiedItemDetails(WebRowSet wb) {
		StringBuffer br = new StringBuffer();
		int i = 0;
							
		try
		{
			
			if (wb != null) 
			{
				if (wb.size() != 0) 
				{
					br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#1277b5' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr class='TITLE'>");
					br.append("<td colspan='8'><div id='' align='left'>Verified Item Detail(s)</div></td></tr>");
					br.append("<tr>");					
					br.append("<td WIDTH='35%'  colspan='1' class='multiLabel'>Drug Name</td>");
					br.append("<td WIDTH='15%'  colspan='1' class='multiLabel'>Batch No</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='multiLabel'>Expiry Date</td>");					
					br.append("<td WIDTH='10%'  colspan='1' class='multiLabel'>Accepted Qty.</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='multiLabel'>Rejected Qty.</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='multiLabel'>Breakage Qty</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='multiLabel'>Excess Qty</td>");
					br.append("</tr> ");
					br.append("</table> ");
					br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#1277b5' cellspacing ='1px' cellpadding='1px' >");
					while (wb.next()) 
					{
						/*
						 * 1.hstnum_item_id
						 * 2.hstnum_itembrand_id
						 * 3.Drug Name 
						 * 4.hststr_batch_sl_no
						 * 5.quantities [hstnum_accepted_qty || '^'|| hblnum_rejected_qty  ||''^''|| hstnum_breakage_qty ||''^''||  hstnum_excess_qty  ||'^'|| hstnum_inhand_qty ||'^'|| hstnum_rate]
						 * 6.unitids [HSTNUM_ACCEPTEDQTY_UNITID || '^'|| HBLNUM_REJECTEDQTY_UNITID ||''^''|| HSTNUM_BREAKQTY_UNITID||''^''||HSTNUM_EXCESSQTY_UNITID  ||''^''||HSTNUM_INHAND_QTY_UNITID ||''^''|| HSTNUM_RATE_UNITID] 
						 * 7.hstnum_store_id
						 * 8.hstnum_po_store_id 
						 * 9.hstnum_group_id
						 * 10.hstnum_subgroup_id
						 * 11.hstnum_po_no
						 * 12.hstnum_schedule_no
						 * 13.base_unit_name
						 * 14.verify_date
						 * 15.mfg_date
						 * 16.expiry_date
						 * 17.gstr_remarks 
						 */
						
					br.append("<input type='hidden' name='strHiddenVerifiedItems' id='strHiddenVerifiedItems"+i +"' value='"
							+ wb.getString(1)+ "$"+ wb.getString(2)+ "$"+ wb.getString(3)+ "$"+ wb.getString(4)+ "$"+ wb.getString(5)+ "$"
							+ wb.getString(6)+ "$"+ wb.getString(7)+ "$"+ wb.getString(8)+ "$"+ wb.getString(9)+ "$"	
							+ wb.getString(10)+ "$"	+ wb.getString(11)+ "$"	+ wb.getString(12)+ "$"	+ wb.getString(13)+ "$"	
							+ wb.getString(14)+ "$"	+ wb.getString(15)+ "$"	+ wb.getString(16)+ "$"	+ wb.getString(17)+ "'/>");	
												
					br.append("<TR>");										
					br.append("<TD WIDTH='35%'  colspan='1' CLASS='multiControl'>"+ wb.getString(3) + "</TD>");
					br.append("<TD WIDTH='15%'  colspan='1' CLASS='multiControl'>"+ wb.getString(4) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiControl'>"+ wb.getString(16) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiControl'>"+ wb.getString(5).split("\\^")[0]+" "+ wb.getString(13) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiControl'>"+ wb.getString(5).split("\\^")[1]+" "+ wb.getString(13)+ "</TD>");						
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiControl'>"+ wb.getString(5).split("\\^")[2]+" "+ wb.getString(13) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiControl'>"+ wb.getString(5).split("\\^")[3]+" "+ wb.getString(13) + "</TD>");
					br.append("</TR>");
					
				  
					br.append("<TR>");
					br.append("<td class='multiControl' align = 'center' colspan='7><div id='id' align='center'><img style='cursor: pointer;'	src='../../hisglobal/images/print_tab.gif' onclick='printPage("+i+");' /></div></td>");
					br.append("</TR>");
					br.append("</table> ");
					i++;
					}

				}				

			}
			if (wb.size() == 0) 
			{
				br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#1277b5' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr class='TITLE'>");
				br.append("<td colspan='8'><div id='' align='left'>Verified Item Detail(s)</div></td></tr>");
				br.append("<tr>");					
				br.append("<td WIDTH='35%'  colspan='1' class='multiLabel'>Drug Name</td>");
				br.append("<td WIDTH='15%'  colspan='1' class='multiLabel'>Batch No</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiLabel'>Expiry Date</td>");					
				br.append("<td WIDTH='10%'  colspan='1' class='multiLabel'>Accepted Qty.</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiLabel'>Rejected Qty.</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiLabel'>Breakage Qty</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiLabel'>Excess Qty</td>");
				br.append("</tr> ");
				br.append("</table>");
				br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#1277b5' cellspacing ='1px' cellpadding='1px' >");
				br.append("<TR>");
				br.append("<td class='multiControl' colspan='7><b><div id='id' align='center' color='Red'>No Verified Item Detail Found</div></b></td>");
				br.append("</TR>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {

		}
//		System.out.println("VerifiedItemDetails in hlp: "+br.toString());
		return br.toString();
	}
	
	public static String getPrintItemDetails(WebRowSet ws,String hosCode) throws Exception {

		StringBuffer sb = new StringBuffer("");
		String strMrnNo = "";
		String strMrnDate = "";
		String strPONo="";
		String strPODate="";
		String strVendor="",strdcno="";
		String strItem="";
		String strSup="",strRej="",strRcd="";
		String strAmount="0.00";
		double tot = 0.000,tmpRcd=0.0;
		String strOrderQty="";
		String strExpiryDt="",strbtch="",strmrp="",strPurRate="",strUser="",strBrandId="",tmpId="0",strBal="",stritemTax="" , strRateWithTax="",manuf="";
		/*
		String str2 = "76.39";
		float f = Float.parseFloat(str2);
		String str = "5";
		Float f = new Float(str);
		double d = f.doubleValue();
		
		*/
	//	double cltamt  = 0.00;
	///	double totalCost = 0.00;
		
	//	double cltamt1  = 0.00;
		//double totalCostWithoutSC = 0.00;
		
		
	//	String strStoreName="";
	//	 String returnTo="";
		int i=1;
	//	String strItemTotCost="0.00";
	//	String strItemTotCostWithOutSC ="0.00";
	//	String strBudgetUsed ="0.00";
		HisUtil util = new HisUtil("mms", "getChallanPrintDetails");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(hosCode);	
		
		//String configIssueRate = mmscofigutil.getStrConfigIssueRate();
		DecimalFormat myFormatter = new DecimalFormat("0.00");

		//WebRowSet ws = formBean.getWsIssueDetails();
        
		//String strIssueDate = "";

//		if (formBean.getStrIssueDate().length() > 2) 
//		{
//			strIssueDate = formBean.getStrIssueDate();
//		}
//		
		String strTableWidth = "700";

		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			//System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
		//	System.out.println("the ws length isa  "+ws.getKeyColumns());
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			//sb.append(res.getString("REPORT_TITLE"));
			sb.append(hospitalVO.getHospitalName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
			//sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			//sb.append(hospitalVO.getCity());
			//sb.append(res.getString("CITY"));
			sb.append("Material Receipt Note </font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<br> ");
			sb.append("<br> ");
			/*
			System.out.println("the ws length isa  "+ws.getKeyColumns());
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='cancelPage(\"LIST\");' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr><br></br> ");
			sb.append("</table> ");
			ws.next();
			sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='").append(strTableWidth).append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MATERIAL RECEIVING NOTE-"+ ws.getString("store") +"</b></font></td></tr></table> ");
			*/
			ws.beforeFirst();
			if(ws != null && ws.size() > 0)
			{
				ws.next();
				strMrnNo              = ws.getString("mrn_no");
				strMrnDate            = ws.getString("challan_dt");
				strPONo  		 	  = ws.getString("po_no");
				strPODate	  		  = ws.getString("po_date");
				strVendor             = ws.getString("supp_info");
				strdcno				  = ws.getString("dc_no");
				strUser				  = ws.getString("usr");
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN No. : </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strMrnNo +"</b></font></td>");
				sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN Date. : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strMrnDate +"</b></font></td>");
				sb.append("</tr> ");
				
			//	sb.append("<tr><td width='100%'>--------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				//sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>P.O  : </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPONo +"</b></font></td>");
				sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>P.O Date.  : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPODate +"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='17%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan/Invoice No.: </b></font></td>");
				sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[0]+"</b></font></td>");
				sb.append("<td align='right' width='58%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan/Invoice Date.  : </b></font></td>");
				sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier  : </b></font></td>");
				sb.append("<td align='left' width='80%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strVendor+"</b></font></td>");
				sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				/*sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");*/
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='5'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("</table> ");
				
			
			
			sb.append("<table width='725' align='center' cellpadding='1px' cellspacing='1px'> ");
			sb.append("<tr> ");
			sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.NO.</b></font></td>");
			sb.append("<td align='center' width='28%' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>ITEM DESCRIPTION</b></font></td>");
			sb.append("<td align='center' width='5%'  colspan='7'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>QUANTITY</b></font></td>");
			//sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sup. Qty</b></font></td>");
			//sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rej. Qty</b></font></td>");
			sb.append("<td align='center' width='8%' colspan=2><font face='Verdana, Arial, Helvetica, sans-serif' ><b>AMOUNT</b></font></td>");
			sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
			sb.append("</tr> ");
			
			sb.append("<tr> ");
			sb.append("<td align='center' width='2%'></td>");
			/*sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Generic</b></font></td>");*/
			sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Brand</b></font></td>");
			sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Manufacturer Name</b></font></td>");
			//sb.append("<td align='left' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Code</b></font></td>");
			sb.append("<td align='left' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
			sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Dt</b></font></td>");
			sb.append("<td align='left' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax</b></font></td>");
			sb.append("<td align='left' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur. Rate</b></font></td>");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur.Rate(With Tax)</b></font></td>");
			sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Ord</b></font></td>");
			sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sup</b></font></td>");
			sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rcd</b></font></td>");
			sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Bal</b></font></td>");
			sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
			sb.append("</tr> ");
			
			ws.beforeFirst();

				while (ws.next()) 
				{
					NumberFormat formatter = new DecimalFormat("############.##");  	
						
						strItem				  = ws.getString("item");
						strSup				  = ws.getString("sup_qty");
						strRej				  = ws.getString("rej_qty");
						strRcd				  = ws.getString("rcd_qty");
						strAmount			  = ws.getString("rate");
						strOrderQty			  = ws.getString("po_qty");
						strmrp				  = ws.getString("mrp");
						strExpiryDt			  = ws.getString("exp_dt");
						strbtch 			  = ws.getString("btch");
						strPurRate			  = ws.getString("pur_rate");
						strBrandId			  = ws.getString("id");
						strBal				  = ws.getString("bal_qty");
						stritemTax				  = ws.getString("item_tax");
						strRateWithTax = ws.getString("RATE_WITH_TAX");
						manuf = ws.getString("manuf");
						
						//if(strBrandId.equals(tmpId))
						//	tmpRcd = tmpRcd+Double.parseDouble(strRcd);
						//else
						//	tmpRcd = Double.parseDouble(strRcd);
					sb.append("<tr> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");
					
					
					/*sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strItem.split("/")[0]);
					sb.append("</font></td> ");*/
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strItem.split("/")[1]);
					sb.append("</font></td> ");
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(manuf);
					sb.append("</font></td> ");
//					sb.append("<td align='left' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//					sb.append(strItem.split("/")[3]);
//					sb.append("</font></td> ");
					
					sb.append("<td align='left' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strbtch);
					sb.append("</font></td> ");
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strExpiryDt);
					sb.append("</font></td> ");
					sb.append("<td align='left' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(stritemTax);
					sb.append("</font></td> ");
					
					sb.append("<td align='left' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strPurRate);
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strRateWithTax);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strOrderQty);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+Math.round(Double.parseDouble(strSup))+"</font></td> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strRcd);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strBal+"</font></td> ");
					sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strAmount);
					sb.append("</font></td></tr> ");
					
					
					
					i++;
					tot=tot+Double.parseDouble(ws.getString("rate"));
					tmpId=strBrandId;

				}
				sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right' width='5%' colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL</b></font></td>");
				sb.append("<td colspan='11'></td>");
				sb.append("<td align='center' colspan='13'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+HisUtil.getAmountWithDecimal(tot, 3)+"</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
				sb.append("<tr> ");
////			sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
			sb.append("<td colspan='13' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
			sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By <br><b> &nbsp;&nbsp;</font></td> ");
				//sb.append("<td colspan='5' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Checked By <br><b> &nbsp;&nbsp;</font></td> ");
				sb.append("<td colspan='7' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>signature<br><b> &nbsp;&nbsp;</font></td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
////				sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
				sb.append("<td colspan='13' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
				sb.append("</tr> ");
				sb.append("</table>");
				
			}
				
				
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");
		//	System.out.println("printItemDetails in hlp: "+sb.toString());

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
		finally {
			mmscofigutil = null;
		}
		
		return sb.toString();
	}
	
}
