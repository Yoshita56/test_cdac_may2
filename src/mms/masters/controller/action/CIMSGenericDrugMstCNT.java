package mms.masters.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;
import mms.masters.controller.data.CIMSGenericDrugMstDATA;
import mms.masters.controller.fb.CIMSGenericDrugMstFB;
import mms.masters.controller.utl.CIMSGenericDrugMstUTL;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 */

public class CIMSGenericDrugMstCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget = "";

	/**
	 * Invoke Util Constructor to bring list page.
	 */
	public CIMSGenericDrugMstCNT() // Constructor for GenericDrugMstCNT
	{
		super(new CIMSGenericDrugMstUTL(), "/masters/CIMSGenericDrugMstCNT");
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
		saveToken(request);

		CIMSGenericDrugMstFB formBean = (CIMSGenericDrugMstFB) form;
        formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		CIMSGenericDrugMstDATA.initParamAdd(request, formBean);
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
		CIMSGenericDrugMstFB formBean = (CIMSGenericDrugMstFB) form;
		CIMSGenericDrugMstDATA.insert(request, formBean);
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
		CIMSGenericDrugMstFB formBean = (CIMSGenericDrugMstFB) form;
		CIMSGenericDrugMstDATA.modify(request, formBean);
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
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		boolean retValue = false;
		CIMSGenericDrugMstFB formBean = (CIMSGenericDrugMstFB) form;
		retValue = CIMSGenericDrugMstDATA.update(request, formBean);
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
		CIMSGenericDrugMstFB formBean = (CIMSGenericDrugMstFB) form;
		CIMSGenericDrugMstDATA.view(request, formBean);
		strtarget = "view";
		return mapping.findForward(strtarget);
	}
	
	
	public ActionForward CLEAR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		CIMSGenericDrugMstFB formBean = (CIMSGenericDrugMstFB) form;
		//CIMSGenericDrugMstDATA.clear(formBean);
		CIMSGenericDrugMstDATA.initParamAdd(request, formBean);
		return mapping.findForward("add");

	}

}
