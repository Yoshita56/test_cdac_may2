package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.ItemWiseConsumptionRptDATA;
import mms.reports.controller.fb.ItemWiseConsumptionRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
/**
 * Developer : Tanvi Sappal
 * Version : 1.0 Date : 17/July/2009
 * Module : MMS 
 */

public class ItemWiseConsumptionRptCNT extends DispatchAction {
	

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
		ItemWiseConsumptionRptFB formBean = (ItemWiseConsumptionRptFB)form;
		ItemWiseConsumptionRptDATA.initialAdd(formBean,request);
		
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
		
			ItemWiseConsumptionRptFB formBean = (ItemWiseConsumptionRptFB)form;
			ItemWiseConsumptionRptDATA.groupName(formBean, request, response);
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
		
			ItemWiseConsumptionRptFB formBean = (ItemWiseConsumptionRptFB)form;
			ItemWiseConsumptionRptDATA.subGroupName(formBean, request, response);
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
		
			ItemWiseConsumptionRptFB formBean = (ItemWiseConsumptionRptFB)form;
			ItemWiseConsumptionRptDATA.itemName(formBean, request, response);
			return null;
	}
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ItemWiseConsumptionRptFB formBean = (ItemWiseConsumptionRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ItemWiseConsumptionRptDATA.showReport(formBean, request, response);
		
		
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

}
