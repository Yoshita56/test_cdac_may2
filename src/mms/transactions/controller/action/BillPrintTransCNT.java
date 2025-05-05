package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.BillPrintTransDATA;
import mms.transactions.controller.fb.BillPrintTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class BillPrintTransCNT extends DispatchAction{
	
	public void PRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		System.out.println(" --------------- BillPrintTransCNT.PRINT ----------------- ");
		
		BillPrintTransFB formBean = (BillPrintTransFB)form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BillPrintTransDATA.showReport(formBean, request, response);
		
	}
	

}
