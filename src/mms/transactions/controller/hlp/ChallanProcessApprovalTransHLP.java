package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;


import javax.sql.rowset.WebRowSet;

import mms.transactions.controller.fb.ChallanProcessApprovalTransFB;
import mms.transactions.dao.ChallanProcessApprovalTransDAO;
import mms.transactions.vo.ChallanProcessApprovalTransVO;

public class ChallanProcessApprovalTransHLP {
	
	public static String getScheduleAndReceiveDtls(ChallanProcessApprovalTransFB formBean){
		
		StringBuffer sb = new StringBuffer("");
		
		sb.append(" <table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
		sb.append(" <tr> ");
		sb.append(" <td class='LABEL' width='25%'>Schedule Date</td> ");
		sb.append(" <td class='CONTROL' width='25%'>"+formBean.getStrScheduleDate()+"</td> ");
		sb.append(" <td class='LABEL' width='25%'>Schedule Type</td> ");
		sb.append(" <td class='CONTROL' width='25%'>"+formBean.getStrScheduleType()+"</td> ");
		sb.append(" </tr> ");
		sb.append(" <tr> ");
		sb.append(" <td class='LABEL' width='25%' colspan='1'>Delivery Date</td> ");
		sb.append(" <td class='CONTROL' width='75%' colspan='3'>"+formBean.getStrDeliveryDate()+"</td> ");
		sb.append(" </tr> ");
		sb.append(" </table> ");
		sb.append(" <table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
		sb.append(" <tr> ");
		sb.append(" <td colspan='4' class='TITLE' width='25%'><div id='' style='display:block;'> Receive Details</div> </td> ");
		sb.append(" </tr> ");
		sb.append(" </table> ");
		sb.append(" <table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
		if(formBean.getStrPoTypeId().trim().equals("24")){
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
		sb.append(" <td class='LABEL' width='25%'>No. of Packets</td> ");
		sb.append(" <td class='CONTROL' width='25%'><input type='text' name='strNoOfPackets' maxlength='3' class='txtFldNormal' onkeypress='return validateData(event,5);' /></td> ");
		sb.append(" <td class='LABEL' width='25%'>Package Weight (Kg)</td> ");
		sb.append(" <td class='CONTROL' width='25%'><input type='text' name='strPackageWeight' maxlength='6' class='txtFldNormal' onkeypress='return validateData(event,7);' /> ");
		sb.append(" </td> ");
		sb.append(" </tr> ");
		sb.append(" <tr> ");
		sb.append(" <td class='LABEL' width='25%'><font color='red'>*</font>Delivery Mode</td> ");
		sb.append(" <td class='CONTROL' width='75%' colspan='3'> ");
		sb.append(" <select name='strDeliveryMode' class='comboNormal'> ");
		sb.append(formBean.getStrDeliveryModeValues());
		sb.append(" </select> ");
		sb.append(" </td> ");
		sb.append(" </tr>  ");	
		sb.append(" </table> ");
				
		return sb.toString();
	}
	
	public static String getScheduleItemList(ChallanProcessApprovalTransFB formBean , ChallanProcessApprovalTransVO vo )throws Exception{
		
		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = null;
		HisUtil util = null;
		int count = 0;
		try{
		
			util = new HisUtil("ChallanProcessApprovalTrans","ChallanProcessApprovalTransHLP");
			
		sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px'> ");
		sb.append("<tr> ");
		sb.append("<td colspan='4' class='TITLE' width='25%'><div id='' style='display:block;'>Item Details</div>");
		sb.append("</td> ");
		sb.append("</tr> ");
		sb.append("</table> ");
		sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px' bgcolor='black'> ");
		sb.append("<tr> ");
		sb.append("<td class='multiLabel' width='35%'>Item Name</td> ");
		sb.append("<td class='multiLabel' width='20%'>Balance Qty.</td> ");
		sb.append("<td class='multiLabel' width='20%'><font color='red'>*</font>Received Qty.</td> ");
		sb.append("<td class='multiLabel' width='25%'><font color='red'>*</font>Unit Name</td> ");
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
				
				ChallanProcessApprovalTransDAO.unitNameCombo(vo);
				
				String unitValues = util.getOptionValue(vo.getWsUnitList(), strUnit, "0^Select Value", true , false);
				
				
				sb.append("<tr> ");
				sb.append("<td class='multiPOControl' width='35%'><input type='hidden' name='strItemDtls' id='strItemDtls"+count+"' value='"+strHidden+"' ><a style='color:blue;cursor: pointer' title='Get Item Detials' onclick='showItemDtls(this,\""+strManfName+"\",\""+strRate+"\",\""+strItemName+"\");' >"+strItemName+"</a></td> ");
				sb.append("<td class='multiPOControl' width='20%'><a style='color:blue;cursor: pointer' title='Get Balance Quantity Detials' onclick='showBalQtyDtls(this,\""+strOrdQty+"\",\""+strRecQty+"\" ,\""+strItemName+"\");'>"+strBalQty+"</a></td> ");
				sb.append("<td class='multiPOControl' width='20%'> <input type='text' name='strReceivedQty' id='strReceivedQty"+count+"' onkeyup='checkQtyDtls("+count+", \"strReceivedQty\", \"strReceivedUnitId\");' onkeypress='return validateData(event,7);' maxlength='8'  class='txtFldMin' value='"+strReqQty+"' ></td> ");
				sb.append("<td class='multiPOControl' width='25%'> <select name='strReceivedUnitId' id='strReceivedUnitId"+count+"' onchange='checkQtyDtls("+count+", \"strReceivedQty\", \"strReceivedUnitId\");'  class='comboMin'>");
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
	
	public static String createMemberDetails(ChallanProcessApprovalTransFB formBean , WebRowSet ws )
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
				
				throw new Exception("ChallanProcessApprovalTransHLP.createMemberDetails--->"+e.getMessage());
			}
			catch(Exception e1)
			{}
		}
		
	return br.toString();
	}
	
	public static String getBalanceQtyDtls(ChallanProcessApprovalTransFB formBean){
		
		StringBuffer br = new StringBuffer("");
				
		br.append(" <table width='450' cellpadding='0' cellspacing='0'> ");
		br.append(" <tr class='HEADER'> ");
		br.append(" <td colspan='2' align='left'> ");
		br.append(" Balance Qty. Details ");
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
	
	/**
	 * Gets the challan received details.
	 * @author santoshsinghchauhan
	 * @param wb the wb
	 * 
	 * @return the challan received details
	 */
	public static String getChallanReceivedDetails(WebRowSet wb) {
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
					br.append("<td colspan='8'><div id='' align='left'>Challan Received Detail(s)</div></td></tr>");
					br.append("<tr>");
					br.append("<td WIDTH='5%'   colspan='1' class='multiLabel'>#</td>");
					br.append("<td WIDTH='30%'  colspan='1' class='multiLabel'>Challan No</td>");
					br.append("<td WIDTH='13%'  colspan='1' class='multiLabel'>Received Date</td>");
					br.append("<td WIDTH='13%'  colspan='1' class='multiLabel'>Supp Receipt No</td>");					
					br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Supp Receipt Date</td>");
					//br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Schedule Type</td>");
					//br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Delivery Mode</td>");
					br.append("</tr> ");
					br.append("</table> ");
					br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#1277b5' cellspacing ='1px' cellpadding='1px' >");
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
						
					br.append("<input type='hidden' name='strHiddenChallanValue' id='strHiddenChallanValue"+i +"' value='"
							+ wb.getString(1)+ "$"+ wb.getString(2)+ "$"+ wb.getString(3)+ "$"+ wb.getString(4)+ "$"+ wb.getString(5)+ "$"
							+ wb.getString(6)+ "$"+ wb.getString(7)+ "$"+ wb.getString(8)+ "$"+ wb.getString(9)+ "$"	
							+ wb.getString(10)+ "$"	+ wb.getString(11)+ "$"	+ wb.getString(12)+ "$"	+ wb.getString(13)+ "$"	+ wb.getString(14) + "'/>");	
												
					br.append("<TR>");												
					br.append("<td width='5%' class='multiLabel' id='check"+i+"'><input type='radio' title='Select One' name='strCheckOne' value='' id='strCheckOne"+i+"' onclick='selectRecord(this,\""+ i + "\"),fetchReceivedItemDetail(this,\""+ i + "\");'></td>");
					br.append("</td>");						
					br.append("<TD WIDTH='30%'  colspan='1' CLASS='multiControl'>"+ wb.getString(4) + "</TD>");
					br.append("<TD WIDTH='13%'  colspan='1' CLASS='multiControl'>"+ wb.getString(5) + "</TD>");
					br.append("<TD WIDTH='13%'  colspan='1' CLASS='multiControl'>"+ wb.getString(6) + "</TD>");
					br.append("<TD WIDTH='12%'  colspan='1' CLASS='multiControl'>"+ wb.getString(7) + "</TD>");
					//br.append("<TD WIDTH='12%'  colspan='1' CLASS='multiControl'>"+ wb.getString(9) + "</TD>");						
					//br.append("<TD WIDTH='12%'  colspan='1' CLASS='multiControl'>"+ wb.getString(14) + "</TD>");
					br.append("</TR>");
					i++;
				}                   
					br.append("</table> ");

				}				

			}
			if (wb.size() == 0) 
			{
				br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#1277b5' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr class='TITLE'>");
				br.append("<td colspan='8'><div id='' align='left'>Challan Received Detail(s)</div></td></tr>");
				br.append("<tr>");
				br.append("<td WIDTH='5%'   colspan='1' class='multiLabel'>#</td>");
				br.append("<td WIDTH='30%'  colspan='1' class='multiLabel'>Challan No</td>");
				br.append("<td WIDTH='13%'  colspan='1' class='multiLabel'>Received Date</td>");
				br.append("<td WIDTH='13%'  colspan='1' class='multiLabel'>Supp Receipt No</td>");					
				br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Supp Receipt Date</td>");
			//	br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Schedule Type</td>");
			//	br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Delivery Mode</td>");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				br.append("<TR>");
				br.append("<td class='multiControl' colspan='7><b><div id='id' align='center' color='Red'>No Challan Received Detail Found</div></b></td>");
				br.append("</TR>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {

		}
		//System.out.println(" Challan Received detail in hlp: "+br.toString());
		return br.toString();
	}
	
	public static String getChallanReceivedDetailsBS(WebRowSet wb) {
		StringBuffer br = new StringBuffer();
		int i = 0;
							
		try
		{
			
			if (wb != null) 
			{
				if (wb.size() != 0) 
				{
					
					br.append("<div class='row'><div class='col-sm-12'><p class='subHeaders'>Challan Received Detail(s)</p></div></div>");
					br.append("<table class='table' >");
					br.append("<thead class='thead-dark'>");
					br.append("<tr>");
					br.append("<th width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>#</th>");
					br.append("<th width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Challan No</th>");
					br.append("<th width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Received Date</th>");
					br.append("<th width='30%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Supp Receipt No</th>");					
					br.append("<th width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Supp Receipt Date</th>");
					//br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Schedule Type</td>");
					//br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Delivery Mode</td>");
					br.append("</tr> ");
					br.append("</thead>");
					br.append("<tbody>");
					
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
						
					br.append("<input type='hidden' name='strHiddenChallanValue' id='strHiddenChallanValue"+i +"' value='"
							+ wb.getString(1)+ "$"+ wb.getString(2)+ "$"+ wb.getString(3)+ "$"+ wb.getString(4)+ "$"+ wb.getString(5)+ "$"
							+ wb.getString(6)+ "$"+ wb.getString(7)+ "$"+ wb.getString(8)+ "$"+ wb.getString(9)+ "$"	
							+ wb.getString(10)+ "$"	+ wb.getString(11)+ "$"	+ wb.getString(12)+ "$"	+ wb.getString(13)+ "$"	+ wb.getString(14) + "'/>");	
												
					br.append("<tr>");												
					br.append("<td width='10%' align='center' id='check"+i+"'><input type='radio' title='Select One' name='strCheckOne' value='' id='strCheckOne"+i+"' onclick='selectRecord(this,\""+ i + "\"),fetchReceivedItemDetail(this,\""+ i + "\");'></td>");
					br.append("</td>");
					
					br.append("<td width='20%' align='center'>"+ wb.getString(4) + "</td>");
					br.append("<td width='20%' align='center'>"+ wb.getString(5) + "</td>");
					br.append("<td width='30%' align='center'>"+ wb.getString(6) + "</td>");
					br.append("<td width='20%' align='center'>"+ wb.getString(7) + "</td>");
					//br.append("<TD WIDTH='12%'  colspan='1' CLASS='multiControl'>"+ wb.getString(9) + "</TD>");						
					//br.append("<TD WIDTH='12%'  colspan='1' CLASS='multiControl'>"+ wb.getString(14) + "</TD>");
					br.append("</tr>");
					i++;
				}                   
					br.append("</tbody> ");
					br.append("</table> ");
					

				}				

			}
			if (wb.size() == 0) 
			{
				br.append("<div class='row'><div class='col-sm-12'><p class='subHeaders'>Challan Received Detail(s)</p></div></div>");
				br.append("<table class='table'>");
				br.append("<thead>");
				
				br.append("<tr>");
				br.append("<th width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>#</th>");
				br.append("<th width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Challan No</th>");
				br.append("<th width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Received Date</th>");
				br.append("<th width='30%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Supp Receipt No</th>");					
				br.append("<th width='20%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Supp Receipt Date</th>");
			//	br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Schedule Type</td>");
			//	br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Delivery Mode</td>");
				br.append("</tr> ");
				br.append("<thead>");
				br.append("</table> ");
				
				br.append("<table class='table'>");
				br.append("<tr>");
				br.append("<td align='center' style='font-weight:350 !important ;font-size: 16px !important;' colspan='7'><b><div id='id' align='center' color='Red'>No Challan Received Detail Found</div></b></td>");
				br.append("</tr>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {

		}
		//System.out.println(" Challan Received detail in hlp: "+br.toString());
		return br.toString();
	}
	
	/**
	 * Gets the received item details.
	 * @author santoshsinghchauhan
	 * @param wb the wb
	 * 
	 * @return the received item details
	 */
	public static String getReceivedItemDetails(WebRowSet wb) {
		StringBuffer br = new StringBuffer();
		int i = 0;
							
		try
		{
			
			if (wb != null) 
			{
				if (wb.size() != 0) 
				{
					br.append("<table class='table'>");
					br.append("<thead class='thead-dark'>");
					br.append("<tr>");
					br.append("<th colspan='8'><div id='' align='left'>Received Item Detail(s)1</div></th>");
					
					//br.append("<td WIDTH='5%'   colspan='1' class='multiLabel'>#</td>");
					br.append("<th  WIDTH='15%'  colspan='1' style='font-weight:350 !important ;font-size: 16px !important;'>Received Date</th>");
					br.append("<th  WIDTH='55%'  colspan='1' style='font-weight:350 !important ;font-size: 16px !important;'>Drug Name</th>");
					br.append("<th  WIDTH='10%'  colspan='1' style='font-weight:350 !important ;font-size: 16px !important;'>Received Qty</th>");					
					//br.append("<td WIDTH='15%'  colspan='1' class='multiLabel'>Status</td>");
					br.append("</tr> ");
					br.append("</thead>");
					br.append("</table> ");
					br.append("<table class='table' >");
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
						
					br.append("<input type='hidden' name='strHiddenReceivedItems' id='strHiddenReceivedItems"+i +"' value='"
							+ wb.getString(1)+ "$"+ wb.getString(2)+ "$"+ wb.getString(3)+ "$"+ wb.getString(4)+ "$"+ wb.getString(5)+ "$"
							+ wb.getString(6)+ "$"+ wb.getString(7)+ "$"+ wb.getString(8)+ "$"+ wb.getString(9)+ "$"	
							+ wb.getString(10)+ "$"	+ wb.getString(11)+ "$"	+ wb.getString(12)+ "$"	+ wb.getString(13)+ "$"	
							+ wb.getString(14)+ "$"	+ wb.getString(15)+ "$"	+ wb.getString(16)+ "$"	+ wb.getString(17)+ "$"	
							+ wb.getString(18)+ "$"	+ wb.getString(19)+ "$"	+ wb.getString(20)+ "$"	+ wb.getString(21)+ "$"	
							+ wb.getString(22)+ "$"	+ wb.getString(23)+ "$"	+ wb.getString(24)+ "$"	+ wb.getString(25)+ "$"	
							+ wb.getString(26)+ "'/>");	
												
					br.append("<tr>");										
				//	br.append("<td width='5%' class='multiLabel' id='check"+i+"'><input type='radio' title='View' name='strRecvdItems' value='' id='strRecvdItems"+i+"' onclick='fetchVerifiedItemDetail(this,\""+ i + "\");'></td>");
				//	br.append("</td>");						
					br.append("<td WIDTH='15%'  colspan='1' style='font-weight:350 !important ;font-size: 16px !important;'>"+ wb.getString(1) + "</td>");
					br.append("<td WIDTH='55%'  colspan='1' style='font-weight:350 !important ;font-size: 16px !important;'>"+ wb.getString(4) + "</td>");
					br.append("<td WIDTH='10%'  colspan='1' style='font-weight:350 !important ;font-size: 16px !important;''>"+ wb.getString(6) + "</td>");
					//br.append("<TD WIDTH='15%'  colspan='1' CLASS='multiControl'>"+ wb.getString(11)+ "</TD>");
					br.append("</tr>");
					i++;
				}                   
					br.append("</table> ");
				}				

			}
			if (wb.size() == 0) 
			{
				br.append("<table class='table'>");
				br.append("<thead class='thead-dark'>");
				br.append("<tr >");
				br.append("<td colspan='8' style='font-weight:350 !important ;font-size: 16px !important;'><div id='' align='left'>Received Item Detail(s)11</div></td></tr>");
				br.append("<tr>");
				//br.append("<td WIDTH='5%'   colspan='1' class='multiLabel'>#</td>");
				br.append("<td WIDTH='15%'  colspan='1' style='font-weight:350 !important ;font-size: 16px !important;'>Received DD Date</td>");
				br.append("<td WIDTH='55%'  colspan='1' style='font-weight:350 !important ;font-size: 16px !important;'>Drug Name</td>");
				br.append("<td WIDTH='10%'  colspan='1' style='font-weight:350 !important ;font-size: 16px !important;'>Received Qty</td>");					
				//br.append("<td WIDTH='15%'  colspan='1' class='multiLabel'>Status</td>");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table class='table'  >");
				br.append("<TR>");
				br.append("<td colspan='7' style='font-weight:350 !important ;font-size: 16px !important;' ><b><div id='id' align='center' color='Red'>No Received Item Detail Found</div></b></td>");
				br.append("</TR>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {

		}
//		System.out.println("getReceivedItemDetails in hlp: "+br.toString());
		return br.toString();
	}
	
	/**
	 * Gets the verified item details.
	 * @author santoshsinghchauhan
	 * @param wb the wb
	 * 
	 * @return the verified item details
	 */
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
					i++;
				}                   
					br.append("</table> ");

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
				br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
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
	
	/**
	 * Gets the challan dtl for cancel page.
	 * @author vivek
	 * @param wb the wb
	 * 
	 * @return the challan dtl hlp
	 */
	public static String getChallanDtlForFreeze(WebRowSet wb) {
		StringBuffer br = new StringBuffer();
		
		/*
		 * 1.hstnum_store_id
		 * 2.ddw name
		 * 3.hstnum_po_no 
		 * 4.HSTNUM_CHALLAN_NO
		 * 5.HSTSTR_SUPP_RECIEPT_NO
		 * 6.HSTSTR_SUPP_RECIEPT_DATE 
		 * 7.HSTNUM_SCHEDULE_TYPE
		 * 8.DECODE(HSTNUM_SCHEDULE_TYPE , 1, 'Fresh Supply' , 2, 'Against Returned') 
		 * 9.HSTNUM_SUPPLIER_ID
		 * 10.Supplier Name
		 */
		
		try
		{
			
			if (wb != null) 
			{
				if (wb.size() != 0) 
				{
					
					while (wb.next()) 
					{						
						br.append("<input type='hidden' name='strChallanDetails' id='strChallanDetails' value='"
								+ wb.getString(1)+ "$"+ wb.getString(2)+ "$"+ wb.getString(3)+ "$"+ wb.getString(4)+ "$"
								+ wb.getString(5)+ "$"+ wb.getString(6)+ "$"+ wb.getString(7)+ "$"+ wb.getString(8)+ "$"
								+ wb.getString(9)+ "$"+ wb.getString(10)+ "' />");
						br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px'>");
						br.append("<tr>");
						br.append("<td width='25%' colspan='1' class='LABEL'>Store Name</td>");
						br.append("<td width='25%' colspan='1' class='CONTROL'>");
						br.append(wb.getString(2));
						br.append("</td>");
						br.append("<td width='25%' colspan='1' class='LABEL'>PO No.</td>");
						br.append("<td width='25%' colspan='1' class='CONTROL'>");
						//br.append(wb.getString(11)+"/"+wb.getString(3));
						br.append(wb.getString(3));//po prefix not in use
						br.append("</td>");
						br.append("</tr>");
						br.append("<tr>");
						br.append("<td width='25%' colspan='1' class='LABEL'>Challan No.</td>");
						br.append("<td width='25%' colspan='1' class='CONTROL'>");
						br.append(wb.getString(4));
						br.append("</td>");
						br.append("<td width='25%' colspan='1' class='LABEL'>Supplier Receipt No.</td>");
						br.append("<td width='25%' colspan='1' class='CONTROL'>");
						br.append(wb.getString(5));
						br.append("</td>");
						br.append("</tr>");
						br.append("<tr>");
						br.append("<td width='25%' colspan='1' class='LABEL'>Supplier Receipt Date</td>");
						br.append("<td width='25%' colspan='1' class='CONTROL'>");
						br.append(wb.getString(6));
						br.append("</td>");
						br.append("<td width='25%' colspan='1' class='LABEL'>Schedule Type</td>");
						br.append("<td width='25%' colspan='1' class='CONTROL'>");
						br.append(wb.getString(8));
						br.append("</td>");
						br.append("</tr>");

						br.append("<tr>");
						br.append("<td width='25%' colspan='1' class='LABEL'>Supplier Name</td>");
						br.append("<td width='25%' colspan='1' class='CONTROL'>");
						br.append(wb.getString(10));
						br.append("</td>");
						br.append("<td width='25%' colspan='1' class='LABEL'></td>");
						br.append("<td width='25%' colspan='1' class='CONTROL'>");
						br.append("");
						br.append("</td>");				
						br.append("</tr>");						
						br.append("</table>");					
						br.append("<input type='hidden' name='strStoreId' value='"+wb.getString(1)+"'>");
						br.append("<input type='hidden' name='strPoNo' value='"+wb.getString(3)+"'>");
						br.append("<input type='hidden' name='strChallanNo' value='"+wb.getString(4)+"'>");
						br.append("<input type='hidden' name='strSupplierReceiptNo' value='"+wb.getString(5)+"'>");
						br.append("<input type='hidden' name='strScheduleType' value='"+wb.getString(7)+"'>");
						
			
					}	                    
					
				}				

			}			
			
		} catch (Exception e) {

		}
		//System.out.println("challan detail in hlp: "+br.toString());
		return br.toString();
	}
	
	public static String getChallanDtlForFreezeBS(WebRowSet wb) {
		StringBuffer br = new StringBuffer();
		
		/*
		 * 1.hstnum_store_id
		 * 2.ddw name
		 * 3.hstnum_po_no 
		 * 4.HSTNUM_CHALLAN_NO
		 * 5.HSTSTR_SUPP_RECIEPT_NO
		 * 6.HSTSTR_SUPP_RECIEPT_DATE 
		 * 7.HSTNUM_SCHEDULE_TYPE
		 * 8.DECODE(HSTNUM_SCHEDULE_TYPE , 1, 'Fresh Supply' , 2, 'Against Returned') 
		 * 9.HSTNUM_SUPPLIER_ID
		 * 10.Supplier Name
		 */
		
		try
		{
			
			if (wb != null) 
			{
				if (wb.size() != 0) 
				{
					
					while (wb.next()) 
					{						
						br.append("<input type='hidden' name='strChallanDetails' id='strChallanDetails' value='"
								+ wb.getString(1)+ "$"+ wb.getString(2)+ "$"+ wb.getString(3)+ "$"+ wb.getString(4)+ "$"
								+ wb.getString(5)+ "$"+ wb.getString(6)+ "$"+ wb.getString(7)+ "$"+ wb.getString(8)+ "$"
								+ wb.getString(9)+ "$"+ wb.getString(10)+ "' />");
						br.append("<div class='row'>");
						br.append("<div class='col-sm-2' ><label>Store Name</label></div>");
						br.append("<div class='col-sm-2' style=\"font-weight: initial;\">"+wb.getString(2)+"</div>");
						br.append("<div class='col-sm-2'><label>PO No.</label></div>");
						br.append("<div class='col-sm-2' style=\"font-weight: initial;\">"+wb.getString(3)+"</div>");
						br.append("<div class='col-sm-2'><label>Challan No.</label></div>");
						br.append("<div class='col-sm-2' style=\"font-weight: initial;\">"+wb.getString(3)+"</div>");
						br.append("</div>");
						br.append("<div class='row'>");
						br.append("<div class='col-sm-2'><label>Supplier Receipt No.</label></div>");
						br.append("<div class='col-sm-2' style=\"font-weight: initial;\">"+wb.getString(5)+"</div>");
						br.append("<div class='col-sm-2'><label>Supplier Receipt Date</label></div>");
						br.append("<div class='col-sm-2' style=\"font-weight: initial;\">"+wb.getString(6)+"</div>");
						br.append("<div class='col-sm-2'><label>Schedule Type</label></div>");
						br.append("<div class='col-sm-2' style=\"font-weight: initial;\">"+wb.getString(8)+"</div>");
						br.append("</div>");
						
						br.append("<div class='row'>");
						br.append("<div class='col-sm-2'><label>Supplier Name</label></div>");
						br.append("<div class='col-sm-10' style=\"font-weight: initial;\">"+wb.getString(10)+"</div>");
						br.append("</div>");
										
						br.append("<input type='hidden' name='strStoreId' value='"+wb.getString(1)+"'>");
						br.append("<input type='hidden' name='strPoNo' value='"+wb.getString(3)+"'>");
						br.append("<input type='hidden' name='strChallanNo' value='"+wb.getString(4)+"'>");
						br.append("<input type='hidden' name='strSupplierReceiptNo' value='"+wb.getString(5)+"'>");
						br.append("<input type='hidden' name='strScheduleType' value='"+wb.getString(7)+"'>");
					}	                    
					
				}				

			}			
			
		} catch (Exception e) {

		}
		//System.out.println("challan detail in hlp: "+br.toString());
		return br.toString();
	}
		
	/**
	 * Gets the Verified Item dtl for cancel.
	 * @author vivek
	 * @param wb the wb
	 * 
	 * @return the challan dtl hlp
	 */
	public static String getVerifiedItemDtlForFreeze(WebRowSet wb) {
		StringBuffer br = new StringBuffer();
		int i = 0;
		int j=1;
							
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
					br.append("<td WIDTH='5%'   colspan='1' class='multiLabel'>Sl No</td>");
					br.append("<td WIDTH='28%'  colspan='1' class='multiLabel'>Drug Name</td>");
					br.append("<td WIDTH='13%'  colspan='1' class='multiLabel'>Batch No</td>");
					br.append("<td WIDTH='13%'  colspan='1' class='multiLabel'>Expiry Date</td>");					
					br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Supplied Qty.</td>");
					br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Accepted Qty.</td>");
					br.append("<td WIDTH='14%'  colspan='1' class='multiLabel'>Rejected/Breakage Qty</td>");
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
						 * 5.expiry_date                  
						 * 6.qty [hstnum_accepted_qty ||''^''|| NVL(HSTNUM_ACCEPTEDQTY_UNITID,0)|| '^'|| hstnum_breakage_qty ||''^''|| NVL(HSTNUM_BREAKQTY_UNITID,0) || '^'|| hblnum_rejected_qty||''^''|| NVL(HBLNUM_REJECTEDQTY_UNITID,0)  || '^' || hstnum_inhand_qty||''^''|| NVL(HSTNUM_INHAND_QTY_UNITID,0) ||'^'|| hstnum_excess_qty ||''^''|| NVL(HSTNUM_EXCESSQTY_UNITID,0)||'^'|| hstnum_shortage_qty||''^''|| NVL(HSTNUM_SHORT_QTY_UNITID,0) ||'^'|| hstnum_recieved_qty||''^''|| NVL(HSTNUM_RECQTY_UNITID,0) ||'^'|| hstnum_qc_rej_qty||''^''|| NVL(HSTNUM_QC_REJQTY_UNITID,0) ||'^'|| hstnum_temp_qty ||'^'|| hstnum_rate||''^''|| NVL(HSTNUM_RATE_UNITID,0)[18]||''^''|| NVL(HSTNUM_RATE,0)[19]] 
						 * 7.status [decode(gnum_isvalid,9, 'Active',2, 'Verified',1, 'Freezed')]
						 * 8.hstnum_store_id 
						 * 9.hstnum_po_store_id
						 * 10.hstnum_supplier_id
						 * 11.hstnum_group_id
						 * 12.hstnum_subgroup_id
						 * 13.hstnum_po_no
						 * 14.hstnum_schedule_no
						 * 15.verify_date
						 * 16.mfg_date
						 * 17.cancel_date
						 * 17.flags [hstnum_qc_req_flag || '^'|| hstnum_backlog_verify_flag || '^'|| hstnum_qc_report_status || '^'|| hstnum_is_online_data]
						 * 19.gstr_remarks 
						 * 20.hststr_cancel_remarks
						 * 21.hstnum_tax
						 * 22.hstnum_penelty
						 * 23.hstnum_modify_count
						 * 24.max(hstnum_slno)
						 * 25.base_unit_name
						 * 26.total_batch
						 * 27.QC_FLAG
						 * 28.HSTDT_PO_DATE
						 * 29 HSTSTR_DEMAND_YEAR
						 * 30 HSTDT_CHALLAN_DATE
						 * 31 HSTDT_RECIEVED_DATE
						 * 32 SSTNUM_POTYPE_ID
						 * 33.Item Catg
						 * 34.Manufacter Id
						 * 35.Accepted Qty Unit Name
						 * 36.Received/Supplied Qty with unit
						 */
						
					br.append("<input type='hidden' name='strHiddenVerifiedChallanValue' id='strHiddenVerifiedChallanValue"+i +"' value='"
							+ wb.getString(1)+ "$"+ wb.getString(2)+ "$"+ wb.getString(3)+ "$"+ wb.getString(4)+ "$"+ wb.getString(5)+ "$"
							+ wb.getString(6)+ "$"+ wb.getString(7)+ "$"+ wb.getString(8)+ "$"+ wb.getString(9)+ "$"	
							+ wb.getString(10)+ "$"	+ wb.getString(11)+ "$"	+ wb.getString(12)+ "$"	+ wb.getString(13)+ "$"	
							+ wb.getString(14)+ "$"	+ wb.getString(15)+ "$"	+ wb.getString(16)+ "$"	+ wb.getString(17)+ "$"	
							+ wb.getString(18)+ "$"	+ wb.getString(19)+ "$"	+ wb.getString(20)+ "$"	+ wb.getString(21)+ "$"	
							+ wb.getString(22)+ "$"	+ wb.getString(23)+ "$"	+ wb.getString(24)+ "$"	+ wb.getString(25)+ "$"	
						    + wb.getString(26)+ "$"	+ wb.getString(27)+ "$"	+ wb.getString(28)+ "$"	+ wb.getString(29)+ "$"	
						    + wb.getString(30)+ "$"	+ wb.getString(31)+ "$"	+ wb.getString(32)+ "$"	+ wb.getString(33)+"$"+ wb.getString(34)+"$"+ wb.getString(37)+"'/>");	
												
					br.append("<TR>");						
					
					
					br.append("<td width='5%' class='multiLabel' >"+j+"</td>");
					br.append("</td>");						
					
					br.append("<TD WIDTH='28%'  colspan='1' CLASS='multiControl'>"+ wb.getString(3) + "</TD>");
					br.append("<TD WIDTH='13%'  colspan='1' CLASS='multiControl'>"+ wb.getString(4) + "</TD>");
					br.append("<TD WIDTH='13%'  colspan='1' CLASS='multiControl'>"+ wb.getString(5) + "</TD>");
					br.append("<TD WIDTH='12%'  colspan='1' CLASS='multiControl'>"+ wb.getString(36) + "</TD>");
					br.append("<TD WIDTH='12%'  colspan='1' CLASS='multiControl'>"+ wb.getString(6).split("\\^")[0]+ " "+wb.getString(35)+"</TD>");						
					br.append("<TD WIDTH='14%'  colspan='1' CLASS='multiControl'>"+ wb.getString(6).split("\\^")[4] +"/"+wb.getString(6).split("\\^")[2]+ "</TD>");
					br.append("</TR>");
					i++;
					j++;
				}                   
					br.append("</table> ");

				}				

			}
			if (wb.size() == 0) 
			{
				br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr> ");
				br.append("<td WIDTH='5%'   colspan='1' class='multiLabel'></td>");
				br.append("<td WIDTH='30%'  colspan='1' class='multiLabel'>Drug Name</td>");
				br.append("<td WIDTH='13%'  colspan='1' class='multiLabel'>Batch No</td>");
				br.append("<td WIDTH='13%'  colspan='1' class='multiLabel'>Expiry Date</td>");					
				br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Supplied Qty.</td>");
				br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Accepted Qty.</td>");
				br.append("<td WIDTH='12%'  colspan='1' class='multiLabel'>Rejected/Breakage Qty</td>");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				br.append("<TR>");
				br.append("<td class='multiControl' colspan='7><b><div id='id' align='center' color='Red'>No Received Item Detail</div></b></td>");
				br.append("</TR>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {

		}
		//System.out.println("verified item detail in hlp: "+br.toString());
		return br.toString();
	}
	
	public static String getVerifiedItemDtlForFreezeBS(WebRowSet wb) {
		StringBuffer br = new StringBuffer();
		int i = 0;
		int j=1;
							
		try
		{
			
			if (wb != null) 
			{
				if (wb.size() != 0) 
				{
					br.append("<p class='subHeaders'>Verified Item Detail(s)</p>");
					br.append("<table class='table'>");
					
					br.append("<tr>");
					br.append("<thead class='thead-dark'>");
					br.append("<th width='10%' style='font-weight:350 !important ;font-size: 16px !important;text-align:center'>Sl No</th>");
					br.append("<th width='30%' style='font-weight:350 !important ;font-size: 16px !important;'>Drug Name</th>");
					br.append("<th width='15%' style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</th>");
					br.append("<th width='10%'style='font-weight:350 !important ;font-size: 16px !important;'>Expiry Date</th>");					
					br.append("<th width='10%'style='font-weight:350 !important ;font-size: 16px !important;'>Supplied Qty.</th>");
					br.append("<th width='10%'style='font-weight:350 !important ;font-size: 16px !important;'>Accepted Qty.</th>");
					br.append("<th width='15%'style='font-weight:350 !important ;font-size: 16px !important;'>Rejected/Breakage Qty</th>");
					br.append("</tr> ");
					br.append("</thead>");
					br.append("<tbody> ");
					while (wb.next()) 
					{
						/*
						 * 1.hstnum_item_id
						 * 2.hstnum_itembrand_id
						 * 3.Drug Name 
						 * 4.hststr_batch_sl_no
						 * 5.expiry_date                  
						 * 6.qty [hstnum_accepted_qty ||''^''|| NVL(HSTNUM_ACCEPTEDQTY_UNITID,0)|| '^'|| hstnum_breakage_qty ||''^''|| NVL(HSTNUM_BREAKQTY_UNITID,0) || '^'|| hblnum_rejected_qty||''^''|| NVL(HBLNUM_REJECTEDQTY_UNITID,0)  || '^' || hstnum_inhand_qty||''^''|| NVL(HSTNUM_INHAND_QTY_UNITID,0) ||'^'|| hstnum_excess_qty ||''^''|| NVL(HSTNUM_EXCESSQTY_UNITID,0)||'^'|| hstnum_shortage_qty||''^''|| NVL(HSTNUM_SHORT_QTY_UNITID,0) ||'^'|| hstnum_recieved_qty||''^''|| NVL(HSTNUM_RECQTY_UNITID,0) ||'^'|| hstnum_qc_rej_qty||''^''|| NVL(HSTNUM_QC_REJQTY_UNITID,0) ||'^'|| hstnum_temp_qty ||'^'|| hstnum_rate||''^''|| NVL(HSTNUM_RATE_UNITID,0)[18]||''^''|| NVL(HSTNUM_RATE,0)[19]] 
						 * 7.status [decode(gnum_isvalid,9, 'Active',2, 'Verified',1, 'Freezed')]
						 * 8.hstnum_store_id 
						 * 9.hstnum_po_store_id
						 * 10.hstnum_supplier_id
						 * 11.hstnum_group_id
						 * 12.hstnum_subgroup_id
						 * 13.hstnum_po_no
						 * 14.hstnum_schedule_no
						 * 15.verify_date
						 * 16.mfg_date
						 * 17.cancel_date
						 * 17.flags [hstnum_qc_req_flag || '^'|| hstnum_backlog_verify_flag || '^'|| hstnum_qc_report_status || '^'|| hstnum_is_online_data]
						 * 19.gstr_remarks 
						 * 20.hststr_cancel_remarks
						 * 21.hstnum_tax
						 * 22.hstnum_penelty
						 * 23.hstnum_modify_count
						 * 24.max(hstnum_slno)
						 * 25.base_unit_name
						 * 26.total_batch
						 * 27.QC_FLAG
						 * 28.HSTDT_PO_DATE
						 * 29 HSTSTR_DEMAND_YEAR
						 * 30 HSTDT_CHALLAN_DATE
						 * 31 HSTDT_RECIEVED_DATE
						 * 32 SSTNUM_POTYPE_ID
						 * 33.Item Catg
						 * 34.Manufacter Id
						 * 35.Accepted Qty Unit Name
						 * 36.Received/Supplied Qty with unit
						 */
						
					br.append("<input type='hidden' name='strHiddenVerifiedChallanValue' id='strHiddenVerifiedChallanValue"+i +"' value='"
							+ wb.getString(1)+ "$"+ wb.getString(2)+ "$"+ wb.getString(3)+ "$"+ wb.getString(4)+ "$"+ wb.getString(5)+ "$"
							+ wb.getString(6)+ "$"+ wb.getString(7)+ "$"+ wb.getString(8)+ "$"+ wb.getString(9)+ "$"	
							+ wb.getString(10)+ "$"	+ wb.getString(11)+ "$"	+ wb.getString(12)+ "$"	+ wb.getString(13)+ "$"	
							+ wb.getString(14)+ "$"	+ wb.getString(15)+ "$"	+ wb.getString(16)+ "$"	+ wb.getString(17)+ "$"	
							+ wb.getString(18)+ "$"	+ wb.getString(19)+ "$"	+ wb.getString(20)+ "$"	+ wb.getString(21)+ "$"	
							+ wb.getString(22)+ "$"	+ wb.getString(23)+ "$"	+ wb.getString(24)+ "$"	+ wb.getString(25)+ "$"	
						    + wb.getString(26)+ "$"	+ wb.getString(27)+ "$"	+ wb.getString(28)+ "$"	+ wb.getString(29)+ "$"	
						    + wb.getString(30)+ "$"	+ wb.getString(31)+ "$"	+ wb.getString(32)+ "$"	+ wb.getString(33)+"$"+ wb.getString(34)+"$"+ wb.getString(37)+"'/>");	
												
					br.append("<TR>");						
					
					
					br.append("<td style='font-weight:350 !important ;font-size: 16px !important;text-align:center'>"+j+"</td>");
					br.append("</td>");						
					
					br.append("<TD style='font-weight:350 !important ;font-size: 16px !important;text-align:left'>"+ wb.getString(3) + "</TD>");
					br.append("<TD style='font-weight:350 !important ;font-size: 16px !important;text-align:left'>"+ wb.getString(4) + "</TD>");
					br.append("<TD style='font-weight:350 !important ;font-size: 16px !important;text-align:center'>"+ wb.getString(5) + "</TD>");
					br.append("<TD style='font-weight:350 !important ;font-size: 16px !important;text-align:center'>"+ wb.getString(36) + "</TD>");
					br.append("<TD style='font-weight:350 !important ;font-size: 16px !important;text-align:center'>"+ wb.getString(6).split("\\^")[0]+ " "+wb.getString(35)+"</TD>");						
					br.append("<TD style='font-weight:350 !important ;font-size: 16px !important;text-align:center'>"+ wb.getString(6).split("\\^")[4] +"/"+wb.getString(6).split("\\^")[2]+ "</TD>");
					br.append("</TR>");
					i++;
					j++;
				}                
					br.append("</tbody> ");
					br.append("</table> ");

				}				

			}
			if (wb.size() == 0) 
			{
				br.append("<table class='table'>");
				br.append("<tr> ");
				br.append("<td width='10%'style='font-weight:350 !important ;font-size: 16px !important;'></td>");
				br.append("<td width='30%'style='font-weight:350 !important ;font-size: 16px !important;'>Drug Name</td>");
				br.append("<td width='15%'style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</td>");
				br.append("<td width='10%'style='font-weight:350 !important ;font-size: 16px !important;'>Expiry Date</td>");					
				br.append("<td width='10%'style='font-weight:350 !important ;font-size: 16px !important;'>Supplied Qty.</td>");
				br.append("<td width='10%'style='font-weight:350 !important ;font-size: 16px !important;'>Accepted Qty.</td>");
				br.append("<td width='15%'style='font-weight:350 !important ;font-size: 16px !important;'>Rejected/Breakage Qty</td>");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table class='table' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				br.append("<TR>");
				br.append("<td colspan='7'><b><div id='id' align='center' color='Red' style='font-weight:350 !important ;font-size: 16px !important;'>No Received Item Detail</div></b></td>");
				br.append("</TR>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {

		}
		//System.out.println("verified item detail in hlp: "+br.toString());
		return br.toString();
	}
}
