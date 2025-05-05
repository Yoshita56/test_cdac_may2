package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.bo.BOUnitMst;
import mms.masters.controller.utl.UTLUnitMst;
import mms.masters.vo.VOUnitMst;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;


/**
 * Developer : Anshul Jindal 
 * 
 */
public class BSCNTUnitMst extends GenericController {

	public BSCNTUnitMst() {

		super(new UTLUnitMst(), "masters/BSCNTUnitMst");
	}

	String strTarget = null;

	/**
	 * forwards control to the Unit Master Add Page
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
          generateToken(request);
		String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
				.toString();
		String seatid = request.getSession().getAttribute("SEATID").toString();
		String strModuleId = request.getSession().getAttribute("strModuleId")
				.toString();
		////  System.out.println("in cnt modid--"+strModuleId);

		 String strModuleName = request.getParameter("comboValue");
		//System.out.println("module name-->"+strModuleName);

		BOUnitMst boMst = new BOUnitMst();
		VOUnitMst formBean = (VOUnitMst) form;
		 formBean.setStrModuleName(strModuleName);
		// formBean.setStrUnitComboValues(formBean.getStrUnitComboValues());

		formBean.setStrHospitalCode(hosCode);
		formBean.setStrSeatId(seatid);
		formBean.setStrModuleVal(strModuleId);

		try {
			boMst.initialAdd(formBean);
			boMst.modName(formBean);
		} catch (Exception e) {
		}
		strTarget = "add";

		return mapping.findForward(strTarget);
	}

	/**
	 * invokes insert logic and forwards control to the Unit Master Add Page
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward INSERT(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
          validateToken(request, response);
		String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
				.toString();
		String seatid = request.getSession().getAttribute("SEATID").toString();
		String strModuleId = request.getSession().getAttribute("strModuleId")
				.toString();

		BOUnitMst boMst = new BOUnitMst();
		VOUnitMst formBean = (VOUnitMst) form;

		formBean.setStrHospitalCode(hosCode);
		formBean.setStrSeatId(seatid);
		formBean.setStrModuleVal(strModuleId);
		boMst.insert(formBean);

		return this.ADD(mapping, form, request, response);

	}

	/**
	 * invoks modify logic and forwards control to the Unit Master Modify Page
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		generateToken(request);
		BOUnitMst boMst = new BOUnitMst();
		VOUnitMst formBean = (VOUnitMst) form;
		String strChk = request.getParameter("chk");
		boMst.modify(strChk, formBean);
		strTarget = "modify";

		return mapping.findForward(strTarget);
	}

	/**
	 * invokes update logic and forwards control to the Unit Master Add or
	 * Modify Page based on the return value
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward object with target
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
		 validateToken(request, response);
		String hosCode = request.getSession().getAttribute("HOSPITAL_CODE")
				.toString();
		String seatid = request.getSession().getAttribute("SEATID").toString();

		boolean returnValue = false;
		BOUnitMst boMst = new BOUnitMst();
		VOUnitMst formBean = (VOUnitMst) form;
		String strChk = request.getParameter("chk");
		// formBean.setStrLastModSeatId(request.getSession().getAttribute("SEATID").toString());
		formBean.setStrHospitalCode(hosCode);
		formBean.setStrSeatId(seatid);
		formBean.setStrModuleVal(request.getSession().getAttribute(
				"strModuleId").toString());
		returnValue = boMst.update(strChk, formBean);

		if (returnValue) {

			return this.LIST(mapping, form, request, response);
		} else {

			return this.MODIFY(mapping, form, request, response);
		}
	}

	/**
	 * invoked by the Ajax function and retrieves Unit Combo Values
	 * 
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return null
	 * @throws HisException
	 * @throws SQLException
	 */
	public ActionForward BASEUNITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		String strModuleVal = (String) request.getParameter("modName");
		String comboValues = null;
		VOUnitMst formBean = (VOUnitMst) form;
		formBean.setStrModuleVal(strModuleVal);

		comboValues = formBean.getStrUnitComboValues();

		try {
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(comboValues);
		} catch (IOException e) {

			new HisException("Unit Master", "BSCNTUnitMst.BASEUNITVAL()", e
					.getMessage());
		}

		return null;
	}
}
