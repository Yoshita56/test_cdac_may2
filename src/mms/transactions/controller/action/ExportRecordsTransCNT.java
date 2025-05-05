package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ExportRecordsTransDATA;
import mms.transactions.controller.fb.ExportRecordsTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ExportRecordsTransCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		
		return EXPORTINIT(mapping, form, request, response);
		
	}

	
	public ActionForward EXPORTINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		String strTarget = "exportinit";

		ExportRecordsTransFB formBean = (ExportRecordsTransFB) form;
		
		ExportRecordsTransDATA.getExportTemplateList(request, formBean);
		
		
		return mapping.findForward(strTarget);
	}
	
	public ActionForward EXPORTRECORDS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		  

		ExportRecordsTransFB formBean = (ExportRecordsTransFB) form;
		
		ExportRecordsTransDATA.exportRecords(request, response , formBean);
		
	  
		return null;
	}
	
	
	
	public ActionForward GETTEMPLATEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ExportRecordsTransFB formBean = (ExportRecordsTransFB) form;
	 
		ExportRecordsTransDATA.getParamDtls(request, response , formBean);
		
 
	return null;
	}
	
	public ActionForward CLEAR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		 		 
		return this.unspecified(mapping, form, request, response);
		

	}
	
	
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
			ActionForward acFwd = new ActionForward();
			acFwd.setPath("/hisglobal/initPage.jsp");
			acFwd.setContextRelative(true);
			return acFwd;
	
}
	

}
