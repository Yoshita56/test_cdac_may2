package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.masters.bo.InvoiceTypeMstBO;

import mms.masters.controller.fb.InvoiceTypeMstFB;

import mms.masters.vo.InvoiceTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class InvoiceTypeMstDATA.
 * 
 * @author manas meher
 */

public class InvoiceTypeMstDATA {

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */

	public static void insertRecord(InvoiceTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		InvoiceTypeMstVO vo = null;
		InvoiceTypeMstBO bo = null;

		try {
			bo = new InvoiceTypeMstBO();
			vo = new InvoiceTypeMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrIsValid("1");
			vo.setStrInvoiceTypeName(formBean.getStrInvoiceTypeName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrInvoiceTypeId(formBean.getStrInvoiceTypeId());
			vo.setStrInvoiceType(formBean.getStrInvoiceType());
			bo.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus()) {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			strmsgText = "Invoice Type Master.InvoiceTypeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InvoiceTypeMstDATA->insertRecord()", strmsgText);
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

	public static void modifyRecord(InvoiceTypeMstFB formBean,
			HttpServletRequest request) {

		InvoiceTypeMstVO vo = null;
		InvoiceTypeMstBO bo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";

		try {
			bo = new InvoiceTypeMstBO();
			vo = new InvoiceTypeMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace("$", "#").split("#");

			strtemp[1] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrInvoiceTypeId(strtemp[0]);
			vo.setStrSeatId(seatid);

			bo.modifyQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrInvoiceTypeName(vo.getStrInvoiceTypeName());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrInvoiceType(vo.getStrInvoiceType());
		} catch (Exception e) {
			strmsgText = "Invoive Type Master.InvoiceTypeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InvoiceTypeMstDATA->modifyRecord()", strmsgText);
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

	public static boolean updateRecord(InvoiceTypeMstFB formBean,
			HttpServletRequest request) {
		InvoiceTypeMstVO vo = null;
		InvoiceTypeMstBO bo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";
		try {
			bo = new InvoiceTypeMstBO();
			vo = new InvoiceTypeMstVO();
			
			// 14@100@6$3
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace("$", "#").split("#");//6$3
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrInvoiceTypeId(strtemp[0]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrSeatId(seatid);
			vo.setStrInvoiceTypeName(formBean.getStrInvoiceTypeName());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrInvoiceType(formBean.getStrInvoiceType());
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
			strmsgText = "Invoice Type Master.InvoiceTypeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InvoiceTypeMstDATA->updateRecord()", strmsgText);
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
	public static void initialAdd(InvoiceTypeMstFB formBean,
			HttpServletRequest request) {
		InvoiceTypeMstVO vo = null;
		InvoiceTypeMstBO bo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			hisutil = new HisUtil("mms", "ComponentMstBO");
			bo = new InvoiceTypeMstBO();
			vo = new InvoiceTypeMstVO();

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			bo.initAdd(vo);

		} catch (Exception e) {

			strmsgText = "Invoice Type Master.InvoiceTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"InvoiceTypeMstDATA->initialAdd()", strmsgText);
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
