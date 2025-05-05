package dossier.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dossier.masters.controller.data.DossierMstDATA;
import dossier.masters.controller.fb.DossierMstFB;
import dossier.masters.controller.utl.DossierMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/*import purchase.transactions.controller.data.ATDetailsTransDATA;
import purchase.transactions.controller.fb.ATDetailsTransFB;
*/
// TODO: Auto-generated Javadoc
/**
 * The Class DossierMstCNT.
 */
public class DossierMstCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget = "";

	/**
	 * Invoke Util Constructor to bring list page.
	 */
	public DossierMstCNT() {
		super(new DossierMstUTL(), "/masters/DossierMstCNT");
	}

	/**Proc_Consultant_Name
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
		DossierMstFB formBean = (DossierMstFB) form;
		DossierMstDATA.initParamAddPage(request, formBean);
		strtarget = "add";
		return mapping.findForward(strtarget);

	}

	/**
	 * is used to invoke DossierMstDATA insertRecord().
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
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
				
		DossierMstFB formBean = (DossierMstFB) form;
		validateToken(request, response);
		DossierMstDATA.insert(request, formBean);
		// return mapping.findForward("add");
		return this.ADD(mapping, form, request, response);

	}
	

	/**
	 * is used to forward control to modify page.
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
		DossierMstFB formBean = (DossierMstFB) form;
		DossierMstDATA.modify(request, formBean);
		strtarget = "modify";
		return mapping.findForward(strtarget);
	}

	/**
	 * invoke updateRecord and then control goes to List page.
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
		{
			validateToken(request, response);
			DossierMstFB formBean = (DossierMstFB) form;
			strtarget = "modify";
			boolean retValue = false;

			retValue = DossierMstDATA.update(request, formBean);

			if (retValue)
				return this.LIST(mapping, form, request, response);
			else
				return this.MODIFY(mapping, form, request, response);

		}
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
		DossierMstFB formBean = (DossierMstFB) form;
		DossierMstDATA.view(request, formBean);

		strtarget = "view";
		return mapping.findForward(strtarget);
	}

}

