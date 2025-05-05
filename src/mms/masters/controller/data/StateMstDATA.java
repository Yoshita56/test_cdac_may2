package mms.masters.controller.data;

import javax.servlet.http.HttpServletRequest;

import mms.masters.bo.StateMstBO;
import mms.masters.controller.fb.StateMstFB;
import mms.masters.vo.StateMstVO;
import hisglobal.TransferObjectFactory;
import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

/**
 * @author Vivek Aggarwal  
 * Creation Date:- 1-June-2011 
 * Modifying Date:- 3-June-2011
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class StateMstDATA 
{
	
	/**
	 * To initialize Add Page.
	 * 
	 * @param formBean the State Master FormBean
	 * @param request the HttpServletRequest
	 */
	public static void initializeAdd(StateMstFB stateMstFB_p, HttpServletRequest request_p) 
	{
		
		String strMsgText;
		HisUtil hisutil = null;
		StateMstBO bo = null;
		StateMstVO vo = null;
		
		
		String arr_strListPageCombos[]=null;

		try 
		{
			hisutil = new HisUtil("mms", "StateMstDATA");
			
			vo = new StateMstVO();
			bo = new StateMstBO();
			
			String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			
			arr_strListPageCombos=stateMstFB_p.getCombo();
			
			if(arr_strListPageCombos!=null && arr_strListPageCombos.length >= 1 ) {
				stateMstFB_p.setStrCountryCode(arr_strListPageCombos[0]);
				
			}
			else {
				stateMstFB_p.setStrCountryCode("0");
			}
			
			vo.setStrCountryCode(stateMstFB_p.getStrCountryCode());
			vo.setStrHospitalCode(strHospitalCode);
			
// Calling BO object
			bo.initializeAdd(vo);
			
			if (vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			
			else {
				stateMstFB_p.setStrCountryName(vo.getStrCountryName());
			}
		}	
		catch (Exception e) 
		{
			strMsgText = "StateMstDATA.initializeAdd(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms","StateMstDATA.initializeAdd(stateMstFB_p,request_p)", strMsgText);
			stateMstFB_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
		
		eObj = null;
		}
	}
	
	
	/**
	 * to insert the data.
	 * 
	 * @param stateMstFB_p the form bean
	 * @param request_p the request
	 */
	public static void insertRecord(StateMstFB stateMstFB_p, HttpServletRequest request_p) 
	{
		StateMstBO bo = null;
		StateMstVO vo = null;
		String strMsgText = "";

		try {
			bo = new StateMstBO();
			vo = new StateMstVO();

			String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request_p.getSession().getAttribute("SEATID").toString();

		
			vo.setStrMode("1");
			vo.setStrStateName(stateMstFB_p.getStrStateName());	
			vo.setStrStateShortName(stateMstFB_p.getStrStateShortName().toUpperCase());
			vo.setStrCountryCode(stateMstFB_p.getCombo()[0]);
			vo.setStrHospitalCode(strHospitalCode);	//from session
			vo.setStrSeatId(strSeatId);	//from session
			vo.setStrIsValid("1");

			bo.insertRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.isBExistStatus() == false) {
				stateMstFB_p.setStrWarningMsg("State Name already exist !");
			}
			else {
				stateMstFB_p.setStrNormalMsg("Record Saved Successfully!");
			}

		}
		catch (Exception e) 
		{

			//e.printStackTrace();
			
			strMsgText = "StateMstDATA.insertRecord(vo) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms", "StateMstDATA->insertRecord()", strMsgText);
			stateMstFB_p.setStrErrMsg("Application Error [ERROR ID : "
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
	 * @param stateMstFB_p the form bean
	 * @param request the request
	 */
	public static void modifyRecord(StateMstFB stateMstFB_p,	HttpServletRequest request_p) 
	{
		StateMstBO bo = null;
		StateMstVO vo = null;
		String strTemp[] = null;
		String strTemp2[] = null;
		String strMsgText = "";
		String strChk = "";

		
		try {
			bo = new StateMstBO();
			vo = new StateMstVO();
            String strCombos[] = request_p.getParameterValues("combo");

			strChk = request_p.getParameter("chk");
			
			
			//chk value::		10@108$6
            // Primary Key::	GNUM_STATECODE@GNUM_HOSPITAL_CODE

			if(strChk!=null && !strChk.trim().equals("")) {
				
				strTemp = strChk.replace('@', '#').split("#");
				strTemp2 = strTemp[1].replace("$", "#").split("#");

				vo.setStrStateCode(strTemp[0]);
				vo.setStrHospitalCode(strTemp2[0]);
				
			} 

			vo.setStrCountryCode(strCombos[0]);
			

			bo.modifyRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			stateMstFB_p.setStrCountryName(vo.getStrCountryName());
			stateMstFB_p.setStrStateName(vo.getStrStateName());
			stateMstFB_p.setStrStateShortName(vo.getStrStateShortName());
			stateMstFB_p.setStrIsValid(vo.getStrIsValid());
			
		} 
		catch (Exception e) 
		{
			strMsgText = "StateMstDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
			HisException eObj = new HisException("mms","StateMstDATA->modifyRecord()", strMsgText);
			stateMstFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

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
	 * @param stateMstFB_p the form bean
	 * @param request_p the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(StateMstFB stateMstFB_p,HttpServletRequest request_p) 
	{
		StateMstBO bo = null;
		StateMstVO vo = null;
		boolean bReturnValue = true;
		String strTemp[] = null;
		String strTemp2[] = null;
		String strMsgText;
		String strChk = "";

		String strCombos[] = request_p.getParameterValues("combo");

		try {
			bo = new StateMstBO();
			vo = new StateMstVO();
			
            strChk = request_p.getParameter("chk");

        	//chk value::		10@108$6
            // Primary Key::	GNUM_STATECODE@GNUM_HOSPITAL_CODE
            
			if(strChk!=null && !strChk.trim().equals("")) {
				
				strTemp = strChk.replace('@', '#').split("#");
				strTemp2 = strTemp[1].replace("$", "#").split("#");
			
				vo.setStrStateCode(strTemp[0]);
				vo.setStrHospitalCode(strTemp2[0]);
				
			} 
			
			vo.setStrMode("2");
			vo.setStrCountryCode(strCombos[0]);
			vo.setStrStateName(stateMstFB_p.getStrStateName());
			vo.setStrStateShortName(stateMstFB_p.getStrStateShortName().toUpperCase());
			vo.setStrIsValid(stateMstFB_p.getStrIsValid());
			
			bo.updateRecord(vo);

				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				
				if (vo.isBExistStatus() == false) 
				{
					stateMstFB_p.setStrWarningMsg("State Name already exist !");
					bReturnValue = false;

				}
				else 
				{
						stateMstFB_p.setStrNormalMsg("Record Modified Successfully");
				}
			} 
			catch (Exception e) 
			{
			bReturnValue = false;
			strMsgText = "StateMstDATA.updateRecord(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms","StateMstDATA->updateRecord()", strMsgText);
			stateMstFB_p.setStrErrMsg("Application Error [ERROR ID : "
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
