
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.IndentForImportItemsDATA;
import mms.transactions.controller.fb.IndentForImportItemsFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * Developer : Anshul Jindal Version : 1.0 Date : 27/Apr/2009
 * 
 */
public class IndentForImportItemsCNT extends DispatchAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return INIT(mapping, form, request, response);
	}

	/**
	 * This method is used to forward the request on first view jsp page And
	 * calls the methods getInitialValues()
	 * 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * 
	 */
	public ActionForward INIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		String strTarget = "index";
		IndentForImportItemsFB formBean = (IndentForImportItemsFB) form;
		IndentForImportItemsDATA.getInitialValues(formBean, request);
		return mapping.findForward(strTarget);
	}

	/**
	 * To get SUBGROUP AND ITEM NAME COMBO IN THE BASIS OF SELECTED GROUP
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward SUBGROUPANDITEM(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		IndentForImportItemsFB formBean = (IndentForImportItemsFB) form;
		IndentForImportItemsDATA.getSubGroupItemCombo(formBean, request,
				response);
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		return mapping.findForward(null);

	}

	/**
	 * To get ITEM COMBO IN THE BASIS OF SELECTED SUBGROUP
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ITEMNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		IndentForImportItemsFB formBean = (IndentForImportItemsFB) form;
		IndentForImportItemsDATA.getItemCombo(formBean, request, response);
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		return mapping.findForward(null);

	}

	/**
	 * To get BRAND NAME COMBO IN THE BASIS OF SELECTED ITEM
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward BRANDNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		IndentForImportItemsFB formBean = (IndentForImportItemsFB) form;
		IndentForImportItemsDATA.getBrandCombo(formBean, request, response);
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		return mapping.findForward(null);

	}
	
	/**
	 * To get BRAND NAME COMBO IN THE BASIS OF SELECTED ITEM
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward STOCKDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		IndentForImportItemsFB formBean = (IndentForImportItemsFB) form;
		IndentForImportItemsDATA.getStockDtls(formBean, request, response);
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		return mapping.findForward(null);

	}


	/**
	 * To get SUPPLIER ADDRESS IN THE BASIS OF SELECTED SUPPLIER
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward SUPPLIERADDRESS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		IndentForImportItemsFB formBean = (IndentForImportItemsFB) form;
		IndentForImportItemsDATA
				.getSupplierAddress(formBean, request, response);
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		return mapping.findForward(null);

	}

	/**
	 * CANCEL is used to forward control to Indent Desk
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ActionForward acFwd = new ActionForward();
		String strPath = "";
		if(request.getParameter("strPath")!= null)
		{
			strPath = request.getParameter("strPath").concat("?hmode=CANCEL");
			acFwd.setPath(strPath);
	        acFwd.setContextRelative(true);
	        
		}
		return acFwd;
	}

	
	/**
	 * This method is CALL ON save button
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * 
	 */
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		IndentForImportItemsFB formBean = (IndentForImportItemsFB) form;
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		
		boolean retValue = false;	
	   	retValue =  IndentForImportItemsDATA.insertDetails(formBean, request);
	      
	    if (retValue)
	    	return this.INIT(mapping, form, request, response);
		else
			return this.INIT(mapping, form, request, response);
		
		
	}

}
