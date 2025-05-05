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
import org.apache.struts.actions.DispatchAction;
import hisglobal.exceptions.HisException;
import mms.transactions.controller.data.CondemnationRegisterTransDATA;
import mms.transactions.controller.fb.CondemnationRegisterTransFB;
import mms.transactions.controller.utl.CondemnationRegisterTransUTL;

public class CondemnationRegisterTransCNT  extends DispatchAction
{
	String strtarget;
	static CondemnationRegisterTransUTL masterObj = new CondemnationRegisterTransUTL();
	/**
	 * Constructor of Class.
	 */
	
	
	
	public ActionForward CONDEMN_ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		CondemnationRegisterTransFB formBean=(CondemnationRegisterTransFB) form;
		
	
		CondemnationRegisterTransDATA.initialAdd(formBean, request);
		
		return mapping.findForward("add"); 
	}

	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		
		CondemnationRegisterTransFB formBean=(CondemnationRegisterTransFB) form;
		CondemnationRegisterTransDATA.insert(formBean, request);
		ActionForward afd=new ActionForward();
		if(formBean.getStrResult().equals("1")){
			afd.setPath("/mms/transactions/CondemnationRegisterTransDeskCNT.cnt?hmode=ReturnToMainDesk" );
					afd.setContextRelative(true);
			return afd; 
		}
		else
			return CONDEMN_ADD( mapping,  form, request,response); 
		
			
		
		
	}
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		
		ActionForward afd=new ActionForward();
		afd.setPath(request.getParameter("strPath"));
		afd.setContextRelative(true);
		return afd; 
	}
	public ActionForward COMMITEEMEMBERDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException ,SQLException{
		CondemnationRegisterTransFB formBean=(CondemnationRegisterTransFB) form;
		CondemnationRegisterTransDATA.getMemberDtl(formBean, request,response);
		formBean.setStrMsg("");
			
		return null;
	}
	
}
