package mms.transactions.controller.hlp;

import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.ThirdPartyIssueDtlModificationTransBO;
import mms.transactions.vo.ThirdPartyIssueDtlModificationTransVO;

public class ThirdPartyIssueDtlModificationTransHLP 
{
	
	public static String getVoucherDtlHlp(WebRowSet ws,ThirdPartyIssueDtlModificationTransVO vo) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int t = 0;
		int start = 1;
		final int REC_PER_PAGE = 5;
		final int PAGE_PER_BLOCK = 5;		
		double strTotalCostTemp = 0.00;
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		DecimalFormat myFormatter = new DecimalFormat("0.00");
		try
	    {
			
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
			 
			    br.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr class='HEADER'>");
				br.append("<td  colspan='6' style=\"text-align:left;\">");										
				br.append("Drug Details");
				br.append("</td>");
				br.append("</tr>");					
				br.append("</table>");
			    
			    
			 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
			 br.append("<tr>");
			 br.append("<td class='LABEL'>");
			 		 
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			br.append("</td></tr>");
			br.append("</table>");			
			
				
			
			br.append("<table class='TABLEWIDTH' bgcolor='#6097BC' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
			br.append("<tr>");
			br.append("<td WIDTH='5%' colspan='1' class='multiLabel'>#</td>");
			br.append("<td WIDTH='35%' colspan='1' class='multiLabel'>Drug Name</td>");
			br.append("<td WIDTH='20%' colspan='1' class='multiLabel'>Batch No</td>");
			br.append("<td WIDTH='18%' colspan='1' class='multiLabel'>Avl Qty At The Time of Issue</td>");
			br.append("<td WIDTH='10%' colspan='1' class='multiLabel'>Issue Quantity</td>");
			br.append("<td WIDTH='12%' colspan='1' class='multiLabel'>Cost</td>");					
			br.append("</tr> ");
			br.append("</table> ");
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
				
				br.append("<table bgcolor='#6097BC' class='TABLEWIDTH' align='center' cellspacing='1px'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					if(ws.next())
					{
						
//						 * 1. HSTNUM_ITEMBRAND_ID, 
//						 * 2. HSTSTR_BATCH_SL_NO,
//						 * 3. HSTNUM_STOCK_STATUS_CODE,
//						 * 4. ITEM_NAME,
//						 * 5. ISSUE_QTY,
//						 * 6. ITEM_COST,
//						 * 7. CURRENT_AVL_QTY,
//						 * 8. UNIT_NAME
						 
						
						String strRadioTempValue = ws.getString(1) +"^"+ws.getString(2) +"^"+ws.getString(3) +"^0^"+
												   ws.getString(5) +"^"+ws.getString(6) +"^"+ws.getString(7) +"^"+ws.getString(8);
						
						
						br.append("<TR>");
						
						br.append("<input type='hidden' name='strDrugId' value='"+ws.getString(1)+"' />");												
						br.append("<input type='hidden' name='strOldBatchNo' value='"+ws.getString(2)+"' />");	
						br.append("<input type='hidden' name='strOldIssueQty' value='"+ws.getString(5)+"' />");
						br.append("<input type='hidden' name='strUnitId' value='1' />");
						
						vo.setStrBatchNumber(ws.getString(2));
						vo.setStrItemBrandId(ws.getString(1));						
						vo.setStrStockStatusCode(ws.getString(3));
						vo.setStrIssQty(ws.getString(5));
						
						ThirdPartyIssueDtlModificationTransBO.BatchCombo(vo);
						
						 
						
//						NVL(HSTSTR_BATCH_NO,'--') || '^' || 
//						RATE_BASE || '^' || 
//		                INHAND_QTY || '^' || 
//		                UNIT_NAME || '^' || 
//		                HSTNUM_STOCK_STATUS_CODE AS DISP_ID,
//		                NVL(HSTSTR_BATCH_NO,'--') AS DISP_NAME
						 
								
						if(t==0)
						{
							br.append("<TD WIDTH='5%'  colspan='1' style=\'text-align:center;\' CLASS='multiLabel'>"+"<input type='radio' name='strDrugDtls' id='strDrugDtls"+t+"' value='"+strRadioTempValue+"' onclick='getModificationDtls("+t+");' checked >"+"</TD>");
						}
						else
						{
							br.append("<TD WIDTH='5%'  colspan='1' style=\'text-align:center;\' CLASS='multiLabel'>"+"<input type='radio' name='strDrugDtls' id='strDrugDtls"+t+"' value='"+strRadioTempValue+"' onclick='getModificationDtls("+t+");'  >"+"</TD>");							
						}
						
						br.append("<TD WIDTH='35%'  colspan='1' style=\'text-align:left;\' CLASS='multiControl'>"+ws.getString(4)+"</TD>");
						br.append("<TD WIDTH='20%'  colspan='1' style=\'text-align:left;\' CLASS='multiRowControl'><div id='strBatchNo"+t+"'>"+vo.getStrBatchNumber()+"</div></TD>");						
						br.append("<TD WIDTH='18%'  colspan='1' CLASS='multiControl'><div id='avlQtyDivId"+t+"'  >"+ws.getString(7)+" " + ws.getString(8) + "</div></TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiControl'><div id='strIssueQty"+t+"'  >"+ws.getString(5)+"</div></TD>");
						br.append("<TD WIDTH='12%'  colspan='1' style=\'text-align:right;\' CLASS='multiControl'><div id='costDivId"+t+"'  >"+ws.getString(6)+"</div></TD>");
						br.append("</TR>");
						
						strTotalCostTemp = strTotalCostTemp + Double.parseDouble(ws.getString(6));
						t++ ;
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
				
				br.append("<table bgcolor='#6097BC' class='TABLEWIDTH' align='center' cellspacing='1px'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
//					 * 1. HSTNUM_ITEMBRAND_ID, 
//					 * 2. HSTSTR_BATCH_SL_NO,
//					 * 3. HSTNUM_STOCK_STATUS_CODE,
//					 * 4. ITEM_NAME,
//					 * 5. ISSUE_QTY,
//					 * 6. ITEM_COST,
//					 * 7. CURRENT_AVL_QTY,
//					 * 8. UNIT_NAME
					 
					
					String strRadioTempValue = ws.getString(1) +"^"+ws.getString(2) +"^"+ws.getString(3) +"^0^"+
											   ws.getString(5) +"^"+ws.getString(6) +"^"+ws.getString(7) +"^"+ws.getString(8);
					
					
					br.append("<TR>");
					
					br.append("<input type='hidden' name='strDrugId' value='"+ws.getString(1)+"' />");												
					br.append("<input type='hidden' name='strOldBatchNo' value='"+ws.getString(2)+"' />");	
					br.append("<input type='hidden' name='strOldIssueQty' value='"+ws.getString(5)+"' />");
					br.append("<input type='hidden' name='strUnitId' value='1' />");
					
					vo.setStrBatchNumber(ws.getString(2));
					vo.setStrItemBrandId(ws.getString(1));						
					vo.setStrStockStatusCode(ws.getString(3));
					vo.setStrIssQty(ws.getString(5));
					
					ThirdPartyIssueDtlModificationTransBO.BatchCombo(vo);
					
					 
					
//					NVL(HSTSTR_BATCH_NO,'--') || '^' || 
//					RATE_BASE || '^' || 
//	                INHAND_QTY || '^' || 
//	                UNIT_NAME || '^' || 
//	                HSTNUM_STOCK_STATUS_CODE AS DISP_ID,
//	                NVL(HSTSTR_BATCH_NO,'--') AS DISP_NAME
					 
							
					if(t==0)
					{
						br.append("<TD WIDTH='5%'  colspan='1' style=\'text-align:center;\' CLASS='multiLabel'>"+"<input type='radio' name='strDrugDtls' id='strDrugDtls"+t+"' value='"+strRadioTempValue+"' onclick='getModificationDtls("+t+");' checked >"+"</TD>");
					}
					else
					{
						br.append("<TD WIDTH='5%'  colspan='1' style=\'text-align:center;\' CLASS='multiLabel'>"+"<input type='radio' name='strDrugDtls' id='strDrugDtls"+t+"' value='"+strRadioTempValue+"' onclick='getModificationDtls("+t+");'  >"+"</TD>");							
					}
					
					br.append("<TD WIDTH='35%'  colspan='1' style=\'text-align:left;\' CLASS='multiControl'>"+ws.getString(4)+"</TD>");
					br.append("<TD WIDTH='20%'  colspan='1' style=\'text-align:left;\' CLASS='multiRowControl'><div id='strBatchNo"+t+"'>"+vo.getStrBatchNumber()+"</div></TD>");						
					br.append("<TD WIDTH='18%'  colspan='1' CLASS='multiControl'><div id='avlQtyDivId"+t+"'  >"+ws.getString(7)+" "+ws.getString(8)+"</div></TD>");
					br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiControl'><div id='strIssueQty"+t+"'  >"+ws.getString(5)+"</div></TD>");
					br.append("<TD WIDTH='12%'  colspan='1' style=\'text-align:right;\' CLASS='multiControl'><div id='costDivId"+t+"'  >"+ws.getString(6)+"</div></TD>");
					br.append("</TR>");
					
					strTotalCostTemp = strTotalCostTemp + Double.parseDouble(ws.getString(6));

					t++ ;
				}
				br.append("</table>");
				
				br.append("</div>");
				}
		   	}
			 
			  
			  br.append("<table class='TABLEWIDTH' align='center' cellpadding='1' cellspacing='1'>");
					  br.append("<tr>");
							  br.append("<td width='85%' class='LABEL'><b>    Total Cost(Rs.)</b></td>");
									  br.append("<td width='15%' class='CONTROL' style='text-align: right; color:red;' >");
							  br.append("<b>"+ myFormatter.format(strTotalCostTemp)+"</b>");
									  br.append("</td>");
											  br.append("<input type='hidden' name='strTotalCost' />");
								
													  br.append("</tr>");
				
															  br.append("</table>");
			}
			else
			{
				 
				 
				 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr class='HEADER'>");
					br.append("<td  colspan='5' style=\"text-align:left;\">");										
					br.append("Drug Details");
					br.append("</td>");
					br.append("</tr>");					
					br.append("</table>");
					br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td WIDTH='5%' colspan='1' class='multiLabel'>Select</td>");
					br.append("<td WIDTH='35%' colspan='1' class='multiLabel'>Drug Name</td>");
					br.append("<td WIDTH='20%' colspan='1' class='multiLabel'>Batch No</td>");
					br.append("<td WIDTH='18%' colspan='1' class='multiLabel'>Available Quantity</td>");
					br.append("<td WIDTH='10%' colspan='1' class='multiLabel'>Issue Quantity</td>");
					br.append("<td WIDTH='12%' colspan='1' class='multiLabel'>Cost</td>");					
					br.append("</tr> ");
					br.append("</table> ");
				
	           	br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
				br.append("<tr>");
	           	 br.append("<td class='multiControl' colspan='6'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	 br.append("</table>");
	         
					
			   }
			} 
	     }
		
	catch (Exception e) {	
		 
			throw new Exception("OffLineIssueIndentTransHLP.getPendingDemands()->"+e.getMessage());
		}
		return br.toString();
	}
/*	
	*//**
	 * Gets the added Task details.
	 * 
	 * @param ws the ws
	 * 
	 * @return the added Task details
	 *//*
	public static String getVoucherDtlHlp(WebRowSet ws,ThirdPartyIssueDtlModificationTransVO vo) 
	{
		StringBuffer br = new StringBuffer();
		int t=0;
		double strTotalCostTemp=0.0;
		
        try 
		{
        	
			if (ws != null) 
			{
				if (ws.size() != 0) 
				{
					HisUtil hisutil = new HisUtil("MMS", "ChallanPerformanceHLP");  
					br.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr class='HEADER'>");
					br.append("<td  colspan='5' style=\"text-align:left;\">");										
					br.append("Drug Details");
					br.append("</td>");
					br.append("</tr>");					
					br.append("</table>");
					br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td WIDTH='5%' colspan='1' class='multiLabel'>Select</td>");
					br.append("<td WIDTH='35%' colspan='1' class='multiLabel'>Drug Name</td>");
					br.append("<td WIDTH='20%' colspan='1' class='multiLabel'>Batch No</td>");
					br.append("<td WIDTH='18%' colspan='1' class='multiLabel'>Available Quantity</td>");
					br.append("<td WIDTH='10%' colspan='1' class='multiLabel'>Issue Quantity</td>");
					br.append("<td WIDTH='12%' colspan='1' class='multiLabel'>Cost</td>");					
					br.append("</tr> ");
					br.append("</table> ");
					br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
					
					while (ws.next())
					{ 				
						
						 * 1. HSTNUM_ITEMBRAND_ID, 
						 * 2. HSTSTR_BATCH_SL_NO,
						 * 3. HSTNUM_STOCK_STATUS_CODE,
						 * 4. ITEM_NAME,
						 * 5. ISSUE_QTY,
						 * 6. ITEM_COST,
						 * 7. CURRENT_AVL_QTY,
						 * 8. UNIT_NAME
						 
						
						String strRadioTempValue = ws.getString(1) +"^"+ws.getString(2) +"^"+ws.getString(3) +"^"+ws.getString(4) +"^"+
												   ws.getString(5) +"^"+ws.getString(6) +"^"+ws.getString(7) +"^"+ws.getString(8);
						
						
						br.append("<TR>");
						
						br.append("<input type='hidden' name='strDrugId' value='"+ws.getString(1)+"' />");												
						br.append("<input type='hidden' name='strOldBatchNo' value='"+ws.getString(2)+"' />");	
						br.append("<input type='hidden' name='strOldIssueQty' value='"+ws.getString(5)+"' />");
						br.append("<input type='hidden' name='strUnitId' value='1' />");
						
						vo.setStrBatchNumber(ws.getString(2));
						vo.setStrItemBrandId(ws.getString(1));						
						vo.setStrStockStatusCode(ws.getString(3));
						vo.setStrIssQty(ws.getString(5));
						
						ThirdPartyIssueDtlModificationTransBO.BatchCombo(vo);
						
						 * 
						
						NVL(HSTSTR_BATCH_NO,'--') || '^' || 
						RATE_BASE || '^' || 
		                INHAND_QTY || '^' || 
		                UNIT_NAME || '^' || 
		                HSTNUM_STOCK_STATUS_CODE AS DISP_ID,
		                NVL(HSTSTR_BATCH_NO,'--') AS DISP_NAME
						 
								
						if(t==0)
						{
							br.append("<TD WIDTH='5%'  colspan='1' style=\'text-align:center;\' CLASS='multiControl'>"+"<input type='radio' name='strDrugDtls' id='strDrugDtls"+t+"' value='"+strRadioTempValue+"' onclick='getModificationDtls("+t+");' checked >"+"</TD>");
						}
						else
						{
							br.append("<TD WIDTH='5%'  colspan='1' style=\'text-align:center;\' CLASS='multiControl'>"+"<input type='radio' name='strDrugDtls' id='strDrugDtls"+t+"' value='"+strRadioTempValue+"' onclick='getModificationDtls("+t+");'  >"+"</TD>");							
						}
						
						br.append("<TD WIDTH='35%'  colspan='1' style=\'text-align:left;\' CLASS='multiControl'>"+ws.getString(4)+"</TD>");
						br.append("<TD WIDTH='20%'  colspan='1' style=\'text-align:left;\' CLASS='multiRowControl'><div id='strBatchNo"+t+"'>"+vo.getStrBatchNumber()+"</div></TD>");						
						br.append("<TD WIDTH='18%'  colspan='1' CLASS='multiControl'><div id='avlQtyDivId"+t+"'  >"+ws.getString(7)+" "+ws.getString(8)+"</div></TD>");
						br.append("<TD WIDTH='10%'  colspan='1' CLASS='multiControl'><div id='strIssueQty"+t+"'  >"+ws.getString(5)+"</div></TD>");
						br.append("<TD WIDTH='12%'  colspan='1' style=\'text-align:right;\' CLASS='multiControl'><div id='costDivId"+t+"'  >"+ws.getString(6)+"</div></TD>");
						br.append("</TR>");
						
						strTotalCostTemp = strTotalCostTemp + Double.parseDouble(ws.getString(6));
						
						t++; 					
					}	
					
					br.append("</table> ");
					
					br.append("<input type='hidden'  name='strTotalCostTemp' value='"+strTotalCostTemp+"' >");
					
					
						
				}
				
				
			}
			 if(ws.size()==0)
			 {	 
				 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px' cellpadding='1px'>");
				 br.append("<tr class='HEADER'>");
				 br.append("<td  colspan='5' style=\"text-align:right;\">");
				 br.append("ADD ROW'S::::::<input type='text' class='txtFldMin' name='strNoOfMultiRow' value ='' maxlength='100' onkeypress='if(event.keyCode==13) getMultiRow()();'>");					
				 br.append("</td>");
				 br.append("</tr>");    				
				 br.append("</table> ");
				 br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td WIDTH='5%' colspan='1' class='multiLabel'>Select</td>");
					br.append("<td WIDTH='35%' colspan='1' class='multiLabel'>Drug Name</td>");
					br.append("<td WIDTH='20%' colspan='1' class='multiLabel'>Batch No</td>");
					br.append("<td WIDTH='18%' colspan='1' class='multiLabel'>Available Quantity</td>");
					br.append("<td WIDTH='10%' colspan='1' class='multiLabel'>Issue Quantity</td>");
					br.append("<td WIDTH='12%' colspan='1' class='multiLabel'>Cost</td>");						
					br.append("</tr> ");
					br.append("</table> ");
				 br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				 br.append("<TR>");
				 br.append("<td class='multiControl' colspan='10'><b><div id='id' align='center' color='Red'>No Previous Data Exists</div></b></td>");
				 br.append("</TR>");
				 br.append("</table> ");
			 }
		}
		catch (Exception e) 
		{
			e.printStackTrace();

		}
		return br.toString();
	}*/
	
	public static String getVoucherDtlHlp1() 
	{
		StringBuffer br = new StringBuffer();
		int i=0;
        try 
		{
			
				 br.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px' cellpadding='1px'>");
				 br.append("<tr class='HEADER'>");
				 br.append("<td  colspan='5' style=\"text-align:right;\">");
				 br.append("ADD ROW'S::::::<input type='text' class='txtFldMin' name='strNoOfMultiRow' value ='' maxlength='100' onkeypress='if(event.keyCode==13) getMultiRow()();'>");					
					//br.append("<img style='cursor: pointer; style=\'text-align:right;\'  title='Add Row' src='../../hisglobal/images/Go.png' onclick='getMultiRow();'/>");
				 br.append("</td>");
				 br.append("</tr>");    
				
				 br.append("</table> ");
				 br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td WIDTH='35%' colspan='1' class='multiLabel'>Drug Name</td>");
					br.append("<td WIDTH='20%' colspan='1' class='multiLabel'>Batch No</td>");
					br.append("<td WIDTH='18%' colspan='1' class='multiLabel'>Available Quantity</td>");
					br.append("<td WIDTH='10%' colspan='1' class='multiLabel'>Issue Quantity</td>");
					br.append("<td WIDTH='12%' colspan='1' class='multiLabel'>Cost</td>");					
					br.append("<td WIDTH='5%'  colspan='1' class='multiLabel'>#</td>");
					br.append("</tr> ");
					br.append("</table> ");
				
		
		}
		catch (Exception e) 
		{
			

		}
		return br.toString();
	}

	
	

	/**
	 * To get Modification Details Table HLP
	 * 
	 * @param wrsData_p  the WebRowSet
	 */
	public static String getModificationDetailsTable(ThirdPartyIssueDtlModificationTransVO vo)	throws SQLException 
	{
		
		StringBuffer sbTable = new StringBuffer(100);
		StringBuffer sbHeader = new StringBuffer(100);
		StringBuffer sbBody = new StringBuffer(100);
		int nWidth=25;
		int nColspan=6;
		
		sbTable.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >");
		sbTable.append("<tr>"+	"<td class=\"TITLE\" colspan=\"4\" >Modification Details</td>" + "</tr>");
		sbTable.append("</table>");
		
		/*
		 * Header Row:
		 */

		sbHeader.append("<table class=\"TABLEWIDTH\" align=\"center\" border=\"0\" cellspacing =\"1px\" >");
		
		
		if (vo.getStrDrugDtls() != null )
		{	
			try{
//				System.out.println("vo.getStrDrugDtls()"+vo.getStrDrugDtls());
				
				int i=0;
				
				/*
				 * 1. HSTNUM_ITEMBRAND_ID, 
				 * 2. HSTSTR_BATCH_SL_NO,
				 * 3. HSTNUM_STOCK_STATUS_CODE,
				 * 4. ITEM_NAME,
				 * 5. ISSUE_QTY,
				 * 6. ITEM_COST,
				 * 7. CURRENT_AVL_QTY,
				 * 8. UNIT_NAME
				 */
			
				
					String strItemBrandId 			= 	vo.getStrDrugDtls().split("\\^")[0] ;			
					String strBatchNo 				= 	vo.getStrDrugDtls().split("\\^")[1] ;
					String strStockStatusCode 		= 	vo.getStrDrugDtls().split("\\^")[2] ; 
					String strDrugName 				=	vo.getStrDrugDtls().split("\\^")[3] ;
					String strIssQty 				= 	vo.getStrDrugDtls().split("\\^")[4] ;
					String strCost 					= 	vo.getStrDrugDtls().split("\\^")[5] ;
					String strAvlQty 				=	vo.getStrDrugDtls().split("\\^")[6] ;
					String strUnit 					=	vo.getStrDrugDtls().split("\\^")[7] ;				
								
					
					vo.setStrBatchNumber(strBatchNo);
					vo.setStrItemBrandId(strItemBrandId);						
					vo.setStrStockStatusCode(strStockStatusCode);
					vo.setStrIssQty(strIssQty);
					
					ThirdPartyIssueDtlModificationTransBO.BatchCombo(vo);
					/*
					 * 
					
					NVL(HSTSTR_BATCH_NO,'--') || '^' || 
					RATE_BASE || '^' || 
	                INHAND_QTY || '^' || 
	                UNIT_NAME || '^' || 
	                HSTNUM_STOCK_STATUS_CODE AS DISP_ID,
	                NVL(HSTSTR_BATCH_NO,'--') AS DISP_NAME
					 */
					
					if (strBatchNo == null) {
						strBatchNo = "---";
					}
					if (strAvlQty == null) {
						strAvlQty = "---";
					}				
					if (strUnit == null) {
						strUnit = "---";
					}				
					if (strIssQty == null) {
						strIssQty = "---";
					}
					if (strCost == null) {
						strCost = "---";
					}
					
			/*
			 * Table Body
			 */

					sbBody.append("<tr>");		
					sbBody.append("<td colspan='1' WIDTH='25%' class=\"LABEL\" ><font size='2' color='red'>*</font>Batch No</td>");
					sbBody.append("<td  colspan='1' WIDTH='25%' class='CONTROL'><select name='strBatchNo' id='strBatchNo"+i+"' class='comboMax' onchange='splitBatchValues("+i+");' >'"+vo.getStrBatchCombo()+"'</select>"+"</td>");
			
					sbBody.append("<td colspan='1' WIDTH='25%' class=\"LABEL\" >Current Avl Qty</td>");
					sbBody.append("<td colspan='1' WIDTH='25%' class=\"CONTROL\" ><input type='hidden' name='strAvlQty' >"+"<div id='strAvlQtyDivId' value='' ></div></td>");					
					sbBody.append("</tr>");
			
					sbBody.append("<tr>");
					sbBody.append("<td colspan='1' WIDTH='25%' class=\"LABEL\" ><font size='2' color='red'>*</font>Issue Qty</td>");
					sbBody.append("<td colspan='1' WIDTH='25%' class=\"CONTROL\" ><input type='text' name='strIssueQty' maxlength='9' size='10' onkeypress='return validateData(event,5);' value='"+strIssQty+"'  onblur='checkAvailQtyTwo("+i+")'  ></td>");
			
					sbBody.append("<td colspan='1' WIDTH='25%' class=\"LABEL\" >Cost</td>");
					sbBody.append("<td colspan='1' WIDTH='25%' class=\"CONTROL\" ><input type='hidden' name='strCost' >"+"<div id='strCostDivId'  value='"+strCost+"' >"+strCost + "</div></td>");					
					sbBody.append("</tr>");

					sbBody.append("</table>");	
			}
			catch (Exception e) {
				vo.setStrMsgString("ThirdPartyIssueDtlModificationTransHLP.getModificationDetailsTable() --> "+ e.getMessage());
				vo.setStrMsgType("1");
			}
			

		} 
		else 
		{
			sbBody.append("<tr>");
			sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"multiRPTControl\" style=\"text-align: center; color: red;\">No Data Found!</td>");
			sbBody.append("</tr></table>");
		}

		
		
		return sbTable.toString() + sbHeader.toString() + sbBody.toString();
	}


}
