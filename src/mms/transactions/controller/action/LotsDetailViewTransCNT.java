package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import mms.transactions.controller.data.LotsDtlViewTransDATA;

import mms.transactions.controller.fb.LotsDetailViewTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class LotsDetailViewTransCNT extends  DispatchAction  {
	
	/*
	 * Developer : Anurudra Goel
	
	*/
	/**
	 * Unspecified Method Use to Transfer the Control Over Action viewData.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	
	
	
	
	
	public ActionForward LOTSVIEW(ActionMapping mapping
			                        ,ActionForm form
			                        ,HttpServletRequest request
			                        ,HttpServletResponse response)throws HisException, SQLException
    {
		String strTarget="index";
		//System.out.println("Second");
		LotsDetailViewTransFB formBean = (LotsDetailViewTransFB) form;
		
		LotsDtlViewTransDATA.viewData(formBean, request);
			return mapping.findForward(strTarget);
	}
	/*
	 * 
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		ActionForward afd=new ActionForward();
		afd.setPath("/mms/transactions/LotsDetailTransDeskCNT.cnt?hmode=MOVELISTPAGE");
		afd.setContextRelative(true);
		return afd; 
	}
}
