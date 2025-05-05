/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         StockOnHandRptDATA.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.data;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.reports.bo.ConsumptionDetailRptBO_NEW;
import mms.reports.controller.fb.ConsumptionDetailRptFB_NEW;
import mms.reports.controller.hlp.StockConsumptionDateWiseRptHLP;
import mms.reports.vo.ConsumptionDetailRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class StockOnHandRptDATA.
 */
public class ConsumptionDetailRptDATA_NEW {


	/**
	 * Gets the district list.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the district list
	 */
	public static void getDistrictList(ConsumptionDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionDetailRptBO_NEW bo = null;
		ConsumptionDetailRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ConsumptionDetailRptBO_NEW();
			voObj = new ConsumptionDetailRptVO_NEW();

			String strUserLevel = request.getSession()
					.getAttribute("USER_LEVEL").toString();
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
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			String strDistrictCombo = "";

			if (strUserLevel.equals("1") || strUserLevel.equals("2")) {

				if (voObj.getStrDistrictWS() != null
						&& voObj.getStrDistrictWS().size() > 0) {
					strDistrictCombo = util.getOptionValue(
							voObj.getStrDistrictWS(), "0", "0^All", false);
				}

				else {
					strDistrictCombo = "<option value='0'>All</option>";
				}

			} else {
				if (strUserLevel.equals("3")) {
					if (voObj.getStrDistrictWS() != null
							&& voObj.getStrDistrictWS().size() > 0) {
						strDistrictCombo = util.getOptionValue(
								voObj.getStrDistrictWS(),
								voObj.getStrDistrictId(), "0^Select Value",
								false);
					}

					else {
						strDistrictCombo = "<option value='0'>All</option>";
					}
				}

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strDistrictCombo);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.StockOnHandRptDATA.getDistrictList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHandRptDATA->getDistrictList()", strmsgText);
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
	 * Gets the store combo.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the store combo
	 */
	public static void getStoreCombo(ConsumptionDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionDetailRptBO_NEW bo = null;
		ConsumptionDetailRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ConsumptionDetailRptBO_NEW();
			voObj = new ConsumptionDetailRptVO_NEW();
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
						"0^All", false);

			} else
				strStoreVal = "<option value='0'>All</option>";

			String temp,temp1,temp2;
			formBean.setStrStoreValues(strStoreVal);
			bo.getItemCatList(voObj);
			if (voObj.getStrItemCatWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "",
						true);

			} else {

				temp = "<option value='0'>SelectValue</option>";
			}
			formBean.setStrItemCatgCombo(temp);
			
			/*bo.getGroupList(voObj);
			if (voObj.getStrGroupCmbWS().size() != 0) {

				temp1 = util.getOptionValue(voObj.getStrGroupCmbWS(), "0",
						"0^All", true);

			} else {

				temp1 = "<option value='0'>All</option>";
			}
			formBean.setStrGroupCombo(temp1);
			bo.getitemTypecmb(voObj);
			if (voObj.getItemTypeWs().size() != 0) {

				temp2 = util.getOptionValue(voObj.getItemTypeWs(), "0",
						"0^All", true);

			} else {

				temp2 = "<option value='0'>All</option>";
			}
			formBean.setStrItemTypeValues(temp2);*/
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

	/**
	 * Gets the store type list.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the store type list
	 */
	public static void getStoreTypeList(ConsumptionDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionDetailRptBO_NEW bo =null;
		ConsumptionDetailRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strStoreTypeId="";
		try {

			bo = new ConsumptionDetailRptBO_NEW();
			voObj = new ConsumptionDetailRptVO_NEW();

			String strUserLevel = request.getSession()
					.getAttribute("USER_LEVEL").toString();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			formBean.setStrUserLevel(strUserLevel);
			voObj.setStrUserLevel(strUserLevel);
			
			
			if(request.getParameter("strDistrictStoreId").length()>9){
				strStoreTypeId = request.getParameter("strDistrictStoreId").split("\\^")[1];
			}
				voObj.setStrStoreId(request.getParameter("strDistrictStoreId"));

			voObj.setStrStoreTypeId(strStoreTypeId);

			bo.getStoreTypeList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			String strStoreTypeCombo = "";

			if ((voObj.getStrStoreTypeWS() != null)
					&&( voObj.getStrStoreTypeWS().size() > 0)  ) {
 
				 
				if ( !voObj.getStrStoreId().equals("0"))
				{
					strStoreTypeCombo =
						"<option value='1'>Only District Warehouse</option>" + "<option value='2'>All Except District Warehouse</option>"
								+ "<option value='3'>All Including District Warehouse</option>";
				}
				else
				{
					strStoreTypeCombo = "<option value='0'>All</option>";
					
				}
				
				String temp = util.getOptionValue(voObj.getStrStoreTypeWS(), "1", "", false);
				
				strStoreTypeCombo = strStoreTypeCombo + temp;
}

			

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStoreTypeCombo);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.StockOnHandRptDATA.getStoreTypeList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHandRptDATA->getStoreTypeList()", strmsgText);
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
	 * Gets the sub store combo.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the sub store combo
	 */
	public static void getSubStoreCombo(ConsumptionDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionDetailRptBO_NEW bo = null;
		ConsumptionDetailRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ConsumptionDetailRptBO_NEW();
			voObj = new ConsumptionDetailRptVO_NEW();

			String strUserLevel = request.getSession().getAttribute("USER_LEVEL").toString();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			formBean.setStrUserLevel(strUserLevel);
			voObj.setStrUserLevel(strUserLevel);

			String strCircleId = request.getParameter("strCircleId");
			String strDistrictId = request.getParameter("strDistrictId");
			String strDistrictStoreId = request
					.getParameter("strDistrictStoreId");
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
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			String strStoreVal = "";

			if (voObj.getStrStoreWs().next()) {
				voObj.setStrStoreId(voObj.getStrStoreWs().getString(1));
			}
			voObj.getStrStoreWs().beforeFirst();

			if (voObj.getStrStoreWs() != null
					&& voObj.getStrStoreWs().size() > 0) {

				strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0",
						"0^All", false);

			} else
				strStoreVal = "<option value='0'>All</option>";

		
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strStoreVal);

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
	 * Gets the item cat list.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the item cat list
	 */
	public static void getItemCatList(ConsumptionDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionDetailRptBO_NEW bo = null;
		ConsumptionDetailRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ConsumptionDetailRptBO_NEW();
			voObj = new ConsumptionDetailRptVO_NEW();

			String strStoreId = request.getParameter("storeId");

			if (strStoreId == null)
				strStoreId = "0";

			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			String temp = "<option value='0'>SelectValue</option>";

			if (voObj.getStrItemCatWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "",
						true);

			} else {

				temp = "<option value='0'>SelectValue</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.StockOnHandRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHandRptDATA->getItemCatList()", strmsgText);
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
	 * Gets the group list.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the group list
	 */
	public static void getGroupList(ConsumptionDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionDetailRptBO_NEW bo = null;
		ConsumptionDetailRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ConsumptionDetailRptBO_NEW();
			voObj = new ConsumptionDetailRptVO_NEW();

			String strItemCatId = request.getParameter("itemcat");

			if (strItemCatId == null)
				strItemCatId = "0";

			voObj.setStrItemCatId(strItemCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			
			bo.getGroupList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			String temp = "<option value='0'>All</option>";
			String temp1 = "<option value='0'>All</option>";
			if (voObj.getStrGroupCmbWS().size() != 0) {

				temp = util.getOptionValue(voObj.getStrGroupCmbWS(), "0",
						"0^All", true);

			} else {

				temp = "<option value='0'>All</option>";
			}
			if (voObj.getItemTypeWs().size() != 0) {

				temp1 = util.getOptionValue(voObj.getItemTypeWs(), "0",
						"0^All", true);

			} else {

				temp1 = "<option value='0'>All</option>";
			}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp+"^"+temp1);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.StockOnHandRptDATA.getGroupList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHandRptDATA->getGroupList()", strmsgText);
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
	 * Gets the drug list.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the drug list
	 */
	public static void getDrugList(ConsumptionDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionDetailRptBO_NEW bo = null;
		ConsumptionDetailRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		String hosCode = "";
		String storeId = "";
		String itemCatNO = "";
		String groupId = "";
		String statusId = "";
		String strItemCmb = "", itemType = "", districtStoreId = "";

		try {
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			bo = new ConsumptionDetailRptBO_NEW();
			voObj = new ConsumptionDetailRptVO_NEW();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			storeId = (String) request.getParameter("storeId");
			itemCatNO = (String) request.getParameter("itemcat");
			groupId = (String) request.getParameter("groupId");
			itemType = (String) request.getParameter("itemType");
			statusId = (String) request.getParameter("statusId");

			

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrStoreId(storeId);

			
			
			
			
			
			formBean.setStrItemCatNo(itemCatNO);
			formBean.setStrGroupId(groupId);
			formBean.setStrItemType(itemType);
			formBean.setStrStatusId(statusId);

			voObj.setStrHospitalCode(hosCode);
			voObj.setStrDistrictStoreId("0");
			voObj.setStrStoreId(request.getParameter("storeId"));
			voObj.setStrItemCatId( request.getParameter("itemcat"));
			voObj.setStrGroupId(request.getParameter("groupId") + "^" + request.getParameter("itemType"));

			voObj.setStrStatusId(request.getParameter("statusId"));

			bo.getDrugList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			if (voObj.getStrDrugWs() != null && voObj.getStrDrugWs().size() > 0) {
				strItemCmb = util.getOptionValue(voObj.getStrDrugWs(), "", "",
						true);
			} else {
				strItemCmb = "";
			}
			bo.getGroupList(voObj);
			
			
			String temp = "<option value='0'>All</option>";
			String temp1 = "<option value='0'>All</option>";
			if (voObj.getStrGroupCmbWS().size() != 0) {

				temp = util.getOptionValue(voObj.getStrGroupCmbWS(), "0",
						"0^All", true);

			} else {

				temp = "<option value='0'>All</option>";
			}
			if (voObj.getItemTypeWs().size() != 0) {

				temp1 = util.getOptionValue(voObj.getItemTypeWs(), "0",
						"0^All", true);

			} else {

				temp1 = "<option value='0'>All</option>";
			}
			
			
			
			
			

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemCmb+"^"+temp+"^"+temp1);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.StockOnHandRptDATA.getDrugList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHandRptDATA->getDrugList()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR####Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

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
	public static void getDrugList1(ConsumptionDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionDetailRptBO_NEW bo = null;
		ConsumptionDetailRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		String hosCode = "";
		String storeId = "";
		String itemCatNO = "";
		String groupId = "";
		String statusId = "";
		String strItemCmb = "", itemType = "", districtStoreId = "";

		try {
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			bo = new ConsumptionDetailRptBO_NEW();
			voObj = new ConsumptionDetailRptVO_NEW();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			storeId = (String) request.getParameter("storeId");
			itemCatNO = (String) request.getParameter("itemcat");
			groupId = (String) request.getParameter("groupId");
			itemType = (String) request.getParameter("itemType");
			statusId = (String) request.getParameter("statusId");

			

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrStoreId(storeId);

			
			
			
			
			
			formBean.setStrItemCatNo(itemCatNO);
			formBean.setStrGroupId(groupId);
			formBean.setStrItemType(itemType);
			formBean.setStrStatusId(statusId);

			voObj.setStrHospitalCode(hosCode);
			voObj.setStrDistrictStoreId(formBean.getStrDistrictStoreId());
			voObj.setStrStoreId(formBean.getStrStoreId());
			voObj.setStrItemCatId(itemCatNO);
			voObj.setStrGroupId(groupId + "^" + itemType);

			voObj.setStrStatusId(statusId);

			bo.getDrugList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			if (voObj.getStrDrugWs() != null && voObj.getStrDrugWs().size() > 0) {
				strItemCmb = util.getOptionValue(voObj.getStrDrugWs(), "", "",
						true);
			} else {
				strItemCmb = "";
			}
			bo.getGroupList(voObj);
			
			
			String temp = "<option value='0'>All</option>";
			String temp1 = "<option value='0'>All</option>";
			if (voObj.getStrGroupCmbWS().size() != 0) {

				temp = util.getOptionValue(voObj.getStrGroupCmbWS(), "0",
						"0^All", true);

			} else {

				temp = "<option value='0'>All</option>";
			}
			if (voObj.getItemTypeWs().size() != 0) {

				temp1 = util.getOptionValue(voObj.getItemTypeWs(), "0",
						"0^All", true);

			} else {

				temp1 = "<option value='0'>All</option>";
			}
			
			
			
			
			

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemCmb+"^"+temp+"^"+temp1);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.StockOnHandRptDATA.getDrugList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHandRptDATA->getDrugList()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR####Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

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
	public static void getProgrammeCombo(ConsumptionDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionDetailRptBO_NEW bo = null;
		ConsumptionDetailRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		String strProgCmb = "", districtStoreId = "";

		try {
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			bo = new ConsumptionDetailRptBO_NEW();
			voObj = new ConsumptionDetailRptVO_NEW();

			districtStoreId = (String) request.getParameter("districtStoreId");
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrDistrictStoreId(districtStoreId);
			voObj.setStrSeatId(formBean.getStrSeatId());

			bo.getProgrammeCombo(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			if (voObj.getStrProgNameComboWS() != null
					&& voObj.getStrProgNameComboWS().size() > 0) {
				strProgCmb = util.getOptionValue(voObj.getStrProgNameComboWS(),
						"0", "0^All", true);
			} else {
				strProgCmb = "<option value=0>All</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strProgCmb);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.StockOnHandRptDATA.getDrugList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHandRptDATA->getDrugList()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR####Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

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
	public static void getPoCombo(ConsumptionDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ConsumptionDetailRptBO_NEW bo = null;
		ConsumptionDetailRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		String strPoCmb = "", districtStoreId = "";

		try {
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			bo = new ConsumptionDetailRptBO_NEW();
			voObj = new ConsumptionDetailRptVO_NEW();
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrStoreId(request.getParameter("storeId"));
			voObj.setStrItemCatNo(request.getParameter("itemcat"));
			voObj.setStrFromDate(request.getParameter("fromDate"));
			voObj.setStrToDate(request.getParameter("toDate"));
			voObj.setStrpotypeId(request.getParameter("potype"));
			voObj.setStrSeatId(formBean.getStrSeatId());

			bo.getPoCombo(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			if (voObj.getStrPoWs() != null
					&& voObj.getStrPoWs().size() > 0) {
				strPoCmb = util.getOptionValue(voObj.getStrPoWs(),
						"0", "0^All", true);
			} else {
				strPoCmb = "<option value=0>All</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strPoCmb);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.StockOnHandRptDATA.getDrugList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StockOnHandRptDATA->getDrugList()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR####Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

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
	
	public static void showHTMLReport(ConsumptionDetailRptFB_NEW formBean, HttpServletRequest request, HttpServletResponse response) throws Exception{

		new HashMap<String, Object>();
		String strCircleId = "";

		String strDistrictId = "";

		String strDistrictStoreId = "";

		String strStoreId = "";
		String strItemBrandId = "";
		String strItemId = "0";
		String strCircleName = formBean.getStrCircleName();
		String strDistrictName = formBean.getStrDistrictName();
		String strStoreName = formBean.getStrStoreName();
		formBean.getStrStoreTypeName();
		formBean.getStrSubStoreName();
		String strReportHeader = "";
		ConsumptionDetailRptBO_NEW bo = null;
		ConsumptionDetailRptVO_NEW vo = null;
		
		HisUtil util = null;

		try {
			util = new HisUtil("MMS Reports", "StockConsumptionDateWiseRptDATA");
			
			bo = new ConsumptionDetailRptBO_NEW();
			vo = new ConsumptionDetailRptVO_NEW();

			String strHospitalCode = formBean.getStrHospitalCode();
			String strStatusId = formBean.getStrStatusId();
			String strReportId = formBean.getStrReportId();
			String strCatCode = formBean.getStrItemCatNo();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strGroupId = formBean.getStrGroupId() == null ? "0" : formBean.getStrGroupId();
			String strCurrentDate = formBean.getStrCurrentDate();
			strCircleId = "0" ;
			strDistrictId = "0";
			strDistrictStoreId = formBean.getStrDistrictStoreId() == null ? "0" : formBean.getStrDistrictStoreId().split("\\^")[0];

			strStoreId = formBean.getStrStoreId() == null ? "0" : formBean.getStrStoreId();
			strItemBrandId = formBean.getStrItemBrandId() == null ? "0" : formBean.getStrItemBrandId();
			strItemId = formBean.getStrItemBrandId() == null ? "0" : formBean.getStrItemBrandId();

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrStatusId(strStatusId);
			//vo.setStrReportId(strReportId);
			vo.setStrCatCode(strCatCode);
			vo.setStrUserRemarks(strUserRemarks);
			vo.setStrGroupId(strGroupId);
			vo.setStrCurrentDate(strCurrentDate);
			vo.setStrCircleId(strCircleId);
			vo.setStrDistrictId(formBean.getStrStoreId());
			vo.setStrDistrictStoreId(strDistrictStoreId);
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrItemId(strItemId);
			vo.setStrBatchWiseChkFlg(formBean.getStrBatchWiseChkFlg());
			vo.setStrFromDate(formBean.getStrDate());
			if (formBean.getStrDays1().length() > 0) {
				vo.setStrDays1(formBean.getStrDays1());
			} else {
				vo.setStrDays1("0");
			}
			if (formBean.getStrDays2().length() > 0) {
				vo.setStrDays2(formBean.getStrDays2());
			} else {
				vo.setStrDays2("0");
			}
			if (formBean.getStrDays3().length() > 0) {
				vo.setStrDays3(formBean.getStrDays3());
			} else {
				vo.setStrDays3("0");
			}
			if (formBean.getStrDays4().length() > 0) {
				vo.setStrDays4(formBean.getStrDays4());
			} else {
				vo.setStrDays4("0");
			}
			if (formBean.getStrDays5().length() > 0) {
				vo.setStrDays5(formBean.getStrDays5());
			} else {
				vo.setStrDays5("0");
			}
			if (formBean.getStrDays6().length() > 0) {
				vo.setStrDays6(formBean.getStrDays6());
			} else {
				vo.setStrDays6("0");
			}

			//request.getSession().getAttribute("USER_LEVEL").toString();
			String strDBHeader ="abc";       // getHeadersFromDB(strHospitalCode, strDistrictStoreId);
			strReportHeader = "dfsdsdf ";//+HisLanguageProperties.getValue(request, "label.common.Consumption_Report") ;
			strReportHeader +="zxczx ";//+ HisLanguageProperties.getValue(request, "label.common.Store_Name")+" : " + formBean.getStrStoreName();
			formBean.setStrUserName("a");//(String) request.getSession().getAttribute("UserFullName"));

			//if (formBean.getStrIsDdwFlag().equals("1")) {
			
					strReportHeader +=" , ";//+// HisLanguageProperties.getValue(request, "label.common.Store_Type")+" : " + formBean.getStrStoreTypeNameList();
			//} 
			strReportHeader +="sdf"; //HisLanguageProperties.getValue(request, "label.commom.On_Date")+" : " + formBean.getStrDate();
			// Calling BO Method
			bo.getRportData(vo); // PKG_MMS_RPT.Rptm_consumption_dtl_new [Mode
									// =1 ]
									// Mms_Mst.get_daterange_consumption_rpt
									// [Mode =1 ]

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			response.setContentType("text/html;charset=UTF-8");
			StockConsumptionDateWiseRptHLP hlp = new StockConsumptionDateWiseRptHLP();
			String strIndentItemList = hlp.printZeroStockDrugList(vo, request);
			formBean.setStrIndentItemList(StockConsumptionDateWiseRptHLP.getPrintIndentDetails(vo, formBean, strReportHeader, strDBHeader,
					strIndentItemList, request));

			// formBean.setStrIndentItemList(strIndentItemList);
			formBean.setStrTableWidth(vo.getStrTableWidth());
			strCurrentDate = util.getASDate("dd-MMM-yyyy");
			formBean.setStrReqDate(strCurrentDate);
			

		} catch (Exception e) {
			e.printStackTrace();
			String strMsgText = e.getMessage();
			

		}
	}

	/**
	 * Show report.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void showReport(ConsumptionDetailRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();

		String reportFormat = "html";
		String strReportName = "";
		String reportPath = "";
		Map<String, Object> params = new HashMap<String, Object>();
		String Isbatchno="";
		String strCircleId = "0";
		String strDistrictId = "0";
		String strDistrictStoreId = "0";
		String strStoreTypeId = "0";
		String strStoreId = "";
		String strpoId="";
		String strItemBrandId = "";

	
		String strSubStoreName = formBean.getStrSubStoreName();
		String strItemType = formBean.getStrItemType() == null ? "0" : formBean.getStrItemType();// Item Type Id (e.g Tablets, Drops etc.)
		String strIsGroupWise = formBean.getStrIsGroupWise() == null ? "0" : formBean.getStrIsGroupWise();
		String strIsItemWise = formBean.getStrIsItemWise() == null ? "0" : formBean.getStrIsItemWise();
		System.err.println("strIsGroupWise"+strIsGroupWise);
		
		try {

			String strHospitalCode = formBean.getStrHospitalCode();
			String strStatusId = formBean.getStrStatusId();
			String strCatCode = formBean.getStrItemCatNo();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strGroupId = formBean.getStrGroupId() == null ? "0" : formBean.getStrGroupId();
			//String strCurrentDate = formBean.getStrCurrentDate();
			String strBatchNo = formBean.getStrBatchNo();

			strCircleId = "0";
			strDistrictId = "0";
			strDistrictStoreId = "0";
			strStoreTypeId = formBean.getStrStoreTypeId() == null ? "0" : formBean.getStrStoreTypeId();
			strStoreId = formBean.getStrStoreId() == null ? "0" : formBean.getStrStoreId();
			strItemBrandId = formBean.getStrItemBrandId() == null ? "0" : formBean.getStrItemBrandId();
			strpoId = formBean.getStrPoId() == null ? "0" : formBean.getStrPoId();
			strReportName = "Consolidated Report";
			reportFormat = formBean.getStrReportFormat();

			boolean footerVisible = true;

			if (formBean.getStrIsFooter().equals("1")) 
			{
				footerVisible = false;

			}

			if (formBean.getStrIsFooter() == null)
				formBean.setStrIsFooter("0");

			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;

			}
			params.put("report_id", "0");
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
			params.put("report_user_Remarks", strUserRemarks);
			params.put("username","0");
			params.put("report_Footer_Visible", footerVisible);
			params.put("report_user_Remarks", strUserRemarks);
			
			params.put("hospCode", strHospitalCode);
			params.put("catCode", strCatCode );
			params.put("frmdate", formBean.getStrFromDate() );
			params.put("todate", formBean.getStrToDate());
			
			params.put("pono", strpoId);
			params.put("itemid", strItemBrandId);
			params.put("suppid", "0");
			params.put("potypeid", "0");
			
			params.put("p_hstnum_store_id",strStoreId);
			params.put("p_district_id", "0");
			params.put("p_circle_id", "0");
			params.put("p_dwh_type_id", formBean.getStrPoType());
			
			
			
				reportPath = "/mms/reports/Consolidated_Challan_Report.rptdesign";
			
				
			
			ts.displayReport(request, response, reportPath, reportFormat,params,strHospitalCode);
			
		} catch (Exception e) {

			e.printStackTrace();

		}
	}
}
