package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

/**
* The Class LabMstUTL.
*/
public class LabMstUTL implements MasterInterface{
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The http session. */
	HttpSession httpSession = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#setHttpSession(javax.servlet.http
	 * .HttpSession)
	 */
	public void setHttpSession(HttpSession session) {

		httpSession = session;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {

		String masterName = "Lab Master";
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {

		String[] columnHdr = { "Lab No", "Lab Name","Phone No", "Fax No" };
		return columnHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */
	public String[] getSearchField() {

		String search_field[] = { "1", "HSTSTR_USER_LABNO","2","HSTSTR_LAB_NAME" };
		return search_field;

		// return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getRecord_per_page()
	 */
	public int getRecord_per_page() {

		return 10;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getPage_per_block()
	 */
	public int getPage_per_block() {

		return 10;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {

		String[] strColumnHdr = {"1" , "Record Status"};
		return strColumnHdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		String[] strComboQuery = new String[1];
		strComboQuery[0] = "1^Active#2^InActive";
		return strComboQuery;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb) {
		StringBuffer brMainQuery = new StringBuffer();
		String strHosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		strHosCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		
		brMainQuery.append(mms.qryHandler_mms.getQuery(1, "labMst.main").replace("?", strHosCode));
		
		if (cmb != null) 
		{

			brMainQuery.append(" AND "+ mms.qryHandler_mms.getQuery(1, "labMst.main.cond.1").replace("?",cmb[0]));
		}
		else
		{
			brMainQuery.append(" AND " + mms.qryHandler_mms.getQuery(1, "labMst.main.cond.1").replace("?","1"));
		}
//		//System.out.println("Main Query==>"+brMainQuery.toString());
		return brMainQuery.toString();

	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {

		return mms.qryHandler_mms.getQuery(1, "labMst.view");
	}


	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "1", "HSTSTR_LAB_NAME", "2","HSTSTR_USER_LABNO" };
		return orderBy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {
		String[] deleteQuery = new String[1];
		//String strHospitalCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		String strSeatId = httpSession.getAttribute("SEATID").toString();
		deleteQuery[0] = mms.qryHandler_mms
				.getQuery(1, "lab.delete.0").replace("?", strSeatId);
		deleteQuery[0] = deleteQuery[0].concat("  where "
				+ mms.qryHandler_mms.getQuery(1, "lab.delete.cond.0"));

		return deleteQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() {
		StringBuilder strButtons = new StringBuilder();
		
		strButtons.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) add(\"ADD\");' onClick='add(\"ADD\");' ><span class='add'>Add</span></a>");
		strButtons.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) edit(\"MODIFY\");' onClick='edit(\"MODIFY\");' ><span class='modify'>Modify</span></a>");
		strButtons.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' onClick='deleteRecords(\"DELETE\");' ><span class='delete'>Delete</span></a>");
		strButtons.append("<a href='#' class='btn btn-sm btn-primary'  onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' onClick='view(\"VIEWDATA\");' ><span class='view'>View</span></a>");
		strButtons.append("<a href='#' class='btn btn-sm btn-primary'  onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  onClick='report(\"REPORT\");' ><span class='report'>Report</span></a>");

		return strButtons.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {
		String jsFile = new String("");
		return jsFile;
		 //return null;

	}

	public String[] getColsWidth() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean reportInterFaceRequired() {

		return true;
	}

	public List<String> getViewHeader() {
		List<String> viewHdr = new ArrayList<String>();
		
		viewHdr.add("lab Name");
		viewHdr.add("D");
		viewHdr.add("Lab No");
		viewHdr.add("D");
		viewHdr.add("Lab Type");
		viewHdr.add("D");
		viewHdr.add("lab Address");
		viewHdr.add("D");
		viewHdr.add("Phone No");
		viewHdr.add("D");
		viewHdr.add("Fax No");
		viewHdr.add("D");
		viewHdr.add("Record Status");
		viewHdr.add("D");
		
		return viewHdr;		
	}
	public String isGlobal() {
		return "1";
	}

}
