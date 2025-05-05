package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.bo.SetSachetDetailsTransBO;
import mms.transactions.controller.fb.SetSachetDetailsTransFB;
import mms.transactions.controller.hlp.SetSachetDetailsTransHLP;
import mms.transactions.vo.SetSachetDetailsTransVO;
import mms.MmsConfigUtil;

/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 23/Jan/2009
 *  Module:MMS
 * Unit:Set/Sachet Details
 *
 */

/**
 * Developer : Anshul Jindal Version : 2.0 Date : 11/May/2009 Module:MMS
 * Unit:Set/Sachet Details
 * 
 */

public class SetSachetDetailsTransDATA {

	/**
	 * This method is used to populate the value of Store name combo box and
	 * this method calls the getInitialValues() method which is define in
	 * SetSachetDetailsTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void getInitialValues(SetSachetDetailsTransFB formBean,
			HttpServletRequest request,HttpServletResponse response) {

		SetSachetDetailsTransBO bo = null;
		SetSachetDetailsTransVO vo = null;
		HisUtil hisutil = null;
		String strmsgText = "";

		String ctDate = "";
		String hosCode = "";
		String seatid = "";

		String strStoreNameValues = "";

		try {

			bo = new SetSachetDetailsTransBO();
			vo = new SetSachetDetailsTransVO();
			hisutil = new HisUtil("mms", "SetSachetDetailsTransDATA");
			ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			seatid = request.getSession().getAttribute("SEATID").toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			bo.getInitialValues(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getStoreNameValuesWS() != null
					&& vo.getStoreNameValuesWS().size() > 0) {
				if(vo.getStoreNameValuesWS().next())
				{
				vo.setStrStoreId(vo.getStoreNameValuesWS().getString(1));
				formBean.setStrStoreId(vo.getStoreNameValuesWS().getString(1));
				vo.getStoreNameValuesWS().beforeFirst();
				}
				strStoreNameValues = hisutil.getOptionValue(vo.getStoreNameValuesWS(), "", "", true);
			} else {
				strStoreNameValues = "<option value='0'>Select Value</option>";
			}
			formBean.setStrStoreNameValues(strStoreNameValues);
			
			String strCategoryValues = "";
			String strStoreComboId = "";
			if(!formBean.getStrStoreId().equals(""))
				strStoreComboId = formBean.getStrStoreId();
			else
					strStoreComboId = request.getParameter("storeComboId");
			vo.setStrStoreId(strStoreComboId);
			if (strStoreComboId.equals("0")) 
			{
				strCategoryValues = "<option value='0'>Select Value</option>";
			} 
			else 
			{
				bo.getCategoryValues(vo);
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				if (vo.getStrCategoryValuesWS() != null && vo.getStrCategoryValuesWS().size() > 0) 
				{
					if(vo.getStrCategoryValuesWS().next())
					{
						vo.setStrSetCategoryNo(vo.getStrCategoryValuesWS().getString(1));
						formBean.setStrSetCategoryNo(vo.getStrCategoryValuesWS().getString(1));
						vo.getStrCategoryValuesWS().beforeFirst();
					}
					strCategoryValues = hisutil.getOptionValue(vo.getStrCategoryValuesWS(), "", "",true);
				} 
				else 
				{
					strCategoryValues = "<option value='0'>Select Value</option>";
					vo.setStrSetCategoryNo("0");
					formBean.setStrSetCategoryNo("0");
				}
				formBean.setStrCategoryValues(strCategoryValues);
				String strGroupNameValues = "";
				if(!vo.getStrSetCategoryNo().equals("0") && !vo.getStrSetCategoryNo().equals(""))
				bo.getGroupNameValues(vo);
				if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
				}
				if (vo.getStrGroupNameValuesWS() != null && vo.getStrGroupNameValuesWS().size() > 0) 
				{
					if(vo.getStrGroupNameValuesWS().next())
					{
						vo.setStrGroupId(vo.getStrGroupNameValuesWS().getString(1));
						formBean.setStrGroupId(vo.getStrGroupNameValuesWS().getString(1));
						vo.getStrGroupNameValuesWS().beforeFirst();
					}
					strGroupNameValues = hisutil.getOptionValue(vo.getStrGroupNameValuesWS(), "0","0^Select Value", true);
					} 
				else 
				{
						strGroupNameValues = "<option value='0'>Select Value</option>";
						vo.setStrGroupId("0");
						formBean.setStrGroupId("0");
				}
				formBean.setStrGroupNameValues(strGroupNameValues);
				/*
				String strSubGroupNameValues = "";
				if(!vo.getStrGroupId().equals("0") && !vo.getStrGroupId().equals(""))
				bo.getSubGroupNameValues(vo);

					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}
					if (vo.getStrSubGroupNameValuesWS() != null && vo.getStrSubGroupNameValuesWS().size() > 0) 
					{
						if(vo.getStrSubGroupNameValuesWS().next())
						{
							vo.setStrSubGroupId(vo.getStrSubGroupNameValuesWS().getString(1));
							formBean.setStrSubGroupId(vo.getStrSubGroupNameValuesWS().getString(1));
							vo.getStrSubGroupNameValuesWS().beforeFirst();
						}
						strSubGroupNameValues = hisutil.getOptionValue(vo.getStrSubGroupNameValuesWS(), "", "0^All", true);
					} 
					else 
					{
						strSubGroupNameValues = "<option value='0'>All</option>";
						vo.setStrSubGroupId("0");
						formBean.setStrSubGroupId("0");						
					}
					formBean.setStrSubGroupNameValues(strSubGroupNameValues);
					String strSetSachetNameValues = "";
					if(!vo.getStrSubGroupId().equals("0") && !vo.getStrSubGroupId().equals(""))
					bo.getSachetNameValues(vo);
					if (vo.getStrMsgType().equals("1")) {
						throw new Exception(vo.getStrMsgString());
					}
					if (vo.getStrSetSachetNameValuesWS() != null && vo.getStrSetSachetNameValuesWS().size() > 0) {
						strSetSachetNameValues = hisutil.getOptionValue(vo.getStrSetSachetNameValuesWS(), "", "0^Select Value",true);
					} 
					else 
					{
						strSetSachetNameValues = "<option value='0'>Select Value</option>";
					}
					formBean.setStrSetSachetNameValues(strSetSachetNameValues);*/
			}
		} catch (Exception e) {

			strmsgText = "hisglobaltransactionutil.SetSachetDetailsTransDATA.getInitialValues(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SetSachetDetailsTransDATA->getInitialValues()", strmsgText);
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
	 * This method is used to populate the value of Group name combo box and
	 * this method calls the getGroupNameValues() method which is define in
	 * SetSachetDetailsTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getGroupNameCmb(SetSachetDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		SetSachetDetailsTransBO bo = null;
		SetSachetDetailsTransVO vo = null;
		HisUtil hisutil = null;

		String strmsgText = "";
		String hosCode = "";
		String strGroupNameValues = "";
		String strCategoryNo = "";
	

		try {
			bo = new SetSachetDetailsTransBO();
			vo = new SetSachetDetailsTransVO();
			/*
			 * strStoreComboId = request.getParameter("storeComboId"); temp =
			 * strStoreComboId.replace("^", "#").split("#");
			 * 
			 * strStoreTypeId = temp[1];
			 */

			strCategoryNo = request.getParameter("CategoryNo");
			hisutil = new HisUtil("mms", "SetSachetDetailsTransDATA");

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSetCategoryNo(strCategoryNo);
			// vo.setStrStoreTypeId(strStoreTypeId);

			bo.getGroupNameValues(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getStrGroupNameValuesWS() != null
					&& vo.getStrGroupNameValuesWS().size() > 0) {
				strGroupNameValues = hisutil
						.getOptionValue(vo.getStrGroupNameValuesWS(), "0",
								"0^Select Value", true);
			} else {
				strGroupNameValues = "<option value='0'>Select Value</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strGroupNameValues);

			} catch (Exception e) {
				// TODO Auto-generated catch block

			}

		} catch (Exception e) {
			strmsgText = "transactions.SetSachetDetailsTransDATA.getGroupNameCmb(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SetSachetDetailsTransDATA->getGroupNameCmb()", strmsgText);
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
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	/**
	 * This method is used to populate the value of Category name combo box and
	 * this method calls the getGroupNameValues() method which is define in
	 * SetSachetDetailsTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getCategoryNameCmb(SetSachetDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		SetSachetDetailsTransBO bo = null;
		SetSachetDetailsTransVO vo = null;
		HisUtil hisutil = null;

		String strmsgText = "";
		String hosCode = "";
		String strCategoryValues = "";
		String strStoreComboId = "";
	

		try {
			bo = new SetSachetDetailsTransBO();
			vo = new SetSachetDetailsTransVO();

			strStoreComboId = request.getParameter("storeComboId");
			// temp = strStoreComboId.replace("^", "#").split("#");

			// strStoreId = temp[0];
			hisutil = new HisUtil("mms", "SetSachetDetailsTransDATA");

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrStoreId(strStoreComboId);

			if (strStoreComboId.equals("0")) {
				strCategoryValues = "<option value='0'>Select Value</option>";
			} else {
				bo.getCategoryValues(vo);

				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				if (vo.getStrCategoryValuesWS() != null
						&& vo.getStrCategoryValuesWS().size() > 0) {
					if(vo.getStrCategoryValuesWS().size()==1)
					strCategoryValues = hisutil.getOptionValue(vo.getStrCategoryValuesWS(), "", "",true);
					else
						strCategoryValues = hisutil.getOptionValue(vo.getStrCategoryValuesWS(), "0", "0^Select Value",true);
				} else {
					strCategoryValues = "<option value='0'>Select Value</option>";
				}
			}
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strCategoryValues);

			} catch (Exception e) {
				// TODO Auto-generated catch block

			}

		} catch (Exception e) {
			strmsgText = "transactions.SetSachetDetailsTransDATA.getCategoryNameCmb(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SetSachetDetailsTransDATA->getCategoryNameCmb()",
					strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block

			}

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	/**
	 * This method is used to populate the value of Sub Group name combo box and
	 * this method calls the getSubGroupNameValues() method which is define in
	 * SetSachetDetailsTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getSubGroupNameCmb(SetSachetDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		SetSachetDetailsTransBO bo = null;
		SetSachetDetailsTransVO vo = null;
		HisUtil hisutil = null;

		String strmsgText = "";

		String hosCode = "";

		String strSubGroupNameValues = "";
		String strGroupComboId = "";

		try {
			bo = new SetSachetDetailsTransBO();
			vo = new SetSachetDetailsTransVO();

			strGroupComboId = request.getParameter("GroupComboId");
			hisutil = new HisUtil("mms", "SetSachetDetailsTransDATA");
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			vo.setStrHospitalCode(hosCode);
			vo.setStrGroupId(strGroupComboId);
			bo.getSubGroupNameValues(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getStrSubGroupNameValuesWS() != null
					&& vo.getStrSubGroupNameValuesWS().size() > 0) {
				strSubGroupNameValues = hisutil.getOptionValue(vo
						.getStrSubGroupNameValuesWS(), "", "0^All", true);
			} else {
				strSubGroupNameValues = "<option value='0'>All</option>";
			}
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strSubGroupNameValues);

			} catch (Exception e) {
				// TODO Auto-generated catch block
			}

		} catch (Exception e) {
			strmsgText = "transactions.SetSachetDetailsTransDATA.getSubGroupNameCmb(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SetSachetDetailsTransDATA->getSubGroupNameCmb()",
					strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block

			}

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	/**
	 * This method is used to populate the value of Set/Sachet name combo box
	 * and this method calls the getSachetNameValues() method which is define in
	 * SetSachetDetailsTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getSetSachetNameCmb(SetSachetDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		SetSachetDetailsTransBO bo = null;
		SetSachetDetailsTransVO vo = null;
		HisUtil hisutil = null;

		String strmsgText = "";

		String hosCode = "";

		String strSetSachetNameValues = "";
		String strCategoryNo = "";
		String strGroupId = "";
		String strSubGroupId = "";

		try {
			bo = new SetSachetDetailsTransBO();
			vo = new SetSachetDetailsTransVO();

			strCategoryNo = request.getParameter("CategoryNo");
			strGroupId = request.getParameter("GroupComboId");
			strSubGroupId = request.getParameter("SubGroupId");
			hisutil = new HisUtil("mms", "SetSachetDetailsTransDATA");
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSetCategoryNo(strCategoryNo);
			vo.setStrGroupId(strGroupId);
			vo.setStrSubGroupId(strSubGroupId);

			bo.getSachetNameValues(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getStrSetSachetNameValuesWS() != null
					&& vo.getStrSetSachetNameValuesWS().size() > 0) {
				strSetSachetNameValues = hisutil.getOptionValue(vo
						.getStrSetSachetNameValuesWS(), "", "0^Select Value",
						true);
			} else {
				strSetSachetNameValues = "<option value='0'>Select Value</option>";
			}
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strSetSachetNameValues);

			} catch (Exception e) {
				// TODO Auto-generated catch block
			}

		} catch (Exception e) {
			strmsgText = "transactions.SetSachetDetailsTransDATA.getSetSachetNameCmb(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SetSachetDetailsTransDATA->getSetSachetNameCmb()",
					strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block

			}

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	/**
	 * This method is used to display the value of tItem Details and this method
	 * calls the getItemDetails() method which is define in
	 * SetSachetDetailsTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getItemDetails(SetSachetDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		SetSachetDetailsTransBO bo = null;
		SetSachetDetailsTransVO vo = null;
		String strmsgText = "";
		String hosCode = "";
		String strSetId = "";

		String ItemDetails = "";
		String strPreparedQty = "";

		try {
			bo = new SetSachetDetailsTransBO();
			vo = new SetSachetDetailsTransVO();

			strSetId = request.getParameter("setId");

			strPreparedQty = request.getParameter("strPreparedQty");
			String strStoreId = request.getParameter("storeComboId");
			 
			// //System.out.println("strPreparedQty-"+strPreparedQty);
			hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSetSachetId(strSetId);
			vo.setStrPreparedQty(strPreparedQty);
			vo.setStrStoreId(strStoreId);
			bo.getItemDetails(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			// //System.out.println("vo.getStrItemListWS().size-"+vo.getStrItemListWS().size());
			ItemDetails = SetSachetDetailsTransHLP.getItemDetails(vo
					.getStrPreparedQty(), vo.getStrHospitalCode(), vo
					.getStrItemListWS());

			// //System.out.println("data ItemDetails-"+ItemDetails);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(ItemDetails);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		} catch (Exception e) {
			strmsgText = "transactions.SetSachetDetailsTransDATA.getItemDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SetSachetDetailsTransDATA->getItemDetails()",
					strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");

			} catch (Exception e1) {
				// TODO Auto-generated catch block

			}

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * This method is used to insert the value of tItem Details and set/sachet
	 * details in database and this method calls the insertSachetValues() method
	 * which is define in SetSachetDetailsTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void insertSetSachetDetails(SetSachetDetailsTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		SetSachetDetailsTransBO bo = null;
		SetSachetDetailsTransVO vo = null;
		MmsConfigUtil mcu = null;

		String strmsgText = "";

		String hosCode = "";
		String seatid = "";

		String strFinancialStartYear = "";
		String strFinancialEndYear = "";

		String strStoreId = "";

		int chkLength = 0;
		String[] values = null;
		String temp[] = null;
		
		String strItemIdArray[] = null;
		String strBrandIdArray[] = null;
		String strItemCategory[] = null;
		String strReqQtyArray[] = null;
		String strReqQtyWithPrepQtyArray[] = null;
		String strReqQtyinInvUnitArray[] = null;
		String strReqQtyUnitIdArray[] = null;
		String strInvUnitIdArray[] = null;

		try {
			bo = new SetSachetDetailsTransBO();
			vo = new SetSachetDetailsTransVO();
			mcu = new MmsConfigUtil(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			chkLength = formBean.getStrItemDetailsChk().length;

			strBrandIdArray = new String[chkLength];
			strReqQtyArray = new String[chkLength];
			strReqQtyUnitIdArray = new String[chkLength];
			strItemIdArray = new String[chkLength];
			strItemCategory = new String[chkLength];
			strInvUnitIdArray = new String[chkLength];
			strReqQtyinInvUnitArray = new String[chkLength];
			strReqQtyWithPrepQtyArray = new String[chkLength];
			//strRateArray = new String[chkLength];

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			seatid = request.getSession().getAttribute("SEATID").toString();

			strStoreId = formBean.getStrStoreId();

			strFinancialStartYear = mcu.getStrFinancialStartDate(strStoreId , hosCode);
			strFinancialEndYear = mcu.getStrFinancialEndDate(strStoreId , hosCode);
			

			vo.setStrFinancialStartYear(strFinancialStartYear);
			vo.setStrFinancialEndYear(strFinancialEndYear);
			vo.setStrQtyUnitId(MmsConfigUtil.UNIT_ID);
			
			vo.setStrStoreId(strStoreId);
			vo.setStrHospitalCode(hosCode);
			temp = formBean.getStrSetSachetId().replace("^", "#").split("#");
			
			vo.setStrSetGenericItemId(temp[0]);
			vo.setStrSetSachetId(temp[1]);
			vo.setStrSetCategoryNo(formBean.getStrSetCategoryNo());
			vo.setStrSeatId(seatid);
			vo.setStrGroupId(formBean.getStrGroupId());
			vo.setStrSubGroupId(formBean.getStrSubGroupId());
			vo.setStrPreparedQty(formBean.getStrPreparedQty());
			vo.setStrExpiryDate(formBean.getStrExpiryDate());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrCost(formBean.getStrCost()); // each item rate

		
			vo.setStrSetUnitId(MmsConfigUtil.UNIT_ID);
			for (int i = 0; i < chkLength; i++) {

				values = formBean.getStrItemDetailsChk()[i].replace("^", "#")
						.split("#");
				strItemIdArray[i] = values[0];
				strBrandIdArray[i] = values[1];
				strItemCategory[i] = values[2];
				strReqQtyinInvUnitArray[i] = values[3]; // value in inventory
														// unit
				strReqQtyArray[i] = values[4];
				//strReqQtyUnitIdArray[i] = values[6];
				strReqQtyUnitIdArray[i] = MmsConfigUtil.UNIT_ID;

				if (values[7].equals("") || values[7] == null
						|| values[7].equals("0"))
					values[7] = values[6];


			//	strInvUnitIdArray[i] = values[7];
				strInvUnitIdArray[i]  = MmsConfigUtil.UNIT_ID;

				//strInvUnitIdArray[i] = values[7];
				strInvUnitIdArray[i] = MmsConfigUtil.UNIT_ID;
				// req qty of 1 item = req qty * prep qty
				strReqQtyWithPrepQtyArray[i] = Double.toString(Double
						.parseDouble(strReqQtyinInvUnitArray[i])
						* Double.parseDouble(vo.getStrPreparedQty()));

				
			}
			vo.setStrSalePriceArray(formBean.getStrSalePrice());
			vo.setStrItemIdArray(strItemIdArray);
			vo.setStrBrandIdArray(strBrandIdArray);
			vo.setStrCategoryNoArray(strItemCategory);

			vo.setStrReqQtyArray(strReqQtyArray);
			vo.setStrReqQtyUnitIdArray(strReqQtyUnitIdArray);

			vo.setStrReqQtyInInvUnitArray(strReqQtyinInvUnitArray);
			vo.setStrInvUnitIdArray(strInvUnitIdArray);

			vo.setStrReqQtyWithPrepQtyArray(strReqQtyWithPrepQtyArray); // req
			bo.insertData(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			else {
				formBean.setStrMsg("Data Saved Successfully");
			}

		} catch (Exception e) {
			e.printStackTrace();

			strmsgText = "hisglobaltransactionutil.SetSachetDetailsTransDATA.insertSetSachetDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SetSachetDetailsTransDATA->insertSetSachetDetails()",
					strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			mcu = null;
		}

	}

}
