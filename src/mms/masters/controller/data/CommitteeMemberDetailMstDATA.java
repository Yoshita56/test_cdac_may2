/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 20/Jan/2009
 *  
 */
package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.masters.bo.CommitteeMemberDetailMstBO;
import mms.masters.controller.fb.CommitteeMemberDetailMstFB;
import mms.masters.controller.hlp.CommitteeMemberDetailMstHLP;
import mms.masters.vo.CommitteeMemberDetailMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class CommitteeMemberDetailMstDATA.
 */
public class CommitteeMemberDetailMstDATA {
	
	
	/**
	 * to display the Store Type Name on Add page or modify page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(CommitteeMemberDetailMstFB formBean,
			HttpServletRequest request) {
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		HisUtil hisutil = null;
		String hosCode;
		String strmsgText;
		String seatid;
		String cmb;
		
		try {
			hisutil = new HisUtil("MMS", "CommitteeMemberDetailMstDATA");
			bo = new CommitteeMemberDetailMstBO();
			vo = new CommitteeMemberDetailMstVO();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			String strCatCodes="";
		
			
			if(request.getSession().getAttribute("USERVALUE") != null){
				
				strCatCodes = request.getSession().getAttribute("USERVALUE").toString();
			}else{
				
				strCatCodes = "0";
			}
			
			vo.setStrCatCodesFromSession(strCatCodes); 
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
            // Calling BO Method
			bo.initialAdd(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
            // Calling BO Method
			bo.getCatValue(vo);
			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());

			if (vo.getItemCategoryWS() != null
					&& vo.getItemCategoryWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getItemCategoryWS(), "0",
						"0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrCatValues(cmb);
			// Calling BO Method
			bo.getReqType(vo);
			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());

			if (vo.getReqTypeWS() != null && vo.getReqTypeWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getReqTypeWS(), "0",
						"0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
			
			bo.getCommType(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			cmb = hisutil.getOptionValue(vo.getCommTypeWS(), "0",
					"0^Select Value", true);

			formBean.setStrCommitteTypeVals(cmb);
			formBean.setStrCommitteTypeCombo(vo.getStrCommitteTypeCombo());
			formBean.setStrUpdateEmpInfHLPWs(vo.getStrMemberDtlWs());
			formBean.setStrEmpNumber(vo.getStrEmpNumber());

		} catch (Exception e) {
            e.printStackTrace();
			strmsgText = "CommitteeMemberDetailMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CommitteeMemberDetailMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * ***************************Ajax Function
	 * **********************************.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */

	public static void UNITVAL1(HttpServletRequest request,
			HttpServletResponse response, CommitteeMemberDetailMstFB formBean) {
		// Declaring Variables
		String strmsgText;
		String strCommitteTypeId = null;
		String strRes = null;
		String strMemberDtl = null;
		// Creating Object for BO & VO.
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;

		HisUtil hisutil = null;
		try {
			vo = new CommitteeMemberDetailMstVO();
			bo = new CommitteeMemberDetailMstBO();
			hisutil = new HisUtil("transaction", "CommitteeMemberDetailMstDATA");
			strCommitteTypeId = request.getParameter("modName");
			vo.setStrCommetieTypeId(strCommitteTypeId);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			vo.setStrCatNo(request.getParameter("catCode"));
			// Call BO TariffCombo Method
			bo.getCommettieeDtlHLP(vo);
			strMemberDtl = CommitteeMemberDetailMstHLP.getMemberDTL(vo.getStrMemberDtlWs());

			if (vo.getStrCommitteTypeCombo() != null)
			{
				response.setHeader("Cache-Control", "no-cache");
				strRes = vo.getStrCommitteDtl() + "@@@" + strMemberDtl;
				response.getWriter().print(strRes);
			}

		} 
		catch (Exception e)
		{
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS",
					"CommitteeMemberDetailMstDATA->UNITVAL1()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} 
		finally 
		{
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
			if (bo != null)
				bo = null;
		}

	}

	/**
	 * UNITVA l4.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void UNITVAL4(HttpServletRequest request,
			HttpServletResponse response, CommitteeMemberDetailMstFB formBean) {
		// Declaring Variables

		String strmsgText = "";
		String strChk = null;
		WebRowSet wb = null;

		String name = null;
		String addr = null;
		String phone = null;
		String email = null;

		// Creating Object for BO & VO.
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		HisUtil hisutil = null;
		try {
			vo = new CommitteeMemberDetailMstVO();
			bo = new CommitteeMemberDetailMstBO();
			hisutil = new HisUtil("transaction", "CommitteeMemberDetailMstDATA");
			strChk = request.getParameter("modName");
			String[] temp = strChk.split("\\^");

			vo.setStrChk1(temp[0]);
			vo.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());
			// Call BO TariffCombo Method
			bo.getUNITVAL4(vo);
			wb = vo.getStrEmpInfDataWs();

			while (wb.next()) {

				name = wb.getString(3);

				addr = wb.getString(4);

				phone = wb.getString(5);

				email = wb.getString(6);

			}

			String sendData = name + "@@" + addr + "@@" + phone + "@@" + email;
			String output = sendData + "$" + temp[1];
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(output);

		} catch (Exception e) {
			// e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS",
					"IpdBillManagementTransDATA->UNITVAL4()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} finally {
			wb = null;
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
			if (bo != null)
				bo = null;
		}

	}

	/**
	 * UNITVA l5.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void UNITVAL5(HttpServletRequest request,
			HttpServletResponse response, CommitteeMemberDetailMstFB formBean) {
		// Declaring Variables

		String strmsgText = "";
		String strChk = null;
		String name = null;
		String addr = null;
		String phone = null;
		String email = null;

		// Creating Object for BO & VO.

		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		HisUtil hisutil = null;
		try {
			vo = new CommitteeMemberDetailMstVO();
			bo = new CommitteeMemberDetailMstBO();
			hisutil = new HisUtil("transaction", "CommitteeMemberDetailMstDATA");
			strChk = request.getParameter("modName");
			String[] temp = strChk.split("\\^");

			vo.setStrChk1(temp[0]);

			vo.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());
			// Call BO TariffCombo Method
			bo.getUNITVAL5(vo);

			name = vo.getStrEmpNameHLP();

			addr = vo.getStrEmpAddrHLP();

			phone = vo.getStrEmpPhoneHLP();

			email = vo.getStrEmpEmailHLP();

			String sendData = name + "@@" + addr + "@@" + phone + "@@" + email
					+ "@@" + vo.getStrUserIdCombo();
			String output = sendData + "$" + temp[1];
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(output);

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS",
					"IpdBillManagementTransDATA->UNITVAL5()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
			if (bo != null)
				bo = null;
		}

	}

	/**
	 * UNITVA l3.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void UNITVAL3(HttpServletRequest request,
			HttpServletResponse response, CommitteeMemberDetailMstFB formBean) {
		// Declaring Variables
		String strmsgText = "";
		String strChk = null;
		String strRes = "";

		// Creating Object for BO & VO.
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		HisUtil hisutil = null;
		try {
			vo = new CommitteeMemberDetailMstVO();
			bo = new CommitteeMemberDetailMstBO();
			hisutil = new HisUtil("transaction", "CommitteeMemberDetailMstDATA");
			strChk = (String) request.getParameter("hlp");
			vo.setStrTmp(strChk);
			strRes = CommitteeMemberDetailMstHLP.getUpdatedMemberHLP1(vo);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strRes);

		} catch (Exception e) {
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS",
					"IpdBillManagementTransDATA->UNITVAL3()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
			if (bo != null)
				bo = null;
		}

	}

	/**
	 * UNITVA l2.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 */
	public static void UNITVAL2(HttpServletRequest request,
			HttpServletResponse response, CommitteeMemberDetailMstFB formBean) {
		// Declaring Variables

		String strmsgText = "";
		String strChk = "";
		String strRes = "";

		// Creating Object for BO & VO.
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		HisUtil hisutil = null;
		try {
			vo = new CommitteeMemberDetailMstVO();
			bo = new CommitteeMemberDetailMstBO();
			hisutil = new HisUtil("transaction", "CommitteeMemberDetailMstDATA");
			strChk = (String) request.getParameter("hlp");
			vo.setStrTmp(strChk);
			strRes = CommitteeMemberDetailMstHLP.getUpdatedMemberHLP(vo);
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strRes);

		} catch (Exception e) {
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS",
					"CommitteeMemberDetailMstDATA->UNITVAL2()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
			if (bo != null)
				bo = null;
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insertRecord(CommitteeMemberDetailMstFB formBean,HttpServletRequest request) 
	{
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		String strmsgText = "";
		

		try 
		{
			bo = new CommitteeMemberDetailMstBO();
			vo = new CommitteeMemberDetailMstVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(seatid);
			vo.setStrPrevVal(formBean.getStrPrevVal());
			vo.setStrChkBox(formBean.getStrCheckBox());
			vo.setStrCommetieTypeId(formBean.getStrCommitteType());
			vo.setStrCatNo(formBean.getStrCatNo());
            
			bo.AddRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();

			strmsgText = "CommitteeMemberDetailMaster.CommitteeMemberDetailMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugSaftyAlertMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insertRecord1(CommitteeMemberDetailMstFB formBean,
			HttpServletRequest request) {
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new CommitteeMemberDetailMstBO();
			vo = new CommitteeMemberDetailMstVO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			// String seatid =
			// request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(strHospitalCode);
			if (formBean.getStrEmpNo() == null) {
				if (formBean.getStrEmpNoUpdate() != null) {
					vo.setStrCommitteNo(formBean.getStrCommitteNo());
					vo.setStrCommeitteSlNo(formBean.getStrCommeitteSlNo());
					vo.setStrEmpNoUpdate(formBean.getStrEmpNoUpdate());
					vo.setStrEmpNameUpdate(formBean.getStrEmpNameUpdate());
					vo.setStrEmpAddrUpdate(formBean.getStrEmpAddrUpdate());
					vo.setStrEmpPhoneUpdate(formBean.getStrEmpPhoneUpdate());
					vo.setStrEmpEmailUpdate(formBean.getStrEmpEmailUpdate());
					vo.setStrEmpUserIdUpdate(formBean.getStrEmpUserIdUpdate());
					vo.setStrEmpLevelUpdate(formBean.getStrEmpLevelUpdate());
					vo.setStrOptionUpdate(formBean.getStrOptionUpdate());
					vo.setStrConstituteDate(formBean
							.getStrConstituteDateUpdate());
					vo.setStrStoreType(formBean.getStrStoreType());
					vo.setStrConstituteByComboUpdate(formBean
							.getStrConstituteBy());
					vo.setStrEffectiveFromUpdate(formBean
							.getStrEffectiveFromUpdate());
					vo.setStrEffectiveToUpdate(formBean.getStrEffectiveTo());
				}
				if (formBean.getStrEmpNoUpdateMR() != null) {

					vo.setStrIsEmployeeUpdateMR(formBean
							.getStrIsEmployeeUpdateMR());
					vo.setStrEmpNoUpdateMRCombo(formBean
							.getStrEmpNoUpdateMRCombo());

					vo.setStrCommitteType(formBean.getStrCommitteType());
					vo.setStrEmpNoUpdateMR(formBean.getStrEmpNoUpdateMR());
					vo.setStrEmpNameUpdateMR(formBean.getStrEmpNameUpdateMR());
					vo.setStrEmpAddrUpdateMR(formBean.getStrEmpAddrUpdateMR());
					vo
							.setStrEmpPhoneUpdateMR(formBean
									.getStrEmpPhoneUpdateMR());
					vo
							.setStrEmpEmailUpdateMR(formBean
									.getStrEmpEmailUpdateMR());
					vo.setStrEmpUserIdUpdateMR(formBean
							.getStrEmpUserIdUpdateMR());
					vo
							.setStrEmpLevelUpdateMR(formBean
									.getStrEmpLevelUpdateMR());
					vo.setStrOptionUpdateMR(formBean.getStrOptionUpdateMR());

					vo.setStrStoreType(formBean.getStrStoreType());
					vo.setStrConstituteDate(formBean
							.getStrConstituteDateUpdate());
					vo.setStrConstituteByComboUpdate(formBean
							.getStrConstituteBy());
					vo.setStrEffectiveFromUpdate(formBean
							.getStrEffectiveFromUpdate());
					vo.setStrEffectiveToUpdate(formBean.getStrEffectiveTo());
				}
				vo.setStrStoreType(formBean.getStrStoreType());
				vo.setStrConstituteDate(formBean.getStrConstituteDateUpdate());
				vo.setStrConstituteByComboUpdate(formBean.getStrConstituteBy());
				vo.setStrEffectiveFromUpdate(formBean
						.getStrEffectiveFromUpdate());
				vo.setStrEffectiveToUpdate(formBean.getStrEffectiveTo());
				bo.insertRecord(vo);

			} else {
				if (formBean.getStrEmpNo() != null) {
					// vo.setStrIsEmployee(formBean.getStrIsEmployee());
					vo.setStrEmpNoCombo(formBean.getStrEmpNoCombo());

					vo.setStrCommitteType(formBean.getStrCommitteType());
					vo.setStrStoreType(formBean.getStrStoreType());
					vo.setStrConstituteDate(formBean.getStrConstituteDate());
					vo.setStrConstituteByComboUpdate(formBean
							.getStrConstituteBy());
					vo
							.setStrEffectiveFromUpdate(formBean
									.getStrEffectiveFrom());
					vo.setStrEffectiveToUpdate(formBean.getStrEffectiveTo());

					vo.setStrEmpNo(formBean.getStrEmpNo());
					vo.setStrEmpName(formBean.getStrEmpName());
					vo.setStrEmpAddr(formBean.getStrEmpAddr());
					vo.setStrEmpPhone(formBean.getStrEmpPhone());
					vo.setStrEmpEmail(formBean.getStrEmpEmail());
					vo.setStrEmpUserId(formBean.getStrEmpUserId());
					vo.setStrEmpLevel(formBean.getStrEmpLevel());
					

				}
				bo.AddRecord(vo);
			}

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			// e.printStackTrace();

			strmsgText = "CommitteeMemberDetailMaster.CommitteeMemberDetailMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugSaftyAlertMstDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insertRecord2(CommitteeMemberDetailMstFB formBean,
			HttpServletRequest request) {
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new CommitteeMemberDetailMstBO();
			vo = new CommitteeMemberDetailMstVO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			// String seatid =
			// request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(strHospitalCode);

			if (formBean.getStrEmpNoUpdate() != null) {
				vo.setStrCommitteNo(formBean.getStrCommitteNo());
				vo.setStrCommeitteSlNo1(formBean.getStrCommeitteSlNo1());
				vo.setStrEmpNoUpdate(formBean.getStrEmpNoUpdate());
				vo.setStrEmpNameUpdate(formBean.getStrEmpNameUpdate());
				vo.setStrEmpAddrUpdate(formBean.getStrEmpAddrUpdate());
				vo.setStrEmpPhoneUpdate(formBean.getStrEmpPhoneUpdate());
				vo.setStrEmpEmailUpdate(formBean.getStrEmpEmailUpdate());
				vo.setStrEmpUserIdUpdate(formBean.getStrEmpUserIdUpdate());
				vo.setStrEmpLevelUpdate(formBean.getStrEmpLevelUpdate());
				vo.setStrOptionUpdate(formBean.getStrOptionUpdate());
				vo.setStrConstituteDate(formBean.getStrConstituteDateUpdate());
				vo.setStrStoreType(formBean.getStrStoreType());
				vo.setStrConstituteByComboUpdate(formBean.getStrConstituteBy());
				vo.setStrEffectiveFromUpdate(formBean
						.getStrEffectiveFromUpdate());
				vo.setStrEffectiveToUpdate(formBean.getStrEffectiveTo());
			}
			if (formBean.getStrEmpNoUpdateMR() != null) {

				formBean.setStrEmpNoUpdateMRCombo(formBean
						.getStrEmpNoUpdateMRComboDummy());

				

				vo
						.setStrIsEmployeeUpdateMR(formBean
								.getStrIsEmployeeUpdateMR());
				vo
						.setStrEmpNoUpdateMRCombo(formBean
								.getStrEmpNoUpdateMRCombo());

				vo.setStrCommitteType(formBean.getStrCommitteType());
				vo.setStrEmpNoUpdateMR(formBean.getStrEmpNoUpdateMR());
				vo.setStrEmpNameUpdateMR(formBean.getStrEmpNameUpdateMR());
				vo.setStrEmpAddrUpdateMR(formBean.getStrEmpAddrUpdateMR());
				vo.setStrEmpPhoneUpdateMR(formBean.getStrEmpPhoneUpdateMR());
				vo.setStrEmpEmailUpdateMR(formBean.getStrEmpEmailUpdateMR());
				vo.setStrEmpUserIdUpdateMR(formBean.getStrEmpUserIdUpdateMR());
				vo.setStrEmpLevelUpdateMR(formBean.getStrEmpLevelUpdateMR());
				vo.setStrOptionUpdateMR(formBean.getStrOptionUpdateMR());

				vo.setStrStoreType(formBean.getStrStoreType());
				vo.setStrConstituteDate(formBean.getStrConstituteDateUpdate());
				vo.setStrConstituteByComboUpdate(formBean.getStrConstituteBy());
				vo.setStrEffectiveFromUpdate(formBean
						.getStrEffectiveFromUpdate());
				vo.setStrEffectiveToUpdate(formBean.getStrEffectiveTo());
			}
			vo.setStrStoreType(formBean.getStrStoreType());
			vo.setStrConstituteDate(formBean.getStrConstituteDateUpdate());
			vo.setStrConstituteByComboUpdate(formBean.getStrConstituteBy());
			vo.setStrEffectiveFromUpdate(formBean.getStrEffectiveFromUpdate());
			vo.setStrEffectiveToUpdate(formBean.getStrEffectiveTo());
			bo.insertRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();

			strmsgText = "CommitteeMemberDetailMaster.CommitteeMemberDetailMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugSaftyAlertMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(CommitteeMemberDetailMstFB formBean,
			HttpServletRequest request) {
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new CommitteeMemberDetailMstBO();
			vo = new CommitteeMemberDetailMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			String strStoreTypeId = request.getSession().getAttribute(
					"strStoreTypeId").toString();
			// String storetypecmb = request.getParameter("combo");

			formBean.setStrHospitalCode(hosCode);
			// formBean.setStrSeatId(seatid);
			// formBean.setStrStoreTypeId(strStoreTypeId);
			// formBean.setStrChk1(request.getParameter("chk"));

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrChk1(request.getParameter("chk"));

			bo.initialAdd(vo); // to display the Store Type Name on modify page
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			bo.modifyRecord(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {

			strmsgText = "CommitteeMemberDetailMaster.CommitteeMemberDetailMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugSaftyAlertMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(CommitteeMemberDetailMstFB formBean,
			HttpServletRequest request) {
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		try {
			bo = new CommitteeMemberDetailMstBO();
			vo = new CommitteeMemberDetailMstVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			// formBean.setStrStoreTypeId(request.getParameter("storeTypeId"));
			// formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);

			vo.setStrHospitalCode(hosCode);
			vo.setStrChk1(request.getParameter("chk"));
			vo.setStrSeatId(seatid);
			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			// TransferObjectFactory.populateData(formBean, vo);

			else {
				formBean.setStrMsg("Record Modify Successfully");
			}

		} catch (Exception e) {

			strmsgText = "CommitteeMemberDetailMaster.CommitteeMemberDetailMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugSaftyAlertMstDATA->updateRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

	// for creating request type combo (by Anshul)

	/**
	 * Gets the req type combo.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 * 
	 * @return the req type combo
	 */
	public static void getReqTypeCombo(HttpServletRequest request,
			HttpServletResponse response, CommitteeMemberDetailMstFB formBean) {
		// Declaring Variables
		// String strTariffCombo = "";
		String strmsgText = "";
		String strCategoryNo = "";
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		String cmb = "";

		HisUtil hisutil = null;
		try {
			vo = new CommitteeMemberDetailMstVO();
			bo = new CommitteeMemberDetailMstBO();
			hisutil = new HisUtil("MMS", "CommitteeMemberDetailMstDATA");

			strCategoryNo = request.getParameter("CategoryNo");
			vo.setStrCatNo(strCategoryNo);
			vo.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getReqType(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			cmb = hisutil.getOptionValue(vo.getReqTypeWS(), "0",
					"0^Select Value", true);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS",
					"CommitteeMemberDetailMstDATA->getReqTypeCombo()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
			if (bo != null)
				bo = null;
		}

	}
	
	
	/**
	 * Gets the req type combo.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 * 
	 * @return the req type combo
	 */
	public static void getEmpUserIdCombo(HttpServletRequest request,HttpServletResponse response, CommitteeMemberDetailMstFB formBean) 
	{
		String strmsgText;
		String strEmpNo;
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		String cmb = "";

		HisUtil hisutil = null;
		
		try 
		{
			vo = new CommitteeMemberDetailMstVO();
			bo = new CommitteeMemberDetailMstBO();
			hisutil = new HisUtil("MMS", "CommitteeMemberDetailMstDATA");

			strEmpNo = request.getParameter("EmpNo");
			vo.setStrEmpNumber(strEmpNo);
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
        
			bo.getEmpUserIdCombo(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			cmb = hisutil.getOptionValue(vo.getStrUserIdWs(), "0","0^Select Value", true);

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);
			
		} 
		catch (Exception e) 
		{
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS","CommitteeMemberDetailMstDATA->getReqTypeCombo()", strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} 
		finally 
		{
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
			if (bo != null)
				bo = null;
		}

	}

	// for creating committee type combo (by Anshul)

	/**
	 * Gets the comm type combo.
	 * 
	 * @param request the request
	 * @param response the response
	 * @param formBean the form bean
	 * 
	 * @return the comm type combo
	 */
	public static void getCommTypeCombo(HttpServletRequest request,
			HttpServletResponse response, CommitteeMemberDetailMstFB formBean) {
		// Declaring Variables
		// String strTariffCombo = "";
		String strmsgText = "";
		String strReqTypeId = "";
		String strCategoryNo = "";
		CommitteeMemberDetailMstBO bo = null;
		CommitteeMemberDetailMstVO vo = null;
		String cmb = "";

		HisUtil hisutil = null;
		try {
			vo = new CommitteeMemberDetailMstVO();
			bo = new CommitteeMemberDetailMstBO();
			hisutil = new HisUtil("MMS", "CommitteeMemberDetailMstDATA");

			strReqTypeId = request.getParameter("ReqTypeId");
			strCategoryNo = request.getParameter("CategoryNo");
			vo.setStrReqTypeId(strReqTypeId);
			vo.setStrCatNo(strCategoryNo);
			vo.setStrHospitalCode(request.getSession().getAttribute(
					"HOSPITAL_CODE").toString());

			bo.getCommType(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			cmb = hisutil.getOptionValue(vo.getCommTypeWS(), "0",
					"0^Select Value", true);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);

			} catch (Exception e) {

			}
		} catch (Exception e) {
			strmsgText = e.getMessage();
			HisException eObj = new HisException("MMS",
					"CommitteeMemberDetailMstDATA->getCommTypeCombo()",
					strmsgText);
			formBean.setStrErr("ERROR####Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			formBean.setStrMsgType("1");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (hisutil != null)
				hisutil = null;
			if (bo != null)
				bo = null;
		}

	}

}
