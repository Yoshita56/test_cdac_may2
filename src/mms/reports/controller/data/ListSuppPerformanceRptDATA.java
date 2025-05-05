package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.ListSuppPerformanceRptBO;
import mms.reports.controller.fb.ListSuppPerformanceRptFB;
import mms.reports.vo.ListSuppPerformanceRptVO;

public class ListSuppPerformanceRptDATA {
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void initialAdd(ListSuppPerformanceRptFB formBean,HttpServletRequest request) {
		ListSuppPerformanceRptVO vo=null;
		ListSuppPerformanceRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatCmb = "";
		
			
		try {
			vo = new ListSuppPerformanceRptVO();
			bo = new ListSuppPerformanceRptBO();
			
			hisutil = new HisUtil("mms", "ListSuppPerformanceRptDATA");
			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
				
			bo.initialAdd(vo);			
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getItemCategoryWS() != null
					&& vo.getItemCategoryWS().size() > 0) {			
			     itemCatCmb = hisutil.getOptionValue(vo.getItemCategoryWS(),
					   "", "0^Select Value", true);
			}
			else {
				itemCatCmb = "<option value='0'>Select Value</option>";
			}
			
			formBean.setStrItemCategoryCombo(itemCatCmb);
			formBean.setStrCurrentDate(hisutil.getASDate("dd-MMM-yyyy"));
												
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ListSuppPerformanceRptDATA->initialAdd()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	public static void showReport(ListSuppPerformanceRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCategoryNo();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strStatus = formBean.getStrStatus();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
						
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Supplier Performance List";
			
			String reportPath = "/mms/reports/listSuppPerformance_mms_rpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				if(strStatus.equals("0")){
					params.put("IsStatusAvl", false);
					params.put("IsStatusUnAvl", true);
					params.put("status", "null");
				}else{
					params.put("IsStatusAvl", true);
					params.put("IsStatusUnAvl", false);
					
					if(strStatus.equals("1")){
						params.put("status", "Partial Supply");
					}else if(strStatus.equals("2")){
						params.put("status", "Delayed Supply");
					}else{
						params.put("status", "Breakage/Rejected Supply");
					}
					
				}
				
				//ts.displayReport(request, response, reportPath, reportFormat,params);
			
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
