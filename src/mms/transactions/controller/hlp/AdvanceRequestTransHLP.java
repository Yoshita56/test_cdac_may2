package mms.transactions.controller.hlp;

import hisglobal.exceptions.HisException;

import javax.sql.rowset.WebRowSet;

public class AdvanceRequestTransHLP {
	
	public static String getPODetails(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		 try {
			if(wb != null && wb.size() > 0)
			{ 
				while(wb.next())
				{
						String strPODate = wb.getString(1);
	  					String strSuppName = wb.getString(2);
	  					String strPOType = wb.getString(3);
	  					String strCurrCode = wb.getString(4);
	  					String strPONetAmt = wb.getString(6);
	  					String strAdvTaken = wb.getString(5);
	  					String strRequestedAdvAmt = wb.getString(17);
	  						  					
	  					if(strPODate == null || strPODate.equals("null") || strPODate.equals(""))strPODate = "---";
	  					if(strSuppName == null || strSuppName.equals("null") || strSuppName.equals("") )strSuppName = "---";
	  					if(strPOType == null || strPOType.equals("null") || strPOType.equals(""))strPOType = "---";
	  					if(strCurrCode == null || strCurrCode.equals("null") || strCurrCode.equals(""))strCurrCode = "---";
	  					if(strPONetAmt == null || strPONetAmt.equals("null") || strPONetAmt.equals(""))strPONetAmt = "---";
	  					if(strAdvTaken == null || strAdvTaken.equals("null") || strAdvTaken.equals(""))strAdvTaken = "---";
	  					sBuffer.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px'>");
	  					sBuffer.append("<tr><td colspan='4' class='TITLE'>PO Details</td></tr>"); 
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width='25%'  colspan='1' class='LABEL'>PO Date</td>");  
	  					sBuffer.append("<input type='hidden' name='strPODate' value='"+strPODate+"'>");
	  					sBuffer.append("<input type='hidden' name='strAdvTaken' value='"+strAdvTaken+"'>");
	  					sBuffer.append("<input type='hidden' name='strRequestedAdvAmt' value='"+strRequestedAdvAmt+"'>");
	  					sBuffer.append("<td width='25%' colspan='1' class='CONTROL'>"+strPODate+"</td>");
	  					sBuffer.append("<td width='25%' colspan='1' class='LABEL'>Supplier Name</td>");
	  					sBuffer.append("<td width='25%' colspan='1' class='CONTROL'>"+strSuppName+"</td></tr>");
	  					
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width='25%' colspan='1' class='LABEL'>PO Type</td>");
	  					sBuffer.append("<td width='25%' colspan='1' class='CONTROL'>"+strPOType+"</td>");
	  					sBuffer.append("<td width='25%' colspan='1' class='LABEL'>Currency Code</td>");
	  					sBuffer.append("<td width='25%' colspan='1' class='CONTROL'>"+strCurrCode+"</td></tr>");
	  					
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width='25%' colspan='1' class='LABEL'>PO Net Amt</td>");
	  					sBuffer.append("<td width='25%' colspan='1' class='CONTROL'>"+strPONetAmt+"</td>");
	  					sBuffer.append("<td width='25%' colspan='1' class='LABEL'>Advance Taken</td>");
	  					sBuffer.append("<td width='25%' colspan='1' class='CONTROL'>"+strAdvTaken+"</td></tr>");
	  					sBuffer.append("<tr><td width='25%' colspan='1' class='LABEL'>Requested Advance Amt</td>");
	  					sBuffer.append("<td width='25%' colspan='3' class='CONTROL'>"+strRequestedAdvAmt+"</td></tr>");
	  					sBuffer.append("<input type='hidden' name='strSuppId' value='"+wb.getString(7)+"'>");
	  					sBuffer.append("<input type='hidden' name='strCurrId' value='"+wb.getString(9)+"'>");
	  					sBuffer.append("<input type='hidden' name='strPOAmt' value='"+strPONetAmt+"'>");
	  					
	  				}
                 sBuffer.append("</table>");
              
                 
	     }else {
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td CLASS='multiControl' >"
						+ "<div class='errMsg' align='center'> NO RECEIPT DETAILS FOUND FOR SELECTED PO NO. </div>" + "</td>");

			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			throw  new HisException("Advance Request Transaction","AdvanceRequestTransHLP.getPODetails()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
	
	public static String getPODetailsDup(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		 try {
			if(wb != null && wb.size() > 0)
			{ 
				while(wb.next())
				{
						String strPODate = wb.getString(1);
	  					String strSuppName = wb.getString(2);
	  					String strPOType = wb.getString(3);
	  						  						  					
	  					if(strPODate == null || strPODate.equals("null") || strPODate.equals(""))strPODate = "---";
	  					if(strSuppName == null || strSuppName.equals("null") || strSuppName.equals("") )strSuppName = "---";
	  					if(strPOType == null || strPOType.equals("null") || strPOType.equals(""))strPOType = "---";
	  					
	  					sBuffer.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px'>");
	  					sBuffer.append("<tr><td colspan='4' class='TITLE'>PO Details</td></tr>"); 
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width='25%' colspan='1' class='LABEL'>PO Date</td>");  
	  					sBuffer.append("<td width='25%' colspan='1' class='CONTROL'>"+strPODate+"</td>");
	  					sBuffer.append("<td width='25%' colspan='1' class='LABEL'>Supplier Name</td>");
	  					sBuffer.append("<td width='25%' colspan='1' class='CONTROL'>"+strSuppName+"</td></tr>");
	  					
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width='25%' colspan='1' class='LABEL'>PO Type</td>");
	  					sBuffer.append("<td width='25%' colspan='3' class='CONTROL'>"+strPOType+"</td></tr>");
	  					
//	  					sBuffer.append("<input type='hidden' name='strPODate' value='"+strPODate+"'>");
//	  					sBuffer.append("<input type='hidden' name='strSuppId' value='"+wb.getString(7)+"'>");
//	  					sBuffer.append("<input type='hidden' name='strCurrId' value='"+wb.getString(9)+"'>");
	  					
	  				}
                sBuffer.append("</table>");
             
                
	     }else {
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td CLASS='CONTROL' >"
						+ "<div class='errMsg' align='center'> NO RECEIPT DETAILS FOUND FOR SELECTED PO NO. </div>" + "</td>");

			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
		   } 
		 }
		 catch(Exception e)
		 {
			throw  new HisException("Advance Request Transaction","AdvanceRequestTransHLP.getPODetailsDup()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
	
	
	public static String getBankDetailsDup(WebRowSet wb)
	 {
		StringBuffer sBuffer = new StringBuffer("");
		 try {
			if(wb != null && wb.size() > 0)
			{ 
				sBuffer.append("<div id = 'bankdtlsDiv' style='display:none'>");
				sBuffer.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px'>");
				sBuffer.append("<tr><td colspan='4' class='TITLE'>Bank Account Details</td></tr>"); 
				sBuffer.append("<tr><td width='50%' class='multiLabel'>Bank Acc. Name</td>"); 
				sBuffer.append("<td width='50%' class='multiLabel'>Bank Acc. No.</td></tr>"); 
				
				while(wb.next())
				{
						String strBankAccName = wb.getString(1);
	  					String strBankAccNo = wb.getString(2);
	  					
	  						  						  					
	  					if(strBankAccName == null || strBankAccName.equals("null") || strBankAccName.equals(""))strBankAccName = "---";
	  					if(strBankAccNo == null || strBankAccNo.equals("null") || strBankAccNo.equals("") )strBankAccNo = "---";
	  					
	  					
	  					
	  					sBuffer.append("<tr>");
	  					sBuffer.append("<td width='50%' colspan='1' class='multiControl'>"+strBankAccName+"</td>");
	  					sBuffer.append("<td width='50%' colspan='1' class='multiControl'>"+strBankAccNo+"</td></tr>");
	  					
	  				}
               sBuffer.append("</table>");
               sBuffer.append("</div>");
               
	     }else {
	    	 	sBuffer.append("<div id = 'bankdtlsDiv' style='display:none'>");
			    sBuffer.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px'>"); 
			    sBuffer.append("<tr>");
			    sBuffer.append("<td CLASS='CONTROL' >"
						+ "<div class='errMsg' align='center'> NO BANK ACC. DETAILS FOUND FOR SELECTED PO NO. </div>" + "</td>");

			    sBuffer.append("</tr>");
			    sBuffer.append("</table>");
			    sBuffer.append("</div>");
		   } 
		 }
		 catch(Exception e)
		 {
			throw new HisException("Advance Request Transaction","AdvanceRequestTransHLP.getBankDetailsDup()-->",e.getMessage());
	     }
	    return sBuffer.toString();
	 	}
	
public static String getNewReqDetails(WebRowSet wb){
		
		StringBuffer br = new StringBuffer("");
	
		try {			
			if(wb != null && wb.size() > 0)
			{
				
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				br.append("<tr><td colspan='5' class='TITLE'>Request Details</td></tr>");
				
				br.append("<td width='30%' class='multiLabel'>Req No</td>"); 
				br.append("<td width='20%' class='multiLabel'>Req Date</td>"); 
				br.append("<td width='20%' class='multiLabel'>Advance Requested</td>"); 
				br.append("<td width='20%' class='multiLabel'>Advance Status</td></tr>"); 
				
				while (wb.next())
				{
					
					
					String strReqNo = wb.getString(2);
					String strReqDate = wb.getString(3);
					String strAdvRequested = wb.getString(4);
					String strAdvStatus = wb.getString(5);					
					
					if(strReqNo == null || strReqNo.equals("null"))strReqNo = "";
					if(strReqDate == null || strReqDate.equals("null"))strReqDate = "";
					if(strAdvRequested == null || strAdvRequested.equals("null"))strAdvRequested = "";
					 
					br.append("<tr>");
					
					
					br.append("<td width='30%' class='multiControl'>"+strReqNo+"</td>");
					br.append("<td width='20%' class='multiControl'>"+strReqDate+"</td>");
					br.append("<td width='20%' class='multiControl'>"+strAdvRequested+"</td>");
					br.append("<td width='20%' class='multiControl'>"+strAdvStatus+"</td>");
					br.append("</tr>");	
					
				
					
				}
				br.append("</table>");
				
				
			}else {
					
				    br.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px'>"); 
				    br.append("<tr>");
				    br.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED PO NO. </div>" + "</TD>");

				    br.append("</tr>");
				    br.append("</table>");
				    
				    
					
			   } 
		}catch(Exception e){
			
			throw new HisException("Advance Request Transaction","AdvanceRequestTransHLP.getReqDetails()-->",e.getMessage());
		}
	return br.toString();
	}

	public static String getReqDetails(WebRowSet wb){
		
		StringBuffer br = new StringBuffer("");
	
		try {			
			if(wb != null && wb.size() > 0)
			{
				br.append("<div id = 'reqdtlsDiv' style='display:none'>");
				br.append("<table class='TABLEWIDTH' align='center' cellspacing='1px'>");
				br.append("<tr><td colspan='5' class='TITLE'>Request Details</td></tr>");
				br.append("<tr><td width='5%' class='multiLabel'>#</td>"); 
				br.append("<td width='45%' class='multiLabel'>Req No</td>"); 
				br.append("<td width='20%' class='multiLabel'>Req Date</td>"); 
				br.append("<td width='25%' class='multiLabel'>Advance Requested</td></tr>"); 
				
				
				while (wb.next())
				{
					
					String strRadioVal = wb.getString(1);
					String strReqNo = wb.getString(2);
					String strReqDate = wb.getString(3);
					String strAdvRequested = wb.getString(4);
					
					if(strRadioVal == null || strRadioVal.equals("null"))strRadioVal = "";
					if(strReqNo == null || strReqNo.equals("null"))strReqNo = "";
					if(strReqDate == null || strReqDate.equals("null"))strReqDate = "";
					if(strAdvRequested == null || strAdvRequested.equals("null"))strAdvRequested = "";
					 
					br.append("<tr>");
					br.append("<td width='10%' class='multiControl'>");
					br.append("<input type='radio' name='strRadioVal' value='"+strRadioVal+"' ></td>");
					br.append("<td width='45%' class='multiControl'>"+strReqNo+"</td>");
					br.append("<td width='20%' class='multiControl'>"+strReqDate+"</td>");
					br.append("<td width='25%' class='multiControl'>"+strAdvRequested+"</td>");
					br.append("</tr>");	
					
				}
				br.append("</table>");
				br.append("</div>");
				
			}else {
					br.append("<div id = 'reqdtlsDiv' style='display:none'>");
				    br.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px'>"); 
				    br.append("<tr>");
				    br.append("<td colspan='5'  CLASS='multiControl' >"
							+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED PO NO. </div>" + "</TD>");

				    br.append("</tr>");
				    br.append("</table>");
				    br.append("</div>");
				    
					
			   } 
		}catch(Exception e){
			
			throw new HisException("Advance Request Transaction","AdvanceRequestTransHLP.getReqDetails()-->",e.getMessage());
		}
	return br.toString();
	}
	
}
