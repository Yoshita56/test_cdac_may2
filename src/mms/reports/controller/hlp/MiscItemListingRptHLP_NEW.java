package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.vo.MiscItemListingRptVO_NEW;


public class MiscItemListingRptHLP_NEW {

	public static String getMiscellaneousConsDetails(MiscItemListingRptVO_NEW vo) 
	{
		StringBuffer sb = new StringBuffer("");
		
		WebRowSet ws = vo.getWsMiscellaneousConsDtlRpt();
		int i=1;
	    try
	    {
		if (ws != null) 
		{
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
					+ " <tr> "
					+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
					//+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
					+ "</tr>");
			
			sb.append(" <tr align='right'> "
					+ " <td colspan='12'>"
					+ "<div id='printImg' align='right'>"
					+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);' />"
					+ "</div></td></tr></table>");
					
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"		
					+ "<tr><td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>"
					+ "<b>"+" Miscellaneous Consumption Report "+"</b>"
					+ "</font></td>"
					+ "</tr>"
					
					+ " <tr><td align='center' colspan='3'></td> "
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
					
					+ " <tr><td align='center' colspan='3'></td> "
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Item Category ::<b>"+vo.getStrCategoryName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
					
					
					+ " <tr> <td align='center' colspan='3'></td>"
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "From Date ::<b>"+vo.getStrFromDate()+"</b> To Date ::<b>"+vo.getStrToDate()+"</b></font></td>"
							+ "<td align='center' colspan='2'>"
							+ "<div id='printid1' class='hidecontrol' style='float:right'>"
							+"</td></tr>" +
										
					 "</table> ");
			
				if(ws.size() != 0)
				{
					sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
			        sb.append("<tr>");
			        
			        sb.append("<td width='3%' align='center'><b>S No.</b>");
			        sb.append("</td>");
			        
				    sb.append("<td width='20%' align='center'><b>Item Name</b>");
				    sb.append("</td>");
				    
				    sb.append("<td width='10%' align='center'><b>Item Type</b>");
				    sb.append("</td>");
				    
			        sb.append("<td width='10%' align='center'><b>Batch No</b>");
				    sb.append("</td>");
			        
			        sb.append("<td width='15%' align='center'><b>Supplier</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='10%' align='center'><b>Consumed Qty</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='10%' align='center'><b>Date</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='5%' align='center'><b>Rate/Unit</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='5%' align='center'><b>Cost</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='10%' align='center'><b>Remarks</b>");
			        sb.append("</td>");
			        
			        sb.append("</tr>");

				while(ws.next())
				{		
						/*
						 * 1  S.No.
						 * 2  Item Name
						 * 3  Item Type
						 * 4  Batch No
						 * 5  Supplier
						 * 6  Consumed Qty
						 * 7  Date
						 * 8  Rate/Unit
						 * 9  Cost
						 * 10 Remarks
						 */
							   						
							sb.append("<tr>");
							
							sb.append("<td  width='3%' align='center' >");							
							sb.append(i);											//	S No	
							sb.append("</td>");
							
							sb.append("<td  width='20%' align='left' >");							
							sb.append(ws.getString(1));								//	Item Name 				
							sb.append("</td>");
							
							sb.append("<td  width='10%' align='left' >");							
							sb.append(ws.getString(2));								//	Item Type				
							sb.append("</td>");

							sb.append("<td  width='10%' align='center'>");								
							sb.append(ws.getString(3));								//	Batch No.					
							sb.append("</td>");
							
							sb.append("<td  width='15%' align='left'>");
							sb.append(ws.getString(6));								//	Supplier
							sb.append("</td>");
							
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(4));								//	Consume Qty
							sb.append("</td>");
							
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(5));								//	Date 
							sb.append("</td>");
							
//R47J --ws.getString(7)>>ws.getString(10)						
							sb.append("<td  width='5%' align='center'>");
							sb.append(ws.getString(10));							//	Rate/Unit
							sb.append("</td>");
							
							sb.append("<td  width='5%' align='center'>");
							if(ws.getString(8) !=null)
							{
							    sb.append(ws.getString(8).split("\\#")[1]);			 //	Cost
							}
							else
							{
								sb.append("-");			 //	Cost
							}
							sb.append("</td>"); 
							
							sb.append("<td  width='10%' align='left'>");
							sb.append(ws.getString(9));							//	Remarks
							sb.append("</td>");
							
							sb.append("</tr>");
							i++;
				}
				sb.append("</table>");
			}
		else
		{
		 	sb.append("<table align='center' cellspacing='1px' bgcolor='white' cellpadding='1px' border='1px solid black' style='border-collapse:collapse;'>");		
			sb.append("<td ><font color='red'>No Record Found</font></td>");
			sb.append("</tr>");
			sb.append("</table>");
		}
	   } 
		
	 }
	 catch(Exception e)
	 {
		    e.printStackTrace();
		    new HisException("Local Purchase Report","MiscItemListingRptHLP_NEW.getMiscellaneousConsDetails()-->",e.getMessage());
	  }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	}

	
}
