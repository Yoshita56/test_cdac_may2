package mms.masters.controller.action;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mms.masters.controller.data.ProcessLetterTypeMstDATA;
import mms.masters.controller.fb.ProcessLetterTypeMstFB;
import mms.masters.controller.utl.ProcessLetterTypeMstUTL;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessLetterTypeMstCNT.
 * 
 * @author Tanvi Sappal
 */
public class ProcessLetterTypeMstCNT extends GenericController {

	/** The strtarget. */
	String strtarget = "";

	/**
	 * calls super class constructor.
	 */
	public ProcessLetterTypeMstCNT() // Constructor for LetterTypeMstCNT
	{
		super(new ProcessLetterTypeMstUTL(), "/masters/ProcessLetterTypeMstCNT");
	}

	/**
	 * Forwards Control to the ADD Page.
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
		ProcessLetterTypeMstFB formBean = (ProcessLetterTypeMstFB) form;

		ProcessLetterTypeMstDATA.initialAdd(formBean, request);// to display
																// the Store
																// Type
		// Name on next page
		// according to the selected

		strtarget = "add";
		return mapping.findForward(strtarget);
	}

	/**
	 * To Save Data in Database & return Control Back to List Page.
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
		ProcessLetterTypeMstFB formBean = (ProcessLetterTypeMstFB) form;
		ProcessLetterTypeMstDATA.insertRecord(formBean, request);

		/*
		 * strtarget = "add"; return mapping.findForward(strtarget);
		 */
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

		ProcessLetterTypeMstFB formBean = (ProcessLetterTypeMstFB) form;
		ProcessLetterTypeMstDATA.modifyRecord(formBean, request);
		strtarget = "modify";
		return mapping.findForward(strtarget);
	}

	/**
	 * To Update data.
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
	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		boolean retValue = false;
		ProcessLetterTypeMstFB formBean = (ProcessLetterTypeMstFB) form;

		retValue = ProcessLetterTypeMstDATA.updateRecord(formBean, request);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);
	}

	/**
	 * Invoked by Ajax Functions and sets the required Left Letter Name Values.
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
	public ActionForward LEFTLETTERNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ProcessLetterTypeMstFB formBean = (ProcessLetterTypeMstFB) form;
		ProcessLetterTypeMstDATA.getLeftList(formBean, request, response);

		return null;
	}

	/**
	 * Invoked by Ajax Functions and sets the required Right Letter Name Values.
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
	public ActionForward RIGHTLETTERNAME(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		ProcessLetterTypeMstFB formBean = (ProcessLetterTypeMstFB) form;
		ProcessLetterTypeMstDATA.getRightList(formBean, request, response);

		return null;
	}
}
