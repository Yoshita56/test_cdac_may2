/**
 * 
 */
package mms.transactions.controller.data;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import hisglobal.utility.SMSHttpsNICPostClient;
import hisglobal.vo.UserVO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.MmsConfigUtil;
import mms.transactions.bo.PODeskGenerateTransBO;
import mms.transactions.controller.fb.PODeskGenerateTransFB;
import mms.transactions.controller.hlp.PODeskGenerateTransHLP;
import mms.transactions.vo.PODeskGenerateTransVO;

import org.codehaus.jettison.json.JSONObject;


/**
 * @author Pankaj Kumar Creation Date:- 10-06-2009 Modifying Date:- Used For:-
 *         Team Lead By:- Ajay Gupta Module:- MMS(HIS Project)
 * 
 */
public class PODeskGenerateTransDATA {
	public static void setItemCatValues(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request) {
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		HisUtil util = null;
		try {
			util = new HisUtil("Material Management System","PODeskGenerateTransDATA.setItemCatValues()");
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			poDeskGenerateTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskGenerateTransVO.setStrSeatId((String) _request.getSession()
					.getAttribute("SEATID"));
			poDeskGenerateTransVO.setStrStoreId(_request
					.getParameterValues("combo")[0]);
			poDeskGenerateTransVO.setStrItemCatNo(_request.getParameterValues("combo")[1]);
			poDeskGenerateTransVO.setStrPOTypeId(_request.getParameterValues("combo")[2]);

			_poDeskGenerateTransFB.setStrStoreName(_request
					.getParameter("comboValue"));
			_poDeskGenerateTransFB.setStrStoreId(poDeskGenerateTransVO
					.getStrStoreId());
			_poDeskGenerateTransFB.setStrCurrentDate(util.getDSDate("DD-Mon-yyyy"));

			_poDeskGenerateTransFB.setStrINRCurrencyId(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
			_poDeskGenerateTransFB.setStrpoDate(util.getASDate("dd-MMM-yyyy"));
			_poDeskGenerateTransFB.setStrpoDateId(util.getASDate("dd-MMM-yyyy"));
			poDeskGenerateTransBO.setItemCatValues(poDeskGenerateTransVO);
			_poDeskGenerateTransFB.setStrItemCatName(poDeskGenerateTransVO.getStrItemCatName());
			_poDeskGenerateTransFB.setStrItemCat(poDeskGenerateTransVO.getStrItemCatNo());
			_poDeskGenerateTransFB.setStrPOType(poDeskGenerateTransVO.getStrPOType());
			_poDeskGenerateTransFB.setStrPOTypeId(poDeskGenerateTransVO.getStrPOTypeId());
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());

			_poDeskGenerateTransFB.setStrItemCatValues(poDeskGenerateTransVO
					.getStrItemCatValues());
			
			_poDeskGenerateTransFB.setTmpPoType(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2));
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.setItemCatValues()---->", _Err
							.getMessage());
			_poDeskGenerateTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void setPOTypeValues(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			poDeskGenerateTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskGenerateTransVO.setStrItemCat(_request
					.getParameter("strItemCat"));
			poDeskGenerateTransVO.setStrStoreId(_request
					.getParameter("strStoreId"));
			poDeskGenerateTransBO.setPOTypeValues(poDeskGenerateTransVO);
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());
			_response.getWriter().print(
					poDeskGenerateTransVO.getStrPOTypeValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.setPOTypeValues()---->", _Err
							.getMessage());
			_poDeskGenerateTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void setSupplierValues(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			poDeskGenerateTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskGenerateTransVO.setStrContractType(_request.getParameter("strContractType"));
			poDeskGenerateTransVO.setStrItemCat(_request.getParameter("strItemCat"));
			poDeskGenerateTransBO.setSupplierValues(poDeskGenerateTransVO);
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());
			_response.getWriter().print(
					poDeskGenerateTransVO.getStrSupplierValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.setSupplierValues()---->", _Err
							.getMessage());
			_poDeskGenerateTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void setPurchaseSourceValues(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request) {
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		String strApprovedByVals="";
		HisUtil util=null;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			util = new HisUtil("MMS",
			"transactions.PODeskGenerateTransDATA.setPurchaseSourceValues()");
			poDeskGenerateTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskGenerateTransVO.setStrSeatId((String) _request.getSession()
					.getAttribute("SEATID"));
			poDeskGenerateTransBO
					.setPurchaseSourceValues(poDeskGenerateTransVO);
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());
			if(poDeskGenerateTransVO.getWbApprovedBy()!=null ||poDeskGenerateTransVO.getWbApprovedBy().size()!=0){
				strApprovedByVals=util.getOptionValue(poDeskGenerateTransVO.getWbApprovedBy(), "", "0^Select Value", false);
			}else{
				strApprovedByVals="<option value='0'>Select Value</option>";
			}
			
			_poDeskGenerateTransFB
					.setStrPurchaseSourceValues(poDeskGenerateTransVO
							.getStrPurchaseSourceValues());
		
			_poDeskGenerateTransFB.setStrApprovedByVals(strApprovedByVals);
			_poDeskGenerateTransFB.setStrCurrentDate(util.getDSDate("DD-Mon-yyyy"));
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.setPurchaseSourceValues()---->",
					_Err.getMessage());
			_poDeskGenerateTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void setAgentNameValues(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			poDeskGenerateTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskGenerateTransVO.setStrItemCat(_request
					.getParameter("strItemCat"));
			poDeskGenerateTransBO.setAgentNameValues(poDeskGenerateTransVO);
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());
			_response.getWriter().print(
					poDeskGenerateTransVO.getStrAgentNameValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.setAgentNameValues()---->", _Err
							.getMessage());
			_poDeskGenerateTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void setDeliveryLocationValues(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request) {
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			poDeskGenerateTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskGenerateTransVO.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			poDeskGenerateTransVO.setStrItemCatNo(_request.getParameterValues("combo")[1]);
			poDeskGenerateTransVO.setStrStoreId(_request.getParameterValues("combo")[0]);
			poDeskGenerateTransBO.setDeliveryLocationValues(poDeskGenerateTransVO);
			////System.out.println("Delivery Location->>"+poDeskGenerateTransVO.getStrDeliveryLocationValues());
			
			
			SimpleDateFormat dateformat = new SimpleDateFormat("dd-MMM-yyyy");  
			
			Calendar cal = Calendar.getInstance();
			MmsConfigUtil mmsConfig =  new MmsConfigUtil(poDeskGenerateTransVO.getStrHospitalCode());
			
			 int importedTime  = Integer.parseInt(mmsConfig.getStrImportedDeliveryTime());
			 int   indianTime  = Integer.parseInt(mmsConfig.getStrIndianDeliveryTime());
			 ////System.out.println("Imported Time->>"+importedTime);
			 ////System.out.println("Indian   Time->>"+indianTime);
			 	 
			 cal.add(Calendar.DATE, importedTime);
		     ////System.out.println("Imported Delivery Date: " + dateformat.format(cal.getTime()));
		     _poDeskGenerateTransFB.setStrImportedDeleivryDate(dateformat.format(cal.getTime()));
		     Calendar cal1 = Calendar.getInstance();
			 cal1.add(Calendar.DATE, indianTime);
			 _poDeskGenerateTransFB.setStrIndianDeleivryDate(dateformat.format(cal1.getTime()));
			 ////System.out.println("Indian Delivery Date: " + dateformat.format(cal1.getTime())); 
			_poDeskGenerateTransFB.setStrTax(mmsConfig.getStrTax());			
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());
			_poDeskGenerateTransFB.setStrDeliveryLocationValues(poDeskGenerateTransVO.getStrDeliveryLocationValues());
			
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.setDeliveryLocationValues()---->",
					_Err.getMessage());
			_poDeskGenerateTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

	public static void setCurrencyValues(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request) {
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			poDeskGenerateTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskGenerateTransBO.setCurrencyValues(poDeskGenerateTransVO);
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());
			_poDeskGenerateTransFB.setStrCurrencyValues(poDeskGenerateTransVO
					.getStrCurrencyValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.setCurrencyValues()---->", _Err
							.getMessage());
			_poDeskGenerateTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
public static void getManufactrerValues(PODeskGenerateTransFB _poDeskGenerateTransFB,HttpServletRequest _request) 
	{
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		try 
		{
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			poDeskGenerateTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskGenerateTransVO.setStrItemCat("10");
			
			if(_poDeskGenerateTransFB.getStrModifyFlg().equals("1"))
			{
				poDeskGenerateTransVO.setStrItemManufacturerId(_poDeskGenerateTransFB.getStrItemManufacturerId());
			}
			else
			{
				poDeskGenerateTransVO.setStrItemManufacturerId("0");	
			}
			poDeskGenerateTransBO.setManufacturerValues(poDeskGenerateTransVO);
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());
			_poDeskGenerateTransFB.setStrManufacturerValues(poDeskGenerateTransVO.getStrManufacturerValues());
		}
		catch (Exception _Err) 
		{
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.getManufactrerValues()---->", _Err
							.getMessage());
			_poDeskGenerateTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
public static void getRequestDetails(
		PODeskGenerateTransFB _poDeskGenerateTransFB,
		HttpServletRequest _request, HttpServletResponse _response) {
	String strRequestDetails = "";
	PODeskGenerateTransVO poDeskGenerateTransVO = null;
	PODeskGenerateTransBO poDeskGenerateTransBO = null;
	try {
		poDeskGenerateTransVO = new PODeskGenerateTransVO();
		poDeskGenerateTransBO = new PODeskGenerateTransBO();

		poDeskGenerateTransVO.setStrHospitalCode((String) _request
				.getSession().getAttribute("HOSPITAL_CODE"));
		poDeskGenerateTransVO.setStrSeatId((String) _request.getSession()
				.getAttribute("SEATID"));
		poDeskGenerateTransVO.setStrItemCat(_request
				.getParameter("strItemCat"));
		poDeskGenerateTransVO.setStrStoreId(_request
				.getParameter("strStoreId"));
		poDeskGenerateTransVO.setStrPOTypeId(_request
				.getParameter("strPOTypeId"));
		poDeskGenerateTransVO.setStrPOGrantType(_request
				.getParameter("strPOGrantType"));

		poDeskGenerateTransBO.getRequestDetails(poDeskGenerateTransVO);
		if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
			throw new Exception(poDeskGenerateTransVO.getStrMsgString());

		_poDeskGenerateTransFB.setWbRequestDetail(poDeskGenerateTransVO
				.getWbRequestDetail());
		strRequestDetails = PODeskGenerateTransHLP
				.getRequestDetails(_poDeskGenerateTransFB);
		if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
			throw new Exception(_poDeskGenerateTransFB.getStrMsgString());
		_poDeskGenerateTransFB.setTmpPoType(poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
		_response.setHeader("Cache-Control", "no-cache");
		_response.getWriter().print(strRequestDetails);
	} catch (Exception _Err) {
		_Err.printStackTrace();
		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getRequestDetails()---->", _Err
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
	public static void getRequestDetailsBS(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strRequestDetails = "";
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();

			poDeskGenerateTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskGenerateTransVO.setStrSeatId((String) _request.getSession()
					.getAttribute("SEATID"));
			poDeskGenerateTransVO.setStrItemCat(_request
					.getParameter("strItemCat"));
			poDeskGenerateTransVO.setStrStoreId(_request
					.getParameter("strStoreId"));
			poDeskGenerateTransVO.setStrPOTypeId(_request
					.getParameter("strPOTypeId"));
			poDeskGenerateTransVO.setStrPOGrantType(_request
					.getParameter("strPOGrantType"));

			poDeskGenerateTransBO.getRequestDetails(poDeskGenerateTransVO);
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());

			_poDeskGenerateTransFB.setWbRequestDetail(poDeskGenerateTransVO
					.getWbRequestDetail());
			strRequestDetails = PODeskGenerateTransHLP
					.getRequestDetailsBS(_poDeskGenerateTransFB);
			if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskGenerateTransFB.getStrMsgString());
			_poDeskGenerateTransFB.setTmpPoType(poDeskGenerateTransVO.getStrPOTypeId().substring(0,2));
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strRequestDetails);
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.getRequestDetails()---->", _Err
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

	public static void setRateUnitValues(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request) {
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			poDeskGenerateTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskGenerateTransVO.setStrSeatId((String) _request.getSession()
					.getAttribute("SEATID"));
			poDeskGenerateTransBO.setUnitValues(poDeskGenerateTransVO);
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());
			_poDeskGenerateTransFB.setStrRateUnitValues(poDeskGenerateTransVO
					.getStrRateUnitValues());
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.setRateUnitValues()---->", _Err
							.getMessage());
			_poDeskGenerateTransFB
					.setStrErr("Error####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	public static void getRequestModifyItemDetails(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strIndentDetails = "";
		try {
			_poDeskGenerateTransFB.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));

			
			String strChk = _request.getParameter("chk");
			String[] strtemp = strChk.replace("@", "#").split("#");
			_poDeskGenerateTransFB.setStrPoNo(strtemp[1]);
			_poDeskGenerateTransFB.setStrSupplierId("0");
			_poDeskGenerateTransFB.setStrContractType("12");
			_poDeskGenerateTransFB.setStrPOTypeId(strtemp[3]);
			_poDeskGenerateTransFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			_poDeskGenerateTransFB.setStrItemCat(_request.getParameterValues("combo")[1]);
			
			_poDeskGenerateTransFB.setStrRequestIds("");
			_poDeskGenerateTransFB.setStrReqIdnDate("");
			_poDeskGenerateTransFB.setStrCheckData("");
			_poDeskGenerateTransFB.setStrCurrentDate("");
			if(_poDeskGenerateTransFB.getStrPOTypeId().equals("21"))
				strIndentDetails = PODeskGenerateTransHLP
						.getRequestModifyItemDetails(_poDeskGenerateTransFB);
			else
				strIndentDetails = PODeskGenerateTransHLP
					.getRequestItemDetails(_poDeskGenerateTransFB);
			if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskGenerateTransFB.getStrMsgString());
			_poDeskGenerateTransFB.setTmpPoType(_poDeskGenerateTransFB.getStrPOTypeId());
			_poDeskGenerateTransFB.setStrReqModifyItemDtls(strIndentDetails);
			/*_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strIndentDetails);*/
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.getRequestItemDetails()---->",
					_Err.getMessage());
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
	

	public static void getRequestModifyItemDetailsBS(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strIndentDetails = "";
		try {
			_poDeskGenerateTransFB.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));

			
			String strChk = _request.getParameter("chk");
			String[] strtemp = strChk.replace("@", "#").split("#");
			_poDeskGenerateTransFB.setStrPoNo(strtemp[1]);
			_poDeskGenerateTransFB.setStrSupplierId("0");
			_poDeskGenerateTransFB.setStrContractType("12");
			_poDeskGenerateTransFB.setStrPOTypeId(strtemp[3]);
			_poDeskGenerateTransFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			_poDeskGenerateTransFB.setStrItemCat(_request.getParameterValues("combo")[1]);
			
			_poDeskGenerateTransFB.setStrRequestIds("");
			_poDeskGenerateTransFB.setStrReqIdnDate("");
			_poDeskGenerateTransFB.setStrCheckData("");
			_poDeskGenerateTransFB.setStrCurrentDate("");
			if(_poDeskGenerateTransFB.getStrPOTypeId().equals("21"))
				strIndentDetails = PODeskGenerateTransHLP
						.getRequestModifyItemDetails(_poDeskGenerateTransFB);
			else
				strIndentDetails = PODeskGenerateTransHLP
					.getRequestItemDetailsBS(_poDeskGenerateTransFB);
			if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskGenerateTransFB.getStrMsgString());
			_poDeskGenerateTransFB.setTmpPoType(_poDeskGenerateTransFB.getStrPOTypeId());
			_poDeskGenerateTransFB.setStrReqModifyItemDtls(strIndentDetails);
			/*_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strIndentDetails);*/
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.getRequestItemDetails()---->",
					_Err.getMessage());
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
	
	public static void getRequestItemDetails(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strIndentDetails = "";
		try {
			_poDeskGenerateTransFB.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));

			_poDeskGenerateTransFB.setStrSupplierId(_request
					.getParameter("strSupplierId"));
			_poDeskGenerateTransFB.setStrContractType(_request
					.getParameter("strContractType"));
			_poDeskGenerateTransFB.setStrPOTypeId(_request
					.getParameter("strPOTypeId"));
			_poDeskGenerateTransFB.setStrItemCat(_request
					.getParameter("strItemCat"));
			_poDeskGenerateTransFB.setStrRequestIds(_request
					.getParameter("strRequestIds"));
			_poDeskGenerateTransFB.setStrReqIdnDate(_request
					.getParameter("strReqIdnDate"));
			_poDeskGenerateTransFB.setStrCheckData(_request
					.getParameter("strCheckData"));
			_poDeskGenerateTransFB.setStrCurrentDate(_request.getParameter("strCurrentDate"));
			if(!_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("21"))  // Bulk PO
			{
				strIndentDetails = PODeskGenerateTransHLP.getRequestItemDetails(_poDeskGenerateTransFB);
			}
			else
			{
				// Local PO
				strIndentDetails = PODeskGenerateTransHLP.getRequestItemDetails(_poDeskGenerateTransFB);
			}
			if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskGenerateTransFB.getStrMsgString());
			_poDeskGenerateTransFB.setTmpPoType(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2));
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strIndentDetails);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.getRequestItemDetails()---->",
					_Err.getMessage());
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
	
	public static void getRequestItemDetailsBS(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strIndentDetails = "";
		try {
			
			System.out.println("----------- PODeskGenerateTransDATA . getRequestItemDetailsBS -----------");
			
			_poDeskGenerateTransFB.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));

			_poDeskGenerateTransFB.setStrSupplierId(_request.getParameter("strSupplierId"));
			_poDeskGenerateTransFB.setStrContractType(_request.getParameter("strContractType"));
			_poDeskGenerateTransFB.setStrPOTypeId(_request.getParameter("strPOTypeId"));
			_poDeskGenerateTransFB.setStrItemCat(_request.getParameter("strItemCat"));
			_poDeskGenerateTransFB.setStrRequestIds(_request.getParameter("strRequestIds"));
			_poDeskGenerateTransFB.setStrReqIdnDate(_request.getParameter("strReqIdnDate"));
			_poDeskGenerateTransFB.setStrCheckData(_request.getParameter("strCheckData"));
			_poDeskGenerateTransFB.setStrCurrentDate(_request.getParameter("strCurrentDate"));
			
			System.out.println("----------- PO TYPE 21 - BULK PO , 22 - LOCAL PO  -----------");
			if(!_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("21"))
			{
				
				strIndentDetails = PODeskGenerateTransHLP.getRequestItemDetailsBS(_poDeskGenerateTransFB);
			}
			else
			{
				strIndentDetails = PODeskGenerateTransHLP.getRequestItemDetailsBS(_poDeskGenerateTransFB);
			}
			if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskGenerateTransFB.getStrMsgString());
			_poDeskGenerateTransFB.setTmpPoType(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2));
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strIndentDetails);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.getRequestItemDetails()---->",
					_Err.getMessage());
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
	
	
	public static void getPOItemDetails(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strPOItemDetails = "";
		try {
			_poDeskGenerateTransFB.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			_poDeskGenerateTransFB.setStrCheckData(_request
					.getParameter("chkValue"));

			strPOItemDetails = PODeskGenerateTransHLP
					.getPOItemDetails(_poDeskGenerateTransFB);
			if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskGenerateTransFB.getStrMsgString());

			//_response.setHeader("Cache-Control", "no-cache");
			//_response.getWriter().print(strPOItemDetails);
			_poDeskGenerateTransFB.setStrSetItemDetails(strPOItemDetails);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.getRequestItemDetails()---->",
					_Err.getMessage());
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

	public static void getComponentDetail(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strRequestDetails = "";
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		try {
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			_poDeskGenerateTransFB.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			_poDeskGenerateTransFB.setStrPOTypeId(_request
					.getParameter("strPOTypeId"));
			_poDeskGenerateTransFB.setStrItemCat(_request
					.getParameter("strItemCat"));

			poDeskGenerateTransVO.setStrHospitalCode(_poDeskGenerateTransFB
					.getStrHospitalCode());
			poDeskGenerateTransVO.setStrPOTypeId(_poDeskGenerateTransFB
					.getStrPOTypeId());
			poDeskGenerateTransVO.setStrItemCat(_poDeskGenerateTransFB
					.getStrItemCat());

			poDeskGenerateTransBO.getComponentDetail(poDeskGenerateTransVO);

			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());

			_poDeskGenerateTransFB.setStrComponentID(poDeskGenerateTransVO
					.getStrComponentID());
			_poDeskGenerateTransFB.setStrComponentName(poDeskGenerateTransVO
					.getStrComponentName());
			_poDeskGenerateTransFB.setStrComponentValue(poDeskGenerateTransVO
					.getStrComponentValue());
			strRequestDetails = PODeskGenerateTransHLP
					.getComponentDetail(_poDeskGenerateTransFB);
			if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskGenerateTransFB.getStrMsgString());

			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strRequestDetails);
		} catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.getComponentDetail()---->", _Err
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

	public static void getIndentPopupDetails(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strIndentDetails = "";
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		try {
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();

			poDeskGenerateTransVO.setStrHospitalCode((String) _request
					.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskGenerateTransVO.setStrIndentNo(_request
					.getParameter("strIndentNo"));
			poDeskGenerateTransVO.setStrIndentNo(_request
					.getParameter("strStoreId"));

			poDeskGenerateTransBO.getIndentPopupDetails(poDeskGenerateTransVO);
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());

			_poDeskGenerateTransFB.setWbRequestDetail(poDeskGenerateTransVO
					.getWbRequestDetail());
			// strIndentDetails = PODeskGenerateTransHLP
			// .getIndentPopupDetails(_poDeskGenerateTransFB);
			if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
				throw new Exception(_poDeskGenerateTransFB.getStrMsgString());
			_response.getWriter().print(strIndentDetails);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.getIndentPopupDetails()---->",
					_Err.getMessage());
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

	public static void insert(PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request) {
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		try {
			System.out.println("----------- PODeskGenerateTransDATA . INSERT -----------");
			
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			_poDeskGenerateTransFB.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			_poDeskGenerateTransFB.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			_poDeskGenerateTransFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			_poDeskGenerateTransFB.setStrAgendaStatus(_request.getParameterValues("combo")[3]);
			_poDeskGenerateTransFB.setStrDPurchaseSource("13");//13 is for RC supplier
			poDeskGenerateTransVO = (PODeskGenerateTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PODeskGenerateTransVO",_poDeskGenerateTransFB);
			//System.out.println("poDeskGenerateTransVO.getStrDPurchaseSource()::::"+poDeskGenerateTransVO.getStrDPurchaseSource());
			poDeskGenerateTransBO.insert(poDeskGenerateTransVO);
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());
			if(poDeskGenerateTransVO.getStrMsgType().equals("2"))
			{
				_poDeskGenerateTransFB.setStrErr("Purchase Order No [ "+poDeskGenerateTransVO.getStrPoNo()+" ] Generated Successfully !! ");	
			}
			
		} 
		catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException("Material Management System","PODeskGenerateTransDATA.insert()---->", _Err.getMessage());
			_poDeskGenerateTransFB.setStrErr("Error####Application Error [ERROR ID : "+ hisException.getErrorID()+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void insertDraft(PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request) {
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		try {
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			_poDeskGenerateTransFB.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			_poDeskGenerateTransFB.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			_poDeskGenerateTransFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			_poDeskGenerateTransFB.setStrAgendaStatus(_request.getParameterValues("combo")[3]);
			_poDeskGenerateTransFB.setStrDPurchaseSource("13");//13 is for RC supplier
			//_poDeskGenerateTransFB.setStrStoreName(_request					.getParameter("comboValue"));
			poDeskGenerateTransVO = (PODeskGenerateTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PODeskGenerateTransVO",_poDeskGenerateTransFB);
			//System.out.println("poDeskGenerateTransVO.getStrDPurchaseSource()::::"+poDeskGenerateTransVO.getStrDPurchaseSource());
			poDeskGenerateTransBO.insertDraft(poDeskGenerateTransVO);
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());
			
			if(poDeskGenerateTransVO.getStrMsgType().equals("2"))
			{
				_poDeskGenerateTransFB.setStrErr("Draft PO Generated successfully ");//+poDeskGenerateTransVO.getStrPoNo());	
			}
			
		} 
		catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException("Material Management System","PODeskGenerateTransDATA.insert()---->", _Err.getMessage());
			_poDeskGenerateTransFB.setStrErr("Error####Application Error [ERROR ID : "+ hisException.getErrorID()+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void INSERTMODIFYDRAFT(PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request) {
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		try {
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			_poDeskGenerateTransFB.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			_poDeskGenerateTransFB.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			_poDeskGenerateTransFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			_poDeskGenerateTransFB.setStrAgendaStatus(_request.getParameterValues("combo")[3]);
			_poDeskGenerateTransFB.setStrDPurchaseSource("13");//13 is for RC supplier
			//_poDeskGenerateTransFB.setStrStoreName(_request					.getParameter("comboValue"));
			poDeskGenerateTransVO = (PODeskGenerateTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PODeskGenerateTransVO",_poDeskGenerateTransFB);
			//System.out.println("poDeskGenerateTransVO.getStrDPurchaseSource()::::"+poDeskGenerateTransVO.getStrDPurchaseSource());
			poDeskGenerateTransBO.INSERTMODIFYDRAFT(poDeskGenerateTransVO);
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());
			
			if(poDeskGenerateTransVO.getStrMsgType().equals("2"))
			{
				_poDeskGenerateTransFB.setStrErr("Data Save successfully with Draft Po No "+poDeskGenerateTransVO.getStrPoNo());	
			}
			
		} 
		catch (Exception _Err) {
			_Err.printStackTrace();
			HisException hisException = new HisException("Material Management System","PODeskGenerateTransDATA.insert()---->", _Err.getMessage());
			_poDeskGenerateTransFB.setStrErr("Error####Application Error [ERROR ID : "+ hisException.getErrorID()+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void getScheduleDetails(PODeskGenerateTransFB _PODeskGenerateTransFB,	HttpServletRequest _request) 
	{
		PODeskGenerateTransVO PODeskGenerateTransVO = null;
		PODeskGenerateTransBO PODeskGenerateTransBO = null;
		HisUtil hisutil = null;		
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;		
		try 
		{
			hisutil = new HisUtil("DWH Transaction","PODeskGenerateTransDATA");
			PODeskGenerateTransVO = new PODeskGenerateTransVO();
			PODeskGenerateTransBO = new PODeskGenerateTransBO();
			
			strCurrentDate  = hisutil.getASDate("dd-MM-yyyy");
			_PODeskGenerateTransFB.setStrCurrentDate(strCurrentDate);
            strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
            ResourceBundle resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
            _PODeskGenerateTransFB.setStrReOrderFlgColor(resObj.getString("QC_COLOR"));
			
			
			if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			
			strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			
			PODeskGenerateTransVO.setStrStoreId(_request.getParameterValues("combo")[0]);
			PODeskGenerateTransVO.setStrFinancialStartDate(strFinancialStartDate);
			PODeskGenerateTransVO.setStrFinancialToDate(strFinancialEndDate);
			PODeskGenerateTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));			
			PODeskGenerateTransVO.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			_PODeskGenerateTransFB.setStrHospitalCode(PODeskGenerateTransVO.getStrHospitalCode());
			_PODeskGenerateTransFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			//System.out.println();
			
			_PODeskGenerateTransFB.setStrStoreName(_request.getParameter("comboValue"));
			_PODeskGenerateTransFB.setStrPONo(_request.getParameter("chk").replace("@", "#").split("#")[1]);
			PODeskGenerateTransVO.setStrPONo(_PODeskGenerateTransFB.getStrPONo());
			PODeskGenerateTransVO.setStrStoreId(_request.getParameterValues("combo")[0]);	
			PODeskGenerateTransVO.setStrItemCat("10");
			PODeskGenerateTransVO.setStrPONo(_request.getParameter("chk").replace("@", "#").split("#")[1]);
			// Calling BO Method
			PODeskGenerateTransBO.getPODetails(PODeskGenerateTransVO);
			
			if (PODeskGenerateTransVO.getStrMsgType().equals("1"))
				
				throw new Exception(PODeskGenerateTransVO.getStrMsgString());			

			_PODeskGenerateTransFB.setStrPODate(PODeskGenerateTransVO.getStrPODate());
			_PODeskGenerateTransFB.setStrSupplierName(PODeskGenerateTransVO.getStrSupplierName());
			_PODeskGenerateTransFB.setStrPOType(PODeskGenerateTransVO.getStrPOType());
			_PODeskGenerateTransFB.setStrSupplierId(PODeskGenerateTransVO.getStrSupplierId());
			_PODeskGenerateTransFB.setStrPOTypeId(PODeskGenerateTransVO.getStrPOTypeId());
			_PODeskGenerateTransFB.setStrItemCat(PODeskGenerateTransVO.getStrItemCat());
			_PODeskGenerateTransFB.setStrItemCatName(PODeskGenerateTransVO.getStrItemCatName());		
			_PODeskGenerateTransFB.setStrPOHiddenValue(PODeskGenerateTransVO.getStrPOHiddenValue());
			_PODeskGenerateTransFB.setStrItemId(PODeskGenerateTransVO.getStrItemId());
			_PODeskGenerateTransFB.setStrItemBrandIds(PODeskGenerateTransVO.getStrItemBrandIds());
			_PODeskGenerateTransFB.setStrItemRate(PODeskGenerateTransVO.getStrItemRate());
			_PODeskGenerateTransFB.setStrItemRateUnitId(PODeskGenerateTransVO.getStrItemRateUnitId());
			_PODeskGenerateTransFB.setStrItemManufacturerId(PODeskGenerateTransVO.getStrItemManufacturerId());
			_PODeskGenerateTransFB.setStrTotalPOCost(PODeskGenerateTransVO.getStrTotalPOCost());
     		 //  (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)CURRENCY CODE ^(5) NET ADVANCE 
			 //^ (6)PO NET AMOUNT ^(7) SUPPLIER ID ^(8) PO Type ^ (9)Currency Id ^(10) Currency Value ^(11) Item Catg No 
			 //^ (12)Catg Name ^ (13)Purchase Source ID  ^ (14)Purchase Source Name ^ (15)Currency Id ^(16) Currency Value
             //^ (17)Advance Amt ^ (18)PO Prefix With PO No ^ (19)Delivery Date ^ (20)PO PreFix ^ (21)TAX 
             //^ (22)Tender No ^ (23)Tender Date ^ (24)Qutation No ^ (25)Qutation Date ^ (26) PO Date ^ (27) Verify Date ^ (28) Verify BY
			 //^ (29) Financial Start Date ^ (30) Financial End Date
			////System.out.println("Hidden Value:::"+PODeskGenerateTransVO.getStrPOHiddenValue());
			_PODeskGenerateTransFB.setStrPurchaseSourceID(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[12]);
			_PODeskGenerateTransFB.setStrPoRefrenceNo(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[19]);
			PODeskGenerateTransVO.setStrPoRefrenceNo(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[19]);
			
			_PODeskGenerateTransFB.setStrPORefrenceDate(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[25]);
			////System.out.println("Over All Tax:::"+PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[20]);
			_PODeskGenerateTransFB.setStrDOverAllTax(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[20]);
			_PODeskGenerateTransFB.setStrDTenderNo(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[21]);
			
			_PODeskGenerateTransFB.setStrDQuotationNo(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[23]);
						
			if(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[22]==null || PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[22].equals(""))
			{	
			    _PODeskGenerateTransFB.setStrDTenderDate("");
			}
			else
			{
				 _PODeskGenerateTransFB.setStrDTenderDate(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[22]);
			}
			
			if(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[24]==null || PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[24].equals(""))
			{	
			     _PODeskGenerateTransFB.setStrDQuotationDate("");
			}
			else
			{
				_PODeskGenerateTransFB.setStrDQuotationDate(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[24]);
			}
			// Calling BO Method
			PODeskGenerateTransBO.getPOPrefixCmb(PODeskGenerateTransVO);
			_PODeskGenerateTransFB.setStrPoRefrenceNoCmb(PODeskGenerateTransVO.getStrPoRefrenceNoCmb());
			
			_PODeskGenerateTransFB.setStrVerifiedDate(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[26]);
			_PODeskGenerateTransFB.setStrVerifyById(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[27]);
			//System.out.println("HiddenValues"+PODeskGenerateTransVO.getStrPOHiddenValue());
			for(int i = 0;i<PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^").length;i++)
			{
				//System.out.println(i+"::"+PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[i]);
			}
			_PODeskGenerateTransFB.setStrApprovedBy(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[30]);
			_PODeskGenerateTransFB.setStrApprovalDate(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[31]);
			
			//System.out.println("_PODeskGenerateTransFB.setStrApprovedBy"+_PODeskGenerateTransFB.getStrApprovedBy());
			//System.out.println("PODeskGenerateTransFB.setStrApprovalDate"+_PODeskGenerateTransFB.getStrApprovalDate());
			_PODeskGenerateTransFB.setStrFinancialStartDate(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[28]);
			_PODeskGenerateTransFB.setStrFinancialToDate(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[29]);
			
			_PODeskGenerateTransFB.setStrPODemandYear(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[28].split("\\-")[2]+"-"+PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[29].split("\\-")[2]);
			PODeskGenerateTransVO.setStrFinancialStartDate(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[28]);
			PODeskGenerateTransVO.setStrFinancialToDate(PODeskGenerateTransVO.getStrPOHiddenValue().split("\\^")[29]);
			 
			// Calling BO Method
			PODeskGenerateTransVO.setStrStoreId(_request.getParameterValues("combo")[0]);	
			_PODeskGenerateTransFB.setWbsReqListPO(PODeskGenerateTransVO.getWbsReqListPO());
			_PODeskGenerateTransFB.setStrModifyFlg("1");
			_PODeskGenerateTransFB.setStrPOItemCmb(PODeskGenerateTransVO.getStrPOItemCmb());
			_PODeskGenerateTransFB.setStrStoreName(PODeskGenerateTransVO.getStrStoreName());
			 PODeskGenerateTransDATA.getManufactrerValues(_PODeskGenerateTransFB, _request);
			 PODeskGenerateTransDATA.setPurchaseSourceValues(_PODeskGenerateTransFB, _request);	
				
			
		} 
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException("Material Management System","PODeskGenerateTransDATA.getScheduleDetails()---->", _Err.getMessage());
			_PODeskGenerateTransFB.setStrErr("ERROR####Application Error [ERROR ID : "+ hisException.getErrorID()+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void setItemCatValues1(
			PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request) {
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		HisUtil util = null;
		String strCurrentDate;
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strFinancialStartDate;
		String strFinancialEndDate;
		try 
		{
			util = new HisUtil("Material Management System","PODeskGenerateTransDATA.setItemCatValues()");
			poDeskGenerateTransVO = new PODeskGenerateTransVO();
			poDeskGenerateTransBO = new PODeskGenerateTransBO();
			MmsConfigUtil mmscofigutil = new  MmsConfigUtil(_request.getSession().getAttribute("HOSPITAL_CODE").toString());
			
			/* This Object is Used to get Re-Order Level Color from hisProperties File  */
			ResourceBundle resObj = ResourceBundle.getBundle("hisglobal.hisconfig.hisProperties");
			_poDeskGenerateTransFB.setStrReOrderFlgColor(resObj.getString("QC_COLOR"));
			/*****Here We found either Budget Funcanality is Allow or Not******/
			/* If Avalaible then New Cost Column will be Added */
			//_poDeskGenerateTransFB.setStrBudgetFlg(mmscofigutil.getStrBudgetFlg());
			_poDeskGenerateTransFB.setStrRequestId(_request.getParameterValues("combo")[1]);	
			//System.out.println("_poDeskGenerateTransFB.setStrRequestId"+_poDeskGenerateTransFB.getStrRequestId());
			if(!mmscofigutil.getStrDemandActivePrd().equals("0"))
			{	
				//_poDeskGenerateTransFB.setStrIsDemandActiveFlag("1");
			}
			/*******************************************************************/
								
			strCurrentDate  = util.getASDate("dd-MM-yyyy");
						
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
			
			
			if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
							
			strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
			
			strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
			
			poDeskGenerateTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			poDeskGenerateTransVO.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			poDeskGenerateTransVO.setStrStoreId(_request.getParameterValues("combo")[0]);
			if(_poDeskGenerateTransFB.getStrStoreName().equals("")||_poDeskGenerateTransFB.getStrStoreName() == null)
				_poDeskGenerateTransFB.setStrStoreName(_request.getParameter("comboValue"));
			_poDeskGenerateTransFB.setStrStoreId(poDeskGenerateTransVO.getStrStoreId());
					
			
			_poDeskGenerateTransFB.setStrCurrentDate(util.getDSDate("DD-Mon-yyyy"));
			_poDeskGenerateTransFB.setStrINRCurrencyId(MmsConfigUtil.DEFAULT_CURRENCY_CODE);
			
			poDeskGenerateTransBO.setItemCatValues1(poDeskGenerateTransVO);
			
			
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());

			_poDeskGenerateTransFB.setStrItemCatValues(poDeskGenerateTransVO.getStrItemCatValues());
			
			
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.setItemCatValues1()---->", _Err
							.getMessage());
			_poDeskGenerateTransFB
					.setStrErr("ERROR####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}
	
	public static void approvedPO(PODeskGenerateTransFB _poDeskGenerateTransFB,
			HttpServletRequest _request) 
	{
		PODeskGenerateTransVO poDeskGenerateTransVO = null;
		PODeskGenerateTransBO poDeskGenerateTransBO = null;
		UserVO _userVO=null;
		String strApprovalType="";
		try 
		{
			 poDeskGenerateTransBO = new PODeskGenerateTransBO();
			_poDeskGenerateTransFB.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
			_poDeskGenerateTransFB.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
			_poDeskGenerateTransFB.setStrStoreId(_request.getParameterValues("combo")[0]);
			_poDeskGenerateTransFB.setStrAgendaStatus(_request.getParameterValues("combo")[1]);			
			////System.out.println("PO Item ID==>"+_poDeskGenerateTransFB.getStrPOItemID());
			poDeskGenerateTransVO = (PODeskGenerateTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PODeskGenerateTransVO",	_poDeskGenerateTransFB);
			//strApproved
			if(_poDeskGenerateTransFB.getStrPostatus().equals("1"))
		    {
				strApprovalType = "1";
		    }	
		    else
		    {
		    	strApprovalType = "2";
		    }
			poDeskGenerateTransVO.setStrApprovalType(strApprovalType);
			//System.out.println("setStrApprovalType(strApprovalType::"+poDeskGenerateTransVO.getStrApprovalType());
			
			// Calling BO method
			poDeskGenerateTransBO.approvedPO(poDeskGenerateTransVO);
			_poDeskGenerateTransFB.setStrMsgType(poDeskGenerateTransVO.getStrMsgType());
			if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
			{	
				throw new Exception(poDeskGenerateTransVO.getStrMsgString());
			}
			else
			{								
				 /* This Method is global method used to Send SMS Here we pass
				  * Mobile e.g 9891925159,9856577577,84848485458
				  * Msg in String format "SMS Alert...."
				  * Mode 1 = Single SMS
				  * Mode 2 = Bulk SMS
				  * Mode 3 = Send Schedule SMS
				  * */
//				//System.out.println("PO Update Mobile No List==>"+poDeskGenerateTransVO.getStrMobileNoList());
//				//System.out.println("Mobile Msg==>"+poDeskGenerateTransVO.getStrMobileMsg());
//				//System.out.println("User Name==>"+poDeskGenerateTransVO.getStrMobileUserName());
//				//System.out.println("Pwd ==>"+poDeskGenerateTransVO.getStrMobilePwd());
				
				String mode = "2";
				String mobileNos = poDeskGenerateTransVO.getStrMobileNoList();
				String message   = poDeskGenerateTransVO.getStrMobileMsg();
				String scheduledTime = "";  
				String username  = poDeskGenerateTransVO.getStrMobileUserName();
				String pwd       = poDeskGenerateTransVO.getStrMobilePwd();
				String senderId  = poDeskGenerateTransVO.getStrMobileSenderId();	
			
				if(!poDeskGenerateTransVO.getStrMobileUserName().equals("0"))
				{	
				 // HisUtil.SendSMS(username,pwd,senderId,mode,mobileNos,message,scheduledTime);
				}  
			}
		}
		catch (Exception _Err) 
		{
			_Err.printStackTrace();
			HisException hisException = new HisException(
					"Material Management System",
					"PODeskGenerateTransDATA.approvedPO()---->", _Err.getMessage());
			_poDeskGenerateTransFB
					.setStrErr("Error####Application Error [ERROR ID : "
							+ hisException.getErrorID()
							+ "], Contact System Administrator! ");
			hisException = null;
		}
	}

public static void getFinancialYearCombo(PODeskGenerateTransFB PODeskGenerateTransFB_p,HttpServletRequest request_p)
	{
		PODeskGenerateTransBO	PODeskGenerateTransBO = null; 
		PODeskGenerateTransVO	PODeskGenerateTransVO  = null;
		String strCurrentDate;
		String strMsgText;
		HisUtil hisutil = null;
		
		int strCurrentMonth;
		int CURRENT_YEAR;
		String strCurrentFinancialYear="";
		String strNextFinancialYear=""; 
		
		try {
			PODeskGenerateTransBO = new PODeskGenerateTransBO();
			PODeskGenerateTransVO = new PODeskGenerateTransVO();
		 	hisutil = new HisUtil("DWH Transaction","PODeskGenerateTransDATA");
			strCurrentDate=hisutil.getASDate("dd-MM-yyyy");
			strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
		    if(strCurrentMonth>=4 )
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
			}
			else
			{
				CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
			}
		   String DATE_FORMAT = "dd-MM-yyyy";
		   java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
		   String strDemandActivePeriod = MmsConfigUtil.getStrPODemnadValidity((String) request_p.getSession().getAttribute("HOSPITAL_CODE"));
		   Calendar calendar1 = Calendar.getInstance();
		   Calendar calendar2 = Calendar.getInstance();
		   calendar1.set(Integer.parseInt(strCurrentDate.split("\\-")[2] ),(Integer.parseInt( strCurrentDate.split("\\-")[1] )-1) , Integer.parseInt( strCurrentDate.split("\\-")[0]));
		   calendar2.set(Integer.parseInt( strCurrentDate.split("\\-")[2] ), 3 ,Integer.parseInt(strDemandActivePeriod));
		   
			    System.out.print("Calender 1:::"+sdf.format(calendar1.getTime()));
			    System.out.print("Calender 2:::"+sdf.format(calendar2.getTime()));
			
		    if (calendar1.before(calendar2)) 
		    {
				strCurrentFinancialYear = (CURRENT_YEAR-1) + " - " + CURRENT_YEAR; 			
				strNextFinancialYear =     CURRENT_YEAR + " - " + (CURRENT_YEAR + 1);
		       
		    }
		    if (calendar1.after(calendar2)) 
		    {
				strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 			
				strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2); 
		    } 
		    if (calendar1.equals(calendar2)) 
		    {
				strCurrentFinancialYear = CURRENT_YEAR + " - " + (CURRENT_YEAR + 1); 			
				strNextFinancialYear = (CURRENT_YEAR+1) + " - " + (CURRENT_YEAR + 2);  
		    } 
		 // For setting the financial year combo
			PODeskGenerateTransFB_p.setStrCurrentFinancialYear(strCurrentFinancialYear);
			PODeskGenerateTransFB_p.setStrNextFinancialYear(strNextFinancialYear);
			
		} 
		catch (Exception e) 
		{
			strMsgText = "mms.transactions.PODeskGenerateTransDATA.getFinancialYearCombo() --> "
					+ e.getMessage();
			//System.out.println("strMsgText++++=========>>>>"+strMsgText);
			HisException eObj = new HisException("mms","PODeskGenerateTransDATA->getFinancialYearCombo()", strMsgText);
			PODeskGenerateTransFB_p.setStrErr("Application Error [ERROR ID : "+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} 
		finally 
		{

		if (PODeskGenerateTransBO != null)
			PODeskGenerateTransBO = null;
		if (PODeskGenerateTransVO != null)
			PODeskGenerateTransVO = null;
		if (hisutil != null)
			hisutil = null;
		}
		
	}

public static void getSupplierValues
(
		PODeskGenerateTransFB _poDeskGenerateTransFB,
		HttpServletRequest _request, HttpServletResponse _response) 
{
	PODeskGenerateTransVO poDeskGenerateTransVO = null;
	PODeskGenerateTransBO poDeskGenerateTransBO = null;
	try {
		poDeskGenerateTransVO = new PODeskGenerateTransVO();
		poDeskGenerateTransBO = new PODeskGenerateTransBO();
		poDeskGenerateTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
		poDeskGenerateTransVO.setStrContractType("28");
		poDeskGenerateTransVO.setStrItemCat("10");
		// Calling BO Method
		poDeskGenerateTransBO.setSupplierValues1(poDeskGenerateTransVO);
		
		_poDeskGenerateTransFB.setStrSupplierValues(poDeskGenerateTransVO.getStrSupplierValues());
		
	} catch (Exception _Err) {
		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.setSupplierValues()---->", _Err
						.getMessage());
		_poDeskGenerateTransFB
				.setStrErr("ERROR####Application Error [ERROR ID : "
						+ hisException.getErrorID()
						+ "], Contact System Administrator! ");
		hisException = null;
	}
}

public static void getUnitValues1(PODeskGenerateTransFB _poDeskGenerateTransFB,HttpServletRequest _request,HttpServletResponse _response) 
{
	PODeskGenerateTransVO poDeskGenerateTransVO = null;
	PODeskGenerateTransBO poDeskGenerateTransBO = null;
	try 
	{
		poDeskGenerateTransVO = new PODeskGenerateTransVO();
		poDeskGenerateTransBO = new PODeskGenerateTransBO();
		poDeskGenerateTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
		
		poDeskGenerateTransVO.setStrItemId(_request.getParameter("strPOItemID").split("\\@")[1]);
		poDeskGenerateTransVO.setStrRateUnitId(_request.getParameter("strPOItemID").split("\\@")[4]);
		poDeskGenerateTransBO.setUnitValues(poDeskGenerateTransVO);
		_poDeskGenerateTransFB.setStrRateUnitValues(poDeskGenerateTransVO.getStrRateUnitValues());
		if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
			throw new Exception(poDeskGenerateTransVO.getStrMsgString());
		_response.setHeader("Cache-Control", "no-cache");
		_response.getWriter().print(poDeskGenerateTransVO.getStrRateUnitValues());
		
	} 
	catch (Exception _Err)
	{
		 _Err.printStackTrace();
		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getUnitValues1()---->", _Err
						.getMessage());
		_poDeskGenerateTransFB
				.setStrErr("ERROR####Application Error [ERROR ID : "
						+ hisException.getErrorID()
						+ "], Contact System Administrator! ");
		hisException = null;
	}
}

public static void getPOHLP(PODeskGenerateTransFB _poDeskGenerateTransFB,HttpServletRequest _request, HttpServletResponse _response) 
{
	PODeskGenerateTransVO poDeskGenerateTransVO = null;
	PODeskGenerateTransBO poDeskGenerateTransBO = null;
	String strRequestDetails;
	String strCurrentDate;
	int strCurrentMonth;
	int CURRENT_YEAR;
	String strFinancialStartDate;
	String strFinancialEndDate;
	HisUtil hisutil = null;
	try 
	{
		poDeskGenerateTransVO = new PODeskGenerateTransVO();
		poDeskGenerateTransBO = new PODeskGenerateTransBO();
		poDeskGenerateTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
		
			poDeskGenerateTransVO.setStrMode(_request.getParameter("mode"));
			poDeskGenerateTransVO.setStrSupplierId(_request.getParameter("strSupplierId").split("\\^")[0]);
			poDeskGenerateTransVO.setStrItemId(_request.getParameter("strPOItemID").split("\\^")[2]);
			poDeskGenerateTransVO.setStrItemBrandIds(_request.getParameter("strPOItemID").split("\\^")[0]);
			poDeskGenerateTransVO.setStrPOTypeId(_request.getParameter("strComboPOTypeId").split("\\^")[0]);
			poDeskGenerateTransVO.setStrStoreId(_request.getParameter("strStoreId"));
			String strPeriodValue = _request.getParameter("strIndentPeriodValue");
			strFinancialStartDate = "01-Apr"+"-" + (strPeriodValue.split("\\-")[0]).trim(); 							
			strFinancialEndDate = "31-Mar"+"-" + (strPeriodValue.split("\\-")[1]).trim();
		
			_poDeskGenerateTransFB.setStrMode(poDeskGenerateTransVO.getStrMode());
		
		 //  (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)CURRENCY CODE ^(5) NET ADVANCE 
		 //^ (6)PO NET AMOUNT ^(7) SUPPLIER ID ^(8) PO Type ^ (9)Currency Id ^(10) Currency Value ^(11) Item Catg No 
		 //^ (12)Catg Name ^ (13)Purchase Source ID  ^ (14)Purchase Source Name ^ (15)Currency Id ^(16) Currency Value
        //^ (17)Advance Amt ^ (18)PO Prefix With PO No ^ (19)Delivery Date ^ (20)PO PreFix ^ (21)TAX 
        //^ (22)Tender No ^ (23)Tender Date ^ (24)Qutation No ^ (25)Qutation Date ^ (26) PO Date ^ (27) Verify Date ^ (28) Verify BY
		 //^ (29) Financial Start Date ^ (30) Financial End Date
		
		
		hisutil = new HisUtil("DWH Transaction","PODeskGenerateTransDATA");
		strCurrentDate  = hisutil.getASDate("dd-MM-yyyy");
		
		strCurrentMonth = Integer.parseInt( strCurrentDate.split("\\-")[1] );
		
		
		if(strCurrentMonth>=4 )
		{
			CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] );
		}
		else
		{
			CURRENT_YEAR = Integer.parseInt( strCurrentDate.split("\\-")[2] ) - 1 ;	
		}
						
		//strFinancialStartDate = "01-Apr"+"-" + CURRENT_YEAR; 
		
		//strFinancialEndDate = "31-Mar"+"-" + (CURRENT_YEAR+1);	
		
		poDeskGenerateTransVO.setStrFinancialStartDate(strFinancialStartDate);
		poDeskGenerateTransVO.setStrFinancialToDate(strFinancialEndDate);
			
		// Calling BO Method
		poDeskGenerateTransBO.setDWHList(poDeskGenerateTransVO);
		
		_poDeskGenerateTransFB.setWbsReqListPO(poDeskGenerateTransVO.getWbsReqListPO());
		strRequestDetails = PODeskGenerateTransHLP.getPOWithItemHLP(_poDeskGenerateTransFB);
		
		if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
		
			throw new Exception(_poDeskGenerateTransFB.getStrMsgString());

		_response.setHeader("Cache-Control", "no-cache");
		_response.getWriter().print(strRequestDetails);
		
		
	} catch (Exception _Err) 
	{
		_Err.printStackTrace();
		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getPOHLP()---->", _Err
						.getMessage());
		_poDeskGenerateTransFB
				.setStrErr("ERROR####Application Error [ERROR ID : "
						+ hisException.getErrorID()
						+ "], Contact System Administrator! ");
		hisException = null;
	}
}


public static void getPOHLP1(PODeskGenerateTransFB _poDeskGenerateTransFB,HttpServletRequest _request, HttpServletResponse _response) 
{
	PODeskGenerateTransVO poDeskGenerateTransVO = null;
	PODeskGenerateTransBO poDeskGenerateTransBO = null;
	String strRequestDetails;
	try 
	{
		poDeskGenerateTransVO = new PODeskGenerateTransVO();
		poDeskGenerateTransBO = new PODeskGenerateTransBO();
		poDeskGenerateTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
//		//System.out.println("Mode:::"+_request.getParameter("mode"));
//		//System.out.println("Supplier ID:::"+_request.getParameter("strPOItemID").split("\\@")[2]);
//		//System.out.println("PO NO:::"+_request.getParameter("strPOHiddenValue"));
//		//System.out.println("Hidden Value:::"+_request.getParameter("strPOHiddenValue"));
			poDeskGenerateTransVO.setStrMode(_request.getParameter("mode"));
			poDeskGenerateTransVO.setStrSupplierId(_request.getParameter("strPOItemID").split("\\@")[2]);
			poDeskGenerateTransVO.setStrItemId(_request.getParameter("strPOItemID").split("\\@")[1]);
			poDeskGenerateTransVO.setStrItemBrandIds(_request.getParameter("strPOItemID").split("\\@")[0]);
			poDeskGenerateTransVO.setStrStoreId(_request.getParameter("strStoreId"));
			poDeskGenerateTransVO.setStrPOTypeId(_request.getParameter("strPONo"));				
			
		
		_poDeskGenerateTransFB.setStrMode(poDeskGenerateTransVO.getStrMode());

		
		 //  (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)CURRENCY CODE ^(5) NET ADVANCE 
		 //^ (6)PO NET AMOUNT ^(7) SUPPLIER ID ^(8) PO Type ^ (9)Currency Id ^(10) Currency Value ^(11) Item Catg No 
		 //^ (12)Catg Name ^ (13)Purchase Source ID  ^ (14)Purchase Source Name ^ (15)Currency Id ^(16) Currency Value
        //^ (17)Advance Amt ^ (18)PO Prefix With PO No ^ (19)Delivery Date ^ (20)PO PreFix ^ (21)TAX 
        //^ (22)Tender No ^ (23)Tender Date ^ (24)Qutation No ^ (25)Qutation Date ^ (26) PO Date ^ (27) Verify Date ^ (28) Verify BY
		 //^ (29) Financial Start Date ^ (30) Financial End Date
		
		
		poDeskGenerateTransVO.setStrFinancialStartDate(_request.getParameter("strPOHiddenValue").split("\\^")[28]);
		
		poDeskGenerateTransVO.setStrFinancialToDate(_request.getParameter("strPOHiddenValue").split("\\^")[29]);
			
		// Calling BO Method
		poDeskGenerateTransBO.setDWHList(poDeskGenerateTransVO);
		
		_poDeskGenerateTransFB.setWbsReqListPO(poDeskGenerateTransVO.getWbsReqListPO());
		//Calling HLP Method
		strRequestDetails = PODeskGenerateTransHLP.getPOWithItemHLP(_poDeskGenerateTransFB);
		
		
		if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
		
			throw new Exception(_poDeskGenerateTransFB.getStrMsgString());

		_response.setHeader("Cache-Control", "no-cache");
		_response.getWriter().print(strRequestDetails);
		
		
	} catch (Exception _Err) 
	{
		_Err.printStackTrace();
		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getPOHLP1()---->", _Err
						.getMessage());
		_poDeskGenerateTransFB
				.setStrErr("ERROR####Application Error [ERROR ID : "
						+ hisException.getErrorID()
						+ "], Contact System Administrator! ");
		hisException = null;
	}
}


public static void getPOHLP2(PODeskGenerateTransFB _poDeskGenerateTransFB,HttpServletRequest _request, HttpServletResponse _response) 
{
	PODeskGenerateTransVO poDeskGenerateTransVO = null;
	PODeskGenerateTransBO poDeskGenerateTransBO = null;
	String strRequestDetails;
	try 
	{
		poDeskGenerateTransVO = new PODeskGenerateTransVO();
		poDeskGenerateTransBO = new PODeskGenerateTransBO();
		poDeskGenerateTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
//		//System.out.println("Mode:::"+_request.getParameter("mode"));
//		//System.out.println("Supplier ID:::"+_request.getParameter("strPOItemID").split("\\@")[2]);
//		//System.out.println("PO NO:::"+_request.getParameter("strPOHiddenValue"));
		//System.out.println("Hidden Value:::"+_request.getParameter("strPOHiddenValue"));
			poDeskGenerateTransVO.setStrMode(_request.getParameter("mode"));
			poDeskGenerateTransVO.setStrSupplierId(_request.getParameter("strPOItemID").split("\\@")[2]);
			poDeskGenerateTransVO.setStrItemId(_request.getParameter("strPOItemID").split("\\@")[1]);
			poDeskGenerateTransVO.setStrItemBrandIds(_request.getParameter("strPOItemID").split("\\@")[0]);
			poDeskGenerateTransVO.setStrStoreId(_request.getParameter("strStoreId"));
			poDeskGenerateTransVO.setStrPOTypeId(_request.getParameter("strPONo"));				
			
		
		_poDeskGenerateTransFB.setStrMode(poDeskGenerateTransVO.getStrMode());

		
		 //  (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)CURRENCY CODE ^(5) NET ADVANCE 
		 //^ (6)PO NET AMOUNT ^(7) SUPPLIER ID ^(8) PO Type ^ (9)Currency Id ^(10) Currency Value ^(11) Item Catg No 
		 //^ (12)Catg Name ^ (13)Purchase Source ID  ^ (14)Purchase Source Name ^ (15)Currency Id ^(16) Currency Value
        //^ (17)Advance Amt ^ (18)PO Prefix With PO No ^ (19)Delivery Date ^ (20)PO PreFix ^ (21)TAX 
        //^ (22)Tender No ^ (23)Tender Date ^ (24)Qutation No ^ (25)Qutation Date ^ (26) PO Date ^ (27) Verify Date ^ (28) Verify BY
		 //^ (29) Financial Start Date ^ (30) Financial End Date
		
		
		poDeskGenerateTransVO.setStrFinancialStartDate(_request.getParameter("strPOHiddenValue").split("\\^")[28]);
		
		poDeskGenerateTransVO.setStrFinancialToDate(_request.getParameter("strPOHiddenValue").split("\\^")[29]);
			
		// Calling BO Method
		poDeskGenerateTransBO.setDWHList(poDeskGenerateTransVO);
		
		_poDeskGenerateTransFB.setWbsReqListPO(poDeskGenerateTransVO.getWbsReqListPO());
		//Calling HLP Method
		//strRequestDetails = PODeskGenerateTransHLP.getPOWithItemHLP(_poDeskGenerateTransFB);
		strRequestDetails = PODeskGenerateTransHLP.getPOWithItemHLPTWO(_poDeskGenerateTransFB);
		
		if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
		
			throw new Exception(_poDeskGenerateTransFB.getStrMsgString());

		_response.setHeader("Cache-Control", "no-cache");
		_response.getWriter().print(strRequestDetails);
		
		
	} catch (Exception _Err) 
	{
		_Err.printStackTrace();
		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getPOHLP2()---->", _Err
						.getMessage());
		_poDeskGenerateTransFB
				.setStrErr("ERROR####Application Error [ERROR ID : "
						+ hisException.getErrorID()
						+ "], Contact System Administrator! ");
		hisException = null;
	}
}

public static void getPOHLP3(PODeskGenerateTransFB _poDeskGenerateTransFB,HttpServletRequest _request, HttpServletResponse _response) 
{
	PODeskGenerateTransVO poDeskGenerateTransVO = null;
	PODeskGenerateTransBO poDeskGenerateTransBO = null;
	String strRequestDetails;
	try 
	{
		poDeskGenerateTransVO = new PODeskGenerateTransVO();
		poDeskGenerateTransBO = new PODeskGenerateTransBO();
		poDeskGenerateTransVO.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
//		//System.out.println("Mode:::"+_request.getParameter("mode"));
//		//System.out.println("Supplier ID:::"+_request.getParameter("strPOItemID").split("\\@")[2]);
//		//System.out.println("PO NO:::"+_request.getParameter("strPOHiddenValue"));
//		//System.out.println("Hidden Value:::"+_request.getParameter("strPOHiddenValue"));
			poDeskGenerateTransVO.setStrMode(_request.getParameter("mode"));
			poDeskGenerateTransVO.setStrSupplierId(_request.getParameter("strPOItemID").split("\\@")[2]);
			poDeskGenerateTransVO.setStrItemId(_request.getParameter("strPOItemID").split("\\@")[1]);
			poDeskGenerateTransVO.setStrItemBrandIds(_request.getParameter("strPOItemID").split("\\@")[0]);
			poDeskGenerateTransVO.setStrStoreId(_request.getParameter("strStoreId"));
			poDeskGenerateTransVO.setStrPOTypeId(_request.getParameter("strPONo"));				
			poDeskGenerateTransVO.setStrStoreId(_poDeskGenerateTransFB.getStrStoreId());
		
		_poDeskGenerateTransFB.setStrMode(poDeskGenerateTransVO.getStrMode());

		
		 //  (1)PO_DATE ^ (2)SUPP NAME ^ (3)PO TYPE ^ (4)CURRENCY CODE ^(5) NET ADVANCE 
		 //^ (6)PO NET AMOUNT ^(7) SUPPLIER ID ^(8) PO Type ^ (9)Currency Id ^(10) Currency Value ^(11) Item Catg No 
		 //^ (12)Catg Name ^ (13)Purchase Source ID  ^ (14)Purchase Source Name ^ (15)Currency Id ^(16) Currency Value
        //^ (17)Advance Amt ^ (18)PO Prefix With PO No ^ (19)Delivery Date ^ (20)PO PreFix ^ (21)TAX 
        //^ (22)Tender No ^ (23)Tender Date ^ (24)Qutation No ^ (25)Qutation Date ^ (26) PO Date ^ (27) Verify Date ^ (28) Verify BY
		 //^ (29) Financial Start Date ^ (30) Financial End Date
		
		
		poDeskGenerateTransVO.setStrFinancialStartDate(_request.getParameter("strPOHiddenValue").split("\\^")[28]);
		
		poDeskGenerateTransVO.setStrFinancialToDate(_request.getParameter("strPOHiddenValue").split("\\^")[29]);
			
		// Calling BO Method
		poDeskGenerateTransBO.setDWHList(poDeskGenerateTransVO);
		
		_poDeskGenerateTransFB.setWbsReqListPO(poDeskGenerateTransVO.getWbsReqListPO());
		//Calling HLP Method
		//strRequestDetails = PODeskGenerateTransHLP.getPOWithItemHLP(_poDeskGenerateTransFB);
		strRequestDetails = PODeskGenerateTransHLP.getPOWithItemHLPForView(_poDeskGenerateTransFB);
		
		if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
		
			throw new Exception(_poDeskGenerateTransFB.getStrMsgString());

		_response.setHeader("Cache-Control", "no-cache");
		_response.getWriter().print(strRequestDetails);
		
		
	} catch (Exception _Err) 
	{
		_Err.printStackTrace();
		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getPOHLP3()---->", _Err
						.getMessage());
		_poDeskGenerateTransFB
				.setStrErr("ERROR####Application Error [ERROR ID : "
						+ hisException.getErrorID()
						+ "], Contact System Administrator! ");
		hisException = null;
	}
}

public static void getItemDetails(
		PODeskGenerateTransFB _poDeskGenerateTransFB,
		HttpServletRequest _request, HttpServletResponse _response) {
	String strItemDetails = "";
	try {
		_poDeskGenerateTransFB.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));

		_poDeskGenerateTransFB.setStrItemBrandIds(_request.getParameter("strItemBrandID"));
		_poDeskGenerateTransFB.setStrItemId(_request.getParameter("ItemID"));
		_poDeskGenerateTransFB.setStrStoreId(_request.getParameter("strRaisingStore"));
		_poDeskGenerateTransFB.setStrRequestId(_request.getParameter("strReqIds"));
		_poDeskGenerateTransFB.setStrPOTypeId(_request.getParameter("poTypeId"));
		//_poDeskGenerateTransFB.setStrRequestIds(_request.getParameter("strRequestIds"));
		//_poDeskGenerateTransFB.setStrReqIdnDate(_request.getParameter("strReqIdnDate"));
		//_poDeskGenerateTransFB.setStrCheckData(_request.getParameter("strCheckData"));
		
		if(_poDeskGenerateTransFB.getStrPOTypeId().replace("^", "#").split("#")[0].equals("87"))
			strItemDetails = PODeskGenerateTransHLP.getItemDetails(_poDeskGenerateTransFB);
		else
			strItemDetails = PODeskGenerateTransHLP.getDeptItemDetails(_poDeskGenerateTransFB);
		if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
			throw new Exception(_poDeskGenerateTransFB.getStrMsgString());

		_response.setHeader("Cache-Control", "no-cache");
		_response.getWriter().print(strItemDetails);
	} catch (Exception _Err) {

		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getItemDetails()---->",
				_Err.getMessage());
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

public static void getSupplierDetails(
		PODeskGenerateTransFB _poDeskGenerateTransFB,
		HttpServletRequest _request, HttpServletResponse _response) {
	String strSupplierDetails = "";
	try {
		_poDeskGenerateTransFB.setStrHospitalCode((String) _request
				.getSession().getAttribute("HOSPITAL_CODE"));

		_poDeskGenerateTransFB.setStrSupplierId(_request
				.getParameter("suppId"));
		_poDeskGenerateTransFB.setStrContractType(_request
				.getParameter("contractType"));
		_poDeskGenerateTransFB.setStrPOTypeId(_request
				.getParameter("strPOTypeId"));
		_poDeskGenerateTransFB.setStrItemCat(_request
				.getParameter("itemCat"));
		_poDeskGenerateTransFB.setStrRequestIds(_request
				.getParameter("strReqIds"));
		_poDeskGenerateTransFB.setStrTempUnit(_request.getParameter("unitId").replace("^","#").split("#")[0]);
		_poDeskGenerateTransFB.setStrDivId(_request.getParameter("divThisId"));
		_poDeskGenerateTransFB.setStrIndex(_request.getParameter("Index"));
		
		//_poDeskGenerateTransFB.setStrReqIdnDate(_request
		//		.getParameter("strReqIdnDate"));
		///_poDeskGenerateTransFB.setStrCheckData(_request
		//		.getParameter("strCheckData"));
		_poDeskGenerateTransFB.setStrItemBrandIds(_request.getParameter("strItemBrandID"));
		_poDeskGenerateTransFB.setStrStoreId(_request.getParameter("strRaisingStore"));

		strSupplierDetails = PODeskGenerateTransHLP
				.getSupplierDetails(_poDeskGenerateTransFB);
		if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
			throw new Exception(_poDeskGenerateTransFB.getStrMsgString());

		_response.setHeader("Cache-Control", "no-cache");
		_response.getWriter().print(strSupplierDetails);
	} catch (Exception _Err) {

		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getSupplierDetails()---->",
				_Err.getMessage());
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

public static void getSupplierWiseCompiledData(
		PODeskGenerateTransFB _poDeskGenerateTransFB,
		HttpServletRequest _request, HttpServletResponse _response) {
	String strCompiledData = "";
	String bulkData="";
	try {
		_poDeskGenerateTransFB.setStrHospitalCode((String) _request
				.getSession().getAttribute("HOSPITAL_CODE"));
				
		JSONObject jsonObj = new JSONObject(_request.getParameter("json"));
		_poDeskGenerateTransFB.setStrSupplierId(jsonObj.getString("suppId"));
		_poDeskGenerateTransFB.setStrPOTypeId(jsonObj.getString("poType"));
		_poDeskGenerateTransFB.setStrItemCat(jsonObj.getString("itemCat"));
		_poDeskGenerateTransFB.setStrItemId(jsonObj.getString("ItemID"));
		_poDeskGenerateTransFB.setStrItemBrandIds(jsonObj.getString("strItemBrandID"));
		_poDeskGenerateTransFB.setStrStoreId(jsonObj.getString("strRaisingStore"));
		_poDeskGenerateTransFB.setStrTempUnit(jsonObj.getString("unitId"));
		_poDeskGenerateTransFB.setStrDOrderQty((jsonObj.getString("qty").split(",")));
		_poDeskGenerateTransFB.setStrDRate(jsonObj.getString("rate").split(","));
		_poDeskGenerateTransFB.setStrRateUnitValues(jsonObj.getString("trate"));
		_poDeskGenerateTransFB.setStrtQty(jsonObj.getString("tqty"));
		_poDeskGenerateTransFB.setStrDTax(jsonObj.getString("tax").split(","));
		_poDeskGenerateTransFB.setStrPODate(jsonObj.getString("poDate").toString());
		_poDeskGenerateTransFB.setStrGroupId(jsonObj.getString("grp"));
		if(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("22"))
		{	
			_poDeskGenerateTransFB.setStrDMRP(jsonObj.getString("mrp").split(","));
		}
		_poDeskGenerateTransFB.setStrDPackSize(jsonObj.getString("pack").split(","));
		
		
		System.out.println("Json PACK Object-->>"+jsonObj.getString("pack"));
		
		strCompiledData = PODeskGenerateTransHLP.getSupplierWiseCompiledData(_poDeskGenerateTransFB);
		
		if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
			throw new Exception(_poDeskGenerateTransFB.getStrMsgString());
		
		_poDeskGenerateTransFB.setTmpPoType(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2));
		_response.setHeader("Cache-Control", "no-cache");
		
		 PrintWriter writerObj=_response.getWriter();
		 writerObj.write(strCompiledData+""+bulkData);
	} catch (Exception _Err) {

		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getSupplierDetails()---->",
				_Err.getMessage());
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
public static void getSupplierWiseCompiledDataBS(
		PODeskGenerateTransFB _poDeskGenerateTransFB,
		HttpServletRequest _request, HttpServletResponse _response) {
	String strCompiledData = "";
	String bulkData="";
	try {
		
		System.out.println("----------- PODeskGenerateTransDATA . getSupplierWiseCompiledDataBS -----------");
		
		_poDeskGenerateTransFB.setStrHospitalCode((String) _request
				.getSession().getAttribute("HOSPITAL_CODE"));
				
		JSONObject jsonObj = new JSONObject(_request.getParameter("json"));
		
		System.out.println("----------- suppId -->"+jsonObj.getString("suppId"));
		System.out.println("----------- poType -->"+jsonObj.getString("poType"));
		System.out.println("----------- itemCat -->"+jsonObj.getString("itemCat"));
		System.out.println("----------- ItemID -->"+jsonObj.getString("ItemID"));
		System.out.println("----------- strItemBrandID -->"+jsonObj.getString("strItemBrandID"));
		System.out.println("----------- strRaisingStore -->"+jsonObj.getString("strRaisingStore"));
		System.out.println("----------- unitId -->"+jsonObj.getString("unitId"));
		System.out.println("----------- qty -->"+jsonObj.getString("qty"));
		System.out.println("----------- rate -->"+jsonObj.getString("rate"));
		System.out.println("----------- trate -->"+jsonObj.getString("trate"));
		System.out.println("----------- tqty -->"+jsonObj.getString("tqty"));
		
		System.out.println("----------- tax -->"+jsonObj.getString("tax"));
		System.out.println("----------- poDate -->"+jsonObj.getString("poDate"));
		System.out.println("----------- grp -->"+jsonObj.getString("grp"));
		if (jsonObj.getString("mrp") == null)
		{
			throw new Exception("MRP JSON IS NULL");
		}			
		System.out.println("----------- mrp -->"+jsonObj.getString("mrp"));
		System.out.println("----------- pack -->"+jsonObj.getString("pack"));
		
		
		_poDeskGenerateTransFB.setStrSupplierId(jsonObj.getString("suppId"));
		_poDeskGenerateTransFB.setStrPOTypeId(jsonObj.getString("poType"));
		_poDeskGenerateTransFB.setStrItemCat(jsonObj.getString("itemCat"));
		_poDeskGenerateTransFB.setStrItemId(jsonObj.getString("ItemID"));
		_poDeskGenerateTransFB.setStrItemBrandIds(jsonObj.getString("strItemBrandID"));
		_poDeskGenerateTransFB.setStrStoreId(jsonObj.getString("strRaisingStore"));
		_poDeskGenerateTransFB.setStrTempUnit(jsonObj.getString("unitId"));
		_poDeskGenerateTransFB.setStrDOrderQty((jsonObj.getString("qty").split(",")));
		_poDeskGenerateTransFB.setStrDRate(jsonObj.getString("rate").split(","));
		_poDeskGenerateTransFB.setStrRateUnitValues(jsonObj.getString("trate"));
		_poDeskGenerateTransFB.setStrtQty(jsonObj.getString("tqty"));
		_poDeskGenerateTransFB.setStrDTax(jsonObj.getString("tax").split(","));
		_poDeskGenerateTransFB.setStrPODate(jsonObj.getString("poDate").toString());
		_poDeskGenerateTransFB.setStrGroupId(jsonObj.getString("grp"));
		if(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("22"))
			_poDeskGenerateTransFB.setStrDMRP(jsonObj.getString("mrp").split(","));
		_poDeskGenerateTransFB.setStrDPackSize(jsonObj.getString("pack").split(","));
				
		
		
		strCompiledData = PODeskGenerateTransHLP.getSupplierWiseCompiledDataBS(_poDeskGenerateTransFB);
		//if(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2).equals("21"))
		//	bulkData = PODeskGenerateTransHLP.getOtherData(_poDeskGenerateTransFB);
		if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
			throw new Exception(_poDeskGenerateTransFB.getStrMsgString());
		_poDeskGenerateTransFB.setTmpPoType(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2));
		_response.setHeader("Cache-Control", "no-cache");
		//_response.getWriter().print(strCompiledData+""+bulkData);
		 PrintWriter writerObj=_response.getWriter();
		 writerObj.write(strCompiledData+""+bulkData);
	} catch (Exception _Err) {

		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getSupplierDetails()---->",
				_Err.getMessage());
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

public static void indentDetail(
		PODeskGenerateTransFB _poDeskGenerateTransFB,
		HttpServletRequest _request, HttpServletResponse _response) {
	String strCompiledData = "";
	try {
		_poDeskGenerateTransFB.setStrHospitalCode((String) _request
				.getSession().getAttribute("HOSPITAL_CODE"));
		
		_poDeskGenerateTransFB.setStrStoreId(_request.getParameter("strRaisingStore"));
		_poDeskGenerateTransFB.setStrRequestId(_request.getParameter("indentNo"));

		strCompiledData = PODeskGenerateTransHLP.indentDetail(_poDeskGenerateTransFB);
		if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
			throw new Exception(_poDeskGenerateTransFB.getStrMsgString());

		_response.setHeader("Cache-Control", "no-cache");
		_response.getWriter().print(strCompiledData);
	} catch (Exception _Err) {

		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getSupplierDetails()---->",
				_Err.getMessage());
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
public static void indentDetailBS(
		PODeskGenerateTransFB _poDeskGenerateTransFB,
		HttpServletRequest _request, HttpServletResponse _response) {
	String strCompiledData = "";
	try {
		_poDeskGenerateTransFB.setStrHospitalCode((String) _request
				.getSession().getAttribute("HOSPITAL_CODE"));
		
		_poDeskGenerateTransFB.setStrStoreId(_request.getParameter("strRaisingStore"));
		_poDeskGenerateTransFB.setStrRequestId(_request.getParameter("indentNo"));

		strCompiledData = PODeskGenerateTransHLP.indentDetailBS(_poDeskGenerateTransFB);
		if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
			throw new Exception(_poDeskGenerateTransFB.getStrMsgString());

		_response.setHeader("Cache-Control", "no-cache");
		_response.getWriter().print(strCompiledData);
	} catch (Exception _Err) {

		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getSupplierDetails()---->",
				_Err.getMessage());
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
public static void finalizePO(
		PODeskGenerateTransFB _poDeskGenerateTransFB,
		HttpServletRequest _request, HttpServletResponse _response) {
	
	String strIndentDetails = "";
	String strIndentDetailsBS = "";
	try {
		_poDeskGenerateTransFB.setStrHospitalCode((String) _request
				.getSession().getAttribute("HOSPITAL_CODE"));

		String strChk = _request.getParameter("chk");
		_poDeskGenerateTransFB.setStrStoreId(strChk.split("@")[0]);
		_poDeskGenerateTransFB.setStrPoNo(strChk.split("@")[1]);
		_poDeskGenerateTransFB.setStrPOTypeId(strChk.split("@")[3]);
		_poDeskGenerateTransFB.setStrItemCat(strChk.split("@")[4]);
		
			strIndentDetails = PODeskGenerateTransHLP.finalizePO(_poDeskGenerateTransFB);
			strIndentDetailsBS = PODeskGenerateTransHLP.finalizePOBS(_poDeskGenerateTransFB);
			
		if (_poDeskGenerateTransFB.getStrMsgType().equals("1"))
			throw new Exception(_poDeskGenerateTransFB.getStrMsgString());
		_poDeskGenerateTransFB.setTmpPoType(_poDeskGenerateTransFB.getStrPOTypeId().substring(0,2));
		_poDeskGenerateTransFB.setStrDraftPoDetails(strIndentDetails);
		_poDeskGenerateTransFB.setStrDraftPoDetailsBS(strIndentDetailsBS);
	} catch (Exception _Err) {

		HisException hisException = new HisException(
				"Material Management System",
				"PODeskGenerateTransDATA.getRequestItemDetails()---->",
				_Err.getMessage());
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

public static void finalsave(PODeskGenerateTransFB _poDeskGenerateTransFB,
		HttpServletRequest _request) {
	PODeskGenerateTransVO poDeskGenerateTransVO = null;
	PODeskGenerateTransBO poDeskGenerateTransBO = null;
	try {
		poDeskGenerateTransBO = new PODeskGenerateTransBO();
		_poDeskGenerateTransFB.setStrHospitalCode((String) _request.getSession().getAttribute("HOSPITAL_CODE"));
		_poDeskGenerateTransFB.setStrSeatId((String) _request.getSession().getAttribute("SEATID"));
		_poDeskGenerateTransFB.setStrStoreId(_request.getParameterValues("combo")[0]);
		poDeskGenerateTransVO = (PODeskGenerateTransVO) TransferObjectFactory.populateData("mms.transactions.vo.PODeskGenerateTransVO",_poDeskGenerateTransFB);
		poDeskGenerateTransBO.finalsave(poDeskGenerateTransVO);
		if (poDeskGenerateTransVO.getStrMsgType().equals("1"))
			throw new Exception(poDeskGenerateTransVO.getStrMsgString());
		
		if(poDeskGenerateTransVO.getStrMsgType().equals("2"))
		{
			_poDeskGenerateTransFB.setStrErr("Data Save Successfully with Po No(s) : "+poDeskGenerateTransVO.getStrPONoDisplay());	
		}
		
	} 
	catch (Exception _Err) {
		_Err.printStackTrace();
		HisException hisException = new HisException("Material Management System","PODeskGenerateTransDATA.insert()---->", _Err.getMessage());
		_poDeskGenerateTransFB.setStrErr("Error####Application Error [ERROR ID : "+ hisException.getErrorID()+ "], Contact System Administrator! ");
		hisException = null;
	}
}
}
