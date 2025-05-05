package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

// TODO: Auto-generated Javadoc
/**
 * The Class ProcessComponentMstUTL.
 */
public class ProcessComponentMstUTL implements MasterInterface {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The http session. */
	HttpSession httpSession = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() {

		StringBuilder br = new StringBuilder();
		br.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],8);'	onClick='return callComboAdd(document.forms[0],8);' ><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],8);' onClick='return callComboModify(document.forms[0],8);' ><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' 	onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");' ><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");' ><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  onClick='report(\"REPORT\");' ><span class='report'>Report</span></a>");

		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String col_header[] = { "Process Name", " Component Name",
				"Effective From" };
		return col_header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		String[] comboHeader = { "0", "Process Name", "1", "Record Status" };
		return comboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		String[] comboQuery = new String[2];
		comboQuery[0] = mms.qryHandler_mms.getQuery(1,
				"select.processComponentMst.4").replace("?", hosCode);
		comboQuery[1] = ("1^Active#2^Inactive");
		httpSession.setAttribute("isvalid", "1");
		return comboQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {
		String[] deleteQuery = new String[1];
		String seatId = httpSession.getAttribute("SEATID").toString();
		deleteQuery[0] = mms.qryHandler_mms.getQuery(1,
				"delete.processComponentMst.0").replace("?", seatId);
		deleteQuery[0] = deleteQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1,
						"delete.processComponentMst.cond.0"));

		return deleteQuery;
		// return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {
		String jsFile = new String("../../mms/js/mms.js");
		return jsFile;
		// return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb) {

		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		StringBuffer brMainQuery = new StringBuffer();
		brMainQuery.append(
				mms.qryHandler_mms.getQuery(1, "select.processComponentMst.0")
						.replace("?", hosCode)).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.processComponentMst.cond.2").replace(
								"?", "0"));
		if (cmb != null) {

			if (!cmb[0].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[0]);
				// httpSession.setAttribute("isvalid", cmb[1]);
			}
			if (!cmb[1].equals("0")) {
				brMainQuery.append(" And "
						+ mms.qryHandler_mms.getQuery(1,
								"select.processComponentMst.cond.1").replace(
								"?", cmb[1]));

			}
		}
		return brMainQuery.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {
		String masterName = " Process Component Master ";
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "1", "C.PROCESS_NAME" };
		return orderBy;
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
	 * @see hisglobal.masterutil.MasterInterface#getRecord_per_page()
	 */
	public int getRecord_per_page() {
		return 10;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */
	public String[] getSearchField() {

		String search_field[] = { "2", "C.COMPONENT_NAME" };
		return search_field;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {
		List<String> viewHdr = new ArrayList<String>();
		viewHdr.add("Process Name");
		viewHdr.add("D");
		viewHdr.add("Component Name");
		viewHdr.add("D");
		viewHdr.add("Component Value1");
		viewHdr.add("D");
		viewHdr.add("Component Value2");
		viewHdr.add("D");
		viewHdr.add("Effective From");
		viewHdr.add("D");
		viewHdr.add("Remarks");
		viewHdr.add("D");
		viewHdr.add("Record Status");
		viewHdr.add("D");
		return viewHdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {
		String viewQuery = mms.qryHandler_mms.getQuery(1,
				"select.processComponentMst.1");
		return viewQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#setHttpSession(javax.servlet.http
	 * .HttpSession)
	 */
	public void setHttpSession(HttpSession session) {
		this.httpSession = session;
	}

	public String[] getColsWidth() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean reportInterFaceRequired() {
		// TODO Auto-generated method stub
		return true;
	}
	public String isGlobal() {
		return "1";
	}
}
