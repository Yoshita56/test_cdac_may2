/**********************************************************
 Project:	   DWH_GUJARAT	
 File:         TransferDemandReqTransCNT.java
 Created:      Jul 3, 2014
 Last Changed: Jul 3, 2014
 Author:       cdac

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.TransferDemandReqTransDATA;
import mms.transactions.controller.fb.TransferDemandReqTransFB;
import mms.transactions.controller.utl.TransferDemandReqTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * The Class TransferDemandReqTransCNT.
 */
public class TransferDemandReqTransCNT extends GenericController {

	/**
	 * Instantiates a new transfer demand req trans cnt.
	 */
	public TransferDemandReqTransCNT() {
		super(new TransferDemandReqTransUTL(), "/transactions/TransferDemandReqTransCNT");
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

	public ActionForward generate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		generateToken(request);
		TransferDemandReqTransFB formBean = (TransferDemandReqTransFB) form;
		TransferDemandReqTransDATA.initialAdd(formBean, request, response);
		String strtarget = "generateDemand";
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
		TransferDemandReqTransFB formBean = (TransferDemandReqTransFB) form;
		formBean.setStrChk(request.getParameter("chk"));
		TransferDemandReqTransDATA.initModify(formBean, request, response);

		String strtarget = "modifyDemand";
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
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */

	public ActionForward subGrpNameCmb(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferDemandReqTransFB formBean = (TransferDemandReqTransFB) form;
		TransferDemandReqTransDATA.subGroupCombo(formBean, request, response);
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

	public ActionForward itemBrandName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferDemandReqTransFB formBean = (TransferDemandReqTransFB) form;
		TransferDemandReqTransDATA.itemBrandName(formBean, request, response);
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

	public ActionForward transferDtl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferDemandReqTransFB formBean = (TransferDemandReqTransFB) form;
		TransferDemandReqTransDATA.transferDtl(formBean, request, response);
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

	public ActionForward transferItemDtl(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferDemandReqTransFB formBean = (TransferDemandReqTransFB) form;
		TransferDemandReqTransDATA.transferItem(formBean, request, response);
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

			TransferDemandReqTransFB formBean = (TransferDemandReqTransFB) form;
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			TransferDemandReqTransDATA.insert(formBean, request, response);
			return this.generate(mapping, form, request, response);
		} catch (Exception e) {
			System.out.println("TransferDemandReqTransCNT.insertRecord >> " + e.getMessage());
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
			TransferDemandReqTransFB formBean = (TransferDemandReqTransFB) form;
			formBean.setStrChk(request.getParameter("strModifyChk"));
			formBean.setStrStoreId(request.getParameter("strTmpStoreId"));
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			TransferDemandReqTransDATA.update(formBean, request, response);
			return this.LIST(mapping, form, request, response);
		} catch (Exception e) {
			System.out.println("TransferDemandReqTransCNT.updateRecord >> " + e.getMessage());
		}

		return null;
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

	public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException,
			IOException, ServletException {
		generateToken(request);
		TransferDemandReqTransFB formBean = (TransferDemandReqTransFB) form;

		formBean.setStrChk(request.getParameter("chk"));		
		String strStoreId = formBean.getCombo()[0];
		formBean.setStrStoreId(strStoreId);		
		formBean.setStrOrderView("0");
		TransferDemandReqTransDATA.initView(formBean, request, response);
		formBean.setStrChk(request.getParameter("chk"));
		String strtarget = "viewDemand";
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

	public ActionForward order_view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws SQLException,
			IOException, ServletException {
		generateToken(request);
		TransferDemandReqTransFB formBean = (TransferDemandReqTransFB) form;

		formBean.setStrChk(request.getParameter("chk"));

		if (request.getParameter("strRequestNo") != null && request.getParameter("strRequestNo").trim().length() > 0) {

			formBean.setStrChk(request.getParameter("strRequestNo"));
		}
		if (request.getParameter("strStoreId") != null && request.getParameter("strStoreId").trim().length() > 0) {

			formBean.setStrStoreId(request.getParameter("strStoreId"));
		} 
		if (request.getParameter("strSerialNo") != null && request.getParameter("strSerialNo").trim().length() > 0) {

			formBean.setStrSerialNo(request.getParameter("strSerialNo"));
		} 
		formBean.setStrOrderView("1");
		TransferDemandReqTransDATA.initView(formBean, request, response);

		//vo.setStrChk(formBean.getStrRequestNo()+"@0@"+formBean.getStrSerialNo());
		formBean.setStrChk(formBean.getStrRequestNo()+"@0@"+formBean.getStrSerialNo());

		String strtarget = "viewDemand";
		return mapping.findForward(strtarget);

	}


	/**
	 * is used to forward control to modify page.
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
	public ActionForward cancelRecord(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		boolean retValue = false;

		TransferDemandReqTransFB formBean = (TransferDemandReqTransFB) form;
		formBean.setStrChk(request.getParameter("chk"));
		retValue = TransferDemandReqTransDATA.cancelRecord(request, formBean, response);
		if (retValue) {
			return this.LIST(mapping, form, request, response);
		} else {
			return this.LIST(mapping, form, request, response);
		}

	}

	/**
	 * Returntodesk.
	 * 
	 * @param mapping the mapping
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
	 */
	public ActionForward cancelToList(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
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
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws ServletException the servlet exception
	 */
	public ActionForward getPrintScreenTwo(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferDemandReqTransFB fb = (TransferDemandReqTransFB) form;
		TransferDemandReqTransDATA.getPrintScreenTwo(fb, request, response);
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
		TransferDemandReqTransFB fb = (TransferDemandReqTransFB) form;
		TransferDemandReqTransDATA.generatePdf(fb, request, response);
		return null;
	}

	/**
	 * Check duplicate request.
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
	public ActionForward checkDuplicateRequest(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		TransferDemandReqTransFB formBean = (TransferDemandReqTransFB) form;
		TransferDemandReqTransDATA.checkDuplicateRequest(formBean, request, response);
		return null;
	}

}
