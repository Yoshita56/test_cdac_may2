package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.vo.ListItemWiseSupplierRptVO;

public class ListItemWiseSupplierRptHLP {

	public static String getBreakageDetails(ListItemWiseSupplierRptVO voObj) 
	{
		StringBuffer sb = new StringBuffer("");
		
		WebRowSet ws = voObj.getBreakageDtlRptWs();
		int i=1;
	    try
	    {
	    
		if (ws != null) 
		{
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ "<tr> "
						+ " <td colspan='12'>"
						+ "<br>"
						+"<div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printReport();' />&nbsp; <img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='controlToMainPage();' /></div></td>");

				sb.append("</tr>");		
						
				sb.append("<tr> "
					+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>");
				sb.append("</tr></table>");		
			
				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
						"<tr> "
						+ " <td colspan='12' align='center' style='font-size:18px;font-weight:normal;'>Rate Contract Details Report</td>");
				sb.append("</tr>");
				
		
				sb.append(" <tr><td align='center' colspan='3'></td> " +
				  "<td align='center' colspan='3'>" +
				  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				  "Item Category::<b>"+voObj.getStrItemCategoryName()
				  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				  
				sb.append(" <tr><td align='center' colspan='3'></td> " +
						  "<td align='center' colspan='3'>" +
						  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
						  "Group Name::<b>"+voObj.getStrGroupName()
						  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				
				sb.append(" <tr><td align='center' colspan='3'></td> " +
				  "<td align='center' colspan='3'>" +
				  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				  "Supplier Name::<b>"+voObj.getStrSupplierName()
				  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				
				/*
				sb.append(" <tr> <td align='center' colspan='3'></td>"
				+ "<td align='center' colspan='3'>"
				+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
				+ "From Date ::<b>"+voObj.getStrStartDate()+"</b> To Date ::<b>"+voObj.getStrEndDate()+"</b></font></td>"
						+ "<td align='center' colspan='2'>"
						+ "<div id='printid1' class='hidecontrol' style='float:right'>"
						+"</td></tr>");
				
				sb.append(" <tr> "
				        + " <td colspan='1'></td>"
						+ " <td colspan='1'></td>"
						+ " <td colspan='1'><br></td>");
				sb.append("</tr>"); */
			
				sb.append("</table>");
			
				if(ws.size() != 0)
				{
					sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
			        sb.append("<tr>");
			        sb.append("<td width='5%' align='center'><b>S.No</b>");
				    sb.append("</td>");
				    
				    sb.append("<td width='15%' align='center'><b>Supplier Name</b>");
				    sb.append("</td>");
				    
			        sb.append("<td width='20%' align='center'><b>Item Name</b>");
				    sb.append("</td>");
				    
			        sb.append("<td width='15%' align='center'><b>RC / Tender No</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='10%' align='center'><b>Validity</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='5%' align='center'><b>Tax</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='5%' align='center'><b>Contracted Qty</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='5%' align='center'><b>Ordered Qty</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='5%' align='center'><b>Rate/Unit</b>");
			        sb.append("</td>");
			        
			        sb.append("</tr>");

				while(ws.next())
				{		
					        /*
			                1.Sr No
			                2.supplier Name 
			                3.Item Name
			                4.RC No
			                5.Tender No
			                6.Tax
			                7.Rate-unit 
			                8.Validity 
			                9.Security amt
			                10.Contracted qty
			                11.Ordered qty
			              */							
												
							sb.append("<tr>");
							sb.append("<td  width='5%' align='center' >");							
							sb.append(i);											//	S.No				
							sb.append("</td>");
							
							sb.append("<td  width='15%' align='center' >");							
							sb.append(ws.getString(1));								//	supplier Name 				
							sb.append("</td>");
							
							sb.append("<td  width='20%' align='left' >");							
							sb.append(ws.getString(2));								//	Item Name				
							sb.append("</td>");

							sb.append("<td width='15%' align='center'>")            //  RC No /Tender No
							  .append(ws.getString(3))
							  .append("/<b>")
							  .append(ws.getString(4))
							  .append("</b>")
							  .append("</td>");

							
							sb.append("<td  width='5%' align='center'>");
							sb.append(ws.getString(7));								//	Validity 
							sb.append("</td>");
							
							sb.append("<td  width='3%' align='center'>");
							sb.append(ws.getString(5));								//	Tax
							sb.append("</td>");
							
							sb.append("<td  width='5%' align='center'>");
							sb.append(ws.getString(9));								//	Contracted Qty
							sb.append("</td>");
							
							
							sb.append("<td  width='5%' align='center'>");
							sb.append(ws.getString(10));							//	Ordered Qty 
							sb.append("</td>");
							
							sb.append("<td  width='3%' align='center'>");
							sb.append(ws.getString(6));								//	Rate/Unit
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
		    new HisException("Report","ListItemWiseSupplierRptHLP.getBreakageDetails()-->",e.getMessage());
	  }
	    return sb.toString();
	}

	
}
