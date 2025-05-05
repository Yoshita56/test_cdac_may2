package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.SupplierReturnModifyTransVO;

/**
 * 
 * @author dell
 *
 */
public class SupplierReturnModifyTransHLP {
	
	public static String getItemDetails(SupplierReturnModifyTransVO voObj)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		int issueStatus=0;
		float cost=0;
		 try {
			 WebRowSet wb=voObj.getStrItemDetailsWS();
			 if(wb.size() != 0)
			 { 
				sBuffer.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px' bgcolor='#6097BC'>");
				while(wb.next())
				{		     
					    voObj.setStrGroupName(wb.getString(8));
					    voObj.setStrRemarks(wb.getString(20));
					    sBuffer.append("<tr>");
	  					sBuffer.append("<td width='15%' colspan='1' class='multiControl'>"+wb.getString(2)+"</td>");
	  					sBuffer.append("<td width='15%' colspan='1' class='multiControl'>"+wb.getString(3)+"</td>");
	  					sBuffer.append("<td width='15%' colspan='1' class='multiControl'>"+wb.getString(17)+"/"+wb.getString(18)+"</td>");
	  					sBuffer.append("<td width='15%' colspan='1' class='multiControl'>"+wb.getString(15)+" "+wb.getString(16)+"</td>");
	  					sBuffer.append("<td width='15%' colspan='1' class='multiControl'>"+wb.getString(4)+" "+wb.getString(12)+"</td>");
	  					sBuffer.append("<td width='15%' colspan='1' class='multiControl'>"+wb.getString(6)+" "+wb.getString(13)+"</td>");
	  					sBuffer.append("<td width='10%' colspan='1' class='multiControl'>"+wb.getString(19)+"</td>");
	  					cost=cost+Float.parseFloat(wb.getString(19));
	  					if(Integer.parseInt(wb.getString(6))>Integer.parseInt(wb.getString(15)))
	  					{
	  					   issueStatus=issueStatus+1;
	  					}   
	  					sBuffer.append("</tr>");	
	  			}
				sBuffer.append("</table>");
				sBuffer.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				sBuffer.append("<tr>");
				sBuffer.append("<td class='LABEL' colspan='6' width='90%'>Total Return Cost</td>");
				sBuffer.append("<td class='multiControl' colspan='1' width='10%'>");
				sBuffer.append("<div id='strTotalReturnCostDivId' style='color: red;font-weight:bold'>"+cost+"</div>");
				sBuffer.append("</td>");
				sBuffer.append("</tr>");	
               sBuffer.append("</table>");
               sBuffer.append("<input type='hidden' name='issueStatus' value='"+issueStatus+"'>");
               voObj.setStrTotalReturnCost(String.valueOf(cost));
               
	     }else {
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0'  cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td colspan='7'  CLASS='multiControl' >"
						+ "<div class='errMsg' align='center'> NO RECORD FOUND </div>" + "</td>");

			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			 new HisException("Third Party Issue Transaction","SupplierReturnSancTransHLP.getItemDetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
	

}



