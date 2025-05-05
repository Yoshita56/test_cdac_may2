package billing;
import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;

public class HLPClientApprovalDtl
{
	public static String getClientApprovalDetails_PUK(String strPukNo ,String strChargeTypeId,String strHospCode) 
	{
		BillingVO voObj = new BillingVO();  
		BillingBO boObj = new BillingBO();
		
		voObj.setStrValue1(strPukNo);  
		voObj.setStrValue2(strChargeTypeId); 
		voObj.setStrValue3(strHospCode);
		StringBuffer sb = new StringBuffer("");
		try 
		{
		 boObj.getApprovalDetails_Puk(voObj);
		 WebRowSet ws = voObj.getGblWs1();	
	 	 if(voObj.getStrMsgType().equals("0"))
    	 {
	       if (ws != null) 
		   {
			if (ws.next()) 
			{
    				String strClientName = ws.getString(3);
					String strClientType = ws.getString(4);
					String strCltAppSancAmt = ws.getString(7);
					String strApplcationNo = ws.getString(5);
					String strDate = ws.getString(6);
					String strCltApprBalanceAmt = ws.getString(8);
				//	String strClientPatNo = ws.getString(8);
				//	String strClientNo = ws.getString(9);
				//	String strCltAppHLPHid = ws.getString(18);
//				    System.out.println("Client_Pat_No->"+ws.getString(1));
//				    System.out.println("Client_No->"+ws.getString(2));
//				    System.out.println("Client Name->"+ws.getString(3));
//				    System.out.println("Client Type->"+ws.getString(4));
//				    System.out.println("AppNo->"+ws.getString(5));
//				    System.out.println("Date->"+ws.getString(6));
//				    System.out.println("Balance Amt->"+ws.getString(7));
//				    System.out.println("8->"+ws.getString(8));
//				    System.out.println("9->"+ws.getString(9));
//				    System.out.println("10->"+ws.getString(10));
//				    System.out.println("11->"+ws.getString(11));
//				    System.out.println("12->"+ws.getString(12));
//				    System.out.println("13->"+ws.getString(13));
//				    System.out.println("14->"+ws.getString(14));
//				    System.out.println("15->"+ws.getString(15));
//				    System.out.println("16->"+ws.getString(16));
//				    System.out.println("17->"+ws.getString(17));
//				    System.out.println("hidden field->"+ws.getString(18));
				    			    
				    
     				if (strClientName == null)
						strClientName = "";
					if (strClientType == null)
						strClientType = "";
					if (strCltAppSancAmt == null)
						strCltAppSancAmt = "";
					if (strApplcationNo == null)
						strApplcationNo = "";
					if (strDate == null)
						strDate = "";
					if (strCltApprBalanceAmt == null)
						strCltApprBalanceAmt = "";
					sb.append("<input type='hidden' name='strCltPatientNo' value="+ws.getString(1)+">");
					sb.append("<input type='hidden' name='strCltAppHLPHid' value="+ws.getString(18)+">");
					sb.append("<input type='hidden' name='strCltAppSancAmt' value="+ws.getString(7)+">");
					sb.append("<input type='hidden' name='strCltApprBalanceAmt' value="+ws.getString(9)+">");
				
					
					sb.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px'>");
					sb.append("<tr><td width='25%' class='LABEL'>Client Name:</td>");
					sb.append("<td width='25%' class='CONTROL' name='strClientName'> ");
					sb.append(strClientName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Client Type:</td>");
					sb.append("<td width='25%' class='CONTROL' name='strClientType'>");
					sb.append(strClientType);
					sb.append("</td>");
					sb.append("</tr>");
	
					sb.append("<tr><td width='25%' class='LABEL'>Sanction Amt:</td>");
					sb.append("<td width='25%' class='CONTROL' name='strCltAppSancAmt'> ");
					sb.append(strCltAppSancAmt);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>App No/Date:</td>");
					sb.append("<td width='25%' class='CONTROL' name='strApplNoDate'>");
					sb.append(strApplcationNo +"/"+strDate);
					sb.append("</td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>Balance Amt:</td>");
					sb.append("<td width='25%' class='CONTROL' name ='strCltApprBalanceAmt'>");
					sb.append("<input name='strCltApprBalanceAmt' type='text' class='txtFldMin' value="+ws.getString(9)+" disabled='disabled'>");
					sb.append("&nbsp;Rs</td>");
							    
					sb.append("<td width='25%' class='LABEL'></td>");
					sb.append("<td width='25%' class='CONTROL' name=''>");
					sb.append("</td>");
					
					sb.append("</tr>");
					
					sb.append("</table>");
				}

			}
	       else
           {
          	    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
  				sb.append("<tr>");
  				sb.append("<td colspan='7'  CLASS='multiControl' >"
  						+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED GROUP </div>" + "</TD>");
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
	  catch (Exception e) {}
		
      
		return sb.toString();
	}
	
	public static String getClientApprovalDetails_APPID(String strClientPatNo ,String strChargeTypeId,String strHospCode) 
	{

		BillingVO voObj = new BillingVO();  
		BillingBO boObj = new BillingBO();
		
		voObj.setStrValue1(strClientPatNo);  
		voObj.setStrValue2(strChargeTypeId); 
		voObj.setStrValue3(strHospCode);
		StringBuffer sb = new StringBuffer("");
       try
       {
    	 if(voObj.getStrMsgType().equals("0"))
      	 {
    	   boObj.getApprovalDetails_CltAppNo(voObj);
   		   WebRowSet ws = voObj.getGblWs1();
   		   if (ws != null)
		   {
     		    if (ws.next())
				{
    				String strClientName = ws.getString(3);
					String strClientType = ws.getString(4);
					String strCltAppSancAmt = ws.getString(7);
					String strApplcationNo = ws.getString(5);
					String strDate = ws.getString(6);
					String strCltApprBalanceAmt = ws.getString(8);
//					String strClientPatNo = ws.getString(8);
				//	String strClientNo = ws.getString(9);
				//	String strCltAppHLPHid = ws.getString(18);

			    
     				if (strClientName == null)
						strClientName = "";
					if (strClientType == null)
						strClientType = "";
					if (strCltAppSancAmt == null)
						strCltAppSancAmt = "";
					if (strApplcationNo == null)
						strApplcationNo = "";
					if (strDate == null)
						strDate = "";
					if (strCltApprBalanceAmt == null)
						strCltApprBalanceAmt = "";
					sb.append("<input type='hidden' name='strCltPatientNo' value="+ws.getString(1)+">");
					sb.append("<input type='hidden' name='strCltAppHLPHid' value="+ws.getString(18)+">");
					sb.append("<input type='hidden' name='strCltAppSancAmt' value="+ws.getString(7)+">");
					sb.append("<input type='hidden' name='strCltApprBalanceAmt' value="+ws.getString(9)+">");

					
					sb.append("<table class='TABLEWIDTH' align='center'>");
					sb.append("<tr><td width='25%' class='LABEL'>Client Name:</td>");
					sb.append("<td width='25%' class='CONTROL' name='strClientName'> ");
					sb.append(strClientName);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Client Type:</td>");
					sb.append("<td width='25%' class='CONTROL' name='strClientType'>");
					sb.append(strClientType);
					sb.append("</td>");
					sb.append("</tr>");
	
					sb.append("<tr><td width='25%' class='LABEL'>Sanction Amt:</td>");
					sb.append("<td width='25%' class='CONTROL' name='strCltAppSancAmt'> ");
					sb.append(strCltAppSancAmt);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>App No/Date:</td>");
					sb.append("<td width='25%' class='CONTROL' name='strApplNoDate'>");
					sb.append(strApplcationNo +"/"+strDate);
					sb.append("</td>");
					sb.append("</tr>");
					
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>Balance Amt:</td>");
					sb.append("<td width='25%' class='CONTROL' name ='strCltApprBalanceAmt'>");
					sb.append("<input name='strCltApprBalanceAmt' type='text' class='txtFldMin' value="+ws.getString(9)+" disabled='disabled'>");
					sb.append("&nbsp;Rs</td>");
							    
					sb.append("<td width='25%' class='LABEL'></td>");
					sb.append("<td width='25%' class='CONTROL' name=''>");
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("</table>");				
				}
		      }
		  else
          {
         	    sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
 				sb.append("<tr>");
 				sb.append("<td colspan='7'  CLASS='multiControl' >"
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
        catch (SQLException e) 
        {
				
        }
		
		return sb.toString();
	}
	
	
}
