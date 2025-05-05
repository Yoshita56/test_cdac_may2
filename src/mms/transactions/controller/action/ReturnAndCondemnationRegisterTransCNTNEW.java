package mms.transactions.controller.action;

//import hisglobal.TokenConfig;
/***************************Start of program*****************************\
## Copyright Information				: C-DAC, Noida  
## Project Name					:NIMS 
## Name of Developer		 			:Shefali Garg	 
## Module Name					: MMS
## Process/Database Object Name			:
## Purpose						:
## Date of Creation					: 15-may-2015
## Modification Log					:				
##		Modify Date				: 
##		Reason	(CR/PRS)			: 
##		Modify By				: 

*/

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.ReturnAndCondemnationRegisterTransDATA;
import mms.transactions.controller.fb.ReturnAndCondemnationRegisterTransFB;
import hisglobal.presentation.CSRFGardTokenAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;


/**
 * The Class ReturnAndCondemnationRegisterTransCNT.
 */
public class ReturnAndCondemnationRegisterTransCNTNEW extends CSRFGardTokenAction
{
	
	/* (non-Javadoc)
	 * @see org.apache.struts.actions.DispatchAction#unspecified(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HisException {
		//generateToken(request);
		ReturnAndCondemnationRegisterTransFB formBean = (ReturnAndCondemnationRegisterTransFB)form;
		ReturnAndCondemnationRegisterTransDATA.initialPage(formBean,request);
		String target = "initialPage";
		//System.out.println("formBean.setStrStoreName"+formBean.getStrStoreName());
		formBean.setStrVoucherFlag("0");
		formBean.setStrsaveflag("0");
		//formBean.setStrTmpStoreId("112222");
		return mapping.findForward(target);
	}	
	public ActionForward unspecified1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HisException {
		generateToken(request);
		ReturnAndCondemnationRegisterTransFB formBean = (ReturnAndCondemnationRegisterTransFB)form;
		ReturnAndCondemnationRegisterTransDATA.initialPage(formBean,request);
		String target = "initialPage";
		//System.out.println("formBean.setStrStoreName"+formBean.getStrStoreName());
		formBean.setStrVoucherFlag("1");
		formBean.setStrsaveflag("1");
		//formBean.setStrTmpStoreId("112222");
		return mapping.findForward(target);
	}	
	/**
	 * Gets the return or condemn drug list hlp.
	 *
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the return or condemn drug list hlp
	 * @throws HisException the his exception
	 */
	public ActionForward getReturnOrCondemnDrugListHlp(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HisException 
					{
		ReturnAndCondemnationRegisterTransFB formBean = (ReturnAndCondemnationRegisterTransFB)form;
		ReturnAndCondemnationRegisterTransDATA.getReturnOrCondemnDrugListHlpNEW(formBean, request,response);
		return null;
					}
	

	public static ActionForward GETCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HisException 
					{
		ReturnAndCondemnationRegisterTransFB formBean = (ReturnAndCondemnationRegisterTransFB)form;
		ReturnAndCondemnationRegisterTransDATA.GETCATCMB(formBean, request,response);
		return null;
					}
	public static ActionForward GETSUPPLIERCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HisException 
					{
		ReturnAndCondemnationRegisterTransFB formBean = (ReturnAndCondemnationRegisterTransFB)form;
		ReturnAndCondemnationRegisterTransDATA.getsuppliernamecmb(formBean, request,response);
		return null;
					}

	/**
	 * Insert.
	 *
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HisException {
		try {
			//this.validateToken(request, response);   
			ReturnAndCondemnationRegisterTransFB formBean = ( ReturnAndCondemnationRegisterTransFB)form;
			ReturnAndCondemnationRegisterTransDATA.insert(formBean, request);		
			ReturnAndCondemnationRegisterTransDATA.initialPage(formBean,request);
			String target = "initialPage";
			return unspecified1(mapping, formBean, request, response); 	
		} catch (Exception e) {
			System.out.println("ReturnAndCondemnationRegisterTransCNT.INSERT >> "
					+ e.getMessage());
		}

		return null;


	}


	/**
	 * Voucherprint.
	 *
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 */
	public ActionForward VOUCHERPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
					throws HisException {
		ReturnAndCondemnationRegisterTransFB formBean = ( ReturnAndCondemnationRegisterTransFB)form;
		ReturnAndCondemnationRegisterTransDATA.voucherPrint(formBean, request,response);		

		return null;

	}

	/**
	 * Cancelpage.
	 *
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 */
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
}