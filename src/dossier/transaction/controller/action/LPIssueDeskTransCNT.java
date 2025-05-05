/**
Author Anurudra Goel
DATE 10-June-2009
**/

package dossier.transaction.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dossier.transaction.controller.data.LPIssueDeskTransDATA;
import dossier.transaction.controller.fb.LPIssueDeskTransFB;
import dossier.transaction.controller.util.LPIssueDeskTransUTL;

public class LPIssueDeskTransCNT extends GenericController {

	public LPIssueDeskTransCNT() {
		super(new LPIssueDeskTransUTL(), "/transaction/LPIssueDeskTransCNT");
	}

	
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ISSUE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		System.out.println("<<<--------------LPIssueDeskTransCNT . ISSUE---------------->>>");
		
		ActionForward acFwd = new ActionForward();
		String[] Temp    = request.getParameterValues("combo");
		String storeName = request.getParameter("cmbVal");
		String[] arr  = Temp[1].split("\\^");
	    String cmb  = arr[0];
	    String str = Temp[0];
	    
	    System.out.println("<<<--------------Request Type ---------------->>>"+cmb);
	    
	    if(cmb.equals("31")) //Issue to store 
	    {
	    	acFwd.setPath("/mms/transactions/IssueDeskTransCNT.cnt?hmode=ISSUE");
	    	acFwd.setContextRelative(true);
	        return acFwd;
	    }
	    else
		if(cmb.equals("32")) // Issue to patient (OPD)
		{
			System.out.println("Store Name----->>>"+storeName);
			System.out.println("Store Id----->>>"+Temp[0]);
			System.out.println("Req type----->>>"+Temp[1]);
			System.out.println("Status----->>>"+Temp[2]);
		    acFwd.setPath("/mms/transactions/IssueTransCNT.cnt?hmode=unspecified&strMode=0&strStoreId="+str+"^"+storeName);
		    acFwd.setContextRelative(true);
	        return acFwd;
		}	
		else
		{
			
			System.out.println("<<<--------------LPIssueDeskTransCNT . ISSUE-----[ add_LpIssueDtlTrans.jsp ]----------->>>");
			
			LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
			LPIssueDeskTransDATA.getInitDetailForIssuePage(formBean, request);
			formBean.setStrUCReq("0");
			String strtarget = "issue";
			return mapping.findForward(strtarget);
		}
		
			
			

	}
	
	public ActionForward SETTLEMENT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ActionForward acFwd = new ActionForward();
		String[] Temp = request.getParameterValues("combo");
		String[] arr  = Temp[1].split("\\^");
	    String cmb  = arr[0];
	    String str = Temp[0];
		System.out.println("----------------DossierDeskTransCNT.SETTLEMENT-----[/dossier/transaction/DossierSettlementCNT.cnt?hmode=NEW]-------------");
		
	    acFwd.setPath("/dossier/transaction/DossierSettlementCNT.cnt?hmode=NEW&servicetypeId="+Temp[0]);
    	acFwd.setContextRelative(true);
        return acFwd;
	   
		
			
			

	}
	
	public ActionForward  RETURNTOMAINDESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws HisException, SQLException 
	{
		
		return this.LIST(mapping, form, request, response);
	}
	
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
		System.out.println("<<<--------------LPIssueDeskTransCNT . INSERT---------------->>>");
		LPIssueDeskTransDATA.insertData(formBean, request);
		
		System.out.println("<<<--------------LPIssueDeskTransCNT . afterIssueSave() -- [ add_LpIssueDtlTrans.jsp ]-------------->>>");
		
		LPIssueDeskTransDATA.afterIssueSave(formBean, request);
		String strtarget = "issue";
		return mapping.findForward(strtarget);
		

	}
	
	public ActionForward RETURN(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws HisException, SQLException {
		
		System.out.println("<<<--------------LPIssueDeskTransCNT . RETURN---------------->>>");
		
		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
		LPIssueDeskTransDATA.getInitDetailForReturnPage(formBean, request);
		String strtarget = "return";
		return mapping.findForward(strtarget);
	}
	
	
	public ActionForward ISSUEVIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		
		System.out.println("<<<--------------LPIssueDeskTransCNT . ISSUEVIEW---- [view_LpIssueDtlTrans.jsp / view_LpReturnDtlTrans.jsp ]------------>>>");

	//	System.out.println(" Inside 1");
		ActionForward acFwd = new ActionForward();
		String[] Temp = request.getParameterValues("combo");
		String[] arr  = Temp[1].split("\\^");
	    String cmb  = arr[0];
	    String str = Temp[0];
	    
	    if(cmb.equals("31")) //Issue to store 
	    {
	    	acFwd.setPath("/mms/transactions/IssueDeskTransCNT.cnt?hmode=VIEW2");
	    	acFwd.setContextRelative(true);
	        return acFwd;
	    }
	    else
		{
			LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
	
			LPIssueDeskTransDATA.getInitDetailForViewPage(formBean, request);
			
			String strtarget = "viewIssue";
			return mapping.findForward(strtarget);
		}

	}
	
	public ActionForward SETTELMENTVIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		
		System.out.println("<<<--------------LPIssueDeskTransCNT . SETTELMENTVIEW---- [view_LpIssueDtlTrans.jsp / view_LpReturnDtlTrans.jsp ]------------>>>");

	//	System.out.println(" Inside 1");
		ActionForward acFwd = new ActionForward();
		String[] Temp = request.getParameterValues("combo");
		String[] arr  = Temp[1].split("\\^");
	    String cmb  = arr[0];
	    String str = Temp[0];
	    
	   
		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
	
		LPIssueDeskTransDATA.getSettelmentViewPage(formBean, request);
			
		String strtarget = "viewSettelment";
		return mapping.findForward(strtarget);
		

	}
	
	public ActionForward RETURNVIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		ActionForward acFwd = new ActionForward();
		String[] Temp = request.getParameterValues("combo");
		String[] arr  = Temp[1].split("\\^");
	    String cmb  = arr[0];
	    String str = Temp[0];
	    
	    System.out.println("<<<--------------LPIssueDeskTransCNT . RETURNVIEW---- [ view_LpReturnDtlTrans.jsp ]------------>>>");
	    
	    if(cmb.equals("31")) //Issue to store 
	    {
	    	acFwd.setPath("/mms/transactions/IssueDeskTransCNT.cnt?hmode=VIEW2");
	    	acFwd.setContextRelative(true);
	        return acFwd;
	    }
	    else
		{
			
			LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
			LPIssueDeskTransDATA.getInitDetailForReturnViewPage(formBean, request);
			String strtarget = "viewReturn";
			return mapping.findForward(strtarget);
		}

	}
	
	
	/*Insert into Return To Patient*/
	public ActionForward INSERTRET(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
		System.out.println("<<<--------------LPIssueDeskTransCNT . INSERTRET---------------->>>");
		
		LPIssueDeskTransDATA.insertReturn(formBean, request);
		//if(formBean.getStrFlag().equals("1")){
		//	return this.LIST(mapping, form, request, response);
		//}
	//	else{
			return this.RETURN(mapping, form, request, response);
	//	}
		

	}

	/**
	 * This method is used to cancel the Process.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	/**
	 * This method is used to FORWARD CONTROL ON A CNT FOR VIEW PAGE.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		//System.out.println(" Inside 2");
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/IssueViewDetailsCNT.cnt?hmode=init");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public void PRINT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
//		String[] s = request.getParameterValues("chk");
//		for(int i=0;i<s.length;i++)
//		{
//			System.out.println(" In Cnt Chk-->"+i+"==>>"+s[i]);			
//		}
		///hisglobal/initPage.jsp
		/*System.out.println("reached to print.........");
		ActionForward acFwd = new ActionForward();
		request.setAttribute("Path","LPIssuedesktransCNT.cnt");
		acFwd.setPath("/mms/transactions/IndentPrintTransCNT.cnt?hmode=PRINT");
	    acFwd.setContextRelative(true);
        return acFwd;*/
		
		System.out.println("<<<--------------LPIssueDeskTransCNT . PRINT---------------->>>");
		
		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB)_form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		LPIssueDeskTransDATA.showReport(formBean, request, response);
		
        
    }

	public ActionForward ISSUEDTLSINITONE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("<<<--------------LPIssueDeskTransCNT . ISSUEDTLSINITONE--(PRINT_VOUCHER)-------------->>>");
		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
		LPIssueDeskTransDATA.issueDtlsInit(request, response, formBean);
		return null;
	}
	
	public ActionForward ISSUEDTLSINITTWO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("<<<--------------LPIssueDeskTransCNT . ISSUEDTLSINITTWO --(PRINT_VOUCHER RETURN/NEW ITEM)-------------->>>");
		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
		LPIssueDeskTransDATA.returnNewItem(request, response, formBean);
		return null;
	}
	
	public ActionForward SETTELMENTVOUCHER(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("<<<--------------LPIssueDeskTransCNT . SETTELMENTVOUCHER--( PRINT_VOUCHER )-------------->>>");
		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
		LPIssueDeskTransDATA.settelmentVoucher(request, response, formBean);
		return null;
	}
	
}
