package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.IssueToPatOPDTransDATA;
import mms.transactions.controller.fb.IssueToPatOPDTransFB;

public class IssueToPatOPDTransCNT extends CSRFGardTokenAction {

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		generateToken(request);
		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		return this.INITVAL(mapping, formBean, request, response);
	}

	// To Get the Store Combo
	public ActionForward INITVAL(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		System.out.println(
				" ------- IssueToPatOPDTransCNT.INITVAL  --[ Plz Check JavaScript function onGoButton() ] ---[issueTransNew.jsp , IssueTransBs.js]---- ");

		generateToken(request);
		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;

		// formBean.setStrCrNoDefault("1");

		formBean.setStrDoseFrqFlg("0");
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.getStoreDtls(formBean, request);
	
		//formBean.setStrCrNo(request.getSession().getAttribute("HOSPITAL_CODE").toString());

		/*if (formBean.getStrCRorLFwise() == null || formBean.getStrCRorLFwise() == "")
			
		formBean.setStrCRorLFwise("1");*/

		String target = "issue";

		return mapping.findForward(target);
	}

	// From index page go btn hit to ISSUE_OPD_OFFLINE
	public ActionForward ISSUE_OPD_OFFLINE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		System.out.println(
				" ------- IssueToPatOPDTransCNT.ISSUE_OPD_OFFLINE  ----[ Plz Check JavaScript function onGoButton() ]--[ IssueTransGoNew.jsp , IssueTransBs.js]--- ");

		generateToken(request);
		String target = "";
		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;

		if (formBean.getNewreqflg().equalsIgnoreCase("1")) {
			formBean.setStrCrNo(formBean.getStrCrNo());
		}

		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		System.out.println(" formBean.getStrStoreId          ----- " + formBean.getStrStoreId());
		System.out.println(" formBean.getStrCrNo()           ----- " + formBean.getStrCrNo());

		System.out.println(" request.getParameter(strId)----- " + request.getParameter("strId"));
		System.out.println(" request.getParameter(crNo)----- " + request.getParameter("crNo"));

		IssueToPatOPDTransDATA.getPatientStatus(formBean, request, response);
		
		if (formBean.getStrInvalidCrFlag().equals("2")) {
			System.out.println(" ------- In-Valid CR-[ target =  IssueTransNew.jsp]-- ");
			
			IssueToPatOPDTransDATA.getStoreDtls(formBean, request);
			formBean.setStrErrMsg(" In Valid CR No. Drug Dispensing Only For OPD Patient !! ");
			target = "issue";
			
			//formBean.setStrCrNo(formBean.getStrHospitalCode());
			
		} else {
			IssueToPatOPDTransDATA.getDiirecIssueInitData(formBean, request, response);
			IssueToPatOPDTransDATA.getPatientDetails(formBean, request, response);
			IssueToPatOPDTransDATA.getOnlineReqDtl(formBean, request, response);
			IssueToPatOPDTransDATA.getDeptDetails(formBean, request);
			IssueToPatOPDTransDATA.getFrequencyDetails(formBean, request);
			IssueToPatOPDTransDATA.getDoseDetails(formBean, request);
			//formBean.setStrStoreId(formBean.getStrStoreId());

			if (!formBean.getStrIssueMode().equals("0")) { 
				IssueToPatOPDTransDATA.getGroupDetails(formBean, request);
			}

			System.out.println(" ---B---- target = issueGo_offLine --[IssueTransGoNew.jsp]- ");
			target = "issueGo_offLine";
		}

		return mapping.findForward(target);

	}
	// issueGo_offLine - IssueTransGoNew.jsp once drug from finder is selected save click will generate DIRECTISSUE_OFFLINE
	public ActionForward DIRECTISSUE_OFFLINE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(" ------- IssueToPatOPDTransCNT.DIRECTISSUE_OFFLINE  ---[ IN USE ]---- ");

		validateToken(request, response);
		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.DIRECTISSUE_OFFLINE(formBean, request);
		// this.ISSUEDTLPOPUP(mapping,form,request,response);
		formBean.setPrintReq("1");

		/*
		 * System.out.
		 * println("<<<--------------IssueToPatientTransBSOCNT . afterIssueSave() -- [ issue_VoucherOffline.jsp ]-------------->>>"
		 * ); IssueToPatOPDTransDATA.afterIssueSave(formBean, request); String strtarget
		 * = "voucher"; return mapping.findForward(strtarget);
		 */

		if (formBean.getStrVisitDtl().equals("0")) {
			// ActionMapping mapping, ActionForm form,
			// HttpServletRequest request, HttpServletResponse response
			return this.ISSUE_OPD_ONLINE(mapping, form, request, response);
		} else {

			return this.INITVAL(mapping, form, request, response);
		}

	}


	/**
	 * 
	 * forwards control to the View page of this Transaction.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	// jump control to view2 page to get issued details list
	public ActionForward VIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(
				" ------- IssueToPatOPDTransCNT.VIEWPAGE  ----[ View_PreviousIssueOPD.jsp , IssueTransBs.js]--- ");

		String strTarget = "view2";
		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		// formBean.setStrflg("0");
		generateToken(request);
		// IssueToPatOPDTransDATA.getMmsConfigFlags(formBean, request, response);

		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		// formBean.setStrCrNo(formBean.getStrCrNo());

		IssueToPatOPDTransDATA.getStoreDtlsView(formBean, request);
		// formBean.setStrflg("1");
		return mapping.findForward(strTarget);
	}

	/* ==drug Q rate cost == */
	public ActionForward ISSUEDTLPOPUP(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		System.out.println(" ------- IssueToPatOPDTransCNT.ISSUEDTLPOPUP  ------- ");

		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		IssueToPatOPDTransDATA.getIssuePopUp(formBean, request, response);

		return this.INITVAL(mapping, form, request, response);
	}

	public ActionForward ISSUEDTLPOPUP_ORG(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		System.out.println(" ------- IssueToPatOPDTransCNT.ISSUEDTLPOPUP_ORG  ------- ");
		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.getIssuePopUp(formBean, request, response);
		return null;
	}

	/* == issue no issue date == */
	public ActionForward PREVISSUEDTL(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		System.out.println(" ------- IssueToPatOPDTransCNT.PREVISSUEDTL  ------- ");

		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.getIssueDetails(formBean, request, response);
		return null;
	}

	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	/*
	 * AFTER Click On GO Button
	 * 
	 */
	public ActionForward ISSUE_OPD_ONLINE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		System.out.println(
				" ------- IssueToPatOPDTransCNT.ISSUE_OPD_ONLINE  ----[ Plz Check JavaScript function onGoButton() ]--[ IssueGoOPD_OnLine.jsp , IssueTransBs.js]--- ");

		generateToken(request);
		String target = "";
		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		
		if (formBean.getNewreqflg().equalsIgnoreCase("1")) {
			formBean.setStrCrNo(formBean.getCrNo());
		}

		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		System.out.println(" request.getParameter(strStoreId)----- " + request.getParameter("strId"));
		System.out.println(" request.getParameter(getStrCrNo)----- " + request.getParameter("crNo"));
		System.out.println(" request.getParameter(strItemCat)----- " + request.getParameter("itemCategory"));
		System.out.println(" formBean.getStrCrNo()           ----- " + formBean.getStrCrNo());
		System.out.println(" formBean.getStrStoreId          ----- " + formBean.getStrStoreId());
		System.out.println(" formBean.getStrItemCat()        ----- " + formBean.getStrItemCat());

		IssueToPatOPDTransDATA.getDiirecIssueInitData(formBean, request, response);

		try {
			IssueToPatOPDTransDATA.getPatientDetails(formBean, request, response);
		} catch (Exception e) {
			return this.INITVAL(mapping, formBean, request, response);
		}
		formBean.setCrNo(formBean.getStrCrNo());
		formBean.setStrStoreId(formBean.getStrStoreId());
		formBean.setItemCategory(formBean.getStrItemCat());

		if (formBean.getStrInvalidCrFlag().equals("1") || formBean.getStrInvalidLFFlag().equals("1")
				|| formBean.getStrInvalidLFFlag().equals("2") || formBean.getStrInvalidCrFlag().equals("2")) {
			formBean.setStrWarningMsg(" Drug Dispensing Only For OPD Patient !!! ");

			return this.INITVAL(mapping, formBean, request, response);

		} else {

			IssueToPatOPDTransDATA.getOnlineReqDtl(formBean, request, response);
			IssueToPatOPDTransDATA.getDeptDetails(formBean, request);

			IssueToPatOPDTransDATA.getFrequencyDetails(formBean, request);
			IssueToPatOPDTransDATA.getDoseDetails(formBean, request);
			if (!formBean.getStrIssueMode().equals("0")) {

				IssueToPatOPDTransDATA.getGroupDetails(formBean, request);

			}

			System.out.println(" ---B---- target = issueGo_onLine -[ IssueGoOPD_OnLine.jsp ]-- ");
			target = "issueGo_onLine";

			return mapping.findForward(target);
		}

	}

	/*
	 * To Get the Cancel Page
	 */

	public ActionForward GETCANCELPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		System.out.println(" ------- IssueToPatOPDTransCNT.GETCANCELPAGE  ------- ");

		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.getStoreDtls(formBean, request);
		String target = "cancelIssue";
		return mapping.findForward(target);
	}

	/*
	 * To Get the Item Category Combo
	 */

	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		System.out.println(" ------- IssueToPatOPDTransCNT.ITEMCATCMB  ------- ");
		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatOPDTransDATA.getItemCatDtls(formBean, request, response);

		return null;
	}

	public ActionForward GET_PAT_ACC_STATUS(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		System.out.println(
				" ------- IssueToPatOPDTransCNT.GET_PAT_ACC_STATUS  --[ After Go Click Check Account Status ]----- ");
		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatOPDTransDATA.GET_PAT_ACC_STATUS(formBean, request, response);

		return null;
	}

	public ActionForward INITCANCELGO(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.getCancelPatientDetails(formBean, request, response);

		String target = "cancelGo";
		return mapping.findForward(target);

	}

	public ActionForward REQUESTDTLS(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		System.out.println(" ------- IssueToPatOPDTransCNT.REQUESTDTLS  ------- ");

		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.getRequestDetails(formBean, request, response);
		return null;
	}

	public ActionForward UNITCMB(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		System.out.println(" ------- IssueToPatOPDTransCNT.UNITCMB  ------- ");
		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.getUnitDetails(formBean, request, response);
		return null;
	}

	public ActionForward PRESCRIPEDBY(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		System.out.println(" ------- IssueToPatOPDTransCNT.PRESCRIPEDBY  ------- ");

		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.getPrescribedBy(formBean, request, response);
		return null;
	}

	public ActionForward ITEMDETAILS(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		System.out.println(" ------- IssueToPatOPDTransCNT.ITEMDETAILS  ------- ");

		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.getItemDetails(formBean, request, response);
		return null;
	}

	public ActionForward INSERT(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, Exception {
		System.out.println(" ------- IssueToPatOPDTransCNT.INSERT  ------- ");

		validateToken(request, response);
		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.insert(formBean, request);
		// this.ISSUEDTLPOPUP(mapping,form,request,response);
		// formBean.setPrintReq("1");
		if (formBean.getStrVisitDtl().equals("0")) {
			// ActionMapping mapping, ActionForm form,
			// HttpServletRequest request, HttpServletResponse response
			return this.ISSUE_OPD_ONLINE(mapping, form, request, response);
		} else {
			return this.INITVAL(mapping, form, request, response);
		}

	}

	

	public ActionForward INSERTCANCEL(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		System.out.println(" ------- IssueToPatOPDTransCNT.INSERTCANCEL  ------- ");

		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.insertCancel(formBean, request);
		if (formBean.getStrVisitDtl().equals("0")) {
			return this.INITCANCELGO(mapping, form, request, response);
		} else {
			return this.GETCANCELPAGE(mapping, form, request, response);
		}

	}

	

	
	/**
	 * ISSUEDTLSINIT - gets the issue details view used for ajax.
	 * 
	 * @param mapping  the mapping
	 * @param form     the form
	 * @param request  the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward ISSUEDTLSINIT(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		IssueToPatOPDTransDATA.issueDtlsInit(request, response, formBean);
		return null;
	}

	/**
	 * ISSUEDTLSINIT - gets the issue details view used for ajax.
	 * 
	 * @param mapping  the mapping
	 * @param form     the form
	 * @param request  the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward ISSUEDTLSINITONE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		System.out.println(" ------- IssueToPatOPDTransCNT.ISSUEDTLSINITONE  ------- ");

		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		IssueToPatOPDTransDATA.issueDtlsInit(request, response, formBean);
		return null;
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

	public ActionForward GOVIEWPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(" ------- IssueToPatOPDTransCNT.GOVIEWPAGE  ------- ");

		IssueToPatOPDTransFB fb = (IssueToPatOPDTransFB) form;
		IssueToPatOPDTransDATA.getViewDtl(fb, request, response);
		return null;
	}

	public ActionForward RETURNTOMAINDESK(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(" ------- IssueToPatOPDTransCNT.RETURNTOMAINDESK  ------- ");

		ActionForward acFwd = new ActionForward();
		String strPath = "";
		if (request.getParameter("strPath") != null) {
			strPath = request.getParameter("strPath");
			acFwd.setPath(strPath);
			acFwd.setContextRelative(true);

		}
		return acFwd;
	}

	/**
	 * 
	 * Method is used to get issue item details after billing
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward ISSUEDTLSBILLED(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		System.out.println(" ------- IssueToPatOPDTransCNT.ISSUEDTLSBILLED  ------- ");

		IssueToPatOPDTransFB fb = (IssueToPatOPDTransFB) form;
		IssueToPatOPDTransDATA.getBilledItemDtls(fb, request, response);
		return null;
	}

	public ActionForward SAVE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {
		System.out.println(" ------- IssueToPatOPDTransCNT.SAVE  ------- ");

		IssueToPatOPDTransFB fb = (IssueToPatOPDTransFB) form;
		IssueToPatOPDTransDATA.save(fb, request, response);
		// fb.setStrflg("0");
		/*
		 * ActionForward acFwd = new ActionForward(); String strPath =
		 * "/mms/transactions/MmsCNT.cnt?hmode=ISSUEDTLSINIT&strMode=1&strStoreId="+fb.
		 * getStrStoreId()+"&strIssueNo="+fb.getStrHlpIssueNo()+
		 * "&strIndentNo=0&strIndentDate=0"; //VIEWPAGE acFwd.setPath(strPath);
		 * acFwd.setContextRelative(true); return acFwd;
		 */
		fb.setStrCrNo(fb.getCrNo());
		fb.setStrflg("10");
		return this.VIEWPAGE(mapping, form, request, response);
	}

	/**
	 * 
	 * Method is used to delete issue item details after billing
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward DELETEISSUEDETAILS(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(" ------- IssueToPatOPDTransCNT.DELETEISSUEDETAILS  ------- ");
		IssueToPatOPDTransFB fb = (IssueToPatOPDTransFB) form;
		IssueToPatOPDTransDATA.deleteIssueDtls(fb, request, response);
		return null;
	}

	public ActionForward TARIFFCHK(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(" ------- IssueToPatOPDTransCNT.TARIFFCHK  ------- ");

		IssueToPatOPDTransFB fb = (IssueToPatOPDTransFB) form;
		IssueToPatOPDTransDATA.getTariffDtl(fb, request, response);
		return null;
	}

	public ActionForward ALREADYISSUEDRUG(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(" ------- IssueToPatOPDTransCNT.ALREADYISSUEDRUG  ------- ");

		IssueToPatOPDTransFB fb = (IssueToPatOPDTransFB) form;
		IssueToPatOPDTransDATA.getAlreadyIssueDrug(fb, request, response);
		return null;
	}

	public ActionForward GETREQTYPE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(" ------- IssueToPatOPDTransCNT.GETREQTYPE  ------- ");

		IssueToPatOPDTransFB fb = (IssueToPatOPDTransFB) form;
		IssueToPatOPDTransDATA.getReqType(fb, request, response);
		return null;
	}

	public ActionForward INSERTDIRECTISSUE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(" ------- IssueToPatOPDTransCNT.INSERTDIRECTISSUE  ------- ");

		validateToken(request, response);
		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		IssueToPatOPDTransDATA.insertDirectIssue(formBean, request);
		// this.ISSUEDTLPOPUP(mapping,form,request,response);
		formBean.setPrintReq("1");
		if (formBean.getStrVisitDtl().equals("0")) {
			// ActionMapping mapping, ActionForm form,
			// HttpServletRequest request, HttpServletResponse response
			return this.ISSUE_OPD_ONLINE(mapping, form, request, response);
		} else {
			return this.INITVAL(mapping, form, request, response);
		}

	}

	public ActionForward EPISODEDTLS(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(" ------- IssueToPatOPDTransCNT.EPISODEDTLS  ------- ");

		IssueToPatOPDTransFB fb = (IssueToPatOPDTransFB) form;
		IssueToPatOPDTransDATA.getEpisodeDtl(fb, request, response);
		return null;
	}

	public ActionForward PRESFORMDTLS(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(" ------- IssueToPatOPDTransCNT.PRESFORMDTLS  ------- ");
		IssueToPatOPDTransFB fb = (IssueToPatOPDTransFB) form;
		IssueToPatOPDTransDATA.getPresFormDtl(fb, request, response);
		return null;
	}

	public ActionForward GETPRESCDATA(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println(" ------- IssueToPatOPDTransCNT.GETPRESCDATA  ------- ");

		IssueToPatOPDTransFB formBean = (IssueToPatOPDTransFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		IssueToPatOPDTransDATA.getOnlineTreatmentDtl(formBean, request, response);
		return null;
	}

}
