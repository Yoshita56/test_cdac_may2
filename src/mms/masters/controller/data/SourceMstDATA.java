package mms.masters.controller.data;


import hisglobal.exceptions.HisException;
import javax.servlet.http.HttpServletRequest;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.masters.bo.SourceMstBO;
import mms.masters.controller.fb.SourceMstFB;
import mms.masters.vo.SourceMstVO;


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
 * The Class SourceMstDATA.
 */

public class SourceMstDATA {
	
	
	/**
	 * to get the initial data for add page.
	 * 
	 * @param formBean_p the form bean
	 * @param request_p the request
	 */
	public static void initializeAdd(SourceMstFB formBean_p, HttpServletRequest request_p) 
	{
		
		String strMsgText;
		HisUtil hisutil = null;
		SourceMstVO vo=null;
		//SourceMstBO bo=null;
		
		try 
		{
			vo=new SourceMstVO();
			//bo=new SourceMstBO();
			hisutil = new HisUtil("mms", "SourceMstDATA");
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

			strMsgText = "SourceMst.SourceMstDATA.initializeAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SourceMstDATA->initializeAdd()", strMsgText);
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
	public static void insertRecord(SourceMstFB formBean_p, HttpServletRequest request_p) {
		
		SourceMstBO bo = null;
		SourceMstVO vo = null;
		String strmsgText = "";
		
		
		try {
			vo=new SourceMstVO();
			bo=new SourceMstBO();
			
			String strHosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
			strHosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			formBean_p.setStrHospitalCode(strHosCode);
			
			vo.setStrSeatId(strSeatId);
			vo.setStrHospitalCode(formBean_p.getStrHospitalCode());
			vo.setStrSourceName(formBean_p.getStrSourceName());
			vo.setStrEffectiveFrom(formBean_p.getStrEffectiveFrom());
			vo.setStrRemarks(formBean_p.getStrRemarks());
			vo.setStrCtDate(formBean_p.getStrCtDate());
			vo.setStrIsValid("1");
			vo.setStrSlNo("1");
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

			strmsgText = "SourceMst.SourceMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"SourceMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(SourceMstFB formBean_p, HttpServletRequest request_p) {
		// TODO Auto-generated method stub
		SourceMstBO bo = null;
		SourceMstVO vo = null;
		String strTemp[] = null;
		String strTemp2[] = null;
		String strmsgText = "";
		String strChk="";
		HisUtil hisutil=null;
		
		
		try {
			bo = new SourceMstBO();
			vo = new SourceMstVO();
			strChk = request_p.getParameter("chk");
			
			hisutil = new HisUtil("mms", "SourceMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			
//			100@100@1$1

			if(strChk!=null && !strChk.trim().equals("")) {
				strTemp = strChk.replace("@", "#").split("#");
				strTemp2=strTemp[2].replace("$", "#").split("#");
				strTemp[2]	=	strTemp2[0];	
				vo.setStrSourceId(strTemp[0]);
				vo.setStrHospitalCode(strTemp[1]);
				vo.setStrSlNo(strTemp[2]);
				//vo.setStrChk(strTemp[0]);
			} 
            String strSourceName = request_p.getParameter("strSourceName");
            String strEffectiveFrom = request_p.getParameter("strEffectiveFrom");
            String strRemarks = request_p.getParameter("strRemarks");
            
            formBean_p.setStrCtDate(ctDate);
			
			vo.setStrCtDate(formBean_p.getStrCtDate());
			vo.setStrSourceName(strSourceName);
			vo.setStrEffectiveFrom(strEffectiveFrom);
			vo.setStrRemarks(strRemarks);
			vo.setStrIsValid(formBean_p.getStrIsValid());
			
			bo.modifyRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			
			formBean_p.setStrSourceName(vo.getStrSourceName());
			formBean_p.setStrEffectiveFrom(vo.getStrEffectiveFrom());
			formBean_p.setStrRemarks(vo.getStrRemarks());
			formBean_p.setStrSourceId(vo.getStrSourceId());
			formBean_p.setStrIsValid(vo.getStrIsValid());
		} 
		catch (Exception e) 
		{
			strmsgText = "SourceMstDATA.modifyRecord(formBean_p,request_p) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms","SourceMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(SourceMstFB formBean_p,HttpServletRequest request_p) 
	{
		SourceMstBO bo = null;
		SourceMstVO vo = null;
		boolean bReturnValue = true;
		String strMsgText;
		String strTemp[] = null;
		String strTemp2[] = null;
		String strmsgText = "";
		String strChk="";
		HisUtil hisutil=null;		
		
		try {
			bo = new SourceMstBO();
			vo = new SourceMstVO();

//			100@100@1$1
			
			strChk = request_p.getParameter("chk");
			
			hisutil = new HisUtil("mms", "SourceMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			
//			100@100@1$1

			if(strChk!=null && !strChk.trim().equals("")) {
				strTemp = strChk.replace("@", "#").split("#");
				strTemp2=strTemp[2].replace("$", "#").split("#");
				strTemp[2]	=	strTemp2[0];	
				vo.setStrSourceId(strTemp[0]);
				vo.setStrHospitalCode(strTemp[1]);
				vo.setStrSlNo(strTemp[2]);
				//vo.setStrChk(strTemp[0]);
			} 
			
			
			////System.out.println("formBean_p.getStrSourceId() "+formBean_p.getStrSourceId());
//            vo.setStrSourceId(formBean_p.getStrSourceId());
			vo.setStrSourceName(formBean_p.getStrSourceName());
			vo.setStrEffectiveFrom(formBean_p.getStrEffectiveFrom());
			vo.setStrRemarks(formBean_p.getStrRemarks());
			vo.setStrIsValid(formBean_p.getStrIsValid());
			
			
			bo.updateRecord(vo);

				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				
				if (vo.getBExistStatus() == false) 
				{
					formBean_p.setStrWarningMsg("Source Name already exist !");
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
			strMsgText = "SourceMstDATA.updateRecord(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms","SourceMstDATA->updateRecord()", strMsgText);
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
	