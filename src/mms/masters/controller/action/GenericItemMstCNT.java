package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.GenericItemMstDATA;
import mms.masters.controller.fb.GenericItemMstFB;
import mms.masters.controller.utl.GenericItemMstUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * Developer : Pankaj
 * Version : 1.0
 * Date : 7/Jan/2009
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 * 
 */

public class GenericItemMstCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget = "";

	/**
	 * Invoke Util Constructor to bring list page.
	 */
	public GenericItemMstCNT() {
		super(new GenericItemMstUTL(), "/masters/GenericItemMstCNT");
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
		//saveToken(request);
		GenericItemMstFB formBean = (GenericItemMstFB) form;
		formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		GenericItemMstDATA.initParamAdd(request, formBean);
		strtarget = "add";
		return mapping.findForward(strtarget);

	}

	/**
	 * INSERT.
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
		 validateToken(request, response);
		GenericItemMstFB formBean = (GenericItemMstFB) form;
		GenericItemMstDATA.insert(request, formBean);
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
		GenericItemMstFB formBean = (GenericItemMstFB) form;
		GenericItemMstDATA.modify(request, formBean);
		strtarget = "modify";
		return mapping.findForward(strtarget);
	}

	/**
	 * UPDATE.
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
		GenericItemMstFB formBean = (GenericItemMstFB) form;

		retValue = GenericItemMstDATA.update(request, formBean);

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
		generateToken(request);
		GenericItemMstFB formBean = (GenericItemMstFB) form;
		GenericItemMstDATA.view(request, formBean);
		strtarget = "view";
		return mapping.findForward(strtarget);
	}

	/**
	 * (ADDED BY ANSHUL) This function is used to get ITEM TYPE COMBO VALUES ON
	 * THE BASIS OF ITEM CATEGORY (BY AJAX).
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
	/*
	 * public ActionForward GETITEMTYPECOMBO(ActionMapping mapping, ActionForm
	 * form, HttpServletRequest request, HttpServletResponse response) throws
	 * HisException, SQLException { GenericItemMstFB formBean =
	 * (GenericItemMstFB) form; GenericItemMstDATA.getItemTypeCombo(formBean,
	 * request, response);
	 * 
	 * return null;
	 *  }
	 */

	/**
	 * (ADDED BY ANSHUL) This function is used to get INVENTORY UNIT COMBO
	 * VALUES ON THE BASIS OF CONSUMABLE TYPE (BY AJAX)
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GETINVENTORYUNITCOMBO(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		GenericItemMstFB formBean = (GenericItemMstFB) form;
		GenericItemMstDATA.getInventoryUnitCombo(formBean, request, response);

		return null;

	}

}
