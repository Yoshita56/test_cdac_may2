package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.GatePassTypeMstBO;
import mms.masters.controller.fb.GatePassTypeMstFB;
import mms.masters.vo.GatePassTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class GatePassTypeMstDATA.
 */
public class GatePassTypeMstDATA {

	/**
	 * to display the current date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(GatePassTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			hisutil = new HisUtil("mms", "GatePassTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

		} catch (Exception e) {
			strmsgText = "GatePassTypeMaster.GatePassTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"GatePassTypeMstDATA->initialAdd()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
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
	public static void insertRecord(GatePassTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		GatePassTypeMstVO vo = null;
		GatePassTypeMstBO bo = null;

		try {
			bo = new GatePassTypeMstBO();
			vo = new GatePassTypeMstVO();

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrIsValid("1");
			vo.setStrGatePassTypeName(formBean.getStrGatePassTypeName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrGatePassTypeCode(formBean.getStrGatePassTypeCode());

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
			e.printStackTrace();
			strmsgText = "GatePassTypeMaster.GatePassTypeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"GatePassTypeMstDATA->insertRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			vo = null;
			bo = null;
		}

	}

	/**
	 * invokes modifyQuery Method.
	 * 
	 * @param formBean -
	 * FormBean Object
	 * @param request the request
	 */
	public static void modifyRecord(GatePassTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		GatePassTypeMstVO vo = null;
		GatePassTypeMstBO bo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";

		try {
			bo = new GatePassTypeMstBO();
			vo = new GatePassTypeMstVO();

			hisutil = new HisUtil("mms", "GatePassTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrGatePassTypeCode(strtemp[0]);
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrLastModifiedSeatId(seatid);

			bo.modifyQuery(vo);

			formBean.setStrGatePassTypeName(vo.getStrGatePassTypeName());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk(request.getParameter("chk"));

		} catch (Exception e) {
			strmsgText = "GatePassTypeMaster.GatePassTypeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"GatePassTypeMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
	}

	/**
	 * Update method returns true if Record Updated Successfully false if Record<br>
	 * Not Updated Successfully.
	 * 
	 * @param formBean -FormBean Object
	 * @param request the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(GatePassTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		boolean retValue = true;
		GatePassTypeMstVO vo = null;
		GatePassTypeMstBO bo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";

		try {

			bo = new GatePassTypeMstBO();
			vo = new GatePassTypeMstVO();

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrGatePassTypeCode(strtemp[0]);
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrLastModifiedSeatId(seatid);
			vo.setStrSeatId(seatid);
			vo.setStrGatePassTypeName(formBean.getStrGatePassTypeName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrIsValid(formBean.getStrIsValid());

			bo.updateQuery(vo);

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
			strmsgText = "GatePassTypeMaster.GatePassTypeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"GatePassTypeMstDATA->updateRecord()", strmsgText);
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
