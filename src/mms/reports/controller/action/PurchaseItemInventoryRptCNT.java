package mms.reports.controller.action;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.reports.controller.data.PurchaseItemInventoryRptDATA;
import mms.reports.controller.fb.PurchaseItemInventoryRptFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class PurchaseItemInventoryRptCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.init(mapping, form, request, response);
		
	}
	
	/** This method is used to forward the request on first jsp page
	 * And calls the methods getInitialValues() which is define in PendingListAgendaRptDATA java file. AND LIST VALUES to display combos 
	 * on first page. 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * 
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			 
	{
		String strTarget = null;
		try
		{
		System.out.println("--------------- START ------------------");
		
		PurchaseItemInventoryRptFB formBean = (PurchaseItemInventoryRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		PurchaseItemInventoryRptDATA.initDetails(formBean,request);
		 strTarget = "purchaseItemInventory";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//PurchaseItemInventoryRptDATA.getStoreList(formBean,request);
				
		System.out.println("---------------- END -----------------");
		return mapping.findForward(strTarget);
	}
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		PurchaseItemInventoryRptFB formBean = (PurchaseItemInventoryRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		PurchaseItemInventoryRptDATA.getItemCatList(formBean,request, response);
		
		return null;
	}
	
	public ActionForward POTYPECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		PurchaseItemInventoryRptFB formBean = (PurchaseItemInventoryRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		PurchaseItemInventoryRptDATA.getPOTypeList(formBean,request, response);
		
		return null;
	}
	
	public ActionForward SUPPLIERCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		PurchaseItemInventoryRptFB formBean = (PurchaseItemInventoryRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		PurchaseItemInventoryRptDATA.getSupplierList(formBean,request, response);
		
		return null;
	}
	
	public ActionForward SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		PurchaseItemInventoryRptFB formBean = (PurchaseItemInventoryRptFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		PurchaseItemInventoryRptDATA.showReport(formBean, request, response);
		
		String strTarget = null;
		strTarget = "purchaseItemInventoryReport";
		

		return mapping.findForward(strTarget);
		
		
	}
	
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
	    ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public ActionForward Back(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		return this.init(mapping, form, request, response);
		
	}
}
