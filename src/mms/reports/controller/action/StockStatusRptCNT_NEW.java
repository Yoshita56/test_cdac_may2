/**
 * 
 */
package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.StockStatusRptDATA_NEW;
import mms.reports.controller.fb.StockStatusRptFB_NEW;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0 
 * Date : 21/July/2009
 * Module : MMS 
 */
public class StockStatusRptCNT_NEW extends DispatchAction {
	
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
		String target = "reportPage";
		StockStatusRptFB_NEW formBean = (StockStatusRptFB_NEW)form;
		StockStatusRptDATA_NEW.initialAdd(formBean,request);
		
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
	public ActionForward ITEMCATEGORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
			StockStatusRptFB_NEW formBean = (StockStatusRptFB_NEW)form;
			StockStatusRptDATA_NEW.itemCategory(formBean, request, response);
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
	public ActionForward GROUPNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
			StockStatusRptFB_NEW formBean = (StockStatusRptFB_NEW)form;
			StockStatusRptDATA_NEW.groupName(formBean, request, response);
			return null;
	}
	
	public ActionForward ITEMSTORECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

	
		StockStatusRptFB_NEW formBean = (StockStatusRptFB_NEW) form;
		StockStatusRptDATA_NEW.setStoreComboDtl(formBean, request, response);

	
		return null;

	}
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		StockStatusRptFB_NEW formBean = (StockStatusRptFB_NEW) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		StockStatusRptDATA_NEW.showReport(formBean, request, response);
		
		
	}
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response)
			 {
			  ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/hisglobal/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;
			 }


}
