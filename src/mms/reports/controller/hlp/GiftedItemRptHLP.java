package mms.reports.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;

import mms.reports.controller.fb.GiftedItemRptFB;
import mms.reports.vo.GiftedItemRptvo;

public class GiftedItemRptHLP {

	private static final String strColor = "red";
	private static final String defaultColor = "blue";

	public static String getLPMRNDetails(GiftedItemRptvo vo) 
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
						+ "<b>"+"Gifted Item Report"+"</b>"
						+ "</font></td><td align='center' colspan='2'><div id='printImg'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						

						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Item Category ::<b>"+vo.getStrCategoryName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For ItemName ::<b>"+vo.getStrlpItemName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
					
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
				2. -------->		Gifted Number
				3. -------->		Gifted Date
				4. -------->		Gifted By
				5. -------->		Item Name
				6. -------->		Qty
				
				*/

				sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center'><b>S.No</b>");
			    sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>Gifted Number</b>");
			    sb.append("</td>");
			    sb.append("<td width='10%' align='center'><b>Gifted Date</b>");
			    sb.append("</td>");
			    sb.append("<td width='15%' align='center'><b>Gifted By</b>");
		        sb.append("</td>");
		        sb.append("<td width='13%' align='center'><b>Item Name</b>");
		        sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>Qty</b>");
		        sb.append("</td>");
		        sb.append("</tr>");
		      

				while(ws.next())
				{		
//							if(i==0)
//							{
//								Quantity = Double.parseDouble(ws.getString(6));
//								totamt = Double.parseDouble(ws.getString(6));
//							}
//							else
//							{
//								Quantity = Quantity + Double.parseDouble(ws.getString(6));
//								totamt = totamt + Double.parseDouble(ws.getString(6));
//							}
					
							sb.append("<tr>");
							sb.append("<td  width='5%' align='center' >");							
							sb.append(ws.getString(1));									//	S.No				
							sb.append("</td>");
							sb.append("<td  width='5%' align='left'>");
							sb.append(ws.getString(2));									//	Gifted Number
							sb.append("</td>");
							sb.append("<td  width='5%' align='center'>");
							sb.append(ws.getString(3));								    //	Gifted Date
							sb.append("</td>");
							sb.append("<td  width='5%' align='left'>");								
							sb.append(ws.getString(4));									//	Gifted By					
							sb.append("</td>");
							sb.append("<td  width='25%' align='left'>");
							sb.append(ws.getString(5));								    //	Item Name
							sb.append("</td>");
							sb.append("<td  width='8%' align='right'>");				// Qty
							sb.append(ws.getString(6));									
							sb.append("</td>");
							sb.append("</tr>");
							i++;
							
				}
				
//							sb.append("<tr background-color='red'>");
//							sb.append("<td  colspan='4' align='right'>");
//							sb.append("<b>");
//							sb.append("Total");
//							sb.append("</b>");
//							sb.append("</td>");
//							sb.append("<td align='right'>");
//							sb.append("<b>"+Math.round(totamt)+"</b>");											
//							sb.append("</td>");
//							sb.append("</tr>");
				
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
		    new HisException("Local Purchase Report","GiftedItemRptHLP.getLPMRNDetails()-->",e.getMessage());
	  }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	}


}
