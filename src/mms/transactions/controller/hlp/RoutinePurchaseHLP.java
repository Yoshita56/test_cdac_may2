package mms.transactions.controller.hlp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.RoutinePurchaseVO;

public class RoutinePurchaseHLP 
{
	
	public static String getIndentDetails(RoutinePurchaseVO vo)
    {
		
		StringBuffer sb = new StringBuffer("");
		
		try {
			WebRowSet ws = vo.getStrIndentDetailsWs();
			if (ws != null && ws.size() > 0) 
			{
				if (ws.next()) 
				{
										
					String strReqNo        = ws.getString(1);
					String strStoreName    = ws.getString(2);
					String strIndentDate   = ws.getString(3);
					String strItemCatg     = ws.getString(4);
					String strIndentType   = ws.getString(5);
					String strToStore      = ws.getString(6);
					String strIndentStatus = ws.getString(7);
					
					if (strStoreName == null)
						strStoreName = "----";
					if (strItemCatg == null)
						strItemCatg = "----";
					if (strReqNo == null)
						strReqNo = "----";
					if (strIndentDate == null)
						strIndentDate = "----";
					if (strIndentType == null)
						strIndentType = "----";
					if (strToStore == null)
						strToStore = "----";
					vo.setStrIndentDate(strIndentDate);
					sb.append("<table class='TABLEWIDTH'  align='center'  border='0'  cellspacing ='1px'>");
					sb.append("<input type='hidden' name='strIndentStatus'  value='"+strIndentStatus+"'>");
					sb.append("<input type='hidden' name='strIndentDate'  value='"+strIndentDate+"'>");
					sb.append("<tr><td width='25%' class='LABEL'>Store Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strStoreName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Item Category</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strItemCatg);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Indent No</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strReqNo);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Indent Date</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentDate);
					sb.append("</td></tr>");
					sb.append("<tr><td width='25%' class='LABEL'>Indent Type</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strIndentType);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>To Store Name</td>");
					sb.append("<td width='25%' class='CONTROL'>");
					sb.append(strToStore);
					sb.append("</td></tr>");
					sb.append("</table>");
				}
			}
			else {
				    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#6097BC' cellspacing ='1px'>"); 
				    sb.append("<tr>");
				    sb.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED INDENT NO. </div>" + "</TD>");

				    sb.append("</tr>");
				    sb.append("</table>");
					
			   } 
		}catch(Exception e){
			
			vo
				.setStrMsgString("IndentViewTransHLP.getItemDetails() --> "
						+e.getMessage());
			vo.setStrMsgType("1");
		}
	return sb.toString();
	}
	
	public static String getIndentItemList(RoutinePurchaseVO vo) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		final int REC_PER_PAGE = 20;
		final int PAGE_PER_BLOCK = 20;
		String strGroupName="";		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		WebRowSet ws =null;
		
		try
	    {   		
			ws  = vo.getIndentItemWS();		
			//br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	//br.append("<tr><td colspan='4' width='100%' class='TITLE'>Supplier Performance Details</td></tr></table>");	
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
				     int actualFetchRecord = ws.size();			
			         if(totalFetchRecord != actualFetchRecord)
					 {
						totalFetchRecord = actualFetchRecord;
						totalRecordsToManipulate = actualFetchRecord;
					 }
				    int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
				    int reminder = totalRecordsToManipulate % REC_PER_PAGE;
				    if (reminder > 0)
				    	
					totalLayer = totalLayer + 1;
				 
				    br.append("<input type='hidden' name='TotalLayer'  value='"+totalLayer+"'>");
				    br.append("<input type='hidden' name='RecordShowOnPage'  value='"+REC_PER_PAGE+"'>");
				    br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				    br.append("<tr>");			   
					br.append("<td class='TITLE' style=\"text-align:right;\" colspan='8'>Drug Name::::<select name='strItemNameCmb' class='comboTooMax'  onchange='openItemDivForItem(this);'>");
					br.append("<option value='0^0'>ALL</option>");
					while(ws.next())
					{	
							br.append("<option value='"+ws.getString(1)+"^"+ws.getString(3)+"'>"+ws.getString(3)+"</option>");
					}
						
					br.append("</select></td></tr>");
					br.append("</table>");
					ws.beforeFirst();
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
					br.append("<tr bgcolor='#FFEBD5'>");					
					br.append("<th colspan='4'></th>");
					br.append("<th colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' style=\"color: #653232;\" >Requested Quantity</font></th>");
					br.append("<th colspan='1'></th>");
					br.append("</tr>");
					br.append("<tr>");					
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Item Code</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>Item Name</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Avl. Qty</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Last Indent Qty.</td>");					
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>MC Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>CHMO Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Total Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Approx Cost</td>");					
					br.append("</tr>");					
					br.append("</table>");
					
					
			    for (int i = 1; i <= totalLayer; i++) 
			    {
				 if (i <= totalLayer) 
				 {
					 
					if (i == 1) 
					{
						br.append("<div id='DivId" +i+ "' style='display:block'>");
					} 
					else
					{
						br.append("<div id='DivId" +i+ "' style='display:none'>");
					}
					
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
					for (int j = 0; j < REC_PER_PAGE; j++) 
					{
						/*
					  	 1.Group Name
					  	 2.CPA Code
					  	 3.Item Name
					  	 4.Avalaible Quantity
					  	 5.Last Indent Quantity
					  	 6.Total Qty
					  	 7.Approx Cost
					  	 
					  	 8.Item Brand Id
					  	 9.Item ID
					  	 10.Rate With Unit
					  	 11.Rate for Calculation	
					  	 ---------------------------------				  	 
					  	   12(0).Item Id
					  	   12(1).Item Brand ID
					  	   12(2).Group ID
					  	   12(3).Sub-Grp Id
					  	   12(4).Cosumable Flag
					  	   12(5).Re-Order Qty
					  	   12(6).Re-Order Qty Unit Id
					  	   12(7).In-Hand Qty
					  	   12(8).In-Hand Qty Unit Id
					  	   12(9).Last Rate
					  	   12(10).Last Rate Unit Id
					  	   12(11).Inventory Unit Id
					  	   12(12).Last PO No. 
					  	   12(13).Last PO Date
	                       12(14).Last Supplied By
	                       12(15).Batch No
	                       12(16).Expiry date
	                       12(17).Manufactrer Date
	                       12(18).Item Serial No
	                       12(19).Last Received Qty
	                       12(20).Last Received Qty Unit
	                       12(21).Last Indented Qty
	                       12(22).Last Indented Qty Unit Id
	                       12(23).Last Received Qty
	                       12(24).Last Received Qty Unit ID
	                       12(25).Last Year Consumption Qty
	                       12(26).Last Year Consumption Qty Unit Id
	                       12(27).Prefix
	                       12(28).Cost Parameter
	                       12(29).Cost Unit
	                       12(30).Purchase Lead Time
	                       12(31).Purchase Lead Time Unit
	                       12(32).Stock Status 
	                       12(33).Dummy
	                       12(34).Dummy
	                       12(35).Brand Reserved Flg
	                       12(36).Item Make
	                       12(37).CPA Code
	                       12(38).Dummy
	                       12(39).NA
                       -----------------------------
                       13.CHM_QTY
                       14.MC_QTY*/
						
						if(ws.next())
						{						
							if(count==0)
							{
								 strGroupName = ws.getString(1).trim();								 
								 br.append("<tr>");
								 br.append("<td class='multiCLRLabel'  style=\"text-align:left;\"  colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Name::<u>"+ws.getString(1)+"</u></b></font></td>");
								 br.append("</tr>");
							}	
							
							if(strGroupName.equals(ws.getString(1).trim()))
							{
								br.append("<input type='hidden' name='itemName' id='itemName"+i+""+j+"' value='"+ws.getString(3)+"'>");
								br.append("<input type='hidden' name='rateForCalc' id='rateForCalc"+i+""+j+"' value='"+ws.getString(11)+"'>");
								br.append("<input type='hidden' name='itemParamValue' id='itemParamValue"+i+""+j+"' value='"+ws.getString(12)+"'>");
								br.append("<input type='hidden' name='groupName' id='groupName"+i+""+j+"' value='"+ws.getString(1)+"^"+i+""+j+"'>");
								br.append("<input type='hidden' name='divIndex' id='divIndex"+i+"' value='"+i+"'>");
								br.append("<tr>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId1"+i+""+j+"'  width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</font></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId2"+i+""+j+"'  width='30%'  width='30%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><a STYLE='CURSOR:POINTER;color:blue' title='Rate/Unit is  [ "+ws.getString(10)+" ]'>"+ws.getString(3)+"</a></font></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId3"+i+""+j+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(4)+"</font></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId4"+i+""+j+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(5)+"</font></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId5"+i+""+j+"'  width='10%'><input type='text' name='strCHMOQty'   id='strCHMOQty"+i+""+j+"'    class='txtFldNormal' maxlength ='8'   onkeypress='return validateData(event,5);'  value='"+ws.getString(13)+"'  onkeyup='CalculateItemTotal("+i+""+j+",1);'></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId6"+i+""+j+"'  width='10%'><input type='text' name='strMCQty'     id='strMCQty"+i+""+j+"'      class='txtFldNormal' maxlength ='8'   onkeypress='return validateData(event,5);'  value='"+ws.getString(14)+"'  onkeyup='CalculateItemTotal("+i+""+j+",1);' ></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId7"+i+""+j+"'  width='10%'><input type='text' name='strTotalQty'  id='strTotalQty"+i+""+j+"'   class='txtFldNormal' readonly='readonly'   value='"+ws.getString(6)+"' ></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId8"+i+""+j+"'  width='12%'><input type='text' name='strApproxAmt' id='strApproxAmt"+i+""+j+"'  class='txtFldNormal' readonly='readonly'   value='"+ws.getString(7)+"'></td>");
								br.append("</tr>");							
							}
							else
							{
								    strGroupName = ws.getString(1).trim();							    
								    br.append("<tr>");
									br.append("<td class='multiCLRLabel' style=\"text-align:left;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Name::<u>"+ws.getString(1)+"</u></b></font></td>");
									br.append("</tr>");
									br.append("<input type='hidden' name='itemName'     id='itemName"+i+""+j+"' value='"+ws.getString(3)+"'>");
									br.append("<input type='hidden' name='rateForCalc'  id='rateForCalc"+i+""+j+"' value='"+ws.getString(11)+"'>");
									br.append("<input type='hidden' name='itemParamValue' id='itemParamValue"+i+""+j+"' value='"+ws.getString(12)+"'>");
									br.append("<input type='hidden' name='groupName'    id='groupName"+i+""+j+"' value='"+ws.getString(1)+"^"+i+""+j+"'>");
									br.append("<input type='hidden' name='divIndex'     id='divIndex"+i+"' value='"+i+"'>");
									br.append("<tr>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId1"+i+""+j+"'  width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId2"+i+""+j+"'  width='30%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><a STYLE='CURSOR:POINTER;color:blue'  title='Rate/Unit is  [ "+ws.getString(10)+" ]' >"+ws.getString(3)+"</a></font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId3"+i+""+j+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(4)+"</font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId4"+i+""+j+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><a STYLE='CURSOR:POINTER;color:blue' title='Received Date'>"+ws.getString(5)+"</a></font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId5"+i+""+j+"'  width='10%'><input type='text' name='strCHMOQty' id='strCHMOQty"+i+""+j+"'  class='txtFldNormal' maxlength ='8'   onkeypress='return validateData(event,5);' value='"+ws.getString(13)+"' onkeyup='CalculateItemTotal("+i+""+j+",1);'></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId6"+i+""+j+"'  width='10%'><input type='text' name='strMCQty' id='strMCQty"+i+""+j+"'      class='txtFldNormal' maxlength ='8'   onkeypress='return validateData(event,5);' value='"+ws.getString(14)+"' onkeyup='CalculateItemTotal("+i+""+j+",1);'></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId7"+i+""+j+"'  width='10%'><input type='text' name='strTotalQty'  readonly='readonly' id='strTotalQty"+i+""+j+"' class='txtFldNormal'    value='"+ws.getString(6)+"' ></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId8"+i+""+j+"'  width='12%'><input type='text' class='txtFldNormal'  readonly='readonly'  name='strApproxAmt' id='strApproxAmt"+i+""+j+"' value='"+ws.getString(7)+"'></td>");
									br.append("</tr>");		

							}
							
							count++ ;
							
						}
						else
						{
							break;
						}
					 
					}
						br.append("</table>");
						
						
						br.append("</div>");
	
				} 
				else 
				{
					br.append("<div id='DivId" + i+ "' style='display:none'>");
					
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
					for (int k = 0; k < reminder; k++) 
					{
						/*
					  	 1.Group Name
					  	 2.CPA Code
					  	 3.Item Name
					  	 4.Avalaible Quantity
					  	 5.Last Indent Quantity
					  	 6.Total Qty
					  	 7.Approx Cost					  	 
					  	 8.Item Brand Id
					  	 9.Item ID
					  	 10.Rate With Unit
					  	 11.Rate for Calculation	
					  	 ---------------------------------				  	 
					  	   12(0).Item Id
					  	   12(1).Item Brand ID
					  	   12(2).Group ID
					  	   12(3).Sub-Grp Id
					  	   12(4).Cosumable Flag
					  	   12(5).Re-Order Qty
					  	   12(6).Re-Order Qty Unit Id
					  	   12(7).In-Hand Qty
					  	   12(8).In-Hand Qty Unit Id
					  	   12(9).Last Rate
					  	   12(10).Last Rate Unit Id
					  	   12(11).Inventory Unit Id
					  	   12(12).Last PO No. 
					  	   12(13).Last PO Date
	                       12(14).Last Supplied By
	                       12(15).Batch No
	                       12(16).Expiry date
	                       12(17).Manufactrer Date
	                       12(18).Item Serial No
	                       12(19).Last Received Qty
	                       12(20).Last Received Qty Unit
	                       12(21).Last Indented Qty
	                       12(22).Last Indented Qty Unit Id
	                       12(23).Last Received Qty
	                       12(24).Last Received Qty Unit ID
	                       12(25).Last Year Consumption Qty
	                       12(26).Last Year Consumption Qty Unit Id
	                       12(27).Prefix
	                       12(28).Cost Parameter
	                       12(29).Cost Unit
	                       12(30).Purchase Lead Time
	                       12(31).Purchase Lead Time Unit
	                       12(32).Stock Status 
	                       12(33).Dummy
	                       12(34).Dummy
	                       12(35).Brand Reserved Flg
	                       12(36).Item Make
	                       12(37).CPA Code
	                       12(38).Dummy
	                       12(39).NA
                      -----------------------------
                      13.CHM_QTY
                      14.MC_QTY*/
						
						
						ws.next();
						if(count==0)
						{
							 strGroupName = ws.getString(1).trim();								 
							 br.append("<tr>");
							 br.append("<td class='multiCLRLabel' style=\"text-align:left;\"  colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Name::<u>"+ws.getString(1)+"</u></b></font></td>");
							 br.append("</tr>");
						}	
						
						if(strGroupName.equals(ws.getString(1).trim()))
						{
							br.append("<input type='hidden' name='itemName'     id='itemName"+i+""+k+"' value='"+ws.getString(3)+"'>");
							br.append("<input type='hidden' name='rateForCalc'  id='rateForCalc"+i+""+k+"' value='"+ws.getString(11)+"'>");
							br.append("<input type='hidden' name='itemParamValue' id='itemParamValue"+i+""+k+"' value='"+ws.getString(12)+"'>");
							br.append("<input type='hidden' name='groupName'    id='groupName"+i+""+k+"' value='"+ws.getString(1)+"^"+i+""+k+"'>");
							br.append("<input type='hidden' name='divIndex'     id='divIndex"+i+"' value='"+i+"'>");
							br.append("<tr>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId1"+i+""+k+"'  width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</font></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId2"+i+""+k+"'  width='30%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><a STYLE='CURSOR:POINTER;color:blue'  title='Rate/Unit is  [ "+ws.getString(10)+" ]'>"+ws.getString(3)+"</a></font></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId3"+i+""+k+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(4)+"</font></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId4"+i+""+k+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(5)+"</font></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId5"+i+""+k+"'  width='10%'><input type='text' name='strCHMOQty' id='strCHMOQty"+i+""+k+"'  class='txtFldNormal' maxlength ='8'   onkeypress='return validateData(event,5);'  value='"+ws.getString(13)+"' onkeyup='CalculateItemTotal("+i+""+k+",1);'></font></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId6"+i+""+k+"'  width='10%'><input type='text' name='strMCQty' id='strMCQty"+i+""+k+"'  class='txtFldNormal'      maxlength ='8'   onkeypress='return validateData(event,5);' value='"+ws.getString(14)+"'  onkeyup='CalculateItemTotal("+i+""+k+",1);'></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId7"+i+""+k+"'  width='10%'><input type='text' name='strTotalQty'  readonly='readonly' id='strTotalQty"+i+""+k+"' class='txtFldNormal' value='"+ws.getString(6)+"' ></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId8"+i+""+k+"'  width='12%'><input type='text' class='txtFldNormal' readonly='readonly'  name='strApproxAmt' id='strApproxAmt"+i+""+k+"' value='"+ws.getString(7)+"'></td>");
							br.append("</tr>");
							
							
						}
						else
						{
							    strGroupName = ws.getString(1).trim();
						    
							    br.append("<tr>");
							    br.append("<td class='multiCLRLabel' style=\"text-align:left;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Name::<u>"+ws.getString(1)+"</u></b></font></td>");
							    br.append("</tr>");
							    
							    br.append("<input type='hidden' name='itemName'     id='itemName"+i+""+k+"' value='"+ws.getString(3)+"'>");
								br.append("<input type='hidden' name='rateForCalc'  id='rateForCalc"+i+""+k+"' value='"+ws.getString(11)+"'>");
								br.append("<input type='hidden' name='itemParamValue' id='itemParamValue"+i+""+k+"' value='"+ws.getString(12)+"'>");
								br.append("<input type='hidden' name='groupName'    id='groupName"+i+""+k+"' value='"+ws.getString(1)+"^"+i+""+k+"'>");
								br.append("<input type='hidden' name='divIndex'     id='divIndex"+i+"' value='"+i+"'>");
								br.append("<tr>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId1"+i+""+k+"'  width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</font></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId2"+i+""+k+"'  width='30%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><a STYLE='CURSOR:POINTER;color:blue' title='Rate/Unit is  [ "+ws.getString(10)+" ]'>"+ws.getString(3)+"</a></font></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId3"+i+""+k+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(4)+"</font></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId4"+i+""+k+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(5)+"</font></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId5"+i+""+k+"'  width='10%'><input type='text' name='strCHMOQty' id='strCHMOQty"+i+""+k+"'   class='txtFldNormal' maxlength ='8'   onkeypress='return validateData(event,5);' value='"+ws.getString(13)+"' onkeyup='CalculateItemTotal("+i+""+k+",1);'></font></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId6"+i+""+k+"'  width='10%'><input type='text' name='strMCQty' id='strMCQty"+i+""+k+"'  class='txtFldNormal'      maxlength ='8'   onkeypress='return validateData(event,5);' value='"+ws.getString(14)+"' onkeyup='CalculateItemTotal("+i+""+k+",1);'></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId7"+i+""+k+"'  width='10%'><input type='text' name='strTotalQty'  readonly='readonly' id='strTotalQty"+i+""+k+"' class='txtFldNormal'  value='"+ws.getString(6)+"' ></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId8"+i+""+k+"'  width='12%'><input type='text' class='txtFldNormal' readonly='readonly' name='strApproxAmt' id='strApproxAmt"+i+""+k+"' value='"+ws.getString(7)+"'></td>");
								br.append("</tr>");

						}
						
						count++ ;
						
					}
					br.append("</table>");
								
					
					
					br.append("</div>");
					}
			   	}
			    br.append("</div>");
			    
			    br.append("<table class='TABLEWIDTH' align='center' cellpadding='1'	cellspacing='1'>");
			    br.append("<tr>");					
				br.append("<td CLASS='multiRPTLabel' colspan='7' width='88%' style=\"text-align:right;\">Total Cost(Rs)</td>");
				br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'><div id='strApproxAmtTotalDivId' align='center'>0.00</div><input type='hidden' name='strApproxAmtTotal'></td>");
				br.append("</tr>");			    
			    br.append("</table>");
			    
			    br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
			    br.append("<tr>");			   
			    br.append("<td class='LABEL'><span onclick='prevFunction();' class='pg-normal'> &#171 Prev </span><select name='pageIndeCmb' class='comboMin' onchange='openItemDiv(this);'>");
				for (int k = 1; k <= totalLayer; k++)
				{
					br.append("<option value='"+k+"'>"+k+"</option>");						
				}
			    br.append("</select>");
			    br.append("<span onclick='nextFunction();' class='pg-normal'> Next &#187;</span>");
			    br.append("</td></tr>");
			    br.append("</table>");	
			   
			}
			else
			{
				 
				
				    br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				    br.append("<tr bgcolor='#FFEBD5'>");					
					br.append("<th colspan='4'></th>");
					br.append("<th colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' style=\"color: #653232;\" >Requested Quantity</font></th>");
					br.append("<th colspan='1'></th>");
					br.append("</tr>");
				    br.append("<tr>");					
				    br.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Item Code</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>Item Name</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Avl. Qty</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Last Indent Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>CHMO Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>MC Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Total Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Approx Cost</td>");
					br.append("</tr>");
				    br.append("<tr>");  
	           	    br.append("<td class='multiRPTControl' colspan='8'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	    br.append("</table>");
	           	
					
			   }
			} 
		    else
				{
					 
					 
		    	    br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		    	    br.append("<tr bgcolor='#FFEBD5'>");					
					br.append("<th colspan='4'></th>");
					br.append("<th colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' style=\"color: #653232;\" >Requested Quantity</font></th>");
					br.append("<th colspan='1'></th>");
					br.append("</tr>");
				    br.append("<tr>");					
				    br.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Item Code</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>Item Name</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Avl. Qty</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Last Indent Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>CHMO Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>MC Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Total Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Approx Cost</td>");
					br.append("</tr>");
				    br.append("<tr>");  
	           	    br.append("<td class='multiRPTControl' colspan='9'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	    br.append("</table>");
		          	
						
				   }
	     }
		
	catch (Exception e) {	
		    e.printStackTrace();
			throw new Exception("OffLineIssueIndentTransHLP.getIndentItemList()->"+e.getMessage());
		}
		return br.toString();
	}
	
	public static String getIndentItemListForModify(RoutinePurchaseVO vo) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		final int REC_PER_PAGE = 20;
		final int PAGE_PER_BLOCK = 20;
		String strGroupName="";		
		double totalFinalCost = 0.00;
		double cltamt  = 0.00;
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		WebRowSet ws =null;
		NumberFormat formatter = new DecimalFormat("############.##");
		try
	    {   		
			ws  = vo.getIndentItemWS();		
			//br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	//br.append("<tr><td colspan='4' width='100%' class='TITLE'>Supplier Performance Details</td></tr></table>");	
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
				     int actualFetchRecord = ws.size();			
			         if(totalFetchRecord != actualFetchRecord)
					 {
						totalFetchRecord = actualFetchRecord;
						totalRecordsToManipulate = actualFetchRecord;
					 }
				    int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
				    int reminder = totalRecordsToManipulate % REC_PER_PAGE;
				    if (reminder > 0)
				    	
					totalLayer = totalLayer + 1;
				 
				    br.append("<input type='hidden' name='TotalLayer'  value='"+totalLayer+"'>");
				    br.append("<input type='hidden' name='RecordShowOnPage'  value='"+REC_PER_PAGE+"'>");
				    br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				    br.append("<tr>");			   
					br.append("<td class='TITLE' style=\"text-align:right;\" colspan='8'>Drug Name::::<select name='strItemNameCmb' class='comboTooMax'  onchange='openItemDivForItem(this);'>");
					br.append("<option value='0^0'>ALL</option>");
					while(ws.next())
					{	
//						   System.out.println("Grp Name:::"+ws.getString(1));
//						   System.out.println("CPA Code:::"+ws.getString(2));
//						   System.out.println("Item Name:::"+ws.getString(3));
//						   System.out.println("Avl Qty:::"+ws.getString(4));
//						   System.out.println("Last Indent Qty:::"+ws.getString(5));
//						   System.out.println("Total Qty:::"+ws.getString(6));
//						   System.out.println("Appx Cost:::"+ws.getString(7));
//						   System.out.println("Item Brand Id:::"+ws.getString(8));
//						   System.out.println("Item Id:::"+ws.getString(9));
//						   System.out.println("Rate to View:::"+ws.getString(10));
//						   System.out.println("Rate for Calculation:::"+ws.getString(11));
						   //System.out.println("Hiddent Value:::"+ws.getString(12));
						   //System.out.println("CHC#MCQ Qty:::"+ws.getString(13));		   
						   
						   
							br.append("<option value='"+ws.getString(1)+"^"+ws.getString(3)+"'>"+ws.getString(3)+"</option>");
							int          chm_qty = Integer.parseInt(ws.getString(13).split("\\#")[0]);
							int           mc_qty = Integer.parseInt(ws.getString(13).split("\\#")[1]);
							//System.out.println("chm_qty:::"+chm_qty);
							//System.out.println("mc_qty:::"+mc_qty);
							int         totalQty = (chm_qty + mc_qty);
							//System.out.println("Total Qty:::"+totalQty);
							double      rate_cal = Double.parseDouble(ws.getString(11));
							double     totalCost = rate_cal * totalQty;
							      totalFinalCost = totalFinalCost + totalCost;                      //Calculate Total Cost  
					}
					ws.beforeFirst();
					String FinaltotalCost = formatter.format(new BigDecimal(totalFinalCost)); 	
					br.append("</select></td></tr>");
					br.append("</table>");
					
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
					br.append("<tr bgcolor='#FFEBD5'>");					
					br.append("<th colspan='4'></th>");
					br.append("<th colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' style=\"color: #653232;\" >Requested Quantity</font></th>");
					br.append("<th colspan='1'></th>");
					br.append("</tr>");
					br.append("<tr>");					
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Item Code</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>Item Name</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Avl. Qty</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Last Indent Qty.</td>");					
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>MC Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>CHMO Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Total Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Approx Cost</td>");					
					br.append("</tr>");					
					br.append("</table>");
					
					
			    for (int i = 1; i <= totalLayer; i++) 
			    {
				 if (i <= totalLayer) 
				 {
					 
					if (i == 1) 
					{
						br.append("<div id='DivId" +i+ "' style='display:block'>");
					} 
					else
					{
						br.append("<div id='DivId" +i+ "' style='display:none'>");
					}
					
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
					for (int j = 0; j < REC_PER_PAGE; j++) 
					{
						/*
					  	 1.Group Name
					  	 2.CPA Code
					  	 3.Item Name
					  	 4.Avalaible Quantity
					  	 5.Last Indent Quantity
					  	 6.Total Qty
					  	 7.Approx Cost					  	 
					  	 8.Item Brand Id
					  	 9.Item ID
					  	 10.Rate With Unit
					  	 11.Rate for Calculation	
					  	 ---------------------------------				  	 
					  	 12.Rate # Rate Unit ID
                       -----------------------------
                       13.CHM_QTY  #  MC_QTY
                       */
						
						if(ws.next())
						{						
							if(count==0)
							{
								 strGroupName = ws.getString(1).trim();								 
								 br.append("<tr>");
								 br.append("<td class='multiCLRLabel'  style=\"text-align:left;\"  colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Name::<u>"+ws.getString(1)+"</u></b></font></td>");
								 br.append("</tr>");
							}	
							
							if(strGroupName.equals(ws.getString(1).trim()))
							{
								
								int          chm_qty = Integer.parseInt(ws.getString(13).split("\\#")[0]);
								int           mc_qty = Integer.parseInt(ws.getString(13).split("\\#")[1]);
								int         totalQty = (chm_qty + mc_qty);
								double      rate_cal = Double.parseDouble(ws.getString(11));
								double     totalCost = rate_cal * totalQty;
								String TotalCost = formatter.format(new BigDecimal(totalCost)); 	
								br.append("<input type='hidden' name='itemBrandId' id='itemBrandId"+i+""+j+"' value='"+ws.getString(8)+"'>");
								br.append("<input type='hidden' name='itemId' id='itemId"+i+""+j+"' value='"+ws.getString(9)+"'>");
								br.append("<input type='hidden' name='itemName' id='itemName"+i+""+j+"' value='"+ws.getString(3)+"'>");
								br.append("<input type='hidden' name='rateForCalc' id='rateForCalc"+i+""+j+"' value='"+ws.getString(11)+"'>");
								br.append("<input type='hidden' name='itemParamValue' id='itemParamValue"+i+""+j+"' value='"+ws.getString(12)+"'>");
								br.append("<input type='hidden' name='groupName' id='groupName"+i+""+j+"' value='"+ws.getString(1)+"^"+i+""+j+"'>");
								br.append("<input type='hidden' name='divIndex' id='divIndex"+i+"' value='"+i+"'>");
								br.append("<tr>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId1"+i+""+j+"'  width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</font></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId2"+i+""+j+"'  width='30%'  width='30%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><a STYLE='CURSOR:POINTER;color:blue' title='Rate/Unit is  [ "+ws.getString(10)+" ]'>"+ws.getString(3)+"</a></font></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId3"+i+""+j+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(4)+"</font></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId4"+i+""+j+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(5)+"</font></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId5"+i+""+j+"'  width='10%'><input type='text' name='strCHMOQty'   id='strCHMOQty"+i+""+j+"'    class='txtFldNormal' maxlength ='8'   onkeypress='return validateData(event,5);'  value='"+chm_qty+"'  onblur='CalculateItemTotal("+i+""+j+",2);'></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId6"+i+""+j+"'  width='10%'><input type='text' name='strMCQty'     id='strMCQty"+i+""+j+"'      class='txtFldNormal' maxlength ='8'   onkeypress='return validateData(event,5);'  value='"+mc_qty+"'  onblur='CalculateItemTotal("+i+""+j+",2);' ></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId7"+i+""+j+"'  width='10%'><input type='text' name='strTotalQty'  id='strTotalQty"+i+""+j+"'   class='txtFldNormal' readonly='readonly'   value='"+totalQty+"' ></td>");
								br.append("<td class='multiPOControl' name='tdId' id='tdId8"+i+""+j+"'  width='12%' style=\"text-align:left;\"><input type='text' name='strApproxAmt' id='strApproxAmt"+i+""+j+"'  class='txtFldNormal' readonly='readonly'   value='"+TotalCost+"'></td>");
								br.append("</tr>");							
							}
							else
							{
								    strGroupName = ws.getString(1).trim();	
								    int          chm_qty = Integer.parseInt(ws.getString(13).split("\\#")[0]);
									int           mc_qty = Integer.parseInt(ws.getString(13).split("\\#")[1]);
									int         totalQty = (chm_qty + mc_qty);
									double      rate_cal = Double.parseDouble(ws.getString(11));
									double     totalCost = rate_cal * totalQty;
									String TotalCost = formatter.format(new BigDecimal(totalCost));
									
								    br.append("<tr>");
									br.append("<td class='multiCLRLabel' style=\"text-align:left;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Name::<u>"+ws.getString(1)+"</u></b></font></td>");
									br.append("</tr>");
									br.append("<input type='hidden' name='itemBrandId' id='itemBrandId"+i+""+j+"' value='"+ws.getString(8)+"'>");
									br.append("<input type='hidden' name='itemId' id='itemId"+i+""+j+"' value='"+ws.getString(9)+"'>");
									br.append("<input type='hidden' name='itemName'     id='itemName"+i+""+j+"' value='"+ws.getString(3)+"'>");
									br.append("<input type='hidden' name='rateForCalc'  id='rateForCalc"+i+""+j+"' value='"+ws.getString(11)+"'>");
									br.append("<input type='hidden' name='itemParamValue' id='itemParamValue"+i+""+j+"' value='"+ws.getString(12)+"'>");
									br.append("<input type='hidden' name='groupName'    id='groupName"+i+""+j+"' value='"+ws.getString(1)+"^"+i+""+j+"'>");
									br.append("<input type='hidden' name='divIndex'     id='divIndex"+i+"' value='"+i+"'>");
									br.append("<tr>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId1"+i+""+j+"'  width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId2"+i+""+j+"'  width='30%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><a STYLE='CURSOR:POINTER;color:blue'  title='Rate/Unit is  [ "+ws.getString(10)+" ]' >"+ws.getString(3)+"</a></font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId3"+i+""+j+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(4)+"</font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId4"+i+""+j+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><a STYLE='CURSOR:POINTER;color:blue' title='Received Date'>"+ws.getString(5)+"</a></font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId5"+i+""+j+"'  width='10%'><input type='text' name='strCHMOQty' id='strCHMOQty"+i+""+j+"'  class='txtFldNormal' maxlength ='8'   onkeypress='return validateData(event,5);' value='"+chm_qty+"' onblur='CalculateItemTotal("+i+""+j+",2);'></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId6"+i+""+j+"'  width='10%'><input type='text' name='strMCQty' id='strMCQty"+i+""+j+"'      class='txtFldNormal' maxlength ='8'   onkeypress='return validateData(event,5);' value='"+mc_qty+"'  onblur='CalculateItemTotal("+i+""+j+",2);'></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId7"+i+""+j+"'  width='10%'><input type='text' name='strTotalQty'  readonly='readonly' id='strTotalQty"+i+""+j+"' class='txtFldNormal'    value='"+totalQty+"' ></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId8"+i+""+j+"'  width='12%' style=\"text-align:left;\"><input type='text' class='txtFldNormal'  readonly='readonly'  name='strApproxAmt' id='strApproxAmt"+i+""+j+"' value='"+TotalCost+"'></td>");
									br.append("</tr>");		

							}
							
							count++ ;
							
						}
						else
						{
							break;
						}
					 
					}
						br.append("</table>");
						
						
						br.append("</div>");
	
				} 
				else 
				{
					br.append("<div id='DivId" + i+ "' style='display:none'>");
					
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
					for (int k = 0; k < reminder; k++) 
					{
						/*
					  	 1.Group Name
					  	 2.CPA Code
					  	 3.Item Name
					  	 4.Avalaible Quantity
					  	 5.Last Indent Quantity
					  	 6.Total Qty
					  	 7.Approx Cost					  	 
					  	 8.Item Brand Id
					  	 9.Item ID
					  	 10.Rate With Unit
					  	 11.Rate for Calculation	
					  	 ---------------------------------				  	 
					  	 12.Rate # Rate Unit ID
                      -----------------------------
                      13.CHM_QTY  #  MC_QTY
                      */
						
						
						ws.next();
						if(count==0)
						{
							 strGroupName = ws.getString(1).trim();								 
							 br.append("<tr>");
							 br.append("<td class='multiCLRLabel' style=\"text-align:left;\"  colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Name::<u>"+ws.getString(1)+"</u></b></font></td>");
							 br.append("</tr>");
						}	
						
						if(strGroupName.equals(ws.getString(1).trim()))
						{
							int          chm_qty = Integer.parseInt(ws.getString(13).split("\\#")[0]);
							int           mc_qty = Integer.parseInt(ws.getString(13).split("\\#")[1]);
							int         totalQty = (chm_qty + mc_qty);
							double      rate_cal = Double.parseDouble(ws.getString(11));
							double     totalCost = rate_cal * totalQty;
							String TotalCost = formatter.format(new BigDecimal(totalCost));
							br.append("<input type='hidden' name='itemBrandId' id='itemBrandId"+i+""+k+"' value='"+ws.getString(8)+"'>");
							br.append("<input type='hidden' name='itemId' id='itemId"+i+""+k+"' value='"+ws.getString(9)+"'>");
							br.append("<input type='hidden' name='itemName'     id='itemName"+i+""+k+"' value='"+ws.getString(3)+"'>");
							br.append("<input type='hidden' name='rateForCalc'  id='rateForCalc"+i+""+k+"' value='"+ws.getString(11)+"'>");
							br.append("<input type='hidden' name='itemParamValue' id='itemParamValue"+i+""+k+"' value='"+ws.getString(12)+"'>");
							br.append("<input type='hidden' name='groupName'    id='groupName"+i+""+k+"' value='"+ws.getString(1)+"^"+i+""+k+"'>");
							br.append("<input type='hidden' name='divIndex'     id='divIndex"+i+"' value='"+i+"'>");
							br.append("<tr>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId1"+i+""+k+"'  width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</font></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId2"+i+""+k+"'  width='30%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><a STYLE='CURSOR:POINTER;color:blue'  title='Rate/Unit is  [ "+ws.getString(10)+" ]'>"+ws.getString(3)+"</a></font></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId3"+i+""+k+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(4)+"</font></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId4"+i+""+k+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(5)+"</font></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId5"+i+""+k+"'  width='10%'><input type='text' name='strCHMOQty' id='strCHMOQty"+i+""+k+"'  class='txtFldNormal' maxlength ='8'   onkeypress='return validateData(event,5);'  value='"+chm_qty+"' onblur='CalculateItemTotal("+i+""+k+",2);'></font></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId6"+i+""+k+"'  width='10%'><input type='text' name='strMCQty' id='strMCQty"+i+""+k+"'  class='txtFldNormal'      maxlength ='8'   onkeypress='return validateData(event,5);' value='"+mc_qty+"'  onblur='CalculateItemTotal("+i+""+k+",2);'></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId7"+i+""+k+"'  width='10%'><input type='text' name='strTotalQty'  readonly='readonly' id='strTotalQty"+i+""+k+"' class='txtFldNormal' value='"+totalQty+"' ></td>");
							br.append("<td class='multiPOControl'  name='tdId' id='tdId8"+i+""+k+"'  width='12%' style=\"text-align:left;\"><input type='text' class='txtFldNormal' readonly='readonly'  name='strApproxAmt' id='strApproxAmt"+i+""+k+"' value='"+TotalCost+"'></td>");
							br.append("</tr>");
							
							
						}
						else
						{
							    strGroupName = ws.getString(1).trim();
							    
							    int          chm_qty = Integer.parseInt(ws.getString(13).split("\\#")[0]);
								int           mc_qty = Integer.parseInt(ws.getString(13).split("\\#")[1]);
								int         totalQty = (chm_qty + mc_qty);
								double      rate_cal = Double.parseDouble(ws.getString(11));
								double     totalCost = rate_cal * totalQty;
								String TotalCost = formatter.format(new BigDecimal(totalCost));
							    br.append("<tr>");
							    br.append("<td class='multiCLRLabel' style=\"text-align:left;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Group Name::<u>"+ws.getString(1)+"</u></b></font></td>");
							    br.append("</tr>");
							    br.append("<input type='hidden' name='itemBrandId' id='itemBrandId"+i+""+k+"' value='"+ws.getString(8)+"'>");
								br.append("<input type='hidden' name='itemId' id='itemId"+i+""+k+"' value='"+ws.getString(9)+"'>");
							    br.append("<input type='hidden' name='itemName'     id='itemName"+i+""+k+"' value='"+ws.getString(3)+"'>");
								br.append("<input type='hidden' name='rateForCalc'  id='rateForCalc"+i+""+k+"' value='"+ws.getString(11)+"'>");
								br.append("<input type='hidden' name='itemParamValue' id='itemParamValue"+i+""+k+"' value='"+ws.getString(12)+"'>");
								br.append("<input type='hidden' name='groupName'    id='groupName"+i+""+k+"' value='"+ws.getString(1)+"^"+i+""+k+"'>");
								br.append("<input type='hidden' name='divIndex'     id='divIndex"+i+"' value='"+i+"'>");
								br.append("<tr>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId1"+i+""+k+"'  width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</font></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId2"+i+""+k+"'  width='30%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><a STYLE='CURSOR:POINTER;color:blue' title='Rate/Unit is  [ "+ws.getString(10)+" ]'>"+ws.getString(3)+"</a></font></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId3"+i+""+k+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(4)+"</font></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId4"+i+""+k+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(5)+"</font></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId5"+i+""+k+"'  width='10%'><input type='text' name='strCHMOQty' id='strCHMOQty"+i+""+k+"'   class='txtFldNormal' maxlength ='8'   onkeypress='return validateData(event,5);' value='"+chm_qty+"' onblur='CalculateItemTotal("+i+""+k+",2);'></font></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId6"+i+""+k+"'  width='10%'><input type='text' name='strMCQty' id='strMCQty"+i+""+k+"'  class='txtFldNormal'      maxlength ='8'   onkeypress='return validateData(event,5);' value='"+mc_qty+"' onblur='CalculateItemTotal("+i+""+k+",2);'></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId7"+i+""+k+"'  width='10%'><input type='text' name='strTotalQty'  readonly='readonly' id='strTotalQty"+i+""+k+"' class='txtFldNormal'  value='"+rate_cal+"' ></td>");
								br.append("<td class='multiPOControl'  name='tdId' id='tdId8"+i+""+k+"'  width='12%' style=\"text-align:left;\"><input type='text' class='txtFldNormal' readonly='readonly' name='strApproxAmt' id='strApproxAmt"+i+""+k+"' value='"+TotalCost+"'></td>");
								br.append("</tr>");

						}
						
						count++ ;
						
					}
					br.append("</table>");
								
					
					
					br.append("</div>");
					}
			   	}
			    br.append("</div>");
			    
			    br.append("<table class='TABLEWIDTH' align='center' cellpadding='1'	cellspacing='1'>");
			    br.append("<tr>");					
				br.append("<td CLASS='multiRPTLabel' colspan='7' width='88%' style=\"text-align:right;\">Total Cost(Rs)</td>");
				br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'><input type='text' name='strApproxAmtTotal' class='txtFldNormal' readonly='readonly' value='"+FinaltotalCost+"'></td>");
				br.append("</tr>");			    
			    br.append("</table>");
			    
			    br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
			    br.append("<tr>");			   
			    br.append("<td class='LABEL'><span onclick='prevFunction();' class='pg-normal'> &#171 Prev </span><select name='pageIndeCmb' class='comboMin' onchange='openItemDiv(this);'>");
				for (int k = 1; k <= totalLayer; k++)
				{
					br.append("<option value='"+k+"'>"+k+"</option>");						
				}
			    br.append("</select>");
			    br.append("<span onclick='nextFunction();' class='pg-normal'> Next &#187;</span>");
			    br.append("</td></tr>");
			    br.append("</table>");	
			   
			}
			else
			{
				 
				
				    br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				    br.append("<tr bgcolor='#FFEBD5'>");					
					br.append("<th colspan='4'></th>");
					br.append("<th colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' style=\"color: #653232;\" >Requested Quantity</font></th>");
					br.append("<th colspan='1'></th>");
					br.append("</tr>");
				    br.append("<tr>");					
				    br.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Item Code</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>Item Name</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Avl. Qty</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Last Indent Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>CHMO Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>MC Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Total Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Approx Cost</td>");
					br.append("</tr>");
				    br.append("<tr>");  
	           	    br.append("<td class='multiRPTControl' colspan='8'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	    br.append("</table>");
	           	
					
			   }
			} 
		    else
				{
					 
					 
		    	    br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		    	    br.append("<tr bgcolor='#FFEBD5'>");					
					br.append("<th colspan='4'></th>");
					br.append("<th colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' style=\"color: #653232;\" >Requested Quantity</font></th>");
					br.append("<th colspan='1'></th>");
					br.append("</tr>");
				    br.append("<tr>");					
				    br.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Item Code</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>Item Name</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Avl. Qty</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Last Indent Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>CHMO Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>MC Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Total Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Approx Cost</td>");
					br.append("</tr>");
				    br.append("<tr>");  
	           	    br.append("<td class='multiRPTControl' colspan='9'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	    br.append("</table>");
		          	
						
				   }
	     }
		
	catch (Exception e) {	
		    e.printStackTrace();
			throw new Exception("OffLineIssueIndentTransHLP.getIndentItemList()->"+e.getMessage());
		}
		return br.toString();
	}
	
}
