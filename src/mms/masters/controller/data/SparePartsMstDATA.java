package mms.masters.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.masters.bo.SparePartsMstBO;
import mms.masters.controller.fb.SparePartsMstFB;
import mms.masters.controller.hlp.SparePartsMstHLP;
import mms.masters.vo.SparePartsMstVO;

// TODO: Auto-generated Javadoc
/**
 * The Class SparePartsMstDATA.
 */
public class SparePartsMstDATA {

	/**
	 * to display the Store Type Name on Add page or modify page.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void initialAdd(SparePartsMstFB formBean,
			HttpServletRequest request) {
		SparePartsMstBO bo = null;
		SparePartsMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String[] temp = null;
		String[] temp1 = null;
		String strItemCategoryId = "";
		String strItemId = "";

		try {
			bo = new SparePartsMstBO();
			vo = new SparePartsMstVO();

			hisutil = new HisUtil("mms", "SparePartsMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String strComboValues = request.getParameter("comboValue");

			formBean.setStrComboValues(strComboValues);
			temp = strComboValues.replace('^', '#').split("#");

			String strItemCategoryName = temp[0];
			formBean.setStrItemCatgName(strItemCategoryName);
			String strItemName = temp[1];
			formBean.setStrItemName(strItemName);
			// formBean.setStrModuleId("17");

//			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
//					.toString();
			
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			if (formBean.getCombo()[0] != null
					|| formBean.getCombo()[0].equals("")) {

				strItemCategoryId = formBean.getCombo()[0];
			}

			else {

				strItemCategoryId = formBean.getStrItemCatgNo();
			}

			if (formBean.getCombo()[1] != null)

				strItemId = formBean.getCombo()[1];
			else
				strItemId = formBean.getStrItemId();

			temp1 = strItemCategoryId.replace('^', '#').split("#");

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrItemCatgNo(temp1[0]);
			formBean.setStrItemId(strItemId);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatgNo(temp1[0]);
			vo.setStrItemId(strItemId);

			bo.initialAdd(vo);

			hisutil = new HisUtil("mms", "ItemSetsMstDATA");
			String cmb = hisutil.getOptionValue(vo.getStrGroupComboWS(), vo
					.getStrGroupId(), "0^Select Value", false);
			formBean.setStrGroupCombo(cmb);

			String cmb1 = hisutil.getOptionValue(vo
					.getStrSparePartCatgComboWS(), vo
					.getStrSparePatCategoryNo(), "0^Select Value", false);
			formBean.setStrSparePartCatgCombo(cmb1);

			String str = SparePartsMstHLP.getSparePartsDetails(vo
					.getStrSparePartDtlWs());

			formBean.setStrPreviousSparePartDtl(str);

			// formBean.setStrItemCategoryCombo(vo.getStrItemCategoryCombo());

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			// formBean.setStrStoreTypeName(vo.getStrStoreTypeName());

		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "SparePartsMstDATA.initialAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SparePartsMstDATA->initialAdd()", strmsgText);
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
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(SparePartsMstFB formBean,
			HttpServletRequest request) {
		SparePartsMstBO bo = null;
		SparePartsMstVO vo = null;
		String strmsgText = "";
		boolean retValue = true;
		String strtemp[] = null;
		String strtemp2[] = null;
		String chk = "";
		String temp[] = null;
		String temp1[] = null;
		try {
			bo = new SparePartsMstBO();
			vo = new SparePartsMstVO();

			/*
			 * String hosCode =
			 * request.getSession().getAttribute("HOSPITAL_CODE") .toString();
			 * String seatid = request.getSession().getAttribute("SEATID")
			 * .toString(); //// //System.out.println("Chk in
			 * UPDATE::::"+request.getParameter("strChk1"));
			 * vo.setStrHospitalCode(hosCode); vo.setStrSeatId(seatid);
			 * vo.setStrChk1(request.getParameter("strChk1"));
			 * vo.setStrSPartName(formBean.getStrSPartName());
			 * vo.setStrItemName(formBean.getStrItemName());
			 * vo.setStrItemCategory(formBean.getStrItemCategory());
			 * vo.setStrRemarks(formBean.getStrRemarks());
			 * vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			 * 
			 * bo.updateRecord(vo);
			 * 
			 * if (vo.getStrMsgType().equals("1")) { throw new
			 * Exception(vo.getStrMsgString()); }
			 * 
			 * else { if (vo.getStrMsgType().equals("1")) { throw new
			 * Exception(vo.getStrMsgString()); } else {
			 * formBean.setStrMsg("Record Modify Successfully"); } }
			 */

			chk = request.getParameter("chk");

			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			temp = strtemp[3].replace('$', '#').split("#");

			String seatId = request.getSession().getAttribute("SEATID")
					.toString();

			// String strItemCategoryId = formBean.getCombo()[0];
			// String strSetId = formBean.getCombo()[1];

			// //
			// //System.out.println("formBean.getStrItemCatgNo()-->"+formBean.getStrItemCatgNo());

			String strItemCategoryId = formBean.getStrItemCatgNo();
			// String strItemId = formBean.getStrItemId();

			temp1 = strItemCategoryId.replace('^', '#').split("#");

			vo.setStrModuleId(formBean.getStrModuleId());

			// //System.out.println("Item Id Update-->"+strtemp[0]);
			// *// //System.out.println("Spare Part Item Id
			// Update-->"+strtemp[1]);
			// *// //System.out.println("Hospital Code Update-->"+strtemp[2]);
			// *// //System.out.println("Item Sl No Update-->"+strtemp[3]);
			// *// //System.out.println("Item Sl No 11 Update-->"+temp[0]);
			// */

			vo.setStrItemId(strtemp[0]);
			vo.setStrSparePartItemId(strtemp[1]);
			vo.setStrHospitalCode(strtemp[2]);
			vo.setStrItemSlNo(temp[0]);

			vo.setStrLastModeSeatId(seatId);
			vo.setStrSparePatCategoryNo(temp1[0]);
			vo.setStrItemCatgNo(temp1[0]);
			vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrIsValid(formBean.getStrIsValid());

			bo.updateRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {

			retValue = false;
			strmsgText = "DrugSaftyAlertMaster.DrugSaftyAlertMstDATA.updateRecord(vo) --> "
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

	/**
	 * to insert the data.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void insertRecord(SparePartsMstFB formBean,
			HttpServletRequest request) {
		SparePartsMstBO bo = null;
		SparePartsMstVO vo = null;
		String strmsgText = "";
		String temp1[] = null;
		try {
			bo = new SparePartsMstBO();

//			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
//					.toString();
			String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			// //
			// //System.out.println("formBean.getCombo()[0]-->"+formBean.getStrItemCatgNo());
			// //
			// //System.out.println("formBean.getCombo()[1]-->"+formBean.getStrItemId());

			// String strItemCategoryId = formBean.getCombo()[0];
			// String strItemId = formBean.getCombo()[1];

			String strItemCategoryId = formBean.getStrItemCatgNo();
			String strItemId = formBean.getStrItemId();

			temp1 = strItemCategoryId.replace('^', '#').split("#");

			formBean.setStrHospitalCode(hosCode);
			formBean.setStrSeatId(seatid);
			formBean.setStrItemCatgNo(temp1[0]);
			formBean.setStrItemId(strItemId);

			// //
			// //System.out.println("formBean.getStrSparePatCategoryNo()"+formBean.getStrSparePatCategoryNo());
			temp1 = formBean.getStrSparePatCategoryNo().replace('^', '#')
					.split("#");
			formBean.setStrSparePatCategoryNo(temp1[0]);
			// //
			// //System.out.println("formBean.getStrSparePatCategoryNo()"+formBean.getStrSparePatCategoryNo());

			// //
			// //System.out.println("formBean.getStrStrItemCatgNo()"+formBean.getStrItemCatgNo());

			// //
			// //System.out.println("formBean.getStrEffectiveFrom()"+formBean.getStrEffectiveFrom());

			vo = (SparePartsMstVO) TransferObjectFactory.populateData(
					"mms.masters.vo.SparePartsMstVO", formBean);
			vo.setStrIsValid("1");
			/*
			 * vo.setStrItemCategoryNo(strItemCategoryId);
			 * vo.setStrSetId(strSetId);
			 * vo.setStrIsValid(formBean.getStrIsValid());
			 * vo.setStrSetSlNo(formBean.getStrSetSlNo());
			 * 
			 * vo.setStrItemCategoryName(formBean.getStrItemCategoryName());
			 * vo.setStrSetName(formBean.getStrSetName());
			 * vo.setStrGroupId(formBean.getStrGroupId());
			 * vo.setStrSubGroupId(formBean.getStrSubGroupId());
			 * vo.setStrItemId(formBean.getStrItemId());
			 * vo.setStrItemQuantity(formBean.getStrItemQuantity());
			 * vo.setStrUnitId(formBean.getStrUnitId());
			 * 
			 * vo.setStrRemarks(formBean.getStrRemarks());
			 * vo.setStrEffectiveFrom(formBean.getStrEffectiveFrom());
			 */

			bo.insertRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) {
				formBean.setStrWarning("Data already exist");
			} else {
				formBean.setStrMsg("Data Saved Successfully");
			}

			/*
			 * if (vo.getStrMsgType().equals("1")) { throw new
			 * Exception(vo.getStrMsgString()); } else {
			 * formBean.setStrMsg("Data Saved Successfully"); }
			 */

		} catch (Exception e) {
			e.printStackTrace();

			strmsgText = "SparePartsMst.SparePartsMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SparePartsMstDATA->insertRecord()", strmsgText);
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
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 */
	public static void modifyRecord(SparePartsMstFB formBean,
			HttpServletRequest request) {
		SparePartsMstBO bo = null;
		SparePartsMstVO vo = null;
		String strmsgText = "";
		HisUtil hisutil = null;
		String temp[] = null;
		String temp1[] = null;
		String temp2[] = null;
		String chk = "";
		String strtemp[] = null;
		String strtemp2[] = null;
		// String str = "";
		try {
			bo = new SparePartsMstBO();
			vo = new SparePartsMstVO();

			/*
			 * String hosCode =
			 * request.getSession().getAttribute("HOSPITAL_CODE") .toString();
			 * String seatid = request.getSession().getAttribute("SEATID")
			 * .toString(); formBean.setStrHospitalCode(hosCode);
			 * 
			 * vo.setStrHospitalCode(hosCode); vo.setStrSeatId(seatid);
			 * 
			 * vo.setStrChk1(request.getParameter("chk"));
			 * formBean.setStrChk1(request.getParameter("chk"));
			 * bo.initialModify(vo);
			 * 
			 * formBean.setStrSPartName(vo.getStrSPartName());
			 * formBean.setStrItemName(vo.getStrItemName());
			 * formBean.setStrItemCategory(vo.getStrItemCategory());
			 * formBean.setStrRemarks(vo.getStrRemarks());
			 * formBean.setEffectiveFrm(vo.getEffectiveFrm());
			 */

			hisutil = new HisUtil("mms", "ItemSetsMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String strComboValues = request.getParameter("comboValue");
			temp1 = strComboValues.replace('^', '#').split("#");

			String strItemCategoryName = temp1[0];
			formBean.setStrItemCatgNo(strItemCategoryName);

			String strItemName = temp1[1];
			formBean.setStrItemName(strItemName);

			chk = request.getParameter("chk");
			strtemp = chk.replace('@', '#').split("#");
			strtemp2 = strtemp[1].replace('$', '#').split("#");
			strtemp[1] = strtemp2[0];

			temp = strtemp[3].replace('$', '#').split("#");

			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strItemCategoryId = formBean.getStrItemCatgNo();
			// String strItemId = formBean.getStrItemId();

			temp2 = strItemCategoryId.replace('^', '#').split("#");

			vo.setStrModuleId(formBean.getStrModuleId());

			/*
			 * // //System.out.println("Item Id-->"+strtemp[0]); //
			 * //System.out.println("Spare Part Item Id-->"+strtemp[1]); //
			 * //System.out.println("Hospital Code-->"+strtemp[2]); //
			 * //System.out.println("Item Sl No-->"+strtemp[3]); //
			 * //System.out.println("Item Sl No 11-->"+temp[0]);
			 */

			vo.setStrItemId(strtemp[0]);
			vo.setStrSparePartItemId(strtemp[1]);
			vo.setStrHospitalCode(strtemp[2]);
			vo.setStrItemSlNo(temp[0]);
			vo.setStrSeatId(seatid);
			vo.setStrItemCatgNo(temp2[0]);

			bo.initialModify(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setStrItemCatgName(vo.getStrItemCatgName());
			formBean.setStrItemName(vo.getStrItemName());
			formBean.setStrSparePartCategoryName(vo
					.getStrSparePartCategoryName());
			formBean.setStrSparePartItemName(vo.getStrSparePartItemName());
			formBean.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean.setStrRemarks(vo.getStrRemarks());
			formBean.setStrIsValid(vo.getStrIsValid());
			formBean.setStrChk1(request.getParameter("chk"));

		} catch (Exception e) {

			strmsgText = "Spare Parts Master.SparePartsMstDATA.modifyRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SparePartsMstDATA->modifyRecord()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * ***************************Ajax Function for View
	 * Charges(Combo)**********************************.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	/**
	 * To get values of SubgroupCombo
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void subGroupName(SparePartsMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		SparePartsMstBO bo = null;
		SparePartsMstVO vo = null;
		HisUtil hisutil = null;
		String subgrpcmbstr = "";
		String itemcmb = "";

		String strHospitalCode = "";
		String strSeatId = "";
		String groupId = "";
		String sparePartCategoryNo = "";
		String[] temp = null;

		try {

			bo = new SparePartsMstBO();
			vo = new SparePartsMstVO();

//			strHospitalCode = request.getSession()
//					.getAttribute("HOSPITAL_CODE").toString();
			strHospitalCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			strSeatId = request.getSession().getAttribute("SEATID").toString();
			groupId = (String) request.getParameter("GroupId");
			sparePartCategoryNo = (String) request.getParameter("CategoryNo");
			// //System.out.println("sparePartCategoryNo-" + sparePartCategoryNo);
			// //System.out.println("strHospitalCode-" + strHospitalCode);
			// //System.out.println("groupId-" + groupId);
			temp = sparePartCategoryNo.replace("^", "#").split("#");
			sparePartCategoryNo = temp[0];

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrGroupId(groupId);
			vo.setStrSparePatCategoryNo(sparePartCategoryNo);

			bo.getSubGroupName(vo);
			vo.getStrSubGroupComboWS();
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			bo.itemGrpName(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			hisutil = new HisUtil("mms", "SparePartsMstDATA");
			if (vo.getStrSubGroupComboWS() != null
					&& vo.getStrSubGroupComboWS().size() > 0) {
				subgrpcmbstr = hisutil.getOptionValue(vo
						.getStrSubGroupComboWS(), vo.getStrSubGroupId(),
						"0^Select Value", false);
			} else {
				subgrpcmbstr = "<option value='0'>Select Value</option>";
			}

			if (vo.getStrItemNameComboWS() != null
					&& vo.getStrItemNameComboWS().size() > 0) {
				itemcmb = hisutil.getOptionValue(vo.getStrItemNameComboWS(), vo
						.getStrItemId(), "0^Select Value", false);
			} else {
				itemcmb = "<option value='0'>Select Value</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(subgrpcmbstr + "^" + itemcmb);
			} catch (Exception e) {

			}

		} catch (Exception e) {
			e.printStackTrace();
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
	 * To get values of Item Name Combo.
	 * 
	 * @param formBean
	 *            the form bean
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	public static void itemName(SparePartsMstFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		String strmsgText = "";
		SparePartsMstBO bo = null;
		SparePartsMstVO vo = null;
		String temp[] = null;
		String strHospitalCode = "";
		String strSeatId = "";
		String groupId = "";
		String subGroupId = "";
		String categoryId = "";

		try {

			bo = new SparePartsMstBO();
			vo = new SparePartsMstVO();

//			strHospitalCode = request.getSession()
//					.getAttribute("HOSPITAL_CODE").toString();
			strHospitalCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			strSeatId = request.getSession().getAttribute("SEATID").toString();
			categoryId = (String) request.getParameter("CategoryNo");
			groupId = (String) request.getParameter("GroupId");
			subGroupId = (String) request.getParameter("subGroupId");

			// String cmbValue = request.getParameter("strCategory");

			/*
			 * temp = cmbValue.replace('^', '#').split("#");
			 * formBean.setStrItemCategoryNo(temp[0]);
			 * formBean.setStrSetName(temp[1]);
			 */

			/*
			 * // //System.out.println("strHospitalCode-->"+strHospitalCode); //
			 * //System.out.println("strSeatId-->"+strSeatId); //
			 * //System.out.println("groupId-->"+groupId); //
			 * //System.out.println("subGroupId-->"+subGroupId); //
			 * //System.out.println("categoryId-->"+categoryId);
			 */

			temp = categoryId.replace('^', '#').split("#");

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrGroupId(groupId);
			vo.setStrSubGroupId(subGroupId);
			vo.setStrSparePatCategoryNo(temp[0]);
			// vo.setStrSetName(temp[1]);

			bo.itemName(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			// //
			// //System.out.println("vo.getStrItemNameComboWS().size()-->"+vo.getStrItemNameComboWS().size());
			HisUtil hisutil = new HisUtil("mms", "SparePartsMstDATA");
			String cmbstr = hisutil.getOptionValue(vo.getStrItemNameComboWS(),
					vo.getStrItemId(), "0^Select Value", false);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
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
	 * To get values of Unit Name Combo
	 * 
	 * @param formBean
	 * @param request
	 */
	/*
	 * public static void unitName(SparePartsMstFB formBean, HttpServletRequest
	 * request,HttpServletResponse response){
	 * 
	 * String strmsgText = ""; SparePartsMstBO bo = null; SparePartsMstVO vo =
	 * null; String temp[]=null; String temp1[]=null; HisUtil hisutil = null;
	 * String cmbstr = "";
	 * 
	 * try {
	 * 
	 * bo = new SparePartsMstBO(); vo = new SparePartsMstVO();
	 * 
	 * String strComboValues = request.getParameter("comboValue"); //
	 * //System.out.println("strComboValues-->"+strComboValues);
	 * 
	 * formBean.setStrComboValues(strComboValues); temp =
	 * strComboValues.replace('^', '#').split("#");
	 * 
	 * String strItemCategoryName = temp[0];
	 * formBean.setStrItemCatgName(strItemCategoryName); String strItemName =
	 * temp[1]; formBean.setStrItemName(strItemName);
	 * formBean.setStrModuleId(MmsConfigUtil.MODULE_ID);
	 * 
	 * String hosCode =
	 * request.getSession().getAttribute("HOSPITAL_CODE").toString();
	 * 
	 * String seatid = request.getSession().getAttribute("SEATID").toString();
	 * 
	 * String strItemCategoryId = formBean.getCombo()[0]; String strItemId =
	 * formBean.getCombo()[1];
	 * 
	 * temp1 = strItemCategoryId.replace('^', '#').split("#");
	 * 
	 * formBean.setStrHospitalCode(hosCode); formBean.setStrSeatId(seatid);
	 * formBean.setStrItemCatgNo(temp1[0]); formBean.setStrItemId(strItemId);
	 * 
	 * vo.setStrHospitalCode(hosCode); vo.setStrSeatId(seatid);
	 * vo.setStrItemCatgNo(temp1[0]); vo.setStrItemId(strItemId);
	 * vo.setStrModuleId(formBean.getStrModuleId());
	 * 
	 * bo.getUnitValues(vo); vo.getStrUnitNameComboWS();
	 * 
	 * if (vo.getStrMsgType().equals("1")) { throw new
	 * Exception(vo.getStrMsgString()); }
	 * 
	 * hisutil = new HisUtil("mms", "ItemSetsMstDATA");
	 * 
	 * if(vo.getStrUnitNameComboWS() != null &&
	 * vo.getStrUnitNameComboWS().size() > 0){ cmbstr =
	 * hisutil.getOptionValue(vo.getStrUnitNameComboWS(), vo.getStrUnitId(),
	 * "0^Select Value", false); }else{ cmbstr = "<option value='0'>Select
	 * Value</option>"; }
	 * 
	 * formBean.setStrUnitNameCombo(cmbstr); } catch (Exception e) { strmsgText =
	 * "ItemSetsMaster.ItemSetsMstDATA.unitName(vo) --> " + e.getMessage();
	 * HisException eObj = new HisException("mms",
	 * "ItemSetsMstDATA->unitName()", strmsgText);
	 * formBean.setStrErr("Application Error [ERROR ID : " + eObj.getErrorID() +
	 * "],Contact System Administrator! "); eObj = null; } finally { vo = null;
	 * bo = null; hisutil = null; } }
	 */

}
