package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mms.masters.controller.fb.ShortenURLMstFB1;
import mms.masters.controller.utl.ShortenURLMstUTL1;
import mms.masters.controller.data.ShortenURLMstDATA1;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreHierarchyMstCNT.
 * 
 * @author Anshul Jindal
 */
public class ShortenURLMstCNT1 extends GenericController {
	
	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */
	public ShortenURLMstCNT1() {
		super(new ShortenURLMstUTL1(), "masters/ShortenURLMstCNT");

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
		ShortenURLMstFB1 formBean = (ShortenURLMstFB1) form;

		ShortenURLMstDATA1.initialAdd(formBean, request);// to get CURRENT
		// DATE
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
		ShortenURLMstFB1 fb = (ShortenURLMstFB1) form;
		ShortenURLMstDATA1.insertRecord(fb, request);

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
		ShortenURLMstFB1 fb = (ShortenURLMstFB1) form;

		ShortenURLMstDATA1.modifyRecord(fb, request);
		strtarget = "modify";
		return mapping.findForward(strtarget);
	}

	/**
	 * To update data.
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

		ShortenURLMstFB1 fb = (ShortenURLMstFB1) form;
		retValue = ShortenURLMstDATA1.updateRecord(fb, request);
		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);

	}
	
	/**
	 * ASSOCIATEDSTORE called from ajax function for creating unit combo according to
	 * inventory unit Id of selected generic item.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws Exception the exception
	 */
	public ActionForward ASSOCIATEDSTORE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception 
	{

		ShortenURLMstFB1 fb = (ShortenURLMstFB1) form;
		ShortenURLMstDATA1.getAssociatedStore(fb, request, response);

		return null;
	}

}
