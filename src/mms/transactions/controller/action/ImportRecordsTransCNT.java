package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ImportRecordsTransDATA;
import mms.transactions.controller.fb.ImportRecordsTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class ImportRecordsTransCNT extends DispatchAction {

	/**
	 * method used to call the import trans initilaization method
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		
		return IMPORTINIT(mapping, form, request, response);
		
	}

	/**
	 * initial method to get start the transaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward IMPORTINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		String strTarget = "importinit";

		ImportRecordsTransFB formBean = (ImportRecordsTransFB) form;
		
		 ImportRecordsTransDATA.getImportTemplateList(request, formBean);
		
		
		return mapping.findForward(strTarget);
	}
	
	/**
	 * import the records by selecting the template and excel sheet (with out header)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward IMPORTRECORDS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		  

		ImportRecordsTransFB formBean = (ImportRecordsTransFB) form;
		
		 ImportRecordsTransDATA.importRecords(request, formBean);
		
		
		return IMPORTINIT(mapping, form, request, response);
	}
	
	
	/**
	 * gets the template details based on tempalte id.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GETTEMPLATEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ImportRecordsTransFB formBean = (ImportRecordsTransFB) form;
	 
		ImportRecordsTransDATA.getParamDtls(request, response , formBean);
		
 
	return null;
	}
	
	/**
	 * clear the page.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward CLEAR(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		 		 
		return this.unspecified(mapping, form, request, response);
		

	}
	
	/**
	 * cancel the process and forward to init page.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
			ActionForward acFwd = new ActionForward();
			acFwd.setPath("/hisglobal/initPage.jsp");
			acFwd.setContextRelative(true);
			return acFwd;
	
}
}
