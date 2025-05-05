
package mms.transactions.controller.action;
/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 27//2010
 * Modification Date: 
 *  
*/
import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.IssueDtlModificationTransDATA;
import mms.transactions.controller.fb.IssueDtlModificationTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class IssueDtlModificationTransCNT extends DispatchAction
{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public IssueDtlModificationTransCNT()
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
		return this.VIEWPAGE(mapping, form, request, response);
	}
	
	
	/**
	 * To add data.
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

		//boolean retVal ; 
		IssueDtlModificationTransFB formBean = (IssueDtlModificationTransFB) form;
		IssueDtlModificationTransDATA.insertRecord(formBean, request);

		return this.VIEWPAGE(mapping, form, request, response);
		

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
        
		IssueDtlModificationTransFB formBean = (IssueDtlModificationTransFB) form;
		IssueDtlModificationTransDATA.IndentingStoreCombo(request,response,formBean);
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
	public ActionForward VoucherDetails(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		IssueDtlModificationTransFB formBean = (IssueDtlModificationTransFB) form;
		IssueDtlModificationTransDATA.VoucherDetails(request,response,formBean);
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
		String strTarget="main";
		
		IssueDtlModificationTransFB fb = (IssueDtlModificationTransFB) form;
		IssueDtlModificationTransDATA.initViewPageDtl(fb,request);
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
	
	public ActionForward GETVOUCHERCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		IssueDtlModificationTransFB fb = (IssueDtlModificationTransFB) form;
		IssueDtlModificationTransDATA.getVoucherCombo(fb, request, response);
		return null;
	}
	

	public ActionForward getModificationDtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		IssueDtlModificationTransFB fb = (IssueDtlModificationTransFB) form;
		IssueDtlModificationTransDATA.getModificationDtls(fb, request, response);
		return null;
	}
	
	
	
	
	
}
