package mms.transactions.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import mms.transactions.controller.data.SupplierReturnDeskDATA;
import mms.transactions.controller.fb.SupplierReturnDeskFB;
import mms.transactions.controller.utl.SupplierReturnDeskUTL;
import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

/**
 * Developer : Deepak Tiwari
 * Version : 1.0
 * Date : 28/Jan/2009
 *  
*/

public class SupplierReturnDeskCNT extends GenericController {

	public SupplierReturnDeskCNT() {
		super(new SupplierReturnDeskUTL(), "/transactions/SupplierReturnDeskCNT");
	}

	/**
	 * is used to forward control to add page
	 * 
	 * @param _mapping
	 * @param _form
	 * @param _request
	 * @param _response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward REQUEST(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException, SQLException {
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/SupplierReturnReqTransCNT.cnt?hmode=unspecified");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward CANCEL_REQUEST(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/SupplierReturnReqTransCNT.cnt?hmode=CANCEL_REQUEST");	
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	public ActionForward VIEW(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException, SQLException {
		SupplierReturnDeskFB fb = (SupplierReturnDeskFB) _form;
		fb.setStrHospitalCode(_request.getSession().getAttribute("HOSPITAL_CODE").toString());
		fb.setStrSeatId(_request.getSession().getAttribute("SEATID").toString());
		SupplierReturnDeskDATA.getData(fb, _request);
		return _mapping.findForward("view");
	}

	public ActionForward MODIFY(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException, SQLException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/SupplierReturnModifyTransCNT.cnt?hmode=MODIFY");	
		acFwd.setContextRelative(true);
		return acFwd;
	}

	public ActionForward RETURN(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException, SQLException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/mms/transactions/SupplierReturnSancTransCNT.cnt?hmode=RETURN");	
		acFwd.setContextRelative(true);
		return acFwd;
	}
	/**
	 * @param _mapping
	 * @param _form
	 * @param _request
	 * @param _response
	 * @return
	 * @throws HisException
	 */
	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	
	
}
