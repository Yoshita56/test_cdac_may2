package mms.reports.controller.hlp;

import java.util.ResourceBundle;

import javax.sql.rowset.WebRowSet;

import mms.reports.vo.StockLedgerRptVO;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16-Mar-2012
 * Modification Date: 
 *  
*/
public class StockLedgerRptHLP 
{
	
		public static String getStockLedger(StockLedgerRptVO vo,String strMode) throws Exception 
		{
		
		StringBuffer br = new StringBuffer();
		WebRowSet ws =	vo.getWrsData();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 100;
		final int PAGE_PER_BLOCK = 10;
		
		double nOpeningBalQtyActive= 0;
		double nOpeningBalQtyInActive= 0;
		double nOpeningBalQtyQuarantine= 0;
		
		double nReceivedQtyActive= 0;
		double nReceivedQtyInActive= 0;
		double nReceivedQtyQuarantine= 0;
		
		double nIssuedQtyActive= 0;
		double nIssuedQtyInActive= 0;
		double nIssuedQtyQuarantine= 0;
		
		double nClosingBalQtyActive= 0;
		double nClosingBalQtyInActive= 0;
		double nClosingBalQtyQuarantine= 0;
		
		
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		try
	    {
			
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Stock Ledger </td></tr></table>");	
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
						    
							br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
							br.append("<tr>");
							br.append("<td class='LABEL'>");				
				   		    for (int i = 1; i <= totalLayer; i++)
							 {
								br.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" +
										  " onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
										+ "</a>|&nbsp;");
							 }
							br.append("</td></tr>");
							br.append("</table>");			
						
							
//							br.append("<table class='TABLEWIDTH' border='0' bgcolor='#CC9966' align='center' cellspacing='1px' cellpadding='1px'>");
//							//br.append("<tr class='TITLE'>");
//							//br.append("<td colspan='4'></td></tr>");
//							br.append("<tr>");
//							
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
//							
//							if(strMode.equals("DRUG_WISE"))
//							{
//								if(vo.getStrMode().equals("1"))
//								{
//									br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Drug Name</td>");
//									
//									br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No.</td>");
//								}
//								else
//								{
//									br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Drug Name</td>");
//								}
//									
//							}
//							else
//							{
//								if(vo.getStrMode().equals("1"))
//								{
//									br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>DDW Name</td>");
//									
//									br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No.</td>");
//								}
//								else
//								{
//									br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>DDW Name</td>");
//								}
//								
//								
//							}
//							
//							
//							br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Opening Balance</td>");
//							br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Received Qty</td>");
//							br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Issued Qty</td>");
//							br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Closing Balance</td>");
//							
//							br.append("</tr>");
//							
//							br.append("<tr>");
//							
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'></td>");
//							
//							if(vo.getStrMode().equals("1"))
//							{
//								br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'></td>");
//								br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
//							}
//							else
//							{
//								br.append("<td CLASS='multiRPTLabel' colspan='1' width='35%'></td>");
//							}
//							
//							
//							// Opening Balance
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Quarantine</td>");
//							// Received Balance
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Quarantine</td>");
//							// Issued Balance
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Quarantine</td>");
//							// Closing Balance
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Active</td>");
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
//							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Quarantine</td>");
//							
//							
//							br.append("</tr>");
//							
//							br.append("</table>");
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
								
										br.append("<table class='TABLEWIDTH' bgcolor='#CC9966' align='center' cellspacing='1px' border='0' >");
										br.append("<tr>");
										
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
										
										if(strMode.equals("DRUG_WISE"))
										{
											if(vo.getStrMode().equals("1"))
											{
												if(vo.getStrItemCatId()!=null && vo.getStrItemCatId().equals("10"))
													br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Drug Name</td>");
												else
													br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Item Name</td>");
												
												br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No.</td>");
											}
											else
											{
												if(vo.getStrItemCatId()!=null && vo.getStrItemCatId().equals("10"))
													br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Drug Name</td>");
												else
													br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Item Name</td>");
											}
												
										}
										else
										{
											if(vo.getStrMode().equals("1"))
											{
												br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Store Name</td>");
												
												br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No.</td>");
											}
											else
											{
												br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Store Name</td>");
											}
											
											
										}
										
										
										br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Opening Balance</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Received Qty</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Issued Qty</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Closing Balance</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Rate/No</td>");
										
										br.append("</tr>");
										
										/*
										br.append("<tr>");
										
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'></td>");
										
										if(vo.getStrMode().equals("1"))
										{
											br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'></td>");
											br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
										}
										else
										{
											br.append("<td CLASS='multiRPTLabel' colspan='1' width='35%'></td>");
										}
										
										
										// Opening Balance
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
										// Received Balance
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
										// Issued Balance
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
										// Closing Balance
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
										
										
										br.append("</tr>");
										*/
										
										String strCssClass =	"multiRPTControl";
										
										for (int j = 0; j < REC_PER_PAGE; j++) 
										{
											if(ws.next())
											{
												
												 /* Value Pass in Web Row Set
												  1.  STR_NAME
												  2.  ITEM_NAME	
												  3.  BATCH_NO	
												  4.  OP_BALANCE	
												  5.  ACTIVE_ISSUE	
												  6.  INACTIVE_ISSUE	
												  7.  QUARTINE_ISSUE	
												  8.  ACTIVE_REC	
												  9.  INACTIVE_REC	
												  10  QUARTINE_REC									  
												  11. STR_ID
												  12. ITEM_ID
									           	 */    	 	
												
																		
												String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)
																		 +"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)
																		 +"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)
																		 +"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+vo.getStrItemCatId()+"^"+ws.getString(13);		
												
												if(j%2==0)
												 {
													strCssClass =	"multiRPTControl";
													
												 }
												else
												{
													strCssClass =	"multiRPTControl1";
												}
												
												
												br.append("<tr>");
												//br.append("<input type='hidden' name='demandFlg'  value='1'>");
												br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
												
												br.append("<td class= "+strCssClass+ " colspan='1' width='5%'>"+(count+1)+"</td>");
												
												if(strMode.equals("DRUG_WISE"))
												{
													if(vo.getStrMode().equals("1"))// mode = 1 for Batch Wise 
													{
														br.append("<td style=\"text-align: left;\" class= "+strCssClass+ " colspan='1' width='25%'>"+
																"<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid"+count+"' value='0' " +
																"onClick='chkBoxClick(this,\""+count+"\");'>"+ws.getString(2)+"</a></td>");
														
														br.append("<td style=\"text-align: center;\" class= "+strCssClass+ " colspan='1' width='10%'>"+ws.getString(3)+"</td>");
													}
													else
													{
														br.append("<td style=\"text-align: left;\" class= "+strCssClass+ " colspan='1' width='35%'>"+
																"<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid"+count+"' value='0' " +
																"onClick='chkBoxClick(this,\""+count+"\");'>"+ws.getString(2)+"</a></td>");
													}
													
												}
												else
												{
													if(vo.getStrMode().equals("1"))
													{
														br.append("<td style=\"text-align: left;\" class= "+strCssClass+ " colspan='1' width='25%'>"+
																"<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid"+count+"' value='0' " +
																		"onClick='chkBoxClick(this,\""+count+"\");'>"+ws.getString(1)+"</a></td>");	
														
														br.append("<td style=\"text-align: center;\" class= "+strCssClass+ " colspan='1' width='10%'>"+ws.getString(3)+"</td>");
													}
													else
													{
														br.append("<td style=\"text-align: left;\" class= "+strCssClass+ " colspan='1' width='35%'>"+
																"<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid"+count+"' value='0' " +
																		"onClick='chkBoxClick(this,\""+count+"\");'>"+ws.getString(1)+"</a></td>");	
													}
													
												}
													
								
												 nOpeningBalQtyActive		=	Double.parseDouble(ws.getString(4).split("#")[0]);
												 nOpeningBalQtyInActive		=	Double.parseDouble(ws.getString(4).split("#")[1]);	
												 nOpeningBalQtyQuarantine	=	Double.parseDouble(ws.getString(4).split("#")[2]);
												
												 nReceivedQtyActive			=	Double.parseDouble(ws.getString(8));
												 nReceivedQtyInActive		=	Double.parseDouble(ws.getString(9));
												 nReceivedQtyQuarantine		=	Double.parseDouble(ws.getString(10));
												
												 nIssuedQtyActive			=	Double.parseDouble(ws.getString(5));
												 nIssuedQtyInActive			=	Double.parseDouble(ws.getString(6));
												 nIssuedQtyQuarantine		=	Double.parseDouble(ws.getString(7));
												
												 nClosingBalQtyActive		=	nOpeningBalQtyActive + nReceivedQtyActive - nIssuedQtyActive;
												 nClosingBalQtyInActive		=	nOpeningBalQtyInActive + nReceivedQtyInActive - nIssuedQtyInActive;
												 nClosingBalQtyQuarantine   =	nOpeningBalQtyQuarantine + nReceivedQtyQuarantine - nIssuedQtyQuarantine;
												
												
												br.append("<td style=\"text-align: right;\" class= "+strCssClass+ " colspan='3' width='15%'>"+nOpeningBalQtyActive+"</td>");
												//br.append("<td style=\"text-align: right;\" class= "+strCssClass+  colspan='1' width='5%'>"+nOpeningBalQtyInActive+"</td>");
												//br.append("<td style=\"text-align: right;\" class= "+strCssClass+  colspan='1' width='5%'>"+nOpeningBalQtyQuarantine+"</td>");
												
												br.append("<td style=\"text-align: right;\" class= "+strCssClass+ " colspan='3' width='15%'>"+nReceivedQtyActive+"</td>");
												//br.append("<td style=\"text-align: right;\" class= "+strCssClass+  colspan='1' width='5%'>"+nReceivedQtyInActive+"</td>");
												//br.append("<td style=\"text-align: right;\" class= "+strCssClass+  colspan='1' width='5%'>"+nReceivedQtyQuarantine+"</td>");
												
												br.append("<td style=\"text-align: right;\" class= "+strCssClass+ " colspan='3' width='15%'>"+nIssuedQtyActive+"</td>");
												//br.append("<td style=\"text-align: right;\" class= "+strCssClass+  colspan='1' width='5%'>"+nIssuedQtyInActive+"</td>");
												//br.append("<td style=\"text-align: right;\" class= "+strCssClass+  colspan='1' width='5%'>"+nIssuedQtyQuarantine+"</td>");
												
												br.append("<td style=\"text-align: right;\" class= "+strCssClass+ " colspan='3' width='15%'>"+nClosingBalQtyActive+"</td>");
												//br.append("<td style=\"text-align: right;\" class= "+strCssClass+  colspan='1' width='5%'>"+nClosingBalQtyInActive+"</td>");
												//br.append("<td style=\"text-align: right;\" class= "+strCssClass+  colspan='1' width='5%'>"+nClosingBalQtyQuarantine+"</td>");
												br.append("<td style=\"text-align: right;\" class= "+strCssClass+ " colspan='3' width='15%'>"+Double.parseDouble(ws.getString(13))+"</td>");
												
												br.append("</tr>");
												
												count++ ;
												
												
											}
											else
											{
												break;
											}
										}
										
										br.append("</table>");							
									
									br.append("</div>");
					
							} 
						 	else 
							{
								br.append("<div id='DivId" + i+ "' style='display:none'>");
								
								br.append("<table border='1' class='TABLEWIDTH'  bgcolor='#CC9966' align='center' cellspacing='1px'>");
								for (int k = 0; k < reminder; k++) 
								{
									ws.next();
					
					
									/* Value Pass in Web Row Set
									  1.  STR_NAME
									  2.  ITEM_NAME	
									  3.  BATCH_NO	
									  4.  OP_BALANCE	
									  5.  ACTIVE_ISSUE	
									  6.  INACTIVE_ISSUE	
									  7.  QUARTINE_ISSUE	
									  8.  ACTIVE_REC	
									  9.  INACTIVE_REC	
									  10  QUARTINE_REC									  
									  11. STR_ID
									  12. ITEM_ID
						           	 */   
									
															
									String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)
															 +"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)
															 +"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)
															 +"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12);		
									
									
									br.append("<tr>");
									br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
									
									//br.append("<input type='hidden' name='demandFlg'  value='1'>");
									
									br.append("<td class='multiRPTControl' colspan='1' width='5%'>"+count+"</td>");
									
					
									
									if(strMode.equals("DRUG_WISE"))
									{
										if(vo.getStrMode().equals("1"))// mode = 1 for Batch Wise 
										{
											br.append("<td style=\"text-align: left;\" class='multiRPTControl' colspan='1' width='25%'>"+ws.getString(2)+"</td>");
											
											br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='10%'>"+ws.getString(3)+"</td>");
										}
										else
										{
											br.append("<td style=\"text-align: left;\" class='multiRPTControl' colspan='1' width='35%'>"+ws.getString(2)+"</td>");
										}
										
									}
									else		// Item Wise
									{
										if(vo.getStrMode().equals("1"))
										{
											br.append("<td style=\"text-align: left;\" class='multiRPTControl' colspan='1' width='25%'>"+
													"<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid"+count+"' value='0' " +
															"onClick='chkBoxClick(this,\""+count+"\");'>"+ws.getString(1)+"</a></td>");	
											
											br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='10%'>"+ws.getString(3)+"</td>");
										}
										else
										{
											br.append("<td style=\"text-align: left;\" class='multiRPTControl' colspan='1' width='35%'>"+
													"<a style=\"color:blue;cursor: pointer\" name='checkid' id='checkid"+count+"' value='0' " +
															"onClick='chkBoxClick(this,\""+count+"\");'>"+ws.getString(1)+"</a></td>");	
										}
										
									}								
									
										
					
									 nOpeningBalQtyActive		=	Double.parseDouble(ws.getString(4).split("#")[0]);
									 nOpeningBalQtyInActive		=	Double.parseDouble(ws.getString(4).split("#")[1]);	
									 nOpeningBalQtyQuarantine	=	Double.parseDouble(ws.getString(4).split("#")[2]);
									
									 nReceivedQtyActive			=	Double.parseDouble(ws.getString(8));
									 nReceivedQtyInActive		=	Double.parseDouble(ws.getString(9));
									 nReceivedQtyQuarantine		=	Double.parseDouble(ws.getString(10));
									
									 nIssuedQtyActive			=	Double.parseDouble(ws.getString(5));
									 nIssuedQtyInActive			=	Double.parseDouble(ws.getString(6));
									 nIssuedQtyQuarantine		=	Double.parseDouble(ws.getString(7));
									
									 nClosingBalQtyActive		=	nOpeningBalQtyActive + nReceivedQtyActive - nIssuedQtyActive;
									 nClosingBalQtyInActive		=	nOpeningBalQtyInActive + nReceivedQtyInActive - nIssuedQtyInActive;
									 nClosingBalQtyQuarantine   =	nOpeningBalQtyQuarantine + nReceivedQtyQuarantine - nIssuedQtyQuarantine;
									
									
									br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'>"+nOpeningBalQtyActive+"</td>");
									//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nOpeningBalQtyInActive+"</td>");
									//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nOpeningBalQtyQuarantine+"</td>");
									
									br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'>"+nReceivedQtyActive+"</td>");
									//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nReceivedQtyInActive+"</td>");
									//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nReceivedQtyQuarantine+"</td>");
									
									br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'>"+nIssuedQtyActive+"</td>");
									//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nIssuedQtyInActive+"</td>");
									//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nIssuedQtyQuarantine+"</td>");
									
									br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'>"+nClosingBalQtyActive+"</td>");
									//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nClosingBalQtyInActive+"</td>");
									//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nClosingBalQtyQuarantine+"</td>");
									
									
									br.append("</tr>");
									br.append("</table>");
								
									br.append("</div>");
									
									
								}
						   	}
						 		br.append("</div>");
								}
						}
					else
					{
						 
						 
						    br.append("<table class='TABLEWIDTH' border='1' align='center' cellspacing='1px' cellpadding='1px'>");
							//br.append("<tr class='TITLE'>");
							//br.append("<td colspan='4'></td></tr>");
							br.append("<tr>");
							
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>S. No.</td>");
							
							
							if(strMode.equals("DRUG_WISE"))
							{
								if(vo.getStrMode().equals("1"))
								{
									if(vo.getStrItemCatId()!=null && vo.getStrItemCatId().equals("10"))
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Drug Name</td>");
									else
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Item Name</td>");
									
									br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No.</td>");
								}
								else
								{
									if(vo.getStrItemCatId()!=null && vo.getStrItemCatId().equals("10"))
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Drug Name</td>");
									else
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Item Name</td>");
								}
									
							}
							else
							{
								if(vo.getStrMode().equals("1"))
								{
									br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Store Name</td>");
									
									br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No.</td>");
								}
								else
								{
									br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'>Store Name</td>");
								}
								
								
							}
							
							
							br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Opening Balance</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Received Qty</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Issued Qty</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Closing Balance</td>");
							
							br.append("</tr>");
							
							/*
							br.append("<tr>");
							
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'></td>");
							
							if(vo.getStrMode().equals("1"))
							{
								br.append("<td CLASS='multiRPTLabel' colspan='1' width='25%'></td>");
								br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
							}
							else
							{
								br.append("<td CLASS='multiRPTLabel' colspan='1' width='35%'></td>");
							}
							
							// Opening Balance
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
							// Received Balance
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
							// Issued Balance
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
							// Closing Balance
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
							
							
							br.append("</tr>");
							*/
							int nColSpan=0;
							if(vo.getStrMode().equals("1"))
								nColSpan=17;
							else
								nColSpan=15;	
			           	    br.append("<tr>");  
			           	    br.append("<td class='multiRPTControl' colspan='"+nColSpan+"'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
			           	    br.append("<tr>");
			           	    br.append("<td colspan='"+nColSpan+"' width='100%' class='multiRPTControl'>****End of Report****</td>");
			           	    br.append("</tr>");
			           	    br.append("<tr>");
			           	    br.append("<td colspan='"+nColSpan+"' width='100%' class='multiRPTControl'>Computer Generated Report</td>");
			           	    br.append("</tr>");
			 			
			           	    br.append("</table>");
			           	   
							
					   }
			} 
	    }			
		catch (Exception e) 
		{		 e.printStackTrace();
				throw new Exception("StockLedgerRptHLP.getStockLedgerDetails()->"+e.getMessage());
		}
			return br.toString();
	}
		
		
		
		/**
		 * Gets the issue dtls init view.
		 * 
		 * @param formBean  the form bean
		 * 
		 * @return the issue dtls init view
		 * 
		 * @throws Exception the exception
		 */
		public static String getStockLedgerPopUp(StockLedgerRptVO vo,String strMode) throws Exception 
		{
			StringBuffer br = new StringBuffer();
			int count = 0;
			
			double nOpeningBalQtyActive= 0;
			double nOpeningBalQtyInActive= 0;
			double nOpeningBalQtyQuarantine= 0;
			
			double nReceivedQtyActive= 0;
			double nReceivedQtyInActive= 0;
			double nReceivedQtyQuarantine= 0;
			
			double nIssuedQtyActive= 0;
			double nIssuedQtyInActive= 0;
			double nIssuedQtyQuarantine= 0;
			
			double nClosingBalQtyActive= 0;
			double nClosingBalQtyInActive= 0;
			double nClosingBalQtyQuarantine= 0;
			
			
			ResourceBundle res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			WebRowSet ws = vo.getWrsData();		
	 		String strTableWidth = "100%";
	 		
	 		try 
			{
	 			br.append("<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledger_mmsrpt.js'></script><body><form><table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0''> ");
				br.append("<tr>");
				//br.append("<td width='10%'><div  align='right'><img width='46px' height='39px' src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");
				//br.append("<td width='10%'><div  align='right'><img width='46px' height='39px' src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
				br.append("<td width='80%' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
				br.append(res.getString("REPORT_TITLE"));
				br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
				br.append("</tr> ");
				br.append("</table> ");
				br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0'> ");
				br.append("<tr><td width='8%'>&nbsp;</td> ");
				br.append("<td width='82%' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
				br.append("Stock Ledger ");			
				br.append("</font></b></td><td width='10%'>&nbsp;</td> ");
				br.append("</tr> ");
				br.append("<tr> ");
				br.append("<td width='8%'>&nbsp;</td> ");
				br.append("<td width='82%' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
				
					br.append("Store Name: "+vo.getStrStoreName()+"<br>");
					if(vo.getStrItemCatId()!=null && vo.getStrItemCatId().equals("10"))
						br.append("Drug Name: "+vo.getStrDrugName()+"<br>");
					else
						br.append("Item Name: "+vo.getStrDrugName()+"<br>");
				
			
						
				
				br.append("</font></b></td><td width='10%'>&nbsp; ");
				br.append("</td> ");
				br.append("</tr> ");
				br.append("<tr> ");
				br.append("<td width='8%'>&nbsp;</td> ");
				br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
				br.append("Between: "+vo.getStrFromDate()+" and "+vo.getStrToDate());
				br.append("</font></b></td><td width='10%'>&nbsp; ");
				br.append("</td> ");
				br.append("</tr> ");
				br.append("</table> ");				
				br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
				br.append("<tr> ");
				br.append("<td align='right'>");
				br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				br.append("<img style='cursor: pointer; ' title='Print Page'  ");
				br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
				br.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
				br.append(" </td> ");
				br.append(" </tr> ");
				br.append(" </table> ");	
				br.append("<table cellspacing='0' border='1' cellpadding='0' width='").append(strTableWidth).append("' align='center'> ");
				//br.append("<tr><td colspan='15'><hr></td></tr>");
				br.append("<tr bgcolor='#cdc9c9'> ");
				
							
				
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></font></td>");
				
				
				if(strMode.equals("DRUG_WISE"))
				{
					if(vo.getStrMode().equals("1"))
					{
						if(vo.getStrItemCatId()!=null && vo.getStrItemCatId().equals("10"))
							br.append("<td style=\"text-align: center;\" colspan='1' width='25%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
						else
							br.append("<td style=\"text-align: center;\" colspan='1' width='25%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font></td>");
						
						br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
					}
					else
					{
						if(vo.getStrItemCatId()!=null && vo.getStrItemCatId().equals("10"))
							br.append("<td style=\"text-align: center;\" colspan='1' width='25%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
						else
							br.append("<td style=\"text-align: center;\" colspan='1' width='25%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Item Name</b></font></td>");
					}
						
				}
				else
				{
					if(vo.getStrMode().equals("1"))
					{
						br.append("<td style=\"text-align: center;\" colspan='1' width='25%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Store Name</b></font></td>");
						
						br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font>");
					}
					else
					{
						br.append("<td CLASS='multiRPTLabel' colspan='1' width='35%'>Store Name</td>");
					}
					
					
				}
				
				
				br.append("<td style=\"text-align: center;\" colspan='3' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Opening Balance</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='3' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Closing Balance</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='3' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rate/No</b></font></td>");
				
				br.append("</tr>");
				

				
				/*
				br.append("<tr> ");
				br.append("<tr bgcolor='#cdc9c9'> ");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				
				
				if(vo.getStrMode().equals("1"))
				{
					br.append("<td style=\"text-align: center;\" colspan='1' width='25%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				}
				else
				{
					br.append("<td style=\"text-align: center;\" colspan='1' width='35%'><font  size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></font></td>");
				}
				
				
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready For Issue</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty in Quarantine</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready For Issue</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty in Quarantine</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready For Issue</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty in Quarantine</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready For Issue</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></font></td>");
				br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty in Quarantine</b></font></td>");				
				
				br.append("</tr>");
				*/
				
				//br.append("<tr><td colspan='15'><hr></td></tr>"); 

				if (ws != null && ws.size() > 0) 
				{

					while (ws.next()) 
					{	
						
						 /* Value Pass in Web Row Set
				    	  1. 	ITEM_NAME
				    	  2. 	BATCH_NO	
				    	  
				    	  3. 	OPENING_BAL_QTY_ACTIVE
				    	  4. 	OPENING_BAL_QTY_INACTIVE	
				    	  5. 	OPENING_BAL_QTY_QUARANTINE	
				    	  
				    	  6. 	RECEIVED_BAL_QTY_ACTIVE	
				    	  7. 	RECEIVED_BAL_QTY_INACTIVE	
				    	  8. 	RECEIVED_BAL_QTY_QUARANTINE	
				    	  
				    	  9. 	ISSUED_BAL_QTY_ACTIVE	
				    	  10.	ISSUED_BAL_QTY_INACTIVE	
				    	  11.	ISSUED_BAL_QTY_QUARANTINE	
	
				    	  12.	CLOSING_BAL_QTY_ACTIVE	
				    	  13.	CLOSING_BAL_QTY_INACTIVE	
				    	  14.	CLOSING_BAL_QTY_QUARANTINE
	
			           	 */    	 	
						
												
						String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)
												 +"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)
												 +"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)
												 +"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12);		
						
						br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
						
						br.append("<tr >");
						//br.append("<input type='hidden' name='demandFlg'  value='1'>");
						
						br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+(count+1)+"</td>");
						
						
						if(strMode.equals("DRUG_WISE"))
						{
							if(vo.getStrMode().equals("1"))// mode = 1 for Batch Wise 
							{
								br.append("<td style=\"text-align: left;\" class='multiRPTControl' colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</font></td>");
								
								br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(3)+"</font></td>");
							}
							else
							{
								br.append("<td style=\"text-align: left;\" class='multiRPTControl' colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</font></td>");
							}
							
						}
						else
						{
							if(vo.getStrMode().equals("1"))
							{
								br.append("<td style=\"text-align: left;\" class='multiRPTControl' colspan='1' width='25%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(1)+"</font></td>");	
								
								br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(3)+"</font></td>");
							}
							else
							{
								br.append("<td style=\"text-align: left;\" class='multiRPTControl' colspan='1' width='35%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(1)+"</font></td>");	
							}
							
						}	
						
						 nOpeningBalQtyActive		=	Double.parseDouble(ws.getString(4).split("#")[0]);
						 nOpeningBalQtyInActive		=	Double.parseDouble(ws.getString(4).split("#")[1]);	
						 nOpeningBalQtyQuarantine	=	Double.parseDouble(ws.getString(4).split("#")[2]);
						
						 nReceivedQtyActive			=	Double.parseDouble(ws.getString(8));
						 nReceivedQtyInActive		=	Double.parseDouble(ws.getString(9));
						 nReceivedQtyQuarantine		=	Double.parseDouble(ws.getString(10));
						
						 nIssuedQtyActive			=	Double.parseDouble(ws.getString(5));
						 nIssuedQtyInActive			=	Double.parseDouble(ws.getString(6));
						 nIssuedQtyQuarantine		=	Double.parseDouble(ws.getString(7));
						
						 nClosingBalQtyActive		=	nOpeningBalQtyActive + nReceivedQtyActive - nIssuedQtyActive;
						 nClosingBalQtyInActive		=	nOpeningBalQtyInActive + nReceivedQtyInActive - nIssuedQtyInActive;
						 nClosingBalQtyQuarantine   =	nOpeningBalQtyQuarantine + nReceivedQtyQuarantine - nIssuedQtyQuarantine;
						
						
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nOpeningBalQtyActive+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nOpeningBalQtyInActive+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nOpeningBalQtyQuarantine+"</td>");
						
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nReceivedQtyActive+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nReceivedQtyInActive+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nReceivedQtyQuarantine+"</td>");
						
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nIssuedQtyActive+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nIssuedQtyInActive+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nIssuedQtyQuarantine+"</td>");
						
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nClosingBalQtyActive+"</td>");
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+Double.parseDouble(ws.getString(13))+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nClosingBalQtyInActive+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nClosingBalQtyQuarantine+"</td>");
						
						br.append("</tr>");
						count++ ;
						}
						
						
						
				}	
				else 
				{

					br.append("<tr> ");
					br.append("<td colspan='15' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><br/><b>Details Not Available</b><br/><br/></font></td> ");
					br.append("</tr> ");

				}

				br.append("</table> ");
				
				br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
				br.append("<tr><td colspan='15'><hr></td></tr>");
				br.append("<tr> ");
				br.append("<td colspan='15' align='center'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >***End of Report***</font></td> ");
				br.append("</tr> ");
				br.append("</table> </form></body></HEAD></HTML>");

			} catch (Exception e) {

				//e.printStackTrace();

				throw e;
			}

			return br.toString();
		}

		
		/**
		 * To get Detailed Stock Ledger Detail
		 * 
		 * @param vo
		 * @return
		 * @throws Exception
		 */
		
		public static String getDetailedStockLedgerDtl(StockLedgerRptVO vo) throws Exception // Original detailed data showing function
		{
		
		StringBuffer br = new StringBuffer();
		WebRowSet ws =	vo.getWrsData();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 100;
		final int PAGE_PER_BLOCK = 10;
		
		double nOpeningBalQtyActive= Double.parseDouble(vo.getStrOpeningBalance().split("#")[0]);
		double nOpeningBalQtyInActive= Double.parseDouble(vo.getStrOpeningBalance().split("#")[1]);
		double nOpeningBalQtyQuarantine= Double.parseDouble(vo.getStrOpeningBalance().split("#")[2]);
		
		double nReceivedQtyActive= 0;
		double nReceivedQtyInActive= 0;
		double nReceivedQtyQuarantine= 0;
		double nTotalReceivedQty = 0;
		
		double nIssuedQtyActive= 0;
		double nIssuedQtyInActive= 0;
		double nIssuedQtyQuarantine= 0;
		double nTotalIssuedQty = 0;
		
		double nClosingBalQtyActive= Double.parseDouble(vo.getStrOpeningBalance().split("#")[0]);
		double nClosingBalQtyInActive= Double.parseDouble(vo.getStrOpeningBalance().split("#")[0]);
		double nClosingBalQtyQuarantine= Double.parseDouble(vo.getStrOpeningBalance().split("#")[0]);
		
		int nRowNum=1;
		
		String strTableWidth = "100%";
		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
		String strHiddenParameter =	vo.getStrDWHId()+"^"+vo.getStrItemBrandId()+"^"+vo.getStrFromDate()	+"^"+vo.getStrToDate() +"^"+vo.getStrBatchNo()+"^"+vo.getStrOpeningBalance() +"^"+ vo.getStrStoreName() +"^"+ vo.getStrDrugName()+ "^"+vo.getStrBatchFlag()+"^"+vo.getStrItemCatId()+"^"+vo.getRate();

		try
	    {
 			br.append("<HTML><HEAD><link href='../css/transaction.css' rel='stylesheet' type='text/css'>" +
 					"<script language='Javascript' src='../../mms/js/stockledger_mmsrpt.js'>" +
 					"</script><body><form><table class='TABLEWIDTH' align='center' width='").append(strTableWidth).append("' border='0' cellspacing='1px' cellpadding='1px''> ");
 			//br.append("");
			//br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Stock Ledger </td></tr></table>");	
					if (ws != null) 
					{
						br.append("<table class='TABLEWIDTH'  align='center' colspan='4' width='").append(strTableWidth).append("' border='0' cellspacing='1px' cellpadding='1px'> ");
						
						br.append("<tr> ");
							br.append("<td class='LABEL' width='50%' > <b><div align='right'> <font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
						
							br.append("Store Name: ");
							br.append("</font><div></b></td>");
							
							br.append("<td style=\"text-align: center;\" class='CONTROL' colspan='1' width='50%'><div align='left'>");
							br.append(vo.getStrStoreName());
							br.append("<div></td>");
						br.append("</tr> ");
							
						br.append("<tr> ");
							br.append("<td class='LABEL' width='50%' > <b><div align='right'> <font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
							if(vo.getStrItemCatId()!=null && vo.getStrItemCatId().equals("10"))
								br.append("Drug Name: ");
							else
								br.append("Item Name: ");
							br.append("</font><div></b></td>");
						
							br.append("<td style=\"text-align: center;\"class='CONTROL' colspan='1' width='50%'> <div align='left'>");
							br.append(vo.getStrDrugName());
							br.append("<div></td>");
						br.append("</tr> ");
						
				if(vo.getStrBatchFlag().equals("1"))
				{
					br.append("<tr> ");
						br.append("<td class='LABEL' width='50%' > <b><div align='right'> <font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
						
						br.append("Batch No : ");
						br.append("</font><div></b></td>");
					
						br.append("<td style=\"text-align: center;\"class='CONTROL' colspan='1' width='50%'> <div align='left'>");
						br.append(vo.getStrBatchNo());
						br.append("<div></td>");
					br.append("</tr> ");
				}
						
						//From Date and To Date
					br.append("<tr> ");
						br.append("<td class='LABEL' width='50%' > <b><div align='right'> <font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
						br.append("From Date: ");
						br.append("</font><div></b></td>");
						
						br.append("<td style=\"text-align: center;\" class='CONTROL' colspan='1' width='50%'><div align='left'>");
						br.append(vo.getStrFromDate());
						br.append("<div></td>");
					br.append("</tr> ");
						
					br.append("<tr> ");
						br.append("<td class='LABEL' width='50%' > <b><div align='right'> <font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
						//<td width="50%" colspan="2" class="CONTROL">
						br.append("To Date: ");
						br.append("</font><div></b></td>");
					
						br.append("<td style=\"text-align: center;\"class='CONTROL' colspan='1' width='50%'> <div align='left'>");
						br.append(vo.getStrToDate());
						br.append("<div></td>");
					br.append("</tr> ");
					
					br.append("<tr> ");
					br.append("<td class='LABEL' width='50%' > <b><div align='right'> <font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
					//<td width="50%" colspan="2" class="CONTROL">
					br.append("Rate/No");
					br.append("</font><div></b></td>");
				
					br.append("<td style=\"text-align: center;\"class='CONTROL' colspan='1' width='50%'> <div align='left'>");
					br.append(vo.getRate());
					br.append("<div></td>");
				br.append("</tr> ");
					
					br.append("<tr><td class='TITLE' colspan='4' align='center'> ");
					br.append("<b><div align='left'><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
					br.append("Stock Ledger ");			
					br.append("</font></div></b></td>");
					br.append("</tr> ");
					
					br.append("</table> ");		
						
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
						   
						   
						    br.append("<input type='hidden' name='TotalLayer1'  value='"+totalLayer+"'>");
						    br.append("<input type='hidden' name='RecordShowOnPage'  value='"+REC_PER_PAGE+"'>");
						    
							br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
							br.append("<tr>");
							br.append("<td class='LABEL'>");				
				   		    for (int i = 1; i <= totalLayer; i++)
							 {
								br.append("<a name='pg1' id='pg1" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing'" +
										  " onClick='GetIndex1(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
										+ "</a>|&nbsp;");
							 }
							br.append("</td></tr>");
							br.append("</table>");			
							
							
									
						
						
						br.append("</td></tr>");							
						br.append("</table>");
							
							
					    for (int i = 1; i <= totalLayer; i++) 
					    {
						 if (i <= totalLayer) 
							 {
								 
										if (i == 1) 
										{
											br.append("<div id='DivId1" +i+ "' style='display:block'>");

										} 
										else
										{
											br.append("<div id='DivId1" +i+ "' style='display:none'>");
										}
								
										br.append("<table class='TABLEWIDTH' bgcolor='#CC9966' align='center' cellspacing='1px' border='0' >");
										
										br.append("<tr>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>S. No.</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Date</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='40%'>Particulars</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Received Qty</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issued Qty</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Balance</td>");
										br.append("</tr>");
										
										/*
										br.append("<tr>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");										
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'></td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='40%'></td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
										// Closing Balance
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
										br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
										br.append("</tr>");
										*/
										
										if(i==1)
										{	
										// First Row
										br.append("<tr>");										
										br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='10%'><b>"+nRowNum+"</b></td>");
										br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='15%'><b>"+vo.getStrFromDate()+"</b></td>");
										br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='40%'><b>"+"Opening Balance"+"</b></td>");
										br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>"+"0"+"</b></td>");
										br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><b>"+"0"+"</b></td>");
										
										br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'><b>"+nOpeningBalQtyActive+"</b></td>");
										//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nOpeningBalQtyInActive+"</td>");
										//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nOpeningBalQtyQuarantine+"</td>");
										br.append("<tr>");
										}
										
										br.append("<input type='hidden' name='strHiddenParameter' id='strHiddenParameterId"+count+"' value='"+strHiddenParameter+"'>");
										
										String strCssClass =	"multiRPTControl";
										
										for (int j = 0; j < REC_PER_PAGE; j++) 
										{
											
											
											if(ws.next())
											{
												
												 /* Value Pass in Web Row Set
												  1.	TRANS_DATE
												  2.	PARTICULARS	
												  
												  3.	ACTIVE_ISSUE	
												  4.	INACTIVE_ISSUE	
												  5.	QUARTINE_ISSUE
												  	
												  6.	ACTIVE_REC	
												  7.	INACTIVE_REC	
												  8.	QUARTINE_REC
												  	
												  9.	STR_NAME	
												  10.	ITEM_NAME	
												  11.	HSTSTR_BATCH_SL_NO

									           	 */    	 	
												
																		
												String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)
																		 +"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)
																		 +"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)
																		 +"^"+ws.getString(10)+"^"+ws.getString(11);
												
												
												
												if(j%2==0)
												 {
													strCssClass =	"multiRPTControl";
													
												 }
												else
												{
													strCssClass =	"multiRPTControl1";
												}
												
												
												
												 nReceivedQtyActive			=	Double.parseDouble(ws.getString(6));
												 nReceivedQtyInActive		=	Double.parseDouble(ws.getString(7));
												 nReceivedQtyQuarantine		=	Double.parseDouble(ws.getString(8));
												
												 nTotalReceivedQty			=	nReceivedQtyActive + nReceivedQtyInActive +	nReceivedQtyQuarantine;// Total Received Qty
												 
												 nIssuedQtyActive			=	Double.parseDouble(ws.getString(3));
												 nIssuedQtyInActive			=	Double.parseDouble(ws.getString(4));
												 nIssuedQtyQuarantine		=	Double.parseDouble(ws.getString(5));
												
												 nTotalIssuedQty			=	nIssuedQtyActive + nIssuedQtyInActive + nIssuedQtyQuarantine;// Total Issued Qty
												 
												 nClosingBalQtyActive		=	nClosingBalQtyActive + nReceivedQtyActive - nIssuedQtyActive;
												 nClosingBalQtyInActive		=	nClosingBalQtyInActive + nReceivedQtyInActive - nIssuedQtyInActive;
												 nClosingBalQtyQuarantine   =	nClosingBalQtyQuarantine + nReceivedQtyQuarantine - nIssuedQtyQuarantine;
												
												
												 
												
												
												br.append("<tr>");
												br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
														
												
												br.append("<td class= "+strCssClass+ " colspan='1' width='10%'>"+(count+1+nRowNum)+"</td>");
												br.append("<td class= "+strCssClass+ " colspan='1' width='15%'>"+ws.getString(1)+"</td>");
												br.append("<td class= "+strCssClass+ " colspan='1' width='40%'>"+ws.getString(2)+"</td>"); 
												 
												br.append("<td style=\"text-align: right;\" class= "+strCssClass+ " colspan='1' width='10%'>"+nTotalReceivedQty+"</td>");
												br.append("<td style=\"text-align: right;\" class= "+strCssClass+ "  colspan='1' width='10%'>"+nTotalIssuedQty+"</td>");
												
												
												br.append("<td style=\"text-align: right;\" class= "+strCssClass+ "  colspan='3' width='15%'>"+nClosingBalQtyActive+"</td>");
												//br.append("<td style=\"text-align: right;\" class= "+strCssClass+ "  colspan='1' width='5%'>"+nClosingBalQtyInActive+"</td>");
												//br.append("<td style=\"text-align: right;\" class= "+strCssClass+ "  colspan='1' width='5%'>"+nClosingBalQtyQuarantine+"</td>");
												
												
												br.append("</tr>");
												
												count++ ;
												
											}
											else
											{
												break;
											}
										}
										
										br.append("</table>");									
									    br.append("</div>");
					
							} // Till first div
						 	else 
							{
								br.append("<div id='DivId1" + i+ "' style='display:none'>");
								
								br.append("<table border='0' class='TABLEWIDTH'  bgcolor='#CC9966' align='center' cellspacing='1px'>");
								for (int k = 0; k < reminder; k++) 
								{
									ws.next();
					
					
									 /* Value Pass in Web Row Set
									  1.	TRANS_DATE
									  2.	PARTICULARS	
									  
									  3.	ACTIVE_ISSUE	
									  4.	INACTIVE_ISSUE	
									  5.	QUARTINE_ISSUE
									  	
									  6.	ACTIVE_REC	
									  7.	INACTIVE_REC	
									  8.	QUARTINE_REC
									  	
									  9.	STR_NAME	
									  10.	ITEM_NAME	
									  11.	HSTSTR_BATCH_SL_NO

						           	 */    	 	
									
															
									String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)
															 +"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)
															 +"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)
															 +"^"+ws.getString(10)+"^"+ws.getString(11);		
									
									br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
									
									br.append("<tr>");
									
									br.append("<td class='multiRPTControl' colspan='1' width='10%'>"+(count+1)+"</td>");
									
									br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='10%'>"+ws.getString(1)+"</td>");

										
					
									 nOpeningBalQtyActive		=	Double.parseDouble(vo.getStrOpeningBalance().split("#")[0]);
									 nOpeningBalQtyInActive		=	Double.parseDouble(vo.getStrOpeningBalance().split("#")[1]);	
									 nOpeningBalQtyQuarantine	=	Double.parseDouble(vo.getStrOpeningBalance().split("#")[2]);
									
									 nReceivedQtyActive			=	Double.parseDouble(ws.getString(6));
									 nReceivedQtyInActive		=	Double.parseDouble(ws.getString(7));
									 nReceivedQtyQuarantine		=	Double.parseDouble(ws.getString(8));
									
									 nTotalReceivedQty			=	nReceivedQtyActive + nReceivedQtyInActive +	nReceivedQtyQuarantine;// Total Received Qty
									 
									 nIssuedQtyActive			=	Double.parseDouble(ws.getString(3));
									 nIssuedQtyInActive			=	Double.parseDouble(ws.getString(4));
									 nIssuedQtyQuarantine		=	Double.parseDouble(ws.getString(5));
									
									 nTotalIssuedQty			=	nIssuedQtyActive + nIssuedQtyInActive + nIssuedQtyQuarantine;// Total Issued Qty
									 
									 nClosingBalQtyActive		=	nOpeningBalQtyActive + nReceivedQtyActive - nIssuedQtyActive;
									 nClosingBalQtyInActive		=	nOpeningBalQtyInActive + nReceivedQtyInActive - nIssuedQtyInActive;
									 nClosingBalQtyQuarantine   =	nOpeningBalQtyQuarantine + nReceivedQtyQuarantine - nIssuedQtyQuarantine;
									
									
									
									
									br.append("<td class='multiRPTControl' colspan='1' width='10%'>"+(count+2)+"</td>");
									br.append("<td class='multiRPTControl' colspan='1' width='15%'>"+ws.getString(1)+"</td>");
									br.append("<td class='multiRPTControl' colspan='1' width='40%'>"+ws.getString(2)+"</td>"); 
									 
									br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nTotalReceivedQty+"</td>");
									br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nTotalIssuedQty+"</td>");
									
									
									br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'>"+nClosingBalQtyActive+"</td>");
									//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nClosingBalQtyInActive+"</td>");
								//	br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nClosingBalQtyQuarantine+"</td>");
									
									
									br.append("</tr>");
									
									count++ ;
									
									
									
									}
								br.append("</table>");
								
								br.append("</div>");
								
						   	    }
						            
						   
						 		//br.append("</div>");
						 		
						}
					    
					    if(actualFetchRecord< (REC_PER_PAGE-1))
					    {
						    br.append("<div id='closingDiv' style='display:block'>");	    	
					    }					    
					    else
					    {
					    	br.append("<div id='closingDiv' style='display:none'>");	
					    }
					    
					        
						br.append("<table class='TABLEWIDTH' bgcolor='#CC9966' align='center' cellspacing='1px' border='0' >");
						// Last Row for closing Balance
						br.append("<tr>");										
						br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='9%'><b>"+(count+1+nRowNum)+"</b></td>");
						br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='13%'><b>"+vo.getStrToDate()+"</b></td>");
						br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='36%'><b>"+"Closing Balance"+"</b></td>");
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='9%'><b>"+"---"+"</b></td>");
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='9%'><b>"+"---"+"</b></td>");
						
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='13%'><b>"+nClosingBalQtyActive+"</b></td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nClosingBalQtyInActive+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+nClosingBalQtyQuarantine+"</td>");
						br.append("<tr>");
						br.append("</table></div>");  
					}
					else
					{
						 // If No Details Available
						 
						    br.append("<table class='TABLEWIDTH' bgcolor='#CC9966' border='0' align='center' cellspacing='1px' >");
							//br.append("<tr class='TITLE'>");
							//br.append("<td colspan='4'></td></tr>");
							br.append("<input type='hidden' name='strHiddenParameter' id='strHiddenParameterId"+count+"' value='"+strHiddenParameter+"'>");

						    
						    br.append("<tr>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>S. No.</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Date</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='40%'>Particulars</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Received Qty</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issued Qty</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='3' width='15%'>Balance</td>");
							br.append("</tr>");
							/*
							br.append("<tr>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");										
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'></td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='40%'></td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'></td>");
							// Closing Balance
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Ready For Issue</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Rejected</td>");
							br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Qty in Quarantine</td>");
							br.append("</tr>");
							*/
							
			           	    //br.append("<tr>");  
			           	    //br.append("<td class='multiRPTControl' colspan='15'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
							
							// First Row for closing Balance
							br.append("<tr>");										
							br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='5%'>"+nRowNum+"</td>");
							br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='15%'>"+vo.getStrFromDate()+"</td>");
							br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='40%'>"+"Opening Balance"+"</td>");
							br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'>"+"0"+"</td>");
							br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'>"+"0"+"</td>");
							
							br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'>"+vo.getStrOpeningBalance().split("#")[0]+"</td>");
							//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+vo.getStrOpeningBalance().split("#")[1]+"</td>");
							//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+vo.getStrOpeningBalance().split("#")[2]+"</td>");
							br.append("<tr>");
							
							
							// Last Row for closing Balance
							br.append("<tr>");										
							br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='5%'>"+(count+1+nRowNum)+"</td>");
							br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='15%'>"+vo.getStrToDate()+"</td>");
							br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='40%'>"+"Closing Balance"+"</td>");
							br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'>"+"---"+"</td>");
							br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'>"+"---"+"</td>");
							
							br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'>"+vo.getStrOpeningBalance().split("#")[0]+"</td>");
							//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+vo.getStrOpeningBalance().split("#")[1]+"</td>");
							//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'>"+vo.getStrOpeningBalance().split("#")[2]+"</td>");
							br.append("<tr>");
							
			           	    br.append("</table>");
			           	   
							
					   }
			} 
					br.append("<table border='0'  class='TABLEWIDTH' width='").append(strTableWidth).append("' align='center'> ");
					br.append("<tr class='HEADER'><td  ></td></tr>");
					br.append("<tr> ");
					br.append("<td align='center'>");
					br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='center'>");
					br.append("<img style='cursor: pointer; ' title='Print Page'  ");
					br.append(" src='../../hisglobal/images/print_tab.gif' onClick='printDetailedStockLedgerReport(this,\""+count+"\");' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
					br.append(" src='../../hisglobal/images/btn-ccl.png' onClick='window.close();' /> </div></div>");
					br.append(" </td> ");
					br.append(" </tr> ");
					br.append(" </table> ");	
					
	    }			
		catch (Exception e) 
		{	
				throw new Exception("StockLedgerRptHLP.getStockLedgerDetails()->"+e.getMessage());
		}
			return br.toString();
	}
		
		

	/**
	 * To get Detailed Stock Ledger Detail
	 * 
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	
	public static String getDetailedStockLedgerDtlPopup(StockLedgerRptVO vo) throws Exception 
	{
	ResourceBundle res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
	StringBuffer br = new StringBuffer();
	WebRowSet ws =	vo.getWrsData();
	int count = 0;
	int start = 1;
	
	double nOpeningBalQtyActive= Double.parseDouble(vo.getStrOpeningBalance().split("#")[0]);
	double nOpeningBalQtyInActive= Double.parseDouble(vo.getStrOpeningBalance().split("#")[1]);
	double nOpeningBalQtyQuarantine= Double.parseDouble(vo.getStrOpeningBalance().split("#")[2]);
	
	double nReceivedQtyActive= 0;
	double nReceivedQtyInActive= 0;
	double nReceivedQtyQuarantine= 0;
	double nTotalReceivedQty = 0;
	
	double nIssuedQtyActive= 0;
	double nIssuedQtyInActive= 0;
	double nIssuedQtyQuarantine= 0;
	double nTotalIssuedQty = 0;
	
	double nClosingBalQtyActive= Double.parseDouble(vo.getStrOpeningBalance().split("#")[0]);
	double nClosingBalQtyInActive= Double.parseDouble(vo.getStrOpeningBalance().split("#")[0]);
	double nClosingBalQtyQuarantine= Double.parseDouble(vo.getStrOpeningBalance().split("#")[0]);
	
	int nRowNum=1;
	
	String strHiddenParameter =	vo.getStrDWHId()+"^"+vo.getStrItemBrandId()+"^"+vo.getStrFromDate()	+"^"+vo.getStrToDate() +"^"+vo.getStrBatchNo()+"^"+vo.getStrOpeningBalance() +"^"+ vo.getStrStoreName() +"^"+ vo.getStrDrugName() + "^"+vo.getStrBatchFlag();
	
	String strTableWidth = "100%";
	try
    {
		
		br.append("<HTML><HEAD><script language='Javascript' src='../../mms/js/stockledger_mmsrpt.js'></script><body><form><table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0''> ");
		br.append("<tr>");
		//br.append("<td width='10%'><div  align='right'><img width='46px' height='39px' src='../../hisglobal/images/Rmsc_Logo.png' /></div></td>");
		//br.append("<td width='10%'><div  align='right'><img width='46px' height='39px' src='../../hisglobal/images/aiims_inv_header.png' /></div></td>");
		br.append("<td width='80%' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
		br.append(res.getString("REPORT_TITLE"));
		br.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
		br.append("</tr> ");
		br.append("</table> ");
		br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0'> ");
		br.append("<tr><td width='8%'>&nbsp;</td> ");
		br.append("<td width='82%' align='center'> <b><font size='2' face='Verdana, Arial, Helvetica, sans-serif'> ");
		br.append("Stock Ledger ");			
		br.append("</font></b></td><td width='10%'>&nbsp;</td> ");
		br.append("</tr> ");
		br.append("<tr> ");
		br.append("<td width='8%'>&nbsp;</td> ");
		br.append("<td width='82%' align='center'> <b><font size='1' face='Verdana, Arial, Helvetica, sans-serif'>");
		
			br.append("Store Name: "+vo.getStrStoreName()+"<br>");
			if(vo.getStrItemCatId()!=null && vo.getStrItemCatId().equals("10"))
				br.append("Drug Name: "+vo.getStrDrugName()+"<br>");
			else
				br.append("Item Name: "+vo.getStrDrugName()+"<br>");
		
		br.append("</font></b></td><td width='10%'>&nbsp; ");
		br.append("</td> ");
		br.append("</tr> ");
		
		if(vo.getStrBatchFlag().equals("1"))
		{
			br.append("<tr> ");
			br.append("<td width='8%'>&nbsp;</td> ");
			br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
			
				br.append("Batch No : "+vo.getStrBatchNo());
				br.append("</font></b></td><td width='10%'>&nbsp; ");
				br.append("</td> ");
			br.append("</tr> ");
		}
		
		
		
		br.append("<tr> ");
		br.append("<td width='8%'>&nbsp;</td> ");
		br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
		br.append("Between: "+vo.getStrFromDate()+" and "+vo.getStrToDate());
		br.append("</font></b></td><td width='10%'>&nbsp; ");
		br.append("</td> ");
		br.append("</tr> ");
		
		br.append("<tr> ");
		br.append("<td width='8%'>&nbsp;</td> ");
		br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='1'> ");
		br.append("Rate/No: "+vo.getRate());
		br.append("</font></b></td><td width='10%'>&nbsp; ");
		br.append("</td> ");
		br.append("</tr> ");
		
		br.append("</table> ");				
		br.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
		br.append("<tr> ");
		br.append("<td align='right'>");
		br.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
		br.append("<img style='cursor: pointer; ' title='Print Page'  ");
		br.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printThis();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
		br.append(" src='../../hisglobal/images/stop.png' onClick='window.close();' /> </div></div>");
		br.append(" </td> ");
		br.append(" </tr> ");
		br.append(" </table> ");	
		
		
		
		br.append("<input type='hidden' name='strHiddenParameter' id='strHiddenParameterId"+count+"' value='"+strHiddenParameter+"'>");
				if (ws != null) 
				{
					br.append("<table class='TABLEWIDTH' border='1' align='center' cellspacing='0'>");
					
					br.append("<tr bgcolor='#cdc9c9'>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>S. No.</b></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Date</b></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='40%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Particulars</b></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Received Qty</b></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Issued Qty</b></td>");
					br.append("<td style=\"text-align: center;\" colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Balance</b></td>");
					br.append("</tr>");
					
					/*
					br.append("<tr>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></td>");										
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='40%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b></b></td>");
					
					br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Ready For Issue</b></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Rejected</b></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><b>Qty in Quarantine</b></td>");
					br.append("</tr>");
					*/
					if(ws.size() != 0)
					{
				
									
									// First Row
									br.append("<tr>");										
									br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nRowNum+"</td>");
									br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrFromDate()+"</td>");
									br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='40%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+"Opening Balance"+"</td>");
									br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+"0"+"</td>");
									br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+"0"+"</td>");
									
									br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nOpeningBalQtyActive+"</td>");
									//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nOpeningBalQtyInActive+"</td>");
									//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nOpeningBalQtyQuarantine+"</td>");
									br.append("<tr>");
									
									
										
										while(ws.next())
										{
											
											 /* Value Pass in Web Row Set
											  1.	TRANS_DATE
											  2.	PARTICULARS	
											  
											  3.	ACTIVE_ISSUE	
											  4.	INACTIVE_ISSUE	
											  5.	QUARTINE_ISSUE
											  	
											  6.	ACTIVE_REC	
											  7.	INACTIVE_REC	
											  8.	QUARTINE_REC
											  	
											  9.	STR_NAME	
											  10.	ITEM_NAME	
											  11.	HSTSTR_BATCH_SL_NO

								           	 */    	 	
											
																	
											String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)
																	 +"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)
																	 +"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)
																	 +"^"+ws.getString(10)+"^"+ws.getString(11);
											
											
											
											 nReceivedQtyActive			=	Double.parseDouble(ws.getString(6));
											 nReceivedQtyInActive		=	Double.parseDouble(ws.getString(7));
											 nReceivedQtyQuarantine		=	Double.parseDouble(ws.getString(8));
											
											 nTotalReceivedQty			=	nReceivedQtyActive + nReceivedQtyInActive +	nReceivedQtyQuarantine;// Total Received Qty
											 
											 nIssuedQtyActive			=	Double.parseDouble(ws.getString(3));
											 nIssuedQtyInActive			=	Double.parseDouble(ws.getString(4));
											 nIssuedQtyQuarantine		=	Double.parseDouble(ws.getString(5));
											
											 nTotalIssuedQty			=	nIssuedQtyActive + nIssuedQtyInActive + nIssuedQtyQuarantine;// Total Issued Qty
											 
											 nClosingBalQtyActive		=	nClosingBalQtyActive + nReceivedQtyActive - nIssuedQtyActive;
											 nClosingBalQtyInActive		=	nClosingBalQtyInActive + nReceivedQtyInActive - nIssuedQtyInActive;
											 nClosingBalQtyQuarantine   =	nClosingBalQtyQuarantine + nReceivedQtyQuarantine - nIssuedQtyQuarantine;
											
											
											 
											
											
											br.append("<tr>");
											br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
													
											
											br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+(count+1+nRowNum)+"</td>");
											br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(1)+"</td>");
											br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='40%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</td>"); 
											 
											br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nTotalReceivedQty+"</td>");
											br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nTotalIssuedQty+"</td>");
											
											
											br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nClosingBalQtyActive+"</td>");
											//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nClosingBalQtyInActive+"</td>");
											//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nClosingBalQtyQuarantine+"</td>");
											
											
											br.append("</tr>");
											
											count++ ;
											
										}	
										
										br.append("<tr>");										
										br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+(count+1+nRowNum)+"</td>");
										br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrToDate()+"</td>");
										br.append("<td style=\"text-align: center;\" class='multiRPTControl' colspan='1' width='40%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+"Closing Balance"+"</td>");
										br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+"---"+"</td>");
										br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+"---"+"</td>");
										
										br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nClosingBalQtyActive+"</td>");
									//	br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nClosingBalQtyInActive+"</td>");
									//	br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nClosingBalQtyQuarantine+"</td>");
										br.append("<tr>");
				}
				else
				{
					 // If No Details Available
					 
					
						// First Row for closing Balance
						br.append("<tr>");		
						
						

						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+nRowNum+"</td>");
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrFromDate()+"</td>");
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='40%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+"Opening Balance"+"</td>");
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+"0"+"</td>");
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+"0"+"</td>");
						
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrOpeningBalance().split("#")[0]+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrOpeningBalance().split("#")[1]+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrOpeningBalance().split("#")[2]+"</td>");
						br.append("<tr>");
						
						
						// Last Row for closing Balance
						br.append("<tr>");										
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+(count+1+nRowNum)+"</td>");
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrToDate()+"</td>");
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='40%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+"Closing Balance"+"</td>");
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+"---"+"</td>");
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+"---"+"</td>");
						
						br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='3' width='15%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrOpeningBalance().split("#")[0]+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrOpeningBalance().split("#")[1]+"</td>");
						//br.append("<td style=\"text-align: right;\" class='multiRPTControl' colspan='1' width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrOpeningBalance().split("#")[2]+"</td>");
						br.append("<tr>");
						
		           	    br.append("</table>");
		           	   
						
				   }
		} 
				
    }			
	catch (Exception e) 
	{	
			throw new Exception("StockLedgerRptHLP.getStockLedgerDetails()->"+e.getMessage());
	}
		return br.toString();
}
		
		
}		
