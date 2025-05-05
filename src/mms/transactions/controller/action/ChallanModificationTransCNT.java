package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ChallanModificationTransDATA;
import mms.transactions.controller.fb.ChallanModificationTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ChallanModificationTransCNT extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		ChallanModificationTransFB formBean = (ChallanModificationTransFB) form;

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
     
		ChallanModificationTransFB formBean = (ChallanModificationTransFB) form;
		formBean.reset(mapping, request);
		
		ChallanModificationTransDATA.getDrugWareHouseNameCombo(formBean, request);
		
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
		ChallanModificationTransFB fb = (ChallanModificationTransFB) form;
		ChallanModificationTransDATA.getPoNoCmb(fb, request,response);
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
	public ActionForward getSupplierCmb(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ChallanModificationTransFB fb = (ChallanModificationTransFB) form;
		ChallanModificationTransDATA.getSupplierCmb(fb, request,response);
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
		ChallanModificationTransFB fb = (ChallanModificationTransFB) form;
		ChallanModificationTransDATA.getChallanNoCmb(fb, request,response);
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
		ChallanModificationTransFB fb = (ChallanModificationTransFB) form;
		ChallanModificationTransDATA.getItemNameCmb(fb, request,response);
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
	public ActionForward SUPPLIERPERPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ChallanModificationTransFB fb = (ChallanModificationTransFB) form;
		ChallanModificationTransDATA.getSupplierPerformancePopUp(fb, request,response);
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
	public ActionForward CHALLANDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ChallanModificationTransFB fb = (ChallanModificationTransFB) form;
		ChallanModificationTransDATA.getChallanDtl(fb, request,response);
	   	return null;
	}
	
	
	
	public ActionForward PREVBUDGETDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ChallanModificationTransFB formBean = (ChallanModificationTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ChallanModificationTransDATA.getDrugWareHouseNameCombo(formBean, request);
		
//		ChallanModificationTransDATA.getPrevBudgetDtls(formBean,request, response);
		
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

		ChallanModificationTransFB formBean = (ChallanModificationTransFB) form;
		ChallanModificationTransDATA.saveSupplierPerformanceDtls(formBean,request, response);

		return this.INITVAL(mapping, form, request, response);
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
	public ActionForward SAVECHALLANDTL(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{

		ChallanModificationTransFB formBean = (ChallanModificationTransFB) form;
		ChallanModificationTransDATA.saveChallanDtls(formBean,request, response);

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

		ChallanModificationTransFB formBean = (ChallanModificationTransFB) form;
		ChallanModificationTransDATA.getDrugWareHouseNameCombo(formBean, request);

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

		ChallanModificationTransFB formBean = (ChallanModificationTransFB) form;
		ChallanModificationTransDATA.getSupplierPerformancePendingDtlView(formBean,request, response);
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

		ChallanModificationTransFB formBean = (ChallanModificationTransFB) form;
		ChallanModificationTransDATA.getSupplierPerformanceCompletedDtlView(formBean,request, response);
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

		ChallanModificationTransFB formBean = (ChallanModificationTransFB) form;
		//ChallanModificationTransDATA.getDWHSubStoreCmb(formBean,request, response);
		return null;
	}
	
	
	
}

