/**********************************************************
 Project:DWH_GUJARAT	
 File:         TransferShortageApprovalTransCNT.java
 Created:      Jul 22, 2014
 Last Changed: Jul 22, 2014
 Author:       santoshsinghchauhan

This code is copyright (c) 2014 C-DAC Noida.

 ***********************************************************/
package mms.transactions.controller.action;

/**
 * @author santoshsinghchauhan
 * @date Jul 22, 2014
 * @file TransferShortageApprovalTransCNT.java
 */


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.TransferShortageApprovalTransDATA;
import mms.transactions.controller.fb.TransferShortageApprovalTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;

/**
 * The Class TransferShortageApprovalTransCNT.
 */
public class TransferShortageApprovalTransCNT extends DispatchAction {

	/**
	 * Generate.
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

	public ActionForward approve(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {		
		generateToken(request);
		String strChk = "";
		String path = "";
		if (request.getParameter("strChk") == null) {
		
			strChk = request.getParameter("chk");
		} else {
		
			strChk = request.getParameter("strChk");
		}
		
		if (request.getParameter("cnt_page") == null) {
			path = request.getParameter("strPath");
		} else {
			path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		}
		TransferShortageApprovalTransFB formBean = (TransferShortageApprovalTransFB) form;
		formBean.setStrPath(path.trim());
		formBean.setStrChk(strChk);
		String[] temp = strChk.split("\\@");
		String[] temp1 = temp[5].split("\\$");
		String strReqTypeId = temp1[0];
		formBean.setStrReqTypeId(strReqTypeId);
		TransferShortageApprovalTransDATA.initialApproval(formBean, request,response);
		String strtarget = "approve";
		return mapping.findForward(strtarget);

	}
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 * @throws ServletException 
	 * @throws IOException 
	 */
	
	public ActionForward reapprove(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws SQLException, IOException, ServletException {
		generateToken(request);
		String strChk = "";
		String path = "";
		if (request.getParameter("strChk") == null) {
		
			strChk = request.getParameter("chk");
		} else {
		
			strChk = request.getParameter("strChk");
		}
		
		if (request.getParameter("cnt_page") == null) {
			path = request.getParameter("strPath");
		} else {
			path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		}
		TransferShortageApprovalTransFB formBean = (TransferShortageApprovalTransFB) form;
		formBean.setStrPath(path.trim());
		formBean.setStrChk(strChk);
		String[] temp = strChk.split("\\@");
		String[] temp1 = temp[5].split("\\$");
		String strReqTypeId = temp1[0];
		formBean.setStrReqTypeId(strReqTypeId);
		
		TransferShortageApprovalTransDATA.initialApproval(formBean, request,response);
		
		String strtarget = "reapprove";
		return mapping.findForward(strtarget);
}

	/**
	 * Insert.
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

			TransferShortageApprovalTransFB formBean = (TransferShortageApprovalTransFB) form;
			String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
			formBean.setStrPath(path.trim());
			boolean retValue = false;
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			retValue=TransferShortageApprovalTransDATA.insertRecord(formBean,request,response);
			if (retValue) {
				return this.cancelToList(mapping, form, request, response);
			} else {
				return this.approve(mapping, form, request, response);
			}			
		} catch (Exception e) {
			System.out.println("TransferShortageApprovalTransCNT.INSERT >> " + e.getMessage());
		}

		return null;
	}
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 * @throws IOException
	 * @throws ServletException 
	 */
	
	public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HisException,
	SQLException, IOException, ServletException {
		generateToken(request);
		String strTarget = "";
		TransferShortageApprovalTransFB formBean = (TransferShortageApprovalTransFB) form;
		String strChk = request.getParameter("chk");
		String[] temp = strChk.split("\\@");
		String[] temp1 = temp[5].split("\\$");
		String strReqTypeId = temp1[0];
		formBean.setStrReqTypeId(strReqTypeId);
		formBean.setStrChk(request.getParameter("chk"));
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		strTarget = "view";
		TransferShortageApprovalTransDATA.viewData(formBean, request,response);
		return mapping.findForward(strTarget);
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
	 * Generatepdf.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward generatePdf(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {
		TransferShortageApprovalTransFB fb = (TransferShortageApprovalTransFB) form;
		TransferShortageApprovalTransDATA.generatePdf(fb, request, response);
		return null;
	}

}
