package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.vo.ListofNARptVO;

public class ListofNARptHLP {
	
	public static String getReturnReqDtls(ListofNARptVO vo) 
	{
		StringBuffer sb = new StringBuffer("");
		
		WebRowSet ws = vo.getWsReturnReqDtlRpt();
		int i=1;
		
	    try
	    {
			if (ws != null) 
			{
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
				        + "<tr><td colspan='1'></td>"
						+ " <td colspan='1'></td>"
						+ " <td colspan='1'>"
			+ "<br><div id='printImg' align='right'>"
			+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div>"
						
						+"</td></tr>");			
						
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
						+ "<b>"+" List of Not Available Items "+"</b>"
						+ "</font></td>"
						+ "</tr>");
						
				sb.append("<tr><td align='center' colspan='12'>" +
						  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
						  "For Item Category ::<b>"+vo.getStrCategoryName() 
						  +"</b></font></td></tr>");
				
				sb.append(" <tr>"
				+"<td align='center' colspan='12'>" +
				  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				  "Indent Store Name ::<b>"+vo.getStrStoreName()
				  +"</b></font></td></tr>");
						 
				if (vo.getStrIssuingStoreName().equals("Select Value")) {
					sb.append("<tr><td align='center' colspan='12'>" +
	                "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
	            	"Issuing Store Name ::<b>" + "--" + "</b></font></td></tr>");
				} else {
					sb.append("<tr><td align='center' colspan='12'>" +
	                "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
	                "Issuing Store Name ::<b>" + vo.getStrIssuingStoreName() + "</b></font></td></tr>");
				}
				
				sb.append("</table>");		
				
				/*
				 * sb.
				 * append("<table align='center' cellspacing='1px' cellpadding='1px' border='0'>"
				 * + " <tr> " //+
				 * "<td width='8%' colspan='3'><div><img src='/INVMGM/hisglobal/images/logo.png' width='100' style='margin-left: 100%;float: left;'></div></td>"
				 * 
				 * + " <td colspan='1'></td>" //+
				 * " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
				 * + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/"
				 * + vo.getStrLogoName() + "'></div></td>" + " <td colspan='1'></td>"
				 * 
				 * 
				 * 
				 * + "<td align='center' colspan='3'>" +
				 * "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>" +
				 * "<b>"+" List of Not Available Items "+"</b>" + "</font></td>"
				 * 
				 * +
				 * "<td align='center' colspan='2'><div id='printImg'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div>"
				 * + "</td>" + "</tr>"
				 * 
				 * 
				 * + " <tr><td align='center' colspan='3'></td> " +
				 * "<td align='center' colspan='3'>" +
				 * "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				 * "Indent Store Name ::<b>"+vo.getStrStoreName()
				 * +"</b></font></td><td align='center' colspan='2'></td></tr>"
				 * 
				 * + " <tr><td align='center' colspan='3'></td> " +
				 * "<td align='center' colspan='3'>" +
				 * "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				 * "Issuing Store Name ::<b>"+vo.getStrIssuingStoreName()
				 * +"</b></font></td><td align='center' colspan='2'></td></tr>"
				 * 
				 * 
				 * + " <tr><td align='center' colspan='3'></td> " +
				 * "<td align='center' colspan='3'>" +
				 * "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				 * "For Item Category ::<b>"+vo.getStrCategoryName()
				 * +"</b></font></td><td align='center' colspan='2'></td></tr>" + " </table> ");
				 */
					
					if(ws.size() != 0)
					{
						sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
				        sb.append("<tr>");
				        
				        sb.append("<td width='10%' align='center'><b>SNo.</b>");
				        sb.append("</td>");
							
				        sb.append("<td width='40%' align='center'><b>Name</b>");
				        sb.append("</td>");
				        
					    sb.append("<td width='20%' align='center'><b>Group Name</b>");
					    sb.append("</td>");
					    
				        sb.append("<td width='15%' align='center'><b>Type</b>");
					    sb.append("</td>");
					    
				        sb.append("<td width='15%' align='center'><b>EDL</b>");
				        sb.append("</td>");
				        
				        sb.append("</tr>");
				       
	
					while(ws.next())
					{		
						/*
						1.Item Name
						2.Group Name
						3.Item Type
						4.EDL
					*/					
								sb.append("<tr>");
								
								sb.append("<td  width='10%' align='center'><b>");
								sb.append(i);								
								sb.append("</b></td>");
							 
								sb.append("<td  width='40%' align='left' >");							
								sb.append(ws.getString(1));										
								sb.append("</td>");
								
								sb.append("<td  width='20%' align='center' >");							
								sb.append(ws.getString(2));											
								sb.append("</td>");
	
								sb.append("<td  width='15%' align='center'>");								
								sb.append(ws.getString(3));												
								sb.append("</td>");
								
								sb.append("<td  width='15%' align='center'>");
								sb.append(ws.getString(4));								
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
		    new HisException("NA List Report","ReturnItemListingRptHLP_NEW.getReturnReqDtls()-->",e.getMessage());
	  }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	}

}
