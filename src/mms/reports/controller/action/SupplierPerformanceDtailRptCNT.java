package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.SupplierPerformanceDtailRptDATA;
import mms.reports.controller.fb.SupplierPerformanceDtailRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class SupplierPerformanceDtailRptCNT extends DispatchAction 
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
		String target = "reportPage";
		SupplierPerformanceDtailRptFB formBean = (SupplierPerformanceDtailRptFB)form;
		SupplierPerformanceDtailRptDATA.getInitializedValues(formBean,request,response);
		
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
	public ActionForward GETDRUGNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		SupplierPerformanceDtailRptFB formBean = (SupplierPerformanceDtailRptFB)form;
		SupplierPerformanceDtailRptDATA.getDrugNameValues(formBean,request,response);
		
		return null;
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
		
		SupplierPerformanceDtailRptFB formBean = (SupplierPerformanceDtailRptFB)form;
		SupplierPerformanceDtailRptDATA.getPOCombo(formBean,request,response);
		
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
	public ActionForward GETSUPPLIERPERFORMANCEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		SupplierPerformanceDtailRptFB fb = (SupplierPerformanceDtailRptFB) form;
	    SupplierPerformanceDtailRptDATA.getSupplierPerformanceDtl(fb, request,response);
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
		SupplierPerformanceDtailRptFB fb = (SupplierPerformanceDtailRptFB) form;
	    SupplierPerformanceDtailRptDATA.getSupplierPerformanceDtlPrint(fb, request,response);
	   	return null;
	}
	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	/*public ActionForward GETPRINTSCREENTWO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		//SupplierPerformanceDtailRptFB fb = (SupplierPerformanceDtailRptFB) form;
	    //SupplierPerformanceDtailRptDATA.getPrintScreenTwo(fb, request,response);
	   	return null;
	}*/
	
	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	/*public ActionForward SUPPLIERPODTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		//SupplierPerformanceDtailRptFB fb = (SupplierPerformanceDtailRptFB) form;
	   // SupplierPerformanceDtailRptDATA.getSupplierPODtlPopUp(fb, request,response);
	   	return null;
	}*/
	
	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	/*public ActionForward GETPOCHALLANDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		//SupplierPerformanceDtailRptFB fb = (SupplierPerformanceDtailRptFB) form;
	    //SupplierPerformanceDtailRptDATA.getPOChallanDtlPopUp(fb, request,response);
	   	return null;
	}*/
	
	
	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	/*public ActionForward GETCHALLANDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		//SupplierPerformanceDtailRptFB fb = (SupplierPerformanceDtailRptFB) form;
	    //SupplierPerformanceDtailRptDATA.getChallanDtl(fb, request,response);
	   	return null;
	}*/
	
	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	/*public ActionForward GETCHALLANITEMDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		//SupplierPerformanceDtailRptFB fb = (SupplierPerformanceDtailRptFB) form;
	    //SupplierPerformanceDtailRptDATA.getChallanItemDtlPopUp(fb, request,response);
	   	return null;
	}*/
	
	
	
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
			//System.out.println("inside cancel of action");
			  ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/hisglobal/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;
			 }
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		//SupplierPerformanceDtailRptFB formBean = (SupplierPerformanceDtailRptFB) form;
		//formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		//SupplierPerformanceDtailRptDATA.showReport(formBean, request, response);
		
		
	}

}
