package mms.transactions.controller.data;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.upload.FormFile;
import org.apache.commons.collections.MultiMap;
import org.apache.commons.collections.map.MultiValueMap; 
import org.json.JSONObject;

import com.google.common.collect.LinkedHashMultimap;

import mms.AttachFileGlobal;
import mms.MmsConfigUtil;
import mms.transactions.bo.ChallanProcessTransBO;
import mms.transactions.bo.NewChallanProcessTransBO;
import mms.transactions.controller.fb.NewChallanProcessTransFB;
import mms.transactions.controller.hlp.ChallanProcessTransBSHLP;
import mms.transactions.controller.hlp.ChallanProcessTransHLP;
import mms.transactions.controller.hlp.NewChallanProcessTransHLP;
import mms.transactions.vo.ChallanProcessTransVO;
import mms.transactions.vo.NewChallanProcessTransVO;

/**
 * 
 * Developer : Balasubramaniam M Version : 1.0 Date : 12-Jun-2009
 * 
 */

public class NewChallanProcessTransBSDATA {

	public static void receiveChallanInit(NewChallanProcessTransFB formBean,
			HttpServletRequest request) {

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		String strmsgText = "";
		String strReceivedByOptionVal="";
		String strDeliveryModeOptionVal="";
		HisUtil hisutil = null;

		try {
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();

			hisutil = new HisUtil("mms", "ChallanProcessTransDATA");

			if (formBean.getComboValue() != null && !formBean.getComboValue().equals(""))
			{

				String strCmbNames = formBean.getComboValue();
				String[] temp = strCmbNames.replace("^", "#").split("#");
				formBean.setStrStoreName(temp[0]);

			}

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strStoreId = formBean.getCombo()[0];
			
			String strPoNoDtls[] = formBean.getCombo()[2].replace("^", "#").split("#");

			vo.setStrStoreName(formBean.getStrStoreName());
			vo.setStrPoNo(strPoNoDtls[0]);
			vo.setStrPoStoreId(strPoNoDtls[1]);
			vo.setStrPoDate(strPoNoDtls[2]);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);

			bo.receiveInit(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo
						.setStrMsgString("NewChallanProcessTransDATA.receiveChallanInit() --> "
								+ vo.getStrMsgString());
			}

			TransferObjectFactory.populateData(formBean, vo);

			if (!formBean.getStrChallanCount().equals("0")) {

				formBean
						.setStrDeliveryModeValues("<option value='0'>Select Value</option>");

				formBean
						.setStrScheduleNoValues("<option value='0'>Select Value</option>");

				formBean
						.setStrErr("");

			} else {
				
				
				
				if(vo.getWsDeliveryMode()!=null)
				{
					strDeliveryModeOptionVal=hisutil.getOptionValue(vo.getWsDeliveryMode(),"0", "Select Value", true);
					strDeliveryModeOptionVal=strDeliveryModeOptionVal+"<option value='1'>Other</option>";
				}
				else
				{
					strDeliveryModeOptionVal="<option value='0'>Select Value</option>";
				}
				
				formBean.setStrDeliveryModeValues(strDeliveryModeOptionVal);
				
				
				

				if (vo.getWsScheduleNo() != null
						&& vo.getWsScheduleNo().size() > 0) {

					formBean.setStrScheduleNoValues(hisutil.getOptionValue(vo
							.getWsScheduleNo(), formBean.getStrScheduleNo(),
							"", true, false));

					
					String[] strScheduleDtls = vo.getStrScheduleNo().replace("^",
							"#").split("#");

					formBean.setStrScheduleNo(strScheduleDtls[0]);
					formBean.setStrScheduleDate(strScheduleDtls[1]);
					formBean.setStrDeliveryDate(strScheduleDtls[2]);
					formBean.setStrScheduleTypeId(strScheduleDtls[3]);
					formBean.setStrScheduleType(strScheduleDtls[4]);

					

					//formBean.setStrScheduleAndReceiveDtls(ChallanProcessTransHLP.getScheduleAndReceiveDtls(formBean));

			//formBean.setStrScheduledItemDetails(ChallanProcessTransHLP.getScheduleItemList(formBean, vo));
					
				} else {

					formBean
							.setStrScheduleNoValues("<option value='0'>Select Value</option>");

				}

				

			}
			if(vo.getRecievedByWS()!=null){
				strReceivedByOptionVal=hisutil.getOptionValue(vo.getRecievedByWS(),"0", "Select Value", true);
				strReceivedByOptionVal=strReceivedByOptionVal+"<option value='1'>Other</option>";
			}else{
				strReceivedByOptionVal="<option value='0'>Select Value</option>";
			}
			
			formBean.setStrReceivedByOptionVal(strReceivedByOptionVal);
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
	

		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Drug Inventory.NewChallanProcessTransDATA.receiveChallanInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->receiveChallanInit()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}


	
	public static void getScheduleDtlsTwo(NewChallanProcessTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		NewChallanProcessTransBO bo = null;
		NewChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "";

		try 
		{
			bo = new NewChallanProcessTransBO();
			vo = new NewChallanProcessTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessTransDATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			
			
			String strPoNo        = (String) request.getParameter("strPoNo");
			String strPoStoreId   = (String) request.getParameter("strPoStoreId");
			String strStoreId     = (String) request.getParameter("strStoreId");
		//	String strReceiveDate = (String) request.getParameter("strReceiveDate");
			//String[] strScheduleDtls = strSchedule.replace("^", "#").split("#");

			//formBean.setStrReceiveDate(strReceiveDate);
			//formBean.setStrScheduleNo(strScheduleDtls[0]);
			//formBean.setStrScheduleDate(strScheduleDtls[1]);
			//formBean.setStrDeliveryDate(strScheduleDtls[2]);
			//formBean.setStrScheduleTypeId(strScheduleDtls[3]);
			//formBean.setStrScheduleType(strScheduleDtls[4]);
			vo.setStrStoreId(strStoreId);
			//vo.setStrReceiveDate(strReceiveDate);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrScheduleNo(formBean.getStrScheduleNo());
			vo.setStrPoNo(strPoNo);
			vo.setStrPoStoreId(strPoStoreId);

			bo.getScheduleDtls(vo);

			if (vo.getWsDeliveryMode() != null && vo.getWsDeliveryMode().size() > 0) 
			{
				formBean.setStrDeliveryModeValues(hisutil.getOptionValue(vo	.getWsDeliveryMode(), "0", "0^Select Value", false,	false));
			} 
			else 
			{
				formBean.setStrDeliveryModeValues("<option value='0'>Select Value</option>");
			}
			String[] strScheduleDtls = vo.getStrScheduleNo().replace("^","#").split("#");
			formBean.setStrScheduleNo(strScheduleDtls[0]);
			formBean.setStrScheduleDate(strScheduleDtls[1]);
			formBean.setStrDeliveryDate(strScheduleDtls[2]);
			formBean.setStrScheduleTypeId(strScheduleDtls[3]);
			formBean.setStrScheduleType(strScheduleDtls[4]);
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		
			String strScheduleContent = NewChallanProcessTransHLP.getScheduleAndReceiveDtls(formBean);
			strScheduleContent = strScheduleContent + " "+ NewChallanProcessTransHLP.getScheduleItemList(formBean, vo);

			try 
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strScheduleContent);
			} 
			catch (Exception e) 
			{
				throw e;
			}

		} 
		catch (Exception e)
		{
            e.printStackTrace(); 
			strmsgText = "Drug Inventory.NewChallanProcessTransDATA.getScheduleDtlsTwo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->getScheduleDtlsTwo()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	public static void getScheduleDtlsTwoBS(NewChallanProcessTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		NewChallanProcessTransBO bo = null;
		NewChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "";

		try 
		{
			bo = new NewChallanProcessTransBO();
			vo = new NewChallanProcessTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessTransDATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			
			
			String strPoNo        = (String) request.getParameter("strPoNo");
			String strPoStoreId   = (String) request.getParameter("strPoStoreId");
			String strStoreId     = (String) request.getParameter("strStoreId");
		//	String strReceiveDate = (String) request.getParameter("strReceiveDate");
			//String[] strScheduleDtls = strSchedule.replace("^", "#").split("#");

			//formBean.setStrReceiveDate(strReceiveDate);
			//formBean.setStrScheduleNo(strScheduleDtls[0]);
			//formBean.setStrScheduleDate(strScheduleDtls[1]);
			//formBean.setStrDeliveryDate(strScheduleDtls[2]);
			//formBean.setStrScheduleTypeId(strScheduleDtls[3]);
			//formBean.setStrScheduleType(strScheduleDtls[4]);
			vo.setStrStoreId(strStoreId);
			//vo.setStrReceiveDate(strReceiveDate);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrScheduleNo(formBean.getStrScheduleNo());
			vo.setStrPoNo(strPoNo);
			vo.setStrPoStoreId(strPoStoreId);

			bo.getScheduleDtls(vo);

			if (vo.getWsDeliveryMode() != null && vo.getWsDeliveryMode().size() > 0) 
			{
				formBean.setStrDeliveryModeValues(hisutil.getOptionValue(vo	.getWsDeliveryMode(), "0", "0^Select Value", false,	false));
			} 
			else 
			{
				formBean.setStrDeliveryModeValues("<option value='0'>Select Value</option>");
			}
			String[] strScheduleDtls = vo.getStrScheduleNo().replace("^","#").split("#");
			formBean.setStrScheduleNo(strScheduleDtls[0]);
			formBean.setStrScheduleDate(strScheduleDtls[1]);
			formBean.setStrDeliveryDate(strScheduleDtls[2]);
			formBean.setStrScheduleTypeId(strScheduleDtls[3]);
			formBean.setStrScheduleType(strScheduleDtls[4]);
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		
			String strScheduleContent = NewChallanProcessTransHLP.getScheduleAndReceiveDtls(formBean);
			strScheduleContent = strScheduleContent + " "+ NewChallanProcessTransHLP.getScheduleItemListBS(formBean, vo);

			try 
			{
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strScheduleContent);
			} 
			catch (Exception e) 
			{
				throw e;
			}

		} 
		catch (Exception e)
		{
            e.printStackTrace(); 
			strmsgText = "Drug Inventory.NewChallanProcessTransDATA.getScheduleDtlsTwo(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->getScheduleDtlsTwo()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	public static void getScheduleDtls(NewChallanProcessTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "";

		try {
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessTransDATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strSchedule = (String) request
					.getParameter("strScheduleDtls");
			String strPoNo = (String) request.getParameter("strPoNo");
			String strPoStoreId = (String) request.getParameter("strPoStoreId");

			String[] strScheduleDtls = strSchedule.replace("^", "#").split("#");

			formBean.setStrScheduleNo(strScheduleDtls[0]);
			formBean.setStrScheduleDate(strScheduleDtls[1]);
			formBean.setStrDeliveryDate(strScheduleDtls[2]);
			formBean.setStrScheduleTypeId(strScheduleDtls[3]);
			formBean.setStrScheduleType(strScheduleDtls[4]);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrScheduleNo(formBean.getStrScheduleNo());
			vo.setStrPoNo(strPoNo);
			vo.setStrPoStoreId(strPoStoreId);

			bo.getScheduleDtls(vo);

			if (vo.getWsDeliveryMode() != null
					&& vo.getWsDeliveryMode().size() > 0) {

				formBean.setStrDeliveryModeValues(hisutil.getOptionValue(vo
						.getWsDeliveryMode(), "0", "0^Select Value", false,
						false));

			} else {

				formBean
						.setStrDeliveryModeValues("<option value='0'>Select Value</option>");

			}

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

//			String strScheduleContent = ChallanProcessTransHLP
//					.getScheduleAndReceiveDtls(formBean);
//
//			strScheduleContent = strScheduleContent + " "
//					+ ChallanProcessTransHLP.getScheduleItemList(formBean, vo);

			try {
				response.setHeader("Cache-Control", "no-cache");
				//response.getWriter().print(strScheduleContent);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {

			strmsgText = "Drug Inventory.NewChallanProcessTransDATA.getScheduleDtls(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->getScheduleDtls()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	public static void getCommitteeMemberDtls(NewChallanProcessTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		String strmsgText = "";

		try {
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			String strCommitteTypeId = (String) request
					.getParameter("committeType");

			formBean.setStrCommitteeType(strCommitteTypeId);
			vo.setStrItemCategoryId(request.getParameter("itemCategNo"));
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrCommitteeType(strCommitteTypeId);

			bo.getCommitteeMemberDtls(vo);

//			String strMembDtls = ChallanProcessTransHLP.createMemberDetails(
//					formBean, vo.getWsCommitteeMemberList());

			try {
				response.setHeader("Cache-Control", "no-cache");
//				response.getWriter().print(strMembDtls);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {

			strmsgText = "Challan Process.NewChallanProcessTransDATA.getCommitteeMemberDtls(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->getCommitteeMemberDtls()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	public static void getBalanceQtyDtls(NewChallanProcessTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		String strmsgText = "";

		try {
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();

			String strPoNo = (String) request.getParameter("strPoNo");
			String strScheduleNo = (String) request.getParameter("strScheduleNo");
			String strItemId = (String) request.getParameter("strItemId");
			String strBrandItemId = (String) request
					.getParameter("strItemBrandId");
			String strPoStoreId = (String) request.getParameter("strPoStoreId");

			vo.setStrPoNo(strPoNo);
			vo.setStrScheduleNo(strScheduleNo);
			vo.setStrGenericItemId(strItemId);
			vo.setStrItemBrandId(strBrandItemId);
			vo.setStrPoStoreId(strPoStoreId);
			vo.setStrHospitalCode(hosCode);

			bo.getBalanceQtyDtls(vo);

			formBean.setStrOrderedQuantityView(vo.getStrOrderedQuantityView());
			formBean
					.setStrAcceptedQuantityView(vo.getStrAcceptedQuantityView());
			formBean
					.setStrRejectedQuantityView(vo.getStrRejectedQuantityView());

//			String strBalanceQtyDtls = ChallanProcessTransHLP
//					.getBalanceQtyDtls(formBean);

			try {
				response.setHeader("Cache-Control", "no-cache");
//				response.getWriter().print(strBalanceQtyDtls);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {

			strmsgText = "Challan Process.NewChallanProcessTransDATA.getBalanceQtyDtls(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->getBalanceQtyDtls()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	public static boolean insert(NewChallanProcessTransFB formBean) {

		NewChallanProcessTransBO bo = null;
		NewChallanProcessTransVO vo = null;

		boolean fltRes = false;
		
		MmsConfigUtil mmsUtil = null;

		String strmsgText = "";

		try {
			bo = new NewChallanProcessTransBO();
			vo = new NewChallanProcessTransVO();

			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());
			//System.out.println("chk value   "+formBean.getStrchkvalue());
			//String[] strScheduleDtls = formBean.getStrScheduleNo().replace("^","#").split("#");

			//formBean.setStrScheduleNo(strScheduleDtls[0]);
			//formBean.setStrScheduleDate(strScheduleDtls[1]);
			//formBean.setStrDeliveryDate(strScheduleDtls[2]);
			//formBean.setStrScheduleTypeId(strScheduleDtls[3]);
			//formBean.setStrScheduleType(strScheduleDtls[4]);
			////System.out.println("strSupplierReceiptNo==>"+formBean.getStrSupplierReceiptNo());
			vo = (NewChallanProcessTransVO) TransferObjectFactory.populateData("mms.transactions.vo.NewChallanProcessTransVO", formBean);

			vo.setStrFinancialStartDate(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode() ));
			vo.setStrFinancialEndDate(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
            vo.setStrDeliveryModeTextValue("-");
			
			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			
			fltRes = true;
			
		}
		catch (Exception e)
		{
            e.printStackTrace();
			strmsgText = "NewChallanProcessTransDATA.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->insert()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			fltRes = false;
			
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

		return fltRes;
		
	}

	public static void verifyChallanInit(NewChallanProcessTransFB formBean,HttpServletRequest request) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "";

		try {
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();
			hisutil = new HisUtil("mms", "NewChallanProcessTransDATA");

			

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			

			if(request.getParameter("chk") != null)
			{
				if (formBean.getComboValue() != null && !formBean.getComboValue().equals(""))
				{

					String strCmbNames = formBean.getComboValue();
					String[] temp = strCmbNames.replace("^", "#").split("#");
					formBean.setStrStoreName(temp[0]);
					formBean.setStrItemCategoryName(temp[1]);

				}	
				String strStoreId = formBean.getCombo()[0];
				
				String strPoNoDtls[] = formBean.getCombo()[2].replace("^", "#").split("#");
				vo.setStrStoreName(formBean.getStrStoreName());
				vo.setStrStoreId(strStoreId);
				vo.setStrPoNo(strPoNoDtls[0]);
				vo.setStrPoStoreId(strPoNoDtls[1]);
				
			  String strChk = request.getParameter("chk");
			  String strTemp[] = strChk.replace("@", "#").split("#");
			  vo.setStrChallanNo(strTemp[1]);
			  vo.setStrGenericItemId(strTemp[2]);
			  vo.setStrItemBrandId(strTemp[3]);
			  vo.setStrScheduleNo(strTemp[4]);
			}
			else
			{
				if(!formBean.getStrTmpChkVal().equals("")||!formBean.getStrTmpChkVal().equals(" "))
				{	
					String strChk = formBean.getStrTmpChkVal();
					String strTemp[] = strChk.replace("@", "#").split("#");
					vo.setStrChallanNo(strTemp[1]);
					vo.setStrGenericItemId(strTemp[2]);
					vo.setStrItemBrandId(strTemp[3]);
					vo.setStrScheduleNo(strTemp[4]);
				}
				vo.setStrStoreName(formBean.getStrTmpStoreName());
				vo.setStrStoreId(formBean.getStrTmpStoreId());
				vo.setStrPoNo(formBean.getStrTmpPoNumber());
				vo.setStrPoStoreId(formBean.getStrTmpPoStoreId());
				vo.setStrTmpChkVal(formBean.getStrTmpChkVal());
			}
			
			
			
			bo.verifyInit(vo);
			

			String strManfValues = "<option value='0'>Select Value </option>";

			if (vo.getWsManufacturer() != null	&& vo.getWsManufacturer().size() > 0) 
			{

				strManfValues = hisutil.getOptionValue(vo.getWsManufacturer(),"0", "0^Select Value", false);

			}

			String strUnitVals = "<option value='0'>Select Value </option>";

			if (vo.getWsUnitList() != null && vo.getWsUnitList().size() > 0) {

				strUnitVals = hisutil.getOptionValue(vo.getWsUnitList(), vo.getStrCompositeUnitId(),
						"", false);

			}

			String strRateUnitVals = "<option value='0'>Select Value </option>";

			if (vo.getWsRateUnit() != null && vo.getWsRateUnit().size() > 0) {

				strRateUnitVals = hisutil.getOptionValue(vo.getWsRateUnit(),
						vo.getStrCompRateUnitId(), "", false);

			}

			String strCommitteType = "<option value='0'>Select Value </option>";

			if (vo.getWsCommitteeType() != null
					&& vo.getWsCommitteeType().size() > 0) {

				strCommitteType = hisutil.getOptionValue(vo
						.getWsCommitteeType(), "0", "0^Select Value", false);

			}

			TransferObjectFactory.populateData(formBean, vo);

			formBean.setStrManufacturerValues(strManfValues);
			formBean.setStrUnitValues(strUnitVals);
			formBean.setStrRateUnitValues(strRateUnitVals);
			formBean.setStrCommitteeTypeValues(strCommitteType);

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(hosCode);	
			formBean.setStrIssueRateConfigFlg(mmscofigutil.getStrIssueRateConfigFlg());
			formBean.setStrConfigIssueRate(mmscofigutil.getStrConfigIssueRate());
			
			formBean.setStrChallanNo(vo.getStrChallanNo());
			formBean.setStrGenericItemId(vo.getStrGenericItemId());
			formBean.setStrItemBrandId(vo.getStrItemBrandId());
			formBean.setStrScheduleNo(vo.getStrScheduleNo());
			if(request.getParameter("chk") != null)
			{	
			 formBean.setStrTmpChkVal(request.getParameter("chk"));
			}
			else
			{
				formBean.setStrTmpChkVal(vo.getStrTmpChkVal());
			}
			formBean.setStrChallanNo(vo.getStrChallanNo());
			formBean.setStrGenericItemId(vo.getStrGenericItemId());
			formBean.setStrItemBrandId(vo.getStrItemBrandId());
			formBean.setStrScheduleNo(vo.getStrScheduleNo());
			
			formBean.setStrTmpStoreName(vo.getStrStoreName());
			formBean.setStrTmpStoreId(vo.getStrStoreId());
			formBean.setStrTmpPoNumber(vo.getStrPoNo());
			formBean.setStrTmpPoStoreId(vo.getStrPoStoreId());
			formBean.setStrQcTypeFlg(vo.getStrQcTypeFlg());
			////System.out.println("QC Type FLG in[ChallanProcessTransDATA.verifyChallanInit(vo)] ==>"+vo.getStrQcTypeFlg());
			formBean.setStrSupplierPerformanceInfo(vo.getStrSupplierPerformanceInfo());
			formBean.setStrSupplierPerformanceFlag(vo.getStrSupplierPerformanceFlag());
			////System.out.println("Supplier Performance Flg==>"+vo.getStrSupplierPerformanceFlag());
			formBean.setStrItemBrandName(vo.getStrItemBrandName());
			

		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "NewChallanProcessTransDATA.verifyChallanInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->verifyChallanInit()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	
	public static boolean verifyInsert(NewChallanProcessTransFB formBean) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		boolean fltRes = false;
		
	MmsConfigUtil mmsUtil = null;

		String strmsgText = "";
		String strFileName="";
		String strCurrentDate="";
		HisUtil hisutil=null;
		AttachFileGlobal fs=null;
		String strFileExt="";
		String temp[]=null;
	//	String filePath="";

		try 
		{
			
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();
			hisutil=new HisUtil("mms", "ChallanProcessTransDATA");
			fs=new AttachFileGlobal();
			
			strCurrentDate = hisutil.getASDate("dd-MMM-yyyy");
			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());
            

			vo = (ChallanProcessTransVO) TransferObjectFactory.populateData(
					"mms.transactions.vo.ChallanProcessTransVO", formBean);

			vo.setStrFinancialStartDate(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode() ));
			vo.setStrFinancialEndDate(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
            vo.setCombo(formBean.getCombo());
			vo.setStrRackNumber(formBean.getStrRackNumber());
			vo.setStrAcceptedQuantityUnitId(formBean.getStrAcceptedQuantityUnitId().replace("^", "#").split("#")[0]);
			vo.setStrRejectedQuantityUnitId(formBean.getStrRejectedQuantityUnitId().replace("^", "#").split("#")[0]);
			vo.setStrBalanceQuantityUnitId(formBean.getStrBalanceQuantityUnitId().replace("^", "#").split("#")[0]);
			vo.setStrBreakageQuantityUnitId(formBean.getStrBreakageQuantityUnitId().replace("^", "#").split("#")[0]);
			vo.setStrExcessQtyUnitId(formBean.getStrExcessQtyUnitId().replace("^", "#").split("#")[0]);
			vo.setStrSalePriceUnitId(formBean.getStrSalePriceUnitId().replace("^", "#").split("#")[0]);
			vo.setStrSalePrice(formBean.getStrSalePrice());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrFileNo(formBean.getStrFileNo());
			vo.setStrPageNo(formBean.getStrPageNo());
			vo.setStrCommitteeMemberHidden(formBean.getStrCommitteeMemberHidden());
			FormFile myFile = formBean.getStrLocation();
			     strFileExt = myFile.getFileName();
			temp=strFileExt.replace('.', '#').split("#");
			     strFileExt = temp[temp.length-1];
			    strFileName = vo.getStrStoreId()+"_"+vo.getStrChallanNo()+"_"+vo.getStrHospitalCode()+"_"+strCurrentDate+"."+strFileExt;
			
			vo.setStrFileName(strFileName);
			vo.setStrTmpChkVal(formBean.getStrTmpChkVal());
			formBean.setStrTmpChkVal(formBean.getStrTmpChkVal());
			
			bo.verifyInsert(vo);

			
				if (vo.getStrMsgType().equals("1"))
				{
					formBean.setStrErr(vo.getStrMsgString());
					
					throw new Exception(vo.getStrMsgString());
				}
				else
				{	
				   double balaceQty  = Double.parseDouble(formBean.getStrBalanceQuantity());
				   double acceptedQty  = Double.parseDouble(vo.getStrAcceptedQuantity());
				   double remainQty = balaceQty - acceptedQty;
				   
				   formBean.setStrRemainingQty(String.valueOf(remainQty));
			       formBean.setStrMsg("Item Verify Successfully ");
			       
			       
				}   
			  		
 
			fltRes = true;	
			formBean.setStrTmpChkVal(vo.getStrTmpChkVal());
			formBean.setStrPageNumber("");

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "ChallanProcessTransDATA.verifyInsert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->verifyInsert()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			fltRes = false;
			
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

			return fltRes;
		
	}
	
	
	public static void cancelChallan(NewChallanProcessTransFB formBean) {

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;


		String strmsgText = "";

		try {
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();

			String strPkValues = formBean.chk[0];
			
			String[] strTemp = strPkValues.replace("@", "#").split("#");
			
			vo.setStrStoreId(strTemp[0]);
			vo.setStrChallanNo(strTemp[1]);
			vo.setStrGenericItemId(strTemp[2]);
			vo.setStrItemBrandId(strTemp[3]);
			
			String strPoValues = formBean.getCombo()[1];
			
			String[] strTemp1 = strPoValues.replace("^", "#").split("#");
			
			vo.setStrPoNo(strTemp1[0]);
			vo.setStrPoStoreId(strTemp1[1]);
			vo.setStrRemarks(formBean.getComboValue());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.cancelChallan(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

		} catch (Exception e) {

			
			
			strmsgText = "NewChallanProcessTransDATA.cancelChallan(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->cancelChallan()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	public static void viewChallan(NewChallanProcessTransFB formBean,HttpServletRequest request) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strChallanDtl = "", strChallanDtlNew = "";
	
		try {
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessTransDATA");		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
		
			if(formBean.getCombo()[0] != "0" && formBean.getCombo()[1] != "0")
			{				
				String strCmbNames = formBean.getComboValue();
				String[] temp = strCmbNames.split("\\^");
				formBean.setStrStoreName(temp[0]);
				
				String[] chktmp = formBean.getChk();
				String[] tmp=chktmp[0].replace("@","#").split("#");
				formBean.setStrPoNoDisplay(tmp[2]);
				
				
				String strStoreId = formBean.getCombo()[0];				
				//String strPoNoDtls[] = formBean.getCombo()[2].split("\\^");
				formBean.setStrPoNo(tmp[2]);
				
				vo.setStrStoreId(strStoreId);
				vo.setStrPoNo(tmp[2]);
				vo.setStrPoStoreId(tmp[3]);			  
			}
			
			bo.viewChallan(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ChallanProcessTransDATA.viewChallan() --> "
								+ vo.getStrMsgString());
			}			
			strChallanDtl = ChallanProcessTransBSHLP.getChallanReceivedDetails(vo.getWsChallanDtls());
			//System.out.println("strChallan :: "+strChallanDtl);
			formBean.setStrChallanHlpDtl(strChallanDtl);
			/* formBean.setStrChallanHlpDtlNew(strChallanDtlNew); */
			formBean.setStrSupplierId(vo.getStrSupplierId());
			formBean.setStrSupplierName(vo.getStrSupplierName());
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "NewChallanProcessTransDATA.viewChallan(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->viewChallan()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	public static void getReceivedItemDetails(NewChallanProcessTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strReceivedItemDtl = "";
	
		try {
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();
			hisutil = new HisUtil("mms", "NewChallanProcessTransDATA");		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
			String strStoreId = request.getParameter("strStoreId");
			String strPoNo = request.getParameter("strPoNo");
			String strChallanNo = request.getParameter("strChallanNo");
			
			vo.setStrStoreId(strStoreId);
			vo.setStrPoNo(strPoNo);
			vo.setStrChallanNo(strChallanNo);				
			
			bo.getReceivedItemDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ChallanProcessTransDATA.getReceivedItemDetails() --> "
								+ vo.getStrMsgString());
			}					
			
			strReceivedItemDtl = ChallanProcessTransBSHLP.getReceivedItemDetails(vo.getWsReceivedItemDtls());			
			
			if(strReceivedItemDtl!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	
			 	response.getWriter().print(strReceivedItemDtl);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "NewChallanProcessTransDATA->getReceivedItemDetails()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }			
               
			formBean.setStrReceivedItemHlpDtl(strReceivedItemDtl);
			
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "NewChallanProcessTransDATA.getReceivedItemDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"NewChallanProcessTransDATA->getReceivedItemDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	
	public static void getVerifiedItemDetails(NewChallanProcessTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strVerifiedItemDtl = "";
	
		try {
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();
			hisutil = new HisUtil("mms", "NewChallanProcessTransDATA");		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
			String strStoreId = request.getParameter("strStoreId");
			String strPoNo = request.getParameter("strPoNo");
			String strChallanNo = request.getParameter("strChallanNo");
			String strItemId = request.getParameter("strItemId");
			String strItemBrandId = request.getParameter("strItemBrandId");
			 
			vo.setStrStoreId(strStoreId);
			vo.setStrPoNo(strPoNo);
			vo.setStrChallanNo(strChallanNo);
			vo.setStrItemId(strItemId);
			vo.setStrItemBrandId(strItemBrandId);
			
			bo.getVerifiedItemDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("NewChallanProcessTransDATA.getVerifiedItemDetails() --> "
								+ vo.getStrMsgString());
			}					
			
			strVerifiedItemDtl = ChallanProcessTransHLP.getVerifiedItemDetails(vo.getWsVerifiedItemDtls());			
			
			if(strVerifiedItemDtl!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	
			 	response.getWriter().print(strVerifiedItemDtl);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "NewChallanProcessTransDATA->getVerifiedItemDetails()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }			
               
			formBean.setStrVerifiedItemHlpDtl(strVerifiedItemDtl);
			
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "NewChallanProcessTransDATA.getVerifiedItemDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"NewChallanProcessTransDATA->getVerifiedItemDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	
	public static void print(NewChallanProcessTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strPrintItemDtl = "";
	
		try {
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessTransDATA");		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			
			String strStoreId = request.getParameter("strStoreId");
			String strPoNo = request.getParameter("strPoNo");
			String strChallanNo = request.getParameter("strChallanNo");
			//String strItemId = request.getParameter("strItemId");
			//String strItemBrandId = request.getParameter("strItemBrandId");
			 
			vo.setStrStoreId(strStoreId);
			vo.setStrPoNo(strPoNo);
			vo.setStrChallanNo(strChallanNo);
			//vo.setStrItemId(strItemId);
			//vo.setStrItemBrandId(strItemBrandId);
			
			bo.getPrintDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("NewChallanProcessTransDATA.getVerifiedItemDetails() --> "
								+ vo.getStrMsgString());
			}					
			
			strPrintItemDtl = ChallanProcessTransHLP.getPrintItemDetails(vo.getWsPrintItemDtls(),hosCode);			
			
			if(strPrintItemDtl!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	
			 	response.getWriter().print(strPrintItemDtl);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "NewChallanProcessTransDATA->getVerifiedItemDetails()", vo.getStrMsgString());
				String str = "ERROR####Application Error [ERROR ID : " + eObj.getErrorID() + "], Contact System Administrator! ";
				response.getWriter().print(str);
	    	 }			
               
			formBean.setStrPrintItemHlpDtl(strPrintItemDtl);
			
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "ChallanProcessTransDATA.getPrintItemDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"NewChallanProcessTransDATA->getPrintItemDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	
	
	public static void getInitNewRecItemChl(NewChallanProcessTransFB formBean,HttpServletRequest request) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;
		LinkedHashMultimap<String, List> multiMap = null;
		List<String> list=null;
		List<String> list1=null;
		HisUtil hisutil = null;
		Set<List<String>> set=null;
		String strReceivedByOptionVal="";
		String strmsgText = "", strChallanDtl = "";
	
		try {
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessTransDATA");		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
		
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemCategoryId(formBean.getStrItemCategoryId());
			vo.setStrPoNo(formBean.getStrPoNo());	
			
			formBean.setStrPoNo1(formBean.getStrPoNo());	  
		
			
			bo.getInitNewRecChl(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ChallanProcessTransDATA.viewChallan() --> "
								+ vo.getStrMsgString());
				//throw new 
			}			
			
			 multiMap = LinkedHashMultimap.create();
			 
			 if(vo.getWsNewReceivedItemDtls().size() > 0)
				{
					while(vo.getWsNewReceivedItemDtls().next())
					{
					
					list=new ArrayList<String>();
					int ColumnLength=	vo.getWsNewReceivedItemDtls().getMetaData().getColumnCount();
						for(int i=1 ;i<=ColumnLength;i++)
						{
							list.add(vo.getWsNewReceivedItemDtls().getString(i));
						}
						multiMap.put(vo.getWsNewReceivedItemDtls().getString(5).split("\\^")[0], list);
					}
				}
			 

			/* Set<String> keys = multiMap.keySet();
			 list1=new  ArrayList<String>();
			 set =new HashSet<List<String>>();
           	 for (String key : keys) {
           		 
           		 //System.out.println("key"+key);
           		 
           		//System.out.println("sIRZE:::::::::::"+multiMap.get(key).size());
           		set = (Set)multiMap.get(key);
           		Iterator value = set.iterator(); 
           	
           		while (value.hasNext()) { 
                 ////System.out.println(value.next()); 
                 list1 = (List)value.next();
                 for(int j = 0 ; j <list1.size() ; j++)
                 {
                	//System.out.println(list1.get(j)); 
                 }
             } 
           	}*/
			 
			// formBean.setStrPoNo(strPoNo);
			 formBean.setStrPoDate(vo.getStrPoDate());
			 formBean.setStrSupplierName(vo.getStrSupplierName());
			 formBean.setStrPoType(vo.getStrPoType());
			 formBean.setStrCurrencyName(vo.getStrCurrencyName());
			 formBean.setStrSupplierId(vo.getStrSupplierId());
			 formBean.setStrPoTypeId(vo.getStrPoTypeId());
			 formBean.setStrPoNoDisplay(vo.getStrPoNoDisplay());
			 formBean.setStrCurrencyCode(vo.getStrCurrencyCode());
			 formBean.setStrPurchaseSourceId(vo.getStrPurchaseSourceId());
			 
			 
			 formBean.setStrIsOpenFlg("1");
			 if(vo.getRecievedByWS()!=null){
					strReceivedByOptionVal=hisutil.getOptionValue(vo.getRecievedByWS(),"0", "Select Value", true);
					strReceivedByOptionVal=strReceivedByOptionVal+"<option value='1'>Other</option>";
				}else{
					strReceivedByOptionVal="<option value='0'>Select Value</option>";
				}
			 formBean.setStrReceivedByOptionVal(strReceivedByOptionVal);
			/* //System.out.println("list:::::::::::"+list.size());
			 //System.out.println("list:::::::::::"+multiMap.size());
			 //System.out.println(multiMap);
			 JSONObject mainObj = new JSONObject();
			 mainObj.put("Data", multiMap);
			 //System.out.println("multiMap"+mainObj);*/
			 
			 formBean.setStrStoreName(formBean.getStrStoreName1());
			 formBean.setStrItemCategoryName(formBean.getStrItemCatName1());
			 if(vo.getWsNewReceivedItemDtls().size() > 0)
				{	
				 request.getSession().setAttribute("CHALITEMDTL", multiMap);
				}
			 else{
				 request.getSession().setAttribute("CHALITEMDTL", null);
			 }
			
			
			
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "NewChallanProcessTransDATA.viewChallan(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->viewChallan()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	public static boolean insertlp(NewChallanProcessTransFB formBean ,HttpServletRequest request) {

		NewChallanProcessTransBO bo = null;
		NewChallanProcessTransVO vo = null;

		boolean fltRes = false;
		
		MmsConfigUtil mmsUtil = null;
		MultiMap ItemWaiseMultiMap = null;
		MultiMap CrnoWaiseMultiMap = null;
		MultiMap batchWaiseMultiMap = null;
		String strmsgText = "";

		try {
			bo = new NewChallanProcessTransBO();
			vo = new NewChallanProcessTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());
			////System.out.println("chk value   "+formBean.getStrchkvalue());
			//String[] strScheduleDtls = formBean.getStrScheduleNo().replace("^","#").split("#");

			//formBean.setStrScheduleNo(strScheduleDtls[0]);
			//formBean.setStrScheduleDate(strScheduleDtls[1]);
			//formBean.setStrDeliveryDate(strScheduleDtls[2]);
			//formBean.setStrScheduleTypeId(strScheduleDtls[3]);
			//formBean.setStrScheduleType(strScheduleDtls[4]);
			////System.out.println("strSupplierReceiptNo==>"+formBean.getStrSupplierReceiptNo());
			
			////System.out.println("Lenght::::::::"+formBean.getIsChecked().length);
			
			/* Data Item And Batch Wise */ 
			if(formBean.getIsChecked()!=null)
			{
				ItemWaiseMultiMap = new MultiValueMap();
				
				//System.out.println("Lenght::::::::"+formBean.getIsChecked().length);
				
				for(int i=0 ; i < formBean.getIsChecked().length ; i++)
				{
					String batch=formBean.getStrBatch()[i];
					String Qty=formBean.getStrAcceptedQty()[i];
					String Mrp=formBean.getStrMRP()[i];
					String expDate=formBean.getStrExpDate()[i];
					String mfgDate=formBean.getStrMfgDate()[i];
					String action=formBean.getStractionRNI()[i];
					String HiddenValue=formBean.getIsChecked()[i];
					ItemWaiseMultiMap.put(formBean.getIsChecked()[i].split("#")[3], HiddenValue+"#"+Mrp+"#"+batch+"#"+Qty+"#"+expDate+"#"+mfgDate+"#"+action);
				}
			}
			/* Data lp Wise For Issue TO Patient */ 
			if(formBean.getIsChecked()!=null)
			{
				CrnoWaiseMultiMap = new MultiValueMap();
				
				//System.out.println("Lenght::::::::"+formBean.getIsChecked().length);
				
				for(int i=0 ; i < formBean.getIsChecked().length ; i++)
				{
					String batch=formBean.getStrBatch()[i];
					String Qty=formBean.getStrAcceptedQty()[i];
					String Mrp=formBean.getStrMRP()[i];
					String expDate=formBean.getStrExpDate()[i];
					String mfgDate=formBean.getStrMfgDate()[i];
					String action=formBean.getStractionRNI()[i];
					String HiddenValue=formBean.getIsChecked()[i];
					CrnoWaiseMultiMap.put(formBean.getIsChecked()[i].split("#")[1], HiddenValue+"#"+Mrp+"#"+batch+"#"+Qty+"#"+expDate+"#"+mfgDate+"#"+action);
					
				}
			}
			
			/* Batch Wise */
			if(formBean.getIsChecked()!=null)
			{
				batchWaiseMultiMap = new MultiValueMap();
				
				//System.out.println("Lenght::::::::"+formBean.getIsChecked().length);
				
				for(int i=0 ; i < formBean.getIsChecked().length ; i++)
				{
					String batch=formBean.getStrBatch()[i];
					String Qty=formBean.getStrAcceptedQty()[i];
					String Mrp=formBean.getStrMRP()[i];
					String expDate=formBean.getStrExpDate()[i];
					String mfgDate=formBean.getStrMfgDate()[i];
					String action=formBean.getStractionRNI()[i];
					String HiddenValue=formBean.getIsChecked()[i];
					batchWaiseMultiMap.put(batch, HiddenValue+"#"+Mrp+"#"+batch+"#"+Qty+"#"+expDate+"#"+mfgDate+"#"+action);
				}
			}
			
			//System.out.println("batchWaiseMultiMap"+batchWaiseMultiMap.size());
			//System.out.println(batchWaiseMultiMap.toString());
			//vo = (NewChallanProcessTransVO) TransferObjectFactory.populateData("mms.transactions.vo.NewChallanProcessTransVO", formBean);
			vo.setStrPoNo(formBean.getStrPoNo());
			vo.setStrSupplierId(formBean.getStrSupplierId());
			vo.setStrPurchaseSourceId(formBean.getStrPurchaseSourceId());
			vo.setStrPoDate(formBean.getStrPoDate());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemWiseMap(ItemWaiseMultiMap);
			vo.setStrCrNoWiseMap(CrnoWaiseMultiMap);
			vo.setStrbatchWaiseMultiMap(batchWaiseMultiMap);
			vo.setStrPoTypeId(formBean.getStrPoType());
			vo.setStrItemCategoryId(formBean.getStrItemCategoryId());
			vo.setStrFinancialStartDate(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode() ));
			vo.setStrFinancialEndDate(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
            vo.setStrDeliveryModeTextValue("-");
			vo.setStrPoStoreId(formBean.getStrStoreId());
			vo.setStrPoNo(formBean.getStrPoNo1());
			vo.setStrReceivedBy(formBean.getStrReceivedBy());
			vo.setStrRequestTypeId("35");
			vo.setStrSupplierReceiptNo(formBean.getStrSupplierReceiptNo());
			vo.setStrSupplierReceiptDate(formBean.getStrSupplierReceiptDate());
			vo.setStrReceiveDate(formBean.getStrSupplierReceiptDate());
			bo.insertlp(vo);

			/*if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}*/
			
			fltRes = true;
			
		}
		catch (Exception e)
		{
            e.printStackTrace();
			strmsgText = "NewChallanProcessTransDATA.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->insert()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			fltRes = false;
			
			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

		return fltRes;
		
	}
	public static void getInitNewRecChl(NewChallanProcessTransFB formBean,HttpServletRequest request) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strChallanDtl = "";
	
		try {
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessTransDATA");		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
		
			
			if(formBean.getCombo()[0] != "0" && formBean.getCombo()[1] != "0")
			{				
				String strCmbNames = formBean.getComboValue();
				String[] temp = strCmbNames.split("\\^");
				formBean.setStrStoreName(temp[0]);
				formBean.setStrItemCategoryName(temp[1]);
				formBean.setStrStoreId(temp[2]);
				formBean.setStrItemCategoryId(temp[3]);
				
				formBean.setStrStoreName1(temp[0]);
				formBean.setStrItemCatName1(temp[1]);
					  
			}
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ChallanProcessTransDATA.viewChallan() --> "
								+ vo.getStrMsgString());
			}			
			
			String ctDate = hisutil.getASDate("yyyy-mm-dd");
			formBean.setStrCtDate(ctDate);
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "NewChallanProcessTransDATA.viewChallan(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->viewChallan()", strmsgText);
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
