/**
 * Developer : Deepak
 * Version : 1.0
 * Date : 31/Jan/2009
 */
package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.AuthorityHierDtlDATA;
import mms.masters.controller.fb.AuthorityHierDtlFB;
import hisglobal.presentation.CSRFGardTokenAction;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorityHierDtlCNT.
 */
public class AuthorityHierDtlCNT extends CSRFGardTokenAction {
	
	/** The strtarget. */
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public AuthorityHierDtlCNT() {
		// super(new
		// CommitteeMemberDetailMstUTL(),"/masters/CommitteeMemberDetailMstCNT");
	}

	/**
	 * *********************UNSPECIFIED*************************.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */

	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
				generateToken(request);
		return this.FIRSTDATA(mapping, form, request, response);
	}

	/**
	 * forwards control to the ADD page of Trasaction.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward FIRSTDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		AuthorityHierDtlFB fb = (AuthorityHierDtlFB) form;

		AuthorityHierDtlDATA.GetData(fb, request);
		strtarget = "hierDtls";
		return mapping.findForward(strtarget);
	}

	/**
	 * ITEMCATCMB.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		AuthorityHierDtlFB fb = (AuthorityHierDtlFB) form;
		AuthorityHierDtlDATA.ITEMCATCMB(fb, request, response);
		strtarget = "target";
		return mapping.findForward(strtarget);
	}

	/**
	 * REQTYPCMB.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward REQTYPCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		AuthorityHierDtlFB fb = (AuthorityHierDtlFB) form;
		AuthorityHierDtlDATA.REQTYPCMB(fb, request, response);
		strtarget = "target";
		return mapping.findForward(strtarget);
	}

	/**
	 * HIERARCH y_ dtl.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward HIERARCHY_DTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		AuthorityHierDtlFB formBean = (AuthorityHierDtlFB) form;
		AuthorityHierDtlDATA.heirdetails(formBean, request, response);
		return null;
	}

	/**
	 * INSERT.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * @throws Exception 
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
       validateToken(request, response);
		AuthorityHierDtlFB fb = (AuthorityHierDtlFB) form;
		AuthorityHierDtlDATA.INSERT(fb, request);
		return this.FIRSTDATA(mapping, form, request, response);

	}

	/**
	 * forwards control to the CANCEL page of Trasaction.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException 	 * @throws SQLException 	 */

	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	
	/**
	 * Ajax response for getting remarks value..
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward.
	 * 
	 * @throws HisException 	 * @throws SQLException 	 */

	public ActionForward getRemarks(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		AuthorityHierDtlFB formBean = (AuthorityHierDtlFB) form;
		AuthorityHierDtlDATA.getRemarks(formBean, request, response);
		return null;
	}
}
