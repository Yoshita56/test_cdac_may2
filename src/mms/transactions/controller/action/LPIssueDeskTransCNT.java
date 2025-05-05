/**
Author Anurudra Goel
DATE 10-June-2009
**/

package mms.transactions.controller.action;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONArray;

import hisglobal.exceptions.HisException;
import hisglobal.tools.hlp.GlobalVO;
import hisglobal.transactionutil.GenericController;
import mms.transactions.controller.data.LPIssueDeskTransDATA;
import mms.transactions.controller.fb.LPIssueDeskTransFB;
import mms.transactions.controller.utl.LPIssueDeskTransUTL;

public class LPIssueDeskTransCNT extends GenericController {

	public LPIssueDeskTransCNT() {
		super(new LPIssueDeskTransUTL(), "/transactions/LPIssueDeskTransCNT");
	}

	public ActionForward CANCELTODESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/LPIssueDeskTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
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
			throws HisException, SQLException {

		ActionForward acFwd = new ActionForward();
		String[] Temp = request.getParameterValues("combo");
		String[] arr  = Temp[1].split("\\^");
	    String cmb  = arr[0];
	    String str = Temp[0];
	    String strName = request.getParameter("comboValue");
	    
	    if(cmb.equals("31")) //Issue to store 
	    {
	    	System.out.println("LPIssueDeskTransCNT.ISSUE -- 31 ----[ /mms/transactions/IssueDeskTransCNT.cnt?hmode=ISSUE ]-----------");
	    	
	    	acFwd.setPath("/mms/transactions/IssueDeskTransCNT.cnt?hmode=ISSUE");
	    	acFwd.setContextRelative(true);
	        return acFwd;
	    }
	    else
		if(cmb.equals("32")) // Issue to patient (OPD)
		{
			System.out.println("LPIssueDeskTransCNT.ISSUE -- 32 ----[ /mms/transactions/IssueTransCNT.cnt?hmode=unspecified&strMode=0&strStoreId="+str+"#--]-----------");
			
		    acFwd.setPath("/mms/transactions/IssueTransCNT.cnt?hmode=unspecified&strMode=0&strStoreId="+str+"#"+strName);
		    acFwd.setContextRelative(true);
	        return acFwd;
		}	
		else
		{
			System.out.println("------LPIssueDeskTransCNT.ISSUE ----[ add_LpIssueDtlTrans.jsp ]------------");
			
			LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;

			LPIssueDeskTransDATA.getInitDetailForIssuePage(formBean, request);
			formBean.setStrUCReq("0");
			String strtarget = "issue";
			return mapping.findForward(strtarget);
		} 
	}
	
	public void PATDTLSERVICE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		String strCrNo = request.getParameter("crno");
		GlobalVO voObj = new GlobalVO();
		try
		{
			System.out.println("-------------  LPIssueDeskTransCNT . PATDTLSERVICE  --------------");
			voObj.setStrValue1(strCrNo);
			voObj.setStrValue2(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			String json = LPIssueDeskTransDATA.getInitPatDtl(voObj); 
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter(); 
			pw.write(json==null || json=="" ? "{}":json);
		}
		catch(Exception e){
			System.out.println(e);
		}
		 
	}	
	public void PATADMDTLSERVICE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		String strCrNo = request.getParameter("crno");
		String strHospitalCode = request.getParameter("hospCode");
		GlobalVO voObj = new GlobalVO();
		try
		{
			System.out.println("-------------  LPIssueDeskTransCNT . PATADMDTLSERVICE  --------------");
			voObj.setStrValue1(strCrNo);
			voObj.setStrValue2(strHospitalCode); 
			String json = LPIssueDeskTransDATA.getInitPatAdmDtl(voObj); 
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter(); 
			pw.write(json==null || json=="" ? "{}":json);
		}
		catch(Exception e){
			System.out.println(e);
		}
		 
	}
	public void PATDIADTLSERVICE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response){
		String strCrNo = request.getParameter("crno");
		String strHospitalCode = request.getParameter("hospCode");
		GlobalVO voObj = new GlobalVO();
		try
		{
			System.out.println("-------------  LPIssueDeskTransCNT . PATDIADTLSERVICE  --------------");
			voObj.setStrValue1(strCrNo);
			voObj.setStrValue2(strHospitalCode); 
			String json = LPIssueDeskTransDATA.getInitPatDiaDtl(voObj); 
			response.setContentType("application/json");
			PrintWriter pw = response.getWriter(); 
			pw.write(json==null || json=="" ? "{}":json);
		}
		catch(Exception e){
			System.out.println(e);
		}
		 
	}
	
	public ActionForward NEWISSUE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ActionForward acFwd = new ActionForward();
		String[] Temp = request.getParameterValues("combo");
		String[] arr  = Temp[1].split("\\^");
	    String cmb  = arr[0];
	    String str = Temp[0];
	    
	    System.out.println("-------------  LPIssueDeskTransCNT . NEWISSUE  --------------");
	    
	    if(cmb.equals("31")) //Issue to store 
	    {
	    	System.out.println("-------------  /mms/transactions/IssueDeskTransCNT.cnt?hmode=ISSUE --------------");
	    	
	    	acFwd.setPath("/mms/transactions/IssueDeskTransCNT.cnt?hmode=ISSUE");
	    	acFwd.setContextRelative(true);
	        return acFwd;
	    }
	    else
		if(cmb.equals("32")) // Issue to patient (OPD)
		{
			System.out.println("-------------  /mms/transactions/IssueTransCNT.cnt?hmode=unspecified&strMode=0&strStoreId="+str+"--------------");
			
		    acFwd.setPath("/mms/transactions/IssueTransCNT.cnt?hmode=unspecified&strMode=0&strStoreId="+str+"^--");
		    acFwd.setContextRelative(true);
	        return acFwd;
		}	
		else
		{
			
			System.out.println("-------------  [ new_add_LpIssueDtlTrans.jsp ] --------------");
			
			LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
			formBean.setStrStoreId(Temp[0]);
			formBean.setStrRequestTypeId(Temp[1]);
			String hosCode = request.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			formBean.setStrHospitalCode(hosCode);
			
			formBean.setCombo(request.getParameterValues("combo"));
			formBean.setStrStoreName(formBean.getComboValue());
			
			//LPIssueDeskTransDATA.getInitDetailForIssuePage(formBean, request);
			formBean.setStrUCReq("0");
			String strtarget = "newipdissue";
			return mapping.findForward(strtarget);
		}
		
			
			

	}
	public ActionForward NEWISSUEPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
			
		 System.out.println("-------------  LPIssueDeskTransCNT . NEWISSUEPRINT  --------------");
			JSONArray jsonObj =null;
			String storeId = request.getParameter("storeId"); 
			String issueNo = request.getParameter("issueNo"); 
			try{  
				LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form; 

				request.getSession().setAttribute("storeId",storeId);
				request.getSession().setAttribute("issueNo",issueNo);
			}
			catch(Exception e){
				
			}
			String strtarget = "newissueprint";
			return mapping.findForward(strtarget); 
	}
	public ActionForward NEWISSUESAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
			
		System.out.println("-------------  LPIssueDeskTransCNT . NEWISSUESAVE  --------------");
			/*JSONArray jsonObj =null;
			String str = request.getParameter("issueDtlJson"); */
			try{
				/*jsonObj = new JSONArray(str);	
				System.out.println(jsonObj.toString());*/
				LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
				
			//	if(request.getParameter("toPrintFlg").equals("1"))
					LPIssueDeskTransDATA.saveNewIssuePage(formBean);
					formBean.setStrCrNo(""); 
			}
			catch(Exception e){
				e.printStackTrace();
			} 
			return mapping.findForward("newipdissue"); 
	}
	
	public ActionForward  RETURNTOMAINDESK(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws HisException, SQLException {
		
		return this.LIST(mapping, form, request, response);
	}
	
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("---------LPIssueDeskTransCNT.INSERT---------");
		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;

		LPIssueDeskTransDATA.insertData(formBean, request);
//		//if(formBean.getStrFlag().equals("1")){
//		//	return this.LIST(mapping, form, request, response);
//		//}else{
//			return this.ISSUE(mapping, form, request, response);
//		//}
		
		LPIssueDeskTransDATA.getInitDetailForIssuePage(formBean, request);
		String strtarget = "issue";
		return mapping.findForward(strtarget);
		

	}
	
	public ActionForward RETURN(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws HisException, SQLException {
		System.out.println("-------------  LPIssueDeskTransCNT . RETURN  --------------");
		
		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
		LPIssueDeskTransDATA.getInitDetailForReturnPage(formBean, request);
		String strtarget = "return";
		return mapping.findForward(strtarget);
	}
	
	
	public ActionForward ISSUEVIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

	//	System.out.println(" Inside 1");
		ActionForward acFwd = new ActionForward();
		String[] Temp = request.getParameterValues("combo");
		String[] arr  = Temp[1].split("\\^");
	    String cmb  = arr[0];
	    String str = Temp[0];
	    
	    System.out.println("-------------  LPIssueDeskTransCNT . ISSUEVIEW  --------------");
	    
	    if(cmb.equals("31")) //Issue to store 
	    {
	    	System.out.println("-------------  /mms/transactions/IssueDeskTransCNT.cnt?hmode=VIEW2 --------------");
	    	acFwd.setPath("/mms/transactions/IssueDeskTransCNT.cnt?hmode=VIEW2");
	    	acFwd.setContextRelative(true);
	        return acFwd;
	    }
	    else
		{
	    	System.out.println("-------------  view_LpIssueDtlTrans.jsp --------------");
	    	
			LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
	
			LPIssueDeskTransDATA.getInitDetailForIssuePage(formBean, request);
			
			String strtarget = "viewIssue";
			return mapping.findForward(strtarget);
		}

	}
	
	public ActionForward RETURNVIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		ActionForward acFwd = new ActionForward();
		String[] Temp = request.getParameterValues("combo");
		String[] arr  = Temp[1].split("\\^");
	    String cmb  = arr[0];
	    String str = Temp[0];
	    System.out.println("-------------  LPIssueDeskTransCNT . RETURNVIEW  --------------");
	    
	    if(cmb.equals("31")) //Issue to store 
	    {
	    	System.out.println("-------------  /mms/transactions/IssueDeskTransCNT.cnt?hmode=VIEW2 --------------");
	    	
	    	acFwd.setPath("/mms/transactions/IssueDeskTransCNT.cnt?hmode=VIEW2");
	    	acFwd.setContextRelative(true);
	        return acFwd;
	    }
	    else
		{
	    	System.out.println("-------------  view_LpReturnDtlTrans.jsp -----[ Patinet View]---------");
			
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

		 System.out.println("-------------  LPIssueDeskTransCNT . INSERTRET  --------------");
		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
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
		
		 System.out.println("-------------  LPIssueDeskTransCNT . VIEW  --------------");
		 
		 System.out.println("-------------  /mms/transactions/IssueViewDetailsCNT.cnt?hmode=init  --------------");
		 
		acFwd.setPath("/mms/transactions/IssueViewDetailsCNT.cnt?hmode=init");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public void PRINT(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{
		 System.out.println("-------------  LPIssueDeskTransCNT . PRINT  --------------");
		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB)_form;
		formBean.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		LPIssueDeskTransDATA.showReport(formBean, request, response);
		
        
    }
	
	/**
	 * APPROVALPRINT - gets the issue details view used for ajax.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward BEFOREISSUEPRINT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		LPIssueDeskTransFB formBean = (LPIssueDeskTransFB) form;
        System.out.println("-----------LPIssueDeskTransCNT . BEFOREISSUEPRINT [ Approval Voucher ]--------------");
        LPIssueDeskTransDATA.indentAppPrint(request, response, formBean);

		return null;
	}
	
	
	


}
