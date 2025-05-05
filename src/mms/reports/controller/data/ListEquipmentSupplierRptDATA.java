package mms.reports.controller.data;

import hisglobal.ReportUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.fb.ListEquipmentSupplierRptFB;

public class ListEquipmentSupplierRptDATA {
	
	public static void showReport(ListEquipmentSupplierRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospCode();
			String strReportId = formBean.getStrReportId();
			String strUserRemarks = formBean.getStrUserRemarks();
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "List of Equipment Supplier Wise";
	
						
				String reportPath = "/mms/reports/listequipmentsupplier_mmsrpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
								
				ts.displayReport(request, response, reportPath, reportFormat,
						params,"0");
				
				
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}


}
