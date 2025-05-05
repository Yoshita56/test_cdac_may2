package mms.reports.controller.hlp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.MmsConfigUtil;
import mms.reports.controller.fb.StoreSaleReturnFB;
import mms.reports.vo.StoreSaleReturnVO;

public class StoreSaleReturnHLP {
	
	public static String getYearWiseIssueTrackDtl(StoreSaleReturnVO voObj) {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = voObj.getWsBreakageDtlRpt();
		WebRowSet ws1 = voObj.getWsyearDtlRpt();
		int i = 1;  
		NumberFormat formatter = new DecimalFormat("############.##");
		double totamt1   = 0.00;
		double totamt2   = 0.00;
		double Quantity1 = 0.00;
		double Quantity2 = 0.00;
		String strItemTotCost1 = "0.00";
		String strItemTotCost2 = "0.00";
		String strItemTotCost3 = "0.00";
		double IssueTotal = 0.00;
		double ReceiveTotal = 0.00;
		double diff = 0.00;
		
		try {
			if (ws != null) {
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ "<tr> " + " <td colspan='1'></td>" + " <td colspan='1'></td>"
						+ " <td colspan='1'><br><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);' /></div></td>");
				sb.append("</tr>");

				sb.append("<tr> " + " <td colspan='1'></td>"
						+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>" + " <td colspan='1'></td>");
				sb.append("</tr></table>");

				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + "<tr> "
						+ " <td colspan='3'></td>"
						+ " <td colspan='3'align='center' style='font-size:15px'><b>Store Wise Sale Return Report</b></td>"
						+ " <td colspan='3'></td>");
				sb.append("</tr>");

				sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Store Name ::<b>"
						+ voObj.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>");

				sb.append(" <tr> <td align='center' colspan='3'></td>" + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Year ::<b>"
						+ voObj.getStrStartDate() + "</b></font></td>"
						+ "<td align='center' colspan='2'>"
						+ "<div id='printid1' class='hidecontrol' style='float:right'>" + "</td></tr>");

				sb.append(
						" <tr> " + " <td colspan='1'></td>" + " <td colspan='1'></td>" + " <td colspan='1'><br></td>");
				sb.append("</tr>");

				sb.append("</table>");
				
				if (ws.size() != 0) {
					sb.append(
							"<table align='center' style='width: 100%;' class='table table-bordered table-hover'>");
					sb.append("<tr style='background-color: #dbdee15e;'>");

					sb.append("<td  align='center' style='width: 18%;'><b>Store Name</b>");
					sb.append("</td>");

					sb.append("<td  align='center' style='width: 6%;'><b>Jan</b>");
					sb.append("</td>");

					sb.append("<td align='center' style='width: 6%;'><b>Feb</b>");
					sb.append("</td>");

					sb.append("<td  align='center' style='width: 6%;'><b>Mar</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Apr</b>");
					sb.append("</td>");

					sb.append("<td  align='center' style='width: 6%;'><b>May</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Jun</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Jul</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Aug</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Sept</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Oct</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Nov</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Dec</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 10%;'><b>Total</b>");
					sb.append("</td>");
					
					sb.append("</tr>");

					while (ws.next()) {

						IssueTotal = Double.parseDouble(ws.getString(14));
						
						sb.append("<td  align='left' style='width: 18%;'>");
						sb.append(ws.getString(1)); 
						sb.append("</td>");
						sb.append("<td  align='right' style='width: 6%;'>");
						sb.append(ws.getString(2));
						sb.append("</td>");
						sb.append("<td  align='right' style='width: 6%;'>");
						sb.append(ws.getString(3));
						sb.append("</td>");
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws.getString(4));
						sb.append("</td>");
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws.getString(5));
						sb.append("</td>");
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws.getString(6));
						sb.append("</td>");
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws.getString(7));
						sb.append("</td>");
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws.getString(8));
						sb.append("</td>");
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws.getString(9));
						sb.append("</td>");
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws.getString(10));
						sb.append("</td>");
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws.getString(11));
						sb.append("</td>");
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws.getString(12));
						sb.append("</td>");
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws.getString(13));
						sb.append("</td>");
						sb.append("<td align='right' style='width: 10%;'>");
						sb.append(ws.getString(14));
						sb.append("</td>");
						sb.append("</tr>");
						i++;
					}

					sb.append("</table>");
					
				} else {
					sb.append(
							"<table class='table table-bordered table-hover' align='center'  bgcolor='white'  border='1px solid black' style='border-collapse:collapse;width: 100%;'>");
					sb.append("<td ><font color='red'>No Record Found</font></td>");
					sb.append("</tr>");
					sb.append("</table>");
				}
				
				if (ws1.size() != 0) {
					sb.append(
							"<table align='center' style='width: 100%;' class='table table-bordered table-hover'>");
					sb.append("<tr style='background-color: #dbdee15e;'>");

					sb.append("<td  align='center' style='width: 18%;'><b>Store Name</b>");
					sb.append("</td>");

					sb.append("<td  align='center' style='width: 6%;'><b>Jan</b>");
					sb.append("</td>");

					sb.append("<td align='center' style='width: 6%;'><b>Feb</b>");
					sb.append("</td>");

					sb.append("<td  align='center' style='width: 6%;'><b>Mar</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Apr</b>");
					sb.append("</td>");

					sb.append("<td  align='center' style='width: 6%;'><b>May</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Jun</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Jul</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Aug</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Sept</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Oct</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Nov</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 6%;'><b>Dec</b>");
					sb.append("</td>");
					
					sb.append("<td  align='center' style='width: 10%;'><b>Total</b>");
					sb.append("</td>");
					
					sb.append("</tr>");

					while (ws1.next()) {
						
						ReceiveTotal = Double.parseDouble(ws1.getString(14));
						
						sb.append("<td  align='left' style='width: 18%;'>");
						sb.append(ws1.getString(1)); 
						sb.append("</td>");

						sb.append("<td  align='right' style='width: 6%;'>");
						sb.append(ws1.getString(2));
						sb.append("</td>");

						sb.append("<td  align='right' style='width: 6%;'>");
						sb.append(ws1.getString(3));
						sb.append("</td>");

						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws1.getString(4));
						sb.append("</td>");
						
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws1.getString(5));
						sb.append("</td>");
						
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws1.getString(6));
						sb.append("</td>");
						
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws1.getString(7));
						sb.append("</td>");
						
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws1.getString(8));
						sb.append("</td>");
						
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws1.getString(9));
						sb.append("</td>");
						
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws1.getString(10));
						sb.append("</td>");
						
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws1.getString(11));
						sb.append("</td>");
						
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws1.getString(12));
						sb.append("</td>");
						
						sb.append("<td align='right' style='width: 6%;'>");
						sb.append(ws1.getString(13));
						sb.append("</td>");
						
						sb.append("<td align='right' style='width: 10%;'>");
						sb.append(ws1.getString(14));
						sb.append("</td>");
						
						sb.append("</tr>");
						i++;
					}

					sb.append("</table>");
					
					
				} else {
					sb.append(
							"<table class='table table-bordered table-hover' style='width: 100%;' align='center'  bgcolor='white'  border='1px solid black' style='border-collapse:collapse;'>");
					sb.append("<td ><font color='red'>No Record Found</font></td>");
					sb.append("</tr>");
					sb.append("</table>");
				}
				
				diff = IssueTotal - ReceiveTotal;
				diff = Math.round(diff * 100.0) / 100.0;
				sb.append("<table class='table table-bordered table-hover' align='center'  bgcolor='white'  border='1px solid black' style='border-collapse:collapse;width: 100%;'>");
				sb.append("<tr style='background-color: #dbdee15e;'>");
				sb.append("<td align='center' style='width: 33%;'><b>");
				sb.append("SALE AMOUNT");
				sb.append("</b></td>");
				sb.append("<td align='center' style='width: 33%;'><b>");
				sb.append("RETURN AMOUNT");
				sb.append("</b></td>");
				sb.append("<td align='center' style='width: 34%;'><b>");
				sb.append("NET. SALE AMOUNT");
				sb.append("</b></td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td align='right' style='width: 33%;'>");
				sb.append(IssueTotal);
				sb.append("</td>");
				sb.append("<td align='right' style='width: 33%;'>");
				sb.append(ReceiveTotal);
				sb.append("</td>");
				sb.append("<td align='right' style='width: 34%;'>");
				sb.append(diff);
				sb.append("</td>");
				sb.append("</tr>");
				sb.append("</table>");
				
				sb.append("<font face='Verdana, Arial, Helvetica, sans-serif' size='1' align='right'>This is System Generated Report. No Signature is Required.</font>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Local Purchase Report", "BreakageItemDtlTransHLP.getBreakageDetails()-->",
					e.getMessage());
		}
		 System.out.println("sb"+sb);
		return sb.toString();
	}
	

	public static String getIssueTrackDetails(StoreSaleReturnVO voObj) {
		StringBuffer sb = new StringBuffer("");

		WebRowSet ws = voObj.getWsBreakageDtlRpt();

		int i = 1; 
		NumberFormat formatter = new DecimalFormat("############.##");
//		double totamt1   = 0.00;
//		double totamt2   = 0.00;
//		double Quantity1 = 0.00;
		double Quantity2 = 0.00;
		
		double totamt11   = 0.00;
		double totamt22 = 0L;
		double Quantity11 = 0L;
		String strItemTotCost1 = "0.00";
		String strItemTotCost2 = "0.00";
		String strItemTotCost3 = "0.00";
		
		try {
			if (ws != null) {
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ "<tr> " + " <td colspan='1'></td>" + " <td colspan='1'></td>"
						+ " <td colspan='1'><br><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne(1);' /></div></td>");
				sb.append("</tr>");

				sb.append("<tr> " + " <td colspan='1'></td>"
						+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>" + " <td colspan='1'></td>");
				sb.append("</tr></table>");

				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + "<tr> "
						+ " <td colspan='3'></td>"
						+ " <td colspan='3'align='center' style='font-size:15px'><b>Store Wise Sale Return Report</b></td>"
						+ " <td colspan='3'></td>");
				sb.append("</tr>");

				sb.append(" <tr><td align='center' colspan='3'></td> " + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "For Store Name ::<b>"
						+ voObj.getStrStoreName() + "</b></font></td><td align='center' colspan='2'></td></tr>");

				sb.append(" <tr> <td align='center' colspan='3'></td>" + "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "From Date ::<b>"
						+ voObj.getStrStartDate() + "</b> To Date ::<b>" + voObj.getStrEndDate() + "</b></font></td>"
						+ "<td align='center' colspan='2'>"
						+ "<div id='printid1' class='hidecontrol' style='float:right'>" + "</td></tr>");

				sb.append(
						" <tr> " + " <td colspan='1'></td>" + " <td colspan='1'></td>" + " <td colspan='1'><br></td>");
				sb.append("</tr>");

				sb.append("</table>");

				if (ws.size() != 0) {
					sb.append(
							"<table align='center' class='table table-bordered table-hover'>");
					sb.append("<tr style='background-color: #dbdee15e;'>");

					sb.append("<td  align='center'><b>SR.No.</b>");
					sb.append("</td>");

					sb.append("<td  align='center'><b>Store Name</b>");
					sb.append("</td>");

					sb.append("<td  align='center'><b>SALE AMT.</b>");
					sb.append("</td>");

					sb.append("<td align='center'><b>SALE RETURN AMOUNT</b>");
					sb.append("</td>");

					sb.append("<td  align='center'><b>NET. SALE AMT.</b>");
					sb.append("</td>");


					sb.append("</tr>");

					while (ws.next()) {
						if (i == 0) {
							
							strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(2)));  
						    Quantity11  = Double.parseDouble(strItemTotCost1);
						    
						    strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(3)));  
						    totamt11  = Double.parseDouble(strItemTotCost2);
						    
						    strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(4)));  
						    totamt22  = Double.parseDouble(strItemTotCost3);
							
						} else {
						    strItemTotCost1 = formatter.format(new BigDecimal(ws.getString(2)));  
						    Quantity11  = Quantity11 + Double.parseDouble(strItemTotCost1);
						    
						    strItemTotCost2 = formatter.format(new BigDecimal(ws.getString(3)));  
						    totamt11  = totamt11 = Double.parseDouble(strItemTotCost2);
						    
						    strItemTotCost3 = formatter.format(new BigDecimal(ws.getString(4)));  
						    totamt22  = totamt22 +  Double.parseDouble(strItemTotCost3);
							
						}
						
						Quantity11 = Math.round(Quantity11 * 100.0) / 100.0;
						totamt11 = Math.round(totamt11 * 100.0) / 100.0;
						totamt22 = Math.round(totamt22 * 100.0) / 100.0;
						
						
						sb.append("<td  align='center' ><b>");
						sb.append(i); 
						sb.append("</b></td>");

						sb.append("<td  align='left' >");
						sb.append(ws.getString(1)); 
						sb.append("</td>");

						sb.append("<td  align='right' >");
						sb.append(ws.getString(2));
						sb.append("</td>");

						sb.append("<td  align='right'>");
						sb.append(ws.getString(3));
						sb.append("</td>");

						sb.append("<td align='right' >");
						sb.append(ws.getString(4));
						sb.append("</td>");

						sb.append("</tr>");
						i++;
					}
					
					sb.append("<tr style='background-color: #dbdee15e;'>");

					sb.append("<td  colspan='2' align='right'><b>Total  </b>");
					sb.append("</td>");

					sb.append("<td  colspan='1' align='right'><b>");
					
					sb.append((int)Quantity11);
					sb.append("</b></td>");

					sb.append("<td  colspan='1' align='right'><b>");
					sb.append((int)totamt11);
					sb.append("</b></td>");

					sb.append("<td  colspan='1' align='right'><b>");
					sb.append((int)totamt22);
					sb.append("</b></td>");

					sb.append("</tr>");

					sb.append("</table>");
					
					sb.append("<font face='Verdana, Arial, Helvetica, sans-serif' size='1' align='right'>This is System Generated Report. No Signature is Required.</font>");
				} else {
					sb.append(
							"<table class='table table-bordered table-hover' align='center'  bgcolor='white'  border='1px solid black' style='border-collapse:collapse;'>");
					sb.append("<td ><font color='red'>No Record Found</font></td>");
					sb.append("</tr>");
					sb.append("</table>");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			new HisException("Local Purchase Report", "BreakageItemDtlTransHLP.getBreakageDetails()-->",
					e.getMessage());
		}
//		 System.out.println("sb"+sb);
		return sb.toString();
	}
	

}
