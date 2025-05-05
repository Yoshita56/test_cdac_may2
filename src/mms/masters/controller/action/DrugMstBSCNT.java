package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.DrugMstDATA;
import mms.masters.controller.fb.DrugMstFB;
import mms.masters.controller.utl.DrugMstBSUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Jan/2009-May/09
 */

public class DrugMstBSCNT extends GenericController {
	
	/** The strtarget. */
	String strtarget = "";

	/**
	 * Invoke Util Constructor to bring list page.
	 */
	public DrugMstBSCNT() // Constructor for DrugMstBSCNT
	{
		super(new DrugMstBSUTL(), "/masters/DrugMstBSCNT");
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
		DrugMstFB formBean = (DrugMstFB) form;

		DrugMstDATA.initParamAdd(request, formBean);
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
		DrugMstFB formBean = (DrugMstFB) form;
		DrugMstDATA.insert(request, formBean);
		return unspecified(mapping, form, request, response);

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
		DrugMstFB formBean = (DrugMstFB) form;
		DrugMstDATA.modify(request, formBean);
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
		DrugMstFB formBean = (DrugMstFB) form;
		retValue = DrugMstDATA.update(request, formBean);

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
		DrugMstFB formBean = (DrugMstFB) form;
		DrugMstDATA.view(request, formBean);
		strtarget = "view";
		return mapping.findForward(strtarget);
	}
	
	
	public ActionForward getStrMktUnitIdBasedOnItemId(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		DrugMstFB formBean = (DrugMstFB) form;
		
		DrugMstDATA.getStrMktUnitIdBasedOnItemId(formBean,request, response);
		return null;
	}
	
	
	
	/******Method used to delete the record...********/
	
	public ActionForward DELRecord(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		saveToken(request);
		
		String str[]=request.getParameterValues("chk");
		//System.out.println("in the delete method"+" "+str.length+" "+str[0]);
		DrugMstFB fb = (DrugMstFB) form;
		fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DrugMstDATA.checkDATAExists(fb, request.getParameterValues("chk"));
		return this.LIST(mapping, form, request, response);

	}

}
