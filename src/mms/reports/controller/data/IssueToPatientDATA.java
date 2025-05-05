package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.IssueToPatientBO;
import mms.reports.controller.fb.IssueToPatientFB;
import mms.reports.controller.hlp.IssueToPatientHLP;
import mms.reports.vo.IssueToPatientVO;

public class IssueToPatientDATA {

	public static void getStoreList(IssueToPatientFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		IssueToPatientBO bo = null;
		IssueToPatientVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new IssueToPatientBO();
			voObj = new IssueToPatientVO();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrItemCatId("10");

			voObj.setStrMode("5");
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientDATA");

			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^SelectValue", false);

			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientDATA.getStoreList --> " + e.getMessage();
			HisException eObj = new HisException("mms", "IssueToPatientDATA->getStoreList()", strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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

	public static void getItemCatList(IssueToPatientFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		IssueToPatientBO bo = null;
		IssueToPatientVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new IssueToPatientBO();
			voObj = new IssueToPatientVO();

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
			util = new HisUtil("MMS Transactions", "IssueToPatientDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrItemCatWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^SelectValue", true);
			} else {

				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientDATA.getItemCatList --> " + e.getMessage();
			HisException eObj = new HisException("mms", "IssueToPatientDATA->getItemCatList()", strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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

	public static void getReqTypeList(IssueToPatientFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		IssueToPatientBO bo = null;
		IssueToPatientVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new IssueToPatientBO();
			voObj = new IssueToPatientVO();

			String strStoreId = request.getParameter("storeId");

			if (strStoreId == null)
				strStoreId = "0";

			voObj.setStrStoreId(request.getParameter("storeId"));
			voObj.setStrItemCatId(request.getParameter("catId"));
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrMode("1");
			bo.getReqTypeList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrReqTypeWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrReqTypeWs(), "0", "0^SelectValue", true);

			} else {

				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientDATA.getItemCatList --> " + e.getMessage();
			HisException eObj = new HisException("mms", "IssueToPatientDATA->getItemCatList()", strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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

	/*	public static void showReport(IssueToPatientFB formBean,
				HttpServletRequest request, HttpServletResponse response) {
		
			ReportUtil ts = new ReportUtil();
			
			String reportFormat = "html";
			String strReportName;
		
			Map<String, Object> params = new HashMap<String, Object>();
			try {
				
				String strHospitalCode = formBean.getStrHospitalCode();
				String strReportId = formBean.getStrReportId();
				String strStoreId = formBean.getStrStoreId();
				String strCatCode = formBean.getStrItemCatNo();
				String strFromDate = formBean.getStrFromDate();
				String strToDate = formBean.getStrToDate();
				String strUserRemarks = formBean.getStrUserRemarks();
				String strPatTypeId = formBean.getStrPatientType();
				String strGendercode=formBean.getStrPatientGenderCode();
				
				reportFormat = formBean.getStrReportFormat();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				boolean footerVisible = true;
				
				if (formBean.getStrIsFooter().equals("1")) {
					footerVisible = false;
					
				}
						strReportName = "(Issue To Patient Report) ";
						// PKG_MMS_RPT_BIRT.RPTM_ISSUE_TO_PATIENT_DTL
					 	String reportPath = "/mms/reports/IssueToPatient_mmsrpt.rptdesign";
					
						params.put("report_id", strReportId);
						params.put("report_Name", strReportName);
						params.put("report_Footer_Visible", footerVisible);
						params.put("report_user_Remarks", strUserRemarks);
						params.put("hospCode", strHospitalCode);
						params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
						params.put("toDate", sdf.format(sdf.parse(strToDate)));
						params.put("storeId", strStoreId);
						params.put("catCode", strCatCode);
						params.put("strPatTypeId", strPatTypeId);
						params.put("strGendercode", strGendercode);
					    params.put("report_Fix_Header","Header");
					
					     ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
					
				
			       	
			} catch (Exception e) {
		
				e.printStackTrace();
		
			}
		}*/
	public static void showReport(IssueToPatientFB fb,HttpServletRequest request,HttpServletResponse response)
	{
	       String strmsgText = "";
	       IssueToPatientVO vo = null;
	       IssueToPatientBO bo = null;

		   Map<String, Object> params = new HashMap<String, Object>();
		   HisUtil util = null;
	
		 
		   try{
			    String strResult="";
			    String strCurrentDate="";

			    vo=new IssueToPatientVO();
			   	bo=new IssueToPatientBO();
			   	
			   	util = new HisUtil("MMS Transactions", "IssueToPatientDATA");
			   	
			  // 	fb.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));	
			   

				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				
				String strFromDate = fb.getStrFromDate();
				String strToDate = fb.getStrToDate();			
				
				strCurrentDate=util.getASDate("dd-MMM-yyyy");
				
				
				String strByCurrentAndDate = (fb.getStrByCurrentAndDate()==null||fb.getStrByCurrentAndDate().equals(""))?"1":fb.getStrByCurrentAndDate();
			
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	vo.setStrStoreId(request.getParameter("storeId"));	 
				vo.setStrStoreName(request.getParameter("storeName"));
			   	vo.setStrItemCategoryId(request.getParameter("categoryId"));
				vo.setStrItemCategoryName(request.getParameter("categoryName")); 
			   	vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
				vo.setStrFinancialEndYear((String) request.getParameter("endDate"));
				vo.setStrPatientType(request.getParameter("patientType"));
				vo.setStrPatientGenderCode(request.getParameter("patientGenderCode"));
	
				vo.setStrByCurrentAndDate(strByCurrentAndDate);

				
				bo.getReplacementDtl(vo);
				
			/* if (vo.getWsItemCategoryCombo().size() > 0) {
				  if (vo.getWsItemCategoryCombo().next()) {
					  vo.setStrUserName(vo.getWsItemCategoryCombo().getString(11)); 
				  	} 
			  }*/
			    
				vo.getWsItemCategoryCombo().beforeFirst();
	
				strResult=IssueToPatientHLP.getReplacementDetails(fb,vo);
	
				if(vo.getStrItemCategoryId()!= null){	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult); 		 
				}else{
				    HisException eObj = new HisException("MMS", "IssueToPatientDATA->showReport()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	}   
				
		   	}catch(Exception e){
		   		
		   		strmsgText = e.getMessage();
				HisException eObj = new HisException("MMS", "IssueToPatientDATA->showReport()", strmsgText);
				fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				eObj = null;
		   }	   
	}

}
