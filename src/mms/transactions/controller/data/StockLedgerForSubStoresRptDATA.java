package mms.transactions.controller.data;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.StockLedgerForSubStoresRptBO;
import mms.reports.controller.fb.StockLedgerForSubStoresRptFB;
import mms.reports.controller.hlp.StockLedgerForSubStoresRptHLP;
import mms.reports.vo.StockLedgerForSubStoresRptVO;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 16-Mar-2012
 * Modification Date: 
 *  
*/
public class StockLedgerForSubStoresRptDATA {
			
	/**
	 * Gets the inits the val.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getInitVal(StockLedgerForSubStoresRptFB formBean, HttpServletRequest request, HttpServletResponse response){

		StockLedgerForSubStoresRptBO bo = null;
		StockLedgerForSubStoresRptVO voObj = null;
		String strStoreVal = "";
		HisUtil util = null;
		String strmsgText = null;
		try {

			bo = new StockLedgerForSubStoresRptBO();
			voObj = new StockLedgerForSubStoresRptVO();
			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());

			if (strUserLevel.equals("1") || strUserLevel.equals("2") || strUserLevel.equals("3")) {
				voObj.setStrMode("10");
			} else {
				voObj.setStrMode("5");
			}

			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockLedgerForSubStoresRptDATA");

			/*
			 * if(strUserLevel.equals("1") || strUserLevel.equals("2") || strUserLevel.equals("3")){ strStoreVal =
			 * util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false); } else
			 */
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "", false);

			voObj.setStrItemCatId("10");
			String strGroupId = "0";
			String strItemType = "0";
			voObj.setStrGroupId(strGroupId + "^" + strItemType);
			bo.getItemList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}

			String strItemValues = "<option value='0'>All</option>";
			if (voObj.getStrItemWs().size() != 0 && voObj.getStrItemWs() != null) {

				strItemValues = util.getOptionValue(voObj.getStrItemWs(), "0", "0^All", true);

				voObj.getStrItemWs().beforeFirst();
				formBean.setStrLeftItemList(util.getOptionValue(voObj.getStrItemWs(), "0", "", true));

			} else {

				strItemValues = "<option value='0'>All</option>";
			}

			bo.getGroupList(voObj);

			if (voObj.getStrGroupCmbWS() != null && voObj.getStrGroupCmbWS().next()) {
				voObj.setStrGroupId(voObj.getStrGroupCmbWS().getString(1));
				voObj.getStrGroupCmbWS().beforeFirst();
			}

			String temp1 = "";
			if (voObj.getStrGroupCmbWS() != null && voObj.getStrGroupCmbWS().size() > 0) {
				temp1 = util.getOptionValue(voObj.getStrGroupCmbWS(), "0", "0^All", true);
			} else {
				temp1 = "<option value='0'>All</option>";
			}

			formBean.setStrGroupCombo(temp1);
			formBean.setStrItemTypeValues(util.getOptionValue(voObj.getItemTypeWs(), "0", "0^All", false));

			formBean.setStrItemValues(strItemValues);
			formBean.setStrStoreValues(strStoreVal);

			util.getASDate("dd-MMM-yyyy");

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			Calendar c1 = Calendar.getInstance();
			c1.add(Calendar.DATE, -1); // or Calendar.DAY_OF_MONTH which is a
										// synonym
			formBean.setStrCurrentDate(sdf.format(c1.getTime()));

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockLedgerForSubStoresRptDATA.getInitVal --> "+ e.getMessage();
			HisException eObj = new HisException("mms","StockLedgerForSubStoresRptDATA->getInitVal()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	 * Gets the item cat list.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getItemCatList(StockLedgerForSubStoresRptFB formBean, HttpServletRequest request, HttpServletResponse response){

		StockLedgerForSubStoresRptBO bo = null;
		StockLedgerForSubStoresRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StockLedgerForSubStoresRptBO();
			voObj = new StockLedgerForSubStoresRptVO();

			String strStoreId = request.getParameter("storeId");

			if (strStoreId == null) {
				strStoreId = "0";
			}

			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockLedgerForSubStoresRptDATA");
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
			strmsgText = "mms.transactions.StockLedgerForSubStoresRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockLedgerForSubStoresRptDATA->getItemCatList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null) {
				bo = null;
			}
			if (voObj != null) {
				voObj = null;
			}
			if (util != null) {
				util = null;
			}
		}
	}

	/**
	 * Gets the group list.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getGroupList(StockLedgerForSubStoresRptFB formBean, HttpServletRequest request, HttpServletResponse response) {

		StockLedgerForSubStoresRptBO bo = null;
		StockLedgerForSubStoresRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StockLedgerForSubStoresRptBO();
			voObj = new StockLedgerForSubStoresRptVO();

			String strItemCatId = request.getParameter("itemCatId");

			if (strItemCatId == null) {
				strItemCatId = "0";
			}

			voObj.setStrItemCatId(strItemCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getGroupList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockLedgerForSubStoresRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrGroupWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrGroupWs(), "0", "0^All", true);

			} else {

				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockLedgerForSubStoresRptDATA.getGroupList --> "+ e.getMessage();
			HisException eObj = new HisException("mms","StockLedgerForSubStoresRptDATA->getGroupList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null) {
				bo = null;
			}
			if (voObj != null) {
				voObj = null;
			}
			if (util != null) {
				util = null;
			}
		}
	}

	/**
	 * Gets the item list.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getItemList(StockLedgerForSubStoresRptFB formBean, HttpServletRequest request, HttpServletResponse response) {

		StockLedgerForSubStoresRptBO bo = null;
		StockLedgerForSubStoresRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new StockLedgerForSubStoresRptBO();
			voObj = new StockLedgerForSubStoresRptVO();

			String strStoreId = request.getParameter("storeId");
			String strItemCatId = request.getParameter("itemCatId");
			String strGroupId = request.getParameter("groupId");

			if (strItemCatId == null) {
				strItemCatId = "0";
			}
			if (strStoreId == null) {
				strStoreId = "0";
			}
			if (strGroupId == null) {
				strGroupId = "0";
			}

			voObj.setStrItemCatId(strItemCatId);
			voObj.setStrStoreId(strStoreId);
			voObj.setStrGroupId(strGroupId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getItemList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockLedgerForSubStoresRptDATA");
			String temp = "<option value='0'>All</option>";
			if (voObj.getStrItemWs().size() != 0 && voObj.getStrItemWs() != null) {

				temp = util.getOptionValue(voObj.getStrItemWs(), "0", "0^All", true);

			} else {

				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.StockLedgerForSubStoresRptDATA.getItemList --> "+ e.getMessage();
			HisException eObj = new HisException("mms","StockLedgerForSubStoresRptDATA->getItemList()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (bo != null) {
				bo = null;
			}
			if (voObj != null) {
				voObj = null;
			}
			if (util != null) {
				util = null;
			}
		}
	}

	/**
	 * Gets the stock ledger dtl.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getStockLedgerDtl(StockLedgerForSubStoresRptFB formBean, HttpServletRequest request, HttpServletResponse response) {

		StockLedgerForSubStoresRptBO bo = null;
		StockLedgerForSubStoresRptVO vo = null;
		StockLedgerForSubStoresRptHLP hlp = null;
		HisUtil util = null;
		String strMsgText = null;
		try {
			bo = new StockLedgerForSubStoresRptBO();
			vo = new StockLedgerForSubStoresRptVO();
			hlp = new StockLedgerForSubStoresRptHLP();
			

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrDWHId((request.getParameter("storeId") == null || request.getParameter("storeId").equals("")) ? "0" : request
					.getParameter("storeId"));

			vo.setStrItemBrandId((request.getParameter("itembrandId") == null || request.getParameter("itembrandId").equals("") || request
					.getParameter("itembrandId").equals("0")) ? "0" : request.getParameter("itembrandId").split("^")[0]);
			vo.setStrFromDate(request.getParameter("fromDate"));
			vo.setStrToDate(request.getParameter("toDate"));

			vo.setStrWhetherBatchWise((request.getParameter("batchFlag") == null || request.getParameter("batchFlag").equals("")) ? "0" : request
					.getParameter("batchFlag"));

			if (vo.getStrWhetherBatchWise().equals("1")) {
				vo.setStrMode("1"); // Batch Wise Or Without Batch Wise
			} else {
				vo.setStrMode("2"); // Without Batch Wise
			}

			vo.setStrItemCatId("10");

			// Calling BO
			bo.getConsolidatedStockLedgerDtl(vo);

			String strStockLedgerDetails = "";
			response.setContentType("text/html;charset=UTF-8");
			if (vo.getStrMode().equals("1")) {
				strStockLedgerDetails = hlp.getStockLedgerDtlBatch(vo, request); // Batch
																		// Wise
			} else {
				strStockLedgerDetails = hlp.getStockLedgerDtl(vo, request); // Without
																	// Batch
																	// Wise
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStockLedgerDetails);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strMsgText = "mms.transactions.StockLedgerForSubStoresRptDATA.getStockLedgerDtl --> "	+ e.getMessage();
			HisException eObj = new HisException("mms",	"StockLedgerForSubStoresRptDATA->getStockLedgerDtl()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} finally {

			if (bo != null) {
				bo = null;
			}
			if (vo != null) {
				vo = null;
			}
			if (util != null) {
				util = null;
			}
		}
	}

	/**
	 * Gets the consolidated stock ledger rpt.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getConsolidatedStockLedgerReport(StockLedgerForSubStoresRptFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		StockLedgerForSubStoresRptBO bo = null;
		StockLedgerForSubStoresRptVO vo = null;
		HisUtil util = null;
		String strMsgText = null;
		StockLedgerForSubStoresRptHLP hlp = null;
		try {
			bo = new StockLedgerForSubStoresRptBO();
			vo = new StockLedgerForSubStoresRptVO();
			hlp = new StockLedgerForSubStoresRptHLP();
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrDWHId((request.getParameter("storeId") == null || request.getParameter("storeId").equals("")) ? "0" : request
					.getParameter("storeId"));

			vo.setStrItemBrandId((request.getParameter("itembrandId") == null || request.getParameter("itembrandId").equals("") || request
					.getParameter("itembrandId").equals("0")) ? "0" : request.getParameter("itembrandId").split("^")[0]);
			vo.setStrFromDate(request.getParameter("fromDate"));
			vo.setStrToDate(request.getParameter("toDate"));

			vo.setStrWhetherBatchWise((request.getParameter("batchFlag") == null || request.getParameter("batchFlag").equals("")) ? "0" : request
					.getParameter("batchFlag"));

			vo.setStrStoreName(request.getParameter("storeName"));

			if (vo.getStrWhetherBatchWise().equals("1")) {
				vo.setStrMode("1"); // Batch Wise
			} else {
				vo.setStrMode("2"); // Without Batch Wise
			}

			vo.setStrItemCatId("10");

			

			// Calling BO
			bo.getConsolidatedStockLedgerDtl(vo);

			String strStockLedgerDetails = "";
			response.setContentType("text/html;charset=UTF-8");
			if (vo.getStrMode().equals("1")) {
				strStockLedgerDetails = hlp.getConsolidatedStockLedgerRptBatch(vo, request);
			} else {
				strStockLedgerDetails = hlp.getConsolidatedStockLedgerRpt(vo, request); //
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStockLedgerDetails);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strMsgText = "mms.transactions.StockLedgerForSubStoresRptDATA.getConsolidatedStockLedgerReport --> "	+ e.getMessage();
			HisException eObj = new HisException("mms",	"StockLedgerForSubStoresRptDATA->getConsolidatedStockLedgerReport()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} finally {

			if (bo != null) {
				bo = null;
			}
			if (vo != null) {
				vo = null;
			}
			if (util != null) {
				util = null;
			}
		}
	}

	/**
	 * To get Detailed Stock Ledger Dtl.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getDetailedStockLedger(StockLedgerForSubStoresRptFB formBean, HttpServletRequest request, HttpServletResponse response){

		StockLedgerForSubStoresRptBO bo = null;
		StockLedgerForSubStoresRptVO vo = null;
		StockLedgerForSubStoresRptHLP hlp = null;

		HisUtil util = null;
		String strMsgText = null;

		try {
			bo = new StockLedgerForSubStoresRptBO();
			vo = new StockLedgerForSubStoresRptVO();
			hlp = new StockLedgerForSubStoresRptHLP();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrDWHId((request.getParameter("storeId") == null || request.getParameter("storeId").equals("")) ? "0" : request.getParameter("storeId"));

			vo.setStrItemBrandId((request.getParameter("itembrandId") == null || request.getParameter("itembrandId").equals("") || request.getParameter("itembrandId").equals("0")) ? "0" : request.getParameter("itembrandId").split("^")[0]);
			vo.setStrFromDate(request.getParameter("fromDate"));
			vo.setStrToDate(request.getParameter("toDate"));

			vo.setStrBatchNo((request.getParameter("batchNo") == null || request.getParameter("batchNo").equals("")) ? "0" : request.getParameter("batchNo"));
			vo.setStrOpeningBalance(request.getParameter("openingBalanceActive") + "#" + request.getParameter("openingBalanceQuarantine") + "#"+ request.getParameter("openingBalanceInActive"));
						
			vo.setStrItemCatId("10");

			// Calling BO
			bo.getDetailedStockLedgerDtl(vo);
			response.setContentType("text/html;charset=UTF-8");
			String strStockLedgerDetails = hlp.getDetailedStockLedgerDtl(vo, request);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStockLedgerDetails);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strMsgText = "mms.transactions.StockLedgerForSubStoresRptDATA.getDetailedStockLedger --> "	+ e.getMessage();
			HisException eObj = new HisException("mms",	"StockLedgerForSubStoresRptDATA->getDetailedStockLedger()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} finally {
			if (bo != null) {
				bo = null;
			}
			if (vo != null) {
				vo = null;
			}
			if (util != null) {
				util = null;
			}
			hlp = null;
		}
	}

	/**
	 * To get Detailed Stock Ledger Dtl.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getDetailedStockLedgerDtlRpt(StockLedgerForSubStoresRptFB formBean, HttpServletRequest request, HttpServletResponse response) {

		StockLedgerForSubStoresRptBO bo = null;
		StockLedgerForSubStoresRptVO vo = null;
		HisUtil util = null;
		String strMsgText = null;
		StockLedgerForSubStoresRptHLP hlp = null;
		try {
			bo = new StockLedgerForSubStoresRptBO();
			vo = new StockLedgerForSubStoresRptVO();
			hlp = new StockLedgerForSubStoresRptHLP();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrDWHId((request.getParameter("storeId") == null || request.getParameter("storeId").equals("")) ? "0" : request
					.getParameter("storeId"));

			vo.setStrItemBrandId((request.getParameter("itembrandId") == null || request.getParameter("itembrandId").equals("") || request
					.getParameter("itembrandId").equals("0")) ? "0" : request.getParameter("itembrandId"));
			vo.setStrFromDate(request.getParameter("fromDate"));
			vo.setStrToDate(request.getParameter("toDate"));

			vo.setStrBatchNo((request.getParameter("batchNo") == null || request.getParameter("batchNo").equals("")) ? "0" : request
					.getParameter("batchNo"));

			vo.setStrStoreName(request.getParameter("storeName"));
			vo.setStrOpeningBalance(request.getParameter("openingBalanceActive") + "#" + request.getParameter("openingBalanceInActive") + "#"
					+ request.getParameter("openingBalanceQuarantine"));

			vo.setStrBatchFlag((request.getParameter("batchFlg") == null || request.getParameter("batchFlg").equals("")) ? "0" : request
					.getParameter("batchFlg"));
			
			
			if (vo.getStrBatchFlag().equals("1")) {
				vo.setStrMode("1"); // Batch Wise
			} else {
				vo.setStrMode("2"); // Without Batch Wise
			}
			vo.setStrItemCatId("10");

			

			// Calling BO
			bo.getDetailedStockLedgerDtl(vo);
			response.setContentType("text/html;charset=UTF-8");
			String strStockLedgerDetails = hlp.getDetailedStockLedgerRpt(vo, request);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStockLedgerDetails);

			// formBean.setStrStockLedgerDetails(strStockLedgerDetails);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strMsgText = "mms.transactions.StockLedgerForSubStoresRptDATA.getDetailedStockLedgerDtlRpt --> "	+ e.getMessage();
			HisException eObj = new HisException("mms",	"StockLedgerForSubStoresRptDATA->getDetailedStockLedgerDtlRpt()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} finally {

			if (bo != null) {
				bo = null;
			}
			if (vo != null) {
				vo = null;
			}
			if (util != null) {
				util = null;
			}
		}
	}

	/**
	 * Gets the drug list.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getDrugList(StockLedgerForSubStoresRptFB formBean, HttpServletRequest request, HttpServletResponse response) {

		StockLedgerForSubStoresRptBO bo = null;
		StockLedgerForSubStoresRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;

		String hosCode = "";
		String storeId = "";
		String itemCatNO = "";
		String groupId = "";
		String itemType = "";

		try {
			util = new HisUtil("MMS Reports", "StockLedgerForSubStoresRptDATA");
			bo = new StockLedgerForSubStoresRptBO();
			voObj = new StockLedgerForSubStoresRptVO();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			storeId = request.getParameter("storeId");
			itemCatNO = request.getParameter("itemcat");
			groupId = request.getParameter("groupId");
			itemType = request.getParameter("itemType");

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrStoreId(storeId);
			formBean.setStrItemCatNo(itemCatNO);
			formBean.setStrGroupId(groupId);
			formBean.setStrItemType(itemType);

			voObj.setStrHospitalCode(hosCode);

			voObj.setStrStoreId(formBean.getStrStoreId());
			voObj.setStrItemCatId("10");
			voObj.setStrGroupId(groupId + "^" + itemType);

			bo.getItemList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}

			String strItemValues = "";
			if (voObj.getStrItemWs().size() != 0 && voObj.getStrItemWs() != null) {

				strItemValues = util.getOptionValue(voObj.getStrItemWs(), "", "", true);

				voObj.getStrItemWs().beforeFirst();
				formBean.setStrLeftItemList(util.getOptionValue(voObj.getStrItemWs(), "", "", true));

			} else {

				strItemValues = "";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemValues);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
			strMsgText = "mms.reports.StockLedgerForSubStoresRptDATA.getDrugList --> "+ e.getMessage();
			HisException eObj = new HisException("mms","StockLedgerForSubStoresRptDATA->getDrugList()", strMsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR####Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

		     } catch (Exception e1) {
				
			}
			eObj = null;
		} finally {
			if (voObj != null) {
				voObj = null;
			}
			if (formBean != null) {
				formBean = null;
			}
			util = null;
		}
	}

	/**
	 * Generate pdf.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void generatePdf(StockLedgerForSubStoresRptFB formBean, HttpServletRequest request, HttpServletResponse response) {

		String strMsgText = null, strReportData;

		try {
			String strHtmlCode = formBean.getStrHtmlCode();

			
			strReportData = "<html><head><style type='text/css'>@page {size: 16.5in 11.75in; margin-left:0in; margin-right:0in; "
				+ "margin-top:0.25in; margin-bottom: 0.25in;}</style></head><body>" + strHtmlCode + "</body></html>";

			
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=stock_ledger.pdf");
			//HtmlToPdfConvertor.convertHtmlToPDFDirect(response, strReportData);

		} catch (Exception e) {
			strMsgText = "mms.transactions.StockLedgerForSubStoresRptDATA.generatePdf --> "	+ e.getMessage();
			HisException eObj = new HisException("mms",	"StockLedgerForSubStoresRptDATA->generatePdf()", strMsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		}

	}
}
