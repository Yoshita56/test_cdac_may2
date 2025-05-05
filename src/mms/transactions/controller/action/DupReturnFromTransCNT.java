

/**
 * 
 * 
 */
package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.DupReturnFromTransDATA;
import mms.transactions.controller.fb.DupReturnFromTransFB	;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * Developer : Tanvi Sappal 
 * Version : 1.0 
 * Date : 23/April/2009
 * Mod Date : 11/Jun/2009
 */
public class DupReturnFromTransCNT extends DispatchAction {
	
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

		DupReturnFromTransFB formBean = (DupReturnFromTransFB)form;
		DupReturnFromTransDATA.getMmsConfigFlags(formBean, request,response);

		DupReturnFromTransDATA.storeName(formBean,request);
		formBean.setStrCrNo("");
		formBean.setStrMode("2");
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

		DupReturnFromTransFB formBean = (DupReturnFromTransFB)form;
		DupReturnFromTransDATA.itemCategory(formBean,request,response);
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
		DupReturnFromTransFB formBean = (DupReturnFromTransFB)form;
		
		String strMode = request.getParameter("strMode");
		formBean.setStrMode(strMode);
		if(formBean.getStrCrNoDefault()!=null && formBean.getStrCrNoDefault().equals("1"))
		{
			return validateIssueNumber(mapping, form, request, response);
		}
		else
		{
			
			boolean fRes = DupReturnFromTransDATA.patientDetail(formBean, request);
			
			if(fRes){
				
				strTarget = "patientGo";
				return mapping.findForward(strTarget);
				
			}
			else
			{
				DupReturnFromTransDATA.storeName(formBean,request);	
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
		DupReturnFromTransFB formBean = (DupReturnFromTransFB)form;
		DupReturnFromTransDATA.getIssueDetails(formBean, request,response);
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
	 * @throws HisException
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		DupReturnFromTransFB formBean = (DupReturnFromTransFB)form;
		DupReturnFromTransDATA.insert(formBean,request);
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
     
		DupReturnFromTransFB formBean = (DupReturnFromTransFB) form;
		if(DupReturnFromTransDATA.validateIssueNumber(formBean, request,response))
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
     
		DupReturnFromTransFB formBean = (DupReturnFromTransFB) form;
	
		
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
					
					DupReturnFromTransDATA.storeName(formBean,request);
						DupReturnFromTransDATA.getpatientDemographicDetail(formBean, request);
					
						
					
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
		DupReturnFromTransFB formBean = (DupReturnFromTransFB)form;
		
		String strMode = request.getParameter("strMode");
		formBean.setStrMode(strMode);
		
		DupReturnFromTransDATA.getMmsConfigFlags(formBean, request,response);
		
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
		
//		boolean fRes = DupReturnFromTransDATA.patientDetail(formBean, request);
		
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
		DupReturnFromTransFB formBean = (DupReturnFromTransFB)form;
		
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

		DupReturnFromTransDATA.getIssueDetailsBasedOnPatientNameOrCrNo(formBean, request,response);

		
		strTarget = "patientGoWithoutCrNo";
		return mapping.findForward(strTarget);
		
//		boolean fRes = DupReturnFromTransDATA.patientDetail(formBean, request);
		
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
	 * @throws HisException
	 */
	public ActionForward INSERTWithoutCrNo(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		DupReturnFromTransFB formBean = (DupReturnFromTransFB)form;
		DupReturnFromTransDATA.insertWithoutCrNo(formBean,request);
		formBean.setFlagWithoutCrNo("0");
		return this.unspecified(mapping, form, request, response);
	}
}
