package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.MaintenanceTypeMstBO;
import mms.masters.controller.fb.MaintenanceTypeMstFB;
import mms.masters.vo.MaintenanceTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class MaintenanceTypeMstDATA.
 */
public class MaintenanceTypeMstDATA {

	/**
	 * to display the current date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(MaintenanceTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			hisutil = new HisUtil("mms", "MaintenanceTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

		} catch (Exception e) {
			strmsgText = "MaintenanceTypeMaster.MaintenanceTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MaintenanceTypeMstDATA->initialAdd()", strmsgText);
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
	public static void insertRecord(MaintenanceTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		MaintenanceTypeMstVO vo = null;
		MaintenanceTypeMstBO bo = null;

		try {
			bo = new MaintenanceTypeMstBO();
			vo = new MaintenanceTypeMstVO();

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrIsValid("1");
			vo.setStrMaintenanceTypeName(formBean.getStrMaintenanceTypeName());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrMaintenanceTypeCode(formBean.getStrMaintenanceTypeCode());

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
			strmsgText = "MaintenanceTypeMaster.MaintenanceTypeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MaintenanceTypeMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(MaintenanceTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		MaintenanceTypeMstVO vo = null;
		MaintenanceTypeMstBO bo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";

		try {
			bo = new MaintenanceTypeMstBO();
			vo = new MaintenanceTypeMstVO();

			hisutil = new HisUtil("mms", "GatePassTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrMaintenanceTypeCode(strtemp[0]);
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrLastModifiedSeatId(seatid);

			bo.modifyQuery(vo);

			formBean.setStrMaintenanceTypeName(vo.getStrMaintenanceTypeName());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk(request.getParameter("chk"));

		} catch (Exception e) {
			strmsgText = "MaintenanceTypeMaster.MaintenanceTypeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MaintenanceTypeMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(MaintenanceTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		boolean retValue = true;
		MaintenanceTypeMstVO vo = null;
		MaintenanceTypeMstBO bo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";

		try {

			bo = new MaintenanceTypeMstBO();
			vo = new MaintenanceTypeMstVO();

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrMaintenanceTypeCode(strtemp[0]);
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrSeatId(seatid);
			
			vo.setStrMaintenanceTypeName(formBean.getStrMaintenanceTypeName());
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
			strmsgText = "MaintenanceTypeMaster.MaintenanceTypeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"MaintenanceTypeMstDATA->updateRecord()", strmsgText);
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
