package mms.reports.controller.hlp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.SupplierPaymentDtailRptVO;

public class SupplierPaymentDtailRptHLP 
{
	public static String getSupplierPerformabceDetailsPopUp1(SupplierPaymentDtailRptVO vo) throws Exception 
	{
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		StringBuffer br = new StringBuffer();
		StringBuffer br1 = new StringBuffer();
		
		int count = 0;
		
		//final summary
		double grandBasicValue = 0.0;
		double grandTaxValue = 0.0;
		double grandLDCharge = 0.0;
		double grandCondPenCharge = 0.0;
		double grandLogoPenCharge = 0.0;
		double grandBrandPenCharge = 0.0;
		double grandMRPPenCharge = 0.0;
		double grandPaymentValue = 0.0;
		
		double grandTotBasicValue = 0.0;
		double grandTotTaxValue = 0.0;
		double grandTotLDCharge = 0.0;
		double grandTotCondPenCharge = 0.0;
		double grandTotLogoPenCharge = 0.0;
		double grandTotBrandPenCharge = 0.0;
		double grandTotMRPPenCharge = 0.0;
		double grandTotPaymentValue = 0.0;
		
		double suppTotBasicValue = 0.0;
		double suppTotTaxValue = 0.0;
		double suppTotLDCharge = 0.0;
		double suppTotCondPenCharge = 0.0;
		double suppTotLogoPenCharge = 0.0;
		double suppTotBrandPenCharge = 0.0;
		double suppTotMRPPenCharge = 0.0;
		double suppTotPaymentValue = 0.0;
		
		String strPONumber="";
		String amtStr = "";
		String strPODate = "";
		String strSuppName = "";
		
		int poFlag = 0;
		int suppFlag = 0;
		
		WebRowSet ws =null;
		hisglobal.utility.HisUtil util = null;
				
		//NumberFormat formatter = new DecimalFormat("############.##"); 
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		//String[] strSuppParamVal = null;
		String[] strPayParamVal = null;
		String rptType = "0";
		
		try
	    {
			util = new hisglobal.utility.HisUtil("DWH","SupplierPaymentDtailRptHLP");
			
			ws  = vo.getStrScreentTwoWs();
			rptType = vo.getStrReportId();
			
			br.append("<HTML><HEAD><link href=\"../css/transaction.css\" rel=\"stylesheet\" type=\"text/css\">");
			br.append("<script language='Javascript' src='../../mms/js/dwh_supplierPaymentDtail_rpt.js'></script><body><form><table align='center' width='1150' border='0' cellspacing='0' cellpadding='0''> ");
			br.append("<tr>");
//			br.append("<td width='10%'><div  align='right'><img width='46px' height='39px' src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");	
			br.append("<td width='10%'><div  align='right'><img width='46px' height='39px' src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
			br.append("<td width='80%' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			br.append(res.getString("REPORT_TITLE"));
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("</table> ");
						
			br.append("<table align='center' width='1150' border='0' cellspacing='0' cellpadding='0'> ");
			br.append("<tr><td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
			br.append("Supplier Payment Detail Report");			
			br.append("</font></b></td><td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
			br.append("For Supplier Name: "+vo.getStrSupplierName()+"<br>");
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
			br.append("Between: "+vo.getStrFromDate()+" and "+vo.getStrToDate());
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("</table> ");		
						
			br.append("<table border='0' width='1150' align='center'> ");
			br.append("<tr> ");
			br.append("<td align='right'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			br.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
			br.append(" </td> ");
			br.append(" </tr> ");
			br.append(" </table> ");
			
			//header
			br.append("<table width='1150' align='center' cellspacing='1px' cellpadding='1px'>");
		 	
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
					while(ws.next())
					{
						//strSuppParamVal = ws.getString(4).split("\\^");
						strPayParamVal = ws.getString(12).split("\\#");
						
						if(count==0)
	    				{
							strSuppName = ws.getString(1).trim();
	    					strPONumber = ws.getString(8).trim(); 
	    					strPODate = ws.getString(9);
	    					
	    					br1.append("<tr><td colspan=9>");
							br1.append("<font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier Name :: " + strSuppName + "</b></font>");
							br1.append("</td></tr>");
							
							count++;
	    				}
	    				
						if(!strSuppName.equalsIgnoreCase(ws.getString(1).trim()))
						{
							if(poFlag > 0)
							{
								//supplier wise total
								br1.append("<tr><td colspan='9'><hr></td></tr>");
		    					br1.append("<tr> ");
								br1.append("<td style=\"text-align: left;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>\n");
		    					br1.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotBasicValue) + "</b></font></td>\n");
		    					br1.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotTaxValue) + "</b></font></td>\n");
		    					br1.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotLDCharge) + "</b></font></td>\n");
		    					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotCondPenCharge) + "</b></font></td>\n");
		    					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotLogoPenCharge) + "</b></font></td>\n");
		    					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotBrandPenCharge) + "</b></font></td>");
		    					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotMRPPenCharge) + "</b></font></td>\n");
		    					br1.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotPaymentValue) + "</b></font></td>\n");
		    					br1.append("</tr>");
		    					br1.append("<tr><td colspan='9'><hr></td></tr>");
		    					
								br1.append("<tr><td colspan=9>");
								br1.append("<font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier Name :: " + strSuppName + "</b></font>");
								br1.append("</td></tr>");
								
								strSuppName = ws.getString(1).trim();
								suppTotBasicValue = 0.0;
								suppTotTaxValue = 0.0;
								suppTotLDCharge = 0.0;
								suppTotCondPenCharge = 0.0;
								suppTotLogoPenCharge = 0.0;
								suppTotBrandPenCharge = 0.0;
								suppTotMRPPenCharge = 0.0;
								suppTotPaymentValue = 0.0;
							}
							else
								suppFlag = 1;
						}
							
						//final summary
    					if(!strPONumber.equalsIgnoreCase(ws.getString(8).trim()))
						{
    						br1.append("<tr> ");
    						br1.append("<td style=\"text-align: left;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + strPONumber+"/"+strPODate + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandBasicValue) + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandTaxValue) + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandLDCharge) + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandCondPenCharge) + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandLogoPenCharge) + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandBrandPenCharge) + "</font></td>");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandMRPPenCharge) + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandPaymentValue) + "</font></td>\n");
        					br1.append("</tr>");
        					
        					//for final summary
    						grandBasicValue = 0.0;
    						grandTaxValue = 0.0;
    						grandLDCharge = 0.0;
    						grandCondPenCharge = 0.0;
    						grandLogoPenCharge = 0.0;
    						grandBrandPenCharge = 0.0;
    						grandMRPPenCharge = 0.0;
    						grandPaymentValue = 0.0;
    						
    						strPONumber = ws.getString(8).trim(); 
    						strPODate = ws.getString(9);
    						
    						if(suppFlag == 1 && poFlag == 0)
    						{
    							//supplier wise total
    							br1.append("<tr><td colspan='9'><hr></td></tr>");
    	    					br1.append("<tr> ");
    							br1.append("<td style=\"text-align: left;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>\n");
    	    					br1.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotBasicValue) + "</b></font></td>\n");
    	    					br1.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotTaxValue) + "</b></font></td>\n");
    	    					br1.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotLDCharge) + "</b></font></td>\n");
    	    					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotCondPenCharge) + "</b></font></td>\n");
    	    					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotLogoPenCharge) + "</b></font></td>\n");
    	    					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotBrandPenCharge) + "</b></font></td>");
    	    					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotMRPPenCharge) + "</b></font></td>\n");
    	    					br1.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotPaymentValue) + "</b></font></td>\n");
    	    					br1.append("</tr>");
    	    					br1.append("<tr><td colspan='9'><hr></td></tr>");
    	    					
    	    					strSuppName = ws.getString(1).trim();
    	    					
    							br1.append("<tr><td colspan=9>");
    							br1.append("<font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier Name :: " + strSuppName + "</b></font>");
    							br1.append("</td></tr>");
    							
    							strSuppName = ws.getString(1).trim();
    							suppTotBasicValue = 0.0;
    							suppTotTaxValue = 0.0;
    							suppTotLDCharge = 0.0;
    							suppTotCondPenCharge = 0.0;
    							suppTotLogoPenCharge = 0.0;
    							suppTotBrandPenCharge = 0.0;
    							suppTotMRPPenCharge = 0.0;
    							suppTotPaymentValue = 0.0;
    							
    							suppFlag = 0;
    						}
    						
    						poFlag++;
						}
    					
    					//for final summary
						grandBasicValue += Double.parseDouble(strPayParamVal[9]);
						grandTaxValue += Double.parseDouble(strPayParamVal[20]);
						grandLDCharge += Double.parseDouble(strPayParamVal[12]);
						grandCondPenCharge += Double.parseDouble(strPayParamVal[14]);
						grandLogoPenCharge += Double.parseDouble(strPayParamVal[15]);
						grandBrandPenCharge += Double.parseDouble(strPayParamVal[16]);
						grandMRPPenCharge += Double.parseDouble(strPayParamVal[17]);
						grandPaymentValue += Double.parseDouble(strPayParamVal[21]);
						
						grandTotBasicValue += Double.parseDouble(strPayParamVal[9]);
						grandTotTaxValue += Double.parseDouble(strPayParamVal[20]);
						grandTotLDCharge += Double.parseDouble(strPayParamVal[12]);
						grandTotCondPenCharge += Double.parseDouble(strPayParamVal[14]);
						grandTotLogoPenCharge += Double.parseDouble(strPayParamVal[15]);
						grandTotBrandPenCharge += Double.parseDouble(strPayParamVal[16]);
						grandTotMRPPenCharge += Double.parseDouble(strPayParamVal[17]);
						grandTotPaymentValue += Double.parseDouble(strPayParamVal[21]);
						
						suppTotBasicValue += Double.parseDouble(strPayParamVal[9]);
						suppTotTaxValue += Double.parseDouble(strPayParamVal[20]);
						suppTotLDCharge += Double.parseDouble(strPayParamVal[12]);
						suppTotCondPenCharge += Double.parseDouble(strPayParamVal[14]);
						suppTotLogoPenCharge += Double.parseDouble(strPayParamVal[15]);
						suppTotBrandPenCharge += Double.parseDouble(strPayParamVal[16]);
						suppTotMRPPenCharge += Double.parseDouble(strPayParamVal[17]);
						suppTotPaymentValue += Double.parseDouble(strPayParamVal[21]);
    					
					} //while loop
					
					//last row (payment detail info)
					if(count > 0)
					{
						//header
    					br.append("<tr><td colspan='9'>&nbsp;</td></tr>");
    					
    					br.append("<tr><td colspan='9'><hr></td></tr>");
    					br.append("<tr bgcolor='#cdc9c9'> ");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No/ Date<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Basic Amount (Active)<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(+) VAT/CST<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) LD Charge<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) Other Penalty (Drug Condition)<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) Other Penalty (Logogram Not Printed)<b></font></td>");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) Other Penalty (Brand Name Printed)<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) Other Penalty (MRP Printed)<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Final Payment Value<b></font></td>\n");
    					br.append("</tr>");
    					br.append("<tr><td colspan='9'><hr></td></tr>");
    					br.append(br1);
    					
    					//last row
    					br.append("<tr> ");
						br.append("<td style=\"text-align: left;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + strPONumber+"/"+strPODate + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandBasicValue) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandTaxValue) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandLDCharge) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandCondPenCharge) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandLogoPenCharge) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandBrandPenCharge) + "</font></td>");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandMRPPenCharge) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandPaymentValue) + "</font></td>\n");
    					br.append("</tr>");
    					
    					//supplier wise total
    					br.append("<tr><td colspan='9'><hr></td></tr>");
    					br.append("<tr> ");
						br.append("<td style=\"text-align: left;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotBasicValue) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotTaxValue) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotLDCharge) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotCondPenCharge) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotLogoPenCharge) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotBrandPenCharge) + "</b></font></td>");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotMRPPenCharge) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(suppTotPaymentValue) + "</b></font></td>\n");
    					br.append("</tr>");
    					br.append("<tr><td colspan='9'><hr></td></tr>");
    					
    					//grand total
    					br.append("<tr> ");
						br.append("<td style=\"text-align: left;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Grand Total</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotBasicValue) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotTaxValue) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotLDCharge) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotCondPenCharge) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotLogoPenCharge) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotBrandPenCharge) + "</b></font></td>");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotMRPPenCharge) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotPaymentValue) + "</b></font></td>\n");
    					br.append("</tr>");
    					br.append("<tr><td colspan='9'><hr></td></tr>");
    					
    					amtStr = "Final Payment Value In Words:			(" + util.toInitCap(  util.getAmountStr(myFormatter.format(grandTotPaymentValue))) + ")";
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>&nbsp;</font></td>");
    					br.append("<td colspan='8' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + amtStr + "</strong></font></td>");
						br.append("</tr>");
						
					}
					
					if(ws != null)
					{
						ws.close();
						ws = null;
					}
				} //ws.size <> 0
				else
				{
					br.append("<tr>");
					br.append("<td colspan='9'><b><div id='id' align='center'>No Data Found</div></b></td>");
					br.append("</tr>");
				}
			}
			else
			{
				br.append("<tr>");
				br.append("<td colspan='9'><b><div id='id' align='center'>No Data Found</div></b></td>");
				br.append("</tr>");
			}
		}//try
		catch (Exception e) {	
		    e.printStackTrace();
		    
		    br.append("<tr>");
			br.append("<td colspan='9'><b><div id='id' align='center'>No Data Found</div></b></td>");
			br.append("</tr>");
			br.append("</table>");
			
			if(ws != null)
			{
				ws.close();
				ws = null;
			}
			
			throw new Exception("SupplierPaymentDtailRptHLP.getSupplierPerformabceDetailsPopUp1()->"+e.getMessage());
		}
		
		br.append("</table>");
		 	
		return br.toString();	
				
	}
	
	public static String getSupplierPerformabceDetailsPopUp1_without(SupplierPaymentDtailRptVO vo) throws Exception 
	{
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		StringBuffer br = new StringBuffer();
		StringBuffer br1 = new StringBuffer();
		
		int count = 0;
		
		//final summary
		double grandBasicValue = 0.0;
		double grandTaxValue = 0.0;
		double grandLDCharge = 0.0;
		double grandCondPenCharge = 0.0;
		double grandLogoPenCharge = 0.0;
		double grandBrandPenCharge = 0.0;
		double grandMRPPenCharge = 0.0;
		double grandPaymentValue = 0.0;
		
		double grandTotBasicValue = 0.0;
		double grandTotTaxValue = 0.0;
		double grandTotLDCharge = 0.0;
		double grandTotCondPenCharge = 0.0;
		double grandTotLogoPenCharge = 0.0;
		double grandTotBrandPenCharge = 0.0;
		double grandTotMRPPenCharge = 0.0;
		double grandTotPaymentValue = 0.0;
		
		String strPONumber="";
		String amtStr = "";
		String strPODate = "";
		String strSuppName = "";
		
		WebRowSet ws =null;
		hisglobal.utility.HisUtil util = null;
				
		//NumberFormat formatter = new DecimalFormat("############.##"); 
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		//String[] strSuppParamVal = null;
		String[] strPayParamVal = null;
		
		try
	    {
			util = new hisglobal.utility.HisUtil("DWH","SupplierPaymentDtailRptHLP");
			
			ws  = vo.getStrScreentTwoWs();
			
			br.append("<HTML><HEAD><link href=\"../css/transaction.css\" rel=\"stylesheet\" type=\"text/css\">");
			br.append("<script language='Javascript' src='../../mms/js/dwh_supplierPaymentDtail_rpt.js'></script><body><form><table align='center' width='1150' border='0' cellspacing='0' cellpadding='0''> ");
			br.append("<tr>");
//			br.append("<td width='10%'><div  align='right'><img width='46px' height='39px' src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");	
			br.append("<td width='10%'><div  align='right'><img width='46px' height='39px' src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
			br.append("<td width='80%' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
			br.append(res.getString("REPORT_TITLE"));
			br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("</table> ");
						
			br.append("<table align='center' width='1150' border='0' cellspacing='0' cellpadding='0'> ");
			br.append("<tr><td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
			br.append("Supplier Payment Detail Report");			
			br.append("</font></b></td><td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
			br.append("For Supplier Name: "+vo.getStrSupplierName()+"<br>");
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
			br.append("Between: "+vo.getStrFromDate()+" and "+vo.getStrToDate());
			br.append("</font></b></td><td width='10%'>&nbsp; ");
			br.append("</td> ");
			br.append("</tr> ");
			br.append("</table> ");		
						
			br.append("<table border='0' width='1150' align='center'> ");
			br.append("<tr> ");
			br.append("<td align='right'>");
			br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			br.append("<img style='cursor: pointer; ' title='Print Page'  ");
			br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			br.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
			br.append(" </td> ");
			br.append(" </tr> ");
			br.append(" </table> ");
			
			//header
			br.append("<table width='1150' border='0' align='center' cellspacing='1px' cellpadding='1px'>");
		 	
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
					while(ws.next())
					{
						//strSuppParamVal = ws.getString(4).split("\\^");
						strPayParamVal = ws.getString(12).split("\\#");
						
						if(count==0)
	    				{
							strSuppName = ws.getString(1).trim();
	    					strPONumber = ws.getString(8).trim(); 
	    					strPODate = ws.getString(9);
	    					
							count++;
	    				}
	    				
						//final summary
    					if(!strSuppName.equalsIgnoreCase(ws.getString(1).trim()))
						{
    						br1.append("<tr> ");
    						br1.append("<td style=\"text-align: left;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + strSuppName + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandBasicValue) + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandTaxValue) + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandLDCharge) + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandCondPenCharge) + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandLogoPenCharge) + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandBrandPenCharge) + "</font></td>");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandMRPPenCharge) + "</font></td>\n");
        					br1.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandPaymentValue) + "</font></td>\n");
        					br1.append("</tr>");
        					
        					//for final summary
    						grandBasicValue = 0.0;
    						grandTaxValue = 0.0;
    						grandLDCharge = 0.0;
    						grandCondPenCharge = 0.0;
    						grandLogoPenCharge = 0.0;
    						grandBrandPenCharge = 0.0;
    						grandMRPPenCharge = 0.0;
    						grandPaymentValue = 0.0;
    						
    						strSuppName = ws.getString(1).trim();
    						strPONumber = ws.getString(8).trim(); 
    						strPODate = ws.getString(9);
						}
    					
    					//for final summary
						grandBasicValue += Double.parseDouble(strPayParamVal[9]);
						grandTaxValue += Double.parseDouble(strPayParamVal[20]);
						grandLDCharge += Double.parseDouble(strPayParamVal[12]);
						grandCondPenCharge += Double.parseDouble(strPayParamVal[14]);
						grandLogoPenCharge += Double.parseDouble(strPayParamVal[15]);
						grandBrandPenCharge += Double.parseDouble(strPayParamVal[16]);
						grandMRPPenCharge += Double.parseDouble(strPayParamVal[17]);
						grandPaymentValue += Double.parseDouble(strPayParamVal[21]);
						
						grandTotBasicValue += Double.parseDouble(strPayParamVal[9]);
						grandTotTaxValue += Double.parseDouble(strPayParamVal[20]);
						grandTotLDCharge += Double.parseDouble(strPayParamVal[12]);
						grandTotCondPenCharge += Double.parseDouble(strPayParamVal[14]);
						grandTotLogoPenCharge += Double.parseDouble(strPayParamVal[15]);
						grandTotBrandPenCharge += Double.parseDouble(strPayParamVal[16]);
						grandTotMRPPenCharge += Double.parseDouble(strPayParamVal[17]);
						grandTotPaymentValue += Double.parseDouble(strPayParamVal[21]);
						
					} //while loop
					
					//last row (payment detail info)
					if(count > 0)
					{
						//header
    					br.append("<tr><td colspan='9'>&nbsp;</td></tr>");
    					
    					br.append("<tr><td colspan='9'><hr></td></tr>");
    					br.append("<tr bgcolor='#cdc9c9'> ");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier Name<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Basic Amount (Active)<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(+) VAT/CST<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) LD Charge<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) Other Penalty (Drug Condition)<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) Other Penalty (Logogram Not Printed)<b></font></td>");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) Other Penalty (Brand Name Printed)<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) Other Penalty (MRP Printed)<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Final Payment Value<b></font></td>\n");
    					br.append("</tr>");
    					br.append("<tr><td colspan='9'><hr></td></tr>");
    					br.append(br1);
    					
    					//last row
    					br.append("<tr> ");
						br.append("<td style=\"text-align: left;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + strSuppName + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandBasicValue) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandTaxValue) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandLDCharge) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandCondPenCharge) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandLogoPenCharge) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandBrandPenCharge) + "</font></td>");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandMRPPenCharge) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandPaymentValue) + "</font></td>\n");
    					br.append("</tr>");
    					
    					br.append("<tr><td colspan='9'><hr></td></tr>");
    					
    					//grand total
    					br.append("<tr> ");
						br.append("<td style=\"text-align: left;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Grand Total</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotBasicValue) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotTaxValue) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotLDCharge) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotCondPenCharge) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotLogoPenCharge) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotBrandPenCharge) + "</b></font></td>");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotMRPPenCharge) + "</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>" + myFormatter.format(grandTotPaymentValue) + "</b></font></td>\n");
    					br.append("</tr>");
    					br.append("<tr><td colspan='9'><hr></td></tr>");
    					
    					amtStr = "Final Payment Value In Words:			(" + util.toInitCap( util.getAmountStr(myFormatter.format(grandTotPaymentValue))) + ")";
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>&nbsp;</font></td>");
    					br.append("<td colspan='8' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + amtStr + "</strong></font></td>");
						br.append("</tr>");
						
					}
					
					if(ws != null)
					{
						ws.close();
						ws = null;
					}
				} //ws.size <> 0
				else
				{
					br.append("<tr>");
					br.append("<td colspan='9'><b><div id='id' align='center'>No Data Found</div></b></td>");
					br.append("</tr>");
				}
			}
			else
			{
				br.append("<tr>");
				br.append("<td colspan='9'><b><div id='id' align='center'>No Data Found</div></b></td>");
				br.append("</tr>");
			}
		}//try
		catch (Exception e) {	
		    e.printStackTrace();
		    
		    br.append("<tr>");
			br.append("<td colspan='9'><b><div id='id' align='center'>No Data Found</div></b></td>");
			br.append("</tr>");
			br.append("</table>");
			
			if(ws != null)
			{
				ws.close();
				ws = null;
			}
			
			throw new Exception("SupplierPaymentDtailRptHLP.getSupplierPerformabceDetailsPopUp1()->"+e.getMessage());
		}
		
		br.append("</table>");
		 	
		return br.toString();	
				
	}
}
