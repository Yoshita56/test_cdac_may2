/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferApprovalTransDATA.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.data;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.transactions.bo.TransferRequestTransBO;
import mms.transactions.controller.fb.TransferRequestTransFB;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.controller.hlp.TransferRequestTransHLP;
import mms.transactions.vo.TransferRequestTransVO;

/**
 * The Class TransferRequestTransDATA.
 */
public class TransferRequestTransDATA {

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
		util = new HisUtil("transaction", "TransferRequestTransHLP");
		try {
			a = util.getASDate(frmt);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return a;
	}

	/**
	 * Initial add.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws Exception the exception
	 */

	public static void initialAdd(TransferRequestTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws Exception {

		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;
		String strmsgText = "";
		String strStoreName = "";
		try {
			bo = new TransferRequestTransBO();
			vo = new TransferRequestTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			if (request.getParameter("comboValue") == null) {
				strStoreName = formBean.getStrStoreName();
			} else {
				strStoreName = request.getParameter("comboValue");
			}

			request.getParameterValues("combo");
			formBean.setStrStoreName(strStoreName);
			String strStoreId = formBean.getCombo()[0].split("\\^")[0];
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
			
			formBean.setStrOnlineAppStatus(vo.getStrOnlineAppStatus());
			formBean.setStrGroupNameCombo(vo.getStrGroupNameCombo());
			formBean.setStrSubGroupCombo(vo.getStrSubGroupCombo());
			formBean.setStrItemNameCombo(vo.getStrItemNameCombo());
			formBean.setStrApprovedByCombo(vo.getStrApprovedByCombo());
			formBean.setStrReqDate(now(dateFormatNow));
			formBean.setStrCtDate(now(dateFormatNow));
			formBean.setStrTimePeriodCombo(vo.getStrTimePeriodCombo());
			//System.out.println("App Status---->"+formBean.getStrOnlineAppStatus());
			//formBean.setStrOnlineAppStatus("0");

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferRequestTransDATA.initialAdd()", strmsgText);
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

	public static void initModify(TransferRequestTransFB formBean, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;
		String strmsgText = "";
		try {
			bo = new TransferRequestTransBO();
			vo = new TransferRequestTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strStoreName = request.getParameter("comboValue");
			formBean.setStrStoreName(strStoreName);
			String strStoreId = formBean.getCombo()[0].split("\\^")[0];

			String strChk = formBean.getStrChk();

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(strStoreId);
			vo.setStrModifyFlg("1");
			
			//HSTNUM_REQUEST_NO||'@'|| MODIFY_CANCEL_FLAG ||'@'||HSTNUM_SLNO
			//10921400024         @            1             @      1         $  2
			//System.out.println("strChk---->"+strChk);
			//System.out.println("Req No---->"+(strChk.split("\\$")[0]).split("\\@")[0]);
			// Request No @ Cancel Flg
			vo.setStrRequestNo((strChk.split("\\@")[0]));
			vo.setStrSlNo((strChk.split("\\@")[2]).split("\\$")[0]);
			vo.setStrItemCategoryNo("10");
			vo.setStrChk(strChk);
			// Calling BO Method
			bo.initialModify(vo);   // PKG_MMS_VIEW.proc_transfer_transreq_dtls [Mode =1]
			                        // PKG_MMS_VIEW.proc_store_emp_dtl [Mode =1]
			                        // mms_mst.check_online_app_status     Check Approval Required or Not
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			formBean.setStrApprovedByCombo(vo.getStrApprovedByCombo());
			formBean.setStrReqDate(now(dateFormatNow));
			formBean.setStrCtDate(now(dateFormatNow));
			formBean.setStrOnlineAppStatus(vo.getStrOnlineAppStatus());
			formBean.setStrModifyChk(vo.getStrChk());
			formBean.setStrChk(vo.getStrChk());
			formBean.setStrRequestNo((strChk.split("\\@")[0]));

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			} 
			else 
			{
				while (vo.getStrModifyDtlWS().next()) 
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
					formBean.setStrRemarks(vo.getStrModifyDtlWS().getString(9));
					formBean.setStrSubGroupNameView(vo.getStrModifyDtlWS().getString(10));
					formBean.setStrBatchNoDetail(vo.getStrModifyDtlWS().getString(11));
					formBean.setStrAvlQty(vo.getStrModifyDtlWS().getString(12));
					formBean.setStrMfgDate(vo.getStrModifyDtlWS().getString(13));
					formBean.setStrExpDate(vo.getStrModifyDtlWS().getString(14));

				}
			}
		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferRequestTransDATA.initialAdd()", strmsgText);
			
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

	public static void initView(TransferRequestTransFB formBean, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;
		String strmsgText = "";
		String path = "";
		try 
		{
			
			bo = new TransferRequestTransBO();
			vo = new TransferRequestTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			String strStoreName = request.getParameter("comboValue");
			request.getParameterValues("combo");
			formBean.setStrStoreName(strStoreName);

			String strChk = formBean.getStrChk();
			path = "/mms" + request.getParameter("cnt_page") + ".cnt";

			if (request.getParameter("cnt_page") == null) 
			{
				path = request.getParameter("strPath");
			}
			formBean.setStrPath(path.trim());

			vo.setStrHospitalCode(hosCode);			
			vo.setStrSeatId(seatid);			
			vo.setStrStoreId(formBean.getStrStoreId());
			
			if (formBean.getStrOrderView().equals("0")) 
			{
				//HSTNUM_REQUEST_NO||'@'|| MODIFY_CANCEL_FLAG ||'@'||HSTNUM_SLNO
				//10921400024         @            1             @      1         $  2
				//System.out.println("strChk---->"+strChk);
				//System.out.println("Req No---->"+(strChk.split("\\$")[0]).split("\\@")[0]);
				// Request No @ Cancel Flg
				vo.setStrRequestNo((strChk.split("\\@")[0]));
				vo.setStrSlNo((strChk.split("\\@")[2]).split("\\$")[0]);
				vo.setStrItemCategoryNo("10");
				vo.setStrChk(strChk);
			}
			else
			{
				vo.setStrRequestNo(formBean.getStrRequestNo());
				vo.setStrSlNo(formBean.getStrSerialNo());
				vo.setStrItemCategoryNo("10");
				vo.setStrChk(formBean.getStrRequestNo()+"@0@"+formBean.getStrSlNo());
			}
			// Calling BO Method
			bo.initialView(vo);  // PKG_MMS_VIEW.proc_transfer_transreq_dtls [Mode=2]
			                     // PKG_MMS_VIEW.proc_transfer_order_dtl [Mode =2]
			
			//System.out.println("TWO--->>");
			
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
					formBean.setStrSubGroupNameView(vo.getStrModifyDtlWS().getString(20));
					formBean.setStrBatchNoView(vo.getStrModifyDtlWS().getString(21));
					formBean.setStrMfgDateView(vo.getStrModifyDtlWS().getString(22));
					formBean.setStrExpDateView(vo.getStrModifyDtlWS().getString(23));
					
					System.out.println("vo.getStrModifyDtlWS().getString(19)--->>"+vo.getStrModifyDtlWS().getString(19));
					
				}
				formBean.setWbTransferOrderDetail(vo.getWbTransferOrderDetail());
			}
			formBean.setStrCtDate(now(dateFormatNow));
			String strTransferOrderDetails = TransferRequestTransHLP.getTransferOrderDetails(formBean,request);
			formBean.setStrTransferOrderDetails(strTransferOrderDetails);
			/** @param strFrmStoreId the str frm store id
			 * @param strHospCode the str hosp code
			 * @param strReqStatus the str req status
			 * @param strReqNo the str req no
			 */
			String str2 = ApprovalDtlHLP.getApprovalDtlNew(vo.getStrStoreId().split("\\^")[0], vo.getStrHospitalCode(), "", vo.getStrRequestNo(),request);
			formBean.setStrSetApprovedDetails(str2);
			formBean.setStrStoreId(vo.getStrStoreId());

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText =e.getMessage();
			new HisException("e-Aushadhi", "TransferRequestTransDATA.initialAdd()", strmsgText);
			
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

	public static void initOrderView(TransferRequestTransFB formBean, HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {

		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;
		String strmsgText = "";
		String path = "";
		try {
			bo = new TransferRequestTransBO();
			vo = new TransferRequestTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();

			path = "/mms" + request.getParameter("cnt_page") + ".cnt";

			if (request.getParameter("cnt_page") == null) {

				path = request.getParameter("strPath");
			}
			String strChk = formBean.getStrChk();
			formBean.setStrPath(path.trim());

			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId("0");
			vo.setStrOrderNumber(formBean.getStrOrderNo());
			vo.setStrItemCategoryNo("10");
			vo.setStrDemandSlNo((strChk.split("\\@")[1]));
			vo.setStrOrderSlNo((strChk.split("\\@")[1]));
			// Calling BO Method
			bo.initialOrderView(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			} else {
				while (vo.getWbTransferOrderDetailView() != null && vo.getWbTransferOrderDetailView().next()) {
					formBean.setStrOrderNoView(vo.getWbTransferOrderDetailView().getString(1));
					formBean.setStrOrderNoDate(vo.getWbTransferOrderDetailView().getString(2));
					formBean.setStrRaisingDDWView(vo.getWbTransferOrderDetailView().getString(3));
					formBean.setStrRequestNoView(vo.getWbTransferOrderDetailView().getString(4));
					formBean.setStrTransferDDWView(vo.getWbTransferOrderDetailView().getString(5));
					formBean.setStrTransferReqNoView(vo.getWbTransferOrderDetailView().getString(6));
					formBean.setStrGroupNameView(vo.getWbTransferOrderDetailView().getString(7));
					formBean.setStrItemNameView(vo.getWbTransferOrderDetailView().getString(8));
					formBean.setStrOrderQtyView(vo.getWbTransferOrderDetailView().getString(9));
					formBean.setStrTransferQtyView(vo.getWbTransferOrderDetailView().getString(10));
					formBean.setStrAckQtyWithUnitView(vo.getWbTransferOrderDetailView().getString(11));
					formBean.setStrOrderRemarksView(vo.getWbTransferOrderDetailView().getString(12));
					formBean.setStrSubGroupNameView(vo.getWbTransferOrderDetailView().getString(13));
					formBean.setStrBatchNo(vo.getWbTransferOrderDetailView().getString(18));
					formBean.setStrMfgDate(vo.getWbTransferOrderDetailView().getString(19));
					formBean.setStrExpDate(vo.getWbTransferOrderDetailView().getString(20));
				}
				formBean.setWbTransferOrderDetail(vo.getWbTransferOrderDetail());
				String strTransferDetailsView = TransferRequestTransHLP.getTransferDetails(formBean,request);
				response.setContentType("text/html;charset=UTF-8");
				formBean.setStrTransferDetailsView(strTransferDetailsView);
			}

		} catch (Exception e)
        {
			e.printStackTrace();
			strmsgText =  e.getMessage();
			new HisException("e-Aushadhi", "TransferRequestTransDATA.initialAdd()", strmsgText);
		
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
	 * @throws ServletException 
	 * @throws IOException 
	 */

	public static void subGroupCombo(TransferRequestTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String strmsgText = "";
		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;
		try {

			bo = new TransferRequestTransBO();
			vo = new TransferRequestTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();

			String strSeatId = request.getSession().getAttribute("SEATID").toString();
			String strGroupId = request.getParameter("GroupId");
			String strStoreId = request.getParameter("storeId").split("\\^")[0];

			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);
			vo.setStrGroupId(strGroupId);

			bo.subGrpAndItemCmb(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
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
			new HisException("e-Aushadhi", "TransferRequestTransDATA->subGroupCombo()", strmsgText);
			
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

	public static void itemBrandName(TransferRequestTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String strmsgText = "";
		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;

		try {

			bo = new TransferRequestTransBO();
			vo = new TransferRequestTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();

			String strStoreId = request.getParameter("storeId").split("\\^")[0];
			String strGroupId = request.getParameter("strGroupId");
			String strSubGroupId = request.getParameter("strSubGroupId");

			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");
			vo.setStrGroupId(strGroupId);
			vo.setStrSubGroupId(strSubGroupId);

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			bo.getItemBrandCmb(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			String cmbstr = vo.getStrItemNameCombo();

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText =  e.getMessage();
			new HisException("e-Aushadhi", "TransferRequestTransDATA->itemBrandName()", strmsgText);
			
		} finally {
			vo = null;
			bo = null;
		}
	}

	/**
	 * Gets the batch details.
	 *
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return the batch details
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void getBatchDetails(TransferRequestTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String strmsgText = "";
		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;

		try {

			bo = new TransferRequestTransBO();
			vo = new TransferRequestTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();

			String strStoreId = request.getParameter("storeId").split("\\^")[0];
			String strGroupId = request.getParameter("strGroupId");
			String strItemBrandId = request.getParameter("strItemBrandId");

			vo.setStrStoreId(strStoreId);
			vo.setStrItemCategoryNo("10");
			vo.setStrGroupId(strGroupId);
			vo.setStrItemBrandId(strItemBrandId.split("\\^")[0]);
			vo.setStrItemId(strItemBrandId.split("\\^")[1]);

			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			bo.getBatchNo(vo);  // PKG_MMS_VIEW.proc_transfer_excess_stock_dtl  [ Mode =1 ]

			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}
			String strBatchDtl = TransferRequestTransHLP.getDrugBatchDetails(vo.getStrBatchDtlWs(), formBean, "0");			

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strBatchDtl);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferRequestTransDATA->getBatchDetails()", strmsgText);
			
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

	public static void transferDtl(TransferRequestTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String strmsgText = "";
		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;
		String cmbstr = "";
		try {

			bo = new TransferRequestTransBO();
			vo = new TransferRequestTransVO();

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

			bo.getTransferDtl(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean.setWbTransferOrderDetail(vo.getWbTransferOrderDetail());
			if (strPrintFlag.equals("1")) {
				cmbstr = TransferRequestTransHLP.getTransferDetails(formBean,request);
				response.setContentType("text/html;charset=UTF-8");
			} else {
				cmbstr = TransferRequestTransHLP.getTransferDetailsPrintScreen(formBean);
			}

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr);
			} catch (Exception e) {
				throw e;
			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferRequestTransDATA->transferDtl()", strmsgText);
			
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
	 * @throws ServletException 
	 * @throws IOException 
	 */

	public static void transferItem(TransferRequestTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String strmsgText = "";
		String cmbstr = "";
		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;

		try {

			bo = new TransferRequestTransBO();
			vo = new TransferRequestTransVO();

			
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();

			String strTransferNo = request.getParameter("strTransferNo").split("\\^")[0];
			vo.setStrStoreId(request.getParameter("strTransferNo").split("\\^")[2]);
			vo.setStrRequestNo(strTransferNo);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrSeatId(strSeatId);

			// Calling BO Method
			bo.getTransferItemDtl(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			cmbstr = TransferRequestTransHLP.getDrugDetails(vo.getWbTransferOrderDetail(), formBean, request);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(cmbstr + "^" + request.getParameter("strTransferNo").split("\\^")[1]);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferRequestTransDATA->transferItem()", strmsgText);
			
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

	public static void insert(TransferRequestTransFB formBean,HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String strmsgText = "";
		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;

		try {
			bo = new TransferRequestTransBO();
			vo = (TransferRequestTransVO) TransferObjectFactory.populateData("mms.transactions.vo.TransferRequestTransVO", formBean);
			// Calling BO method
			bo.insert(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getStrMsgType().equals("1")) {
				formBean.setStrErrMsg(vo.getStrMsgString());

				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrNormalMsg("Transfer Excess Request Form Store [ "+vo.getStrStoreName()+" ] Has been Successfully Generated");
			}

		} catch (Exception e) {
			formBean.setStrStoreName(vo.getStrStoreName());
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferRequestTransDATA->insert()", strmsgText);
			

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
	 * @throws ServletException 
	 * @throws IOException 
	 */

	public static void update(TransferRequestTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String strmsgText = "";
		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;

		try {
			bo = new TransferRequestTransBO();
			vo = new TransferRequestTransVO();
			String strChk = formBean.getStrChk();
			vo = (TransferRequestTransVO) TransferObjectFactory.populateData("mms.transactions.vo.TransferRequestTransVO", formBean);
			vo.setStrStoreId(formBean.getStrStoreId());
			//HSTNUM_REQUEST_NO||'@'|| MODIFY_CANCEL_FLAG ||'@'||HSTNUM_SLNO
			//10921400024         @            1             @      1         $  2
			//System.out.println("strChk---->"+strChk);
			//System.out.println("Req No---->"+(strChk.split("\\$")[0]).split("\\@")[0]);
			// Request No @ Cancel Flg
			vo.setStrRequestNo((strChk.split("\\@")[0]));
			vo.setStrSlNo((strChk.split("\\@")[2]).split("\\$")[0]);
			vo.setStrItemCategoryNo("10");
			vo.setStrChk(strChk);
			// Calling BO method
			bo.update(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			if (vo.getStrMsgType().equals("1")) {
				formBean.setStrErrMsg(vo.getStrMsgString());

				throw new Exception(vo.getStrMsgString());
			} else {
				formBean.setStrNormalMsg("Data Has been Updated Successfully Saved");
			}

		} catch (Exception e) {
			formBean.setStrStoreName(vo.getStrStoreName());
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferRequestTransDATA->update()", strmsgText);
			

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
	 * @return true, if successful
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static boolean cancelRecord(HttpServletRequest request, TransferRequestTransFB formBean,HttpServletResponse response) throws IOException, ServletException {
		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;
		boolean retValue = true;

		try {
			bo = new TransferRequestTransBO();
			vo = new TransferRequestTransVO();
			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request.getSession().getAttribute("SEATID").toString();

			String strStoreName = request.getParameter("comboValue");
			formBean.setStrStoreName(strStoreName);
			String strStoreId = formBean.getCombo()[0].split("\\^")[0];

			String strChk = formBean.getStrChk();
            //System.out.println("Chk---->"+strChk);
            //10921400024@1@1$2$asdasdasd
			//HSTNUM_REQUEST_NO||'@'|| MODIFY_CANCEL_FLAG ||'@'||HSTNUM_SLNO
			//10921400024         @            1             @      1         $  2
			//System.out.println("strChk---->"+strChk);
			//System.out.println("Req No---->"+(strChk.split("\\$")[0]).split("\\@")[0]);
			// Request No @ Cancel Flg
			vo.setStrRequestNo((strChk.split("\\@")[0]));
			vo.setStrSlNo((strChk.split("\\@")[2]).split("\\$")[0]);
			vo.setStrItemCategoryNo("10");
			vo.setStrChk(strChk);
			vo.setStrStoreId(strStoreId);
			vo.setStrSeatId(strSeatId);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrCancelReson((strChk.split("\\@")[2]).split("\\$")[2]);
			//System.out.println("Cacnel Reson---->"+(strChk.split("\\@")[2]).split("\\$")[2]);
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
			new HisException("e-Aushadhi", "TransferRequestTransDATA->cancelRecord()", strmsgText);
			
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
	 * @return the prints the screen two
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void getPrintScreenTwo(TransferRequestTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		TransferRequestTransBO bo = null;
		TransferRequestTransVO vo = null;
		String strmsgText = "";
		try 
		{
			bo = new TransferRequestTransBO();
			vo = new TransferRequestTransVO();
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request.getSession().getAttribute("SEATID").toString();
			String storeId = request.getParameter("storeId").split("\\^")[0];
			String strChk = request.getParameter("strChk");
			String strStoreName = request.getParameter("strStoreName");		
			String strOrderView = request.getParameter("strOrderView");
			formBean.setStrStoreId(storeId);
			formBean.setStrStoreName(strStoreName);
			vo.setStrHospitalCode(hosCode);
			vo.setStrSeatId(seatid);
			vo.setStrStoreId(formBean.getStrStoreId().split("\\^")[0]);
			//HSTNUM_REQUEST_NO||'@'|| MODIFY_CANCEL_FLAG ||'@'||HSTNUM_SLNO
			//10921400024         @            1             @      1         $  2
			//System.out.println("strChk-Print Screen Execc--->"+strChk);
			//System.out.println("Req No---->"+(strChk.split("\\$")[0]).split("\\@")[0]);
			// Request No @ Cancel Flg
			vo.setStrRequestNo((strChk.split("\\@")[0]));
			if(strOrderView.equals("1"))
			{
				vo.setStrSlNo((strChk.split("\\@")[2]));
			}	
			else
			{
				vo.setStrSlNo((strChk.split("\\$")[0]).split("\\@")[2]);
			}
			vo.setStrItemCategoryNo("10");
			vo.setStrChk(strChk);
			// Calling BO Method
			bo.initialView(vo);
			if (vo.getStrMsgType().equals("1")) 
			{
				throw new Exception(vo.getStrMsgString());
			}

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
					formBean.setStrBatchNoView(vo.getStrModifyDtlWS().getString(21));
					formBean.setStrMfgDateView(vo.getStrModifyDtlWS().getString(22));
					formBean.setStrExpDateView(vo.getStrModifyDtlWS().getString(23));

				}
				formBean.setWbTransferOrderDetail(vo.getWbTransferOrderDetail());
			}
			formBean.setStrCtDate(now(dateFormatNow));
			response.setContentType("text/html;charset=UTF-8");
			String strTransferOrderDetails = TransferRequestTransHLP.getPrintScreenTwo(formBean, request);
			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strTransferOrderDetails);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) 
		{
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
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public static void generatePdf(TransferRequestTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String strSearchItemInitView = "";

		try {

			String strHtmlCode = formBean.getStrRemarks();
			strHtmlCode = strHtmlCode.replace("width=\"800\"", "width='650'");
			strSearchItemInitView = "<html><body></body></html>";

			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "attachment; filename=" + formBean.getStrChk().split("\\$")[0] + ".pdf");
			//HtmlToPdfConvertor.convertHtmlToPDFDirect(response, strSearchItemInitView);

		} catch (Exception e) {
			e.printStackTrace();

			String strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferRequestTransDATA.generatePdf(vo)", strmsgText);
			

		}
	}

}
