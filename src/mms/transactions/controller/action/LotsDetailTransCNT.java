/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 1/May/2009
 *  
*/
package mms.transactions.controller.action;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import mms.transactions.controller.data.LotsDetailTransDATA;
import mms.transactions.controller.fb.LotsDetailTransFB;


public class LotsDetailTransCNT  extends DispatchAction
{
	String strtarget;
	
	
	/**
	 * This function is used to 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward LOT_ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		
		LotsDetailTransFB formBean=(LotsDetailTransFB) form;
		LotsDetailTransDATA.initialAdd(formBean, request);
		return mapping.findForward("add"); 
	}
	/*
	 * This function to forward to control to cancel mode(used to cancel Lots)
	 */
	public ActionForward LOT_CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		LotsDetailTransFB formBean=(LotsDetailTransFB) form;
		LotsDetailTransDATA.cancelLots(formBean, request);
		ActionForward afd=new ActionForward();
		afd.setPath("/mms/transactions/LotsDetailTransDeskCNT.cnt?hmode=MOVELISTPAGE");
		afd.setContextRelative(true);
		return afd; 
		
	}
	/**
	 * This function is used to forward control to insert mode.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		LotsDetailTransFB formBean=(LotsDetailTransFB) form;
		LotsDetailTransDATA.insert(formBean, request);
		return LOT_ADD( mapping,  form, request,response); 
	}
	
	/**
	 *This function is used to forward control back to list page 
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
			throws Exception, SQLException {
		
		ActionForward afd=new ActionForward();
		afd.setPath(request.getParameter("strPath"));
		afd.setContextRelative(true);
		return afd; 
	}
	public ActionForward CLEAR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		LotsDetailTransFB formBean=(LotsDetailTransFB) form;
		return this.LOT_ADD(mapping, formBean, request, response);
		
	}
	
}
