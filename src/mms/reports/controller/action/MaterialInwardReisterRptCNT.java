package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.MaterialInwardReisterRptDATA;
import mms.reports.controller.fb.MaterialInwardReisterRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class MaterialInwardReisterRptCNT extends DispatchAction 
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
		MaterialInwardReisterRptFB formBean = (MaterialInwardReisterRptFB)form;
		MaterialInwardReisterRptDATA.getInitializedValues(formBean,request,response);
		
		return mapping.findForward(target);
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
	public ActionForward GETSCREENTWO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		MaterialInwardReisterRptFB fb = (MaterialInwardReisterRptFB) form;
	    MaterialInwardReisterRptDATA.getScreenTwo(fb, request,response);
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
	public ActionForward GETPRINTSCREENTWO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		MaterialInwardReisterRptFB fb = (MaterialInwardReisterRptFB) form;
	    MaterialInwardReisterRptDATA.getPrintScreenTwo(fb, request,response);
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
	public ActionForward SUPPLIERPODTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		MaterialInwardReisterRptFB fb = (MaterialInwardReisterRptFB) form;
	    MaterialInwardReisterRptDATA.getSupplierPODtlPopUp(fb, request,response);
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
	public ActionForward GETPOCHALLANDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		MaterialInwardReisterRptFB fb = (MaterialInwardReisterRptFB) form;
	    MaterialInwardReisterRptDATA.getPOChallanDtlPopUp(fb, request,response);
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
	public ActionForward GETCHALLANDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		MaterialInwardReisterRptFB fb = (MaterialInwardReisterRptFB) form;
	    MaterialInwardReisterRptDATA.getChallanDtl(fb, request,response);
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
	public ActionForward GETCHALLANITEMDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		MaterialInwardReisterRptFB fb = (MaterialInwardReisterRptFB) form;
	    MaterialInwardReisterRptDATA.getChallanItemDtlPopUp(fb, request,response);
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
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MaterialInwardReisterRptFB formBean = (MaterialInwardReisterRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		MaterialInwardReisterRptDATA.showReport(formBean, request, response);
		
		
	}
	public ActionForward Back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		String target = "reportPage";
		MaterialInwardReisterRptFB formBean = (MaterialInwardReisterRptFB)form;
		MaterialInwardReisterRptDATA.getInitializedValues(formBean,request,response);
		
		return mapping.findForward(target);
	}

}
