package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.transactions.vo.LocalPurchaseMRN_VO;

public class LocalPurchaseMRN_HLP {

	
	public static String getConsolidatedDetails(LocalPurchaseMRN_VO vo) 
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
				sb.append("<table align='center' cellspacing='1px' cellpadding='1px' border='0'> ");
				sb.append("<tr><td align='center'><div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>");
				sb.append("</tr>");	
				sb.append("</table>");	
				sb.append("<table align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> <td width='8%' colspan='3'></td>"
	
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"
						+ "<b>"+"Local Purchase MRN Report"+"</b>"
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
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Puchase Through ::<b>"+vo.getStrInstituteName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Supplier Name ::<b>"+vo.getStrSupplierName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Group Name ::<b>"+vo.getStrGroupName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr> <td align='center' colspan='3'></td>"
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.getStrFinancialEndYear()+"</b></font></td>"
								+ "<td align='center' colspan='2'>"
								+ "<div id='printid1' class='hidecontrol' style='float:right'>"
								+"</td></tr>" +
											
						 "</table> <br>");
				
				/*
				DataBase Indexing
				
				1. -------->		SrNO
				2. -------->		Entry_Date
				3. -------->		suppName
				4. -------->		item_name
				5. -------->		Batch_No
				6. -------->		Expiry_Date
				7. -------->		Invoice_No
				8. -------->		Invoice_Date
				9. -------->		Quantity
				10. ------->		Rate
				11. ------->		Total_Amount
				12. ------->		Purchase Mode
				*/

				sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center'><b>S.No</b>");
			    sb.append("</td>");
		        sb.append("<td width='15%' align='center'><b>LPDTL</b>");
			    sb.append("</td>");
			    sb.append("<td width='10%' align='center'><b>Supplier Name</b>");
			    sb.append("</td>");
			    sb.append("<td width='8%' align='center'><b>Value</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Status</b>");
		        sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>Actual Delivery Date</b>");
		        sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>Expected Delivery Date</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Performance</b>");
		        sb.append("</td>");
		        
		        sb.append("</tr>");
		      

				while(ws.next())
				{		

					sb.append("<tr>");
					
					sb.append("<td  width='5%' align='center' >");							
					sb.append(i);									//	S.No				
					sb.append("</td>");
					
					sb.append("<td  width='8%' align='left'>");
					sb.append(ws.getString(8)+" / "+ws.getString(5));				//	LPDTL
					sb.append("</td>");
					
					sb.append("<td  width='10%' align='left'>");
					sb.append(ws.getString(6));								    //	Supplier Name
					sb.append("</td>");
					
					sb.append("<td  width='10%' align='right'>");								
					sb.append(ws.getString(9));									//	Value			
					sb.append("</td>");
					
					sb.append("<td  width='10%' align='left'>");
					sb.append(ws.getString(10));								//	Status
					sb.append("</td>");
					
					sb.append("<td  width='8%' align='center'>");				// Actual Delivery Date
					sb.append(ws.getString(11));									
					sb.append("</td>");
					
					sb.append("<td  width='8%'align='center'>");
					sb.append(ws.getString(12));									//	Expected Delivery Date
					sb.append("</td>");
					
					sb.append("<td  width='7%' align='left'>");
					sb.append(ws.getString(13));									//	Performance
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
	
	
	
	public static String getLPMRNDetails(LocalPurchaseMRN_VO vo) 
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
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ "<tr> "
				        + " <td colspan='1'></td>"
						+ " <td colspan='1'></td>"
						+ " <td colspan='1'><br><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
				sb.append("</tr>");		
						
				sb.append("<tr> "
			        + " <td colspan='1'></td>"
			        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
					//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
					+ " <td colspan='1'></td>");
				sb.append("</tr></table>");			
				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> <td colspan='3'></td>"
	
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"
						+ "<b>"+"Local Purchase MRN Report"+"</b>"
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
						
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For ItemName ::<b>"+vo.getStrlpItemName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Puchase Through ::<b>"+vo.getStrInstituteName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Supplier Name ::<b>"+vo.getStrSupplierName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Group Name ::<b>"+vo.getStrGroupName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
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
				2. -------->		Entry_Date
				3. -------->		suppName
				4. -------->		item_name
				5. -------->		Batch_No
				6. -------->		Expiry_Date
				7. -------->		Invoice_No
				8. -------->		Invoice_Date
				9. -------->		Quantity
				10. ------->		Rate
				11. ------->		Total_Amount
				12. ------->		Purchase Mode
				*/

				sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center'><b>S.No</b>");
			    sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>Entry Date</b>");
			    sb.append("</td>");
			    sb.append("<td width='10%' align='center'><b>Vendor</b>");
			    sb.append("</td>");
			    sb.append("<td width='15%' align='center'><b>Item Name</b>");
		        sb.append("</td>");
		        sb.append("<td width='13%' align='center'><b>Purchase Mode</b>");
		        sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>Batch No.</b>");
		        sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>Expiry Date</b>");
		        sb.append("</td>");
		        sb.append("<td width='7%' align='center'><b>Invoice No</b>");
		        sb.append("</td>");
		        sb.append("<td width='7%' align='center'><b>Invoice Date</b>");
			    sb.append("</td>");
			    sb.append("<td width='7%' align='center'><b>Quantity</b>");
			    sb.append("</td>");
			    sb.append("<td width='7%' align='center'><b>Rate(With GST)</b>");
			    sb.append("</td>");
			    sb.append("<td width='7%' align='r'><b>Total Amount Rate * Quantity</b>");
			    sb.append("</td>");
		        sb.append("</tr>");
		      

				while(ws.next())
				{		
							if(i==0)
							{
								Quantity = Double.parseDouble(ws.getString(10));
								totamt = Double.parseDouble(ws.getString(12));
							}
							else
							{
								Quantity = Quantity + Double.parseDouble(ws.getString(10));
								totamt = totamt + Double.parseDouble(ws.getString(12));
							}
					
							sb.append("<tr>");
							sb.append("<td  width='5%' align='center' >");							
							sb.append(ws.getString(1));									//	S.No				
							sb.append("</td>");
							sb.append("<td  width='8%' align='center'>");
							sb.append(ws.getString(3));									//	Entry_Date
							sb.append("</td>");
							sb.append("<td  width='10%'>");
							sb.append(ws.getString(4));								    //	Supplier Name
							sb.append("</td>");
							sb.append("<td  width='15%'>");								
							sb.append(ws.getString(5));									//	Item Name					
							sb.append("</td>");
							sb.append("<td  width='13%'>");
							sb.append(ws.getString(13));								//	Purchase Mode
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='center'>");				// Batch No.
							sb.append(ws.getString(6));									
							sb.append("</td>");
							
							sb.append("<td  width='8%'align='center'>");
							sb.append(ws.getString(7));									//	Expiry Date
							sb.append("</td>");
							sb.append("<td  width='7%' align='left'>");
							sb.append(ws.getString(8));									//	Invoice No
							sb.append("</td>");
							sb.append("<td  width='7%' align='center'>");
							sb.append(ws.getString(9));								    //	Invoice Date
							sb.append("</td>");
							sb.append("<td  width='7%' align='right'>");
							sb.append(ws.getString(10));								//	Quantity
							sb.append("</td>");
							sb.append("<td  width='7%' align='right'>");
							sb.append(ws.getString(11));								//	Rate
							sb.append("</td>");
							sb.append("<td  width='7%' align='right'>");
							sb.append(ws.getString(12));								//	Total Amount Rate * Quantity
							sb.append("</td>");
							sb.append("</tr>");
							i++;
							
				}
				
							sb.append("<tr background-color='red'>");
							
							sb.append("<td  colspan='9' align='right'>");
							sb.append("<b>");
							sb.append("Total");
							sb.append("</b>");
							sb.append("</td>");
							
							sb.append("<td align='center'>");
							sb.append("<b>"+Math.round(Quantity)+"</b>");											
							sb.append("</td>");
							
							sb.append("<td align='center'>");
							sb.append("");											
							sb.append("</td>");
							
							sb.append("<td align='center'>");
							sb.append("<b>"+Math.round(totamt)+"</b>");											
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
