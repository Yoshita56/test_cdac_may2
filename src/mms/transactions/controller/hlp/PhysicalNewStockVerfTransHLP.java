package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.PhysicalNewStockVerfTransVO;
public class PhysicalNewStockVerfTransHLP 
{
	
	public static String getIndentDetails(PhysicalNewStockVerfTransVO vo,HttpServletRequest request) 
	{
		StringBuffer sb = new StringBuffer("");
		try 
		{
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{

					String strReqNo = ws.getString(1);
					String strStoreName = ws.getString(2);
					String strIndentDate = ws.getString(3);
					String strItemCatg = ws.getString(4);
					String strIndentType = ws.getString(5);
					String strToStore = ws.getString(6);
					String strIndentStatus = ws.getString(7);
					String strIndentPeriod = ws.getString(8);
					String strApprovedBy = ws.getString(9);
					String strApprovedDate = ws.getString(10);
					String strApprovedlevel = ws.getString(11);
					

					if (strStoreName == null) {
						strStoreName = "----";
					}
					if (strItemCatg == null) {
						strItemCatg = "----";
					}
					if (strReqNo == null) {
						strReqNo = "----";
					}
					if (strIndentDate == null) {
						strIndentDate = "----";
					}
					if (strIndentType == null) {
						strIndentType = "----";
					}
					if (strToStore == null) {
						strToStore = "----";
					}
					if (strIndentStatus == null) {
						strIndentStatus = "----";
					}
					if (strIndentPeriod == null || strIndentPeriod.equals("0")) {
						strIndentPeriod = "----";
					}
					if (strApprovedBy == null) {
						strApprovedBy = "----";
					}
					if (strApprovedDate == null) {
						strApprovedDate = "----";
					}
					if (strApprovedlevel == null) {
						strApprovedlevel = "----";
					}
					sb.append("<input type='hidden' name ='strReqApprovalFlg'  value='" + strIndentStatus + "'>");
					sb.append("<table class='TABLEWIDTH' align='center'   border='0'  cellspacing ='0px'>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>Request type name</td>");
					sb.append("<td width='25%' class='CONTROL'> ");
					sb.append(strIndentType);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Category</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strItemCatg);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Store Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strStoreName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Request No.</td>");
					sb.append("<td width='25%' class='CONTROL'>");	
					sb.append(strReqNo);
					sb.append("</td></tr>");

					sb.append("<tr><td width='25%' class='LABEL'>Request Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentDate);
					sb.append("</td>");
					sb.append("<td width='25%' class='CONTROL'></td>");
					sb.append("<td width='25%' class='CONTROL'>");				
					sb.append("</td></tr>");
					sb.append("</table>");
				}
			} else {
				sb.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='0px'>");
				sb.append("<tr>");
				sb.append("<td colspan='4'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'>No Record Found</div>" + "</TD>");
				sb.append("</tr>");
				sb.append("</table>");

			}
		} catch (Exception e) {
            e.printStackTrace();
			vo.setStrMsgString("PhysicalNewStockVerfTransHLP.getIndentDetails() --> " + e.getMessage());
			vo.setStrMsgType("1");
		}
		return sb.toString();
	}
	
	/**
	 * Gets the breakage details.
	 * 
	 * @param ws the ws
	 * @param strStoreId the str store id
	 * @param strHospitalCode the str hospital code
	 * @param vo the vo
	 * @return the breakage details
	 */
	public static String getAddNewDrugHlp(PhysicalNewStockVerfTransVO vo,HttpServletRequest request) 
	{
		StringBuffer sb = new StringBuffer("");
		sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing='1px'>"); 
		try 
		{
			
//			sb.append("<tr class='FOOTER'>");
//			sb.append("<td colspan='4'></td>");
//			sb.append("</tr>");
			
			/*sb.append("<tr>");
			sb.append("<td class='LABEL' width='20%' colspan='1'><font color='red'>*</font>Programme Name </td>");
			sb.append("<td class='CONTROL' width='30%' colspan='1'>");
			sb.append("<select name='strProgId'  class='comboNormal'>");
			sb.append(vo.getStrProgNameComboWS());
			sb.append("</select>");
			sb.append("</td>");*/
			
			sb.append("<tr>");
			sb.append("<td class='LABEL' width='10%' colspan='1'><font color='red'>*</font>Group Name </td>");
			sb.append("<td class='CONTROL' width='40%' colspan='1'>");
			sb.append("<select name='strGroupId' onchange='getDrugName(this);' class='comboNormal'>");
			sb.append(vo.getStrGroupNameCombo());
			sb.append("</select>");
			sb.append("</td>");
			sb.append("</tr>");
			
			
			sb.append("<tr>");
			sb.append("<td class='LABEL' width='20%' colspan='1'><font color='red'>*</font>Drug/Item Name  </td>");
			sb.append("<td class='CONTROL' width='30%' colspan='1'>");
			sb.append("<div id='drugComboDivID'><select name='strDrugId' id='strDrugId' class='comboMax' onChange='getUnitName(this);'>");
			sb.append(vo.getStrDrugNameCombo());
			sb.append("</select></div>");			
			sb.append("</td>");
		
			sb.append("<td class='LABEL' width='10%' colspan='1'><font color='red'>*</font>Stock Status  </td>");
			sb.append("<td class='CONTROL' width='40%' colspan='1'>");			
			sb.append("<select name='strStatus' class='comboMin' >");
			sb.append(vo.getStrStockStatusCombo());
			sb.append("</select></div>");
			sb.append("</td>");
			sb.append("</tr>");
			
			sb.append("<tr>");
			sb.append("<td class='LABEL' width='20%' colspan='1'><div id='batchId'><font color='red'>*</font>Batch No.  </div></td>");
			sb.append("<td class='CONTROL' width='30%' colspan='1'>");
			sb.append("<input type='text' id='strBatchNo' name='strBatchNo' maxlength='20' class='txtFldMax' onkeypress='return validateData(event,17);' onblur='checkBatchExistence();'/>");
			sb.append("</td>");	
			
			sb.append("<td class='LABEL' width='10%' colspan='1'><font color='red'>*</font>Counted Qty.  </td>");
			sb.append("<td class='CONTROL' width='40%' colspan='1'>");
			sb.append("<input type='text' name='strCountedQty' maxlength='8' class='txtFldMax' onkeypress='return validateData(event,7);' />");
			sb.append("</td>");				
			sb.append("</tr>");
			
			
			
			sb.append("<tr>");
			sb.append("<td class='LABEL' width='20%' colspan='1'><div id='expiryId'><font color='red'>*</font>Expiry Date  </div></td>");
			sb.append("<td class='CONTROL' width='30%' colspan='1'>");
			sb.append(HisUtil.getDatePicker("strExpiryDate" , vo.getStrCurrentDate(), true));
			sb.append("</td>");
			
			sb.append("<td class='LABEL' width='10%' colspan='1'><font color='red'>*</font>Mfg Date  </td>");
			sb.append("<td class='CONTROL' width='40%' colspan='1'>");
			sb.append(HisUtil.getDatePicker("strMfgDate"   , vo.getStrCurrentDate(), true));
			sb.append("</td>");
			sb.append("</tr>");
						
			sb.append("<tr>");		
			sb.append("<td class='LABEL' width='20%' colspan='1'><font color='red'>*</font>Manufacturer Name  </td>");
			sb.append("<td class='CONTROL' width='30%' colspan='1'>");
			sb.append("<div id='subGroupComboDivID'><select name='strSupplierId' class='comboMin'>");
			sb.append(vo.getStrMfgNameCombo());
			sb.append("</select></div>");
			sb.append("</td>");
			
			sb.append("<td class='LABEL' width='10%' colspan='1'><font color='red'>*</font>Rate  </td>");
			sb.append("<td class='CONTROL' width='40%' colspan='1'>");
			sb.append("<input type='text' name='strRate' maxlength='9' class='txtFldMin' onkeypress='return validateData(event,7);' onBlur='checkDecimalValue(this);' />");				
			sb.append("<select name='strRateUnit' class='comboMin' >");
			sb.append(vo.getStrUnitNameCombo());
			sb.append("</select>");
			sb.append("</td>");
			sb.append("</tr>");
			
			
			sb.append("<tr>");
			sb.append("<td class='LABEL' width='20%' colspan='1'>Tender No.  </td>");
			sb.append("<td class='CONTROL' width='30%' colspan='1'>");
			sb.append("<input type='text' name='strTenderNo' maxlength='20' class='txtFldMax' onkeypress='return validateData(event,17);' />");
			sb.append("</td>");
			
			sb.append("<td class='LABEL' width='10%' colspan='1'> PO No. </td>");
			sb.append("<td class='CONTROL' width='40%' colspan='1'>");
			sb.append("<input type='text' name='strPONo' maxlength='20' class='txtFldMax' onkeypress='return validateData(event,7);' onBlur='checkDecimalValue(this);' />");
			sb.append("</td>");
			sb.append("</tr>");				
			
			sb.append("<tr>"); 
			sb.append("<td width='20%' class='LABEL'><font color='red'>*</font>Remarks  </td>"); 
			sb.append("<td class='CONTROL' colspan='3'>"); 
			sb.append("<textarea name='strDrugRemarks' cols='30' rows='2'id='strDrugRemarks' tabindex='1'></textarea> </td>"); 
			sb.append("</tr>"); 
			sb.append("<br>");
			sb.append("<tr class='FOOTER'>"); 
			sb.append("<td colspan='4'></td>"); 
			sb.append("</tr>"); 
			sb.append("</table>");
			
			sb.append("<table align='center' border='0' cellpadding='1px' cellspacing='1px'>"); 			
			sb.append("<tr align='Center'>");			    
			sb.append("<td  colspan='4' ><a id='saveRecordImageDivId' href='#' class='button' title='Save Record' onClick=' return validateMultiRow();' onkeypress='if(event.keyCode==13) validateMultiRow();'><span class='add'>Add</span></a></td>");
			sb.append("</tr>");
			sb.append("</table>");
			
		}
		
		catch (Exception e)
		{
			e.printStackTrace();
			new HisException("Breakage Details Transaction", "PhysicalNewStockVerfTransHLP.getAddNewDrugHlp()-->", e.getMessage());
		}
		
		return sb.toString();
	}
	
	/**
	 * To get Details HLP.
	 * 
	 * @param wrsData_p the WebRowSet	 * @return the batch details table
	 * @throws SQLException the SQL exception
	 */
	public static String getPhyStockVerifiedItemDtls(WebRowSet ws,String mode,String strPhyDtls,HttpServletRequest request) throws SQLException 
	{
	  StringBuffer sbBody = new StringBuffer(1000);
	  StringBuffer br = new StringBuffer(2000);
	  String tempHtmlStr = "",strClass="";
	  int count = 1;
	  double roundTolrance = 0.00;
	  if(mode.equals("1"))
	  {	  
		
		int nColspan = 7;
		int i = 0;
        if(mode.equals("1"))
        {	
			sbBody.append("<div class=' '><table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >" + "");
			sbBody.append("<tr class='HEADER'>" + "<td colspan=\"4\" >To Be Verified Drug Detail(s)</td>" + "</tr>");
			sbBody.append("</table></div>");
        }
        else
        {
        	sbBody.append("<div class='line'><table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >" + "<tr>");
			sbBody.append("<tr>" + "<td colspan=\"4\" >Tender noVerified Drug Detail(s)</td>" + "</tr>");
			sbBody.append("</table></div>");
        }
		
		sbBody.append("<div id='wrapper1' style='margin-left:7.5%' class='TABLEWIDTH panel panel-default table-fixedheader'>");
		sbBody.append("<table id='mainTableRptId1' class='HEADER'><thead><tr id='tableHeaderId1'>");		
		sbBody.append("<td class='multiPOLabelNew' width='3%'  >#</td>");		
		sbBody.append("<td class='multiPOLabelNew' width='15%' >Drug/Item Name</td>");
		//sbBody.append("<td class='multiPOLabelNew' width='15%' >Programme Name</td>");
		sbBody.append("<td class='multiPOLabelNew' width='10%' >Batch No.</td>");
		sbBody.append("<td class='multiPOLabelNew' width='8%' >Stock Status</td>");
		sbBody.append("<td class='multiPOLabelNew' width='8%'  >Available Qty.(A)</td>");
		sbBody.append("<td class='multiPOLabelNew' width='8%'  >Tolerance Limit "+strPhyDtls.split("\\^")[2]+"(%)</td>");
		sbBody.append("<td class='multiPOLabelNew' width='10%'  >Counted Qty. (B)</td>");
		sbBody.append("<td class='multiPOLabelNew' width='8%'  >Variance Qty. (B-A)</td>");
		sbBody.append("<td class='multiPOLabelNew' width='8%'  >Variance Cost</td>");
		sbBody.append("<td class='multiPOLabelNew' width='8%'  >Remarks</td>");
		sbBody.append("</tr></thead>");    
		sbBody.append("<tbody>");
		if (ws != null && ws.size() > 0) 
		{
			   /*
			 * 1.Primary Key [ STORE_ID '^'ITEM_ID'^'ITEMBRAND_ID '^'BATCH_SL_NO'^'STOCK_STATUS_CODE ]
			 * 2.Drug Name
			 * 3.Batch No
			 * 4.Stock Status
			 * 5.Avl Qty
			 * 6.Unit Name
			 * 7.Rate Base Value
			 * 8.New Item Flag
			 * 9.Tolrance Value
			 * 10.Counted Qty
			 * 11.Variance Qty
			 * 12.Variance Cost
			 * 13.Remarks
			 * 14.Tender No
			 * 15.Supplier Id
			 * 16.Stock Status Code
			 * 17.Group Id
			 * 18.Rate Unit Id
			 * 19.Supplier Name
			 * 20.Expiry Date
			 * 21.Manuf Date
			 * */
           try
           {
			while (ws.next()) 
			{				  
				
				
				    roundTolrance = Math.round(0 - (Double.parseDouble(ws.getString(5))* Double.parseDouble(strPhyDtls.split("\\^")[2])/100));
				    sbBody.append("<tr id =trId"+i+">");	    
				   // System.out.println("strHiddenValue"+ws.getString(1));
					sbBody.append("<td width='3%'     id='a"+i+"' style=\"text-align:center;\"><input type='checkbox' name='batchCheckbox' id='batchCheckbox" + i + "'  onclick='clickBatchChkBox(" + i + ")' >"); 
					sbBody.append("<input type='hidden' name='strMultiRemarks' 		     id='strMultiRemarks"+i+"'  	 value='' disabled>");
				    sbBody.append("<input type='hidden' name='strMultiExpiryDate' 		 id='strMultiExpiryDate"+i+"'  	 value='" + ws.getString(18) + "' disabled>");
					sbBody.append("<input type='hidden' name='strMultiMfgDate'  		 id='strMultiMfgDate"+i+"'  	 value='" + ws.getString(19) + "' disabled>");
					sbBody.append("<input type='hidden' name='strMultiSupplierId'  		 id='strMultiSupplierId"+i+"'  	 value='" + ws.getString(13) + "' disabled>");
					//sbBody.append("<input type='hidden' name='strMultiTenderNo'  		 id='strMultiTenderNo"+i+"'  	 value='" + ws.getString(14) + "' disabled>");
					sbBody.append("<input type='hidden' name='strMultiRateUnitId'  		 id='strMultiRateUnitId"+i+"'  	 value='" + ws.getString(16) + "' disabled>");					
					sbBody.append("<input type='hidden' name='strHiddenValue' 		     id='strHiddenValue"+i+"'  	     value='" + ws.getString(1) + "'  disabled>");
					sbBody.append("<input type='hidden' name='strNewItemFlg'  		     id='strNewItemFlg"+i+"'  	     value='" + ws.getString(7) + "'  disabled>");
					sbBody.append("<input type='hidden' name='strTolranceLimit'          id='strTolranceLimit"+i+"'      value='" + roundTolrance + "'disabled >");
					sbBody.append("<input type='hidden' name='strAvlQty'                 id='strAvlQty"+i+"'             value='" + ws.getString(5) + "' disabled>");
					//sbBody.append("<input type='hidden' name='strRateWithBaseValue'      id='strRateWithBaseValue"+i+"'  value='" + ws.getString(7) + "' disabled>");
					sbBody.append("<input type='hidden' name='strCatcode'      id='strCatcode"+i+"'  value='" + ws.getString(21) + "' disabled>");
					sbBody.append("</td>");
					
					sbBody.append("<td width='15%'    id='b"+i+"' style=\"text-align:left;\">" + ws.getString(2) + "</td>");
					//sbBody.append("<td width='15%'    id='c"+i+"' style=\"text-align:center;\">" + ws.getString(23) + "</td>");
					sbBody.append("<td width='10%'    id='d"+i+"' style=\"text-align:center;\">" + ws.getString(3) + "</td>");
					sbBody.append("<td width='8%'    id='e"+i+"' style=\"text-align:center;\">" + ws.getString(4)+ "</td>");
					sbBody.append("<td width='8%'     id='f"+i+"' style=\"text-align:center;\">" + ws.getString(5) + " " + ws.getString(6) + "</td>");
					sbBody.append("<td width='8%'     id='g"+i+"' style=\"text-align:center;\">" + roundTolrance+ "</td>");
					sbBody.append("<td width='10%'     id='h"+i+"' style=\"text-align:center;\"><input type='text' name='strVerifyCountedQty' id='strVerifyCountedQty"+i+"' value='"+ws.getString(10)+"' maxlength='8' class='txtFldMin' disabled='true' onblur='checklength(" + i + ");calculateQtyCost(" + i + ");' onkeypress='return validateData(event,5);return checklength(" + i + ");' /></td>");
					sbBody.append("<td width='8%'     id='i"+i+"' style=\"text-align:center;\"><b><div id='varianceQtyID"+i+"'>" + ws.getString(10)+ "</div></b></td>");
					sbBody.append("<td width='8%'     id='j"+i+"' style=\"text-align:center;\"><b><div id='varianceCostID"+i+"'>" + ws.getString(11)+ "</div></b></td>");					
					sbBody.append("<td width='8%'     id='k"+i+"' style=\"text-align:center;\"><a value='' style='cursor:pointer;'  onClick='openDivItem(this," + i
							+ ",1);' title='Click here to Enter Remarks'><font color='blue'>#</font></a>");
					
					sbBody.append("<div id='remarksId" + i + "' class='popup' style='display:none'>");
					sbBody.append("<table width='600' align='center'>");
					sbBody.append("<tr class='HEADER'><td class='multiPOLabelNew' align='left'>Remarks For " + ws.getString(2) + "</td>");
					sbBody.append("<td class='multiPOLabelNew' align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/stop.png'");
					sbBody.append(" onClick='closeDivItem(" + i + ");' title='Click Here To Close Popup'></td></tr>");
					sbBody.append("</table>");
					
					sbBody.append("<table width='600' align='center' cellspacing='0px' cellpadding='1px'>");
					sbBody.append("<tr><td class='LABEL' width='40%'><div id='remarksLabelId" + i + "'>Remarks</div></td>");
					sbBody.append("<td class='CONTROL' width='60%'><textarea name='strItemRemarks' cols='30' rows='2' id='strItemRemarks"+i+"' disabled>" + (ws.getString(12)) + "</textarea></td>");
					sbBody.append("</tr>");
					sbBody.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
					sbBody.append("<tr ><td colspan='2' class='CONTROL'>");

					sbBody.append("<div class='control_button'><table  class='TABLEWIDTH' align='center'>");
					sbBody.append("<tr id='saveId'>");
					sbBody.append("<td align='center'><div >");
					sbBody.append("<a href='#' style='cursor:pointer;' title='Click Here To Save Remarks For Item' class='button' onClick='closeDivItem("
							+ i + ");'><span class='ok'>Ok</span></a>");
					sbBody.append("</div></td>");
					sbBody.append("</tr>");
					sbBody.append("</table></div>");
					
					sbBody.append("</td></tr>");
					sbBody.append("</table>");
					
					sbBody.append("</div>");
					
					sbBody.append("</td>");					
					sbBody.append("</tr>");
               
                    
				i++;
			}
		
			
           }
           catch(Exception e)
           {
        	   e.printStackTrace();
           }
		} 
		else 
		{
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\"" + nColspan + "\" class=\"multiPOControl\" style=\"text-align: center; color: red;\">No Data Found!</td>");
			sbBody.append("</tr>");
		}
		sbBody.append("</tbody></table></div>");
	  }
	  else
	  {
		    int nColspan = 7;
			int i = 0;
			
			sbBody.append("<div class=' '><table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >" + "<tr>");
			//sbBody.append("<tr>" + "<td colspan=\"4\" >Verified Drug Detail</td>" + "</tr>");
			sbBody.append("<tr class='HEADER'>" + "<td colspan=\"4\" >Verified Drug Detail</td>" + "</tr>");
			sbBody.append("</table></div>");
			sbBody.append("<div id='wrapper1' style='margin-left:7.5%' class='TABLEWIDTH panel panel-default table-fixedheader' >");
			sbBody.append("<table id='mainTableRptId1' class='table table-striped'><thead><tr id='tableHeaderId1'>");		
			sbBody.append("<td class='multiPOLabelNew' width='2%'  >#</td>");		
			sbBody.append("<td class='multiPOLabelNew' width='15%' >Drug/Item Name</td>");
			//sbBody.append("<td class='multiPOLabelNew' width='15%' >Programme Name</td>");
			sbBody.append("<td class='multiPOLabelNew' width='10%' >Batch No.</td>");
			sbBody.append("<td class='multiPOLabelNew' width='8%' >Stock Status</td>");
			sbBody.append("<td class='multiPOLabelNew' width='8%'  >Available Qty.(A)</td>");
			sbBody.append("<td class='multiPOLabelNew' width='8%'  >Tolerance Limit "+strPhyDtls.split("\\^")[2]+"(%)</td>");
			sbBody.append("<td class='multiPOLabelNew'width='10%'  >Counted Qty. (B)</td>");
			sbBody.append("<td class='multiPOLabelNew' width='8%'  >Variance Qty. (B-A)</td>");
			sbBody.append("<td class='multiPOLabelNew' width='8%'  >Variance Cost</td>");
			sbBody.append("<td class='multiPOLabelNew' width='8%'  >Remarks</td>");
			sbBody.append("</tr></thead>");    
			sbBody.append("<tbody>");
			if (ws != null && ws.size() > 0) 
			{
				   /*
				 * 1.Primary Key [ STORE_ID '^'ITEM_ID'^'ITEMBRAND_ID '^'BATCH_SL_NO'^'STOCK_STATUS_CODE ]
				 * 2.Drug Name
				 * 3.Batch No
				 * 4.Stock Status
				 * 5.Avl Qty
				 * 6.Unit Name
				 * 7.Rate Base Value
				 * 8.New Item Flag
				 * 9.Tolrance Value
				 * 10.Counted Qty
				 * 11.Variance Qty
				 * 12.Variance Cost
				 * 13.Remarks
				 * 14.Tender No
				 * 15.Supplier Id
				 * 16.Stock Status Code
				 * 17.Group Id
				 * 18.Rate Unit Id
				 * 19.Supplier Name
				 * 20.Expiry Date
				 * 21.Manuf Date
				 * */
	           try
	           {
				while (ws.next()) 
				{		
					
					    if(ws.getString(8).equals("0"))
					    {	
					    				    	    
					    	    if( Integer.parseInt(ws.getString(10)) >0 && (0-(Integer.parseInt(ws.getString(10))- Integer.parseInt(ws.getString(5)))) > (Math.round(Double.parseDouble(ws.getString(5))* Double.parseDouble(strPhyDtls.split("\\^")[2])/100))) 
						    	{
									strClass = "danger";
								} 
						    	else 
						    	{
									strClass = "";
								}
						    	roundTolrance = Math.round(0 - (Double.parseDouble(ws.getString(5))* Double.parseDouble(strPhyDtls.split("\\^")[2])/100));
								sbBody.append("<tr id =trId"+i+" class='" + strClass + "'>");					
								
								sbBody.append("<td width='2%'    id='a"+i+"' 	style=\"text-align:center;\"><input type='checkbox' name='batchCheckbox' id='batchCheckbox" + i + "'  onclick='clickBatchChkBox(" + i + ")' >"); 
								sbBody.append("<input type='hidden' name='strMultiRemarks' 		     id='strMultiRemarks"+i+"'  	 value='' disabled>");
							    sbBody.append("<input type='hidden' name='strMultiExpiryDate' 		 id='strMultiExpiryDate"+i+"'  	 value='" + ws.getString(20) + "' disabled>");
								sbBody.append("<input type='hidden' name='strMultiMfgDate'  		 id='strMultiMfgDate"+i+"'  	 value='" + ws.getString(21) + "' disabled>");
								sbBody.append("<input type='hidden' name='strMultiSupplierId'  		 id='strMultiSupplierId"+i+"'  	 value='" + ws.getString(15) + "' disabled>");
								//sbBody.append("<input type='hidden' name='strMultiTenderNo'  		 id='strMultiTenderNo"+i+"'  	 value='" + ws.getString() + "' disabled>");
								sbBody.append("<input type='hidden' name='strMultiRateUnitId'  		 id='strMultiRateUnitId"+i+"'  	 value='" + ws.getString(18) + "' disabled>");					
								sbBody.append("<input type='hidden' name='strHiddenValue' 		     id='strHiddenValue"+i+"'  	     value='" + ws.getString(1) + "'  disabled>");
								sbBody.append("<input type='hidden' name='strNewItemFlg'  		     id='strNewItemFlg"+i+"'  	     value='" + ws.getString(8) + "'  disabled>");
								sbBody.append("<input type='hidden' name='strTolranceLimit'          id='strTolranceLimit"+i+"'      value='" + roundTolrance + "' >");
								sbBody.append("<input type='hidden' name='strAvlQty'                 id='strAvlQty"+i+"'             value='" + ws.getString(5) + "' >");
								//sbBody.append("<input type='hidden' name='strRateWithBaseValue'      id='strRateWithBaseValue"+i+"'  value='" + ws.getString(7) + "' disabled>");
								sbBody.append("<input type='hidden' name='strCatcode'      id='strCatcode"+i+"'  value='" + ws.getString(24) + "' disabled>");
								sbBody.append("</td>");
								sbBody.append("<td width='15%'   id='b"+i+"' 	style=\"text-align:right;\">" + ws.getString(2) + "</td>");
								//sbBody.append("<td width='15%'   id='c"+i+"' 	style=\"text-align:left;\">" + ws.getString(23) + "</td>");
								sbBody.append("<td width='10%'   id='d"+i+"' 	>" + ws.getString(3) + "</td>");
								sbBody.append("<td width='8%'   id='e"+i+"' 	>" + ws.getString(4)+ "</td>");
								sbBody.append("<td width='8%'    id='f"+i+"' 	><b>" + ws.getString(5) + " " + ws.getString(6) + "</b></td>");
								sbBody.append("<td width='8%'    id='g"+i+"' 	><b>" + roundTolrance + "</b></td>");
								sbBody.append("<td width='10%'    id='h"+i+"' 	><input type='text' name='strVerifyCountedQty' id='strVerifyCountedQty"+i+"' value='"+ws.getString(10)+"' maxlength='8' class='txtFldMin' disabled='true' onblur='checklength(" + i + ");calculateQtyCost(" + i + ");' onkeypress='return validateData(event,5);return checklength(" + i + ");' /></td>");
								sbBody.append("<td width='8%'    id='i"+i+"' 	><b><div id='varianceQtyID"+i+"'>" + (Integer.parseInt(ws.getString(10))- Integer.parseInt(ws.getString(5)))+ "</div></b></td>");
								sbBody.append("<td width='8%'    id='j"+i+"' 	><b><div id='varianceCostID"+i+"'>" + ws.getString(12)+ "</div></b></td>");				
								sbBody.append("<td width='8%'    id='j"+i+"' 	><a value='' style='cursor:pointer;'  onClick='openDivItem(this," + i
										+ ",1);' title='Click here to Enter Remarks'><font color='blue'>#</font></a>");
								
								sbBody.append("<div id='remarksId" + i + "' class='popup' style='display:none'>");
								sbBody.append("<table width='600' align='center'>");
								sbBody.append("<tr class='HEADER'><td class='multiPOLabelNew' align='left'>Remarks For " + ws.getString(2) + "</th>");
								sbBody.append("<td class=''multiPOLabelNew' align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/stop.png'");
								sbBody.append(" onClick='closeDivItem(" + i + ");' title='Click Here To Close Popup'></th></tr>");
								sbBody.append("</table>");
								
								sbBody.append("<table width='600' align='center' cellspacing='0px' cellpadding='1px'>");
								sbBody.append("<tr><td class='LABEL' width='50%'><div id='remarksLabelId" + i + "'>Remarks</div></td>");
								sbBody.append("<td class='CONTROL' width='50%'><textarea name='strItemRemarks' cols='30' rows='2' id='strItemRemarks"+i+"' >" + (ws.getString(12)) + "</textarea></td>");
								sbBody.append("</tr>");
								sbBody.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
								sbBody.append("<tr ><td colspan='2' class='CONTROL'>");
		
								sbBody.append("<div class='control_button'><table  class='TABLEWIDTH' align='center'>");
								sbBody.append("<tr id='saveId'>");
								sbBody.append("<td align='center'><div >");
								sbBody.append("<a href='#' style='cursor:pointer;' title='Click Here To Save Remarks For Item' class='button' onClick='closeDivItem("
										+ i + ");'><span class='ok'>Ok</span></a>");
								sbBody.append("</div></td>");
								sbBody.append("</tr>");
								sbBody.append("</table></div>");
								
								sbBody.append("</td></tr>");
								sbBody.append("</table>");
								
								sbBody.append("</div>");
								
								sbBody.append("</td>");					
								sbBody.append("</tr>");			                    
							    i++;
				       }
					   else
					   {
						  
						   /*
							 * 1.Primary Key [ STORE_ID '^'ITEM_ID'^'ITEMBRAND_ID '^'BATCH_SL_NO'^'STOCK_STATUS_CODE ]
							 * 2.Drug Name
							 * 3.Batch No
							 * 4.Stock Status
							 * 5.Avl Qty
							 * 6.Unit Name
							 * 7.Rate Base Value
							 * 8.New Item Flag
							 * 9.Tolrance Value
							 * 10.Counted Qty
							 * 11.Variance Qty
							 * 12.Variance Cost
							 * 13.Remarks
							 * 14.Tender No
							 * 15.Supplier Id
							 * 16.Stock Status Code
							 * 17.Group Id
							 * 18.Rate Unit Id
							 * 19.Supplier Name
							 * 20.Expiry Date
							 * 21.Manuf Date
							 * */
						                   // Rate Base   ^   Rate Unit ^    Supplier ID    ^ Stock Status     ^  Tender    ^  Remarks   ^ Counted Qty ^ Exp Date ^ Mfg date
					      	String pkKey2 = ws.getString(7)+"^"+ws.getString(18)+"^0^0^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(14)+"^"+ws.getString(13)+"^"+ws.getString(10)+"^"+ws.getString(20)+"^"+ws.getString(21);     			 	       
					      	String delIndex = "1-" + count;
						    tempHtmlStr +="<div id='id" + delIndex + "'>";
						    tempHtmlStr +="<table class='TABLEWIDTH' id='td" + delIndex + "'  align='center' cellpadding='1px' cellspacing='0px'>";
						    tempHtmlStr +="<input type='hidden' name='strRowIndex'            id='strRowIndex" + delIndex + "'        value='" + delIndex + "' />";
						    tempHtmlStr +="<input type='hidden' name='strMultiRowPKKey1'      id='strMultiRowPKKey1" + delIndex + "'  value='"+ws.getString(1)+"' />";
						    tempHtmlStr +="<input type='hidden' name='strMultiRowPKKey2'      id='strMultiRowPKKey2" + delIndex + "'  value='"+pkKey2+"' />";
						    tempHtmlStr +="<input type='hidden' name='strMultiNewItemFlg'     id='strMultiNewItemFlg" + delIndex + "' value='0' />";
							
						    tempHtmlStr +="<tr>";  							
						    tempHtmlStr +="<td WIDTH='20%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowDrugName" + delIndex + "' align='left'>" + ws.getString(2) + "</div>";						 
						    tempHtmlStr +="</td>";
						   /* tempHtmlStr +="<td WIDTH='18%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowProgramName" + delIndex + "' align='left'>" + ws.getString(23) + "</div>";						 
						    tempHtmlStr +="</td>";*/
						    tempHtmlStr +="<td WIDTH='10%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowBatchNo" + delIndex + "'>" + ws.getString(3) + "</div>";						  
						    tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='10%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowStockStatus" + delIndex + "'>" + ws.getString(4) + "</div>";	
							  
						    tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='8%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowExpDate" + delIndex + "' align='center'>" + ws.getString(20) + "</div>";	
							 
						    tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='10%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowCountedQty" + delIndex + "'>" + ws.getString(10) + "</div>";	
							 
						    tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='10%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowRateWithUnit" + delIndex + "'>" + ws.getString(7) + "/" +ws.getString(6)+"</div>";	
							 
						    tempHtmlStr +="</td>";						    
							  
						    tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='10%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowRemarks" + delIndex + "'>" + ws.getString(13) + "</div>";						    
						    tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='4%'   class='multiRPTControl'>";
							
						    tempHtmlStr +="<img name='' onkeypress='onPressingEnter(this,event)' src='../../hisglobal/images/minus.gif' style='cursor: pointer;' title='Delete Row' " +
						    		"onclick=\"ajaxDeleteRow('"+ delIndex + "');\" >";
						    tempHtmlStr +="</td>";								
						    tempHtmlStr +="</tr>";
						    tempHtmlStr +="</table></div>";
						    count++;
						  			   
					   }
					    
					    
				}
				br.append(tempHtmlStr); 
				
	           }
	           catch(Exception e)
	           {
	        	   e.printStackTrace();
	           }
			} 
			else 
			{
				sbBody.append("<tr>");
				sbBody.append("<td colspan=\"" + nColspan + "\" class=\"multiPOControl\" style=\"text-align: center; color: red;\">No Data Found!</td>");
				sbBody.append("</tr>");
			}
			sbBody.append("</tbody></table></div>");
	  }
	  return  sbBody.toString()+"$"+br.toString()+"$"+count;
	}
	
	
	/**
	 * To get Details HLP.
	 * 
	 * @param wrsData_p the WebRowSet	 * @return the batch details table
	 * @throws SQLException the SQL exception
	 */
	public static String getPhyStkVerfItemDtlsForSaveView(WebRowSet ws,String mode,String strPhyDtls,HttpServletRequest request) throws SQLException 
	{
	  StringBuffer sbBody = new StringBuffer(1000);
	  StringBuffer br = new StringBuffer(2000);
	  String tempHtmlStr = "",strClass="";
	  int count = 1;
	  double roundTolrance = 0.00;
	 
		    int nColspan = 7;
			int i = 0;
			
			sbBody.append("<div class=' '><table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >" + "<tr>");
			//sbBody.append("<tr>" + "<td colspan=\"4\" >Verified Drug Detail</td>" + "</tr>");
			sbBody.append("<tr class='HEADER'>" + "<td colspan=\"4\" >Verified Drug Detail</td>" + "</tr>");
			sbBody.append("</table></div>");
			sbBody.append("<div id='wrapper1' style='margin-left:7.5%' class='TABLEWIDTH panel panel-default table-fixedheader' >");
			sbBody.append("<table id='mainTableRptId1' class='table table-striped'><thead><tr id='tableHeaderId1'>");		
			sbBody.append("<td class='multiPOLabelNew' width='5%'  >S.No.</td>");		
			sbBody.append("<td class='multiPOLabelNew' width='25%' >Drug/Item Name</td>");
			sbBody.append("<td class='multiPOLabelNew' width='10%' >Batch No.</td>");
			sbBody.append("<td class='multiPOLabelNew' width='10%' >Stock Status</td>");
			sbBody.append("<td class='multiPOLabelNew' width='8%' >Available Qty.(A)</td>");
			sbBody.append("<td class='multiPOLabelNew' width='10%' >Tolerance Limit "+ strPhyDtls.split("\\^")[2]+"(%)</td>");
			sbBody.append("<td class='multiPOLabelNew' width='8%' >Counted Qty.(B)</td>");
			sbBody.append("<td class='multiPOLabelNew' width='8%'  >Variance Qty. (B-A)</td>");
			sbBody.append("<td class='multiPOLabelNew' width='8%'  >Variance Cost</td>");
			sbBody.append("<td class='multiPOLabelNew' width='8%'  >Remarks</td>");
			sbBody.append("</tr></thead>");    
			sbBody.append("<tbody>"); 
			if (ws != null && ws.size() > 0) 
			{
				   /*
				 * 1.Primary Key [ STORE_ID '^'ITEM_ID'^'ITEMBRAND_ID '^'BATCH_SL_NO'^'STOCK_STATUS_CODE ]
				 * 2.Drug Name
				 * 3.Batch No
				 * 4.Stock Status
				 * 5.Avl Qty
				 * 6.Unit Name
				 * 7.Rate Base Value
				 * 8.New Item Flag
				 * 9.Tolrance Value
				 * 10.Counted Qty
				 * 11.Variance Qty
				 * 12.Variance Cost
				 * 13.Remarks
				 * 14.Tender No
				 * 15.Supplier Id
				 * 16.Stock Status Code
				 * 17.Group Id
				 * 18.Rate Unit Id
				 * 19.Supplier Name
				 * 20.Expiry Date
				 * 21.Manuf Date
				 * */
	           try
	           {
				while (ws.next()) 
				{		
					    if(ws.getString(8).equals("0"))
					    {	
						    	if ((0 - (Integer.parseInt(ws.getString(10))- Integer.parseInt(ws.getString(5)))) > (Math.round(Double.parseDouble(ws.getString(5))* Double.parseDouble(strPhyDtls.split("\\^")[2])/100))) 
						    	{
									strClass = "danger";
								} 
						    	else 
						    	{
									strClass = "";
								}
						    	roundTolrance = Math.round(0 - (Double.parseDouble(ws.getString(5))* Double.parseDouble(strPhyDtls.split("\\^")[2])/100));
								sbBody.append("<tr id='trId"+i+"' class='" + strClass + "'>");		
								sbBody.append("<input type='hidden' name='strMultiRemarks' id='strMultiRemarks"+i+"' value='' disabled>");
								sbBody.append("<td width='5%'    	style=\"text-align:center;\">"+(i+1)+"</td>");
								sbBody.append("<td width='25%'   	style=\"text-align:left;\">" + ws.getString(2) + "</td>");
								sbBody.append("<td width='10%'   	style=\"text-align:center;\">" + ws.getString(3) + "</td>");
								sbBody.append("<td width='10%'   	style=\"text-align:center;\">" + ws.getString(4)+ "</td>");
								sbBody.append("<td width='8%'    	style=\"text-align:center;\"><b>" + ws.getString(5) + " " + ws.getString(6) + "</b></td>");
								sbBody.append("<td width='10%'    	style=\"text-align:center;\"><b>" + roundTolrance + "</b></td>");
								sbBody.append("<td width='8%'    	style=\"text-align:center;\"><b>"+ws.getString(10)+"<b></td>");
								sbBody.append("<td width='8%'    	style=\"text-align:center;\"><b><div id='varianceQtyID"+i+"'>" + (Integer.parseInt(ws.getString(10))- Integer.parseInt(ws.getString(5)))+ "</div></b></td>");
								sbBody.append("<td width='8%'    	style=\"text-align:center;\"><b><div id='varianceCostID"+i+"'>" + ws.getString(12)+ "</div></b></td>");				
								sbBody.append("<td width='8%'    	style=\"text-align:center;\"><a value='' style='cursor:pointer;'  onClick='openDivItem(this," + i
										+ ",2);' title='Click here to Enter Remarks'><font color='blue'>#</font></a>");
								
								sbBody.append("<div id='remarksId" + i + "' class='popup' style='display:none'>");
								sbBody.append("<table width='600' align='center'>");
								sbBody.append("<tr class='HEADER'><td class='multiPOLabelNew' align='left'>Remarks For " + ws.getString(2) + "</th>");
								sbBody.append("<td class='multiPOLabelNew' align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/stop.png'");
								sbBody.append(" onClick='closeDivItem(" + i + ");' title='Click Here To Close Popup'></th></tr>");
								sbBody.append("</table>");
								
								sbBody.append("<table width='600' align='center' cellspacing='0px' cellpadding='1px'>");
								sbBody.append("<tr><td class='LABEL' width='50%'><div id='remarksLabelId" + i + "'>Remarks</div></td>");
								sbBody.append("<td class='CONTROL' width='50%'><textarea name='strItemRemarks' cols='30' rows='2' id='strItemRemarks"+i+"' >" + (ws.getString(12)) + "</textarea></td>");
								sbBody.append("</tr>");
								sbBody.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
								sbBody.append("<tr ><td colspan='2' class='CONTROL'>");
		
								sbBody.append("<div class='control_button'><table  class='TABLEWIDTH' align='center'>");
								sbBody.append("<tr id='saveId'>");
								sbBody.append("<td align='center'><div >");
								sbBody.append("<a href='#' style='cursor:pointer;' title='Click Here To Save Remarks For Item' class='button' onClick='closeDivItem("
										+ i + ");'><span class='ok'>Ok</span></a>");
								sbBody.append("</div></td>");
								sbBody.append("</tr>");
								sbBody.append("</table></div>");
								
								sbBody.append("</td></tr>");
								sbBody.append("</table>");
								
								sbBody.append("</div>");
								
								sbBody.append("</td>");					
								sbBody.append("</tr>");			                    
							    i++;
				       }
					   else
					   {
						   /*
							 * 1.Primary Key [ STORE_ID '^'ITEM_ID'^'ITEMBRAND_ID '^'BATCH_SL_NO'^'STOCK_STATUS_CODE ]
							 * 2.Drug Name
							 * 3.Batch No
							 * 4.Stock Status
							 * 5.Avl Qty
							 * 6.Unit Name
							 * 7.Rate Base Value
							 * 8.New Item Flag
							 * 9.Tolrance Value
							 * 10.Counted Qty
							 * 11.Variance Qty
							 * 12.Variance Cost
							 * 13.Remarks
							 * 14.Tender No
							 * 15.Supplier Id
							 * 16.Stock Status Code
							 * 17.Group Id
							 * 18.Rate Unit Id
							 * 19.Supplier Name
							 * 20.Expiry Date
							 * 21.Manuf Date
							 * */
						                   // Rate Base   ^   Rate Unit ^    Supplier ID    ^ Stock Status     ^  Tender    ^  Remarks   ^ Counted Qty ^ Exp Date ^ Mfg date
					      	String pkKey2 = ws.getString(7)+"^"+ws.getString(18)+"^0^0^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(14)+"^"+ws.getString(13)+"^"+ws.getString(10)+"^"+ws.getString(20)+"^"+ws.getString(21);     			 	       
						    
					      	String delIndex = "1-" + count;
						    tempHtmlStr +="<div id='id" + delIndex + "'>";
						    tempHtmlStr +="<table class='TABLEWIDTH' id='td" + delIndex + "' align='center' cellpadding='1px' cellspacing='0px'>";
							
						    tempHtmlStr +="<tr>";  							
						    tempHtmlStr +="<td WIDTH='20%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowDrugName" + delIndex + "' align='left'>" + ws.getString(2) + "</div>";						 
						    tempHtmlStr +="</td>";
						   // tempHtmlStr +="<td WIDTH='18%'   class='multiRPTControl'>";
						    //tempHtmlStr +="<div id='strMultiRowProgramName" + delIndex + "' align='left'>" + ws.getString(23) + "</div>";						 
						    //tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='10%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowBatchNo" + delIndex + "'>" + ws.getString(3) + "</div>";						  
						    tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='10%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowStockStatus" + delIndex + "'>" + ws.getString(4) + "</div>";	
							  
						    tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='8%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowExpDate" + delIndex + "' align='center'>" + ws.getString(20) + "</div>";	
							 
						    tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='10%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowCountedQty" + delIndex + "'>" + ws.getString(10) + "</div>";	
							 
						    tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='10%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowRateWithUnit" + delIndex + "'>" + ws.getString(7) + "/" +ws.getString(6)+"</div>";	
							 
						    tempHtmlStr +="</td>";						    
							  
						    tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='10%'   class='multiRPTControl'>";
						    tempHtmlStr +="<div id='strMultiRowRemarks" + delIndex + "'>" + ws.getString(13) + "</div>";						    
						    tempHtmlStr +="</td>";
						    tempHtmlStr +="<td WIDTH='4%'   class='multiRPTControl'>";
							
						    tempHtmlStr +="<img name='' onkeypress='onPressingEnter(this,event)' src='../../hisglobal/images/minus.gif' style='cursor: pointer;' title='Delete Row' " +
						    		"onclick=\"deleteRow('"+ delIndex + "',1,0);\" >";
						    tempHtmlStr +="</td>";								
						    tempHtmlStr +="</tr>";
						    tempHtmlStr +="</table></div>";
						    count++;
						  			   
					   }
					 
				}
				br.append(tempHtmlStr); 
				
	           }
	           catch(Exception e)
	           {
	        	   e.printStackTrace();
	           }
			} 
			else 
			{
				sbBody.append("<tr>");
				sbBody.append("<td colspan=\"" + nColspan + "\" class=\"multiPOControl\" style=\"text-align: center; color: red;\">No Data Found!</td>");
				sbBody.append("</tr>");
			}
			sbBody.append("</tbody></table></div>");
	  
      
	  return  sbBody.toString()+"$"+br.toString()+"$"+count;
	}
	
	
	/**
	 * To get Details HLP.
	 * 
	 * @param wrsData_p the WebRowSet	 * @return the batch details table
	 * @throws SQLException the SQL exception
	 */
	public static String physicalApprovalHLP(WebRowSet ws,String mode,String strTolranceLimit) throws SQLException 
	{
		  	StringBuffer sbBody = new StringBuffer(1000);
		  	StringBuffer sbBody1 = new StringBuffer(1000);
		  	String strClass="";
		  	int count = 1;
		  	double roundTolrance = 0.00;
		    int nColspan = 10;
			int i = 0;
			sbBody.append("<div class='line'><table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >" + "<tr>");
			sbBody.append("<tr>" + "<td colspan=\"4\" >Discrepancy Drug Detail(s)</td>" + "</tr>");
			sbBody.append("</table></div>");
			sbBody.append("<div id='wrapper' style='margin-left:2.5%' class='TABLEWIDTH' ><table id='mainTableRptId' align='center'cellpadding='1px' cellspacing='0px' bgcolor='#CC9966'>");
			sbBody.append("<tr id='tableHeaderId'>");				
			sbBody.append("<td width='25%' >Drug/Item Name</th>");
			sbBody.append("<th width='10%' >Batch No.</th>");
			sbBody.append("<th width='10%' >Stock Status</th>");
			sbBody.append("<th width='8%'  >Avl.Qty. (A)</th>");
			sbBody.append("<th width='8%'  >Tolerance Limit "+strTolranceLimit+"(%)</th>");
			sbBody.append("<th width='8%'  >Counted Qty. (B)</th>");
			sbBody.append("<th width='8%'  >Variance Qty. (B-A)</th>");
			sbBody.append("<th width='8%'  >Variance Cost</th>");
			sbBody.append("<th width='8%'  >Remarks</th>");
			sbBody.append("</tr>");    
			
			sbBody1.append("<div class='line'><table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >" + "<tr>");
			sbBody1.append("<tr>" + "<td colspan=\"4\" >Non-Discrepancy Drug Detail(s)</td>" + "</tr>");
			sbBody1.append("</table></div>");
			sbBody1.append("<div id='wrapper1' style='margin-left:2.5%' class='TABLEWIDTH' ><table id='mainTableRptId1' align='center'cellpadding='1px' cellspacing='0px' bgcolor='#CC9966'>");
			sbBody1.append("<tr id='tableHeaderId1'>");				
			sbBody1.append("<th width='25%' >Drug/Item Name</th>");
			sbBody1.append("<th width='10%' >Batch No.</th>");
			sbBody1.append("<th width='10%' >Stock Status</th>");
			sbBody1.append("<th width='8%'  >Avl.Qty. (A)</th>");
			sbBody1.append("<th width='8%'  >Tolerance Limit "+strTolranceLimit+"(%)</th>");
			sbBody1.append("<th width='8%'  >Counted Qty. (B)</th>");
			sbBody1.append("<th width='8%'  >Variance Qty. (B-A)</th>");
			sbBody1.append("<th width='8%'  >Variance Cost</th>");
			sbBody1.append("<th width='8%'  >Remarks</th>");
			sbBody1.append("</tr>");    
			
			if (ws != null && ws.size() > 0) 
			{
				   /*
				 * 1.Primary Key [ STORE_ID '^'ITEM_ID'^'ITEMBRAND_ID '^'BATCH_SL_NO'^'STOCK_STATUS_CODE ]
				 * 2.Drug Name
				 * 3.Batch No
				 * 4.Stock Status
				 * 5.Avl Qty
				 * 6.Unit Name
				 * 7.Rate Base Value
				 * 8.New Item Flag
				 * 9.Tolrance Value
				 * 10.Counted Qty
				 * 11.Variance Qty
				 * 12.Variance Cost
				 * 13.Remarks
				 * 14.Tender No
				 * 15.Supplier Id
				 * 16.Stock Status Code
				 * 17.Group Id
				 * 18.Rate Unit Id
				 * 19.Supplier Name
				 * 20.Expiry Date
				 * 21.Manuf Date
				 * */
	           try
	           {
				while (ws.next()) 
				{		
					   
			    	    strClass = "";
				    	if ((0 - (Integer.parseInt(ws.getString(10))- Integer.parseInt(ws.getString(5)))) > (Math.round(Double.parseDouble(ws.getString(5))* Double.parseDouble(strTolranceLimit)/100))) 
				    	{
						
				    	roundTolrance = Math.round(0 - (Double.parseDouble(ws.getString(5))* Double.parseDouble(strTolranceLimit)/100));
						sbBody.append("<tr class='" + strClass + "'>");					
						
						sbBody.append("<td width='25%'   	style=\"text-align:left;\">" + ws.getString(2) + "</td>");
						sbBody.append("<td width='10%'   	style=\"text-align:center;\">" + ws.getString(3) + "</td>");
						sbBody.append("<td width='10%'   	style=\"text-align:center;\">" + ws.getString(4)+ "</td>");
						sbBody.append("<td width='8%'    	style=\"text-align:center;\"><b>" + ws.getString(5) + " " + ws.getString(6) + "</b></td>");
						sbBody.append("<td width='8%'    	style=\"text-align:center;\"><b>" + roundTolrance + "</b></td>");
						sbBody.append("<td width='8%'    	style=\"text-align:center;\"><b>"+ws.getString(10)+"<b></td>");
						sbBody.append("<td width='8%'    	style=\"text-align:center;\"><b><div id='varianceQtyID"+i+"'>" + (Integer.parseInt(ws.getString(10))- Integer.parseInt(ws.getString(5)))+ "</div></b></td>");
						sbBody.append("<td width='8%'    	style=\"text-align:center;\"><b><div id='varianceCostID"+i+"'>" + ws.getString(12)+ "</div></b></td>");				
						sbBody.append("<td width='8%'    	style=\"text-align:center;\"><a value='' style='cursor:pointer;'  onClick='openDivItem(this," + i
								+ ");' title='Click here to Enter Remarks'><font color='blue'>#</font></a>");
						
						sbBody.append("<div id='remarksId" + i + "' class='popup' style='display:none'>");
						sbBody.append("<table width='600' align='center'>");
						sbBody.append("<tr class='HEADER'><th align='left'>Remarks For " + ws.getString(2) + "</th>");
						sbBody.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/stop.png'");
						sbBody.append(" onClick='closeDivItem(" + i + ");' title='Click Here To Close Popup'></th></tr>");
						sbBody.append("</table>");
						
						sbBody.append("<table width='600' align='center' cellspacing='0px' cellpadding='1px'>");
						sbBody.append("<tr><td class='LABEL' width='50%'><div id='remarksLabelId" + i + "'>Remarks</div></td>");
						sbBody.append("<td class='CONTROL' width='50%'><textarea name='strItemRemarks'id='strItemRemarks"+i+"' >" + (ws.getString(12) ) + "</textarea></td>");
						sbBody.append("</tr>");
						sbBody.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
						sbBody.append("<tr ><td colspan='2' class='CONTROL'>");

						sbBody.append("<div class='control_button'><table  class='TABLEWIDTH' align='center'>");
						sbBody.append("<tr id='saveId'>");
						sbBody.append("<td align='center'><div >");
						sbBody.append("<a href='#' style='cursor:pointer;' title='Click Here To Save Remarks For Item' class='button' onClick='closeDivItem("
								+ i + ");'><span class='ok'>Ok</span></a>");
						sbBody.append("</div></td>");
						sbBody.append("</tr>");
						sbBody.append("</table></div>");
						
						sbBody.append("</td></tr>");
						sbBody.append("</table>");
						
						sbBody.append("</div>");
						
						sbBody.append("</td>");					
						sbBody.append("</tr>");			                    
					    i++;
				    	}				       
					   else
					   {
						  
							strClass = "";
							
					    	roundTolrance = Math.round(0 - (Double.parseDouble(ws.getString(5))* Double.parseDouble(strTolranceLimit)/100));
							sbBody1.append("<tr class='" + strClass + "'>");					
							
							sbBody1.append("<td widtalign:left;\">" + ws.getString(2) + "</td>");
							sbBody1.append("<td width='10%'   	style=\"text-align:center;\">" + ws.getString(3) + "</td>");
							sbBody1.append("<td width='10%'   	style=\"text-align:center;\">" + ws.getString(4)+ "</td>");
							sbBody1.append("<td width='8%'    	style=\"text-align:center;\"><b>" + ws.getString(5) + " " + ws.getString(6) + "</b></td>");
							sbBody1.append("<td width='8%'    	style=\"text-align:center;\"><b>" + roundTolrance + "</b></td>");
							sbBody1.append("<td width='8%'    	style=\"text-align:center;\"><b>"+ws.getString(10)+"<b></td>");
							sbBody1.append("<td width='8%'    	style=\"text-align:center;\"><b><div id='varianceQtyID"+count+"'>" + (Integer.parseInt(ws.getString(10))- Integer.parseInt(ws.getString(5)))+ "</div></b></td>");
							sbBody1.append("<td width='8%'    	style=\"text-align:center;\"><b><div id='varianceCostID"+count+"'>" + ws.getString(12)+ "</div></b></td>");				
							sbBody1.append("<td width='8%'    	style=\"text-align:center;\"><a value='' style='cursor:pointer;'  onClick='openDivItem(this," + count
									+ ");' title='Click here to Enter Remarks'><font color='blue'>#</font></a>");
							
							sbBody1.append("<div id='remarksId" + count + "' class='popup' style='display:none'>");
							sbBody1.append("<table width='600' align='center'>");
							sbBody1.append("<tr class='HEADER'><th align='left'>Remarks For " + ws.getString(2) + "</th>");
							sbBody1.append("<th align='right'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/stop.png'");
							sbBody1.append(" onClick='closeDivItem(" + count + ");' title='Click Here To Close Popup'></th></tr>");
							sbBody1.append("</table>");
							
							sbBody1.append("<table width='600' align='center' cellspacing='0px' cellpadding='1px'>");
							sbBody1.append("<tr><td class='LABEL' width='50%'><div id='remarksLabelId" + count + "'>Remarks</div></td>");
							sbBody1.append("<td class='CONTROL' width='50%'><textarea name='strItemRemarks'id='strItemRemarks"+count+"' >" + (ws.getString(12)) + "</textarea></td>");
							sbBody1.append("</tr>");
							sbBody1.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
							sbBody1.append("<tr ><td colspan='2' class='CONTROL'>");
	
							sbBody1.append("<div class='control_button'><table  class='TABLEWIDTH' align='center'>");
							sbBody1.append("<tr id='saveId'>");
							sbBody1.append("<td align='center'><div >");
							sbBody1.append("<a href='#' style='cursor:pointer;' title='Click Here To Save Remarks For Item' class='button' onClick='closeDivItem("
									+ count + ");'><span class='ok'>Ok</span></a>");
							sbBody1.append("</div></td>");
							sbBody1.append("</tr>");
							sbBody1.append("</table></div>");
							
							sbBody1.append("</td></tr>");
							sbBody1.append("</table>");
							
							sbBody1.append("</div>");
							
							sbBody1.append("</td>");					
							sbBody1.append("</tr>");	          
						    
						    count++;
						  			   
					   }
					 
				}
				
				
	           }
	           catch(Exception e)
	           {
	        	   e.printStackTrace();
	           }
			} 
			else 
			{
				sbBody.append("<tr>");
				sbBody.append("<td colspan=\"" + nColspan + "\" class=\"multiPOControl\" style=\"text-align: center; color: red;\">No Data Found!</td>");
				sbBody.append("</tr>");
				sbBody1.append("<tr>");
				sbBody1.append("<td colspan=\"" + nColspan + "\" class=\"multiPOControl\" style=\"text-align: center; color: red;\">No Data Found!</td>");
				sbBody1.append("</tr>");
			}
			sbBody.append("</table></div>");
			sbBody1.append("</table></div>");
	  
	  return  sbBody.toString()+"@"+sbBody1.toString();
	}
	
	/**
	 * To get Details HLP.
	 * 
	 * @param wrsData_p the WebRowSet
	 * @return the batch details table
	 * @throws SQLException the SQL exception
	 */
	public static String getPrevPhyStockDtls(WebRowSet ws,HttpServletRequest request) throws SQLException 
	{
		StringBuffer sbTable = new StringBuffer(100);
		StringBuffer sbHeader = new StringBuffer(100);
		StringBuffer sbBody = new StringBuffer(100);
		int nColspan = 4;
		int i = 0;
        sbTable.append("<div class=' '><table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >" + "<tr>");
		//sbTable.append("<tr>" + "<td colspan=\"4\" >Request Details</td>" + "</tr>");
		sbTable.append("<tr class='HEADER'>" + "<td colspan=\"4\" >Request Details</td>" + "</tr>");
		sbTable.append("</table></div>");
		sbHeader.append("<div class='panel panel-default' style='width:95%;margin-left:7.5%;'>");
		sbHeader.append("<table class=\"TABLEWIDTH\" align='center'cellpadding='1px' cellspacing='0px'>");
		sbHeader.append("<thead><tr>");		
		sbHeader.append("<td class='multiPOLabelNew' width='20%'>Request No.</td>");
		sbHeader.append("<td class='multiPOLabelNew' width='20%'>Request Date</td>");
		sbHeader.append("<td class='multiPOLabelNew' width='20%'>Stock Status</td>");
		sbHeader.append("<td class='multiPOLabelNew' width='20%'>Verification Date</td>");
		sbHeader.append("<td class='multiPOLabelNew' width='20%'>Action</td>");		
		sbHeader.append("</tr></thead><tbody>");
		

		if (ws != null && ws.size() > 0) 
		{
			/*
			MODIFY_CANCEL_FLAG =  1 >> Enable Modify/Cancel Button =  0 >> Disable Modify/Cancel Button
            Status = 40 >> Enable Stock Update Button  
			*/
			/*
			 * 1.Physical Stock No
			 * 2.Request Date
			 * 3.Stock Status
			 * 4.Hstnum_status
			 * 5.Modify Cancel Flag	
			 * 6.VERIFICATION_DATE	
			 * 7.SSTNUM_IS_DRAFT_MODE	
			 * */

			while (ws.next()) 
			{				           
					if (ws.getString(7).equals("1")) 
			    	{
					}			    	
					sbBody.append("<tr id='trId"+i+"' >");					
					sbBody.append("<td width='20%' name='1a' id='1a"+i+"' >" + ws.getString(1) + "</td>");
					sbBody.append("<td width='20%' name='1b' id='1b"+i+"' >" + ws.getString(2) + "</td>");
					sbBody.append("<td width='20%' name='1c' id='1c"+i+"' >" + ws.getString(3)+ "</td>");
					sbBody.append("<td width='20%' name='1d' id='1d"+i+"' >" + ws.getString(6)+ "</td>");
					sbBody.append("<td width='20%' name='1e' id='1e"+i+"' >");						
					if(ws.getString(5).equals("1"))
					{	
						sbBody.append("<img  style='cursor:pointer;cursor:pointer; height:15px;width:13px;'  title='Modify Record' src='/HIS/hisglobal/images/nonclinical/update.png' onclick='return updateRecord(1,\""+i+"\");'>");
						//sbBody.append("<span class='glyphicon glyphicon-edit' title='Modify Record' onclick='return updateRecord(1,\""+i+"\");' style='cursor:pointer;'></span>");
						//sbBody.append("<a href='#' class='button' id=' ' onclick='return updateRecord(1,\""+i+"\");'><span class='modify'>modify</span></a>");
						sbBody.append("&nbsp;&nbsp;<img  style='cursor:pointer;cursor:pointer; height:15px;width:13px;'  title='Cancel Record' src='/HBIMS/hisglobal/images/cancel.png' onclick='return cancelRecord(1,\""+i+"\");'>");
						//sbBody.append("&nbsp;&nbsp;<span class='glyphicon glyphicon-remove' title='Cancel Record' onclick='return cancelRecord(1,\""+i+"\");' style='cursor:pointer;'></span>");
						//sbBody.append("<a href='#' class='button' id=' ' onclick='return cancelRecord(1,\""+i+"\");'><span class='clear'>remove</span></a>");
					}
					else
					{
						//sbBody.append("<span class='glyphicon-ban-circle' title='Modify Record Not Allowed'></span>");
						sbBody.append("<img  style='cursor:pointer;cursor:pointer; height:15px;width:13px;'  title='Modify Record Not Allowed' src='/HBIMS/hisglobal/images/banned.jpg' >");
						//sbBody.append("<a href='#' class='button' id=' ' onclick=' '><span class='no'>not</span></a>");
						//sbBody.append("<a href='#' class='button' id=' ' onclick=' '><span class='no'>not</span></a>");
						//sbBody.append("&nbsp;&nbsp;<span class='glyphicon-ban-circle' title='Cancel Record Not Allowed'></span>");
						sbBody.append("&nbsp;&nbsp;<img  style='cursor:pointer;cursor:pointer; height:15px;width:13px;'  title='Cancel Record Not Allowed' src='/HBIMS/hisglobal/images/banned.jpg' >");
					}
					if(ws.getString(4).equals("40"))
					{	
						//sbBody.append("&nbsp;&nbsp;<span class='glyphicon-floppy-disk' onclick='return stockUpdate(1,\""+i+"\");' title='Stock Upload' style='cursor:pointer;'></span>");
						sbBody.append("&nbsp;&nbsp;<img  style='cursor:pointer;cursor:pointer; height:15px;width:13px;'  title='Stock Upload' src='/HBIMS/hisglobal/images/save.png' onclick='return stockUpdate(1,\""+i+"\");'>");
						
					}
					else
					{
						//sbBody.append("&nbsp;&nbsp;<span class='glyphicon glyphicon-ban-circle' title='Stock Upload Not Allowed'></span>");		
						sbBody.append("&nbsp;&nbsp;<img  style='cursor:pointer;cursor:pointer; height:15px;width:13px;'  title='Stock upload Not Allowed' src='/HBIMS/hisglobal/images/banned.jpg' >");
						
					
			        }
					//sbBody.append("&nbsp;&nbsp;<span class='glyphicon glyphicon-eye-open' onclick='return viewStock(0,\""+i+"\");' title='View Record' style='cursor:pointer;'></span>");
					sbBody.append("&nbsp;&nbsp;<img  style='cursor:pointer;cursor:pointer; height:15px;width:13px;'  title='view Record' src='/HBIMS/hisglobal/images/view.png' onclick='return viewStock(0,\""+i+"\");'>");
					sbBody.append("</td>");
				    sbBody.append("<input type='hidden' name='strPhyHlpReqDtls'  disabled='disabled' id='strPhyHlpReqDtls" + i + "' 				value='"+ws.getString(1)+"$"+ws.getString(2)+"$"+ws.getString(3)+"$"+ws.getString(4)+"$"+ws.getString(5)+"' >");
					sbBody.append("</tr>");
				    i++;
			}
		
			

		} 
		else 
		{
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\"" + nColspan + "\"  style=\"text-align: center; color: red;\">No Data Found!</td>");
			sbBody.append("</tr>");
		}
		sbBody.append("</tbody></table></div>");

		return sbTable.toString() + sbHeader.toString() + sbBody.toString();
	}

	





}