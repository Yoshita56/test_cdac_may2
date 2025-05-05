package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.IssueToPatientBO_NEW;
import mms.reports.controller.fb.IssueToPatientFB_NEW;
import mms.reports.vo.IssueToPatientVO_NEW;

public class IssueToPatientDATA_NEW {
	
	public static void getStoreList(IssueToPatientFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueToPatientBO_NEW bo = null;
		IssueToPatientVO_NEW voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new IssueToPatientBO_NEW();
			voObj = new IssueToPatientVO_NEW();
		//	String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrItemCatId("10");

			/*if(strUserLevel.equals("6")){
				voObj.setStrMode("6");
			}
			else*/
				voObj.setStrMode("5");
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PendingIndentStatusRecordRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^SelectValue", false);
						
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
	
	public static void getItemCatList(IssueToPatientFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueToPatientBO_NEW bo = null;
		IssueToPatientVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new IssueToPatientBO_NEW();
			voObj = new IssueToPatientVO_NEW();
			
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
	
	public static void getReqTypeList(IssueToPatientFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		IssueToPatientBO_NEW bo = null;
		IssueToPatientVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new IssueToPatientBO_NEW();
			voObj = new IssueToPatientVO_NEW();
			
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
	
	public static void showReport(IssueToPatientFB_NEW formBean,
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
	}


}
