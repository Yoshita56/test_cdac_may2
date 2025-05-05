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
public class ThirdPartyIssueSancTransHLP {
	
	
	public static String getItemDetails(ThirdPartyIssueSancTransVO voObj)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		int issueStatus=0;
		 try {
			 WebRowSet wb=voObj.getStrItemDetailsWS();
			 if(wb.size() != 0)
			 { 
				sBuffer.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				while(wb.next())
				{		     
					    voObj.setStrGroupName(wb.getString(8));
					    sBuffer.append("<tr>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+wb.getString(2)+"</td>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+wb.getString(3)+"</td>");
	  					sBuffer.append("<td width='10%' class='multiControl'>"+wb.getString(14)+"</td>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+wb.getString(15)+" "+wb.getString(16)+"</td>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+wb.getString(4)+" "+wb.getString(12)+"</td>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+wb.getString(6)+" "+wb.getString(13)+"</td>");
	  					if( Float.parseFloat(wb.getString(6))
	  							> Float.parseFloat(wb.getString(15)))
	  					{
	  					   sBuffer.append("<td width='15%' class='multiControl'>-N/A-</td>");
	  					   issueStatus=issueStatus+1;
	  					}   
	  					else
	  					   sBuffer.append("<td width='15%' class='multiControl'>"+wb.getString(6)+" "+wb.getString(13)+"</td>");	
	  					sBuffer.append("</tr>");	
	  			}
                 sBuffer.append("</table>");
                 sBuffer.append("<input type='hidden' name='issueStatus' value='"+issueStatus+"'>");
                
	     }else {
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td colspan='7'  CLASS='multiControl' >"
						+ "<div class='errMsg' align='center'> NO RECORD FOUND </div>" + "</td>");

			    sBuffer.append("</tr>");
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



