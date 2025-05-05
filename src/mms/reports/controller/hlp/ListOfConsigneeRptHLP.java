package mms.reports.controller.hlp;

import hisglobal.utility.HisUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.ListOfConsigneeRptVO;

public class ListOfConsigneeRptHLP 
{
	public static String getPoDtlOne(ListOfConsigneeRptVO vo) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 100;
		final int PAGE_PER_BLOCK = 100;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		WebRowSet ws =null;
		try
	    {   		
			/* Value Pass in Web Row Set
			  1. PO_NO
			  2. PO_DATE
			  3. PO_REF_NO
			  4. SUPPLIER_NAME
			  5. SUPPLIER_ID	
			  6. STORE_ID
			  7. ITEM_CAT_NO
			  8. po_store_id
			  
			 */
			ws= vo.getStrPOWs();
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>PO Details</td></tr></table>");	
		if (ws != null) 
		{
			if(ws.size() != 0)
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
			 
			    br.append("<input type='hidden' name='TotalLayer'  value='"+totalLayer+"'>");
			    br.append("<input type='hidden' name='RecordShowOnPage'  value='"+REC_PER_PAGE+"'>");
			    br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
			 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
			 br.append("<tr>");
			 br.append("<td class='LABEL'>");
			 NumberFormat formatter = new DecimalFormat("############.##");  
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");			
			
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				//br.append("<tr class='TITLE'>");
				//br.append("<td colspan='4'></td></tr>");
				br.append("<tr>");
				br.append("<td CLASS='multiLabel' colspan='1' width='5%'></td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='12%'>PO No</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='12%'>PO Date</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='32'>PO Ref No</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='39%'>Supplier Name</td>");
				
				br.append("</tr>");
				br.append("</table>");
		    for (int i = 1; i <= totalLayer; i++) 
		    {
			 if (i <= totalLayer) 
			 {
				 
				if (i == 1) 
				{
					br.append("<div id='DivId" +i+ "' style='display:block'>");
				} 
				else
				{
					br.append("<div id='DivId" +i+ "' style='display:none'>");
				}
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{
						/* Value Pass in Web Row Set
						  1. PO_NO
						  2. PO_DATE
						  3. PO_REF_NO
						  4. SUPPLIER_NAME
						  5. SUPPLIER_ID	
						  6. STORE_ID
						  7. ITEM_CAT_NO
						  8. po_store_id
						  
						 */	
						String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8);		
						
						br.append("<tr>");
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
						//br.append("<td class='multiControl' colspan='1' width='5%'><b>");
						//br.append(start);
						//br.append("</b></td>");
						
						br.append("<td class='multiControl' colspan='1' width='5%'><input type='radio' name='strSuppChkIndex' value='0' /></td>");
						br.append("<td class='multiControl' colspan='1' width='12%'>"+ws.getString(1)+"</td>");
						br.append("<td class='multiControl' colspan='1' width='12%'>"+ws.getString(2)+"</td>");
						br.append("<td class='multiControl' style=\"text-align: left;\" colspan='1' width='32%'>"+ws.getString(3)+"</td>");
						br.append("<td class='multiControl' style=\"text-align: left;\" colspan='1' width='39%'>"+ws.getString(4)+"</td>");
						
						br.append("</tr>");
						
						count++ ;
						start++;
					}else{
						break;
					}
				}
					br.append("</table>");
					
					
					br.append("</div>");

			} 
			else 
			{
				br.append("<div id='DivId" + i+ "' style='display:none'>");
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					
					/* Value Pass in Web Row Set
					  1. PO_NO
					  2. PO_DATE
					  3. PO_REF_NO
					  4. SUPPLIER_NAME
					  5. SUPPLIER_ID	
					  6. STORE_ID
					  7. ITEM_CAT_NO
					  8. po_store_id
					  
					 */		
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8);		
					
					br.append("<tr>");
					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					//br.append("<td class='multiControl' colspan='1' width='5%'><b>");
					//br.append(start);
					//br.append("</b></td>");
					
					br.append("<td class='multiControl' colspan='1' width='5%'><input type='radio' name='strSuppChkIndex' value='0' /></td>");
					br.append("<td class='multiControl' colspan='1' width='12%'>"+ws.getString(1)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='12%'>"+ws.getString(2)+"</td>");
					br.append("<td class='multiControl' style=\"text-align: left;\" colspan='1' width='32%'>"+ws.getString(3)+"</td>");
					br.append("<td class='multiControl' style=\"text-align: left;\" colspan='1' width='39%'>"+ws.getString(4)+"</td>");
					//br.append("<td class='multiControl' colspan='1' width='10%'>"+ws.getString(11)+"</td>");
					
					
					br.append("</tr>");
					
					count++ ;
				}
				br.append("</table>");
							
				
				
				br.append("</div>");
				}
		   	}
			  br.append("</div>");
			}
			else
			{
				 
				
				 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				 br.append("<tr>");
				 br.append("<td CLASS='multiLabel' colspan='1' width='5%'></td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='12%'>PO No</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='12%'>PO Date</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='32'>PO Ref No</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='39%'>Supplier Name</td>");
				
				 br.append("</tr>");
				 br.append("<tr>");  
	           	 br.append("<td class='multiControl' colspan='10'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	 br.append("</table>");
	           	
					
			   }
			} 
		    else
				{
					 
					 
		    	 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				 br.append("<tr>");
				 br.append("<td CLASS='multiLabel' colspan='1' width='5%'></td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='12%'>PO No</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='12%'>PO Date</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='28'>PO Ref No</td>");
					br.append("<td CLASS='multiLabel' colspan='1' width='43%'>Supplier Name</td>");
				
				 br.append("</tr>");
				 br.append("<tr>");  
	           	 br.append("<td class='multiControl' colspan='10'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	 br.append("</table>");
		          	
						
				   }
	     }
		
	catch (Exception e) {	
		 
			throw new Exception("OffLineIssueIndentTransHLP.getPoDtlOne()->"+e.getMessage());
		}
		return br.toString();
	}	
	
	
	public static String getConsigneeDtlPrintPopUp(ListOfConsigneeRptVO vo) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 1000;
		final int PAGE_PER_BLOCK = 10;
		double cltamt  = 0.00;
		double totalCost = 0.00;
		String strItemTotCost="0.00";
		String strTableWidth = "700";
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		WebRowSet ws =null;
		String[] strPoListOfConsignee=null;
		String[] strTmp=null;
		String[][] strPoListOfConsigneeDtl=null;
		
		
		if(vo.getStrPoListOfConsignee()!=null && vo.getStrPoListOfConsignee().length()>0)
		{
			strPoListOfConsignee=vo.getStrPoListOfConsignee().replace("@", "#").split("#");
		}
		
		if(strPoListOfConsignee!=null && strPoListOfConsignee.length>0)
		{
			strPoListOfConsigneeDtl=new String[7][strPoListOfConsignee.length];
			for(int l=0; l<strPoListOfConsignee.length; l++)
			{
				strTmp=strPoListOfConsignee[l].replace("^", "#").split("#");
				////System.out.println("strTmp.length  ::::"+strTmp.length);
				if(strTmp!=null && strTmp.length >0){
					for(int j=0; j<strTmp.length; j++){
						strPoListOfConsigneeDtl[j][l]=strTmp[j];
					}
				}
				
			}
		}
		
		
		try
	    {	
			String strStoreIdTmp[]=vo.getStrStoreIdTmp().replace("^", "#").split("^");
			String strStoreNameTmp[] = vo.getStrStoreNameTmp().replace("^", "#").split("^");
			ws= vo.getWrsPoListOfConsignee();
		 /* Value Pass in strPoListOfConsigneeDtl[i]
						1.  PO_NO
						2.  ITEM_BRAND_ID
						3.  ITEM_NAME
						4.  ITEM_SPECIFICATION
						5.  ORDER_QTY
						6.  UNIT
						7.  DELIVERY_LOCATION
						  	
            */
			
			if (strStoreIdTmp != null) 
			{
				if(strStoreIdTmp.length != 0)
				{
					int actualFetchRecord = strStoreIdTmp.length;  
				
					if(totalFetchRecord != actualFetchRecord)
					 {
						totalFetchRecord = actualFetchRecord;
						totalRecordsToManipulate = actualFetchRecord;
					 }
					int totalLayer = totalRecordsToManipulate / REC_PER_PAGE;
					int reminder = totalRecordsToManipulate % REC_PER_PAGE;
					if (reminder > 0)
						totalLayer = totalLayer + 1;
					 
					br.append("<input type='hidden' name='TotalLayer'  value='"+totalLayer+"'>");
					br.append("<input type='hidden' name='RecordShowOnPage'  value='"+REC_PER_PAGE+"'>");
					br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
					br.append("<table  align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
					br.append("<tr style=\"display: none;\">");
					br.append("<td >");
					NumberFormat formatter = new DecimalFormat("############.##");  
					 
					for (int i = 1; i <= totalLayer; i++)
					{
						br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
								+ "</a>|&nbsp;");
					}
					br.append("</td></tr>");
					br.append("</table>");			
		//////////////////////////////////////
			
					br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
					br.append("<tr><td width='8%'>&nbsp;</td> ");
					br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
		//			br.append(res.getString("REPORT_TITLE"));
		//			//System.out.println("ws.getString(4)"+ws.getString(4));
						
					br.append("RAJASTHAN MEDICAL SERVICE CORPORATION LTD., JAIPUR");
				
					br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
					br.append("</tr> ");
					br.append("<tr> ");
					br.append("<td width='8%'>&nbsp;</td> ");
					br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
		//			br.append(res.getString("FULL_TITLE"));
					br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
					br.append("</tr> ");
					br.append("<tr> ");
					br.append("<td width='8%'>&nbsp;</td> ");
					br.append("M/S Iscon Surgical Jodhpur");
					br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
					br.append("List of Consignee (Notification of Award No:"+vo.getStrPoNumber()+" Dated :<br><br>");
			
					br.append("</font></b></td><td width='10%'>&nbsp; ");
					br.append("</td> ");
					br.append("</tr> ");
					
					br.append("</table> ");
					
					
					br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
					br.append("<tr> ");
					br.append("<td align='right'>");
					br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
					br.append("<img style='cursor: pointer; ' title='Print Page'  ");
					br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(1);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
					br.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(1);' /> </div></div>");
					br.append(" </td> ");
					br.append(" </tr> ");
					br.append(" </table> ");
					br.append(" <br> ");
					br.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
				
				
				
					br.append("<table border='1' width='").append(strTableWidth).append("' align='center'> ");
					br.append("<table align='center' cellspacing='1px' cellpadding='1px'>");
					//br.append("<tr class='TITLE'>");
					//br.append("<td colspan='4'></td></tr>");
					br.append("<tr bgcolor='#cdc9c9'> ");
					
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sl. No.</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Code</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='13%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Product Description</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Order Quantity</b></font></td>");
					
				
				
				
				    for (int i = 0; i < totalLayer; i++) 
				    {
						 if (i < totalLayer) 
						 {
							 
							if (i == 0) 
							{
								br.append("<div id='DivId" +i+ "' style='display:block'>");
							} 
							else
							{
								br.append("<div id='DivId" +i+ "' style='display:none'>");
							}
							
							br.append("<table align='center' cellspacing='1px'>");
							
							ws.beforeFirst();
							for (int j = 0; j < REC_PER_PAGE; j++) 
							{
								if(ws.next())
								{
									
									 /* Value Pass in strPoListOfConsigneeDtl[i]
										1.  PO_NO			// award No.
										2.  ITEM_BRAND_ID
										3.  ITEM_NAME      //item code
										4.  ITEM_SPECIFICATION  //pdt specification
										5.  ORDER_QTY
										6.  UNIT
										7.  DELIVERY_LOCATION
									 */
																					
									br.append("<tr>");
									//br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strChallanHidValue+"'>");
									/////
									//br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sl. No.</b></font></td>");
									//br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Code</b></font></td>");
									//br.append("<td style=\"text-align: center;\" colspan='1' width='13%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Product Description</b></font></td>");
									//br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Order Quantity</b></font></td>");
									/////
									
									String strThirdCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6);
									
									
									
									br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(13)+"</td>");
									br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(1)+"</td>");
									br.append("<td style=\"text-align: center;\"  colspan='1' width='13%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"/ "+ws.getString(3)+"</td>");
									br.append("<td style=\"text-align: center;\"  colspan='1' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(4)+"</td>");
									br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(5)+"</td>");
									br.append("<td style=\"text-align: center;\"  colspan='1' width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(6)+"/ "+ws.getString(7)+"</td>");
									br.append("<td style=\"text-align: center;\"  colspan='1' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(8)+"</td>");
									br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(10)+"</td>");
									br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(9)+"</td>");
									br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(11)+"</td>");
									
									br.append("</tr>");
									br.append("<input type='hidden' name='strCheckHidValue2' id='strCheckHidValue2"+count+"' value='"+strThirdCheckHidValue+"'>");
									
									
								}else{
									break;
								}
							}
								br.append("</table>");
								br.append("</div>");
			
						} 
					}
			   	 }
				 br.append("</div>");
			}
			else
			{
				br.append("<table border='1' width='").append(strTableWidth).append("' align='center'> ");
				br.append("<table align='center' cellspacing='1px' cellpadding='1px'>");
				//br.append("<tr class='TITLE'>");
				//br.append("<td colspan='4'></td></tr>");
				br.append("<tr bgcolor='#cdc9c9'> ");
				
				br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplier Name</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='13%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Challan No & Date</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty. Received</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Date</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Report No & Date</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Condition of Drug</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Rajasthan Government supply not for Sale</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether the supplied Medicine is in generic or brand</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Whether Mrp has been printed on the cove</b></font></td>");
				
				br.append("</tr>");
				br.append("<tr>");  
	           	br.append("<td class='multiControl' colspan='10'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	br.append("</table>");
	           	 
					
			}
	    } 		
	catch (Exception e)
	{			 
		e.printStackTrace();
			throw new Exception("SupplierPerformanceDtailRptHLP.getSupplierPerformabceDetailsPopUp1()->"+e.getMessage());
		}
		return br.toString();
	}

	public static int[] posOfDrugLocationInPoListOfConsignee(ListOfConsigneeRptVO vo,String strIdToChk, String[][] strInChk)
	{
		int doneColumn[]=new int[1000];
		int intDoneColSize=-1;
		if(strInChk[0] !=null)
		{
			for(int i=0; i<strInChk[0].length; i++)
			{
				if(strInChk[6][i].equals(strIdToChk))
					doneColumn[++intDoneColSize]=i;
			}
		}
		
		vo.setIntDoneColSize(intDoneColSize+1);
		return doneColumn;
	}
	
	public static String getConsigneeDtlPopUpForPrint(ListOfConsigneeRptVO vo) throws Exception 
	{
		

		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		int doneColumn[]=new int[1000];
		int doneColSize=-1;
		double cltQty  = 0.00;
		double totalQty = 0.00;
		double cltQty1  = 0.00;
		double totalQty1 = 0.00;

		String strItemTotQty="0.00";
		String strItemSupplyQty="0.00";
		final int REC_PER_PAGE = 1000;
		final int PAGE_PER_BLOCK = 10;
		
		
		String strTableWidth = "700";
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		WebRowSet ws =null;
		String[] strTmp,strPoListOfConsignee=null;
		String[][] strPoListOfConsigneeDtl=null;
		
		HisUtil util = new HisUtil("mms", "getIssueDtlsInitView");
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		/*List<String> listPoListOfConsignee = new ArrayList<String>();
		
		for(int z = 0; z< strPoListOfConsignee.length; z++ )
		listPoListOfConsignee.add(strPoListOfConsignee[z]);
		
		List<String[]> listPoListOfConsigneeDtl = new ArrayList<String[]>();
		
		for(int z = 0; z< strPoListOfConsignee.length; z++ )
			listPoListOfConsigneeDtl.add(strPoListOfConsigneeDtl[z]);*/
		
		
		if(vo.getStrPoListOfConsignee()!=null && vo.getStrPoListOfConsignee().length()>0)
		{
			strPoListOfConsignee=vo.getStrPoListOfConsignee().replace("@", "#").split("#");
		}
		

		if(strPoListOfConsignee!=null && strPoListOfConsignee.length>0)
		{
			strPoListOfConsigneeDtl=new String[10][strPoListOfConsignee.length];
			for(int l=0; l<strPoListOfConsignee.length; l++)
			{
				strTmp=strPoListOfConsignee[l].replace("^", "#").split("#");
				////System.out.println("strTmp.length  ::::"+strTmp.length);
				if(strTmp!=null && strTmp.length >0)
				{
					for(int j=0; j<strTmp.length; j++)
					{
						strPoListOfConsigneeDtl[j][l]=strTmp[j];
					}
				}
				
			}
		}
		
		
		try
	    {	
			NumberFormat formatter = new DecimalFormat("############.##");
			String strStoreIdTmp[]=vo.getStrStoreIdTmp().replace("^", "#").split("#");
			String strStoreNameTmp[] = vo.getStrStoreNameTmp().replace("^", "#").split("#");
			ws= vo.getWrsPoListOfConsignee();
		 /* Value Pass in strPoListOfConsigneeDtl[i]
						1.  PO_NO
						2.  ITEM_BRAND_ID
						3.  ITEM_NAME
						4.  ITEM_SPECIFICATION
						5.  ORDER_QTY
						6.  UNIT
						7.  DELIVERY_LOCATION
						  	
            */
			String strLastDrugWarehouseLocId=strStoreIdTmp[0];
			int i=0;
			if (strStoreIdTmp != null && strStoreIdTmp.length != 0) 
			{
				
					int actualFetchRecord = strStoreIdTmp.length;  
				
					if(totalFetchRecord != actualFetchRecord)
					 {
						totalFetchRecord = actualFetchRecord;
						totalRecordsToManipulate = actualFetchRecord;
					 }
					int totalLayer = totalRecordsToManipulate / PAGE_PER_BLOCK;
					int reminder = totalRecordsToManipulate % PAGE_PER_BLOCK;
					if (reminder > 0)
						totalLayer = totalLayer + 1;
					 
					br.append("<input type='hidden' name='TotalLayer'  value='"+totalLayer+"'>");
					br.append("<input type='hidden' name='RecordShowOnPage'  value='"+REC_PER_PAGE+"'>");
					br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
					br.append("<table  align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
					br.append("<tr style=\"display: block;\">");
					br.append("<td >");
					br.append("</td></tr>");
					br.append("</table>");			
			
					br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
					br.append("<tr>");
					//br.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");	
					br.append("<td width='10%'><div  align='right'><img src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");	
					br.append("<td width='80%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
					br.append(res.getString("REPORT_TITLE"));
					br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
					br.append("</tr> ");	
					br.append("<tr> ");
					br.append("<td width='8%'>&nbsp;</td> ");
					br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
					br.append(res.getString("FULL_TITLE"));
					br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
					br.append("</tr> ");
					br.append("<tr> ");
					br.append("<td width='8%'>&nbsp;</td> ");
					br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
					br.append(res.getString("CITY"));
					br.append("</font></b></td><td width='10%'>&nbsp; ");
					br.append("</td> ");
					br.append("</tr> ");
					br.append("</table> ");
					br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
					br.append("<tr><td width='8%'>&nbsp;</td> ");
					br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'>Supplier::");
					br.append(vo.getStrSupplierName());
					br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
					br.append("</tr> ");
					br.append("<tr> ");
					br.append("<td width='8%'>&nbsp;</td> ");
					br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
					br.append("List of Consignee (PO No:<b>"+vo.getStrPoNumber()+"</b>, Date :<b>"+vo.getStrCurrentDate()+"</b>)<br><br>");
					br.append("</font></b></td><td width='10%'>&nbsp; ");
					br.append("</td> ");
					br.append("</tr> ");
					br.append("</table> ");

					br.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> </table>");
					br.append("<tr align='right'> ");
					br.append("<td align='right'>");
					br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
					br.append("<img style='cursor: pointer; ' title='Print Page'  ");
					br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(1);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
					br.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(1);' /> </div></div>");
					br.append(" </td> ");
					br.append(" </tr> ");
					br.append("</table> ");
					br.append(" <br> ");
					br.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> </table>");
				
					br.append("<table align='center' cellspacing='1px' cellpadding='1px' border='1px'>");
					br.append("<tr bgcolor='#cdc9c9'> ");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sl. No.</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Warehouse</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Order Quantity</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Supplied Quantity</b></font></td>");
					br.append("</table>");
					
					br.append("<div id='DivId1' style='display:block'>");
					br.append("<table align='center' cellspacing='1px' cellpadding='1px' border='1px'>");
					for(int p=0,rowCount=1; p<strStoreIdTmp.length; p++)
					{
						 /* Value Pass in strPoListOfConsigneeDtl[p]
							1.  PO_NO			// award No.
							2.  ITEM_BRAND_ID
							3.  ITEM_NAME      //item code
							4.  ITEM_SPECIFICATION  //pdt specification
							5.  ORDER_QTY
							6.  UNIT
							7.  DELIVERY_LOCATION
							8.  Order Qty in Base
							9.  Base Unit
							10. Accepted Qty
						 */
						vo.setIntDoneColSize(0);
						if(strPoListOfConsigneeDtl!=null)
						{
							doneColumn=	posOfDrugLocationInPoListOfConsignee(vo,strStoreIdTmp[p],strPoListOfConsigneeDtl);
						}
						br.append("<tr>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='5%' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+(p+1)+"</b></td>");
						if(vo.getIntDoneColSize()!=0)
						{
							int q;
							for(q=0; q<vo.getIntDoneColSize(); q++)
							{
								if(q!=0)
								{
									br.append("</tr>");
									br.append("<tr>");
									br.append("<td style=\"text-align: center;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ></td>");
								}
								if(q==0)
								{
									br.append("<td style=\"text-align: left;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strStoreNameTmp[p]+"</td>");
								}
								else
								{
									br.append("<td style=\"text-align: left;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ></td>");
								}
								br.append("<td style=\"text-align: left;\"  colspan='1' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strPoListOfConsigneeDtl[2][q+i]+"</td>");
								//br.append("<td style=\"text-align: center;\"  colspan='1' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strPoListOfConsigneeDtl[3][q+i]+"</td>");
								br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strPoListOfConsigneeDtl[4][q+i]+" "+strPoListOfConsigneeDtl[5][q+i]+"</td>");
								br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strPoListOfConsigneeDtl[9][q+i]+"</td>");
								//strLastDrugWarehouseLocId=strPoListOfConsigneeDtl[6][p];
								
								
								
								strItemTotQty = formatter.format(new BigDecimal(strPoListOfConsigneeDtl[7][q+i]));  
								cltQty  = Double.parseDouble(strItemTotQty);
								totalQty = totalQty + cltQty;
								
								
								
							}
															
						}
						else{
							br.append("<td style=\"text-align: left;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strStoreNameTmp[p]+"</td>");
							br.append("<td style=\"text-align: left;\"  colspan='1' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' > --- </td>");
							//br.append("<td style=\"text-align: center;\"  colspan='1' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' > --- </td>");
							br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >0 No.</td>");
							br.append("<td style=\"text-align: right;\"  colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >0 No.</td>");
							
						}
						i+=vo.getIntDoneColSize();
						br.append("</tr>");
							     
					}
					String strFinaltotalQty  = formatter.format(new BigDecimal(totalQty)); 
					
					br.append("<tr bgcolor='#cdc9c9'>");
					br.append("<td width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
					br.append("<td width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
					br.append("<td style=\"text-align: center;\"  width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Order Quantity</b></font></td>");
					//br.append("<td style=\"text-align: center;\" colspan='1' width='50%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Order Quantity</b></font></td>");
					br.append("<td style=\"text-align: right;\"  width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>"+strFinaltotalQty+" "+strPoListOfConsigneeDtl[8][0]+"</b></font></td>");
					br.append("<td style=\"text-align: right;\"  width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
					
					br.append("</tr>");
					br.append("</table>");
					
					
					
					br.append("</div>");
			   
			}
			else
			{
				br.append("<table border='1' width='").append(strTableWidth).append("' align='center'> ");
				br.append("<table align='center' cellspacing='1px' cellpadding='1px'>");
				//br.append("<tr class='TITLE'>");
				//br.append("<td colspan='4'></td></tr>");
				br.append("<tr bgcolor='#cdc9c9'> ");
				
				br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Sl. No.</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Warehouse</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='45%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Code</b></font></td>");
				//br.append("<td style=\"text-align: center;\" colspan='1' width='30%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Product Description</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Order Quantity</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Order Quantity</b></font></td>");
				
				br.append("</tr>");
				br.append("<tr>");  
	           	br.append("<td class='multiControl' colspan='10'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	br.append("</table>");
	           	 
					
			}
			////System.out.println("br.toString() ::");
			////System.out.println(br.toString());
	    } 		
	catch (Exception e)
	{			 
		e.printStackTrace();
			throw new Exception("SupplierPerformanceDtailRptHLP.getSupplierPerformabceDetailsPopUp1()->"+e.getMessage());
		}
		return br.toString();
	}

}
