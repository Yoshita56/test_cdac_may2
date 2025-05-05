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
import mms.transactions.controller.data.AckSuppReceiptDATA;
import mms.transactions.controller.fb.AckSuppReceiptFB;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 18/June/2009
 */
public class AckSuppReceiptCNT extends DispatchAction 
{
	
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

		System.out.println("-- AckSuppReceiptCNT -> unspecified ");
		
		AckSuppReceiptFB formBean = (AckSuppReceiptFB)form;
		String target;
		formBean.setStrStoreName(request.getParameter("strStoreName").split("\\@")[0]);
		formBean.setStrItemCategoeryName(request.getParameter("strStoreName").split("\\@")[1]);
		formBean.setStrReqTypeId(request.getParameter("strType"));
		formBean.setStrStoreId(request.getParameter("storeId"));
		
		String[] Temp     = request.getParameterValues("combo");
		String  strItemCategoryNo  = Temp[1];
	    
		//System.out.println("catgCode-->>"+strItemCategoryNo);
		
		formBean.setStrItemCategoryNo(strItemCategoryNo);
		formBean.setStrLpoNo(request.getParameter("chk").split("\\@")[0]);
		formBean.setStrStoreName(request.getParameter("chk").split("\\@")[1]);
		
		//System.out.println("formBean.getStrLpoNo()-------------------->"+formBean.getStrLpoNo());
		//System.out.println("formBean.getStrStoreId-------------------->"+formBean.getStrStoreId());
		
		
		AckSuppReceiptDATA.initialAdd(formBean,request);
		/*
		if(strItemCategoryNo.equals("10") || strItemCategoryNo.equals("13"))
		{
			System.out.println("<--------- [ AckSuppReceiptCNT . AckSuppReceipt_mmstrans.jsp ] ---------->");
			target = "drug";
		}
		else
		{
			System.out.println("<--------- [ AckSuppReceiptCNT . AckSuppReceipt_item_mmstrans.jsp ] ---------->");
			target = "item";
		}
		*/
		
		System.out.println("<--------- [ AckSuppReceiptCNT . AckSuppReceipt_mmstrans.jsp ] ---------->");
		target = "drug";
		
		System.out.println("target------>"+target);
		return mapping.findForward(target);
	}
	
	
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		AckSuppReceiptFB formBean = (AckSuppReceiptFB)form;
		
		System.out.println("---formBean.getStrMRP()---"+formBean.getStrMRP());
		
		System.out.println("-------AckSuppReceiptCNT.SAVE-----[AckSuppReceipt_print_mmstrans.jsp ]-----");
		
		AckSuppReceiptDATA.save(formBean,request,response);
		
		System.out.println("-------AckSuppReceiptCNT.SAVE---END-------");
		String strTarget = "printlp";		
		return mapping.findForward(strTarget);
		
	}
	
	public ActionForward REJECT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		AckSuppReceiptFB formBean = (AckSuppReceiptFB)form;
		
		
		System.out.println("-------AckSuppReceiptCNT.REJECT----------");
		
		//formBean.setStrStoreName(request.getParameter("strStoreName").split("\\^")[0]);
		//formBean.setStrItemCategoeryName(request.getParameter("strStoreName").split("\\^")[1]);
		formBean.setStrReqTypeId(request.getParameter("strType"));
		formBean.setStrStoreId(request.getParameter("storeId"));
		
		formBean.setStrLpoNo(request.getParameter("chk").split("\\@")[0]);
		formBean.setStrStoreName(request.getParameter("chk").split("\\@")[1]);
		
		formBean.setStrRemarks(request.getParameter("chk").split("\\^")[1]);
		
		System.out.println("CHk------------------------>"+request.getParameter("chk"));
		
		//10222200005@10201121@27916$1^Cancel By Amit
		
		System.out.println("formBean.getStrRemarks()------------------------>"+formBean.getStrRemarks());		
		System.out.println("formBean.getStrLpoNo()------------------------>"+formBean.getStrLpoNo());
		System.out.println("formBean.getStrStoreId------------------------>"+formBean.getStrStoreId());
		
		
		AckSuppReceiptDATA.REJECT(formBean,request,response);
		
		System.out.println("-------AckSuppReceiptCNT.REJECT---END-------");
		return this.CANCELTODESK(mapping, formBean, request, response);
		
	}
	
	
	
	public ActionForward PRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		System.out.println("-------AckSuppReceiptCNT.PRINT-----[ AckSuppReceipt_print_mmstrans.jsp ]-----");
		
		String strTarget = "printlp";
		AckSuppReceiptFB formBean = (AckSuppReceiptFB)form;
		String[] Temp     = request.getParameterValues("combo");
		String  strItemCategoryNo  = Temp[1];	    		
		//System.out.println("catgCode-->>"+strItemCategoryNo);	
		
		formBean.setStrItemCategoryNo(strItemCategoryNo);
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		AckSuppReceiptDATA.print(formBean, request, response);
		return mapping.findForward(strTarget);
		
	}
	
	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
		System.out.println("-------AckSuppReceiptCNT.MODIFY-----[ AckSupplierReceipt_modify_trans.jsp ]-----");
		
		String strTarget = "modify";
		AckSuppReceiptFB formBean = (AckSuppReceiptFB)form;
		String[] Temp     = request.getParameterValues("combo");
		String  strItemCategoryNo  = Temp[1];		
		formBean.setStrItemCategoryNo(strItemCategoryNo);
		formBean.setStrStoreId(Temp[0]);
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		AckSuppReceiptDATA.getModify_Details(formBean, request, response);
		return mapping.findForward(strTarget);
		
	}
	
	public ActionForward MODIFY_SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {

		AckSuppReceiptFB formBean = (AckSuppReceiptFB)form;
		
		System.out.println("---formBean.getStrMRP()---"+formBean.getStrMRP());
		
		System.out.println("-------AckSuppReceiptCNT.MODIFY_SAVE-----[AckSuppReceipt_print_mmstrans.jsp ]-----");
		
		AckSuppReceiptDATA.modifySave(formBean,request,response);
		
		System.out.println("-------AckSuppReceiptCNT.MODIFY_SAVE---END-------");
		String strTarget = "printlp";		
		return mapping.findForward(strTarget);
		
	}
	
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) 
	{
			
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/AckSuppReceiptDeskCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	

}
