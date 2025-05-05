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

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.transactions.bo.TransferOrderDetailTransBO;
import mms.transactions.controller.fb.TransferOrderDetailTransFB;
import mms.transactions.controller.hlp.TransferApprovalTransHLP;
import mms.transactions.controller.hlp.TransferOrderDetailTransHLP;
import mms.transactions.vo.TransferOrderDetailTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferApprovalTransDATA.
 */
public class TransferOrderDetailTransDATA {

	/**
	 * Inits the order generate.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void initOrderGenerate(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;

		HisUtil util = null;
		String strmsgText = "";
		try {
			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

			util = new HisUtil("mms", "TransferOrderDetailTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrTmpStoreId(formBean.getCombo()[0].split("\\^")[0]);
			vo.setStrStoreId(formBean.getStrStoreId());
			
			vo.setStrItemCategoryNo("10");
			
			// System.out.println("Store id value"+formBean.getCombo()[0].split("\\^")[0]);
			// Calling BO Method
			bo.initOrderGenerate(vo);

			if (vo.getWsDwhList() != null && vo.getWsDwhList().size() > 0) {

				formBean.setStrDwhNames(util.getOptionValue(vo.getWsDwhList(), "0", "0^All", false));

			} else {

				formBean.setStrDwhNames("<option value='0'>All</option> ");

			}
			
			
			String strStoreList = "<option value='0'>NA</option>";
			
			if(vo.getWbsStoreDetails() != null && vo.getWbsStoreDetails().size() > 0){
				
				strStoreList = util.getOptionValue(vo.getWbsStoreDetails(), "0", "0^Select Value", false);
			} 
			
			 formBean.setStrStoreNameList(strStoreList);
			
				formBean.setStrGroupNameCombo("<option value='0'>All</option>");
				formBean.setStrSubGroupCombo("<option value='0'>All</option>");
			//	formBean.setStrItemNameCombo(vo.getStrItemNameCombo());
			 
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrCtDate(util.getDSDate("dd-Mon-yyyy HH24:MI"));

		//	formBean.setStrDemandRequestDetails(TransferApprovalTransHLP.getDemandRequestDetails(vo.getWsDemandRequestDetails(),request));
			
			response.setContentType("text/html;charset=UTF-8");

			formBean.setStrTmpStoreId(formBean.getCombo()[0].split("\\^")[0]);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

		} catch (Exception e) {
            e.printStackTrace();
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->initOrderGenerate()", strmsgText);

		} finally {
			bo = null;
			vo = null;
			util = null;

		}

	}

	/**
	 * Gets the demand request details.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return the demand request details
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void getDemandRequestDetails(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String strmsgText = "";
		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;
		try {

			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strStoreId = request.getParameter("strStoreId");
			String strParentStoreId = request.getParameter("strParentStoreId");
			vo.setStrSeatId(formBean.getStrSeatId());
		 

			vo.setStrStoreId(strStoreId);
		 
			vo.setStrTmpStoreId(strParentStoreId);
			vo.setStrHospitalCode(strHospitalCode);

			bo.getDemandRequestDetails(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			String strDemandRequestDetails = TransferApprovalTransHLP.getDemandRequestDetails(vo.getWsDemandRequestDetails(),request);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strDemandRequestDetails);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->getDemandRequestDetails()", strmsgText);

		} finally {
			vo = null;
			bo = null;

		}
	}

	
	public static void getGrpItemDetails(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String strmsgText = "";
		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;
		try {

			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strStoreId = request.getParameter("strStoreId");
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrItemCategoryNo("10");
		 

			vo.setStrStoreId(strStoreId);
		  
			vo.setStrHospitalCode(strHospitalCode);

			bo.getGrpItemDetails(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			String strDemandRequestDetails = vo.getStrGroupNameCombo()+"#^#"+vo.getStrItemNameCombo();

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strDemandRequestDetails);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->getDemandRequestDetails()", strmsgText);

		} finally {
			vo = null;
			bo = null;

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

	public static void subGroupCombo(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		String strmsgText = "";
		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;
		try {

			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

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
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->getDemandRequestDetails()", strmsgText);

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

	public static void itemBrandName(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		String strmsgText = "";
		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;
		try {

			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

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
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->getDemandRequestDetails()", strmsgText);

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
	public static void getBatchDetails(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		String strmsgText = "";
		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;
		try {

			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

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
			String strBatchDtl = TransferOrderDetailTransHLP.getDrugBatchDetails(vo.getStrBatchDtlWs(), formBean, "0" , request);			

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strBatchDtl);
			} catch (Exception e) {
				throw e;
			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->getDemandRequestDetails()", strmsgText);
			
		} finally {
			vo = null;
			bo = null;
		}
	}
	
	
	/**
	 * Gets the transfering details.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @return the transfering details
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void getTransferingDetails(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String strmsgText = "";
		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;
		try {

			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strItemBrandId = request.getParameter("strItemBrandId");
			String strStoreId = request.getParameter("strStoreId");

			vo.setStrItemBrandId(strItemBrandId);
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrStoreId(strStoreId);

			bo.getTransferingDetails(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			response.setContentType("text/html;charset=utf-8");

			String strTransferingDetails = TransferApprovalTransHLP.getTransferingDetails(vo.getWsTransferingDetails(),request);

			try {
				response.setHeader("Cache-Control", "no-cache");
				response.getWriter().print(strTransferingDetails);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {

			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->getDemandRequestDetails()", strmsgText);

		} finally {
			vo = null;
			bo = null;

		}
	}

	/**
	 * Insert order generate.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void insertOrderGenerate(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;

		String strmsgText = "";
		 
		
		try {
			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
            
			vo.setStrTmpStoreId(formBean.getStrTmpStoreId());
			vo.setStrOrderDate(formBean.getOrderDate());
			
			vo.setStrRequestingStoreId(formBean.getStrRequestingStoreId());
			vo.setStrTransferingStoreId(formBean.getStrTransferingStoreId());
			
			
			vo.setStrRemarks(formBean.getStrRemarks());
			
			vo.setStrHiddenValue(formBean.getStrHiddenValue());
			vo.setStrPKey(formBean.getStrPKey());
			  
			bo.insertOrderGenerate(vo);
		 
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			
			formBean.setStrMsg("Transfer Order Generated Successfully");
		 

		} catch (Exception e) {
			
			e.printStackTrace();
 
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->getDemandRequestDetails()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * Inits the order modify.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void initOrderModify(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;

		String strmsgText = "";
		try {
			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrOrderNo(formBean.getStrOrderNo());
			vo.setStrStoreId(formBean.getCombo()[0].split("\\^")[0]);
			vo.setStrTmpStoreId(formBean.getCombo()[0].split("\\^")[0]);
			vo.setStrOrderSlNo(formBean.getStrOrderSlNo());
			// Calling BO Method
			bo.initOrderModify(vo);

			formBean.setStrDemandNo(vo.getStrRequestNo());
			formBean.setStrTransRequestNo(vo.getStrTransRequestNo());
			formBean.setStrDrugName(vo.getStrDrugName());
			formBean.setStrOrderQty(vo.getStrOrderQty());
			formBean.setStrDemandDate(vo.getStrDemandDate());
			formBean.setStrTransStoreId(vo.getStrTransStoreId());
			formBean.setStrItemBrandId(vo.getStrItemBrandId());
			formBean.setStrDemandQty(vo.getStrDemandQty());
			formBean.setStrOrderedQty(vo.getStrOrderedQty());
			formBean.setStrBalanceQty(vo.getStrBalanceQty());
			formBean.setStrBalanceQtyBaseValue(vo.getStrBalanceQtyBaseValue());
			formBean.setStrStoreId(vo.getStrStoreId());				
			formBean.setStrTransferingOrderDetails(TransferOrderDetailTransHLP.getOrderDetails(vo,request));
						
			response.setContentType("text/html;charset=UTF-8");
			formBean.setStrTransferingDetails(TransferOrderDetailTransHLP.getTransferingDetailsModify(vo.getWsTransferingDetails(),request));
			response.setContentType("text/html;charset=UTF-8");
			
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrTmpStoreId(vo.getStrTmpStoreId());
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

		} catch (Exception e) {

			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->getDemandRequestDetails()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * Insert order modify.
	 * 
	 * @param formBean the form bean
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void insertOrderModify(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;

		String strmsgText = "";

		try {
			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());

			vo.setStrOrderNo(formBean.getStrOrderNo());
			vo.setStrDemandNo(formBean.getStrDemandNo());
			vo.setStrStoreId(formBean.getStrStoreId());
			vo.setStrItemBrandId(formBean.getStrItemBrandId());
			vo.setStrRequestNo(formBean.getStrRequestNo());
			vo.setStrRemarks(formBean.getStrRemarks());
			vo.setStrOrderSlNo(formBean.getStrOrderSlNo());

			String[] strTransferStoreIds = null;
			String[] strTransferRequestNos = null;

			if (formBean.getStrTransferingDtls() != null && formBean.getStrTransferingDtls().length > 0) {

				int len = formBean.getStrTransferingDtls().length;

				strTransferStoreIds = new String[len];
				strTransferRequestNos = new String[len];

				vo.setStrTransferOrderQtys(formBean.getStrTransferOrderQty());
				vo.setStrTransferStoreIds(strTransferStoreIds);
				vo.setStrTransferRequestNos(strTransferRequestNos);
				vo.setStrTransferingDtls(formBean.getStrTransferingDtls());
				vo.setStrStoreId(formBean.getStrStoreId());
				vo.setStrOrderSlNo(formBean.getStrOrderSlNo());
				vo.setStrPrimaryKey(formBean.getStrPrimaryKey());
				vo.setStrPrimaryKey1(formBean.getStrPrimaryKey1());
				vo.setStrTmpStoreId(formBean.getStrTmpStoreId());

			}

			bo.insertOrderModify(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

		} catch (Exception e) {
			e.printStackTrace();
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->getDemandRequestDetails()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * Demand reject.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void demandReject(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;
		String strmsgText = "";

		try {
			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

			String strChkValues = formBean.chk[0];
			String[] strTemp = strChkValues.replace("@", "#").split("#");

			vo.setStrStoreId(strTemp[0]);
			vo.setStrRequestNo(strTemp[1]);
			vo.setStrDemandSlNo(strTemp[2]);
			vo.setStrRemarks(formBean.getComboValue());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());

			bo.demandReject(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->getDemandRequestDetails()", strmsgText);

		} finally {
			bo = null;
			vo = null;
		}

	}

	/**
	 * Transfer reject.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void transferReject(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;

		String strmsgText = "";

		try {
			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

			String strChkValues = formBean.chk[0];
			String[] strTemp = strChkValues.replace("@", "#").split("#");

			vo.setStrStoreId(strTemp[0]);
			vo.setStrRequestNo(strTemp[1]);
			vo.setStrDemandSlNo(strTemp[2]);
			vo.setStrRemarks(formBean.getComboValue());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());

			bo.transferReject(vo);
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

		} catch (Exception e) {
			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->getDemandRequestDetails()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * Transfer forcefully close.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void transferForcefullyClose(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;

		String strmsgText = "";

		try {
			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();

			String strChkValues = formBean.chk[0];

			String[] strTemp = strChkValues.replace("@", "#").split("#");

			vo.setStrStoreId(strTemp[0]);
			vo.setStrRequestNo(strTemp[1]);
			vo.setStrRemarks(formBean.getComboValue());

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());

			bo.transferForcefullyClose(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

		} catch (Exception e) {

			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->getDemandRequestDetails()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}

	/**
	 * Cancel order.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public static void cancelOrder(TransferOrderDetailTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		TransferOrderDetailTransBO bo = null;
		TransferOrderDetailTransVO vo = null;

		String strmsgText = "";

		try {
			bo = new TransferOrderDetailTransBO();
			vo = new TransferOrderDetailTransVO();
        
			String strChkValues = formBean.chk[0];
			String strOrderNo = strChkValues.replace("@", "#").split("#")[0];
			String strSlNo = strChkValues.replace("@", "#").split("#")[1];
			String  drugName = strChkValues.replace("@", "#").split("#")[2];
			
			
			String demandStore = strChkValues.replace("@", "#").split("#")[3];
			String transStore = strChkValues.replace("@", "#").split("#")[4];
			String orderDate = strChkValues.replace("@", "#").split("#")[5];
			vo.setStrOrderNo(strOrderNo);
			System.out.println("order"+vo.getStrOrderNo()+drugName+demandStore+ transStore+orderDate);
			
			vo.setStrRemarks(formBean.getComboValue());
			System.out.println("rema"+vo.getStrRemarks());
			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrDemandSlNo(strSlNo);

			bo.cancelOrder(vo);

			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
			else
			{
				/*
				AlertMessageServiceCall.addMessage(
						"TR115",
						vo.getStrStoreId(),
						null,
						null,
						null,
						vo.getStrOrderNo(),
						"Transfer Order No & Date [ "
						+vo.getStrOrderNo() +" / "+orderDate+" ]" +
									//	" for transfer of [ " +vo.getStrInsertHiddenValue().length+ " ]" +
												" containing ["+drugName+"]demanded by ["+demandStore+"]store from ["+transStore+"] has been cancelled with["+vo.getStrRemarks()+"] Reason    by User [ "+request.getSession().getAttribute("UserFullName").toString()+" ] ", null,
						Integer.parseInt(vo.getStrHospitalCode()),
						Integer.parseInt(vo.getStrSeatId()), request.getSession().getAttribute("UserFullName").toString());
						*/
			}

		} catch (Exception e) {

			strmsgText = e.getMessage();
			new HisException("e-Aushadhi", "TransferOrderDetailTransDATA->cancelOrder()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}

}
