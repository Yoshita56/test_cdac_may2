package mms.masters.controller.data;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mms.masters.bo.DistrictMstBO;
import mms.masters.controller.fb.DistrictMstFB;
import mms.masters.vo.DistrictMstVO;
import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

/**
 * @author Adil Wasi  
 * Creation Date:- 27-July-2011 
 * Modifying Date:- 
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class DistrictMstDATA 
{
	
	/**
	 * To initialize Add Page.
	 * 
	 * @param formBean the District Master FormBean
	 * @param request the HttpServletRequest
	 */
	public static void initializeAdd(DistrictMstFB districtMstFB_p, HttpServletRequest request_p) 
	{
		
		String strMsgText;
		HisUtil hisutil = null;
		DistrictMstBO bo = null;
		DistrictMstVO vo = null;
		String strCountryCombo=null;
		String strStateCombo=null;
		
		
		String arr_strListPageCombos[]=null;

		try 
		{
			hisutil = new HisUtil("mms", "DistrictMstDATA");
			
			vo = new DistrictMstVO();
			bo = new DistrictMstBO();
			
			String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strCtDate = hisutil.getASDate("dd-MMM-yyyy");
			
			arr_strListPageCombos=districtMstFB_p.getCombo();
			
			if(arr_strListPageCombos!=null && arr_strListPageCombos.length >= 2 ) {
				districtMstFB_p.setStrCountryId(arr_strListPageCombos[0]);
				districtMstFB_p.setStrStateId(arr_strListPageCombos[1]);
				districtMstFB_p.setStrCountryCode(arr_strListPageCombos[0]);
				districtMstFB_p.setStrStatecode(arr_strListPageCombos[1]);
				
			}
			else {
				districtMstFB_p.setStrCountryId("0");
				districtMstFB_p.setStrStateId("0");
				districtMstFB_p.setStrCountryCode("0");
				districtMstFB_p.setStrStatecode("0");
			}
			TransferObjectFactory.populateData(vo, districtMstFB_p);

			vo.setStrHospitalCode(strHospitalCode);
			
// Calling BO object
			bo.initializeAdd(vo);
			
			districtMstFB_p.setStrCtDate(strCtDate);
			if (vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getStrCountryWS() != null && vo.getStrCountryWS().size() > 0) 
			{
				strCountryCombo = hisutil.getOptionValue(vo.getStrCountryWS(), vo.getStrCountryId(),"0^Select Value", false);
			}
			
			else
			{
				strCountryCombo = "<option value='0'>Select Value</option>";
			}
			
			if (vo.getStrStateWS() != null && vo.getStrStateWS().size() > 0) 
			{
				strStateCombo = hisutil.getOptionValue(vo.getStrStateWS(), vo.getStrStateId(),"0^Select Value", false);
			}
			
			else
			{
				strStateCombo = "<option value='0'>Select Value</option>";
			}
			
			districtMstFB_p.setStrCountryCombo(strCountryCombo); 
			districtMstFB_p.setStrStateCombo(strStateCombo);
		}	
		catch (Exception e) 
		{
			strMsgText = "DistrictMstDATA.initializeAdd(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms","DistrictMstDATA.initializeAdd(districtMstFB_p,request_p)", strMsgText);
			districtMstFB_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
		
		eObj = null;
		}
	}
	
	
	
	
	/**
	 * To get State combo on Add Page.
	 * 
	 * @param formBean the District Master FormBean
	 * @param request the HttpServletRequest
	 */
	public static void getStateCombo(DistrictMstFB districtMstFB_p, HttpServletRequest request_p, HttpServletResponse response_p) 
	{
		
		String strMsgText;
		HisUtil hisutil = null;
		DistrictMstBO bo = null;
		DistrictMstVO vo = null;
		String strStateComboWS=null;
		
		
		try 
		{
			hisutil = new HisUtil("mms", "DistrictMstDATA");
			
			vo = new DistrictMstVO();
			bo = new DistrictMstBO();
			
			String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrCountryCode(request_p.getParameter("countryCode"));
			
			
// Calling BO object
			
			bo.getStrStateCombo(vo);
			
			if (vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getStrStateWS() != null && vo.getStrStateWS().size() > 0) 
			{
				strStateComboWS = hisutil.getOptionValue(vo.getStrStateWS(), vo.getStrStateId(),"0^Select Value", false);
			}
			
			else
			{
				strStateComboWS = "<option value='0'>Select Value</option>";
			}
			
				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(strStateComboWS);
		}	
		catch (Exception e) 
		{
			strMsgText = "DistrictMstDATA.getStateCombo(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms","DistrictMstDATA.getStateCombo(districtMstFB_p,request_p)", strMsgText);
			try 
			{
				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(
						"ERROR#### Application Error [ERROR ID : "
								+ eObj.getErrorID()
								+ "],Contact System Administrator! ");
	
			}
			catch (Exception e1)
			{
				new HisException("mms","DistrictMstDATA.getStateCombo()", strMsgText);
			}
		
		eObj = null;
		}
		finally
		{
			hisutil = null;
			vo = null;
			bo = null;
		}
	}




	/**
	 * to insert the data.
	 * 
	 * @param formBean the form bean
	 * @param request_p the request
	 */
	public static void insertRecord(DistrictMstFB districtMstFB_p,	HttpServletRequest request_p) 
	{
		DistrictMstBO bo = null;
		DistrictMstVO vo = null;
		String strmsgText = "";
		try {
			bo = new DistrictMstBO();
			vo = new DistrictMstVO();

			String hosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			String seatid = request_p.getSession().getAttribute("SEATID").toString();

			districtMstFB_p.setStrHospitalCode(hosCode);					//from session
			districtMstFB_p.setStrSeatId(seatid);							//from session
			districtMstFB_p.setStrIsValid("1");
			
			TransferObjectFactory.populateData(vo, districtMstFB_p);
			vo.setStrMode("1");

			vo.setStrStatecode(districtMstFB_p.getStrStateId());
			vo.setStrCountryCode(districtMstFB_p.getStrCountryId());
			bo.insertRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) {
				if(vo.isDepartmentNameExist() && vo.isDepartmentShortNameExist()){
					districtMstFB_p.setStrWarningMsg("District Name and District Short Name already exist !");
				}else if(vo.isDepartmentNameExist()){
					districtMstFB_p.setStrWarningMsg("District Name already exist !");
				}else{
					districtMstFB_p.setStrWarningMsg("District Short Name already exist !");
				}
				
			}
			else {
				districtMstFB_p.setStrNormalMsg("Record Saved Successfully!");
			}

		}
		catch (Exception e) 
		{

			//e.printStackTrace();
			
			strmsgText = "DistrictMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("bmed",
					"DistrictMstDATA->insertRecord()", strmsgText);
			districtMstFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			bo = null;
			vo = null;
		}

	}

	
	

	/**
	 * to get the data for modify page.
	 * 
	 * @param districtMstFB_p the form bean
	 * @param request the request
	 */

	public static void modifyRecord(DistrictMstFB districtMstFB_p, HttpServletRequest request_p) {

		DistrictMstBO bo = null;
		DistrictMstVO vo = null;
		String strTemp[] = null;
		String strTemp2[] = null;
		String strMsgText = "";
		String strChk = "";
		HisUtil hisutil = null;

		
		try {
			bo = new DistrictMstBO();
			vo = new DistrictMstVO();
			hisutil = new HisUtil("mms", "DistrictMstDATA");
			
			String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
			String strCtDate = hisutil.getASDate("dd-MMM-yyyy");
			
            String strCombos[] = request_p.getParameterValues("combo");

			strChk = request_p.getParameter("chk");
			
			//chk value::		15033@1@999$7
			// Primary Key::	GNUM_DistrictID@SL_NO@GNUM_HOSPITAL_CODE

			if(strChk!=null && !strChk.trim().equals("")) {
				
				strTemp = strChk.replace('@', '#').split("#");
				strTemp2 = strTemp[2].replace("$", "#").split("#");

				vo.setStrDistrictId(strTemp[0]);
				vo.setStrHospitalCode(strTemp2[0]);
				
			} 
			vo.setStrCountryCode(strCombos[0]);
			vo.setStrStatecode(strCombos[1]);
			vo.setStrSeatId(strSeatId);
			vo.setStrCtDate(strCtDate);
			vo.setStrIsValid("1");
			
			bo.modifyRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			districtMstFB_p.setStrCountryName(vo.getStrCountryName());
			districtMstFB_p.setStrStateName(vo.getStrStateName());
			districtMstFB_p.setStrDistrictName(vo.getStrDistrictName());
			districtMstFB_p.setStrDistrictShortName(vo.getStrDistrictShortName());
			districtMstFB_p.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			districtMstFB_p.setStrEffectiveTo(vo.getStrEffectiveTo());
			districtMstFB_p.setStrRemarks(vo.getStrRemarks());
			districtMstFB_p.setStrIsValid(vo.getStrIsValid());
			
			
		} 
		catch (Exception e) 
		{
			strMsgText = "DistrictMstDATA.modifyRecord(districtMstFB_p,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","DistrictMstDATA->modifyRecord()", strMsgText);
			districtMstFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		}
		finally 
		{
			bo = null;
			vo = null;
		}

		
	}

	

	/**
	 * to update the record after modifying it.
	 * 
	 * @param districtMstFB_p the form bean
	 * @param request_p the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(DistrictMstFB districtMstFB_p,HttpServletRequest request_p) 
	{
		DistrictMstBO bo = null;
		DistrictMstVO vo = null;
		String strTemp[] = null;
		String strTemp2[] = null;
		String strMsgText = "";
		String strChk = "";
		HisUtil hisutil = null;
		boolean bReturnValue = true;

		
		try {
			bo = new DistrictMstBO();
			vo = new DistrictMstVO();
			hisutil = new HisUtil("mms", "DistrictMstDATA");
			
			String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
			
            String strCombos[] = request_p.getParameterValues("combo");

			strChk=request_p.getParameter("chk");
			//chk value::		15033@1@999$7
			// Primary Key::	GNUM_DistrictID@SL_NO@GNUM_HOSPITAL_CODE


			if(strChk!=null && !strChk.trim().equals("")) {
				
				strTemp = strChk.replace('@', '#').split("#");
				strTemp2 = strTemp[2].replace("$", "#").split("#");
 
				vo.setStrDistrictId(strTemp[0]);
				vo.setStrHospitalCode(strTemp2[0]);
				
			} 
			vo.setStrCountryCode(strCombos[0]);
			vo.setStrStatecode(strCombos[1]);
			vo.setStrHospitalCode(strHospitalCode);
			vo.setStrMode("2");
			vo.setStrDistrictName(districtMstFB_p.getStrDistrictName());
			vo.setStrDistrictShortName(districtMstFB_p.getStrDistrictShortName());
			vo.setStrEffectiveFrom(districtMstFB_p.getStrEffectiveFrom());
			vo.setStrEffectiveTo(districtMstFB_p.getStrEffectiveTo());
			vo.setStrRemarks(districtMstFB_p.getStrRemarks());
			vo.setStrIsValid(districtMstFB_p.getStrIsValid());
			vo.setStrSeatId(strSeatId);
			vo.setStrLastModifySeatId(strSeatId);
			
			bo.updateRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			if (vo.getBExistStatus() == false) {
				if(vo.isDepartmentNameExist() && vo.isDepartmentShortNameExist()){
					districtMstFB_p.setStrWarningMsg("District Name and District Short Name already exist !");
					bReturnValue = false;
				}else if(vo.isDepartmentNameExist()){
					districtMstFB_p.setStrWarningMsg("District Name already exist !");
					bReturnValue = false;
				}else{
					districtMstFB_p.setStrWarningMsg("District Short Name already exist !");
					bReturnValue = false;
				}
				
			}
			else {
				districtMstFB_p.setStrNormalMsg("Record Saved Successfully!");
			}
			
		}
		catch (Exception e) 
		{
			bReturnValue = false;
			strMsgText = "DistrictMstDATA.updateRecord(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms","DistrictMstDATA->updateRecord()", strMsgText);
			districtMstFB_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
	
			eObj = null;
		} 
		finally 
		{
		bo = null;
		vo = null;
		}
			
		return bReturnValue;
	}
		

}
