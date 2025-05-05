package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.StoreMstDATA;
import mms.masters.controller.fb.StoreMstFB;
import mms.masters.controller.utl.StoreMstBSUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

// TODO: Auto-generated Javadoc
/**
 * Developer : Anshul Jindal Version : 1.0 Date : 31/Dec/2008
 */

public class StoreMstBSCNT extends GenericController {

	/** The strtarget. */
	String strtarget;

	/**
	 * calls super class constructor.
	 */
	public StoreMstBSCNT() {
		super(new StoreMstBSUTL(), "masters/StoreMstBSCNT");

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
		StoreMstFB fb = (StoreMstFB) form;
		StoreMstDATA.initialAdd(fb, request);// to get combo values
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
		StoreMstFB fb = (StoreMstFB) form;
//		strRightDeptReqTypeList
		
//		System.out.println("----strRightRequestTypes---"+fb.getStrRightRequestTypes()[1]);
//		System.out.println("---fb.getStrRightDeptReqTypeList()----"+fb.getStrRightDeptReqTypes()[1]);
		
		StoreMstDATA.insertRecord(fb, request);
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
		StoreMstFB fb = (StoreMstFB) form;
		/*
		 * String strStoreTypeName = request.getParameter("comboValue");
		 * fb.setStrStoreTypeName(strStoreTypeName); StoreMstDATA.initialAdd(fb,
		 * request);// to get combo values
		 */
		StoreMstDATA.modifyRecord(fb, request);
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

		StoreMstFB fb = (StoreMstFB) form;
		//System.out.println("----strRightRequestTypes---"+fb.getStrRightRequestTypes()[0]);
		//System.out.println("---fb.getStrRightDeptReqTypeList()----"+fb.getStrRightDeptReqTypes()[0]);
		retValue = StoreMstDATA.updateRecord(fb, request);

		if (retValue)
			return this.LIST(mapping, form, request, response);
		else
			return this.MODIFY(mapping, form, request, response);

	}

	/**
	 * BLOCKNAME called from ajax function for creating combo of BLOCK NAME.
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
	public ActionForward BLOCKNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		StoreMstFB formBean = (StoreMstFB) form;
		StoreMstDATA.getBlockCombo(formBean, request, response);

		return null;
	}

	/**
	 * FLOORNAME called from ajax function for creating combo for FLOOR NAME.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws Exception the exception
	 */
	public ActionForward FLOORNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {

		StoreMstFB formBean = (StoreMstFB) form;
		StoreMstDATA.getFloorCombo(formBean, request, response);

		return null;
	}

	/**
	 * WARDCOMBO called from ajax function for creating combo for WARD.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws Exception the exception
	 */
	public ActionForward WARDCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {

		StoreMstFB formBean = (StoreMstFB) form;
		StoreMstDATA.getWardCombo(formBean, request, response);

		return null;
	}
	
	/**
	 * WARDCOMBO called from ajax function for creating combo for WARD.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws Exception the exception
	 */
	public ActionForward DISTRICTDWH(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception 
    {

		StoreMstFB formBean = (StoreMstFB) form;
		StoreMstDATA.getDistrictDWHCmb(formBean, request, response);

		return null;
	}
	
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StoreMstFB fb = (StoreMstFB) form;
        fb.setStrViewFlg("1");
		StoreMstDATA.viewRecord(fb, request);// to get combo values
		strtarget = "view";
		return mapping.findForward(strtarget);

	}

}
