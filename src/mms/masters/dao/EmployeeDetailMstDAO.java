package mms.masters.dao;

import javax.sql.rowset.WebRowSet;

import hisglobal.transactionmgnt.HisDAO;
import hisglobal.utility.HisUtil;
import mms.masters.vo.EmployeeDependentDtlVO;
import mms.masters.vo.EmployeeDetailMstVO;
import mms.reports.vo.EmployeeDetailRptVO;

public class EmployeeDetailMstDAO {

	
	/**
	 * To get Salutation Combo populated.
	 * 
	 * @param employeeDetailMstVO_p	the vo
	 */
	public static void getSalutationCombo(EmployeeDetailMstVO employeeDetailMstVO_p) {

		HisDAO dao = null;
		int nqryIndex;
		String strQuery;
		WebRowSet wb = null;

		try {
			dao = new HisDAO("bmed", "EmployeeDetailMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1,"employeeDetailMst.salutation.combo.add");
			nqryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nqryIndex, 1, employeeDetailMstVO_p.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);
			
			employeeDetailMstVO_p.setWrsData(wb);

		} 
		catch (Exception e) 
		{
			employeeDetailMstVO_p.setStrMsgString("--> EmployeeDetailMstDAO.getSalutationCombo()-->"	+ e.getMessage());
			employeeDetailMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wb = null;
		}
	}
	
	
	
	/**
	 * To get Designation Combo populated.
	 * 
	 * @param employeeDetailMstVO_p	the vo
	 */
	public static void getDesignationCombo(EmployeeDetailMstVO employeeDetailMstVO_p) {

		HisDAO dao = null;
		int nqryIndex;
		String strQuery;
		WebRowSet wb = null;

		try {
			dao = new HisDAO("dwh", "EmployeeDetailMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1,"employeeDetailMst.designation.combo.add");
			nqryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nqryIndex, 1, employeeDetailMstVO_p.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);
			
			employeeDetailMstVO_p.setWrsData(wb);

		} 
		catch (Exception e) 
		{
			employeeDetailMstVO_p.setStrMsgString("--> EmployeeDetailMstDAO.getDesignationCombo()-->"	+ e.getMessage());
			employeeDetailMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wb = null;
		}
	}


	/**
	 * To get Relationship Combo populated.
	 * 
	 * @param employeeDetailMstVO_p	the vo
	 */
	public static void getRelationshipCombo(EmployeeDetailMstVO employeeDetailMstVO_p) {
		HisDAO dao = null;
		int nqryIndex;
		String strQuery;
		WebRowSet wb = null;

		try {
			dao = new HisDAO("dwh", "EmployeeDetailMstDAO");

			strQuery = mms.qryHandler_mms.getQuery(1,"employeeDetailMst.relationship.combo.add");
			nqryIndex = dao.setQuery(strQuery);
			
			dao.setQryValue(nqryIndex, 1, employeeDetailMstVO_p.getStrHospitalCode());

			wb = dao.executeQry(nqryIndex);
			
			employeeDetailMstVO_p.setWrsData(wb);

		} 
		catch (Exception e) 
		{
			employeeDetailMstVO_p.setStrMsgString("--> EmployeeDetailMstDAO.getDesignationCombo()-->"	+ e.getMessage());
			employeeDetailMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wb = null;
		}		
	}



	/**
	 * To Save Data in PIST_EMP_PERSONNEL_DTL
	 * 
	 * @param employeeDetailMstVO_p
	 */
	public static void saveEmployeeDetail(EmployeeDetailMstVO employeeDetailMstVO_p,HisDAO hisDAO_p) {

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			
			strProcName_U = "{call pkg_mms_dml.proc_pist_emp_personnel_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // Total 32 Values
			
			nProcIndex_U = hisDAO_p.setProcedure(strProcName_U);
						
			//HisUtil.replaceNullValueWithEmptyString(employeeDetailMstVO_p);
			
			//Total 30 variables
			hisDAO_p.setProcInValue(nProcIndex_U, "p_mode", employeeDetailMstVO_p.getStrMode());//1
			
			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_emp_no", employeeDetailMstVO_p.getStrEmpNo());//2 
			hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_hospital_code", employeeDetailMstVO_p.getStrHospitalCode());//3
			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_emp_code",	employeeDetailMstVO_p.getStrEmpCode());//4
			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_first_name",	employeeDetailMstVO_p.getStrFirstName());//5
			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_middle_name",	employeeDetailMstVO_p.getStrMiddleName());//6

			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_last_name", employeeDetailMstVO_p.getStrLastName());//7
			hisDAO_p.setProcInValue(nProcIndex_U, "p_num_desig_id",	employeeDetailMstVO_p.getStrDesigId());//8
			hisDAO_p.setProcInValue(nProcIndex_U, "p_dt_joining_date", employeeDetailMstVO_p.getStrJoiningDate());//9
			hisDAO_p.setProcInValue(nProcIndex_U, "p_dt_birth_date", employeeDetailMstVO_p.getStrBirthDate());//10
			hisDAO_p.setProcInValue(nProcIndex_U, "p_num_gender_code", employeeDetailMstVO_p.getStrGenderCode());//11

			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_permanent_address", employeeDetailMstVO_p.getStrPermanentAddress());//12
			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_local_address", employeeDetailMstVO_p.getStrLocalAddress());//13
			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_phone_no", employeeDetailMstVO_p.getStrPhoneNo());//14
			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_mobile_no", employeeDetailMstVO_p.getStrMobileNo());//15
			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_fax_no", employeeDetailMstVO_p.getStrFaxNo());//16

			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_service_doc_no", employeeDetailMstVO_p.getStrServiceDocNo());//17
			hisDAO_p.setProcInValue(nProcIndex_U, "p_dt_service_doc_date", employeeDetailMstVO_p.getStrServiceDocDate());//18
			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_father_name", employeeDetailMstVO_p.getStrFatherName());//19
			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_mother_name", employeeDetailMstVO_p.getStrMotherName());//20
			hisDAO_p.setProcInValue(nProcIndex_U, "p_str_spouse_name", employeeDetailMstVO_p.getStrSpouseName());//21

			hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_salutation_id", employeeDetailMstVO_p.getStrSalutationId());//22
			hisDAO_p.setProcInValue(nProcIndex_U, "p_gstr_remarks", employeeDetailMstVO_p.getStrRemarks());//23
			hisDAO_p.setProcInValue(nProcIndex_U, "p_gdt_effective_frm", employeeDetailMstVO_p.getStrEffectiveFrm());//24
			hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_lstmod_seatid", employeeDetailMstVO_p.getStrLstModSeatId());//25
			hisDAO_p.setProcInValue(nProcIndex_U, "p_gdt_lstmod_date", employeeDetailMstVO_p.getStrLstModDate());//26

			hisDAO_p.setProcInValue(nProcIndex_U, "p_gdt_entry_date", employeeDetailMstVO_p.getStrEntryDate());//27
			hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_seatid", employeeDetailMstVO_p.getStrSeatId());//28
			hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_isvalid", employeeDetailMstVO_p.getStrIsValid());//29
			
			hisDAO_p.setProcInValue(nProcIndex_U, "p_email_id", employeeDetailMstVO_p.getStrEmailId());//30
			hisDAO_p.setProcInValue(nProcIndex_U, "p_district_id", employeeDetailMstVO_p.getStrDistrictId());//31
		
			/* Default Value */

			hisDAO_p.setProcOutValue(nProcIndex_U, "err", 1);//30

			hisDAO_p.execute(nProcIndex_U,1);
			
			employeeDetailMstVO_p.setStrMsgType("0");

		} 
		catch (Exception e) 
		{
			employeeDetailMstVO_p.setStrMsgString("--> EmployeeDetailDAO.saveEmployeeDetail(employeeDetailMstVO_p,hisDAO_p)-->" + e.getMessage());
			employeeDetailMstVO_p.setStrMsgType("1");
		} 	
	}
	
	
	/**
	 * To Save Data in PIST_EMP_DEPENDENT_DTL
	 * 
	 * @param employeeDetailMstVO_p
	 */
	public static void saveDependentDetail(EmployeeDependentDtlVO employeeDependentDtlVO_p,HisDAO hisDAO_p,int strDependentSlNo_p) {

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			
			strProcName_U = "{call pkg_mms_dml.proc_pist_emp_dependent_dtl(?,?,?,?,?,  ?,?,?,?,?,  ?,?,?,?,?,  ?)}"; // Total 16 Values
			
			nProcIndex_U = hisDAO_p.setProcedure(strProcName_U);
						
		//	HisUtil.replaceNullValueWithEmptyString(employeeDependentDtlVO_p);
			
			//Total 16 variables
			
			for(int i=0;i<employeeDependentDtlVO_p.getStrDependentName().length;i++)
			{	
					hisDAO_p.setProcInValue(nProcIndex_U, "p_mode", employeeDependentDtlVO_p.getStrMode());//1
					
					
					hisDAO_p.setProcInValue(nProcIndex_U, "p_str_emp_no", employeeDependentDtlVO_p.getStrEmpNo());//2 
					hisDAO_p.setProcInValue(nProcIndex_U, "p_num_sl_no",Integer.toString(i+strDependentSlNo_p));//3
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_hospital_code", employeeDependentDtlVO_p.getStrHospitalCode());//4
					hisDAO_p.setProcInValue(nProcIndex_U, "p_str_dependent_name",	employeeDependentDtlVO_p.getStrDependentName()[i]);//5
					hisDAO_p.setProcInValue(nProcIndex_U, "p_num_age",	employeeDependentDtlVO_p.getStrAge()[i]);//6
		
					hisDAO_p.setProcInValue(nProcIndex_U, "p_dt_age_on", employeeDependentDtlVO_p.getStrAgeOn());//7
					hisDAO_p.setProcInValue(nProcIndex_U, "p_sstnum_reltype_id",	employeeDependentDtlVO_p.getStrRelationshipId()[i]);//8
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gdt_effective_frm", employeeDependentDtlVO_p.getStrEffectiveFrm());//9
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gdt_effective_to", employeeDependentDtlVO_p.getStrEffectiveTo());//10
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_lstmod_seatid", employeeDependentDtlVO_p.getStrLstModSeatId());//11
		
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gdt_lstmod_date", employeeDependentDtlVO_p.getStrLstModDate());//12
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gdt_entry_date", employeeDependentDtlVO_p.getStrEntryDate());//13
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_seatid", employeeDependentDtlVO_p.getStrSeatId());//14
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_isvalid", employeeDependentDtlVO_p.getStrIsValid());//15
		
					
					/* Default Value */
		
					hisDAO_p.setProcOutValue(nProcIndex_U, "err", 1);//16
		
					//hisDAO_p.executeProcedure(nProcIndex_U);
		
					hisDAO_p.execute(nProcIndex_U, 1);
			
			}
		
			employeeDependentDtlVO_p.setStrMsgType("0");

		} 
		catch (Exception e) 
		{
			employeeDependentDtlVO_p.setStrMsgString("--> EmployeeDetailDAO.saveDependentDetail(employeeDependentDtlVO_p,hisDAO_p)-->" + e.getMessage());
			employeeDependentDtlVO_p.setStrMsgType("1");
		} 
	}


	/**
	 * to get data for modify page.
	 * 
	 * @param employeeDetailMstVO_p the vo
	 * @param employeeDependentDtlVO_p  the vo
	 * 
	 */
	public static void modifyRecord(EmployeeDetailMstVO employeeDetailMstVO_p,EmployeeDependentDtlVO employeeDependentDtlVO_p) {

		HisDAO dao = null;
		int nqryIndex = 0, nqryIndex1=0;

		String strQuery,strQuery1;

		WebRowSet web = null,web1=null;

		try {

			dao = new HisDAO("mms", "EmployeeDetailMstDAO");


			strQuery = mms.qryHandler_mms.getQuery(1, "employeeDetailMst.modify");
			
			strQuery1 = mms.qryHandler_mms.getQuery(1, "employeeDetailMst.modify.dependent.details");
			
			nqryIndex = dao.setQuery(strQuery);
			nqryIndex1 = dao.setQuery(strQuery1);

			dao.setQryValue(nqryIndex, 1, employeeDetailMstVO_p.getStrEmpNo());
			dao.setQryValue(nqryIndex, 2, employeeDetailMstVO_p.getStrHospitalCode());
			
			dao.setQryValue(nqryIndex1, 1, employeeDetailMstVO_p.getStrEmpNo());
			dao.setQryValue(nqryIndex1, 2, employeeDetailMstVO_p.getStrHospitalCode());
			

			web = dao.executeQry(nqryIndex);
			if (web.next()) {
			        
				employeeDetailMstVO_p.setStrEmpCode(web.getString("STR_EMP_CODE"));	
				employeeDetailMstVO_p.setStrGenderCode(web.getString("NUM_GENDER_CODE"));
				employeeDetailMstVO_p.setStrSalutationId(web.getString("GNUM_SALUTATION_ID"));
				
				
				employeeDetailMstVO_p.setStrFirstName(web.getString("STR_FIRST_NAME"));
				employeeDetailMstVO_p.setStrMiddleName(web.getString("STR_MIDDLE_NAME"));
				employeeDetailMstVO_p.setStrLastName(web.getString("STR_LAST_NAME"));
				employeeDetailMstVO_p.setStrFatherName(web.getString("STR_FATHER_NAME"));
				employeeDetailMstVO_p.setStrMotherName(web.getString("STR_MOTHER_NAME"));
				employeeDetailMstVO_p.setStrSpouseName(web.getString("STR_SPOUSE_NAME"));
				employeeDetailMstVO_p.setStrBirthDate(web.getString("DT_BIRTH_DATE"));
				employeeDetailMstVO_p.setStrDesigId(web.getString("NUM_DESIG_ID"));
				employeeDetailMstVO_p.setStrJoiningDate(web.getString("DT_JOINING_DATE"));
				employeeDetailMstVO_p.setStrPermanentAddress(web.getString("STR_PERMANENT_ADDRESS"));
				employeeDetailMstVO_p.setStrLocalAddress(web.getString("STR_LOCAL_ADDRESS"));
				employeeDetailMstVO_p.setStrPhoneNo(web.getString("STR_PHONE_NO"));
				employeeDetailMstVO_p.setStrMobileNo(web.getString("STR_MOBILE_NO"));
				employeeDetailMstVO_p.setStrFaxNo(web.getString("STR_FAX_NO"));
				
				employeeDetailMstVO_p.setStrServiceDocNo(web.getString("STR_SERVICE_DOC_NO"));
				employeeDetailMstVO_p.setStrServiceDocDate(web.getString("DT_SERVICE_DOC_DATE"));
				employeeDetailMstVO_p.setStrRemarks(web.getString("GSTR_REMARKS"));
				
				
				employeeDetailMstVO_p.setStrSeatId(web.getString("GNUM_SEATID"));	
				employeeDetailMstVO_p.setStrIsValid(web.getString("GNUM_ISVALID"));
				
				employeeDetailMstVO_p.setStrEmailId(web.getString("PISSTR_EMAIL_ID"));
				employeeDetailMstVO_p.setStrDistrictId(web.getString("PISNUM_DISTRICT_ID"));
				 
				
				employeeDetailMstVO_p.setStrEffectiveFrm(web.getString("GDT_EFFECTIVE_FRM"));
				employeeDetailMstVO_p.setStrEntryDate(web.getString("GDT_ENTRY_DATE"));
				
			}
			web.close();
			
			
			web1 = dao.executeQry(nqryIndex1);
			
			
				employeeDependentDtlVO_p.setWrsData(web1);
			
			//web1.close();
		}

		catch (Exception e) 
		{
			employeeDetailMstVO_p.setStrMsgString("--> EmployeeDetailMstDAO.modifyRecord()-->"	+ e.getMessage());
			employeeDetailMstVO_p.setStrMsgType("1");
		}
		finally 
		{
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}
	
	/*
	 * 
	 */
	
	/**
	 * To delete Data in PIST_EMP_DEPENDENT_DTL
	 * 
	 * @param employeeDetailMstVO_p
	 */
	public static void deleteDependentDetail(EmployeeDependentDtlVO deleteEmpDependentDetailVO_p,HisDAO hisDAO_p) {

		int nProcIndex_U;

		String strProcName_U = "";

		try {
			
			strProcName_U = "{call pkg_mms_dml.proc_pist_emp_dependent_dtl(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}"; // Total 16 Values
			
			nProcIndex_U = hisDAO_p.setProcedure(strProcName_U);
						
			//HisUtil.replaceNullValueWithEmptyString(deleteEmpDependentDetailVO_p);
			
			//Total 16 variables
			
			for(int i=0;i<deleteEmpDependentDetailVO_p.getStrSlNo().length;i++)
			{	
					hisDAO_p.setProcInValue(nProcIndex_U, "p_mode", deleteEmpDependentDetailVO_p.getStrMode());//1
					
					
					hisDAO_p.setProcInValue(nProcIndex_U, "p_str_emp_no", deleteEmpDependentDetailVO_p.getStrEmpNo());//2 
					hisDAO_p.setProcInValue(nProcIndex_U, "p_num_sl_no",deleteEmpDependentDetailVO_p.getStrSlNo()[i]);//3
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_hospital_code", deleteEmpDependentDetailVO_p.getStrHospitalCode());//4
					hisDAO_p.setProcInValue(nProcIndex_U, "p_str_dependent_name",	deleteEmpDependentDetailVO_p.getStrDependentName()[i]);//5
					hisDAO_p.setProcInValue(nProcIndex_U, "p_num_age",	deleteEmpDependentDetailVO_p.getStrAge()[i]);//6
		
					hisDAO_p.setProcInValue(nProcIndex_U, "p_dt_age_on", deleteEmpDependentDetailVO_p.getStrAgeOn());//7
					hisDAO_p.setProcInValue(nProcIndex_U, "p_sstnum_reltype_id",	deleteEmpDependentDetailVO_p.getStrRelationshipId()[i]);//8
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gdt_effective_frm", deleteEmpDependentDetailVO_p.getStrEffectiveFrm());//9
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gdt_effective_to", deleteEmpDependentDetailVO_p.getStrEffectiveTo());//10
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_lstmod_seatid", deleteEmpDependentDetailVO_p.getStrLstModSeatId());//11
		
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gdt_lstmod_date", deleteEmpDependentDetailVO_p.getStrLstModDate());//12
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gdt_entry_date", deleteEmpDependentDetailVO_p.getStrEntryDate());//13
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_seatid", deleteEmpDependentDetailVO_p.getStrSeatId());//14
					hisDAO_p.setProcInValue(nProcIndex_U, "p_gnum_isvalid", deleteEmpDependentDetailVO_p.getStrIsValid());//15
		
					/* Default Value */
					
					hisDAO_p.setProcOutValue(nProcIndex_U, "err", 1);//16
		
					//hisDAO_p.executeProcedure(nProcIndex_U);
		
					hisDAO_p.execute(nProcIndex_U, 1);
			
			}
		
			deleteEmpDependentDetailVO_p.setStrMsgType("0");

		} 
		catch (Exception e) 
		{
			deleteEmpDependentDetailVO_p.setStrMsgString("--> EmployeeDetailDAO.saveDependentDetail(deleteEmpDependentDetailVO_p,hisDAO_p)-->" + e.getMessage());
			deleteEmpDependentDetailVO_p.setStrMsgType("1");
		} 
		finally
		{
			
		}
	}

	/**
	 * to get data for View page.
	 * 
	 * @param employeeDetailMstVO_p the vo
	 * @param employeeDependentDtlVO_p  the vo
	 * 
	 */
	public static void viewRecord(EmployeeDetailMstVO employeeDetailMstVO_p,EmployeeDependentDtlVO employeeDependentDtlVO_p) {

		HisDAO dao = null;
		int nqryIndex = 0, nqryIndex1=0;

		String strQuery,strQuery1;

		WebRowSet web = null,web1=null;

		try {

			dao = new HisDAO("mms", "EmployeeDetailMstDAO");


			strQuery = mms.qryHandler_mms.getQuery(1, "employeeDetailMst.view");
			
			strQuery1 = mms.qryHandler_mms.getQuery(1, "employeeDetailMst.view.dependent.details");
			
			nqryIndex = dao.setQuery(strQuery);
			nqryIndex1 = dao.setQuery(strQuery1);

			dao.setQryValue(nqryIndex, 1, employeeDetailMstVO_p.getStrEmpNo());
			dao.setQryValue(nqryIndex, 2, employeeDetailMstVO_p.getStrHospitalCode());
			
			dao.setQryValue(nqryIndex1, 1, employeeDetailMstVO_p.getStrEmpNo());
			dao.setQryValue(nqryIndex1, 2, employeeDetailMstVO_p.getStrHospitalCode());
			

			web = dao.executeQry(nqryIndex);
			if (web.next()) {
			        
				employeeDetailMstVO_p.setStrEmpCode(web.getString("STR_EMP_CODE"));	
				employeeDetailMstVO_p.setStrGenderCode(web.getString("NUM_GENDER_CODE"));
				employeeDetailMstVO_p.setStrSalutationId(web.getString("GNUM_SALUTATION_ID"));
				
				
				employeeDetailMstVO_p.setStrFirstName(web.getString("STR_FIRST_NAME"));
				employeeDetailMstVO_p.setStrMiddleName(web.getString("STR_MIDDLE_NAME"));
				employeeDetailMstVO_p.setStrLastName(web.getString("STR_LAST_NAME"));
				employeeDetailMstVO_p.setStrFatherName(web.getString("STR_FATHER_NAME"));
				employeeDetailMstVO_p.setStrMotherName(web.getString("STR_MOTHER_NAME"));
				employeeDetailMstVO_p.setStrSpouseName(web.getString("STR_SPOUSE_NAME"));
				employeeDetailMstVO_p.setStrBirthDate(web.getString("DT_BIRTH_DATE"));
				employeeDetailMstVO_p.setStrDesigId(web.getString("NUM_DESIG_ID"));
				employeeDetailMstVO_p.setStrJoiningDate(web.getString("DT_JOINING_DATE"));
				employeeDetailMstVO_p.setStrPermanentAddress(web.getString("STR_PERMANENT_ADDRESS"));
				employeeDetailMstVO_p.setStrLocalAddress(web.getString("STR_LOCAL_ADDRESS"));
				employeeDetailMstVO_p.setStrPhoneNo(web.getString("STR_PHONE_NO"));
				employeeDetailMstVO_p.setStrMobileNo(web.getString("STR_MOBILE_NO"));
				employeeDetailMstVO_p.setStrFaxNo(web.getString("STR_FAX_NO"));
				
				employeeDetailMstVO_p.setStrServiceDocNo(web.getString("STR_SERVICE_DOC_NO"));
				employeeDetailMstVO_p.setStrServiceDocDate(web.getString("DT_SERVICE_DOC_DATE"));
				employeeDetailMstVO_p.setStrRemarks(web.getString("GSTR_REMARKS"));
				
				
				employeeDetailMstVO_p.setStrSeatId(web.getString("GNUM_SEATID"));	
				employeeDetailMstVO_p.setStrIsValid(web.getString("GNUM_ISVALID"));
				
				
				employeeDetailMstVO_p.setStrEffectiveFrm(web.getString("GDT_EFFECTIVE_FRM"));
				employeeDetailMstVO_p.setStrEntryDate(web.getString("GDT_ENTRY_DATE"));
				
			}
			web.close();
			
			
			web1 = dao.executeQry(nqryIndex1);
			
			
				employeeDependentDtlVO_p.setWrsData(web1);
			
			//web1.close();
		}

		catch (Exception e) 
		{
			employeeDetailMstVO_p.setStrMsgString("--> EmployeeDetailMstDAO.viewRecord()-->"	+ e.getMessage());
			employeeDetailMstVO_p.setStrMsgType("1");
		}
		finally 
		{
			if (dao != null) {
				dao.free();
				dao = null;
			}

		}
	}



	/**
	 * Check duplicate while inserting records
	 * 
	 * @param employeeDetailMstVO_p the vo
	 * @param strInsertUpdate
	 *            the String variable used to catch the parameter to know
	 *            whether duplicacy is checked for inserting a record or
	 *            updating it
	 */
	public static void chkDuplicate(EmployeeDetailMstVO employeeDetailMstVO_p, String strInsertUpdate) {
		HisDAO dao = null;
		int nqryIndex = 0;
		int ncount = 0;
		WebRowSet wb = null;
		String strquery = new String();

		try {
			dao = new HisDAO("bmed", "EmployeeDetailMstDAO");
			if (strInsertUpdate.equals("insert")) {
				strquery = mms.qryHandler_mms.getQuery(1,"employeeDetailMst.insert.chkduplicate");
				nqryIndex = dao.setQuery(strquery);

				dao.setQryValue(nqryIndex, 1, employeeDetailMstVO_p.getStrEmpCode());
				dao.setQryValue(nqryIndex, 2, employeeDetailMstVO_p.getStrHospitalCode());
			}

			else if (strInsertUpdate.equals("update"))
			{
				strquery = mms.qryHandler_mms.getQuery(1,"employeeDetailMst.update.chkduplicate");
				nqryIndex = dao.setQuery(strquery);

				dao.setQryValue(nqryIndex, 1, employeeDetailMstVO_p.getStrEmpNo());
				dao.setQryValue(nqryIndex, 2, employeeDetailMstVO_p.getStrHospitalCode());
			
				dao.setQryValue(nqryIndex, 3, employeeDetailMstVO_p.getStrEmpCode());
				dao.setQryValue(nqryIndex, 4, employeeDetailMstVO_p.getStrHospitalCode());
			}

			employeeDetailMstVO_p.setStrMsgType("0");

			wb = dao.executeQry(nqryIndex);

			while (wb.next()) {
				ncount = Integer.parseInt(wb.getString(1));
			}

			if (ncount == 0) {

				employeeDetailMstVO_p.setBExistStatus(true); // ncount=0 => no duplicate Employee Code, hence new
											// record will be saved
			} else {
				employeeDetailMstVO_p.setBExistStatus(false); // ncount!=0 => Employee Code already
											// exists, so new record will not be
											// added
			}
		} catch (Exception e) {
			employeeDetailMstVO_p.setStrMsgString("EmployeeDetailMstDAO.chkDuplicate() --> "	+ e.getMessage());
			employeeDetailMstVO_p.setStrMsgType("1");
		} finally {
			if (dao != null) {
				dao.free();
				dao = null;
			}
			wb = null;
		}
	}
	
	
	/**
	 * for getting option value of Lab Name on page
	 * 
	 * @param vo
	 * @throws Exception
	 */
	public static void getDistrictNameCmb(EmployeeDetailMstVO vo)
	{
		String strProcName = "{call pkg_mms_view.Proc_District_Name_Combo(?,?,?,?,?,  ?,?)}"; //5 variables
		
		int nProcIndex = 0;
		String strErr = "";
		WebRowSet ws = null;
		HisDAO daoObj=null;
		HisUtil hisutil = null;
		try
		{						
			daoObj=new HisDAO("mms","EmployeeDetailRptDAO");
			hisutil    = new HisUtil("mms", "EmployeeDetailRptDAO");
			nProcIndex = daoObj.setProcedure(strProcName);
						  		
			
			
			daoObj.setProcInValue(nProcIndex, "p_mode", "1");
			daoObj.setProcInValue(nProcIndex, "p_hosp_code", vo.getStrHospitalCode());
			daoObj.setProcInValue(nProcIndex, "p_country_code", vo.getStrCountryCode());
			daoObj.setProcInValue(nProcIndex, "p_state_code", vo.getStrStateCode());
			daoObj.setProcInValue(nProcIndex, "p_seatid", vo.getStrSeatId());
			daoObj.setProcOutValue(nProcIndex, "err",1); 
			daoObj.setProcOutValue(nProcIndex, "resultset",2);
			daoObj.executeProcedure(nProcIndex);
			
			strErr = daoObj.getString(nProcIndex, "err");
			if (strErr == null)
				strErr = "";
			ws = daoObj.getWebRowSet(nProcIndex, "resultset");
			String str;
			if (strErr.equals("")) 
			{
				if(ws!=null && ws.size()>0)
				{
					str = hisutil.getOptionValue(ws, vo.getStrDistrictId(),"0^Select Value", true);
					vo.setStrDistrictNameCombo(str);
				}	
				else
				{
					str = "<option value='0'>Select Value</option>";  
					vo.setStrDistrictNameCombo(str);
				}	
			} 
			else 
			{
				throw new Exception(strErr);
			}
		}
		catch(Exception e)
		{
			vo.setStrMsgString("EmployeeDetailRptDAO.Proc_District_Name_Combo() --> "
					+ e.getMessage());
			vo.setStrMsgType("1");
		}
	}
}