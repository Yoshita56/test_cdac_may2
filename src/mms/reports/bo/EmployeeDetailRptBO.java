package mms.reports.bo;

import mms.reports.dao.EmployeeDetailRptDAO;
import mms.reports.vo.EmployeeDetailRptVO;



public class EmployeeDetailRptBO {


	/**
	 * GetData Method is Used to Populate the Data 
	 * for Lab Details DAO 
	 * @param vo
	 */
	public void initDetail(EmployeeDetailRptVO employeeDetailRptVO_p)
	{
		EmployeeDetailRptDAO.getDistrictNameCmb(employeeDetailRptVO_p);
		EmployeeDetailRptDAO.getDesignationNameCmb(employeeDetailRptVO_p);
		
		  if (employeeDetailRptVO_p.getStrMsgType().equals("1")) 
		  {
			  employeeDetailRptVO_p.setStrMsgString("EmployeeDetailRptBO.initDetail() --> "+ employeeDetailRptVO_p.getStrMsgString());
		  }
		  
	}
}
