/**
 * 
 */
package mms.transactions.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.transactions.controller.data.SupplierReceiptDATA;
import mms.transactions.controller.fb.SupplierReceiptFB;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 18/June/2009
 */
public class SupplierReceiptCNT extends DispatchAction {
	
	/**
	 * To display the Item Category Name on the Screen.
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
			throws HisException {

		SupplierReceiptFB formBean = (SupplierReceiptFB)form;
		String target;
				
		formBean.setStrStoreName(request.getParameter("strStoreName").split("\\@")[0]);
		formBean.setStrItemCategoeryName(request.getParameter("strStoreName").split("\\@")[1]);
		formBean.setStrReqTypeId(request.getParameter("strType"));
		
		System.out.println("------- CATGCODE -----"+request.getParameter("strType"));
		
		formBean.setStrStoreId(request.getParameter("storeId"));
		
		SupplierReceiptDATA.initialAdd(formBean,request);
		/*
		if(formBean.getStrReqTypeId().equals("10") || formBean.getStrReqTypeId().equals("13"))
		{
			System.out.println("-------------- SupplierReceiptCNT.unspecified -- [ SupplierReceipt_mmstrans.jsp ]-----------"+formBean.getStrReqTypeId());
			target = "drug";
		}
		else
		{	
			
			System.out.println("-------------- SupplierReceiptCNT.unspecified -- [ SupplierReceipt_item_mmstrans.jsp ]-----------"+formBean.getStrReqTypeId());
			target = "item";
		}
		*/
		System.out.println("-------------- SupplierReceiptCNT.unspecified -- [ SupplierReceipt_mmstrans.jsp , LocalPurchaseNew_item_mmstrans.js ]-----------"+formBean.getStrReqTypeId());
		target = "drug";
		return mapping.findForward(target);
	}
	
	
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		SupplierReceiptFB formBean = (SupplierReceiptFB)form;
		
		/*
		 * System.out.println("getstrInstituteId--------------->"
		 * +formBean.getstrInstituteId());
		 * System.out.println("getStrSupplier--------------->"
		 * +formBean.getStrSupplier());
		 * System.out.println("getgetStrDCNo--------------->" +formBean.getStrDCNo());
		 * System.out.println("getStrInvoiceNo--------------->"
		 * +formBean.getStrInvoiceNo());
		 * System.out.println("getStrLpoNo--------------->" +formBean.getStrLpoNo());
		 */
		
		
		SupplierReceiptDATA.save(formBean,request,response);
		String strTarget = "printlp";
		return mapping.findForward(strTarget);
		//this.PRINT(mapping, formBean, request, response);
	}
	
	
	
	public ActionForward PRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		String strTarget = "printlp";
		SupplierReceiptFB formBean = (SupplierReceiptFB)form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SupplierReceiptDATA.print(formBean, request, response);
		return mapping.findForward(strTarget);
		
	}
	
	
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
	/*	ActionForward acFwd = new ActionForward();
		acFwd.setPath("/startup/initPage.jsp");
		acFwd.setContextRelative(true);*/
	//	return acFwd;
	//	return this.LIST(mapping, form, request, response);
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/SupplierReceiptDeskCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	//String strPrintHLP=LocalPurchaseNewTransHLP.getPrintDtl(vo);
	////formBean.setStrPrintDtls(strPrintHLP);
	//formBean.setStrPrintFlag("1");
}
