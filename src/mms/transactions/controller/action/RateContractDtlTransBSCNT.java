/**
 * 
 */
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.RateContractDtlTransDATA;
import mms.transactions.controller.fb.RateContractDtlTransFB;
import mms.transactions.controller.utl.RateContractDtlTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
/**
 * Developer : Anshul Jindal
 * Version : 1.0
 * Date :05/June/2009
 *  
*/
/**
 * Developer : Anshul Jindal
 * Version : 1.0
 * Date : 29/Jan/2009
 *  
*/

public class RateContractDtlTransBSCNT extends GenericController {

	String strtarget;

	/**
	 * calls super class constructor.
	 */
	public RateContractDtlTransBSCNT() {
		super(new RateContractDtlTransUTL(),
				"/transactions/RateContractDtlTransBSCNT");
	}

	/**
	 * forwards control to the ADD page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
         generateToken(request);
		RateContractDtlTransFB formBean = (RateContractDtlTransFB) form;
	
		RateContractDtlTransDATA.initialAdd(formBean, request);// to get
		// CURRENT DATE and item category combo
		strtarget = "add";
		return mapping.findForward(strtarget);

	}
	
	/**
	 * forwards control to the ADD page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward RENEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
         generateToken(request);
		RateContractDtlTransFB formBean = (RateContractDtlTransFB) form;
	
		RateContractDtlTransDATA.viewDetails(formBean, request);// to get
		// CURRENT DATE and item category combo
		strtarget = "renew";
		return mapping.findForward(strtarget);

	}

	

	
	/**
	 * To add data.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		//boolean retVal ; 
		validateToken(request, response);
		RateContractDtlTransFB formBean = (RateContractDtlTransFB) form;
		 RateContractDtlTransDATA.insertRecord(formBean, request);

		return this.ADD(mapping, form, request, response);
		// return LIST( mapping,  form,
    	//		 request,  response);

	}
	
	
	
	public ActionForward RCEXTN(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HisException, SQLException {
        generateToken(request);
		RateContractDtlTransFB formBean = (RateContractDtlTransFB) form;
		RateContractDtlTransDATA.viewDetails(formBean, request);// to get
		strtarget = "extn";
		return mapping.findForward(strtarget);

	}

	

	/**
	 * forwards control to the ADD page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward INSERTRENEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
          validateToken(request, response);
		boolean retval ;
		RateContractDtlTransFB formBean = (RateContractDtlTransFB) form;
	
		retval = RateContractDtlTransDATA.insertRenew(formBean, request);// to get
		if(retval)
		
			 return LIST( mapping,  form,
	    			 request,  response);
		else
			return this.RENEW(mapping, form, request, response);
			
	

	}
	/**
	 * forwards control to the TERMINATE page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward CANCELRECORD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		RateContractDtlTransFB formBean = (RateContractDtlTransFB) form;
		RateContractDtlTransDATA.cancelRecord(formBean, request);
		 return LIST( mapping,  form,
    			 request,  response);
	}
	
	/**
	 * forwards control to the TERMINATE page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 *//*
	public ActionForward TERMINATECONTRACT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		RateContractDtlTransFB formBean = (RateContractDtlTransFB) form;
		RateContractDtlTransDATA.insertTerminateDtl(formBean, request);
		
		return this.TERMINATE(mapping, form, request, response);
	}
	
	*/
	/**
	 * forwards control to the VIEW page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		RateContractDtlTransFB formBean = (RateContractDtlTransFB) form;
		RateContractDtlTransDATA.viewDetails(formBean, request);
		strtarget = "view";
		return mapping.findForward(strtarget);
	}
	
	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		RateContractDtlTransFB formBean = (RateContractDtlTransFB) form;
		RateContractDtlTransDATA.viewDetails(formBean, request);
		strtarget = "modify";
		return mapping.findForward(strtarget);
	}
	/**
	 * forwards control to the LIST page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward RETLISTPAGE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		
        return LIST( _mapping,  _form,
    			 request,  response);
        
    }
	
	
	/** This method is used to cancel the Process.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response)
			 {
			     ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/hisglobal/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;
			 }
	
	public ActionForward MODIFYSAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
          validateToken(request, response);
		boolean retval ;
		RateContractDtlTransFB formBean = (RateContractDtlTransFB) form;
	
		retval = RateContractDtlTransDATA.modifyRecord(formBean, request);// to get
		if(retval)
		
			 return LIST( mapping,  form,
	    			 request,  response);
		else
			return this.MODIFY(mapping, form, request, response);
			
	

	}
	public ActionForward insertRateContractExtension(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HisException, Exception {

		boolean retval ;
		validateToken(request, response);
		RateContractDtlTransFB formBean = (RateContractDtlTransFB) form;

		retval = RateContractDtlTransDATA.insertRateContractExtension(formBean, request);// to get
		if(retval)

			return LIST( mapping,  form,
					request,  response);
		else
			return this.RENEW(mapping, form, request, response);

	}


}
