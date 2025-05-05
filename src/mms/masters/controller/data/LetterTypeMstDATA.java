package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.LetterTypeMstBO;
import mms.masters.controller.fb.LetterTypeMstFB;
import mms.masters.vo.LetterTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer - Tanvi Sappal Version - 1.0 Changes Done on 21/April/2009
 */

public class LetterTypeMstDATA {

	/**
	 * to display the current date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(LetterTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			String strStoreTypeName = request.getParameter("comboValue");
			formBean.setStrStoreTypeName(strStoreTypeName);

			hisutil = new HisUtil("mms", "LetterTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

		} catch (Exception e) {
			strmsgText = "LetterTypeMaster.LetterTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LetterTypeMstDATA->initialAdd()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
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

	public static void insertRecord(LetterTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		LetterTypeMstVO vo = null;
		LetterTypeMstBO bo = null;

		try {
			bo = new LetterTypeMstBO();
			vo = new LetterTypeMstVO();

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strStoreTypeId = formBean.getCombo()[0];

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrStoreTypeId(strStoreTypeId);

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrIsValid("1");

			vo.setStrLetterTypeName(formBean.getStrLetterTypeName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrLetterTypeId(formBean.getStrLetterTypeId());

			bo.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) {
				formBean.setStrWarning("Data already exist");
			} else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			strmsgText = "LetterTypeMaster.LetterTypeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LetterTypeMstDATA->insertRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			vo = null;
			bo = null;
		}

	}

	/**
	 * to get the data for modify page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void modifyRecord(LetterTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		LetterTypeMstVO vo = null;
		LetterTypeMstBO bo = null;
		String chk = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		HisUtil hisutil = null;
		try {
			bo = new LetterTypeMstBO();
			vo = new LetterTypeMstVO();

			hisutil = new HisUtil("mms", "LetterTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String strStoreTypeName = request.getParameter("comboValue");
			formBean.setStrStoreTypeName(strStoreTypeName);

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strStoreTypeId = formBean.getCombo()[0];

			vo.setStrLetterTypeId(strtemp[0]);
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrLastModifiedSeatId(seatid);
			vo.setStrStoreTypeId(strStoreTypeId);
			
			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrStoreTypeId(vo.getStrStoreTypeId());
			formBean.setStrLetterTypeName(vo.getStrLetterTypeName());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk(request.getParameter("chk"));
		} catch (Exception e) {

			strmsgText = "LetterTypeMaster.LetterTypeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LetterTypeMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
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
	public static boolean updateRecord(LetterTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		LetterTypeMstVO vo = null;
		LetterTypeMstBO bo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";

		try {
			bo = new LetterTypeMstBO();
			vo = new LetterTypeMstVO();

			String strStoreTypeName = request.getParameter("comboValue");
			formBean.setStrStoreTypeName(strStoreTypeName);

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strStoreTypeId = formBean.getCombo()[0];

			vo.setStrLetterTypeId(strtemp[0]);
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrLastModifiedSeatId(seatid);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrSeatId(seatid);
			vo.setStrLetterTypeName(formBean.getStrLetterTypeName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrStoreTypeId(strStoreTypeId);
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

			strmsgText = "LetterTypeMaster.LetterTypeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LetterTypeMstDATA->updateRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

}
