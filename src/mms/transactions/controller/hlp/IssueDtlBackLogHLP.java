package mms.transactions.controller.hlp;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import mms.transactions.bo.IssueDtlBackLogBO;
import mms.transactions.vo.IssueDtlBackLogVO;

public class IssueDtlBackLogHLP 
{
	/**
	 * Gets the added Task details.
	 * 
	 * @param wb the wb
	 * 
	 * @return the added Task details
	 */
	public static String getVoucherDtlHlp(WebRowSet wb,IssueDtlBackLogVO vo) 
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
					br.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr class='HEADER'>");
					br.append("<td  colspan='5' style=\"text-align:right;\">");
					br.append("ADD ROW'S::::::<input type='text' class='txtFldMin' name='strNoOfMultiRow' value ='' maxlength='100' onkeypress='return validateData(event,5);' onkeyup='if(event.keyCode==13) getMultiRow();'>");					
					
					br.append("</td>");
					br.append("</tr>");					
					br.append("</table>");
					br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
					br.append("<tr>");
					br.append("<td WIDTH='40%' colspan='1' class='multiLabel'><font color='red'>*</font>Drug Name</td>");
					br.append("<td WIDTH='20%' colspan='1' class='multiLabel'><font color='red'>*</font>Batch No</td>");
					br.append("<td WIDTH='15%' colspan='1' class='multiLabel'><font color='red'>*</font>Issue Quantity</td>");
					br.append("<td WIDTH='15%' colspan='1' class='multiLabel'><font color='red'>*</font>Unit</td>");
					br.append("<td WIDTH='5%'  colspan='1' class='multiLabel'>#</td>");
					br.append("</tr> ");
					br.append("</table> ");
					br.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px' >");
					
					while (wb.next())
					{ 					
						
						/*
						 * 1.Item Brand Id
						 * 2.Item Name
						 * 3.Batch No
						 * 4.Issue Qty
						 * 5.Unit Name
						 * 6.Issue Date
						 * 7.Indent No
						 * 8.Indent Date
						 * */	
						
						br.append("<TR>");
						
						br.append("<input type='hidden' name='strDrugId' value='"+wb.getString(1)+"' />");												
						br.append("<input type='hidden' name='strOldBatchNo' value='"+wb.getString(3)+"' />");	
						br.append("<input type='hidden' name='strOldIssueQty' value='"+wb.getString(4)+"' />");
						br.append("<input type='hidden' name='strUnitId' value='1' />");
						
						vo.setStrBatchNumber(wb.getString(3));
						vo.setStrItemBrandId(wb.getString(1));
						IssueDtlBackLogBO.BatchCombo(vo);
								
						br.append("<TD WIDTH='40%'  colspan='1' style=\'text-align:left;\' CLASS='multiControl'>"+wb.getString(2)+"</TD>");
						br.append("<TD WIDTH='20%'  colspan='1' CLASS='multiControl'><select name='strBatchNo' class='comboMax'>'"+vo.getStrBatchCombo()+"'</select>");
						br.append("<TD WIDTH='15%'  colspan='1' CLASS='multiControl'><input type='text'  name='strIssueQty'  value ='"+wb.getString(4)+"' maxlength='100' onkeypress='return validateData(event,5);'></TD>");
						br.append("<TD WIDTH='15%'  colspan='1' CLASS='multiControl'>"+wb.getString(5)+"</TD>");
						br.append("<TD WIDTH='5%'   colspan='1' CLASS='multiControl' >#</TD>");
						br.append("</TR>");
						i++; 					
					}					
					br.append("</table> ");
						
				}
				
				
			}
			 if(wb.size()==0)
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
					br.append("<td WIDTH='40%' colspan='1' class='multiLabel'><font color='red'>*</font>Drug Name</td>");
					br.append("<td WIDTH='20%' colspan='1' class='multiLabel'><font color='red'>*</font>Batch No</td>");
					br.append("<td WIDTH='15%' colspan='1' class='multiLabel'><font color='red'>*</font>Issue Quantity</td>");
					br.append("<td WIDTH='15%' colspan='1' class='multiLabel'><font color='red'>*</font>Unit</td>");
					br.append("<td WIDTH='5%'  colspan='1' class='multiLabel'>#</td>");
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
	}
	
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
					br.append("<td WIDTH='40%' colspan='1' class='multiLabel'><font color='red'>*</font>Drug Name</td>");
					br.append("<td WIDTH='20%' colspan='1' class='multiLabel'><font color='red'>*</font>Batch No</td>");
					br.append("<td WIDTH='15%' colspan='1' class='multiLabel'><font color='red'>*</font>Issue Quantity</td>");
					br.append("<td WIDTH='15%' colspan='1' class='multiLabel'><font color='red'>*</font>Unit</td>");
					br.append("<td WIDTH='5%'  colspan='1' class='multiLabel'>#</td>");
					br.append("</tr> ");
					br.append("</table> ");
				
		
		}
		catch (Exception e) 
		{
			

		}
		return br.toString();
	}

}
