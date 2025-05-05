package mms.reports.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.StoreWiseIssueRptBO;
import mms.reports.controller.fb.StoreWiseIssueRptFB;
import mms.reports.controller.hlp.StoreWiseIssueRptHLP;
import mms.reports.vo.StoreWiseIssueRptVO;

public class StoreWiseIssueRptDATA {

	public static void getStoreList(StoreWiseIssueRptFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		StoreWiseIssueRptBO bo = null;
		StoreWiseIssueRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new StoreWiseIssueRptBO();
			voObj = new StoreWiseIssueRptVO();
			// String strUserLevel =
			// request.getSession().getAttribute("USER_LEVEL").toString();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrItemCatId("10");

			/*
			 * if(strUserLevel.equals("6")){ voObj.setStrMode("6"); } else
			 */
			voObj.setStrMode("8"); // role based stores
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PendingIndentStatusRecordRptDATA");

			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "-1", "-1^SelectValue", false);

			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PendingIndentStatusRecordRptDATA.getStoreList --> " + e.getMessage();
			HisException eObj = new HisException("mms", "PendingIndentStatusRecordRptDATA->getStoreList()", strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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

	public static void getItemCatList(StoreWiseIssueRptFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		StoreWiseIssueRptBO bo = null;
		StoreWiseIssueRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StoreWiseIssueRptBO();
			voObj = new StoreWiseIssueRptVO();

			String strStoreId = request.getParameter("storeId");

			if (strStoreId == null)
				strStoreId = "0";

			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrMode("2");
			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PendingIndentStatusRecordRptDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrItemCatWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^SelectValue", true);

			} else {

				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PendingIndentStatusRecordRptDATA.getItemCatList --> " + e.getMessage();
			HisException eObj = new HisException("mms", "PendingIndentStatusRecordRptDATA->getItemCatList()",
					strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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

	public static void getReqTypeList(StoreWiseIssueRptFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		StoreWiseIssueRptBO bo = null;
		StoreWiseIssueRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StoreWiseIssueRptBO();
			voObj = new StoreWiseIssueRptVO();

			String strStoreId = request.getParameter("storeId");

			if (strStoreId == null)
				strStoreId = "0";

			// added by vipul on 10.05.2021
			if (strStoreId.equals("0")) {
				voObj.setStrMode("3");
			} else {
				voObj.setStrMode("2");
			}
			// ended by vipul on 10.05.2021
			voObj.setStrStoreId(request.getParameter("storeId"));
			voObj.setStrItemCatId(request.getParameter("catId"));
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getReqTypeList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PendingIndentStatusRecordRptDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrReqTypeWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrReqTypeWs(), "0", "0^SelectValue", true);

			} else {

				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PendingIndentStatusRecordRptDATA.getItemCatList --> " + e.getMessage();
			HisException eObj = new HisException("mms", "PendingIndentStatusRecordRptDATA->getItemCatList()",
					strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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

	public static void getStoreWiseIssueDtls(StoreWiseIssueRptFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		StoreWiseIssueRptBO bo = null;
		StoreWiseIssueRptVO voObj = null;
		String strmsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new StoreWiseIssueRptBO();
			voObj = new StoreWiseIssueRptVO();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrStoreId(formBean.getStrStoreId());
			
			voObj.setStrStoreName(formBean.getStrStoreName());
			
			voObj.setStrItemCatId(formBean.getStrItemCatNo());
			
			voObj.setStrItemCatName(formBean.getStrItemCatName());
			
			voObj.setStrFromDate(formBean.getStrFromDate());
			voObj.setStrToDate(formBean.getStrToDate());
			voObj.setStrReqTypeId(formBean.getStrReqTypeId());
			voObj.setStrRptType(formBean.getStrRptType());

			System.out.println("formBean.getStrHospitalCode()" + formBean.getStrHospitalCode());
			System.out.println("formBean.getStrStoreId()" + formBean.getStrStoreId());
			System.out.println("formBean.getStrStoreName()" + formBean.getStrStoreName());
			System.out.println("formBean.getStrItemCatNo()" + formBean.getStrItemCatNo());
			System.out.println("formBean.getStrItemCatName()" + formBean.getStrItemCatName());
			System.out.println("formBean.getStrFromDate()" + formBean.getStrFromDate());
			System.out.println("formBean.getStrToDate()" + formBean.getStrToDate());
			System.out.println("formBean.getStrReqTypeId()" + formBean.getStrReqTypeId());
			System.out.println("formBean.getStrRptType()" + formBean.getStrRptType());

			bo.getPartialIssueDtls(voObj);

			String strPartialIssueDtls = StoreWiseIssueRptHLP.getStoreWiseIssueDtlsRpt(voObj.getStrPartialIssueWs(),
					voObj.getStrHospitalCode(),voObj);

			formBean.setStrPartialIssueDtls(strPartialIssueDtls);
			formBean.setStrStoreValues(strStoreVal);
			

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PendingIndentStatusRecordRptDATA.getPartialIssueDtls --> " + e.getMessage();
			HisException eObj = new HisException("mms", "PendingIndentStatusRecordRptDATA->getPartialIssueDtls()",
					strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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
