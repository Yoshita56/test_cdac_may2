package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.transactions.controller.fb.AcknowledgeTransFB;

public class AcknowledgeTransBSHLP 
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
	/**
	 * voucher Print
	 */
	public static String getTransferDetails(WebRowSet ws, String strDwhName) throws Exception 
	{

		StringBuffer sb = new StringBuffer("");
		String strTransferNo = "";
		String strTransferDate = "";
		String strTransferFrom = "";
		String strTransferTo = "";
		String strReceivedQty = "";
		String strOrderNo="" , strOrderDate="",strDemandNo="",strDemandDate="",strTransferredBy="";
		double cltamt  = 0.00;
		double totalCost = 0.00;
		int i=1;
		String strItemTotCost="0.00";
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		String strTableWidth = "700";
		try 
		{

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
			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> Drug Transfer Voucher");
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
             1. Transfer No
             2. Transfer Date
             3. Transfer To
             4. Issuing Store Name
             5. Generic Name
             6. Brand Name
             7. Batch No
             8. Expiry date
             9. Transfer Qty
             10. Store ID
             11. Item id
             12. Item Brand Id
             13. Rate With Unit
             14. Base Value
             15. Trnasfer Qty
             16. Transfer Qty Unit
             17. Qty Base Value
             18. Item Sl No
             19. Item Sl No
             20. Item Catg Code
             21. Remarks
             22. Receive By
             23. Cost
             24. Order No
             25. Order Date
             26. Demand Req No
             27. Demand Date
             28. Transfer By
             29. Received Qty
             30. Rec Cost
             * */
            
            
           
            if (ws != null && ws.size() > 0) 
			{

				while (ws.next()) 
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
				ws.beforeFirst();
				
			
			    sb.append("<tr> ");
	
				sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Transfer No.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strTransferNo)
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Transfer Date", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strTransferDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
				
				
				sb.append("<tr> ");
				
				sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Receiving DDW.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strTransferTo)
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Transfering DDW.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strTransferFrom).append(
						"</b></font></td> ");
				sb.append("</tr> ");
				
                sb.append("<tr> ");
				
				sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Order No.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strOrderNo)
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Order Date.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strOrderDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
				
                sb.append("<tr> ");
				
				sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Demand No.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strDemandNo)
						.append("</b></font></td> ");
	
				sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
						util.appendSpace("Demand Date.", 15,0)).append(":</b></font></td> ");
				sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strDemandDate).append(
						"</b></font></td> ");
				sb.append("</tr> ");
											
			
			sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

			sb.append("<tr>");		
			sb.append("<td colspan='8' align='center'><hr size='2' width='100%'></td>");
			sb.append("</tr>");
			
			sb.append("<tr bgcolor='#cdc9c9'> ");
			sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
			sb.append("</td>");
						
			sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font> ");
			sb.append("</td>");
			
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
			sb.append("</td> ");
			sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='6%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>TransfQty</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='6%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Recv Qty</b></font> ");
			sb.append("</td> ");
			sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font> ");
			sb.append("</td> ");		
			sb.append("</tr> ");
			
			sb.append("<tr>");		
			sb.append("<td colspan='8' align='center'><hr size='2' width='100%'></td>");
			sb.append("</tr>");
			
				while (ws.next()) 
				{
					NumberFormat formatter = new DecimalFormat("############.##");  
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(30)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					totalCost = totalCost + cltamt;
					sb.append("<tr> ");
					sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(i);
					sb.append("</font></td> ");
					
					
					sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(6));
					sb.append("</font></td> ");

					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(7));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(8));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(13));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='6%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(9));
					sb.append("</font></td> ");
					sb.append("<td align='center' width='6%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(29));
					sb.append("</font></td> ");
					
					sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(ws.getString(30));
					sb.append("</font></td> ");
					
					sb.append("</tr> ");
					i++;
								
				 }
					NumberFormat formatter = new DecimalFormat("############.##");  
				    
					String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
					
					sb.append("<tr>");
					sb.append("<td colspan='5' align='center'></td>");					
					sb.append("<td colspan='3' align='center'><hr size='2' width='100%'></td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td colspan='7' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
					sb.append("<td colspan='2' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
					sb.append(FinaltotalCost);				
					sb.append("</font></td>");
					sb.append("</tr>");	
					sb.append("<tr>");
					sb.append("<td colspan='5' align='center'></td>");					
					sb.append("<td colspan='3' align='center'><hr size='2' width='100%'></td>");
					sb.append("</tr>");
					
					/*sb.append("<tr> "); 
					sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
					sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
					
					
					if(!strRemarks.equals("")||!strRemarks.equals(" ")||!strRemarks.equals(null))
					{
					    sb.append(strRemarks);
					} 
					else
					{
						sb.append("--------");	
					}	
					sb.append("<br></font></td>");
			        sb.append("</tr> ");*/
					
					
					sb.append("<tr> ");
					sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
					sb.append("</tr> ");
					sb.append("<tr> ");
					sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strTransferredBy).append(
									")<b> &nbsp;&nbsp;</font></td> ");
					sb.append("</tr> ");
				
				

			} 
			else 
			{

				sb.append("<tr> ");
				sb
						.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
				sb.append("</tr> ");

			}

			sb.append("</table> ");

		} catch (Exception e) {

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}

	
	 public static String getAcknowledgeDetails(WebRowSet ws)
	    {
			
			StringBuffer sb = new StringBuffer("");
			
			try {
				
				if(ws != null && ws.size() > 0)
				{ 
					if (ws.next()) 
					{
						 /*
						    *1.From Store
						    *2.Trans No
						    *3.Trans Date
						    *4.Catg 
						    *5.Req type
						    *6.Ack Store
						    *7.Issuing Store Id
						    *8.Ack Store ID
						    *9.Catg Id
						    *10.Req no
						    *11.Req Date
						    *12.Req Type ID 
						    *13.Remarks
						    * */
						
						String strStoreName         = ws.getString(6);
						String strTransNo           = ws.getString(2);
						String strTransDate         = ws.getString(3);
						String strItemCategoryName  = ws.getString(4);
						String strReqTypeName       = ws.getString(5);
						String strToStoreName       = ws.getString(1);
						
						String strStrId = ws.getString(7);
						String strToStrId = ws.getString(8);
						String strItemCatNo = ws.getString(9);
						
						String strHidVal = strStrId+"^"+strToStrId+"^"+strItemCatNo+"^"+strToStoreName+"^"+strTransNo;
						
						if (strStoreName == null)
							strStoreName = "----";
						if (strTransNo == null)
							strTransNo = "----";
						if (strTransDate == null)
							strTransDate = "----";
						if (strItemCategoryName == null)
							strItemCategoryName = "----";
						if (strReqTypeName == null)
							strReqTypeName = "----";
						if (strToStoreName == null)
							strToStoreName = "----";
						sb.append("<input type='hidden' name ='strHidVal'  value='"+strHidVal+"'>");
						 /*
						    *1.From Store
						    *2.Trans No
						    *3.Trans Date
						    *4.Catg 
						    *5.Req type
						    *6.Ack Store
						    *7.Issuing Store Id
						    *8.Ack Store ID
						    *9.Catg Id
						    *10.Req no
						    *11.Req Date
						    *12.Req Type ID 
						    *13.Remarks
						    * */
						sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
						sb.append("<tr><td width='25%' class='LABEL'>Receiving Store</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strStoreName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Req Type</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(5));
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Req No</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(10));
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Req Date</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						if(ws.getString(11)!=null)
							
						    sb.append(ws.getString(11));
						else
							sb.append("---");	
						sb.append("</td></tr>");
						if(ws.getString(12).equals("51"))   // Transfer Request
						{
						sb.append("<tr><td width='25%' class='LABEL'>Transfer By</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(1));
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Transfer Date</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(3));
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Transfer No</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(2));
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Remarks</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(13));
						sb.append("</td></tr>");
						}
						if(ws.getString(12).equals("17") || ws.getString(12).equals("31"))  // Issue To Store / Indent For Issue
						{
						sb.append("<tr><td width='25%' class='LABEL'>Issued By</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(1));
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Issue Date</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(3));
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Issue No</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(2));
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Remarks</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(13));
						sb.append("</td></tr>");
						}
						if(ws.getString(12).equals("18"))  // Return request
						{
						sb.append("<tr><td width='25%' class='LABEL'>Returned By</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(1));
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Returned Date</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(3));
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%' class='LABEL'>Return No</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(2));
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Remarks</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(13));
						sb.append("</td></tr>");
						}
						
						sb.append("</table>");
					}
				}
				else {
					    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
					    sb.append("<tr>");
					    sb.append("<td colspan='5'  CLASS='multiControl' >"
								+ "<DIV class='errMsg' align='center'> </div>" + "</TD>");

					    sb.append("</tr>");
					    sb.append("</table>");
						
				   } 
				System.out.println("sb in hLP ::"+sb);
			}catch(Exception e){
				 
				throw new HisException("Acknowledge Transaction","AcknowledgeTransHLP.getAcknowledgeDetails()-->",e.getMessage());
			}
		return sb.toString();
		}
	
	public static String getItemDetails(AcknowledgeTransFB formBean)
	{
	    StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		int i=0;
		try 
		{
			 formBean.getStrItemDtlWs().beforeFirst();
			   
			   WebRowSet ws1 = formBean.getStrItemDtlWs();
			  
		       sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
		       sb.append("<tr><td colspan='5' class='TITLE'><div id='a' style='cursor:pointer;'>Drug Detail(s)</div></td></tr>");
		       sb.append("</table>");
		       sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='black' cellspacing ='1px'>");
			   sb.append("<tr>");
			   sb.append("<td width='37%' class='multiRPTLabel'>Drug Name</td>");
			   sb.append("<td width='18%' class='multiRPTLabel'>Batch No</td>");
			   if(formBean.getStrRequestType().equals("51"))
			   {	   
			   sb.append("<td width='15%' class='multiRPTLabel'>Transfer Qty.</td>");
			   }
			   if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
			   {	   
				   sb.append("<td width='15%' class='multiRPTLabel'>Sanc Qty.</td>");
			   sb.append("<td width='15%' class='multiRPTLabel'>Issue Qty.</td>");
			   }
			   if(formBean.getStrRequestType().equals("18"))
			   {	   
			   sb.append("<td width='15%' class='multiRPTLabel'>Return Qty.</td>");
			   }			   
			   sb.append("<td width='15%' class='multiRPTLabel'>Received Qty.</td>");
			//   sb.append("<td width='15%' class='multiRPTLabel'>Bkg/Short Qty.</td></tr>");
			   sb.append("</table>");
			   sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' border='0' cellspacing ='1px'>");
			      if (ws1 != null) 
				  {
			    	  
			    	  
					   String strItemName   = null;
				       String strRateUnit = null;
				       String strQtyUnit = null;
				       String strBatchNo = null;
				    //   double strCost = 0.00;
				       String strQty = null;
			//	       String strRate = null;
			//	       String strUnitConversion = null;
				       
				       String strItemId 			 = "";
			    	   String strItemBrandId 		 = "";
			    	   String strItemSlNo 		     = "";
			    	   String strStockStatusCode 	 = "";
			    	   String strQtyUnitId = "";
			    	   String strRecQty = "";
			    	   String strRecCost = "";
			    	   String strSancQty = "";
				      		       
				       while(ws1.next())
				       {
				    	    
				    	   strItemName           = ws1.getString(1);
				    	   strBatchNo            = ws1.getString(2);
				    	   strQtyUnit            = ws1.getString(3);
				    	   strRateUnit           = ws1.getString(4);
				    	   strQty                = ws1.getString(5);
				//    	   strRate     			 = ws1.getString(6);
				 //   	   strUnitConversion     = ws1.getString(7);
				    	   strItemId 			 = ws1.getString(8);
				    	   strItemBrandId 		 = ws1.getString(9);
				    	   strItemSlNo 		     = ws1.getString(10);
				    	   strStockStatusCode 	 = ws1.getString(11);
				    	   strQtyUnitId			 = ws1.getString(12);
				    	   strRecQty             = ws1.getString(13);
				    	   strRecCost            = ws1.getString(14);
				    	   if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
						   {
				    		   strSancQty 			 = ws1.getString(15);
						   }
				    	   
				    	   if (strRecQty == null)
				    		   strRecQty = "----";
							if (strRecCost == null)
								strRecCost = "----";
				    	  
				    	   strHiddenValue  = strItemName+"^"+strBatchNo+"^"+strQty+"^"+strItemId+"^"+strItemBrandId+"^"+strItemSlNo+"^"+strStockStatusCode+"^"+strQtyUnitId+"^"+strRecQty+"^"+strRecCost;
				    	   
				    	 //  strCost = ((Double.parseDouble(strQty)) *  (Double.parseDouble(strRate)))/Double.parseDouble(strUnitConversion);
				    	  					    	   				    	    			    	     		    	   
					  	    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
							if(strBatchNo == null || strBatchNo.equals("")) strBatchNo = "-----";
							if(strQtyUnit == null || strQtyUnit.equals("")) strQtyUnit = "-----";
							if(strRateUnit == null || strRateUnit.equals("")) strRateUnit = "-----";

							sb.append("<input type='hidden' name ='strHiddenValue' id='strHiddenValue"+i+"' value='"+strHiddenValue+"'>");
							
							sb.append("<tr>");
							sb.append("<td width='37%' class='multiPOControl'>");
							sb.append(strItemName);
							sb.append("</td>");
							sb.append("<td width='18%' class='multiPOControl'>");
							sb.append(strBatchNo);
							sb.append("</td>");
							if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
							   {
							sb.append("<td width='15%' class='multiPOControl'>");
							sb.append(Math.round(Double.parseDouble(strSancQty)));
							sb.append("</td>");	
							   }
							sb.append("<td width='15%' class='multiPOControl'>");
							sb.append(Math.round(Double.parseDouble(strQty)));
							sb.append("</td>");								 
							sb.append("<td class='multiPOControl' width='15%'><input type='text' name='strReceivedQty'  class='txtFldNormal' id='strReceivedQty"+i+"' value='"+Math.round(Double.parseDouble(strQty))+"' onkeypress='return validateData(event,5);'  onblur='notGreaterThanReceQty(this,\""+i+"\");' /></td>");
					//		sb.append("<td class='multiPOControl' width='15%'><input type='text' name='strBkgQty'       class='txtFldNormal' id='strBkgQty"+i+"'      value='0'    readonly  /></td>");
							 
							sb.append("</tr>");
							i++;
						}
					 sb.append("</table>");
			  	     
		 	  }else {
				    sb.append("<table class='TABLEWIDTH' align='center'  bgcolor='#6097BC'  border='0'  cellspacing ='1px'>"); 
				    sb.append("<tr>");
				    sb.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>" + "</TD>");
	
				    sb.append("</tr>");
				    sb.append("</table>");
					
			   } 
		}
		catch(Exception e)
		{
			 
			throw new HisException("Acknowledge Transaction","AcknowledgeTransHLP.getItemDetails()-->",e.getMessage());
		}
	return sb.toString();
	}
	
	
	public static String getItemDetailsBS(AcknowledgeTransFB formBean)
	{
	    StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		int i=0;
		try 
		{
			 formBean.getStrItemDtlWs().beforeFirst();
			   
			   WebRowSet ws1 = formBean.getStrItemDtlWs();
			  
			   sb.append("<div class='row'>");
		       sb.append("<div class='subHeaders col-sm-12'>Drug Detail(s)</div>");
		       sb.append("</div>");
		       sb.append("<table class='table' align='center'  border='0' bgcolor='black' cellspacing ='1px'>");
			   sb.append("<thead>");
			   sb.append("<th style='text-align='left''>Drug Name</th>");
			   sb.append("<th style='text-align='left''>Batch No</th>");
			   if(formBean.getStrRequestType().equals("51"))
			   {	   
			   sb.append("<th style='text-align='right''>Transfer Qty.</th>");
			   }
			   if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
			   {	   
				   sb.append("<th style='text-align='right''>Sanc Qty.</th>");
			   sb.append("<th style='text-align='right''>Issue Qty.</th>");
			   }
			   if(formBean.getStrRequestType().equals("18"))
			   {	   
			   sb.append("<th>Return Qty.</th>");
			   }			   
			   sb.append("<th width='10%'>Received Qty.</th>");
			//   sb.append("<td width='15%' class='multiRPTLabel'>Bkg/Short Qty.</td></tr>");
			   sb.append("</thead>");
			   sb.append("<tbody>");
			      if (ws1 != null) 
				  {
			    	  
			    	  
					   String strItemName   = null;
				       String strRateUnit = null;
				       String strQtyUnit = null;
				       String strBatchNo = null;
				    //   double strCost = 0.00;
				       String strQty = null;
			//	       String strRate = null;
			//	       String strUnitConversion = null;
				       
				       String strItemId 			 = "";
			    	   String strItemBrandId 		 = "";
			    	   String strItemSlNo 		     = "";
			    	   String strStockStatusCode 	 = "";
			    	   String strQtyUnitId = "";
			    	   String strRecQty = "";
			    	   String strRecCost = "";
			    	   String strSancQty = "";
				      		       
				       while(ws1.next())
				       {
				    	    
				    	   strItemName           = ws1.getString(1);
				    	   strBatchNo            = ws1.getString(2);
				    	   strQtyUnit            = ws1.getString(3);
				    	   strRateUnit           = ws1.getString(4);
				    	   strQty                = ws1.getString(5);
				//    	   strRate     			 = ws1.getString(6);
				 //   	   strUnitConversion     = ws1.getString(7);
				    	   strItemId 			 = ws1.getString(8);
				    	   strItemBrandId 		 = ws1.getString(9);
				    	   strItemSlNo 		     = ws1.getString(10);
				    	   strStockStatusCode 	 = ws1.getString(11);
				    	   strQtyUnitId			 = ws1.getString(12);
				    	   strRecQty             = ws1.getString(13);
				    	   strRecCost            = ws1.getString(14);
				    	   if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
						   {
				    		   strSancQty 			 = ws1.getString(15);
						   }
				    	   
				    	   if (strRecQty == null)
				    		   strRecQty = "----";
							if (strRecCost == null)
								strRecCost = "----";
				    	  
				    	   strHiddenValue  = strItemName+"^"+strBatchNo+"^"+strQty+"^"+strItemId+"^"+strItemBrandId+"^"+strItemSlNo+"^"+strStockStatusCode+"^"+strQtyUnitId+"^"+strRecQty+"^"+strRecCost;
				    	   
				    	 //  strCost = ((Double.parseDouble(strQty)) *  (Double.parseDouble(strRate)))/Double.parseDouble(strUnitConversion);
				    	  					    	   				    	    			    	     		    	   
					  	    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
							if(strBatchNo == null || strBatchNo.equals("")) strBatchNo = "-----";
							if(strQtyUnit == null || strQtyUnit.equals("")) strQtyUnit = "-----";
							if(strRateUnit == null || strRateUnit.equals("")) strRateUnit = "-----";

							sb.append("<input type='hidden' name ='strHiddenValue' id='strHiddenValue"+i+"' value='"+strHiddenValue+"'>");
							 
							//sb.append("<tr>");
							sb.append("<td style='text-align='left''>");
							sb.append(strItemName);
							sb.append("</td>");
							sb.append("<td style='text-align='left''>");
							sb.append(strBatchNo);
							sb.append("</td>");
							if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
							   {
							sb.append("<td style='text-align='right''>");
							sb.append(Math.round(Double.parseDouble(strSancQty)));
							sb.append("</td>");	
							   }
							sb.append("<td style='text-align='right''>");
							sb.append(Math.round(Double.parseDouble(strQty)));
							sb.append("</td>");								 
							sb.append("<td><input type='text' name='strReceivedQty'  class='form-control form-control-sm' id='strReceivedQty"+i+"' value='"+Math.round(Double.parseDouble(strQty))+"' onkeypress='return validateData(event,5);'  onblur='notGreaterThanReceQty(this,\""+i+"\");' /></td>");
					//		sb.append("<td class='multiPOControl' width='15%'><input type='text' name='strBkgQty'       class='txtFldNormal' id='strBkgQty"+i+"'      value='0'    readonly  /></td>");
							 
							sb.append("</tbody>");
							i++;
						}
				       //sb.append("</tbody>");
					 sb.append("</table>");
			  	     
		 	  }else {
				    sb.append("<tbody>"); 
				   // sb.append("<tr>");
				    sb.append("<td>"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>" + "</td>");
	
				   // sb.append("</tr>");
				    sb.append("</tbody>");
					
			   } 
		}
		catch(Exception e)
		{
			 
			throw new HisException("Acknowledge Transaction","AcknowledgeTransHLP.getItemDetails()-->",e.getMessage());
		}
	return sb.toString();
	}
	
	public static String getViewItemDetails(AcknowledgeTransFB formBean)
	{
	    StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "";
		int i=0;
		try 
		{
			 formBean.getStrItemDtlWs().beforeFirst();
			   
			   WebRowSet ws1 = formBean.getStrItemDtlWs();
			  
		       sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
		       sb.append("<tr><td colspan='5' class='TITLE'><div id='a' style='cursor:pointer;'>Drug Detail(s)</div></td></tr>");
		       sb.append("</table>");
		       sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='black' cellspacing ='1px'>");
			   sb.append("<tr>");
			   sb.append("<td width='37%' class='multiRPTLabel'>Drug Name</td>");
			   sb.append("<td width='18%' class='multiRPTLabel'>Batch No</td>");
			   if(formBean.getStrRequestType().equals("51"))
			   {	   
			   sb.append("<td width='15%' class='multiRPTLabel'>Transfer Qty.</td>");
			   }
			   if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
			   {	   
			   sb.append("<td width='15%' class='multiRPTLabel'>Issue Qty.</td>");
			   }
			   if(formBean.getStrRequestType().equals("18"))
			   {	   
			   sb.append("<td width='15%' class='multiRPTLabel'>Return Qty.</td>");
			   }
			   
			   sb.append("<td width='15%' class='multiRPTLabel'>Received Qty.</td></tr>");
			   sb.append("</table>");
			   sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' border='0' cellspacing ='1px'>");
			      if (ws1 != null) 
				  {
			    	  
			    	  
					   String strItemName   = null;
				       String strRateUnit = null;
				       String strQtyUnit = null;
				       String strBatchNo = null;
				    //   double strCost = 0.00;
				       String strQty = null;
			//	       String strRate = null;
			//	       String strUnitConversion = null;
				       
				       String strItemId 			 = "";
			    	   String strItemBrandId 		 = "";
			    	   String strItemSlNo 		     = "";
			    	   String strStockStatusCode 	 = "";
			    	   String strQtyUnitId = "";
			    	   String strRecQty = "";
			    	   String strRecCost = "";
				      		       
				       while(ws1.next())
				       {
				    	    
				    	   strItemName           = ws1.getString(1);
				    	   strBatchNo            = ws1.getString(2);
				    	   strQtyUnit            = ws1.getString(3);
				    	   strRateUnit           = ws1.getString(4);
				    	   strQty                = ws1.getString(5);
				//    	   strRate     			 = ws1.getString(6);
				 //   	   strUnitConversion     = ws1.getString(7);
				    	   strItemId 			 = ws1.getString(8);
				    	   strItemBrandId 		 = ws1.getString(9);
				    	   strItemSlNo 		     = ws1.getString(10);
				    	   strStockStatusCode 	 = ws1.getString(11);
				    	   strQtyUnitId			 = ws1.getString(12);
				    	   strRecQty             = ws1.getString(13);
				    	   strRecCost            = ws1.getString(14);
				    	   
				    	   if (strRecQty == null)
				    		   strRecQty = "----";
							if (strRecCost == null)
								strRecCost = "----";
				    	  
				    	   strHiddenValue  = strItemName+"^"+strBatchNo+"^"+strQty+"^"+strItemId+"^"+strItemBrandId+"^"+strItemSlNo+"^"+strStockStatusCode+"^"+strQtyUnitId+"^"+strRecQty+"^"+strRecCost;
				    	   
				    	 //  strCost = ((Double.parseDouble(strQty)) *  (Double.parseDouble(strRate)))/Double.parseDouble(strUnitConversion);
				    	  					    	   				    	    			    	     		    	   
					  	    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
							if(strBatchNo == null || strBatchNo.equals("")) strBatchNo = "-----";
							if(strQtyUnit == null || strQtyUnit.equals("")) strQtyUnit = "-----";
							if(strRateUnit == null || strRateUnit.equals("")) strRateUnit = "-----";

							sb.append("<input type='hidden' name ='strHiddenValue' id='strHiddenValue"+i+"' value='"+strHiddenValue+"'>");
							
							sb.append("<tr>");
							sb.append("<td width='37%' class='multiPOControl'>");
							sb.append(strItemName);
							sb.append("</td>");
							sb.append("<td width='18%' class='multiPOControl'>");
							sb.append(strBatchNo);
							sb.append("</td>");
							sb.append("<td width='15%' class='multiPOControl'>");
							sb.append(strQtyUnit);
							sb.append("</td>");	
							
							sb.append("<td class='multiPOControl' width='15%'>");
							sb.append(strRecQty);
							sb.append("</td>");	
							sb.append("</tr>");
							i++;
						}
					 sb.append("</table>");
			  	     
		 	  }else {
				    sb.append("<table class='TABLEWIDTH' align='center'  bgcolor='#6097BC'  border='0'  cellspacing ='1px'>"); 
				    sb.append("<tr>");
				    sb.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>" + "</TD>");
	
				    sb.append("</tr>");
				    sb.append("</table>");
					
			   } 
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
			throw new HisException("Acknowledge Transaction","AcknowledgeTransHLP.getItemDetails()-->",e.getMessage());
		}
	return sb.toString();
	}
	
	 public static String getAckDtls(WebRowSet ws)
	    {
			
			StringBuffer sb = new StringBuffer("");
			
			try {
				
				if(ws != null && ws.size() > 0)
				{ 
					if (ws.next()) 
					{
											
						String strAckDate         = ws.getString(1);
						String strAckBy           = ws.getString(2);
						String strRemarks         = ws.getString(3);
												
						if (strAckDate == null)
							strAckDate = "----";
						if (strAckBy == null)
							strAckBy = "----";
						if (strRemarks == null)
							strRemarks = "----";
						
						sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
						sb.append("<tr><td colspan='4' class='TITLE'>Acknowledge Details</td></tr>");
						sb.append("<tr><td width='25%' colspan='1' class='LABEL'>Acknowledge Date</td>");
						sb.append("<td width='25%'  colspan='1' class='CONTROL'>");
						sb.append(strAckDate);
						sb.append("</td>");
						sb.append("<td width='25%'  colspan='1' class='LABEL'>Acknowledge By</td>");
						sb.append("<td width='25%'  colspan='1' class='CONTROL'>");
						sb.append(strAckBy);
						sb.append("</td></tr>");
						sb.append("<tr><td width='25%'  colspan='1' class='LABEL'>Remarks</td>");
						sb.append("<td width='75%'  colspan='3'  class='CONTROL'>");
						sb.append(strRemarks);
						sb.append("</td></tr>");
						sb.append("</table>");
					}
				}
				else {
					    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#6097BC' cellspacing ='1px'>"); 
					    sb.append("<tr>");
					    sb.append("<td colspan='4'  CLASS='multiControl' >"
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>" + "</TD>");

					    sb.append("</tr>");
					    sb.append("</table>");
						
				   } 
			}catch(Exception e){
	 
				throw new HisException("Acknowledge Transaction","AcknowledgeTransHLP.getAckDtls()-->",e.getMessage());
			}
		return sb.toString();
		}
}
