/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 31/Jan/2009
 *  
*/
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.BreakageItemDtlTransDATA;
import mms.transactions.controller.fb.BreakageItemDtlTransFB;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class BreakageItemDtlTransCNT  extends CSRFGardTokenAction
{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public BreakageItemDtlTransCNT()
	{
		//super(new CommitteeMemberDetailMstUTL(),"/masters/CommitteeMemberDetailMstCNT");
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
        generateToken(request);
		BreakageItemDtlTransFB fb = (BreakageItemDtlTransFB) form;
	    BreakageItemDtlTransDATA.GetData(fb, request); 
		strtarget = "breakageItemDtl";
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
        System.out.println("for local purchase");
		BreakageItemDtlTransFB formBean = (BreakageItemDtlTransFB) form;
		BreakageItemDtlTransDATA.ItemCatgoryCombo(request,response,formBean);
		return null;

	}
	/**
	 * This method used to get Group Name Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GRPNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		BreakageItemDtlTransFB formBean = (BreakageItemDtlTransFB) form;
		BreakageItemDtlTransDATA.GRPNAMECOMBO(request,response,formBean);
		return null;

	}
	
	
	/**
	 * INSERT method is used to insert data into
	 * table.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
        validateToken(request, response);
		BreakageItemDtlTransFB fb = (BreakageItemDtlTransFB) form;
	    BreakageItemDtlTransDATA.INSERT(fb, request); 
	    return this.FIRSTDATA(mapping, form, request, response);

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
		
		BreakageItemDtlTransFB fb = (BreakageItemDtlTransFB) form;
		BreakageItemDtlTransDATA.initViewPageDtl(fb,request);
		return mapping.findForward(strTarget);
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
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		BreakageItemDtlTransFB fb = (BreakageItemDtlTransFB) form;
		BreakageItemDtlTransDATA.getViewDtl(fb, request, response);
		return null;
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
        
		BreakageItemDtlTransFB formBean = (BreakageItemDtlTransFB) form;
	
		BreakageItemDtlTransDATA.ApprovedByCombo(request,response,formBean);
		return null;

	}
}
