package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.ConsolidatedDistrictWiseBudgetDetailRptBO;
import mms.reports.controller.fb.ConsolidatedDistrictWiseBudgetDetailRptFB;
import mms.reports.vo.ConsolidatedDistrictWiseBudgetDetailRptVO;

public class ConsolidatedDistrictWiseBudgetDetailRptDATA {
	
	public static void getInitializedValues(ConsolidatedDistrictWiseBudgetDetailRptFB consolidatedDistrictWiseBudgetDetailRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		ConsolidatedDistrictWiseBudgetDetailRptBO bo = null;
		ConsolidatedDistrictWiseBudgetDetailRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strCurrentFinancialYear;
		String strNextFinancialYear; 
		try {

			bo = new ConsolidatedDistrictWiseBudgetDetailRptBO();
			voObj = new ConsolidatedDistrictWiseBudgetDetailRptVO();
			
			consolidatedDistrictWiseBudgetDetailRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			consolidatedDistrictWiseBudgetDetailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","ConsolidatedDistrictWiseBudgetDetailRptDATA");
			
					
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 ){
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
				
			
			strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 
			
//			strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2);
			
			// For setting the financial year 
			consolidatedDistrictWiseBudgetDetailRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			consolidatedDistrictWiseBudgetDetailRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			consolidatedDistrictWiseBudgetDetailRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.ConsolidatedDistrictWiseBudgetDetailRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"ConsolidatedDistrictWiseBudgetDetailRptDATA->getInitializedValues()", strMsgText);
			consolidatedDistrictWiseBudgetDetailRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} 
		finally 
		{
			if (bo != null)
				bo = null;
			if (voObj != null)
				voObj = null;
			if (hisutil != null)
				hisutil = null;
		}
	}
	

	
	public static void showReport(ConsolidatedDistrictWiseBudgetDetailRptFB consolidatedDistrictWiseBudgetDetailRptFB_p,HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			consolidatedDistrictWiseBudgetDetailRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			consolidatedDistrictWiseBudgetDetailRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = consolidatedDistrictWiseBudgetDetailRptFB_p.getStrHospitalCode();
			String strReportId = consolidatedDistrictWiseBudgetDetailRptFB_p.getStrReportId();
		
			if(consolidatedDistrictWiseBudgetDetailRptFB_p.getStrWhetherToShowDataForNoBudgetAllocatedCheckBox()==null)
			{
				consolidatedDistrictWiseBudgetDetailRptFB_p.setStrWhetherToShowDataForNoBudgetAllocatedCheckBox("0");
			}
			
			
			
			
			String strStartYear = consolidatedDistrictWiseBudgetDetailRptFB_p.getStrStartFinancialYear();
			String strEndYear = consolidatedDistrictWiseBudgetDetailRptFB_p.getStrEndFinancialYearTemp();
			
			
//			String strFromDate = consolidatedDistrictWiseBudgetDetailRptFB_p.getStrFromDate();
//			String strToDate = consolidatedDistrictWiseBudgetDetailRptFB_p.getStrToDate();
			
			String strUserRemarks = consolidatedDistrictWiseBudgetDetailRptFB_p.getStrUserRemarks();
			
			reportFormat = consolidatedDistrictWiseBudgetDetailRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(consolidatedDistrictWiseBudgetDetailRptFB_p.getStrIsFooter()==null)
				consolidatedDistrictWiseBudgetDetailRptFB_p.setStrIsFooter("0");
			
			if (consolidatedDistrictWiseBudgetDetailRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
			
			String strReportName = "Consolidated District Wise Budget Detail";
	
							
				String reportPath = "/mms/reports/dwh_consolidatedDistrictWiseBudgetDetail_rpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("mode", "1");
				params.put("storeId", "0");
				params.put("slno", "0");
				params.put("fromDate", "0");
				params.put("toDate", "0");
				params.put("fromYear", strStartYear);
				params.put("toYear", strEndYear);
				
				if(consolidatedDistrictWiseBudgetDetailRptFB_p.getStrWhetherToShowDataForNoBudgetAllocatedCheckBox().equals("0"))
				{
					params.put("dataForNoBudgetAllocatedFlag", "0");
				}
				else
				{
					params.put("dataForNoBudgetAllocatedFlag", "1");
				}
				
								
				ts.displayReport(request, response, reportPath, reportFormat,params,"0");
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
