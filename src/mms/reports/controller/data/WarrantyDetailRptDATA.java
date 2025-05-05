package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.WarrantyDetailRptBO;
import mms.reports.controller.fb.WarrantyDetailRptFB;
import mms.reports.vo.WarrantyDetailRptVO;

public class WarrantyDetailRptDATA {
	
	public static void getItemCatList(WarrantyDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		WarrantyDetailRptBO bo = null;
		WarrantyDetailRptVO voObj = null;
		String strmsgText = null;
		String strItemCatVal = "";
		HisUtil util = null;
		try {

			bo = new WarrantyDetailRptBO();
			voObj = new WarrantyDetailRptVO();
			
						
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "WarrantyDetailRptDATA");
			
			strItemCatVal = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^SelectValue", false);
						
			formBean.setStrItemCatValues(strItemCatVal);
		
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.WarrantyDetailRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"WarrantyDetailRptDATA->getItemCatList()", strmsgText);
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
	
	public static void showReport(WarrantyDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strCatCode = formBean.getStrItemCatNo();
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Warranty Details";

		
				
				String reportPath = "/mms/reports/warrantydetails_mmsrpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				
				//ts.displayReport(request, response, reportPath, reportFormat,params);
				
	
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}


}
