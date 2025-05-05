package mms.masters.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;
import mms.masters.controller.data.DrugContradictionMstDATA;
import mms.masters.controller.fb.DrugContradictionMstFB;
import mms.masters.controller.utl.DrugContradictionMstUTL;

/**
 * @author Niharika Srivastava 
 * Date 	: 20-08-10
 * Process 	: Drug Contradiction Master 
 * Module	: MMS 
 * Team Lead: Mr. Ajay Kumar Gupta
 * Description : Controller for Drug Contradiction Master
 */

public class DrugContradictionMstCNT extends GenericController {

	/** The strtarget. */
	
	String strTarget;

	/**
	 * Constructor for Action Class calls super class constructor.
	 */
	public DrugContradictionMstCNT() {
		super(new DrugContradictionMstUTL(), "masters/DrugContradictionMstCNT");
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

		DrugContradictionMstFB formBean = (DrugContradictionMstFB) form;
		DrugContradictionMstDATA.initialAdd(formBean, request);
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

		DrugContradictionMstFB formBean = (DrugContradictionMstFB) form;
		DrugContradictionMstDATA.getDrugNameCombo(formBean, request, response);

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

		DrugContradictionMstFB formBean = (DrugContradictionMstFB) form;
		DrugContradictionMstDATA.getContradictedDrugList(formBean, request,
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

		DrugContradictionMstFB formBean = (DrugContradictionMstFB) form;
		DrugContradictionMstDATA.insertRecord(formBean, request);

		return this.ADD(mapping, form, request, response);

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

		DrugContradictionMstFB formBean = (DrugContradictionMstFB) form;
		DrugContradictionMstDATA.modifyRecord(formBean, request);
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

		DrugContradictionMstFB formBean = (DrugContradictionMstFB) form;
		retValue = DrugContradictionMstDATA.updateRecord(formBean, request);

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

		    DrugContradictionMstFB formBean = (DrugContradictionMstFB) form;
		    DrugContradictionMstDATA.contradicView(formBean,request);
			strTarget = "view";
		    return mapping.findForward(strTarget);
	}

}
