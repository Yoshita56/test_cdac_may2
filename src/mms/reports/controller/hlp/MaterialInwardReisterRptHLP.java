package mms.reports.controller.hlp;

import hisglobal.utility.HisUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.MaterialInwardReisterRptVO;

public class MaterialInwardReisterRptHLP
{
	public static String getScreenTwo(WebRowSet ws) throws Exception 
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
		
		double cltamt3  = 0.00;
		double totalCost3 = 0.00;
		String strItemTotCost3="0.00";
		
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		HisUtil util = new HisUtil("mms", "getScreenTwo");
		try
	    {/* Value Pass in Web Row Set
    	    1. SUPPLIER NAME
    	    2. Supplier Address , 
            3. PO DATE 
            4. Supplied Amount 
            5. PO Net Amount
            6. Store Id
            7. PO No
    	 */    		
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Consolidated Details</td></tr></table>");	
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
				
				br.append("<td CLASS='multiLabel' colspan='1' width='5%'>Sl No.</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Supplier Name</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>PO Value(Rs.)</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Base Supplied Value(Rs.)</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Tax Value(Rs.)</td>");/*Brahmam*/
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Total Supplied Value(Rs.)</td>");/*brahmam*/
				
				//br.append("<td CLASS='multiLabel' colspan='1' width='25%'>PO Value</td>");
				
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
			    	    1. SUPPLIER NAME
			    	    2. PO NET AMT , 
			            3. Supplied Amount 
			            4. Supplier ID 
			            5. Tax Value
			            6. Total Value*/  	
						String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6);	/*Brahmam*/	
						
						br.append("<tr>");
						br.append("<input type='hidden' name='demandFlg'  value='1'>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
						br.append("<td class='multiControl' colspan='1' width='5%'>");
						br.append(start);
						br.append("</td>");
						
						
						br.append("<td style=\"text-align:left;\"  class='multiControl' colspan='1' width='20%'>");
						br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strSupplierID' id='strSupplierID"+count+"' onClick='getSupplierDtlPopUp(\""+count+"\")'>"+ws.getString(1)+"</a> &nbsp;");
						br.append("</td>");
						
						br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(2)))+"</td>");
						br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(3)))+"</td>");
						br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='15%'>"+myFormatter.format(Double.parseDouble(ws.getString(4)))+"</td>");/*Brahmam*/
						br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(5)))+"</td>");/*Brahmam*/
						
						
						//br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(12)+"</td>");
						
						
						br.append("</tr>");
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(2)));  
						cltamt  = Double.parseDouble(strItemTotCost);
						
						totalCost = totalCost + cltamt;
						
						strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(3)));  
						cltamt1  = Double.parseDouble(strItemTotCost1);
						
						totalCost1 = totalCost1 + cltamt1;
						
						strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(4)));  /* brahmam*/
						cltamt2  = Double.parseDouble(strItemTotCost2);                          
						
						totalCost2 = totalCost2 + cltamt2;
						
						
						strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(5)));  /* brahmam*/
						cltamt3  = Double.parseDouble(strItemTotCost3);                          
						
						totalCost3 = totalCost3 + cltamt3;
						
						count++ ;
						start++;
					}else{
						break;
					}
				}
					br.append("</table>");
					
					String amtStr = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost)) )+ ")";
					String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost1))) + ")";
					String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost2)) )+ ")";
					String amtStr3 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost3)) )+ ")";
					
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					String FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1)); 
					String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
					String FinaltotalCost3 = formatter.format(new BigDecimal(totalCost3)); 
					
    				 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
					 br.append("<tr>");
					 br.append("<td CLASS='multiLabel' colspan='1' width='5%'></td>");
					 br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Total Cost(Rs.)</td>");
					 br.append("<td CLASS='multiControl' colspan='1' width='20%' style=\"text-align:right; font-weight: bold;\">"+FinaltotalCost+"</td>");
					 br.append("<td CLASS='multiControl' colspan='1' width='20%' style=\"text-align:right; font-weight: bold;\">"+FinaltotalCost1+"</td>");
					 br.append("<td CLASS='multiControl' colspan='1' width='15%' style=\"text-align:right; font-weight: bold;\">"+FinaltotalCost2+"</td>");/*brahmam*/
					 br.append("<td CLASS='multiControl' colspan='1' width='20%' style=\"text-align:right; font-weight: bold;\">"+FinaltotalCost3+"</td>");/*brahmam*/
					 
					 br.append("</tr>");
					 
					 	br.append("<tr>");
						br.append("<td colspan='2' width='40%' bgcolor='#FFEBD5'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' color='#653232' ><b>Total Cost(Words)</b></font></td>");
						br.append("<td colspan='1' width='15%' bgcolor='#F1ECE2'  style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
						br.append(amtStr);				
						br.append("</font></td>");
						
						
						br.append("<td colspan='1' width='15%' bgcolor='#F1ECE2'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
						br.append(amtStr1);				
						br.append("</font></td>");
						
						br.append("<td colspan='1' width='15%' bgcolor='#F1ECE2'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
						br.append(amtStr2);				
						br.append("</font></td>");
						
						br.append("<td colspan='1' width='15%' bgcolor='#F1ECE2'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
						br.append(amtStr3);				
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
		    	    1. SUPPLIER NAME
		    	    2. PO NET AMT , 
		            3. Supplied Amount 
		            4. Supplier ID 
		            5.Tax Value
		            6.Total Value*/  	
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6);	/* brahmam Changed*/	
					
					br.append("<tr>");
					br.append("<input type='hidden' name='demandFlg'  value='1'>");
					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					br.append("<td class='multiControl' colspan='1' width='5%'>");
					br.append(start);
					br.append("</td>");
					
					
					br.append("<td style=\"text-align:left;\" class='multiControl' colspan='1' width='20%'>");
					br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strSupplierID' id='strSupplierID"+count+"' onClick='getSupplierDtlPopUp(\""+count+"\")'>"+ws.getString(1)+"</a> &nbsp;");
					br.append("</td>");
					br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(2)))+"</td>");
					br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(3)))+"</td>");
					br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='15%'>"+myFormatter.format(Double.parseDouble(ws.getString(4)))+"</td>");/*brahmam*/
					br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(5)))+"</td>");
					
					//br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(12)+"</td>");
					
					br.append("</tr>");
					
					
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(2)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					
					totalCost = totalCost + cltamt;
					
					strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(3)));  
					cltamt1  = Double.parseDouble(strItemTotCost1);
					
					totalCost1 = totalCost1 + cltamt1;
					
					strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(4)));  /* brahmam*/
					cltamt2  = Double.parseDouble(strItemTotCost2);                          
					
					totalCost2 = totalCost2 + cltamt2;
					
					
					strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(5)));  /* brahmam*/
					cltamt3  = Double.parseDouble(strItemTotCost3);                          
					
					totalCost3 = totalCost3 + cltamt3;
					
					count++ ;
				}
				br.append("</table>");
				
				String amtStr = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost))) + ")";
				String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost1))) + ")";
				String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost2))) + ")";
				String amtStr3 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost3))) + ")";
				
				String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
				String FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1));  
				String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
				String FinaltotalCost3 = formatter.format(new BigDecimal(totalCost3)); 
				 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				 br.append("<tr>");
				 br.append("<td CLASS='multiLabel' colspan='1' width='5%'></td>");
				 br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Total Cost(Rs.)</td>");
				 br.append("<td CLASS='multiControl' colspan='1' width='20%'  style=\"text-align: right;\">"+FinaltotalCost+"</td>");
				 br.append("<td CLASS='multiControl' colspan='1' width='20%'  style=\"text-align: right;\">"+FinaltotalCost1+"</td>");
				 br.append("<td CLASS='multiControl' colspan='1' width='15%'  style=\"text-align: right;\">"+FinaltotalCost2+"</td>");/*brahmam*/
				 br.append("<td CLASS='multiControl' colspan='1' width='20%'  style=\"text-align: right;\">"+FinaltotalCost3+"</td>");/*brahmam*/
				 
				 br.append("</tr>");
				 

					br.append("<tr>");
					br.append("<td colspan='2' width='40%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Words)</b></font></td>");
					br.append("<td colspan='1' width='15%'  style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					br.append(amtStr);				
					br.append("</font></td>");
					
					
					br.append("<td colspan='1' width='15%'  style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					br.append(amtStr1);				
					br.append("</font></td>");
					
					br.append("<td colspan='1' width='15%'  style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					br.append(amtStr2);				
					br.append("</font></td>");
					
					br.append("<td colspan='1' width='15%'  style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					br.append(amtStr3);				
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
				 br.append("<td CLASS='multiLabel' colspan='1' width='5%'>Sl No.</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Supplier Name</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>PO Value(Rs.)</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Base Supplied Value(Rs.)</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Tax Value(Rs.)</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Total Supplied Value(Rs.)</td>");/*brahmam*/
				 
				 br.append("</tr>");
				 br.append("<input type='hidden' name='demandFlg'  value='0'>");
	           	 br.append("<tr>");  
	           	 br.append("<td class='multiControl' colspan='6'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	 br.append("</table>");
	           	
					
			   }
			} 
		    else
				{
					 
					 
					 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
					 br.append("<tr>");
					 br.append("<td CLASS='multiLabel' colspan='1' width='5%'>Sl No.</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Supplier Name</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='20%'>PO Value(Rs.)</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Base Supplied Value(Rs.)</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Tax Value(Rs.)</td>");
						br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Total Supplied Value(Rs.)</td>");/*brahmam*/
					 
					 br.append("</tr>");
					 br.append("<input type='hidden' name='demandFlg'  value='0'>");
		          	 br.append("<tr>");  
		          	 br.append("<td class='multiControl' colspan='6'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
		          	 br.append("</table>");
		          	
						
				   }
	     }
		
	catch (Exception e) {	
		 
			throw new Exception("OffLineIssueIndentTransHLP.getScreenTwo()->"+e.getMessage());
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
	public static String getPrintScreenTwo(MaterialInwardReisterRptVO vo) throws Exception 
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
		
		double cltamt2  = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost2="0.00";
		
		double cltamt3  = 0.00;
		double totalCost3 = 0.00;
		String strItemTotCost3="0.00";
		
		HisUtil util = new HisUtil("mms", "MaterialInwardReisterRptHLP");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		WebRowSet ws = vo.getStrScreentTwoWs();
		String strHiddenValue = vo.getStrHiddenValue();
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
			sb.append("</tr>");			
			sb.append("<tr>");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append("Material Inward Register");
			sb.append("</font></b></td><td width='10%'>&nbsp;</td> ");
			sb.append("</tr>");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Selected Store:: ");
			sb.append(vo.getStrSupplierName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> Between :: ");
			sb.append(vo.getStrFromDate()+"  TO  " +vo.getStrToDate());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");

			
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(4);' /> <img style='cursor: pointer; ' title='Get Back Report'  ");
			sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(4);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(4);' /></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
		
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='17%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier Name</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Value(Rs.)</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Base Supplied Value(Rs.)</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax Value(Rs.)</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Supplied Value(Rs.)</b></font> ");
			sb.append("</td> ");
			
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
			
					/* Value Pass in Web Row Set
		    	    1. SUPPLIER NAME
		    	    2. PO NET AMT , 
		            3. Supplied Amount 
		            4. Supplier ID 
		            5. Tax Value
		            6. Total Value*/  	
							
							NumberFormat formatter = new DecimalFormat("############.##");  
						    
							strItemTotCost = formatter.format(new BigDecimal(ws.getString(2)));  
							cltamt  = Double.parseDouble(strItemTotCost);
							
							totalCost = totalCost + cltamt;
							
							strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(3)));  
							cltamt1  = Double.parseDouble(strItemTotCost1);
							
							totalCost1 = totalCost1 + cltamt1;
							
							strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(4)));  /* brahmam*/
							cltamt2  = Double.parseDouble(strItemTotCost2);                          
							
							totalCost2 = totalCost2 + cltamt2;
							
							
							strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(5)));  /* brahmam*/
							cltamt3  = Double.parseDouble(strItemTotCost3);                          
							
							totalCost3 = totalCost3 + cltamt3;
							
					//String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+strHiddenValue;		
					sb.append("<tr> ");
					//sb.append("<input type='hidden' name='strPoHidValue' id='strPoHidValue"+count+"' value='"+strCheckHidValue+"'>");
					sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:left;\"  width='17%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(1));
					sb.append("</font></td>");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(2))));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(3))));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(4))));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(5))));
					sb.append("</font></td> ");
//					sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//					sb.append(ws.getString(6));
//					sb.append("</font></td> ");
					sb.append("</tr> ");					
					
					i++;
					count++;
								
				}
					
					NumberFormat formatter = new DecimalFormat("############.##");  
				    
					String amtStr = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost))) + ")";
					String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost1))) + ")";
					String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost2))) + ")";
					String amtStr3 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost3))) + ")";
					
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					String FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1));
					String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
					String FinaltotalCost3 = formatter.format(new BigDecimal(totalCost3)); 
					
					sb.append("<tr>");
					sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' ></td>");
					sb.append("<td align='center' width='17%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+FinaltotalCost+"</b></font></td>");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+FinaltotalCost1+"</b></font></td>");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+FinaltotalCost2+"</b></font></td>");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+FinaltotalCost3+"</b></font></td>");
					sb.append("</tr>");
				   	
					sb.append("<tr>");
					sb.append("<td colspan='2' width='40%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Words)</b></font></td>");
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr);				
					sb.append("</font></td>");
					
					
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr1);				
					sb.append("</font></td>");
					
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr2);				
					sb.append("</font></td>");
					
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr3);				
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

	
	
	public static String getSupplierPODtlPopUp(WebRowSet ws,String HiddenValue) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 100;
		final int PAGE_PER_BLOCK = 100;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		double cltamt1  = 0.00;
		double totalCost1 = 0.00;
		String strItemTotCost="0.00";
		String strTotSuppliedCost="0.00";
		
		double cltamt2  = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost2="0.00";
		
		double cltamt3  = 0.00;
		double totalCost3 = 0.00;
		String strItemTotCost3="0.00";
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		try
	    {
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='5' width='100%' class='TITLE'>PO Consolidated Details</td></tr></table>");	
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
				
				br.append("<td CLASS='multiLabel' colspan='1' width='5%'></td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>PO No.</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>PO Date</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>PO Value(Rs.)</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Base Sipplied Value(Rs.)</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Tax Value(Rs.)</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Total Sipplied Value(Rs.)</td>");
				
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
				    	   1. PO TYPE
				    	   2. PO DATE , 
			            3. PO NET AMT,
			            4. STORE ID 
			            5. PO  NO
			            6. SUPPLIED AMT 
						*/
												
						String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+HiddenValue;		
						
						br.append("<tr>");
						br.append("<input type='hidden' name='demandFlg'  value='1'>");
						br.append("<input type='hidden' name='strPoHidValue' id='strPoHidValue"+count+"' value='"+strCheckHidValue+"'>");
						br.append("<td class='multiControl' colspan='1' width='5%'>");
						br.append(start);
						br.append("</td>");
						
						br.append("<td class='multiControl' colspan='1' width='20%'>");
						br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strPONo' id='strPONo"+count+"' onClick='getPoChallanDtlPopUp(\""+count+"\")'>"+ws.getString(5)+"</a> &nbsp;");
						br.append("</td>");
						
						br.append("<td class='multiControl' colspan='1' width='25%'>"+ws.getString(2)+"</td>");
						br.append("<td style=\"text-align:right;\"  class='multiControl' colspan='1' width='15%'>"+myFormatter.format(Double.parseDouble(ws.getString(3)))+"</td>");
						br.append("<td style=\"text-align:right;\"  class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(6)))+"</td>");
						br.append("<td style=\"text-align:right;\"  class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(7)))+"</td>");
						br.append("<td style=\"text-align:right;\"  class='multiControl' colspan='1' width='15%'>"+myFormatter.format(Double.parseDouble(ws.getString(8)))+"</td>");
						
						
						
						br.append("</tr>");
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(3)));  
						cltamt  = Double.parseDouble(strItemTotCost);
						
						totalCost = totalCost + cltamt;
						
						strTotSuppliedCost = formatter.format(new BigDecimal(ws.getString(6)));  
						cltamt1  = Double.parseDouble(strTotSuppliedCost);
						
						totalCost1 = totalCost1 + cltamt1;
						
						strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(7)));  /* brahmam*/
						cltamt2  = Double.parseDouble(strItemTotCost2);                          
						
						totalCost2 = totalCost2 + cltamt2;
						
						
						strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(8)));  /* brahmam*/
						cltamt3  = Double.parseDouble(strItemTotCost3);                          
						
						totalCost3 = totalCost3 + cltamt3;
						
						
						count++ ;
						start++;
					}else{
						break;
					}
				}
					br.append("</table>");
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					String FinaltotalSuppCost = formatter.format(new BigDecimal(totalCost1));
					String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
					String FinaltotalCost3 = formatter.format(new BigDecimal(totalCost3)); 
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td colspan='5' class='multiLabel' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(FinaltotalCost);				
					br.append("</font></td>");
					br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(FinaltotalSuppCost);				
					br.append("</font></td>");
					br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(FinaltotalCost2);				
					br.append("</font></td>");
					br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(FinaltotalCost3);				
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
			    	   1. PO TYPE
			    	   2. PO DATE , 
		            3. PO NET AMT,
		            4. STORE ID 
		            5. PO  NO
		            6. SUPPLIED AMT 
					*/
											
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+HiddenValue;		
					
					br.append("<tr>");
					br.append("<input type='hidden' name='demandFlg'  value='1'>");
					br.append("<input type='hidden' name='strPoHidValue' id='strPoHidValue"+count+"' value='"+strCheckHidValue+"'>");
					br.append("<td class='multiControl' colspan='1' width='5%'>");
					br.append(start);
					br.append("</td>");
					
					
					br.append("<td class='multiControl' colspan='1' width='20%'>");
					br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strPONo' id='strPONo"+count+"' onClick='getPoChallanDtlPopUp(\""+count+"\")'>"+ws.getString(5)+"</a> &nbsp;");
					br.append("</td>");
					br.append("<td class='multiControl' colspan='1' width='15%'>"+ws.getString(2)+"</td>");
					br.append("<td style=\"text-align:right;\"  class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(3)))+"</td>");
					br.append("<td style=\"text-align:right;\"  class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(6)))+"</td>");
					br.append("<td style=\"text-align:right;\"  class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(7)))+"</td>");
					br.append("<td style=\"text-align:right;\"  class='multiControl' colspan='1' width='15%'>"+myFormatter.format(Double.parseDouble(ws.getString(8)))+"</td>");
					
					br.append("</tr>");
					
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(3)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					
					totalCost = totalCost + cltamt;
					
					strTotSuppliedCost = formatter.format(new BigDecimal(ws.getString(6)));  
					cltamt  = Double.parseDouble(strTotSuppliedCost);
					
					totalCost1 = totalCost1 + cltamt1;
					
					strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(7)));  /* brahmam*/
					cltamt2  = Double.parseDouble(strItemTotCost2);                          
					
					totalCost2 = totalCost2 + cltamt2;
					
					
					strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(8)));  /* brahmam*/
					cltamt3  = Double.parseDouble(strItemTotCost3);                          
					
					totalCost3 = totalCost3 + cltamt3;
					
					count++ ;
					start++;
				}
				br.append("</table>");
							
				String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
				String FinaltotalSuppCost = formatter.format(new BigDecimal(totalCost1));
				String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
				String FinaltotalCost3 = formatter.format(new BigDecimal(totalCost3)); 
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				br.append("<tr>");
				br.append("<td colspan='5' class='multiLabel' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalCost);				
				br.append("</font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalSuppCost);				
				br.append("</font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalCost2);				
				br.append("</font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalCost3);				
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
				 
				 br.append("<div id='prevTechEntryDtlId' style='display:none;'>");
				 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				 br.append("<tr>");
				 br.append("<td CLASS='multiLabel' colspan='1' width='5%'></td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>PO No.</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='15%'>PO Date</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>PO Value(Rs.)</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Base Supplied Value(Rs.)</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Tax Value(Rs.)</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Total Supplied Value(Rs.)</td>");
					
				 
				 br.append("</tr>");
				 br.append("<input type='hidden' name='demandFlg'  value='0'>");
	           	 br.append("<tr>");  
	           	 br.append("<td class='multiControl' colspan='6'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	 br.append("</table>");
	           	 br.append("</div>");
					
			   }
			} 
	     }
		
	catch (Exception e) {	
		 
			throw new Exception("OffLineIssueIndentTransHLP.getSupplierPODtlPopUp()->"+e.getMessage());
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
	public static String getSupplierPODtlPopUpOne(MaterialInwardReisterRptVO vo) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		
		int i=1;
		int count = 0;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		double cltamt1  = 0.00;
		double totalCost1 = 0.00;
		String strItemTotCost1="0.00";
		
		double cltamt2  = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost2="0.00";
		
		double cltamt3  = 0.00;
		double totalCost3 = 0.00;
		String strItemTotCost3="0.00";
		
		
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		WebRowSet ws = vo.getStrSupplierPODtlWs();
		String strHiddenValue = vo.getStrHiddenValue();
 		String strTableWidth = "750";
 		DecimalFormat myFormatter = new DecimalFormat("0.00");

		try 
		{
			/* Value Pass in Web Row Set
    	    1. SUPPLIER NAME
    	    2. Supplier Address , 
            3. PO DATE 
            4. Supplied Amount 
            5. PO Net Amount
            6. Store Id
            7. PO No
            8.Supplier ID 	*/

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
			sb.append("Material Inward Register");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Supplier :: ");
			sb.append(vo.getStrHiddenValue().split("\\^")[0]);
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> Between :: ");
			sb.append(vo.getStrFromDate()+"  TO  " +vo.getStrToDate());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'></td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> PO Details ");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append(" </table> ");

			
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(1);' /> <img style='cursor: pointer; ' title='Get Back Record'  ");
			sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(1);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
		
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Date</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Value(Rs.)</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Base Supplied Value(Rs.)</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax Value(Rs.)</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Rs.)</b></font>");
			sb.append("</td> ");
//			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
//			sb.append("</td> ");
			
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
					
				 /* Value Pass in Web Row Set
			    	1. PO TYPE
			    	2. PO DATE , 
		            3. PO NET AMT,
		            4. STORE ID 
		            5. PO  NO
		            6. SUPPLIED AMT 
					++++++++++++++++++++++++++++++++++++
					/* Value Pass in Web Row Set
		    	    1. SUPPLIER NAME
		    	    2. Supplier Address , 
		            3. PO DATE 
		            4. Supplied Amount 
		            5. PO Net Amount
		            6. Store Id
		            7. PO No
		            8.Supplier ID 				
				*/
							
							NumberFormat formatter = new DecimalFormat("############.##");  
						    
							strItemTotCost = formatter.format(new BigDecimal(ws.getString(3)));  
					
					
					cltamt     = Double.parseDouble(strItemTotCost);										
					totalCost  = totalCost + cltamt;
					
					cltamt1    = Double.parseDouble(formatter.format(new BigDecimal(ws.getString(6))));										
					totalCost1 = totalCost1 + cltamt1;
					
					strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(7)));  /* brahmam*/
					cltamt2  = Double.parseDouble(strItemTotCost2);                          
					
					totalCost2 = totalCost2 + cltamt2;
					
					
					strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(8)));  /* brahmam*/
					cltamt3  = Double.parseDouble(strItemTotCost3);                          
					
					totalCost3 = totalCost3 + cltamt3;
					
					
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+strHiddenValue;		
					sb.append("<tr> ");
					sb.append("<input type='hidden' name='strPoHidValue' id='strPoHidValue"+count+"' value='"+strCheckHidValue+"'>");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strPONo' id='strPONo"+count+"' onClick='getPoChallanDtlPopUp(\""+count+"\")'>"+ws.getString(5)+"</a>");
					sb.append("</font></td>");
					sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(2));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(3))));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(6))));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(7))));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(8))));
					sb.append("</font></td> ");
					sb.append("</tr> ");
					i++;
					count++;
								
				}
					
					NumberFormat formatter = new DecimalFormat("############.##");  
				    
					String amtStr = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost))) + ")";
					String amtStr1 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost1))) + ")";
					String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost2))) + ")";
					String amtStr3 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost3))) + ")";
					
					
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					String FinaltotalCost1 = formatter.format(new BigDecimal(totalCost1)); 
					String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
					String FinaltotalCost3 = formatter.format(new BigDecimal(totalCost3));
					sb.append("<tr>");
					sb.append("<td colspan='3' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Rs.)</b></font></td>");
					sb.append("<td colspan='1' style=\"text-align:right;\"><b>");
					sb.append(FinaltotalCost);				
					sb.append("</b></td>");
					sb.append("<td style=\"text-align:right;\" colspan='1'><b>");
					sb.append(FinaltotalCost1);				
					sb.append("</b></td>");
					sb.append("<td style=\"text-align:right;\" colspan='1'><b>");
					sb.append(FinaltotalCost2);				
					sb.append("</b></td>");
					sb.append("<td style=\"text-align:right;\" colspan='1'><b>");
					sb.append(FinaltotalCost3);				
					sb.append("</b></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='3' width='40%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value(Words)</b></font></td>");
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr);				
					sb.append("</font></td>");
					
					
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr1);				
					sb.append("</font></td>");
					
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr2);				
					sb.append("</font></td>");
					
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr3);				
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

	
	public static String getPODetails(WebRowSet ws) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 100;
		final int PAGE_PER_BLOCK = 100;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		try
	    {
			 /* Value Pass in Web Row Set
	    	   1. SUPPLIER NAME
	    	   2. PO With PREFIX , 
            3. CATG NAME,
            4. PO TYPE 
            5. QU NO
            6. QU DATE 
            7. TENDER NO 
            8. TENDER DATE 
            9. SUPPLIER ADD 
            10.PO DATE
            11.TAX
            12.AMT  
            13.Store Id
            14. PO No
	    	 */    	
			
			/*br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='1' width='5%' class='TITLE'>");
			br.append("<div id='plusPrevTechEntryDtlId' align='center' style='display:none;'>");
			br.append("<img src='../../hisglobal/images/plus.gif' style='cursor: pointer; '"); 
			br.append("onClick=view1('plusPrevTechEntryDtlId','minusPrevTechEntryDtlId','prevTechEntryDtlId');>");
			br.append("</div>");
			br.append("<div id='minusPrevTechEntryDtlId' style='display:block;' align='center'>");
			br.append("<img src='../../hisglobal/images/minus.gif' style='cursor: pointer; '"); 
			br.append("onClick=view2('plusPrevTechEntryDtlId','minusPrevTechEntryDtlId','prevTechEntryDtlId');>");
			br.append("</div></td><td colspan='3' width='95%' class='TITLE'>Consolidated Details</td></tr></table>");	
			*/
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='6' width='100%' class='TITLE'>PO Consolidated Details</td></tr></table>");	
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
				
				br.append("<td CLASS='multiLabel' colspan='1' width='5%'></td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='25%'>PO No.</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='25%'>PO Date</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='25%'>Supplier Name</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>PO Value</td>");
				
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
				    	   1. SUPPLIER NAME
				    	   2. PO With PREFIX , 
			               3. CATG NAME,
			               4. PO TYPE 
			               5. QU NO
			               6. QU DATE 
			               7. TENDER NO 
			               8. TENDER DATE 
			               9. SUPPLIER ADD 
			               10.PO DATE
			               11.TAX
			               12.AMT  
			               13.Store Id
			               14. PO No
				    	 */    	 	
												
						String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14);		
						
						br.append("<tr>");
						br.append("<input type='hidden' name='demandFlg'  value='1'>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
						br.append("<td class='multiControl' colspan='1' width='5%'>");
						br.append("<input type='radio' name='checkid' id='checkid"+count+"' value='0' onClick='chkBoxClick(this,\""+count+"\");'> </td>");
						
						
						br.append("<td class='multiControl' colspan='1' width='25%'>"+ws.getString(2)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='25%'>"+ws.getString(10)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='25%'>"+ws.getString(1)+"</td>");
						br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(12)))+"</td>");
						
						
						br.append("</tr>");
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(12)));  
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
					br.append("<td colspan='7' class='multiLabel' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
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
			    	   1. SUPPLIER NAME
			    	   2. PO With PREFIX , 
		               3. CATG NAME,
		               4. PO TYPE 
		               5. QU NO
		               6. QU DATE 
		               7. TENDER NO 
		               8. TENDER DATE 
		               9. SUPPLIER ADD 
		               10.PO DATE
		               11.TAX
		               12.AMT  
		               13.Store Id
		               14. PO No
			    	 */    	
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(3)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14);					
					
					br.append("<tr>");
					br.append("<input type='hidden' name='demandFlg'  value='1'>");
					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					br.append("<td class='multiControl' colspan='1' width='5%'>");
					br.append("<input type='radio' name='checkid' id='checkid"+count+"' value='0' onClick='chkBoxClick(this,\""+count+"\");'> </td>");
					
					
					br.append("<td class='multiControl' colspan='1' width='25%'>"+ws.getString(2)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='25%'>"+ws.getString(10)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='25%'>"+ws.getString(1)+"</td>");
					br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='20%'>"+myFormatter.format(Double.parseDouble(ws.getString(12)))+"</td>");
					
					br.append("</tr>");
					
					
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(12)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					
					totalCost = totalCost + cltamt;
					count++ ;
				}
				br.append("</table>");
							
				String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				br.append("<tr>");
				br.append("<td colspan='7' align='left' class='multiLabel'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
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
				 
				 br.append("<div id='prevTechEntryDtlId' style='display:none;'>");
				 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				 br.append("<tr>");
				    br.append("<td CLASS='multiLabel' colspan='1' width='5%'></td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='25%'>PO No.</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='25%'>PO Date</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='25%'>Supplier Name</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>PO Value</td>");
					
				 
				 br.append("</tr>");
				 br.append("<input type='hidden' name='demandFlg'  value='0'>");
	           	 br.append("<tr>");  
	           	 br.append("<td class='multiControl' colspan='6'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	 br.append("</table>");
	           	 br.append("</div>");
					
			   }
			} 
	     }
		
	catch (Exception e) {	
		 
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
	public static String getPOChallanDtlPopUpOne(MaterialInwardReisterRptVO vo) throws Exception 
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
		
		WebRowSet ws = vo.getStrPOChallanDtlWs();
		String strHiddenValue = vo.getStrHiddenValue();
 		String strTableWidth = "750";
 		DecimalFormat myFormatter = new DecimalFormat("0.00");
 		
 		double cltamt2  = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost2="0.00";
		
		double cltamt3  = 0.00;
		double totalCost3 = 0.00;
		String strItemTotCost3="0.00";

		try 
		{
		/*
	    	   1. PO TYPE
	    	   2. PO DATE , 
         3. PO NET AMT,
         4. STORE ID 
         5. PO  NO
         6. SUPPLIED AMT 
         "+++++++++"
 	    1. SUPPLIER NAME
 	    2. Supplier Address , 
         3. PO DATE 
         4. Supplied Amount 
         5. PO Net Amount
         6. Store Id
         7. PO No
         8. Supplier ID */ 

			
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr>");
			sb.append("<td width='10%'><div  align='right'></div></td>");			
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append("Material Inward Register");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr>");
			sb.append("<tr><td width='8%'>&nbsp;</td>");
			sb.append("<td width='82%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Supplier :: ");
			sb.append(vo.getStrHiddenValue().split("\\^")[8]);
			sb.append("</font></b></td><td width='10%'>&nbsp;</td> ");
			sb.append("</tr>");
			sb.append("<tr>");
			sb.append("<td width='8%'>&nbsp;</td>");
			sb.append("<td width='82%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>PO Number :: ");
			sb.append(vo.getStrHiddenValue().split("\\^")[4]);
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			
			sb.append(" </table> ");

			
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(2);' /> <img style='cursor: pointer; ' title='Get Back Record'  ");
			sb.append(" src='../../hisglobal/images/arrdouble-left.png' onClick='hidePopup(2);' /> <img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(2);' /></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
		
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Delivery Challan No</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan Date</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Location</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b> Base Supplied Value(Rs.)</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax Value(Rs.)</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Supplied Value(Rs.)</b></font>");
			sb.append("</td> ");
		
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
			
					/* Value Pass in Web Row Set
			    	   1. Chaalna No
			    	   2. Challan Date , 
		               3. Store Name(Location),
		               4. Value 
		               5. Stor ID(Location)
	                "+++++++++"
			    	   1. PO TYPE
			    	   2. PO DATE , 
		            3. PO NET AMT,
		            4. STORE ID 
		            5. PO  NO
		            6. SUPPLIED AMT 
	                "+++++++++"
		    	    1. SUPPLIER NAME
		    	    2. Supplier Address , 
		            3. PO DATE 
		            4. Supplied Amount 
		            5. PO Net Amount
		            6. Store Id
		            7. PO No
		            8. Supplier ID */  		
											
								
					NumberFormat formatter = new DecimalFormat("############.##");  
						    
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(4)));  
					
					cltamt  = Double.parseDouble(strItemTotCost);
										
					totalCost = totalCost + cltamt;
					
					strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(5)));  /* brahmam*/
					cltamt2  = Double.parseDouble(strItemTotCost2);                          
					
					totalCost2 = totalCost2 + cltamt2;
					
					
					strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(6)));  /* brahmam*/
					cltamt3  = Double.parseDouble(strItemTotCost3);                          
					
					totalCost3 = totalCost3 + cltamt3;
					
					String strChalllanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+vo.getStrHiddenValue();		
					
					sb.append("<tr> ");
					sb.append("<input type='hidden' name='strChalllanHidValue' id='strChalllanHidValue"+count+"' value='"+strChalllanHidValue+"'>");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strChallanNo' id='strChallanNo"+count+"' onClick='getPoChallanItemDtlPopUp(\""+count+"\")'>"+ws.getString(1)+"</a>");
					sb.append("</font></td>");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(2));
					sb.append("</font></td> ");
					sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(4))));
					sb.append("</font></td> ");
					
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(5))));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(6))));
					sb.append("</font></td> ");
					sb.append("</tr> ");
					i++;
					count++;				
								
				}
					
					NumberFormat formatter = new DecimalFormat("############.##");  
					 
					String amtStr = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost))) + ")";
					String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost2))) + ")";
					String amtStr3 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost3))) + ")";
										
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost)); 
					String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
					String FinaltotalCost3 = formatter.format(new BigDecimal(totalCost3));
					
					sb.append("<tr>");
					sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Supplied Value(Rs.)</b></font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(FinaltotalCost);				
					sb.append("</font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(FinaltotalCost2);				
					sb.append("</font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(FinaltotalCost3);				
					sb.append("</font></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='4' width='55%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Suppplied Value(Words)</b></font></td>");
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr);				
					sb.append("</font></td>");
										
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr2);				
					sb.append("</font></td>");
					
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr3);				
					sb.append("</font></td>");
				
			}	
			else 
			{

				sb.append("<tr> ");
				sb.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {
			
			//System.out.println("Exception Catches in challanPO Detail Popup");

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}

	
	
	
	public static String getPOChallanDtlPopUp(WebRowSet ws,String strHiddenValue) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 100;
		final int PAGE_PER_BLOCK = 100;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		double cltamt2  = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost2="0.00";
		
		double cltamt3  = 0.00;
		double totalCost3 = 0.00;
		String strItemTotCost3="0.00";
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		try
	    {			
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Challan Consolidated Details</td></tr></table>");	
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
				
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'></td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Delivery Challan No.</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Challan Date</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Loaction</td>");
				
//				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Expiry Date</td>");				
//				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Received Qty</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Base Supplied Value(Rs.)</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Tax Value(Rs.)</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Total Supplied Value(Rs.)</td>");
				
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
				    	   1. Chaalna No
				    	   2. Challan Date , 
			               3. Store Name(Location),
			               4. Value 
		                "+++++++++"
				    	   1. PO TYPE
				    	   2. PO DATE , 
			            3. PO NET AMT,
			            4. STORE ID 
			            5. PO  NO
			            6. SUPPLIED AMT 
		                "+++++++++"
			    	    1. SUPPLIER NAME
			    	    2. Supplier Address , 
			            3. PO DATE 
			            4. Supplied Amount 
			            5. PO Net Amount
			            6. Store Id
			            7. PO No
			            8. Supplier ID */  		
												
						String strChalllanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+strHiddenValue;
						
						br.append("<tr>");
						
						br.append("<input type='hidden' name='strChalllanHidValue' id='strChalllanHidValue"+count+"' value='"+strChalllanHidValue+"'>");
						
						br.append("<td class='multiControl' colspan='1' width='10%'>"+start+"</td>");
						br.append("<td class='multiControl' colspan='1' width='10%'>");
						br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strChallanNo' id='strChallanNo"+count+"' onClick='getPoChallanItemDtlPopUp(\""+count+"\")'>"+ws.getString(1)+"</a> &nbsp;");
						br.append("</td>");						
						br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(2)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(3)+"</td>");
						br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='15%'>"+myFormatter.format(Double.parseDouble(ws.getString(4)))+"</td>");
						br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(5)))+"</td>");
						br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='15%'>"+myFormatter.format(Double.parseDouble(ws.getString(6)))+"</td>");
						//br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(8)+"</td>");
						//br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(9)+"</td>");
						
						br.append("</tr>");
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(4)));  
						cltamt  = Double.parseDouble(strItemTotCost);
						
						totalCost = totalCost + cltamt;
						
						strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(5)));  /* brahmam*/
						cltamt2  = Double.parseDouble(strItemTotCost2);                          
						
						totalCost2 = totalCost2 + cltamt2;
						
						
						strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(6)));  /* brahmam*/
						cltamt3  = Double.parseDouble(strItemTotCost3);                          
						
						totalCost3 = totalCost3 + cltamt3;
						
						count++ ;
						start++;
					}else{
						break;
					}
				}
					br.append("</table>");
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
					String FinaltotalCost3 = formatter.format(new BigDecimal(totalCost3));
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td colspan='7' class='multiLabel' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(FinaltotalCost);				
					br.append("</font></td>");
					br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(FinaltotalCost2);				
					br.append("</font></td>");
					br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(FinaltotalCost3);				
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
			    	   1. Chaalna No
			    	   2. Challan Date , 
		               3. Store Name(Location),
		               4. Value 
	                "+++++++++"
			    	   1. PO TYPE
			    	   2. PO DATE , 
		            3. PO NET AMT,
		            4. STORE ID 
		            5. PO  NO
		            6. SUPPLIED AMT 
	                "+++++++++"
		    	    1. SUPPLIER NAME
		    	    2. Supplier Address , 
		            3. PO DATE 
		            4. Supplied Amount 
		            5. PO Net Amount
		            6. Store Id
		            7. PO No
		            8. Supplier ID */  		
					String strChalllanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+strHiddenValue;				
					br.append("<input type='hidden' name='strChalllanHidValue' id='strChalllanHidValue"+count+"' value='"+strChalllanHidValue+"'>");
					
					br.append("<td class='multiControl' colspan='1' width='10%'>"+start+"</td>");
					br.append("<td class='multiControl' colspan='1' width='10%'>");
					br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strChallanNo' id='strChallanNo"+count+"' onClick='getPoChallanItemDtlPopUp(\""+count+"\")'>"+ws.getString(1)+"</a> &nbsp;");
					br.append("</td>");						
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(2)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(3)+"</td>");
					br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='15%'>"+myFormatter.format(Double.parseDouble(ws.getString(4)))+"</td>");
					br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(5)))+"</td>");
					br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='15%'>"+myFormatter.format(Double.parseDouble(ws.getString(6)))+"</td>");
					//br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(8)+"</td>");
					//br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(9)+"</td>");
					
					br.append("</tr>");
					
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(4)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					
					totalCost = totalCost + cltamt;
					
					strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(5)));  /* brahmam*/
					cltamt2  = Double.parseDouble(strItemTotCost2);                          
					
					totalCost2 = totalCost2 + cltamt2;
					
					
					strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(6)));  /* brahmam*/
					cltamt3  = Double.parseDouble(strItemTotCost3);                          
					
					totalCost3 = totalCost3 + cltamt3;
					
					
					count++ ;
					start++;
				}
				br.append("</table>");
							
				String FinaltotalCost = formatter.format(new BigDecimal(totalCost)); 
				String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
				String FinaltotalCost3 = formatter.format(new BigDecimal(totalCost3));
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				br.append("<tr>");
				br.append("<td colspan='7' align='left' class='multiLabel'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalCost);				
				br.append("</font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalCost2);				
				br.append("</font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalCost3);				
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
				 
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'></td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Delivery Challan No.</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Challan Date</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Loaction</td>");
					
//					br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Expiry Date</td>");				
//					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Received Qty</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Base Supplied Value(Rs.)</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Tax Value(Rs.)</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Total Supplied Value(Rs.)</td>");

					
				 
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
	public static String getChallanItemDtlPopUpOne(MaterialInwardReisterRptVO vo) throws Exception 
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
		
		WebRowSet ws = vo.getStrChallanItemDtlWs();
		String strHiddenValue = vo.getStrHiddenValue();
 		String strTableWidth = "750";
 		DecimalFormat myFormatter = new DecimalFormat("0.00");
 		
 		double cltamt2  = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost2="0.00";
		
		double cltamt3  = 0.00;
		double totalCost3 = 0.00;
		String strItemTotCost3="0.00";
 		

		try 
		{
			
			/* Value Pass in Web Row Set
	    	   1. Chaalna No
	    	   2. Challan Date , 
            3. Store Name(Location),
            4. Value 
            5. Stor ID(Location)
            ++++++++++++++++++++
	    	   1. PO TYPE
	    	   2. PO DATE , 
	            3. PO NET AMT,
	            4. STORE ID 
	            5. PO  NO
	            6. SUPPLIED AMT 
			
         "+++++++++"
 	   
	    	    1. SUPPLIER NAME
	    	    2. PO NET AMT , 
	            3. Supplied Amount 
	            4. Supplier ID */  	  	
			////System.out.println("Hidden Value ==>"+vo.getStrHiddenValue());
			//10681100001^21-Dec-2011^Baran_Dwh^5000^99901104^-1^21-Dec-2011^11340^99901134^10221100003^10000^M/S Agron Remedics Pvt Ltd^Agron Remedics Pvt Ltd^21-Dec-2011^10000^11340^99901134^10221100003^1010050

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
			sb.append("Material Inward Register");
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Supplier :: ");
			sb.append(vo.getStrHiddenValue().split("\\^")[15]);
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>PO Number :: ");
			sb.append(vo.getStrHiddenValue().split("\\^")[11]);
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Challan Number :: ");
			sb.append(vo.getStrHiddenValue().split("\\^")[0]);
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>At Location :: ");
			sb.append(vo.getStrHiddenValue().split("\\^")[2]);
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");			
			sb.append(" </table> ");			
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
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
			sb.append("</td>");

			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry date</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rec.Qty</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Base Supplied Value(Rs.)</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax Value(Rs.)</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Supplied Value(Rs.)</b></font>");
			sb.append("</td> ");
		
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
			
					/* 
					   1. Store Name
			    	   2. Drug Name , 
		               3. Batch No,
		               4. Exp Date
		               5. Received Qty
		               6.Value 
		          "+++++++++"
					  Value Pass in Web Row Set
			    	   1. Chaalna No
			    	   2. Challan Date , 
		               3. Store Name(Location),
		               4. Value 
	             "+++++++++"
			    	   1. PO TYPE
			    	   2. PO DATE , 
		            3. PO NET AMT,
		            4. STORE ID 
		            5. PO  NO
		            6. SUPPLIED AMT 
	             "+++++++++"
		    	    1. SUPPLIER NAME
		    	    2. Supplier Address , 
		            3. PO DATE 
		            4. Supplied Amount 
		            5. PO Net Amount
		            6. Store Id
		            7. PO No
		            8. Supplier ID */  	
								
					NumberFormat formatter = new DecimalFormat("############.##");  
						    
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(6)));  
					
					cltamt  = Double.parseDouble(strItemTotCost);
										
					totalCost = totalCost + cltamt;
					
					strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(7)));  /* brahmam*/
					cltamt2  = Double.parseDouble(strItemTotCost2);                          
					
					totalCost2 = totalCost2 + cltamt2;
					
					
					strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(8)));  /* brahmam*/
					cltamt3  = Double.parseDouble(strItemTotCost3);                          
					
					totalCost3 = totalCost3 + cltamt3;
					
					String strChalllanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+vo.getStrHiddenValue();		
					
					sb.append("<tr> ");
					sb.append("<input type='hidden' name='strDrugHidValue' id='strDrugHidValue"+count+"' value='"+strChalllanHidValue+"'>");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
					sb.append(i);
					sb.append("</b></font></td> ");
					
					sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(2));
					sb.append("</font></td>");
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(4));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(5));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(6))));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(7))));
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(myFormatter.format(Double.parseDouble(ws.getString(8))));
					sb.append("</font></td> ");
					sb.append("</tr> ");
					i++;
					count++;				
									
				}
					
					NumberFormat formatter = new DecimalFormat("############.##");  
				
					String amtStr = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost))) + ")";
					String amtStr2 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost2))) + ")";
					String amtStr3 = "(" + util.toInitCap( util.getAmountStr(myFormatter.format(totalCost3))) + ")";
				
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost)); 
					String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
					String FinaltotalCost3 = formatter.format(new BigDecimal(totalCost3));
					
					sb.append("<tr>");
					sb.append("<td colspan='5' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Supplied Value(Rs.)</b></font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(FinaltotalCost);				
					sb.append("</font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(FinaltotalCost2);				
					sb.append("</font></td>");
					sb.append("<td colspan='1' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(FinaltotalCost3);				
					sb.append("</font></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='5' width='55%'  style=\"text-align: center;\"><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Suppplied Value(Words)</b></font></td>");
					sb.append("<td colspan='1' width='15%'  style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr);				
					sb.append("</font></td>");
										
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr2);				
					sb.append("</font></td>");
					
					sb.append("<td colspan='1' width='15%'   style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1' >");						
					sb.append(amtStr3);				
					sb.append("</font></td>");
						 
				
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
	
	
	public static String getChallanItemDtlPopUp(WebRowSet ws,String strHiddenValue) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 100;
		final int PAGE_PER_BLOCK = 100;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
		double cltamt2  = 0.00;
		double totalCost2 = 0.00;
		String strItemTotCost2="0.00";
		
		double cltamt3  = 0.00;
		double totalCost3 = 0.00;
		String strItemTotCost3="0.00";
 		
		
		try
	    {			
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Challan Consolidated Details</td></tr></table>");	
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
				
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'></td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Drug Name.</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Batch No</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Expiry Date</td>");
//				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Expiry Date</td>");				
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Received Qty</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Base Supplied Value(Rs.)</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Tax Value(Rs.)</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Total Supplied Value(Rs.)</td>");
				
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
						
						/* 
						   1. Store Name
				    	   2. Drug Name , 
			               3. Batch No,
			               4. Exp Date
			               5. Received Qty
			               6.Value 
			          "+++++++++"
						  Value Pass in Web Row Set
				    	   1. Chaalna No
				    	   2. Challan Date , 
			               3. Store Name(Location),
			               4. Value 
		             "+++++++++"
				    	   1. PO TYPE
				    	   2. PO DATE , 
			            3. PO NET AMT,
			            4. STORE ID 
			            5. PO  NO
			            6. SUPPLIED AMT 
		             "+++++++++"
			    	    1. SUPPLIER NAME
			    	    2. Supplier Address , 
			            3. PO DATE 
			            4. Supplied Amount 
			            5. PO Net Amount
			            6. Store Id
			            7. PO No
			            8. Supplier ID */  	
												
						String strChalllanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+strHiddenValue;
						
						br.append("<tr>");
						
						br.append("<input type='hidden' name='strDrugHidValue' id='strDrugHidValue"+count+"' value='"+strChalllanHidValue+"'>");
						
																								
						br.append("<td class='multiControl' colspan='1' width='10%'>"+start+"</td>");
						br.append("<td class='multiControl' colspan='1' width='20%'>");
						br.append(ws.getString(2));
						br.append("</td>");						
						br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(3)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(4)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(5)+"</td>");
						br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(6)))+"</td>");
						br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(7)))+"</td>");
						br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(8)))+"</td>");
												
						
						br.append("</tr>");
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(6)));  
						cltamt  = Double.parseDouble(strItemTotCost);
						
						totalCost = totalCost + cltamt;
						
						strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(7)));  /* brahmam*/
						cltamt2  = Double.parseDouble(strItemTotCost2);                          
						
						totalCost2 = totalCost2 + cltamt2;
						
						
						strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(8)));  /* brahmam*/
						cltamt3  = Double.parseDouble(strItemTotCost3);                          
						
						totalCost3 = totalCost3 + cltamt3;
						
						
						count++ ;
						start++;
					}else{
						break;
					}
				}
					br.append("</table>");
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));
					String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
					String FinaltotalCost3 = formatter.format(new BigDecimal(totalCost3));
					
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td colspan='7' class='multiLabel' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(FinaltotalCost);				
					br.append("</font></td>");
					br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(FinaltotalCost2);				
					br.append("</font></td>");
					br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					br.append(FinaltotalCost3);				
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
					
					/* 
					   1. Store Name
			    	   2. Drug Name , 
		               3. Batch No,
		               4. Exp Date
		               5. Received Qty
		               6.Value 
		          "+++++++++"
					  Value Pass in Web Row Set
			    	   1. Chaalna No
			    	   2. Challan Date , 
		               3. Store Name(Location),
		               4. Value 
	             "+++++++++"
			    	   1. PO TYPE
			    	   2. PO DATE , 
		            3. PO NET AMT,
		            4. STORE ID 
		            5. PO  NO
		            6. SUPPLIED AMT 
	             "+++++++++"
		    	    1. SUPPLIER NAME
		    	    2. Supplier Address , 
		            3. PO DATE 
		            4. Supplied Amount 
		            5. PO Net Amount
		            6. Store Id
		            7. PO No
		            8. Supplier ID */  	
											
					String strChalllanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+strHiddenValue;
					
					br.append("<tr>");
					
					br.append("<input type='hidden' name='strDrugHidValue' id='strDrugHidValue"+count+"' value='"+strChalllanHidValue+"'>");
					
																							
					br.append("<td class='multiControl' colspan='1' width='10%'>"+start+"</td>");
					br.append("<td class='multiControl' colspan='1' width='20%'>");
					br.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strDrugName' id='strDrugName"+count+"' >"+ws.getString(2)+"</a> &nbsp;");
					br.append("</td>");						
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(3)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(4)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(5)+"</td>");
					br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(6)))+"</td>");
					br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(7)))+"</td>");
					br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(8)))+"</td>");
					
					br.append("</tr>");
					
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(6)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					
					totalCost = totalCost + cltamt;
					
					strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(7)));  /* brahmam*/
					cltamt2  = Double.parseDouble(strItemTotCost2);                          
					
					totalCost2 = totalCost2 + cltamt2;
					
					
					strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(8)));  /* brahmam*/
					cltamt3  = Double.parseDouble(strItemTotCost3);                          
					
					totalCost3 = totalCost3 + cltamt3;
					
					
					count++ ;
					start++;
				}
				br.append("</table>");
							
				String FinaltotalCost = formatter.format(new BigDecimal(totalCost));
				String FinaltotalCost2 = formatter.format(new BigDecimal(totalCost2)); 
				String FinaltotalCost3 = formatter.format(new BigDecimal(totalCost3));
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				br.append("<tr>");
				br.append("<td colspan='7' align='left' class='multiLabel'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalCost);				
				br.append("</font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalCost2);				
				br.append("</font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalCost3);				
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
				 
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'></td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Drug Name.</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Batch No</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Expiry Date</td>");
//					br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Expiry Date</td>");				
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Received Qty</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Base Supplied Value(Rs.)</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Tax Value(Rs.)</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Total Supplied Value(Rs.)</td>");

					
				 
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
	
	
	public static String getChallanDetails(WebRowSet ws) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 100;
		final int PAGE_PER_BLOCK = 100;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		try
	    {			
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Challan Consolidated Details</td></tr></table>");	
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
				
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Challan No.</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Challan Date</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Drug</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Batch No</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Expiry Date</td>");				
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Received Qty</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Value(Rs.)</td>");
				
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
				    	   1. Chaalna No
				    	   2. Challan Date , 
			               3. Store Name,
			               4. PO No 
			               5. Item Name
			               6. Batch No 
			               7. Exp Date 
			               8. Received Qty 
			               9. Value 
			               10.Store ID(Loaction)
			              
				    	 */    	 	
												
						String strChallanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(3)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9);
						
						br.append("<tr>");
						br.append("<input type='hidden' name='demandFlg'  value='1'>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strChallanHidValue+"'>");
						
						
						br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(1)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(2)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(5)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='15%'>"+ws.getString(6)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='15%'>"+ws.getString(7)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(8)+"</td>");
						br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(9)))+"</td>");
						
						
						
						
						br.append("</tr>");
						
						strItemTotCost = formatter.format(new BigDecimal(ws.getString(9)));  
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
					br.append("<td colspan='7' class='multiLabel' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
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
			    	   1. Chaalna No
			    	   2. Challan Date , 
		               3. Store Name,
		               4. PO No 
		               5. Item Name
		               6. Batch No 
		               7. Exp Date 
		               8. Received Qty 
		               9. Value 
		              
			    	 */    
					String strChallanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(3)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9);
					
					br.append("<tr>");
					br.append("<input type='hidden' name='demandFlg'  value='1'>");
					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strChallanHidValue+"'>");
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(1)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(2)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='20%'>"+ws.getString(5)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='15%'>"+ws.getString(6)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='15%'>"+ws.getString(7)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(8)+"</td>");
					br.append("<td style=\"text-align:right;\" class='multiControl' colspan='1' width='10%'>"+myFormatter.format(Double.parseDouble(ws.getString(9)))+"</td>");
					
					
					br.append("</tr>");
					
					
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(9)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					
					totalCost = totalCost + cltamt;
					count++ ;
				}
				br.append("</table>");
							
				String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				br.append("<tr>");
				br.append("<td colspan='7' align='left' class='multiLabel'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
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
				 
				    br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Challan No.</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Challan Date</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='20%'>Drug</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Batch No</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Expiry Date</td>");				
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Received Qty</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='10%'>Value(Rs.)</td>");
					
				 
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
	

}
