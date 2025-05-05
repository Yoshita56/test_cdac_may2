package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.ListOfInstitutionsRptBO;
import mms.reports.controller.fb.ListOfInstitutionsRptFB;
import mms.reports.vo.ListOfInstitutionsRptVO;

public class ListOfInstitutionsRptDATA {
	
	/*public static void getInitializedValues(ListOfInstitutionsRptFB ListOfInstitutionsRptFB_p,	HttpServletRequest request, HttpServletResponse response) {

		ListOfInstitutionsRptBO bo = null;
		ListOfInstitutionsRptVO voObj = null;
		String strMsgText = null;
		String strCurrentDate;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strCurrentFinancialYear;
		String strNextFinancialYear;
		String strHospitalCode,strStoreVal,strDwhTypeVal;
		
		try {

			bo = new ListOfInstitutionsRptBO();
			voObj = new ListOfInstitutionsRptVO();
			
			
			strHospitalCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			ListOfInstitutionsRptFB_p.setStrHospitalCode(strHospitalCode);
			ListOfInstitutionsRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
			hisutil = new HisUtil("DWH","ListOfInstitutionsRptDATA");
			
					
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
			
						
			hisutil = new HisUtil("MMS Transactions", "ListOfInstitutionsRptDATA");
			// For setting the financial year 
			ListOfInstitutionsRptFB_p.setStrStartFinancialYear(""+CURRENT_YEAR);
			ListOfInstitutionsRptFB_p.setStrEndFinancialYear(""+(CURRENT_YEAR+1));
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			ListOfInstitutionsRptFB_p.setStrCurrentDate(strCurrentDate);			
		

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = "mms.transactions.ListOfInstitutionsRptDATA.getInitializedValues --> "+ e.getMessage();
			HisException eObj = new HisException("dwh",	"ListOfInstitutionsRptDATA->getInitializedValues()", strMsgText);
			ListOfInstitutionsRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	}*/
	

	
	
	
	
	public static void showReport(ListOfInstitutionsRptFB ListOfInstitutionsRptFB_p,HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			ListOfInstitutionsRptFB_p.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ListOfInstitutionsRptFB_p.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
			String strHospitalCode = ListOfInstitutionsRptFB_p.getStrHospitalCode();
			String strReportId = ListOfInstitutionsRptFB_p.getStrReportId();
			
			String strUserRemarks = ListOfInstitutionsRptFB_p.getStrUserRemarks();
			
			reportFormat = ListOfInstitutionsRptFB_p.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if(ListOfInstitutionsRptFB_p.getStrIsFooter()==null)
				ListOfInstitutionsRptFB_p.setStrIsFooter("0");
			
			if (ListOfInstitutionsRptFB_p.getStrIsFooter().equals("1"))
			{
				footerVisible = false;
				
			}
			
			String strReportName = "Statement Showing Current List Of Institutions";
	
							
				String reportPath = "/mms/reports/dwh_listOfInstitutions_rpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("mode", "1");
				params.put("storeId", "0");

				params.put("dwhTypeId", "0");

				ts.displayReport(request, response, reportPath, reportFormat,params,"0");
				
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
