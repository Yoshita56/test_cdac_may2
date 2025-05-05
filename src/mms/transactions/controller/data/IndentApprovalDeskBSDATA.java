package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.IndentApprovalDeskBO;
import mms.transactions.controller.fb.IndentApprovalDeskFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.DiscrepancyReportHLP;
import mms.transactions.controller.hlp.IndentApprovalDeskBSHLP;
import mms.transactions.vo.IndentApprovalDeskVO;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 1/June/2009
 * Modif Date : / /2009 
*/

public class IndentApprovalDeskBSDATA 
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
			
			vo.setStrFinancialStartYear(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinancialEndYear(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
           
			
			formBean.setStrLevelType(strLevelType);
		    
			/*----------Calling BO Method-----------*/
			bo.ApprovalData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			/*------------- Get Item Details ---------------*/
			if(vo.getStrReqTypeId().equals("61"))
			{
			    str1=IndentApprovalDeskBSHLP.getAgendaItemDetails(vo);
			}
			else
			{	
			   if(vo.getStrReqTypeId().equals("65"))
			   {
				  str1=IndentApprovalDeskBSHLP.getIssueToThirdPartyItemDetails(vo);
			   }
			   else
			   {	
			      if(vo.getStrReqTypeId().equals("12") || vo.getStrReqTypeId().equals("13") || vo.getStrReqTypeId().equals("14") || vo.getStrReqTypeId().equals("10"))
			      {
				     str1=IndentApprovalDeskBSHLP.getItemDetails1(vo);
			      }
			      else
			      {			
				    if(vo.getStrReqTypeId().equals("17"))
				    {
					    str1=IndentApprovalDeskBSHLP.getIssueItemDetails(vo);	
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
									        str1=IndentApprovalDeskBSHLP.getItemDetails(vo);
									        
					  }
					  else
					  {
					    if(vo.getStrReqTypeId().equals("47"))
					    {	  
						  str1=IndentApprovalDeskBSHLP.getItemDetailsReturnFromSupplier(vo);
					    }	
					    else
					    {	  
					    	if(vo.getStrReqTypeId().equals("64"))
					    	{
					    	   str1 = IndentApprovalDeskBSHLP.getItemDetailsForReceiveFromThirdParty(vo);
					    	}	
					    	else
					    	{	
					    	   str1=IndentApprovalDeskBSHLP.getItemDetails(vo);
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
			  str3=IndentApprovalDeskBSHLP.getIndentDetailsForApproval(vo);
			}
			else
			{
			  if(vo.getStrReqTypeId().equals("47"))
			  {	 
				 str3=IndentApprovalDeskBSHLP.getIndentDetailsReturnToSupplier(vo);
			  }
			  else
			  {
				    
				      str3=IndentApprovalDeskBSHLP.getIndentDetails(vo);
			    	  
			  }	 
			}	
			if(vo.getStrReqTypeId().equals("80")||vo.getStrReqTypeId().equals("81")||vo.getStrReqTypeId().equals("82")||vo.getStrReqTypeId().equals("83")||vo.getStrReqTypeId().equals("84")||vo.getStrReqTypeId().equals("85"))
			{	
			  str4=ApprovalDtlHLP.getPreTechApprovalDtl(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), vo.getStrItemCatgNo(), vo.getStrReqTypeId(), vo.getStrReqNo(),vo.getStrSeatId());
			  formBean.setStrSetPreTechApprovedDetails(str4);
			}
			
			formBean.setStrDeliveryDate(vo.getStrDeliveryDate());
			
			formBean.setStrSetItemDetails(str1);
			formBean.setStrIndentDetails(str3);
			formBean.setStrRequestName(vo.getStrIndentName());
			formBean.setStrMultiRow(vo.getStrMultiRow());
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
			                 str3    = IndentApprovalDeskBSHLP.getIndentDetailsForPhysicalStockVerification(vo);
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
			                 str3    = IndentApprovalDeskBSHLP.getIndentDetailsViewForPhysicalStockVerification(vo);
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

			
			bo.viewData(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			
			  if(formBean.getStrReqTypeId().equals("12") || formBean.getStrReqTypeId().equals("13") || formBean.getStrReqTypeId().equals("14") || formBean.getStrReqTypeId().equals("10"))
			  {
				
				  str1 = IndentApprovalDeskBSHLP.getItemDetailsView1(vo);
			  }
			  else
			  {
				
				 if(formBean.getStrReqTypeId().equals("47"))  
				 {  					
				     str1 = IndentApprovalDeskBSHLP.getItemDetailsReturnFromSupplier(vo);
				 }
				 else
				 {
					 if(formBean.getStrReqTypeId().equals("64"))
					 {
						str1 = IndentApprovalDeskBSHLP.getItemDetailsForReceiveFromThirdParty(vo);
					 }	 
					 else
					 {	 
					    str1 = IndentApprovalDeskBSHLP.getItemDetailsView(vo);
					 }  
					 
				 }	
			  }	
			
			str2  =  ApprovalDtlHLP.getApprovalDtlBS(vo.getStrStoreId(), vo.getStrHospitalCode(), vo.getStrToStoreId(), temp[3], vo.getStrReqTypeId(), vo.getStrReqNo());
			formBean.setStrSetApprovedDetails(str2);
			
			if(formBean.getStrReqTypeId().equals("47"))  
			{  					
			    str3 = IndentApprovalDeskBSHLP.getIndentDetailsReturnToSupplierView(vo);
			}
			else
			{
				
				   str3 = IndentApprovalDeskBSHLP.getIndentDetailsView(vo);
				   
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
//			for(int i=0;i<formBean.getStrInsUnitCombo().length;i++)
//			{	
//			  //System.out.println("Unit Combo::::"+formBean.getStrInsUnitCombo()[i]);	
//			  //System.out.println("Unit ::::"+formBean.getStrInsUnitCombo()[i].split("\\^")[0]);
//			}
			vo.setStrInsUnitCombo(formBean.getStrInsUnitCombo());
			vo.setStrIssueFrmReservStock(formBean.getStrIssueFrmReservStock());
			vo.setStrItemRemarks(formBean.getStrItemRemarks());
		    // Calling BO Method      				
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
     		str  = IndentApprovalDeskBSHLP.getBlockedItemDetails(vo,strRasingReceving);
            
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
	
}



