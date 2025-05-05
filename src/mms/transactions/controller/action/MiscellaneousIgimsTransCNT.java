package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.MiscellaneousIgimsTransDATA;
import mms.transactions.controller.fb.MiscellaneousIgimsTransFB;
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

public class MiscellaneousIgimsTransCNT extends CSRFGardTokenAction {
	
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
         generateToken(request);
		return this.init(mapping, form, request, response);
		
	}

	/** This method is used to forward the request on first jsp page
	 * And calls the methods getInitialValues() which is define in MiscellaneousIgimsTransDATA java file. AND LIST VALUES to display combos 
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
		MiscellaneousIgimsTransFB formBean = (MiscellaneousIgimsTransFB) form;
		MiscellaneousIgimsTransDATA.getInitialValues(formBean,request);
		return mapping.findForward(strTarget);
	}
	
	/** This method is used to populate the Item Category  combo box for this activity
	 *  calls the methods getItemCategoryCmb() which is define in MiscellaneousIgimsTransDATA java file.  
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
		
		MiscellaneousIgimsTransFB formBean = (MiscellaneousIgimsTransFB) form;
	
		MiscellaneousIgimsTransDATA.getItemCategoryCmb(formBean,request,response);
		
		return null;
	}
	
	
	/** This method is used to populate the group name combo box for that 
	 *  calls the methods getGroupNameCmb() which is define in MiscellaneousIgimsTransDATA java file.  
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
		
		MiscellaneousIgimsTransFB formBean = (MiscellaneousIgimsTransFB) form;
	
		MiscellaneousIgimsTransDATA.getGroupNameCmb(formBean,request,response);
		
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
		MiscellaneousIgimsTransFB formBean = (MiscellaneousIgimsTransFB) form;
		MiscellaneousIgimsTransDATA.insertMiscConsumpRecord(formBean,request,response);
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
		//voucher	 
	public ActionForward ISSUEDTLSINITNEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MiscellaneousIgimsTransFB formBean = (MiscellaneousIgimsTransFB) form;
		
		System.out.println("---- MiscellaneousIgimsTransCNT . ISSUEDTLSINITNEW ----");

		MiscellaneousIgimsTransDATA.issueDtlsInitNEW(request, response, formBean);

		return null;
	}
	public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		generateToken(request);
		 String strTarget="viewpage";
		
		 System.out.println("---------------MiscellaneousIgimsTransCNT.VIEWPAGE [ miscellaneous_consumption_view.jsp ]------------------");
		 
		 MiscellaneousIgimsTransFB fb = (MiscellaneousIgimsTransFB) form;
		 MiscellaneousIgimsTransDATA.initViewPageDtl(fb,request);
		
		 return mapping.findForward(strTarget);
	}
	
	/**
	 * 
	 * Method is used to get View details after pressing GO button
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		MiscellaneousIgimsTransFB fb = (MiscellaneousIgimsTransFB) form;
		MiscellaneousIgimsTransDATA.getViewDtlNEW(fb, request, response);
		return null;
	}
	
}
