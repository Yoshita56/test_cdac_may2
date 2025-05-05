package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.BillApprovalVerificationRptDATA;
import mms.reports.controller.data.ListConsumablesExpiryDateRptDATA;
import mms.reports.controller.fb.BillApprovalVerificationRptFB;
import mms.reports.controller.fb.ListConsumablesExpiryDateRptFB;
import mms.transactions.controller.data.BillApprovalTransDATA;


public class BillApprovalVerificationRptCNT extends DispatchAction {


	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception, SQLException {

		return this.STORECMB(mapping, form, request, response);
	}

	public ActionForward STORECMB(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		String strTarget = "index";
		BillApprovalVerificationRptFB formBean = (BillApprovalVerificationRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		BillApprovalVerificationRptDATA.getInitialAddList(formBean, request, response);
		return mapping.findForward(strTarget);
	}

	public void POCOMBOPAGE(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		BillApprovalVerificationRptFB formBean = (BillApprovalVerificationRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		BillApprovalVerificationRptDATA.getPOCombo(formBean, request, response); // to display the Store
	}

	
	public void GET_PO_DETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception, SQLException {
		System.out.println(" --------------- BillApprovalVerificationRptCNT.GET_PO_DETAILS ---------------- ");
		
		BillApprovalVerificationRptFB formBean = (BillApprovalVerificationRptFB) form;
		
		String strBillTypeId = request.getParameter("strBillTypeId");
		
		if (strBillTypeId != null) {
			formBean.setStrBillTypeId(request.getParameter("strBillTypeId"));
		} else {
		    formBean.setStrBillTypeId("-");
		}

		System.out.println("CNT:GET_PO_DETAILS:formBean.getStrBillTypeId()-->" + formBean.getStrBillTypeId());

		if(formBean.getStrBillTypeId().equals("10")) //BULK
	  	    {	
	    		  BillApprovalVerificationRptDATA.getBulkPODetails(formBean,request,response);
	  	    }
	  	    if(formBean.getStrBillTypeId().equals("11"))//LOCAL
	  	    {
	  	    	
	  	    	BillApprovalVerificationRptDATA.getLPPODetails(formBean,request,response);
	  	    }
	  	    if(formBean.getStrBillTypeId().equals("12"))//SUPPLIER
	  	    {
	  	    	BillApprovalVerificationRptDATA.getSupp_Rec_Details(formBean,request,response);
	  	    }  	
	}
	

	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		BillApprovalVerificationRptFB formBean = (BillApprovalVerificationRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BillApprovalVerificationRptDATA.getItemCatList(formBean,request, response);
		return null;
	}
	
	

	public ActionForward CANCEL(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public ActionForward BACK(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception, SQLException {

		return this.STORECMB(mapping, form, request, response);

	}

}
