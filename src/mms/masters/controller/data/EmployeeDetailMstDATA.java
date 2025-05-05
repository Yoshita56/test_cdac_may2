package mms.masters.controller.data;

import java.sql.SQLException;

import hisglobal.exceptions.HisException;
import hisglobal.utility.HisUtil;

import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.WebRowSet;

import mms.MmsConfigUtil;
import mms.masters.bo.EmployeeDetailMstBO;
import mms.masters.controller.fb.EmployeeDetailMstFB;
import mms.masters.vo.EmployeeDependentDtlVO;
import mms.masters.vo.EmployeeDetailMstVO;

public class EmployeeDetailMstDATA
{
	/**
	 * To initialize Add Page.
	 * 
	 * @param formBean the Employee Detail Master FormBean
	 * @param request the HttpServletRequest
	 */
	public static void initializeAdd(EmployeeDetailMstFB employeeDetailMstFB_p, HttpServletRequest request_p) 
	{
		
		String strMsgText;
		HisUtil hisutil = null;
		
		EmployeeDetailMstBO bo = null;
		EmployeeDetailMstVO []vo = null;
		String strSalutationValues,strDesignationValues,strRelationship;
		String strCurrentDate;
		MmsConfigUtil mcu = null;

		try 
		{
			hisutil = new HisUtil("mms", "EmployeeDetailMstDATA");
			mcu = new MmsConfigUtil(employeeDetailMstFB_p.getStrHospitalCode());
			
			vo = new EmployeeDetailMstVO[3];
			
			vo[0] = new EmployeeDetailMstVO();
			vo[1] = new EmployeeDetailMstVO();
			vo[2] = new EmployeeDetailMstVO();
			
			bo = new EmployeeDetailMstBO();
			
			String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
			String strSeatId = request_p.getSession().getAttribute("SEATID").toString();;
			
			
			//vo.setStrCountryCode(employeeDetailMstFB_p.getStrCountryCode());
			vo[0].setStrHospitalCode(strHospitalCode);// Salutation Combo
			vo[1].setStrHospitalCode(strHospitalCode);// Designation Combo
			vo[2].setStrHospitalCode(strHospitalCode);// RelationShip Combo
			
			strCurrentDate=hisutil.getASDate("dd-MMM-yyyy");
			employeeDetailMstFB_p.setStrCurrentDate(strCurrentDate);
			
			vo[0].setStrCountryCode(mcu.getStrCountryCode());
			vo[0].setStrStateCode(mcu.getStrStateCode());
			vo[0].setStrSeatId(strSeatId);
			
			vo[0].setStrDistrictId((employeeDetailMstFB_p.getStrDistrictId()==null||employeeDetailMstFB_p.getStrDistrictId().equals(""))?"0":employeeDetailMstFB_p.getStrDistrictId());
			// Calling BO object
			bo.initializeAdd(vo);
			
			//Salutation Combo
			if (vo[0].getStrMsgType().equals("1"))
			{
				throw new Exception(vo[0].getStrMsgString());
			}
			
			if (vo[0].getWrsData() != null && vo[0].getWrsData().size() > 0) 
			{
				if(employeeDetailMstFB_p.getStrSalutationId()!=null)
				{
					strSalutationValues = hisutil.getOptionValue(vo[0].getWrsData(),employeeDetailMstFB_p.getStrSalutationId(),"0^Select Value", false);
				}
				
				else
					strSalutationValues = hisutil.getOptionValue(vo[0].getWrsData(),"","0^Select Value", false);
			}
			else
			{
				strSalutationValues = "<option value='0'>Select Value</option>";
			}
			employeeDetailMstFB_p.setStrSalutationValues(strSalutationValues);
			
			employeeDetailMstFB_p.setStrDistrictNameCombo(vo[0].getStrDistrictNameCombo());
			
			
			//Designation Combo
			if (vo[1].getStrMsgType().equals("1"))
			{
				throw new Exception(vo[1].getStrMsgString());
			}
			
			if (vo[1].getWrsData() != null && vo[1].getWrsData().size() > 0) 
			{
				if(employeeDetailMstFB_p.getStrDesigId()!=null)
				{
					strDesignationValues = hisutil.getOptionValue(vo[1].getWrsData(),employeeDetailMstFB_p.getStrDesigId(),"0^Select Value", false);
				}
				else
				strDesignationValues = hisutil.getOptionValue(vo[1].getWrsData(),"","0^Select Value", false);
			}
			else
			{
				strDesignationValues = "<option value='0'>Select Value</option>";
			}
			employeeDetailMstFB_p.setStrDesignationValues(strDesignationValues);
			
			

			//RelationShip Combo
			if (vo[2].getStrMsgType().equals("1"))
			{
				throw new Exception(vo[2].getStrMsgString());
			}
			
			if (vo[2].getWrsData() != null && vo[2].getWrsData().size() > 0) 
			{
				strRelationship = hisutil.getOptionValue(vo[2].getWrsData(),"","0^Select Value", false);
			}
			else
			{
				strRelationship = "<option value='0'>Select Value</option>";
			}
			employeeDetailMstFB_p.setStrRelationship(strRelationship);
			
		}	
		catch (Exception e) 
		{
			strMsgText = "EmployeeDetailMstDATA.initializeAdd(vo) --> " + e.getMessage();
			HisException eObj = new HisException("mms","EmployeeDetailMstDATA.initializeAdd(employeeDetailMstFB_p,request_p)", strMsgText);
			employeeDetailMstFB_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");
		
		eObj = null;
		}
	}
	
	
		/**
		 * To get Salutation Combo populated.
		 * 
		 * @param formBean the Employee Master form bean
		 * @param request the HttpServletRequest
		 * @param response the HttpServletResponse
		 */
		/*public static void getSalutationCombo(EmployeeDetailMstFB employeeDetailMstFB_p,HttpServletRequest request_p, HttpServletResponse response_p) 
		{
			String strMsgText = "";
			HisUtil hisutil = null;
			EmployeeDetailMstBO bo = null;
			EmployeeDetailMstVO vo = null;
			
			String strGenderCode = "";
			String strSalutationValues = "";
			
			try 
			{
				hisutil = new HisUtil("bmed", "EmployeeDetailMstDATA");
				
				vo = new EmployeeDetailMstVO();
				bo = new EmployeeDetailMstBO();
				
				String hosCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
		
				strGenderCode = request_p.getParameter("genderCode");
				vo.setStrHospitalCode(hosCode);
				
				vo.setStrGenderCode(strGenderCode);

				// Calling BO
				//bo.getSalutationCombo(vo);
				
				if (vo.getStrMsgType().equals("1")) {
					throw new Exception(vo.getStrMsgString());
				}
				
				if (vo.getWrsData() != null && vo.getWrsData().size() > 0) 
				{
					strSalutationValues = hisutil.getOptionValue(vo.getWrsData(),"","0^Select Value", false);
				}
				
				else
				{
					strSalutationValues = "<option value='0'>Select Value</option>";
				}
				
				response_p.setHeader("Cache-Control", "no-cache");
				response_p.getWriter().print(strSalutationValues);
				
			} 
			catch (Exception e) 
			{
				strMsgText = "EmployeeDetailMstDATA.getEnggItemSubTypeCmb(vo) --> " + e.getMessage();
			HisException eObj = new HisException("bmed", "EmployeeDetailMstDATA.getEnggItemSubTypeCmb()", strMsgText);
			
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
					new HisException("bmed","EmployeeDetailMstDATA.getEnggItemSubTypeCmb()", strMsgText);
				}

			eObj = null;
			} 
			finally
			{
				hisutil = null;
				vo = null;
				bo = null;
			}

		}*/

		/**
		 * To Save Data 
		 * 
		 * @param employeeDetailMstFB_p	the form bean
		 * @param request_p	the request
		 */
		public static void insertRecord(EmployeeDetailMstFB employeeDetailMstFB_p,	HttpServletRequest request_p) {
			EmployeeDetailMstBO bo = null;
			EmployeeDetailMstVO empPersonalDetailVO = null;
			EmployeeDependentDtlVO empDependentDetailVO = null;
			
			
			String strMsgText = "";

			try {
				String strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();
				String strSeatId = request_p.getSession().getAttribute("SEATID").toString();
								
				
				bo = new EmployeeDetailMstBO();
				
				empPersonalDetailVO = new EmployeeDetailMstVO();
				empDependentDetailVO = new EmployeeDependentDtlVO();
				
				
			
				empPersonalDetailVO.setStrMode("1");
				empPersonalDetailVO.setStrEmpCode(employeeDetailMstFB_p.getStrEmpCode());	
				empPersonalDetailVO.setStrGenderCode(employeeDetailMstFB_p.getStrGenderCode());
				empPersonalDetailVO.setStrSalutationId(employeeDetailMstFB_p.getStrSalutationId());
				
				
				empPersonalDetailVO.setStrFirstName(employeeDetailMstFB_p.getStrFirstName());
				empPersonalDetailVO.setStrMiddleName(employeeDetailMstFB_p.getStrMiddleName());
				empPersonalDetailVO.setStrLastName(employeeDetailMstFB_p.getStrLastName());
				empPersonalDetailVO.setStrFatherName(employeeDetailMstFB_p.getStrFatherName());
				empPersonalDetailVO.setStrMotherName(employeeDetailMstFB_p.getStrMotherName());
				empPersonalDetailVO.setStrSpouseName(employeeDetailMstFB_p.getStrSpouseName());
				empPersonalDetailVO.setStrBirthDate(employeeDetailMstFB_p.getStrBirthDate());
				empPersonalDetailVO.setStrDesigId(employeeDetailMstFB_p.getStrDesigId());
				empPersonalDetailVO.setStrJoiningDate(employeeDetailMstFB_p.getStrJoiningDate());
				empPersonalDetailVO.setStrPermanentAddress(employeeDetailMstFB_p.getStrPermanentAddress());
				empPersonalDetailVO.setStrLocalAddress(employeeDetailMstFB_p.getStrLocalAddress());
				empPersonalDetailVO.setStrPhoneNo(employeeDetailMstFB_p.getStrPhoneNo());
				empPersonalDetailVO.setStrMobileNo(employeeDetailMstFB_p.getStrMobileNo());
				empPersonalDetailVO.setStrFaxNo(employeeDetailMstFB_p.getStrFaxNo());
				empPersonalDetailVO.setStrEmailId(employeeDetailMstFB_p.getStrEmailId());
				empPersonalDetailVO.setStrDistrictId(employeeDetailMstFB_p.getStrDistrictId());
				
				
									
					empDependentDetailVO.setStrMode("1");
					empDependentDetailVO.setStrDependentName(employeeDetailMstFB_p.getStrDependentName());
					empDependentDetailVO.setStrAge(employeeDetailMstFB_p.getStrAge());
					empDependentDetailVO.setStrRelationshipId(employeeDetailMstFB_p.getStrRelationshipId());
					empDependentDetailVO.setStrSlNo(employeeDetailMstFB_p.getStrSlNo());				
					empDependentDetailVO.setStrHospitalCode(strHospitalCode);
					empDependentDetailVO.setStrIsValid("1");
					empDependentDetailVO.setStrSeatId(strSeatId);
				
				
				
				//Other Details
				empPersonalDetailVO.setStrServiceDocNo(employeeDetailMstFB_p.getStrServiceDocNo());
				empPersonalDetailVO.setStrServiceDocDate(employeeDetailMstFB_p.getStrServiceDocDate());
				empPersonalDetailVO.setStrRemarks(employeeDetailMstFB_p.getStrRemarks());
				
				
				empPersonalDetailVO.setStrHospitalCode(strHospitalCode);	//from session
				empPersonalDetailVO.setStrSeatId(strSeatId);	//from session
				empPersonalDetailVO.setStrIsValid("1");

				
				bo.insertRecord(empPersonalDetailVO,empDependentDetailVO);
				
				if (empPersonalDetailVO.getStrMsgType().equals("1")) {
					throw new Exception(empPersonalDetailVO.getStrMsgString());
				}

				if (empPersonalDetailVO.isBExistStatus() == false) {
					employeeDetailMstFB_p.setStrWarningMsg("Employee Code \"" +employeeDetailMstFB_p.getStrEmpCode() + "\" already exist !");
				}
				else {
					employeeDetailMstFB_p.setStrNormalMsg("Record Saved Successfully!");
				}

			}
			catch (Exception e) 
			{

				//e.printStackTrace();
				
				strMsgText = "EmployeeDetailMstDATA.insertRecord(empPersonalDetailVO) --> "	+ e.getMessage();
				HisException eObj = new HisException("mms", "EmployeeDetailMstDATA->insertRecord()", strMsgText);
				employeeDetailMstFB_p.setStrErrMsg("Application Error [ERROR ID : "
						+ eObj.getErrorID() + "],Contact System Administrator! ");

				eObj = null;
			}
			finally 
			{
				bo = null;
				empPersonalDetailVO = null;
			}			
		}

		
		/**
		 * To get Data for Modify Page 
		 * 
		 * @param employeeDetailMstFB_p	the form bean
		 * @param request_p	the request
		 */
		public static void modifyRecord(EmployeeDetailMstFB employeeDetailMstFB_p,	HttpServletRequest request_p) {
			
			EmployeeDetailMstBO bo = null;
			EmployeeDetailMstVO employeeDetailMstVO = null;
			EmployeeDependentDtlVO empDependentDetailVO = null;

			String strEnteredDependentDetailsTable;
			
			String strTemp[] = null;
			String strTemp2[] = null;
			String strMsgText = "";
			String strChk = "";

			
			try {
				bo = new EmployeeDetailMstBO();
				employeeDetailMstVO = new EmployeeDetailMstVO();
				 empDependentDetailVO = new EmployeeDependentDtlVO();

				strChk = request_p.getParameter("chk");
				
				
				//chk value::		RAOL1000000001@999$1
	            // Primary Key::	STR_EMP_NO@GNUM_HOSPITAL_CODE

				if(strChk!=null && !strChk.trim().equals("")) {
					
					strTemp = strChk.replace('@', '#').split("#");
					strTemp2 = strTemp[1].replace("$", "#").split("#");

					employeeDetailMstVO.setStrEmpNo(strTemp[0]);
					employeeDetailMstVO.setStrHospitalCode(strTemp2[0]);
					
					
					empDependentDetailVO.setStrEmpNo(strTemp[0]);
					empDependentDetailVO.setStrHospitalCode(strTemp2[0]);
				} 


				bo.modifyRecord(employeeDetailMstVO,empDependentDetailVO);
				
				/*while(empDependentDetailVO.getWrsData().next())
				{
					employeeDetailMstFB_p.setStrDeleteCheckbox(empDependentDetailVO.getWrsData().getString("STR_DELETE_CHECKBOX")));
				}*/
				
				
				if (employeeDetailMstVO.getStrMsgType().equals("1")) {
					throw new Exception(employeeDetailMstVO.getStrMsgString());
				}
				
				strEnteredDependentDetailsTable	=	getEnteredDependentDetailsTable(empDependentDetailVO.getWrsData(),"WITH_DELETE_CHECKBOX");
				
				
				employeeDetailMstFB_p.setStrEmpCode(employeeDetailMstVO.getStrEmpCode());	
				employeeDetailMstFB_p.setStrGenderCode(employeeDetailMstVO.getStrGenderCode());
				employeeDetailMstFB_p.setStrSalutationId(employeeDetailMstVO.getStrSalutationId());
				
				
				employeeDetailMstFB_p.setStrFirstName(employeeDetailMstVO.getStrFirstName());
				employeeDetailMstFB_p.setStrMiddleName(employeeDetailMstVO.getStrMiddleName());
				employeeDetailMstFB_p.setStrLastName(employeeDetailMstVO.getStrLastName());
				employeeDetailMstFB_p.setStrFatherName(employeeDetailMstVO.getStrFatherName());
				employeeDetailMstFB_p.setStrMotherName(employeeDetailMstVO.getStrMotherName());
				employeeDetailMstFB_p.setStrSpouseName(employeeDetailMstVO.getStrSpouseName());
				employeeDetailMstFB_p.setStrBirthDate(employeeDetailMstVO.getStrBirthDate());
				employeeDetailMstFB_p.setStrDesigId(employeeDetailMstVO.getStrDesigId());
				employeeDetailMstFB_p.setStrJoiningDate(employeeDetailMstVO.getStrJoiningDate());
				employeeDetailMstFB_p.setStrPermanentAddress(employeeDetailMstVO.getStrPermanentAddress());
				employeeDetailMstFB_p.setStrLocalAddress(employeeDetailMstVO.getStrLocalAddress());
				employeeDetailMstFB_p.setStrPhoneNo(employeeDetailMstVO.getStrPhoneNo());
				employeeDetailMstFB_p.setStrMobileNo(employeeDetailMstVO.getStrMobileNo());
				employeeDetailMstFB_p.setStrFaxNo(employeeDetailMstVO.getStrFaxNo());
				
				
				employeeDetailMstFB_p.setStrServiceDocNo(employeeDetailMstVO.getStrServiceDocNo());
				employeeDetailMstFB_p.setStrServiceDocDate(employeeDetailMstVO.getStrServiceDocDate());
				employeeDetailMstFB_p.setStrRemarks(employeeDetailMstVO.getStrRemarks());
				employeeDetailMstFB_p.setStrIsValid(employeeDetailMstVO.getStrIsValid());
				
				employeeDetailMstFB_p.setStrEmailId(employeeDetailMstVO.getStrEmailId());
				employeeDetailMstFB_p.setStrDistrictId(employeeDetailMstVO.getStrDistrictId());
				
				
				
				employeeDetailMstFB_p.setStrEnteredDependentDetailsTable(strEnteredDependentDetailsTable);
				
			} 
			catch (Exception e) 
			{
				strMsgText = "EmployeeDetailMstDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
				HisException eObj = new HisException("mms","EmployeeDetailMstDATA->modifyRecord()", strMsgText);
				employeeDetailMstFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

				eObj = null;
			}
			finally 
			{
				bo = null;
				employeeDetailMstVO = null;
			}

		}

	
	
		/**
		 * to update the record after modifying it.
		 * 
		 * @param employeeDetailMstFB_p the form bean
		 * @param request_p the request
		 * 
		 * @return true, if update record
		 */
		public static boolean updateRecord(EmployeeDetailMstFB employeeDetailMstFB_p,HttpServletRequest request_p)
		{
			EmployeeDetailMstBO bo = null;
			
			EmployeeDetailMstVO empPersonalDetailVO = null;
			EmployeeDependentDtlVO empDependentDetailVO = null;
			
			EmployeeDependentDtlVO deleteEmpDependentDetailVO = null;

			boolean bReturnValue = true;
			String strTemp[] = null;
			String strTemp2[] = null;
			String strMsgText;
			String strChk = "";
			String strSeatId; 
			String strHospitalCode;
			
			try {
				bo = new EmployeeDetailMstBO();
				empPersonalDetailVO = new EmployeeDetailMstVO();
				empDependentDetailVO = new EmployeeDependentDtlVO();

				strHospitalCode = request_p.getSession().getAttribute("HOSPITAL_CODE").toString();

				strSeatId = request_p.getSession().getAttribute("SEATID").toString();

				
	            strChk = request_p.getParameter("chk");

	          //chk value::		RAOL1000000001@999$1
	            // Primary Key::	STR_EMP_NO@GNUM_HOSPITAL_CODE
	            
				if(strChk!=null && !strChk.trim().equals("")) {
					
					strTemp = strChk.replace('@', '#').split("#");
					strTemp2 = strTemp[1].replace("$", "#").split("#");
				
					empPersonalDetailVO.setStrEmpNo(strTemp[0]);
					empPersonalDetailVO.setStrHospitalCode(strTemp2[0]);
					
				} 
				
				empPersonalDetailVO.setStrMode("2");
				
				empPersonalDetailVO.setStrEmpCode(employeeDetailMstFB_p.getStrEmpCode());	
				empPersonalDetailVO.setStrGenderCode(employeeDetailMstFB_p.getStrGenderCode());
				empPersonalDetailVO.setStrSalutationId(employeeDetailMstFB_p.getStrSalutationId());
				
				
				empPersonalDetailVO.setStrFirstName(employeeDetailMstFB_p.getStrFirstName());
				empPersonalDetailVO.setStrMiddleName(employeeDetailMstFB_p.getStrMiddleName());
				empPersonalDetailVO.setStrLastName(employeeDetailMstFB_p.getStrLastName());
				empPersonalDetailVO.setStrFatherName(employeeDetailMstFB_p.getStrFatherName());
				empPersonalDetailVO.setStrMotherName(employeeDetailMstFB_p.getStrMotherName());
				empPersonalDetailVO.setStrSpouseName(employeeDetailMstFB_p.getStrSpouseName());
				empPersonalDetailVO.setStrBirthDate(employeeDetailMstFB_p.getStrBirthDate());
				empPersonalDetailVO.setStrDesigId(employeeDetailMstFB_p.getStrDesigId());
				empPersonalDetailVO.setStrJoiningDate(employeeDetailMstFB_p.getStrJoiningDate());
				empPersonalDetailVO.setStrPermanentAddress(employeeDetailMstFB_p.getStrPermanentAddress());
				empPersonalDetailVO.setStrLocalAddress(employeeDetailMstFB_p.getStrLocalAddress());
				empPersonalDetailVO.setStrPhoneNo(employeeDetailMstFB_p.getStrPhoneNo());
				empPersonalDetailVO.setStrMobileNo(employeeDetailMstFB_p.getStrMobileNo());
				empPersonalDetailVO.setStrFaxNo(employeeDetailMstFB_p.getStrFaxNo());
				empPersonalDetailVO.setStrEmailId(employeeDetailMstFB_p.getStrEmailId());
				empPersonalDetailVO.setStrDistrictId(employeeDetailMstFB_p.getStrDistrictId());
				
				// Dependent details
				empDependentDetailVO.setStrMode("1");
				empDependentDetailVO.setStrEmpNo(strTemp[0]);
				empDependentDetailVO.setStrDependentName(employeeDetailMstFB_p.getStrDependentName());
				empDependentDetailVO.setStrAge(employeeDetailMstFB_p.getStrAge());
				empDependentDetailVO.setStrRelationshipId(employeeDetailMstFB_p.getStrRelationshipId());
				empDependentDetailVO.setStrSlNo(employeeDetailMstFB_p.getStrSlNo());				
				empDependentDetailVO.setStrHospitalCode(strHospitalCode);
				empDependentDetailVO.setStrIsValid("1");
				empDependentDetailVO.setStrSeatId(strSeatId);
				
				
				if(employeeDetailMstFB_p.getStrDeleteCheckbox()!=null && employeeDetailMstFB_p.getStrDeleteCheckbox().length>0)
				{
					deleteEmpDependentDetailVO = new EmployeeDependentDtlVO();
					
					deleteEmpDependentDetailVO.setStrMode("2");
					deleteEmpDependentDetailVO.setStrEmpNo(employeeDetailMstFB_p.getStrDeleteCheckbox()[0].split("\\^")[0]);
					deleteEmpDependentDetailVO.setStrHospitalCode(strHospitalCode);
					deleteEmpDependentDetailVO.setStrLstModSeatId(strSeatId);
					deleteEmpDependentDetailVO.setStrLstModDate("");
					deleteEmpDependentDetailVO.setStrIsValid("2");
					
					String strTempSlNo[]=new String[employeeDetailMstFB_p.getStrDeleteCheckbox().length];

					for(int j=0;j<employeeDetailMstFB_p.getStrDeleteCheckbox().length;j++)
					{
						if(!employeeDetailMstFB_p.getStrDeleteCheckbox()[j].equals("0"))
						{
							strTempSlNo[j]=employeeDetailMstFB_p.getStrDeleteCheckbox()[j].split("\\^")[1];
						}
						else
						{
							strTempSlNo[j]="0";
						}
					}
						
						deleteEmpDependentDetailVO.setStrSlNo(strTempSlNo);
						
						
						deleteEmpDependentDetailVO.setStrDependentName(strTempSlNo);
						deleteEmpDependentDetailVO.setStrAge(strTempSlNo);
						deleteEmpDependentDetailVO.setStrRelationshipId(strTempSlNo);
					
				}
				
				// Other Details
				empPersonalDetailVO.setStrServiceDocNo(employeeDetailMstFB_p.getStrServiceDocNo());
				empPersonalDetailVO.setStrServiceDocDate(employeeDetailMstFB_p.getStrServiceDocDate());
				empPersonalDetailVO.setStrRemarks(employeeDetailMstFB_p.getStrRemarks());
				
				
				empPersonalDetailVO.setStrLstModSeatId(strSeatId);	//from session
				empPersonalDetailVO.setStrIsValid(employeeDetailMstFB_p.getStrIsValid());
				
				
				bo.updateRecord(empPersonalDetailVO,empDependentDetailVO,deleteEmpDependentDetailVO);
				


					if (empPersonalDetailVO.getStrMsgType().equals("1")) 
					{
						throw new Exception(empPersonalDetailVO.getStrMsgString());
					}
					
					if (empPersonalDetailVO.isBExistStatus() == false) 
					{
						employeeDetailMstFB_p.setStrWarningMsg("Employee Code \"" +employeeDetailMstFB_p.getStrEmpCode() + "\" already exist !");
						bReturnValue = false;

					}
					else 
					{
						employeeDetailMstFB_p.setStrNormalMsg("Record Modified Successfully");
					}
				} 
				catch (Exception e) 
				{
				bReturnValue = false;
				strMsgText = "EmployeeDetailMstDATA.updateRecord(empPersonalDetailVO) --> " + e.getMessage();
				HisException eObj = new HisException("mms","EmployeeDetailMstDATA->updateRecord()", strMsgText);
				employeeDetailMstFB_p.setStrErrMsg("Application Error [ERROR ID : " + eObj.getErrorID() + "],Contact System Administrator! ");

				eObj = null;
				} 
				finally 
				{
				bo = null;
				empPersonalDetailVO = null;
				}
					
				return bReturnValue;
		}
		
		
		/**
		 * To get Data for View Page 
		 * 
		 * @param employeeDetailMstFB_p	the form bean
		 * @param request_p	the request
		 */
		public static void viewRecord(EmployeeDetailMstFB employeeDetailMstFB_p,	HttpServletRequest request_p) {
			
			EmployeeDetailMstBO bo = null;
			EmployeeDetailMstVO employeeDetailMstVO = null;
			EmployeeDependentDtlVO empDependentDetailVO = null;

			String strEnteredDependentDetailsTable;
			
			String strTemp[] = null;
			String strTemp2[] = null;
			String strMsgText = "";
			String strChk = "";

			
			try {
				bo = new EmployeeDetailMstBO();
				employeeDetailMstVO = new EmployeeDetailMstVO();
				 empDependentDetailVO = new EmployeeDependentDtlVO();

				strChk = request_p.getParameter("chk");
				
				
				//chk value::		RAOL1000000001@999$1
	            // Primary Key::	STR_EMP_NO@GNUM_HOSPITAL_CODE

				if(strChk!=null && !strChk.trim().equals("")) {
					
					strTemp = strChk.replace('@', '#').split("#");
					strTemp2 = strTemp[1].replace("$", "#").split("#");

					employeeDetailMstVO.setStrEmpNo(strTemp[0]);
					employeeDetailMstVO.setStrHospitalCode(strTemp2[0]);
					
					
					empDependentDetailVO.setStrEmpNo(strTemp[0]);
					empDependentDetailVO.setStrHospitalCode(strTemp2[0]);
				} 


				bo.viewRecord(employeeDetailMstVO,empDependentDetailVO);
				
				/*while(empDependentDetailVO.getWrsData().next())
				{
					employeeDetailMstFB_p.setStrDeleteCheckbox(empDependentDetailVO.getWrsData().getString("STR_DELETE_CHECKBOX")));
				}*/
				
				
				if (employeeDetailMstVO.getStrMsgType().equals("1")) {
					throw new Exception(employeeDetailMstVO.getStrMsgString());
				}
				
				strEnteredDependentDetailsTable	=	getEnteredDependentDetailsTable(empDependentDetailVO.getWrsData(),"WITHOUT_DELETE_CHECKBOX");
				
				
				employeeDetailMstFB_p.setStrEmpCode(employeeDetailMstVO.getStrEmpCode());	
				employeeDetailMstFB_p.setStrGenderCode(employeeDetailMstVO.getStrGenderCode());
				employeeDetailMstFB_p.setStrSalutationId(employeeDetailMstVO.getStrSalutationId());
				
				
				employeeDetailMstFB_p.setStrFirstName(employeeDetailMstVO.getStrFirstName());
				employeeDetailMstFB_p.setStrMiddleName(employeeDetailMstVO.getStrMiddleName());
				employeeDetailMstFB_p.setStrLastName(employeeDetailMstVO.getStrLastName());
				employeeDetailMstFB_p.setStrFatherName(employeeDetailMstVO.getStrFatherName());
				employeeDetailMstFB_p.setStrMotherName(employeeDetailMstVO.getStrMotherName());
				employeeDetailMstFB_p.setStrSpouseName(employeeDetailMstVO.getStrSpouseName());
				employeeDetailMstFB_p.setStrBirthDate(employeeDetailMstVO.getStrBirthDate());
				employeeDetailMstFB_p.setStrDesignationValues(employeeDetailMstVO.getStrDesigId());
				employeeDetailMstFB_p.setStrJoiningDate(employeeDetailMstVO.getStrJoiningDate());
				employeeDetailMstFB_p.setStrPermanentAddress(employeeDetailMstVO.getStrPermanentAddress());
				employeeDetailMstFB_p.setStrLocalAddress(employeeDetailMstVO.getStrLocalAddress());
				employeeDetailMstFB_p.setStrPhoneNo(employeeDetailMstVO.getStrPhoneNo());
				employeeDetailMstFB_p.setStrMobileNo(employeeDetailMstVO.getStrMobileNo());
				employeeDetailMstFB_p.setStrFaxNo(employeeDetailMstVO.getStrFaxNo());
				
				
				employeeDetailMstFB_p.setStrServiceDocNo(employeeDetailMstVO.getStrServiceDocNo());
				employeeDetailMstFB_p.setStrServiceDocDate(employeeDetailMstVO.getStrServiceDocDate());
				employeeDetailMstFB_p.setStrRemarks(employeeDetailMstVO.getStrRemarks());
				
				employeeDetailMstFB_p.setStrEnteredDependentDetailsTable(strEnteredDependentDetailsTable);
				
			} 
			catch (Exception e) 
			{
				strMsgText = "EmployeeDetailMstDATA.modifyRecord(fb,request_p) --> "	+ e.getMessage();
				HisException eObj = new HisException("mms","EmployeeDetailMstDATA->modifyRecord()", strMsgText);
				employeeDetailMstFB_p.setStrErrMsg("Application Error [ERROR ID : "	+ eObj.getErrorID() + "],Contact System Administrator! ");

				eObj = null;
			}
			finally 
			{
				bo = null;
				employeeDetailMstVO = null;
			}

		}
		
		
		/**
		 * To get Entered Dependent Details HLP
		 * 
		 * @param wrsData_p
		 *            the WebRowSet
		 */
		private static String getEnteredDependentDetailsTable(WebRowSet wrsData_p,String strWithOrWithoutDeleteChkBox)	throws SQLException {
			StringBuffer sbHeader = new StringBuffer(100);
			StringBuffer sbBody = new StringBuffer(100);
			int nWidth=20;
			int nColspan=5;
			
			if(strWithOrWithoutDeleteChkBox.equals("WITH_DELETE_CHECKBOX"))
			{
				nWidth = 20;
				nColspan = 5;
			}
			else if(strWithOrWithoutDeleteChkBox.equals("WITHOUT_DELETE_CHECKBOX"))
			{
				nWidth = 25;
				nColspan = 4;
			}
				
			
			/*
			 * Header Row:
			 */

			sbHeader.append("<tr>");
			if(strWithOrWithoutDeleteChkBox.equals("WITH_DELETE_CHECKBOX")){
				sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Delete</td>");	
			}
			
			sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">S. No. </td>");
			sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Dependent Name </td>");
			sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Age(Year) </td>");
			sbHeader.append("<td width=\""	+ nWidth	+ "%\" class=\"LABEL\" style=\"text-align: center;\">Relationship </td>");
			sbHeader.append("</tr>");

			if (wrsData_p != null && wrsData_p.size() > 0) {		
				/* Result Index */
				// TOTAL_DEPENDENTS: 1
				// STR_DEPENDENT_NAME: 2
				// NUM_AGE: 3
				// RELATIONSHIP: 4
				
				int strTotalPrevDep=0;
				
				while (wrsData_p.next()) {

					
					
					String strDeleteChk = wrsData_p.getString("STR_DELETE_CHECKBOX");
					String strTotalDependents = wrsData_p.getString("TOTAL_DEPENDENTS");
					String strDependentName = wrsData_p.getString("STR_DEPENDENT_NAME");
					String strAge = wrsData_p.getString("NUM_AGE");
					String strRelationship = wrsData_p.getString("RELATIONSHIP");
					
					
					
					
					if (strDeleteChk == null) {
						strDeleteChk = "---";
					}
					if (strTotalDependents == null) {
						strTotalDependents = "---";
					}
					if (strDependentName == null) {
						strDependentName = "---";
					}
					if (strAge == null) {
						strAge = "---";
					}
					if (strRelationship == null) {
						strRelationship = "---";
					}
					
					strTotalPrevDep++;
					/*
					 * Table Body
					 */

					sbBody.append("<tr>");
					
					if(strWithOrWithoutDeleteChkBox.equals("WITH_DELETE_CHECKBOX")){
						
						sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">"
								+"<input type=\"checkbox\" name=\"strDeleteCheckbox\" value=\""+strDeleteChk+"\" onclick=\"setDeleteRecord();\">" + "</td>");
						
					}
					
					sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strTotalDependents + "</td>");
					sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strDependentName + "</td>");
					sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strAge + "</td>");
					sbBody.append("<td class=\"CONTROL\" style=\"text-align: center;\">" + strRelationship + "</td>");
					
					sbBody.append("</tr>"); 
				}

			} 
			else 
			{
				sbBody.append("<tr>");
				sbBody.append("<td colspan=\""	+ nColspan	+ "\" class=\"CONTROL\" style=\"text-align: center; color: red;\">No Data Found!</td>");
				sbBody.append("</tr>");
			}
			
//			sbBody.append("<tr>");
//			sbBody.append("<html:hidden name=\"employeeDetailMstBean\" property=\"strTotalPreviousDependents\" value=\"'strTotalPrevDep'\" />");
//			sbBody.append("</tr>");

			return sbHeader.toString() + sbBody.toString();
		}
}
