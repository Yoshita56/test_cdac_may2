/**
 * 
 */
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ReturnFromEmployeeTransDATA;
import mms.transactions.controller.fb.ReturnFromEmployeeTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 17/June/2009
 * 
 */
public class ReturnFromEmployeeTransCNT extends DispatchAction {
	 
	 String strTarget = "";
		
		/**
		 * forwards control to the Page return_from_mmstrans.jsp
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return ActionForward object with target
		 * @throws HisException
		 */
		public ActionForward unspecified(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {

			ReturnFromEmployeeTransFB formBean = (ReturnFromEmployeeTransFB)form;
			ReturnFromEmployeeTransDATA.storeName(formBean,request);
			strTarget = "patient";
			return mapping.findForward(strTarget);
			
			
		}
		
			
		/**
		 * Invoked by Ajax Functions and sets the required Item Category Values.
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return ActionForward object with target
		 * @throws HisException
		 */
		public ActionForward ITEMCATEGORY(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {

			ReturnFromEmployeeTransFB formBean = (ReturnFromEmployeeTransFB)form;
			ReturnFromEmployeeTransDATA.itemCategory(formBean,request,response);
			return null;
			
		}
		
		/**
		 * Forwards Control to the Go Function
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */ 
		public ActionForward GO(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
			ReturnFromEmployeeTransFB formBean = (ReturnFromEmployeeTransFB)form;
			
			boolean fRes = ReturnFromEmployeeTransDATA.employeeDetail(formBean, request);
			
			
			if(fRes){
				
				strTarget = "patientGo";
				return mapping.findForward(strTarget);
				
			}else{
				
				return this.unspecified(mapping, formBean, request, response);
			}
			
			
		}
		
		/**
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		public ActionForward ISSUEDETAILS(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {
			ReturnFromEmployeeTransFB formBean = (ReturnFromEmployeeTransFB)form;
			ReturnFromEmployeeTransDATA.getIssueDetails(formBean, request,response);
			/*String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
			formBean.setStrPath(path.trim());*/
			return null;

		}
		
		/**
		 * This function is used to insert details into database
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 */
		public ActionForward INSERT(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {
			ReturnFromEmployeeTransFB formBean = (ReturnFromEmployeeTransFB)form;
			ReturnFromEmployeeTransDATA.insert(formBean,request);
			return this.unspecified(mapping, form, request, response);
		}
		
		/** This method is used to cancel the Return From Patient/Staff page.
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * @throws SQLException
		 */
		public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
				   HttpServletRequest request, HttpServletResponse response)
				 {
				  ActionForward acFwd = new ActionForward();
				  acFwd.setPath("/hisglobal/initPage.jsp");
				  acFwd.setContextRelative(true);
				  return acFwd;
				 }
				 

}
