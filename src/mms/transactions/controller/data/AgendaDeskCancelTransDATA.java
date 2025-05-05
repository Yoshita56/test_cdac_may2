/**
 * 
 */
package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.bo.AgendaDeskCancelTransBO;
import mms.transactions.vo.AgendaDeskCancelTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 9-jun-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class AgendaDeskCancelTransDATA {
	public static void cancelAgenda(HttpServletRequest _request, HttpServletResponse _response) {
		AgendaDeskCancelTransVO agendaVO = null;
		AgendaDeskCancelTransBO agendaBO = null;
		try {
			agendaVO = new AgendaDeskCancelTransVO();
			agendaBO = new AgendaDeskCancelTransBO();
			
			agendaVO.setStrHospitalCode((String)_request.getSession().getAttribute("HOSPITAL_CODE"));
			agendaVO.setStrRemarks(_request.getParameter("comboValue").split("#")[1]);
			agendaVO.setStrSeatId((String)_request.getSession().getAttribute("SEATID"));
			agendaVO.setStrAgendaNo(_request.getParameter("comboValue").split("#")[2]);
			agendaVO.setStrStoreId(_request.getParameter("comboValue").split("#")[0]);

			agendaBO.cancelAgenda(agendaVO);
			if (agendaVO.getStrMsgType().equals("1"))
				throw new Exception(agendaVO.getStrMsgString());


		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskCancelTransDATA.cancelAgenda()---->", _Err
							.getMessage());
			try {
				_response.getWriter().print(
						"Error####Application Error [ERROR ID : "
								+ hisException.getErrorID()
								+ "], Contact System Administrator! ");
			} catch (Exception _Err1) {
			}
			hisException = null;
		}
	}
}
