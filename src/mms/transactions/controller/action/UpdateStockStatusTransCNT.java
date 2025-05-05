package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.UpdateStockStatusTransDATA;
import mms.transactions.controller.fb.UpdateStockStatusTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class UpdateStockStatusTransCNT extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		UpdateStockStatusTransFB formBean = (UpdateStockStatusTransFB) form;
		return this.INITVAL(mapping, formBean, request, response);
	}
	
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
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
			throws HisException, SQLException 
   {
     
		UpdateStockStatusTransFB formBean = (UpdateStockStatusTransFB) form;
		formBean.reset(mapping, request);
		
		UpdateStockStatusTransDATA.getInitializedValues(formBean,request,response);
		
		String target = "initialPage";
		return mapping.findForward(target);
	} 
	
	/**
	 * To display the Item Category Name on the Screen.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * 
	 * @return ActionForward object with target
	 */
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		UpdateStockStatusTransFB formBean = (UpdateStockStatusTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		UpdateStockStatusTransDATA.getItemCatDtls(formBean,request, response);
		
		return null;
	}
	
	
	/**
	 * To display the GETDRUGNAMECOMBO on the Screen.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * 
	 * @return ActionForward object with target
	 */
	public ActionForward GETDRUGNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		UpdateStockStatusTransFB formBean = (UpdateStockStatusTransFB)form;
		UpdateStockStatusTransDATA.getDrugNameValues(formBean,request,response);
		
		return null;
	}
	
	
	public ActionForward GETCURRSTOCKDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		UpdateStockStatusTransFB formBean = (UpdateStockStatusTransFB) form;
		UpdateStockStatusTransDATA.getCurrentStockDtls(formBean,request,response);
		
		return null;
	}
	
	
	public ActionForward GETSTOCKSTATUSLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		UpdateStockStatusTransFB formBean = (UpdateStockStatusTransFB) form;
		UpdateStockStatusTransDATA.getStockStatusList(formBean,request,response);
		
		return null;
	}
	
	
	
	public ActionForward GETUNITCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		UpdateStockStatusTransFB formBean = (UpdateStockStatusTransFB) form;
		UpdateStockStatusTransDATA.getUnitNameCombo(formBean,request,response);
		
		return null;
	}
	
	
	public ActionForward GETAPPROVEDBYCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		UpdateStockStatusTransFB formBean = (UpdateStockStatusTransFB) form;
		UpdateStockStatusTransDATA.getApprovedByCombo(formBean,request,response);
		
		return null;
	}
	
	/**
	 * To Save data.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{

		UpdateStockStatusTransFB formBean = (UpdateStockStatusTransFB) form;
		UpdateStockStatusTransDATA.saveUpdateStockDtls(formBean,request, response);

		return this.INITVAL(mapping, form, request, response);
	}

	
	/**
	 * To get View Details data.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward GETVIEWPAGE(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{

		UpdateStockStatusTransFB formBean = (UpdateStockStatusTransFB) form;
		UpdateStockStatusTransDATA.getInitializedViewValues(formBean, request, response);


		String target = "view";
		return mapping.findForward(target);
	}

	/**
	 * To get View Details data.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward GETUPDATEEDSTOCKVIEWDTLS(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{

		UpdateStockStatusTransFB formBean = (UpdateStockStatusTransFB) form;
		UpdateStockStatusTransDATA.getViewDetails(formBean,request, response);
		return null;
	}
	
	
}

