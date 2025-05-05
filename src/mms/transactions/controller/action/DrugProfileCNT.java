/**
 * 
 */
package mms.transactions.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.DrugProfileDATA;
import mms.transactions.controller.fb.DrugProfileFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author pankaj
 * Date-- 22-Jan-2009
 * Controller Class for Drug Profile Transaction
 * 
 */
public class DrugProfileCNT extends CSRFGardTokenAction {

	public ActionForward unspecified(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		generateToken(_request);
		//saveToken(_request);
		DrugProfileDATA.drugBrandCombo((DrugProfileFB)_form, _request, _response);
		return _mapping.findForward("View");
	}
	
	public ActionForward POPUP(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		DrugProfileDATA.setChkVal((DrugProfileFB)_form, _request);
		return _mapping.findForward("Popup");
	}
	
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd
				.setPath("/mms/transactions/DrugInventoryTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward CANCEL(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward drugProfilePopup(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		saveToken(_request);
		DrugProfileDATA.drugProfilePopup((DrugProfileFB)_form, _request, _response);
		return null;
	}
	
	public ActionForward getStrSubGroupComboValues(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		DrugProfileDATA.getStrSubGroupComboValues((DrugProfileFB)_form, _request, _response);
		return null;
	}
	
	public ActionForward getStrDrugComboValues(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		DrugProfileDATA.getStrDrugComboValues((DrugProfileFB)_form, _request, _response);
		return null;
	}
	
	public ActionForward dosageData(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		DrugProfileDATA.dosageData((DrugProfileFB)_form, _request, _response);
		return null;
	}
	
	public ActionForward saftyData(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		DrugProfileDATA.saftyData((DrugProfileFB)_form, _request, _response);
		return null;
	}

	public ActionForward brandData(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		DrugProfileDATA.brandData((DrugProfileFB)_form, _request, _response);
		return null;
	}
	
	public ActionForward GENERICDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		DrugProfileDATA.genericDtl((DrugProfileFB)_form, _request, _response);
		return null;
	}
	
}
