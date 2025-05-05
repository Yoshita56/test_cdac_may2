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


public class ReplacementCondemnationOrderTransCNT extends CSRFGardTokenAction   
{
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		 System.out.println("--------------- ReplacementCondemnationOrderTransCNT . unspecified ---[ dwh_main_replacementCondemnationOrder_trans.jsp , replacementCondemnationOrder_mmstrans.js]-------------");
         GenerateSecureRandomNumber(request);
		ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
		ReplacementCondemnationOrderTransDATA.initialPage(formBean,request);
		String target = "initialPage";
		return mapping.findForward(target);
	}
	//RC req generation desk go btn hit 
	public ActionForward GETPENDINGORDERDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		    System.out.println("--------------- ReplacementCondemnationOrderTransCNT . GETPENDINGORDERDTL ------[strActionsId = 1 (Return) , strActionsId = 2 (Condemnation) ]----------");
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getPendingOrderDtl(formBean, request,response);
			return null;
	}
	
	
	
	public ActionForward GETNOSQDRUGLISTHLP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		System.out.println("--------------- ReplacementCondemnationOrderTransCNT . GETNOSQDRUGLISTHLP ----------------");
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
		//	ReplacementCondemnationOrderTransDATA.getNOSQDrugListHLP(formBean, request,response);
			return null;
	}
	//Suggested Drug/Item List(Non Moving Drug/Item List)   this will open list of drugs/items 
	public ActionForward GETEXPIRYREJECTED(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		System.out.println("--------------- ReplacementCondemnationOrderTransCNT . GETEXPIRYREJECTED ----------------");
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getExpiryRejectedDrugList(formBean, request,response);
			return null;
	}
	
	public ActionForward GETREGULARINDENTDRUGLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		System.out.println("--------------- ReplacementCondemnationOrderTransCNT . GETREGULARINDENTDRUGLIST ----------------");
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getregularindentdruglist(formBean, request,response);
			return null;
	}
	
	
	
	
	public ActionForward GETAVAILABLESTOCKDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		System.out.println("--------------- ReplacementCondemnationOrderTransCNT . GETAVAILABLESTOCKDTL ----------------");
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getAvailableStockDtls(formBean, request,response);
			return null;
	}
	public ActionForward GETORDERSCHEDULEDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		System.out.println("--------------- ReplacementCondemnationOrderTransCNT . GETORDERSCHEDULEDTL ----------------");
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getOrderScheduleDtl(formBean, request,response);
			return null;
		
   }
	public ActionForward GETCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		System.out.println("--------------- ReplacementCondemnationOrderTransCNT . GETCATCMB ----------------");
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getcatcmb(formBean, request,response);
			return null;
		
   }
	
   public ActionForward GETSUPPLIERCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
	   System.out.println("--------------- ReplacementCondemnationOrderTransCNT . GETSUPPLIERCMB ----------------");
		    ReplacementCondemnationOrderTransFB formBean = (ReplacementCondemnationOrderTransFB)form;
			ReplacementCondemnationOrderTransDATA.getsuppliercmb(formBean, request,response);
			return null;
		
  }
   //after selecting item/drug from suggested drug list then save 
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		 System.out.println("--------------- ReplacementCondemnationOrderTransCNT . INSERT ----------------");
		//validateToken(request, response);
		 ReplacementCondemnationOrderTransFB formBean = ( ReplacementCondemnationOrderTransFB)form;
		//System.out.println("ACTIONID FormBean::"+formBean.getStrActionsId());
		 ReplacementCondemnationOrderTransDATA.insert(formBean, request);		
		
		return this.unspecified(mapping, form, request, response);
			
	}
	public ActionForward CANCELORDER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		 System.out.println("--------------- ReplacementCondemnationOrderTransCNT . CANCELORDER ----------------");
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

