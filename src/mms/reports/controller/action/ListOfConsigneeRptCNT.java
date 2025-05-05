package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.ListOfConsigneeRptDATA;
import mms.reports.controller.fb.ListOfConsigneeRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ListOfConsigneeRptCNT extends DispatchAction 
{	
	/**
	 * To display the Supplier Name on the Screen.
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
		ListOfConsigneeRptFB formBean =(ListOfConsigneeRptFB)form;
		ListOfConsigneeRptDATA.getInitializedValues(formBean,request,response);
		
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
	public ActionForward GETPODETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		String target = "reportPage";
		ListOfConsigneeRptFB formBean = (ListOfConsigneeRptFB)form;
		ListOfConsigneeRptDATA.getPODtl(formBean,request,response);
		
		return null;
	}
	
	/**
	 * GETCONSIGNEEDTLPRINT Method Use to get the consignee Detail.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward GETCONSIGNEEDTLPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ListOfConsigneeRptFB fb = (ListOfConsigneeRptFB) form;
	    ListOfConsigneeRptDATA.getConsigneeDtlPrintPopUp(fb, request,response);
	   	return null;
	}
	
	
	/**
	 * GETCONSIGNEEDTLPRINT Method Use to get the consignee Detail.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward GETPDFRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ListOfConsigneeRptFB fb = (ListOfConsigneeRptFB) form;
	    ListOfConsigneeRptDATA.getConsigneeDtlGenratePDF(fb, request,response);
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
	/*public ActionForward SUPPLIERPODTLPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		//ListOfConsigneeRptFB fb = (ListOfConsigneeRptFB) form;
	   // ListOfConsigneeRptDATA.getSupplierPODtlPopUp(fb, request,response);
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
		//ListOfConsigneeRptFB fb = (ListOfConsigneeRptFB) form;
	    //ListOfConsigneeRptDATA.getPOChallanDtlPopUp(fb, request,response);
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
		//ListOfConsigneeRptFB fb = (ListOfConsigneeRptFB) form;
	    //ListOfConsigneeRptDATA.getChallanDtl(fb, request,response);
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
		//ListOfConsigneeRptFB fb = (ListOfConsigneeRptFB) form;
	    //ListOfConsigneeRptDATA.getChallanItemDtlPopUp(fb, request,response);
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
			  ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/hisglobal/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;
			 }
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		//ListOfConsigneeRptFB formBean = (ListOfConsigneeRptFB) form;
		//formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		//ListOfConsigneeRptDATA.showReport(formBean, request, response);
		
		
	}

}

