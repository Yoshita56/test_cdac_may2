package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.vo.SampleSentTransVO;

public class SampleSentTransHLP 
{
	
	
	
	
	public static String getIndentItemList(SampleSentTransVO vo) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		final int REC_PER_PAGE = 20;
		final int PAGE_PER_BLOCK = 20;		
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		WebRowSet ws =null;
		String strItemName="";
		String strItemNameWithBatch="";
		
		try
	    {   		
			    ws  = vo.getIndentItemWS();		
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
				    br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				    br.append("<tr>");			   
					br.append("<td class='TITLE' style=\"text-align:right;\" colspan='8'>Drug Name::::<select name='strItemNameCmb' class='comboTooMax'  onchange='openItemDivForItem(this);'>");
					br.append("<option value='0^0'>ALL</option>");
					while(ws.next())
					{	if(count==0)
					    {
						    strItemName  = ws.getString(2);
					    }
					    if(strItemName.equals(ws.getString(2)))
					    {
					    	strItemNameWithBatch =  ws.getString(2)+"("+ws.getString(18)+")";
					    	br.append("<option value='"+ws.getString(2)+"^"+ws.getString(18)+"'>"+strItemNameWithBatch+"</option>");
					    }
					    else
					    {
					    	strItemName  = ws.getString(2);
					    	strItemNameWithBatch =  ws.getString(2)+"("+ws.getString(18)+")";
					    	br.append("<option value='"+ws.getString(2)+"^"+ws.getString(18)+"'>"+strItemNameWithBatch+"</option>");
					    }
					    
					    count++;
					}
						
					br.append("</select></td></tr>");
					br.append("</table>");
					ws.beforeFirst();
					
					
					
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
					
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
					br.append("<tr>");					
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>Drug Name</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'>Avl. Qty</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Expiry Date</td>");					
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>PO No/Date</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Supplier</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Issue Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Secret Code</td>");					
					br.append("</tr>");					

					for (int j = 0; j < REC_PER_PAGE; j++) 
					{
						/*
					  	 1.Item Brand Id
					  	 2.Item Name
					  	 3.In-Hand Qty
					  	 4.Supplied
					  	 5.Manufactrer Date
					  	 6.Expiry Date
					  	 7.PO/Po date
					  	 8.Supplier Name
					  	 9.Item Id
					  	 10.Status Code
					  	 11.In-Hand Qty
					  	 12.In-Hand Qty Unit
					  	 13.Rate
                       14.Rate Unit
                       15.Supplier ID
                       16.PO No
                       17.PO Date
                       18.Batch No
                       19.Inventory Unit Id*/
						
						if(ws.next())
						{														  				    
							        br.append("<input type='hidden' name='hiddenValue'  id='hiddenValue"+i+""+j+"' value='"+ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"'>");
									br.append("<input type='hidden' name='itemName'     id='itemName"+i+""+j+"' value='"+ws.getString(2)+"^"+i+""+j+"'>");
									br.append("<input type='hidden' name='batchNo'      id='batchNo"+i+""+j+"' value='"+ws.getString(18)+"^"+i+""+j+"'>");
									br.append("<input type='hidden' name='inHandQty'    id='inHandQty"+i+""+j+"' value='"+ws.getString(3)+"'>");
									br.append("<input type='hidden' name='rateForCalc'  id='rateForCalc"+i+""+j+"' value='"+ws.getString(13)+"'>");
   								    br.append("<input type='hidden' name='divIndex'     id='divIndex"+i+"' value='"+i+"'>");
									br.append("<tr>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId1"+i+""+j+"'  width='30%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId2"+i+""+j+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><a STYLE='CURSOR:POINTER;color:blue'  title='Rate/Unit is  [ "+ws.getString(10)+" ]' >"+ws.getString(18)+"</a></font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId3"+i+""+j+"'  width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(11)+"</font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId4"+i+""+j+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(6)+"</font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId5"+i+""+j+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(7)+"</font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId6"+i+""+j+"'  width='15%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(8)+"</font></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId7"+i+""+j+"'  width='8%'><input type='text' name='strDSampleIssueQty'  value='0'  onkeypress='return validateData(event, 5);' onKeyUp='CompairWithAvlQty("+i+""+j+",1);'  id='strDSampleIssueQty"+i+""+j+"' class='txtFldMin'></td>");
									br.append("<td class='multiPOControl'  name='tdId' id='tdId8"+i+""+j+"'  width='12%'><input type='text' class='txtFldNormal'  onkeypress='return validateData(event,17);'   name='strDSampleCodeNumber' id='strDSampleCodeNumber"+i+""+j+"'></td>");
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
					
					br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
					for (int k = 0; k < reminder; k++) 
					{
						/*
					  	 1.Item Brand Id
					  	 2.Item Name
					  	 3.In-Hand Qty
					  	 4.Supplied
					  	 5.Manufactrer Date
					  	 6.Expiry Date
					  	 7.PO/Po date
					  	 8.Supplier Name
					  	 9.Item Id
					  	 10.Status Code
					  	 11.In-Hand Qty
					  	 12.In-Hand Qty Unit
					  	 13.Rate
                        14.Rate Unit
                        15.Supplier ID
                        16.PO No
                        17.PO Date
                        18.Batch No
                        19.Inventory Unit Id*/
						
						br.append("<input type='hidden' name='hiddenValue'  id='hiddenValue"+i+""+k+"' value='"+ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"'>");
						br.append("<input type='hidden' name='itemName'     id='itemName"+i+""+k+"' value='"+ws.getString(2)+"^"+i+""+k+"'>");
						br.append("<input type='hidden' name='batchNo'      id='batchNo"+i+""+k+"' value='"+ws.getString(18)+"^"+i+""+k+"'>");
						br.append("<input type='hidden' name='inHandQty'     id='inHandQty"+i+""+k+"' value='"+ws.getString(3)+"'>");
						br.append("<input type='hidden' name='rateForCalc'  id='rateForCalc"+i+""+k+"' value='"+ws.getString(13)+"'>");
						br.append("<input type='hidden' name='divIndex'     id='divIndex"+i+"' value='"+i+"'>");
						br.append("<tr>");
						br.append("<td class='multiPOControl'  name='tdId' id='tdId1"+i+""+k+"'  width='30%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</font></td>");
						br.append("<td class='multiPOControl'  name='tdId' id='tdId2"+i+""+k+"'  width='10%' ><font size='1' face='Verdana, Arial, Helvetica, sans-serif' ><a STYLE='CURSOR:POINTER;color:blue'  title='Rate/Unit is  [ "+ws.getString(10)+" ]' >"+ws.getString(18)+"</a></font></td>");
						br.append("<td class='multiPOControl'  name='tdId' id='tdId3"+i+""+k+"'  width='5%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(11)+"</font></td>");
						br.append("<td class='multiPOControl'  name='tdId' id='tdId4"+i+""+k+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(6)+"</font></td>");
						br.append("<td class='multiPOControl'  name='tdId' id='tdId5"+i+""+k+"'  width='10%'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(7)+"</font></td>");
						br.append("<td class='multiPOControl'  name='tdId' id='tdId6"+i+""+k+"'  width='15%' style=\"text-align:left;\"><font size='1' face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(8)+"</font></td>");
						br.append("<td class='multiPOControl'  name='tdId' id='tdId7"+i+""+k+"'  width='8%'><input type='text' name='strDSampleIssueQty'  value='0' onkeypress='return validateData(event, 5);' onKeyUp='CompairWithAvlQty("+i+""+k+",1);'  id='strDSampleIssueQty"+i+""+k+"' class='txtFldMin'></td>");
						br.append("<td class='multiPOControl'  name='tdId' id='tdId8"+i+""+k+"'  width='12%'><input type='text' class='txtFldNormal'  onkeypress='return validateData(event,17);'   name='strDSampleCodeNumber' id='strDSampleCodeNumber"+i+""+k+"'></td>");
						br.append("</tr>");			
						}
						
						count++ ;
						
					}
					br.append("</table>");					
					br.append("</div>");
					
			   	}
			    br.append("</div>");			    
			    br.append("<table class='TABLEWIDTH' align='center'  border='0' cellpadding='1px' cellspacing ='1px'>");
			    br.append("<tr>");			   
			    br.append("<td class='LABEL'><span onclick='prevFunction();' class='pg-normal'> &#171 Prev </span><select name='pageIndeCmb' class='comboMin' onchange='openItemDiv(this);'>");
				for (int k = 1; k <= totalLayer; k++)
				{
					br.append("<option value='"+k+"'>"+k+"</option>");						
				}
			    br.append("</select>");
			    br.append("<span onclick='nextFunction();' class='pg-normal'> Next &#187;</span>");
			    br.append("</td></tr>");
			    br.append("</table>");	
			   
			}
			else
			{
				 
				
				    br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				    br.append("<tr bgcolor='#FFEBD5'>");					
					br.append("<th colspan='4'></th>");
					br.append("<th colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' style=\"color: #653232;\" >Requested Quantity</font></th>");
					br.append("<th colspan='1'></th>");
					br.append("</tr>");
					br.append("<tr>");					
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>DrugName</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Avl. Qty</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Expiry Date</td>");					
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>PO No/Date</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Supplier</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issue Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Secret Code</td>");					
					br.append("</tr>");		
				    br.append("<tr>");  
	           	    br.append("<td class='multiRPTControl' colspan='8'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	    br.append("</table>");
	           	
					
			   }
			} 
		    else
				{
					 
					 
		    	    br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
		    	    br.append("<tr bgcolor='#FFEBD5'>");					
					br.append("<th colspan='4'></th>");
					br.append("<th colspan='3'><font size='1' face='Verdana, Arial, Helvetica, sans-serif' style=\"color: #653232;\" >Requested Quantity</font></th>");
					br.append("<th colspan='1'></th>");
					br.append("</tr>");
					br.append("<tr>");					
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='30%'>DrugName</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Avl. Qty</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Expiry Date</td>");					
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>PO No/Date</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Supplier</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issue Qty.</td>");
					br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Secret Code</td>");					
					br.append("</tr>");		
				    br.append("<tr>");  
	           	    br.append("<td class='multiRPTControl' colspan='9'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	    br.append("</table>");
		          	
						
				   }
	     }
		
	catch (Exception e) {	
		    e.printStackTrace();
			throw new Exception("OffLineIssueIndentTransHLP.getIndentItemList()->"+e.getMessage());
		}
		return br.toString();
	}
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
	public static String getPrintSampleSentLabelView(String strHiddenValue) throws Exception 
	{
		StringBuffer sb = new StringBuffer("");
		String strResponse[] = null;
		
 		String strTableWidth = "700";
		try 
		{
			
			sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(1);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(1);' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			sb.append(" <br> ");
			
			
//          Lab Sne No +      CTR No  + Item Brand Name  + Batch No  + Mfd Date +  Lab Number + Exp Date + Mfd By
						
			    strResponse = strHiddenValue.replace("$$$$", "#").split("#");
			    for (int i = 1; i < strResponse.length; i++) 
				{
			    	String ctrNumber ="";
				    if(strResponse[i].replace("^", "#").split("#")[1].equals("0")||strResponse[i].replace("^", "#").split("#")[1].equals(""))
				    {
				    	ctrNumber = "---";
				    }
				    else
				    {
				    	ctrNumber = strResponse[i].replace("^", "#").split("#")[1];
				    }
						sb.append(" <br> ");
						sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr> ");
						sb.append("<td align='center' width='50%' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>DECODING OF SECRET CODE NO::</b>"+strResponse[i].replace("^", "#").split("#")[0]+"</font> ");
						sb.append("</td>");
						sb.append("<td align='center' width='50%' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>CTR NO::</b>"+ctrNumber+"</font> ");
						sb.append("</td>");
						sb.append("</tr> ");
		 	            sb.append("</table> ");
						
						sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr> ");
						sb.append("<td  colspan='4' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name::  "+strResponse[i].replace("^", "#").split("#")[2]+"</b></font><b></td>");
						sb.append("</tr> ");				
						sb.append(" </table> ");
								
						sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr> ");
						sb.append("<td align='center' width='25%' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font> ");
						sb.append("</td> ");				
						sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strResponse[i].replace("^", "#").split("#")[3]+"</font> ");
						sb.append("</td> ");
						
						sb.append("<td align='center' width='25%' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Mfg. Date</b></font> ");
						sb.append("</td> ");				
						sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strResponse[i].replace("^", "#").split("#")[4]+"</font> ");
						sb.append("</td> ");
						sb.append("</tr> ");
						
						sb.append("<tr> ");
						sb.append("<td align='center' width='25%' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>M.L. No.</b></font> ");
						sb.append("</td> ");				
						sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strResponse[i].replace("^", "#").split("#")[5]+"</font> ");
						sb.append("</td> ");
						
						sb.append("<td align='center' width='25%'bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Date</b></font> ");
						sb.append("</td> ");				
						sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+strResponse[i].replace("^", "#").split("#")[6]+"</font> ");
						sb.append("</td> ");
						sb.append("</tr> ");
						sb.append("</table> ");
						sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
						sb.append("<tr> ");
						sb.append("<td  width='25%' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Mfd By::"+strResponse[i].replace("^", "#").split("#")[7]+"</b></font><b></td>");
						sb.append("</tr> ");				
						sb.append(" </table> ");
				}	

		} 
		catch (Exception e) 
		{

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}
	
	
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
	public static String getPrintSampleSentLabel(SampleSentTransVO vo) throws Exception 
	{
		StringBuffer sb = new StringBuffer("");
		String strHiddenValue = vo.getStrHiddenBatchDtl();
 		String strTableWidth = "700";
		try 
		{
			/*
                           0                                        1
			NVL(A.HSTNUM_INHAND_QTY,'''')||''^''||Mms_Mst.GET_SUPP_DTL(1,A.GNUM_HOSPITAL_CODE,HSTNUM_SUPPLIER_ID)||''^''||
			             2                                                          3                       
			NVL(TO_CHAR(A.HSTDT_MANUF_DATE,''DD-Mon-YYYY''),'''')||''^''||NVL(TO_CHAR(A.HSTDT_EXPIRY_DATE,''DD-Mon-YYYY''),'''')||''^''||
			--------------------      4   ----------------------------------                              
			NVL(A.HSTNUM_PO_NO,'''')||''/''||NVL(TO_CHAR(A.HSTDT_PO_DATE,''DD-Mon-YYYY''),'''')||''^''||
			                            5                                                  6
			Mms_Mst.GET_SUPP_DTL(1,A.GNUM_HOSPITAL_CODE,A.HSTNUM_SUPPLIED_BY) ||''^''||A.HSTNUM_ITEM_ID
			              7                                    8                     9                               10     
			||''^''||HSTNUM_STOCK_STATUS_CODE||''^''||HSTNUM_INHAND_QTY||''^''|| HSTNUM_INHAND_QTY_UNITID  ||''^''|| HSTNUM_RATE  ||''^''||
			  11                            12                           13                        
			HSTNUM_RATE_UNITID  ||''^''|| HSTDT_MANUF_DATE   ||''^''|| HSTDT_EXPIRY_DATE    ||''^''||
			  14                             15                          16                       17                18      19          20
			HSTNUM_SUPPLIER_ID  ||''^''|| HSTNUM_SUPPLIED_BY   ||''^''|| HSTNUM_PO_NO    ||''^''|| HSTDT_PO_DATE ^ BATCH_NO^ITEM_BRND^STORE_ID
*/
			    String ctrNumber ="";
			    if(vo.getStrCTRNumber().equals("0"))
			    {
			    	ctrNumber = "---";
			    }
			    else
			    {
			    	ctrNumber = vo.getStrCTRNumber();
			    }
			
	    		sb.append("<table border='0' width='").append(strTableWidth).append("' align='center'> ");
				sb.append("<tr> ");
				sb.append("<td align='right'>");
	 			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
				sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
				sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData(1);' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
				sb.append(" src='../../hisglobal/images/stop.png' onClick='hidePopup(1);' /> </div></div>");
				sb.append(" </td> ");
				sb.append(" </tr> ");
				sb.append(" </table> ");
				sb.append(" <br> ");
			
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td align='center' width='50%' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>DECODING OF SECRET CODE NO::</b>"+vo.getStrLabSendNo()+"</font> ");
				sb.append("</td>");
				sb.append("<td align='center' width='50%' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>CTR NO::</b>"+ctrNumber+"</font> ");
				sb.append("</td>");
				sb.append("</tr> ");
 	            sb.append("</table> ");
				
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td  colspan='4' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name::  "+vo.getStrDrugName()+"</b></font><b></td>");
				sb.append("</tr> ");				
				sb.append(" </table> ");
						
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td align='center' width='25%' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No</b></font> ");
				sb.append("</td> ");				
				sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrBatchNo()+"</font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='25%'bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Mfg. Date</b></font> ");
				sb.append("</td> ");				
				sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrHiddenBatchDtl().split("\\^")[12]+"</font> ");
				sb.append("</td> ");
				sb.append("</tr> ");
				
				sb.append("<tr> ");
				sb.append("<td align='center' width='25%' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>M.L. No.</b></font> ");
				sb.append("</td> ");				
				sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrLabCode()+"</font> ");
				sb.append("</td> ");
				
				sb.append("<td align='center' width='25%' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Exp Date</b></font> ");
				sb.append("</td> ");				
				sb.append("<td align='center' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+vo.getStrHiddenBatchDtl().split("\\^")[13]+"</font> ");
				sb.append("</td> ");
				sb.append("</tr> ");
				sb.append("</table> ");
				sb.append("<table width='").append(strTableWidth).append("' align='center' cellpadding='1px' cellspacing='1px'> ");
				sb.append("<tr> ");
				sb.append("<td  width='25%' bgcolor='#cdc9c9'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Mfd By::"+vo.getStrHiddenBatchDtl().split("\\^")[1]+"</b></font><b></td>");
				sb.append("</tr> ");				
				sb.append(" </table> ");

		} 
		catch (Exception e) 
		{

			e.printStackTrace();

			throw e;
		}

		return sb.toString();
	}
	
	

	public static String getViewSampleSentDetails(SampleSentTransVO vo) 
	 {
		StringBuffer sb = new StringBuffer("");
		int start = 1;
		final int REC_PER_PAGE = 100;
		final int PAGE_PER_BLOCK = 100;
		int count=0;
		String strApplyClass    = "";
		String strApprovStatus= "";
		//MmsConfigUtil mcu = null;
		WebRowSet ws = null;
		String strMfdDate="";
		String strExpDate="";
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
	    try
	    {
	    	//mcu = new MmsConfigUtil();
	    	ws = vo.getWsLabSentHlp();
	    	
		if (ws != null) 
		{
			if(ws.size() != 0)
			{
				//System.out.println("Hello1");
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
			 
			 sb.append("<input type='hidden' name='TotalLayer'  value='").append(totalLayer).append("'>");
			 sb.append("<input type='hidden' name='RecordShowOnPage'  value='").append(REC_PER_PAGE).append("'>");
			 sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
			 sb.append("<tr>");
			 sb.append("<td class='LABEL' >");
			 for (int i = 1; i <= totalLayer; i++)
			 {
				sb.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			sb.append("</td>");
			sb.append("</tr>");
    		sb.append("</table>");
			sb.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' bgcolor='#6097BC'>");
	        sb.append("<tr>");
	        sb.append("<td width='5%'class='multiRPTLabel'>#");
		    sb.append("</td>");
	        sb.append("<td width='10%'class='multiRPTLabel'>Sent Date");
		    sb.append("</td>");
//	        sb.append("<td width='14%'class='multiLabel'>Lab Name");
//	        sb.append("</td>");
	        sb.append("<td width='24%'class='multiRPTLabel'>Drug Name");
	        sb.append("</td>");
	        sb.append("<td width='10%'class='multiRPTLabel'>Batch No.");
	        sb.append("</td>");
	        sb.append("<td width='8%'class='multiRPTLabel'>Sent Qty");
		    sb.append("</td>");
		    sb.append("<td width='9%'class='multiRPTLabel'>Secret CodeNo.");
		    sb.append("</td>");
		    sb.append("<td width='15%'class='multiRPTLabel'>Mfd.@Expiry Date");
		    sb.append("</td>");
//		    sb.append("<td width='5%'class='multiLabel'><input name='chkmain' onclick='CheckedAll(this);' type='CHECKBOX'>");
//		    sb.append("</td>");
	        sb.append("</tr>");
	        sb.append("</table>");
	        
		    for (int i = 1; i <= totalLayer; i++) 
		    {
			 if (i <= totalLayer) 
			 {
				 
				if (i == 1) 
				{
					sb.append("<div id='DivId" ).append(i).append( "' style='display:block'>");
				} 
				else
				{
					sb.append("<div id='DivId" ).append(i).append( "' style='display:none'>");
				}
				
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='#6097BC' cellpadding='1px'>");
				for (int j = 0; j < REC_PER_PAGE; j++) 
				{
					/*
					 1- Item Id
					 2- Lab Sent Date
					 3- Sent Store Name
					 4- Generic Name
					 5-Brand Name
					 6- Batch
					 7-Exp Date
					 8-Transfer Qty
					 9-Store Id Sent
					 10-Item Id
					 11-Item Brand ID
					 12-Rate With Unit
					 13-Rate Base value
					 14-Consumed Qty
					 15=Consumed Qty Wit Unit
					 16-Qty Base Value
					 17-Item Sl No
					 18-Item Sl No
					 19-Catg Code
					 20- Lab Send No
					 21-Lab Name
					 22-CTR Number
					 23-Net Cost
					 24-PO No
					 25-PO Date
					 26-Mfd Date
					 27-Is Send Decode Value
                     28-Lab No
                     29-Manufacter By
                     30.QC Status
                     31. Report Date
                     32.Seceret Code No.
                     33.REPORT PENDING/RECEIVED (RP Stand for Report Pending / RR Report Received)
                   */
					if(ws.next())
					{
						
						if(!ws.getString(7).equals(""))
						{	
							strExpDate = ws.getString(7);
						}
						else
						{
							strExpDate = "-----";
						}
						//System.out.println("Mfd date==>"+ws.getString(26));
						if(!ws.getString(26).equals("")||!ws.getString(26).equals("/"))
						{	
							strMfdDate = ws.getString(26);
						}
						else
						{
							strMfdDate = "-----";
						}
						
						
					 strApprovStatus  = ws.getString(33).trim();
				
					 String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)
					                          +"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)
					                          +"^"+ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)
					                          +"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31)+"^"+ws.getString(32)+"^"+ws.getString(33)+"^0";
					
					//                           Lab Sne No +      CTR No  + Item Brand Name  + Batch No  + Mfd Date +  Lab Number + Exp Date + Mfd By
					 String strPrintLabelValue = ws.getString(20)+"^"+ws.getString(22)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(26)+"^"+ws.getString(28)+"^"+ws.getString(7)+"^"+ws.getString(29);
                    		sb.append("<tr>");
                    		
                     sb.append("<input type='hidden' name='strHidValueFlag' id='strHidValueFlag"+count+"' value='0'>");
					 sb.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					 sb.append("<input type='hidden' name='strPrintLabelValue' id='strPrintLabelValue"+count+"' value='"+strPrintLabelValue+"'>");
						if(strApprovStatus.equals("RR")) 
					    {
							strApplyClass = "Approved";
							
						    sb.append("<tr>");
							sb.append("<td width='5%'class='"+strApplyClass+"'><input value='0' name='chkFlg' id='chkFlg"+count+"' onclick='CheckedFlg(this,\""+count+"\");' type='CHECKBOX' disabled>");
						    sb.append("</td>");
							sb.append("<td class='"+strApplyClass+"' width='10%'>");
							sb.append(ws.getString(2));
							sb.append("</td>");
//							sb.append("<td class='"+strApplyClass+"' width='15%' style=\"text-align:left;\">");
//							sb.append(ws.getString(21));
//							sb.append("</td>");
							sb.append("<td class='"+strApplyClass+"' width='25%' style=\"text-align:left;\">");
							sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' title='Get Drug Details' name='strDrugName' id='strDrugName"+count+"' onClick='drugDtl(this,\""+count+"\");'>"+ws.getString(5)+"</a> &nbsp;");
							sb.append("</td>");
							sb.append("<td class='"+strApplyClass+"' width='10%'>");
							sb.append(ws.getString(6));
							sb.append("</td>");
							sb.append("<td class='"+strApplyClass+"' width='8%'>");
							sb.append(ws.getString(8));
							sb.append("</td>");
							sb.append("<td class='"+strApplyClass+"' width='10%'>");
							sb.append(ws.getString(32));
							sb.append("</td>");
							sb.append("<td class='"+strApplyClass+"' width='12%'>");
							sb.append(strMfdDate+"@"+strExpDate);
							sb.append("</td>");
		
							sb.append("</tr>");
					    }
						else
						{
							if(!ws.getString(7).equals(""))
							{	
								strExpDate = ws.getString(7);
							}
							else
							{
								strExpDate = "-----";
							}
							//System.out.println("Mfd date==>"+ws.getString(26));
							if(!ws.getString(26).equals("")||!ws.getString(26).equals("/"))
							{	
								strMfdDate = ws.getString(26);
							}
							else
							{
								strMfdDate = "-----";
							}
                            strApplyClass = "NotApproved";
							
						    sb.append("<tr>");
							sb.append("<td width='5%'class='"+strApplyClass+"'><input value='0' name='chkFlg' id='chkFlg"+count+"' onclick='CheckedFlg(this,\""+count+"\");' type='CHECKBOX'>");
							sb.append("</td>");
							sb.append("<td class='"+strApplyClass+"' width='10%'>");
							sb.append(ws.getString(2));
							sb.append("</td>");
//							sb.append("<td class='"+strApplyClass+"' width='15%' style=\"text-align:left;\">");
//							sb.append(ws.getString(21));
//							sb.append("</td>");
							sb.append("<td class='"+strApplyClass+"' width='25%' style=\"text-align:left;\">");
							sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' title='Get Drug Details' name='strDrugName' id='strDrugName"+count+"' onClick='drugDtl(this,\""+count+"\");'>"+ws.getString(5)+"</a> &nbsp;");
							sb.append("</td>");
							sb.append("<td class='"+strApplyClass+"' width='10%'>");
							sb.append(ws.getString(6));
							sb.append("</td>");
							sb.append("<td class='"+strApplyClass+"' width='8%'>");
							sb.append(ws.getString(8));
							sb.append("</td>");
							sb.append("<td class='"+strApplyClass+"' width='10%'>");
							sb.append(ws.getString(32));
							sb.append("</td>");
							sb.append("<td class='"+strApplyClass+"' width='12%'>");
							sb.append(strMfdDate+"@"+strExpDate);
							sb.append("</td>");
		
							sb.append("</tr>");
						}
					}
					else
					{
						break;
					}
					count++;
				}
				sb.append("</table>");
				sb.append("</div>");

			} 
			else 
			{
				sb.append("<div id='DivId" ).append( i).append( "' style='display:none'>");
				
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					 String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)
                     +"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)
                     +"^"+ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)
                     +"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31)+"^"+ws.getString(32)+"^"+ws.getString(33)+"^0";

					//                           Lab Sne No +      CTR No  + Item Brand Name  + Batch No  + Mfd Date +  Lab Number + Exp Date + Mfd By
					String strPrintLabelValue = ws.getString(20)+"^"+ws.getString(22)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(26)+"^"+ws.getString(28)+"^"+ws.getString(7)+"^"+ws.getString(29);
						sb.append("<tr>");
									
					sb.append("<input type='hidden' name='strHidValueFlag' id='strHidValueFlag"+count+"' value='0'>");
					sb.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					sb.append("<input type='hidden' name='strPrintLabelValue' id='strPrintLabelValue"+count+"' value='"+strPrintLabelValue+"'>");
					
					if(strApprovStatus.equals("RR")) 
				    {
						if(!ws.getString(7).equals(""))
						{	
							strExpDate = ws.getString(7);
						}
						else
						{
							strExpDate = "-----";
						}
						//System.out.println("Mfd date==>"+ws.getString(26));
						if(!ws.getString(26).equals("")||!ws.getString(26).equals("/"))
						{	
							strMfdDate = ws.getString(26);
						}
						else
						{
							strMfdDate = "-----";
						}
						strApplyClass = "Approved";
						
					    sb.append("<tr>");
						sb.append("<td width='5%'class='"+strApplyClass+"'><input value='0' name='chkFlg' id='chkFlg"+count+"' onclick='CheckedFlg(this,\""+count+"\");' type='CHECKBOX' disabled>");
					    sb.append("</td>");
						sb.append("</td>");
						sb.append("<td class='"+strApplyClass+"' width='10%'>");
						sb.append(ws.getString(2));
						sb.append("</td>");
//						sb.append("<td class='"+strApplyClass+"' width='15%' style=\"text-align:left;\">");
//						sb.append(ws.getString(21));
//						sb.append("</td>");
						sb.append("<td class='"+strApplyClass+"' width='25%' style=\"text-align:left;\">");
						sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' title='Get Drug Details' name='strDrugName' id='strDrugName"+count+"' onClick='drugDtl(this,\""+count+"\");'>"+ws.getString(5)+"</a> &nbsp;");
						sb.append("</td>");
						sb.append("<td class='"+strApplyClass+"' width='10%'>");
						sb.append(ws.getString(6));
						sb.append("</td>");
						sb.append("<td class='"+strApplyClass+"' width='8%'>");
						sb.append(ws.getString(8));
						sb.append("</td>");
						sb.append("<td class='"+strApplyClass+"' width='10%'>");
						sb.append(ws.getString(32));
						sb.append("</td>");
						sb.append("<td class='"+strApplyClass+"' width='12%'>");
						sb.append(ws.getString(7)+"@"+ws.getString(26));
						sb.append("</td>");
	
						sb.append("</tr>");
				    }
					else
					{
						if(!ws.getString(7).equals(""))
						{	
							strExpDate = ws.getString(7);
						}
						else
						{
							strExpDate = "-----";
						}
						//System.out.println("Mfd date==>"+ws.getString(26));
						if(!ws.getString(26).equals("")||!ws.getString(26).equals("/"))
						{	
							strMfdDate = ws.getString(26);
						}
						else
						{
							strMfdDate = "-----";
						}
                        strApplyClass = "NotApproved";
						
					    sb.append("<tr>");
						sb.append("<td width='5%'class='"+strApplyClass+"'><input value='0' name='chkFlg' id='chkFlg"+count+"' onclick='CheckedFlg(this,\""+count+"\");' type='CHECKBOX'>");
					    sb.append("</td>");
						sb.append("</td>");
						sb.append("<td class='"+strApplyClass+"' width='10%'>");
						sb.append(ws.getString(2));
						sb.append("</td>");
//						sb.append("<td class='"+strApplyClass+"' width='15%' style=\"text-align:left;\">");
//						sb.append(ws.getString(21));
//						sb.append("</td>");
						sb.append("<td class='"+strApplyClass+"' width='25%' style=\"text-align:left;\">");
						sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' title='Get Drug Details' name='strDrugName' id='strDrugName"+count+"' onClick='drugDtl(this,\""+count+"\");'>"+ws.getString(5)+"</a> &nbsp;");
						sb.append("</td>");
						sb.append("<td class='"+strApplyClass+"' width='10%'>");
						sb.append(ws.getString(6));
						sb.append("</td>");
						sb.append("<td class='"+strApplyClass+"' width='8%'>");
						sb.append(ws.getString(8));
						sb.append("</td>");
						sb.append("<td class='"+strApplyClass+"' width='10%'>");
						sb.append(ws.getString(32));
						sb.append("</td>");
						sb.append("<td class='"+strApplyClass+"' width='12%'>");
						sb.append(ws.getString(7)+"@"+ws.getString(26));
						sb.append("</td>");
	
						sb.append("</tr>");
					}
					count++;
				
				}
				sb.append("</table>");
				sb.append("</div>");
				}
		   	}
		sb.append("</td>");
		sb.append("</tr>");
		sb.append("</table>");
		}
		else
		{
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='black' cellpadding='1px'>");
			sb.append("<tr>");
			sb.append("<td class='multiControl'><font color='red'>No Record Found</font></td>");
			sb.append("</tr>");
			sb.append("</table>");
		}
	   } 
		
	 }
	 catch(Exception e)
	 {
		    e.printStackTrace();
		    new HisException("Breakage Details Transaction","BreakageItemDtlTransHLP.getBreakageDetails()-->",e.getMessage());
	    }
	     //System.out.println("sb"+sb);
	    return sb.toString();
	 	}


	
	
}
