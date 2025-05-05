package mms.transactions.controller.hlp;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.ReplacementCondemnationOrderTransBO;
import mms.transactions.controller.fb.ReplacementCondemnationOrderTransFB;
import mms.transactions.vo.ReplacementCondemnationOrderTransVO;


public class ReplacementCondemnationOrderTransHLP {
	
	public static String getPendingOrderHLP(ReplacementCondemnationOrderTransVO vo) 
	{
		System.out.println("----------------------- ReplacementCondemnationOrderTransHLP.getPendingOrderHLP --------------------------");
		
		StringBuffer br = new StringBuffer();		
		WebRowSet wb = vo.getWsPendingOrderDtl();					
		try
		{			
			if (wb != null && wb.size() > 0) 
			{
				
					br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td colspan='6' class='LABEL'>");					
					br.append("<div id='PendingOrderId' style='display:none;' align='right' ><input type='radio' title='View' name='strReplacementRadio'  id='strReplacementRadio' onclick='getPendingOrderDtl(2);'>Replacement<input type='radio' title='View' name='strCondemRadio' checked='checked' id='strCondemRadio' onclick='getPendingOrderDtl(3);'>Condemnation</div></td></tr>");
					br.append("<tr>");					
					br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Order No.</td>");
					br.append("<td WIDTH='14%'  colspan='1' class='multiRPTLabel'>Order Date</td>");
					//br.append("<td WIDTH='17%'  colspan='1' class='multiRPTLabel'>Order To</td>");
					br.append("<td WIDTH='16%'  colspan='1' class='multiRPTLabel'>Order Type</td>");					
					br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Prev Order Ref No</td>");						
					br.append("<td WIDTH='28%'  colspan='1' class='multiRPTLabel'>Item Name</td>");	
					br.append("<td WIDTH='5%'  colspan='1' class='multiRPTLabel'>Cancel</td>");	
					br.append("</tr> ");
					br.append("</table> ");
					br.append("<table class='TABLEWIDTH' align='center' border='0'  cellspacing ='1px' cellpadding='1px' >");
					while (wb.next()) 
					{
						/*
						 * 1.Order No
						 * 2.Order Date
						 * 3.Supplier Name
						 * 4.Order Type
						 * 5.Previouse Order
						 * 6.Item Name 						 
						 */																
					br.append("<TR>");								
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ wb.getString(1) + "</TD>");
					br.append("<TD WIDTH='14%'  colspan='1' CLASS='multiRPTControl' >"+ wb.getString(2) + "</TD>");
					//br.append("<TD WIDTH='17%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ wb.getString(3) + "</TD>");
					br.append("<TD WIDTH='16%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ wb.getString(4) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' >"+ wb.getString(5) + "</TD>");
					br.append("<TD WIDTH='28%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ wb.getString(6) + "</TD>");
					br.append("<TD WIDTH='5%'  colspan='1' CLASS='multiRPTControl' ><a href='#' title='Cancel Pending Order No. "+ wb.getString(1)+"'><img src='../../hisglobal/images/cancel.png' value="+wb.getString(1)+" onclick='cancelorder("+wb.getString(1)+")'></a></TD>");
					br.append("</TR>");
					
				}  
					
					br.append("</table> ");					

			}
			if (wb.size() == 0 || wb == null) 
			{
				br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr>");
				br.append("<td colspan='6' class='LABEL'>");					
				br.append("<div id='PendingOrderId' style='display:none;' align='right'><input type='radio' title='View' name='strReplacementRadio' checked='checked' id='strReplacementRadio' onclick='getPendingOrderDtl(2);'>Replacement<input type='radio' title='View' name='strCondemRadio' id='strCondemRadio' onclick='getPendingOrderDtl(3);'>Condemnation</div></td></tr>");
				br.append("<tr>");					
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Order No.</td>");
				br.append("<td WIDTH='14%'  colspan='1' class='multiRPTLabel'>Order Date</td>");
				br.append("<td WIDTH='17%'  colspan='1' class='multiRPTLabel'>Order To</td>");
				br.append("<td WIDTH='16%'  colspan='1' class='multiRPTLabel'>Order Type</td>");					
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Prev Order Ref No</td>");						
				br.append("<td WIDTH='28%'  colspan='1' class='multiRPTLabel'>Item Name</td>");
				br.append("<td WIDTH='5%'  colspan='1' class='multiRPTLabel'>Cancel</td>");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				br.append("<TR>");
				
				
				if(vo.getStrActionsId().equals("1"))
				{	
				 br.append("<td class='multiRPTControl' colspan='6'><b><div id='id' align='center' color='Red'>No Record found</div></b></td>");
				}
				else
				{	
				  if(vo.getStrActionsId().equals("2"))
				  {	
				  br.append("<td class='multiRPTControl' colspan='6'><b><div id='id' align='center' color='Red'>No Record found</div></b></td>");
				  }
				  else
				  {
					br.append("<td class='multiRPTControl' colspan='6'><b><div id='id' align='center' color='Red'>No Record found</div></b></td>");
				  }
				}
				br.append("</TR>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {

		}
		//System.out.println("Pending order dtl in hlp: "+br.toString());
		return br.toString();
	}

	
	public static String getPendingOrderHLPNEW(ReplacementCondemnationOrderTransVO vo) 
	{
		System.out.println("----------------------- ReplacementCondemnationOrderTransHLP.getPendingOrderHLPNEW --------------------------");
		
		StringBuffer br = new StringBuffer();		
		WebRowSet wb = vo.getWsPendingOrderDtl();					
		try
		{			
			if (wb != null && wb.size() > 0) 
			{
				
					br.append("<table class='table table-striped' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td colspan='7' class='LABEL'>");					
					br.append("<div id='PendingOrderId' style='display:none;' align='right' ><input type='radio' title='View' name='strReplacementRadio'  id='strReplacementRadio' onclick='getPendingOrderDtl(2);'>Replacement<input type='radio' title='View' name='strCondemRadio' checked='checked' id='strCondemRadio' onclick='getPendingOrderDtl(3);'>Condemnation</div></td></tr>");
					br.append("<tr>");					
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Order No.</td>");
					br.append("<td WIDTH='14%'  colspan='1' class='font-weight-bold'>Order Date</td>");
					//br.append("<td WIDTH='17%'  colspan='1' class='multiRPTLabel'>Order To</td>");
					br.append("<td WIDTH='16%'  colspan='1' class='font-weight-bold'>Order Type</td>");					
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Prev Order Ref No</td>");						
					br.append("<td WIDTH='28%'  colspan='1' class='font-weight-bold'>Item Name</td>");	
					br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>Cancel</td>");	
					br.append("</tr> ");
					br.append("</table> ");
					br.append("<table class='table table-striped' align='center' border='0'  cellspacing ='1px' cellpadding='1px' >");
					while (wb.next()) 
					{
						/*
						 * 1.Order No
						 * 2.Order Date
						 * 3.Supplier Name
						 * 4.Order Type
						 * 5.Previouse Order
						 * 6.Item Name 						 
						 */																
					br.append("<TR>");								
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='' style=\"text-align:center;\">"+ wb.getString(1) + "</TD>");
					br.append("<TD WIDTH='14%'  colspan='1' CLASS='' >"+ wb.getString(2) + "</TD>");
					//br.append("<TD WIDTH='17%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ wb.getString(3) + "</TD>");
					br.append("<TD WIDTH='16%'  colspan='1' CLASS='' style=\"text-align:center;\">"+ wb.getString(4) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='' >"+ wb.getString(5) + "</TD>");
					br.append("<TD WIDTH='28%'  colspan='1' CLASS='' style=\"text-align:center;\">"+ wb.getString(6) + "</TD>");
					br.append("<TD WIDTH='5%'  colspan='1' CLASS='' ><a href='#' title='Cancel Pending Order No. "+ wb.getString(1)+"'><i class=\"fas fa-minus-circle\" style='color:red;' value="+wb.getString(1)+" onclick='cancelorder("+wb.getString(1)+")'></i></a></TD>");
					br.append("</TR>");
					
				}  
					
					br.append("</table> ");					

			}
			if (wb.size() == 0 || wb == null) 
			{
				br.append("<table class='table table-striped' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr>");
				br.append("<td colspan='7' class='LABEL'>");					
				br.append("<div id='PendingOrderId' style='display:none;' align='right'><input type='radio' title='View' name='strReplacementRadio' checked='checked' id='strReplacementRadio' onclick='getPendingOrderDtl(2);'>Replacement<input type='radio' title='View' name='strCondemRadio' id='strCondemRadio' onclick='getPendingOrderDtl(3);'>Condemnation</div></td></tr>");
				br.append("<tr>");					
				br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Order No.</td>");
				br.append("<td WIDTH='14%'  colspan='1' class='font-weight-bold'>Order Date</td>");
				br.append("<td WIDTH='17%'  colspan='1' class='font-weight-bold'>Order To</td>");
				br.append("<td WIDTH='16%'  colspan='1' class='font-weight-bold'>Order Type</td>");					
				br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Prev Order Ref No</td>");						
				br.append("<td WIDTH='28%'  colspan='1' class='font-weight-bold'>Item Name</td>");
				br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>Cancel</td>");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table class='table table-striped' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				br.append("<TR>");
				
				
				if(vo.getStrActionsId().equals("1"))
				{	
				 br.append("<td class='' colspan='6'><b><div id='id' align='center'><font color='red'>No Record found</font></div></b></td>");
				}
				else
				{	
				  if(vo.getStrActionsId().equals("2"))
				  {	
				  br.append("<td class='' colspan='6'><b><div id='id' align='center'><font color='red'>No Record found</font></div></b></td>");
				  }
				  else
				  {
					br.append("<td class='' colspan='6'><b><div id='id' align='center'><font color='red'>No Record found</font></div></b></td>");
				  }
				}
				br.append("</TR>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {

		}
		//System.out.println("Pending order dtl in hlp: "+br.toString());
		return br.toString();
	}

	
	public static String getNOSQDrugListHLP(ReplacementCondemnationOrderTransVO vo)
	{
		System.out.println("----------------------- ReplacementCondemnationOrderTransHLP.getNOSQDrugListHLP --------------------------");
		
		StringBuffer br = new StringBuffer();
		int i = 0;
		WebRowSet wb = vo.getWsNOSQItemDetail();					
		try
		{
			br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
			br.append("<tr>");
			br.append("<td WIDTH='5%'   colspan='1' class='multiRPTLabel'>#</td>");
			br.append("<td WIDTH='23%'  colspan='1' class='multiRPTLabel'>Item Name</td>");
			br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>Batch No</td>");
			br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>Mfg. Date</td>");
			br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>Exp. Date</td>");
			br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>Total Accepted Qty</td>");					
			br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>PO No.</td>");
			br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>Schedule No</td>");
			br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>PO Date</td>");
			br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>Tender No.</td>");
			br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>Supplied By</td>");
			br.append("</tr> ");
			
			if (wb != null && wb.size() > 0) 
			{												
					
					
					while (wb.next()) 
					{
						/*
						 * 1.DRUG_NAME
						 * 2.BATCH_NO
						 * 3.Accepted Qty
						 * 4.HSTNUM_PO_NO
						 * 5.Schedule No
						 * 6.PO_DATE
						 * 7.Supplied By
						 * 8.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_SL_NO^HSTNUM_OLD_PO_NO^HSTNUM_OLD_SCHEDULE_NO^HSTNUM_SUPPLIER_ID]
						 * 9. Exp.Date
						 * 10.Tender No. 
						 * 11. Manuf. Date
						 */
																	
					br.append("<TR>");										
					br.append("<td width='5%'  colspan='1' class='multiRPTLabel' id='check"+i+"'><input type='radio' title='View' name='strNosqDrugs' value='"+ wb.getString(8)+"^"+wb.getString(3)+"' id='strNosqDrugs"+i+"' onclick='showDeliveryDateDetails(1,this,\""+ i + "\");'></td>");
					br.append("</td>");						
					br.append("<TD WIDTH='23%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ wb.getString(1) + "</TD>");
					br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl'>"+ wb.getString(2) + "</TD>");
					br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl'>"+ wb.getString(11) + "</TD>");
					br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl'>"+ wb.getString(9) + "</TD>");
					br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl'>"+ wb.getString(3) + "</TD>");
					br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl'>"+ wb.getString(4) + "</TD>");
					br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl'>"+ wb.getString(5) + "</TD>");
					br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl'>"+ wb.getString(6) + "</TD>");
					br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ wb.getString(10) + "</TD>");
					br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ wb.getString(7) + "</TD>");					
					br.append("</TR>");
					i++;
				}  					
					/*br.append("</table> ");*/
					

						

			}
			if (wb.size() == 0) 
			{
				/*br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr class='TITLE'>");
				br.append("<td colspan='10'><div id='' align='left'>NOSQ Drug List</div></td></tr>");
				br.append("</table> ");					
				br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr>");
				br.append("<td WIDTH='5%'   colspan='1' class='multiRPTLabel'>#</td>");
				br.append("<td WIDTH='20%'  colspan='1' class='multiRPTLabel'>Item Name</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Batch No</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Exp. Date</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Total Accepted Qty</td>");					
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>PO No.</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Schedule No</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>PO Date</td>");
				br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Tender No.</td>");
				br.append("<td WIDTH='8%'   colspan='1' class='multiRPTLabel'>Supplied By</td>");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");*/
				br.append("<TR>");
				br.append("<td class='multiRPTControl' colspan='10'><b><div id='id' align='center' color='Red'>NOSQ drug list not found</div></b></td>");
				br.append("</TR>");
				
			}
			br.append("</table> ");
		} catch (Exception e) {

		}
//		System.out.println("ReceivedAndSuppPerfDetails in hlp: "+br.toString());
		return br.toString();
	}
	
	public static String getExpiryDrugListHLP(ReplacementCondemnationOrderTransVO vo)throws Exception 
	{
		System.out.println("----------------------- ReplacementCondemnationOrderTransHLP.getExpiryDrugListHLP --------------------------");
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 150;
		final int PAGE_PER_BLOCK = 50;
		WebRowSet ws = vo.getWbExpiryDrug();		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;		
		try
	    {
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
			    br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
			 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
			 br.append("<tr>");
			 br.append("<td class='LABEL'>");
			
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");			
			
				
			br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'   style='table-layout: fixed;word-wrap: break-word;'>");
			br.append("<tr>");
			br.append("<td WIDTH='5%'   colspan='1' class='multiRPTLabel'>#</td>");
			br.append("<td WIDTH='24%'  colspan='1' class='multiRPTLabel'>Name</td>");
			br.append("<td WIDTH='5%'   colspan='1' class='multiRPTLabel'>PO No</td>");
			br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Batch</td>");
			br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Mfg. Date</td>");
			br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Expiry Date</td>");					
			br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Avl Qty</td>");
			if(vo.getStrActionsId().equalsIgnoreCase("2"))
			{
			br.append("<td WIDTH='8%'   colspan='1' class='multiRPTLabel'>Condemnation Qty</td>");
			}else
			{
			br.append("<td WIDTH='8%'   colspan='1' class='multiRPTLabel'>Return Qty</td>");
			}			
			br.append("<td WIDTH='8%'   colspan='1' class='multiRPTLabel'>Rate/Unit.</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Supplied By</td>");
			br.append("<td WIDTH='8%'   colspan='1' class='multiRPTLabel'>Action</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Remarks</td>");
			br.append("</tr> ");
			br.append("</table> ");
			
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
				
				br.append("<table class='TABLEWIDTH' id='myTable' align='center' cellspacing='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{

						/*
						 * 1.DRUG_NAME
						 * 2.BATCH_NO
						 * 3.Exp Date
						 * 4.In Hand Qty
						 * 5.PO No
						 * 6.Supplied By
						 * 7.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_PO_NO^1^HSTNUM_SUPPLIED_BY ]
						 * 8.Mfg Date
						 * 9.Rate wth Tax (Sale Price) 
						 *10.Exp Remaining Days
						 *11.RC No 
						 * 
						 */
						
						br.append("<tr>");
						if(vo.getStrActionsId().equalsIgnoreCase("2"))
						{
						  br.append("<td width='5%'   colspan='1' class='multiRPTLabel' id='check"+i+""+j+"'><input type='checkbox' title='View' name='strExpiryDrugs' value='"+ ws.getString(7)+"^"+ws.getString(4)+"' id='strExpiryDrugs"+j+"' onclick='chkboxEnable2(this)'></td>");
						}
						else
						{
						  br.append("<td width='5%'   colspan='1' class='multiRPTLabel' id='check"+i+""+j+"'><input type='checkbox' title='View' name='strExpiryDrugs' value='"+ ws.getString(7)+"^"+ws.getString(4)+"' id='strExpiryDrugs"+j+"'  onclick='chkboxEnable1(this)' ></td>");
						}
						br.append("</td>");						
						br.append("<TD WIDTH='24%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(1) + "</TD>");
						br.append("<TD WIDTH='5%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");
						br.append("<TD WIDTH='7%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(2) + "</TD>");
						br.append("<TD WIDTH='7%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(8) + "</TD>");
						br.append("<TD WIDTH='7%'  colspan='1' CLASS='multiRPTControl'style=\"color: red;\">"+ ws.getString(3) + "</TD>");
						br.append("<TD WIDTH='7%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(4) + "</TD>");
						br.append("<input type='hidden' id='hidden"+i+"' name='totalvalue'  value='"+ws.getString(4)+"'>");
						br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl'> <input type='text' style=\"text-align:right;\"  class='txtFldNormal' name='condemqty' onchange=\"calRate(this,"+ws.getString(7).replace("^", "#").split("#")[1]+","+j+",'"+ws.getString(2)+"');\" onblur='chkTotalValue(this)' value='"+ws.getString(4)+"' id='condemqty"+j+"'></TD>");
							
						//br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");						
						br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:center;\">"+ ws.getString(9) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(6) + "</TD>");
						if(vo.getStrActionsId().equalsIgnoreCase("1"))
							br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl11' style=\"text-align:left;\"><select name='strRetActionType' onchange='getOtherTextBox(this)' id='strRetActionType1"+j+"' class='comboMin' disabled ><option title='Breakage' value='1'>Breakage</option><option title='Expiry' value='2'>Expiry</option><option title='Other' value='5'>Other</option></select></TD>");
						else
							br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl11' style=\"text-align:left;\"><select name='strRetActionType'  id='strRetActionTypeId"+j+"' class='comboMin' disabled ><option title='Condaminate' value='3'>Condaminate</option><option title='Other' value='5'>Other</option></select></TD>");
						//br.append("<TD WIDTH='2%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"></TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'> <div id='itemRemarksDivId"+j+"' style='display:none'><input type='text' style='width: 95%;'   name='strItemRemarks' value='' ></div></TD>");
						br.append("</tr>");
						
						count++ ;
						start++;
					}else{
						break;
					}
				}
					br.append("</table>");					
					br.append("</div>");

			} 
			else 
			{
				br.append("<div id='DivId" + i+ "' style='display:none'>");
				
				br.append("<table class='TABLEWIDTH' id='myTable' align='center' cellspacing='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					
					/*
					 * 1.DRUG_NAME
					 * 2.BATCH_NO
					 * 3.Exp Date
					 * 4.In Hand Qty
					 * 5.PO No
					 * 6.Supplied By
					 * 7.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_PO_NO^1^HSTNUM_SUPPLIED_BY ]
					 * 8.Mfg Date
					 * 9.Rate wth Tax (Sale Price) 
					 *10.Exp Remaining Days
					 *11.RC No 
					 * 
					 */
					br.append("<tr>");										
					br.append("<td width='5%'   colspan='1' class='multiRPTLabel' id='check"+i+""+k+"'><input type='radio' title='View' name='strExpiryDrugs' value='"+ ws.getString(7)+"^"+ws.getString(4)+"' id='strExpiryDrugs"+i+""+k+"' onclick='showDeliveryDateDetails(2,this,\""+i+""+k+"\");'></td>");
					br.append("</td>");						
					br.append("<TD WIDTH='24%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(1) + "</TD>");
					br.append("<TD WIDTH='5%'   colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");
					br.append("<TD WIDTH='7%'   colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(2) + "</TD>");
					br.append("<TD WIDTH='7%'   colspan='1' CLASS='multiRPTControl'>"+ ws.getString(8) + "</TD>");
					br.append("<TD WIDTH='7%'   colspan='1' CLASS='multiRPTControl'>"+ ws.getString(3) + "</TD>");
					br.append("<TD WIDTH='7%'   colspan='1' CLASS='multiRPTControl'>"+ ws.getString(4) + "</TD>");						
					br.append("<TD WIDTH='8%'   colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");
					br.append("<TD WIDTH='8%'   colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(9) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(6) + "</TD>");
					br.append("<TD WIDTH='8%'   colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"><select name='strRetActionType'  id='strRetActionTypeId"+i+""+k+"' class='comboMin' disabled ><option title='Condaminate' value='3'>Condaminate</option><option title='Other' value='5'>Other</option></select></TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"></TD>");
				    br.append("</tr>");
					count++ ;
				}
				br.append("</table>");				
				br.append("</div>");
				}
		   	}
			  br.append("</div>");
			}
			else
			{
				 
				
				     br.append("<table class='TABLEWIDTH' id='myTable' align='center' cellspacing='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				     br.append("<tr>");
				     br.append("<td WIDTH='5%'   colspan='1' class='multiRPTLabel'>#</td>");
					 br.append("<td WIDTH='24%'  colspan='1' class='multiRPTLabel'>Item Name</td>");
					 br.append("<td WIDTH='5%'  colspan='1' class='multiRPTLabel'>RC S.No.</td>");
					 br.append("<td WIDTH='7%'  colspan='1' class='multiRPTLabel'>Batch No</td>");
					 br.append("<td WIDTH='7%'  colspan='1' class='multiRPTLabel'>Mfg. Date</td>");
					 br.append("<td WIDTH='7%'  colspan='1' class='multiRPTLabel'>Expiry Date</td>");					
					 br.append("<td WIDTH='7%'  colspan='1' class='multiRPTLabel'>Total Avl Qty</td>");
						if(vo.getStrActionsId().equalsIgnoreCase("2"))
					 br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>Con. Qty</td>");
						else
					 br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>Retrun Qty</td>");	
						//br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>PO No</td>");
					 br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>Rate/Unit.</td>");
					 br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Supplied By</td>");
					 br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>Action</td>");
					 br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Remarks</td>");
					 br.append("</tr> ");
					 br.append("<input type='hidden' name='demandFlg'  value='0'>");
		           	 br.append("<tr>");  
		           	 //br.append("<td class='multiControl' colspan='10'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
		           	 br.append("</table>");
			   }
			} 
		    else
				{
					 
					 
					    br.append("<table class='TABLEWIDTH' id='myTable' align='center' cellspacing='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");
					    br.append("<tr>");
					    br.append("<td CLASS='multiLabel' colspan='1' width='5%'>Sl No.</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Supplier Name</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='20%'>PO Value(Rs.)</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Base Supplied Value(Rs.)</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Tax Value(Rs.)</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Total Supplied Value(Rs.)</td>");/*brahmam*/
					 
					    br.append("</tr>");
					    br.append("</table>");
					    br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
						br.append("<TR>");
						br.append("<td class='multiRPTControl' colspan='7'><b><div id='id' align='center' color='Red'>Expiry Drug list not found</div></b></td>");
						br.append("</TR>");
						br.append("</table> ");	          	
						
				   }
	     }
		
	catch (Exception e) {	
		 e.printStackTrace();
			throw new Exception("OffLineIssueIndentTransHLP.getScreenTwo()->"+e.getMessage());
		}
		return br.toString();
	}
	
	public static String getSuggestedExpiryList(ReplacementCondemnationOrderTransVO vo)throws Exception 
	{
		
		System.out.println("----------------------- ReplacementCondemnationOrderTransHLP.getSuggestedExpiryList --------------------------");
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		int trt=750;
		final int REC_PER_PAGE = 1000;
		final int PAGE_PER_BLOCK = 50;
		WebRowSet ws = vo.getWbSuggestedDrug();		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;		
		try
	    {
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
			    br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
			 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
			 br.append("<tr>");
			 br.append("<td class='LABEL'>");
			
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");			
			
				
			br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'   style='table-layout: fixed;word-wrap: break-word;'>");
			br.append("<tr>");
			br.append("<td WIDTH='4%'   colspan='1' class='multiRPTLabel'>#</td>");
			br.append("<td WIDTH='20%'  colspan='1' class='multiRPTLabel'>Item Name</td>");
			br.append("<td WIDTH='12%'  colspan='1' class='multiRPTLabel'>PO No</td>");
			br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Batch No</td>");			
			br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Expiry Date</td>");					
			br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Total Avl Qty</td>");
			if(vo.getStrActionsId().equalsIgnoreCase("2"))
			{
				br.append("<td WIDTH='7%'  colspan='1' class='multiRPTLabel'>Condemnation Qty</td>");	
			}else
			{
				br.append("<td WIDTH='7%'  colspan='1' class='multiRPTLabel'>Return Qty</td>");
			}
			
			br.append("<td WIDTH='8%'   colspan='1' class='multiRPTLabel'>Rate/Unit.</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Supplied By</td>");
			br.append("<td WIDTH='8%'   colspan='1' class='multiRPTLabel'>Action</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Remarks</td>");
			br.append("</tr> ");
			br.append("</table> ");
			
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
				
				br.append("<table class='TABLEWIDTH'  align='center' cellspacing='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{
						/*
						 * 1.DRUG_NAME
						 * 2.BATCH_NO
						 * 3.Exp Date
						 * 4.In Hand Qty
						 * 5.PO No
						 * 6.Supplied By
						 * 7.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_PO_NO^1^HSTNUM_SUPPLIED_BY ]
						 * 8.Mfg Date
						 * 9.Rate wth Tax (Sale Price) 
						 *10.Exp Remaining Days
						 *11.RC No 
						 * 
						 */
						
						br.append("<tr>");										
						if(!vo.getStrcatno().equalsIgnoreCase("10") && vo.getStrActionsId().equalsIgnoreCase("2"))
							br.append("<td width='4%'   colspan='1' class='multiRPTLabel' id='check"+i+""+j+"'><input type='checkbox' title='View' name='strExpiryDrugs'  id='strExpiryDrugs"+j+"'  value='"+ ws.getString(7)+"^"+ws.getString(4)+"'  onclick='chkboxEnable(this)'></td>");
						else
							br.append("<td width='4%'   colspan='1' class='multiRPTLabel' id='check"+i+""+j+"'><input type='checkbox' title='View' name='strExpiryDrugs' id='strExpiryDrugs"+j+"'  value='"+ ws.getString(7)+"^"+ws.getString(4)+"'  onclick='chkboxEnable(this)'></td>");
							br.append("</td>");						
							br.append("<TD WIDTH='20%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(1) + "</TD>");
							br.append("<TD WIDTH='12%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;color:blue;\">"+ ws.getString(5) + "</TD>");
							br.append("<TD WIDTH='7%'   colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(2) + "</TD>");						
						if(Float.parseFloat(ws.getString(10)) <= 0.00)
						    br.append("<TD WIDTH='7%'  colspan='1' CLASS='multiRPTControl' style=\"color: red;\">"+ ws.getString(3) + "</TD>");
						else
							br.append("<TD WIDTH='7%'  colspan='1' CLASS='multiRPTControl' >"+ ws.getString(3) + "</TD>");
							br.append("<TD WIDTH='7%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(4) + "</TD>");
							br.append("<TD WIDTH='7%'  colspan='1' CLASS='multiRPTControl'> <input type='text' class='txtFldNormal' style=\"text-align:right;\"  onchange=\"calRate(this,"+ws.getString(7).replace("^", "#").split("#")[1]+","+j+",'"+ws.getString(2)+"');\" name='condemqty' value='"+ws.getString(4)+"'></TD>");	
							br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:center;\">"+ ws.getString(9) + "</TD>");
							br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(6) + "</TD>");
						if(vo.getStrActionsId().equalsIgnoreCase("1"))
						{
							if(Float.parseFloat(ws.getString(10)) <= 0.00)
							{
								br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"><select id='strRetActionType"+j+"' onchange='getOtherTextBox(this)' name='strRetActionType' class='comboMin' disabled ><option title='Expiry' value='2'>Expire</option><option title='Breakage' value='1'>Breakage</option><option title='Breakage' value='4'>Non-Moving</option><option title='Breakage' value='5'>Other</option></select></TD>");
							}
							else
							{
								br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"><select id='strRetActionType"+j+"'  onchange='getOtherTextBox(this)' name='strRetActionType' class='comboMin' disabled ><option title='Breakage' value='4'>Non-Moving</option> <option title='Breakage' value='1'>Breakage</option><option title='Expiry' value='2'>Expire</option><option title='Breakage' value='5'>Other</option></select></TD>");	
							}
						
						}
						else
						{
						    br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"><select id='strRetActionType"+j+"' name='strRetActionType' class='comboMin' disabled ><option title='Condaminate' value='3'>Condaminate</option></select></TD>");	
						}	
						
						    br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'> <div id='itemRemarksDivId"+j+"' style='display:none'><input type='text' style='width: 95%;'   name='strItemRemarks' value='' ></div></TD>");
						    br.append("</tr>");
						
						count++ ;
						start++;
					}else{
						break;
					}
				}
					br.append("</table>");					
					br.append("</div>");

			} 
			else 
			{
				br.append("<div id='DivId" + i+ "' style='display:none'>");
				
				br.append("<table class='TABLEWIDTH'  align='center' cellspacing='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					
					/*
					 * 1.DRUG_NAME
					 * 2.BATCH_NO
					 * 3.Exp Date
					 * 4.In Hand Qty
					 * 5.PO No
					 * 6.Supplied By
					 * 7.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_PO_NO^1^HSTNUM_SUPPLIED_BY ]
					 * 8.Mfg Date
					 * 9.Rate wth Tax (Sale Price) 
					 *10.Exp Remaining Days
					 *11.RC No 
					 * 
					 */
					/*
					br.append("<tr>");										
					br.append("<td width='4%'   colspan='1' class='multiRPTLabel' id='check"+i+""+k+"'><input type='radio' title='View' name='strExpiryDrugs' value='"+ ws.getString(7)+"^"+ws.getString(4)+"' id='strExpiryDrugs"+i+""+k+"' onclick='showDeliveryDateDetails(2,this,\""+i+""+k+"\");'></td>");
					br.append("</td>");						
					br.append("<TD WIDTH='20%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(1) + "</TD>");
					br.append("<TD WIDTH='12%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;color:blue;\">"+ ws.getString(5) + "</TD>");
					br.append("<TD WIDTH='7%'  	colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(2) + "</TD>");					
					br.append("<TD WIDTH='7%'  	colspan='1' CLASS='multiRPTControl'>"+ ws.getString(3) + "</TD>");
					br.append("<TD WIDTH='7%'  	colspan='1' CLASS='multiRPTControl'>"+ ws.getString(4) + "</TD>");						
					br.append("<TD WIDTH='7%'  	colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");
					br.append("<TD WIDTH='8%'  	colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(9) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(6) + "</TD>");
					br.append("<TD WIDTH='8%' 	colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"><select id='strRetActionType"+i+""+k+"' onchange='getOtherTextBox(this)' name='strRetActionType' class='comboMin' disabled ><option title='Expiry' value='2'>Expire</option><option title='Breakage' value='1'>Breakage</option><option title='Breakage' value='4'>Non-Moving</option><option title='Breakage' value='5'>Other</option></select></TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'> <div id='itemRemarksDivId"+i+""+k+"' style='display:none'><input type='text' style='width: 95%;'   name='strItemRemarks' value='' ></div></TD>");
				    br.append("</tr>");
				    */
					
					br.append("<tr>");										
					if(!vo.getStrcatno().equalsIgnoreCase("10") && vo.getStrActionsId().equalsIgnoreCase("2"))
						br.append("<td width='4%'   colspan='1' class='multiRPTLabel' id='check"+i+""+k+"'><input type='checkbox' title='View' name='strExpiryDrugs'  id='strExpiryDrugs"+k+"'  value='"+ ws.getString(7)+"^"+ws.getString(4)+"'  onclick='chkboxEnable(this)'></td>");
					else
						br.append("<td width='4%'   colspan='1' class='multiRPTLabel' id='check"+i+""+k+"'><input type='checkbox' title='View' name='strExpiryDrugs' id='strExpiryDrugs"+k+"'  value='"+ ws.getString(7)+"^"+ws.getString(4)+"'  onclick='chkboxEnable(this)'></td>");
						br.append("</td>");						
						br.append("<TD WIDTH='20%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(1) + "</TD>");
						br.append("<TD WIDTH='12%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;color:blue;\">"+ ws.getString(5) + "</TD>");
						br.append("<TD WIDTH='7%'   colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(2) + "</TD>");						
					if(Float.parseFloat(ws.getString(10)) <= 0.00)
					    br.append("<TD WIDTH='7%'  colspan='1' CLASS='multiRPTControl' style=\"color: red;\">"+ ws.getString(3) + "</TD>");
					else
						br.append("<TD WIDTH='7%'  colspan='1' CLASS='multiRPTControl' >"+ ws.getString(3) + "</TD>");
						br.append("<TD WIDTH='7%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(4) + "</TD>");
						br.append("<TD WIDTH='7%'  colspan='1' CLASS='multiRPTControl'> <input type='text' class='txtFldNormal' style=\"text-align:right;\"  readonly onchange=\"calRate(this,"+ws.getString(7).replace("^", "#").split("#")[1]+","+k+",'"+ws.getString(2)+"');\" name='condemqty' value='"+ws.getString(4)+"'></TD>");	
						br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:center;\">"+ ws.getString(9) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(6) + "</TD>");
					if(vo.getStrActionsId().equalsIgnoreCase("1"))
					{
						if(Float.parseFloat(ws.getString(10)) <= 0.00)
						{
							br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"><select id='strRetActionType"+k+"' onchange='getOtherTextBox(this)' name='strRetActionType' class='comboMin' disabled ><option title='Expiry' value='2'>Expire</option><option title='Breakage' value='1'>Breakage</option><option title='Breakage' value='4'>Non-Moving</option><option title='Breakage' value='5'>Other</option></select></TD>");
						}
						else
						{
							br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"><select id='strRetActionType"+k+"'  onchange='getOtherTextBox(this)' name='strRetActionType' class='comboMin' disabled ><option title='Breakage' value='4'>Non-Moving</option> <option title='Breakage' value='1'>Breakage</option><option title='Expiry' value='2'>Expire</option><option title='Breakage' value='5'>Other</option></select></TD>");	
						}
					
					}
					else
					{
					    br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"><select id='strRetActionType"+k+"' name='strRetActionType' class='comboMin' disabled ><option title='Condaminate' value='3'>Condaminate</option></select></TD>");	
					}	
					
					    br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'> <div id='itemRemarksDivId"+k+"' style='display:none'><input type='text' style='width: 95%;'   name='strItemRemarks' value='' ></div></TD>");
					    br.append("</tr>");
					
					
					count++ ;
				}
				br.append("</table>");				
				br.append("</div>");
				}
		   	}
			  br.append("</div>");
			}
			else
			{
				 
				
				br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'   style='table-layout: fixed;word-wrap: break-word;'>");
				br.append("<tr>");
				br.append("<td WIDTH='4%'   colspan='1' class='multiRPTLabel'>#</td>");
				br.append("<td WIDTH='20%'  colspan='1' class='multiRPTLabel'>Item Name</td>");
				br.append("<td WIDTH='12%'   colspan='1' class='multiRPTLabel'>PO No</td>");
				br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Batch No</td>");				
				br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Expiry Date</td>");					
				br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Total Avl Qty</td>");
				if(vo.getStrActionsId().equalsIgnoreCase("2"))
				{
					br.append("<td WIDTH='7%'  colspan='1' class='multiRPTLabel'>Condemnation Qty</td>");	
				}else
				{
					br.append("<td WIDTH='7%'  colspan='1' class='multiRPTLabel'>Return Qty</td>");
				}
				
				br.append("<td WIDTH='8%'   colspan='1' class='multiRPTLabel'>Rate/Unit.</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Supplied By</td>");
				br.append("<td WIDTH='8%'   colspan='1' class='multiRPTLabel'>Action</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Remarks</td>");
				br.append("</tr> ");
				br.append("</table> ");
			   }
			} 
		    else
				{
					 
					 
				    	br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'   style='table-layout: fixed;word-wrap: break-word;'>");
						br.append("<tr>");
						br.append("<td WIDTH='4%'   colspan='1' class='multiRPTLabel'>#</td>");
						br.append("<td WIDTH='20%'  colspan='1' class='multiRPTLabel'>Item Name</td>");
						br.append("<td WIDTH='12%'  colspan='1' class='multiRPTLabel'>PO No</td>");
						br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Batch No</td>");						
						br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Expiry Date</td>");					
						br.append("<td WIDTH='7%'   colspan='1' class='multiRPTLabel'>Total Avl Qty</td>");
						if(vo.getStrActionsId().equalsIgnoreCase("2"))
						{
							br.append("<td WIDTH='7%'  colspan='1' class='multiRPTLabel'>Condemnation Qty</td>");	
						}else
						{
							br.append("<td WIDTH='7%'  colspan='1' class='multiRPTLabel'>Return Qty</td>");
						}
						
						br.append("<td WIDTH='8%'   colspan='1' class='multiRPTLabel'>Rate/Unit.</td>");
						br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Supplied By</td>");
						br.append("<td WIDTH='8%'   colspan='1' class='multiRPTLabel'>Action</td>");
						br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Remarks</td>");
						br.append("</tr> ");
						br.append("</table> ");         	
						
				   }
	     }
		
	catch (Exception e) {	
		 e.printStackTrace();
			throw new Exception("OffLineIssueIndentTransHLP.getScreenTwo()->"+e.getMessage());
		}
		return br.toString();
	}
	

	public static String getExpiryDrugListHLPNEW(ReplacementCondemnationOrderTransVO vo)throws Exception 
	{
		System.out.println("----------------------- ReplacementCondemnationOrderTransHLP.getExpiryDrugListHLPNEW --------------------------");
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 150;
		final int PAGE_PER_BLOCK = 50;
		WebRowSet ws = vo.getWbExpiryDrug();		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;		
		try
	    {
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
			    br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
			 br.append("<table class='table' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
			 br.append("<tr>");
			 br.append("<td class='LABEL'>");
			
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;color:blue;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");			
			
				
			br.append("<table class='table' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'   style='table-layout: fixed;word-wrap: break-word;'>");
			br.append("<tr>");
			br.append("<td WIDTH='5%'   colspan='1' class='font-weight-bold'>#</td>");
			br.append("<td WIDTH='25%'  colspan='1' class='font-weight-bold'>Drug/Item Name</td>");
			br.append("<td WIDTH='7%'  colspan='1' class='font-weight-bold'>Batch No</td>");
			br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>Mfg. Date</td>");
			br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>Expiry Date</td>");					
			br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>Total Avl Qty</td>");
			if(vo.getStrActionsId().equalsIgnoreCase("2"))
			{
			br.append("<td WIDTH='8%'  colspan='1' class='font-weight-bold'>Condemnation Qty</td>");
			}else
			{
			br.append("<td WIDTH='8%'  colspan='1' class='font-weight-bold'>Return Qty</td>");
			}
			//br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>PO No</td>");
			br.append("<td WIDTH='7%'  colspan='1' class='font-weight-bold'>Rate/Unit.</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Supplied By</td>");
			br.append("<td WIDTH='8%'  colspan='1' class='font-weight-bold'>Action</td>");
			br.append("<td WIDTH='15%'  colspan='1' class='font-weight-bold'>Remarks</td>");
			br.append("</tr> ");
			br.append("</table> ");
			
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
				
				br.append("<table class='table-striped' id='myTable' align='center' cellspacing='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{
						/*
						 * 1.DRUG_NAME
						 * 2.BATCH_NO
						 * 3.Exp Date
						 * 4.In Hand Qty
						 * 5.PO No
						 * 6.Supplied By
						 * 7.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_PO_NO^1^HSTNUM_SUPPLIED_BY ]
						 * 8. Mfg Date
						 * 9. Tender No.
						 */
						
						br.append("<tr>");
						if(vo.getStrActionsId().equalsIgnoreCase("2"))
						{
						br.append("<td width='5%'   colspan='1' class='' id='check"+i+""+j+"'><input type='checkbox' title='View' name='strExpiryDrugs' value='"+ ws.getString(7)+"^"+ws.getString(4)+"' id='strExpiryDrugs"+j+"' onclick='chkboxEnable2(this)'></td>");
						}
						else{
							br.append("<td width='5%'   colspan='1' class='' id='check"+i+""+j+"'><input type='checkbox' title='View' name='strExpiryDrugs' value='"+ ws.getString(7)+"^"+ws.getString(4)+"' id='strExpiryDrugs"+j+"'  onclick='chkboxEnable1(this)' ></td>");
						}br.append("</td>");						
						br.append("<TD WIDTH='25%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(1) + "</TD>");
						br.append("<TD WIDTH='5%'  colspan='1' CLASS='' style=\"text-align:center;\">"+ ws.getString(2) + "</TD>");
						br.append("<TD WIDTH='7%'  colspan='1' CLASS='' style=\"text-align:center;\">"+ ws.getString(8) + "</TD>");
						br.append("<TD WIDTH='5%'  colspan='1' CLASS='' style=\"text-align:center;\">"+ ws.getString(3) + "</TD>");
						br.append("<TD WIDTH='5%'  colspan='1' CLASS='=\"color: red;\" style=\"text-align:center;\">"+ ws.getString(4) + "</TD>");
						br.append("<TD WIDTH='5%'  colspan='1' CLASS=''>"+ ws.getString(4) + "</TD>");
						br.append("<input type='hidden' id='hidden"+i+"' name='totalvalue'  value='"+ws.getString(4)+"'>");
						br.append("<TD WIDTH='8%'  colspan='1' CLASS=''> <input type='text' class='txtFldNormal'  style=\"text-align:right;\"  name='condemqty' onchange=\"calRate(this,"+ws.getString(7).replace("^", "#").split("#")[1]+","+j+",'"+ws.getString(2)+"');\" onblur='chkTotalValue(this)' value='"+ws.getString(4)+"' id='condemqty"+j+"'></TD>");
							
						//br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");						
						br.append("<TD WIDTH='7%'  colspan='1' CLASS='' style=\"text-align:center;\">"+ ws.getString(9) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(6) + "</TD>");
						if(vo.getStrActionsId().equalsIgnoreCase("1"))
							br.append("<TD WIDTH='8%'  colspan='1' CLASS='' style=\"text-align:left;\"><select name='strRetActionType' onchange='getOtherTextBox1(this)' id='strRetActionType1"+j+"' class='browser-default custom-select' disabled ><option title='Breakage' value='1'>Breakage</option><option title='Expiry' value='2'>Expiry</option><option title='Other' value='5'>Other</option></select></TD>");
						else
							br.append("<TD WIDTH='8%'  colspan='1' CLASS='' style=\"text-align:left;\"><select name='strRetActionType'  id='strRetActionTypeId"+j+"' class='browser-default custom-select' disabled ><option title='Condaminate' value='3'>Condaminate</option><option title='Other' value='5'>Other</option></select></TD>");
						//br.append("<TD WIDTH='2%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"></TD>");
						br.append("<TD WIDTH='15%'  colspan='1' CLASS=''> <div id='itemRemarksDivId1"+j+"' style='display:none'><input type='text' style='width: 95%;'   name='strItemRemarks' value='' ></div></TD>");
						br.append("</tr>");
						
						count++ ;
						start++;
					}else{
						break;
					}
				}
					br.append("</table>");					
					br.append("</div>");

			} 
			else 
			{
				br.append("<div id='DivId" + i+ "' style='display:none'>");
				
				br.append("<table class='table-striped' id='myTable' align='center' cellspacing='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					
					/*
					 * 1.DRUG_NAME
					 * 2.BATCH_NO
					 * 3.Exp Date
					 * 4.In Hand Qty
					 * 5.PO No
					 * 6.Supplied By
					 * 7.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_PO_NO^1^HSTNUM_SUPPLIED_BY ]
					 */
					br.append("<tr>");										
					br.append("<td width='5%'   colspan='1' class='' id='check"+i+""+k+"'><input type='radio' title='View' name='strExpiryDrugs' value='"+ ws.getString(7)+"^"+ws.getString(4)+"' id='strExpiryDrugs"+i+""+k+"' onclick='showDeliveryDateDetails(2,this,\""+i+""+k+"\");'></td>");
					br.append("</td>");						
					br.append("<TD WIDTH='25%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(1) + "</TD>");
					br.append("<TD WIDTH='5%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(10) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(2) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS=''>"+ ws.getString(8) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS=''>"+ ws.getString(3) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS=''>"+ ws.getString(4) + "</TD>");
						
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(9) + "</TD>");
					br.append("<TD WIDTH='8%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(6) + "</TD>");
					br.append("<TD WIDTH='2%'  colspan='1' CLASS='' style=\"text-align:left;\"></TD>");
				    br.append("</tr>");
					count++ ;
				}
				br.append("</table>");				
				br.append("</div>");
				}
		   	}
			  br.append("</div>");
			}
			else
			{
				 
				
				     br.append("<table class='table' id='myTable' align='center' cellspacing='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				     br.append("<tr>");
				     br.append("<td WIDTH='5%'   colspan='1' class='font-weight-bold'>#</td>");
						br.append("<td WIDTH='25%'  colspan='1' class='font-weight-bold'>Item Name</td>");
						br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>RC No.</td>");
						br.append("<td WIDTH='7%'  colspan='1' class='font-weight-bold'>Batch No</td>");
						br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>Mfg. Date</td>");
						br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>Expiry Date</td>");					
						br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>Total Avl Qty</td>");
						if(vo.getStrActionsId().equalsIgnoreCase("2"))
						br.append("<td WIDTH='8%'  colspan='1' class='font-weight-bold'>Con. Qty</td>");
						else
						br.append("<td WIDTH='8%'  colspan='1' class='font-weight-bold'>Retrun Qty</td>");	
						//br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>PO No</td>");
						br.append("<td WIDTH='7%'  colspan='1' class='font-weight-bold'>Rate/Unit.</td>");
						br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Supplied By</td>");
					 br.append("<td WIDTH='8%'  colspan='1' class='font-weight-bold'>Action</td>");
					 br.append("<td WIDTH='15%'  colspan='1' class='font-weight-bold'>Remarks</td>");
					 br.append("</tr> ");
					 br.append("<input type='hidden' name='demandFlg'  value='0'>");
		           	 br.append("<tr>");  
		           	 br.append("<td class='' bgcolor='' colspan='12' style='text-align:center'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
		           	 br.append("</table>");
			   }
			} 
		    else
				{
					 
					 
					    br.append("<table class='table table-striped' id='myTable' align='center' cellspacing='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;width:100%'>");
					    br.append("<tr>");
					    br.append("<td CLASS='font-weight-bold' colspan='1' width='5%'>Sl No.</td>");
						br.append("<td CLASS='font-weight-bold' colspan='1' width='20%'>Supplier Name</td>");
						br.append("<td CLASS='font-weight-bold' colspan='1' width='20%'>PO Value(Rs.)</td>");
						br.append("<td CLASS='font-weight-bold' colspan='1' width='20%'>Base Supplied Value(Rs.)</td>");
						br.append("<td CLASS='font-weight-bold' colspan='1' width='15%'>Tax Value(Rs.)</td>");
						br.append("<td CLASS='font-weight-bold' colspan='1' width='20%'>Total Supplied Value(Rs.)</td>");/*brahmam*/
					 
					    br.append("</tr>");
					    //br.append("</table>");
					   // br.append("<table class='table' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
						br.append("<TR>");
						br.append("<td class='' colspan='7'><b><div id='id' align='center'><font color='red'>Expiry Drug list not found</font></div></b></td>");
						br.append("</TR>");
						br.append("</table> ");	          	
						
				   }
	     }
		
	catch (Exception e) {	
		 e.printStackTrace();
			throw new Exception("OffLineIssueIndentTransHLP.getScreenTwo()->"+e.getMessage());
		}
		return br.toString();
	}

	
	
	

	
	public static String getSuggestedExpiryListNEW(ReplacementCondemnationOrderTransVO vo)throws Exception 
	{
		
		System.out.println("----------------------- ReplacementCondemnationOrderTransHLP.getSuggestedExpiryListNEW --------------------------");
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		int trt=750;
		final int REC_PER_PAGE = 1000;
		final int PAGE_PER_BLOCK = 50;
		WebRowSet ws = vo.getWbSuggestedDrug();		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;		
		try
	    {
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
			    br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
			 br.append("<table class='table table-striped' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
			 br.append("<tr>");
			 br.append("<td class='LABEL'>");
			
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;color:blue;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");			
			
				
			br.append("<table class='table' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'   style='table-layout: fixed;word-wrap: break-word;'>");
			br.append("<tr>");
			br.append("<td WIDTH='5%'   colspan='1' class='font-weight-bold'>#</td>");
			br.append("<td WIDTH='25%'  colspan='1' class='font-weight-bold'>Item Name</td>");
			br.append("<td WIDTH='7%'  colspan='1' class='font-weight-bold'>Batch No</td>");
			br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>Mfg. Date</td>");
			br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>Expiry Date</td>");					
			br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>Total Avl Qty</td>");
			if(vo.getStrActionsId().equalsIgnoreCase("2"))
			{
				br.append("<td WIDTH='8%'  colspan='1' class='font-weight-bold'>Condemnation Qty</td>");	
			}else
			{
				br.append("<td WIDTH='8%'  colspan='1' class='font-weight-bold'>Return Qty</td>");
			}
			
			br.append("<td WIDTH='7%'  colspan='1' class='font-weight-bold'>Rate/Unit.</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Supplied By</td>");
			br.append("<td WIDTH='8%'  colspan='1' class='font-weight-bold'>Action</td>");
			br.append("<td WIDTH='15%'  colspan='1' class='font-weight-bold'>Remarks</td>");
			br.append("</tr> ");
			br.append("</table> ");
			
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
				
				br.append("<table class='table table-striped'  align='center' cellspacing='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{
						/*
						 * 1.DRUG_NAME
						 * 2.BATCH_NO
						 * 3.Exp Date
						 * 4.In Hand Qty
						 * 5.PO No
						 * 6.Supplied By
						 * 7.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_PO_NO^1^HSTNUM_SUPPLIED_BY ]
						 * 8. Mfg Date
						 * 9. Tender No.
						 */
						
						br.append("<tr>");										
						if(!vo.getStrcatno().equalsIgnoreCase("10") && vo.getStrActionsId().equalsIgnoreCase("2"))
							br.append("<td width='5%'   colspan='1' class='' id='check"+i+""+j+"'><input type='checkbox' title='View' name='strExpiryDrugs'  id='strExpiryDrugs"+j+"'  value='"+ ws.getString(7)+"^"+ws.getString(4)+"'  onclick='chkboxEnable(this)'></td>");
							else
								br.append("<td width='5%'   colspan='1' class='' id='check"+i+""+j+"'><input type='checkbox' title='View' name='strExpiryDrugs' id='strExpiryDrugs"+j+"'  value='"+ ws.getString(7)+"^"+ws.getString(4)+"'  onclick='chkboxEnable(this)'></td>");
						br.append("</td>");						
						br.append("<TD WIDTH='25%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(1) + "</TD>");
						//br.append("<TD WIDTH='5%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(9) + "</TD>");
						br.append("<TD WIDTH='7%'  colspan='1' CLASS='' style=\"text-align:center;\">"+ ws.getString(2) + "</TD>");
						br.append("<TD WIDTH='5%'  colspan='1' CLASS=''>"+ ws.getString(8) + "</TD>");
						if(Float.parseFloat(ws.getString(10)) <= 0.00)
						br.append("<TD WIDTH='5%'  colspan='1' CLASS='' style=\"color: red;\">"+ ws.getString(3) + "</TD>");
						else
							br.append("<TD WIDTH='5%'  colspan='1' CLASS='' >"+ ws.getString(3) + "</TD>");
						br.append("<TD WIDTH='5%'  colspan='1' CLASS=''>"+ ws.getString(4) + "</TD>");
						br.append("<TD WIDTH='8%'  colspan='1' CLASS=''><input type='text'  style=\"text-align:right;\" class='txtFldNormal' onchange=\"calRate(this,"+ws.getString(7).replace("^", "#").split("#")[1]+","+j+",'"+ws.getString(2)+"');\" name='condemqty' value='"+ws.getString(4)+"' '></TD>");	
						//br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");						
						br.append("<TD WIDTH='7%'  colspan='1' CLASS='' style=\"text-align:center;\">"+ ws.getString(9) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='' style=\"text-align:center;\">"+ ws.getString(6) + "</TD>");
						if(vo.getStrActionsId().equalsIgnoreCase("1"))
						{
							if(Float.parseFloat(ws.getString(10)) <= 0.00){
								br.append("<TD WIDTH='8%'  colspan='1' CLASS='' style=\"text-align:left;\"><select id='strRetActionType"+j+"' onchange='getOtherTextBox(this)' name='strRetActionType' class='browser-default custom-select' disabled ><option title='Expiry' value='2'>Expire</option><option title='Breakage' value='1'>Breakage</option><option title='Breakage' value='4'>Non-Moving</option><option title='Breakage' value='5'>Other</option></select></TD>");
							}else{
								br.append("<TD WIDTH='8%'  colspan='1' CLASS='' style=\"text-align:left;\"><select id='strRetActionType"+j+"'  onchange='getOtherTextBox(this)' name='strRetActionType' class='browser-default custom-select' disabled ><option title='Breakage' value='4'>Non-Moving</option> <option title='Breakage' value='1'>Breakage</option><option title='Expiry' value='2'>Expire</option><option title='Breakage' value='5'>Other</option></select></TD>");	
							}
						
						}
						else{
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='' style=\"text-align:left;\"><select id='strRetActionType"+j+"' name='strRetActionType' class='browser-default custom-select' disabled ><option title='Condaminate' value='3'>Condaminate</option></select></TD>");	
						}	
						//br.append("<TD WIDTH='2%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"></TD>");
						br.append("<TD WIDTH='15%'  colspan='1' CLASS=''> <div id='itemRemarksDivId"+j+"' style='display:none'><input type='text' style='width: 95%;' class='form-control'  name='strItemRemarks' value='' ></div></TD>");
						br.append("</tr>");
						
						count++ ;
						start++;
					}else{
						break;
					}
				}
					br.append("</table>");					
					br.append("</div>");
					

			} 
			else 
			{
				br.append("<div id='DivId" + i+ "' style='display:none'>");
				
				br.append("<table class='table table-striped'  align='center' cellspacing='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					
					/*
					 * 1.DRUG_NAME
					 * 2.BATCH_NO
					 * 3.Exp Date
					 * 4.In Hand Qty
					 * 5.PO No
					 * 6.Supplied By
					 * 7.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_PO_NO^1^HSTNUM_SUPPLIED_BY ]
					 */
					br.append("<tr>");										
					br.append("<td width='5%'   colspan='1' class='' id='check"+i+""+k+"'><input type='radio' title='View' name='strExpiryDrugs' value='"+ ws.getString(7)+"^"+ws.getString(4)+"' id='strExpiryDrugs"+i+""+k+"' onclick='showDeliveryDateDetails(2,this,\""+i+""+k+"\");'></td>");
					br.append("</td>");						
					br.append("<TD WIDTH='25%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(1) + "</TD>");
					br.append("<TD WIDTH='5%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(9) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(2) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS=''>"+ ws.getString(8) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS=''>"+ ws.getString(3) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS=''>"+ ws.getString(4) + "</TD>");
						
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(9) + "</TD>");
					br.append("<TD WIDTH='8%'  colspan='1' CLASS='' style=\"text-align:left;\">"+ ws.getString(6) + "</TD>");
					//br.append("<TD WIDTH='2%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\"></TD>");
				    br.append("</tr>");
					count++ ;
				}
				br.append("</table>");				
				br.append("</div>");
				}
		   	}
			  br.append("</div>");
			}
			else
			{
				 
				
					br.append("<table class='table'  align='center' cellspacing='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");
			     	br.append("<tr>");
			     	br.append("<td WIDTH='5%'   colspan='1' class='font-weight-bold'>#</td>");
					br.append("<td WIDTH='25%'  colspan='1' class='font-weight-bold'>Item Name</td>");
					br.append("<td WIDTH='25%'  colspan='1' class='font-weight-bold'>RC No.</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Batch No</td>");
					br.append("<td WIDTH='14%'  colspan='1' class='font-weight-bold'>Mfg. Date</td>");
					br.append("<td WIDTH='14%'  colspan='1' class='font-weight-bold'>Expiry Date</td>");					
					br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>Total Avl Qty</td>");
					//br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>PO No</td>");
					br.append("<td WIDTH='12%'  colspan='1' class='font-weight-bold'>Rate/Unit.</td>");
					br.append("<td WIDTH='15%'  colspan='1' class='font-weight-bold'>Supplied By</td>");
					 //br.append("<td WIDTH='2%'  colspan='1' class='multiRPTLabel'></td>");
					 br.append("</tr> ");
					 br.append("<input type='hidden' name='demandFlg'  value='0'>");
		           	 br.append("<tr>");  
		           	 br.append("<td class='' colspan='10'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
		           	br.append("</table>");
			   }
			} 
		    else
				{
					 
					 
					   br.append("<table class='TABLEWIDTH'  align='center' cellspacing='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");
					    br.append("<tr>");
					    br.append("<td CLASS='font-weight-bold' colspan='1' width='5%'>Sl No.</td>");
						br.append("<td CLASS='font-weight-bold' colspan='1' width='20%'>Supplier Name</td>");
						br.append("<td CLASS='font-weight-bold' colspan='1' width='20%'>PO Value(Rs.)</td>");
						br.append("<td CLASS='font-weight-bold' colspan='1' width='20%'>Base Supplied Value(Rs.)</td>");
						br.append("<td CLASS='font-weight-bold' colspan='1' width='15%'>Tax Value(Rs.)</td>");
						br.append("<td CLASS='font-weight-bold' colspan='1' width='20%'>Total Supplied Value(Rs.)</td>");/*brahmam*/
					 
					    br.append("</tr>");
					    br.append("</table>");
					   br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
						br.append("<TR>");
						br.append("<td class='' colspan='7'><b><div id='id' align='center' color='Red'>Expiry Drug list not found</div></b></td>");
						br.append("</TR>");
						br.append("</table> ");	          	
						
				   }
	     }
		
	catch (Exception e) {	
		 e.printStackTrace();
			throw new Exception("OffLineIssueIndentTransHLP.getScreenTwo()->"+e.getMessage());
		}
		return br.toString();
	}

	
	
	public static String getRejectedDrugListHLP(ReplacementCondemnationOrderTransVO vo)throws Exception 
	{
		System.out.println("----------------------- ReplacementCondemnationOrderTransHLP.getRejectedDrugListHLP --------------------------");
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 150;
		final int PAGE_PER_BLOCK = 50;
		WebRowSet ws = vo.getWbRejectedDrug();		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;		
		try
	    {
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
			    br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
			 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px' style='table-layout: fixed;word-wrap: break-word;'>");
			 br.append("<tr>");
			 br.append("<td class='LABEL'>");
			
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg1' id='pg1" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex1(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");	
			br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");			
			br.append("<tr>");
			br.append("<td WIDTH='5%'   colspan='1' class='multiRPTLabel'>#</td>");
			br.append("<td WIDTH='25%'  colspan='1' class='multiRPTLabel'>Item Name</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Batch No</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Manuf. Date</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Exp. Date</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Total Avl Qty</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>PO No</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Tender No.</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Supplied By</td>");
			br.append("</tr> ");
			br.append("</table> ");
			
		    for (int i = 1; i <= totalLayer; i++) 
		    {
		    	
			 if (i <= totalLayer) 
			 {
				 
				if (i == 1) 
				{
					br.append("<div id='DivId1" +i+ "' style='display:block'>");
				} 
				else
				{
					br.append("<div id='DivId1" +i+ "' style='display:none'>");
				}
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{
						/*
						 * 1.DRUG_NAME
						 * 2.BATCH_NO						 * 
						 * 3.In Hand Qty
						 * 4.PO No
						 * 5.Supplied By
						 * 6.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_PO_NO^1^HSTNUM_SUPPLIED_BY ]
						 * 7. Manuf Date
						 * 8. Exp. Date
						 * 9. Tender No.
						 */
																	
							br.append("<TR>");										
							br.append("<td width='5%'   colspan='1' class='multiRPTLabel' id='check"+i+""+j+"'><input type='radio' title='View' name='strRejectedDrugs' value='"+ ws.getString(6)+"^"+ws.getString(3)+"' id='strRejectedDrugs"+i+""+j+"' onclick='showDeliveryDateDetails(3,this,\""+i+""+j+"\");'></td>");
							br.append("</td>");						
							br.append("<TD WIDTH='25%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(1) + "</TD>");
							br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(2) + "</TD>");
							br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(7) + "</TD>");
							br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(8) + "</TD>");							
							br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(3) + "</TD>");
							br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(4) + "</TD>");
							br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(9) + "</TD>");
							br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");
							
										
							br.append("</TR>");
						
						count++ ;
						start++;
					}else{
						break;
					}
				}
					br.append("</table>");					
					br.append("</div>");

			} 
			else 
			{
				br.append("<div id='DivId1" + i+ "' style='display:none'>");
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					
					/*
					 * 1.DRUG_NAME
					 * 2.BATCH_NO						 * 
					 * 3.In Hand Qty
					 * 4.PO No
					 * 5.Supplied By
					 * 6.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_PO_NO^1^HSTNUM_SUPPLIED_BY ]
					 */
																
						br.append("<TR>");										
						br.append("<td width='5%'   colspan='1' class='multiRPTLabel' id='check"+i+""+k+"'><input type='radio' title='View' name='strRejectedDrugs' value='"+ ws.getString(6)+"^"+ws.getString(3)+"' id='strRejectedDrugs"+i+""+k+"' onclick='showDeliveryDateDetails(3,this,\""+i+""+k+"\");'></td>");
						br.append("</td>");						
						br.append("<TD WIDTH='25%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(1) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(2) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(7) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(8) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(3) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(4) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(9) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");								
						br.append("</TR>");
					count++ ;
				}
				br.append("</table>");				
				br.append("</div>");
				}
		   	}
			  br.append("</div>");
			}
			else
			{
				 
				
				br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				br.append("<tr class='TITLE'>");
				br.append("<td colspan='9'><div id='' align='left'>Rejected Drug List</div></td></tr>");
				br.append("</table> ");
				br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");			
				br.append("<tr>");
				br.append("<td WIDTH='5%'   colspan='1' class='multiRPTLabel'>#</td>");
				br.append("<td WIDTH='25%'  colspan='1' class='multiRPTLabel'>Item Name</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Batch No</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Manuf. Date</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Exp. Date</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Total Avl Qty</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>PO No</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Tender No.</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Supplied By</td>");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				br.append("<TR>");
				br.append("<td class='multiRPTControl' colspan='9'><b><div id='id' align='center' color='Red'>Rejected Drug list not found</div></b></td>");
				br.append("</TR>");
				br.append("</table> ");
			   }
			} 
		    else
				{						 
			    	br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");
					br.append("<tr class='TITLE'>");
					br.append("<td colspan='9'><div id='' align='left'>Rejected Drug List</div></td></tr>");
					br.append("</table> ");
					br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");			
					br.append("<tr>");
					br.append("<td WIDTH='5%'   colspan='1' class='multiRPTLabel'>#</td>");
					br.append("<td WIDTH='25%'  colspan='1' class='multiRPTLabel'>Item Name</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Batch No</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Manuf. Date</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Exp. Date</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Total Avl Qty</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>PO No</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Tender No.</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Supplied By</td>");
					br.append("</tr> ");
					br.append("</table> ");
					br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");
					br.append("<TR>");
					br.append("<td class='multiRPTControl' colspan='9'><b><div id='id' align='center' color='Red'>Rejected Drug list not found</div></b></td>");
					br.append("</TR>");
					br.append("</table> ");						
			   }
	     }
		
	catch (Exception e) {	
		 e.printStackTrace();
			throw new Exception("OffLineIssueIndentTransHLP.getScreenTwo()->"+e.getMessage());
		}
		return br.toString();
	}
	
	
	public static String getPopUpInfo(ReplacementCondemnationOrderTransVO vo, String index) 
	{
		
		System.out.println("----------------------- ReplacementCondemnationOrderTransHLP.getPopUpInfo --------------------------");
		
		StringBuffer br = null;
		
		String strStoreName = "";
		String Expiry = "";
		String strAvlQty = "";
		WebRowSet wb = vo.getWsStockDetails();

		try 
		{
			br  = new StringBuffer();
			

			br.append("<table width='400' align='center' cellpadding='1px' cellspacing='1px'>");
			br.append("<tr class='HEADER' align='left'><td style='cursor:pointer;cursor:pointer;font-family: Arial, Helvetica, sans-serif;font-size:13px;'>Available Stock Details </td> ");
			br.append("<td align='right'><img style='cursor: pointer; '  src='../../hisglobal/images/popUp_cancel.JPG' title='To Close PopUp Window' align='middle' onclick='hide_popup_menu(\"strStockPopUpDtls"+index+"\");'> </td></tr>");
			br.append("</tr>");
			br.append("</table> ");
			
			br.append("<table width='400' align='center' bgcolor='black'  border='0'  cellspacing ='1px'>");
			br.append("<tr>");
			br.append("<td class='multiRPTLabel' WIDTH='20%' >DDW Name</td>");
			br.append("<td class='multiRPTLabel' WIDTH='10%' >Avl Qty.</td>");
			br.append("</tr>");
			//br.append("</table> ");
			//br.append("<table width='400' align='center' bgcolor='#6097BC'  border='0'  cellspacing ='1px'>");
			
			if (wb != null && wb.size() != 0) 
			{
				while (wb.next())

				{
					
					strStoreName  = wb.getString(1);
					strAvlQty = wb.getString(2);
					Expiry   = wb.getString(3);
					

					
					if (strStoreName == null || strStoreName.equals("null"))
						strStoreName = "----";
					if (Expiry == null|| Expiry.equals("null"))
						Expiry = "----";
					if (strAvlQty == null || strAvlQty.equals("null"))
						strAvlQty = "----";
					
					br.append("<tr>");
				    br.append("<td WIDTH='20%' CLASS='multiPOControl' >"+ strStoreName  + "</td>");
					br.append("<td WIDTH='10%' CLASS='multiPOControl' >"+ strAvlQty    + "</td>");
					br.append("</tr>");
				
				}
				
				br.append("</table>");
				br.append("<table width='400' align='center'  border='0'  cellspacing ='1px'>");
				br.append("<tr class='FOOTER'><td colspan='2'></td></tr>");
				br.append("</table>");
				
			} 
			else
			{				
				br.append("<tr>");
				br.append("<td colspan='2'  CLASS='multiControl' ><DIV class='errMsg' align='center'> NO RECORD FOUND</div></td>");
				br.append("</tr>");
				br.append("</table> ");				
			}	
							

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return "ERROR";

		}
		
		return br.toString();

	}
			
	public static String getOrderScheduleDtl(ReplacementCondemnationOrderTransFB formBean , ReplacementCondemnationOrderTransVO vo)
	{
		System.out.println("----------------------- ReplacementCondemnationOrderTransHLP.getOrderScheduleDtl --------------------------");

		 StringBuffer br = new StringBuffer("");
		 StringBuffer br1 = new StringBuffer();
		 StringBuffer br2 = new StringBuffer();
		 String strJonalLocation ="", orderQty="0", acceptedQty="0", avlQty="0", replacedQty="0";
		 WebRowSet wb = null;
		 WebRowSet schQtyWs = null;
		 int remainingWidth = 0;
		 int maxScheduleNo = 0 , maxSchNoStore = 0, largestSch = 0;
		 int tableWidth = 0;
		 int count = 0;		
		 ReplacementCondemnationOrderTransBO bo=null;
		try 
		{
			bo = new ReplacementCondemnationOrderTransBO();		
				
			    br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='8%'  class='multiPOLabel'>DIVISON</td>");
				br.append("<td width='12%' class='multiPOLabel'>DDW</td>");
				remainingWidth = 80;
								
				wb =  formBean.getWsOrderScheduleDtl();	
				
				/*
				 * 1.STR_NAME
				 * 2.STR_ID
				 * 3.HSTSTR_LOCATION
				 * 4.HSTNUM_PO_NO
				 * 5.HSTNUM_ITEM_ID
				 * 6.HSTNUM_ITEMBRAND_ID
				 * 7.MAX_SCH_NO_STORE 
				 * 8.HSTSTR_BATCH_SL_NO
				 * 9.MAX_SCH_NO 
				 */
				
				
								
				if(wb != null && wb.size() > 0)
				{
					
					remainingWidth = 80;
					List list = new ArrayList();
					while(wb.next())
					{
						maxScheduleNo = Integer.parseInt(wb.getString(9));						
						list.add(maxScheduleNo);						
					}
					wb.beforeFirst();
					Collections.sort(list);					
					largestSch = (Integer) list.get(list.size()-1);	
																								
					for(int p=1; p <= largestSch; p++)
					{					
						br.append("<td CLASS='multiPOLabel' width='"+remainingWidth / largestSch +"%'>SCHEDULE("+p+")");
						br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'><tr>" +
								"<td width='25%' class='multiPOLabel'>ORDER QTY</td><td width='25%' class='multiPOLabel'>ACCEPTED QTY</td>" +
								"<td width='25%' class='multiPOLabel'>AVAILABLE QTY</td><td width='25%' class='multiPOLabel'>RPLACED QTY</td>" +
								"</tr></table></td>");				
					}
									
				}			
				
				
				int i = 0;
							
				if(wb != null && wb.size() > 0)
				{	
					
								
					List list = new ArrayList();
					while(wb.next())
					{
						maxScheduleNo = Integer.parseInt(wb.getString(9));						
						list.add(maxScheduleNo);						
					}
					wb.beforeFirst();
					Collections.sort(list);					
					largestSch = (Integer) list.get(list.size()-1);	
					
				        
					
					while(wb.next())
					{	
						maxSchNoStore = Integer.parseInt(wb.getString(7));	
					    if(i == 0)
					    {	
				          strJonalLocation = wb.getString(3);
					    }
				        if(strJonalLocation.equals(wb.getString(3)))
				        {	
						        	   
								       // Store Name (1)+DDW_ID(2)+HSTSTR_LOCATION(3)+ HSTNUM_PO_NO(4)+ HSTNUM_ITEM_ID(5) + HSTNUM_ITEMBRAND_ID(6)+MAX_SCH_NO(7)
								        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9);	
								        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
								        br.append("<tr>");
							            if(i == 0)
										{
							                br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='8%'><b>"+wb.getString(3)+"<b></td>");
										}
							            else
							            {
							            	br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='8%'></td>");
							            }
							            
										br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiPOControl'    width='12%'><b>"+wb.getString(1)+"</b></td>");
										
										br1 = new StringBuffer();
										String strApp = null;
										if(maxSchNoStore == 0)
										{	
											br1.append("<td CLASS='multiPOControl' width='"+remainingWidth/largestSch+"%'>NA</td>");
											/*br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'><input type='hidden' name='strAcceptedQty' id='strAcceptedQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='0'><img style='cursor: pointer' src='../../hisglobal/images/FrStopAutoHide.png' title='Compile Data'/></td>");
											br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'><input type='hidden' name='strAvlQty' id='strAvlQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='0'><img style='cursor: pointer' src='../../hisglobal/images/FrStopAutoHide.png' title='Compile Data'/></td>");
											br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'><input type='hidden' name='strReplacedQty' id='strReplacedQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='0'><img style='cursor: pointer' src='../../hisglobal/images/FrStopAutoHide.png' title='Compile Data'/></td>");*/
										}
										
										for(int p=1; p <= maxSchNoStore; p++)
										{	
											/*
											 * 1.STR_NAME
											 * 2.STR_ID
											 * 3.HSTSTR_LOCATION
											 * 4.HSTNUM_PO_NO
											 * 5.HSTNUM_ITEM_ID
											 * 6.HSTNUM_ITEMBRAND_ID
											 * 7.MAX_SCH_NO_STORE 
											 * 8.HSTSTR_BATCH_SL_NO
											 * 9.MAX_SCH_NO 
											 */
											
											
											// Calling BO Method
											bo.getScheduleQtyDtl(wb.getString(2),wb.getString(4),wb.getString(5),wb.getString(6),wb.getString(8),p,vo);
											schQtyWs = vo.getWsScheduleQty();
											if(schQtyWs.size() == 0)
											{	
												br1.append("<td CLASS='multiPOControl' width='"+remainingWidth/largestSch+"%'>NA</td>");
												/*br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'><input type='hidden' name='strAcceptedQty' id='strAcceptedQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='0'><img style='cursor: pointer' src='../../hisglobal/images/FrStopAutoHide.png' title='Compile Data'/></td>");
												br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'><input type='hidden' name='strAvlQty' id='strAvlQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='0'><img style='cursor: pointer' src='../../hisglobal/images/FrStopAutoHide.png' title='Compile Data'/></td>");
												br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'><input type='hidden' name='strReplacedQty' id='strReplacedQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='0'><img style='cursor: pointer' src='../../hisglobal/images/FrStopAutoHide.png' title='Compile Data'/></td>");*/
											}
											else
											{   
												while(schQtyWs.next())
												{
													orderQty = schQtyWs.getString(1);
													acceptedQty = schQtyWs.getString(2);
													avlQty = schQtyWs.getString(3);
													replacedQty = avlQty;
													br1.append("<td CLASS='Approved' width='"+remainingWidth/4+"%'>");
													br1.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'><tr>");													
													br1.append("<td CLASS='Approved' width='"+remainingWidth/4+"%'><input type='text' name='strOrderQty' id='strOrderQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='"+orderQty+"' ></td>");
												    br1.append("<td CLASS='Approved' width='"+remainingWidth/4+"%'><input type='text' name='strAcceptedQty' id='strAcceptedQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='"+acceptedQty+"' ></td>");
													br1.append("<td CLASS='Approved' width='"+remainingWidth/4+"%'><input type='text' name='strAvlQty' id='strAvlQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='"+avlQty+"' ></td>");
													br1.append("<td CLASS='Approved' width='"+remainingWidth/4+"%'><input type='text' name='strReplacedQty' id='strReplacedQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='"+replacedQty+"' ></td>");
													br1.append("</tr></table></td>");
												}
											}
																							
											
											//br1.append("<input type='hidden'    name='strDynamicPrgId'  id='strDynamicPrgId"+i+"-"+p+"' value='"+strSchedule.split("\\^")[p]+"'>");
											
										}  
										br.append("<input type='hidden'    name='strCombindeVal'   id='strCombindeVal"+i+"' value='"+strApp+"'>");
											
										br2 = new StringBuffer();
										
									    br.append(br1).append(br2);										
										br.append("</tr>");	
										/*br.append("<td  name='td10' id='td150"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(7)+"</td>");// 90 Days Consumption Qty
										br.append("<td  name='td10' id='td160"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(6)+"</td>");// Short/Excess Qty
										
										br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(2)+"</td>");										
										br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(3)+"</td>");
										br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(3)+"</td>");
										br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(4)+"</td>");
										br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(7)+"</td>");
										br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(5)+"</td>");								
										br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(5)+"</td>");
										br.append("<td  name='td10' id='td90"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(6)+"</td>");								
										br.append("<td  name='td10' id='td110"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='8%'>"+wb.getString(6)+"</td>");
										if(formBean.getStrMode().equals("2"))
									  	{
											br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onBlur='POUtilityFunction("+i+");' value="+wb.getString(7)+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");	
										//br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onKeyUp='getValueofOrderQty("+i+");' value="+wb.getString(7).split("\\#")[0]+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
										    br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='8%'><input type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+wb.getString(7)+"></td>");
									  	}
										else
										{
											br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onBlur='POUtilityFunction("+i+");' class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
											//br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onKeyUp='getValueofOrderQty("+i+");' value='0' class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
											br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='8%'><input type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value='0'></td>");
								
										}							
								  	    br.append("</tr>");  */
								  	    
						        }
						        else
						        {
						        	strJonalLocation = wb.getString(3);
						        	
							        String strPODetailsHidValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3)+"^"+wb.getString(4)+"^"+wb.getString(5)+"^"+wb.getString(6)+"^"+wb.getString(7)+"^"+wb.getString(8)+"^"+wb.getString(9);	
							        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
							        br.append("<tr>");
						            br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='8%'><b>"+wb.getString(3)+"<b></td>");
									br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiPOControl'    width='12%'><b>"+wb.getString(1)+"</b></td>");
									
									br1 = new StringBuffer();
									String strApp = null;
									if(maxSchNoStore == 0)
									{	
										br1.append("<td CLASS='multiPOControl' width='"+remainingWidth/largestSch+"%'>NA</td>");
										/*br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'><input type='hidden' name='strAcceptedQty' id='strAcceptedQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='0'><img style='cursor: pointer' src='../../hisglobal/images/FrStopAutoHide.png' title='Compile Data'/></td>");
										br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'><input type='hidden' name='strAvlQty' id='strAvlQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='0'><img style='cursor: pointer' src='../../hisglobal/images/FrStopAutoHide.png' title='Compile Data'/></td>");
										br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'><input type='hidden' name='strReplacedQty' id='strReplacedQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='0'><img style='cursor: pointer' src='../../hisglobal/images/FrStopAutoHide.png' title='Compile Data'/></td>");*/
									}
									for(int p=1; p <= maxSchNoStore; p++)
									{	
										// Calling BO Method
										bo.getScheduleQtyDtl(wb.getString(2),wb.getString(4),wb.getString(5),wb.getString(6),wb.getString(8),p,vo);
										schQtyWs = vo.getWsScheduleQty();
										if(schQtyWs.size() == 0)
										{	
											br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'>NA</td>");
											/*br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'><input type='hidden' name='strAcceptedQty' id='strAcceptedQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='0'><img style='cursor: pointer' src='../../hisglobal/images/FrStopAutoHide.png' title='Compile Data'/></td>");
											br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'><input type='hidden' name='strAvlQty' id='strAvlQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='0'><img style='cursor: pointer' src='../../hisglobal/images/FrStopAutoHide.png' title='Compile Data'/></td>");
											br1.append("<td CLASS='multiPOControl' colspan='1'     width='"+remainingWidth/maxScheduleNo+"%'><input type='hidden' name='strReplacedQty' id='strReplacedQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='0'><img style='cursor: pointer' src='../../hisglobal/images/FrStopAutoHide.png' title='Compile Data'/></td>");*/
										}
										else
										{   
											while(schQtyWs.next())
											{
												orderQty = schQtyWs.getString(1);
												acceptedQty = schQtyWs.getString(2);
												avlQty = schQtyWs.getString(3);
												replacedQty = avlQty;
												br1.append("<td CLASS='Approved' width='"+remainingWidth/4+"%'>");
												br1.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'><tr>");													
												br1.append("<td CLASS='Approved' width='"+remainingWidth/4+"%'><input type='text' name='strOrderQty' id='strOrderQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='"+orderQty+"' ></td>");
											    br1.append("<td CLASS='Approved' width='"+remainingWidth/4+"%'><input type='text' name='strAcceptedQty' id='strAcceptedQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='"+acceptedQty+"' ></td>");
												br1.append("<td CLASS='Approved' width='"+remainingWidth/4+"%'><input type='text' name='strAvlQty' id='strAvlQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='"+avlQty+"' ></td>");
												br1.append("<td CLASS='Approved' width='"+remainingWidth/4+"%'><input type='text' name='strReplacedQty' id='strReplacedQty"+i+"-"+p+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='"+replacedQty+"' ></td>");
												br1.append("</tr></table></td>");												
											}
											
										}
																						
										
										//br1.append("<input type='hidden'    name='strDynamicPrgId'  id='strDynamicPrgId"+i+"-"+p+"' value='"+strSchedule.split("\\^")[p]+"'>");
										
									}  
									br.append("<input type='hidden'    name='strCombindeVal'   id='strCombindeVal"+i+"' value='"+strApp+"'>");
										
									br2 = new StringBuffer();									
									br.append(br1).append(br2);									
									br.append("</tr>");	
									/*br.append("<td  name='td10' id='td150"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(7)+"</td>");// 90 Days Consumption Qty
									br.append("<td  name='td10' id='td160"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(6)+"</td>");// Short/Excess Qty
									
									br.append("<td  name='td10' id='td20"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(2)+"</td>");									
									br.append("<td  name='td10' id='td30"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(3)+"</td>");
									br.append("<td  name='td10' id='td40"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(3)+"</td>");
									br.append("<td  name='td10' id='td50"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(4)+"</td>");
									br.append("<td  name='td10' id='td60"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(7)+"</td>");
									br.append("<td  name='td10' id='td70"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(5)+"</td>");								
									br.append("<td  name='td10' id='td80"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(5)+"</td>");
									br.append("<td  name='td10' id='td90"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='7%'>"+wb.getString(6)+"</td>");								
									br.append("<td  name='td10' id='td110"+i+"'  style=\"text-align: center;\"  class='multiPOControl'  width='8%'>"+wb.getString(6)+"</td>");
									if(formBean.getStrMode().equals("2"))
								  	{
										br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onBlur='POUtilityFunction("+i+");' value="+wb.getString(7)+" class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");	
									    br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='8%'><input type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value="+wb.getString(7)+"></td>");
								  	}
									else
									{
										br.append("<td  name='td10' id='td120"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='10%'><input type='text' name='strQrderQty' id='strQrderQty"+i+"' onBlur='POUtilityFunction("+i+");' class='txtFldNormal' maxlength ='8' onkeypress='return validateData(event,7);'></td>");
									    br.append("<td  name='td10' id='td130"+i+"' style=\"text-align: center;\"  class='multiPOControl'  width='8%'><input type='text' name='strOrdeCost' id='strOrdeCost"+i+"' class='txtFldNormal' disabled='disabled' value='0'></td>");
							
									}							
							  	    br.append("</tr>");  */
							  	    count++;
						        	
						        	
						        	
						        }						        
							  					  	    
					            i=i+1;					     
				   }
				}
				
				
				br.append("<tr>");			
				br.append("<td colspan='1'  class='multiRPTLabel'></td>");
				br.append("</tr>");				
				br.append("</table>");
				
				
			
		} 
		catch (Exception _e) 
		{
			_e.printStackTrace();
			formBean.setStrMsg("ReplacementCondemnationOrderTransHLP.getOrderScheduleDtl() --> "+ _e.getMessage());
			formBean.setStrMsgType("1");
		}
		return br.toString();
		
	}
	
	public static String getOrderScheduleDtlTWO(ReplacementCondemnationOrderTransFB formBean , ReplacementCondemnationOrderTransVO vo)
	{

		System.out.println("----------------------- ReplacementCondemnationOrderTransHLP.getOrderScheduleDtlTWO --------------------------");
		
		 StringBuffer br = new StringBuffer("");
		 StringBuffer br1 = new StringBuffer();
		 StringBuffer br2 = new StringBuffer();
		 String strJonalLocation ="", orderQty="0", acceptedQty="0", avlQty="0", replacedQty="0";
		 String nosqQty[] = {""};
		 WebRowSet wb = null;
		 int remainingWidth = 0;
		 int maxScheduleNo = 0 , maxSchNoStore = 0, largestSch = 0;
		 int tableWidth = 0;
		 int count = 0;			
		try 
		{			
				
			    br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'>");
				br.append("<tr>");
				br.append("<td width='8%'  class='multiPOLabel'>DIVISON</td>");
				br.append("<td width='12%' class='multiPOLabel'>DDW</td>");
				remainingWidth = 80;
								
				wb =  formBean.getWsOrderScheduleDtl();	
				
				/*
				 * 1.STR_NAME
				 * 2.STR_ID
				 * 3.HSTSTR_LOCATION
				 * 4.HSTNUM_PO_NO
				 * 5.HSTNUM_ITEM_ID
				 * 6.HSTNUM_ITEMBRAND_ID
				 * 7.MAX_SCH_NO_STORE 
				 * 8.HSTSTR_BATCH_SL_NO
				 * 9.MAX_SCH_NO 
				 * 10.DEMAND_YEAR
				 * 11.NOSQ_QTY [(sch 1-order_qty^accepted_qty)#(sch 2-order_qty^accepted_qty)#(sch 3-order_qty^accepted_qty) and so on]
				 * 
				 */
				
				
								
				if(wb != null && wb.size() > 0)
				{
					
					remainingWidth = 80;
					List list = new ArrayList();
					while(wb.next())
					{
						maxScheduleNo = Integer.parseInt(wb.getString(9));						
						list.add(maxScheduleNo);						
					}
					wb.beforeFirst();
					Collections.sort(list);					
					largestSch = (Integer) list.get(list.size()-1);	
																								
					for(int p=1; p <= largestSch; p++)
					{					
						br.append("<td CLASS='multiPOLabel' width='"+remainingWidth / largestSch +"%'>SCHEDULE("+p+")");
						br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'><tr>" +
								"<td width='25%' class='multiPOLabel'>ORDER QTY</td><td width='25%' class='multiPOLabel'>ACCEPTED QTY</td>" +
								"<td width='25%' class='multiPOLabel'>AVAILABLE QTY</td><td width='25%' class='multiPOLabel'>RPLACED QTY</td>" +
								"</tr></table></td>");				
					}
									
				}			
				
				
				int i = 0;
							
				if(wb != null && wb.size() > 0)
				{	
					
								
					List list = new ArrayList();
					while(wb.next())
					{
						maxScheduleNo = Integer.parseInt(wb.getString(9));						
						list.add(maxScheduleNo);						
					}
					wb.beforeFirst();
					Collections.sort(list);					
					largestSch = (Integer) list.get(list.size()-1);	
					
				        
					
					while(wb.next())
					{	
						maxSchNoStore = Integer.parseInt(wb.getString(7));	
					    if(i == 0)
					    {	
				          strJonalLocation = wb.getString(3);
					    }
				        if(strJonalLocation.equals(wb.getString(3)))
				        {	
						        	   
					       // STR_NAME(1)+DDW_ID(2)+HSTSTR_LOCATION(3)+ HSTNUM_PO_NO(4)+ HSTNUM_ITEM_ID(5) + HSTNUM_ITEMBRAND_ID(6)+MAX_SCH_NO_STORE(7)+HSTSTR_BATCH_SL_NO(8)+MAX_SCH_NO(9)+DEMAND_YEAR(10)+ NOSQ_QTY(11)[(sch 1-order_qty^accepted_qty)#(sch 2-order_qty^accepted_qty)#(sch 3-order_qty^accepted_qty) and so on]
					        String strPODetailsHidValue = wb.getString(1)+"$"+wb.getString(2)+"$"+wb.getString(3)+"$"+wb.getString(4)+"$"+wb.getString(5)+"$"+wb.getString(6)+"$"+wb.getString(7)+"$"+wb.getString(8)+"$"+wb.getString(9)+"$"+wb.getString(10)+"$"+wb.getString(11);	
					        String strQtySchHidValue = "0";
					        br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
					       
					        br.append("<tr>");
				            if(i == 0)
							{
				                br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='8%'><b>"+wb.getString(3)+"<b></td>");
							}
				            else
				            {
				            	br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='8%'></td>");
				            }
				            
							br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiPOControl'    width='12%'><b>"+wb.getString(1)+"</b></td>");
							
							br1 = new StringBuffer();
							for(int p=0; p < largestSch; p++)
							{
								if(maxSchNoStore == 0)
								{	
									br1.append("<td CLASS='multiPOControl' width='"+remainingWidth/largestSch+"%'>NA</td>");												
								}
							}							
										
									/*
									 * 1.STR_NAME
									 * 2.STR_ID
									 * 3.HSTSTR_LOCATION
									 * 4.HSTNUM_PO_NO
									 * 5.HSTNUM_ITEM_ID
									 * 6.HSTNUM_ITEMBRAND_ID
									 * 7.MAX_SCH_NO_STORE 
									 * 8.HSTSTR_BATCH_SL_NO
									 * 9.MAX_SCH_NO
									 * 10.DEMAND_YEAR 
									 * 11.NOSQ_QTY [(sch 1-order_qty^accepted_qty^avl Qty)#(sch 2-order_qty^accepted_qty^avl Qty)#(sch 3-order_qty^accepted_qty^avl Qty) and so on]
									 * 
									 */							
														
							String strTemp="";	    
							for(int p=0; p < largestSch; p++)
							{												
								if(wb.getString(11).equals("NA"))
								{	
									br1.append("<td CLASS='multiPOControl'  width='"+remainingWidth/largestSch+"%'>NA</td>");										
								}
								else
								{ 
									nosqQty = wb.getString(11).split("#");
									if(p < nosqQty.length)
									{
										if(!nosqQty[p].equals("NA"))
										{
											orderQty = nosqQty[p].split("\\^")[0];
											acceptedQty = nosqQty[p].split("\\^")[1];
											avlQty = nosqQty[p].split("\\^")[2];
											replacedQty = acceptedQty;
											
											br1.append("<td CLASS='Approved' width='"+remainingWidth/largestSch+"%'>");
											br1.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'><tr>");													
											br1.append("<td CLASS='Approved' width='"+(remainingWidth/maxSchNoStore)/4+"%'><input type='text' name='strOrderQty' id='strOrderQty"+i+"-"+(p+1)+"'  class='txtFldMin' maxlength ='9' value='"+orderQty+"' readOnly='true'></td>");
										    br1.append("<td CLASS='Approved' width='"+(remainingWidth/maxSchNoStore)/4+"%'><input type='text' name='strAcceptedQty' id='strAcceptedQty"+i+"-"+(p+1)+"'  class='txtFldMin' maxlength ='9' value='"+acceptedQty+"' readOnly='true'></td>");
											br1.append("<td CLASS='Approved' width='"+(remainingWidth/maxSchNoStore)/4+"%'><input type='text' name='strAvlQty' id='strAvlQty"+i+"-"+(p+1)+"'  class='txtFldMin' maxlength ='9' value='"+avlQty+"' readOnly='true'></td>");
											br1.append("<td CLASS='Approved' width='"+(remainingWidth/maxSchNoStore)/4+"%'><input type='text' name='strReplacedQty' id='strReplacedQty"+i+"-"+(p+1)+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='"+replacedQty+"' onblur='return validateQty(this , \""+ i+ "-"+ (p+1)+ "\");'></td>");  //onblur='setReplacedQty(this , \""+ i+ "-"+ (p+1)+ "\");' 
											br1.append("</tr></table></td>");	
											
											if(p==0)
							   				{
							   					strTemp = strTemp + replacedQty+'^'+""+(p+1)+"";
							   				}		   				 	
							   				else
							   				{						   				 	
							   				 	strTemp = strTemp +'#'+ replacedQty+'^'+""+(p+1)+"";
							   				}
										}
										else
										{
											br1.append("<td CLASS='multiPOControl'  width='"+remainingWidth/largestSch+"%'>NA</td>");			
										}	
										
									}
									else
									{
										br1.append("<td CLASS='multiPOControl'  width='"+remainingWidth/largestSch+"%'>NA</td>");			
									}	
																			
								}												
							} 
							
							strQtySchHidValue = strTemp; 
							//System.out.println("strQtySchHidValue: "+strQtySchHidValue);
							
							br2 = new StringBuffer();
							
						    br.append(br1).append(br2);										
							br.append("</tr>");	
							br.append("<input type='hidden' name='strQtySchHidValue' id='strQtySchHidValue"+i+"' value='"+strQtySchHidValue+"'>");
								
				        }
				        else
				        {
				        	strJonalLocation = wb.getString(3);
				        	
				        	String strPODetailsHidValue = wb.getString(1)+"$"+wb.getString(2)+"$"+wb.getString(3)+"$"+wb.getString(4)+"$"+wb.getString(5)+"$"+wb.getString(6)+"$"+wb.getString(7)+"$"+wb.getString(8)+"$"+wb.getString(9)+"$"+wb.getString(10)+"$"+wb.getString(11);	
				        	String strQtySchHidValue = "0";
				        	br.append("<input type='hidden' name='strPODetailsHidValue' id='strPODetailsHidValue"+i+"' value='"+strPODetailsHidValue+"'>");
				        	
					        br.append("<tr>");
				            br.append("<td  name='td10' id='td140"+i+"' style=\"text-align: right;\"   class='multiRPTLabel'  width='8%'><b>"+wb.getString(3)+"<b></td>");
							br.append("<td  name='td10' id='td10"+i+"'  style=\"text-align: left;\"    class='multiPOControl'    width='12%'><b>"+wb.getString(1)+"</b></td>");
							
							br1 = new StringBuffer();
							for(int p=0; p < largestSch; p++)
							{
								if(maxSchNoStore == 0)
								{	
									br1.append("<td CLASS='multiPOControl' width='"+remainingWidth/largestSch+"%'>NA</td>");									
								}
							}
														
							String strTemp="";
							for(int p=0; p < largestSch; p++)
							{								
								
								if(wb.getString(11).equals("NA"))
								{	
									br1.append("<td CLASS='multiPOControl' width='"+remainingWidth/largestSch+"%'>NA</td>");									
								}
								else
								{ 
									nosqQty = wb.getString(11).split("#");	
									if(p < nosqQty.length)
									{
										if(!nosqQty[p].equals("NA"))
										{
											orderQty = nosqQty[p].split("\\^")[0];
											acceptedQty = nosqQty[p].split("\\^")[1];
											avlQty = nosqQty[p].split("\\^")[2];
											replacedQty = acceptedQty;												
																								
											br1.append("<td CLASS='Approved' width='"+remainingWidth/largestSch+"%'>");
											br1.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' cellspacing='1px'><tr>");													
											br1.append("<td CLASS='Approved' width='"+(remainingWidth/maxSchNoStore)/4+"%'><input type='text' name='strOrderQty' id='strOrderQty"+i+"-"+(p+1)+"'  class='txtFldMin' maxlength ='9' value='"+orderQty+"' readOnly='true'></td>");
										    br1.append("<td CLASS='Approved' width='"+(remainingWidth/maxSchNoStore)/4+"%'><input type='text' name='strAcceptedQty' id='strAcceptedQty"+i+"-"+(p+1)+"'  class='txtFldMin' maxlength ='9' value='"+acceptedQty+"' readOnly='true'></td>");
											br1.append("<td CLASS='Approved' width='"+(remainingWidth/maxSchNoStore)/4+"%'><input type='text' name='strAvlQty' id='strAvlQty"+i+"-"+(p+1)+"'  class='txtFldMin' maxlength ='9' value='"+avlQty+"' readOnly='true'></td>");
											br1.append("<td CLASS='Approved' width='"+(remainingWidth/maxSchNoStore)/4+"%'><input type='text' name='strReplacedQty' id='strReplacedQty"+i+"-"+(p+1)+"'  class='txtFldMin' maxlength ='9' onkeypress='return validateData(event,5);' value='"+replacedQty+"'  onblur='return validateQty(this , \""+ i+ "-"+ (p+1)+ "\");'></td>"); //onblur='setReplacedQty(this , \""+ i+ "-"+ (p+1)+ "\");'
											br1.append("</tr></table></td>");
											
											if(p==0)
							   				{
							   					strTemp = strTemp + replacedQty+'^'+""+(p+1)+"";
							   				}		   				 	
							   				else
							   				{						   				 	
							   				 	strTemp = strTemp +'#'+ replacedQty+'^'+""+(p+1)+"";
							   				}
										}
										else
										{
											br1.append("<td CLASS='multiPOControl'  width='"+remainingWidth/largestSch+"%'>NA</td>");			
										}
									}
									else
									{
										br1.append("<td CLASS='multiPOControl'  width='"+remainingWidth/largestSch+"%'>NA</td>");			
									}
								}											
							}	
							
							strQtySchHidValue = strTemp; 
							//System.out.println("strQtySchHidValue: "+strQtySchHidValue);
							br2 = new StringBuffer();									
							br.append(br1).append(br2);									
							br.append("</tr>");	
							br.append("<input type='hidden' name='strQtySchHidValue' id='strQtySchHidValue"+i+"' value='"+strQtySchHidValue+"'>");
							
					  	    count++;				        	
				        }
				        i=i+1;
				     }
				  
				}
				
				
				br.append("<tr>");			
				br.append("<td colspan='1'  class='multiRPTLabel'></td>");
				br.append("</tr>");				
				br.append("</table>");
				
				
			
		} 
		catch (Exception _e) 
		{
			_e.printStackTrace();
			formBean.setStrMsg("ReplacementCondemnationOrderTransHLP.getOrderScheduleDtlTWO() --> "+ _e.getMessage());
			formBean.setStrMsgType("1");
		}
		return br.toString();		
	}

	
	public static String getregularindentdruglistHLP(ReplacementCondemnationOrderTransVO vo)throws Exception 
	{
		System.out.println("----------------------- ReplacementCondemnationOrderTransHLP.getregularindentdruglistHLP --------------------------");
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 150;
		final int PAGE_PER_BLOCK = 50;
		WebRowSet ws = vo.getWsRegularIndentDrugs();		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;		
		try
	    {
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
			    br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
			 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
			 br.append("<tr>");
			 br.append("<td class='LABEL'>");
			
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");			
			
				
			br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'   style='table-layout: fixed;word-wrap: break-word;'>");
			br.append("<tr>");
			br.append("<td WIDTH='5%'   colspan='1' class='multiRPTLabel'>#</td>");
			br.append("<td WIDTH='25%'  colspan='1' class='multiRPTLabel'>Item Name</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Indent No</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>CR.No</td>");
			br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Requested Qty</td>");					
		//	br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Total Avl Qty</td>");
			//br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>PO No</td>");
			//br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Tender No.</td>");
			//br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Supplied By</td>");
			br.append("</tr> ");
			br.append("</table> ");
			
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
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{
						/*
						 * 1.DRUG_NAME
						 * 2.BATCH_NO
						 * 3.Exp Date
						 * 4.In Hand Qty
						 * 5.PO No
						 * 6.Supplied By
						 * 7.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_PO_NO^1^HSTNUM_SUPPLIED_BY ]
						 * 8. Mfg Date
						 * 9. Tender No.
						 */
						
						br.append("<tr>");										
						br.append("<td width='5%'   colspan='1' class='multiRPTLabel' id='check"+i+""+j+"'><input type='radio' title='View' name='strIndentedDrugs' value='"+ ws.getString(1)+"^"+ws.getString(2)+"^"+ ws.getString(3)+"^"+ ws.getString(4)+"^"+ ws.getString(5)+"^"+ ws.getString(6)+"^"+ ws.getString(10)+"' id='strIndentedDrugs"+i+""+j+"' onclick='showDeliveryDateDetails(4,this,\""+i+""+j+ "\");'></td>");
						br.append("</td>");						
						br.append("<TD WIDTH='25%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(9) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(7) + "</TD>");
					//	br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(8) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(8) + "</TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(10) + "</TD>");
							
					//	br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");						
					//	br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(9) + "</TD>");
					//	br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(6) + "</TD>");
					    br.append("</tr>");
						
						count++ ;
						start++;
					}else{
						break;
					}
				}
					br.append("</table>");					
					br.append("</div>");

			} 
			else 
			{
				br.append("<div id='DivId" + i+ "' style='display:none'>");
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					
					/*
					 * 1.DRUG_NAME
					 * 2.BATCH_NO
					 * 3.Exp Date
					 * 4.In Hand Qty
					 * 5.PO No
					 * 6.Supplied By
					 * 7.Hidden Value[ HSTNUM_ITEM_ID^HSTNUM_ITEMBRAND_ID^HSTSTR_BATCH_NO^HSTNUM_PO_NO^1^HSTNUM_SUPPLIED_BY ]
					 */
					br.append("<tr>");										
					br.append("<td width='5%'   colspan='1' class='multiRPTLabel' id='check"+i+""+k+"'><input type='radio' title='View' name='strIndentedDrugs' value='"+ ws.getString(1)+"^"+ws.getString(2)+"^"+ ws.getString(3)+"^"+ ws.getString(4)+"^"+ ws.getString(5)+"^"+ ws.getString(6)+"^"+ ws.getString(10)+"'id='strIndentedDrugs"+i+""+k+"' onclick='showDeliveryDateDetails(4,this,\""+i+""+k+"\");'></td>");
					br.append("</td>");						
					br.append("<TD WIDTH='25%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(9) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(7) + "</TD>");
				//	br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(8) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(8) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl'>"+ ws.getString(10) + "</TD>");
							
					//br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(5) + "</TD>");
					///br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(9) + "</TD>");
					//br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiRPTControl' style=\"text-align:left;\">"+ ws.getString(6) + "</TD>");
				    br.append("</tr>");
					count++ ;
				}
				br.append("</table>");				
				br.append("</div>");
				}
		   	}
			  br.append("</div>");
			}
			else
			{
				 
				
				     br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");
				     br.append("<tr>");
					 br.append("<td WIDTH='5%'   colspan='1' class='multiRPTLabel'>#</td>");
					 br.append("<td WIDTH='25%'  colspan='1' class='multiRPTLabel'>Item Name</td>");
					 br.append("<td WIDTH='19%'  colspan='1' class='multiRPTLabel'>Indent No</td>");
					 br.append("<td WIDTH='19%'  colspan='1' class='multiRPTLabel'>CR No.</td>");
					 br.append("<td WIDTH='19%'  colspan='1' class='multiRPTLabel'>Expiry Date</td>");					
					 br.append("<td WIDTH='19%'  colspan='1' class='multiRPTLabel'>Requested Qty</td>");
				     //br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>PO No</td>");
				    //br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Tender No.</td>");
					// br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Supplied By</td>");
					 br.append("</tr> ");
					 br.append("<input type='hidden' name='demandFlg'  value='0'>");
		           	 br.append("<tr>");  
		           	 br.append("<td class='multiControl' colspan='9'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
		           	 br.append("</table>");
			   }
			} 
		    else
				{
					 
					 
					    br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px' style='table-layout: fixed;word-wrap: break-word;'>");
					    br.append("<tr>");
					    br.append("<td CLASS='multiLabel' colspan='1' width='5%'>Sl No.</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Supplier Name</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='20%'>PO Value(Rs.)</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Base Supplied Value(Rs.)</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Tax Value(Rs.)</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Total Supplied Value(Rs.)</td>");/*brahmam*/
					 
					    br.append("</tr>");
					    br.append("</table>");
					    br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
						br.append("<TR>");
						br.append("<td class='multiRPTControl' colspan='7'><b><div id='id' align='center' color='Red'>Expiry Drug list not found</div></b></td>");
						br.append("</TR>");
						br.append("</table> ");	          	
						
				   }
	     }
		
	catch (Exception e) {	
		 e.printStackTrace();
			throw new Exception("OffLineIssueIndentTransHLP.getScreenTwo()->"+e.getMessage());
		}
		return br.toString();
	}
	
	
}
