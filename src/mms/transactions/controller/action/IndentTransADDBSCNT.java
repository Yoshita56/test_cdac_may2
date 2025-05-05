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

public class IndentTransADDBSCNT extends CSRFGardTokenAction 
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
		String combo[]    = null;
		String catgCode   = "0";
		String reqTypeId  = "0";
		         
		                  
		               
		                  
		generateToken(request);                
		try
		{
			      combo = request.getParameterValues("combo");
			   catgCode = combo[1];     			
			  reqTypeId = combo[2].split("\\^")[1];  			  
			  
			  IndentTransADDFB fb = (IndentTransADDFB) form;
			  IndentTransADDDATA.GetData(fb,request,response); 
			  if(reqTypeId.equals("23"))
			  {
				    System.out.println("----[ "+reqTypeId+" ]------- IndentTransADDBSCNT . FIRSTDATA . NA CERTIFICATE  -------[ add_NAIndentTrans_mms.jsp ]--------");						
				    strtarget = "naCertGene";
			  }
			  else
			  {
				    System.out.println("----[ "+reqTypeId+" ]------- IndentTransADDBSCNT . FIRSTDATA  -------[ add_IndentADDTrans_mmsNew2.jsp ,add_indent_trans_search_row.jsp ]--------");						
					strtarget = "indentTypeAdd";
			  }
			  
			  System.out.println("------IndentTransADDBSCNT . FIRSTDATA-- B ----"+strtarget);	
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return mapping.findForward(strtarget);

	}
	
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
	public ActionForward INDENT_FOR_DEPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{				
		
		String catgCode   = "0";
		String reqTypeId  = "0";
		
		String strStoreName="";
		String strCatgName="";
		String strReqName="";
		String chkValue="";
		         
		if(request.getParameter("chk") != null)
		{
        	chkValue 	= request.getParameter("chk");
        	strStoreName= request.getParameter("strStoreName");
    		strCatgName	= request.getParameter("strCatgName");
    		strReqName	= request.getParameter("strReqName");	    			    			    		
    		System.out.println("chkValue  ------>>"+chkValue);
    		System.out.println("strStoreName  ------>>"+strStoreName);
    		System.out.println("strCatgName  ------>>"+strCatgName);
    		System.out.println("strReqName  ------>>"+strReqName);
		}
                    
		               
		                  
		generateToken(request);                
		try
		{
			  reqTypeId 		  = chkValue.split("\\@")[2];   // Request Type ID
			  
			  if(reqTypeId.equals("23"))
			  {
				    System.out.println("----[ "+reqTypeId+" ]------- IndentTransADDBSCNT . INDENT_FOR_DEPT . NA CERTIFICATE  -------[ add_NAIndentTrans_mms.jsp ]--------");						
				    strtarget = "naCertGene";
			  }
			  else
			  {
				    System.out.println("----[ "+reqTypeId+" ]------- IndentTransADDBSCNT . INDENT_FOR_DEPT  -------[ add_IndentADDTrans_mmsNew.jsp ]--------");						
					strtarget = "indentTypeAdd";
			  }
			  
			  IndentTransADDFB fb = (IndentTransADDFB) form;
			  IndentTransADDDATA.GetData_NEW(fb,request,response); 
  			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
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
	public ActionForward GET_ITEM_DRUG_LIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
        
		IndentTransADDFB formBean = (IndentTransADDFB) form;
		IndentTransADDDATA.GetItemDrugList(request,response,formBean);
		return null;

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
        
        System.out.println("---------- IndentTransADDBSCNT . INSERT  ---------------");
        
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
	 * This Mode use to insert Record in a table.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward INSERT_NEW_FINDER_DATA(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception 
	{
        validateToken(request, response);
        
        System.out.println("---------- IndentTransADDBSCNT . INSERT_NEW_FINDER_DATA  ---------------");
        
		IndentTransADDFB fb = (IndentTransADDFB) form;
		boolean retValue = false;	
	   	retValue =  IndentTransADDDATA.INSERT_NEW_FINDER_DATA(fb, request);
	      
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
		else
		{
			acFwd.setPath("/mms/transactions/IndentTransNEWCNT.cnt?hmode=LIST");
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
		
	
}
