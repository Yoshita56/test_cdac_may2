package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.BillApprovalViewTransDATA;
import mms.transactions.controller.fb.BillApprovalViewTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class BillApprovalViewTransCNT extends DispatchAction {
	/*
	 * Developer : Anurudra Goel
	 * Version : 1.0 
	 * Date : 23/June/2009
	 *  Module:MMS
	 * Unit:Bill Approval View  
	*/
	
	
	public ActionForward BILLAPPROVALVIEW(ActionMapping mapping
			                        ,ActionForm form
			                        ,HttpServletRequest request
			                        ,HttpServletResponse response)throws HisException, SQLException
    {
		String strTarget = "view";
		
		
		BillApprovalViewTransFB formBean = (BillApprovalViewTransFB) form;
		BillApprovalViewTransDATA.viewData(formBean,request);
		return mapping.findForward(strTarget);
	}
	
	
	/**
	 * CANCEL 
	 * is used to forward control to Main Desk
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward MAINPAGE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/BillApprovalDeskTransCNT.cnt?hmode=CANCELPAGE");
        acFwd.setContextRelative(true);
        return acFwd;
        
    }


}
