package mms.transactions.controller.action;

/**
 * Developer : Vivek Aggarwal
 * Version : 1.0
 * Date : 11-Jan-2012
 * Modification Date: 
 *  
*/
import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.IssueSampleForQcCheckTransDATA;
import mms.transactions.controller.data.SampleSentTransDATA;
import mms.transactions.controller.fb.IssueSampleForQcCheckTransFB;
import mms.transactions.controller.fb.SampleSentTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


	public class IssueSampleForQcCheckTransCNT extends DispatchAction
	{
		String strtarget;
	
		/**
		 * Constructor of Class.
		 */
		public IssueSampleForQcCheckTransCNT()
		{
			
		}
		
		 /***********************UNSPECIFIED**************************/
		 
		/**
		 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */ 
		public ActionForward unspecified(ActionMapping mapping
				                        ,ActionForm form
				                        ,HttpServletRequest request
				                        ,HttpServletResponse response)throws HisException, SQLException
	    {
			return this.FIRSTDATA(mapping, form, request, response);
		}
		/**
		 * forwards control to the ADD page of Trasaction.& get
		 * all data which required to show over add page
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		public ActionForward FIRSTDATA(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
	        
			IssueSampleForQcCheckTransFB fb = (IssueSampleForQcCheckTransFB) form;
			IssueSampleForQcCheckTransDATA.GetData(fb, request); 
			strtarget = "initialPage";
			return mapping.findForward(strtarget);
	
		}
		/**
		 * This method  TO BE REMOVED AS IT IS NOT USED
		 * for Indent Issue Transaction.
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		public ActionForward PendingDemandDetails(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
	        
			IssueSampleForQcCheckTransFB formBean = (IssueSampleForQcCheckTransFB) form;
			IssueSampleForQcCheckTransDATA.PendingDemandDetails(request,response,formBean);
			return null;
	
		}
		
		/**
		 * This method used to get Item Category Combo
		 * for Indent Issue Transaction.
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		public ActionForward ItemCatgoryCombo(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
	        
			IssueSampleForQcCheckTransFB formBean = (IssueSampleForQcCheckTransFB) form;
			IssueSampleForQcCheckTransDATA.ItemCatgoryCombo(request,response,formBean);
			return null;
	
		}
		
		
		/**
		 * This method used to get Approved By Combo
		 * for Indent Issue Transaction.
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		public ActionForward ApprovedByCombo(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
	        
			IssueSampleForQcCheckTransFB formBean = (IssueSampleForQcCheckTransFB) form;
			IssueSampleForQcCheckTransDATA.ApprovedByCombo(request,response,formBean);
			return null;
	
		}
		
		/**
		 * This method used to get Approved By Combo
		 * for Indent Issue Transaction.
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		public ActionForward GetPendingIndentDetails(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
	        
			IssueSampleForQcCheckTransFB formBean = (IssueSampleForQcCheckTransFB) form;
			IssueSampleForQcCheckTransDATA.getPendingIndentDetails(request,response,formBean);
			return null;
	
		}
		
		
		
		/**
		 * This method used to get Indent Store Combo
		 * for Indent Issue Transaction.
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		public ActionForward HQNameStoreCombo(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
	        
			IssueSampleForQcCheckTransFB formBean = (IssueSampleForQcCheckTransFB) form;
			IssueSampleForQcCheckTransDATA.getHQNameStoreCombo(request,response,formBean);
			return null;
	
		}
		
		/**
		 * This method used to get Approved and Verified By Combo
		 * for Indent Issue Transaction.
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		public ActionForward ApprovedVerifyCombo(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
	        
			IssueSampleForQcCheckTransFB formBean = (IssueSampleForQcCheckTransFB) form;
			IssueSampleForQcCheckTransDATA.ApprovedVerifyCombo(request,response,formBean);
			return null;
	
		}
		
		
		/**
		 * This method used to get Approved and Verified By Combo
		 * for Indent Issue Transaction.
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		public ActionForward GetStoreBudget(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
	        
			IssueSampleForQcCheckTransFB formBean = (IssueSampleForQcCheckTransFB) form;
			IssueSampleForQcCheckTransDATA.GetStoreBudget(request,response,formBean);
			return null;
	
		}
		
		
		/**
		 * CANCEL method  
		 * forwards control to the LIST  page of Transaction.
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
		{
		    ActionForward acFwd = new ActionForward();
			acFwd.setPath("/hisglobal/initPage.jsp");
			acFwd.setContextRelative(true);
			return acFwd;
		}
		/**
		 * 
		 * forwards control to the View page of this  Transaction.
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		
		public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
		{
			String strTarget="view";
			
			IssueSampleForQcCheckTransFB fb = (IssueSampleForQcCheckTransFB) form;
			IssueSampleForQcCheckTransDATA.initViewPageDtl(fb,request);
			return mapping.findForward(strTarget);
		}
		
		
		/**
		 * To CANCEL Records.
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws SQLException
		 * @throws Exception
		 * @throws SQLException
		 */

		public ActionForward CANCELRECORDS(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{

			saveToken(request);
			IssueSampleForQcCheckTransFB formBean = (IssueSampleForQcCheckTransFB) form;
			formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			IssueSampleForQcCheckTransDATA.cancelRecords(formBean);
			
			return this.VIEWPAGE(mapping, form, request, response);
		}
		
		/**
		 * 
		 * Method is used to get View details after pressing GO button
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		
		public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
		{
				
			IssueSampleForQcCheckTransFB fb = (IssueSampleForQcCheckTransFB) form;
			IssueSampleForQcCheckTransDATA.getViewDtl(fb, request, response);
			return null;
		}
		/** 
		 * This method Issue Item Details. (i.e hyperlink)
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * @throws SQLException
		 */
		public ActionForward GETPOPUP(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception, SQLException {
			////System.out.println("cnt GETPOPUP");
			IssueSampleForQcCheckTransFB formBean = (IssueSampleForQcCheckTransFB) form;
			IssueSampleForQcCheckTransDATA.getPopUp(request, response,formBean);
			return null;
		}
		/** This method use to SAVEEXISTINGDEMAND data
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * @throws SQLException
		 */
		public ActionForward SAVENEWDEMAND(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception, SQLException {
	
			IssueSampleForQcCheckTransFB formBean = (IssueSampleForQcCheckTransFB) form;
			IssueSampleForQcCheckTransDATA.insertIssueSampleForQcCheck( formBean,request);
			return this.FIRSTDATA(mapping, form, request, response);
		}
		
		
		
		
	}
