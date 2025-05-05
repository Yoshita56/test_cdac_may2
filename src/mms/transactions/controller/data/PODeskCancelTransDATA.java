/**
 * 
 */
package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;

import mms.transactions.bo.PODeskCancelTransBO;
import mms.transactions.controller.fb.PODeskCancelTransFB;
import mms.transactions.controller.hlp.PODeskCancelTransHLP;
import mms.transactions.vo.PODeskCancelTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskCancelTransDATA {
	public static void getScheduleDetails(
			PODeskCancelTransFB _poDeskCancelTransFB,
			HttpServletRequest _request) {
		PODeskCancelTransVO poDeskCancelTransVO = null;
		PODeskCancelTransBO poDeskCancelTransBO = null;
		HisUtil hisUtil = null;
		try {
			hisUtil = new HisUtil("Material Management System","PODeskCancelDATA");
			poDeskCancelTransVO = new PODeskCancelTransVO();
			poDeskCancelTransBO = new PODeskCancelTransBO();
			poDeskCancelTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			
			poDeskCancelTransVO.setStrSeatId((String) _request
					.getSession().getAttribute("SEATID"));

			_poDeskCancelTransFB.setStrHospitalCode(poDeskCancelTransVO
					.getStrHospitalCode());

			_poDeskCancelTransFB.setStrStoreId(_request
					.getParameterValues("combo")[0]);

			_poDeskCancelTransFB.setStrStoreName(_request
					.getParameter("comboValue"));
			_poDeskCancelTransFB.setStrSysdate(hisUtil.getDSDate("DD-Mon-yyyy"));

			_poDeskCancelTransFB.setStrPONo(_request.getParameter("chk")
					.replace("@", "#").split("#")[1]);

			poDeskCancelTransVO.setStrPONo(_poDeskCancelTransFB.getStrPONo());
			poDeskCancelTransVO.setStrStoreId(_poDeskCancelTransFB
					.getStrStoreId());

			_poDeskCancelTransFB.setStrStoreId(poDeskCancelTransVO
					.getStrStoreId());

			poDeskCancelTransBO.getPODetails(poDeskCancelTransVO);
			if (poDeskCancelTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskCancelTransVO.getStrMsgString());

			_poDeskCancelTransFB.setStrPODate(poDeskCancelTransVO
					.getStrPODate());
			_poDeskCancelTransFB.setStrSupplierName(poDeskCancelTransVO
					.getStrSupplierName());
			_poDeskCancelTransFB.setStrPOType(poDeskCancelTransVO
					.getStrPOType());
			_poDeskCancelTransFB.setStrSupplierId(poDeskCancelTransVO
					.getStrSupplierId());
			_poDeskCancelTransFB.setStrPOTypeId(poDeskCancelTransVO
					.getStrPOTypeId());
			_poDeskCancelTransFB.setStrItemCat(poDeskCancelTransVO
					.getStrItemCat());
			_poDeskCancelTransFB.setStrItemCatName(poDeskCancelTransVO
					.getStrItemCatName());

			poDeskCancelTransBO.getForeignPODetails(poDeskCancelTransVO);
			if (poDeskCancelTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskCancelTransVO.getStrMsgString());

			_poDeskCancelTransFB.setStrAgentId(poDeskCancelTransVO
					.getStrAgentId());
			_poDeskCancelTransFB.setStrCAAgent(poDeskCancelTransVO
					.getStrCAAgent());
			_poDeskCancelTransFB.setStrCurrencyCode(poDeskCancelTransVO
					.getStrCurrencyCode());
			_poDeskCancelTransFB.setStrAgentName(poDeskCancelTransVO
					.getStrAgentName());
			_poDeskCancelTransFB.setStrCAAgentName(poDeskCancelTransVO
					.getStrCAAgentName());
			_poDeskCancelTransFB.setStrCurrency(poDeskCancelTransVO
					.getStrCurrency());

			poDeskCancelTransBO.setEmployeeValues(poDeskCancelTransVO);
			if (poDeskCancelTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskCancelTransVO.getStrMsgString());

			_poDeskCancelTransFB.setStrCancelByValues(poDeskCancelTransVO
					.getStrEmployeeValues());
			_poDeskCancelTransFB.setStrApprovedByValues(poDeskCancelTransVO
					.getStrEmployeeValues());

			if (_poDeskCancelTransFB.getStrPOTypeId().equals("24"))
				_poDeskCancelTransFB
						.setStrForeignPODetails(PODeskCancelTransHLP
								.getForeignPODetails(_poDeskCancelTransFB));
			if (_poDeskCancelTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskCancelTransFB.getStrMsgString());
			_poDeskCancelTransFB.setStrScheduleDetails(PODeskCancelTransHLP
					.getScheduleDetails(_poDeskCancelTransFB));

		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskCancelTransDATA.getScheduleDetails()---->", _Err
							.getMessage());
			_poDeskCancelTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	public static void getScheduleDetailsBS(
			PODeskCancelTransFB _poDeskCancelTransFB,
			HttpServletRequest _request) {
		PODeskCancelTransVO poDeskCancelTransVO = null;
		PODeskCancelTransBO poDeskCancelTransBO = null;
		HisUtil hisUtil = null;
		try {
			hisUtil = new HisUtil("Material Management System","PODeskCancelDATA");
			poDeskCancelTransVO = new PODeskCancelTransVO();
			poDeskCancelTransBO = new PODeskCancelTransBO();
			poDeskCancelTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			
			poDeskCancelTransVO.setStrSeatId((String) _request
					.getSession().getAttribute("SEATID"));

			_poDeskCancelTransFB.setStrHospitalCode(poDeskCancelTransVO
					.getStrHospitalCode());

			_poDeskCancelTransFB.setStrStoreId(_request
					.getParameterValues("combo")[0]);

			_poDeskCancelTransFB.setStrStoreName(_request
					.getParameter("comboValue"));
			_poDeskCancelTransFB.setStrSysdate(hisUtil.getDSDate("DD-Mon-yyyy"));

			_poDeskCancelTransFB.setStrPONo(_request.getParameter("chk")
					.replace("@", "#").split("#")[1]);

			poDeskCancelTransVO.setStrPONo(_poDeskCancelTransFB.getStrPONo());
			poDeskCancelTransVO.setStrStoreId(_poDeskCancelTransFB
					.getStrStoreId());

			_poDeskCancelTransFB.setStrStoreId(poDeskCancelTransVO
					.getStrStoreId());

			poDeskCancelTransBO.getPODetails(poDeskCancelTransVO);
			if (poDeskCancelTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskCancelTransVO.getStrMsgString());

			_poDeskCancelTransFB.setStrPODate(poDeskCancelTransVO
					.getStrPODate());
			_poDeskCancelTransFB.setStrSupplierName(poDeskCancelTransVO
					.getStrSupplierName());
			_poDeskCancelTransFB.setStrPOType(poDeskCancelTransVO
					.getStrPOType());
			_poDeskCancelTransFB.setStrSupplierId(poDeskCancelTransVO
					.getStrSupplierId());
			_poDeskCancelTransFB.setStrPOTypeId(poDeskCancelTransVO
					.getStrPOTypeId());
			_poDeskCancelTransFB.setStrItemCat(poDeskCancelTransVO
					.getStrItemCat());
			_poDeskCancelTransFB.setStrItemCatName(poDeskCancelTransVO
					.getStrItemCatName());

			poDeskCancelTransBO.getForeignPODetails(poDeskCancelTransVO);
			if (poDeskCancelTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskCancelTransVO.getStrMsgString());

			_poDeskCancelTransFB.setStrAgentId(poDeskCancelTransVO
					.getStrAgentId());
			_poDeskCancelTransFB.setStrCAAgent(poDeskCancelTransVO
					.getStrCAAgent());
			_poDeskCancelTransFB.setStrCurrencyCode(poDeskCancelTransVO
					.getStrCurrencyCode());
			_poDeskCancelTransFB.setStrAgentName(poDeskCancelTransVO
					.getStrAgentName());
			_poDeskCancelTransFB.setStrCAAgentName(poDeskCancelTransVO
					.getStrCAAgentName());
			_poDeskCancelTransFB.setStrCurrency(poDeskCancelTransVO
					.getStrCurrency());

			poDeskCancelTransBO.setEmployeeValues(poDeskCancelTransVO);
			if (poDeskCancelTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskCancelTransVO.getStrMsgString());

			_poDeskCancelTransFB.setStrCancelByValues(poDeskCancelTransVO
					.getStrEmployeeValues());
			_poDeskCancelTransFB.setStrApprovedByValues(poDeskCancelTransVO
					.getStrEmployeeValues());

			if (_poDeskCancelTransFB.getStrPOTypeId().equals("24"))
				_poDeskCancelTransFB
						.setStrForeignPODetails(PODeskCancelTransHLP
								.getForeignPODetails(_poDeskCancelTransFB));
			if (_poDeskCancelTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskCancelTransFB.getStrMsgString());
			_poDeskCancelTransFB.setStrScheduleDetails(PODeskCancelTransHLP
					.getScheduleDetailsBS(_poDeskCancelTransFB));

		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskCancelTransDATA.getScheduleDetails()---->", _Err
							.getMessage());
			_poDeskCancelTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	public static void insert(PODeskCancelTransFB _poDeskCancelTransFB,
			HttpServletRequest _request) {
		PODeskCancelTransVO poDeskCancelTransVO = null;
		PODeskCancelTransBO poDeskCancelTransBO = null;
		try 
		{
			poDeskCancelTransBO = new PODeskCancelTransBO();
			_poDeskCancelTransFB.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			_poDeskCancelTransFB.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			
			_poDeskCancelTransFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			
			poDeskCancelTransVO = (PODeskCancelTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PODeskCancelTransVO",_poDeskCancelTransFB);

			poDeskCancelTransBO.insert(poDeskCancelTransVO);
			
			if (poDeskCancelTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskCancelTransVO.getStrMsgString());
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskCancelTransDATA.insert()---->", _Err.getMessage());
			_poDeskCancelTransFB
					.setStrErr("Error####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
}
