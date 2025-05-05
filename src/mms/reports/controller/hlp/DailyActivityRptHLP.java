package mms.reports.controller.hlp;

import hisglobal.utility.HisUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.DailyActivityRptVO;

public class DailyActivityRptHLP
{
	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getDailyActivityPrint(DailyActivityRptVO vo) throws Exception 
	{
		StringBuffer sb = new StringBuffer("");
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		double cltamt1  = 0.00;
		double totalCost1 = 0.00;
		String strItemTotCost1="0.00";
		
		double cltamt2  = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost2="0.00";
		int i=1;
		int count = 0;
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		WebRowSet ws = vo.getStrIssueDtlWs();
		String strTableWidth = "700";
		HisUtil util = new HisUtil("",""); 
 		try 
		{
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			
			sb.append("<tr>");
			//sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");	
			sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");	
		
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Activity Report");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Selected Store:: ");
			sb.append(vo.getStrStoreName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Between ");
			sb.append(vo.getStrFromDate()+"  And  " +vo.getStrToDate());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			
//			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//			sb.append("<tr> ");
//			sb.append("<td align='right'>");
// 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
//			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(6);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//			sb.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(6);' /> </div></div>");
//			sb.append(" </td> ");
//			sb.append(" </tr> ");
//			sb.append(" </table> ");
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(6);' /> <img style='cursor: pointer; ' title='Get Back Report'  ");
			sb.append("src='../../hisglobal/images/stop.png' onClick='closePopup(6);' /></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
			sb.append(" <br> ");
		
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='27%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>DWH Name</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='18%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Issue Voucher</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Received Count</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sample Sent Count</b></font> ");
			sb.append("</td> ");//Brahmam
			
			sb.append("</tr> ");
			NumberFormat formatter = new DecimalFormat("############.##");  
			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					/* Value Pass in Web Row Set
			    	   1. Issue Count
			    	   2. Receive Count
		               3. DWH Name
		               4. Store ID		             
		           	 */ 						
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5);	
					String IssueCount = ws.getString(1);
					String ReceiveCount = ws.getString(2);
					if(!IssueCount.equals("0") || !ReceiveCount.equals("0") )
					{		
						    
							sb.append("<tr> ");
							sb.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
							sb.append("<td style=\"text-align:center;\" width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							sb.append(i);
							sb.append("</font></td> ");
							sb.append("<td  style=\"text-align:left;\"  width='27%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							sb.append(ws.getString(3));
							sb.append("</font></td>");
							sb.append("<td style=\"text-align:center;\" width='18%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							sb.append(ws.getString(1));
							sb.append("</font></td> ");
							sb.append("<td style=\"text-align:center;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							sb.append(ws.getString(2));
							sb.append("</font></td> ");
							sb.append("<td style=\"text-align:center;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							sb.append(ws.getString(5));
							sb.append("</font></td> ");
							
						
							sb.append("</tr> ");
							i++;
							count++;
							
							strItemTotCost = formatter.format(new BigDecimal(ws.getString(1)));  
							cltamt  = Double.parseDouble(strItemTotCost);
							
							totalCost = totalCost + cltamt;
							
							strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(2)));  
							cltamt1  = Double.parseDouble(strItemTotCost1);
							
							totalCost1 = totalCost1 + cltamt1;
							
							strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(5)));  
							cltamt2  = Double.parseDouble(strItemTotCost2);
							
							totalCost2 = totalCost2 + cltamt2;
					}					
					
								
				}
					
					
				    
				    NumberFormat formatter1 = new DecimalFormat("############.##");
					String FinaltotalCost = formatter1.format(new BigDecimal(totalCost));  
					String FinaltotalCost1 = formatter1.format(new BigDecimal(totalCost1)); 
					String FinaltotalCost2 = formatter1.format(new BigDecimal(totalCost2));
					
					
					
					
					sb.append("<tr>");
					sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' ></td>");
					sb.append("<td align='center' width='39%'><font face='Verdana, Arial, Helvetica, sans-serif' >Total(s)</font></td>");
					sb.append("<td style=\"text-align:center;\" width='18%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+FinaltotalCost+"</b></font></td>");
					sb.append("<td style=\"text-align:center;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+FinaltotalCost1+"</b></font></td>");
					sb.append("<td style=\"text-align:center;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+FinaltotalCost2+"</b></font></td>");
					sb.append("</tr>");		
					
					
				
			}	
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}
	
	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getIssueVoucherDtlPopUpOne(DailyActivityRptVO vo) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		double cltamt  = 0.00;
		double totalCost = 0.00;
		int i=1;
		int count = 0;
		String strItemTotCost="0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		WebRowSet ws = vo.getStrIssueVoucherDtlOneWS();
		String strHiddenValue = vo.getStrIssueVoucherHiddenVal();
 		String strTableWidth = "700";

		try 
		{
            sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			
			sb.append("<tr>");
			//sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");	
			sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");	
		
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Activity Report");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>For : ");
			sb.append(vo.getStrStoreName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Between  ");
			sb.append(vo.getStrFromDate()+"  And " +vo.getStrToDate());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			
//			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//			sb.append("<tr> ");
//			sb.append("<td align='right'>");
// 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
//			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(1);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//			sb.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(1);' /> </div></div>");
//			sb.append(" </td> ");
//			sb.append(" </tr> ");
//			sb.append(" </table> ");
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(1);' /> <img style='cursor: pointer; ' title='Get Back Report'  ");
			sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(1);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' /></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");			
			sb.append(" <br> ");		
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Institute Name</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Issue Voucher Count</b></font> ");
			sb.append("</td> ");
			
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					
					/*
					1.ISSUE_TO(Institution Name),
					2.HSTNUM_REQ_STOREID
					3.COUNT(HSTNUM_ISSUE_NO),
					4.HSTNUM_STORE_ID,
					5.STORE_NAME
					++++++++++++++++++++++++++++++++++++++++++++
			    	6. Issue Count
			    	7. Receive Count
		            8. DWH Name
		            9. Store ID
					*/
							
//					NumberFormat formatter = new DecimalFormat("############.##");  
//					strItemTotCost = formatter.format(new BigDecimal(ws.getString(3)));  
//					cltamt  = Double.parseDouble(strItemTotCost);
//					totalCost = totalCost + cltamt;
					
					String strIssueVoucherOneHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+strHiddenValue;		
					sb.append("<tr> ");
					sb.append("<input type='hidden' name='strIssueVoucherOneHidValue' id='strIssueVoucherOneHidValue"+count+"' value='"+strIssueVoucherOneHidValue+"'>");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					sb.append("<td style=\"text-align:left;\" width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strInstituteName' id='strInstituteName"+count+"' onClick='getInstituteIssueDtl(\""+count+"\")'>"+ws.getString(1)+"</a>");
					sb.append("</font></td>");
					sb.append("<td align='center' width='40%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");					
					sb.append("</tr> ");
					i++;
					count++;
								
				}
					
					//NumberFormat formatter = new DecimalFormat("############.##");  
				    
					//String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					
					/*sb.append("<tr>");
					sb.append("<td colspan='2' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total PO Value(Rs.)</b></font></td>");
					sb.append("<td colspan='2' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(FinaltotalCost);				
					sb.append("</font></td>");
					sb.append("</tr>");
					*/
								
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

		return sb.toString();
	}
	
	
	
	
	public static String getIssueDetails(WebRowSet ws) throws Exception 
	{
	
	StringBuffer br = new StringBuffer();
	int count = 0;
	int start = 1;
	final int REC_PER_PAGE = 100;
	final int PAGE_PER_BLOCK = 100;
	double cltamt  = 0.00;
	double totalCost = 0.00;
	String strItemTotCost="0.00";
	
	double cltamt1  = 0.00;
	double totalCost1 = 0.00;
	String strItemTotCost1="0.00";
	
	double cltamt2  = 0.00;
	double totalCost2 = 0.00;
	String strItemTotCost2="0.00";
	
	int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
	int totalRecordsToManipulate = totalFetchRecord - 1;
	try
    {
		
		br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
	 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Consolidated Issue Details</td></tr></table>");	
	if (ws != null) 
	{
		if(ws.size() != 0)
		{
		 int actualFetchRecord = ws.size();
	
         if(totalFetchRecord != actualFetchRecord)
		 {
			totalFetchRecord = actualFetchRecord;
			totalRecordsToManipulate = actualFetchRecord;
		 }
		 int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
		 int reminder = totalRecordsToManipulate % REC_PER_PAGE;
		 if (reminder > 0)
			totalLayer = totalLayer + 1;
		 
		    br.append("<input type='hidden' name='TotalLayer'  value='"+totalLayer+"'>");
		    br.append("<input type='hidden' name='RecordShowOnPage'  value='"+REC_PER_PAGE+"'>");
		    br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
		 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
		 br.append("<tr>");
		 br.append("<td class='LABEL'>");
		 NumberFormat formatter = new DecimalFormat("############.##");  
		 
		 for (int i = 1; i <= totalLayer; i++)
		 {
			br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
					+ "</a>|&nbsp;");
		 }
		br.append("</td></tr>");
		br.append("</table>");			
		
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			//br.append("<tr class='TITLE'>");
			//br.append("<td colspan='4'></td></tr>");
			br.append("<tr>");
			
			br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Sl No.</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='30%'>DWH Name</td>");
    		br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Total Issue Voucher</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Total Received Count</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Sample Sent Count</td>");
		
			
			br.append("</tr>");
			br.append("</table>");
	    for (int i = 1; i <= totalLayer; i++) 
	    {
		 if (i <= totalLayer) 
		 {
			 
			if (i == 1) 
			{
				br.append("<div id='DivId" +i+ "' style='display:block'>");
			} 
			else
			{
				br.append("<div id='DivId" +i+ "' style='display:none'>");
			}
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			for (int j = 0; j < REC_PER_PAGE; j++) 
			{
				if(ws.next())
				{
					
					 /* Value Pass in Web Row Set
			    	   1. Issue Count
			    	   2. Receive Count
		               3. DWH Name
		               4. Store ID
		             
		           	 */    	 	
					
					////System.out.println("HLP"+ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5))	;					
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5);	
					String IssueCount = ws.getString(1);
					String ReceiveCount = ws.getString(2);
					String SampleSentCount = ws.getString(5);
										
					if(!IssueCount.equals("0") || !ReceiveCount.equals("0")|| !SampleSentCount.equals("0") )
					{
						br.append("<tr>");
						br.append("<input type='hidden' name='demandFlg'  value='1'>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
						br.append("<td class='multiControl' colspan='1' width='10%'>");
						br.append(start);
						//br.append("<input type='radio' name='checkid' id='checkid"+count+"' value='0' onClick='chkBoxClick(this,\""+count+"\");'> </td>");
						br.append("</td>");
						
						br.append("<td class='multiControl' style=\"text-align:left;\" colspan='1' width='30%'>"+ws.getString(3)+"</td>");
						br.append("<td class='multiControl' style=\"text-align:center;\" colspan='1' width='20%'>");
						br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' title='Get Issue Voucher Details' name='strTotalIssue' id='strTotalIssue"+count+"' onClick='chkBoxClick(1,this,\""+count+"\")'>"+ws.getString(1)+"</a> &nbsp;");
						br.append("</td>");
						
						br.append("<td class='multiControl' style=\"text-align:center;\" colspan='1' width='20%'>");
						br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' title='Get Receive Voucher Details' name='strTotalReceive' id='strTotalReceive"+count+"' onClick='chkBoxClick(2,this,\""+count+"\")'>"+ws.getString(2)+"</a> &nbsp;");
						br.append("</td>");
						br.append("<td class='multiControl' style=\"text-align:center;\" colspan='1' width='20%'>");
						br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' title='Get Sample Send Details' name='strTotalReceive' id='strTotalReceive"+count+"' onClick='chkBoxClick(3,this,\""+count+"\")'>"+ws.getString(5)+"</a> &nbsp;");
						br.append("</td>");
											
						
						br.append("</tr>");
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(1)));  
						cltamt  = Double.parseDouble(strItemTotCost);
						
						totalCost = totalCost + cltamt;
						
						strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(2)));  
						cltamt1  = Double.parseDouble(strItemTotCost1);
						
						totalCost1 = totalCost1 + cltamt1;
						
						strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(5)));  
						cltamt2  = Double.parseDouble(strItemTotCost2);
						
						totalCost2 = totalCost2 + cltamt2;
						
						
						count++ ;
						start++;
					}
				}else{
					break;
				}
			}
				br.append("</table>");
				String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
				String FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1));  
				String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2));
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				
				if(FinaltotalCost.equals("0") && FinaltotalCost1.equals("0")&& FinaltotalCost2.equals("0"))
		           	 br.append("<tr><td class='multiControl' colspan='4'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
					
				else
				{
					br.append("<tr><td CLASS='multiLabel' colspan='1' width='10%'></td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='30%'>Total</td>");
		    		br.append("<td CLASS='multiLabel' colspan='1' width='20%'>"+FinaltotalCost+"</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>"+FinaltotalCost1+"</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>"+FinaltotalCost2+"</td></tr>");
	
				}
								
				
				br.append("</table>");
				br.append("</div>");

		} 
		else 
		{
			br.append("<div id='DivId" + i+ "' style='display:none'>");
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			for (int k = 0; k < reminder; k++) 
			{
				ws.next();

				/* Value Pass in Web Row Set
		    	   1. Issue Count
		    	   2. Receive Count
	               3. DWH Name
	               4. Store ID
	             
	           	 */ 
				String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5);	
				String IssueCount = ws.getString(1);
				String ReceiveCount = ws.getString(2);
				String SampleSentCount = ws.getString(5);
								
				if(!IssueCount.equals("0") || !ReceiveCount.equals("0")|| !SampleSentCount.equals("0") )
				{
						br.append("<tr>");
						br.append("<input type='hidden' name='demandFlg'  value='1'>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
						br.append("<td class='multiControl' colspan='1' width='10%'><b>");
						br.append(start);
						br.append("</td>");						
						br.append("<td class='multiControl' style=\"text-align:left;\" colspan='1' width='30%'>"+ws.getString(3)+"</td>");
						br.append("<td class='multiControl' style=\"text-align:center;\" colspan='1' width='20%'>");
						br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' title='Get Issue Voucher Details' name='strTotalIssue' id='strTotalIssue"+count+"' onClick='chkBoxClick(1,this,\""+count+"\")'>"+ws.getString(1)+"</a> &nbsp;");
						br.append("</td>");
						
						br.append("<td class='multiControl' style=\"text-align:center;\" colspan='1' width='20%'>");
						br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' title='Get Receive Voucher Details' name='strTotalReceive' id='strTotalReceive"+count+"' onClick='chkBoxClick(2,this,\""+count+"\")'>"+ws.getString(2)+"</a> &nbsp;");
						br.append("</td>");
						
						br.append("<td class='multiControl' style=\"text-align:center;\" colspan='1' width='20%'>");
						br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' title='Get Receive Voucher Details' name='strTotalReceive' id='strTotalReceive"+count+"' onClick='chkBoxClick(2,this,\""+count+"\")'>"+ws.getString(5)+"</a> &nbsp;");
						br.append("</td>");
											
						
						br.append("</tr>");
						
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(1)));  
						cltamt  = Double.parseDouble(strItemTotCost);
						
						totalCost = totalCost + cltamt;
						
						strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(2)));  
						cltamt1  = Double.parseDouble(strItemTotCost1);
						
						totalCost1 = totalCost1 + cltamt1;
						
						strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(5)));  
						cltamt2  = Double.parseDouble(strItemTotCost2);
						
						totalCost2 = totalCost2 + cltamt2;
						
						count++ ;
						start++;
				}
			}
			br.append("</table>");
			String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
			String FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1));
			String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2));
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'><tr>");
			br.append("<td CLASS='multiLabel' colspan='1' width='10%'></td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='30%'>Total</td>");
    		br.append("<td CLASS='multiLabel' colspan='1' width='20%'>"+FinaltotalCost+"</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='20%'>"+FinaltotalCost1+"</td></tr>");
			br.append("<td CLASS='multiLabel' colspan='1' width='20%'>"+FinaltotalCost2+"</td></tr>");
			
			br.append("</table>");
			br.append("</div>");

			}
	   	}
		  br.append("</div>");
		}
		else
		{
			 
			 br.append("<div id='prevTechEntryDtlId' style='display:none;'>");
			 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			 br.append("<tr>");
			 
			 br.append("<td CLASS='multiLabel' colspan='1' width='10%'></td>");
			 br.append("<td CLASS='multiLabel' colspan='1' width='30%'>DWH Name</td>");
	    	 br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Total Issue Voucher</td>");
			 br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Total Received Count</td>");
			 br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Sample Sent Count</td>");
			
				
			 
			 br.append("</tr>");
			 br.append("<input type='hidden' name='demandFlg'  value='0'>");
           	 br.append("<tr>");  
           	 br.append("<td class='multiControl' colspan='6'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
           	 br.append("</table>");
           	 br.append("</div>");
				
		   }
		} 
     }
	
catch (Exception e) 
{	e.printStackTrace();
	 
		throw new Exception("OffLineIssueIndentTransHLP.getPODetails()->"+e.getMessage());
	}
	return br.toString();
}
	
	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getIssueNoDetailsPopUp(DailyActivityRptVO vo) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		double cltamt  = 0.00;
		double totalCost = 0.00;
		int i=1;
		int count = 0;
		String strItemTotCost="0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		WebRowSet ws = vo.getStrIssueVoucherDtlThreeWS();
		String strHiddenValue = vo.getStrIssueVoucherHiddenVal();
 		String strTableWidth = "700";
 		DecimalFormat myFormatter = new DecimalFormat("0.00");

		try 
		{								
            sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr>");
//			sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");		
			sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");	
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Activity Report");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> From DDW Name : ");/*Brahmam*/
			sb.append(vo.getStrStoreName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> To Institute :: ");
			sb.append(vo.getStrReqStoreName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Against Issue No :: ");
			sb.append(vo.getStrIssueVoucherHiddenVal().split("\\^")[0]);
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Between ");
			sb.append(vo.getStrFromDate()+"  And  " +vo.getStrToDate());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
//			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//			sb.append("<tr> ");
//			sb.append("<td align='right'>");
// 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
//			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(3);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//			sb.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(3);' /> </div></div>");
//			sb.append(" </td> ");
//			sb.append(" </tr> ");
//			sb.append(" </table> ");
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(3);' /> <img style='cursor: pointer; ' title='Get Back Report'  ");
			sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(3);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(3);' /></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
			sb.append(" <br> ");		
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Value</b></font> ");
			sb.append("</td> ");
			
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					
					/* 1. Issue No
			    	   2. Issue Date  
		               3.  Issue To Store ,
		               4. Store Name 
		               5. Genric Item Name
		               6. Item Brand Name
		               7. Batch No 
		               8. Exp
		               9. Rate
		               10.Issue Qty
		               11. Store ID
		               12.Item Id
		               13.Item Brand Id
		               14.Batch Sl No
		               15.Exp Date
		               16.Rate
		               17.Rate Unit Id
		               18.Rate Base Value
		               19.Issue Qty
		               20.Issue Qty Unit Id
		               21.Qty Base Value
		               22.Item Sl No
		               23.Item Sl No
		               24.Category Code
		               25.Balance Qty
		               26.Remarks
		               27.Recevide By
		               28.Issue By
		               29.Final remarks
		               30.Cost
		               31.Issue TO Avl Budget 
		                +++++++++++++++Hidden Value+++++++++++++++++++++++++++++ 
						32.HSTNUM_ISSUE_NO,
						33.ISSUE_DATE,
						34.INDENT_NO,
						35.ISSUED_VALUE,
						36.STORE_ID,
						37.STORE_NAME,
						38.HSTNUM_REQ_STOREID,
						39.REQ_STORE
						40.ISSUE_TO(Institution Name),
						41.HSTNUM_REQ_STOREID
						42.COUNT(HSTNUM_ISSUE_NO),
						43.HSTNUM_STORE_ID,
						44.STORE_NAME
				    	45. Issue Count
				    	46. Receive Count
			            47. DWH Name
			            48. Store ID
			       */
					
							
					NumberFormat formatter = new DecimalFormat("############.##");  
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(30)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					totalCost = totalCost + cltamt;
					
					String strInstituteIssueHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+strHiddenValue;		
					sb.append("<tr> ");
					sb.append("<input type='hidden' name='strInstituteIssueHidValue' id='strInstituteIssueHidValue"+count+"' value='"+strInstituteIssueHidValue+"'>");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					sb.append("<td style=\"text-align:left;\" width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(6));
					sb.append("</font></td>");
					sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");		
					
					sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(10));
					sb.append("</font></td>");
										
					sb.append("<td style=\"text-align:right;\" width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(30))));
					sb.append("</font></td> ");	
					
					
					sb.append("</tr> ");
					i++;
					count++;
								
				}
					
				    NumberFormat formatter1 = new DecimalFormat("############.##");
				    
					String FinaltotalCost = formatter1.format(new BigDecimal(totalCost));  
					String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost)) ) + ")";
					
					sb.append("<tr>");
					sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Rs.)</b></font></td>");
					sb.append("<td colspan='1' style=\"text-align:right;\" ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(FinaltotalCost);				
					sb.append("</b></font></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Words)</b></font></td>");
					sb.append("<td colspan='1' style=\"text-align:right;\" ><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(amtStr1);				
					sb.append("</font></td>");
					sb.append("</tr>");
					
								
			}	
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}

	
	
	
	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getInstituteIssueDetailsPopUp(DailyActivityRptVO vo) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		double cltamt  = 0.00;
		double totalCost = 0.00;
		int i=1;
		int count = 0;
		String strItemTotCost="0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		WebRowSet ws = vo.getStrIssueVoucherDtlTwoWS();
		String strHiddenValue = vo.getStrIssueVoucherHiddenVal();
 		String strTableWidth = "700";
 		DecimalFormat myFormatter = new DecimalFormat("0.00");

		try 
		{		
            sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			
			sb.append("<tr>");
//			sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");	
			sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");	
		
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Activity Report");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> From DDW Name : ");/*Brahmam*/
			sb.append(vo.getStrStoreName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Institute :: ");
			sb.append(vo.getStrIssueVoucherHiddenVal().split("\\^")[0]);
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Between ");
			sb.append(vo.getStrFromDate()+"  And  " +vo.getStrToDate());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			
//			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//			sb.append("<tr> ");
//			sb.append("<td align='right'>");
// 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
//			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(2);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//			sb.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(2);' /> </div></div>");
//			sb.append(" </td> ");
//			sb.append(" </tr> ");
//			sb.append(" </table> ");
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(2);' /> <img style='cursor: pointer; ' title='Get Back Report'  ");
			sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(2);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(2);' /></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
			sb.append(" <br> ");		
			
		///////////////////////////////////////////////////////////////////////////
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue No</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Date</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent No</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Value</b></font> ");
			sb.append("</td> ");
			
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					
					/*
					
					1. HSTNUM_ISSUE_NO,
					2.ISSUE_DATE,
					3.INDENT_NO,
					4.ISSUED_VALUE,
					5.STORE_ID,
					6.STORE_NAME,
					7.HSTNUM_REQ_STOREID,
					8.REQ_STORE

					+++++++++++++++Hidden Value+++++++++++++++++++++++++++++ 
					9.ISSUE_TO(Institution Name),
					10.HSTNUM_REQ_STOREID
					11.COUNT(HSTNUM_ISSUE_NO),
					12.HSTNUM_STORE_ID,
					13.STORE_NAME
					++++++++++++++++++++++++++++++++++++++++++++
			    	14. Issue Count
			    	15. Receive Count
		            16. DWH Name
		            17. Store ID
					*/
							
					NumberFormat formatter = new DecimalFormat("############.##");  
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(4)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					totalCost = totalCost + cltamt;
					
					String strInstituteIssueHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+strHiddenValue;		
					sb.append("<tr> ");
					sb.append("<input type='hidden' name='strInstituteIssueHidValue' id='strInstituteIssueHidValue"+count+"' value='"+strInstituteIssueHidValue+"'>");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					sb.append("<td align='center' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strInstituteName' id='strIssueNo"+count+"' onClick='getIssueNoDetails(\""+count+"\")'>"+ws.getString(1)+"</a>");
					sb.append("</font></td>");
					sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(2));
					sb.append("</font></td> ");		
					
					sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3));
					sb.append("</font></td>");
					sb.append("<td style=\"text-align:right;\" width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(4))));
					sb.append("</font></td> ");	
					sb.append("</tr> ");
					i++;
					count++;
								
				}
					
					
					NumberFormat formatter1 = new DecimalFormat("############.##");
					String FinaltotalCost = formatter1.format(new BigDecimal(totalCost));  
					String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost)) ) + ")";
					sb.append("<tr>");
					sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Issued Value(Rs.)</b></font></td>");
					sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));				
					sb.append("<b></font></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Issued Value(Words)</b></font></td>");
					sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(amtStr1);				
					sb.append("</font></td>");
					sb.append("</tr>");
					
								
			}	
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}
	
	
	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getRecieveVoucherDtlPopUpOne(DailyActivityRptVO vo) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		int cltamt1  = 0;
		int totalCost1 = 0;
		String strItemTotCost1="0";		
		int i=1;
		int count = 0;		
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		WebRowSet ws = vo.getStrReceiveVoucherDtlOneWS();
		String strHiddenValue = vo.getStrReceiveVoucherHiddenVal();
 		String strTableWidth = "700";
 		DecimalFormat myFormatter = new DecimalFormat("0.00");
		try 
		{
	
	           sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				
				sb.append("<tr>");
//				sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");		
				sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
				sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				sb.append(res.getString("REPORT_TITLE"));
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");	
			
				sb.append("<tr> ");
				sb.append("<td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				sb.append(res.getString("FULL_TITLE"));
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				sb.append(res.getString("CITY"));
				sb.append("</font></b></td><td width='10%'>&nbsp; ");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				sb.append("<tr><td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Activity Report");
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				sb.append("<tr><td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>For :: ");
				sb.append(vo.getStrReceiveVoucherHiddenVal().split("\\^")[2]);
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
		
				sb.append("<tr><td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Between ");
				sb.append(vo.getStrFromDate()+"  And  " +vo.getStrToDate());
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				
//				sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//				sb.append("<tr> ");
//				sb.append("<td align='right'>");
//	 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//				sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
//				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(4);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//				sb.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(4);' /> </div></div>");
//				sb.append(" </td> ");
//				sb.append(" </tr> ");
//				sb.append(" </table> ");
				
				sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='right'>");
	 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(4);' /> <img style='cursor: pointer; ' title='Print Report'  ");
				sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(4);'  /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(4);' /></div></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");
				sb.append(" <br> ");		
		
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No</b></font> ");
			sb.append("</td>");

			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Date</b></font> ");
			sb.append("</td>");
			
			sb.append("<td align='center' width='17%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplied Value</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier Name</b></font> ");
			sb.append("</td>");
			
			sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Count</b></font> ");
			sb.append("</td> ");
			
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					
					/*
					1.Supplier Name,
					2.Supplier Id,
					3.PO With Ref No,
					4.PO Date,
					5.PO No
					6.Supplied Value
					7.Received Count
					++++++++++++++++++++++++++++++++++++++++++++
			    	8. Issue Count
			    	9. Receive Count
		            10. DWH Name
		            11. Store ID
		            12.Sample Sent Count
					*/
							
					NumberFormat formatter = new DecimalFormat("############.##");  
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(6)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					totalCost = totalCost + cltamt;
					
					//strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(7)));  
					cltamt1  = Integer.parseInt(ws.getString(7));
					totalCost1 = totalCost1 + cltamt1;
					
					String strReceiveVoucherOneHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+strHiddenValue;
					////System.out.println("strReceiveVoucherOneHidValue"+strReceiveVoucherOneHidValue);
					sb.append("<tr> ");
					sb.append("<input type='hidden' name='strReceiveVoucherOneHidValue' id='strReceiveVoucherOneHidValue"+count+"' value='"+strReceiveVoucherOneHidValue+"'>");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					sb.append("<td align='left' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strPoNumber' id='strPoNumber"+count+"' onClick='getPoChallanDtl(\""+count+"\")'>"+ws.getString(3)+"</a>");
					sb.append("</font></td>");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(4));
					sb.append("</font></td> ");		
					
					sb.append("<td style=\"text-align:right;\" width='17%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(6))));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:left;\" width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(1));
					sb.append("</font></td> ");	
					
					sb.append("<td style=\"text-align:center;\" width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");	
					
											
					sb.append("</tr> ");
					i++;
					count++;
								
				}
					
				    NumberFormat formatter1 = new DecimalFormat("############.##");
					String FinaltotalCost  = formatter1.format(new BigDecimal(totalCost));  
					//String FinaltotalCost1 = formatter1.format(new BigDecimal(totalCost1));  
					String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost))  ) + ")";
					String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost1)) ) + ")";
					
					sb.append("<tr>");
					sb.append("<td colspan='3'  align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Rs.)</b></font></td>");
					sb.append("<td colspan='1'  style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(FinaltotalCost);
					sb.append("</b></font></td>");
					sb.append("<td colspan='1'  align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Count</b></font></td>");
					
					
					sb.append("<td colspan='1' style=\"text-align:center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(totalCost1);				
					sb.append("</b></font></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='3' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Words)</b></font></td>");
					sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(amtStr1);				
					sb.append("</font></td>");
					sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(amtStr2);				
					sb.append("</font></td>");
					sb.append("</tr>");
					
								
			}	
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
        
		return sb.toString();
	}
	
	
	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getPOChallanDetails(DailyActivityRptVO vo) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		double cltamt1  = 0.00;
		double totalCost1 = 0.00;
		String strItemTotCost1="0.00";		
		int i=1;
		int count = 0;	
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		WebRowSet ws = vo.getStrPOChallanItemDtlWs();
		String strHiddenValue = vo.getStrReceiveVoucherHiddenVal();
 		String strTableWidth = "700";
 		DecimalFormat myFormatter = new DecimalFormat("0.00");
 		HisUtil util = new HisUtil("","");
		try 
		{
	
	           sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				
				sb.append("<tr>");
//				sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");	
				sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
				sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				sb.append(res.getString("REPORT_TITLE"));
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");	
			
				sb.append("<tr> ");
				sb.append("<td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				sb.append(res.getString("FULL_TITLE"));
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				sb.append(res.getString("CITY"));
				sb.append("</font></b></td><td width='10%'>&nbsp; ");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				sb.append("<tr><td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Activity Report");
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				sb.append("<tr><td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>For :: ");
				sb.append(vo.getStrReceiveVoucherHiddenVal().split("\\^")[9]);
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				
				sb.append("<tr><td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Against PO No.  ");
				sb.append(vo.getStrReceiveVoucherHiddenVal().split("\\^")[2]);
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
		
				sb.append("<td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Between ");
				sb.append(vo.getStrFromDate()+"  And  " +vo.getStrToDate());
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				
//				sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//				sb.append("<tr> ");
//				sb.append("<td align='right'>");
//	 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//				sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
//				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(5);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//				sb.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(5);' /> </div></div>");
//				sb.append(" </td> ");
//				sb.append(" </tr> ");
//				sb.append(" </table> ");
				
				sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='right'>");
	 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(5);' /> <img style='cursor: pointer; ' title='Get Back Report'  ");
				sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(5);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(5);' /></div></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");
				sb.append(" <br> ");		
		
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Delivery Challan No</b></font> ");
			sb.append("</td>");

			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan Date</b></font> ");
			sb.append("</td>");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Date</b></font> ");
			sb.append("</td>");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>No. Of Cartoons</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplied Value</b></font> ");
			sb.append("</td> ");
			
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{
				NumberFormat formatter = new DecimalFormat("############.##");  

				while (ws.next()) 
				{
					
					/*
					1.Recipt No(Challan)
					2.Challan No
					3.Challan Date
					4.Received Date
					5.No Packet
					6.Supplied Value(SUM)
					+++++++++++++++++++++++++++  
					7.Supplier Name,
					8.Supplier Id,
					9.PO With Ref No,
					10.PO Date,
					11.PO No
					12.Supplied Value
					13.Received Count
					++++++++++++++++++++++++++++++++++++++++++++
			    	14. Issue Count
			    	15. Receive Count
		            16. DWH Name
		            17. Store ID
		            18.Sample Sent Count
					*/		
					
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(6)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					totalCost = totalCost + cltamt;
										
					
				String strReceiveVoucherTwoHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+strHiddenValue;		
					////System.out.println("POPUP CHALLAN"+strReceiveVoucherTwoHidValue);
				    sb.append("<tr> ");
					sb.append("<input type='hidden' name='strReceiveVoucherTwoHidValue' id='strReceiveVoucherTwoHidValue"+count+"' value='"+strReceiveVoucherTwoHidValue+"'>");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					sb.append("<td align='center' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strChallanNumber' id='strChallanNumber"+count+"' onClick='getChallanItemsDtl(\""+count+"\")'>"+ws.getString(1)+"</a>");
					sb.append("</font></td>");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");		
					
					sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(4));
					sb.append("</font></td> ");	
					
					sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(5));
					sb.append("</font></td> ");	
					
					sb.append("<td style=\"text-align:right;\" width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(6))));
					sb.append("</font></td> ");		
											
					sb.append("</tr> ");
					i++;
					count++;
					
								
				}	
				
				
				NumberFormat formatter1 = new DecimalFormat("############.##");
				String FinaltotalCost  = formatter1.format(new BigDecimal(totalCost));  
				String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost)) )+ ")";				
				
				sb.append("<tr>");
				sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Rs.)</b></font></td>");
				
				sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
				sb.append(FinaltotalCost);				
				sb.append("</b></font></td>");
				sb.append("</tr>");
				
				sb.append("<tr>");
				sb.append("<td colspan='3' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Words)</b></font></td>");
				sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append("</font></td>");
				sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(amtStr1);				
				sb.append("</font></td>");
				sb.append("</tr>");
					
								
			}	
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='5' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}
        
		return sb.toString();
	}
	
	
	/**
	 * Gets the issue dtls init view.
	 * 
	 * @param formBean
	 *            the form bean
	 * 
	 * @return the issue dtls init view
	 * 
	 * @throws Exception
	 *             the exception
	 */
	public static String getChallanItemDetails(DailyActivityRptVO vo) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		int i=1;
		int count = 0;	
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		WebRowSet ws = vo.getStrChallanItemDtlWs();
		String strTableWidth = "700";
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
 		DecimalFormat myFormatter = new DecimalFormat("0.00");
 		HisUtil  util = new HisUtil("","");
		try 
		{
	
	            sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				
				sb.append("<tr>");
//				sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");	
				sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
				sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				sb.append(res.getString("REPORT_TITLE"));
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");	
			
				sb.append("<tr> ");
				sb.append("<td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				sb.append(res.getString("FULL_TITLE"));
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				sb.append("<tr> ");
				sb.append("<td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
				sb.append(res.getString("CITY"));
				sb.append("</font></b></td><td width='10%'>&nbsp; ");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				sb.append("<tr><td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Activity Report");
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
								
				sb.append("<tr><td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>For :: ");
				sb.append(vo.getStrReceiveVoucherHiddenVal().split("\\^")[15]);
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");				
				sb.append("<tr><td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Against PO No.  ");
				sb.append(vo.getStrReceiveVoucherHiddenVal().split("\\^")[8]);
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td>");
				sb.append("</tr> ");
				
				sb.append("<tr><td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>And Challan No.  ");
				sb.append(vo.getStrReceiveVoucherHiddenVal().split("\\^")[0]);
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				
				sb.append("<tr><td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Between ");
				sb.append(vo.getStrFromDate()+"  And  " +vo.getStrToDate());
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				
//				sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//				sb.append("<tr> ");
//				sb.append("<td align='right'>");
//	 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//				sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
//				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(10);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//				sb.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(10);' /> </div></div>");
//				sb.append(" </td> ");
//				sb.append(" </tr> ");
//				sb.append(" </table> ");
				
				sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='right'>");
	 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(10);' /> <img style='cursor: pointer; ' title='Get Back Report'  ");
				sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(10);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(10);' /></div></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");
				
				sb.append(" <br> ");		
		
				sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");
	
				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
				sb.append("</td>");
							
				sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
				sb.append("</td>");
	
				sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font> ");
				sb.append("</td>");
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='6%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax(%)</b></font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Value(Rs.)</b></font> ");
				sb.append("</td> ");
				
				sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{
				NumberFormat formatter = new DecimalFormat("############.##");  
				while (ws.next()) 
				{
					 /*
					1. Brand Name
					2. Batch No
					3. Exp Date
					4. Qty
					5. Rate With unit
					6. TAX
					7. Cost
					++++++++++++++++++++++++++++++++++
					8.Recipt No(Challan)
					9.Challan No
					10.Challan Date
					11.Received Date
					12.No Packet
					13.Supplied Value(SUM)
					+++++++++++++++++++++++++++  
					14.Supplier Name,
					15.Supplier Id,
					16.PO With Ref No,
					17.PO Date,
					18.PO No
					19.Supplied Value
					20.Received Count
					++++++++++++++++++++++++++++++++++++++++++++
			    	21. Issue Count
			    	22. Receive Count
		            23. DWH Name
		            24. Store ID
		            25.Sample Sent Count
					*/	
					
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(7)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					totalCost = totalCost + cltamt;
					
					String strReceiveVoucherThreeHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7);		
					////System.out.println("POPUP CHALLANITEM"+strReceiveVoucherThreeHidValue);
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					sb.append("<td style=\"text-align:left;\" width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(1));
					sb.append("</font></td>");
					sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(2));
					sb.append("</font></td> ");		
					
					sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");		
					
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(4));
					sb.append("</font></td> ");	
					
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(5));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:right;\" width='6%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(7))));
					sb.append("</font></td> ");		
											
					sb.append("</tr> ");
					i++;
					count++;								
				}
				NumberFormat formatter1 = new DecimalFormat("############.##");
				String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost)) )+ ")";	
				String FinaltotalCost  = formatter1.format(new BigDecimal(totalCost)); 
				
				sb.append("<tr>");
				sb.append("<td colspan='7' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Rs)</b></font></td>");
				//sb.append("<td colspan='2' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
				//sb.append("</font></td>");
				sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
				sb.append(FinaltotalCost);				
				sb.append("</b></font></td>");
				sb.append("</tr>");
				
				sb.append("<tr>");
				sb.append("<td colspan='2' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total(Words)</b></font></td>");
				sb.append("<td colspan='2' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append("</font></td>");
				sb.append("<td colspan='2' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(amtStr1);				
				sb.append("</font></td>");
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
        
		return sb.toString();
	}
	
	
	

public static String getIssuedNoDetails(WebRowSet ws) throws Exception 
{
	
	StringBuffer br = new StringBuffer();
	int count = 0;
	int start = 1;
	final int REC_PER_PAGE = 10;
	final int PAGE_PER_BLOCK = 10;
	
	int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
	int totalRecordsToManipulate = totalFetchRecord - 1;
	try
    {			
		
		br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
	 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Issue Details</td></tr></table>");	
	if (ws != null) 
	{
		if(ws.size() != 0)
		{
		 int actualFetchRecord = ws.size();
	
         if(totalFetchRecord != actualFetchRecord)
		 {
			totalFetchRecord = actualFetchRecord;
			totalRecordsToManipulate = actualFetchRecord;
		 }
		 int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
		 int reminder = totalRecordsToManipulate % REC_PER_PAGE;
		 if (reminder > 0)
			totalLayer = totalLayer + 1;
		 
		    br.append("<input type='hidden' name='TotalLayer'  value='"+totalLayer+"'>");
		    br.append("<input type='hidden' name='RecordShowOnPage'  value='"+REC_PER_PAGE+"'>");
		    br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
		 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
		 br.append("<tr>");
		 br.append("<td class='LABEL'>");
		
		 
		 for (int i = 1; i <= totalLayer; i++)
		 {
			br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
					+ "</a>|&nbsp;");
		 }
		br.append("</td></tr>");
		br.append("</table>");			
		
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			//br.append("<tr class='TITLE'>");
			//br.append("<td colspan='4'></td></tr>");
			br.append("<tr>");
			
			br.append("<td CLASS='multiLabel' colspan='1' width='10%'></td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='30%'>Issue No</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='30%'>Issue Date</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='30%'>Name of Institution</td>");
					
			br.append("</tr>");
			br.append("</table>");
	    for (int i = 1; i <= totalLayer; i++) 
	    {
		 if (i <= totalLayer) 
		 {
			 
			if (i == 1) 
			{
				br.append("<div id='DivId" +i+ "' style='display:block'>");
			} 
			else
			{
				br.append("<div id='DivId" +i+ "' style='display:none'>");
			}
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			for (int j = 0; j < REC_PER_PAGE; j++) 
			{
				if(ws.next())
				{
					
					 /* Value Pass in Web Row Set
			    	   1. Issue No
			    	   2. Issue Date  
		               3. Store Name Issue To,
		               4. Store Name 
		               5. Genric Item
		               6. Item Brand 
		               7. Batch No 
		               8. Exp
		               9. Rate
		               10.Issue Qty
		               11.Store ID
		               12.Item Id
		               13.Item Brand Id
		               14.Batch Sl No
		               15.Exp Date
		               16.Rate
		               17.Rate Unit Id
		               18.Rate Base Value
		               19.Issue Qty
		               20.Issue Qty Unit Id
		               21.Qty Base Value
		               22.Item Sl No
		               23.Item Sl No
		               24.Catg Code
		               25.Balance Qty
		               26.Remrkas
		               27.Recevide By
		               28.Issue By
		               29.Final remarks
		               30.Cost
		               31.Avl Budget 
		               */    	 	
											
					String strChallanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3);
					
					br.append("<tr>");
					br.append("<input type='hidden' name='demandFlg'  value='1'>");
					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strChallanHidValue+"'>");
								
					br.append("<td class='multiControl' colspan='1' width='10%'></td>");
					br.append("<td class='multiControl' colspan='1' width='30%'>"+ws.getString(1)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='30%'>"+ws.getString(2)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='30%'>"+ws.getString(3)+"</td>");
										
					br.append("</tr>");
					
					
					
					count++ ;
				}else{
					break;
				}
			}
				br.append("</table>");
				
				
				br.append("</div>");

		} 
		else 
		{
			br.append("<div id='DivId" + i+ "' style='display:none'>");
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			for (int k = 0; k < reminder; k++) 
			{
				ws.next();
				 /* Value Pass in Web Row Set
		    	   1. Issue No
		    	   2. Issue Date  
	               3. Store Name Issue To,
	               4. Store Name 
	               5. Genric Item
	               6. Item Brand 
	               7. Batch No 
	               8. Exp
	               9. Rate
	               10.Issue Qty
	               11.Store ID
	               12.Item Id
	               13.Item Brand Id
	               14.Batch Sl No
	               15.Exp Date
	               16.Rate
	               17.Rate Unit Id
	               18.Rate Base Value
	               19.Issue Qty
	               20.Issue Qty Unit Id
	               21.Qty Base Value
	               22.Item Sl No
	               23.Item Sl No
	               24.Catg Code
	               25.Balance Qty
	               26.Remrkas
	               27.Recevide By
	               28.Issue By
	               29.Final remarks
	               30.Cost
	               31.Avl Budget 
	               */    	 	
										
				String strChallanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3);
				
				br.append("<tr>");
				br.append("<input type='hidden' name='demandFlg'  value='1'>");
				br.append("<input type='hidden' name='strIssueHidValue' id='strIssueHidValue"+count+"' value='"+strChallanHidValue+"'>");
				
				
				br.append("<td class='multiControl' colspan='1' width='10%'></td>");
				br.append("<td class='multiControl' colspan='1' width='30%'>"+ws.getString(1)+"</td>");
				br.append("<td class='multiControl' colspan='1' width='30%'>"+ws.getString(2)+"</td>");
				br.append("<td class='multiControl' colspan='1' width='30%'>"+ws.getString(3)+"</td>");
				
				
				br.append("</tr>");
				
				
				count++ ;
			}
			br.append("</table>");						
			
			
			br.append("</div>");
			}
	   	  }
		  br.append("</div>");
		}
		else
		{
			 
			 
			 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			 br.append("<tr>");
			 
			    br.append("<td CLASS='multiLabel' colspan='1' width='10%'></td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='30%'>Issue No</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='30%'>Issue Date</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='30%'>Name of Institution</td>");
				
			 
			 br.append("</tr>");
			 br.append("<input type='hidden' name='demandFlg'  value='0'>");
           	 br.append("<tr>");  
           	 br.append("<td class='multiControl' colspan='7'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
           	 br.append("</table>");
           	 
				
		   }
		} 
     }
	
catch (Exception e)
{			 
	e.printStackTrace();
		throw new Exception("OffLineIssueIndentTransHLP.getPODetails()->"+e.getMessage());
	}
	return br.toString();
}

public static String getReceiveDetails(WebRowSet ws) throws Exception 
{
	
	StringBuffer br = new StringBuffer();
	int count = 0;
	int start = 1;
	final int REC_PER_PAGE = 10;
	final int PAGE_PER_BLOCK = 10;
	
	int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
	int totalRecordsToManipulate = totalFetchRecord - 1;
	try
    {			
		
		br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
	 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Received Details</td></tr></table>");	
	if (ws != null) 
	{
		if(ws.size() != 0)
		{
		 int actualFetchRecord = ws.size();
	
         if(totalFetchRecord != actualFetchRecord)
		 {
			totalFetchRecord = actualFetchRecord;
			totalRecordsToManipulate = actualFetchRecord;
		 }
		 int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
		 int reminder = totalRecordsToManipulate % REC_PER_PAGE;
		 if (reminder > 0)
			totalLayer = totalLayer + 1;
		 
		    br.append("<input type='hidden' name='TotalLayer'  value='"+totalLayer+"'>");
		    br.append("<input type='hidden' name='RecordShowOnPage'  value='"+REC_PER_PAGE+"'>");
		    br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
		 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
		 br.append("<tr>");
		 br.append("<td class='LABEL'>");
		
		 
		 for (int i = 1; i <= totalLayer; i++)
		 {
			br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
					+ "</a>|&nbsp;");
		 }
		br.append("</td></tr>");
		br.append("</table>");			
		
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			//br.append("<tr class='TITLE'>");
			//br.append("<td colspan='4'></td></tr>");
			br.append("<tr>");
			
			br.append("<td CLASS='multiLabel' colspan='1' width='10%'></td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='10%'>PO No.</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='10%'>PO Date</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Challan No</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Challan Date</td>");				
			br.append("<td CLASS='multiLabel' colspan='1' width='30%'>Supplier Name</td>");
			
			
			br.append("</tr>");
			br.append("</table>");
	    for (int i = 1; i <= totalLayer; i++) 
	    {
		 if (i <= totalLayer) 
		 {
			 
			if (i == 1) 
			{
				br.append("<div id='DivId" +i+ "' style='display:block'>");
			} 
			else
			{
				br.append("<div id='DivId" +i+ "' style='display:none'>");
			}
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			for (int j = 0; j < REC_PER_PAGE; j++) 
			{
				if(ws.next())
				{
					
					 /* Value Pass in Web Row Set
			    	   1. Store Name
			    	   2. PO No  
		               3. Recept date
		               4. PO date 
		               5. Challan No
		               6. Challan Date 
		               7. Supplier 
		                
		               */    	 	
											
					String strReceivedHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7);
					
					br.append("<tr>");
					br.append("<input type='hidden' name='demandFlg'  value='1'>");
					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strReceivedHidValue+"'>");
								
					br.append("<td class='multiControl' colspan='1' width='10%'></td>");
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(2)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(4)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(5)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(6)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='30%'>"+ws.getString(7)+"</td>");
																				
					br.append("</tr>");
					
					
					
					
					count++ ;
				}else{
					break;
				}
			}
				
				br.append("</div>");

		} 
		else 
		{
			br.append("<div id='DivId" + i+ "' style='display:none'>");
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			for (int k = 0; k < reminder; k++) 
			{
				ws.next();
				/* Value Pass in Web Row Set
		    	   1. Store Name
		    	   2. PO No  
	               3. Recept date
	               4. PO date 
	               5. Challan No
	               6. Challan Date 
	               7. Supplier 
	                
	               */  
				String strReceivedHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7);
				
				br.append("<tr>");
				br.append("<input type='hidden' name='demandFlg'  value='1'>");
				br.append("<input type='hidden' name='strReceivedHidValue' id='strReceivedHidValue"+count+"' value='"+strReceivedHidValue+"'>");
				
				
				br.append("<td class='multiControl' colspan='1' width='10%'></td>");
				br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(2)+"</td>");
				br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(4)+"</td>");
				br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(5)+"</td>");
				br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(6)+"</td>");
				br.append("<td class='multiControl' colspan='1' width='30%'>"+ws.getString(7)+"</td>");
				
				
				br.append("</tr>");
						
				
				count++ ;
			}
			br.append("</table>");	
			
			br.append("</div>");
			}
	   	  }
		  br.append("</div>");
		}
		else
		{
			 
			 
			 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			 br.append("<tr>");
			 
			    br.append("<td CLASS='multiLabel' colspan='1' width='10%'></td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>PO No.</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>PO Date</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Challan No</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Challan Date</td>");				
				br.append("<td CLASS='multiLabel' colspan='1' width='30%'>Supplier Name</td>");
				
			 
			 br.append("</tr>");
			 br.append("<input type='hidden' name='demandFlg'  value='0'>");
           	 br.append("<tr>");  
           	 br.append("<td class='multiControl' colspan='7'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
           	 br.append("</table>");
           	 
				
		   }
		} 
     }
	
catch (Exception e)
{			 
	e.printStackTrace();
		throw new Exception("OffLineIssueIndentTransHLP.getPODetails()->"+e.getMessage());
	}
	return br.toString();
}


public static String getSampleSendDtlPopUpOne(DailyActivityRptVO vo) throws Exception 
{

	StringBuffer sb = new StringBuffer("");
	int cltamt1  = 0;
	int totalCost1 = 0;
	String strItemTotCost1="0";	
		
	int i=1;
	int count = 0;		
	HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
	
	ResourceBundle res = mms.qryHandler_mms.res;
	if(res == null) 
	{
		res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
		mms.qryHandler_mms.res = res;
	}
	
	WebRowSet ws = vo.getStrSampleSendDtlDtlOneWS();
	String strHiddenValue = vo.getSampleSendHiddenVal();
		String strTableWidth = "700";
		DecimalFormat myFormatter = new DecimalFormat("0.00");
	try 
	{

           sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			
			sb.append("<tr>");
//			sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");			
			sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");	
		
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Activity Report");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>For :: ");
			sb.append(vo.getSampleSendHiddenVal().split("\\^")[2]);
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
	
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Between ");
			sb.append(vo.getStrFromDate()+"  And  " +vo.getStrToDate());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			
//			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//			sb.append("<tr> ");
//			sb.append("<td align='right'>");
// 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
//			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(4);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//			sb.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(4);' /> </div></div>");
//			sb.append(" </td> ");
//			sb.append(" </tr> ");
//			sb.append(" </table> ");
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(11);' /> <img style='cursor: pointer; ' title='Print Report'  ");
			sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(11);'  /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(11);' /></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");		
	
		sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

		sb.append("<tr bgcolor='#cdc9c9'> ");
		sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
		sb.append("</td>");
					
		sb.append("<td align='center' width='65%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
		sb.append("</td>");

		sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font> ");
		sb.append("</td> ");
		
		sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Count</b></font> ");
		sb.append("</td>");
		
		
		
		sb.append("</tr> ");

		if (ws != null && ws.size() > 0) 
		{

			while (ws.next()) 
			{
				
				/*
				1.Store Id,
				2.Drug Name,
				3.Drug Brand ID,
				4.Issued Count,
				5.Issued Qty
				
				++++++++++++++++++++++++++++++++++++++++++++
		    	6. Issue Count
		    	7. Receive Count
	            8. DWH Name
	            9. Store ID
	            10.Sample Sent Count
				*/
						
				//NumberFormat formatter = new DecimalFormat("############.##");  
				cltamt1  = Integer.parseInt(ws.getString(4));
				totalCost1 = totalCost1 + cltamt1;
				
				//strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(7)));  
				
				
				String strSampleSendDtlOneHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+strHiddenValue;
				////System.out.println("strSampleSendDtlOneHidValue  "+strSampleSendDtlOneHidValue);
				sb.append("<tr> ");
				sb.append("<input type='hidden' name='strSampleSendDtlOneHidValue' id='strSampleSendDtlOneHidValue"+count+"' value='"+strSampleSendDtlOneHidValue+"'>");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
				sb.append(i);
				sb.append("</b></font></td> ");
				
				sb.append("<td align='left' width='55%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strDrugName' id='strDrugName"+count+"' onClick='getSampleSendItemBatchDtl(\""+count+"\")'>"+ws.getString(2)+"</a>");
				sb.append("</font></td>");
				sb.append("<td align='right' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(5));
				sb.append("</font></td> ");		
				
				sb.append("<td style=\"text-align:center;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(4));
				sb.append("</font></td> ");	
				
				
										
				sb.append("</tr> ");
				i++;
				count++;
							
			}
				
			   // NumberFormat formatter1 = new DecimalFormat("############.##");
				//String FinaltotalCost  = formatter1.format(new BigDecimal(totalCost));  
				//String FinaltotalCost1 = formatter1.format(new BigDecimal(totalCost1));  
				//String amtStr1 = "(" + util.getAmountStr(myFormatter.format(totalCost)) + ")";
				//String amtStr2 = "(" + util.getAmountStr(myFormatter.format(totalCost1)) + ")";
				
				sb.append("<tr>");
				
				sb.append("<td colspan='3'  align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Count</b></font></td>");
				sb.append("<td colspan='1' style=\"text-align:center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
				sb.append(totalCost1);				
				sb.append("</b></font></td>");
				
				
				sb.append("</tr>");
				
//				sb.append("<tr>");
//				sb.append("<td colspan='3' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Words)</b></font></td>");
//				sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
//				sb.append(amtStr1);				
//				sb.append("</font></td>");
//				sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
//				sb.append(amtStr2);				
//				sb.append("</font></td>");
//				sb.append("</tr>");
				
							
		}	
		else 
		{

			sb.append("<tr> ");
			sb
					.append("<td colspan='4' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
			sb.append("</tr> ");

		}

		sb.append("</table> ");

	} catch (Exception e) {

		e.printStackTrace();

		throw e;
	}
    
	return sb.toString();
}

public static String getSampleSendDtlPopUpTwo(DailyActivityRptVO vo) throws Exception 
{

	StringBuffer sb = new StringBuffer("");
	
	int cltamt1  = 0;
	int totalCost1 = 0;
	String strItemTotCost1="0";		
	int i=1;
	int count = 0;		
	HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
	
	ResourceBundle res = mms.qryHandler_mms.res;
	if(res == null) 
	{
		res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
		mms.qryHandler_mms.res = res;
	}
	
	WebRowSet ws = vo.getStrSampleSendDtlDtlTwoWS();
	String strHiddenValue = vo.getSampleSendItemBatchHiddenVal();
		String strTableWidth = "700";
		DecimalFormat myFormatter = new DecimalFormat("0.00");
	try 
	{

           sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			
			sb.append("<tr>");
//			sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");		
			sb.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");	
		
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Activity Report");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>For :: ");
			sb.append(vo.getSampleSendItemBatchHiddenVal().split("\\^")[7]);
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			
			//sb.append("<tr><td width='8%'>&nbsp;</td> ");
			//sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Drug Name :: ");
			//sb.append(vo.getSampleSendItemBatchHiddenVal().split("\\^")[1]);
			//sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			//sb.append("</tr> ");
	
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Between ");
			sb.append(vo.getStrFromDate()+"  And  " +vo.getStrToDate());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");
			
//			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//			sb.append("<tr> ");
//			sb.append("<td align='right'>");
// 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
//			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(4);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//			sb.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(4);' /> </div></div>");
//			sb.append(" </td> ");
//			sb.append(" </tr> ");
//			sb.append(" </table> ");
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(12);' /> <img style='cursor: pointer; ' title='Print Report'  ");
			sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(12);'  /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(12);' /></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");		
	
		sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

		sb.append("<tr bgcolor='#cdc9c9'> ");
		sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
		sb.append("</td>");
					
		sb.append("<td align='center' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
		sb.append("</td>");
		
		sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font> ");
		sb.append("</td>");
		
		sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font> ");
		sb.append("</td>");
		
		sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier Name</b></font> ");
		sb.append("</td>");
		
		sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Date</b></font> ");
		sb.append("</td>");

		sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font> ");
		sb.append("</td> ");
		
		sb.append("</tr> ");

		if (ws != null && ws.size() > 0) 
		{

			while (ws.next()) 
			{
				
				/*
				
				1.Store ID
				2.Drug Name
				3.Item Brand ID
				4.Batch No
				5.Expiry Date
				6.Supplier Name
				7.Issue Date
				8.Issue Qty
				++++++++++++++++++++++++++++++++++++++++++++ 
				9.Store Id,
				10.Drug Name,
				11.Drug Brand ID,
				12.Issued Count,
				13.Issued Qty
				
				++++++++++++++++++++++++++++++++++++++++++++
		    	14. Issue Count
		    	15. Receive Count
	            16. DWH Name
	            17. Store ID
	            18.Sample Sent Count
				*/
						
				//NumberFormat formatter = new DecimalFormat("############.##");  
				
				
				//strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(7)));  
				
				cltamt1  = Integer.parseInt(ws.getString(8));
				totalCost1 = totalCost1 + cltamt1;
				
				
				String strSampleSendDtlTwoHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+strHiddenValue;
				////System.out.println("strSampleSendDtlTwoHidValue  "+strSampleSendDtlTwoHidValue);
				sb.append("<tr> ");
				sb.append("<input type='hidden' name='strSampleSendDtlTwoHidValue' id='strSampleSendDtlTwoHidValue"+count+"' value='"+strSampleSendDtlTwoHidValue+"'>");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
				sb.append(i);
				
				sb.append("<td align='left' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(2));
				sb.append("</font></td> ");		
				
				sb.append("<td style=\"text-align:left;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(4));
				sb.append("</font></td> ");	
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(5));
				sb.append("</font></td> ");	
				
				sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(6));
				sb.append("</font></td> ");	
				
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(7));
				sb.append("</font></td> ");	
				
				sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				sb.append(ws.getString(8));
				sb.append("</font></td> ");	
				
				
										
				sb.append("</tr> ");
				i++;
				count++;
							
			}
				
			   // NumberFormat formatter1 = new DecimalFormat("############.##");
				//String FinaltotalCost  = formatter1.format(new BigDecimal(totalCost));  
				//String FinaltotalCost1 = formatter1.format(new BigDecimal(totalCost1));  
				//String amtStr1 = "(" + util.getAmountStr(myFormatter.format(totalCost)) + ")";
				//String amtStr2 = "(" + util.getAmountStr(myFormatter.format(totalCost1)) + ")";
			
			sb.append("<tr>");
			
			sb.append("<td colspan='6'  align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Qty</b></font></td>");
			sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
			sb.append(totalCost1);				
			sb.append("</b></font></td>");
			
			
			sb.append("</tr>");
				
				//sb.append("<tr>");
				
				//sb.append("<td colspan='3'  align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Count</b></font></td>");
				//sb.append("<td colspan='1' style=\"text-align:center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
				//sb.append(totalCost1);				
				//sb.append("</b></font></td>");
				
				
				//sb.append("</tr>");
				
//				sb.append("<tr>");
//				sb.append("<td colspan='3' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Words)</b></font></td>");
//				sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
//				sb.append(amtStr1);				
//				sb.append("</font></td>");
//				sb.append("<td colspan='1' style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
//				sb.append(amtStr2);				
//				sb.append("</font></td>");
//				sb.append("</tr>");
				
							
		}	
		else 
		{

			sb.append("<tr> ");
			sb
					.append("<td colspan='7' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
			sb.append("</tr> ");

		}

		sb.append("</table> ");

	} catch (Exception e) {

		e.printStackTrace();

		throw e;
	}
    
	return sb.toString();
}





}
