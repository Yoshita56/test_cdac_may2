package mms.transactions.controller.hlp;


import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.transactions.vo.DupSupplierReturnFromTransVO;


public class DupSupplierReturnFromTransHLP {
	public static String getReturnOrCondemnDrugListHlp(DupSupplierReturnFromTransVO vo) {
		StringBuffer br = new StringBuffer();
		int i = 0;
		WebRowSet wb = vo.getWsNOSQItemDetail();					
		try
		{
			
			if (wb != null && wb.size() > 0) 
			{
				
					br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr class='TITLE'>");
					br.append("<td colspan='8' class='font-weight-bold'><div id='' align='left'>Order Details</div></td></tr>");
					br.append("<tr>");
					br.append("<td WIDTH='5%'   colspan='1' class='font-weight-bold'>#</td>");
					br.append("<td WIDTH='25%'  colspan='1' class='font-weight-bold'>Drug Name</td>");
					br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>RC No.</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Batch No</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Avl Qty</td>");	
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Return/Condemnation Qty</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Action</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Order No.</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Order Date</td>");
					br.append("</tr> ");
					br.append("</table> ");
					br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px' >");
					while (wb.next()) 
					{
					  /*
						 1 ITEM_NAME
                    	 2 HSTNUM_ITEMBRAND_ID
                    	 3 HSTSTR_BATCH_SL_NO
                    	 4 DECODE(HSTNUM_NEW_ORDER_TYPE,1,'Replacement',2,'Condemnation')
                    	 5 HSTNUM_NEW_ORDER_TYPE
                    	 6 HSTNUM_NEW_ORDER_NO
                    	 7 HSTDT_NEW_ORDER_DATE
                    	 8 DECODE(HSTNUM_DRUG_TYPE_FLAG,1,'NOSQ',2,'Rejected',3,'Expired')
                    	 9 STORE_NAME
                    	10 HSTNUM_STORE_ID
                    	11 AVL_QTY
                    	12 HSTNUM_NEW_ORDER_TYPE
                    	13 HSTNUM_DRUG_TYPE_FLAG
                    	14 HIDDEN_VALUE   (HSTNUM_ITEM_ID || ''^'' || HSTNUM_ITEMBRAND_ID || ''^'' || HSTSTR_BATCH_SL_NO || ''^'' || 
			                    HSTNUM_OLD_PO_NO || ''^'' || HSTNUM_NEW_ORDER_NO || ''^'' || HSTNUM_SUPPLIER_ID || ''^'' || 
			                    HSTNUM_DRUG_TYPE_FLAG||''^''||HSTNUM_NEW_ORDER_TYPE)
			            15 HSTNUM_RET_CONDEMN_QTY        
					  */
						
						
					String strHiddenValue = wb.getString(14)+"^"+wb.getString(11);
						
					br.append("<TR>");										
					br.append("<td width='5%' class='multiRPTLabel' id='check"+i+"'><input type='checkbox' title='View' name='strNosqDrugs' value='"+strHiddenValue+ "' id='strNosqDrugs' onclick='onCheckRadioButton(\""+strHiddenValue+"\",\""+ i + "\");'></td>");
					br.append("</td>");						
					br.append("<TD WIDTH='25%'  colspan='1' CLASS=''>"+ wb.getString(1) + "</TD>");
					br.append("<TD WIDTH='5%'  colspan='1' CLASS=''>"+ wb.getString(16) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS=''>"+ wb.getString(3) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS=''>"+ wb.getString(11) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS=''>"+ wb.getString(15) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS=''>"+ wb.getString(4) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS=''>"+ wb.getString(6) + "</TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS=''>"+ wb.getString(7) + "</TD>");
					
					br.append("</TR>");
					i++;
				}  					
					br.append("</table> ");

						

			}
			if (wb.size() == 0) 
			{
				br.append("<table class='TABLEWIDTH' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr class='TITLE'>");
				br.append("<td colspan='8'><div id='' align='left'>Drug List</div></td></tr>");
				br.append("<tr>");
				br.append("<td WIDTH='5%'   colspan='1' class='multiRPTLabel'>#</td>");
				br.append("<td WIDTH='25%'  colspan='1' class='multiRPTLabel'>Drug Name</td>");
				br.append("<td WIDTH='5%'  colspan='1' class='multiRPTLabel'>RC No.</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Batch No</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Avl Qty</td>");	
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Return/Condemnation Qty</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Action</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Order No.</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='multiRPTLabel'>Order Date</td>");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				br.append("<TR>");
				br.append("<td class='multiRPTControl' colspan='7><b><div id='id' align='center' color='Red'> drug list not found</div></b></td>");
				br.append("</TR>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return br.toString();
	}

		
	public static String getReturnOrCondemnDrugListHlpNEW(DupSupplierReturnFromTransVO vo) {
		StringBuffer br = new StringBuffer();
		int i = 0;
		WebRowSet wb = vo.getWsNOSQItemDetail();					
		try
		{
			
			if (wb != null && wb.size() > 0) 
			{
			
					br.append("<table class='table table-striped' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr class=''>");
					br.append("<td colspan='9' class='font-weight-bold'><div id='' align='left'>Order Details</div></td></tr>");
					br.append("<tr>");
					br.append("<td WIDTH='5%'   colspan='1' class='font-weight-bold'>#</td>");
					br.append("<td WIDTH='25%' colspan='1' class='font-weight-bold'>Drug Name</td>");
					br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>RC No.</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Batch No</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Avl Qty</td>");	
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Return/Condemnation Qty</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Action</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Order No.</td>");
					br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Order Date</td>");
					br.append("</tr> ");
					//br.append("</table> ");
					
					//br.append("<div class='row'>");
					//br.append("<div class='col-md-12'>");
					//br.append("<table class='' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
					while (wb.next()) 
					{
					  /*
						 1 ITEM_NAME
                    	 2 HSTNUM_ITEMBRAND_ID
                    	 3 HSTSTR_BATCH_SL_NO
                    	 4 DECODE(HSTNUM_NEW_ORDER_TYPE,1,'Replacement',2,'Condemnation')
                    	 5 HSTNUM_NEW_ORDER_TYPE
                    	 6 HSTNUM_NEW_ORDER_NO
                    	 7 HSTDT_NEW_ORDER_DATE
                    	 8 DECODE(HSTNUM_DRUG_TYPE_FLAG,1,'NOSQ',2,'Rejected',3,'Expired')
                    	 9 STORE_NAME
                    	10 HSTNUM_STORE_ID
                    	11 AVL_QTY
                    	12 HSTNUM_NEW_ORDER_TYPE
                    	13 HSTNUM_DRUG_TYPE_FLAG
                    	14 HIDDEN_VALUE   (HSTNUM_ITEM_ID || ''^'' || HSTNUM_ITEMBRAND_ID || ''^'' || HSTSTR_BATCH_SL_NO || ''^'' || 
			                    HSTNUM_OLD_PO_NO || ''^'' || HSTNUM_NEW_ORDER_NO || ''^'' || HSTNUM_SUPPLIER_ID || ''^'' || 
			                    HSTNUM_DRUG_TYPE_FLAG||''^''||HSTNUM_NEW_ORDER_TYPE)
			            15 HSTNUM_RET_CONDEMN_QTY        
					  */
						
						
					String strHiddenValue = wb.getString(14)+"^"+wb.getString(11);
						
					br.append("<TR>");										
					br.append("<td width='5%' id='check"+i+"'><input class='form-control' type='checkbox' title='View' name='strNosqDrugs' value='"+strHiddenValue+ "' id='strNosqDrugs' onclick='onCheckRadioButton(\""+strHiddenValue+"\",\""+ i + "\");'></td>");
					br.append("</td>");						
					br.append("<TD WIDTH='25%' colspan='1' CLASS=''>"+ wb.getString(1) + "</TD>");
					br.append("<TD WIDTH='5%' align='center' colspan='1' CLASS=''>"+ wb.getString(16) + "</TD>");
					br.append("<TD WIDTH='10%' align='center'  colspan='1' CLASS=''>"+ wb.getString(3) + "</TD>");
					br.append("<TD WIDTH='10%' align='center' colspan='1' CLASS=''>"+ wb.getString(11) + "</TD>");
					br.append("<TD WIDTH='10%' align='center' colspan='1' CLASS=''>"+ wb.getString(15) + "</TD>");
					br.append("<TD WIDTH='10%' align='center' colspan='1' CLASS=''>"+ wb.getString(4) + "</TD>");
					br.append("<TD WIDTH='10%' align='center' colspan='1' CLASS=''>"+ wb.getString(6) + "</TD>");
					br.append("<TD WIDTH='10%' align='center' colspan='1' CLASS=''>"+ wb.getString(7) + "</TD>");
					
					br.append("</TR>");
					i++;
				}  					
					br.append("</table> ");
					//br.append("</div>");
					//br.append("</div>");

						

			}
			if (wb.size() == 0) 
			{
				br.append("<table class='table table-striped' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr class=''>");
				br.append("<td colspan='9' class='font-weight-bold'><div id='' align='left'>Drug List</div></td></tr>");
				br.append("<tr>");
				br.append("<td WIDTH='5%'   colspan='1' class='font-weight-bold'>#</td>");
				br.append("<td WIDTH='25%'  colspan='1' class='font-weight-bold'>Drug Name</td>");
				br.append("<td WIDTH='5%'  colspan='1' class='font-weight-bold'>RC No.</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Batch No</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Avl Qty</td>");	
				br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Return/Condemnation Qty</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Action</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Order No.</td>");
				br.append("<td WIDTH='10%'  colspan='1' class='font-weight-bold'>Order Date</td>");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table class='table' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				br.append("<TR>");
				br.append("<td class='' style='color:red' colspan='7><b><div id='id' align='center' color='Red'> Drug list not found</div></b></td>");
				br.append("</TR>");
				br.append("</table> ");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return br.toString();
	}

	
	public static String getDebitNoteList(DupSupplierReturnFromTransVO vo) {
		StringBuffer br = new StringBuffer();
		int i = 0;
		WebRowSet wb = vo.getWsNOSQItemDetail();					
		try
		{
			
			if (wb != null && wb.size() > 0) 
			{
			
					br.append("<table class='table table-striped' id='debitNoteTable' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr class=''>");
					br.append("<td colspan='9' class='font-weight-bold'><div id='' align='left'>Debit Note Number Details</div></td></tr>");
					br.append("<tr>");
					br.append("<td WIDTH='5%'   colspan='1' class='font-weight-bold'>#</td>");
					br.append("<td WIDTH='25%' colspan='1' class='font-weight-bold'>Debit Note Number</td>");
					br.append("<td WIDTH='25%'  colspan='1' class='font-weight-bold'>Date of Order</td>");
					br.append("</tr> ");
					//br.append("</table> ");
					
					//br.append("<div class='row'>");
					//br.append("<div class='col-md-12'>");
					//br.append("<table class='' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
					while (wb.next()) 
					{
					  /*
						 1 HSTNUM_debitnote_no
                    	 2 hstdt_ret_condemn_date
                    	 3 HSTSTR_SUPPLIER_NAME
                    	        
					  */
						
						 String sDate1=wb.getString(2).split(" ")[0];  
						 Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);  
						//System.out.println(sDate1+"\t"+date1);
						
						
						
					String strHiddenValue = wb.getString(1)+"^"+wb.getString(2)+"^"+wb.getString(3);
						
					br.append("<TR>");										
					br.append("<td id='check"+i+"'><input class='#' type='radio' title='Print Debit Note' name='strdebitNote' value='"+strHiddenValue+ "' id='strdebitNote' onclick='onSelectRadioButton(\""+strHiddenValue+"\",\""+ i + "\");'></td>");
					br.append("</td>");						
					br.append("<TD WIDTH='25%' colspan='1' CLASS=''>"+ wb.getString(1) + "</TD>");
					/*
					 * DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); String
					 * strDate = dateFormat.format(wb.getString(2));
					 * 
					 */
					/*
					 * String d = wb.getString(2).split(" ")[0]; System.out.println(new
					 * SimpleDateFormat("dd-mm-yyyy").format(d));
					 */ 
					br.append("<TD WIDTH='10%' align='center'  colspan='1' CLASS=''>"+ new SimpleDateFormat("dd-MMM-yyyy").format(date1) + "</TD>");
										
					br.append("</TR>");
					i++;
				}  					
					br.append("</table> ");
					//br.append("</div>");
					//br.append("</div>");

						

			}
			if (wb.size() == 0) 
			{
				br.append("<table class='table table-striped' align='center' border='0' bgcolor='#6097BC' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr class=''>");
				br.append("<td colspan='9' class='font-weight-bold'><div id='' align='left'>Debit Note Number Details</div></td></tr>");
				br.append("<tr>");
				br.append("<td WIDTH='5%'   colspan='1' class='font-weight-bold'>#</td>");
				br.append("<td WIDTH='25%' colspan='1' class='font-weight-bold'>Debit Note Number</td>");
				br.append("<td WIDTH='25%'  colspan='1' class='font-weight-bold'>Date of Order</td>");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table class='table' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				br.append("<TR>");
				br.append("<td class='' style='color:red' colspan='7><b><div id='id' align='center' color='Red'> Debit Note list not found</div></b></td>");
				br.append("</TR>");
				br.append("</table> ");
				
							
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return br.toString();
	}
	
	
	
	
	public static String getDebitNoteDetail(DupSupplierReturnFromTransVO vo) throws Exception {
		StringBuffer sb = new StringBuffer("");
		
		String SrNo = "";
		String StoreName = "" ;
		String StoreId = "";
		String ItemName = "";
		String BatchNO = "";
		String HospitalCode = "";
		String SupplierName = "";
		String ExpDate = "";
		String ret_condemn_qty = "";
		String action = "";
		String orderNo = "";
		String orderdate = "";
		String ret_condemn_date = "";
		
		String returnto = "";
		String condemn_type = "";
		String condemn_remarks = "";
		String newOrderType = "";
		String rate = "";
		String qty = "";
		String rate_with_tax = "";
		String newOrderNo = "";
		String invoiceNo = "";
		String supplier_address = "";
		String verification_remarks = "";
		
		String tax = "";
		String item_remarks = "";
		String debitnote_no = "";
		String TENDER_ITEMNO = "";
		
		WebRowSet ws = vo.getWsNOSQItemDetail();
		
		double quantity_total = 0.00;
		double Value = 0.00;
		
		int i=0;
		
		
		/*
			 1. SrNo 
			 2. StoreName
			 3. StoreId 
			 4. ItemName
			 5. BatchNO 
			 6. HospitalCode
			 7. SupplierName
			 8. ExpDate 
			 9. ret_condemn_qty
			 10. action 
			 11. orderNo
			 12. orderdate
			 13. ret_condemn_date		
			 14. returnto 
			 15. condemn_type
			 16. condemn_remarks
			 17. newOrderType
			 18. rate 
			 19. qty 
			 20. rate_with_tax 
			 21. newOrderNo 
			 22. invoiceNo 
			 23. supplier_address
			 24. verification_remarks		
			 25. tax 
			 26. item_remarks
			 27. debitnote_no
			 28. TENDER_ITEMNO
		 */
		 
	    try
	    {
	    
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
				
				sb.append("<table align='center' cellspacing='1px' cellpadding='1px' border='0' >"
						+ " <tr><td align='center'><div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>");
				sb.append("</tr> ");
				sb.append("</table> ");	
	
				sb.append( "<table align='center' cellspacing='1px' cellpadding='1px' border='0' >"
						+ "<tr><td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"
						+ "<b>"+"Debit Note Details"+"</b>"
						+ "</font></td><td align='center' colspan='2'><div id='printImg'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne1();' /></div></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "Store Name ::<b>"+vo.getStrStoreName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "Category Name ::<b>"+vo.getStrCategoryName()+"</b></font></td><td align='center' colspan='2'></td></tr>" 
						
						+ " <tr><td align='center' colspan='3'></td> "
						+ "<td align='center' colspan='3'>"
						+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
						+ "Supplier Name ::<b>"+vo.getStrSupplierName()+"</b></font></td><td align='center' colspan='2'></td></tr>" +
						
						"</table> ");
											
				sb.append("<table class='table table-hover' style='margin-top: 2%;color:black;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center'><b>SrNo</b>");
			    sb.append("</td>");
			    sb.append("<td width='25%' align='center'><b>ItemName</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Batch No.</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Exp. Date</b>");
		        sb.append("</td>");
		       
		        sb.append("<td width='10%' align='center'><b>Debit No</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Debit Date</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Rate With Tax</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Debit Qty</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Value</b>");
		        sb.append("</td>");
		       
		        sb.append("</tr>");
		      

				while(ws.next())
				{		
					
					 
							if(i==0)
							{
								quantity_total = Double.parseDouble(ws.getString(9));
								Value = Double.parseDouble(ws.getString(20));
							}
							else
							{
								quantity_total = quantity_total + Double.parseDouble(ws.getString(9));
								Value = Value + Double.parseDouble(ws.getString(20));
							}
					
							sb.append("<tr >");
							sb.append("<td  width='5%' style='text-align: center;' >");							
							sb.append(ws.getString(1));							// SrNo											
							sb.append("</td>");
							sb.append("<td  width='25%' style='text-align: left;'>");								
							sb.append(ws.getString(4));							// ItemName											
							sb.append("</td>");
							sb.append("<td  width='10%' style='text-align: left;'>");
							sb.append(ws.getString(5));							// Batch No.						    
							sb.append("</td>");
							sb.append("<td  width='10%' style='text-align: center;'>");				
							sb.append(ws.getString(8));							// Exp. Date						
							sb.append("</td>");
						
							sb.append("<td  width='10%' style='text-align: right;' >");							
							sb.append(ws.getString(11));						// Debit No											
							sb.append("</td>");
							sb.append("<td  width='10%' style='text-align: center;' >");							
							sb.append(ws.getString(12));						// Debit Date										
							sb.append("</td>");
							sb.append("<td  width='10%' style='text-align: right;' >");							
							sb.append(ws.getString(26));	    				// Rate With Tax										
							sb.append("</td>");
							sb.append("<td  width='10%' style='text-align: right;' >");							
							sb.append(ws.getString(9));							// Debit Qty												
							sb.append("</td>");
							sb.append("<td  width='10%' style='text-align: right;'>");							
							sb.append(ws.getString(20));						// Value										
							sb.append("</td>");
							sb.append("</tr>");
							i++;
							
				}
							sb.append("<tr background-color='red'>");
							sb.append("<td  colspan='7' style='text-align: right;'>");
							sb.append("<b>");
							sb.append("Total");
							sb.append("</b>");
							sb.append("</td>");
							sb.append("<td style='text-align: right;'>");
							sb.append("<b>"+Math.round(quantity_total)+"</b>");											
							sb.append("</td>");
							sb.append("<td style='text-align: right;'>");
							sb.append("<b>"+Math.round(Value)+"</b>");											
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
		
		
		
		
		
		
		
		
		
		
		
		
		
	

	
	
	public static String getvoucherPrintDetails(DupSupplierReturnFromTransVO vo) 
	{
		double sum1=0;
		StringBuffer sb = new StringBuffer("");
		String strReceivedQty = "";
		String strOrderNo="" , strOrderDate="";
		HisUtil util = new HisUtil("mms", "getvoucherPrintDetails");
		WebRowSet ws = null ;
		String strTableWidth = "700";
		String Remarks="";
		int sno=1;
		try 
		{
			ResourceBundle res = mms.qryHandler_mms.res;
			if(res == null) 
			{
				res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = res;
			}
			ws	=	vo.getWsNOSQItemDetail();
			if (ws != null && ws.size() > 0) 
			{
				ws.next();
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
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
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			if(ws.getString(16).equals("2"))
			{
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><u>Condemnation voucher</u>");
			}
			else
			{
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><u>Supplier Debit Note</u>");
			}
			
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");		
			
			sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='").append(strTableWidth).append(
			"'></table> ");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataForTransfer();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideTransferPopup();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
            sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

            /*
             1 STORE_NAME,
             2 HSTNUM_STORE_ID
			 3 ITEM_NAME 
             4 BATCH_NO
             5 GNUM_HOSPITAL_CODE
             6 SUPPLIER_NAME
             7 Exp_Date
             8 RET_CONDEMN_QTY
             9 ACTION
             10 ORDER_NO
             11 ORDER_DATE
             12 RET_CONDEMN_DATE
             13 RETURN_TO
             14 CONDEMNATION_TYPE
             15 CONDEMN_REMARKS
             16 HSTNUM_RET_CONDEMN_FLAG
            */
            
            
			}
			ws.beforeFirst();
            if (ws != null && ws.size() > 0) 
			{

				/*while (ws.next()) 
				{
					 strTransferNo    = ws.getString(1);
					 strTransferDate  = ws.getString(2);
					 strTransferTo    = ws.getString(3);
					 strTransferFrom  = ws.getString(4);
					 //strRemarks       = ws.getString(21);
					 //strReceivedBy    = ws.getString(22);					 
					 strOrderNo       = ws.getString("ORDER_NO");
					 strOrderDate     = ws.getString("ORDER_DATE");
				     strDemandNo      = ws.getString("DEMAND_REQ_NO");
					 strDemandDate    = ws.getString("DEMAND_DATE");
					 strTransferredBy = ws.getString("TRANSFER_BY"); 
					 
	                          
					
				}
				ws.beforeFirst();*/
				
            	if(ws.next())
            	{
            		 Remarks=ws.getString(23);
            		if(ws.getString(16).equals("1"))
            		{
            		 sb.append("<tr > ");
            		 sb.append("<tdwidth='25%' align='LEFT' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
								util.appendSpace("<b>Supplier Name</b>", 15,0)).append(" : "+ws.getString(6)+"</font></td> ");
					 sb.append("</tr> ");
					
					 sb.append("<tr colspan='4'> ");
            		 sb.append("<td width='25%' align='LEFT' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
								util.appendSpace("<b>Supplier Address</b>", 15,0)).append(" : "+ws.getString(22)+"</font></td> ");
					 sb.append("</tr> ");
            		}
					 
					sb.append("<tr> ");
					/*sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Store Name", 15,0)).append(" : "+ws.getString(1)+"</b></font></td> ");*/
					
					if(ws.getString(16).equals("1"))
					{
						sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
							util.appendSpace("<b>Store Name</b>", 15,0)).append(" : "+ws.getString(1)+"</font></td> ");
						 sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
									util.appendSpace("<b>Order Date</b>", 15,0)).append(" : "+ws.getString(11)+"</font></td> ");
					}
					else
					{
						/*sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Condemnation Type", 15,0)).append(" : "+ws.getString(14)+"</b></font></td> ");						
						*/
						sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
								util.appendSpace("<b>Store Name</b>", 15,0)).append(" : "+ws.getString(1)+"</font></td> ");
							 sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
										util.appendSpace("<b>Order Date</b>", 15,0)).append(" : "+ws.getString(11)+"</font></td> ");
					}
					
				     sb.append("</tr> ");
				     if(ws.getString(16).equals("1"))
						{
				     
				     sb.append("<tr> ");
				     sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Debit Note No", 15,0)+"</b>").append(" : "+ws.getString(27)+"</font></td> ");
				     sb.append("</tr> ");
						}
				     else
						{
				     
				     sb.append("<tr> ");
				     sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Condemnation voucher No.", 15,0)+"</b>").append(" : "+ws.getString(27)+"</font></td> ");
				     sb.append("</tr> ");
						}
						
					
					 //sb.append("<tr> ");
					 //sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
					//			util.appendSpace("Order No", 15,0)).append(" : "+ws.getString(10)+"</b></font></td> ");
					 
					
					 //sb.append("</tr> ");
					
					/*sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Transfer Date", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strTransferDate).append(
							"</b></font></td> ");*/
					//sb.append("</tr> ");
            	}	
							
			
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
				/*sb.append("<tr>");		
				sb.append("<td colspan='8' align='center'><hr size='2' width='100%'></td>");
				sb.append("</tr>");*/
				
				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append("<td  width='5%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>S.No.</b></font> ");
				sb.append("</td>");
				sb.append("<td  width='25%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>Item Name</b></font> ");
				sb.append("</td>");
				sb.append("<td  width='5%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>RC S.No.</b></font> ");
				sb.append("</td>");
				
				sb.append("<td width='8%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>Batch No.</b></font> ");
				sb.append("</td> ");
				//sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return/Condemn Qty</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice No</b></font> ");
				sb.append("</td> ");
				
				/*if(ws.getString(16).equals("2"))
				{
					sb.append("<td align='center' width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Condemnation Type</b></font> ");
					sb.append("</td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Condemn Date</b></font> ");
					sb.append("</td> ");
				}*/
				//else
				//{
					//sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Date</b></font> ");
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry</b></font> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax</b></font> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate(With Tax)</b></font> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty.</b></font> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font> ");
					sb.append("<td align='center' width='27%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks</b></font> ");
					sb.append("</td> ");
				//}
				
				sb.append("</tr> ");

				sb.append("<tr>");		
				sb.append("<td colspan='10' align='center'><hr size='2' width='100%'></td>");
				sb.append("</tr>");
						
				ws.beforeFirst();	
				while (ws.next()) 
				{
					sb.append("<tr> ");
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(sno++);
					sb.append("</font></td> ");
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(28));
					sb.append("</font></td> ");
					sb.append("<td align='left' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(4));
					sb.append("</font></td> ");
					/*sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");*/
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(21));
					sb.append("</font></td> ");
					
					//if(ws.getString(16).equals("2"))
					//{
					//	sb.append("<td align='center' width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//	sb.append(ws.getString(14));
				//		sb.append("</font></td> ");
				//	}
					
					//sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//sb.append(ws.getString(12));
					//sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(17));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(24));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(25));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(18));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(19));
					sum1=sum1+Double.parseDouble(ws.getString(19));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='27%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(26));
					sb.append("</font></td> ");
					
					sb.append("</tr> ");
					
					//sb.append("<tr><br/><br/>");
					//sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Remarks : "+ws.getString(15)+"</b><br/><br/></font></td> ");
					//sb.append("</tr> ");
								
				 }
				sb.append("<tr><br/>");
				sb.append("<td colspan='15' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Return Total: "+HisUtil.getAmountWithDecimal(sum1,2)+"</font></td> ");
				sb.append("</tr> ");
				sb.append("<tr>");
				HisUtil his= new HisUtil("", "");
				sb.append("<td colspan='15' align='left'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Return Amount:</b> "+his.getAmountStr( String.valueOf(HisUtil.getAmountWithDecimal(sum1,0)))+"</b></font></td> ");
				sb.append("</tr> ");
				sb.append("<tr>");
				//HisUtil his= new HisUtil("", "");
				sb.append("<td colspan='15' align='left'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Remarks:</b> "+Remarks+"</b></font></td> ");
				sb.append("</tr> ");
			} 
			else 
			{

				sb.append("<tr> ");
				sb.append("<td colspan='11' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/>Details Not Available</font></td> ");
				sb.append("</tr> ");

			}
            
			
			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();
		}

		return sb.toString();
	}
	
	public static String getDuplicatevoucherPrintDetails(DupSupplierReturnFromTransVO vo) 
	{
		double sum1=0;
		StringBuffer sb = new StringBuffer("");
		String strReceivedQty = "";
		String strOrderNo="" , strOrderDate="";
		HisUtil util = new HisUtil("mms", "getvoucherPrintDetails");
		WebRowSet ws = null ;
		String strTableWidth = "800";
		String Remarks="";
		int sno=1;
		try 
		{
			/*ResourceBundle res = mms.qryHandler_mms.res;
			if(res == null) 
			{
				res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = res;
			}
			ws	=	vo.getWsNOSQItemDetail();
			if (ws != null && ws.size() > 0) 
			{
				ws.next();
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
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
			sb.append("</tr> ");*/
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(vo.getStrHospitalCode());
			//System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
			//System.out.println("the ws length isa  "+ws.getKeyColumns());
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			//sb.append(res.getString("REPORT_TITLE"));
			sb.append(hospitalVO.getHospitalName());
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
			sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
			//sb.append(res.getString("FULL_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			//sb.append(hospitalVO.getCity());
			//sb.append(res.getString("CITY"));
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
		//	sb.append("</table> ");
			ws	=	vo.getWsNOSQItemDetail();
			if (ws != null && ws.size() > 0) 
			{
				ws.next();
			sb.append("<tr> ");
			sb.append("<td width='8%'>&nbsp;</td> ");
			if(ws.getString(16).equals("2"))
			{
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><u>Condemnation voucher(Duplicate)</u>");
			}
			else
			{
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><u>Supplier Debit Note(Duplicate)</u>");
			}
			
			sb.append("</font></b></td><td width='10%'>&nbsp; ");
			sb.append("</td> ");
			sb.append("</tr> ");
			sb.append("</table> ");		
			
			sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='").append(strTableWidth).append(
			"'></table> ");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printDataForTransfer();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideTransferPopup();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
            sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

            /*
             1 STORE_NAME,
             2 HSTNUM_STORE_ID
			 3 ITEM_NAME 
             4 BATCH_NO
             5 GNUM_HOSPITAL_CODE
             6 SUPPLIER_NAME
             7 Exp_Date
             8 RET_CONDEMN_QTY
             9 ACTION
             10 ORDER_NO
             11 ORDER_DATE
             12 RET_CONDEMN_DATE
             13 RETURN_TO
             14 CONDEMNATION_TYPE
             15 CONDEMN_REMARKS
             16 HSTNUM_RET_CONDEMN_FLAG
            */
            
            
			}
			ws.beforeFirst();
            if (ws != null && ws.size() > 0) 
			{

				/*while (ws.next()) 
				{
					 strTransferNo    = ws.getString(1);
					 strTransferDate  = ws.getString(2);
					 strTransferTo    = ws.getString(3);
					 strTransferFrom  = ws.getString(4);
					 //strRemarks       = ws.getString(21);
					 //strReceivedBy    = ws.getString(22);					 
					 strOrderNo       = ws.getString("ORDER_NO");
					 strOrderDate     = ws.getString("ORDER_DATE");
				     strDemandNo      = ws.getString("DEMAND_REQ_NO");
					 strDemandDate    = ws.getString("DEMAND_DATE");
					 strTransferredBy = ws.getString("TRANSFER_BY"); 
					 
	                          
					
				}
				ws.beforeFirst();*/
				
            	if(ws.next())
            	{
            		 Remarks=ws.getString(23);
//            		if(ws.getString(16).equals("1"))
//            		{
//            		 sb.append("<tr > ");
//            		 sb.append("<tdwidth='25%' align='LEFT' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
//								util.appendSpace("<b>Supplier Name</b>", 15,0)).append(" : "+ws.getString(6)+"</font></td> ");
//					 sb.append("</tr> ");
//					
//					 sb.append("<tr colspan='4'> ");
//            		 sb.append("<td width='25%' align='LEFT' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
//								util.appendSpace("<b>Supplier Address</b>", 15,0)).append(" : "+ws.getString(22)+"</font></td> ");
//					 sb.append("</tr> ");
//            		}
//					 
					sb.append("<tr> ");
					/*sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Store Name", 15,0)).append(" : "+ws.getString(1)+"</b></font></td> ");*/
					
					if(ws.getString(16).equals("1"))
					{
						sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
							util.appendSpace("<b>Store Name</b>", 15,0)).append(" : "+ws.getString(1)+"</font></td> ");
						 sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
									util.appendSpace("<b>Order Date</b>", 15,0)).append(" : "+ws.getString(11)+"</font></td> ");
					}
					else
					{
						/*sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Condemnation Type", 15,0)).append(" : "+ws.getString(14)+"</b></font></td> ");						
						*/
						sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
								util.appendSpace("<b>Store Name</b>", 15,0)).append(" : "+ws.getString(1)+"</font></td> ");
							 sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
										util.appendSpace("<b>Order Date</b>", 15,0)).append(" : "+ws.getString(11)+"</font></td> ");
					}
					
				     sb.append("</tr> ");
				     if(ws.getString(16).equals("1"))
						{
				     
				     sb.append("<tr> ");
				     sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Debit Note No", 15,0)+"</b>").append(" : "+ws.getString(27)+"</font></td> ");
				     
				     
				  
//            		 sb.append("<tdwidth='25%' align='LEFT'>").append(
//								util.appendSpace("<b>Supplier Name</b>", 15,0)).append(" : "+ws.getString(6)+"</font></td> ");
					
            		 sb.append("</tr> ");
				     
					 sb.append("<tr> ");
            		 sb.append("<td width='25%' align='LEFT' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
								util.appendSpace("<b>Supplier Address</b>", 15,0)).append(" : "+ws.getString(22)+"</font></td> ");
					 sb.append("</tr> ");
				     
					 
					 
				    
				     
						}
				     
				
				     else
						{
				     
				     sb.append("<tr> ");
				     sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Condemnation voucher No.", 15,0)+"</b>").append(" : "+ws.getString(27)+"</font></td> ");
				     sb.append("</tr> ");
						}
						
					
					 //sb.append("<tr> ");
					 //sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
					//			util.appendSpace("Order No", 15,0)).append(" : "+ws.getString(10)+"</b></font></td> ");
					 
					
					 //sb.append("</tr> ");
					
					/*sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Transfer Date", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strTransferDate).append(
							"</b></font></td> ");*/
					//sb.append("</tr> ");
            	}	
							
			
				sb.append("<table class='table table-bordered'> ");
				/*sb.append("<tr>");		
				sb.append("<td colspan='8' align='center'><hr size='2' width='100%'></td>");
				sb.append("</tr>");*/
				
				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append("<td  width='5%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>S.No.</b></font> ");
				sb.append("</td>");
				sb.append("<td  width='25%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>Item Name</b></font> ");
				sb.append("</td>");
				sb.append("<td  width='5%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>RC S.No.</b></font> ");
				sb.append("</td>");
				
				sb.append("<td width='8%' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>Batch No.</b></font> ");
				sb.append("</td> ");
				//sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return/Condemn Qty</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice No</b></font> ");
				sb.append("</td> ");
				
				/*if(ws.getString(16).equals("2"))
				{
					sb.append("<td align='center' width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Condemnation Type</b></font> ");
					sb.append("</td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Condemn Date</b></font> ");
					sb.append("</td> ");
				}*/
				//else
				//{
					//sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Date</b></font> ");
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry</b></font> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
					sb.append("<td align='center' width='27%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks</b></font> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax</b></font> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate(With Tax)</b></font> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty.</b></font> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font> ");
					
					sb.append("</td> ");
				//}
				
				sb.append("</tr> ");

				
						
				ws.beforeFirst();	
				while (ws.next()) 
				{
					sb.append("<tr> ");
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(sno++);
					sb.append("</font></td> ");
					sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(3));
					sb.append("</font></td> ");
					sb.append("<td align='left' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(28));
					sb.append("</font></td> ");
					sb.append("<td align='left' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(4));
					sb.append("</font></td> ");
					/*sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");*/
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(21));
					sb.append("</font></td> ");
					
					//if(ws.getString(16).equals("2"))
					//{
					//	sb.append("<td align='center' width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//	sb.append(ws.getString(14));
				//		sb.append("</font></td> ");
				//	}
					
					//sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					//sb.append(ws.getString(12));
					//sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(17));
					sb.append("</font></td> ");
					
					sb.append("<td align='left' width='27%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(26));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(24));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(25));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(18));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(19));
					sum1=sum1+Double.parseDouble(ws.getString(19));
					sb.append("</font></td> ");
					
					
					
					sb.append("</tr> ");
					
					//sb.append("<tr><br/><br/>");
					//sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Remarks : "+ws.getString(15)+"</b><br/><br/></font></td> ");
					//sb.append("</tr> ");
								
				 }
				sb.append("<tr><br/>");
				sb.append("<td colspan='15' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Return Total: "+HisUtil.getAmountWithDecimal(sum1,2)+"</font></td> ");
				sb.append("</tr> ");
				sb.append("<tr>");
				HisUtil his= new HisUtil("", "");
				sb.append("<td colspan='15' align='left'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Return Amount:</b> "+his.getAmountStr( String.valueOf(HisUtil.getAmountWithDecimal(sum1,0)))+"</b></font></td> ");
				sb.append("</tr> ");
				sb.append("<tr>");
				//HisUtil his= new HisUtil("", "");
				sb.append("<td colspan='15' align='left'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Remarks:</b> "+Remarks+"</b></font></td> ");
				sb.append("</tr> ");
			} 
			else 
			{

				sb.append("<tr> ");
				sb.append("<td colspan='11' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/>Details Not Available</font></td> ");
				sb.append("</tr> ");

			}
            
			
			sb.append("</table> ");
			

		} catch (Exception e) {

			e.printStackTrace();
		}

		return sb.toString();
	}
}