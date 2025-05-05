package mms.transactions.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.vo.HospitalMstVO;
import mms.MmsConfigUtil;
import mms.transactions.bo.IndentApprovalDeskBO;
import mms.transactions.controller.fb.IndentApprovalDeskFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.DiscrepancyReportHLP;
import mms.transactions.controller.hlp.IndentApprovalDeskHLP;
import mms.transactions.vo.IndentApprovalDeskVO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 1/June/2009
 * Modif Date : / /2009 
*/

public class IndentApprovalDeskDATA 
{
	/**
	 * Method is Used to get the Data for Approved Page of
	 * Approval Desk on the basis of Request Type Id 
	 * @param formBean
	 * @param request
	 */
	public static void ApprovedRecord(HttpServletRequest request,IndentApprovalDeskFB formBean) 
	{
		IndentApprovalDeskBO bo = null;
		IndentApprovalDeskVO vo = null;
		String strmsgText = "";
		String str1 = "";
		String str3 = "";
		String str4 = "";
		String committeType = "";
		MmsConfigUtil mmsUtil = null;
		StringBuffer sb = new StringBuffer("");
		try 
		{
			bo = new IndentApprovalDeskBO();
			vo = new IndentApprovalDeskVO();
			mmsUtil = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			HisUtil  util = new HisUtil("MMS", "IndentApprovalDeskDATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
						
			String strChk       = formBean.getStrChk();
			            
			String[] temp       = strChk.split("\\@");
			String strLevelType = temp[0];
			String strStoreId   = temp[1];
			String strToStoreId = temp[2];
			String strItemCatg  = temp[3];
			String strReqNo     = temp[4];
			String[] temp1      = temp[5].split("\\$");
			String strReqTypeId = temp1[0];
							
			vo.setStrReqNo(strReqNo);
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatgNo(strItemCatg);
			vo.setStrToStoreId(strToStoreId);
			vo.setStrLevelType(strLevelType);
			
			vo.setStrFinancialStartYear(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinancialEndYear(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
           
			
			formBean.setStrLevelType(strLevelType);
			
			System.out.println("-----(IndentApprovalDeskDATA . ApprovedRecord)--Pass--Req_type---"+vo.getStrReqTypeId());
		    
			/*----------Calling BO Method-----------*/
			bo.ApprovalData(vo);
			
			
		/*  
		    1. Req No
            2. Req Store Name
            3. Req Date
            4. Catg Name
            5. Indent Name
            6. To_Store Name
            7. Req Status
            8. Indent Period
            9. Last Approved By
           10. Last Approval Date
           11. Last Approval Level
           12. Committe Type
           13. Indent Period Value
           14, Urgent Flag
           15. Remarks       
           
           vo.setStrIndentDetailsWs(wb)
           
          */    
		  
		   if( vo.getStrIndentDetailsWs().size() > 0)
		   {
			   if(vo.getStrIndentDetailsWs().next())
			   {
				   vo.setStrLastAppLevel(vo.getStrIndentDetailsWs().getString(11));
			   }
		   }
		   vo.getStrIndentDetailsWs().beforeFirst();
		   
		   System.out.println("--[ 0 - No Approval Done,1-Ist Level Approval Done , 2-IInd Level Approval Done]--"+vo.getStrLastAppLevel());
		   
			
			//if(hosCode.equals("21917"))  // AIIMS Bhuveneshwar Production
			//{				       
				bo.getAppLevelBasedOnSeatId(vo);
			//}  
			
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			/*------------- Get Item Details ---------------*/
			if(vo.getStrReqTypeId().equals("61"))
			{
			    str1=IndentApprovalDeskHLP.getAgendaItemDetails(vo);
			}
			else
			{	
			   if(vo.getStrReqTypeId().equals("65"))
			   {
				  str1=IndentApprovalDeskHLP.getIssueToThirdPartyItemDetails(vo);
			   }
			   else
			   {	
			      if(vo.getStrReqTypeId().equals("12") || vo.getStrReqTypeId().equals("13") || vo.getStrReqTypeId().equals("14") || vo.getStrReqTypeId().equals("10"))
			      {
				     str1=IndentApprovalDeskHLP.getItemDetails1(vo);
			      }
			      else
			      {			
				    if(vo.getStrReqTypeId().equals("17"))
				    {
				    	
				    	System.out.println("-----vo.getStrHospitalCode()-------"+vo.getStrHospitalCode());
				    	
				    	System.out.println("-----IndentApprovalDeskHLP.getIssueItemDetails_Bhatinda-------");
				    	
				    	str1=IndentApprovalDeskHLP.getIssueItemDetails_Bhatinda(vo);
				    	/*
				    	if(vo.getStrHospitalCode().equals("93915"))   // Bhatinda			    	
				    	{				    		
				    						    		  
				    		//str1=IndentApprovalDeskHLP.getIssueItemDetails_Bhatinda(vo);
				    		str1=IndentApprovalDeskHLP.getIssueItemDetails_Bhatinda(vo);

				    	}
				    	else
				    	{
				    		//str1=IndentApprovalDeskHLP.getIssueItemDetails(vo);
				    		str1=IndentApprovalDeskHLP.getIssueItemDetails_Bhatinda(vo);
				    	}
				    	*/
				    }	
				    else
				    {	
					   if(vo.getStrReqTypeId().equals("16") || vo.getStrReqTypeId().equals("19"))
					   {
						 						        
					        if (vo.getStrCommitteTypeWS() != null && vo.getStrCommitteTypeWS().size() > 0) 
							{
					        	 committeType = util.getOptionValue(vo.getStrCommitteTypeWS(), "0","0^Select Unit", false);
							} 
							else
							{
								 committeType = "<option value='0'>Select Unit</option>";
							}	
					        formBean.setStrCommitteTypeCmb(committeType);
					        str1=IndentApprovalDeskHLP.getItemDetails(vo);
									        
					  }
					  else
					  {
					    if(vo.getStrReqTypeId().equals("47"))
					    {	  
						  str1=IndentApprovalDeskHLP.getItemDetailsReturnFromSupplier(vo);
					    }	
					    else
					    {	  
					    	if(vo.getStrReqTypeId().equals("64"))
					    	{
					    	   str1 = IndentApprovalDeskHLP.getItemDetailsForReceiveFromThirdParty(vo);
					    	}	
					    	else
					    	{	
					    	   System.out.println("******** IndentApprovalDeskHLP.getItemDetails ************");
					    	   str1=IndentApprovalDeskHLP.getItemDetails(vo);
					    	}  
					    }
					  }  
				   }  
			    }
			  }
			}
			/*---------Here We Get Indent Details-----------*/			
			if(vo.getStrReqTypeId().equals("61"))
			{	
			  str3=IndentApprovalDeskHLP.getIndentDetailsForApproval(vo);
			}
			else
			{
			  if(vo.getStrReqTypeId().equals("47"))
			  {	 
				 str3=IndentApprovalDeskHLP.getIndentDetailsReturnToSupplier(vo);
			  }
			  else
			  {
				    
				      str3=IndentApprovalDeskHLP.getIndentDetails(vo);
			    	  
			  }	 
			}	
			if(vo.getStrReqTypeId().equals("80")||vo.getStrReqTypeId().equals("81")||vo.getStrReqTypeId().equals("82")||vo.getStrReqTypeId().equals("83")||vo.getStrReqTypeId().equals("84")||vo.getStrReqTypeId().equals("85"))
			{	
			  str4=ApprovalDtlHLP.getPreTechApprovalDtl(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), vo.getStrItemCatgNo(), vo.getStrReqTypeId(), vo.getStrReqNo(),vo.getStrSeatId());
			  formBean.setStrSetPreTechApprovedDetails(str4);
			}
			else
			{	
				str4  =  ApprovalDtlHLP.getApprovalDtl(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), temp[3], vo.getStrReqTypeId(), vo.getStrReqNo());
				formBean.setStrSetApprovedDetails(str4);
			}
			//if(hosCode.equals("21917"))  // AIIMS Bhuveneshwar Production
			//{
			String  stArr [] = vo.getStrGrpId().split("\\$");
			if((stArr[2].toString()).trim().equals("1") || (stArr[2].toString()).trim()=="1")
			{	
				sb.append("<table class='TABLEWIDTH' cellspacing='1px' cellpadding='1px' border='0' align='center'>");
				sb.append("<tbody>");
				sb.append("<tr><td  colspan='4' class='CONTROL'><b>Login User Details </b></td></tr>");
				sb.append("<tr>");				
				sb.append("<td class='multiLabel' width='25%'>Authority Name</td>");
				sb.append("<td class='multiLabel' width='10%'>Level</td>");
				sb.append("<td class='multiLabel' width='50%'>Information</td>");
				sb.append("<td class='multiLabel' width='10%'>Apply Special Approval Power</td>");
				sb.append("</tr>");
								
				sb.append("<tr>");
				 
				sb.append("<td class='Approved' width='25%'>"+stArr[0]+"</td>");
				sb.append("<td class='Approved' width='10%'>"+stArr[1]+"</td>");
				if((stArr[2].toString()).trim().equals("1") || (stArr[2].toString()).trim()=="1")
				{
					//System.out.println("---A-stArr[2]---"+stArr[2]);
				    sb.append("<td class='Approved' width='50%'>Spercial Approval Applicable [ In This Case Any User at any Level Can Override the Other Level User ] \n If Any one Choose Special Approval Case  Other Approval Level will be Over-Ride \n All Activity must be Save in LOG </td>");
				}
				else
				{
					//System.out.println("---B-stArr[2]---"+stArr[2]);
					sb.append("<td class='Approved' width='50%'>Spercial Approval Not Applicable Every Level User Do their Approval</td>");	
				}
				sb.append("<td class='Approved' width='10%'  id='a' style='text-align:center;'><input type='checkbox' name='batchCheckbox' id='batchCheckbox'  onclick='clickChkBox();' >");
				sb.append("</tr>");
				
				sb.append("</tbody>");
				sb.append("</table>");
				
				//formBean.setStrSetApprovedDetails(sb.toString()+""+formBean.getStrSetApprovedDetails());
				
			}	
				
			
			formBean.setStrDeliveryDate(vo.getStrDeliveryDate());
			
			formBean.setStrSetItemDetails(str1);
			formBean.setStrIndentDetails(str3);
			formBean.setStrRequestName(vo.getStrIndentName());
			formBean.setStrMultiRow(vo.getStrMultiRow());
			
			formBean.setStrSpecialAppDtls(vo.getStrGrpId()); // User Name $ Level $ Special APP Flg
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentApprovalDeskDATA.ApprovedRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentApprovalDeskDATA->ApprovedRecord()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	/**
	 * Method is Used to get the Data for Approved Page of
	 * Approval Desk on the basis of Request Type Id 
	 * @param formBean
	 * @param request
	 */
	public static void ApprovedRecord1(HttpServletRequest request,IndentApprovalDeskFB formBean) 
	{
		IndentApprovalDeskBO bo = null;
		IndentApprovalDeskVO vo = null;
		String strmsgText = "";
	//	String str1 ="";
		String str3 ="";
		String strNonDiscrepancyRpt = "";
		String strDiscripancyRpt    = "";
		try 
		{
			bo = new IndentApprovalDeskBO();
			vo = new IndentApprovalDeskVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId  = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
						
			String strChk       = formBean.getStrChk();
			            
			String[] temp       = strChk.split("\\@");
			String strLevelType = temp[0];
			String strStoreId   = temp[1];
			String strToStoreId = temp[2];
			String strItemCatg  = temp[3];
			String strReqNo     = temp[4];
			String[] temp1      = temp[5].split("\\$");
			String strReqTypeId = temp1[0];
							
			vo.setStrReqNo(strReqNo);
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatgNo(strItemCatg);
			vo.setStrToStoreId(strToStoreId);
			formBean.setStrLevelType(strLevelType);
		    formBean.setStrStoreId(strStoreId);
		    formBean.setStrReqNo(strReqNo);
			bo.ApprovalData(vo);
				
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			if(vo.getStrReqTypeId().equals("69"))
			{
			                 str3    = IndentApprovalDeskHLP.getIndentDetailsForPhysicalStockVerification(vo);
			    strDiscripancyRpt    = DiscrepancyReportHLP.getDiscrepancyReport(vo.getStrHospitalCode(), vo.getStrStoreId(), vo.getStrReqNo());
			    strNonDiscrepancyRpt = DiscrepancyReportHLP.getGroupCombo(vo.getStrHospitalCode(), vo.getStrStoreId(), vo.getStrReqNo());
			}
			
			formBean.setStrNonDiscrepancyRpt(strNonDiscrepancyRpt);
			formBean.setStrDiscripancyRpt(strDiscripancyRpt);
			formBean.setStrIndentDetails(str3);
			formBean.setStrRequestName(vo.getStrIndentName());
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentApprovalDeskDATA.ApprovedRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentApprovalDeskDATA->ApprovedRecord()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	

	/**
	 * Method is Used to get the Data for view Page of
	 * Approval Desk 
	 * @param formBean
	 * @param request
	 */
	public static void viewDataPhysicalStockVerification(IndentApprovalDeskFB formBean,HttpServletRequest request) 
	{
		IndentApprovalDeskBO bo = null;
		IndentApprovalDeskVO vo = null;
		String strmsgText = "";
	//	String str1 ="";
		String str2 ="";
		String str3 ="";
		String strNonDiscrepancyRpt = "";
		String strDiscripancyRpt    = "";
		try 
		{
			bo = new IndentApprovalDeskBO();
			vo = new IndentApprovalDeskVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			String strChk = formBean.getStrChk();
						
			String[] temp       = strChk.split("\\@");
			String strLevelType = temp[0];
			String strStoreId   = temp[1];
	//		String strToStoreId = temp[2];
			String strItemCatg  = temp[3];
			String strReqNo     = temp[4];
	//		String[] temp1      = temp[5].split("\\$");
	//		String strReqTypeId = temp1[0];
                        
			vo.setStrReqNo(strReqNo);
			vo.setStrReqTypeId(formBean.getStrReqTypeId());
			vo.setStrStoreId(strStoreId);
			formBean.setStrLevelType(strLevelType);
			 

			vo.setStrReqNo(strReqNo);
			vo.setStrItemCatgNo(strItemCatg);
			vo.setStrReqTypeId(formBean.getStrReqTypeId());
			vo.setStrStoreId(strStoreId);
			vo.setStrToStoreId(temp[2]);
			formBean.setStrLevelType(strLevelType);
		    formBean.setStrStoreId(strStoreId);
		    formBean.setStrReqNo(strReqNo);
			
         	bo.viewData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			if(vo.getStrReqTypeId().equals("69"))
			{
			                 str3    = IndentApprovalDeskHLP.getIndentDetailsViewForPhysicalStockVerification(vo);
			    strDiscripancyRpt    = DiscrepancyReportHLP.getDiscrepancyReport(vo.getStrHospitalCode(), vo.getStrStoreId(), vo.getStrReqNo());
			    strNonDiscrepancyRpt = DiscrepancyReportHLP.getGroupCombo(vo.getStrHospitalCode(), vo.getStrStoreId(), vo.getStrReqNo());
			}
			str2 = ApprovalDtlHLP.getApprovalDtl(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), temp[3], vo.getStrReqTypeId(), vo.getStrReqNo());
			formBean.setStrSetApprovedDetails(str2);
			formBean.setStrNonDiscrepancyRpt(strNonDiscrepancyRpt);
			formBean.setStrDiscripancyRpt(strDiscripancyRpt);
			formBean.setStrIndentDetails(str3);
			formBean.setStrRequestName(vo.getStrIndentName());

		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentApprovalDeskDATA.viewDataPhysicalStockVerification(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentApprovalDeskDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	
	
	/**
	 * Method is Used to get the Data for view Page of
	 * Approval Desk 
	 * @param formBean
	 * @param request
	 */
	public static void viewData(IndentApprovalDeskFB formBean,HttpServletRequest request) 
	{
		IndentApprovalDeskBO bo = null;
		IndentApprovalDeskVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";
		String str4 ="";
		MmsConfigUtil mmsUtil = null;
		try 
		{
			bo = new IndentApprovalDeskBO();
			vo = new IndentApprovalDeskVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				   mmsUtil = new MmsConfigUtil(hosCode);
			String seatId  = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			
			String strChk = formBean.getStrChk();
								
			String[] temp       = strChk.split("\\@");
			String strLevelType = temp[0];
			String strStoreId   = temp[1];
	//		String strToStoreId = temp[2];
	//		String strItemCatg  = temp[3];
			String strReqNo     = temp[4];
	//		String[] temp1      = temp[5].split("\\$");
	//		String strReqTypeId = temp1[0];

			vo.setStrReqNo(strReqNo);
			vo.setStrReqTypeId(formBean.getStrReqTypeId());
			vo.setStrStoreId(strStoreId);
			formBean.setStrLevelType(strLevelType);
			vo.setStrItemCatgNo(temp[3]);				
			vo.setStrReqNo(strReqNo);
			vo.setStrReqTypeId(formBean.getStrReqTypeId());
			vo.setStrStoreId(strStoreId);
			vo.setStrToStoreId(temp[2]);
			
			vo.setStrFinancialStartYear(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinancialEndYear(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			
			System.out.println("----- IndentApprovalDeskDATA . viewData ----Req_type---"+vo.getStrReqTypeId());

			
			bo.viewData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			
			  if(formBean.getStrReqTypeId().equals("12") || formBean.getStrReqTypeId().equals("13") || formBean.getStrReqTypeId().equals("14") || formBean.getStrReqTypeId().equals("10"))
			  {
				
				  str1 = IndentApprovalDeskHLP.getItemDetailsView1(vo);
			  }
			  else
			  {
				
				 if(formBean.getStrReqTypeId().equals("47"))  
				 {  					
				     str1 = IndentApprovalDeskHLP.getItemDetailsReturnFromSupplier(vo);
				 }
				 else
				 {
					 if(formBean.getStrReqTypeId().equals("64"))
					 {
						str1 = IndentApprovalDeskHLP.getItemDetailsForReceiveFromThirdParty(vo);
					 }	 
					 else
					 {	 
					    str1 = IndentApprovalDeskHLP.getItemDetailsView(vo);
					 }  
					 
				 }	
			  }	
			
			str2  =  ApprovalDtlHLP.getApprovalDtl(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), temp[3], vo.getStrReqTypeId(), vo.getStrReqNo());
			formBean.setStrSetApprovedDetails(str2);
			
			if(formBean.getStrReqTypeId().equals("47"))  
			{  					
			    str3 = IndentApprovalDeskHLP.getIndentDetailsReturnToSupplierView(vo);
			}
			else
			{
				
				   str3 = IndentApprovalDeskHLP.getIndentDetailsView(vo);
				   
			}	
			
			if(vo.getStrReqTypeId().equals("80")||vo.getStrReqTypeId().equals("81")||vo.getStrReqTypeId().equals("82")||vo.getStrReqTypeId().equals("83")||vo.getStrReqTypeId().equals("84")||vo.getStrReqTypeId().equals("85"))
			{	
			  str4=ApprovalDtlHLP.getPreTechApprovalDtl(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), vo.getStrItemCatgNo(), vo.getStrReqTypeId(), vo.getStrReqNo(),vo.getStrSeatId());
			  formBean.setStrSetPreTechApprovedDetails(str4);
			}
			
			formBean.setStrSetItemDetails(str1);
			formBean.setStrIndentDetails(str3);
			
			formBean.setStrRequestName(vo.getStrIndentName());
			formBean.setStrMultiRow(vo.getStrMultiRow());
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentApprovalDeskDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentApprovalDeskDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	
	public static void indentAppPrint(HttpServletRequest request,HttpServletResponse response,IndentApprovalDeskFB formBean) 
	{
		IndentApprovalDeskBO bo = null;
		IndentApprovalDeskVO vo = null;
		String strmsgText = "";
		String str1 ="";
		String str2 ="";
		String str3 ="";
		String str4 ="";		
		StringBuffer sb = new StringBuffer("");
		String finalPrint = "";
		try 
		{
			bo = new IndentApprovalDeskBO();
			vo = new IndentApprovalDeskVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();				 
			String seatId  = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			
	       	vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);	
			
			String strChk       = (String) request.getParameter("strChk");
			String strReqTypeId = (String) request.getParameter("strReqTypeId");
			
			
						
			String[] temp       = strChk.split("\\@");
			String strLevelType = temp[0];
			String strStoreId   = temp[1];
	//		String strToStoreId = temp[2];
	//		String strItemCatg  = temp[3];
			String strReqNo     = temp[4];
			String[] temp1      = temp[5].split("\\$");
					

			vo.setStrReqNo(strReqNo);
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrStoreId(strStoreId);
			formBean.setStrLevelType(strLevelType);
			vo.setStrItemCatgNo(temp[3]);				
			vo.setStrReqNo(strReqNo);			
			vo.setStrStoreId(strStoreId);
			vo.setStrToStoreId(temp[2]);
			
			
			System.out.println("----- IndentApprovalDeskDATA . indentAppPrint ----Req_type---"+vo.getStrReqTypeId());
			
			String strTableWidth = "825";
			
			vo.setStrTableWidth(strTableWidth);

			
			bo.viewData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			
			  if(formBean.getStrReqTypeId().equals("12") || formBean.getStrReqTypeId().equals("13") || formBean.getStrReqTypeId().equals("14") || formBean.getStrReqTypeId().equals("10"))
			  {
				
				  str1 = IndentApprovalDeskHLP.getItemDetailsView1Print(vo);
			  }
			  else
			  {
				
				 if(formBean.getStrReqTypeId().equals("47"))  
				 {  					
				     str1 = IndentApprovalDeskHLP.getItemDetailsReturnFromSupplierPrint(vo);
				 }
				 else
				 {
					 if(formBean.getStrReqTypeId().equals("64"))
					 {
						str1 = IndentApprovalDeskHLP.getItemDetailsForReceiveFromThirdPartyPrint(vo);
					 }	 
					 else
					 {	 
					    str1 = IndentApprovalDeskHLP.getItemDetailsViewPrint(vo);
					 }  
					 
				 }	
			  }	
			
			str2  =  ApprovalDtlHLP.getApprovalDtlPrint(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), temp[3], vo.getStrReqTypeId(), vo.getStrReqNo());
			formBean.setStrSetApprovedDetails(str2);
			
			if(formBean.getStrReqTypeId().equals("47"))  
			{  					
			    str3 = IndentApprovalDeskHLP.getIndentDetailsReturnToSupplierViewPrint(vo);
			}
			else
			{
				
				   str3 = IndentApprovalDeskHLP.getIndentDetailsViewPrint(vo);
				   
			}	
			
			/*
			if(vo.getStrReqTypeId().equals("80")||vo.getStrReqTypeId().equals("81")||vo.getStrReqTypeId().equals("82")||vo.getStrReqTypeId().equals("83")||vo.getStrReqTypeId().equals("84")||vo.getStrReqTypeId().equals("85"))
			{	
			  str4=ApprovalDtlHLP.getPreTechApprovalDtl(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), vo.getStrItemCatgNo(), vo.getStrReqTypeId(), vo.getStrReqNo(),vo.getStrSeatId());
			  formBean.setStrSetPreTechApprovedDetails(str4);
			}
			*/
			
			
			HisUtil hisUtil=new HisUtil("Global","ReportUtil");
			HospitalMstVO hospitalVO=hisUtil.getHospitalDetail(hosCode);
			
            sb.append("<style>@media screen and (orientation: potrait) { #toolbar {position: fixed; width: 2.65em; height: 100%; } p { margin-left: 2em;} li + li {margin-top: .5em;}}</style>");
			
			sb.append("<table align='center' width='").append(strTableWidth).append("' border='0' cellspacing='0' cellpadding='0' height='69'> ");
			sb.append("<tr><td align='center' ><div><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td> ");
            //sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='4'> ");

			//sb.append(hospitalVO.getHospitalName());
			//sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
			sb.append("</tr> ");
//			sb.append("<tr> ");
//			sb.append("<td width='8%'>&nbsp;</td> ");
//			sb.append("<td width='82%' align='center'> <b><font face='Verdana, Arial, Helvetica, sans-serif' size='2'> ");
//			sb.append(((hospitalVO.getAddress1()==""||hospitalVO.getAddress1()==null)?" ":(hospitalVO.getAddress1()+","))+((hospitalVO.getAddress2()==""||hospitalVO.getAddress2()==null)?" ":(hospitalVO.getAddress2()+","))+ ((hospitalVO.getCity()==""||hospitalVO.getCity()==null)?" ":(hospitalVO.getCity()+","))+((hospitalVO.getPinCode()==""||hospitalVO.getPinCode()==null)?" ":(hospitalVO.getPinCode()))+"");
//
//			sb.append("</font></b></td> <td width='10%'>&nbsp;</td> ");
//			sb.append("</tr> ");
			sb.append("</table> ");
			
			sb.append("<TABLE ALIGN='CENTER' cellspacing='1px' cellpadding='1px' border='0' WIDTH='"+strTableWidth+"'>");
			sb.append("<tr> ");
			sb.append("<td align='right'>");
			sb.append("<div id='saveId' style='display : block'> <div id='printid1' class='hidecontrol' align='right'>");
			sb.append("<img style='cursor: pointer; ' title='Print Page'  ");
			sb.append(" src='../../hisglobal/images/printer_symbol.gif' onClick='printData();' /> <img style='cursor: pointer; ' title='Cancel Process'  ");
			sb.append(" src='../../hisglobal/images/stop.png' onClick='hideIssuePopup(),cancelToDesk();' /> </div></div>");
			sb.append(" </td> ");
			sb.append(" </tr> ");
			sb.append(" </table> ");
			
			sb.append(str3+""+str1+""+str2);
			
			finalPrint = sb.toString();
										
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(finalPrint);
		}
		  catch (Exception e) 
		  {
            e.printStackTrace(); 
			strmsgText = "IndentApprovalDeskDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentApprovalDeskDATA->viewData()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			sb = null;
		}

	}
	
	
	
	
	
	/**
	 * This Method is used to insert approval details into database
	 * @param  FormBean
	 * @param  request
	 */
	public static boolean insertDataPhysicalStockVerification(IndentApprovalDeskFB formBean,
			HttpServletRequest request) 
	{
		IndentApprovalDeskBO      bo = null;
		IndentApprovalDeskVO      vo = null;
		String            strmsgText = "";
		MmsConfigUtil            mcu = null;
        String strFinancialStartYear = "";
	    String   strFinancialEndYear = "";
	    String               hosCode = "";
	    String                seatid = "";
	    String                ipAddr = "";
	    String                strChk = "";
	//    String               strPath = "";
	    String       strApprovalType = "";
	    boolean retValue = true;
		try 
		{
			 bo = new IndentApprovalDeskBO();
			 vo = new IndentApprovalDeskVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		   // strFinancialStartYear = mcu.getStrFinancialStartDate();
	        //  strFinancialEndYear = mcu.getStrFinancialEndDate();
	          
	          
	       	              hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			               seatid = request.getSession().getAttribute("SEATID").toString();
			               ipAddr = request.getSession().getAttribute("IP_ADDR").toString();
			               strChk = request.getParameter("strChk");
			      //        strPath = request.getParameter("strPath");

			String[] temp       = strChk.split("\\@");
			String strLevelType = temp[0];
			String strStoreId   = temp[1];
			String strToStoreId = temp[2];
			String strItemCatg  = temp[3];
			String strReqNo     = temp[4];
			String[] temp1      = temp[5].split("\\$");
			String strReqTypeId = temp1[0];
			
			strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId , hosCode);
			strFinancialEndYear = mcu.getStrFinancialEndDate(strStoreId , hosCode);
			
			
            vo.setStrSeatId(seatid);	
			vo.setStrHospitalCode(hosCode);
			vo.setStrIpAddr(ipAddr);
			vo.setStrReqNo(strReqNo);
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrStoreId(strStoreId);
			vo.setStrLevelType(strLevelType);
			vo.setStrItemCatgNo(strItemCatg);
			vo.setStrToStoreId(strToStoreId);
			
			if(formBean.getStrApproved().equals("1"))
		    {
				strApprovalType = "1";
		    }	
		    else
		    {
		    	strApprovalType = "2";
		    }
					
			vo.setStrApprovalType(strApprovalType);
			vo.setStrApproved(formBean.getStrApproved());
			vo.setStrRejected(formBean.getStrRejected());
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrFinancialStartYear(strFinancialStartYear);
			//vo.setStrInsertHiddenValue(formBean.getStrInsertHiddenValue());	
			vo.setStrRemarks(formBean.getStrRemarks());
			//vo.setStrInsSancQty(formBean.getStrInsSancQty());
			//vo.setStrInsUnitCombo(formBean.getStrInsUnitCombo());
			//vo.setStrIssueFrmReservStock(formBean.getStrIssueFrmReservStock());
			           				
			bo.INSERT(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}
	    	else 
			{
	    		
				formBean.setStrMsg("Saved Successfully");
			}
			
		}
		  catch (Exception e) 
		  {
			  retValue = false;
	        e.printStackTrace(); 
			strmsgText = "IndentApprovalDeskDATA.insertDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentApprovalDeskDATA->insertDetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}
	

	/**
	 * This Method is used to insert approval details into database
	 * @param  FormBean
	 * @param  request
	 */
	public static boolean insertDetails(IndentApprovalDeskFB formBean,
			HttpServletRequest request) 
	{
		IndentApprovalDeskBO      bo = null;
		IndentApprovalDeskVO      vo = null;
		String            strmsgText = "";
		MmsConfigUtil            mcu = null;
        String strFinancialStartYear = "";
	    String strFinancialEndYear   = "";
	    String hosCode               = "";
	    String seatid                = "";
	    String ipAddr                = "";
	    String strChk                = "";
	//    String strPath               = "";
	    boolean retValue = true;
		try 
		{
			
			System.out.println("------IndentApprovalDeskDATA.insertDetails---[ START ]---");
			
               bo = new IndentApprovalDeskBO();
               vo = new IndentApprovalDeskVO();
              hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
              mcu = new MmsConfigUtil(hosCode);
              seatid = request.getSession().getAttribute("SEATID").toString();
              ipAddr = request.getSession().getAttribute("IP_ADDR").toString();
              strChk = request.getParameter("strChk");
       //       strPath = request.getParameter("strPath");
             
			String[]   temp       = strChk.split("\\@");
			String   strLevelType = temp[0];
			String   strStoreId   = temp[1];
			String   strToStoreId = temp[2];
			String   strItemCatg  = temp[3];
			String   strReqNo     = temp[4];
			String[]   temp1      = temp[5].split("\\$");
			String   strReqTypeId = temp1[0];
			
			System.out.println("-------------------------------");
			System.out.println("-----strLevelType---"+strLevelType);
			System.out.println("-----strStoreId---"+strStoreId);
			System.out.println("-----strToStoreId---"+strToStoreId);
			System.out.println("-----strReqNo---"+strReqNo);
			System.out.println("-----strReqTypeId---"+strReqTypeId);
			System.out.println("-------------------------------");
			
			
			strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId , hosCode);
			strFinancialEndYear   = mcu.getStrFinancialEndDate(strStoreId , hosCode);
			
            vo.setStrSeatId(seatid);	
			vo.setStrHospitalCode(hosCode);
			vo.setStrIpAddr(ipAddr);
			vo.setStrReqNo(strReqNo);
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrStoreId(strStoreId);
			vo.setStrLevelType(strLevelType);
			vo.setStrItemCatgNo(strItemCatg);
			vo.setStrToStoreId(strToStoreId);			
					
			String strApprovalType = "";
			if(formBean.getStrApproved().equals("1"))
		    {
				strApprovalType = "1";
		    }	
		    else
		    {
		    	strApprovalType = "2";
		    }
			if(strReqTypeId.equals("16")||strReqTypeId.equals("47")||strReqTypeId.equals("18")||strReqTypeId.equals("65"))
			{
				
				
				vo.setStrItemSlNo(formBean.getStrItemSlNo());
				vo.setStrStockStatusCode(formBean.getStrStockStatusCode());
				vo.setStrBatchNo(formBean.getStrBatchNo());
				if(strReqTypeId.equals("16"))
				{	
				   ////System.out.println("Indesxntr for condentiomn"+formBean.getStrCommitteTypeCode());
				   vo.setStrCommitteTypeCode(formBean.getStrCommitteTypeCode());
				   vo.setStrCommitteRemarks(formBean.getStrRemarks());
				 
				} 
				else
				{
				   vo.setStrCommitteTypeCode("");
				   vo.setStrCommitteRemarks("");
				}	
				
				if(strReqTypeId.equals("47"))
				{	
					vo.setStrDeliveryDate(formBean.getStrDeliveryDate());
					vo.setStrReturnType(formBean.getStrReturnTypeCmb());
				 
				} 
				else
				{
					vo.setStrDeliveryDate("");
					vo.setStrReturnType("");
				}	
				
			}

			vo.setStrBatchNo(formBean.getStrBatchNo());
			vo.setStrStockStatusCode(formBean.getStrStockStatusCode());
			vo.setStrItemSlNo(formBean.getStrItemSlNo());
			vo.setStrApprovalType(strApprovalType);
			vo.setStrApproved(formBean.getStrApproved());
			vo.setStrRejected(formBean.getStrRejected());
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrInsertHiddenValue(formBean.getStrInsertHiddenValue());	
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrInsSancQty(formBean.getStrInsSancQty());
			vo.setStrSpecialAppFlg(formBean.getStrSpecialAppFlg());
//			for(int i=0;i<formBean.getStrInsUnitCombo().length;i++)
//			{	
//			  //System.out.println("Unit Combo::::"+formBean.getStrInsUnitCombo()[i]);	
//			  //System.out.println("Unit ::::"+formBean.getStrInsUnitCombo()[i].split("\\^")[0]);
//			}
			vo.setStrInsUnitCombo(formBean.getStrInsUnitCombo());
			vo.setStrIssueFrmReservStock(formBean.getStrIssueFrmReservStock());
			vo.setStrItemRemarks(formBean.getStrItemRemarks());
		    // Calling BO Method    
			//if((vo.getStrSpecialAppFlg().trim()).equals("0"))
			//{
			    bo.INSERT(vo);
			//}
			//else
			//{
			//	bo.INSERT_SPECIAL_APPROVAL(vo);
			//}
			
			if (vo.getStrMsgType().equals("1")) 
			{
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}
	    	else 
			{
	    		if((vo.getStrSpecialAppFlg().trim()).equals("0"))
				{
	    			formBean.setStrMsg("Saved Successfully");
				}
	    		else
	    		{   
	    			// Invapp ( inv_app1 ) $ 1 $  1 
	    			formBean.setStrMsg("Special Approval at All Level By User "+formBean.getStrSpecialAppDtls().split("\\$")[0]+" Saved Successfully");
	    		}
			}
			
			System.out.println("------IndentApprovalDeskDATA.insertDetails---[ END ]---");
			
		}
		  catch (Exception e) 
		  {
			  retValue = false;
	        e.printStackTrace(); 
			strmsgText = "IndentApprovalDeskDATA.insertDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentApprovalDeskDATA->insertDetails()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+eObj.getErrorID()+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;

	}
	
	/**
	 * Method used to get Blocked Item Detail For 
	 * Blocked Item Detail PoPup 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getBlockedItemDtl(IndentApprovalDeskFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
		IndentApprovalDeskBO  bo = null;
		IndentApprovalDeskVO  vo = null;
		String       strmsgText  = "";
		String       strHospCode = "";
		String      strHiddenVal = "";
		String strRasingReceving = "";
		String               str = "";
		String[]            temp = null;

		try {

			                 bo = new IndentApprovalDeskBO();
			                 vo = new IndentApprovalDeskVO();
          			strHospCode = request.getSession().getAttribute("HOSPITAL_CODE").toString(); 
			       strHiddenVal = request.getParameter("param");
			  strRasingReceving = request.getParameter("RasingReceving");
			    		   temp = strHiddenVal.split("\\@");
			    		   
			    		   
			vo.setStrHospitalCode(strHospCode);
			vo.setStrItemId(temp[0]);
			vo.setStrStoreId(temp[1]);
			vo.setStrItemBrandId(temp[2]);
			vo.setStrReqNo(temp[3]);
			vo.setStrBatchNoBlocked(temp[4]);
			vo.setStrItemSlNoBlocked(temp[5]);
			vo.setStrStockStatusCodeBlocked(temp[6]);
			vo.setStrToStoreId(temp[7]);
			vo.setStrReqTypeId(temp[8]);
			vo.setStrHospCode(strHospCode);
			vo.setStrRasingRecevingFlg(strRasingReceving);
		
//			//System.out.println("Item Id -->" + temp[0]);
//			//System.out.println("DATA strstoreId-->" + temp[1]);
//			//System.out.println("DATA setStrItemBrandId-->" + temp[2]);
//			//System.out.println("DATA setStrReqNo-->" + temp[3]);
//			//System.out.println("DATA setStrBatchNo-->" + temp[4]);
//			//System.out.println("DATA setStrItemSlNo-->" + temp[5]);
//			//System.out.println("DATA setStrStockStatusCode-->" + temp[6]);
//			//System.out.println("DATA To Store ID-->>"+temp[7]);
//			//System.out.println("DATA Req Type ID -->>"+temp[8]);
//            //System.out.println("DATA strRasingReceving-->>"+strRasingReceving);
            
			// Calling BO Method
     		bo.getBlockItemDtl(vo);
     		str  = IndentApprovalDeskHLP.getBlockedItemDetails(vo,strRasingReceving);
            
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			try 
			{
					response.setHeader("Cache-Control", "no-cache");
					response.getWriter().print(str);

			} 
			catch (Exception e) 
			{
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			

		} 
		catch (Exception e) {

			e.printStackTrace();
			strmsgText = "IndentApprovalDeskDATA.getBlockedItemDtl(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("mms","IndentApprovalDeskDATA->getBlockedItemDtl()",
					strmsgText);
			try 
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : "+ eObj.getErrorID()+ "],Contact System Administrator! ");
			} 
			catch (Exception e1) 
			{
				// TODO Auto-generated catch block
				
			}
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			
		}
	}

	/*public static void genCertificate(
			HttpServletRequest request,HttpServletResponse response){
				String result="";
			String strmsgText="";
		
			try{
				
				
			}catch(Exception e){
					e.printStackTrace();
				strmsgText = "mms.transactions.IndentApprovalDeskDATA.genCertificate --> "
						+ e.getMessage();
			}
					
		
	}*/
	
	public static void getVoucherDtl(IndentApprovalDeskFB formBean,HttpServletRequest request,HttpServletResponse response) 
	{

		IndentApprovalDeskBO bo = null;
		IndentApprovalDeskVO vo = null;
		
		try 
		{
			String strHmode = (String) request.getParameter("hmode");
			String strItemId = (String) request.getParameter("itemId");
			String strStoreId = (String) request.getParameter("storeId");
			String strTostoreId = (String) request.getParameter("tostoreId");			
			String strItemBrandId = (String) request.getParameter("itemBrandId");
			String appLevel = (String) request.getParameter("appLevel");
			
			bo = new IndentApprovalDeskBO();
			vo = new IndentApprovalDeskVO();

			
			
			System.out.println("---- IndentApprovalDeskDATA . getVoucherDtl --[ ]--");
			System.out.println("----------------------------------");
			System.out.println("--strHmode        ----"+strHmode);
			System.out.println("--strItemId ----"+strItemId);
			System.out.println("--strStoreId     ----"+strStoreId);
			System.out.println("--strItemBrandId     ----"+strItemBrandId);
			System.out.println("--strTostoreId     ----"+strTostoreId);
			System.out.println("--appLevel     ----"+appLevel);			
			System.out.println("----------------------------------");
			
		
			formBean.setStrItemId(strItemId);
			formBean.setStrItemBrandId(strItemBrandId);
			formBean.setStrStoreId(strStoreId);
			formBean.setStrTostoreId(strTostoreId);

			vo.setStrLastAppLevel(appLevel);
			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrItemBrandId(formBean.getStrItemBrandId());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrTostoreId(formBean.getStrTostoreId());			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		    
		 	bo.getStockTableHLP(vo); 
		    
		    String strIssueDtl = vo.getStrDBTabel();
		   	
		
		    if(strIssueDtl!= null && !strIssueDtl.equals(""))
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	response.getWriter().print(strIssueDtl);
			}
			else
			{
			    HisException eObj = new HisException("MMS", "ReturnFromTransDATA->getViewDtl()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }
		 
	   }catch(Exception e){
			e.printStackTrace();
	   }
	}
}



