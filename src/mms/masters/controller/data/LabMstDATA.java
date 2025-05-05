package mms.masters.controller.data;


import hisglobal.exceptions.HisException;
import javax.servlet.http.HttpServletRequest;
import hisglobal.utility.HisUtil;
import mms.MmsConfigUtil;
import mms.masters.bo.LabMstBO;
import mms.masters.controller.fb.LabMstFB;
import mms.masters.vo.LabMstVO;


/**
 * @author:-	Adil Wasi   
 * Creation Date:- 7-Jan-2012 
 * Modifying Date:- 
 * Used For:-	
 * Team Lead By:-	
 *  Module:- DWH(HIS Project)
 * 
 */



/**
 * The Class LabMstDATA.
 */

public class LabMstDATA {
	
	
	/**
	 * to get the initial data for add page.
	 * 
	 * @param formBean_p the form bean
	 * @param request_p the request
	 */
	public static void initializeAdd(LabMstFB formBean_p, HttpServletRequest request_p) 
	{
		
		String strMsgText;
		HisUtil hisutil = null;
		LabMstVO vo=null;
		
		try 
		{
			vo=new LabMstVO();
			hisutil = new HisUtil("mms", "LabMstDATA");
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

			strMsgText = "LabMst.LabMstDATA.initializeAdd(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LabMstDATA->initializeAdd()", strMsgText);
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
	public static void insertRecord(LabMstFB formBean_p, HttpServletRequest request_p) {
		
		LabMstBO bo = null;
		LabMstVO vo = null;
		String strmsgText = "";
		
		
		try {
			vo=new LabMstVO();
			bo=new LabMstBO();
			
			String strHosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
				strHosCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
			String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
			
			formBean_p.setStrHospitalCode(strHosCode);
			
			vo.setStrSeatId(strSeatId);
			vo.setStrHospitalCode(formBean_p.getStrHospitalCode());
			vo.setStrLabUserNo(formBean_p.getStrLabUserNo());
			vo.setStrLabName(formBean_p.getStrLabName());
			vo.setStrLabType(formBean_p.getStrLabType());
			vo.setStrPhoneNo(formBean_p.getStrPhoneNo());
			vo.setStrFaxNo(formBean_p.getStrFaxNo());
			vo.setStrAddress(formBean_p.getStrAddress());
			vo.setStrIsValid(formBean_p.getStrIsValid());
			vo.setStrCtDate(formBean_p.getStrCtDate());
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

			strmsgText = "LabMst.LabMstDATA.insertRecord(vo) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms",
					"LabMstDATA->insertRecord()", strmsgText);
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
	public static void modifyRecord(LabMstFB formBean_p, HttpServletRequest request_p) {
		// TODO Auto-generated method stub
		LabMstBO bo = null;
		LabMstVO vo = null;
		String strTemp[] = null;
		String strTemp2[] = null;
		String strmsgText = "";
		String strChk="";
		HisUtil hisutil=null;
		
		
		try {
			bo = new LabMstBO();
			vo = new LabMstVO();
//			1001@100@1$1
			strChk = request_p.getParameter("chk");
//			//System.out.println("strChk :"+strChk);
			hisutil = new HisUtil("mms", "LabMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			
			

			if(strChk!=null && !strChk.trim().equals("")) {
				strTemp = strChk.replace("@", "#").split("#");
				strTemp2=strTemp[2].replace("$", "#").split("#");
				strTemp[2] = strTemp2[0];
				
				vo.setStrLabNo(strTemp[0]);
				vo.setStrHospitalCode(strTemp[1]);
				vo.setStrSlNo(strTemp[2]);
				
				//vo.setStrChk(strTemp[0]);
				formBean_p.setStrChk(strChk);
			} 
            
			
			bo.modifyRecord(vo);
			
			if (vo.getStrMsgType().equals("1")) {
				throw new Exception(vo.getStrMsgString());
			}
			formBean_p.setStrLabNo(vo.getStrLabNo());
			formBean_p.setStrHospitalCode(vo.getStrHospitalCode());
			formBean_p.setStrLabName(vo.getStrLabName());
			formBean_p.setStrLabUserNo(vo.getStrLabUserNo());
			formBean_p.setStrPhoneNo(vo.getStrPhoneNo());
			formBean_p.setStrFaxNo(vo.getStrFaxNo());
			formBean_p.setStrAddress(vo.getStrAddress());
			formBean_p.setStrLabType(vo.getStrLabType());
			formBean_p.setStrIsValid(vo.getStrIsValid());
		} 
		catch (Exception e) 
		{
			strmsgText = "LabMstDATA.modifyRecord(formBean_p,request_p) --> "
					+ e.getMessage();
			HisException eObj = new HisException("mms","LabMstDATA->modifyRecord()", strmsgText);
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
	public static boolean updateRecord(LabMstFB formBean_p,HttpServletRequest request_p) 
	{
		LabMstBO bo = null;
		LabMstVO vo = null;
		boolean bReturnValue = true;
		String strMsgText;
		String strTemp[] = null;
		String strTemp2[] = null;
		String strmsgText = "";
		String strChk="";
		HisUtil hisutil=null;
		
		try {
			bo = new LabMstBO();
			vo = new LabMstVO();
			
			strChk = request_p.getParameter("chk");
//			//System.out.println("strChk :"+strChk);
			hisutil = new HisUtil("mms", "LabMstDATA");
			String ctDate = hisutil.getASDate("dd-MMM-yyyy");
			
			strChk = request_p.getParameter("chk");

			if(strChk!=null && !strChk.trim().equals("")) {
				strTemp = strChk.replace("@", "#").split("#");
				strTemp2=strTemp[2].replace("$", "#").split("#");
				strTemp[2] = strTemp2[0];
				
				vo.setStrLabNo(strTemp[0]);
				vo.setStrHospitalCode(strTemp[1]);
				vo.setStrSlNo(strTemp[2]);
				
				//vo.setStrChk(strTemp[0]);
			} 
            
			
			
			String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
//			vo.setStrLabNo(formBean_p.getStrLabNo());
			vo.setStrLabName(formBean_p.getStrLabName());
			vo.setStrLabUserNo(formBean_p.getStrLabUserNo());
			vo.setStrLabType(formBean_p.getStrLabType());
			vo.setStrPhoneNo(formBean_p.getStrPhoneNo());
			vo.setStrFaxNo(formBean_p.getStrFaxNo());
			vo.setStrAddress(formBean_p.getStrAddress());
			vo.setStrIsValid(formBean_p.getStrIsValid());
			vo.setStrSeatId(strSeatId);
			vo.setStrLastModifiedSeatId(strSeatId);
			
			bo.updateRecord(vo);

				if (vo.getStrMsgType().equals("1")) 
				{
					throw new Exception(vo.getStrMsgString());
				}
				
				if (vo.getBExistStatus() == false) 
				{
					formBean_p.setStrWarningMsg("Lab Name already exist !");
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
			strMsgText = "LabMstDATA.updateRecord(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms","LabMstDATA->updateRecord()", strMsgText);
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
	