package mms.transactions.controller.action;

import java.sql.SQLException;

import hisglobal.exceptions.HisException;
import mms.transactions.controller.data.ItemTransferTransDATA;
import mms.transactions.controller.data.OfflineIssueIndentTransDATA;
import mms.transactions.controller.data.OnlineTransferDetailTransDATA;
import mms.transactions.controller.fb.ItemTransferTransFB;
import mms.transactions.controller.fb.OfflineIssueIndentTransFB;
import mms.transactions.controller.fb.OnlineTransferDetailTransFB;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class OnlineTransferDetailTransCNT extends DispatchAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		OnlineTransferDetailTransFB formBean = (OnlineTransferDetailTransFB) form;

		return this.INITVAL(mapping, formBean, request, response);

	}

	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	/*
	 * To Get the Store Combo
	 */

	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		OnlineTransferDetailTransFB formBean = (OnlineTransferDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		OnlineTransferDetailTransDATA.getInitDtls(formBean, request);
		String target = "initialPage";
		return mapping.findForward(target);
	}

	/*
	 * To Get the Store Combo
	 */

	public ActionForward getOrderNo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		
		OnlineTransferDetailTransFB formBean = (OnlineTransferDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		OnlineTransferDetailTransDATA.getOrderNo(formBean, request, response);
		return null;
	}

	public ActionForward INITVALGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		OnlineTransferDetailTransFB formBean = (OnlineTransferDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());
		OnlineTransferDetailTransDATA.initGoPage(formBean, request);

		String target = "GoPage";
		return mapping.findForward(target);
	}

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		OnlineTransferDetailTransFB formBean = (OnlineTransferDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		OnlineTransferDetailTransDATA.insert(formBean, request);

		return this.INITVAL(mapping, formBean, request, response);

	}

	/**
	 * 
	 * forwards control to the View page of this Transaction.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String strTarget = "view";
		OnlineTransferDetailTransFB formBean = (OnlineTransferDetailTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute(
				"HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID")
				.toString());

		OnlineTransferDetailTransDATA.getInitDtls(formBean, request);
		return mapping.findForward(strTarget);
		
		
		
	}

	/**
	 * 
	 * Method is used to get View details after pressing GO button
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward SEARCHTRANSFERDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){

		OnlineTransferDetailTransFB fb = (OnlineTransferDetailTransFB) form;
		OnlineTransferDetailTransDATA.searchTransferDetail(fb, request,
				response);
		return null;
	}
	
	/**
	 * 
	 * Method is used to get View details after pressing GO button
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward ITEMDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){

		OnlineTransferDetailTransFB fb = (OnlineTransferDetailTransFB) form;
		OnlineTransferDetailTransDATA.getItemDetailsTable(fb, request,
				response);
		return null;
	}
	
	
	

	/**
	 * 
	 * Method is used to get View details after pressing GO button
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		OnlineTransferDetailTransFB fb = (OnlineTransferDetailTransFB) form;
		OnlineTransferDetailTransDATA.getViewDtl(fb, request, response);
		return null;
	}
	
	
	
	/**
	 * 
	 * Method is used to get View details after pressing GO button
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward cancelDrugTransferDtl(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {

		OnlineTransferDetailTransFB fb = (OnlineTransferDetailTransFB) form;
		OnlineTransferDetailTransDATA.cancelDrugTransferDtl(fb, request);
		return VIEWPAGE(mapping, form, request, response);
	}

	/**
	 * VOUCHER 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward TRANSFERDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		OnlineTransferDetailTransFB fb = (OnlineTransferDetailTransFB) form;
		OnlineTransferDetailTransDATA.getTransferDtl(fb, request, response);
		return null;
	}
	
	
}
