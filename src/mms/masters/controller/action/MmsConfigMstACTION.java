package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.presentation.CSRFGardTokenAction;
//import hisglobal.presentation.CSRFGardTokenAction;
import hisglobal.utility.HelperMethods;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.bo.MmsConfigMstBO;
import mms.masters.controller.data.MmsConfigMstDATA;
import mms.masters.controller.fb.MmsConfigMstFB;
import mms.masters.vo.MmsConfigMstVO;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsConfigMstCNT.
 */
public class MmsConfigMstACTION extends CSRFGardTokenAction {

	/**
	 * forwards control to the ipdconfig_ipd Page
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target 
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward unspecified(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
			
		return this.mmsgeneraldtls(mapping, form, request, response);
	}
	
	public ActionForward mmsgeneraldtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
				generateToken(request);
		     	MmsConfigMstFB fb = (MmsConfigMstFB)form;
				MmsConfigMstDATA.displayGenDtlsNew(fb,request);
				
			return mapping.findForward("mmsgeneraldtls");
	}
	
	public ActionForward mmsissuedtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		     	MmsConfigMstFB fb = (MmsConfigMstFB)form;
				MmsConfigMstDATA.displayIssueDtlsNew(fb, request);
				//bo.displayIssueDtls(vo);
				
			return mapping.findForward("mmsissuedtls");
	}
	
	public ActionForward mmspenaltydtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		     	MmsConfigMstFB fb = (MmsConfigMstFB)form;
				MmsConfigMstDATA.displayPenaltyDtls(fb, request);
				//bo.displayPenaltyDtls(vo);
				
			return mapping.findForward("mmspenaltydtls");
	}
	
	public ActionForward mmsphysicalstockverifydtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		     	MmsConfigMstFB fb = (MmsConfigMstFB)form;
				MmsConfigMstDATA.displayPhysicalStockVerifyDtls(fb, request);
				//bo.displayPhysicalStockDtls(vo);
				
			return mapping.findForward("mmsphysicalstockverifydtls");
	}
	
	public ActionForward mmsreportParamdtls(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
		     	MmsConfigMstFB fb = (MmsConfigMstFB)form;
				MmsConfigMstDATA.displayReportParameterDtls(fb, request);
				//bo.displayReportDetailsValues(vo);
				
			return mapping.findForward("mmsreportParamdtls");
	}
	
	
	
	/**
	 * invokes the saveValues method of the BOMmsConfigMst 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return - ActionForward with target save by invoking unspecified method.
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward SAVEGENDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException,Exception{
		validateToken(request, response);
		    	MmsConfigMstFB fb = (MmsConfigMstFB)form;
				MmsConfigMstVO vo = new MmsConfigMstVO();
				HelperMethods.populate(vo, fb);
				MmsConfigMstBO bo = new MmsConfigMstBO();
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrStoreId(fb.getStrStoreId().replace("^", "#").split("#")[0]);
				vo.setStrExpAlertDays(fb.getStrExpAlertDays());
				vo.setStrContractValue(fb.getStrContractValue());
				vo.setStrStampPaperAmt(fb.getStrStampPaperAmt());
				vo.setStrBilingIntegration(fb.getStrBillingIntegration());
				vo.setStrTaxRate(fb.getStrTaxRate());
				vo.setStrWhetherSingleItemMultiSupplier(fb.getStrWhetherSingleItemMultiSupplier());
				vo.setStrFMSIntegration(fb.getStrFMSIntegration());
				vo.setStrIndentLimitAmt(fb.getStrIndentLimitAmt());
			//	vo.setStrDefaultHospCode(fb.getStrDefaultHospCode());
				//bo.saveValues(vo);
				bo.saveGeneralDtlDataInDataBase(vo);
				fb.setStrNormalMsg("Data Saved Successfully");
				
			return this.mmsgeneraldtls(mapping, form, request, response);
	}
	
	/**
	 * invokes the saveValues method of the BOMmsConfigMst 
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return - ActionForward with target save by invoking unspecified method.
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward SAVEISSUEDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException,Exception{
		validateToken(request, response);
		    	MmsConfigMstFB fb = (MmsConfigMstFB)form;
				MmsConfigMstVO vo = new MmsConfigMstVO();
				HelperMethods.populate(vo, fb);
				MmsConfigMstBO bo = new MmsConfigMstBO();
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				//bo.saveValues(vo);
				bo.saveissueDtlDataInDataBase(vo);
				fb.setStrNormalMsg("Data Saved Successfully");
				
			return this.mmsissuedtls(mapping, form, request, response);
	}
	
	public ActionForward SAVEPENALTYDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException,Exception {
		      
		validateToken(request, response);
		    
				MmsConfigMstFB fb = (MmsConfigMstFB)form;
				MmsConfigMstVO vo = new MmsConfigMstVO();
				HelperMethods.populate(vo, fb);
				MmsConfigMstBO bo = new MmsConfigMstBO();
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				//bo.saveValues(vo);
				bo.savePenaltyDtlDataInDataBase(vo);
				fb.setStrNormalMsg("Data Saved Successfully");
				
			return this.mmspenaltydtls(mapping, form, request, response);
	}
	
	public ActionForward SAVEPHYSTKVERIFYDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException,Exception {
		validateToken(request, response);
		    	MmsConfigMstFB fb = (MmsConfigMstFB)form;
				MmsConfigMstVO vo = new MmsConfigMstVO();
				HelperMethods.populate(vo, fb);
				MmsConfigMstBO bo = new MmsConfigMstBO();
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				bo.savePhysicalStockDtlDataInDataBase(vo);
				fb.setStrNormalMsg("Data Saved Successfully");
				return this.mmsphysicalstockverifydtls(mapping, form, request, response);
			
	}
	public ActionForward SAVEREPORTPARAMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException,Exception{
		validateToken(request, response);
		    	MmsConfigMstFB fb = (MmsConfigMstFB)form;
				MmsConfigMstVO vo = new MmsConfigMstVO();
				HelperMethods.populate(vo, fb);
				MmsConfigMstBO bo = new MmsConfigMstBO();
				vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());
				vo.setStrHospitalCode(request.getSession().getAttribute("HOSPITAL_CODE").toString());
				fb.setStrNormalMsg("Data Saved Successfully");
				bo.saveReportDtlinDataBase(vo);
				
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
	
	public ActionForward GETCATEGORY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		MmsConfigMstFB formBean = (MmsConfigMstFB) form;
		MmsConfigMstDATA.getItemCategoryList(request, response, formBean);
		
		return null;
	}
	
	/**
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward INITIALPAGE(ActionMapping mapping,ActionForm form,
			HttpServletRequest request,HttpServletResponse response)
            throws HisException{
				/*ActionForward acFwd = new ActionForward();
				acFwd.setPath("/startup/initPage.jsp");
				acFwd.setContextRelative(true);
				return acFwd;*/
				return mapping.findForward("INIT");
		}
	
}
