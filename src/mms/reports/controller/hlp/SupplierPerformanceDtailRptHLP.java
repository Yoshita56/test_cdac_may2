package mms.reports.controller.hlp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.SupplierPerformanceDtailRptVO;

public class SupplierPerformanceDtailRptHLP 
{
	
	public static String getScreenOne(SupplierPerformanceDtailRptVO vo) throws Exception 
	{
		StringBuffer br = new StringBuffer();
		
		int count = 0;
		int count1 = 0;
		int totalActiveQty = 0;
		int totalRecQty = 0;
		int totalOrderQty = 0;
		
		double totalOrderValue = 0.0;
		double totalRecValue = 0.0;
		double totalActiveValue = 0.0;
		
		double totalLDCharge = 0.0;
		double totalOtherCharge = 0.0;
		double totalPaymentValue = 0.0;
		
		double totalTaxValue = 0.0;
		double totalCondPenCharge = 0.0;
		double totalLogoPenCharge = 0.0;
		double totalBrandPenCharge = 0.0;
		double totalMRPPenCharge = 0.0;
		
		int ddw_active_qty = 0;
		int ddw_inactive_qty = 0;
		int ddw_quar_qty = 0;
		
		double ddw_supplied_value = 0.0;
		double ddw_penelty = 0.0;
		double ddw_other_penelty = 0.0;
		double ddw_tax = 0.0;
		double ddw_final_value = 0.0;
		
		String strDrugName="";
		String strPONumber="";
		String strDDWName="";
		String strRate = "";
		String amtStr = "";
		String strPODate = "";
		String strSuppName = "";
		
		WebRowSet ws =null;
		hisglobal.utility.HisUtil util = null;
				
		//NumberFormat formatter = new DecimalFormat("############.##"); 
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		String[] strSuppParamVal = null;
		String[] strPayParamVal = null;
		
		//header
		br.append("<table width='1150' align='center' cellspacing='1px' cellpadding='1px'>");
	 	br.append("<tr><td colspan='15' class='TITLE'>Supplier Performance Details</td></tr>\n");	
	 	
	 	//header
	 	br.append("<tr>");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Challan No/ Date</td>\n");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>Received Date</td>\n");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Batch No</td>\n");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>Report No /Date</td>\n");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>Drug Condition</td>\n");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>Whether Rajsthan Govt. Supply Not for Sale Logogram printed</td>");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Brand Name not Written</td>\n");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>Price(MRP) not printed/ Visible</td>\n");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='9%'>Qty Received (A/Q/R)</td>\n");
		//br.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Rate/ Unit</td>\n");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>Total Value of goods/ drugs received (Only For Active Qty) </td>\n");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>LD Charges to be deducted</td>\n");					
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>Other Penalty to be deducted</td>\n");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Tax Value</td>\n");
		br.append("<td CLASS='multiRPTLabel' colspan='1' width='7%'>Final Payment Value</td>\n");
		br.append("</tr>");
		
		try
	    {
			util = new hisglobal.utility.HisUtil("DWH","SupplierPerformanceDtailRptHLP");
			ws  = vo.getStrScreentTwoWs();

			if (ws != null) 
			{
				if(ws.size() != 0)
				{
					while(ws.next())
					{
						strSuppParamVal = ws.getString(4).split("\\^");
						strPayParamVal = ws.getString(12).split("\\#");
						
						if(count==0)
	    				{
	    					strDrugName = ws.getString(6).trim();
	    					strPONumber = ws.getString(8).trim(); 
							strDDWName = ws.getString(5).trim();
							strPODate = ws.getString(9);
							strSuppName = ws.getString(1);
							strRate = strPayParamVal[6] + "/" + strPayParamVal[7];
														 
							br.append("<tr>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='7'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No. & Date ::<font style='color: red; font-weight: bold'>"+ws.getString(8)+"/"+ws.getString(9)+"</font></td>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='8'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier ::<font style='color: red; font-weight: bold'>"+ws.getString(1)+"</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='10'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name ::<font style='color: red; font-weight: bold'>"+strDrugName+"</font></td>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit ::<font style='color: red; font-weight: bold'>"+strPayParamVal[6]+"/" + strPayParamVal[7] + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='4' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>DDW Name ::<font style='color: red; font-weight: bold'>"+ws.getString(5)+"</font></td>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Order Qty & Schedule Date ::<font style='color: red; font-weight: bold'>"+strPayParamVal[1]+ " " + strPayParamVal[0] + " / "+ws.getString(11)+"</font></td>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Order Value ::<font style='color: red; font-weight: bold'>"+strPayParamVal[8]+"</font></td>");
							br.append("</tr>");
							
							count++;
	    				}
	    				
						if(strPONumber.equalsIgnoreCase(ws.getString(8).trim()) && strDrugName.equalsIgnoreCase(ws.getString(6).trim()))
	    				{
							if(count1 == 0)
							{
								strRate = strPayParamVal[6] + "/" + strPayParamVal[7];
								totalOrderQty = Integer.parseInt(strPayParamVal[22]);
								totalOrderValue = Double.parseDouble(strPayParamVal[23]);
								
								count1++;
							}
							
							totalActiveQty += Integer.parseInt(strPayParamVal[2]);
							totalRecQty += Integer.parseInt(strPayParamVal[5]);
							
							totalActiveValue += Double.parseDouble(strPayParamVal[9]);
							totalRecValue += Double.parseDouble(strPayParamVal[10]);
							
							totalTaxValue += Double.parseDouble(strPayParamVal[20]);
	    					totalLDCharge += Double.parseDouble(strPayParamVal[12]);
							
							totalCondPenCharge += Double.parseDouble(strPayParamVal[14]);
							totalLogoPenCharge += Double.parseDouble(strPayParamVal[15]);
							totalBrandPenCharge += Double.parseDouble(strPayParamVal[16]);
							totalMRPPenCharge += Double.parseDouble(strPayParamVal[17]);
	    					totalOtherCharge += Double.parseDouble(strPayParamVal[18]);
	    						    					
	    					totalPaymentValue += Double.parseDouble(strPayParamVal[21]);
	    					
	    					//ddw name is not same
	    					if(!strDDWName.equalsIgnoreCase(ws.getString(5).trim()))
    						{
    							strDDWName = ws.getString(5).trim();
    							//totalOrderQty += Integer.parseInt(strPayParamVal[1]);
								//totalOrderValue += Double.parseDouble(strPayParamVal[8]);
								
								//display total ddw wise
								br.append("<tr>\n");
								br.append("<td class='multiRPTLabel'  style=\"text-align:right;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>\n");
    							br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Qty\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+ddw_active_qty + "/ " + ddw_quar_qty + "/ " + ddw_inactive_qty +"</b></font></td>");
    							br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Supplied Value (Only for Active Qty)\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_supplied_value)+ "</b></font></td>");
    							br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Penelty\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_penelty)+"</b></font></td>");
    							br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Other Penelty\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_other_penelty)+"</b></font></td>");
    							br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Tax Value\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_tax)+ "</b></font></td>");
    							br.append("<td class='multiCTLTotal'  style=\"text-align:right;\" title=\"DDW Wise Total Payment Value\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_final_value)+"</b></font></td>");
    							br.append("</tr>\n");
    							
								br.append("<tr>");
    							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='4' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>DDW Name ::<font style='color: red; font-weight: bold'>"+ws.getString(5)+"</font></td>");
    							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Order Qty & Schedule Date ::<font style='color: red; font-weight: bold'>"+strPayParamVal[1]+ " " + strPayParamVal[0] + " / "+ws.getString(11)+"</font></td>");
    							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Order Value ::<font style='color: red; font-weight: bold'>"+strPayParamVal[8]+"</font></td>");
    							br.append("</tr>");
    							
    							//initilize the variable here
								ddw_active_qty = 0;
								ddw_inactive_qty = 0;
								ddw_quar_qty = 0;
								ddw_supplied_value = 0.0;
								ddw_penelty = 0.0;
								ddw_other_penelty = 0.0;
								ddw_tax = 0.0;
								ddw_final_value = 0.0;
    						}
	    					
	    				}
	    				else
	    				{
	    					//display total ddw wise
							br.append("<tr>\n");
							br.append("<td class='multiRPTLabel'  style=\"text-align:right;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>\n");
							br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Qty\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+ddw_active_qty + "/ " + ddw_quar_qty + "/ " + ddw_inactive_qty +"</b></font></td>");
							br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Supplied Value (Only for Active Qty)\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_supplied_value)+ "</b></font></td>");
							br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Penelty\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_penelty)+"</b></font></td>");
							br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Other Penelty\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_other_penelty)+"</b></font></td>");
							br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Tax Value\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_tax)+ "</b></font></td>");
							br.append("<td class='multiCTLTotal'  style=\"text-align:right;\" title=\"DDW Wise Total Payment Value\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_final_value)+"</b></font></td>");
							br.append("</tr>\n");
							
	    					//display total here if either po no or item name is not same
	    					br.append("<tr>");
	    					br.append("<td colspan='15'>\n");
	    					
	    					br.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px'>");
	    					br.append("<tr>");
	    					br.append("<td class='multiRPTControl' colspan='9'><hr size=1></td>\n");
	    					br.append("</tr>");
	    					
	    					br.append("<tr>");
	    					br.append("<td CLASS='multiRPTLabel' style=\"text-align:left;\" colspan='9'><strong><u>Payment Details (Consolidated)</u></strong></td>\n");
	    					br.append("</tr>");
	    					
	    					br.append("<tr>");
							br.append("<td class='multiRPTControl'  style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No. & Date ::"+strPONumber+"/"+strPODate+"</td>");
							br.append("<td class='multiRPTControl'  style=\"text-align:left;\" colspan='4'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier ::"+strSuppName+"</td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiRPTControl'  style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name ::"+strDrugName+"</td>");
							br.append("<td class='multiRPTControl'  style=\"text-align:left;\" colspan='4'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit ::"+strRate + "</td>");
							br.append("</tr>");
							
	    					br.append("<tr>");
	    					br.append("<td class='multiRPTControl' style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Ordered Qty :: " + totalOrderQty + "</strong></font></td>");
							br.append("<td class='multiRPTControl' style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Ordered Value (Rs.) :: " + myFormatter.format(totalOrderValue) + "</strong></font></td>");
							br.append("<td class='multiRPTControl' style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Qty (A+Q+R) :: " + totalRecQty + "</strong></font></td>");
							br.append("<td class='multiRPTControl' style=\"text-align:left;\" colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Value (A+Q+R) (Rs.) :: " + myFormatter.format(totalRecValue) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
	    					br.append("<td class='multiRPTControl' style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Qty (Active) :: " + totalActiveQty + "</strong></font></td>");
							br.append("<td class='multiRPTControl' style=\"text-align:left;\" colspan='7'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Rate/Unit :: " + strRate + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
	    					br.append("<td class='multiRPTControl' colspan='9'><hr size=1></td>\n");
	    					br.append("</tr>");
	    					
							br.append("<tr>");
							br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>1.</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total Basic Amount (Active)" + "</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalActiveValue) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>2.</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(+) VAT/CST" + "</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalTaxValue) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>3.</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(-) LD Charge" + "</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalLDCharge) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(-) Other Penelty" + "</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalOtherCharge) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.1</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Drug Condition)" + "</font></td>");
	    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalCondPenCharge) + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.2</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Logogram Not Printed)" + "</font></td>");
	    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalLogoPenCharge) + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.3</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Brand Name Printed)" + "</font></td>");
	    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalBrandPenCharge) + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.4</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (MRP Printed)" + "</font></td>");
	    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalMRPPenCharge) + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>5.</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong><u>Final Payment Value</u>" + "</strong></font></td>");
	    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' color='red'><strong>" + myFormatter.format(totalPaymentValue) + "</strong></font></td>");
							br.append("</tr>");
							
							amtStr = "(" + util.getAmountStr(myFormatter.format(totalPaymentValue)) + ")";
							br.append("<tr>");
							br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>&nbsp;</font></td>");
	    					br.append("<td class='multiRPTControl' colspan='8' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + amtStr + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
	    					br.append("<td colspan='9'><hr size=1></td>\n");
	    					br.append("</tr>");
	    					
	    					br.append("</table></td></tr>\n");
	    					
							//po no is not same
							strDrugName = ws.getString(6).trim();
	    					strPONumber = ws.getString(8).trim(); 
							strDDWName = ws.getString(5).trim();
							strPODate = ws.getString(9);
							strSuppName = ws.getString(1);
														 
							br.append("<tr>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='7'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No. & Date ::<font style='color: red; font-weight: bold'>"+ws.getString(8)+"/"+ws.getString(9)+"</font></td>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='8'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier ::<font style='color: red; font-weight: bold'>"+ws.getString(1)+"</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='10'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name ::<font style='color: red; font-weight: bold'>"+strDrugName+"</font></td>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit ::<font style='color: red; font-weight: bold'>"+strPayParamVal[6]+"/" + strPayParamVal[7] + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='4' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>DDW Name ::<font style='color: red; font-weight: bold'>"+ws.getString(5)+"</font></td>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Order Qty & Schedule Date ::<font style='color: red; font-weight: bold'>"+strPayParamVal[1]+ " " + strPayParamVal[0] + " / "+ws.getString(11)+"</font></td>");
							br.append("<td class='multiCLRLabel'  style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Order Value ::<font style='color: red; font-weight: bold'>"+strPayParamVal[8]+"</font></td>");
							br.append("</tr>");
							
							strRate = strPayParamVal[6] + "/" + strPayParamVal[7];
							totalOrderQty = Integer.parseInt(strPayParamVal[22]);
							totalOrderValue = Double.parseDouble(strPayParamVal[23]);
							
							totalActiveQty = Integer.parseInt(strPayParamVal[2]);
							totalRecQty = Integer.parseInt(strPayParamVal[5]);
							
							totalActiveValue = Double.parseDouble(strPayParamVal[9]);
							totalRecValue = Double.parseDouble(strPayParamVal[10]);
							
							totalTaxValue = Double.parseDouble(strPayParamVal[20]);
	    					totalLDCharge = Double.parseDouble(strPayParamVal[12]);
							
							totalCondPenCharge = Double.parseDouble(strPayParamVal[14]);
							totalLogoPenCharge = Double.parseDouble(strPayParamVal[15]);
							totalBrandPenCharge = Double.parseDouble(strPayParamVal[16]);
							totalMRPPenCharge = Double.parseDouble(strPayParamVal[17]);
	    					totalOtherCharge = Double.parseDouble(strPayParamVal[18]);
	    						    					
	    					totalPaymentValue = Double.parseDouble(strPayParamVal[21]);
	    					
	    					//initilize the variable here
							ddw_active_qty = 0;
							ddw_inactive_qty = 0;
							ddw_quar_qty = 0;
							ddw_supplied_value = 0.0;
							ddw_penelty = 0.0;
							ddw_other_penelty = 0.0;
							ddw_tax = 0.0;
							ddw_final_value = 0.0;
	    				}
	    				
	    				//row
	    				br.append("<tr>\n");
						br.append("<td class='multiRPTControl' colspan='1' title=\"Challan No/Date\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(2) + "</font></td>\n");//challan no
						br.append("<td class='multiRPTControl' colspan='1' title=\"Received Date\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(3) + "</font></td>\n");//challan date								
						br.append("<td class='multiRPTControl' colspan='1' title=\"Batch No\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(7)+"</font></td>\n");//batch no
						br.append("<td class='multiRPTControl' colspan='1' title=\"Report No & Date\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[0]+"/ "+strSuppParamVal[1]+"</font></td>\n"); //reportno/date	
						
						if(strSuppParamVal[2].equalsIgnoreCase("No"))
							br.append("<td class='multiRPTControl' colspan='1' title=\"Drug Condition\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>"+strSuppParamVal[2]+"</strong></font></td>\n");//drug condition								
						else
							br.append("<td class='multiRPTControl' colspan='1' title=\"Drug Condition\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[2]+"</font></td>\n");//drug condition
						
						if(strSuppParamVal[4].equalsIgnoreCase("No"))
							br.append("<td class='multiRPTControl' colspan='1' title=\"Whether Logo Printed\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>"+strSuppParamVal[4]+"</strong></font></td>\n");//logogram
						else
							br.append("<td class='multiRPTControl' colspan='1' title=\"Whether Logo Printed\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[4]+"</font></td>\n");//logogram
						
						if(strSuppParamVal[3].equalsIgnoreCase("No"))
							br.append("<td class='multiRPTControl' colspan='1' title=\"Whether Brand Name Printed\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>"+strSuppParamVal[3]+"</strong></font></td>\n");//brand name								
						else
							br.append("<td class='multiRPTControl' colspan='1' title=\"Whether Brand Name Printed\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[3]+"</font></td>\n");//brand name
						
						if(strSuppParamVal[5].equalsIgnoreCase("No"))
							br.append("<td class='multiRPTControl' colspan='1' title=\"Whether MRP Printed\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>"+strSuppParamVal[5]+"</strong></font></td>\n");//price written								
						else
							br.append("<td class='multiRPTControl' colspan='1' title=\"Whether MRP Printed\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[5]+"</font></td>\n");//price written
						
						br.append("<td class='multiRPTControl' colspan='1' title=\"Qty Received (A+Q+R)\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strPayParamVal[2] + "/ " + strPayParamVal[3] + "/ " + strPayParamVal[4] + "</font></td>\n");//qty received
						//br.append("<td class='multiRPTControl' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strPayParamVal[6]+ "/ " + strPayParamVal[7] + "</font></td>\n"); //rate/unit
						br.append("<td class='multiRPTControl' colspan='1' title=\"Total Value of goods received (Active)\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[9]))+"</font></td>"); //total value received
						br.append("<td class='multiRPTControl' colspan='1' title=\"LD Charge\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[12]))+"@ " + strPayParamVal[11] + "%" + "</font></td>\n"); //LD Charges								
						br.append("<td class='multiRPTControl' colspan='1' title=\"Other Penelty Charge\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[18]))+"@ " + strPayParamVal[13] + "%" + "</font></td>\n"); //other penelty								
						br.append("<td class='multiRPTControl' colspan='1' title=\"Tax Value\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[20]))+"@ " + strPayParamVal[19] + "%" + "</font></td>"); //tax value
						br.append("<td class='multiRPTControl' colspan='1' style=\"text-align:right;\" title=\"Final Payment Value\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[21]))+"</font></td>\n"); //final payment value
						br.append("</tr>\n");
						
						//add ddw wise
						ddw_active_qty += Integer.parseInt(strPayParamVal[2]);
						ddw_inactive_qty += Integer.parseInt(strPayParamVal[4]);
						ddw_quar_qty += Integer.parseInt(strPayParamVal[3]);
						ddw_supplied_value += Double.parseDouble(strPayParamVal[9]);
						ddw_penelty += Double.parseDouble(strPayParamVal[12]);
						ddw_other_penelty += Double.parseDouble(strPayParamVal[18]);
						ddw_tax += Double.parseDouble(strPayParamVal[20]);
						ddw_final_value += Double.parseDouble(strPayParamVal[21]);
	    				
					} //while loop
					
					//last row (payment detail info)
					if(count > 0)
					{
						//display total ddw wise
						br.append("<tr>\n");
						br.append("<td class='multiRPTLabel'  style=\"text-align:right;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>\n");
						br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Qty\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+ddw_active_qty + "/ " + ddw_quar_qty + "/ " + ddw_inactive_qty +"</b></font></td>");
						br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Supplied Value (Only for Active Qty)\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_supplied_value)+ "</b></font></td>");
						br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Penelty\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_penelty)+"</b></font></td>");
						br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Other Penelty\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_other_penelty)+"</b></font></td>");
						br.append("<td class='multiCTLTotal'  style=\"text-align:center;\" title=\"DDW Wise Total Tax Value\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_tax)+ "</b></font></td>");
						br.append("<td class='multiCTLTotal'  style=\"text-align:right;\" title=\"DDW Wise Total Payment Value\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b>"+myFormatter.format(ddw_final_value)+"</b></font></td>");
						br.append("</tr>\n");
						
						br.append("<tr>");
    					br.append("<td colspan='15'>\n");
    					
    					br.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px'>");
    					br.append("<tr>");
    					br.append("<td class='multiRPTControl' colspan='9'><hr size=1></td>\n");
    					br.append("</tr>");
    					
    					br.append("<tr>");
    					br.append("<td CLASS='multiRPTLabel' style=\"text-align:left;\" colspan='9'><strong><u>Payment Details (Consolidated)</u></strong></td>\n");
    					br.append("</tr>");
    						    				
    					br.append("<tr>");
						br.append("<td class='multiRPTControl'  style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No. & Date ::"+strPONumber+"/"+strPODate+"</td>");
						br.append("<td class='multiRPTControl'  style=\"text-align:left;\" colspan='4'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier ::"+strSuppName+"</td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td class='multiRPTControl'  style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name ::"+strDrugName+"</td>");
						br.append("<td class='multiRPTControl'  style=\"text-align:left;\" colspan='4'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit ::"+strRate + "</td>");
						br.append("</tr>");
						
    					br.append("<tr>");
    					br.append("<td class='multiRPTControl' style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Ordered Qty :: " + totalOrderQty + "</strong></font></td>");
						br.append("<td class='multiRPTControl' style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Ordered Value (Rs.) :: " + myFormatter.format(totalOrderValue) + "</strong></font></td>");
						br.append("<td class='multiRPTControl' style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Qty (A+Q+R) :: " + totalRecQty + "</strong></font></td>");
						br.append("<td class='multiRPTControl' style=\"text-align:left;\" colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Value (A+Q+R) (Rs.) :: " + myFormatter.format(totalRecValue) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
    					br.append("<td class='multiRPTControl' style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Qty (Active) :: " + totalActiveQty + "</strong></font></td>");
						br.append("<td class='multiRPTControl' style=\"text-align:left;\" colspan='7'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Rate/Unit :: " + strRate + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
    					br.append("<td class='multiRPTControl' colspan='9'><hr size=1></td>\n");
    					br.append("</tr>");
    					
						br.append("<tr>");
						br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>1.</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total Basic Amount (Active)" + "</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalActiveValue) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>2.</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(+) VAT/CST" + "</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalTaxValue) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>3.</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(-) LD Charge" + "</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalLDCharge) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(-) Other Penelty" + "</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalOtherCharge) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.1</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Drug Condition)" + "</font></td>");
    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalCondPenCharge) + "</font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.2</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Logogram Not Printed)" + "</font></td>");
    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalLogoPenCharge) + "</font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.3</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Brand Name Printed)" + "</font></td>");
    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalBrandPenCharge) + "</font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.4</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (MRP Printed)" + "</font></td>");
    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalMRPPenCharge) + "</font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>5.</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong><u>Final Payment Value</u>" + "</strong></font></td>");
    					br.append("<td class='multiRPTControl' colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td class='multiRPTControl' colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' color='red'><strong>" + myFormatter.format(totalPaymentValue) + "</strong></font></td>");
						br.append("</tr>");
						
						amtStr = "(" + util.getAmountStr(myFormatter.format(totalPaymentValue)) + ")";
						br.append("<tr>");
						br.append("<td class='multiRPTLabel' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>&nbsp;</font></td>");
    					br.append("<td class='multiRPTControl' colspan='8' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + amtStr + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
    					br.append("<td colspan='9'><hr size=1></td>\n");
    					br.append("</tr>");
    					
    					br.append("</table></td></tr>\n");
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
					br.append("<td class='multiRPTControl' colspan='15'><b><div id='id' align='center'>No Data Found</div></b></td>");
					br.append("</tr>");
				}
			}
			else
			{
				br.append("<tr>");
				br.append("<td class='multiRPTControl' colspan='15'><b><div id='id' align='center'>No Data Found</div></b></td>");
				br.append("</tr>");
			}
		}//try
		catch (Exception e) {	
		    e.printStackTrace();
		    
		    br.append("<tr>");
			br.append("<td class='multiRPTControl' colspan='15'><b><div id='id' align='center'>No Data Found</div></b></td>");
			br.append("</tr>");
			br.append("</table>");
			
			if(ws != null)
			{
				ws.close();
				ws = null;
			}
			
			throw new Exception("OffLineIssueIndentTransHLP.getScreenTwo()->"+e.getMessage());
		}
		
		br.append("</table>");
		return br.toString();	
				
	}
	
	public static String getSupplierPerformabceDetailsPopUp1(SupplierPerformanceDtailRptVO vo) throws Exception 
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
		int count1 = 0;
		int totalActiveQty = 0;
		int totalRecQty = 0;
		int totalOrderQty = 0;
		
		double totalOrderValue = 0.0;
		double totalRecValue = 0.0;
		double totalActiveValue = 0.0;
		
		double totalLDCharge = 0.0;
		double totalOtherCharge = 0.0;
		double totalPaymentValue = 0.0;
		
		double totalTaxValue = 0.0;
		double totalCondPenCharge = 0.0;
		double totalLogoPenCharge = 0.0;
		double totalBrandPenCharge = 0.0;
		double totalMRPPenCharge = 0.0;
		
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
		
		String strDrugName="";
		String strPONumber="";
		String strDDWName="";
		String strRate = "";
		String amtStr = "";
		String strPODate = "";
		
		int ddw_active_qty = 0;
		int ddw_inactive_qty = 0;
		int ddw_quar_qty = 0;
		
		double ddw_supplied_value = 0.0;
		double ddw_penelty = 0.0;
		double ddw_other_penelty = 0.0;
		double ddw_tax = 0.0;
		double ddw_final_value = 0.0;
		
		WebRowSet ws =null;
		hisglobal.utility.HisUtil util = null;
				
		//NumberFormat formatter = new DecimalFormat("############.##"); 
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		String[] strSuppParamVal = null;
		String[] strPayParamVal = null;
		
		try
	    {
			util = new hisglobal.utility.HisUtil("DWH","SupplierPerformanceDtailRptHLP");
			ws  = vo.getStrScreentTwoWs();
			
			br.append("<HTML><HEAD><link href=\"../css/transaction.css\" rel=\"stylesheet\" type=\"text/css\">");
			br.append("<script language='Javascript' src='../../mms/js/dwh_supplierPerformanceDtail_rpt.js'></script><body><form><table align='center' width='1150' border='0' cellspacing='0' cellpadding='0''> ");
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
			br.append("Supplier Performance Detail Report");			
			br.append("</font></b></td><td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
			br.append("For Supplier Name: "+vo.getStrSupplierName()+"<br>");
			br.append("For Drug Name: "+vo.getStrDrugName());
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
		 	
		 	//header
			br.append("<tr><td colspan='14'><hr></td></tr>");
			br.append("<tr bgcolor='#cdc9c9'> ");
			br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan No/ Date<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Date<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='6%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Report No /Date<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Condition<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Rajsthan Govt. Supply Not for Sale Logogram printed<b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='6%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Brand Name not Written<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Price(MRP) not printed/ Visible<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty Received (A/Q/R)<b></font></td>\n");
			//br.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Rate/ Unit</td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value of goods/ drugs received (Only For Active Qty) <b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>LD Charges to be deducted<b></font></td>\n");					
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Other Penalty to be deducted<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='6%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax Value<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Final Payment Value<b></font></td>\n");
			br.append("</tr>");
			br.append("<tr><td colspan='14'><hr></td></tr>");
			
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
					while(ws.next())
					{
						strSuppParamVal = ws.getString(4).split("\\^");
						strPayParamVal = ws.getString(12).split("\\#");
						
						if(count==0)
	    				{
	    					strDrugName = ws.getString(6).trim();
	    					strPONumber = ws.getString(8).trim(); 
	    					strPODate = ws.getString(9);
							strDDWName = ws.getString(5).trim();
														 
							br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='8'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No. & Date ::<font style='font-weight: bold'>"+ws.getString(8)+"/"+ws.getString(9)+"</font></td>");
							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier ::<font style='font-weight: bold'>"+ws.getString(1)+"</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='8'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name ::<font style='font-weight: bold'>"+strDrugName+"</font></td>");
							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit ::<font style='font-weight: bold'>"+strPayParamVal[6]+"/" + strPayParamVal[7] + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr><td colspan='14'><hr></td></tr>");
							
							br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='4' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>DDW Name ::<font style='font-weight: bold'>"+ws.getString(5)+"</font></u></b></td>");
							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Order Qty & Schedule Date ::<font style='font-weight: bold'>"+strPayParamVal[1]+ " " + strPayParamVal[0] + " / "+ws.getString(11)+"</font></u></b></td>");
							br.append("<td style=\"text-align:left;\" colspan='4'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Order Value ::<font style='font-weight: bold'>"+strPayParamVal[8]+"</font></u></b></td>");
							br.append("</tr>");
							
							count++;
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
						
						if(strPONumber.equalsIgnoreCase(ws.getString(8).trim()) && strDrugName.equalsIgnoreCase(ws.getString(6).trim()))
	    				{
							if(count1 == 0)
							{
								strRate = strPayParamVal[6] + "/" + strPayParamVal[7];
								totalOrderQty = Integer.parseInt(strPayParamVal[22]);
								totalOrderValue = Double.parseDouble(strPayParamVal[23]);
								count1++;
							}
							
							totalActiveQty += Integer.parseInt(strPayParamVal[2]);
							totalRecQty += Integer.parseInt(strPayParamVal[5]);
							
							totalActiveValue += Double.parseDouble(strPayParamVal[9]);
							totalRecValue += Double.parseDouble(strPayParamVal[10]);
							
							totalTaxValue += Double.parseDouble(strPayParamVal[20]);
	    					totalLDCharge += Double.parseDouble(strPayParamVal[12]);
							
							totalCondPenCharge += Double.parseDouble(strPayParamVal[14]);
							totalLogoPenCharge += Double.parseDouble(strPayParamVal[15]);
							totalBrandPenCharge += Double.parseDouble(strPayParamVal[16]);
							totalMRPPenCharge += Double.parseDouble(strPayParamVal[17]);
	    					totalOtherCharge += Double.parseDouble(strPayParamVal[18]);
	    						    					
	    					totalPaymentValue += Double.parseDouble(strPayParamVal[21]);
	    					
	    					//ddw name is not same
	    					if(!strDDWName.equalsIgnoreCase(ws.getString(5).trim()))
    						{
	    						//display total ddw wise
								br.append("<tr>\n");
								br.append("<td style=\"text-align:right;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><I>Total</I></b></font></td>\n");
    							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+ddw_active_qty + "/ " + ddw_quar_qty + "/ " + ddw_inactive_qty +"</I></b></font></td>");
    							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_supplied_value)+ "</I></b></font></td>");
    							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_penelty)+"</I></b></font></td>");
    							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_other_penelty)+"</I></b></font></td>");
    							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_tax)+ "</I></b></font></td>");
    							br.append("<td class='multiRPTTotal'  style=\"text-align:right;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_final_value)+"</I></b></font></td>");
    							br.append("</tr>\n");
    							
    							strDDWName = ws.getString(5).trim();
    							//totalOrderQty += Integer.parseInt(strPayParamVal[1]);
								//totalOrderValue += Double.parseDouble(strPayParamVal[8]);
								
    							br.append("<tr>");
    							br.append("<td style=\"text-align:left;\" colspan='4' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>DDW Name ::<font style='font-weight: bold'>"+ws.getString(5)+"</font></u></b></td>");
    							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Order Qty & Schedule Date ::<font style='font-weight: bold'>"+strPayParamVal[1]+ " " + strPayParamVal[0] + " / "+ws.getString(11)+"</font></u></b></td>");
    							br.append("<td style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Order Value ::<font style='font-weight: bold'>"+strPayParamVal[8]+"</font></u></b></td>");
    							br.append("</tr>");
    							
    							//initilize the variable here
    							ddw_active_qty = 0;
    							ddw_inactive_qty = 0;
    							ddw_quar_qty = 0;
    							ddw_supplied_value = 0.0;
    							ddw_penelty = 0.0;
    							ddw_other_penelty = 0.0;
    							ddw_tax = 0.0;
    							ddw_final_value = 0.0;
    						}
	    					
	    				}
	    				else
	    				{
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
							}
	    					
	    					//display total ddw wise
	    					br.append("<tr>\n");
							br.append("<td style=\"text-align:right;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><I>Total</I></b></font></td>\n");
							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+ddw_active_qty + "/ " + ddw_quar_qty + "/ " + ddw_inactive_qty +"</I></b></font></td>");
							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_supplied_value)+ "</I></b></font></td>");
							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_penelty)+"</I></b></font></td>");
							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_other_penelty)+"</I></b></font></td>");
							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_tax)+ "</I></b></font></td>");
							br.append("<td class='multiRPTTotal'  style=\"text-align:right;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_final_value)+"</I></b></font></td>");
							br.append("</tr>\n");
							
	    					//display total here if either po no or item name is not same
	    					br.append("<tr>");
	    					br.append("<td colspan='14'>\n");
	    					
	    					br.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px'>");
	    					br.append("<tr>");
	    					br.append("<td colspan='9'><hr size=1></td>\n");
	    					br.append("</tr>");
	    					
	    					br.append("<tr>");
	    					br.append("<td style=\"text-align:left;\" colspan='9'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><strong><u>Payment Details (Consolidated)</u></strong></font></td>\n");
	    					br.append("</tr>");
	    						    		
	    					br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No. & Date ::"+strPONumber+"/"+strPODate+"</td>");
							br.append("<td style=\"text-align:left;\" colspan='4'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name ::"+strDrugName+"</td>");
							br.append("</tr>");
							
	    					br.append("<tr>");
	    					br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Ordered Qty :: " + totalOrderQty + "</strong></font></td>");
							br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Ordered Value (Rs.) :: " + myFormatter.format(totalOrderValue) + "</strong></font></td>");
							br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Qty (A+Q+R) :: " + totalRecQty + "</strong></font></td>");
							br.append("<td style=\"text-align:left;\" colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Value (A+Q+R) (Rs.) :: " + myFormatter.format(totalRecValue) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
	    					br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Qty (Active) :: " + totalActiveQty + "</strong></font></td>");
							br.append("<td style=\"text-align:left;\" colspan='7'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Rate/Unit :: " + strRate + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
	    					br.append("<td colspan='9'><hr size=1></td>\n");
	    					br.append("</tr>");
	    					
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>1.</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total Basic Amount (Active)" + "</strong></font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalActiveValue) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>2.</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(+) VAT/CST" + "</strong></font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
	    					br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalTaxValue) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>3.</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(-) LD Charge" + "</strong></font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalLDCharge) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(-) Other Penelty" + "</strong></font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalOtherCharge) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.1</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Drug Condition)" + "</font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalCondPenCharge) + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.2</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Logogram Not Printed)" + "</font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalLogoPenCharge) + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.3</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Brand Name Printed)" + "</font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalBrandPenCharge) + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.4</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (MRP Printed)" + "</font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalMRPPenCharge) + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>5.</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong><u>Final Payment Value</u>" + "</strong></font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalPaymentValue) + "</strong></font></td>");
							br.append("</tr>");
							
							amtStr = "(" + util.getAmountStr(myFormatter.format(totalPaymentValue)) + ")";
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>&nbsp;</font></td>");
	    					br.append("<td colspan='8' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + amtStr + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
	    					br.append("<td colspan='9'><hr size=1></td>\n");
	    					br.append("</tr>");
	    					
	    					br.append("</table></td></tr>\n");
	    					
							//po no is not same
							strDrugName = ws.getString(6).trim();
	    					strPONumber = ws.getString(8).trim(); 
							strDDWName = ws.getString(5).trim();
							strPODate = ws.getString(9);
														 
							br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='8'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No. & Date ::<font style='font-weight: bold'>"+ws.getString(8)+"/"+ws.getString(9)+"</font></td>");
							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier ::<font style='font-weight: bold'>"+ws.getString(1)+"</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='8'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name ::<font style='font-weight: bold'>"+strDrugName+"</font></td>");
							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit ::<font style='font-weight: bold'>"+strPayParamVal[6]+"/" + strPayParamVal[7] + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr><td colspan='14'><hr></td></tr>");
							
							br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='4' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>DDW Name ::<font style='font-weight: bold'>"+ws.getString(5)+"</font></u></b></td>");
							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Order Qty & Schedule Date ::<font style='font-weight: bold'>"+strPayParamVal[1]+ " " + strPayParamVal[0] + " / "+ws.getString(11)+"</font></u></b></td>");
							br.append("<td style=\"text-align:left;\" colspan='4'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Order Value ::<font style='font-weight: bold'>"+strPayParamVal[8]+"</font></u></b></td>");
							br.append("</tr>");
							
							strRate = strPayParamVal[6] + "/" + strPayParamVal[7];
							totalOrderQty = Integer.parseInt(strPayParamVal[22]);
							totalOrderValue = Double.parseDouble(strPayParamVal[23]);
							
							totalActiveQty = Integer.parseInt(strPayParamVal[2]);
							totalRecQty = Integer.parseInt(strPayParamVal[5]);
							
							totalActiveValue = Double.parseDouble(strPayParamVal[9]);
							totalRecValue = Double.parseDouble(strPayParamVal[10]);
							
							totalTaxValue = Double.parseDouble(strPayParamVal[20]);
	    					totalLDCharge = Double.parseDouble(strPayParamVal[12]);
							
							totalCondPenCharge = Double.parseDouble(strPayParamVal[14]);
							totalLogoPenCharge = Double.parseDouble(strPayParamVal[15]);
							totalBrandPenCharge = Double.parseDouble(strPayParamVal[16]);
							totalMRPPenCharge = Double.parseDouble(strPayParamVal[17]);
	    					totalOtherCharge = Double.parseDouble(strPayParamVal[18]);
	    						    					
	    					totalPaymentValue = Double.parseDouble(strPayParamVal[21]);
	    					
	    					//initilize the variable here
							ddw_active_qty = 0;
							ddw_inactive_qty = 0;
							ddw_quar_qty = 0;
							ddw_supplied_value = 0.0;
							ddw_penelty = 0.0;
							ddw_other_penelty = 0.0;
							ddw_tax = 0.0;
							ddw_final_value = 0.0;
	    				}
	    				
	    				//row
	    				br.append("<tr>\n");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(2) + "</font></td>\n");//challan no
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(3) + "</font></td>\n");//challan date								
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(7)+"</font></td>\n");//batch no
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[0]+"/ "+strSuppParamVal[1]+"</font></td>\n"); //reportno/date	
						
						if(strSuppParamVal[2].equalsIgnoreCase("No"))
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>"+strSuppParamVal[2]+"</strong></font></td>\n");//drug condition								
						else
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[2]+"</font></td>\n");//drug condition
						
						if(strSuppParamVal[4].equalsIgnoreCase("No"))
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>"+strSuppParamVal[4]+"</strong></font></td>\n");//logogram
						else
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[4]+"</font></td>\n");//logogram
						
						if(strSuppParamVal[3].equalsIgnoreCase("No"))
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>"+strSuppParamVal[3]+"</strong></font></td>\n");//brand name								
						else
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[3]+"</font></td>\n");//brand name
						
						if(strSuppParamVal[5].equalsIgnoreCase("No"))
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>"+strSuppParamVal[5]+"</strong></font></td>\n");//price written								
						else
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[5]+"</font></td>\n");//price written
						
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strPayParamVal[2] + "/ " + strPayParamVal[3] + "/ " + strPayParamVal[4] + "</font></td>\n");//qty received
						//br.append("<td class='multiRPTControl' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strPayParamVal[6]+ "/ " + strPayParamVal[7] + "</font></td>\n"); //rate/unit
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[9]))+"</font></td>"); //total value received
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[12]))+"@ " + strPayParamVal[11] + "%" + "</font></td>\n"); //LD Charges								
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[18]))+"@ " + strPayParamVal[13] + "%" + "</font></td>\n"); //other penelty								
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[20]))+"@ " + strPayParamVal[19] + "%" + "</font></td>"); //tax value
						br.append("<td colspan='1' style=\"text-align:right;\" width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[21]))+"</font></td>\n"); //final payment value
						br.append("</tr>\n");
						
						//add ddw wise
						ddw_active_qty += Integer.parseInt(strPayParamVal[2]);
						ddw_inactive_qty += Integer.parseInt(strPayParamVal[4]);
						ddw_quar_qty += Integer.parseInt(strPayParamVal[3]);
						ddw_supplied_value += Double.parseDouble(strPayParamVal[9]);
						ddw_penelty += Double.parseDouble(strPayParamVal[12]);
						ddw_other_penelty += Double.parseDouble(strPayParamVal[18]);
						ddw_tax += Double.parseDouble(strPayParamVal[20]);
						ddw_final_value += Double.parseDouble(strPayParamVal[21]);

					} //while loop
					
					//last row (payment detail info)
					if(count > 0)
					{
						//display total ddw wise
						br.append("<tr>\n");
						br.append("<td style=\"text-align:right;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><I>Total</I></b></font></td>\n");
						br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+ddw_active_qty + "/ " + ddw_quar_qty + "/ " + ddw_inactive_qty +"</I></b></font></td>");
						br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_supplied_value)+ "</I></b></font></td>");
						br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_penelty)+"</I></b></font></td>");
						br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_other_penelty)+"</I></b></font></td>");
						br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_tax)+ "</I></b></font></td>");
						br.append("<td class='multiRPTTotal'  style=\"text-align:right;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_final_value)+"</I></b></font></td>");
						br.append("</tr>\n");
						
						br.append("<tr>");
    					br.append("<td colspan='15'>\n");
    					
    					br.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px'>");
    					br.append("<tr>");
    					br.append("<td colspan='9'><hr size=1></td>\n");
    					br.append("</tr>");
    					
    					br.append("<tr>");
    					br.append("<td style=\"text-align:left;\" colspan='9'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><strong><u>Payment Details (Consolidated)</u></strong></font></td>\n");
    					br.append("</tr>");
    					
    					br.append("<tr>");
						br.append("<td style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No. & Date ::"+strPONumber+"/"+strPODate+"</td>");
						br.append("<td style=\"text-align:left;\" colspan='4'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name ::"+strDrugName+"</td>");
						br.append("</tr>");
						
    					br.append("<tr>");
    					br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Ordered Qty :: " + totalOrderQty + "</strong></font></td>");
						br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Ordered Value (Rs.) :: " + myFormatter.format(totalOrderValue) + "</strong></font></td>");
						br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Qty (A+Q+R) :: " + totalRecQty + "</strong></font></td>");
						br.append("<td style=\"text-align:left;\" colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Value (A+Q+R) (Rs.) :: " + myFormatter.format(totalRecValue) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
    					br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Qty (Active) :: " + totalActiveQty + "</strong></font></td>");
						br.append("<td style=\"text-align:left;\" colspan='7'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Rate/Unit :: " + strRate + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
    					br.append("<td colspan='9'><hr size=1></td>\n");
    					br.append("</tr>");
    					
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>1.</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total Basic Amount (Active)" + "</strong></font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalActiveValue) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>2.</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(+) VAT/CST" + "</strong></font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
    					br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalTaxValue) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>3.</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(-) LD Charge" + "</strong></font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalLDCharge) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(-) Other Penelty" + "</strong></font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalOtherCharge) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.1</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Drug Condition)" + "</font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalCondPenCharge) + "</font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.2</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Logogram Not Printed)" + "</font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalLogoPenCharge) + "</font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.3</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Brand Name Printed)" + "</font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalBrandPenCharge) + "</font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.4</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (MRP Printed)" + "</font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalMRPPenCharge) + "</font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>5.</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong><u>Final Payment Value</u>" + "</strong></font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalPaymentValue) + "</strong></font></td>");
						br.append("</tr>");
						
						amtStr = "(" + util.getAmountStr(myFormatter.format(totalPaymentValue)) + ")";
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>&nbsp;</font></td>");
    					br.append("<td colspan='8' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + amtStr + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
    					br.append("<td colspan='9'><hr size=1></td>\n");
    					br.append("</tr>");
    					
    					br.append("</table></td></tr>\n");
    					
    					//final summary
    					//header
    					br.append("<tr><td colspan='14'>");
    					br.append("<table width='1150' align='center' cellspacing='1px' cellpadding='1px'>");
    				 	
    				 	//header
    					br.append("<tr><td colspan='9'>&nbsp;</td></tr>");
    					
    					br.append("<tr>");
    					br.append("<td style=\"text-align:left;\" colspan='9'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><strong><u>Final Summary Detail - " + vo.getStrSupplierName() + "</u></strong></font></td>\n");
    					br.append("</tr>");
    					
    					br.append("<tr><td colspan='9'><hr></td></tr>");
    					br.append("<tr bgcolor='#cdc9c9'> ");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No/ Date<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Basic Amount (Active)<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(+) VAT/CST<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) LD Charge<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) Other Penelty (Drug Condition)<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) Other Penelty (Logogram Not Printed)<b></font></td>");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) Other Penelty (Brand Name Printed)<b></font></td>\n");
    					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>(-) Other Penelty (MRP Printed)<b></font></td>\n");
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
    					
    					br.append("<tr><td colspan='9'><hr></td></tr>");
    					
    					//grand total
    					br.append("<tr> ");
						br.append("<td style=\"text-align: left;\" colspan='1' width='20%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Grand Total</b></font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandTotBasicValue) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandTotTaxValue) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='8%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandTotLDCharge) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandTotCondPenCharge) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandTotLogoPenCharge) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandTotBrandPenCharge) + "</font></td>");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandTotMRPPenCharge) + "</font></td>\n");
    					br.append("<td style=\"text-align: left;\" colspan='1' width='12%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + myFormatter.format(grandTotPaymentValue) + "</font></td>\n");
    					br.append("</tr>");
    					br.append("<tr><td colspan='9'><hr></td></tr>");
    					
    					amtStr = "(" + util.getAmountStr(myFormatter.format(grandTotPaymentValue)) + ")";
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
					br.append("<td colspan='15'><b><div id='id' align='center'>No Data Found</div></b></td>");
					br.append("</tr>");
				}
			}
			else
			{
				br.append("<tr>");
				br.append("<td colspan='15'><b><div id='id' align='center'>No Data Found</div></b></td>");
				br.append("</tr>");
			}
		}//try
		catch (Exception e) {	
		    e.printStackTrace();
		    
		    br.append("<tr>");
			br.append("<td colspan='15'><b><div id='id' align='center'>No Data Found</div></b></td>");
			br.append("</tr>");
			br.append("</table>");
			
			if(ws != null)
			{
				ws.close();
				ws = null;
			}
			
			throw new Exception("OffLineIssueIndentTransHLP.getScreenTwo()->"+e.getMessage());
		}
		
		br.append("</table>");
		 	
		return br.toString();	
				
	}
	
	public static String getSupplierPerformabceDetailsPopUp1_without(SupplierPerformanceDtailRptVO vo) throws Exception 
	{
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		StringBuffer br = new StringBuffer();
		
		int count = 0;
		int count1 = 0;
		int totalActiveQty = 0;
		int totalRecQty = 0;
		int totalOrderQty = 0;
		
		double totalOrderValue = 0.0;
		double totalRecValue = 0.0;
		double totalActiveValue = 0.0;
		
		double totalLDCharge = 0.0;
		double totalOtherCharge = 0.0;
		double totalPaymentValue = 0.0;
		
		double totalTaxValue = 0.0;
		double totalCondPenCharge = 0.0;
		double totalLogoPenCharge = 0.0;
		double totalBrandPenCharge = 0.0;
		double totalMRPPenCharge = 0.0;
		
		String strDrugName="";
		String strPONumber="";
		String strDDWName="";
		String strRate = "";
		String amtStr = "";
		
		int ddw_active_qty = 0;
		int ddw_inactive_qty = 0;
		int ddw_quar_qty = 0;
		
		double ddw_supplied_value = 0.0;
		double ddw_penelty = 0.0;
		double ddw_other_penelty = 0.0;
		double ddw_tax = 0.0;
		double ddw_final_value = 0.0;
		
		WebRowSet ws =null;
		hisglobal.utility.HisUtil util = null;
				
		//NumberFormat formatter = new DecimalFormat("############.##"); 
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		
		String[] strSuppParamVal = null;
		String[] strPayParamVal = null;
		
		try
	    {
			util = new hisglobal.utility.HisUtil("DWH","SupplierPerformanceDtailRptHLP");
			ws  = vo.getStrScreentTwoWs();
			
			br.append("<HTML><HEAD><link href=\"../css/transaction.css\" rel=\"stylesheet\" type=\"text/css\">");
			br.append("<script language='Javascript' src='../../mms/js/dwh_supplierPerformanceDtail_rpt.js'></script><body><form><table align='center' width='1150' border='0' cellspacing='0' cellpadding='0''> ");
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
			br.append("Payment Detail Report");			
			br.append("</font></b></td><td width='10%'>&nbsp;</td> ");
			br.append("</tr> ");
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
			br.append("For Supplier Name: "+vo.getStrSupplierName()+"<br>");
			br.append("For Drug Name: "+vo.getStrDrugName());
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
		 	
		 	//header
			/*
			br.append("<tr><td colspan='14'><hr></td></tr>");
			br.append("<tr bgcolor='#cdc9c9'> ");
			br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan No/ Date<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Date<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='6%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Report No /Date<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Condition<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Rajsthan Govt. Supply Not for Sale Logogram printed<b></font></td>");
			br.append("<td style=\"text-align: center;\" colspan='1' width='6%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Brand Name not Written<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Price(MRP) not printed/ Visible<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='9%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty Received (A/Q/R)<b></font></td>\n");
			//br.append("<td CLASS='multiRPTLabel' colspan='1' width='6%'>Rate/ Unit</td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Value of goods/ drugs received (Only For Active Qty) <b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>LD Charges to be deducted<b></font></td>\n");					
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Other Penalty to be deducted<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='6%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax Value<b></font></td>\n");
			br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Final Payment Value<b></font></td>\n");
			br.append("</tr>");
			*/
			br.append("<tr><td colspan='14'><hr></td></tr>");
			
			if (ws != null) 
			{
				if(ws.size() != 0)
				{
					while(ws.next())
					{
						strSuppParamVal = ws.getString(4).split("\\^");
						strPayParamVal = ws.getString(12).split("\\#");
						
						if(count==0)
	    				{
	    					strDrugName = ws.getString(6).trim();
	    					strPONumber = ws.getString(8).trim(); 
							strDDWName = ws.getString(5).trim();
														 
							br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='8'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No. & Date ::<font style='font-weight: bold'><u>"+ws.getString(8)+"/"+ws.getString(9)+"</u></font></td>");
							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier ::<font style='font-weight: bold'><u>"+ws.getString(1)+"</u></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='8'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name ::<font style='font-weight: bold'><u>"+strDrugName+"</u></font></td>");
							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit ::<font style='font-weight: bold'><u>"+strPayParamVal[6]+"/" + strPayParamVal[7] + "</u></font></td>");
							br.append("</tr>");
							
							//br.append("<tr><td colspan='14'><hr></td></tr>");
							
							/*
							br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='4' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>DDW Name ::<font style='font-weight: bold'>"+ws.getString(5)+"</font></u></b></td>");
							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Order Qty & Schedule Date ::<font style='font-weight: bold'>"+strPayParamVal[1]+ " " + strPayParamVal[0] + " / "+ws.getString(11)+"</font></u></b></td>");
							br.append("<td style=\"text-align:left;\" colspan='4'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Order Value ::<font style='font-weight: bold'>"+strPayParamVal[8]+"</font></u></b></td>");
							br.append("</tr>");
							*/
							
							count++;
	    				}
	    				
						if(strPONumber.equalsIgnoreCase(ws.getString(8).trim()) && strDrugName.equalsIgnoreCase(ws.getString(6).trim()))
	    				{
							if(count1 == 0)
							{
								strRate = strPayParamVal[6] + "/" + strPayParamVal[7];
								totalOrderQty = Integer.parseInt(strPayParamVal[22]);
								totalOrderValue = Double.parseDouble(strPayParamVal[23]);
								count1++;
							}
							
							totalActiveQty += Integer.parseInt(strPayParamVal[2]);
							totalRecQty += Integer.parseInt(strPayParamVal[5]);
							
							totalActiveValue += Double.parseDouble(strPayParamVal[9]);
							totalRecValue += Double.parseDouble(strPayParamVal[10]);
							
							totalTaxValue += Double.parseDouble(strPayParamVal[20]);
	    					totalLDCharge += Double.parseDouble(strPayParamVal[12]);
							
							totalCondPenCharge += Double.parseDouble(strPayParamVal[14]);
							totalLogoPenCharge += Double.parseDouble(strPayParamVal[15]);
							totalBrandPenCharge += Double.parseDouble(strPayParamVal[16]);
							totalMRPPenCharge += Double.parseDouble(strPayParamVal[17]);
	    					totalOtherCharge += Double.parseDouble(strPayParamVal[18]);
	    						    					
	    					totalPaymentValue += Double.parseDouble(strPayParamVal[21]);
	    					
	    					//ddw name is not same
	    					if(!strDDWName.equalsIgnoreCase(ws.getString(5).trim()))
    						{
	    						//display total ddw wise
	    						/*
								br.append("<tr>\n");
								br.append("<td style=\"text-align:right;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><I>Total</I></b></font></td>\n");
    							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+ddw_active_qty + "/ " + ddw_quar_qty + "/ " + ddw_inactive_qty +"</I></b></font></td>");
    							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_supplied_value)+ "</I></b></font></td>");
    							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_penelty)+"</I></b></font></td>");
    							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_other_penelty)+"</I></b></font></td>");
    							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_tax)+ "</I></b></font></td>");
    							br.append("<td class='multiRPTTotal'  style=\"text-align:right;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_final_value)+"</I></b></font></td>");
    							br.append("</tr>\n");
    							
    							strDDWName = ws.getString(5).trim();
    							//totalOrderQty += Integer.parseInt(strPayParamVal[1]);
								//totalOrderValue += Double.parseDouble(strPayParamVal[8]);
								
    							br.append("<tr>");
    							br.append("<td style=\"text-align:left;\" colspan='4' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>DDW Name ::<font style='font-weight: bold'>"+ws.getString(5)+"</font></u></b></td>");
    							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Order Qty & Schedule Date ::<font style='font-weight: bold'>"+strPayParamVal[1]+ " " + strPayParamVal[0] + " / "+ws.getString(11)+"</font></u></b></td>");
    							br.append("<td style=\"text-align:left;\" colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Order Value ::<font style='font-weight: bold'>"+strPayParamVal[8]+"</font></u></b></td>");
    							br.append("</tr>");
    							*/
    							
    							//initilize the variable here
    							ddw_active_qty = 0;
    							ddw_inactive_qty = 0;
    							ddw_quar_qty = 0;
    							ddw_supplied_value = 0.0;
    							ddw_penelty = 0.0;
    							ddw_other_penelty = 0.0;
    							ddw_tax = 0.0;
    							ddw_final_value = 0.0;
    						}
	    					
	    				}
	    				else
	    				{
	    					//display total ddw wise
	    					/*
	    					br.append("<tr>\n");
							br.append("<td style=\"text-align:right;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><I>Total</I></b></font></td>\n");
							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+ddw_active_qty + "/ " + ddw_quar_qty + "/ " + ddw_inactive_qty +"</I></b></font></td>");
							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_supplied_value)+ "</I></b></font></td>");
							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_penelty)+"</I></b></font></td>");
							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_other_penelty)+"</I></b></font></td>");
							br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_tax)+ "</I></b></font></td>");
							br.append("<td class='multiRPTTotal'  style=\"text-align:right;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_final_value)+"</I></b></font></td>");
							br.append("</tr>\n");
							*/
	    					
	    					//display total here if either po no or item name is not same
	    					br.append("<tr>");
	    					br.append("<td colspan='14'>\n");
	    					
	    					br.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px'>");
	    					//br.append("<tr>");
	    					//br.append("<td colspan='9'><hr size=1></td>\n");
	    					//br.append("</tr>");
	    					
	    					//br.append("<tr>");
	    					//br.append("<td style=\"text-align:left;\" colspan='9'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><strong><u>Payment Details (Consolidated)</u></strong></font></td>\n");
	    					//br.append("</tr>");
	    						    					
	    					br.append("<tr>");
	    					br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Ordered Qty :: <u>" + totalOrderQty + "</u></strong></font></td>");
							br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Ordered Value (Rs.) :: <u>" + myFormatter.format(totalOrderValue) + "</u></strong></font></td>");
							br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Qty (A+Q+R) :: <u>" + totalRecQty + "</u></strong></font></td>");
							br.append("<td style=\"text-align:left;\" colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Value (A+Q+R) (Rs.) :: <u>" + myFormatter.format(totalRecValue) + "</u></strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
	    					br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Qty (Active) :: <u>" + totalActiveQty + "</u></strong></font></td>");
							br.append("<td style=\"text-align:left;\" colspan='7'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Rate/Unit :: <u>" + strRate + "</u></strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
	    					br.append("<td colspan='9'><hr size=1></td>\n");
	    					br.append("</tr>");
	    					
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>1.</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total Basic Amount (Active)" + "</strong></font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalActiveValue) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>2.</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(+) VAT/CST" + "</strong></font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
	    					br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalTaxValue) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>3.</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(-) LD Charge" + "</strong></font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalLDCharge) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(-) Other Penelty" + "</strong></font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalOtherCharge) + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.1</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Drug Condition)" + "</font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalCondPenCharge) + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.2</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Logogram Not Printed)" + "</font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalLogoPenCharge) + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.3</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Brand Name Printed)" + "</font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalBrandPenCharge) + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.4</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (MRP Printed)" + "</font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalMRPPenCharge) + "</font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>5.</strong></font></td>");
	    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong><u>Final Payment Value</u>" + "</strong></font></td>");
	    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
							br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalPaymentValue) + "</strong></font></td>");
							br.append("</tr>");
							
							amtStr = "(" + util.getAmountStr(myFormatter.format(totalPaymentValue)) + ")";
							br.append("<tr>");
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>&nbsp;</font></td>");
	    					br.append("<td colspan='8' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + amtStr + "</strong></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
	    					br.append("<td colspan='9'><hr size=1></td>\n");
	    					br.append("</tr>");
	    					
	    					br.append("</table></td></tr>\n");
	    					
							//po no is not same
							strDrugName = ws.getString(6).trim();
	    					strPONumber = ws.getString(8).trim(); 
							strDDWName = ws.getString(5).trim();
														 
							br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='8'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No. & Date ::<font style='font-weight: bold'><u>"+ws.getString(8)+"/"+ws.getString(9)+"</u></font></td>");
							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier ::<font style='font-weight: bold'><u>"+ws.getString(1)+"</u></font></td>");
							br.append("</tr>");
							
							br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='8'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name ::<font style='font-weight: bold'><u>"+strDrugName+"</u></font></td>");
							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit ::<font style='font-weight: bold'><u>"+strPayParamVal[6]+"/" + strPayParamVal[7] + "</u></font></td>");
							br.append("</tr>");
							
							//br.append("<tr><td colspan='14'><hr></td></tr>");
							
							/*
							br.append("<tr>");
							br.append("<td style=\"text-align:left;\" colspan='4' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>DDW Name ::<font style='font-weight: bold'>"+ws.getString(5)+"</font></u></b></td>");
							br.append("<td style=\"text-align:left;\" colspan='6'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Order Qty & Schedule Date ::<font style='font-weight: bold'>"+strPayParamVal[1]+ " " + strPayParamVal[0] + " / "+ws.getString(11)+"</font></u></b></td>");
							br.append("<td style=\"text-align:left;\" colspan='4'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>Order Value ::<font style='font-weight: bold'>"+strPayParamVal[8]+"</font></u></b></td>");
							br.append("</tr>");
							*/
							
							strRate = strPayParamVal[6] + "/" + strPayParamVal[7];
							totalOrderQty = Integer.parseInt(strPayParamVal[1]);
							totalOrderValue = Double.parseDouble(strPayParamVal[8]);
							
							totalActiveQty = Integer.parseInt(strPayParamVal[2]);
							totalRecQty = Integer.parseInt(strPayParamVal[5]);
							
							totalActiveValue = Double.parseDouble(strPayParamVal[9]);
							totalRecValue = Double.parseDouble(strPayParamVal[10]);
							
							totalTaxValue = Double.parseDouble(strPayParamVal[20]);
	    					totalLDCharge = Double.parseDouble(strPayParamVal[12]);
							
							totalCondPenCharge = Double.parseDouble(strPayParamVal[14]);
							totalLogoPenCharge = Double.parseDouble(strPayParamVal[15]);
							totalBrandPenCharge = Double.parseDouble(strPayParamVal[16]);
							totalMRPPenCharge = Double.parseDouble(strPayParamVal[17]);
	    					totalOtherCharge = Double.parseDouble(strPayParamVal[18]);
	    						    					
	    					totalPaymentValue = Double.parseDouble(strPayParamVal[21]);
	    					
	    					//initilize the variable here
							ddw_active_qty = 0;
							ddw_inactive_qty = 0;
							ddw_quar_qty = 0;
							ddw_supplied_value = 0.0;
							ddw_penelty = 0.0;
							ddw_other_penelty = 0.0;
							ddw_tax = 0.0;
							ddw_final_value = 0.0;
	    				}
	    				
	    				//row
						/*
	    				br.append("<tr>\n");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(2) + "</font></td>\n");//challan no
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(3) + "</font></td>\n");//challan date								
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(7)+"</font></td>\n");//batch no
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[0]+"/ "+strSuppParamVal[1]+"</font></td>\n"); //reportno/date	
						
						if(strSuppParamVal[2].equalsIgnoreCase("No"))
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>"+strSuppParamVal[2]+"</strong></font></td>\n");//drug condition								
						else
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[2]+"</font></td>\n");//drug condition
						
						if(strSuppParamVal[4].equalsIgnoreCase("No"))
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>"+strSuppParamVal[4]+"</strong></font></td>\n");//logogram
						else
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[4]+"</font></td>\n");//logogram
						
						if(strSuppParamVal[3].equalsIgnoreCase("No"))
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>"+strSuppParamVal[3]+"</strong></font></td>\n");//brand name								
						else
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[3]+"</font></td>\n");//brand name
						
						if(strSuppParamVal[5].equalsIgnoreCase("No"))
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>"+strSuppParamVal[5]+"</strong></font></td>\n");//price written								
						else
							br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strSuppParamVal[5]+"</font></td>\n");//price written
						
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strPayParamVal[2] + "/ " + strPayParamVal[3] + "/ " + strPayParamVal[4] + "</font></td>\n");//qty received
						//br.append("<td class='multiRPTControl' colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+strPayParamVal[6]+ "/ " + strPayParamVal[7] + "</font></td>\n"); //rate/unit
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[9]))+"</font></td>"); //total value received
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[12]))+"@ " + strPayParamVal[11] + "%" + "</font></td>\n"); //LD Charges								
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[18]))+"@ " + strPayParamVal[13] + "%" + "</font></td>\n"); //other penelty								
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[20]))+"@ " + strPayParamVal[19] + "%" + "</font></td>"); //tax value
						br.append("<td colspan='1' style=\"text-align:right;\" width='7%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+myFormatter.format(Double.parseDouble(strPayParamVal[21]))+"</font></td>\n"); //final payment value
						br.append("</tr>\n");
						*/
						
						//add ddw wise
						ddw_active_qty += Integer.parseInt(strPayParamVal[2]);
						ddw_inactive_qty += Integer.parseInt(strPayParamVal[4]);
						ddw_quar_qty += Integer.parseInt(strPayParamVal[3]);
						ddw_supplied_value += Double.parseDouble(strPayParamVal[9]);
						ddw_penelty += Double.parseDouble(strPayParamVal[12]);
						ddw_other_penelty += Double.parseDouble(strPayParamVal[18]);
						ddw_tax += Double.parseDouble(strPayParamVal[20]);
						ddw_final_value += Double.parseDouble(strPayParamVal[21]);
	    				
					} //while loop
					
					//last row (payment detail info)
					if(count > 0)
					{
						//display total ddw wise
						/*
						br.append("<tr>\n");
						br.append("<td style=\"text-align:right;\" colspan='8' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><I>Total</I></b></font></td>\n");
						br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+ddw_active_qty + "/ " + ddw_quar_qty + "/ " + ddw_inactive_qty +"</I></b></font></td>");
						br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_supplied_value)+ "</I></b></font></td>");
						br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_penelty)+"</I></b></font></td>");
						br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_other_penelty)+"</I></b></font></td>");
						br.append("<td class='multiRPTTotal'  style=\"text-align:left;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_tax)+ "</I></b></font></td>");
						br.append("<td class='multiRPTTotal'  style=\"text-align:right;\" colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><b><I>"+myFormatter.format(ddw_final_value)+"</I></b></font></td>");
						br.append("</tr>\n");
						*/
						
						br.append("<tr>");
    					br.append("<td colspan='15'>\n");
    					
    					br.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px'>");
    					//br.append("<tr>");
    					//br.append("<td colspan='9'><hr size=1></td>\n");
    					//br.append("</tr>");
    					
    					//br.append("<tr>");
    					//br.append("<td style=\"text-align:left;\" colspan='9'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><strong><u>Payment Details (Consolidated)</u></strong></font></td>\n");
    					//br.append("</tr>");
    						    					
    					br.append("<tr>");
    					br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Ordered Qty :: <u>" + totalOrderQty + "</u></strong></font></td>");
						br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Ordered Value (Rs.) :: <u>" + myFormatter.format(totalOrderValue) + "</u></strong></font></td>");
						br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Qty (A+Q+R) :: <u>" + totalRecQty + "</u></strong></font></td>");
						br.append("<td style=\"text-align:left;\" colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Value (A+Q+R) (Rs.) :: <u>" + myFormatter.format(totalRecValue) + "</u></strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
    					br.append("<td style=\"text-align:left;\" colspan='2'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Total Received Qty (Active) :: <u>" + totalActiveQty + "</u></strong></font></td>");
						br.append("<td style=\"text-align:left;\" colspan='7'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><strong>Rate/Unit :: <u>" + strRate + "</u></strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
    					br.append("<td colspan='9'><hr size=1></td>\n");
    					br.append("</tr>");
    					
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>1.</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>Total Basic Amount (Active)" + "</strong></font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalActiveValue) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>2.</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(+) VAT/CST" + "</strong></font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
    					br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalTaxValue) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>3.</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(-) LD Charge" + "</strong></font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalLDCharge) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>(-) Other Penelty" + "</strong></font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalOtherCharge) + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.1</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Drug Condition)" + "</font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalCondPenCharge) + "</font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.2</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Logogram Not Printed)" + "</font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalLogoPenCharge) + "</font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.3</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (Brand Name Printed)" + "</font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalBrandPenCharge) + "</font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>4.4</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>Other Penelty (MRP Printed)" + "</font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>" + myFormatter.format(totalMRPPenCharge) + "</font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>5.</strong></font></td>");
    					br.append("<td colspan='4' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong><u>Final Payment Value</u>" + "</strong></font></td>");
    					br.append("<td colspan='1' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>=</strong></font></td>");
						br.append("<td colspan='3' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + myFormatter.format(totalPaymentValue) + "</strong></font></td>");
						br.append("</tr>");
						
						amtStr = "(" + util.getAmountStr(myFormatter.format(totalPaymentValue)) + ")";
						br.append("<tr>");
						br.append("<td colspan='1'><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>&nbsp;</font></td>");
    					br.append("<td colspan='8' style=\"text-align:right;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif'><strong>" + amtStr + "</strong></font></td>");
						br.append("</tr>");
						
						br.append("<tr>");
    					br.append("<td colspan='9'><hr size=1></td>\n");
    					br.append("</tr>");
    					
    					br.append("</table></td></tr>\n");
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
					br.append("<td colspan='15'><b><div id='id' align='center'>No Data Found</div></b></td>");
					br.append("</tr>");
				}
			}
			else
			{
				br.append("<tr>");
				br.append("<td colspan='15'><b><div id='id' align='center'>No Data Found</div></b></td>");
				br.append("</tr>");
			}
		}//try
		catch (Exception e) {	
		    e.printStackTrace();
		    
		    br.append("<tr>");
			br.append("<td colspan='15'><b><div id='id' align='center'>No Data Found</div></b></td>");
			br.append("</tr>");
			br.append("</table>");
			
			if(ws != null)
			{
				ws.close();
				ws = null;
			}
			
			throw new Exception("OffLineIssueIndentTransHLP.getScreenTwo()->"+e.getMessage());
		}
		
		br.append("</table>");
		 	
		return br.toString();	
				
	}
}
