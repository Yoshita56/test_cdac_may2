package mms.reports.controller.hlp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.controller.fb.BillApprovalVerificationRptFB;
import mms.reports.vo.BillApprovalVerificationRptVO;
import mms.transactions.bo.BillApprovalTransBO;
import mms.transactions.vo.BillApprovalTransVO;

public class BillApprovalVerificationRptHLP {

	/*
		public static String getPaymentDetails_Print(WebRowSet ws,String hosCode) throws Exception 
		{
			
			 
			    System.out.println("--------------------- LocalPurchaseNewTransHLP.getPaymentDetails_Print -------------------------------");
			    StringBuffer sb = new StringBuffer("");
			
			    String body = getPaymentDetails(ws,hosCode);
			
				
			    sb.append(body);	    
			   
			
			return sb.toString();
		}
		
		public static String getPaymentDetails(WebRowSet ws,String hosCode) throws Exception 
		{
	
			System.out.println("--------------------- LocalPurchaseNewTransHLP.getPaymentDetails -------------------------------");
			StringBuffer sb = new StringBuffer("");
			String strMrnNo = "" , storeName = "",uc_req="",cat="";
			String strMrnDate = "";
			String strPONo="";
			String strPODate="";
			String strVendor="",strdcno="";
			String strItem="";
			String strSup="",strRej="",strRcd="";
			String strAmount="0.00";
			double tot = 0.000,tmpRcd=0.0;
			String strOrderQty="";
			String strPOStoreName		  ="";
			String strPONODate			  ="";
			String strInvoiceNoDate	  	  ="";
			String strSuppName			  ="";
			String strInvAmt			  ="";
			String strInvTaxAmt			  ="";
			String strPenaltyAmt		  ="";
			String strAmtAfterDedduct     ="";
			String strPaymentStatus	      ="";
			String strBillType			  ="";
			String strInvAppBy			  ="";
			String strInvAppDate   	      ="";
			String strInvoiceSaveBy	      ="";
			String strPaymenStatusCode	  ="";							
			String strUtrNo               ="";
			String strPoNetAmt            ="";
			String strSuppAmtTillPayment  ="";
			String strCatgCode	  		  ="";
			String strRemarks             ="";
			String strStoreId			  ="";
			String strSupplierId  	      ="";
			String strInvoiceStatus	      ="";
			String strGroupByValue        ="";
			
			int i=1,count=0;
			
			BigDecimal         totalInvAmount = new BigDecimal(BigInteger.ZERO,  2);
			BigDecimal              invAmount = new BigDecimal(BigInteger.ZERO,  2);
			
			BigDecimal         totalTaxAmount = new BigDecimal(BigInteger.ZERO,  2);
			BigDecimal              taxAmount = new BigDecimal(BigInteger.ZERO,  2);
			
			BigDecimal           totalPenalty = new BigDecimal(BigInteger.ZERO,  2);
			BigDecimal                penalty = new BigDecimal(BigInteger.ZERO,  2);		
			
			BigDecimal      totalCalInvAmount = new BigDecimal(BigInteger.ZERO,  2);
			BigDecimal           calInvamount = new BigDecimal(BigInteger.ZERO,  2);				
			
	
			try 
			{
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px' > ");
				if(ws != null && ws.size() > 0)
				{				
					sb.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");												
					sb.append("<tr> ");
					sb.append("<td align='center' 	width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SNo</b></font>.</td>");
					sb.append("<td align='center' 	width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice No/Date</b></font></td>");				
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Bill Type</b></font></td>");
					sb.append("<td align='center' 	width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>[App By/Date]/User</b></font></td>");				
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice Amt<br> [A] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax Amt<br> [B] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Disc. Amt<br> [C] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Final Amt<br> [D=(A+B)-C]</b></font></td>");				
					sb.append("</tr> ");
					sb.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");
					
					 * 1.PO_STORE_NAME
					 * 2.PO_NO_DATE
					 * 3.INV_NO_DATE
					 * 4.SUPP_NAME
					 * 5.INVOICE_AMT
					 * 6.PEALTY_AMT
					 * 7.AMT_AFTER_DEDUCTION
					 * 8.PAYMENT_STATUS
					 * 9.BILL_TYPE [ BULK PO , LOCAL PO]
					 * 10.APP_BY 
					 * 11.APP_DATE
					 * 12.SAVE_BY_USER
					 * 13.PAYMENT_STATUS_CODE
					 * 14.UTR_NO
					 * 15.PO_NET_AMT
					 * 16.SUPP_AMT_TILL_INVOICE_GENERATED
					 * 17.CATG_CODE
					 * 18.INVOICE_REMARKS
					 * 19.STORE_ID
					 * 20.SUPPLIER_ID
					 * 21.INVOICE_STATUS
					 * 22.hstnum_supp_invoice_tax_amt
					 * 23.((NVL(C.HSTNUM_SUPP_INVOICE_AMT,0)+ NVL(hstnum_supp_invoice_tax_amt,0))- NVL(C.HSTNUM_PENELTY_WAIVE_AMT,0))
					 * 
						while (ws.next()) 
						{
								
								
						   strInvAmt			 = ws.getString(5);   // Inv Amount 
						   strPenaltyAmt		 = ws.getString(6);   // Discount Amt	
						   strAmtAfterDedduct    = ws.getString(23);  // Amt Aftre Deduction
						   strInvTaxAmt          = ws.getString(22);  // TAx Amt
						   
						   strPoNetAmt           = ws.getString(15);
						   strSuppAmtTillPayment = ws.getString(16);
						   
						  	
								
						   invAmount = new BigDecimal(strInvAmt);
									
						   totalInvAmount = totalInvAmount.add(invAmount);
						   
						   
						   taxAmount = new BigDecimal(strInvTaxAmt);
							
						   totalTaxAmount = totalTaxAmount.add(taxAmount);
						   
						   
						   penalty = new BigDecimal(strPenaltyAmt);
							
						   totalPenalty = totalPenalty.add(penalty);
						   
						   
						   
						   calInvamount = new BigDecimal(strAmtAfterDedduct);
							
						   totalCalInvAmount = totalCalInvAmount.add(calInvamount);
								    
									
								
						}
						
						ws.beforeFirst();
						
						while (ws.next()) 
						{	
							strPOStoreName		  = ws.getString(1);
							strPONODate			  = ws.getString(2);
							strInvoiceNoDate	  = ws.getString(3);
							strSuppName			  = ws.getString(4);
							strInvAmt			  = ws.getString(5);
							strPenaltyAmt		  = ws.getString(6);
							
							strPaymentStatus	  = ws.getString(8);
							strBillType			  = ws.getString(9);
							strInvAppBy			  = ws.getString(10);
							strInvAppDate   	  = ws.getString(11);
							strInvoiceSaveBy	  = ws.getString(12);
							strPaymenStatusCode	  = ws.getString(13);							
							strUtrNo              = ws.getString(14);
							strPoNetAmt           = ws.getString(15);
							strSuppAmtTillPayment = ws.getString(16);
							strCatgCode	  		  = ws.getString(17);
							strRemarks            = ws.getString(18);
							strStoreId			  = ws.getString(19);
							strSupplierId  	      = ws.getString(20);
							strInvoiceStatus	  = ws.getString(21);
							strInvTaxAmt          = ws.getString(22);
							strAmtAfterDedduct    = ws.getString(23);
							
							if (count == 0) 
							{
								strGroupByValue = strPONODate.trim()+"/"+strSuppName.trim();
								
								sb.append("<tr>");
								sb.append("<td  style='text-align:left;' colspan='8'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>PO Dtl / Supplier Name ::<b>"
										).append( strGroupByValue ).append("</u></b></font></td>");
								
								sb.append("</tr>");
								sb.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");
							}
							
							if (strGroupByValue.equals(strPONODate.trim()+"/"+strSuppName.trim())) 
							{
								
								sb.append("<tr> ");
								sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(i);
								sb.append("</font></td> ");	
							
								sb.append("<td align='left' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strInvoiceNoDate);
								sb.append("</font></td> ");					
								
								sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strBillType);
								sb.append("</font></td> ");	
								
								sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strInvAppBy+"<br>"+strInvAppDate+"<br>User:"+strInvoiceSaveBy);
								sb.append("</font></td> ");	
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strInvAmt);
								sb.append("</font></td> ");
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strInvTaxAmt);
								sb.append("</font></td> ");	
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strPenaltyAmt);
								sb.append("</font></td> ");					
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strAmtAfterDedduct);
								sb.append("</font></td> ");																
								sb.append("</tr> ");	
								
							}else 
							{
								strGroupByValue = strPONODate.trim()+"/"+strSuppName.trim();
								
	
								sb.append("<tr>");
								sb.append("<td  style='text-align:left;' colspan='8'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>PO Dtl / Supplier Name ::<b><u>"
										).append( strGroupByValue ).append( "</u></b></font></td>");
								
								sb.append("</tr>");
								
								sb.append("<tr> ");
								sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(i);
								sb.append("</font></td> ");	
							
								sb.append("<td align='left' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strInvoiceNoDate);
								sb.append("</font></td> ");					
								
								sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strBillType);
								sb.append("</font></td> ");	
								
								sb.append("<td align='left' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strInvAppBy+"<br>"+strInvAppDate+"<br>User:"+strInvoiceSaveBy);
								sb.append("</font></td> ");	
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strInvAmt);
								sb.append("</font></td> ");
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strInvTaxAmt);
								sb.append("</font></td> ");	
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strPenaltyAmt);
								sb.append("</font></td> ");					
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strAmtAfterDedduct);
								sb.append("</font></td> ");																
								sb.append("</tr> ");	
							}
							
							
																		
							
							i++;
							count++;					
							
		
						}
						sb.append("<tr><td width='100%' colspan='8'><hr></td></tr> ");
						sb.append("<tr> ");
						
						sb.append("<tr> ");
						sb.append("<td align='right'  colspan='4'><b>Total :: </b></font></td>");
						sb.append("<td align='right'  colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+totalInvAmount+"</b></font></td>");
						sb.append("<td align='right'  colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+totalTaxAmount+"</b></font></td>");
						sb.append("<td align='right'  colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+totalPenalty+"</b></font></td>");
						sb.append("<td align='right'  colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+totalCalInvAmount+"</b></font></td>");
						
						sb.append("<input type='hidden' name='strTotRegInvAmt'      id='strTotRegInvAmt'       value='"+totalInvAmount+"'/>");
						sb.append("<input type='hidden' name='strTotRegInvTaxAmt'   id='strTotRegInvTaxAmt'    value='"+totalTaxAmount+"'/>");
						sb.append("<input type='hidden' name='strTotRegInvWavAmt'   id='strTotRegInvWavAmt'    value='"+totalPenalty+"'/>");
						sb.append("<input type='hidden' name='strTotRegFinalInvAmt' id='strTotRegFinalInvAmt'  value='"+totalCalInvAmount+"'/>");
						
						sb.append("</tr> ");
										
						sb.append("<tr><td width='100%' colspan='8'><hr></td></tr> ");					
										
				}				
				else 
				{
					sb.append("<tr><td width='100%' colspan='8'><hr></td></tr> ");	
					sb.append("<tr> ");
					sb.append("<td align='center' 	width='2%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SNo</b></font>.</td>");
					sb.append("<td align='center' 	width='18%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice No/Date</b></font></td>");				
					sb.append("<td align='center' 	width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Bill Type</b></font></td>");
					sb.append("<td align='center' 	width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>[App By/Date]/User</b></font></td>");				
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice Amt<br> [A] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax Amt<br> [B] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Disc. Amt<br> [C] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Final Amt<br> [D=(A+B)-C]</b></font></td>");				
					sb.append("</tr> ");
					sb.append("<tr><td width='100%' colspan='8'><hr></td></tr> ");	
					sb.append("<tr> ");
					sb.append("<input type='hidden' name='strTotRegInvAmt'      id='strTotRegInvAmt'       value='0'/>");
					sb.append("<input type='hidden' name='strTotRegInvTaxAmt'   id='strTotRegInvTaxAmt'    value='0'/>");
					sb.append("<input type='hidden' name='strTotRegInvWavAmt'   id='strTotRegInvWavAmt'    value='0'/>");
					sb.append("<input type='hidden' name='strTotRegFinalInvAmt' id='strTotRegFinalInvAmt'  value='0'/>");
					sb.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice Details Not Available</b></font></td> ");
					sb.append("</tr> ");
	
				}
	
				sb.append("</table> ");
				//System.out.println("printItemDetails in hlp: "+sb.toString());
	
			} catch (Exception e) {
	
				e.printStackTrace();
	
				throw e;
			}
			finally {
				
			}
			
			return sb.toString();
		}
		
		public static String getRegisteredPaymentDetails(WebRowSet ws,String hosCode) throws Exception 
		{
	
			System.out.println("--------------------- LocalPurchaseNewTransHLP.getRegisteredPaymentDetails -------------------------------");
			StringBuffer sb = new StringBuffer("");
			String strMrnNo = "" , storeName = "",uc_req="",cat="";
			String strMrnDate = "";
			String strPONo="";
			String strPODate="";
			String strVendor="",strdcno="";
			String strItem="";
			String strSup="",strRej="",strRcd="";
			String strAmount="0.00";
			double tot = 0.000,tmpRcd=0.0;
			String strOrderQty="";
			String strPOStoreName		  ="";
			String strPONODate			  ="";
			String strInvoiceNoDate	  	  ="";
			String strSuppName			  ="";
			String strOrgInvAmt			  ="";
			String strPayInvAmt			  ="";
			String strPayTaxAmt			  ="";
			String strPayDiscAmt		  ="";
			String strFinalPayAmt		  ="";
			String strInvRemainAmt		  ="";
			String strPaymentStatus	      ="";
			String strInvAppBy			  ="";
			String strGroupByValue        ="";
			
			int i=1,count=0;
			
			BigDecimal         totalOrgInvAmount = new BigDecimal(BigInteger.ZERO,  2);
			BigDecimal              orgInvAmount = new BigDecimal(BigInteger.ZERO,  2);
	
			
			BigDecimal         totalPayInvAmount = new BigDecimal(BigInteger.ZERO,  2);
			BigDecimal              payInvAmount = new BigDecimal(BigInteger.ZERO,  2);
			
			BigDecimal         totalPayTaxAmount = new BigDecimal(BigInteger.ZERO,  2);
			BigDecimal              payTaxAmount = new BigDecimal(BigInteger.ZERO,  2);
			
			BigDecimal          totalPayDiscount = new BigDecimal(BigInteger.ZERO,  2);
			BigDecimal               payDiscount = new BigDecimal(BigInteger.ZERO,  2);		
			
			BigDecimal       totalFinalPayAmount = new BigDecimal(BigInteger.ZERO,  2);
			BigDecimal            finalPayAmount = new BigDecimal(BigInteger.ZERO,  2);
			
			BigDecimal         totalInvRemainAmt = new BigDecimal(BigInteger.ZERO,  2);
			BigDecimal              invRemainAmt = new BigDecimal(BigInteger.ZERO,  2);
			
	
			try 
			{
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px' > ");
				if(ws != null && ws.size() > 0)
				{
					sb.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");												
					sb.append("<tr> ");
					sb.append("<td align='center' 	width='4%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SNo</b></font>.</td>");	
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif'><b>Status</b></font>.</td>");
					sb.append("<td align='center' 	width='16%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice No/Date</b></font></td>");				
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Org Invoice Amt<br> [A] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pay Invoice Amt<br> [B] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pay Tax Amt<br> [C] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pay Disc.Amt<br> [D] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Final Pay Amt<br> [E=(B+C)-D]</b></font></td>");	
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Left Amt<br> [A-E]</b></font></td>");				
					sb.append("</tr> ");
					sb.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");
					
					 1.PO_NO
					 2.Inv No/ Date
					 3.Supp Name
					 4.Org Inv Amount
					 5.PAY_Amount
					 6.PAY_TAX
					 7.PAY_DISC
					 8.Final PAY 
					 9.Payment Status
					10.Bill Type
					11.User Name
					12.Payment No
					13.Serial No
					14.Remarks
					15.Remain_Pay_Amount 
					
						while (ws.next()) 
						{
								
								
							strOrgInvAmt	 = ws.getString(4);   
							strPayInvAmt	 = ws.getString(5);   
							strPayTaxAmt     = ws.getString(6);  
							strPayDiscAmt    = ws.getString(7); 
							strFinalPayAmt   = ws.getString(8);
							strInvRemainAmt  = ws.getString(15);
	
						   orgInvAmount = new BigDecimal(strOrgInvAmt);
								
						   totalOrgInvAmount = totalOrgInvAmount.add(orgInvAmount);
						   
						
						   payInvAmount = new BigDecimal(strPayInvAmt);
									
						   totalPayInvAmount = totalPayInvAmount.add(payInvAmount);
						   
						   
						   payTaxAmount = new BigDecimal(strPayTaxAmt);
							
						   totalPayTaxAmount = totalPayTaxAmount.add(payTaxAmount);
						   
						   
						   payDiscount = new BigDecimal(strPayDiscAmt);
							
						   totalPayDiscount = totalPayDiscount.add(payDiscount);				   
						   
						   
						   finalPayAmount = new BigDecimal(strFinalPayAmt);
							
						   totalFinalPayAmount = totalFinalPayAmount.add(finalPayAmount);
						   
						   
						   invRemainAmt = new BigDecimal(strInvRemainAmt);
							
						   totalInvRemainAmt = totalInvRemainAmt.add(invRemainAmt);
								    
									
								
						}
						
						ws.beforeFirst();
						
						while (ws.next()) 
						{	
							
							 1.PO_NO
							 2.Inv No/ Date
							 3.Supp Name
							 4.Org Inv Amount
							 5.PAY_Amount
							 6.PAY_TAX
							 7.PAY_DISC
							 8.Final PAY 
							 9.Payment Status
							10.Bill Type
							11.User Name
							12.Payment No
							13.Serial No
							14.Remarks
							15.Remain_Pay_Amount 
							
	
							strPONODate			  = ws.getString(1);
							strInvoiceNoDate	  = ws.getString(2);
							strSuppName			  = ws.getString(3);
							strOrgInvAmt	 	  = ws.getString(4);   
							strPayInvAmt	      = ws.getString(5);   
							strPayTaxAmt          = ws.getString(6);  
							strPayDiscAmt         = ws.getString(7); 
							strFinalPayAmt        = ws.getString(8);
							strPaymentStatus	  = ws.getString(9);
							strInvAppBy			  = ws.getString(11);						
							strInvRemainAmt       = ws.getString(15);
							
							
							
							if (count == 0) 
							{
								strGroupByValue = strPONODate.trim()+"/"+strSuppName.trim();
								
								sb.append("<tr>");
								sb.append("<td  style='text-align:left;' colspan='9'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b><u>PO Dtl / Supplier Name ::<b>"
										).append( strGroupByValue ).append("</u></b></font></td>");
								
								sb.append("</tr>");
								sb.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");
							}
							
							if (strGroupByValue.equals(strPONODate.trim()+"/"+strSuppName.trim())) 
							{
								strPONODate			  = ws.getString(1);
								strInvoiceNoDate	  = ws.getString(2);
								strSuppName			  = ws.getString(3);
								strOrgInvAmt	 	  = ws.getString(4);   
								strPayInvAmt	      = ws.getString(5);   
								strPayTaxAmt          = ws.getString(6);  
								strPayDiscAmt         = ws.getString(7); 
								strFinalPayAmt        = ws.getString(8);
								strPaymentStatus	  = ws.getString(9);
								strInvAppBy			  = ws.getString(11);						
								strInvRemainAmt       = ws.getString(15);
							
								sb.append("<tr> ");
								sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(i);
								sb.append("</font></td> ");
								
								sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strPaymentStatus);
								sb.append("</font></td> ");	
								
								sb.append("<td align='left' width='16%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strInvoiceNoDate+"<br> User "+strInvAppBy);
								sb.append("</font></td> ");	
															
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strOrgInvAmt);
								sb.append("</font></td> ");	
								
														
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strPayInvAmt);
								sb.append("</font></td> ");	
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strPayTaxAmt);
								sb.append("</font></td> ");	
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strPayDiscAmt);
								sb.append("</font></td> ");	
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strFinalPayAmt);
								sb.append("</font></td> ");	
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strInvRemainAmt);
								sb.append("</font></td> ");	
								
								sb.append("</tr> ");
								
							}else 
							{
								strGroupByValue = strPONODate.trim()+"/"+strSuppName.trim();
								
	
								sb.append("<tr> ");
								sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(i);
								sb.append("</font></td> ");
								
								sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strPaymentStatus);
								sb.append("</font></td> ");	
								
								sb.append("<td align='left' width='16%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strInvoiceNoDate+"<br> User "+strInvAppBy);
								sb.append("</font></td> ");	
															
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strOrgInvAmt);
								sb.append("</font></td> ");	
								
														
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strPayInvAmt);
								sb.append("</font></td> ");	
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strPayTaxAmt);
								sb.append("</font></td> ");	
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strPayDiscAmt);
								sb.append("</font></td> ");	
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strFinalPayAmt);
								sb.append("</font></td> ");	
								
								sb.append("<td align='right' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
								sb.append(strInvRemainAmt);
								sb.append("</font></td> ");	
								
								sb.append("</tr> ");			
							}
							
							
																		
							
							i++;
							count++;					
							
		
						}
						sb.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");
									
						sb.append("<tr> ");
						sb.append("<td align='right'  colspan='3'><b>Total :: </b></font></td>");
						sb.append("<td align='right'  colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+totalOrgInvAmount+"</b></font></td>");
						sb.append("<td align='right'  colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+totalPayInvAmount+"</b></font></td>");
						sb.append("<td align='right'  colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+totalPayTaxAmount+"</b></font></td>");
						sb.append("<td align='right'  colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+totalPayDiscount+"</b></font></td>");
						sb.append("<td align='right'  colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+totalFinalPayAmount+"</b></font></td>");
						sb.append("<td align='right'  colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+totalInvRemainAmt+"</b></font></td>");
						
						sb.append("<input type='hidden' name='strTotOrgInvAmt'      id='strTotOrgInvAmt'      	value='"+totalOrgInvAmount+"'/>");
						sb.append("<input type='hidden' name='strTotPayInvAmt'      id='strTotPayInvAmt'    	value='"+totalPayInvAmount+"'/>");
						sb.append("<input type='hidden' name='strTotPayTaxAmt'      id='strTotPayTaxAmt'    	value='"+totalPayTaxAmount+"'/>");
						sb.append("<input type='hidden' name='strTotPayDiscAmt'     id='strTotPayDiscAmt'  		value='"+totalPayDiscount+"'/>");
						sb.append("<input type='hidden' name='strTotPayFinalAmt'    id='strTotPayFinalAmt'  	value='"+totalFinalPayAmount+"'/>");
						sb.append("<input type='hidden' name='strTotInvRemainAmt'   id='strTotInvRemainAmt'  	value='"+totalInvRemainAmt+"'/>");
						
						sb.append("</tr> ");
										
						sb.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");					
										
				}				
				else 
				{
					sb.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");	
					sb.append("<tr> ");
					sb.append("<td align='center' 	width='4%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SNo</b></font>.</td>");	
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Status</b></font>.</td>");
					sb.append("<td align='center' 	width='16%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice No/Date</b></font></td>");				
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Org Invoice Amt<br> [A] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Org Invoice Amt<br> [B] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Pay Tax Amt<br> [C] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Disc.Amt<br> [D] </b></font></td>");
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Final Pay Amt<br> [E=(B+C)-D]</b></font></td>");	
					sb.append("<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Left Amt<br> [A-E]</b></font></td>");				
					sb.append("</tr> ");
					sb.append("<tr><td width='100%' colspan='9'><hr></td></tr> ");	
					sb.append("<tr> ");
					sb.append("<td colspan='9' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice Payment Details Not Available</b></font></td> ");
					sb.append("</tr> ");
	
				}
	
				sb.append("</table> ");
				//System.out.println("printItemDetails in hlp: "+sb.toString());
	
			} catch (Exception e) {
	
				e.printStackTrace();
	
				throw e;
			}
			finally {
				
			}
			
			return sb.toString();
		}*/
	// BULK & LOCAL
	public static String getPrintItemDetails(WebRowSet ws, BillApprovalVerificationRptVO vo,
			BillApprovalVerificationRptFB fb, String hosCode) throws Exception {

		System.out.println(
				"--------------------- LocalPurchaseNewTransHLP.getPrintItemDetails -------------------------------");
		StringBuffer sb = new StringBuffer("");
		String strMrnNo = "", storeName = "", uc_req = "", cat = "";
		String strMrnDate = "";
		String strPONo = "";
		String strPODate = "";
		String strVendor = "", strdcno = "";
		String strItem = "";
		String strSup = "", strRej = "", strRcd = "";
		String strAmount = "0.00";
		double tot = 0.000, tmpRcd = 0.0;
		String strOrderQty = "";
		String strExpiryDt = "", strbtch = "", costtopat = "", admchg = "", strmrp = "", strPurRate = "", strUser = "",
				strRemarks = "", strBrandId = "", tmpId = "0", strBal = "", stritemTax = "", strRateWithTax = "",
				manuf = "";

		int i = 1;
		double totamt = 0.00;

		BigDecimal totalAmount = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal amount = new BigDecimal(BigInteger.ZERO, 2);

		try {
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px'> ");
			if (ws != null && ws.size() > 0) {
				ws.next();
				strMrnNo = ws.getString("mrn_no");
				strMrnDate = ws.getString("challan_dt");
				strPONo = ws.getString("po_no");
				strPODate = ws.getString("po_date");
				strVendor = ws.getString("supp_info");
				strdcno = ws.getString("dc_no");
				strUser = ws.getString("usr");
				storeName = ws.getString("store");

				sb.append(
						"<div id='printRptId' align='right'><img style='cursor: pointer; margin-right :10px;' text-align=right title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printReport();' /><img style='cursor: pointer;' text-align=right title='Print Page' src='../../hisglobal/images/stop.png' onClick='controlToMainPage();' /></div></td>");
				sb.append("<div class='d-flex justify-content-center align-items-center'>"
						// + " <div align='center'><img src='/INVMGM/hisglobal/images/" +
						// vo.getStrLogoName() + "'></div></div>"
						+ " <div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></div>");

				sb.append(
						"<tr><td colspan='12' align='center' style='font-size:18px;font-weight:normal;font face:Verdana, Arial, Helvetica, sans-serif'>"
								+ "Bill Approval Verification Report</td></tr>");

				sb.append("<tr>" + "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Report Date & Time  ::<b>"
						+ fb.getStrCurrentDate() + "</b></font></td></tr>");

				sb.append(" <tr><td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "From Date ::<b>"
						+ vo.getStrFinancialStartYear() + "</b> To Date ::<b>" + vo.getStrFinancialEndYear()
						+ "</b></font></td>" + "<td align='center' colspan='2'>"
						+ "<div id='printid1' class='hidecontrol' style='float:right'>" + "</td></tr>");

				sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");
				sb.append("<tr> ");
				sb.append(
						"<td align='center'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.NO.</b></font></td>");
				sb.append(
						"<td align='center'  colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>ITEM DESCRIPTION</b></font></td>");
				sb.append(
						"<td align='center'  colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>QUANTITY</b></font></td>");
				sb.append(
						"<td align='center'  colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>AMOUNT</b></font></td>");
				sb.append(
						"<td align='right'   colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");
				sb.append("<tr> ");
				sb.append("<td align='center' 	width='2%'>#</td>");
				sb.append(
						"<td align='left' 	width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN No/Date</b></font></td>");
				sb.append(
						"<td align='left' 	width='24%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Brand</b></font></td>");
				sb.append(
						"<td align='left' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
				sb.append(
						"<td align='left' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Dt</b></font></td>");
				sb.append(
						"<td align='left' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax</b></font></td>");
				sb.append(
						"<td align='left' 	width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur. Rate</b></font></td>");
				sb.append(
						"<td align='center' 	width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur.Rate(With Tax)</b></font></td>");
				sb.append(
						"<td align='center'   width='4%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Ord</b></font></td>");
				sb.append(
						"<td align='center' 	width='4%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Rcd</b></font></td>");
				sb.append(
						"<td align='center'   width='4%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Bal</b></font></td>");
				sb.append(
						"<td align='center' 	width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>#</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");

				ws.beforeFirst();

				while (ws.next()) {
					strItem = ws.getString("item");
					strSup = ws.getString("sup_qty");
					strRej = ws.getString("rej_qty");
					strRcd = ws.getString("rcd_qty");
					strAmount = ws.getString("rate");
					strOrderQty = ws.getString("po_qty");
					strmrp = ws.getString("mrp");
					strExpiryDt = ws.getString("exp_dt");
					strbtch = ws.getString("btch");
					strPurRate = ws.getString("pur_rate");
					strBrandId = ws.getString("id");
					strBal = ws.getString("bal_qty");
					stritemTax = ws.getString("item_tax");
					// costtopat = ws.getString("costtopat");
					// admchg = ws.getString("admchg");

					strMrnNo = ws.getString("mrn_no");
					strMrnDate = ws.getString("challan_dt");
					strPONo = ws.getString("po_no");
					strPODate = ws.getString("po_date");
					strVendor = ws.getString("supp_info");
					strdcno = ws.getString("dc_no");
					strUser = ws.getString("usr");
					storeName = ws.getString("store");
					// uc_req = ws.getString("uc_req");
					// cat = ws.getString("cat");
					// strRemarks = ws.getString("remarks");

					// if(Double.parseDouble(admchg)>1000)
					// admchg = Double.toString(1000.0);
					strRateWithTax = ws.getString("RATE_WITH_TAX");
					manuf = ws.getString("manuf");

					/*
					 *  1.Store Name
					 *  2.MRN_NO
					 *  3.Challan_date
					 *  4.PO_No
					 *  5.PO_DATE
					 *  6.Item Name
					 *  7.Supplier Name
					 *  8.Supply Qty
					 *  9.Rejected Qty
					 * 10.Rec Qty
					 * 11.Cost Wth Tax
					 * 12. hstnum_dc_no||'#'||TO_CHAR(hstnum_challan_date  
					 * 13.PO Qty
					 * 14.Rate Wth Tax
					 * 15.Exp Date
					 * 16.Batch
					 * 17.Rate Without Tax
					 * 18.Gen By User name
					 * 19.hstnum_itembrand_id
					 * 20.Balance Qty
					 * 21.DL_NO
					 * 22.Tax
					 * 23.Rate Wth tax
					 * 24.Mfg Name
					 * */

					sb.append("<tr> ");
					sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");

					sb.append("<td align='left' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strMrnNo + "<br>" + strMrnDate);
					sb.append("</font></td> ");

					sb.append("<td align='left' width='24%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strItem);
					sb.append("</font></td> ");

					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strbtch);
					sb.append("</font></td> ");
					sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strExpiryDt);
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

					sb.append("<td align='center' width='6%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strOrderQty);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='6%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strRcd);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='6%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strBal);
					sb.append("</font></td> ");

					BigDecimal totalCost = new BigDecimal(strRateWithTax).multiply(new BigDecimal(strRcd));

					sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");

					sb.append(ws.getString(11));
					sb.append("</font></td>");
					sb.append("</tr> ");
					totamt = totamt + Double.parseDouble(ws.getString(11));

					i++;

					tmpId = strBrandId;

				}
				sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");
				sb.append("<tr> ");

				sb.append("<tr> ");
				sb.append("<td align='right'  colspan='10'><b>Total :: </b></font></td>");
				sb.append("<td align='right'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ totamt + "</b></font></td>");
				sb.append("</tr> ");

				sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");

				// sb.append("</table>");

			}

			else {

				sb.append("<tr> ");
				sb.append(
						"<td colspan='12' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");
			// System.out.println("printItemDetails in hlp: "+sb.toString());

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		} finally {

		}

		return sb.toString();
	}

	// SUPPLIER
	public static String getSuppPrintItemDetails_NEW(WebRowSet ws, BillApprovalVerificationRptVO vo,
			BillApprovalVerificationRptFB fb, String hosCode) throws Exception {

		System.out.println(
				"--------------------- LocalPurchaseNewTransHLP.getSuppPrintItemDetails_NEW -------------------------------");
		StringBuffer sb = new StringBuffer("");
		String strMrnNo = "", storeName = "", uc_req = "", cat = "";
		String strMrnDate = "";
		String strPONo = "";
		String strPODate = "";
		String strVendor = "", strdcno = "";
		String strItem = "";
		String strSup = "", strRej = "", strRcd = "";
		String strAmount = "0.00";
		double tot = 0.000, tmpRcd = 0.0;
		String strOrderQty = "";
		String strExpiryDt = "", strbtch = "", costtopat = "", admchg = "", strmrp = "", strPurRate = "", strUser = "",
				strRemarks = "", strBrandId = "", tmpId = "0", strBal = "", stritemTax = "", strRateWithTax = "",
				manuf = "";

		String rate = "";
		String tax = "";
		String admnChg = "";
		String admnAmt = "";
		String salePrice = "";
		String mrp = "";
		String poNODate = "";
		String pKey = "";
		String concatPKey = "";

		int i = 1;
		double totamt = 0.00;

		BigDecimal totalAmount = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal amount = new BigDecimal(BigInteger.ZERO, 2);
		NumberFormat formatter = new DecimalFormat("############.##");

		try {
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px'> ");
			if (ws != null && ws.size() > 0) {
				ws.next();
				strMrnNo = ws.getString("mrn_no");
				strMrnDate = ws.getString("challan_dt");
				strPONo = ws.getString("po_no");
				strPODate = ws.getString("po_date");
				strVendor = ws.getString("supp_info");
				strdcno = ws.getString("dc_no");
				strUser = ws.getString("usr");
				storeName = ws.getString("store");
				poNODate = ws.getString(32);

				sb.append(
						"<div id='printRptId' align='right'><img style='cursor: pointer; margin-right :10px;' text-align=right title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printReport();' /><img style='cursor: pointer;' text-align=right title='Print Page' src='../../hisglobal/images/stop.png' onClick='controlToMainPage();' /></div></td>");
				sb.append("<div class='d-flex justify-content-center align-items-center'>"
						// + " <div align='center'><img src='/INVMGM/hisglobal/images/" +
						// vo.getStrLogoName() + "'></div></div>"
						+ " <div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></div>");

				sb.append(
						"<tr><td colspan='12' align='center' style='font-size:18px;font-weight:normal;font face:Verdana, Arial, Helvetica, sans-serif'>"
								+ "Bill Approval Verification Report</td></tr>");

				sb.append("<tr>" + "<td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "Report Date & Time  ::<b>"
						+ fb.getStrCurrentDate() + "</b></font></td></tr>");

				sb.append(" <tr><td align='center' colspan='12'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" + "From Date ::<b>"
						+ vo.getStrFinancialStartYear() + "</b> To Date ::<b>" + vo.getStrFinancialEndYear()
						+ "</b></font></td>" + "<td align='center' colspan='2'>"
						+ "<div id='printid1' class='hidecontrol' style='float:right'>" + "</td></tr>");

				sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");
				sb.append("<tr> ");
				sb.append(
						"<td align='center'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.NO.</b></font></td>");
				sb.append(
						"<td align='center'  colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>ITEM DESCRIPTION</b></font></td>");
				sb.append(
						"<td align='center'  colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>QUANTITY</b></font></td>");
				sb.append(
						"<td align='center'  colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>AMOUNT</b></font></td>");
				sb.append(
						"<td align='right'   colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");
				sb.append("<tr> ");
				sb.append("<td align='center' 	width='5%'>#</td>");
				sb.append(
						"<td align='center' 	width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN No/Date</b></font></td>");
				sb.append(
						"<td align='center' 	width='24%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Brand</b></font></td>");
				sb.append(
						"<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
				sb.append(
						"<td align='center' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Dt</b></font></td>");
				sb.append(
						"<td align='center' 	width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate</b></font></td>");
				sb.append(
						"<td align='center' 	width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax</b></font></td>");
				sb.append(
						"<td align='center' 	width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate<br>(With Tax)</b></font></td>");
				sb.append(
						"<td align='center'   width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Admn Chg</b></font></td>");
				sb.append(
						"<td align='center' 	width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Sale Price</b></font></td>");
				sb.append(
						"<td align='center'   width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty</b></font></td>");
				sb.append(
						"<td align='center' 	width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Value</b></font></td>");
				sb.append("</tr> ");
				sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");
				sb.append(
						"<tr><td width='100%' colspan='12' align='left' ><font face='Verdana, Arial, Helvetica, sans-serif' size='1'><u><b>PO Dtl / Supplier Name ::"
								+ poNODate + "/" + strVendor + "</b></u></font></td></tr> ");
				sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");

				ws.beforeFirst();

				while (ws.next()) {
					strItem = ws.getString("item");
					strSup = ws.getString("sup_qty");
					strRej = ws.getString("rej_qty");
					strRcd = ws.getString("rcd_qty");
					strAmount = ws.getString("rate");
					strOrderQty = ws.getString("po_qty");
					strmrp = ws.getString("mrp");
					strExpiryDt = ws.getString("exp_dt");
					strbtch = ws.getString("btch");
					strPurRate = ws.getString("pur_rate");
					strBrandId = ws.getString("id");
					strBal = ws.getString("bal_qty");
					stritemTax = ws.getString("item_tax");
					// costtopat = ws.getString("costtopat");
					// admchg = ws.getString("admchg");

					strMrnNo = ws.getString("mrn_no");
					strMrnDate = ws.getString("challan_dt");
					strPONo = ws.getString("po_no");
					strPODate = ws.getString("po_date");
					strVendor = ws.getString("supp_info");
					strdcno = ws.getString("dc_no");
					strUser = ws.getString("usr");
					storeName = ws.getString("store");
					manuf = ws.getString("manuf");

					rate = ws.getString(25);
					tax = ws.getString(26);
					strRateWithTax = ws.getString(27);
					admnChg = ws.getString(28);
					admnAmt = ws.getString(29);
					salePrice = ws.getString(30);
					mrp = ws.getString(31);
					pKey = ws.getString(35);
					/*
					hstnum_supp_lp_no||''#''||hstnum_store_id||''#''||hstnum_lp_qty   AS P_KEY 
					*/

					/*
					 *  1.Store Name
					 *  2.MRN_NO
					 *  3.Challan_date
					 *  4.PO_No
					 *  5.PO_DATE
					 *  6.Item Name
					 *  7.Supplier Name
					 *  8.Supply Qty
					 *  9.Rejected Qty
					 * 10.Rec Qty
					 * 11.Cost Wth Tax
					 * 12. hstnum_dc_no||'#'||TO_CHAR(hstnum_challan_date  
					 * 13.PO Qty
					 * 14.Rate Wth Tax
					 * 15.Exp Date
					 * 16.Batch
					 * 17.Rate Without Tax
					 * 18.Gen By User name
					 * 19.hstnum_itembrand_id
					 * 20.Balance Qty
					 * 21.DL_NO
					 * 22.Tax
					 * 23.Rate Wth tax
					 * 24.Mfg Name
					 * 25.hstnum_rate
					 * 26.hstnum_tax, 
					 * 27.ROUND ((  hstnum_rate + (  HSTNUM_RATE *  HSTNUM_TAX ) / 100),2) AS rate_with_tax
					 * 28.hstnum_administrative_charges
					 * 29.round( NVL(hstnum_administrative_charges ,0) * round(round(((hstnum_rate*hstnum_tax) /100+hstnum_rate),3) ,3 ) /100 ,3)AS ADMN_AMT
					 * 30.hstnum_saleprice
					 * 31.hstnum_mrp
					 * 32.hststr_po_no||'' [ ''||to_char(hstdt_podate,''dd-Mon-yyyy'')||'' ] ''
					 * 33.''Ack By : ''||mms_mst.get_user_name (gnum_hospital_code,hstnum_ack_by)	
					 * 34.round((ROUND ((  hstnum_rate + (  HSTNUM_RATE *  HSTNUM_TAX ) / 100),3)*hstnum_lp_qty) ,2) - Value	
					 * 35. PKEY	hstnum_supp_lp_no||''#''||hstnum_store_id||''#''||hstnum_lp_qty
					 * */
					if (i == 1) {
						concatPKey = pKey;
					} else {
						concatPKey = concatPKey + "$" + pKey;
					}

					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");

					sb.append("<td align='left' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strMrnNo + "<br>" + strMrnDate);
					sb.append("</font></td> ");

					sb.append("<td align='left' width='24%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strItem);
					sb.append("</font></td> ");

					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strbtch);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strExpiryDt);
					sb.append("</font></td> ");

					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(rate);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(tax);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strRateWithTax);
					sb.append("</font></td> ");

					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(admnChg);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(salePrice);
					sb.append("</font></td> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strRcd);
					sb.append("</font></td> ");

					sb.append("<td align='right' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(34));
					sb.append("</font></td>");
					sb.append("</tr> ");
					totamt = totamt + Double.parseDouble(ws.getString(34));

					i++;

					tmpId = strBrandId;

				}

				String FinaltotalCost = formatter.format(new BigDecimal(totamt));

				sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");
				sb.append("<tr> ");
				sb.append("<td align='right'  colspan='11'><b>Total :: </b></font></td>");
				sb.append("<td align='right'  colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"
						+ FinaltotalCost + "</b></font></td>");
				sb.append("</tr> ");
				sb.append("<input type='hidden' name='strPONetCost'   id='strPONetCost'  value='" + FinaltotalCost
						+ "' />");
				sb.append(
						"<input type='hidden' name='strConcatPKey'  id='strConcatPKey' value='" + concatPKey + "' />");

				sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");

				// sb.append("</table>");

			}

			else {

				sb.append("<tr> ");
				sb.append(
						"<td colspan='12' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");
			// System.out.println("printItemDetails in hlp: "+sb.toString());

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		} finally {

		}

		return sb.toString();
	}

	/*	public static String getPrintItemDetails(WebRowSet ws, String hosCode) throws Exception {
	
			System.out.println(
					"--------------------- LocalPurchaseNewTransHLP.getPrintItemDetails -------------------------------");
			StringBuffer sb = new StringBuffer("");
			String strMrnNo = "", storeName = "", uc_req = "", cat = "";
			String strMrnDate = "";
			String strPONo = "";
			String strPODate = "";
			String strVendor = "", strdcno = "";
			String strItem = "";
			String strSup = "", strRej = "", strRcd = "";
			String strAmount = "0.00";
			double tot = 0.000, tmpRcd = 0.0;
			String strOrderQty = "";
			String strExpiryDt = "", strbtch = "", costtopat = "", admchg = "", strmrp = "", strPurRate = "", strUser = "",
					strRemarks = "", strBrandId = "", tmpId = "0", strBal = "", stritemTax = "", strRateWithTax = "",
					manuf = "";
	
			int i = 1;
			double totamt = 0.00;
	
			BigDecimal totalAmount = new BigDecimal(BigInteger.ZERO, 2);
			BigDecimal amount = new BigDecimal(BigInteger.ZERO, 2);
	
			try {
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='0px' cellpadding='1px'> ");
				if (ws != null && ws.size() > 0) {
					ws.next();
					strMrnNo = ws.getString("mrn_no");
					strMrnDate = ws.getString("challan_dt");
					strPONo = ws.getString("po_no");
					strPODate = ws.getString("po_date");
					strVendor = ws.getString("supp_info");
					strdcno = ws.getString("dc_no");
					strUser = ws.getString("usr");
					storeName = ws.getString("store");
	
					sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");
					sb.append("<tr> ");
					sb.append(
							"<td align='center'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.NO.</b></font></td>");
					sb.append(
							"<td align='center'  colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>ITEM DESCRIPTION</b></font></td>");
					sb.append(
							"<td align='center'  colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>QUANTITY</b></font></td>");
					sb.append(
							"<td align='center'  colspan='3'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>AMOUNT</b></font></td>");
					sb.append(
							"<td align='right'   colspan='1'><font face='Verdana, Arial, Helvetica, sans-serif' ></font></td>");
					sb.append("</tr> ");
					sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");
					sb.append("<tr> ");
					sb.append("<td align='center' 	width='2%'>#</td>");
					sb.append(
							"<td align='left' 	width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>MRN No/Date</b></font></td>");
					sb.append(
							"<td align='left' 	width='24%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Brand</b></font></td>");
					sb.append(
							"<td align='left' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
					sb.append(
							"<td align='left' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Dt</b></font></td>");
					sb.append(
							"<td align='left' 	width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax</b></font></td>");
					sb.append(
							"<td align='left' 	width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur. Rate</b></font></td>");
					sb.append(
							"<td align='center' 	width='5%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Pur.Rate(With Tax)</b></font></td>");
					sb.append(
							"<td align='center'   width='4%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Ord</b></font></td>");
					sb.append(
							"<td align='center' 	width='4%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Rcd</b></font></td>");
					sb.append(
							"<td align='center'   width='4%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>Bal</b></font></td>");
					sb.append(
							"<td align='center' 	width='7%'><font  face='Verdana, Arial, Helvetica, sans-serif' ><b>#</b></font></td>");
					sb.append("</tr> ");
					sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");
	
					ws.beforeFirst();
	
					while (ws.next()) {
						strItem = ws.getString("item");
						strSup = ws.getString("sup_qty");
						strRej = ws.getString("rej_qty");
						strRcd = ws.getString("rcd_qty");
						strAmount = ws.getString("rate");
						strOrderQty = ws.getString("po_qty");
						strmrp = ws.getString("mrp");
						strExpiryDt = ws.getString("exp_dt");
						strbtch = ws.getString("btch");
						strPurRate = ws.getString("pur_rate");
						strBrandId = ws.getString("id");
						strBal = ws.getString("bal_qty");
						stritemTax = ws.getString("item_tax");
						// costtopat = ws.getString("costtopat");
						// admchg = ws.getString("admchg");
	
						strMrnNo = ws.getString("mrn_no");
						strMrnDate = ws.getString("challan_dt");
						strPONo = ws.getString("po_no");
						strPODate = ws.getString("po_date");
						strVendor = ws.getString("supp_info");
						strdcno = ws.getString("dc_no");
						strUser = ws.getString("usr");
						storeName = ws.getString("store");
						// uc_req = ws.getString("uc_req");
						// cat = ws.getString("cat");
						// strRemarks = ws.getString("remarks");
	
						// if(Double.parseDouble(admchg)>1000)
						// admchg = Double.toString(1000.0);
						strRateWithTax = ws.getString("RATE_WITH_TAX");
						manuf = ws.getString("manuf");
	
						
						 *  1.Store Name
						 *  2.MRN_NO
						 *  3.Challan_date
						 *  4.PO_No
						 *  5.PO_DATE
						 *  6.Item Name
						 *  7.Supplier Name
						 *  8.Supply Qty
						 *  9.Rejected Qty
						 * 10.Rec Qty
						 * 11.Cost Wth Tax
						 * 12. hstnum_dc_no||'#'||TO_CHAR(hstnum_challan_date  
						 * 13.PO Qty
						 * 14.Rate Wth Tax
						 * 15.Exp Date
						 * 16.Batch
						 * 17.Rate Without Tax
						 * 18.Gen By User name
						 * 19.hstnum_itembrand_id
						 * 20.Balance Qty
						 * 21.DL_NO
						 * 22.Tax
						 * 23.Rate Wth tax
						 * 24.Mfg Name
						 * 
	
						sb.append("<tr> ");
						sb.append("<td align='center' width='2%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(i);
						sb.append("</font></td> ");
	
						sb.append("<td align='left' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strMrnNo + "<br>" + strMrnDate);
						sb.append("</font></td> ");
	
						sb.append("<td align='left' width='24%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strItem);
						sb.append("</font></td> ");
	
						sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strbtch);
						sb.append("</font></td> ");
						sb.append("<td align='left' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strExpiryDt);
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
	
						sb.append("<td align='center' width='6%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strOrderQty);
						sb.append("</font></td> ");
						sb.append("<td align='center' width='6%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strRcd);
						sb.append("</font></td> ");
						sb.append("<td align='center' width='6%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(strBal);
						sb.append("</font></td> ");
	
						BigDecimal totalCost = new BigDecimal(strRateWithTax).multiply(new BigDecimal(strRcd));
	
						sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
	
						sb.append(ws.getString(11));
						sb.append("</font></td>");
						sb.append("</tr> ");
						totamt = totamt + Double.parseDouble(ws.getString(11));
	
						i++;
	
						tmpId = strBrandId;
	
					}
					sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");
					sb.append("<tr> ");
	
					sb.append("<tr> ");
					sb.append("<td align='right'  colspan='10'><b>Total :: </b></font></td>");
					sb.append("<td align='right'  colspan='2'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"
							+ totamt + "</b></font></td>");
					sb.append("</tr> ");
	
					sb.append("<tr><td width='100%' colspan='12'><hr></td></tr> ");
	
					// sb.append("</table>");
	
				}
	
				else {
	
					sb.append("<tr> ");
					sb.append(
							"<td colspan='12' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
					sb.append("</tr> ");
	
				}
	
				sb.append("</table> ");
				// System.out.println("printItemDetails in hlp: "+sb.toString());
	
			} catch (Exception e) {
	
				e.printStackTrace();
	
				throw e;
			} finally {
	
			}
	
			return sb.toString();
		}
	
		public static String getScheduleDetails(BillApprovalTransVO vo) throws HisException {
			StringBuffer sBuffer = new StringBuffer("");
			WebRowSet wb = null;
			int count = 0;
			try {
				wb = vo.getStrScheduleDtlsWS();
				// System.out.println("ScheduleWsSize->"+wb.size());
				if (wb.size() != 0) {
					// wb.beforeFirst();
	
					// System.out.println("ScheduleWsSize->"+wb.size());
					sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black'>");
					sBuffer.append("<td width='5%' colspan='1' class='multiLabel'></td>");
					sBuffer.append(
							"<td width='20%' colspan='1' class='multiLabel'><div align='center'>Challan No.</div></td>");
					sBuffer.append(
							"<td width='20%' colspan='1' class='multiLabel'><div align='center'>Schedule No.</div></td>");
					sBuffer.append(
							"<td width='20%' colspan='1' class='multiLabel'><div align='center'>Schedule Date</div></td>");
					sBuffer.append(
							"<td width='10%' colspan='1' class='multiLabel'><div align='center'>Schedule Type</div></td>");
					sBuffer.append("<td width='10%' colspan='1' class='multiLabel'><div align='center'>#</div></td>");
					sBuffer.append("</tr>");
					while (wb.next()) {
						count++;
						String strScheduleNo = wb.getString(1);
						String strScheduleDate = wb.getString(2);
						// String strScheduleType = wb.getString(3);
						String strScheduleTypeName = wb.getString(4);
						String strPeneltyLateSchduleWise = wb.getString(5);
						String strPenltyRejejectedSchduleWise = wb.getString(6);
						String strChallanNo = wb.getString(7);
						// String strScheduleChk = strScheduleNo+"^"+strScheduleType;
						sBuffer.append("<tr>");
						sBuffer.append(
								"<td width='5%' colspan='1' class='multiControl'><input type='checkbox' name='strScheduleChk' value='"
										+ strScheduleNo + "'></td>");
						sBuffer.append("<td width='20%' colspan='1' class='multiControl'>" + strChallanNo + "</td>");
						sBuffer.append("<td width='20%' colspan='1' class='multiControl'>" + strScheduleNo + "</td>");
						sBuffer.append("<td width='20%' colspan='1' class='multiControl'>" + strScheduleDate + "</td>");
						sBuffer.append("<td width='10%' colspan='1' class='multiControl'>" + strScheduleTypeName);
						sBuffer.append("<input type='hidden' name='strPeneltyLateSchduleWise' value='"
								+ strPeneltyLateSchduleWise);
						sBuffer.append("' /><input type='hidden' name='strPenltyRejejectedSchduleWise' value='"
								+ strPenltyRejejectedSchduleWise + "' /></td>");
						sBuffer.append(
								"<td width='20%' colspan='1' class='multiControl'><img align='middle' name='compile' style='cursor: pointer; ' title='To click for Records' src='../../hisglobal/images/Compile.png' onclick='scheduleCheckCompile();'/></td>");
						sBuffer.append("</tr>");
					}
					// sBuffer.append("<tr><td class='multiControl' width='100%' colspan='5'><img
					// align='middle' name='compile' style='cursor: pointer; ' title='To click for
					// Records' src='../../hisglobal/images/Compile.png'
					// onclick='scheduleCheckCompile();'/></td></tr>");
	
					sBuffer.append("</table>");
				}
	
			} catch (Exception e) {
				new HisException("Bill Approval Transaction", "BillApprovalViewTransHLP.getScheduleDetails()-->",
						e.getMessage());
			}
			return sBuffer.toString();
		}
	
		public static String getScheduleItemDetails(BillApprovalTransVO vo) {
			StringBuffer sBuffer = new StringBuffer("");
			// int count=0;
			double strTotCost = 0;
			WebRowSet wb = null;
			BillApprovalTransBO bo = null;
			double strScheduleCost = 0;
			String scheduleBudget = "0.00";
			String Cost = "0.00";
			String selScheduleNo[] = null;
			try {
	
				bo = new BillApprovalTransBO();
				NumberFormat formatter = new DecimalFormat("############.##");
	
				selScheduleNo = vo.getStrSelScheduleNos().replace('^', '#').split("#");
	
				for (int i = 0, stopI = selScheduleNo.length; i < stopI; i++) {
					vo.setStrScheduleNo(selScheduleNo[i]);
					strScheduleCost = 0;
					bo.getScheduleItemDtls(vo);
					wb = vo.getStrScheduleItemDtlsWS();
					String scheduleSelPlusIdDIV = "scheduleSelPlusId" + i;
					String scheduleSelMinusIdDIV = "scheduleSelMinusId" + i;
					String selectedScheduleNoDIV = "selectedScheduleNoDIV" + i;
					wb.beforeFirst();
					sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
					sBuffer.append("<tr><td width='5%'class='TITLE' colspan='1'>");
					sBuffer.append("<div id='" + scheduleSelPlusIdDIV + "' align='center' style='display:none;'>");
					sBuffer.append(
							"<img src=\"../../hisglobal/images/plus.gif\" title='Show Details' onClick=\"view1('scheduleSelPlusId"
									+ i + "','scheduleSelMinusId" + i + "','selectedScheduleNoDIV" + i
									+ "');\" style='cursor: pointer; '/>");
					sBuffer.append("</div>");
					sBuffer.append("<div id='" + scheduleSelMinusIdDIV + "' style='display:block;' align='center'>");
					sBuffer.append(
							"<img src=\"../../hisglobal/images/minus.gif\" title='Close Details' onClick=\"view2('scheduleSelPlusId"
									+ i + "','scheduleSelMinusId" + i + "','selectedScheduleNoDIV" + i
									+ "');\"  style='cursor: pointer; '/></div></td>");
					sBuffer.append(
							"<td width='95%' class='TITLE' colspan='5' width='95%'> <div id='' style='color:blue;'>Schedule No :: "
									+ selScheduleNo[i] + "</div></td>");
					sBuffer.append("</tr></table>");
					sBuffer.append("<div id='" + selectedScheduleNoDIV + "'>");
					sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
					sBuffer.append(
							"<tr><td width='35%' colspan='2' class='multiLabel'><div align='center'>Item name</div></td>");
					sBuffer.append(
							"<td width='15%' colspan='1' class='multiLabel'><div align='center'>Rate/Unit</div></td>");
					sBuffer.append(
							"<td width='15%' colspan='1' class='multiLabel'><div align='center'>Accepted Qty</div></td>");
					sBuffer.append("<td width='15%' colspan='1' class='multiLabel'><div align='center'>Tax(%)</div></td>");
					sBuffer.append("<td width='20%' colspan='1' class='multiLabel'><div align='center'>Cost</div></td>");
					sBuffer.append("</tr>");
					while (wb.next()) {
						String strItemName = wb.getString(3);
						String strRateUnit = wb.getString(4) + "/" + wb.getString(6);
						String strAccQty = wb.getString(7) + " " + wb.getString(9);
						String strTax = wb.getString(10);
						double strCost = Double.parseDouble(wb.getString(11));
						Cost = formatter.format(new BigDecimal(strCost));
	
						sBuffer.append("<tr>");
						sBuffer.append("<td width='35%' colspan='2' class='multiControl'>" + strItemName + "</td>");
						sBuffer.append("<td width='15%' colspan='1' class='multiControl'>" + strRateUnit + "</td>");
						sBuffer.append("<td width='15%' colspan='1' class='multiControl'>" + strAccQty + "</td>");
						sBuffer.append("<td width='15%' colspan='1' class='multiControl'>" + strTax + "</td>");
						sBuffer.append("<td width='20%' colspan='1' class='multiControl'>" + Cost + "</td>");
						sBuffer.append("</tr>");
	
						strTotCost = strTotCost + strCost;
	
						strScheduleCost = strScheduleCost + strCost;
						scheduleBudget = formatter.format(new BigDecimal(strScheduleCost));
					}
					sBuffer.append("<input type='hidden' name='strScheduleNoArrH' id='strScheduleNo" + i + "' value='"
							+ selScheduleNo[i] + "'/>");
					sBuffer.append("<input type='hidden' name='strScheduleCostArrH' id='strScheduleCost" + i + "' value='"
							+ scheduleBudget + "'/>");
					sBuffer.append("</table></div>");
				}
				sBuffer.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				sBuffer.append("<td class='LABEL' colspan='4' width='80%'>Total Schedule Item Cost</td>");
				sBuffer.append(
						"<td class='CONTROL' colspan='1' width='20%'><div id='strTotalItemCostDIV' style='color: blue;font-weight:bold;align:center;'>"
								+ formatter.format(new BigDecimal(strTotCost))
								+ "</div><input type='hidden' name='strTotalItemCost' value='"
								+ formatter.format(new BigDecimal(strTotCost)) + "' /></td>");
				sBuffer.append("</table>");
	
				vo.setStrTotalItemCost(String.valueOf(formatter.format(new BigDecimal(strTotCost))));
	
			} catch (Exception e) {
				new HisException("Bill Approval Transaction", "BillApprovalTransHLP.getScheduleItemDetails()-->",
						e.getMessage());
			}
			return sBuffer.toString();
		}
	
		public static String getOtherDetails(BillApprovalTransVO vo, String strSuppliedItemCost, String strPOTotalCost)
				throws HisException {
			StringBuffer sb = new StringBuffer("");
			HisUtil util = null;
			BillApprovalTransBO bo = null;
			String waiveOffApprovedBy = "";
			try {
				util = new HisUtil("MMS", "Bill Approval Transaction");
				bo = new BillApprovalTransBO();
	
				float balAdvance = Float.parseFloat(vo.getStrAdvanceTaken()) - Float.parseFloat(vo.getStrAdvanceAdjusted());
				float penaltyImposed = Float.parseFloat(vo.getStrNetPenalty());
	
				bo.getWaiveOffApprovedBy(vo);
				waiveOffApprovedBy = util.getOptionValue(vo.getStrWaiveOffApprovedByWS(), "0", "0^Select Value", false);
	
				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				sb.append("<tr>");
				sb.append("<td class='TITLE'   colspan='4'>Waive Off Details</td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td class='LABEL'   colspan='1' width='25%'><font color='red'>*</font>Waive Off Amt.</td>");
				sb.append(
						"<td class='CONTROL' colspan='1' width='25%'><input type='text' name='strWaiveOffAmt' class='txtFldNormal' value='0' onKeyPress='return(numericWithTwoDecimalPlaces(this,',','.',event));' onKeyUp='calculateNetBillCost();'></td>");
				sb.append("<td class='LABEL'   colspan='1' width='25%'><font color='red'>*</font>Approved By</td>");
				sb.append("<td class='CONTROL' colspan='1' width='25%'><select name='strWaiveOffApprovedBy'>"
						+ waiveOffApprovedBy + "</select></td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td class='LABEL'   colspan='1' width='25%'><font color='red'>*</font>Approved Date</td>");
				sb.append("<td class='CONTROL' colspan='1' width='25%'>"
						+ getDatePicker("strWaiveOffApprovedDate", vo.getStrCurrentDate(), true) + "</td>");
				sb.append("<td class='LABEL'   colspan='1' width='25%'>PO Net Cost :</td>");
				sb.append("<td class='CONTROL' colspan='1' width='25%'><input type='hidden' name='strPONetCost'     value='"
						+ strPOTotalCost + "' /><input type='hidden' name='strSupplyNetCost' value='" + strSuppliedItemCost
						+ "' />     <div id='poNetCostDIV' style='color: red;font-weight:bold'>" + strPOTotalCost
						+ "</div></td>");
				sb.append("</tr>");
				
				sb.append("<tr>");
				sb.append("<td class='LABEL'   colspan='3' >Supply Cost : </td>");	       
				sb.append("<td class='CONTROL' colspan='1' ><input type='hidden' name='strSupplyNetCost' value='"+strSuppliedItemCost+"' /><div id='supplyNetCostDIV' style='color: red;font-weight:bold'>"+strSuppliedItemCost+"</div></td>");
				sb.append("</tr>");
				sb.append("<tr>");
				sb.append("<td class='LABEL'   colspan='3' >Balance Cost : </td>");      
				sb.append("<td class='CONTROL' colspan='1' ><input type='hidden' name='strBalanceNetCost'     value='"+(Double.parseDouble(strPOTotalCost) - Double.parseDouble(strSuppliedItemCost))+"' />     <div id='balanceNetCostDIV' style='color: red;font-weight:bold'>"+(Double.parseDouble(strPOTotalCost) - Double.parseDouble(strSuppliedItemCost))+"</div></td>");
				sb.append("</tr>");
				
				sb.append("</table>");
	
			} catch (Exception e) {
				new HisException("Bill Approval Transaction", "BillApprovalViewTransHLP.getReceiptDetails()-->",
						e.getMessage());
			}
			return sb.toString();
		}
	
		public static String getOtherDetails_New(BillApprovalTransVO vo) throws HisException {
			StringBuffer sb = new StringBuffer("");
			HisUtil util = null;
			BillApprovalTransBO bo = null;
			String waiveOffApprovedBy = "";
			try {
				util = new HisUtil("MMS", "Bill Approval Transaction");
				bo = new BillApprovalTransBO();
	
				bo.getWaiveOffApprovedBy(vo); // Pkg_Mms_View.Proc_Consultant_Name --[ Mode - 2 ]
				waiveOffApprovedBy = util.getOptionValue(vo.getStrWaiveOffApprovedByWS(), "0", "0^Select Value", false);
	
				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				sb.append("<tr>");
				sb.append("<td class='TITLE'   colspan='4'>Details</td>");
				sb.append("</tr>");
	
				sb.append("<tr>");
				sb.append("<td class='LABEL'   colspan='1' width='25%'><font color='red'>*</font>Approved Date</td>");
				sb.append("<td class='CONTROL' colspan='1' width='25%'>"
						+ getDatePicker("strWaiveOffApprovedDate", vo.getStrCurrentDate(), true) + "</td>");
				sb.append("<td class='LABEL'   colspan='1' width='25%'><font color='red'>*</font>Approved By</td>");
				sb.append("<td class='CONTROL' colspan='3' width='25%'><select name='strWaiveOffApprovedBy'>"
						+ waiveOffApprovedBy + "</select></td>");
	
				sb.append("</tr>");
				sb.append("</table>");
	
			} catch (Exception e) {
				new HisException("Bill Approval Transaction", "BillApprovalViewTransHLP.getReceiptDetails()-->",
						e.getMessage());
			}
			return sb.toString();
		}
	
		public static String getOtherDetails_ORG(BillApprovalTransVO vo) throws HisException {
			StringBuffer sb = new StringBuffer("");
			HisUtil util = null;
			BillApprovalTransBO bo = null;
			String waiveOffApprovedBy = "";
			try {
				util = new HisUtil("MMS", "Bill Approval Transaction");
				bo = new BillApprovalTransBO();
	
				// System.out.println("sizeApprovedBy->"+vo.getStrWaiveOffApprovedByWS().size());
	
				// float
				// overallTax=Float.parseFloat(vo.getStrTotalItemCost())*Float.parseFloat(vo.getStrOverallPOTax())/100;
				// float advanceTaken=Float.parseFloat(vo.getStrAdvanceTaken());
				// float advanceAdjusted=Float.parseFloat(vo.getStrAdvanceAdjusted());
				float balAdvance = Float.parseFloat(vo.getStrAdvanceTaken()) - Float.parseFloat(vo.getStrAdvanceAdjusted());
				float penaltyImposed = Float.parseFloat(vo.getStrNetPenalty());
	
				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				// sb.append("<tr><td class='TITLE' colspan='5'>Other Cost Details</td></tr>");
				sb.append("<tr><td class='LABEL' colspan='2' width='25%'>Overall Tax(<font color='blue'>"
						+ vo.getStrOverallPOTax() + "%</font>)<input type='hidden' name='strOverallPOTax' value='"
						+ vo.getStrOverallPOTax() + "' /></td>");
				sb.append("<td class='CONTROL' colspan='1' width='25%'><div id='overallTaxDIV'>0</div></td>");
				sb.append("<td class='LABEL' colspan='1' width='25%'>Balance Advance</td>");
				sb.append(
						"<td class='CONTROL' colspan='1' width='25%'><input type='hidden' name='strBalanceAdvance' value='"
								+ balAdvance
								+ "' /><a style='color: blue;cursor: pointer; ' onClick='openBalAdvanceDtl(this);'>"
								+ balAdvance + "</a></td></tr>");
				sb.append("<tr><td class='LABEL' colspan='2' width='25%'>Penalty Imposed</td>");
				sb.append("<td class='CONTROL' colspan='1' width='25%'><div id='peneltyDivId'>" + penaltyImposed
						+ "</div><input type='hidden' name='strNetPenalty' value='" + penaltyImposed + "'/></td>");
				// if(penaltyImposed>0)
				sb.append(
						"<td class='LABEL' colspan='1' width='25%' ><input type='checkbox' name='strWaiveOffChk' onClick='waiveOffdtl(this);'></td>");
				// else
				// sb.append("<td class='LABEL' colspan='1' width='25%' ><input type='checkbox'
				// name='strWaiveOffChk' disabled></td>");
				sb.append("<td class='CONTROL' colspan='1' width='25%'>Waive Off</td>");
				sb.append("</tr>");
				sb.append("</table>");
				// if(penaltyImposed>0)
				{
					bo.getWaiveOffApprovedBy(vo);
					waiveOffApprovedBy = util.getOptionValue(vo.getStrWaiveOffApprovedByWS(), "0", "0^Select Value", false);
					sb.append("<div id='waiveOffDtlDIV' style='display:none'>");
					sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
					sb.append("<tr><td class='TITLE' colspan='5'>Waive Off Details</td></tr>");
					sb.append(
							"<tr><td class='LABEL' colspan='2' width='25%'><font color='red'>*</font>Waive Off Amt.</td>");
					sb.append(
							"<td class='CONTROL' colspan='1' width='25%'><input type='text' name='strWaiveOffAmt' class='txtFldNormal' value='0' onKeyPress='return validateData(event,5);' onKeyUp='calculateNetCost();'></td>");
					sb.append("<td class='LABEL' colspan='1' width='25%'><font color='red'>*</font>Approved By</td>");
					sb.append("<td class='CONTROL' colspan='1' width='25%'><select name='strWaiveOffApprovedBy'>"
							+ waiveOffApprovedBy + "</select></td></tr>");
					sb.append("<tr><td class='LABEL' colspan='2' width='25%'><font color='red'>*</font>Approved Date</td>");
					sb.append("<td class='CONTROL' colspan='3' width='75%'>"
							+ getDatePicker("strWaiveOffApprovedDate", vo.getStrCurrentDate(), true) + "</td>");
					sb.append("</table></div>");
				}
				sb.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				sb.append("<tr><td class='LABEL' colspan='1' width='25%'><font color='red'>*</font>Advance Adjusted</td>");
				sb.append(
						"<td class='CONTROL' colspan='1' width='25%'><input type='text' name='strAdvanceAdjusted' class='txtFldNormal' value='0' onKeyPress='return validateData(event,5);' onKeyUp='calculateNetCost();'></td>");
				sb.append("<td class='LABEL' colspan='1' width='25%'>Net Cost</td>");
				sb.append(
						"<td class='CONTROL' colspan='1' width='25%'><input type='hidden' name='strNetItemCost' value='0' /><div id='netCostDIV' style='color: red;font-weight:bold'>0.0</div></td></tr>");
				sb.append("</table>");
	
			} catch (Exception e) {
				new HisException("Bill Approval Transaction", "BillApprovalViewTransHLP.getReceiptDetails()-->",
						e.getMessage());
			}
			return sb.toString();
		}
	
		public static String getDatePicker(String fieldName, String dateValue, boolean readOnly) {
			String dateString = "";
			StringBuilder strBuffer = new StringBuilder(500);
			strBuffer.append((new StringBuilder(" <input size='9%' type=\"text\" name=\"")).append(fieldName)
					.append("\" id=\"").append(fieldName).append("\" ").toString());
			if (readOnly)
				strBuffer.append(" readonly = \"false\" ");
			strBuffer.append((new StringBuilder(" value='")).append(dateValue).append("'>").toString());
			strBuffer.append((new StringBuilder(" <img src=\"../../hisglobal/images/imgDatepicker.png\" id=\""))
					.append(fieldName)
					.append("1\" style=\"cursor: pointer; border: 1px solid red;\" title=\"Date selector\" ").toString());
			strBuffer.append(" onmouseover=\"Calendar.datePickerAjax(event,document.forms[0]." + fieldName
					+ "),this.style.background='red';\" onmouseout=\"this.style.background=''\"> \n");
			  strBuffer.append("<script event=\"Click()\" language=\"JavaScript\"> \"+Calendar.setup({ ");
			strBuffer.append((new StringBuilder(" inputField : \"")).append(fieldName).append("\",ifFormat : \"%d-%b-%Y\",button : \"").append(fieldName).append("1\",singleClick : true\n").toString());
			strBuffer.append("})\";</script>\n");
			dateString = strBuffer.toString();
			strBuffer = null;
			return dateString;
		}
	
		public static String getPONoSearchListDetails(BillApprovalTransVO vo) throws SQLException {
			StringBuffer br = new StringBuffer();
			int i = 0;
			WebRowSet wb = null;
			try {
				wb = vo.getStrPOSearchDetailsWs();
				// System.out.println("wsSizePopUp->"+wb.size());
				if (wb.size() != 0) {
					br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
					br.append("<TR>");
					br.append("<TD WIDTH='5%' CLASS='multiLabel' colspan='1'></TD>");
					br.append("<TD WIDTH='25%' CLASS='multiLabel' colspan='1'>PO No.</TD>");
					br.append("<TD WIDTH='20%' CLASS='multiLabel' colspan='1'>PO Date</TD>");
					br.append("<TD WIDTH='25%' CLASS='multiLabel' colspan='1'>PO Type</TD>");
					br.append("<TD WIDTH='25%' CLASS='multiLabel' colspan='1'>Supplier Name</TD>");
					br.append("<TR>");
					while (wb.next()) {
						String strPOSearchDtlChkVal = wb.getString(1) + "^" + wb.getString(2) + "^" + wb.getString(3) + "^"
								+ wb.getString(5) + "^" + wb.getString(9) + "^" + wb.getString(7);
						br.append("<TR>");
						br.append(
								"<TD WIDTH='5%'  CLASS='multiControl' colspan='1'><input type='radio' name ='strPOSearchDtlChk' id='strItemDetailsChk"
										+ i + "' value='" + strPOSearchDtlChkVal + "' onClick='poNoSel(this);'/> </TD>");
						br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='1'>" + wb.getString(1) + "</TD>");
						br.append("<TD WIDTH='20%' CLASS='multiControl' colspan='1'>" + wb.getString(2) + "</TD>");
						br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='1'>" + wb.getString(4) + "</TD>");
						br.append("<TD WIDTH='25%' CLASS='multiControl' colspan='1'>" + wb.getString(6) + "</TD>");
						br.append("</TR>");
						i++;
					}
					br.append("</table>");
				} else {
					br.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px'>");
					br.append("<TR>");
					br.append("<TD WIDTH='100%' CLASS='multiControl' colspan='5'>"
							+ "<font color='red' size='2'>No Record Found</font></TD>");
					br.append("</TR>");
					br.append("</table>");
				}
	
			} catch (Exception e) {
	
			}
	
			return br.toString();
		}
	
		public static String createPeneltyDtl(WebRowSet wb1, String strLatePenelty, String strRejectedPenelty) {
			StringBuffer br = new StringBuffer();
	
			try {
	
				br.append("<table width='400'>\n");
				br.append("<tr class='HEADER'>\n");
	
				br.append("<td align='left' width='90%'>Penelty Details</td>");
				br.append(
						"<td align='center' width='10%'><img  style='cursor:pointer;cursor:pointer' src='../../hisglobal/images/popUp_cancel.JPG'");
				br.append("onClick='closePeneltyItemDtl();' title='Click Here To Close Popup'></td>");
				br.append("</tr>\n");
				br.append("</table>");
				br.append("<table width='400' cellspacing='1px' cellpadding='1px'>\n");
				br.append("<tr>\n");
				br.append("<td class='LABEL' width='25%'>\n");
				br.append("Late Supply Penelty");
				br.append("</td>");
				br.append("<td class='CONTROL'  >\n");
				br.append(strLatePenelty);
				br.append("</td>");
				br.append("</tr>\n");
				br.append("<td class='LABEL'  width='25%'>\n");
				br.append("Rejected/Breakage Penelty");
				br.append("</td>");
				if (wb1.size() == 0) {
					br.append("<td class='CONTROL' >\n");
					br.append(strRejectedPenelty);
					br.append("</td>");
				} else {
					br.append(
							"<td class='CONTROL' ><a style='color: blue;cursor: pointer; ' onClick='showPeneltyItemDtl();' title='Click Here to View Items Details'>\n");
					br.append(strRejectedPenelty + "</a></td>");
	
				}
	
				br.append("</tr>\n");
				br.append("</table>");
				if (wb1 != null || wb1.size() != 0) {
					br.append("<div id='itemDtl' style='display:none'>");
					br.append("<table width='400' cellspacing='1px' cellpadding='1px'>\n");
					br.append("<tr>\n");
					br.append("<td class='TITLE' colspan='4'>Breakage/Rejected Item Details</td>");
					br.append("</tr>\n");
					br.append("<tr>\n");
					br.append("<td class='multiLabel'>Item Name</td>\n");
					br.append("<td 'class= 'multiLabel'>Batch No.</td>\n");
					br.append("<td 'class='multiLabel'>Rejected Qty</td>\n");
					br.append("<td 'class='multiLabel'>Breakage Qty</td>\n");
					br.append("</tr>\n");
	
					while (wb1.next()) {
						br.append("<tr>\n");
						br.append("<td class='multiControl'>" + wb1.getString(1) + "</td>\n");
						br.append("<td class= 'multiControl'>" + wb1.getString(2) + "</td>\n");
						br.append("<td class='multiControl'>" + wb1.getString(3) + "</td>\n");
						br.append("<td class='multiControl'>" + wb1.getString(4) + "</td>\n");
						br.append("</tr>\n");
					}
					br.append("</table>");
					br.append("</div>");
				}
				br.append("<table width='400' cellspacing='1px' cellpadding='1px'>\n");
				br.append("<tr class='FOOTER'>");
				br.append("<td colspan='2' align ='center'></td>");
				br.append("</tr>");
				br.append("</table>");
	
			} catch (Exception e) {
				try {
	
					throw new Exception("BillApprovalTransHLP.createPeneltyDtl--->" + e.getMessage());
				} catch (Exception e1) {
				}
			} finally {
				wb1 = null;
	
			}
			return br.toString();
		}*/

}