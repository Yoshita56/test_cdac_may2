package mms.reports.controller.hlp;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.reports.vo.IssueDetailRptVO;
public class IssueDetailRptHLP {
	public static String generateReport(IssueDetailRptVO vo) 
	{
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = vo.getReportDataWS();
		int i=1;
	  
	    try {
	    	
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
					sb.append("<div id='printRptId' align='right'><img style='cursor: pointer; margin-right :10px;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printReport();' /></div></td>");
					
					sb.append("<div class='d-flex justify-content-center align-items-center'>"
					        //+ " <div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></div>");
							+ " <div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></div>");
				
					sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
							"<tr> "
							+ " <td colspan='3'></td>"
							+ " <td colspan='3'align='center' style='font-size:15px'><b> Issue Details Report</b></td>"
							+ " <td colspan='3'></td>");
					sb.append("</tr>");
					
					sb.append(" <tr><td align='center' colspan='3'></td> " +
							  "<td align='center' colspan='3'>" +
							  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
							  "Search Type ::<b>"+"Store Wise"
							  +"</b></font></td><td align='center' colspan='2'></td></tr>");
					
					sb.append(" <tr><td align='center' colspan='3'></td> " +
					  "<td align='center' colspan='3'>" +
					  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
					  "For Store Name ::<b>"+vo.getStrStoreName()
					  +"</b></font></td><td align='center' colspan='2'></td></tr>");
					  
					sb.append(" <tr><td align='center' colspan='3'></td> " +
					  "<td align='center' colspan='3'>" +
					  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
					  "For Item Category ::<b>"+vo.getStrItemName()
					  +"</b></font></td><td align='center' colspan='2'></td></tr>");
					
					sb.append(" <tr> <td align='center' colspan='3'></td>"
					+ "<td align='center' colspan='3'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "From Date ::<b>"+vo.getStrFromDate()+"</b> To Date ::<b>"+vo.getStrToDate()+"</b></font></td>"
							+ "<td align='center' colspan='2'>"
							+ "<div id='printid1' class='hidecontrol' style='float:right'>"
							+"</td></tr>");
					
					sb.append(" <tr> "
					        + " <td colspan='1'></td>"
							+ " <td colspan='1'></td>"
							+ " <td colspan='1'><br></td>");
					sb.append("</tr>");
				
					sb.append("</table>");
				
						
					
						
						  sb.
						  append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse; width:auto;'>"
						  ); 
						  sb.append("<tr>");
						  sb.append("<td align='center' 	width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No</b></font>");
						  sb.append("</td>"); 
						  sb.append("<td align='center' 	width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Drug</b></font>");
						  sb.append("</td>");
						  sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indenting Store</b></font>");
						  sb.append("</td>");
						  sb.append("<td align='center' 	width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Quantity</b></font>");
						  sb.append("</td>");
						  sb.append("</tr>");
						  
						  
						  while(ws.next()) {
							  
							  String[] stores = ws.getString(1).replace('^', '#').split("#");
							  String[] quantities = ws.getString(3).replace('^', '#').split("#");
							  
							  int totalQty = 0;
						  
							  sb.append("<tr>");
							  sb.append("<td   width='5%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' >"); 
							  sb.append(i); //S.No 
							  sb.append("</font></td>");
							  sb.append("<td  width='40%' align='left' ><font face='Verdana, Arial, Helvetica, sans-serif' >");
							  sb.append(ws.getString(2)); //Issued Drug 
							  sb.append("</font></td>");
							  
							  
							  sb.append("<td  width='10%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							  sb.append(stores[0]); //  Indenting Store
							  sb.append("</font></td>");
							  
							  sb.append("<td  width='5%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							  sb.append((int) Double.parseDouble(quantities[0])); // Quantity
							  totalQty+= Double.parseDouble(quantities[0]);
							  sb.append("</font></td>");
							  
							  sb.append("</tr>"); 
							  for(int j=1;j<stores.length;j++) {
								  sb.append("<tr>");
								  sb.append("<td  width='40%' align='left' colspan='2' ><font face='Verdana, Arial, Helvetica, sans-serif' >");
								  sb.append("</font></td>");
								  
								  
								  sb.append("<td  width='10%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								  sb.append(stores[j]); // Indenting Store
								  sb.append("</font></td>");
								  
								  sb.append("<td  width='5%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								  sb.append((int) Double.parseDouble(quantities[j])); // Quantity
								  totalQty+= Double.parseDouble(quantities[j]);
								  sb.append("</font></td>");
								  
								  sb.append("</tr>"); 
								  
							  }
							  sb.append("<tr>");
							  sb.append("<td width='55%' align='right' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							  sb.append("<b>Total : </b>"); 
							  sb.append("</font></td>");
							  
							  sb.append("<td  width='5%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' >");
							  sb.append(totalQty); // Total Quantity
							  sb.append("</b></font></td>");
							  
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
		    new HisException("Issue Detail Report","IssueDetailRptHLP.generateReport()-->",e.getMessage());
	  }
	//     System.out.println("sb"+sb);
	       return sb.toString();
	}
}
