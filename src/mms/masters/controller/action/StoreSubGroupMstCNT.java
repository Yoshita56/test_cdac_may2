package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.StoreSubGroupMstDATA;
import mms.masters.controller.fb.StoreSubGroupMstFB;
import mms.masters.controller.utl.StoreSubGroupMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreSubGroupMstCNT.
 * 
 * @author Anshul Jindal
 */
public class StoreSubGroupMstCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget = "";

	/**
	 * calls super class constructor.
	 */
	public StoreSubGroupMstCNT() {
		super(new StoreSubGroupMstUTL(), "/masters/StoreSubGroupMstCNT");
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
	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
         generateToken(request);
		StoreSubGroupMstFB fb = (StoreSubGroupMstFB) form;

		StoreSubGroupMstDATA.initialAdd(fb, request);
		strtarget = "add";
		return mapping.findForward(strtarget);

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
        validateToken(request, response);
		StoreSubGroupMstFB fb = (StoreSubGroupMstFB) form;
		StoreSubGroupMstDATA.insertRecord(fb, request);

		return this.ADD(mapping, form, request, response);
	}

	/**
	 * forwards control to the modify page.
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
	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		 generateToken(request);
		StoreSubGroupMstFB fb = (StoreSubGroupMstFB) form;

		StoreSubGroupMstDATA.modifyRecord(fb, request);
		strtarget = "modify";
		return mapping.findForward(strtarget);
	}

	/**
	 * To modify data.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * @throws Exception 
	 */
	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
          validateToken(request, response);
		boolean retValue = false;

		StoreSubGroupMstFB fb = (StoreSubGroupMstFB) form;
		retValue = StoreSubGroupMstDATA.updateRecord(fb, request);

		if (retValue)
		{
			
			return this.LIST(mapping, form, request, response);
			
		}
		else
			return this.MODIFY(mapping, form, request, response);

	}
}
