package mms.reports.controller.hlp;

import hisglobal.utility.HisUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.reports.controller.fb.MaterialOutwardRegisterRptFB;
import mms.reports.vo.MaterialOutwardRegisterRptVO;

public class MaterialOutwardRegisterRptHLP 
{
	public static String getIssueDetails(WebRowSet ws) throws Exception 
	{
	
	StringBuffer br = new StringBuffer();
	int count = 0;
	int start = 1;
	final int REC_PER_PAGE = 1000;
	final int PAGE_PER_BLOCK = 10;
	double cltamt  = 0.00;
	double totalCost = 0.00;
	String strItemTotCost="0.00";
	
	double cltamt1  = 0.00;
	double totalCost1 = 0.00;
	String strItemTotCost1="0.00";
	
	double cltamt2  = 0.00;
	double totalCost2 = 0.00;
	String strItemTotCost2="0.00";
	
	DecimalFormat myFormatter = new DecimalFormat("0.00");
	int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
	int totalRecordsToManipulate = totalFetchRecord - 1;
	HisUtil util = new HisUtil("","");
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
			br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" +
					  " onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
					+ "</a>|&nbsp;");
		 }
		br.append("</td></tr>");
		br.append("</table>");			
		
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			//br.append("<tr class='TITLE'>");
			//br.append("<td colspan='4'></td></tr>");
			br.append("<tr>");
			
			br.append("<td CLASS='multiLabel' colspan='1' width='5%'>S. No.</td>");
//			br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Issue Date</td>");
//			br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Indent No</td>");
//			br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Indent Date</td>");
//			br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Name of Institution</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='40%'>DWH Name</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Value Inclusive of Tax(VAT/CST In Rs.)</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='20%'>SurCharge(@5% In Rs.)</td>");
			br.append("<td  CLASS='multiLabel' colspan='1' width='20%'>Total value Inclusive of SurCharge(Rs.)</td>");
			
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
			    	   1. Dwh Name
			    	   2. Net Cost
		               3. Store Id
		           	 */    	 	
					
											
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5);		
					
					br.append("<tr>");
					br.append("<input type='hidden' name='demandFlg'  value='1'>");
					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					br.append("<td class='multiControl' colspan='1' width='5%'>"+(j+1)+"</td>");
					br.append("<td style=\"text-align: left;\" class='multiControl' colspan='1' width='40%'>"+
					"<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid"+count+"' value='0' " +
							"onClick='chkBoxClick(this,\""+count+"\");'>"+ws.getString(1)+"</a></td>");
					br.append("<td style=\"text-align: right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(4)))+"</td>");
					br.append("<td style=\"text-align: right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(5)))+"</td>");
					br.append("<td style=\"text-align: right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(2)))+"</td>");
					
					br.append("</tr>");
					
					strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(4)));  
					cltamt1  = Double.parseDouble(strItemTotCost1);
					
					totalCost1 = totalCost1 + cltamt1;
					
					strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(5)));  
					cltamt2  = Double.parseDouble(strItemTotCost2);
					
					totalCost2 = totalCost2 + cltamt2;
					
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(2)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					
					totalCost = totalCost + cltamt;
					
					
					
					count++ ;
				}else{
					break;
				}
			}
				br.append("</table>");
				String FinaltotalCost = formatter.format(new BigDecimal(totalCost));
				
				String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost1))) + ")";
				String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost2))) + ")";
				String amtStr = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost))) + ")";
				
				String FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1));  
				
				
				String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2));  
				
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				
//				br.append("<tr>");
//				br.append("<td colspan='7' class='multiLabel' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
//				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//				br.append(FinaltotalCost);				
//				br.append("</font></td>");
//				br.append("</tr>");
				
				
				br.append("<tr>");
				br.append("<td class='multiLabel' colspan='1' width='5%'></td>");
				br.append("<td class='multiLabel' colspan='1' width='40%' style=\"text-align: right;\">Total Cost(Rs.)</td>");
				br.append("<td style=\"text-align: right;\" class='multiControl' colspan='1' width='20%'><b>"+FinaltotalCost1+"</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiControl' colspan='1' width='20%'><b>"+FinaltotalCost2+"</b></td>");
				br.append("<td style=\"text-align: right;\" class='multiControl' colspan='1' width='20%'><b>"+FinaltotalCost+"</b></td>");
				
				
				br.append("<tr>");
				br.append("<td  bgcolor='#FFEBD5'  colspan='1' width='5%'></td>");
				br.append("<td  bgcolor='#FFEBD5'  colspan='1' style=\"text-align: right;\"  width='40%' ><b><font face='Verdana, Arial, Helvetica, sans-serif' size='1' color='#653232' ><b>Total Cost(Word's)</font></b></td>");
				br.append("<td align='right' bgcolor='#F1ECE2' colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >"+amtStr1+"</font></td>");
				br.append("<td align='right' bgcolor='#F1ECE2' colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >"+amtStr2+"</font></td>");
				br.append("<td align='right' bgcolor='#F1ECE2' colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >"+amtStr+"</font></td>");
				br.append("</tr>");
				
				
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
		    	   1. Dwh Name
		    	   2. Net Cost
	               3. Store Id
	           	 */  
				String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3);		
				
				br.append("<tr>");
				br.append("<input type='hidden' name='demandFlg'  value='1'>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
				br.append("<td class='multiControl' colspan='1' width='5%'>"+(k+1)+"</td>");
				br.append("<td style=\"text-align: left;\" class='multiControl' colspan='1' width='40%'>"+
				"<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid"+count+"' value='0' " +
						"onClick='chkBoxClick(this,\""+count+"\");'>"+ws.getString(1)+"</a></td>");
				br.append("<td style=\"text-align: right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(4)))+"</td>");
				br.append("<td style=\"text-align: right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(5)))+"</td>");
				br.append("<td style=\"text-align: right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(2)))+"</td>");
				
				
				br.append("</tr>");
				
				
				strItemTotCost = formatter.format(new BigDecimal(ws.getString(2)));  
				cltamt  = Double.parseDouble(strItemTotCost);
				
				totalCost = totalCost + cltamt;
				
				strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(4)));  
				cltamt1  = Double.parseDouble(strItemTotCost1);
				
				totalCost1 = totalCost1 + cltamt1;
				
				strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(5)));  
				cltamt2  = Double.parseDouble(strItemTotCost2);
				
				totalCost2 = totalCost2 + cltamt2;
				
			
				
				count++ ;
			}
			br.append("</table>");
						
			String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
			String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost1))) + ")";
			String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost2)) )+ ")";
			String amtStr = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost))) + ")";
			
			String FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1));  
			
			
			String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2));  
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			br.append("<tr>");
			br.append("<td class='multiLabel' colspan='1' width='5%'></td>");
			br.append("<td class='multiLabel' colspan='1' style=\"text-align: right;\"  width='40%'>Total Cost(Rs.)</td>");
			
			br.append("<td class='multiControl' colspan='1' width='20%'><b>"+FinaltotalCost1+"</b></td>");
			br.append("<td class='multiControl' colspan='1' width='20%'><b>"+FinaltotalCost2+"</b></td>");
			br.append("<td class='multiControl' colspan='1' width='20%'><b>"+FinaltotalCost+"</b></td>");
			
			br.append("</tr>");
			
			br.append("<tr>");
			br.append("<td  bgcolor='#FFEBD5'  colspan='1' width='5%'></td>");
			br.append("<td  bgcolor='#FFEBD5'  colspan='1' style=\"text-align: right;\"  width='40%'><b>Total Cost(Word's)</b></td>");
			br.append("<td align='right' bgcolor='#F1ECE2' colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >"+amtStr1+"</font></td>");
			br.append("<td align='right' bgcolor='#F1ECE2' colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >"+amtStr2+"</font></td>");
			br.append("<td align='right' bgcolor='#F1ECE2' colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >"+amtStr+"</font></td>");
			br.append("</tr>");
			
			br.append("</table>");
			
			br.append("</div>");
			}
	   	}
		  br.append("</div>");
		}
		else
		{
			 
			 br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
			 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			 br.append("<tr>");
			 br.append("<td CLASS='multiLabel' colspan='1' width='5%'>S. No.</td>");
			 br.append("<td CLASS='multiLabel' colspan='1' width='40%'>DWH Name</td>");
			 br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Value Inclusive of Tax(VAT/CST)(Rs.)</td>");
		     br.append("<td CLASS='multiLabel' colspan='1' width='20%'>SurCharge(@5%)(Rs.)</td>");
		     br.append("<td  CLASS='multiLabel' colspan='1' width='20%'>Total value Inclusive of SurCharge(Rs.)</td>");
			 
			 br.append("</tr>");
           	 br.append("<tr>");  
           	 br.append("<td class='multiControl' colspan='6'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
           	 br.append("</table>");
           	 br.append("</div>");
				
		   }
		} 
     }
		
	catch (Exception e) {	
		 
			throw new Exception("MaterialOutwardRegisterRptHLP.getIssueDetails()->"+e.getMessage());
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
	public static String getPrintScreenTwo(WebRowSet ws,MaterialOutwardRegisterRptVO materialOutwardRegisterRptVO_p)throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		int i=1;
		int count = 0;
		
		double cltamt1  = 0.00;
		double totalCost1 = 0.00;
		String strItemTotCost1="0.00";
		
		double cltamt2  = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost2="0.00";
		
		HisUtil util = new HisUtil("mms", "getPrintScreenTwo");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		//String strHiddenValue = vo.getStrHiddenValue();
 		String strTableWidth = "700";
 		DecimalFormat myFormatter = new DecimalFormat("0.00");

		try 
		{
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			
			sb.append("<tr>");
			sb.append("<td width='10%'><div  align='right'></div></td>");			
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");	
		
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
//			sb.append(res.getString("FULL_TITLE"));
			sb.append("Material Outward Register");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>From Store::");
			sb.append(materialOutwardRegisterRptVO_p.getStrStoreName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Between: ");
			sb.append(materialOutwardRegisterRptVO_p.getStrFromDate()+" and "+ materialOutwardRegisterRptVO_p.getStrToDate());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");		
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataMain4();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(4);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(4);' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			
			sb.append(" </table> ");
			sb.append(" <br> ");
		
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='left' width='32%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>DWH Name</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Value Inclusive of Tax(VAT/CST)(Rs.)</b></font> ");
			sb.append("</td>");
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SurCharge(@5%)(Rs.)</b></font> ");
			sb.append("</td>");
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total value Inclusive of SurCharge(Rs.)</b></font> ");
		    sb.append("</td> ");			
			
			
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
			
					/* Value Pass in Web Row Set
			    	   1. DWH NAME
			    	   2. Net Cost
		               3. Store Id
		               
		           	 */ 
							
							NumberFormat formatter = new DecimalFormat("############.##");  
						    
							strItemTotCost = formatter.format(new BigDecimal(ws.getString(2)));  
							cltamt  = Double.parseDouble(strItemTotCost);
							
							totalCost = totalCost + cltamt;
							
							strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(4)));  
							cltamt1  = Double.parseDouble(strItemTotCost1);
							
							totalCost1 = totalCost1 + cltamt1;
							
							strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(5)));  
							cltamt2  = Double.parseDouble(strItemTotCost2);
							
							totalCost2 = totalCost2 + cltamt2;
							
					//String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+strHiddenValue;		
					sb.append("<tr> ");
					//sb.append("<input type='hidden' name='strPoHidValue' id='strPoHidValue"+count+"' value='"+strCheckHidValue+"'>");
					sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					sb.append("<td style=\"text-align: left;\" width='32%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(1));
					sb.append("</font></td>");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(4))));
					sb.append("</font></td> ");	
					
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(5))));
					sb.append("</font></td> ");	
					
					
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(2))));
					sb.append("</font></td> ");					
					sb.append("</tr> ");					
					
					i++;
					count++;
								
				}
					
					NumberFormat formatter = new DecimalFormat("############.##");  
				    
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));
					String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost1))) + ")";
					String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost2))) + ")";
					String amtStr = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost))) + ")";
					
					String FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1));  
					
					
					String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
					
					
										
					sb.append("<tr>");
					sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' ></td>");
					sb.append("<td align='center' width='32%'><font face='Verdana, Arial, Helvetica, sans-serif' >Total Cost(Rs.)</font></td>");
					sb.append("<td align='right' width='15%'><b><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+FinaltotalCost1+"</b></font></b></td>");
					sb.append("<td align='right' width='15%'><b><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+FinaltotalCost2+"</b></font></b></td>");
					sb.append("<td align='right' width='15%'><b><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+FinaltotalCost+"</b></font></b></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='1' width='5%'></td>");
					sb.append("<td colspan='1' style=\"text-align: right;\"  width='40%'><b>Total Cost(Word's)</b></td>");
					sb.append("<td align='right' colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >"+amtStr1+"</font></td>");
					sb.append("<td align='right' colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >"+amtStr2+"</font></td>");
					sb.append("<td align='right' colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >"+amtStr+"</font></td>");
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
	
	
	
	
	
	public static String printIssueDetailsPopUpMain(WebRowSet ws,MaterialOutwardRegisterRptVO materialOutwardRegisterRptVO_p) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 1000;
		final int PAGE_PER_BLOCK = 10;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		String strTableWidth = "700";
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		
		try
	    {			
			
		 /* Value Pass in Web Row Set
	        1. Issue no
	        2. Issue Date
            3. Indent No
            4. Indent Date
            5. Name of Institution
            6. Total Value 
            7. DWH Name
            8. Store Id
            9. Requesting Store Id	
            */
			
//			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
//		 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Challan Consolidated Details</td></tr></table>");	
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
			 br.append("<tr style=\"display: none;\">");
			 br.append("<td class='LABEL'>");
			 NumberFormat formatter = new DecimalFormat("############.##");  
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");			
	//////////////////////////////////////
		
			br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			br.append("<tr><td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
//			br.append(res.getString("REPORT_TITLE"));
//			//System.out.println("ws.getString(4)"+ws.getString(4));
			if(ws.next())
			
			br.append("From DWH Name: "+ materialOutwardRegisterRptVO_p.getStrStoreName());
			
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			br.append("Material Outward Register");
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			br.append("Between: "+materialOutwardRegisterRptVO_p.getStrFromDate()+" and "+materialOutwardRegisterRptVO_p.getStrToDate());
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("</table> ");
			
			
			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//			br.append("<tr> ");
//			br.append("<td align='right'>");
//			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
//			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataMain();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//			br.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopupMain();' /> </div></div>");
//			br.append(" </td> ");
//			br.append(" </tr> ");
			
			br.append("<tr> ");
			br.append("<td align='right'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataMain();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			br.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(1);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' /> </div></div>");
			br.append(" </td> ");
			br.append(" </tr> ");
			
			br.append(" </table> ");
			br.append(" <br> ");
			br.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
			
			
			
			br.append("<table border='1' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			//br.append("<tr class='TITLE'>");
			//br.append("<td colspan='4'></td></tr>");
			br.append("<tr bgcolor='#cdc9c9'> ");
			/*br.append("<td  colspan='1' width='50%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
			br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
			br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
			br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font></td>");
			br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");				
			br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received By</b></font></td>");*/
			
			
			br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='70%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>DWH Name</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Value(Rs.)</b></font></td>");
			
			
			br.append("</tr>");
			br.append("</table>");
			
	/////////////////////////////////////	
			
			//Commented by Vivek
	/*			
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				//br.append("<tr class='TITLE'>");
				//br.append("<td colspan='4'></td></tr>");
				br.append("<tr>");
				
				br.append("<td CLASS='multiLabel' colspan='1' width='50%'>Drug Name</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Batch No.</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Expiry Date</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Issue Qty</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Value</td>");				
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Received By</td>");
				
				
				br.append("</tr>");
				br.append("</table>");*/
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
				
				ws.beforeFirst();
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{
						
						 /* Value Pass in Web Row Set
				    	   1. Issue no
				    	   2. Issue Date
			               3. Indent No
			               4. Indent Date
			               5. Name of Institution
			               6. Total Value 
			               7. DWH Name
			               8. Store Id
			               9. Requesting Store Id	
												
//						String strCheckHidValue2 = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31);
						
						br.append("<tr>");
						br.append("<input type='hidden' name='demandFlg'  value='1'>");
//						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strChallanHidValue+"'>");
									
						br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+(j+1)+"</td>");
						br.append("<td style=\"text-align: center;\" colspan='1' width='70%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(5)+"</td>");
						br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(6)+"</td>");
						
						/*br.append("<td  colspan='1' width='50%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(6)+"</td>");
						br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(7)+"</td>");
						br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(8)+"</td>");
						br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(10)+"</td>");
						br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(30)+"</td>");
						br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(27)+"</td>");*/
						
						String strCheckHidValue2 = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3);
						
						br.append("<input type='hidden' name='strCheckHidValue2' id='strCheckHidValue2"+count+"' value='"+strCheckHidValue2+"'>");
						
						br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+(j+1)+"</td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='70%'><font face='Verdana, Arial, Helvetica, sans-serif' >"
//						"<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid"+count+"' value='0' " +	"onClick='getPopUp2(this,\""+count+"\");'>"
						+ws.getString(1)+
//						"</a>" +
						"</td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(ws.getString(6)))+"</td>");
						
						
						
						
						
						
						br.append("</tr>");
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(6)));  
						cltamt  = Double.parseDouble(strItemTotCost);
						
						totalCost = totalCost + cltamt;
						
						
						count++ ;
					}else{
						break;
					}
				}
					br.append("</table>");
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td colspan='2' width='80%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					br.append("<td colspan='1' width='20%'  style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(FinaltotalCost);				
					br.append("</font></td>");
					br.append("</tr>");
					br.append("</table>");
					
					br.append("</div>");

			} 
//			else 
//			{
//				br.append("<div id='DivId" + i+ "' style='display:none'>");
//				
//				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
//				for (int k = 0; k < reminder; k++) 
//				{
//					ws.next();
//					 /* Value Pass in Web Row Set
//			    	   1. Issue No
//			    	   2. Issue Date  
//		               3. Store Name Issue To,
//		               4. Store Name 
//		               5. Genric Item
//		               6. Item Brand 
//		               7. Batch No 
//		               8. Exp
//		               9. Rate
//		               10.Issue Qty
//		               11. Store ID
//		               12.Item Id
//		               13.Item Brand Id
//		               14.Batch Sl No
//		               15.Exp Date
//		               16.Rate
//		               17.Rate Unit Id
//		               18.Rate Base Value
//		               19.Issue Qty
//		               20.Issue Qty Unit Id
//		               21.Qty Base Value
//		               22.Item Sl No
//		               23.Item Sl No
//		               24.Catg Code
//		               25.Balance Qty
//		               26.Remrkas
//		               27.Recevide By
//		               28.Issue By
//		               29.Final remarks
//		               30.Cost
//		               31.Avl Budget 
//		              
//			    	 */    	 
//					String strChallanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31);
//					
//					br.append("<tr>");
//					br.append("<input type='hidden' name='demandFlg'  value='1'>");
//					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strChallanHidValue+"'>");
//					
//					
//					br.append("<td class='multiControl' colspan='1' width='50%'>"+ws.getString(6)+"</td>");
//					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(7)+"</td>");
//					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(8)+"</td>");
//					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(10)+"</td>");
//					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(30)+"</td>");
//					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(27)+"</td>");
//					
//					
//					br.append("</tr>");
//					
//					br.append("<tr>");
//					br.append("<td colspan='8' align='center' ><b>------------------------------------------------------------</b></font></td>");
//					br.append("</tr>");
//					
//					strItemTotCost = formatter.format(new BigDecimal(ws.getString(30)));  
//					cltamt  = Double.parseDouble(strItemTotCost);
//					
//					totalCost = totalCost + cltamt;
//					count++ ;
//				}
//				br.append("</table>");
//							
//				String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
//				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
//							
//				br.append("<tr>");
//				br.append("<td colspan='7' align='center' class='multiLabel'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
//				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//				br.append(FinaltotalCost);				
//				br.append("</font></td>");
//				br.append("</tr>");
//				br.append("</table>");
//				
//				br.append("</div>");
//				}
		   	  }
			  br.append("</div>");
			}
			else
			{
			
				 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				 br.append("<tr>");
				 
				 	br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='70%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>DWH Name</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Value(Rs.)</b></font></td>");
					
					
				 
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
			throw new Exception("MaterialOutwardRegisterRptHLP.getIssueDetailsPopUp1()->"+e.getMessage());
		}
		return br.toString();
	}
	
	
	
	public static String getIssueDetailsPopUp1(WebRowSet ws,MaterialOutwardRegisterRptVO materialOutwardRegisterRptVO_p) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 1000;
		final int PAGE_PER_BLOCK = 10;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		String strTableWidth = "750";
		
		double cltamt1  = 0.00;
		double totalCost1 = 0.00;
		String strItemTotCost1="0.00";
		
		double cltamt2  = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost2="0.00";
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		NumberFormat formatter = new DecimalFormat("############.##");
		HisUtil  util = new HisUtil("",""); 
		String strStoreName="";
		try
	    {			
			
		 /* Value Pass in Web Row Set
	     
            1. Name of Institution
            2. Total Value 
            3. Store Id
            4. DWH Name
            5. Requesting Store Id	
            */
			while(ws.next())
			{
				strStoreName = ws.getString(4);
			}
			ws.beforeFirst();
		if (ws != null) 
		{		
			br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");			
			br.append("<tr>");
			br.append("<td width='10%'><div  align='right'></div></td>");			
			br.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			br.append(res.getString("REPORT_TITLE"));
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");			
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			br.append("Material Outward Register");
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>DWH Name :: ");
			br.append(strStoreName);
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			br.append("Between: "+materialOutwardRegisterRptVO_p.getStrFromDate()+" and "+materialOutwardRegisterRptVO_p.getStrToDate());
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append(" </table> ");
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			br.append("<tr> ");
			br.append("<td align='right'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			br.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(1);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' /> </div></div>");
			br.append(" </td> ");
			br.append(" </tr> ");
			br.append(" </table> ");
			br.append(" <br> ");
			br.append("<table class='TABLEWIDTH' border='1px' align='center' cellspacing='1px' cellpadding='1px'>");
			br.append("<tr bgcolor='#cdc9c9'> ");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
			br.append("<td style=\"text-align: left;\" colspan='1' width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Institution Name</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Value Inclusive Tax(VAT/CST)(Rs.)</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SurCharge(@5%)(Rs.)</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value Inclusive of Surcharge(Rs.)</b></font></td>");
			
			
			br.append("</tr>");
			
			br.append("<tr> ");
			
		    
					while(ws.next())
					{
						
						 /* Value Pass in Web Row Set
				    	   1. Name of Institution
				            2. Total Value 
				            3. Store Id
				            4. DWH Name
				            5. Requesting Store Id*/
						
						String strChkHidValue2 = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7);
						
						br.append("<input type='hidden' name='strChkHidValue2' id='strChkHidValue2"+count+"' value='"+strChkHidValue2+"'>");
						
						
						br.append("<tr> ");
						br.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						br.append(start);
						br.append("</font></td> ");									
						br.append("<td style=\"text-align: left;\"   width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+
								"<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid"+count+"' value='0' " +
								"onClick='getPopUp2(this,\""+count+"\");'>"+ws.getString(1)+"</a></td>");
						br.append("<td style=\"text-align: right;\"  width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(ws.getString(6)))+"</td>");
						br.append("<td style=\"text-align: right;\"  width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(ws.getString(7)))+"</td>");
						br.append("<td style=\"text-align: right;\"  width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(ws.getString(2)))+"</td>");
						
						br.append("</tr>");
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(2)));  
						cltamt  = Double.parseDouble(strItemTotCost);
						
						totalCost = totalCost + cltamt;
						
						strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(6)));  
						cltamt1  = Double.parseDouble(strItemTotCost1);
						
						totalCost1 = totalCost1 + cltamt1;
						
						strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(7)));  
						cltamt2  = Double.parseDouble(strItemTotCost2);
						
						totalCost2 = totalCost2 + cltamt2;
						
						
						
						count++ ;
						start++;
					}				  
					
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));
					String amtStr = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost))) + ")";
					String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost1))) + ")";
					String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost2))) + ")";
					
					String FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1));
					String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2));
					
					
					br.append("<tr>");
					br.append("<td colspan='2' width='40%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					br.append("<td colspan='1' width='20%'  style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					br.append(myFormatter.format(Double.parseDouble(FinaltotalCost1)));				
					br.append("<b></font></td>");
					br.append("<td colspan='1' width='20%'  style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					br.append(myFormatter.format(Double.parseDouble(FinaltotalCost2)));				
					br.append("<b></font></td>");
					br.append("<td colspan='1' width='20%'  style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					br.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));				
					br.append("<b></font></td>");
					br.append("</tr>");
					
					br.append("<tr>");
					br.append("<td colspan='2' width='40%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Words)</b></font></td>");
					br.append("<td colspan='1' width='20%'  style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(amtStr1);				
					br.append("</font></td>");
					br.append("<td colspan='1' width='20%'  style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(amtStr2);				
					br.append("</font></td>");
					br.append("<td colspan='1' width='20%'  style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(amtStr);				
					br.append("</font></td>");
					br.append("</tr>");
					
					
					br.append("</table>");
					
					

			   

		   	 
			}
			else
			{
				br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
				br.append("<tr> ");
				br.append("<td align='right'>");
				br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				br.append("<img style='cursor: pointer; ' title='Print Page'  ");
				br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
				br.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(1);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' /> </div></div>");
				br.append(" </td> ");
				br.append(" </tr> ");				
				br.append(" </table> ");
				 
				 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				 br.append("<tr>");
				 
				 	br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
					br.append("<td style=\"text-align: left;\" colspan='1' width='35%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Institution Name</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Value Inclusive Tax(VAT/CST)(Rs.)</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SurCharge(@5%)(Rs.)</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value Inclusive of Surcharge(Rs.)</b></font></td>");
							
				 
				 br.append("</tr>");
				 br.append("<input type='hidden' name='demandFlg'  value='0'>");
	           	 br.append("<tr>");  
	           	 br.append("<td class='multiControl' colspan='7'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	 br.append("</table>");
	           	 
					
			   }
		
	 }
		
	catch (Exception e)
	{			 
		e.printStackTrace();
			throw new Exception("MaterialOutwardRegisterRptHLP.getIssueDetailsPopUp1()->"+e.getMessage());
		}
		return br.toString();
	}


	public static String getIssueDetailsPopUp2(WebRowSet ws,MaterialOutwardRegisterRptVO materialOutwardRegisterRptVO_p) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 1000;
		final int PAGE_PER_BLOCK = 10;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		String strTableWidth = "750";
		
		double cltamt1  = 0.00;
		double totalCost1 = 0.00;
		String strItemTotCost1="0.00";
		
		double cltamt2  = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost2="0.00";
		
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		HisUtil util = new HisUtil("","");
		
		try
	    {			
			
		 /* Value Pass in Web Row Set
	        1. Issue no
	        2. Issue Date
            3. Indent No
            4. Indent Date
            5. Name of Institution
            6. Total Value 
            7. DWH Name
            8. Store Id
            9. Requesting Store Id	
            10. Received By
            */
			
//			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
//		 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Challan Consolidated Details</td></tr></table>");	
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
			 br.append("<tr style=\"display: none;\">");
			 br.append("<td class='LABEL'>");
			 NumberFormat formatter = new DecimalFormat("############.##");  
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");			
	//////////////////////////////////////
		
			br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			br.append("<tr><td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
//			br.append(res.getString("REPORT_TITLE"));
//			//System.out.println("ws.getString(4)"+ws.getString(4));
			if(ws.next())
			
			br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			
			br.append("<tr>");
			br.append("<td width='10%'><div  align='right'></div></td>");			
			br.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			br.append(res.getString("REPORT_TITLE"));
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");	
		
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
//			br.append(res.getString("FULL_TITLE"));
			br.append("Material Outward Register");
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
//			br.append(res.getString("CITY"));
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("</table> ");
			
			br.append("<table> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			br.append("From DWH Name: "+ws.getString(7));
			
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
//			br.append("<tr> ");
//			br.append("<td width='8%'>&nbsp;</td> ");
//			br.append("<td width='82%' align='center'> <font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
////			br.append(res.getString("FULL_TITLE"));			
//			br.append("</font></td> <td width='10%'>&nbsp;</td> ");
//			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			br.append("To Store Name: "+ws.getString(5));
//			br.append(res.getString("CITY"));
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			br.append("Between: "+materialOutwardRegisterRptVO_p.getStrFromDate()+" and "+materialOutwardRegisterRptVO_p.getStrToDate());
//			br.append(res.getString("CITY"));
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("</table> ");
			
			
			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//			br.append("<tr> ");
//			br.append("<td align='right'>");
//			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
//			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData2();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//			br.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup2();' /> </div></div>");
//			br.append(" </td> ");
//			br.append(" </tr> ");
			
			br.append("<tr> ");
			br.append("<td align='right'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData2();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			br.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(2);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(2);' /> </div></div>");
			br.append(" </td> ");
			br.append(" </tr> ");
			
			br.append(" </table> ");
			br.append(" </br> ");
			//br.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
			//br.append("<table border='1' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<table class='TABLEWIDTH' align='center' border='1px' cellspacing='1px' cellpadding='1px'>");
			//br.append("<tr class='TITLE'>");
			//br.append("<td colspan='4'></td></tr>");
			br.append("<tr bgcolor='#cdc9c9'> ");
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue No.</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Date</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent No.</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Value Inclusive Tax(VAT/CST)(Rs.)</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SurCharge(@5%)(Rs.)</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value Inclusive of SurCharge(Rs.)</b></font></td>");
			br.append("</tr>");
			
			
	/////////////////////////////////////	
			
			//Commented by Vivek
	/*			
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				//br.append("<tr class='TITLE'>");
				//br.append("<td colspan='4'></td></tr>");
				br.append("<tr>");
				
				br.append("<td CLASS='multiLabel' colspan='1' width='50%'>Drug Name</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Batch No.</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Expiry Date</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Issue Qty</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Value</td>");				
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Received By</td>");
				
				
				br.append("</tr>");
				br.append("</table>");*/
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
				
				
				
				ws.beforeFirst();
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{
						
						 /* Value Pass in Web Row Set
				    	   1. Issue no
				    	   2. Issue Date
			               3. Indent No
			               4. Indent Date
			               5. Name of Institution
			               6. Total Value 
			               7. DWH Name
			               8. Store Id
			               9. Requesting Store Id	*/
						
						String strCheckHidValue3 = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12);
						
						br.append("<input type='hidden' name='strCheckHidValue33' id='strCheckHidValue33"+count+"' value='"+strCheckHidValue3+"'>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+(j+1)+"</td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+
								"<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid"+count+"' value='0' " +
								"onClick='getPopUp3(this,\""+count+"\");'>"+ws.getString(1)+"</a></td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(3)+"</td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(ws.getString(11)))+"</td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(ws.getString(12)))+"</td>");
						br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(ws.getString(6)))+"</td>");
						br.append("</tr>");
					
						
						
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(6)));  
						cltamt  = Double.parseDouble(strItemTotCost);
						
						totalCost = totalCost + cltamt;
						
						strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(11)));  
						cltamt1  = Double.parseDouble(strItemTotCost1);
						
						totalCost1 = totalCost1 + cltamt1;
						
						strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(12)));  
						cltamt2  = Double.parseDouble(strItemTotCost2);
						
						totalCost2 = totalCost2 + cltamt2;
						
						
						
						
						count++ ;
					}else{
						break;
					}
				}
					
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					String amtStr = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost))) + ")";
					String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost1))) + ")";
					String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost2))) + ")";
					
					String FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1));
					String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2));
					
					
					
					br.append("<tr>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Rs.)</b></font></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					br.append(myFormatter.format(Double.parseDouble(FinaltotalCost1)));				
					br.append("</b></font></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					br.append(myFormatter.format(Double.parseDouble(FinaltotalCost2)));				
					br.append("</b></font></td>");
					br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					br.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));				
					br.append("</b></font></td>");
					br.append("</tr>");
					br.append("<tr>");
					br.append("<td colspan='4' width='55%'  style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Words)</b></font></td>");
					br.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(amtStr1);				
					br.append("</font></td>");
					
					br.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(amtStr2);				
					br.append("</font></td>");
					
					br.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(amtStr);				
					br.append("</font></td>");
					br.append("</tr>");
					br.append("</table>");
					
					//br.append("</div>");

			     } 

		   	  }
			  br.append("</div>");
			}
			else
			{
				br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//				br.append("<tr> ");
//				br.append("<td align='right'>");
//				br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//				br.append("<img style='cursor: pointer; ' title='Print Page'  ");
//				br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData2();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//				br.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup2();' /> </div></div>");
//				br.append(" </td> ");
//				br.append(" </tr> ");
				
				br.append("<tr> ");
				br.append("<td align='right'>");
				br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				br.append("<img style='cursor: pointer; ' title='Print Page'  ");
				br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData2();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
				br.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(2);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(2);' /> </div></div>");
				br.append(" </td> ");
				br.append(" </tr> ");
				
				br.append(" </table> ");
				 
				 br.append("<table class='TABLEWIDTH' align='center' border='1px' cellspacing='1px' cellpadding='1px'>");
				 br.append("<tr>");
				 

				   br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue No.</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Date</b></font></td>");
					
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent No.</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Value Inclusive Tax(VAT/CST)(Rs.)</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SurCharge(@5%)(Rs.)</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value Inclusive of SurCharge(Rs.)</b></font></td>");
					
					
					
				 
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
			throw new Exception("MaterialOutwardRegisterRptHLP.getIssueDetailsPopUp1()->"+e.getMessage());
		}
		return br.toString();
	}
	
	
	
	public static String getIssueDetailsPopUp3(WebRowSet ws,MaterialOutwardRegisterRptVO materialOutwardRegisterRptVO_p) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 1000;
		final int PAGE_PER_BLOCK = 10;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		String strTableWidth = "750";
		
		double cltamt1  = 0.00;
		double totalCost1 = 0.00;
		String strItemTotCost1="0.00";
		
		double cltamt2  = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost2="0.00";
		
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		HisUtil util = new HisUtil("","");
		try
	    {			
			
		  /* Value Pass in Web Row Set
    	    1. Issue No
    	    2. Issue Date  
            3. Store Name Issue To,
            4. Store Name 
            5. Generic Item
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
			
//			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
//		 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Challan Consolidated Details</td></tr></table>");	
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
			 br.append("<tr style=\"display: none;\">");
			 br.append("<td class='LABEL'>");
			 NumberFormat formatter = new DecimalFormat("############.##");  
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");			
	
		
			br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			br.append("<tr><td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
//			br.append(res.getString("REPORT_TITLE"));
//			//System.out.println("ws.getString(4)"+ws.getString(4));
			if(ws.next())

			br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			
			br.append("<tr>");
			br.append("<td width='10%'><div  align='right'></div></td>");			
			br.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			br.append(res.getString("REPORT_TITLE"));
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");	
		
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
//			br.append(res.getString("FULL_TITLE"));
			br.append("Material Outward Register");
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
//			br.append(res.getString("CITY"));
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("</table> ");
	
			br.append("<table> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			br.append("DWH Name: "+ws.getString(4));			
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			br.append("To Institute Name: "+ws.getString(3));			
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			
//			br.append("<tr> ");
//			br.append("<td width='8%'>&nbsp;</td> ");
//			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
////			br.append(res.getString("FULL_TITLE"));
//			
//			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
//			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			br.append("Issue No/Issue Date: "+ws.getString(1)+"/"+ws.getString(2));
//			br.append(res.getString("CITY"));
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			br.append("For Request No/Request Date: "+ws.getString(34)+"/"+ws.getString(35));
//			br.append(res.getString("CITY"));
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
//			br.append("Between: "+materialOutwardRegisterRptVO_p.getStrFromDate()+" and "+materialOutwardRegisterRptVO_p.getStrToDate());
//			br.append(res.getString("CITY"));
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("</table> ");
			
			
			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//			br.append("<tr> ");
//			br.append("<td align='right'>");
//			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
//			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData3();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//			br.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup3();' /> </div></div>");
//			br.append(" </td> ");
//			br.append(" </tr> ");
			
			br.append("<tr> ");
			br.append("<td align='right'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData3();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			br.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(3);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(3);' /> </div></div>");
			br.append(" </td> ");
			br.append(" </tr> ");
			
			br.append(" </table> ");
			br.append(" <br> ");
			br.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
			
			
			
			br.append("<table border='1' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<table class='TABLEWIDTH' border='1px' align='center' cellspacing='1px' cellpadding='1px'>");
			//br.append("<tr class='TITLE'>");
			//br.append("<td colspan='4'></td></tr>");
			br.append("<tr bgcolor='#cdc9c9'> ");
			
			
			br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Base Cost(Rs.)</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SurCharge (@5%)(Rs.)</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Rs.)</b></font></td>");
			
			
			br.append("</tr>");
			
			
	
			
		
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
				
				
				
				ws.beforeFirst();
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{
						
						 /* Value Pass in Web Row Set
				    	   1. Issue no
				    	   2. Issue Date
			               3. Indent No
			               4. Indent Date
			               5. Name of Institution
			               6. Total Value 
			               7. DWH Name
			               8. Store Id
			               9. Requesting Store Id	
                            */
						
						String strCheckHidValue4 = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31)+"^"+ws.getString(32)+"^"+ws.getString(33)+"^"+ws.getString(34)+"^"+ws.getString(35);
						
						br.append("<input type='hidden' name='strCheckHidValue4' id='strCheckHidValue4"+count+"' value='"+strCheckHidValue4+"'>");
						
						br.append("<tr> ");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+(j+1)+"</td>");
						br.append("<td style=\"text-align: left;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+
								ws.getString(6)+"</td>");//DRUG NAME
						br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(7)+"</td>");//bATCH nO
						br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(8)+"</td>");//Expiry Date
						br.append("<td style=\"text-align: left;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(9)+"</td>");//Rate/Unit
						br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(10)+"</td>");//Issue Qty
						br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(ws.getString(32)))+"</td>");//Base Cost
						br.append("<td style=\"text-align: right;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(ws.getString(33)))+"</td>");//SurCuarge
						br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(ws.getString(30)))+"</td>");//Total Value
						
						br.append("</tr>");
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(30)));  
						cltamt  = Double.parseDouble(strItemTotCost);
						
						totalCost = totalCost + cltamt;
						
						strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(32)));  
						cltamt1  = Double.parseDouble(strItemTotCost1);
						
						totalCost1 = totalCost1 + cltamt1;
						
						strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(33)));  
						cltamt2  = Double.parseDouble(strItemTotCost2);
						
						totalCost2 = totalCost2 + cltamt2;
						
						
						count++ ;
					}else{
						break;
					}
				}
					
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					String amtStr = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost))) + ")";
					String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost1))) + ")";
					String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost2))) + ")";
					
					String FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1)); 
					String FinaltotalCost2= formatter.format(new BigDecimal(totalCost2)); 
					
					br.append("<tr>");
					br.append("<td colspan='1' width='5%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
					br.append("<td colspan='1' width='15%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
					br.append("<td colspan='1' width='15%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
					br.append("<td colspan='1' width='10%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
					br.append("<td colspan='1' width='15%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
					br.append("<td colspan='1' width='10%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					br.append("<td colspan='1' width='10%'  style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif'><b>");						
					br.append(myFormatter.format(Double.parseDouble(FinaltotalCost1)));				
					br.append("</b></font></td>");
					br.append("<td colspan='1' width='10%'  style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif'><b>");						
					br.append(myFormatter.format(Double.parseDouble(FinaltotalCost2)));				
					br.append("</b></font></td>");
					br.append("<td colspan='1' width='15%'  style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif'><b>");						
					br.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));				
					br.append("</b></font></td>");
					br.append("</tr>");
					
					br.append("<tr>");
					br.append("<td colspan='6' width='55%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Words)</b></font></td>");
					br.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");						
					br.append(amtStr1);				
					br.append("</font></td>");
					
					
					br.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");						
					br.append(amtStr2);				
					br.append("</font></td>");
					
					br.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' >");						
					br.append(amtStr);				
					br.append("</font></td>");
					
					br.append("</tr>");
					br.append("</table>");
					
					br.append("</div>");

			} 
//			else 
//			{
//				br.append("<div id='DivId" + i+ "' style='display:none'>");
//				
//				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
//				for (int k = 0; k < reminder; k++) 
//				{
//					ws.next();
//					 /* Value Pass in Web Row Set
//			    	   1. Issue No
//			    	   2. Issue Date  
//		               3. Store Name Issue To,
//		               4. Store Name 
//		               5. Genric Item
//		               6. Item Brand 
//		               7. Batch No 
//		               8. Exp
//		               9. Rate
//		               10.Issue Qty
//		               11. Store ID
//		               12.Item Id
//		               13.Item Brand Id
//		               14.Batch Sl No
//		               15.Exp Date
//		               16.Rate
//		               17.Rate Unit Id
//		               18.Rate Base Value
//		               19.Issue Qty
//		               20.Issue Qty Unit Id
//		               21.Qty Base Value
//		               22.Item Sl No
//		               23.Item Sl No
//		               24.Catg Code
//		               25.Balance Qty
//		               26.Remrkas
//		               27.Recevide By
//		               28.Issue By
//		               29.Final remarks
//		               30.Cost
//		               31.Avl Budget 
//		              
//			    	 */    	 
//					String strChallanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31);
//					
//					br.append("<tr>");
//					br.append("<input type='hidden' name='demandFlg'  value='1'>");
//					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strChallanHidValue+"'>");
//					
//					
//					br.append("<td class='multiControl' colspan='1' width='50%'>"+ws.getString(6)+"</td>");
//					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(7)+"</td>");
//					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(8)+"</td>");
//					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(10)+"</td>");
//					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(30)+"</td>");
//					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(27)+"</td>");
//					
//					
//					br.append("</tr>");
//					
//					br.append("<tr>");
//					br.append("<td colspan='8' align='center' ><b>------------------------------------------------------------</b></font></td>");
//					br.append("</tr>");
//					
//					strItemTotCost = formatter.format(new BigDecimal(ws.getString(30)));  
//					cltamt  = Double.parseDouble(strItemTotCost);
//					
//					totalCost = totalCost + cltamt;
//					count++ ;
//				}
//				br.append("</table>");
//							
//				String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
//				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
//							
//				br.append("<tr>");
//				br.append("<td colspan='7' align='center' class='multiLabel'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
//				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//				br.append(FinaltotalCost);				
//				br.append("</font></td>");
//				br.append("</tr>");
//				br.append("</table>");
//				
//				br.append("</div>");
//				}
		   	  }
			  br.append("</div>");
			}
			else
			{
				br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//				br.append("<tr> ");
//				br.append("<td align='right'>");
//				br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//				br.append("<img style='cursor: pointer; ' title='Print Page'  ");
//				br.append(" src='../../hisglobsymbol.gif' onClick='printData2();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//				br.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup2();' /> </div></div>");
//				br.append(" </td> ");
//				br.append(" </tr> ");
				
				br.append("<tr> ");
				br.append("<td align='right'>");
				br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				br.append("<img style='cursor: pointer; ' title='Print Page'  ");
				br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData2();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
				br.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(2);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(2);' /> </div></div>");
				br.append(" </td> ");
				br.append(" </tr> ");
				
				br.append(" </table> ");
				 
				 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				 br.append("<tr>");
				 
					
				 br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Base Cost(Rs.)</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SurCharge (@5%)(Rs.)</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Rs.)</b></font></td>");
					
					
				 
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
			throw new Exception("MaterialOutwardRegisterRptHLP.getIssueDetailsPopUp1()->"+e.getMessage());
		}
		return br.toString();
	}
	
	
	
	
	
	
	/**
	 * 
	 * @param ws
	 * @param materialOutwardRegisterRptFB_p
	 * @return
	 * @throws Exception
	 */
	public static String getIssueItemDetails(WebRowSet ws,MaterialOutwardRegisterRptFB materialOutwardRegisterRptFB_p) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 1000;
		final int PAGE_PER_BLOCK = 10;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		String strTableWidth = "700";
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		
		try
	    {			
			
	//		br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
	//	 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Challan Consolidated Details</td></tr></table>");	
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
			 br.append("<tr style=\"display: none;\">");
			 br.append("<td class='LABEL'>");
			 NumberFormat formatter = new DecimalFormat("############.##");  
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");			
	//////////////////////////////////////
		
			br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			br.append("<tr><td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
	//		br.append(res.getString("REPORT_TITLE"));
	//		//System.out.println("ws.getString(4)"+ws.getString(4));
			if(ws.next())
			
			br.append(ws.getString(4));
			
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
	//		br.append(res.getString("FULL_TITLE"));
			br.append("Material Outward Register");
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
	//		br.append(res.getString("CITY"));
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("</table> ");
			
			
			br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
//			br.append("<tr> ");
//			br.append("<td align='right'>");
//			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
//			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
//			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
//			br.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();' /> </div></div>");
//			br.append(" </td> ");
//			br.append(" </tr> ");
			br.append("<tr> ");
			br.append("<td align='right'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			br.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(1);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' /> </div></div>");
			br.append(" </td> ");
			br.append(" </tr> ");
			
			br.append(" </table> ");
			br.append(" <br> ");
			br.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
			
			
			
			br.append("<table border='1' width='").append(strTableWidth).append("' align='center'> ");
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			//br.append("<tr class='TITLE'>");
			//br.append("<td colspan='4'></td></tr>");
			br.append("<tr bgcolor='#cdc9c9'> ");
			
			/*br.append("<td  colspan='1' width='50%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
			br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
			br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
			br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font></td>");
			br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");				
			br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received By</b></font></td>");*/
			
			
			br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='70%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Institution Name</b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Value(Rs.)</b></font></td>");
			
			
			br.append("</tr>");
			br.append("</table>");
			
	/////////////////////////////////////	
			
			//Commented by Vivek
	/*			
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				//br.append("<tr class='TITLE'>");
				//br.append("<td colspan='4'></td></tr>");
				br.append("<tr>");
				
				br.append("<td CLASS='multiLabel' colspan='1' width='50%'>Drug Name</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Batch No.</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Expiry Date</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Issue Qty</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Value</td>");				
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Received By</td>");
				
				
				br.append("</tr>");
				br.append("</table>");*/
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
				
				ws.beforeFirst();
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{
						
						 /* Value Pass in Web Row Set
				    	   1. Issue No
				    	   2. Issue Date  
			               3. Store Name Issue To,
			               4. Store Name 
			               5. Generic Item
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
												
						String strChallanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31);
						
						br.append("<tr>");
						br.append("<input type='hidden' name='demandFlg'  value='1'>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strChallanHidValue+"'>");
									
						br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+(j+1)+"</td>");
						br.append("<td style=\"text-align: center;\" colspan='1' width='70%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(3)+"</td>");
						br.append("<td style=\"text-align: right;\" colspan='1' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(ws.getString(30)))+"</td>");
						
						/*br.append("<td  colspan='1' width='50%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(6)+"</td>");
						br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(7)+"</td>");
						br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(8)+"</td>");
						br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(10)+"</td>");
						br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(30)+"</td>");
						br.append("<td  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(27)+"</td>");*/
						
						
						br.append("</tr>");
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(30)));  
						cltamt  = Double.parseDouble(strItemTotCost);
						
						totalCost = totalCost + cltamt;
						
						
						count++ ;
					}else{
						break;
					}
				}
					br.append("</table>");
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td colspan='2' width='80%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					br.append("<td colspan='1' width='20%'  style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(FinaltotalCost);				
					br.append("</font></td>");
					br.append("</tr>");
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
		               24.Catg Code
		               25.Balance Qty
		               26.Remrkas
		               27.Recevide By
		               28.Issue By
		               29.Final remarks
		               30.Cost
		               31.Avl Budget 
		              
			    	 */    	 
					String strChallanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31);
					
					br.append("<tr>");
					br.append("<input type='hidden' name='demandFlg'  value='1'>");
					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strChallanHidValue+"'>");
					
					
					br.append("<td class='multiControl' colspan='1' width='50%'>"+ws.getString(6)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(7)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(8)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(10)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(30)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(27)+"</td>");
					
					
					br.append("</tr>");
					
					br.append("<tr>");
					br.append("<td colspan='8' align='center' ><b>------------------------------------------------------------</b></font></td>");
					br.append("</tr>");
					
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(30)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					
					totalCost = totalCost + cltamt;
					count++ ;
				}
				br.append("</table>");
							
				String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
							
				br.append("<tr>");
				br.append("<td colspan='7' align='center' class='multiLabel'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalCost);				
				br.append("</font></td>");
				br.append("</tr>");
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
				 
				    br.append("<td CLASS='multiLabel' colspan='1' width='50%'>Drug Name</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Batch No.</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Expiry Date</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Issue Qty</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Value</td>");				
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Received By</td>");
					
				 
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
			throw new Exception("MaterialOutwardRegisterRptHLP.getPODetails()->"+e.getMessage());
		}
		return br.toString();
	}
	

}
