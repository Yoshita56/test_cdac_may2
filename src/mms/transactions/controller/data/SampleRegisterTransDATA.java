package mms.transactions.controller.data;

import java.util.HashMap;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.controller.HisComboOptions;
import hisglobal.utility.HisUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.upload.FormFile;

import mms.AttachFileGlobal;
import mms.MmsConfigUtil;
import mms.transactions.bo.SampleRegisterTransBO;
import mms.transactions.controller.fb.SampleRegisterTransFB;
import mms.transactions.controller.hlp.SampleRegisterTransHLP;
import mms.transactions.vo.SampleRegisterTransVO;

public class SampleRegisterTransDATA {

	/**
	 * This function is used to set initial parameters for recieve mode
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void initialAdd(SampleRegisterTransFB _SampleRegisterTransFB,
			HttpServletRequest request) {
		SampleRegisterTransBO bo = null;
		SampleRegisterTransVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;

		try {
			bo = new SampleRegisterTransBO();
			vo = new SampleRegisterTransVO();
			hisutil = new HisUtil("mms", "SampleRegisterTransDATA");
			String path = "/mms" + request.getParameter("cnt_page") + ".cnt";

			_SampleRegisterTransFB.setStrPath(path.trim());
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strCurrentDate = hisutil.getASDate("dd-MMM-yyyy");

			_SampleRegisterTransFB.setStrCurrentDate(strCurrentDate);

			/**
			 * Here we are splitting value combo value that contain both store
			 * Id and store type id
			 */

			String strCmb1 = _SampleRegisterTransFB.getCombo()[0];
			String temp[] = strCmb1.replace("/", "#").split("#");

			String temp1[] = request.getParameter("comboValue")
					.replace("^", "#").split("#");

			_SampleRegisterTransFB.setComboValue(request
					.getParameter("comboValue"));
			_SampleRegisterTransFB.setStrStoreName(temp1[0]);
			_SampleRegisterTransFB.setStrItemCategoryName(temp1[1]);
			_SampleRegisterTransFB.setStrItemCategory(request
					.getParameterValues("combo")[1]);
			_SampleRegisterTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterTransFB.setStrSeatId(seatid);
			_SampleRegisterTransFB.setStrStoreId(temp[0]);
			_SampleRegisterTransFB.setStrStoreTypeId(temp[1]);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(temp[0]);
			vo.setStrStoreTypeId(temp[1]);
			vo.setStrItemCategory(_SampleRegisterTransFB.getStrItemCategory());

			bo.initialAdd(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			String cmb = hisutil.getOptionValue(vo.getGroupWs(), "",
					"0^Select Value", true);
			_SampleRegisterTransFB.setStrGroupValues(cmb);

			cmb = hisutil.getOptionValue(vo.getItemCategoryWS(), "",
					"0^Select Value", true);
			_SampleRegisterTransFB.setStrItemCategoryValue(cmb);
			hisutil = new HisUtil("mms", "SampleRegisterTransDATA");
			cmb = hisutil.getOptionValue(vo.getStrSupplierWS(), "",
					"0^Select Value", true);
			_SampleRegisterTransFB.setStrSupplierValues(cmb);

		} catch (Exception e) {
			strmsgText = "SampleRegisterTransDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterTransDATA->initialAdd()", strmsgText);
			_SampleRegisterTransFB.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	/**
	 * This function is used to set initial parameters for return mode
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void returnAdd(SampleRegisterTransFB _SampleRegisterTransFB,
			HttpServletRequest request) {
		SampleRegisterTransBO bo = null;
		SampleRegisterTransVO vo = null;
		String strmsgText = "";
		try {
			bo = new SampleRegisterTransBO();
			vo = new SampleRegisterTransVO();
			String path = "/mms" + request.getParameter("cnt_page") + ".cnt";

			_SampleRegisterTransFB.setStrPath(path);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			_SampleRegisterTransFB.setStrChk(request.getParameter("chk")
					.toString());
			// _SampleRegisterTransFB.setChk(_SampleRegisterTransFB.getStrChk());
			String strStoreId = _SampleRegisterTransFB.getCombo()[0];
			_SampleRegisterTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterTransFB.setStrSeatId(seatid);
			_SampleRegisterTransFB.setStrStoreId(strStoreId);

			String strCmb1 = _SampleRegisterTransFB.getCombo()[0];

			String temp1[] = strCmb1.replace("/", "#").split("#");
			_SampleRegisterTransFB.setStrStoreName(request
					.getParameter("comboValue"));

			_SampleRegisterTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterTransFB.setStrSeatId(seatid);
			_SampleRegisterTransFB.setStrStoreId(temp1[0]);
			_SampleRegisterTransFB.setStrStoreTypeId(temp1[1]);
			// _SampleRegisterTransFB.setChk(_SampleRegisterTransFB.getStrChk());

			vo.setStrChk(_SampleRegisterTransFB.getStrChk());
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			String strChk = vo.getStrChk();

			String temp[] = strChk.replace("@", "#").split("#");

			vo.setStrItemReciveNo(temp[0]);
			vo.setStrItemId(temp[1]);
			vo.setStrItemBrandId(temp[2]);
			vo.setStrBatchSlno(temp[3]);

			_SampleRegisterTransFB.setStrTenderNo(temp[5]);
			_SampleRegisterTransFB.setStrQuotationNo(temp[6]);
			bo.initialReturnAdd(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			_SampleRegisterTransFB.setStrItemName(vo.getStrItemName());
			_SampleRegisterTransFB
					.setStrItemBrandName(vo.getStrItemBrandName());
			_SampleRegisterTransFB.setStrBatchSlno(vo.getStrBatchSlno());
			_SampleRegisterTransFB.setStrRecQty(vo.getStrRecQty() + " "
					+ vo.getStrUnitVal());
			_SampleRegisterTransFB.setStrRecQtyUnitId(vo.getStrRecQtyUnitId());
			_SampleRegisterTransFB.setStrSupplierName(vo.getStrSupplierName());
			_SampleRegisterTransFB.setStrItemCategDtl(vo.getStrItemCategDtl());

		} catch (Exception e) {
			strmsgText = "SampleRegisterTransDATA.returnAdd() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterTransDATA->returnAdd()", strmsgText);
			_SampleRegisterTransFB.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * This function is used to set initial parameters for return mode
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void verifyAdd(SampleRegisterTransFB _SampleRegisterTransFB,
			HttpServletRequest request) {
		SampleRegisterTransBO bo = null;
		SampleRegisterTransVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String strUnitVals = "";

		try {
			bo = new SampleRegisterTransBO();
			vo = new SampleRegisterTransVO();
			String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
			_SampleRegisterTransFB.setStrPath(path);
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			_SampleRegisterTransFB.setStrChk(request.getParameter("chk")
					.toString());
			String strStoreId = _SampleRegisterTransFB.getCombo()[0];
			_SampleRegisterTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterTransFB.setStrSeatId(seatid);
			_SampleRegisterTransFB.setStrStoreId(strStoreId);
			// _SampleRegisterTransFB.setChk(_SampleRegisterTransFB.getStrChk());
			String strCmb1 = _SampleRegisterTransFB.getCombo()[0];

			/**
			 * 
			 * Here we are splitting value combo value that contain both store
			 * Id and store type id
			 */

			String temp1[] = strCmb1.replace("/", "#").split("#");

			_SampleRegisterTransFB.setStrStoreName(request
					.getParameter("comboValue"));
			_SampleRegisterTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterTransFB.setStrSeatId(seatid);
			_SampleRegisterTransFB.setStrStoreId(temp1[0]);
			_SampleRegisterTransFB.setStrStoreTypeId(temp1[1]);

			vo.setStrItemCatNo(request.getParameterValues("combo")[1]);
			vo.setStrChk(request.getParameter("chk").toString());
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			String strChk = vo.getStrChk();
			String temp[] = strChk.replace("@", "#").split("#");
			vo.setStrItemReciveNo(temp[0]);
			vo.setStrItemId(temp[1]);
			vo.setStrItemBrandId(temp[2]);
			vo.setStrBatchSlno(temp[3]);
			_SampleRegisterTransFB.setStrTenderNo(temp[5]);
			_SampleRegisterTransFB.setStrQuotationNo(temp[6]);
			_SampleRegisterTransFB.setStrConsumableFlag(temp[7]);
			bo.initialVerifyAdd(vo);

			HashMap<String, String> _mapProcedureParam1 = new HashMap<String, String>();
			_mapProcedureParam1.put("modeval", "1");
			_mapProcedureParam1.put("hosp_code", request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			_mapProcedureParam1.put("unit_id", vo.getStrRecQtyUnitId());

			_mapProcedureParam1.put("module_id", ""); // Default Value

			_mapProcedureParam1.put("err", "#1");
			_mapProcedureParam1.put("resultset", "#2");
			/*
			 * strUnitVals = HisComboOptions.getOptionsFromProc(
			 * "pkg_mms_view.proc_gblt_unit_mst", _mapProcedureParam1, "0", "", true);
			 */
			_SampleRegisterTransFB.setStrUnitVals("");

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			_SampleRegisterTransFB.setStrItemName(vo.getStrItemName());
			_SampleRegisterTransFB
					.setStrItemBrandName(vo.getStrItemBrandName());
			_SampleRegisterTransFB.setStrBatchSlno(vo.getStrBatchSlno());
			_SampleRegisterTransFB.setStrRecQty(vo.getStrRecQty() + " "
					+ vo.getStrUnitVal());
			_SampleRegisterTransFB.setStrRecQtyUnitId(vo.getStrRecQtyUnitId());
			_SampleRegisterTransFB.setStrSupplierName(vo.getStrSupplierName());
			_SampleRegisterTransFB.setStrItemCategDtl(vo.getStrItemCategDtl());
			_SampleRegisterTransFB.setStrItemCategory(vo.getStrItemCatNo());
			_SampleRegisterTransFB.setStrUnitBaseVals(vo.getStrUnitBaseVals());
			_SampleRegisterTransFB.setStrRecQtyVals(vo.getStrRecQty());
			hisutil = new HisUtil("mms", "SampleRegisterTransDATA");
			String cmb = hisutil.getOptionValue(vo.getCommitteTypeWS(), "",
					"0^Select Value", true);
			_SampleRegisterTransFB.setStrCommitteeValues(cmb);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "SampleRegisterTransDATA.verifyAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterTransDATA->verifyAdd()", strmsgText);
			_SampleRegisterTransFB.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	/**
	 * This function is used to set initial parameters for return mode
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void condemnPage(
			SampleRegisterTransFB _SampleRegisterTransFB,
			HttpServletRequest request) {
		SampleRegisterTransBO bo = null;
		SampleRegisterTransVO vo = null;
		String strmsgText = "";

		try {
			bo = new SampleRegisterTransBO();
			vo = new SampleRegisterTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
			_SampleRegisterTransFB.setStrPath(path);
			_SampleRegisterTransFB.setStrChk(request.getParameter("chk")
					.toString());

			String strStoreId = _SampleRegisterTransFB.getCombo()[0];
			_SampleRegisterTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterTransFB.setStrSeatId(seatid);
			_SampleRegisterTransFB.setStrStoreId(strStoreId);
			// _SampleRegisterTransFB.setChk(_SampleRegisterTransFB.getStrChk());

			/**
			 * 
			 * Here we are splitting value combo value that contain both store
			 * Id and store type id
			 */

			String strCmb1 = _SampleRegisterTransFB.getCombo()[0];
			String temp1[] = strCmb1.replace("/", "#").split("#");

			_SampleRegisterTransFB.setStrStoreName(request
					.getParameter("comboValue"));
			_SampleRegisterTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterTransFB.setStrSeatId(seatid);
			_SampleRegisterTransFB.setStrStoreId(temp1[0]);
			_SampleRegisterTransFB.setStrStoreTypeId(temp1[1]);
			vo.setStrItemCatNo(request.getParameterValues("combo")[1]);
			vo.setStrChk(request.getParameter("chk").toString());
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			/**
			 * splitting selected check box value to get sample recieve no.
			 */

			String strChk = vo.getStrChk();
			String temp[] = strChk.replace("@", "#").split("#");
			vo.setStrItemReciveNo(temp[0]);
			vo.setStrItemId(temp[1]);
			vo.setStrItemBrandId(temp[2]);
			vo.setStrBatchSlno(temp[3]);
			_SampleRegisterTransFB.setStrTenderNo(temp[5]);
			_SampleRegisterTransFB.setStrQuotationNo(temp[6]);
			bo.initialCondemnAdd(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			_SampleRegisterTransFB.setStrItemName(vo.getStrItemName());
			_SampleRegisterTransFB
					.setStrItemBrandName(vo.getStrItemBrandName());
			_SampleRegisterTransFB.setStrBatchSlno(vo.getStrBatchSlno());
			_SampleRegisterTransFB.setStrRecQty(vo.getStrRecQty() + " "
					+ vo.getStrUnitVal());
			_SampleRegisterTransFB.setStrRecQtyUnitId(vo.getStrRecQtyUnitId());
			_SampleRegisterTransFB.setStrSupplierName(vo.getStrSupplierName());
			_SampleRegisterTransFB.setStrItemCategDtl(vo.getStrItemCategDtl());

		} catch (Exception e) {
			strmsgText = "SampleRegisterTransDATA.condemnPage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterTransDATA->condemnPage()", strmsgText);
			_SampleRegisterTransFB.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * This function is used to set insert data during recieve mode
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void insert(SampleRegisterTransFB _SampleRegisterTransFB) {
		String strmsgText = "";
		SampleRegisterTransBO bo = null;
		SampleRegisterTransVO vo = null;
		MmsConfigUtil mcu = null;
		try {

			
			// //System.out.println("FinancialStartYear-->"+mcu.getStrFinancialStartDate());
			bo = new SampleRegisterTransBO();
			vo = new SampleRegisterTransVO();
			// vo =
			// (SampleRegisterTransVO)TransferObjectFactory.populateData("mms.transactions.SampleRegisterTransVO",
			// formBean);
			vo.setItemParamValue(_SampleRegisterTransFB.getItemParamValue());
			vo.setStrSupplierName(_SampleRegisterTransFB.getStrSupplierName());
			vo.setStrTenderNo(_SampleRegisterTransFB.getStrTenderNo());
			vo.setStrQuotationNo(_SampleRegisterTransFB.getStrQuotationNo());
			vo.setStrRemarks(_SampleRegisterTransFB.getStrRemarks());
			vo.setStrUnitName(_SampleRegisterTransFB.getStrUnitName());
			vo.setStrSeatId(_SampleRegisterTransFB.getStrSeatId());
			vo.setStrStoreId(_SampleRegisterTransFB.getStrStoreId());
			vo.setStrStoreTypeId(_SampleRegisterTransFB.getStrStoreTypeId());
			vo.setStrHospitalCode(_SampleRegisterTransFB.getStrHospitalCode());
			vo.setStrFinancialEndYear(_SampleRegisterTransFB
					.getStrFinancialEndYear());
			vo.setStrFinancialStartYear(_SampleRegisterTransFB
					.getStrFinancialStartYear());
			vo.setStrQty(_SampleRegisterTransFB.getStrQty());
			vo.setStrGroupName(_SampleRegisterTransFB
					.getStrGroupIdForItemSearch());
			vo.setStrBatchSlNo(_SampleRegisterTransFB.getStrBatchSlNo());
			vo.setStrItemCategory(_SampleRegisterTransFB.getStrItemCategory());
			vo.setStrExpDate(_SampleRegisterTransFB.getStrExpDate());
			vo.setStrTendorDate(_SampleRegisterTransFB.getStrTendorDate());
			vo.setStrQuotationDate(_SampleRegisterTransFB.getStrQuotationDate());
			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getIsFlag() == true) {
				_SampleRegisterTransFB.setStrMsg("Data is successfully saved");
			}

		} catch (Exception e) {

			strmsgText = "SampleRegisterTransDATA.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterTransDATA->insert()", strmsgText);
			_SampleRegisterTransFB.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {
			if (vo != null) {
				vo = null;
			}
		}
	}

	/**
	 * This function is used to set insert data during return mode
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void updateReturn(SampleRegisterTransFB formBean,
			HttpServletRequest request) {
		String strmsgText = "";
		SampleRegisterTransBO bo = null;
		SampleRegisterTransVO vo = null;
		String strTemp = "";
		String strTempData[] = null;

		try {
			bo = new SampleRegisterTransBO();
			vo = new SampleRegisterTransVO();
			strTemp = request.getParameter("strChk").toString();
			strTempData = strTemp.replace('@', '#').split("#");
			vo.setStrSampleRecieveNo(strTempData[0]);
			vo.setStrItemId(strTempData[1]);
			vo.setStrItemBrandId(strTempData[2]);
			vo.setStrBatchSlno(strTempData[3]);
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			vo.setStrGatePassNo(formBean.getStrGatePassNo());
			vo.setStrReturnTo(formBean.getStrReturnTo());
			vo.setStrStoreId(formBean.getStrStoreId());
			bo.updateReturn(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getIsFlag() == true) {

				formBean.setStrMsg("Data is successfully saved");
			}

		} catch (Exception e) {

			strmsgText = "SampleRegisterTransDATA.updateReturn(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterTransDATA.updateReturn(vo)", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {
			if (vo != null) {
				vo = null;
			}
		}
	}

	public static void getSupplierCombo(
			SampleRegisterTransFB _SampleRegisterTransFB,
			HttpServletRequest request, HttpServletResponse response) {
		String strmsgText = "";
		SampleRegisterTransBO bo = null;
		SampleRegisterTransVO vo = null;
		HisUtil hisutil = null;
		String strCmb = "";
		try {

			vo = new SampleRegisterTransVO();
			bo = new SampleRegisterTransBO();
			// //System.out.println("request.getParameter('itemCategory')"+request.getParameter("itemCategory"));
			vo.setStrItemCategory(request.getParameter("itemCategory"));
			vo.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			bo.getSupplierDetails(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			hisutil = new HisUtil("mms", "SampleRegisterTransDATA");
			strCmb = hisutil.getOptionValue(vo.getStrSupplierWS(), "",
					"0^Select Value", true);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strCmb);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "SampleRegisterTransDATA.getSupplierCombo() --> "
					+ e.getMessage();

			HisException eObj = new HisException("IPD",
					"SampleRegisterTransDATA->getSupplierCombo()", strmsgText);
			String response1 = "ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator!";
			try {
				response.getWriter().print(response1);
				eObj = null;
			} catch (Exception e1) {

			}

		}
	}

	public static void getMemberDtl(
			SampleRegisterTransFB _SampleRegisterTransFB,
			HttpServletRequest request, HttpServletResponse response) {
		String strmsgText = "";
		SampleRegisterTransBO bo = null;
		SampleRegisterTransVO vo = null;
		String result = "";
		try {

			vo = new SampleRegisterTransVO();
			bo = new SampleRegisterTransBO();
			vo.setStrCommitteeType(request.getParameter("committeType"));

			vo.setStrItemCatNo(request.getParameter("itemCategNo"));
			vo.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			bo.getMemberDetails(vo);
			_SampleRegisterTransFB
					.setCommitteMemberWS(vo.getCommitteMemberWS());
			result = SampleRegisterTransHLP
					.createMemberDetails(_SampleRegisterTransFB);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			response.getWriter().print(result);

		} catch (Exception e) {
			strmsgText = "SampleRegisterTransDATA.getMemberDtl() --> "
					+ e.getMessage();
			HisException eObj = new HisException("IPD",
					"SampleRegisterTransDATA->getMemberDtl()", strmsgText);
			String response1 = "ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator!";
			try {
				response.getWriter().print(response1);
				eObj = null;
			} catch (Exception e1) {

			}

		}
	}

	/**
	 * This function is used to set insert data during return mode
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void verifyUpdate(SampleRegisterTransFB formBean,
			HttpServletRequest request) {
		String strmsgText = "";
		SampleRegisterTransBO bo = null;
		SampleRegisterTransVO vo = null;
		String strTemp = "";
		String strTempData[] = null;
		AttachFileGlobal fs = null;
		// MmsConfigUtil mmsConfig=null;
		String strFileName = "";
		HisUtil hisutil = null;
		// String fileLocation="";
		String fileExt = "";
		String[] temp = null;

		try {
			bo = new SampleRegisterTransBO();
			vo = new SampleRegisterTransVO();
			fs = new AttachFileGlobal();
			hisutil = new HisUtil("mms", "SampleRegisterTransDATA");
			// mmsConfig=new MmsConfigUtil();

			String strCurrentDate = hisutil.getASDate("dd-MMM-yyyy");

			strTemp = request.getParameter("strChk").toString();
			strTempData = strTemp.replace('@', '#').split("#");

			vo.setStrSampleRecieveNo(strTempData[0]);
			vo.setStrItemId(strTempData[1]);
			vo.setStrItemBrandId(strTempData[2]);
			vo.setStrBatchSlno(strTempData[3]);
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			vo.setStrApprovalStatus(formBean.getStrApprovalStatus());
			vo.setStrCommitteeMemberHidden(formBean
					.getStrCommitteeMemberHidden());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrFileNo(formBean.getStrFileNo());
			vo.setStrPageNo(formBean.getStrPageNo());
			FormFile myFile = formBean.getStrLocation();
			temp = myFile.getFileName().replace('.', '#').split("#");
			fileExt = temp[temp.length - 1];
			strFileName = vo.getStrStoreId() + "_" + vo.getStrSampleRecieveNo()
					+ "_" + vo.getStrHospitalCode() + "_" + strCurrentDate
					+ "." + fileExt;
			vo.setStrFileName(strFileName);

			vo.setConsumeQty(formBean.getConsumeQty());
			vo.setStrConsumeQtyUnit(formBean.getStrConsumeQtyUnit());

			// fileLocation=mmsConfig.getStrCommitteeFilePath();
			if (formBean.getStrMemberRecommendation() != null) {
				vo.setStrMemberRecommendation(formBean
						.getStrMemberRecommendation());
				vo.setStrCommitteeType(formBean.getStrCommitteeType());
			}

			bo.verifyUpdate(vo);

			fs.saveFile(myFile.getFileData(), strFileName);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getIsFlag() == true) {

				formBean.setStrMsg("Data is successfully saved");
			}

		} catch (Exception e) {

			strmsgText = "SampleRegisterTransDATA.verifyUpdate(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterTransDATA->verifyUpdate()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {
			if (vo != null) {
				vo = null;
			}
		}
	}

	public static void condemnSample(
			SampleRegisterTransFB _SampleRegisterTransFB,
			HttpServletRequest request) {
		String strmsgText = "";
		SampleRegisterTransBO bo = null;
		SampleRegisterTransVO vo = null;
		String strTemp = "";
		String strTempData[] = null;
		try {
			bo = new SampleRegisterTransBO();
			vo = new SampleRegisterTransVO();
			strTemp = request.getParameter("strChk").toString();
			strTempData = strTemp.replace('@', '#').split("#");
			vo.setStrSampleRecieveNo(strTempData[0]);
			vo.setStrItemId(strTempData[1]);
			vo.setStrItemBrandId(strTempData[2]);
			vo.setStrBatchSlno(strTempData[3]);
			vo.setStrRemarks(_SampleRegisterTransFB.getStrRemarks());
			vo.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			vo.setStrApprovalStatus(_SampleRegisterTransFB
					.getStrApprovalStatus());
			vo.setStrStoreId(_SampleRegisterTransFB.getStrStoreId());
			bo.condemnSample(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getIsFlag() == true) {

				_SampleRegisterTransFB.setStrMsg("Data is successfully saved");
			}

		} catch (Exception e) {

			strmsgText = "SampleRegisterTransDATA.condemnSample(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterTransDATA->condemnSample()", strmsgText);
			_SampleRegisterTransFB.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {
			if (vo != null) {
				vo = null;
			}
		}
	}

}
