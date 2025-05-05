/**
 * 
 */
package mms.transactions.controller.data;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.transactions.bo.PODeskScheduleTransBO;
import mms.transactions.controller.fb.PODeskScheduleTransFB;
import mms.transactions.controller.hlp.PODeskScheduleTransHLP;
import mms.transactions.vo.PODeskScheduleTransVO;

/**
 * @author Pankaj Kumar Creation Date:- 15-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskScheduleTransDATA {
	public static void getPODetails(
			PODeskScheduleTransFB _poDeskScheduleTransFB,
			HttpServletRequest _request) {
		PODeskScheduleTransVO poDeskScheduleTransVO = null;
		PODeskScheduleTransBO poDeskScheduleTransBO = null;
		HisUtil util = null;
		try {
			util = new HisUtil("Material Management System","PODeskScheduleTransDATA.getPODetails()");
			poDeskScheduleTransVO = new PODeskScheduleTransVO();
			poDeskScheduleTransBO = new PODeskScheduleTransBO();
			poDeskScheduleTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));

			_poDeskScheduleTransFB.setStrStoreId(_request.getParameterValues("combo")[0]);

			_poDeskScheduleTransFB.setStrStoreName(_request.getParameter("comboValue"));

			_poDeskScheduleTransFB.setStrPONo(_request.getParameter("chk").replace("@", "#").split("#")[1]);

			poDeskScheduleTransVO.setStrPONo(_poDeskScheduleTransFB	.getStrPONo());
			
			poDeskScheduleTransVO.setStrStoreId(_poDeskScheduleTransFB.getStrStoreId());
			_poDeskScheduleTransFB.setStrCurrentDate(util.getDSDate("DD-Mon-yyyy"));
			
			poDeskScheduleTransBO.getPODetails(poDeskScheduleTransVO);
			
			if (poDeskScheduleTransVO.getStrMsgType().equals("1"))
				
				throw new Exception(poDeskScheduleTransVO.getStrMsgString());

			_poDeskScheduleTransFB.setStrPODate(poDeskScheduleTransVO.getStrPODate());
			_poDeskScheduleTransFB.setStrSupplierName(poDeskScheduleTransVO	.getStrSupplierName());
			_poDeskScheduleTransFB.setStrPOType(poDeskScheduleTransVO.getStrPOType());
			_poDeskScheduleTransFB.setStrSupplierId(poDeskScheduleTransVO.getStrSupplierId());
			_poDeskScheduleTransFB.setStrPOTypeId(poDeskScheduleTransVO.getStrPOTypeId());
			_poDeskScheduleTransFB.setStrItemCat(poDeskScheduleTransVO.getStrItemCat());
			_poDeskScheduleTransFB.setStrItemCatName(poDeskScheduleTransVO.getStrItemCatName());

			poDeskScheduleTransBO.getForeignPODetails(poDeskScheduleTransVO);
			
			if (poDeskScheduleTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskScheduleTransVO.getStrMsgString());

			_poDeskScheduleTransFB.setStrAgentId(poDeskScheduleTransVO.getStrAgentId());
			_poDeskScheduleTransFB.setStrCAAgent(poDeskScheduleTransVO.getStrCAAgent());
			_poDeskScheduleTransFB.setStrCurrencyCode(poDeskScheduleTransVO.getStrCurrencyCode());
			_poDeskScheduleTransFB.setStrAgentName(poDeskScheduleTransVO.getStrAgentName());
			_poDeskScheduleTransFB.setStrCAAgentName(poDeskScheduleTransVO.getStrCAAgentName());
			_poDeskScheduleTransFB.setStrCurrency(poDeskScheduleTransVO.getStrCurrency());
			_poDeskScheduleTransFB.setStrPODeliveryDate(poDeskScheduleTransVO.getStrPODeliveryDate());

			if (_poDeskScheduleTransFB.getStrPOTypeId().equals("24"))
				_poDeskScheduleTransFB.setStrForeignPODetails(PODeskScheduleTransHLP.getForeignPODetails(_poDeskScheduleTransFB));
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskScheduleTransDATA.getPODetails()---->", _Err
							.getMessage());
			_poDeskScheduleTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void getPOItemDetails(
			PODeskScheduleTransFB _poDeskScheduleTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		PODeskScheduleTransVO poDeskScheduleTransVO = null;
		PODeskScheduleTransBO poDeskScheduleTransBO = null;
		try {
			poDeskScheduleTransVO = new PODeskScheduleTransVO();
			poDeskScheduleTransBO = new PODeskScheduleTransBO();
			
			poDeskScheduleTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskScheduleTransVO.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			
			_poDeskScheduleTransFB.setStrPONo(_request.getParameter("strPONo"));
			
			_poDeskScheduleTransFB.setStrStoreId(_request.getParameter("strStoreId"));

			_poDeskScheduleTransFB.setStrDNoOfSchedule(_request.getParameter("strDNoOfSchedule"));
			_poDeskScheduleTransFB.setStrPODeliveryDate(_request.getParameter("strPODeliveryDate"));
			
			
			poDeskScheduleTransVO.setStrPONo(_poDeskScheduleTransFB	.getStrPONo());
			poDeskScheduleTransVO.setStrStoreId(_poDeskScheduleTransFB.getStrStoreId());

			_poDeskScheduleTransFB.setStrHospitalCode(poDeskScheduleTransVO.getStrHospitalCode());

			// Callling BO Method
			poDeskScheduleTransBO.getPOItemDetails(poDeskScheduleTransVO);
			_poDeskScheduleTransFB.setStrDeliveryLocationValues(poDeskScheduleTransVO.getStrDeliveryLocationValues());
			
			if (poDeskScheduleTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskScheduleTransVO.getStrMsgString());

			_poDeskScheduleTransFB.setWbPOItemDetail(poDeskScheduleTransVO.getWbPOItemDetail());
		    
             // Calling HLP method
			_response.getWriter().print(PODeskScheduleTransHLP.getPOItemDetails(_poDeskScheduleTransFB));
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskScheduleTransDATA.getPOItemDetails()---->", _Err
							.getMessage());
			_poDeskScheduleTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void insert(PODeskScheduleTransFB _poDeskScheduleTransFB,HttpServletRequest _request) 
	{
		PODeskScheduleTransVO poDeskScheduleTransVO = null;
		PODeskScheduleTransBO poDeskScheduleTransBO = null;
		try 
		{
			 poDeskScheduleTransBO = new PODeskScheduleTransBO();
			_poDeskScheduleTransFB.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			_poDeskScheduleTransFB.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			_poDeskScheduleTransFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			
			poDeskScheduleTransVO = (PODeskScheduleTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PODeskScheduleTransVO",	_poDeskScheduleTransFB);
            // Calling BO Method 
			poDeskScheduleTransBO.insert(poDeskScheduleTransVO);
			if (poDeskScheduleTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskScheduleTransVO.getStrMsgString());
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskScheduleTransDATA.insert()---->", _Err.getMessage());
			_poDeskScheduleTransFB
					.setStrErr("Error####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
}
