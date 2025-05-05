package mms.masters.controller.data;


import hisglobal.exceptions.HisException;
import javax.servlet.http.HttpServletRequest;
import hisglobal.utility.HisUtil;
import mms.masters.bo.SchemeMstBO;
import mms.masters.controller.fb.SchemeMstFB;
import mms.masters.vo.SchemeMstVO;


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
 * The Class SchemeMstDATA.
 */

public class SchemeMstDATA {
	
	
	/**
	 * to get the initial data for add page.
	 * 
	 * @param formBean_p the form bean
	 * @param request_p the request
	 */
	public static void initializeAdd(SchemeMstFB formBean_p, HttpServletRequest request_p) 
	{
		
		String strMsgText;
		HisUtil hisutil = null;
		SchemeMstVO vo=null;
		//SchemeMstBO bo=null;
		
		try 
		{
			vo=new SchemeMstVO();
			//bo=new SchemeMstBO();
			hisutil = new HisUtil("mms", "SchemeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			
			formBean_p.setStrCtDate(ctDate);
			
			vo.setStrCtDate(formBean_p.getStrCtDate());
			
			if (vo.getStrMsgType().equals("1"))
			{
				throw new Exception(vo.getStrMsgString());
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();

			strMsgText = "SchemeMst.SchemeMstDATA.initializeAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SchemeMstDATA->initializeAdd()", strMsgText);
			formBean_p.setStrErrMsg("Application Error [ERROR ID : "
					+ eObj.getErrorID() + "],Contact System Administrator! ");
		
		}
		finally 
		{
			hisutil = null;
			vo = null;
		}
	}
	
	
	
	
	
	/**
	 * to insert the data.
	 * 
	 * @param formBean_p the form bean
	 * @param request_p the request
	 */
	public static void insertRecord(SchemeMstFB formBean_p, HttpServletRequest request_p) {
		
		SchemeMstBO bo = null;
		SchemeMstVO vo = null;
		String strmsgText = "";
		
		
		try {
			vo=new SchemeMstVO();
			bo=new SchemeMstBO();
			
			String strHosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
			
			formBean_p.setStrHospitalCode(strHosCode);
			
			vo.setStrSeatId(strSeatId);
			vo.setStrHospitalCode(formBean_p.getStrHospitalCode());
			vo.setStrSchemeName(formBean_p.getStrSchemeName());
			vo.setStrEffectiveFrom(formBean_p.getStrEffectiveFrom());
			vo.setStrRemarks(formBean_p.getStrRemarks());
			vo.setStrCtDate(formBean_p.getStrCtDate());
			vo.setStrIsValid("1");
			
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

			strmsgText = "SchemeMst.SchemeMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SchemeMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(SchemeMstFB formBean_p, HttpServletRequest request_p) {
		// TODO Auto-generated method stub
		SchemeMstBO bo = null;
		SchemeMstVO vo = null;
		String strTemp[] = null;
		String strTemp2[] = null;
		String strmsgText = "";
		String strChk="";
		HisUtil hisutil=null;
		
		
		try {
			bo = new SchemeMstBO();
			vo = new SchemeMstVO();
			strChk = request_p.getParameter("chk");
			
			hisutil = new HisUtil("mms", "SchemeMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			
			

			if(strChk!=null && !strChk.trim().equals("")) {
				strTemp = strChk.replace("@", "#").split("#");
				strTemp2=strTemp[1].replace("$", "#").split("#");
				vo.setStrSchemeId(strTemp[0]);
				vo.setStrHospitalCode(strTemp2[0]);
				//vo.setStrChk(strTemp[0]);
			} 
            String strSchemeName = request_p.getParameter("strSchemeName");
            String strEffectiveFrom = request_p.getParameter("strEffectiveFrom");
            String strRemarks = request_p.getParameter("strRemarks");
            formBean_p.setStrCtDate(ctDate);
			
			vo.setStrCtDate(formBean_p.getStrCtDate());
			vo.setStrSchemeName(strSchemeName);
			vo.setStrEffectiveFrom(strEffectiveFrom);
			vo.setStrRemarks(strRemarks);
			vo.setStrIsValid(formBean_p.getStrIsValid());
			
			bo.modifyRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			formBean_p.setStrSchemeName(vo.getStrSchemeName());
			formBean_p.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean_p.setStrRemarks(vo.getStrRemarks());
			formBean_p.setStrSchemeId(vo.getStrSchemeId());
			formBean_p.setStrIsValid(vo.getStrIsValid());
		} 
		catch (Exception e) 
		{
			strmsgText = "SchemeMstDATA.modifyRecord(formBean_p,request_p) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms","SchemeMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(SchemeMstFB formBean_p,HttpServletRequest request_p) 
	{
		SchemeMstBO bo = null;
		SchemeMstVO vo = null;
		boolean bReturnValue = true;
		String strMsgText;
		
		
		try {
			bo = new SchemeMstBO();
			vo = new SchemeMstVO();
			
			String strHosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			////System.out.println("formBean_p.getStrSchemeId() "+formBean_p.getStrSchemeId());
            vo.setStrSchemeId(formBean_p.getStrSchemeId());
			vo.setStrSchemeName(formBean_p.getStrSchemeName());
			vo.setStrEffectiveFrom(formBean_p.getStrEffectiveFrom());
			vo.setStrRemarks(formBean_p.getStrRemarks());
			vo.setStrIsValid(formBean_p.getStrIsValid());
			vo.setStrHospitalCode(strHosCode);
			
			bo.updateRecord(vo);

				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				
				if (vo.getBExistStatus() == false) 
				{
					formBean_p.setStrWarningMsg("Scheme Name already exist !");
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
			strMsgText = "SchemeMstDATA.updateRecord(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms","SchemeMstDATA->updateRecord()", strMsgText);
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
