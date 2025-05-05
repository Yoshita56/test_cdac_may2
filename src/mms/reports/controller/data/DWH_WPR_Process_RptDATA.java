package mms.reports.controller.data;

import hisglobal.ReportUtil;


import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import mms.reports.controller.fb.DWH_WPR_Process_RptFB;


public class DWH_WPR_Process_RptDATA {
	
	
public static void showReport(DWH_WPR_Process_RptFB DWH_WPR_Process_RptFB_p,HttpServletRequest request, HttpServletResponse response) {
		
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			DWH_WPR_Process_RptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			DWH_WPR_Process_RptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = DWH_WPR_Process_RptFB_p.getStrHospitalCode();
			String strReportId = DWH_WPR_Process_RptFB_p.getStrReportId();
			
			String strUserRemarks = DWH_WPR_Process_RptFB_p.getStrUserRemarks();
			
			reportFormat = DWH_WPR_Process_RptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(DWH_WPR_Process_RptFB_p.getStrIsFooter()==null)
				DWH_WPR_Process_RptFB_p.setStrIsFooter("0");
			
			if (DWH_WPR_Process_RptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
			
			String strReportName = "WPR Process Report ";
	
							
				String reportPath = "/mms/reports/Wpr_Process_rpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Format", reportFormat);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("mode", "1");
				

				ts.displayReport(request, response, reportPath, reportFormat,params,"0");
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}



}
