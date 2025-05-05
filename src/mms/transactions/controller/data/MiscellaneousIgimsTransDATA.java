package mms.transactions.controller.data;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.transactions.bo.MiscellaneousIgimsTransBO;
import mms.transactions.controller.fb.MiscellaneousIgimsTransFB;
import mms.transactions.controller.hlp.MiscellaneousIgimsTransHLP;
import mms.transactions.vo.MiscellaneousIgimsTransVO;

/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 20/April/2009
 *  Module:MMS
 * Process: Miscellaneous Consumptions
 *
 */
/**
 * Developer : Tanvi Sappal Version : 1.0 Modify Date : 29/May/2009 Module:MMS
 * Process: Miscellaneous Consumptions
 *
 */

public class MiscellaneousIgimsTransDATA {

	/**
	 * This method is used to populate the value of Store Combo. for this activity
	 * this method called getInitialValues() methods which is define in
	 * MiscellaneousIgimsTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void getInitialValues(MiscellaneousIgimsTransFB formBean, HttpServletRequest request) {

		MiscellaneousIgimsTransBO bo = null;
		MiscellaneousIgimsTransVO vo = null;
		HisUtil hisutil = null;
		String strmsgText = "";

		String ctDate = "";
		String hosCode = "";
		String seatid = "";

		String strStoreNameValues = "";
		String strStoreComboId = "";
		String strCategoryValues = "";

		try {

			bo = new MiscellaneousIgimsTransBO();
			vo = new MiscellaneousIgimsTransVO();
			hisutil = new HisUtil("mms", "MiscellaneousConsumptionTransDATA");
			ctDate = hisutil.getASDate("dd-MMM-yyyy");

			ResourceBundle resObj = mms.qryHandler_mms.res;
			if (resObj == null) {
				resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
				mms.qryHandler_mms.res = resObj;
			}

			formBean.setStrCtDate(ctDate);

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			bo.getInitialValues(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			/* Changed By Niharika Srivastava on 21-sep-2010 */

			if (vo.getStoreNameValuesWS() != null && vo.getStoreNameValuesWS().size() > 0) {
				if (vo.getStoreNameValuesWS().next()) {
					vo.setStrStoreValId(vo.getStoreNameValuesWS().getString(1));
					formBean.setStrStoreId(vo.getStoreNameValuesWS().getString(1));
					vo.getStoreNameValuesWS().beforeFirst();
				}
				strStoreNameValues = hisutil.getOptionValue(vo.getStoreNameValuesWS(), "", "", true);
			} else {
				strStoreNameValues = "<option value='0'>Select Value</option>";
			}
			formBean.setStrStoreNameValues(strStoreNameValues);
			if (!formBean.getStrStoreId().equals(""))
				strStoreComboId = formBean.getStrStoreId();
			else
				strStoreComboId = request.getParameter("storeComboId");
			vo.setStrStoreValId(strStoreComboId);

			if (strStoreComboId.equals("0")) {
				strCategoryValues = "<option value='0'>Select Value</option>";
			} else {
				vo.setStrRequestType("54");

				bo.getItemCategoryCmb(vo);

				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				if (vo.getItemCategoryWS() != null && vo.getItemCategoryWS().size() > 0) {
					strCategoryValues = hisutil.getOptionValue(vo.getItemCategoryWS(), "10", "0^Select Value", true);
				} else {
					strCategoryValues = "<option value='0'>Select Value</option>";
				}
				formBean.setStrItemCategoryValues(strCategoryValues);
				formBean.setStrReOrderFlgColor(resObj.getString("RE_ORDER_COLOR"));
			}
		} catch (Exception e) {
			e.printStackTrace();

			strmsgText = "hisglobaltransactionutil.MiscellaneousConsumptionTransDATA.getInitialValues(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms", "MiscellaneousConsumptionTransDATA->getInitialValues()",
					strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	/**
	 * This method is used to populate the value of Item Category Combo . For this
	 * activity this method call the method getItemCategoryCmb() which is define in
	 * MiscellaneousIgimsTransBO java file
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getItemCategoryCmb(MiscellaneousIgimsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		MiscellaneousIgimsTransBO bo = null;
		MiscellaneousIgimsTransVO vo = null;
		HisUtil hisutil = null;

		String strmsgText = "";
		String hosCode = "";
		String strItemCatValues = "";
		String strStoreComboId = "";
		String strRequestType = "";

		try {
			bo = new MiscellaneousIgimsTransBO();
			vo = new MiscellaneousIgimsTransVO();

			strStoreComboId = request.getParameter("storeComboId");
			strRequestType = "54";

			//// System.out.println("strRequestType-->"+strRequestType);

			hisutil = new HisUtil("mms", "MiscellaneousConsumptionTransDATA");

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			vo.setStrHospitalCode(hosCode);

			vo.setStrStoreValId(strStoreComboId);

			vo.setStrRequestType(strRequestType);

			bo.getItemCategoryCmb(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getItemCategoryWS() != null && vo.getItemCategoryWS().size() > 0) {
				strItemCatValues = hisutil.getOptionValue(vo.getItemCategoryWS(), "10", "0^Select Value", true);
			} else {
				strItemCatValues = "<option value='0'>Select Value</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strItemCatValues);

			} catch (Exception e) {
				// TODO Auto-generated catch block

			}

		} catch (Exception e) {
			strmsgText = "transactions.MiscellaneousConsumptionTransDATA.getItemCategoryCmb(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "MiscellaneousConsumptionTransDATA->getItemCategoryCmb()",
					strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : " + eObj.getErrorID()
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
	 * This method is used to populate the value of Group name combo box and this
	 * method calls the getGroupNameValues() method which is define in
	 * MiscellaneousIgimsTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void getGroupNameCmb(MiscellaneousIgimsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		MiscellaneousIgimsTransBO bo = null;
		MiscellaneousIgimsTransVO vo = null;
		HisUtil hisutil = null;

		String strmsgText = "";
		String hosCode = "";
		String strGroupNameValues = "";
		String strItemCatComboId = "";

		try {
			bo = new MiscellaneousIgimsTransBO();
			vo = new MiscellaneousIgimsTransVO();

			strItemCatComboId = request.getParameter("itemCatId");

			hisutil = new HisUtil("mms", "MiscellaneousConsumptionTransDATA");

			hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrItemCategoryId(strItemCatComboId);

			bo.getGroupNameValues(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getGroupNameWS() != null && vo.getGroupNameWS().size() > 0) {
				strGroupNameValues = hisutil.getOptionValue(vo.getGroupNameWS(), "", "0^Select Value", true);
			} else {
				strGroupNameValues = "<option value='0'>Select Value</option>";
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strGroupNameValues);

			} catch (Exception e) {

			}

		} catch (Exception e) {
			strmsgText = "transactions.MiscellaneousConsumptionDATA.getGroupNameCmb(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "MiscellaneousConsumptionDATA->getGroupNameCmb()", strmsgText);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print("ERROR#### Application Error [ERROR ID : " + eObj.getErrorID()
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
	 * This method is used to insert the Miscellaneous Consumptions in database for
	 * this activity this function call the insertMissConsumpRecord()method which is
	 * define in MiscellaneousIgimsTransBO java file.
	 * 
	 * @param formBean
	 * @param request
	 * @param response
	 */
	public static void insertMiscConsumpRecord(MiscellaneousIgimsTransFB formBean, HttpServletRequest request,
			HttpServletResponse response) {

		MiscellaneousIgimsTransBO bo = null;
		MiscellaneousIgimsTransVO vo = null;
		MmsConfigUtil mcu = null;
		String strmsgText = "";
		String strTemp[] = null;
		String[] strInsertValue = null;
		String strItemIdArray[] = null;
		String[] strBrandIdArray = null;
		String[] strStockStatusArray = null;
		String strBatchSlNoArray[] = null;
		String strInhandQtyArray[] = null;
		String[] strInhandQtyUnitArray = null;
		String[] strConsumptionQTY = null;
		String[] strConsumptionQtyUnitID = null;
		String[] UnitID = null;
		String[] strMRP = null;
		String[] strPur = null;
		HisUtil hisutil = null;

		try {
			bo = new MiscellaneousIgimsTransBO();

			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			mcu = new MmsConfigUtil(formBean.getStrHospitalCode());
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

			formBean.setStrFinancialStartDate(
					mcu.getStrFinancialStartDate(formBean.getStrStoreId(), formBean.getStrHospitalCode()));
			formBean.setStrFinancialEndDate(
					mcu.getStrFinancialEndDate(formBean.getStrStoreId(), formBean.getStrHospitalCode()));

			hisutil = new HisUtil("mms", "MiscellaneousConsumptionTransDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			vo = (MiscellaneousIgimsTransVO) TransferObjectFactory
					.populateData("mms.transactions.vo.MiscellaneousIgimsTransVO", formBean);

			int nMultiRowLen = vo.getStrConsumptionQty().length;

			strConsumptionQTY = new String[nMultiRowLen];
			strConsumptionQtyUnitID = new String[nMultiRowLen];
			strItemIdArray = new String[nMultiRowLen];
			strInhandQtyArray = new String[nMultiRowLen];
			strBatchSlNoArray = new String[nMultiRowLen];
			strInhandQtyUnitArray = new String[nMultiRowLen];
			strBrandIdArray = new String[nMultiRowLen];
			strStockStatusArray = new String[nMultiRowLen];
			strMRP = new String[nMultiRowLen];
			strPur = new String[nMultiRowLen];
			for (int i = 0; i < nMultiRowLen; i++) {

				strTemp = vo.getItemParamValue()[i].split("#");

				//// System.out.println("Inserted Vlue-->"+strTemp[2]);
				// 18000005^18100008^181001^181001100^0^0^0^1^6301^12000^6301^6301^123^21-DEC-10^1810003^~06/01/2011
				//// 01:01:29^^06-JAN-11^CDAC/HIS/11/0009^0^0^0^0^0^0^0^0^^0^0^0^0^10^150000^6301^1^1^0
				// strDisplayValue = strTemp[0].replace("^", "#").split("#");
				strInsertValue = strTemp[2].replace("^", "#").split("#");

				//// System.out.println("Batch No::::"+strInsertValue[15]);
				strItemIdArray[i] = strInsertValue[0];
				strBatchSlNoArray[i] = strInsertValue[15];
				strInhandQtyArray[i] = strInsertValue[7];
				strInhandQtyUnitArray[i] = strInsertValue[8];
				strBrandIdArray[i] = strInsertValue[1];
				strStockStatusArray[i] = strInsertValue[32];
				strMRP[i] = strInsertValue[9];
				strPur[i] = strInsertValue[41];
				UnitID = vo.getStrUnitName()[i].replace('^', '#').split("#");
				strConsumptionQTY[i] = formBean.getStrConsumptionQty()[i];
				strConsumptionQtyUnitID[i] = UnitID[0];

			}

			vo.setStrStoreValId(formBean.getStrStoreId());

			vo.setStrItemCategoryId(formBean.getStrItemCategoryId1());
			vo.setStrRequestType("54");
			vo.setStrItemId(strItemIdArray);
			vo.setStrItemBrandId(strBrandIdArray);
			vo.setStrBatchSlNo(strBatchSlNoArray);
			vo.setStrInhandQty(strInhandQtyArray);
			vo.setStrInhandQtyUnitId(strInhandQtyUnitArray);
			vo.setStrConsumptionQty(strConsumptionQTY);
			vo.setStrUnitName(strConsumptionQtyUnitID);
			vo.setStrFinancialStartDate(formBean.getStrFinancialStartDate());
			vo.setStrFinancialEndDate(formBean.getStrFinancialEndDate());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrConsumptionDate(formBean.getStrCtDate());
			vo.setStrReservedFlag("1");
			vo.setStrStockStatusCode(strStockStatusArray);
			vo.setStrIsValid("1");
			vo.setStrMRP(strMRP);
			vo.setStrPur(strPur);
			bo.insertMiscConsumpRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				if (vo.getStrMsgString().split("\\##")[2].equals("999")) {
					formBean.setStrErrMsg(vo.getStrMsgString().split("\\##")[1]);
				} else {
					formBean.setStrErrMsg(vo.getStrMsgString());
					throw new Exception(vo.getStrMsgString());
				}
			}

			else {
				formBean.setStrNormalMsg("Consumption [" + vo.getStrConsumpNo() + "] Saved Successfully");
				formBean.setStrConsmpStoreId(vo.getStrStoreValId());
				formBean.setStrConsumptionNo(vo.getStrConsumpNo());
				formBean.setStrConsumptionPuk(vo.getStrIndentNo());
				formBean.setStrConsumptionPatientName(vo.getStrPatientName());

			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "hisglobaltransactionutil.MiscellaneousConsumptionTransDATA.insertMiscConsumpRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms", "MiscellaneousConsumptionTransDATA->insertMiscConsumpRecord()",
					strmsgText);
			formBean.setStrErrMsg(
					"Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			mcu = null;
			hisutil = null;
		}

	}

	public static void issueDtlsInitNEW(HttpServletRequest request, HttpServletResponse response,
			MiscellaneousIgimsTransFB formBean) {
		MiscellaneousIgimsTransBO bo = null;
		MiscellaneousIgimsTransVO vo = null;

		try {

			String strStoreValId = (String) request.getParameter("strStoreId");
			String strConsumpNo = (String) request.getParameter("strIssueNo");
			String crNo = (String) request.getParameter("strCrNo") == null ? "0"
					: (String) request.getParameter("strCrNo");

			bo = new MiscellaneousIgimsTransBO();
			vo = new MiscellaneousIgimsTransVO();

			vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

			System.out.println(
					"---- MiscellaneousConsumptionTransDATA . issueDtlsInitNEW --[ pkg_mms_view.proc_issue_detail ]--");
			System.out.println("----------------------------------");
			System.out.println("--strFromStoreId ----" + strStoreValId);
			System.out.println("--strConsumpNo     ----" + strConsumpNo);
			System.out.println("--crNo           ----" + crNo);
			System.out.println("----------------------------------");

			vo.setStrStoreValId(strStoreValId);
			vo.setStrConsumpNo(strConsumpNo);
			vo.setStrIndentNo(crNo);

			bo.getIssueDtlsInitDtls(vo); // pkg_mms_view.Proc_Emp_Issue_Detail [ Mode - 3 ]

			if (vo.getStrMsgType().equals("1"))
				throw new Exception(vo.getStrMsgString());

			System.out.println("-WsIssueDetails --Size in HLP ----" + vo.getWsIssueDetails().size());
			/*
			 * 1. Issue No 2. Issue Date 3. Pat Name 4. Store Name 5. Generic Name 6. Brnad
			 * Name 7. BATCH 8. EXP Date 9. Rate / Unit 10. Issue Qty Wth Unit 11. Store Id
			 * 12. Item Id 13. Brand Id 14. BATCH 15. Exp Date 16. Rate 17. Rate Unit Id 18.
			 * Rate Base Value 19. Base Vale 20. Issue Qty Unit Id 21. Qty Base Value 22. Sl
			 * Npo 23. NVL 24. Catg Code 25. Bal Qty 26. NVL 27. Remarks 28. Rec By 29.
			 * HSTNUM_TOTAL_COST 30. Budget 31. NVL 32. Issue Date 33. MRP of Drug 34. Total
			 * Purchase Cost 35. Cr No 36. Issue By User Name 37. Order By 38. Hosp Name 39.
			 * HSTSTR_LOCATION
			 */

			while (vo.getWsIssueDetails().next()) {
				vo.setStrPatientName(vo.getWsIssueDetails().getString(3));
				vo.setStrUserName(vo.getWsIssueDetails().getString(36));
				vo.setStrIndentIssueDate(vo.getWsIssueDetails().getString(2));
				vo.setStrStoreName(vo.getWsIssueDetails().getString(4));
				vo.setStrIndentNo(
						vo.getWsIssueDetails().getString(35) == null || vo.getWsIssueDetails().getString(35).equals("")
								? "NA"
								: vo.getWsIssueDetails().getString(35));

			}
			vo.getWsIssueDetails().beforeFirst();

			System.out.println("---  LPIssueDeskTransHLP.getIssueDtlsInitView  ----");

			String strAfterSaveVoucher = MiscellaneousIgimsTransHLP.getAfterSaveVoucher(vo, "1");
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(strAfterSaveVoucher);
			System.out.println("---- MiscellaneousConsumptionTransDATA . issueDtlsInitNEW --[ END ]--");

		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = "MmsDATA.issueDtlsInit(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms", "MmsDATA.issueDtlsInit(vo) --> ", strmsgText);
			eObj.printStackTrace();
			eObj = null;

		} finally {

			bo = null;
			vo = null;
		}
	}
	public static void initViewPageDtl(MiscellaneousIgimsTransFB fb,HttpServletRequest request)
	{
	       String strmsgText = "";
	       MiscellaneousIgimsTransBO bo = null;
		   MiscellaneousIgimsTransVO vo = null;
		   HisUtil hisUtil;
		   try
		   {
			   hisUtil = new HisUtil("MMS", "MiscellaneousConsumptionTransDATA");
			    vo=new MiscellaneousIgimsTransVO();
			   	bo=new MiscellaneousIgimsTransBO();
			   	
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			   	
			   	bo.initForViewPage(vo);
			   
			   	fb.setStrStoreName(vo.getStrStoreName());
			   	
			   	fb.setStrCurrentDate(hisUtil.getASDate("dd-MMM-yyyy"));
			 
			   				   
				fb.setStrStoreName(vo.getStrStoreName());
				fb.setStrHospitalCode(vo.getStrHospitalCode());
				fb.setStrSeatId(vo.getStrSeatId());
					 
			   	
			   
			   
		   }catch(Exception _err)
		   {
			   _err.printStackTrace();
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "BreakageItemDtlTransDATA->initViewPageDtl()", strmsgText);
				fb.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				fb.setStrMsgType("1");
				eObj = null;
		   }
		   
	}
	
	public static void getViewDtlNEW(MiscellaneousIgimsTransFB formBean,HttpServletRequest request,HttpServletResponse response)
	{
		 /* Declaring Variables */
	       String strmsgText = "";
		   MiscellaneousIgimsTransVO vo = null;
		   MiscellaneousIgimsTransBO bo = null;
		   try
		   {
			    /* Creating Object */   	
			    vo=new MiscellaneousIgimsTransVO();
			   	bo=new MiscellaneousIgimsTransBO();
			   	/* Value set in Value Object */
			   	vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			   	vo.setStrStoreName(request.getParameter("storeId"));
			   	vo.setStrCrNo(request.getParameter("itemCatNo"));
			   	vo.setStrFromDate(request.getParameter("fromDate"));
			   	vo.setStrToDate(request.getParameter("ToDate"));
                
                /* Calling BO method */
			    bo.setViewPageDtl(vo);
			    
			    String strResult = MiscellaneousIgimsTransHLP.getIssuedDetailNEW(vo.getIssueNoDtlWs());
			    
			    System.out.println("---  strResult  ----"+strResult);

			    if(strResult!= null && !strResult.equals(""))
				{	
				 	response.setHeader("Cache-Control", "no-cache");
				 	response.getWriter().print(strResult);
				 		 
				}
				else
				{
				    HisException eObj = new HisException("MMS", "MiscellaneousConsumptionTransDATA->getViewDtl()", vo.getStrMsgString());
					String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
					response.getWriter().print(str);
		    	 }
			   
			   
		   }catch(Exception _err){
			   strmsgText = _err.getMessage();
				HisException eObj = new HisException("MMS", "MiscellaneousConsumptionTransDATA->getViewDtl()", strmsgText);
				formBean.setStrErrMsg("ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ");
				formBean.setStrMsgType("1");
				eObj = null;
		   }
		   
	}

}
