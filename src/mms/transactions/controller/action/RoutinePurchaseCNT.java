package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.RoutinePurchaseDATA;
import mms.transactions.controller.fb.RoutinePurchaseFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class RoutinePurchaseCNT extends DispatchAction{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public RoutinePurchaseCNT()
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
		return this.GO(mapping, form, request, response);
	}
	
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
	public ActionForward GO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		 String strTarget="";
		if(res.getString("INDENT_TYPE").equals("1"))
		{
 		     strTarget = "RequestForRoutinePurchaseJsp";
 		     RoutinePurchaseFB fb = (RoutinePurchaseFB) form;
 			 RoutinePurchaseDATA.GetData(fb, request);
		}
		else
		{
			 strTarget = "RequestForRoutinePurchaseJspWithItem";
			 RoutinePurchaseFB fb = (RoutinePurchaseFB) form;
			 RoutinePurchaseDATA.GetDataWithItem(fb, request);
			 RoutinePurchaseDATA.getFinancialYearCombo(fb, request);
	 	}
		
	    
		return mapping.findForward(strTarget);
	}
	
	
	
	
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
	/*public ActionForward UNITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		RoutinePurchaseFB fb = (RoutinePurchaseFB) form;
	  //  RoutinePurchaseDATA.UNITVAL(fb, request,response);
	   	return null;
	}*/
	
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
	/*public ActionForward UNITVAL1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		
	    RoutinePurchaseFB fb = (RoutinePurchaseFB) form;
	  //  RoutinePurchaseDATA.UNITVAL1(fb, request,response);
	   	return null;
	}*/
	
	/**
	 * forwards control to the ADD page of Trasaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		RoutinePurchaseFB fb = (RoutinePurchaseFB) form;
		boolean retValue = false;	
	   	retValue = RoutinePurchaseDATA.INSERT(fb, request);
	      
	    if (retValue)
	    	return this.GO(mapping, form, request, response);
		else
			return this.GO(mapping, form, request, response);
	   

	}
	
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
	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ResourceBundle res = mms.qryHandler_mms.res;
		if(res == null) 
		{
			res = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			mms.qryHandler_mms.res = res;
		}
		
		 String strTarget="";
		    
	    	String strPath = "/mms"+request.getParameter("cnt_page")+".cnt";
			 strTarget = "ViewRequestForRoutinePurchaseJspWithItem";
			 RoutinePurchaseFB fb = (RoutinePurchaseFB) form;
			 fb.setStrChk(request.getParameter("chk"));
			 fb.setStrChkTmp(request.getParameter("chk"));
			 fb.setStrPath(strPath);
			 RoutinePurchaseDATA.ModifyIndentItemList(fb, request);
		
		
	    
		return mapping.findForward(strTarget);
	}
	/**
	 * forwards control to the ADD page of Trasaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward MODIFYINDENT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		RoutinePurchaseFB fb = (RoutinePurchaseFB) form;
		boolean retValue = false;	
		
		fb.setStrChkTmp(request.getParameter("strChkTmp"));
		//System.out.println("Modify Indet:::"+fb.getStrChkTmp());
	   	retValue = RoutinePurchaseDATA.UPDATE(fb, request);
	      
	    if (retValue)
	    	return this.CANCEL(mapping, form, request, response);
		else
			return this.CANCEL(mapping, form, request, response);
	   

	}
	
	
	
	/**
	 * CANCEL 
	 * is used to forward control to Indent Desk
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
//	public ActionForward CANCEL(ActionMapping _mapping, ActionForm _form,
//			HttpServletRequest request, HttpServletResponse response)
//			throws HisException, SQLException 
//	{
//		ActionForward acFwd = new ActionForward();
//		acFwd.setPath(request.getParameter("strPath"));
//        acFwd.setContextRelative(true);
//        return acFwd;
//        
//    }
	
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
	
}
