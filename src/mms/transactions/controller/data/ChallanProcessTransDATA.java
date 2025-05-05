package mms.transactions.controller.data;


import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.upload.FormFile;

import mms.AttachFileGlobal;
import mms.MmsConfigUtil;
import mms.transactions.bo.ChallanProcessTransBO;
import mms.transactions.controller.fb.ChallanProcessTransFB;
import mms.transactions.controller.hlp.ChallanProcessTransHLP;
import mms.transactions.vo.ChallanProcessTransVO;

/**
 * 
 * Developer : Balasubramaniam M Version : 1.0 Date : 12-Jun-2009
 * 
 */

public class ChallanProcessTransDATA 
{

	public static void receiveChallanInit(ChallanProcessTransFB formBean,
			HttpServletRequest request) 
	{
		
		System.out.println("---------- ChallanProcessTransDATA . receiveChallanInit ------------");

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

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);

			bo.receiveInit(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo
						.setStrMsgString("ChallanProcessTransDATA.receiveChallanInit() --> "
								+ vo.getStrMsgString());
			}

			TransferObjectFactory.populateData(formBean, vo);

			if (!formBean.getStrChallanCount().equals("0")) {

				formBean
						.setStrDeliveryModeValues("<option value='0'>Select Value</option>");

				formBean
						.setStrScheduleNoValues("<option value='0'>Select Value</option>");

				formBean
						.setStrErr("No Receive Until All the Item(s) are Verified");

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

					

					formBean.setStrScheduleAndReceiveDtls(ChallanProcessTransHLP.getScheduleAndReceiveDtls(formBean));

					formBean.setStrScheduledItemDetails(ChallanProcessTransHLP.getScheduleItemList(formBean, vo));
					
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
			strmsgText = "Drug Inventory.ChallanProcessTransDATA.receiveChallanInit(vo) --> "
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

	
	public static void getScheduleDtlsTwo(ChallanProcessTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "";

		try 
		{
			System.out.println("---------- ChallanProcessTransDATA . getScheduleDtlsTwo ------------");
			
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessTransDATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();
			
			
			String strPoNo        = (String) request.getParameter("strPoNo");
			String strPoStoreId   = (String) request.getParameter("strPoStoreId");
			String strStoreId     = (String) request.getParameter("strStoreId");
			String strReceiveDate = (String) request.getParameter("strReceiveDate");
			//String[] strScheduleDtls = strSchedule.replace("^", "#").split("#");

			formBean.setStrReceiveDate(strReceiveDate);
			//formBean.setStrScheduleNo(strScheduleDtls[0]);
			//formBean.setStrScheduleDate(strScheduleDtls[1]);
			//formBean.setStrDeliveryDate(strScheduleDtls[2]);
			//formBean.setStrScheduleTypeId(strScheduleDtls[3]);
			//formBean.setStrScheduleType(strScheduleDtls[4]);
			vo.setStrStoreId(strStoreId);
			vo.setStrReceiveDate(strReceiveDate);
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
		
			String strScheduleContent = ChallanProcessTransHLP.getScheduleAndReceiveDtls(formBean);
			strScheduleContent = strScheduleContent + " "+ ChallanProcessTransHLP.getScheduleItemList(formBean, vo);

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
			strmsgText = "Drug Inventory.ChallanProcessTransDATA.getScheduleDtlsTwo(vo) --> "
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
	public static void getScheduleDtls(ChallanProcessTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "";

		try {
			
			System.out.println("---------- ChallanProcessTransDATA . getScheduleDtls ------------");
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

			String strScheduleContent = ChallanProcessTransHLP
					.getScheduleAndReceiveDtls(formBean);

			strScheduleContent = strScheduleContent + " "
					+ ChallanProcessTransHLP.getScheduleItemList(formBean, vo);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strScheduleContent);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {

			strmsgText = "Drug Inventory.ChallanProcessTransDATA.getScheduleDtls(vo) --> "
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

	public static void getCommitteeMemberDtls(ChallanProcessTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		String strmsgText = "";

		try {
			System.out.println("---------- ChallanProcessTransDATA . getCommitteeMemberDtls ------------");
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

			String strMembDtls = ChallanProcessTransHLP.createMemberDetails(
					formBean, vo.getWsCommitteeMemberList());

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strMembDtls);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {

			strmsgText = "Challan Process.ChallanProcessTransDATA.getCommitteeMemberDtls(vo) --> "
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

	public static void getBalanceQtyDtls(ChallanProcessTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		String strmsgText = "";

		try {
			System.out.println("---------- ChallanProcessTransDATA . getBalanceQtyDtls ------------");
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

			String strBalanceQtyDtls = ChallanProcessTransHLP
					.getBalanceQtyDtls(formBean);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strBalanceQtyDtls);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {

			strmsgText = "Challan Process.ChallanProcessTransDATA.getBalanceQtyDtls(vo) --> "
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

	public static boolean insert(ChallanProcessTransFB formBean) {

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		boolean fltRes = false;
		
		MmsConfigUtil mmsUtil = null;

		String strmsgText = "";

		try {
			
			System.out.println("---------- ChallanProcessTransDATA . insert ------------");
			
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();

			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());

			//String[] strScheduleDtls = formBean.getStrScheduleNo().replace("^","#").split("#");

			//formBean.setStrScheduleNo(strScheduleDtls[0]);
			//formBean.setStrScheduleDate(strScheduleDtls[1]);
			//formBean.setStrDeliveryDate(strScheduleDtls[2]);
			//formBean.setStrScheduleTypeId(strScheduleDtls[3]);
			//formBean.setStrScheduleType(strScheduleDtls[4]);
			////System.out.println("strSupplierReceiptNo==>"+formBean.getStrSupplierReceiptNo());
			vo = (ChallanProcessTransVO) TransferObjectFactory.populateData("mms.transactions.vo.ChallanProcessTransVO", formBean);

			vo.setStrFinancialStartDate(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode() ));
			vo.setStrFinancialEndDate(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
            vo.setStrDeliveryModeTextValue(formBean.getStrDeliveryModeText());
			
			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			
			fltRes = true;
			
		}
		catch (Exception e)
		{
            e.printStackTrace();
			strmsgText = "ChallanProcessTransDATA.insert(vo) --> "
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

	public static void verifyChallanInit(ChallanProcessTransFB formBean,HttpServletRequest request) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "";

		try {
			System.out.println("---------- ChallanProcessTransDATA . verifyChallanInit ------------");
			
			bo = new ChallanProcessTransBO();
			vo = new ChallanProcessTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessTransDATA");

			

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
			strmsgText = "ChallanProcessTransDATA.verifyChallanInit(vo) --> "
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

	
	public static boolean verifyInsert(ChallanProcessTransFB formBean) 
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
			System.out.println("---------- ChallanProcessTransDATA . verifyInsert ------------");
			
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
	
	
	public static void cancelChallan(ChallanProcessTransFB formBean) {

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

			
			
			strmsgText = "ChallanProcessTransDATA.cancelChallan(vo) --> "
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
	
	public static void viewChallan(ChallanProcessTransFB formBean,HttpServletRequest request) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strChallanDtl = "";
	
		try {
			System.out.println("---------- ChallanProcessTransDATA . viewChallan ------------");
			
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
				//formBean.setStrPoNoDisplay(temp[1]);
				
				
				
				String strStoreId = formBean.getCombo()[0];				
				String strPoNoDtls[] = formBean.getCombo()[2].split("\\^");
				formBean.setStrPoNo(strPoNoDtls[0]);
				formBean.setStrPoNoDisplay(strPoNoDtls[0]);
				
				vo.setStrStoreId(strStoreId);
				vo.setStrPoNo(strPoNoDtls[0]);
				vo.setStrPoStoreId(strPoNoDtls[1]);			  
			}
			
			bo.viewChallan(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ChallanProcessTransDATA.viewChallan() --> "
								+ vo.getStrMsgString());
			}			
			strChallanDtl = ChallanProcessTransHLP.getChallanReceivedDetails(vo.getWsChallanDtls());
						//System.out.println("strChallan :: "+strChallanDtl);
			formBean.setStrChallanHlpDtl(strChallanDtl);
			formBean.setStrSupplierId(vo.getStrSupplierId());
			formBean.setStrSupplierName(vo.getStrSupplierName());
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "ChallanProcessTransDATA.viewChallan(vo) --> "
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
	public static void getReceivedItemDetails(ChallanProcessTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strReceivedItemDtl = "";
	
		try {
			System.out.println("---------- ChallanProcessTransDATA . getReceivedItemDetails ------------");
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
			
			vo.setStrStoreId(strStoreId);
			vo.setStrPoNo(strPoNo);
			vo.setStrChallanNo(strChallanNo);				
			
			bo.getReceivedItemDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ChallanProcessTransDATA.getReceivedItemDetails() --> "
								+ vo.getStrMsgString());
			}					
			
			strReceivedItemDtl = ChallanProcessTransHLP.getReceivedItemDetails(vo.getWsReceivedItemDtls());			
			
			if(strReceivedItemDtl!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	
			 	response.getWriter().print(strReceivedItemDtl);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "ChallanProcessTransDATA->getReceivedItemDetails()", vo.getStrMsgString());
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
			strmsgText = "ChallanProcessTransDATA.getReceivedItemDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->getReceivedItemDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	
	public static void getVerifiedItemDetails(ChallanProcessTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strVerifiedItemDtl = "";
	
		try {
			System.out.println("---------- ChallanProcessTransDATA . getVerifiedItemDetails ------------");
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
			String strItemId = request.getParameter("strItemId");
			String strItemBrandId = request.getParameter("strItemBrandId");
			 
			vo.setStrStoreId(strStoreId);
			vo.setStrPoNo(strPoNo);
			vo.setStrChallanNo(strChallanNo);
			vo.setStrItemId(strItemId);
			vo.setStrItemBrandId(strItemBrandId);
			
			bo.getVerifiedItemDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ChallanProcessTransDATA.getVerifiedItemDetails() --> "
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
			    HisException eObj = new HisException("MMS", "ChallanProcessTransDATA->getVerifiedItemDetails()", vo.getStrMsgString());
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
			strmsgText = "ChallanProcessTransDATA.getVerifiedItemDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessTransDATA->getVerifiedItemDetails()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	
	public static void print(ChallanProcessTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		ChallanProcessTransBO bo = null;
		ChallanProcessTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strPrintItemDtl = "";
	
		try {
			System.out.println("---------- ChallanProcessTransDATA . print ------------");
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
			
			bo.getPrintDetails(vo);   // PKG_MMS_VIEW.PROC_HSTT_CHALL_VERIFIITEM_DTL --[ Mode - 4 ]
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ChallanProcessTransDATA.getVerifiedItemDetails() --> "
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
			    HisException eObj = new HisException("MMS", "ChallanProcessTransDATA->getVerifiedItemDetails()", vo.getStrMsgString());
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
					"ChallanProcessTransDATA->getPrintItemDetails()", strmsgText);
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
