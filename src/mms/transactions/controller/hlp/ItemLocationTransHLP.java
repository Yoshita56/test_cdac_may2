/**
 * 
 */
package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import java.text.DecimalFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.ItemLocationTransVO;

/**
 * Developer : Tanvi sappal
 * Version : 1.0
 * Date : 18/Jun/2009
 */
public class ItemLocationTransHLP 
{
	
	
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
	public static String getPrintStockDtl(ItemLocationTransVO vo, WebRowSet ws) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		String strStoreName = "";
		String batchNo = "0";
		String avlQty = "";
		String expiryDt = "";
		String stockStatus = "";
		String reservedQty = "";
		String blockedQty = "";
		String unitName = "",itemBrandName="";
		String activeQty = "";
		String inActiveQty = "";
		String quarantineQty = "";		
		int i=1;
		int count = 0;	
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
				
 		
		String strTableWidth = "700";
 		DecimalFormat myFormatter = new DecimalFormat("0.00");
 		Double activeQtyTotal=0.00,inActiveQtyTotal=0.00,quarantineQtyTotal=0.00;
		try 
		{
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td align='center'><div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>");
			sb.append("</tr>");	
			sb.append("</table>");
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			
			sb.append("<tr>");
			sb.append("<td width='10%'></td>");			
			sb.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append(res.getString("REPORT_TITLE"));
			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr>");			
			sb.append("<tr>");
			sb.append("<td width='8%'>&nbsp;</td> ");
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
			sb.append("Stock Detail(s)");
			sb.append("</font></b></td><td width='10%'>&nbsp;</td> ");
			sb.append("</tr>");
			sb.append("</table> ");			
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(1);' /><img style='cursor: pointer; ' title='Get Back Report' src='../../hisglobal/images/stop.png' onClick='closePopup(1);' /></div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
            
			sb.append("<table width='").append(strTableWidth).append("' align='center' border='1px' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>SL No</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Store Name</b></font> ");
			sb.append("</td>");

			if(vo.getStrItemCategoryNo()!=null && vo.getStrItemCategoryNo().equals("10"))
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			else
				sb.append("<td align='center' width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font> ");
			sb.append("</td> ");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Active Qty</b></font> ");
			sb.append("</td> ");
			
			//sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>In-Active Qty</b></font> ");
			//sb.append("</td> ");
			
			//sb.append("<td align='center' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Quarantine Qty</b></font> ");
		//	sb.append("</td> ");
			
			sb.append("</tr> ");

			if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
				{
			
					strStoreName = ws.getString(8);
	            	batchNo = ws.getString(15);
	            	expiryDt = ws.getString(18);
	            	avlQty = ws.getString(9);
	            	stockStatus = ws.getString(40);
	            	reservedQty = ws.getString(41);
	            	blockedQty = ws.getString(42);
	            	unitName = ws.getString(43);
	            	itemBrandName=ws.getString(2);
	            	
	            	activeQty = ws.getString(44) + " " + unitName;
	            	inActiveQty = ws.getString(45) + " " + unitName;
	            	quarantineQty = ws.getString(46) + " " + unitName;
	            	
	            	//itemBrandName=ws.getString(13);
  					
  					if(strStoreName == null || strStoreName.equals("null") || strStoreName.equals(""))strStoreName = "---";
  					if(batchNo == null || batchNo.equals("null") || batchNo.equals("") )batchNo = "---";
  					if(avlQty == null || avlQty.equals("null") || avlQty.equals(""))avlQty = "---";
  					if(expiryDt == null || expiryDt.equals("null") || expiryDt.equals(""))expiryDt = "---";
  					if(stockStatus == null || stockStatus.equals("null") || stockStatus.equals(""))stockStatus = "---";
  					if(itemBrandName == null || itemBrandName.equals("null") || itemBrandName.equals(""))itemBrandName = "---";
  					
  					if(activeQty == null || activeQty.equals("null") || activeQty.equals(""))activeQty = "---";
  					if(inActiveQty == null || inActiveQty.equals("null") || inActiveQty.equals(""))inActiveQty = "---";
  					if(quarantineQty == null || quarantineQty.equals("null") || quarantineQty.equals(""))quarantineQty = "---";
					
					sb.append("<tr> ");					
					sb.append("<td align='center' width='3%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");					
					sb.append("<td style=\"text-align:left;\"  width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(strStoreName);
					sb.append("</font></td>");
					sb.append("<td style=\"text-align:left;\" width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(itemBrandName);
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:left;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(batchNo);
					sb.append("</font></td> ");					
					sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(expiryDt);
					sb.append("</font></td> ");
					sb.append("<td style=\"text-align:right;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(activeQty);
					sb.append("</font></td> ");					
//					sb.append("<td style=\"text-align:right;\" width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//					sb.append(inActiveQty);
//					sb.append("</font></td> ");					
//					sb.append("<td style=\"text-align:right;\" width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
//					sb.append(quarantineQty);
//					sb.append("</font></td> ");
					
					activeQtyTotal = activeQtyTotal +	Double.parseDouble(activeQty.split("\\ ")[0]);
  					inActiveQtyTotal    = inActiveQtyTotal	+ 	Double.parseDouble(inActiveQty.split("\\ ")[0]);
  					quarantineQtyTotal	= quarantineQtyTotal 	+ Double.parseDouble(quarantineQty.split("\\ ")[0]);
  					
					
					sb.append("</tr> ");	
					
					 
					 
					
					 
					
					i++;
					count++;
								
				}
				
				 sb.append("<tr>");
				 sb.append("<td width='3%'  style=\"text-align:right;\"></td>");
				 sb.append("<td width='12%'  style=\"text-align:right;\"></td>");
				 sb.append("<td width='2%'  style=\"text-align:right;\"></td>");
				 sb.append("<td width='10%'  style=\"text-align:right;\"></td>");
				 sb.append("<td width='15%'  style=\"text-align:right;\"><b></b></td>");
				 sb.append("<td width='10%'  style=\"text-align:right;\"><b>Total</b></td>");
				 sb.append("<td width='10%'  style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> <b>"+activeQtyTotal+" "+unitName+"</b></font></td>");
//				 sb.append("<td width='7%'  style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> <b>"+inActiveQtyTotal+" "+unitName+"</b></font></td>");
//				 sb.append("<td width='7%'  style=\"text-align:right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> <b>"+quarantineQtyTotal+" "+unitName+"</b></font></td>");
				 sb.append("</tr>");
			}	
			else 
			{

				sb.append("<tr> ");
				sb.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Detail(s) Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}
	
	/*
	public static String createStockDetails2(ItemLocationTransVO vo, WebRowSet ws) throws Exception {
	    // Initialize StringBuilder to store generated HTML
	    StringBuilder br = new StringBuilder();
	    
	    // Constants for pagination
	    int start = 1;
	    final int REC_PER_PAGE = 500;
	    final int PAGE_PER_BLOCK = 50;

	    // Calculate total records to fetch and manipulate
	    int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
	    int totalRecordsToManipulate = totalFetchRecord - 1;

	    // Variables to store fetched data
	    String strStoreName = "";
	    String batchNo = "0";
	    String avlQty = "";
	    String expiryDt = "";
	    String stockStatus = "";
	    String reservedQty = "";
	    String blockedQty = "";
	    String unitName = "";
	    String itemBrandName = "";
	    String activeQty = "";
	    String inActiveQty = "";
	    String quarantineQty = "";
	    int activeQtyTotal = 0, inActiveQtyTotal = 0, quarantineQtyTotal = 0;
	    String mrp, branded;
	    int count = 0;

	    try {
	        // Check if WebRowSet is not null
	        if (ws != null) {
	            // Log size of WebRowSet
	            System.out.println("createStockDetails2 ws size : " + ws.size());

	            // Check if WebRowSet has records
	            if (ws.size() > 0) {
	                // Get actual number of records
	                int actualFetchRecord = ws.size();

	                // Adjust total fetch records if actual count is less
	                if (totalFetchRecord != actualFetchRecord) {
	                    totalFetchRecord = actualFetchRecord;
	                    totalRecordsToManipulate = actualFetchRecord;
	                }

	                // Calculate total pages based on records per page
	                int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
	                int reminder = totalRecordsToManipulate % REC_PER_PAGE;
	                if (reminder > 0) {
	                    totalLayer = totalLayer + 1;
	                }

	                // Add hidden fields for pagination control
	                br.append("<input type='hidden' name='TotalLayer' value='").append(totalLayer).append("'>");
	                br.append("<input type='hidden' name='RecordShowOnPage' value='").append(REC_PER_PAGE).append("'>");

	                // Generate pagination links
	                br.append("<nav aria-label='Page navigation example'>");
	                br.append("<ul class='pagination justify-content-center'>");
	                for (int j = 1; j <= totalLayer; j++) {
	                    br.append("<li class='page-item'><a class='page-link' href='#' onclick='GetIndex(\"")
	                        .append(j).append("\",\"").append(totalLayer).append("\")'>")
	                        .append((j + start - 1)).append("</a></li>");
	                }
	                br.append("</ul>");
	                br.append("</nav>");

	                // Begin table for displaying stock details
	                br.append("<div class='table-responsive'>");
	                br.append("<table class='table table-striped table-bordered table-hover'>");
	                br.append("<thead class='thead-dark'>");
	                br.append("<tr style='color: #fefefe; background-color: #7eb2e5; border-color: #10101036; text-transform: uppercase;'>"); // Added CSS for uppercase and other styles
	                br.append("<th scope='col'>S.No.</th>");
	                br.append("<th scope='col'>Store Name</th>");
	                br.append("<th scope='col'>Batch No</th>");
	                br.append("<th scope='col'>Cost To Patient/Unit</th>");
	                br.append("<th scope='col'>Expiry Date</th>");
	                br.append("<th scope='col'>Total Qty(No.)</th>");
	                br.append("</tr>");
	                br.append("</thead>");
	                br.append("<tbody>");

	                // Loop through each layer of records
	                for (int j = 1; j <= totalLayer; j++) {
	                    br.append("<div id='DivId").append(j).append("' style='display:").append(j == 1 ? "block" : "none").append("'>");
	                    for (int k = 1; k <= REC_PER_PAGE; k++) {
	                        if (ws.next()) {
	                            // Fetch data from WebRowSet
	                            strStoreName = ws.getString(8);
	                            batchNo = ws.getString(15);
	                            expiryDt = ws.getString(18);
	                            avlQty = ws.getString(9);
	                            stockStatus = ws.getString(40);
	                            reservedQty = ws.getString(41);
	                            blockedQty = ws.getString(42);
	                            unitName = ws.getString(43);
	                            itemBrandName = ws.getString(2);
	                            activeQty = ws.getString(44);
	                            inActiveQty = ws.getString(45);
	                            quarantineQty = ws.getString(46);
	                            mrp = ws.getString(38);
	                            String[] newmrp = mrp.split("/");
	                            mrp = "INR" + " " + newmrp[0];
	                            branded = ws.getString(47);

	                            // Handle null or empty values
	                            if (strStoreName == null || strStoreName.equals("null") || strStoreName.equals(""))
	                                strStoreName = "---";
	                            if (batchNo == null || batchNo.equals("null") || batchNo.equals(""))
	                                batchNo = "---";
	                            if (avlQty == null || avlQty.equals("null") || avlQty.equals(""))
	                                avlQty = "---";
	                            if (expiryDt == null || expiryDt.equals("null") || expiryDt.equals(""))
	                                expiryDt = "---";
	                            if (stockStatus == null || stockStatus.equals("null") || stockStatus.equals(""))
	                                stockStatus = "---";
	                            if (itemBrandName == null || itemBrandName.equals("null") || itemBrandName.equals(""))
	                                itemBrandName = "---";

	                            if (activeQty == null || activeQty.equals("null") || activeQty.equals(""))
	                                activeQty = "---";
	                            if (inActiveQty == null || inActiveQty.equals("null") || inActiveQty.equals(""))
	                                inActiveQty = "---";
	                            if (quarantineQty == null || quarantineQty.equals("null") || quarantineQty.equals(""))
	                                quarantineQty = "---";

	                            // Append table row with fetched data
	                            br.append("<tr>");
	                            br.append("<th scope='row'>").append(k).append("</th>");
	                            br.append("<td>").append(strStoreName).append("</td>");
	                            br.append("<td>").append(batchNo).append("</td>");
	                            br.append("<td>").append(mrp).append("</td>");
	                            br.append("<td>").append(expiryDt).append("</td>");
	                            br.append("<td>").append(activeQty)
	                                .append("<input type='hidden' name='strAvlQty' id='strAvlQty").append(count).append("' value='")
	                                .append(reservedQty).append(" ").append("@").append(blockedQty).append("'/></td>");
	                            br.append("</tr>");

	                            // Calculate totals
	                            activeQtyTotal += Integer.parseInt(activeQty.split(" ")[0]);
	                            inActiveQtyTotal += Integer.parseInt(inActiveQty.split(" ")[0]);
	                            quarantineQtyTotal += Integer.parseInt(quarantineQty.split(" ")[0]);
	                            count++;
	                        } else {
	                            break;
	                        }
	                    }
	                    br.append("</div>");
	                }

	                // End table body and table
	                br.append("</tbody>");
	                br.append("</table>");

	                // Display total quantities
	                br.append("<div class='table-responsive'>");
	                br.append("<table class='table table-bordered'>");
	                br.append("<tr>");
	                br.append("<td colspan='4' class='text-right'><b>Grand Total Qty</b></td>");
	                br.append("<td class='text-right font-weight-bold'>").append(activeQtyTotal).append("</td>");
	                br.append("</tr>");
	                br.append("</table>");
	                br.append("</div>");

	                // Close the main div
	                br.append("</div>");
	            } else {
	                // Display message if no records found
	                br.append("<div class='alert alert-warning' role='alert'>No Record Available</div>");
	            }
	        }
	    } catch (Exception e) {
	        // Exception handling
	        throw new Exception(e.getMessage());
	    } finally {
	        // Clean up resources
	        ws = null;
	    }

	    // Add tableDiv at its exact location in the original code
	    br.insert(br.indexOf("</tbody>"), "<div id='tableDiv'></div>");

	    // Return the generated HTML as a string
	    return br.toString();
	} */




	
	public static String createStockDetails2(ItemLocationTransVO vo, WebRowSet ws)throws Exception
		{ 
			StringBuffer br = new StringBuffer();
			int start = 1;
			final int REC_PER_PAGE = 500;
			final int PAGE_PER_BLOCK = 50;
			
			int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
			int totalRecordsToManipulate = totalFetchRecord - 1;
			
			String strStoreName = "";
			String batchNo = "0";
			String avlQty = "";
			String expiryDt = "";
			String stockStatus = "";
			String reservedQty = "";
			String blockedQty = "";
			String unitName = "",itemBrandName="";
			String activeQty = "";
			String inActiveQty = "";
			String quarantineQty = "";
			int activeQtyTotal=0,inActiveQtyTotal=0,quarantineQtyTotal=0;
			String mrp,branded;
			int count=0;
			
			try
			{
				if(ws != null )
				{
					
					System.out.println("createStockDetails2 ws size : "+ws.size());
					
		            if(ws.size() > 0)
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
		   			 
			   			br.append("<input type='hidden' name='TotalLayer'  value='").append(totalLayer).append("'>");
			   			br.append("<input type='hidden' name='RecordShowOnPage'  value='").append(REC_PER_PAGE).append("'>");
						
						  br.
						  append("<table class='table table-striped text-uppercase' align='center' cellspacing='1px'>"
						  );
						  br.append("<tr>");
						  br.append("<td class='LABEL' >");
						  
						  for (int j = 1; j <= totalLayer; j++) { br.
						  append("<a STYLE='cursor:pointer;cursor:pointer;color:black;' color:'blue;' onClick='GetIndex(\""
						  ).append(j).append("\",\"").append(totalLayer).append("\")'>" ).append(
						  (j+start-1) ).append( "</a> &nbsp;"); } 
						  br.append("</td>");
						  br.append("</tr>"); //
						  //br.append("<tr><td class='LABEL'><div id='pageNavPosition'></div></td></tr>"); 
						  br.append("</table>");
						 
			   			
			   			br.append("<div style='overflow-x:auto; margin-top:-15px;' id='tableDiv'>");
						/*
						 * br.append("<table  class='table'>"); br.append("<thead>");
						 * br.append("<td colspan='7'>Stock Details</td>"); br.append("</tr></table>");
						 */
			   			
						br.append("<table  class='table table-striped text-uppercase' id='example'>");
						br.append("<thead class='multiPOControl' style='color:grey;'>");
						br.append("<tr>");
						if(vo.getStrItemCategoryNo()!=null && vo.getStrItemCategoryNo().equals("1")){
							br.append("<tr><th><div align='center'><b>S.No.</b></div></th>");
							br.append("<th><div align='center'><b>Store Name</b></div></th>");
							/* br.append("<th><div align='left'><b>Drug Name</b></div></th>"); */
						}else{
							br.append("<tr><th><div align='center'><b>S.No.</b></div></th>");
							br.append("<th><div align='center'><b>Store Name</b></div></th>");
							/* br.append("<th><div align='center'><b>Item Name</b></div></th>"); */
						}
			  	        br.append("<th><div align='center'><b>Batch No</b></div></th>");
			  	        br.append("<th><div align='center'><b>Cost To Patient/Unit</b></div></th>");
			  	        br.append("<th><div align='center'><b>Expiry Date</b></div></th>");
			  	        //br.append("<th><div align='right'><b>Branded/Non-Branded</b></div></th>"); 
			  	        br.append("<th><div align='center'><b>Total Qty(No.)</b></div></th>");
			          //  br.append("<th width='10%' class='multiRPTLabel'><div align='center'>In-Active Qty</div></th>");
			          //  br.append("<td width='10%' class='multiRPTLabel'><div align='center'>Quarantine Qty</div></td>");
			            br.append("</tr>");
			            		br.append("</thead>");
			            		br.append("<tbody>");
			            for (int j = 1; j <= totalLayer; j++) 
					    {
							 if (j <= totalLayer) 
							 {
								 
								if (j == 1) 
								{
									br.append("<div id='DivId" ).append(j).append( "' style='display:block'>");
								} 
								else
								{
									br.append("<div id='DivId" ).append(j).append( "' style='display:none'>");
								}
								
								for (int k = 1; k <= REC_PER_PAGE; k++) 
								{
									
									if(ws.next())
									{
						            	strStoreName = ws.getString(8);
						            	batchNo = ws.getString(15);
						            	expiryDt = ws.getString(18);
						            	avlQty = ws.getString(9);
						            	stockStatus = ws.getString(40);
						            	reservedQty = ws.getString(41);
						            	blockedQty = ws.getString(42);
						            	unitName = ws.getString(43);
						            	itemBrandName=ws.getString(2);
						            	
										/*
										 * activeQty = ws.getString(44) + " " + unitName; inActiveQty = ws.getString(45)
										 * + " " + unitName; quarantineQty = ws.getString(46) + " " + unitName;
										 */
						            	activeQty = ws.getString(44);
						            	inActiveQty = ws.getString(45);
						            	quarantineQty = ws.getString(46);
						            	mrp=ws.getString(38);
						            	String newmrp[] = mrp.split("/");
						            	mrp="INR"+" "+newmrp[0];
						            	branded=ws.getString(47);
						            	//itemBrandName=ws.getString(13);
					  					
					  					if(strStoreName == null || strStoreName.equals("null") || strStoreName.equals(""))strStoreName = "---";
					  					if(batchNo == null || batchNo.equals("null") || batchNo.equals("") )batchNo = "---";
					  					if(avlQty == null || avlQty.equals("null") || avlQty.equals(""))avlQty = "---";
					  					if(expiryDt == null || expiryDt.equals("null") || expiryDt.equals(""))expiryDt = "---";
					  					if(stockStatus == null || stockStatus.equals("null") || stockStatus.equals(""))stockStatus = "---";
					  					if(itemBrandName == null || itemBrandName.equals("null") || itemBrandName.equals(""))itemBrandName = "---";
					  					
					  					if(activeQty == null || activeQty.equals("null") || activeQty.equals(""))activeQty = "---";
					  					if(inActiveQty == null || inActiveQty.equals("null") || inActiveQty.equals(""))inActiveQty = "---";
					  					if(quarantineQty == null || quarantineQty.equals("null") || quarantineQty.equals(""))quarantineQty = "---";
					  				
					  					br.append("<tr>");
					  					
					  					br.append("<td>"+ k +"</td>");
					  					br.append("<td>"+strStoreName+"</td>");
					  					
					  					//br.append("<td>");
					  					//br.append(itemBrandName);
					  					//br.append("<input type='hidden' name='strItemDetail' id='strItemDetail" +count+"' value='"+ws.getString(5)+"^"+ws.getString(19)+"^"+ws.getString(6)+"^"+ws.getString(25)+"^"+ws.getString(29)+"' /></td>");
					  					
					  					br.append("<td>"+batchNo+"</td>");
					  					br.append("<td>"+mrp+"</td>");
					  					br.append("<td>"+expiryDt+"</td>");
					  					
					  					//br.append("<td>"+branded+"</td>");
					  					br.append("<td> " +activeQty+"<input type='hidden' name='strAvlQty' id='strAvlQty" +count+"'"+
						  							"value='"+ reservedQty+" "+ "@"+ blockedQty +" " + "'/></td>");
					  					
					  			//		br.append("<td width='10%' class='multiPOControl' style=\"text-align: right;\">"+inActiveQty+"</td>");
					  			//		br.append("<td width='10%' class='multiPOControl' style=\"text-align: right;\">"+quarantineQty+"</td>");
					  					
					  					activeQtyTotal = activeQtyTotal +	Integer.parseInt(activeQty.split("\\ ")[0]);
					  					inActiveQtyTotal    = inActiveQtyTotal	+ 	Integer.parseInt(inActiveQty.split("\\ ")[0]);
					  					quarantineQtyTotal	= quarantineQtyTotal 	+ Integer.parseInt(quarantineQty.split("\\ ")[0]);
					  					
					  					
					  					br.append("</tr>");
					  					
									}else{
										break;
									}
									count++;
								}
								br.append("</div>");
								
								
							 }
							 ////
							 else 
							 {
								br.append("<div id='DivId" ).append( j).append( "' style='display:none'>");
								
								for (int l = 0; l < reminder; l++) 
								{
									ws.next();
									
									strStoreName = ws.getString(8);
					            	batchNo = ws.getString(15);
					            	expiryDt = ws.getString(18);
					            	avlQty = ws.getString(9);
					            	stockStatus = ws.getString(40);
					            	reservedQty = ws.getString(41);
					            	blockedQty = ws.getString(42);
					            	unitName = ws.getString(43);
					            	itemBrandName=ws.getString(2);
					            	mrp=ws.getString(38);
					            	activeQty = ws.getString(44) + " " + unitName;
					            	inActiveQty = Float.parseFloat(ws.getString(45)) + " " + unitName;
					            	quarantineQty = Float.parseFloat(ws.getString(46)) + " " + unitName;
					            	branded=ws.getString(47);
				  					if(strStoreName == null || strStoreName.equals("null") || strStoreName.equals(""))strStoreName = "---";
				  					if(batchNo == null || batchNo.equals("null") || batchNo.equals("") )batchNo = "---";
				  					if(avlQty == null || avlQty.equals("null") || avlQty.equals(""))avlQty = "---";
				  					if(expiryDt == null || expiryDt.equals("null") || expiryDt.equals(""))expiryDt = "---";
				  					if(stockStatus == null || stockStatus.equals("null") || stockStatus.equals(""))stockStatus = "---";
				  					if(itemBrandName == null || itemBrandName.equals("null") || itemBrandName.equals(""))itemBrandName = "---";
				  					
				  					if(activeQty == null || activeQty.equals("null") || activeQty.equals(""))activeQty = "---";
				  					if(inActiveQty == null || inActiveQty.equals("null") || inActiveQty.equals(""))inActiveQty = "---";
				  					if(quarantineQty == null || quarantineQty.equals("null") || quarantineQty.equals(""))quarantineQty = "---";
				  				
				  					br.append("<tr>");
				  					br.append("<td>"+strStoreName+"</td>");
				  					
				  					//br.append("<td>");
				  					//br.append(itemBrandName);
				  					//br.append("<input type='hidden' name='strItemDetail' id='strItemDetail" +count+"' value='"+ws.getString(5)+"^"+ws.getString(19)+"^"+ws.getString(6)+"^"+ws.getString(25)+"^"+ws.getString(29)+"' /></td>");
				  					
				  					br.append("<td>"+batchNo+"</td>");
				  					br.append("<td>"+mrp+"</td>");
				  					br.append("<td>"+expiryDt+"</td>");
				  					//br.append("<td>"+branded+"</td>");
				  					
				  					br.append("<td"+activeQty+"<input type='hidden' name='strAvlQty' id='strAvlQty" +count+"'"+
					  							"value='"+ reservedQty+" "+unitName+ "@"+ blockedQty + "'/></td>");
				  					
				  					
				  				//	br.append("<td width='10%' class='multiPOControl'>"+inActiveQty+"</td>");
				  				//	br.append("<td width='10%' class='multiPOControl'>"+quarantineQty+"</td>");
				  					
				  					activeQtyTotal = activeQtyTotal +	Integer.parseInt(activeQty.split("\\ ")[0]);
				  					inActiveQtyTotal    = inActiveQtyTotal	+ 	Integer.parseInt((inActiveQty.split("\\ ")[0]).toString());
				  					quarantineQtyTotal	= quarantineQtyTotal 	+ Integer.parseInt(quarantineQty.split("\\ ")[0]);
				  					
				  					br.append("</tr>");
				  					count++;
								
								}
								br.append("</div>");
															
							 }
							 ////
						 //br.append("</td>");
						 //br.append("</tr>");
						 
						 
					    }
			            br.append("<tbody>");	
						br.append("</table>");
			            
			            if(actualFetchRecord< (REC_PER_PAGE-1))
					    {
						 br.append("<div id='totalDivId' style='display:block'>");	    	
					    }					    
					    else
					    {
					    	br.append("<div id='totalDivId' style='display:none'>");	
					    }
					 	
						
						/*
						 * br.
						 * append("<table class='TABLEWIDTH' align='center' cellspacing='1px'  cellpadding='1px'>"
						 * ); br.append("<tr>");
						 * br.append("<td width='15%' class='multiPOControl'></td>");
						 * br.append("<td width='25%' class='multiPOControl'></td>");
						 * br.append("<td width='15%' class='multiPOControl'></td>");
						 * br.append("<td width='15%' class='multiPOControl'><b></b></td>"); br.
						 * append("<td width='15%' class='multiPOControl'><div align='right'><b>Total</b></div></td>"
						 * ); br.
						 * append("<td width='10%' class='multiPOControl' style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> "
						 * +activeQtyTotal+" "+unitName+"</font></td>"); // br.
						 * append("<td width='10%' class='multiPOControl' style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> "
						 * +inActiveQtyTotal+" "+unitName+"</font></td>"); // br.
						 * append("<td width='10%' class='multiPOControl' style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> "
						 * +quarantineQtyTotal+" "+unitName+"</font></td>"); br.append("</tr>");
						 * br.append("</table>"); br.append("</div>");
						 */
					}
					else{
						br.append("<div style='overflow-x:auto;'>");
						br.append("<table class='table table-striped text-uppercase' id='example1'>");
			   			br.append("<tr >");
						br.append("<td colspan='7'><font color='red'>No Record Available</font></td>");
						br.append("</tr>");
						br.append("</table>");
						br.append("</div>");
						
					}
				}
				   br.append("</table>");
				   br.append("<div id='totalDiv'>");
				   br.append("<table class='TABLEWIDTH text-uppercase' align='center' cellspacing='1px'  cellpadding='1px'>");
					 br.append("<tr>");
					 br.append("<td width='15%' class='multiPOControl'></td>");
					 br.append("<td width='25%' class='multiPOControl'></td>");
					 br.append("<td width='15%' class='multiPOControl'></td>");
					 br.append("<td width='15%' class='multiPOControl'><b></b></td>");
						 
					 br.append("<td width='15%' class='multiPOControl'><div align='right'><b>Grand Total Qty</b></div></td>");
					 br.append("<td width='10%' class='multiPOControl' style=\"text-align: right;font-weight: bold;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> "+activeQtyTotal+"</font></td>");
					// br.append("<td width='10%' class='multiPOControl' style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> "+inActiveQtyTotal+" "+unitName+"</font></td>");
					// br.append("<td width='10%' class='multiPOControl' style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> "+quarantineQtyTotal+" "+unitName+"</font></td>");
					 br.append("</tr>");
					 br.append("</table>");
					 br.append("</div>");
					 br.append("</div>");
				   
				   
					
			}catch(Exception e){
			
					//System.out.println("Error"+e.getMessage());
					throw new Exception(e.getMessage());
				
			}
			finally
			{
				ws=null;
				
			}
		return br.toString();
		}



	public static String createStockDetails1(ItemLocationTransVO vo, WebRowSet ws)throws Exception
	{ 
		StringBuffer br = new StringBuffer();
		int start = 1;
		final int REC_PER_PAGE = 500;
		final int PAGE_PER_BLOCK = 50;
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
		String strStoreName = "";
		String batchNo = "0";
		String avlQty = "";
		String expiryDt = "";
		String stockStatus = "";
		String reservedQty = "";
		String blockedQty = "";
		String unitName = "",itemBrandName="";
		String activeQty = "";
		String inActiveQty = "";
		String quarantineQty = "";
		int activeQtyTotal=0,inActiveQtyTotal=0,quarantineQtyTotal=0;
		String mrp,branded;
		int count=0;
		
		try
		{
			if(ws != null )
			{
				
				//System.out.println("ws size : "+ws.size());
				
	            if(ws.size() > 0)
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
	   			 
		   			br.append("<input type='hidden' name='TotalLayer'  value='").append(totalLayer).append("'>");
		   			br.append("<input type='hidden' name='RecordShowOnPage'  value='").append(REC_PER_PAGE).append("'>");
		   			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
		   			
		   			br.append("<td class='LABEL' >");
		   			
	   			    for (int j = 1; j <= totalLayer; j++)
		   			{
			   			br.append("<a STYLE='cursor:pointer;cursor:pointer;' color:'blue' onClick='GetIndex(\"").append(j).append("\",\"").append(totalLayer).append("\")'>" ).append( (j+start-1)
			   					).append( "</a> &nbsp;");
		   			}
		   			br.append("</td>");
		   			br.append("</tr>");
		   		//	br.append("<tr><td class='LABEL'><div id='pageNavPosition'></div></td></tr>");
		   			br.append("</table>");
	            	
					br.append("<table  class='TABLEWIDTH' align='center' cellpadding='1px'  cellspacing='1px'>");
					br.append("<tr class='TITLE'>");
					br.append("<td colspan='7'>Stock Details</td>");
					br.append("</tr></table>");
					br.append("<table  class='TABLEWIDTH' align='center' cellpadding='1px'   cellspacing='1px'>");
					br.append("<tr>");
					if(vo.getStrItemCategoryNo()!=null && vo.getStrItemCategoryNo().equals("1")){
						br.append("<tr><td width='15%' class='multiRPTLabel'><div align='left'><b>Store Name</b></div></td>");
						br.append("<td width='25%' class='multiRPTLabel'><div align='left'><b>Drug Name</b></div></td>");
					}else{
						br.append("<tr><td width='15%' class='multiRPTLabel'><div align='left'><b>Store Name</b></div></td>");
						br.append("<td width='25%' class='multiRPTLabel'><div align='left'><b>Item Name</b></div></td>");
					}
		  	        br.append("<td width='15%' class='multiRPTLabel'><div align='left'><b>Batch No</b></div></td>");
		  	        br.append("<td width='10%' class='multiRPTLabel'><div align='center'><b>MRP</b></div></td>");
		  	        br.append("<td width='10%' class='multiRPTLabel'><div align='left'><b>Expiry Date</b></div></td>");
		  	        br.append("<td width='15%' class='multiRPTLabel'><div align='right'><b>Branded/Non-Branded</b></div></td>");
		  	        br.append("<td width='15%' class='multiRPTLabel'><div align='right'><b>Active Qty</b></div></td>");
		          //  br.append("<td width='10%' class='multiRPTLabel'><div align='center'>In-Active Qty</div></td>");
		          //  br.append("<td width='10%' class='multiRPTLabel'><div align='center'>Quarantine Qty</div></td>");
		            br.append("</tr></table>");
				 	
		            for (int j = 1; j <= totalLayer; j++) 
				    {
						 if (j <= totalLayer) 
						 {
							 
							if (j == 1) 
							{
								br.append("<div id='DivId" ).append(j).append( "' style='display:block'>");
							} 
							else
							{
								br.append("<div id='DivId" ).append(j).append( "' style='display:none'>");
							}
							
							br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'  cellpadding='1px'>");
							for (int k = 0; k < REC_PER_PAGE; k++) 
							{
							
								if(ws.next())
								{
					            	strStoreName = ws.getString(8);
					            	batchNo = ws.getString(15);
					            	expiryDt = ws.getString(18);
					            	avlQty = ws.getString(9);
					            	stockStatus = ws.getString(40);
					            	reservedQty = ws.getString(41);
					            	blockedQty = ws.getString(42);
					            	unitName = ws.getString(43);
					            	itemBrandName=ws.getString(2);
					            	
					            	activeQty = ws.getString(44) + " " + unitName;
					            	inActiveQty = ws.getString(45) + " " + unitName;
					            	quarantineQty = ws.getString(46) + " " + unitName;
					            	mrp=ws.getString(38);
					            	branded=ws.getString(47);
					            	//itemBrandName=ws.getString(13);
				  					
				  					if(strStoreName == null || strStoreName.equals("null") || strStoreName.equals(""))strStoreName = "---";
				  					if(batchNo == null || batchNo.equals("null") || batchNo.equals("") )batchNo = "---";
				  					if(avlQty == null || avlQty.equals("null") || avlQty.equals(""))avlQty = "---";
				  					if(expiryDt == null || expiryDt.equals("null") || expiryDt.equals(""))expiryDt = "---";
				  					if(stockStatus == null || stockStatus.equals("null") || stockStatus.equals(""))stockStatus = "---";
				  					if(itemBrandName == null || itemBrandName.equals("null") || itemBrandName.equals(""))itemBrandName = "---";
				  					
				  					if(activeQty == null || activeQty.equals("null") || activeQty.equals(""))activeQty = "---";
				  					if(inActiveQty == null || inActiveQty.equals("null") || inActiveQty.equals(""))inActiveQty = "---";
				  					if(quarantineQty == null || quarantineQty.equals("null") || quarantineQty.equals(""))quarantineQty = "---";
				  				
				  					br.append("<tr>");
				  					br.append("<td width='15%' class='multiPOControl' style=\"text-align: left;\">"+strStoreName+"</td>");
				  					
				  					br.append("<td class='multiPOControl' width='25%'>");
				  					br.append(itemBrandName);
				  					br.append("<input type='hidden' name='strItemDetail' id='strItemDetail" +count+"' value='"+ws.getString(5)+"^"+ws.getString(19)+"^"+ws.getString(6)+"^"+ws.getString(25)+"^"+ws.getString(29)+"' /></td>");
				  					
				  					br.append("<td width='15%' class='multiPOControl' style=\"text-align: left;\">"+batchNo+"</td>");
				  					br.append("<td width='10%' class='multiPOControl' style=\"text-align: center;\">"+mrp+"</td>");
				  					br.append("<td width='10%' class='multiPOControl'>"+expiryDt+"</td>");
				  					
				  					br.append("<td width='15%' class='multiPOControl' style=\"text-align: center;\">"+branded+"</td>");
				  					br.append("<td width='15%' class='multiPOControl' style=\"text-align: right;\"> " +activeQty+"<input type='hidden' name='strAvlQty' id='strAvlQty" +count+"'"+
					  							"value='"+ reservedQty+" "+unitName+ "@"+ blockedQty +" "+unitName + "'/></td>");
				  					
				  			//		br.append("<td width='10%' class='multiPOControl' style=\"text-align: right;\">"+inActiveQty+"</td>");
				  			//		br.append("<td width='10%' class='multiPOControl' style=\"text-align: right;\">"+quarantineQty+"</td>");
				  					
				  					activeQtyTotal = activeQtyTotal +	Integer.parseInt(activeQty.split("\\ ")[0]);
				  					inActiveQtyTotal    = inActiveQtyTotal	+ 	Integer.parseInt(inActiveQty.split("\\ ")[0]);
				  					quarantineQtyTotal	= quarantineQtyTotal 	+ Integer.parseInt(quarantineQty.split("\\ ")[0]);
				  					
				  					
				  					br.append("</tr>");
				  					
								}else{
									break;
								}
								count++;
							}
							br.append("</table>");
							br.append("</div>");
						 }
						 ////
						 else 
						 {
							br.append("<div id='DivId" ).append( j).append( "' style='display:none'>");
							
							br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
							for (int l = 0; l < reminder; l++) 
							{
								ws.next();
								
								strStoreName = ws.getString(8);
				            	batchNo = ws.getString(15);
				            	expiryDt = ws.getString(18);
				            	avlQty = ws.getString(9);
				            	stockStatus = ws.getString(40);
				            	reservedQty = ws.getString(41);
				            	blockedQty = ws.getString(42);
				            	unitName = ws.getString(43);
				            	itemBrandName=ws.getString(2);
				            	mrp=ws.getString(38);
				            	activeQty = ws.getString(44) + " " + unitName;
				            	inActiveQty = Float.parseFloat(ws.getString(45)) + " " + unitName;
				            	quarantineQty = Float.parseFloat(ws.getString(46)) + " " + unitName;
				            	branded=ws.getString(47);
			  					if(strStoreName == null || strStoreName.equals("null") || strStoreName.equals(""))strStoreName = "---";
			  					if(batchNo == null || batchNo.equals("null") || batchNo.equals("") )batchNo = "---";
			  					if(avlQty == null || avlQty.equals("null") || avlQty.equals(""))avlQty = "---";
			  					if(expiryDt == null || expiryDt.equals("null") || expiryDt.equals(""))expiryDt = "---";
			  					if(stockStatus == null || stockStatus.equals("null") || stockStatus.equals(""))stockStatus = "---";
			  					if(itemBrandName == null || itemBrandName.equals("null") || itemBrandName.equals(""))itemBrandName = "---";
			  					
			  					if(activeQty == null || activeQty.equals("null") || activeQty.equals(""))activeQty = "---";
			  					if(inActiveQty == null || inActiveQty.equals("null") || inActiveQty.equals(""))inActiveQty = "---";
			  					if(quarantineQty == null || quarantineQty.equals("null") || quarantineQty.equals(""))quarantineQty = "---";
			  				
			  					br.append("<tr>");
			  					br.append("<td width='15%' class='multiPOControl'>"+strStoreName+"</td>");
			  					
			  					br.append("<td class='multiPOControl' width='25%'>");
			  					br.append(itemBrandName);
			  					br.append("<input type='hidden' name='strItemDetail' id='strItemDetail" +count+"' value='"+ws.getString(5)+"^"+ws.getString(19)+"^"+ws.getString(6)+"^"+ws.getString(25)+"^"+ws.getString(29)+"' /></td>");
			  					
			  					br.append("<td width='15%' class='multiPOControl'>"+batchNo+"</td>");
			  					br.append("<td width='10%' class='multiPOControl' style=\"text-align: center;\" >"+mrp+"</td>");
			  					br.append("<td width='15%' class='multiPOControl'>"+expiryDt+"</td>");
			  					br.append("<td width='15%' class='multiPOControl' style=\"text-align: right;\">"+branded+"</td>");
			  					
			  					br.append("<td width='10%' class='multiPOControl'"+activeQty+"<input type='hidden' name='strAvlQty' id='strAvlQty" +count+"'"+
				  							"value='"+ reservedQty+" "+unitName+ "@"+ blockedQty +" "+unitName + "'/></td>");
			  					
			  					
			  				//	br.append("<td width='10%' class='multiPOControl'>"+inActiveQty+"</td>");
			  				//	br.append("<td width='10%' class='multiPOControl'>"+quarantineQty+"</td>");
			  					
			  					activeQtyTotal = activeQtyTotal +	Integer.parseInt(activeQty.split("\\ ")[0]);
			  					inActiveQtyTotal    = inActiveQtyTotal	+ 	Integer.parseInt((inActiveQty.split("\\ ")[0]).toString());
			  					quarantineQtyTotal	= quarantineQtyTotal 	+ Integer.parseInt(quarantineQty.split("\\ ")[0]);
			  					
			  					br.append("</tr>");
			  					count++;
							
							}
							br.append("</table>");
							br.append("</div>");
						 }
						 ////
					 br.append("</td>");
					 br.append("</tr>");
					 
					 
					
					 br.append("</table>");
					 
				    }
		            
		            if(actualFetchRecord< (REC_PER_PAGE-1))
				    {
					 br.append("<div id='totalDivId' style='display:block'>");	    	
				    }					    
				    else
				    {
				    	br.append("<div id='totalDivId' style='display:none'>");	
				    }
				 	
					
					 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'  cellpadding='1px'>");
					 br.append("<tr>");
					 br.append("<td width='15%' class='multiPOControl'></td>");
					 br.append("<td width='25%' class='multiPOControl'></td>");
					 br.append("<td width='15%' class='multiPOControl'></td>");
					 br.append("<td width='15%' class='multiPOControl'><b></b></td>");
					 br.append("<td width='15%' class='multiPOControl'><div align='right'><b>Total</b></div></td>");
					 br.append("<td width='10%' class='multiPOControl' style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> "+activeQtyTotal+" "+unitName+"</font></td>");
					// br.append("<td width='10%' class='multiPOControl' style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> "+inActiveQtyTotal+" "+unitName+"</font></td>");
					// br.append("<td width='10%' class='multiPOControl' style=\"text-align: right;\"><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> "+quarantineQtyTotal+" "+unitName+"</font></td>");
					 br.append("</tr>");
					 br.append("</table>");
					 br.append("</div>");
				}
				else{
					
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
		   			br.append("<tr class='multiPOControl'>");
					br.append("<td colspan='7'><font color='red'>No Record Available</font></td>");
					br.append("</tr>");
					br.append("</table>");
					
				}
			}
			   br.append("</table>");
				
		}catch(Exception e){
		
				//System.out.println("Error"+e.getMessage());
				throw new Exception(e.getMessage());
			
		}
		finally
		{
			ws=null;
			
		}
	return br.toString();
	}
	
	
	public static String createStockDetails(ItemLocationTransVO vo, WebRowSet ws)throws Exception
	{ 
		StringBuffer br = new StringBuffer();
		
		String strStoreName = "";
		String batchNo = "0";
		String serialNo = null;
		String avlQty = "";
		String expiryDt = "";
		String stockStatus = "";
		String reservedQty = "";
		String blockedQty = "";
		String unitName = "",itemBrandName="";
		String mrp,branded;
		int i=0;
		
			try{
				
				br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				br.append("<tr class='TITLE'>");
				br.append("<td colspan='7'>Stock Details</td>");
				br.append("</tr>");
				br.append("<tr>");
				if(vo.getStrItemCategoryNo()!=null && vo.getStrItemCategoryNo().equals("1")){
					br.append("<tr><td width='15%' class='multiRPTLabel'><div align='left'><b>Store Name</b></div></td>");
					br.append("<td width='20%' class='multiRPTLabel'><div align='left'><b>Drug Name</b></div></td>");
				}else{
					br.append("<tr><td width='15%' class='multiRPTLabel'><div align='left'><b>Store Name</b></div></td>");
					br.append("<td width='20%' class='multiRPTLabel'><div align='left'><b>Item Name</b></div></td>");
				}
	  	        br.append("<td width='10%' class='multiRPTLabel'><div align='left'><b>Batch No</b></div></td>");
	  	        br.append("<td width='20%' class='multiRPTLabel'><div align='left'><b>MRP</b></div></td>");
	  	        br.append("<td width='15%' class='multiRPTLabel'><div align='left'><b>Avl Qty</b></div></td>");
	            br.append("<td width='10%' class='multiRPTLabel'><div align='left'><b>Expiry Date</b></div></td>");
	           // br.append("<td width='15%' class='multiRPTLabel'><div align='left'>Branded/Non-Branded</div></td>");
	            br.append("<td width='10%' class='multiRPTLabel'><div align='left'><b>Stock Status</b></div></td>");
	            br.append("</tr>");
				
				if(ws != null && ws.size() > 0){
					
					//System.out.println("ws size : "+ws.size());
					
		            while(ws.next())
					{		
		            	strStoreName = ws.getString(8);
		            	
		            	batchNo = ws.getString(15);
		            	
		            	if(!vo.getStrItemCategoryNo().equals("1"))
		            	serialNo = ws.getString(37);
		            	
		            	expiryDt = ws.getString(18);
		            	avlQty = ws.getString(9);
		            	stockStatus = ws.getString(40);
		            	
		            	reservedQty = ws.getString(41);
		            	blockedQty = ws.getString(42);
		            	unitName = ws.getString(43);
		            	itemBrandName=ws.getString(2);
		            	mrp=ws.getString(38);
		            	branded=ws.getString(47);
	  					if(strStoreName == null || strStoreName.equals("null") || strStoreName.equals(""))strStoreName = "---";
	  					if(batchNo == null || batchNo.equals("null") || batchNo.equals("") )batchNo = "---";
	  					if(serialNo == null || serialNo.equals("null") || serialNo.equals(""))serialNo = "---";
	  					if(avlQty == null || avlQty.equals("null") || avlQty.equals(""))avlQty = "---";
	  					if(expiryDt == null || expiryDt.equals("null") || expiryDt.equals(""))expiryDt = "---";
	  					if(stockStatus == null || stockStatus.equals("null") || stockStatus.equals(""))stockStatus = "---";
	  					if(itemBrandName == null || itemBrandName.equals("null") || itemBrandName.equals(""))itemBrandName = "---";
	  				
	  					br.append("<tr>");
	  					br.append("<td width='15%' class='multiPOControl'>"+strStoreName+"</td>");
	  					
	  					br.append("<td class='multiPOControl' width='20%'>");
	  					br.append(itemBrandName);
	  					br.append("<input type='hidden' name='strItemDetail' id='strItemDetail" +i+"' value='"+ws.getString(5)+"^"+ws.getString(19)+"^"+ws.getString(6)+"^"+ws.getString(25)+"^"+ws.getString(29)+"' /></td>");
	  					
	  					br.append("<td width='10%' class='multiPOControl'>"+batchNo+"</td>");
	  					br.append("<td width='20%' class='multiPOControl'>"+mrp+"</td>");
	  					br.append("<td width='15%' class='multiPOControl'>"+avlQty+"<input type='hidden' name='strAvlQty' id='strAvlQty" +i+"'"+
		  							"value='"+ reservedQty+" "+unitName+ "@"+ blockedQty +" "+unitName + "'/></td>");
	  					br.append("<td width='10%' class='multiPOControl'>"+expiryDt+"</td>");
	  				//	br.append("<td width='15%' class='multiPOControl'>"+branded+"</td>");
	  					br.append("<td width='10%' class='multiPOControl'>"+stockStatus+"</td>");
	  					
	  					br.append("</tr>");
	  					i++;
					}
		         
				}else{
					
					br.append("<tr class='multiPOControl'>");
					br.append("<td colspan='7'><font color='red'>No Record Available</font></td>");
					br.append("</tr>");
					
				}
			 
				   br.append("</table>");
				
		}catch(Exception e){
		
				//System.out.println("Error"+e.getMessage());
				throw new Exception(e.getMessage());
			
		}
		finally
		{
			ws=null;
			
		}
	return br.toString();
	}
	
	public static String createEmployeeStockDetails(ItemLocationTransVO vo,WebRowSet ws)throws Exception
	{ 
		StringBuffer br = new StringBuffer();
		
		String strEmpNo = "";
		String empName = "";
		String batchNo = "";
		String serialNo = "";
		String avlQty = "";
		String expiryDt = "";
		
		
			try{
				
				br.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				br.append("<tr class='TITLE'>");
				br.append("<td colspan='6'>Employee Stock Details</td>");
				br.append("</tr>");
				br.append("<tr>");
				br.append("<tr><td width='15%' class='multiRPTLabel'><div align='center'>Emp No</div></td>");  
	  	        br.append("<td width='25%' class='multiRPTLabel'><div align='center'>Emp Name</div></td>");
	  	        br.append("<td width='10%' class='multiRPTLabel'><div align='center'>Batch No</div></td>");
	  	        br.append("<td width='20%' class='multiRPTLabel'><div align='center'>Serial No</div></td>");
	            br.append("<td width='20%' class='multiRPTLabel'><div align='center'>Avl Qty</div></td>");
	            br.append("<td width='10%' class='multiRPTLabel'><div align='center'>Expiry Date</div></td>");
	            br.append("</tr>");
				
	            if(ws != null && ws.size() > 0){
					
					//System.out.println("Emp ws size : "+ws.size());
					
		            while(ws.next())
					{		
		            	strEmpNo = ws.getString(1);
		            	empName = ws.getString(2);
		            	batchNo = ws.getString(3);
		            	serialNo = ws.getString(4);
		            	avlQty = ws.getString(5);
		            	expiryDt = ws.getString(6);
		            	
	  					
	  					if(strEmpNo == null || strEmpNo.equals("null") || strEmpNo.equals(""))strEmpNo = "---";
	  					if(batchNo == null || batchNo.equals("null") || batchNo.equals("") )batchNo = "---";
	  					if(serialNo == null || serialNo.equals("null") || serialNo.equals(""))serialNo = "---";
	  					if(avlQty == null || avlQty.equals("null") || avlQty.equals(""))avlQty = "---";
	  					if(expiryDt == null || expiryDt.equals("null") || expiryDt.equals(""))expiryDt = "---";
	  					if(empName == null || empName.equals("null") || empName.equals(""))empName = "---";
	  				
	  					br.append("<tr>");
	  					br.append("<td width='20%' class='multiPOControl'>"+strEmpNo+"</td>");
	  					br.append("<td width='20%' class='multiPOControl'>"+empName+"</td>");
	  					br.append("<td width='10%' class='multiPOControl'>"+batchNo+"</td>");
	  					br.append("<td width='10%' class='multiPOControl'>"+serialNo+"</td>");
	  					br.append("<td width='20%' class='multiPOControl'>"+avlQty+"</td>");
	  					br.append("<td width='20%' class='multiPOControl'>"+expiryDt+"</td>");
	  					
	  					
	  					br.append("</tr>");
					}
		           
				}else{
					
					br.append("<tr class='multiPOControl'>");
					br.append("<td colspan='6'><font color='red'>No Record Available</font></td>");
					br.append("</tr>");
					
				}
			 
				   br.append("</table>");
			 
		}catch(Exception e){
		
				throw new Exception(e.getMessage());
		
		}
		finally
		{
			ws=null;
			
		}
	return br.toString();
	}

}
