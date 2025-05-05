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

import mms.reports.bo.PendingListAgendaRptBO;
import mms.reports.controller.fb.PendingListAgendaRptFB;
import mms.reports.vo.PendingListAgendaRptVO;

/**
 * Developer:Anshul Jindal
 * Creation Date: 17-07-2009 Modifying Date:-
 * Used For:-MMS Reports
 * Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PendingListAgendaRptDATA {
	
	public static void getInitialDtl(PendingListAgendaRptFB formBean,HttpServletRequest request) {

		PendingListAgendaRptBO bo = null;
		PendingListAgendaRptVO vo = null;

		HisUtil util = null;
		String strStoreVal = "";
		String strmsgText = null;
		
		String strHospitalCode = "";
		String strSeatId = "";
		
		try {
			bo = new PendingListAgendaRptBO();
			vo = new PendingListAgendaRptVO();
			
			strHospitalCode =  request.getSession().getAttribute("HOSPITAL_CODE").toString(); 
			strSeatId  = request.getSession().getAttribute("SEATID").toString();
				
	       
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			
			bo.getStoreNameValues(vo);
	
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "PendingListAgendaRptDATA");
			
			strStoreVal = util.getOptionValue(vo.getStoreComboWS(), "0",
					"0^Select Value", false);
						
			formBean.setStrStoreNameValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			
			
			

		} catch (Exception e) {
			strmsgText = "mms.Reports.PendingListAgendaRptDATA.getInitialDtl --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PendingListAgendaRptDATA->getInitialDtl()", strmsgText);
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
	 * PendingListAgendaRptBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getCategoryNameCmb(PendingListAgendaRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PendingListAgendaRptBO bo = null;
		PendingListAgendaRptVO vo = null;
		HisUtil hisutil = null;

		String strmsgText = "";
		String hosCode = "";
		String strCategoryValues = "";
		String strStoreComboId = "";
	

		try {
			bo = new PendingListAgendaRptBO();
			vo = new PendingListAgendaRptVO();

			strStoreComboId = request.getParameter("storeComboId"); 

			hisutil = new HisUtil("mms", "PendingListAgendaRptDATA");

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(strStoreComboId);

			if (strStoreComboId.equals("0")) {
				strCategoryValues = "<option value='0'>Select Value</option>";
			} else {
				bo.getCategoryValues(vo);

				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				if (vo.getCategoryComboWS() != null
						&& vo.getCategoryComboWS().size() > 0) {
					strCategoryValues = hisutil.getOptionValue(vo
							.getCategoryComboWS(), "0", "0^Select Value",
							true);
				} else {
					strCategoryValues = "<option value='0'>Select Value</option>";
				}
			}
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strCategoryValues);

			} catch (Exception e) {
				// TODO Auto-generated catch block

			}

		} catch (Exception e) {
			strmsgText = "reports.PendingListAgendaRptDATA.getCategoryNameCmb(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PendingListAgendaRptDATA->getCategoryNameCmb()",
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
	
	public static void showReport(PendingListAgendaRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strStoreId = formBean.getStrStoreId();
			String strCatCode = formBean.getStrCategoryNo();
			String strUserRemarks = formBean.getStrUserRemarks();
			
			reportFormat = formBean.getStrReportFormat();
			
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "Pending List of Agenda";
			
			String reportPath = "/mms/reports/pending_list_agenda_rpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("hospCode", strHospitalCode);
				params.put("storeId", strStoreId);
				params.put("catCode", strCatCode);
				
			
				ts.displayReport(request, response, reportPath, reportFormat,
						params,strStoreId);
			
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
