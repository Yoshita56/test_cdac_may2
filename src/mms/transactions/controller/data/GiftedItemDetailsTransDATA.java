package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hissso.config.HISSSOConfig;
import hissso.validation.credentails.authentication.AuthenticationCredentials;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.DupSupplierReturnFromTransBO;
import mms.transactions.bo.GiftedItemDetailsTransBO;
import mms.transactions.controller.fb.DupSupplierReturnFromTransFB;
import mms.transactions.controller.fb.GiftedItemDetailsTransFB;
import mms.transactions.controller.hlp.DupSupplierReturnFromTransHLP;
import mms.transactions.controller.hlp.GiftedItemDetailsTransHLP;
import mms.transactions.vo.DupSupplierReturnFromTransVO;
import mms.transactions.vo.GiftedItemDetailsTransVO;

/**
 * 
 * @author Tanvi Sappal
 * 
 */
public class GiftedItemDetailsTransDATA {

	/**
	 * This function is used to set initial parameters required to display on main
	 * page
	 * 
	 * @param formBean
	 */
	public static void initialGenAdd(GiftedItemDetailsTransFB formBean, HttpServletRequest request) {
		GiftedItemDetailsTransVO vo = null;
		GiftedItemDetailsTransBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate;

		try {
			vo = new GiftedItemDetailsTransVO();
			bo = new GiftedItemDetailsTransBO();

			hisutil = new HisUtil("mms", "GiftedItemDetailsTransDATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrSeatId(seatid);
			formBean.setStrHospitalCode(hosCode);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			bo.initialGenAdd(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());

			}

			String temp = "";

			if (vo.getWsStoreNameCombo() != null && vo.getWsStoreNameCombo().size() > 0) {
				if (vo.getWsStoreNameCombo().next()) {
					vo.setStrStoreId(vo.getWsStoreNameCombo().getString(1));
					vo.getWsStoreNameCombo().beforeFirst();
				}
				temp = hisutil.getOptionValue(vo.getWsStoreNameCombo(), "", "", false, false);

			} else {

				temp = "<option value='0'>Select Value</option>";

			}

			formBean.setStrStoreNameCombo(temp);

			bo.getCategoryList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			String cmbstr = "";
			if (vo.getWsItemCategoryCombo() != null && vo.getWsItemCategoryCombo().size() > 0) {
				cmbstr = hisutil.getOptionValue(vo.getWsItemCategoryCombo(), "0", "0^Select Value", false);

			} else {

				cmbstr = "<option value='0'>Select Value</option>";
			}
			formBean.setStrItemCategoryCombo(cmbstr);
			MmsConfigUtil mmscofigutil = new MmsConfigUtil(hosCode);
			formBean.setStrIssueRateConfigFlg(mmscofigutil.getStrIssueRateConfigFlg());

			strCurrentDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->initialGenAdd()", strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			if (formBean != null)
				formBean = null;
			hisutil = null;

		}
	}

	public static void getCategoryList(GiftedItemDetailsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		String strmsgText = "";
		GiftedItemDetailsTransBO bo = null;
		GiftedItemDetailsTransVO vo = null;
		HisUtil hisutil = null;
		try {

			vo = new GiftedItemDetailsTransVO();
			bo = new GiftedItemDetailsTransBO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			String strStoreId = (String) request.getParameter("storeId");

			vo.setStrStoreId(strStoreId);
			vo.setStrHospitalCode(strHospitalCode);

			bo.getCategoryList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "ItemInventoryTransDATA");

			String cmbstr = "";

			if (vo.getWsItemCategoryCombo() != null && vo.getWsItemCategoryCombo().size() > 0) {

				cmbstr = hisutil.getOptionValue(vo.getWsItemCategoryCombo(), "0", "0^Select Value", false);

			} else {

				cmbstr = "<option value='0'>Select Value</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->getCategoryList()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : " + eObj.getErrorID()
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

	public static void getFinancialYear(GiftedItemDetailsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		String strmsgText = "";
		MmsConfigUtil mmsUtil = null;

		try {

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			mmsUtil = new MmsConfigUtil(strHospitalCode);

			String strStoreId = (String) request.getParameter("storeId");

			String strFinYear = "";

			if (mmsUtil.getStrFinancialStartDate(strStoreId, strHospitalCode).length() > 10)
				strFinYear = mmsUtil.getStrFinancialStartDate(strStoreId, strHospitalCode).substring(7, 11) + " - "
						+ mmsUtil.getStrFinancialEndDate(strStoreId, strHospitalCode).substring(7, 11);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strFinYear);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->getFinancialYear()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : " + eObj.getErrorID()
						+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			mmsUtil = null;
		}
	}

	public static void getGiftedItemList(GiftedItemDetailsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) 
	{

		String strmsgText = "";
		GiftedItemDetailsTransBO bo = null;
		GiftedItemDetailsTransVO vo = null;
		MmsConfigUtil mmsUtil = null;
		try 
		{

			vo = new GiftedItemDetailsTransVO();
			bo = new GiftedItemDetailsTransBO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			mmsUtil = new MmsConfigUtil(strHospitalCode);

			String strStoreId = (String) request.getParameter("storeId");
			String strItemCategoryId = (String) request.getParameter("strCategoryId");

			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryId(strItemCategoryId);
			vo.setStrHospitalCode(strHospitalCode);
//			vo.setStrFinancialStartYear(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
//			vo.setStrFinancialEndYear(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));

			vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
			vo.setStrFinancialEndYear((String) request.getParameter("endDate"));

			vo.setStrMode("4");
			bo.getGiftedItemList(vo);

			formBean.setWsGiftedItemList(vo.getWsGiftedItemList());
			
			

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			String strTemp = GiftedItemDetailsTransHLP.getGiftedItemsList_NEW(formBean);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strTemp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->getGiftedItemList()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : " + eObj.getErrorID()
						+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			mmsUtil = null;
		}
	}

	public static void getGiftedItemListNEW(GiftedItemDetailsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		String strmsgText = "";
		GiftedItemDetailsTransBO bo = null;
		GiftedItemDetailsTransVO vo = null;
		MmsConfigUtil mmsUtil = null;
		try {

			vo = new GiftedItemDetailsTransVO();
			bo = new GiftedItemDetailsTransBO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			mmsUtil = new MmsConfigUtil(strHospitalCode);

			String strStoreId = (String) request.getParameter("storeId");
			String strItemCategoryId = (String) request.getParameter("strCategoryId");

			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryId(strItemCategoryId);
			vo.setStrHospitalCode(strHospitalCode);
//			vo.setStrFinancialStartYear(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
//			vo.setStrFinancialEndYear(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));

			vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
			vo.setStrFinancialEndYear((String) request.getParameter("endDate"));
			
			
			vo.setStrMode("4");
			bo.getGiftedItemList(vo);

			formBean.setWsGiftedItemList(vo.getWsGiftedItemList());

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

			String strTemp = GiftedItemDetailsTransHLP.getGiftedItemsList_NEW(formBean);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strTemp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->getGiftedItemList()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : " + eObj.getErrorID()
						+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				e.printStackTrace();
			}

			eObj = null;
		} finally {
			vo = null;
			bo = null;
			mmsUtil = null;
		}
	}

	public static void initialAdd(GiftedItemDetailsTransFB formBean, HttpServletRequest request) {

		GiftedItemDetailsTransBO bo = null;
		GiftedItemDetailsTransVO vo = null;

		String strmsgText = "";
		HisUtil hisutil = null;
		String ItemCmb = "";

		try {
			bo = new GiftedItemDetailsTransBO();
			vo = new GiftedItemDetailsTransVO();
			hisutil = new HisUtil("mms", "GiftedItemDetailsTransDATA");

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String[] strTempVal = formBean.getStrItemCategoryId().replace("^", "#").split("#");

			String strItemCategoryId = strTempVal[0];
			String strWarrantyFlag = strTempVal[1];
			String strInstallFlag = strTempVal[2];

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCategoryNo(strItemCategoryId);

			formBean.setStrDefaultCurrencyCode(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			formBean.setStrItemCategoryNo(strItemCategoryId);
			formBean.setStrWarrantyFlag(strWarrantyFlag);
			formBean.setStrInstallFlag(strInstallFlag);

			MmsConfigUtil mmscofigutil = new MmsConfigUtil(hosCode);
			formBean.setStrIssueRateConfigFlg(mmscofigutil.getStrIssueRateConfigFlg());
			formBean.setStrConfigIssueRate(mmscofigutil.getStrConfigIssueRate());
//			System.out.println("GiftedItemDetailsTransDATA.initADD().ISSUE FLG:::::"+mmscofigutil.getStrIssueRateConfigFlg());
//			System.out.println("GiftedItemDetailsTransDATA.initADD().ISSUE RATE:::::"+mmscofigutil.getStrConfigIssueRate());

			bo.initialAdd(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStrGroupComboWs() != null && vo.getStrGroupComboWs().size() > 0) {

				ItemCmb = hisutil.getOptionValue(vo.getStrGroupComboWs(), "0", "0^Select Value", true);

			} else {
				ItemCmb = "<option value='0'>Select Value</option>";

			}

			formBean.setStrGroupCombo(ItemCmb);

			if (vo.getStrManufactureComboWS() != null && vo.getStrManufactureComboWS().size() > 0) {

				ItemCmb = hisutil.getOptionValue(vo.getStrManufactureComboWS(), "0", "0^Select Value", true);

			} else {
				ItemCmb = "<option value='0'>Select Value</option>";

			}

			formBean.setStrSuppliedByValues(ItemCmb);

			if (vo.getStrCurrencyCodeWs() != null && vo.getStrCurrencyCodeWs().size() > 0) {
				ItemCmb = hisutil.getOptionValue(vo.getStrCurrencyCodeWs(), MmsConfigUtil.DEFAULT_CURRENCY_CODE,
						"0^Select Value", true);

			} else {
				ItemCmb = "<option value='0'>Select Value</option>";

			}

			formBean.setStrCurrencyCodeValues(ItemCmb);

			if (vo.getStrStockStatusWs() != null && vo.getStrStockStatusWs().size() > 0) {
				ItemCmb = hisutil.getOptionValue(vo.getStrStockStatusWs(), "10", "", true);

			} else {
				ItemCmb = "<option value='0'>Select Value</option>";

			}

			formBean.setStrStockStatusValues(ItemCmb);

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = "Gifted Item Inventory.GiftedItemDetailsTransDATA.initialAdd(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->initialAdd()", strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	public static void getSubGroupList(GiftedItemDetailsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		String strmsgText = "";
		GiftedItemDetailsTransBO bo = null;
		GiftedItemDetailsTransVO vo = null;
		HisUtil hisutil = null;
		try {

			bo = new GiftedItemDetailsTransBO();
			vo = new GiftedItemDetailsTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			String strGroupId = (String) request.getParameter("GroupId");

			vo.setStrHospitalCode(strHospitalCode);

			vo.setStrGroupId(strGroupId);

			bo.getSubGroupList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "GiftedItemDetailsTransDATA");

			String cmbstr = "<option value='0'>All</option>";

			if (vo.getStrSubGroupComboWs() != null && vo.getStrSubGroupComboWs().size() > 0) {

				cmbstr = hisutil.getOptionValue(vo.getStrSubGroupComboWs(), vo.getStrItemId(), "0^All", false);

			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = "DrugInventory.GiftedItemDetailsTransDATA.getSubGroupList(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->getSubGroupList()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : " + eObj.getErrorID()
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
	 * To get values of SubgroupCombo
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void itemName(GiftedItemDetailsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		String strmsgText = "";
		GiftedItemDetailsTransBO bo = null;
		GiftedItemDetailsTransVO vo = null;
		HisUtil hisutil = null;
		try {

			bo = new GiftedItemDetailsTransBO();
			vo = new GiftedItemDetailsTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();

			String subGroupId = (String) request.getParameter("strSubGroupId");
			String strGroupId = (String) request.getParameter("GroupId");
			String strStoreId = (String) request.getParameter("storeId");
			String strItemCatNo = (String) request.getParameter("catCode");

			if (subGroupId == null)
				subGroupId = "0";

			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo(strItemCatNo);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			vo.setStrSubGroupId(subGroupId);
			vo.setStrGroupId(strGroupId);

			bo.getItemName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "GiftedItemDetailsTransDATA");
			String cmbstr = hisutil.getOptionValue(vo.getStrItemNameComboWS(), vo.getStrItemId(), "0^Select Value",
					false);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = "DrugInventory.GiftedItemDetailsTransDATA.itemName(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->itemName()", strmsgText);
			try {

				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : " + eObj.getErrorID()
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

	public static void itemBrandName(GiftedItemDetailsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		String strmsgText = "";
		GiftedItemDetailsTransBO bo = null;
		GiftedItemDetailsTransVO vo = null;

		try {

			bo = new GiftedItemDetailsTransBO();
			vo = new GiftedItemDetailsTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();
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

			HisUtil hisutil = new HisUtil("mms", "GiftedItemDetailsTransDATA");
			String cmbstr = hisutil.getOptionValue(vo.getStrItemBrandComboWS(), vo.getStrItemBrandId(),
					"0^Select Value", false);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "DrugInventory.GiftedItemDetailsTransDATA.itemBrandName(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->itemBrandName()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : " + eObj.getErrorID()
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

	public static void getBrandDetails(GiftedItemDetailsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		GiftedItemDetailsTransBO bo = null;
		GiftedItemDetailsTransVO vo = null;
		HisUtil hisutil = null;
		String ItemCmb = "";
		try {

			bo = new GiftedItemDetailsTransBO();
			vo = new GiftedItemDetailsTransVO();
			hisutil = new HisUtil("mms", "GiftedItemDetailsTransDATA");

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			String strItemBrandId = (String) request.getParameter("strItemBrandId");

			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrHospitalCode(strHospitalCode);

			vo.setStrItemCategoryNo("10");// formBean.getStrItemCategoryNo()

			bo.getBrandDetails(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			String strBrandDetails = vo.getStrRegFlag() + "^" + vo.getStrBrandDetails();

			if (vo.getStrStockStatusWs() != null && vo.getStrStockStatusWs().size() > 0) {
				ItemCmb = hisutil.getOptionValue(vo.getStrStockStatusWs(), "0", "0^Select Value", true);

			} else {
				ItemCmb = "<option value='0'>Select Value</option>";

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strBrandDetails + "$$" + ItemCmb);

		} catch (Exception e) {

			e.printStackTrace();

			String strmsgText = "GiftedItemDetailsTransDATA.getBrandDetails(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->getBrandDetails()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : " + eObj.getErrorID()
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

	public static void manufectuteName(GiftedItemDetailsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		String strmsgText = "";
		GiftedItemDetailsTransBO bo = null;
		GiftedItemDetailsTransVO vo = null;

		try {

			bo = new GiftedItemDetailsTransBO();
			vo = new GiftedItemDetailsTransVO();

			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();

			String strItemBrandId = (String) request.getParameter("strItemBrandId");

			String strCatCode = (String) request.getParameter("strCatCode");

			vo.setStrItemCategoryNo(strCatCode);

			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			bo.getmanufectuteName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			HisUtil hisutil = new HisUtil("mms", "GiftedItemDetailsTransDATA");
			String cmbstr = hisutil.getOptionValue(vo.getStrManufactureComboWS(), vo.getStrManufactureId(),
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

			strmsgText = "DrugInventory.GiftedItemDetailsTransDATA.manufectuteName(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->manufectuteName()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : " + eObj.getErrorID()
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

	public static void insert(GiftedItemDetailsTransFB formBean, HttpServletRequest request, HttpServletResponse response) {
		String strmsgText = "";
		GiftedItemDetailsTransBO bo = null;
		GiftedItemDetailsTransVO vo = null;

		MmsConfigUtil mmsUtil = null;
		String strCurrentDate="";

		try {
			
			bo = new GiftedItemDetailsTransBO();

			vo = (GiftedItemDetailsTransVO) TransferObjectFactory
					.populateData("mms.transactions.vo.GiftedItemDetailsTransVO", formBean);

			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());

			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			vo.setStrInHandQuantityUnitID(formBean.getStrInHandQuantityUnitID().replace("^", "#").split("#")[0]);
			vo.setStrUnitRateID(formBean.getStrUnitRateID().replace("^", "#").split("#")[0]);
			vo.setStrUnitSaleID(formBean.getStrUnitSaleID().replace("^", "#").split("#")[0]);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());

			if (formBean.getStrBatchNo().trim().equals("0") || formBean.getStrBatchNo().trim().length() < 1) {

				vo.setStrBatchNo(mmsUtil.getStrBatchNo());

			}

			vo.setStrFinancialStartYear(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId(), vo.getStrHospitalCode()));
			vo.setStrFinancialEndYear(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId(), vo.getStrHospitalCode()));
			vo.setStrPONumber(formBean.getStrPONumber());
			 AuthenticationCredentials ac = (AuthenticationCredentials) request.getSession().getAttribute(HISSSOConfig.LOGGEDIN_USER_AUTHENTICATION_OBJECT);
			  vo.setRecievedBy(ac.getVarUsrName());
			
			bo.insert(vo);

			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());

			formBean.setStrSerialNo(vo.getStrSerialNo());

			formBean.setStrNormalMsg("Data has been Successfully Saved ");

			formBean.setStrIsWarrantyDetails("0");
			formBean.setStrIsInstallDetails("0");

		} catch (Exception e) {

			strmsgText = "DrugInventory.GiftedItemDetailsTransDATA.insert(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->insert()", strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {

			bo = null;
			vo = null;
			mmsUtil = null;

		}
	}

	/**
	 * To get values of Unit on the basics of Item Name combo
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void unitNameCombo(GiftedItemDetailsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		String strmsgText = "";
		GiftedItemDetailsTransBO bo = null;
		GiftedItemDetailsTransVO vo = null;
		// MmsConfigUtil mcu = null;

		try {

			bo = new GiftedItemDetailsTransBO();
			vo = new GiftedItemDetailsTransVO();
			// mcu = new MmsConfigUtil();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();
			String itemId = (String) request.getParameter("strItemId");
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrItemId(itemId);
			// vo.setStrModuleId(mcu.getStrModuleId());
			vo.setStrModuleId("63");
			bo.unitNameCombo(vo);
			vo.getStrItemNameComboWS();

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			String cmbstr = "";

			HisUtil hisutil = new HisUtil("mms", "GiftedItemDetailsTransDATA");
			if(vo.getStrUnitRateComboWS().size()>0)
			{	
			 cmbstr = hisutil.getOptionValue(vo.getStrUnitRateComboWS(), vo.getStrUnitRateID(), "0^Select Value",false);
			}
			else
			{
				cmbstr = "<option value='6301'>No.</option>";	
			}
			
			String cmbstr1 = "";
			HisUtil hisutil1 = new HisUtil("mms", "GiftedItemDetailsTransDATA"); 
			if(vo.getStrUnitSaleComboWS().size()>0)
			{
			
				cmbstr1 = hisutil1.getOptionValue(vo.getStrUnitSaleComboWS(),vo.getStrUnitSaleID(), "0^Select Value", false);
			}
			else
			{
				cmbstr1 = "<option value='6301'>No.</option>";
			}
			 

			try {
				// System.out.println("cmbstr" + cmbstr);
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);

			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "DrugInventory.GiftedItemDetailsTransDATA.unitNameCombo(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "GiftedItemDetailsTransDATA->unitNameCombo()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : " + eObj.getErrorID()
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

	
	  public static void voucherPrint(GiftedItemDetailsTransFB formBean,
	  HttpServletRequest request, HttpServletResponse response) 
	  { 
		  
	   
	  String strmsgText = ""; 
	  GiftedItemDetailsTransBO bo = null;
	  GiftedItemDetailsTransVO vo = null; 
	  String strResult = "A"; 
	  try {
	  
	  vo = new GiftedItemDetailsTransVO(); 
	  bo = new GiftedItemDetailsTransBO();
	  
	  vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString()); 
	  vo.setStrStoreId(request.getParameter("storeId"));
	  vo.setStrItemCategoryNo(request.getParameter("itemcatno"));
	  vo.setStrSuppliedBy(request.getParameter("supplierid")); 
	  vo.setTransactionNumber(request.getParameter("transactionNumber"));
	  
	  vo.setStrHiddenValue(request.getParameter("strHidVal"));
	  //System.out.println(request.getSession().getAttribute(HISSSOConfig.LOGGEDIN_USER_VO));
	  //System.out.println(request.getSession().getAttribute("keyLoggedInUserAuthenticationObject"));
	 
	  bo.getVoucherDtl(vo); 
	  vo.setStrSuppliedBy(request.getParameter("supplier"));
	  vo.setPono(request.getParameter("pono"));
	  vo.setStrItemCategoryId(request.getParameter("itemCategoryName"));
	  vo.setStrReceivedDate(request.getParameter("voucherDate"));
	  
	  strResult = GiftedItemDetailsTransHLP.getvoucherPrintDetails(vo); 
	  if(strResult != null) 
	  { response.setHeader("Cache-Control", "no-cache");
	  
	  response.getWriter().print(strResult);
	  
	  } 
	  else { 
		  HisException eObj = new HisException("MMS","GiftedItemDetailsTransDATA->voucherprint()", vo.getStrMsgString()); 
		  String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() +"], Contact System Administrator! "; 
		  response.getWriter().print(str); 
		  }
	  
	  } 
	  catch (Exception _err) { strmsgText = _err.getMessage(); HisException eObj
	  = new HisException("MMS", "GiftedItemDetailsTransDATA->voucherprint()",
	  strmsgText); formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : "
	  + eObj.getErrorID() + "], Contact System Administrator! ");
	  
	  eObj = null; }
	  
	  }
	 
}
