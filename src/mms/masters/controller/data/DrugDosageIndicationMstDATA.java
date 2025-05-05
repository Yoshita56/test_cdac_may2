package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.masters.bo.DrugDosegeIndicationMstBO;
import mms.masters.controller.fb.DrugDosageIndicationMstFB;
import mms.masters.controller.hlp.DrugDosageIndicationMstHLP;
import mms.masters.vo.DrugDosegeIndicationMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugDosageIndicationMstDATA.
 */
public class DrugDosageIndicationMstDATA {

	/**
	 * to display the Store Type Name on Add page or modify page.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void initialAdd(DrugDosageIndicationMstFB formBean,
			HttpServletRequest request) {

		DrugDosegeIndicationMstBO bo = null;
		DrugDosegeIndicationMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String str2 = "";
		String strCtDate = "";
		try {
			hisutil = new HisUtil("mms", "DrugDosegeIndicationMstDAO");
			bo = new DrugDosegeIndicationMstBO();
			vo = new DrugDosegeIndicationMstVO();

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			// String strStoreTypeId =
			// request.getSession().getAttribute("strStoreTypeId").toString();

			strCtDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(strCtDate);

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			bo.initialAdd(vo);
			str2 = hisutil.getOptionValue(vo.getStrGroupNameComboValuesWS(),
					"-1", "0^Select Value", true);
			if (str2 != null) {
				vo.setStrGroupNameCombo(str2);
			} else {
				str2 = "<option value='0'>DATA N/A</option>";
				vo.setStrGroupNameCombo(str2);
			}

			String str = DrugDosageIndicationMstHLP.getProcessUnProcessDtl(vo
					.getStrDataWs());

			formBean.setStrItemDtlHlp(str);
			formBean.setStrGroupNameCombo(vo.getStrGroupNameCombo());

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			// formBean.setStrStoreTypeName(vo.getStrStoreTypeName());

		} catch (Exception e) {

			strmsgText = "DrugDosegeIndicationMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugDosegeIndicationMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * ***************************Ajax Function for View
	 * Charges(Combo)**********************************.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void UNITVAL1(HttpServletRequest request,
			HttpServletResponse response, DrugDosageIndicationMstFB formBean) {
		// Declaring Variables
		// String strTariffCombo = "";
		String strmsgText = "";
		String strChk = null;
		// String strRes = null;

		// Creating Object for BO & VO.
		DrugDosegeIndicationMstBO bo = null;
		DrugDosegeIndicationMstVO vo = null;

		HisUtil hisutil = null;
		String str2 = "";
		try {
			vo = new DrugDosegeIndicationMstVO();
			bo = new DrugDosegeIndicationMstBO();
			hisutil = new HisUtil("mms", "DrugDosegeIndicationMstDATA");
			strChk = request.getParameter("GroupId");

			vo.setStrGroupId(strChk);
			vo.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			// Call BO TariffCombo Method
			bo.getSubGroupCombo(vo);
			// TariffName Combo

			str2 = hisutil.getOptionValue(vo.getStrSubGroupNameComboValuesWS(),
					"-1", "0^Select Value", true);

			try {

				response.setHeader("Cache-Control", "no-cache");

				response.getWriter().print(str2);
			} catch (Exception e) {

			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugDosegeIndicationMstDATA->UNITVAL()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
			if (bo != null)
				bo = null;
		}

	}

	/**
	 * UNITVA l2.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param formBean
	 *            the form bean
	 */
	public static void UNITVAL2(HttpServletRequest request,
			HttpServletResponse response, DrugDosageIndicationMstFB formBean) {
		// Declaring Variables
		// String strTariffCombo = "";
		String strmsgText = "";
		String strChk = null;
		// String strRes = null;

		// Creating Object for BO & VO.
		DrugDosegeIndicationMstBO bo = null;
		DrugDosegeIndicationMstVO vo = null;

		HisUtil hisutil = null;
		String str2 = null;
		try {
			vo = new DrugDosegeIndicationMstVO();
			bo = new DrugDosegeIndicationMstBO();
			hisutil = new HisUtil("mms", "DrugDosegeIndicationMstDATA");
			strChk = request.getParameter("GroupId");
			vo.setStrGrpId(strChk);
			strChk = request.getParameter("SubGroupId");
			vo.setStrSubGrpId(strChk);
			// // //System.out.println("sub group id:::"+strChk);
			vo.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			// Call BO TariffCombo Method
			bo.getDrugCombo(vo);
			// TariffName Combo
			str2 = hisutil.getOptionValue(vo.getStrDrugNameComboValuesWS(),
					"-1", "0^Select Value", true);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(str2);
			} catch (Exception e) {

			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugDosegeIndicationMstDATA->UNITVAL()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
			if (bo != null)
				bo = null;
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void insertRecord(DrugDosageIndicationMstFB formBean,
			HttpServletRequest request) {
		DrugDosegeIndicationMstBO bo = null;
		DrugDosegeIndicationMstVO vo = null;
		String strmsgText = "";
		try {

			bo = new DrugDosegeIndicationMstBO();
			vo = new DrugDosegeIndicationMstVO();

			String strHospitalCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			// String strStoreTypeId =
			// request.getSession().getAttribute("strStoreTypeId").toString();

			// //System.out.println("strStoreTypeId--.>>"+strStoreTypeId);

			// //System.out.println("Grp Name is :::"+formBean.getStrGroupName());
			// //System.out.println("Sub-Grp Name is
			// :::"+formBean.getStrSubGroupName());
			// //System.out.println("Drug Name is :::"+formBean.getStrDrugName());
			// //System.out.println("Rmkis:::"+formBean.getStrRemarks());
			// //System.out.println("Ef From:::"+formBean.getStrEffectiveFrom());

			vo.setStrAddedData(formBean.getStrAddedData());
			vo.setStrGrpId(formBean.getStrGroupName());
			vo.setStrSubGrpId(formBean.getStrSubGroupName());
			vo.setStrItemID(formBean.getStrDrugName());
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(seatid);
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());

			bo.insertRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) {
				formBean.setStrWarning("Data already exist");
			} else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "DrugSaftyAlertMaster.DrugDosegeIndicationMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugDosegeIndicationMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * to update the record.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(DrugDosageIndicationMstFB formBean,
			HttpServletRequest request) {
		DrugDosegeIndicationMstBO bo = null;
		DrugDosegeIndicationMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		try {
			bo = new DrugDosegeIndicationMstBO();
			vo = new DrugDosegeIndicationMstVO();

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			// // //System.out.println("Chk in
			// UPDATE::::"+request.getParameter("chk"));
			formBean.setStrChk1(request.getParameter("chk"));
			vo.setStrHospitalCode(hosCode);
			vo.setStrChk1(request.getParameter("chk"));
			vo.setStrSeatId(seatid);
			vo.setStrAddedData(formBean.getStrAddedData());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			// TransferObjectFactory.populateData(formBean, vo);

			// if (vo.getBExistStatus() == false)
			// {
			// formBean.setStrWarning("Data already exist");
			// retValue = false;
			// }
			else {
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				} else {
					formBean.setStrMsg("Record Modify Successfully");
				}
			}

		} catch (Exception e) {

			strmsgText = "DrugDosegeIndicationMaster.DrugDosegeIndicationMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugDosegeIndicationMstDATA->updateRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

	/**
	 * to get the data for modify page.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void modifyRecord(DrugDosageIndicationMstFB formBean,
			HttpServletRequest request) {
		DrugDosegeIndicationMstBO bo = null;
		DrugDosegeIndicationMstVO vo = null;
		String strmsgText = "";
		String str = "";
		try {
			bo = new DrugDosegeIndicationMstBO();
			vo = new DrugDosegeIndicationMstVO();

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			formBean.setStrHospitalCode(hosCode);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			// vo.setStrStoreTypeId(strStoreTypeId);

			vo.setStrChk1(request.getParameter("chk"));
			formBean.setStrChk1(request.getParameter("chk"));
			// // //System.out.println("Inside DATA::");
			bo.initialModify(vo);
			if (formBean.getStrGetView().equals("1")) {
				str = DrugDosageIndicationMstHLP.getProcessUnProcessDtl2(
						vo.getStrDataWs(), vo.getStrAddedDataWs());
			} else {
				str = DrugDosageIndicationMstHLP.getProcessUnProcessDtl1(
						vo.getStrDataWs(), vo.getStrAddedDataWs());
			}
			formBean.setStrItemDtlHlp(str);
			formBean.setStrDrugName(vo.getStrDrugName());
			formBean.setStrSubGroupName(vo.getStrSubGroupName());
			formBean.setStrGroupName(vo.getStrGroupName());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());

		} catch (Exception e) {

			strmsgText = "DrugSaftyAlertMaster.DrugDosegeIndicationMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugSaftyAlertMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

}
