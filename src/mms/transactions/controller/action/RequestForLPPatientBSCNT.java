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

/**
 * Developer : Amit Kumar
 * Version : 1.0
 * Date : 31/Apr/2009
 * Modif Date : / /2009 
*/
public class RequestForLPPatientBSCNT extends CSRFGardTokenAction
{
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public RequestForLPPatientBSCNT()
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
		generateToken(request);
		
		
		System.out.println("<<------ RequestForLPPatientBSCNT . GO . GetData1  ----[ add_RequestForLPPatientTrans_mmsNew.jsp ]-->>");
		
		String strTarget = "requestForLpPatientJspNew";
		RequestForLPPatientFB fb = (RequestForLPPatientFB) form;
		RequestForLPPatientDATA.GetData(fb, request);
		String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
		
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
		System.out.println("<<------ RequestForLPPatientBSCNT . GO1 . GetData ----[ add_RequestForLPPatientTrans_mmsNew.jsp ]-->>");
		
		String strTarget = "requestForLpPatientJspNew";
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
		validateToken(request, response);
		RequestForLPPatientFB fb = (RequestForLPPatientFB) form;
	    
	    boolean retValue = false;	
	   	retValue = RequestForLPPatientDATA.INSERT(fb, request); 
	      
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
	/*public ActionForward UNITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		RequestForLPPatientFB fb = (RequestForLPPatientFB) form;
	  //  RequestForLPPatientDATA.UNITVAL(fb, request,response);
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
		
	    RequestForLPPatientFB fb = (RequestForLPPatientFB) form;
	  //  RequestForLPPatientDATA.UNITVAL1(fb, request,response);
	   	return null;
	}*/
	
	
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
	
	public ActionForward PLACEREGULARINDENT(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)throws HisException, SQLException, IOException
	{
		String strTarget = "PlaceRegularIndent";
		RequestForLPPatientFB formBean = (RequestForLPPatientFB) form;
		//String[] combo = request.getParameterValues("combo");
		formBean.setStrChk(request.getParameter("chk"));
		//String path = "/mms/transactions/IndentTransCNT.cnt";
		//System.out.println("in RequestForLPPATIENT CNT->PLACEREGULARINDENT");
		//System.out.println("path ++>."+path);
		//formBean.setStrPath(path.trim());
		RequestForLPPatientDATA.placeRegularIndent(formBean,request);
		return mapping.findForward(strTarget);
	}
	
}
