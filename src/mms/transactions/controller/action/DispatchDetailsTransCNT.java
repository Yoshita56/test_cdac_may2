package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.DispatchDetailsTransDATA;
import mms.transactions.controller.fb.DispatchDetailsTransFB;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 09/April/2009
 *  Module:MMS
 * Process: Dispatch Details
 *
 */
/**
 * Developer : Baisakhi Roy
 * Version : 1.1
 * Start Date : 08/May/2009
 * End Date : 12/May/2009
 *  Module:MMS
 * Process: Dispatch Details
 *(All Changes after table Creation)
 */

public class DispatchDetailsTransCNT extends DispatchAction
{
	/* (non-Javadoc)
	 * 
	 * @see org.apache.struts.actions.DispatchAction#unspecified(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.ADVANCEMODE(mapping, form, request, response);
		
	}

	
	

	/** This method is used to forward the request on  jsp page in Advance Mode
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * 
	 */
	public ActionForward ADVANCEMODE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
	{
		String strTarget = "advance";
		DispatchDetailsTransFB formBean = (DispatchDetailsTransFB) form;
		DispatchDetailsTransDATA.getInitialValues(formBean,request);
		
		
		if(formBean.getHidePONO()!= null && !formBean.getHidePONO().equals("0") 
				&& !formBean.getHidePONO().equals("")){
		DispatchDetailsTransDATA.getDetailsAdvance(formBean,request,response);
		}
		
		return mapping.findForward(strTarget);
	}


	/** This method is used to forward the request on  jsp page in Bill Mode
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * 
	 */
	public ActionForward BILLMODE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
	{
		String strTarget = "bill";
		DispatchDetailsTransFB formBean = (DispatchDetailsTransFB) form;
		DispatchDetailsTransDATA.getInitialValues(formBean,request);
		
		if(formBean.getHidePONO()!= null && formBean.getHidePONO()!= "0" && formBean.getHidePONO()!= ""){
			DispatchDetailsTransDATA.getDetailsBill(formBean,request,response);
		}
		return mapping.findForward(strTarget);
	}
	
	public ActionForward VIEWMODE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
	{
		String strTarget = "view";
		DispatchDetailsTransFB formBean = (DispatchDetailsTransFB) form;
		DispatchDetailsTransDATA.getInitialValues(formBean,request);
		
		if(formBean.getHideStoreId()!= null && !formBean.getHideStoreId().equals("0")
				&& !formBean.getHideStoreId().equals("")){
			DispatchDetailsTransDATA.getViewDetails(formBean,request,response);
		}
		return mapping.findForward(strTarget);
	}

	/** This method is used to save and update the data  in Advance mode 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward SAVEADVANCE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
	{
		DispatchDetailsTransFB formBean = (DispatchDetailsTransFB) form;
		DispatchDetailsTransDATA.insertAdvance(formBean,request,response);
		return this.ADVANCEMODE( mapping,  formBean,
				 request,  response);
	}
	/** This method is used to save and update the data  in Bill mode 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward SAVEBILL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
	{
		DispatchDetailsTransFB formBean = (DispatchDetailsTransFB) form;
		DispatchDetailsTransDATA.insertBill(formBean,request,response);
		return this.BILLMODE( mapping,  formBean,
				 request,  response);
	}
	
	/** This method is used to get Item Category Combo
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	
	public ActionForward ITEMCATEGORYCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
	{
		
		DispatchDetailsTransFB formBean = (DispatchDetailsTransFB) form;
		DispatchDetailsTransDATA.getItemCatCombo(formBean, request, response);
		
		return null;
	}
	/** This method is used to get PONO Combo
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward PONOCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
	{
		
		DispatchDetailsTransFB formBean = (DispatchDetailsTransFB) form;
		DispatchDetailsTransDATA.getPONOCombo(formBean, request, response);
		
		return null;
	}
	
	/**This method is used to cancel the Dispatch Details page.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
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
