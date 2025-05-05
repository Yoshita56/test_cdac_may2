package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.controller.fb.IssueToPatientFB;
import mms.reports.vo.IssueToPatientVO;

public class ItemWiseConsumptionRptHLP {
	public static String generateReportNew(IssueToPatientFB fb,IssueToPatientVO vo) 
	{
		StringBuffer sb = new StringBuffer("");
	
		WebRowSet ws = vo.getWsItemCategoryCombo();
		int i=1;
		double totalnetcost = 0.0;
		try
		{
			if (ws != null) 
			{
			sb.append("<div id='printRptId' align='right'><img style='cursor: pointer; margin-right :10px;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printReport();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='controlToMainPage();' /></div></td>");
	
			sb.append("<div class='d-flex justify-content-center align-items-center'>"
			        //+ " <div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></div>");
					+ " <div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></div>");
			
			sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
					"<tr> "
					+ " <td colspan='3'></td>"
					+"<td colspan='3' align='center' style='font-size:18px;font-weight:normal;font face:Verdana, Arial, Helvetica, sans-serif'>Item Wise Consumption Report</td>"
					+ " <td colspan='3'></td>");
			sb.append("</tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " +
					  "<td align='center' colspan='3'>" +
					  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
					  "Item Category::<b>"+vo.getStrStoreName()
					  +"</b></font></td><td align='center' colspan='2'></td></tr>");
			  
			sb.append(" <tr><td align='center' colspan='3'></td> " +
					  "<td align='center' colspan='3'>" +
					  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
					  "Group Name ::<b>"+vo.getStrItemCategoryName() 
					  +"</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " +
					  "<td align='center' colspan='3'>" +
					  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
					  "Sub Group Name ::<b>"+vo.getStrItemCategoryName() 
					  +"</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " +
					  "<td align='center' colspan='3'>" +
					  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
					  "Item Name ::<b>"+vo.getStrItemCategoryName() 
					  +"</b></font></td><td align='center' colspan='2'></td></tr>");

			
			sb.append(" <tr> <td align='center' colspan='3'></td>"
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.getStrFinancialEndYear()+"</b></font></td>"
							+ "<td align='center' colspan='2'>"
							+ "<div id='printid1' class='hidecontrol' style='float:right'>"
							+"</td></tr>");
			sb.append("</table>");
			
			if(ws.size() != 0)
			{
					sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
					sb.append("<tr style='text-align:center;'>");
			        sb.append("<td width='5%' ><b>S.No</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='25%' ><b>Store Name</b>");
			        sb.append("</td>");
			        
				    sb.append("<td width='10%' ><b>Issued Qty</b>");
				    sb.append("</td>");
				    
				    sb.append("<td width='20%' ><b>Cost</b>");
				    sb.append("</td>");
				   
		
			        sb.append("</tr>");
		
				while(ws.next())
				{		
						
					
						/*	  
							1 	ISSUE_DATE  
							2 	ITEM_NAME
							3	STORE_NAME
							4	ISSUE_QTY 
							5	COST_VAL */
						
							totalnetcost+= Double.parseDouble(ws.getString(5) !=null && !ws.getString(5).isEmpty() ? ws.getString(5) : "0");
							sb.append("<tr>");
							sb.append("<td  width='5%' align='center' >");							
							sb.append(i);								            //	SL NO	
							sb.append("</td>");
							
							sb.append("<td  width='25%' align='center' >");							
							sb.append(ws.getString(3));								//	STORE_NAME 		
							sb.append("</td>");
	
							sb.append("<td  width='10%' align='center' >");							
							sb.append(ws.getString(4));								//	ISSUE_QTY
							sb.append("</td>");
							
							
							sb.append("<td  width='20%' align='center'>");
							sb.append(ws.getString(5) !=null && !ws.getString(5).isEmpty() ? ws.getString(5) : "-");//	COST_VAL
							sb.append("</td>");
	
							sb.append("</tr>");
							i++;
							
				} //while 
				
				sb.append("<tr>");
				
				sb.append("<td  colspan='3' align='right'><b> TOTAL </b>");
				sb.append("</td>");		
											
				sb.append("<td  colspan='1' align='center'>");
				sb.append(totalnetcost);								
				sb.append("</td>");
				
				sb.append("</tr>");
				sb.append("</table>");
			} else {
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
		    new HisException("Item Wise Consumption Report","ItemWiseConsumptionRptHLP.generateReportNew()-->",e.getMessage());
	  }
	return sb.toString();
	}
}
