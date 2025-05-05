package mms.masters.controller.action;

import mms.masters.controller.data.GroupItemAltMstDATA;
import mms.masters.controller.fb.GroupItemAltMstFB;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;

/**
 * The Class ComponentMstCNT.
 * 
 * @author amit kumar ateria
 */
public class GroupItemAltMstBSCNT extends DispatchAction {

	String strtarget = "";
	/**
	 * forwards control to the ADD page.
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

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		return this.ADD(mapping, form, request, response);
	}

	/**
	 * forwards control to the ADD page.
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

	public ActionForward ADD(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		strtarget = "add";
		GroupItemAltMstFB fb = (GroupItemAltMstFB) form;
		GroupItemAltMstDATA.initialAdd(fb, request);
		return mapping.findForward(strtarget);
	}
	/**
	 * gets the existing group.
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

	public ActionForward EXISTGROUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		strtarget = "add";
		GroupItemAltMstFB fb = (GroupItemAltMstFB) form;
		GroupItemAltMstDATA.getExGroup(fb, request,response);
		return null;
	}
	/**
	 * gets the replaced group.
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

	public ActionForward REPLACESUBGROUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		strtarget = "add";
		GroupItemAltMstFB fb = (GroupItemAltMstFB) form;
		GroupItemAltMstDATA.getRpSubGroup(fb, request,response);
		return null;
	}
	/**
	 * gets the existing items
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

	public ActionForward EXISTINGITEMS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		strtarget = "add";
		GroupItemAltMstFB fb = (GroupItemAltMstFB) form;
		GroupItemAltMstDATA.getExItems(fb, request,response);
		return null;
	}

	/**
	 * To add data.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		GroupItemAltMstFB fb = (GroupItemAltMstFB) form;
		GroupItemAltMstDATA.insertRecord(fb, request);
		return this.ADD(mapping, form, request, response);
	}
	/**
	 * cancels the transaction
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws Exception the exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
			{
		ActionForward acFwd = new ActionForward();
		  acFwd.setPath("/hisglobal/initPage.jsp");
		  acFwd.setContextRelative(true);
		  return acFwd;
	}
}