/**
 * 
 */
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.PODeskCancelTransDATA;
import mms.transactions.controller.fb.PODeskCancelTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskCancelTransBSCNT extends CSRFGardTokenAction    {
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/PODeskTransBSCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward CANCELPO(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		generateToken(_request);
		PODeskCancelTransFB poDeskCancelTransFB = (PODeskCancelTransFB)_form;
		PODeskCancelTransDATA.getScheduleDetailsBS(poDeskCancelTransFB, _request);
		return _mapping.findForward("cancel");
	}
	
	public ActionForward INSERT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws Exception {
		validateToken(_request, _response);
		PODeskCancelTransFB poDeskCancelTransFB = (PODeskCancelTransFB)_form;
		PODeskCancelTransDATA.insert(poDeskCancelTransFB, _request);
		return CANCELTODESK(_mapping, _form, _request, _response);
	}
}
