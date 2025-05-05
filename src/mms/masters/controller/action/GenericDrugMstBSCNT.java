package mms.masters.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;
import mms.masters.controller.data.GenericDrugMstDATA;
import mms.masters.controller.fb.GenericDrugMstFB;
import mms.masters.controller.utl.GenericDrugMstBSUTL;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 */

public class GenericDrugMstBSCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget = "";

	/**
	 * Invoke Util Constructor to bring list page.
	 */
	public GenericDrugMstBSCNT() // Constructor for GenericDrugMstBSCNT
	{
		super(new GenericDrugMstBSUTL(), "/masters/GenericDrugMstBSCNT");
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
         generateToken(request);
		GenericDrugMstFB formBean = (GenericDrugMstFB) form;
        formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		GenericDrugMstDATA.initParamAdd(request, formBean);
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
		GenericDrugMstFB formBean = (GenericDrugMstFB) form;
		GenericDrugMstDATA.insert(request, formBean);
		return mapping.findForward("add");

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
		GenericDrugMstFB formBean = (GenericDrugMstFB) form;
		GenericDrugMstDATA.modify(request, formBean);
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
		GenericDrugMstFB formBean = (GenericDrugMstFB) form;
		retValue = GenericDrugMstDATA.update(request, formBean);
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
		GenericDrugMstFB formBean = (GenericDrugMstFB) form;
		GenericDrugMstDATA.view(request, formBean);
		strtarget = "view";
		return mapping.findForward(strtarget);
	}
	
	
	public ActionForward CLEAR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		GenericDrugMstFB formBean = (GenericDrugMstFB) form;
		//GenericDrugMstDATA.clear(formBean);
		GenericDrugMstDATA.initParamAdd(request, formBean);
		return mapping.findForward("add");

	}

}
