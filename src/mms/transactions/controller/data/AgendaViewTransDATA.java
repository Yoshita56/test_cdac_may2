package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;

import mms.transactions.bo.AgendaViewTransBO;
import mms.transactions.controller.fb.AgendaViewTransFB;
import mms.transactions.controller.hlp.AgendaViewTransHLP;
import mms.transactions.controller.hlp.ApprovalDtlHLP;
import mms.transactions.vo.AgendaViewTransVO;

public class AgendaViewTransDATA {

	/*
	 * Developer : Pramod Kumar Mehta Version : 1.0 Date : 08/April/2009
	 * Module:MMS Unit:Agenda View
	 */
	/**
	 * Method is Used to get the Data for view Page of Agenda Desk
	 * 
	 * @param formBean
	 * @param request
	 */
	public static void viewData(AgendaViewTransFB _agendaViewTransFB,
			HttpServletRequest _request) {
		AgendaViewTransBO agendaViewTransBO = null;
		AgendaViewTransVO agendaViewTransVO = null;
		String strmsgText = "";

		try {
			agendaViewTransBO = new AgendaViewTransBO();
			agendaViewTransVO = new AgendaViewTransVO();

			agendaViewTransVO.setStrHospitalCode(_request.getSession()
					.getAttribute("HOSPITAL_CODE").toString());
			agendaViewTransVO.setStrAgendaNo(_request.getParameter("chk")
					.replace("@", "#").split("#")[1]);
			agendaViewTransVO.setStrStoreId(_request.getParameter("chk")
					.replace("@", "#").split("#")[0]);

			agendaViewTransBO.viewData(agendaViewTransVO);
			if (agendaViewTransVO.getStrMsgType().equals("1"))
				throw new Exception(agendaViewTransVO.getStrMsgString());

			_agendaViewTransFB.setStrStoreName(_request.getParameter(
					"comboValue").split("#")[0]);
			_agendaViewTransFB.setStrToStoreName(agendaViewTransVO
					.getStrToStoreName());
			_agendaViewTransFB.setStrItemCategory(_request.getParameter(
					"comboValue").split("#")[1]);
			_agendaViewTransFB.setStrRemarks(agendaViewTransVO.getStrRemarks());
			_agendaViewTransFB.setStrGrantType(agendaViewTransVO
					.getStrGrantType());
			_agendaViewTransFB.setStrAgendaDate(agendaViewTransVO
					.getStrAgendaDate());
			_agendaViewTransFB.setStrAgendaNo(agendaViewTransVO
					.getStrAgendaNo());

			_agendaViewTransFB.setStrIndentDetails(AgendaViewTransHLP
					.getIndentDetails(agendaViewTransVO.getIndentDetailsWS()));
			_agendaViewTransFB.setStrCompiledItemDetails(AgendaViewTransHLP
					.getCompiledItemDetails(agendaViewTransVO
							.getCompiledItemDetailsWS()));
			_agendaViewTransFB.setStrApprovalDetails(ApprovalDtlHLP
					.getApprovalDtl(agendaViewTransVO.getStrStoreId(),
							agendaViewTransVO.getStrHospitalCode(),
							agendaViewTransVO.getStrToStore(),
							agendaViewTransVO.getStrItemCatogry(), "61",
							agendaViewTransVO.getStrAgendaNo()));
		} catch (Exception e) {
			strmsgText = "AgendaViewTransDATA.viewData(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"AgendaViewTransDATA->viewData()", strmsgText);
			_agendaViewTransFB.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			agendaViewTransBO = null;
			agendaViewTransVO = null;
		}

	}

}
