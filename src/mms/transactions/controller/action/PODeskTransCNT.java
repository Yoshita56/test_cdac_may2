/**
 * 
 */
package mms.transactions.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;
import mms.transactions.controller.utl.PODeskTransUTL;

/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskTransCNT extends GenericController {
	//static PODeskTransUTL masterObj = new PODeskTransUTL();
	/*
	public PODeskTransCNT() {
		super(masterObj, "/transactions/PODeskTransCNT");
	}*/
	
	public PODeskTransCNT() {
		super(new PODeskTransUTL(), "/transactions/PODeskTransCNT");
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
		System.out.println("GENERATE---->/mms/transactions/PODeskGenerateTransCNT.cnt?hmode=GENERATE");
		//if(!cmb.equals("21")) // B & S PO
			acFwd.setPath("/mms/transactions/PODeskGenerateTransCNT.cnt?hmode=GENERATE");
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
		
		System.out.println("POMODIFY---->/mms/transactions/PODeskGenerateTransCNT.cnt?hmode=POMODIFY");
		
		//if(!cmb.equals("21")) // B & S PO
			acFwd.setPath("/mms/transactions/PODeskGenerateTransCNT.cnt?hmode=POMODIFY");
		//else
		//	acFwd.setPath("/mms/transactions/PODeskGenerateTransNewCNT.cnt?hmode=GENERATEITEMWISE");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward SCHEDULE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		
		System.out.println("SCHEDULE---->/mms/transactions/PODeskScheduleTransCNT.cnt?hmode=SCHEDULE");
		acFwd.setPath("/mms/transactions/PODeskScheduleTransCNT.cnt?hmode=SCHEDULE");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward CANCELPO(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/PODeskCancelTransCNT.cnt?hmode=CANCELPO");
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
		System.out.println("VIEW---->/mms/transactions/PODeskViewTransCNT.cnt?hmode=VIEWPO");
		
			acFwd.setPath("/mms/transactions/PODeskViewTransCNT.cnt?hmode=VIEWPO");
		//else
		//	acFwd.setPath("/mms/transactions/PODeskGenerateTransNewCNT.cnt?hmode=VIEWPO");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward PRINT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		System.out.println("PRINT---->/mms/transactions/PODeskPrintTransCNT.cnt?hmode=PRINT");
		
		_request.setAttribute("Path","PODeskPrintTransCNT.cnt");
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
		{	
			System.out.println("FINALIZEPO---->/mms/transactions/PODeskGenerateTransCNT.cnt?hmode=FINALIZEPO");
			acFwd.setPath("/mms/transactions/PODeskGenerateTransCNT.cnt?hmode=FINALIZEPO");
		}
		else
		{
			System.out.println("FINALIZEPO---->/mms/transactions/PODeskGenerateTransCNT.cnt?hmode=GENERATE");
			
			acFwd.setPath("/mms/transactions/PODeskGenerateTransCNT.cnt?hmode=GENERATE");
		}
		acFwd.setContextRelative(true);
		return acFwd;
	}
}
