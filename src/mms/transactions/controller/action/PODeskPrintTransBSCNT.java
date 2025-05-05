package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.PODeskPrintTransDATA;
import mms.transactions.controller.fb.PODeskPrintTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class PODeskPrintTransBSCNT extends DispatchAction  {
	
	
	public void PRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		PODeskPrintTransFB formBean = (PODeskPrintTransFB)form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		PODeskPrintTransDATA.showReport(formBean, request, response);
		
	}
	

}
