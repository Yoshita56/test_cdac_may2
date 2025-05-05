package mms.masters.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.masters.bo.GenericItemMstBO;

import mms.masters.controller.fb.GenericItemMstFB;

import mms.masters.vo.GenericItemMstVO;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 * 
 * 
 * Developer : Balasubramaniam M Version : 1.1 Modified Date : 13/Jan/2010 Desc
 * : Generic Master Inventory Unit cannot be Modified.
 * 
 * 
 */

public class GenericItemMstDATA {

	/**
	 * Inits the param add.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void initParamAdd(HttpServletRequest request,
			GenericItemMstFB formBean) {
		HisUtil util = null;
		GenericItemMstBO bo = null;
		GenericItemMstVO genericItemMstVO = null;
		String cmb = "";
		String strmsgText = "";
		MmsConfigUtil mms=new MmsConfigUtil(formBean.getStrHospCode());
		try {

			util = new HisUtil("MMS", "GenericItemMstDATA)");
			genericItemMstVO = new GenericItemMstVO();
			bo = new GenericItemMstBO();

			formBean.setStrPurchaseLeadTime(mms.getStrPurchaseLeadTime());
			formBean.setStrShelfLife(mms.getStrSelfLife());
			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			String temp[] = request.getParameterValues("combo");

			if (request.getParameterValues("combo") != null) {
				formBean.setStrCatNo(temp[0]);
				formBean.setStrGroupId(temp[1]);

				if (temp[1] == null || temp[1].equals("")
						|| temp[1].equals("0")) {
					temp[1] = "0";
				}

				formBean.setStrSubGroupId(temp[2]);

			}

			genericItemMstVO.setStrCatNo(formBean.getStrCatNo());
			genericItemMstVO.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);

			formBean.setCombo(request.getParameterValues("combo"));

			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);
			genericItemMstVO.setStrModuleId(formBean.getStrModuleId());

			String temp1 = formBean.getComboValue();
			if (temp1 != null && !temp1.equals("")) {
				String strTemp[] = temp1.replace("^", "#").split("#");
				formBean.setStrCatValues(strTemp[0]);
				formBean.setStrGroupNameValue(strTemp[1]);
				if (strTemp.length != 3) {
					formBean.setStrSubGroupNameValue("");
				} else {
					formBean.setStrSubGroupNameValue(strTemp[2]);
				}

			}

			// bo.setCatValue(genericItemMstVO);
			if (genericItemMstVO.getStrMsgType().equals("1"))
				throw new Exception(genericItemMstVO.getStrMsgString());
			/*
			 * if (genericItemMstVO.getItemCategoryWS() != null &&
			 * genericItemMstVO.getItemCategoryWS().size() > 0) { cmb = util
			 * .getOptionValue(genericItemMstVO.getItemCategoryWS(),
			 * genericItemMstVO.getStrCatNo(), "0^Select Value", false); } else
			 * { cmb = "<option value='0'>Select Value</option>"; }
			 */

			// formBean.setStrCatValues(cmb);

			bo.getStockMaintainedValues(genericItemMstVO);

			if (genericItemMstVO.getStrMsgType().equals("1"))
				throw new Exception(genericItemMstVO.getStrMsgString());

			formBean.setStrIsItemCodeRequired(genericItemMstVO
					.getStrIsItemCodeRequired());
			formBean.setStrCurrentDate(util.getASDate("dd-MMM-yyyy"));

			if (genericItemMstVO.getStockMaintainedWS() != null
					&& genericItemMstVO.getStockMaintainedWS().size() > 0) {
				cmb = util.getOptionValue(
						genericItemMstVO.getStockMaintainedWS(), "",
						"", false);
				// cmb = "<option value='0'>Select Value</option>";
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
			formBean.setStrStockMaintainedValues(cmb);

			formBean.setStrEffectiveFrom(util.getASDate("dd-MMM-yyyy"));

		} catch (Exception _e) {

			strmsgText = "Item Master.ItemMstDATA.initParamAdd(vo) --> "
					+ _e.getMessage();
			HisException eObj = new HisException("mms",
					"GenericItemMstDATA->initParamAdd()", strmsgText);

			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		}

	}

	/*
	 * This function is used to insert data
	 */
	/**
	 * Insert.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void insert(HttpServletRequest request,
			GenericItemMstFB formBean) {
		GenericItemMstBO bo = null;
		GenericItemMstVO vo = null;
		HisUtil util = null;
		try {
			util = new HisUtil("MMS", "GenericItemMstDATA)");
			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());

			vo = (GenericItemMstVO) TransferObjectFactory.populateData(
					"mms.masters.vo.GenericItemMstVO", formBean);

			if (!formBean.getStrCPACode().trim().equals("")) {

				vo.setStrCPACode(formBean.getStrCPACode());

			} else {

				vo.setStrCPACode("0");

			}

			bo = new GenericItemMstBO();
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
			formBean.setStrStockMaintainedValues(util.getOptionValue(
					vo.getStockMaintainedWS(), "0", "0^Select Value", false));

		} catch (Exception e) {
			String strmsgText = "Item Master.ItemMstDATA.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"GenericItemMstDATA->insert()", strmsgText);
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
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void modify(HttpServletRequest request,
			GenericItemMstFB formBean) {
		GenericItemMstBO bo = null;
		GenericItemMstVO vo = null;
		// HisUtil util = null;

		String tempChk[] = null;

		try {
			vo = new GenericItemMstVO();
			bo = new GenericItemMstBO();

			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());

			if (request.getParameter("chk") != null) {
				String strChk = request.getParameter("chk");
				strChk = strChk.replace("$", "@");
				tempChk = strChk.split("@");
				formBean.setStrChk(strChk);
			} else {
				String strChk = formBean.getStrChk();
				strChk = strChk.replace("$", "@");
				tempChk = strChk.split("@");
			}

			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);

			String temp11 = formBean.getComboValue();
			String strTemp[] = temp11.replace("^", "#").split("#");

			formBean.setStrCatValues(strTemp[0]);
			formBean.setStrGroupNameValue(strTemp[1]);

			vo.setStrItemId(tempChk[0]);

			vo.setStrHospCode(tempChk[1]);
			vo.setStrSerialNo(tempChk[2]);
			
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);

			// //System.out.println(""+);
			bo.modify(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {


				formBean.setStrInventoryUnitName(vo.getStrInventoryUnitName());
				formBean.setStrItemName(vo.getStrItemName());
				formBean.setStrBatchNo(vo.getStrBatchNo());
				formBean.setStrExpiryDate(vo.getStrExpiryDate());
				formBean.setStrPurchaseLeadTime(vo.getStrPurchaseLeadTime());
				formBean.setStrTimeFormat(vo.getStrTimeFormat());
				formBean.setStrShelfLife(vo.getStrShelfLife());
				formBean.setStrShelfTimeFormat(vo.getStrShelfTimeFormat());
				formBean.setStrConsumableType(vo.getStrConsumableType());
				formBean.setStrRemarks(vo.getStrRemarks());
				formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
				formBean.setStrIsValid(vo.getStrIsValid());
				formBean.setStrParam(vo.getStrParam());
				// formBean.setStrItemComposit(vo.getStrItemComposit());
				formBean.setStrSerialNo(vo.getStrSerialNo());
				formBean.setStrCatNo(vo.getStrCatNo());
				formBean.setStrItemID(formBean.getStrChk().replace("$", "@").split("@")[0]);
				formBean.setStrSubGroupNameValue(vo.getStrSubGroupNameValue());
				formBean.setStrGroupNameValue(vo.getStrGroupNameValue());
				formBean.setStrAssetsReq(vo.getStrAssetsReq());
				formBean.setStrDepreciationcost(vo.getStrDepreciationcost());
				formBean.setStrIsItemCodeRequired(vo.getStrIsItemCodeRequired());
				formBean.setStrCPACode(vo.getStrCPACode());
				formBean.setStrStockMaintainedCode(vo.getStrStockMaintainedCode());

			}
		} catch (Exception e) {

			e.printStackTrace();

			String strmsgText = "Item Master.ItemMstDATA.modify(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"GenericItemMstDATA->modify()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;
			// util = null;
		}
	}

	/**
	 * This function is used to invoke Bo's update method to update data.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 * 
	 * @return true, if update
	 */
	public static boolean update(HttpServletRequest request,
			GenericItemMstFB formBean) {
		GenericItemMstBO bo = null;
		GenericItemMstVO vo = null;
		boolean retValue = true;
		String tempChk[] = null;

		try {
			bo = new GenericItemMstBO();
			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());

			String strChk = formBean.getStrChk();
			// // //System.out.println("strChk-"+strChk);
			strChk = strChk.replace("$", "@");
			tempChk = strChk.split("@");
			if (request.getParameterValues("combo") != null) 
			{
				String temp1[] = request.getParameterValues("combo");
				formBean.setStrGroupId(temp1[1]);
				formBean.setStrSubGroupId(temp1[2]);
				formBean.setCombo(request.getParameterValues("combo"));

			} 
			else
			{
				String temp1[] = formBean.getCombo();
				formBean.setStrGroupId(temp1[1]);
				formBean.setStrSubGroupId(temp1[2]);

			}

			vo = (GenericItemMstVO) TransferObjectFactory.populateData("mms.masters.vo.GenericItemMstVO", formBean);

			vo.setStrItemId(tempChk[0]);
			vo.setStrHospCode(tempChk[1]);
			vo.setStrSerialNo(tempChk[2]);
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
			String strmsgText = "Item Master.ItemMstDATA.update(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"GenericItemMstDATA->update()", strmsgText);
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
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 */
	public static void view(HttpServletRequest request,
			GenericItemMstFB formBean) {
		GenericItemMstBO bo = null;
		GenericItemMstVO vo = null;

		// String temp = "";
		String tempChk[] = null;
		try {
			vo = new GenericItemMstVO();
			bo = new GenericItemMstBO();

			formBean.setStrHospCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
					.toString());
			String strChk = request.getParameter("chk");
			strChk = strChk.replace("$", "@");
			tempChk = strChk.split("@");

			String temp1 = request.getParameter("cmbVal1");

			formBean.setStrGroupNameValue(temp1);

			vo.setStrChk(formBean.getStrChk());
			vo.setStrHospCode(formBean.getStrHospCode());
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
			vo.setStrItemId(tempChk[0]);
			vo.setStrHospCode(tempChk[1]);
			vo.setStrSerialNo(tempChk[2]);

			bo.view(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {

				formBean.setStrItemName(vo.getStrItemName());

				/*
				 * This code is deactivated by Aritra on 1st June, 2010 Reason:
				 * vo.strBatchNo, vo.strExpiryDate, vo.strSerialNo all are
				 * already set to "Yes" or "No".
				 * ************************************************************
				 * if (vo.getStrBatchNo().equals("1"))
				 * formBean.setStrBatchNo("Yes"); else
				 * formBean.setStrBatchNo("No");
				 * 
				 * if (vo.getStrExpiryDate().equals("1"))
				 * formBean.setStrExpiryDate("Yes"); else
				 * formBean.setStrExpiryDate("No");
				 * 
				 * if (vo.getStrSerialNo().equals("1"))
				 * formBean.setStrSerialNo("Yes"); else
				 * formBean.setStrSerialNo("No");
				 */

				/*
				 * This 4 lines is added by Aritra on 1st June, 2010 Reason: To
				 * set value in formBean for the fields strBatchNo,
				 * strExpiryDate, strSerialNo, strGroupNameValue
				 */
				formBean.setStrBatchNo(vo.getStrBatchNo());
				formBean.setStrExpiryDate(vo.getStrExpiryDate());
				formBean.setStrSerialNo(vo.getStrSerialNo());
				formBean.setStrGroupNameValue(vo.getStrGroupNameValue());
				/* ********** ---End of 31st May Addition--- *********** */

				formBean.setStrItemID(vo.getStrItemId());
				formBean.setStrStockMaintain(vo.getStrStockMaintain());
				formBean.setStrPurchaseLeadTime(vo.getStrPurchaseLeadTime());
				formBean.setStrTimeFormat(vo.getStrTimeFormat());
				formBean.setStrShelfLife(vo.getStrShelfLife());
				formBean.setStrShelfTimeFormat(vo.getStrShelfTimeFormat());
				formBean.setStrConsumableType(vo.getStrConsumableType());
				formBean.setStrRemarks(vo.getStrRemarks());
				formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
				formBean.setStrIsValid(vo.getStrIsValid());
				formBean.setStrParam(vo.getStrParam());
				// formBean.setStrSerialNo(vo.getStrSerialNo());
				formBean.setStrCatNo(vo.getStrCatNo());

				formBean.setStrCatValues(vo.getStrCatValues());

				formBean.setStrSubGroupNameValue(vo.getStrSubGroupNameValue());

				formBean.setStrConsumableFlag(vo.getStrConsumableFlag());
				formBean.setStrAssetsReq(vo.getStrAssetsReq());
				formBean.setStrDepreciationcost(vo.getStrDepreciationcost());
			}
		} catch (Exception e) {

			String strmsgText = "Item Master.ItemMstDATA.view(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("MMS",
					"GenericItemMstDATA->view()", strmsgText);
			formBean.setStrErrMssgstring("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}
	}

	/**
	 * To get values of ITEM TYPE COMBO.
	 * 
	 * @param request
	 *            the request
	 * @param formBean
	 *            the form bean
	 * @param response
	 *            the response
	 */
	/*
	 * public static void getItemTypeCombo(GenericItemMstFB formBean,
	 * HttpServletRequest request, HttpServletResponse response) {
	 * 
	 * String strmsgText = ""; GenericItemMstBO bo = null; GenericItemMstVO vo =
	 * null; HisUtil hisutil = null; String strItemCatNo = ""; String hosCode =
	 * ""; String seatid = ""; String cmb = "";
	 * 
	 * try {
	 * 
	 * bo = new GenericItemMstBO(); vo = new GenericItemMstVO();
	 * 
	 * hisutil = new HisUtil("MMS", "GenericItemMstDATA)"); strItemCatNo =
	 * (String) request.getParameter("ItemCatNo");
	 * 
	 * hosCode = request.getSession().getAttribute("HOSPITAL_CODE") .toString();
	 * seatid = request.getSession().getAttribute("SEATID").toString();
	 * 
	 * //// //System.out.println("strItemCatNo-"+strItemCatNo); ////
	 * //System.out.println("hosCode-"+hosCode); vo.setStrHospCode(hosCode);
	 * vo.setStrSeatId(seatid); vo.setStrCatNo(strItemCatNo); //
	 * bo.getItemValues(vo);
	 * 
	 * if (vo.getStrMsgType().equals("1")) { throw new
	 * Exception(vo.getStrMsgString()); }
	 * 
	 * try { response.setHeader("Cache-Control", "no-cache");
	 * response.getWriter().print(cmb); } catch (Exception e1) { } } catch
	 * (Exception e) { strmsgText = "Item
	 * Master.ItemMstDATA.getItemTypeCombo(vo) --> " + e.getMessage();
	 * HisException eObj = new HisException("mms",
	 * "GenericItemMstDATA->getItemTypeCombo()", strmsgText); try {
	 * response.setHeader("Cache-Control", "no-cache");
	 * response.getWriter().print( "ERROR#### Application Error [ERROR ID : " +
	 * eObj.getErrorID() + "],Contact System Administrator! "); } catch
	 * (Exception e1) { }
	 * 
	 * eObj = null; } finally { vo = null; bo = null; hisutil = null; } }
	 */

	/**
	 * To get values of INVENTORY UNIT COMBO
	 * 
	 * @param form
	 * @param request
	 */
	public static void getInventoryUnitCombo(GenericItemMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		GenericItemMstBO bo = null;
		GenericItemMstVO vo = null;
		HisUtil hisutil = null;
		String strConsumableType = "";
		String hosCode = "";
		String seatid = "";
		String cmb = "";

		try {

			bo = new GenericItemMstBO();
			vo = new GenericItemMstVO();

			hisutil = new HisUtil("MMS", "GenericItemMstDATA)");
			strConsumableType = (String) request.getParameter("ConsumableFlag");

			hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrConsumableType(strConsumableType);
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);

			bo.getInventoryUnitCmb(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStockMaintainedWS() != null
					&& vo.getStockMaintainedWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getStockMaintainedWS(), "0",
						"0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);

			} catch (Exception e1) {

			}

		} catch (Exception e) {
			strmsgText = "Generic Item Master.ItemMstDATA.getInventoryUnitCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"GenericItemMstDATA->getInventoryUnitCombo()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {

			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}
}
