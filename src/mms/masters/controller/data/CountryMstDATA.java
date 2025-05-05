package mms.masters.controller.data;


import hisglobal.exceptions.HisException;
import javax.servlet.http.HttpServletRequest;
import mms.masters.bo.CountryMstBO;
import mms.masters.controller.fb.CountryMstFB;
import mms.masters.vo.CountryMstVO;


/**
 * @author:-	Adil Wasi   
 * Creation Date:- 6-Jun-2011 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 *  Module:- DWH(HIS Project)
 * 
 */



/**
 * The Class CountryMstDATA.
 */

public class CountryMstDATA {
	
	
	/**
	 * to insert the data.
	 * 
	 * @param formBean_p the form bean
	 * @param request_p the request
	 */
	public static void insertRecord(CountryMstFB formBean_p, HttpServletRequest request_p) {
		
		CountryMstBO bo = null;
		CountryMstVO vo = null;
		String strmsgText = "";
		
		
		try {
			vo=new CountryMstVO();
			bo=new CountryMstBO();
			
			String strHosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
			
			formBean_p.setStrHospitalCode(strHosCode);
			
			vo.setStrSeatId(strSeatId);
			vo.setStrHospitalCode(formBean_p.getStrHospitalCode());
			vo.setStrCountryName(formBean_p.getStrCountryName());
			vo.setStrCountryShortName(formBean_p.getStrCountryShortName());
			vo.setStrNationality(formBean_p.getStrNationality());
			vo.setStrIsValid(formBean_p.getStrIsValid());
			
			bo.insertRecord(vo);

			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}

			if (vo.getBExistStatus() == false) {
				formBean_p.setStrWarningMsg("Record already exist");
			} else {
				formBean_p.setStrNormalMsg("Record Saved Successfully");
			}

			

		} catch (Exception e) {
			e.printStackTrace();

			strmsgText = "CountryMst.CountryMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"CountryMstDATA->insertRecord()", strmsgText);
			formBean_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");

			eObj = null;
		} finally {
			bo = null;
			vo = null;
		}

	}
	
	
	/**
	 * to get the data for modify page.
	 * 
	 * @param formBean_p the form bean
	 * @param request_p the request
	 */
	public static void modifyRecord(CountryMstFB formBean_p, HttpServletRequest request_p) {
		// TODO Auto-generated method stub
		CountryMstBO bo = null;
		CountryMstVO vo = null;
		String strTemp[] = null;
		String strTemp2[] = null;
		String strmsgText = "";
		String strChk="";

		
		
		try {
			bo = new CountryMstBO();
			vo = new CountryMstVO();
			strChk = request_p.getParameter("chk");
			
			//System.out.println("strchk: "+strChk);
			if(strChk!=null && !strChk.trim().equals("")) {
				strTemp = strChk.replace("@", "#").split("#");
				strTemp2=strTemp[1].replace("$", "#").split("#");
				vo.setStrCountryCode(strTemp[0]);
				vo.setStrHospitalCode(strTemp2[0]);
				
			} 
            /*String strCountryName = request_p.getParameter("strCountryName");
            String strEffectiveFrom = request_p.getParameter("strEffectiveFrom");
            String strRemarks = request_p.getParameter("strRemarks");*/
            
            
			vo.setStrCountryName(formBean_p.getStrCountryName());
			vo.setStrCountryShortName(formBean_p.getStrCountryShortName());
			vo.setStrNationality(formBean_p.getStrNationality());
			vo.setStrIsValid(formBean_p.getStrIsValid());
			
			bo.modifyRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			formBean_p.setStrCountryName(vo.getStrCountryName());
			formBean_p.setStrCountryShortName(vo.getStrCountryShortName());
			formBean_p.setStrNationality(vo.getStrNationality());
			formBean_p.setStrIsValid(vo.getStrIsValid());
			formBean_p.setStrCountryCode(vo.getStrCountryCode());
		} 
		catch (Exception e) 
		{
			strmsgText = "CountryMstDATA.modifyRecord(formBean_p,request_p) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms","CountryMstDATA->modifyRecord()", strmsgText);
			formBean_p.setStrErrMsg("Application Error [ERROR ID : "
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
	 * to update the record after modifying it.
	 * 
	 * @param formBean_p the form bean
	 * @param request_p the request
	 * 
	 * @return true, if update record
	 */
	public static boolean updateRecord(CountryMstFB formBean_p,HttpServletRequest request_p) 
	{
		CountryMstBO bo = null;
		CountryMstVO vo = null;
		boolean bReturnValue = true;
		String strMsgText;
		
		
		try {
			bo = new CountryMstBO();
			vo = new CountryMstVO();
			
			String strHosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			vo.setStrCountryCode(formBean_p.getStrCountryCode());
			vo.setStrCountryName(formBean_p.getStrCountryName());
			vo.setStrCountryShortName(formBean_p.getStrCountryShortName());
			vo.setStrNationality(formBean_p.getStrNationality());
			vo.setStrIsValid(formBean_p.getStrIsValid());
			vo.setStrHospitalCode(strHosCode);
			
			bo.updateRecord(vo);

				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				
				if (vo.getBExistStatus() == false) 
				{
					formBean_p.setStrWarningMsg("Country Name already exist !");
					bReturnValue = false;

				}
				else 
				{
						formBean_p.setStrNormalMsg("Record Modified Successfully");
				}
			} 
			catch (Exception e) 
			{
			bReturnValue = false;
			strMsgText = "CountryMstDATA.updateRecord(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms","CountryMstDATA->updateRecord()", strMsgText);
			formBean_p.setStrErrMsg("Application Error [ERROR ID : "
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
	
