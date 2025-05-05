package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;
import mms.global.controller.MmsDATA;
import mms.global.controller.MmsFB;
import mms.transactions.controller.data.ThirdPartyIssueDeskBSDATA;
import mms.transactions.controller.fb.ThirdPartyIssueDeskFB;
import mms.transactions.controller.utl.ThirdPartyIssueDeskUTL;

/**
 * Developer : Kapil
 * Version : 1.0
 * Date : 23/Jan/2009
 *  
*/
public class ThirdPartyIssueDeskBSCNT extends GenericController {
	
	public ThirdPartyIssueDeskBSCNT() {
		super(new ThirdPartyIssueDeskUTL(), "/transactions/ThirdPartyIssueDeskBSCNT");
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
		System.out.println("---------- ThirdPartyIssueDeskBSCNT.[/mms/transactions/ThirdPartyIssueReqTransBSCNT.cnt?hmode=REQUEST] -----------------");
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/ThirdPartyIssueReqTransBSCNT.cnt?hmode=REQUEST");	
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward CANCEL_REQUEST(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("---------- ThirdPartyIssueDeskBSCNT.[/mms/transactions/ThirdPartyIssueReqTransBSCNT.cnt?hmode=CANCEL_REQUEST] -----------------");
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/ThirdPartyIssueReqTransBSCNT.cnt?hmode=CANCEL_REQUEST");	
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward ISSUE(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("---------- ThirdPartyIssueDeskBSCNT.[/mms/transactions/ThirdPartyIssueSancTransBSCNT.cnt?hmode=ISSUE] -----------------");

		
		ActionForward acFwd = new ActionForward();
		acFwd
				.setPath("/mms/transactions/ThirdPartyIssueSancTransBSCNT.cnt?hmode=ISSUE");	
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward VIEW(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("---------- ThirdPartyIssueDeskBSCNT.VIEW -------[ thirdPartyIssueDeskViewTransNew.jsp ]----------");

		
		ThirdPartyIssueDeskFB fb = (ThirdPartyIssueDeskFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		ThirdPartyIssueDeskBSDATA.getData(fb, request);
		
		return _mapping.findForward("view");
	}
	
	public ActionForward ISSUEDTLSINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		ThirdPartyIssueDeskFB formBean = (ThirdPartyIssueDeskFB) form;
        System.out.println("-----------ThirdPartyIssueDeskBSCNT . ISSUEDTLSINIT [ After Save Issue Voucher ]--------------");
        ThirdPartyIssueDeskBSDATA.issueDtlsInit(request, response, formBean);

		return null;
	}
	
	public ActionForward CANCELVIEW(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/ThirdPartyIssueDeskBSCNT.cnt?hmode=unspecified");	
		acFwd.setContextRelative(true);
		return acFwd;
	}
}
