/**
 * 
 */
package mms.transactions.controller.data;

import hisglobal.exceptions.HisException;

import javax.servlet.http.HttpServletRequest;

import mms.transactions.bo.PODeskViewTransBO;
import mms.transactions.controller.fb.PODeskViewTransFB;
import mms.transactions.controller.hlp.PODeskViewTransHLP;
import mms.transactions.vo.PODeskViewTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskViewTransDATA 
{
	public static void getScheduleDetails(PODeskViewTransFB _poDeskViewTransFB,	HttpServletRequest _request)
	{
		PODeskViewTransVO poDeskViewTransVO = null;
		PODeskViewTransBO poDeskViewTransBO = null;
		try {
			poDeskViewTransVO = new PODeskViewTransVO();
			poDeskViewTransBO = new PODeskViewTransBO();
			poDeskViewTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			
			poDeskViewTransVO.setStrSeatId((String) _request
					.getSession().getAttribute("SEATID"));

			_poDeskViewTransFB.setStrHospitalCode(poDeskViewTransVO
					.getStrHospitalCode());
			
			_poDeskViewTransFB.setStrStoreId(_request
					.getParameterValues("combo")[0]);
			poDeskViewTransVO.setStrPOTypeId(_request.getParameterValues("combo")[2]);
			_poDeskViewTransFB.setStrpoStatus(_request.getParameterValues("combo")[3]);
			_poDeskViewTransFB.setStrStoreName(_request
					.getParameter("comboValue"));
			//System.out.println("_request.getParameter(chk)"+_request.getParameter("chk"));
			_poDeskViewTransFB.setStrPONo(_request.getParameter("chk")
					.replace("@", "#").split("#")[1]);

			poDeskViewTransVO.setStrPONo(_poDeskViewTransFB.getStrPONo());
			poDeskViewTransVO.setStrStoreId(_poDeskViewTransFB
					.getStrStoreId());

			_poDeskViewTransFB.setStrStoreId(poDeskViewTransVO
					.getStrStoreId());
			poDeskViewTransVO.setStrpoStatus(_request.getParameterValues("combo")[3]);
			
			poDeskViewTransBO.getPODetails(poDeskViewTransVO);
			if (poDeskViewTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskViewTransVO.getStrMsgString());

			_poDeskViewTransFB.setStrPODate(poDeskViewTransVO
					.getStrPODate());
			_poDeskViewTransFB.setStrSupplierName(poDeskViewTransVO
					.getStrSupplierName());
			_poDeskViewTransFB.setStrPOType(poDeskViewTransVO
					.getStrPOType());
			_poDeskViewTransFB.setStrSupplierId(poDeskViewTransVO
					.getStrSupplierId());
			_poDeskViewTransFB.setStrPOTypeId(poDeskViewTransVO
					.getStrPOTypeId());
			_poDeskViewTransFB.setStrItemCat(poDeskViewTransVO
					.getStrItemCat());
			_poDeskViewTransFB.setStrItemCatName(poDeskViewTransVO
					.getStrItemCatName());

			poDeskViewTransBO.getForeignPODetails(poDeskViewTransVO);
			if (poDeskViewTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskViewTransVO.getStrMsgString());

			_poDeskViewTransFB.setStrAgentId(poDeskViewTransVO
					.getStrAgentId());
			_poDeskViewTransFB.setStrCAAgent(poDeskViewTransVO
					.getStrCAAgent());
			_poDeskViewTransFB.setStrCurrencyCode(poDeskViewTransVO
					.getStrCurrencyCode());
			_poDeskViewTransFB.setStrAgentName(poDeskViewTransVO
					.getStrAgentName());
			_poDeskViewTransFB.setStrCAAgentName(poDeskViewTransVO
					.getStrCAAgentName());
			_poDeskViewTransFB.setStrCurrency(poDeskViewTransVO
					.getStrCurrency());

			if (_poDeskViewTransFB.getStrPOTypeId().equals("24"))
				_poDeskViewTransFB.setStrForeignPODetails(PODeskViewTransHLP.getForeignPODetails(_poDeskViewTransFB));
			if (_poDeskViewTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskViewTransFB.getStrMsgString());
			_poDeskViewTransFB.setStrRequestDetails(PODeskViewTransHLP.getRequestDetails(_poDeskViewTransFB));
			if (_poDeskViewTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskViewTransFB.getStrMsgString());
			_poDeskViewTransFB.setStrItemDetails(PODeskViewTransHLP.getItemDetails(_poDeskViewTransFB));
			if (_poDeskViewTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskViewTransFB.getStrMsgString());

		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskViewTransDATA.getScheduleDetails()---->", _Err
							.getMessage());
			_poDeskViewTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	public static void getScheduleDetailsBS(
			PODeskViewTransFB _poDeskViewTransFB,
			HttpServletRequest _request) {
		PODeskViewTransVO poDeskViewTransVO = null;
		PODeskViewTransBO poDeskViewTransBO = null;
		try {
			poDeskViewTransVO = new PODeskViewTransVO();
			poDeskViewTransBO = new PODeskViewTransBO();
			poDeskViewTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			
			poDeskViewTransVO.setStrSeatId((String) _request
					.getSession().getAttribute("SEATID"));

			_poDeskViewTransFB.setStrHospitalCode(poDeskViewTransVO
					.getStrHospitalCode());
			
			_poDeskViewTransFB.setStrStoreId(_request
					.getParameterValues("combo")[0]);
			poDeskViewTransVO.setStrPOTypeId(_request.getParameterValues("combo")[2]);
			_poDeskViewTransFB.setStrpoStatus(_request.getParameterValues("combo")[3]);
			_poDeskViewTransFB.setStrStoreName(_request
					.getParameter("comboValue"));
			//System.out.println("_request.getParameter(chk)"+_request.getParameter("chk"));
			_poDeskViewTransFB.setStrPONo(_request.getParameter("chk")
					.replace("@", "#").split("#")[1]);

			poDeskViewTransVO.setStrPONo(_poDeskViewTransFB.getStrPONo());
			poDeskViewTransVO.setStrStoreId(_poDeskViewTransFB
					.getStrStoreId());

			_poDeskViewTransFB.setStrStoreId(poDeskViewTransVO
					.getStrStoreId());
			poDeskViewTransVO.setStrpoStatus(_request.getParameterValues("combo")[3]);
			
			poDeskViewTransBO.getPODetails(poDeskViewTransVO);
			if (poDeskViewTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskViewTransVO.getStrMsgString());

			_poDeskViewTransFB.setStrPODate(poDeskViewTransVO
					.getStrPODate());
			_poDeskViewTransFB.setStrSupplierName(poDeskViewTransVO
					.getStrSupplierName());
			_poDeskViewTransFB.setStrPOType(poDeskViewTransVO
					.getStrPOType());
			_poDeskViewTransFB.setStrSupplierId(poDeskViewTransVO
					.getStrSupplierId());
			_poDeskViewTransFB.setStrPOTypeId(poDeskViewTransVO
					.getStrPOTypeId());
			_poDeskViewTransFB.setStrItemCat(poDeskViewTransVO
					.getStrItemCat());
			_poDeskViewTransFB.setStrItemCatName(poDeskViewTransVO
					.getStrItemCatName());

			poDeskViewTransBO.getForeignPODetails(poDeskViewTransVO);
			if (poDeskViewTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskViewTransVO.getStrMsgString());

			_poDeskViewTransFB.setStrAgentId(poDeskViewTransVO
					.getStrAgentId());
			_poDeskViewTransFB.setStrCAAgent(poDeskViewTransVO
					.getStrCAAgent());
			_poDeskViewTransFB.setStrCurrencyCode(poDeskViewTransVO
					.getStrCurrencyCode());
			_poDeskViewTransFB.setStrAgentName(poDeskViewTransVO
					.getStrAgentName());
			_poDeskViewTransFB.setStrCAAgentName(poDeskViewTransVO
					.getStrCAAgentName());
			_poDeskViewTransFB.setStrCurrency(poDeskViewTransVO
					.getStrCurrency());

			if (_poDeskViewTransFB.getStrPOTypeId().equals("24"))
				_poDeskViewTransFB
						.setStrForeignPODetails(PODeskViewTransHLP
								.getForeignPODetails(_poDeskViewTransFB));
			if (_poDeskViewTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskViewTransFB.getStrMsgString());
			_poDeskViewTransFB.setStrRequestDetails(PODeskViewTransHLP
					.getRequestDetailsBS(_poDeskViewTransFB));
			if (_poDeskViewTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskViewTransFB.getStrMsgString());
			_poDeskViewTransFB.setStrItemDetails(PODeskViewTransHLP
					.getItemDetailsBS(_poDeskViewTransFB));
			if (_poDeskViewTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskViewTransFB.getStrMsgString());

		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskViewTransDATA.getScheduleDetails()---->", _Err
							.getMessage());
			_poDeskViewTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
}
