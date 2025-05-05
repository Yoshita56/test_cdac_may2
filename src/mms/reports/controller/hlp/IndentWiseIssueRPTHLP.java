package mms.reports.controller.hlp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.vo.IndentWiseIssueRPTVO;

public class IndentWiseIssueRPTHLP {

	private static final String strColor = "red";
	private static final String defaultColor = "blue";

public static String getIssueDetails(IndentWiseIssueRPTVO vo) 
	 {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = vo.getWsItemCategoryCombo();
		int i=1;
		double totamt = 0.00;
		double Quantity = 0.00;
	    try
	    {
	    
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ "<tr> "
				        + " <td colspan='1'></td>"
						+ " <td colspan='1'></td>"
						+ " <td colspan='1'><br><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
				sb.append("</tr>");		
						
				sb.append("<tr> "
			        + " <td colspan='1'></td>"
//					+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
			        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"

					+ " <td colspan='1'></td>");
				sb.append("</tr></table>");		
			
				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
						"<tr> "
						+ " <td colspan='3'></td>"
						+ " <td colspan='3'align='center' style='font-size:15px'><b>Acknowledge Report For Issue</b></td>"
						+ " <td colspan='3'></td>");
				sb.append("</tr>");
				
				
				sb.append(" <tr><td align='center' colspan='3'></td> " +
				  "<td align='center' colspan='3'>" +
				  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				  "Acknowledged Store Name ::<b>"+vo.getStrStoreName()
				  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				  
				sb.append(" <tr><td align='center' colspan='3'></td> " +
				  "<td align='center' colspan='3'>" +
				  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				  "For Item Category ::<b>"+vo.getStrCategoryName() 
				  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				 
				sb.append(" <tr><td align='center' colspan='3'></td> " +
						  "<td align='center' colspan='3'>" +
						  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
						  "For Item Name ::<b>"+vo.getStrlpItemName() 
						  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				
				sb.append(" <tr> <td align='center' colspan='3'></td>"
				+ "<td align='center' colspan='3'>"
				+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
				+ "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.getStrFinancialEndYear()+"</b></font></td>"
						+ "<td align='center' colspan='2'>"
						+ "<div id='printid1' class='hidecontrol' style='float:right'>"
						+"</td></tr>");
				
				sb.append(" <tr> "
				        + " <td colspan='1'></td>"
						+ " <td colspan='1'></td>"
						+ " <td colspan='1'><br></td>");
				sb.append("</tr>");
			
				sb.append("</table>");
				sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center'><b>S.No</b>");
			    sb.append("</td>");
		        sb.append("<td width='17%' align='center'><b>Issue No [Date] </b>");
			    sb.append("</td>");
			    sb.append("<td width='15%' align='center'><b>Supplier Name</b>");
			    sb.append("</td>");
			    sb.append("<td width='10%' align='center'><b>Ack By</b>");
			    sb.append("</td>");
			    sb.append("<td width='25%' align='center'><b>Item Name</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Batch No.</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Expiry Date</b>");
		        sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>Qty</b>");
		        sb.append("</td>");
		        sb.append("</tr>");
				while(ws.next())
				{		
							if(i==0)
							{
//								Quantity = Double.parseDouble(ws.getString(8));
//								totamt = Double.parseDouble(ws.getString(12));
							}
							else
							{
//								Quantity = Quantity + Double.parseDouble(ws.getString(8));
//								totamt = totamt + Double.parseDouble(ws.getString(12));
							}
					
							sb.append("<tr>");
							sb.append("<td  width='5%' align='center' >");							
							sb.append(i);											//	S.No				
							sb.append("</td>");
							sb.append("<td  width='17%' align='center' >");							
							sb.append(ws.getString(1));								//	Issue No/Issue Date				
							sb.append("</td>");
							sb.append("<td  width='15%' align='left'>");
							sb.append(ws.getString(15));							//	Supplier Name							
							sb.append("</td>");
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(14));							//	Ack By						
							sb.append("</td>");
							
							sb.append("<td  width='25%' align='left'>");
							sb.append(ws.getString(4));								//	Item Name
							sb.append("</td>");
							sb.append("<td  width='10%' align='center'>");								
							sb.append(ws.getString(5));								//	Batch No.					
							sb.append("</td>");
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(6));								//	Expiry Date
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='right'>");			//  Qty
							sb.append(ws.getString(8));									
							sb.append("</td>");
							
							sb.append("</tr>");
							i++;
							
				}
				
//							sb.append("<tr background-color='red'>");
//							sb.append("<td  colspan='6' align='right'>");
//							sb.append("<b>");
//							sb.append("Total");
//							sb.append("</b>");
//							sb.append("</td>");
//							sb.append("<td align='right'>");
//							sb.append("<b>"+Math.round(Quantity)+"</b>");											
//							sb.append("</td>");
//							sb.append("<td align='right'>");
//							sb.append("");											
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
		    new HisException("Local Purchase Report","IndentWiseIssueRPTHLP.getIssueDetails()-->",e.getMessage());
	  }
	    return sb.toString();
	}




public static String getTransferDetails(IndentWiseIssueRPTVO vo) 
{
	StringBuffer sb = new StringBuffer("");
	WebRowSet ws = vo.getWsItemCategoryCombo();
	int i=1;
	double totamt = 0.00;
	double Quantity = 0.00;
	
	Set<String> uniqueParentNode = new HashSet<>();
    Set<String> uniqueChildNode = new HashSet<>();
    Map<String, Set<String>> childNodeToSubChildNodeMap = new HashMap<>();
  
    try {
    
	if (ws != null) 
	{
		if(ws.size() != 0)
		{
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
					+ "<tr> "
			        + " <td colspan='1'></td>"
					+ " <td colspan='1'></td>"
					+ " <td colspan='1'><br><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
			sb.append("</tr>");		
					
			sb.append("<tr> "
		        + " <td colspan='1'></td>"
		        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
//				+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
				+ " <td colspan='1'></td>");
			sb.append("</tr></table>");		
		
			sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
					"<tr> "
					+ " <td colspan='3'></td>"
					+ " <td colspan='3'align='center' style='font-size:15px'><b>Indent Wise Issue Report</b></td>"
					+ " <td colspan='3'></td>");
			sb.append("</tr>");
			
			
			sb.append(" <tr><td align='center' colspan='3'></td> " +
			  "<td align='center' colspan='3'>" +
			  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
			  "Acknowledged Store Name ::<b>"+vo.getStrStoreName()
			  +"</b></font></td><td align='center' colspan='2'></td></tr>");
			  
			sb.append(" <tr><td align='center' colspan='3'></td> " +
			  "<td align='center' colspan='3'>" +
			  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
			  "For Item Category ::<b>"+vo.getStrCategoryName() 
			  +"</b></font></td><td align='center' colspan='2'></td></tr>");

			sb.append(" <tr> <td align='center' colspan='3'></td>"
			+ "<td align='center' colspan='3'>"
			+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
			+ "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.getStrFinancialEndYear()+"</b></font></td>"
					+ "<td align='center' colspan='2'>"
					+ "<div id='printid1' class='hidecontrol' style='float:right'>"
					+"</td></tr>");
			
			sb.append(" <tr> "
			        + " <td colspan='1'></td>"
					+ " <td colspan='1'></td>"
					+ " <td colspan='1'><br></td>");
			sb.append("</tr>");
		
			sb.append("</table>");
		
				
			

			sb.append("<table class='table table-striped table-light border' align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
	        sb.append("<tr>");
	        sb.append("<td width='4%' align='center' class='py-4'><b>S.No</b>");
		    sb.append("</td>");
	        sb.append("<td width='10%' align='center' class='py-4'><b>Indenting Store</b>");
		    sb.append("</td>");
		    sb.append("<td width='19%' align='center' class='py-4'><b>Item Name</b>");
	        sb.append("</td>");
		    sb.append("<td width='11%' align='center' class='py-4'><b>Indent No /Date</b>");
	        sb.append("</td>");
	        sb.append("<td width='5%' align='center' class='py-4'><b>IndentQty</b>");
	        sb.append("</td>");
	        sb.append("<td width='5%' align='center' class='py-4'><b>Issue Qty</b>");
	        sb.append("</td>");
	        sb.append("<td width='11%' align='center' class='py-4'><b>Issue No /Date </b>");
	        sb.append("</td>");
	        sb.append("<td width='10%' align='center' class='py-4'><b>Expiry Date</b>");
	        sb.append("</td>");
//	        sb.append("<td width='10%' align='center'><b>Issue Qty</b>");
//	        sb.append("</td>");
//	        sb.append("<td width='6%' align='center'><b>Cost</b>");
//	        sb.append("</td>");
	        sb.append("<td width='6%' align='center' class='py-4'><b>Batch</b>");
	        sb.append("</td>");
	        sb.append("<td width='8%' align='center' class='py-4'><b>Recieved By</b>");
	        sb.append("</td>");
	        sb.append("</tr>");
	      

			while(ws.next())
			{		
					
						sb.append("<tr>");
						sb.append("<td  class='py-4' width='4%' align='center' >");							
						sb.append(i);																		//	S.No				
						sb.append("</td>");
						sb.append("<td class='py-4' width='10%' align='left' >");							
						sb.append(ws.getString(14));														//	Indenting Store			
						sb.append("</td>");
						
						sb.append("<td class='py-4' width='19%' align='left'>");
						sb.append(ws.getString(4));															//	Item Name
						sb.append("</td>");
						
						sb.append("<td class='py-4' width='11%' align='right'>");
						sb.append(ws.getString(41)+"<br> "+ws.getString(3));								//	Indent No / Indent Date
						
						sb.append("</td>");
						
						sb.append("<td class='py-4' width='5%' align='center'>");								
						sb.append(ws.getString(5));															//	Indent Qty					
						sb.append("</td>");
						
						sb.append("<td class='py-4' width='5%' align='center'>");								
						sb.append(ws.getString(6));						                        			//	Issue  Qty					
						sb.append("</td>");						
						
						sb.append("<td class='py-4' width='11%' align='right'>");
						sb.append(ws.getString(7)+"<br>"+ws.getString(8));						        //	Issue No / Issue Date						
						sb.append("</td>");
						
						sb.append("<td class='py-4' width='10%' align='center'>");							//  Expiry Date
						sb.append(ws.getString(16));									
						sb.append("</td>");
//						sb.append("<td  width='10%' align='right'>");										//  Issue Qty
//						sb.append(ws.getString(6));									
//						sb.append("</td>");
//						sb.append("<td class='py-4' width='6%' align='right'>");							//  Cost
//						sb.append(ws.getString(9));									
//						sb.append("</td>");
						sb.append("<td class='py-4' width='6%' align='center'>");							//  Batch
						sb.append(ws.getString(12));									
						sb.append("</td>");
						sb.append("<td class='py-4' width='8%' align='left'>");							//  Recieved By
						sb.append(ws.getString(10));									
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
	    new HisException("Local Purchase Report","IndentWiseIssueRPTHLP.getTransferDetails()-->",e.getMessage());
  }
//     System.out.println("sb"+sb);
       return sb.toString();
}


}