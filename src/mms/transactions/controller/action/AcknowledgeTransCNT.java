package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;
import mms.transactions.controller.data.AcknowledgeTransDATA;
import mms.transactions.controller.fb.AcknowledgeTransFB;
import mms.transactions.controller.utl.AcknowledgeTransUTL;

public class AcknowledgeTransCNT extends GenericController {
	
	 public AcknowledgeTransCNT() 
	    {
	    	super(new AcknowledgeTransUTL(),"/transactions/AcknowledgeTransCNT");
	    }

	public ActionForward ACKNOWLEDGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{   
		generateToken(request);
		String strTarget = "acknowledge";
		
		System.out.println("-------------AcknowledgeTransCNT.ACKNOWLEDGE-[ acknowledge_trans.jsp ,acknowledgeDesk_trans.js , issueDetails_util.js ]-------------");
		
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
		System.out.println("-------------AcknowledgeTransCNT.TRANSFERDTL--------------");
		
		AcknowledgeTransFB fb = (AcknowledgeTransFB) form;
		AcknowledgeTransDATA.getTransferDtl(fb, request, response);
		return null;
	}
	
	/**
	 * ISSUEDTLSINIT - gets the issue details view used for ajax.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ACKVOUCHER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		AcknowledgeTransFB formBean = (AcknowledgeTransFB) form;
        System.out.println("-----------AcknowledgeTransCNT . ACKVOUCHER [ After Save  Acknowledge  Voucher ]--------------");
        AcknowledgeTransDATA.getAckVoucherDtl(request, response, formBean);

		return null;
	}
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		validateToken(request, response);
		AcknowledgeTransFB formBean = (AcknowledgeTransFB) form;
		
		System.out.println("-------------AcknowledgeTransCNT.INSERT--------------");
		
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
		System.out.println("------------- AcknowledgeTransCNT.ACKNOWLEDGE1 --------------");
		
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
