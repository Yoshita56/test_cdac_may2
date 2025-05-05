package mms.transactions.controller.hlp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.MmsConfigUtil;
import mms.transactions.controller.fb.AcknowledgeTransFB;

public class AcknowledgeTransHLP 
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

	
	 public static String getAcknowledgeDetailsBS(WebRowSet ws)
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
						//sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
						sb.append("<div class='row'><div class='col-sm-2'></div><div class='col-sm-2'>Receiving Store</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(strStoreName);
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Request Type</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(5));
						sb.append("</div><div class='col-sm-2'></div></div>");
						sb.append("<div class='row'><div class='col-sm-2'></div><div class='col-sm-2'>Request No</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(10));
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Request Date</div>");
						sb.append("<div class='col-sm-2' text-align='left' style='font-weight: 400; color: blue;'>");
						if(ws.getString(11)!=null)
							
						    sb.append(ws.getString(11));
						else
							sb.append("---");	
						sb.append("</div><div class='col-sm-2'></div></div>");
						if(ws.getString(12).equals("51"))   // Transfer Request
						{
						sb.append("<div class='row'><div class='col-sm-2'></div><div class='col-sm-2'>Transfer By</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(1));
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Transfer Date</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(3));
						sb.append("</div><div class='col-sm-2'></div></div>");
						sb.append("<div class='row'><div class='col-sm-2'></div><div class='col-sm-2'>Transfer No</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(2));
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Remarks</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(13));
						sb.append("</div><div class='col-sm-2'></div></div>");
						}
						if(ws.getString(12).equals("17") || ws.getString(12).equals("31"))  // Issue To Store / Indent For Issue
						{
						sb.append("<div class='row'><div class='col-sm-2'></div><div class='col-sm-2'>Issued By</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(1));
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Issue Date</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(3));
						sb.append("</div><div class='col-sm-2'></div></div>");
						sb.append("<div class='row'><div class='col-sm-2'></div><div class='col-sm-2'>Issue No</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(2));
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Remarks</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(13));
						sb.append("</div><div class='col-sm-2'></div></div>");
						}
						if(ws.getString(12).equals("18"))  // Return request
						{
						sb.append("<div class='row'><div class='col-sm-2'></div><div class='col-sm-2'>Returned By</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(1));
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Returned Date</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(3));
						sb.append("</div><div class='col-sm-2'></div></div>");
						sb.append("<div class='row'><div class='col-sm-2'></div><div class='col-sm-2'>Return No</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(2));
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Remarks</div>");
						sb.append("<div class='col-sm-2' align='left' style='font-weight: 400; color: blue;'>");
						sb.append(ws.getString(13));
						sb.append("</div><div class='col-sm-2'></div></div>");
						}
						
						//sb.append("</table>");
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
				//System.out.println("sb in hLP ::"+sb);
			}catch(Exception e){
				 e.printStackTrace();
				throw new HisException("Acknowledge Transaction","AcknowledgeTransHLP.getAcknowledgeDetails()-->",e.getMessage());
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
					   sb.append("<div class='container'>");
						  sb.append("<div class='row'>");
					      sb.append("<div class='col-sm-3'>Receiving Store</div>");
						  sb.append("<div class='col-sm-3' colspan='3'>");
						  	sb.append(strStoreName);
						  sb.append("</div>");
						
					      sb.append("<div class='col-sm-3'>Req Type</div>");
						  sb.append("<div class='col-sm-3' colspan='3'>");
							sb.append(ws.getString(5));
						  sb.append("</div></div>");
						
						  sb.append("<div class='row'>");
					      sb.append("<div class='col-sm-3'>Req No</div>");
						  sb.append("<div class='col-sm-3' colspan='3'>");
							sb.append(ws.getString(10));
						  sb.append("</div>");
						
					      sb.append("<div class='col-sm-3'>Req Date</div>");
						  sb.append("<div class='col-sm-3' colspan='3'>");
							  if(ws.getString(11)!=null)
								    sb.append(ws.getString(11));
								else
									sb.append("---");							  
						  sb.append("</div></div>");
						  
						/*
						sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
						sb.append("<tr><td width='25%' class='LABEL'>Receiving Store </td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(strStoreName);
						sb.append("</td>");
						sb.append("<td width='25%' class='LABEL'>Req Type</td>");
						sb.append("<td width='25%' class='CONTROL'>");
						sb.append(ws.getString(5));
						sb.append("</td></tr>");
						*/
						  
						/*
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
						*/
						
						if(ws.getString(12).equals("51"))   // Transfer Request
						{
							sb.append("<div class='row'>");
						      sb.append("<div class='col-sm-3'>Transfer By</div>");
							  sb.append("<div class='col-sm-3' colspan='3'>");
								sb.append(ws.getString(1));
							  sb.append("</div>");
							
						      sb.append("<div class='col-sm-3'>Transfer Date</div>");
							  sb.append("<div class='col-sm-3' colspan='3'>");
								sb.append(ws.getString(3));
							  sb.append("</div></div>");
							  
							 sb.append("<div class='row'>");
						      sb.append("<div class='col-sm-3'>Transfer No</div>");
							  sb.append("<div class='col-sm-3' colspan='3'>");
								sb.append(ws.getString(2));
							  sb.append("</div>");
							
						      sb.append("<div class='col-sm-3'>Remarks</div>");
							  sb.append("<div class='col-sm-3' colspan='3'>");
								sb.append(ws.getString(13));
							  sb.append("</div></div>");
					/*
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
					*/	
						}
						if(ws.getString(12).equals("17") || ws.getString(12).equals("31"))  // Issue To Store / Indent For Issue
						{
							sb.append("<div class='row'>");
						      sb.append("<div class='col-sm-3'>Issued By</div>");
							  sb.append("<div class='col-sm-3' colspan='3'>");
								sb.append(ws.getString(1));
							  sb.append("</div>");
							
						      sb.append("<div class='col-sm-3'>Issue Date</div>");
							  sb.append("<div class='col-sm-3' colspan='3'>");
								sb.append(ws.getString(3));
							  sb.append("</div></div>");
							  
							 sb.append("<div class='row'>");
						      sb.append("<div class='col-sm-3'>Issue No</div>");
							  sb.append("<div class='col-sm-3' colspan='3'>");
								sb.append(ws.getString(2));
							  sb.append("</div>");
							
						      sb.append("<div class='col-sm-3'>Remarks</div>");
							  sb.append("<div class='col-sm-3' colspan='3'>");
								sb.append(ws.getString(13));
							  sb.append("</div></div>");	
					/*		  
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
					*/
						}
					
						if(ws.getString(12).equals("18"))  // Return request
						{
							sb.append("<div class='row'>");
						      sb.append("<div class='col-sm-3'>Returned By</div>");
							  sb.append("<div class='col-sm-3' colspan='3'>");
								sb.append(ws.getString(1));
							  sb.append("</div>");
							
						      sb.append("<div class='col-sm-3'>Returned Date</div>");
							  sb.append("<div class='col-sm-3' colspan='3'>");
								sb.append(ws.getString(3));
							  sb.append("</div></div>");
							  
							 sb.append("<div class='row'>");
						      sb.append("<div class='col-sm-3'>Return No</div>");
							  sb.append("<div class='col-sm-3' colspan='3'>");
								sb.append(ws.getString(2));
							  sb.append("</div>");
							
						      sb.append("<div class='col-sm-3'>Remarks</div>");
							  sb.append("<div class='col-sm-3' colspan='3'>");
								sb.append(ws.getString(13));
							  sb.append("</div></div>");
					/*
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
					*/	
						}
						//sb.append("</table>");
						sb.append("</div>");
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
				e.printStackTrace();
				throw new HisException("Acknowledge Transaction","AcknowledgeTransHLP.getAcknowledgeDetails()-->",e.getMessage());
			}
		return sb.toString();
		}
	
	 
	 public static String getItemDetails(AcknowledgeTransFB formBean)
	 {
	    StringBuffer sb = new StringBuffer("");
		String strHiddenValue = "",strApplyClass="";
		int i=0;
		try 
			{
			formBean.getStrItemDtlWs().beforeFirst();
					   /* (reqTypeId) = 31
					    * 1.Item Name
					    * 2.Batch No
					    * 3.Issue Qty 
					    * 4.Rate/Unit
					    * 5.Issue Qty
					    * 6.Rate
					    * 7.Conversion Value
					    * 8.Item Id
					    * 9.Brand Id
					    * 10.Item Sl No
					    * 11.Stock Status
					    * 12.Issue Qty Unit Is
					    * 13.Rec Qty
					    * 14.Rec Cost
					    * 15.Sanc Qty
					    * 16.EDL_CATG
					    * 17.EXP_DATE					   
					    * */
					   
		WebRowSet ws1 = formBean.getStrItemDtlWs();
				  
			     
				  sb.append("<table class='table'>");
				  sb.append("<div class='legendHeader my-2' id='' style='font-weight:600;font-size: 16px;'>Drug Detail(s)</div>");
				  sb.append("<thead class='thead-dark'>"); 
				  sb.append("<tr>");
				  if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
				  {	
				      sb.append("<th width='30%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Drug Name</th>");
				  }
				  else
				  {
					  sb.append("<th width='40%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Drug Name</th>");
				  }
				  sb.append("<th width='18%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</th>");
			      
				  if(formBean.getStrRequestType().equals("51"))
				  {	   
						sb.append("<th width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Transfer Qty.</th>");
				  }
				  if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
				  {	
					   sb.append("<th width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Sanc Qty.</th>");
					  
					   sb.append("<th width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Exp Date</th>");
					   sb.append("<th width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Issue Qty.</th>");
				  }
				  if(formBean.getStrRequestType().equals("18"))
				  {	
					  sb.append("<th width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Return Qty.</th>");
					
				  }	
				   sb.append("<th width='12%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Received Qty.</th>");
				   sb.append("</tr> ");
				   sb.append("</thead>");
				   sb.append("<tbody>");
				  
				      if (ws1 != null) 
					  {
						   String strItemName   = null;
					       String strRateUnit = null;
					       String strQtyUnit = null;
					       String strBatchNo = null;
					       //double strCost = 0.00;
					       String strQty = null;
					       //String strRate = null;
					       //String strUnitConversion = null;
					       
					       String strItemId 			 = "";
				    	   String strItemBrandId 		 = "";
				    	   String strItemSlNo 		     = "";
				    	   String strStockStatusCode 	 = "";
				    	   String strQtyUnitId = "";
				    	   String strRecQty = "";
				    	   String strRecCost = "";
				    	   String strSancQty = "";
				    	   
				    	   String strExpDate = "";
					      		       
					       while(ws1.next())
					       {
					    	    
					    	   strItemName           = ws1.getString(1);
					    	   strBatchNo            = ws1.getString(2);
					    	   strQtyUnit            = ws1.getString(3);
					    	   strRateUnit           = ws1.getString(4);
					    	   strQty                = ws1.getString(5);
					    	   //strRate     			 = ws1.getString(6);
					    	   //strUnitConversion     = ws1.getString(7);
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
					    		  strExpDate            = ws1.getString(17);
							   }
					    	   
					    	   if (strRecQty == null)
					    		   strRecQty = "----";
								if (strRecCost == null)
									strRecCost = "----";
								
								if(ws1.getString(16).equals("1"))   // EDL Catg Flag
							       {
							    	 strApplyClass = "Approved";				    	   
							       }
							       else
							       {
							    	 strApplyClass = "multiPOControl";    				    	   
							       }
					    	  
					    	   strHiddenValue  = strItemName+"^"+strBatchNo+"^"+strQty+"^"+strItemId+"^"+strItemBrandId+"^"+strItemSlNo+"^"+strStockStatusCode+"^"+strQtyUnitId+"^"+strRecQty+"^"+strRecCost;
					    	   
					    	 //  strCost = ((Double.parseDouble(strQty)) *  (Double.parseDouble(strRate)))/Double.parseDouble(strUnitConversion);
					    	  					    	   				    	    			    	     		    	   
						  	    if(strItemName == null || strItemName.equals("")) strItemName = "-----";
								if(strBatchNo == null || strBatchNo.equals("")) strBatchNo = "-----";
								if(strQtyUnit == null || strQtyUnit.equals("")) strQtyUnit = "-----";
								if(strRateUnit == null || strRateUnit.equals("")) strRateUnit = "-----";

								sb.append("<input type='hidden' name ='strHiddenValue' id='strHiddenValue"+i+"' value='"+strHiddenValue+"'>");
								
								sb.append("<tr>");
								
								 if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
								  {	
									 sb.append("<td width='30%' align='left' style='font-weight:350 !important ;font-size: 16px !important;'>"+ strItemName + "</td>");
								  }
								  else
								  {
									  sb.append("<td width='40%' align='left' style='font-weight:350 !important ;font-size: 16px !important;'>"+ strItemName + "</td>");
								  }
					
								
					
								sb.append("<td width='18%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+ strBatchNo + "</td>");
								
								if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
								{
								  sb.append("<td width='10%' align='center'style='font-weight:350 !important ;font-size: 16px !important;'>"+ Math.round(Double.parseDouble(strSancQty)) + "</td>");
								  sb.append("<td width='15%' align='center'style='font-weight:350 !important ;font-size: 16px !important;'>"+ strExpDate + "</td>");
								 
								 
								}
				
								sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+ Math.round(Double.parseDouble(strQty)) + "</td>");

								sb.append("<td width='12%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'><input type='text' name='strReceivedQty'  class='form-control' id='strReceivedQty"+i+"' value='"+Math.round(Double.parseDouble(strQty))+"' onkeypress='return validateData(event,5);'  onblur='notGreaterThanReceQty(this,\""+i+"\"');' readonly /></td>");
								sb.append("</tr>");
								i++;
							}
						 sb.append("</tbody>");
						 sb.append("</table>");
			 	  }else 
			 	  {
					    
						sb.append("<div class='errMsg' colspan='5' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>");
				  } 
			}
			catch(Exception e)
			{
				e.printStackTrace(); 
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
			   
				  //sb.append("<div class='legendHeader my-2' id='' style='font-weight:600;font-size: 16px;'>Drug Detail(s)</div>");

				  sb.append("<table class='table'>");

					sb.append("<thead class='thead-dark'>");

					sb.append("<tr>");
						sb.append("<th width='40%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Drug Name</th>");
						sb.append("<th width='18%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Batch No</th>");
			  
			   if(formBean.getStrRequestType().equals("51"))
			   {	   
			   sb.append("<th width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Transfer Qty.</th>");

			   }
			   if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
			   {	   
			   sb.append("<th width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Issue Qty.</th>");
			   }
			   if(formBean.getStrRequestType().equals("18"))
			   {	   
			   sb.append("<th width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Return Qty.</th>");
			   }
			   sb.append("<th width='12%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>Received Qty.</th>");
			   sb.append("</tr> ");
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
							sb.append("<td width='40%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+ strItemName + "</td>");
					/*
					 * sb.append("<td width='37%' class='multiPOControl'>"); sb.append(strItemName);
					 * sb.append("</td>");
					 */
							sb.append("<td width='18%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+ strBatchNo + "</td>");
					/*
					 * sb.append("<td width='18%' class='multiPOControl'>"); sb.append(strBatchNo);
					 * sb.append("</td>");
					 */
							sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+ strQtyUnit + "</td>");
					/*
					 * sb.append("<td width='15%' class='multiPOControl'>"); sb.append(strQtyUnit);
					 * sb.append("</td>");
					 */
							sb.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+ strRecQty + "</td>");
					/*
					 * sb.append("<td class='multiPOControl' width='15%'>"); sb.append(strRecQty);
					 * sb.append("</td>");
					 */
							
							sb.append("</tr>");
							i++;
						}
					 sb.append("</tbody>");
			  	     
		 	  }else {
					sb.append("<div class='errMsg' colspan='5' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>");
			   } 
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
			throw new HisException("Acknowledge Transaction","AcknowledgeTransHLP.getItemDetails()-->",e.getMessage());
		}
	return sb.toString();
	}
	
	
	
	public static String getViewItemDetailsBS(AcknowledgeTransFB formBean)
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
			   sb.append("<th>Drug Name</th>");
			   sb.append("<th>Batch No</th>");
			   if(formBean.getStrRequestType().equals("51"))
			   {	   
			   sb.append("<th>Transfer Qty.</th>");
			   }
			   if(formBean.getStrRequestType().equals("17")|| formBean.getStrRequestType().equals("31"))
			   {	   
			   sb.append("<th>Issue Qty.</th>");
			   }
			   if(formBean.getStrRequestType().equals("18"))
			   {	   
			   sb.append("<th>Return Qty.</th>");
			   }
			   
			   sb.append("<th>Received Qty.</th></thead>");
			   //sb.append("</table>");
			   //sb.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' border='0' cellspacing ='1px'>");
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
							
							sb.append("<tbody>");
							sb.append("<td>");
							sb.append(strItemName);
							sb.append("</td>");
							sb.append("<td>");
							sb.append(strBatchNo);
							sb.append("</td>");
							sb.append("<td>");
							sb.append(strQtyUnit);
							sb.append("</td>");	
							
							sb.append("<td>");
							sb.append(strRecQty);
							sb.append("</td>");	
							sb.append("</tbody>");
							i++;
						}
					 sb.append("</table>");
			  	     
		 	  }else {
				    sb.append("<table class='table' align='center'  bgcolor='#6097BC'  border='0'  cellspacing ='1px'>"); 
				    sb.append("<tbody>");
				    sb.append("<td>"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>" + "</TD>");
	
				    sb.append("</tbody>");
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
						
						sb.append("<div class='container'>");
						//sb.append("<div class='legendHeader my-2' id='' style='font-weight:600;font-size: 16px;'>Acknowledge Details</div>");

						 sb.append("<div class='row'>");
					      sb.append("<div class='col-sm-3'>Acknowledge Date</div>");
						  sb.append("<div class='col-sm-3' colspan='3'>");
						  	sb.append(strAckDate);
						  sb.append("</div>");
						
					      sb.append("<div class='col-sm-3'>Acknowledge By</div>");
						  sb.append("<div class='col-sm-3' colspan='3'>");
							sb.append(strAckBy);
						 sb.append("</div></div>");
						
						 sb.append("<div class='row'>");
						  sb.append("<div class='col-sm-3'>Remarks</div>");
						  sb.append("<div class='col-sm-9' colspan='3'>");
							sb.append(strRemarks);
						  sb.append("</div></div>");
						 sb.append("</div>");

						  
					/*	sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
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
						sb.append("</table>"); */
					}
				}
				else {
					    /*
					    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#6097BC' cellspacing ='1px'>"); 
					    sb.append("<tr>");
					    sb.append("<td colspan='4'  CLASS='multiControl' >"
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>" + "</TD>");

					    sb.append("</tr>");
					    sb.append("</table>"); */
						
						sb.append("<div class='errMsg' colspan='4' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>");
						sb.append("</div>");

				   } 
			}catch(Exception e){
	 
				throw new HisException("Acknowledge Transaction","AcknowledgeTransHLP.getAckDtls()-->",e.getMessage());
			}
		return sb.toString();
		}
	 
	 public static String getAckDtlsBS(WebRowSet ws)
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
						 sb.append("<div class='row'>");
					     sb.append("<div class='subHeaders col-sm-12'>Acknowledge Details</div>");
					     sb.append("</div>");
						//sb.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>");
						//sb.append("<tr><td colspan='4' class='TITLE'>Acknowledge Details1</td></tr>");
						sb.append("<div class='row'><div class='col-sm-2'></div><div class='col-sm-2'>Acknowledge Date</div>");
						sb.append("<div class='col-sm-2' style='font-weight: 400; color: blue;'>");
						sb.append(strAckDate);
						sb.append("</div>");
						sb.append("<div class='col-sm-2'>Acknowledge By</div>");
						sb.append("<div class='col-sm-4' style='font-weight: 400; color: blue;'>");
						sb.append(strAckBy);
						sb.append("</div></div>");
						sb.append("<div class='row'><div class='col-sm-2'></div><div class='col-sm-2'>Remarks</div>");
						sb.append("<div class='col-sm-4' style='font-weight: 400; color: blue;'>");
						sb.append(strRemarks);
						sb.append("</div></div>");
						//sb.append("</table>");
					}
				}
				else {
					    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#6097BC' cellspacing ='1px'>"); 
					    sb.append("<tbody>");
					    sb.append("<td colspan='4' >"
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED DATA </div>" + "</TD>");

					    sb.append("</tbody>");
					    sb.append("</table>");
						
				   } 
			}catch(Exception e){
	 
				throw new HisException("Acknowledge Transaction","AcknowledgeTransHLP.getAckDtls()-->",e.getMessage());
			}
		return sb.toString();
		}
	 
	 
	 public static String getAckVoucherDtl(AcknowledgeTransFB formBean) throws Exception {

			StringBuffer sb = new StringBuffer("");
			String strIssueBy = "";
			String strRecivedBy = "";
			String strPurchaseCost="";
			String strRemarks="";
			/*
			String str2 = "76.39";
			float f = Float.parseFloat(str2);
			String str = "5";
			Float f = new Float(str);
			double d = f.doubleValue();
			
			*/
			double cltamt  = 0.00;
			double totalCost = 0.00;
			
			double cltamt1  = 0.00;
			double totalCostWithoutSC = 0.00;
			
			
			String strStoreName="";
			 String returnTo="";
			int i=1;
			String strItemTotCost="0.00";
			String strItemTotCostWithOutSC ="0.00";
			String strBudgetUsed ="0.00",strApplyClass="";
			HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
			
			ResourceBundle res = mms.qryHandler_mms.res;
			if(res == null) 
			{
				res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = res;
			}
			
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());	
			
			String configIssueRate = mmscofigutil.getStrConfigIssueRate();
			DecimalFormat myFormatter = new DecimalFormat("0.00");

			WebRowSet ws = formBean.getWsIssueDetails();
	        
			String strIssueDate = "";

			if (formBean.getStrIssueDate().length() > 2) 
			{
				strIssueDate = formBean.getStrIssueDate();
			}
			
			String strTableWidth = "825";

			try 
			{
				HisUtil hisUtil=new HisUtil("Global","ReportUtil");
				HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(formBean.getStrHospitalCode());
				
				//System.out.println("hospitalVO.getAddress1()"+hospitalVO.getHospitalName());
				//System.out.println("the ws length isa  "+ws.getKeyColumns());
				
				sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
				sb.append("<tr><td align='center'><div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td> ");
				sb.append("</tr> ");
				sb.append("</table> ");

				if (formBean.getStrModeVal().equals("3")) 
				{

					sb.append(
									"<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
							.append(strTableWidth)
							.append(
									"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Third Party Issue Details</b></font></td></tr></table> ");

				} 
				else 
					if 
					(formBean.getStrModeVal().equals("4")) 
					{
					sb
							.append(
									"<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
							.append(strTableWidth)
							.append(
									"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Acknowledge</b></font></td></tr></table> ");
				} 
				else 
				{
					if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
					{
					     sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
							.append(strTableWidth)
							.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Report For&nbsp;Issue Details</b></font></td></tr></table> ");
					}
					else
					{
						sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
						.append(strTableWidth)
						.append("'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report For&nbsp;Return Details</b></font></td></tr></table> ");

						
					}	

				}

				if (formBean.getStrStoreName().length() != 0) 
				{
					if(!formBean.getStrModeVal().equals("4"))
					{
					sb.append(
									"<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
							.append(strTableWidth).append(
									"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>(").append(
									formBean.getStrStoreName()).append(
									")</b></font></td></tr></table>");
					}
					else
					{
						sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='")
					.append(strTableWidth).append(
							"'><TR> <td align='center' ><font face='Verdana, Arial, Helvetica, sans-serif' > <b>Acknowledging Store : ").append(
							formBean.getStrStoreName()).append(
							"</b></font></td></tr></table>");
					}

				}
				
				
				sb.append("<table border='0' width='").append(strTableWidth)
						.append("' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='right'>");
				sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /> </div></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");
				sb.append(" <br> ");
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");

				
				if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
				{	

					sb.append("<tr> ");
		
					sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Issue No. :", 15,0)).append(formBean.getStrIssueNo())
							.append("</b></font></td> ");
		
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Issue Date", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
							"</b></font></td> ");
					sb.append("</tr> ");
								
					if (!formBean.getStrIndentNo().equals("0")) 
					{
						sb.append("<tr> ");
						sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Request No. :", 15,0)).append(formBean.getStrIndentNo())
								.append("</b></font></td> ");
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Request Date", 15,0)).append(	":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								formBean.getStrIndentDate()).append("</b></font></td> ");
						sb.append("</tr> ");
		
					}
					if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("4"))
					{
						sb.append("<tr> ");
						sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Issue To :", 15,0)).append(formBean.getStrIssueTo().split("@")[0])
								.append("</b></font></td> ");
						if(!formBean.getStrModeVal().equals("2") && !formBean.getStrModeVal().equals("4")){
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("CR No.:", 15,0)).append("</b></font></td> ");
						sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								formBean.getStrCrno()).append("</b></font></td> ");
						}
						sb.append("</tr> ");
					
					    sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
					}
					else
					{
						sb.append("<tr> ");
						if(!formBean.getStrModeVal().equals("4"))
						{
							sb.append("<td width='25%' align='LEFT'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Issue To", 15,0)).append(":</b></font></td> ");
							sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
							
							sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
									util.appendSpace("", 15,0)).append("</b></font></td> ");
							sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append("</b></font></td> ");
						}
						else
						{
							sb.append("<td width='50%' align='CENTER'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
									util.appendSpace("Issuing Store :", 15,0)).append(formBean.getStrOrgName())
									.append("</b></font></td> ");	
								sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Indent Type : </b></font></td> ");
								sb.append("<td width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue to Store</b></font></td> ");
						}
		
						
						
						sb.append("</tr> ");
					
					    sb.append("<tr><TD COLSPAN='4'>&nbsp;</td></tr>");
						
					}	
				}
				else
				{
					sb.append("<tr> ");
					
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Return No.", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(formBean.getStrIssueNo())
							.append("</b></font></td> ");
		
					sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
							util.appendSpace("Return Date", 15,0)).append(":</b></font></td> ");
					sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(strIssueDate).append(
							"</b></font></td> ");
					sb.append("</tr> ");
								
					if(formBean.getStrModeVal().equals("5") && formBean.getStrModeVal().equals("6"))
					{
						if(formBean.getStrReturnReqNo()!=null && !formBean.getStrReturnReqNo().equals("") && !formBean.getStrReturnReqNo().equals("0"))
						{
							sb.append("<tr> ");
							sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;").append(
									util.appendSpace("Return Req. No.", 15,0)).append(
									":</b></font></td> ");
							sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
									formBean.getStrReturnReqNo()).append("</b></font></td> ");
							sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>&nbsp;").append(
									util.appendSpace("Return Req. Date", 15,0)).append(
									":</b></font></td> ");
							sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
									formBean.getStrIndentDate()).append("</b></font></td> ");
							sb.append("</tr> ");
						}
					}
						
		               
						if (ws != null && ws.size() > 0) 
						{

							while (ws.next()) 
							{
								returnTo = ws.getString(4);
								
							}
							ws.beforeFirst();
						}	
						sb.append("<tr> ");
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Return From", 15,0)).append(":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								formBean.getStrIssueTo().split("@")[0]).append("</b></font></td> ");
						sb.append("<td width='25%' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								util.appendSpace("Return To", 15,0)).append(":</b></font></td> ");
						sb.append("<td width='25%' ><font face='Verdana, Arial, Helvetica, sans-serif' ><b>").append(
								returnTo).append("</b></font></td> ");


						sb.append("</tr> ");
					
				}				
				//sb.append("<tr><TD COLSPAN='4' align='left'><b>**[T/S] - Temprature Senstive </b></td></tr>");
				sb.append("</table> ");

				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px' border='0px'> ");

				sb.append("<tr bgcolor='#cdc9c9'> ");
				sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>S.No.</b></font> ");
				sb.append("</td>");
							
				sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font> ");
				sb.append("</td>");


				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch/Serial No.</b></font> ");
				sb.append("</td> ");
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font>");
				sb.append("</td> ");
				sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/Unit</b></font> ");
				sb.append("</td> ");
				if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
				{
					if(formBean.getStrModeVal().equals("2"))
					{
						sb.append("<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sanc. Qty</b></font>");
						 sb.append("</td> ");
					}
				   sb.append("<td align='center' width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font>");
				   sb.append("</td> ");
				   if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
					{

				      sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
				      sb.append("</td> ");
					}
				}
				else
				{
					sb.append("<td align='center' width='14%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Return Qty</b></font> ");
					sb.append("</td> ");
					 sb.append("<td align='center' width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Cost</b></font>");
				      sb.append("</td> ");
				}	
				sb.append("</tr> ");

				if (ws != null && ws.size() > 0) 
				{

					while (ws.next()) 
					{
						

						   if(ws.getString(23).equals("1")) 
					       {
					    	 strApplyClass = "#DCDCDC";				    	   
					       }
					       else
					       {
					    	 strApplyClass = "";    				    	   
					       }
						
						   
						NumberFormat formatter = new DecimalFormat("############.##");  	

						if (formBean.getStrModeVal().equals("4")) 
						{
							
							strIssueBy              = ws.getString(28);
							strRecivedBy            = ws.getString(27);
							strItemTotCost  		= ws.getString(30);
							strPurchaseCost 		= ws.getString(32);
							strItemTotCost          = formatter.format(new BigDecimal(ws.getString(30)));
							
							if(ws.getString(33) == null || ws.getString(33).equals(""))
								strItemTotCostWithOutSC = "0";
							else
								strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(33)));
						} 
						else 
						{
							if (formBean.getStrModeVal().equals("2"))
							{							
								strStoreName    		= ws.getString(4);	
								strRemarks              = ws.getString(27);
								strRecivedBy    		= ws.getString(28);
								strItemTotCost          = ws.getString(29);
								
								strPurchaseCost         = ws.getString(33);  // With Unit Like e.g. 161 No.
													    
								strItemTotCost          = formatter.format(new BigDecimal(ws.getString(29)));  
								strItemTotCostWithOutSC = formatter.format(new BigDecimal(ws.getString(34)));
							//	strBudgetUsed           = formatter.format(new BigDecimal(ws.getString(35)));
							}
							else
							{
								if(formBean.getStrModeVal().equals("3"))
								{
									
								//	strRemarks   = ws.getString(25);
								//	strRecivedBy = ws.getString(26);
								}
								else
								{
									if(formBean.getStrModeVal().equals("1") || formBean.getStrModeVal().equals("6"))
									{
										
										if(formBean.getStrModeVal().equals("1"))
										{
											strRemarks   = ws.getString(26);
											strRecivedBy = ws.getString(25);
										}
									
										strItemTotCost = formatter.format(new BigDecimal(Double.parseDouble(formatter.format(new BigDecimal(ws.getString(16)))) * Double.parseDouble(ws.getString(19))));
									}
								}
							}
							
						}
						
						cltamt1  = Double.parseDouble(strItemTotCostWithOutSC);
						
						totalCostWithoutSC = totalCostWithoutSC + cltamt1;   //Calculate Total Cost Without Service Charge
						 
						cltamt  = Double.parseDouble(strItemTotCost);    
											
						totalCost = totalCost + cltamt;                      //Calculate Total Cost With Service Charge
												
						sb.append("<tr bgcolor='"+strApplyClass+"'> ");
						sb.append("<td align='center' width='5%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>");
						sb.append(i);
						sb.append("</b></font></td> ");
						
						
						sb.append("<td align='left' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' size='1' ><b>");
						sb.append(ws.getString(6));
						sb.append("</b></font></td> ");


						sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(7));
						sb.append("</font></td> ");
						sb.append("<td align='center' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(8));//debug
						sb.append("</font></td> ");
						sb.append("<td style=\"text-align:center;\" width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(9));
						sb.append("</font></td> ");
						if(formBean.getStrModeVal().equals("2"))
						{
							sb.append("<td style=\"text-align:center;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							sb.append(ws.getString(37));
							sb.append("</font></td> ");
						}
						sb.append("<td style=\"text-align:center;\" width='9%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						sb.append(ws.getString(10));
						sb.append("</font></td> ");
						if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5") )
						{

							sb.append("</font></td> ");  
							sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							sb.append(myFormatter.format(new BigDecimal(strItemTotCost)));
							//myFormatter.format(Double.parseDouble(ws.getString(6)))
							sb.append("</font></td> ");  
						}
						if(formBean.getStrModeVal().equals("5"))
						{
							sb.append("</font></td> ");  
							sb.append("<td style=\"text-align:right;\" width='4%'><font face='Verdana, Arial, Helvetica, sans-serif' >");
							sb.append(myFormatter.format(new Float(ws.getString(10).split(" ")[0])*new Float(ws.getString(9).split("/")[0])));
							//myFormatter.format(Double.parseDouble(ws.getString(6)))
							sb.append("</font></td> ");  
						}
						sb.append("</tr> ");
						i++;
									
					}
									
					if(!formBean.getStrModeVal().equals("3") && !formBean.getStrModeVal().equals("5"))
					{	
						NumberFormat formatter = new DecimalFormat("############.##");  
					    					
						String ServiceCharge ="";
						
						String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
						
						sb.append("<tr>");
						sb.append("<td colspan='6' align='left'><hr size='2'></td>");
						sb.append("<td colspan='2' align='center'><hr size='2'></td>");
						
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='6' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><div align='right'><b>TOTAL Rs.(Round)</b></div></font></td>");
						sb.append("<td colspan='2' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
						//sb.append(myFormatter.format(Double.parseDouble(FinaltotalCost)));	
						sb.append(Math.round(Double.parseDouble(FinaltotalCost)));
						sb.append("</font></td>");
						sb.append("</tr>");
						
						sb.append("<tr>");
						sb.append("<td colspan='6' align='left'><hr size='2'></td>");
						sb.append("<td colspan='2' align='center'><hr size='2'></td>");
						
						sb.append("</tr>");
						
						
						if(formBean.getStrModeVal().equals("2") || formBean.getStrModeVal().equals("4"))  // To Show Issue Off-Line Voucher
						{
							
							/*
							  Total 33 Value Return In Case of ModeVal 2 (Which Call in Case of Off-Line Issue Voucher)
							  1.Issue No
							  2.Issue Date
							  3.Issue To 
							  4.Issue By
							  5.Generic Name
							  6.Brand Name
							  7.Batch No
							  8.Expiry date
							  9.Issue rate
							  10.Issue Qty
							  11.Store Id
							  12.Item Id
							  13.Item Brand ID
							  14.Batch No
							  15.Expiry Date
							  16.Issue Rate
							  17.Issue Rate Unit Id
							  18.Issue Rate Base Unit Id
							  19.Issue Qty
							  20.Issue Qty Unit Id
							  21.Issue Qty Base Value
							  22.Item Sl No
							  23.Item SL No
							  24,Category Code
							  25.Issue Qty
							  26.Remarks
							  27.Final remarks
							  28.Received By
							  29.Cost
							  30.Total Avl Budget
							  31.Indent No
							  32.Indent Date
							  33.Purchase Rate e.g 101 No.
							  34.Cost With Purchae Rate 
							  35.Budget Used
							 */
							String FinaltotalCostWithoutSc = formatter.format(new BigDecimal(totalCostWithoutSC)); 
							if(configIssueRate.equals("") || configIssueRate == null)
								configIssueRate = "0";
							double IssueRatePercentage  = Double.parseDouble(configIssueRate);
							
							
							double PurchaseCost         =  Double.parseDouble(strItemTotCost);
						
							double serviceCharge        = totalCost - totalCostWithoutSC;
							
							ServiceCharge        = formatter.format(new BigDecimal(serviceCharge));
							
							
							double costWithServiceChag = totalCostWithoutSC + serviceCharge;
							
										
							
						}				 
						
					
					}
					if (formBean.getStrModeVal().equals("4")) 
					{

						
						sb.append("<tr> "); 
						sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
						sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
						sb.append(formBean.getStrFinalRemarks());
						sb.append("<br></font></td>");
				        sb.append("</tr> ");
						
						
						sb.append("<tr> ");
						if(!formBean.getStrModeVal().equals("4"))
						{
							sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b> &nbsp;&nbsp;</font></td> ");
							sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By<br><b> &nbsp;&nbsp;</font></td> ");
							sb.append("</tr> ");
							sb.append("<tr> ");
		//					sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(").append(strRecivedBy).append(")<br><b> &nbsp;&nbsp;</font></td> ");
							sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>").append("<br><b> &nbsp;&nbsp;</font></td> ");
							sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>(")
									.append(strIssueBy).append(
											")<br><b> &nbsp;&nbsp;</font></td> ");
						}
						else
						{
							sb.append("<td colspan='4' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br>.</font></td> ");
							sb.append("<td colspan='4' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Acknowledged By :").append(formBean.getStrUserName()).append("<br><b> &nbsp;&nbsp;</font></td> ");
						}
						sb.append("</tr> ");
						
						
					} 
					
					else 
					{

						if(!formBean.getStrModeVal().equals("5") && !formBean.getStrModeVal().equals("6"))
						{
							if(!formBean.getStrModeVal().equals("3"))
							{	
								
						        sb.append("<tr> "); 
								sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received By:</font></td>");
								sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");							
								sb.append(strRecivedBy.trim());									
								sb.append("</font></td>");
						        sb.append("</tr> ");   							
						        sb.append("<tr> "); 
								sb.append("<td colspan='2' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Remarks:<b></font></td>");
								sb.append("<td colspan='6' align='left'><font face='Verdana, Arial, Helvetica, sans-serif'>");
								System.out.println("check Params::"+formBean.getStrFinalRemarks());
								
								
								/*if(!formBean.getStrFinalRemarks().equals("")||!formBean.getStrFinalRemarks().equals(" ")||!formBean.getStrFinalRemarks().equals(null))
								{
								    sb.append(formBean.getStrFinalRemarks().trim());
								} 
								else
								{
									sb.append("--------");	
								}	*/
								sb.append(strRemarks);	
								sb.append("</font></td>");
						        sb.append("</tr> ");      
						        sb.append("<tr> ");
						        if(formBean.getStrModeVal().equals("1"))
						        {
						        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>[ &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp;"+formBean.getStrUserName()+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
						        	sb.append("</tr> ");      
								    sb.append("<tr> ");
						        	sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>* In case of not issued items , kindly contact billing desk for refund.<b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
						        }
						        else{
						        	sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Issued By : "+formBean.getStrIssueTo().split("@")[1]+"<b>&nbsp;&nbsp;</font></td> ");	
						        }
								sb.append("</tr> ");
								if(formBean.getStrModeVal().equals("2"))
						        {
								sb.append("<tr> ");
					        	sb.append("<td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b>Approval Remarks :<b>&nbsp;&nbsp;</font></td></tr> ");
					        	int lth = formBean.getStrApprovalRemarks().split("#").length;
					        	for(int q=0;q<lth;q++)
					        		sb.append("<tr><td colspan='8' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><b> "+(q+1)+'.' +formBean.getStrApprovalRemarks().split("#")[q]+"<b>&nbsp;&nbsp;</font></td></tr> ");
					        	//sb.append("</tr> ");
						        }
								//sb.append("<tr> ");
								//sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Issued By on Behalf of RMSCL<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
								//sb.append("</tr> ");
								
							}
							else
							{
								if(formBean.getStrModeVal().equals("3"))
								{
								
									sb.append("<tr> "); 
									sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
									sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");
									sb.append(strRemarks);	
									sb.append("<br></font></td>");
							        sb.append("</tr> ");
									sb.append("<tr> ");
									sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
									sb.append("</tr> ");
									sb.append("<tr> ");
									sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
													")<b> &nbsp;&nbsp;</font></td> ");
									sb.append("</tr> ");
									
								}
								else
								{
									sb.append("<tr> "); 
									sb.append("<td colspan='1' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Remarks:<br><b></font></td>");
									sb.append("<td colspan='7' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br>");								
									sb.append(strRemarks);										
									sb.append("<br></font></td>");
							        sb.append("</tr> ");								
									sb.append("<tr> ");
									sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><b>Received By<br><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td> ");
									sb.append("</tr> ");
									sb.append("<tr> ");
									sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>(").append(strRecivedBy).append(
													")<b> &nbsp;&nbsp;</font></td> ");
									sb.append("</tr> ");
								}
							}	
							
											
						}
						else
						{
							
							sb.append("<tr> ");
							sb.append("<td colspan='8' align='right'><font face='Verdana, Arial, Helvetica, sans-serif' ><br><br><br><br><b>Received By : "+formBean.getStrIssueTo().split("@")[1]+"<br><b> &nbsp;&nbsp;</font></td> ");
							sb.append("</tr> ");
							
						}	
					}

				} 
				else 
				{

					sb.append("<tr> ");
					sb
							.append("<td colspan='8' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available/Requested Qty not available</b><br/><br/></font></td> ");
					sb.append("</tr> ");

				}

				sb.append("</table> ");

			} catch (Exception e) {

				e.printStackTrace();

				throw e;
			}
			finally {
				mmscofigutil = null;
			}

			return sb.toString();
		}
}
