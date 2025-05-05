package mms.reports.controller.data;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.SampleJavaMailCCAndBcc;
import mms.reports.bo.ReorderLevelBhuvRptBO;
import mms.reports.controller.fb.ReorderLevelBhuvRptFB;
import mms.reports.controller.hlp.ReorderLevelBhuvRptHLP;
import mms.reports.controller.hlp.StockOnHandRptHLP;
import mms.reports.vo.ReorderLevelBhuvRptVO;

public class ReorderLevelBhuvRptDATA 
{

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
	public static void getDistrictList(ReorderLevelBhuvRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{

		ReorderLevelBhuvRptBO bo = null;
		ReorderLevelBhuvRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ReorderLevelBhuvRptBO();
			voObj = new ReorderLevelBhuvRptVO();

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
			util = new HisUtil("MMS Reports", "projectionOrderRptDATA");
			/* util = new HisUtil("MMS Reports", "StockOnHandRptDATA"); */
			String strDistrictCombo = "";

			

			if (voObj.getStrDistrictWS() != null
					&& voObj.getStrDistrictWS().size() > 0) 
			{
				strDistrictCombo = util.getOptionValue(
						voObj.getStrDistrictWS(), "", "", false);
			}

			else 
			{
				strDistrictCombo = "<option value='0'>Select Value</option>";
			}

			

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strDistrictCombo);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.reports.ProjectionOrderRptDATA.getDistrictList --> "
					+ e.getMessage();
			/*
			 * strmsgText = "mms.reports.StockOnHandRptDATA.getDistrictList --> " +
			 * e.getMessage();
			 */
			HisException eObj = new HisException("mms",
					"ProjectionOrderRptDATA->getDistrictList()", strmsgText);
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
	public static void getStoreCombo(ReorderLevelBhuvRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReorderLevelBhuvRptBO bo = null;
		ReorderLevelBhuvRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ReorderLevelBhuvRptBO();
			voObj = new ReorderLevelBhuvRptVO();
			
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			
			
			bo.getStoreList(voObj);  // pkg_mms_rpt.rptm_hstt_store_mst [ Mode - 1 ] 
			
			voObj.setStrItemCatId("10");
			voObj.setStrStoreId("0");
			voObj.setStrGroupId("0");
			
			if (voObj.getStrMsgType().equals("1")) 
			{
				throw new Exception(voObj.getStrMsgString());
			}

			util = new HisUtil("MMS Reports", "projectionOrderRptDATA");
			/* util = new HisUtil("MMS Reports", "StockOnHandRptDATA") */;
			String strStoreVal = "";

			if (voObj.getStrStoreWs() != null
					&& voObj.getStrStoreWs().size() > 0) 
			{

				if (voObj.getStrStoreWs().next()) 
				{
					voObj.setStrStoreId(voObj.getStrStoreWs().getString(1));
				}
				voObj.getStrStoreWs().beforeFirst();

				strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "","", false);

			} else
				strStoreVal = "<option value='0'>Select Value</option>";

			
			String temp;
			formBean.setStrStoreValues(strStoreVal);
			/******************** F.Y Combo ********************/
			
			bo.getFYCombo(voObj);  //  PKG_MMS_VIEW2.proc_get_financial_year_combo [ Mode - 1]
			
			String strFYCombo = "";

			if (voObj.getStrFYCmbWS() != null && voObj.getStrFYCmbWS().size() > 0) 
			{
				strFYCombo = util.getOptionValue(voObj.getStrFYCmbWS(), "0","", false);

			} 
			else
			{	
				strFYCombo = "<option value='0'>Select Value</option>";
			}
			
			
			formBean.setStrFYCombo(strFYCombo);
			
			/******************** F.Y Combo ********************/
			
			bo.getItemCatList(voObj);
			
			if (voObj.getStrItemCatWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0", "",true);

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
		} catch (Exception e) {
			e.printStackTrace();
			
			strmsgText = "mms.reports.ProjectionOrderRptDATA.getStoreCombo --> "
					+ e.getMessage();
			/*
			 * strmsgText = "mms.reports.StockOnHandRptDATA.getStoreCombo --> " +
			 * e.getMessage();
			 */
			HisException eObj = new HisException("mms",
					"ProjectionOrderRptDATA->getStoreCombo()", strmsgText);
			/*
			 * HisException eObj = new HisException("mms",
			 * "StockOnHandRptDATA->getStoreCombo()", strmsgText);
			 */
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
	public static void getStoreTypeList(ReorderLevelBhuvRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReorderLevelBhuvRptBO bo =null;
		ReorderLevelBhuvRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		String strStoreTypeId="";
		try {

			bo = new ReorderLevelBhuvRptBO();
			voObj = new ReorderLevelBhuvRptVO();

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
			/* util = new HisUtil("MMS Reports", "StockOnHandRptDATA"); */
			util = new HisUtil("MMS Reports", "projectionOrderRptDATA");
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
			strmsgText = "mms.reports.ProjectionOrderRptDATA.getStoreTypeList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProjectionOrderRptDATA->getStoreTypeList()", strmsgText);
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
	public static void getSubStoreCombo(ReorderLevelBhuvRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReorderLevelBhuvRptBO bo = null;
		ReorderLevelBhuvRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ReorderLevelBhuvRptBO();
			voObj = new ReorderLevelBhuvRptVO();

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
			/* util = new HisUtil("MMS Reports", "StockOnHandRptDATA"); */
			util = new HisUtil("MMS Reports", "projectionOrderRptDATA");

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
			strmsgText = "mms.reports.ProjectionOrderRptDATA.getStoreCombo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProjectionOrderRptDATA->getStoreCombo()", strmsgText);
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
	public static void getItemCatList(ReorderLevelBhuvRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReorderLevelBhuvRptBO bo = null;
		ReorderLevelBhuvRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ReorderLevelBhuvRptBO();
			voObj = new ReorderLevelBhuvRptVO();

			String strStoreId = request.getParameter("storeId");

			if (strStoreId == null)
				strStoreId = "0";

			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			/* util = new HisUtil("MMS Reports", "StockOnHandRptDATA"); */
			util = new HisUtil("MMS Reports", "projectionOrderRptDATA");

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
			strmsgText = "mms.reports.ProjectionOrderRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProjectionOrderRptDATA->getItemCatList()", strmsgText);
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
	public static void getGroupList(ReorderLevelBhuvRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReorderLevelBhuvRptBO bo = null;
		ReorderLevelBhuvRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new ReorderLevelBhuvRptBO();
			voObj = new ReorderLevelBhuvRptVO();

			String strItemCatId = request.getParameter("itemcat");

			if (strItemCatId == null)
				strItemCatId = "0";

			voObj.setStrItemCatId(strItemCatId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			
			bo.getGroupList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Reports", "projectionOrderRptDATA");
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
			strmsgText = "mms.reports.ProjectionOrderRptDATA.getGroupList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProjectionOrderRptDATA->getGroupList()", strmsgText);
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
	public static void getDrugList(ReorderLevelBhuvRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReorderLevelBhuvRptBO bo = null;
		ReorderLevelBhuvRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		String hosCode = "";
		String storeId = "";
		String itemCatNO = "";
		String groupId = "";
		String statusId = "";
		String strItemCmb = "", itemType = "", districtStoreId = "";

		try {
			util = new HisUtil("MMS Reports", "projectionOrderRptDATA");
			bo = new ReorderLevelBhuvRptBO();
			voObj = new ReorderLevelBhuvRptVO();

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
			strmsgText = "mms.reports.ProjectionOrderRptDATA.getDrugList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProjectionOrderRptDATA->getDrugList()", strmsgText);
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
	
	public static void getDrugList1(ReorderLevelBhuvRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReorderLevelBhuvRptBO bo = null;
		ReorderLevelBhuvRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		String hosCode = "";
		String storeId = "";
		String itemCatNO = "";
		String groupId = "";
		String statusId = "";
		String strItemCmb = "", itemType = "", districtStoreId = "";

		try {
			util = new HisUtil("MMS Reports", "projectionOrderRptDATA");
			bo = new ReorderLevelBhuvRptBO();
			voObj = new ReorderLevelBhuvRptVO();

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
			strmsgText = "mms.reports.ProjectionOrderRptDATA.getDrugList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProjectionOrderRptDATA->getDrugList()", strmsgText);
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
	public static void getProgrammeCombo(ReorderLevelBhuvRptFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReorderLevelBhuvRptBO bo = null;
		ReorderLevelBhuvRptVO voObj = null;
		String strmsgText = null;
		HisUtil util = null;

		String strProgCmb = "", districtStoreId = "";

		try {
			util = new HisUtil("MMS Reports", "projectionOrderRptDATA");
			bo = new ReorderLevelBhuvRptBO();
			voObj = new ReorderLevelBhuvRptVO();

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
			strmsgText = "mms.reports.ProjectionOrderRptDATA.getDrugList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProjectionOrderRptDATA->getDrugList()", strmsgText);
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
		
	
	public static void showRpt(ReorderLevelBhuvRptFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException 
	{
			
		String strReportName = "";	
		String strCircleId = "";
		String strDistrictId = "";
		String strDistrictStoreId = "";
		
		ReorderLevelBhuvRptBO bo = null;
		ReorderLevelBhuvRptVO vo = null;		
		HisUtil util = null;	
		try 
		{
			util = new HisUtil("MMS Reports", "StockOnHandRptDATA");
			bo = new ReorderLevelBhuvRptBO();
			vo = new ReorderLevelBhuvRptVO();
			
			String seatid = request.getSession().getAttribute("SEATID").toString();
			
			String strDrugTypeName 	= formBean.getStrDrugTypeName();
			String strGroupName 	= formBean.getStrGroupName();
			String strStoreName 	= formBean.getStrStoreName();				
			String strItemType 		= formBean.getStrItemType() == null ? "0" : formBean.getStrItemType(); // Item Type Id (e.g Tablets, Drops etc.)
			String strIsGroupWise   = formBean.getStrIsGroupWise() == null ? "0" : formBean.getStrIsGroupWise();
			String strIsItemWise    = formBean.getStrIsItemWise() == null ? "0" : formBean.getStrIsItemWise();			
			String Isbatchno        = formBean.getStrBatchNo() ==null? "1" : formBean.getStrBatchNo();		
			String strHospitalCode  = formBean.getStrHospitalCode();			
			String strStatusId      = formBean.getStrStatusId();
			String strCatCode       = formBean.getStrItemCatNo();			
			String strGroupId       = formBean.getStrGroupId() == null ? "0" : formBean.getStrGroupId();
			String strItemBrandId   = formBean.getStrItemBrandId() == null ? "0" : formBean.getStrItemBrandId();
			String strStoreTypeId   = formBean.getStrStoreTypeId() == null ? "0" : formBean.getStrStoreTypeId();
			String strStoreId       = formBean.getStrStoreId() == null ? "0" : formBean.getStrStoreId();
			String strFYId          = formBean.getStrFYId() == null ? "2024-2025" : formBean.getStrFYId();
					
			strCircleId = "0";
			strDistrictId = "0";
			strDistrictStoreId = "0";
			
			
			System.out.println("------strStoreId-----"+strStoreId);
		
			System.out.println("------------ StockOnHandRptDATA_NEW . showReport_NEW -----------------");
			System.out.println("strGroupName---------"+strGroupName);			
			System.out.println("strDrugTypeName---------"+strDrugTypeName);	
			System.out.println("strStoreName---------"+strStoreName);
			System.out.println("strItemType---------"+strItemType);
			System.out.println("strIsItemWise---------"+strIsItemWise);
			System.out.println("strIsGroupWise---[ 1- Means Batch Wise 0 - Without Batch ]------"+strIsGroupWise);
			System.out.println("strItemBrandId---------"+strItemBrandId);
			System.out.println("strStoreId---------"+strStoreId);
			System.out.println("strStoreTypeId-----"+strStoreTypeId);
			System.out.println("strHospitalCode----"+strHospitalCode);
			System.out.println("strStatusId--------"+strStatusId);
			System.out.println("strCatCode---------"+strCatCode);
			System.out.println("strGroupId---------"+strGroupId);
			System.out.println("Isbatchno----------"+Isbatchno);
			System.out.println("-----------------------------");
			
			strReportName = "Order Projection Report";			
		
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);			
			vo.setStrItemCatNo(strCatCode);		
			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrStoreName(strStoreName);				
			vo.setStrStatusId(strStatusId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrCatCode(strCatCode);
			vo.setStrIsItemWise(strIsItemWise);
			vo.setStrIsGroupWise(strIsGroupWise);
			vo.setStrGroupId(strGroupId);
			vo.setStrItemType(strItemType);
			vo.setStrGroupName(strGroupName);
			vo.setStrDrugTypeName(strDrugTypeName);
			vo.setStrSeatId(seatid);
			vo.setStrFYId(strFYId);
			
			formBean.setStrUserName("User_Name");

								
		    System.out.println("<-----With Batch-- PKG_MMS_VIEW2.proc_rptm_re_order_report [ Mode - 1] -->");
			
			//to print Date & time 
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));									

			bo.getReport(vo);
			/*
                1.ITEM_NAME
			    2.STORE_NAME
			    3.LAST_30DAYS_CONSUMPTION            
			    4.REORDERLEVEL  
			  */
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}					
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));									
			response.setContentType("text/html;charset=UTF-8");										
			String strIndentItemList = ReorderLevelBhuvRptHLP.prinRpt(vo, strReportName , request,formBean);				
			
			
			 StringBuffer sb = new StringBuffer("");
			
			 sb.append("<table  width='100%' align='center' cellspacing='1px' cellpadding='1px' border='0'>");
			 sb.append("<tr> "
				+ " <td colspan='12'><br>"
				+ "<div id='printImg' align='right'>"
				+ "<img style='cursor: pointer;'  text-align=right  title='Print Page' src='../../hisglobal/images/printer_symbol.gif' onClick='printDataOne();' />"
				+ "<img style='cursor: pointer;'  text-align=right  title='Cancel Process' src='../../hisglobal/images/stop.png' onClick='cancelFunc();' /></div>"
				+ "</td>");
				sb.append("</tr>");

				sb.append("<tr> "
				+ " <td colspan='12'><div align='center'><img src='/INVMGM/hisglobal/images/aiims_inv_header.png'></div></td>"
				+ "</tr></table>");		

				
			formBean.setStrViewItemDtls(sb.toString()+""+strIndentItemList);
			
			formBean.setStrTableWidth(vo.getStrTableWidth());	
			
						
			  // Message info       
	        String[] to = {"director@aiimsbhubaneswar.edu.in","ms@aiimsbhubaneswar.edu.in","cenpharm@aiimsbhubaneswar.edu.in","spo@aiimsbhubaneswar.edu.in","fic_sp@aiimsbhubaneswar.edu.in","pathol_amit@aiimsbhubaneswar.edu.in","dda@aiimsbhubaneswar.edu.in","plastic_sanjay@aiimsbhubaneswar.edu.in","biochem_debapriya@aiimsbhubaneswar.edu.in","chairmanit@aiimsbhubaneswar.edu.in"}; // list of recipient email addresses
			
			//String[] to= {"amit_kumar@cdac.in","mitp2561@gmail.com"}; // list of recipient email addresses
	        String[] cc={ "amit_kumar@cdac.in" };
	        String[] bcc={ "aiimsbbsrpharmacyalert@gmail.com" };
	        String[] subject = {"Dear Sir , Please find the attached List of Items Stock which have Stock  60% of the Maximum Stock Level."};
	        String[] body = {strIndentItemList};	

	        //SampleJavaMailCCAndBcc.sendFromGMail(to, cc, bcc, subject, body);
			
		} catch (Exception e) {
			e.printStackTrace();
			String strMsgText = e.getMessage();

		}
	}
}
