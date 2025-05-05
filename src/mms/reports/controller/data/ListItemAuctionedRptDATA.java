/**
 * 
 */
package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.ListItemAuctionedRptBO;
import mms.reports.controller.fb.ListItemAuctionedRptFB;
import mms.reports.vo.ListItemAuctionedRptVO;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0 Date : 17/July/2009
 * Module : MMS 
 */
public class ListItemAuctionedRptDATA {
	
	/**
	 * This function is used to set initial parameters required to display on main page 
	 * @param formBean
	 */
	public static void initialAdd(ListItemAuctionedRptFB formBean,HttpServletRequest request) {
		ListItemAuctionedRptVO vo=null;
		ListItemAuctionedRptBO bo= null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatCmb = "";
		
			
		try {
			vo = new ListItemAuctionedRptVO();
			bo = new ListItemAuctionedRptBO();
			
			hisutil = new HisUtil("mms", "ListItemAuctionedRptDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			
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
			
												
		} catch (Exception e) {
		
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "ListItemAuctionedRptDATA->initialAdd()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}
		finally {
			if(vo != null) vo = null;
			if(formBean != null) formBean = null;
			hisutil = null;
		}
	}
	
	public static void showReport(ListItemAuctionedRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();
		
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strCatCode = formBean.getStrItemCategoryNo();
			reportFormat = formBean.getStrReportFormat();
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			String strReportName = "List of Auctioned Items";

		
				
				String reportPath = "/mms/reports/listItemAuctioned_mms_rpt.rptdesign";
				
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				
				params.put("hospCode", strHospitalCode);
				params.put("catCode", strCatCode);
				params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
				params.put("toDate", sdf.format(sdf.parse(strToDate)));
				
				//ts.displayReport(request, response, reportPath, reportFormat,params);
				
	
		      	
		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
