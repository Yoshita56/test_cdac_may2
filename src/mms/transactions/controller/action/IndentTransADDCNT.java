package mms.transactions.controller.action;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Amit Kumar
 * Date of Creation : 31/3/2009
 * Date of Modification :  /  / 
 * Version : 1.0
 * Module  : Store
 */
import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.IndentTransADDDATA;
import mms.transactions.controller.fb.IndentTransADDFB;

public class IndentTransADDCNT extends CSRFGardTokenAction 
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
        generateToken(request);
		IndentTransADDFB fb = (IndentTransADDFB) form;
		IndentTransADDDATA.GetData(fb,request,response); 
		System.out.println("----- IndentTransADDCNT --[add_IndentADDTrans_mms.jsp]--- ");
		strtarget = "indentTypeAdd";
		return mapping.findForward(strtarget);

	}
	
	/**
	 * This Mode use to insert Record in a table.
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
		IndentTransADDFB fb = (IndentTransADDFB) form;
		boolean retValue = false;	
	   	retValue =  IndentTransADDDATA.INSERT(fb, request);
	      
	    if (retValue)
	    	return this.FIRSTDATA(mapping, form, request, response);
		else
			return this.FIRSTDATA(mapping, form, request, response);
		
		//IndentTransADDDATA.INSERT(fb, request); 
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

	public ActionForward PLACEREGULARINDENT(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)throws HisException, SQLException, IOException
	{
		String strTarget = "PlaceRegularIndent";
		IndentTransADDFB formBean = (IndentTransADDFB) form;
		//String[] combo = request.getParameterValues("combo");
		formBean.setStrChk(request.getParameter("chk"));
		//String path = "/mms/transactions/IndentTransCNT.cnt";
		
		////System.out.println("path ++>."+path);
		//formBean.setStrPath(path.trim());
		IndentTransADDDATA.placeRegularIndent(formBean,request);
		return mapping.findForward(strTarget);
	}
	/**
	 * ISSUEDTLSINIT - gets the VOUCHER
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */

	public ActionForward ISSUEDTLSINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		IndentTransADDFB formBean = (IndentTransADDFB) form;
	    // System.out.println("check the store id "+formBean.getStrToStoreId());
		//System.out.println("check the Indent id "+formBean.getStrIndentNo());
		IndentTransADDDATA.issueDtlsInit(request, response, formBean);

		return null;
	}
	
	public ActionForward INDENT_NA_CERTIFICATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		IndentTransADDFB formBean = (IndentTransADDFB) form;
	    // System.out.println("check the store id "+formBean.getStrToStoreId());
		//System.out.println("check the Indent id "+formBean.getStrIndentNo());
		IndentTransADDDATA.certificateNA(request, response, formBean);

		return null;
	}
		
		
	
}
