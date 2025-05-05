package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.BudgetAllocationDetailProcessTransDATA;
import mms.transactions.controller.fb.BudgetAllocationDetailProcessTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class BudgetAllocationDetailProcessTransCNT extends DispatchAction{
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
   {
		BudgetAllocationDetailProcessTransFB formBean = (BudgetAllocationDetailProcessTransFB) form;

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
     
		BudgetAllocationDetailProcessTransFB formBean = (BudgetAllocationDetailProcessTransFB) form;
		formBean.reset(mapping, request);
		BudgetAllocationDetailProcessTransDATA.getFinancialYearCombo(formBean, request);
		BudgetAllocationDetailProcessTransDATA.getDrugWareHouseNameCombo(formBean, request);
		BudgetAllocationDetailProcessTransDATA.getDWHSubTypeCombo(formBean, request);
		
		formBean.setStrGoDetailsFlag("0");
		
		String target = "initialPage";
		return mapping.findForward(target);
	} 
	
	/*
	 * To Get the Item Category Combo
	 */
	
	public ActionForward PREVBUDGETDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		BudgetAllocationDetailProcessTransFB formBean = (BudgetAllocationDetailProcessTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BudgetAllocationDetailProcessTransDATA.getDrugWareHouseNameCombo(formBean, request);
		BudgetAllocationDetailProcessTransDATA.getDWHSubTypeCombo(formBean, request);
		BudgetAllocationDetailProcessTransDATA.getDWHSubStoreCmb(formBean, request, response);
		BudgetAllocationDetailProcessTransDATA.getPrevBudgetDtls(formBean,request, response);
		
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

		BudgetAllocationDetailProcessTransFB formBean = (BudgetAllocationDetailProcessTransFB) form;
		BudgetAllocationDetailProcessTransDATA.saveBudgetDtls(formBean,request, response);

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

		BudgetAllocationDetailProcessTransFB formBean = (BudgetAllocationDetailProcessTransFB) form;
		formBean.setStrPageFlag("VIEW");
		
		BudgetAllocationDetailProcessTransDATA.getDrugWareHouseNameCombo(formBean, request);
		BudgetAllocationDetailProcessTransDATA.getFinancialComboViewPage(formBean,request, response);
		BudgetAllocationDetailProcessTransDATA.getDWHSubTypeCombo(formBean, request);
		
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
	public ActionForward BUDGETDETAILSVIEW(ActionMapping mapping, ActionForm form,	HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException 
	{

		BudgetAllocationDetailProcessTransFB formBean = (BudgetAllocationDetailProcessTransFB) form;
		BudgetAllocationDetailProcessTransDATA.getViewDetails(formBean,request, response);
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

		BudgetAllocationDetailProcessTransFB formBean = (BudgetAllocationDetailProcessTransFB) form;
		BudgetAllocationDetailProcessTransDATA.getDWHSubStoreCmb(formBean,request, response);
		return null;
	}
	
	
	
}

