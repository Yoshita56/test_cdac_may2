/**
 * 
 */
package mms.transactions.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dossier.transaction.controller.util.LPIssueDeskTransUTL;
import mms.transactions.controller.utl.PODeskTransUTL;
import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskTransBSCNT extends GenericController {
	//static PODeskTransUTL masterObj = new PODeskTransUTL();
	/*
	public PODeskTransCNT() {
		super(masterObj, "/transactions/PODeskTransCNT");
	}*/
	
	public PODeskTransBSCNT() {
		super(new PODeskTransUTL(), "/transactions/PODeskTransBSCNT");
	}
	
	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward GENERATE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		generateToken(_request);
		String[] Temp = _request.getParameterValues("combo");
		String[] arr  = Temp[2].split("\\^");
	    String cmb  = arr[0];
		ActionForward acFwd = new ActionForward();
		//if(!cmb.equals("21")) // B & S PO
			acFwd.setPath("/mms/transactions/PODeskGenerateTransBSCNT.cnt?hmode=GENERATE");
		//else
		//	acFwd.setPath("/mms/transactions/PODeskGenerateTransNewCNT.cnt?hmode=GENERATEITEMWISE");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward POMODIFY(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		generateToken(_request);
		String[] Temp = _request.getParameterValues("combo");
		String[] arr  = Temp[2].split("\\^");
	    String cmb  = arr[0];
		ActionForward acFwd = new ActionForward();
		//if(!cmb.equals("21")) // B & S PO
			acFwd.setPath("/mms/transactions/PODeskGenerateTransBSCNT.cnt?hmode=POMODIFY");
		//else
		//	acFwd.setPath("/mms/transactions/PODeskGenerateTransNewCNT.cnt?hmode=GENERATEITEMWISE");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward SCHEDULE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/PODeskScheduleTransBSCNT.cnt?hmode=SCHEDULE");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward CANCELPO(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/PODeskCancelTransBSCNT.cnt?hmode=CANCELPO");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward VIEW(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		String[] Temp = _request.getParameterValues("combo");
		String[] arr  = Temp[2].split("\\^");
	    String cmb  = arr[0];
		ActionForward acFwd = new ActionForward();
		//if(cmb.equals("87"))
			acFwd.setPath("/mms/transactions/PODeskViewTransBSCNT.cnt?hmode=VIEWPO");
		//else
		//	acFwd.setPath("/mms/transactions/PODeskGenerateTransNewCNT.cnt?hmode=VIEWPO");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward PRINT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/PODeskPrintTransCNT.cnt?hmode=PRINT");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward FINALIZEPO(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		String[] Temp = _request.getParameterValues("combo");
		String[] arr  = Temp[2].split("\\^");
	    String cmb  = arr[0];
		ActionForward acFwd = new ActionForward();
		if(cmb.equals("21")) // B & S PO
			acFwd.setPath("/mms/transactions/PODeskGenerateTransBSCNT.cnt?hmode=FINALIZEPO");
		else
			acFwd.setPath("/mms/transactions/PODeskGenerateTransBSCNT.cnt?hmode=GENERATE");
		acFwd.setContextRelative(true);
		return acFwd;
	}
}
