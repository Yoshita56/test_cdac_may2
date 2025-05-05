package dossier.masters.controller.action;


import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dossier.masters.controller.data.DossierItemBrandMstDATA;
import dossier.masters.controller.data.DossierItemMstDATA;
import dossier.masters.controller.fb.DossierItemBrandMstFB;
import dossier.masters.controller.utl.DossierItemBrandMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


// TODO: Auto-generated Javadoc

public class DossierItemBrandMstCNT extends GenericController {

	/** The strtarget. */
	String strtarget = "";

	/**
	 * Invoke Util Constructor to bring list page.
	 */
	public DossierItemBrandMstCNT() {
		super(new DossierItemBrandMstUTL(), "/masters/DossierItemBrandMstCNT");
	}

	/**
	 * is used to forward control to add page.
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
		// saveToken(request);
		DossierItemBrandMstFB formBean = (DossierItemBrandMstFB) form;
		DossierItemBrandMstDATA.initAdd(request, formBean);
		DossierItemBrandMstDATA.getItemCatValues(formBean, request, response);
		strtarget = "add";
		return mapping.findForward(strtarget);

	}

	/**
	 * is used to forward control to add page.
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
		// saveToken(request);
		DossierItemBrandMstFB formBean = (DossierItemBrandMstFB) form;
		DossierItemBrandMstDATA.insert(formBean, request);
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
		DossierItemBrandMstFB formBean = (DossierItemBrandMstFB) form;
		DossierItemBrandMstDATA.modifyRecord(formBean, request);
		DossierItemBrandMstDATA.getItemCatValues(formBean, request, response);
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
	 * @throws Exception 
	 */
	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
        validateToken(request, response);
		boolean retValue = false;

		DossierItemBrandMstFB formBean = (DossierItemBrandMstFB) form;
		retValue = DossierItemBrandMstDATA.updateRecord(formBean, request);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);
	}

	/**
	 * This function is used to open view page.
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
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		//generateToken(request);
		DossierItemBrandMstFB formBean = (DossierItemBrandMstFB) form;
		DossierItemBrandMstDATA.view(request, formBean);
		strtarget = "view";
		return mapping.findForward(strtarget);
	}
	
}

