/**
 * 
 */
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.PODeskScheduleTransDATA;
import mms.transactions.controller.fb.PODeskScheduleTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskScheduleTransCNT extends DispatchAction    {
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/PODeskTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward SCHEDULE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskScheduleTransFB poDeskScheduleTransFB = (PODeskScheduleTransFB)_form;
		PODeskScheduleTransDATA.getPODetails(poDeskScheduleTransFB, _request);
		return _mapping.findForward("schedule");
	}
	
	public ActionForward POITEMDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskScheduleTransFB poDeskScheduleTransFB = (PODeskScheduleTransFB)_form;
		PODeskScheduleTransDATA.getPOItemDetails(poDeskScheduleTransFB, _request, _response);
		return null;
	}
	
	public ActionForward INSERT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskScheduleTransFB poDeskScheduleTransFB = (PODeskScheduleTransFB)_form;
		PODeskScheduleTransDATA.insert(poDeskScheduleTransFB, _request);
		return CANCELTODESK(_mapping, _form, _request, _response);
	}
}
