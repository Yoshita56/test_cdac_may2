package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.ListSlowFastMovingItemsRptBO;
import mms.reports.controller.fb.ListSlowFastMovingItemsRptFB;
import mms.reports.vo.ListSlowFastMovingItemsRptVO;

public class ListSlowFastMovingItemsRptDATA {
	
	public static void getStoreList(ListSlowFastMovingItemsRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ListSlowFastMovingItemsRptBO bo = null;
		ListSlowFastMovingItemsRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new ListSlowFastMovingItemsRptBO();
			voObj = new ListSlowFastMovingItemsRptVO();
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ListSlowFastMovingItemsRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^SelectValue", false);
						
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ListSlowFastMovingItemsRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ListSlowFastMovingItemsRptDATA->getStoreList()", strmsgText);
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
	
	public static void getItemCatList(ListSlowFastMovingItemsRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ListSlowFastMovingItemsRptBO bo = null;
		ListSlowFastMovingItemsRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ListSlowFastMovingItemsRptBO();
			voObj = new ListSlowFastMovingItemsRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ListSlowFastMovingItemsRptDATA");
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
			strmsgText = "mms.transactions.ListSlowFastMovingItemsRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ListSlowFastMovingItemsRptDATA->getItemCatList()", strmsgText);
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
	
	public static void showReport(ListSlowFastMovingItemsRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			String strStoreId = formBean.getStrStoreId();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strStoreName = formBean.getStrStoreName();
			
			reportFormat = formBean.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "List of Slow/Fast Moving Items";
			
			String reportPath = "/mms/reports/listslowfastmovingitems_mmsrpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("storeId", strStoreId);
				params.put("storeName", strStoreName);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strStoreId);
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
