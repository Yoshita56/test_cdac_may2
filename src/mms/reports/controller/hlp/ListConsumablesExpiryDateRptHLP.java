package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.controller.fb.ListConsumablesExpiryDateRptFB;
import mms.reports.vo.ListConsumablesExpiryDateRptVO;

public class ListConsumablesExpiryDateRptHLP {

	public static String getExpiryDetails(ListConsumablesExpiryDateRptFB formBean,ListConsumablesExpiryDateRptVO voObj) 
	{
		StringBuffer sb = new StringBuffer("");
		
		WebRowSet ws = voObj.getWsExpiryDtlRpt();
		int i=1;
	
	    try
	    {
		if (ws != null) 
		{
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
			        + "<tr><td colspan='1'></td>"
					+ " <td colspan='1'></td>"
					+ " <td colspan='1'><br><div id='printImg' align='right'>"
					+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
			sb.append("</tr>");		
					
			sb.append("<tr> "
		        + " <td colspan='1'></td>"
		        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
				//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + voObj.getStrLogoName() + "'></div></td>"
				+ " <td colspan='1'></td></tr>");
			sb.append("</table>");		
			
			sb.append("<div style='display:flex; width:100%;'>");
			sb.append("<div style='width:20%;'><table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
			sb.append("</table></div>");
			sb.append("<div style='width:60%;'><table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ "<tr>"
						+ "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>"
						+ "<b>"+formBean.getStrReportName()+"</b>"
						+ "</font></td>"
						+ "<tr>"
						
						+ "<tr>"
						+ "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Store Name ::<b>"+voObj.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr>"
						+ "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Item Category ::<b>"+voObj.getStrCategoryName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ "<tr>"
						+ "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "Report Date & Time  ::<b>"+formBean.getStrCurrentDate()+"</b></font></td></tr>"
						
						+ " <tr>"
						+ "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "By User  ::<b>"+formBean.getStrUserName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						+"</table> </div>");
			
				sb.append("<div style='width:20%'><table id='legendTable'  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
				sb.append("<tr>"  
						+ "<td align='center' colspan='2'>"  
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" 
						+ "<b>Legends (based on expiry date)</b>"  
						+ "</font></td>" 
						+ "<tr>");
				sb.append("<tr>"  
						+ "<td width='20%' align='right'>"  
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='1'>" 
						+ "<div class='tdClass1' style='width: 12px;height: 12px;border-radius: 6px;'></div>"
						+ "</td>"
						+ "<td align='left'>"
						+ " : For 0 to 90 days"  
						+ "</font></td>"
						+ "<tr>");
				sb.append("<tr>"  
						+ "<td width='20%' align='right'>"  
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='1'>" 
						+ "<div class='tdClass2' style='width: 12px;height: 12px;border-radius: 6px;'></div>"
						+ "</td>"
						+ "<td align='left'>"
						+"  : For 91 to 180 days"  
						+ "</font></td>"
						+ "<tr>");
				sb.append("<tr>"  
						+ "<td width='20%' align='right'>"  
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='1'>"
						+ "<div class='tdClass3' style='width: 12px;height: 12px;border-radius: 6px;'></div>"
						+ "</td>"
						+ "<td align='left'>"
						+"  : For 181 to 360 days"  
						+ "</font></td>" 
						+ "<tr>");
				sb.append("</table></div>");
				sb.append("</div>");
				if(ws.size() != 0)
				{	
//					sb.append("<div style='display:flex; position:fixed;'>"
//							+ " <input type='color' id='favcolor1' name='favcolor1' onChange='changeColor1()' value='#FFC7CE'>"
//							+ " <input type='color' id='favcolor2' name='favcolor2' onChange='changeColor2()' value='#FBD8C5'>"
//							+ " <input type='color' id='favcolor3' name='favcolor3' onChange='changeColor3()' value='#DDEBF7'>"
//							+ "</div>");
					sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
			        sb.append("<tr>");
			        
			        sb.append("<td width='5%' align='center'><b>S No.</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='10%' align='center'><b>Store Name</b>");
				    sb.append("</td>");
				    
				    sb.append("<td width='20%' align='center'><b>Item Name</b>");
				    sb.append("</td>");
				    
			        sb.append("<td width='10%' align='center'><b>Batch No</b>");
				    sb.append("</td>");
				    
			        sb.append("<td width='5%' align='center'><b>Available Qty</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='10%' align='center'><b>Expiry Date</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='5%' align='center'><b>Remaining Days</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='10%' align='center'><b>Cost</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='10%' align='center'><b>Supplied by</b>");
			        sb.append("</td>");
			        
			        sb.append("</tr>");

				while(ws.next())
				{		
						/*
		                    1. Store Name
		                    2. Item  Name
		                    3. Batch_No
		                    4. Avl_Qty
		                    5. Expiry Date
		                    6. Remaning Days
		                    7. Strength
		                    8. Cost
		                    9. Supp By
		                    10.User Name
		                 */       	
						
						String bgColor = "white";
						
						int remaningDays = Integer.parseInt(ws.getString(6).split("\\.")[0]);
						
						if(remaningDays>=0 &&  remaningDays<=90) {
							//bgColor = "#FFC7CE";
							bgColor = "tdClass1";
						}else if(remaningDays>90 && remaningDays<=180) {
//							bgColor = "#FBD8C5";
							bgColor = "tdClass2";
						}else if(remaningDays>181 && remaningDays<=365) {
//							bgColor = "#DDEBF7";
							bgColor = "tdClass3";
						}
						
						sb.append("<tr "
								//+ "style='background-color: "+bgColor+";'>"
										+ " class='"+bgColor+"'>");
						
						sb.append("<td  width='10%' align='center' >");							
						sb.append(i);								            //	S No	
						sb.append("</td>");
						
						sb.append("<td  width='10%' align='left' >");							
						sb.append(ws.getString(1));								//	Store Name 				
						sb.append("</td>");
						
						sb.append("<td  width='20%' align='left' >");							
						sb.append(ws.getString(2));								//	Item Name				
						sb.append("</td>");

						sb.append("<td  width='10%' align='center'>");								
						sb.append(ws.getString(3));								//	Batch No.					
						sb.append("</td>");
						
						sb.append("<td  width='5%' align='center'>");
						sb.append(ws.getString(4));								//	Avl qty
						sb.append("</td>");
						
						sb.append("<td  width='10%' align='center'>");
						sb.append(ws.getString(5));								//	Expiry Date
						sb.append("</td>");
						
						sb.append("<td  width='5%' align='center'>");
						sb.append(ws.getString(6).split("\\.")[0]);				//	Remaining Days
						sb.append("</td>");
						
						sb.append("<td  width='10%' align='center'>");
						sb.append(ws.getString(8));								//	Cost
						sb.append("</td>");
						
						sb.append("<td  width='10%' align='left'>");
						sb.append(ws.getString(9));								//	Supplied
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

	public static String getInvoiceWiseExpiryDetails(ListConsumablesExpiryDateRptFB formBean,ListConsumablesExpiryDateRptVO voObj) 
	{
		StringBuffer sb = new StringBuffer("");
		
		WebRowSet ws = voObj.getWsExpiryDtlRpt();
		int i=1;
	
	    try
	    {
		if (ws != null) 
		{
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
			        + "<tr><td colspan='1'></td>"
					+ " <td colspan='1'></td>"
					+ " <td colspan='1'><br><div id='printImg' align='right'>"
					+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
			sb.append("</tr>");		
					
			sb.append("<tr> "
		        + " <td colspan='1'></td>"
		        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
				//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + voObj.getStrLogoName() + "'></div></td>"
				+ " <td colspan='1'></td></tr>");
			sb.append("</table>");		
		
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ "<tr>"
						+ "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>"
						+ "<b>"+formBean.getStrReportName()+"</b>"
						+ "</font></td>"
						+ "<tr>"
						
						+ "<tr>"
						+ "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Store Name ::<b>"+voObj.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr>"
						+ "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Item Category ::<b>"+voObj.getStrCategoryName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ "<tr>"
						+ "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "Report Date & Time  ::<b>"+formBean.getStrCurrentDate()+"</b></font></td></tr>"
						
						+ " <tr>"
						+ "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "By User  ::<b>"+formBean.getStrUserName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						+"</table> ");
				if(ws.size() != 0)
				{
					sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
			        sb.append("<tr>");
			        
			        sb.append("<td width='3%' align='center'><b>SNo.</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='10%' align='center'><b>Product Name</b>");
				    sb.append("</td>");
				    
				    sb.append("<td width='5%' align='center'><b>Current Stock</b>");
				    sb.append("</td>");
				    
				    sb.append("<td width='8%' align='center'><b>Cost Price</b>");
				    sb.append("</td>");
				    
			        sb.append("<td width='5%' align='center'><b>M.R.P.</b>");
				    sb.append("</td>");
				    
			        sb.append("<td width='8%' align='center'><b>Purchase Price</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='8%' align='center'><b>Sale Price</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='7%' align='center'><b>Received Date</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='8%' align='center'><b>Batch</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='8%' align='center'><b>Expiry Date</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='12%' align='center'><b>Supplied by</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='10%' align='center'><b>Invoice No</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='8%' align='center'><b>Invoice Date</b>");
			        sb.append("</td>");
			        
			        sb.append("</tr>");

				while(ws.next())
				{		
					
							sb.append("<tr>");
							
							sb.append("<td  width='3%' align='center' >");							
							sb.append(i);								            //	S No	
							sb.append("</td>");
							
							sb.append("<td  width='10%' align='left' >");							
							sb.append(ws.getString(1));								//	Product Name 				
							sb.append("</td>");
							
							sb.append("<td  width='5%' align='center' >");							
							sb.append(ws.getString(2));								//	Current Stock		 		
							sb.append("</td>");

							sb.append("<td  width='8%' align='center' >");							
							sb.append(ws.getString(3));								//	Cost Price				
							sb.append("</td>");
							
							
							sb.append("<td  width='5%' align='center'>");								
							sb.append(ws.getString(4));								//	M.R.P.					
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='center'>");
							sb.append(ws.getString(5));								//	Purchase Price
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='center'>");
							sb.append(ws.getString(6));								//	Sales Price
							sb.append("</td>");
							
							sb.append("<td  width='5%' align='center'>");
							/* sb.append(ws.getString(7).split("\\.")[0]); */  
							sb.append(ws.getString(7).split(" ")[0]);               // date
							sb.append("</td>");
							
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(8));								//	Batch  
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='center'>");
							sb.append(ws.getString(9));								//	Expiry
							sb.append("</td>");
							
							sb.append("<td  width='12%' align='left'>");
							sb.append(ws.getString(10));								//	Supplied
							sb.append("</td>");
							
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(11));								//	Invoice No  
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='center'>");
							sb.append(ws.getString(12));								//	Invoice Date
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
		    new HisException("Expiry Report","ListConsumablesExpiryDateRptHLP.getInvoiceWiseExpiryDetails()-->",e.getMessage());
	  }
	    return sb.toString();
	}

}

	
	
