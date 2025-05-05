/**
 * 
 */
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.PODeskViewTransDATA;
import mms.transactions.controller.fb.PODeskViewTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskViewTransCNT extends DispatchAction    {
	
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/PODeskTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward VIEWPO(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskViewTransFB poDeskViewTransFB = (PODeskViewTransFB)_form;
		PODeskViewTransDATA.getScheduleDetailsBS(poDeskViewTransFB, _request);
		return _mapping.findForward("view");
	}
}
