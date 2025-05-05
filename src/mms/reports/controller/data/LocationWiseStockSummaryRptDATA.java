/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         LocationWiseStockSummaryRptDATA.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.reports.bo.LocationWiseStockSummaryRptBO;
import mms.reports.controller.fb.LocationWiseStockSummaryRptFB;
import mms.reports.controller.hlp.LocationWiseStockSummaryRptHLP;
import mms.reports.vo.LocationWiseStockSummaryRptVO;

//TODO: Auto-generated Javadoc
/**
 * The Class LocationWiseStockSummaryRptDATA.
 */
public class LocationWiseStockSummaryRptDATA {

	/**
	 * Gets the initial data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getInitialData(LocationWiseStockSummaryRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		LocationWiseStockSummaryRptBO bo = null;
		LocationWiseStockSummaryRptVO voObj = null;
		String strMsgText = null;
		String strDistrictStoreVal, strCircleCombo = "", strDistrictCombo = "", strCatgCombo = "";
		String strStoreValues = "";
		String strUserLevel, strCurrentDate = "";
		String strItemCmb = "",strProgrammeCmb="";

		HisUtil util = null;

		try {

			bo = new LocationWiseStockSummaryRptBO();
			voObj = new LocationWiseStockSummaryRptVO();

			util = new HisUtil("MMS Reports", "LocationWiseStockSummaryRptDATA");

			strUserLevel = formBean.getStrUserLevel();
		    voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			formBean.setStrUserLevel(strUserLevel);
			voObj.setStrUserLevel(strUserLevel);
			
			bo.getStoreList(voObj);

			if (voObj.getStrStoreWs() != null && voObj.getStrStoreWs().next()) 
			{
				
				voObj.setStrStoreId(voObj.getStrStoreWs().getString(1));
				voObj.setStrDistrictStoreId(voObj.getStrStoreId());
				voObj.getStrStoreWs().beforeFirst();
			}
			
			//System.out.println("-Store Id-----"+voObj.getStrStoreId()); 

			if (voObj.getStrStoreWs() != null && voObj.getStrStoreWs().size() > 0) {
				strDistrictStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);
			} else {
				strDistrictStoreVal = "<option value='0'>All</option>";
			}
			
			bo.getItemCatList(voObj);
			
			//System.out.println("-Size-----"+voObj.getStrItemCatWs().size()); 

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			if (voObj.getStrItemCatWs() != null && voObj.getStrItemCatWs().size() > 0) {
				String temp = util.getOptionValue(voObj.getStrItemCatWs(), "", "", false);

				strCatgCombo = temp;
			}			
			formBean.setStrCatgCombo(strCatgCombo);
			
			//System.out.println("-strCatgCombo-----"+strCatgCombo);

			voObj.setStrAlphabet("$");
			bo.getDrugList(voObj);

			if (voObj.getStrDrugWs() != null && voObj.getStrDrugWs().size() > 0) {
				strItemCmb = util.getOptionValue(voObj.getStrDrugWs(), "0", "0^All", true);

				voObj.getStrDrugWs().beforeFirst();
				formBean.setStrLeftItemFilterList(util.getOptionValue(voObj.getStrDrugWs(), "0", "", true));
			} else {
				strItemCmb = "<option value='0'>All</option>";
			}
			bo.getDrugClassificationValue(voObj);
			
			formBean.setStrDrugClassVal(util.getOptionValue(voObj.getDrugClassWs(), "0", "0^All", false));
			formBean.setStrDrugSearchCombo(strItemCmb);

			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			formBean.setStrDistrictStoreValues(strDistrictStoreVal);
			formBean.setStrStoreValues(strStoreValues);
			strCurrentDate = util.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);
			formBean.setStrUserLevel(strUserLevel);
			formBean.setStrCircleCombo(strCircleCombo);
			formBean.setStrDistrictCombo(strDistrictCombo);			

			// formBean.setStrItemTypeValues(util.getOptionValue(voObj.getItemTypeWs(),
			// "0", "0^All", false));

		} catch (Exception e) 
		{
			e.printStackTrace();
			strMsgText = e.getMessage();
			new HisException();
				


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
	 * Gets the district list.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getDistrictList(LocationWiseStockSummaryRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		LocationWiseStockSummaryRptBO bo = null;
		LocationWiseStockSummaryRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new LocationWiseStockSummaryRptBO();
			voObj = new LocationWiseStockSummaryRptVO();

			String strUserLevel =formBean.getStrUserLevel();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			formBean.setStrUserLevel(strUserLevel);
			voObj.setStrUserLevel(strUserLevel);

			String strCircleId = request.getParameter("circleId");

			voObj.setStrCircleId(strCircleId);

			bo.getDistrictList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "LocationWiseStockSummaryRptDATA");
			String strDistrictCombo = "";

			if (strUserLevel.equals("1") || strUserLevel.equals("2")) {

				if (voObj.getStrDistrictWS() != null && voObj.getStrDistrictWS().size() > 0) {
					strDistrictCombo = util.getOptionValue(voObj.getStrDistrictWS(), "0", "0^All", false);
				} else {
					strDistrictCombo = "<option value='0'>All</option>";
				}

			} else {
				if (strUserLevel.equals("3")) {
					if (voObj.getStrDistrictWS() != null && voObj.getStrDistrictWS().size() > 0) {
						strDistrictCombo = util.getOptionValue(voObj.getStrDistrictWS(), voObj.getStrDistrictId(), "0^Select Value", false);
					} else {
						strDistrictCombo = "<option value='0'>All</option>";
					}
				}

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strDistrictCombo);

		} catch (Exception e) {
			strMsgText = e.getMessage();
			new HisException();
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
	 * Gets the store combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getStoreCombo(LocationWiseStockSummaryRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		LocationWiseStockSummaryRptBO bo = null;
		LocationWiseStockSummaryRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		String temp = null;
		try {

			bo = new LocationWiseStockSummaryRptBO();
			voObj = new LocationWiseStockSummaryRptVO();

			String strUserLevel = formBean.getStrUserLevel();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			formBean.setStrUserLevel(strUserLevel);
			voObj.setStrUserLevel(strUserLevel);

			String strCircleId = request.getParameter("strCircleId");
			String strDistrictId = request.getParameter("strDistrictId");

			voObj.setStrDistrictId(strDistrictId);
			voObj.setStrCircleId(strCircleId);

			voObj.setStrMode("10");
			bo.getStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "LocationWiseStockSummaryRptDATA");
			String strStoreVal = "";

			if (voObj.getStrStoreWs().next()) {
				voObj.setStrStoreId(voObj.getStrStoreWs().getString(1));
			}
			voObj.getStrStoreWs().beforeFirst();

			if (voObj.getStrStoreWs() != null && voObj.getStrStoreWs().size() > 0) {

				strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);

			} else {
				strStoreVal = "<option value='0'>All</option>";
			}

			bo.getStoreTypeList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			if (voObj.getStrStoreTypeWS() != null && voObj.getStrStoreTypeWS().size() > 0) {
				temp = util.getOptionValue(voObj.getStrStoreTypeWS(), "", "", false);

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStoreVal + "$" + temp);

		} catch (Exception e) {
			strMsgText = e.getMessage();
			new HisException();
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
	 * Gets the store type list.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getStoreTypeList(LocationWiseStockSummaryRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		LocationWiseStockSummaryRptBO bo = null;
		LocationWiseStockSummaryRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new LocationWiseStockSummaryRptBO();
			voObj = new LocationWiseStockSummaryRptVO();

			String strUserLevel = formBean.getStrUserLevel();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			formBean.setStrUserLevel(strUserLevel);
			voObj.setStrUserLevel(strUserLevel);

			String strStoreTypeId = request.getParameter("strDistrictStoreId").split("\\^")[1];

			voObj.setStrStoreTypeId(strStoreTypeId);

			bo.getSubStoreTypeList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "LocationWiseStockSummaryRptDATA");
			String strStoreTypeCombo = "";

			if (voObj.getStrStoreTypeWS() != null && voObj.getStrStoreTypeWS().size() > 0) {

				String temp = util.getOptionValue(voObj.getStrStoreTypeWS(), "", "", false);

				strStoreTypeCombo = temp;
			} else {
				strStoreTypeCombo = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStoreTypeCombo);

		} catch (Exception e) {
			strMsgText = e.getMessage();
			new HisException();
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
	 * Gets the DWH type list.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getDWHTypeList(LocationWiseStockSummaryRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		LocationWiseStockSummaryRptBO bo = null;
		LocationWiseStockSummaryRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new LocationWiseStockSummaryRptBO();
			voObj = new LocationWiseStockSummaryRptVO();

			String strUserLevel = formBean.getStrUserLevel();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			formBean.setStrUserLevel(strUserLevel);
			voObj.setStrUserLevel(strUserLevel);

			bo.getStoreTypeList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "LocationWiseStockSummaryRptDATA");
			String strStoreTypeCombo = "";

			if (voObj.getStrStoreTypeWS() != null && voObj.getStrStoreTypeWS().size() > 0) {

				String temp = util.getOptionValue(voObj.getStrStoreTypeWS(), "", "", false);

				strStoreTypeCombo = temp;
			} else {
				strStoreTypeCombo = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStoreTypeCombo);

		} catch (Exception e) {
			strMsgText = e.getMessage();
			new HisException();
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
	 * Gets the DWH sub type list.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getDWHSubTypeList(LocationWiseStockSummaryRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		LocationWiseStockSummaryRptBO bo = null;
		LocationWiseStockSummaryRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new LocationWiseStockSummaryRptBO();
			voObj = new LocationWiseStockSummaryRptVO();

			String strUserLevel =formBean.getStrUserLevel();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			formBean.setStrUserLevel(strUserLevel);
			voObj.setStrUserLevel(strUserLevel);
			String strStoreTypeId = request.getParameter("strDistrictStoreId").split("\\^")[1];
			voObj.setStrStoreId(request.getParameter("strDistrictStoreId").split("\\^")[0]);
			voObj.setStrStoreTypeId(strStoreTypeId);
			bo.getDwhSubTypeCombo(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "LocationWiseStockSummaryRptDATA");
			String strStoreTypeCombo = "";

			if (voObj.getStrStoreTypeWS() != null && voObj.getStrStoreTypeWS().size() > 0) {

			
				String temp = util.getOptionValue(voObj.getStrStoreTypeWS(), "", "", false);

				strStoreTypeCombo = strStoreTypeCombo + temp;
			} else {
				strStoreTypeCombo = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStoreTypeCombo);

		} catch (Exception e) {
			strMsgText = e.getMessage();
			new HisException();
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
	 * Gets the sub store combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getSubStoreCombo(LocationWiseStockSummaryRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		LocationWiseStockSummaryRptBO bo = null;
		LocationWiseStockSummaryRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new LocationWiseStockSummaryRptBO();
			voObj = new LocationWiseStockSummaryRptVO();

			String strUserLevel =formBean.getStrUserLevel();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			formBean.setStrUserLevel(strUserLevel);
			voObj.setStrUserLevel(strUserLevel);

			String strCircleId = request.getParameter("strCircleId");
			String strDistrictId = request.getParameter("strDistrictId");
			String strDistrictStoreId = request.getParameter("strDistrictStoreId");
			String strStoreTypeId = request.getParameter("strStoreTypeId");

			voObj.setStrCircleId(strCircleId);
			voObj.setStrDistrictId(strDistrictId);

			voObj.setStrDistrictStoreId(strDistrictStoreId);
			voObj.setStrStoreTypeId(strStoreTypeId);

			voObj.setStrMode("11");
			bo.getSubStoreList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "LocationWiseStockSummaryRptDATA");
			String strStoreVal = "";

			if (voObj.getStrStoreWs().next()) {
				voObj.setStrStoreId(voObj.getStrStoreWs().getString(1));
			}
			voObj.getStrStoreWs().beforeFirst();

			if (voObj.getStrStoreWs() != null && voObj.getStrStoreWs().size() > 0) {

				strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", false);

			} else {
				strStoreVal = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStoreVal);

		} catch (Exception e) {
			strMsgText = e.getMessage();
			new HisException();
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
	public static void getItemCatList(LocationWiseStockSummaryRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		LocationWiseStockSummaryRptBO bo = null;
		LocationWiseStockSummaryRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new LocationWiseStockSummaryRptBO();
			voObj = new LocationWiseStockSummaryRptVO();

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
			util = new HisUtil("MMS Reports", "LocationWiseStockSummaryRptDATA");
			String temp = "<option value='0'>Select Value</option>";

			if (voObj.getStrItemCatWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrItemCatWs(), "", "", true);

			} else {

				temp = "<option value='0'>Select Value</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			strMsgText = e.getMessage();
			new HisException();
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
	public static void getGroupList(LocationWiseStockSummaryRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		LocationWiseStockSummaryRptBO bo = null;
		LocationWiseStockSummaryRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new LocationWiseStockSummaryRptBO();
			voObj = new LocationWiseStockSummaryRptVO();

			String strItemCatId = request.getParameter("itemcat");

			if (strItemCatId == null) {
				strItemCatId = "0";
			}

			voObj.setStrItemCatId(strItemCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			
			bo.getGroupList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "LocationWiseStockSummaryRptDATA");
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
			new HisException();
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
	 * Gets the drug list.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getDrugList(LocationWiseStockSummaryRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		LocationWiseStockSummaryRptBO bo = null;
		LocationWiseStockSummaryRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;

		String hosCode = "";
		String strItemCmb = "";

		try {
			util = new HisUtil("MMS Reports", "LocationWiseStockSummaryRptDATA");
			bo = new LocationWiseStockSummaryRptBO();
			voObj = new LocationWiseStockSummaryRptVO();

			hosCode = formBean.getStrHospitalCode();
			String strAlphabet = request.getParameter("strAlphabet");
			String strCatgId = request.getParameter("strCatgId");

			formBean.setStrHospitalCode(hosCode);

			voObj.setStrHospitalCode(hosCode);
			voObj.setStrAlphabet(strAlphabet);
			voObj.setStrCatgId(strCatgId);

			bo.getDrugList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			if (voObj.getStrDrugWs() != null && voObj.getStrDrugWs().size() > 0) {
				strItemCmb = util.getOptionValue(voObj.getStrDrugWs(), "", "", true);
			} else {
				strItemCmb = "";
			}


			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemCmb);



		} catch (Exception e) {
			strMsgText = e.getMessage();
			new HisException();
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
	 * Show html location stock report.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void showHTMLLocationStockReport(LocationWiseStockSummaryRptFB formBean, HttpServletRequest request, HttpServletResponse response) 	throws HisException, IOException, ServletException {

		new HashMap<String, Object>();
		String strMsgText = null;
		String strCircleId = "";
		String strDistrictId = "";
		String strDistrictStoreId = "";
		String strStoreId = "";
		String strItemBrandId = "";
		String strItemId = "0";
		String strDistrictName = formBean.getStrDistrictName();
		String strStoreName = formBean.getStrStoreName();
		formBean.getStrStoreTypeName();
		formBean.getStrSubStoreName();
		String strReportHeader = "";
		LocationWiseStockSummaryRptBO bo = null;
		LocationWiseStockSummaryRptVO vo = null;
		HisUtil util = null;

		try {
			util = new HisUtil("MMS Reports", "LocationWiseStockSummaryRptDATA");
			bo = new LocationWiseStockSummaryRptBO();
			vo = new LocationWiseStockSummaryRptVO();

			String strHospitalCode = formBean.getStrHospitalCode();
			String strStatusId = formBean.getStrStatusId();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strGroupId = formBean.getStrGroupId() == null ? "0" : formBean.getStrGroupId();
			String strCurrentDate = formBean.getStrCurrentDate();
			strCircleId = formBean.getStrCircleId() == null ? "0" : formBean.getStrCircleId();
			strDistrictId = formBean.getStrDistrictId() == null ? "0" : formBean.getStrDistrictId();
			strDistrictStoreId = formBean.getStrDistrictStoreId() == null ? "0" : formBean.getStrDistrictStoreId().split("\\^")[0];

			strStoreId = formBean.getStrStoreId() == null ? "0" : formBean.getStrStoreId();
			strItemBrandId = formBean.getStrItemBrandId() == null ? "0" : formBean.getStrItemBrandId();
			strItemId = formBean.getStrItemId() == null ? "0" : formBean.getStrItemId();

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrStatusId(strStatusId);
			vo.setStrReportId(strReportId);
			vo.setStrCatCode(strCatCode);
			vo.setStrUserRemarks(strUserRemarks);
			vo.setStrGroupId(strGroupId);
			vo.setStrCurrentDate(strCurrentDate);
			vo.setStrCircleId(strCircleId);
			vo.setStrDistrictId(strDistrictId);
			vo.setStrDistrictStoreId(strDistrictStoreId);
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrItemId(strItemId);
			vo.setStrBatchWiseChkFlg(formBean.getStrBatchWiseChkFlg());
			vo.setStrDrugClassName(formBean.getStrDrugClassName());
			vo.setStrDrugClassCode(formBean.getStrDrugClassCode());
			vo.setStrProgrammeId(formBean.getStrProgrammeId());
			vo.setStrStatusId(formBean.getStrStatusId());
			vo.setStrCatgId(formBean.getStrCatgId());

			String strDBHeader = getHeadersFromDB(strHospitalCode, strDistrictStoreId);

			strReportHeader = " Location Wise Stock In Hand Report <br>";
	
			strReportHeader += "Store - " + strStoreName + ", ";		
			
			strReportHeader += "Stock Status - " + formBean.getStrStockStatusName();
			

			// Calling BO Method
			bo.getLocationStockDtl(vo); // PKG_MMS_RPT.PROC_LOCATION_STOCK_HAND_DTL
			// 1- Store List (Header)
			// 3 - BATCH WISE, 2 >> WITHOUT BATCH

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			String strIndentItemList = "";
			strCurrentDate = util.getASDate("dd-MMM-yyyy");
			formBean.setStrReqDate(strCurrentDate);

			 if(vo.getStrBatchWiseChkFlg().equals("0"))
            {	
			 //strIndentItemList = LocationWiseStockSummaryRptHLP.printStockDrugList(vo,request);
			 strIndentItemList = LocationWiseStockSummaryRptHLP.printStockDrugListBatch(vo,request);
            }
            else
            {            	
			 strIndentItemList = LocationWiseStockSummaryRptHLP.printStockDrugListBatch(vo,request);
            }
			response.setContentType("text/html;charset=UTF-8");
			formBean.setStrIndentItemList(LocationWiseStockSummaryRptHLP.getPrintIndentDetails(vo, strReportHeader, strDBHeader, formBean,strIndentItemList, request));
			response.setContentType("text/html;charset=UTF-8");

			formBean.setStrTableWidth(vo.getStrTableWidth());

		} catch (Exception e) {
			e.printStackTrace();
			strMsgText = e.getMessage();
			new HisException();
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
	 * Gets the headers from db.
	 * 
	 * @param strHospCode the str hosp code
	 * @param storeId the store id
	 * @return the headers from db
	 * @throws Exception the exception
	 */
	private static String getHeadersFromDB(String strHospCode, String storeId) throws Exception {

		String strHeaders = null;

		HisDAO daoObj = null;
		WebRowSet ws = null;

		String qry =
			"SELECT NVL(HSTSTR_HEADER1 ,'NA'), NVL(HSTSTR_HEADER2 ,'NA'), NVL(HSTSTR_HEADER3 ,'NA') FROM HSTT_STORE_MST "
			+ "WHERE GNUM_ISVALID = 1 AND GNUM_HOSPITAL_CODE = " + strHospCode + " AND HSTNUM_STORE_ID = " + storeId;

		try {
			// initilize HisDAO object
			daoObj = new HisDAO("hisglobal", "ReportUtil");
			ws = daoObj.getQryResult(qry);
			if (ws != null) {

				if (ws.size() > 0) {
					if (ws.next()) {

						strHeaders = ws.getString(1) + "^" + ws.getString(2) + "^" + ws.getString(3);
					}
				} else {
					strHeaders = "NA^NA^NA";
				}
				
			}
		} catch (Exception e) {

			throw new Exception("ReportUtil.getHeadersFromDB()-->" + e.getMessage());
		} finally {
			try {
				if (ws != null) {
					ws.close();
					ws = null;
				}
				if (daoObj != null) {
					daoObj.free();
					daoObj = null;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return strHeaders;
	}
	
	/**
	 * Gets the programme combo.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the programme combo
	 */
	public static void getProgrammeCombo(LocationWiseStockSummaryRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		LocationWiseStockSummaryRptBO bo = null;
		LocationWiseStockSummaryRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		String strProgCmb = "", storeId = "";

		try {
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			bo = new LocationWiseStockSummaryRptBO();
			voObj = new LocationWiseStockSummaryRptVO();

			storeId = (String) request.getParameter("strStoreId");

			voObj.setStrHospitalCode(formBean.getStrHospitalCode());			
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrStoreId(storeId);

			bo.getProgrammeCombo(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			if (voObj.getStrProgNameComboWS() != null && voObj.getStrProgNameComboWS().size() > 0) {
				strProgCmb = util.getOptionValue(voObj.getStrProgNameComboWS(),	"", "0^All", true);
			} else {
				strProgCmb = "<option value=0>Select Value</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strProgCmb);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.LocationWiseStockSummaryRptDATA.getDrugList --> "+ e.getMessage();
			HisException eObj = new HisException("mms",	"LocationWiseStockSummaryRptDATA->getDrugList()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR####Application Error [ERROR ID : "+ eObj.getErrorID()+ "],Contact System Administrator! ");
			} catch (Exception e1) {

			}
			eObj = null;
		} finally {
			if (voObj != null)
				voObj = null;
			if (formBean != null)
				formBean = null;
			util = null;
		}
	}	
}
