package billing;

import hisglobal.utility.HisUtil;

import javax.sql.rowset.WebRowSet;


public class HLPParticularDtlBillApprovalNew
{
	 public static String getParticularDtlForBillApproval(String strAcctNo,int j,String strHospCode,String accType) 
	 {
			BillingVO voObj = new BillingVO();
			BillingBO boObj = new BillingBO();
			
		    voObj.setStrValue1(strAcctNo);
		    voObj.setStrValue2(strHospCode);
		    BillConfigUtil billConfig = new BillConfigUtil(strHospCode);
		    String strFinalStringBillApproval = null;
		    // Declaring Variables
		 		 
		    String strTotalExpAmt 	= "0";	
		    String trfamt="0";
			String strTotalDisAmt 	= "0";			
			String strClientAmt 	= "0";
			String strClientSancAmt	= "0";
			String strClientBalAmt	= "0";
			String strClientPatNo 	= "";
			String strTotalRecvdAmt = "0";	
			double strTotalRecvdAmtDiv = 0.00;
			String strSeviceTax 	= "0";
			String strServiceTaxAmt = "0";			
			String strPoorFreeWelfare	=	"0";			
			String strPoorFreeGrant	=	"0";			
			String strPrimaryCategory = "";		
			String totalRoomRent="0";
			String totalRoomDays="0";
			String elegibleRoomLimitPerDay="0";
			float fltRoomLimitDiff=0;
			StringBuffer sb = new StringBuffer("");	          
	        StringBuffer sb4 = new StringBuffer("");
	         
	        try 
			 {   
		    // boObj.getPartPaymentPendingReq(voObj);  
		       boObj.getParticularDtl(voObj);
		       boObj.getAccountDtlAcctNo(voObj);
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
		       if(voObj.getStrMsgType().equals("0"))
		       {	
	            WebRowSet ws = voObj.getGblWs2();
	            WebRowSet ws1 = voObj.getGblWs3();
	           sb.append("<table class='table tableTariifDtl'>"); 
	           //sb.append("<tr><td class='TITLE' colspan='5'>Tariff Details</td> </tr>");
	           sb.append("<thead>");
			   sb.append("<tr class='alert alert-secondary'><th><label class='labelcaps zerobottom'>Sl No.</label></th>");
			   sb.append("<th><label class='labelcaps zerobottom'>Group Name</label></th>");
			   sb.append("<th><label class='labelcaps zerobottom'>Calculated Amt</label></th>");
			   sb.append("<th><label class='labelcaps zerobottom'>Final Amt</label></th>");
			   sb.append("<th><label class='labelcaps zerobottom'>Details</label></th></tr></thead>");
			   sb.append("<tbody>");
			   			   
				   if (ws != null && ws1 != null) 
				   {			   
					    while(ws1.next())
			            {				    	
					    	strTotalDisAmt = ws1.getString(13);
					    	strTotalRecvdAmt = ws1.getString(8);
					    	strClientAmt = ws1.getString(9);
					    	strClientSancAmt = ws1.getString(7);
					    	strClientBalAmt = ws1.getString(17);
					    	strClientPatNo = ws1.getString(4);
					    	strTotalExpAmt = ws1.getString(10);				    	
					    	strPoorFreeWelfare = (Float.parseFloat(ws1.getString(8)))*-1+"";
					    	strPoorFreeGrant = (Float.parseFloat(ws1.getString(10)))*-1+"";				    	
					    	strPrimaryCategory=ws1.getString(26);
	     	            }
				    
				    strTotalExpAmt = HisUtil.getAmountWithDecimal(strTotalExpAmt,2);
				    trfamt= HisUtil.getAmountWithDecimal(strTotalExpAmt,2);
				    strTotalDisAmt = HisUtil.getAmountWithDecimal(strTotalDisAmt,2);
				    strTotalRecvdAmt = HisUtil.getAmountWithDecimal(strTotalRecvdAmt,2);
				    strTotalRecvdAmtDiv =  Double.parseDouble(strTotalRecvdAmt);
				    if(strTotalRecvdAmtDiv!=0)
  				    {
  					 strTotalRecvdAmtDiv=strTotalRecvdAmtDiv*-1;//For Display Only
  				    }
				    strClientAmt = HisUtil.getAmountWithDecimal(strClientAmt,2);
				    strClientSancAmt= HisUtil.getAmountWithDecimal(strClientSancAmt,2);
					strSeviceTax  = billConfig.getIpdServiceTaxOnTotalBill();
					
					strPoorFreeWelfare = HisUtil.getAmountWithDecimal(strPoorFreeWelfare,2);
					strPoorFreeGrant = HisUtil.getAmountWithDecimal(strPoorFreeGrant,2);
				    
				//	double balanceAmt = Double.parseDouble(strTotalExpAmt) + Double.parseDouble(strTotalRecvdAmt);
					
					double balanceAmt = Double.parseDouble(strTotalExpAmt) - Double.parseDouble(strTotalDisAmt);
					double balanceAmtDiv = 0.00;
					
					if(balanceAmt > 0)
					{						
						  if(new BillConfigUtil(strHospCode).getIpdThirdPartyBilling().equals("1") && Double.parseDouble(strClientAmt) > 0)
						  {							  
							  strServiceTaxAmt = Double.toString(( balanceAmt +  Double.parseDouble(strTotalDisAmt) + Double.parseDouble(strClientAmt)) * (Double.parseDouble(strSeviceTax) / 100.00) );							  
						  }
						  else
						  {					
							  strServiceTaxAmt = Double.toString(( balanceAmt +  Double.parseDouble(strTotalDisAmt)) * (Double.parseDouble(strSeviceTax) / 100.00) );							  
						  }						
					}
					else
					{						
						 strServiceTaxAmt = "0";
					}
					
					
					if(fltRoomLimitDiff>0)//Room Limit Total Difference Defined For Patient. Paid By Patient
						trfamt=String.valueOf(Double.parseDouble(trfamt)-fltRoomLimitDiff);
				   	if(Double.parseDouble(trfamt)<=Double.parseDouble(strClientSancAmt))
				   		balanceAmt = Double.parseDouble(strTotalRecvdAmt);
				   	else
				   		balanceAmt =Double.parseDouble(trfamt) + Double.parseDouble(strTotalRecvdAmt)-Double.parseDouble(strClientSancAmt);
				  
				   		balanceAmtDiv =balanceAmt*-1;
						String strParticular = null;
						String strTotalAmt = null;
						double strTotalAmtDiv = 0;
						String strDisAmt = null;
						String strPenelty = null;
					
						double dblNetAmtTotal = 0;
						String strGrpId = null;
				
						for(int i=0;ws.next();i++)
	                    {
							strParticular  = ws.getString(1);
							strTotalAmt  = ws.getString(6);
							strDisAmt  = ws.getString(4);
							strPenelty  = ws.getString(5);						
							strGrpId  = ws.getString(7);
							
	     				   	if(strParticular == null || strParticular.equals("")) strParticular = "-----";
	     				    if(strTotalAmt == null || strTotalAmt.equals("")) 
	     				    {
	     				    	strTotalAmt = "0.00";
	     				    	strTotalAmtDiv=0;
	     				    }
	     				    if(strDisAmt == null || strDisAmt.equals("")) strDisAmt = "0.00";
	     				    if(strPenelty == null || strPenelty.equals("")) strPenelty = "0";
	     				    if(strServiceTaxAmt == null || strServiceTaxAmt.equals("")) strServiceTaxAmt = "0.00";
	     				   	     				       
	     				   strTotalAmt = HisUtil.getAmountWithDecimal(strTotalAmt,2);	
	     				   strTotalAmtDiv=Double.parseDouble(strTotalAmt);
	     				   if( strGrpId.equals(BillConfigUtil.GROUP_ID_DEPOSIT) && strTotalAmtDiv!=0)
	     				   {
	     					  strTotalAmtDiv=strTotalAmtDiv*-1;//For Display Only	     					  
	     				   }
	     				   strDisAmt = HisUtil.getAmountWithDecimal(strDisAmt,2);
	     				   strServiceTaxAmt = HisUtil.getAmountWithDecimal(strServiceTaxAmt,2);
	     				   dblNetAmtTotal = dblNetAmtTotal + Double.parseDouble(strTotalAmt);
	     				   				  
	     				   
	     				   // sb.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
							sb.append("<tr>");							
							sb.append("<td>");
							
							sb.append("<input type='hidden' name='strGrpId'  value='"+ws.getString(7)+"'>");
		     				sb.append("<input type='hidden' name='flag'  value='"+0+"'>");	
	     				    sb.append("<b>");
							sb.append(i+1);
							sb.append("</b></td>");
							
							sb.append("<td><label class='labelcaps zerobottom'>"+strParticular+"</td>");							
							sb.append("<td><i class='fas fa-rupee-sign'>&nbsp;</i><input type='hidden' name='strTotalFinalCalAmtHid' id='strTotalFinalCalAmtHid"+i+"' type='text' class='txtFldMin' value='"+strTotalAmt+"'>");
							sb.append(strTotalAmtDiv);
							sb.append("</td>");
							
							sb.append("<td>");
							if( strGrpId.equals(BillConfigUtil.GROUP_ID_DEPOSIT))
							{
								sb.append("<input type='hidden' name='strTotalFinalAmtHid' id='strTotalFinalAmtHid"+i+"' type='text' class='txtFldNormal' value='0'>");
							}
							else
							{								
								sb.append("<input type='hidden' name='strTotalFinalAmtHid' id='strTotalFinalAmtHid"+i+"' type='text' class='txtFldNormal' value='"+strTotalAmt+"'>");
							}
							
							sb.append("<input name='strTotalFinalAmt' id='strTotalFinalAmt"+i+"' type='hidden' class='txtFldNormal' value='"+strTotalAmt+"' disabled='disabled'>");
							sb.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label class='zerobottom' id='strTotalFinalAmtDivId"+i+"'>"+strTotalAmtDiv+"</label>");
							sb.append("</td>");
											
							sb.append("<td>");
							sb.append("<input type='hidden' name='flagConfig' id='delindex"+i+"' value='"+0+"'>");							
							sb.append("<i class='fas fa-info-circle text-info' aria-hidden='true' data-toggle='modal' data-target='#procUnprocDtl' onClick='getBillApprovalDtl(this,"+strGrpId+","+strAcctNo+","+i+");'></i>");
							
							//sb.append("<img bgColor='white' value='"+i+"' src='../../hisglobal/images/viewDetails.gif' style='cursor:pointer;cursor:hand;' data-toggle='modal' data-target='#procUnprocDtl' onClick='getBillApprovalDtl(this,"+strGrpId+","+strAcctNo+","+i+");'>");
							sb.append("</td></tr>");
							//sb.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
							//sb.append("<tr><td><div id='billapprovalId"+i+"' style='display:none'></div></td></tr></table>");
						
							sb.append("<div id='billapprovalId"+i+"' style='display:none'></div>");
							
					    }
						sb.append("</tbody>");
						
						if(accType.equals("2"))
						{
							sb.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px'>");
					 		sb.append("<tr><td width='42%' class='LABEL'>");
					 		
							sb.append("Total IPD Exp Amount:</td>");
							sb.append("<td width='25%' class='multiControl' style='font-weight:bold'>");
							sb.append("<input name='stripCalAmt' id='stripCalAmt' type='hidden' class='txtFldNormal' value='"+HisUtil.getAmountWithDecimal(dblNetAmtTotal, 2)+"'   disabled='disabled'>");
							sb.append("<div id='stripCalAmtDivId'>"+HisUtil.getAmountWithDecimal(dblNetAmtTotal, 2)+"</div>");
							sb.append("</td>");
							sb.append("<td width='17%' class='multiControl' style='font-weight:bold'>");
							sb.append("<input name='stripAmt' id='stripAmt' type='hidden' class='txtFldNormal' value='"+HisUtil.getAmountWithDecimal(dblNetAmtTotal, 2)+"'   disabled='disabled'>");
							sb.append("<div id='stripAmtDivId'>"+HisUtil.getAmountWithDecimal(dblNetAmtTotal, 2)+"</div>");
							sb.append("</td>");
							sb.append("<td width='18%'  class='CONTROL'></td>");
							sb.append("</tr></table>");
						}
						
					    
					    
					 /*   sb.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px'>");
				 		sb.append("<tr><td width='42%' class='LABEL'>");
				 		sb.append("<input type='hidden' name='currId'  value='-1'>");
						sb.append("<input type='hidden' name='IpdThirdPartyBilling'  value='"+j+"'>");
						sb.append("<input type='hidden' name='hiddenString'  value=''>");
						sb.append("Total Exp Amount:</td>");
						sb.append("<td width='25%' class='multiControl' style='font-weight:bold'>");
						sb.append("<input name='strFinalCalAmt' id='strFinalCalAmt' type='hidden' class='txtFldNormal' value='"+strTotalExpAmt+"'   disabled='disabled'>");
						sb.append("<div id='strFinalCalAmtDivId'>"+strTotalExpAmt+"</div>");
						sb.append("</td>");
						sb.append("<td width='17%' class='multiControl' style='font-weight:bold'>");
						sb.append("<input name='strFinalAmt' id='strFinalAmt' type='hidden' class='txtFldNormal' value='"+strTotalExpAmt+"'   disabled='disabled'>");
						sb.append("<div id='strFinalAmtDivId'>"+strTotalExpAmt+"</div>");
						sb.append("</td>");
						sb.append("<td width='18%'  class='CONTROL'></td>");
						sb.append("</tr></table>");
							*/
			           // sb4.append("<table class='TABLEWIDTH' align='center' border='0' cellspacing ='1px' cellpadding='1px'>");
			            
			            /*sb4.append("<tr><td width='83%' class='LABEL'>Received Amt (<img src='../../hisglobal/images/INR.png'>)(A):</td>");
						sb4.append("<td width='17%' class='CONTROL' style='font-weight:bold'>");
						sb4.append("<input name='strReceivedAmt' id='strReceivedAmt' type='hidden' class='txtFldNormal' value='"+strTotalRecvdAmt+"' disabled='disabled'>");
						sb4.append("<div id='strReceivedAmtDivId'>"+strTotalRecvdAmtDiv+"</div>");
						sb4.append("</td></tr>");
						*/
						
						
						
							  
							  
					/*
					 * sb.append("<br><div class='row rowFlex reFlex'>");
					 * sb.append("<div class='col-sm-4' align='right'>");
					 * sb.append("<input type='hidden' name='currId'  value='-1'>");
					 * sb.append("<input type='hidden' name='IpdThirdPartyBilling'  value='"+j+"'>")
					 * ; sb.append("<input type='hidden' name='hiddenString'  value=''>");
					 * sb.append("<label>Total Exp Amount:</label></div>");
					 * sb.append("<div class='col-sm-3' align='right'>"); sb.
					 * append("<input name='strFinalCalAmt' id='strFinalCalAmt' type='hidden' class='txtFldNormal' value='"
					 * +strTotalExpAmt+"'   disabled='disabled'>"); sb.
					 * append("<i class='fas fa-rupee-sign'>&nbsp;</i><label id='strFinalCalAmtDivId'>"
					 * +strTotalExpAmt+"</label></div>");
					 * sb.append("<div class='col-sm-3' align='right'>"); sb.
					 * append("<input name='strFinalAmt' id='strFinalAmt' type='hidden' class='txtFldNormal' value='"
					 * +strTotalExpAmt+"'   disabled='disabled'>"); sb.
					 * append("<i class='fas fa-rupee-sign'>&nbsp;</i><label id='strFinalAmtDivId'>"
					 * +strTotalExpAmt+"</label></div>"); sb.append("<div class='col-sm-2'></div>");
					 * sb.append("</div>");
					 */
						sb.append("<tfoot>");
						sb.append("<tr class='alert alert-secondary'>");
					    sb.append("<td colspan='2'><label class='labelcaps zerobottom'>Total Exp Amount</label></td>");
					    sb.append("<input type='hidden' name='currId'  value='-1'>");
						sb.append("<input type='hidden' name='IpdThirdPartyBilling'  value='"+j+"'>");
						sb.append("<input type='hidden' name='hiddenString'  value=''>");
						
					    sb.append("<td colspan='1'>");
					    sb.append("<input name='strFinalCalAmt' id='strFinalCalAmt' type='hidden' class='txtFldNormal' value='"+strTotalExpAmt+"'   disabled='disabled'>");
						sb.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label id='strFinalCalAmtDivId' class='zerobottom'>"+strTotalExpAmt+"</label></td>");
						sb.append("<td colspan='1'>");
					    sb.append("<input name='strFinalAmt' id='strFinalAmt' type='hidden' class='txtFldNormal' value='"+strTotalExpAmt+"'   disabled='disabled'>");
						sb.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label id='strFinalAmtDivId' class='zerobottom'>"+strTotalExpAmt+"</label></td>");
						sb.append("<td colspan='1'></td>");
					    
						sb.append("</tfoot>");
					    
				        sb.append("</table>"); 	
					    
					    sb4.append("<div class='row rowFlex reFlex'>");		 
		            	sb4.append("<div class='col-sm-8' align='right'><label class='zerobottom'>Received Amt(A):</label></div>");
		            	sb4.append("<div class='col-sm-4' align='left'>");
		            	sb4.append("<input name='strReceivedAmt' id='strReceivedAmt' type='hidden' class='txtFldNormal' value='"+strTotalRecvdAmt+"' disabled='disabled'>");
						sb4.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label class='zerobottom' id='strReceivedAmtDivId'>"+strTotalRecvdAmtDiv+"</label>");
						sb4.append("</div>");
						sb4.append("</div>");
						
						
						
						if(new BillConfigUtil(strHospCode).getIpdThirdPartyBilling().equals("1") && Double.parseDouble(strClientSancAmt) > 0)
			            {						 
							sb4.append("<div class='row rowFlex reFlex'>");
							sb4.append("<div class='col-sm-8' align='right'><label class='zerobottom'>Maximum Benefits from Client(B):</label></div>");
							sb4.append("<div class='col-sm-4' align='left'>");
						    sb4.append("<input name='strMaxBenifitAmt' id='strMaxBenifitAmt' type='hidden' class='txtFldNormal' value='"+strClientSancAmt+"' disabled='disabled'>");
							sb4.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label class='zerobottom' id='strMaxBenifitAmtDivId'>"+strClientSancAmt+"</label>");
							sb4.append("<input type='hidden' name='strCltPatientNo' value="+strClientPatNo+">");
							sb4.append("<input type='hidden' name='strCltAppHLPHid' value=''>");
							sb4.append("<input type='hidden' name='strCltAppSancAmt' value="+strClientSancAmt+">");
							sb4.append("<input type='hidden' name='strCltAppAmt' value="+strClientAmt+">");
							sb4.append("<input type='hidden' name='strCltApprBalanceAmt' value="+strClientBalAmt+">");
							sb4.append("</div>");
							sb4.append("</div>");
			            }
			            else
			            {
			            	sb4.append("<div class='row rowFlex reFlex'>");
			            	sb4.append("<div class='col-sm-8' align='right'><label class='zerobottom'>Maximum Benefits from Client(B):</label></div>");
			            	sb4.append("<div class='col-sm-4' align='left'>");
							sb4.append("<input name='strMaxBenifitAmt' id='strMaxBenifitAmt' type='hidden' class='txtFldNormal' value='0' disabled='disabled'>");
							sb4.append("<i class='fas fa-rupee-sign'>&nbsp</i><label class='zerobottom' id='strMaxBenifitAmtDivId'>"+strClientSancAmt+"</label>");
							sb4.append("</div>");
							sb4.append("</div>");
			            }
						
						sb4.append("<div class='row rowFlex reFlex'>");
					  
					    sb4.append("<div class='col-sm-8' align='right'><label class='zerobottom'>Grand Total Exp Amount(C):</label></div>");
					    sb4.append("<div class='col-sm-4' align='left'>");
			            sb4.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label class='zerobottom' id='totalRecAmtDivId'>"+strTotalExpAmt+"</label><input type='hidden' name='totalRecAmtDivId1' id='totalRecAmtDivId1' value='"+strTotalExpAmt+"' >");
					    sb4.append("</div>");
					    sb4.append("</div>");
					    
					    sb4.append("<div class='row rowFlex reFlex'>");
					    
					    sb4.append("<div class='col-sm-8' align='right'><label class='zerobottom'>Discount Amt(D):</label></div>");
					    sb4.append("<div class='col-sm-4' align='left'>");
					    sb4.append("<input name='strTotalDisAmt' id='strTotalDisAmt' type='hidden' value='0.00' disabled='disabled'>");
						sb4.append("<i class='fas fa-rupee-sign'>&nbsp</i><label class='zerobottom' id='strTotalDisAmtDivId'>0.00 </label>&nbsp;<i class='fas fa-info-circle text-danger' aria-hidden='true' onClick='getDiscountDtlForBillApproval(this);'></i>");
						sb4.append("<input name='strTariffDiscountAmtConfgDtlBillApproval' id='strTariffDiscountAmtConfgDtlBillApproval' type='hidden' value='"+0+"'>");
						//sb4.append("");
						sb4.append("</div>");
					    sb4.append("</div>");
					    
					    sb4.append("<div class='row rowFlex reFlex'>");
					    sb4.append("<div class='col-sm-8' align='right'><label class='zerobottom'>Service Tax:</label></div>");
					    sb4.append("<div class='col-sm-4' align='left'>");
					    sb4.append("<input type='hidden' id='strTotalServiceTaxTemp' value='"+strSeviceTax+"'>");
						sb4.append("<input name='strTotalServiceTax' id='strTotalServiceTax' type='hidden' value='"+strServiceTaxAmt+"' disabled='disabled'>");
						sb4.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label class='zerobottom' id='strTotalServiceTaxDivId'>"+strSeviceTax+"</label>");
						sb4.append("</div>");
					    sb4.append("</div>");
						
					
						///poor free details. Visible only for poor patients
						if(strPrimaryCategory.equals(new BillConfigUtil(strHospCode).getIpdFreeCategory()))
						{
							sb4.append("<input type='hidden' name='primaryCategoryCode' value='"+ strPrimaryCategory+"'");
							
							/*sb4.append("</td></tr>");
							sb4.append("<tr><td width='83%' class='LABEL'>Poor Free Welfare:</td>");
							sb4.append("<td width='17%' class='CONTROL' style='font-weight:bold'>");
							sb.append("<input type='hidden' id='strPoorFreeWelfareTemp' value='"+strPoorFreeWelfare+"'>");
							sb4.append("<input name='strPoorFreeWelfareAmt' id='strPoorFreeWelfare' type='hidden' class='txtFldNormal' value='"+strPoorFreeWelfare+"' >");
							sb4.append("<div id='strPoorFreeWelfareDivId'>"+strPoorFreeWelfare+"</div>");
							sb4.append("</td></tr>");*/
							
							
							    sb4.append("<div class='row rowFlex reFlex'>");
							    sb4.append("<div class='col-sm-3'></div>");
							    sb4.append("<div class='col-sm-6' align='right'><label class='zerobottom'>Poor Free Welfare:</label></div>");
							    sb4.append("<div class='col-sm-3' align='left'>");
							    sb4.append("<input type='hidden' id='strPoorFreeWelfareTemp' value='"+strPoorFreeWelfare+"'>");
								sb4.append("<input name='strPoorFreeWelfareAmt' id='strPoorFreeWelfare' type='hidden' value='"+strPoorFreeWelfare+"' >");
								sb4.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label class='zerobottom' id='strPoorFreeWelfareDivId'>"+strPoorFreeWelfare+"</label>");
							    sb4.append("</div>");
							    
							    
							    sb4.append("<div class='row rowFlex reFlex'>");
							    sb4.append("<div class='col-sm-3'></div>");
							    sb4.append("<div class='col-sm-6' align='right'><label class='zerobottom'>Poor Free grant:</label></div>");
							    sb4.append("<div class='col-sm-3' align='left'>");
							    sb4.append("<input type='hidden' id='strPoorFreeGrantTemp' value='"+strPoorFreeGrant+"'>");
								sb4.append("<input name='strPoorFreeGrantAmt' id='strPoorFreeGrant' type='hidden' value='"+strPoorFreeGrant+"' >");
								sb4.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label class='zerobottom' id='strPoorFreeGrantDivId'>"+strPoorFreeGrant+"</label>");
							    sb4.append("</div>");
							    
							    
							     
							/*sb4.append("</td></tr>");
							sb4.append("<tr><td width='83%' class='LABEL'>Poor Free grant:</td>");
							sb4.append("<td width='17%' class='CONTROL' style='font-weight:bold'>");
							sb.append("<input type='hidden' id='strPoorFreeGrantTemp' value='"+strPoorFreeGrant+"'>");
							sb4.append("<input name='strPoorFreeGrantAmt' id='strPoorFreeGrant' type='hidden' class='txtFldNormal' value='"+strPoorFreeGrant+"' >");
							sb4.append("<div id='strPoorFreeGrantDivId'>"+strPoorFreeGrant+"</div>");
							sb4.append("</td></tr>");*/
						}
						if(fltRoomLimitDiff>0)//Room Limit Total Difference Defined For Patient. Paid By Patient
						{
							balanceAmt=balanceAmt+fltRoomLimitDiff;
							
							sb4.append("<div class='row rowFlex reFlex'>");
						    sb4.append("<div class='col-sm-3'></div>");
						    sb4.append("<div class='col-sm-6' align='right'><label class='zerobottom'>Balance Room Rent Paid By Patient</label></div>");
						    sb4.append("<div class='col-sm-3' align='left'>");
						    sb4.append("<input name='strNetRoomRent' id ='strNetRoomRent' type='hidden' class='txtFldNormal' value='0' disabled='disabled'>");
							sb4.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label class='zerobottom' id='strNetRoomRentDivId'>"+fltRoomLimitDiff+"</label>");
						    sb4.append("</div>");						   
						}
						
						sb4.append("<div class='row rowFlex reFlex'>");
					    sb4.append("<div class='col-sm-8' align='right'><label class='zerobottom'>Balance Amt:</label></div>");
					    sb4.append("<div class='col-sm-4' align='left'>");
					    sb4.append("<input name='strNetPaybleAmt' id ='strNetPaybleAmt' type='hidden' value='0' disabled='disabled'>");
						sb4.append("<i class='fas fa-rupee-sign'>&nbsp;</i><label class='zerobottom' id='strNetPaybleAmtDivId'>"+Math.round(balanceAmtDiv)+"</label>");
					    sb4.append("</div>");
					    
						strFinalStringBillApproval = sb.toString()+"&&"+sb4.toString();
			 	  }
				   else
				   {
					   sb.append("<table class='TABLEWIDTH' align='center'  border='0' bgcolor='#000000' cellspacing ='1px' cellpadding='1px'>"); 
						sb.append("<tr>");
						sb.append("<td colspan='5'  CLASS='multiControl' >"
								+ "<DIV class='errMsg' align='center'> NO RECORD FOUND FOR SELECTED GROUP </div>" + "</TD>");

						sb.append("</tr>");
						sb.append("</table></div>");
						strFinalStringBillApproval =  sb.toString();
				   } 
		    	 }
				  else
				  {	  
					String err = voObj.getStrMsgString();   
				    sb.append("ERROR####"+err);
				    strFinalStringBillApproval =  sb.toString();
				  } 
				}   
	            catch (Exception e) 
	            {
					
				}
	        	
			return strFinalStringBillApproval;
		}

}
