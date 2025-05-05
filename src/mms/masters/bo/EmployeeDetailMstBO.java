package mms.masters.bo;

import hisglobal.exceptions.HisException;
import hisglobal.transactionmgnt.HisDAO;
import mms.masters.dao.EmployeeDetailMstDAO;
import mms.masters.dao.StateMstDAO;
import mms.masters.vo.EmployeeDependentDtlVO;
import mms.masters.vo.EmployeeDetailMstVO;
import mms.reports.dao.EmployeeDetailRptDAO;

/**
 * @author Vivek Aggarwal  
 * Creation Date:- 7-June-2011 
 * Modifying Date:- 10-June-2011
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class EmployeeDetailMstBO 
{
	
	/**
	 * to get Employee Name and Designation Combo Value.
	 * 
	 * @param vo the vo
	 * 
	 */
	public void initializeAdd(EmployeeDetailMstVO []employeeDetailMstVO_p) {

		EmployeeDetailMstDAO.getSalutationCombo(employeeDetailMstVO_p[0]);
		EmployeeDetailMstDAO.getDistrictNameCmb(employeeDetailMstVO_p[0]);
		
		
		EmployeeDetailMstDAO.getDesignationCombo(employeeDetailMstVO_p[1]);
		
		EmployeeDetailMstDAO.getRelationshipCombo(employeeDetailMstVO_p[2]);

			if (employeeDetailMstVO_p[0].getStrMsgType().equals("1")) 
			{
				employeeDetailMstVO_p[0].setStrMsgString("EmployeeDetailMstBO.initializeAdd(employeeDetailMstVO_p) --> "	+ employeeDetailMstVO_p[0].getStrMsgString());
				
			}
			
			if(employeeDetailMstVO_p[1].getStrMsgType().equals("1"))
			{
				employeeDetailMstVO_p[1].setStrMsgString("EmployeeDetailMstBO.initializeAdd(employeeDetailMstVO_p) --> "	+ employeeDetailMstVO_p[1].getStrMsgString());

			}
			
			if(employeeDetailMstVO_p[2].getStrMsgType().equals("1"))
			{
				employeeDetailMstVO_p[2].setStrMsgString("EmployeeDetailMstBO.initializeAdd(employeeDetailMstVO_p) --> "	+ employeeDetailMstVO_p[1].getStrMsgString());

			}
	}

	
	/**
	 * To insert data.
	 * 
	 * @param employeeDetailMstVO_p the EmployeeDetailMstVO
	 * @param empDependentDetailVO_p the  EmployeeDependentDtlVO
	 * 
 	 */
	public void insertRecord(EmployeeDetailMstVO employeeDetailMstVO_p, EmployeeDependentDtlVO empDependentDetailVO_p) {

		EmployeeDetailMstDAO.chkDuplicate(employeeDetailMstVO_p,"insert");
		
		if (employeeDetailMstVO_p.isBExistStatus() == true)	//no duplicate EmployeeCode , so new record is added
		{
		
			String strEmpNo;
			HisDAO hisDAO_p = null;
			String strDependentSlNo="0";
	
			int funcIndex = 0,funcIndex1=0;
			
			try {
				hisDAO_p = new HisDAO("dwh", "EmployeeDetailMstBO");
				
				/*
				 * Generate Emp No.
				 */
				funcIndex = hisDAO_p.setFunction("{? = call mms_mst.gen_emp_no(?)}");
	
				hisDAO_p.setFuncInValue(funcIndex, 2, employeeDetailMstVO_p.getStrHospitalCode());
	
				hisDAO_p.setFuncOutValue(funcIndex, 1);
	
				// Execute Function
				hisDAO_p.executeFunction(funcIndex);
				strEmpNo = hisDAO_p.getFuncString(funcIndex);
	
				
				employeeDetailMstVO_p.setStrEmpNo(strEmpNo);
				
				
				/*
				 *Generate Serial No;
				 */	
				funcIndex1 = hisDAO_p.setFunction("{? = call mms_mst.gen_emp_dependent_slno(?,?)}");
				
				hisDAO_p.setFuncInValue(funcIndex1, 2, empDependentDetailVO_p.getStrHospitalCode());
				hisDAO_p.setFuncInValue(funcIndex1, 3, empDependentDetailVO_p.getStrEmpNo());
	
				hisDAO_p.setFuncOutValue(funcIndex1, 1);
	
				// Execute Function
				hisDAO_p.executeFunction(funcIndex1);
				strDependentSlNo = hisDAO_p.getFuncString(funcIndex1);
				
				//Save Employee Personal Details
				EmployeeDetailMstDAO.saveEmployeeDetail(employeeDetailMstVO_p,hisDAO_p);
	
				if (employeeDetailMstVO_p.getStrMsgType().equals("1")) 
				{
					employeeDetailMstVO_p.setStrMsgString("EmployeeDetailMstBO.insertValues(employeeDetailMstVO_p) ---->"+ employeeDetailMstVO_p.getStrMsgString());
				}
				
				
						//Save Dependent Details
			
						if(empDependentDetailVO_p!=null)
						{
							empDependentDetailVO_p.setStrEmpNo(strEmpNo);
							EmployeeDetailMstDAO.saveDependentDetail(empDependentDetailVO_p,hisDAO_p,Integer.parseInt(strDependentSlNo));
							
							if (empDependentDetailVO_p.getStrMsgType().equals("1")) 
							{
								empDependentDetailVO_p.setStrMsgString("EmployeeDetailMstBO.insertValues(employeeDetailMstVO_p) ---->"+ empDependentDetailVO_p.getStrMsgString());
							}	
						}
			
				synchronized (hisDAO_p) {
					hisDAO_p.fire(); // Here we Execute in Batch
				}
				
			}
			catch (Exception e) {
				String strMsgText = e.getMessage();
						throw new HisException("dwh","EmployeeDetailMstBO.insertRecord(employeeDetailMstVO_p,empDependentDetailVO_p)",strMsgText);
			}
			finally 
			{
				/* Closing Transaction */
				if (hisDAO_p != null) 
				{
					hisDAO_p.free();
					hisDAO_p = null;
				}
			}
		}
		
		if (employeeDetailMstVO_p.getStrMsgType().equals("1")) 
		{
			employeeDetailMstVO_p.setStrMsgString("EmployeeDetailMstBO.insertRecord() --> "+ employeeDetailMstVO_p.getStrMsgString());
		}
	}

	/**
	 * to get data for modify page.
	 * 
	 * @param EmployeeDetailMstVO_p the vo
	 * 
	 */
	public void modifyRecord(EmployeeDetailMstVO employeeDetailMstVO_p,EmployeeDependentDtlVO employeeDependentDtlVO_p) {
		EmployeeDetailMstDAO.modifyRecord(employeeDetailMstVO_p,employeeDependentDtlVO_p);
		if (employeeDetailMstVO_p.getStrMsgType().equals("1")) {
			employeeDetailMstVO_p.setStrMsgString("EmployeeDetailMstBO.modifyRecord(employeeDetailMstVO_p) --> "	+ employeeDetailMstVO_p.getStrMsgString());
		}
	}

	
	/**
	 * to update the record.
	 * 
	 * @param employeeDetailMstVO_p the EmployeeDetailMstVO
	 * @param empDependentDetailVO_p the  EmployeeDependentDtlVO
	 */
	public void updateRecord(EmployeeDetailMstVO employeeDetailMstVO_p, EmployeeDependentDtlVO empDependentDetailVO_p,EmployeeDependentDtlVO deleteEmpDependentDetailVO_p) {
	
		EmployeeDetailMstDAO.chkDuplicate(employeeDetailMstVO_p,"update");

		if (employeeDetailMstVO_p.isBExistStatus() == true)	//no duplicate EmployeeCode , so new record is added
		{
		
		HisDAO hisDAO = null;
		int funcIndex = 0;
		String strDependentSlNo="0";
		try {
			hisDAO = new HisDAO("dwh", "EmployeeDetailMstBO");

			/*
			 *Generate Serial No;
			 */	
			funcIndex = hisDAO.setFunction("{? = call mms_mst.gen_emp_dependent_slno(?,?)}");
			
			hisDAO.setFuncInValue(funcIndex, 2, empDependentDetailVO_p.getStrHospitalCode());
			hisDAO.setFuncInValue(funcIndex, 3, empDependentDetailVO_p.getStrEmpNo());

			hisDAO.setFuncOutValue(funcIndex, 1);

			// Execute Function
			hisDAO.executeFunction(funcIndex);
			strDependentSlNo = hisDAO.getFuncString(funcIndex);
			
			//Save Employee Details
			EmployeeDetailMstDAO.saveEmployeeDetail(employeeDetailMstVO_p,hisDAO);

			if (employeeDetailMstVO_p.getStrMsgType().equals("1")) 
			{
				employeeDetailMstVO_p.setStrMsgString("EmployeeDetailMstBO.updateRecord(employeeDetailMstVO_p) ---->"+ employeeDetailMstVO_p.getStrMsgString());
			}
			
			
			if(deleteEmpDependentDetailVO_p!=null)
			{
				EmployeeDetailMstDAO.deleteDependentDetail(deleteEmpDependentDetailVO_p,hisDAO );
				
				
				if (deleteEmpDependentDetailVO_p.getStrMsgType().equals("1"))
				{
					deleteEmpDependentDetailVO_p.setStrMsgString("EmployeeDetailMstBO.updateRecord() --> " + deleteEmpDependentDetailVO_p.getStrMsgString());
				}	
			}
			
			
			
			// Save Dependent Details
			if(empDependentDetailVO_p!=null && empDependentDetailVO_p.getStrDependentName()!=null && empDependentDetailVO_p.getStrDependentName().length>0)
			{
				
				EmployeeDetailMstDAO.saveDependentDetail(empDependentDetailVO_p,hisDAO,Integer.parseInt(strDependentSlNo) );	
				
				
				if (empDependentDetailVO_p.getStrMsgType().equals("1"))
				{
					empDependentDetailVO_p.setStrMsgString("EmployeeDetailMstBO.updateRecord() --> " + empDependentDetailVO_p.getStrMsgString());
				}	
			}
			
				

				synchronized (hisDAO) {
					hisDAO.fire(); // Here we Execute in Batch
				}
					
			}
			catch (Exception e) {
				String strMsgText = e.getMessage();
						throw new HisException("dwh","EmployeeDetailMstBO.updateRecord(employeeDetailMstVO_p,empDependentDetailVO_p)",strMsgText);
			}
			finally 
			{
				/* Closing Transaction */
				if (hisDAO != null) 
				{
					hisDAO.free();
					hisDAO = null;
				}
			}		
		}
		if (employeeDetailMstVO_p.getStrMsgType().equals("1")) 
		{
			employeeDetailMstVO_p.setStrMsgString("EmployeeDetailMstBO.updateRecord(employeeDetailMstVO_p) ---->"+ employeeDetailMstVO_p.getStrMsgString());
		}
	}
		
	/**
	 * to get data for View page.
	 * 
	 * @param EmployeeDetailMstVO_p the vo
	 * 
	 */
	public void viewRecord(EmployeeDetailMstVO employeeDetailMstVO_p,EmployeeDependentDtlVO employeeDependentDtlVO_p) {
		EmployeeDetailMstDAO.viewRecord(employeeDetailMstVO_p,employeeDependentDtlVO_p);
		if (employeeDetailMstVO_p.getStrMsgType().equals("1")) {
			employeeDetailMstVO_p.setStrMsgString("EmployeeDetailMstBO.viewRecord(employeeDetailMstVO_p) --> "	+ employeeDetailMstVO_p.getStrMsgString());
		}
	}
}
