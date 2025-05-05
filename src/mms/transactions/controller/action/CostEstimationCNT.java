package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.CostEstimationDATA;
import mms.transactions.controller.fb.CostEstimationFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class CostEstimationCNT extends DispatchAction
{
	String strtarget;
	
	/**
	 * <p>Method::Unspecified is used to Transfer the Control Over Action FIRSTDATA.
	 * @param  <ActionMapping>mapping
	 * @param  <ActionForm>form
	 * @param  <HttpServletRequest>request
	 * @param  <HttpServletResponse>response
	 * @return <ActionForward>target
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward unspecified(ActionMapping mapping
			                        ,ActionForm form
			                        ,HttpServletRequest request
			                        ,HttpServletResponse response)throws HisException, SQLException
    {
		return this.FIRSTDATA(mapping, form, request, response);
	}
	
	/**
	 * <p>Method::FIRSTDATA forwards control to the JSP page of Trasaction.
	 * @param  <ActionMapping>mapping
	 * @param  <ActionForm>form
	 * @param  <HttpServletRequest>request
	 * @param  <HttpServletResponse>response
	 * @return <ActionForward>target
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward FIRSTDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		CostEstimationFB fb = (CostEstimationFB) form;
	    CostEstimationDATA.GetData(fb, request); 
		strtarget = "costestimation";
		return mapping.findForward(strtarget);
	}
	
	public ActionForward PRINTCOST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{

		CostEstimationFB formBean = (CostEstimationFB)form;
		CostEstimationDATA.printCostEstimation(formBean, request, response);
		
		return null;
	}
	
	
	/** This method is used to cancel the Item Location.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response)
			 {
			  ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/hisglobal/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;
			 }
}
