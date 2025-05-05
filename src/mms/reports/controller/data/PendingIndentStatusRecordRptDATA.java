package mms.reports.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.PendingIndentStatusRecordRptBO;
import mms.reports.controller.fb.PendingIndentStatusRecordRptFB;
import mms.reports.controller.hlp.PendingIndentStatusRecordRptHLP;
import mms.reports.vo.PendingIndentStatusRecordRptVO;

public class PendingIndentStatusRecordRptDATA {
	
	public static void getStoreList(PendingIndentStatusRecordRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PendingIndentStatusRecordRptBO bo = null;
		PendingIndentStatusRecordRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new PendingIndentStatusRecordRptBO();
			voObj = new PendingIndentStatusRecordRptVO();
		//	String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrItemCatId("10");

			/*if(strUserLevel.equals("6")){
				voObj.setStrMode("6");
			}
			else*/
				voObj.setStrMode("8"); // role based stores
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PendingIndentStatusRecordRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "-1", "-1^SelectValue", false);
						
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PendingIndentStatusRecordRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PendingIndentStatusRecordRptDATA->getStoreList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void getItemCatList(PendingIndentStatusRecordRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PendingIndentStatusRecordRptBO bo = null;
		PendingIndentStatusRecordRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PendingIndentStatusRecordRptBO();
			voObj = new PendingIndentStatusRecordRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrMode("2");
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PendingIndentStatusRecordRptDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrItemCatWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^SelectValue",
						true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PendingIndentStatusRecordRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PendingIndentStatusRecordRptDATA->getItemCatList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}
	
	public static void getReqTypeList(PendingIndentStatusRecordRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PendingIndentStatusRecordRptBO bo = null;
		PendingIndentStatusRecordRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PendingIndentStatusRecordRptBO();
			voObj = new PendingIndentStatusRecordRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			//added by vipul on 10.05.2021
			if (strStoreId.equals("0")){
				voObj.setStrMode("3");
				}
			else {
				voObj.setStrMode("2");
				}
			// ended by vipul on 10.05.2021
			voObj.setStrStoreId(request.getParameter("storeId"));
			voObj.setStrItemCatId(request.getParameter("catId"));
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			
			bo.getReqTypeList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PendingIndentStatusRecordRptDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrReqTypeWs().size() != 0) {
				
				temp = util.getOptionValue(voObj.getStrReqTypeWs(), "0", "0^SelectValue",
						true);

			}else{
				
				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PendingIndentStatusRecordRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PendingIndentStatusRecordRptDATA->getItemCatList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}

	/*
	public static void getPartialIssueDtls(PendingIndentStatusRecordRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
	
		PendingIndentStatusRecordRptBO bo = null;
		PendingIndentStatusRecordRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try 
		{
	
			bo = new PendingIndentStatusRecordRptBO();
			voObj = new PendingIndentStatusRecordRptVO();				
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());			
			voObj.setStrStoreId(formBean.getStrStoreId());
			voObj.setStrStoreName(formBean.getStrStoreName());
			
			voObj.setStrItemCatId(formBean.getStrItemCatNo());
			voObj.setStrCategoryName(formBean.getStrCategoryName());
	
			voObj.setStrFromDate(formBean.getStrFromDate());
			voObj.setStrToDate(formBean.getStrToDate());					
			voObj.setStrReqTypeId(formBean.getStrReqTypeId());
			voObj.setStrRptType(formBean.getStrRptType());
			
			System.out.println("getPartialIssueDtls >> formBean.getStrHospitalCode()"+ formBean.getStrHospitalCode());
			System.out.println("formBean.getStrStoreId()"+ formBean.getStrStoreId());
			System.out.println("formBean.getStrStoreName()"+ formBean.getStrStoreName());
			
			System.out.println("formBean.getStrItemCatNo()"+ formBean.getStrItemCatNo());
			System.out.println("formBean.getStrCategoryName()"+ formBean.getStrCategoryName());
	
			System.out.println("formBean.getStrFromDate()"+ formBean.getStrFromDate());
			System.out.println("formBean.getStrToDate()"+ formBean.getStrToDate());
			System.out.println("formBean.getStrReqTypeId()"+ formBean.getStrReqTypeId());
			System.out.println("formBean.getStrRptType()"+ formBean.getStrRptType());
		
									
			bo.getPartialIssueDtls(voObj);
						
			String strPartialIssueDtls = PendingIndentStatusRecordRptHLP.getPartialIssueDtls(voObj.getStrPartialIssueWs(),voObj.getStrHospitalCode(),voObj);	
			
			//System.out.println("strPartialIssueDtls----"+ strPartialIssueDtls);
			
			formBean.setStrPartialIssueDtls(strPartialIssueDtls);
			formBean.setStrStoreValues(strStoreVal);
			
	
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PendingIndentStatusRecordRptDATA.getPartialIssueDtls --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PendingIndentStatusRecordRptDATA->getPartialIssueDtls()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
	
			eObj = null;
		} finally {
	
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}
	*/
	
	
	public static void showReport(PendingIndentStatusRecordRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PendingIndentStatusRecordRptBO bo = null;
		PendingIndentStatusRecordRptVO vo = null;
		HisUtil util = null;
		try {
			
			   String strResult="";


			bo = new PendingIndentStatusRecordRptBO();
			vo = new PendingIndentStatusRecordRptVO();	
			
			util = new HisUtil("MMS", "PendingIndentStatusRecordRptDATA");
		   	
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));	
			/*
		   	System.out.println("StrCurrentDate--showReport_DATA"+formBean.getStrCurrentDate());			
			System.out.println("showReport >> voObj.setStrHospitalCode()"+ formBean.getStrHospitalCode());
			System.out.println("vo.setStrSeatId()"+ formBean.getStrSeatId());			
			System.out.println("vo.setStrStoreId()"+ request.getParameter("strStoreId"));
			System.out.println("vo.setStrStoreName()"+ request.getParameter("storeName"));
			System.out.println("vo.setStrItemCatId()"+ request.getParameter("strCategoryId"));
			System.out.println("vo.setStrCategoryName()"+ request.getParameter("strCategoryName"));
			System.out.println("vo.getStrFromDate()"+ (String)request.getParameter("strFromDate"));
			System.out.println("vo.getStrToDate()"+ (String)request.getParameter("strToDate"));
			System.out.println("vo.getStrReqTypeId()"+ request.getParameter("strReqTypeId"));
			System.out.println("vo.getStrRptType()"+ request.getParameter("strRptType"));
			*/
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());		   			   	
			vo.setStrStoreId(request.getParameter("strStoreId"));
			vo.setStrStoreName(request.getParameter("storeName"));
			vo.setStrItemCatId(request.getParameter("strCategoryId")); 	
			vo.setStrCategoryName(request.getParameter("strCategoryName")); 			
			vo.setStrFromDate((String)request.getParameter("strFromDate"));
			vo.setStrToDate((String)request.getParameter("strToDate"));			
			vo.setStrReqTypeId((String)request.getParameter("strReqTypeId"));
			vo.setStrRptType((String)request.getParameter("strRptType"));
			vo.setStrCurrentDate(formBean.getStrCurrentDate());			
			formBean.setStrIsConsolidated(request.getParameter("strIsConsolidated"));
			
			
			System.out.println("strIsConsolidated----"+ formBean.getStrIsConsolidated());	

		
			/* Req_Type - > 1 - Not Issued
			           		2 - Issued 
			           		3 - Partial Issue */
		  
			System.out.println("vo.getStrRptType()       ----"+ vo.getStrRptType()+" - > 1 - Not Issued , 2 - Issued , 3 - Partial Issue ");
		
			
		if(formBean.getStrIsConsolidated().equals("1"))
		{
//			Null & "" handling 
			if(vo.getStrStoreId()==null || vo.getStrStoreId().equals(""))
			{
				vo.setStrStoreId("0");
			}
			
			
//			START ----1 - Not Issued 
			if(vo.getStrRptType().equals("1"))
			{	
					if(vo.getStrReqTypeId().equals("17"))
					{
						bo.getNotIssuedDtls(vo); //pkg_mms_view2.rptm_issuednotissued_status -- Modeval 1
						
						strResult = PendingIndentStatusRecordRptHLP.getNotIssuedDtls(vo, formBean);	
						
					 	response.getWriter().print(strResult); 	
						
					}
			}//			CLOSING IF BLOCK----1 - Not Issued 


			
//			START IF BLOCK------2 - Issued
				    else if(vo.getStrRptType().equals("2"))
				    {
						if(vo.getStrReqTypeId().equals("17"))
						{
							bo.getIssuedDtls(vo);// pkg_mms_view2.rptm_issuednotissued_status -- Modeval 2
							
							strResult = PendingIndentStatusRecordRptHLP.getIssuedDtls(vo, formBean);	
							
						 	response.getWriter().print(strResult); 	
								 
						}
				    }//			CLOSING IF BLOCK-- 2 - Issued

			
//			START IF BLOCK------3 - Partial Issued
				    else if(vo.getStrRptType().equals("3"))
				    {
						if(vo.getStrReqTypeId().equals("17"))
						{
							bo.getPartialIssueDtls(vo); // pkg_mms_rpt.rptm_partial_issue_dtl -- Modeval 1
							
							strResult = PendingIndentStatusRecordRptHLP.getPartialIssueDtls(vo.getStrPartialIssueWs(),vo.getStrHospitalCode(),vo);	
							
						 	response.getWriter().print(strResult); 	
								 
						}
				    }//			CLOSING IF BLOCK-- 3 - Partial Issued

		}
//		CLOSING if(strIsConsolidated.equals("1"))
		
		else
		{
//		START UNCONSOLIDATED unchecked !=1
//			Null & "" handling 
			if(vo.getStrStoreId()==null || vo.getStrStoreId().equals(""))
			{
				vo.setStrStoreId("0");
			}
			
			if(vo.getStrRptType().equals("1"))
			{
				if(vo.getStrReqTypeId().equals("17"))
				{
					bo.getNotIssuedDtls(vo);
					
					strResult = PendingIndentStatusRecordRptHLP.getNotIssuedDtls(vo, formBean);	
					
				 	response.getWriter().print(strResult); 	
					
				}
			} else if(vo.getStrRptType().equals("2"))
			{
				if(vo.getStrReqTypeId().equals("17"))
				{
					bo.getIssuedDtls(vo);
					
					strResult = PendingIndentStatusRecordRptHLP.getIssuedDtls(vo, formBean);	
					
				 	response.getWriter().print(strResult); 	
				} 
		    } else if(vo.getStrRptType().equals("3"))
			{
				if(vo.getStrReqTypeId().equals("17"))
				{
					bo.getPartialIssueDtls(vo);
					
					strResult = PendingIndentStatusRecordRptHLP.getPartialIssueDtls(vo.getStrPartialIssueWs(),vo.getStrHospitalCode(),vo);	
					
				 	response.getWriter().print(strResult); 	
				} 
		    }
		}//		END UNCONSOLIDATED
	}
		catch (Exception e) {

			e.printStackTrace();

		}
	}
}
