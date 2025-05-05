package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.DrugInventoryTransBO;
import mms.transactions.controller.fb.DrugInventoryTransFB;
import mms.transactions.vo.DrugInventoryTransVO;

/**
 * 
 * Developer : Amit Kr
 * Version : 1.0 
 * Date : 20-May-2009
 * 
 */
public class DrugInventoryTransDATA {

	/**
	 * to display the Store Name and Group Name on Add page
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void initialAdd(DrugInventoryTransFB formBean,
			HttpServletRequest request) {

		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String SubGroupCmb = "";
		
		String ItemCmb = "";
		String strTemp = "";

		try {
			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();
			

			hisutil = new HisUtil("mms", "DrugInventoryTransDATA");
			
			
			if (!formBean.getComboValue().equals("")) 
			{
				////System.out.println("check value"+formBean.getComboValue());
				String strCmbNames = formBean.getComboValue();
				String[] temp = strCmbNames.replace("^", "#").split("#");
				formBean.setStrStoreName(temp[0]);
				formBean.setStrGroupName(temp[1]);
			

			}

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strStoreId = formBean.getCombo()[0];
			String strGroupId = formBean.getCombo()[1];
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);
			vo.setStrGroupId(strGroupId);

			vo.setStrItemCategoryNo("10");

			formBean.setStrGroupId(strGroupId);
			formBean.setStrDefaultCurrencyCode(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
			bo.initialAdd(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			
			formBean.setStrGroupNameCombo(vo.getStrGroupNameCombo());
			
			
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
           			
			if (vo.getStrStockStatusWs().size() == 0
					|| vo.getStrStockStatusWs() == null) {
				strTemp = "<option value='0'>Select Value</option>";
			} else {
				strTemp = hisutil.getOptionValue(vo.getStrStockStatusWs(),
						"10", "0^Select Value", true);

			}

			formBean.setStrStockStatusValues(strTemp);
			
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(hosCode);	
			formBean.setStrIssueRateConfigFlg(mmscofigutil.getStrIssueRateConfigFlg());
			formBean.setStrConfigIssueRate(mmscofigutil.getStrConfigIssueRate());
			////System.out.println("Issue Rate::::"+mmscofigutil.getStrConfigIssueRate());
			
			formBean.setStrCurrencyCodeValues(ItemCmb);
			
			
			
			

		} 
		catch (Exception e) 
		{
           
			strmsgText = "Drug Inventory.DrugInventoryTransDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->initialAdd()", strmsgText);
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
	 * to display the Store Name and Group Name on Add page
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void initialAddDummy(DrugInventoryTransFB formBean,HttpServletRequest request) 
	{

		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String ItemCmb = "";
		
		try 
		{
			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();
			

			hisutil = new HisUtil("mms", "DrugInventoryTransDATA");
			
			
			if (!formBean.getComboValue().equals("")) 
			{
				String strCmbNames = formBean.getComboValue();
				String[] temp = strCmbNames.replace("^", "#").split("#");
				formBean.setStrStoreName(temp[0]);
				formBean.setStrGroupName(temp[1]);
			

			}

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strStoreId = formBean.getCombo()[0];
			String strGroupId = formBean.getCombo()[1];
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);
			vo.setStrGroupId(strGroupId);

			vo.setStrItemCategoryNo("10");

			formBean.setStrGroupId(strGroupId);
			formBean.setStrDefaultCurrencyCode(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
			bo.initialAddDummy(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			
			
			if (vo.getStrItemNameComboWS().size() == 0
					|| vo.getStrItemNameComboWS() == null) {
				ItemCmb = "<option value='0'>Select Value</option>";
			} else {
				ItemCmb = hisutil.getOptionValue(vo.getStrItemNameComboWS(),
						"0", "0^Select Value", true);

			}
			formBean.setStrItemBrandCombo(ItemCmb);
			

		} 
		catch (Exception e) 
		{
           e.printStackTrace();
			strmsgText = "Drug Inventory.DrugInventoryTransDATA.initialAddDummy(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->initialAdd()", strmsgText);
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

	public static void itemName(DrugInventoryTransFB formBean,HttpServletRequest request, HttpServletResponse response)
	{

		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;
		HisUtil hisutil = null;
		try 
		{

			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();

			String subGroupId = (String) request.getParameter("strSubGroupId");
			String strGroupId = (String) request.getParameter("GroupId");
			String strStoreId = (String) request.getParameter("storeId");
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrSubGroupId(subGroupId);
			vo.setStrGroupId(strGroupId);

			bo.getItemName(vo);
			vo.getStrItemNameComboWS();

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			 hisutil = new HisUtil("mms", "DrugInventoryTransDATA");
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

			strmsgText = "DrugInventory.DrugInventoryTransDATA.itemName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->itemName()", strmsgText);
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

	public static void subGroupCombo(DrugInventoryTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;
		HisUtil hisutil = null;
		try {

			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			String strSeatId = request.getSession().getAttribute("SEATID").toString();			
			String strGroupId = (String) request.getParameter("GroupId");
			String strStoreId = (String) request.getParameter("storeId");
			
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrGroupId(strGroupId);

			bo.subGrpAndItemCmb(vo);
			

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "DrugInventoryTransDATA");
			
			String  subGrpCmbStr = hisutil.getOptionValue(vo.getStrSubGroupComboWs(),"0", "0^Select Value", false);
			String    itemCmbStr = hisutil.getOptionValue(vo.getStrItemNameComboWS(),"0", "0^Select Value", false);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(subGrpCmbStr+"@@"+itemCmbStr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = "DrugInventory.DrugInventoryTransDATA.subGroupCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->itemName()", strmsgText);
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
	 * To get values of Existing Batch Number 
	 * for Selected Drug
	 * @param formBean
	 * @param request
	 */

	public static void getGroupName(DrugInventoryTransFB formBean,HttpServletRequest request, HttpServletResponse response)
	{

		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;

		try 
		{
			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId       = request.getSession().getAttribute("SEATID").toString();
			String itemId          = (String) request.getParameter("strItemId");
						
			
			vo.setStrItemCategoryNo("10");
									
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrItemId(itemId);

			bo.getGroupId(vo);
			
			
			String cmbstr = vo.getStrGroupId()+"@@"+vo.getStrGroupName() ;

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = "DrugInventory.DrugInventoryTransDATA.getExistingBatchList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->getExistingBatchList()", strmsgText);
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
	 * To get values of Existing Batch Number In Stock Before Save
	 * for Selected Drug
	 * @param formBean
	 * @param request
	 */

	public static void getExistingBatchInStock(DrugInventoryTransFB formBean,HttpServletRequest request, HttpServletResponse response)
	{

		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;

		try 
		{
			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId       = request.getSession().getAttribute("SEATID").toString();
			String itemId          = (String) request.getParameter("strItemId");
			String strStoreId      = (String) request.getParameter("storeId");
			String strItemBrandId  = (String) request.getParameter("strItemBrandId");
			String strGroupId      = (String) request.getParameter("strGroupId");
			String strBatchNo      = (String) request.getParameter("strBatchNo");
			
			
			
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");
			vo.setStrItemBrandId(strItemBrandId);
						
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrItemId(itemId);
			vo.setStrGroupId(strGroupId);
            vo.setStrBatchNo(strBatchNo);
			bo.getExistingBatchInStock(vo);
			
			formBean.setStrBatchExistInStockFlg(vo.getStrBatchExistInStockFlg());
			

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
		
			String cmbstr = formBean.getStrBatchExistInStockFlg();

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = "DrugInventory.DrugInventoryTransDATA.getExistingBatchInStock(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->getExistingBatchInStock()", strmsgText);
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
	 * To get values of Existing Batch Number 
	 * for Selected Drug
	 * @param formBean
	 * @param request
	 */

	public static void getExistingBatchList(DrugInventoryTransFB formBean,HttpServletRequest request, HttpServletResponse response)
	{

		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;

		try 
		{
			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId       = request.getSession().getAttribute("SEATID").toString();
			String itemId          = (String) request.getParameter("strItemId");
			String strStoreId      = (String) request.getParameter("storeId");
			String strItemBrandId  = (String) request.getParameter("strItemBrandId");
			
			
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");
			vo.setStrItemBrandId(strItemBrandId);
						
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrItemId(itemId);
			
			vo.setStrMode("2");
			
			bo.getExistingBatchList(vo);
			
			vo.getStrExistingBatchComboWS();

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			HisUtil hisutil = new HisUtil("mms", "DrugInventoryTransDATA");
			String cmbstr = hisutil.getOptionValue(vo.getStrExistingBatchComboWS(),"", "0^New Batch", false);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = "DrugInventory.DrugInventoryTransDATA.getExistingBatchList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->getExistingBatchList()", strmsgText);
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
	 * To get values of Existing Batch Number 
	 * for Selected Drug
	 * @param formBean
	 * @param request
	 */

	public static void getExistingBatchDetails(DrugInventoryTransFB formBean,HttpServletRequest request, HttpServletResponse response)
	{

		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;
		String cmbstr;

		try 
		{
			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();

			String strHospitalCode     = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId           = request.getSession().getAttribute("SEATID").toString();
			String itemId              = (String) request.getParameter("strItemId");
			String strStoreId          = (String) request.getParameter("storeId");
			String strItemBrandId      = (String) request.getParameter("strItemBrandId");
			String strExistingBatchId  = (String) request.getParameter("strExistingBatchId");
			
			
			
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");
			vo.setStrStockStatus("10");
			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrBatchNo(strExistingBatchId);			
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrItemId(itemId);

			bo.getExistingBatchDetails(vo);
			
			cmbstr = vo.getStrStoreName()+"^"+vo.getStrGroupName()+"^"+vo.getStrSubGroupName()+"^"+vo.getStrItemName()+"^"+	vo.getStrItemBrandName()+"^" +
					""+vo.getStrManufactureName()+"^"+vo.getStrBatchNo()+"^"+vo.getStrExpiryDate()+"^" +
					""+vo.getStrManufactureDate()+"^"+vo.getStrInHandQuantity()+"^"+vo.getStrInHandQuantityUnitName()+"^"+vo.getStrInHandQuantityUnitID()+"^" +
					""+vo.getStrRate()+"^"+vo.getStrUnitRateName()+"^"+vo.getStrUnitRateID()+"^"+vo.getStrSalePrice()+"^" +
					""+vo.getStrUnitNameSale()+"^"+vo.getStrUnitSaleID()+"^"+vo.getStrPoNo()+"^"+vo.getStrPoDate()+"^"+vo.getStrSuppliedBy()+"^" +
					""+vo.getStrReceivedDate()+"^"+vo.getStrCurrencyCode()+"^"+vo.getStrCurrencyValue()+"^"+vo.getStrBillNo()+"^" +
					""+vo.getStrBillDate()+"^"+vo.getStrItemSpecification()+"^"+vo.getStrManufactureId()+"^"+vo.getStrRackNumber();
			 //   1              2          3            4            5                 6             7            8             9
		     // Store Name + Grp Name +Sub Grp Name + Item name + Item Brand Name + Supplier Name + Batch No +  Expiry Date + Manu Factrer Date
			 //   10            11                        12                 13       14              15               16          17                  
			 // In Hand Qty + In Hand Qty Unit Name + In Hand Qty Unit ID + Rate + Rate Unit Name + Rate Unit Id + Sale Price + Sale Price Unit Name + 
		 	 //    18               19      20          21               22              23            24              25              26                    
			 // Sale Price Unit + Po No + Po Date + Supplied by Id + Received Date + Currency Id +  Currency Value + Invoice No + Invoice Date +
			 //     27               28              29
			 // Specefication  + Manufactrere Id + Rack No

			try 
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = "DrugInventory.DrugInventoryTransDATA.getExistingBatchList(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->getExistingBatchList()", strmsgText);
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
	 * To get values of Item Name Combo
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void itemBrandName(DrugInventoryTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;

		try {

			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();
			String itemId = (String) request.getParameter("strItemId");
			String strStoreId = (String) request.getParameter("storeId");
			String strGroupId = (String) request.getParameter("strGroupId");
			String strSubGroupId = (String) request.getParameter("strSubGroupId");
			
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");
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

			HisUtil hisutil = new HisUtil("mms", "DrugInventoryTransDATA");
			String cmbstr = hisutil.getOptionValue(vo.getStrItemBrandComboWS(),
					vo.getStrItemBrandId(), "0^Select Value", false);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = "DrugInventory.DrugInventoryTransDATA.itemBrandName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->itemBrandName()", strmsgText);
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

	public static void getBrandDetails(DrugInventoryTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;

		try {

			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();

			 
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

			String strBrandDetails = vo.getStrRegFlag()+"^"+vo.getStrBrandDetails()+"^"+vo.getStrQcTypeFlg(); 
			
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strBrandDetails);
		 
		} catch (Exception e) {

			e.printStackTrace();

			String strmsgText = "DrugInventory.DrugInventoryTransDATA.getBrandDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->getBrandDetails()", strmsgText);
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

	public static void manufectuteName(DrugInventoryTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;

		try {

			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();

			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);
			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();

			String strItemBrandId = (String) request
					.getParameter("strItemBrandId");

			String strStoreId = (String) request.getParameter("storeId");

			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");

			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			bo.getmanufectuteName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			HisUtil hisutil = new HisUtil("mms", "DrugInventoryTransDATA");
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

			strmsgText = "DrugInventory.DrugInventoryTransDATA.manufectuteName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->manufectuteName()", strmsgText);
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

	public static void insert2(DrugInventoryTransFB formBean) 
	{
		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;

		try 
		{
			bo = new DrugInventoryTransBO();
			////System.out.println("Existing Batch Details:::::"+formBean.getStrExistingBatchDetails());
            String[] tmp = formBean.getStrExistingBatchDetails().split("\\^");
           
            vo = (DrugInventoryTransVO) TransferObjectFactory.populateData("mms.transactions.vo.DrugInventoryTransVO", formBean);
             /*           
            //System.out.println("Store ID:::"+vo.getStrStoreId());
            //System.out.println("Item ID:::"+vo.getStrItemId());
            //System.out.println("Item Brand ID:::"+vo.getStrItemBrandId());
            //System.out.println("Grp ID:::"+vo.getStrGroupId());
            //System.out.println("Bill No:::"+tmp[24]);
            //System.out.println("Bill Date:::"+tmp[25]);
            */
            vo.setStrBatchNo(tmp[6]);
            vo.setStrItemCategoryNo("10");
            vo.setStrGroupId(formBean.getStrGroupId());
            vo.setStrSubGroupId(formBean.getStrSubGroupId());
            vo.setStrExpiryDate(tmp[7]);
            vo.setStrManufactureDate(tmp[8]);
            vo.setStrStockStatus(formBean.getCombo()[2]);
            vo.setStrInHandQuantity(formBean.getStrInHandQuantity());
            vo.setStrInHandQuantityUnitID(tmp[11]);
            vo.setStrManufactureId(tmp[27]);
            vo.setStrRate(tmp[12]);
            vo.setStrUnitRateID(tmp[14]);
            vo.setStrSalePrice(tmp[15]);
            vo.setStrUnitSaleID(tmp[17]);
            vo.setStrPoNo(tmp[18]);
            vo.setStrPoDate(tmp[19]);
            vo.setStrSuppliedBy(tmp[20]);
            vo.setStrReceivedDate(tmp[21]);
            vo.setStrCurrencyCode(formBean.getStrCurrencyCode());
            vo.setStrCurrencyValue(formBean.getStrCurrencyValue());
            vo.setStrItemSpecification(tmp[26]);
            vo.setStrBillNo(tmp[24]);
            vo.setStrBillDate(tmp[25]);
            vo.setStrRackNumber(tmp[28]);
            vo.setStrDrugTotCost(formBean.getStrDrugTotCost());           
           /* 
             //   1              2          3            4            5                 6             7            8             9
		     // Store Name + Grp Name +Sub Grp Name + Item name + Item Brand Name + Supplier Name + Batch No +  Expiry Date + Manu Factrer Date
			 //   10            11                        12                 13       14              15               16          17                  
			 // In Hand Qty + In Hand Qty Unit Name + In Hand Qty Unit ID + Rate + Rate Unit Name + Rate Unit Id + Sale Price + Sale Price Unit Name + 
		 	 //    18               19      20          21               22              23            24              25              26                    
			 // Sale Price Unit + Po No + Po Date + Supplied by Id + Received Date + Currency Id +  Currency Value + Invoice No + Invoice Date +
			 //     27               28              29
			 // Specefication  + Manufactrere Id + Rack No
			*/
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			
			vo.setStrStockStatus(formBean.getStrStockStatus());

			bo.insert(vo);
			
			if (vo.getStrMsgType().equals("5"))
			{
				formBean.setStrErr(vo.getStrMsgString());
				
			}
			else
			{	
				if (vo.getStrMsgType().equals("1"))
				{
					formBean.setStrErr(vo.getStrMsgString());
					
					throw new Exception(vo.getStrMsgString());
				}
				else
				{	
			       formBean.setStrMsg("Data Has been Successfully Saved");
				}   
			}  

		}
		catch (Exception e) 
		{
			e.printStackTrace();

			strmsgText = "DrugInventory.DrugInventoryTransDATA.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {

			bo = null;
			vo = null;
			

		}
	}

	
	
	/**
	 * to insert the data
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void insert(DrugInventoryTransFB formBean) 
	{
		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;

		MmsConfigUtil mmsUtil = null;

		try 
		{
			bo = new DrugInventoryTransBO();

			vo = (DrugInventoryTransVO) TransferObjectFactory.populateData("mms.transactions.vo.DrugInventoryTransVO", formBean);

			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			            
			vo.setStrInHandQuantityUnitID(formBean.getStrInHandQuantityUnitID().replace("^", "#").split("#")[0]);
			vo.setStrUnitRateID(formBean.getStrUnitRateID().replace("^", "#").split("#")[0]);
			vo.setStrUnitSaleID(formBean.getStrUnitSaleID().replace("^", "#").split("#")[0]);
			vo.setStrItemCategoryNo("10");

			if (formBean.getStrBatchNo().trim().equals("0")|| formBean.getStrBatchNo().trim().length() < 1) 
			{
				vo.setStrBatchNo(mmsUtil.getStrBatchNo());
			}

			vo.setStrStockStatus(formBean.getStrStockStatus());
			////System.out.println("Stock Status==>"+formBean.getStrStockStatus());

			bo.insert(vo);
			
			if (vo.getStrMsgType().equals("5"))
			{
				formBean.setStrErr(vo.getStrMsgString());
				
			}
			else
			{	
				if (vo.getStrMsgType().equals("1"))
				{
					formBean.setStrErr(vo.getStrMsgString());
					
					throw new Exception(vo.getStrMsgString());
				}
				else
				{	
			       formBean.setStrMsg("Data Has been Successfully Saved");
				}   
			}  

		} catch (Exception e) {

			strmsgText = "DrugInventory.DrugInventoryTransDATA.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {

			bo = null;
			vo = null;
			mmsUtil = null;

		}
	}

	
	
	/**
	 * to insert the data
	 * 
	 * @param formBean
	 * @param request
	 */

	public static void dummyinsert(DrugInventoryTransFB formBean) 
	{
		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;


		try 
		{
			bo = new DrugInventoryTransBO();

			vo = (DrugInventoryTransVO) TransferObjectFactory.populateData("mms.transactions.vo.DrugInventoryTransVO", formBean);


			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrItemCategoryNo("10");
			vo.setStrBatchNo(formBean.getStrBatchNo());

			bo.dummyinsert(vo);
			
				if (vo.getStrMsgType().equals("1"))
				{
					formBean.setStrErr(vo.getStrMsgString());
					
					throw new Exception(vo.getStrMsgString());
				}
				else
				{	
			       formBean.setStrMsg("Data Has been Successfully Saved");
				}   
			 

		} catch (Exception e) {

			strmsgText = "DrugInventory.DrugInventoryTransDATA.dummyinsert(vo) --> "+ e.getMessage();
			HisException eObj = new HisException("mms",	"DrugInventoryTransDATA->insertRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {

			bo = null;
			vo = null;

		}
	}
	
	public static void modify(DrugInventoryTransFB formBean) {
		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;
		HisUtil util = null;
		try {
			bo = new DrugInventoryTransBO();

			vo = new DrugInventoryTransVO();

		
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			String[] strValues = formBean.getStrChk().replace("@", "#").split("#");
			
			vo.setStrStoreId(strValues[0]);
			vo.setStrItemId(strValues[1]);
			vo.setStrItemBrandId(strValues[2]);
			vo.setStrBatchNo(strValues[3]);
			vo.setStrStockStatus(strValues[5].replace("$", "#").split("#")[0]);
			
			vo.setStrItemCategoryNo("10");
			
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);
			
			bo.modifyRecord(vo);
            
			String cmbstr = vo.getStrStoreName()+"^"+vo.getStrGroupName()+"^"+vo.getStrSubGroupName()+"^"+vo.getStrItemName()+"^"+	vo.getStrItemBrandName()+"^" +
			""+vo.getStrManufactureName()+"^"+vo.getStrBatchNo()+"^"+vo.getStrExpiryDate()+"^" +
			""+vo.getStrManufactureDate()+"^"+vo.getStrInHandQuantity()+"^"+vo.getStrInHandQuantityUnitName()+"^"+vo.getStrInHandQuantityUnitID()+"^" +
			""+vo.getStrRate()+"^"+vo.getStrUnitRateName()+"^"+vo.getStrUnitRateID()+"^"+vo.getStrSalePrice()+"^" +
			""+vo.getStrUnitNameSale()+"^"+vo.getStrUnitSaleID()+"^"+vo.getStrPoNo()+"^"+vo.getStrPoDate()+"^"+vo.getStrSuppliedBy()+"^" +
			""+vo.getStrReceivedDate()+"^"+vo.getStrCurrencyCode()+"^"+vo.getStrCurrencyValue()+"^"+vo.getStrBillNo()+"^" +
			""+vo.getStrBillDate()+"^"+vo.getStrItemSpecification()+"^"+vo.getStrManufactureId()+"^"+vo.getStrRackNumber();
			
			
			
			TransferObjectFactory.populateData(formBean, vo);
			
			
			util = new HisUtil("mms", "DrugInventoryTransDATA");
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
			
			String ctDate = util.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			formBean.setStrSalesRateUnitValues(strTemp);
			formBean.setStrRackNumber(vo.getStrRackNumber());
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(vo.getStrHospitalCode());	
			formBean.setStrIssueRateConfigFlg(mmscofigutil.getStrIssueRateConfigFlg());
			formBean.setStrConfigIssueRate(mmscofigutil.getStrConfigIssueRate());
			formBean.setStrExistingBatchDetails(cmbstr);
			
						
			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());
			

		} catch (Exception e) {

			strmsgText = "DrugInventory.DrugInventoryTransDATA.modify(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->insertRecord()", strmsgText);
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

	public static void unitNameCombo(DrugInventoryTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;
		// MmsConfigUtil mcu = null;

		try {

			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();
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

			HisUtil hisutil = new HisUtil("mms", "DrugInventoryTransDATA");
			String cmbstr = hisutil.getOptionValue(vo.getStrUnitRateComboWS(),
					vo.getStrUnitRateID(), "0^Select Value", false);

			/*
			 * HisUtil hisutil1 = new HisUtil("mms", "DrugInventoryTransDATA");
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
			strmsgText = "DrugInventory.DrugInventoryTransDATA.unitNameCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->unitNameCombo()", strmsgText);
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

	public static boolean update(DrugInventoryTransFB formBean) {
		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;

		boolean res = false;
		
		try {
			bo = new DrugInventoryTransBO();

			 vo = (DrugInventoryTransVO) TransferObjectFactory.populateData(
					"mms.transactions.vo.DrugInventoryTransVO", formBean);


		
			vo.setStrHospitalCode(formBean.getStrHospitalCode());

			String[] strValues = formBean.getStrChk().replace("@", "#").split("#");
			
			vo.setStrStoreId(strValues[0]);
			vo.setStrItemId(strValues[1]);
			vo.setStrItemBrandId(strValues[2]);
			vo.setStrBatchNo(strValues[3]);
				
			vo.setStrInHandQuantityUnitID(formBean.getStrInHandQuantityUnitID()
					.replace("^", "#").split("#")[0]);
			vo.setStrUnitRateID(formBean.getStrUnitRateID().replace("^", "#")
					.split("#")[0]);
			vo.setStrUnitSaleID(formBean.getStrUnitSaleID().replace("^", "#")
					.split("#")[0]);
			vo.setStrItemCategoryNo("10");
						
			vo.setStrOldStockStatus(formBean.getCombo()[2]);
			
			//bo.update(vo);
			
			if (vo.getStrMsgType().equals("1")){
				throw new Exception(vo.getStrMsgString());
			}
			
			res = vo.getBExistStatus();
			
						
		} catch (Exception e) {

			strmsgText = "DrugInventory.DrugInventoryTransDATA.update(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->update()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;

		} finally {

			bo = null;
			vo = null;
		

		}
		
		return res;
		
	}
	
	public static void getIsModify(DrugInventoryTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		DrugInventoryTransBO bo = null;
		DrugInventoryTransVO vo = null;

		try {

			bo = new DrugInventoryTransBO();
			vo = new DrugInventoryTransVO();

			String strHospitalCode = request.getSession().getAttribute(
					"HOSPITAL_CODE").toString();
			
			String strTemp = (String) request.getParameter("strChkVal");
			
			String strTempVal[] = strTemp.replace("@", "#").split("#");
			
			vo.setStrStoreId(strTempVal[0]);
			vo.setStrItemId(strTempVal[1]);
			vo.setStrItemBrandId(strTempVal[2]);
			vo.setStrHospitalCode(strHospitalCode);
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
			
			strmsgText = "DrugInventoryTransDATA.getIsModify(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"DrugInventoryTransDATA->getIsModify()", strmsgText);
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
