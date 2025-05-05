package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.InstallationTransDATA;
import mms.transactions.controller.fb.InstallationTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class InstallationTransCNT extends DispatchAction {
	
	/**
	 * To display the Store Name on the Screen.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		InstallationTransFB formBean = (InstallationTransFB)form;
		InstallationTransDATA.initialAdd(formBean,request);

		String target = "add";
		return mapping.findForward(target);
	}
	
	/**
	 * Invoked by Ajax Functions and sets the required Item Category Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ITEMCATEGORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		InstallationTransFB formBean = (InstallationTransFB)form;
		InstallationTransDATA.getItemCatCmb(formBean, request, response);
		return null;
	}
	
	/**
	 * Invoked by Ajax Functions and sets the required group Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		InstallationTransFB formBean = (InstallationTransFB)form;
		InstallationTransDATA.getGroupCmb(formBean, request, response);
		return null;
	}
	
	/**
	 * Invoked by Ajax Functions and sets the required subgroup Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward SUBGROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		InstallationTransFB formBean = (InstallationTransFB)form;
		InstallationTransDATA.getSubGroupCmb(formBean, request, response);
		return null;
	}
	
	/**
	 * Invoked by Ajax Functions and sets the required Generic Item Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GENITEMNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		InstallationTransFB formBean = (InstallationTransFB)form;
		InstallationTransDATA.getGenItemCmb(formBean, request, response);
		return null;
	}
	
	/**
	 * Invoked by Ajax Functions and sets the required Item Name Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ITEMNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		InstallationTransFB formBean = (InstallationTransFB)form;
		InstallationTransDATA.getItemCmb(formBean, request, response);
		return null;
	}
	
	
	/**
	 * Invoked by Ajax Functions and sets the required Batch No.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward BATCHSLNO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		InstallationTransFB formBean = (InstallationTransFB)form;
		InstallationTransDATA.getBatchSerialNo(formBean, request, response);
		return null;
	}
	
	
	/**
	 * This function is used to insert details into database
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		InstallationTransFB formBean = (InstallationTransFB)form;
		InstallationTransDATA.insert(formBean,request);
	
		return this.unspecified(mapping, form, request, response);
	}
	
	/**
	 * To display Item Category Values on the View Page Screen.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
				
		
		////System.out.println("View Page--");
		
		InstallationTransFB formBean = (InstallationTransFB)form;
		InstallationTransDATA.initialAdd(formBean, request);
		String target = "view";
		return mapping.findForward(target);
	}
	
	public ActionForward VIEWITEMGO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
				
		InstallationTransFB formBean = (InstallationTransFB)form;
		InstallationTransDATA.goView(formBean, request);
		String target = "view";
		return mapping.findForward(target);
	}
	
	/** This method is used to cancel the Main Page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response) {
		
			  ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/hisglobal/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;
		}
			 
	
}
