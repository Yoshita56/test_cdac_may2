/**
 * 
 */
package mms.transactions.controller.action;

import java.sql.SQLException;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.*;
import org.apache.struts.actions.DispatchAction;

import mms.transactions.controller.data.SerialNoGenerationTransDATA;
import mms.transactions.controller.fb.SerialNoGenerationTransFB;

/**
 * @author Niharika Srivastava 
 * Date Of Creation : 15-Sep-2010 
 * Team Lead : Mr. Ajay Kumar Gupta 
 * Module : MMS 
 * Process : Serial No Generation Transaction
 * Description : Action Class (Controller) for Serial No Generation Transaction
 * Version : 1.0
 * Last Modified By :-- 
 * Last Modification Date :--
 */

public class SerialNoGenerationTransCNT extends DispatchAction{
	String strTarget = "";
	
	/**
	 * Forwards Control to Initial Page For Serial No Generation.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * 
	 */
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		return this.INIT(mapping, form, request, response);
	}
	/**
	 * Forwards to Initial Page For Serial No Generation.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * 
	 */

	public ActionForward INIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		SerialNoGenerationTransFB formBean = (SerialNoGenerationTransFB)form;
		SerialNoGenerationTransDATA.initialData(formBean,request);
		strTarget = "initialPage";
		return mapping.findForward(strTarget);
	}
	
	/**
	 * Invoked by Ajax Functions and sets the Item Category Combo.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * 
	 */
	
	public ActionForward GETITEMCATLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		SerialNoGenerationTransFB formBean = (SerialNoGenerationTransFB)form;
		SerialNoGenerationTransDATA.getCategoryList(formBean, request, response);
		
		return null;
	}
	
	/**
	 * Invoked by Ajax Functions and sets the Item Name Combo.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * 
	 */
	
	public ActionForward GETITEMNAMELIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		SerialNoGenerationTransFB formBean = (SerialNoGenerationTransFB)form;
		SerialNoGenerationTransDATA.getItemName(formBean, request, response);
		
		return null;
	}
	/**
	 * Forwards Control To Reprint Page
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * 
	 */
	
	public ActionForward REPRINTPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		SerialNoGenerationTransFB formBean = (SerialNoGenerationTransFB)form;
		SerialNoGenerationTransDATA.initialRePrint(formBean,request);
		strTarget = "rePrint";
		return mapping.findForward(strTarget);
	}
	
	/**
	 * Invoked by Ajax Functions and sets the Report Name Combo.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * 
	 */

	public ActionForward GETREPORTNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws HisException {
		
		SerialNoGenerationTransFB formBean = (SerialNoGenerationTransFB)form;
		SerialNoGenerationTransDATA.getReportNameList(formBean, request, response);
		
		return null;
		
	}
	/**
	 * CANCEL method  
	 * Cancel out the current Transaction Page & forwards Control to init page
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
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
