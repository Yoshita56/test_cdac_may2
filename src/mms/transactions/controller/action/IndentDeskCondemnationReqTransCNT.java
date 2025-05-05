package mms.transactions.controller.action;
/**
 * @author Amit Kumar
 * Date of Creation : 27/4/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.IndentDeskCondemnationReqTransDATA;
import mms.transactions.controller.fb.IndentDeskCondemnationReqTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class IndentDeskCondemnationReqTransCNT extends DispatchAction 
{
	String strtarget;
	/**
	 * FIRSTDATA is used to ge
	 * forwards control to the ADD page of Trasaction.
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
        
		IndentDeskCondemnationReqTransFB fb = (IndentDeskCondemnationReqTransFB) form;
		IndentDeskCondemnationReqTransDATA.GetData(fb,request); 
		strtarget = "condemnationRequest";
		return mapping.findForward(strtarget);

	}
	/**
	 * INSERT method is used to insert data into
	 * table.
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
        
		IndentDeskCondemnationReqTransFB fb = (IndentDeskCondemnationReqTransFB) form;
		boolean retValue = false;	
	   	retValue =  IndentDeskCondemnationReqTransDATA.INSERT(fb, request);
	      
	    if (retValue)
	    	return this.CANCEL(mapping, form, request, response);
		else
			return this.FIRSTDATA(mapping, form, request, response);
		//IndentDeskCondemnationReqTransDATA.INSERT(fb, request); 
	    //return this.CANCEL(mapping, form, request, response);

	}
		
	
	
	/**
	 * Cancel
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
