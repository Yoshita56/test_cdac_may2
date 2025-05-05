package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import hisglobal.exceptions.HisException;
import mms.reports.controller.data.NewConsLedgerRptData;
import mms.reports.controller.fb.NewConsLedgerRptFB;
import mms.reports.controller.fb.NewDietCompilationTransFB;


public class NewDietCompilationTransCNT extends DispatchAction{
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		return this.INITDETAIL(mapping, form, request, response);
	

}
	
	public ActionForward INITDETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String target="index";
		NewDietCompilationTransFB formBean = (NewDietCompilationTransFB) form;
	//	NewConsLedgerRptData.setInitDtl(formBean, request);
		return mapping.findForward(target);

	}
	
}
