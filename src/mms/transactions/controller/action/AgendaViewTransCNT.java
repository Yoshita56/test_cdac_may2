package mms.transactions.controller.action;


import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mms.transactions.controller.data.AgendaViewTransDATA;
import mms.transactions.controller.fb.AgendaViewTransFB;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 08/April/2009
 *  Module:MMS
 * Unit:Agenda View
 *
 */


public class AgendaViewTransCNT extends DispatchAction{
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/AgendaDeskTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, Exception {
		return init(mapping, form, request, response);
	}
	
	
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		String strTarget = "index";
		AgendaViewTransFB formBean = (AgendaViewTransFB) form;
		AgendaViewTransDATA.viewData(formBean,request);
		
		return mapping.findForward(strTarget);
	}

}
