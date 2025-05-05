package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.MaterialOutwardRegisterRptDATA;
import mms.reports.controller.fb.MaterialOutwardRegisterRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class MaterialOutwardRegisterRptCNT extends DispatchAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.INITVAL(mapping, form, request, response);
		
	}
	
	
	
	
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		

		String strTarget = "reportPage";
		MaterialOutwardRegisterRptFB formBean = (MaterialOutwardRegisterRptFB) form;
		
		MaterialOutwardRegisterRptDATA.getInitializedValues(formBean,request, response);
//		MaterialOutwardRegisterRptDATA.getToStoreCmb(formBean, request,response);
		return mapping.findForward(strTarget);
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
	public ActionForward GETISSUEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		MaterialOutwardRegisterRptFB fb = (MaterialOutwardRegisterRptFB) form;
	    MaterialOutwardRegisterRptDATA.getIssueDetails(fb, request,response);
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
	public ActionForward PRINTMAINSCREENISSUEDTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		MaterialOutwardRegisterRptFB fb = (MaterialOutwardRegisterRptFB) form;
	    MaterialOutwardRegisterRptDATA.printIssueDetailsMain(fb, request,response);
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
	public ActionForward GETISSUEDTLPOPUP1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		MaterialOutwardRegisterRptFB fb = (MaterialOutwardRegisterRptFB) form;
	    MaterialOutwardRegisterRptDATA.getIssueDtlPopUp1(fb, request,response);
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
	public ActionForward GETISSUEDTLPOPUP2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		MaterialOutwardRegisterRptFB fb = (MaterialOutwardRegisterRptFB) form;
	    MaterialOutwardRegisterRptDATA.getIssueDtlPopUp2(fb, request,response);
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
	public ActionForward GETTOSTORE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		MaterialOutwardRegisterRptFB fb = (MaterialOutwardRegisterRptFB) form;
	    MaterialOutwardRegisterRptDATA.getToStoreCmb(fb, request,response);
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
	public ActionForward GETISSUEDITEMDTLPOPUP3(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		MaterialOutwardRegisterRptFB fb = (MaterialOutwardRegisterRptFB) form;
	    MaterialOutwardRegisterRptDATA.getIssueItemDtl(fb, request,response);
	   	return null;
	}
	
	
	/*public ActionForward STORECMB(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws HisException, SQLException 
	{
		
		MaterialOutwardRegisterRptFB formBean = (MaterialOutwardRegisterRptFB) form;
		MaterialOutwardRegisterRptDATA.getStoreList(formBean,request, response);
		return null;
	}*/
	
	
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MaterialOutwardRegisterRptFB formBean = (MaterialOutwardRegisterRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		MaterialOutwardRegisterRptDATA.showReport(formBean, request, response);
		
		
	}
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
}

