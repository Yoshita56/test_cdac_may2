package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.PODeskGenerateTransNewDATA;
import mms.transactions.controller.fb.PODeskGenerateTransNewFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class PODeskGenerateTransNewCNT extends DispatchAction {
	
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/PODeskTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public ActionForward GENERATE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.setItemCatValues(PODeskGenerateTransNewFB, _request);
		PODeskGenerateTransNewDATA.getFinancialYearCombo(PODeskGenerateTransNewFB,_request);
		PODeskGenerateTransNewDATA.setPurchaseSourceValues(PODeskGenerateTransNewFB, _request);
		PODeskGenerateTransNewDATA.setDeliveryLocationValues(PODeskGenerateTransNewFB, _request);
		PODeskGenerateTransNewDATA.setCurrencyValues(PODeskGenerateTransNewFB, _request);
		
		return _mapping.findForward("generate");
	}
	
	public ActionForward GENERATEITEMWISE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.setItemCatValues(PODeskGenerateTransNewFB, _request);
		PODeskGenerateTransNewDATA.setPurchaseSourceValues(PODeskGenerateTransNewFB, _request);
		PODeskGenerateTransNewDATA.getManufactrerValues(PODeskGenerateTransNewFB, _request);
	    PODeskGenerateTransNewDATA.getFinancialYearCombo(PODeskGenerateTransNewFB, _request);
	    PODeskGenerateTransNewDATA.getSupplierValues(PODeskGenerateTransNewFB, _request, _response);
		
		
		return _mapping.findForward("generatewithItem");
	}
	
	
	public ActionForward MODIFY(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getScheduleDetails(PODeskGenerateTransNewFB, _request);  // PO Item List
		PODeskGenerateTransNewDATA.setItemCatValues1(PODeskGenerateTransNewFB, _request);
		PODeskGenerateTransNewDATA.setPurchaseSourceValues(PODeskGenerateTransNewFB, _request);
		return _mapping.findForward("modifyWithItem");
	}
	
	public ActionForward VIEWPO(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getScheduleDetails(PODeskGenerateTransNewFB, _request);  // PO Item List
		PODeskGenerateTransNewDATA.setItemCatValues1(PODeskGenerateTransNewFB, _request);
		//PODeskGenerateTransNewDATA.setPurchaseSourceValues(PODeskGenerateTransNewFB, _request);
		return _mapping.findForward("viewWithItem");
	}
	
	
	public ActionForward GETPOITEMLIST(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		    PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
			PODeskGenerateTransNewDATA.getPOItemList(PODeskGenerateTransNewFB, _request,_response);
			return null;
	}
	
	public ActionForward GETUNITVALUE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		 PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getUnitValues(PODeskGenerateTransNewFB, _request,_response);		
		return null;
	}
	
	public ActionForward GETUNITVALUE1(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		 PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getUnitValues1(PODeskGenerateTransNewFB, _request,_response);		
		return null;
	}
	
	public ActionForward GETDWHPOHLP(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getPOHLP(PODeskGenerateTransNewFB, _request, _response);
		return null;
	}
	
	
	public ActionForward GETDWHPOHLP1(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getPOHLP1(PODeskGenerateTransNewFB, _request, _response);
		return null;
	}
	/*
	 * This Method is Used to get PO Detial for DDW wise
	 * in both PO modify and PO View After Pressing Go button
	 * */
	public ActionForward GETDWHPOHLP2(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getPOHLP2(PODeskGenerateTransNewFB, _request, _response);
		return null;
	}
	/*
	 * This Method is Used to get PO Detial for DDW wise
	 * in both PO modify and PO View After Pressing Go button
	 * */
	public ActionForward GETDWHPOHLP3(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getPOHLP3(PODeskGenerateTransNewFB, _request, _response);
		return null;
	}
	
	public ActionForward GETPOTYPEVALUES(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.setPOTypeValues(PODeskGenerateTransNewFB, _request, _response);
		return null;
	}
	
	public ActionForward GETSUPPLIERVALUES(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.setSupplierValues(PODeskGenerateTransNewFB, _request, _response);
		return null;
	}
	
	public ActionForward GETAGENTNAMEVALUES(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.setAgentNameValues(PODeskGenerateTransNewFB, _request, _response);
		return null;
	}
	
	public ActionForward REQUESTDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getRequestDetails(PODeskGenerateTransNewFB, _request, _response);
		return null;
	}
	
	public ActionForward SUPPLIERFOREIGNFLAG(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException 
	{
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getSupplierForeignFlag(PODeskGenerateTransNewFB, _request, _response);
		return null;
	}
	
	public ActionForward GETREQUESTITEMDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getRequestItemDetails(PODeskGenerateTransNewFB, _request, _response);
		return null;
	}
	
	public ActionForward GETCOMPONENTDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getComponentDetail(PODeskGenerateTransNewFB, _request, _response);
		return null;
	}
	
	public ActionForward INDENTPOPUPDETAILS(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.getIndentPopupDetails(PODeskGenerateTransNewFB, _request, _response);
		return null;
	}
	
	
	public ActionForward INSERTNEWPO(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.insertNewPO(PODeskGenerateTransNewFB, _request);
		
		if(PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
		{
			return this.GENERATEITEMWISE(_mapping, _form, _request, _response);
		}
		else
		{
			return this.CANCELTODESK(_mapping, _form, _request, _response);
		}
		
		//return GENERATEITEMWISE(_mapping, _form, _request, _response);
	}
	
	public ActionForward UPDATEPO(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.updateNewPO(PODeskGenerateTransNewFB, _request);
		//return CANCELTODESK(_mapping, _form, _request, _response);
		if(PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
		{
			return this.GENERATEITEMWISE(_mapping, _form, _request, _response);
		}
		else
		{
			return this.CANCELTODESK(_mapping, _form, _request, _response);
		}
	}
	
	
	public ActionForward INSERT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
		PODeskGenerateTransNewDATA.insert(PODeskGenerateTransNewFB, _request);
		return CANCELTODESK(_mapping, _form, _request, _response);
	}
	
	
	
		
		public ActionForward CANCELTOAPPROVALDESK(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException 
		{
			ActionForward acFwd = new ActionForward();
			acFwd.setPath("/mms/transactions/POApprovalDeskCNT.cnt?hmode=unspecified");
			acFwd.setContextRelative(true);
			return acFwd;
		}

		
		
		
		public ActionForward APPROVAL(ActionMapping _mapping, ActionForm _form,
				HttpServletRequest _request, HttpServletResponse _response)
				throws HisException 
		{
			PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
			PODeskGenerateTransNewDATA.getScheduleDetails(PODeskGenerateTransNewFB, _request);  // PO Item List
			PODeskGenerateTransNewDATA.setItemCatValues1(PODeskGenerateTransNewFB, _request);		
			//PODeskGenerateTransNewDATA.setPurchaseSourceValues(PODeskGenerateTransNewFB, _request);
			return _mapping.findForward("poApproval");
		}
		
		
		public ActionForward VIEWAPPROVALPO(ActionMapping _mapping, ActionForm _form,
				HttpServletRequest _request, HttpServletResponse _response)
				throws HisException 
		{
			PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
			PODeskGenerateTransNewDATA.getScheduleDetails(PODeskGenerateTransNewFB, _request);  // PO Item List
			PODeskGenerateTransNewDATA.setItemCatValues1(PODeskGenerateTransNewFB, _request);
			//PODeskGenerateTransNewDATA.setPurchaseSourceValues(PODeskGenerateTransNewFB, _request);
			return _mapping.findForward("viewWithApprovalItem");
		}
		
		
		public ActionForward APPROVEDPO(ActionMapping _mapping, ActionForm _form,
				HttpServletRequest _request, HttpServletResponse _response)
				throws HisException {
			PODeskGenerateTransNewFB PODeskGenerateTransNewFB = (PODeskGenerateTransNewFB)_form;
			PODeskGenerateTransNewDATA.approvedPO(PODeskGenerateTransNewFB, _request);
			//return CANCELTODESK(_mapping, _form, _request, _response);
			if(PODeskGenerateTransNewFB.getStrMsgType().equals("1"))
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

}
