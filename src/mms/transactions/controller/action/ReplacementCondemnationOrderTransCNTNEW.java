
package mms.transactions.controller.action;

/***************************Start of program*****************************\
## Copyright Information				: C-DAC, Noida  
## Project Name					:NIMS 
## Name of Developer		 			:Shefali Garg	 
## Module Name					: MMS
## Process/Database Object Name			:
## Purpose						:
## Date of Creation					: 11-may-2015
## Modification Log					:				
##		Modify Date				: 
##		Reason	(CR/PRS)			: 
##		Modify By				: 

*/
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.ReplacementCondemnationOrderTransDATA;
import mms.transactions.controller.fb.ReplacementCondemnationOrderTransFB;


public class ReplacementCondemnationOrderTransCNTNEW extends CSRFGardTokenAction   
{
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		//generateToken(request);
         GenerateSecureRandomNumber(request);
		ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
		ReplacementCondemnationOrderTransDATA.initialPage(formBean,request);
		String target = "initialPage";
		return mapping.findForward(target);
	}
	
	public ActionForward GETPENDINGORDERDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getPendingOrderDtlNEW(formBean, request,response);
			return null;
	}
	
	
	
	public ActionForward GETNOSQDRUGLISTHLP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
		//	ReplacementCondemnationOrderTransDATA.getNOSQDrugListHLP(formBean, request,response);
			return null;
	}
	
	public ActionForward GETEXPIRYREJECTED(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getExpiryRejectedDrugListNEW(formBean, request,response);
			return null;
	}
	
	public ActionForward GETREGULARINDENTDRUGLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getregularindentdruglist(formBean, request,response);
			return null;
	}
	
	
	
	
	public ActionForward GETAVAILABLESTOCKDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getAvailableStockDtls(formBean, request,response);
			return null;
	}
	public ActionForward GETORDERSCHEDULEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getOrderScheduleDtl(formBean, request,response);
			return null;
		
   }
	public ActionForward GETCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getcatcmb(formBean, request,response);
			return null;
		
   }
	
   public ActionForward GETSUPPLIERCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getsuppliercmb(formBean, request,response);
			return null;
		
  }
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//validateToken(request, response);
		 ReplacementCondemnationOrderTransFB formBean = ( ReplacementCondemnationOrderTransFB)form;
		//System.out.println("ACTIONID FormBean::"+formBean.getStrActionsId());
		 ReplacementCondemnationOrderTransDATA.insert(formBean, request);		
		
		return this.unspecified(mapping, form, request, response);
			
	}
	public ActionForward CANCELORDER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		 ReplacementCondemnationOrderTransFB formBean = ( ReplacementCondemnationOrderTransFB)form;
		//System.out.println("ACTIONID FormBean::"+formBean.getStrActionsId());
		 ReplacementCondemnationOrderTransDATA.CANCELORDER(formBean, request);		
		
		return this.unspecified(mapping, form, request, response);
			
	}
	/** This method is used to cancel the Miscellaneous Consumption  page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
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

