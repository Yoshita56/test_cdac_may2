package mms.transactions.controller.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.RequestForLPPatientDATA;
import mms.transactions.controller.fb.RequestForLPPatientFB;

public class IssueToPatIndentCNT extends CSRFGardTokenAction
{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public IssueToPatIndentCNT()
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
		generateToken(request);
		//return this.GO_NEW(mapping, form, request, response);
		return this.GO(mapping, form, request, response);
	}
	
	/**
	 * GO_NEW Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward GO_NEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println("----------- IssueToPatIndentCNT . GO_NEW  -------[ add_RequestForPatientNewTrans.jsp ]--------");
		
		generateToken(request);
		String strTarget = "identForPatientJsp";
		RequestForLPPatientFB fb = (RequestForLPPatientFB) form;
		RequestForLPPatientDATA.GetData_NEW(fb, request);
		RequestForLPPatientDATA.GetData_NEW_TWO(fb, request);
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
	public ActionForward GO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println("----------- IssueToPatIndentCNT . GO  ---------------");
		
		generateToken(request);
		String strTarget = "identForPatientJsp";
		RequestForLPPatientFB fb = (RequestForLPPatientFB) form;
		RequestForLPPatientDATA.GetData(fb, request);
		if(request.getParameter("strCrNo")!=null)
	    {
	       RequestForLPPatientDATA.GetData1(fb, request);
	    }	
		return mapping.findForward(strTarget);
	}
	
	public ActionForward GO1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println("----------- IssueToPatIndentCNT . GO1  ---------------");
		
		String strTarget = "identForPatientJsp";
		RequestForLPPatientFB fb = (RequestForLPPatientFB) form;
		fb.setStrCrNo("");
		fb.setStrGoFlg("0");
		RequestForLPPatientDATA.GetData(fb, request);
		return mapping.findForward(strTarget);
	}
	
	/**
	 * forwards control to the ADD page of Trasaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
		
		System.out.println("----------- IssueToPatIndentCNT . INSERT  ---------------");
		
		validateToken(request, response);
		RequestForLPPatientFB fb = (RequestForLPPatientFB) form;
	    
	    boolean retValue = false;	
	   	retValue = RequestForLPPatientDATA.INSERT(fb, request); 
	      
	    if (retValue)
	    	return this.GO_NEW(mapping, form, request, response);
		else
			return this.GO_NEW(mapping, form, request, response);
	   

	}
	/**
	 * forwards control to the ADD page of Trasaction.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println("----------- IssueToPatIndentCNT . CANCEL  ---------------");
		
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
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward HOSITALPDIAGNOSIS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException 
	{
		RequestForLPPatientFB formBean = (RequestForLPPatientFB) form;
		RequestForLPPatientDATA.initHosiptalDiagnosis(response, formBean);

		return null;

	}

	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ICDDIAGNOSIS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		RequestForLPPatientFB formBean = (RequestForLPPatientFB) form;
		RequestForLPPatientDATA.initIcdDiagnosis(request,response, formBean);

		return null;

	}
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward PLACEREGULARINDENT(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)throws HisException, SQLException, IOException
	{
		String strTarget = "PlaceRegularIndent";
		RequestForLPPatientFB formBean = (RequestForLPPatientFB) form;
		formBean.setStrChk(request.getParameter("chk"));	
		RequestForLPPatientDATA.placeRegularIndent(formBean,request);
		return mapping.findForward(strTarget);
	}
	
}
