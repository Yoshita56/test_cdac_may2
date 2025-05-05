package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.SummaryListIndentPurchaseRptBO;
import mms.reports.controller.fb.SummaryListIndentPurchaseRptFB;
import mms.reports.vo.SummaryListIndentPurchaseRptVO;

public class SummaryListIndentPurchaseRptDATA {

	public static void getItemCatList(SummaryListIndentPurchaseRptFB formBean,
			HttpServletRequest request) {

		SummaryListIndentPurchaseRptBO bo = null;
		SummaryListIndentPurchaseRptVO voObj = null;
		String strmsgText = null;
		String strItemCatVal = "";
		HisUtil util = null;
		try {

			bo = new SummaryListIndentPurchaseRptBO();
			voObj = new SummaryListIndentPurchaseRptVO();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
            
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");

			strItemCatVal = util.getOptionValue(voObj.getStrItemCatWs(), "0",
					"0^All", false);

			formBean.setStrItemCatValues(strItemCatVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.SummaryListIndentPurchaseRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SummaryListIndentPurchaseRptDATA->getItemCatList()",
					strmsgText);
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

	public static void getPurchaseTypeList(
			SummaryListIndentPurchaseRptFB formBean, HttpServletRequest request) {

		SummaryListIndentPurchaseRptBO bo = null;
		SummaryListIndentPurchaseRptVO voObj = null;
		String strmsgText = null;
		String strPurchaseTypeVal = "";
		HisUtil util = null;
		try {

			bo = new SummaryListIndentPurchaseRptBO();
			voObj = new SummaryListIndentPurchaseRptVO();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getPurchaseTypeList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");

			strPurchaseTypeVal = util.getOptionValue(voObj
					.getStrPurchaseTypeWs(), "0", "0^SelectValue", false);

			formBean.setStrPurchaseTypeValues(strPurchaseTypeVal);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.SummaryListIndentPurchaseRptDATA.getPurchaseTypeList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SummaryListIndentPurchaseRptDATA->getPurchaseTypeList()",
					strmsgText);
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

	public static void showReport(SummaryListIndentPurchaseRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();

		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			String reportPath = "/mms/reports/summlistindentpurchase_mmsrpt22.rptdesign";
			String strReportName = "Summary List of Indent Purchase";
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strPurchaseTypeId = formBean.getStrPurchaseTypeId();
			String strFromDate = formBean.getStrFromDate();
			String strToDate = formBean.getStrToDate();
			String strItemCategoryName = formBean.getStrItemCategoryName();
			reportFormat = formBean.getStrReportFormat();

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");

			boolean footerVisible = true;

			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;

			}

			params.put("report_id", strReportId);
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
			params.put("report_user_Remarks", strUserRemarks);
			params.put("purType", strPurchaseTypeId);
			params.put("hospCode", strHospitalCode);
			params.put("fromDate", sdf.format(sdf.parse(strFromDate)));
			params.put("toDate", sdf.format(sdf.parse(strToDate)));

			if (strCatCode.equals("0")) {
				params.put("catCode", "null");
			} else {
				params.put("catCode", strCatCode);
			}

			if (strPurchaseTypeId.equals("21")) { // ANNUAL
				params.put("itemCategoryName", strItemCategoryName);
				params.put("poType", "null");
			}

			if (strPurchaseTypeId.equals("22")) { // ANNUAL
				params.put("itemCategoryName", strItemCategoryName);
				params.put("poType", "null");

			} else if (strPurchaseTypeId.equals("24")) { // IMPORTED
				params.put("itemCategoryName", strItemCategoryName);
				params.put("poType", "null");

			} else if (strPurchaseTypeId.equals("23")) { // CONTIGENCY
				params.put("itemCategoryName", strItemCategoryName);
				params.put("poType", "null");

			} else if (strPurchaseTypeId.equals("25")
					|| strPurchaseTypeId.equals("26")
					|| strPurchaseTypeId.equals("27")) { // IMPORTED

				params.put("itemCategoryName", strItemCategoryName);
				params.put("poType", strPurchaseTypeId);

			}

			 ts.displayReport(request, response, reportPath, reportFormat,
			 params,strHospitalCode);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}
	
	
	
	public static void getHospitalname(
			SummaryListIndentPurchaseRptFB formBean, HttpServletRequest request) {

		SummaryListIndentPurchaseRptBO bo = null;
		SummaryListIndentPurchaseRptVO voObj = null;
		String strmsgText = null;
		String strHospitalnameVal = "";
		HisUtil util = null;
		try {

			bo = new SummaryListIndentPurchaseRptBO();
			voObj = new SummaryListIndentPurchaseRptVO();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			bo.getHospitalName(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");

			strHospitalnameVal = util.getOptionValue(voObj
					.getStrHospitalnameWs(), "0", "0^SelectValue", false);

			formBean.setStrHospNameValues(strHospitalnameVal);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.SummaryListIndentPurchaseRptDATA.getPurchaseTypeList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SummaryListIndentPurchaseRptDATA->getPurchaseTypeList()",
					strmsgText);
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
}
