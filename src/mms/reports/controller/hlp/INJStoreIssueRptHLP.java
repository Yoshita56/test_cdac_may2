package mms.reports.controller.hlp;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.reports.vo.INJStoreIssueRptVO;

public class INJStoreIssueRptHLP {

	private static final String strColor = "red";
	private static final String defaultColor = "blue";

public static String getIssueDetails(INJStoreIssueRptVO vo) 
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
						+ "<tr> "
				        + " <td colspan='1'></td>"
						+ " <td colspan='1'></td>"
						+ " <td colspan='1'><br><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
				sb.append("</tr>");		
						
				sb.append("<tr> "
			        + " <td colspan='1'></td>"
			        + " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' ></div></td>"
					//+ " <td colspan='1'><div align='center'><img src='/INVMGM/hisglobal/images/" + vo.getStrLogoName() + "'></div></td>"
					+ " <td colspan='1'></td>");
				sb.append("</tr></table>");		
			
				sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>" + 
						"<tr> "
						+ " <td colspan='3'></td>"
						+ " <td colspan='3'align='center' style='font-size:15px'><b>Acknowledge Report For Issue</b></td>"
						+ " <td colspan='3'></td>");
				sb.append("</tr>");
				
				
				sb.append(" <tr><td align='center' colspan='3'></td> " +
				  "<td align='center' colspan='3'>" +
				  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				  "Acknowledged Store Name ::<b>"+vo.getStrStoreName()
				  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				  
				sb.append(" <tr><td align='center' colspan='3'></td> " +
				  "<td align='center' colspan='3'>" +
				  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
				  "For Item Category ::<b>"+vo.getStrCategoryName() 
				  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				 
				sb.append(" <tr><td align='center' colspan='3'></td> " +
						  "<td align='center' colspan='3'>" +
						  "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>" +
						  "For Item Name ::<b>"+vo.getStrlpItemName() 
						  +"</b></font></td><td align='center' colspan='2'></td></tr>");
				
				sb.append(" <tr> <td align='center' colspan='3'></td>"
				+ "<td align='center' colspan='3'>"
				+ "<font face='Verdana, Arial, Helvetica, sans-serif' size='2'>"						
				+ "From Date ::<b>"+vo.getStrFinancialStartYear()+"</b> To Date ::<b>"+vo.getStrFinancialEndYear()+"</b></font></td>"
						+ "<td align='center' colspan='2'>"
						+ "<div id='printid1' class='hidecontrol' style='float:right'>"
						+"</td></tr>");
				
				sb.append(" <tr> "
				        + " <td colspan='1'></td>"
						+ " <td colspan='1'></td>"
						+ " <td colspan='1'><br></td>");
				sb.append("</tr>");
			
				sb.append("</table>");
				sb.append("<table align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center'><b>S.No</b>");
			    sb.append("</td>");
		        sb.append("<td width='17%' align='center'><b>Issue No [Date] </b>");
			    sb.append("</td>");
			    sb.append("<td width='15%' align='center'><b>Supplier Name</b>");
			    sb.append("</td>");
			    sb.append("<td width='10%' align='center'><b>Ack By</b>");
			    sb.append("</td>");
			    sb.append("<td width='25%' align='center'><b>Item Name</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Batch No.</b>");
		        sb.append("</td>");
		        sb.append("<td width='10%' align='center'><b>Expiry Date</b>");
		        sb.append("</td>");
		        sb.append("<td width='8%' align='center'><b>Qty</b>");
		        sb.append("</td>");
		        sb.append("</tr>");
				while(ws.next())
				{		
							if(i==0)
							{
//								Quantity = Double.parseDouble(ws.getString(8));
//								totamt = Double.parseDouble(ws.getString(12));
							}
							else
							{
//								Quantity = Quantity + Double.parseDouble(ws.getString(8));
//								totamt = totamt + Double.parseDouble(ws.getString(12));
							}
					
							sb.append("<tr>");
							sb.append("<td  width='5%' align='center' >");							
							sb.append(i);											//	S.No				
							sb.append("</td>");
							sb.append("<td  width='17%' align='center' >");							
							sb.append(ws.getString(1));								//	Issue No/Issue Date				
							sb.append("</td>");
							sb.append("<td  width='15%' align='left'>");
							sb.append(ws.getString(15));							//	Supplier Name							
							sb.append("</td>");
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(14));							//	Ack By						
							sb.append("</td>");
							
							sb.append("<td  width='25%' align='left'>");
							sb.append(ws.getString(4));								//	Item Name
							sb.append("</td>");
							sb.append("<td  width='10%' align='center'>");								
							sb.append(ws.getString(5));								//	Batch No.					
							sb.append("</td>");
							sb.append("<td  width='10%' align='center'>");
							sb.append(ws.getString(6));								//	Expiry Date
							sb.append("</td>");
							
							sb.append("<td  width='8%' align='right'>");			//  Qty
							sb.append(ws.getString(8));									
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

public static String getBarCodeSave(INJStoreIssueRptVO vo,HttpServletRequest request) 
{
	StringBuffer sb = new StringBuffer("");
	WebRowSet ws = vo.getWsStockDtl();
	int i=1;
	double totamt = 0.00;
	double Quantity = 0.00;
	String strTableWidth = "825";
	int tot = 0;
    HisUtil hisUtil= null;
    HospitalMstVO hospitalVO=null;
    try 
    {
    
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
				
				hisUtil    = new HisUtil("Global","getBarCodeSave");
				//
				
				
				hospitalVO = hisUtil.getHospitalDetail(vo.getStrHospitalCode());
				
				
				sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				
				sb.append("<script language='Javascript' src='../../hisglobal/js/jquery-barcode.js'></script>");				
				sb.append("<tr><div id='printImg' align='right'><img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' /></div></td>");
				sb.append("</tr>");		
				
				sb.append("<tr>"
						+ "<td width='10%'>"
						//+ "<div><img src='/INVMGM/hisglobal/images/logo.png' width='100' style='margin-left: 100%;float: left;'></div></td> &nbsp;&nbsp;&nbsp;&nbsp;");
						+ "<div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png' width='100' style='margin-left: 100%;float: left;'></div></td> &nbsp;&nbsp;&nbsp;&nbsp;");
				
				sb.append("<td width='80%' align='center'><b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> &nbsp;&nbsp;&nbsp;");
				//sb.append(res.getString("REPORT_TITLE"));
				sb.append("&nbsp;&nbsp;&nbsp;"+hospitalVO.getHospitalName());
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");
				
				sb.append("<tr> ");
				sb.append("<td width='8%'>&nbsp;</td> ");
				sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
				sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
				//sb.append(res.getString("FULL_TITLE"));
				sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				sb.append("</tr> ");					
				sb.append("</table> ");	
				
				sb.append("<table class='table table-striped table-light border' align='center' cellpadding='1px' cellspacing='1px' bgcolor='' border='1px solid black' style='border-collapse:collapse;'>");
		        sb.append("<tr>");
		        sb.append("<td width='5%' align='center' class='py-4'><b>S.No</b>");
			    sb.append("</td>");
		        sb.append("<td width='35%' align='center' class='py-4'><b>Item Name</b>");
			    sb.append("</td>");
			    sb.append("<td width='60%' align='center' class='py-4'><b>Code</b>");
		        sb.append("</td>");			     
		        sb.append("</tr>");
		      	
				while(ws.next())
				{		
					 /* PKG_MMS_VIEW.proc_storeitem_brand_list [ Mode - 5]
				       1. HSTNUM_ITEMBRAND_ID ^ HSTSTR_BATCH_SL_NO @ HSTDT_EXPIRY_DATE @ hstnum_saleprice
				       2. Item Name		
				       3. IN Hand Qty	
				       4. P_KEY	       
				    */
								        
			      
							sb.append("<tr>");
							sb.append("<td  class='' width='5%' align='center' >");							
							sb.append(i);																		//	S.No				
							sb.append("</td>");
							sb.append("<td class=''   width='45%' align='left' >");							
							sb.append("<table cellspacing='1' id='' cellpadding='1' style=''>"+
						    			"<tr>"+
						    			"<td colspan='4' rowspan='1' align='left'>Name: <b><font size='1px;'>"+ws.getString(2)+"</font></b></td>"+			
						    			"</tr>"+
						    			"<tr>"+
						    			"<td colspan='4' rowspan='1' align='left'>Qty:<b><font size='1px;'>"+ws.getString(3)+" No.</font></b></td>"+
						    			"</tr>"+	    			 
						    			"<tr>"+
						    			"<td colspan='4' rowspan='1' align='left'>Batch:<font size='1px;'><b>"+(ws.getString(1).split("\\^")[1]).split("\\@")[0]+"</b></font></td>"+			
						    			"</tr>"+	
						    			"<tr>"+
						    			"<td colspan='4' rowspan='1' align='left'>Exp - Price:<font size='1px;'><b>"+(ws.getString(1).split("\\^")[1]).split("\\@")[1]+"</b></font></td>"+			
						    			"</tr>"+
						    			"</table>");														
							sb.append("</td>");
							
							sb.append("<input type='hidden' name='strPKey' id='strPKey" + i +"' value='"+ ws.getString(4)+"'/>");
							
							sb.append("<td class='' width='50%' align='left' >");
							sb.append("<input class='form-control' name='strVerifyCountedQty' id='strVerifyCountedQty"+i+"' type='text'>");//	Text Box			
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
//     System.out.println("sb"+sb);
       return sb.toString();
 }

public static String getBarCodeGeneration(INJStoreIssueRptVO vo,HttpServletRequest request) throws Exception 
{
	
	
	int i=1;
	double totamt = 0.00;
	double Quantity = 0.00;
	String strTableWidth = "825";
	int tot = 0;
    HisUtil hisUtil= null;
    HospitalMstVO hospitalVO=null;    
    StringBuilder sb = new StringBuilder();   
    int vouchersPerRow = 2; // Number of vouchers per row
    int vouchersPerPage = 16; // Number of vouchers per page
    int voucherCount = 0;

    try 
    {
        sb.append("<style>")
            .append("@media print { .page-break { page-break-before: always; } }")
            .append("</style>");

        WebRowSet ws = vo.getWsStockDtl();
        sb.append("<div>");
        sb.append("<table width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
        sb.append("<tr>")
            .append("<td colspan='3'>")
            .append("<div id='saveId' style='display: block'>")
            .append("<br><div id='printImg' class='hidecontrol' align='right'>")
            .append("<img style='cursor: pointer; margin-right: 0px' title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onclick='printDataOne()'>")
            .append("</div>")
            .append("</div>")
            .append("</td>")
            .append("</tr>");
             
        sb.append("</table>");

        // End of the table
        sb.append("</table>");

        // Start the vouchers table
        //sb.append("<table width='100%' align='center' cellpadding='1px' cellspacing='1px' style='border-collapse: collapse;'>");
        sb.append("<table style='margin-left:3%; margin-top:1%;border-collapse: collapse;' cellspacing='0' cellpadding='0' width='90%'>");

        while (ws.next()) 
        {
            if (voucherCount % vouchersPerPage == 0) 
            {
                // Start a new page for every 12 vouchers
                sb.append("<tr class='page-break'>");
            }

            if (voucherCount % vouchersPerRow == 0) 
            {
                // Start a new row for every 4 vouchers
                sb.append("<tr>");
            }
                     
           // sb.append("<td style='border: 2px dotted #000; padding: 11px;'>");
            sb.append("<td style='padding: 11px;'>");
           
           
            /* PKG_MMS_VIEW.proc_storeitem_brand_list [ Mode - 5]
		       1. HSTNUM_ITEMBRAND_ID # HSTSTR_BATCH_SL_NO @ HSTDT_EXPIRY_DATE # hstnum_saleprice
		       2. Item Name				       
		    */
			int fixedLength = 20;
	        
	        // Truncate to the fixed length
	        String truncatedString = ws.getString(2).length() > fixedLength ? ws.getString(2).substring(0, fixedLength) : ws.getString(2);
	        //System.out.println("Truncated: '" + truncatedString + "'");
	        
	        sb.append("<table cellspacing='1' id='barcodeTable' cellpadding='1' style='margin-left:65px'>"+
	    			"<tr>"+
	    			"<td colspan='4' nowrap='nowrap' align='left'><b><font size='1px;'>"+truncatedString+"</font></b></td>"+			
	    			"</tr>"+
	    			"<tr>"+
	    			"<td colspan='3' rowspan='1' align='left'><p class='divBarcodeSlipControls' id='divBarCodeControlCrNo' style=''>"+ws.getString(1).split("\\@")[0]+"</p></td>"+
	    			"</tr>"+	    			 
	    			"<tr>"+
	    			"<td colspan='4' rowspan='1' align='left'><font size='1px;'><b>"+ws.getString(1).split("\\@")[1]+"</b></font></td>"+			
	    			"</tr>"+	    			
	    			"</table>");
            sb.append("</td>");

            if ((voucherCount + 1) % vouchersPerRow == 0) {
                // End the row after every 4 vouchers
                sb.append("</tr>");
            }

            if ((voucherCount + 1) % vouchersPerPage == 0) {
                // End the page after every 12 vouchers
                sb.append("</tr>");
            }

            i++;
            voucherCount++;
        }

        // Close any open row
        if (voucherCount % vouchersPerRow != 0) {
            sb.append("</tr>");
        }

        // Close any open page
        if (voucherCount % vouchersPerPage != 0) {
            sb.append("</tr>");
        }

        // End the vouchers table
        sb.append("</table>");

        // End the main container


    } catch (Exception e) {
        e.printStackTrace();
        throw e;
    }

    return sb.toString();
}





}