package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.masters.bo.ProcessComponentMstBO;
import mms.masters.controller.fb.ProcessComponentMstFB;
import mms.masters.vo.ProcessComponentMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessComponentMstDATA.
 * 
 * @author Anurudra Goel
 */
public class ProcessComponentMstDATA {

	/**
	 * to display the Item Category combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(ProcessComponentMstFB formBean,
			HttpServletRequest request) {
		ProcessComponentMstBO bo = null;
		ProcessComponentMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String cmb = "";
		try {
			hisutil = new HisUtil("mms", "ProcessComponentMstDATA");
			bo = new ProcessComponentMstBO();
			vo = new ProcessComponentMstVO();
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			formBean.setStrHospitalCode(hosCode);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			String strComboVal = request.getParameter("comboValue").toString();
			String strCombo[] = request.getParameterValues("combo");
			bo.initAdd(vo);
			formBean.setStrProcessNameId(strCombo[0]);
			formBean.setStrProcessName(strComboVal);
			formBean.setComboValue(strComboVal);
			formBean.setCombo(strCombo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getWSProcessName() != null
					&& vo.getWSProcessName().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getWSProcessName(),
						"0^Select Value", "Select Value", true);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrProcessNameValues(cmb);

			if (vo.getWSComponentName() != null
					&& vo.getWSComponentName().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getWSComponentName(),
						"0^Select Value", "Select Value", true);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrComponentNameValues(cmb);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {

			strmsgText = "Process Component Master.ProcessComponentMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProcessComponentMstDATA->initialAdd()", strmsgText);
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
	public static void insertRecord(ProcessComponentMstFB formBean,
			HttpServletRequest request) {
		ProcessComponentMstBO bo = null;
		ProcessComponentMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new ProcessComponentMstBO();
			vo = new ProcessComponentMstVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			formBean.setStrHospitalCode(hosCode);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrComponentName(formBean.getStrComponentName());
			vo.setStrComponentValue1(formBean.getStrComponentValue1());
			vo.setStrComponentValue2(formBean.getStrComponentValue2());
			vo.setStrRemarks(vo.getStrRemarks());
			vo.setStrProcessNameId(formBean.getStrProcessNameId());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid("1");
			bo.insertRecord(vo);
			String temp[] = new String[1];
			temp[0] = formBean.getStrProcessNameId();
			formBean.setCombo(temp);
			formBean.setComboValue(formBean.getStrProcessName());
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else if (vo.getBExistStatus() == false) {
				formBean.setStrWarning("Data Already Exist");
			}

			else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {

			strmsgText = "Store Type Master.ProcessComponentMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProcessComponentMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(ProcessComponentMstFB formBean,
			HttpServletRequest request) {
		ProcessComponentMstBO bo = null;
		ProcessComponentMstVO vo = null;
		String strtemp[] = null;
		// HisUtil hisutil=null;
		String strmsgText = "";
		String chk = "";
		// String cmb="";
		try {
			bo = new ProcessComponentMstBO();
			vo = new ProcessComponentMstVO();
			chk = request.getParameter("chk");
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			strtemp = chk.replace('@', '#').split("#");
			vo.setStrProcessNameId(strtemp[0]);
			vo.setStrComponentId(strtemp[1]);
			vo.setStrProcessComponentSlNo(strtemp[2]);
			vo.setStrHospitalCode(hosCode);
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			vo.setStrSeatId(seatid);
			bo.modifyRecord(vo);
			// hisutil = new HisUtil("mms", "ProcessComponentMstDATA");
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrComponentValue1(vo.getStrComponentValue1Values());
			formBean.setStrComponentValue2(vo.getStrComponentValue2Values());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());
			String strComboVal = request.getParameter("comboValue").toString();
			formBean.setStrProcessName(strComboVal);
			formBean.setStrProcessNameId(vo.getStrProcessNameId());
			formBean.setStrChk(chk);
			formBean.setStrComponentNameModify(vo.getStrComponentNameModify());
			formBean.setStrComponentName(vo.getStrComponentId());
			formBean.setStrRemarks(vo.getStrRemarks());

		} catch (Exception e) {

			strmsgText = "Store Type Master.ProcessComponentMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProcessComponentMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(ProcessComponentMstFB formBean,
			HttpServletRequest request) {
		ProcessComponentMstBO bo = null;
		ProcessComponentMstVO vo = null;
		boolean retValue = true;
		String strtemp[] = null;
		// String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";
		try {

			bo = new ProcessComponentMstBO();
			vo = new ProcessComponentMstVO();
			chk = formBean.getStrChk();
			strtemp = chk.replace('@', '#').split("#");
			vo.setStrProcessNameId(strtemp[0]);
			vo.setStrComponentId(strtemp[1]);
			vo.setStrProcessComponentSlNo(strtemp[2]);
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrComponentValue1(formBean.getStrComponentValue1());
			vo.setStrComponentValue2(formBean.getStrComponentValue2());
			vo.setStrComponentName(formBean.getStrComponentName());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrSeatId(seatid);
			bo.updateRecord(vo);
			if (vo.getStrMsgType().equals("1")) {

				retValue = false;
				throw new Exception(vo.getStrMsgString());
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
			strmsgText = "Store Type Master.ProcessComponentMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProcessComponentMstDATA->updateRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			request.setAttribute("chk", chk);

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

		return retValue;
	}

}
