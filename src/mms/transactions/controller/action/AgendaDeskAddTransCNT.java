/**
 * 
 */
package mms.transactions.controller.action;

import java.util.ResourceBundle;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.controller.data.AgendaDeskAddTransDATA;
import mms.transactions.controller.fb.AgendaDeskAddTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author Pankaj Kumar Creation Date:- 8-4-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class AgendaDeskAddTransCNT extends DispatchAction  {
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/AgendaDeskTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public ActionForward ADD(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		AgendaDeskAddTransFB agendaFB = (AgendaDeskAddTransFB)_form;
		AgendaDeskAddTransDATA.setToStoreValues(agendaFB, _request);
		AgendaDeskAddTransDATA.setGrantTypeValues(agendaFB, _request);
		
		ResourceBundle resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
		// MmsConfigUtil mmscofigutil = new  MmsConfigUtil();			
		agendaFB.setStrSDFFlgColor("pink");
		return _mapping.findForward("add");
	}

	public ActionForward INDENTDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		AgendaDeskAddTransFB agendaFB = (AgendaDeskAddTransFB)_form;
		AgendaDeskAddTransDATA.getIndentDetails(agendaFB, _request, _response);
		return null;
	}
	
	public ActionForward INDENTITEMDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		AgendaDeskAddTransFB agendaFB = (AgendaDeskAddTransFB)_form;
		AgendaDeskAddTransDATA.getIndentItemDetails(agendaFB, _request, _response);
		return null;
	}
	
	public ActionForward INDENTPOPUPDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		AgendaDeskAddTransFB agendaFB = (AgendaDeskAddTransFB)_form;
		AgendaDeskAddTransDATA.getIndentPopupDetails(agendaFB, _request, _response);
		return null;
	}
	
	public ActionForward INSERT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		AgendaDeskAddTransFB agendaFB = (AgendaDeskAddTransFB)_form;
		AgendaDeskAddTransDATA.insert(agendaFB, _request);
		if(!agendaFB.getStrMsgType().equals("1"))
			return CANCELTODESK(_mapping, _form, _request, _response);
		else
			return ADD(_mapping, _form, _request, _response);
	}
}