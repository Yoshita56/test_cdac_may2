package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.transactions.controller.data.ThirdPartyIssueSancTransBSDATA;
import mms.transactions.controller.fb.ThirdPartyIssueSancTransFB;

/**
 * Developer : Kapil
 * Version : 1.0
 * Date : 23/Jan/2009
 *  
*/
public class ThirdPartyIssueSancTransBSCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping
            ,ActionForm form
            ,HttpServletRequest request
            ,HttpServletResponse response)throws HisException, SQLException
		{
		return this.ISSUE(mapping, form, request, response);
		}
	
	public ActionForward ISSUE(ActionMapping mapping
            ,ActionForm form
            ,HttpServletRequest request
            ,HttpServletResponse response)throws HisException, SQLException
    {
		System.out.println("---------- ThirdPartyIssueSancTransBSCNT.ISSUE -----------------");
		
		ThirdPartyIssueSancTransFB fb = (ThirdPartyIssueSancTransFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ThirdPartyIssueSancTransBSDATA.getData(fb, request);
		
		return mapping.findForward("issue");

    }
	
	/**
	 * This method is used to reset all the values 
	 * on clicking of clear button.
	 * @param _mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward CLEAR(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)throws HisException, SQLException 
	{
		ThirdPartyIssueSancTransFB fb = (ThirdPartyIssueSancTransFB) form;
		
		fb.setStrNormalMsg("");
		String strTarget=request.getParameter("mode");
		if(strTarget.equals("issue"))
		return this.ISSUE(_mapping, form, request, response);
		return null;
	}
	
	/**
	 * This method is used to insert the details.
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		System.out.println("---------- ThirdPartyIssueSancTransBSCNT.INSERT -----------------");
		
		ThirdPartyIssueSancTransFB fb = (ThirdPartyIssueSancTransFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		ThirdPartyIssueSancTransBSDATA.insert(fb, request, response);
		
		return this.ISSUE(mapping, form, request, response);
	}
	
	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/ThirdPartyIssueDeskBSCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
}
