package mms.reports.controller.hlp;

import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import com.ibm.icu.text.DecimalFormat;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.controller.fb.ItemReplacementRPTFB;
import mms.reports.vo.ItemReplacementRPTVO;

public class ItemReplacementRPTHLP {


public static String getReplacementDetails(ItemReplacementRPTFB fb,ItemReplacementRPTVO vo) 
{
	StringBuffer sb = new StringBuffer("");

	WebRowSet ws = vo.getWsItemCategoryCombo();
	int i=1;
	int totamt   = 0 ;
	String amount="";
	
	String strStoreId = "";
	String strItemCategoryId = "";
	String strFinancialStartYear = "";
	String strFinancialEndYear = "";
	String strDebitNoteNo = "";

	
	try
    {
	if (ws != null) 
	{
		/*sb.append("<div id='printRptId' class='px-5 mx-5' align='right'>"
	                + "<span class='mr-1' style='color:royalblue;' onclick='printReport();'>PRINT</span>"
	                + "<i class='fas fa-print fa-lg mr-2' style='cursor: pointer; color: royalblue;' title='Print Page'  onclick='printReport();'></i>"
	                + "<span class='' style='color:red;'  onclick='controlToMainPage();'>CANCEL</span>"
	                + "<i class='fas fa-times fa-lg'      style='cursor: pointer; color: red;' title='Cancel Page'  onclick='controlToMainPage();'></i>"
	        + "</div>");*/
		sb.append("<div id='printRptId' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printReport();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='controlToMainPage();' /></div></td>");

		sb.append("<div class='d-flex justify-content-center align-items-center'>"
		        //+ " <div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></div>");
				+ " <div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></div>");
		
		sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
				"<tr> "
				+ " <td colspan='3'></td>"
				+"<td colspan='3' align='center' style='font-size:18px;font-weight:normal;'>Item Replacement Report</td>"
				+ " <td colspan='3'></td>");
		sb.append("</tr>");
		
		
		sb.append(" <tr><td align='center' colspan='3'></td> " +
		  "<td align='center' colspan='3'>" +
		  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
		  "Return/Condemnation From ::<b>"+vo.getStrStoreName()
		  +"</b></font></td><td align='center' colspan='2'></td></tr>");
		  
		sb.append(" <tr><td align='center' colspan='3'></td> " +
		  "<td align='center' colspan='3'>" +
		  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
		  "For Item Category ::<b>"+vo.getStrCategoryName() 
		  +"</b></font></td><td align='center' colspan='2'></td></tr>");
		
		sb.append("<tr>"
				+ "<td align='center' colspan='12'>"
				+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
				+ "By User  ::<b>"+vo.getStrUserName()+"</b></font></td><td align='center' colspan='2'></td></tr>");
		
		sb.append("<tr>"
				+ "<td align='center' colspan='12'>"
				+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
				+ "Report Date & Time  ::<b>"+fb.getStrCurrentDate()+"</b></font></td></tr>");
		
		sb.append(" <tr> <td align='center' colspan='3'></td>"
				+ "<td align='center' colspan='3'>"
				+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
				+ "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.getStrFinancialEndYear()+"</b></font></td>"
						+ "<td align='center' colspan='2'>"
						+ "<div id='printid1' class='hidecontrol' style='float:right'>"
						+"</td></tr>");
		
		sb.append("</table>");
				sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        
		        sb.append("<td width='2%' align='center'><b>S.NO</b>");
		        sb.append("</td>");
		        
			    sb.append("<td width='10%' align='center'><b>STORE</b>");
			    sb.append("</td>");
			    
			    sb.append("<td width='20%' align='center'><b>ITEM NAME</b>");
			    sb.append("</td>");
			    
			    sb.append("<td width='8%' align='center'><b>BATCH</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='6%' align='center'><b>EXPIRY DATE</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='8%' align='center'><b>RETN/COND BY</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='8%' align='center'><b>RETN/COND DATE</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='18%' align='center'><b>REMARKS</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='5%' align='center'><b>RATE</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='6%' align='center'><b>QTY</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='6%' align='center'><b>AMOUNT</b>");
		        sb.append("</td>");
		        
		        sb.append("<td width='6%' align='center'><b>#</b>");
		        sb.append("</td>");
	
		        sb.append("</tr>");
    	if(ws.size() != 0)
		{
			while(ws.next())
			{		
				/*  MODEVAL_2 output procedure level
				1 	debitnote no 
				2 	transaction date 
				3	issue-to 
				4	store name 
				5	gener_item_name
				6	brand_item_name
				7	batch no 
				8	exp date
				9	trsfr qty
				10	str id 
				11	item id
				12	item brand id
				13	rate 
				14	rate base val
				15	condemn qty
				16	rate_unit_id
				17  qty-base-value
				18	item_sl_no
				19	col-text
				20	category code
				21	final remarks
				22	received by 
				23	net_cost
				24	order_no -- REMARKS
				25	order date
				26	demand req_no 
				27  demand date
				28	trsfer by 
				29 	condemn qty 
				30 	condemn net cost 
				31  stock register _n 
				32  get username
				33  to char varying date 
				
				*/	
				
					double rate = Double.parseDouble(ws.getString(23));
					int quantity = Integer.parseInt(ws.getString(29).split("\\.")[0]);
				//	int quantity = Integer.parseInt(ws.getString(29));

				//	amount = rate * quantity;
					amount = String.format("%.2f", rate * quantity);
					double finalamount = Double.parseDouble(amount);


						/*
						 * DecimalFormat decimalFormat = new DecimalFormat("#.##"); amount =
						 * decimalFormat.format(amount);
						 */
					//	amount = Math.round(rate * quantity * 100.0) / 100.0; 

				   strStoreId            = vo.getStrStoreId();
				   strItemCategoryId     = vo.getStrItemCategoryId();
				   strFinancialStartYear = vo.getStrFinancialStartYear();
				   strFinancialEndYear   = vo.getStrFinancialEndYear();
				   strDebitNoteNo 		 = ws.getString(1);
 						
				   sb.append("<input type='hidden' name='strHlpStoreId'    id='strHlpStoreId"    +i+ "'  value=" + strStoreId + " />");
				   sb.append("<input type='hidden' name='strHlpItemCategoryId'    id='strHlpItemCategoryId" +i+ "'  value=" + strItemCategoryId + " />");
				   sb.append("<input type='hidden' name='strHlpFinancialStartYear'    id='strHlpFinancialStartYear" +i+ "'  value=" + strFinancialStartYear + " />");
				   sb.append("<input type='hidden' name='strHlpFinancialEndYear'    id='strHlpFinancialEndYear" +i+ "'  value=" + strFinancialEndYear + " />");
				   sb.append("<input type='hidden' name='strHlpDebitNoteNo'    id='strHlpDebitNoteNo" +i+ "'  value=" + strDebitNoteNo + " />");

						sb.append("<tr>");
						
						sb.append("<td  width='2%' align='center' >");							
						sb.append(i);								            //	SL NO	
						sb.append("</td>");
						
						sb.append("<td  width='10%' align='center' >");							
						sb.append(ws.getString(4));								//	Store  		
						sb.append("</td>");

						sb.append("<td  width='20%' align='left' >");							
						sb.append(ws.getString(6));								//	Item Name			
						sb.append("</td>");
						
						sb.append("<td  width='8%' align='center'>");								
						sb.append(ws.getString(7));								//	Batch					
						sb.append("</td>");
						
						sb.append("<td  width='6%' align='center'>");
						sb.append(ws.getString(8));								//	Expiry Date 
						sb.append("</td>");
						
						sb.append("<td  width='8%' align='center'>");								
						sb.append(ws.getString(28));							//	Return/Condemnation By		
						sb.append("</td>");
						
						
						sb.append("<td  width='8%' align='center'>");
						sb.append(ws.getString(27));							//	Return/Condemnation Date
						sb.append("</td>");
						
						sb.append("<td  width='18%' align='left'>");
						sb.append(ws.getString(24));							//	Remarks 
						sb.append("</td>");
						
						sb.append("<td  width='5%' align='center'>");
						sb.append(rate);  										//Rate
						sb.append("</td>");
						
						sb.append("<td  width='6%' align='center'>");
						sb.append(quantity);									//	Return/Condemnation Qty
						sb.append("</td>");
						
						sb.append("<td  width='6%' align='center'>");			
						sb.append(amount);										//Amount = rate * qty 
						sb.append("</td>");
						
						//sb.append("<td width='2%' align='center'><img src='../../hisglobal/images/search_icon1.gif' onclick='generateIssueFunc(this,i);' style='cursor: pointer;' title='Print Replacement Details'></td>");
						sb.append("<td width='6%' align='center'><i class='fa fa-search highlight-icon' onclick='generateIssueFunc(this," + i + ");' style='cursor: pointer;' title='Print Replacement Details'></i></td>");

						sb.append("</tr>");
						i++;
		                totamt += finalamount;

			}
			
			sb.append("<tr>");
			
			sb.append("<td  colspan='10' align='right'><b> TOTAL </b>");
			sb.append("</td>");				
										
			sb.append("<td  colspan='1' align='center'>");
			sb.append(totamt);								
			sb.append("</td>");
			
			sb.append("<td  colspan='1' align='center'>");
			sb.append("</td>");
			
			sb.append("</tr>");
			
			sb.append("</table>");
		}
	else
	{
	 	sb.append("<table align='center' cellspacing='1px' bgcolor='white' cellpadding='1px' border='1px solid black' style='border-collapse:collapse;'>");		
		sb.append("<tr><td><font color='red'>No Record Found</font></td>");
		sb.append("</tr>");
		sb.append("</table>");
	}
   } 
 }
 catch(Exception e)
  {
	    e.printStackTrace();
	    new HisException("Item Replacement Report","ItemReplacementRPTHLP.getReplacementDetails()-->",e.getMessage());
  }
    return sb.toString();
}


public static String getPrintVoucher(ItemReplacementRPTFB fb,ItemReplacementRPTVO vo) throws Exception {
    StringBuffer sb = new StringBuffer("");
    int i = 1;
    ResourceBundle res = null;
    WebRowSet ws = null;
	double  amount=0;
	double totamt   = 0 ;


    String strTableWidth = "850";

    try {
  	  sb.append("<table   width='850' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
				+ " <tr> "
				+ " <td colspan='1'>"
				//+ "<div align='center'><img src='/INVMGM/hisglobal/images/"+vo.getStrLogoName()+"' >"
				+ "<div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' >"
				+ "</div>"
				+ "</td>");

	  sb.append("<td colspan='1'><div id='printVoucrId' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printVoucher();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();' /></div></td>");
  	 
  	  sb.append("</tr>");			
  		
  	  sb.append("</table>");
			        
       sb.append("<table width='850' align='center' cellpadding='1px' cellspacing='1px'> ");
       
       sb.append("<tr>");
       sb.append("<td width='100%' align='center' colspan='5'><font face='Verdana, Arial, Helvetica, sans-serif' size='3'>Item Replacement</font></td> ");
       sb.append("</tr>");	 
       
       sb.append("<tr> ");	
       sb.append("<td width='100%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'><b>").append("Return/Condemnation By User  ::</b></font></td> ");
       sb.append("</tr> ");
       
       sb.append("<tr> ");
       sb.append("<td width='100%' align='center' ><font face='Verdana, Arial, Helvetica, sans-serif'  size='2'>").append(vo.getStrUserName()).append("</font></td> ");
       sb.append("</tr> ");
       
       sb.append("<tr> ");
       sb.append("<table class='custom-table' width='850' align='center' cellpadding='1px' cellspacing='1px' border='1px solid' > ");
       sb.append("<tr bgcolor='#cdc9c9'> ");
       sb.append("<td align='center' width='2%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>SL.No</b></font> ");
       sb.append("</td>");
       sb.append("<td align='center' width='20%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>STORE</b></font> ");
       sb.append("</td>");
       sb.append("<td align='center' width='12%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>ITEM NAME</b></font> ");
       sb.append("</td> ");
       sb.append("<td align='center' width='10%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>BATCH</b></font>");
       sb.append("</td> ");	       
       sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>EXPIRY DATE</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='8%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>RETN/COND DATE</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='22%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>REMARKS</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='6%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>RATE</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='6%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>QTY</b></font>");
       sb.append("</td> ");
       sb.append("<td align='center'  width='6%' style='border: 1px solid black;'><font  face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'><b>AMOUNT</b></font>");
       sb.append("</td> ");
       sb.append("</tr> ");
       
	   ws = vo.getWsItemCategoryCombo();

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{	
					/*
					    1.Debit Note No
						2.Trans Date
						3.Return By
						4.Store Name
						5.Generic Item Name
						6.Item name
						7.Batch No
						8.Exp Date
						9.Ret Qty
					   10.Store Id
					   11.Item Id
					   12.Brand Id
					   13.Rate
					   14.Rate Base Value
					   15.Condemnation Qty
					   16.Rate Unit Id
					   17.Qty Base Value
					   18.Item Sl No
					   19.Default Value
					   20.Catg Code
					   21.Final Remarks
					   22.Rec By
					   23.Net Cost
					   24.Order Remarks
					   25.Order Date
					   26.Req No
					   27.Demand Date
					   28.Transfer By
					   29.Condemn_Qty
					   30.Condemnation Cost
					   31.Stock Reg No
					   32.Get User Name
					   33.Demand Date
				   */				  
					//double rate = Double.parseDouble(ws.getString(13));
					//int quantity = Integer.parseInt(ws.getString(15).split(".")[0]);
					amount = Double.parseDouble(ws.getString(23));
					
					sb.append("<tr > ");
					sb.append("<td align='center' width='2%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(i);
					sb.append("</font></td> ");					
					sb.append("<td align='center' width='20%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;' >");
					sb.append(ws.getString(4));								//	Store  		
					sb.append("</font></td> ");
					sb.append("<td align='left' width='12%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif'  style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(6));								//	Item Name			
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(7));								//	Batch					
					sb.append("</font></td> ");
					sb.append("<td align='center' width='8%'  style='border: 1px solid black;' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(8));								//	Expiry Date 
					sb.append("</font></td> ");
					sb.append("<td align='center' width='8%' style='border: 1px solid black;'  ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(27));							//	Return/Condemnation date 		
					sb.append("</font></td> ");
					sb.append("<td align='left' width='22%' style='border: 1px solid black;'><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(24));							//	REMARKS
					sb.append("</font></td> ");
					sb.append("<td align='center' width='6%'style='border: 1px solid black;'  ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(13)); 
					sb.append("</font></td> ");
					sb.append("<td  align='center' width='6%' style='border: 1px solid black;' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(ws.getString(15)); 
					sb.append("</font></td> ");  	
					sb.append("<td  align='center' width='6%' style='border: 1px solid black;' ><font face='Verdana, Arial, Helvetica, sans-serif' style='FONT-SIZE: 11px;'>");
					sb.append(amount); 
					sb.append("</font></td> ");  
				 					
					sb.append("</tr> ");
					i++;
					totamt += amount;
								
				}	
				
			sb.append("<tr>");
			
			sb.append("<td  colspan='9' align='right'><b> TOTAL </b>");
			sb.append("</td>");				
										
			sb.append("</td>");			
			sb.append("<td  colspan='1' align='center'>");
			sb.append(totamt);								
			sb.append("</td>");
			
			sb.append("</tr>");
						
			sb.append("<tr>");
			//sb.append("<td colspan='4' align='left'><u><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Terms & Conditions</font></td>");
			sb.append("<td colspan='9' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>FOR I.G.I.M.S CENTRAL PHARMACY</font></td>");					
			sb.append("</tr>");
			
			/*sb.append("<tr>");
			sb.append("<td colspan='5' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='1'>Un-used Medicine must be returned before discharge</font></td>");
			sb.append("<td colspan='4' align='center'></td>");					
			sb.append("</tr>");						
			*/
			sb.append("<tr>");
			sb.append("<td colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>User:"+vo.getStrUserName()+"</font></td>");
			sb.append("<td colspan='3' align='left'>User Sign</td>");	
			sb.append("<td colspan='3' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Authorised Signatory</font></td>");	
			sb.append("</tr>");
				        		
			} else {
          sb.append("<tr> ");
          sb.append("<td colspan='9' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>No Reocrd</b><br/><br/></font></td> ");
          sb.append("</tr> ");
       }

       sb.append("</table> ");
       sb.append("<table align='center' width='850' border='0' cellspacing='0' cellpadding='0' height='69'> ");
       sb.append("<tr>");
       sb.append("<td width='10%'></td>");
       sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
       sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
       sb.append("</tr> ");
       sb.append("</table>");
    } catch (Exception e) {
       e.printStackTrace();
       throw e;
    } finally {
       if (ws != null) {
          ws.close();
          ws = null;
       }
    }
    return sb.toString();

    }


		public static String getvoucherPrintDetails(ItemReplacementRPTFB fb,ItemReplacementRPTVO vo) 
		{
			double sum1=0;
			StringBuffer sb = new StringBuffer("");
			HisUtil util = new HisUtil("mms", "getvoucherPrintDetails");
			WebRowSet ws = null ;
			String strTableWidth = "700";
			String Remarks="";
			int sno=1;
			try 
			{
				
				 sb.append("<table   width='850' align='center' cellspacing='1px' cellpadding='1px' border='0'>"
							+ " <tr> "
							+ " <td colspan='1'>"
							//+ "<div align='center'><img src='/INVMGM/hisglobal/images/"+vo.getStrLogoName()+"' >"
							+ "<div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' >"
							+ "</div>"
							+ "</td>");

				  sb.append("<td colspan='1'><div id='printVoucrId' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printVoucher();' /><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/stop.png' onClick='hideIssuePopup();' /></div></td>");
			  	 
			  	  sb.append("</tr>");			
			  		
			  	  sb.append("</table>");
			  	  
				
		
				ws	=	vo.getWsNOSQItemDetail();
				if (ws != null && ws.size() > 0) 
				{
					ws.next();
				
				
					sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
					sb.append("<tr> ");
					sb.append("<td width='8%'>&nbsp;</td> ");
					if(ws.getString(16).equals("2"))
					{
					sb.append("<div align='center'><td width='82%'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'>Condemnation voucher</div>");
					}
					else
					{
						sb.append("<div align='center'><td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'>Supplier Debit Note</div>");
					}
					
					sb.append("</font></b></td><td width='10%'>&nbsp; ");
					sb.append("</td> ");
					sb.append("</tr> ");
					sb.append("</table> ");		
										
					sb.append("<table align='center' cellpadding='1px' cellspacing='1px'> ");		
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
			
			        	if(ws.next())
			        	{
			        		 Remarks=ws.getString(23);
			        		if(ws.getString(16).equals("1"))
			        		{
			        			
			        			sb.append("<tr> ");							
								if(ws.getString(16).equals("1"))
								{
									sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
										util.appendSpace("<b>Store Name</b>", 15,0)).append(" : "+ws.getString(1)+"</font></td> ");
									 sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
												util.appendSpace("<b>Order Date</b>", 15,0)).append(" : "+ws.getString(11)+"</font></td> ");
								}
								else
								{
									sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
											util.appendSpace("<b>Store Name</b>", 15,0)).append(" : "+ws.getString(1)+"</font></td> ");
										 sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
													util.appendSpace("<b>Order Date</b>", 15,0)).append(" : "+ws.getString(11)+"</font></td> ");
								}
								
							     sb.append("</tr> ");
							     if(ws.getString(16).equals("1"))
									{
							     
							     sb.append("<tr> ");
							     sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
											util.appendSpace("Debit Note No", 15,0)+"</b>").append(" : "+ws.getString(27)+"</font></td> ");
							     
							     sb.append("<td width='25%' align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
											util.appendSpace("<b>Supplier Name</b>", 15,0)).append(" : "+ws.getString(6)+"</font></td> ");
							     sb.append("</tr> ");
									}
							     else
									{
							     
							     sb.append("<tr> ");
							     sb.append("<td width='25%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
											util.appendSpace("Condemnation voucher No.", 15,0)+"</b>").append(" : "+ws.getString(27)+"</font></td> ");
							     sb.append("<td width='25%' align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
											util.appendSpace("<b>Supplier Name</b>", 15,0)).append(" : "+ws.getString(6)+"</font></td> ");
							     
							     sb.append("</tr> ");
									}
			
							
							 sb.append("<tr colspan='4'> ");
			        		 sb.append("<td width='25%' align='center' colspan='4'><font face='Verdana, Arial, Helvetica, sans-serif' >").append(
										util.appendSpace("<b>Supplier Address</b>", 15,0)).append(" : "+ws.getString(22)+"</font></td> ");
							 sb.append("</tr> ");
			        		}
			
			        	}	
		        	sb.append("<table class='table' align='center' style='border-collapse: collapse; border: 1px solid;'>");
					
					sb.append("<tr bgcolor='#cdc9c9'> ");
					sb.append("<td  width='5%' align='left' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>S.No.</b></font></td>");
					sb.append("<td  width='25%' align='left' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>Item Name</b></font></td>");
					sb.append("<td  width='5%' align='left' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>RC S.No.</b></font> ");
					sb.append("</td>");
					
					sb.append("<td width='8%' align='left' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b align='left'>Batch No.</b></font> ");
					sb.append("</td> ");
					sb.append("</td> ");
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Invoice No</b></font> ");
					sb.append("</td> ");
					sb.append("<td align='center' width='10%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry</b></font></td>  ");
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font></td>  ");
					sb.append("<td align='center' width='27%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks</b></font></td>  ");
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Tax</b></font></td>  ");
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate(With Tax)</b></font></td>  ");
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty.</b></font></td>  ");
					sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total</b></font></td>  ");
				
					sb.append("</tr> ");
		
					
							
					ws.beforeFirst();	
					while (ws.next()) 
					{
						sb.append("<tr> ");
						sb.append("<td align='left' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(sno++);
						sb.append("</font></td> ");
						sb.append("<td align='left' width='25%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(3));
						sb.append("</font></td> ");
						sb.append("<td align='left' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(28));
						sb.append("</font></td> ");
						sb.append("<td align='left' width='8%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(4));
						sb.append("</font></td> ");

						sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(21));
						sb.append("</font></td> ");

						sb.append("<td align='center' width='10%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(7));
						sb.append("</font></td> ");
						
						sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(17));
						sb.append("</font></td> ");						
						
						sb.append("<td align='left' width='27%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(26));
						sb.append("</font></td> ");
						
						sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(24));
						sb.append("</font></td> ");
						
						sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(25));
						sb.append("</font></td> ");
						
						sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(18));
						sb.append("</font></td> ");
						
						sb.append("<td align='center' width='5%' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(19));
						sum1=sum1+Double.parseDouble(ws.getString(19));
						sb.append("</font></td> ");
						sb.append("</tr> ");
									
					 }
					sb.append("<tr>");
					
					
					
					sb.append("<td colspan='12' style='text-align: right;' ><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Return Total: "+HisUtil.getAmountWithDecimal(sum1,2)+"</font></td> ");
					sb.append("</tr> ");
					sb.append("<tr>");					
					sb.append("<td colspan='12' style='text-align: left;'><font size='2' face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:</b> "+Remarks+"</b></font></td> ");
					sb.append("</tr> ");
				} 
				else 
				{
		
					sb.append("<tr> ");
					sb.append("<td colspan='11' align='center' style='border: 1px solid;'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/>Details Not Available</font></td> ");
					sb.append("</tr> ");
		
				}
		        
				
				sb.append("</table> ");
		
			} catch (Exception e) {
		
				e.printStackTrace();
			}
		
			return sb.toString();
		   }
}