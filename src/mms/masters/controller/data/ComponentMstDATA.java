package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.ComponentMstBO;

import mms.masters.controller.fb.ComponentMstFB;

import mms.masters.vo.ComponentMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ComponentMstDATA.
 * 
 * @author manas
 */

public class ComponentMstDATA {

	/**
	 * to display the Item Category combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */

	public static void initialAdd(ComponentMstFB formBean,
			HttpServletRequest request) {
	//	ComponentMstBO bo = null;
		ComponentMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
	//	String cmb = "";
		try {
			hisutil = new HisUtil("mms", "ComponentMstBO");
	//		bo = new ComponentMstBO();
			vo = new ComponentMstVO();

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			/*bo.initAdd(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStrItemCategoryCmbWs() != null
					&& vo.getStrItemCategoryCmbWs().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getStrItemCategoryCmbWs(),
						"0^Select Value", "Select Value", true);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrItemCategoryNameCombo(cmb);
*/
			/*
			 * if (vo.getStrMsgType().equals("1")) { throw new
			 * Exception(vo.getStrMsgString()); }
			 * 
			 * formBean.setStrItemCategoryNameCombo(vo
			 * .getStrItemCategoryNameCombo());
			 */
		} catch (Exception e) {

			strmsgText = "Component Master.ComponentMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ComponentMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
	//		bo = null;
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

	public static void insertRecord(ComponentMstFB formBean,
			HttpServletRequest request) {
		ComponentMstBO bo = null;
		ComponentMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new ComponentMstBO();
			vo = new ComponentMstVO();

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			//vo.setStrItemCategoryId(formBean.getStrItemCategoryId());
			vo.setStrComponentName(formBean.getStrComponentName());
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

			strmsgText = "Component Master.ComponentMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ComponentMstDATA->insertRecord()", strmsgText);
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

	public static void modifyRecord(ComponentMstFB formBean,
			HttpServletRequest request) {
		ComponentMstBO bo = null;
		ComponentMstVO vo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";
		try {
			bo = new ComponentMstBO();
			vo = new ComponentMstVO();
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace("$", "#").split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrComponentId(strtemp[0]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrSeatId(seatid);			

			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrComponentName(vo.getStrComponentName());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrSeatId(vo.getStrSeatId());
			formBean.setStrIsValid(vo.getStrIsValid());
			//formBean.setStrItemCategoryName(vo.getStrItemCategoryName());
			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "Component Master.ComponentMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ComponentMstDATA->modifyRecord()", strmsgText);
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

	public static boolean updateRecord(ComponentMstFB formBean,
			HttpServletRequest request) {
		ComponentMstBO bo = null;
		ComponentMstVO vo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String strmsgText = "";
		String chk = "";
		try {
			bo = new ComponentMstBO();
			vo = new ComponentMstVO();
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace("$", "#").split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrComponentId(strtemp[0]);
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);			
			vo.setStrSeatId(seatid);

			vo.setStrChk1(request.getParameter("chk"));
			vo.setStrComponentName(formBean.getStrComponentName());
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
			strmsgText = "Component Master.ComponentMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ComponentMstDATA->updateRecord()", strmsgText);
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
