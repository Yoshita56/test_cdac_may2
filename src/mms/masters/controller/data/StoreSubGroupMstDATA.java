package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.StoreSubGroupMstBO;
import mms.masters.controller.fb.StoreSubGroupMstFB;
import mms.masters.vo.StoreSubGroupMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreSubGroupMstDATA.
 */
public class StoreSubGroupMstDATA {

	/**
	 * to display the Group Name combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(StoreSubGroupMstFB formBean,
			HttpServletRequest request) {

		HisUtil hisutil = null;
		StoreSubGroupMstBO bo = null;
		StoreSubGroupMstVO vo = null;
		String strmsgText = "";
		String cmb = "";
		String[] strArr_combo =null; // holds the combo array of formBean
		try {
			String strItemCatName = request.getParameter("comboValue");
			formBean.setStrItemCatName(strItemCatName);

			hisutil = new HisUtil("mms", "StoreSubGroupMstDATA");
			bo = new StoreSubGroupMstBO();
			vo = new StoreSubGroupMstVO();

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			String strItemCatId = formBean.getCombo()[0];
			hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrItemCatId(strItemCatId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatId(strItemCatId);
			
			/*
			 * Retrieving individual data from combo array.
			 */
			strArr_combo = formBean.getCombo();
			vo.setStrItemCatId(strArr_combo[0]);
			vo.setStrGroupId(strArr_combo[1]);
			
			
			bo.initAdd(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			/*
			 * This is deactivated by Aritra on 1st June, 2010.
			 * Reason: Group is name not selected with previous value.
			 * *******************************************************
			 if (vo.getStrGrpNameComboWS() != null) {
				cmb = hisutil.getOptionValue(vo.getStrGrpNameComboWS(),
						"0^Select Value", "Select Value", true);
			}
			*/
			/*
			 * This code is added by Aritra on 1st June, 2010
			 * Reason: To generate preselected drop-down list for Groupname.
			 * ************************************************************
			 */
			if (vo.getStrGrpNameComboWS() != null) {
				cmb = hisutil.getOptionValue(vo.getStrGrpNameComboWS(),vo.getStrGroupId(),
						"0^Select Value",  false);
			}
			
			
			vo.setStrGroupNameCombo(cmb);

			formBean.setStrItemCatName(vo.getStrItemCatName());
			formBean.setStrGroupNameCombo(vo.getStrGroupNameCombo());

		} catch (Exception e) {

			strmsgText = "SubGroupTypeMaster.StoreSubGroupMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreSubGroupMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insertRecord(StoreSubGroupMstFB formBean,
			HttpServletRequest request) {
		StoreSubGroupMstBO bo = null;
		StoreSubGroupMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new StoreSubGroupMstBO();
			vo = new StoreSubGroupMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			String strItemCatId = formBean.getCombo()[0];
			hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrItemCatId(strItemCatId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatId(strItemCatId);

			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupName(formBean.getStrSubGroupName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid("1");

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

			strmsgText = "SubGroupTypeMaster.StoreSubGroupMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreSubGroupMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * to get the data for modify page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void modifyRecord(StoreSubGroupMstFB formBean,
			HttpServletRequest request) {

		StoreSubGroupMstBO bo = null;
		StoreSubGroupMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;
		try {
			String strItemCatName = request.getParameter("comboValue");
			formBean.setStrItemCatName(strItemCatName);

			hisutil = new HisUtil("mms", "StoreSubGroupMstDATA");
			bo = new StoreSubGroupMstBO();
			vo = new StoreSubGroupMstVO();

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			// 100@181000100@1$1
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace("$", "#").split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			String strItemCatId = formBean.getCombo()[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrSubGroupId(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatId(strItemCatId);

			bo.modifyRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrGroupName(vo.getStrGroupName());

			formBean.setStrSubGroupName(vo.getStrSubGroupName());

			formBean.setStrSeatId(vo.getStrSeatId());

			formBean.setStrIsValid(vo.getStrIsValid());

			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());

			formBean.setStrRemarks(vo.getStrRemarks());

			formBean.setStrChk1(chk);
			formBean.setStrItemCatName(vo.getStrItemCatName());

		} catch (Exception e) {

			strmsgText = "SubGroupTypeMaster.StoreSubGroupMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreSubGroupMstDATA->modifyRecord()", strmsgText);
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
	 * @param formBean the form bean
	 * @param request the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(StoreSubGroupMstFB formBean,
			HttpServletRequest request) {

		boolean retValue = true;
		StoreSubGroupMstBO bo = null;
		StoreSubGroupMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		try {
			bo = new StoreSubGroupMstBO();
			vo = new StoreSubGroupMstVO();
			// 100@181000100@1$1
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace("$", "#").split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			String strItemCatId = formBean.getCombo()[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrSubGroupId(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatId(strItemCatId);

			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrSubGroupName(formBean.getStrSubGroupName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			// TransferObjectFactory.populateData(formBean, vo);

			if (vo.getBExistStatus() == false) {
				formBean.setStrWarning("Data already exist");
				retValue = false;
			} else {
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				} else {
					formBean.setStrMsg("Record Modify Successfully");
				}
			}

		} catch (Exception e) {

			strmsgText = "SubGroupTypeMaster.StoreSubGroupMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreSubGroupMstDATA->updateRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

}
