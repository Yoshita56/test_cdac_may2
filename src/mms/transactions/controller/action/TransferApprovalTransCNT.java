/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferApprovalTransCNT.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;
import mms.transactions.controller.data.TransferApprovalTransDATA;
import mms.transactions.controller.fb.TransferApprovalTransFB;
import mms.transactions.controller.utl.TransferApprovalTransUTL;

// TODO: Auto-generated Javadoc
/**
 * The Class TransferApprovalTransCNT.
 */
public class TransferApprovalTransCNT extends GenericController {

	/**
	 * Instantiates a new transfer approval trans cnt.
	 */
	public TransferApprovalTransCNT() 
	{
		super(new TransferApprovalTransUTL(), "/transactions/TransferApprovalTransCNT");
		
	}

	/**
	 * Order generate.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward ORDER_GENERATE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {
		generateToken(request);
		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		TransferApprovalTransDATA.initOrderGenerate(formBean, request, response);

		return mapping.findForward("orderGenerate");
	}

	/**
	 * Gets the demand req dtl.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward GET_DEMAND_REQ_DTL(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {

		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferApprovalTransDATA.getDemandRequestDetails(formBean, request, response);

		return null;
	}

	/**
	 * Order generate insert.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward ORDER_GENERATE_INSERT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {
		try {
			this.validateToken(request, response);
		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferApprovalTransDATA.insertOrderGenerate(formBean,request,response);

		return this.ORDER_GENERATE(mapping, formBean, request, response);
		} catch (Exception e) {
			System.out.println("RateContractItemWiseTransCNT.INSERTRENEW >> " + e.getMessage());
		}

		return null;

		}


	/**
	 * Gets the trans dtl.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward GET_TRANS_DTL(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {

		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferApprovalTransDATA.getTransferingDetails(formBean, request, response);

		return null;
	}

	/**
	 * Order modify.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward ORDER_MODIFY(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {
		generateToken(request);
		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		String chk = formBean.getChk()[0];

		String strOrderNo = chk.replace("@", "#").split("#")[0];
		String strOrderSlno=chk.replace("@", "#").split("#")[1];

		formBean.setStrOrderNo(strOrderNo);
		formBean.setStrOrderSlNo(strOrderSlno);

		TransferApprovalTransDATA.initOrderModify(formBean, request,response);

		return mapping.findForward("orderModify");
	}

	/**
	 * Order modify insert.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward ORDER_MODIFY_INSERT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {
		try {
			this.validateToken(request, response);
		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;
		formBean.setStrChk(request.getParameter("chk"));
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		TransferApprovalTransDATA.insertOrderModify(formBean,request,response);

		return this.LIST(mapping, formBean, request, response);
	}catch (Exception e) {
		System.out.println("RateContractItemWiseTransCNT.INSERTRENEW >> " + e.getMessage());
	}

	return null;

	}

	/**
	 * Order cancel.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward ORDER_CANCEL(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {

		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferApprovalTransDATA.cancelOrder(formBean,request,response);
		return this.LIST(mapping, form, request, response);
	}

	/**
	 * Order view.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 */
	public ActionForward ORDER_VIEW(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		String chk = formBean.getChk()[0];
		String strOrderNo = chk.replace("@", "#").split("#")[0];
		String strDemandSlNo=chk.replace("@", "#").split("#")[1];
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/TransferRequestTransCNT.cnt?hmode=orderView&strOrderNo=" + strOrderNo+"&strDemandSlNo=" + strDemandSlNo);
		acFwd.setContextRelative(true);
		return acFwd;
	}

	/**
	 * Transfer reject.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward TRANSFER_REJECT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {

		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferApprovalTransDATA.transferReject(formBean,request,response);
		return this.LIST(mapping, form, request, response);
	}

	/**
	 * Transfer ffclose.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward TRANSFER_FFCLOSE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {

		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		TransferApprovalTransDATA.transferForcefullyClose(formBean,request,response);

		return this.LIST(mapping, form, request, response);
	}

	/**
	 * Transfer view.
	 * 
	 * @param _mapping the _mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 */
	public ActionForward TRANSFER_VIEW(ActionMapping _mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
        // Store Id @ Request No @ Sl No @ Hosp Code $ App Qty $ Store Dtl  
		String chk = formBean.getChk()[0];

		String strRequestNo = chk.replace("@", "#").split("#")[1];
		String strStoreId   = chk.replace("@", "#").split("#")[0];
		String strSerialNo  = chk.replace("@", "#").split("#")[2];

		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/TransferRequestTransCNT.cnt?hmode=OrderView&strRequestNo=" + strRequestNo + "&strStoreId=" + strStoreId+"&strSerialNo="+strSerialNo);

		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	/**
	 * Demand view.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 */
	public ActionForward DEMAND_VIEW(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		// Store Id @ Request No @ Sl No @ Hosp Code $ App Qty $ Store Dtl  
		String chk = formBean.getChk()[0];

		String strRequestNo = chk.replace("@", "#").split("#")[1];
		String strStoreId   = chk.replace("@", "#").split("#")[0];
		String strSerialNo  = chk.replace("@", "#").split("#")[2];

		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/TransferDemandReqTransCNT.cnt?hmode=order_view&strRequestNo=" + strRequestNo + "&strStoreId=" + strStoreId+"&strSerialNo="+strSerialNo);
		acFwd.setContextRelative(true);
		return acFwd;
	}

	/**
	 * Demand reject.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward DEMAND_REJECT(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {

		TransferApprovalTransFB formBean = (TransferApprovalTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferApprovalTransDATA.demandReject(formBean,request,response);
		return this.LIST(mapping, form, request, response);
	}

	

}
