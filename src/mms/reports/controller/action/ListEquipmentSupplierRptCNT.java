package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.ListEquipmentSupplierRptDATA;
import mms.reports.controller.fb.ListEquipmentSupplierRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ListEquipmentSupplierRptCNT extends DispatchAction{
	
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.INITDETAIL(mapping, form, request, response);
		
	}
	
	public ActionForward INITDETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String target="index";
	//	ListEquipmentSupplierRptFB formBean = (ListEquipmentSupplierRptFB) form;
		return mapping.findForward(target);

	}
	
		public ActionForward SHOWRPT(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {

			ListEquipmentSupplierRptFB formBean = (ListEquipmentSupplierRptFB) form;
			formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			ListEquipmentSupplierRptDATA.showReport(formBean, request, response);
			
			return null;
			
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
