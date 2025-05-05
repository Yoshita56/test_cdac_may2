package mms.masters.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.ImportExportTemplateMstDATA;
import mms.masters.controller.fb.ImportExportTemplateMstFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsConfigMstCNT.
 */
public class ImportExportTemplateMstCNT extends DispatchAction {

	 /**
	  * initial method
	  */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		return this.addTemplate(mapping, form, request, response);
	}

	 /**
	  * method used to initialize the add template screen
	  * @param mapping
	  * @param form
	  * @param request
	  * @param response
	  * @return
	  * @throws HisException
	  * @throws SQLException
	  */
	public ActionForward addTemplate(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ImportExportTemplateMstFB formBean = (ImportExportTemplateMstFB) form;
	 
		ImportExportTemplateMstDATA.initMainPage(request, formBean);
		formBean.setStrTemplateType("1");

		String target = "addtemplate";
		return mapping.findForward(target);
	}

	/**
	 * method initialized for the parameter mapping page. 
	 * Once the procedure is selected and excel file path is provided then by clicking next button, this method is invoked.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward PARAMAPPING(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ImportExportTemplateMstFB formBean = (ImportExportTemplateMstFB) form;
				 	
		//if( formBean.getStrTemplateType().equals("1") ){
			
			 
			
				ImportExportTemplateMstDATA.paramMapping(request, formBean);
				
					 
	/*	}else{
			
			ImportExportTemplateMstDATA.paramMapping(request, formBean);
			
		}*/
		
		String target = "parammapping";
		return mapping.findForward(target);
	}
	
	/**
	 * Once the mapping processed is complete then the mapped parameter details are showed in this page (for import).
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward PRESAVEMAPPING(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ImportExportTemplateMstFB formBean = (ImportExportTemplateMstFB) form;
	 
		ImportExportTemplateMstDATA.preSaveMapping(request, formBean);
		

		String target = "savetemplate";
		return mapping.findForward(target);
	}
	
	/**
	 * Once the mapping processed is complete then the mapped parameter details are showed in this page (for export).
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward PREEXPSAVEMAPPING(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ImportExportTemplateMstFB formBean = (ImportExportTemplateMstFB) form;
	 
		ImportExportTemplateMstDATA.preExpSaveMapping(request, formBean);
		

		String target = "savetemplate";
		return mapping.findForward(target);
	}
	
	/**
	 * method used to save the parameter mapping and template details in the corresponding tables.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward SAVEMAPPING(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ImportExportTemplateMstFB formBean = (ImportExportTemplateMstFB) form;
	 
		ImportExportTemplateMstDATA.saveMapping(request, formBean);
		
 
		return this.addTemplate(mapping, form, request, response);
	}
	
	/**
	 * gets the parameter details (for view purpose, when existing template is selected)
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

		ImportExportTemplateMstFB formBean = (ImportExportTemplateMstFB) form;
	 
		ImportExportTemplateMstDATA.getParamDtls(request, response , formBean);
		
 
	return null;
	}
	
	/**
	 * gets the template list for the combo box. (based on template type - Import / Export)
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GETTEMPLATELIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ImportExportTemplateMstFB formBean = (ImportExportTemplateMstFB) form;
	 
		ImportExportTemplateMstDATA.getTemplateList(request, response, formBean);
		
 
	return null;
	}
	
	/**
	 * gets the procedure list based on the template type 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GETPROCLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ImportExportTemplateMstFB formBean = (ImportExportTemplateMstFB) form;
	 
		ImportExportTemplateMstDATA.getProcedureList(request, response, formBean);
		
 
	return null;
	}
	
	/**
	 * deletes the selected template.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward DELETETEMPLATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ImportExportTemplateMstFB formBean = (ImportExportTemplateMstFB) form;
	 
		ImportExportTemplateMstDATA.deleteTemplate(request, formBean);

		ImportExportTemplateMstDATA.initMainPage(request, formBean);
		

		String target = "addtemplate";
		return mapping.findForward(target);
		

	}
/**
 * clears the existing page.
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
	 * cancel the process and forwards to initial page.
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
