/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 17/July/2009
 *  
*/
package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.CondemnItemDetailRptDATA;
import mms.reports.controller.fb.CondemnItemDetailRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class CondemnItemDetailRptCNT  extends DispatchAction{
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
		CondemnItemDetailRptFB formBean = (CondemnItemDetailRptFB) form;
		CondemnItemDetailRptDATA.setInitDtl(formBean, request);
		return mapping.findForward(target);

	}

		public void SHOWRPT(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {

			CondemnItemDetailRptFB formBean = (CondemnItemDetailRptFB) form;
			formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			CondemnItemDetailRptDATA.showReport(formBean, request, response);
			
			
		}
}
