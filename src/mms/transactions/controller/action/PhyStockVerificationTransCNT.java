package mms.transactions.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.transactionutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.controller.data.DiscrepancyReportData;
import mms.transactions.controller.data.PhyStockVerificationTransDATA;
import mms.transactions.controller.fb.PhyStockVerificationTransFB;
import mms.transactions.controller.utl.PhyStockVerificationTransUTL;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class PhyStockVerificationTransCNT extends GenericController {
	
		
	public PhyStockVerificationTransCNT() {
		super(new PhyStockVerificationTransUTL(), "/transactions/PhyStockVerificationTransCNT");
	}
	
	
	/**
	 * This method is used to populate the group details
	 * on request page
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward INVENTORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "inventoryCount";
		PhyStockVerificationTransFB fb = (PhyStockVerificationTransFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		PhyStockVerificationTransDATA.getGroupCmb(fb, request, response);
		
		return mapping.findForward(strTarget);
	}
	
	public ActionForward ITEMDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		PhyStockVerificationTransFB fb = (PhyStockVerificationTransFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		PhyStockVerificationTransDATA.getItemDtl(fb, request, response);
		
		return null;
	}
	
	public ActionForward COUNTEDDETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		PhyStockVerificationTransFB fb = (PhyStockVerificationTransFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		PhyStockVerificationTransDATA.getNewItemDtl(fb, request, response);
		
		return null;
	}
	
	public ActionForward UNITCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		PhyStockVerificationTransFB fb = (PhyStockVerificationTransFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		PhyStockVerificationTransDATA.getUnitCmb(fb, request, response);
		
		return null;
	}
	
	
	public ActionForward ITEMBRANDCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		PhyStockVerificationTransFB fb = (PhyStockVerificationTransFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		PhyStockVerificationTransDATA.getBrandCmb(fb, request, response);
		
		return null;
	}
	
	
	/**
	 * This method is used to get the initial page 
	 * on clicking of cancel button.
	 * @param _mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 */
	
	public ActionForward CANCELPAGE(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		
			return this.LISTPAGE(_mapping, form, request, response);
	}
	
	public ActionForward SAVE(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		

		PhyStockVerificationTransFB formBean = (PhyStockVerificationTransFB) form;
		PhyStockVerificationTransDATA.insertRecord(formBean, request);
		
			return this.LIST(_mapping, form, request, response);
	}
	
	public ActionForward GETPHYSTOCKVERIFIED(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		PhyStockVerificationTransFB fb = (PhyStockVerificationTransFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		PhyStockVerificationTransDATA.getPhysicalStockVerified(fb, request, response);
		
		return null;
	}
	
	
	public ActionForward VERIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String strTarget = "verify";
		PhyStockVerificationTransFB fb = (PhyStockVerificationTransFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		PhyStockVerificationTransDATA.getVerifyInitValues(fb, request, response);
		
		return mapping.findForward(strTarget);
	}
	
	public ActionForward GETCOUNTEDITEMLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		PhyStockVerificationTransFB fb = (PhyStockVerificationTransFB) form;
		fb.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		
		PhyStockVerificationTransDATA.getCountedItemsList(fb, request, response);
		
		return null;
	}
	public ActionForward BATCHWISEDTL(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws HisException{
	
		//PhyStockVerificationTransDATA.getBatchWiseDtl(formBean, request, response);
		DiscrepancyReportData.getBatchWiseDtl(request, response);
		return null;
	}
	public ActionForward VIEW(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		PhyStockVerificationTransFB fb = (PhyStockVerificationTransFB) form;
		PhyStockVerificationTransDATA.getViewPage(fb, request);
			return _mapping.findForward("view");
	}
	public ActionForward REVIEW(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		PhyStockVerificationTransFB fb = (PhyStockVerificationTransFB) form;
		PhyStockVerificationTransDATA.getReviewPage(fb, request);
			return _mapping.findForward("review");
	}
	public ActionForward COMMITEEMEMBERDTL(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws HisException{
		
		PhyStockVerificationTransFB formBean = (PhyStockVerificationTransFB) form;
		PhyStockVerificationTransDATA.getMemberDtl(formBean, request, response);
		return null;
	}
	public ActionForward NONDISCREPANCYREPORT(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		DiscrepancyReportData.getNonDiscrepancyReport(request, response);
		return null;
	}
	public ActionForward LISTPAGETOMAINPAGE(ActionMapping _mapping, ActionForm form,
	HttpServletRequest request, HttpServletResponse response)
	throws HisException {
		return this.LIST(_mapping, form, request, response);
	}

	public ActionForward REVIEWUPDATE(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException {
		

		PhyStockVerificationTransFB formBean = (PhyStockVerificationTransFB) form;
		PhyStockVerificationTransDATA.updateReview(formBean, request);
		return this.LIST(_mapping, formBean, request, response);
	}
	public ActionForward CANCELSTOCK(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws HisException {


		PhyStockVerificationTransFB formBean = (PhyStockVerificationTransFB) form;
		PhyStockVerificationTransDATA.cancelRecord(formBean, request);
		return this.LIST(_mapping, formBean, request, response);
}
	public ActionForward UPDATESTOCK(ActionMapping _mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws HisException {


		PhyStockVerificationTransFB formBean = (PhyStockVerificationTransFB) form;
		PhyStockVerificationTransDATA.updateStock(formBean, request);
		return this.LIST(_mapping, formBean, request, response);
}
	
	
}
