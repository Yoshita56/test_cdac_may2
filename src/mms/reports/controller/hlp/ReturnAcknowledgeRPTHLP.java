package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.controller.fb.ReturnAcknowledgeRPTFB;
import mms.reports.vo.ReturnAcknowledgeRPTVO;

public class ReturnAcknowledgeRPTHLP {


public static String getReplacementDetails(ReturnAcknowledgeRPTFB fb,ReturnAcknowledgeRPTVO vo) 
{
	StringBuffer sb = new StringBuffer("");

	WebRowSet ws = vo.getWsItemCategoryCombo();
	int i=1;
	double totamt = 0.0;
	try
    {
	if (ws != null) 
	{
		sb.append("<div id='printRptId' align='right'><img style='cursor: pointer; margin-right :10px;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printReport();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='controlToMainPage();' /></div></td>");

		sb.append("<div class='d-flex justify-content-center align-items-center'>"
		        //+ " <div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></div>");
				+ " <div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></div>");
	
		sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
				"<tr> "
				+ " <td colspan='3'></td>"
				+"<td colspan='3' align='center' style='font-size:18px;font-weight:normal;font face:Verdana, Arial, Helvetica, sans-serif'>Return Acknowledge Report</td>"
				+ " <td colspan='3'></td>");
		sb.append("</tr>");
		
		sb.append(" <tr><td align='center' colspan='3'></td> " +
		  "<td align='center' colspan='3'>" +
		  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
		  "Returning Store::<b>"+vo.getStrStoreName()
		  +"</b></font></td><td align='center' colspan='2'></td></tr>");
		  
		sb.append(" <tr><td align='center' colspan='3'></td> " +
		  "<td align='center' colspan='3'>" +
		  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
		  "For Item Category ::<b>"+vo.getStrCategoryName() 
		  +"</b></font></td><td align='center' colspan='2'></td></tr>");
		
		sb.append("<tr>"
		        + "<td align='center' colspan='12'>"
		        + "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
		        + "By User  ::<b>" + (vo.getStrUserName() != null && !vo.getStrUserName().isEmpty() ? vo.getStrUserName() : "N/A") + "</b></font></td>"
		        + "<td align='center' colspan='2'></td></tr>");
		
		sb.append("<tr>"
				+ "<td align='center' colspan='12'>"
				+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
				+ "Report Date & Time  ::<b>"+fb.getStrCurrentDate()+"</b></font></td></tr>");
		
		sb.append(" <tr> <td align='center' colspan='3'></td>"
				+ "<td align='center' colspan='3'>"
				+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
				+ "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.getStrFinancialEndYear()+"</b></font></td>"
						+ "<td align='center' colspan='2'>"
						+ "<div id='printid1' class='hidecontrol' style='float:right'>"
						+"</td></tr>");
		sb.append("</table>");
		
				sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<thead style='text-align:center;'><tr>");
		        
		        sb.append("<td width='2%' ><b>S.No</b>");
		        sb.append("</td>");
		        
			    sb.append("<td width='10%' ><b>Return No</b>");
			    sb.append("</td>");
			    
			    sb.append("<td width='8%' ><b>Return Date</b>");
			    sb.append("</td>");
			    
			    sb.append("<td width='12%' ><b>Return To</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='15%' ><b>Item Name</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='10%' ><b>Batch</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='8%' ><b>Expiry Date</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='8%' ><b>Ack Date</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='5%' ><b>Rate</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='5%' ><b>Qty</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='10%' ><b>Amount</b>");
		        sb.append("</td>");
	
		        sb.append("</tr></thead>");
    	if(ws.size() != 0)
		{
			while(ws.next())
			{		
				/*  MODEVAL_1 output procedure level
				1 	return no 
				2 	return date 
				3	item name
				4	batch no 
				5	exp date
				6	rate 
				7	issue qty
				8	total return cost
				9	acknowledge date
				*/	
				sb.append("<tbody><tr>");
						
						sb.append("<td  width='2%' align='center' >");							
						sb.append(i);								            //	SL NO	
						sb.append("</td>");
						
						sb.append("<td  width='10%' align='center' >");							
						sb.append(ws.getString(1));								//	return no   		
						sb.append("</td>");

						sb.append("<td  width='8%' align='center' >");							
						sb.append(ws.getString(2));								//	return date		
						sb.append("</td>");
						
						sb.append("<td  width='12%' align='left'>");								
						sb.append(ws.getString(3));								//	to store 					
						sb.append("</td>");
						
						sb.append("<td  width='15%' align='left'>");
						sb.append(ws.getString(4));								//	item name 
						sb.append("</td>");
						
						sb.append("<td  width='10%' align='center'>");								
						sb.append(ws.getString(5));							//	batch no 
						sb.append("</td>");
						
						
						sb.append("<td  width='8%' align='center'>");
						sb.append(ws.getString(6));							//	expi date 
						sb.append("</td>");
						
						sb.append("<td  width='8%' align='center'>");			
						sb.append(ws.getString(10));						// acknowledge date
						sb.append("</td>");
						
						sb.append("<td  width='5%' align='center'>");
						sb.append(ws.getString(7));							//	Rate
						sb.append("</td>");
						
						sb.append("<td  width='5%' align='center'>");
						sb.append(ws.getString(8));  						// qty
						sb.append("</td>");
						
						sb.append("<td  width='10%' align='center'>");
						sb.append(ws.getString(9));							//	total amount
						sb.append("</td>");

						sb.append("</tr>");
						i++;
						totamt += Double.parseDouble(ws.getString(9).trim());

			}
			
			sb.append("<tr>");
			
			sb.append("<td  colspan='10' align='right'><b> TOTAL </b>");
			sb.append("</td>");				
										
			sb.append("<td  colspan='1' align='center'>");
			sb.append(totamt);								
			sb.append("</td>");
			
			sb.append("</tr></tbody>");
			sb.append("</table>");
		}
	else
	{
		sb.append("<tr><td colspan='12' style='text-align:center;'><font color='red'>No Record Found</font></td>");
		sb.append("</tr></tbody>");
		sb.append("</table>");
	}
   } 
 }
 catch(Exception e)
  {
	    e.printStackTrace();
	    new HisException("Item Replacement Report","ItemReplacementRPTHLP.getReplacementDetails()-->",e.getMessage());
  }
    return sb.toString();
}

}