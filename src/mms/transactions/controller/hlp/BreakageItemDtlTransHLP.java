package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.vo.New_Report_For_AcknowledgeVO;

public class BreakageItemDtlTransHLP {

	public static String getBreakageDetails(WebRowSet ws , String strStoreId , String strHospitalCode) 
	 {
		StringBuffer sb = new StringBuffer("");
	    try
	    {	    
	    	
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
				 sb.append("<table class='' align='center' cellspacing='1px'>");
				 sb.append("<tr>");
				 sb.append("<td class='TITLE' >Breakage/Lost Details ");
				 sb.append("</td></tr>");			
				sb.append("</table>");
				
				sb.append("<table class='' align='center'cellpadding='1px' cellspacing='1px' bgcolor=''>");
		        sb.append("<tr>");
		        sb.append("<td width='10%'   class=''>Date");
			    sb.append("</td>");
			    sb.append("<td width='7%'    class=''>Type");
			    sb.append("</td>");
		        sb.append("<td width='15%'   class=''>Item Name");
		        sb.append("</td>");
		        sb.append("<td width='15%'   class=''>Batch Sl. No");
		        sb.append("</td>");
		        sb.append("<td width='17%'   class=''>Rate/Unit");
		        sb.append("</td>");
		        sb.append("<td width='21%'   class=''>Breakage Qty");
			    sb.append("</td>");
			    sb.append("<td width='15%'   class=''>Cost");
			    sb.append("</td>");
		        sb.append("</tr>");
		        sb.append("</table>");
		        sb.append("<table class='' align='center'cellpadding='1px' cellspacing='1px' bgcolor=''>");
			    
						while(ws.next())
						{
							sb.append("<tr>");
							sb.append("<td class='' width='10%'>");
							sb.append(ws.getString(1));
							sb.append("</td>");
							sb.append("<td class='' width='7%'>");
							sb.append(ws.getString(9));
							sb.append("</td>");
							sb.append("<td class='' width='15%'>");
							sb.append(ws.getString(2));
							sb.append("</td>");
							sb.append("<td class='' width='15%'>");
							sb.append(ws.getString(3));
							sb.append("</td>");
							sb.append("<td class='' width='17%'>");
							sb.append(ws.getString(4)).append("/").append(ws.getString(5));
							sb.append("</td>");
							sb.append("<td class='' width='21%'>");
							sb.append(ws.getString(6)).append(" ").append(ws.getString(7));
							sb.append("</td>");
							sb.append("<td class='' width='15%'>");
							sb.append(ws.getString(8));
							sb.append("</td>");
							sb.append("</tr>");
						
					    }
					sb.append("</table>");
					
	
				} 
				else 
				{
					
					
				 sb.append("<table class='' align='center' cellspacing='1px' bgcolor='' cellpadding='1px'>");
				 sb.append("<tr>");
				 sb.append("<td class='TITLE' ></td></tr>");
				 sb.append("<tr>");
				 sb.append("<td class=''><font color='red'>No Record Found</font></td>");
				 sb.append("</tr>");
				 sb.append("</table>");
			    }
	      } 
		
	 }
	 catch(Exception e)
	 {
		    e.printStackTrace();
		    new HisException("Breakage Details Transaction","BreakageItemDtlTransHLP.getBreakageDetails()-->",e.getMessage());
	    }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	 	}

	public static String getBreakageDetailsNEW_OLD(WebRowSet ws , String strStoreId , String strHospitalCode) 
	 {
		StringBuffer sb = new StringBuffer("");
		int start = 1;
		
		
	    try
	    {
	    	
	    	
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
				
			 sb.append("<table class='table table-striped' align='center' cellspacing='1px'>");
			 sb.append("<tr>");
			 sb.append("<td class='' style='bgcolor:white; color:#666;font-weight: bold;text-align:left'>Breakage/Lost Details ");
			 sb.append("</td></tr>");			
			 sb.append("</table>");
			 sb.append("<table class='table text-uppercase' style='font-weight:bold;' align='center'cellpadding='1px' cellspacing='1px' bgcolor=''>");
	         sb.append("<tr>");
	         sb.append("<td width='10%'class=''>Date");
		     sb.append("</td>");
		     sb.append("<td width='7%'class=''>Type");
		     sb.append("</td>");
	         sb.append("<td width='15%'class=''>Item Name");
	         sb.append("</td>");
	         sb.append("<td width='15%'class=''>Batch Sl. No");
	         sb.append("</td>");
	         sb.append("<td width='17%'class=''>Rate/Unit");
	         sb.append("</td>");
	         sb.append("<td width='21%'class=''>Breakage Qty");
		     sb.append("</td>");
		     sb.append("<td width='15%'class=''>Cost");
		     sb.append("</td>");
	         sb.append("</tr>");
	         sb.append("</table>");
	        
		    
				
				sb.append("<table id='example' class='table table-striped text-uppercase' align='center' cellspacing='1px' bgcolor='' cellpadding='1px'>");
				
				while(ws.next())
				{
					sb.append("<tr>");
					sb.append("<td class='' width='10%'>");
					sb.append(ws.getString(1));
					sb.append("</td>");
					sb.append("<td class='' width='7%'>");
					sb.append(ws.getString(9));
					sb.append("</td>");
					sb.append("<td class='' width='15%'>");
					sb.append(ws.getString(2));
					sb.append("</td>");
					sb.append("<td class='' width='15%'>");
					sb.append(ws.getString(3));
					sb.append("</td>");
					sb.append("<td class='' width='17%'>");
					sb.append(ws.getString(4)).append("/").append(ws.getString(5));
					sb.append("</td>");
					sb.append("<td class='' width='21%'>");
					sb.append(ws.getString(6)).append(" ").append(ws.getString(7));
					sb.append("</td>");
					sb.append("<td class='' width='15%'>");
					sb.append(ws.getString(8));
					sb.append("</td>");
					sb.append("</tr>");
					
				}
				sb.append("</table>");
			}		
		else
		{
			sb.append("<table class='table table-striped text-uppercase' cellspacing='1px' bgcolor='black' cellpadding='1px'>");
			sb.append("<tr>");
			sb.append("<td class='' style='bgcolor:white; color:#666;font-weight: bold;text-align:left'><label>Breakage Details </label></td></tr>");
			sb.append("<tr>");
			sb.append("<td class=''><font color='red'>No Record Found</font></td>");
			sb.append("</tr>");
			sb.append("</table>");
		
		 }
	   }
	 }
	 catch(Exception e)
	 {
		    e.printStackTrace();
		    new HisException("Breakage Details Transaction","BreakageItemDtlTransHLP.getBreakageDetails()-->",e.getMessage());
	    }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	 }
	
	public static String getBreakageDetailsNEW(WebRowSet ws , String strStoreId , String strHospitalCode)  
	{
		StringBuffer sb = new StringBuffer("");
		
		int i=1;		
	    try
	    {
	    
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
							
				sb.append("<table align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td> </tr>"
						
						+ "<tr><td align='center' colspan='3'></td>"
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>"
						+ "<b>"+"Acknowledge Report For Issue"+"</b>"
						+ "</font></td><td align='center' colspan='2'><div id='printImg'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td></tr>" 
						
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+"<b>"+"Breakage / Lost Report"+"</b>"
						+ "</font></td><td align='center' colspan='2'></td></tr>" +
						"</table> <br>");
				
			

				sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center'><b>S.No</b>");
			    sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Date </b>");
			    sb.append("</td>");
			    sb.append("<td width='10%' align='center'><b>Type</b>");
			    sb.append("</td>");
			    sb.append("<td width='30%' align='center'><b>Item Name</b>");
			    sb.append("</td>");
			    sb.append("<td width='15%' align='center'><b>Batch</b>");
			    sb.append("</td>");
			    sb.append("<td width='10%' align='center'><b>Rate/Unit</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Breakage Qty</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Cost</b>");
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
							sb.append("<td  width='10%' align='center' >");							
							sb.append(ws.getString(1));								//	Date				
							sb.append("</td>");
							sb.append("<td  width='15%' align='left'>");
							sb.append(ws.getString(9));							//	Type					
							sb.append("</td>");
							sb.append("<td  width='30%' align='center'>");
							sb.append(ws.getString(2));							//	Item name					
							sb.append("</td>");
							
							sb.append("<td  width='13%' align='left'>");
							sb.append(ws.getString(3));								//	Batch
							sb.append("</td>");
							sb.append("<td  width='10%' align='center'>");								
							sb.append(ws.getString(4)).append("/").append(ws.getString(5));			//	Rate/Unit				
							sb.append("</td>");
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(6)).append(" ").append(ws.getString(7));		//	Breakage Qty
							sb.append("</td>");
							
							sb.append("<td  width='10%' align='right'>");			//  Cost
							sb.append(ws.getString(8));									
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
