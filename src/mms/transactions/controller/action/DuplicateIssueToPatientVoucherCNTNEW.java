

/**
 * 
 * 
 */
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.DuplicateIssueToPatientVoucherTransDATA;
import mms.transactions.controller.fb.DuplicateIssueToPatientVoucherTransFB;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * Developer : Shivani Varshney 
 * Version : 1.0 
 * Date : 02/June/2020
 * Mod Date : 
 */
public class DuplicateIssueToPatientVoucherCNTNEW extends CSRFGardTokenAction {
	
	String strTarget = "";
	
	/**
	 * forwards control to the Page return_from_mmstrans.jsp
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
         //GenerateSecureRandomNumber(request);
		DuplicateIssueToPatientVoucherTransFB formBean = (DuplicateIssueToPatientVoucherTransFB)form;
		String strMode = request.getParameter("strMode");
		formBean.setStrMode(strMode);
		DuplicateIssueToPatientVoucherTransDATA.getMmsConfigFlags(formBean, request,response);

		DuplicateIssueToPatientVoucherTransDATA.storeName(formBean,request);
		formBean.setStrCrNo("");
		//if(formBean.getStrCrNoDefault()==null || formBean.getStrCrNoDefault().equals("0"))
		//{
			strTarget = "patient";
			return mapping.findForward(strTarget);	
		//}
		//else 
		//{
		//	String target = "patientWithoutCrNo";
		//	return mapping.findForward(target);	
		//}
		
		
	}
	
		
	/**
	 * Invoked by Ajax Functions and sets the required Item Category Values.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 */
	public ActionForward ITEMCATEGORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		DuplicateIssueToPatientVoucherTransFB formBean = (DuplicateIssueToPatientVoucherTransFB)form;
		DuplicateIssueToPatientVoucherTransDATA.itemCategory(formBean,request,response);
		return null;
		
	}
	
	/**
	 * Forwards Control to the Go Function
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
		DuplicateIssueToPatientVoucherTransFB formBean = (DuplicateIssueToPatientVoucherTransFB)form;
		
		String strMode = request.getParameter("strMode");
		formBean.setStrMode(strMode);
		if(formBean.getStrCrNoDefault()!=null && formBean.getStrCrNoDefault().equals("1"))
		{
			return validateIssueNumber(mapping, form, request, response);
		}
		else
		{
			
			boolean fRes = DuplicateIssueToPatientVoucherTransDATA.patientDetailNEW(formBean, request);
			
			if(fRes){
				
				strTarget = "patientGo";
				return mapping.findForward(strTarget);
				
			}
			else
			{
				DuplicateIssueToPatientVoucherTransDATA.storeName(formBean,request);	
				formBean.setStrCrNo("");
				strTarget = "patient";
				return mapping.findForward(strTarget);
			}	
			
			
		}		
	}
	
	
	public ActionForward GO1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		generateToken(request);
		DuplicateIssueToPatientVoucherTransFB formBean = (DuplicateIssueToPatientVoucherTransFB)form;
		
		String strMode = request.getParameter("strMode");
		formBean.setStrMode(strMode);
		if(formBean.getStrCrNoDefault()!=null && formBean.getStrCrNoDefault().equals("1"))
		{
			return validateIssueNumber(mapping, form, request, response);
		}
		else
		{
			
			boolean fRes = DuplicateIssueToPatientVoucherTransDATA.patientDetailNEW1(formBean, request);
			
			if(fRes){
				
				strTarget = "patientGo";
				return mapping.findForward(strTarget);
				
			}
			else
			{
				DuplicateIssueToPatientVoucherTransDATA.storeName(formBean,request);	
				formBean.setStrCrNo("");
				strTarget = "patient";
				return mapping.findForward(strTarget);
			}	
		
		}		
	}
	
	
	
	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ISSUEDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		DuplicateIssueToPatientVoucherTransFB formBean = (DuplicateIssueToPatientVoucherTransFB)form;
		DuplicateIssueToPatientVoucherTransDATA.getIssueDetailsNEW(formBean, request,response);
		/*String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());*/
		return null;

	}
	
	/**
	 * This function is used to insert details into database
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		validateToken(request, response);
		DuplicateIssueToPatientVoucherTransFB formBean = (DuplicateIssueToPatientVoucherTransFB)form;
		DuplicateIssueToPatientVoucherTransDATA.insert(formBean,request);
		formBean.setFlagWithoutCrNo("0");
		return this.unspecified(mapping, form, request, response);
	}
	
	/** This method is used to cancel the Return From Patient/Staff page.
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
			 
	
	// Change Request
	
	/**
	 * To validate Issue Number
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward validateIssueNumber(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)	throws HisException, SQLException 
	{
     
		DuplicateIssueToPatientVoucherTransFB formBean = (DuplicateIssueToPatientVoucherTransFB) form;
		if(DuplicateIssueToPatientVoucherTransDATA.validateIssueNumber(formBean, request,response))
		{
			return withoutCrNo(mapping, form, request, response);
		}
		else
		{
			String target = "patientWithoutCrNo";
			return mapping.findForward(target);	
		}
			
	}	
	
	
	
	/**
	 * To go on the page with Or Without Cr No.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward withoutCrNo(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)	throws HisException, SQLException 
   {
     
		DuplicateIssueToPatientVoucherTransFB formBean = (DuplicateIssueToPatientVoucherTransFB) form;
	
		
//		//System.out.println("mode"+request.getParameter("mode"));
		
					formBean.setStrIssueMode(request.getParameter("mode"));
					formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
					formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
//					formBean.setStrWithoutCrNoCheckBox("1");
//					IssueTransDATA.getStoreDtls(formBean, request);
//					IssueTransDATA.getDeptDetails(formBean, request);
//					IssueTransDATA.getFrequencyDetails(formBean, request);
//					IssueTransDATA.getDoseDetails(formBean, request);
//					IssueTransDATA.getGenderCombo(formBean, request);
//					IssueTransDATA.getFrequencyDetails(formBean, request);
//					IssueTransDATA.getDoseDetails(formBean, request);
					
					String strMode = request.getParameter("strMode");
					formBean.setStrMode(strMode);
					formBean.setFlagWithoutCrNo("1");
					//boolean fRes = 
					
					DuplicateIssueToPatientVoucherTransDATA.storeName(formBean,request);
						DuplicateIssueToPatientVoucherTransDATA.getpatientDemographicDetail(formBean, request);
					
						
					
					String target = "patientWithoutCrNo";
					return mapping.findForward(target);	
			
	}
	
	
	
	/**
	 * Forwards Control to the SEARCH Function
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward SEARCH(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		DuplicateIssueToPatientVoucherTransFB formBean = (DuplicateIssueToPatientVoucherTransFB)form;
		
		String strMode = request.getParameter("strMode");
		formBean.setStrMode(strMode);
		
		DuplicateIssueToPatientVoucherTransDATA.getMmsConfigFlags(formBean, request,response);
		
		if(formBean.getStrCrNoDefault()!=null && formBean.getStrCrNoDefault().equals("1"))
		{
			formBean.setStrSearchByPatientNameOrCrNo("2");
		}
		else
		{
			formBean.setStrSearchByPatientNameOrCrNo("1");
		}	
		
		strTarget = "patientGoWithoutCrNo";
		return mapping.findForward(strTarget);
		
//		boolean fRes = DuplicateIssueToPatientVoucherTransDATA.patientDetail(formBean, request);
		
//		if(fRes){
			
//			strTarget = "patientGoWithoutCrNo";
//			return mapping.findForward(strTarget);
			
		//}else{
			
			//strTarget = "patientWithoutCrNo";
			//return mapping.findForward(strTarget);
//		}	
		
	}
	
	
	/**
	 * To Get Issue Details
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */ 
	public ActionForward GETISSUEDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		DuplicateIssueToPatientVoucherTransFB formBean = (DuplicateIssueToPatientVoucherTransFB)form;
		
		String strMode = request.getParameter("strMode");
		formBean.setStrMode(strMode);
		
		
		/*if(formBean.getStrCrNoDefault()!=null && formBean.getStrCrNoDefault().equals("1"))
		{
			formBean.setStrSearchByPatientNameOrCrNo("2");
		}
		else
		{
			formBean.setStrSearchByPatientNameOrCrNo("1");
		}	*/

		DuplicateIssueToPatientVoucherTransDATA.getIssueDetailsBasedOnPatientNameOrCrNo(formBean, request,response);

		
		strTarget = "patientGoWithoutCrNo";
		return mapping.findForward(strTarget);
		
//		boolean fRes = DuplicateIssueToPatientVoucherTransDATA.patientDetail(formBean, request);
		
//		if(fRes){
			
//			strTarget = "patientGoWithoutCrNo";
//			return mapping.findForward(strTarget);
			
		//}else{
			
			//strTarget = "patientWithoutCrNo";
			//return mapping.findForward(strTarget);
//		}	
		
	}
	
	
	
	/**
	 * This function is used to insert details into database
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	public ActionForward INSERTWithoutCrNo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		validateToken(request, response);
		DuplicateIssueToPatientVoucherTransFB formBean = (DuplicateIssueToPatientVoucherTransFB)form;
		DuplicateIssueToPatientVoucherTransDATA.insertWithoutCrNo(formBean,request);
		formBean.setFlagWithoutCrNo("0");
		return this.unspecified(mapping, form, request, response);
	}
	
	
	/*
	 * public ActionForward DUPLICATEVOUCHER(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws Exception {
	 * validateToken(request, response); DuplicateIssueToPatientVoucherTransFB
	 * formBean = (DuplicateIssueToPatientVoucherTransFB)form;
	 * DuplicateIssueToPatientVoucherTransDATA.getIssueDtlsInitView(formBean,request
	 * ); formBean.setFlagWithoutCrNo("0"); return this.unspecified(mapping, form,
	 * request, response); }
	 */
}
