package mms.reports.controller.hlp;

import hisglobal.utility.HisUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.sql.rowset.WebRowSet;

public class DebtorRegisterRptHLP 
{
	public static String getIssuedStoreDetails(WebRowSet ws) throws Exception 
	{
	
	StringBuffer br = new StringBuffer();
	int count = 0;
	int start = 1;
	final int REC_PER_PAGE = 1000;
	final int PAGE_PER_BLOCK = 1000;
	double cltamt  = 0.00;
	double totalCost = 0.00;
	String strItemTotCost="0.00";
	
	int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
	int totalRecordsToManipulate = totalFetchRecord - 1;
	HisUtil util = new HisUtil("",""); 
	try
    {
		
		br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
	 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Consolidated Issue Details</td></tr></table>");	
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
			
			br.append("<td CLASS='multiLabel' colspan='1' width='15%'></td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='45%'>Name Of Unit</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='45%'>Value</td>");
			
			
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
			    	   1. Issue no
			    	   2. Issue Date
		               3. Unit Name
		               4. Indent No
		               5. Indent Date
		               6. Total Value 
		               7. Store ID
		           	 */    	 	
					
											
					String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7);		
					
					br.append("<tr>");
					br.append("<input type='hidden' name='demandFlg'  value='1'>");
					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
					br.append("<td class='multiControl' colspan='1' width='15%'>");
					br.append("<input type='radio' name='checkid' id='checkid"+count+"' value='0' onClick='chkBoxClick(this,\""+count+"\");'> </td>");
					
					
					
					br.append("<td class='multiControl' colspan='1' width='45%'>"+ws.getString(3)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='45%'>"+ws.getString(6)+"</td>");
					
					
					
					
					br.append("</tr>");
					
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(6)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					
					totalCost = totalCost + cltamt;
					
					
					count++ ;
				}else{
					break;
				}
			}
				br.append("</table>");
				String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
				
				String amtStr1 = "(" + util.toInitCap( util.getAmountStr(formatter.format(totalCost))) + ")";
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				br.append("<tr>");
				br.append("<td colspan='7' class='multiLabel' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalCost);				
				br.append("</font></td>");
				br.append("</tr>");
				
				
				br.append("<tr>");

				br.append("<td align='center' colspan='7' class='multiLabel' width='37%'><font face='Verdana, Arial, Helvetica, sans-serif' >Total Cost(Words)</font></td>");
				br.append("<td class='multiControl' colspan='1' style=\"text-align:right;\" width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+amtStr1+"</font></td>");
				br.append("</tr>");
				
				
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
		    	   1. Issue no
		    	   2. Issue Date
	               3. Unit Name
	               4. Indent No
	               5. Indent Date
	               6. Total Value 
	               7.Store ID
	           	 */    	 	
				
				String strCheckHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7);					
				
				br.append("<tr>");
				br.append("<input type='hidden' name='demandFlg'  value='1'>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strCheckHidValue+"'>");
				br.append("<td class='multiControl' colspan='1' width='15%'>");
				br.append("<input type='radio' name='checkid' id='checkid"+count+"' value='0' onClick='chkBoxClick(this,\""+count+"\");'> </td>");
				
				
				br.append("<td class='multiControl' colspan='1' width='45%'>"+ws.getString(3)+"</td>");
				br.append("<td class='multiControl' colspan='1' width='45%'>"+ws.getString(6)+"</td>");
				
				br.append("</tr>");
				
				
				strItemTotCost = formatter.format(new BigDecimal(ws.getString(6)));  
				cltamt  = Double.parseDouble(strItemTotCost);
				
				totalCost = totalCost + cltamt;
				count++ ;
			}
			br.append("</table>");
						
			String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			br.append("<tr>");
			br.append("<td colspan='7' align='left' class='multiLabel'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
			br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
			br.append(FinaltotalCost);				
			br.append("</font></td>");
			br.append("</tr>");
			br.append("</table>");
			
			br.append("</div>");
			}
	   	}
		  br.append("</div>");
		}
		else
		{
			 
			 br.append("<div id='prevTechEntryDtlId' style='display:block;'>");
			 br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			 br.append("<tr>");
			    
			    br.append("<td CLASS='multiLabel' colspan='1' width='15%'></td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='45%'>Name Of Unit</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='45%'>Value</td>");
				
			 
			 br.append("</tr>");
			 br.append("<input type='hidden' name='demandFlg'  value='0'>");
           	 br.append("<tr>");  
           	 br.append("<td class='multiControl' colspan='6'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
           	 br.append("</table>");
           	 br.append("</div>");
				
		   }
		} 
     }
	
catch (Exception e) {	
	 
		throw new Exception("OffLineIssueIndentTransHLP.getPODetails()->"+e.getMessage());
	}
	return br.toString();
}

public static String getIssuedDrugDetails(WebRowSet ws) throws Exception 
{
	
	StringBuffer br = new StringBuffer();
	int count = 0;
	int start = 1;
	final int REC_PER_PAGE = 1000;
	final int PAGE_PER_BLOCK = 1000;
	double cltamt  = 0.00;
	double totalCost = 0.00;
	String strItemTotCost="0.00";
	
	int totalFetchRecord = (REC_PER_PAGE * PAGE_PER_BLOCK) + 1;
	int totalRecordsToManipulate = totalFetchRecord - 1;
	HisUtil util = new HisUtil("",""); 
	try
    {			
		
		br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
	 	br.append("<tr><td colspan='4' width='100%' class='TITLE'>Challan Consolidated Details</td></tr></table>");	
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
			
			br.append("<td CLASS='multiLabel' colspan='1' width='10%'></td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='45%'>Drug Name</td>");
			br.append("<td CLASS='multiLabel' colspan='1' width='45%'>Value</td>");				
			
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
			    	   1. Issue No
			    	   2. Issue Date  
		               3. Store Name Issue To,
		               4. Store Name 
		               5. Genric Item
		               6. Item Brand 
		               7. Batch No 
		               8. Exp
		               9. Rate
		               10.Issue Qty
		               11. Store ID
		               12.Item Id
		               13.Item Brand Id
		               14.Batch Sl No
		               15.Exp Date
		               16.Rate
		               17.Rate Unit Id
		               18.Rate Base Value
		               19.Issue Qty
		               20.Issue Qty Unit Id
		               21.Qty Base Value
		               22.Item Sl No
		               23.Item Sl No
		               24.Catg Code
		               25.Balance Qty
		               26.Remrkas
		               27.Recevide By
		               28.Issue By
		               29.Final remarks
		               30.Cost
		               31.Avl Budget 
		               */    	 	
											
					String strChallanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31);
					
					br.append("<tr>");
					br.append("<input type='hidden' name='demandFlg'  value='1'>");
					br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strChallanHidValue+"'>");
								
					br.append("<td class='multiControl' colspan='1' width='10%'></td>");
					br.append("<td class='multiControl' colspan='1' width='45%'>"+ws.getString(6)+"</td>");
					br.append("<td class='multiControl' colspan='1' width='45%'>"+ws.getString(30)+"</td>");
					
					
					
					br.append("</tr>");
					
					strItemTotCost = formatter.format(new BigDecimal(ws.getString(30)));  
					cltamt  = Double.parseDouble(strItemTotCost);
					
					totalCost = totalCost + cltamt;
					
					
					count++ ;
				}else{
					break;
				}
			}
				br.append("</table>");
				String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
				String amtStr1 = "(" + util.toInitCap( util.getAmountStr(formatter.format(totalCost))) + ")";
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
				br.append("<tr>");
				br.append("<td colspan='7' class='multiLabel' align='left'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
				br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
				br.append(FinaltotalCost);				
				br.append("</font></td>");
				br.append("</tr>");
				
				
				br.append("<tr>");
				br.append("<td align='center' colspan='7' class='multiLabel' width='37%'><font face='Verdana, Arial, Helvetica, sans-serif' >Total Cost(Words)</font></td>");
				br.append("<td class='multiControl' colspan='1' style=\"text-align:right;\" width='20%'><font face='Verdana, Arial, Helvetica, sans-serif' >"+amtStr1+"</font></td>");
				br.append("</tr>");
				
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
		    	   1. Issue No
		    	   2. Issue Date  
	               3. Store Name Issue To,
	               4. Store Name 
	               5. Genric Item
	               6. Item Brand 
	               7. Batch No 
	               8. Exp
	               9. Rate
	               10.Issue Qty
	               11. Store ID
	               12.Item Id
	               13.Item Brand Id
	               14.Batch Sl No
	               15.Exp Date
	               16.Rate
	               17.Rate Unit Id
	               18.Rate Base Value
	               19.Issue Qty
	               20.Issue Qty Unit Id
	               21.Qty Base Value
	               22.Item Sl No
	               23.Item Sl No
	               24.Catg Code
	               25.Balance Qty
	               26.Remrkas
	               27.Recevide By
	               28.Issue By
	               29.Final remarks
	               30.Cost
	               31.Avl Budget 
	              
		    	 */    	 
				String strChallanHidValue = ws.getString(1)+"^"+ws.getString(2)+"^"+ws.getString(3)+"^"+ws.getString(4)+"^"+ws.getString(5)+"^"+ws.getString(6)+"^"+ws.getString(7)+"^"+ws.getString(8)+"^"+ws.getString(9)+"^"+ws.getString(10)+ws.getString(11)+"^"+ws.getString(12)+"^"+ws.getString(13)+"^"+ws.getString(14)+"^"+ws.getString(15)+"^"+ws.getString(16)+"^"+ws.getString(17)+"^"+ws.getString(18)+"^"+ws.getString(19)+"^"+ws.getString(20)+ws.getString(21)+"^"+ws.getString(22)+"^"+ws.getString(23)+"^"+ws.getString(24)+"^"+ws.getString(25)+"^"+ws.getString(26)+"^"+ws.getString(27)+"^"+ws.getString(28)+"^"+ws.getString(29)+"^"+ws.getString(30)+"^"+ws.getString(31);
				
				br.append("<tr>");
				br.append("<input type='hidden' name='demandFlg'  value='1'>");
				br.append("<input type='hidden' name='strCheckHidValue' id='strCheckHidValue"+count+"' value='"+strChallanHidValue+"'>");
				
				
				br.append("<td class='multiControl' colspan='1' width='10%'></td>");
				br.append("<td class='multiControl' colspan='1' width='45%'>"+ws.getString(6)+"</td>");
				br.append("<td class='multiControl' colspan='1' width='45%'>"+ws.getString(30)+"</td>");
				
				
				br.append("</tr>");
				
				
				strItemTotCost = formatter.format(new BigDecimal(ws.getString(30)));  
				cltamt  = Double.parseDouble(strItemTotCost);
				
				totalCost = totalCost + cltamt;
				count++ ;
			}
			br.append("</table>");
						
			String FinaltotalCost = formatter.format(new BigDecimal(totalCost));  
			br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px'>");
			br.append("<tr>");
			br.append("<td colspan='7' align='left' class='multiLabel'><font face='Verdana, Arial, Helvetica, sans-serif' ><b>Total Cost(Rs.)</b></font></td>");
			br.append("<td colspan='1' class='multiControl' style='font-weight: bold' align='center'><font face='Verdana, Arial, Helvetica, sans-serif' >");
			br.append(FinaltotalCost);				
			br.append("</font></td>");
			br.append("</tr>");
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
			 
			 br.append("<td CLASS='multiLabel' colspan='1' width='10%'></td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='45%'>Drug Name</td>");
				br.append("<td CLASS='multiLabel' colspan='1' width='45%'>Value</td>");			
			 
			 br.append("</tr>");
			 br.append("<input type='hidden' name='demandFlg'  value='0'>");
           	 br.append("<tr>");  
           	 br.append("<td class='multiControl' colspan='7'><font color='red'><b>No Detail(s) Available</b></font></td></tr>");
           	 br.append("</table>");
           	 
				
		   }
		} 
     }
	
catch (Exception e)
{			 
	e.printStackTrace();
		throw new Exception("OffLineIssueIndentTransHLP.getPODetails()->"+e.getMessage());
	}
	return br.toString();
}


}
