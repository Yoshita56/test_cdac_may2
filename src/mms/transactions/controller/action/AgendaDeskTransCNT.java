/**
 * 
 */
package mms.transactions.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import mms.transactions.controller.data.AgendaDeskCancelTransDATA;
import mms.transactions.controller.utl.AgendaDeskTransUTL;
import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

/**
 * @author Pankaj Kumar Creation Date:- 8-4-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class AgendaDeskTransCNT extends GenericController {
	/*static AgendaDeskTransUTL masterObj = new AgendaDeskTransUTL();

	public AgendaDeskTransCNT() {
		super(masterObj, "/transactions/AgendaDeskTransCNT");
	}*/

	public AgendaDeskTransCNT() {
		super(new AgendaDeskTransUTL(), "/transactions/AgendaDeskTransCNT");
	}
	
	
	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public ActionForward ADD(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/AgendaDeskAddTransCNT.cnt?hmode=ADD");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	public ActionForward CANCEL1(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		AgendaDeskCancelTransDATA.cancelAgenda(_request, _response);
		return unspecified(_mapping,_form, _request, _response);
	}
	/*public ActionForward CANCEL1(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/AgendaDeskCancelTransCNT.cnt?hmode=CANCEL");
		acFwd.setContextRelative(true);
		return acFwd;
	}*/
	
	public ActionForward VIEW(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/AgendaViewTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
}
