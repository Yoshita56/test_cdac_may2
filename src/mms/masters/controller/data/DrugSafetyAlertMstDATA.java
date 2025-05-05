package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.masters.bo.DrugSafetyAlertMstBO;
import mms.masters.controller.fb.DrugSafetyAlertMstFB;
import mms.masters.controller.hlp.DrugSafetyAlertMstHLP;
import mms.masters.vo.DrugSafetyAlertMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugSafetyAlertMstDATA.
 */
public class DrugSafetyAlertMstDATA {
	
	/**
	 * to display the Store Type Name on Add page or modify page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(DrugSafetyAlertMstFB formBean,
			HttpServletRequest request) {
		DrugSafetyAlertMstBO bo = null;
		DrugSafetyAlertMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String str2 = "";
		String strCtDate = "";
		try {
			hisutil = new HisUtil("mms", "DrugSaftyAlertMstDAO");
			bo = new DrugSafetyAlertMstBO();
			vo = new DrugSafetyAlertMstVO();

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			// String strStoreTypeId =
			// request.getSession().getAttribute("strStoreTypeId").toString();
			//
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			// formBean.setStrStoreTypeId(strStoreTypeId);
			//
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			// vo.setStrStoreTypeId(strStoreTypeId);
			strCtDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(strCtDate);
			bo.initialAdd(vo);
			str2 = hisutil.getOptionValue(vo.getStrGroupNameComboValuesWS(),
					"-1", "0^Select Value", true);

			vo.setStrGroupNameCombo(str2);

			String str = DrugSafetyAlertMstHLP.getProcessUnProcessDtl(vo
					.getStrDataWs());

			formBean.setStrItemDtlHlp(str);
			// formBean.setStrDrugNameCombo(vo.getStrDrugNameCombo());

			formBean.setStrGroupNameCombo(vo.getStrGroupNameCombo());

			// //System.out.println("In DATA:::"+vo.getStrRemarks());
			// //System.out.println("Effe Frm:::"+vo.getStrEffectiveFrom());
			// formBean.setStrRemarks(vo.getStrRemarks());
			// formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			// formBean.setStrStoreTypeName(vo.getStrStoreTypeName());

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "DrugSaftyAlertMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugSaftyAlertMstDATA->initialAdd()", strmsgText);
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
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void UNITVAL1(HttpServletRequest request,
			HttpServletResponse response, DrugSafetyAlertMstFB formBean) {
		// Declaring Variables

		String strmsgText = "";
		String strChk = null;
		String strRes = null;

		// Creating Object for BO & VO.
		DrugSafetyAlertMstBO bo = null;
		DrugSafetyAlertMstVO vo = null;

		HisUtil hisutil = null;
		String str2 = "";
		try {
			vo = new DrugSafetyAlertMstVO();
			bo = new DrugSafetyAlertMstBO();
			hisutil = new HisUtil("mms", "DrugSaftyAlertMstDAO");
			strChk = request.getParameter("GroupId");

			vo.setStrGroupId(strChk);
			vo.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			// Call BO TariffCombo Method
			bo.getSubGroupCombo(vo);
			// TariffName Combo
			str2 = hisutil.getOptionValue(vo.getStrSubGroupNameComboValuesWS(),
					"-1", "0^Select Value", true);

			vo.setStrSubGroupNameCombo(str2);

			try {

				response.setHeader("Cache-Control", "no-cache");
				strRes = vo.getStrSubGroupNameCombo();
				response.getWriter().print(strRes);
			} catch (Exception e) {

			}

		} catch (Exception e) {
			strmsgText = "DrugSaftyAlertMstDATA.UNITVAL1(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugSaftyAlertMstDATA->UNITVAL1()", strmsgText);
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
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void UNITVAL2(HttpServletRequest request,
			HttpServletResponse response, DrugSafetyAlertMstFB formBean) {
		// Declaring Variables

		String strmsgText = "";
		String strChk = null;
		String strRes = null;

		// Creating Object for BO & VO.
		DrugSafetyAlertMstBO bo = null;
		DrugSafetyAlertMstVO vo = null;

		HisUtil hisutil = null;
		String str2 = "";
		try {
			vo = new DrugSafetyAlertMstVO();
			bo = new DrugSafetyAlertMstBO();
			hisutil = new HisUtil("mms", "DrugSaftyAlertMstDAO");
			strChk = request.getParameter("GroupId");
			vo.setStrGrpId(strChk);
			strChk = request.getParameter("SubGroupId");
			vo.setStrSubGrpId(strChk);
			vo.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			// Call BO TariffCombo Method
			bo.getDrugCombo(vo);
			// TariffName Combo
			str2 = hisutil.getOptionValue(vo.getStrDrugNameComboValuesWS(),
					"-1", "0^Select Value", true);

			vo.setStrDrugNameCombo(str2);

			try {

				response.setHeader("Cache-Control", "no-cache");
				strRes = vo.getStrDrugNameCombo();
				response.getWriter().print(strRes);
			} catch (Exception e) {

			}

		} catch (Exception e) {
			strmsgText = "DrugSaftyAlertMstDATA.UNITVAL2(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugSaftyAlertMstDATA->UNITVAL2()", strmsgText);
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
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insertRecord(DrugSafetyAlertMstFB formBean,
			HttpServletRequest request) {
		DrugSafetyAlertMstBO bo = null;
		DrugSafetyAlertMstVO vo = null;
		String strCtDate = "";
		String strmsgText = "";
		HisUtil util = null;
		try {
			bo = new DrugSafetyAlertMstBO();
			vo = new DrugSafetyAlertMstVO();

			util = new HisUtil("IssueToEmployeeTransDATA",
					"IssueToEmployeeTransDATA");
			strCtDate = util.getASDate("dd-MMM-yyyy");

			formBean.setStrCtDate(strCtDate);
			vo.setStrCtDate(strCtDate);
			String strHospitalCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			// String strStoreTypeId =
			// request.getSession().getAttribute("strStoreTypeId").toString();

			// //System.out.println("Grp Name is :::"+formBean.getStrGroupName());
			// //System.out.println("Sub-Grp Name is
			// :::"+formBean.getStrSubGroupName());
			// //System.out.println("Drug Name is :::"+formBean.getStrDrugName());
			// //System.out.println("Rmkis:::"+formBean.getStrRemarks());
			// //System.out.println("Ef From:::"+formBean.getStrEffectiveFrom());

			vo.setStrAddedData(formBean.getStrAddedData());
			vo.setStrGrpId(formBean.getStrGroupName());
			vo.setStrSubGrpId(formBean.getStrSubGroupName());
			vo.setStrItemId(formBean.getStrDrugName());
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
			strmsgText = "DrugSaftyAlertMaster.DrugSaftyAlertMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugSaftyAlertMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			util = null;
		}

	}

	/**
	 * to update the record.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(DrugSafetyAlertMstFB formBean,
			HttpServletRequest request) {
		DrugSafetyAlertMstBO bo = null;
		DrugSafetyAlertMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		try {
			bo = new DrugSafetyAlertMstBO();
			vo = new DrugSafetyAlertMstVO();

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

			strmsgText = "DrugSaftyAlertMaster.DrugSaftyAlertMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugSaftyAlertMstDATA->updateRecord()", strmsgText);
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
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void modifyRecord(DrugSafetyAlertMstFB formBean,
			HttpServletRequest request) {
		DrugSafetyAlertMstBO bo = null;
		DrugSafetyAlertMstVO vo = null;
		String strmsgText = "";
		String str = "";
		try {
			bo = new DrugSafetyAlertMstBO();
			vo = new DrugSafetyAlertMstVO();

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			formBean.setStrHospitalCode(hosCode);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			// vo.setStrStoreTypeId(strStoreTypeId);

			vo.setStrChk1(request.getParameter("chk"));
			formBean.setStrChk1(request.getParameter("chk"));
			bo.initialModify(vo);
			if (formBean.getStrGetView().equals("1")) {
				str = DrugSafetyAlertMstHLP.getProcessUnProcessDtl2(vo
						.getStrDataWs(), vo.getStrAddedDataWs());
			} else {
				str = DrugSafetyAlertMstHLP.getProcessUnProcessDtl1(vo
						.getStrDataWs(), vo.getStrAddedDataWs());
			}
			formBean.setStrItemDtlHlp(str);
			formBean.setStrDrugName(vo.getStrDrugName());
			formBean.setStrSubGroupName(vo.getStrSubGroupName());
			formBean.setStrGroupName(vo.getStrGroupName());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());

		} catch (Exception e) {

			strmsgText = "DrugSaftyAlertMaster.DrugSaftyAlertMstDATA.modifyRecord(vo) --> "
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
