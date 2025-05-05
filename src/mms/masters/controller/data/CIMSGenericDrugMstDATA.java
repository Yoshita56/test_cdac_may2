package mms.masters.controller.data;

import javax.servlet.http.HttpServletRequest;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.masters.bo.CIMSGenericDrugMstBO;
import mms.masters.controller.fb.CIMSGenericDrugMstFB;
import mms.masters.vo.CIMSGenericDrugMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 */

public class CIMSGenericDrugMstDATA {

	/**
	 * Inits the param add.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 */
	public static void initParamAdd(HttpServletRequest request,CIMSGenericDrugMstFB formBean) 
	{
		HisUtil util = null;
		CIMSGenericDrugMstBO bo = null;
		CIMSGenericDrugMstVO vo = null;
		
		try 
		{
			util = new HisUtil("MMS", "CIMSGenericDrugMstDATA");
			vo = new CIMSGenericDrugMstVO();
			bo = new CIMSGenericDrugMstBO();

			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);

			String temp[] = request.getParameterValues("combo");

			formBean.setStrGroupId(temp[0]);

			if (temp[1] == null || temp[1].equals("") || temp[1].equals("0")) 
			{
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
			
			if (strTemp.length == 1) 
			{
				formBean.setStrSubGroupNameValue("-----");
			} 
			else
			{
				formBean.setStrSubGroupNameValue(strTemp[1]);
			}
			
			bo.getStockMaintainedValues(vo);
			//bo.getSubgroupName(vo);
			bo.getPregCat(vo);
			bo.getContracdictoryDrugList(vo);
			bo.getAdministartion(vo);
			bo.getStorage(vo);
			bo.getContraindicationsList(vo);
			bo.getAdminRoute(vo);

			//formBean.setStrSubGroupNameValue(vo.getStrSubGroupNameValue());
			//formBean.setStrIsItemCodeRequired(vo.getStrIsItemCodeRequired());
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

			if (vo.getStockMaintainedWS() == null	|| vo.getStockMaintainedWS().size() == 0) 
			{
				formBean.setStrStockMaintainedValues("<option value='0'>Select Value</option>");
			} 
			else 
			{
				formBean.setStrStockMaintainedValues(util.getOptionValue(vo.getStockMaintainedWS(), "", "", false));
			}			
			
			formBean.setStrPregnancySafeFlag(util.getOptionValue(vo.getPregcatDtlWS(),vo.getPregCatDef(), "", false));
			
			formBean.setStrDrugval(util.getOptionValue(vo.getDrugvalWS(), "0", "0^Select Value", false));
			
			
			formBean.setStrDrugAdmincode(util.getOptionValue(vo.getAdminWS(), "0", "0^Select Value", false));
			formBean.setStrContraindictioncode(util.getOptionValue(vo.getContraindWS(), "0", "0^Select Value", false));
			formBean.setStrStoragecode(util.getOptionValue(vo.getStorageWS(), "", "", false));
			formBean.setStrAdminRoute(util.getOptionValue(vo.getAdminRouteWS(), "0", "0^Select Value", false));
			formBean.setComboValue(temp1);
		} 
		catch (Exception _e) 
		{
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
			CIMSGenericDrugMstFB formBean) {
		CIMSGenericDrugMstBO bo = null;
		CIMSGenericDrugMstVO vo = null;
		HisUtil util = null;
		int nStopI = 0;
		String strContraDrugsId = "";
		String strContraDrugs = "";
		try {

			bo = new CIMSGenericDrugMstBO();
			vo = new CIMSGenericDrugMstVO();
			util = new HisUtil("MMS", "GenericDrugMstDATA");

			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);
			

			if (request.getParameterValues("combo") != null) 
			{
				String temp[] = request.getParameterValues("combo");
				formBean.setStrGroupId(temp[0]);
				formBean.setStrSubGroupId(temp[1]);
				formBean.setCombo(request.getParameterValues("combo"));
			} 
			else 
			{
				String temp[] = formBean.getCombo();
				formBean.setStrGroupId(temp[0]);
				formBean.setStrSubGroupId(temp[1]);

			}
			nStopI=formBean.getStrContradictoryDrugArray().length;
			
			for(int i=0;i<nStopI;i++)
			{
              //System.out.println("formBean.getStrContradictoryDrugArray()[i]"+formBean.getStrContradictoryDrugArray()[i]);
				if (!formBean.getStrContradictoryDrugArray()[i].equals("0")) {
					if (i == nStopI - 1) {
						strContraDrugsId = strContraDrugsId
								+ formBean.getStrContradictoryDrugIdArray()[i];
						strContraDrugs = strContraDrugs
								+ formBean.getStrContradictoryDrugArray()[i];
					} else
						strContraDrugsId = strContraDrugsId
								+ formBean.getStrContradictoryDrugIdArray()[i] + ",";
					strContraDrugs = strContraDrugs
							+ formBean.getStrContradictoryDrugArray()[i] + ",";
				}
			}
			vo.setStrHospCode(formBean.getStrHospCode());
			vo.setStrModuleId(formBean.getStrModuleId());
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
			vo.setStrDrugName(formBean.getStrDrugName());
			vo.setStrConsumableType(formBean.getStrConsumableType());
			
			vo.setStrBatchNo(formBean.getStrBatchNo());
			vo.setStrExpiryDate(formBean.getStrExpiryDate());
			
			vo.setStrShelfLife(formBean.getStrShelfLife());
			vo.setStrShelfTimeFormat(formBean.getStrShelfTimeFormat());
			vo.setStrStockMaintain(formBean.getStrStockMaintain());
			
			
			
			
			vo.setStrContraindictioncode(formBean.getStrContraindictioncode());
			vo.setStrdosageadult(formBean.getStrdosageadult());
			vo.setStrsprecau(formBean.getStrsprecau());
			vo.setStradvdrug(formBean.getStradvdrug());
			vo.setStrStoragecode(formBean.getStrStoragecode());
			vo.setStrmechact(formBean.getStrmechact());
			vo.setStrlabintfrnce(formBean.getStrlabintfrnce());
			vo.setStrShelfLife(formBean.getStrShelfLife());
			vo.setStrItemCatNo("10");
			vo.setStrbatchnoreq("1");
			vo.setStrExpiryDatereq("1");
			vo.setStrIsValid("1");
			vo.setStrPregnancySafeFlag(formBean.getStrPregnancySafeFlag());
			vo.setStrDrugAdmincode(formBean.getStrDrugAdmincode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrAdminRoute(formBean.getStrAdminRoute());
		    vo.setStrDrugval(strContraDrugs.trim());
			vo.setStrdosagepeads(formBean.getStrdosagepeads());
			vo.setStrCPACode(formBean.getStrCPACode());
			vo.setStrDrugIdval(strContraDrugsId.trim());
			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());

			}
			/*if (vo.getBExistStatus() == false) {
				formBean.setStrWarnMssgstring("Data already exist");
			} else {*/
				formBean.setStrNormMssgstring("Data Saved Successfully");
	//		}

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
			CIMSGenericDrugMstFB formBean) {
		HisUtil util = null;
		CIMSGenericDrugMstBO bo = null;
		CIMSGenericDrugMstVO vo = null;
	//	HisUtil util = null;
		String temp[] = null;
		
	//	String cmb = "";
		try {
			util = new HisUtil("MMS", "CIMSGenericDrugMstDATA");
			vo = new CIMSGenericDrugMstVO();
			bo = new CIMSGenericDrugMstBO();
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
			
			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);
			vo.setStrModuleId(formBean.getStrModuleId());
			//vo.setStrHospCode(formBean.getStrHospCode());
			////System.out.println("formBean.setStrChk  -->>"+formBean.getStrChk());
			
			////System.out.println("temp[1]"+temp[1]);
////System.out.println("vo.getStrItemId"+temp[0]);
            vo.setStrItemId(temp[0]);
            vo.setStrHospCode(temp[1]);
			vo.setStrSerialNo(temp[2]);
////System.out.println("vo.getStrItemId"+vo.getStrItemId());
			String temp11 = formBean.getComboValue();

			String strTemp[] = temp11.replace("^", "#").split("#");

			formBean.setStrGroupNameValue(strTemp[0]);

		//	vo.setStrModuleId(MmsConfigUtil.MODULE_ID);

			bo.modify(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				
				//bo.getStockMaintainedValues(vo);
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
				//formBean.setStrPurchaseLeadTime(vo.getStrPurchaseLeadTime());
				//formBean.setStrTimeFormat(vo.getStrTimeFormat());
				formBean.setStrShelfLife(vo.getStrShelfLife());
				formBean.setStrShelfTimeFormat(vo.getStrShelfTimeFormat());				
				formBean.setStrConsumableType(vo.getStrConsumableType());				
				formBean.setStrIsItemNarcotic(vo.getStrIsItemNarcotic());
				//formBean.setStrRemarks(vo.getStrRemarks());
				//formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
				formBean.setStrIsValid(vo.getStrIsValid());				
				formBean.setStrConsentReq(vo.getStrConsentReq());
				formBean.setStrSubGroupNameValue(vo.getStrSubGroupNameValue());
				formBean.setStrGroupNameValue(vo.getStrGroupNameValue());
				//formBean.setStrCPACode(vo.getStrCPACode());				
				formBean.setStrIsItemCodeRequired(vo.getStrIsItemCodeRequired());
				formBean.setStrStockMaintainedCode(vo.getStrStockMaintainedCode());
				formBean.setStrAtcClassCode(vo.getStrAtcClassCode());
				formBean.setStrPregnancySafeFlag(vo.getStrPregnancySafeFlag());
				formBean.setStrContraindictioncode(vo.getStrContraindictioncode());
				formBean.setStrDrugAdmincode(vo.getStrDrugAdmincode());
				formBean.setStrStoragecode(vo.getStrStoragecode());
				formBean.setStrdosageadult(vo.getStrdosageadult());
				formBean.setStrsprecau(vo.getStrsprecau());
				formBean.setStradvdrug(vo.getStradvdrug());
				formBean.setStrmechact(vo.getStrmechact());
				formBean.setStrlabintfrnce(vo.getStrlabintfrnce());
				formBean.setStrAdminRoute(vo.getStrAdminRoute());
				formBean.setStrDrugval(vo.getStrDrugval());
				formBean.setStrdosagepeads(vo.getStrdosagepeads());
				formBean.setStrDrugIdval(vo.getStrDrugIdval());
				bo.getPregCat(vo);
				bo.getContracdictoryDrugList(vo);
				bo.getAdministartion(vo);
				bo.getStorage(vo);
				bo.getContraindicationsList(vo);
				bo.getAdminRoute(vo);
				formBean.setStrPregnancySafeFlag(util.getOptionValue(vo.getPregcatDtlWS(),vo.getStrPregnancySafeFlag(), "", false));
				formBean.setStrCPACode(vo.getStrCPACode());
				
				
				formBean.setStrDrugval(util.getOptionValue(vo.getDrugvalWS(),vo.getStrDrugval(),  "0^Select Value", false));
				bo.getStockMaintainedValues(vo);
				if (vo.getStockMaintainedWS() == null	|| vo.getStockMaintainedWS().size() == 0) {
					formBean.setStrStockMaintainedValues("<option value='0'>Select Value</option>");

				} else {
					formBean.setStrStockMaintainedValues(util.getOptionValue(vo.getStockMaintainedWS(),vo.getStrStockMaintainedCode(), "", false));
				}
				formBean.setStrDrugAdmincode(util.getOptionValue(vo.getAdminWS(), formBean.getStrDrugAdmincode(), "0^Select Value", false));
				formBean.setStrContraindictioncode(util.getOptionValue(vo.getContraindWS(), formBean.getStrContraindictioncode(), "0^Select Value", false));
				formBean.setStrStoragecode(util.getOptionValue(vo.getStorageWS(), "", "", false));
				formBean.setStrAdminRoute(util.getOptionValue(vo.getAdminRouteWS(), formBean.getStrAdminRoute(), "0^Select Value", false));
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
			CIMSGenericDrugMstFB formBean) {
		CIMSGenericDrugMstBO bo = null;
		CIMSGenericDrugMstVO vo = null;
		boolean retValue = true;
		String temp[] = null;
		int nStopI = 0;
		String strContraDrugsId = "",strContraDrugs="";
		//MmsConfigUtil mms=new MmsConfigUtil(formBean.getStrHospCode());
		try {
			bo = new CIMSGenericDrugMstBO();
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

			vo = (CIMSGenericDrugMstVO) TransferObjectFactory.populateData("mms.masters.vo.CIMSGenericDrugMstVO", formBean);

			vo.setStrItemId(temp[0]);
			vo.setStrHospCode(temp[1]);
			vo.setStrSerialNo(temp[2]);
			
			
			//if(formBean.getStrIsItemCodeRequired().equals("1")){
				
				vo.setStrCPACode(formBean.getStrCPACode());
				
			//}else{
				
				//vo.setStrCPACode("0");
				
			//}
			vo.setStrStockMaintainedCode(formBean.getStrStockMaintainedCode());
			
            nStopI=formBean.getStrContradictoryDrugArray().length;
			
            for(int i=0;i<nStopI;i++)
			{
              //System.out.println("formBean.getStrContradictoryDrugArray()[i]"+formBean.getStrContradictoryDrugArray()[i]);
				if (!formBean.getStrContradictoryDrugArray()[i].equals("0")) {
					if (i == nStopI - 1) {
						strContraDrugsId = strContraDrugsId
								+ formBean.getStrContradictoryDrugIdArray()[i];
						strContraDrugs = strContraDrugs
								+ formBean.getStrContradictoryDrugArray()[i];
					} else
						strContraDrugsId = strContraDrugsId
								+ formBean.getStrContradictoryDrugIdArray()[i] + ",";
					strContraDrugs = strContraDrugs
							+ formBean.getStrContradictoryDrugArray()[i] + ",";
				}
			}
			
			vo.setStrDrugval(strContraDrugs.trim()); 
			vo.setStrDrugIdval(strContraDrugsId.trim());
			
			vo.setStrIsValid("1");
			
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrShelfTimeFormat(formBean.getStrShelfTimeFormat());
			// Calling BO Method
			bo.update(vo);
		/*	if (vo.getBExistStatus() == false) {
				formBean.setStrWarnMssgstring("Data already exist");
				retValue = false;
			}*/
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
			CIMSGenericDrugMstFB formBean) {
		CIMSGenericDrugMstBO bo = null;
		CIMSGenericDrugMstVO vo = null;
	 
		String temp[] = null;
		try {
			vo = new CIMSGenericDrugMstVO();
			bo = new CIMSGenericDrugMstBO();
			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());
			String strChk = request.getParameter("chk");
			strChk = strChk.replace("$", "@");
			temp = strChk.split("@");

			vo.setStrItemId(temp[0]);
			vo.setStrHospCode(temp[1]);
			vo.setStrSerialNo(temp[2]);
			

			//String temp1 = request.getParameter("cmbVal1");
			// String temp2 = request.getParameter("cmbVal2");
			//formBean.setStrGroupNameValue(temp1);
			// formBean.setStrSubGroupNameValue(temp2);

			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
			// formBean.setStrBrandItemDtlValues(DrugMSTHLP.getBrandItemView(vo.getStrItemId(),vo.getStrHospCode()));
			bo.view(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrInventoryUnitName(vo.getStrInventoryUnitName());
				formBean.setStrDrugName(vo.getStrDrugName());				
				formBean.setStrBatchNo(vo.getStrBatchNo());
				formBean.setStrExpiryDate(vo.getStrExpiryDate());
				//formBean.setStrPurchaseLeadTime(vo.getStrPurchaseLeadTime());
				//formBean.setStrTimeFormat(vo.getStrTimeFormat());
				formBean.setStrShelfLife(vo.getStrShelfLife());
				formBean.setStrShelfTimeFormat(vo.getStrShelfTimeFormat());				
				formBean.setStrConsumableType(vo.getStrConsumableType());				
				formBean.setStrIsItemNarcotic(vo.getStrIsItemNarcotic());
				//formBean.setStrRemarks(vo.getStrRemarks());
				//formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
				formBean.setStrIsValid(vo.getStrIsValid());				
				formBean.setStrConsentReq(vo.getStrConsentReq());
				formBean.setStrSubGroupNameValue(vo.getStrSubGroupNameValue());
				formBean.setStrGroupNameValue(vo.getStrGroupNameValue());
				//formBean.setStrCPACode(vo.getStrCPACode());				
				formBean.setStrIsItemCodeRequired(vo.getStrIsItemCodeRequired());
				formBean.setStrStockMaintainedCode(vo.getStrStockMaintainedCode());
				formBean.setStrAtcClassCode(vo.getStrAtcClassCode());
				formBean.setStrPregnancySafeFlag(vo.getStrPregnancySafeFlag());
				formBean.setStrContraindictioncode(vo.getStrContraindictioncode());
				formBean.setStrDrugAdmincode(vo.getStrDrugAdmincode());
				formBean.setStrStoragecode(vo.getStrStoragecode());
				formBean.setStrdosageadult(vo.getStrdosageadult());
				formBean.setStrsprecau(vo.getStrsprecau());
				formBean.setStradvdrug(vo.getStradvdrug());
				formBean.setStrmechact(vo.getStrmechact());
				formBean.setStrlabintfrnce(vo.getStrlabintfrnce());
				formBean.setStrAdminRoute(vo.getStrAdminRoute());
				formBean.setStrDrugval(vo.getStrDrugval());
                formBean.setStrBrand(vo.getStrBrand());
				formBean.setStrdosagepeads(vo.getStrdosagepeads());
				

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
