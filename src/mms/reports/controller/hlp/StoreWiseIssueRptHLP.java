package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.reports.vo.StoreWiseIssueRptVO;

public class StoreWiseIssueRptHLP 
{

	/* new Added dt on 30-06-23 */
	/* RJ47 */

	public static String getStoreWiseIssueDtlsRpt(WebRowSet ws,String hosCode, StoreWiseIssueRptVO VoObj) throws Exception 
	{

		System.out.println("--------------------- StoreWiseIssueRptHLP.getIssueDtls -------------------------------");
		StringBuffer sb = new StringBuffer("");
		int i=1,count=0;
		double totamt   = 0.00;
		int    Quantity = 0;
	
		try 
		{
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			sb.append("<table align='center' class='TABLEWIDTH' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr align='center' ><td width='100%'><div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' width='' style=''></div></td>");
			sb.append("</tr>");					
			sb.append("</table> ");
			
			sb.append("<br><table align='center' class='TABLEWIDTH 'border='0' cellspacing='0' cellpadding='0' height='69' ><tr><td align='center' colspan='3'></td> " +
			  "<td align='center' colspan='3'>" +
			  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
			  "For Store Name ::<b>"+VoObj.getStrStoreName()
			  +"</b></font></td><td align='center' colspan='2'></td></tr>"
			  
			  + " <tr><td align='center' colspan='3'></td> " +
			  "<td align='center' colspan='3'>" +
			  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
			  "For Item Category ::<b>"+VoObj.getStrItemCatName()
			  +"</b></font></td><td align='center' colspan='2'></td></tr>"
			  
			   + " <tr><td align='center' colspan='3'></td> " +
			  "<td align='center' colspan='3'>" +
			  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
			  "Request Type ::<b>"+VoObj.getStrRptType()
			  +"</b></font></td><td align='center' colspan='2'></td></tr>"
			  
			  +" <tr> <td align='center' colspan='3'></td>" +
			  "<td align='center' colspan='3'>" +
			  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
			  "From Date ::<b>"+VoObj.getStrFromDate()+"</b> To Date ::<b>"+
			  VoObj.getStrToDate()+"</b></font></td>" +"</table> ");
			 
			 
			sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
			
			if(ws != null && ws.size() > 0)
			{
				sb.append("<tr> ");
				sb.append("<td align='center' 	width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S No</b></font>.</td>");	
				
				sb.append("<td align='center' 	width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font></td>");
				sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font></td>");
				sb.append("<td align='center' 	width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indenting Store<br>[Issue No/Issue Date]</b></font></td>");
				

				//sb.append("<td align='center' 	width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue No <br>/Date</b></font></td>");
				sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
				
				sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate</b></font></td>");
				sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font></td>");
				sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font></td>");
				sb.append("</tr> ");
				   
					/*
					 * 1.ITEM_NAME
					 * 2.BATCH_NO
					 * 3.Indenting_Store 
					 * 4. ISSUE_No_DATE
					 * 4. Expiry_DATE
					 * 4. Rate
					 * 4. Issue_Qty 
					 * 4. Cost
					 */
					while (ws.next()) 
					{	
							if(i==0)
							{
								Quantity = Integer.parseInt(ws.getString(3));
								totamt = Double.parseDouble(ws.getString(11));
							}
							else
							{
								Quantity = Quantity + Integer.parseInt(ws.getString(3));
								totamt = totamt + Double.parseDouble(ws.getString(11));
							}		
						    sb.append("</tr> ");
							sb.append("<td align='center'  width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");   
							sb.append(i);  
							sb.append("</font></td> ");
							
							sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");   
							sb.append(ws.getString(1)); //ITEM_NAME
							sb.append("</font></td> ");
							
							sb.append("<td align='left'  width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");   
							sb.append(ws.getString(4)); //BATCH_NO
							sb.append("</font></td> ");
							
							sb.append("<td align='left'  width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");   
							sb.append(ws.getString(6) +"<br>["+ws.getString(2)+"]");  //Indenting_Store -substore
							sb.append("</font></td> ");
							
							//sb.append("<td align='center'  width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"); 
							//sb.append(ws.getString(2).split("\\/")[1]); sb.append("</font></td> ");
							
							sb.append("<td align='center'  width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");   
							sb.append(ws.getString(14)); //Expiry_DATE
							sb.append("</font></td> ");
							
							sb.append("<td align='center'  width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");   
							sb.append(ws.getString(8)); //Rate
							sb.append("</font></td> ");
														
							sb.append("<td align='center'  width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");  
							sb.append(ws.getString(3)); // Issue_Qty
							sb.append("</font></td> ");	
							
							sb.append("<td align='right'  width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");  
							sb.append(ws.getString(11)); // Cost
							sb.append("</font></td> ");		
							
							
							sb.append("</tr> ");	
							i++;
							count++;					
				     }
				sb.append("<tr>");
				
				sb.append("<td  colspan='6' align='right'><b> Total : </b>");
				sb.append("</td>");				
				
				sb.append("<td  colspan='1' align='center'><b>");
				sb.append(Quantity);								
				sb.append("</b></td>");			
			
				sb.append("<td  colspan='1' align='right'><b>");
				sb.append(totamt);								
				sb.append("</b></td>");
				
				sb.append("</tr>");
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


