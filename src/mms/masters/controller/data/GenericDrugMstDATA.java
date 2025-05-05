package mms.masters.controller.data;

import javax.servlet.http.HttpServletRequest;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.masters.bo.GenericDrugMstBO;
import mms.masters.controller.fb.GenericDrugMstFB;
import mms.masters.vo.GenericDrugMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 */

public class GenericDrugMstDATA {

	/**
	 * Inits the param add.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 */
	public static void initParamAdd(HttpServletRequest request,
			GenericDrugMstFB formBean) {
		HisUtil util = null;
		GenericDrugMstBO bo = null;
		GenericDrugMstVO vo = null;
		MmsConfigUtil mms=new MmsConfigUtil(formBean.getStrHospCode());
		
		//System.out.println("Hospital Code is "+formBean.getStrHospCode());
		try {

			util = new HisUtil("MMS", "GenericDrugMstDATA");
			vo = new GenericDrugMstVO();
			bo = new GenericDrugMstBO();

			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			
			formBean.setStrPurchaseLeadTime(mms.getStrPurchaseLeadTime());
			formBean.setStrShelfLife(mms.getStrSelfLife());

			String temp[] = request.getParameterValues("combo");

			formBean.setStrGroupId(temp[0]);

			if (temp[1] == null || temp[1].equals("") || temp[1].equals("0")) {
				temp[1] = "0";
			}

			formBean.setStrSubGroupId(temp[1]);
			vo.setStrSubGroupId(formBean.getStrSubGroupId());

			vo.setStrHospCode(formBean.getStrHospCode());

			formBean.setCombo(request.getParameterValues("combo"));

			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);
			vo.setStrModuleId(formBean.getStrModuleId());

			String temp1 = formBean.getComboValue();

			String strTemp[] = temp1.replace("^", "#").split("#");

			formBean.setStrGroupNameValue(strTemp[0]);

			
			/*
			if (strTemp.length == 1) 
			{
				formBean.setStrSubGroupNameValue("-----");
			} 
			else
			{
				formBean.setStrSubGroupNameValue(strTemp[1]);
			}
			*/

			bo.getStockMaintainedValues(vo);
			bo.getSubgroupName(vo);

			formBean.setStrSubGroupNameValue(vo.getStrSubGroupNameValue());
			formBean.setStrIsItemCodeRequired(vo.getStrIsItemCodeRequired());
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

			if (vo.getStockMaintainedWS() == null	|| vo.getStockMaintainedWS().size() == 0) {
				formBean.setStrStockMaintainedValues("<option value='0'>Select Value</option>");

			} else {
				formBean.setStrStockMaintainedValues(util.getOptionValue(vo.getStockMaintainedWS(), "", "", false));
			}
			
			/*Aritra*/
			formBean.setStrPregnancySafeFlag("ON");
			formBean.setStrBatchNo("ON");
			formBean.setStrExpiryDate("ON");
			formBean.setStrTrimester("NOT_SELECTED");
			formBean.setStrEffectsOnFoetus("");

		} catch (Exception _e) {
			_e.printStackTrace();
			HisException eObj = new HisException("MMS","GenericDrugMstDATA->initParamAdd()", _e.getMessage());
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}
/*
 * 
 */
	public static void initParamAdd_BS(HttpServletRequest request,
			GenericDrugMstFB formBean) {
		HisUtil util = null;
		GenericDrugMstBO bo = null;
		GenericDrugMstVO vo = null;
		MmsConfigUtil mms=new MmsConfigUtil(formBean.getStrHospCode());
		
		//System.out.println("Hospital Code is "+formBean.getStrHospCode());
		try {

			util = new HisUtil("MMS", "GenericDrugMstDATA");
			vo = new GenericDrugMstVO();
			bo = new GenericDrugMstBO();

			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			
			formBean.setStrPurchaseLeadTime(mms.getStrPurchaseLeadTime());
			formBean.setStrShelfLife(mms.getStrSelfLife());

			String temp[] = request.getParameterValues("combo");

			formBean.setStrGroupId(temp[0]);

			if (temp[1] == null || temp[1].equals("") || temp[1].equals("0")) {
				temp[1] = "0";
			}

			formBean.setStrSubGroupId(temp[1]);
			vo.setStrSubGroupId(formBean.getStrSubGroupId());

			vo.setStrHospCode(formBean.getStrHospCode());

			formBean.setCombo(request.getParameterValues("combo"));

			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);
			vo.setStrModuleId(formBean.getStrModuleId());

			String temp1 = formBean.getComboValue();

			String strTemp[] = temp1.replace("^", "#").split("#");

			formBean.setStrGroupNameValue(strTemp[0]);

			
			/*
			if (strTemp.length == 1) 
			{
				formBean.setStrSubGroupNameValue("-----");
			} 
			else
			{
				formBean.setStrSubGroupNameValue(strTemp[1]);
			}
			*/

			bo.getStockMaintainedValues(vo);
			bo.getSubgroupName(vo);

			formBean.setStrSubGroupNameValue(vo.getStrSubGroupNameValue());
			formBean.setStrIsItemCodeRequired(vo.getStrIsItemCodeRequired());
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

			if (vo.getStockMaintainedWS() == null	|| vo.getStockMaintainedWS().size() == 0) {
				formBean.setStrStockMaintainedValues("<option value='0'>Select Value</option>");

			} else {
				formBean.setStrStockMaintainedValues(util.getOptionValue(vo.getStockMaintainedWS(), "", "", false));
			}
			
			/*Aritra*/
			formBean.setStrPregnancySafeFlag("ON");
			formBean.setStrBatchNo("ON");
			formBean.setStrExpiryDate("ON");
			formBean.setStrTrimester("NOT_SELECTED");
			formBean.setStrEffectsOnFoetus("");

		} catch (Exception _e) {
			_e.printStackTrace();
			HisException eObj = new HisException("MMS","GenericDrugMstDATA->initParamAdd()", _e.getMessage());
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	/*
	 * This function is used to insert data
	 */
	/**
	 * Insert.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 */
	public static void insert(HttpServletRequest request,
			GenericDrugMstFB formBean) {
		GenericDrugMstBO bo = null;
		GenericDrugMstVO vo = null;
		HisUtil util = null;

		try {

			bo = new GenericDrugMstBO();
			vo = new GenericDrugMstVO();
			util = new HisUtil("MMS", "GenericDrugMstDATA");

			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			vo.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());
			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);

			if (request.getParameterValues("combo") != null) {
				String temp[] = request.getParameterValues("combo");
				formBean.setStrGroupId(temp[0]);
				formBean.setStrSubGroupId(temp[1]);
				formBean.setCombo(request.getParameterValues("combo"));

			} else {
				String temp[] = formBean.getCombo();
				formBean.setStrGroupId(temp[0]);
				formBean.setStrSubGroupId(temp[1]);

			}

			vo.setStrHospCode(formBean.getStrHospCode());
			vo.setStrModuleId(formBean.getStrModuleId());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
			vo.setStrDrugName(formBean.getStrDrugName());
			vo.setStrConsumableType(formBean.getStrConsumableType());
			vo.setStrConsentReq(formBean.getStrConsentReq());
			vo.setStrIsItemNarcotic(formBean.getStrIsItemNarcotic());
			vo.setStrBatchNo(formBean.getStrBatchNo());
			vo.setStrExpiryDate(formBean.getStrExpiryDate());
			vo.setStrPurchaseLeadTime(formBean.getStrPurchaseLeadTime());
			vo.setStrTimeFormat(formBean.getStrTimeFormat());
			vo.setStrShelfLife(formBean.getStrShelfLife());
			vo.setStrShelfTimeFormat(formBean.getStrShelfTimeFormat());
			vo.setStrStockMaintain(formBean.getStrStockMaintain());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			if(formBean.getStrIsItemCodeRequired().equals("1")){
				
				vo.setStrCPACode(formBean.getStrCPACode());
				
			}else{
				
				vo.setStrCPACode("0");
				
			}
			
			
			
			/*Aritra*/
			
			if("ON".equalsIgnoreCase(formBean.getStrPregnancySafeFlag())) {
				vo.setStrPregnancySafeFlag("1");
				vo.setStrTrimester("0");
				vo.setStrEffectsOnFoetus("");
			} else {
				vo.setStrPregnancySafeFlag("0");
				vo.setStrTrimester(formBean.getStrTrimester());
				vo.setStrEffectsOnFoetus(formBean.getStrEffectsOnFoetus());
			}
			
			if("ON".equalsIgnoreCase(formBean.getStrBatchNo())) {
				vo.setStrBatchNo("1");
				
			} else {
				vo.setStrBatchNo("0");
			
			}
			if("ON".equalsIgnoreCase(formBean.getStrExpiryDate())) {
				vo.setStrExpiryDate("1");
				
			} else {
				vo.setStrExpiryDate("0");
			
			}
			
			
		
			
			
			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());

			}
			if (vo.getBExistStatus() == false) {
				formBean.setStrWarnMssgstring("Data already exist");
			} else {
				formBean.setStrNormMssgstring("Data Saved Successfully");
			}

			String temp[] = request.getParameterValues("combo");
			formBean.setStrGroupId(temp[0]);
			formBean.setStrSubGroupId(temp[1]);

			formBean.setCombo(request.getParameterValues("combo"));
			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);
			// vo.setStrHospCode(formBean.getStrHospCode());
			vo.setStrModuleId(formBean.getStrModuleId());

			bo.getStockMaintainedValues(vo);

			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));
			formBean.setStrStockMaintainedValues(util.getOptionValue(vo
					.getStockMaintainedWS(), "0", "0^Select Value", false));

		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"GenericDrugMstDATA->insert()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
	}

	/**
	 * This function is used to invoke Bo's method to bring data on modify page.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 */
	public static void modify(HttpServletRequest request,
			GenericDrugMstFB formBean) {
		GenericDrugMstBO bo = null;
		GenericDrugMstVO vo = null;
	//	HisUtil util = null;
		String temp[] = null;
	//	String cmb = "";
		try {
			vo = new GenericDrugMstVO();
			bo = new GenericDrugMstBO();
			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());
			if (request.getParameter("chk") != null) 
			{
				String strChk = request.getParameter("chk");
				strChk = strChk.replace("$", "@");
				temp = strChk.split("@");
				formBean.setStrChk(strChk);
			} 
			else 
			{
				String strChk = formBean.getStrChk();
				strChk = strChk.replace("$", "@");
				temp = strChk.split("@");
			}
			
			
			////System.out.println("formBean.setStrChk  -->>"+formBean.getStrChk());
			vo.setStrItemId(temp[0]);
			vo.setStrHospCode(temp[1]);
			vo.setStrSerialNo(temp[2]);

			String temp11 = formBean.getComboValue();

			String strTemp[] = temp11.replace("^", "#").split("#");

			formBean.setStrGroupNameValue(strTemp[0]);

			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);

			bo.modify(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {

				bo.getStockMaintainedValues(vo);
		//		util = new HisUtil("MMS", "GenericDrugMstDATA");

			/*	if (vo.getStockMaintainedWS() == null
						|| vo.getStockMaintainedWS().size() == 0) {
					cmb = "<option value='0'>Select Value</option>";

				} else {

					cmb = util.getOptionValue(vo.getStockMaintainedWS(), vo
							.getStrStockMaintainedCode(), "0^Select Value",
							false);
				}*/

				//formBean.setStrStockMaintainedValuesModi(cmb);

				formBean.setStrInventoryUnitName(vo.getStrInventoryUnitName());
				formBean.setStrDrugName(vo.getStrDrugName());				
				formBean.setStrBatchNo(vo.getStrBatchNo());
				formBean.setStrExpiryDate(vo.getStrExpiryDate());
				formBean.setStrPurchaseLeadTime(vo.getStrPurchaseLeadTime());
				formBean.setStrTimeFormat(vo.getStrTimeFormat());
				formBean.setStrShelfLife(vo.getStrShelfLife());
				formBean.setStrShelfTimeFormat(vo.getStrShelfTimeFormat());				
				formBean.setStrConsumableType(vo.getStrConsumableType());				
				formBean.setStrIsItemNarcotic(vo.getStrIsItemNarcotic());
				formBean.setStrRemarks(vo.getStrRemarks());
				formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
				formBean.setStrIsValid(vo.getStrIsValid());				
				formBean.setStrConsentReq(vo.getStrConsentReq());
				formBean.setStrSubGroupNameValue(vo.getStrSubGroupNameValue());
				formBean.setStrGroupNameValue(vo.getStrGroupNameValue());
				formBean.setStrCPACode(vo.getStrCPACode());				
				formBean.setStrIsItemCodeRequired(vo.getStrIsItemCodeRequired());
				formBean.setStrStockMaintainedCode(vo.getStrStockMaintainedCode());
				/*Aritra*/
				if("0".equals(vo.getStrPregnancySafeFlag())) {
					formBean.setStrPregnancySafeFlag("OFF"); // Unsafe
					formBean.setStrTrimester(vo.getStrTrimester());
					formBean.setStrEffectsOnFoetus(vo.getStrEffectsOnFoetus());
				} else {
					formBean.setStrPregnancySafeFlag("ON");
					formBean.setStrTrimester("NOT_SELECTED");
					formBean.setStrEffectsOnFoetus("");
				}
				
				
				
				// formBean.setStrChk(strChk);

			}
		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"GenericDrugMstDATA->modify()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		//	util = null;
		}
	}

	/**
	 * This function is used to invoke Bo's update method to update data.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * 
	 * @return true, if update
	 */
	public static boolean update(HttpServletRequest request,
			GenericDrugMstFB formBean) {
		GenericDrugMstBO bo = null;
		GenericDrugMstVO vo = null;
		boolean retValue = true;
		String temp[] = null;
		try {
			bo = new GenericDrugMstBO();
			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());

			// String strChk = request.getParameter("chk");
			String strChk = formBean.getStrChk();
			// // //System.out.println("data chk--"+strChk);
			strChk = strChk.replace("$", "@");
			temp = strChk.split("@");
			
			if (request.getParameterValues("combo") != null) 
			{
				String temp1[] = request.getParameterValues("combo");
				formBean.setStrGroupId(temp1[0]);
				formBean.setStrSubGroupId(temp1[1]);
				formBean.setCombo(request.getParameterValues("combo"));

			} 
			else
			{
				String temp1[] = formBean.getCombo();
				formBean.setStrGroupId(temp1[0]);
				formBean.setStrSubGroupId(temp1[1]);

			}

			vo = (GenericDrugMstVO) TransferObjectFactory.populateData("mms.masters.vo.GenericDrugMstVO", formBean);

			vo.setStrItemId(temp[0]);
			vo.setStrHospCode(temp[1]);
			vo.setStrSerialNo(temp[2]);
			
			/* Aritra */
			if("ON".equalsIgnoreCase(formBean.getStrPregnancySafeFlag())) {
				vo.setStrPregnancySafeFlag("1");
				vo.setStrTrimester("0");
				vo.setStrEffectsOnFoetus("");
			} else {
				vo.setStrPregnancySafeFlag("0");
				vo.setStrTrimester(formBean.getStrTrimester());
				vo.setStrEffectsOnFoetus(formBean.getStrEffectsOnFoetus());
			}
			
			if(formBean.getStrIsItemCodeRequired().equals("1")){
				
				vo.setStrCPACode(formBean.getStrCPACode());
				
			}else{
				
				vo.setStrCPACode("0");
				
			}
			vo.setStrStockMaintainedCode(formBean.getStrStockMaintainedCode());
			
			// Calling BO Method
			bo.update(vo);
			if (vo.getBExistStatus() == false) {
				formBean.setStrWarnMssgstring("Data already exist");
				retValue = false;
			}
			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}
		} catch (Exception e) {
			retValue = false;
			e.printStackTrace();
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"GenericDrugMstDATA->update()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

	/**
	 * View.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 */
	public static void view(HttpServletRequest request,
			GenericDrugMstFB formBean) {
		GenericDrugMstBO bo = null;
		GenericDrugMstVO vo = null;
	 
		String temp[] = null;
		try {
			vo = new GenericDrugMstVO();
			bo = new GenericDrugMstBO();
			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());
			String strChk = request.getParameter("chk");
			strChk = strChk.replace("$", "@");
			temp = strChk.split("@");

			vo.setStrItemId(temp[0]);
			vo.setStrHospCode(temp[1]);
			vo.setStrSerialNo(temp[2]);

			String temp1 = request.getParameter("cmbVal1");
			// String temp2 = request.getParameter("cmbVal2");
			formBean.setStrGroupNameValue(temp1);
			// formBean.setStrSubGroupNameValue(temp2);

			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
			// formBean.setStrBrandItemDtlValues(DrugMSTHLP.getBrandItemView(vo.getStrItemId(),vo.getStrHospCode()));
			bo.view(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
			 

				/*
				 * cmb = util.getOptionValue(vo.getStockMaintainedWS(), vo
				 * .getStrStockMaintainedCode(), "0^Select Value", false);
				 * formBean.setStrStockMaintainedValuesModi(cmb);
				 * 
				 * formBean.setStrStockMaintainedValuesModi(cmb);
				 */
				formBean.setStrStockMaintain(vo.getStrStockMaintain());
				formBean.setStrDrugName(vo.getStrDrugName());
				formBean.setStrBatchNo(vo.getStrBatchNo());
				formBean.setStrExpiryDate(vo.getStrExpiryDate());
				formBean.setStrPurchaseLeadTime(vo.getStrPurchaseLeadTime());
				formBean.setStrTimeFormat(vo.getStrTimeFormat());
				formBean.setStrShelfLife(vo.getStrShelfLife());

				formBean.setStrShelfTimeFormat(vo.getStrShelfTimeFormat());
				
				if("Yes".equalsIgnoreCase(vo.getStrConsumableType())) {
					formBean.setStrConsumableType("Consumable");
				} else if ("No".equalsIgnoreCase(vo.getStrConsumableType())) {
					formBean.setStrConsumableType("Non-Consumable");
				} else {
					formBean.setStrConsumableType(vo.getStrConsumableType());
				}
				
				formBean.setStrIsItemNarcotic(vo.getStrIsItemNarcotic());
				formBean.setStrRemarks(vo.getStrRemarks());
				formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());

				formBean.setStrIsValid(vo.getStrIsValid());

				/*
				 * ************************************************************
				 * This code is inactivated by Aritra on 31st May, 2010.
				 * Reason: in dao, vo.strConsentReq is set with value {Yes, No},
				 * instead of {1,2} as asumed here.
				 * ************************************************************
				 
				if (vo.getStrConsentReq().equals("1"))
					formBean.setStrConsentReq("Yes");
				else
					formBean.setStrConsentReq("No");
				*/
				
				/*
				 * This line of code is added on 31st May, 2010.
				 * Reason: To set vo.strConsentReq data to formBean.strConsentReq
				 * data.
				 */
				formBean.setStrConsentReq(vo.getStrConsentReq());

				formBean.setStrSubGroupNameValue(vo.getStrSubGroupNameValue());
				
				
				/*Aritra*/
				if("0".equals(vo.getStrPregnancySafeFlag())) {
					formBean.setStrPregnancySafeFlag("Unsafe"); // Unsafe
					
					String strTrimester="";
					if("0".equals(vo.getStrTrimester())) {
						strTrimester="All";
					} else if("1".equals(vo.getStrTrimester())) {
						strTrimester="First";
					} else if("2".equals(vo.getStrTrimester())) {
						strTrimester="Second";
					} else if("3".equals(vo.getStrTrimester())) {
						strTrimester="Third";
					} 
					formBean.setStrTrimester(strTrimester);
					formBean.setStrEffectsOnFoetus(vo.getStrEffectsOnFoetus());
				} else {
					formBean.setStrPregnancySafeFlag("Safe");
					formBean.setStrTrimester("");
					formBean.setStrEffectsOnFoetus("");
				}

			}
		} catch (Exception e) {
		 
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"GenericDrugMstDATA->view()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			 
		}
	}
	
	

}
