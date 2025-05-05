package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.MmsConfigUtil;
import mms.masters.bo.SupplierGradeMstBO;
import mms.masters.controller.fb.SupplierGradeMstFB;
import mms.masters.vo.SupplierGradeMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierGradeMstDATA.
 * 
 * @author Tanvi Sappal
 */

public class SupplierGradeMstDATA {

	/**
	 * to display the current date.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(SupplierGradeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		HisUtil hisutil = null;
		try {
			hisutil = new HisUtil("mms", "CommitteeTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

		} catch (Exception e) {
			strmsgText = "SupplierGradeMaster.SupplierGradeMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierGradeMstDATA->initialAdd()", strmsgText);
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
	public static void insertRecord(SupplierGradeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		SupplierGradeMstVO vo = null;
		SupplierGradeMstBO bo = null;

		try {
			bo = new SupplierGradeMstBO();
			vo = new SupplierGradeMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			hosCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrIsValid("1");
			vo.setStrGradeName(formBean.getStrGradeName());
			vo.setStrGradeCriteria(formBean.getStrGradeCriteria());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrSupplierGradeId(formBean.getStrSupplierGradeId());

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
			strmsgText = "SupplierGradeMst.SupplierGradeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierGradeMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(SupplierGradeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";

		SupplierGradeMstVO vo = null;
		SupplierGradeMstBO bo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;

		try {
			bo = new SupplierGradeMstBO();
			vo = new SupplierGradeMstVO();

			hisutil = new HisUtil("mms", "CommitteeTypeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
//			14@100@1$4
			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];

			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrSupplierGradeId(strtemp[0]);
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrSeatId(seatid);

			bo.modifyQuery(vo);

			formBean.setStrGradeName(vo.getStrGradeName());
			formBean.setStrGradeCriteria(vo.getStrGradeCriteria());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk(request.getParameter("chk"));

		} catch (Exception e) {
			strmsgText = "SupplierGradeMst.SupplierGradeMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierGradeMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(SupplierGradeMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		boolean retValue = true;
		SupplierGradeMstVO vo = null;
		SupplierGradeMstBO bo = null;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";

		try {

			bo = new SupplierGradeMstBO();
			vo = new SupplierGradeMstVO();

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[2].replace('$', '#').split("#");
			strtemp[2] = strtemp2[0];
						
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrSupplierGradeId(strtemp[0]);
			vo.setStrHospitalCode(strtemp[1]);
			vo.setStrSlNo(strtemp[2]);
			vo.setStrSeatId(seatid);

			vo.setStrGradeName(formBean.getStrGradeName());
			vo.setStrGradeCriteria(formBean.getStrGradeCriteria());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrLastModifiedSeatId(seatid);
			vo.setStrSeatId(seatid);
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
			strmsgText = "SupplierGradeMst.SupplierGradeMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SupplierGradeMstDATA->updateRecord()", strmsgText);
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
