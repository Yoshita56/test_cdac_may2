/**
 * 
 */
package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.setup.MmsConfigGeneral;
import mms.transactions.bo.ItemInventoryTransBO;
import mms.transactions.controller.fb.ItemInventoryTransFB;
import mms.transactions.vo.ItemInventoryTransVO;


/**
 * @author pankaj
 * 
 */

/**( NOT INSERTING CORRECT VALUES, MODIFY/UPDATE WAS NOT WORKING AND SUBGROUP SHOULD NOT BE MANDATORY ON ADD)
 * Developer : Anshul Jindal ( TO CONTINUE AND CORRECTIONS )
 * Version : 1.0 Date : 21/Apr/2009
 * 
 */
public class ItemInventoryTransDATA {

	/**
	 * to display the Store Name and Group Name on Add page
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void initialAdd(ItemInventoryTransFB formBean,
			HttpServletRequest request) {

		ItemInventoryTransBO bo = null;
		ItemInventoryTransVO vo = null;

		String strmsgText = "";
		HisUtil hisutil = null;
		String SubGroupCmb = "";
		String ItemCmb = "";

		try {
			bo = new ItemInventoryTransBO();
			vo = new ItemInventoryTransVO();
			hisutil = new HisUtil("mms", "ItemInventoryTransDATA");
			
			
			if (!formBean.getComboValue().equals("")) {
				String strCmbNames = formBean.getComboValue();
				String[] temp = strCmbNames.replace("^", "#").split("#");
				formBean.setStrStoreName(temp[0]);
				formBean.setStrItemCategoryName(temp[1]);
				formBean.setStrGroupName(temp[2]);

			}

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strStoreId = formBean.getCombo()[0];
			
			String[] strTempVal = formBean.getCombo()[1].replace("^", "#").split("#");
			
			String strItemCategoryId = strTempVal[0];
			String strWarrantyFlag = strTempVal[1];
			String strInstallFlag = strTempVal[2];
			
			String strGroupId = formBean.getCombo()[2];
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo(strItemCategoryId);
			vo.setStrGroupId(strGroupId);

			formBean.setStrGroupId(strGroupId);
			formBean.setStrDefaultCurrencyCode(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			////System.out.println("strItemCategoryId>>>>>>"+strItemCategoryId);
			formBean.setStrItemCategoryNo(strItemCategoryId);
			formBean.setStrWarrantyFlag(strWarrantyFlag);
			formBean.setStrInstallFlag(strInstallFlag);
			
			bo.initialAdd(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStrSubGroupComboWs().size() == 0
					|| vo.getStrSubGroupComboWs() == null) {
				SubGroupCmb = "<option value='0'>All</option>";
			} else {
				SubGroupCmb = hisutil.getOptionValue(
						vo.getStrSubGroupComboWs(), "0", "0^All", true);

			}

			formBean.setStrSubGroupCombo(SubGroupCmb);

			if (vo.getStrItemNameComboWS().size() == 0
					|| vo.getStrItemNameComboWS() == null) {
				ItemCmb = "<option value='0'>Select Value</option>";
			} else {
				ItemCmb = hisutil.getOptionValue(vo.getStrItemNameComboWS(),
						"0", "0^Select Value", true);

			}

			formBean.setStrItemNameCombo(ItemCmb);

			if (vo.getStrManufactureComboWS().size() == 0
					|| vo.getStrManufactureComboWS() == null) {
				ItemCmb = "<option value='0'>Select Value</option>";
			} else {
				ItemCmb = hisutil.getOptionValue(vo.getStrManufactureComboWS(),
						"0", "0^Select Value", true);

			}

			formBean.setStrSuppliedByValues(ItemCmb);
			
			
			if (vo.getStrCurrencyCodeWs().size() == 0
					|| vo.getStrCurrencyCodeWs() == null) {
				ItemCmb = "<option value='0'>Select Value</option>";
			} else {
				ItemCmb = hisutil.getOptionValue(vo.getStrCurrencyCodeWs(),
						MmsConfigUtil.DEFAULT_CURRENCY_CODE, "0^Select Value", true);

			}

			formBean.setStrCurrencyCodeValues(ItemCmb);
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			formBean.setStrIssueRateConfigFlg(mmscofigutil.getStrIssueRateConfigFlg());			

		} catch (Exception e) {

			strmsgText = "Drug Inventory.ItemInventoryTransDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemInventoryTransDATA->initialAdd()", strmsgText);
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
	 * To get values of SubgroupCombo
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void itemName(ItemInventoryTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ItemInventoryTransBO bo = null;
		ItemInventoryTransVO vo = null;
		HisUtil hisutil = null;
		try {

			bo = new ItemInventoryTransBO();
			vo = new ItemInventoryTransVO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();

			
			
			String subGroupId = (String) request.getParameter("strSubGroupId");
			String strGroupId = (String) request.getParameter("GroupId");
			String strStoreId = (String) request.getParameter("storeId");
			String strCategoryCode = (String) request.getParameter("strCatCode");
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo(strCategoryCode);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrSubGroupId(subGroupId);
			vo.setStrGroupId(strGroupId);

			bo.getItemName(vo);
			vo.getStrItemNameComboWS();

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			 hisutil = new HisUtil("mms", "ItemInventoryTransDATA");
			String cmbstr = hisutil.getOptionValue(vo.getStrItemNameComboWS(),
					vo.getStrItemId(), "0^Select Value", false);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = "ItemInventory.ItemInventoryTransDATA.itemName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemInventoryTransDATA->itemName()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}

	/**
	 * To get values of Item Name Combo
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void itemBrandName(ItemInventoryTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ItemInventoryTransBO bo = null;
		ItemInventoryTransVO vo = null;

		try {

			bo = new ItemInventoryTransBO();
			vo = new ItemInventoryTransVO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();
			String itemId = (String) request.getParameter("strItemId");
			String strStoreId = (String) request.getParameter("storeId");
			String strGroupId = (String) request.getParameter("strGroupId");
			String strSubGroupId = (String) request.getParameter("strSubGroupId");
			String strCategoryCode = (String) request.getParameter("strCatCode");
			
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo(strCategoryCode);
			vo.setStrGroupId(strGroupId);
			vo.setStrSubGroupId(strSubGroupId);
			
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrItemId(itemId);

			bo.getItemBrandName(vo);
			vo.getStrItemNameComboWS();

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			HisUtil hisutil = new HisUtil("mms", "ItemInventoryTransDATA");
			String cmbstr = hisutil.getOptionValue(vo.getStrItemBrandComboWS(),
					vo.getStrItemBrandId(), "0^Select Value", false);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "ItemInventory.ItemInventoryTransDATA.itemBrandName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemInventoryTransDATA->itemBrandName()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
		}
	}

	/**
	 * To get Brand Details of a Branded Item
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void getBrandDetails(ItemInventoryTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ItemInventoryTransBO bo = null;
		ItemInventoryTransVO vo = null;

		try {

			bo = new ItemInventoryTransBO();
			vo = new ItemInventoryTransVO();

			 
			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			  
			String strItemBrandId = (String) request
					.getParameter("strItemBrandId");

			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrHospitalCode(strHospitalCode);
		 
			bo.getBrandDetails(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			String strBrandDetails = vo.getStrRegFlag()+"^"+vo.getStrBrandDetails(); 
		  
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strBrandDetails);
		 
		} catch (Exception e) {

			e.printStackTrace();

			String strmsgText = "ItemInventory.ItemInventoryTransDATA.getBrandDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemInventoryTransDATA->getBrandDetails()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
		}
	}
	
	
	/**
	 * To get values of Manufacture Name combo
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void manufectuteName(ItemInventoryTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ItemInventoryTransBO bo = null;
		ItemInventoryTransVO vo = null;

		try {

			bo = new ItemInventoryTransBO();
			vo = new ItemInventoryTransVO();

			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);
			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();

			String strItemBrandId = (String) request
					.getParameter("strItemBrandId");

			String strCatCode = (String) request.getParameter("strCatCode");
			
			vo.setStrItemCategoryNo(strCatCode);

			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			bo.getmanufectuteName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			HisUtil hisutil = new HisUtil("mms", "ItemInventoryTransDATA");
			String cmbstr = hisutil.getOptionValue(vo
					.getStrManufactureComboWS(), vo.getStrManufactureId(),
					"0^Select Value", false);

			try {
				response.setHeader("Cache-Control", "no-cache");
				formBean.setStrManufactureCombo(cmbstr);
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = "ItemInventory.ItemInventoryTransDATA.manufectuteName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemInventoryTransDATA->manufectuteName()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
		}
	}

	/**
	 * to insert the data
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void insert(ItemInventoryTransFB formBean) {
		String strmsgText = "";
		ItemInventoryTransBO bo = null;
		ItemInventoryTransVO vo = null;

		MmsConfigUtil mmsUtil = null;

		try {
			bo = new ItemInventoryTransBO();

			vo = (ItemInventoryTransVO) TransferObjectFactory.populateData(
					"mms.transactions.vo.ItemInventoryTransVO", formBean);

			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());

			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			vo.setStrInHandQuantityUnitID(formBean.getStrInHandQuantityUnitID()
					.replace("^", "#").split("#")[0]);
			vo.setStrUnitRateID(formBean.getStrUnitRateID().replace("^", "#")
					.split("#")[0]);
			vo.setStrUnitSaleID(formBean.getStrUnitSaleID().replace("^", "#")
					.split("#")[0]);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());

			if (formBean.getStrBatchNo().trim().equals("0")
					|| formBean.getStrBatchNo().trim().length() < 1) {

				vo.setStrBatchNo(mmsUtil.getStrBatchNo());

			}

			vo.setStrStockStatus(formBean.getCombo()[3]);
			
			vo.setStrFinancialStartYear(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinancialEndYear(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			
			bo.insert(vo);
			
			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());
			
			formBean.setStrSerialNo(vo.getStrSerialNo());
			
			if(vo.getStrSerialNo().length() > 2){
			
				formBean.setStrMsg("Data has been Successfully Saved; Generated Serial No. is <b>"+formBean.getStrSerialNo()+"</b>");
			}else{
				formBean.setStrMsg("Data has been Successfully Saved");
			}
			
			formBean.setStrIsWarrantyDetails("0");
			formBean.setStrIsInstallDetails("0");

		} catch (Exception e) {

			strmsgText = "Item Inventory.ItemInventoryTransDATA.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemInventoryTransDATA->insert()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {

			bo = null;
			vo = null;
			mmsUtil = null;

		}
	}

	
	public static void modify(ItemInventoryTransFB formBean) {
		String strmsgText = "";
		ItemInventoryTransBO bo = null;
		ItemInventoryTransVO vo = null;
		HisUtil util = null;
		try {
			bo = new ItemInventoryTransBO();

			vo = new ItemInventoryTransVO();

			
			if (!formBean.getComboValue().equals("")) {
				String strCmbNames = formBean.getComboValue();
				String[] temp = strCmbNames.replace("^", "#").split("#");
				formBean.setStrStoreName(temp[0]);
				formBean.setStrItemCategoryName(temp[1]);
				formBean.setStrGroupName(temp[2]);

			}
			
		
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			String[] strValues = formBean.getStrChk().replace("@", "#").split("#");
			
			vo.setStrStoreId(strValues[0]);
			vo.setStrItemId(strValues[1]);
			vo.setStrItemBrandId(strValues[2]);
			vo.setStrBatchNo(strValues[3]);
			vo.setStrSerialNo(strValues[4]);
			vo.setStrStockStatus(strValues[6].replace("$", "#").split("#")[0]);
			
			String[] strTempVal = formBean.getCombo()[1].replace("^", "#").split("#");
			
			String strItemCategoryId = strTempVal[0];
			String strWarrantyFlag = strTempVal[1];
			String strInstallFlag = strTempVal[2];
			
			vo.setStrItemCategoryNo(strItemCategoryId);
			vo.setStrWarrantyFlag(strWarrantyFlag);
			vo.setStrInstallFlag(strInstallFlag);
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
			
			bo.modifyRecord(vo);

	
			TransferObjectFactory.populateData(formBean, vo);
			
			formBean.setStrDefaultCurrencyCode(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			formBean.setStrItemCategoryNo(strItemCategoryId);
			formBean.setStrWarrantyFlag(strWarrantyFlag);
			formBean.setStrInstallFlag(strInstallFlag);
			
			util = new HisUtil("mms", "ItemInventoryTransDATA");
			String strTemp = "";
			
			if (vo.getStrManufactureComboWS().size() == 0
					|| vo.getStrManufactureComboWS() == null) {
				strTemp = "<option value='0'>Select Value</option>";
			} else {
				strTemp = util.getOptionValue(vo.getStrManufactureComboWS(),
						formBean.getStrSuppliedBy(), "0^Select Value", true);

			}

			formBean.setStrSuppliedByValues(strTemp);
			
			
			if (vo.getStrCurrencyCodeWs().size() == 0
					|| vo.getStrCurrencyCodeWs() == null) {
				strTemp = "<option value='0'>Select Value</option>";
			} else {
				strTemp = util.getOptionValue(vo.getStrCurrencyCodeWs(),
						formBean.getStrCurrencyCode(), "0^Select Value", true);

			}

			formBean.setStrCurrencyCodeValues(strTemp);
			formBean.setStrDefaultCurrencyCode(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
			if (vo.getStrStockStatusWs().size() == 0
					|| vo.getStrStockStatusWs() == null) {
				strTemp = "<option value='0'>Select Value</option>";
			} else {
				strTemp = util.getOptionValue(vo.getStrStockStatusWs(),
						formBean.getStrStockStatus(), "0^Select Value", true);

			}

			formBean.setStrStockStatusValues(strTemp);
			
			
			if (vo.getStrUnitNameComboWS().size() == 0
					|| vo.getStrUnitNameComboWS() == null) {
				strTemp = "<option value='0'>Select Value</option>";
			} else {
				strTemp = util.getOptionValue(vo.getStrUnitNameComboWS(),
						formBean.getStrInHandQuantityUnitID(), "0^Select Value", false , false);

			}

			formBean.setStrInHandQuantityUnitValues(strTemp);
						
			if (vo.getStrUnitRateComboWS().size() == 0
					|| vo.getStrUnitRateComboWS() == null) {
				strTemp = "<option value='0'>Select Value</option>";
			} else {
				strTemp = util.getOptionValue(vo.getStrUnitRateComboWS(),
						formBean.getStrUnitRateID(), "0^Select Value", false , false);

			}

			formBean.setStrRateUnitValues(strTemp);
			
			
			if (vo.getStrUnitSaleComboWS().size() == 0
					|| vo.getStrUnitSaleComboWS() == null) {
				strTemp = "<option value='0'>Select Value</option>";
			} else {
				strTemp = util.getOptionValue(vo.getStrUnitSaleComboWS(),
						formBean.getStrUnitSaleID(), "0^Select Value", false , false);

			}

			formBean.setStrSalesRateUnitValues(strTemp);
			
			
			if (vo.getStrWarrantyManufactureComboWS() != null && vo.getStrWarrantyManufactureComboWS().size() == 0 ) {
				strTemp = "<option value='0'>Select Value</option>";
			} else {
				strTemp = util.getOptionValue(vo.getStrWarrantyManufactureComboWS(),
						vo.getStrWarantyManufacturer(), "0^Select Value", false, false);

			}

			formBean.setStrManufactureCombo(strTemp);
			
			
						
			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());
			

		} catch (Exception e) {

			strmsgText = "Item Inventory.ItemInventoryTransDATA.modify(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemInventoryTransDATA->modify()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {

			bo = null;
			vo = null;
			util = null;
		
		}
	}
	
	
	/**
	 * To get values of Unit on the basics of Item Name combo
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void unitNameCombo(ItemInventoryTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ItemInventoryTransBO bo = null;
		ItemInventoryTransVO vo = null;
		// MmsConfigUtil mcu = null;

		try {

			bo = new ItemInventoryTransBO();
			vo = new ItemInventoryTransVO();
			// mcu = new MmsConfigUtil();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();
			String itemId = (String) request.getParameter("strItemId");
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrItemId(itemId);
			// vo.setStrModuleId(mcu.getStrModuleId());
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
			bo.unitNameCombo(vo);
			vo.getStrItemNameComboWS();

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			HisUtil hisutil = new HisUtil("mms", "ItemInventoryTransDATA");
			String cmbstr = hisutil.getOptionValue(vo.getStrUnitRateComboWS(),
					vo.getStrUnitRateID(), "", false);

			/*
			 * HisUtil hisutil1 = new HisUtil("mms", "ItemInventoryTransDATA");
			 * String cmbstr1 =
			 * hisutil1.getOptionValue(vo.getStrUnitSaleComboWS(),
			 * vo.getStrUnitSaleID(), "0^Select Value", false);
			 */

			try {
				// //System.out.println("cmbstr" + cmbstr);
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "ItemInventory.ItemInventoryTransDATA.unitNameCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemInventoryTransDATA->unitNameCombo()", strmsgText);
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
			// mcu = null;
		}
	}

	public static boolean update(ItemInventoryTransFB formBean) {
		String strmsgText = "";
		ItemInventoryTransBO bo = null;
		ItemInventoryTransVO vo = null;
		MmsConfigUtil mmsUtil = null;
		
		boolean res = false;
		
		try {
			bo = new ItemInventoryTransBO();

			 vo = (ItemInventoryTransVO) TransferObjectFactory.populateData(
					"mms.transactions.vo.ItemInventoryTransVO", formBean);

				mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());
		
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			String[] strValues = formBean.getStrChk().replace("@", "#").split("#");
			
			vo.setStrStoreId(strValues[0]);
			vo.setStrItemId(strValues[1]);
			vo.setStrItemBrandId(strValues[2]);
			vo.setStrBatchNo(strValues[3]);
			vo.setStrSerialNo(strValues[4] );	
			
			vo.setStrInHandQuantityUnitID(formBean.getStrInHandQuantityUnitID()
					.replace("^", "#").split("#")[0]);
			vo.setStrUnitRateID(formBean.getStrUnitRateID().replace("^", "#")
					.split("#")[0]);
			vo.setStrUnitSaleID(formBean.getStrUnitSaleID().replace("^", "#")
					.split("#")[0]);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
						
			vo.setStrOldStockStatus(formBean.getCombo()[3]);
			vo.setStrFinancialStartYear(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinancialEndYear(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			
			
			bo.update(vo);
			
			if (vo.getStrMsgType().equals("1")){
				throw new Exception(vo.getStrMsgString());
			}
			
			res = vo.getBExistStatus();
			
						
		} catch (Exception e) {

			strmsgText = "ItemInventory.ItemInventoryTransDATA.update(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemInventoryTransDATA->update()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {

			bo = null;
			vo = null;
			mmsUtil = null;

		}
		
		return res;
		
	}

	public static void getIsModify(ItemInventoryTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ItemInventoryTransBO bo = null;
		ItemInventoryTransVO vo = null;

		try {

			bo = new ItemInventoryTransBO();
			vo = new ItemInventoryTransVO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			
			String strTemp = (String) request.getParameter("strChkVal");
			
			String strTempVal[] = strTemp.replace("@", "#").split("#");
			
			String strTempVal2 = strTempVal[6].replace("^", "#").split("#")[1];
			
			vo.setStrStoreId(strTempVal[0]);
			vo.setStrItemCategoryNo(strTempVal2);
			vo.setStrItemBrandId(strTempVal[2]);
			vo.setStrItemId(strTempVal[1]);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSerialNo(strTempVal[4]);
			vo.setStrBatchNo(strTempVal[3]);
		
			

			bo.getModifyValue(vo);
			
			String cmbstr = vo.getStrModifyValue();
			

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			
			
			e.printStackTrace();
			
			strmsgText = "ItemInventoryTransDATA.getIsModify(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemInventoryTransDATA->getIsModify()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
		}
	}
	
}
