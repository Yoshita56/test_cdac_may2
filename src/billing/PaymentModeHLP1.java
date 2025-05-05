package billing;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

public class PaymentModeHLP1{
		
	public static String getChequeDetails()
	 {
		 StringBuffer sBuffer = new StringBuffer("");
		 try{
			          sBuffer.append("<table width='75%' align='center' border='0'>");       
	 	              sBuffer.append("<tr><td width='21%' class='LABEL'>");
	                  sBuffer.append("<font color='red'>*</font>Cheque No</td>");
                      sBuffer.append("<td width='21%' class='CONTROL'>");  
	  	              sBuffer.append("<input type='text' name='strChequeNo' class='txtFldNormal' maxlength ='20' id='strChequeNo' onkeypress=\"return validateData(event,7);\">");
	  	              sBuffer.append("</td>");
	  	              	              
	  	              sBuffer.append("<td width='21%' class='LABEL'>");
	                  sBuffer.append("<font color='red'>*</font>Cheque Date</td>");
	                  sBuffer.append("<td width='21%' class='CONTROL'>");
	                  sBuffer.append(HisUtil.getDatePicker("strChequeDate", "", true));
	  	           // sBuffer.append("<input type='text' name='strChequeDate' class='txtFldNormal' maxlength ='20' id='strChequeDate' onkeypress=\"return validateData(event,7);\">");
	  	              sBuffer.append("</td></tr>");
	  	              	                         
	      	          sBuffer.append("<tr><td width='21%' class='LABEL'>");
	                  sBuffer.append("<font color='red'>*</font>Bank Name</td>");
	 	              sBuffer.append("<td width='21%' class='CONTROL'>");    
		              sBuffer.append("<input type='text' name='strBankName' class='txtFldMax' maxlength ='20' id='strDrawBank' return validateData(event,5);'>");
		              sBuffer.append("</td>");
		              sBuffer.append("<td width='21%' class='LABEL'>");
	                  sBuffer.append("<font color='red'>*</font>Branch</td>");
	                  sBuffer.append("<td width='21%' class='CONTROL'>");
	                  sBuffer.append("<input type='text' name='strBranchName' class='txtFldMax' maxlength ='20' id='strBranchName' return validateData(event,5);'>");
	      	          sBuffer.append("</td></tr>");
	      	          sBuffer.append("</table>");

	 	              
	 	              
	 	              
	     }
		 catch(Exception e)
		 {
			 new HisException("Client Verification Trans","ClientVerificationHLP.getChequeDetails()-->",e.getMessage());
	     }
	   
		// System.out.println("value :  "+sBuffer.toString());
	     
	     return sBuffer.toString();
		
	 }
	 
	 
	  public static String getDDDetails()
	  {
	 	 StringBuffer sBuffer = new StringBuffer("");
	 	 try{
	              
		              sBuffer.append("<table width='75%' align='center' border='0'>");       
	 	              sBuffer.append("<tr><td width='21%' class='LABEL'>");
	                  sBuffer.append("<font color='red'>*</font>Draft NO</td>");
                      sBuffer.append("<td width='21%' class='CONTROL'>");  
	  	              sBuffer.append("<input type='text' name='strDraftNo' class='txtFldNormal' maxlength ='20' id='strDraftNo' onkeypress=\"return validateData(event,7);\">");
	  	              sBuffer.append("</td>");
	  	              	              
	  	              sBuffer.append("<td width='21%' class='LABEL'>");
	                  sBuffer.append("<font color='red'>*</font>Draft Date</td>");
	                  sBuffer.append("<td width='21%' class='CONTROL'>");
	                  sBuffer.append(HisUtil.getDatePicker("strDraftDate", "", true));
	  	           //   sBuffer.append("<input type='text' name='strDraftDate' class='txtFldNormal' maxlength ='20' id='strDraftDate' onkeypress=\"return validateData(event,7);\">");
	  	              sBuffer.append("</td></tr>");
	  	              	                         
	      	          sBuffer.append("<tr><td width='21%' class='LABEL'>");
	                  sBuffer.append("<font color='red'>*</font>Bank Name</td>");
	 	              sBuffer.append("<td width='21%' class='CONTROL'>");    
		              sBuffer.append("<input type='text' name='strBankName' class='txtFldMax' maxlength ='20' id='strDrawBank' return validateData(event,5);'>");
		              sBuffer.append("</td>");
		              sBuffer.append("<td width='21%' class='LABEL'>");
	                  sBuffer.append("<font color='red'>*</font>Branch</td>");
	                  sBuffer.append("<td width='21%' class='CONTROL'>");
	                  sBuffer.append("<input type='text' name='strBranchName' class='txtFldMax' maxlength ='20' id='strBranchName' return validateData(event,5);'>");
	      	          sBuffer.append("</td></tr>");
	      	          sBuffer.append("</table>");
	           
		              
		              
		              
		              
		              
		              
	      }
	 	 catch(Exception e)
	 	 {
	     
	      }
	    return sBuffer.toString();
	  }
	  public static String getCardDetails()
	  {
	 	 StringBuffer sBuffer = new StringBuffer("");
	 	 try{
  		              sBuffer.append("<table width='75%' align='center' border='0'>");       
	 	              sBuffer.append("<tr><td width='21%' class='LABEL'>");
	                  sBuffer.append("<font color='red'>*</font>Card No</td>");
                      sBuffer.append("<td width='21%' class='CONTROL'>");  
	  	              sBuffer.append("<input type='text' name='strCardNo' class='txtFldNormal' maxlength ='20' id='strCardNo' onkeypress=\"return validateData(event,7);\">");
	  	              sBuffer.append("</td>");
	  	              	              
	  	              sBuffer.append("<td width='21%' class='LABEL'>");
	                  sBuffer.append("<font color='red'>*</font>Card Type</td>");
	  	              sBuffer.append("<td class='CONTROL'><select name ='strCardType' width ='21%' class='comboNormal' id = 'strCardType'>");
	      	          sBuffer.append("<option value ='0'> Select Value</option>");
	      	          sBuffer.append("<option value ='1' selected='selected'>Master</option>");
	      	          sBuffer.append("<option value ='2' >Visa</option>");
	      	          sBuffer.append("</td></tr>");
	  	              	                         
	      	          sBuffer.append("<tr><td width='21%' class='LABEL'>");
	                  sBuffer.append("<font color='red'>*</font>Auth No.</td>");
	 	              sBuffer.append("<td width='21%' class='CONTROL'>");    
		              sBuffer.append("<input type='text' name='strAuthNo' class='txtFldNormal' maxlength ='20' id='strAuthNo' return validateData(event,5);'>");
		              sBuffer.append("</td>");
		              sBuffer.append("<td width='21%' class='LABEL'>");
	                  sBuffer.append("<font color='red'>*</font>Expiry Date</td>");
	                  sBuffer.append("<td width='21%' class='CONTROL'>");  
	                  sBuffer.append(HisUtil.getDatePicker("strExpiryDate", "", true));
	                 // sBuffer.append("<input type='text' name='strExpiryDate' class='txtFldNormal' maxlength ='20' id='strExpiryDate' return validateData(event,5);'>");
	      	          sBuffer.append("</td></tr>");
	      	          sBuffer.append("</table>");
		             
	           
	      }
	 	 catch(Exception e)
	 	 {
	      
	      }
	    return sBuffer.toString();
	  }
	  
	 
}
