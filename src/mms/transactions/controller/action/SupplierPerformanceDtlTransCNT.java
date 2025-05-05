package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.SupplierPerformanceDtlTransDATA;
import mms.transactions.controller.fb.SupplierPerformanceDtlTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class SupplierPerformanceDtlTransCNT extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		SupplierPerformanceDtlTransFB formBean = (SupplierPerformanceDtlTransFB) form;

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
     
		SupplierPerformanceDtlTransFB formBean = (SupplierPerformanceDtlTransFB) form;
		formBean.reset(mapping, request);
		
		SupplierPerformanceDtlTransDATA.getDrugWareHouseNameCombo(formBean, request);
		
		
		formBean.setStrGoDetailsFlag("0");
		
		String target = "initialPage";
		return mapping.findForward(target);
	} 
	
	
	/**
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward getPoNoCmb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		SupplierPerformanceDtlTransFB fb = (SupplierPerformanceDtlTransFB) form;
		SupplierPerformanceDtlTransDATA.getPoNoCmb(fb, request,response);
	   	return null;
	}
	
	
	
	/**
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward getChallanNoCmb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		SupplierPerformanceDtlTransFB fb = (SupplierPerformanceDtlTransFB) form;
		SupplierPerformanceDtlTransDATA.getChallanNoCmb(fb, request,response);
	   	return null;
	}
	
	/**
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward getItemNameCmb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		SupplierPerformanceDtlTransFB fb = (SupplierPerformanceDtlTransFB) form;
		SupplierPerformanceDtlTransDATA.getItemNameCmb(fb, request,response);
	   	return null;
	}
	
	
	/**
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward getBatchCmb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		SupplierPerformanceDtlTransFB fb = (SupplierPerformanceDtlTransFB) form;
		SupplierPerformanceDtlTransDATA.getBatchNameCmb(fb, request,response);
	   	return null;
	}
	
	public ActionForward PREVBUDGETDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SupplierPerformanceDtlTransFB formBean = (SupplierPerformanceDtlTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SupplierPerformanceDtlTransDATA.getDrugWareHouseNameCombo(formBean, request);
		
//		SupplierPerformanceDtlTransDATA.getPrevBudgetDtls(formBean,request, response);
		
		String target = "initialPage";
		return mapping.findForward(target);
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

		SupplierPerformanceDtlTransFB formBean = (SupplierPerformanceDtlTransFB) form;
		SupplierPerformanceDtlTransDATA.saveSupplierPerformanceDtls(formBean,request, response);

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

		SupplierPerformanceDtlTransFB formBean = (SupplierPerformanceDtlTransFB) form;
		SupplierPerformanceDtlTransDATA.getDrugWareHouseNameCombo(formBean, request);

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
	public ActionForward getSupplierPerformancePendingDtlView(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{

		SupplierPerformanceDtlTransFB formBean = (SupplierPerformanceDtlTransFB) form;
		SupplierPerformanceDtlTransDATA.getSupplierPerformancePendingDtlView(formBean,request, response);
		return null;
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
	public ActionForward getSupplierPerformanceCompletedDtlView(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{

		SupplierPerformanceDtlTransFB formBean = (SupplierPerformanceDtlTransFB) form;
		SupplierPerformanceDtlTransDATA.getSupplierPerformanceCompletedDtlView(formBean,request, response);
		return null;
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
	public ActionForward DWHSUBTYPECMB(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{

		SupplierPerformanceDtlTransFB formBean = (SupplierPerformanceDtlTransFB) form;
		//SupplierPerformanceDtlTransDATA.getDWHSubStoreCmb(formBean,request, response);
		return null;
	}
	
	
	
}

