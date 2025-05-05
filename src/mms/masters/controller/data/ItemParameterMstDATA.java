package mms.masters.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.ItemParameterMstBO;
import mms.masters.controller.fb.ItemParameterMstFB;
import mms.masters.vo.ItemParameterMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemParameterMstDATA.
 * 
 * @author manas
 */

public class ItemParameterMstDATA {

	/**
	 * to insert the data.
	 * 
	 * @param request the request
	 * @param formbean the formbean
	 */

	public static void InsertRecord(ItemParameterMstFB formbean,
			HttpServletRequest request) {

		String strmsgText = "";

		ItemParameterMstVO vo = null;
		ItemParameterMstBO bo = null;

		try {

			bo = new ItemParameterMstBO();
			vo = new ItemParameterMstVO();

			String strHospitalCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();
			formbean.setStrHospitalCode(strHospitalCode);
			formbean.setStrSeatId(strSeatId);

			if (formbean.getStrIsChild().equals("0")) {
				formbean.setStrParentParamId("0");
			}

			String strItemCatNo = formbean.getCombo()[0];

			formbean.setStrCategroyNo(strItemCatNo);
			/*
			 * String[] strVal = bothValue.replace("^", "#").split("#");
			 * 
			 * formbean.setStrStoreTypeId(strVal[0]);
			 * formbean.setStrCategroyNo(strVal[1]);
			 */

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrCategroyNo(strItemCatNo);
			// vo.setStrCategroyNo(strVal[1]);
			vo.setStrItemParamName(formbean.getStrItemParamName());
			vo.setStrParamType(formbean.getStrParamType());
			vo.setStrParamLength(formbean.getStrParamLength());
			vo.setStrParentParamId(formbean.getStrParentParamId());
			vo.setStrEffectiveFrom(formbean.getStrEffectiveFrom());
			vo.setStrIsValid(formbean.getStrIsValid());
			vo.setStrRemarks(formbean.getStrRemarks());

			bo.insertQuery(vo);

			// formbean.setStrStoreTypeId(strTemp);

			if (vo.getStrMsgType().equals("2")) {

				formbean.setStrWarning("Data already exist");
			} else if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			} else {

				formbean.setStrMsg("Data Saved Successfully");

			}

		}

		catch (Exception e) {

			// e.printStackTrace();

			strmsgText = "ItemParameterMaster.ItemParameterMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("store",
					"ItemParameterMstDATA->insertRecord()", strmsgText);
			formbean.setStrErr("Application Error [ERROR ID : "
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

	public static void modifyRecord(ItemParameterMstFB formBean,
			HttpServletRequest request) {

		ItemParameterMstVO vo = null;
		ItemParameterMstBO bo = null;
		String[] strTemp = null;
		String[] strTemp1 = null;
		try {

			bo = new ItemParameterMstBO();

			String chk = request.getParameter("chk");
			String strLastSeatId = request.getSession().getAttribute("SEATID")
					.toString();

			formBean.setStrLastModifiedSeatId(strLastSeatId);

			strTemp = chk.replace('$', '#').split("#");

			strTemp1 = strTemp[0].split("@");

			formBean.setStrItemParamId(strTemp1[0]);
			formBean.setStrHospitalCode(strTemp1[1]);
			formBean.setStrSlNo(strTemp1[2]);
		
			vo = (ItemParameterMstVO) TransferObjectFactory.populateData(
					"mms.masters.vo.ItemParameterMstVO", formBean);
			bo.modifyQuery(vo);

			formBean.setStrItemParamName(vo.getStrItemParamName());
			formBean.setStrParamType(vo.getStrParamType());
			formBean.setStrParamLength(vo.getStrParamLength());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrCategroyNo(vo.getStrCategroyNo());

		}

		catch (Exception e) {
			new HisException("Item Parameter Master", "ItemParameterMstDATA",
					"ItemParameterMstDATA.modifyRecord()-->" + e.getMessage());
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

	public static boolean updateRecord(ItemParameterMstFB formBean,
			HttpServletRequest request) {

		boolean bResult = false;

		ItemParameterMstVO vo = null;
		ItemParameterMstBO bo = null;

		String[] strTemp = null;
		String[] strTemp1 = null;
		try {
			String chk1 = request.getParameter("chk");
			strTemp = chk1.replace('$', '#').split("#");

			strTemp1 = strTemp[0].split("@");
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			formBean.setStrItemParamId(strTemp1[0]);
			formBean.setStrHospitalCode(strTemp1[1]);
			formBean.setStrSlNo(strTemp1[2]);
			formBean.setStrParentParamId(strTemp[1]);
			formBean.setStrLastModifiedSeatId(seatid);
			formBean.setStrSeatId(seatid);
			bo = new ItemParameterMstBO();

			vo = (ItemParameterMstVO) TransferObjectFactory.populateData(
					"mms.masters.vo.ItemParameterMstVO", formBean);
			bo.updateQuery(vo);

			if (vo.getStrMsgType().equals("2")) {

				formBean.setStrWarning("Data Already Exist");
			} else if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			} else {

				bResult = true;

			}

		}

		catch (Exception e)
		{
			e.printStackTrace();
			HisException eObj = new HisException(" Item Parameter Master",
					"ItemParameterMstDATA",
					"ItemParameterMstDATA.updateRecord()-->" + e.getMessage());

			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

			bResult = false;

		} finally {

			bo = null;
			vo = null;
		}

		return bResult;

	}

	/**
	 * to display the parent parameter combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */

	public static void initialAdd(ItemParameterMstFB formBean,
			HttpServletRequest request) {

		ItemParameterMstVO vo = null;
		ItemParameterMstBO bo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String cmb = "";
		try {
			bo = new ItemParameterMstBO();
			vo = new ItemParameterMstVO();

			String strItemCategoryName = request.getParameter("comboValue");
			formBean.setStrItemCategoryName(strItemCategoryName);

			/*
			 * String combo[] = request.getParameterValues("combo");
			 * 
			 * String[] strVal = combo[0].replace("^", "#").split("#");
			 * 
			 * formBean.setStrStoreTypeId(strVal[0]);
			 * formBean.setStrCategroyNo(strVal[1]);
			 */

			hisutil = new HisUtil("mms", "ItemParameterMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String strItemCatNo = formBean.getCombo()[0];

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			/*
			 * String seatid = request.getSession().getAttribute("SEATID")
			 * .toString();
			 */

			formBean.setStrCategroyNo(strItemCatNo);
			formBean.setStrHospitalCode(hosCode);
			// formBean.setStrSeatId(seatid);

			vo.setStrHospitalCode(hosCode);
			vo.setStrCategroyNo(strItemCatNo);
			formBean.setStrParamType("0");
			// vo.setStrSeatId(seatid);

			bo.initAdd(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "ItemParameterMstBO");

			if (vo.getStrparentCmbWs() != null
					&& vo.getStrparentCmbWs().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getStrparentCmbWs(),
						"0^Select Value", "Select Value", true);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrparentNameCombo(cmb);

		} catch (Exception e) {

			// e.printStackTrace();

			strmsgText = "Item Parameter Master.ItemParameterMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemParameterMstDATA->initialAdd()", strmsgText);
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
