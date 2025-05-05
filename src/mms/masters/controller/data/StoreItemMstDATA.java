package mms.masters.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.masters.bo.StoreItemMstBO;
import mms.masters.controller.fb.StoreItemMstFB;
import mms.masters.vo.StoreItemMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreItemMstDATA.
 * 
 * @author Anshul Jindal
 */

/**
 * Developer : Tanvi Sappal Version : 1.0 Modify Date : 13/May/2009
 * 
 */
public class StoreItemMstDATA {
	
	/**
	 * to display the current date and item,brand & level unit combos.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void initialAdd(StoreItemMstFB formBean,
			HttpServletRequest request) {

		StoreItemMstBO bo = null;
		StoreItemMstVO vo = null;
		HisUtil hisutil = null;
		String temp[] = null;
		String strmsgText;
		// String strStoreTypeId = "";
		String strCategoryNo;
		String ctDate;
		String hosCode;
		String seatid;
		String strStoreCombo;
		String cmb;
		String strComboName;
		//String strGrpNameId;

		try {
			bo = new StoreItemMstBO();
			vo = new StoreItemMstVO();

			hisutil = new HisUtil("mms", "StoreItemMstDATA");
			ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			if (formBean.getStrComboValue().equals("")) {
				strComboName = request.getParameter("comboValue");

			} else {
				strComboName = formBean.getStrComboValue();
			}
			// //System.out.println("strComboName="+strComboName);
			formBean.setStrComboValue(strComboName);
			temp = strComboName.replace('^', '#').split("#");
			String strStoreName = temp[0];
			String strItemCategoryName = temp[1];

			formBean.setStrStoreName(strStoreName);
			formBean.setStrItemCategoryName(strItemCategoryName);

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			// //System.out.println("strStoreCombo-->"+formBean.getCombo()[0]);
			// //System.out.println("strCategoryNo-->"+formBean.getCombo()[1]);
			strStoreCombo = formBean.getCombo()[0];
			strCategoryNo = formBean.getCombo()[1];
			// strGrpNameId = formBean.getCombo()[2];
            			
			temp = strStoreCombo.replace('@', '#').split("#");

			// strStoreTypeId = temp[2];
			// COMMENTED AFTER CHANGES IN TABLES ON 17TH FEB-09
			// strCategoryNo = strStoreTypeId.substring(0, 1);

			formBean.setStrStoreLevel("1");
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getCombo()[0]);
			// Commented By Amit Kr On Date 28-Dec-2010 (Ref of Change Request)
//			if(temp[2].equals("1")){
//				strStoreName+=" [ Bounded with items ]";
//			}else{
//				
//				strStoreName+=" [ Not Bounded with items ]";
//				
//			}
			formBean.setStrStoreName(strStoreName);
			formBean.setStrCategoryNo(strCategoryNo);
			vo.setStrCategoryNo(strCategoryNo);
			// vo.setStrStoreTypeId(strStoreTypeId);
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);

			bo.initAdd(vo);
			if (vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			cmb = hisutil.getOptionValue(vo.getStrGroupComboWs(),"0", "0^Select Value", true);

			//str = hisutil.getOptionValue(vo.getStrHospitalServiceCombo(), "2", "0^Select value", true);
			
			formBean.setStrGroupNameCombo(cmb);

			/*if (vo.getStrLevelUnitComboWs() != null
					&& vo.getStrLevelUnitComboWs().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getStrLevelUnitComboWs(), "",
						"0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			vo.setStrLevelUnitCombo(cmb);

			formBean.setStrLevelUnitCombo(vo.getStrLevelUnitCombo());*/
			
			
			

		}
		catch (Exception e)
		{
			e.printStackTrace();
			strmsgText = "StoreItemMaster.StoreItemMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreItemMstDATA->initialAdd()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			hisutil = null;
		}

	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void insertRecord(StoreItemMstFB formBean,
			HttpServletRequest request) {
		StoreItemMstBO bo = null;
		StoreItemMstVO vo = null;
		String strmsgText = "";
		String temp[] = null;

		String strCategoryNo = "";
		String strStoreId = "";
		String hosCode = "";
		String seatid = "";
		String strStoreCombo = "";

		try {
			bo = new StoreItemMstBO();

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			strStoreCombo = formBean.getCombo()[0];
			strCategoryNo = formBean.getCombo()[1];

			temp = strStoreCombo.replace('@', '#').split("#");
			// String strStoreTypeId = temp[2];
			// strCategoryNo = strStoreTypeId.substring(0, 1);
			strStoreId = temp[0];

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrStoreId(strStoreCombo);
			formBean.setStrIsValid("1");
			formBean.setStrCategoryNo(strCategoryNo);
			
			temp = formBean.getStrItemId().replace("^", "#").split("#");
			
			//System.out.println("Item Id::::::::::"+formBean.getStrItemId());

			if (!formBean.getStrIssueableFlag().equals("1"))
				formBean.setStrIssueableFlag("0");
			if (!formBean.getStrIsReturnable().equals("1"))
				formBean.setStrIsReturnable("0");
			if (formBean.getStrForeCast() == null
					|| formBean.getStrForeCast().equals(""))
				formBean.setStrForeCast("000");
			// Changes by Tanvi for Reserved Qty on 20/April in all methods
			// Insert, Modify and Update with Batch Update also
			if (formBean.getStrReservedQty() == null
					|| formBean.getStrReservedQty().equals(""))
				formBean.setStrReservedQty("00");

			vo = (StoreItemMstVO) TransferObjectFactory.populateData(
					"mms.masters.vo.StoreItemMstVO", formBean);

			
			vo.setStrItemId(formBean.getStrItemId().split("\\^")[0]);
			bo.insertRecord(vo);

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

			
			if (vo.getBExistStatus() == false) 
			{
				formBean.setStrWarning("Data already exist");
			} 
			else
			{
				if (vo.getStrMsgType().equals("2")) 
				{
					formBean.setStrWarning("No Item Avalaible in Selected Group!!!!!");
				}
				else
				{
				    formBean.setStrMsg("Data Saved Successfully");
				}   
			}

		} catch (Exception e) {
            e.printStackTrace();
			strmsgText = "StoreItemMaster.StoreItemMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreItemMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(StoreItemMstFB formBean,
			HttpServletRequest request) {
		StoreItemMstBO bo = null;
		StoreItemMstVO vo = null;
		String strmsgText = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		HisUtil hisutil = null;
		String temp[] = null;

		String strCategoryNo = "";
		String hosCode = "";
		String seatid = "";
		String strStoreCombo = "";
		String strStoreName = "";
		String strComboName = "";
		String strItemCategoryName = "";
	 
		String ctDate = "";

		try {
			bo = new StoreItemMstBO();
			vo = new StoreItemMstVO();
			hisutil = new HisUtil("mms", "StoreItemMstDATA");
			ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			if (formBean.getStrComboValue().equals("")) {
				strComboName = request.getParameter("comboValue");
			} else {
				strComboName = formBean.getStrComboValue();
			}
			// //System.out.println("strComboName="+strComboName);
			formBean.setStrComboValue(strComboName);
			temp = strComboName.replace('^', '#').split("#");
			strStoreName = temp[0];
			strItemCategoryName = temp[1];

			formBean.setStrStoreName(strStoreName);
			formBean.setStrItemCategoryName(strItemCategoryName);

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			strStoreCombo = formBean.getCombo()[0];

			temp = strStoreCombo.replace('@', '#').split("#");
			// String strStoreTypeId = temp[2];
			// strCategoryNo = strStoreTypeId.substring(0, 1);
			strCategoryNo = formBean.getCombo()[1];

			formBean.setStrStoreLevel("1");
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreCombo);
			vo.setStrCategoryNo(strCategoryNo);
			formBean.setStrCategoryNo(strCategoryNo);
			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());
			}

			chk = request.getParameter("chk");
            //108@10102101@10100001@10000001@101004@10$1
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[4].replace('$', '#').split("#");
			strtemp[4] = strtemp2[0];

			vo.setStrHospitalCode(strtemp[0]);
			vo.setStrStoreId(strtemp[1]);
			vo.setStrItemId(strtemp[2]);
			vo.setStrItemBrandId(strtemp[3]);
			vo.setStrGroupId(strtemp[4]);
			vo.setStrItemSlNo(strtemp[5]);
			vo.setStrSubGroupId(strtemp[6]);

			bo.modifyRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			TransferObjectFactory.populateData(formBean, vo);

			/*if (vo.getStrLevelUnitComboWs() != null
					&& vo.getStrLevelUnitComboWs().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getStrLevelUnitComboWs(), vo
						.getStrLevelUnitId(), "0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			vo.setStrLevelUnitCombo(cmb);
			formBean.setStrLevelUnitCombo(vo.getStrLevelUnitCombo());*/

			formBean.setStrChk1(chk);
			formBean.setStrStoreName(strStoreName);
			formBean.setStrCategoryNo(strCategoryNo);
			formBean.setStrMaxQty(vo.getStrMaxQty());
            formBean.setStrMaxIndentQty(vo.getStrMaxIndentQty());
			formBean.setStrLevelUnitId(vo.getStrLevelUnitId());
			formBean.setStrLevelUnitName(vo.getStrLevelUnitName());
			
		} catch (Exception e) {

			strmsgText = "StoreItemMaster.StoreItemMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreItemMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(StoreItemMstFB formBean,
			HttpServletRequest request) {

		StoreItemMstBO bo = null;
		StoreItemMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		String strtemp[] = null;
		//String strtemp2[] = null;
		String chk = "";
		String seatid = "";

		try 
		{
			bo = new StoreItemMstBO();
            // GNUM_HOSPITAL_CODE ||'@'|| HSTNUM_STORE_ID ||'@'|| HSTNUM_ITEM_ID ||'@'|| 
			// HSTNUM_ITEMBRAND_ID ||'@'|| HSTNUM_GROUP_ID||'@'|| HSTNUM_ITEM_SLNO || '@'|| HSTNUM_SUBGROUP_ID  
			// chk::::108@10102101@10000019@10100070@101004@14@0$3
			chk = request.getParameter("chk");
			////System.out.println("chk::::"+chk);
			strtemp = chk.replace('@', '#').split("#");
			//strtemp2 = strtemp[4].replace('$', '#').split("#");
			
			//strtemp[4] = strtemp2[0];
            
			seatid = request.getSession().getAttribute("SEATID").toString();

			formBean.setStrHospitalCode(strtemp[0]);
			formBean.setStrStoreId(strtemp[1]);
			formBean.setStrItemId(strtemp[2]);
			formBean.setStrItemBrandId(strtemp[3]);
			formBean.setStrGroupId(strtemp[4]);
			formBean.setStrItemSlNo(strtemp[5]);
			formBean.setStrSubGroupId(strtemp[6].split("\\$")[0]);
				
			formBean.setStrSeatId(seatid);

			if (!formBean.getStrIssueableFlag().equals("1"))
				formBean.setStrIssueableFlag("0");
			if (!formBean.getStrIsReturnable().equals("1"))
				formBean.setStrIsReturnable("0");
			if (formBean.getStrForeCast() == null
					|| formBean.getStrForeCast().equals(""))
				formBean.setStrForeCast("000");

			if (formBean.getStrReservedQty() == null
					|| formBean.getStrReservedQty().equals(""))
				formBean.setStrReservedQty("00");

			vo = (StoreItemMstVO) TransferObjectFactory.populateData(
					"mms.masters.vo.StoreItemMstVO", formBean);

			// Calling BO Method
			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}
			
			

		} catch (Exception e) {

			strmsgText = "StoreItemMaster.StoreItemMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreItemMstDATA->updateRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

	/**
	 * To get values of Brand name Combo.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * @param response the response
	 */
	public static void getBrandName(StoreItemMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		StoreItemMstBO bo = null;
		StoreItemMstVO vo = null;
		HisUtil hisutil = null;
		String temp[] = null;
		// String strStoreTypeId = "";
		String strCatNo = "";
		String strItemId = "";
		String strStoreCombo = "";
		String hosCode = "";
		String seatid = "";
		String cmb = "";

		try {

			bo = new StoreItemMstBO();
			vo = new StoreItemMstVO();

			strItemId = (String) request.getParameter("ItemId");
			strStoreCombo = (String) request.getParameter("combo");
			strCatNo = (String) request.getParameter("CategoryNo");
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			strStoreCombo = formBean.getCombo()[0];
			temp = strStoreCombo.replace('@', '#').split("#");

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreCombo);
			vo.setStrCategoryNo(strCatNo);
			vo.setStrItemId(strItemId);

			bo.getBrandName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "StoreItemMstDATA");
			cmb = hisutil.getOptionValue(vo.getStrItemBrandComboWs(), vo
					.getStrItemBrandId(), "0^All Value", true);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "StoreItemMaster.StoreItemMstDATA.getBrandName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreItemMstDATA->getBrandName()", strmsgText);
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

	/**
	 * To get values of Brand name Combo.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * @param response the response
	 */
	public static void getSubGroupCombo(StoreItemMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		StoreItemMstBO bo = null;
		StoreItemMstVO vo = null;
		HisUtil hisutil = null;
		String temp[] = null;
		String hosCode = "";
		String seatid = "";
		String subgrpcmbstr = "";
		String itemcmb = "";
		String grpAllItemcmb = "";
		String strGroupId = "";
        //String strStoreId;
		/*String[] temp = null;
		String strStoreCombo = "";
		String strStoreTypeId = "";*/
		String strCategoryNo = "";

		try {

			bo = new StoreItemMstBO();
			vo = new StoreItemMstVO();

			strGroupId = request.getParameter("GroupId");
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			/*
			 * strStoreCombo = formBean.getCombo()[0]; temp =
			 * strStoreCombo.replace('^', '#').split("#"); strStoreTypeId =
			 * temp[2]; strCategoryNo = formBean.getCombo()[1];
			 */

			strCategoryNo = request.getParameter("CategoryNo");
			   temp = request.getParameter("StoreId").replace('@', '#').split("#");
			
			System.out.println("data subgrp cat no-"+strCategoryNo);
			System.out.println("Store Id -"+request.getParameter("StoreId"));
			 

			vo.setStrGroupId(strGroupId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrCategoryNo(strCategoryNo);
			formBean.setStrStoreId(temp[0]);
			vo.setStrStoreId(temp[0]);

			bo.getSubGroupCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			bo.itemGrpNameCombo(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "StoreItemMstDATA");
			if (vo.getStrSubGroupComboWs() != null
					&& vo.getStrSubGroupComboWs().size() > 0) {
				subgrpcmbstr = hisutil.getOptionValue(vo
						.getStrSubGroupComboWs(), vo.getStrSubGroupId(),
						"0^All Value", true);
			} else {
				subgrpcmbstr = "<option value='0'>All Value</option>";
			}

			if (vo.getStrItemNameComboWs() != null
					&& vo.getStrItemNameComboWs().size() > 0) {
				itemcmb = hisutil.getOptionValue(vo.getStrItemNameComboWs(), vo
						.getStrItemId(), "0^All Value", true);
			} else {
				itemcmb = "<option value='0'>All Value</option>";
			}
			
			if (getGrpAllItemNameCombo(formBean,request,response) != null && getGrpAllItemNameCombo(formBean,request,response).size() > 0) 
			{
				grpAllItemcmb = hisutil.getOptionValue(getGrpAllItemNameCombo(formBean,request,response),"0", "0^All Value", true);
			} 
			else 
			{
				grpAllItemcmb = "<option value='0'>All Value</option>";
			}			
			

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(subgrpcmbstr + "#" + itemcmb + "#" +grpAllItemcmb);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			strmsgText = "StoreItemMaster.StoreItemMstDATA.getSubGroupCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreItemMstDATA->getSubGroupCombo()", strmsgText);
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

	/**
	 * To get values of Item name Combo according to Group Id & Sub Group Id.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * @param response the response
	 */
	public static void getItemNameCombo(StoreItemMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		StoreItemMstBO bo = null;
		StoreItemMstVO vo = null;
		HisUtil hisutil = null;

		String hosCode = "";
		String seatid = "";
		String cmb = "";
		String strGroupId = "";
		String strSubGroupId = "";
		String temp[] = null;

		// String strStoreTypeId = "";
		String strCategoryNo = "";

		String strStoreCombo = "";

		try {

			bo = new StoreItemMstBO();
			vo = new StoreItemMstVO();

			strGroupId = request.getParameter("GroupId");
			strSubGroupId = request.getParameter("SubGroupId");
			strStoreCombo = request.getParameter("StoreComboId");
			strCategoryNo = request.getParameter("CategoryNo");

			// //System.out.println("dao getItemNameCombo
			// strCategoryNo"+strCategoryNo);

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			temp = strStoreCombo.replace('@', '#').split("#");
			// String strStoreTypeId = temp[2];
			// strCategoryNo = strStoreTypeId.substring(0, 1);

			vo.setStrStoreId(strStoreCombo);
			vo.setStrCategoryNo(strCategoryNo);
			vo.setStrGroupId(strGroupId);
			vo.setStrSubGroupId(strSubGroupId);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			bo.getItemNameCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "StoreItemMstDATA");
			cmb = hisutil.getOptionValue(vo.getStrItemNameComboWs(), vo
					.getStrItemId(), "0^All Value", true);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			strmsgText = "StoreItemMaster.StoreItemMstDATA.getItemNameCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreItemMstDATA->getItemNameCombo()", strmsgText);
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
	
	/**
	 * To get values of Selected Group All Item name Combo according to Group Id & Sub Group Id.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * @param response the response
	 */
	public static WebRowSet getGrpAllItemNameCombo(StoreItemMstFB formBean,
			HttpServletRequest request, HttpServletResponse response)
	{
		StoreItemMstBO bo = null;
		StoreItemMstVO vo = null;
		//HisUtil hisutil = null;
	    String strmsgText;
		//String temp;
		//String cmb;
		//String strItemDetails = "";
		WebRowSet wb  = null;

		try {

			bo = new StoreItemMstBO();
			vo = new StoreItemMstVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE")
					.toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
		 
			if (request.getParameter("GroupId") != null	&& !request.getParameter("GroupId").equals("0")&& request.getParameter("CategoryNo") != null	&& !request.getParameter("CategoryNo").equals("0")) 
			{					   				
				vo.setStrGroupId(request.getParameter("GroupId"));
                vo.setStrCategoryNo(request.getParameter("CategoryNo"));
                vo.setStrStoreId(formBean.getStrStoreId());
				bo.getGrpAllItemNameCombo(vo);

				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				wb = vo.getStrItemBrandComboWs();
				
			} 			
			
		} 
		catch (Exception e)
		{
			strmsgText = "StoreItemMaster.StoreItemMstDATA.getGrpAllItemNameCombo(vo) --> "
					+ e.getMessage();
			new HisException("mms",
					"StoreItemMstDATA->getGrpAllItemNameCombo()", strmsgText);
			
		} 
		finally 
		{
			vo = null;
			bo = null;
			//hisutil = null;
		}
		return wb;
	}
	
	

	/**
	 * To get values of Item name Combo according to Group Id & Sub Group Id.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * @param response the response
	 */
	public static void getUnitCombo(StoreItemMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		StoreItemMstBO bo = null;
		StoreItemMstVO vo = null;
	    
		String temp = "";
		String strUnitDetails = "";

		try {

			bo = new StoreItemMstBO();
			vo = new StoreItemMstVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE")
					.toString());
			vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			
		 
			if (request.getParameter("strItemId") != null
					&& !request.getParameter("strItemId").equals("0")) {
				
				temp = request.getParameter("strItemId").replace("^", "#").split("#")[1];
			   				
				vo.setStrInventoryUnitId(temp);

				bo.getUnitCombo(vo);

				
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}

				strUnitDetails = vo.getStrLevelUnitId()+"^"+vo.getStrLevelUnitName();
 
			} 
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strUnitDetails); 

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			String strmsgText = "StoreItemMaster.StoreItemMstDATA.getUnitCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreItemMstDATA->getUnitCombo()", strmsgText);
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
		 
		}
	}

	/**
	 * to display from store combo on batch update page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void BatchUpdateStoreCombo(StoreItemMstFB formBean,
			HttpServletRequest request) {
		StoreItemMstBO bo = null;
		StoreItemMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String temp[] = null;
		String strStoreTypeId = "";
		String strCategoryNo = "";
		String ctDate = "";
		String cmb = "";
		try {
			String strStoreName = request.getParameter("comboValue");
			formBean.setStrStoreName(strStoreName);

			bo = new StoreItemMstBO();
			vo = new StoreItemMstVO();

			hisutil = new HisUtil("mms", "StoreItemMstDATA");
			ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strStoreId = formBean.getCombo()[0];

			temp = strStoreId.replace('^', '#').split("#");
			strStoreTypeId = temp[2];
			strCategoryNo = strStoreTypeId.substring(0, 1);

			formBean.setStrStoreLevel(temp[1]);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(temp[0]);
			vo.setStrCategoryNo(strCategoryNo);
			vo.setStrStoreTypeId(strStoreTypeId);

			bo.getBatchUpdateStoreCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStrStoreComboWs() != null) {
				cmb = hisutil.getOptionValue(vo.getStrStoreComboWs(),
						"0^Select Value", "Select Value", true);
			}
			vo.setStrStoreCombo(cmb);
			formBean.setStrStoreCombo(vo.getStrStoreCombo());

		} catch (Exception e) {
			strmsgText = "StoreItemMaster.StoreItemMstDATA.BatchUpdateStoreCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"StoreItemMstDATA->BatchUpdateStoreCombo()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

}
