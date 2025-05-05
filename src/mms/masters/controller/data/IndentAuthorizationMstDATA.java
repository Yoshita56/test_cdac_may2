package mms.masters.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.masters.bo.IndentAuthorizationMstBO;
import mms.masters.controller.fb.IndentAuthorizationMstFB;
import mms.masters.controller.hlp.IndentAuthorizationMstHLP;
import mms.masters.vo.IndentAuthorizationMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentAuthorizationMstDATA.
 */
public class IndentAuthorizationMstDATA {

	/**
	 * Initial add.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(IndentAuthorizationMstFB formBean,
			HttpServletRequest request) {

		IndentAuthorizationMstBO bo = null;
		IndentAuthorizationMstVO vo = null;
		HisUtil hisutil = null;
		String temp[] = null;
		String strmsgText = "";
		String strStoreId = "";
		String ctDate = "";
		String hosCode = "";
		String seatid = "";
		String cmb = "";
		String strComboName = "";
		String strStoreName = "";
		String strItemCategoryName = "";
		String strAuthorizationFor = "";
		String strType = "";

		String strCategoryNo = "";
		String strAuthorizationForId = "";
		String strTypeId = "";

		try {
			bo = new IndentAuthorizationMstBO();
			vo = new IndentAuthorizationMstVO();

			hisutil = new HisUtil("mms", "IndentAuthorizationMstDATA");
			ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			if (formBean.getStrComboValue().equals("")) {
				strComboName = request.getParameter("comboValue");

			} else {
				strComboName = formBean.getStrComboValue();
			}

			formBean.setStrComboValue(strComboName);
			temp = strComboName.replace('^', '#').split("#");
			strStoreName = temp[0];
			strItemCategoryName = temp[1];
			strAuthorizationFor = temp[2];
			strType = temp[3];

			formBean.setStrStoreName(strStoreName);
			formBean.setStrItemCategoryName(strItemCategoryName);
			formBean.setStrAuthorizationForName(strAuthorizationFor);
			formBean.setStrType(strType);

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			strStoreId = formBean.getCombo()[0];
			strCategoryNo = formBean.getCombo()[1];
			strAuthorizationForId = formBean.getCombo()[2];
			strTypeId = formBean.getCombo()[3];

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCatNo(strCategoryNo);
			vo.setStrAuthtypeForId(strAuthorizationForId);
			vo.setStrTypeId(strTypeId);
			vo.setStrIsValid("1");

			bo.initAdd(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			String strValue = IndentAuthorizationMstHLP.getAddedItemDetails(vo
					.getStrIndentAuthorizationDetails());

			formBean.setStrAddedData(strValue);

			cmb = hisutil.getOptionValue(vo.getStrEmployeeNameComboWs(),
					"0^Select Value", "Select Value", true);

			formBean.setStrEmployeeNameValues(cmb);

		} catch (Exception e) {
			strmsgText = "Indent Authorization Master.IndentAuthorizationMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentAuthorizationMstDATA->initialAdd()", strmsgText);
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
	public static void insertRecord(IndentAuthorizationMstFB formBean,
			HttpServletRequest request) {
		IndentAuthorizationMstBO bo = null;
		IndentAuthorizationMstVO vo = null;
		String strCategoryNo = "";
		String strAuthorizationForId = "";
		String strTypeId = "";
		String strmsgText = "";
		 

		String strStoreId = "";
		String hosCode = "";
		String seatid = "";
	//	String strStoreCombo = "";

		try {
			bo = new IndentAuthorizationMstBO();
			vo = new IndentAuthorizationMstVO();
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			strStoreId = formBean.getCombo()[0];
			strCategoryNo = formBean.getCombo()[1];
			strAuthorizationForId = formBean.getCombo()[2];
			strTypeId = formBean.getCombo()[3];

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrStoreId(strStoreId);
			formBean.setStrIsValid("1");
			formBean.setStrItemCatNo(strCategoryNo);
			formBean.setStrAuthtypeForId(strAuthorizationForId);
			formBean.setStrTypeId(strTypeId);

			for (int i = 0 , stopI = formBean.getStrEmpId().length; i < stopI; i++) {
				vo.setStrEmpId(formBean.getStrEmpId());
				vo.setStrLevel(formBean.getStrLevel());

			}

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrItemCatNo(formBean.getStrItemCatNo());
			vo.setStrAuthtypeForId(formBean.getStrAuthtypeForId());
			vo.setStrTypeId(formBean.getStrTypeId());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());

			bo.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.isBExistStatus() == false) {
				formBean.setStrWarning("Data already exist");
			} else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {

			strmsgText = "Indent Authorization Master.IndentAuthorizationMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentAuthorizationMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(IndentAuthorizationMstFB formBean,
			HttpServletRequest request) {
		IndentAuthorizationMstBO bo = null;
		IndentAuthorizationMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;
		String temp[] = null;

	/*	String strCategoryNo = "";
		String hosCode = "";
		String seatid = "";
		String strStoreCombo = "";*/
		String strStoreName = "";
		String strComboName = "";
		String strItemCategoryName = "";
		String cmb = "";
		String ctDate = "";
		String strAuthorizationFor = "";
		String strType = "";

		try {
			bo = new IndentAuthorizationMstBO();
			vo = new IndentAuthorizationMstVO();
			hisutil = new HisUtil("mms", "IndentAuthorizationMstDATA");
			ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			if (formBean.getStrComboValue().equals("")) {
				strComboName = request.getParameter("comboValue");
			} else {
				strComboName = formBean.getStrComboValue();
			}
			// //System.out.println("strComboName="+strComboName);
			formBean.setStrComboValue(strComboName);
			temp = strComboName.replace('^', '#').split("#");
			strStoreName = temp[0];
			strItemCategoryName = temp[1];
			strAuthorizationFor = temp[2];
			strType = temp[3];

			formBean.setStrStoreName(strStoreName);
			formBean.setStrItemCategoryName(strItemCategoryName);
			formBean.setStrAuthorizationForName(strAuthorizationFor);
			formBean.setStrType(strType);

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrAuthorizationNo(strtemp2[0]);

			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			TransferObjectFactory.populateData(formBean, vo);

			cmb = hisutil.getOptionValue(vo.getStrEmployeeNameComboWs(), vo
					.getStrEmployeeId(), "Select Value", true);

			formBean.setStrEmployeeNameValues(cmb);

			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "Indent Authorization Master.IndentAuthorizationMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentAuthorizationMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(IndentAuthorizationMstFB formBean,
			HttpServletRequest request) {

		IndentAuthorizationMstBO bo = null;
		IndentAuthorizationMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		String seatid = "";

		try {
			bo = new IndentAuthorizationMstBO();
			vo = new IndentAuthorizationMstVO();

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrAuthorizationNo(strtemp2[0]);
			seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrSeatId(seatid);
			vo.setStrEmployeeId(formBean.getStrEmployeeId());
			vo.setStrLevel1(formBean.getStrLevel1());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.isBExistStatus() == false) {
				retValue = false;
				formBean.setStrWarning("Data already exist");
			} else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {

			strmsgText = "Indent Authorization Master.IndentAuthorizationMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"IndentAuthorizationMstDATA->updateRecord()", strmsgText);
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
