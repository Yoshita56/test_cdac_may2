package mms.transactions.controller.action;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 16/Sep/2010
 * Modification Date: 
 *  
*/
import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.OfflineIssueIndentTransDATA;
import mms.transactions.controller.fb.OfflineIssueIndentTransFB;
public class OfflineIssueIndentTransCNTNEW extends CSRFGardTokenAction
{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public OfflineIssueIndentTransCNTNEW()
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
		generateToken(request);
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
		System.out.println("------------ OfflineIssueIndentTransCNTNEW. FIRSTDATA -----[ add_OfflineIssueIndentTrans_mmsNEW.jsp , OffLineIssueItemDtlNEW.js]----------");
		 generateToken(request);
		OfflineIssueIndentTransFB fb = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.GetData(fb, request); 
		strtarget = "offLineIssueItemDtl";
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
	public ActionForward PendingDemandDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OfflineIssueIndentTransFB formBean = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.PendingDemandDetails(request,response,formBean);
		return null;

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
        
		OfflineIssueIndentTransFB formBean = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.ItemCatgoryCombo(request,response,formBean);
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
        
		OfflineIssueIndentTransFB formBean = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.ApprovedByCombo(request,response,formBean);
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
	public ActionForward GetPendingIndentDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OfflineIssueIndentTransFB formBean = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.getPendingIndentDetails(request,response,formBean);
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
        
		OfflineIssueIndentTransFB formBean = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.IndentingStoreCombo(request,response,formBean);
		return null;

	}
	
	/**
	 * This method used to get Approved and Verified By Combo
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
        
		OfflineIssueIndentTransFB formBean = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.ApprovedVerifyCombo(request,response,formBean);
		return null;

	}
	
	
	/**
	 * This method used to get Approved and Verified By Combo
	 * for Indent Issue Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GetStoreBudget(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		OfflineIssueIndentTransFB formBean = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.GetStoreBudget(request,response,formBean);
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
		System.out.println("------------ OfflineIssueIndentTransCNTNEW. VIEWPAGE -----[ view_OfflineIssueIndent_mmsNEW.jsp ,OffLineIssueItemDtlNEW.js ]----------");		
		String strTarget="view";		
		OfflineIssueIndentTransFB fb = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.initViewPageDtl(fb,request);
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
			
		OfflineIssueIndentTransFB fb = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.getViewDtlNEW(fb, request, response);
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
		//System.out.println("cnt GETPOPUP");
		OfflineIssueIndentTransFB formBean = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.getPopUp(request, response,formBean);
		return null;
	}
	/** This method use to SAVENEWDEMAND data
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward SAVENEWDEMAND(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		validateToken(request, response);
		OfflineIssueIndentTransFB formBean = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.InsertOffLineforNewDemand( formBean,request);
		return this.FIRSTDATA(mapping, form, request, response);
	}
		
	/** This method use to SAVEEXISTINGDEMAND data
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward  SAVEEXISTINGDEMAND(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		validateToken(request, response);
		OfflineIssueIndentTransFB formBean = (OfflineIssueIndentTransFB) form;
		OfflineIssueIndentTransDATA.InsertOffLineforExistingDemand( formBean,request);
		return this.FIRSTDATA(mapping, form, request, response);
	}
	
}
