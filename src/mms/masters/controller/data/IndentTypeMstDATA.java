package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.masters.bo.IndentTypeMstBO;

import mms.masters.controller.fb.IndentTypeMstFB;

import mms.masters.vo.IndentTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentTypeMstDATA.
 * 
 * @author Anshul Jindal
 */

public class IndentTypeMstDATA {

	/**
	 * to display the current date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(IndentTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		String strStoreTypeName = "";
		String[] temp = null;
		try {
			hisutil = new HisUtil("mms", "IndentTypeMstDATA");

			String comboValue = request.getParameter("comboValue");
			temp = comboValue.replace("^", "#").split("#");

			strStoreTypeName = temp[0];
			formBean.setStrStoreTypeName(strStoreTypeName);

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

		} catch (Exception e) {
			strmsgText = "IndentTypeMaster.IndentTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentTypeMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			hisutil = null;
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insertRecord(IndentTypeMstFB formBean,
			HttpServletRequest request) {
		IndentTypeMstBO bo = null;
		IndentTypeMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new IndentTypeMstBO();
			vo = new IndentTypeMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strStoreTypeId = formBean.getCombo()[0];

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrStoreTypeId(strStoreTypeId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrIsValid("1");

			vo.setStrIndentTypeName(formBean.getStrIndentTypeName());
			vo.setStrIndentTypeTime(formBean.getStrIndentTypeTime());
			vo.setStrIndentTypeTimeUnit(formBean.getStrIndentTypeTimeUnit());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());

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

			strmsgText = "IndentTypeMaster.IndentTypeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentTypeMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(IndentTypeMstFB formBean,
			HttpServletRequest request) {
		IndentTypeMstBO bo = null;
		IndentTypeMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;
		String strStoreTypeName = "";
		String[] temp = null;

		try {
			hisutil = new HisUtil("mms", "IndentTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String comboValue = request.getParameter("comboValue");
			temp = comboValue.replace("^", "#").split("#");

			strStoreTypeName = temp[0];
			formBean.setStrStoreTypeName(strStoreTypeName);

			bo = new IndentTypeMstBO();
			vo = new IndentTypeMstVO();
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrIndentTypeId(strtemp[1]);

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			String strStoreTypeId = formBean.getCombo()[0];

			vo.setStrSeatId(seatid);
			vo.setStrStoreTypeId(strStoreTypeId);

			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrStoreTypeId(vo.getStrStoreTypeId());
			formBean.setStrIndentTypeName(vo.getStrIndentTypeName());
			formBean.setStrIndentTypeTime(vo.getStrIndentTypeTime());
			formBean.setStrIndentTypeTimeUnit(vo.getStrIndentTypeTimeUnit());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "IndentTypeMaster.IndentTypeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentTypeMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(IndentTypeMstFB formBean,
			HttpServletRequest request) {
		IndentTypeMstBO bo = null;
		IndentTypeMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		try {
			bo = new IndentTypeMstBO();
			vo = new IndentTypeMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			String strStoreTypeId = formBean.getCombo()[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrIndentTypeId(strtemp[1]);
			vo.setStrSeatId(seatid);
			vo.setStrStoreTypeId(strStoreTypeId);

			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrIndentTypeName(formBean.getStrIndentTypeName());
			vo.setStrIndentTypeTime(formBean.getStrIndentTypeTime());
			vo.setStrIndentTypeTimeUnit(formBean.getStrIndentTypeTimeUnit());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

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

			strmsgText = "IndentTypeMaster.IndentTypeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentTypeMstDATA->updateRecord()", strmsgText);
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
