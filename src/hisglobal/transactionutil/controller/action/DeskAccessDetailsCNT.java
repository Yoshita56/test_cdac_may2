package hisglobal.transactionutil.controller.action;

import hisglobal.transactionutil.controller.data.DeskAccessDetailsDATA;
import hisglobal.transactionutil.controller.fb.DeskAccessDetailsFB;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


/**
 * @author Anshul Jindal
 *
 */
public class DeskAccessDetailsCNT extends DispatchAction{
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.actions.DispatchAction#unspecified(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.init(mapping, form, request, response);
	}

	/** This method is used to forward the request on first jsp page
	 * And calls the methods userNameCmb() and deskNameCmb() AND LIST VALUESto display combos 
	 * on first page. 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * 
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException 
	{
		String strTarget = "index";
		DeskAccessDetailsFB formBean = (DeskAccessDetailsFB) form;
		
		DeskAccessDetailsDATA.getInitialValues(formBean,request);
		
		return mapping.findForward(strTarget);
	}

	

	
	/** LEFTMENUNAMES called from ajax function for creating LEFT MENU LIST
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward LEFTMENUNAMES(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		
		DeskAccessDetailsFB formBean = (DeskAccessDetailsFB) form;
		DeskAccessDetailsDATA.getLeftList(formBean, request,response);

		return null;
	}
	
	/** RIGHTMENUNAMES called from ajax function for creating RIGHT MENU LIST
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward RIGHTMENUNAMES(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		DeskAccessDetailsFB formBean = (DeskAccessDetailsFB) form;
		DeskAccessDetailsDATA.getRightList(formBean, request,response);

		return null;
	}
	
	
	/**
	 * To add data.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		
		DeskAccessDetailsFB formBean = (DeskAccessDetailsFB) form;
		DeskAccessDetailsDATA.insertRecord(formBean, request);

		return this.init(mapping, form, request, response);

	}

	
	
}
