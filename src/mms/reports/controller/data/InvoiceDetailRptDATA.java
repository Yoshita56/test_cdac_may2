package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.InvoiceDetailRptBO;
import mms.reports.controller.fb.InvoiceDetailRptFB;
import mms.reports.vo.InvoiceDetailRptVO;

public class InvoiceDetailRptDATA {
	
	public static void getItemCatList(InvoiceDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		InvoiceDetailRptBO bo = null;
		InvoiceDetailRptVO voObj = null;
		String strmsgText = null;
		String strItemCatVal = "";
		HisUtil util = null;
		try {

			bo = new InvoiceDetailRptBO();
			voObj = new InvoiceDetailRptVO();
			
						
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "InvoiceDetailRptDATA");
			
			strItemCatVal = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^SelectValue", false);
						
			formBean.setStrItemCatValues(strItemCatVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.InvoiceDetailRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InvoiceDetailRptDATA->getItemCatList()", strmsgText);
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

	public static void showReport(InvoiceDetailRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strUserRemarks = formBean.getStrUserRemarks();
			reportFormat = formBean.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Invoice Details";
	
			
				
				String reportPath = "/mms/reports/invoicedetail_mmsrpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			 	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}
}
