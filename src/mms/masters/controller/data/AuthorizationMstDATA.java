package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import javax.servlet.http.HttpServletRequest;
import mms.masters.bo.AuthorizationMstBO;
import mms.masters.controller.fb.AuthorizationMstFB;
import mms.masters.vo.AuthorizationMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorizationMstDATA.
 */
public class AuthorizationMstDATA {

	/**
	 * Initial add.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(AuthorizationMstFB formBean,
			HttpServletRequest request) {

		AuthorizationMstVO vo = null;
		AuthorizationMstBO bo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String cmb = "";
		try {
			bo = new AuthorizationMstBO();
			vo = new AuthorizationMstVO();

			hisutil = new HisUtil("mms", "AuthorizationMstBO");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strStoreTypeName = request.getParameter("comboValue");
			formBean.setStrStoreTypeCombo(strStoreTypeName);

			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrAuthorizationTypeId("0");
			formBean.setStrAuthorizationLevel("0");

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			bo.initAdd(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStrUserNameComboWS() != null
					&& vo.getStrUserNameComboWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getStrUserNameComboWS(), vo
						.getStrUserId(), "0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			formBean.setStrUserNameCombo(cmb);

		} catch (Exception e) {
			strmsgText = "Authorization Master.AuthorizationMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AuthorizationMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
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

	public static void insertRecord(AuthorizationMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		AuthorizationMstVO vo = null;
		AuthorizationMstBO bo = null;

		try {
			bo = new AuthorizationMstBO();
			vo = new AuthorizationMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strStoreId = formBean.getCombo()[0];

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrStoreId(strStoreId);

			vo.setStrSeatId(seatid);
			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(strStoreId);
			vo.setStrIsValid("1");

			vo.setStrUserId(formBean.getStrUserId());
			vo.setStrAuthorizationTypeId(formBean.getStrAuthorizationTypeId());
			vo.setStrAuthorizationLevel(formBean.getStrAuthorizationLevel());
			vo.setStrCostForm(formBean.getStrCostForm());
			vo.setStrCost(formBean.getStrCost());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());

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
			strmsgText = "Authorization Master.AuthorizationMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AuthorizationMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
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
	public static void modifyRecord(AuthorizationMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";

		String chk = "";

		String strtemp[] = null;
		String strtemp2[] = null;
		AuthorizationMstVO vo = null;
		AuthorizationMstBO bo = null;
		HisUtil hisutil = null;

		try {
			bo = new AuthorizationMstBO();
			vo = new AuthorizationMstVO();

			hisutil = new HisUtil("mms", "AuthorizationMstBO");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String strStoreTypeName = request.getParameter("comboValue");
			formBean.setStrStoreTypeCombo(strStoreTypeName);

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");

			vo.setStrHospitalCode(strtemp2[0]);
			vo.setStrAuthorizationSlNo(strtemp[0]);

			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrAuthorizationType(vo.getStrAuthorizationType());
			formBean.setStrAuthorizationLevel(vo.getStrAuthorizationLevel());
			formBean.setStrUserName(vo.getStrUserName());
			formBean.setStrCostForm(vo.getStrCostForm());
			formBean.setStrCost(vo.getStrCost());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk(request.getParameter("chk"));

		} catch (Exception e) {
			strmsgText = "Authorization Master.AuthorizationMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AuthorizationMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(AuthorizationMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";

		AuthorizationMstVO vo = null;
		AuthorizationMstBO bo = null;

		try {
			bo = new AuthorizationMstBO();
			vo = new AuthorizationMstVO();

			// String strStoreTypeName = request.getParameter("comboValue");
			// formBean.setStrStoreTypeCombo(strStoreTypeName);
			String lastSeatid = request.getSession().getAttribute("SEATID")
					.toString();

			chk = request.getParameter("chk");
			// chk = formBean.getStrChk();
			strtemp = chk.replace('@', '#').split("#");

			strtemp2 = strtemp[1].replace('$', '#').split("#");

			vo.setStrAuthorizationSlNo(strtemp[0]);
			vo.setStrHospitalCode(strtemp2[0]);
			vo.setStrLastModifiedSeatId(lastSeatid);
			vo.setStrCostForm(formBean.getStrCostForm());

			if (formBean.getStrCost() == null
					|| formBean.getStrCost().equals("")) {
				formBean.setStrCost("");
			}

			vo.setStrCost(formBean.getStrCost());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrIsValid(formBean.getStrIsValid());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());

			}
			// TransferObjectFactory.populateData(formBean, vo);

		} catch (Exception e) {
			retValue = false;
			strmsgText = "Authorization Master.AuthorizationMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AuthorizationMstDATA->updateRecord()", strmsgText);
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
