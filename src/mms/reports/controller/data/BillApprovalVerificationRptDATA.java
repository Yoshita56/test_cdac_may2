package mms.reports.controller.data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.BillApprovalVerificationRptBO;
import mms.reports.controller.fb.BillApprovalVerificationRptFB;
import mms.reports.controller.hlp.BillApprovalVerificationRptHLP;
import mms.reports.vo.BillApprovalVerificationRptVO;

public class BillApprovalVerificationRptDATA {

	public static String DATE_FORMAT_NOWwt = "dd-MMM-yyyy/HH:mm:ss";
	public static String DATE_FORMAT_NOW = "dd-MMM-yyyy";

	public static String now(String frmt) {
		HisUtil util = null;
		String a = "";
		util = new HisUtil("transaction", "SupplierReturnReqTransDATA");
		try {
			a = util.getASDate(frmt);
		} catch (Exception e) {

		}
		/*Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());*/
		return a;
	}

	public static void getInitialAddList(BillApprovalVerificationRptFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		BillApprovalVerificationRptBO bo = null;
		BillApprovalVerificationRptVO vo = null;
		String strmsgText = null;
		String storeValList = "";
		String supplierList = "";
		String itemcategoryList = "";
		String billTypeWs = "";
		// String POSearchDetailsWs = "";

		HisUtil util = null;
		try {

			bo = new BillApprovalVerificationRptBO();
			vo = new BillApprovalVerificationRptVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrItemCatId("10");

			bo.getInitialAddList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "IssueToPatientDATA");

			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

			if (vo.getStrStoreWs() != null && vo.getStrStoreWs().size() > 0) {
				storeValList = util.getOptionValue(vo.getStrStoreWs(), "0", "0^Select Value", false);
			} else {
				storeValList = "<option value='0'>Select Value</option>";
			}

			formBean.setStrStoreValues(storeValList);
			/*System.out.println("vo.setStrStoreId(formBean.getStrStoreId())-->"+formBean.getStrStoreId());
			vo.setStrStoreId(formBean.getStrStoreId());*/

			if (vo.getStrItemCatWs() != null && vo.getStrItemCatWs().size() > 0) {
				itemcategoryList = util.getOptionValue(vo.getStrItemCatWs(), "0", "0^Select Value", true);
			} else {
				itemcategoryList = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemCatValues(itemcategoryList);

			/*System.out.println("vo.setStrItemCategoryId(formBean.getStrItemCatId())-->"+formBean.getStrItemCatId());
			vo.setStrItemCategoryId(formBean.getStrItemCatId());*/

			if (vo.getStrSupplierWs() != null && vo.getStrSupplierWs().size() > 0) {
				supplierList = util.getOptionValue(vo.getStrSupplierWs(), "0", "0^Select Value", true);
			} else {
				supplierList = "<option value='0'>Select Value</option>";
			}
			formBean.setStrSupplierCombo(supplierList);

			/*System.out.println("vo.setStrSupplierId(formBean.getStrSupplierId())-->"+formBean.getStrSupplierId());
			vo.setStrSupplierId(formBean.getStrSupplierId());*/

			if (vo.getStrBillTypeWs() != null && vo.getStrBillTypeWs().size() > 0) {
				billTypeWs = util.getOptionValue(vo.getStrBillTypeWs(), "0", "0^Select Value", true);
			} else {
				billTypeWs = "<option value='0'>Select Value</option>";
			}
			formBean.setStrBillTypeCombo(billTypeWs);

			/*if (vo.getStrPOSearchDetailsWs() != null && vo.getStrPOSearchDetailsWs().size() > 0) {
				POSearchDetailsWs = util.getOptionValue(vo.getStrPOSearchDetailsWs(), "0", "0^Select Value", true);
			}else {
				POSearchDetailsWs = "<option value='0'>Select Value</option>";
			}
			formBean.setStrPoNoCombo(POSearchDetailsWs);
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(POSearchDetailsWs);*/

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientDATA.getStoreList --> " + e.getMessage();
			HisException eObj = new HisException("mms", "IssueToPatientDATA->getStoreList()", strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
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

	public static void getItemCatList(BillApprovalVerificationRptFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		BillApprovalVerificationRptBO bo = null;
		BillApprovalVerificationRptVO voObj = null;
		String strmsgText = null;
		String strUserLevel = "1";// request.getSession().getAttribute("USER_LEVEL").toString();
		HisUtil util = null;
		try {

			bo = new BillApprovalVerificationRptBO();
			voObj = new BillApprovalVerificationRptVO();

			String strStoreId = request.getParameter("storeId");

			if (strStoreId == null)
				strStoreId = "0";

			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "ListConsumablesExpiryDateRptDDATA");
			String temp = "<option value='0'>SelectValue</option>";

//				if(strUserLevel.equals("6"))
//				{
//					temp = "<option value='0'>Select Value</option><option value='10'>Drug</option>";
//				}
//				else
//				{
			if (voObj.getStrItemCatWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^Select Value", true);

			} else {

				temp = "<option value='0'>Select Value</option><option value='10'>Drug</option>";
			}
			// }

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.ListConsumablesExpiryDateRptDDATA.getItemCatList --> " + e.getMessage();
			HisException eObj = new HisException("mms", "ListConsumablesExpiryDateRptDDATA->getItemCatList()",
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

	public static void getPOCombo(BillApprovalVerificationRptFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		BillApprovalVerificationRptBO bo = null;
		BillApprovalVerificationRptVO vo = null;
		String strmsgText = null;
		HisUtil util = null;
		String POSearchDetailsWs = "";

		try {

			bo = new BillApprovalVerificationRptBO();
			vo = new BillApprovalVerificationRptVO();

			System.out.println("DATA-->getPOCombo()-->HOSPITAL_CODE"
					+ request.getSession().getAttribute("HOSPITAL_CODE").toString());
			System.out.println("DATA-->getPOCombo()-->SEATID" + request.getSession().getAttribute("SEATID").toString());

			System.out.println("formBean.getStrHospitalCode()-->" + formBean.getStrHospitalCode());
			System.out.println("vo.setStrSupplierId()-->" + request.getParameter("storeId"));
			System.out.println("strItemCatId()-->" + request.getParameter("strItemCatId"));

			System.out.println("vo.setStrSupplierId()-->" + request.getParameter("strSupplierId"));
			System.out.println("vo.setStrBillTypeId()-->" + request.getParameter("strBillTypeId"));
			System.out.println("vo.setStrFinancialStartYear()-->" + request.getParameter("startDate"));
			System.out.println("vo.setStrFinancialEndYear()-->" + request.getParameter("endDate"));

			String strStoreId = request.getParameter("storeId");
			if (strStoreId == null)
				strStoreId = "0";
			vo.setStrStoreId(strStoreId);

			// vo.setStrHospitalCode(formBean.getStrHospitalCode());
			// vo.setStrMode("1");

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			vo.setStrSupplierId(request.getParameter("strSupplierId"));
			vo.setStrBillTypeId(request.getParameter("strBillTypeId"));

			vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
			vo.setStrFinancialEndYear((String) request.getParameter("endDate"));

			// vo.setStrProcMode("12");
			// <MODE 4, 10 - Bulk PO>--- <MODE 10, 11 - Local PO>-- <MODE 12 , 12 - Supplier
			// Receipt>

			if (formBean.getStrBillTypeId().equals("10")) {
				vo.setStrProcMode("4");
			}

			if (formBean.getStrBillTypeId().equals("11")) {
				vo.setStrProcMode("10");
			}

			if (formBean.getStrBillTypeId().equals("12")) {
				vo.setStrProcMode("12");
			}

			bo.getPOCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			util = new HisUtil("MMS Transactions", "BillApprovalVerificationRptDATA");

			if (vo.getStrPOSearchDetailsWs() != null && vo.getStrPOSearchDetailsWs().size() > 0) {
				POSearchDetailsWs = util.getOptionValue(vo.getStrPOSearchDetailsWs(), "0", "0^Select Value", true);
			} else {
				POSearchDetailsWs = "<option value='0'>Select Value</option>";
			}
			// formBean.setStrPoNoCombo(POSearchDetailsWs);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(POSearchDetailsWs);

			// System.out.println("vo.(formBean.getStrPoNoId())-->"+formBean.getStrPoNoId());
			// vo.setStrPoNoId(formBean.getStrPoNoId());

			/*
			util = new HisUtil("MMS Transactions", "SaleReportCategoryDATA");
			strPatCatVal = util.getOptionValue(vo.getStrItemCatWs(), "0", "0^Select Value", false);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strPatCatVal);*/
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.IssueToPatientDATA.getItemCatList --> " + e.getMessage();
			HisException eObj = new HisException("mms", "IssueToPatientDATA->getItemCatList()", strmsgText);
			formBean.setStrErrMsg(
					"998##Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

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

	// BULK
	public static void getBulkPODetails(BillApprovalVerificationRptFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(" --------------- BillApprovalTransDATA.getPODetails ----------------- ");
		BillApprovalVerificationRptBO bo = null;
		BillApprovalVerificationRptVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		WebRowSet ws = null;
		String[] temp = null;
		NumberFormat formatter = new DecimalFormat("############.##");
		String strInvAmt = "";
		String strPenaltyAmt = "";
		String strAmtAfterDedduct = "";
		String strPoNetAmt = "";
		String strSuppAmtTillPayment = "";

		BigDecimal amtRemainigForPayment = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal paidAmt = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal totalCalAmount = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal amount = new BigDecimal(BigInteger.ZERO, 2);

		BigDecimal totalPenalty = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal penalty = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal poNetAmt = new BigDecimal(BigInteger.ZERO, 2);

		HisUtil util = null;

		try {
			String strResult = "";

			bo = new BillApprovalVerificationRptBO();
			vo = new BillApprovalVerificationRptVO();

			util = new HisUtil("MMS", "Bill Approval Transaction");

			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();
			vo.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);

			/*	vo.setStrStoreId(formBean.getStrStoreId());
				temp = formBean.getStrPONoCmb().replace('^', '#').split("#");
				vo.setStrPONo(formBean.getStrPONoCmb().replace('^', '#').split("#")[0]);
				vo.setStrPOStoreId(formBean.getStrPONoCmb().replace('^', '#').split("#")[1]);
				formBean.setStrPONo(formBean.getStrPONoCmb().replace('^', '#').split("#")[0]);
				vo.setStrBillType(formBean.getStrBillType());
				if (temp.length == 3) {
					formBean.setStrPOPrefix(formBean.getStrPONoCmb().replace('^', '#').split("#")[2]);
				}*/

			System.out.println("DATA-->getPOCombo()-->HOSPITAL_CODE"
					+ request.getSession().getAttribute("HOSPITAL_CODE").toString());
			System.out.println("DATA-->getPOCombo()-->SEATID" + request.getSession().getAttribute("SEATID").toString());

			System.out.println("vo.setStoreId()-->" + request.getParameter("storeId"));
			System.out.println("strItemCatId()-->" + request.getParameter("strItemCatId"));

			System.out.println("vo.setStrSupplierId()-->" + request.getParameter("strSupplierId"));
			System.out.println("vo.setStrBillTypeId()-->" + request.getParameter("strBillTypeId"));
			System.out.println("vo.setStrPoNoId()-->" + request.getParameter("strPoNoId").split("\\^")[0].trim());

			System.out.println("vo.setStrFinancialStartYear()-->" + request.getParameter("startDate"));
			System.out.println("vo.setStrFinancialEndYear()-->" + request.getParameter("endDate"));
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrStoreId(request.getParameter("storeId"));

			vo.setStrSupplierId(request.getParameter("strSupplierId"));
			vo.setStrBillTypeId(request.getParameter("strBillTypeId"));

			vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
			vo.setStrFinancialEndYear((String) request.getParameter("endDate"));

			vo.setStrPoNoId(request.getParameter("strPoNoId").split("\\^")[0].trim());

			if (formBean.getStrBillTypeId().equals("12")) {
				vo.setStrProcMode("13");
			}

			if (formBean.getStrBillTypeId().equals("10")) {
				vo.setStrProcMode("5");
			}

			if (formBean.getStrBillTypeId().equals("11")) {
				vo.setStrProcMode("11");
			}
			bo.getPOPrintDetails(vo); // Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode ]

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				ws = vo.getStrPODetailsWs();
				while (ws.next()) {
					vo.setStrPODate(ws.getString(1));
					vo.setStrPOTypeId(ws.getString(2));
					vo.setStrPOType(ws.getString(3));
					vo.setStrSupplierId(ws.getString(4));
					vo.setStrSupplierName(ws.getString(5));
					vo.setStrPOStoreId(ws.getString(6));
					vo.setStrPOStoreName(ws.getString(7));
					vo.setStrItemCategoryNoH(ws.getString(8));
					vo.setStrItemCategoryNameH(ws.getString(9));
					vo.setStrCurrencyId(ws.getString(10));
					vo.setStrCurrencyName(ws.getString(11));
					vo.setStrCurrencyValue(ws.getString(12));
					vo.setStrOverallPOTax(ws.getString(13));
					vo.setStrAdvanceTaken(ws.getString(14));
					vo.setStrAdvanceAdjusted(ws.getString(15));
					vo.setStrNetPenalty(ws.getString(16));
					vo.setStrCurrentDate(now(DATE_FORMAT_NOW));
					vo.setStrPONetAmount(ws.getString(18));
					// setting fromBean
					formBean.setStrPODate(vo.getStrPODate());
					formBean.setStrPOTypeId(vo.getStrPOTypeId());
					formBean.setStrPOType(vo.getStrPOType());
					formBean.setStrSupplierId(vo.getStrSupplierId());
					formBean.setStrSupplierName(vo.getStrSupplierName());
					formBean.setStrPOStoreId(vo.getStrPOStoreId());
					formBean.setStrPOStoreName(vo.getStrPOStoreName());
					formBean.setStrItemCategoryNoH(ws.getString(8));
					formBean.setStrItemCategoryNameH(ws.getString(9));
					formBean.setStrCurrencyId(ws.getString(10));
					formBean.setStrCurrencyName(ws.getString(11));
					formBean.setStrCurrencyValue(ws.getString(12));
					formBean.setStrOverallPOTax(ws.getString(13));
					formBean.setStrAdvanceTaken(ws.getString(14));
					formBean.setStrAdvanceAdjusted(ws.getString(15));
					formBean.setStrNetPenalty(ws.getString(16));
					formBean.setStrPONetAmount(ws.getString(18));
					formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
				}

				formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));
				System.out.println("StrCurrentDate--showReport_DATA" + formBean.getStrCurrentDate());

				System.out.println("formBean.getStrBillTypeId" + formBean.getStrBillTypeId());
				
				if (formBean.getStrBillTypeId().equals("10")) {
					vo.setStrProcMode("6"); // BULK
					System.out.println("vo.getStrProcMode" + vo.getStrProcMode());
				}
				if (formBean.getStrBillTypeId().equals("11")) {
					vo.setStrProcMode("7"); // LOCAL
					System.out.println("vo.getStrProcMode" + vo.getStrProcMode());
				}
				if (formBean.getStrBillTypeId().equals("12")) {
					vo.setStrProcMode("8"); // SUPPLIER
					System.out.println("vo.getStrProcMode" + vo.getStrProcMode());
				}
				
				bo.getPrintDetails(vo); // PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL

				/***********************************************
				 * Supply Details
				 ***************************************************/
				strResult = BillApprovalVerificationRptHLP.getPrintItemDetails(vo.getWsPrintItemDtls(), vo, formBean,
						hosCode);

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strResult);

			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.BillApprovalTransDATA.getPODetails --> " + e.getMessage();
			HisException eObj = new HisException("mms", "BillApprovalTransDATA->getPODetails()", strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {
			bo = null;
			vo = null;
		}

	}

	// LOCAL
	public static void getLPPODetails(BillApprovalVerificationRptFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(" --------------- BillApprovalTransDATA.getLPPODetails ----------------- ");
		BillApprovalVerificationRptBO bo = null;
		BillApprovalVerificationRptVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		WebRowSet ws = null;
		String[] temp = null;
		NumberFormat formatter = new DecimalFormat("############.##");
		String strInvAmt = "";
		String strPenaltyAmt = "";
		String strAmtAfterDedduct = "";
		String strPoNetAmt = "";
		String strSuppAmtTillPayment = "";

		BigDecimal amtRemainigForPayment = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal paidAmt = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal totalCalAmount = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal amount = new BigDecimal(BigInteger.ZERO, 2);

		BigDecimal totalPenalty = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal penalty = new BigDecimal(BigInteger.ZERO, 2);
		BigDecimal poNetAmt = new BigDecimal(BigInteger.ZERO, 2);
		HisUtil util = null;

		try {
			
			String strResult = "";

			bo = new BillApprovalVerificationRptBO();
			vo = new BillApprovalVerificationRptVO();
			util = new HisUtil("MMS", "Bill Approval Transaction");

			
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();
			
			System.out.println("DATA-->getPOCombo()-->HOSPITAL_CODE"
					+ request.getSession().getAttribute("HOSPITAL_CODE").toString());
			System.out.println("DATA-->getPOCombo()-->SEATID" + request.getSession().getAttribute("SEATID").toString());

			System.out.println("vo.setStoreId()-->" + request.getParameter("storeId"));
			System.out.println("strItemCatId()-->" + request.getParameter("strItemCatId"));

			System.out.println("vo.setStrSupplierId()-->" + request.getParameter("strSupplierId"));
			System.out.println("vo.setStrBillTypeId()-->" + request.getParameter("strBillTypeId"));
			System.out.println("vo.setStrPoNoId()-->" + request.getParameter("strPoNoId").split("\\^")[0].trim());

			System.out.println("vo.setStrFinancialStartYear()-->" + request.getParameter("startDate"));
			System.out.println("vo.setStrFinancialEndYear()-->" + request.getParameter("endDate"));
			
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrStoreId(request.getParameter("storeId"));

			vo.setStrSupplierId(request.getParameter("strSupplierId"));
			vo.setStrBillTypeId(request.getParameter("strBillTypeId"));

			vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
			vo.setStrFinancialEndYear((String) request.getParameter("endDate"));

			vo.setStrPoNoId(request.getParameter("strPoNoId").split("\\^")[0].trim());

			if (formBean.getStrBillTypeId().equals("12")) {
				vo.setStrProcMode("13");
			}

			if (formBean.getStrBillTypeId().equals("10")) {
				vo.setStrProcMode("5");
			}

			if (formBean.getStrBillTypeId().equals("11")) {
				vo.setStrProcMode("11");
			}
			bo.getPOPrintDetails(vo); // Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode ]

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				ws = vo.getStrPODetailsWs();
				while (ws.next()) {
					vo.setStrPODate(ws.getString(1));
					vo.setStrPOTypeId(ws.getString(2));
					vo.setStrPOType(ws.getString(3));
					vo.setStrSupplierId(ws.getString(4));
					vo.setStrSupplierName(ws.getString(5));
					vo.setStrPOStoreId(ws.getString(6));
					vo.setStrPOStoreName(ws.getString(7));
					vo.setStrItemCategoryNoH(ws.getString(8));
					vo.setStrItemCategoryNameH(ws.getString(9));
					vo.setStrCurrencyId(ws.getString(10));
					vo.setStrCurrencyName(ws.getString(11));
					vo.setStrCurrencyValue(ws.getString(12));
					vo.setStrOverallPOTax(ws.getString(13));
					vo.setStrAdvanceTaken(ws.getString(14));
					vo.setStrAdvanceAdjusted(ws.getString(15));
					vo.setStrNetPenalty(ws.getString(16));
					vo.setStrCurrentDate(now(DATE_FORMAT_NOW));
					vo.setStrPONetAmount(ws.getString(18));
					// setting fromBean
					formBean.setStrPODate(vo.getStrPODate());
					formBean.setStrPOTypeId(vo.getStrPOTypeId());
					formBean.setStrPOType(vo.getStrPOType());
					formBean.setStrSupplierId(vo.getStrSupplierId());
					formBean.setStrSupplierName(vo.getStrSupplierName());
					formBean.setStrPOStoreId(vo.getStrPOStoreId());
					formBean.setStrPOStoreName(vo.getStrPOStoreName());
					formBean.setStrItemCategoryNoH(ws.getString(8));
					formBean.setStrItemCategoryNameH(ws.getString(9));
					formBean.setStrCurrencyId(ws.getString(10));
					formBean.setStrCurrencyName(ws.getString(11));
					formBean.setStrCurrencyValue(ws.getString(12));
					formBean.setStrOverallPOTax(ws.getString(13));
					formBean.setStrAdvanceTaken(ws.getString(14));
					formBean.setStrAdvanceAdjusted(ws.getString(15));
					formBean.setStrNetPenalty(ws.getString(16));
					formBean.setStrPONetAmount(ws.getString(18));
					formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
				}
			
				formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));

				formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));
				System.out.println("StrCurrentDate--showReport_DATA" + formBean.getStrCurrentDate());

				System.out.println("formBean.getStrBillTypeId" + formBean.getStrBillTypeId());

				if (formBean.getStrBillTypeId().equals("12")) {
					vo.setStrProcMode("8"); // SUPPLIER
					System.out.println("vo.getStrProcMode" + vo.getStrProcMode());
				}

				if (formBean.getStrBillTypeId().equals("11")) {
					vo.setStrProcMode("7"); // LOCAL
					System.out.println("vo.getStrProcMode" + vo.getStrProcMode());
				}

				if (formBean.getStrBillTypeId().equals("10")) {
					vo.setStrProcMode("6"); // BULK
					System.out.println("vo.getStrProcMode" + vo.getStrProcMode());
				}
				bo.getPrintDetails(vo); // PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL

				/***********************************************
				 * Supply Details
				 ***************************************************/
				strResult = BillApprovalVerificationRptHLP.getPrintItemDetails(vo.getWsPrintItemDtls(), vo, formBean,
						hosCode);

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strResult);
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.BillApprovalTransDATA.getPODetails --> " + e.getMessage();
			HisException eObj = new HisException("mms", "BillApprovalTransDATA->getPODetails()", strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {
			bo = null;
			vo = null;
		}

	}

	// SUPPLIER
	public static void getSupp_Rec_Details(BillApprovalVerificationRptFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(" --------------- BillApprovalTransDATA.getSupp_Rec_Details ----------------- ");
		BillApprovalVerificationRptBO bo = null;
		BillApprovalVerificationRptVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		WebRowSet ws = null;
		String[] temp = null;

		HisUtil util = null;

		try {
			String strResult = "";

			bo = new BillApprovalVerificationRptBO();
			vo = new BillApprovalVerificationRptVO();

			util = new HisUtil("MMS", "Bill Approval Transaction");

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatId = request.getSession().getAttribute("SEATID").toString();
			vo.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);

			vo.setStrStoreId(formBean.getStrStoreId());

			vo.setStrBillTypeId(formBean.getStrBillTypeId());
			vo.setStrSupplierId(formBean.getStrSupplierId());

			System.out.println("DATA-->getPOCombo()-->HOSPITAL_CODE"
					+ request.getSession().getAttribute("HOSPITAL_CODE").toString());
			System.out.println("DATA-->getPOCombo()-->SEATID" + request.getSession().getAttribute("SEATID").toString());

			System.out.println("vo.setStoreId()-->" + request.getParameter("storeId"));
			System.out.println("strItemCatId()-->" + request.getParameter("strItemCatId"));

			System.out.println("vo.setStrSupplierId()-->" + request.getParameter("strSupplierId"));
			System.out.println("vo.setStrBillTypeId()-->" + request.getParameter("strBillTypeId"));
			System.out.println("vo.setStrPoNoId()-->" + request.getParameter("strPoNoId").split("\\^")[0].trim());

			System.out.println("vo.setStrFinancialStartYear()-->" + request.getParameter("startDate"));
			System.out.println("vo.setStrFinancialEndYear()-->" + request.getParameter("endDate"));

			String strStoreId = request.getParameter("storeId");
			if (strStoreId == null)
				strStoreId = "0";
			vo.setStrStoreId(strStoreId);

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrStoreId(request.getParameter("storeId"));

			vo.setStrSupplierId(request.getParameter("strSupplierId"));
			vo.setStrBillTypeId(request.getParameter("strBillTypeId"));

			vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
			vo.setStrFinancialEndYear((String) request.getParameter("endDate"));

			vo.setStrPoNoId(request.getParameter("strPoNoId").split("\\^")[0].trim());
			
			if (formBean.getStrBillTypeId().equals("12")) {
				vo.setStrProcMode("13");
			}

			if (formBean.getStrBillTypeId().equals("10")) {
				vo.setStrProcMode("5");
			}

			if (formBean.getStrBillTypeId().equals("11")) {
				vo.setStrProcMode("11");
			}
			bo.getPOPrintDetails(vo); // Pkg_Mms_View.Proc_Po_Detail_Info --[ Mode ]

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				ws = vo.getStrPODetailsWs();
				while (ws.next()) {
					System.out.println("vo.setStrPODate()-->" + ws.getString(1));
					System.out.println("vo.setStrPOTypeId()-->" + ws.getString(2));
					System.out.println("vo.setStrPOType()-->" + ws.getString(3));
					System.out.println("vo.setStrSupplierId()-->" + ws.getString(4));
					System.out.println("vo.setStrSupplierName()-->" + ws.getString(5));
					System.out.println("vo.setStrPOStoreId()-->" + ws.getString(6));

//			         System.out.println("vo.setStrItemCategoryNoH()-->" + ws.getString(7));
					System.out.println("vo.setStrPOStoreName()-->" + ws.getString(7));

					System.out.println("vo.setStrItemCategoryNoH()-->" + ws.getString(8));
					System.out.println("vo.setStrItemCategoryName()-->" + ws.getString(9));

					System.out.println("vo.setStrCurrencyId()-->" + ws.getString(10));
					System.out.println("vo.setStrCurrencyName()-->" + ws.getString(11));
					System.out.println("vo.setStrCurrencyValue()-->" + ws.getString(12));

					System.out.println("vo.setStrOverallPOTax()-->" + ws.getString(13));
					System.out.println("vo.setStrAdvanceTaken()-->" + ws.getString(14));
					System.out.println("vo.setStrAdvanceAdjusted()-->" + ws.getString(15));
					System.out.println("vo.setStrNetPenalty()-->" + ws.getString(16));
					System.out.println("vo.setStrPONetAmount()-->" + ws.getString(18));

					vo.setStrPODate(ws.getString(1));
					vo.setStrPOTypeId(ws.getString(2));
					vo.setStrPOType(ws.getString(3));
					vo.setStrSupplierId(ws.getString(4));
					vo.setStrSupplierName(ws.getString(5));
					vo.setStrPOStoreId(ws.getString(6));

					vo.setStrPOStoreName(ws.getString(7));

					vo.setStrItemCategoryNoH(ws.getString(8));
					vo.setStrItemCategoryNameH(ws.getString(9));
					vo.setStrCurrencyId(ws.getString(10));
					vo.setStrCurrencyName(ws.getString(11));
					vo.setStrCurrencyValue(ws.getString(12));
					vo.setStrOverallPOTax(ws.getString(13));
					vo.setStrAdvanceTaken(ws.getString(14));
					vo.setStrAdvanceAdjusted(ws.getString(15));
					vo.setStrNetPenalty(ws.getString(16));

					vo.setStrCurrentDate(now(DATE_FORMAT_NOW));
					vo.setStrPONetAmount(ws.getString(18));

					// setting fromBean
					formBean.setStrPODate(vo.getStrPODate());
					formBean.setStrPOTypeId(vo.getStrPOTypeId());
					formBean.setStrPOType(vo.getStrPOType());

					formBean.setStrSupplierId(vo.getStrSupplierId());
					formBean.setStrSupplierName(vo.getStrSupplierName());

					formBean.setStrPOStoreId(vo.getStrPOStoreId());
					formBean.setStrPOStoreName(vo.getStrPOStoreName());

					formBean.setStrItemCategoryNoH(ws.getString(8));
					formBean.setStrItemCategoryNameH(ws.getString(9));

					formBean.setStrCurrencyId(ws.getString(10));
					formBean.setStrCurrencyName(ws.getString(11));
					formBean.setStrCurrencyValue(ws.getString(12));

					formBean.setStrOverallPOTax(ws.getString(13));

					formBean.setStrAdvanceTaken(ws.getString(14));
					formBean.setStrAdvanceAdjusted(ws.getString(15));
					formBean.setStrNetPenalty(ws.getString(16));

					formBean.setStrPONetAmount(ws.getString(18));
					formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));
				}
				formBean.setStrCurrentDate(now(DATE_FORMAT_NOW));

				formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));
				System.out.println("StrCurrentDate--showReport_DATA" + formBean.getStrCurrentDate());

				System.out.println("formBean.getStrBillTypeId" + formBean.getStrBillTypeId());

				if (formBean.getStrBillTypeId().equals("12")) {
					vo.setStrProcMode("8"); // SUPPLIER
					System.out.println("vo.getStrProcMode" + vo.getStrProcMode());
				}

				if (formBean.getStrBillTypeId().equals("11")) {
					vo.setStrProcMode("7"); // LOCAL
					System.out.println("vo.getStrProcMode" + vo.getStrProcMode());
				}

				if (formBean.getStrBillTypeId().equals("10")) {
					vo.setStrProcMode("6"); // BULK
					System.out.println("vo.getStrProcMode" + vo.getStrProcMode());
				}
				bo.getPrintDetails(vo); // PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL

				/***********************************************
				 * Supply Details
				 ***************************************************/
				strResult = BillApprovalVerificationRptHLP.getSuppPrintItemDetails_NEW(vo.getWsPrintItemDtls(), vo,
						formBean, hosCode);

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strResult);
			}
		} catch (Exception e) {
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS", "BillApprovalVerificationRptDATA->showReport()", strmsgText);
			formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID()
					+ "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

}
