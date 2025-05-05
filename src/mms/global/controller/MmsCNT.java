package mms.global.controller;

import hisglobal.exceptions.HisException;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

// TODO: Auto-generated Javadoc
/**
 * The Class MmsCNT.
 */
public class MmsCNT extends DispatchAction {

	/**
	 * ITEMPARAMUTLINIT.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMPARAMUTLINIT(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException 
	{

		MmsFB formBean = (MmsFB) form;

		System.out.println("----MmsCNT.ITEMPARAMUTLINIT----");
		MmsDATA.initItemParam(request, response, formBean);

		return null;
	}
	
	public ActionForward ITEMPARAMUTLINITNEW(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		System.out.println("----MmsCNT.ITEMPARAMUTLINITNEW----");

		MmsDATA.initItemParamNEW(request, response, formBean);

		return null;
	}

	/**
	 * ITEMPARAMDTL.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMPARAMDTL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMPARAMDTL ----");

		MmsDATA.initItemParamDtl(request, response, formBean);

		return null;
	}

	/**
	 * ITEMEXEPARAMDTL.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMEXEPARAMDTL(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMEXEPARAMDTL ----");

		MmsDATA.initItemExistingParam(request, response, formBean);

		return null;
	}

	/**
	 * ITEMPARAMUTLMODIFY.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMPARAMUTLMODIFY(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMPARAMUTLMODIFY ----");

		MmsDATA.initItemParam(request, response, formBean);

		return null;
	}

	/**
	 * ITEMPARAMDTLMODI.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMPARAMDTLMODI(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMPARAMDTLMODI ----");

		MmsDATA.initExistingItemParamDtl(request, response, formBean);

		return null;
	}

	/**
	 * ITEMPARAMUTLDISPLAY.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMPARAMUTLDISPLAY(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMPARAMUTLDISPLAY ----");

		MmsDATA.initDisplayItemParam(request, response, formBean, "", "");

		return null;
	}

	/**
	 * ITEMPARAMDTLDISPLAY.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMPARAMDTLDISPLAY(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMPARAMDTLDISPLAY ----");

		MmsDATA.initDisplayItemParamDtl(request, response, formBean);

		return null;
	}

	/**
	 * ITEMPARAMDTLDISPLAY.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMPARAMDTLDISPLAYFORVIEW(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMPARAMDTLDISPLAYFORVIEW ----");

		MmsDATA.initDisplayItemParamDtlForView(request, response, formBean);

		return null;
	}

	/**
	 * INSERT.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . INSERT ----");

		MmsDATA.insert(request, formBean);

		return null;
	}

	/**
	 * UPDATE.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . UPDATE ----");

		MmsDATA.update(request, formBean);

		return null;
	}

	/**
	 * SEARCHITEMINIT.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward SEARCHITEMINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		System.out.println("---- MmsCNT . SEARCHITEMINIT ----");
		
		MmsFB formBean = (MmsFB) form;
            
		MmsDATA.searchItemInit(request, response, formBean);
		//MmsDATA.searchItemInitBS(request, response, formBean);

		return null;
	}
	
	/**
	 * SEARCHITEMINIT.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward SEARCHITEMINIT_WITHOUTCATG(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		System.out.println("---- MmsCNT . SEARCHITEMINIT_WITHOUTCATG ----");
		
		MmsFB formBean = (MmsFB) form;
            
		MmsDATA.searchItemInit_WITHOUTCATG(request, response, formBean);
		//MmsDATA.searchItemInitBS(request, response, formBean);

		return null;
	}
	public ActionForward SEARCHITEMINITBS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		System.out.println("---- MmsCNT . SEARCHITEMINITBS ----");
		
		MmsFB formBean = (MmsFB) form;
//Used To Get Group List
		MmsDATA.searchItemInitBS(request, response, formBean);

		return null;
	}

	/**
	 * GETSUBGROUPLIST.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward GETSUBGROUPLIST(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException 
	{

		System.out.println("---- MmsCNT . GETSUBGROUPLIST ----");
		
		MmsFB formBean = (MmsFB) form;

		MmsDATA.getSubGroupAndGenericItems(request, response, formBean);

		return null;
	}

	/**
	 * GETITEMLIST.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward GETITEMLIST(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . GETITEMLIST ----");

		MmsDATA.searchItemList(request, response, formBean);

		return null;
	}

	/**
	 * GETITEMBRANDLIST.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward GETITEMBRANDLIST(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . GETITEMBRANDLIST ----");

		MmsDATA.searchItemBrandList(request, response, formBean);

		return null;
	}
	
	/**
	 * GETITEMBRANDLIST.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward GETITEMBRANDLIST_ALLCatg(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . GETITEMBRANDLIST_ALLCatg ----");

		MmsDATA.searchItemBrandList_ALLCatg(request, response, formBean);

		return null;
	}


	/**
	 * GETUNITCOMBO.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward GETUNITCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . GETUNITCOMBO ----");

		MmsDATA.getUnitComboList(request, response, formBean);

		return null;
	}

	/**
	 * GETITEMMANDATORYDTLS.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward GETITEMMANDATORYDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		System.out.println("---- MmsCNT . GETITEMMANDATORYDTLS ----");
		
		MmsDATA.getItemMandatoryDetails(request, response);

		return null;
	}

	/**
	 * MMSLISTING.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward MMSLISTING(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		String target = "mmslist";
		MmsFB formBean = (MmsFB) form;
		formBean.setStrHospitalCode(request.getSession()
				.getAttribute("HOSPITAL_CODE").toString());
		formBean.setUsrArg(request.getParameter("mmsList"));
		formBean.setUsrFuncName(request.getParameter("usrFuncName"));
		
		System.out.println("---- MmsCNT . MMSLISTING ----");
		// System.out.println("here");
		return mapping.findForward(target);
	}

	/**
	 * FETCHMMSLISTING.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward FETCHMMSLISTING(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . FETCHMMSLISTING ----");
		
		MmsDATA.getMmsListingDtls(request, response, formBean);

		return null;
	}

	/**
	 * STOCKDTLSINIT - gets the Item & Drug Stock Details view used for ajax.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward STOCKDTLSINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . STOCKDTLSINIT ----");

		MmsDATA.stockItemDtlsInit(request, response, formBean);

		return null;
	}

	/**
	 * ISSUEDTLSINIT - gets the issue details view used for ajax.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ISSUEDTLSINIT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException 
	{

		MmsFB formBean = (MmsFB) form;
        System.out.println("-----------MmsCNT . ISSUEDTLSINIT [ After Save Issue Voucher ]--------------");
		MmsDATA.issueDtlsInit(request, response, formBean);

		return null;
	}
	
	public ActionForward ISSUEDTLSINITNEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ISSUEDTLSINITNEW ----");

		MmsDATA.issueDtlsInitNEW(request, response, formBean);

		return null;
	}
	
	public ActionForward DUPLICATEISSUEDTLSINITNEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;

		System.out.println("---- MmsCNT . DUPLICATEISSUEDTLSINITNEW ----");
		MmsDATA.duplicateIssueDtlsInitNEW(request, response, formBean);

		return null;
	}
	
	public ActionForward ISSUEDTLSINITSERVICE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ISSUEDTLSINITSERVICE ----");

		MmsDATA.issueDtlsInitService(request, response, formBean);

		return null;
	}
	

	/**
	 * FREEITEMDTLS - gets free item details view used for ajax.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward FREEITEMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		

		MmsDATA.getFreeItemDtls(request, response, formBean);

		return null;
	}

	/**
	 * PARTITEMDTLS - gets part item details view used for ajax.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward PARTITEMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . PARTITEMDTLS ----");

		MmsDATA.getPartItemDtls(request, response, formBean);

		return null;
	}

	/**
	 * WARRANTYDTLS - gets item warranty details view used for ajax.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward WARRANTYDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;

		MmsDATA.getItemWarrantyDtls(request, response, formBean);

		return null;
	}

	/**
	 * ITEMPARAMDTLS - gets item parameter details view in a special mode where
	 * popup name is specified.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMPARAMDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMPARAMDTLS ----");

		MmsDATA.initDisplayItemParam(request, response, formBean, "2",
				"itemOtherDtlsDiv");

		return null;
	}

	/**
	 * ITEMOTHERDTLS.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMOTHERDTLS(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMOTHERDTLS ----");

		MmsDATA.getInitItemOtherDtls(request, response, formBean);

		return null;
	}

	
	
	public ActionForward ITEMOTHERDTLSNEW(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMOTHERDTLSNEW ----");

		MmsDATA.getInitItemOtherDtlsNEW(request, response, formBean);

		return null;
	}
	/**
	 * ITEMOTHERGROUPDTLS.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMOTHERGROUPDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMOTHERGROUPDTLS ----");

		MmsDATA.getGroupList(request, response, formBean);

		return null;
	}

	/**
	 * ITEMOTHERSUBGROUPDTLS.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMOTHERSUBGROUPDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMOTHERSUBGROUPDTLS ----");

		MmsDATA.getSubGroupList(request, response, formBean);

		return null;
	}

	/**
	 * ITEMOTHERGENITEMDTLS.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMOTHERGENITEMDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMOTHERGENITEMDTLS ----");

		MmsDATA.getGenItemList(request, response, formBean);

		return null;
	}

	/**
	 * ITEMOTHERITEMDTLS.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward ITEMOTHERITEMDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . ITEMOTHERITEMDTLS ----");

		MmsDATA.getItemList(request, response, formBean);

		return null;
	}

	/**
	 * GETOTHERITEMUNITCOMBO.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward GETOTHERITEMUNITCOMBO(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . GETOTHERITEMUNITCOMBO ----");

		MmsDATA.getOtherItemUnitComboList(request, response, formBean);

		return null;
	}

	/**
	 * GETOTHERITEMMODIVIEW.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward GETOTHERITEMMODIVIEW(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . GETOTHERITEMMODIVIEW ----");

		MmsDATA.getOtherItemModifyInitView(request, response, formBean);

		return null;
	}

	/**
	 * GETMANUFCOMBO.
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward GETMANUFCOMBO(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . GETMANUFCOMBO ----");

		MmsDATA.getManufacturerComboList(request, response, formBean);

		return null;
	}

	/**
	 * GETADDNEWITEM - get the view of Add
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward GETADDNEWITEM(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . GETADDNEWITEM ----");

		MmsDATA.getAddNewItemView(request, response, formBean);

		return null;
	}

	/**
	 * SAVENEWITEMDTLS - save new item details
	 * 
	 * @param mapping
	 *            the mapping
	 * @param form
	 *            the form
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * 
	 * @return the action forward
	 * 
	 * @throws HisException
	 *             the his exception
	 * @throws SQLException
	 *             the SQL exception
	 */
	public ActionForward SAVENEWITEMDTLS(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws HisException, SQLException {

		MmsFB formBean = (MmsFB) form;
		
		System.out.println("---- MmsCNT . SAVENEWITEMDTLS ----");

		MmsDATA.insertAddNewItemView(request, response, formBean);

		return null;
	}


}
