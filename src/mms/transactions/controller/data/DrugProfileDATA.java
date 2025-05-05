/**
 * 
 */
package mms.transactions.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;
import mms.transactions.bo.DrugProfileBO;
import mms.transactions.controller.fb.DrugProfileFB;
import mms.transactions.controller.hlp.DrugProfileHLP;
import mms.transactions.vo.DrugProfileVO;

/**
 * @author pankaj Date-- 22-Jan-2009 Data Class for Drug Profile Transaction
 * 
 */
public class DrugProfileDATA {
	public static void drugProfilePopup(DrugProfileFB _drugProfileFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String drugCombo = "",ItemCmb="";
		DrugProfileVO drugProfileVO = null;
		//DrugProfileBO drugProfileBO = null;
		//HisUtil hisutil = null;
		try {
			drugProfileVO = new DrugProfileVO();
		//	drugProfileBO = new DrugProfileBO();
		//	hisutil = new HisUtil("mms", "DrugProfileDATA");
			drugProfileVO.setStrGroupID(_request.getParameter("strGroupID")==null? "1":_request.getParameter("strGroupID"));
			
			if(drugProfileVO.getStrGroupID().equals("0")){
				
				drugProfileVO.setStrGroupID("1");
			}
			
			drugProfileVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			drugProfileVO.setStrSeatID((String) _request.getSession()
					.getAttribute("SEATID"));
			/*drugProfileBO.setBrandComboValues(drugProfileVO);
			if (drugProfileVO.getStrItemNameComboWS().size() == 0
					|| drugProfileVO.getStrItemNameComboWS() == null) {
				ItemCmb = "<option value='0'>Select Value</option>";
			} else {
				ItemCmb = hisutil.getOptionValue(drugProfileVO.getStrItemNameComboWS(),
						"0", "0^Select Value", true);

			}
			_drugProfileFB.setStrItemBrandCombo(ItemCmb);*/
			drugCombo = DrugProfileHLP.drugCombos(drugProfileVO);
			if (drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(drugProfileVO.getStrMsgString());
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(drugCombo);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"DrugProfileDATA.drugProfilePopup()---->", _Err
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
	
	public static void genericDtl(DrugProfileFB _drugProfileFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String genericdtl = "",ItemCmb="";
		DrugProfileVO drugProfileVO = null;
		//DrugProfileBO drugProfileBO = null;
		//HisUtil hisutil = null;
		try {
			drugProfileVO = new DrugProfileVO();
		//	drugProfileBO = new DrugProfileBO();
		//	hisutil = new HisUtil("mms", "DrugProfileDATA");
			drugProfileVO.setStrGroupID(_request.getParameter("strGroupID")==null? "1":_request.getParameter("strGroupID"));
			
			if(drugProfileVO.getStrGroupID().equals("0")){
				
				drugProfileVO.setStrGroupID("1");
			}
			
			drugProfileVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			drugProfileVO.setStrSeatID((String) _request.getSession()
					.getAttribute("SEATID"));
			drugProfileVO.setStrItemID(_request.getParameter("strItemID")==null? "1":_request.getParameter("strItemID"));
			/*drugProfileBO.setBrandComboValues(drugProfileVO);
			if (drugProfileVO.getStrItemNameComboWS().size() == 0
					|| drugProfileVO.getStrItemNameComboWS() == null) {
				ItemCmb = "<option value='0'>Select Value</option>";
			} else {
				ItemCmb = hisutil.getOptionValue(drugProfileVO.getStrItemNameComboWS(),
						"0", "0^Select Value", true);

			}
			_drugProfileFB.setStrItemBrandCombo(ItemCmb);*/
			genericdtl = DrugProfileHLP.genericDtls(drugProfileVO);
			if (drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(drugProfileVO.getStrMsgString());
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(genericdtl);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"DrugProfileDATA.drugProfilePopup()---->", _Err
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
	public static void drugBrandCombo(DrugProfileFB _drugProfileFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String drugCombo = "",ItemCmb="";
		DrugProfileVO drugProfileVO = null;
		DrugProfileBO drugProfileBO = null;
		HisUtil hisutil = null;
		try {
			drugProfileVO = new DrugProfileVO();
			drugProfileBO = new DrugProfileBO();
			hisutil = new HisUtil("mms", "DrugProfileDATA");
			
			drugProfileVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			drugProfileVO.setStrSeatID((String) _request.getSession()
					.getAttribute("SEATID"));
			drugProfileBO.setBrandComboValues(drugProfileVO);
			if (drugProfileVO.getStrItemNameComboWS().size() == 0
					|| drugProfileVO.getStrItemNameComboWS() == null) {
				ItemCmb = "<option value='0'>Select Value</option>";
			} else {
				ItemCmb = hisutil.getOptionValue(drugProfileVO.getStrItemNameComboWS(),
						"0", "0^Select Value", true);

			}
			_drugProfileFB.setStrItemBrandCombo(ItemCmb);
			
			if (drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(drugProfileVO.getStrMsgString());
			/*_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(ItemCmb);*/
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"DrugProfileDATA.drugProfilePopup()---->", _Err
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

	public static void getStrSubGroupComboValues(DrugProfileFB _drugProfileFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		DrugProfileBO drugProfileBO = null;
		DrugProfileVO drugProfileVO = null;
		try {
			drugProfileVO = new DrugProfileVO();
			drugProfileVO.setStrSubGroupID(_request.getParameter("strSubGroupID")==null?"":_request.getParameter("strSubGroupID"));
			drugProfileVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			drugProfileVO.setStrSeatID((String) _request.getSession()
					.getAttribute("SEATID"));
			drugProfileVO.setStrGroupID(_request.getParameter("strGroupID"));
			drugProfileBO = new DrugProfileBO();
			drugProfileBO.setSubGroupComboValues(drugProfileVO);
			if (drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(drugProfileVO.getStrMsgString());
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(
					"<select name='strSubGroupID' onchange='getDrugCombo()' class='comboNormal'>"
							+ drugProfileVO.getStrSubGroupComboValues()
							+ "</select>");
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"DrugProfileDATA.getStrSubGroupComboValues()---->", _Err
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

	public static void getStrDrugComboValues(DrugProfileFB _drugProfileFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		DrugProfileBO drugProfileBO = null;
		DrugProfileVO drugProfileVO = null;
		try {
			drugProfileVO = new DrugProfileVO();
			drugProfileVO.setStrItemID(_request.getParameter("strItemID")==null?"":_request.getParameter("strItemID"));
			drugProfileVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			drugProfileVO.setStrSeatID((String) _request.getSession()
					.getAttribute("SEATID"));
			drugProfileVO.setStrGroupID(_request.getParameter("strGroupID"));
			
			if(drugProfileVO.getStrGroupID().equals("0")){
				
				drugProfileVO.setStrGroupID("1");
			}
			
			drugProfileVO.setStrSubGroupID(_request
					.getParameter("strSubGroupID"));
			
			
			
			drugProfileBO = new DrugProfileBO();
			drugProfileBO.setDrugComboValues(drugProfileVO);
			if (drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(drugProfileVO.getStrMsgString());
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(
					"<select name='strItemID' onchange='hideAllDetails()' class='comboNormal'>"
							+ drugProfileVO.getStrDrugComboValues()
							+ "</select>");
		} catch (Exception _Err) {
			HisException hisException = new HisException(
					"Material Management System",
					"DrugProfileDATA.getStrDrugComboValues()---->", _Err
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

	public static void dosageData(DrugProfileFB _drugProfileFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strDosageData = null;
		DrugProfileVO drugProfileVO = null;
		try {
			drugProfileVO = new DrugProfileVO();
		
			drugProfileVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			drugProfileVO.setStrSeatID((String) _request.getSession()
					.getAttribute("SEATID"));
			drugProfileVO.setStrGroupID(_request.getParameter("strGroupID"));
			drugProfileVO.setStrSubGroupID(_request
					.getParameter("strSubGroupID"));
			drugProfileVO.setStrItemID(_request.getParameter("strItemID"));
			strDosageData = DrugProfileHLP.dosageData(drugProfileVO);
			if (drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(drugProfileVO.getStrMsgString());
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strDosageData);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"DrugProfileDATA.dosageData()---->", _Err.getMessage());
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

	public static void saftyData(DrugProfileFB _drugProfileFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strSaftyData = null;
		DrugProfileVO drugProfileVO = null;
		try {
			drugProfileVO = new DrugProfileVO();
			drugProfileVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			drugProfileVO.setStrSeatID((String) _request.getSession()
					.getAttribute("SEATID"));
			drugProfileVO.setStrGroupID(_request.getParameter("strGroupID"));
			drugProfileVO.setStrSubGroupID(_request
					.getParameter("strSubGroupID"));
			drugProfileVO.setStrItemID(_request.getParameter("strItemID"));
			strSaftyData = DrugProfileHLP.saftyData(drugProfileVO);
			if (drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(drugProfileVO.getStrMsgString());
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strSaftyData);
		} catch (Exception _Err) {
		
			HisException hisException = new HisException(
					"Material Management System",
					"DrugProfileDATA.saftyData()---->", _Err.getMessage());
			try {
				_response.getWriter().print(
						"Error####Application Error [ERROR ID : "
								+ hisException.getErrorID()
								+ "], Contact System Administrator! ");
			} catch (Exception _Err1) {
				_Err1.printStackTrace();
			}
			hisException = null;
		}
	}

	public static void brandData(DrugProfileFB _drugProfileFB,
			HttpServletRequest _request, HttpServletResponse _response) {
		String strBrandData = null;
		DrugProfileVO drugProfileVO = null;
		try {
			drugProfileVO = new DrugProfileVO();
			drugProfileVO.setStrHospitalCode((String) _request.getSession()
					.getAttribute("HOSPITAL_CODE"));
			drugProfileVO.setStrSeatID((String) _request.getSession()
					.getAttribute("SEATID"));
			drugProfileVO.setStrGroupID(_request.getParameter("strGroupID"));
			drugProfileVO.setStrSubGroupID(_request
					.getParameter("strSubGroupID"));
			drugProfileVO.setStrItemID(_request.getParameter("strItemID"));
			strBrandData = DrugProfileHLP.setBrandedItemData(drugProfileVO);
			if (drugProfileVO.getStrMsgType().equals("1"))
				throw new Exception(drugProfileVO.getStrMsgString());
			_response.setHeader("Cache-Control", "no-cache");
			_response.getWriter().print(strBrandData);
		} catch (Exception _Err) {

			HisException hisException = new HisException(
					"Material Management System",
					"DrugProfileDATA.brandData()---->", _Err.getMessage());
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
	
	public static void setChkVal(DrugProfileFB _drugProfileFB,
			HttpServletRequest _request) {
		try {
			_drugProfileFB.setStrChkVal(_request.getParameter("chk").replace("@", "#").split("#")[1]);
			
		} catch (Exception _Err) {
			 new HisException(
					"Material Management System",
					"DrugProfileDATA.setChkVal()---->", _Err.getMessage());
		}
	}
}
