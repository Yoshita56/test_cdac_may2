package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.StoreGroupMstBO;
import mms.masters.controller.fb.StoreGroupMstFB;
import mms.masters.vo.StoreGroupMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreGroupMstDATA.
 * 
 * @author Anshul Jindal
 */
public class StoreGroupMstDATA {

	/**
	 * to display the current date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(StoreGroupMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			String strItemCatName = request.getParameter("comboValue");
			formBean.setStrItemCatName(strItemCatName);
            //System.out.println("setStrItemCatName       "+formBean.getStrItemCatName());
			hisutil = new HisUtil("mms", "StoreGroupMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

		} catch (Exception e) {
			strmsgText = "StoreGroupMaster.StoreGroupMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreGroupMstDATA->initialAdd()", strmsgText);
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
	public static void insertRecord(StoreGroupMstFB formBean,
			HttpServletRequest request) {
		StoreGroupMstBO bo = null;
		StoreGroupMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new StoreGroupMstBO();
			vo = new StoreGroupMstVO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			strHospitalCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			String strItemCatId = formBean.getCombo()[0];

			formBean.setStrHospitalCode(strHospitalCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrItemCatId(strItemCatId);

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(seatid);
			vo.setStrIsValid("1");
			vo.setStrGroupName(formBean.getStrGroupName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrItemCatId(formBean.getStrItemCatId());

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

			strmsgText = "StoreGroupMaster.StoreGroupMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreGroupMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(StoreGroupMstFB formBean,
			HttpServletRequest request) {
		StoreGroupMstBO bo = null;
		StoreGroupMstVO vo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			String strItemCatName = request.getParameter("comboValue");
			formBean.setStrItemCatName(strItemCatName);

			hisutil = new HisUtil("mms", "StoreGroupMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			bo = new StoreGroupMstBO();
			vo = new StoreGroupMstVO();

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			String strItemCatId = formBean.getCombo()[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrGroupId(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatId(strItemCatId);

			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrItemCatId(vo.getStrItemCatId());
			formBean.setStrGroupName(vo.getStrGroupName());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "StoreGroupMaster.StoreGroupMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreGroupMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(StoreGroupMstFB formBean,
			HttpServletRequest request) {
		StoreGroupMstBO bo = null;
		StoreGroupMstVO vo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		String strmsgText = "";
		boolean retValue = true;
		try {
			bo = new StoreGroupMstBO();
			vo = new StoreGroupMstVO();
			//100@110000@1$1
			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			String strItemCatId = formBean.getStrItemCatId();

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrGroupId(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			
			vo.setStrSeatId(seatid);
			vo.setStrItemCatId(strItemCatId);

			vo.setStrGroupName(formBean.getStrGroupName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
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

			strmsgText = "StoreGroupMaster.StoreGroupMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreGroupMstDATA->updateRecord()", strmsgText);
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
