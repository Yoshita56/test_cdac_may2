package mms.transactions.controller.data;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import mms.transactions.controller.fb.BillPrintTransFB;

public class BillPrintTransDATA 
{
	public static void showReport(BillPrintTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
		ReportUtil ts = new ReportUtil();
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();

		try 
		{

		String strHospitalCode = formBean.getStrHospitalCode();
		String strReportId = formBean.getStrReportId();
		String strChk = request.getParameter("chk");
		String[] strtemp = strChk.replace("@", "#").split("#");
		
		reportFormat = formBean.getStrReportFormat();
		String strPONo = strtemp[1].substring(0, 11);
		//System.out.println("strpono==="+strPONo);
		//System.out.println("strhospcode==="+strHospitalCode);
		String reportPath = ""; 
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		boolean footerVisible = true;
		
		if (formBean.getStrIsFooter().equals("1")) 
		{
			footerVisible = false;				
		}
		
		String strReportName = "BILL REPORT";
		
		
	
			 reportPath = "/mms/reports/billprint.rptdesign";
			params.put("report_id", strReportId);
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
			
			params.put("pono",strPONo);
			params.put("hospCode", strHospitalCode);
			
			params.put("report_Fix_Header","Header");
			
			ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);		      	


		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}