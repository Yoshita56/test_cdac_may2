package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.CommitteeTypeMstBO;
import mms.masters.controller.fb.CommitteeTypeMstFB;
import mms.masters.vo.CommitteeTypeMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer - Tanvi Sappal Version - 1.0 Changes done on 21/Aprl/2009
 */

public class CommitteeTypeMstDATA {

	/**
	 * to display the current date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(CommitteeTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
	//	String strComboName = "";
	//	String temp[] = null;
		try {
			hisutil = new HisUtil("mms", "CommitteeTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		/*	if (formBean.getStrComboValue().equals("")) {
				strComboName = request.getParameter("comboValue");
				
			} else {
				strComboName = formBean.getStrComboValue();
			}
*/
			//formBean.setStrComboValue(strComboName);
			//temp = strComboName.replace('^', '#').split("#");

			//formBean.setStrProcessName(temp[0]);

		} catch (Exception e) {
			strmsgText = "CommitteeTypeMaster.CommitteeTypeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CommitteeTypeMstDATA->initialAdd()", strmsgText);
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

	public static void insertRecord(CommitteeTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		CommitteeTypeMstVO vo = null;
		CommitteeTypeMstBO bo = null;

		try {
			bo = new CommitteeTypeMstBO();
			vo = new CommitteeTypeMstVO();

//			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
//					.toString();
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			//String strItemCatNo = formBean.getCombo()[0];
			//String strProcessId = formBean.getCombo()[0];

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			//formBean.setStrItemCatNo(strItemCatNo);
			//formBean.setStrProcessId(strProcessId);

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			//vo.setStrItemCatNo(strItemCatNo);
			//vo.setStrProcessId(strProcessId);
			vo.setStrIsValid("1");

			vo.setStrCommitteeTypeName(formBean.getStrCommitteeTypeName());
			vo.setStrCommitteePurpose(formBean.getStrCommitteePurpose());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrCommitteeTypeId(formBean.getStrCommitteeTypeId());

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
			strmsgText = "CommitteeTypeMaster.CommitteeTypeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CommitteeTypeMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(CommitteeTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		CommitteeTypeMstVO vo = null;
		CommitteeTypeMstBO bo = null;
		String chk = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		HisUtil hisutil = null;
		String strComboName = "";
		String temp[] = null;

		try {
			bo = new CommitteeTypeMstBO();
			vo = new CommitteeTypeMstVO();

			hisutil = new HisUtil("mms", "CommitteeTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			if (formBean.getStrComboValue().equals("")) {
				strComboName = request.getParameter("comboValue");
				
			} else {
				strComboName = formBean.getStrComboValue();
			}

			formBean.setStrComboValue(strComboName);
			temp = strComboName.replace('^', '#').split("#");

			//formBean.setStrItemCatName(temp[0]);
			formBean.setStrProcessName(temp[0]);

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			//String strItemCatNo = formBean.getCombo()[0];
			String strProcessId = formBean.getCombo()[0];

			vo.setStrCommitteeTypeId(strtemp[0]);
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrLastModifiedSeatId(seatid);
			//vo.setStrItemCatNo(strItemCatNo);
			vo.setStrProcessId(strProcessId);

			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			//formBean.setStrItemCatNo(vo.getStrItemCatNo());
			formBean.setStrProcessId(vo.getStrProcessId());
			formBean.setStrCommitteeTypeName(vo.getStrCommitteeTypeName());
			formBean.setStrCommitteePurpose(vo.getStrCommitteePurpose());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk(request.getParameter("chk"));
		} catch (Exception e) {

			strmsgText = "CommitteeTypeMaster.CommitteeTypeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CommitteeTypeMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(CommitteeTypeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		CommitteeTypeMstVO vo = null;
		CommitteeTypeMstBO bo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";

		try {
			bo = new CommitteeTypeMstBO();
			vo = new CommitteeTypeMstVO();

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];			

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
		
			vo.setStrCommitteeTypeId(strtemp[0]);
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrLastModifiedSeatId(seatid);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrSeatId(seatid);
			
			vo.setStrCommitteeTypeName(formBean.getStrCommitteeTypeName());
			vo.setStrCommitteePurpose(formBean.getStrCommitteePurpose());
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
					formBean.setStrMsg("Record Modified Successfully");
				}
			}

		} catch (Exception e) {

			strmsgText = "CommitteeTypeMaster.CommitteeTypeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CommitteeTypeMstDATA->updateRecord()", strmsgText);
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
