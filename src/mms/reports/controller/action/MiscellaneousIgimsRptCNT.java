package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.MiscellaneousIgimsRptDATA;
import mms.reports.controller.fb.MiscellaneousIgimsRptFB;


	public class MiscellaneousIgimsRptCNT extends DispatchAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		return this.INITDETAIL(mapping, form, request, response);
	}

	public ActionForward INITDETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		System.out.println("---------INITDETAIL---------"); 
		String target = "index";
		MiscellaneousIgimsRptFB formBean = (MiscellaneousIgimsRptFB) form;
		MiscellaneousIgimsRptDATA.setInitDtl(formBean, request);
		return mapping.findForward(target);
	}

	public ActionForward ITEMCATEGORYCOMBO(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MiscellaneousIgimsRptFB formBean = (MiscellaneousIgimsRptFB) form;
		MiscellaneousIgimsRptDATA.setItemCategComboDtl(formBean, request, response);
		return null;
	}

	public ActionForward DRUGNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MiscellaneousIgimsRptFB formBean = (MiscellaneousIgimsRptFB) form;
		MiscellaneousIgimsRptDATA.setDrugNameCombo(formBean, request, response);
		return null;
	}

	public ActionForward EXISTINGBATCH(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		MiscellaneousIgimsRptFB formBean = (MiscellaneousIgimsRptFB) form;
		MiscellaneousIgimsRptDATA.getExistingBatchList(formBean, request, response);
		return null;
	}

	public ActionForward PROGNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MiscellaneousIgimsRptFB formBean = (MiscellaneousIgimsRptFB) form;
		formBean.setStrHospCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		//IssueDetailRptData_NEW.getProgrammeCombo(formBean, request, response);
		return null;
	}
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MiscellaneousIgimsRptFB formBean = (MiscellaneousIgimsRptFB) form;
		formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		MiscellaneousIgimsRptDATA.showReportNew(formBean, request, response);
	}
	

}
