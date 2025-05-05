package mms.transactions.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.transactions.controller.fb.GiftedItemDetailsTransFB;

import mms.transactions.controller.fb.ReceiveFromThirdPartyTransTestFB;
import mms.transactions.controller.hlp.ReceiveFromThirdPartyTransTestHLP;
import mms.transactions.vo.ReceiveFromThirdPartyTransTestVO;
import mms.transactions.bo.ReceiveFromThirdPartyTransTestBO;

public class ReceiveFromThirdPartyTransTestDATA {

	/**
	 * This function is used to set initial parameters required to display on
	 * main page
	 * 
	 * @param formBean
	 */
	public static void initialGenAdd(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request) {
		ReceiveFromThirdPartyTransTestVO vo = null;
		ReceiveFromThirdPartyTransTestBO bo = null;
		HisUtil hisutil = null;
		String strCurrentDate;


		try {
			vo = new ReceiveFromThirdPartyTransTestVO();
			bo = new ReceiveFromThirdPartyTransTestBO();

			hisutil = new HisUtil("mms", "ReceiveFromThirdPartyTransTestDATA");

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

			if (vo.getWsStoreNameCombo() != null
					&& vo.getWsStoreNameCombo().size() > 0) {
				if(vo.getWsStoreNameCombo().next())
				{
					vo.setStrStoreId(vo.getWsStoreNameCombo().getString(1));
					vo.getWsStoreNameCombo().beforeFirst();
				}
				temp = hisutil.getOptionValue(vo.getWsStoreNameCombo(), "",
						"", false, false);

			} else {

				temp = "<option value='0'>Select Value</option>";

			}

			formBean.setStrStoreNameCombo(temp);
			bo.getCategoryList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			String cmbstr = "";
			if (vo.getWsItemCategoryCombo() != null	&& vo.getWsItemCategoryCombo().size() > 0) 
			{
				cmbstr = hisutil.getOptionValue(vo.getWsItemCategoryCombo(),"", "", false);

			} else {

				cmbstr = "<option value='0'>Select Value</option>";
			}

			formBean.setStrItemCategoryCombo(cmbstr);
			if (vo.getWsInstituteList() != null	&& vo.getWsInstituteList().size() > 0)
			{
				temp = hisutil.getOptionValue(vo.getWsInstituteList(), "0",	"0^Select Value", true);

			} 
			else 
			{
				temp = "<option value='0'>Select Value</option>";

			}
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			formBean.setStrIssueRateConfigFlg(mmscofigutil.getStrIssueRateConfigFlg());			
			formBean.setStrInstituteValues(temp);
			
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCurrentDate(strCurrentDate);	
			
		} catch (Exception e) {

			e.printStackTrace();
			
			String strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",	"ReceiveFromThirdPartyTransTestDATA->initialGenAdd()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "], Contact System Administrator! ");
			eObj = null;
		} finally {
			if (vo != null)
				vo = null;
			
			hisutil = null;
	
		}
	}
	/**
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getCategoryListTwo(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
		String strmsgText = "";
		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;
	 
		String strTemp =  null;
		try {

			vo = new ReceiveFromThirdPartyTransTestVO();
			bo = new ReceiveFromThirdPartyTransTestBO();
 

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strStatus = (String) request.getParameter("storeId");
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrStatus(strStatus);
			
			
			bo.getReceivedItemListTwo(vo);

			formBean.setWsReceivedItemList(vo.getWsReceivedItemList());

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
						
            if(strStatus.equals("4"))
            {	
			  strTemp = ReceiveFromThirdPartyTransTestHLP.getNewReceivedItemsList(formBean);
            }
            if(strStatus.equals("2"))
            {
              strTemp = ReceiveFromThirdPartyTransTestHLP.getUpdateReceivedItemsList(formBean);	
            }	

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strTemp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->getReceivedItemList()", strmsgText);
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

	public static void getCategoryListTwoNEW(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
		String strmsgText = "";
		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;
	 
		String strTemp =  null;
		try {

			vo = new ReceiveFromThirdPartyTransTestVO();
			bo = new ReceiveFromThirdPartyTransTestBO();
 

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strStatus = (String) request.getParameter("storeId");
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrStatus(strStatus);
			
			
			bo.getReceivedItemListTwo(vo);

			formBean.setWsReceivedItemList(vo.getWsReceivedItemList());

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
						
            if(strStatus.equals("4"))
            {	
			  strTemp = ReceiveFromThirdPartyTransTestHLP.getNewReceivedItemsListNEW(formBean);
            }
            if(strStatus.equals("2"))
            {
              strTemp = ReceiveFromThirdPartyTransTestHLP.getUpdateReceivedItemsList(formBean);	
            }	

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strTemp);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->getReceivedItemList()", strmsgText);
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
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getCategoryListThree(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
		String strmsgText = "";
		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;
		MmsConfigUtil mmsUtil = null;
		String strTemp =  null;
		String strStatus = "";
		try {

			vo = new ReceiveFromThirdPartyTransTestVO();
			bo = new ReceiveFromThirdPartyTransTestBO();

			mmsUtil = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			strStatus = formBean.getStrStatus();
			String[] tmp = formBean.getStrItemCategoryCode().split("\\^");
			
			vo.setStrStatus(formBean.getStrStatus());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCategoryId(tmp[0]);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrFinancialStartYear(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinancialEndYear(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));

			bo.getReceivedItemListThree(vo);

			formBean.setWsReceivedItemList(vo.getWsReceivedItemList());

			if (vo.getStrMsgType().equals("1")) 
			{

				throw new Exception(vo.getStrMsgString());

			}
            if(strStatus.equals("4"))
            {	
			  strTemp = ReceiveFromThirdPartyTransTestHLP.getNewReceivedItemsList(formBean);
            }
            if(strStatus.equals("2"))
            {
              strTemp = ReceiveFromThirdPartyTransTestHLP.getUpdateReceivedItemsList(formBean);	
            }	
            formBean.setStrItemHlp(strTemp);
			

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->getReceivedItemList()", strmsgText);
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
			mmsUtil = null;
		}
	}

	public static void getCategoryListThreeNEW(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request, HttpServletResponse response) 
	{
		String strmsgText = "";
		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;
		MmsConfigUtil mmsUtil = null;
		String strTemp =  null;
		String strStatus = "";
		try {

			vo = new ReceiveFromThirdPartyTransTestVO();
			bo = new ReceiveFromThirdPartyTransTestBO();

			mmsUtil = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			strStatus = formBean.getStrStatus();
			String[] tmp = formBean.getStrItemCategoryCode().split("\\^");
			
			vo.setStrStatus(formBean.getStrStatus());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCategoryId(tmp[0]);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrFinancialStartYear(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			vo.setStrFinancialEndYear(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));

			bo.getReceivedItemListThree(vo);

			formBean.setWsReceivedItemList(vo.getWsReceivedItemList());

			if (vo.getStrMsgType().equals("1")) 
			{

				throw new Exception(vo.getStrMsgString());

			}
            if(strStatus.equals("4"))
            {	
			  strTemp = ReceiveFromThirdPartyTransTestHLP.getNewReceivedItemsListNEW(formBean);
            }
            if(strStatus.equals("2"))
            {
              strTemp = ReceiveFromThirdPartyTransTestHLP.getUpdateReceivedItemsListNEW(formBean);	
            }	
            formBean.setStrItemHlp(strTemp);
			

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->getReceivedItemList()", strmsgText);
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
			mmsUtil = null;
		}
	}
	

	public static void getCategoryList(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;
		HisUtil hisutil = null;
		try {

			vo = new ReceiveFromThirdPartyTransTestVO();
			bo = new ReceiveFromThirdPartyTransTestBO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();

			String strStoreId = (String) request.getParameter("storeId");

			vo.setStrStoreId(strStoreId);
			vo.setStrHospitalCode(strHospitalCode);

			bo.getCategoryList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "ItemInventoryTransDATA");

			String cmbstr = "";

			if (vo.getWsItemCategoryCombo() != null
					&& vo.getWsItemCategoryCombo().size() > 0) {

				cmbstr = hisutil.getOptionValue(vo.getWsItemCategoryCombo(),
						"", "", false);

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
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->getCategoryList()", strmsgText);
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

	public static void getFinancialYear(GiftedItemDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		MmsConfigUtil mmsUtil = null;

		try {
				
			mmsUtil = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();

			String strStoreId = (String) request.getParameter("storeId");

			String strFinYear = "";	
			
					
			if(mmsUtil.getStrFinancialStartDate(strStoreId , strHospitalCode ).length() > 10)
			strFinYear = mmsUtil.getStrFinancialStartDate(strStoreId , strHospitalCode ).substring(7,11) +" - "+mmsUtil.getStrFinancialEndDate(strStoreId , strHospitalCode).substring(7,11);
			
			
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strFinYear);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->getFinancialYear()", strmsgText);
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
			mmsUtil = null;
		}
	}
	

	
	

	public static void initialAdd(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request) {

		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;

		String strmsgText = "";
		HisUtil hisutil = null;
		String ItemCmb = "";
		String strItemBrandCombo = "";

		try {
			bo = new ReceiveFromThirdPartyTransTestBO();
			vo = new ReceiveFromThirdPartyTransTestVO();
			hisutil = new HisUtil("mms", "ReceiveFromThirdPartyTransTestDATA");

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String[] strTempVal = formBean.getStrItemCategoryId().replace("^","#").split("#");

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
			
			if(formBean.getStrInstituteId().equals("108") && strItemCategoryId.equals("10")) // 108 for local purchase 
				vo.setStrLpFlagMode("8");	
			else
				vo.setStrLpFlagMode("1");
			
			bo.initialAdd(vo);
			
			bo.getItemBrandName(vo); // PKG_MMS_VIEW.proc_storeitem_list [ Mode - 2 ]
			
			

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getStrItemBrandComboWS() != null	&& vo.getStrItemBrandComboWS().size() > 0) 
			{

				strItemBrandCombo = hisutil.getOptionValue(vo.getStrItemBrandComboWS(),vo.getStrItemBrandId(), "0^Select Value", false);

			} 
			else 
			{
				strItemBrandCombo = "<option value='0'>Select Value</option>";

			}			
			formBean.setStrItemBrandCombo(strItemBrandCombo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStrGroupComboWs() != null
					&& vo.getStrGroupComboWs().size() > 0) {

				ItemCmb = hisutil.getOptionValue(vo.getStrGroupComboWs(), "0","0^All", true);

			} else {
				ItemCmb = "<option value='0'>Select Value</option>";

			}

			formBean.setStrGroupCombo(ItemCmb);

			if (vo.getStrManufactureComboWS() != null
					&& vo.getStrManufactureComboWS().size() > 0) {

				ItemCmb = hisutil.getOptionValue(vo.getStrManufactureComboWS(),	"0", "0^Select Value", true);

			} else {
				ItemCmb = "<option value='0'>Select Value</option>";

			}

			formBean.setStrSuppliedByValues(ItemCmb);

			if (vo.getStrCurrencyCodeWs() != null
					&& vo.getStrCurrencyCodeWs().size() > 0) {
				ItemCmb = hisutil.getOptionValue(vo.getStrCurrencyCodeWs(),
						MmsConfigUtil.DEFAULT_CURRENCY_CODE, "0^Select Value",
						true);

			} else {
				ItemCmb = "<option value='0'>Select Value</option>";

			}

			formBean.setStrCurrencyCodeValues(ItemCmb);

			if (vo.getStrStockStatusWs() != null
					&& vo.getStrStockStatusWs().size() > 0) {
				ItemCmb = hisutil.getOptionValue(vo.getStrStockStatusWs(), "10",
						"0^Select Value", true);

			} else {
				ItemCmb = "<option value='0'>Select Value</option>";

			}
			
			
			formBean.setStrStockStatusValues(ItemCmb);
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());	
			formBean.setStrIssueRateConfigFlg(mmscofigutil.getStrIssueRateConfigFlg());
			formBean.setStrConfigIssueRate(mmscofigutil.getStrConfigIssueRate());
			
			
		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = "Gifted Item Inventory.ReceiveFromThirdPartyTransTestDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->initialAdd()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	public static void getSubGroupList(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;
		HisUtil hisutil = null;
		try {

			bo = new ReceiveFromThirdPartyTransTestBO();
			vo = new ReceiveFromThirdPartyTransTestVO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();

			String strGroupId = (String) request.getParameter("GroupId");

			vo.setStrHospitalCode(strHospitalCode);

			vo.setStrGroupId(strGroupId);

			bo.getSubGroupList(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "ReceiveFromThirdPartyTransTestDATA");

			String cmbstr = "<option value='0'>All</option>";

			if (vo.getStrSubGroupComboWs() != null
					&& vo.getStrSubGroupComboWs().size() > 0) {

				cmbstr = hisutil.getOptionValue(vo.getStrSubGroupComboWs(), vo
						.getStrItemId(), "0^All", false);

			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = "DrugInventory.ReceiveFromThirdPartyTransTestDATA.getSubGroupList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->getSubGroupList()", strmsgText);
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
	 * To get values of SubgroupCombo
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void itemName(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;
		HisUtil hisutil = null;
		try {

			bo = new ReceiveFromThirdPartyTransTestBO();
			vo = new ReceiveFromThirdPartyTransTestVO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();

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

			hisutil = new HisUtil("mms", "ReceiveFromThirdPartyTransTestDATA");
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

			strmsgText = "DrugInventory.ReceiveFromThirdPartyTransTestDATA.itemName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->itemName()", strmsgText);
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

	public static void itemBrandName(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;

		try {

			bo = new ReceiveFromThirdPartyTransTestBO();
			vo = new ReceiveFromThirdPartyTransTestVO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();
			String itemId = (String) request.getParameter("strItemId");
			String strStoreId = (String) request.getParameter("storeId");
			String strGroupId = (String) request.getParameter("strGroupId");
			String strSubGroupId = (String) request
					.getParameter("strSubGroupId");
			String strCategoryCode = (String) request
					.getParameter("strCatCode");

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

			HisUtil hisutil = new HisUtil("mms", "ReceiveFromThirdPartyTransTestDATA");
			String cmbstr = hisutil.getOptionValue(vo.getStrItemBrandComboWS(),
					vo.getStrItemBrandId(), "0^Select Value", false);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "DrugInventory.ReceiveFromThirdPartyTransTestDATA.itemBrandName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->itemBrandName()", strmsgText);
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

	public static void getBrandDetails(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;
		HisUtil hisutil = null;
		String ItemCmb = "";

		try {

			bo = new ReceiveFromThirdPartyTransTestBO();
			vo = new ReceiveFromThirdPartyTransTestVO();
			hisutil = new HisUtil("mms", "ReceiveFromThirdPartyTransTestDATA");
			 
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			  
			String strItemBrandId = (String) request.getParameter("strItemBrandId");

			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrHospitalCode(strHospitalCode);
		 
			vo.setStrItemCategoryNo("10");//formBean.getStrItemCategoryNo()
			
			bo.getBrandDetails(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			String strBrandDetails = vo.getStrRegFlag()+"^"+vo.getStrBrandDetails(); 
		  
			if (vo.getStrStockStatusWs() != null && vo.getStrStockStatusWs().size() > 0) 
			{
				ItemCmb = hisutil.getOptionValue(vo.getStrStockStatusWs(),	"0", "0^Select Value",	true);

			} else {
				ItemCmb = "<option value='0'>Select Value</option>";

			}

			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strBrandDetails+"$$"+ItemCmb);
			
			
		 
		} catch (Exception e) {

			e.printStackTrace();

			String strmsgText = "ReceiveFromThirdPartyTransTestDATA.getBrandDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->getBrandDetails()", strmsgText);
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

	public static void manufectuteName(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;

		try {

			bo = new ReceiveFromThirdPartyTransTestBO();
			vo = new ReceiveFromThirdPartyTransTestVO();

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

			HisUtil hisutil = new HisUtil("mms", "ReceiveFromThirdPartyTransTestDATA");
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

			strmsgText = "DrugInventory.ReceiveFromThirdPartyTransTestDATA.manufectuteName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->manufectuteName()", strmsgText);
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

	public static void insert(ReceiveFromThirdPartyTransTestFB formBean) {
		String strmsgText = "";
		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;

		MmsConfigUtil mmsUtil = null;

		try {
			bo = new ReceiveFromThirdPartyTransTestBO();

			vo = (ReceiveFromThirdPartyTransTestVO) TransferObjectFactory.populateData("mms.transactions.vo.ReceiveFromThirdPartyTransTestVO",formBean);
System.out.println("formBean.getStrHospitalCode()"+formBean.getStrHospitalCode());

			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
System.out.println("formBean.getStrHospitalCode()"+formBean.getStrHospitalCode());
			vo.setStrInHandQuantityUnitID(formBean.getStrInHandQuantityUnitID()
					.replace("^", "#").split("#")[0]);
			vo.setStrUnitRateID(formBean.getStrUnitRateID().replace("^", "#")
					.split("#")[0]);
			vo.setStrUnitSaleID(formBean.getStrUnitSaleID().replace("^", "#")
					.split("#")[0]);
			vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
			
			vo.setStrGstTax(formBean.getStrGstTax());
			vo.setStrRatewithGst(formBean.getStrRatewithGst());
			vo.setStrAdminTax(formBean.getStrAdminTax());
			
			System.out.println("vo.setStrGstTax(formBean.getStrGstTax());"+formBean.getStrGstTax());
			System.out.println("vo.setStrRatewithGst(formBean.getStrRatewithGst());"+formBean.getStrRatewithGst());
			System.out.println("vo.setStrAdminTax(formBean.getStrAdminTax());"+formBean.getStrAdminTax());

			if (formBean.getStrBatchNo().trim().equals("0")|| formBean.getStrBatchNo().trim().length() < 1) {
				vo.setStrBatchNo(mmsUtil.getStrBatchNo());
			}

			//vo.setStrFinancialStartYear(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
			//vo.setStrFinancialEndYear(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
            //vo.setStrReceivedFromThirdPartyName(formBean.getStrReceivedFromThirdPartyName());
			System.out.println("vo.setStrAdminTax(formBean.getStrAdminTax());"+formBean.getStrReceivedFromThirdPartyName());

			bo.insert(vo);

			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());

			formBean.setStrSerialNo(vo.getStrSerialNo());

			formBean.setStrNormalMsg("Data has been Successfully Saved !!");

			formBean.setStrIsWarrantyDetails("0");
			formBean.setStrIsInstallDetails("0");
			
		} catch (Exception e) {

			strmsgText = "DrugInventory.ReceiveFromThirdPartyTransTestDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->insertRecord()", strmsgText);
			formBean.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

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

	public static void unitNameCombo(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;
		String strItemCategoryNo="";
		// MmsConfigUtil mcu = null;

		try {

			bo = new ReceiveFromThirdPartyTransTestBO();
			vo = new ReceiveFromThirdPartyTransTestVO();
			// mcu = new MmsConfigUtil();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();
			String itemId = (String) request.getParameter("strItemId");
			strItemCategoryNo=request.getParameter("itemCategNo");
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrItemId(itemId);
			vo.setStrItemCategoryNo(strItemCategoryNo);
			// vo.setStrModuleId(mcu.getStrModuleId());
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
			bo.unitNameCombo(vo);
			vo.getStrItemNameComboWS();

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			HisUtil hisutil = new HisUtil("mms", "ReceiveFromThirdPartyTransTestDATA");
			String cmbstr = hisutil.getOptionValue(vo.getStrUnitRateComboWS(),vo.getStrUnitRateID(), "", false);

			/*
			 * HisUtil hisutil1 = new HisUtil("mms",
			 * "ReceiveFromThirdPartyTransTestDATA"); String cmbstr1 =
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
			strmsgText = "DrugInventory.ReceiveFromThirdPartyTransTestDATA.unitNameCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->unitNameCombo()", strmsgText);
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
	
	public static void getReceivedItemList(ReceiveFromThirdPartyTransTestFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ReceiveFromThirdPartyTransTestBO bo = null;
		ReceiveFromThirdPartyTransTestVO vo = null;
		MmsConfigUtil mmsUtil = null;
		try {

			vo = new ReceiveFromThirdPartyTransTestVO();
			bo = new ReceiveFromThirdPartyTransTestBO();

			mmsUtil = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			String strStoreId = (String) request.getParameter("storeId");
			String strItemCategoryId = (String) request.getParameter("strCategoryId");
			String strStoreName = (String) request.getParameter("storeName");
			String strItemCategoryName = (String) request.getParameter("categoryName");
			
			System.out.println("strStoreName"+strStoreName);
			System.out.println("strItemCategoryName"+strItemCategoryName);
			
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryId(strItemCategoryId);
			
			vo.setStrStoreName(strStoreName);
			vo.setStrItemCategoryNo(strItemCategoryName);
			
			vo.setStrHospitalCode(strHospitalCode);
//			vo.setStrFinancialStartYear(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
//			vo.setStrFinancialEndYear(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));

			vo.setStrFinancialStartYear((String) request.getParameter("startDate"));
			vo.setStrFinancialEndYear((String) request.getParameter("endDate"));
			
			vo.setStrMode("4");			
			
			bo.getImgHeader(vo);

			bo.getReceivedItemList(vo);

			formBean.setWsReceivedItemList(vo.getWsReceivedItemList());

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

			String strTemp = ReceiveFromThirdPartyTransTestHLP.getReceivedItemsList(formBean,vo);

			try
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strTemp);
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}

		} 
		catch (Exception e) 
		{

			e.printStackTrace();

			strmsgText = e.getMessage();
			HisException eObj = new HisException("mms",
					"ReceiveFromThirdPartyTransTestDATA->getReceivedItemList()", strmsgText);
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
			mmsUtil = null;
		}
	}
	
	
	public static void printVoucherDtl(ReceiveFromThirdPartyTransTestFB fb, HttpServletRequest request, HttpServletResponse response) {
			
		ReceiveFromThirdPartyTransTestBO bo    = null;
		ReceiveFromThirdPartyTransTestVO vo    = null;			
			
			String strmsgText  = null;			
		
			  String strStoreId = ""; 
			  String strStoreName = ""; 
	
			  String strCategoryId = ""; 
			  String strCategoryNo = ""; 
	
			  String hosCode =""; 
			  String strResult=""; 
			  String startDate=""; 
			  String endDate="";
			  String receiveNo="";
			  HisUtil util = null;

		
			try 
			{
				   System.out.println(" ------- ReceiveFromThirdPartyTransTestDATA.printVoucherDtl  ---- pkg_mms_view.proc_receivedItem_dtl_individual [ Mode - 1 ]--- ");
				 
					util = new HisUtil("MMS Transactions", "ReceiveFromThirdPartyTransTestDATA");
				   	
				   	fb.setStrCurrentDate(util.getASDate("dd-MMM-yyyy  hh:mm"));	
				   
				   bo = new ReceiveFromThirdPartyTransTestBO();
				   vo = new ReceiveFromThirdPartyTransTestVO();	
				   
				   hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
				   strStoreId = request.getParameter("storeId");
				   strStoreName = request.getParameter("storeName");
	
				   strCategoryId = request.getParameter("categoryId");
				   strCategoryNo = request.getParameter("categoryNo");
				   
				   startDate =  request.getParameter("startDate");
				   endDate =    request.getParameter("endDate");
				   receiveNo =    request.getParameter("receiveNo");
	
				   
				   vo.setStrHospitalCode(hosCode);
				   vo.setStrStoreId(strStoreId);
				   vo.setStrStoreName(strStoreName);
	
				   vo.setStrItemCategoryId(strCategoryId);
				   vo.setStrItemCategoryNo(strCategoryNo);
	
				   vo.setStrFinancialStartYear(startDate);
				   vo.setStrFinancialEndYear(endDate);
				   vo.setReceiveNo(receiveNo);
					
				   vo.setStrMode("1");
				   bo.getReceivedItemListIndividual(vo); //pkg_mms_view.proc_receivedItem_dtl_individual
	
				 
				   strResult=ReceiveFromThirdPartyTransTestHLP.getvoucherPrintDetails(fb,vo);
				   
					if (vo.getStrMsgType().equals("1")) 
					{
						throw new Exception(vo.getStrMsgString());
					}	
			
				    response.setHeader("Cache-Control", "no-cache");
				    response.getWriter().print(strResult);	
							
			} catch (Exception e) 
			{
				e.printStackTrace();
				strmsgText = "mms.transactions.ReturnAgainstIssuedRPTDATA.getIssueVoucherDtl --> " + e.getMessage();
				
				HisException eObj = new HisException("mms",
						"ReturnAgainstIssuedRPTDATA->getIssueVoucherDtl()", strmsgText);
				fb.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");
				eObj = null;
			} finally {
			
				if (bo != null)
					bo = null;
				if (vo != null)
					vo = null;
				
			}
	  }
	
}
