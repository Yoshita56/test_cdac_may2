package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mms.masters.bo.ProcessLetterTypeMstBO;
import mms.masters.controller.fb.ProcessLetterTypeMstFB;
import mms.masters.vo.ProcessLetterTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessLetterTypeMstDATA.
 * 
 * @author Tanvi Sappal
 */
public class ProcessLetterTypeMstDATA {
	
	/**
	 * To get values of Left List Box.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 */
	public static void getLeftList(ProcessLetterTypeMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ProcessLetterTypeMstBO bo = null;
		ProcessLetterTypeMstVO vo = null;
		HisUtil hisutil = null;

		String strHospitalCode = "";
		String strSeatId = "";
		String storeId = "";

		try {

			bo = new ProcessLetterTypeMstBO();
			vo = new ProcessLetterTypeMstVO();

			strHospitalCode = request.getSession()
					.getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request.getSession().getAttribute("SEATID").toString();
			storeId = (String) request.getParameter("storeName");

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrStoreTypeId(storeId);

			bo.getLeftList(vo);
			vo.getLeftListWS();

			hisutil = new HisUtil("mms", "ProcessLetterTypeMstDATA");
			String cmbstr = hisutil.getOptionValue(vo.getLeftListWS(), "", "",
					false);

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(cmbstr);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "ProcessLetterTypeMaster.ProcessLetterTypeMstDATA.getLeftList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProcessLetterTypeMstDATA->getLeftList()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {

			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}

	/**
	 * To get values of Right List Box.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 */
	public static void getRightList(ProcessLetterTypeMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ProcessLetterTypeMstBO bo = null;
		ProcessLetterTypeMstVO vo = null;
		HisUtil hisutil = null;

		String strHospitalCode = "";
		String strSeatId = "";
		String processId = "";

		try {

			bo = new ProcessLetterTypeMstBO();
			vo = new ProcessLetterTypeMstVO();

			strHospitalCode = request.getSession()
					.getAttribute("HOSPITAL_CODE").toString();
			strSeatId = request.getSession().getAttribute("SEATID").toString();
			processId = (String) request.getParameter("processName");

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrProcessId(processId);

			bo.getRightList(vo);
			vo.getRightListWS();

			hisutil = new HisUtil("mms", "ProcessLetterTypeMstDATA");
			String cmbstr = hisutil.getOptionValue(vo.getRightListWS(), "", "",
					false);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {

			}

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = "ProcessLetterTypeMaster.ProcessLetterTypeMstDATA.getRightList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProcessLetterTypeMstDATA->getRightList()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {

			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}

	}

	/**
	 * to display the Store Type Name on Add page or modify page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(ProcessLetterTypeMstFB formBean,
			HttpServletRequest request) {
		ProcessLetterTypeMstBO bo = null;
		ProcessLetterTypeMstVO vo = null;
		String strmsgText = "";
		String cmb = "";
		HisUtil hisutil = null;
		try {
			bo = new ProcessLetterTypeMstBO();
			vo = new ProcessLetterTypeMstVO();

			hisutil = new HisUtil("mms", "ProcessLetterTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String strProcessName = request.getParameter("comboValue");
			formBean.setStrProcessName(strProcessName);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strProcessId = formBean.getCombo()[0];

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrProcessId(strProcessId);

			// vo.setStrStoreTypeCombo(cmb);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			// vo.setStrProcessId(strProcessId);
			vo.setStrProcessName(strProcessName);

			bo.initialAdd(vo);
			hisutil = new HisUtil("mms", "ProcessLetterTypeMstDATA");

			if (vo.getStoreTypeComboWS() != null
					&& vo.getStoreTypeComboWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getStoreTypeComboWS(), vo
						.getStrStoreTypeId(), "0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrStoreTypeCombo(cmb);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {

			strmsgText = "ProcessLetterTypeMaster.ProcessLetterTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProcessLetterTypeMstDATA->initialAdd()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
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

	public static void insertRecord(ProcessLetterTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		ProcessLetterTypeMstBO bo = null;
		ProcessLetterTypeMstVO vo = null;

		try {
			bo = new ProcessLetterTypeMstBO();
			vo = new ProcessLetterTypeMstVO();

			String strProcessName = request.getParameter("comboValue");
			formBean.setStrProcessName(strProcessName);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strProcessId = formBean.getCombo()[0];

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrProcessId(strProcessId);

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrProcessId(strProcessId);
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrProcessSlNo(formBean.getStrProcessSlNo());

			vo.setStrStoreTypeName(formBean.getStrStoreTypeName());
			vo.setStrRightLetterName(formBean.getStrRightLetterName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());

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

			strmsgText = "ProcessLetterTypeMaster.ProcessLetterTypeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProcessLetterTypeMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(ProcessLetterTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		ProcessLetterTypeMstVO vo = null;
		ProcessLetterTypeMstBO bo = null;
		String chk = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String temp[] = null;
		HisUtil hisutil = null;

		try {
			bo = new ProcessLetterTypeMstBO();
			vo = new ProcessLetterTypeMstVO();

			hisutil = new HisUtil("mms", "ProcessLetterTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String strProcessName = request.getParameter("comboValue");
			formBean.setStrProcessName(strProcessName);

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			temp = strtemp[3].replace('$', '#').split("#");

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strProcessId = formBean.getCombo()[0];

			vo.setStrLetterTypeId(strtemp[0]);
			vo.setStrHospitalCode(strtemp[2]);
			vo.setStrProcessId(strtemp[1]);
			vo.setStrProcessSlNo(temp[0]);

			vo.setStrSeatId(seatid);
			vo.setStrProcessId(strProcessId);

			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrProcessId(vo.getStrProcessId());
			formBean.setStrLetterTypeId(vo.getStrLetterTypeId());
			formBean.setStrLetterTypeName(vo.getStrLetterTypeName());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk(request.getParameter("chk"));
		} catch (Exception e) {

			strmsgText = "ProcessLetterTypeMaster.ProcessLetterTypeMstDATA.modifyRecord(vo) -->"
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProcessLetterTypeMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(ProcessLetterTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		ProcessLetterTypeMstVO vo = null;
		ProcessLetterTypeMstBO bo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		String temp[] = null;

		try {
			bo = new ProcessLetterTypeMstBO();
			vo = new ProcessLetterTypeMstVO();

			String strProcessName = request.getParameter("comboValue");
			formBean.setStrProcessName(strProcessName);

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			temp = strtemp[3].replace('$', '#').split("#");

			String lastModifySeatId = request.getSession().getAttribute(
					"SEATID").toString();

			String strProcessId = formBean.getCombo()[0];

			vo.setStrLetterTypeId(strtemp[0]);
			vo.setStrHospitalCode(strtemp[2]);
			vo.setStrProcessId(strtemp[1]);
			vo.setStrProcessSlNo(temp[0]);

			vo.setStrLastModifiedSeatId(lastModifySeatId);
			vo.setStrProcessId(strProcessId);

			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
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

			strmsgText = "ProcessLetterTypeMaster.ProcessLetterTypeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ProcessLetterTypeMstDATA->updateRecord()", strmsgText);
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
