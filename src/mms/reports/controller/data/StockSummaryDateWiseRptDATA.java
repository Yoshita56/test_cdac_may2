/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockSummaryDateWiseRptDATA.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.reports.bo.StockSummaryDateWiseRptBO;
import mms.reports.controller.fb.ApplicationErrorLogDetailRptFB;
import mms.reports.controller.fb.StockSummaryDateWiseRptFB;
import mms.reports.controller.hlp.StockSummaryDateWiseRptHLP;
import mms.reports.vo.StockSummaryDateWiseRptVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StockSummaryDateWiseRptDATA.
 */
public class StockSummaryDateWiseRptDATA {

	/**
	 * Gets the initial data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getInitialData(StockSummaryDateWiseRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strMsgText = null;
		String strDistrictStoreVal="", strCircleCombo = "", strDistrictCombo = "", strStoreTypeCombo = "";		
		String strUserLevel, strCurrentDate = "";
		String strItemCmb = "";

		HisUtil util = null;
		

		try {

			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();

			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
			
			strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrAlphabet("$");
			voObj.setStrSeatId(formBean.getStrSeatId());
			formBean.setStrUserLevel(strUserLevel);
			voObj.setStrUserLevel(strUserLevel);

	
				bo.getInitializedValues(voObj);
				
						if (voObj.getStrDistrictStoreWs() != null && voObj.getStrDistrictStoreWs().next()) 
						{
							voObj.setStrStoreId(voObj.getStrDistrictStoreWs().getString(1));					
						}
						
						voObj.getStrDistrictStoreWs().beforeFirst();
		
						if (voObj.getStrDistrictStoreWs() != null && voObj.getStrDistrictStoreWs().size() > 0) {
		
							strDistrictStoreVal = util.getOptionValue(voObj.getStrDistrictStoreWs(), "", "", false);
		
						} else
							strDistrictStoreVal = "<option value='0'>All</option>";
						
				
				
						if (voObj.getStrStoreId().split("\\^")[1].equals("13") || voObj.getStrStoreId().split("\\^")[1].equals("14")) {
							formBean.setStrIsDdwFlag("1");
		
						} else
							formBean.setStrIsDdwFlag("0");

					
				bo.getStoreTypeList(voObj);
					

						if (voObj.getStrMsgType().equals("1")) {
							throw new Exception(voObj.getStrMsgString());
	
						}
				
						if (voObj.getStrStoreTypeWS() != null && voObj.getStrStoreTypeWS().size() > 0) {
							String temp = util.getOptionValue(voObj.getStrStoreTypeWS(), "0", "0^All", false);
							strStoreTypeCombo = temp;
						}
														
					

				bo.getDrugList(voObj);
				
						if (voObj.getStrMsgType().equals("1")) {
							throw new Exception(voObj.getStrMsgString());
		
						}

						if (voObj.getStrDrugWs() != null && voObj.getStrDrugWs().size() > 0) {
							strItemCmb = util.getOptionValue(voObj.getStrDrugWs(), "0", "0^All", true);
			
							voObj.getStrDrugWs().beforeFirst();
							formBean.setStrLeftItemFilterList(util.getOptionValue(voObj.getStrDrugWs(), "0", "", true));
						} else {
							strItemCmb = "<option value='0'>All</option>";
						}

						
			formBean.setStrDrugSearchCombo(strItemCmb);
			formBean.setStrDistrictStoreValues(strDistrictStoreVal);
			strCurrentDate = util.getDSDate("dd-Mon-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);
			formBean.setStrUserLevel(strUserLevel);
			formBean.setStrCircleCombo(strCircleCombo);
			formBean.setStrDistrictCombo(strDistrictCombo);
			formBean.setStrStoreTypeCombo(strStoreTypeCombo);

		} catch (Exception e) {
			e.printStackTrace();
			strMsgText = e.getMessage();
			new HisException("e-Aushadhi", "StockSummaryDateWiseRptDATA.getInitialData()",
					strMsgText);

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
	
	public static void getInitialData1(StockSummaryDateWiseRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strMsgText = null;
		String strDistrictStoreVal="", strCircleCombo = "", strDistrictCombo = "", strStoreTypeCombo = "";		
		String strUserLevel, strCurrentDate = "";
		String strItemCmb = "";

		HisUtil util = null;
		

		try {

			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();

			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
			
				
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrAlphabet("$");
			voObj.setStrSeatId(formBean.getStrSeatId());
			
	
												
					

				bo.getDrugList(voObj);
				
						if (voObj.getStrMsgType().equals("1")) {
							throw new Exception(voObj.getStrMsgString());
		
						}

						if (voObj.getStrDrugWs() != null && voObj.getStrDrugWs().size() > 0) {
							strItemCmb = util.getOptionValue(voObj.getStrDrugWs(), "0", "0^All", true);
			
							voObj.getStrDrugWs().beforeFirst();
							formBean.setStrLeftItemFilterList(util.getOptionValue(voObj.getStrDrugWs(), "0", "", true));
						} else {
							strItemCmb = "<option value='0'>All</option>";
						}

						
			formBean.setStrDrugSearchCombo(strItemCmb);
			
			strCurrentDate = util.getDSDate("dd-Mon-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);
			

		} catch (Exception e) {
			e.printStackTrace();
			strMsgText = e.getMessage();
			new HisException("e-Aushadhi", "StockSummaryDateWiseRptDATA.getInitialData()",
					strMsgText);

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
	public static void getStoreCombo(StockSummaryDateWiseRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strItemCmb="";
		try {

			
			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			bo.getStoreList(voObj);
			voObj.setStrItemCatId("10");
			voObj.setStrStoreId("0");
			voObj.setStrGroupId("0");
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			String strStoreVal = "";

			if (voObj.getStrStoreWs() != null
					&& voObj.getStrStoreWs().size() > 0) {

				if (voObj.getStrStoreWs().next()) {
					voObj.setStrStoreId(voObj.getStrStoreWs().getString(1));
				}
				voObj.getStrStoreWs().beforeFirst();

				strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0",
						"-1^Select Value", false);

			} else
				strStoreVal = "<option value='-1'>Select Value</option>";

			String temp,temp1,temp2;
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrStoreTypeCombo(strStoreVal);
			bo.getItemCatList(voObj);
			if (voObj.getStrItemCatWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "",
						true);

			} else {

				temp = "<option value='0'>SelectValue</option>";
			}
			formBean.setStrItemCatgCombo(temp);
			
			voObj.setStrItemCatNo("10");
			//bo.getDrugList1(voObj);
			
			

			/*if (voObj.getStrDrugWs() != null && voObj.getStrDrugWs().size() > 0) {
				strItemCmb = util.getOptionValue(voObj.getStrDrugWs(), "0", "0^All", true);

				voObj.getStrDrugWs().beforeFirst();
				formBean.setStrLeftItemFilterList(util.getOptionValue(voObj.getStrDrugWs(), "0", "", true));
			} else {
				strItemCmb = "<option value='0'>All</option>";
			}

			
formBean.setStrDrugSearchCombo(strItemCmb);*/
			
			
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.StockOnHandRptDATA.getStoreCombo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHandRptDATA->getStoreCombo()", strmsgText);
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
	
	public static void getItemCombo(StockSummaryDateWiseRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strItemCmb="";
		try {

			
			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrItemCatNo(request.getParameter("catId"));
			voObj.setStrStoreId(request.getParameter("storeId"));
			
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			bo.getDrugList1(voObj);
			
			

			if (voObj.getStrDrugWs() != null && voObj.getStrDrugWs().size() > 0) {
				strItemCmb = util.getOptionValue(voObj.getStrDrugWs(), "", "", true);

				voObj.getStrDrugWs().beforeFirst();
				formBean.setStrLeftItemFilterList(util.getOptionValue(voObj.getStrDrugWs(), "0", "", true));
			} else {
				strItemCmb = "<option value='0'></option>";
			}

			
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strItemCmb);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.StockOnHandRptDATA.getStoreCombo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHandRptDATA->getStoreCombo()", strmsgText);
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

	/**
	 * Gets the district list.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getDistrictList(StockSummaryDateWiseRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();

			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
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
			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
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
			new HisException("e-Aushadhi", "StockSummaryDateWiseRptDATA.getDistrictList()",
					strMsgText);
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
/*	public static void getStoreCombo(StockSummaryDateWiseRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		String temp = null;
		try {

			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();

			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
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
			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
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
			new HisException("e-Aushadhi", "StockSummaryDateWiseRptDATA.getStoreCombo()",
					strMsgText);
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
*/
	/**
	 * Gets the store type list.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getStoreTypeList(StockSummaryDateWiseRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();

			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
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
			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
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
			new HisException("e-Aushadhi", "StockSummaryDateWiseRptDATA.getStoreTypeList()",
					strMsgText);
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
	public static void getDWHTypeList(StockSummaryDateWiseRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();

			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			formBean.setStrUserLevel(strUserLevel);
			voObj.setStrUserLevel(strUserLevel);

			bo.getStoreTypeList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
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
			new HisException("e-Aushadhi", "StockSummaryDateWiseRptDATA.getDWHTypeList()",
					strMsgText);
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
	public static void getDWHSubTypeList(StockSummaryDateWiseRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();

			/*String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			formBean.setStrUserLevel(strUserLevel);
			voObj.setStrUserLevel(strUserLevel);
			String strStoreTypeId = request.getParameter("strDistrictStoreId").split("\\^")[1];
			voObj.setStrStoreTypeId(strStoreTypeId);
			bo.getDwhSubTypeCombo(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
			String strStoreTypeCombo = "";

			if (voObj.getStrStoreTypeWS() != null && voObj.getStrStoreTypeWS().size() > 0) {

				String temp = util.getOptionValue(voObj.getStrStoreTypeWS(), "", "", false);

				strStoreTypeCombo = temp;
			} else {
				strStoreTypeCombo = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStoreTypeCombo);*/
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			String strStoreTypeCombo = "";
			
			bo.getStoreTypeList(voObj);
			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
			String temp="";
			

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			if (voObj.getStrStoreTypeWS() != null && voObj.getStrStoreTypeWS().size() > 0) {
				 temp= util.getOptionValue(voObj.getStrStoreTypeWS(), "0", "0^All", false);
				strStoreTypeCombo = temp;
			}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStoreTypeCombo);	

		} catch (Exception e) {
			strMsgText = e.getMessage();
			new HisException("e-Aushadhi", "StockSummaryDateWiseRptDATA.getDWHSubTypeList()",
					strMsgText);
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
	public static void getSubStoreCombo(StockSummaryDateWiseRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();

			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
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
			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
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
			new HisException("e-Aushadhi", "StockSummaryDateWiseRptDATA.getSubStoreCombo()",
					strMsgText);
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
	public static void getItemCatList(StockSummaryDateWiseRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		String strItemCmb="";
		try {

			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();

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
			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrItemCatWs().next()) {
				//System.out.println("asa"+voObj.getStrItemCatWs().getString(1));
				voObj.setStrItemCatNo(voObj.getStrItemCatWs().getString(1));
			}
			voObj.getStrItemCatWs().beforeFirst();
			if (voObj.getStrItemCatWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrItemCatWs(), "", "", true);

			} else {

				temp = "<option value='0'>SelectValue</option>";
			}
			
			bo.getDrugList1(voObj);
			
			
			if (voObj.getStrDrugWs() != null && voObj.getStrDrugWs().size() > 0) {
				strItemCmb = util.getOptionValue(voObj.getStrDrugWs(), "", "", true);

				voObj.getStrDrugWs().beforeFirst();
				formBean.setStrLeftItemFilterList(util.getOptionValue(voObj.getStrDrugWs(), "0", "", true));
			} else {
				strItemCmb = "<option value='0'></option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp+"^"+strItemCmb);

		} catch (Exception e) {
			e.printStackTrace();
			strMsgText = e.getMessage();
			new HisException("e-Aushadhi", "StockSummaryDateWiseRptDATA.getItemCatList()",
					strMsgText);
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
	public static void getGroupList(StockSummaryDateWiseRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;
		try {

			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();

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
			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
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
			new HisException("e-Aushadhi", "StockSummaryDateWiseRptDATA.getGroupList()",
					strMsgText);
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
	public static void getDrugList(StockSummaryDateWiseRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO voObj = null;
		String strMsgText = null;
		HisUtil util = null;

		String hosCode = "";
		String strItemCmb = "";

		try {
			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
			bo = new StockSummaryDateWiseRptBO();
			voObj = new StockSummaryDateWiseRptVO();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strAlphabet = request.getParameter("strAlphabet");

			formBean.setStrHospitalCode(hosCode);
			voObj.setStrHospitalCode(hosCode);
			voObj.setStrAlphabet(strAlphabet);
			voObj.setStrItemCatNo(request.getParameter("catId"));

			bo.getDrugList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			if (voObj.getStrDrugWs() != null && voObj.getStrDrugWs().size() > 0) {
				strItemCmb = util.getOptionValue(voObj.getStrDrugWs(), "", "", true);
			} else {
				strItemCmb = "";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemCmb);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
			strMsgText = e.getMessage();
			new HisException("e-Aushadhi", "StockSummaryDateWiseRptDATA.getDrugList()",
					strMsgText);
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
	 * Show html report.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void showHTMLReport(StockSummaryDateWiseRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		new HashMap<String, Object>();
		String strCircleId = "";

		String strDistrictId = "";

		String strDistrictStoreId = "";

		String strStoreId = "";
		String strItemBrandId = "";
		String strItemId = "0";
		String strStoreTypeId=formBean.getStrStoreTypeId();
		formBean.getStrStoreTypeName();
		formBean.getStrSubStoreName();
		String strReportHeader = "";
		StockSummaryDateWiseRptBO bo = null;
		StockSummaryDateWiseRptVO vo = null;
		HisUtil util = null;

		try {
			util = new HisUtil("MMS Reports", "StockSummaryDateWiseRptDATA");
			bo = new StockSummaryDateWiseRptBO();
			vo = new StockSummaryDateWiseRptVO();

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
			vo.setStrStockValWiseChkFlg(formBean.getStrStockValWiseChkFlg());
			vo.setStrDate(formBean.getStrDate());
			vo.setStrStoreTypeId(strStoreTypeId);
			request.getSession().getAttribute("USER_LEVEL").toString();
			String strDBHeader = getHeadersFromDB(strHospitalCode, strDistrictStoreId);

			strReportHeader = " Stock In Hand Report: On Date - " + formBean.getStrDate() +", ";
			
			if(vo.getStrStoreTypeId().equals("0")){
			strReportHeader += " Store - "+ formBean.getStrStoreName();
			}
			else
			{
				strReportHeader += "Store - "+ formBean.getStrDistrictName1();
			}
			//	vo.setStrItemBrandId("0");
			
			formBean.setStrUserName(request.getSession().getAttribute("UserFullName").toString());
			// Calling BO Method
			bo.getRportData(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			response.setContentType("text/html;charset=UTF-8");
			
			String strIndentItemList="";
			
			if(vo.getStrStockValWiseChkFlg().equals("1"))
			{
				 strIndentItemList = StockSummaryDateWiseRptHLP.printZeroStockDrugList(vo, request);	
			}
			else
				 strIndentItemList = StockSummaryDateWiseRptHLP.printZeroStockDrugList2(vo, request);
			
			formBean.setStrIndentItemList(StockSummaryDateWiseRptHLP.getPrintIndentDetails(vo, strReportHeader, strDBHeader, formBean,
					strIndentItemList, request));

			// formBean.setStrIndentItemList(strIndentItemList);
			formBean.setStrTableWidth(vo.getStrTableWidth());
			strCurrentDate = util.getASDate("dd-MMM-yyyy");
			formBean.setStrReqDate(strCurrentDate);
			

		} catch (Exception e) {
			e.printStackTrace();
			String strMsgText = e.getMessage();
			new HisException("e-Aushadhi", "StockSummaryDateWiseRptDATA.showHTMLReport()",
					strMsgText);

		}
	}

	
	
	public static void showReport(StockSummaryDateWiseRptFB formBean,
			HttpServletRequest request, HttpServletResponse response)
	{

		ReportUtil ts = new ReportUtil();
		String strStoreId="";
		String strItemCatNo="";
		String stritemId="";
		String reportFormat = "html";

		Map<String, Object> params = new HashMap<String, Object>();
		try {
			
			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			
			String strUserRemarks = formBean.getStrUserRemarks();
			reportFormat = formBean.getStrReportFormat();
			String reportPath = ""; 
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;
			
			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;
				
			}
			
			strStoreId = formBean.getStrStoreTypeId() == null ? "0" : formBean.getStrStoreTypeId();
			strItemCatNo=formBean.getStritemCatNo() ==null ? "0" : formBean.getStritemCatNo();
			stritemId=formBean.getStrItemId() == null ? "0" : formBean.getStrItemId();
			
			String strReportName = "Stock Status On Given Date";
			
				 reportPath = "/mms/reports/dwh_stock_statusongivenDate.rptdesign";
		
				
		
			 //System.out.println("item"+stritemId);
				params.put("report_id", strReportId);
				params.put("report_Name", strReportName);
				params.put("report_Footer_Visible", footerVisible);
				params.put("report_user_Remarks", strUserRemarks);
				params.put("hospCode", strHospitalCode);
				params.put("storeid", strStoreId);
				params.put("catcode", strItemCatNo);  
				params.put("itemid", stritemId);
				params.put("date", formBean.getStrDate());
				
				
				ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			
		      	
		}
		catch (Exception e) 
		{
			//e.printStackTrace();
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
}
