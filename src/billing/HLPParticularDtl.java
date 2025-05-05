package billing;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;

import billing.CashCollectionOnlineTransVO;

public class HLPParticularDtl
{
   public static String getParticularDtl(String strAcctNo,String strHospCode) 
	{
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
	    voObj.setStrValue1(strAcctNo);
	    voObj.setStrValue2(strHospCode);
	    
	    // Declaring Variables
	//    int rowSize = 0,TotalExpAmt=0,size=0,TotalDisAmt=0,TotalServiceTaxAmt=0,NetAmt=0,CltAmt=0,DisNetAmt=0,FinalDisAmt=0,MaxBenifitAmt=0;
	    
	/*	String strTotalDisAmt = null;
		String strDiscNetAmt  = null;
		String strTotalServiceTax = null;
		String strClientAmt = null;
		String strTotalRecvdAmt = null;
		String strMaxBenifitFrmCleint = null;*/
		
		/*Variable Show in Bottom Line*/
		
		String strTotalExpAmt  = null; 
		String strPaidByPatient = null;
		String strPaidByClient  = null;
		String strNetPaybleAmt = null;
		
		
		
		StringBuffer sb = new StringBuffer("");
         
        StringBuffer sb1 = new StringBuffer("");
        StringBuffer sb2 = new StringBuffer("");
        StringBuffer sb3 = new StringBuffer("");
        StringBuffer sb11 = new StringBuffer("");
	       
        try
		{ 
         boObj.getParticularDtl(voObj);
 	     boObj.getAccountDtlAcctNo(voObj);
 	     boObj.getAllAmtForViewBill(voObj);
 	     
         if(voObj.getStrMsgType().equals("0"))
		 {
       
           WebRowSet ws = voObj.getGblWs2();
      //     WebRowSet ws1 = voObj.getGblWs3();
        
           WebRowSet ws2 = voObj.getGblWs1();
           
                      	       
	  	   sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>"); 
		   sb.append("<tr><td width='5%' class='multiLabel'>SNo</td>");
		   sb.append("<td width='20%' class='multiLabel'>Particulars</td>");
		   sb.append("<td width='15%' class='multiLabel'>Total Amt(<img src='../../hisglobal/images/INR.png'>)</td>");
		   sb.append("<td width='15%' class='multiLabel'>Discount Amt(<img src='../../hisglobal/images/INR.png'>)</td>");
		   sb.append("<td width='15%' class='multiLabel'>Penelty(<img src='../../hisglobal/images/INR.png'>)</td>");
		   sb.append("<td width='15%' class='multiLabel'>Service Tax Amt(<img src='../../hisglobal/images/INR.png'>)</td>");    //New Vale Added 1/7/08
		   sb.append("<td width='15%' class='multiLabel'>Details</td></tr></table>");
		   
	
		if (ws != null) 
		  {
		    /*  while(ws1.next())
	           {

	        	//   String[] id = ws1.getString(25).split("\\^");
	        	//   strClientAmt = id[2];
	        	//   strDiscNetAmt = id[3];
	        	   
	           }*/
		      while(ws2.next())
		      {		    	  
		    	  /*
		           SELECT 
		           NVL(HBLNUM_PATIENT_RECD_AMT,0), 
		           NVL(HBLNUM_CLIENT_AMT,0),
		           NVL(HBLNUM_TARIFF_NET_AMT,0),
				   (NVL(HBLNUM_TARIFF_NET_AMT,0) - NVL(HBLNUM_CLIENT_AMT,0) - NVL(HBLNUM_PATIENT_RECD_AMT,0))	AS balance   
			 	 */
		    	   strTotalExpAmt   = ws2.getString(3); 
		  		   strPaidByPatient = ws2.getString(1);;
		  		   strPaidByClient  = ws2.getString(2);;
		  		   strNetPaybleAmt  = ws2.getString(4);;
		    	  
		    	  
		      }
				//	rowSize = ws.size();
					String strParticular = null;
					String strTotalAmt = null;
					String strDisAmt = null;
					String strPenelty = null;
					String strSeviceTaxAmt = null;
				//	String strDummy = null;
				//	String strMaxBeniftAmt = null;
					
					for(int i=0;ws.next();i++)
                    {
//						System.out.println("Grp Name ->"+ws.getString(1));
//						System.out.println("Total Amt->"+ws.getString(2));
//						System.out.println("Total Service Amt->"+ws.getString(3));
//						System.out.println("Total Discount->"+ws.getString(4));
//						System.out.println("Total Penelty->"+ws.getString(5));
//						System.out.println("Net Amt->"+ws.getString(6));
//						System.out.println("Grp ID->"+ws.getString(7));
						
						sb11.append(ws.getString(7)+"^"+ws.getString(2)+"@");
						
						sb1.append(ws.getString(2)+"^");  //  Total Amt
						sb2.append(ws.getString(4)+"@");  //  Total Discount
						sb3.append(ws.getString(6)+"$");  //  Total Serivce Tax 
											
												
						strParticular  = ws.getString(1);
						strTotalAmt  = ws.getString(6);
						strDisAmt  = ws.getString(4);
						strPenelty  = ws.getString(5);
						strSeviceTaxAmt  = ws.getString(2);
				
     				   	if(strParticular == null || strParticular.equals("")) strParticular = "-----";
     				    if(strTotalAmt == null || strTotalAmt.equals("")) strTotalAmt = "-----";
     				    if(strDisAmt == null || strDisAmt.equals("")) strDisAmt = "-----";
     				    if(strPenelty == null || strPenelty.equals("")) strPenelty = "-----";
     				    if(strSeviceTaxAmt == null || strSeviceTaxAmt.equals("")) strSeviceTaxAmt = "-----";
     				   	
     				   // sb.append("<input type='hidden' name='strGrpId'  value='"+ws.getString(7)+"'>");	
     				  
     				    sb.append("<input type='hidden' name='flag'  value='"+0+"'>");	
     				    sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
						sb.append("<tr>");
						sb.append("<td width='5%' class='multiControl'><b>");
						sb.append(i+1);
						sb.append("</b></td>");
						sb.append("<td width='20%' class='multiControl'>");
						sb.append(strParticular);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append(strTotalAmt);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append(strDisAmt);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append(strPenelty);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append(strSeviceTaxAmt);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append("<input type='hidden' name='flagConfig' id='delindex"+i+"' value='"+0+"'>");
						sb.append("<img bgColor='white' value='"+i+"' src='../../hisglobal/images/viewDetails.gif' style='cursor:hand;cursor:pointer;' onClick='getParticularsDetails(this,"+ws.getString(7)+","+strAcctNo+","+i+");'>");
						sb.append("</td></tr></table>");
						sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
						sb.append("<tr><td><div id='particularDtlsId"+i+"' style='display:none'></div></td></tr>");
						sb.append("</table>");
					//	sb.append("<input type='hidden' name='currId'  value='0'>");
				    }
					
					sb.append("<input type='hidden' name='currId'  value='-1'>");
					sb.append("<input type='hidden' name='hiddenString'  value='"+sb11.toString()+"'>");
								
					sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
					sb.append("<tr><td width='86%' class='LABEL'><font color='red'>*</font>Expense Amt:</td>");
					sb.append("<td width='14%' class='CONTROL'>");
					sb.append("<input name='strTotalExpAmt' type='text' class='txtFldMin' value='"+HisUtil.getAmountWithDecimal(strTotalExpAmt,2)+"' disabled='disabled'>");
					sb.append("&nbsp;Rs</td></tr>");
					
					
					sb.append("<tr><td width='86%' class='LABEL'><font color='red'>*</font>Paid By Patient:</td>");
					sb.append("<td width='14%' class='CONTROL'>");
					sb.append("<input name='strPaidByPatient' id='strPaidByPatient' type='text' class='txtFldMin' value='"+HisUtil.getAmountWithDecimal(strPaidByPatient,2)+"' disabled='disabled'>");
					sb.append("&nbsp;Rs</td></tr>");
					
					
					sb.append("<tr><td width='86%' class='LABEL'><font color='red'>*</font>Paid By Client:</td>");
					sb.append("<td width='14%' class='CONTROL'>");
					sb.append("<input name='strPaidByClient' id='strPaidByClient' type='text' class='txtFldMin' value='"+HisUtil.getAmountWithDecimal(strPaidByClient,2)+"' disabled='disabled'>");
					sb.append("&nbsp;Rs</td></tr>");
		          
											
					sb.append("<tr><td width='86%' class='LABEL'><font color='red'>*</font>Net Payble Amt:</td>");
					sb.append("<td width='14%' class='CONTROL'>");
					sb.append("<input name='strNetPaybleAmt' type='text' class='txtFldMin' value='"+HisUtil.getAmountWithDecimal(strNetPaybleAmt,2)+"' disabled='disabled'>");
				    sb.append("&nbsp;Rs</td></tr></table>");
		 	}
		   else
		   {
			   sb.append("<table class='TABLEWIDTH' align='center'   bgcolor='#000000' border='0' cellpadding='1px' cellspacing ='1px'>"); 
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
            {
				
			}
		
		 
		return sb.toString();
	}
   
   public static String getParticularDtl1(String strAcctNo,int j,String strHospCode) 
	{
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
	    voObj.setStrValue1(strAcctNo);
	    voObj.setStrValue2(strHospCode);
	    
	    // Declaring Variables
	  /*  int rowSize = 0,TotalExpAmt=0,size=0,TotalDisAmt=0,TotalServiceTaxAmt=0,NetAmt=0,CltAmt=0,DisNetAmt=0,FinalDisAmt=0,MaxBenifitAmt=0;
	    
		String strTotalDisAmt = null;
		String strDiscNetAmt  = null;
		String strTotalServiceTax = null;
		String strClientAmt = null;
		String strTotalRecvdAmt = null;
		String strMaxBenifitFrmCleint = null;*/
		
		/*Variable Show in Bottom Line*/
		
		String strTotalExpAmt  = null; 
		String strPaidByPatient = null;
		String strPaidByClient  = null;
		String strNetPaybleAmt = null;
		
		
		
		StringBuffer sb = new StringBuffer("");
        
       StringBuffer sb1 = new StringBuffer("");
       StringBuffer sb2 = new StringBuffer("");
       StringBuffer sb3 = new StringBuffer("");
       StringBuffer sb11 = new StringBuffer("");
	       
       try
		{ 
        boObj.getParticularDtl(voObj);
	     boObj.getAccountDtlAcctNo(voObj);
	     boObj.getAllAmtForViewBill(voObj);
	     
        if(voObj.getStrMsgType().equals("0"))
		 {
      
          WebRowSet ws = voObj.getGblWs2();
       //   WebRowSet ws1 = voObj.getGblWs3();
       
          WebRowSet ws2 = voObj.getGblWs1();
          
                     	       
	  	   sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>"); 
		   sb.append("<tr><td width='5%' class='multiLabel'>SNo</td>");
		   sb.append("<td width='20%' class='multiLabel'>Particulars</td>");
		   sb.append("<td width='15%' class='multiLabel'>Total Amt(<img src='../../hisglobal/images/INR.png'>)</td>");
		   sb.append("<td width='15%' class='multiLabel'>Discount Amt(<img src='../../hisglobal/images/INR.png'>)</td>");
		   sb.append("<td width='15%' class='multiLabel'>Penelty(<img src='../../hisglobal/images/INR.png'>)</td>");
		   sb.append("<td width='15%' class='multiLabel'>Service Tax Amt(<img src='../../hisglobal/images/INR.png'>)</td>");    //New Vale Added 1/7/08
		   sb.append("<td width='15%' class='multiLabel'>Details</td></tr></table>");
		   
	
		if (ws != null) 
		  {
		     /* while(ws1.next())
	           {

	        	   String[] id = ws1.getString(25).split("\\^");
	        	 //  strClientAmt = id[2];
	        	 //  strDiscNetAmt = id[3];
	        	   
	           }*/
		      while(ws2.next())
		      {		    	  
		    	  /*
		           SELECT 
		           NVL(HBLNUM_PATIENT_RECD_AMT,0), 
		           NVL(HBLNUM_CLIENT_AMT,0),
		           NVL(HBLNUM_TARIFF_NET_AMT,0),
				   (NVL(HBLNUM_TARIFF_NET_AMT,0) - NVL(HBLNUM_CLIENT_AMT,0) - NVL(HBLNUM_PATIENT_RECD_AMT,0))	AS balance   
			 	 */
		    	   strTotalExpAmt   = ws2.getString(3); 
		  		   strPaidByPatient = ws2.getString(1);;
		  		   strPaidByClient  = ws2.getString(2);;
		  		   strNetPaybleAmt  = ws2.getString(4);;
		    	  
		    	  
		      }
				//	rowSize = ws.size();
					String strParticular = null;
					String strTotalAmt = null;
					String strDisAmt = null;
					String strPenelty = null;
					String strSeviceTaxAmt = null;
				//	String strDummy = null;
				//	String strMaxBeniftAmt = null;
					
					for(int i=0;ws.next();i++)
                   {
//						System.out.println("Grp Name ->"+ws.getString(1));
//						System.out.println("Total Amt->"+ws.getString(2));
//						System.out.println("Total Service Amt->"+ws.getString(3));
//						System.out.println("Total Discount->"+ws.getString(4));
//						System.out.println("Total Penelty->"+ws.getString(5));
//						System.out.println("Net Amt->"+ws.getString(6));
//						System.out.println("Grp ID->"+ws.getString(7));
						
						sb11.append(ws.getString(7)+"^"+ws.getString(2)+"@");
						
						sb1.append(ws.getString(2)+"^");  //  Total Amt
						sb2.append(ws.getString(4)+"@");  //  Total Discount
						sb3.append(ws.getString(6)+"$");  //  Total Serivce Tax 
											
												
						strParticular  = ws.getString(1);
						strTotalAmt  = ws.getString(6);
						strDisAmt  = ws.getString(4);
						strPenelty  = ws.getString(5);
						strSeviceTaxAmt  = ws.getString(2);
				
    				   	if(strParticular == null || strParticular.equals("")) strParticular = "-----";
    				    if(strTotalAmt == null || strTotalAmt.equals("")) strTotalAmt = "-----";
    				    if(strDisAmt == null || strDisAmt.equals("")) strDisAmt = "-----";
    				    if(strPenelty == null || strPenelty.equals("")) strPenelty = "-----";
    				    if(strSeviceTaxAmt == null || strSeviceTaxAmt.equals("")) strSeviceTaxAmt = "-----";
    				   	
    				   // sb.append("<input type='hidden' name='strGrpId'  value='"+ws.getString(7)+"'>");	
    				  
    				    sb.append("<input type='hidden' name='flag'  value='"+0+"'>");	
    				    sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
						sb.append("<tr>");
						sb.append("<td width='5%' class='multiControl'><b>");
						sb.append(i+1);
						sb.append("</b></td>");
						sb.append("<td width='20%' class='multiControl'>");
						sb.append(strParticular);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append(strTotalAmt);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append(strDisAmt);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append(strPenelty);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append(strSeviceTaxAmt);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append("<input type='hidden' name='flagConfig' id='delindex"+i+"' value='"+0+"'>");
						sb.append("<img bgColor='white' value='"+i+"' src='../../hisglobal/images/viewDetails.gif' style='cursor:hand;cursor:pointer;' onClick='getParticularsDetails(this,"+ws.getString(7)+","+strAcctNo+","+i+");'>");
						sb.append("</td></tr></table>");
						sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
						sb.append("<tr><td><div id='particularDtlsId"+i+"' style='display:none'></div></td></tr>");
						sb.append("</table>");
					//	sb.append("<input type='hidden' name='currId'  value='0'>");
				    }
					
					sb.append("<input type='hidden' name='currId'  value='-1'>");
					sb.append("<input type='hidden' name='hiddenString'  value='"+sb11.toString()+"'>");
								
					sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
					sb.append("<tr><td width='86%' class='LABEL'><font color='red'>*</font>Expense Amt:</td>");
					sb.append("<td width='14%' class='CONTROL'>");
					sb.append("<input name='strTotalExpAmt' type='text' class='txtFldMin' value='"+HisUtil.getAmountWithDecimal(Double.parseDouble(strTotalExpAmt),2)+"' disabled='disabled'>");
					sb.append("&nbsp;Rs</td></tr>");
					
					
					sb.append("<tr><td width='86%' class='LABEL'><font color='red'>*</font>Paid By Patient:</td>");
					sb.append("<td width='14%' class='CONTROL'>");
					sb.append("<input name='strPaidByPatient' id='strPaidByPatient' type='text' class='txtFldMin' value='"+HisUtil.getAmountWithDecimal(Double.parseDouble(strPaidByPatient),2)+"' disabled='disabled'>");
					sb.append("&nbsp;Rs</td></tr>");
					
				//	System.out.println("Value of j:::::"+j);
					
					if(j!=1)
		            {	
						sb.append("<tr><td width='86%' class='LABEL'><font color='red'>*</font>Paid By Client:</td>");
						sb.append("<td width='14%' class='CONTROL'>");
						sb.append("<input name='strPaidByClient' id='strPaidByClient' type='text' class='txtFldMin' value='"+HisUtil.getAmountWithDecimal(Double.parseDouble(strPaidByClient),2)+"' disabled='disabled'>");
						sb.append("&nbsp;Rs</td></tr>");
		            }  
											
					sb.append("<tr><td width='86%' class='LABEL'><font color='red'>*</font>Net Payble Amt:</td>");
					sb.append("<td width='14%' class='CONTROL'>");
					sb.append("<input name='strNetPaybleAmt' type='text' class='txtFldMin' value='"+HisUtil.getAmountWithDecimal(Double.parseDouble(strNetPaybleAmt),2)+"' disabled='disabled'>");
				    sb.append("&nbsp;Rs</td></tr></table>");
		 	}
		   else
		   {
			   sb.append("<table class='TABLEWIDTH' align='center'   bgcolor='#000000' border='0' cellpadding='1px' cellspacing ='1px'>"); 
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
           {
				
			}
		
		 
		return sb.toString();
	}
   
   
	
   public static String getParticularDtl(String strAcctNo, String strHospCode,String strReqNo, String strChargeTypeId,String strClientBalanceAmt,CashCollectionOnlineTransVO voOnline) throws Exception 
   {
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
		voObj.setStrValue1(strAcctNo);
		voObj.setStrValue2(strHospCode);
		voObj.setStrValue3(strReqNo);
		voObj.setStrValue4(strChargeTypeId);

		String strDefaultGroupId = BillConfigUtil.GROUP_ID_DEPOSIT;

		StringBuffer sb = new StringBuffer("");

		StringBuffer sb1 = new StringBuffer("");
		StringBuffer sb2 = new StringBuffer("");
		StringBuffer sb3 = new StringBuffer("");
		StringBuffer sb11 = new StringBuffer("");

		
		String strTariffRate = "0";
		String strDiscountUnit = "0";
		String strDiscountType = "0";
		String strDiscountApprovalId = "0";
		String strServiceTax = "0";
		String strQty = "0";
		String strQtyBaseVal = "0";
		String strRateBaseVal = "0";
		String strClientRule = "0";
		String strPatRecvdAmount = "0";

		String tariff_cost="0";
		String to_be_payable_cost="0";
		String net_amount_paid="0";
		String strClientTariifNames="";
		String strRoomLimit="0";
		String totalRoomRent="0";
		String totalRoomDays="0";
		String elegibleRoomLimitPerDay="0";
		
		float fltRate = 0;
		float fltClientBalanceAmt = 0;
		float fltClientAmount = 0;
		float fltDiscountUnit = 0;
		float fltDiscountAmt = 0;
		float fltServiceTax = 0;
		float fltServiceTaxAmt = 0;
		float fltNetAmount = 0;//Net Amount is Amount To Be adjusted (refunded or payable)
		float fltQty = 0;
		float fltQtyRateVal = 0;
		float fltRateBaseVal = 0;
		float fltClientRule = 0;
		float fltPatRecvdAmount = 0;
		float fltDiffPayableByPat=0;
		float fltRoomLimitDiff=0;
		float fltRemainingDiffAfterClientRule=0;

		try 
		{
			boObj.getClientChargeTrfDtl(voObj);
			WebRowSet ws3 = voObj.getGblWs2();//Taken In New Variable Because In next Method getParticularDtl Same Webrowset Object is being used
			
			boObj.getParticularDtl(voObj);
			if(strReqNo!=null && !strReqNo.equals("0"))
			boObj.getRateDetails(voObj);
			
			//For Handling CGHS Stent & Other Surgeries As per eligibility( CGHS Gives Stent Rates As 23628 But NIMS Charges 32000 Rs.) 
			for(int i=0;ws3.next();i++)
		    { 		
			    tariff_cost=ws3.getString(1) ;//Actual Defined In Charge Mst
			    to_be_payable_cost=ws3.getString(2) ;//Payable at NIMS for Client
			    net_amount_paid=ws3.getString(3) ;//Actual Paid by Patient Generally equal to tariff_cost
			    
			    if(Float.parseFloat(net_amount_paid)>Float.parseFloat(to_be_payable_cost))//Actual Cost is Greater Than Payable Cost By Client  Then Remaining Difference Will Be Paid By Patient//Simply Means CLient Pays Less Amount But Actual Cost is higher Then remain diff paid by patient
			    {
			    	fltDiffPayableByPat=fltDiffPayableByPat+(Float.parseFloat(net_amount_paid)-Float.parseFloat(to_be_payable_cost));
			    	if(i==0)
			    		strClientTariifNames=ws3.getString(4)+"["+to_be_payable_cost+"]";
			    	else
			    		strClientTariifNames=strClientTariifNames+", "+ws3.getString(4)+"["+to_be_payable_cost+"]";
			    }
		    }
			boObj.getRoomTrfDtl(voObj);//To Check Whether Room Limit Defined For Patient. If defined what is the difference amount between room limit and actual room rent occupied by patient
			WebRowSet ws4 = voObj.getGblWs4();
			if (ws4.next()) 
			{
				totalRoomRent=ws4.getString(1);
				totalRoomDays=ws4.getString(2);
				elegibleRoomLimitPerDay=ws4.getString(3);
				
				if(Float.parseFloat(elegibleRoomLimitPerDay)>0)
				{
					if(Float.parseFloat(elegibleRoomLimitPerDay)*Float.parseFloat(totalRoomDays)<Float.parseFloat(totalRoomRent))//Room Limit Total Less Than Actuarl Room Rent Taken For totalRoomDays
					{
						fltRoomLimitDiff=Float.parseFloat(totalRoomRent)-Float.parseFloat(elegibleRoomLimitPerDay)*Float.parseFloat(totalRoomDays);//Difference To Be Paid by Patient
					}
				}
			}			
			
			if (voObj.getStrMsgType().equals("0")) 
			{
				WebRowSet ws2 = voObj.getGblWs1();
				
				if (ws2!=null && ws2.next()) 
				{
					strQty = ws2.getString(11);
					strDiscountApprovalId = ws2.getString(6);
					strTariffRate = ws2.getString(13);
					strDiscountUnit = ws2.getString(14);
					strDiscountType = ws2.getString(15);
					strServiceTax = ws2.getString(21);
					strRateBaseVal = ws2.getString(25);
					strQtyBaseVal = ws2.getString(26);
					strClientRule=ws2.getString(33);
					strPatRecvdAmount=ws2.getString(34);
				}

				fltRate = Float.parseFloat(strTariffRate);//Total Tariff Cost
				fltClientBalanceAmt = Float.parseFloat(strClientBalanceAmt);
				fltDiscountUnit = Float.parseFloat(strDiscountUnit);
				fltServiceTax = Float.parseFloat(strServiceTax);
				fltQty = Float.parseFloat(strQty);
				fltQtyRateVal = Float.parseFloat(strQtyBaseVal);
				//fltRateBaseVal = Float.parseFloat(strRateBaseVal);
				fltClientRule=Float.parseFloat(strClientRule);
				fltPatRecvdAmount=Float.parseFloat(strPatRecvdAmount);

				fltNetAmount = fltRate;//First Net Amount is  Total Tariff Cost
				
				if (fltNetAmount > 0 && fltDiscountUnit > 0) 
				{
					if (strDiscountType.equals("1")) 
					{
						fltDiscountAmt = fltDiscountUnit;
					} 
					else 
					{
						fltDiscountAmt = fltRate * (fltDiscountUnit / 100.00f);
					}
				}
				
				fltDiscountAmt = Float.parseFloat(HisUtil.getAmountWithDecimal((0 - (fltDiscountAmt)), 2));
				
				fltNetAmount = fltNetAmount + (fltDiscountAmt);//Net Amount=Total Tariff Cost+Discount(Discount Being -Ve)
				
				if (fltServiceTax > 0) 
				{
					fltServiceTaxAmt = (fltNetAmount)* (fltServiceTax / 100.00f);
				}
				
				fltServiceTaxAmt = Float.parseFloat(HisUtil.getAmountWithDecimal(fltServiceTaxAmt,2));
				
				fltNetAmount = fltNetAmount + fltServiceTaxAmt;//Net Amount=Total Tariff Cost+Discount(Discount Being -Ve)+Service Tax
				fltNetAmount = Float.parseFloat(HisUtil.getAmountWithDecimal(fltNetAmount,2));
				if(fltRoomLimitDiff>0)//Room Limit Total Difference Defined For Patient. Paid By Patient
					fltNetAmount=fltNetAmount-fltRoomLimitDiff;
				
				if (fltClientBalanceAmt > 0) // If Client Balance is present. Here the client balance is client sanctioned amount.
				{
					if(fltClientRule>0)
					{
					    if (fltClientBalanceAmt >= Math.round(fltNetAmount*fltClientRule/100)) // If Client Balance is Greater Than Total Expenditure Cost(Tariff-Discount+S.Tax) Then Client Amount is Total Expenditure Cost
					    {
							fltClientAmount = Math.round(fltNetAmount*fltClientRule/100);//							
						    fltNetAmount=Math.round(fltNetAmount*(100-fltClientRule)/100);
						    fltRemainingDiffAfterClientRule=fltNetAmount;
						    
						}
					    else
					    {
					    	fltClientAmount = fltClientBalanceAmt;//Else Client Balance
							fltNetAmount = fltNetAmount - fltClientAmount;//Now if all the payment given by client the Net Amount will be zero otherwise Net Amount-Client Amount
					    }
					}
					else
					{
						if (fltClientBalanceAmt >=fltNetAmount)
						{
							fltClientAmount = fltNetAmount;//
							fltNetAmount = fltNetAmount - fltClientAmount;
						}
						else
					    {
					    	fltClientAmount = fltClientBalanceAmt;//Else Client Balance
							fltNetAmount = fltNetAmount - fltClientAmount;//Now if all the payment given by client the Net Amount will be zero otherwise Net Amount-Client Amount
					    }
					} 
					/*else 
					{
						//if(fltClientRule>0)
						//{
							fltClientAmount = fltClientBalanceAmt;//Else Client Balance
							fltNetAmount = fltNetAmount - fltClientAmount;//Now if all the payment given by client the Net Amount will be zero otherwise Net Amount-Client Amount*/
						//}
						/*else
						{
							fltClientAmount = Math.round(fltClientBalanceAmt*fltClientRule/100);//Else Client Balance
							fltNetAmount = fltNetAmount - fltClientAmount;
						}	*/
					//}
					/*if(fltClientRule>0)
						fltNetAmount=Math.round(fltNetAmount*(100-fltClientRule)/100);
					else
						fltNetAmount = fltNetAmount - fltClientAmount;//Now if all the payment given by client the Net Amount will be zero otherwise Net Amount-Client Amount*/
					
				} 
				else 
				{
					fltClientAmount = 0;
				}
				
				/*if (fltPatRecvdAmount > 0) // If Patient Given Amount is present
				{
					fltNetAmount=fltNetAmount-fltPatRecvdAmount;
				}*/
				
				
				//System.out.println("fltNetAmount = " + fltNetAmount);
				WebRowSet ws = voObj.getGblWs2();

				sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
				sb.append("<tr><td width='3%' class='multiLabel'>SNo</td>");
				sb.append("<td width='45%' class='multiLabel'>Particulars</td>");
				sb.append("<td width='12%' class='multiLabel'>Discount Amt(<img src='../../hisglobal/images/INR.png'>)</td>");
				sb.append("<td width='12%' class='multiLabel'>Penelty(<img src='../../hisglobal/images/INR.png'>)</td>");
				sb.append("<td width='12%' class='multiLabel'>Service Tax Amt(<img src='../../hisglobal/images/INR.png'>)</td>"); 
				sb.append("<td width='16%' class='multiLabel'>Total Amt(<img src='../../hisglobal/images/INR.png'>)</td>");
				sb.append("<td width='5%' class='multiLabel'>Details</td>");
				sb.append("</tr></table>");

				if (ws != null) 
				{
					String strParticular = null;
					String strTotalAmt = null;
					double strTotalAmtDiv = 0;
					//String strRecdAmt = "0";
					String strDisAmt = null;
					String strPenelty = null;
					String strSeviceTaxAmt = null;
					String strGroupId = "0";

					for (int i = 0; ws.next(); i++) 
					{
						sb11.append(ws.getString(7) + "^" + ws.getString(2)+ "@");

						sb1.append(ws.getString(2) + "^"); // Total Amt
						sb2.append(ws.getString(4) + "@"); // Total Discount
						sb3.append(ws.getString(6) + "$"); // Total Serivce Tax

						strParticular = ws.getString(1);
						strTotalAmt = ws.getString(6);
						strDisAmt = ws.getString(4);
						strPenelty = ws.getString(5);
						strSeviceTaxAmt = ws.getString(3);
						strTotalAmtDiv=Double.parseDouble(strTotalAmt);

						
						strGroupId = ws.getString(7);
						
						if(strGroupId.equals(strDefaultGroupId) && strTotalAmtDiv!=0)
							strTotalAmtDiv=strTotalAmtDiv*-1;
						
						if (strParticular == null || strParticular.equals(""))
							strParticular = "-----";
						if (strTotalAmt == null || strTotalAmt.equals(""))
						{
							strTotalAmt = "-----";
							strTotalAmtDiv=0;
						}
						if (strDisAmt == null || strDisAmt.equals(""))
							strDisAmt = "-----";
						if (strPenelty == null || strPenelty.equals(""))
							strPenelty = "-----";
						if (strSeviceTaxAmt == null
								|| strSeviceTaxAmt.equals(""))
							strSeviceTaxAmt = "-----";

						// sb.append("<input type='hidden' name='strGrpId'
						// value='"+ws.getString(7)+"'>");

						sb.append("<input type='hidden' name='flag'  value='"+ 0 + "'>");
						sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
						sb.append("<tr>");
						sb.append("<td width='3%' class='multiControl'><b>");
						sb.append(i + 1);
						sb.append("</b></td>");
						sb.append("<td width='45%' class='multiControl'><div align='left'>");
						sb.append(strParticular);
						sb.append("<div></td>");
						sb.append("<td width='12%' class='multiControl'>");
						sb.append(strDisAmt);

						sb.append("</td>");
						sb.append("<td width='12%' class='multiControl'>");
						sb.append(strPenelty);
						sb.append("</td>");
						sb.append("<td width='12%' class='multiControl'>");
						sb.append(strSeviceTaxAmt);
						sb.append("</td>");
						sb.append("<td width='16%' class='multiControl'>");

						/*///fltNetAmount -TOTAL REMAINING TARIFF COST  AFTER DEDUCTION FROM CLIENT AMOUNT(EITHER 80% RULE OR 100%-DEPENDING UPON CLIENT/COMPANY) 
						if (strDefaultGroupId.equals(strGroupId.trim()) && fltClientAmount<=0) //If Client Amount Is Not Present
						{							
						//	System.out.println("strTotalAmt = " + strTotalAmt);
							fltNetAmount = Float.parseFloat(HisUtil.getAmountWithDecimal(fltNetAmount + Float.parseFloat(strTotalAmt),2));
						//	System.out.println("fltNetAmount = " + fltNetAmount);
						}*/ //Not Required since it is handled above.
						
						
						sb.append(strTotalAmtDiv);
						sb.append("</td>");
						sb.append("<td width='5%' class='multiControl'>");
						sb.append("<input type='hidden' name='flagConfig' id='delindex"+ i + "' value='" + 0 + "'>");
						sb.append("<img bgColor='white' value='"+ i+ "' src='../../hisglobal/images/viewDetails.gif' style='cursor:hand;cursor:pointer;' onClick='getParticularsDetails(this,"+ ws.getString(7) + "," + strAcctNo+ "," + i + ");'>");
						sb.append("</td></tr></table>");
						// sb.append("<table class='TABLEWIDTH' align='center'
						// border='0' cellpadding='1px' cellspacing
						// ='1px'><tr><td>");
						sb.append("<div id='particularDtlsId" + i+ "' style='display:none'></div>");
						// sb.append("</td></tr></table>");
						// sb.append("<input type='hidden' name='currId'
						// value='0'>");

					}
					if(fltRoomLimitDiff>0)//Room Limit Total Difference Defined For Patient. Paid By Patient
					{
						//if(fltNetAmount==0)
						fltNetAmount=fltNetAmount+fltRoomLimitDiff;
						/*if(fltDiffPayableByPat<=fltRoomLimitDiff)
							fltDiffPayableByPat=0;
						else
							fltDiffPayableByPat=fltDiffPayableByPat-fltRoomLimitDiff;*/
						sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
						sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
						sb.append("<td width='45%' class='multiControlRed'><div align='left'>Room Rent Eligibilty(Per Day)</div></td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='16%' class='multiControlRed'>"+elegibleRoomLimitPerDay+"</td>");
						sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
						
						sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
						sb.append("<td width='45%' class='multiControlRed'><div align='left'>Total Room Rent("+totalRoomDays+" Days)</div></td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='16%' class='multiControlRed'>"+totalRoomRent+"</td>");
						sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
						
						sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
						sb.append("<td width='45%' class='multiControlRed'><div align='left'>Difference Room Rent Payable By Patient("+totalRoomDays+" Days) (A)</div></td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='16%' class='multiControlRed'>"+fltRoomLimitDiff+"</td>");
						sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
						
					}
					if(fltClientRule>0 || fltDiffPayableByPat>0)
					{
						//fltClientAmount=fltClientAmount-fltDiffPayableByPat;
						sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
						
						/*if (fltClientRule<=0 && fltDiffPayableByPat>0)
							sb.append("<td width='45%' class='multiControlRed'>Client Approved(Tariffs Chargeable To Client)</td>");
						else if (fltClientRule>0 && fltDiffPayableByPat<=0)
							sb.append("<td width='45%' class='multiControlRed'>Client Approved("+fltClientRule+" % of Total Tariff Cost)</td>");
						else
							*/
						if(fltClientRule>0)
						{
							sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
							sb.append("<td width='45%' class='multiControlRed'><div align='left'>Client Approved("+fltClientRule+" % of Total Tariff Cost/Tariffs Chargeable To Client)</div></td>");
							sb.append("<td width='12%' class='multiControl'>0.00</td>");
							sb.append("<td width='12%' class='multiControl'>0.00</td>");
							sb.append("<td width='12%' class='multiControl'>0.00</td>");
							sb.append("<td width='16%' class='multiControlRed'>"+fltClientAmount+"</td>");
							sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
							
							sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
							sb.append("<td width='45%' class='multiControlRed'><div align='left'>Remaining Difference After Client Approved("+(100-fltClientRule)+" % of Total Tariff Cost/Tariffs Chargeable To Client)(B)</div></td>");
							sb.append("<td width='12%' class='multiControl'>0.00</td>");
							sb.append("<td width='12%' class='multiControl'>0.00</td>");
							sb.append("<td width='12%' class='multiControl'>0.00</td>");
							sb.append("<td width='16%' class='multiControlRed'>"+fltRemainingDiffAfterClientRule+"</td>");
							sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
						}
						
						
					
						if (fltClientRule<=0 && fltDiffPayableByPat>0)
						{
							sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
							sb.append("<td width='36%' class='multiControl' title='"+strClientTariifNames+"'><div align='left'>Tariffs Differenece Chargeable To Patient(C)</div></td>");
							sb.append("<td width='45%' class='multiControlRed'  colspan='3'>"+strClientTariifNames+"</td>");
							sb.append("<td width='16%' class='multiControlRed'>"+fltDiffPayableByPat+"</td>");
							sb.append("<td width='5%' class='multiLabel'>#</td></tr>");							
						}						
						
						sb.append("</table>");
					}
					if (fltPatRecvdAmount > 0) // If Patient Given Amount is present
					{
						fltNetAmount=fltNetAmount-fltPatRecvdAmount;
					}
					fltNetAmount=fltNetAmount+fltDiffPayableByPat;//Add All Difference Amount To Be payable By Patient
					sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'><tr>");					
					sb.append("<td class='LABEL' colspan='4' width='50%'>Bill Type</td><td class='CONTROL' width='50%' colspan='3'><select name='strBillType' class='comboNormal'><option value='1'>Consolidated</option><option value='2' selected='selected'>Detailed</option></selected></td>");					
					sb.append("</tr></table>");
					sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'><tr>");					
					sb.append("<td class='LABEL' colspan='4' width='50%' style='display:none;'>Convert Account into Wallet(Only for General/Paid Category Patients)</td><td class='CONTROL' width='50%' colspan='3' style='display:none;'><input type='checkbox' onclick='setwalacc();' name='walacc' id='walacc' value='1'></td>");					
					sb.append("</tr></table>");
					
					if(voOnline!=null)
					{
						sb.append("<input type='hidden' name='currId'  value='-1'>");
						sb.append("<input type='hidden' name='strClientPatientNo'  value='"+voOnline.getStrClientPatientNo()+"'>");
						sb.append("<input type='hidden' name='hiddenString'  value='"+ sb11.toString() + "'>");		
						sb.append("<input type='hidden' name='strRequestBillTariffDetails' value='"+ strDiscountApprovalId +"^"+strDiscountUnit+"^"+strDiscountType+"^"+strServiceTax+ "'>");
						sb.append("<input type='hidden' name='strExpenseAmount' value='"+ fltRate + "'>");
						sb.append("<input type='hidden' name='strNetClientAmount' value='"+ fltClientAmount + "'>");
						sb.append("<input type='hidden' name='strSancAmount' value='"+ voOnline.getStrSancAmount() + "'>");
						sb.append("<input type='hidden' name='strClientBalance' value='"+ voOnline.getStrClientBalance() + "'>");
						sb.append("<input type='hidden' name='strClientAmount' value='"+ voOnline.getStrClientAmount() + "'>");
						sb.append("<input type='hidden' name='strNetDiscountAmount' value='"+ fltDiscountAmt + "'>");
						sb.append("<input type='hidden' name='strNetServiceTaxAmount' value='"+ fltServiceTaxAmt + "'>");
						sb.append("<input type='hidden' name='strNetPaybleAmount' value='"+ fltNetAmount + "'>");
						sb.append("<input type='hidden' name='strPatientRecvdAmount' value='"+ fltPatRecvdAmount + "'>");
					}
				} 
				else 
				{
					sb.append("<table class='TABLEWIDTH' align='center'   bgcolor='#000000' border='0' cellpadding='1px' cellspacing ='1px'>");
					sb.append("<tr>");
					sb.append("<td colspan='5'  CLASS='multiControl' ><div class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED CR NO </div></TD>");
					sb.append("</tr>");
					sb.append("</table>");
					sb.append("</div>");
				}
			} 
			else 
			{
				String err = voObj.getStrMsgString();
				sb.append("ERROR####" + err);
			}

		} catch (Exception e) {
	 
			throw new Exception(e.getMessage());

		}

		return sb.toString();
	}
   
   public static String getParticularDtlForCashCollectionOnline(String strAcctNo, String strHospCode,
			 String strReqNo, String strChargeTypeId,
			String strClientBalanceAmt,String strOperatorVal_p) throws Exception {
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
		voObj.setStrValue1(strAcctNo);
		voObj.setStrValue2(strHospCode);
		voObj.setStrValue3(strReqNo);
		voObj.setStrValue4(strChargeTypeId);

		String strDefaultGroupId = BillConfigUtil.GROUP_ID_DEPOSIT;

		StringBuffer sb = new StringBuffer("");

		StringBuffer sb1 = new StringBuffer("");
		StringBuffer sb2 = new StringBuffer("");
		StringBuffer sb3 = new StringBuffer("");
		StringBuffer sb11 = new StringBuffer("");

		
		String strTariffRate = "0";
		String strDiscountUnit = "0";
		String strDiscountType = "0";
		String strDiscountApprovalId = "0";
		String strServiceTax = "0";
		String strQty = "0";
		String strQtyBaseVal = "0";
		String strRateBaseVal = "0";

		float fltRate = 0;
		float fltClientBalanceAmt = 0;
		float fltClientAmount = 0;
		float fltDiscountUnit = 0;
		float fltDiscountAmt = 0;
		float fltServiceTax = 0;
		float fltServiceTaxAmt = 0;
		float fltNetAmount = 0;
		float fltQty = 0;
		float fltQtyRateVal = 0;
		float fltRateBaseVal = 0;

		try {
			boObj.getParticularDtl(voObj);
			boObj.getRateDetails(voObj);

			// boObj.getAccountDtlAcctNo(voObj);
			// boObj.getAllAmtForViewBill(voObj);

			if (voObj.getStrMsgType().equals("0")) {

				WebRowSet ws2 = voObj.getGblWs1();
				
				if (ws2.next()) {

					strQty = ws2.getString(11);
					strDiscountApprovalId = ws2.getString(12);
					strTariffRate = ws2.getString(13);
					strDiscountUnit = ws2.getString(14);
					strDiscountType = ws2.getString(15);
					strServiceTax = ws2.getString(21);
					strRateBaseVal = ws2.getString(25);
					strQtyBaseVal = ws2.getString(26);
				}

				fltRate = Float.parseFloat(strTariffRate);
				fltClientBalanceAmt = Float.parseFloat(strClientBalanceAmt);
				fltDiscountUnit = Float.parseFloat(strDiscountUnit);
				fltServiceTax = Float.parseFloat(strServiceTax);
				fltQty = Float.parseFloat(strQty);
				fltQtyRateVal = Float.parseFloat(strQtyBaseVal);
				//fltRateBaseVal = Float.parseFloat(strRateBaseVal);

				
				
				fltNetAmount = fltRate;
				
				if (fltNetAmount > 0 && fltDiscountUnit > 0) {

					if (strDiscountType.equals("1")) {

						fltDiscountAmt = fltDiscountUnit;

					} else {

						fltDiscountAmt = fltRate * (fltDiscountUnit / 100.00f);

					}

				}
				
				fltDiscountAmt = Float.parseFloat(HisUtil.getAmountWithDecimal((0 - (fltDiscountAmt)), 2));
				
				fltNetAmount = fltNetAmount + (fltDiscountAmt);
				
				if (fltServiceTax > 0) {

					fltServiceTaxAmt = (fltNetAmount)
							* (fltServiceTax / 100.00f);
				}
				
				fltServiceTaxAmt = Float.parseFloat(HisUtil.getAmountWithDecimal(fltServiceTaxAmt,2));
				
				fltNetAmount = fltNetAmount + fltServiceTaxAmt;
				fltNetAmount = Float.parseFloat(HisUtil.getAmountWithDecimal(fltNetAmount,2));
				
				if (fltClientBalanceAmt > 0) {

					if (fltClientBalanceAmt >= fltNetAmount) {

						fltClientAmount = fltNetAmount;

					} else {

						fltClientAmount = fltClientBalanceAmt;
					}

					fltNetAmount = fltNetAmount - fltClientAmount;

				} else {

					fltClientAmount = 0;
				}
				
				//System.out.println("fltNetAmount = " + fltNetAmount);
				WebRowSet ws = voObj.getGblWs2();

				sb
						.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
				sb.append("<tr><td width='5%' class='multiLabel'>SNo</td>");
				sb
						.append("<td width='20%' class='multiLabel'>Particulars</td>");
				sb
						.append("<td width='15%' class='multiLabel'>Discount Amt(Rs.)</td>");
				sb
						.append("<td width='15%' class='multiLabel'>Penelty(Rs.)</td>");
				sb
						.append("<td width='15%' class='multiLabel'>Service Tax Amt(Rs.)</td>"); // New
																									// Vale
																									// Added
																									// 1/7/08
				sb
						.append("<td width='15%' class='multiLabel'>Total Amt(Rs.)</td>");
				sb.append("<td width='15%' class='multiLabel'>Details</td>");
				sb.append("</tr></table>");

				if (ws != null) {

					String strParticular = null;
					String strTotalAmt = null;
					//String strRecdAmt = "0";
					String strDisAmt = null;
					String strPenelty = null;
					String strSeviceTaxAmt = null;
					String strGroupId = "0";

					for (int i = 0; ws.next(); i++) {

						sb11.append(ws.getString(7) + "^" + ws.getString(2)
								+ "@");

						sb1.append(ws.getString(2) + "^"); // Total Amt
						sb2.append(ws.getString(4) + "@"); // Total Discount
						sb3.append(ws.getString(6) + "$"); // Total Serivce Tax

						strParticular = ws.getString(1);
						strTotalAmt = ws.getString(6);
						strDisAmt = ws.getString(4);
						strPenelty = ws.getString(5);
						strSeviceTaxAmt = ws.getString(3);

						strGroupId = ws.getString(7);
						
						if (strParticular == null || strParticular.equals(""))
							strParticular = "-----";
						if (strTotalAmt == null || strTotalAmt.equals(""))
							strTotalAmt = "-----";
						if (strDisAmt == null || strDisAmt.equals(""))
							strDisAmt = "-----";
						if (strPenelty == null || strPenelty.equals(""))
							strPenelty = "-----";
						if (strSeviceTaxAmt == null
								|| strSeviceTaxAmt.equals(""))
							strSeviceTaxAmt = "-----";

						// sb.append("<input type='hidden' name='strGrpId'
						// value='"+ws.getString(7)+"'>");

						sb.append("<input type='hidden' name='flag'  value='"
								+ 0 + "'>");
						sb
								.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
						sb.append("<tr>");
						sb.append("<td width='5%' class='multiControl'><b>");
						sb.append(i + 1);
						sb.append("</b></td>");
						sb.append("<td width='20%' class='multiControl'>");
						sb.append(strParticular);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append(strDisAmt);

						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append(strPenelty);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb.append(strSeviceTaxAmt);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");

						if (strDefaultGroupId.equals(strGroupId.trim())) {
							
						//	System.out.println("strTotalAmt = " + strTotalAmt);
							fltNetAmount = Float.parseFloat(HisUtil.getAmountWithDecimal(fltNetAmount + Float.parseFloat(strTotalAmt),2));
						//	System.out.println("fltNetAmount = " + fltNetAmount);
						}
						sb.append(strTotalAmt);
						sb.append("</td>");
						sb.append("<td width='15%' class='multiControl'>");
						sb
								.append("<input type='hidden' name='flagConfig' id='delindex"
										+ i + "' value='" + 0 + "'>");
						sb
								.append("<img bgColor='white' value='"
										+ i
										+ "' src='../../hisglobal/images/viewDetails.gif' style='cursor:hand;cursor:pointer;' onClick='getParticularsDetails(this,"
										+ ws.getString(7) + "," + strAcctNo
										+ "," + i + ");'>");
						sb.append("</td></tr></table>");
						// sb.append("<table class='TABLEWIDTH' align='center'
						// border='0' cellpadding='1px' cellspacing
						// ='1px'><tr><td>");
						sb.append("<div id='particularDtlsId" + i
								+ "' style='display:none'></div>");
						// sb.append("</td></tr></table>");
						// sb.append("<input type='hidden' name='currId'
						// value='0'>");

					}

					sb
							.append("<input type='hidden' name='currId'  value='-1'>");
					sb
							.append("<input type='hidden' name='hiddenString'  value='"
									+ sb11.toString() + "'>");
		
					sb
					.append("<input type='hidden' name='strRequestBillTariffDetails' value='"
							+ strDiscountApprovalId +"^"+strDiscountUnit+"^"+strDiscountType+"^"+strServiceTax+ "'>");
					
					sb
							.append("<input type='hidden' name='strExpenseAmount' value='"
									+ fltRate + "'>");
					sb
							.append("<input type='hidden' name='strNetClientAmount' value='"
									+ fltClientAmount + "'>");
					sb
							.append("<input type='hidden' name='strNetDiscountAmount' value='"
									+ fltDiscountAmt + "'>");
					sb
							.append("<input type='hidden' name='strNetServiceTaxAmount' value='"
									+ fltServiceTaxAmt + "'>");
					sb
							.append("<input type='hidden' name='strNetPaybleAmount' value='"
									+ fltNetAmount + "'>");

					sb
					.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'><tr>");
					
					sb.append("<td class='LABEL' colspan='2' width='25%'>Bill Type</td><td class='CONTROL' width='30%' colspan='2'><select name='strBillType' class='comboNormal'><option value='1'>Consolidated</option><option value='2' selected='selected'>Detailed</option></selected></td>");
					//Below line is added by Aadil..modified by NEha Sharma to make Operator mandatory CR 660 PGI
					sb.append("<td class='LABEL' colspan='1' width='15%'>Operator<font color='red'>*</font></td><td class='CONTROL' width='30%' colspan='2'><select id='strOperatorId' name='strOperatorId' class='comboNormal'>"+strOperatorVal_p+"</select></td>");
					sb.append("</tr></table>");
					
				} else {
					sb
							.append("<table class='TABLEWIDTH' align='center'   bgcolor='#000000' border='0' cellpadding='1px' cellspacing ='1px'>");
					sb.append("<tr>");
					sb
							.append("<td colspan='5'  CLASS='multiControl' >"
									+ "<div class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED CR NO </div>"
									+ "</TD>");

					sb.append("</tr>");
					sb.append("</table>");
					sb.append("</div>");

				}
			} else {
				String err = voObj.getStrMsgString();
				sb.append("ERROR####" + err);
			}

		} catch (Exception e) {
	 
			throw new Exception(e.getMessage());

		}

		return sb.toString();
	}
   
   public static String getParticularDtlDiffPayable(String strAcctNo, String strHospCode,String strReqNo, String strChargeTypeId,String strClientBalanceAmt,CashCollectionOnlineTransVO voOnline) throws Exception 
   {
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
		voObj.setStrValue1(strAcctNo);
		voObj.setStrValue2(strHospCode);
		voObj.setStrValue3(strReqNo);
		voObj.setStrValue4(strChargeTypeId);
		StringBuffer sb = new StringBuffer("");
		
		String tariff_cost="0";
		String to_be_payable_cost="0";
		String net_amount_paid="0";
		String strClientTariifNames="";
		String totalRoomRent="0";
		String totalRoomDays="0";
		String elegibleRoomLimitPerDay="0";
		
		float fltNetAmount = 0;//Net Amount is Amount To Be adjusted (refunded or payable)
		float fltDiffPayableByPat=0;
		float fltRoomLimitDiff=0;

		try 
		{
			boObj.getClientChargeTrfDtl(voObj);
			WebRowSet ws3 = voObj.getGblWs2();
			int K=0;
			//For Handling CGHS Stent & Other Surgeries As per eligibility( CGHS Gives Stent Rates As 23628 But NIMS Charges 32000 Rs.) 
			for(int i=0;ws3.next();i++)
		    { 	
			    tariff_cost=ws3.getString(1) ;//Actual Defined In Charge Mst
			    to_be_payable_cost=ws3.getString(2) ;//Payable at NIMS for Client
			    net_amount_paid=ws3.getString(3) ;//Actual Paid by Patient Generally equal to tariff_cost
			    
			    if(Float.parseFloat(net_amount_paid)>Float.parseFloat(to_be_payable_cost))//Actual Rate Paid is Greater Than Payable COst By Client   Then Remaining Difference Will Be Paid By Patient-Client CGHS Pays 23268 For Stent Requirement
			    {
			    	fltDiffPayableByPat=fltDiffPayableByPat+(Float.parseFloat(net_amount_paid)-Float.parseFloat(to_be_payable_cost));
			    	if(K==0)
			    		strClientTariifNames=ws3.getString(4)+"["+to_be_payable_cost+"]";
			    	else
			    		strClientTariifNames=strClientTariifNames+", "+ws3.getString(4)+"["+to_be_payable_cost+"]";
			    	 K++;
			    }
			   
		    }
			boObj.getRoomTrfDtl(voObj);//To Check Whether Room Limit Defined For Patient. If defined what is the difference amount between room limit and actual room rent occupied by patient
			WebRowSet ws4 = voObj.getGblWs4();
			if (ws4.next()) 
			{
				totalRoomRent=ws4.getString(1);
				totalRoomDays=ws4.getString(2);
				elegibleRoomLimitPerDay=ws4.getString(3);
				if(Float.parseFloat(elegibleRoomLimitPerDay)>0)
				{
					if(Float.parseFloat(elegibleRoomLimitPerDay)*Float.parseFloat(totalRoomDays)<Float.parseFloat(totalRoomRent))//Room Limit Total Less Than Actuarl Room Rent Taken For totalRoomDays
					{
						fltRoomLimitDiff=Float.parseFloat(totalRoomRent)-Float.parseFloat(elegibleRoomLimitPerDay)*Float.parseFloat(totalRoomDays);//Difference To Be Paid by Patient
					}
				}
			}			
			if (voObj.getStrMsgType().equals("0")) 
			{
				if(fltRoomLimitDiff>0)//Room Limit Total Difference Defined For Patient. Paid By Patient
				{
					fltNetAmount=fltNetAmount+fltRoomLimitDiff;
					sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
					sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
					sb.append("<td width='45%' class='multiControlRed'>Room Rent Eligibilty(Per Day)</td>");
					sb.append("<td width='12%' class='multiControl'>0.00</td>");
					sb.append("<td width='12%' class='multiControl'>0.00</td>");
					sb.append("<td width='12%' class='multiControl'>0.00</td>");
					sb.append("<td width='16%' class='multiControlRed'>"+elegibleRoomLimitPerDay+"</td>");
					sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
					
					sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
					sb.append("<td width='45%' class='multiControlRed'>Total Room Rent("+totalRoomDays+" Days)</td>");
					sb.append("<td width='12%' class='multiControl'>0.00</td>");
					sb.append("<td width='12%' class='multiControl'>0.00</td>");
					sb.append("<td width='12%' class='multiControl'>0.00</td>");
					sb.append("<td width='16%' class='multiControlRed'>"+totalRoomRent+"</td>");
					sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
					
					sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
					sb.append("<td width='45%' class='multiControlRed'>Difference Room Rent Payable By Patient("+totalRoomDays+" Days) (A)</td>");
					sb.append("<td width='12%' class='multiControl'>0.00</td>");
					sb.append("<td width='12%' class='multiControl'>0.00</td>");
					sb.append("<td width='12%' class='multiControl'>0.00</td>");
					sb.append("<td width='16%' class='multiControlRed'>"+fltRoomLimitDiff+"</td>");
					sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
					sb.append("</table>");					
				}				
				if(fltDiffPayableByPat>0)
				{
					sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
					sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
					sb.append("<td width='36%' class='multiControl' title='"+strClientTariifNames+"'>Tariffs Chargeable To Patient(C)</td>");
					sb.append("<td width='45%' class='multiControlRed'  colspan='3'>"+strClientTariifNames+"</td>");
					sb.append("<td width='16%' class='multiControlRed'>"+fltDiffPayableByPat+"</td>");
					sb.append("<td width='5%' class='multiLabel'>#</td></tr>");							
					sb.append("</table>");
				}				
			} 
			else 
			{
				String err = voObj.getStrMsgString();
				sb.append("ERROR####" + err);
			}

		} catch (Exception e) {
	 
			throw new Exception(e.getMessage());

		}

		return sb.toString();
	}
   
   public static String getParticularDtlBS(String strAcctNo, String strHospCode,String strReqNo, String strChargeTypeId,String strClientBalanceAmt,CashCollectionOnlineTransVO voOnline) throws Exception 
   {
		BillingVO voObj = new BillingVO();
		BillingBO boObj = new BillingBO();
		voObj.setStrValue1(strAcctNo);
		voObj.setStrValue2(strHospCode);
		voObj.setStrValue3(strReqNo);
		voObj.setStrValue4(strChargeTypeId);

		String strDefaultGroupId = BillConfigUtil.GROUP_ID_DEPOSIT;

		StringBuffer sb = new StringBuffer("");

		StringBuffer sb1 = new StringBuffer("");
		StringBuffer sb2 = new StringBuffer("");
		StringBuffer sb3 = new StringBuffer("");
		StringBuffer sb11 = new StringBuffer("");

		
		String strTariffRate = "0";
		String strDiscountUnit = "0";
		String strDiscountType = "0";
		String strDiscountApprovalId = "0";
		String strServiceTax = "0";
		String strQty = "0";
		String strQtyBaseVal = "0";
		String strRateBaseVal = "0";
		String strClientRule = "0";
		String strPatRecvdAmount = "0";

		String tariff_cost="0";
		String to_be_payable_cost="0";
		String net_amount_paid="0";
		String strClientTariifNames="";
		String strRoomLimit="0";
		String totalRoomRent="0";
		String totalRoomDays="0";
		String elegibleRoomLimitPerDay="0";
		
		float fltRate = 0;
		float fltClientBalanceAmt = 0;
		float fltClientAmount = 0;
		float fltDiscountUnit = 0;
		float fltDiscountAmt = 0;
		float fltServiceTax = 0;
		float fltServiceTaxAmt = 0;
		float fltNetAmount = 0;//Net Amount is Amount To Be adjusted (refunded or payable)
		float fltQty = 0;
		float fltQtyRateVal = 0;
		float fltRateBaseVal = 0;
		float fltClientRule = 0;
		float fltPatRecvdAmount = 0;
		float fltDiffPayableByPat=0;
		float fltRoomLimitDiff=0;
		float fltRemainingDiffAfterClientRule=0;

		try 
		{
			boObj.getClientChargeTrfDtl(voObj);
			WebRowSet ws3 = voObj.getGblWs2();//Taken In New Variable Because In next Method getParticularDtl Same Webrowset Object is being used
			
			boObj.getParticularDtl(voObj);
			if(strReqNo!=null && !strReqNo.equals("0"))
			boObj.getRateDetails(voObj);
			
			//For Handling CGHS Stent & Other Surgeries As per eligibility( CGHS Gives Stent Rates As 23628 But NIMS Charges 32000 Rs.) 
			for(int i=0;ws3.next();i++)
		    { 		
			    tariff_cost=ws3.getString(1) ;//Actual Defined In Charge Mst
			    to_be_payable_cost=ws3.getString(2) ;//Payable at NIMS for Client
			    net_amount_paid=ws3.getString(3) ;//Actual Paid by Patient Generally equal to tariff_cost
			    
			    if(Float.parseFloat(net_amount_paid)>Float.parseFloat(to_be_payable_cost))//Actual Cost is Greater Than Payable Cost By Client  Then Remaining Difference Will Be Paid By Patient//Simply Means CLient Pays Less Amount But Actual Cost is higher Then remain diff paid by patient
			    {
			    	fltDiffPayableByPat=fltDiffPayableByPat+(Float.parseFloat(net_amount_paid)-Float.parseFloat(to_be_payable_cost));
			    	if(i==0)
			    		strClientTariifNames=ws3.getString(4)+"["+to_be_payable_cost+"]";
			    	else
			    		strClientTariifNames=strClientTariifNames+", "+ws3.getString(4)+"["+to_be_payable_cost+"]";
			    }
		    }
			boObj.getRoomTrfDtl(voObj);//To Check Whether Room Limit Defined For Patient. If defined what is the difference amount between room limit and actual room rent occupied by patient
			WebRowSet ws4 = voObj.getGblWs4();
			if (ws4.next()) 
			{
				totalRoomRent=ws4.getString(1);
				totalRoomDays=ws4.getString(2);
				elegibleRoomLimitPerDay=ws4.getString(3);
				
				if(Float.parseFloat(elegibleRoomLimitPerDay)>0)
				{
					if(Float.parseFloat(elegibleRoomLimitPerDay)*Float.parseFloat(totalRoomDays)<Float.parseFloat(totalRoomRent))//Room Limit Total Less Than Actuarl Room Rent Taken For totalRoomDays
					{
						fltRoomLimitDiff=Float.parseFloat(totalRoomRent)-Float.parseFloat(elegibleRoomLimitPerDay)*Float.parseFloat(totalRoomDays);//Difference To Be Paid by Patient
					}
				}
			}			
			
			if (voObj.getStrMsgType().equals("0")) 
			{
				WebRowSet ws2 = voObj.getGblWs1();
				
				if (ws2!=null && ws2.next()) 
				{
					strQty = ws2.getString(11);
					strDiscountApprovalId = ws2.getString(6);
					strTariffRate = ws2.getString(13);
					strDiscountUnit = ws2.getString(14);
					strDiscountType = ws2.getString(15);
					strServiceTax = ws2.getString(21);
					strRateBaseVal = ws2.getString(25);
					strQtyBaseVal = ws2.getString(26);
					strClientRule=ws2.getString(33);
					strPatRecvdAmount=ws2.getString(34);
				}

				fltRate = Float.parseFloat(strTariffRate);//Total Tariff Cost
				fltClientBalanceAmt = Float.parseFloat(strClientBalanceAmt);
				fltDiscountUnit = Float.parseFloat(strDiscountUnit);
				fltServiceTax = Float.parseFloat(strServiceTax);
				fltQty = Float.parseFloat(strQty);
				fltQtyRateVal = Float.parseFloat(strQtyBaseVal);
				//fltRateBaseVal = Float.parseFloat(strRateBaseVal);
				fltClientRule=Float.parseFloat(strClientRule);
				fltPatRecvdAmount=Float.parseFloat(strPatRecvdAmount);

				fltNetAmount = fltRate;//First Net Amount is  Total Tariff Cost
				
				if (fltNetAmount > 0 && fltDiscountUnit > 0) 
				{
					if (strDiscountType.equals("1")) 
					{
						fltDiscountAmt = fltDiscountUnit;
					} 
					else 
					{
						fltDiscountAmt = fltRate * (fltDiscountUnit / 100.00f);
					}
				}
				
				fltDiscountAmt = Float.parseFloat(HisUtil.getAmountWithDecimal((0 - (fltDiscountAmt)), 2));
				
				fltNetAmount = fltNetAmount + (fltDiscountAmt);//Net Amount=Total Tariff Cost+Discount(Discount Being -Ve)
				
				if (fltServiceTax > 0) 
				{
					fltServiceTaxAmt = (fltNetAmount)* (fltServiceTax / 100.00f);
				}
				
				fltServiceTaxAmt = Float.parseFloat(HisUtil.getAmountWithDecimal(fltServiceTaxAmt,2));
				
				fltNetAmount = fltNetAmount + fltServiceTaxAmt;//Net Amount=Total Tariff Cost+Discount(Discount Being -Ve)+Service Tax
				fltNetAmount = Float.parseFloat(HisUtil.getAmountWithDecimal(fltNetAmount,2));
				if(fltRoomLimitDiff>0)//Room Limit Total Difference Defined For Patient. Paid By Patient
					fltNetAmount=fltNetAmount-fltRoomLimitDiff;
				
				if (fltClientBalanceAmt > 0) // If Client Balance is present. Here the client balance is client sanctioned amount.
				{
					if(fltClientRule>0)
					{
					    if (fltClientBalanceAmt >= Math.round(fltNetAmount*fltClientRule/100)) // If Client Balance is Greater Than Total Expenditure Cost(Tariff-Discount+S.Tax) Then Client Amount is Total Expenditure Cost
					    {
							fltClientAmount = Math.round(fltNetAmount*fltClientRule/100);//							
						    fltNetAmount=Math.round(fltNetAmount*(100-fltClientRule)/100);
						    fltRemainingDiffAfterClientRule=fltNetAmount;
						    
						}
					    else
					    {
					    	fltClientAmount = fltClientBalanceAmt;//Else Client Balance
							fltNetAmount = fltNetAmount - fltClientAmount;//Now if all the payment given by client the Net Amount will be zero otherwise Net Amount-Client Amount
					    }
					}
					else
					{
						if (fltClientBalanceAmt >=fltNetAmount)
						{
							fltClientAmount = fltNetAmount;//
							fltNetAmount = fltNetAmount - fltClientAmount;
						}
						else
					    {
					    	fltClientAmount = fltClientBalanceAmt;//Else Client Balance
							fltNetAmount = fltNetAmount - fltClientAmount;//Now if all the payment given by client the Net Amount will be zero otherwise Net Amount-Client Amount
					    }
					} 
					/*else 
					{
						//if(fltClientRule>0)
						//{
							fltClientAmount = fltClientBalanceAmt;//Else Client Balance
							fltNetAmount = fltNetAmount - fltClientAmount;//Now if all the payment given by client the Net Amount will be zero otherwise Net Amount-Client Amount*/
						//}
						/*else
						{
							fltClientAmount = Math.round(fltClientBalanceAmt*fltClientRule/100);//Else Client Balance
							fltNetAmount = fltNetAmount - fltClientAmount;
						}	*/
					//}
					/*if(fltClientRule>0)
						fltNetAmount=Math.round(fltNetAmount*(100-fltClientRule)/100);
					else
						fltNetAmount = fltNetAmount - fltClientAmount;//Now if all the payment given by client the Net Amount will be zero otherwise Net Amount-Client Amount*/
					
				} 
				else 
				{
					fltClientAmount = 0;
				}
				
				/*if (fltPatRecvdAmount > 0) // If Patient Given Amount is present
				{
					fltNetAmount=fltNetAmount-fltPatRecvdAmount;
				}*/
				
				
				//System.out.println("fltNetAmount = " + fltNetAmount);
				WebRowSet ws = voObj.getGblWs2();

				sb.append("<table class='table'>");
				sb.append("<thead>");
				sb.append("<tr><th>S.No.</th>");
				sb.append("<th style='text-align:left'>Particulars</th>");
				sb.append("<th>Discount Amt(<i class='fas fa-rupee-sign'></i>)</th>");
				sb.append("<th>Penalty(<i class='fas fa-rupee-sign'></i>)</th>");
				sb.append("<th>Service Tax Amt(<i class='fas fa-rupee-sign'></i>)</th>"); 
				sb.append("<th style='text-align:right'>Total Amt(<i class='fas fa-rupee-sign'></i>)</th>");
				sb.append("<th style='text-align:center'>Details</th>");
				sb.append("</tr><thead>");
				sb.append("<tbody>");

				if (ws != null) 
				{
					String strParticular = null;
					String strTotalAmt = null;
					double strTotalAmtDiv = 0;
					//String strRecdAmt = "0";
					String strDisAmt = null;
					String strPenelty = null;
					String strSeviceTaxAmt = null;
					String strGroupId = "0";

					for (int i = 0; ws.next(); i++) 
					{
						sb11.append(ws.getString(7) + "^" + ws.getString(2)+ "@");

						sb1.append(ws.getString(2) + "^"); // Total Amt
						sb2.append(ws.getString(4) + "@"); // Total Discount
						sb3.append(ws.getString(6) + "$"); // Total Serivce Tax

						strParticular = ws.getString(1);
						strTotalAmt = ws.getString(6);
						strDisAmt = ws.getString(4);
						strPenelty = ws.getString(5);
						strSeviceTaxAmt = ws.getString(3);
						strTotalAmtDiv=Double.parseDouble(strTotalAmt);

						
						strGroupId = ws.getString(7);
						
						if(strGroupId.equals(strDefaultGroupId) && strTotalAmtDiv!=0)
							strTotalAmtDiv=strTotalAmtDiv*-1;
						
						if (strParticular == null || strParticular.equals(""))
							strParticular = "-----";
						if (strTotalAmt == null || strTotalAmt.equals(""))
						{
							strTotalAmt = "-----";
							strTotalAmtDiv=0;
						}
						if (strDisAmt == null || strDisAmt.equals(""))
							strDisAmt = "-----";
						if (strPenelty == null || strPenelty.equals(""))
							strPenelty = "-----";
						if (strSeviceTaxAmt == null
								|| strSeviceTaxAmt.equals(""))
							strSeviceTaxAmt = "-----";

						// sb.append("<input type='hidden' name='strGrpId'
						// value='"+ws.getString(7)+"'>");

						sb.append("<input type='hidden' name='flag'  value='"+ 0 + "'>");
						
						sb.append("<tr>");
						sb.append("<td><b>");
						sb.append(i + 1);
						sb.append("</b></td>");
						sb.append("<td style='text-align:left' class='labelcaps'>");
						sb.append(strParticular);
						sb.append("</td>");
						sb.append("<td>");
						sb.append(strDisAmt);

						sb.append("</td>");
						sb.append("<td>");
						sb.append(strPenelty);
						sb.append("</td>");
						sb.append("<td >");
						sb.append(strSeviceTaxAmt);
						sb.append("</td>");
						sb.append("<td style='text-align:right'>");

						/*///fltNetAmount -TOTAL REMAINING TARIFF COST  AFTER DEDUCTION FROM CLIENT AMOUNT(EITHER 80% RULE OR 100%-DEPENDING UPON CLIENT/COMPANY) 
						if (strDefaultGroupId.equals(strGroupId.trim()) && fltClientAmount<=0) //If Client Amount Is Not Present
						{							
						//	System.out.println("strTotalAmt = " + strTotalAmt);
							fltNetAmount = Float.parseFloat(HisUtil.getAmountWithDecimal(fltNetAmount + Float.parseFloat(strTotalAmt),2));
						//	System.out.println("fltNetAmount = " + fltNetAmount);
						}*/ //Not Required since it is handled above.
						
						
						sb.append(strTotalAmtDiv);
						sb.append("</td>");
						sb.append("<td style='text-align:center'>");
						sb.append("<input type='hidden' name='flagConfig' id='delindex"+ i + "' value='" + 0 + "'>");
						sb.append("<i class='fas fa-info-circle text-info' data-toggle='modal' data-target='#finalAModel" + i+ "'  value='"+ i+"' onClick='getParticularsDetails(this,"+ ws.getString(7) + "," + strAcctNo+ "," + i + ");'></i>");
						sb.append("</td></tr>");
						// sb.append("<table class='TABLEWIDTH' align='center'
						// border='0' cellpadding='1px' cellspacing
						// ='1px'><tr><td>");
						
						// sb.append("</td></tr></table>");
						// sb.append("<input type='hidden' name='currId'
						// value='0'>");
						 //sb.append("<div id='particularDtlsId" + i+ "' style='display:none'></div>");
						
						  sb.append("<div class='modal fade animate' id='finalAModel" + i+ "' tabindex='-1' role='dialog' aria-labelledby='myModalLabel'>"); 
						  sb.append("<div class='modal-dialog modal-lg' role='document' style='max-width: 1242px;'>"); 
						  sb.append(" <div class='modal-content animate-bottom'> ");
						  sb.append(" <div class='modal-header'>");
						  sb.append(" <h4 class='modal-title'>Tariff Details</h4>"); 
						  sb.append("<button type='button' class='close' data-dismiss='modal'>&times;</button></div>"); 
						  sb.append("<div class='modal-body'>");
						  sb.append("<div id='particularDtlsId" + i+ "'></div></div>"); 
						  sb.append("<div class='modal-footer'>");
						  sb.append("</div></div></div></div>");
						 
					}
					if(fltRoomLimitDiff>0)//Room Limit Total Difference Defined For Patient. Paid By Patient
					{
						//if(fltNetAmount==0)
						fltNetAmount=fltNetAmount+fltRoomLimitDiff;
						/*if(fltDiffPayableByPat<=fltRoomLimitDiff)
							fltDiffPayableByPat=0;
						else
							fltDiffPayableByPat=fltDiffPayableByPat-fltRoomLimitDiff;*/
						sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
						sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
						sb.append("<td width='45%' class='multiControlRed'><div align='left'>Room Rent Eligibilty(Per Day)</div></td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='16%' class='multiControlRed'>"+elegibleRoomLimitPerDay+"</td>");
						sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
						
						sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
						sb.append("<td width='45%' class='multiControlRed'><div align='left'>Total Room Rent("+totalRoomDays+" Days)</div></td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='16%' class='multiControlRed'>"+totalRoomRent+"</td>");
						sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
						
						sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
						sb.append("<td width='45%' class='multiControlRed'><div align='left'>Difference Room Rent Payable By Patient("+totalRoomDays+" Days) (A)</div></td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='12%' class='multiControl'>0.00</td>");
						sb.append("<td width='16%' class='multiControlRed'>"+fltRoomLimitDiff+"</td>");
						sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
						
					}
					if(fltClientRule>0 || fltDiffPayableByPat>0)
					{
						//fltClientAmount=fltClientAmount-fltDiffPayableByPat;
						sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'>");
						
						/*if (fltClientRule<=0 && fltDiffPayableByPat>0)
							sb.append("<td width='45%' class='multiControlRed'>Client Approved(Tariffs Chargeable To Client)</td>");
						else if (fltClientRule>0 && fltDiffPayableByPat<=0)
							sb.append("<td width='45%' class='multiControlRed'>Client Approved("+fltClientRule+" % of Total Tariff Cost)</td>");
						else
							*/
						if(fltClientRule>0)
						{
							sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
							sb.append("<td width='45%' class='multiControlRed'><div align='left'>Client Approved("+fltClientRule+" % of Total Tariff Cost/Tariffs Chargeable To Client)</div></td>");
							sb.append("<td width='12%' class='multiControl'>0.00</td>");
							sb.append("<td width='12%' class='multiControl'>0.00</td>");
							sb.append("<td width='12%' class='multiControl'>0.00</td>");
							sb.append("<td width='16%' class='multiControlRed'>"+fltClientAmount+"</td>");
							sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
							
							sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
							sb.append("<td width='45%' class='multiControlRed'><div align='left'>Remaining Difference After Client Approved("+(100-fltClientRule)+" % of Total Tariff Cost/Tariffs Chargeable To Client)(B)</div></td>");
							sb.append("<td width='12%' class='multiControl'>0.00</td>");
							sb.append("<td width='12%' class='multiControl'>0.00</td>");
							sb.append("<td width='12%' class='multiControl'>0.00</td>");
							sb.append("<td width='16%' class='multiControlRed'>"+fltRemainingDiffAfterClientRule+"</td>");
							sb.append("<td width='5%' class='multiLabel'>#</td></tr>");
						}
						
						
					
						if (fltClientRule<=0 && fltDiffPayableByPat>0)
						{
							sb.append("<tr><td width='3%' class='multiLabel'>#</td>");
							sb.append("<td width='36%' class='multiControl' title='"+strClientTariifNames+"'><div align='left'>Tariffs Differenece Chargeable To Patient(C)</div></td>");
							sb.append("<td width='45%' class='multiControlRed'  colspan='3'>"+strClientTariifNames+"</td>");
							sb.append("<td width='16%' class='multiControlRed'>"+fltDiffPayableByPat+"</td>");
							sb.append("<td width='5%' class='multiLabel'>#</td></tr>");							
						}						
						
						sb.append("</table>");
					}
					if (fltPatRecvdAmount > 0) // If Patient Given Amount is present
					{
						fltNetAmount=fltNetAmount-fltPatRecvdAmount;
					}
					fltNetAmount=fltNetAmount+fltDiffPayableByPat;//Add All Difference Amount To Be payable By Patient
					//sb.append("<table class='table'><tr>");		
					//sb.append("<td width='50%'></td>");
					//sb.append("<td width='5%'><label style='font-weight: 501;'>Bill Type</label></td><td width='15%'><select name='strBillType' class='form-control'><option value='1'>Consolidated</option><option value='2' selected='selected'>Detailed</option></select></td>");					
					//sb.append("<td width='30%'></td>");
					//sb.append("</tr></table>");
					sb.append("<table class='TABLEWIDTH' align='center' border='0' cellpadding='1px' cellspacing ='1px'><tr>");					
					sb.append("<td class='LABEL' colspan='4' width='50%' style='display:none;'>Convert Account into Wallet(Only for General/Paid Category Patients)</td><td class='CONTROL' width='50%' colspan='3' style='display:none;'><input type='checkbox' onclick='setwalacc();' name='walacc' id='walacc' value='1'></td>");					
					sb.append("</tr></table>");
					
					if(voOnline!=null)
					{
						sb.append("<input type='hidden' name='currId'  value='-1'>");
						sb.append("<input type='hidden' name='strClientPatientNo'  value='"+voOnline.getStrClientPatientNo()+"'>");
						sb.append("<input type='hidden' name='hiddenString'  value='"+ sb11.toString() + "'>");		
						sb.append("<input type='hidden' name='strRequestBillTariffDetails' value='"+ strDiscountApprovalId +"^"+strDiscountUnit+"^"+strDiscountType+"^"+strServiceTax+ "'>");
						sb.append("<input type='hidden' name='strExpenseAmount' value='"+ fltRate + "'>");
						sb.append("<input type='hidden' name='strNetClientAmount' value='"+ fltClientAmount + "'>");
						sb.append("<input type='hidden' name='strSancAmount' value='"+ voOnline.getStrSancAmount() + "'>");
						sb.append("<input type='hidden' name='strClientBalance' value='"+ voOnline.getStrClientBalance() + "'>");
						sb.append("<input type='hidden' name='strClientAmount' value='"+ voOnline.getStrClientAmount() + "'>");
						sb.append("<input type='hidden' name='strNetDiscountAmount' value='"+ fltDiscountAmt + "'>");
						sb.append("<input type='hidden' name='strNetServiceTaxAmount' value='"+ fltServiceTaxAmt + "'>");
						sb.append("<input type='hidden' name='strNetPaybleAmount' value='"+ fltNetAmount + "'>");
						sb.append("<input type='hidden' name='strPatientRecvdAmount' value='"+ fltPatRecvdAmount + "'>");
					}
					
					sb.append("</tbody></table>");
				} 
				else 
				{
					sb.append("<table class='TABLEWIDTH' align='center'   bgcolor='#000000' border='0' cellpadding='1px' cellspacing ='1px'>");
					sb.append("<tr>");
					sb.append("<td colspan='5'  CLASS='multiControl' ><div class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED CR NO </div></TD>");
					sb.append("</tr>");
					sb.append("</table>");
					sb.append("</div>");
				}
			} 
			else 
			{
				String err = voObj.getStrMsgString();
				sb.append("ERROR####" + err);
			}

		} catch (Exception e) {
	 
			throw new Exception(e.getMessage());

		}

		return sb.toString();
	}

}
