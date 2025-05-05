package mms.transactions.controller.action;


import hisglobal.exceptions.HisException;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.PhysicalNewStockVerfTransDATA;
import mms.transactions.controller.fb.PhysicalNewStockVerfTransFB;
import hisglobal.presentation.CSRFGardTokenAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

public class PhysicalNewStockVerfTransCNT extends CSRFGardTokenAction {

	/** The strtarget. */
	String strtarget;

	/**
	 * Constructor of Class.
	 */
	public PhysicalNewStockVerfTransCNT() {
		// super(new
		// CommitteeMemberDetailMstUTL(),"/masters/CommitteeMemberDetailMstCNT");
	}

	/**
	 * ********************* UNSPECIFIED *************************.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */

	/**
	 * Unspecified Method Use to Transfer the Control Over Action FIRSTDATA.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 * @throws ServletException 
	 * @throws IOException 
	 */

	public ActionForward unspecified(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {
		generateToken(request);
		return this.FIRSTDATA(mapping, form, request, response);
	}

	/**
	 * forwards control to the ADD page of Trasaction.& get all data which required to show over add page
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward FIRSTDATA(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {
		generateToken(request);
		PhysicalNewStockVerfTransFB fb = (PhysicalNewStockVerfTransFB) form;
		PhysicalNewStockVerfTransDATA.GetData(fb, request,response);
		strtarget = "addPhysicalItem";
		return mapping.findForward(strtarget);

	}
	
	
	/**
	 * This method used to get Group Name Combo for Indent Issue Transaction.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward NEWDRUGDTLS(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
		PhysicalNewStockVerfTransDATA.NEWDRUGDTLS(request, response, formBean);
		return null;

	}
	
	/**
	 * This method used to get Group Name Combo for Indent Issue Transaction.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward GETGROUPDRUG(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
		PhysicalNewStockVerfTransDATA.GETGROUPDRUG(request, response, formBean);
		return null;

	}
	
	/**
	 * This method used to get Group Name Combo for Indent Issue Transaction.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward VERIFIEDITEMHLP(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
		PhysicalNewStockVerfTransDATA.VERIFIEDITEMHLP(request, response, formBean);
		return null;

	}
	
	/**
	 * This method used to get Group Name Combo for Indent Issue Transaction.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward REQUESTDETAILS(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
		PhysicalNewStockVerfTransDATA.REQUESTDETAILS(request, response, formBean);
		return null;

	}
	
	
	/**
	 * This method used to get Group Name Combo for Indent Issue Transaction.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward UPDATERECORD(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
		PhysicalNewStockVerfTransDATA.UPDATERECORD(request, response, formBean);
		return null;

	}
	/**
	 * This method used to get Group Name Combo for Indent Issue Transaction.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward CANCELRECORD(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
		PhysicalNewStockVerfTransDATA.CANCELRECORD(request, response, formBean);
		return null;

	}
	/**
	 * This method used to get Group Name Combo for Indent Issue Transaction.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward DELETEITEM(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
		PhysicalNewStockVerfTransDATA.DELETEITEM(request, response, formBean);
		return null;

	}
	
	/**
	 * This method used to get Group Name Combo for Indent Issue Transaction.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 * @throws ServletException 
	 * @throws IOException 
	 */
	public ActionForward STOCKUPDATE(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException, IOException, ServletException {

		PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
		PhysicalNewStockVerfTransDATA.STOCKUPDATE(request, response, formBean);
		return null;

	}
	
	
	

	/**
	 * INSERT method is used to insert data into table.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward TOBEVERIFY(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		try {
			this.validateToken(request, response);
			PhysicalNewStockVerfTransFB fb = (PhysicalNewStockVerfTransFB) form;
			PhysicalNewStockVerfTransDATA.TOBEVERIFY(fb, request,response);
			return this.FIRSTDATA(mapping, fb, request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}	

		return null;
	}
	/**
	 * MODIFY method is used to insert data into table.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward MODIFY(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		try {
			this.validateToken(request, response);
			PhysicalNewStockVerfTransFB fb = (PhysicalNewStockVerfTransFB) form;
			PhysicalNewStockVerfTransDATA.MODIFY(fb, request,response);
			return this.FIRSTDATA(mapping, fb, request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * STOCKUPDATECANCEL method is used to insert data into table.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward STOCKUPDATECANCEL(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		try {
			this.validateToken(request, response);
			PhysicalNewStockVerfTransFB fb = (PhysicalNewStockVerfTransFB) form;
			PhysicalNewStockVerfTransDATA.STOCKUPDATECANCEL(fb, request,response);
			return this.FIRSTDATA(mapping, fb, request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	
	
	/**
	 * CANCEL method forwards control to the LIST page of Transaction.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * @return the action forward
	 */

	public ActionForward CANCEL(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public ActionForward view(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HisException,
	SQLException, IOException, ServletException 
	{
		
		String strTarget = "";
		PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
		String strChk = request.getParameter("chk");
		String[] temp = strChk.split("\\@");
		String[] temp1 = temp[5].split("\\$");
		String strReqTypeId = temp1[0];
		formBean.setStrReqTypeId(strReqTypeId);
		formBean.setStrChk(request.getParameter("chk"));
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		strTarget = "view";
		PhysicalNewStockVerfTransDATA.viewData(formBean, request,response);
		return mapping.findForward(strTarget);
	}
	public ActionForward approve(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HisException,
	SQLException, IOException, ServletException 
	{
		
		String strTarget = "";
		PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
		String strChk = request.getParameter("chk");
		String[] temp = strChk.split("\\@");
		String[] temp1 = temp[5].split("\\$");
		String strReqTypeId = temp1[0];
		formBean.setStrReqTypeId(strReqTypeId);
		formBean.setStrChk(request.getParameter("chk"));
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		formBean.setStrApprovalFlag("1");
		formBean.setStrReApprovalFlag("0");
		strTarget = "approve";
		PhysicalNewStockVerfTransDATA.viewData(formBean, request,response);
		return mapping.findForward(strTarget);
	}
	public ActionForward reapprove(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws HisException,
	SQLException, IOException, ServletException 
	{
		
		String strTarget = "";
		PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
		String strChk = request.getParameter("chk");
		String[] temp = strChk.split("\\@");
		String[] temp1 = temp[5].split("\\$");
		String strReqTypeId = temp1[0];
		formBean.setStrReqTypeId(strReqTypeId);
		formBean.setStrChk(request.getParameter("chk"));
		String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
		formBean.setStrPath(path.trim());
		formBean.setStrApprovalFlag("0");
		formBean.setStrReApprovalFlag("1");
		strTarget = "approve";
		PhysicalNewStockVerfTransDATA.viewData(formBean, request,response);
		return mapping.findForward(strTarget);
	}
	
	public ActionForward INSERTFORAPPROVAL(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception,
	SQLException {
		try {
			PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
			String path = "/mms" + request.getParameter("cnt_page") + ".cnt";
			formBean.setStrPath(path.trim());
		
			boolean retValue = false;
			retValue = PhysicalNewStockVerfTransDATA.insertForApproval(formBean, request,response);
		
			if (retValue) 
			{
				return this.CANCEL1(mapping, form, request, response);
			} 
			else 
			{
				return this.approve(mapping, form, request, response);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
		}
	
	public ActionForward CANCEL1(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
	throws HisException, SQLException 
	{
		ActionForward acFwd = new ActionForward();
		String strPath = "";
		if (request.getParameter("strPath") != null) {
			strPath = request.getParameter("strPath").concat("?hmode=CANCEL");
			acFwd.setPath(strPath);
			acFwd.setContextRelative(true);
		
		}
		return acFwd;
	}
	public ActionForward GETCATCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

	
		PhysicalNewStockVerfTransFB formBean = (PhysicalNewStockVerfTransFB) form;
		PhysicalNewStockVerfTransDATA.setItemCategComboDtl(formBean, request, response);
		return null;

	}

	
}