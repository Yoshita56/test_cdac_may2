package mms.reports.controller.action;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import hisglobal.exceptions.HisException;
import mms.reports.controller.data.ListofNARptDATA;
import mms.reports.controller.fb.ListofNARptFB;

public class ListofNARptCNT extends DispatchAction {
//
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.actions.DispatchAction#unspecified(org.apache.struts
	 * .action.ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		return this.INITDETAIL(mapping, form, request, response);

	}

	/**
	 * this function is used forward control to main page.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward INITDETAIL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		System.out.println("---------ReturnItemListingRptCNT_NEW.INITDETAIL----->>-ReturnItemListingFB_NEW.jsp----");

		String target = "index";
		ListofNARptFB formBean = (ListofNARptFB) form;
		ListofNARptDATA.setInitDtl(formBean, request, response);
		return mapping.findForward(target);

	}

	/**
	 * this function is used to transfer control to Item category combo.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMCATEGORYCOMBO(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		ListofNARptFB formBean = (ListofNARptFB) form;
		ListofNARptDATA.setItemCategComboDtl(formBean, request, response);
		return null;

	}
	
	public ActionForward ITEMCATCMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ListofNARptFB formBean = (ListofNARptFB) form;
		formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ListofNARptDATA.getItemCatList(formBean,request, response);
		return null;
	}
	public ActionForward REQTYPECMB(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		ListofNARptFB formBean = (ListofNARptFB) form;
		formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ListofNARptDATA.getReqTypeList(formBean,request, response);
		return null;
	}
	
	public ActionForward ISSUE_STORE_LIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		ListofNARptFB formBean = (ListofNARptFB) form;
		formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		ListofNARptDATA.getIssuingStoreList(formBean,request, response);
		return null;
	}

	/**
	 * this function is used to get Drug Name combo.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward DRUGNAMECOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ListofNARptFB formBean = (ListofNARptFB) form;
		ListofNARptDATA.setDrugNameCombo(formBean, request, response);
		return null;

	}

	/**
	 * this function is used to get Drug Name combo.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward EXISTINGBATCH(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ListofNARptFB formBean = (ListofNARptFB) form;
		ListofNARptDATA.getExistingBatchList(formBean, request, response);
		return null;

	}

	/**
	 * Progname.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward PROGNAME(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ListofNARptFB formBean = (ListofNARptFB) form;
		formBean.setStrHospCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		//IssueDetailRptData_NEW.getProgrammeCombo(formBean, request, response);
		return null;
	}

	/**
	 * Showrpt.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void SHOWRPT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		ListofNARptFB formBean = (ListofNARptFB) form;
		formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
		System.out.println("---------ReturnItemListingRptCNT_NEW.SHOWRPT-----ReturnItemListingFB_NEW.jsp----");

		ListofNARptDATA.showReportNew(formBean, request, response);

	}
	
	/*
	 * public void SHOWRPT1(ActionMapping mapping, ActionForm form,
	 * HttpServletRequest request, HttpServletResponse response) throws
	 * HisException, SQLException {
	 * 
	 * ReturnItemListingRptFB_NEW formBean = (ReturnItemListingRptFB_NEW) form;
	 * formBean.setStrHospCode(request.getSession().getAttribute("HOSPITAL_CODE").
	 * toString()); ReturnItemListingRptData_NEW.showReport1(formBean, request,
	 * response);
	 * 
	 * }
	 */
	/**
	 * Cancel.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @return the action forward
	 */
	public ActionForward CANCEL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}

}

