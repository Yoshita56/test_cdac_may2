package mms.masters.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.masters.bo.ItemSetsMstBO;
import mms.masters.controller.fb.ItemSetsMstFB;
import mms.masters.controller.hlp.ItemSetsMstHLP;
import mms.masters.vo.ItemSetsMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemSetsMstDATA.
 */
public class ItemSetsMstDATA {

	/**
	 * to display the Store Type Name on Add page or modify page.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void initialAdd(ItemSetsMstFB formBean,
			HttpServletRequest request) {
		ItemSetsMstBO bo = null;
		ItemSetsMstVO vo = null;
		String strmsgText = "";
		String cmb1 = "";
		HisUtil hisutil = null;
		String temp[] = null;
		String temp1[] = null;
		//String temp2[] = null;

		try {
			bo = new ItemSetsMstBO();
			vo = new ItemSetsMstVO();

			hisutil = new HisUtil("mms", "ItemSetsMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String strComboValues = request.getParameter("comboValue");
			formBean.setStrComboValues(strComboValues);

			temp = strComboValues.replace('^', '#').split("#");

			String strItemCategoryName = temp[0];
			// String strGenItemName = temp[1];
			String strSetName = temp[1];
			formBean.setStrItemCategoryName(strItemCategoryName);
			formBean.setStrSetName(strSetName);

			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);

			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strItemCategoryId = formBean.getCombo()[0];
			// String strGenItemId = formBean.getCombo()[1];
			String strSetId = formBean.getCombo()[1];

			/*
			 * after successful splitting, temp1[0]=>category id
			 * temp1[1]=>generic table name temp1[2]=>item/drug table name
			 */
			temp1 = strItemCategoryId.replace('^', '#').split("#");
			// temp2 = strGenItemId.replace('^', '#').split("#");
			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrItemCategoryNo(temp1[0]);
			formBean.setStrSetId(strSetId);
			// formBean.setStrGenItemId(temp2[0]);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCategoryNo(temp1[0]);
			vo.setStrSetId(strSetId);
			// vo.setStrGenItemId(strGenItemId);
			vo.setStrModuleId(formBean.getStrModuleId());

			vo.setGenericTableName(temp1[1]);
			vo.setItemTableName(temp1[2]);

			bo.initialAdd(vo);
			formBean.setStrGenItemName(vo.getStrGenItemName());
			hisutil = new HisUtil("mms", "ItemSetsMstDATA");

			/*
			 * if (vo.getStrGroupComboWS() != null &&
			 * vo.getStrGroupComboWS().size() > 0) { cmb =
			 * hisutil.getOptionValue(vo.getStrGroupComboWS(),
			 * vo.getStrGroupId(), "0^Select Value", false); }else{ cmb =
			 * "<option value='0'>Select Value</option>"; }
			 * 
			 * formBean.setStrGroupCombo(cmb);
			 */

			/*
			 * if (vo.getStrUserNameComboWS() != null &&
			 * vo.getStrUserNameComboWS().size() > 0) { cmb =
			 * hisutil.getOptionValue(vo.getStrUserNameComboWS(), vo
			 * .getStrUserId(), "0^Select Value", false); } else { cmb =
			 * "<option value='0'>Select Value</option>"; }
			 */

			cmb1 = hisutil.getOptionValue(vo.getStrItemCatComboWS(), "0",
					"0^Select Value", false);

			formBean.setStrItemCatCombo(cmb1);

			String strValue = ItemSetsMstHLP.getAddedItemDetails(vo
					.getStrItemDetails());

			formBean.setStrAddedItemDetails(strValue);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "ItemSetsMaster.ItemSetsMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemSetsMstDATA->initialAdd()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * To get values of Item Name Combo.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void itemName(ItemSetsMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ItemSetsMstBO bo = null;
		ItemSetsMstVO vo = null;

		String cmbstr = "";
		String strGenItemId[] = null;

		try {

			bo = new ItemSetsMstBO();
			vo = new ItemSetsMstVO();

			String strHospitalCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();
			String genItemId = (String) request.getParameter("GenItemId");
			if (genItemId != null && !genItemId.trim().equals("")) {

				if (genItemId.equals("0")) {
					strGenItemId = new String[] { "0" };
				} else {
					strGenItemId = genItemId.replace("^", "#").split("#");
				}

				vo.setStrHospitalCode(strHospitalCode);
				vo.setStrSeatId(strSeatId);
				vo.setStrGenItemId(strGenItemId[0]);
				// vo.setStrItemCategoryNo(strGenItemId[0].substring(0, 2));
				vo.setStrItemCategoryNo(formBean.getStrItemCategoryNo());
				vo.setStrGroupId(formBean.getStrGroupId());
				bo.itemName(vo);

				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}

				HisUtil hisutil = new HisUtil("mms", "ItemSetsMstDATA");

				if (vo.getStrItemNameComboWS() != null
						&& vo.getStrItemNameComboWS().size() > 0) {
					cmbstr = hisutil.getOptionValue(vo.getStrItemNameComboWS(),
							vo.getStrItemId(), "0^Select Value", false);
				} else {
					cmbstr = "<option value='0'>Select Value</option>";
				}

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
			strmsgText = "ItemSetsMaster.ItemSetsMstDATA.itemName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemSetsMstDATA->itemName()", strmsgText);
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
	 * To get values of Item Name Combo.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void getGenItemNameCombo(ItemSetsMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ItemSetsMstBO bo = null;
		ItemSetsMstVO vo = null;

		String cmbstr = "";

		try {

			bo = new ItemSetsMstBO();
			vo = new ItemSetsMstVO();

			String strHospitalCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();
			String subGroupId = (String) request.getParameter("subGroupName");
			String itemcatId = request.getParameter("itemcatId");
			String groupId = (String) request.getParameter("groupName");

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			vo.setStrSubGroupId(subGroupId);
			vo.setStrItemCategoryNo(itemcatId);
			vo.setStrGroupId(groupId);

			bo.getGenItemNameCombo(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			HisUtil hisutil = new HisUtil("mms", "ItemSetsMstDATA");

			if (vo.getStrGenItemNameComboWS() != null
					&& vo.getStrGenItemNameComboWS().size() > 0) {
				cmbstr = hisutil.getOptionValue(vo.getStrGenItemNameComboWS(),
						vo.getStrGenItemId(), "0^Select Value", false);
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
			strmsgText = "ItemSetsMaster.ItemSetsMstDATA.getGenItemNameCombo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemSetsMstDATA->getGenItemNameCombo()", strmsgText);
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
	 * To get values of SubgroupCombo.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void subGroupName(ItemSetsMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ItemSetsMstBO bo = null;
		ItemSetsMstVO vo = null;
		String subgrpcmbstr = "";
		String gitemcmb = "";

		try {

			bo = new ItemSetsMstBO();
			vo = new ItemSetsMstVO();
			String strHospitalCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();
			String groupId = (String) request.getParameter("groupName");
			String itemcatId = request.getParameter("itemcatId");

			vo.setStrItemCategoryNo(itemcatId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrGroupId(groupId);

			vo.setStrSubGroupId("0");
			bo.getSubGroupName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			bo.getGenItemNameCombo(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			HisUtil hisutil = new HisUtil("mms", "ItemSetsMstDATA");

			if (vo.getStrSubGroupComboWS() != null
					&& vo.getStrSubGroupComboWS().size() > 0) {
				subgrpcmbstr = hisutil.getOptionValue(
						vo.getStrSubGroupComboWS(), vo.getStrSubGroupId(),
						"0^Select Value", false);
			} else {
				subgrpcmbstr = "<option value='0'>Select Value</option>";
			}

			if (vo.getStrGenItemNameComboWS() != null
					&& vo.getStrGenItemNameComboWS().size() > 0) {
				gitemcmb = hisutil.getOptionValue(
						vo.getStrGenItemNameComboWS(), "0", "0^Select Value",
						false);
			} else {
				gitemcmb = "<option value='0'>Select Value</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(subgrpcmbstr + "##" + gitemcmb);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			strmsgText = "ItemSetsMaster.ItemSetsMstDATA.subGroupName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemSetsMstDATA->subGroupName()", strmsgText);
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
	 * Gets the group name.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the group name
	 */
	public static void getGroupName(ItemSetsMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ItemSetsMstBO bo = null;
		ItemSetsMstVO vo = null;
		String cmb = "";

		try {
			String strHospitalCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String strSeatId = request.getSession().getAttribute("SEATID")
					.toString();
			String itemcatId = (String) request.getParameter("itemcatId");

			bo = new ItemSetsMstBO();
			vo = new ItemSetsMstVO();
			/*
			 * String cmbValue = request.getParameter("strCategory"); temp =
			 * cmbValue.replace('^', '#').split("#");
			 */

			vo.setStrItemCatId(itemcatId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			bo.getGroupName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			HisUtil hisutil = new HisUtil("mms", "ItemSetsMstDATA");

			if (vo.getStrGroupComboWS() != null
					&& vo.getStrGroupComboWS().size() > 0) {
				cmb = hisutil.getOptionValue(vo.getStrGroupComboWS(),
						vo.getStrGroupId(), "0^Select Value", false);
			} else {
				cmb = "<option value='0'>Select Value</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmb);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "ItemSetsMaster.ItemSetsMstDATA.getGroupName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemSetsMstDATA->getGroupName()", strmsgText);
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
	 * to insert the data.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */

	public static void insertRecord(ItemSetsMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		ItemSetsMstBO bo = null;
		ItemSetsMstVO vo = null;
		String temp1[] = null;
		String temp[] = null;
		String strGenItemId = "";

		try {
			bo = new ItemSetsMstBO();
			vo = new ItemSetsMstVO();
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strSetCategoryId = formBean.getCombo()[0];
			String strSetId = formBean.getCombo()[1];

			temp1 = strSetCategoryId.replace('^', '#').split("#");

			strGenItemId = formBean.getStrGenItemId();
			temp = strGenItemId.replace("^", "#").split("#");

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrSetId(strSetId);
			vo.setStrSetCatNo(temp1[0]);
			vo.setStrItemCategoryNo(formBean.getStrItemCatId());
			
			
			
			
			
			vo.setStrItemBrandId(formBean.getStrItemId());
			vo.setStrItemQuantity(formBean.getStrItemQuantity());
			vo.setStrUnitId(formBean.getStrUnitId());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			
			
			if(temp[0].equals("0")) {
				bo.getItemId(vo);
			} else {
				vo.setStrItemId(temp[0]);
			}

			bo.insertQuery(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) {
				formBean.setStrWarning("Data already exist");
			} else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {

			strmsgText = "ItemSetsMaster.ItemSetsMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemSetsMstDATA->insertRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {

			vo = null;
			bo = null;
		}

	}

	/**
	 * to get the data for modify page.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void modifyRecord(ItemSetsMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		ItemSetsMstBO bo = null;
		ItemSetsMstVO vo = null;
		String chk = "";
		String strtemp[] = null;
		String strtemp2[] = null;

		String temp1[] = null;
		HisUtil hisutil = null;
		String strUnitcombo = "";

		try {
			bo = new ItemSetsMstBO();
			vo = new ItemSetsMstVO();
			formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);
			hisutil = new HisUtil("mms", "ItemSetsMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String strComboValues = request.getParameter("comboValue");
			temp1 = strComboValues.replace('^', '#').split("#");

			String strItemCategoryName = temp1[0];
			formBean.setStrItemCategoryName(strItemCategoryName);

			String strSetName = temp1[1];
			formBean.setStrSetName(strSetName);

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[3].replace('$', '#').split("#");

			// String seatid = request.getSession().getAttribute("SEATID")
			// .toString();
			// //System.out.println("formBean.getStrModuleId()-->"+formBean.getStrModuleId());
			vo.setStrModuleId(formBean.getStrModuleId());

			vo.setStrSetId(strtemp[0]);
			vo.setStrItemId(strtemp[1]);
			vo.setStrHospitalCode(strtemp[2]);
			vo.setStrSetSlNo(strtemp2[0]);

			bo.modifyRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			strUnitcombo = hisutil.getOptionValue(vo.getStrUnitNameComboWS(),
					vo.getStrUnitId(), "0^Select Value", false);

			vo.setStrUnitCombo(strUnitcombo);
			formBean.setStrSetCategoryName(vo.getStrSetCategoryName());
			formBean.setStrSetName(vo.getStrSetName());
			formBean.setStrGenItemName(vo.getStrGenItemName());
			formBean.setStrItemName(vo.getStrItemName());
			formBean.setStrItemQuantity(vo.getStrItemQuantity());
			formBean.setStrUnitCombo(vo.getStrUnitCombo());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrItemCatName(vo.getStrItemCatName());
			formBean.setStrItemCategoryNo(vo.getStrItemCategoryNo());
			formBean.setStrItemBrandId(vo.getStrItemBrandId());
			formBean.setStrChk(request.getParameter("chk"));
		} catch (Exception e) {

			strmsgText = "ItemSetsMaster.ItemSetsMstDATA.modifyRecord(vo) -->"
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemSetsMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
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
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(ItemSetsMstFB formBean,
			HttpServletRequest request) {

		String strmsgText = "";
		ItemSetsMstVO vo = null;
		ItemSetsMstBO bo = null;
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		String temp[] = null;

		try {
			bo = new ItemSetsMstBO();
			vo = new ItemSetsMstVO();

			chk = request.getParameter("chk");
			// //System.out.println("update chk"+chk);
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[3].replace('$', '#').split("#");

			String strSetCategoryId = formBean.getStrSetCatNo();

			// //System.out.println("strSetCategoryId"+strSetCategoryId);
			temp = strSetCategoryId.replace('^', '#').split("#");
			// //System.out.println("temp"+temp[0]);

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrModuleId(MmsConfigUtil.MODULE_ID);

			vo.setStrSetId(strtemp[0]);
			vo.setStrItemId(strtemp[1]);
			vo.setStrHospitalCode(strtemp[2]);
			vo.setStrSetSlNo(strtemp2[0]);
			vo.setStrSeatId(seatid);
			vo.setStrSetCatNo(temp[0]);

			// //System.out.println("setStrSetCatNo"+temp[0]);
			// //System.out.println("setStrSeatId"+seatid);

			vo.setStrItemQuantity(formBean.getStrItemQuantity());
			vo.setStrUnitId(formBean.getStrUnitId());
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());
			vo.setStrItemCatId(formBean.getStrItemCategoryNo());
			// //System.out.println("setStrItemCategoryNo"+vo.getStrItemCategoryNo());

			vo.setStrItemBrandId(formBean.getStrItemBrandId());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}
		} catch (Exception e) {
			retValue = false;
			strmsgText = "ItemSetsMaster.ItemSetsMstDATA.updateRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemSetsMstDATA->updateRecord()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

	/**
	 * To get values of Unit Name Combo.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void unitName(ItemSetsMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		ItemSetsMstBO bo = null;
		ItemSetsMstVO vo = null;
		String temp[] = null;

		HisUtil hisutil = null;
		String cmbstr = "";
		String strGenItemId = "";
		String strInventoryUnitId = "";
		String hosCode = "";
		String seatid = "";
		
		String strItemId="";
		String strItemCatId="";

		try {

			bo = new ItemSetsMstBO();
			vo = new ItemSetsMstVO();
			if (request.getParameter("strGenItemId") != null
					&& !request.getParameter("strGenItemId").equals("0")) {
				strGenItemId = request.getParameter("strGenItemId");
				temp = strGenItemId.replace("^", "#").split("#");
				strInventoryUnitId = temp[1];

				hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
				seatid = request.getSession().getAttribute("SEATID").toString();

				vo.setStrHospitalCode(hosCode);
				vo.setStrSeatId(seatid);
				vo.setStrInventoryUnitId(strInventoryUnitId);

				bo.getUnitValues(vo);

				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				hisutil = new HisUtil("mms", "StoreItemMstDATA");
				if (vo.getStrUnitNameComboWS() != null
						&& vo.getStrUnitNameComboWS().size() > 0) {
					cmbstr = hisutil.getOptionValue(vo.getStrUnitNameComboWS(),
							"", "0^Select Value", false);
				} else {
					cmbstr = "<option value='0'>Select Value</option>";
				}

			} else if (request.getParameter("strGenItemId") != null
					&& request.getParameter("strGenItemId").equals("0")) {
				strItemId = request.getParameter("strItemId");
				strItemCatId = request.getParameter("strItemCatId");
				//temp = strGenItemId.replace("^", "#").split("#");
				//strInventoryUnitId = temp[1];

				hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
						.toString();
				seatid = request.getSession().getAttribute("SEATID").toString();

				vo.setStrHospitalCode(hosCode);
				vo.setStrSeatId(seatid);
				//vo.setStrInventoryUnitId(strInventoryUnitId);
				vo.setStrItemId(strItemId);
				vo.setStrItemCategoryNo(strItemCatId);
				bo.getUnitValuesFromItemId(vo);

				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}

				hisutil = new HisUtil("mms", "StoreItemMstDATA");
				if (vo.getStrUnitNameComboWS() != null
						&& vo.getStrUnitNameComboWS().size() > 0) {
					cmbstr = hisutil.getOptionValue(vo.getStrUnitNameComboWS(),
							"", "0^Select Value", false);
				} else {
					cmbstr = "<option value='0'>Select Value</option>";
				}
				
			} else {
				cmbstr = "<option value='0'>Select Value</option>";
			}
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "ItemSetsMaster.ItemSetsMstDATA.unitName(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ItemSetsMstDATA->unitName()", strmsgText);
			formBean.setStrErrorMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
			eObj = null;
		} finally {
			vo = null;
			bo = null;
			hisutil = null;
		}
	}

}
