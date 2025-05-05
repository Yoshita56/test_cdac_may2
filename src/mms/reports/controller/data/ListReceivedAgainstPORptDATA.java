package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.ListReceivedAgainstPORptBO;
import mms.reports.controller.fb.ListReceivedAgainstPORptFB;
import mms.reports.vo.ListReceivedAgainstPORptVO;

public class ListReceivedAgainstPORptDATA {
	
	public static void getItemCatList(ListReceivedAgainstPORptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ListReceivedAgainstPORptBO bo = null;
		ListReceivedAgainstPORptVO voObj = null;
		String strmsgText = null;
		String strItemCatVal = "";
		HisUtil util = null;
		try {

			bo = new ListReceivedAgainstPORptBO();
			voObj = new ListReceivedAgainstPORptVO();
			
						
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ListReceivedAgainstPORptDATA");
			
			strItemCatVal = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^SelectValue", false);
						
			formBean.setStrItemCatValues(strItemCatVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ListReceivedAgainstPORptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ListReceivedAgainstPORptDATA->getItemCatList()", strmsgText);
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
	
	public static void showReport(ListReceivedAgainstPORptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strCatCode = formBean.getStrItemCatNo();
			reportFormat = formBean.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "List of Items Received Against PO";

		
				
				String reportPath = "/mms/reports/listreceivedagainstpo_mms_rpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				
				ts.displayReport(request, response, reportPath, reportFormat,
						params,"0");
				
	
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}


}
