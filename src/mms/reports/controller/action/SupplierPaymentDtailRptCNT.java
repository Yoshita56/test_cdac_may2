package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.SupplierPaymentDtailRptDATA;
import mms.reports.controller.fb.SupplierPaymentDtailRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class SupplierPaymentDtailRptCNT extends DispatchAction 
{	
	/**
	 * To display the Item Category Name on the Screen.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		String target = "initialPage";
		SupplierPaymentDtailRptFB formBean = (SupplierPaymentDtailRptFB)form;
		SupplierPaymentDtailRptDATA.getInitializedValues(formBean,request,response);
		
		return mapping.findForward(target);
	}
	
	/**
	 * To display the Item Category Name on the Screen.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 */
	public ActionForward GETPOCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		SupplierPaymentDtailRptFB formBean = (SupplierPaymentDtailRptFB)form;
		SupplierPaymentDtailRptDATA.getPOCombo(formBean,request,response);
		
		return null;
	}
	/**
	 * GETSUPPLIERPERFORMANCEDTL Method Use to get the Performance Detail.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward GETSUPPPERFORMANCEDTLPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		SupplierPaymentDtailRptFB fb = (SupplierPaymentDtailRptFB) form;
	    SupplierPaymentDtailRptDATA.getSupplierPerformanceDtlPrint(fb, request,response);
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
