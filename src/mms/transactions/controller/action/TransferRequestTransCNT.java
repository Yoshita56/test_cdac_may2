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
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import mms.transactions.controller.data.TransferRequestTransDATA;
import mms.transactions.controller.fb.TransferRequestTransFB;
import mms.transactions.controller.utl.TransferRequestTransUTL;


/**
 * The Class TransferRequestTransCNT.
 */
public class TransferRequestTransCNT extends GenericController {

	/**
	 * Instantiates a new transfer request trans cnt.
	 */
	public TransferRequestTransCNT() {
		super(new TransferRequestTransUTL(), "/transactions/TransferRequestTransCNT");
	}

	/**
	 * forwards control to the ADD page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws Exception the exception
	 */

	public ActionForward generate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		generateToken(request);
		TransferRequestTransFB formBean = (TransferRequestTransFB) form;
		TransferRequestTransDATA.initialAdd(formBean, request, response);
		String strtarget = "generateRequest";
		return mapping.findForward(strtarget);
	}

	/**
	 * forwards control to the ADD page.
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

	public ActionForward modifyRecord(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		generateToken(request);
		TransferRequestTransFB formBean = (TransferRequestTransFB) form;
		formBean.setStrChk(request.getParameter("chk"));
		TransferRequestTransDATA.initModify(formBean, request,response);

		String strtarget = "modifyRequest";
		return mapping.findForward(strtarget);

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
	 * @throws ServletException 
	 * @throws IOException 
	 */

	public ActionForward subGrpNameCmb(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferRequestTransFB formBean = (TransferRequestTransFB) form;
		TransferRequestTransDATA.subGroupCombo(formBean, request, response);
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
	 * @throws ServletException 
	 * @throws IOException 
	 */

	public ActionForward itemBrandName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferRequestTransFB formBean = (TransferRequestTransFB) form;
		TransferRequestTransDATA.itemBrandName(formBean, request, response);
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
		TransferRequestTransFB formBean = (TransferRequestTransFB) form;
		TransferRequestTransDATA.getBatchDetails(formBean, request, response);
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
	 * @throws ServletException 
	 * @throws IOException 
	 */

	public ActionForward transferDtl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferRequestTransFB formBean = (TransferRequestTransFB) form;
		TransferRequestTransDATA.transferDtl(formBean, request, response);
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
	 * @throws ServletException 
	 * @throws IOException 
	 */

	public ActionForward transferItemDtl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferRequestTransFB formBean = (TransferRequestTransFB) form;
		TransferRequestTransDATA.transferItem(formBean, request, response);
		return null;
	}

	/**
	 * To add datab For Existing Batch in Current Stock.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws SQLException the SQL exception
	 */

	public ActionForward insertRecord(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException {
		try {
			this.validateToken(request, response);
			saveToken(request);

			TransferRequestTransFB formBean = (TransferRequestTransFB) form;
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			TransferRequestTransDATA.insert(formBean,request,response);
			return this.generate(mapping, form, request, response);
		} catch (Exception e) {
			System.out.println("TransferRequestTransCNT.insertRecord >> " + e.getMessage());
		}

		return null;
	}

	/**
	 * To add datab For Existing Batch in Current Stock.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws SQLException the SQL exception
	 */

	public ActionForward updateRecord(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException {
		try {
			this.validateToken(request, response);
			saveToken(request);
			TransferRequestTransFB formBean = (TransferRequestTransFB) form;
			formBean.setStrChk(request.getParameter("strModifyChk"));
			formBean.setStrStoreId(request.getParameter("strTmpStoreId"));
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			TransferRequestTransDATA.update(formBean, request, response);
			return this.LIST(mapping, form, request, response);
		} catch (Exception e) {
			System.out.println("TransferRequestTransCNT.updateRecord >> " + e.getMessage());
		}

		return null;
	}

	/**
	 * View.
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
	public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		generateToken(request);
		TransferRequestTransFB formBean = (TransferRequestTransFB) form;
		

		String strStoreId = formBean.getCombo()[0];
		formBean.setStrStoreId(strStoreId);
		formBean.setStrChk(request.getParameter("chk"));
		formBean.setStrOrderView("0");
		TransferRequestTransDATA.initView(formBean, request,response);
		formBean.setStrChk(request.getParameter("chk"));
		String strtarget = "viewRequest";
		return mapping.findForward(strtarget);

	}
	
	/**
	 * View.
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
	public ActionForward OrderView(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		generateToken(request);
		TransferRequestTransFB formBean = (TransferRequestTransFB) form;
		

		if (request.getParameter("strRequestNo") != null && request.getParameter("strRequestNo").trim().length() > 0) 
		{

			formBean.setStrRequestNo(request.getParameter("strRequestNo"));
		}
		if (request.getParameter("strSerialNo") != null && request.getParameter("strSerialNo").trim().length() > 0) 
		{

			formBean.setStrSerialNo(request.getParameter("strSerialNo"));
		}
		if (request.getParameter("strStoreId") != null && request.getParameter("strStoreId").trim().length() > 0) {

			formBean.setStrStoreId(request.getParameter("strStoreId"));
		} 
		formBean.setStrOrderView("1");
		//System.out.println("One--->>");
		TransferRequestTransDATA.initView(formBean, request,response);
		//HSTNUM_REQUEST_NO||'@'|| MODIFY_CANCEL_FLAG ||'@'||HSTNUM_SLNO
		formBean.setStrChk(request.getParameter("strRequestNo")+"@0@"+request.getParameter("strSerialNo"));
		String strtarget = "viewRequest";
		return mapping.findForward(strtarget);

	}

	/**
	 * Order view.
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
	public ActionForward orderView(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		generateToken(request);
		TransferRequestTransFB formBean = (TransferRequestTransFB) form;
		formBean.setStrOrderNo(request.getParameter("strOrderNo"));
		formBean.setStrDemandSlNo(request.getParameter("strDemandSlNo"));
		formBean.setStrChk(request.getParameter("chk"));
		TransferRequestTransDATA.initOrderView(formBean, request,response);
		formBean.setStrChk(request.getParameter("chk"));
		String strtarget = "orderView";
		return mapping.findForward(strtarget);

	}

	/**
	 * Cancels the record.
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
	public ActionForward cancelRecord(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		boolean retValue = false;

		TransferRequestTransFB formBean = (TransferRequestTransFB) form;
		formBean.setStrChk(request.getParameter("chk"));
		retValue = TransferRequestTransDATA.cancelRecord(request, formBean,response);
		if (retValue) {
			return this.LIST(mapping, form, request, response);
		} else {
			return this.LIST(mapping, form, request, response);
		}

	}

	/**
	 * Returntodesk.
	 * 
	 * @param mapping the _mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 */
	public ActionForward returnToDesk(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		return this.LIST(mapping, form, request, response);
	}

	/**
	 * Canceltolist.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws SQLException the SQL exception
	 */
	public ActionForward cancelToList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException {
		ActionForward acFwd = new ActionForward();
		String strPath = "";
		if (request.getParameter("strPath") != null) {
			strPath = request.getParameter("strPath").concat("?hmode=CANCEL");
			acFwd.setPath(strPath);
			acFwd.setContextRelative(true);

		}
		return acFwd;
	}

	/**
	 * Getprintscreentwo.
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
	public ActionForward getPrintScreenTwo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferRequestTransFB fb = (TransferRequestTransFB) form;
		TransferRequestTransDATA.getPrintScreenTwo(fb, request, response);
		return null;
	}

	/**
	 * Generatepdf.
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
	public ActionForward generatePdf(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferRequestTransFB fb = (TransferRequestTransFB) form;
		TransferRequestTransDATA.generatePdf(fb, request, response);
		return null;
	}
}
