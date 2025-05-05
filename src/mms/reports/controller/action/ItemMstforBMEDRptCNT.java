package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.ItemMstforBMEDRptDATA;
import mms.reports.controller.fb.ItemMstforBMEDRptFB;
/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
public class ItemMstforBMEDRptCNT extends DispatchAction {
	
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
	 * @throws SQLException*/
		public ActionForward INITDETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String target="index";
		ItemMstforBMEDRptFB formBean = (ItemMstforBMEDRptFB) form;
		ItemMstforBMEDRptDATA.setInitDtl(formBean, request);
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
	public ActionForward ITEMCATEGORYCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

	
		ItemMstforBMEDRptFB formBean = (ItemMstforBMEDRptFB) form;
		ItemMstforBMEDRptDATA.setItemCategComboDtl(formBean, request, response);
		return null;

	}
	
	public ActionForward DRUGNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ItemMstforBMEDRptFB formBean = (ItemMstforBMEDRptFB) form;
		ItemMstforBMEDRptDATA.setDrugNameCombo(formBean, request, response);
		return null;

	}
	
	public void SHOWRPT_OLD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ItemMstforBMEDRptFB formBean = (ItemMstforBMEDRptFB) form;
		formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ItemMstforBMEDRptDATA.showReport_old(formBean, request, response);
		
		
	}
	
	public ActionForward SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		
		System.out.println("--------------------- IssueToPatientDetailRptCNT ------[ SHOWRPT ]----[issueToPatientDetail_printHlp.jsp]-----------------");
		
		String strTarget = "printlp";
		ItemMstforBMEDRptFB formBean = (ItemMstforBMEDRptFB)form;
		formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ItemMstforBMEDRptDATA.showReport(formBean, request, response);
		return mapping.findForward(strTarget);
		
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
