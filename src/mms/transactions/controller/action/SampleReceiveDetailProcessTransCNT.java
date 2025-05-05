package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.SampleReceiveDetailProcessTransDATA;
import mms.transactions.controller.fb.SampleReceiveDetailProcessTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class SampleReceiveDetailProcessTransCNT extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		SampleReceiveDetailProcessTransFB formBean = (SampleReceiveDetailProcessTransFB) form;

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
	 * To Get the Drug Warehouse Name & Drug Category Combo
	 */
	
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
     
		SampleReceiveDetailProcessTransFB formBean = (SampleReceiveDetailProcessTransFB) form;
		formBean.reset(mapping, request);
		SampleReceiveDetailProcessTransDATA.getDrugWareHouseNameCombo(formBean, request);
		
		String target = "initialPage";
		return mapping.findForward(target);
	} 
	
	
	/**
	 * Invoked by Ajax Functions and sets the required Item Category Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ITEMCATEGORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		SampleReceiveDetailProcessTransFB formBean = (SampleReceiveDetailProcessTransFB)form;
		SampleReceiveDetailProcessTransDATA.itemCatNo(formBean, request, response);
		return null;
	} 
	/**
	 * Invoked by Ajax Functions and sets the required Item Category Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GETDRUGWAREHOUSE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		SampleReceiveDetailProcessTransFB formBean = (SampleReceiveDetailProcessTransFB)form;
		SampleReceiveDetailProcessTransDATA.getSampleSentDWH(formBean, request, response);
		return null;
	} 
	
	/**
	 * Invoked by Ajax Functions and sets the required Item Category Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ITEMNAMECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		SampleReceiveDetailProcessTransFB formBean = (SampleReceiveDetailProcessTransFB)form;
		SampleReceiveDetailProcessTransDATA.getSampleSentDWHItemName(formBean, request, response);
		return null;
	} 
	
	/**
	 * Invoked by Ajax Functions and sets the required Item Category Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward BATCHNAMECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		SampleReceiveDetailProcessTransFB formBean = (SampleReceiveDetailProcessTransFB)form;
		SampleReceiveDetailProcessTransDATA.getItemBatchName(formBean, request, response);
		return null;
	} 
	/*
	 * To Get the Item Category Combo
	 */
	
	public ActionForward GETISSUEDRUGDETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SampleReceiveDetailProcessTransFB formBean = (SampleReceiveDetailProcessTransFB) form;
		SampleReceiveDetailProcessTransDATA.getIssueDrugDtls(formBean,request, response);
		
		return null;
	}
	
	
	
	/**
	 * To add data.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @throws SQLException
	 */

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		//saveToken(request);
		SampleReceiveDetailProcessTransFB formBean = (SampleReceiveDetailProcessTransFB) form;
		SampleReceiveDetailProcessTransDATA.insert(formBean,request, response);
		
		return this.INITVAL(mapping, form, request, response);
	}
	
	
	/**
	 * 
	 * forwards control to the View page of this  Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		String strTarget="view";
		
		SampleReceiveDetailProcessTransFB formBean = (SampleReceiveDetailProcessTransFB) form;
		SampleReceiveDetailProcessTransDATA.getDrugWareHouseNameCombo(formBean, request);
		return mapping.findForward(strTarget);
	}
	
	public ActionForward VIEWSAMPLERECEIVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{

		SampleReceiveDetailProcessTransFB formBean = (SampleReceiveDetailProcessTransFB)form;
		SampleReceiveDetailProcessTransDATA.viewSampleReceive(formBean, request, response);
		
		return null;
	}
	
	public ActionForward GENSAMPLERECEIVEDTLPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{

		SampleReceiveDetailProcessTransFB formBean = (SampleReceiveDetailProcessTransFB)form;
		SampleReceiveDetailProcessTransDATA.viewSampleReceivePrint(formBean, request, response);
		
		return null;
	}
//
//	
//	/**
//	 * To get View Details data.
//	 * 
//	 * @param mapping the mapping
//	 * @param form the form
//	 * @param request the request
//	 * @param response the response
//	 * 
//	 * @return the action forward
//	 * 
//	 * @throws Exception the exception
//	 * @throws SQLException the SQL exception
//	 */
//	public ActionForward GETVIEWPAGE(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
//	{
//
//		BudgetAllocationDetailProcessTransFB formBean = (BudgetAllocationDetailProcessTransFB) form;
//		BudgetAllocationDetailProcessTransDATA.getDrugWareHouseNameCombo(formBean, request);
//		BudgetAllocationDetailProcessTransDATA.getFinancialComboViewPage(formBean,request, response);
//
//		String target = "view";
//		return mapping.findForward(target);
//	}
//
//	/**
//	 * To get View Details data.
//	 * 
//	 * @param mapping the mapping
//	 * @param form the form
//	 * @param request the request
//	 * @param response the response
//	 * 
//	 * @return the action forward
//	 * 
//	 * @throws Exception the exception
//	 * @throws SQLException the SQL exception
//	 */
//	public ActionForward BUDGETDETAILSVIEW(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
//	{
//
//		BudgetAllocationDetailProcessTransFB formBean = (BudgetAllocationDetailProcessTransFB) form;
//		BudgetAllocationDetailProcessTransDATA.getViewDetails(formBean,request, response);
//		return null;
//	}
	
	
	
}

