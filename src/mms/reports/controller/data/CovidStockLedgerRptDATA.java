/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         CovidStockLedgerRptDATA.java
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
import mms.reports.bo.CovidStockLedgerRptBO;
import mms.reports.controller.fb.CovidStockLedgerRptFB;
import mms.reports.controller.hlp.CovidStockLedgerRptHLP;
import mms.reports.vo.CovidStockLedgerRptVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Vivek Aggarwal Version : 1.0 Date : 16-Mar-2012 Modification Date:
 * 
 */
public class CovidStockLedgerRptDATA {

	/**
	 * Gets the inits the val.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getInitVal(CovidStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		CovidStockLedgerRptBO bo = null;
		CovidStockLedgerRptVO voObj = null;
		String strMsgText = null;
		String strStoreVal = "";
		HisUtil util = null;
		try {

			bo = new CovidStockLedgerRptBO();
			voObj = new CovidStockLedgerRptVO();
			//String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());

			
			
			voObj.setStrMode("1");
			

			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "CovidStockLedgerRptDATA");
			
			//System.out.println("--------------------- DATA ----------------------------"+voObj.getStrStoreWs().size());
			

			strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "", "", false);

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
			
			//System.out.println("--------------------- strItemValues ----------------------------"+strItemValues);
			//System.out.println("--------------------- strStoreVal ----------------------------"+strStoreVal);

			

			formBean.setStrItemValues(strItemValues);
			formBean.setStrStoreValues(strStoreVal);

			util.getASDate("dd-MMM-yyyy");

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			Calendar c1 = Calendar.getInstance();
			c1.add(Calendar.DATE, 0); // or Calendar.DAY_OF_MONTH which is a
										// synonym
			// System.out.println("Date + 1 days is : " +
			// sdf.format(c1.getTime()));
			formBean.setStrCurrentDate(sdf.format(c1.getTime()));

		} catch (Exception e) {
			strMsgText = e.getMessage();
			

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
	public static void getItemCatList(CovidStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		CovidStockLedgerRptBO bo = null;
		CovidStockLedgerRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new CovidStockLedgerRptBO();
			voObj = new CovidStockLedgerRptVO();

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
			util = new HisUtil("MMS Transactions", "CovidStockLedgerRptDATA");
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
	public static void getGroupList(CovidStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		CovidStockLedgerRptBO bo = null;
		CovidStockLedgerRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new CovidStockLedgerRptBO();
			voObj = new CovidStockLedgerRptVO();

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
			util = new HisUtil("MMS Transactions", "CovidStockLedgerRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrGroupWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrGroupWs(), "0", "0^All", true);

			} else {

				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			strMsgText = e.getMessage();
					
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
	public static void getItemList(CovidStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		CovidStockLedgerRptBO bo = null;
		CovidStockLedgerRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new CovidStockLedgerRptBO();
			voObj = new CovidStockLedgerRptVO();

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
			util = new HisUtil("MMS Transactions", "CovidStockLedgerRptDATA");
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
	public static void getStockLedgerDtl(CovidStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		CovidStockLedgerRptBO bo = null;
		CovidStockLedgerRptVO vo = null;
		CovidStockLedgerRptHLP hlp = null;
		HisUtil util = null;
		String strMsgText = null;
		try {
			bo = new CovidStockLedgerRptBO();
			vo = new CovidStockLedgerRptVO();
			hlp = new CovidStockLedgerRptHLP();
		

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrDWHId((request.getParameter("storeId") == null || request.getParameter("storeId").equals("")) ? "0" : request
					.getParameter("storeId"));

			vo.setStrItemBrandId((request.getParameter("itembrandId") == null || request.getParameter("itembrandId").equals("") || request
					.getParameter("itembrandId").equals("0")) ? "0" : request.getParameter("itembrandId").split("^")[0]);
			vo.setStrFromDate(request.getParameter("fromDate"));
			vo.setStrToDate(request.getParameter("toDate"));

			System.out.println("brandId-->"+vo.getStrItemBrandId());
			vo.setStrItemCatId("10");

			// Calling BO
			bo.getConsolidatedStockLedgerDtl(vo);

			String strStockLedgerDetails = "";
			response.setContentType("text/html;charset=UTF-8");
			
				strStockLedgerDetails = hlp.getStockLedgerDtl(vo, request); 
				
				System.out.println("HLp/OP-----strStockLedgerDetails-->"+strStockLedgerDetails);
			

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStockLedgerDetails);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strMsgText = e.getMessage();
			
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
	public static void getConsolidatedStockLedgerReport(CovidStockLedgerRptFB formBean, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		CovidStockLedgerRptBO bo = null;
		CovidStockLedgerRptVO vo = null;
		HisUtil util = null;
		String strMsgText = null;
		CovidStockLedgerRptHLP hlp = null;
		try {
			bo = new CovidStockLedgerRptBO();
			vo = new CovidStockLedgerRptVO();
			hlp = new CovidStockLedgerRptHLP();
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			vo.setStrDWHId((request.getParameter("storeId") == null || request.getParameter("storeId").equals("")) ? "0" : request
					.getParameter("storeId"));

			vo.setStrItemBrandId((request.getParameter("itembrandId") == null || request.getParameter("itembrandId").equals("") || request
					.getParameter("itembrandId").equals("0")) ? "0" : request.getParameter("itembrandId").split("^")[0]);
			vo.setStrFromDate(request.getParameter("fromDate"));
			vo.setStrToDate(request.getParameter("toDate"));
			vo.setStrStoreName(request.getParameter("storeName"));

			

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
				strStockLedgerDetails = hlp.getConsolidatedStockLedgerRpt(vo, request); //
			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStockLedgerDetails);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strMsgText = e.getMessage();
			
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
	public static void getDetailedStockLedger(CovidStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		CovidStockLedgerRptBO bo = null;
		CovidStockLedgerRptVO vo = null;
		CovidStockLedgerRptHLP hlp = null;

		HisUtil util = null;
		String strMsgText = null;

		try {
			bo = new CovidStockLedgerRptBO();
			vo = new CovidStockLedgerRptVO();
			hlp = new CovidStockLedgerRptHLP();

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
	public static void getDetailedStockLedgerDtlRpt(CovidStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		CovidStockLedgerRptBO bo = null;
		CovidStockLedgerRptVO vo = null;
		HisUtil util = null;
		String strMsgText = null;
		CovidStockLedgerRptHLP hlp = null;
		try {
			bo = new CovidStockLedgerRptBO();
			vo = new CovidStockLedgerRptVO();
			hlp = new CovidStockLedgerRptHLP();

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
	public static void getDrugList(CovidStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		CovidStockLedgerRptBO bo = null;
		CovidStockLedgerRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;

		String hosCode = "";
		String storeId = "";
		String itemCatNO = "";
		String groupId = "";
		String itemType = "",drugname="";

		try {
			util = new HisUtil("MMS Reports", "CovidStockLedgerRptDATA");
			bo = new CovidStockLedgerRptBO();
			voObj = new CovidStockLedgerRptVO();

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
	public static void generatePdf(CovidStockLedgerRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

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
			
		}

	}
}
