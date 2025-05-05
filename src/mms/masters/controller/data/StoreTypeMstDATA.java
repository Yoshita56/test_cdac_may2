package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.masters.bo.StoreTypeMstBO;
import mms.masters.controller.fb.StoreTypeMstFB;
import mms.masters.vo.StoreTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreTypeMstDATA.
 * 
 * @author Anshul Jindal
 */
public class StoreTypeMstDATA {

	/**
	 * to display the Item Category combo (COMMENTED AFTER CHANGES IN TABLES ON
	 * 17TH-FEB-2009) To display current Date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(StoreTypeMstFB formBean,
			HttpServletRequest request) {
		// StoreTypeMstBO bo = null;
		// StoreTypeMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		// String cmb = "";
		try {
			hisutil = new HisUtil("mms", "StoreTypeMstBO");
			// bo = new StoreTypeMstBO();
			// vo = new StoreTypeMstVO();

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			/*
			 * COMMENTED AFTER CHANGES IN TABLES ON 17TH-FEB-2009
			 * 
			 * String hosCode =
			 * request.getSession().getAttribute("HOSPITAL_CODE") .toString();
			 * String seatid = request.getSession().getAttribute("SEATID")
			 * .toString();
			 * 
			 * formBean.setStrHospitalCode(hosCode);
			 * formBean.setStrSeatId(seatid);
			 * 
			 * vo.setStrHospitalCode(hosCode); vo.setStrSeatId(seatid);
			 * 
			 * bo.initAdd(vo); if (vo.getStrMsgType().equals("1")) { throw new
			 * Exception(vo.getStrMsgString()); }
			 * 
			 * if(vo.getStrItemCategoryCmbWs()!=null){ cmb =
			 * hisutil.getOptionValue(vo.getStrItemCategoryCmbWs(), "0^Select
			 * Value", "Select Value", true); }
			 * vo.setStrItemCategoryNameCombo(cmb);
			 * 
			 * if (vo.getStrMsgType().equals("1")) { throw new
			 * Exception(vo.getStrMsgString()); }
			 * 
			 * formBean.setStrItemCategoryNameCombo(vo
			 * .getStrItemCategoryNameCombo());
			 */

		} catch (Exception e) {

			strmsgText = "Store Type Master.StoreTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreTypeMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			// bo = null;
			// vo = null;
			hisutil = null;
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insertRecord(StoreTypeMstFB formBean,
			HttpServletRequest request) {
		StoreTypeMstBO bo = null;
		StoreTypeMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new StoreTypeMstBO();
			vo = new StoreTypeMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryId(formBean.getStrItemCategoryId());
			vo.setStrStoreTypeName(formBean.getStrStoreTypeName());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
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

			strmsgText = "Store Type Master.StoreTypeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreTypeMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(StoreTypeMstFB formBean,
			HttpServletRequest request) {
		StoreTypeMstBO bo = null;
		StoreTypeMstVO vo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";
		HisUtil hisutil = null;
		try {
			hisutil = new HisUtil("mms", "StoreTypeMstBO");
			bo = new StoreTypeMstBO();
			vo = new StoreTypeMstVO();

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace("$", "#").split("#");
			strtemp[1] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrStoreTypeId(strtemp[1]);
			vo.setStrSeatId(seatid);

			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrStoreTypeName(vo.getStrStoreTypeName());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrSeatId(vo.getStrSeatId());
			formBean.setStrIsValid(vo.getStrIsValid());
			// formBean.setStrItemCategoryName(vo.getStrItemCategoryName());
			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "Store Type Master.StoreTypeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreTypeMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(StoreTypeMstFB formBean,
			HttpServletRequest request) {
		StoreTypeMstBO bo = null;
		StoreTypeMstVO vo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";
		try {
			bo = new StoreTypeMstBO();
			vo = new StoreTypeMstVO();
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace("$", "#").split("#");
			strtemp[1] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrStoreTypeId(strtemp[1]);
			vo.setStrSeatId(seatid);

			vo.setStrChk1(request.getParameter("chk"));
			vo.setStrStoreTypeName(formBean.getStrStoreTypeName());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {

				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}
			// TransferObjectFactory.populateData(formBean, vo);

			if (vo.getBExistStatus() == false) {
				retValue = false;
				formBean.setStrWarning("Data already exist");
				retValue = false;
			} else {
				if (vo.getStrMsgType().equals("1")) {
					retValue = false;
					throw new Exception(vo.getStrMsgString());
				} else {
					formBean.setStrMsg("Record Modify Successfully");
				}
			}

		} catch (Exception e) {
			retValue = false;
			strmsgText = "Store Type Master.StoreTypeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreTypeMstDATA->updateRecord()", strmsgText);
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
