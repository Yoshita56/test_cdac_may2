package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.vo.ReturnItemListingRptVO_NEW;

public class ReturnItemListingHLP_NEW {
	
	public static String getReturnReqDtls(ReturnItemListingRptVO_NEW vo) 
	{
		StringBuffer sb = new StringBuffer("");
		
		WebRowSet ws = vo.getWsReturnReqDtlRpt();
		int i=1;
		 //System.out.println("rjCheckq::::"+vo.getStrStoreId());
	     //System.out.println("rjCheck::::" +vo.getStrCategoryName());

	    try
	    {
		if (ws != null) 
		{
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
			        + "<tr><td colspan='1'></td>"
					+ " <td colspan='1'></td>"
					+ " <td colspan='1'><br><div id='printImg' align='right'>"
					+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);' /></div></td>");
			sb.append("</tr>");		
					
			sb.append("<tr> "
		        + " <td colspan='1'></td>"
		        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
				//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
				+ " <td colspan='1'></td></tr>");
			sb.append("</table>");		
			
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
					+ " <tr> "
					+ "<td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>"
					+ "<b>"+"Return Request Report"+"</b>"
					+ "</font></td></tr>"
					
					+ "<tr>"
					+ "<td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
					
					+ " <tr>"
					+ "<td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "For Item Category ::<b>"+vo.getStrCategoryName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
					
					+ " <tr> "
					+ "<td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "From Date ::<b>"+vo.getStrStartDate()+"</b> To Date ::<b>"+vo.getStrEndDate()+"</b></font></td>"
					+ "<td align='center' colspan='2'>"
					+ "<div id='printid1' class='hidecontrol' style='float:right'>"
					+"</td></tr>");
			sb.append("</table>");		

				if(ws.size() != 0)
				{
					sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
			        sb.append("<tr>");
						
			        sb.append("<td width='16%' align='center'><b>Return by store Name</b>");
			        sb.append("</td>");
			        
				    sb.append("<td width='10%' align='center'><b>Return To Store</b>");
				    sb.append("</td>");
				    
			        sb.append("<td width='8%' align='center'><b>Return Date</b>");
				    sb.append("</td>");
				    
			        sb.append("<td width='16%' align='center'><b>Item Name</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='8%' align='center'><b>Item Type</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='8%' align='center'><b>Batch</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='6%' align='center'><b>Qty</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='8%' align='center'><b>Rate</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='8%' align='center'><b>Cost</b>");
			        sb.append("</td>");
			        
			        sb.append("</tr>");
			       

				while(ws.next())
				{		
					/*
					1.Return To Store
					2.Return Date
					3.Item Name
					4.Item_type
					5.BATCH
					6.QTY
					7.RATE
					8.COST
					9.Return By Store Name
					10.Catg Name
					*/						
							sb.append("<tr>");
							
							sb.append("<td  width='16%' align='left'>");
							sb.append(ws.getString(9));								//	Return By Store Name
							sb.append("</td>");
						 
							sb.append("<td  width='10%' align='left' >");							
							sb.append(ws.getString(1));								//	Return To Store				
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='center' >");							
							sb.append(ws.getString(2));								//	Return Date				
							sb.append("</td>");

							sb.append("<td  width='16%' align='left'>");								
							sb.append(ws.getString(3));								//	Item Name.					
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='left'>");
							sb.append(ws.getString(4));								//	Item Type
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='center'>");
							sb.append(ws.getString(5));								//	BATCH
							sb.append("</td>");
							
							sb.append("<td  width='6%' align='center'>");
							sb.append(ws.getString(6));								//	QTY
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='center'>");
							sb.append(ws.getString(7));								//	RATE
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='center'>");
							sb.append(ws.getString(8));								//	COST
							sb.append("</td>");
							
							sb.append("</tr>");
							i++;
				}
				sb.append("<tr>");
				
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
		    new HisException("Local Purchase Report","ReturnItemListingRptHLP_NEW.getBreakageDetails()-->",e.getMessage());
	  }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	}

}
