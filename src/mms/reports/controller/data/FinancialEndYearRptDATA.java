package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.FinancialEndYearRptBO;
import mms.reports.controller.fb.FinancialEndYearRptFB;
import mms.reports.vo.FinancialEndYearRptVO;
import mms.transactions.bo.PODeskGenerateTransBO;
import mms.transactions.controller.fb.PODeskGenerateTransFB;
import mms.transactions.vo.PODeskGenerateTransVO;

public class FinancialEndYearRptDATA {
	
	public static void getStoreList(FinancialEndYearRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		FinancialEndYearRptBO bo = null;
		FinancialEndYearRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new FinancialEndYearRptBO();
			voObj = new FinancialEndYearRptVO();
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrItemCatId("10");
			
			if(strUserLevel.equals("6")){
				voObj.setStrMode("6");
			}
			else
				voObj.setStrMode("5");
			
			bo.getStoreList(voObj);
			
			FinancialEndYearRptDATA.getFinancialYearCombo(formBean, request);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "FinancialEndYearRptDATA");
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^SelectValue", false);
						
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.FinancialEndYearRptDATA.getStoreList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"FinancialEndYearRptDATA->getStoreList()", strmsgText);
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
	
	/**
	 * To Get The Financial Year Combo
	 * 
	 * @param budgetAllocationDetailProcessTransFB_p
	 * @param request_p
	 */
	public static void getFinancialYearCombo(FinancialEndYearRptFB FinancialEndYearRptFB_p,HttpServletRequest request_p)
	{
		FinancialEndYearRptBO	FinancialEndYearRptBO = null; 
		FinancialEndYearRptVO	FinancialEndYearRptVO  = null;
		String strCurrentDate;
		String strMsgText;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		
		String strCurrentFinancialYear="";
		String strNextFinancialYear=""; 
		
		try {
			FinancialEndYearRptBO = new FinancialEndYearRptBO();
			FinancialEndYearRptVO = new FinancialEndYearRptVO();
			
			hisutil = new HisUtil("DWH Transaction","FinancialEndYearRptDATA");
			
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			
			
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			 
			    if(strCurrentMonth>=4 )
				{
					CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
				}
				else
				{
					CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
				}
			 
			 
			    String DATE_FORMAT = "dd-MM-yyyy";
			    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
			    
			    
			    Calendar calendar1 = Calendar.getInstance();
			     
			    Calendar calendar2 = Calendar.getInstance();
			    
			    calendar1.set(Integer.parseInt( strCurrentDate.split("\\-")[2] ), Integer.parseInt( strCurrentDate.split("\\-")[1] )-1 , Integer.parseInt( strCurrentDate.split("\\-")[0]));
			    calendar2.set(Integer.parseInt( strCurrentDate.split("\\-")[2] ), 3 , 355);
			     
			    //System.out.print(sdf.format(calender1.getTime()));
			     
			    if (calendar1.before(calendar2)) 
			    {
					strCurrentFinancialYear = (CURRENT_YEAR-1) + " - " + CURRENT_YEAR; 			
					strNextFinancialYear =     CURRENT_YEAR + " - " + (CURRENT_YEAR + 1);
			       
			    }
			    if (calendar1.after(calendar2)) 
			    {
					strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 			
					strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2); 
			    } 
			    if (calendar1.equals(calendar2)) 
			    {
					strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 			
					strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2);  
			    } 
			// For setting the financial year combo
			FinancialEndYearRptFB_p.setStrCurrentFinancialYear(strCurrentFinancialYear);
			FinancialEndYearRptFB_p.setStrNextFinancialYear(strNextFinancialYear);
				
		} 
		catch (Exception e) 
		{
			strMsgText = "mms.transactions.FinancialEndYearRptDATA.getStoreDtls --> "+ e.getMessage();
			HisException eObj = new HisException("mms","FinancialEndYearRptDATA->getStoreDtls()", strMsgText);
			FinancialEndYearRptFB_p.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} 
		finally 
		{

			if (FinancialEndYearRptBO != null)
				FinancialEndYearRptBO = null;
			if (FinancialEndYearRptVO != null)
				FinancialEndYearRptVO = null;
			if (hisutil != null)
				hisutil = null;
		}
		
	}
	
	public static void getItemCatList(FinancialEndYearRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		FinancialEndYearRptBO bo = null;
		FinancialEndYearRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new FinancialEndYearRptBO();
			voObj = new FinancialEndYearRptVO();
			
			String strStoreId = request.getParameter("storeId");
			
			if (strStoreId == null)
				strStoreId = "0";
			
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
				
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "FinancialEndYearRptDATA");
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
			strmsgText = "mms.transactions.FinancialEndYearRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"FinancialEndYearRptDATA->getItemCatList()", strmsgText);
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
	
	public static void showReport(FinancialEndYearRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
	
		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";
	
		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			String strStoreId = formBean.getStrStoreId();
			
			String strFromYear = formBean.getStrFromFinYear();
			String strToYear = formBean.getStrToFinYear();
			
			String strUserRemarks = formBean.getStrUserRemarks();
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Closing Stock Details";//Financial End Year
			
			params.put("storeName", formBean.getStrStoreName());
			
			if(formBean.getStrBatchNo().equals("0")){
				
				String reportPath = "/mms/reports/financialendyear_mmsrpt1.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("storeId", strStoreId);
				params.put("fromYear", strFromYear);
				params.put("toYear", strToYear);
				
				
				ts.displayReport(request, response, reportPath, reportFormat,params,strStoreId);
				
			}else if(formBean.getStrBatchNo().equals("1")){
				
				String reportPath = "/mms/reports/financialendyear_mmsrpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("storeId", strStoreId);
				params.put("fromYear", strFromYear);
				params.put("toYear", strToYear);
				
				
				
				ts.displayReport(request, response, reportPath, reportFormat,params,strStoreId);
			}
		
			
		      	
		} catch (Exception e) {
	
			e.printStackTrace();
	
		}
	}

}
