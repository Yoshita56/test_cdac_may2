package mms.transactions.controller.action;
import java.sql.SQLException;
import mms.transactions.controller.fb.GatePassDetailsTransFB;
import mms.transactions.controller.data.GatePassDetailsTransDATA;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 * Developer : baisakhi
 * Version : 1.0
 * Date : 28/Jan/2009
 *  
*/

public class GatePassDetailsTransCNT extends DispatchAction {
 
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
	 return this.init(mapping,form,request,response);
	}
	/**
	 * to display the current date and storename,gatepasstype,issuedby combos 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	private ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String strTarget = "index";
		GatePassDetailsTransFB formBean = (GatePassDetailsTransFB) form;
		
		GatePassDetailsTransDATA.getInitialValues(formBean,request);
		
		return mapping.findForward(strTarget);

	}
	/**
	 * To add data.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		
		GatePassDetailsTransFB formBean = (GatePassDetailsTransFB) form;
		GatePassDetailsTransDATA.insertRecord(formBean, request);

		return this.init(mapping, form, request, response);

	}
	/**
	 * To Cancel the process.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */

	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			   HttpServletRequest request, HttpServletResponse response)
			 {
			     ActionForward acFwd = new ActionForward();
			  acFwd.setPath("/startup/initPage.jsp");
			  acFwd.setContextRelative(true);
			  return acFwd;
			 }
			 
}
