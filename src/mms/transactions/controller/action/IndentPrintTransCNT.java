package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.IndentPrintTransDATA;
import mms.transactions.controller.fb.IndentPrintTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class IndentPrintTransCNT extends DispatchAction{
	
	public void PRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		IndentPrintTransFB formBean = (IndentPrintTransFB)form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		System.out.println("---------IndentPrintTransCNT.PRINT--------------");
		IndentPrintTransDATA.showReport(formBean, request, response);
		
	}
	

}
