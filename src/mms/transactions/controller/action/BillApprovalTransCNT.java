package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.transactions.controller.data.BillApprovalTransDATA;
import mms.transactions.controller.fb.BillApprovalTransFB;

/**
 * Developer : Tanvi Sappal
 * Version : 1.0
 * Date : 02/April/2009
 */

public class BillApprovalTransCNT extends DispatchAction {
	
		
	
	/** This method is used to forward the request on first jsp page
	 * And calls the methods getInitialValues() which is define in SupplierReturnReqTransDATA java file. AND LIST VALUES to display combos 
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
	throws HisException, SQLException 
	{
		String strTarget = "billVerify";
		String temp[]=null;
						
		System.out.println(" --------------- BillApprovalTransCNT.init ---------------- ");
		
		
		BillApprovalTransFB formBean = (BillApprovalTransFB) form;
		
		if(request.getParameter("comboValue")!=null)
		{
			String comboValue[] = request.getParameter("comboValue").replace('^', '#').split("#");
			String strStoreName    = comboValue[0];
			String strSupplierName   = comboValue[1];
			String strBillTypeName = comboValue[2];
			/* 
			 *  hstt_invoicetype_mst			
			 *  
			 * 10 - Bulk PO
			 * 11 - Local PO
			 * 12 - Supplier Receipt
			 * 
			 * */
			String strComboValues[] = request.getParameterValues("combo");
			formBean.setStrStoreName(strStoreName);
			formBean.setStrSupplierName(strSupplierName);		
			formBean.setStrBillTypeName(strBillTypeName);				
			formBean.setStrStoreId(strComboValues[0]);
			formBean.setStrSupplierId(strComboValues[1]);
			formBean.setStrBillType(strComboValues[2]);
			/*
			if(request.getParameter("chk")!=null)
			{
			    String chk = request.getParameter("chk");
			    formBean.setStrChk1(chk);
			}
			
			System.out.println(" ------formBean.getStrChk1()--[ INVOICE_NO_LIST @ PO_NO @ INVOICE_TYPE_ID @ SUPPLIER_ID @ INVOICE_STATUS @ PO_STORE_ID]--- "+formBean.getStrChk1());
			
			temp = formBean.getStrChk1().replace("@", "#").split("#");
			
			formBean.setStrPONo(temp[1]);
			*/
			
		}	
		if(formBean.getStrBillType().equals("12"))
		{
			strTarget = "supp_recep_billVerify";
			System.out.println(" ---------------[ supp_recep_bill_approval_trans.jsp , billApprovalTrans.js ]---------------- ");
		}
		if(formBean.getStrBillType().equals("10"))
		{
			System.out.println(" ---------------[ bill_approval_trans.jsp , billApprovalTrans.js]---------------- ");
			strTarget = "billVerify";
		}
		BillApprovalTransDATA.getInitialValues(formBean,request);
		return mapping.findForward(strTarget);
	}	
	

	/** This method is used to display the value of item details  for this
	 *  calls the methods getItemDetails() which is define in SupplierReturnReqTransDATA java file. .
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward GET_PO_DETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception, SQLException 
	{
		System.out.println(" --------------- BillApprovalTransCNT.GET_PO_DETAILS -[ bill_approval_trans.jsp ]---------------- ");
		
		String strTarget = "billVerify";
		BillApprovalTransFB formBean = (BillApprovalTransFB) form;
	    if(formBean.getStrBillType().equals("10"))
	    {	
	    	
		    BillApprovalTransDATA.getPODetails(formBean,request,response);
	    }
	    if(formBean.getStrBillType().equals("11"))
	    {
	    	
	    	BillApprovalTransDATA.getLPPODetails(formBean,request,response);
	    }
	    if(formBean.getStrBillType().equals("12"))
	    {
	    	
	    	BillApprovalTransDATA.getSupp_Rec_Details(formBean,request,response);
	    }
	    
	    if(formBean.getStrBillType().equals("12"))
		{
			strTarget = "supp_recep_billVerify";
			System.out.println(" ---------------[ supp_recep_bill_approval_trans.jsp , billApprovalTrans.js ]---------------- ");
		}
		if(formBean.getStrBillType().equals("10") || formBean.getStrBillType().equals("11"))
		{
			System.out.println(" ---------------[ bill_approval_trans.jsp , billApprovalTrans.js]---------------- ");
			strTarget = "billVerify";
		}
		return mapping.findForward(strTarget);
	}
	
	/** This method is used to display the value of item details  for this
	 *  calls the methods getItemDetails() which is define in SupplierReturnReqTransDATA java file. .
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward PRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception, SQLException 
	{
		System.out.println(" --------------- BillApprovalTransCNT.PRINT -[ bill_print_trans.jsp ]---------------- ");
		String temp[]=null;
		
		String strTarget = "billPrint";
		BillApprovalTransFB formBean = (BillApprovalTransFB) form;				
		BillApprovalTransDATA.PO_PaymentPrint_New(formBean,request,response);
		return mapping.findForward(strTarget);
	}
	
	public ActionForward ScheduleItemDtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception, SQLException 
	{
		System.out.println(" --------------- BillApprovalTransCNT.ScheduleItemDtls ----------------- ");
		
		BillApprovalTransFB formBean = (BillApprovalTransFB) form;
		BillApprovalTransDATA.getScheduleItemDtls(formBean,request,response);
		return null;
	}
	/**
	 * This function forward control List pop up window
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward LIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		//String strTarget = "list";
	//	BillApprovalTransFB formBean = (BillApprovalTransFB) form;
		return mapping.findForward("list");
	}
	 
	   /**
		 * This function forward control List pop up window
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		public ActionForward LISTDTL(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {
			
			BillApprovalTransFB formBean = (BillApprovalTransFB) form;
			////System.out.println("in CNT");
			BillApprovalTransDATA.initSearchList(formBean, request,response);
			return null;
		}
		
		public ActionForward INSERT(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {

			System.out.println(" --------------- BillApprovalTransCNT.INSERT ----------------- ");
			
			BillApprovalTransFB fb = (BillApprovalTransFB) form;
			fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			BillApprovalTransDATA.insert(fb, request, response);
			fb.setStrPONo("");
			return init(mapping, form, request, response);
		}
		
		public ActionForward INSERT_NEW(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {

			System.out.println(" --------------- BillApprovalTransCNT.INSERT_NEW ----------------- ");
			
			BillApprovalTransFB fb = (BillApprovalTransFB) form;
			fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			BillApprovalTransDATA.insert_new(fb, request, response);
			fb.setStrPONo("");
			return init(mapping, form, request, response);
		}
	
		public ActionForward CLEAR(ActionMapping _mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)throws HisException, SQLException 
		{
			BillApprovalTransFB fb = (BillApprovalTransFB) form;
			
			fb.setStrNormalMsg("");
			fb.setStrPONo("");
			return this.init(_mapping, form, request, response);
		}
				
		
		/** This method is used to cancel the Process.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	
		public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException {
			ActionForward acFwd = new ActionForward();
			acFwd.setPath("/mms/transactions/BillApprovalDeskTransCNT.cnt?hmode=unspecified");
			acFwd.setContextRelative(true);
			return acFwd;
		}
		
		public ActionForward PENELTYDTL(ActionMapping _mapping, ActionForm form,
		HttpServletRequest request, HttpServletResponse response)
		throws HisException {
			
			System.out.println(" --------------- BillApprovalTransCNT.PENELTYDTL ----------------- ");
			BillApprovalTransFB formBean = (BillApprovalTransFB) form;
			BillApprovalTransDATA.getPeneltyDtl(formBean, request, response);
			return null;
		}
		
	
}
