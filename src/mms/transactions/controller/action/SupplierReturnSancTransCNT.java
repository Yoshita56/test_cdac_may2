package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.transactions.controller.data.SupplierReturnSancTransDATA;
import mms.transactions.controller.fb.SupplierReturnSancTransFB;

/**
 * Developer : Kapil
 * Version : 1.0
 * Date : 23/Jan/2009
 *  
*/
public class SupplierReturnSancTransCNT extends DispatchAction {
	
	public ActionForward unspecified(ActionMapping mapping
            ,ActionForm form
            ,HttpServletRequest request
            ,HttpServletResponse response)throws HisException, SQLException
		{
		return this.RETURN(mapping, form, request, response);
		}
	
	public ActionForward RETURN(ActionMapping mapping
            ,ActionForm form
            ,HttpServletRequest request
            ,HttpServletResponse response)throws HisException, SQLException
    {
		SupplierReturnSancTransFB fb = (SupplierReturnSancTransFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		SupplierReturnSancTransDATA.getData(fb, request);
		
		return mapping.findForward("return");

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
		SupplierReturnSancTransFB fb = (SupplierReturnSancTransFB) form;
		
		fb.setStrNormalMsg("");
		return this.RETURN(_mapping, form, request, response);
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

		SupplierReturnSancTransFB fb = (SupplierReturnSancTransFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		
		SupplierReturnSancTransDATA.insert(fb, request, response);
		
		return this.RETURN(mapping, form, request, response);
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
	
	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/SupplierReturnDeskCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}

}
