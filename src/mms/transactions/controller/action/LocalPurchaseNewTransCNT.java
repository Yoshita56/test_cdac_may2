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
import mms.transactions.controller.data.LocalPurchaseNewTransDATA;
import mms.transactions.controller.fb.LocalPurchaseNewTransFB;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 18/June/2009
 */
public class LocalPurchaseNewTransCNT extends DispatchAction {
	
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

		LocalPurchaseNewTransFB formBean = (LocalPurchaseNewTransFB)form;
		String target;
		formBean.setStrStoreName(request.getParameter("strStoreName").split("\\^")[0]);
		formBean.setStrItemCategoeryName(request.getParameter("strStoreName").split("\\^")[1]);
		formBean.setStrReqTypeId(request.getParameter("strType"));
		//System.out.println("request.getParameter(strType)"+request.getParameter("strType"));
		formBean.setStrStoreId(request.getParameter("storeId"));
		
		LocalPurchaseNewTransDATA.initialAdd(formBean,request);
		
		System.out.println("-------------- LocalPurchaseNewTransCNT.unspecified -- [ LocalPurchaseNew_item_mmstrans.jsp]-----------"+formBean.getStrReqTypeId());
		
		target = "item";
		return mapping.findForward(target);
	}
	
	
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		LocalPurchaseNewTransFB formBean = (LocalPurchaseNewTransFB)form;
	
		LocalPurchaseNewTransDATA.save(formBean,request,response);
		String strTarget = "printlp";
		return mapping.findForward(strTarget);
		//this.PRINT(mapping, formBean, request, response);
	}
	
	
	
	public ActionForward PRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		String strTarget = "printlp";
		LocalPurchaseNewTransFB formBean = (LocalPurchaseNewTransFB)form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		LocalPurchaseNewTransDATA.print(formBean, request, response);
		return mapping.findForward(strTarget);
		
	}
	
	
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/LocalPurchaseDeskCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward ITEMCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {
		System.out.println("-------------- ITEMCOMBO ---------------");
		LocalPurchaseNewTransFB fb = (LocalPurchaseNewTransFB) form;
		LocalPurchaseNewTransDATA.getModelItemList(fb,request, response);

		return null;
	}
	
}
