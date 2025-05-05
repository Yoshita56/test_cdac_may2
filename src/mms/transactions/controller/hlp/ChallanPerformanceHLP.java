package mms.transactions.controller.hlp;

import javax.sql.rowset.WebRowSet;
import hisglobal.utility.HisUtil;
public class ChallanPerformanceHLP 
{
	
	/**
	 * Gets the added Task details.
	 * 
	 * @param wb the wb
	 * 
	 * @return the added Task details
	 */
	public static String getChallanDtlHlp(WebRowSet wb) 
	{
		StringBuffer br = new StringBuffer();
		int i=0;
        try 
		{
			if (wb != null) 
			{
				if (wb.size() != 0) 
				{
					HisUtil hisutil = new HisUtil("MMS", "ChallanPerformanceHLP");  
					br.append("<table width='1200' align='center'  border='0' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr class='HEADER'>");
					br.append("<td  colspan='11' style=\"text-align:right;\">");
					br.append("ADD ROW'S::::::<input type='text' class='txtFldMin' name='strNoOfMultiRow' value ='' maxlength='100' onkeypress='if(event.keyCode==13) getMultiRow();'>");					
					//br.append("<img style='cursor: pointer; style=\'text-align:right;\'  title='Add Row' src='../../hisglobal/images/Go.png' onclick='getMultiRow();'/>");
					br.append("</td>");
					br.append("</tr>");					
					br.append("</table>");
					br.append("<table width='1200' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td WIDTH='12%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Received Date</td>");
					br.append("<td WIDTH='12%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Supplier Invoice No</td>");
					br.append("<td WIDTH='12%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Invoice Date</td>");
					br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'><font color='red'>*</font>Batch No</td>");
					br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'><font color='red'>*</font>Received Qty.</td>");
					br.append("<td WIDTH='10%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Whether Test Report Submitted</td>");
					br.append("<td WIDTH='10%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Whether Medicines/Packaging are in good condition</td>");
					br.append("<td WIDTH='9%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Whether Rajsthan Govt. Supply Not for Sale & Logogram printed</td>");
					br.append("<td WIDTH='9%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Brand Name Not Written</td>");
					br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'><font color='red'>*</font>Price(MRP) not printed/Visible</td>");					
					br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>#</td>");
					br.append("</tr> ");
					br.append("</table> ");
					br.append("<table width='1200' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
					
					while (wb.next())
					{ 						
						
						br.append("<TR>");
						br.append("<input type='hidden' name='strHiddenChallanNo'  value='"+wb.getString(7)+"' />");
						br.append("<input type='hidden' name='strHiddenChallanQty' value='"+wb.getString(5)+"' />");
						br.append("<input type='hidden' name='strHiddenPODate'     value='"+wb.getString(8)+"' />");
						br.append("<TD WIDTH='12%' colspan='1' CLASS='multiRPTControl'>"+HisUtil.getDatePicker("strMultiRowChallanReceiveDate",wb.getString(1),true)+"</TD>");
						br.append("<TD WIDTH='12%' colspan='1' CLASS='multiRPTControl'><input type='text' class='txtFldMax' maxlength='20' name='strMultiRowChallanNo' value ='"+wb.getString(2)+"' maxlength='100' onkeypress='return validateData(event,17);'></TD>");
						br.append("<TD WIDTH='12%' colspan='1' CLASS='multiRPTControl'>"+HisUtil.getDatePicker("strMultiRowInvoiceDate",wb.getString(3),true)+"</TD>");
						br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl'><input type='text' class='txtFldNormal' maxlength='25'  name='strMultiRowBatchNo' value ='"+wb.getString(4)+"' maxlength='100' onkeypress='return validateData(event,17);'></TD>");
						br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl'><input type='text' class='txtFldNormal' name='strMultiRowReceivedQty' onKeyUp='calQty();' value ='"+wb.getString(5)+"' maxlength='100' onkeypress='return validateData(event,5);'></TD>");
						if(wb.getString(6).split("\\^")[0].equals("1"))
						{	
						    br.append("<TD WIDTH='10%' colspan='1' CLASS='multiRPTControl'><select name='strMultiRowWhetherTestReportSubmitted' ><option value='1' selected='selected'>Yes</option><option value='2'>No</option></select></TD>");
						}
						else
						{
							br.append("<TD WIDTH='10%' colspan='1' CLASS='multiRPTControl'><select name='strMultiRowWhetherTestReportSubmitted' ><option value='1'>Yes</option><option value='2' selected='selected'>No</option></select></TD>");	
						}
						if(wb.getString(6).split("\\^")[1].equals("1"))
						{
						    br.append("<TD WIDTH='10%' colspan='1' CLASS='multiRPTControl'><select name='strMultiRowWhetherMedicinesInGoodCondition' ><option value='1' selected='selected'>Yes</option><option value='2'>No</option></select></TD>");
						}
						else
						{
							br.append("<TD WIDTH='10%' colspan='1' CLASS='multiRPTControl'><select name='strMultiRowWhetherMedicinesInGoodCondition' ><option value='1'>Yes</option><option value='2' selected='selected'>No</option></select></TD>");
						}
						if(wb.getString(6).split("\\^")[2].equals("1"))
						{
						   br.append("<TD WIDTH='9%' colspan='1' CLASS='multiRPTControl'><select name='strMultiRowWhetherSupplyNotForSale' ><option value='1' selected='selected'>Yes</option><option value='2'>No</option></select></TD>");
						}
						else
						{
						   br.append("<TD WIDTH='9%' colspan='1' CLASS='multiRPTControl'><select name='strMultiRowWhetherSupplyNotForSale' ><option value='1'>Yes</option><option value='2' selected='selected'>No</option></select></TD>");
						}
						if(wb.getString(6).split("\\^")[3].equals("1"))
						{
						   br.append("<TD WIDTH='9%' colspan='1' CLASS='multiRPTControl'><select name='strMultiRowWhetherBrandNameNotWritten' ><option value='1' selected='selected'>Yes</option><option value='2'>No</option></select></TD>");
						}
						else
						{
						  br.append("<TD WIDTH='9%' colspan='1' CLASS='multiRPTControl'><select name='strMultiRowWhetherBrandNameNotWritten' ><option value='1'>Yes</option><option value='2' selected='selected'>No</option></select></TD>");	
						}
						if(wb.getString(6).split("\\^")[4].equals("1"))
						{
						  br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl'><select name='strMultiRowWhetherMRPPrint' ><option value='1'selected='selected' >Yes</option><option value='2'>No</option></select></TD>");
						}
						else
						{
						  br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl'><select name='strMultiRowWhetherMRPPrint' ><option value='1'>Yes</option><option value='2' selected='selected'>No</option></select></TD>");	
						}
						br.append("<TD WIDTH='8%'  colspan='1' CLASS='multiRPTControl' >#</TD>");
						br.append("</TR>");
						i++; 					
					}					
					br.append("</table> ");

				}
				
				
			}
			 if(wb.size()==0)
			 {	 
				 br.append("<table width='1200' align='center'  border='0' cellspacing ='1px' cellpadding='1px'>");
				 br.append("<tr class='HEADER'>");
				 br.append("<td  colspan='11' style=\"text-align:right;\">");
				 br.append("ADD ROW'S::::::<input type='text' class='txtFldMin' name='strNoOfMultiRow' value ='' maxlength='100' onkeypress='if(event.keyCode==13) getMultiRow()();'>");					
					//br.append("<img style='cursor: pointer; style=\'text-align:right;\'  title='Add Row' src='../../hisglobal/images/Go.png' onclick='getMultiRow();'/>");
				 br.append("</td>");
				 br.append("</tr>");    
				 br.append("<tr> ");
				 br.append("</table> ");
				 br.append("<table width='1200' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
				 br.append("<td WIDTH='12%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Received Date</td>");
				 br.append("<td WIDTH='12%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Supplier Invoice No</td>");
				 br.append("<td WIDTH='12%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Invoice Date</td>");
				 br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'><font color='red'>*</font>Batch No</td>");
				 br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'><font color='red'>*</font>Received Qty.</td>");
				 br.append("<td WIDTH='10%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Whether Test Report Submitted</td>");
				 br.append("<td WIDTH='10%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Whether Medicines/Packaging are in good condition</td>");
				 br.append("<td WIDTH='9%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Whether Rajsthan Govt. Supply Not for Sale & Logogram printed</td>");
				 br.append("<td WIDTH='9%' colspan='1' class='multiRPTLabel'><font color='red'>*</font>Brand Name Not Written</td>");
				 br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'><font color='red'>*</font>Price(MRP) not printed/Visible</td>");					
				 br.append("<td WIDTH='8%'  colspan='1' class='multiRPTLabel'>#</td>");
				 br.append("</tr> ");
				 br.append("</table> ");
				 br.append("<table width='1200' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
				 br.append("<TR>");
				 br.append("<td class='multiRPTControl' colspan='10'><b><div id='id' align='center' color='Red'>No Previous Challan Exists</div></b></td>");
				 br.append("</TR>");
				 br.append("</table> ");
			 }
		}
		catch (Exception e) 
		{
			

		}
		return br.toString();
	}

}
