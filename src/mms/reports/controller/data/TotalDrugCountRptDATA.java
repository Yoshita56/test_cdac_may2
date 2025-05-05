package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.reports.bo.TotalDrugCountRptBO;
import mms.reports.controller.fb.TotalDrugCountRptFB;
import mms.reports.vo.TotalDrugCountRptVO;

public class TotalDrugCountRptDATA {
	
	public static void getStoreList(TotalDrugCountRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		TotalDrugCountRptBO bo = null;
		TotalDrugCountRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "",strDistrictStoreVal="";
		HisUtil util = null;
		try {

			bo = new TotalDrugCountRptBO();
			voObj = new TotalDrugCountRptVO();
			String strUserLevel = "1";//request.getSession().getAttribute("USER_LEVEL").toString();
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());

			
			
			bo.getStoreList(voObj,strUserLevel);

			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "TotalDrugCountRptDDATA");
			
			if(strUserLevel.equals("6"))
			{
				strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
				//strDistrictStoreVal = util.getOptionValue(voObj.getStrDistrictStoreWs(), "0", "0^All", false);
			}
			else
			{
				strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "-1^Select Value", false);
			//	strDistrictStoreVal = util.getOptionValue(voObj.getStrDistrictStoreWs(), "0", "-1^Select Value", false);
			}
				
			
			           		
			
			
			//formBean.setStrDistrictStoreValues(strDistrictStoreVal);						
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			formBean.setStrUserLevel(strUserLevel);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.TotalDrugCountRptDDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"TotalDrugCountRptDDATA->getStoreList()", strmsgText);
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
	
	public static void getItemCatList(TotalDrugCountRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		TotalDrugCountRptBO bo = null;
		TotalDrugCountRptVO voObj = null;
		String strmsgText = null;
		String strUserLevel = "1";//request.getSession().getAttribute("USER_LEVEL").toString();
		HisUtil util = null;
		try {

			bo = new TotalDrugCountRptBO();
			voObj = new TotalDrugCountRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "TotalDrugCountRptDDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if(strUserLevel.equals("6"))
			{
				temp = "<option value='0'>Select Value</option><option value='10'>Drug</option>";
			}
			else
			{
				if (voObj.getStrItemCatWs().size() != 0) {
					
					temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^Select Value",true);

				}else{
					
					temp = "<option value='0'>Select Value</option>";
				}
			}
			
			

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.TotalDrugCountRptDDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"TotalDrugCountRptDDATA->getItemCatList()", strmsgText);
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
	 // Added by shefali garg 10-feb-2015
	public static void showReport(TotalDrugCountRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		MmsConfigUtil mcu = null;
		String reportFormat = "html";
		HisUtil util = null;
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			util = new HisUtil("MMS Transactions", "TotalDrugCountRptDDATA");
			
			String strStoreId ="";
			String strReportName ="";
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId     = formBean.getStrReportId();
			String strCatCode      = formBean.getStrItemCatNo();
			
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
		    strStoreId    = formBean.getStrStoreId();
			strReportName = "Total Drug Count";
       		String strUserRemarks  = formBean.getStrUserRemarks();
			
			reportFormat = formBean.getStrReportFormat();
				
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
			}
			
			String reportPath = "/mms/reports/totaldrugcount_mms_rpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("storeName", formBean.getStrStoreName());
				params.put("storeId", strStoreId);
				params.put("report_Fix_Header","Header");
				params.put("report_Footer","Computer Generated Report");
				
				//System.out.println("strStoreId"+strStoreId);
				//System.out.println("hospCode"+ strHospitalCode);
				//System.out.println("catCode"+ strCatCode);
				//System.out.println("storeName"+ formBean.getStrStoreName());
				
				
				//System.out.println("reportPath>>>>>"+reportPath);
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
