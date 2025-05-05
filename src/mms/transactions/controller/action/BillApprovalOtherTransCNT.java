/**
 * 
 */
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.BillApprovalOtherTransDATA;
import mms.transactions.controller.fb.BillApprovalOtherTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


/**
 * Developer : Anshul Jindal 
 * Version : 1.0 Date : 23/June/2009
 * 
 */

public class BillApprovalOtherTransCNT extends DispatchAction{
	
		
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception, SQLException 
	{
		
		return init(mapping,form,request,response);
	}
		
		/** This method is used to forward the request on first view jsp page
		 * And calls the methods getInitialValues() which is define in IssueViewDetailsDATA java file.  
		 * on first page. 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * @throws SQLException
		 * 
		 */
		public ActionForward init(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception, SQLException 
		{
			String path = "";
			String strTarget = "index";
			BillApprovalOtherTransFB formBean = (BillApprovalOtherTransFB) form;
			BillApprovalOtherTransDATA.getPOCombo(formBean,request);
			if(request.getParameter("cnt_page")==null)
			 path=formBean.getStrPath();
			else
			 path = "/mms"+request.getParameter("cnt_page")+".cnt";
			formBean.setStrPath(path.trim());
		
			return mapping.findForward(strTarget);
		}
		
		/** This method is used to get po details
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * @throws SQLException
		 * 
		 */
		public ActionForward GO(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception, SQLException 
		{
			String strTarget = "index";
			BillApprovalOtherTransFB formBean = (BillApprovalOtherTransFB) form;
			BillApprovalOtherTransDATA.getPODetails(formBean,request);
		
			return mapping.findForward(strTarget);
		}
		
		/** This method is used to get po details
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
				throws Exception, SQLException 
		{
			
			BillApprovalOtherTransFB formBean = (BillApprovalOtherTransFB) form;
			BillApprovalOtherTransDATA.insertData(formBean,request);
			return this.unspecified(mapping, form, request, response);
		}
		
		
		/** This method is used to cancel the Process.
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * @throws SQLException
		 */
		
		public ActionForward CANCEL(ActionMapping _mapping, ActionForm _form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
			
			ActionForward acFwd = new ActionForward();
			
			acFwd.setPath(request.getParameter("strPath"));
	        acFwd.setContextRelative(true);
	        return acFwd;
	        
	    }
		

}
