package mms.transactions.controller.action;


import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.SetSachetDetailsTransDATA;
import mms.transactions.controller.fb.SetSachetDetailsTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
&& * Developer : Anshul Jindal
 * Version : 2.0
 * Date : 11/May/2009, 30-june-09
 *  Module:MMS
 * Unit:Set/Sachet Details
 *
 */

/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 23/Jan/2009
 *  Module:MMS
 * Unit:Set/Sachet Details
 *
 */


public class SetSachetDetailsTransCNT extends DispatchAction {

	
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

		return this.init(mapping, form, request, response);
		
	}

	/** This method is used to forward the request on first jsp page
	 * And calls the methods getInitialValues() which is define in SetSachetDetailsTransDATA java file. AND LIST VALUES to display combos 
	 * on first page. 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * 
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
	{
		String strTarget = "index";
		SetSachetDetailsTransFB formBean = (SetSachetDetailsTransFB) form;
		SetSachetDetailsTransDATA.getInitialValues(formBean,request,response);
		return mapping.findForward(strTarget);
	}
	
	/** This method is used to populate the group name combo box for that 
	 *  calls the methods getGroupNameCmb() which is define in SetSachetDetailsTransDATA java file.  
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward GROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
	{
		
		SetSachetDetailsTransFB formBean = (SetSachetDetailsTransFB) form;
	
		SetSachetDetailsTransDATA.getGroupNameCmb(formBean,request,response);
		
		return null;
	}
	
	/** This method is used to populate the group name combo box for that 
	 *  calls the methods getCategoryNameCmb() which is define in SetSachetDetailsTransDATA java file.  
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward CATEGORYNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
	{
		
		SetSachetDetailsTransFB formBean = (SetSachetDetailsTransFB) form;
	
		SetSachetDetailsTransDATA.getCategoryNameCmb(formBean,request,response);
		
		return null;
	}
	/** This method is used to populate the sub group name combo box for this
	 *  calls the methods getSubGroupNameCmb() which is define in SetSachetDetailsTransDATA java file.  
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	
	public ActionForward SUBGROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
	{
		
		SetSachetDetailsTransFB formBean = (SetSachetDetailsTransFB) form;
	
		SetSachetDetailsTransDATA.getSubGroupNameCmb(formBean,request,response);
		
		return null;
	}
	/** This method is used to populate the Set/Sachet name combo box for this
	 *  calls the methods getSetSachetNameCmb() which is define in SetSachetDetailsTransDATA java file. 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	
	public ActionForward SACHETNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
	{
		
		SetSachetDetailsTransFB formBean = (SetSachetDetailsTransFB) form;
	
		SetSachetDetailsTransDATA.getSetSachetNameCmb(formBean,request,response);
		
		return null;
	}
	/** This method is used to display the value of item details  for this
	 *  calls the methods getItemDetails() which is define in SetSachetDetailsTransDATA java file. .
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward ITEMVIEWDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
	{
		
		SetSachetDetailsTransFB formBean = (SetSachetDetailsTransFB) form;
		SetSachetDetailsTransDATA.getItemDetails(formBean,request,response);
		
		return null;
	}
	/** This method is used to save the set/sachet details and item details in database  for this
	 *  calls the methods insertSetSachetDetails() which is define in SetSachetDetailsTransDATA java file.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
	{
		SetSachetDetailsTransFB formBean = (SetSachetDetailsTransFB) form;
		SetSachetDetailsTransDATA.insertSetSachetDetails(formBean,request,response);
		
		return this.init( mapping,  form,
				 request,  response);
	}
	/** This method is used to cancel the Set/Sachet Details page.
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
