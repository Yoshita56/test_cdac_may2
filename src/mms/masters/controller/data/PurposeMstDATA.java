package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.masters.bo.PurposeMstBO;
import mms.masters.controller.fb.PurposeMstFB;
import mms.masters.vo.PurposeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class PurposeMstDATA.
 * 
 * @author Baisakhi Roy
 */
public class PurposeMstDATA {

	/**
	 * to Get the current date in add page.
	 * 
	 * @param formBean the form bean
	 */

	public static void initialAdd(PurposeMstFB formBean) {
		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			hisutil = new HisUtil("mms", "PurposeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

		} catch (Exception e) {

			strmsgText = "Purpose Master.PurposeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurposeMstDATA->initialAdd()", strmsgText);
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

	public static void insertRecord(PurposeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		PurposeMstVO vo = null;
		PurposeMstBO bo = null;

		try {
			bo = new PurposeMstBO();
			vo = new PurposeMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
			.toString();
			String seatid =  request.getSession().getAttribute("SEATID")
			.toString();

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);

			vo.setStrIsValid("1");
			vo.setStrPurpose(formBean.getStrPurpose());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());

			bo.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.isBExistStatus() == false) {
				formBean.setStrWarning("Data already exist");
			} else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			strmsgText = "Purpose Master.PurposeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurposeMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
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

	public static void modifyRecord(PurposeMstFB formBean,
			HttpServletRequest request) {

		PurposeMstVO vo = null;
		PurposeMstBO bo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";

		try {
			bo = new PurposeMstBO();
			vo = new PurposeMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace("$", "#").split("#");

			strtemp[1] = strtemp2[0];

			String seatid =  request.getSession().getAttribute("SEATID")
			 .toString();

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrPurposeId(strtemp[1]);
			vo.setStrSeatId(seatid);

			bo.modifyQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrPurpose(vo.getStrPurpose());

			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());

		} catch (Exception e) {
			strmsgText = "Purpose Master.PurposeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurposeMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			vo = null;
			bo = null;
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

	public static boolean updateRecord(PurposeMstFB formBean,
			HttpServletRequest request) {
		PurposeMstVO vo = null;
		PurposeMstBO bo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";
		try {
			bo = new PurposeMstBO();
			vo = new PurposeMstVO();
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace("$", "#").split("#");
			strtemp[1] = strtemp2[0];

			String seatid =  request.getSession().getAttribute("SEATID")
			 .toString();

			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrPurposeId(strtemp[0]);
			vo.setStrSeatId(seatid);
			vo.setStrPurpose(formBean.getStrPurpose());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {

				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.isBExistStatus() == false) {
				retValue = false;
				formBean.setStrWarning("Data already exist");
				retValue = false;
			} else {
				if (vo.getStrMsgType().equals("1")) {
					retValue = false;
					throw new Exception(vo.getStrMsgString());
				} else {
					formBean.setStrMsg("Record Modified Successfully");
				}
			}

		} catch (Exception e) {
			retValue = false;
			strmsgText = "Purpose Master.PurposeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"PurposeMstDATA->updateRecord()", strmsgText);
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
