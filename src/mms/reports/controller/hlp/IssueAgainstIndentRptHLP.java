package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.vo.IssueAgainstIndentRptVO;
import mms.reports.vo.IssueAgainstIndentRptVO;

public class IssueAgainstIndentRptHLP {

	private static final String strColor = "red";
	private static final String defaultColor = "blue";

	public static String getLPMRNDetails(IssueAgainstIndentRptVO vo) 
	 {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = vo.getWsItemCategoryCombo();
		int i=0;
		double totamt = 0.00;
		double Quantity = 0.00;
	    try
	    {
	    
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
							
				sb.append("<table align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						//+ " <tr> <td width='8%' colspan='3'><div><img src='/HBIMS/hisglobal/images/logo.png' width='100' style='margin-left: 100%;float: left;'></div></td>"
						+ " <tr> <td width='8%' colspan='3'><div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' width='100' style='margin-left: 100%;float: left;'></div></td>"
						
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"
						+ "<b>"+"Issue Against Indent Report"+"</b>"
						+ "</font></td><td align='center' colspan='2'><div id='printImg'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td></tr>" 
						
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
						+ "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.getStrFinancialEndYear()+"</b></font></td>"
								+ "<td align='center' colspan='2'>"
								+ "<div id='printid1' class='hidecontrol' style='float:right'>"
								+"</td></tr>" +
											
						 "</table> ");
				
				/*
				DataBase Indexing
				
				1. -------->		SrNO
				2. -------->		Indent No
				3. -------->		Indenting Store
				4.--------->		Indent Date
				5. -------->		Item Name
				6. -------->		Issue Qty
				7. -------->		Approve Qty
				8. -------->		Rate
				9. -------->		Issue No
				10. -------->		Issue Date
				11. -------->		Cost
				
				*/

				sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center'><b>Sr.No</b>");
			    sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Indent No</b>");
			    sb.append("</td>");
			    sb.append("<td width='10%' align='center'><b>Indenting Store</b>");
			    sb.append("</td>");
			    sb.append("<td width='7%' align='center'><b>Indent Date</b>");
			    sb.append("</td>");
			    sb.append("<td width='17%' align='center'><b>Item Name</b>");
		        sb.append("</td>");
		        sb.append("<td width='7%' align='center'><b>Issue Qty</b>");
		        sb.append("</td>");
		        sb.append("<td width='7%' align='center'><b>Approve Qty</b>");
		        sb.append("</td>");
		        sb.append("<td width='7%' align='center'><b>Rate</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Issue No</b>");
		        sb.append("</td>");
		        sb.append("<td width='7%' align='center'><b>Issue Date</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Cost</b>");
		        sb.append("</td>");
		        sb.append("</tr>");
		      

				while(ws.next())
				{		
					
							sb.append("<tr>");
							sb.append("<td  width='5%' align='center' >");							
							sb.append(ws.getString(1));									//	Sr.No				
							sb.append("</td>");
							sb.append("<td  width='10%' align='right'>");
							sb.append(ws.getString(2));									//	Indent No
							sb.append("</td>");
							sb.append("<td  width='10%' align='left'>");
							sb.append(ws.getString(3));								    //	Indenting Store
							sb.append("</td>");
							sb.append("<td  width='7%' align='center'>");
							sb.append(ws.getString(4));								    //	Indent Date
							sb.append("</td>");
							sb.append("<td  width='17%' align='left'>");								
							sb.append(ws.getString(5));									//	Item Name					
							sb.append("</td>");
							sb.append("<td  width='7%' align='right'>");	
							sb.append(ws.getString(6));									//	Issue Qty					
							sb.append("</td>");
							sb.append("<td  width='7%' align='right'>");	
							sb.append(ws.getString(7));									//	Approve Qty					
							sb.append("</td>");
							sb.append("<td  width='10%' align='right'>");	
							sb.append(ws.getString(11));								//	Rate					
							sb.append("</td>");
							sb.append("<td  width='10%' align='right'>");	
							sb.append(ws.getString(8));									//	Issue No				
							sb.append("</td>");
							sb.append("<td  width='17%' align='center'>");	
							sb.append(ws.getString(9));									//	Issue Date					
							sb.append("</td>");
							sb.append("<td  width='10%' align='right'>");	
							sb.append(ws.getString(10));							    //	Cost					
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
		    new HisException("Local Purchase Report","BreakageItemDtlTransHLP.getBreakageDetails()-->",e.getMessage());
	  }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	}


}
