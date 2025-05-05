package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.utl.POApprovalDeskUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class POApprovalDeskCNT extends GenericController {
	
	public POApprovalDeskCNT() {
		super(new POApprovalDeskUTL(), "/transactions/POApprovalDeskCNT");
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
		ActionForward acFwd = new ActionForward();
		
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		if(res.getString("PO_GENRATION_TYPE").equals("1"))
		{	
		  acFwd.setPath("/mms/transactions/PODeskGenerateTransCNT.cnt?hmode=GENERATE");
		}
		else
		{	
		  
		  acFwd.setPath("/mms/transactions/PODeskGenerateTransCNT.cnt?hmode=GENERATEITEMWISE");
		}  
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward SCHEDULE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
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
	
	public ActionForward APPROVAL(ActionMapping _mapping, ActionForm _form, HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		
		  
		  acFwd.setPath("/mms/transactions/PODeskGenerateTransCNT.cnt?hmode=APPROVAL");
		 
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	
	public ActionForward REJECT(ActionMapping _mapping, ActionForm _form, HttpServletRequest _request, HttpServletResponse _response)
	throws HisException
	{
		ActionForward acFwd = new ActionForward();
	    acFwd.setPath("/mms/transactions/PODeskCancelTransCNT.cnt?hmode=REJECTPO");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	
	public ActionForward VIEW(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();	
		acFwd.setPath("/mms/transactions/PODeskGenerateTransCNT.cnt?hmode=VIEWAPPROVALPO");
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
}
