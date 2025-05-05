package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.ItemTypeMstBO;

import mms.masters.controller.fb.ItemTypeMstFB;
import mms.masters.vo.ItemTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemTypeMstDATA.
 * 
 * @author Anshul Jindal
 */
public class ItemTypeMstDATA {

	/**
	 * to display the current date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(ItemTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			String strItemCategoryName = request.getParameter("comboValue");
			formBean.setStrItemCategoryName(strItemCategoryName);
			hisutil = new HisUtil("mms", "ItemTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

		} catch (Exception e) {
			strmsgText = "ItemTypeMaster.ItemTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemTypeMstDATA->initialAdd()", strmsgText);
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
	public static void insertRecord(ItemTypeMstFB formBean,
			HttpServletRequest request) {
		ItemTypeMstBO bo = null;
		ItemTypeMstVO vo = null;
		String strmsgText = "";
		String strItemCatNo = "";
		try {
			bo = new ItemTypeMstBO();
			vo = new ItemTypeMstVO();

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			strItemCatNo = formBean.getCombo()[0];

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrIsValid("1");
			vo.setStrItemCatNo(strItemCatNo);

			vo.setStrItemTypeName(formBean.getStrItemTypeName());
			vo.setStrShortName(formBean.getStrShortName());
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

			strmsgText = "ItemTypeMaster.ItemTypeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemTypeMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(ItemTypeMstFB formBean,
			HttpServletRequest request) {
		ItemTypeMstBO bo = null;
		ItemTypeMstVO vo = null;
		String strmsgText = "";
		String strItemCatNo = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;
		try {
			String strItemCategoryName = request.getParameter("comboValue");
			formBean.setStrItemCategoryName(strItemCategoryName);

			hisutil = new HisUtil("mms", "ItemTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			bo = new ItemTypeMstBO();
			vo = new ItemTypeMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrItemTypeId(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			strItemCatNo = formBean.getCombo()[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrItemTypeId(strtemp[1]);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatNo(strItemCatNo);

			bo.modifyRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrItemCatNo(vo.getStrItemCatNo());
			formBean.setStrItemTypeName(vo.getStrItemTypeName());
			formBean.setStrShortName(vo.getStrShortName());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());

			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "ItemTypeMaster.ItemTypeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemTypeMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(ItemTypeMstFB formBean,
			HttpServletRequest request) {
		ItemTypeMstBO bo = null;
		ItemTypeMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		String strItemCatNo = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		try {
			bo = new ItemTypeMstBO();
			vo = new ItemTypeMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrItemTypeId(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			strItemCatNo = formBean.getCombo()[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrItemTypeId(strtemp[1]);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatNo(strItemCatNo);

			vo.setStrItemTypeName(formBean.getStrItemTypeName());
			vo.setStrShortName(formBean.getStrShortName());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());

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

			strmsgText = "ItemTypeMaster.ItemTypeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemTypeMstDATA->updateRecord()", strmsgText);
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
