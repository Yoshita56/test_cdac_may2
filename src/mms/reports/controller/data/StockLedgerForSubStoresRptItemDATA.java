/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         StockLedgerForSubStoresRptDATA.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.data;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.reports.bo.StockLedgerForSubStoresRptItemBO;
import mms.reports.controller.fb.StockLedgerForSubStoresRptItemFB;
import mms.reports.controller.hlp.StockLedgerForSubStoresRptItemHLP;
import mms.reports.vo.StockLedgerForSubStoresRptItemVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification Date:
 * 
 */
public class StockLedgerForSubStoresRptItemDATA {

	/**
	 * Gets the inits the val.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getInitVal(StockLedgerForSubStoresRptItemFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockLedgerForSubStoresRptItemBO bo = null;
		StockLedgerForSubStoresRptItemVO voObj = null;
		String strMsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new StockLedgerForSubStoresRptItemBO();
			voObj = new StockLedgerForSubStoresRptItemVO();
			//String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());

			//if (strUserLevel.equals("1") || strUserLevel.equals("2") || strUserLevel.equals("3")) {
			//	voObj.setStrMode("10");
			//} else {
				voObj.setStrMode("5");
			//}
				voObj.setStrItemCatId("0");
				voObj.setStrGroupId("0");
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "StockLedgerForSubStoresRptItemDATA");

			/*
			 * if(strUserLevel.equals("1") || strUserLevel.equals("2") || strUserLevel.equals("3")){ strStoreVal =
			 * util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false); } else
			 */
			
			if (voObj.getStrStoreWs() != null && voObj.getStrStoreWs().next()) {
				voObj.setStrStoreId(voObj.getStrStoreWs().getString(1));
				voObj.getStrStoreWs().beforeFirst();
			}
			
			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "", "", false);
		//	voObj.setStrItemCatId("10");
			
			bo.getItemCatList(voObj);

			if (voObj.getStrItemCatWs() != null && voObj.getStrItemCatWs().next()) {
				voObj.setStrItemCatId(voObj.getStrItemCatWs().getString(1));
				voObj.getStrItemCatWs().beforeFirst();
			}
			String temp2 = "";
			if (voObj.getStrItemCatWs() != null && voObj.getStrItemCatWs().size() > 0) {
				temp2 = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^All", true);
			} else {
				temp2 = "<option value='0'>All</option>";
			}

			formBean.setStrCatCombo(temp2);
			
			
			String strGroupId = "0";
			String strItemType = "0";
			voObj.setStrGroupId(strGroupId + "^" + strItemType);
			

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
			
			formBean.setStrItemTypeValues(util.getOptionValue(voObj.getItemTypeWs(), "0", "0^All", false));

			formBean.setStrItemValues(strItemValues);
			formBean.setStrStoreValues(strStoreVal);

			util.getASDate("dd-MMM-yyyy");

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			Calendar c1 = Calendar.getInstance();
			c1.add(Calendar.DATE, -1); // or Calendar.DAY_OF_MONTH which is a
										// synonym
			// System.out.println("Date + 1 days is : " +
			// sdf.format(c1.getTime()));
			formBean.setStrCurrentDate(sdf.format(c1.getTime()));

		} catch (Exception e) {
			strMsgText = e.getMessage();
			//new HisException("e-Aushadhi", "StockLedgerForSubStoresRptItemDATA.setInitDtl()",			strMsgText, request, response);

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
	 * Gets the item cat list.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getItemCatList(StockLedgerForSubStoresRptItemFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockLedgerForSubStoresRptItemBO bo = null;
		StockLedgerForSubStoresRptItemVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new StockLedgerForSubStoresRptItemBO();
			voObj = new StockLedgerForSubStoresRptItemVO();

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
			util = new HisUtil("MMS Transactions", "StockLedgerForSubStoresRptItemDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrItemCatWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^SelectValue", true);

			} else {

				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			strMsgText = e.getMessage();
			//new HisException("e-Aushadhi", "StockLedgerForSubStoresRptItemDATA.getItemCatList()",	strMsgText, request, response);
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
	public static void getGroupList(StockLedgerForSubStoresRptItemFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockLedgerForSubStoresRptItemBO bo = null;
		StockLedgerForSubStoresRptItemVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new StockLedgerForSubStoresRptItemBO();
			voObj = new StockLedgerForSubStoresRptItemVO();

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
			util = new HisUtil("MMS Transactions", "StockLedgerForSubStoresRptItemDATA");
			String temp = "<option value='0'>All</option>";
			
			if (voObj.getStrGroupCmbWS().size() != 0) {

				temp = util.getOptionValue(voObj.getStrGroupCmbWS(), "0", "0^All", true);

			} else {

				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			strMsgText = e.getMessage();
			//new HisException("e-Aushadhi", "StockLedgerForSubStoresRptItemDATA.getGroupList()",	strMsgText, request, response);
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
	public static void getItemList(StockLedgerForSubStoresRptItemFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockLedgerForSubStoresRptItemBO bo = null;
		StockLedgerForSubStoresRptItemVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new StockLedgerForSubStoresRptItemBO();
			voObj = new StockLedgerForSubStoresRptItemVO();

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
			util = new HisUtil("MMS Transactions", "StockLedgerForSubStoresRptItemDATA");
			String temp = "<option value='0'>All</option>";
			if (voObj.getStrItemWs().size() != 0 && voObj.getStrItemWs() != null) {

				temp = util.getOptionValue(voObj.getStrItemWs(), "0", "0^All", true);

			} else {

				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			strMsgText = e.getMessage();
			//new HisException("e-Aushadhi", "StockLedgerForSubStoresRptItemDATA.getItemList()",strMsgText, request, response);
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
	public static void getStockLedgerDtl(StockLedgerForSubStoresRptItemFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockLedgerForSubStoresRptItemBO bo = null;
		StockLedgerForSubStoresRptItemVO vo = null;
		StockLedgerForSubStoresRptItemHLP hlp = null;
		HisUtil util = null;
		String strMsgText = null;
		try {
			bo = new StockLedgerForSubStoresRptItemBO();
			vo = new StockLedgerForSubStoresRptItemVO();
			hlp = new StockLedgerForSubStoresRptItemHLP();
			new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

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
			vo.setStrItemCatId((request.getParameter("strItemCatId") == null || request.getParameter("strItemCatId").equals("")) ? "0" : request
					.getParameter("strItemCatId"));
			if (vo.getStrWhetherBatchWise().equals("1")) {
				vo.setStrMode("1"); // Batch Wise Or Without Batch Wise
			} else {
				vo.setStrMode("2"); // Without Batch Wise
			}

		//	vo.setStrItemCatId("10");

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
			strMsgText = e.getMessage();
			//new HisException("e-Aushadhi", "StockLedgerForSubStoresRptItemDATA.getStockLedgerDtl()",strMsgText, request, response);
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
	public static void getConsolidatedStockLedgerReport(StockLedgerForSubStoresRptItemFB formBean, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		StockLedgerForSubStoresRptItemBO bo = null;
		StockLedgerForSubStoresRptItemVO vo = null;
		HisUtil util = null;
		String strMsgText = null;
		StockLedgerForSubStoresRptItemHLP hlp = null;
		try {
			bo = new StockLedgerForSubStoresRptItemBO();
			vo = new StockLedgerForSubStoresRptItemVO();
			hlp = new StockLedgerForSubStoresRptItemHLP();
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

			/*
			 * System.out.println("mode:"+vo.getStrMode()); System.out.println("vo.getStrDWHId()"+vo.getStrDWHId()); System.out
			 * .println("vo.getStrItemBrandId()"+vo.getStrItemBrandId()); System.out.println("vo.getStrFromDate()"+vo.getStrFromDate());
			 * System.out.println("vo.getStrToDate()"+vo.getStrToDate()); System. out.println("vo.getStrWhetherBatchWise()"+vo.getStrWhetherBatchWise
			 * ()); System.out.println("vo.getStrMode()"+vo.getStrMode()); System.out.println("vo.getStrItemCatId()"+vo.getStrItemCatId());
			 * System.out.println("vo.getStrStoreName()"+vo.getStrStoreName()); System.out.println("vo.getStrDrugName()"+vo.getStrDrugName());
			 */

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
			strMsgText = e.getMessage();
			//new HisException("e-Aushadhi", "StockLedgerForSubStoresRptItemDATA.getConsolidatedStockLedgerReport()",	strMsgText, request, response);
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
	public static void getDetailedStockLedger(StockLedgerForSubStoresRptItemFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockLedgerForSubStoresRptItemBO bo = null;
		StockLedgerForSubStoresRptItemVO vo = null;
		StockLedgerForSubStoresRptItemHLP hlp = null;

		HisUtil util = null;
		String strMsgText = null;

		try {
			bo = new StockLedgerForSubStoresRptItemBO();
			vo = new StockLedgerForSubStoresRptItemVO();
			hlp = new StockLedgerForSubStoresRptItemHLP();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrDWHId((request.getParameter("storeId") == null || request.getParameter("storeId").equals("")) ? "0" : request
					.getParameter("storeId"));

			vo.setStrItemBrandId((request.getParameter("itembrandId") == null || request.getParameter("itembrandId").equals("") || request
					.getParameter("itembrandId").equals("0")) ? "0" : request.getParameter("itembrandId").split("^")[0]);
			vo.setStrFromDate(request.getParameter("fromDate"));
			vo.setStrToDate(request.getParameter("toDate"));

			vo.setStrBatchNo((request.getParameter("batchNo") == null || request.getParameter("batchNo").equals("")) ? "0" : request
					.getParameter("batchNo"));
			vo.setStrOpeningBalance(request.getParameter("openingBalanceActive") + "#" + request.getParameter("openingBalanceQuarantine") + "#"
					+ request.getParameter("openingBalanceInActive"));
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
			strMsgText = e.getMessage();
			//new HisException("e-Aushadhi", "StockLedgerForSubStoresRptItemDATA.getDetailedStockLedger()",strMsgText, request, response);
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
	public static void getDetailedStockLedgerDtlRpt(StockLedgerForSubStoresRptItemFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockLedgerForSubStoresRptItemBO bo = null;
		StockLedgerForSubStoresRptItemVO vo = null;
		HisUtil util = null;
		String strMsgText = null;
		StockLedgerForSubStoresRptItemHLP hlp = null;
		try {
			bo = new StockLedgerForSubStoresRptItemBO();
			vo = new StockLedgerForSubStoresRptItemVO();
			hlp = new StockLedgerForSubStoresRptItemHLP();

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

			/*
			 * System.out.println("vo.getStrDWHId()"+vo.getStrDWHId()); System.out .println("vo.getStrItemBrandId()"+vo.getStrItemBrandId());
			 * System.out.println("vo.getStrFromDate()"+vo.getStrFromDate()); System.out.println("vo.getStrToDate()"+vo.getStrToDate());
			 * System.out.println("vo.getStrBatchNo()"+vo.getStrBatchNo()); System.out.println("vo.getStrMode()"+vo.getStrMode());
			 * System.out.println("vo.getStrItemCatId()"+vo.getStrItemCatId()); System
			 * .out.println("vo.getStrOpeningBalance()"+vo.getStrOpeningBalance ());
			 */

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
			strMsgText = e.getMessage();
			//new HisException("e-Aushadhi", "StockLedgerForSubStoresRptItemDATA.getDetailedStockLedgerDtlRpt()",	strMsgText, request, response);
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
	public static void getDrugList(StockLedgerForSubStoresRptItemFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockLedgerForSubStoresRptItemBO bo = null;
		StockLedgerForSubStoresRptItemVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;

		String hosCode = "";
		String storeId = "";
		String itemCatNO = "";
		String groupId = "";
		String itemType = "",drugname="";

		try {
			util = new HisUtil("MMS Reports", "StockLedgerForSubStoresRptItemDATA");
			bo = new StockLedgerForSubStoresRptItemBO();
			voObj = new StockLedgerForSubStoresRptItemVO();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			storeId = request.getParameter("storeId");
			itemCatNO = request.getParameter("itemcat");
			groupId = request.getParameter("groupId");
			itemType = request.getParameter("itemType");
			drugname=request.getParameter("section");
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrStoreId(storeId);
			formBean.setStrItemCatNo(itemCatNO);
			formBean.setStrGroupId(groupId);
			formBean.setStrItemType(itemType);

			voObj.setStrHospitalCode(hosCode);

			voObj.setStrStoreId(formBean.getStrStoreId());
			voObj.setStrItemCatId("10");
			voObj.setStrGroupId(groupId + "^" + itemType);
			voObj.setStrSectionId(drugname);
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
			strMsgText = e.getMessage();
			//new HisException("e-Aushadhi", "StockLedgerForSubStoresRptItemDATA.getDrugList()",strMsgText, request, response);
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
	public static void generatePdf(StockLedgerForSubStoresRptItemFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String strMsgText = null, strReportData;

		try {
			String strHtmlCode = formBean.getStrHtmlCode();

			// System.out.println("strHtmlCode:::"+strHtmlCode);
			strHtmlCode = strHtmlCode.replace("width=\"100\\%\"", "width='50\\%'");
			strReportData = "<html><head><style type='text/css'>@page {size: landscape;}</style></head><body>" + strHtmlCode + "</body></html>";

			// System.out.println("stock legder htmlCode=>>=>"+strReportData);

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=stock_ledger.pdf");
			//HtmlToPdfConvertor.convertHtmlToPDFDirect(response, strReportData);

		} catch (Exception e) {
			strMsgText = e.getMessage();
			//new HisException("e-Aushadhi", "StockLedgerForSubStoresRptItemDATA.generatePdf()",	strMsgText, request, response);
		}

	}
}
