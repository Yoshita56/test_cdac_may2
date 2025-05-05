package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import mms.reports.bo.Fast_Moving_DrugsRptBO;
import mms.reports.vo.Fast_Moving_DrugsRPTVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;


import mms.reports.controller.fb.Fast_Moving_DrugRptFB;
import mms.transactions.controller.fb.ExportRecordsTransFB;



public class Fast_Moving_DrugRptDATA {
	
	
	
public static void showReport(Fast_Moving_DrugRptFB Fast_Moving_DrugRptFB_p,HttpServletRequest request, HttpServletResponse response) {
		
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			Fast_Moving_DrugRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			Fast_Moving_DrugRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = Fast_Moving_DrugRptFB_p.getStrHospitalCode();
			String strReportId = Fast_Moving_DrugRptFB_p.getStrReportId();
			
			String strUserRemarks = Fast_Moving_DrugRptFB_p.getStrUserRemarks();
			
			reportFormat = Fast_Moving_DrugRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(Fast_Moving_DrugRptFB_p.getStrIsFooter()==null)
				Fast_Moving_DrugRptFB_p.setStrIsFooter("0");
			
			if (Fast_Moving_DrugRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
			
			String strReportName = "Current Stock of Fast Moving Drugs in DDW'S";
	
							
				String reportPath = "/mms/reports/new_fast_moving_drug_report.rptdesign";
				
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
