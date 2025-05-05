package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.masters.bo.DispatchModeMstBO;
import mms.masters.controller.fb.DispatchModeMstFB;
import mms.masters.vo.DispatchModeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class DispatchModeMstDATA.
 */
public class DispatchModeMstDATA {

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */

	public static void insertRecord(DispatchModeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		DispatchModeMstVO vo = null;
		DispatchModeMstBO bo = null;

		try {
			bo = new DispatchModeMstBO();
			vo = new DispatchModeMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			hosCode="100";
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);

			vo.setStrIsValid("1");
			vo.setStrDispatchModeName(formBean.getStrDispatchModeName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrDispatchModeId(formBean.getStrDispatchModeId());

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
			strmsgText = "Dispatch Mode Master.DispatchModeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DispatchModeMstDATA->insertRecord()", strmsgText);
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

	public static void modifyRecord(DispatchModeMstFB formBean,
			HttpServletRequest request) {

		DispatchModeMstVO vo = null;
		DispatchModeMstBO bo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";

		try {
			bo = new DispatchModeMstBO();
			vo = new DispatchModeMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace("$", "#").split("#");

			strtemp[1] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrDispatchModeId(strtemp[1]);
			vo.setStrSeatId(seatid);

			bo.modifyQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrDispatchModeName(vo.getStrDispatchModeName());

			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());

		} catch (Exception e) {
			strmsgText = "Dispatch Mode Master.DispatchModeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DispatchModeMstDATA->modifyRecord()", strmsgText);
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

	public static boolean updateRecord(DispatchModeMstFB formBean,
			HttpServletRequest request) {
		DispatchModeMstVO vo = null;
		DispatchModeMstBO bo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";
		try {
			bo = new DispatchModeMstBO();
			vo = new DispatchModeMstVO();
			
			//16@100@1$5
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace("$", "#").split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrDispatchModeId(strtemp[0]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrSeatId(seatid);
			vo.setStrDispatchModeName(formBean.getStrDispatchModeName());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {

				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}

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
			strmsgText = "Dispatch Mode Master.DispatchModeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DispatchModeMstDATA->updateRecord()", strmsgText);
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
	 * Initial add.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(DispatchModeMstFB formBean,
			HttpServletRequest request) {
		DispatchModeMstVO vo = null;
		DispatchModeMstBO bo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			hisutil = new HisUtil("mms", "ComponentMstBO");
			bo = new DispatchModeMstBO();
			vo = new DispatchModeMstVO();

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			bo.initAdd(vo);

		} catch (Exception e) {

			strmsgText = "Dispatch Mode Master.DispatchModeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DispatchModeMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

}
