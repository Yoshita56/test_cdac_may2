/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferDemandReqTransDATA.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import mms.MmsConfigUtil;
import mms.transactions.bo.TransferDemandReqTransBO;
import mms.transactions.controller.fb.TransferDemandReqTransFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.TransferDemandReqTransHLP;
import mms.transactions.vo.TransferDemandReqTransVO;

/**
 * The Class TransferDemandReqTransDATA.
 */
public class TransferDemandReqTransDATA {

	/** The DAT e_ forma t_ no wwt. */
	public static String dateFormatNowWt = "dd-MMM-yyyy HH:mm:ss";

	/** The date format now. */
	public static String dateFormatNow = "dd-MMM-yyyy";

	/**
	 * Now.
	 * 
	 * @param frmt the frmt
	 * @return the string
	 */
	public static String now(String frmt) {
		HisUtil util = null;
		String a = "";
		util = new HisUtil("transaction", "PatientLeaveHLP");
		try {
			a = util.getASDate(frmt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;
	}

	/**
	 * to display the Store Name and Group Name on Add page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */

	public static void initialAdd(TransferDemandReqTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		TransferDemandReqTransBO bo = null;
		TransferDemandReqTransVO vo = null;
		String strmsgText = "";
		String strStoreName = "";
		try {
			bo = new TransferDemandReqTransBO();
			vo = new TransferDemandReqTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			if (request.getParameter("comboValue") == null) {
				strStoreName = formBean.getStrStoreName();
			} else {
				strStoreName = request.getParameter("comboValue");
			}
			request.getParameterValues("combo");
			formBean.setStrStoreName(strStoreName);
			String strStoreId = formBean.getCombo()[0];
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");
			formBean.setStrDefaultCurrencyCode(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			// Calling BO Method
			bo.initialAdd(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			String str = "<option value='0'>Select Value</option>";
			formBean.setStrGroupNameCombo(vo.getStrGroupNameCombo());
			formBean.setStrSubGroupCombo(vo.getStrSubGroupCombo());
			formBean.setStrItemNameCombo(vo.getStrItemNameCombo());
			formBean.setStrCtDate(now(dateFormatNow));
			formBean.setStrOnlineAppStatus(vo.getStrOnlineAppStatus());

			// if approval doesn't exist then get offline Approval details
			if (vo.getStrOnlineAppStatus().equals("0")) {
				bo.getApprovalDetails(vo);
				formBean.setStrApprovedByCombo(vo.getStrApprovedByCombo());
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA->initialAdd()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * to display the Store Name and Group Name on Add page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */

	public static void initModify(TransferDemandReqTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		TransferDemandReqTransBO bo = null;
		TransferDemandReqTransVO vo = null;
		String strmsgText = "";
		String[] strChkArr = null;
		try {
			bo = new TransferDemandReqTransBO();
			vo = new TransferDemandReqTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strStoreName = request.getParameter("comboValue");
			formBean.setStrStoreName(strStoreName);
			String strStoreId = formBean.getCombo()[0];

			String strChk = formBean.getStrChk();
			strChkArr = strChk.replace("$", "@").split("\\@");

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);
			vo.setStrRequestNo(strChkArr[0]);
			vo.setStrSerialNo(strChkArr[1]);
			vo.setStrItemCategoryNo("10");
			vo.setStrChk(strChk);
			// Calling BO Method
			bo.initialModify(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				while (vo.getStrModifyDtlWS().next()) {
					formBean.setStrRequestNoView(vo.getStrRequestNo());
					formBean.setStrReqDate(vo.getStrModifyDtlWS().getString(1));
					formBean.setStrItemNameView(vo.getStrModifyDtlWS().getString(2));
					formBean.setStrReqQtyView(vo.getStrModifyDtlWS().getString(3));
					formBean.setStrUnitNameView(vo.getStrModifyDtlWS().getString(4));
					formBean.setStrGroupNameView(vo.getStrModifyDtlWS().getString(5));
					formBean.setStrStoreNameView(vo.getStrModifyDtlWS().getString(6));
					formBean.setStrApprovedByView(vo.getStrModifyDtlWS().getString(7));
					formBean.setStrApprovedDateView(vo.getStrModifyDtlWS().getString(8));
					formBean.setStrApprovedStatusView(vo.getStrModifyDtlWS().getString(9));
					formBean.setStrSubGroupNameView(vo.getStrModifyDtlWS().getString(10));
					formBean.setStrRemarks(vo.getStrModifyDtlWS().getString(11));
					formBean.setStrRaisingAvlQtyWithUnitView(vo.getStrModifyDtlWS().getString(12));
				}
			}

			formBean.setStrOnlineAppStatus(vo.getStrOnlineAppStatus());

			// if approval doesn't exist then get offline Approval details
			if (vo.getStrOnlineAppStatus().equals("0")) {
				bo.getApprovalDetails(vo);
				formBean.setStrApprovedByCombo(vo.getStrApprovedByCombo());
			}

			formBean.setStrCtDate(now(dateFormatNow));
			formBean.setStrModifyChk(vo.getStrChk());
			formBean.setStrChk(vo.getStrChk());

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA->initModify()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * to display the Store Name and Group Name on Add page.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */

	public static void initView(TransferDemandReqTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		TransferDemandReqTransBO bo = null;
		TransferDemandReqTransVO vo = null;
		String strmsgText = "";
		String path = "";
		
		try {
			bo = new TransferDemandReqTransBO();
			vo = new TransferDemandReqTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strStoreName = request.getParameter("comboValue");
			request.getParameterValues("combo");
			formBean.setStrStoreName(strStoreName);

			path = "/mms" + request.getParameter("cnt_page") + ".cnt";

			if (request.getParameter("cnt_page") == null) {

				path = request.getParameter("strPath");
			}

			formBean.setStrPath(path.trim());
			
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getStrStoreId());			
			if (formBean.getStrOrderView().equals("0")) 
			{
				String strChk = formBean.getStrChk();
				//HSTNUM_REQUEST_NO||'@'|| MODIFY_CANCEL_FLAG ||'@'||HSTNUM_SLNO
				//10921400024         @            1             @      1         $  2
				System.out.println("strChk--Shortage-->"+strChk);
				//System.out.println("Req No---->"+(strChk.split("\\$")[0]).split("\\@")[0]);
				// Request No @ Cancel Flg
				vo.setStrRequestNo((strChk.split("\\@")[0]));
				vo.setStrSerialNo((strChk.split("\\@")[1]));
				vo.setStrItemCategoryNo("10");
				vo.setStrChk(strChk);
			}
			else
			{
				vo.setStrRequestNo(formBean.getStrRequestNo());
				vo.setStrSerialNo(formBean.getStrSerialNo());
				vo.setStrItemCategoryNo("10");
				vo.setStrChk(formBean.getStrRequestNo()+"@0@"+formBean.getStrSerialNo());
			}

			// Calling BO Method
			bo.initialView(vo);  // PKG_MMS_VIEW.proc_transfer_demand_dtls [Mode =1]
			                     // PKG_MMS_VIEW.proc_transfer_order_dtl [Mode =1 ]

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{
				while (vo.getStrModifyDtlWS() != null && vo.getStrModifyDtlWS().next()) 
				{
					formBean.setStrRequestNoView(vo.getStrRequestNo());
					formBean.setStrRequestDateView(vo.getStrModifyDtlWS().getString(1));
					formBean.setStrItemNameView(vo.getStrModifyDtlWS().getString(2));
					formBean.setStrReqQtyView(vo.getStrModifyDtlWS().getString(3));
					formBean.setStrUnitNameView(vo.getStrModifyDtlWS().getString(4));
					formBean.setStrGroupNameView(vo.getStrModifyDtlWS().getString(5));
					formBean.setStrStoreNameView(vo.getStrModifyDtlWS().getString(6));
					formBean.setStrApprovedByView(vo.getStrModifyDtlWS().getString(7));
					formBean.setStrApprovedDateView(vo.getStrModifyDtlWS().getString(8));
					formBean.setStrApprovedStatusView(vo.getStrModifyDtlWS().getString(9));
					formBean.setStrReqQtyWithUnitView(vo.getStrModifyDtlWS().getString(10));
					formBean.setStrApprovedQtyWithUnitView(vo.getStrModifyDtlWS().getString(11));
					formBean.setStrAckQtyWithUnitView(vo.getStrModifyDtlWS().getString(12));
					formBean.setStrRaisingAvlQtyWithUnitView(vo.getStrModifyDtlWS().getString(13));
					formBean.setStrAckAvlQtyWithUnitView(vo.getStrModifyDtlWS().getString(14));
					formBean.setStrRaisingRemarksView(vo.getStrModifyDtlWS().getString(15));
					formBean.setStrOrderBySeatIdView(vo.getStrModifyDtlWS().getString(16));
					formBean.setStrOrderByDateView(vo.getStrModifyDtlWS().getString(17));
					formBean.setStrOrderRemarksView(vo.getStrModifyDtlWS().getString(18));
					formBean.setStrStatusView(vo.getStrModifyDtlWS().getString(19));
					formBean.setStrSubGroupNameView(vo.getStrModifyDtlWS().getString(20));

				}
				formBean.setWbTransferOrderDetail(vo.getWbTransferOrderDetail());
			}
			formBean.setStrCtDate(now(dateFormatNow));
			String strTransferOrderDetails = TransferDemandReqTransHLP.getTransferOrderDetails(formBean,request);
			/** @param strFrmStoreId the str frm store id
			 * @param strHospCode the str hosp code
			 * @param strReqStatus the str req status
			 * @param strReqNo the str req no
			 */
			String str2 = ApprovalDtlHLP.getApprovalDtlNew(vo.getStrStoreId(), vo.getStrHospitalCode(), "", vo.getStrRequestNo(),request);
			formBean.setStrSetApprovedDetails(str2);
			formBean.setStrTransferOrderDetails(strTransferOrderDetails);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = "Drug Transfer.TransferDemandReqTransDATA.initView(vo) --> " + e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA->initView()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * To get values of SubgroupCombo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */

	public static void subGroupCombo(TransferDemandReqTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		String strmsgText = "";
		TransferDemandReqTransBO bo = null;
		TransferDemandReqTransVO vo = null;
		try {

			bo = new TransferDemandReqTransBO();
			vo = new TransferDemandReqTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			String strSeatId = request.getSession().getAttribute("SEATID").toString();
			String strGroupId = request.getParameter("GroupId");
			String strStoreId = request.getParameter("storeId");

			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrGroupId(strGroupId);

			bo.subGrpAndItemCmb(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			String subGrpCmbStr = vo.getStrSubGroupCombo();
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(subGrpCmbStr);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA->subGroupCombo()", strmsgText);

		} finally {
			vo = null;
			bo = null;

		}
	}

	/**
	 * To get values of Item Name Combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */

	public static void itemBrandName(TransferDemandReqTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		String strmsgText = "";
		TransferDemandReqTransBO bo = null;
		TransferDemandReqTransVO vo = null;

		try {

			bo = new TransferDemandReqTransBO();
			vo = new TransferDemandReqTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();

			String strStoreId = request.getParameter("storeId");
			String strGroupId = request.getParameter("strGroupId");
			String strSubGroupId = request.getParameter("strSubGroupId");

			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");
			vo.setStrGroupId(strGroupId);
			vo.setStrSubGroupId(strSubGroupId);

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			bo.getItemBrandCmb(vo);

			String cmbstr = vo.getStrItemNameCombo();

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA->itemBrandName()", strmsgText);

		} finally {
			vo = null;
			bo = null;
		}
	}

	/**
	 * To get values of Item Name Combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */

	public static void transferDtl(TransferDemandReqTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		String strmsgText = "";
		TransferDemandReqTransBO bo = null;
		TransferDemandReqTransVO vo = null;
		String cmbstr = "";

		try {

			bo = new TransferDemandReqTransBO();
			vo = new TransferDemandReqTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();

			String strHiddenValue = request.getParameter("strHiddenValue");
			String strPrintFlag = request.getParameter("printFlag");

			vo.setStrRequestNo(strHiddenValue.split("\\^")[0]);
			vo.setStrStoreId(strHiddenValue.split("\\^")[8]);
			vo.setStrOrderNumber(strHiddenValue.split("\\^")[9]);
			vo.setStrOrderSlNo(strHiddenValue.split("\\^")[10]);
			vo.setStrItemCategoryNo("10");
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			bo.getTransferDtl(vo);  // PKG_MMS_VIEW.proc_trasfer_trans_dtls [Mode =1]

			formBean.setWbTransferOrderDetail(vo.getWbTransferOrderDetail());

			if (strPrintFlag.equals("1")) {
				cmbstr = TransferDemandReqTransHLP.getTransferDetails(formBean);
			} else {
				cmbstr = TransferDemandReqTransHLP.getTransferDetailsPrintScreen(formBean);
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA->transferDtl()", strmsgText);

		} finally {
			vo = null;
			bo = null;
		}
	}

	/**
	 * To get values of Item Name Combo.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */

	public static void transferItem(TransferDemandReqTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		String strmsgText = "";
		String cmbstr = "";
		TransferDemandReqTransBO bo = null;
		TransferDemandReqTransVO vo = null;

		try {

			bo = new TransferDemandReqTransBO();
			vo = new TransferDemandReqTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();

			String strTransferNo = request.getParameter("strTransferNo").split("\\^")[0];
			vo.setStrStoreId(request.getParameter("strTransferNo").split("\\^")[2]);
			vo.setStrRequestNo(strTransferNo);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			// Calling Demand Genration BO Method
			bo.getTransferItemDtl(vo);

			cmbstr = TransferDemandReqTransHLP.getDrugDetails(vo.getWbTransferOrderDetail(), formBean, request);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr + "^" + request.getParameter("strTransferNo").split("\\^")[1]);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA->tratransferItemnsferItem()", strmsgText);

		} finally {
			vo = null;
			bo = null;
		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */

	public static void insert(TransferDemandReqTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {
		String strmsgText = "";
		TransferDemandReqTransBO bo = null;
		TransferDemandReqTransVO vo = null;

		try {
			bo = new TransferDemandReqTransBO();
			vo = (TransferDemandReqTransVO) TransferObjectFactory.populateData("mms.transactions.vo.TransferDemandReqTransVO", formBean);
			// Calling BO method
			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {
				formBean.setStrErrMsg(vo.getStrMsgString());

				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrNormalMsg("Data has been Successfully Saved");
			}

		} catch (Exception e) {
			formBean.setStrStoreName(vo.getStrStoreName());
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA->insert()", strmsgText);

		} finally {

			bo = null;
			vo = null;

		}
	}

	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */

	public static void update(TransferDemandReqTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {
		String strmsgText = "";
		String[] strChkArr = null;
		TransferDemandReqTransBO bo = null;
		TransferDemandReqTransVO vo = null;

		try {
			bo = new TransferDemandReqTransBO();
			vo = new TransferDemandReqTransVO();
			String strChk = formBean.getStrChk();
			strChkArr = strChk.replace("$", "@").split("\\@");

			vo = (TransferDemandReqTransVO) TransferObjectFactory.populateData("mms.transactions.vo.TransferDemandReqTransVO", formBean);
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrRequestNo(strChkArr[0]);
			vo.setStrSerialNo(strChkArr[1]);
			vo.setStrItemCategoryNo("10");
			// Calling BO method
			bo.update(vo);

			if (vo.getStrMsgType().equals("1")) {
				formBean.setStrErrMsg(vo.getStrMsgString());

				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrNormalMsg("Data Has been Updated Successfully Saved");
			}

		} catch (Exception e) {
			formBean.setStrStoreName(vo.getStrStoreName());
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA->update()", strmsgText);

		} finally {

			bo = null;
			vo = null;

		}
	}

	/**
	 * This function is used to invoke Bo's update method to update data.
	 * 
	 * @param request the request
	 * @param formBean the form bean
	 * @param response the response
	 * @return true, if successful
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static boolean cancelRecord(HttpServletRequest request, TransferDemandReqTransFB formBean, HttpServletResponse response)
			throws IOException, ServletException {
		TransferDemandReqTransBO bo = null;
		TransferDemandReqTransVO vo = null;
		boolean retValue = true;
		// String tempChk[] = null;

		try {
			bo = new TransferDemandReqTransBO();
			vo = new TransferDemandReqTransVO();
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();

			String strStoreName = request.getParameter("comboValue");
			request.getParameterValues("combo");
			formBean.setStrStoreName(strStoreName);
			String strStoreId = formBean.getCombo()[0];

			String strChk = formBean.getStrChk();

			String[] temp = strChk.replace("$", "@").split("\\@");

			vo.setStrItemCategoryNo("10");
			vo.setStrRequestNo(temp[0]);
			vo.setStrSerialNo(temp[1]);
			vo.setStrStoreId(strStoreId);
			vo.setStrSeatId(strSeatId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrCancelReson(temp[2]);
			// Calling BO Method
			bo.cancel(vo);
			if (vo.getStrMsgType().equals("1")) {
				retValue = false;
				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrNormalMsg("Record is successfully Cancel");

			}
		} catch (Exception e) {
			retValue = false;
			String strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA->cancelRecord()", strmsgText);

		} finally {
			bo = null;
			vo = null;
		}
		return retValue;
	}

	/**
	 * Gets the prints the screen two.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void getPrintScreenTwo(TransferDemandReqTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		TransferDemandReqTransBO bo = null;
		TransferDemandReqTransVO vo = null;
		String strmsgText = "";
		try {
			bo = new TransferDemandReqTransBO();
			vo = new TransferDemandReqTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			String strChk = request.getParameter("strChk");
			String storeId = request.getParameter("storeId");
			String strStoreName = request.getParameter("strStoreName");
			String strOrderView = request.getParameter("strOrderView");
			String strReqNO = strChk.split("\\$")[0].split("\\@")[0];			
			String[] temp = strChk.replace("$", "@").split("\\@");

			vo.setStrItemCategoryNo("10");
			vo.setStrRequestNo(temp[0]);
			if(strOrderView.equals("1"))
			{
				vo.setStrSerialNo(temp[2]);
			}
			else
			{	
			   vo.setStrSerialNo(temp[1]);
			}
			
			formBean.setStrRequestNo(strReqNO);
			formBean.setStrStoreId(storeId);
			formBean.setStrStoreName(strStoreName);

			vo.setStrHospitalCode(hosCode);
			
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getStrStoreId());
			//vo.setStrRequestNo(strReqNO);
			vo.setStrItemCategoryNo("10");

			// Calling BO Method
			bo.initialView(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				while (vo.getStrModifyDtlWS() != null && vo.getStrModifyDtlWS().next()) {
					formBean.setStrRequestNoView(vo.getStrRequestNo());
					formBean.setStrRequestDateView(vo.getStrModifyDtlWS().getString(1));
					formBean.setStrItemNameView(vo.getStrModifyDtlWS().getString(2));
					formBean.setStrReqQtyView(vo.getStrModifyDtlWS().getString(3));
					formBean.setStrUnitNameView(vo.getStrModifyDtlWS().getString(4));
					formBean.setStrGroupNameView(vo.getStrModifyDtlWS().getString(5));
					formBean.setStrStoreNameView(vo.getStrModifyDtlWS().getString(6));
					formBean.setStrApprovedByView(vo.getStrModifyDtlWS().getString(7));
					formBean.setStrApprovedDateView(vo.getStrModifyDtlWS().getString(8));
					formBean.setStrApprovedStatusView(vo.getStrModifyDtlWS().getString(9));
					formBean.setStrReqQtyWithUnitView(vo.getStrModifyDtlWS().getString(10));
					formBean.setStrApprovedQtyWithUnitView(vo.getStrModifyDtlWS().getString(11));
					formBean.setStrAckQtyWithUnitView(vo.getStrModifyDtlWS().getString(12));
					formBean.setStrRaisingAvlQtyWithUnitView(vo.getStrModifyDtlWS().getString(13));
					formBean.setStrAckAvlQtyWithUnitView(vo.getStrModifyDtlWS().getString(14));
					formBean.setStrRaisingRemarksView(vo.getStrModifyDtlWS().getString(15));
					formBean.setStrOrderBySeatIdView(vo.getStrModifyDtlWS().getString(16));
					formBean.setStrOrderByDateView(vo.getStrModifyDtlWS().getString(17));
					formBean.setStrOrderRemarksView(vo.getStrModifyDtlWS().getString(18));
					
					formBean.setStrStatusView(vo.getStrModifyDtlWS().getString(19));

				}
				formBean.setWbTransferOrderDetail(vo.getWbTransferOrderDetail());
			}
			formBean.setStrCtDate(now(dateFormatNow));
			response.setContentType("text/html;charset=UTF-8");
			String strTransferOrderDetails = TransferDemandReqTransHLP.getPrintScreenTwo(formBean, request);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strTransferOrderDetails);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA->getPrintScreenTwo()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * Generate pdf.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void generatePdf(TransferDemandReqTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		String strSearchItemInitView = "";
		try {

			String strHtmlCode = "";
			strHtmlCode = strHtmlCode.replace("width=\"800\"", "width='650'");

			strSearchItemInitView = "<html><body></body></html>";
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=" + formBean.getStrChk().split("\\$")[0] + ".pdf");
			//HtmlToPdfConvertor.convertHtmlToPDFDirect(response, strSearchItemInitView);

		} catch (Exception e) {

			String strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA.generatePdf(vo) --> ", strmsgText);

		}
	}

	/**
	 * Check duplicate request.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void checkDuplicateRequest(TransferDemandReqTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String strmsgText = "";
		TransferDemandReqTransBO bo = null;
		TransferDemandReqTransVO vo = null;
		try {

			bo = new TransferDemandReqTransBO();
			vo = new TransferDemandReqTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			String strStoreId = request.getParameter("storeId");
			String strItemBrandId = request.getParameter("itemBrandId");

			vo.setStrStoreId(strStoreId);
			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrHospitalCode(strHospitalCode);

			bo.checkDuplicateRequest(vo);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(vo.getStrReqStatus());
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferDemandReqTransDATA->checkDuplicateRequest()", strmsgText);

		} finally {
			vo = null;
			bo = null;
		}
	}

}
