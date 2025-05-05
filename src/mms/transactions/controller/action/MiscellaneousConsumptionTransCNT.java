package mms.transactions.controller.action;

import hisglobal.presentation.CSRFGardTokenAction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.MiscellaneousConsumptionTransDATA;
import mms.transactions.controller.fb.MiscellaneousConsumptionTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 20/April/2009
 *  Module:MMS
 * Process: Miscellaneous Consumptions
 *
 */
/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Modify Date : 29/May/2009
 *  Module:MMS
 * Process: Miscellaneous Consumptions
 *
 */

public class MiscellaneousConsumptionTransCNT extends CSRFGardTokenAction {
	
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
         generateToken(request);
		return this.init(mapping, form, request, response);
		
	}

	/** This method is used to forward the request on first jsp page
	 * And calls the methods getInitialValues() which is define in MiscellaneousConsumptionTransDATA java file. AND LIST VALUES to display combos 
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
		generateToken(request);
		String strTarget = "index";
		MiscellaneousConsumptionTransFB formBean = (MiscellaneousConsumptionTransFB) form;
		MiscellaneousConsumptionTransDATA.getInitialValues(formBean,request);
		return mapping.findForward(strTarget);
	}
	
	/** This method is used to populate the Item Category  combo box for this activity
	 *  calls the methods getItemCategoryCmb() which is define in MiscellaneousConsumptionTransDATA java file.  
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward ITEMCATEGORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception, SQLException 
	{
		
		MiscellaneousConsumptionTransFB formBean = (MiscellaneousConsumptionTransFB) form;
	
		MiscellaneousConsumptionTransDATA.getItemCategoryCmb(formBean,request,response);
		
		return null;
	}
	
	
	/** This method is used to populate the group name combo box for that 
	 *  calls the methods getGroupNameCmb() which is define in MiscellaneousConsumptionTransDATA java file.  
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
		
		MiscellaneousConsumptionTransFB formBean = (MiscellaneousConsumptionTransFB) form;
	
		MiscellaneousConsumptionTransDATA.getGroupNameCmb(formBean,request,response);
		
		return null;
	}

	
	/** This method is used to save the miscellaneous Consumption and item details in database .
	 * 
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
		validateToken(request, response);
		MiscellaneousConsumptionTransFB formBean = (MiscellaneousConsumptionTransFB) form;
		MiscellaneousConsumptionTransDATA.insertMiscConsumpRecord(formBean,request,response);
		return this.init( mapping,  form,request,  response);
	}
	/** This method is used to cancel the Miscellaneous Consumption  page.
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
			   HttpServletRequest request, HttpServletResponse response) throws SQLException, Exception
			 {
		
			return this.unspecified(mapping, form, request, response);
			 /*    ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/hisglobal/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;*/
			 }
			 
	


}
