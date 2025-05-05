package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.utl.BillApprovalDeskTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import mms.MmsConfigUtil;
/**
 * Developer : Deepak Tewari
 * Version : 1.0
 * Date : 02/April/2009
 */

public class BillApprovalDeskTransCNT extends GenericController {
	
	String strtarget;
	/**
	 * calls super class constructor.
	 */
	public BillApprovalDeskTransCNT() 
	{
		
		super(new BillApprovalDeskTransUTL(),"/transactions/BillApprovalDeskTransCNT");
	}

	/**
	 * forwards control to the Bill page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward BILL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		ActionForward acFwd = new ActionForward();
	
		String supplierBillMCU= MmsConfigUtil.SUPPLIER_BILL;
		System.out.println(" --------------- BillApprovalDeskTransCNT.BILL ----------------- ");
		String cmbArr[]=request.getParameterValues("combo");
		String supplierBill=cmbArr[1];
		
		//System.out.println("supplierBill ----------------- "+supplierBill);
		//System.out.println("supplierBillMCU -------------- "+supplierBillMCU);
		
			
		System.out.println(" --------------- /mms/transactions/BillApprovalTransCNT.cnt?hmode=init ----------------- ");
		acFwd.setPath("/mms/transactions/BillApprovalTransCNT.cnt?hmode=init");
		
		
		acFwd.setContextRelative(true);
        return acFwd;
	}
	

	/**
	 * forwards control to the View page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		ActionForward acFwd = new ActionForward();
		
		request.setAttribute("combo", request.getParameterValues("combo"));
		request.setAttribute("comboValue", request.getParameter("comboValue"));
		
		System.out.println(" --------------- BillApprovalDeskTransCNT.VIEW ----------------- ");
		
		String chk=request.getParameter("chk");
		
		System.out.println(" --------------- /mms/transactions/BillApprovalViewTransCNT.cnt?hmode=BILLAPPROVALVIEW&chk="+chk+" ----------------- ");
		
		acFwd.setPath("/mms/transactions/BillApprovalViewTransCNT.cnt?hmode=BILLAPPROVALVIEW&chk="+chk);
        acFwd.setContextRelative(true);
        return acFwd;
	}
	/**
	 * This function is send back control to List Page
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */

	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse _response)
			throws HisException 
	{
		System.out.println(" --------------- BillApprovalDeskTransCNT.CANCELPAGE ----------------- ");
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward PRINT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		System.out.println(" --------------- BillApprovalDeskTransCNT.PRINT ----------------- ");
		
		ActionForward acFwd = new ActionForward();
		request.setAttribute("Path","BillApprovalDeskTransCNT.cnt");
		
		System.out.println(" --------------- /mms/transactions/BillApprovalTransCNT.cnt?hmode=PRINT----------------- ");
		
		acFwd.setPath("/mms/transactions/BillApprovalTransCNT.cnt?hmode=PRINT");
	    acFwd.setContextRelative(true);
        return acFwd;
        
    }

}
