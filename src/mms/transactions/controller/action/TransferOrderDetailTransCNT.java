/**********************************************************
 Project:	   
 File:         TransferApprovalTransCNT.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;
import mms.transactions.controller.data.TransferOrderDetailTransDATA;
import mms.transactions.controller.fb.TransferOrderDetailTransFB;
import mms.transactions.controller.utl.TransferOrderDetailTransUTL;


// TODO: Auto-generated Javadoc
/**
 * The Class TransferOrderDetailTransCNT.
 */
public class TransferOrderDetailTransCNT extends GenericController {

	/**
	 * Instantiates a new transfer approval trans cnt.
	 */
	public TransferOrderDetailTransCNT() {
		super(new TransferOrderDetailTransUTL(), "/transactions/TransferOrderDetailTransCNT");
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
		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		TransferOrderDetailTransDATA.initOrderGenerate(formBean, request, response);

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

		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferOrderDetailTransDATA.getDemandRequestDetails(formBean, request, response);

		return null;
	}

	
	public ActionForward GET_ITEM_DTLS(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, IOException, ServletException {

		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferOrderDetailTransDATA.getGrpItemDetails(formBean, request, response);

		return null;
	}


	/**
	 * Invoked by Ajax Functions and sets the required Item Name Values.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */

	public ActionForward subGrpNameCmbDtl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
		TransferOrderDetailTransDATA.subGroupCombo(formBean, request, response);
		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required Item Brand Name Values.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */

	public ActionForward itemBrandNameDtl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
		TransferOrderDetailTransDATA.itemBrandName(formBean, request, response);
		return null;
	}

	

	/**
	 * Getbatchdetails.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward getBatchDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
		TransferOrderDetailTransDATA.getBatchDetails(formBean, request, response);
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

		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferOrderDetailTransDATA.insertOrderGenerate(formBean,request,response);

		return this.ORDER_GENERATE(mapping, formBean, request, response);
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

		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferOrderDetailTransDATA.getTransferingDetails(formBean, request, response);

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
		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		String chk = formBean.getChk()[0];

		String strOrderNo = chk.replace("@", "#").split("#")[0];
		String strOrderSlno=chk.replace("@", "#").split("#")[1];

		formBean.setStrOrderNo(strOrderNo);
		formBean.setStrOrderSlNo(strOrderSlno);

		TransferOrderDetailTransDATA.initOrderModify(formBean, request,response);

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

		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
		formBean.setStrChk(request.getParameter("chk"));
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		TransferOrderDetailTransDATA.insertOrderModify(formBean,request,response);

		return this.LIST(mapping, formBean, request, response);
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

		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferOrderDetailTransDATA.cancelOrder(formBean,request,response);
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

		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
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

		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferOrderDetailTransDATA.transferReject(formBean,request,response);
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

		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;

		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		TransferOrderDetailTransDATA.transferForcefullyClose(formBean,request,response);

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

		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
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

		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
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

		TransferOrderDetailTransFB formBean = (TransferOrderDetailTransFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		TransferOrderDetailTransDATA.demandReject(formBean,request,response);
		return this.LIST(mapping, form, request, response);
	}

	

}
