package mms.transactions.controller.action;


import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.SupplierReturnReqTransDATA;
import mms.transactions.controller.fb.SupplierReturnReqTransFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
/**
 * Developer : Deepak Tiwari 
 * Version   : 1.0 
 * Date      : 23/Jan/2009
 * Module    : MMS
 * Unit      : Supplier Return Request Details
 */


public class SupplierReturnReqTransCNT extends DispatchAction {

	/* (non-Javadoc)
	 * 
	 * @see org.apache.struts.actions.DispatchAction#unspecified(org.apache.struts.action.ActionMapping,
	 *      org.apache.struts.action.ActionForm,
	 *      javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception, SQLException 
	{
		return this.init(mapping, form, request, response);
	}

	/** This method is used to forward the request on first jsp page
	 * And calls the methods getInitialValues() which is define in SupplierReturnReqTransDATA java file. AND LIST VALUES to display combos 
	 * on first page. 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 * 
	 */
	public ActionForward init(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws HisException, SQLException 
	{
		String strTarget = "index";
		SupplierReturnReqTransFB formBean = (SupplierReturnReqTransFB) form;
		SupplierReturnReqTransDATA.getInitialValues(formBean,request);
		return mapping.findForward(strTarget);
	}


	/** This method is used to display the value of item details  for this
	 *  calls the methods getItemDetails() which is define in SupplierReturnReqTransDATA java file. .
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	public ActionForward GET_PO_DETAILS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception, SQLException 
	{
		String strTarget = "index";
		SupplierReturnReqTransFB formBean = (SupplierReturnReqTransFB) form;
		SupplierReturnReqTransDATA.getPODetails(formBean,request,response);
		return mapping.findForward(strTarget);
	}

	/**
	 * This function forward control List pop up window
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward LIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		//String strTarget = "list";
	//	SupplierReturnReqTransFB formBean = (SupplierReturnReqTransFB) form;
		return mapping.findForward("list");
	}
	 
	   /**
		 * This function forward control List pop up window
		 * @param mapping
		 * @param form
		 * @param request
		 * @param response
		 * @return
		 * @throws HisException
		 * @throws SQLException
		 */
		public ActionForward LISTDTL(ActionMapping mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {
			
			SupplierReturnReqTransFB formBean = (SupplierReturnReqTransFB) form;
			//System.out.println("in CNT");
			SupplierReturnReqTransDATA.initSearchList(formBean, request,response);
			return null;
		}
		
		public ActionForward CANCEL_REQUEST(ActionMapping _mapping, ActionForm form,
				HttpServletRequest request, HttpServletResponse response)
				throws HisException, SQLException {
			
			SupplierReturnReqTransFB fb = (SupplierReturnReqTransFB) form;
			fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			SupplierReturnReqTransDATA.CANCEL_REQUEST(fb, request , response);
			ActionForward acFwd = new ActionForward();
			acFwd.setPath("/mms/transactions/SupplierReturnDeskCNT.cnt?hmode=unspecified");
			acFwd.setContextRelative(true);
		    return acFwd;
			//return LISTPAGE(_mapping, form, request, response);
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

			SupplierReturnReqTransFB fb = (SupplierReturnReqTransFB) form;
			fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
			fb.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
			SupplierReturnReqTransDATA.insert(fb, request, response);
			fb.setStrPONo("");
			return init(mapping, form, request, response);
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
			SupplierReturnReqTransFB fb = (SupplierReturnReqTransFB) form;
			
			fb.setStrNormalMsg("");
			fb.setStrPONo("");
			return this.init(_mapping, form, request, response);
		}
			
		/** This method is used to cancel the Supplier Return Request Details page.
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
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
