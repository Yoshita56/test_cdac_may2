/**
 * 
 */
package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.bo.AgendaDeskModifyTransBO;
import mms.transactions.controller.fb.AgendaDeskModifyTransFB;
import mms.transactions.controller.hlp.AgendaDeskModifyTransHLP;
import mms.transactions.vo.AgendaDeskModifyTransVO;

/**
 * @author Pankaj Kumar
 * 
 */
public class AgendaDeskModifyTransDATA {
	public static void setToStoreValues(
			AgendaDeskModifyTransFB _AgendaDeskModifyTransFB,
			HttpServletRequest _request) {
		AgendaDeskModifyTransVO agendaDeskModifyTransVO = null;
		AgendaDeskModifyTransBO agendaBO = null;
		try {
			agendaDeskModifyTransVO = new AgendaDeskModifyTransVO();
			agendaBO = new AgendaDeskModifyTransBO();
			agendaDeskModifyTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			agendaDeskModifyTransVO.setStrSeatId((String) _request.getSession()
					.getAttribute("SEATID"));
			agendaDeskModifyTransVO.setStrStoreId(_request
					.getParameterValues("combo")[0]);
			agendaDeskModifyTransVO.setStrToStore(_AgendaDeskModifyTransFB
					.getStrToStore());
			agendaBO.setToStoreValues(agendaDeskModifyTransVO);
			if (agendaDeskModifyTransVO.getStrMsgType().equals("1"))
				throw new Exception(agendaDeskModifyTransVO.getStrMsgString());
			_AgendaDeskModifyTransFB
					.setStrToStoreValues(agendaDeskModifyTransVO
							.getStrToStoreValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskModifyTransDATA.setToStoreValues()---->", _Err
							.getMessage());
			_AgendaDeskModifyTransFB
					.setStrErr("Error####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void setFetchedData(
			AgendaDeskModifyTransFB _AgendaDeskModifyTransFB,
			HttpServletRequest _request) {
		AgendaDeskModifyTransVO agendaDeskModifyTransVO = null;
		AgendaDeskModifyTransBO agendaBO = null;
		try {
			agendaDeskModifyTransVO = new AgendaDeskModifyTransVO();
			agendaBO = new AgendaDeskModifyTransBO();

			agendaDeskModifyTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			agendaDeskModifyTransVO.setStrStoreId(_request.getParameter("chk")
					.replace("@", "#").split("#")[0]);
			agendaDeskModifyTransVO.setStrAgendaNo(_request.getParameter("chk")
					.replace("@", "#").split("#")[1]);

			agendaBO.setFetchedData(agendaDeskModifyTransVO);
			if (agendaDeskModifyTransVO.getStrMsgType().equals("1"))
				throw new Exception(agendaDeskModifyTransVO.getStrMsgString());
			_AgendaDeskModifyTransFB.setStrAgendaPeriod(agendaDeskModifyTransVO
					.getStrAgendaPeriod());
			_AgendaDeskModifyTransFB.setStrToStore(agendaDeskModifyTransVO
					.getStrToStore());
			_AgendaDeskModifyTransFB.setStrItemCat(agendaDeskModifyTransVO
					.getStrItemCat());
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskModifyTransDATA.setFetchedData()---->", _Err
							.getMessage());
			_AgendaDeskModifyTransFB
					.setStrErr("Error####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void setItemCatValues(
			AgendaDeskModifyTransFB _AgendaDeskModifyTransFB,
			HttpServletRequest _request) {
		AgendaDeskModifyTransVO agendaDeskModifyTransVO = null;
		AgendaDeskModifyTransBO agendaBO = null;
		try {
			agendaDeskModifyTransVO = new AgendaDeskModifyTransVO();
			agendaBO = new AgendaDeskModifyTransBO();
			agendaDeskModifyTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			agendaDeskModifyTransVO.setStrSeatId((String) _request.getSession()
					.getAttribute("SEATID"));
			agendaDeskModifyTransVO.setStrItemCat(_AgendaDeskModifyTransFB
					.getStrItemCat());
			agendaBO.setItemCatValues(agendaDeskModifyTransVO);
			if (agendaDeskModifyTransVO.getStrMsgType().equals("1"))
				throw new Exception(agendaDeskModifyTransVO.getStrMsgString());
			_AgendaDeskModifyTransFB
					.setStrItemCatValues(agendaDeskModifyTransVO
							.getStrItemCatValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskModifyTransDATA.setItemCatValues()---->", _Err
							.getMessage());
			_AgendaDeskModifyTransFB
					.setStrErr("Error####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void getIndentDetails(
			AgendaDeskModifyTransFB _AgendaDeskModifyTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strIndentDetails = "";
		AgendaDeskModifyTransVO agendaDeskModifyTransVO = null;
		AgendaDeskModifyTransBO agendaBO = null;
		try {
			agendaDeskModifyTransVO = new AgendaDeskModifyTransVO();
			agendaBO = new AgendaDeskModifyTransBO();

			agendaDeskModifyTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			agendaDeskModifyTransVO.setStrSeatId((String) _request.getSession()
					.getAttribute("SEATID"));

			agendaBO.getIndentDetails(agendaDeskModifyTransVO);
			if (agendaDeskModifyTransVO.getStrMsgType().equals("1"))
				throw new Exception(agendaDeskModifyTransVO.getStrMsgString());

			_AgendaDeskModifyTransFB.setWbIndentDetail(agendaDeskModifyTransVO
					.getWbIndentDetail());
			strIndentDetails = AgendaDeskModifyTransHLP
					.getIndentDetails(_AgendaDeskModifyTransFB);
			if (_AgendaDeskModifyTransFB.getStrMsgType().equals("1"))
				throw new Exception(_AgendaDeskModifyTransFB.getStrMsgString());

			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strIndentDetails);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskModifyTransDATA.getIndentDetails()---->", _Err
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

	public static void insert(AgendaDeskModifyTransFB _AgendaDeskModifyTransFB,
			HttpServletRequest _request) {
		AgendaDeskModifyTransVO agendaDeskModifyTransVO = null;
		try {
			_AgendaDeskModifyTransFB.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			_AgendaDeskModifyTransFB.setStrSeatId((String) _request
					.getSession().getAttribute("SEATID"));
			_AgendaDeskModifyTransFB.setStrStoreId(_request
					.getParameterValues("combo")[0]);
			
			

			agendaDeskModifyTransVO = (AgendaDeskModifyTransVO) TransferObjectFactory
					.populateData(
							"mms.transactions.vo.AgendaDeskModifyTransVO",
							_AgendaDeskModifyTransFB);

			//agendaBO.insert(agendaDeskModifyTransVO);
			if (agendaDeskModifyTransVO.getStrMsgType().equals("1"))
				throw new Exception(agendaDeskModifyTransVO.getStrMsgString());
			_AgendaDeskModifyTransFB
					.setStrToStoreValues(agendaDeskModifyTransVO
							.getStrToStoreValues());
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"AgendaDeskModifyTransDATA.insert()---->", _Err
							.getMessage());
			_AgendaDeskModifyTransFB
					.setStrErr("Error####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

}
