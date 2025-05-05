package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.PatientDtlHLP;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.RequestForLPStaffBO;
import mms.transactions.controller.fb.RequestForLPStaffFB;
import mms.transactions.vo.RequestForLPStaffVO;

public class RequestForLPStaffDATA {
	/**
	 * Method is Used to Populate the Data for Save Page of Issue To Patient
	 * Transaciton ADD Page
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void GetData(RequestForLPStaffFB formBean,
			HttpServletRequest request) {
		RequestForLPStaffBO bo = null;
		RequestForLPStaffVO vo = null;
		String strmsgText = "";
		HisUtil util = null;
		String[] combo = null;
		String strStoreId = "";
		String strStoreTypeId = "";
		String strReqType = "";
		String strItemCategoryNo = "";
		String path = "";
		try {
			bo = new RequestForLPStaffBO();
			vo = new RequestForLPStaffVO();
			util = new HisUtil("RequestForLPStaffDATA", "RequestForLPStaffDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;

			path = "/mms" + request.getParameter("cnt_page") + ".cnt";
			if (request.getParameter("cnt_page") == null) {

				path = request.getParameter("strPath");
			}

			formBean.setStrPath(path.trim());

			combo = request.getParameterValues("combo");

			String[] strTemp = combo[0].split("\\^");

			strStoreId = strTemp[0]; // Store Id
			strStoreTypeId = strTemp[1]; // Store Type ID
			strItemCategoryNo = combo[1]; // Item category
			String[] strTemp1 = combo[2].split("\\^");

			strReqType = strTemp1[1]; // Request Type ID

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatId = request.getSession().getAttribute("SEATID")
					.toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrCtDate(strCtDate);
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrReqType(strReqType);

			bo.GetData(vo);
			formBean.setStrItemCatg(vo.getStrItemCatg());
			formBean.setStrTmpItemCatg(strItemCategoryNo);
			formBean.setStrStoreTypeId(vo.getStrStoreTypeId());
			formBean.setStrReqDate(strCtDate);
			formBean.setStrTmpReqType(vo.getStrReqType());
			formBean.setStrItemCatgCombo(vo.getStrItemCatgCombo());
			formBean
					.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
			formBean.setStrTmpStoreName(strStoreId);
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
			formBean.setStrGrantTypeCombo(vo.getStrGrantTypeCombo());
			formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "RequestForLPStaffDATA.GetData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RequestForLPStaffDATA->GetData()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * Method is Used to Populate the Data for Save Page of Indent Transaciton
	 * ADD Page
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void GetData1(RequestForLPStaffFB formBean,
			HttpServletRequest request) {
		RequestForLPStaffBO bo = null;
		RequestForLPStaffVO vo = null;
		String strmsgText = "";
		HisUtil util = null;
		String strCatCode = "";
		String strCostRequired = "";
		MmsConfigUtil mmsConfig = null;
		try {
			bo = new RequestForLPStaffBO();
			vo = new RequestForLPStaffVO();
			mmsConfig = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			/* Here we get Category Code from Configuration File */
			strCatCode = MmsConfigUtil.STAFF_CAT_CODE;
			// Here we get Category Code from Configuration File

			// set cost req or not
			strCostRequired = mmsConfig.getStrCostReq();

			util = new HisUtil("RequestForLPStaffDATA", "RequestForLPStaffDATA");
			String strCtDate = util.getASDate("dd-MMM-yyyy");
			util = null;
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatId = request.getSession().getAttribute("SEATID")
					.toString();
			String strStoreId = request.getParameter("strTmpStoreName");
			String strItemCat = request.getParameter("strTmpItemCatg");
			String CrNo = request.getParameter("strTmpCrNo");
			String strReqType = request.getParameter("strTmpReqType");

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatId);
			vo.setStrStoreId(strStoreId);
			vo.setStrCrNo(CrNo);
			vo.setStrItemCategoryNo(strItemCat);
			vo.setStrReqType(strReqType);

			bo.GetData(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			String dummy1 = PatientDtlHLP.patientWithAdmissionDtl(formBean
					.getStrCrNo(), formBean.getStrHospitalCode(), true);

			formBean.setStrConfigCatCode(strCatCode);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatId);
			formBean.setStrPatientDemDtl(dummy1);
			formBean.setStrReqDate(strCtDate);
			formBean.setStrGoFlg("1");
			formBean.setStrItemCatgCombo(vo.getStrItemCatgCombo());
			formBean
					.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
			formBean.setStrTmpStoreName(strStoreId);
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrToStoreCombo(vo.getStrToStoreCombo());
			formBean.setStrGrantTypeCombo(vo.getStrGrantTypeCombo());
			formBean.setStrRecmndByCombo(vo.getStrRecmndByCombo());
			formBean
					.setStrGroupIdForItemSearch(vo.getStrGroupIdForItemSearch());
			formBean.setStrCostRequired(strCostRequired);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "RequestForLPStaffDATA.GetData1(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RequestForLPStaffDATA->GetData1()", strmsgText);
			String str = "PatientDtlHLP-->patientWithAdmissionDtl-->PatientDtlHLP-->patientDtl-->Invalid CR. No.";
			if (str.trim().equals(e.getMessage().trim())) {
				formBean.setStrErr("Invalid CR. No.!!! ");
			} else {
				formBean.setStrErr("Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "],Contact System Administrator! ");
			}

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * Method is Used to Insert Data in DataBase Table Breakage Item Detail
	 * Transaction
	 * 
	 * @param formBean
	 * @param request
	 */

	public static boolean INSERT(RequestForLPStaffFB formBean,
			HttpServletRequest request) {
		RequestForLPStaffBO bo = null;
		RequestForLPStaffVO vo = null;
		String strmsgText = "";
		MmsConfigUtil mcu = null;
		String[] tmp = null;
		String[] temp1 = null;
		String strFinancialStartYear = "";
		String strFinancialEndYear = "";
		boolean retValue = true;

		try {
			bo = new RequestForLPStaffBO();
			vo = new RequestForLPStaffVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			// strFinancialStartYear = mcu.getStrFinancialStartDate();
			// strFinancialEndYear = mcu.getStrFinancialEndDate();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strReqType = request.getParameter("strTmpReqType");
			String strPath = request.getParameter("strPath");
			String strStoreId = request.getParameter("strTmpStoreName");
			String strStoreTypeId = request.getParameter("strStoreTypeId");
			String strItemCategoryNo = request.getParameter("strTmpItemCatg");
			strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId,
					request.getSession().getAttribute("HOSPITAL_CODE")
							.toString());
			strFinancialEndYear = mcu.getStrFinancialEndDate(strStoreId,
					request.getSession().getAttribute("HOSPITAL_CODE")
							.toString());

			// This Hidden Value We Get From Patient Details HLP
			if (formBean.getStrPatientDtlHidVal() != null
					|| !formBean.getStrPatientDtlHidVal().equals("")) {
				tmp = formBean.getStrPatientDtlHidVal().replace("^", "#")
						.split("#");
				vo.setStrEmpNo(tmp[6].trim());

			} else {
				vo.setStrEmpNo("000");
			}
			if (formBean.getStrAdmissionDtlHidVal() != null
					|| !formBean.getStrAdmissionDtlHidVal().equals("")) {
				temp1 = formBean.getStrAdmissionDtlHidVal().replace("^", "#")
						.split("#");
				vo.setStrAdmnNo(temp1[0].trim());

			} else {
				vo.setStrAdmnNo("000");
			}
			vo.setStrTotalCost(formBean.getStrApproxAmt());
			vo.setStrDiagnosisType(formBean.getStrDiagnosisType());
			vo.setStrProvisionDiagnosis(formBean.getStrProvisionDiagnosis());
			vo.setStrStoreId(strStoreId);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			vo.setStrReqType(strReqType);
			vo.setItemParamValue(formBean.getItemParamValue());
			vo.setStrUnitName(formBean.getStrUnitName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrReqQty(formBean.getStrReqQty());
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrRecmndBy(formBean.getStrRecmndBy());

			/* Commented by Aritra on 19 August,2010 */
			/*
			 * if(formBean.getStrIsUrgent().equals("1")) {
			 * vo.setStrUrgentFlg("1"); } else { vo.setStrUrgentFlg("0"); }
			 */

			/* Added by Aritra on August,2010 */
			if (formBean.getStrIsNormal().equals("0")) {
				vo.setStrUrgentFlg("1");
			} else {
				vo.setStrUrgentFlg("0");
			}
			/* -O- */

			vo.setStrCrNo(formBean.getStrCrNo());
			vo.setStrToStoreCombo(formBean.getStrToStore());

			formBean.setStrGoFlg("0");
			formBean.setStrPath(strPath);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			bo.INSERT(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				formBean.setStrCrNo("");
				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrMsg("Indent Successfully Raised!!");
			}

		} catch (Exception e) {
			e.printStackTrace();
			formBean.setStrCrNo("");
			retValue = false;
			strmsgText = "RequestForLPStaffDATA.INSERT(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"RequestForLPStaffDATA->INSERT()", strmsgText);
			String str = "PatientDtlHLP-->patientDtl-->Invalid CR. No.";
			if (str.trim().equals(e.getMessage().trim())) {
				formBean.setStrErr("Invalid CR. No.!!! ");
			} else {
				formBean.setStrErr("Application Error [ERROR ID : "
						+ eObj.getErrorID()
						+ "],Contact System Administrator! ");
			}

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

	/**
	 * 
	 * @param response
	 */
	public static void initHosiptalDiagnosis(HttpServletResponse response,
			RequestForLPStaffFB formBean) {

		RequestForLPStaffVO vo = new RequestForLPStaffVO();
		RequestForLPStaffBO bo = new RequestForLPStaffBO();

		bo.setHospitalDiagnosis(vo);

		HisUtil util = new HisUtil("Admission Advice Trans",
				"RequestForLPStaffDATA");

		try {

			String strHospitalDiagnosis = util.getOptionValue(vo
					.getHospitalDiagnosisWs(), "0", "0^Select Value", false);
			if (vo.getStrMsgType().equals("0")) {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strHospitalDiagnosis);
			} else {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("IPD",
					"RequestForLPStaffDATA->initHosiptalDiagnosis()",
					strmsgText);
			formBean.setStrMsgString("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	/**
	 * 
	 * @param response
	 */
	public static void initIcdDiagnosis(HttpServletResponse response,
			RequestForLPStaffFB formBean) {

		RequestForLPStaffVO vo = new RequestForLPStaffVO();
		RequestForLPStaffBO bo = new RequestForLPStaffBO();

		bo.setIcdDiagnosis(vo);

		HisUtil util = new HisUtil("Admission Advice Trans",
				"RequestForLPStaffDATA");

		try {

			String strIcdDiagnosis = util.getOptionValue(vo
					.getIcd10DiagnosisWs(), "0", "0^Select Value", false);
			if (vo.getStrMsgType().equals("0")) {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strIcdDiagnosis);
			} else {
				throw new Exception(vo.getStrMsgString());
			}
		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("IPD",
					"RequestForLPStaffDATA->initIcdDiagnosis()", strmsgText);
			formBean.setStrMsgString("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

}
