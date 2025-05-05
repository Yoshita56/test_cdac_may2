package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ThirdPartyIssueDeskDATA;
import mms.transactions.controller.fb.ThirdPartyIssueDeskFB;
import mms.transactions.controller.utl.ThirdPartyIssueDeskUTL;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * Developer : Kapil
 * Version : 1.0
 * Date : 23/Jan/2009
 *  
*/
public class ThirdPartyIssueDeskCNT extends GenericController {
	
	public ThirdPartyIssueDeskCNT() {
		super(new ThirdPartyIssueDeskUTL(), "/transactions/ThirdPartyIssueDeskCNT");
	}
	
	/**
	 * This method is used to get the initial page 
	 * on clicking of cancel button.
	 * @param _mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	
	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	
	/**
	 * This method is used to open the page in which 
	 * request is issue to the store name.
	 * @param _mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward REQUEST(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("---------- ThirdPartyIssueDeskCNT.[/mms/transactions/ThirdPartyIssueReqTransCNT.cnt?hmode=REQUEST] -----------------");
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/ThirdPartyIssueReqTransCNT.cnt?hmode=REQUEST");	
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward CANCEL_REQUEST(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		System.out.println("---------- ThirdPartyIssueDeskCNT.[/mms/transactions/ThirdPartyIssueReqTransCNT.cnt?hmode=CANCEL_REQUEST] -----------------");
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/ThirdPartyIssueReqTransCNT.cnt?hmode=CANCEL_REQUEST");	
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward ISSUE(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("---------- ThirdPartyIssueDeskCNT.[/mms/transactions/ThirdPartyIssueSancTransCNT.cnt?hmode=ISSUE] -----------------");

		
		ActionForward acFwd = new ActionForward();
		acFwd
				.setPath("/mms/transactions/ThirdPartyIssueSancTransCNT.cnt?hmode=ISSUE");	
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward VIEW(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		ThirdPartyIssueDeskFB fb = (ThirdPartyIssueDeskFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		ThirdPartyIssueDeskDATA.getData(fb, request);
		
		return _mapping.findForward("view");
	}
	
	public ActionForward CANCELVIEW(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/ThirdPartyIssueDeskCNT.cnt?hmode=unspecified");	
		acFwd.setContextRelative(true);
		return acFwd;
	}
}
