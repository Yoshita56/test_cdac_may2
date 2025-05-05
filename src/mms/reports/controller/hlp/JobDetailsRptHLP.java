package mms.reports.controller.hlp;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import mms.reports.controller.fb.JobDetailsRptFB;
import mms.reports.vo.JobDetailsRptVO;

public class JobDetailsRptHLP {
	public static String getTransferDetails(JobDetailsRptVO vo,HttpServletRequest request,JobDetailsRptFB formBean) throws Exception  
	{

		System.out.println("--------------------- JobDetailsRptHLP.getIssueDtls -------------------------------");
		StringBuffer sb = new StringBuffer("");
		int i=1;
		HisUtil util = new HisUtil("MMS", "JobDetailsRptHLP");
		WebRowSet ws=vo.getWsViewDtl();
		try 
		{
			sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
			sb.append("<tr> "
	        + " <td colspan='1'></td>"
			+ " <td colspan='1'></td>"
			+ " <td colspan='1'><br><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
			sb.append("<tr> "
			+ " <td colspan='1'></td>"
			+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
			//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
			+ " <td colspan='1'></td>");
			sb.append("</tr></table>");		
			
			sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
				"<tr> "
				+ " <td colspan='3'></td>"
				+ " <td colspan='3'align='center' style='font-size:15px'><b>Job Details Report</b></td>"
				+ " <td colspan='3'></td>");
			sb.append("</tr>");
			
			
			sb.append(" <tr><td align='center' colspan='3'></td> " +
			"<td align='center' colspan='3'>" +
			"<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
			"For Type ::<b>"+vo.getStrTypeName()
			+"</b></font></td><td align='center' colspan='2'></td></tr>");
			
			
			sb.append(" <tr> "
			    + " <td colspan='1'></td>"
				+ " <td colspan='1'></td>"
				+ " <td colspan='1'><br></td>");
			sb.append("</tr>");				
			sb.append("</table> ");
			
			 
			sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
			
			if(ws != null && ws.size() > 0)
			{
				sb.append("<tr> ");
				sb.append("<td align='center' 	width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S No</b></font>.</td>");
				sb.append("<td align='center' 	width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Name</b></font></td>");  
				sb.append("<td align='center' 	width='55%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Error</b></font></td>");
				sb.append("</tr> ");
				   
					/*
					 * 1. JOB_NAME
					 * 2. Error
					 */
					while (ws.next()) 
					{			
						    sb.append("</tr> ");
							sb.append("<td align='center'  width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");   
							sb.append(i);  
							sb.append("</font></td> ");
							
							sb.append("<td align='center'  width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' >");   
							sb.append(ws.getString(1)); //JOB_NAME
							sb.append("</font></td> ");
							
							sb.append("<td align='center'  width='55%'><font face='Verdana, Arial, Helvetica, sans-serif' >");   
							sb.append(ws.getString(2)); //Error
							sb.append("</font></td> ");
								
							
							sb.append("</tr> ");	
							i++;					
				     }
			}
			else 
			{
				sb.append("<tr> ");
				sb.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");
			}
			sb.append("</table> ");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		finally {
		}
		return sb.toString();
	}
}
