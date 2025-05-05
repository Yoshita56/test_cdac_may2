package mms.masters.controller.action;

import hisglobal.exceptions.HisException;
import hisglobal.masterutil.GenericController;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.masters.bo.BOUnitValueMst;
import mms.masters.controller.utl.UTLUnitValueMst;
import mms.masters.vo.VOUnitValueMst;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class CNTUnitValueMst extends GenericController {

	public CNTUnitValueMst() {

		super(new UTLUnitValueMst(), "masters/CNTUnitValueMst");

	}

	// displays add page

	public ActionForward ADD(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		generateToken(request);
	//	BOUnitValueMst boMst = new BOUnitValueMst();
		VOUnitValueMst vo = (VOUnitValueMst) form;

		vo.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);

	
		String strModuleId = request.getSession().getAttribute("strModuleId")
				.toString();
		//  System.out.println("in cnt modid--"+strModuleId);

		vo.setStrModuleId(strModuleId);

		vo.setModuleName(request.getParameter("comboValue"));
		String target = "add";
		return mapping.findForward(target);

	}

	// displays modify page

	public ActionForward MODIFY(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, SQLException {
		
		generateToken(request);
		String target = "";
		try {
			
			BOUnitValueMst bo = new BOUnitValueMst();
			VOUnitValueMst vo = (VOUnitValueMst) form;
			vo.setModuleName(request.getParameter("comboValue"));
			vo.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);

			bo.modifyRecord(request.getParameter("chk"), vo);
			////  System.out.println("vo.getIsValid() in CNT--"+vo.getIsValid());

		} catch (Exception e) {
			// Empty
		}
		target = "modify";
		return mapping.findForward(target);

	}

	// FROMUNITVAL mode called from ajax function for creating combo for from
	// unit
	public ActionForward FROMUNITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {

		// String val = (String) request.getParameter("modName");

		String value = (String) request.getParameter("modName");
		VOUnitValueMst vo = (VOUnitValueMst) form;

		vo.setModuleName(value);
		vo.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
		String comboValues = vo.getCmbval1();

		try {
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(comboValues);

		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		return null;
	}

	// TOUNITVAL mode called from ajax function for creating combo for to unit
	public ActionForward TOUNITVAL(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws HisException, Exception {

		String val = (String) request.getParameter("fromunit");
		String val1 = (String) request.getParameter("modName");
		VOUnitValueMst vo = (VOUnitValueMst) form;

		vo.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
		vo.setFromUnit(val);
		vo.setModuleName(val1);

		String comboValues = vo.getCmbval2();

		try {
			response.setHeader("Cache-Control", "no-cache");
			response.getWriter().print(comboValues);

		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
		return null;
	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// update modified record

	public ActionForward UPDATE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception

	{
		validateToken(request, response);
		String target = "";
		VOUnitValueMst vo = (VOUnitValueMst) form;
		BOUnitValueMst bo = new BOUnitValueMst();
		vo.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
		vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		target = bo.updateRecord(request.getParameter("chk"), vo);

		if (target.equals("list"))
			return this.LIST(mapping, form, request, response);
		else
			return mapping.findForward(target);
	}

	// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// insert record

	public ActionForward SAVE(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception, SQLException {
          validateToken(request, response);
		// String target ="";

		BOUnitValueMst bo = new BOUnitValueMst();
		VOUnitValueMst vo = (VOUnitValueMst) form;
		vo.setStrHospitalCode(MmsConfigUtil.GLOBAL_HOSPITAL_CODE);
		vo.setStrSeatId(request.getSession().getAttribute("SEATID").toString());

		bo.InsertRecord(vo);

		return this.ADD(mapping, form, request, response);

	}

}
