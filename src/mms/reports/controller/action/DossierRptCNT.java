package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.DossierRptDATA;
import mms.reports.controller.fb.DossierRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
/**
 * Developer : Anshul Jindal
 * Version : 1.0
 * Date : 17/Feb/2013
 *  
*/
public class DossierRptCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		return this.INITDETAIL(mapping, form, request, response);

	}
	/**
	 * this function is used forward control to main  page
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
		public ActionForward INITDETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String target="index";
		DossierRptFB formBean = (DossierRptFB) form;
		DossierRptDATA.setInitDtl(formBean, request);
		return mapping.findForward(target);

	}
		
		/**
		 * this function is used to transfer control to Item category combo
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
	public ActionForward STORECOMBO(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException 
	{
		DossierRptFB formBean = (DossierRptFB) form;
		DossierRptDATA.setStoreCombo(formBean, request, response);
		return null;
	}
		/**
		 * this function is used to transfer control to Item category combo
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
	public ActionForward ITEMCATEGORYCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

	
		DossierRptFB formBean = (DossierRptFB) form;
		DossierRptDATA.setItemCategComboDtl(formBean, request, response);
		return null;

	}
	
	
	
	/**
	 * this function is used to get Drug Name combo
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward DRUGNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
	
	
		DossierRptFB formBean = (DossierRptFB) form;
		DossierRptDATA.setDrugNameCombo(formBean, request, response);
		return null;
	
	}

	
	/**
	 * this function is used to get Drug Name combo
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward EXISTINGBATCH(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
	
	
		DossierRptFB formBean = (DossierRptFB) form;
		DossierRptDATA.getExistingBatchList(formBean, request, response);
		return null;
	
	}
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		DossierRptFB formBean = (DossierRptFB) form;
		formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		DossierRptDATA.showReport(formBean, request, response);
		
		
	}
	public ActionForward CLEAR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		return this.INITDETAIL(mapping, form, request, response);

	}
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response)
			 {
			  ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/hisglobal/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;
			 }
	public ActionForward Back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		return this.INITDETAIL(mapping, form, request, response);

	}
}
