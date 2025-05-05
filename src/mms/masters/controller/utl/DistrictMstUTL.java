package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 * @author Adil Wasi  
 * Creation Date:- 27-July-2011 
 * Modifying Date:- 
 * Used For:- 
 * Team Lead By:-  
 * Module:- DWH(HIS Project)
 * 
 */
public class DistrictMstUTL  implements MasterInterface
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
				.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) add(\"ADD\");'	onClick='add(\"ADD\");' ><span class='add'>Add</span></a>");
		strButtons
				.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) edit(\"MODIFY\");' onClick='edit(\"MODIFY\");' ><span class='modify'>Modify</span></a>");
		strButtons
				.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' onClick='deleteRecords(\"DELETE\");' ><span class='delete'>Delete</span></a>");
		strButtons
				.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' onClick='view(\"VIEWDATA\");' ><span class='view'>View</span></a>");
		strButtons
				.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  onClick='report(\"REPORT\");' ><span class='report'>Report</span></a>");

		return strButtons.toString();	
		}


	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() 
	{
		String[] columnHdr = { "District Name", "District Short Name" };
		return columnHdr;
	}

		
	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() 
	{
		String[] strComboHdr = {"0", "Country" ,"0", "State" , "1" , "Record Status" };
		return strComboHdr;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery()
	{		
		String[] strComboQuery = new String[3];
		String strHospitalCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		strComboQuery[0] = mms.qryHandler_mms.getQuery(1,"district.country.combo");
		strComboQuery[0] = strComboQuery[0].replace("?", strHospitalCode);
		
		strComboQuery[1] = mms.qryHandler_mms.getQuery(1,"district.state.combo.0");
		strComboQuery[1] = strComboQuery[1].replace("?", strHospitalCode);
				
		strComboQuery[2] = "1^Active#2^Inactive";
		
		return strComboQuery;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() 
	{		
		String[] strDeleteQuery = new String[1];
		String strSeatId = httpSession.getAttribute("SEATID").toString();
//		strSeatId="10001";
		strDeleteQuery[0] = mms.qryHandler_mms.getQuery(1, "districtMst.delete.0").replace("?", strSeatId);
		strDeleteQuery[0] = strDeleteQuery[0].concat(" WHERE " + mms.qryHandler_mms.getQuery(1, "districtMst.delete.cond.0"));

		return strDeleteQuery;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() 
	{
		return "../../mms/js/dwh_district_mst.js";
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb)
	{
		String strHospitalCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
//		strHospitalCode="101";
		StringBuffer brMainQuery = new StringBuffer();
		brMainQuery.append(mms.qryHandler_mms.getQuery(1, "districtMst.main")
				.replace("?", strHospitalCode)).append(" AND " + mms.qryHandler_mms.getQuery(1,"districtMst.main.cond.1").replace("?", "1"));
		
		
		if (cmb != null) 
		{

			if (!cmb[2].equals("0")) 
			{
				brMainQuery.replace(brMainQuery.lastIndexOf("1"), brMainQuery.lastIndexOf("1") + 1, cmb[2]);
			}
		}
		
		brMainQuery.append(" AND "+mms.qryHandler_mms.getQuery(1, "districtMst.main.cond.2").replace("?", "0"));
		if (cmb != null) 
		{

			if (!cmb[1].equals("0")) 
			{
				brMainQuery.replace(brMainQuery.lastIndexOf("0"), brMainQuery.lastIndexOf("0") + 1, cmb[1]);
			}
		}
			
			
		return brMainQuery.toString();
	}


	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName()
	{
		String strMasterName = "District Master";
		return strMasterName;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy()
	{
		String strOrderBy[] = { "1", " UPPER(STR_DIST_NAME) " ,"2", "UPPER(STR_DIST_ST_NAME) " };
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
		String strSearchField[] = { "1", "STR_DIST_NAME" };
		return strSearchField;
	}

	/* (non-Javadoc)
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader()
	{
		List<String> viewHdr = new ArrayList<String>();
		viewHdr.add("Country");
		viewHdr.add("D");
		viewHdr.add("State");
		viewHdr.add("D");
		viewHdr.add("District Name");
		viewHdr.add("D");
		viewHdr.add("District Short Name");
		viewHdr.add("D");
		viewHdr.add("Effective From");
		viewHdr.add("D");
		viewHdr.add("Effective To");
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
		String strViewQuery = mms.qryHandler_mms.getQuery(1,"districtMst.view");
		
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
