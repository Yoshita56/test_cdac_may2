package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

/**
 * @author Vivek Aggarwal  
 * Creation Date:- 6-June-2011 
 * Modifying Date:- 3-June-2011
 * Used For:- 
 * Team Lead By:-  
 *  Module:- DWH(HIS Project)
 * 
 */
public class EmployeeDetailMstUTL  implements MasterInterface
{
	/* 
	 * The Constant serialVersionUID. 
	 */
	private static final long serialVersionUID = 02L;

	/*	
	 * The http session.
	 */
	HttpSession httpSession = null;
	

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#setHttpSession(javax.servlet.http.HttpSession)
	 */
	public void setHttpSession(HttpSession session)
	{		
			httpSession = session;		
	}
	
	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() 
	{		
		StringBuilder strButtons = new StringBuilder();
		strButtons
				.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) add(\"ADD\");'	onClick='add(\"ADD\");' ><span class='add'>Add</span></a>");
		strButtons
				.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) edit(\"MODIFY\");' onClick='edit(\"MODIFY\");' ><span class='modify'>Modify</span></a>");
		strButtons
				.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' onClick='deleteRecords(\"DELETE\");' ><span class='delete'>Delete</span></a>");
		strButtons
				.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) viewData(document.forms[0]);' onClick='viewData(document.forms[0]);' ><span class='view'>View</span></a>");
		strButtons
				.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  onClick='report(\"REPORT\");' ><span class='report'>Report</span></a>");

		return strButtons.toString();	
		}


	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() 
	{
		String[] columnHdr = { "Employee Code", "Employee Name", "Designation","Father Name" };
		return columnHdr;
	}

		
	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() 
	{
		String[] strColumnHdr = {"1" , "Record Status" };
		return strColumnHdr;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery()
	{		
		String[] strComboQuery = new String[1];
//		String strHospitalCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
				
		strComboQuery[0] = "1^Active#2^Inactive";
		
		return strComboQuery;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() 
	{		
		String[] strDeleteQuery = new String[2];
		String strSeatId = httpSession.getAttribute("SEATID").toString();
		strDeleteQuery[0] = mms.qryHandler_mms.getQuery(1, "employeeDetailMst.delete.0").replace("?", strSeatId);
		strDeleteQuery[0] = strDeleteQuery[0].concat(" WHERE " + mms.qryHandler_mms.getQuery(1, "employeeDetailMst.delete.cond.0"));

		strDeleteQuery[1] = mms.qryHandler_mms.getQuery(1, "employeeDetailMst.delete.1").replace("?", strSeatId);
		strDeleteQuery[1] = strDeleteQuery[1].concat(" WHERE " + mms.qryHandler_mms.getQuery(1, "employeeDetailMst.delete.cond.1"));
		
		return strDeleteQuery;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() 
	{
		return "../../mms/js/dwh_employeeDetail_mst.js";
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb)
	{
		String strHospitalCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		StringBuffer brMainQuery = new StringBuffer();
		brMainQuery.append(mms.qryHandler_mms.getQuery(1, "employeeDetailMst.main")
				.replace("?", strHospitalCode)).append(" AND " + mms.qryHandler_mms.getQuery(1,"employeeDetailMst.main.cond.1").replace("?", "1"));
		
	
			
		if (cmb != null)
		{	
			if (!cmb[0].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("1"), brMainQuery.lastIndexOf("1") + 1, cmb[0]);
			
			}		
		}	
		return brMainQuery.toString();
	}


	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName()
	{
		String strMasterName = "Employee Detail Master";
		return strMasterName;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy()
	{
		String strOrderBy[] = { "1", "UPPER(STR_EMP_CODE)" ,"2","MMS_MST.GET_EMP_NAME(GNUM_HOSPITAL_CODE,STR_EMP_NO)","3","MMS_MST.GET_DESIGNATION_NAME (GNUM_HOSPITAL_CODE,NUM_DESIG_ID)", "4", "UPPER(STR_FATHER_NAME)" };
		return strOrderBy;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getPage_per_block()
	 */
	public int getPage_per_block() 
	{
		return 10;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getRecord_per_page()
	 */
	public int getRecord_per_page()
	{		
		return 10;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */	
	public String[] getSearchField()
	{
		String strSearchField[] = { "1", "STR_EMP_CODE" };
		return strSearchField;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader()
	{
		List<String> viewHdr = new ArrayList<String>();
//	     Employee Name (First, Middle, Last with salutation)
			
		viewHdr.add("Employee Code");
		viewHdr.add("D");
		viewHdr.add("Employee Name");
		viewHdr.add("D");
		viewHdr.add("Gender");
		viewHdr.add("D");
		viewHdr.add("Father Name");
		viewHdr.add("D");
		viewHdr.add("Mother Name");
		viewHdr.add("D");
		viewHdr.add("Spouse Name");
		viewHdr.add("D");
		viewHdr.add("Birth Date");
		viewHdr.add("D");
		viewHdr.add("Designation");
		viewHdr.add("D");
		viewHdr.add("Joining Date");
		viewHdr.add("D");
		
		viewHdr.add("Permanent Address");
		viewHdr.add("D");
		viewHdr.add("Local Address");
		viewHdr.add("D");
		viewHdr.add("Phone No.");
		viewHdr.add("D");
		viewHdr.add("Mobile No.");
		viewHdr.add("D");
		viewHdr.add("Fax No.");
		viewHdr.add("D");
		
		viewHdr.add("S. No.");
		viewHdr.add("D");
		viewHdr.add("Dependent Name");
		viewHdr.add("D");
		viewHdr.add("Age(Year)");
		viewHdr.add("D");
		viewHdr.add("Relationship");
		viewHdr.add("D");

		viewHdr.add("Service Doc No.");
		viewHdr.add("D");
		viewHdr.add("Service Doc Date");
		viewHdr.add("D");
		viewHdr.add("Remarks");
		viewHdr.add("D");
		
		viewHdr.add("Record Status");
		viewHdr.add("D");
		
		return viewHdr;
	}


	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery()
	{		
		String strViewQuery = mms.qryHandler_mms.getQuery(1,"employeeDetailMst.view");
		
		return strViewQuery;
	}

	public String[] getColsWidth() {

		return null;
	}
	
	public boolean reportInterFaceRequired() {

		return true;
	}
	public String isGlobal() {
		return "1";
	}

}

