package mms.masters.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

import hisglobal.masterutil.MasterInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class CommitteeTypeMstUTL.
 */
public class CommitteeTypeMstUTL implements MasterInterface {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The http session. */
	HttpSession httpSession = null;
	public HttpServletRequest request = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() {
		StringBuilder br = new StringBuilder();
		/*br.append("<a style=cursor:pointer><img style='cursor:pointer' src='../../hisglobal/images/btn-add.png'		title='Add'		tabindex='0' onKeyPress='if(event.keyCode==13) add(\"ADD\")'				onClick='add(\"ADD\")'				></a>");
		br.append("<a style=cursor:pointer><img style='cursor:pointer' src='../../hisglobal/images/btn-mo.png'		title='Modify'	tabindex='0' onKeyPress='if(event.keyCode==13) edit(\"MODIFY\")'			onClick='edit(\"MODIFY\")' 			></a>");
		br.append("<a style=cursor:pointer><img style='cursor:pointer' src='../../hisglobal/images/btn-del.png'		title='Delete'	tabindex='0' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\")'	onClick='deleteRecords(\"DELETE\")'	></a>");
		br.append("<a style=cursor:pointer><img style='cursor:pointer' src='../../hisglobal/images/btn-view.png'	title='View'	tabindex='0' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\")'			onClick='view(\"VIEWDATA\")'		></a>");
		br.append("<a style=cursor:pointer><img style='cursor:pointer' src='../../hisglobal/images/btn-rpt.png'		title='Reoprts'	tabindex='0' onKeyPress='if(event.keyCode==13) report(\"REPORT\")'			onClick='report(\"REPORT\")'		></a>");
		*/

		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) add(\"ADD\");' 				onClick='add(\"ADD\");'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) edit(\"MODIFY\");' 			onClick='edit(\"MODIFY\");'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 	onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String col_header[] = { "Committee Type Name", "Committee Purpose",
				"Effective From" };
		return col_header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		String[] comboHeader = { "1", "Record Status" };
		return comboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		String[] comboQuery = new String[1];
		// String hosCode =
		// httpSession.getAttribute("HOSPITAL_CODE").toString();
		// String strCatCodes="";

		// //System.out.println("comboQuery[0]-"+comboQuery[0]);

		/*
		 * comboQuery[0] = mms.qryHandler_mms.getQuery(1,
		 * "select.CommitteeType.RequestType.0").replace("?", "" + hosCode +
		 * "");
		 */
		comboQuery[0] = "1^Active#2^Inactive";
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
				"delete.CommitteeTypeMst.0").replace("?", seatId);
		deleteQuery[0] = deleteQuery[0].concat("  where "
				+ mms.qryHandler_mms.getQuery(1,
						"delete.CommitteeTypeMst.cond.0"));
		// deleteQuery[0] =
		// mms.qryHandler_mms.getQuery(1,"delete.CommitteeTypeMst.0");
		return deleteQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {
		String jsFile = new String("../../mms/js/mms.js");
		return jsFile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb) {
		//String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		StringBuffer brMainQuery = new StringBuffer(500);
		brMainQuery.append(
				mms.qryHandler_mms.getQuery(1, "select.CommitteeTypeMst.0")
						.replace("?", "" + hosCode + "")).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.CommitteeTypeMst.cond.0").replace("?",
								"1"));

		if (cmb != null) {
			if (!cmb[0].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, cmb[0]);
			}
		}

		/*
		 * brMainQuery.append(" AND " + mms.qryHandler_mms.getQuery(1,
		 * "select.CommitteeTypeMst.cond.2").replace("?", "0")); if (cmb !=
		 * null) { if (!cmb[0].equals("0")) {
		 * brMainQuery.replace(brMainQuery.lastIndexOf("0"), brMainQuery
		 * .lastIndexOf("0") + 1, cmb[0]);
		 * httpSession.setAttribute("strProcessId", cmb[0]); } }
		 */

		return brMainQuery.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {
		String masterName = "Committee Type Master";
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {
		String orderBy[] = { "1", "HSTNUM_COMMITTEE_TYPE_NAME" };
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
		String search_field[] = { "1", "HSTNUM_COMMITTEE_TYPE_NAME" };
		return search_field;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {
		List<String> viewHdr = new ArrayList<String>();
		viewHdr.add("Committee Type Name");
		viewHdr.add("D");
		viewHdr.add("Commitee Purpose");
		viewHdr.add("D");
		viewHdr.add("Remarks");
		viewHdr.add("D");
		viewHdr.add("Effective From");
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
				"select.CommitteeTypeMst.1");
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
		return false;
	}

	public String isGlobal() {
		return "1";
	}
}
