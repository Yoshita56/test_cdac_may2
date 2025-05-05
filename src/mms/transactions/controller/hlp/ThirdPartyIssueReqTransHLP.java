package mms.transactions.controller.hlp;


/**
 * 
 * @author dell
 *
 */
public class ThirdPartyIssueReqTransHLP {
	
/*	
	public static String getItemDetails(ThirdPartyIssueReqTransVO voObj)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		String reqStatus="";
		String reqQty="";
		String sancQty="";
		String issueQty="";
		String expDt="";
		int count=0;
		 try {
			 WebRowSet wb=voObj.getStrItemCatWs();
			if(wb.size() != 0)
			{ 
				sBuffer.append("<table class='TABLEWIDTH' align='center' cellpadding='1px' cellspacing='1px'>");
				while(wb.next())
				{		     
	            count++;
	                    voObj.setStrGroupName(wb.getString(10));
	                    reqQty   = wb.getString(6);
	                    sancQty  = wb.getString(8);
	                    issueQty = wb.getString(11);
	                    expDt    = wb.getString(15);
	                    if(sancQty.trim().equals("0"))
	                    	sancQty="<font color='blue'>-N/A-</font>";
	                    else
	                    	sancQty=wb.getString(8)+" "+wb.getString(15);
	                    
	                    if(issueQty.trim().equals("0"))
	                    	issueQty="<font color='blue'>-N/A-</font>";
	                    else
	                    	issueQty=wb.getString(11)+" "+wb.getString(13);
	                    
	                    if(expDt.trim().equals("") || expDt.trim().equals("NULL"))
	                    	expDt="-N/A-";
	                    else
	                    	expDt=wb.getString(16);
	                    
	                    sBuffer.append("<tr>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+wb.getString(3)+"</td>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+wb.getString(4)+"</td>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+wb.getString(5)+"</td>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+wb.getString(6)+" "+wb.getString(14)+"</td>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+sancQty+"</td>");
	  					sBuffer.append("<td width='15%' class='multiControl'>"+issueQty+"</td>");
	  					sBuffer.append("<td width='10%' class='multiControl'>"+expDt+"</td>");
	  					sBuffer.append("</tr>");	
	  			}
				sBuffer.append("</table>");
				if(voObj.getStrReqStatus().trim().equals("1"))
				{
					reqStatus="Active";
				}
				else if(voObj.getStrReqStatus().trim().equals("2"))
				{
					reqStatus="Approved";
				}
				else
				{
					reqStatus="Issued";
				}
				 voObj.setStrReqStatus(reqStatus);
			 
	     }else {
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<div class='errMsg' align='center'> NO RECEIPT DETAILS FOUND FOR SELECTED PO NO. </div>" + "</td>");

			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			 new HisException("Third Party Issue Transaction","ThirdPartyIssueReqTransHLP.getItemDetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}*/
	

}



