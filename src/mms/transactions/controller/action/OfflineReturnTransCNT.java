package mms.transactions.controller.action;

/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 16/Sep/2010
 * Modification Date: 
 *  
*/
import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.OfflineReturnTransDATA;
import mms.transactions.controller.fb.OfflineReturnTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
public class OfflineReturnTransCNT extends DispatchAction
{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public OfflineReturnTransCNT()
	{
		
	}
	
	 /***********************UNSPECIFIED**************************/
	 
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
	public ActionForward unspecified(ActionMapping mapping
			                        ,ActionForm form
			                        ,HttpServletRequest request
			                        ,HttpServletResponse response)throws HisException, SQLException
    {
		return this.FIRSTDATA(mapping, form, request, response);
	}
	/**
	 * forwards control to the ADD page of Trasaction.& get
	 * all data which required to show over add page
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward FIRSTDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OfflineReturnTransFB fb = (OfflineReturnTransFB) form;
		OfflineReturnTransDATA.GetData(fb, request); 
		strtarget = "offLineReturnDtl";
		return mapping.findForward(strtarget);

	}
	/**
	 * This method used to get Item Category Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ItemCatgoryCombo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OfflineReturnTransFB formBean = (OfflineReturnTransFB) form;
		OfflineReturnTransDATA.ItemCatgoryCombo(request,response,formBean);
		return null;

	}
	/**
	 * This method used to get Indent Store Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward IndentStoreCombo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OfflineReturnTransFB formBean = (OfflineReturnTransFB) form;
		OfflineReturnTransDATA.IndentingStoreCombo(request,response,formBean);
		return null;

	}
	/**
	 * CANCEL method  
	 * forwards control to the LIST  page of Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
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
	/**
	 * 
	 * forwards control to the View page of this  Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		String strTarget="view";
		
		OfflineReturnTransFB fb = (OfflineReturnTransFB) form;
		OfflineReturnTransDATA.initViewPageDtl(fb,request);
		return mapping.findForward(strTarget);
	}
	
	/**
	 * 
	 * forwards control to the View page details of this  Transaction.
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
			
		OfflineReturnTransFB fb = (OfflineReturnTransFB) form;
		OfflineReturnTransDATA.getViewDtl(fb, request, response);
		return null;
	}
	/** 
	 * This method Issue Item Details. (i.e hyperlink)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward GETPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		OfflineReturnTransFB formBean = (OfflineReturnTransFB) form;
		OfflineReturnTransDATA.getPopUp(request, response,formBean);
		return null;
	}
	
	/**
	 * This method used to get Indent Store Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ApprovedVerifyCombo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OfflineReturnTransFB formBean = (OfflineReturnTransFB) form;
		OfflineReturnTransDATA.ApprovedVerifyCombo(request,response,formBean);
		return null;

	}
	
	/** This method use to SAVE data
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
			throws Exception, SQLException {

		OfflineReturnTransFB formBean = (OfflineReturnTransFB) form;
		OfflineReturnTransDATA.insertData( formBean,request);
		return this.FIRSTDATA(mapping, form, request, response);
	}
	
	
	/**
	 * This method used to get Approved By Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ApprovedByCombo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OfflineReturnTransFB formBean = (OfflineReturnTransFB) form;
	
		OfflineReturnTransDATA.ApprovedByCombo(request,response,formBean);
		return null;

	}
	

	
	
	
	
}

