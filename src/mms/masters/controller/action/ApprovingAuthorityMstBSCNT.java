package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.ApprovingAuthorityMstDATA;

import mms.masters.controller.fb.ApprovingAuthorityMstFB;
import mms.masters.controller.utl.ApprovingAuthorityMstBSUTL;

/**
 * Developer : Pramod Kumar Mehta 
 * Version : 1.0 
 * Date : 14/April/2009
 *  Module:MMS
 * Unit:Approving Authority Master
 *
 */

/**
 * Developer : Anshul Jindal
 * Version : 1.0
 * Modify Date : 22/May/2009
 * 
 */
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class ApprovingAuthorityMstBSCNT.
 */
public class ApprovingAuthorityMstBSCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget = "";

	/**
	 * Invoke Utl Constructor to bring list page.
	 */
	public ApprovingAuthorityMstBSCNT() {
		super(new ApprovingAuthorityMstBSUTL(),
				"/masters/ApprovingAuthorityMstBSCNT");
	}

	/**
	 * This method is used to forward control to add page.
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
	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
         generateToken(request);
		ApprovingAuthorityMstFB formBean = (ApprovingAuthorityMstFB) form;
		ApprovingAuthorityMstDATA.addUserListValue(request, formBean);

		strtarget = "add";
		return mapping.findForward(strtarget);

	}

	/**
	 * This method is used to insert record in database . For this activity this
	 * method call insert() method of ApprovingAuthorityMstDATA java file
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 */

	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				validateToken(request, response);
		ApprovingAuthorityMstFB formBean = (ApprovingAuthorityMstFB) form;
		ApprovingAuthorityMstDATA.insert(request, formBean);
		// return null;
		return this.ADD(mapping, form, request, response);
	}

	/**
	 * This method is used to forward control to modify page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 */
	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
				generateToken(request);
		ApprovingAuthorityMstFB formBean = (ApprovingAuthorityMstFB) form;
		ApprovingAuthorityMstDATA.modifyRecord(formBean, request);
		strtarget = "modify";
		return mapping.findForward(strtarget);
	}

	/**
	 * This method is used to update record in database . For this activity this
	 * method call updateRecord() method of ApprovingAuthorityMstDATA java file
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 */

	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
          validateToken(request, response);
		boolean retValue = false;

		ApprovingAuthorityMstFB fb = (ApprovingAuthorityMstFB) form;
		retValue = ApprovingAuthorityMstDATA.updateRecord(fb, request);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);

	}
	
	
	/**
	 * This method is used to Populate Left list and right list through Ajax call . 
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 */

	public ActionForward populateList(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		

		
		ApprovingAuthorityMstDATA.populateList(request, response);

		return null;

	}

}
