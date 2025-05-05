/**********************************************************
 Project:	   DWH_CMSS	
 File:         SupplierDeskInterfaceTransHLP.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.hlp;

import hisglobal.hisconfig.HisLanguageProperties;
import hisglobal.utility.HisUtil;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.WriterException;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import mms.transactions.controller.fb.SupplierDeskInterfaceTransFB;

import mms.transactions.vo.SupplierDeskInterfaceTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierDeskInterfaceTransHLP.
 */
public class SupplierDeskInterfaceTransHLP {

	public static String storeLocationList(SupplierDeskInterfaceTransVO vo) 
	{

		WebRowSet wsPrograms = null;
		WebRowSet wsLocations = null;

		StringBuffer br       = new StringBuffer(2000);
		StringBuffer brHeader = new StringBuffer(2000);
		StringBuffer brFinal  = new StringBuffer(2000);
		
		StringBuffer footerTotal = new StringBuffer(2000);

		String strPreviousStoreName = "";
		String strStoreName;

		String[] keyArray = null;

		int itemCount = 0;
		int mainCount = 0;

		int tblWidth = 80;
		int nTblWidth = 80;
		
		int propTblWidth = 10;
		int programmeSize = 0;

		Map<String, String> programTemplate = new HashMap<String, String>();

		double width0 = 0;
		double width1 = 0;
		double width2 = 0; // total
		double width6 = 0; // dynamic column

		// fixed column = 100%
		width0 = 10;
		width1 = 60;
		width2 = 50;
		width6 = 60; // this is dynamic column

		NumberFormat formatter = new DecimalFormat("############");
        String previousTotal ="",previousTotalCal="";
		double previousTotal1 = 0d;
		double previousTotal2 = 0d;
		double previousTotal3 = 0d;
		double previousTotal4 = 0d;	
		double previousTotal5 = 0d;
		double previousTotal6 = 0d;
		double previousTotal7 = 0d;
		double previousTotal8 = 0d;	
	

		/*
		 * 1-Location Name 2-Order Qty^-- 3-Balance Qty 4-Programme Id 
		 * 5-SUM(HSTNUM_ORDER_QTY)
		 * 6-SUM(HSTNUM_STOP_QTY)
		 * 7-SUM(HSTNUM_SUPPLIED_QTY)
		 * 8-SUM(HSTNUM_REJECTED_QTY)
           9-SUM(HSTNUM_SHORTAGE_QTY)
           10-SUM(HSTNUM_REJQTY_AFT_VERIFY)
           11-SUM(HSTNUM_SUPP_RETURN_QTY)
           12-SUM(HSTNUM_REPLACEMENT_ORDER_QTY)
           13-Delivery Location Id
           HEADER
		 * 1-Programme Id 2-Programme Name
		 */

		// ws = vo.getStrHeaderWS(); // Header
		// wsItem = vo.getStrDrugListWS(); // Stock on hand
		wsPrograms = vo.getStrHeaderWS();

		programmeSize = wsPrograms.size();

		keyArray = new String[programmeSize];

		propTblWidth = (int) (tblWidth * width6) / 100;
		nTblWidth += (propTblWidth * programmeSize);

		// calculate table width/column width
		
		width0 = (width0 * tblWidth) / nTblWidth;
		width1 = (width1 * tblWidth) / nTblWidth;
		width2 = (width2 * tblWidth) / nTblWidth;
		width6 = (width6 * tblWidth) / nTblWidth;
		
		if (width0 < 1d)
			width0 = 1d;

		try 
		{
			
			brHeader.append("<tr id='tableHeaderId'>");
			brHeader.append("<th colspan='1' width='" + (width0) + "%'>Sl No.</th>");
			brHeader.append("<th colspan='1' width='" + (width1-3) + "%'>Location</th>");
			
			br.append("<tr>");
			br.append("<td  width='" + width0 + "%'></td>");
			br.append("<td  width='" + (width1-3) + "%'></td>");
			
			int arrayCount = 0;

			while (wsPrograms.next()) 
			{

				brHeader.append("<th colspan='8' style='cursor:pointer;' title='"
								+ wsPrograms.getString(2)
								+ "' width='"
								+ width6
								+ "%'>"
								+ wsPrograms.getString(2)
								+ "</th>");				
				
				
				br.append("<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch I Order Qty.'><b> I</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch II Order Qty.'><b>II</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch III Order Qty.'><b>III</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch IV Order Qty.'><b>IV</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch V Order Qty.'><b>V</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch VI Order Qty.'><b>VI</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch VII Order Qty.'><b>VII</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch VIII Order Qty.'><b>VIII</b></td>");
				
				programTemplate
				.put(
						wsPrograms.getString(1),
						"<td colspan='1'    style=\"text-align:center;color:green\">0</td>"
						+"<td colspan='1'   style=\"text-align:center;color:green\">0</td>" 
						+ "<td colspan='1'  style=\"text-align:center;color:green\">0</td>"
						+ "<td colspan='1'  style=\"text-align:center;color:green\">0</td>"
						+ "<td colspan='1'  style=\"text-align:center;color:green\">0</td>"
						+ "<td colspan='1'  style=\"text-align:center;color:green\">0</td>"
						+ "<td colspan='1'  style=\"text-align:center;color:green\">0</td>"
						+ "<td colspan='1'  style=\"text-align:center;color:green\">0</td>");

				keyArray[arrayCount] = wsPrograms.getString(1);

				arrayCount = arrayCount + 1;

			}
/*			brHeader.append("<th colspan='8' width='" + width2+ "%'>Tot. Qty</th>");
			brHeader.append("</tr>");
			
			
			br.append("<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch I Order Qty.'><b> I</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch II Order Qty.'><b>II</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch III Order Qty.'><b>III</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch IV Order Qty.'><b>IV</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch V Order Qty.'><b>V</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch VI Order Qty.'><b>VI</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch VII Order Qty.'><b>VII</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch VIII Order Qty.'><b>VIII</b></td>");
          
			br.append("</tr>");*/

			footerTotal.append("<tr>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'   colspan='"+((arrayCount*0)+2)+"'><b>Total::::</td>");			
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal1' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal2' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal3' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal4' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal5' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal6' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal7' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal8' style=\"color:blue;\"></div></td>");
			footerTotal.append("</tr>");

			wsLocations = vo.getStrDrugListWS();

			if (wsLocations != null && wsLocations.size() > 0) 
			{

				itemCount = 1;
				mainCount = 1;

				while (wsLocations.next()) 
				{

					strStoreName = wsLocations.getString(1);

					if (!strPreviousStoreName.equals(strStoreName)&& strPreviousStoreName.trim().length() > 0 && mainCount != 1) 
					{

						br.append("<tr>");
						br.append("<td colspan='1' width='" + width0 + "%' style=\"text-align:center;\">" + itemCount	+ "</td>");
						br.append("<td colspan='1' width='" + (width1-3) + "%' style=\"text-align:left;\">"	+ strPreviousStoreName + "</td>");

						br.append(getProgramTemplate(programTemplate,keyArray));
						resetProgramTemplate(programTemplate, width6,"0");

						br.append(""+ previousTotal + "");
						br.append("<input type='hidden' name=\"strRowSum\"  value=\""+previousTotalCal+"\">");
						br.append("</tr>");

						previousTotal = "";
						
						previousTotal1 = 0d;
						previousTotal2 = 0d;
						previousTotal3 = 0d;
						previousTotal4 = 0d;
						previousTotal5 = 0d;
						previousTotal6 = 0d;
						previousTotal7 = 0d;
						previousTotal8 = 0d;

						itemCount = itemCount + 1;

						boolean isSet = setProgramTemplate(programTemplate,	
								                           wsLocations.getString(4), 
								                           wsLocations.getString(2), 
								                           width6, 
								                           String.valueOf(itemCount), 
								                           strStoreName,"0");

						if (isSet)
							
							//System.out.println("wsLocations.getString(2)--->"+wsLocations.getString(2));
							previousTotal1 = previousTotal1 + Double.parseDouble(wsLocations.getString(2).split("\\|")[0].trim());
						    previousTotal2 = previousTotal2 + Double.parseDouble(wsLocations.getString(2).split("\\|")[1].trim());
						    previousTotal3 = previousTotal3 + Double.parseDouble(wsLocations.getString(2).split("\\|")[2].trim());
						    previousTotal4 = previousTotal4 + Double.parseDouble(wsLocations.getString(2).split("\\|")[3].trim());
							previousTotal5 = previousTotal5 + Double.parseDouble(wsLocations.getString(2).split("\\|")[4].trim());
						    previousTotal6 = previousTotal6 + Double.parseDouble(wsLocations.getString(2).split("\\|")[5].trim());
						    previousTotal7 = previousTotal7 + Double.parseDouble(wsLocations.getString(2).split("\\|")[6].trim());
						    previousTotal8 = previousTotal8 + Double.parseDouble(wsLocations.getString(2).split("\\|")[7].trim());
						    //StringUtils.leftPad("129018", 10, "0");
						    //String.format("%10s", "foo").replace(' ', '*');
						    previousTotalCal = String.valueOf(formatter.format(previousTotal1))+" , "+String.valueOf(formatter.format(previousTotal2))+" , "+String.valueOf(formatter.format(previousTotal3))+" , "+String.valueOf(formatter.format(previousTotal4))+" , "+
						    		String.valueOf(formatter.format(previousTotal5))+" , "+String.valueOf(formatter.format(previousTotal6))+" , "+String.valueOf(formatter.format(previousTotal7))+" , "+String.valueOf(formatter.format(previousTotal8));
						    
/*						    previousTotal = "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch I   Order Qty.'>"+String.valueOf(formatter.format(previousTotal1))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch II  Order Qty.'>"+String.valueOf(formatter.format(previousTotal2))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch III Order Qty.'>"+String.valueOf(formatter.format(previousTotal3))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch IV Order Qty.'>"+String.valueOf(formatter.format(previousTotal4))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch V Order Qty.'>"+String.valueOf(formatter.format(previousTotal5))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch VI Order Qty.'>"+String.valueOf(formatter.format(previousTotal6))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch VII Order Qty.'>"+String.valueOf(formatter.format(previousTotal7))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch VIII  Order Qty.'>"+String.valueOf(formatter.format(previousTotal8))+"</td>";
						    System.out.println("previousTotal -----111---->"+previousTotal );*/
						

					} 
					else 
					{

						boolean isSet = setProgramTemplate(programTemplate,
								        wsLocations.getString(4), wsLocations
										.getString(2), width6, String
										.valueOf(itemCount), 
										 strStoreName,"0");

                        if (isSet)
							
                        	
                       // 	System.out.println("wsLocations.getString(2)--->"+wsLocations.getString(2));
							previousTotal1 = previousTotal1 + Double.parseDouble(wsLocations.getString(2).split("\\|")[0].trim());
							previousTotal2 = previousTotal2 + Double.parseDouble(wsLocations.getString(2).split("\\|")[1].trim());
							previousTotal3 = previousTotal3 + Double.parseDouble(wsLocations.getString(2).split("\\|")[2].trim());
							previousTotal4 = previousTotal4 + Double.parseDouble(wsLocations.getString(2).split("\\|")[3].trim());
							previousTotal5 = previousTotal5 + Double.parseDouble(wsLocations.getString(2).split("\\|")[4].trim());
							previousTotal6 = previousTotal6 + Double.parseDouble(wsLocations.getString(2).split("\\|")[5].trim());
							previousTotal7 = previousTotal7 + Double.parseDouble(wsLocations.getString(2).split("\\|")[6].trim());
							previousTotal8 = previousTotal8 + Double.parseDouble(wsLocations.getString(2).split("\\|")[7].trim());
							previousTotalCal = String.valueOf(formatter.format(previousTotal1))+" , "+String.valueOf(formatter.format(previousTotal2))+" , "+String.valueOf(formatter.format(previousTotal3))+" , "+String.valueOf(formatter.format(previousTotal4))+" , "+
					    					String.valueOf(formatter.format(previousTotal5))+" , "+String.valueOf(formatter.format(previousTotal6))+" , "+String.valueOf(formatter.format(previousTotal7))+" , "+String.valueOf(formatter.format(previousTotal8));
					    
/*						    previousTotal = "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch I   Order Qty.'>"+String.valueOf(formatter.format(previousTotal1))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch II  Order Qty.'>"+String.valueOf(formatter.format(previousTotal2))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch III Order Qty.'>"+String.valueOf(formatter.format(previousTotal3))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch IV Order Qty.'>"+String.valueOf(formatter.format(previousTotal4))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch V Order Qty.'>"+String.valueOf(formatter.format(previousTotal5))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch VI Order Qty.'>"+String.valueOf(formatter.format(previousTotal6))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch VII Order Qty.'>"+String.valueOf(formatter.format(previousTotal7))+"</td>" +
           	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch VIII  Order Qty.'>"+String.valueOf(formatter.format(previousTotal8))+"</td>";
						    System.out.println("previousTotal ----22222----->"+previousTotal );*/

						   
					}										
										
					strPreviousStoreName = wsLocations.getString(1);
					mainCount = mainCount + 1;
					
					   

				}
							
				
				br.append("<tr>");
				br.append("<td colspan='1' width='" + width0+ "%' style=\"text-align:center;\">"+ itemCount + "</td>");
				br.append("<td colspan='1' width='" + (width1-3)+ "%' style=\"text-align:left;\">"+ strPreviousStoreName + "</td>");
				br.append(getProgramTemplate(programTemplate, keyArray));
				resetProgramTemplate(programTemplate, width6,"0");
				br.append(" "+ previousTotal + "");
				br.append("<input type='hidden' name=\"strRowSum\"  value=\""+previousTotalCal+"\">");
				br.append("</tr>");

				previousTotal = "";
				
				previousTotal1 = 0d;
				previousTotal2 = 0d;
				previousTotal3 = 0d;
				previousTotal4 = 0d;
				previousTotal5 = 0d;
				previousTotal6 = 0d;
				previousTotal7 = 0d;
				previousTotal8 = 0d;
				
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		tblWidth = nTblWidth;
		brFinal.append("<div id='wrapper' style='width:100%;'><table id='mainTableRptId' width='100%' align='center' cellspacing='0px' cellpadding='1px'>");
		brFinal.append(brHeader);
		brFinal.append(br);
		brFinal.append(footerTotal);		
		brFinal.append("</table></div><input type='hidden' name='mstTableWidthVal' value='"+(tblWidth+5)+"'>");
		

		// System.out.println("tblWidth :: "+tblWidth);

		// br.append(brPagination);
		return brFinal.toString();

	}
	
	
	public static String viewStoreLocationList(SupplierDeskInterfaceTransVO vo) 
	{

		WebRowSet wsPrograms = null;
		WebRowSet wsLocations = null;

		StringBuffer br       = new StringBuffer(2000);
		StringBuffer brHeader = new StringBuffer(2000);
		StringBuffer brFinal  = new StringBuffer(2000);
		
		StringBuffer footerTotal = new StringBuffer(2000);

		String strPreviousStoreName = "",strPreviousStoreId="";
		String strStoreName,strStoreId;

		String[] keyArray = null;

		int itemCount = 0;
		int mainCount = 0;

		int tblWidth = 80;
		int nTblWidth = 80;
		
		int propTblWidth = 10;
		int programmeSize = 0;

		Map<String, String> programTemplate = new HashMap<String, String>();

		double width0 = 0;
		double width1 = 0;
		double width2 = 0; // total
		double width6 = 0; // dynamic column

		// fixed column = 100%
		width0 = 10;
		width1 = 60;
		width2 = 50;
		width6 = 80; // this is dynamic column

		NumberFormat formatter = new DecimalFormat("############");
        String previousTotal ="", previousTotalCal ="",popUpValue="";
		double previousTotal1 = 0d;
		double previousTotal2 = 0d;
		double previousTotal3 = 0d;
		double previousTotal4 = 0d;	
		double previousTotal5 = 0d;
		double previousTotal6 = 0d;
		double previousTotal7 = 0d;
		double previousTotal8 = 0d;	
		
		int    orderQty 				= 0;
		int    stopQty 					= 0;
		int    suppliedQty 				= 0;
		int    rejectedQty 				= 0;	
		int    shortageQty 				= 0;
		int    rejectedQtyAfterVerify 	= 0;
		int    supplierReturnQty 		= 0;
		int    replacementOrderQty 		= 0;

		/*
		 * 1-Location Name 2-Order Qty^-- 3-Balance Qty 4-Programme Id 
		 * 5-SUM(HSTNUM_ORDER_QTY)
		 * 6-SUM(HSTNUM_STOP_QTY)
		 * 7-SUM(HSTNUM_SUPPLIED_QTY)
		 * 8-SUM(HSTNUM_REJECTED_QTY)
           9-SUM(HSTNUM_SHORTAGE_QTY)
           10-SUM(HSTNUM_REJQTY_AFT_VERIFY)
           11-SUM(HSTNUM_SUPP_RETURN_QTY)
           12-SUM(HSTNUM_REPLACEMENT_ORDER_QTY)
           13-Delivery Location Id
           HEADER
		 * 1-Programme Id 2-Programme Name
		 */



		// ws = vo.getStrHeaderWS(); // Header
		// wsItem = vo.getStrDrugListWS(); // Stock on hand
		/*wsPrograms = vo.getStrHeaderWS();

		programmeSize = wsPrograms.size();

		keyArray = new String[programmeSize];

		propTblWidth = (int) (tblWidth * width6) / 100;
		nTblWidth += (propTblWidth * programmeSize);

		// calculate table width/column width
		
		width0 = (width0 * tblWidth) / nTblWidth;
		width1 = (width1 * tblWidth) / nTblWidth;
		width2 = (width2 * tblWidth) / nTblWidth;
		width6 = (width6 * tblWidth) / nTblWidth;
		
		if (width0 < 1d)
			width0 = 1d;*/

		try 
		{
			
			/*brHeader.append("<tr id='tableHeaderId'>");
			brHeader.append("<th colspan='1' width='" + width0 + "%'>#</th>");
			brHeader.append("<th colspan='1' width='" + (width1-3) + "%'>Location</th>");
			
			br.append("<tr>");
			br.append("<td  width='" + width0 + "%'></td>");
			br.append("<td  width='" + (width1-3) + "%'></td>");
			
			int arrayCount = 0;

			while (wsPrograms.next()) 
			{

				brHeader.append("<th colspan='4' style='cursor:pointer;' title='"+ wsPrograms.getString(2)
								+ "' width='"+ width6+ "%'>"+ wsPrograms.getString(2)+ "</th>");
				
				programTemplate
				.put(
						wsPrograms.getString(1),
						"<td colspan='1'    style=\"text-align:right;color:green\" title='Sch I   Order   , Balance Qty.'>0 , 0</td>"
						+"<td colspan='1'   style=\"text-align:right;color:green\" title='Sch II  Order   , Balance Qty.'>0 , 0</td>" 
						+"<td colspan='1'   style=\"text-align:right;color:green\" title='Sch III Order   , Balance Qty.'>0 , 0</td>"
						+"<td colspan='1'   style=\"text-align:right;color:green\" title='Sch IV Order   , Balance Qty.'>0 , 0</td>"
						+"<td colspan='1'   style=\"text-align:right;color:green\" title='Sch V Order   , Balance Qty.'>0 , 0</td>"
						+"<td colspan='1'   style=\"text-align:right;color:green\" title='Sch VI Order   , Balance Qty.'>0 , 0</td>"
						+"<td colspan='1'   style=\"text-align:right;color:green\" title='Sch VII Order   , Balance Qty.'>0 , 0</td>"
						+"<td colspan='1'   style=\"text-align:right;color:green\" title='Sch VIII  Order   , Balance Qty.'>0 , 0</td>");

				
				br.append("<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch I Order   , Balance Qty.'><b> I</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch II Order  , Balance Qty.'><b>II</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch III Order , Balance Qty.'><b>III</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch IV Order  , Balance Qty.'><b>IV</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch V Order   , Balance Qty.'><b> V</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch VI Order  , Balance Qty.'><b>VI</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch VII Order , Balance Qty.'><b>VII</b></td>" +
		 		          "<td width='" + (width6/8) + "%' style='text-align:center;cursor:pointer;' title='Sch VIII Order  , Balance Qty.'><b>VIII</b></td>");

				
				keyArray[arrayCount] = wsPrograms.getString(1);

				arrayCount = arrayCount + 1;

			}
			brHeader.append("<th colspan='1' width='" + width2+ "%'>Tot. Qty</th>");
			brHeader.append("</tr>");	
			
			br.append("<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch I Order , Balance Qty.'><b> I</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch II Order , Balance Qty.'><b>II</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch III Order , Balance Qty.'><b>III</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch IV Order , Balance Qty.'><b>IV</b></td>"+
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch V Order , Balance Qty.'><b> V</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch VI Order , Balance Qty.'><b>VI</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch VII Order , Balance Qty.'><b>VII</b></td>" +
	 		          "<td width='" + (width2/8) + "%' style='text-align:center;cursor:pointer;' title='Sch VIII Order , Balance Qty.'><b>VIII</b></td>");
        
			br.append("</tr>");


			footerTotal.append("<tr>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'   colspan='"+((arrayCount*8)+2)+"'><b>Total::::</td>");			
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal1' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal2' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal3' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal4' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal5' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal6' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal7' style=\"color:blue;\"></div></td>");
			footerTotal.append("<td style='border:2px solid #bbb;text-align:right;'  colspan='1'><div id='grandTotal8' style=\"color:blue;\"></div></td>");
			footerTotal.append("</tr>");			*/
			

			wsLocations = vo.getStrDrugListWS();

			if (wsLocations != null && wsLocations.size() > 0) 
			{

				itemCount = 1;
				mainCount = 1;

				while (wsLocations.next()) 
				{

					strStoreName = wsLocations.getString(1);
					strStoreId   = wsLocations.getString(13);

					if (!strPreviousStoreName.equals(strStoreName)&& strPreviousStoreName.trim().length() > 0 && mainCount != 1) 
					{                       
						br.append("<tr>");
					    br.append("<td colspan='1' width='" + width0 + "%' style=\"text-align:center;\"><input type='radio' name='strItemCount'  onClick=\"showDeliveryDtls(this,'" + itemCount + "');\" id='strItemCount"+itemCount+"' value='"+itemCount+"'></td>");
					    br.append("<td colspan='1' width='" + (width1-3) + "%' style=\"text-align:left;\"><a STYLE='CURSOR:POINTER;color:blue' title='Get [ "+strPreviousStoreName+" ] Balance Quantity Detail(s)' onClick=\"showOffLineBalQtyDtls(this,'" + itemCount + "',0,2);\"><div id='storeNameDiv"+itemCount+"'>" + strPreviousStoreName + "</div></a></td>");

						br.append(getProgramTemplate(programTemplate,keyArray));
						resetProgramTemplate(programTemplate, width6,"1");

						br.append(""+ previousTotal + "");
						br.append("<input type='hidden' name=\"strRowSum\"  value=\""+previousTotalCal+"\">");
						br.append("<input type='hidden' name=\"popUpValue\" id=popUpValue"+itemCount+" value=\""+popUpValue+"\">");
						br.append("<input type='hidden' name=\"strDelLocationId\" id=strDelLocationId"+itemCount+" value=\""+strPreviousStoreId+"\">");
						br.append("</tr>");

						previousTotal = "";
						popUpValue ="";
						
						previousTotal1 = 0d;
						previousTotal2 = 0d;
						previousTotal3 = 0d;
						previousTotal4 = 0d;
						
						
						
						orderQty 				= 0;
						stopQty 				= 0;
						suppliedQty 			= 0;
						rejectedQty 			= 0;	
						shortageQty 			= 0;
						rejectedQtyAfterVerify 	= 0;
						supplierReturnQty 		= 0;
						replacementOrderQty 	= 0;


						itemCount = itemCount + 1;
						/*
						 * 1-Location Name 
						 * 2-Order Qty^-- 
						 * 3-Balance Qty 
						 * 4-Programme Id 
						 * 5-SUM(HSTNUM_ORDER_QTY)
						 * 6-SUM(HSTNUM_STOP_QTY)
						 * 7-SUM(HSTNUM_SUPPLIED_QTY)
						 * 8-SUM(HSTNUM_REJECTED_QTY)
				           9-SUM(HSTNUM_SHORTAGE_QTY)
				           10-SUM(HSTNUM_REJQTY_AFT_VERIFY)
				           11-SUM(HSTNUM_SUPP_RETURN_QTY)
				           12-SUM(HSTNUM_REPLACEMENT_ORDER_QTY)
				           13-Delivery Location Id
				           HEADER
						 * 1-Programme Id 2-Programme Name
						 */


						boolean isSet = setProgramTemplate(programTemplate,	
								                           wsLocations.getString(4), 
								                           wsLocations.getString(2)+"^"+wsLocations.getString(3), 
								                           width6, 
								                           String.valueOf(itemCount), 
								                           strStoreName,vo.getStrViewMode());

						if (isSet)
							
							previousTotal1 = previousTotal1 + Double.parseDouble(wsLocations.getString(2).split("\\|")[0].trim());
						    previousTotal2 = previousTotal2 + Double.parseDouble(wsLocations.getString(2).split("\\|")[1].trim());
						    previousTotal3 = previousTotal3 + Double.parseDouble(wsLocations.getString(2).split("\\|")[2].trim());
						    previousTotal4 = previousTotal4 + Double.parseDouble(wsLocations.getString(2).split("\\|")[3].trim());
						    previousTotal5 = previousTotal5 + Double.parseDouble(wsLocations.getString(2).split("\\|")[4].trim());
						    previousTotal6 = previousTotal6 + Double.parseDouble(wsLocations.getString(2).split("\\|")[5].trim());
						    previousTotal7 = previousTotal7 + Double.parseDouble(wsLocations.getString(2).split("\\|")[6].trim());
						    previousTotal8 = previousTotal8 + Double.parseDouble(wsLocations.getString(2).split("\\|")[7].trim());
						    
						    orderQty 				= orderQty 				 +Integer.parseInt(wsLocations.getString(5));
							stopQty 				= stopQty  				 +Integer.parseInt(wsLocations.getString(6));
							suppliedQty 			= suppliedQty 			 +Integer.parseInt(wsLocations.getString(7));
							rejectedQty 			= rejectedQty 			 +Integer.parseInt(wsLocations.getString(8));	
							shortageQty 			= shortageQty 			 +Integer.parseInt(wsLocations.getString(9));
							rejectedQtyAfterVerify 	= rejectedQtyAfterVerify +Integer.parseInt(wsLocations.getString(10));
							supplierReturnQty 		= supplierReturnQty 	 +Integer.parseInt(wsLocations.getString(11));
							replacementOrderQty 	= replacementOrderQty 	 +Integer.parseInt(wsLocations.getString(12));
						    //StringUtils.leftPad("129018", 10, "0");
						    //String.format("%9s", "foo").replace(' ', '*');
							popUpValue       = String.valueOf(orderQty)+"^"+String.valueOf(stopQty)+"^"+String.valueOf(suppliedQty)+"^"+String.valueOf(rejectedQty)+"^"+String.valueOf(shortageQty)+"^"+String.valueOf(rejectedQtyAfterVerify)+"^"+String.valueOf(supplierReturnQty)+"^"+String.valueOf(replacementOrderQty);
							previousTotalCal = String.valueOf(formatter.format(previousTotal1))+" , "+String.valueOf(formatter.format(previousTotal2))+" , "+String.valueOf(formatter.format(previousTotal3))+" , "+String.valueOf(formatter.format(previousTotal4))+" , "+
			    					String.valueOf(formatter.format(previousTotal5))+" , "+String.valueOf(formatter.format(previousTotal6))+" , "+String.valueOf(formatter.format(previousTotal7))+" , "+String.valueOf(formatter.format(previousTotal8));
			    
						    previousTotal = "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch I   Order Qty.'>"+String.valueOf(formatter.format(previousTotal1))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch II  Order Qty.'>"+String.valueOf(formatter.format(previousTotal2))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch III Order Qty.'>"+String.valueOf(formatter.format(previousTotal3))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch IV Order Qty.'>"+String.valueOf(formatter.format(previousTotal4))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch V Order Qty.'>"+String.valueOf(formatter.format(previousTotal5))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch VI Order Qty.'>"+String.valueOf(formatter.format(previousTotal6))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch VII Order Qty.'>"+String.valueOf(formatter.format(previousTotal7))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch VIII  Order Qty.'>"+String.valueOf(formatter.format(previousTotal8))+"</td>";
						


					} 
					else 
					{

						boolean isSet = setProgramTemplate(programTemplate,
								                           wsLocations.getString(4), 
								                           wsLocations.getString(2)+"^"+wsLocations.getString(3), 
								                           width6, String.valueOf(itemCount), 
								                           strStoreName,vo.getStrViewMode());

                        if (isSet)
							
							previousTotal1 = previousTotal1 + Double.parseDouble(wsLocations.getString(2).split("\\|")[0].trim());
						    previousTotal2 = previousTotal2 + Double.parseDouble(wsLocations.getString(2).split("\\|")[1].trim());
						    previousTotal3 = previousTotal3 + Double.parseDouble(wsLocations.getString(2).split("\\|")[2].trim());
						    previousTotal4 = previousTotal4 + Double.parseDouble(wsLocations.getString(2).split("\\|")[3].trim());
						    previousTotal5 = previousTotal5 + Double.parseDouble(wsLocations.getString(2).split("\\|")[4].trim());
						    previousTotal6 = previousTotal6 + Double.parseDouble(wsLocations.getString(2).split("\\|")[5].trim());
						    previousTotal7 = previousTotal7 + Double.parseDouble(wsLocations.getString(2).split("\\|")[6].trim());
						    previousTotal8 = previousTotal8 + Double.parseDouble(wsLocations.getString(2).split("\\|")[7].trim());
						    
						    orderQty 				= orderQty 				 +Integer.parseInt(wsLocations.getString(5));
							stopQty 				= stopQty  				 +Integer.parseInt(wsLocations.getString(6));
							suppliedQty 			= suppliedQty 			 +Integer.parseInt(wsLocations.getString(7));
							rejectedQty 			= rejectedQty 			 +Integer.parseInt(wsLocations.getString(8));	
							shortageQty 			= shortageQty 			 +Integer.parseInt(wsLocations.getString(9));
							rejectedQtyAfterVerify 	= rejectedQtyAfterVerify +Integer.parseInt(wsLocations.getString(10));
							supplierReturnQty 		= supplierReturnQty 	 +Integer.parseInt(wsLocations.getString(11));
							replacementOrderQty 	= replacementOrderQty 	 +Integer.parseInt(wsLocations.getString(12));
						    
							popUpValue       = String.valueOf(orderQty)+"^"+String.valueOf(stopQty)+"^"+String.valueOf(suppliedQty)+"^"+String.valueOf(rejectedQty)+"^"+String.valueOf(shortageQty)+"^"+String.valueOf(rejectedQtyAfterVerify)+"^"+String.valueOf(supplierReturnQty)+"^"+String.valueOf(replacementOrderQty);			
							previousTotalCal = String.valueOf(formatter.format(previousTotal1))+" , "+String.valueOf(formatter.format(previousTotal2))+" , "+String.valueOf(formatter.format(previousTotal3))+" , "+String.valueOf(formatter.format(previousTotal4))+" , "+
			    					String.valueOf(formatter.format(previousTotal5))+" , "+String.valueOf(formatter.format(previousTotal6))+" , "+String.valueOf(formatter.format(previousTotal7))+" , "+String.valueOf(formatter.format(previousTotal8));
			    
						    previousTotal = "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch I   Order Qty.'>"+String.valueOf(formatter.format(previousTotal1))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch II  Order Qty.'>"+String.valueOf(formatter.format(previousTotal2))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch III Order Qty.'>"+String.valueOf(formatter.format(previousTotal3))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch IV Order Qty.'>"+String.valueOf(formatter.format(previousTotal4))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch V Order Qty.'>"+String.valueOf(formatter.format(previousTotal5))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch VI Order Qty.'>"+String.valueOf(formatter.format(previousTotal6))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch VII Order Qty.'>"+String.valueOf(formatter.format(previousTotal7))+"</td>" +
		   	 		        "<td colspan='1' style='text-align:right;cursor:pointer;' title='Sch VIII  Order Qty.'>"+String.valueOf(formatter.format(previousTotal8))+"</td>";
						
					}										
										
					strPreviousStoreName = wsLocations.getString(1);
					strPreviousStoreId   = wsLocations.getString(13);
					mainCount = mainCount + 1;
					
					   

				}
							
				
				br.append("<tr>");
				br.append("<td colspan='1' width='" + width0 + "%' style=\"text-align:center;\"><input type='radio' name='strItemCount'  onClick=\"showDeliveryDtls(this,'" + itemCount + "');\" id='strItemCount"+itemCount+"' value='"+itemCount+"'></td>");
				br.append("<td colspan='1' width='" + (width1-3) + "%' style=\"text-align:left;\"><a STYLE='CURSOR:POINTER;color:blue' title='Get [ "+strPreviousStoreName+" ] Balance Quantity Detail(s)' onClick=\"showOffLineBalQtyDtls(this,'" + itemCount + "',0,2);\"><div id='storeNameDiv"+itemCount+"'>" + strPreviousStoreName + "</div></a></td>");
				                                                                                                                                                                                  

				br.append(getProgramTemplate(programTemplate, keyArray));
				resetProgramTemplate(programTemplate, width6,"1");
				br.append(""+ previousTotal + "");
				br.append("<input type='hidden' name=\"popUpValue\" id=popUpValue"+itemCount+" value=\""+popUpValue+"\">");
				br.append("<input type='hidden' name=\"strRowSum\"  value=\""+previousTotalCal+"\">");
				br.append("<input type='hidden' name=\"strDelLocationId\" id=strDelLocationId"+itemCount+" value=\""+strPreviousStoreId+"\">");
				br.append("</tr>");

				previousTotal = "";
				popUpValue ="";
				
				previousTotal1 = 0d;
				previousTotal2 = 0d;
				previousTotal3 = 0d;
				previousTotal4 = 0d;
				
				orderQty 				= 0;
				stopQty 				= 0;
				suppliedQty 			= 0;
				rejectedQty 			= 0;	
				shortageQty 			= 0;
				rejectedQtyAfterVerify 	= 0;
				supplierReturnQty 		= 0;
				replacementOrderQty 	= 0;
				
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		tblWidth = nTblWidth;
		brFinal.append("<div id='wrapper' style='width:100%;'><table id='mainTableRptId' width='100%' align='center' cellspacing='0px' cellpadding='1px'>");
		brFinal.append(brHeader);
		brFinal.append(br);
		brFinal.append(footerTotal);		
		brFinal.append("</table></div><input type='hidden' name='mstTableWidthVal' value='"+(tblWidth+5)+"'>");
		

		// System.out.println("tblWidth :: "+tblWidth);

		// br.append(brPagination);
		return brFinal.toString();

	}
	
	private static boolean setProgramTemplate(
			Map<String, String> programTemplate, String key, String qty,
			double width, String itemCount, String itemName,String mode) 
	{

		boolean isSet = programTemplate.containsKey(key);

		if (isSet)
			for (Map.Entry<String, String> entry : programTemplate.entrySet()) 
			{
				if (entry.getKey().equals(key)) 
				{
                  if(mode.equals("0"))	
                  {
                	
                     programTemplate.put(key, "<td colspan='1' width='" + width/8	+ "%' style='text-align:center;cursor:pointer;' title='Sch I     Order Qty.'>"+qty.split("\\|")[0].trim()+"</td>" +
            	 		       "<td colspan='1' width='" + width/8	+ "%' style='text-align:center;cursor:pointer;' title='Sch II    Order Qty.'>"+qty.split("\\|")[1].trim()+"</td>" +
            	 		       "<td colspan='1' width='" + width/8	+ "%' style='text-align:center;cursor:pointer;' title='Sch III   Order Qty.'>"+qty.split("\\|")[2].trim()+"</td>" +
            	 		       "<td colspan='1' width='" + width/8	+ "%' style='text-align:center;cursor:pointer;' title='Sch IV    Order Qty.'>"+qty.split("\\|")[3].trim()+"</td>" +
            	 		       "<td colspan='1' width='" + width/8	+ "%' style='text-align:center;cursor:pointer;' title='Sch V     Order Qty.'>"+qty.split("\\|")[4].trim()+"</td>" +
            	 		       "<td colspan='1' width='" + width/8	+ "%' style='text-align:center;cursor:pointer;' title='Sch VI    Order Qty.'>"+qty.split("\\|")[5].trim()+"</td>" +
            	 		       "<td colspan='1' width='" + width/8	+ "%' style='text-align:center;cursor:pointer;' title='Sch VII   Order Qty.'>"+qty.split("\\|")[6].trim()+"</td>" +
            	 		       "<td colspan='1' width='" + width/8	+ "%' style='text-align:center;cursor:pointer;' title='Sch VIII  Order Qty.'>"+qty.split("\\|")[7].trim()+"</td>");
                               	 		                          
                  }
                  else
                  {	  
                	
                     programTemplate.put(key, "<td colspan='1' width='" + width/4	+ "%' style='text-align:center;cursor:pointer;' title='Sch I   Order , Balance Qty.'>"+(qty.split("\\^")[0]).split("\\|")[0].trim()+" , "+(qty.split("\\^")[1]).split("\\|")[0].trim()+"</td>"+
                    		                  "<td colspan='1' width='" + width/4	+ "%' style='text-align:center;cursor:pointer;' title='Sch II  Order , Balance Qty.'>"+(qty.split("\\^")[0]).split("\\|")[1].trim()+" , "+(qty.split("\\^")[1]).split("\\|")[1].trim()+"</td>"+
                    		                  "<td colspan='1' width='" + width/4	+ "%' style='text-align:center;cursor:pointer;' title='Sch III Order , Balance Qty.'>"+(qty.split("\\^")[0]).split("\\|")[2].trim()+" , "+(qty.split("\\^")[1]).split("\\|")[2].trim()+"</td>"+
                    		                  "<td colspan='1' width='" + width/4	+ "%' style='text-align:center;cursor:pointer;' title='Sch II  Order , Balance Qty.'>"+(qty.split("\\^")[0]).split("\\|")[3].trim()+" , "+(qty.split("\\^")[1]).split("\\|")[3].trim()+"</td>"+
                    		                  "<td colspan='1' width='" + width/4	+ "%' style='text-align:center;cursor:pointer;' title='Sch III Order , Balance Qty.'>"+(qty.split("\\^")[0]).split("\\|")[4].trim()+" , "+(qty.split("\\^")[1]).split("\\|")[4].trim()+"</td>"+
                    		                  "<td colspan='1' width='" + width/4	+ "%' style='text-align:center;cursor:pointer;' title='Sch II  Order , Balance Qty.'>"+(qty.split("\\^")[0]).split("\\|")[5].trim()+" , "+(qty.split("\\^")[1]).split("\\|")[5].trim()+"</td>"+
                    		                  "<td colspan='1' width='" + width/4	+ "%' style='text-align:center;cursor:pointer;' title='Sch III Order , Balance Qty.'>"+(qty.split("\\^")[0]).split("\\|")[6].trim()+" , "+(qty.split("\\^")[1]).split("\\|")[6].trim()+"</td>"+
                    		                  "<td colspan='1' width='" + width/4	+ "%' style='text-align:center;cursor:pointer;' title='Sch IV  Order , Balance Qty.'>"+(qty.split("\\^")[0]).split("\\|")[7].trim()+" , "+(qty.split("\\^")[1]).split("\\|")[7].trim()+"</td>");
                		  
                  }
					return isSet;
				}

			}
		programTemplate = null;

		return isSet;

	}


	private static String getProgramTemplate(
			Map<String, String> programTemplate, String[] keyArray) {

		StringBuffer sb = new StringBuffer("");

		for (String keys : keyArray) {

			sb.append(programTemplate.get(keys));
		}

		return sb.toString();
	}

	private static void resetProgramTemplate(
			final Map<String, String> programTemplate, double width,String mode) {

		Map<String, String> newprogramTemplate = new HashMap<String, String>();

		for (Map.Entry<String, String> entry : programTemplate.entrySet()) 
		{

			if(mode.equals("0"))
			{	
			newprogramTemplate.put(entry.getKey(), "<td colspan='1'  style=\"text-align:center;color:green\">0</td>"
					+"<td colspan='1' style=\"text-align:center;color:green\">0</td>" 
					+ "<td colspan='1'  style=\"text-align:center;color:green\">0</td>"
					+ "<td colspan='1'  style=\"text-align:center;color:green\">0</td>"
					+ "<td colspan='1'  style=\"text-align:center;color:green\">0</td>"
					+ "<td colspan='1'  style=\"text-align:center;color:green\">0</td>"
					+ "<td colspan='1'  style=\"text-align:center;color:green\">0</td>"
					+ "<td colspan='1'  style=\"text-align:center;color:green\">0</td>");
			}
			else
			{
				newprogramTemplate.put(entry.getKey(), "<td colspan='1'  style=\"text-align:right;color:green\" title='Sch I   Order , Balance Qty.'>0 , 0</td>"
						+ "<td colspan='1'  style=\"text-align:right;color:green\" title='Sch II   Order , Balance Qty.'>0 , 0</td>" 
						+ "<td colspan='1'  style=\"text-align:right;color:green\" title='Sch III  Order , Balance Qty.'>0 , 0</td>"
						+ "<td colspan='1'  style=\"text-align:right;color:green\" title='Sch IV  Order , Balance Qty.'>0 , 0</td>"
						+ "<td colspan='1'  style=\"text-align:right;color:green\" title='Sch V  Order , Balance Qty.'>0 , 0</td>"
						+ "<td colspan='1'  style=\"text-align:right;color:green\" title='Sch VI  Order , Balance Qty.'>0 , 0</td>"
						+ "<td colspan='1'  style=\"text-align:right;color:green\" title='Sch VII  Order , Balance Qty.'>0 , 0</td>"
						+ "<td colspan='1'  style=\"text-align:right;color:green\" title='Sch VIII   Order , Balance Qty.'>0 , 0</td>");
			}

		}

		programTemplate.clear();

		programTemplate.putAll(newprogramTemplate);

		newprogramTemplate = null;

	}
		
		public static String getPreviousDeliveryDtls(SupplierDeskInterfaceTransVO vo,HttpServletRequest request,String mode)
		{		
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws	=	null;		
		int count = 0;
		String strCssClass =	"multiRPTControl";
		try
		{
			
			ws = vo.getWsItemList();
			if(mode.equals("0"))	
			{
				sb.append("<div id='wrapper1'  width='100%' ><table id='mainTableRptId1' align='center'cellpadding='1px' cellspacing='0px' bgcolor='#CC9966'>");
				sb.append("<tr id='tableHeaderId1'>");				
						
				sb.append(" <th  colspan='1' width='5%' >"+HisLanguageProperties.getValue(request, "label.common.Tranche_no")+"</th> ");				
				sb.append(" <th  colspan='1' width='20%'>"+HisLanguageProperties.getValue(request, "label.common.Consignee_store_name")+"</th>");
				sb.append(" <th  colspan='1' width='10%'>"+HisLanguageProperties.getValue(request, "label.common.Delivery_No")+"</th>");
				sb.append(" <th  colspan='1' width='10%'>"+HisLanguageProperties.getValue(request, "label.common.Supplier_Receipt_No1")+"</th>");
				sb.append(" <th  colspan='1' width='10%'>"+HisLanguageProperties.getValue(request, "label.common.Supplier_Receipt_Date")+"</th>");		
				sb.append(" <th  colspan='1' width='15%'>"+HisLanguageProperties.getValue(request, "label.common.Transporter_name")+"</th>");
				sb.append(" <th  colspan='1' width='10%'>"+HisLanguageProperties.getValue(request, "label.common.Lr_no.")+"</th>");
				sb.append(" <th  colspan='1' width='10%'>"+HisLanguageProperties.getValue(request, "label.common.Status")+"</th>");
				sb.append(" <th  colspan='1' width='10% '>"+HisLanguageProperties.getValue(request, "label.common.Action")+"</th>");
				sb.append(" </tr> ");
				if(ws!=null && ws.size()>0)
				{
					/*
					 * 
						1 SCH_NO
						2 CONSIGNEE
						3 Delivery No
						4 Supplier Receipt No
						5 Supplier Receipt Date
						6 Transporter Name
						7 Lawry No
						8 Status
						9 Action 
						10 Store Id
						11 Primary Key [ PO_NO||'^'||SCHEDULE_NO||'^'|| STORE_ID||'^'|| DELIVERY_NO ||'^'||HSTNUM_PO_STORE_ID]
					
					 */
					 // PKG_MMS_VIEW2.proc_supplier_interface_dtl [MOde =6]
					while(ws.next())
					{
							
						strCssClass =	"multiRPTControl";					
							
						
						String strCheckHidValue = ws.getString(11);	
						
						
	
						sb.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
						sb.append("<input type='hidden' name='strConsignee'     id='strConsignee"+count+"'     value='"+ws.getString(2)+"'>");
						
						sb.append("<tr id =trId"+count+">");
						sb.append("<td style=\"text-align: center;\" 	class= "+strCssClass+ " colspan='1' width='5%'>"+ws.getString(1)+"</td>");
						sb.append("<td style=\"text-align: left;\"  	class= "+strCssClass+ " colspan='1' width='20%'>"+ws.getString(2)+"</td>");
						sb.append("<td style=\"text-align: center;\" 	class= "+strCssClass+ " colspan='1' width='10%'>"+ws.getString(3)+"</td>");
						sb.append("<td style=\"text-align: left;\" 		class= "+strCssClass+ " colspan='1' width='10%'>"+ws.getString(4)+"</td>");
						sb.append("<td style=\"text-align: center;\" 	class= "+strCssClass+ " colspan='1' width='10%'>"+ws.getString(5)+"</td>");
						sb.append("<td style=\"text-align: left;\" 		class= "+strCssClass+ " colspan='1' width='15%'>"+ws.getString(6)+"</td>");
						sb.append("<td style=\"text-align: center;\" 	class= "+strCssClass+ " colspan='1' width='10%'>"+ws.getString(7)+"</td>");
						sb.append("<td style=\"text-align: center;\" 	class= "+strCssClass+ " colspan='1' width='10%'>"+ws.getString(8)+"</td>");
						sb.append("<td style=\"text-align: center;\" 	class= "+strCssClass+ " colspan='1' width='10%'>");
						if(ws.getString(9).equals("1"))
						{	
							
								sb.append("<img title='Delete Record' onclick='return deleteRecord(1,\""+count+"\");' style='cursor:pointer;' src='../../hisglobal/images/delete_icon.png'>");
						   
							
						}
						else
						{	
								
								sb.append("<img title='Delete of Record Not Allowed' onclick='return deleteRecord(2,\""+count+"\");' style='cursor:pointer;' src='../../hisglobal/images/delete_DisableIcon.png'>");
								
							
							
						}	
						sb.append("<img title='View Record' onclick='return openPopUp(\""+count+"\");' style='cursor:pointer;' src='../../hisglobal/images/view_icon1.png'>");
					//	sb.append("<img title='View & Print Barcode' style='cursor: pointer; width: 25px; height: 22px; vertical-align: bottom;'  onclick='return PrintBarCode(\""+count+"\");' style='cursor:pointer;' src='../../hisglobal/images/barcode.png'>");
						sb.append("</td>");
						sb.append("</tr>");
						
						count++;
					}			
				}
				else
				{
					sb.append("<tr>");
					sb.append("<td class='multiRPTControl' colspan='9'><font color='red'><b>No Detail(s) Found</b></font></td></tr>");
					sb.append("</tr>");
				}
					
				sb.append("</table></div>");
			}
			else
			{
				sb.append("<div id='wrapper1'  width='100%' ><table id='mainTableRptId1' align='center'cellpadding='1px' cellspacing='0px' bgcolor='#CC9966'>");
				sb.append("<tr id='tableHeaderId1'>");				
						
				sb.append(" <th  colspan='1' width='5%' >"+HisLanguageProperties.getValue(request, "label.common.Tranche_no")+"</th> ");					
				sb.append(" <th  colspan='1' width='15%'>"+HisLanguageProperties.getValue(request, "label.common.Delivery_No")+"</th>");
				sb.append(" <th  colspan='1' width='15%'>"+HisLanguageProperties.getValue(request, "label.common.Supplier_Receipt_No1")+"</th>");
				sb.append(" <th  colspan='1' width='15%'>"+HisLanguageProperties.getValue(request, "label.common.Supplier_Receipt_Date")+"</th>");		
				sb.append(" <th  colspan='1' width='15%'>"+HisLanguageProperties.getValue(request, "label.common.Transporter_name")+"</th>");
				sb.append(" <th  colspan='1' width='15%'>"+HisLanguageProperties.getValue(request, "label.common.Lr_no.")+"</th>");
				sb.append(" <th  colspan='1' width='15%'>"+HisLanguageProperties.getValue(request, "label.common.Status")+"</th>");
				sb.append(" <th  colspan='1' width='5% '>"+HisLanguageProperties.getValue(request, "label.common.Action")+"</th>");
				sb.append(" </tr> ");
				if(ws!=null && ws.size()>0)
				{
					/*
					 * 
						1 SCH_NO
						2 CONSIGNEE
						3 Delivery No
						4 Supplier Receipt No
						5 Supplier Receipt Date
						6 Transporter Name
						7 Lawry No
						8 Status
						9 Action 
						10 Store Id
						11 Primary Key [ PO_NO||'^'||SCHEDULE_NO||'^'|| STORE_ID||'^'|| DELIVERY_NO ]
					
					 */
					while(ws.next())
					{
							
						strCssClass =	"multiRPTControl";					
							
						
						String strCheckHidValue = ws.getString(11);	
						
						
	
						sb.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
						sb.append("<input type='hidden' name='strConsignee'     id='strConsignee"+count+"'     value='"+ws.getString(2)+"'>");
						
						sb.append("<tr id =trId"+count+">");
						sb.append("<td style=\"text-align: center;\" 	class= "+strCssClass+ " colspan='1' width='5%'>"+ws.getString(1)+"</td>");						
						sb.append("<td style=\"text-align: center;\" 	class= "+strCssClass+ " colspan='1' width='15%'>"+ws.getString(3)+"</td>");
						sb.append("<td style=\"text-align: left;\" 		class= "+strCssClass+ " colspan='1' width='15%'>"+ws.getString(4)+"</td>");
						sb.append("<td style=\"text-align: center;\" 	class= "+strCssClass+ " colspan='1' width='15%'>"+ws.getString(5)+"</td>");
						sb.append("<td style=\"text-align: left;\" 		class= "+strCssClass+ " colspan='1' width='15%'>"+ws.getString(6)+"</td>");
						sb.append("<td style=\"text-align: center;\" 	class= "+strCssClass+ " colspan='1' width='15%'>"+ws.getString(7)+"</td>");
						sb.append("<td style=\"text-align: center;\" 	class= "+strCssClass+ " colspan='1' width='15%'>"+ws.getString(8)+"</td>");
						sb.append("<td style=\"text-align: center;\" 	class= "+strCssClass+ " colspan='1' width='5%'>");
						if(ws.getString(9).equals("1"))
						{	
							
						    	sb.append("<img title='View Record' onclick='return openPopUp(\""+count+"\");' style='cursor:pointer;' src='../../hisglobal/images/view_icon1.png'>");
						    
							
						}
						else
						{	
							
								sb.append("<img title='View Record' onclick='return openPopUp(\""+count+"\");' style='cursor:pointer;' src='../../hisglobal/images/view_icon1.png'>");
							
							
						}	
						sb.append("</td>");
						sb.append("</tr>");
						
						count++;
					}			
				}
				else
				{
					sb.append("<tr>");
					sb.append("<td class='multiRPTControl' colspan='9'><font color='red'><b>No Detail(s) Found</b></font></td></tr>");
					sb.append("</tr>");
				}
					
				sb.append("</table></div>");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
			
			return sb.toString();
		}
		/**
		 * To get Details HLP on view page.
		 * 
		 * @param ws the WebRowSet
		 * @param request 
		 * @return the item details table
		 * @throws Exception 
		 */
		public static String getPopUpDtll(SupplierDeskInterfaceTransVO vo, HttpServletRequest request,String strHiddenValue) throws Exception 
		{

			StringBuffer sbTable = new StringBuffer(100);
			StringBuffer sbHeader = new StringBuffer(100);
			StringBuffer sbBody = new StringBuffer(100);
			String strProgrammeName="",strDrugName="", strPoNo ="";
			HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
			
			int count=0;
			int nColspan = 7;
			 int i=0;
			 int size = 180;
			 String str ="";
			 String printDate = null;
			 
				
			WebRowSet ws = vo.getWsItemList();
			
		
			
			 while(ws.next())
			 {

					/*
					 * 1 Drug Name  
					 * 2 Batch No 
					 * 3 Programme Name 
					 * 4 Mfg Date
					 * 5 Exp Date
					 * 6 Supply Qty
					 * 7. pono  14
					 * */
					 
				 if(i==0)
				 {
					 strDrugName = ws.getString(1);
					 strPoNo = ws.getString(14);
					 
					 str = "Store Name :: "+strHiddenValue+":: Total Batch is "+ws.size()+":: Programme Name :: "+ws.getString(3)+" Batch No-> "+ws.getString(2)+"- Mfg Date->"+ws.getString(4).replace("/", "-")+"- Exp Date->"+ws.getString(5).replace("/", "-")+" - Qty->"+ws.getString(6);
				 }
				 else
				 {
					 str += "Store Name :: "+strHiddenValue+" Batch No->"+ws.getString(2)+"- Mfg Date->"+ws.getString(4).replace("/", "-")+"- Exp Date->"+ws.getString(5).replace("/", "-")+" - Qty->"+ws.getString(6);
				 }
				 i++;
                   					 
			 }								
			ws.beforeFirst();
			
			
	
			System.out.println("QR String--->>"+str);
			
			sbTable.append("<table width='100%' align=\"center\" border=\"0\" cellspacing =\"0px\" >" + "<tr>");
			try {
				printDate = util.getDSDate("DD-Mon-YYYY HH24: MI");
				sbTable.append("<tr> ");
				//sbTable.append("<td width='25%' align='left'>"+HisLanguageProperties.getValue(request,"label.common.Print_date_and_time" )+":<br> ");
				sbTable.append("<td width='25%' align='left'> ");
				sbTable.append(printDate);
				
				sbTable.append("<td width='25%' align='right'>");
				sbTable.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'><div id='printImg'>");
				sbTable.append("<img style='cursor: pointer; ' title='Print Page'  ");
				sbTable.append(" src='../../hisglobal/images/printer_symbol.gif' "
							+ " onClick='printScrollabeVoucher(\"issueDtlsDivId\",\"mainTableId\",\"mainTableRptId2\",\"voucherDivId\");' ></img> "
							+ " <img style='cursor: pointer;' src='../../hisglobal/images/save_on.gif' onclick='generateVoucherPdf();' style='cursor: pointer;' title='Download Payment Detail(s)' ></img> </div></div></div>");
				sbTable.append(" </td> ");
				sbTable.append("</tr>");
				
				
				
				
				//sbTable.append("<td colspan='1' width='50%' align='left'><img src='data:image/gif;base64,"+QRCodeGenerate.getQRCodeImage(str, size, size)+"' width='"+size+"' height='"+size+"' alt='embedded folder icon'>");
			} catch (WriterException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			sbTable.append("<td colspan='1' width='50%' align='left'><font face='Arial, Helvetica, sans-serif' size='3'><strong>Supplier Delivery Report</strong></font></td>");
			
			sbTable.append("</table>");
			sbTable.append("<table width='100%' align=\"center\" border=\"0\" cellspacing =\"0px\" >" + "<tr>");
			sbTable.append("<tr>" + "<td class=\"TITLE\" colspan=\"4\" >"+HisLanguageProperties.getValue(request, "label.common.Drug_Details")+" For  [ "+strHiddenValue+" ] Po No: "+strPoNo+"</td>" + "</tr>");
			
			
			sbHeader.append("<table bgcolor='#cdc9c9'  width='100%' align=\"center\" border=\"0\" cellspacing =\"0px\" >" + "<tr>");
		    sbHeader.append("</tr>");
			sbHeader.append("<td width='28%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.Drug_Name")+"</td>");	
			sbHeader.append("<td width='12%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.Batch_No.")+"</td>");
			sbHeader.append("<td width='10%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.Mfg_date")+"</td>");
			sbHeader.append("<td width='10%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.Expiry_Date")+"</td>");
			sbHeader.append("<td width='12%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.Supply_Qty")+"</td>");
			sbHeader.append("<td width='14%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.Cartan_No.")+"</td>");
		//	sbHeader.append("<td width='14%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.Carton_Size")+"</td>");
		///	sbHeader.append("<td width='14%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.Breakage/lost_qty")+"</td>");
		//	sbHeader.append("<td width='14%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.Total_accepted_qty")+"</td>");
		//	sbHeader.append("<td width='14%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.Rejected_qty")+"</td>");
		//	sbHeader.append("<td width='14%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.Excess_qty")+"</td>");
			//sbHeader.append("<td width='14%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.Po_no.")+"</td>");
			//sbHeader.append("<td width='14%' colspan='1' class='multiRPTLabel'>"+HisLanguageProperties.getValue(request, "label.common.verify_date")+"</td>");
		
			sbHeader.append("</tr>");
	        try
	        {
				if (ws != null && ws.size() > 0) 
				{
					/*
					 * 1 Item Name  
					 * 2 Batch No 
					 * 3 Programme Name 
					 * 4 Mfg Date
					 * 5 Exp Date
					 * 6 Supply Qty
					 * 7.MMS_MST.get_carton_size_name(' || hosp_code || ',HSTNUM_CARTON_SIZE_ID,HSTNUM_ITEMBRAND_ID)
					 * 8.HSTNUM_BOX_ID
					 */
	
					while (ws.next()) 
					{
						
						if (count == 0) 
						{
							strProgrammeName = ws.getString(3).trim();
							sbBody.append("<tr>");			
							sbBody.append("<td  style='text-align:left;border: 1px solid lightyellow;' colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' color='blue'><b>"+HisLanguageProperties.getValue(request,"label.common.Programme_Name" )+"::<u>"
									).append( ws.getString(3) ).append( "</u></b></font></td>");					
							sbBody.append("</tr>");
						}
						
						if (strProgrammeName.equals(ws.getString(3).trim())) 
						{
							sbBody.append("<tr>");
							sbBody.append("<td class=\"multiPOControl\" style=\"text-align: left;\">"    + ws.getString(1) + "</td>");
							sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(2) + "</td>");
							sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(4) + "</td>");
							sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(5) + "</td>");
							sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(6) + "</td>");	
							sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(8) + "</td>");	
						//	sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(7) + "</td>");	
						//	sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(9) + "</td>");
						//	sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(10) + "</td>");
						//	sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(11) + "</td>");
							//sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(12) + "</td>");
						//	sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(14) + "</td>");
						//	sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(13) + "</td>");
							sbBody.append("</tr>");
						}
						else 
						{
							strProgrammeName = ws.getString(3).trim();
							sbBody.append("<tr>");			
							sbBody.append("<td  style='text-align:left;border: 1px solid lightyellow;' colspan='5'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' color='blue'><b>"+HisLanguageProperties.getValue(request,"label.common.Programme_Name" )+"::<u>"
									).append( ws.getString(3) ).append( "</u></b></font></td>");					
							sbBody.append("</tr>");
	
							sbBody.append("<tr>");
							sbBody.append("<td class=\"multiPOControl\" style=\"text-align: left;\">"    + ws.getString(1) + "</td>");
							sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(2) + "</td>");
							sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(4) + "</td>");
							sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(5) + "</td>");
							sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(6) + "</td>");	
							sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(8) + "</td>");	
							//sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(7) + "</td>");
						//	sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(9) + "</td>");			
						//	sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(10) + "</td>");	
						//	sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(11) + "</td>");
						//	sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(12) + "</td>");
						//	sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(14) + "</td>");
						//	sbBody.append("<td class=\"multiPOControl\" style=\"text-align: center;\">"  + ws.getString(13) + "</td>");
							sbBody.append("</tr>");
						}
						count++;
							
					}
	
					sbBody.append("</table>");
	
				} else {
					sbBody.append("<tr>");
					sbBody.append("<td colspan=\"" + nColspan + "\" class=\"multiPOControl\" style=\"text-align: center; color: red;\">"+HisLanguageProperties.getValue(request, "label.common.No_Data_Found")+"!</td>");
					sbBody.append("</tr></table>");
				}
	        }
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }

			return sbTable.toString() + sbHeader.toString() + sbBody.toString();
		}

	
		/**
		 * Gets the schedule item list.
		 * 
		 * @param formBean
		 *            the form bean
		 * @param vo
		 *            the vo
		 * @return the schedule item list
		 * @throws Exception
		 *             the exception
		 */
		
		
		
		
		
		public static String getPopUpDtl(SupplierDeskInterfaceTransVO vo, HttpServletRequest request,String strHiddenValue) throws Exception 
		{

			StringBuffer sb = new StringBuffer("");
			StringBuffer tableHead = new StringBuffer("");
			
			int j = 1;	
			int i = 0;
			
			String strProgrammeName="",strDrugName="", strPoNo ="",str= "",str1= "";
			 int size = 180;
			 int nColspan = 7;
						
			HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
			WebRowSet ws = null;
			String strTableWidth = "800";
			String printDate = null;
			try {
				printDate = util.getDSDate("DD-Mon-YYYY HH24: MI");
				
				 ws = vo.getWsItemList();
				 
				 

				 while(ws.next())
				 {

						/*
						 * 1 Drug Name  
						 * 2 Batch No 
						 * 3 Programme Name 
						 * 4 Mfg Date
						 * 5 Exp Date
						 * 6 Supply Qty
						 * 7. pono  14
						 * */
						 
					 if(i==0)
					 {
						 strDrugName = ws.getString(1);
						 strPoNo = ws.getString(14);
						 strProgrammeName = ws.getString(3);
						 
						 str = "Store Name :: "+strHiddenValue+":: Total Batch is "+ws.size()+":: Programme Name :: "+ws.getString(3)+" Batch No-> "+ws.getString(2)+"- Mfg Date->"+ws.getString(4).replace("/", "-")+"- Exp Date->"+ws.getString(5).replace("/", "-")+" - Qty->"+ws.getString(6);
					 }
					 else
					 {
						 str += "Store Name :: "+strHiddenValue+" Batch No->"+ws.getString(2)+"- Mfg Date->"+ws.getString(4).replace("/", "-")+"- Exp Date->"+ws.getString(5).replace("/", "-")+" - Qty->"+ws.getString(6);
					 }
					 i++;
	                   					 
				 }								
				ws.beforeFirst();
				
			str1 = vo.getStrQrStoreId()+"^"+vo.getStrQrItemId()+"^"+vo.getStrQrSupplierId()+"^"+vo.getStrQrPono()+"^"+vo.getStrSchno()+"^"+vo.getStrDelno();
				
				sb.append("<table align='center' width='").append(strTableWidth).append("'cellspacing='0' cellpadding='0' height='40'> ");
				sb.append("<tr> ");
				
				sb.append(printDate);
				
					sb.append("<td width='25%' align='right'>");
					sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'><div id='printImg'>");
					sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
					
					/*sb.append(" src='../../hisglobal/images/printer_symbol.gif' "
							+ " onClick='printScrollabeVoucher(\"issueDtlsDivId\",\"mainTableId\",\"mainTableRptId2\",\"voucherDivId\");' ></img> "
							+ " <img style='cursor: pointer;' src='../../hisglobal/images/save_on.gif' onclick='generateVoucherPdf();' style='cursor: pointer;' title='Download Supplier Delivery Detail(s)' ></img> </div></div></div>");*/
					
					sb.append(" src='../../hisglobal/images/printer_symbol.gif' "
							+ " onClick='printScrollabeVoucher(\"issueDtlsDivId\",\"mainTableId\",\"mainTableRptId2\",\"voucherDivId\");' ></img>  </div></div></div>");
					
					
					sb.append(" </td> ");
					sb.append("</tr></table>");
					sb.append("<table align='center' width='").append(strTableWidth).append("'cellspacing='0' cellpadding='0' height='40'> ");

					 sb.append("<tr>");
						
						sb.append("<td width='80%' colspan='5' align='center'> <div  align='center'> <b><font face='Arial,Verdana, Helvetica, sans-serif' size='5'> Central Medical Services Society</td> ");
						
						sb.append("</tr>");
		
			
					
				sb.append("</tr></tbody></table>");			
				
				if (ws != null) 				{
					
				/*	try {
					//sb.append("<td colspan='1' width='50%' align='left'><img src='data:image/gif;base64,"+QRCodeGenerate.getQRCodeImage(str1, size, size)+"' width='"+size+"' height='"+size+"' alt='embedded folder icon'>");
					
				} catch (WriterException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}*/
					
					
					
				sb.append("<table align='center' cellspacing='1px' cellpadding='1px' border='0' WIDTH='").append(strTableWidth)
				.append("'><TR> <td align='center' ><b>"+HisLanguageProperties.getValue(request,"label.common.Supplier_Transfer_Detail_Voucher" )+"</b></td></tr></table> ");

			
					sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='0px'> ");
					sb.append("<tr> ");
					sb.append("<td width='25%' align='right'><b>").append(util.appendSpace(HisLanguageProperties.getValue(request,"label.common.Programme_Name" ), 15, 0)).append(":</b></td> ");
					sb.append("<td width='25%' >" + strProgrammeName + "</td> ");
					sb.append("<td width='25%' align='right'><b>").append(util.appendSpace(HisLanguageProperties.getValue(request,"label.common.Store_Name(s)" ), 15, 0)).append(":</b></td> ");
					sb.append("<td width='25%' >" + strHiddenValue + "</td> ");
					sb.append("</tr> ");
					sb.append("</br> ");
					
					
					sb.append("<tr><td COLSPAN='4' height='10'></td></tr></table>");

					sb.append("<table id='mainTableId' width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='0px'> ");
					sb.append("<tr><td colspan=8>");

					sb.append("<table id='mainTableRptId2' class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='0px' border='1px'>");
					sb.append("<tr bgcolor='#cdc9c9'> ");
		
						tableHead.append("<th class='multiRPTLabel' align='center' width='5%'><b>"+HisLanguageProperties.getValue(request,"label.common.S.No." )+"</b> ");
						tableHead.append("</th>");
						tableHead.append("<th class='multiRPTLabel' align='center' width='28%'><b>"+HisLanguageProperties.getValue(request,"label.common.Drug_Name" )+"</b> ");
						tableHead.append("</th>");
						tableHead.append("<th class='multiRPTLabel' align='center' width='12%'><b>"+HisLanguageProperties.getValue(request,"label.common.Batch_No." )+"</b> ");
						tableHead.append("</th> ");
						tableHead.append("<th class='multiRPTLabel' align='center' width='15%'><b>"+HisLanguageProperties.getValue(request,"label.common.Mfg_date" )+"</b> ");
						tableHead.append("</th> ");
						tableHead.append("<th class='multiRPTLabel' align='center' width='15%'><b>"+HisLanguageProperties.getValue(request,"label.common.Expiry_Date" )+"</b> ");
						tableHead.append("</th> ");
						tableHead.append("<th class='multiRPTLabel' align='center' width='10%'><b>"+HisLanguageProperties.getValue(request,"label.common.Supply_Qty" )+"</b> ");
						tableHead.append("</th> ");
						tableHead.append("<th class='multiRPTLabel' align='center' width='15%'><b>"+HisLanguageProperties.getValue(request,"label.common.Cartan_No." )+"</b> ");
						tableHead.append("</th> ");						
					
					sb.append(tableHead.toString());
					sb.append("</tr></table> ");

					sb.append("<div id='voucherDivId'><table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='0px' border='1px'>");
					sb.append("<tr bgcolor='#cdc9c9' style='display:none;'>");
					sb.append(tableHead.toString());
					sb.append("</tr>");
					
					
					

					while (ws.next()) {	
									
							sb.append("<td class='multiRPTControl' width='5%'>");
							sb.append(j);
							sb.append("</td> ");
							sb.append("<td class='multiRPTControl' style=\"text-align:left;\" width='28%'>");
							sb.append(ws.getString(1));
							sb.append("</td> ");
							sb.append("<td class='multiRPTControl' width='12%'>");
							sb.append(ws.getString(2));
							sb.append("</td> ");
							sb.append("<td class='multiRPTControl' width='15%'>");
							sb.append(ws.getString(4));
							sb.append("</td> ");
							sb.append("<td class='multiRPTControl' width='15%'>");
							sb.append(ws.getString(5));
							sb.append("</td> ");
							sb.append("<td class='multiRPTControl' width='10%'>");
							sb.append(ws.getString(6));
							sb.append("</td> ");
							sb.append("<td class='multiRPTControl' width='15%'>");
							sb.append(ws.getString(8));
							sb.append("</td> ");
												
						sb.append("</tr> ");
						j++;
						
					}
					sb.append("</table></div></td></tr>");		
					sb.append("</table> ");
				} else {
					sb.append("<table align='center' width='").append(strTableWidth).append("'cellspacing='0' cellpadding='0' height='69'> ");
					sb.append("<tr>");
					sb.append("<td colspan=\"" + nColspan + "\" class=\"multiPOControl\" style=\"text-align: center; color: red;\">"+HisLanguageProperties.getValue(request, "label.common.No_Data_Found")+"!</td>");
					sb.append("</tr></table>");
					sb.append("</table>");

				}
			} catch (Exception e) {

				e.printStackTrace();

				throw e;
			}

			return sb.toString();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
			public static String getScheduleItemList(SupplierDeskInterfaceTransFB formBean,
					SupplierDeskInterfaceTransVO vo, HttpServletRequest request, String strMode)
					throws Exception {

				StringBuffer header = new StringBuffer(1000);
				StringBuffer header1 = new StringBuffer(1000);

				StringBuffer multirow = new StringBuffer(1000);

				int programmeSize = 0;
				int tblWidth = 0;
				int i = 0;
				int totBalanceQty = 0;
				int nTmpI = 0;
				int prepoflag =0;

				double intCellWidth = 12.66;
				double newCellWidth = 0.0;
				double calCellWidth = 0.0;

				double width1 = 10;
				double width2 = 5;
				double width3 = 5;
				double width4 = 13;
				double width5 = 7;
				
				String batchreqflag =vo.getStrBatchExdateFlag().split("\\^")[0];
				String Exdatereqflag =vo.getStrBatchExdateFlag().split("\\^")[1];
				System.out.println("flagcheck"+batchreqflag+"::"+Exdatereqflag);
				
						
				

				WebRowSet ws = null;
				String unitName = "";

				try 
				{
					// programme id, name, order qty, rec qty, rejected,
					// shortage,balance qty,unit name
					ws = vo.getWsItemList();
					programmeSize = ws.size();

					if (programmeSize > 0) 
					{
						ws.next();
						unitName = ws.getString(8);
						ws.previous();

						if (programmeSize < 3)
							tblWidth = 100;
						else 
						{
							tblWidth = (programmeSize - 2) * 10 + 100;
						}

						newCellWidth = 100 / (programmeSize + 7);
						calCellWidth = (newCellWidth * 100) / intCellWidth;

						width1 = (width1 * calCellWidth) / 100;
						if ((int) width1 == 0)
							width1 = 1;

						width2 = (width2 * calCellWidth) / 100;
						if ((int) width2 == 0)
							width2 = 1;

						width3 = (width3 * calCellWidth) / 100;
						if ((int) width3 == 0)
							width3 = 1;
						width4 = (width4 * calCellWidth) / 100;
						if ((int) width4 == 0)
							width4 = 1;
						
						width5 = (width5 * calCellWidth) / 100;
						if ((int) width5 == 0)
							width5 = 1;
						
						if (strMode.equals("1")) 
						{
							header
									.append(" <table width='100%' align='center' border='0' cellpadding='1px' cellspacing='0px'> ");
							header.append(" <tr>");
							header
									.append(" <td class='multiRPTLabel2' width='70%' style='text-align:left;'>"
											+ HisLanguageProperties.getValue(request,
													"label.common.Item_detail(s)")
											+ "</td> ");
							header
									.append(" <td class='multiRPTLabel2' width='30%' style='text-align:right;'>"
											+ HisLanguageProperties.getValue(request,
													"label.common.No_of_batch")
											+ ":<input type='textbox' class='txtFldMin' style='background-color:#fff;' name='noOfRows' value='' onkeypress='if(event.keyCode==13) getMultiRow(this);'></td>");
							header.append(" </tr>");
							header.append("</table>");
						}

						if (strMode.equals("2")) 
						{
							header.append(" <table width='100%' align='center' border='0' cellpadding='1px' cellspacing='0px'> ");
						} 
						else 
						{
							header.append(" <table width='100%' align='center' border='0' cellpadding='1px' cellspacing='0px'> ");
						}
						header.append(" <tr>");
//						header
//						.append(" <td class='multiRPTLabel1' width='"
//								+ (int) (width3)
//								+ "%'>"
//								+ HisLanguageProperties.getValue(request,
//										"label.common.Same_as_Above")
//								+ "</td> ");
						header
								.append(" <td class='multiRPTLabel1' width='"
										+ (int) (width1)
										+ "%'><div id='mandatoryBatch'><font size='2' color='red'>*</font>"
										+ HisLanguageProperties.getValue(request,
												"label.common.Batch_No.")
										+ "</div></td> ");
						header.append(" <td class='multiRPTLabel1' width='"
								+ (int) width1
								+ "%'><div id=''><font size='2' color='red'>*</font>"
								+ HisLanguageProperties.getValue(request,
										"label.common.Mfg_date")
								+ "</div>                [dd-Mon-yyyy] </td>");
						
						if(Exdatereqflag.equals("1"))
						{
						header.append(" <td class='multiRPTLabel1' width='"
										+ (int) width1
										+ "%'><div id='mandatoryExpiry'><font size='2' color='red'>*</font>"
										+ HisLanguageProperties.getValue(request,
												"label.common.Expiry_Date")
										+ "</div>   [dd-Mon-yyyy]  </td>");
						}
						else
						{
							header.append(" <td class='multiRPTLabel1' width='"
									+ (int) width1
									+ "%'><div id='mandatoryExpiry'>"
									+ HisLanguageProperties.getValue(request,
											"label.common.Expiry_Date")
									+ "</div>   [dd-Mon-yyyy]  </td>");
						}
						
						
						header.append(" <td class='multiRPTLabel1' width='"
								+ (int) (width4)
								+ "%'><font size='2' color='red'>*</font>"
								+ HisLanguageProperties.getValue(request,
										"label.common.Carton_Size") + "</td>");
						
						header.append(" <td class='multiRPTLabel1' width='"
								+ (int) (width4)
								+ "%'><font size='2' color='red'>*</font>"
								+ HisLanguageProperties.getValue(request,
										"label.common.Cartan_No.") + "</td>");
						
						header.append(" <td class='multiRPTLabel1' width='"
								+ (int) (width5)
								+ "%'><font size='2' color='red'>*</font>"
								+ HisLanguageProperties.getValue(request,
										"label.common.No_of_carton") + "</td>");

						multirow.append("<form name='multirow'>");
						multirow.append("<div id='rowAdded1' style='display:none;'>");

						if (strMode.equals("2")) {
							multirow
									.append(" <table width='100%' align='center' border='0' cellpadding='1px' cellspacing='0px'> ");
						} else {
							multirow
									.append(" <table width='100%' align='center' border='0' cellpadding='1px' cellspacing='0px'> ");
						}

						multirow.append("<tr>");
						
						multirow.append("<input type='hidden' name='strStaticIndex'  id='strStaticIndex#delIndex#'  value='' />");

						multirow.append("<input type='hidden' name='strRowIndex' id='strRowIndex#delIndex#'  value=#delIndex# />");

//						multirow.append("<td CLASS='multiRPTControl' width='"
//								+ (int) (width3)
//								+ "%'>"
//								+ "<input type='checkbox'  name='strMultiRowChk' id='strMultiRowChk#delIndex#' "
//								+ "value =''   onClick=\"fillDetails('#delIndex#',this);\" ></td>");s
						
						
						
						
						prepoflag = Integer.parseInt(vo.getStrPoPreFlag());
						
						if(prepoflag==1)
						{
						
						multirow.append("<td CLASS='multiRPTControl' width='"
								+ (int) (width1)
								+ "%'><select name='strMultiRowBatchNo' class='comboMax' id='strMultiRowBatchNo#delIndex#' onBlur='checkDuplicateBatchNo(this);'  >"
								+ vo.getStrBatchNoCmb()
								+ "</select></td>");
						
						}
						else
							
						{
						
						multirow.append("<td CLASS='multiRPTControl' width='"
										+ (int) (width1)
										+ "%'>"
										+ "<input type='text' maxlength='20' class='txtFldNormal'  name='strMultiRowBatchNo' id='strMultiRowBatchNo#delIndex#' "
										+ "value =''  onkeypress='return validateData(event,17);'  onBlur='checkDuplicateBatchNo(this);'></td>");
						}
						multirow.append("<td CLASS='multiRPTControl' width='"
								+ (int) width1
								+ "%' >"
								+ HisUtil.getDatePickerMultiRowTLD(
										"strMultiRowManufacterDate",
										"strMultiRowManufacterDate#delIndex#", true,
										i) + "</td>");

						multirow.append("<td CLASS='multiRPTControl' width='"
								+ (int) width1
								+ "%' >"
								+ HisUtil.getDatePickerMultiRowTLD (
										"strMultiRowExpireDate",//,""
										"strMultiRowExpireDate#delIndex#", true,
										i) + "</td>");
										//"checkDateFormat(this,\"#delIndex#\")") + "</td>");				
					
						multirow.append("<td CLASS='multiRPTControl' width='"
										+ (int) (width4)
										+ "%'><select name='strMultiRowCartonSize' class='comboMax' id='strMultiRowCartonSize#delIndex#' onChange=\"resetProgRowQty('#delIndex#',this);\" >"
										+ vo.getStrCartonSizeCmb()
										+ "</select></td>");
						
						multirow.append("<td CLASS='multiRPTControl' width='"
								+ (int) (width4)
								+ "%'>"
								+ "<input type='text' maxlength='18'   name='strMultiRowCartonNo' disabled='true' id='strMultiRowCartonNo#delIndex#' "
								+ "value =''  onkeypress='return validateData(event,5);'  onBlur='checkDuplicateCartonNo(this);'></td>");
						
						multirow.append("<td CLASS='multiRPTControl' width='"
								+ (int) (width5)
								+ "%'>"
								+ "<input type='text' maxlength='4' class='txtFldMin'  name='strMultiRowNoOfCarton' id='strMultiRowNoOfCarton#delIndex#' "
								+ "value ='1'  onkeypress='return validateData(event,5);'  onChange=\"resetProgRowQty1('#delIndex#',this);\" ><div id='strMultiRowNoOfCartonDiv#delIndex#'></div></td>");

						// vo.setStrUnitId
						header1.append("<tr><td class='multiRPTLabel' colspan='6'><div align='right'><strong>");
									//+ HisLanguageProperties.getValue(request,
										//	"label.common.Balance_qty")
										//+ " ("
										//+ HisLanguageProperties.getValue(request,
											//	"label.common.In")
										//+ unitName
										//+ ")</strong></div></td>");

						while (ws.next()) 
						{
							/*
							 * 1.Programme Id 2.Programme Name 3.Order Qty 4.Received
							 * Qty 5.Rejected Qty 6.Shortage Qty 7.Balance Qty 8.Unit
							 * Name 9.REPL_ORDER_QTY 10.HSTNUM_REJQTY_AFT_VERIFY
							 * 11.HSTNUM_STOP_QTY 12.Supplier Return Qty
							 */

							i++;
							header.append(" <td class='multiRPTLabel1' width='"
									+ (int) width1 + "%'>" + HisLanguageProperties.getValue(request,
											"label.common.Balance_qty") + "</td>");
							header
									.append("<input type='hidden' name='strPopUpBalanceQtyDtl'  id='strPopUpBalanceQtyDtl"
											+ i
											+ "' value='"
											+ ws.getString(3)
											+ "^"
											+ ws.getString(4)
											+ "^"
											+ ws.getString(5)
											+ "^"
											+ ws.getString(6)
											+ "^"
											+ ws.getString(7)
											+ "^"
											+ ws.getString(9)
											+ "^"
											+ ws.getString(10)
											+ "^"
											+ ws.getString(11)
											+ "^"
											+ ws.getString(12)
											+ "^"
											+ ws.getString(13)
											+ "'>");
							header
									.append("<input type='hidden' name='strProgrammeId'         id='strProgrammeId"
											+ i
											+ "'        value='"
											+ ws.getString(1)
											+ "'>");

							header1
									.append("<td class='multiRPTControl' width='"
											+ (int) width1
											+ "%'><a STYLE='CURSOR:POINTER;color:blue' title='Balance Quantity Detail(s)' onClick='showOffLineBalQtyDtls(this,"
											+ nTmpI + "," + i + ",1);'><b>"
											+ ws.getString(7) + "</b></a></td>");

							multirow
									.append("<td CLASS='multiRPTControl' width='"
											+ (int) width1
											+ "%'>"
											+ "<input type='text' maxlength='10' class='txtFldMin' name='strMultiRowReceivedQty"
											+ i
											+ "' "
											+ "id='strMultiRowReceivedQty"
											+ i
											+ "#delIndex#' "
											+ "value ='' onkeypress='return validateData(event,5);' onBlur=\"totalRowQty('"
											+ i + "','#delIndex#',this);\">"
											+ "<div id='strMultiRowReceivedQtyDiv" + i
											+ "#delIndex#'></div></td>");

							totBalanceQty += Integer.parseInt(ws.getString(7));
						}

						header.append(" <td class='multiRPTLabel1' width='"
								+ (int) width2
								+ "%'>"
								+ HisLanguageProperties.getValue(request,
										"label.common.Total_qty")
								+ " ("
								+ HisLanguageProperties.getValue(request,
										"label.common.In") + unitName + ")</td>");
						header.append(" <td class='multiRPTLabel1' width='"
								+ (int) width3 + "%'>#</td>");
						

						header1.append(" <td class='multiRPTControl' width='"
								+ (int) width3 + "%'>" + totBalanceQty + "</td>");
						header1
								.append(" <input type='hidden' name='strTotalBalanceQty' value='"
										+ totBalanceQty + "'>");
						header1.append(" <td class='multiRPTLabel' width='"
								+ (int) width2 + "%'>&nbsp;</td>");

						multirow
								.append("<td CLASS='multiRPTControl' width='"
										+ (int) width2
										+ "%'>"
										+ "<div id='strMultiRowTotalQtyDiv#delIndex#'><font color='red'>0</font></div><input type='hidden' name='strMultiRowTotalQty' id='strMultiRowTotalQty#delIndex#' value ='0'>"
										+ "<input type='hidden' value='0' name='strMultiRowProgrammeDtl'></td>");

						multirow
								.append("<td width='"
										+ (int) width3
										+ "%' class='multiRPTControl'>"
										+ "<img name='' onkeypress='onPressingEnter(this,event)' src='../../hisglobal/images/minus.gif' style='cursor: pointer;' title='Delete Row' "
										+ "onclick='deleteMultiRow(\"#delIndex#\");'></td>");

						header.append("</tr>");
						header1.append("</tr>");

						header.append(header1 + "</table>");

						multirow.append("</tr></table></div>");

						multirow
								.append("<input type='hidden' name='rowIndex1' value='0'><input type='hidden' name='rowLength1' value='0'>");
						multirow.append("</form>");
						nTmpI++;

					} else {
						// no data found html here
					}

				} catch (Exception e) {
					e.printStackTrace();
				}

				return header.toString() + "$$$$" + String.valueOf(tblWidth) + "$$$$" + multirow.toString() + "$$$$" + i;
			}

			public static String getReportDtlPopUp(SupplierDeskInterfaceTransVO vo, String strReportHeader,String strUserName ,HttpServletRequest request)
					throws Exception {
				StringBuffer br = new StringBuffer();
				
				int count = 0;
				WebRowSet ws = null;
				int i = 1;		
				int width1 = 5;
				int width2 = 10;
				int width3 = 15;
				int width4 = 20;
						
				
				try {
					ws = vo.getWsSupplierInterfaceRptList();

					br.append("<HTML><HEAD><link href=\"../../hisglobal/css/dwh.css\" rel=\"stylesheet\" type=\"text/css\">");
					br.append("<link href=\"../../hisglobal/css/control.css\" rel=\"stylesheet\" type=\"text/css\">");
					br.append("<script language='JavaScript' src='../../hisglobal/jquery/3.6.0.min.js'></script>");
					br.append("<script language='Javascript' src='../../mms/js/drug_master.js'></script>");
					br.append("<script language='Javascript' src='../../hisglobal/js/innerxhtml.js'></script>");
					br.append("<script language='Javascript' src='../../hisglobal/js/commonFunctions.js'></script>");
					br.append("<script language='Javascript' src='../../hisglobal/js/fixedHeaderReport.js'></script>");
					br.append("</HEAD><body><div id='mask' style='display:block;'></div><div id='dvLoading' style='display:block;'></div>");
					br.append("<form action='/HBIMS/mms/masters/DrugMstCNT.cnt' method='post'>");
					br.append("<div id='challanStatusDtlDivId'>");

					br.append("<table align='center' width='100%' border='0' cellspacing='0' cellpadding='0'> ");
					br.append("<tr>");
					br.append("<td width='100%' colspan='15' align='right'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
					br.append("User Name : "+strUserName);
					br.append("</font></b></td> ");
					br.append("</tr>");
					br.append("</table> ");

				/*	br.append("<table width='95%' cellspacing='0px' cellpadding='1px' border='0'><tbody>");
					br.append("<tr><td colspan='2' width='95%' align='center'><font size='5' face='Arial, Helvetica, sans-serif'><strong>CENTRAL MEDICAL SERVICES SOCIETY</strong></font><br><font size='3' face='Arial, Helvetica, sans-serif'><strong>Ministry of Health &amp; Family Welfare</strong></font><br><font size='3' face='Arial, Helvetica, sans-serif'><strong>(Government Of India)</strong></font><br><font size='2' face='Arial, Helvetica, sans-serif'>2nd Floor, Vishwa Yuvak Kendra,</font><br><font size='2' face='Arial, Helvetica, sans-serif'>Pt. Uma Shankar Dikshit Marg, Teen Murti Road,</font><br><font size='2' face='Arial, Helvetica, sans-serif'>Opposite Police Station Chankayapuri, New Delhi-110021</font><br></td>");
					
					br.append("</tr>");
					br.append("</tbody></table> ");
					*/
					
					/*<table width="95%" cellspacing="0px" cellpadding="1px" border="0"><tbody>
					<tr><td colspan="2" width="95%" align="center"><font size="5" face="Arial, Helvetica, sans-serif"><strong>CENTRAL MEDICAL SERVICES SOCIETY</strong></font><br><font size="3" face="Arial, Helvetica, sans-serif"><strong>Ministry of Health &amp; Family Welfare</strong></font><br><font size="3" face="Arial, Helvetica, sans-serif"><strong>(Government Of India)</strong></font><br><font size="2" face="Arial, Helvetica, sans-serif">2nd Floor, Vishwa Yuvak Kendra,</font><br><font size="2" face="Arial, Helvetica, sans-serif">Pt. Uma Shankar Dikshit Marg, Teen Murti Road,</font><br><font size="2" face="Arial, Helvetica, sans-serif">Opposite Police Station Chankayapuri, New Delhi-110021</font><br></td>
					<td width="10%" align="right"><div id="saveId" style="display : block"><div class="hidecontrol" id="printid1" align="right"><img style="cursor: pointer;" title="Save in Pdf" src="../../hisglobal/images/pdf.png" onclick="generateLetterReportPdf(null);"><img style="cursor: pointer;" title="Cancel" src="../../hisglobal/images/stop.png" onclick="cancelPrintLoa();"> </div></div></td> 
					</tr>
					<tr>
					<td colspan="2" width="90%" align="center"><font size="3" face="Arial, Helvetica, sans-serif"><br><br><strong><u>LETTER OF ACCEPTANCE</u></strong></font>
					</td>
					</tr>
					</tbody></table>*/
					br.append("<table width='95%' cellspacing='0px' cellpadding='1px' border='0'><tbody>");
					br.append("<tr><td colspan='2' width='95%' align='center'><font size='5' face='Arial, Helvetica, sans-serif'><strong>All India Institute of Medical Sciences</strong></font><br><font size='3' face='Arial, Helvetica, sans-serif'><strong>Ministry of Health Family Welfare</strong></font><br><font size='3' face='Arial, Helvetica, sans-serif'><strong>(Government Of India)</strong></font><br><font size='2' face='Arial, Helvetica, sans-serif'>2nd Floor, Vishwa Yuvak Kendra,</font><br><font size='2' face='Arial, Helvetica, sans-serif'>Pt. Uma Shankar Dikshit Marg, Teen Murti Road,</font><br><font size='2' face='Arial, Helvetica, sans-serif'>Opposite Police Station Chankayapuri, New Delhi-110021</font><br></td>");
					br.append("</tr></br></br>");
                    br.append("<tr id='reportDisplayHeaderRow'> ");
					br.append("<td id='reportDisplayHeaderData' width='90%' colspan='17' align='center' style='padding-left:25px'> <b><font size='3' face='Verdana, Arial, Helvetica, sans-serif'>");
					br.append("Supplier Interface Report");
					br.append("</font></b></td> ");
					

				

					br.append("<table border='0' width='100%' align='center'> ");
					br.append("<tr> ");
					br.append("<td align='right' width='90%'>");
					br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'><div id='printImg'>");
					br.append("<img style='cursor: pointer; ' title='Print Page'  ");
					br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataNew(1);' />");
					br.append("<img style='cursor: pointer; ' title='Save as Pdf' src='../../hisglobal/images/pdf.png' onClick='generatePdfCommon1(\"challanStatusDtlDivId\");'/>");
					br.append("<img style='cursor: pointer; ' title='Save as Excel' src='../../hisglobal/images/excel1.png' onClick='generateXLSCommon(event,\"challanStatusDtlDivId\");' />");
					br.append("<img style='cursor: pointer; ' title='Cancel Process' src='../../hisglobal/images/stop.png' onClick='cancelToList();' /> </div></div></div>");
					br.append(" </td> ");
					br.append(" </tr> ");
					br.append(" </table> ");

					br.append("<div id='wrapper' style='width:1500;'><table id='mainTableRptId' width='1500' border='0' align='center' cellspacing='1px' cellpadding='1px'>");
					// header
					br.append("<tr id='tableHeaderId'> ");
					br.append("<th style=\"text-align: center;\" colspan='1' width='" + width1
							+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No<b></font></th>\n");
					br.append("<th style=\"text-align: center;\" colspan='1' width='" + width3
							+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier Name<b></font></th>\n");
					br.append("<th style=\"text-align: center;\" colspan='1' width='" + width3
							+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No<b></font></th>\n");
					br.append("<th style=\"text-align: center;\" colspan='1' width='" + width2
							+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Date<b></font></th>\n");
					br.append("<th style=\"text-align: center;\" colspan='1' width='" + width2
							+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ordered Qty<b></font></th>");
					br.append("<th style=\"text-align: center;\" colspan='1' width='" + width2
							+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Balance Qty<b></font></th>\n");	
					br.append("<th style=\"text-align: center;\" colspan='1' width='" + width4
							+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name<b></font></th>\n");
					
					br.append("<th style=\"text-align: center;\" colspan='1' width='" + width2
							+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Status<b></font></th>\n");
					br.append("</tr>");

					if (ws != null) 
					{
						if (ws.size() != 0) 
						{
							while (ws.next()) 
							{
								
								// last row
								br.append("<tr> ");
								br.append("<td style=\"text-align: center;\" colspan='1' width='" + width1
										+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + (i++) + "</font></td>\n"); 
								br.append("<td style=\"text-align: center;\" colspan='1'   width='" + width3
										+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(14) + "</font></td>\n");
								br.append("<td style=\"text-align: center;\" colspan='1'   width='" + width3
										+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(11) + "</font></td>\n"); 
								br.append("<td style=\"text-align: center;\" colspan='1' width='" + width2
										+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(3)+ "</font></td>\n"); // 4 Tender No
								br.append("<td style=\"text-align: center;\" colspan='1'   width='" + width2
										+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(8) + "</font></td>\n"); 
								br.append("<td style=\"text-align: center;\" colspan='1' width='" + width2
										+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(9) + "</font></td>\n"); 
																																		
								br.append("<td style=\"text-align: center;\" colspan='1' width='" + width4
										+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(10) + "</font></td>\n");
								
								
								br.append("<td style=\"text-align: center;\" colspan='1' width='" + width2
										+ "%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >" + ws.getString(12) + "</font></td>\n");
								
								
								
								
								count++;
							}
		//rs.getString(4).equals("-") ? rs.getString(4) : rs.getString(4).split("\\^")[1]
							if (ws != null) {
								ws.close();
								ws = null;
							}
						} // ws.size <> 0
						else {
							br.append("<tr><td colspan='6'></td></tr>");
							br.append("<tr>");
							br.append("<td colspan='6'><b><div id='id' align='center'>"+"No Data Found"+"</div></b></td>");
							br.append("</tr>");

						}
					} else {
						br.append("<tr>");
						br.append("<td colspan='6'><b><div id='id' align='center'>"+"No Data Found"+"</div></b></td>");
						br.append("</tr>");

					}
				}// try
				catch (Exception e) {
					e.printStackTrace();

					br.append("<tr>");
					br.append("<td colspan='6'><b><div id='id' align='center'>"+"No Data Found"+"</div></b></td>");
					br.append("</tr>");
					br.append("</table></div>");
					br.append("</div><input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' />");
					br.append("</form></body></HTML>");

					if (ws != null) {
						ws.close();
						ws = null;
					}

					throw new Exception("ChallanStatusRptVO.getChallanProcessDtl()->" + e.getMessage());
				}
				br.append("</table></div>");
				br.append("</div><input type='hidden' name='hmode'/><input type='hidden' name='strHtmlCode' value='' />");
				br.append("</form></body></HTML>");

				return br.toString();

			}
}
