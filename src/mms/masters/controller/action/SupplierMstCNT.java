package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.SupplierMstDATA;
import mms.masters.controller.fb.SupplierMstFB;
import mms.masters.controller.utl.SupplierMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/*import purchase.transactions.controller.data.ATDetailsTransDATA;
import purchase.transactions.controller.fb.ATDetailsTransFB;
*/
// TODO: Auto-generated Javadoc
/**
 * The Class SupplierMstCNT.
 */
public class SupplierMstCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget = "";

	/**
	 * Invoke Util Constructor to bring list page.
	 */
	public SupplierMstCNT() {
		super(new SupplierMstUTL(), "/masters/SupplierMstCNT");
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
		SupplierMstFB formBean = (SupplierMstFB) form;
		SupplierMstDATA.initParamAddPage(request, formBean);
		strtarget = "add";
		return mapping.findForward(strtarget);

	}

	/**
	 * is used to invoke SupplierMstDATA insertRecord().
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
				
		SupplierMstFB formBean = (SupplierMstFB) form;
		validateToken(request, response);
		SupplierMstDATA.insert(request, formBean);
		// return mapping.findForward("add");
		return this.ADD(mapping, form, request, response);

	}
	
	
	 /**
	 * MEMATTDTLS.
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
	public ActionForward STATE(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
			
		 SupplierMstFB formBean = (SupplierMstFB) form;
		 SupplierMstDATA.getState(request, response ,formBean);
		 return null;
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
		SupplierMstFB formBean = (SupplierMstFB) form;
		SupplierMstDATA.modify(request, formBean);
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
			SupplierMstFB formBean = (SupplierMstFB) form;
			strtarget = "modify";
			boolean retValue = false;

			retValue = SupplierMstDATA.update(request, formBean);

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
         generateToken(request);
		SupplierMstFB formBean = (SupplierMstFB) form;
		SupplierMstDATA.view(request, formBean);

		strtarget = "view";
		return mapping.findForward(strtarget);
	}

}
