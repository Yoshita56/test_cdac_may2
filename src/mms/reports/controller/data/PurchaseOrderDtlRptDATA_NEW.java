/**********************************************************
 Project:	   DWH_ANDHRA	
 File:         PurchaseOrderDtlRptDATA.java
 Created:      Jul 8, 2014
 Last Changed: Jul 8, 2014
 Author:       manish

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.PurchaseOrderDtlRptBO_NEW;
import mms.reports.controller.fb.PurchaseOrderDtlRptFB_NEW;
import mms.reports.vo.PurchaseOrderDtlRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseOrderDtlRptDATA.
 */
public class PurchaseOrderDtlRptDATA_NEW {

	/**
	 * Inits the details.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void initDetails(PurchaseOrderDtlRptFB_NEW formBean,
			HttpServletRequest request) {

		PurchaseOrderDtlRptBO_NEW bo = null;
		PurchaseOrderDtlRptVO_NEW voObj = null;
		String strmsgText = null, strCircleCombo = "", strDistrictCombo = "", strStoreVal = "",strFinYearCmb="",strProgCmb="",strCatVal="";
		String strDistrictStoreVal = "";
		String supplier=" ";
		String strUserLevel;
		String strCurrentDate = "";
		HisUtil util = null;
		try {

			bo = new PurchaseOrderDtlRptBO_NEW();
			voObj = new PurchaseOrderDtlRptVO_NEW();
			util = new HisUtil("MMS Reports", "PurchaseOrderDtlRptDATA");
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());
			voObj.setStrSeatId(formBean.getStrSeatId());
			voObj.setStrMode("12");
			bo.getStoreList(voObj);
			
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
			
			if (voObj.getStrStoreWs() != null && voObj.getStrStoreWs().size() != 0) {
				strStoreVal = util.getOptionValue(voObj.getStrStoreWs(), "0", "0^All", true);				
			} else {
				strStoreVal = "<option value='0'>All</option>";				
			}
			formBean.setStrStoreValues(strStoreVal);
			formBean.setStrDistrictStoreValues(strStoreVal);
			bo.getInitializedValues(voObj);
			
			if(voObj.getFinancialYearWs() != null && voObj.getFinancialYearWs().size() > 0)
			{
				strFinYearCmb = util.getOptionValue(voObj.getFinancialYearWs(), "0", "0^Select Value", false);
			}else
			{
				strFinYearCmb = "<option value='0'>Select Value</option>";
			} 
			
			
			
		

			// For setting the financial year
			strCurrentDate = util.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);
			
			formBean.setStrFinYearCombo(strFinYearCmb);
			

			//bo.getSupplierList(voObj);

			/*if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrSupplierWs().size() != 0) {

				

			} else {

				temp = "<option value='0'>All</option>";
			}
			
			bo.getItemCatList(voObj);
			
			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}
			
			if (voObj.getStrItemCatWs() != null && voObj.getStrItemCatWs().size() != 0) {
				strCatVal = util.getOptionValue(voObj.getStrItemCatWs(), "0", "0^All", true);				
			} else {
				strCatVal = "<option value='-1'>Select Value</option>";				
			}

			//formBean.setStrCircleCombo(strCircleCombo);
			//formBean.setStrDistrictCombo(strDistrictCombo);
			//formBean.setStrStoreValues(strStoreVal);
			//formBean.setStrSupplierCmb(temp);
			
			//formBean.setStrCatVal(strCatVal);*/

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PurchaseOrderDtlRptDATA.getSupplierList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseOrderDtlRptDATA->getSupplierList()", strmsgText);
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
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the district list
	 */
	
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
	public static void getStoreCombo(PurchaseOrderDtlRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PurchaseOrderDtlRptBO_NEW bo = null;
		PurchaseOrderDtlRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PurchaseOrderDtlRptBO_NEW();
			voObj = new PurchaseOrderDtlRptVO_NEW();

			String strUserLevel = request.getSession()
					.getAttribute("USER_LEVEL").toString();
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
			util = new HisUtil("MMS Reports", "PurchaseOrderDtlRptDATA");
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
			strmsgText = "mms.reports.PurchaseOrderDtlRptDATA.getStoreCombo --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseOrderDtlRptDATA->getStoreCombo()", strmsgText);
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
	public static void getItemCatList(PurchaseOrderDtlRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PurchaseOrderDtlRptBO_NEW bo = null;
		PurchaseOrderDtlRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PurchaseOrderDtlRptBO_NEW();
			voObj = new PurchaseOrderDtlRptVO_NEW();

			String strStoreId = request.getParameter("storeId");
			voObj.setStrStoreId(strStoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getItemCatList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrItemCatWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrItemCatWs(), "0",
						"0^All", true);

			} else {

				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PurchaseOrderDtlRptDATA.getItemCatList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseOrderDtlRptDATA->getItemCatList()", strmsgText);
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
	 * Gets the PO type list.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the PO type list
	 */
	public static void getPOTypeList(PurchaseOrderDtlRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		PurchaseOrderDtlRptBO_NEW bo = null;
		PurchaseOrderDtlRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PurchaseOrderDtlRptBO_NEW();
			voObj = new PurchaseOrderDtlRptVO_NEW();

			String strStoreId = request.getParameter("storeId");
			String strItemCatNo = request.getParameter("itemcat");

			if (strStoreId == null)
				strStoreId = "0";
			if (strItemCatNo == null)
				strItemCatNo = "0";

			voObj.setStrStoreId(strStoreId);
			voObj.setStrItemCatNo(strItemCatNo);
			voObj.setStrReqFor("2");
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getPOTypeList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrPOTypeWs().size() != 0) {

				temp = util.getOptionValue(voObj.getStrPOTypeWs(), "0",
						"0^All", true);

			} else {

				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "mms.transactions.PurchaseOrderDtlRptDATA.getPOTypeList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseOrderDtlRptDATA->getPOTypeList()", strmsgText);
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
	 * Gets the supplier list.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the supplier list
	 */
	public static void getSupplierList(PurchaseOrderDtlRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{

		PurchaseOrderDtlRptBO_NEW bo = null;
		PurchaseOrderDtlRptVO_NEW voObj = null;
		String strmsgText = null;
		HisUtil util = null;
		try {

			bo = new PurchaseOrderDtlRptBO_NEW();
			voObj = new PurchaseOrderDtlRptVO_NEW();

			String strItemCatNo = request.getParameter("catId");
			String strstoreId=request.getParameter("storeId");
			if (strItemCatNo == null)
				strItemCatNo = "0";

			voObj.setStrItemCatNo(strItemCatNo);
			voObj.setStrStoreId(strstoreId);
			voObj.setStrHospitalCode(formBean.getStrHospitalCode());

			bo.getSupplierList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());

			}
			util = new HisUtil("MMS Transactions", "PurchaseOrderDtlRptDATA");
			String temp = "<option value='0'>All</option>";

			if (voObj.getStrSupplierWs().size() != 0) 
			{
				temp = util.getOptionValue(voObj.getStrSupplierWs(), "0","0^All", true);

			} 
			else
			{
				temp = "<option value='0'>All</option>";
			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(temp);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "mms.transactions.PurchaseOrderDtlRptDATA.getSupplierList --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseOrderDtlRptDATA->getSupplierList()", strmsgText);
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
	 * Show report.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void showReport(PurchaseOrderDtlRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();

		String reportFormat = "html";
		String strCircleId = "";
		String strDistrictId = "",stritemcat="";
		String strDistrictStoreId = "";
		String strFromDate="",strToDate="";
		String strStoreName = formBean.getStrStoreName();
		String strProgName=formBean.getStrProgName();
		String strClassificationName=formBean.getStrClassificationName();
		
		Map<String, Object> params = new HashMap<String, Object>();
		try {

			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			if(formBean.getStrFinYearId().equals("0"))
			{
				strFromDate = formBean.getStrFromDate();
				strToDate = formBean.getStrToDate();
			}
			else{
				strFromDate="01-Apr-"+formBean.getStrFinYearId().split("-")[0];			
				strToDate="31-Mar-"+formBean.getStrFinYearId().split("-")[1];
			}
			
			String strWhetherItemShown = formBean.getStrWhetherItemShown();
			String strUserRemarks = formBean.getStrUserRemarks();
			reportFormat = formBean.getStrReportFormat();
			String strSupplierId = formBean.getStrSupplierId();
			if (strSupplierId == null) 
			{
				strSupplierId = "0";
			}
			String strPoStatus = formBean.getStrPoStatus();
			String strPoType = formBean.getStrPoType();
			String strSuppPOStatus= formBean.getStrSuppPOStatus();
			String strSuppPOStatusName= formBean.getStrSuppPOStatusName();

			String reportPath = "";

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
			boolean footerVisible = true;

			if (formBean.getStrIsFooter().equals("1")) 
			{
				footerVisible = false;
			}
			String strReportName = "Purchase Order Register ";
			if (strWhetherItemShown == null || strWhetherItemShown.equals(""))
				strWhetherItemShown = "0";

			if (strWhetherItemShown.equals("1")) {
				reportPath = "/mms/reports/purchase_order_dtl.rptdesign"; // Item Shown
			} else {
				reportPath = "/mms/reports/purchase_order_dtl1.rptdesign"; // Item Not Shown
			}

			strCircleId = formBean.getStrCircleId() == null ? "0" : formBean.getStrCircleId();
			strDistrictId = formBean.getStrDistrictId() == null ? "0": formBean.getStrDistrictId();
			strDistrictStoreId = formBean.getStrDistrictStoreId() == null ? "0": formBean.getStrDistrictStoreId().split("\\^")[0];
			stritemcat=formBean.getStrItemCatNo()  == null ? "0": formBean.getStrItemCatNo();

			params.put("circleId", stritemcat);/*programe id as a item cat no  */ 
			params.put("districtId", strDistrictId);
			params.put("storeId", strDistrictStoreId);
			params.put("strProgId", stritemcat);

			params.put("catCode", formBean.getStrItemCatNo());
			params.put("from_Date", sdf.format(sdf.parse(strFromDate)));
			params.put("to_Date", sdf.format(sdf.parse(strToDate)));
			params.put("strSuppPOStatus", strSuppPOStatus);
			params.put("strSuppPOStatusName", strSuppPOStatusName);
			params.put("itemcatname", formBean.getStrCircleName());/*circle name as a item cat name*/
			if (formBean.getStrIsFooter() == null)
				formBean.setStrIsFooter("0");

			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;

			}

			if (strDistrictStoreId.equals("0")) {
				params.put("storeName", "All");
			} else {							
					params.put("storeName", strStoreName);

			}
			
			
			if (strPoStatus.equals("0")) {
				params.put("poStatusName", "All");
			} else if(strPoStatus.equals("1")) {							
					params.put("poStatusName", "Active");

			} 
			else{
				params.put("poStatusName", "Cancelled/Rejected");
			}
			
			if(strPoType.equals("1"))
			{
				strPoType="1";
			}
			else if(strPoType.equals("2"))
			{
				strPoType="2";
			}
			else
			{
				strPoType="3";
			}

			params.put("report_id", strReportId);
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
			params.put("report_user_Remarks", strUserRemarks);
			params.put("username",request.getSession().getAttribute("UserFullName"));
			params.put("hospCode", strHospitalCode);

			params.put("supp_id", strSupplierId);
			params.put("po_type", strPoType);
			params.put("po_status", strPoStatus);
			params.put("progName", strProgName);
		

			ts.displayReport(request, response, reportPath, reportFormat,params, strHospitalCode);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}