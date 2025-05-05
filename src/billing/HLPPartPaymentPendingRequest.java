package billing;

import javax.sql.rowset.WebRowSet;

public class HLPPartPaymentPendingRequest
{
	public static String getPendingRequest(String strCrNo,String strHospCode) 
	{
	 BillingVO voObj = new BillingVO();
	 BillingBO boObj = new BillingBO();
	 StringBuffer sb = new StringBuffer("");
	 voObj.setStrValue1(strCrNo);
	 voObj.setStrValue2(strHospCode);
//	 int rowSize = 0;
	 try 
	 {
	    boObj.getPartPaymentPendingReq(voObj);  
        WebRowSet ws = voObj.getGblWs2();   
        if(voObj.getStrMsgType().equals("0"))
	    {
        	
        	 sb.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px'>"); 
			   sb.append("<tr><td width='17%' class='multiLabel'>ReqNo</td>");
			   sb.append("<td width='17%' class='multiLabel'>ReqDate</td>");
			   sb.append("<td width='11%' class='multiLabel'>RaisingWard</td>");    //New Vale Added 1/7/08
			   sb.append("<td width='15%' class='multiLabel'>PartPaymentAmt</td>");
			   sb.append("<td width='15%' class='multiLabel' style='display:none;'>ApprovedBy</td></tr></table>");
        	
		 if (ws != null && ws.size() > 0) 
		  { 
			  
		   
				//	rowSize = ws.size();
					String strApprovedBy = null;
					String strRasingWard = null;
					for(int i=0;ws.next();i++)
                    { 		
						strApprovedBy  = ws.getString(4);
					    strRasingWard  = ws.getString(5);
					  
     					if(strApprovedBy == null) strApprovedBy = "-----";
     				   	if(strRasingWard == null || strRasingWard.equals("")) strRasingWard = "-----";
     				   	
     				   sb.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px'>");									
						sb.append("<tr>");
						sb.append("<td width='17%' class='multiControl'>");
						sb.append(ws.getString(1));
						sb.append("</td>");
						sb.append("<td width='17%' class='multiControl'>");
						sb.append(ws.getString(2));
						sb.append("</td>");
						sb.append("<td width='11%' class='multiControl'>");
						sb.append(strRasingWard);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append(ws.getString(3));
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl' style='display:none;'>");
						sb.append(strApprovedBy);
						sb.append("</td></tr></table>");
					}
				//	sb.append("</table>");
				}
		    else
		    {
			    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
				sb.append("<tr>");
				sb.append("<td colspan='5'  CLASS='multiControl' >"
						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED CR NO </div>" + "</TD>");

				sb.append("</tr>");
				sb.append("</table></div>");
				
		     } 
	       }
		   else
		   {	  
			String err = voObj.getStrMsgString();   
		    sb.append("ERROR####"+err);
	        } 
		  } 
		  catch (Exception e) 
		  { }
		 
		  return sb.toString();
	}
	
	
}
