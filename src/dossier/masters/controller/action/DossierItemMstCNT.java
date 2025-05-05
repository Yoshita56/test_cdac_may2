package dossier.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dossier.masters.controller.data.DossierItemMstDATA;
import dossier.masters.controller.data.DossierMstDATA;
import dossier.masters.controller.fb.DossierItemMstFB;
import dossier.masters.controller.fb.DossierMstFB;
import dossier.masters.controller.utl.DossierItemMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


//TODO: Auto-generated Javadoc
/**
* The Class DossierItemMstCNT.

*/

public class DossierItemMstCNT extends GenericController {

	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */
	public DossierItemMstCNT() {
		super(new DossierItemMstUTL(), "/masters/DossierItemMstCNT");

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
			DossierItemMstFB formBean = (DossierItemMstFB) form;

			DossierItemMstDATA.initialAdd(formBean, request);// to get CURRENT DATE
			DossierItemMstDATA.getItemCatValues(formBean, request, response);
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
			DossierItemMstFB fb = (DossierItemMstFB) form;
			DossierItemMstDATA.insertRecord(fb, request);

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
			DossierItemMstFB fb = (DossierItemMstFB) form;
			DossierItemMstDATA.modifyRecord(fb, request);
			DossierItemMstDATA.getItemCatValues(fb, request, response);
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

			DossierItemMstFB fb = (DossierItemMstFB) form;
			retValue = DossierItemMstDATA.updateRecord(fb, request);

			if (retValue)
				return this.LIST(mapping, form, request, response);
			else
				return this.MODIFY(mapping, fb, request, response);

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
			DossierItemMstFB formBean = (DossierItemMstFB) form;
			DossierItemMstDATA.view(request, formBean);

			strtarget = "view";
			return mapping.findForward(strtarget);
		}


}
///////////////////////////////////////////////////////////////////////////////////////////////
