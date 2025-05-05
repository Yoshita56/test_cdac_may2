package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.transactions.vo.SampleReceiveDetailProcessTransVO;

public class SampleReceiveDetailProcessTransHLP 
{
	public static String getIssueDrugDtlsHlp(SampleReceiveDetailProcessTransVO vo) throws Exception 
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
			    1. ISSUE DATE
				2. STORE NAME
				3. ITEM NAME
				4. BATCH NO
				5. EXPIRY DATE    
				6. ISSUE QUANTITY
				7. ISSUE NO
				8. ITEM BRAND ID
				9. ITEM SL.NO
				10.HSTNUM_STOCK_STATUS_CODE
				11.to_store_id
				12.INHAND_QTY
				13.INHAND_QTY_UNITID
				14.RATE
				15.RATE_UNITID
				16.HSTDT_MFG_DATE 
				17.HSTNUM_SUPPLIER_ID 
				18.HSTNUM_MFG_ID 
				19.HSTSTR_PO_NO 
				20.HSTDT_PO_DATE 
				21.HSTDT_RECEIVE_DATE 
				22.HSTNUM_IS_REISSUE 
				23.GSTR_REMARKS 
				24.HSTDT_FINANCIAL_START_DATE 
				25.HSTDT_FINANCIAL_END_DATE 
				26.GDT_ENTRY_DATE 
				27.GNUM_SEATID 
				28.GNUM_ISVALID
				29.HSTNUM_ITEM_ID,
				30.HSTNUM_ISSUEQTY_UNITID,
				31.HSTNUM_ISSUE_QTY
				32.HSTNUM_STORE_ID
			  
			  //VoObj
			  STORE_ID =	vo.getStrDrugWareHouseId();
			  ITEM CAT NO=	vo.getStrItemCategoryNo();
			  
			 */
			
			ws= vo.getWrsDrugIssueDetail();
			br.append("<table class='TABLEWIDTH' align='center'  cellspacing='1px' cellpadding='1px'>");
		 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Sample Receive Details</td></tr></table>");	
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
					
						
						br.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellspacing='1px' cellpadding='1px'>");
						//br.append("<tr class='TITLE'>");
						//br.append("<td colspan='4'></td></tr>");
						br.append("<tr>");
						br.append("<td CLASS='multiRPTLabel' colspan='1' width='4%'><input name='chkmain' id = 'chkmainId' onclick='CheckedAll(this);' type='CHECKBOX'></td>");
						br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issue Date</td>");
						br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>DWH Name</td>");
						br.append("<td CLASS='multiRPTLabel' colspan='1' width='26%'>Drug Name</td>");
						br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Batch No.</td>");
						br.append("<td CLASS='multiRPTLabel' colspan='1' width='8%'>Expiry Date</td>");
						br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Issued Qty</td>");
						br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Bkg/Lost Qty</td>");	
						br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Received Qty</td>");
						
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
								
								br.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellspacing='1px'>");
								for (int j = 0; j < REC_PER_PAGE; j++) 
								{
									if(ws.next())
									{
										/* Value Pass in Web Row Set
									    1. ISSUE DATE
										2. STORE NAME
										3. ITEM NAME
										4. BATCH NO
										5. EXPIRY DATE    
										6. ISSUE QUANTITY
										7. ISSUE NO
										8. ITEM BRAND ID
										9. ITEM SL.NO
										10.HSTNUM_STOCK_STATUS_CODE
										11.to_store_id
										12.INHAND_QTY
										13.INHAND_QTY_UNITID
										14.RATE
										15.RATE_UNITID
										16.HSTDT_MFG_DATE 
										17.HSTNUM_SUPPLIER_ID 
										18.HSTNUM_MFG_ID 
										19.HSTSTR_PO_NO 
										20.HSTDT_PO_DATE 
										21.HSTDT_RECEIVE_DATE 
										22.HSTNUM_IS_REISSUE 
										23.GSTR_REMARKS 
										24.HSTDT_FINANCIAL_START_DATE 
										25.HSTDT_FINANCIAL_END_DATE 
										26.GDT_ENTRY_DATE 
										27.GNUM_SEATID 
										28.GNUM_ISVALID
										29.HSTNUM_ITEM_ID,
										30.HSTNUM_ISSUEQTY_UNITID,
										31.HSTNUM_ISSUE_QTY
										32.SEND STORE ID
										*/
										
										//System.out.println("DrugWarehouseId in SampleReceiveDetailProcessTransHLP.getIssueDrugDtlsHlp() : "+vo.getStrDrugWareHouseId());
										String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31)+"^"+ws.getString(32);		
										
										br.append("<tr>");
										br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
										//br.append("<td class='multiControl' colspan='1' width='5%'><b>");
										//br.append(start);
										//br.append("</b></td>");
										
										br.append("<td class='multiPOControl' colspan='1' width='4%'><input type='checkbox' name='strIssueChkIndex'  onClick='chkBoxClick(this,\""+count+"\");' id='strIssueChkIndex"+count+"' value='0' /></td>");
										br.append("<td class='multiPOControl' colspan='1' width='10%'>"+ws.getString(1)+"</td>");
										br.append("<td class='multiPOControl' colspan='1' width='12%'>"+ws.getString(2)+"</td>");
										br.append("<td class='multiPOControl' colspan='1' width='26%' style=\"text-align:left;\">"+ws.getString(3)+"</td>");
										br.append("<td class='multiPOControl' colspan='1' width='10%'>"+ws.getString(4)+"</td>");
										br.append("<td class='multiPOControl' colspan='1' width='8%'>"+ws.getString(5)+"</td>");
										br.append("<td class='multiPOControl' colspan='1' width='10%'>"+ws.getString(6)+"</td>");
										br.append("<td class='multiPOControl' colspan='1' width='10%'><input type='text' name='strBkgQty' disabled class='txtFldMin' id='strBkgQty"+count+"' value='0' onkeypress='return validateData(event,7);' onblur='notGreaterThanReceQty(this,\""+count+"\");' /></td>");
										br.append("<td class='multiPOControl' colspan='1' width='10%'><input type='text' name='strReceivedQty' disabled class='txtFldMin' id='strReceivedQty"+count+"' value='0' /></td>");
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
								
								br.append("<table class='TABLEWIDTH' align='center' bgcolor='#6097BC' cellspacing='1px'>");
								for (int k = 0; k < reminder; k++) 
								{
									ws.next();
									
									/* Value Pass in Web Row Set
									    1. ISSUE DATE
										2. STORE NAME
										3. ITEM NAME
										4. BATCH NO
										5. EXPIRY DATE    
										6. ISSUE QUANTITY
										7. ISSUE NO
										8. ITEM BRAND ID
										9. ITEM SL.NO
										10.HSTNUM_STOCK_STATUS_CODE
										11.to_store_id
										12.INHAND_QTY
										13.INHAND_QTY_UNITID
										14.RATE
										15.RATE_UNITID
										16.HSTDT_MFG_DATE 
										17.HSTNUM_SUPPLIER_ID 
										18.HSTNUM_MFG_ID 
										19.HSTSTR_PO_NO 
										20.HSTDT_PO_DATE 
										21.HSTDT_RECEIVE_DATE 
										22.HSTNUM_IS_REISSUE 
										23.GSTR_REMARKS 
										24.HSTDT_FINANCIAL_START_DATE 
										25.HSTDT_FINANCIAL_END_DATE 
										26.GDT_ENTRY_DATE 
										27.GNUM_SEATID 
										28.GNUM_ISVALID
										29.HSTNUM_ITEM_ID,
										30.HSTNUM_ISSUEQTY_UNITID,
										31.HSTNUM_ISSUE_QTY
									  
									   //VoObj
										  STORE_ID =	vo.getStrDrugWareHouseId();
										  ITEM CAT NO=	vo.getStrItemCategoryNo();
									  
									 */		
									String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31)+"^"+ws.getString(32);		
									
									br.append("<tr>");
									br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
									//br.append("<td class='multiControl' colspan='1' width='5%'><b>");
									//br.append(start);
									//br.append("</b></td>");
									
									br.append("<td class='multiPOControl' colspan='1' width='4%'><input type='checkbox' name='strIssueChkIndex' id='strIssueChkIndex"+count+"' value='0' /></td>");
									br.append("<td class='multiPOControl' colspan='1' width='10%'>"+ws.getString(1)+"</td>");
									br.append("<td class='multiPOControl' colspan='1' width='12%'>"+ws.getString(2)+"</td>");
									br.append("<td class='multiPOControl' colspan='1' width='26%' style=\"text-align:left;\">"+ws.getString(3)+"</td>");
									br.append("<td class='multiPOControl' colspan='1' width='10%'>"+ws.getString(4)+"</td>");
									br.append("<td class='multiPOControl' colspan='1' width='8%'>"+ws.getString(5)+"</td>");
									br.append("<td class='multiPOControl' colspan='1' width='10%'>"+ws.getString(6)+"</td>");
									br.append("<td class='multiPOControl' colspan='1' width='10%'><input type='text' name='strBkgQty' class='txtFldMin' id='strBkgQty"+count+"'  disabled  value='0' onkeypress='return validateData(event,7);' onkeyup='notGreaterThanReceQty(this,\""+count+"\");' /></td>");
									br.append("<td class='multiPOControl' colspan='1' width='10%'><input type='text' name='strReceivedQty' id='strReceivedQty"+count+"'   disabled class='txtFldMin' id='strReceivedQty"+count+"' value='0' /></td>");
									
									
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
						 
						
						 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='#6097BC' cellpadding='1px'>");
						 br.append("<tr>");
						 br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'><input name='chkmain' id = 'chkmainId' onclick='CheckedAll(this);' type='CHECKBOX'></td>");
						 br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Issue Date</td>");
						 br.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>DWH Name</td>");
						 br.append("<td CLASS='multiRPTLabel' colspan='1' width='31%'>Drug Name</td>");
						 br.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Batch No.</td>");
						 br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Expiry Date</td>");
						 br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Receive Qty</td>");
						
						 br.append("</tr>");
						 br.append("<tr>");  
			           	 br.append("<td class='multiPOControl' colspan='10'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
			           	 br.append("</table>");
			           	
							
					   }
			} 
		    else
			{
					 
					 
		    	 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='#6097BC' cellpadding='1px'>");
				 br.append("<tr>");
				 br.append("<td CLASS='multiRPTLabel' colspan='1' width='5%'><input name='chkmain' onclick='CheckedAll(this);' type='CHECKBOX'></td>");
				 br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Issue Date</td>");
				 br.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>DWH Name</td>");
				 br.append("<td CLASS='multiRPTLabel' colspan='1' width='31%'>Drug Name</td>");
				 br.append("<td CLASS='multiRPTLabel' colspan='1' width='15%'>Batch No.</td>");
				 br.append("<td CLASS='multiRPTLabel' colspan='1' width='12%'>Expiry Date</td>");
				 br.append("<td CLASS='multiRPTLabel' colspan='1' width='10%'>Receive Qty</td>");
				
				 br.append("</tr>");
				 br.append("<tr>");  
	           	 br.append("<td class='multiPOControl' colspan='10'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
	           	 br.append("</table>");
		          	
						
			}
	     }
		
	catch (Exception e) {	
		 
			e.printStackTrace();	
		throw new Exception("getIssueDrugDtlsHlp.getIssueDrugDtlsHlp()->"+e.getMessage());
		}
		return br.toString();
	}

	
	
	public static String getViewSampleReceiveDetailsHlp(
			SampleReceiveDetailProcessTransVO vo) throws Exception {
		
		StringBuffer sb = new StringBuffer("");
		int start = 1;
		final int REC_PER_PAGE = 100;
		final int PAGE_PER_BLOCK = 100;
		int count=0;
		
		MmsConfigUtil mcu = null;
		WebRowSet ws = null;
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		
	    try
	    {
	    	mcu = new MmsConfigUtil(vo.getStrHospitalCode());
	    	ws = vo.getWrsViewSampleReceiveDetail();
	    	sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
	    	sb.append("<tr><td colspan='4' width='100%' class='TITLE'>Sample Receive Details</td></tr></table>");
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

//			 for (int i = 1; i <= totalLayer; i++)
//			 {
//				sb.append("<a STYLE='cursor:pointer;cursor:pointer;' color:'blue' onClick='GetIndex(\"").append(i).append("\",\"").append(totalLayer).append("\")'>" ).append( (i+start-1)
//						).append( "</a> &nbsp;");
//			 }
			 
			 for (int i = 1; i <= totalLayer; i++)
			 {
				sb.append("<a name='pg' id='pg" + i + "'  STYLE='cursor:pointer;cursor:pointer;' class='pg-normal' title='Record Indexing' onClick='GetIndex(\""+i+"\",\""+totalLayer+"\")'>" + (i+start-1)
						+ "</a>|&nbsp;");
			 }
			sb.append("</td>");
			sb.append("</tr>");
		//	sb.append("<tr><td class='LABEL'><div id='pageNavPosition'></div></td></tr>");
			sb.append("</table>");
			/*
			 * 	 br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Issue Date</td>");
						 br.append("<td CLASS='multiLabel' colspan='1' width='15%'>DWH Name</td>");
						 br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Drug Name</td>");
						 br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Batch No.</td>");
						 br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Expiry Date</td>");
						 br.append("<td CLASS='multiLabel' colspan='1' width='15%'>Receive Qty</td>");
			 */
			sb.append("<table class='TABLEWIDTH' align='center'cellpadding='1px' cellspacing='1px' bgcolor='#6097BC'>");
			sb.append("<tr>");
	        sb.append("<td width='10%'class='multiRPTLabel'>Receive Date</td>");
		    sb.append("<td width='10%'class='multiRPTLabel'>DDW Name</td>");
	        sb.append("<td width='25%'class='multiRPTLabel'>Drug Name</td>");
	        sb.append("<td width='12%'class='multiRPTLabel'>Batch No.</td>");
	        sb.append("<td width='11%'class='multiRPTLabel'>Mfg Date</td>");
		    sb.append("<td width='8%'class='multiRPTLabel'>Expiry Date</td>");
		    sb.append("<td width='8%'class='multiRPTLabel'>Issue Qty</td>");
		    sb.append("<td width='8%'class='multiRPTLabel'>Bkg.Qty</td>");
		    sb.append("<td width='8%'class='multiRPTLabel'>Rec.Qty</td>");
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
					  /* Value Pass in Web Row Set
					1.  receiveDate, 
					2.  storeName,
					3.  itemName,
					4.  batch no
					5.  mfgDate,
					6.  expiryDate,
					7.  issueQty,
					8.  HSTNUM_QC_ISSUE_NO, 
					9.  HSTNUM_ITEMBRAND_ID, 
					10.  HSTSTR_ITEM_SL_NO, 
					11. HSTNUM_STOCK_STATUS_CODE,
					12. HSTNUM_TOSTORE_ID, 
					13. HSTNUM_INHAND_QTY, 
					14. HSTNUM_INHANDQTY_UNITID, 
					15. HSTNUM_RATE, 
					16. HSTNUM_RATE_UNITID, 
					17. HSTNUM_SUPPLIER_ID, 
					18. HSTNUM_MFG_ID, 
					19. HSTSTR_PO_NO, 
					20. HSTDT_PO_DATE, 
					21. HSTDT_RECEIVE_DATE, 
					22. HSTNUM_IS_REISSUE, 
					23. GSTR_REMARKS, 
					24. HSTDT_FINANCIAL_START_DATE, 
					25. HSTDT_FINANCIAL_END_DATE, 
					26. GDT_ENTRY_DATE, 
					27. GNUM_SEATID, 
					28. GNUM_ISVALID
					29. Item ID
					30. Issue Date
					31. Received Qty
					32. Breakage Qty 								  	
                     */
					if(ws.next())
					{
						String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+vo.getStrDrugWareHouseId()+"^"+vo.getStrItemCategoryNo();
						String strPrintLabelValue = ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(6)+"^"+ws.getString(5)+"^"+ws.getString(22);
					
					sb.append("<tr>");
					sb.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					sb.append("<input type='hidden' name='strPrintLabelValue' id='strPrintLabelValue"+count+"' value='"+strPrintLabelValue+"'>");
					sb.append("<td class='multiPOControl' width='10%'>");
					sb.append(ws.getString(1));
					sb.append("</td>");
					sb.append("<td class='multiPOControl' width='10%'>");
					sb.append(ws.getString(2));
					sb.append("</td>");
					sb.append("<td class='multiPOControl' width='25%' style='text-align:left;'>");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strDrugName' id='strDrugName"+count+"' onClick='drugDtl(this,\""+count+"\");'>"+ws.getString(3)+"</a> &nbsp;");
					sb.append("</td>");
					sb.append("<td class='multiPOControl' width='12%'>");
					sb.append(ws.getString(4));
					sb.append("</td>");
					sb.append("<td class='multiPOControl' width='11%'>");
					sb.append(ws.getString(5));
					sb.append("</td>");
					sb.append("<td class='multiPOControl' width='8%'>");
					sb.append(ws.getString(6));
					sb.append("</td>");
					sb.append("<td width='8%'class='multiPOControl'>");
					sb.append(ws.getString(7));
				    sb.append("</td>");
				    sb.append("<td width='8%'class='multiPOControl'>");
					sb.append(ws.getString(32));
				    sb.append("</td>");
				    sb.append("<td width='8%'class='multiPOControl'>");
					sb.append(ws.getString(31));
				    sb.append("</td>");
					sb.append("</tr>");
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
				
				sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='#6097BC' cellpadding='1px'>");
				for (int k = 0; k < reminder; k++) 
				{
					ws.next();
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+vo.getStrDrugWareHouseId()+"^"+vo.getStrItemCategoryNo();
					String strPrintLabelValue = ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(6)+"^"+ws.getString(5)+"^"+ws.getString(22);
					sb.append("<tr>");
					sb.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					sb.append("<input type='hidden' name='strPrintLabelValue' id='strPrintLabelValue"+count+"' value='"+strPrintLabelValue+"'>");
					sb.append("<td class='multiPOControl' width='10%'>");
					sb.append(ws.getString(1));
					sb.append("</td>");
					sb.append("<td class='multiPOControl' width='10%'>");
					sb.append(ws.getString(2));
					sb.append("</td>");
					sb.append("<td class='multiPOControl' width='25%' style='text-align:left;'>");
					sb.append("<a STYLE='cursor:pointer;cursor:hand;color:blue' name='strDrugName' id='strDrugName"+count+"' onClick='drugDtl(this,\""+count+"\");'>"+ws.getString(3)+"</a> &nbsp;");
					sb.append("</td>");
					sb.append("<td class='multiPOControl' width='12%'>");
					sb.append(ws.getString(4));
					sb.append("</td>");
					sb.append("<td class='multiPOControl' width='11%'>");
					sb.append(ws.getString(5));
					sb.append("</td>");
					sb.append("<td class='multiPOControl' width='8%'>");
					sb.append(ws.getString(6));
					sb.append("</td>");
					sb.append("<td width='8%'class='multiPOControl'>");
					sb.append(ws.getString(7));
				    sb.append("</td>");
				    sb.append("<td width='8%'class='multiPOControl'>");
					sb.append(ws.getString(32));
				    sb.append("</td>");
				    sb.append("<td width='8%'class='multiPOControl'>");
					sb.append(ws.getString(31));
				    sb.append("</td>");
					sb.append("</tr>");
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
			sb.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' bgcolor='#6097BC' cellpadding='1px'>");
			sb.append("<tr>");
			sb.append("<td class='multiPOControl'><font color='red'>No Record Found</font></td>");
			sb.append("</tr>");
			sb.append("</table>");
		}
	   } 
		
	 }
	 catch(Exception e)
	 {
		    e.printStackTrace();
		    new HisException("Sample Receive Detail Process","SampleReceiveDetailProcessTransHLP.getViewSampleReceiveDetailsHlp()-->",e.getMessage());
	 }
	     //System.out.println("sb"+sb);
     return sb.toString();
   }


	
	/////////////////////
	public static String getViewSampleReceiveDetailsHlpPrint(SampleReceiveDetailProcessTransVO vo) throws Exception 
	{
		
		StringBuffer br = new StringBuffer();
		int count = 0;
		int start = 1;
		final int REC_PER_PAGE = 100;
		final int PAGE_PER_BLOCK = 100;
		String strTableWidth = "800";
		int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
		int totalRecordsToManipulate = totalFetchRecord - 1;
		WebRowSet ws =null;
		
		try
	    {			
			ws= vo.getWrsViewSampleReceiveDetail();
					
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
				
					br.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
					br.append("<tr><td width='8%'>&nbsp;</td> ");
					br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");
		//			br.append(res.getString("REPORT_TITLE"));
		//			System.out.println("ws.getString(4)"+ws.getString(4));
					if(ws.next())
						
					br.append("Sample Receive Detail [View]");
					
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
					br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='3'> ");
					br.append("For DDW Name: "+vo.getStrDrugWareHouseName()+"<br><br>");
					br.append("For Item Name: "+"Drug");  		//to work on
					br.append("</font></b></td><td width='10%'>&nbsp; ");
					br.append("</td> ");
					br.append("</tr> ");
					br.append("<tr> ");
					br.append("<td width='8%'>&nbsp;</td> ");
					br.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
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
					
					
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Receive Date</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>DDW Name</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='27%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Mfg Date</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Issue Qty</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Bkg Qty</b></font></td>");
					br.append("<td style=\"text-align: center;\" colspan='1' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rec. Qty</b></font></td>");
					
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
						
						br.append("<table align='center' cellspacing='1px'>");
						
						ws.beforeFirst();
						for (int j = 0; j < REC_PER_PAGE; j++) 
						{
							if(ws.next())
							{
							  /* Value Pass in Web Row Set
								1.  receiveDate, 
								2.  storeName,
								3.  itemName,
								4.  batch no
								5.  mfgDate,
								6.  expiryDate,
								7.  issueQty,
								8.  HSTNUM_QC_ISSUE_NO, 
								9.  HSTNUM_ITEMBRAND_ID, 
								10.  HSTSTR_ITEM_SL_NO, 
								11. HSTNUM_STOCK_STATUS_CODE,
								12. HSTNUM_TOSTORE_ID, 
								13. HSTNUM_INHAND_QTY, 
								14. HSTNUM_INHANDQTY_UNITID, 
								15. HSTNUM_RATE, 
								16. HSTNUM_RATE_UNITID, 
								17. HSTNUM_SUPPLIER_ID, 
								18. HSTNUM_MFG_ID, 
								19. HSTSTR_PO_NO, 
								20. HSTDT_PO_DATE, 
								21. HSTDT_RECEIVE_DATE, 
								22. HSTNUM_IS_REISSUE, 
								23. GSTR_REMARKS, 
								24. HSTDT_FINANCIAL_START_DATE, 
								25. HSTDT_FINANCIAL_END_DATE, 
								26. GDT_ENTRY_DATE, 
								27. GNUM_SEATID, 
								28. GNUM_ISVALID
								29. Item ID
								30. Issue Date
								31. Received Qty
								32. Breakage Qty 								  	
		                         */

																				
								br.append("<tr>");
								
								/////
								
								String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+"^"+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+"^"+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+vo.getStrDrugWareHouseId()+"^"+vo.getStrItemCategoryNo();
								
								
								
								br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(1)+"</td>");
								br.append("<td style=\"text-align: left;\"    colspan='1' width='15%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(2)+"</td>");
								br.append("<td style=\"text-align: left;\"    colspan='1' width='27%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(3)+"</td>");
								br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(4)+"</td>");
								br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(5)+"</td>");
								br.append("<td style=\"text-align: center;\"  colspan='1' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(6)+"</td>");
								br.append("<td style=\"text-align: center;\"  colspan='1' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(7)+"</td>");
								br.append("<td style=\"text-align: center;\"  colspan='1' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(32)+"</td>");
								br.append("<td style=\"text-align: center;\"  colspan='1' width='7%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+ws.getString(31)+"</td>");
							
								
								br.append("</tr>");
								br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
								
								
							}else{
								break;
							}
						}
							br.append("</table>");
							br.append("</div>");
		
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
						
						br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Receive Date</b></font></td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='10%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>DDW Name</b></font></td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='25%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Drug Name</b></font></td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='12%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Batch No.</b></font></td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='11%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Mfg Date</b></font></td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Expiry Date</b></font></td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Receive Qty</b></font></td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Bkg Qty</b></font></td>");
						br.append("<td style=\"text-align: center;\"  colspan='1' width='8%'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Rec. Qty</b></font></td>");

						 br.append("</tr>");
						 br.append("<tr>");  
			           	 br.append("<td class='multiControl' colspan='9'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
			           	 br.append("</table>");
			           	 
							
					   }
					} 
	     }
		
	catch (Exception e)
	{			 
		e.printStackTrace();
			throw new Exception("SupplierPerformanceDtailRptHLP.getSupplierPerformabceDetailsPopUp1()->"+e.getMessage());
		}
		return br.toString();
	}
}
