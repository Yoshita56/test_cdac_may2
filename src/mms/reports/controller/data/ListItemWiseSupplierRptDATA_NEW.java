/**
 * 
 */
package mms.reports.controller.data;

import hisglobal.ReportUtil;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.bo.ListItemWiseSupplierRptBO_NEW;
import mms.reports.controller.fb.ListItemWiseSupplierRptFB_NEW;
import mms.reports.vo.ListItemWiseSupplierRptVO_NEW;

// TODO: Auto-generated Javadoc
/**
 * The Class ListItemWiseSupplierRptDATA.
 * 
 * @author user
 */
public class ListItemWiseSupplierRptDATA_NEW {

	/**
	 * This function is used to set initial parameters required to display on
	 * main page .
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void initialAdd(ListItemWiseSupplierRptFB_NEW formBean,
			HttpServletRequest request) {
		ListItemWiseSupplierRptVO_NEW vo = null;
		ListItemWiseSupplierRptBO_NEW bo = null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatCmb, strSupplierVal;
		String strGrpCmb, strItemCmb, strDrugCode, strRateContractTypeCombo;
		String strUserLevel="";

		try {
			vo = new ListItemWiseSupplierRptVO_NEW();
			bo = new ListItemWiseSupplierRptBO_NEW();

			hisutil = new HisUtil("mms", "ListItemWiseSupplierRptDATA");
			
			if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
				hosCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
				seatid=request.getSession().getAttribute("SEATID").toString();
				//strUserLevel=request.getSession().getAttribute("USER_LEVEL").toString();
			}
			
			else
			{
				hosCode="33101";
				seatid="10047";
				strUserLevel="1";
			}

			

			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryNo("10");
			if (strUserLevel.equals("1") || strUserLevel.equals("2")
					|| strUserLevel.equals("3")) {
				vo.setStrMode("12");
			} else
				vo.setStrMode("1");
			
			// Calling BO Method
			bo.initialAdd(vo);

			if (vo.getItemCategoryWS().next()) {
				vo.setStrItemCategoryNo(vo.getItemCategoryWS().getString(1));
				//vo.setStrItemCategoryNo("10");
				//System.out.println("item cat no"+vo.getItemCategoryWS().getString(1));
			}
			vo.getItemCategoryWS().beforeFirst();

			// Calling BO Method
			bo.getGroupName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getItemCategoryWS() != null
					&& vo.getItemCategoryWS().size() > 0) {
				itemCatCmb = hisutil.getOptionValue(vo.getItemCategoryWS(), "",
						"", true);
			} else {
				itemCatCmb = "<option value='0'>Select Value</option>";
			}

			if (strUserLevel.equals("1") || strUserLevel.equals("2")
					|| strUserLevel.equals("3")) {
				strSupplierVal = hisutil.getOptionValue(
						vo.getStrManufactureComboWS(), "0", "0^All", false);
			} else {
				strSupplierVal = hisutil.getOptionValue(
						vo.getStrManufactureComboWS(), "0", "0^All",
						false);
			}

			while (vo.getGroupIdWS().next()) {
				vo.setStrGroupId(vo.getGroupIdWS().getString(1));
			}
			vo.getGroupIdWS().beforeFirst();
			vo.setStrGroupId("0");
			vo.setStrSubGroupId("0");
				
			// Calling BO Method
			//bo.getDrugCode(vo);
			bo.getItemName(vo);

			if (vo.getGroupIdWS() != null && vo.getGroupIdWS().size() > 0) {
				strGrpCmb = hisutil.getOptionValue(vo.getGroupIdWS(), "0",
						"0^All", true);
			} else {
				strGrpCmb = "<option value='0'>All</option>";
			}
			
			if (vo.getItemIdWS() != null && vo.getItemIdWS().size() > 0) {
				strItemCmb = hisutil.getOptionValue(vo.getItemIdWS(), "",
						"0^All", true);
			} else {
				strItemCmb = "<option value='0'>All</option>";
			}

			/*if (vo.getDrugCodeWS() != null && vo.getDrugCodeWS().size() > 0) {
				strDrugCode = hisutil.getOptionValue(vo.getDrugCodeWS(), "",
						"0^All", true);
			} else {
				strDrugCode = "<option value='0'>All</option>";
			}
			*/
			if (vo.getStrContractTypeWS() != null
					&& vo.getStrContractTypeWS().size() > 0) {
				strRateContractTypeCombo = hisutil.getOptionValue(
						vo.getStrContractTypeWS(), "", "", true);
			} else {
				strRateContractTypeCombo = "<option value='0'>Select value</option>";
			}
			 
			formBean.setStrRateContractTypeCombo(strRateContractTypeCombo);
			/*formBean.setStrCodeCombo(strDrugCode);*/
			formBean.setStrItemCombo(strItemCmb);
			formBean.setStrGroupCombo(strGrpCmb);
			formBean.setStrManufactureCombo(strSupplierVal);
			formBean.setStrItemCategoryCombo(itemCatCmb);

		} catch (Exception e) {

			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ListItemWiseSupplierRptDATA->initialAdd()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (formBean != null)
				formBean = null;
			hisutil = null;
		}
	}

	/**
	 * This function is used to display Group Name on the basis of ItemCategory
	 * Name: .
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void groupName(ListItemWiseSupplierRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {
		ListItemWiseSupplierRptVO_NEW vo = null;
		ListItemWiseSupplierRptBO_NEW bo = null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String  strSupplierVal;
		String strGrpCmb = "";
		String strUserLevel="";

		try {
			hisutil = new HisUtil("MMS", "ListItemWiseSupplierRptDATA");
			vo = new ListItemWiseSupplierRptVO_NEW();
			bo = new ListItemWiseSupplierRptBO_NEW();

			if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
				hosCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
				seatid=request.getSession().getAttribute("SEATID").toString();
				
			}
			
			else
			{
				hosCode="33101";
				seatid="10007";
				
			}

			itemCatNO = (String) request.getParameter("itemCatNo");

			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrItemCategoryNo(itemCatNO);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			//System.out.println("request.getParameter(itemCatNo)"+request.getParameter("itemCatNo"));
			vo.setStrItemCategoryNo(request.getParameter("itemCatNo"));
			
			bo.getGroupName(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getGroupIdWS() != null && vo.getGroupIdWS().size() > 0) {
				strGrpCmb = hisutil.getOptionValue(vo.getGroupIdWS(), "",
						"0^All", true);
			} else {
				strGrpCmb = "<option value='0'>All</option>";
			}
			bo.initialAdd1(vo);
			if (strUserLevel.equals("1") || strUserLevel.equals("2")
					|| strUserLevel.equals("3")) {
				strSupplierVal = hisutil.getOptionValue(
						vo.getStrManufactureComboWS(), "0", "0^All", false);
			} else {
				strSupplierVal = hisutil.getOptionValue(vo.getStrManufactureComboWS(), "0", "0^All",false);
			}
			//System.out.println("strSupplierVal"+strSupplierVal);
		
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strGrpCmb+"^"+strSupplierVal);

			} catch (Exception e) {
				e.printStackTrace();
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ListItemWiseSupplierRptDATA->groupName()", strmsgText);
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
			if (vo != null)
				vo = null;
			if (formBean != null)
				formBean = null;
			hisutil = null;
		}
	}

	/**
	 * This function is used to display SubGroup Name on the basis of Group
	 * Name: .
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void subGroupName(ListItemWiseSupplierRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {
		ListItemWiseSupplierRptVO_NEW vo = null;
		ListItemWiseSupplierRptBO_NEW bo = null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String groupId = "";
		String strSubGrpCmb = "";
		String strItemCmb = "";
		String itemCateg = "";
		String strDrugCode = "";

		try {
			hisutil = new HisUtil("MMS", "ListItemWiseSupplierRptDATA");
			vo = new ListItemWiseSupplierRptVO_NEW();
			bo = new ListItemWiseSupplierRptBO_NEW();

			if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
				hosCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
				seatid=request.getSession().getAttribute("SEATID").toString();
			}			
			else
			{
				hosCode="33101";
				seatid="10047";
			}

			groupId = (String) request.getParameter("groupId");
			itemCateg = request.getParameter("itemCateg");
			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrGroupId(groupId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrItemCategoryNo(itemCateg);
			/********** Calling BO **********/
			bo.getSubGroupName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getSubGroupIdWS() != null && vo.getSubGroupIdWS().size() > 0) {
				strSubGrpCmb = hisutil.getOptionValue(vo.getSubGroupIdWS(), "",
						"0^All", true);
			} else {
				strSubGrpCmb = "<option value='0'>All</option>";
			}
			/********** Calling BO **********/
			//bo.getDrugCode(vo);
			/********** Calling BO **********/
			bo.getItemName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getItemIdWS() != null && vo.getItemIdWS().size() > 0) {
				strItemCmb = hisutil.getOptionValue(vo.getItemIdWS(), "",
						"0^All", true);
			} else {
				strItemCmb = "<option value='0'>All</option>";
			}

			/*if (vo.getDrugCodeWS() != null && vo.getDrugCodeWS().size() > 0) {
				strDrugCode = hisutil.getOptionValue(vo.getDrugCodeWS(), "",
						"0^All", true);
			} else {
				strDrugCode = "<option value='0'>All</option>";
			}*/

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						strSubGrpCmb + "@" + strItemCmb + "@" + strDrugCode);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ListItemWiseSupplierRptDATA->subGroupName()", strmsgText);
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
			if (vo != null)
				vo = null;
			if (formBean != null)
				formBean = null;
			hisutil = null;
		}
	}

	/**
	 * This function is used to display GenItem Name on the basis of
	 * StoreId,ItemCtNo,GrpId,SubGrpId: .
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void itemName(ListItemWiseSupplierRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {
		ListItemWiseSupplierRptVO_NEW vo = null;
		ListItemWiseSupplierRptBO_NEW bo = null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String groupId = "";
		String subGrpId = "";
		String strItemCmb = "";

		try {
			hisutil = new HisUtil("MMS", "ListItemWiseSupplierRptDATA");
			vo = new ListItemWiseSupplierRptVO_NEW();
			bo = new ListItemWiseSupplierRptBO_NEW();

			if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
				hosCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
				seatid=request.getSession().getAttribute("SEATID").toString();
			}
			
			else
			{
				hosCode="33101";
				seatid="10047";
			}

			//System.out.println("itemcatno"+request.getParameter("itemCatNo"));
			//System.out.println("froupid"+request.getParameter("groupId"));
			//System.out.println("subgrouid"+request.getParameter("subgrpId"));
			itemCatNO = (String) request.getParameter("itemCatNo");
			groupId = (String) request.getParameter("groupId");
			subGrpId = (String) request.getParameter("subgrpid");

			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrItemCategoryNo(itemCatNO);
			formBean.setStrGroupId(groupId);
			formBean.setStrSubGroupId(subGrpId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());

			bo.getItemName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getItemIdWS() != null && vo.getItemIdWS().size() > 0) {
				strItemCmb = hisutil.getOptionValue(vo.getItemIdWS(), "",
						"0^All", true);
			} else {
				strItemCmb = "<option value='0'>All</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemCmb);

			} catch (Exception e) {

			}

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ListItemWiseSupplierRptDATA->genItemName()", strmsgText);
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
			if (vo != null)
				vo = null;
			if (formBean != null)
				formBean = null;
			hisutil = null;
		}
	}

	/**
	 * This function is used to display GenItem Name on the basis of
	 * StoreId,ItemCtNo,GrpId,SubGrpId: .
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void itemCode(ListItemWiseSupplierRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {
		ListItemWiseSupplierRptVO_NEW vo = null;
		ListItemWiseSupplierRptBO_NEW bo = null;
		HisUtil hisutil = null;
		String hosCode = "";
		String seatid = "";
		String itemCatNO = "";
		String groupId = "";
		String subGrpId = "";
		String strItemCmb = "";

		try {
			hisutil = new HisUtil("MMS", "ListItemWiseSupplierRptDATA");
			vo = new ListItemWiseSupplierRptVO_NEW();
			bo = new ListItemWiseSupplierRptBO_NEW();

			if(request.getSession().getAttribute("HOSPITAL_CODE")!=null ){
				hosCode=request.getSession().getAttribute("HOSPITAL_CODE").toString();
				seatid=request.getSession().getAttribute("SEATID").toString();
				
			}
			
			else
			{
				hosCode="998";
				seatid="10007";
			
			}


			itemCatNO = (String) request.getParameter("itemCatNo");
			groupId = (String) request.getParameter("groupId");
			subGrpId = (String) request.getParameter("subgrpid");

			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrItemCategoryNo(itemCatNO);
			formBean.setStrGroupId(groupId);
			formBean.setStrSubGroupId(subGrpId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());

			// Calling BO method
			bo.getDrugCode(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getDrugCodeWS() != null && vo.getDrugCodeWS().size() > 0) {
				strItemCmb = hisutil.getOptionValue(vo.getDrugCodeWS(), "",
						"0^All", true);
			} else {
				strItemCmb = "<option value='0'>All</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemCmb);

			} catch (Exception e) {

			}

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ListItemWiseSupplierRptDATA->itemCode()", strmsgText);
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
			if (vo != null)
				vo = null;
			if (formBean != null)
				formBean = null;
			hisutil = null;
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
	public static void showReport(ListItemWiseSupplierRptFB_NEW formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReportUtil ts = new ReportUtil();

		String reportFormat = "html";
		String reportPath = "";
		String strReportName = "";

		Map<String, Object> params = new HashMap<String, Object>();
		try {

			String strHospitalCode = formBean.getStrHospitalCode();
			String strReportId = formBean.getStrReportId();
			/*String strCatCode = formBean.getStrItemCategoryNo();*/
			String strCatCode = formBean.getStrItemCategoryNo();
			String strUserRemarks = formBean.getStrUserRemarks();
			String strUserFullName=formBean.getStrFullName();
			
			String strItemId = (formBean.getStrItemId() == null || formBean.getStrItemId().equals("")) ? "0" : formBean.getStrItemId();
			String strSuppId = (formBean.getStrSupplierId() == null || 
					formBean.getStrSupplierId().equals("")) ? "0" : formBean.getStrSupplierId();
			String strExpiryDays = (formBean.getStrFrmExpiryDays() == null || formBean
					.getStrFrmExpiryDays().equals("")) ? "0" : formBean
					.getStrFrmExpiryDays();
			String strRateContractTypeId = (formBean.getStrRateContractTypeId() == null || formBean
					.getStrRateContractTypeId().equals("")) ? "1" : formBean.getStrRateContractTypeId();
			
			String strGroupId = (formBean.getStrGroupId() == null || formBean
					.getStrGroupId().equals("")) ? "1" : formBean.getStrGroupId();
			
			reportFormat = formBean.getStrReportFormat();

			boolean footerVisible = true;

			if (formBean.getStrIsFooter().equals("1")) {
				footerVisible = false;

			}

			if (formBean.getStrActiveOrNearExpiry().equals("1")) {
				strReportName = "Active Rate Contract Details";
				reportPath = "/mms/reports/dwh_listItemWiseSupplier2_rpt_NEW.rptdesign";
			} else {
				strReportName = "Rate Contract Details <br> Expiry After "
						+ strExpiryDays + " Days";
				reportPath = "/mms/reports/dwh_listItemWiseSupplier3_rpt_NEW.rptdesign";
			}
			System.out.println("reportPath"+reportPath);
			//System.out.println("strReportName"+strReportName);
			//System.out.println("strUserFullName"+strUserFullName);
			//System.out.println("strHospitalCode"+strHospitalCode);
			//System.out.println("strCatCode"+strCatCode);
			//System.out.println("strItemId"+strItemId);
			//System.out.println("strSuppId"+strSuppId);
			//System.out.println("strRateContractTypeId"+strRateContractTypeId);
			//System.out.println("strExpiryDays"+strExpiryDays);
			//System.out.println("strGroupId"+strGroupId);
			params.put("report_id", strReportId);
			params.put("report_Name", strReportName);
			params.put("report_Footer_Visible", footerVisible);
			params.put("report_user_Remarks", strUserRemarks);
			params.put("username",strUserFullName);
			params.put("hospCode", strHospitalCode);
			params.put("catCode", strCatCode);
			params.put("itemId", strItemId);
			params.put("suppId", strSuppId);
			params.put("expiryDays", strExpiryDays);
			params.put("rateContractTypeId", strRateContractTypeId);
			params.put("groupId", strGroupId);

			ts.displayReport(request, response, reportPath, reportFormat,params, strHospitalCode);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
