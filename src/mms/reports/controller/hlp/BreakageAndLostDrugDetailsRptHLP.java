package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.vo.BreakageAndLostDrugDetailsRptVO;

public class BreakageAndLostDrugDetailsRptHLP {

	public static String getBreakageDetails(BreakageAndLostDrugDetailsRptVO voObj) 
	{
		StringBuffer sb = new StringBuffer("");
		
		WebRowSet ws = voObj.getWsBreakageDtlRpt();
		int i=1;
		double totamt   = 0.00;
		int    Quantity = 0;
	    try
	    {
	    
		if (ws != null) 
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
					//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + voObj.getStrLogoName() + "'></div></td>"
					+ " <td colspan='1'></td>");
				sb.append("</tr></table>");		
			
				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
						"<tr> "
						+ " <td colspan='3'></td>"
						+ " <td colspan='3'align='center' style='font-size:15px'><b>Breakage and Lost Drug Details Report</b></td>"
						+ " <td colspan='3'></td>");
				sb.append("</tr>");
				
				
				sb.append(" <tr><td align='center' colspan='3'></td> " +
				  "<td align='center' colspan='3'>" +
				  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				  "For Store Name ::<b>"+voObj.getStrStoreName()
				  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				  
				  
				sb.append(" <tr><td align='center' colspan='3'></td> " +
				  "<td align='center' colspan='3'>" +
				  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				  "For Item Category ::<b>"+voObj.getStrCategoryName() 
				  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				 
				
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
				sb.append("</tr>");
			
				sb.append("</table>");
			
				if(ws.size() != 0)
				{
					sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
			        sb.append("<tr>");
			        sb.append("<td width='5%' align='center'><b>S.No</b>");
				    sb.append("</td>");
				    
				    sb.append("<td width='10%' align='center'><b>Date</b>");
				    sb.append("</td>");
				    
			        sb.append("<td width='40%' align='center'><b>Drug Name</b>");
				    sb.append("</td>");
				    
			        sb.append("<td width='25%' align='center'><b>Batch No.</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='10%' align='center'><b>Breakage/Lost Qty</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='10%' align='center'><b>Cost</b>");
			        sb.append("</td>");
			        
			        sb.append("</tr>");

				while(ws.next())
				{		
							if(i==0)
							{
								Quantity = Integer.parseInt(ws.getString(5));
								totamt = Double.parseDouble(ws.getString(7));
							}
							else
							{
								Quantity = Quantity + Integer.parseInt(ws.getString(5));
								totamt = totamt + Double.parseDouble(ws.getString(7));
							}
							
							 
					        /*
			                1.Sr No
			                2.Breakage Date
			                3.Item Name
			                4.Batch No
			                5.Breakage Qty
			                6.Unit Name
			                7.Cost 
			                8.Drug Code
			                9.Store Name
			              */							
												
							sb.append("<tr>");
							sb.append("<td  width='5%' align='center' ><b>");							
							sb.append(i);											//	S.No				
							sb.append("</b></td>");
							
							sb.append("<td  width='10%' align='center' >");							
							sb.append(ws.getString(2));								//	Date				
							sb.append("</td>");
							
							sb.append("<td  width='40%' align='left' >");							
							sb.append(ws.getString(3));								//	Drug Code/Name				
							sb.append("</td>");

							sb.append("<td  width='25%' align='left'>");								
							sb.append(ws.getString(4));								//	Batch No.					
							sb.append("</td>");
							
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(5));								//	Breakage/Lost Qty
							sb.append("</td>");
							
							
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(7));								//	Cost
							sb.append("</td>");
							
							sb.append("</tr>");
							i++;
				}
				
				sb.append("<tr>");
				
				sb.append("<td  colspan='4' align='right'><b> Total : </b>");
				sb.append("</td>");				
				sb.append("<td  colspan='1' align='center'>");
				sb.append(Quantity);								
				sb.append("</td>");			
				sb.append("<td  colspan='1' align='center'>");
				sb.append(totamt);								
				sb.append("</td>");
				
				sb.append("</tr>");
				
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
