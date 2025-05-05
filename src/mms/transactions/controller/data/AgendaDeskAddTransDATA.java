/**
 * 
 */
package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.bo.AgendaDeskAddTransBO;
import mms.transactions.controller.fb.AgendaDeskAddTransFB;
import mms.transactions.controller.hlp.AgendaDeskAddTransHLP;
import mms.transactions.vo.AgendaDeskAddTransVO;

/**
 * @author Amit Kumar Creation Date:- 8-4-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class AgendaDeskAddTransDATA {
	public static void setToStoreValues(AgendaDeskAddTransFB _agendaFB,
			HttpServletRequest _request) {
		AgendaDeskAddTransVO agendaVO = null;
		AgendaDeskAddTransBO agendaBO = null;
		try {
			agendaVO = new AgendaDeskAddTransVO();
			agendaBO = new AgendaDeskAddTransBO();
			agendaVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			agendaVO.setStrSeatId((String) _request.getSession().getAttribute(
					"SEATID"));
			agendaVO.setStrStoreId(_request.getParameterValues("combo")[0]);
			agendaVO.setStrItemCat(_request.getParameterValues("combo")[1]);
			_agendaFB.setStrStoreName(_request.getParameter("comboValue").split("#")[0]);
			_agendaFB.setStrItemCatName(_request.getParameter("comboValue").split("#")[1]);

			_agendaFB.setStrStoreId(agendaVO.getStrStoreId());
			_agendaFB.setStrItemCat(agendaVO.getStrItemCat());
			
			// Calling BO Method
			agendaBO.setToStoreValues(agendaVO);
			_agendaFB.setStrAgendaPeriod(agendaVO.getStrAgendaPeriod());
						
			if (agendaVO.getStrMsgType().equals("1"))
				throw new Exception(agendaVO.getStrMsgString());
			// _response.getWriter().print(agendaVO.getStrToStoreValues());
			_agendaFB.setStrToStoreValues(agendaVO.getStrToStoreValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskAddTransDATA.setToStoreValues()---->", _Err
							.getMessage());
			_agendaFB.setStrErr("ERROR####Application Error [ERROR ID : "
					+ hisException.getErrorID()
					+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void setGrantTypeValues(AgendaDeskAddTransFB _agendaFB,
			HttpServletRequest _request) {
		AgendaDeskAddTransVO agendaVO = null;
		AgendaDeskAddTransBO agendaBO = null;
		try {
			agendaVO = new AgendaDeskAddTransVO();
			agendaBO = new AgendaDeskAddTransBO();
			agendaVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			agendaBO.setGrantTypeValues(agendaVO);
			if (agendaVO.getStrMsgType().equals("1"))
				throw new Exception(agendaVO.getStrMsgString());
			_agendaFB.setStrGrantTypeValues(agendaVO.getStrGrantTypeValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskAddTransDATA.setGrantTypeValues()---->", _Err
							.getMessage());
			_agendaFB.setStrErr("ERROR####Application Error [ERROR ID : "
					+ hisException.getErrorID()
					+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void setRateUnitValues(AgendaDeskAddTransFB _agendaFB,
			HttpServletRequest _request) {
		AgendaDeskAddTransVO agendaVO = null;
		AgendaDeskAddTransBO agendaBO = null;
		try {
			agendaVO = new AgendaDeskAddTransVO();
			agendaBO = new AgendaDeskAddTransBO();
			agendaVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			agendaVO.setStrSeatId((String) _request.getSession().getAttribute(
					"SEATID"));
			agendaBO.setRateUnitValues(agendaVO);
			if (agendaVO.getStrMsgType().equals("1"))
				throw new Exception(agendaVO.getStrMsgString());
			_agendaFB.setStrRateUnitValues(agendaVO.getStrRateUnitValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskAddTransDATA.setRateUnitValues()---->", _Err
							.getMessage());
			_agendaFB.setStrErr("Error####Application Error [ERROR ID : "
					+ hisException.getErrorID()
					+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void getIndentDetails(AgendaDeskAddTransFB _agendaFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strIndentDetails = "";
		AgendaDeskAddTransVO agendaVO = null;
		AgendaDeskAddTransBO agendaBO = null;
		try {
			agendaVO = new AgendaDeskAddTransVO();
			agendaBO = new AgendaDeskAddTransBO();

			agendaVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			agendaVO.setStrSeatId((String) _request.getSession().getAttribute(
					"SEATID"));
			agendaVO.setStrItemCat(_request.getParameter("strItemCat"));
			agendaVO.setStrStoreId(_request.getParameter("strStoreId"));
			agendaVO.setStrAgendaType(_agendaFB.getStrAgendaType());
			agendaBO.getIndentDetails(agendaVO);
			if (agendaVO.getStrMsgType().equals("1"))
				throw new Exception(agendaVO.getStrMsgString());

			_agendaFB.setWbIndentDetail(agendaVO.getWbIndentDetail());
			strIndentDetails = AgendaDeskAddTransHLP
					.getIndentDetails(_agendaFB);
			if (_agendaFB.getStrMsgType().equals("1"))
				throw new Exception(_agendaFB.getStrMsgString());

			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strIndentDetails);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskAddTransDATA.getIndentDetails()---->", _Err
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

	public static void getIndentItemDetails(AgendaDeskAddTransFB _agendaFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strIndentDetails = "";
		AgendaDeskAddTransVO agendaVO = null;
		AgendaDeskAddTransBO agendaBO = null;
		try {
			agendaVO = new AgendaDeskAddTransVO();
			agendaBO = new AgendaDeskAddTransBO();

			agendaVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			_agendaFB.setStrHospitalCode(agendaVO.getStrHospitalCode());
			agendaVO.setStrIndentNo(_request.getParameter("strIndentNo"));
			agendaVO.setStrStoreIds(_request.getParameter("strStoreIds"));

			agendaBO.getIndentItemDetails(agendaVO);
			if (agendaVO.getStrMsgType().equals("1"))
				throw new Exception(agendaVO.getStrMsgString());

			_agendaFB.setWbIndentItemDetail(agendaVO.getWbIndentItemDetail());
			
			strIndentDetails = AgendaDeskAddTransHLP.getIndentItemDetails(_agendaFB);
			
			if (_agendaFB.getStrMsgType().equals("1"))
				throw new Exception(_agendaFB.getStrMsgString());

			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strIndentDetails);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskAddTransDATA.getIndentItemDetails()---->", _Err
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

	public static void getIndentPopupDetails(AgendaDeskAddTransFB _agendaFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strIndentDetails = "";
		AgendaDeskAddTransVO agendaVO = null;
		AgendaDeskAddTransBO agendaBO = null;
		try {
			agendaVO = new AgendaDeskAddTransVO();
			agendaBO = new AgendaDeskAddTransBO();

			agendaVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			agendaVO.setStrIndentNo(_request.getParameter("strIndentNo"));
			agendaVO.setStrStoreId(_request.getParameter("strStoreId"));
			_agendaFB.setStrIndentNo(_request.getParameter("strIndentNo")); 
			// Calling BO Method's
			agendaBO.getIndentPopupDetails(agendaVO);
			if (agendaVO.getStrMsgType().equals("1"))
				throw new Exception(agendaVO.getStrMsgString());

			_agendaFB.setWbIndentDetail(agendaVO.getWbIndentDetail());
			strIndentDetails = AgendaDeskAddTransHLP
					.getIndentPopupDetails(_agendaFB);
			if (_agendaFB.getStrMsgType().equals("1"))
				throw new Exception(_agendaFB.getStrMsgString());
			_response.getWriter().print(strIndentDetails);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskAddTransDATA.getIndentPopupDetails()---->", _Err
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

	public static void insert(AgendaDeskAddTransFB _agendaFB,
			HttpServletRequest _request) {
		AgendaDeskAddTransVO agendaVO = null;
		AgendaDeskAddTransBO agendaBO = null;
		try {
			agendaBO = new AgendaDeskAddTransBO();
			_agendaFB.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			_agendaFB.setStrSeatId((String) _request.getSession().getAttribute(
					"SEATID"));
			_agendaFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			_agendaFB
					.setStrAgendaStatus(_request.getParameterValues("combo")[1]);

			agendaVO = (AgendaDeskAddTransVO) TransferObjectFactory
					.populateData("mms.transactions.vo.AgendaDeskAddTransVO",
							_agendaFB);
			agendaBO.insert(agendaVO);
			if (agendaVO.getStrMsgType().equals("1"))
				throw new Exception(agendaVO.getStrMsgString());
			_agendaFB.setStrToStoreValues(agendaVO.getStrToStoreValues());
		} catch (Exception _Err) {
			_Err.printStackTrace();
			_agendaFB.setStrMsgType("1");
			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskAddTransDATA.insert()---->", _Err.getMessage());
			_agendaFB.setStrErr("Error####Application Error [ERROR ID : "
					+ hisException.getErrorID()
					+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

}
