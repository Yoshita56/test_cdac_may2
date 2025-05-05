package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
import mms.transactions.controller.data.SupplierTransactionRecordDATA;
import mms.transactions.controller.fb.SupplierTransactionRecordFB;

public class SupplierTransactionRecordCNT extends CSRFGardTokenAction {
	
String strtarget = "";
	
//	STORE & ITEM CTG COMBO
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		generateToken(request);
		System.out.println("------------SupplierTransactionRecordCNT.unspecified [ supplierTransactionRecord_mms_trans.jsp ]-------------");
		SupplierTransactionRecordFB formBean = (SupplierTransactionRecordFB)form;
		SupplierTransactionRecordDATA.initialStoreItemAdd(formBean,request);
		String target = "index";
		return mapping.findForward(target);
	}
	
//	DATA TABLE PREVIOUS RECORDS
	public void GETDATATABLEONSELECTION(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	{
		SupplierTransactionRecordFB formBean = (SupplierTransactionRecordFB) form;
		SupplierTransactionRecordDATA.getDataTableDataOnSelection(formBean,request,response);
	}
	
// 	DRUG CATEGORY PAGE	
	public ActionForward DRUGINVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SupplierTransactionRecordFB fb = (SupplierTransactionRecordFB) form;
		//this.UPDATESTOCK(mapping, form, request, response); 
		
		System.out.println("------------SupplierTransactionRecordCNT.DRUGINVENTORY [ received_drugInventory_mmstransNEW.jsp ]-------------");
		
		SupplierTransactionRecordDATA.initialDrugAdd(fb, request); // to display the Store
		strtarget = "druginventory";
		return mapping.findForward(strtarget);
	}

//  ITEM CATEGORY PAGE	
	public ActionForward ITEMINVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		SupplierTransactionRecordFB fb = (SupplierTransactionRecordFB) form;
		//this.UPDATESTOCK(mapping, form, request, response);    
		System.out.println("------------SupplierTransactionRecordCNT.ITEMINVENTORY [ received_itemInventory_mmstransNEW.jsp ]-------------");
		
		SupplierTransactionRecordDATA.initialDrugAdd(fb, request); // to display the Store
		strtarget = "itemInventory";
		return mapping.findForward(strtarget);

	}
	
//  INSERT 
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {

		validateToken(request, response);
		System.out.println("------------SupplierTransactionRecordCNT >> .INSERT-------------");

		SupplierTransactionRecordFB formBean = (SupplierTransactionRecordFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		System.out.println("HOSPITAL_CODE "+request.getSession().getAttribute("HOSPITAL_CODE").toString());
		System.out.println("SEATID "+request.getSession().getAttribute("SEATID").toString());
		SupplierTransactionRecordDATA.insert(formBean,request, response);
		String strTarget = "index";
	    return mapping.findForward(strTarget);
//		return this.INITPAGE(mapping, form, request, response);
	}
	
//	STORE CMB & ITEM CMB
	public ActionForward INITPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException 
	{
		generateToken(request);
		System.out.println("------------SupplierTransactionRecordCNT.INITPAGE [ receivedItemDetailsTrans_mmsNEW.jsp ]-------------");
		SupplierTransactionRecordFB formBean = (SupplierTransactionRecordFB)form;
		SupplierTransactionRecordDATA.initialStoreItemAdd(formBean,request);
//		formBean.setStrReceivedItemViewMode("0");
		String target = "index";
		return mapping.findForward(target);
	}
//  VOUCHER 
	public ActionForward PRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
    {
		System.out.println(" ------- SupplierTransactionRecordCNT.PRINT  ------- ");
     
		SupplierTransactionRecordFB formBean = (SupplierTransactionRecordFB) form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		SupplierTransactionRecordDATA.getPrintDetails(formBean, request, response);
		return null;
		/*String strTarget = "printlp";		
		return mapping.findForward(strTarget);*/
	 }
	
	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response) {
			ActionForward acFwd = new ActionForward();
			acFwd.setPath("/mms/transactions/SupplierTransactionRecordCNT.cnt?hmode=unspecified");
			acFwd.setContextRelative(true);
			return acFwd;
	}

}
