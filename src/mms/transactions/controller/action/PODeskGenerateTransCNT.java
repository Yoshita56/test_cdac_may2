/**
 * 
 */
package mms.transactions.controller.action;

import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.PODeskGenerateTransDATA;
import mms.transactions.controller.fb.PODeskGenerateTransFB;

/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
  public class PODeskGenerateTransCNT extends CSRFGardTokenAction   {
	
	  
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/PODeskTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	
	public ActionForward CANCELTOAPPROVALDESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/POApprovalDeskCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}


	public ActionForward GENERATE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		generateToken(_request);
		System.out.println("------------- PODeskGenerateTransCNT.GENERATE -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.setItemCatValues(poDeskGenerateTransFB, _request);
		PODeskGenerateTransDATA.setPurchaseSourceValues(poDeskGenerateTransFB, _request);
		PODeskGenerateTransDATA.setDeliveryLocationValues(poDeskGenerateTransFB, _request);
		PODeskGenerateTransDATA.setCurrencyValues(poDeskGenerateTransFB, _request);
		
		ResourceBundle resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
		
		//MmsConfigUtil mmscofigutil = new  MmsConfigUtil();				
		poDeskGenerateTransFB.setStrSDFFlgColor("pink");
		
		return _mapping.findForward("generate");
	}
	
	public ActionForward POMODIFY(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		generateToken(_request);
		
		 System.out.println("------------- PODeskGenerateTransCNT.POMODIFY -----------------");
		 
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.setItemCatValues(poDeskGenerateTransFB, _request);
		PODeskGenerateTransDATA.setPurchaseSourceValues(poDeskGenerateTransFB, _request);
		PODeskGenerateTransDATA.setDeliveryLocationValues(poDeskGenerateTransFB, _request);
		PODeskGenerateTransDATA.setCurrencyValues(poDeskGenerateTransFB, _request);
		PODeskGenerateTransDATA.getRequestModifyItemDetails(poDeskGenerateTransFB, _request, _response);
		ResourceBundle resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
		
		//MmsConfigUtil mmscofigutil = new  MmsConfigUtil();				
		poDeskGenerateTransFB.setStrSDFFlgColor("pink");
		
		return _mapping.findForward("pomodify");
	}
	public ActionForward GETPOTYPEVALUES(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		System.out.println("------------- PODeskGenerateTransCNT.GETPOTYPEVALUES -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.setPOTypeValues(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	public ActionForward GETSUPPLIERVALUES(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		
		System.out.println("------------- PODeskGenerateTransCNT.GETSUPPLIERVALUES -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.setSupplierValues(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	public ActionForward GETAGENTNAMEVALUES(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		System.out.println("------------- PODeskGenerateTransCNT.GETAGENTNAMEVALUES -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.setAgentNameValues(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	public ActionForward REQUESTDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		System.out.println("------------- PODeskGenerateTransCNT.REQUESTDETAILS -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getRequestDetails(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	public ActionForward GETREQUESTITEMDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		System.out.println("------------- PODeskGenerateTransCNT.GETREQUESTITEMDETAILS -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getRequestItemDetails(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	public ActionForward GETCOMPONENTDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		System.out.println("------------- PODeskGenerateTransCNT.GETCOMPONENTDETAILS -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getComponentDetail(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	public ActionForward INDENTPOPUPDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		System.out.println("------------- PODeskGenerateTransCNT.INDENTPOPUPDETAILS -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getIndentPopupDetails(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	public ActionForward INSERT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws Exception {
		validateToken(_request, _response);
		System.out.println("------------- PODeskGenerateTransCNT.INSERT -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.insert(poDeskGenerateTransFB, _request);
		//return CANCELTODESK(_mapping, _form, _request, _response);
		return _mapping.findForward("generate");
	}
	
	
	public ActionForward APPROVAL(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		generateToken(_request);
		System.out.println("------------- PODeskGenerateTransCNT.APPROVAL -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getScheduleDetails(poDeskGenerateTransFB, _request);  // PO Item List
		PODeskGenerateTransDATA.getPOItemDetails(poDeskGenerateTransFB, _request,_response);  // PO Item List
		//PODeskGenerateTransDATA.setItemCatValues1(poDeskGenerateTransFB, _request);		
		//PODeskGenerateTransDATA.setPurchaseSourceValues(poDeskGenerateTransFB, _request);
		return _mapping.findForward("poApproval");
	}
	
	
	public ActionForward VIEWAPPROVALPO(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		generateToken(_request);
		System.out.println("------------- PODeskGenerateTransCNT.VIEWAPPROVALPO -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getScheduleDetails(poDeskGenerateTransFB, _request);  // PO Item List
		PODeskGenerateTransDATA.setItemCatValues1(poDeskGenerateTransFB, _request);
		//PODeskGenerateTransDATA.setPurchaseSourceValues(poDeskGenerateTransFB, _request);
		return _mapping.findForward("viewWithApprovalItem");
	}
	
	
	public ActionForward APPROVEDPO(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		generateToken(_request);
		System.out.println("------------- PODeskGenerateTransCNT.APPROVEDPO -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.approvedPO(poDeskGenerateTransFB, _request);
		//return CANCELTODESK(_mapping, _form, _request, _response);
		if(poDeskGenerateTransFB.getStrMsgType().equals("1"))
		{
			return this.GENERATEITEMWISE(_mapping, _form, _request, _response);
		}
		else
		{
			return this.CANCELTOPOAPPROVALDESK(_mapping, _form, _request, _response);
		}
	}
	
	
	public ActionForward CANCELTOPOAPPROVALDESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/POApprovalDeskCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public ActionForward GENERATEITEMWISE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		generateToken(_request);
		System.out.println("------------- PODeskGenerateTransCNT.GENERATEITEMWISE -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.setItemCatValues(poDeskGenerateTransFB, _request);
		PODeskGenerateTransDATA.setPurchaseSourceValues(poDeskGenerateTransFB, _request);
		PODeskGenerateTransDATA.getManufactrerValues(poDeskGenerateTransFB, _request);
	    PODeskGenerateTransDATA.getFinancialYearCombo(poDeskGenerateTransFB, _request);
	    PODeskGenerateTransDATA.getSupplierValues(poDeskGenerateTransFB, _request, _response);
		
		
		return _mapping.findForward("generatewithItem");
	}
	
	public ActionForward GETUNITVALUE1(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		System.out.println("------------- PODeskGenerateTransCNT.GETUNITVALUE1 -----------------");
		 PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getUnitValues1(poDeskGenerateTransFB, _request,_response);		
		return null;
	}
	
	public ActionForward GETDWHPOHLP(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		System.out.println("------------- PODeskGenerateTransCNT.GETDWHPOHLP -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getPOHLP(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	
	public ActionForward GETDWHPOHLP1(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		
		System.out.println("------------- PODeskGenerateTransCNT.GETDWHPOHLP1 -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getPOHLP1(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	/*
	 * This Method is Used to get PO Detial for DDW wise
	 * in both PO modify and PO View After Pressing Go button
	 * */
	public ActionForward GETDWHPOHLP2(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		System.out.println("------------- PODeskGenerateTransCNT.GETDWHPOHLP2 -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getPOHLP2(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	/*
	 * This Method is Used to get PO Detial for DDW wise
	 * in both PO modify and PO View After Pressing Go button
	 * */
	public ActionForward GETDWHPOHLP3(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		System.out.println("------------- PODeskGenerateTransCNT.GETDWHPOHLP3 -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getPOHLP3(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	public ActionForward GETITEMDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		
		System.out.println("------------- PODeskGenerateTransCNT.GETITEMDETAILS -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getItemDetails(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	public ActionForward ADDSUPPLIER(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		System.out.println("------------- PODeskGenerateTransCNT.ADDSUPPLIER -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getSupplierDetails(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	public ActionForward SUPPLIERWISECOMPILATION(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		System.out.println("------------- PODeskGenerateTransCNT.SUPPLIERWISECOMPILATION -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.getSupplierWiseCompiledData(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	public ActionForward INDENTNODETAIL(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		System.out.println("------------- PODeskGenerateTransCNT.INDENTNODETAIL -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.indentDetail(poDeskGenerateTransFB, _request, _response);
		return null;
	}
	
	public ActionForward INSERTDRAFT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws Exception {
		System.out.println("------------- PODeskGenerateTransCNT.INSERTDRAFT -----------------");
		validateToken(_request, _response);
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.insertDraft(poDeskGenerateTransFB, _request);
		//return _mapping.findForward("generate");
		return _mapping.findForward("draft1");
		//return CANCELTODESK(_mapping, _form, _request, _response);
	}
	
	public ActionForward INSERTMODIFYDRAFT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws Exception {
		validateToken(_request, _response);
		System.out.println("------------- PODeskGenerateTransCNT.INSERTMODIFYDRAFT -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.INSERTMODIFYDRAFT(poDeskGenerateTransFB, _request);
		//return _mapping.findForward("pomodify");
		return _mapping.findForward("draft1");
		//return CANCELTODESK(_mapping, _form, _request, _response);
	}
	
	public ActionForward FINALIZEPO(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		generateToken(_request);
		System.out.println("------------- PODeskGenerateTransCNT.FINALIZEPO -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.finalizePO(poDeskGenerateTransFB, _request,_response);
		return _mapping.findForward("draft");
	}
	
	public ActionForward FINALSAVE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException ,Exception {
		validateToken(_request, _response);
		System.out.println("------------- PODeskGenerateTransCNT.FINALSAVE -----------------");
		PODeskGenerateTransFB poDeskGenerateTransFB = (PODeskGenerateTransFB)_form;
		PODeskGenerateTransDATA.finalsave(poDeskGenerateTransFB, _request);
		//return CANCELTODESK(_mapping, _form, _request, _response);
		return _mapping.findForward("draft1");
	}
	

}
