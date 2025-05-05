package mms.transactions.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.upload.FormFile;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.AttachFileGlobal;
import mms.transactions.bo.SampleRegisterPurTransBO;
import mms.transactions.controller.fb.SampleRegisterPurTransFB;
import mms.transactions.controller.hlp.SampleRegisterPurTransHLP;
import mms.transactions.vo.SampleRegisterPurTransVO;


public class SampleRegisterPurTransDATA {
	/**
	 * This function is used to set initial parameters for recieve mode
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void initialAdd(
			SampleRegisterPurTransFB _SampleRegisterPurTransFB,
			HttpServletRequest request) {
		SampleRegisterPurTransVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;

		try {
			vo = new SampleRegisterPurTransVO();
			hisutil = new HisUtil("mms", "SampleRegisterPurTransDATA");
			String path = "/mms" + request.getParameter("cnt_page") + ".cnt";

			_SampleRegisterPurTransFB.setStrPath(path.trim());
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strCurrentDate = hisutil.getASDate("dd-MMM-yyyy");

			_SampleRegisterPurTransFB.setStrCurrentDate(strCurrentDate);

			/**
			 * Here we are splitting value combo value that contain both store
			 * Id and store type id
			 */

			String strCmb1 = _SampleRegisterPurTransFB.getCombo()[0];
			String temp[] = strCmb1.replace("/", "#").split("#");

			String temp1[] = request.getParameter("comboValue")
					.replace("^", "#").split("#");

			_SampleRegisterPurTransFB.setComboValue(request
					.getParameter("comboValue"));
			_SampleRegisterPurTransFB.setStrStoreName(temp1[0]);
			_SampleRegisterPurTransFB.setStrItemCategoryName(temp1[1]);
			_SampleRegisterPurTransFB.setStrItemCategory(request
					.getParameterValues("combo")[1]);
			_SampleRegisterPurTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterPurTransFB.setStrSeatId(seatid);
			_SampleRegisterPurTransFB.setStrStoreId(temp[0]);
			_SampleRegisterPurTransFB.setStrStoreTypeId(temp[1]);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(temp[0]);
			vo.setStrStoreTypeId(temp[1]);
			vo.setStrItemCategory(_SampleRegisterPurTransFB
					.getStrItemCategory());

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "SampleRegisterPurTransDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterPurTransDATA->initialAdd()", strmsgText);
			_SampleRegisterPurTransFB
					.setStrErr("Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			vo = null;
			hisutil = null;
		}

	}

	public static void getProposalNo(SampleRegisterPurTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		SampleRegisterPurTransVO voObj = null;
		SampleRegisterPurTransBO bo = null;
		String strmsgText = null;
		String strProposalNo = "";
		HisUtil util = null;
		try {

			voObj = new SampleRegisterPurTransVO();
			bo = new SampleRegisterPurTransBO();

			voObj.setStrItemCategory(request.getParameter("itemCatNo"));
			voObj.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());

			bo.getProposalList(voObj);

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			}

			util = new HisUtil("mms", "SampleRegisterPurTransDATA");
			strProposalNo = util.getOptionValue(voObj.getProposalNoWs(), "",
					"0^Select Value", true);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strProposalNo);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "purchase.transactions.SampleRegisterPurTransDATA.getProposalNo --> "
					+ e.getMessage();
			HisException eObj = new HisException("purchase",
					"SampleRegisterPurTransDATA->getTenderQuotDtl()",
					strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}

	public static void getProposalDtl(SampleRegisterPurTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		SampleRegisterPurTransVO voObj = null;
		String strmsgText = null;
		String strProposalDtl = "";
		HisUtil util = null;
		try {

			voObj = new SampleRegisterPurTransVO();

			String strProposalNo = request.getParameter("proposalNo");
			if (strProposalNo == null)
				strProposalNo = "0";

			voObj.setStrProposalNo(strProposalNo);

			voObj.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());

			if (voObj.getStrMsgType().equals("1")) {
				throw new Exception(voObj.getStrMsgString());
			} else {

				/*
				 * strProposalDtl = GlblPurchaseHLP.getProposalDetailsTLD(
				 * voObj.getStrProposalNo(), voObj.getStrHospitalCode(), "1");
				 */

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("");

			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "purchase.transactions.SampleRegisterPurTransDATA.getProposalDtl --> "
					+ e.getMessage();
			HisException eObj = new HisException("purchase",
					"SampleRegisterPurTransDATA->getTenderQuotDtl()",
					strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			if (voObj != null)
				voObj = null;
			if (util != null)
				util = null;
		}
	}

	public static void getSupplierCombo(
			SampleRegisterPurTransFB _SampleRegisterPurTransFB,
			HttpServletRequest request, HttpServletResponse response) {
		String strmsgText = "";
		SampleRegisterPurTransBO bo = null;
		SampleRegisterPurTransVO vo = null;
		HisUtil hisutil = null;
		String strCmb = "";

		try {

			vo = new SampleRegisterPurTransVO();
			bo = new SampleRegisterPurTransBO();

			vo.setStrProposalNo(request.getParameter("proposalNo"));
			vo.setStrTenderNo(request.getParameter("tenderNo"));
			vo.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());

			bo.getSupplierCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			hisutil = new HisUtil("mms", "SampleRegisterPurTransDATA");
			strCmb = hisutil.getOptionValue(vo.getStrSupplierWS(), "",
					"0^Select Value", true);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strCmb);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "SampleRegisterPurTransDATA.getSupplierCombo() --> "
					+ e.getMessage();

			HisException eObj = new HisException("MMS",
					"SampleRegisterPurTransDATA->getSupplierCombo()",
					strmsgText);
			String response1 = "ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator!";
			try {
				response.getWriter().print(response1);
				eObj = null;
			} catch (Exception e1) {

			}

		}
	}

	public static void getItemCombo(
			SampleRegisterPurTransFB _SampleRegisterPurTransFB,
			HttpServletRequest request, HttpServletResponse response) {
		String strmsgText = "";
		SampleRegisterPurTransBO bo = null;
		SampleRegisterPurTransVO vo = null;
		HisUtil hisutil = null;
		String strCmb = "";

		try {

			vo = new SampleRegisterPurTransVO();
			bo = new SampleRegisterPurTransBO();

			vo.setStrSupplierId(request.getParameter("supplierId"));
			vo.setStrProposalNo(request.getParameter("proposalNo"));
			vo.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());

			bo.getItemCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			hisutil = new HisUtil("mms", "SampleRegisterPurTransDATA");
			strCmb = hisutil.getOptionValue(vo.getItemWs(), "",
					"0^Select Value", true);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strCmb);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "SampleRegisterPurTransDATA.getItemCombo() --> "
					+ e.getMessage();

			HisException eObj = new HisException("MMS",
					"SampleRegisterPurTransDATA->getItemCombo()", strmsgText);
			String response1 = "ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator!";
			try {
				response.getWriter().print(response1);
				eObj = null;
			} catch (Exception e1) {

			}

		}
	}

	public static void getUnitCombo(
			SampleRegisterPurTransFB _SampleRegisterPurTransFB,
			HttpServletRequest request, HttpServletResponse response) {
		String strmsgText = "";
		SampleRegisterPurTransBO bo = null;
		SampleRegisterPurTransVO vo = null;
		HisUtil hisutil = null;
		String strCmb = "";

		try {

			vo = new SampleRegisterPurTransVO();
			bo = new SampleRegisterPurTransBO();

			vo.setStrItemUnitId(request.getParameter("itemUnitId"));
			vo.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());

			bo.getUnitCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			hisutil = new HisUtil("mms", "SampleRegisterPurTransDATA");
			strCmb = hisutil.getOptionValue(vo.getUnitWS(), "",
					"0^Select Value", true);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strCmb);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "SampleRegisterPurTransDATA.getUnitCombo() --> "
					+ e.getMessage();

			HisException eObj = new HisException("MMS",
					"SampleRegisterPurTransDATA->getUnitCombo()", strmsgText);
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
	 * This function is used to set insert data during recieve mode
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void insert(SampleRegisterPurTransFB formBean,
			HttpServletRequest request) {
		String strmsgText = "";
		SampleRegisterPurTransBO bo = null;
		SampleRegisterPurTransVO vo = null;
		String[] hiddenValue = null;
		try {

			bo = new SampleRegisterPurTransBO();
			vo = new SampleRegisterPurTransVO();

			hiddenValue = formBean.getStrProposalTLDHiddenVal()
					.replace("^", "#").split("#");

			vo.setStrItemId(formBean.getStrItemId());
			vo.setStrBatchSlno(formBean.getStrBatchNo());
			vo.setStrExpiryDate(formBean.getStrExpiryDate());
			vo.setStrRecQty(formBean.getStrReservedQty());
			vo.setStrRecQtyUnitId(formBean.getStrUnitId());
			vo.setStrIssuedQty("0");
			vo.setStrReturnQty("0");
			vo.setStrCondemnQty("0");
			vo.setStrSampleItemStatus("0");
			vo.setStrApprovalStatus("0");
			vo.setStrComRmksSlNo("0");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrItemCategory(request.getParameter("strItemCategoryId"));
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrTenderNo(hiddenValue[0]);
			vo.setStrQuotationNo("0");
			vo.setStrSupplierId(formBean.getStrSupplierId());
			vo.setStrSampleStatus("0");
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrIsValid("1");
			vo.setStrProposalNo(formBean.getStrProposalNo());

			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getIsFlag() == true) {
				formBean.setStrMsg("Data is successfully saved");
			}

		} catch (Exception e) {

			strmsgText = "SampleRegisterPurTransDATA.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterPurTransDATA->insert()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {
			if (vo != null) {
				vo = null;
			}
		}
	}

	/**
	 * This function is used to set initial parameters for return mode
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void returnAdd(
			SampleRegisterPurTransFB _SampleRegisterPurTransFB,
			HttpServletRequest request) {
		SampleRegisterPurTransBO bo = null;
		SampleRegisterPurTransVO vo = null;
		String strmsgText = "";
		try {
			bo = new SampleRegisterPurTransBO();
			vo = new SampleRegisterPurTransVO();
			String path = "/mms" + request.getParameter("cnt_page") + ".cnt";

			_SampleRegisterPurTransFB.setStrPath(path);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			// //System.out.println("Check Post-->"+request.getParameter("chk"));

			// Check
			// Post-->185310003@19000007@19100009@11112@0@11201000004@0@108$2

			_SampleRegisterPurTransFB.setStrChk(request.getParameter("chk")
					.toString());
			// _SampleRegisterPurTransFB.setChk(_SampleRegisterPurTransFB.getStrChk());
			String strStoreId = _SampleRegisterPurTransFB.getCombo()[0];
			_SampleRegisterPurTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterPurTransFB.setStrSeatId(seatid);
			_SampleRegisterPurTransFB.setStrStoreId(strStoreId);

			String strCmb1 = _SampleRegisterPurTransFB.getCombo()[0];
			// String strCmb2 = _SampleRegisterPurTransFB.getCombo()[1];

			// //System.out.println("Get Combo Store-->"+_SampleRegisterPurTransFB.getCombo()[0]);
			// //System.out.println("Get Combo Item Cate-->"+_SampleRegisterPurTransFB.getCombo()[1]);

			String temp1[] = strCmb1.replace("/", "#").split("#");

			// //System.out.println("Combo value--"+request.getParameter("comboValue"));

			String[] val = request.getParameter("comboValue").replace("^", "#")
					.split("#");

			_SampleRegisterPurTransFB.setStrStoreName(val[0]);
			_SampleRegisterPurTransFB.setStrItemCategDtl(val[1]);

			_SampleRegisterPurTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterPurTransFB.setStrSeatId(seatid);
			_SampleRegisterPurTransFB.setStrStoreId(temp1[0]);
			_SampleRegisterPurTransFB.setStrStoreTypeId(temp1[1]);

			// _SampleRegisterPurTransFB.setChk(_SampleRegisterPurTransFB.getStrChk());

			vo.setStrChk(_SampleRegisterPurTransFB.getStrChk());
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			String strChk = vo.getStrChk();

			String temp[] = strChk.replace("@", "#").split("#");

			vo.setStrItemReciveNo(temp[0]);
			vo.setStrItemId(temp[1]);
			vo.setStrItemBrandId(temp[2]);
			vo.setStrBatchSlno(temp[3]);

			vo.setStrTenderNo(temp[5]);
			vo.setStrQuotationNo(temp[6]);

			bo.initialReturnAdd(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			_SampleRegisterPurTransFB.setStrItemName(vo.getStrItemName());
			_SampleRegisterPurTransFB.setStrItemBrandName(vo
					.getStrItemBrandName());
			_SampleRegisterPurTransFB.setStrBatchSlno(vo.getStrBatchSlno());

			// //System.out.println("vo.getStrUnitVal()-->"+vo.getStrUnitVal());

			_SampleRegisterPurTransFB.setStrRecQty(vo.getStrRecQty());
			_SampleRegisterPurTransFB.setStrRecQtyUnit(vo.getStrRecQtyUnit());
			_SampleRegisterPurTransFB.setStrSupplierName(vo
					.getStrSupplierName());
			// _SampleRegisterPurTransFB.setStrItemCategDtl(vo.getStrItemCategDtl());
			_SampleRegisterPurTransFB.setStrTenderNo(vo.getStrTenderNo());
			_SampleRegisterPurTransFB.setStrQuotationNo(vo.getStrQuotationNo());

		} catch (Exception e) {
			strmsgText = "SampleRegisterPurTransDATA.returnAdd() --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterPurTransDATA->returnAdd()", strmsgText);
			_SampleRegisterPurTransFB
					.setStrErr("Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "],Contact System Administrator! ");

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
	public static void verifyAdd(
			SampleRegisterPurTransFB _SampleRegisterPurTransFB,
			HttpServletRequest request) {
		SampleRegisterPurTransBO bo = null;
		SampleRegisterPurTransVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			bo = new SampleRegisterPurTransBO();
			vo = new SampleRegisterPurTransVO();
			String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
			_SampleRegisterPurTransFB.setStrPath(path);
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			_SampleRegisterPurTransFB.setStrChk(request.getParameter("chk")
					.toString());
			String strStoreId = _SampleRegisterPurTransFB.getCombo()[0];
			_SampleRegisterPurTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterPurTransFB.setStrSeatId(seatid);
			_SampleRegisterPurTransFB.setStrStoreId(strStoreId);
			// _SampleRegisterPurTransFB.setChk(_SampleRegisterPurTransFB.getStrChk());
			String strCmb1 = _SampleRegisterPurTransFB.getCombo()[0];

			/**
			 * 
			 * Here we are splitting value combo value that contain both store
			 * Id and store type id
			 */

			String temp1[] = strCmb1.replace("/", "#").split("#");

			_SampleRegisterPurTransFB.setStrStoreName(request
					.getParameter("comboValue"));
			_SampleRegisterPurTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterPurTransFB.setStrSeatId(seatid);
			_SampleRegisterPurTransFB.setStrStoreId(temp1[0]);
			_SampleRegisterPurTransFB.setStrStoreTypeId(temp1[1]);

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
			_SampleRegisterPurTransFB.setStrTenderNo(temp[5]);
			_SampleRegisterPurTransFB.setStrQuotationNo(temp[6]);
			bo.initialVerifyAdd(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			_SampleRegisterPurTransFB.setStrItemName(vo.getStrItemName());
			_SampleRegisterPurTransFB.setStrItemBrandName(vo
					.getStrItemBrandName());
			_SampleRegisterPurTransFB.setStrBatchSlno(vo.getStrBatchSlno());
			_SampleRegisterPurTransFB.setStrRecQty(vo.getStrRecQty() + " "
					+ vo.getStrUnitVal());
			_SampleRegisterPurTransFB.setStrRecQtyUnitId(vo
					.getStrRecQtyUnitId());
			_SampleRegisterPurTransFB.setStrSupplierName(vo
					.getStrSupplierName());
			_SampleRegisterPurTransFB.setStrItemCategDtl(vo
					.getStrItemCategDtl());
			_SampleRegisterPurTransFB.setStrItemCategory(vo.getStrItemCatNo());

			hisutil = new HisUtil("mms", "SampleRegisterPurTransDATA");
			String cmb = hisutil.getOptionValue(vo.getCommitteTypeWS(), "",
					"0^Select Value", true);
			_SampleRegisterPurTransFB.setStrCommitteeValues(cmb);

		} catch (Exception e) {

			strmsgText = "SampleRegisterPurTransDATA.verifyAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterPurTransDATA->verifyAdd()", strmsgText);
			_SampleRegisterPurTransFB
					.setStrErr("Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "],Contact System Administrator! ");

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
			SampleRegisterPurTransFB _SampleRegisterPurTransFB,
			HttpServletRequest request) {
		SampleRegisterPurTransBO bo = null;
		SampleRegisterPurTransVO vo = null;
		String strmsgText = "";

		try {
			bo = new SampleRegisterPurTransBO();
			vo = new SampleRegisterPurTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
			_SampleRegisterPurTransFB.setStrPath(path);
			_SampleRegisterPurTransFB.setStrChk(request.getParameter("chk")
					.toString());

			String strStoreId = _SampleRegisterPurTransFB.getCombo()[0];
			_SampleRegisterPurTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterPurTransFB.setStrSeatId(seatid);
			_SampleRegisterPurTransFB.setStrStoreId(strStoreId);
			// _SampleRegisterPurTransFB.setChk(_SampleRegisterPurTransFB.getStrChk());

			/**
			 * 
			 * Here we are splitting value combo value that contain both store
			 * Id and store type id
			 */

			String strCmb1 = _SampleRegisterPurTransFB.getCombo()[0];
			String temp1[] = strCmb1.replace("/", "#").split("#");

			String[] val = request.getParameter("comboValue").replace("^", "#")
					.split("#");

			_SampleRegisterPurTransFB.setStrStoreName(val[0]);
			_SampleRegisterPurTransFB.setStrItemCategDtl(val[1]);

			_SampleRegisterPurTransFB.setStrHospitalCode(hosCode);
			_SampleRegisterPurTransFB.setStrSeatId(seatid);
			_SampleRegisterPurTransFB.setStrStoreId(temp1[0]);
			_SampleRegisterPurTransFB.setStrStoreTypeId(temp1[1]);
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
			vo.setStrTenderNo(temp[5]);
			vo.setStrQuotationNo(temp[6]);

			bo.initialCondemnAdd(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			_SampleRegisterPurTransFB.setStrItemName(vo.getStrItemName());
			_SampleRegisterPurTransFB.setStrItemBrandName(vo
					.getStrItemBrandName());
			_SampleRegisterPurTransFB.setStrBatchSlno(vo.getStrBatchSlno());
			_SampleRegisterPurTransFB.setStrRecQty(vo.getStrRecQty());
			_SampleRegisterPurTransFB.setStrRecQtyUnit(vo.getStrRecQtyUnit());
			_SampleRegisterPurTransFB.setStrSupplierName(vo
					.getStrSupplierName());
			_SampleRegisterPurTransFB.setStrTenderNo(vo.getStrTenderNo());
			_SampleRegisterPurTransFB.setStrQuotationNo(vo.getStrQuotationNo());

		} catch (Exception e) {
			strmsgText = "SampleRegisterPurTransDATA.condemnPage(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterPurTransDATA->condemnPage()", strmsgText);
			_SampleRegisterPurTransFB
					.setStrErr("Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * This function is used to set insert data during return mode
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void updateReturn(SampleRegisterPurTransFB formBean,
			HttpServletRequest request) {
		String strmsgText = "";
		SampleRegisterPurTransBO bo = null;
		SampleRegisterPurTransVO vo = null;
		String strTemp = "";
		String strTempData[] = null;

		try {
			bo = new SampleRegisterPurTransBO();
			vo = new SampleRegisterPurTransVO();
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

			strmsgText = "SampleRegisterPurTransDATA.updateReturn(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterPurTransDATA.updateReturn(vo)", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {
			if (vo != null) {
				vo = null;
			}
		}
	}

	public static void getMemberDtl(
			SampleRegisterPurTransFB _SampleRegisterPurTransFB,
			HttpServletRequest request, HttpServletResponse response) {
		String strmsgText = "";
		SampleRegisterPurTransBO bo = null;
		SampleRegisterPurTransVO vo = null;
		String result = "";
		try {

			vo = new SampleRegisterPurTransVO();
			bo = new SampleRegisterPurTransBO();
			vo.setStrCommitteeType(request.getParameter("committeType"));

			vo.setStrItemCatNo(request.getParameter("itemCategNo"));
			vo.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			bo.getMemberDetails(vo);
			_SampleRegisterPurTransFB.setCommitteMemberWS(vo
					.getCommitteMemberWS());
			result = SampleRegisterPurTransHLP
					.createMemberDetails(_SampleRegisterPurTransFB);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			response.getWriter().print(result);

		} catch (Exception e) {
			strmsgText = "SampleRegisterPurTransDATA.getMemberDtl() --> "
					+ e.getMessage();
			HisException eObj = new HisException("IPD",
					"SampleRegisterPurTransDATA->getMemberDtl()", strmsgText);
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

	public static void verifyUpdate(SampleRegisterPurTransFB formBean,
			HttpServletRequest request) {
		String strmsgText = "";
		SampleRegisterPurTransBO bo = null;
		SampleRegisterPurTransVO vo = null;
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
			bo = new SampleRegisterPurTransBO();
			vo = new SampleRegisterPurTransVO();
			fs = new AttachFileGlobal();
			hisutil = new HisUtil("mms", "SampleRegisterPurTransDATA");
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

			strmsgText = "SampleRegisterPurTransDATA.verifyUpdate(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterPurTransDATA->verifyUpdate()", strmsgText);
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
			SampleRegisterPurTransFB _SampleRegisterPurTransFB,
			HttpServletRequest request) {
		String strmsgText = "";
		SampleRegisterPurTransBO bo = null;
		SampleRegisterPurTransVO vo = null;
		String strTemp = "";
		String strTempData[] = null;
		try {
			bo = new SampleRegisterPurTransBO();
			vo = new SampleRegisterPurTransVO();
			strTemp = request.getParameter("strChk").toString();
			strTempData = strTemp.replace('@', '#').split("#");
			vo.setStrSampleRecieveNo(strTempData[0]);
			vo.setStrItemId(strTempData[1]);
			vo.setStrItemBrandId(strTempData[2]);
			vo.setStrBatchSlno(strTempData[3]);
			vo.setStrRemarks(_SampleRegisterPurTransFB.getStrRemarks());
			vo.setStrHospitalCode(request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			vo.setStrApprovalStatus(_SampleRegisterPurTransFB
					.getStrApprovalStatus());
			vo.setStrStoreId(_SampleRegisterPurTransFB.getStrStoreId());
			bo.condemnSample(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getIsFlag() == true) {

				_SampleRegisterPurTransFB
						.setStrMsg("Data is successfully saved");
			}

		} catch (Exception e) {

			strmsgText = "SampleRegisterPurTransDATA.condemnSample(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SampleRegisterPurTransDATA->condemnSample()", strmsgText);
			_SampleRegisterPurTransFB
					.setStrErr("Application Error [ERROR ID : "
							+ eObj.getErrorID()
							+ "],Contact System Administrator! ");

			eObj = null;

		} finally {
			if (vo != null) {
				vo = null;
			}
		}
	}

}
