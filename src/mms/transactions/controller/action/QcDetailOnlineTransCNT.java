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

import mms.transactions.controller.data.QcDetailOnlineTransDATA;
import mms.transactions.controller.fb.QcDetailOnlineTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


	public class QcDetailOnlineTransCNT extends DispatchAction
	{
		String strtarget;
	
		/**
		 * Constructor of Class.
		 */
		public QcDetailOnlineTransCNT()
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
	        
			QcDetailOnlineTransFB fb = (QcDetailOnlineTransFB) form;
			QcDetailOnlineTransDATA.GetData(fb, request); 
			strtarget = "initialPage";
			return mapping.findForward(strtarget);
	
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
	        
			QcDetailOnlineTransFB formBean = (QcDetailOnlineTransFB) form;
			QcDetailOnlineTransDATA.ItemCatgoryCombo(request,response,formBean);
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
	        
			QcDetailOnlineTransFB formBean = (QcDetailOnlineTransFB) form;
			QcDetailOnlineTransDATA.ApprovedByCombo(request,response,formBean);
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
		public ActionForward LabNameCombo(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
	        
			QcDetailOnlineTransFB formBean = (QcDetailOnlineTransFB) form;
			QcDetailOnlineTransDATA.getLabNameCombo(request,response,formBean);
			return null;
	
		}
		
		/**
		 * 
		 * 
		 * 
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		public ActionForward GETSAMPLESENTDTLS(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {

			QcDetailOnlineTransFB formBean = (QcDetailOnlineTransFB) form;
			QcDetailOnlineTransDATA.getCurrentStockDtls(formBean,request,response);
			
			return null;
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
		public ActionForward GET_SAMPLESENT_DTLS_WITHSEARCHSTRING(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {

			QcDetailOnlineTransFB formBean = (QcDetailOnlineTransFB) form;
			QcDetailOnlineTransDATA.GET_SAMPLESENT_DTLS_WITHSEARCHSTRING(formBean,request,response);
			
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
	        
			QcDetailOnlineTransFB formBean = (QcDetailOnlineTransFB) form;
			QcDetailOnlineTransDATA.ApprovedVerifyCombo(request,response,formBean);
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
			
			QcDetailOnlineTransFB fb = (QcDetailOnlineTransFB) form;
			QcDetailOnlineTransDATA.initViewPageDtl(fb,request);
			return mapping.findForward(strTarget);
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
				
			QcDetailOnlineTransFB fb = (QcDetailOnlineTransFB) form;
			QcDetailOnlineTransDATA.getViewQcOnlineDetail(fb, request, response);
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
			//System.out.println("cnt GETPOPUP");
			QcDetailOnlineTransFB formBean = (QcDetailOnlineTransFB) form;
			QcDetailOnlineTransDATA.getPopUp(request, response,formBean);
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
	
			QcDetailOnlineTransFB formBean = (QcDetailOnlineTransFB) form;
			QcDetailOnlineTransDATA.insertIssueSampleForQcCheck( formBean,request);
			return this.FIRSTDATA(mapping, form, request, response);
		}
			
		/** This method use to SAVE QC Detail
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 * @throws SQLException
		 */
		public ActionForward SAVEQCDETAIL(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws Exception, SQLException {
	
			QcDetailOnlineTransFB formBean = (QcDetailOnlineTransFB) form;
			QcDetailOnlineTransDATA.saveQCDetail( formBean,request);
			return this.FIRSTDATA(mapping, form, request, response);
		}
		
		public ActionForward PRINTSAMPLESENTLABEL(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException 
		{

			QcDetailOnlineTransFB formBean = (QcDetailOnlineTransFB)form;
			QcDetailOnlineTransDATA.printSampleLabelView(formBean, request, response);
			
			return null;
		}
		
		public ActionForward PRINTSAMPLESENTLABELVIEW(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException 
		{

			QcDetailOnlineTransFB formBean = (QcDetailOnlineTransFB)form;
			QcDetailOnlineTransDATA.printSampleLabelViewPrint(formBean, request, response);
			
			return null;
		}
		
		
	}
