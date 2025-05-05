/**
 * 
 */
package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.ListItemWiseSupplierRptDATA;
import mms.reports.controller.fb.ListItemWiseSupplierRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * @author user
 *
 */
public class ListItemWiseSupplierRptCNT extends DispatchAction {
	
	/**
	 * To display the Item Category Name on the Screen.
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
		String target = "reportPage";
		ListItemWiseSupplierRptFB formBean = (ListItemWiseSupplierRptFB)form;
		ListItemWiseSupplierRptDATA.initialAdd(formBean,request);
		
		return mapping.findForward(target);
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
		
			ListItemWiseSupplierRptFB formBean = (ListItemWiseSupplierRptFB)form;
			ListItemWiseSupplierRptDATA.groupName(formBean, request, response);
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
		
			ListItemWiseSupplierRptFB formBean = (ListItemWiseSupplierRptFB)form;
			ListItemWiseSupplierRptDATA.subGroupName(formBean, request, response);
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
	public ActionForward ITEMNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
			ListItemWiseSupplierRptFB formBean = (ListItemWiseSupplierRptFB)form;
			ListItemWiseSupplierRptDATA.itemName(formBean, request, response);
			return null;
	}
	
	/** This method is used to cancel the Item Location.
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
			   HttpServletRequest request, HttpServletResponse response)
			 {
			  ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/hisglobal/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;
			 }
	public ActionForward back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		String target = "reportPage";
		ListItemWiseSupplierRptFB formBean = (ListItemWiseSupplierRptFB)form;
		ListItemWiseSupplierRptDATA.initialAdd(formBean,request);
		
		return mapping.findForward(target);
	}
	
	public void SHOWRPTNEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ListItemWiseSupplierRptFB formBean = (ListItemWiseSupplierRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ListItemWiseSupplierRptDATA.showReportNew(formBean, request, response);
	}
	
}
