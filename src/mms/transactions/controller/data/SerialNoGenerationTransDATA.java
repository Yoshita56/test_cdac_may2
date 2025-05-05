package mms.transactions.controller.data;

/**
 * @author Niharika Srivastava 
 * Date Of Creation : 15-Sep-2010 
 * Team Lead : Mr. Ajay Kumar Gupta 
 * Module : MMS 
 * Process : Serial No Generation Transaction
 * Description : DATA Class for Serial No Generation Transaction
 * Version : 1.0
 * Last Modified By :-- 
 * Last Modification Date :--
 */

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.bo.SerialNoGenerationTransBO;
import mms.transactions.controller.fb.SerialNoGenerationTransFB;
import mms.transactions.vo.SerialNoGenerationTransVO;


public class SerialNoGenerationTransDATA {

	/**
	 * Function For Getting Initial Data On Serial No Generation Page
	 */

	public static void initialData(SerialNoGenerationTransFB fb_p,
			HttpServletRequest request_p) {

		SerialNoGenerationTransVO vo = null;
		SerialNoGenerationTransBO bo = null;
		HisUtil hisutil = null;
		String strSeatId = "";
		String strHospCode = "";
		String temp_strStoreCombo = "";
		String strStoreComboId = "";
		String strCategoryValues = "";

		try {
			vo = new SerialNoGenerationTransVO();
			bo = new SerialNoGenerationTransBO();

			strHospCode = request_p.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			strSeatId = request_p.getSession().getAttribute("SEATID")
					.toString();
			hisutil = new HisUtil("mms", "SerialNoGenerationTransDATA");

			vo.setStrHospitalCode(strHospCode);
			vo.setStrSeatId(strSeatId);

			bo.initialData(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getWsStoreNameCombo() != null
					&& vo.getWsStoreNameCombo().size() > 0) {
				
				if (vo.getWsStoreNameCombo().next()) {
					vo.setStrStoreId(vo.getWsStoreNameCombo().getString(1));
					fb_p.setStrStoreId(vo.getWsStoreNameCombo().getString(1));
					vo.getWsStoreNameCombo().beforeFirst();
				}
				temp_strStoreCombo = hisutil.getOptionValue(vo
						.getWsStoreNameCombo(), "0", "", false, false);
			} else {

				temp_strStoreCombo = "<option value='0'>Select Value</option>";
			}

			fb_p.setStrStoreNameCombo(temp_strStoreCombo);

			if (!fb_p.getStrStoreId().equals(""))
				strStoreComboId = fb_p.getStrStoreId();
			else
				strStoreComboId = "0";
			vo.setStrStoreId(strStoreComboId);

			if (strStoreComboId.equals("0")) {
				strCategoryValues = "<option value='0'>Select Value</option>";
			} else {
				bo.getCategoryList(vo);
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}

				if (vo.getWsItemCategoryCombo() != null
						&& vo.getWsItemCategoryCombo().size() > 0) {

					strCategoryValues = hisutil.getOptionValue(vo
							.getWsItemCategoryCombo(), "0", "0^Select Value",
							false);
				} else {
					strCategoryValues = "<option value='0'>Select Value</option>";
				}
				fb_p.setStrItemCategoryCombo(strCategoryValues);
			}
		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"SerialNoGenerationTransDATA->initialData()", strmsgText);
			fb_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (bo != null)
				bo = null;
			hisutil = null;

		}
	}

	/**
	 * Function For Getting Initial Data On Reprint Page
	 */

	public static void initialRePrint(SerialNoGenerationTransFB fb_p,
			HttpServletRequest request_p) {
		SerialNoGenerationTransVO vo = null;
		SerialNoGenerationTransBO bo = null;
		HisUtil hisutil = null;
		String strSeatId = "";
		String strHospCode = "";
		String temp_strStoreCombo = "";
		String strCategoryValues = "";
		String strStoreComboId = "";

		try {
			vo = new SerialNoGenerationTransVO();
			bo = new SerialNoGenerationTransBO();

			strHospCode = request_p.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			strSeatId = request_p.getSession().getAttribute("SEATID")
					.toString();

			hisutil = new HisUtil("mms", "SerialNoGenerationTransDATA");
			String strCtDate = hisutil.getASDate("dd-MMM-yyyy");

			vo.setStrHospitalCode(strHospCode);
			vo.setStrSeatId(strSeatId);

			bo.initialRePrintData(vo);

			fb_p.setStrCurrentDate(strCtDate);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getWsStoreNameCombo() != null
					&& vo.getWsStoreNameCombo().size() > 0) {
				
				if (vo.getWsStoreNameCombo().next()) {
					vo.setStrStoreId(vo.getWsStoreNameCombo().getString(1));
					fb_p.setStrStoreId(vo.getWsStoreNameCombo().getString(1));
					vo.getWsStoreNameCombo().beforeFirst();
				}
				temp_strStoreCombo = hisutil.getOptionValue(vo
						.getWsStoreNameCombo(), "0", "", false, false);
			} else {

				temp_strStoreCombo = "<option value='0'>Select Value</option>";
			}

			fb_p.setStrStoreNameCombo(temp_strStoreCombo);

			if (!fb_p.getStrStoreId().equals(""))
				strStoreComboId = fb_p.getStrStoreId();
			else
				strStoreComboId = "0";
			vo.setStrStoreId(strStoreComboId);

			if (strStoreComboId.equals("0")) {
				strCategoryValues = "<option value='0'>Select Value</option>";
			} else {
				bo.getCategoryList(vo);
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}

				if (vo.getWsItemCategoryCombo() != null
						&& vo.getWsItemCategoryCombo().size() > 0) {

					strCategoryValues = hisutil.getOptionValue(vo
							.getWsItemCategoryCombo(), "0", "0^Select Value",
							false);
				} else {
					strCategoryValues = "<option value='0'>Select Value</option>";
				}
				fb_p.setStrItemCategoryCombo(strCategoryValues);
			}

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"SerialNoGenerationTransDATA->initialRePrint()", strmsgText);
			fb_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (bo != null)
				bo = null;
			hisutil = null;

		}
	}

	/**
	 * Function For Getting Item Category Combo
	 */
	public static void getCategoryList(SerialNoGenerationTransFB fb_p,
			HttpServletRequest request_p, HttpServletResponse response_p) {

		String strmsgText = "";
		SerialNoGenerationTransVO vo = null;
		SerialNoGenerationTransBO bo = null;
		HisUtil hisutil = null;
		String strHospCode = "";
		String strCmb = "";

		try {

			vo = new SerialNoGenerationTransVO();
			bo = new SerialNoGenerationTransBO();

			strHospCode = request_p.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			hisutil = new HisUtil("mms", "SerialNoGenerationTransDATA");

			String strStoreId = (String) request_p.getParameter("storeId");

			vo.setStrStoreId(strStoreId);
			vo.setStrHospitalCode(strHospCode);

			bo.getCategoryList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getWsItemCategoryCombo() != null
					&& vo.getWsItemCategoryCombo().size() > 0) {

				strCmb = hisutil.getOptionValue(vo.getWsItemCategoryCombo(),
						"0", "0^Select Value", false);
			} else {
				strCmb = "<option value='0'>Select Value</option>";
			}

			try {
				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(strCmb);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"SerialNoGenerationTransDATA->getCategoryList()",
					strmsgText);
			try {

				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}
			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}

	}

	/**
	 * Function For Getting Item Name Combo
	 */

	public static void getItemName(SerialNoGenerationTransFB fb_p,
			HttpServletRequest request_p, HttpServletResponse response_p) {

		String strmsgText = "";
		SerialNoGenerationTransVO vo = null;
		SerialNoGenerationTransBO bo = null;
		HisUtil hisutil = null;
		String strHospCode = "";
		String strCmb = "";

		try {

			vo = new SerialNoGenerationTransVO();
			bo = new SerialNoGenerationTransBO();

			strHospCode = request_p.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			hisutil = new HisUtil("mms", "SerialNoGenerationTransDATA");

			String strStoreId = (String) request_p.getParameter("storeId");
			String strItemCatId = (String) request_p.getParameter("itemCat");

			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatId(strItemCatId);
			vo.setStrHospitalCode(strHospCode);

			bo.getItemName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getWsItemNameCombo() != null
					&& vo.getWsItemNameCombo().size() > 0) {

				strCmb = hisutil.getOptionValue(vo.getWsItemNameCombo(), "0",
						"0^Select Value", false);
			} else {
				strCmb = "<option value='0'>Select Value</option>";
			}
			try {
				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(strCmb);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"SerialNoGenerationTransDATA->getItemName()", strmsgText);
			try {

				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}

	}

	/**
	 * Function For Getting Report Name Combo
	 */
	public static void getReportNameList(SerialNoGenerationTransFB fb_p,
			HttpServletRequest request_p, HttpServletResponse response_p) {

		String strmsgText = "";
		SerialNoGenerationTransVO vo = null;
		SerialNoGenerationTransBO bo = null;
		HisUtil hisutil = null;
		String strHospCode = "";
		String strCmb = "";
		String strFromDate = "";
		String strToDate = "";

		try {

			vo = new SerialNoGenerationTransVO();
			bo = new SerialNoGenerationTransBO();

			strHospCode = request_p.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			hisutil = new HisUtil("mms", "SerialNoGenerationTransDATA");

			String strStoreId = (String) request_p.getParameter("storeId");
			String strItemCatId = (String) request_p.getParameter("itemCat");

			strFromDate = request_p.getParameter("from_date");
			strToDate = request_p.getParameter("to_date");

			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatId(strItemCatId);
			vo.setStrHospitalCode(strHospCode);
			vo.setStrFromDate(strFromDate);
			vo.setStrToDate(strToDate);

			bo.getReportNameList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getWsReportNameCombo() != null
					&& vo.getWsReportNameCombo().size() > 0) {

				strCmb = hisutil.getOptionValue(vo.getWsReportNameCombo(), "0",
						"0^Select Value", false);
			} else {
				strCmb = "<option value='0'>Select Value</option>";
			}
			try {
				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(strCmb);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"SerialNoGenerationTransDATA->getItemName()", strmsgText);
			try {

				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}

	}
}
