package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.AcknowledgeTransDATA;
import mms.transactions.controller.fb.AcknowledgeTransFB;
import mms.transactions.controller.utl.AcknowledgeTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class AcknowledgeTransBSCNT extends GenericController {
	
	 public AcknowledgeTransBSCNT() 
	    {
	    	super(new AcknowledgeTransUTL(),"/transactions/AcknowledgeTransBSCNT");
	    }

	public ActionForward ACKNOWLEDGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{   
		generateToken(request);
		String strTarget = "acknowledge";
		AcknowledgeTransFB formBean = (AcknowledgeTransFB) form;
			
	   	AcknowledgeTransDATA.getInitialVal(formBean,request);
		
		return mapping.findForward(strTarget);
	}
	
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		String strTarget = "view";
		AcknowledgeTransFB formBean = (AcknowledgeTransFB) form;
		AcknowledgeTransDATA.getViewInitialVal(formBean,request);
		
		return mapping.findForward(strTarget);
	}
	/**
	 * 
	 * forwards control to the View page of this  Transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward TRANSFERDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		AcknowledgeTransFB fb = (AcknowledgeTransFB) form;
		AcknowledgeTransDATA.getTransferDtl(fb, request, response);
		return null;
	}
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		validateToken(request, response);
		AcknowledgeTransFB formBean = (AcknowledgeTransFB) form;
		
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		AcknowledgeTransDATA.insertRecord(formBean,request);
		if(formBean.getStrAckStatus().equals("1") || formBean.getStrReturnStatus().equals("1"))
		{	
			//System.out.println("In the if!");
		 return this.ACKNOWLEDGE1(mapping, formBean, request, response);
		}
		else
		{	
			return this.LIST(mapping, form, request, response);
		}	
		
	}	
	
	public ActionForward ACKNOWLEDGE1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		generateToken(request);
		String strTarget = "acknowledge";
		AcknowledgeTransFB formBean = (AcknowledgeTransFB) form;
		
		//System.out.println("In the Acknowledge1");
			AcknowledgeTransDATA.getInitialVal1(formBean,request);
		
		
		return mapping.findForward(strTarget);
	}
	/**
	 * Cancel
	 * is used to forward control to Indent Desk
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	
	



public ActionForward RETURNTODESK(ActionMapping _mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws HisException {
	return this.LIST(_mapping, form, request, response);
	}
}
