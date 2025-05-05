/**
 * 
 */
package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.SamplesSummaryListRptBO;
import mms.reports.controller.fb.SamplesSummaryListRptFB;
import mms.reports.vo.SamplesSummaryListRptVO;

/**
 * Developer:Anshul Jindal
 * Creation Date: 17-07-2009 Modifying Date:-
 * Used For:-MMS Reports
 * Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class SamplesSummaryListRptDATA {
	
	public static void getInitialDtl(SamplesSummaryListRptFB formBean,HttpServletRequest request) {

		SamplesSummaryListRptBO bo = null;
		SamplesSummaryListRptVO vo = null;

		HisUtil util = null;
		String strCategoryValues = "";
		String strmsgText = null;
		
		String strHospitalCode = "";
		String strSeatId = "";
		
		try {
			bo = new SamplesSummaryListRptBO();
			vo = new SamplesSummaryListRptVO();
			
			strHospitalCode =  request.getSession().getAttribute("HOSPITAL_CODE").toString(); 
			strSeatId  = request.getSession().getAttribute("SEATID").toString();
				
	       
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			
			bo.getCategoryValues(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "SamplesSummaryListRptDATA");
			
			strCategoryValues = util.getOptionValue(vo.getCategoryComboWS(), "0",
					"0^Select Value", false);
						
			formBean.setStrCategoryValues(strCategoryValues);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			
			
			

		} catch (Exception e) {
			strmsgText = "mms.Reports.SamplesSummaryListDATA.getInitialDtl --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SamplesSummaryListRptDATA->getInitialDtl()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null)
				bo = null;
			if (vo != null)
				vo = null;
			if (util != null)
				util = null;
		}
	}
	
	/**
	 * This method is used to populate the value of Category name combo box and
	 * this method calls the getGroupNameValues() method which is define in
	 * SamplesSummaryListRptBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getSupplierAndTenderValues(SamplesSummaryListRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		SamplesSummaryListRptBO bo = null;
		SamplesSummaryListRptVO vo = null;
		HisUtil hisutil = null;

		String strmsgText = "";
		String hosCode = "";
		String strSupplierValues = "";
		String strTenderValues = "";
		String strCategoryNo = "";
	

		try {
			bo = new SamplesSummaryListRptBO();
			vo = new SamplesSummaryListRptVO();

			strCategoryNo = request.getParameter("categoryNo"); 

			hisutil = new HisUtil("mms", "SamplesSummaryListRptDATA");

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrCategoryNo(strCategoryNo);

			if (strCategoryNo.equals("0")) {
				strSupplierValues = "<option value='0'>Select Value</option>";
				strTenderValues = "<option value='0'>Select Value</option>";
			} else {
				bo.getSupplierNameValues(vo);

				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				if (vo.getSupplierComboWS() != null
						&& vo.getSupplierComboWS().size() > 0) {
					strSupplierValues = hisutil.getOptionValue(vo
							.getSupplierComboWS(), "0", "0^Select Value",
							true);
				} else {
					strSupplierValues = "<option value='0'>Select Value</option>";
				}
				
				if (vo.getTenderNoComboWS() != null
						&& vo.getTenderNoComboWS().size() > 0) {
					strTenderValues = hisutil.getOptionValue(vo
							.getTenderNoComboWS(), "0", "0^Select Value",
							true);
				} else {
					strTenderValues = "<option value='0'>Select Value</option>";
				}
			}
			
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strSupplierValues+"@@"+strTenderValues);

			} catch (Exception e) {
				// TODO Auto-generated catch block

			}

		} catch (Exception e) {
			strmsgText = "reports.SamplesSummaryListRptDATA.getCategoryNameCmb(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SamplesSummaryListRptDATA->getCategoryNameCmb()",
					strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block

			}

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	
	public static void showReport(SamplesSummaryListRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrCategoryNo();
			String strSupplierId = formBean.getStrSupplierId();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strTenderNo = formBean.getStrTenderNo();
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Summary List of Samples";

			if(formBean.getStrCase().equals("1")){
				
				String reportPath = "/mms/reports/samples_summary_list_rpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("tenderNo", strTenderNo);
				params.put("supplierId", "null");
				
				//ts.displayReport(request, response, reportPath, reportFormat,params);
				
			}else if(formBean.getStrCase().equals("2")){
				
				String reportPath = "/mms/reports/samples_summary_list_rpt1.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("tenderNo", "null");
				params.put("supplierId", strSupplierId);
				
				//ts.displayReport(request, response, reportPath, reportFormat,params);
			}
		
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
