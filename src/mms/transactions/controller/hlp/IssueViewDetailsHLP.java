package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;
import javax.sql.rowset.WebRowSet;

public class IssueViewDetailsHLP {
	
	/**
	 * Developer : Pramod Kumar Mehta 
	 * Version : 1.0 
	 * Date : 01/April/2009
	 *  Module:MMS
	 * Unit:Issue Details View
	 *
	 */
	
	public static String getItemDetails(WebRowSet wb)
	throws SQLException {
		StringBuffer br = new StringBuffer("");
		
		try {
			int i = 0;
			if(wb != null && wb.size() > 0)
			{
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px' cellpadding='1px' bgcolor='#6097BC'>");
				while (wb.next())
				{
						
					
					String strItemName = wb.getString(1);
					String strBrandName = wb.getString(2);
					String strRateUnit = wb.getString(3);
					String strReqQty = wb.getString(1);
					String strApproveQty = wb.getString(2);
					String strIssueQty = wb.getString(3);
					
					if(strItemName == null || strItemName.equals("null"))strItemName = "";
					if(strBrandName == null || strBrandName.equals("null"))strBrandName = "";
					if(strRateUnit == null || strRateUnit.equals("null"))strRateUnit = "";
					if(strReqQty == null || strReqQty.equals("null"))strReqQty = "";
					if(strApproveQty == null || strApproveQty.equals("null"))strApproveQty = "";
					if(strIssueQty == null || strIssueQty.equals("null"))strIssueQty = "";
				
					br.append("<tr>");
					br.append("<input type='hidden' name='strApprovedDtl' id='strApprovedDtl"+i+"' >");
					
					br.append("<input type='hidden' name='strApproveQty' id='strApproveQty"+i+"' value='"+strApproveQty+"' >");
					
					br.append("<td width='20%' class='multiControl'>"+strItemName+"</td>");
					br.append("<td width='20%' class='multiControl'>"+strBrandName+"</td>");
					br.append("<td width='15%' class='multiControl'>"+strRateUnit+"</td>");
					br.append("<td width='15%' class='multiControl'>"+strReqQty+"</td>");
					
					//System.out.println("strApproveQty"+strApproveQty);
					br.append("<td width='15%' class='multiControl'><a name='strApprovedQuantity' id='strApprovedQuantity"+i+"' STYLE='CURSOR:POINTER;color:blue' title='"+ strApproveQty+"'  onClick='approvalDtl(this,\"" + i + "\");'>" +strApproveQty+"</a></td>");
						
					br.append("<td width='15%' class='multiControl'>"+strIssueQty+"</td>");
								
					br.append("</tr>");	
					
					i++;
				}
				

				br.append("</table>");
			}else {
				    br.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
				    br.append("<tr>");
				    br.append("<td CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED ISSUE NO. </div>" + "</TD>");

				    br.append("</tr>");
				    br.append("</table>");
					
			   } 
		}catch(Exception e){
			
			throw new HisException("Item View Transaction","IndentViewTransHLP.getItemDetails()-->",e.getMessage());
		}
	
		return br.toString();
		}
	}
