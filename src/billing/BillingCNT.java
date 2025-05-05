package billing;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class BillingCNT extends DispatchAction {

	public ActionForward POPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		String strSearchText = request.getParameter("searchText");
		
		BillingFB formBean = (BillingFB) form;
		formBean.setSearchText(strSearchText);
		
		String target = "display";

		return mapping.findForward(target);
	}

	public ActionForward TRFCODEPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		String strSearchText = request.getParameter("searchText");
		
		BillingFB formBean = (BillingFB) form;
		formBean.setSearchText(strSearchText);
		
		String target = "displaytariffCode";

		return mapping.findForward(target);
	}
	
	public ActionForward TRFCODEPOPUP1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		String strSearchText = request.getParameter("searchText");
		
		BillingFB formBean = (BillingFB) form;
		formBean.setSearchText(strSearchText);
		//BillingDATA.strTariffNameCombo(request, response, formBean);
		String target = "displaytariffCode1";

		return mapping.findForward(target);
	}
	public ActionForward TARIFFLIST(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response) throws HisException, SQLException 
	{
		BillingFB formBean = (BillingFB) form;
		formBean.setStrMode("0");
		formBean.setHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BillingDATA.initTariffChargeDetails(request, response, formBean);

		return null;
	}
	
	public ActionForward TARIFFCODELIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		
	
		BillingFB formBean = (BillingFB) form;
		formBean.setStrMode("1");
		formBean.setHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BillingDATA.initTariffChargeDetails(request, response, formBean);

		return null;
	}
	public ActionForward TARIFFCODELIST1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		
	
		BillingFB formBean = (BillingFB) form;
		formBean.setStrMode("1");
		formBean.setHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BillingDATA.initTariffChargeDetails1(request, response, formBean);

		return null;
	}
	
	public ActionForward TARIFFCODELIST2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		
	
		BillingFB formBean = (BillingFB) form;
		formBean.setStrMode("1");
		formBean.setHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BillingDATA.initTariffChargeDetails2(request, response, formBean);

		return null;
	}
	public ActionForward TARIFFCODELIST3(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		
	
		BillingFB formBean = (BillingFB) form;
		formBean.setStrMode("1");
		formBean.setHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BillingDATA.initTariffChargeDetails3(request, response, formBean);

		return null;
	}
	
	
	public ActionForward PATIENTLISTING(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String target = "patlist";
       	BillingFB formBean = (BillingFB) form;
		formBean.setHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setUsrArg(request.getParameter("patList"));
		formBean.setUsrFuncName(request.getParameter("usrFuncName"));
		formBean.setDepartmentCode(request.getParameter("deptCode"));
		formBean.setGblCRValue(request.getParameter("gblCRValue"));
		//System.out.println("=============================>>>>>>>>>>>>>>>>>>>>>>>target= "+target);
		return mapping.findForward(target);
	}
	
	public ActionForward FETCHPATIENTLISTING(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		BillingFB formBean = (BillingFB) form;
		BillingDATA.getPatientListingDtls(request, response, formBean);
		
		return null;
	}
	
	public ActionForward FETCHPATIENTLISTINGBS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		BillingFB formBean = (BillingFB) form;
		//BillingDATA.getReceiptDetailsListing(request, response, formBean);
		BillingDATA.getPatientListingDtls_BS(request, response, formBean);
		
		return null;
	}
	public ActionForward FETCHRECEIPTDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		BillingFB formBean = (BillingFB) form;
		BillingDATA.getReceiptDetailsListing(request, response, formBean);
		
		return null;
	}
	public ActionForward RECEIPTDETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String target = "receiptList";
       	BillingFB formBean = (BillingFB) form;
		formBean.setHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setUsrFuncName(request.getParameter("usrFuncName"));
		
		return mapping.findForward(target);
	}
	
	public ActionForward CASHCOLLECTIONPOPUP(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		BillingFB formBean = (BillingFB) form;
		String target="cashCollectionPopup";
		BillingDATA.getCashCollectionDetail(request, response, formBean);
		
		return mapping.findForward(target);
	}
	public ActionForward PACKAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		String strSearchText = request.getParameter("searchText");
		
		BillingFB formBean = (BillingFB) form;
		formBean.setStrCrNo(request.getParameter("strCrNo"));
		formBean.setStrAccNo(request.getParameter("strAcctNo"));
		formBean.setStrPackageId(request.getParameter("strPackageId"));
		//BillingDATA.strTariffNameCombo(request, response, formBean);
		String target = "displayPackagePopup";

		return mapping.findForward(target);
	}
	public ActionForward GETPACKAGEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		
	
		BillingFB formBean = (BillingFB) form;
		formBean.setStrMode("1");
		formBean.setHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		BillingDATA.initPackageDtls(request, response, formBean);

		return null;
	}
	public ActionForward RECEIPTDETAILSBS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String target = "receiptListnew";
       	BillingFB formBean = (BillingFB) form;
		formBean.setHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setUsrFuncName(request.getParameter("usrFuncName"));
		
		return mapping.findForward(target);
	}
	
}
