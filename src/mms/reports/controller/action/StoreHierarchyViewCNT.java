package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.StoreHierarchyViewDATA;
import mms.reports.controller.fb.StoreHierarchyViewFB;

public class StoreHierarchyViewCNT extends DispatchAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		    return this.INITDETAIL(mapping, form, request, response);
	}

	public ActionForward INITDETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		String target = "mainPage";
		StoreHierarchyViewFB formBean = (StoreHierarchyViewFB) form;
		StoreHierarchyViewDATA.setInitDtl(formBean, request, response);
		//System.out.println("----formBean.getStrStoreCmb()----"+formBean.getStrStoreCmb());
		//System.out.println("----formBean.getStrItemCategCmb()----"+formBean.getStrItemCategCmb());
		return mapping.findForward(target);
	}

	public ActionForward SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
//		String target = "show";
		StoreHierarchyViewFB formBean = (StoreHierarchyViewFB) form;
		formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		System.out.println("---formBean.getStrStoreId()---"+formBean.getStrStoreId());
		StoreHierarchyViewDATA.showReportNew(formBean, request, response);
//		return mapping.findForward(target);
		return null;
		
	}
	

	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

}

