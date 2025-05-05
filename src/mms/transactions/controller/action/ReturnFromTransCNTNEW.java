package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.ReturnFromTransDATA;
import mms.transactions.controller.fb.ReturnFromTransFB;

/**
* Developer : Tanvi Sappal Version : 1.0 Date : 23/April/2009 Mod Date :
* 11/Jun/2009
*/
public class ReturnFromTransCNTNEW extends CSRFGardTokenAction {

	String strTarget = "";

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		System.out.println("------------ ReturnFromTransCNTNEW .unspecified  ------[ return_from_mmstransNEW.jsp ]------");
		ReturnFromTransFB formBean = (ReturnFromTransFB) form;
		ReturnFromTransDATA.getMmsConfigFlags(formBean, request, response);

		ReturnFromTransDATA.storeName(formBean, request);
		formBean.setStrCrNo("");
		strTarget = "patient";
		return mapping.findForward(strTarget);
	}

	public ActionForward ITEMCATEGORY(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		ReturnFromTransFB formBean = (ReturnFromTransFB) form;
		ReturnFromTransDATA.itemCategory(formBean, request, response);
		return null;

	}

	public ActionForward GO(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		ReturnFromTransFB formBean = (ReturnFromTransFB) form;

		System.out.println("------------ ReturnFromTransCNTNEW .GO  ------------");
		// /INVMGM/mms/transactions/ReturnFromTransCNTNEW.cnt?mode=2 
		String strMode = request.getParameter("strMode");
		System.out.println("------------strMode------------"+strMode);

		formBean.setStrMode(strMode);
		if (formBean.getStrCrNoDefault() != null && formBean.getStrCrNoDefault().equals("1")) {
			return validateIssueNumber(mapping, form, request, response);
		} else {

			boolean fRes = ReturnFromTransDATA.patientDetailNEW(formBean, request);

			System.out.println("-----fRes---------" + fRes);

			if (fRes) {
				System.out.println("-----List of ALL Drugs ------- return_from_pat_list_mmstrans_goNEW.jsp [returnFrom_mmsTransNEW.js ]  ------------");

				strTarget = "patientListGo";

				return mapping.findForward(strTarget);
			} else {
				System.out.println("------------ return_from_mmstransNEW.jsp  ------------");

				ReturnFromTransDATA.storeName(formBean, request);
				formBean.setStrCrNo("");
				strTarget = "patient";
				return mapping.findForward(strTarget);
			}

		}

	}

	/*public ActionForward ISSUEDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("------------ ReturnFromTransCNTNEW .ISSUEDETAILS  ------------");
		
		ReturnFromTransFB formBean = (ReturnFromTransFB)form;
		ReturnFromTransDATA.getIssueDetailsNEW(formBean, request,response);
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		return null;
	
	}*/
	
	public ActionForward ISSUEDETAILS_ALL_LIST(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		System.out.println("------------ ReturnFromTransCNTNEW .ISSUEDETAILS_ALL_LIST  ------------");

		ReturnFromTransFB formBean = (ReturnFromTransFB) form;
		ReturnFromTransDATA.getItem_ALL_LIST(formBean, request, response);
		/*String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());*/
		return null;

	}

	/*	public ActionForward INSERT(ActionMapping mapping, ActionForm form, HttpServletRequest request,
				HttpServletResponse response) throws Exception {
			System.out.println("------------ ReturnFromTransCNTNEW .INSERT  ------------");
	
			validateToken(request, response);
			ReturnFromTransFB formBean = (ReturnFromTransFB) form;
			ReturnFromTransDATA.insert(formBean, request);
			formBean.setFlagWithoutCrNo("0");
			return this.unspecified(mapping, form, request, response);
		}*/

	public ActionForward INSERT_LIST(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("------------ ReturnFromTransCNTNEW .INSERT_LIST  ------------");
		validateToken(request, response);
		ReturnFromTransFB formBean = (ReturnFromTransFB) form;
		ReturnFromTransDATA.insert_LIST(formBean, request);
		formBean.setFlagWithoutCrNo("0");
		return this.unspecified(mapping, form, request, response);
	}

	/* voucher */
	public ActionForward ISSUEDTLSINITNEW(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		ReturnFromTransFB formBean = (ReturnFromTransFB) form;

		System.out.println("---- ReturnFromTransCNTNEW . ISSUEDTLSINITNEW ----");

		ReturnFromTransDATA.issueDtlsInitNEW(request, response, formBean);

		return null;
	}

	/**
	 * This method is used to cancel the Return From Patient/Staff page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
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
	public ActionForward validateIssueNumber(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		System.out.println("------------ ReturnFromTransCNTNEW .validateIssueNumber  ------------");

		ReturnFromTransFB formBean = (ReturnFromTransFB) form;
		if (ReturnFromTransDATA.validateIssueNumber(formBean, request, response)) {
			return withoutCrNo(mapping, form, request, response);
		} else {
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
	public ActionForward withoutCrNo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		ReturnFromTransFB formBean = (ReturnFromTransFB) form;
//		System.out.println("mode"+request.getParameter("mode"));

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
		// boolean fRes =

		ReturnFromTransDATA.storeName(formBean, request);
		ReturnFromTransDATA.getpatientDemographicDetail(formBean, request);

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
	public ActionForward SEARCH(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		System.out.println("------------ ReturnFromTransCNTNEW .SEARCH  ------------");

		ReturnFromTransFB formBean = (ReturnFromTransFB) form;

		String strMode = request.getParameter("strMode");
		formBean.setStrMode(strMode);

		ReturnFromTransDATA.getMmsConfigFlags(formBean, request, response);

		if (formBean.getStrCrNoDefault() != null && formBean.getStrCrNoDefault().equals("1")) {
			formBean.setStrSearchByPatientNameOrCrNo("2");
		} else {
			formBean.setStrSearchByPatientNameOrCrNo("1");
		}

		strTarget = "patientGoWithoutCrNo";
		return mapping.findForward(strTarget);

//		boolean fRes = ReturnFromTransDATA.patientDetail(formBean, request);

//		if(fRes){

//			strTarget = "patientGoWithoutCrNo";
//			return mapping.findForward(strTarget);

		// }else{

		// strTarget = "patientWithoutCrNo";
		// return mapping.findForward(strTarget);
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
	public ActionForward GETISSUEDETAILS(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		ReturnFromTransFB formBean = (ReturnFromTransFB) form;

		String strMode = request.getParameter("strMode");
		formBean.setStrMode(strMode);

		System.out.println("------------ ReturnFromTransCNTNEW .GETISSUEDETAILS  ------------");

		/*if(formBean.getStrCrNoDefault()!=null && formBean.getStrCrNoDefault().equals("1"))
		{
			formBean.setStrSearchByPatientNameOrCrNo("2");
		}
		else
		{
			formBean.setStrSearchByPatientNameOrCrNo("1");
		}	*/

		ReturnFromTransDATA.getIssueDetailsBasedOnPatientNameOrCrNo(formBean, request, response);

		strTarget = "patientGoWithoutCrNo";
		return mapping.findForward(strTarget);

//		boolean fRes = ReturnFromTransDATA.patientDetail(formBean, request);

//		if(fRes){

//			strTarget = "patientGoWithoutCrNo";
//			return mapping.findForward(strTarget);

		// }else{

		// strTarget = "patientWithoutCrNo";
		// return mapping.findForward(strTarget);
//		}	

	}

	/**
	 * This function is used to insert details into database
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	public ActionForward INSERTWithoutCrNo(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("------------ ReturnFromTransCNTNEW .INSERTWithoutCrNo  ------------");

		validateToken(request, response);
		ReturnFromTransFB formBean = (ReturnFromTransFB) form;
		ReturnFromTransDATA.insertWithoutCrNo(formBean, request);
		formBean.setFlagWithoutCrNo("0");
		return this.unspecified(mapping, form, request, response);
	}

	public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		String strTarget = "view";

		ReturnFromTransFB fb = (ReturnFromTransFB) form;
		ReturnFromTransDATA.initViewPageDtl(fb, request);
		return mapping.findForward(strTarget);
	}

	/**
	 * 
	 * Method is used to get View details after pressing GO button
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	/* view page go button hit */
	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		ReturnFromTransFB fb = (ReturnFromTransFB) form;
		ReturnFromTransDATA.getViewDtlNEW(fb, request, response);
		return null;
	}

}
