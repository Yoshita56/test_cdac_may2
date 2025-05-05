package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.controller.fb.IssueToPatientFB;
import mms.reports.vo.IssueDetailRptVO_NEW;
import mms.reports.vo.IssueToPatientVO;

public class IssueDetailRptHLP_NEW {
	public static String generateReport(IssueDetailRptVO_NEW vo) 
	{
		StringBuffer sb = new StringBuffer("");
	
		WebRowSet ws = vo.getReportDataWS();
		int i=1;
		
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
					  "Store Name::<b>"+vo.getStrStoreName()
					  +"</b></font></td><td align='center' colspan='2'></td></tr>");
			  
			sb.append(" <tr><td align='center' colspan='3'></td> " +
					  "<td align='center' colspan='3'>" +
					  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
					  "Item Category::<b>"+vo.getStrItemCategoryName() 
					  +"</b></font></td><td align='center' colspan='2'></td></tr>");
			
			sb.append(" <tr> <td align='center' colspan='3'></td>"
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "From Date ::<b>"+vo.getStrFromDate()+"</b> To Date ::<b>"+vo.getStrToDate()+"</b></font></td>"
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
			        
			        sb.append("<td width='20%' ><b>Store Name</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='25%' ><b>Indent No/ Date</b>");
			        sb.append("</td>");
			        
				    sb.append("<td width='10%' ><b>Issued Qty</b>");
				    sb.append("</td>");
				    
				    sb.append("<td width='20%' ><b>Cost</b>");
				    sb.append("</td>");
				   
		
			        sb.append("</tr>");
		
				while(ws.next())
				{		
						
					
						/*	  
							1 	ITEM_NAME  
							2 	SUB_STORE
							3	INDENT_NO_DATE
							4	ISSUE_QTY_UNIT 
							5	COST_VAL */
					double totalCost = 0.0;
					int totalQty = 0;
					sb.append("<tr>");
					sb.append("<td  colspan='4' align='left' >");							
					sb.append(ws.getString(1));								            //	ITEM_NAME	
					sb.append("</td>");
					sb.append("</tr>");
					
					String[] stores = ws.getString(2).split("\\^");
					String[] quantities = ws.getString(4).split("\\^");
					String[] costs = ws.getString(5).split("\\^");
					String[] issueDateNos = ws.getString(3).split("\\^");
					for(int j=0;j<stores.length;j++) {
						totalCost+= Double.parseDouble(costs[j] !=null && !costs[j].isEmpty() ? costs[j] : "0");
						totalQty+=(int)Double.parseDouble(quantities[j] !=null && !quantities[j].isEmpty() ? quantities[j] : "0");
						sb.append("<tr>");
						sb.append("<td  width='5%' align='center' >");							
						sb.append(i);								            //	SL NO	
						sb.append("</td>");
						
						sb.append("<td  width='20%' align='center' >");							
						sb.append(stores[j]);								//	SUB_STORE 		
						sb.append("</td>");
						
						sb.append("<td  width='20%' align='center' >");							
						sb.append(issueDateNos[j]);								// INDENT_NO_DATE 		
						sb.append("</td>");

						sb.append("<td  width='10%' align='center' >");							
						sb.append((int)Double.parseDouble(quantities[j] !=null && !quantities[j].isEmpty() ? quantities[j] : "0"));	 // ISSUE_QTY_UNIT							//	ISSUE_QTY
						sb.append("</td>");
						
						
						sb.append("<td  width='20%' align='center'>");
						sb.append(costs[j] !=null && !costs[j].isEmpty() ? costs[j] : "0");//	COST_VAL
						sb.append("</td>");

						sb.append("</tr>");
						i++;
					}
					sb.append("<tr>");
					sb.append("<td  colspan='3' align='right'><b></b>");
					sb.append("</td>");	
					sb.append("<td  colspan='1' align='center'><b>"+totalQty+"</b>");
					sb.append("</td>");		
												
					sb.append("<td  colspan='1' align='center'><b>");
					sb.append(totalCost);								
					sb.append("</b></td>");
					
					sb.append("</tr>");
							
							
				} //while 
				
				
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
