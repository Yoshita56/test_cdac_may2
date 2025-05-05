/**
 * 
 */
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.AgendaDeskModifyTransDATA;
import mms.transactions.controller.fb.AgendaDeskModifyTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author Pankaj Kumar Creation Date:- 13-4-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class AgendaDeskModifyTransCNT  extends DispatchAction  {
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/AgendaDeskTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public ActionForward MODIFY(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		AgendaDeskModifyTransFB agendaFB = (AgendaDeskModifyTransFB)_form;
		AgendaDeskModifyTransDATA.setFetchedData(agendaFB, _request);
		AgendaDeskModifyTransDATA.setToStoreValues(agendaFB, _request);
		AgendaDeskModifyTransDATA.setItemCatValues(agendaFB, _request);
		return _mapping.findForward("modify");
	}
	
	public ActionForward INDENTDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		AgendaDeskModifyTransFB agendaFB = (AgendaDeskModifyTransFB)_form;
		AgendaDeskModifyTransDATA.getIndentDetails(agendaFB, _request, _response);
		return null;
	}
	
	public ActionForward INSERT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		AgendaDeskModifyTransFB agendaFB = (AgendaDeskModifyTransFB)_form;
		////System.out.println("panak");
		AgendaDeskModifyTransDATA.insert(agendaFB, _request);
		return CANCELTODESK(_mapping, _form, _request, _response);
	}
}
