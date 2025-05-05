package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.controller.data.MmsConfigMstDATA;
import mms.masters.controller.fb.MmsConfigMstFB;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsConfigMstCNT.
 */
public class MmsConfigMstCNT extends CSRFGardTokenAction {

	/**
	 * forwards control to the mmsconfig_mms Page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return ActionForward object with target
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
         generateToken(request);
		return this.mmsgeneraldtls(mapping, form, request, response);
	}

	/**
	 * forwards control to the mmsconfig_mms Page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return ActionForward object with target
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward mmsgeneraldtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.displayGenDtls(formBean , request);

		String target = "mmsgeneraldtls";
		return mapping.findForward(target);
	}

	/**
	 * forwards control to the mmsconfig_mms Page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return ActionForward object with target
	 * @throws Exception 
	 */
	public ActionForward SAVEGENDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
         validateToken(request, response);
		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.saveGenDtls(formBean , request);

		return this.mmsgeneraldtls(mapping, form, request, response);
	}

	/**
	 * forwards control to the mmsconfig_mms Page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return ActionForward object with target
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward mmsissuedtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
         generateToken(request);
		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.displayIssueDtls(formBean , request);

		String target = "mmsissuedtls";
		return mapping.findForward(target);
	}

	/**
	 * forwards control to the mmsconfig_mms Page.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return ActionForward object with target
	 * @throws Exception 
	 */
	public ActionForward SAVEISSUEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
         validateToken(request, response);
		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		formBean.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
		MmsConfigMstDATA.saveIssueDtls(formBean , request);

		return this.mmsissuedtls(mapping, form, request, response);
	}

	/**
	 * Mmspenaltydtls.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException the his exception
	 * @throws SQLException the SQL exception
	 */
	public ActionForward mmspenaltydtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
           generateToken(request);
		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.displayPenaltyDtls(formBean, request);

		String target = "mmspenaltydtls";
		return mapping.findForward(target);
	}

	/**
	 * SAVEPENALTYDTLS.
	 * 
	 * @param mapping the mapping
	 * @param form the form
	 * @param request the request
	 * @param response the response
	 * 
	 * @return the action forward
	 * @throws Exception 
	 */
	public ActionForward SAVEPENALTYDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         validateToken(request, response);
		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.savePenaltyDtls(formBean, request);

		return this.mmspenaltydtls(mapping, form, request, response);
	}

	public ActionForward mmsphysicalstockverifydtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.displayPhysicalStockVerifyDtls(formBean, request);

		String target = "mmsphysicalstockverifydtls";
		return mapping.findForward(target);
	}
	
	public ActionForward GETCATEGORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		generateToken(request);
		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.getItemCategoryList(request, response, formBean);
		
		return null;
	}
	
	public ActionForward GETSTATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.getStateList(request, response, formBean);
		
		return null;
	}
	
	
	public ActionForward GETPERIODDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.getPeriodDetails(request, response, formBean);
		
		return null;
	}
	
	
	public ActionForward SAVEPHYSTKVERIFYDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         validateToken(request, response);
		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.savePhysicalStockDtls(formBean, request);

		return this.mmsphysicalstockverifydtls(mapping, form, request, response);
	}
	
	public ActionForward mmsreportParamdtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.displayReportParameterDtls(formBean, request);

		String target = "mmsreportParamdtls";
		return mapping.findForward(target);
	}
	
	public ActionForward SAVEREPORTPARAMDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
         validateToken(request, response);
		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.saveReportParameterDtls(formBean, request);

		return this.mmsreportParamdtls(mapping, form, request, response);
	}

	
	
	public ActionForward CANCEL(ActionMapping _mapping, ActionForm _form,
			HttpServletRequest _request, HttpServletResponse _response)
			throws HisException {
		ActionForward acFwd = new ActionForward();
		acFwd.setPath("/hisglobal/initPage.jsp");
		acFwd.setContextRelative(true);
		return acFwd;
	}
	public ActionForward PENELTYDTL(ActionMapping _mapping, ActionForm _form,
	HttpServletRequest _request, HttpServletResponse _response)
	throws HisException {
		MmsConfigMstFB formBean = (MmsConfigMstFB) _form;
		MmsConfigMstDATA.getPeneltyDtl(formBean, _request, _response);
		return null;
	}
	
}
