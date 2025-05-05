package mms.masters.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;
import mms.masters.controller.data.ShortenURLMstDATA;

import mms.masters.controller.fb.ShortenURLMstFB;

import mms.masters.controller.utl.ShortenURLMstUTL;

/**
 * @author Niharika Srivastava 
 * Date 	: 20-08-10
 * Process 	: Drug Contradiction Master 
 * Module	: MMS 
 * Team Lead: Mr. Ajay Kumar Gupta
 * Description : Controller for Drug Contradiction Master
 */

public class ShortenURLMstCNT extends GenericController {

	/** The strtarget. */
	
	String strTarget;

	/**
	 * Constructor for Action Class calls super class constructor.
	 */
	public ShortenURLMstCNT() {
		super(new ShortenURLMstUTL(), "masters/ShortenURLMstCNT");
	}

	/**
	 * forwards control to the ADD page.
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
	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ShortenURLMstFB formBean = (ShortenURLMstFB) form;
		//ShortenURLMstDATA.initialAdd(formBean, request);
		strTarget = "add";
		return mapping.findForward(strTarget);

	}
	/**
	 * Ajax Action for populating Drug Name Combo
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
	 * @return null
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward DRUGNAMECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ShortenURLMstFB formBean = (ShortenURLMstFB) form;
		ShortenURLMstDATA.getDrugNameCombo(formBean, request, response);

		return null;

	}
	/**
	 * Ajax Action for populating Contradicted Drugs List
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
	 * @return null
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward CONTRADRUGLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ShortenURLMstFB formBean = (ShortenURLMstFB) form;
		ShortenURLMstDATA.getContradictedDrugList(formBean, request,
				response);

		return null;
	}

	/**
	 * To add data.
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
	 * @throws Exception
	 *             the exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		ShortenURLMstFB formBean = (ShortenURLMstFB) form;
		ShortenURLMstDATA.insertRecord(formBean, request);

		return ADD(mapping, form, request, response);

	}

	/**
	 * forwards control to the modify page.
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
	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ShortenURLMstFB formBean = (ShortenURLMstFB) form;
		ShortenURLMstDATA.modifyRecord(formBean, request);
		strTarget = "modify";
		return mapping.findForward(strTarget);
	}

	/**
	 * To update data.
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
	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		boolean retValue = false;

		ShortenURLMstFB formBean = (ShortenURLMstFB) form;
		retValue = ShortenURLMstDATA.updateRecord(formBean, request);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, formBean, request, response);

	}
	
	/**
	 * For View the data from List page using HLP class
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		    ShortenURLMstFB formBean = (ShortenURLMstFB) form;
		    ShortenURLMstDATA.contradicView(formBean,request);
			strTarget = "view";
		    return mapping.findForward(strTarget);
	}

}
