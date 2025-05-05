/**
 * Developer : Deepak
 * Version : 1.0
 * Date : 31/Jan/2009
 */

package mms.masters.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.bo.AuthorityHierDtlBO;
import mms.masters.controller.fb.AuthorityHierDtlFB;
import mms.masters.controller.hlp.AuthorityHierDtlHLP;
import mms.masters.vo.AuthorityHierDtlVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorityHierDtlDATA.
 */
public class AuthorityHierDtlDATA {
	
	/**
	 * Method is Used to Populate the Data for Save Page of Breakage Item
	 * Transaction.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void GetData(AuthorityHierDtlFB formBean,
			HttpServletRequest request) {
		AuthorityHierDtlBO bo = null;
		AuthorityHierDtlVO vo = null;
		HisUtil hisutil = null;
		String strmsgText = "";
		//String cmb = "";
		String strCmb = "";
		try {
			bo = new AuthorityHierDtlBO();
			vo = new AuthorityHierDtlVO();
			hisutil = new HisUtil("mms", "AuthorityHierDtlDATA");
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatId = request.getSession().getAttribute("SEATID")
					.toString();

			// formBean.getClass();
			formBean.setStrHospitalCode(hosCode);

			formBean.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			bo.GetData(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrStoreName(vo.getStrStoreName());
			// formBean.setStrToStoreName(vo.getStrToStoreName());
			if (vo.getStrItemCategoryComboWS() != null
					&& vo.getStrItemCategoryComboWS().size() > 0) {
				strCmb = hisutil.getOptionValue(vo.getStrItemCategoryComboWS(),
						"0", "Select Value", true);
			} else {
				strCmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemCategoryCombo(strCmb);

			if (vo.getStrrReqTypeComboWS() != null
					&& vo.getStrrReqTypeComboWS().size() > 0) {
				strCmb = hisutil.getOptionValue(vo.getStrrReqTypeComboWS(),
						"0", "Select Value", true);
			} else {
				strCmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrReqTypeCombo(strCmb);
			formBean.setStrApprovalFlag("1"); // by default both raising and receiving level.
		} catch (Exception e) {
			// e.printStackTrace();
			strmsgText = "AuthorityHierDtlDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AuthorityHierDtlDATA->GetData()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * ITEMCATCMB.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 */
	public static void ITEMCATCMB(AuthorityHierDtlFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		AuthorityHierDtlBO bo = null;
		AuthorityHierDtlVO vo = null;
		HisUtil hisutil = null;
		String strmsgText = "";
	//	String cmb = "";
		String strCmb = "";
		try {
			bo = new AuthorityHierDtlBO();
			vo = new AuthorityHierDtlVO();
			hisutil = new HisUtil("mms", "AuthorityHierDtlDATA");
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatId = request.getSession().getAttribute("SEATID")
					.toString();
			vo.setStrFrmStoreId(request.getParameter("storeId"));
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			bo.ITEMCATCMB(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStrItemCategoryComboWS() != null
					&& vo.getStrItemCategoryComboWS().size() > 0) {
				strCmb = hisutil.getOptionValue(vo.getStrItemCategoryComboWS(),
						"0", "Select Value", true);
			} else {
				strCmb = "<option value='0'>Select Value</option>";
			}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strCmb);
		} catch (Exception e) {
			// e.printStackTrace();
			strmsgText = "AuthorityHierDtlDATA.ITEMCATCMB(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AuthorityHierDtlDATA->ITEMCATCMB()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * REQTYPCMB.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 */
	public static void REQTYPCMB(AuthorityHierDtlFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		AuthorityHierDtlBO bo = null;
		AuthorityHierDtlVO vo = null;
		HisUtil hisutil = null;
		String strmsgText = "";
	//	String cmb = "";
		String strCmb = "";
		try {
			bo = new AuthorityHierDtlBO();
			vo = new AuthorityHierDtlVO();
			hisutil = new HisUtil("mms", "AuthorityHierDtlDATA");
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatId = request.getSession().getAttribute("SEATID")
					.toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrFrmStoreId(request.getParameter("storeId"));
			vo.setStrItemCatCmb(request.getParameter("itemCatNo"));
			bo.REQTYPCMB(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStrrReqTypeComboWS() != null
					&& vo.getStrrReqTypeComboWS().size() > 0) {
				strCmb = hisutil.getOptionValue(vo.getStrrReqTypeComboWS(),
						"0", "Select Value", true);
			} else {
				strCmb = "<option value='0'>Select Value</option>";
			}
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strCmb);
		} catch (Exception e) {
			// e.printStackTrace();
			strmsgText = " "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AuthorityHierDtlDATA->REQTYPCMB()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * Method is Used to Populate the Data for Heirarchy Dtls Heirarchy Dtl
	 * Transaction.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 */
	public static void heirdetails(AuthorityHierDtlFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		AuthorityHierDtlBO bo = null;
		AuthorityHierDtlVO vo = null;
	//	HisUtil hisutil = null;
		String strPrevRec = "0";
		String strPrevRecordsSel = "0";
		String strRes = "0";
		String strmsgText = "";
		try {
			bo = new AuthorityHierDtlBO();
			vo = new AuthorityHierDtlVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatId = request.getSession().getAttribute("SEATID")
					.toString();
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrFrmStoreId(request.getParameter("storeId"));
			vo.setStrItemCatCmb(request.getParameter("itemCatNo"));
			vo.setStrReqTypeCmb(request.getParameter("reqTypeId"));
			bo.heirdetails(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				for (int i = 1; i <= 4; i++) {
					strPrevRec = "0";
					if (vo.getStrPrevHierDtlWS().size() != 0) {
						while (vo.getStrPrevHierDtlWS().next()) {

							if (vo.getStrPrevHierDtlWS().getString(1).equals(
									String.valueOf(i))) {

								if (strPrevRec.equals("0")) {
									strPrevRec = vo.getStrPrevHierDtlWS()
											.getString(2);
									strPrevRecordsSel = i
											+ "^"
											+ vo.getStrPrevHierDtlWS()
													.getString(2);
								} else {
									strPrevRec = strPrevRec
											+ "@@"
											+ vo.getStrPrevHierDtlWS()
													.getString(2);
									strPrevRecordsSel = strPrevRecordsSel
											+ "@@"
											+ i
											+ "^"
											+ vo.getStrPrevHierDtlWS()
													.getString(2);
								}
							}
						}
					}
					if (vo.getStrPrevHierDtlWS().getRow() == 1)
						vo.getStrPrevHierDtlWS().beforeFirst();
					else
						vo.getStrPrevHierDtlWS().absolute(
								vo.getStrPrevHierDtlWS().getRow() - 1);// moves
																		// the
																		// webRowset
																		// cursor
																		// to
																		// just
																		// previous
																		// row

					vo.setStrLevelType(String.valueOf(i));
					if (i % 2 == 0) {
						vo.setStrHierDtlWS(vo.getStrHierDtlAdminWS());
					} else {
						vo.setStrHierDtlWS(vo.getStrHierDtlStoreWS());
					}
					vo.setStrTemp(vo.getStrCaptionName()[i - 1]);// for
																	// getting
																	// specific
																	// caption
																	// name::level
																	// type Name
					if (i == 1)
						strRes = AuthorityHierDtlHLP
								.heirdetails(vo, strPrevRec);
					else
						strRes = strRes
								+ "###"
								+ AuthorityHierDtlHLP.heirdetails(vo,
										strPrevRec);
				}
				// storing previous values of records in
				// format:-levelTyp^AppId^Lev^AuthNo@@< Next Record >
				vo.setStrPrevRecordsSel(strPrevRecordsSel);// just for future
															// reference

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						strRes + "####" + vo.getStrUpdateAuthNo());
			}
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = ""
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AuthorityHierDtlDATA->heirdetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}
	
	/*
	 * This method is added to get data Heirarchy Dtls in new BS page added by swapnil
	 */
	public static void heirdetails_BS(AuthorityHierDtlFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		AuthorityHierDtlBO bo = null;
		AuthorityHierDtlVO vo = null;
	//	HisUtil hisutil = null;
		String strPrevRec = "0";
		String strPrevRecordsSel = "0";
		String strRes = "0";
		String strmsgText = "";
		try {
			bo = new AuthorityHierDtlBO();
			vo = new AuthorityHierDtlVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatId = request.getSession().getAttribute("SEATID")
					.toString();
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrFrmStoreId(request.getParameter("storeId"));
			vo.setStrItemCatCmb(request.getParameter("itemCatNo"));
			vo.setStrReqTypeCmb(request.getParameter("reqTypeId"));
			bo.heirdetails(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				for (int i = 1; i <= 4; i++) {
					strPrevRec = "0";
					if (vo.getStrPrevHierDtlWS().size() != 0) {
						while (vo.getStrPrevHierDtlWS().next()) {

							if (vo.getStrPrevHierDtlWS().getString(1).equals(
									String.valueOf(i))) {

								if (strPrevRec.equals("0")) {
									strPrevRec = vo.getStrPrevHierDtlWS()
											.getString(2);
									strPrevRecordsSel = i
											+ "^"
											+ vo.getStrPrevHierDtlWS()
													.getString(2);
								} else {
									strPrevRec = strPrevRec
											+ "@@"
											+ vo.getStrPrevHierDtlWS()
													.getString(2);
									strPrevRecordsSel = strPrevRecordsSel
											+ "@@"
											+ i
											+ "^"
											+ vo.getStrPrevHierDtlWS()
													.getString(2);
								}
							}
						}
					}
					if (vo.getStrPrevHierDtlWS().getRow() == 1)
						vo.getStrPrevHierDtlWS().beforeFirst();
					else
						vo.getStrPrevHierDtlWS().absolute(
								vo.getStrPrevHierDtlWS().getRow() - 1);// moves
																		// the
																		// webRowset
																		// cursor
																		// to
																		// just
																		// previous
																		// row

					vo.setStrLevelType(String.valueOf(i));
					if (i % 2 == 0) {
						vo.setStrHierDtlWS(vo.getStrHierDtlAdminWS());
					} else {
						vo.setStrHierDtlWS(vo.getStrHierDtlStoreWS());
					}
					vo.setStrTemp(vo.getStrCaptionName()[i - 1]);// for
																	// getting
																	// specific
																	// caption
																	// name::level
																	// type Name
					if (i == 1)
						strRes = AuthorityHierDtlHLP
								.heirdetails_BS(vo, strPrevRec);
					else
						strRes = strRes
								+ "###"
								+ AuthorityHierDtlHLP.heirdetails_BS(vo,
										strPrevRec);
				}
				// storing previous values of records in
				// format:-levelTyp^AppId^Lev^AuthNo@@< Next Record >
				vo.setStrPrevRecordsSel(strPrevRecordsSel);// just for future
															// reference

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						strRes + "####" + vo.getStrUpdateAuthNo());
			}
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = ""
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AuthorityHierDtlDATA->heirdetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}

	/**
	 * Method is Used to Insert Data in DataBase Table HSTT_BREAKAGE_DTL &
	 * HSTT_BREAKAGE_ITEM_DTL Breakage Item Detail Transaction.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */

	public static void INSERT(AuthorityHierDtlFB formBean,
			HttpServletRequest request) {
		AuthorityHierDtlBO bo = null;
		AuthorityHierDtlVO vo = null;
		String strmsgText = "";
	//	MmsConfigUtil mcu = null;
		String tmp[] = null;
		/*
		 * String strFinancialStartYear = "";
		 * 
		 * String strFinancialEndYear = "";
		 */

		try {
			bo = new AuthorityHierDtlBO();
			vo = new AuthorityHierDtlVO();
			/*
			 * mcu = new MmsConfigUtil();
			 * 
			 * strFinancialStartYear = mcu.getStrFinancialStartDate();
			 * strFinancialEndYear = mcu.getStrFinancialEndDate();
			 */

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			vo = (AuthorityHierDtlVO) TransferObjectFactory.populateData(
					"mms.masters.vo.AuthorityHierDtlVO", formBean);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			tmp = formBean.getStrStoreName().replace('^', '#').split("#");
			vo.setStrFrmStoreId(tmp[0]);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatCmb(formBean.getStrItemCatCmb());
			vo.setStrReqTypeCmb(formBean.getStrReqTypeCmb());
			// vo.setStrFinancialStartYear("01-Apr-2009");//mcu.getStrFinancialStartDate());
			// vo.setStrFinancialEndYear("01-Apr-2010");//mcu.getStrFinancialEndDate());
			// vo.setItemParamValue(formBean.getItemParamValue());

			/*
			 * vo.setStrBkgEntryDate(formBean.getStrBkgEntryDate());
			 * vo.setStrBkgQty(formBean.getStrBkgQty());
			 * vo.setStrUnitName(formBean.getStrUnitName());
			 * vo.setStrRemarks(formBean.getStrRemarks());
			 * vo.setStrStoreName(formBean.getStrStoreName());
			 * vo.setStrFinancialEndYear(strFinancialEndYear);
			 * vo.setStrFinancialStartYear(strFinancialStartYear);
			 */

			bo.INSERT(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrMsg("Hierarchy Details Saved Successfully");
			}

		} catch (Exception e) {
			strmsgText = "AuthorityHierDtlDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AuthorityHierDtlDATA->INSERT()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	public static void getRemarks(AuthorityHierDtlFB formBean,
			HttpServletRequest request, HttpServletResponse response) {
		AuthorityHierDtlBO bo = null;
		AuthorityHierDtlVO vo = null;
	//	HisUtil hisutil = null;
		//String strPrevRec = "0";
		//String strPrevRecordsSel = "0";
		//String strRes = "0";
		String strmsgText = "";
		try {
			bo = new AuthorityHierDtlBO();
			vo = new AuthorityHierDtlVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatId = request.getSession().getAttribute("SEATID")
					.toString();
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrFrmStoreId(request.getParameter("storeId"));
			vo.setStrItemCatCmb(request.getParameter("itemCatNo"));
			vo.setStrReqTypeCmb(request.getParameter("reqTypeId"));
			bo.getRemarks(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(vo.getStrRemarks()+"^"+vo.getStrApprovalFlag());
			}
		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = ""
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AuthorityHierDtlDATA->heirdetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		
	}

}
