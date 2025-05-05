package billing;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.sql.SQLException;

import javax.sql.rowset.WebRowSet;
public class HLPAccountDtl 
{
	public static String getAccountDetailsHLP(String strPukNo,String strChargeTypeId,String strActiveAcctStatus , String strHospitalCode) 
	{

		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
		
	    voObj.setStrValue1(strPukNo);
	    voObj.setStrValue2(strChargeTypeId);
	    voObj.setStrValue3(strActiveAcctStatus);
        voObj.setStrValue4(strHospitalCode); 
	   
	  	StringBuffer sb = new StringBuffer("");
	    try 
		{
		    boObj.getAccountDtlPukNo(voObj);
		    WebRowSet ws = voObj.getGblWs3();
          	if(voObj.getStrMsgType().equals("0"))
			{				
			  if (ws != null && ws.size() > 0) 
			  {	
				if(ws.next()) 
				{
//					  System.out.println("Charge Type ID->"+ws.getString(1));
//			    	  System.out.println("Pat Acct Opng Dt->"+ws.getString(2));
//			    	  System.out.println("Puk No->"+ws.getString(3));
//			    	  System.out.println("Clt Pat No->"+ws.getString(4));
//			    	  System.out.println("Addmn No->"+ws.getString(5));
//			    	  System.out.println("Episode Code->"+ws.getString(6));
//			    	  System.out.println("Sanc Amt->"+ws.getString(7));
//			    	  System.out.println("Pat Recd Amt->"+ws.getString(8));
//			    	  System.out.println("Clt Amt->"+ws.getString(9));
//			    	  System.out.println("Process Exp Amt->"+ws.getString(10));
//			    	  System.out.println("Pat Refund Amt->"+ws.getString(11));
//			    	  System.out.println("Un Process Exp Amt->"+ws.getString(12));
//			    	  System.out.println("Net Disct Amt->"+ws.getString(13));
//			    	  System.out.println("Recrd Concile Amt->"+ws.getString(14));
//			    	  System.out.println("Proce Exp Amt->"+ws.getString(15));
//			    	  System.out.println("Pat Recd Amt->"+ws.getString(16));
//			    	  System.out.println("Clt Amt->"+ws.getString(17));
//			    	  System.out.println("Pat Refund Amt->"+ws.getString(18));
//			    	  System.out.println("Net Disc Amt->"+ws.getString(19));
//			    	  System.out.println("Approved By->"+ws.getString(20));
//			    	  System.out.println("Clt balance->"+ws.getString(21));
//			    	  System.out.println("pat Closing Date->"+ws.getString(22));
//			    	  System.out.println("Apprved Date->"+ws.getString(23));
//			    	  System.out.println("Approved Id->"+ws.getString(24));
//			    	  System.out.println("Hidden Value->"+ws.getString(25));
				
					String strAcctOpngDate  = ws.getString(2);
					String strTreatmentCatg = ws.getString(24);
					String strAccountType   = ws.getString(22);
//					String strActHLPHid     = ws.getString(25);

					if(strTreatmentCatg == null) strTreatmentCatg = "";
					if(strAccountType == null) strAccountType = "";

					
					sb.append("<input type='hidden' name='strActHLPHid' value="+ws.getString(25)+">");
					
				//	sb.append("<table class='TABLEWIDTH' align='center'>");
					sb.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px'>");
					sb.append("<tr><td width='25%' class='LABEL'>Account No/Account Type:</td>");
					sb.append("<td width='25%' class='CONTROL' > <input type='hidden' name='strAcctNoAcctTyp' value='"+strAccountType+"' > ");
					sb.append(ws.getString(26)+"/"+strAccountType);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Opening Date:</td>");
					sb.append("<td width='25%' class='CONTROL' ><input type='hidden' name='strAcctOpngDate' value='"+strAcctOpngDate+"' >");
					sb.append(strAcctOpngDate);
					sb.append("</td>");
					sb.append("</tr>");
					sb.append("<tr>");
					sb.append("<td width='25%' class='LABEL'>Treatment Category:</td>");
					sb.append("<td width='25%' class='CONTROL'  > <input type='hidden' name='strTreatmentCatg' value='"+strTreatmentCatg+"' > ");
					sb.append(strTreatmentCatg);
					sb.append("</td>");
					sb.append("<td width='25%' class='LABEL'>Balance Amt:</td>");
					sb.append("<td width='25%' class='CONTROL' >");
					sb.append("<input name='strAcctDtlBalanceAmt' type='text' class='txtFldMin' value='"+ws.getString(23)+"' disabled='disabled'>");
					sb.append("&nbsp;Rs</td>");
					sb.append("</tr></table>");
					
							
					
				}
			  }
			  else
			  {
				  sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px'>"); 
	 			  sb.append("<tr>");
	 			  sb.append("<td colspan='4'  CLASS='multiControl' >"
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
				new HisException(
						"Billing",
						"HLPAccountDtl.getAccountPukDetailsHLP() -->",
						e.getMessage());
			}
		

		return sb.toString();
	}
	
	
	
	
	public static String getAccountDetailsHLP1(String strAcctNo,String strChkBoxComboValue,String strHospCode) 
	{
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
		StringBuffer sb = new StringBuffer("");
	    voObj.setStrValue1(strAcctNo);
	    voObj.setStrValue2(strHospCode);
	   
	    try 
	    {
		     boObj.getAccountDtlAcctNo(voObj);
		 	 String[] strValue = strChkBoxComboValue.split("\\@");
		 	 String  strChkVal = strValue[0];
		 	 String  strComboVal = strValue[1];
		 	 WebRowSet ws = voObj.getGblWs3();
		    if(voObj.getStrMsgType().equals("0"))
			{
				 if (ws != null) 
				 {					 
					if(ws.next()) 
					{
							String strAcctOpngDate = ws.getString(2);
						//	String strPukNo        = ws.getString(3);
							String strTreatmentCatg =	ws.getString(24);
							String strAddmnNo = 		ws.getString(4);
							String strAddmnDate = ws.getString(5);
							String strDeptName =			ws.getString(6);
							String strWardName =		ws.getString(7);
							String strAccountNo =		ws.getString(8);
							String strAccountType =		ws.getString(22);
							String strClientName  = ws.getString(10);
							String strApprovalNo  = ws.getString(11);
							String strSancAmt     = HisUtil.getAmountWithDecimal(ws.getString(7),2);
							String strPatientRecdAmt = HisUtil.getAmountWithDecimal(ws.getString(8),2);
					//		System.out.println("strPatientRecdAmt-->>>"+strPatientRecdAmt);
						//	String strClientAmt  = ws.getString(14);
							String strTariffNetAmt  = HisUtil.getAmountWithDecimal(ws.getString(10),2);
							
							String BalanceAmt   =  ws.getString(15);
							String finalBillFlag= ws.getString(27);
							String strRoomLimit= ws.getString(28);
							String strAvailedPackageId= ws.getString(29);
							String strAvailedPackageName= ws.getString(30);
							
					//		System.out.println("Tariff Net Amt---->>>>"+strTariffNetAmt);
					//		String strAcctType  = ws.getString(22);
					//		String strClientType  = ws.getString(17);
					//		String strAcctDtlBalanceAmt = ws.getString(10);
					//		String strActHLPHid = ws.getString(25);
		
							//PatRecdAmt   =  Double.parseDouble(strPatientRecdAmt);
						//	TariffNetAmt =  Double.parseDouble(strTariffNetAmt);
							
							
												
							if(strTreatmentCatg == null) strTreatmentCatg = "";
							if(strAddmnNo == null) strAddmnNo = "";
							if(strAddmnDate == null) strAddmnDate = "";
							if(strDeptName == null) strDeptName = "";
							if(strWardName == null) strWardName = "";
							if(strAccountNo == null) strAccountNo = "";
							if(strAccountType == null) strAccountType = "";
							if(strClientName == null) strClientName = "";
							if(strApprovalNo == null) strApprovalNo = "";
							if(strSancAmt == null) strSancAmt = "";
							if(strPatientRecdAmt == null) strPatientRecdAmt = "";
							if(strTariffNetAmt == null) strTariffNetAmt = "";
							
							sb.append("<input type='hidden' name='strChkVal' value="+strChkVal+">");
							sb.append("<input type='hidden' name='strComboVal' value="+strComboVal+">");
							sb.append("<input type='hidden' name='strAcctNo' value="+strAcctNo+">");
							sb.append("<input type='hidden' name='strActOpenDate' value="+strAcctOpngDate+">");	
							sb.append("<input type='hidden' name='strActHLPHid' value="+ws.getString(25)+">");
							sb.append("<input type='hidden' name='strAcctDtlBalanceAmt' value="+ws.getString(10)+">");
							sb.append("<input type='hidden' name='strTreatmentCategory' value="+ws.getString(26)+">");
							sb.append("<input type='hidden' name='finalBillFlag' value="+finalBillFlag+">");
							sb.append("<input type='hidden' name='strRoomLimit' value="+strRoomLimit+">");
							sb.append("<input type='hidden' name='strRoomLimit' value="+strRoomLimit+">");
							sb.append("<input type='hidden' name='strAvailedPackageId' value="+strAvailedPackageId+">");
							
							sb.append("<table class='TABLEWIDTH' align='center'  border='0' cellspacing ='1px' >");
							sb.append("<tr><td width='25%' class='LABEL'>Account No/Account Type:</td>");
							sb.append("<td width='25%' class='CONTROL' name='strAcctNoAcctTyp'> ");
							sb.append(strAcctNo+"/"+strAccountType);
							sb.append("</td>");
							sb.append("<td width='25%' class='LABEL'>Opening Date:</td>");
							sb.append("<td width='25%' class='CONTROL' name='strAcctOpngDate'>");
							sb.append(strAcctOpngDate);
							sb.append("</td>");
							sb.append("</tr>");
							sb.append("<tr>");
							sb.append("<td width='25%' class='LABEL'>Treatment Category:</td>");
							sb.append("<td width='25%' class='CONTROL' name ='strTreatmentCatg'>");
							sb.append(strTreatmentCatg);
							sb.append("</td>");			    
							sb.append("<td width='25%' class='LABEL'>Balance(-)/Payble(+) Amt:</td>");
							sb.append("<td width='25%' class='CONTROL' >");
							sb.append("<input name='strAccountBalanceAmt' type='hidden' class='txtFldMin' value='"+HisUtil.getAmountWithDecimal(BalanceAmt,2)+"' >");
							sb.append(HisUtil.getAmountWithDecimal(BalanceAmt,2));
							sb.append("&nbsp;Rs</td>");
							sb.append("<input name='strSancAmt' type='hidden' value='"+strSancAmt+"' >");
							sb.append("<input name='strTariffNetAmt' type='hidden' value='"+strTariffNetAmt+"' >");
							sb.append("<input name='strAcctOpngDate' type='hidden' value='"+strAcctOpngDate+"' >");
							sb.append("</tr>");


							sb.append("<tr>");
							sb.append("<td width='25%' class='LABEL'>Room Limit:</td>");
							sb.append("<td width='25%' class='CONTROL' name ='strRoomLimitTd'>");
							sb.append(strRoomLimit);
							sb.append("</td>");
							sb.append("<td width='25%' class='LABEL'>Availed Package:</td>");
							sb.append("<td width='25%' class='CONTROL' name ='strAvailedPackageId'>");
							sb.append(strAvailedPackageName);
							sb.append("</td>");
							
							sb.append("</tr>");
							
							sb.append("<tr>");
							sb.append("<td width='100%' colspan='4'><div class='lineContinue'><label class='DIVLABELCR'>&nbsp;</label></div></td>");
							sb.append("</tr>");
							
							sb.append("</table>");
				     	}
				   }
				   else
				   {
					   sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000'  cellspacing ='1px'>"); 
					   sb.append("<tr>");
					   sb.append("<td colspan='4'  CLASS='multiControl' ><DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED CR NO </div>" + "</TD>");
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
		  { 
		  }	
		return sb.toString();
	}	
	
	public static String getAccountDetailsHLPBS(String strAcctNo,String strChkBoxComboValue,String strHospCode) 
	{
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
		StringBuffer sb = new StringBuffer("");
	    voObj.setStrValue1(strAcctNo);
	    voObj.setStrValue2(strHospCode);
	   
	    try 
	    {
		     boObj.getAccountDtlAcctNo(voObj);
		 	 String[] strValue = strChkBoxComboValue.split("\\@");
		 	 String  strChkVal = strValue[0];
		 	 String  strComboVal = strValue[1];
		 	 WebRowSet ws = voObj.getGblWs3();
		    if(voObj.getStrMsgType().equals("0"))
			{
				 if (ws != null) 
				 {					 
					if(ws.next()) 
					{
							String strAcctOpngDate = ws.getString(2);
					
							String strTreatmentCatg =	ws.getString(24);
							String strAddmnNo = 		ws.getString(4);
							String strAddmnDate = ws.getString(5);
							String strDeptName =			ws.getString(6);
							String strWardName =		ws.getString(7);
							String strAccountNo =		ws.getString(8);
							String strAccountType =		ws.getString(22);
							String strClientName  = ws.getString(10);
							String strApprovalNo  = ws.getString(11);
							String strSancAmt     = HisUtil.getAmountWithDecimal(ws.getString(7),2);
							String strPatientRecdAmt = HisUtil.getAmountWithDecimal(ws.getString(8),2);

							
							String strTariffNetAmt  = HisUtil.getAmountWithDecimal(ws.getString(10),2);
							
							String BalanceAmt   =  ws.getString(15);
							String finalBillFlag= ws.getString(27);
							String strRoomLimit= ws.getString(28);
							String strAvailedPackageId= ws.getString(29);
							String strAvailedPackageName= ws.getString(30);
				
							
							
												
							if(strTreatmentCatg == null) strTreatmentCatg = "";
							if(strAddmnNo == null) strAddmnNo = "";
							if(strAddmnDate == null) strAddmnDate = "";
							if(strDeptName == null) strDeptName = "";
							if(strWardName == null) strWardName = "";
							if(strAccountNo == null) strAccountNo = "";
							if(strAccountType == null) strAccountType = "";
							if(strClientName == null) strClientName = "";
							if(strApprovalNo == null) strApprovalNo = "";
							if(strSancAmt == null) strSancAmt = "";
							if(strPatientRecdAmt == null) strPatientRecdAmt = "";
							if(strTariffNetAmt == null) strTariffNetAmt = "";
							
							sb.append("<input type='hidden' name='strChkVal' value="+strChkVal+">");
							sb.append("<input type='hidden' name='strComboVal' value="+strComboVal+">");
							sb.append("<input type='hidden' name='strAcctNo' value="+strAcctNo+">");
							sb.append("<input type='hidden' name='strActOpenDate' value="+strAcctOpngDate+">");	
							sb.append("<input type='hidden' name='strActHLPHid' value="+ws.getString(25)+">");
							sb.append("<input type='hidden' name='strAcctDtlBalanceAmt' value="+ws.getString(10)+">");
							sb.append("<input type='hidden' name='strTreatmentCategory' value="+ws.getString(26)+">");
							sb.append("<input type='hidden' name='finalBillFlag' value="+finalBillFlag+">");
							sb.append("<input type='hidden' name='strRoomLimit' value="+strRoomLimit+">");
							sb.append("<input type='hidden' name='strRoomLimit' value="+strRoomLimit+">");
							sb.append("<input type='hidden' name='strAvailedPackageId' value="+strAvailedPackageId+">");
							
										
							sb.append("<div class='row rowFlex reFlex'>");
							sb.append("<div class='col-sm-3'><label>Account No/Account Type:</label></div>");
							sb.append("<div class='col-sm-3' name='strAcctNoAcctTyp'><label style='text-transform:uppercase;'>"+strAcctNo+"/"+strAccountType+"</label></div>");
							sb.append("<div  class='col-sm-3'><label>Opening Date:</label></div>");	
							sb.append("<div class='col-sm-3' name='strAcctOpngDate'><label>"+strAcctOpngDate+"</label></div>");								
							sb.append("</div>");
										
										
							sb.append("<div class='row rowFlex reFlex'>");
							sb.append("<div class='col-sm-3'><label>Account Category:</label></div>");
							sb.append("<div class='col-sm-3' name='strTreatmentCatg'><label>"+strTreatmentCatg+"</label></div>");
							sb.append("<div class='col-sm-3'><label>Balance(-)/Payble(+) Amt:</label></div>");
							sb.append("<div class='col-sm-3'");
							sb.append("<input name='strAccountBalanceAmt' type='hidden' class='txtFldMin' value='"+HisUtil.getAmountWithDecimal(BalanceAmt,2)+"'>");
							sb.append("<i class='fas fa-rupee-sign'></i>&nbsp;"+HisUtil.getAmountWithDecimal(BalanceAmt,2)+"");									
							sb.append("<input name='strSancAmt' type='hidden' value='"+strSancAmt+"'>");
							sb.append("<input name='strTariffNetAmt' type='hidden' value='"+strTariffNetAmt+"'>");
							sb.append("<input name='strAcctOpngDate' type='hidden' value='"+strAcctOpngDate+"'>");
							sb.append("</div>");
							sb.append("</div>");
	
							sb.append("<div class='row rowFlex reFlex'>");
							sb.append("<div class='col-sm-3'><label>Room Eligibility:</label></div>");
							sb.append("<div class='col-sm-3' name='strRoomLimitTd'><i class='fas fa-rupee-sign'></i>&nbsp;<label>"+strRoomLimit+"</label></div>");		
							sb.append("<div  class='col-sm-3'><label>Package:</label></div>");
							sb.append("<div class='col-sm-3' name='strAvailedPackageId'><label>"+strAvailedPackageName+"</label></div>");
							sb.append("</div>");
						}
				   }
				   else
				   {
					   sb.append("<DIV class='alert alert-danger'>NO RECORD FOUND FOR SELECTED CR NO!...</div>");					   	
				   }  
			    }
		        else
	     	    {
	     		   String err = voObj.getStrMsgString();   
				   sb.append("ERROR####"+err);  
	     	    }	
	      }
		  catch (Exception e)
		  { 
		  }	
		return sb.toString();
	}
}
