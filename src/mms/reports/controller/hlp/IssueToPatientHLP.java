package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.controller.fb.IssueToPatientFB;
import mms.reports.vo.IssueToPatientVO;

public class IssueToPatientHLP {

	public static String getReplacementDetails(IssueToPatientFB fb,IssueToPatientVO vo) 
	{
		StringBuffer sb = new StringBuffer("");
	
		WebRowSet ws = vo.getWsItemCategoryCombo();
		int i=1;
		int dcount = 0;
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
					+"<td colspan='3' align='center' style='font-size:18px;font-weight:normal;font face:Verdana, Arial, Helvetica, sans-serif'>Issue To Patient Department Wise Report</td>"
					+ " <td colspan='3'></td>");
			sb.append("</tr>");
			
			sb.append(" <tr><td align='center' colspan='3'></td> " +
			  "<td align='center' colspan='3'>" +
			  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
			  "Store::<b>"+vo.getStrStoreName()
			  +"</b></font></td><td align='center' colspan='2'></td></tr>");
			  
			sb.append(" <tr><td align='center' colspan='3'></td> " +
			  "<td align='center' colspan='3'>" +
			  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
			  "For Item Category ::<b>"+vo.getStrItemCategoryName() 
			  +"</b></font></td><td align='center' colspan='2'></td></tr>");
			
			/*			sb.append("<tr>"
					+ "<td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "By User  ::<b>" + (vo.getStrUserName() != null && !vo.getStrUserName().isEmpty() ? vo.getStrUserName() : "N/A") + "</b></font></td>"
					+ "<td align='center' colspan='2'></td></tr>");
			
			sb.append("<tr>"
					+ "<td align='center' colspan='12'>"
					+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
					+ "Report Date & Time  ::<b>"+fb.getStrCurrentDate()+"</b></font></td></tr>");*/
			
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
			        sb.append("<td width='2%' ><b>S.No</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='8%' ><b>CR No</b>");
			        sb.append("</td>");
			        
				    sb.append("<td width='12%' ><b>Patient Name</b>");
				    sb.append("</td>");
				    
				    sb.append("<td width='5%' ><b>Age/Gender</b>");
				    sb.append("</td>");
				   
			        sb.append("<td width='10%' ><b>Issue No</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='8%' ><b>Issue Dt</b>");
			        sb.append("</td>");
	
			        sb.append("<td width='10%' ><b>Issue By</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='12%' ><b>Department</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='8%' ><b>Drug Count</b>");
			        sb.append("</td>");
			        
			        sb.append("<td width='8%' ><b>Net Amount</b>");
			        sb.append("</td>");
		
			        sb.append("</tr>");
		
				while(ws.next())
				{		
					if(i==0)
					{
						dcount = Integer.parseInt(ws.getString(8).trim());
						totalnetcost = Double.parseDouble(ws.getString(9).trim());
					}
					else
					{
						dcount = dcount + Integer.parseInt(ws.getString(8).trim());
						totalnetcost = totalnetcost + Double.parseDouble(ws.getString(9).trim());
					}
					
					
						/*	  MODEVAL_2 output procedure level
							1 	CR  
							2 	issue no
							3	iss dt
							4	pat name 
							5	age_sex
							6	pat _dept
							7	issueby 
							8	drug count
							9	net cost */
						
							sb.append("<tr>");
							sb.append("<td  width='2%' align='center' >");							
							sb.append(i);								            //	SL NO	
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='center' >");							
							sb.append(ws.getString(1));								//	CR 		
							sb.append("</td>");
	
							sb.append("<td  width='12%' align='center' >");							
							sb.append(ws.getString(4));								//	pat name
							sb.append("</td>");
							
							sb.append("<td  width='12%' align='center'>");								
							sb.append(ws.getString(5));								//	age gender				
							sb.append("</td>");
							
							sb.append("<td  width='15%' align='left'>");
							sb.append(ws.getString(2));								//	issue no
							sb.append("</td>");
							
							sb.append("<td  width='10%' align='center'>");								
							sb.append(ws.getString(3));							//	issue dt
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='center'>");
							sb.append(ws.getString(7));							//	issue by  
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='center'>");			
							sb.append(ws.getString(6));						// dept 
							sb.append("</td>");
							
							sb.append("<td  width='5%' align='center'>");
							sb.append(ws.getString(8));							//	drug count
							sb.append("</td>");
							
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(9) !=null && !ws.getString(9).isEmpty() ? ws.getString(9) : "-");//	net cost 
							sb.append("</td>");
	
							sb.append("</tr>");
							i++;
							
				} //while 
				
				sb.append("<tr>");
				
				sb.append("<td  colspan='8' align='right'><b> TOTAL </b>");
				sb.append("</td>");		
				
				sb.append("<td  colspan='1' align='center'>");
				sb.append(dcount);								
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
		    new HisException("Issue to Patient Report","IssueToPatientHLP.getReplacementDetails()-->",e.getMessage());
	  }
	return sb.toString();
	}
}