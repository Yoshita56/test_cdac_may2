package mms.reports.controller.hlp;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import mms.reports.vo.POWiseMaterialReceiptRptVO;


public class POWiseMaterialReceiptRptHLP {

	private static final String strColor = "red";
	private static final String defaultColor = "blue";

	
	public static String getConsolidatedDetails(POWiseMaterialReceiptRptVO vo) 
	 {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = vo.getWsItemCategoryCombo();
		int i=1;
		double totamt = 0.00;
		double Quantity = 0.00;
		String strExpiryDt="",strbtch="",costtopat="",admchg="" , strmrp="",strPurRate="",strUser="",strRemarks="",strBrandId="",tmpId="0",strBal="",stritemTax="" , strRateWithTax="",manuf="";
	    String strInvoiceNo="";
	    String PoDate;
	    String PoNo;
	    String MRP;	   
	    double diffInAmt = 0.000;
	    String strMrnDate = "";
		String strPONo="";
		String strPODate="",challanNo="",challanDate="";
		String strVendor="",strdcno="";
		String strItem="";
		String strSup="",strRej="",strRcd="";
		String strAmount="0.00";
		double tot = 0.000,tmpRcd=0.0;
		String strOrderQty="";
		String strMrnNo = "" , storeName = "",uc_req="",cat="";
		String diffAmtSign = "";
	    try
	    {
	    
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> "
						+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td></tr>");
						//+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td></tr>");
				
				sb.append(" <tr align='right'> "
						+ " <td colspan='12'>"
						+ "<div id='printImg' align='right'>"
						+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' />"
						+ "</div></td></tr></table>");
						
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"		
						+ "<tr><td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>"
						+ "<b>"+" PO Wise Material Receipt Report "+"</b>"
						+ "</font></td>"
						+ "</tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Item Category ::<b>"+vo.getStrCategoryName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Item Name ::<b>"+vo.getStrlpItemName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Puchase Through ::<b>"+vo.getStrInstituteName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Supplier Name ::<b>"+vo.getStrSupplierName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
												
//						+ " <tr><td align='center' colspan='3'></td> "
//						+ "<td align='center' colspan='3'>"
//						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
//							+ "For PO No::<b>"+vo.getStrPoNo()+"</b></font></td><td align='center' colspan='2'></td></tr>"
//						
						+ " <tr> <td align='center' colspan='3'></td>"
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.getStrFinancialEndYear()+"</b></font></td>"
								+ "<td align='center' colspan='2'>"
								+ "<div id='printid1' class='hidecontrol' style='float:right'>"
								+"</td></tr>" +
											
						 "</table> ");
				
				sb.append("<br><br>");
				while(ws.next()) {
					/*
					DataBase Indexing
					
					1.  MRNNO,
					2.  MRN_DATE,
					3.  suppName,
					4.  CHALLAN_INVOICE_DATE,
					5.  STRING_AGG(ITEM_NAME, '^' ) ITEM_NAME,
					6.  STRING_AGG(batch_no,'^') batch_no,
					7.  STRING_AGG(expiry_date,'^') expiry_date,
					8.  invoice_no,
					9.  invoice_date,
					10. STRING_AGG(quantity,'^') quantity,
					11. STRING_AGG(rate,'^') rate,
					12. STRING_AGG(total_amount,'^') total_amount,
					13. Purchased_Through,
					14. L_PO_NO
					15. CHALLAN_INVOICE_NO
					16. STORE_NAME
					17. category
					18. PoDate
					19. mrp
					20. item_tax
					21. pur_rate
					22. RATE_WITH_TAX
					23. admchg
					24. DIFF_AMT
					25. costtopat
					*/
					strMrnNo              = ws.getString(1);
					strMrnDate            = ws.getString(2);
					strVendor             = ws.getString(3);
					challanNo			  = ws.getString(15);
					challanDate			  = ws.getString(4);
					storeName  			  = ws.getString(16);// ws.getString("store");
					uc_req  			  = "0";// ws.getString("uc_req");
					cat  			  	  = ws.getString(17);// ws.getString("cat");
					PoDate				  = ws.getString(18);// ws.getString("PoDate");
					PoNo                  = ws.getString(14);
					
					sb.append("<table width='725' align='center' cellpadding='1px' cellspacing='1px'> ");	
					
					sb.append("<tr> ");
					sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Store Name : </b></font></td>");
					sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+storeName +"</b></font></td>");
					sb.append("<td align='right' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Category : </b></font></td>");
					sb.append("<td align='left'  width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+cat +"</b></font></td>");
					sb.append("</tr> ");
					
					sb.append("<tr> ");
					sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN No : </b></font></td>");
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strMrnNo +"</b></font></td>");
					sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN Date : </b></font></td>");
					sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strMrnDate+"</b></font></td>");
					sb.append("</tr> ");
					/*
					sb.append("<tr> ");
					sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>No  : </b></font></td>");
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPONo +"</b></font></td>");
					sb.append("<td align='right' width='60%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Date  : </b></font></td>");
					sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strPODate +"</b></font></td>");
					sb.append("</tr> ");
					*/
					
					sb.append("<tr> ");
					sb.append("<td align='right' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan/Invoice No : </b></font></td>");
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+challanNo+"</b></font></td>");
					sb.append("<td align='right' width='58%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan/Invoice Date.  : </b></font></td>");
					sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+challanDate+"</b></font></td>");
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No  : </b></font></td>");
					sb.append("<td align='left' width='80%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+PoNo+"</b></font></td>");
					//sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Uc.</b></font></td>");
					//sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+uc_req+"</b></font></td>");
					sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Date : </b></font></td>");
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+PoDate+"</b></font></td>");
					/*sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");*/
					sb.append("</tr> ");
					
					sb.append("<tr> ");
					sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier : </b></font></td>");
					sb.append("<td align='left' width='80%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strVendor+"</b></font></td>");
					//sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Uc.</b></font></td>");
					//sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+uc_req+"</b></font></td>");
//					sb.append("<td align='right' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >PO Date</font></td>");
//					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+PoDate+"</font></td>");
					/*sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strdcno.split("#")[1]+"</b></font></td>");*/
					sb.append("</tr> ");
//					sb.append("<tr> ");
//					sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>PO No : </b></font></td>");
//					sb.append("<td align='left' width='90%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+PoNo+"</b></font></td>");
//					//sb.append("<td align='left' width='5%'></td>");
//					//sb.append("<td align='left' width='5%'></td>");
//					sb.append("</tr> ");
					
					sb.append("<tr><td width='725' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
					sb.append("</table> ");
					
					sb.append("<table width='725' align='center' cellpadding='1px' cellspacing='1px'> ");
					sb.append("<tr> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.NO.</b></font></td>");
					sb.append("<td align='center' width='40%' colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>ITEM DESCRIPTION</b></font></td>");
					sb.append("<td align='center' width='40%'  colspan='6'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>QUANTITY</b></font></td>");			
					sb.append("<td align='center' width='11%' colspan=6><font face='Verdana, Arial, Helvetica, sans-serif' ><b>AMOUNT</b></font></td>");
					sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
					sb.append("</tr> ");
					sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
					sb.append("<tr> ");
					sb.append("<td align='center' width='2%'></td>");			
					sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Brand</b></font></td>");			
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Batch</b></font></td>");
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Expire</b></font></td>");
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>MRP</b></font></td>");
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'  ><b>Tax</b></font></td>");
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif'   ><b>Pur.Rate</b></font></td>");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur.Rate<br>(With Tax)</b></font></td>");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Adm Chg/Unit</b></font></td>");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost <br>To Pat.</b></font></td>");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'><b>Qty</b></font></td>");			
					sb.append("<td align='right' width='7%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>");
					sb.append("</tr> ");
					sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
					
//					1.  MRNNO,
//					2.  MRN_DATE,
//					3.  suppName,
//					4.  CHALLAN_INVOICE_DATE,
//					5.  STRING_AGG(ITEM_NAME, '^' ) ITEM_NAME,
//					6.  STRING_AGG(batch_no,'^') batch_no,
//					7.  STRING_AGG(expiry_date,'^') expiry_date,
//					8.  invoice_no,
//					9.  invoice_date,
//					10. STRING_AGG(quantity,'^') quantity,
//					11. STRING_AGG(rate,'^') rate,
//					12. STRING_AGG(total_amount,'^') total_amount,
//					13. Purchased_Through,
//					14. L_PO_NO
//					15. CHALLAN_INVOICE_NO
//					16. STORE_NAME
//					17. category
//					18. PoDate
//					19. mrp
//					20. item_tax
//					21. pur_rate
//					22. RATE_WITH_TAX
//					23. admchg
//					24. DIFF_AMT
//					25. costtopat
					
					String items[] = ws.getString(5).split("\\^");
					String rates[] = ws.getString(11).split("\\^");
					String quantities[] = ws.getString(10).split("\\^");
					String expDates[] = ws.getString(7).split("\\^");
					String batches[] = ws.getString(6).split("\\^");
					String mrps[] = ws.getString(24).split("\\^");
					String item_taxes[] = ws.getString(20).split("\\^");
					String pur_rates[] = ws.getString(21).split("\\^");
					String totalAmts[] = ws.getString(11).split("\\^");
					String rate_with_taxes[] = ws.getString(22).split("\\^");
					String admchgs[] = ws.getString(23).split("\\^");
					String costToPats[] = ws.getString(25).split("\\^");
					i=1;
					tot=0;
					for(int j=0;j<items.length;j++)
					{
							
							strItem				  = items[j];
							strSup				  = ws.getString(3);
							//strRej				  = ws.getString("rej_qty");
							strRcd				  = quantities[j];//ws.getString("rcd_qty");
							strAmount			  = totalAmts[j];
							strOrderQty			  = quantities[j];
							strmrp				  = "0";//ws.getString("mrp");
							strExpiryDt			  = expDates[j];
							strbtch 			  = batches[j];
							strPurRate			  = pur_rates[j];//ws.getString("pur_rate");
							strBrandId			  =  "0";//ws.getString("id");
							strBal				  = "0";//ws.getString("bal_qty");
							stritemTax			  = item_taxes[j];//ws.getString("item_tax");
							costtopat			  = costToPats[j];
							admchg				  = admchgs[j];//ws.getString("admchg");
							MRP				 	  = mrps[j];//ws.getString(41);
							
							//if(Double.parseDouble(admchg)>1000)
							//	admchg = Double.toString(1000.0);
							strRateWithTax = "0";//ws.getString("RATE_WITH_TAX");
							//manuf = ws.getString("manuf");
							
						sb.append("<tr> ");
						sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(i);
						sb.append("</font></td> ");	
						
					
						sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strItem);
						sb.append("</font></td> ");
					
						sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strbtch);
						sb.append("</font></td> ");
						sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strExpiryDt);
						sb.append("</font></td> ");
						sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(MRP);
						sb.append("</font></td> ");
						sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(stritemTax);
						sb.append("</font></td> ");
						
						sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strPurRate);
						sb.append("</font></td> ");
						
						sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strRateWithTax);
						sb.append("</font></td> ");
						sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(admchg);
						sb.append("</font></td> ");
						sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+costtopat+"</font></td> ");
						sb.append("<td align='center' width='11%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strRcd);
						sb.append("</font></td> ");
						
						sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						//sb.append(Math.round((Double.parseDouble(strRateWithTax) * Double.parseDouble(strRcd))* 1000.0)/1000.0);
						sb.append(strAmount);		
						sb.append("</font></td></tr> ");
						
						
						
						i++;
						//tot=tot+(Double.parseDouble(strRateWithTax) * Double.parseDouble(strRcd));
						tot=tot+Double.parseDouble(strAmount);
						tmpId=strBrandId;

					}
					sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
					sb.append("<tr> ");
					sb.append("<td style='text-align:right;' width='5%' colspan='10'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TOTAL</b></font></td>");
					sb.append("<td style='text-align:right;' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+Math.round(tot * 1000.0)/1000.0+"</b></font></td>");
					sb.append("</tr> ");
					sb.append("<tr><td width='100%' colspan='14'>--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------</td></tr> ");
								    
					if(diffInAmt> 0)
					{
						sb.append("<tr> ");
						sb.append("<td style='text-align:right;' width='5%' colspan='10'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Diff Amt [ "+diffAmtSign+" ]</b></font></td>");
						sb.append("<td style='text-align:right;'colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+diffInAmt+"</b></font></td>");
						sb.append("</tr> ");
						sb.append("<tr> ");
						sb.append("<td style='text-align:right;' width='5%' colspan='10'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Final TOTAL</b></font></td>");
						
						if(diffAmtSign.equals("+"))
						{	
						  sb.append("<td style='text-align:right;' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+(tot+diffInAmt)+"</b></font></td>");
						}
						else
						{
						  sb.append("<td style='text-align:right;' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+(tot-diffInAmt)+"</b></font></td>");	
						}
						sb.append("</tr> ");
					}
					sb.append("<td colspan='13' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
					sb.append("</tr> ");
					sb.append("</table>");
				}
		}		
		else
		{
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
		    new HisException("Local Purchase Report","POWiseMaterialReceiptRptHLP.getConsolidatedDetails()-->",e.getMessage());
	  }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	}
	
	public static String getConsolidatedDetails_Old(POWiseMaterialReceiptRptVO vo) 
	 {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = vo.getWsItemCategoryCombo();
		int i=1;
		double totamt = 0.00;
		double Quantity = 0.00;
	    try
	    {
	    
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> "
						+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td></tr>");
						//+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td></tr>");
				
				sb.append(" <tr align='right'> "
						+ " <td colspan='12'>"
						+ "<div id='printImg' align='right'>"
						+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' />"
						+ "</div></td></tr></table>");
						
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"		
						+ "<tr><td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>"
						+ "<b>"+" PO Wise Material Receipt Report "+"</b>"
						+ "</font></td>"
						+ "</tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Item Category ::<b>"+vo.getStrCategoryName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Item Name ::<b>"+vo.getStrlpItemName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Puchase Through ::<b>"+vo.getStrInstituteName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Supplier Name ::<b>"+vo.getStrSupplierName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
												
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
							+ "For PO No::<b>"+vo.getStrPoNo()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr> <td align='center' colspan='3'></td>"
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.getStrFinancialEndYear()+"</b></font></td>"
								+ "<td align='center' colspan='2'>"
								+ "<div id='printid1' class='hidecontrol' style='float:right'>"
								+"</td></tr>" +
											
						 "</table> ");
				/*
				DataBase Indexing
				
				1. -------->		SrNO
				2. -------->		Entry_Date
				3. -------->		suppName
				4. -------->		item_name
				5. -------->		Batch_No
				6. -------->		Expiry_Date
				7. -------->		Invoice_No
				8. -------->		Invoice_Date
				9. -------->		Quantity
				10. ------->		Rate
				11. ------->		Total_Amount
				12. ------->		Purchase Mode
				*/
//				strMrnNo              = ws.getString("mrn_no");
//				strMrnDate            = ws.getString("challan_dt");
//				strPONo  		 	  = ws.getString("po_no");
//				strPODate	  		  = ws.getString("po_date");
//				strVendor             = ws.getString("supp_info");
//				strdcno				  = ws.getString("dc_no");
//				strUser				  = ws.getString("usr");
//				storeName  			  = ws.getString("store");
//				uc_req  			  = ws.getString("uc_req");
//				cat  			  	  = ws.getString("cat");
//				strRemarks            = ws.getString("remarks");
//				strInvoiceNo          = ws.getString("INV_NO");
//				PoDate				  = ws.getString("PoDate");
//				PoNo				  = ws.getString("PoNo");
				sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        
		        sb.append("<td width='5%' align='center'><b>S.No</b>");
			    sb.append("</td>");
			    
		        sb.append("<td width='15%' align='center'><b>LPDTL</b>");
			    sb.append("</td>");
			    
			    sb.append("<td width='14%' align='center'><b>Supplier Name</b>");
			    sb.append("</td>");
			    
			    sb.append("<td width='8%' align='center'><b>Expected Delivery Date</b>");
		        sb.append("</td>");
			    		       
		        sb.append("<td width='8%' align='center'><b>Actual Delivery Date</b>");
		        sb.append("</td>");
		       
		        sb.append("<td width='10%' align='center'><b>Performance</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='10%' align='center'><b>Status</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='10%' align='center'><b>Value</b>");
		        sb.append("</td>");
		        
		        sb.append("</tr>");
		      

				while(ws.next())
				{		

					sb.append("<tr>");
					
					sb.append("<td  width='5%' align='center' >");							
					sb.append(i);									//	S.No				
					sb.append("</td>");
					
					sb.append("<td  width='15%' align='right'>");
					sb.append(ws.getString(8)+" / "+ws.getString(5));				//	LPDTL
					sb.append("</td>");
					
					sb.append("<td  width='14%' align='right'>");
					sb.append(ws.getString(6));								    //	Supplier Name
					sb.append("</td>");
					
					sb.append("<td  width='8%'align='center'>");
					sb.append(ws.getString(12));									//	Expected Delivery Date
					sb.append("</td>");
					
					sb.append("<td  width='8%' align='center'>");				// Actual Delivery Date
					sb.append(ws.getString(11));									
					sb.append("</td>");				
					
					sb.append("<td  width='10%' align='right'>");
					sb.append(ws.getString(13));									//	Performance
					sb.append("</td>");								
					
					sb.append("<td  width='10%' align='center'>");
					sb.append(ws.getString(10));								//	Status
					sb.append("</td>");
					
					sb.append("<td  width='10%' align='right'>");								
					sb.append(ws.getString(9));									//	Value			
					sb.append("</td>");

					sb.append("</tr>");
					i++;
							
				}
				
				sb.append("</table>");
			}
		else
		{
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
		    new HisException("Local Purchase Report","BreakageItemDtlTransHLP.getBreakageDetails()-->",e.getMessage());
	  }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	}
	
	
	public static String getLPMRNDetails(POWiseMaterialReceiptRptVO vo) 
	 {
		StringBuffer sb = new StringBuffer("");
		WebRowSet ws = vo.getWsItemCategoryCombo();
		int i=0;
		double totamt = 0.00;
		double Quantity = 0.00;
	    try
	    {
	    
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
						+ " <tr> "
						+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td></tr>");
						//+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td></tr>");
				
				sb.append(" <tr align='right'> "
						+ " <td colspan='12'>"
						+ "<div id='printImg' align='right'>"
						+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' />"
						+ "</div></td></tr></table>");
						
				sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>"		
						+ "<tr><td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='3'>"
						+ "<b>"+" PO Wise Material Receipt Report "+"</b>"
						+ "</font></td>"
						+ "</tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Item Category ::<b>"+vo.getStrCategoryName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Item Name ::<b>"+vo.getStrlpItemName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Puchase Through ::<b>"+vo.getStrInstituteName()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "For Supplier Name ::<b>"+vo.getStrSupplierName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
							+ "For PO No::<b>"+vo.getStrPoNo()+"</b></font></td><td align='center' colspan='2'></td></tr>"
						
						+ " <tr> <td align='center' colspan='3'></td>"
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.getStrFinancialEndYear()+"</b></font></td>"
								+ "<td align='center' colspan='2'>"
								+ "<div id='printid1' class='hidecontrol' style='float:right'>"
								+"</td></tr>" +
											
						 "</table> ");
				
				/*
				DataBase Indexing
				
				1. -------->		SrNO
				2. -------->		MRN_DATE
				3. -------->		SUPP_NAME
				4. -------->		item_name
				5. -------->		Batch_No
				6. -------->		Expiry_Date
				7. -------->		Invoice_No
				8. -------->		Invoice_Date
				9. -------->		Quantity
				10.------->		    Rate
				11.------->		    Total_Amount
				12.------->		    Purchased_Through
				13.------->         L_PO_NO
				14.------->         L_PO_DATE
				15.------->         CHALLAN_INVOICE_NO
				16.------->         CHALLAN_INVOICE_DATE 
				*/

				sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center'><b>S.No</b>");
			    sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>MRN Date</b>");
			    sb.append("</td>");
			    sb.append("<td width='8%' align='center'><b>PO No</b>");
			    sb.append("</td>");
			    sb.append("<td width='15%' align='center'><b>Vendor</b>");
			    sb.append("</td>");
			    sb.append("<td width='15%' align='center'><b>Item Name</b>");
		        sb.append("</td>");
		        //sb.append("<td width='13%' align='center'><b>Purchase Mode</b>");
		        //sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>Batch No.</b>");
		        sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>Expiry Date</b>");
		        sb.append("</td>");
		        sb.append("<td width='7%' align='center'><b>Invoice No</b>");
		        sb.append("</td>");
		        sb.append("<td width='7%' align='center'><b>Invoice Date</b>");
			    sb.append("</td>");
			    sb.append("<td width='7%' align='center'><b>Qty(No)</b>");
			    sb.append("</td>");
			    sb.append("<td width='7%' align='center'><b>Rate(With Tax)</b>");
			    sb.append("</td>");
			    sb.append("<td width='7%' align='center'><b>Value</b>");
			    sb.append("</td>");
		        sb.append("</tr>");
		      

				while(ws.next())
				{		
							if(i==0)
							{
								Quantity = Double.parseDouble(ws.getString(9));
								totamt = Double.parseDouble(ws.getString(11));
							}
							else
							{
								Quantity = Quantity + Double.parseDouble(ws.getString(9));
								totamt = totamt + Double.parseDouble(ws.getString(11));
							}
					
							sb.append("<tr>");
							sb.append("<td  width='5%' align='center' >");							
							sb.append(ws.getString(1));									//	S.No				
							sb.append("</td>");
							sb.append("<td  width='8%' align='center'>");
							sb.append(ws.getString(2));									//	MRN_DATE
							sb.append("</td>");
							sb.append("<td  width='8%' align='left'>");
							sb.append(ws.getString(13));									//	PO_NO
							sb.append("</td>");							
							sb.append("<td  width='15%'>");
							sb.append(ws.getString(3));								    //	Supplier Name
							sb.append("</td>");
							sb.append("<td  width='15%'>");								
							sb.append(ws.getString(4));									//	Item Name					
							sb.append("</td>");
							//sb.append("<td  width='13%'>");
							//sb.append(ws.getString(12));								//	Purchase Mode
							//sb.append("</td>");
							
							sb.append("<td  width='8%' align='left'>");				// Batch No.
							sb.append(ws.getString(5));									
							sb.append("</td>");
							
							sb.append("<td  width='8%'align='center'>");
							sb.append(ws.getString(6));									//	Expiry Date
							sb.append("</td>");
							sb.append("<td  width='7%' align='left'>");
							sb.append(ws.getString(15));									//	Invoice No
							sb.append("</td>");
							sb.append("<td  width='7%' align='center'>");
							sb.append(ws.getString(16));								    //	Invoice Date
							sb.append("</td>");
							sb.append("<td  width='7%' align='right'>");
							sb.append(ws.getString(9));								//	Quantity
							sb.append("</td>");
							sb.append("<td  width='7%' align='right'>");
							sb.append(ws.getString(10));								//	Rate
							sb.append("</td>");
							sb.append("<td  width='7%' align='right'>");
							sb.append(ws.getString(11));								//	Total Amount Rate * Quantity
							sb.append("</td>");
							sb.append("</tr>");
							i++;
							
				}
				
							sb.append("<tr background-color='red'>");
							sb.append("<td  colspan='9' align='right'>");
							sb.append("<b>");
							sb.append("Total");
							sb.append("</b>");
							sb.append("</td>");
							sb.append("<td align='right'>");
							sb.append("<b>"+Math.round(Quantity)+"</b>");											
							sb.append("</td>");
							sb.append("<td align='right'>");
							sb.append("");											
							sb.append("</td>");
							sb.append("<td align='right'>");
							sb.append("<b>"+Math.round(totamt)+"</b>");											
							sb.append("</td>");
							sb.append("</tr>");
				
				sb.append("</table>");
			}
		else
		{
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
		    new HisException("Local Purchase Report","BreakageItemDtlTransHLP.getBreakageDetails()-->",e.getMessage());
	  }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	}


}
