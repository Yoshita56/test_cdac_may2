/**
 * 
 */
package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.SupplierTypeMstBO;
import mms.masters.controller.fb.SupplierTypeMstFB;
import mms.masters.vo.SupplierTypeMstVO;

/**
 * Developer : Tanvi Sappal
 * Create Date : 26/Oct/2009
 * Process Name : Supplier Type Master
 * Version : 1.1
 * Modify By/Date : 
 */

public class SupplierTypeMstDATA {
	
	/**
	 * To display current Date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(SupplierTypeMstFB formBean,
			HttpServletRequest request) {
		// SupplierTypeMstBO bo = null;
		// SupplierTypeMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		// String cmb = "";
		try {
			hisutil = new HisUtil("mms", "SupplierTypeMstBO");
			// bo = new SupplierTypeMstBO();
			// vo = new SupplierTypeMstVO();

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

		} catch (Exception e) {

			strmsgText = "Supplier Type Master.SupplierTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierTypeMstDATA->initialAdd()", strmsgText);
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
	public static void insertRecord(SupplierTypeMstFB formBean,
			HttpServletRequest request) {
		SupplierTypeMstBO bo = null;
		SupplierTypeMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new SupplierTypeMstBO();
			vo = new SupplierTypeMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			hosCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			
			String seatid = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrSupplierTypeName(formBean.getStrSupplierTypeName());
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

			strmsgText = "Supplier Type Master.SupplierTypeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierTypeMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(SupplierTypeMstFB formBean,
			HttpServletRequest request) {
		SupplierTypeMstBO bo = null;
		SupplierTypeMstVO vo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";
		HisUtil hisutil = null;
		try {
			hisutil = new HisUtil("mms", "SupplierTypeMstBO");
			bo = new SupplierTypeMstBO();
			vo = new SupplierTypeMstVO();

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
//			100@10@1$1
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace("$", "#").split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrSupplierTypeId(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			
			
			vo.setStrSeatId(seatid);

			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrSupplierTypeName(vo.getStrSupplierTypeName());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrSeatId(vo.getStrSeatId());
			formBean.setStrIsValid(vo.getStrIsValid());
			// formBean.setStrItemCategoryName(vo.getStrItemCategoryName());
			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "Supplier Type Master.SupplierTypeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierTypeMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(SupplierTypeMstFB formBean,
			HttpServletRequest request) {
		SupplierTypeMstBO bo = null;
		SupplierTypeMstVO vo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";
		try {
			bo = new SupplierTypeMstBO();
			vo = new SupplierTypeMstVO();
//			100@10@1$1
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace("$", "#").split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrSupplierTypeId(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			
			vo.setStrLstmodSeatId(seatid);

			vo.setStrChk1(request.getParameter("chk"));
			vo.setStrSupplierTypeName(formBean.getStrSupplierTypeName());
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
			strmsgText = "Supplier Type Master.SupplierTypeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierTypeMstDATA->updateRecord()", strmsgText);
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
