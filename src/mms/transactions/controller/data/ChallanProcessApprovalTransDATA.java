package mms.transactions.controller.data;


import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.upload.FormFile;

import mms.AttachFileGlobal;
import mms.MmsConfigUtil;
import mms.transactions.bo.ChallanProcessApprovalTransBO;
import mms.transactions.bo.ChallanProcessTransBO;
import mms.transactions.controller.fb.ChallanProcessApprovalTransFB;
import mms.transactions.controller.fb.NewChallanProcessTransFB;
import mms.transactions.controller.hlp.ChallanProcessApprovalTransHLP;
import mms.transactions.controller.hlp.ChallanProcessTransHLP;
import mms.transactions.vo.ChallanProcessApprovalTransVO;
import mms.transactions.vo.ChallanProcessTransVO;

/**
 * 
 * Developer  : Balasubramaniam M Version : 1.0 Date : 12-Jun-2009
 * Modified by: Aadil Wasi on 11-Nov-2013
 * 
 */

public class ChallanProcessApprovalTransDATA {

	public static void receiveChallanInit(ChallanProcessApprovalTransFB formBean,
			HttpServletRequest request) {

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		String strmsgText = "";
		String strReceivedByOptionVal="";
		HisUtil hisutil = null;

		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();

			hisutil = new HisUtil("mms", "ChallanProcessApprovalTransDATA");

			if (formBean.getComboValue() != null
					&& !formBean.getComboValue().equals("")) {

				String strCmbNames = formBean.getComboValue();

				String[] temp = strCmbNames.replace("^", "#").split("#");

				formBean.setStrStoreName(temp[0]);

			}

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strStoreId = formBean.getCombo()[0];
			String strPoNoDtls[] = formBean.getCombo()[2].replace("^", "#")
					.split("#");

			vo.setStrStoreName(formBean.getStrStoreName());
			vo.setStrPoNo(strPoNoDtls[0]);
			vo.setStrPoStoreId(strPoNoDtls[1]);

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);

			bo.receiveInit(vo);

			if (vo.getStrMsgType().equals("1")) {
				vo
						.setStrMsgString("ChallanProcessApprovalTransDATA.receiveChallanInit() --> "
								+ vo.getStrMsgString());
			}

			TransferObjectFactory.populateData(formBean, vo);

			if (!formBean.getStrChallanCount().equals("0")) {

				formBean.setStrDeliveryModeValues("<option value='0'>Select Value</option>");
				formBean.setStrScheduleNoValues("<option value='0'>Select Value</option>");
				formBean.setStrErr("No Receive Until All the Item(s) are Verified");

			} else {

				if (vo.getWsDeliveryMode() != null && vo.getWsDeliveryMode().size() > 0) {

					formBean.setStrDeliveryModeValues(hisutil.getOptionValue(
							vo.getWsDeliveryMode(), "0", "0^Select Value", false,false));

				} else {

					formBean.setStrDeliveryModeValues("<option value='0'>Select Value</option>");

				}

				if (vo.getWsScheduleNo() != null
						&& vo.getWsScheduleNo().size() > 0) {

					formBean.setStrScheduleNoValues(hisutil.getOptionValue(vo.getWsScheduleNo(), formBean.getStrScheduleNo(),"", true, false));

					String[] strScheduleDtls = vo.getStrScheduleNo().replace("^","#").split("#");
					formBean.setStrScheduleNo(strScheduleDtls[0]);
					formBean.setStrScheduleDate(strScheduleDtls[1]);
					formBean.setStrDeliveryDate(strScheduleDtls[2]);
					formBean.setStrScheduleTypeId(strScheduleDtls[3]);
					formBean.setStrScheduleType(strScheduleDtls[4]);
					String ctDate = hisutil.getASDate("dd-MMM-yyyy");
					formBean.setStrCtDate(ctDate);
					formBean.setStrScheduleAndReceiveDtls(ChallanProcessApprovalTransHLP.getScheduleAndReceiveDtls(formBean));
					formBean.setStrScheduledItemDetails(ChallanProcessApprovalTransHLP.getScheduleItemList(formBean, vo));
					
				} else {

					formBean.setStrScheduleNoValues("<option value='0'>Select Value</option>");

				}

				

			}
			if(vo.getRecievedByWS()!=null){
				strReceivedByOptionVal=hisutil.getOptionValue(vo.getRecievedByWS(),"0", "Select Value", true);
				strReceivedByOptionVal=strReceivedByOptionVal+"<option value='1'>Other</option>";
			}else{
				strReceivedByOptionVal="<option value='0'>Select Value</option>";
			}
			
			formBean.setStrReceivedByOptionVal(strReceivedByOptionVal);
	

		} catch (Exception e) {

			e.printStackTrace();
			strmsgText = "Drug Inventory.ChallanProcessApprovalTransDATA.receiveChallanInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->receiveChallanInit()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	public static void getScheduleDtls(ChallanProcessApprovalTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "";

		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessApprovalTransDATA");

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strSchedule = (String) request.getParameter("strScheduleDtls");
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
				formBean.setStrDeliveryModeValues("<option value='0'>Select Value</option>");

			}

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);

			String strScheduleContent = ChallanProcessApprovalTransHLP.getScheduleAndReceiveDtls(formBean);

			strScheduleContent = strScheduleContent + " "+ ChallanProcessApprovalTransHLP.getScheduleItemList(formBean, vo);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strScheduleContent);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {

			strmsgText = "Drug Inventory.ChallanProcessApprovalTransDATA.getScheduleDtls(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->getScheduleDtls()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	public static void getCommitteeMemberDtls(ChallanProcessApprovalTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		String strmsgText = "";

		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strCommitteTypeId = (String) request.getParameter("committeType");

			formBean.setStrCommitteeType(strCommitteTypeId);
			vo.setStrItemCategoryId(request.getParameter("itemCategNo"));
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrCommitteeType(strCommitteTypeId);

			bo.getCommitteeMemberDtls(vo);

			String strMembDtls = ChallanProcessApprovalTransHLP.createMemberDetails(
					formBean, vo.getWsCommitteeMemberList());

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strMembDtls);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {

			strmsgText = "Challan Process.ChallanProcessApprovalTransDATA.getCommitteeMemberDtls(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->getCommitteeMemberDtls()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	public static void getBalanceQtyDtls(ChallanProcessApprovalTransFB formBean,
			HttpServletRequest request, HttpServletResponse response) {

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		String strmsgText = "";

		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();

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

			String strBalanceQtyDtls = ChallanProcessApprovalTransHLP
					.getBalanceQtyDtls(formBean);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strBalanceQtyDtls);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {

			strmsgText = "Challan Process.ChallanProcessApprovalTransDATA.getBalanceQtyDtls(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->getBalanceQtyDtls()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}

	public static boolean insert(ChallanProcessApprovalTransFB formBean) {

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		boolean fltRes = false;
		
		MmsConfigUtil mmsUtil = null;

		String strmsgText = "";

		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();

			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());

			String[] strScheduleDtls = formBean.getStrScheduleNo().replace("^",
					"#").split("#");

			formBean.setStrScheduleNo(strScheduleDtls[0]);
			formBean.setStrScheduleDate(strScheduleDtls[1]);
			formBean.setStrDeliveryDate(strScheduleDtls[2]);
			formBean.setStrScheduleTypeId(strScheduleDtls[3]);
			formBean.setStrScheduleType(strScheduleDtls[4]);

			vo = (ChallanProcessApprovalTransVO) TransferObjectFactory.populateData(
					"mms.transactions.vo.ChallanProcessApprovalTransVO", formBean);

			vo.setStrFinancialStartDate(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode() ));
			vo.setStrFinancialEndDate(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));

			
			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			
			fltRes = true;
			
		} catch (Exception e) {

			strmsgText = "ChallanProcessApprovalTransDATA.insert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->insert()", strmsgText);
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

	public static void verifyChallanInit(ChallanProcessApprovalTransFB formBean,
			HttpServletRequest request) {

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "";

		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessApprovalTransDATA");

			if (formBean.getComboValue() != null
					&& !formBean.getComboValue().equals("")) {

				String strCmbNames = formBean.getComboValue();

				String[] temp = strCmbNames.replace("^", "#").split("#");

				formBean.setStrStoreName(temp[0]);
				formBean.setStrItemCategoryName(temp[1]);

			}

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
					.toString();
			String seatid = request.getSession().getAttribute("SEATID")
					.toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			String strStoreId = formBean.getCombo()[0];

			vo.setStrStoreId(strStoreId);

			String strPoNoDtls[] = formBean.getCombo()[2].replace("^", "#")
					.split("#");

			vo.setStrStoreName(formBean.getStrStoreName());
			vo.setStrPoNo(strPoNoDtls[0]);
			vo.setStrPoStoreId(strPoNoDtls[1]);

			if(request.getParameter("chk") != null){
				
			
			String strChk = request.getParameter("chk");

			String strTemp[] = strChk.replace("@", "#").split("#");

			vo.setStrChallanNo(strTemp[1]);
			vo.setStrGenericItemId(strTemp[2]);
			vo.setStrItemBrandId(strTemp[3]);
			vo.setStrScheduleNo(strTemp[4]);
			
			}else{
				
				vo.setStrChallanNo(vo.getStrChallanNo());
				vo.setStrGenericItemId(vo.getStrGenericItemId());
				vo.setStrItemBrandId(vo.getStrItemBrandId());
				vo.setStrScheduleNo(vo.getStrScheduleNo());
			}
			
			
			
			bo.verifyInit(vo);

			String strManfValues = "<option value='0'>Select Value </option>";

			if (vo.getWsManufacturer() != null
					&& vo.getWsManufacturer().size() > 0) {

				strManfValues = hisutil.getOptionValue(vo.getWsManufacturer(),
						"0", "0^Select Value", false);

			}

			String strUnitVals = "<option value='0'>Select Value </option>";

			if (vo.getWsUnitList() != null && vo.getWsUnitList().size() > 0) {

				strUnitVals = hisutil.getOptionValue(vo.getWsUnitList(), vo.getStrCompositeUnitId(),
						"0^Select Value", false);

			}

			String strRateUnitVals = "<option value='0'>Select Value </option>";

			if (vo.getWsRateUnit() != null && vo.getWsRateUnit().size() > 0) {

				strRateUnitVals = hisutil.getOptionValue(vo.getWsRateUnit(),
						vo.getStrCompRateUnitId(), "0^Select Value", false);

			}

			String strCommitteType = "<option value='0'>Select Value </option>";

			if (vo.getWsCommitteeType() != null
					&& vo.getWsCommitteeType().size() > 0) {

				strCommitteType = hisutil.getOptionValue(vo
						.getWsCommitteeType(), "0", "0^Select Value", false);

			}

			//vo.setStrChallanNo(vo.getStrChallanNo()+"/"+vo.getStrChallanReceiptNo());
			vo.setStrChallanNo(vo.getStrChallanNo());
			TransferObjectFactory.populateData(formBean, vo);

			formBean.setStrManufacturerValues(strManfValues);
			formBean.setStrUnitValues(strUnitVals);
			formBean.setStrRateUnitValues(strRateUnitVals);
			formBean.setStrCommitteeTypeValues(strCommitteType);

			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
			
            MmsConfigUtil mmscofigutil = new  MmsConfigUtil(formBean.getStrHospitalCode());	
			
			formBean.setStrConfigIssueRate(mmscofigutil.getStrConfigIssueRate());
			if(formBean.getStrConfigIssueRate().equals("0"))
			{
				formBean.setStrIssueRateConfigFlg("0");
			}
			else
			{
				formBean.setStrIssueRateConfigFlg("1");
			}

		} catch (Exception e) {
	
			strmsgText = "ChallanProcessApprovalTransDATA.verifyChallanInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->verifyChallanInit()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}

	
	public static boolean verifyInsert(ChallanProcessApprovalTransFB formBean) {

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

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

		try {
			
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();
			hisutil=new HisUtil("mms", "ChallanProcessApprovalTransDATA");
			fs=new AttachFileGlobal();
			
			strCurrentDate = hisutil.getASDate("dd-MMM-yyyy");
			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());


			vo = (ChallanProcessApprovalTransVO) TransferObjectFactory.populateData(
					"mms.transactions.vo.ChallanProcessApprovalTransVO", formBean);

			vo.setStrFinancialStartDate(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode() ));
			vo.setStrFinancialEndDate(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));

			
			vo.setStrAcceptedQuantityUnitId(formBean.getStrAcceptedQuantityUnitId().replace("^", "#").split("#")[0]);
			vo.setStrRejectedQuantityUnitId(formBean.getStrRejectedQuantityUnitId().replace("^", "#").split("#")[0]);
			vo.setStrBalanceQuantityUnitId(formBean.getStrBalanceQuantityUnitId().replace("^", "#").split("#")[0]);
			vo.setStrBreakageQuantityUnitId(formBean.getStrBreakageQuantityUnitId().replace("^", "#").split("#")[0]);
			vo.setStrExcessQtyUnitId(formBean.getStrExcessQtyUnitId().replace("^", "#").split("#")[0]);
			vo.setStrSalePriceUnitId(formBean.getStrSalePriceUnitId().replace("^", "#").split("#")[0]);
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrFileNo(formBean.getStrFileNo());
			vo.setStrPageNo(formBean.getStrPageNo());
			vo.setStrCommitteeMemberHidden(formBean.getStrCommitteeMemberHidden());
			FormFile myFile = formBean.getStrLocation();
			strFileExt=myFile.getFileName();
			temp=strFileExt.replace('.', '#').split("#");
			strFileExt=temp[temp.length-1];
			strFileName=vo.getStrStoreId()+"_"+vo.getStrChallanNo()+"_"+vo.getStrHospitalCode()+"_"+strCurrentDate+"."+strFileExt;
			vo.setStrFileName(strFileName);
			// Calling BO Method
			bo.verifyInsert(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
		//	filePath=mmsUtil.getStrCommitteeFilePath();
		//	fs.saveFile(myFile.getFileData(), strFileName); 
 
			fltRes = true;	

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = "ChallanProcessApprovalTransDATA.verifyInsert(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->verifyInsert()", strmsgText);
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
	
	
	public static void cancelChallan(ChallanProcessApprovalTransFB formBean) {

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;


		String strmsgText = "";

		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();

			String strPkValues = formBean.chk[0];
			
			String[] strTemp = strPkValues.replace("@", "#").split("#");
			
			vo.setStrStoreId(strTemp[0]);
			vo.setStrChallanNo(strTemp[1]);
			vo.setStrGenericItemId(strTemp[2]);
			vo.setStrItemBrandId(strTemp[3]);
			
			String strPoValues = formBean.getCombo()[2];
			
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

			
			
			strmsgText = "ChallanProcessApprovalTransDATA.cancelChallan(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->cancelChallan()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	public static void cancelVerifiedChallan(ChallanProcessApprovalTransFB formBean) {

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;


		String strmsgText = "";

		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();

			String strPkValues = formBean.chk[0];
			
			String[] strTemp = strPkValues.replace("@", "#").split("#");
			
			vo.setStrStoreId(strTemp[0]);
			vo.setStrChallanNo(strTemp[1]);
			vo.setStrGenericItemId(strTemp[2]);
			vo.setStrItemBrandId(strTemp[3]);
			
			vo.setStrScheduleNo(strTemp[5].split("\\$")[0]);
			
			
			String strPoValues = formBean.getCombo()[2];
			
			String[] strTemp1 = strPoValues.replace("^", "#").split("#");
			
			vo.setStrPoNo(strTemp1[0]);
			vo.setStrPoStoreId(strTemp1[1]);
			vo.setStrRemarks(formBean.getComboValue());
			
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			
			bo.cancelVerifiedChallan(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

		} catch (Exception e) {

			
			
			strmsgText = "ChallanProcessApprovalTransDATA.cancelChallan(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->cancelChallan()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;

		}

	}
	
	/**
	 * View challan.
	 * @author santoshsinghchauhan
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void viewChallan(ChallanProcessApprovalTransFB formBean,HttpServletRequest request) 
	{

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strChallanDtl = "";
	
		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessApprovalTransDATA");		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
		
			if(formBean.getCombo()[0] != "0" && formBean.getCombo()[2] != "0")
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
				vo.setStrMsgString("ChallanProcessApprovalTransDATA.viewChallan() --> "
								+ vo.getStrMsgString());
			}			
			strChallanDtl = ChallanProcessApprovalTransHLP.getChallanReceivedDetails(vo.getWsChallanDtls());
						
			formBean.setStrChallanHlpDtl(strChallanDtl);
			formBean.setStrSupplierId(vo.getStrSupplierId());
			formBean.setStrSupplierName(vo.getStrSupplierName());
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "ChallanProcessApprovalTransDATA.viewChallan(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->viewChallan()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	public static void viewChallanBS(ChallanProcessApprovalTransFB formBean,HttpServletRequest request) 
	{

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strChallanDtl = "";
	
		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessApprovalTransDATA");		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
		
			if(formBean.getCombo()[0] != "0" && formBean.getCombo()[2] != "0")
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
				vo.setStrMsgString("ChallanProcessApprovalTransDATA.viewChallan() --> "
								+ vo.getStrMsgString());
			}			
			strChallanDtl = ChallanProcessApprovalTransHLP.getChallanReceivedDetailsBS(vo.getWsChallanDtls());
						
			formBean.setStrChallanHlpDtl(strChallanDtl);
			formBean.setStrSupplierId(vo.getStrSupplierId());
			formBean.setStrSupplierName(vo.getStrSupplierName());
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "ChallanProcessApprovalTransDATA.viewChallan(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->viewChallan()", strmsgText);
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
	 * Gets the received item details.
	 * @author santoshsinghchauhan
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the received item details
	 */
	public static void getReceivedItemDetails(ChallanProcessApprovalTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strReceivedItemDtl = "";
	
		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessApprovalTransDATA");		

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
				vo.setStrMsgString("ChallanProcessApprovalTransDATA.getReceivedItemDetails() --> "
								+ vo.getStrMsgString());
			}					
			
			strReceivedItemDtl = ChallanProcessApprovalTransHLP.getReceivedItemDetails(vo.getWsReceivedItemDtls());			
			
			if(strReceivedItemDtl!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	
			 	response.getWriter().print(strReceivedItemDtl);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "ChallanProcessApprovalTransDATA->getReceivedItemDetails()", vo.getStrMsgString());
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
			strmsgText = "ChallanProcessApprovalTransDATA.getReceivedItemDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->getReceivedItemDetails()", strmsgText);
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
	 * Gets the verified item details.
	 * @author santoshsinghchauhan
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the verified item details
	 */
	public static void getVerifiedItemDetails(ChallanProcessApprovalTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strVerifiedItemDtl = "";
	
		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessApprovalTransDATA");		

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
				vo.setStrMsgString("ChallanProcessApprovalTransDATA.getVerifiedItemDetails() --> "
								+ vo.getStrMsgString());
			}					
			strVerifiedItemDtl = ChallanProcessApprovalTransHLP.getVerifiedItemDetails(vo.getWsVerifiedItemDtls());			
			
			if(strVerifiedItemDtl!= null)
			{	
			 	response.setHeader("Cache-Control", "no-cache");
			 	
			 	response.getWriter().print(strVerifiedItemDtl);
			 		 
			}
			 else
			 {
			    HisException eObj = new HisException("MMS", "ChallanProcessApprovalTransDATA->getVerifiedItemDetails()", vo.getStrMsgString());
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
			strmsgText = "ChallanProcessApprovalTransDATA.getVerifiedItemDetails(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->getVerifiedItemDetails()", strmsgText);
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
	 * freezeChallanInit challan init.
	 * @author vivek
	 * @param formBean the form bean
	 * @param request the request
	 */
	public static void freezeChallanInit(ChallanProcessApprovalTransFB formBean,HttpServletRequest request) 
	{

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strChallanDtl = "", strVerifiedItemDtl = "";
	
		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessApprovalTransDATA");

			

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			
			//99901105@10681300001@10000007@10100007@999@Fresh Supply$1
			//HSTNUM_STORE_ID ||'@'|| HSTNUM_CHALLAN_NO ||'@'|| HSTNUM_ITEM_ID ||'@'|| HSTNUM_ITEMBRAND_ID ||'@'|| GNUM_HOSPITAL_CODE||'@'|| HSTNUM_SCHEDULE_TYPE
			
			if(request.getParameter("chk") != null)
			{				
				String strStoreId = formBean.getCombo()[0];
				
				String strPoNoDtls[] = formBean.getCombo()[2].split("\\^");
				
				vo.setStrStoreId(strStoreId);
				vo.setStrPoNo(strPoNoDtls[0]);
				vo.setStrPoStoreId(strPoNoDtls[1]);
				vo.setStrPoDate(strPoNoDtls[2]);
				formBean.setStrPoStoreId(vo.getStrPoStoreId());
				
			  String strChk = request.getParameter("chk");
			  String strTemp[] = strChk.split("\\@");
			  vo.setStrChallanNo(strTemp[1]);
			 // vo.setStrGenericItemId(strTemp[2]);
			//  vo.setStrItemBrandId(strTemp[3]);
			  
			}
			// Calling BO Method
			bo.freezeChallanInit(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				vo.setStrMsgString("ChallanProcessApprovalTransDATA.freezeChallanInit() --> "
								+ vo.getStrMsgString());
			}
		
			if (vo.getWrsChallanDtl() != null	&& vo.getWrsChallanDtl().size() > 0) 
			{
				System.out.println("---  ChallanProcessApprovalTransHLP.getChallanDtlForFreeze ---");
				
				strChallanDtl = ChallanProcessApprovalTransHLP.getChallanDtlForFreeze(vo.getWrsChallanDtl());
			}			
			formBean.setStrChallanHlpDtl(strChallanDtl);
			
			if (vo.getWrsVerifiedItemDtl() != null	&& vo.getWrsVerifiedItemDtl().size() > 0) 
			{
				System.out.println("---  ChallanProcessApprovalTransHLP.getVerifiedItemDtlForFreeze ---");
				
				strVerifiedItemDtl = ChallanProcessApprovalTransHLP.getVerifiedItemDtlForFreeze(vo.getWrsVerifiedItemDtl());
			}
			formBean.setStrVerifiedItemHlpDtl(strVerifiedItemDtl);
			formBean.setStrPoDate(vo.getStrPoDate());
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "ChallanProcessApprovalTransDATA.freezeChallanInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->freezeChallanInit()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	public static void freezeChallanInitBS(ChallanProcessApprovalTransFB formBean,HttpServletRequest request) 
	{

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strChallanDtl = "", strVerifiedItemDtl = "";
	
		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessApprovalTransDATA");

			

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);

			
			//99901105@10681300001@10000007@10100007@999@Fresh Supply$1
			//HSTNUM_STORE_ID ||'@'|| HSTNUM_CHALLAN_NO ||'@'|| HSTNUM_ITEM_ID ||'@'|| HSTNUM_ITEMBRAND_ID ||'@'|| GNUM_HOSPITAL_CODE||'@'|| HSTNUM_SCHEDULE_TYPE
			
			if(request.getParameter("chk") != null)
			{				
				String strStoreId = formBean.getCombo()[0];
				
				String strPoNoDtls[] = formBean.getCombo()[2].split("\\^");
				
				vo.setStrStoreId(strStoreId);
				vo.setStrPoNo(strPoNoDtls[0]);
				vo.setStrPoStoreId(strPoNoDtls[1]);
				vo.setStrPoDate(strPoNoDtls[2]);
				formBean.setStrPoStoreId(vo.getStrPoStoreId());
				
			  String strChk = request.getParameter("chk");
			  String strTemp[] = strChk.split("\\@");
			  vo.setStrChallanNo(strTemp[1]);
			 // vo.setStrGenericItemId(strTemp[2]);
			//  vo.setStrItemBrandId(strTemp[3]);
			  
			}
			// Calling BO Method
			bo.freezeChallanInit(vo);
			
			if (vo.getStrMsgType().equals("1")) 
			{
				vo.setStrMsgString("ChallanProcessApprovalTransDATA.freezeChallanInit() --> "
								+ vo.getStrMsgString());
			}
		
			if (vo.getWrsChallanDtl() != null	&& vo.getWrsChallanDtl().size() > 0) 
			{
				
				strChallanDtl = ChallanProcessApprovalTransHLP.getChallanDtlForFreezeBS(vo.getWrsChallanDtl());
			}			
			formBean.setStrChallanHlpDtl(strChallanDtl);
			
			if (vo.getWrsVerifiedItemDtl() != null	&& vo.getWrsVerifiedItemDtl().size() > 0) 
			{
				strVerifiedItemDtl = ChallanProcessApprovalTransHLP.getVerifiedItemDtlForFreezeBS(vo.getWrsVerifiedItemDtl());
			}
			formBean.setStrVerifiedItemHlpDtl(strVerifiedItemDtl);
			formBean.setStrPoDate(vo.getStrPoDate());
			
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			formBean.setStrCtDate(ctDate);
		} 
		catch (Exception e) 
		{
	        e.printStackTrace();
			strmsgText = "ChallanProcessApprovalTransDATA.freezeChallanInit(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->freezeChallanInit()", strmsgText);
			formBean.setStrErr("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
			hisutil = null;
		}

	}
	
	public static boolean insertFreezeChallan(ChallanProcessApprovalTransFB formBean,HttpServletRequest request) {

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		boolean fltRes = false;
		
		MmsConfigUtil mmsUtil = null;

		String strmsgText = "";

		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();

			mmsUtil = new MmsConfigUtil(formBean.getStrHospitalCode());

			//String[] strScheduleDtls = formBean.getStrScheduleNo().replace("^","#").split("#");

			//formBean.setStrScheduleNo(strScheduleDtls[0]);
			//formBean.setStrScheduleDate(strScheduleDtls[1]);
			//formBean.setStrDeliveryDate(strScheduleDtls[2]);
			//formBean.setStrScheduleTypeId(strScheduleDtls[3]);
			//formBean.setStrScheduleType(strScheduleDtls[4]);
			////System.out.println("strSupplierReceiptNo==>"+formBean.getStrSupplierReceiptNo());
			vo = (ChallanProcessApprovalTransVO) TransferObjectFactory.populateData("mms.transactions.vo.ChallanProcessApprovalTransVO", formBean);

			vo.setStrFinancialStartDate(mmsUtil.getStrFinancialStartDate(vo.getStrStoreId() , vo.getStrHospitalCode() ));
			vo.setStrFinancialEndDate(mmsUtil.getStrFinancialEndDate(vo.getStrStoreId() , vo.getStrHospitalCode()));
            
			// Calling BO Method Here
			bo.insertFreezeChallan(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			
			fltRes = true;
			
		}
		catch (Exception e)
		{
            e.printStackTrace();
			strmsgText = "ChallanProcessApprovalTransDATA.insertFreezeChallan(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"ChallanProcessApprovalTransDATA->insert()", strmsgText);
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
	
	public static void print(ChallanProcessApprovalTransFB formBean,HttpServletRequest request, HttpServletResponse response) 
	{

		ChallanProcessApprovalTransBO bo = null;
		ChallanProcessApprovalTransVO vo = null;

		HisUtil hisutil = null;

		String strmsgText = "", strPrintItemDtl = "";
	
		try {
			bo = new ChallanProcessApprovalTransBO();
			vo = new ChallanProcessApprovalTransVO();
			hisutil = new HisUtil("mms", "ChallanProcessApprovalTransDATA");		

			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			String strPkValues = formBean.chk[0];
			
			String[] strTemp = strPkValues.replace("@", "#").split("#");
			
			vo.setStrStoreId(strTemp[0]);
			vo.setStrChallanNo(strTemp[1]);
			/*String modPopUp = request.getParameter("modPopUp");
			String strStoreId =modPopUp.replace("^", "#").split("#")[0];
			//String strPoNo = request.getParameter("strPoNo");
			String strChallanNo = modPopUp.replace("^", "#").split("#")[1];	*/
			//String strItemId = request.getParameter("strItemId");
			//String strItemBrandId = request.getParameter("strItemBrandId");
			 
			/*vo.setStrStoreId(strStoreId);
			//vo.setStrPoNo("0");
			vo.setStrChallanNo(strChallanNo);*/
			//vo.setStrItemId(strItemId);
			//vo.setStrItemBrandId(strItemBrandId);
			
			bo.getPrintDetails(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				vo.setStrMsgString("ChallanProcessApprovalTransDATA.getVerifiedItemDetails() --> "
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
}
