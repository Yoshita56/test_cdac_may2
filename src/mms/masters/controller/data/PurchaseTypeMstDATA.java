package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.masters.bo.PurchaseTypeMstBO;

import mms.masters.controller.fb.PurchaseTypeMstFB;
import mms.masters.vo.PurchaseTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PurchaseTypeMstDATA.
 * 
 * @author Anshul Jindal
 */
public class PurchaseTypeMstDATA {

	/**
	 * to display the current date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(PurchaseTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			String strStoreTypeName = request.getParameter("comboValue");
			formBean.setStrStoreTypeName(strStoreTypeName);

			hisutil = new HisUtil("mms", "PurchaseTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

		} catch (Exception e) {
			strmsgText = "IndentTypeMaster.PurchaseTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseTypeMstDATA->initialAdd()", strmsgText);
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
	public static void insertRecord(PurchaseTypeMstFB formBean,
			HttpServletRequest request) {
		PurchaseTypeMstBO bo = null;
		PurchaseTypeMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new PurchaseTypeMstBO();
			vo = new PurchaseTypeMstVO();

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

			vo.setStrPurchaseTypeName(formBean.getStrPurchaseTypeName());
			vo.setStrPurchaseTypeLimit(formBean.getStrPurchaseTypeLimit());
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

			strmsgText = "Tender Type Master.DATATenderTypeMst.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseTypeMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(PurchaseTypeMstFB formBean,
			HttpServletRequest request) {
		PurchaseTypeMstBO bo = null;
		PurchaseTypeMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;
		try {
			String strStoreTypeName = request.getParameter("comboValue");
			formBean.setStrStoreTypeName(strStoreTypeName);

			hisutil = new HisUtil("mms", "PurchaseTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			bo = new PurchaseTypeMstBO();
			vo = new PurchaseTypeMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrPurchaseTypeId(strtemp[1]);

			String strStoreTypeId = formBean.getCombo()[0];

			vo.setStrSeatId(seatid);
			vo.setStrStoreTypeId(strStoreTypeId);

			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrStoreTypeId(vo.getStrStoreTypeId());
			formBean.setStrPurchaseTypeName(vo.getStrPurchaseTypeName());
			formBean.setStrPurchaseTypeLimit(vo.getStrPurchaseTypeLimit());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "Tender Type Master.DATATenderTypeMst.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseTypeMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(PurchaseTypeMstFB formBean,
			HttpServletRequest request) {
		PurchaseTypeMstBO bo = null;
		PurchaseTypeMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		try {
			bo = new PurchaseTypeMstBO();
			vo = new PurchaseTypeMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrPurchaseTypeId(strtemp[1]);

			String strStoreTypeId = formBean.getCombo()[0];

			vo.setStrSeatId(seatid);
			vo.setStrStoreTypeId(strStoreTypeId);

			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrPurchaseTypeName(formBean.getStrPurchaseTypeName());
			vo.setStrPurchaseTypeLimit(formBean.getStrPurchaseTypeLimit());
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

			strmsgText = "Tender Type Master.DATATenderTypeMst.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurchaseTypeMstDATA->updateRecord()", strmsgText);
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
