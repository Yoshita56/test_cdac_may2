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
import mms.transactions.bo.TransferApprovalTransBO;
import mms.transactions.controller.fb.TransferApprovalTransFB;
import mms.transactions.controller.hlp.TransferApprovalTransHLP;
import mms.transactions.vo.TransferApprovalTransVO;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferApprovalTransDATA.
 */
public class TransferApprovalTransDATA {

	/**
	 * Inits the order generate.
	 * 
	 * @param formBean the form bean
	 * @param request the request
	 * @param response the response
	 * @throws ServletException
	 * @throws IOException
	 */
	public static void initOrderGenerate(TransferApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		TransferApprovalTransBO bo = null;
		TransferApprovalTransVO vo = null;

		HisUtil util = null;
		String strmsgText = "";
		try {
			bo = new TransferApprovalTransBO();
			vo = new TransferApprovalTransVO();

			util = new HisUtil("mms", "TransferApprovalTransDATA");

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
			vo.setStrTmpStoreId(formBean.getCombo()[0].split("\\^")[0]);
			vo.setStrStoreId(formBean.getStrStoreId());
			// System.out.println("Store id value"+formBean.getCombo()[0].split("\\^")[0]);
			// Calling BO Method
			bo.initOrderGenerate(vo);

			if (vo.getWsDwhList() != null && vo.getWsDwhList().size() > 0) {

				formBean.setStrDwhNames(util.getOptionValue(vo.getWsDwhList(), "0", "0^All", false));

			} else {

				formBean.setStrDwhNames("<option value='0'>All</option> ");

			}
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrCtDate(util.getDSDate("dd-Mon-yyyy HH24:MI"));

			formBean.setStrDemandRequestDetails(TransferApprovalTransHLP.getDemandRequestDetails(vo.getWsDemandRequestDetails(),request));
			
			response.setContentType("text/html;charset=UTF-8");

			formBean.setStrTmpStoreId(formBean.getCombo()[0].split("\\^")[0]);
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

		} catch (Exception e) {

			strmsgText = e.getMessage();
			new HisException("INVMGM", "TransferApprovalTransDATA->initOrderGenerate()", strmsgText);

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
	public static void getDemandRequestDetails(TransferApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String strmsgText = "";
		TransferApprovalTransBO bo = null;
		TransferApprovalTransVO vo = null;
		try {

			bo = new TransferApprovalTransBO();
			vo = new TransferApprovalTransVO();

			String strHospitalCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strStoreId = request.getParameter("strStoreId");
			String strParentStoreId = request.getParameter("strParentStoreId");
			vo.setStrSeatId(formBean.getStrSeatId());
			System.out.println("strStoreId " + strStoreId);

			vo.setStrStoreId(strStoreId);
			System.out.println("store id value+++++++++++" + strStoreId);
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
			new HisException("INVMGM", "TransferApprovalTransDATA->initOrderGenerate()", strmsgText);

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
	public static void getTransferingDetails(TransferApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String strmsgText = "";
		TransferApprovalTransBO bo = null;
		TransferApprovalTransVO vo = null;
		try {

			bo = new TransferApprovalTransBO();
			vo = new TransferApprovalTransVO();

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
			new HisException("INVMGM", "TransferApprovalTransDATA->initOrderGenerate()", strmsgText);

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
	public static void insertOrderGenerate(TransferApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		TransferApprovalTransBO bo = null;
		TransferApprovalTransVO vo = null;

		String strmsgText = "";
		String  orderDate2 ="" ;
		
		try {
			bo = new TransferApprovalTransBO();
			vo = new TransferApprovalTransVO();

			vo.setStrHospitalCode(formBean.getStrHospitalCode());
			vo.setStrSeatId(formBean.getStrSeatId());
                 System.out.println("demand"+formBean.getStrDemandRequest());
                 
                 String demandNo = formBean.getStrDemandRequest();
                 String[]demandNo1 = demandNo.split("\\^");
                 System.out.println(demandNo1[3]);
			String[] strDemandRequestDetails = formBean.getStrDemandRequest().replace("^", "#").split("#");
			vo.setStrStoreId(strDemandRequestDetails[0]);
			vo.setStrItemBrandId(strDemandRequestDetails[1]);
			vo.setStrRequestNo(strDemandRequestDetails[3]);
			vo.setStrDemandSlNo(strDemandRequestDetails[4]);
			vo.setStrRemarks(formBean.getStrRemarks());
			String storeName = request.getParameter("strStoreName");
			System.out.println(storeName);
			String drugName= request.getParameter("hiddenDrugName");
			String [] nameDrug =drugName.split("\\[");
			drugName = nameDrug[0].replace("[", " ");
			String demandDate= request.getParameter("hiddenDemanDate");
		
			String  givingStore= request.getParameter("hiddenToStoreName");
			System.out.println(drugName+demandDate+givingStore);
			
		

			String[] strTransferStoreIds = null;
			String[] strTransferRequestNos = null;
			String[] strTransferSlno = null;
			String[] strTransPrimaryKey = null;
            
			if (formBean.getStrTransferingDtls() != null && formBean.getStrTransferingDtls().length > 0) 
			{

				int len = formBean.getStrTransferingDtls().length;

				strTransferStoreIds = new String[len];
				strTransferRequestNos = new String[len];
				strTransferSlno = new String[len];
				strTransPrimaryKey = new String[len];

				for (int i = 0; i < len; i++)
				{
					
				    strTransferStoreIds[i] = formBean.getStrTransferingDtls()[i].replace("^", "#").split("#")[0];
					strTransferRequestNos[i] = formBean.getStrTransferingDtls()[i].replace("^", "#").split("#")[3];
					strTransferSlno[i] = formBean.getStrTransferingDtls()[i].replace("^", "#").split("#")[7];
					strTransPrimaryKey[i] =formBean.getStrPrimaryKey()[i];
				}
				vo.setStrTransferingDtls(formBean.getStrTransferingDtls());
			
				String orderDate =   request.getParameter("orderDate");
				String[]	orderDate1     = orderDate.split("\\ ");		
				orderDate2 =  orderDate1[0];
				 
				System.out.println("orderDate"+orderDate);
				System.out.println("trabndetails"+vo.getStrTransferingDtls());
				vo.setStrTransferOrderQtys(formBean.getStrTransferOrderQty());
				vo.setStrTransferStoreIds(strTransferStoreIds);
				vo.setStrTransferRequestNos(strTransferRequestNos);
				vo.setStrTmpStoreId(formBean.getStrTmpStoreId());
				vo.setStrTransferReqSlNo(strTransferSlno);
				vo.setStrPrimaryKey(strTransPrimaryKey);
				//System.out.println("PK-->"+vo.getStrPrimaryKey().length);

			}

			bo.insertOrderGenerate(vo);
			System.out.println("orderno."+vo.getStrOrderNo());
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}
						

		} catch (Exception e) {

			e.printStackTrace();

			strmsgText = e.getMessage();
			new HisException("INVMGM", "TransferApprovalTransDATA->initOrderGenerate()", strmsgText);

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
	public static void initOrderModify(TransferApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		TransferApprovalTransBO bo = null;
		TransferApprovalTransVO vo = null;

		String strmsgText = "";
		try {
			bo = new TransferApprovalTransBO();
			vo = new TransferApprovalTransVO();

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
			formBean.setStrTransferingOrderDetails(TransferApprovalTransHLP.getOrderDetails(vo,request));
						
			response.setContentType("text/html;charset=UTF-8");
			formBean.setStrTransferingDetails(TransferApprovalTransHLP.getTransferingDetailsModify(vo.getWsTransferingDetails(),request));
			response.setContentType("text/html;charset=UTF-8");
			
			formBean.setStrStoreName(vo.getStrStoreName());
			formBean.setStrTmpStoreId(vo.getStrTmpStoreId());
			if (vo.getStrMsgType().equals("1")) {

				throw new Exception(vo.getStrMsgString());

			}

		} catch (Exception e) {

			strmsgText = e.getMessage();
			new HisException("INVMGM", "TransferApprovalTransDATA->initOrderGenerate()", strmsgText);

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
	public static void insertOrderModify(TransferApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		TransferApprovalTransBO bo = null;
		TransferApprovalTransVO vo = null;

		String strmsgText = "";

		try {
			bo = new TransferApprovalTransBO();
			vo = new TransferApprovalTransVO();

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
			new HisException("INVMGM", "TransferApprovalTransDATA->initOrderGenerate()", strmsgText);

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
	public static void demandReject(TransferApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		TransferApprovalTransBO bo = null;
		TransferApprovalTransVO vo = null;
		String strmsgText = "";

		try {
			bo = new TransferApprovalTransBO();
			vo = new TransferApprovalTransVO();

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
			new HisException("INVMGM", "TransferApprovalTransDATA->initOrderGenerate()", strmsgText);

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
	public static void transferReject(TransferApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		TransferApprovalTransBO bo = null;
		TransferApprovalTransVO vo = null;

		String strmsgText = "";

		try {
			bo = new TransferApprovalTransBO();
			vo = new TransferApprovalTransVO();

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
			new HisException("INVMGM", "TransferApprovalTransDATA->initOrderGenerate()", strmsgText);

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
	public static void transferForcefullyClose(TransferApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		TransferApprovalTransBO bo = null;
		TransferApprovalTransVO vo = null;

		String strmsgText = "";

		try {
			bo = new TransferApprovalTransBO();
			vo = new TransferApprovalTransVO();

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
			new HisException("INVMGM", "TransferApprovalTransDATA->initOrderGenerate()", strmsgText);

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
	public static void cancelOrder(TransferApprovalTransFB formBean, HttpServletRequest request, HttpServletResponse response) throws IOException,
			ServletException {

		TransferApprovalTransBO bo = null;
		TransferApprovalTransVO vo = null;

		String strmsgText = "";

		try {
			bo = new TransferApprovalTransBO();
			vo = new TransferApprovalTransVO();
        
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
			new HisException("INVMGM", "TransferApprovalTransDATA->initOrderGenerate()", strmsgText);

		} finally {
			bo = null;
			vo = null;

		}

	}

}
