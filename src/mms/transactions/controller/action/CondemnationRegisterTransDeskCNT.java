/**
 * Developer : Anurudra Goel
 * Version : 1.0
 * Date : 13/April/2009
 *  
*/
package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;
import mms.transactions.controller.utl.CondemnationRegisterTransUTL;

public class CondemnationRegisterTransDeskCNT  extends GenericController
{
	String strtarget;
	//static CondemnationRegisterTransUTL masterObj = new CondemnationRegisterTransUTL();
	/**
	 * Constructor of Class.
	 */
	public CondemnationRegisterTransDeskCNT()
	{
		//System.out.println("Hello India");
		super( new CondemnationRegisterTransUTL(),"/transactions/CondemnationRegisterTransDeskCNT");
	}
	
	
	
	public ActionForward CONDEMN(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		String strChk=request.getParameter("chk");
		request.setAttribute("combo", request.getParameter("combo"));
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/CondemnationRegisterTransCNT.cnt?hmode=CONDEMN_ADD&chk="+strChk+"&comboName="+request.getParameter("comboValue"));
        acFwd.setContextRelative(true);
		return acFwd; 
	}

	public ActionForward VIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		String strChk=request.getParameter("chk");
		request.setAttribute("combo", request.getParameter("combo"));
		ActionForward afd=new ActionForward();
		afd.setPath("/mms/transactions/CondemnationRegisterViewTransCNT.cnt?hmode=CONDEMNATIONREGISTERVIEW&chk="+strChk+"&comboName="+request.getParameter("comboValue"));
		afd.setContextRelative(true);
		return afd; 
	}
	public ActionForward VIEWREQ(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		String strChk=request.getParameter("chk");
		request.setAttribute("combo", request.getParameter("combo"));
		ActionForward afd=new ActionForward();
		afd.setPath("/mms/transactions/CondemnationRegisterViewTransCNT.cnt?hmode=CONDEMNATIONREQVIEW&chk="+strChk+"&comboName="+request.getParameter("comboValue"));
		afd.setContextRelative(true);
		return afd; 
	}
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
			ActionForward acFwd = new ActionForward();
			acFwd.setPath("/hisglobal/initPage.jsp");
			acFwd.setContextRelative(true);
			return acFwd;
	}
	public ActionForward ReturnToMainDesk(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
			return LIST(mapping, form, request, response);
	}
}
