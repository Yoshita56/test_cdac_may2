package mms.masters.controller.data;

import java.io.IOException;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;



import mms.masters.bo.ApprovingAuthorityMstBO;
import mms.masters.controller.fb.ApprovingAuthorityMstFB;
import mms.masters.vo.ApprovingAuthorityMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Pramod Kumar Mehta
 * Version : 1.0
 * Date : 14/April/2009
 * Module:MMS
 * Unit:Approving Authority Master
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Modify Date : 22/May/2009
 * 
 */

public class ApprovingAuthorityMstDATA {

	/**
	 * This method is used to update the record in database for this activity
	 * call the insertRecord()method of ApprovingAuthorityMstBO java file.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insert(HttpServletRequest request,
			ApprovingAuthorityMstFB formBean) {
		
		ApprovingAuthorityMstBO bo = null;
		ApprovingAuthorityMstVO vo = null;
		int nRightListLen = 0;
		String UserArray[] = null;

		try {
			vo = new ApprovingAuthorityMstVO();
			bo = new ApprovingAuthorityMstBO();

			vo.setStrStoreId(request.getParameter("strStoreId"));

			vo
					.setStrApprovingTypeId(request
							.getParameter("strApprovingTypeId"));

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			vo.setStrApprovingTypeVal(formBean.getStrApprovingType());
			vo.setStrStoreVal(formBean.getStrStoreName());
			vo.setStrEffectiveDate(formBean.getStrEffectiveDate());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid("1");
			vo.setStrCommitteeFlag(formBean.getStrCommitteeFlag());
			UserArray = formBean.getStrUserName();

			nRightListLen = UserArray.length;
			for (int i = 0; i < nRightListLen; i++) {
				if (!UserArray[i].equals("0")) {
					vo.setStrUserId(UserArray[i]);
					bo.insertRecord(vo);
					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}
				}

			}

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else {
				formBean.setStrNormalMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ApprovingAuthorityMstDATA->insert()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}

	/**
	 * This method is used to populate the value of User name list box on add
	 * page.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 */
	public static void addUserListValue(HttpServletRequest request,
			ApprovingAuthorityMstFB formBean) {
		ApprovingAuthorityMstBO bo = null;
		ApprovingAuthorityMstVO vo = null;
		String[] strTemp = null;
		HisUtil hisutil = null;
		WebRowSet ws = null;
		String strLUserList = "";
		String strRUserList = "";

		try {

			vo = new ApprovingAuthorityMstVO();
			bo = new ApprovingAuthorityMstBO();
			hisutil = new HisUtil("mms", "ApprovingAuthorityMstDATA");

			String strComboVal = request.getParameter("comboValue");
			strTemp = strComboVal.replace("^", "#").split("#");

			formBean.setStrApprovingType(strTemp[0]);
			formBean.setStrStoreName(strTemp[1]);

			String strStoreId = formBean.getCombo()[1];
			formBean.setStrStoreId(strStoreId);

			String strApprovingTypeId = formBean.getCombo()[0];
			formBean.setStrApprovingTypeId(strApprovingTypeId);
			
			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();

			formBean.setStrCtDate(hisutil.getASDate("dd-MMM-yyyy"));

			vo.setStrUserId(formBean.getStrUserId());
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrStoreId(strStoreId);
			vo.setStrApprovingTypeId(strApprovingTypeId);
			vo.setStrCommitteeFlag("0"); //default is non committee

			bo.addUserListValue(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			ws = vo.getStrUserNameWS();
			if (ws != null)
				strLUserList = hisutil.getOptionValue(ws, "", "", true);
			formBean.setStrUserList(strLUserList);

			if (vo.getStrRUserListWS() != null)
				strRUserList = hisutil.getOptionValue(vo.getStrRUserListWS(),
						"", "", true);
			formBean.setStrRUserList(strRUserList);

		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ApprovingAuthorityMstDATA->addUserListValue()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}
	}

	/**
	 * This method is used to modify the recod.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void modifyRecord(ApprovingAuthorityMstFB formBean,
			HttpServletRequest request) {
		ApprovingAuthorityMstBO bo = null;
		ApprovingAuthorityMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
		String strTemp[] = null;
		String strTemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;

		try {
			String strComboVal = request.getParameter("comboValue");
			strTemp = strComboVal.replace("^", "#").split("#");

			formBean.setStrApprovingType(strTemp[0]);
			formBean.setStrStoreName(strTemp[1]);
			hisutil = new HisUtil("mms", "ApprovingAuthorityMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			bo = new ApprovingAuthorityMstBO();
			vo = new ApprovingAuthorityMstVO();
			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strTemp2 = strtemp[1].replace('$', '#').split("#");
			vo.setStrAppId(strtemp[0]);
			vo.setStrHospitalCode(strTemp2[0]);

			bo.modifyRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrUserNameModify(vo.getStrUserNameModify());
			formBean.setStrEffectiveDate(vo.getStrEffectiveDate());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());

			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "ApprovingAuthorityMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ApprovingAuthorityMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * This method is used to update the record in database for this activity
	 * call the updateRecord()method of ApprovingAuthorityMstBO java file.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(ApprovingAuthorityMstFB formBean,
			HttpServletRequest request) {
		ApprovingAuthorityMstBO bo = null;
		ApprovingAuthorityMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;

		String chk = "";
		HisUtil hisutil = null;

		boolean retValue = true;
		try {
			bo = new ApprovingAuthorityMstBO();
			vo = new ApprovingAuthorityMstVO();
			hisutil = new HisUtil("mms", "ApprovingAuthorityMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			vo.setStrHospitalCode(strHospitalCode);
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			vo.setStrSeatId(seatid);

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			vo.setStrAppId(strtemp[0]);
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrEffectiveDate(formBean.getStrEffectiveDate());
			vo.setStrRemarks(formBean.getStrRemarks());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrChk1(chk);

		} catch (Exception e) {

			strmsgText = "ApprovingAuthorityMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ApprovingAuthorityMstDATA->updateRecord()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

	public static void populateList(HttpServletRequest request,
			HttpServletResponse response) {
		HisUtil util = null;

		ApprovingAuthorityMstBO bo 	= null;
		ApprovingAuthorityMstVO vo 	= null;

		String strApprovingTypeId 	= null;
		String strStoreId			= null;
		String strCommitteeFlag 	= null;
		
		String strHospitalCode 		= null;
		
		String strLeftListOptions 	= null;
		String strRightListOptions 	= null;

		String strResponseString = null;
		StringBuffer sbResponseStringBuffer = null;

		try {

			util = new HisUtil("MMS", "ApprovingAuthorityMstDATA");

			vo = new ApprovingAuthorityMstVO();
			bo = new ApprovingAuthorityMstBO();

			sbResponseStringBuffer = new StringBuffer();

			strHospitalCode = request.getSession()
					.getAttribute("HOSPITAL_CODE").toString();

			/* Getting Request Parameter */
			strApprovingTypeId 	= request.getParameter("strApprovingTypeId");
			strStoreId 			= request.getParameter("strStoreId");
			strCommitteeFlag 	= request.getParameter("strCommitteeFlag");

			/* Setting values in vo */
			vo.setStrApprovingTypeId(strApprovingTypeId);
			vo.setStrStoreId(strStoreId);
			vo.setStrCommitteeFlag(strCommitteeFlag);
			vo.setStrHospitalCode(strHospitalCode);
			

			bo.addUserListValue(vo);

			strLeftListOptions = util.getOptionValue(
					vo.getStrUserNameWS(), "", "",
					false);
			strRightListOptions = util.getOptionValue(
					vo.getStrRUserListWS(), "", "",
					false);

			sbResponseStringBuffer.append("SUCCESS");
			sbResponseStringBuffer.append("####");
			sbResponseStringBuffer.append(strLeftListOptions);
			sbResponseStringBuffer.append("^");
			sbResponseStringBuffer.append(strRightListOptions);


		} catch (Exception _e) {

			HisException eObj = new HisException("MMS",
					"ApprovingAuthorityMstDATA --> populateList() -->",
					_e.getMessage());

			sbResponseStringBuffer.append("ERROR");
			sbResponseStringBuffer.append("####");
			sbResponseStringBuffer.append("Application Error [ERROR ID : ");
			sbResponseStringBuffer.append(eObj.getErrorID());
			sbResponseStringBuffer.append("], Contact System Administrator! ");

			eObj = null;
		} finally {

			strResponseString = sbResponseStringBuffer.toString();
			try {
				response.getWriter().write(strResponseString);
			} catch (IOException e) {

				new HisException("MMS",
						"ApprovingAuthorityMstDATA --> populateList() -->",
						e.getMessage());
			}
		}
		
	}

}
