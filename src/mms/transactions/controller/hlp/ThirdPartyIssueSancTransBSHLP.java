package mms.transactions.controller.hlp;

import java.math.BigDecimal;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

import mms.transactions.vo.ThirdPartyIssueSancTransVO;

/**
 * 
 * @author dell
 *
 */
public class ThirdPartyIssueSancTransBSHLP {
	
	
	public static String getItemDetails(ThirdPartyIssueSancTransVO voObj)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		int issueStatus=0;
		 try {
			 WebRowSet wb=voObj.getStrItemDetailsWS();
			 if(wb.size() != 0)
			 { 
				sBuffer.append("<table class='table'>");
				while(wb.next())
				{		     
					    voObj.setStrGroupName(wb.getString(8));
					    sBuffer.append("<tbody>");
	  					sBuffer.append("<td width='25%' align='left'style='font-weight:350 !important ;font-size: 16px !important;'>"+wb.getString(2)+"</td>");
	  					sBuffer.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;' >"+wb.getString(3)+"</td>");
	  					sBuffer.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+wb.getString(14)+"</td>");
	  					sBuffer.append("<td width='15%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+wb.getString(15)+" "+wb.getString(16)+"</td>");
	  					sBuffer.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+wb.getString(4)+" "+wb.getString(12)+"</td>");
	  					sBuffer.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+wb.getString(6)+" "+wb.getString(13)+"</td>");
	  					if( Float.parseFloat(wb.getString(6))
	  							> Float.parseFloat(wb.getString(15)))
	  					{
	  					   sBuffer.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>-N/A-</td>");
	  					   issueStatus=issueStatus+1;
	  					}   
	  					else
	  					   sBuffer.append("<td width='10%' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"+wb.getString(6)+" "+wb.getString(13)+"</td>");	
	  					sBuffer.append("</tbody>");	
	  			}
                 sBuffer.append("</table>");
                 sBuffer.append("<input type='hidden' name='issueStatus' value='"+issueStatus+"'>");
                
	     }else {
			    sBuffer.append("<table class='table'>"); 
			    sBuffer.append("<tbody>");
			    sBuffer.append("<td colspan='7' align='center' style='font-weight:350 !important ;font-size: 16px !important;'>"
						+ "<div class='errMsg' align='center'> NO RECORD FOUND </div>" + "</td>");

			    sBuffer.append("</tbody>");
			    sBuffer.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			 new HisException("Third Party Issue Transaction","ThirdPartyIssueSancTransHLP.getItemDetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
	

}



