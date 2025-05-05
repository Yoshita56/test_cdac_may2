package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class POComponentMstUTL. Modify By : Tanvi Sappal Modify Date :
 * 12/05/2010
 */
public class POComponentMstUTL implements MasterInterface {

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
/*		br.append("<img src='../../hisglobal/images/btn-add.png'	style='cursor: pointer;' tabindex='0' title='Add'		onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],8);'	onClick='return callComboAdd(document.forms[0],8);' />");
		br.append("<img src='../../hisglobal/images/btn-mo.png'		style='cursor: pointer;' tabindex='0' title='Modify'	onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],8);' onClick='return callComboModify(document.forms[0],8);' />");
		br.append("<img src='../../hisglobal/images/btn-del.png'	style='cursor: pointer;' tabindex='0' title='Delete'	onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");' />");
		br.append("<img src='../../hisglobal/images/btn-view.png'	style='cursor: pointer;' tabindex='0' title='View'		onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");' />");
		br.append("<img src='../../hisglobal/images/btn-rpt.png'	style='cursor: pointer;' tabindex='0' title='Reoprt'	onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");' />");
*/
		
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],8);'	onClick='return callComboAdd(document.forms[0],8);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],8);' onClick='return callComboModify(document.forms[0],8);'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
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
		String col_header[] = { "Component Type", " Component Name",
				"Effective From" };
		return col_header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		String[] comboHeader = { "1", "Component Type", "1", "Record Status" };
		return comboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		// String hosCode =
		// httpSession.getAttribute("HOSPITAL_CODE").toString();
		String[] comboQuery = new String[3];
		comboQuery[0] = ("0^Select Value#1^Drugs and Dressing#2^Local Purchase#3^Imported");
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

		String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;

		StringBuffer brMainQuery = new StringBuffer();
		brMainQuery.append(mms.qryHandler_mms.getQuery(1,
				"select.processComponentMst.0"));

		/*
		 * if (cmb != null) {
		 * 
		 * if (!cmb[1].equals("0")) {
		 * brMainQuery.replace(brMainQuery.lastIndexOf("0"), brMainQuery
		 * .lastIndexOf("0") + 1, cmb[1]); //
		 * httpSession.setAttribute("isvalid", cmb[1]); } }
		 */
		brMainQuery.append(" WHERE "
				+ mms.qryHandler_mms.getQuery(1,
						"select.processComponentMst.cond.2").replace("?", "0"));
		if (cmb != null) {
			if (!cmb[0].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[0]);
			}

			/*
			 * if (!cmb[1].equals("0")) { brMainQuery.append(" And " +
			 * mms.qryHandler_mms.getQuery(1,
			 * "select.processComponentMst.cond.3").replace( "?", cmb[1]));
			 * 
			 * }
			 */
			if (!cmb[1].equals("0")) {
				brMainQuery.append(" And "
						+ mms.qryHandler_mms.getQuery(1,
								"select.processComponentMst.cond.1").replace(
								"?", cmb[1]));

			}

			brMainQuery.append(" And "
					+ mms.qryHandler_mms.getQuery(1,
							"select.processComponentMst.cond.0").replace("?",
							hosCode));
		}

		System.out.println("brMainQuery.toString()-"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {
		String masterName = " PO Component Master ";
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "2", "C.COMPONENT_NAME" };
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
		viewHdr.add("Component Type");
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
		return false;
	}
	public String isGlobal() {
		return "1";
	}

}
