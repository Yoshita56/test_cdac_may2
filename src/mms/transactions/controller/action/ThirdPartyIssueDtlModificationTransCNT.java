
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

import mms.transactions.controller.data.ThirdPartyIssueDtlModificationTransDATA;
import mms.transactions.controller.fb.ThirdPartyIssueDtlModificationTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ThirdPartyIssueDtlModificationTransCNT extends DispatchAction
{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public ThirdPartyIssueDtlModificationTransCNT()
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
		ThirdPartyIssueDtlModificationTransFB formBean = (ThirdPartyIssueDtlModificationTransFB) form;
		ThirdPartyIssueDtlModificationTransDATA.insertRecord(formBean, request);

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
        
		ThirdPartyIssueDtlModificationTransFB formBean = (ThirdPartyIssueDtlModificationTransFB) form;
		ThirdPartyIssueDtlModificationTransDATA.IndentingStoreCombo(request,response,formBean);
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
        
		ThirdPartyIssueDtlModificationTransFB formBean = (ThirdPartyIssueDtlModificationTransFB) form;
		ThirdPartyIssueDtlModificationTransDATA.VoucherDetails(request,response,formBean);
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
		
		ThirdPartyIssueDtlModificationTransFB fb = (ThirdPartyIssueDtlModificationTransFB) form;
		ThirdPartyIssueDtlModificationTransDATA.initViewPageDtl(fb,request);
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
			
		ThirdPartyIssueDtlModificationTransFB fb = (ThirdPartyIssueDtlModificationTransFB) form;
		ThirdPartyIssueDtlModificationTransDATA.getVoucherCombo(fb, request, response);
		return null;
	}
	

	public ActionForward getModificationDtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		ThirdPartyIssueDtlModificationTransFB fb = (ThirdPartyIssueDtlModificationTransFB) form;
		ThirdPartyIssueDtlModificationTransDATA.getModificationDtls(fb, request, response);
		return null;
	}
	
	
	
	
	
}
