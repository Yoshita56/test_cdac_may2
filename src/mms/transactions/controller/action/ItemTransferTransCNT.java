			/******************************************************************************************
			 *                                Process Name : Item Transfer                            *
			 ******************************************************************************************
			 * File Name       : ItemTransferTransCNT.java                                            *
			 * Module Name     : MMS                                                                  *
			 * Developer       : Deepak Tiwari                                                        * 
			 * Version         : 1.0                                                                  * 
			 * Assigned Date   : 1-May-2009                                                           *                                               
			 * Completion Date : 3-May-2009                                                           *
			 * Assigned By     : Ajay Kr. Gupta                                                       *
			 * Changes Made on : 20-May-2009 , 27-May-2009 , 30-May-2009                              *
			 * Hand over date  : 30-May-2009                                                          *
			 ******************************************************************************************
			 *                    Copyright 2009 CDAC Noida, Inc. All rights reserved.                *
			 ******************************************************************************************/


package mms.transactions.controller.action;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.ItemTransferTransDATA;
import mms.transactions.controller.fb.ItemTransferTransFB;


public class ItemTransferTransCNT  extends CSRFGardTokenAction
{
	String strtarget;
	
	/**
	 * <p>Method::Unspecified is used to Transfer the Control Over Action FIRSTDATA.
	 * @param  <ActionMapping>mapping
	 * @param  <ActionForm>form
	 * @param  <HttpServletRequest>request
	 * @param  <HttpServletResponse>response
	 * @return <ActionForward>target
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward unspecified(ActionMapping mapping
			                        ,ActionForm form
			                        ,HttpServletRequest request
			                        ,HttpServletResponse response)throws HisException, SQLException
    {
		generateToken(request);
		return this.FIRSTDATA(mapping, form, request, response);
	}
	
	/**
	 * <p>Method::FIRSTDATA forwards control to the JSP page of Trasaction.
	 * @param  <ActionMapping>mapping
	 * @param  <ActionForm>form
	 * @param  <HttpServletRequest>request
	 * @param  <HttpServletResponse>response
	 * @return <ActionForward>target
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward FIRSTDATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		generateToken(request);
		ItemTransferTransFB fb = (ItemTransferTransFB) form;
	    ItemTransferTransDATA.GetData(fb, request); 
		strtarget = "transfer";
		return mapping.findForward(strtarget);
	}
	
	
	/**
	 * <p>Method::GRPNAMECOMBO populates Group Name Combo through AJAX
	 * @param  <ActionMapping>mapping
	 * @param  <ActionForm>form
	 * @param  <HttpServletRequest>request
	 * @param  <HttpServletResponse>response
	 * @return <ActionForward>target
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward GRPNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		ItemTransferTransFB formBean = (ItemTransferTransFB) form;
		ItemTransferTransDATA.GRPNAMECOMBO(request,response,formBean);
		return null;

	}
	
	/**
	 * <p>Method::GRPNAMECOMBO populates Group Name Combo through AJAX
	 * @param  <ActionMapping>mapping
	 * @param  <ActionForm>form
	 * @param  <HttpServletRequest>request
	 * @param  <HttpServletResponse>response
	 * @return <ActionForward>target
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward RECEVBYCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		ItemTransferTransFB formBean = (ItemTransferTransFB) form;
		ItemTransferTransDATA.RECEVBYCMB(request,response,formBean);
		return null;

	}
	
	
	/**
	 * <p>Method::ITEMCATCOMBO populates Item Category Combo through AJAX
	 * @param  <ActionMapping>mapping
	 * @param  <ActionForm>form
	 * @param  <HttpServletRequest>request
	 * @param  <HttpServletResponse>response
	 * @return <ActionForward>target
	 * @throws HisException
	 * @throws SQLException
	 */
	 public ActionForward ITEMCATCOMBO(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException 
		{
	        
			ItemTransferTransFB formBean = (ItemTransferTransFB) form;
			ItemTransferTransDATA.ITEMCATCOMBO(request,response,formBean);
			return null;

		}
	 
		
	/**
	 * <p>Method::INSERT is called at the time of  saving the record.
	 * @param  <ActionMapping>mapping
	 * @param  <ActionForm>form
	 * @param  <HttpServletRequest>request
	 * @param  <HttpServletResponse>response
	 * @return <ActionForward>target
	 * @throws Exception 
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
        validateToken(request, response);
		ItemTransferTransFB fb = (ItemTransferTransFB) form;
	    ItemTransferTransDATA.INSERT(fb, request); 
	    return this.FIRSTDATA(mapping, form, request, response);

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
		
		ItemTransferTransFB fb = (ItemTransferTransFB) form;
		ItemTransferTransDATA.initViewPageDtl(fb,request);
		return mapping.findForward(strTarget);
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
	
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		ItemTransferTransFB fb = (ItemTransferTransFB) form;
		ItemTransferTransDATA.getViewDtl(fb, request, response);
		return null;
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
	
	public ActionForward TRANSFERDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
			
		ItemTransferTransFB fb = (ItemTransferTransFB) form;
		ItemTransferTransDATA.getTransferDtl(fb, request, response);
		return null;
	}
	
		
	/**
	 * <p>Method::CANCEL forwards control to the CANCEL page of Transaction.
	 * @param  <ActionMapping>mapping
	 * @param  <ActionForm>form
	 * @param  <HttpServletRequest>request
	 * @param  <HttpServletResponse>response
	 * @return <ActionForward>target
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

}
