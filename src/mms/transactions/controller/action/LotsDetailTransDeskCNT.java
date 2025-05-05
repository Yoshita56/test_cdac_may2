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

import mms.transactions.controller.utl.LotsDetailTransUTL;

public class LotsDetailTransDeskCNT  extends GenericController
{
	String strtarget;
	/**
	 * Constructor of Class.
	 */
	public LotsDetailTransDeskCNT()
	{
		//System.out.println("Hello India");
		super( new LotsDetailTransUTL(),"/transactions/LotsDetailTransDeskCNT");
	}
	
	
	
	public ActionForward LOTS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
	//	String strChk=request.getParameter("chk");
		request.setAttribute("combo", request.getParameter("combo"));
		String strComboValue1=request.getParameterValues("combo")[0];
		String strComboValue2=request.getParameterValues("combo")[1];
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/LotsDetailTransCNT.cnt?hmode=LOT_ADD&combo1="+strComboValue1+"&combo2="+strComboValue2+"&comboName="+request.getParameter("comboValue"));
        acFwd.setContextRelative(true);
		return acFwd; 
	}
	public ActionForward LOTSVIEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		String strChk=request.getParameter("chk");
		request.setAttribute("combo", request.getParameter("combo"));
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/LotsDetailViewTransCNT.cnt?hmode=LOTSVIEW&comboName="+request.getParameter("comboValue")+"&chk="+strChk);
        acFwd.setContextRelative(true);
		return acFwd; 
	}
	public ActionForward CANCELLOTS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		String strChk=request.getParameter("chk");
		request.setAttribute("combo", request.getParameter("combo"));
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/LotsDetailTransCNT.cnt?hmode=LOT_CANCEL&chk="+strChk+"&cancelRemarks="+request.getParameter("comboValue"));
        acFwd.setContextRelative(true);
		return acFwd; 
	}
	public ActionForward CANCELPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
			ActionForward acFwd = new ActionForward();
			acFwd.setPath("/hisglobal/initPage.jsp");
			acFwd.setContextRelative(true);
			return acFwd;
	}
	public ActionForward MOVELISTPAGE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws HisException ,SQLException{	
		return this.LIST(mapping, form, request, response); 
	}
}
