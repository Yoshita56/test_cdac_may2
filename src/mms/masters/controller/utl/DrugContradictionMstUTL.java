/**
 * 
 */
package mms.masters.controller.utl;

import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

import hisglobal.masterutil.MasterInterface;

/**
 * @author Niharika Srivastava Date : 20-08-10 Process : Drug Contradiction
 *         Master Module: MMS TL:Mr. Ajay Kumar Gupta Description : Utility
 *         Class For List Page of Drug Contradiction Master
 */
public class DrugContradictionMstUTL implements MasterInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The http session. */
	HttpSession httpSession = null;

	public String getButtons() {
		StringBuilder br = new StringBuilder();
		/*
		br.append("<a style=cursor:pointer><img style='cursor:pointer' src='../../hisglobal/images/btn-add.png' 	title='Add' 	tabindex='0' onKeyPress='if(event.keyCode==13) add(\"ADD\");' 				onClick='add(\"ADD\");'				></a>");
		br.append("<a style=cursor:pointer><img style='cursor:pointer' src='../../hisglobal/images/btn-mo.png' 		title='Modify'  tabindex='0' onKeyPress='if(event.keyCode==13) edit(\"MODIFY\");' 			onClick='edit(\"MODIFY\");'			></a>");
		br.append("<a style=cursor:pointer><img style='cursor:pointer' src='../../hisglobal/images/btn-del.png' 	title='Delete'  tabindex='0' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");'	onClick='deleteRecords(\"DELETE\");'></a>");
		br.append("<a style=cursor:pointer><img style='cursor:pointer' src='../../hisglobal/images/btn-view.png'	title='View'  	tabindex='0' onKeyPress='if(event.keyCode==13) contradicView();' 			onClick='contradicView();'			></a>");
		br.append("<a style=cursor:pointer><img style='cursor:pointer' src='../../hisglobal/images/btn-rpt.png' 	title='Reoprts'	tabindex='0' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  		onClick='report(\"REPORT\");'		></a>");
		*/
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) add(\"ADD\");' 				onClick='add(\"ADD\");'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) edit(\"MODIFY\");' 			onClick='edit(\"MODIFY\"););'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
				
		return br.toString();
	}

	public String[] getColsWidth() {
		return null;
	}

	public String[] getColumnHeader() {
		String[] columnHdr = { "Drug Name ", "Contradicted Drugs" };
		return columnHdr;
	}

	public String[] getComboHeader() {
		String[] comboHdr = { "1", " Record Status" };
		return comboHdr;

	}

	public String[] getComboQuery() {
		String[] comboQuery = new String[1];
		comboQuery[0] = "1^Active#2^In Active";
		return comboQuery;
	}

	public String[] getDeleteQuery() 
	{

		String[] delQuery = new String[1];
		String seatId = httpSession.getAttribute("SEATID").toString();
		delQuery[0] = mms.qryHandler_mms.getQuery(1,
				"delete.ContradictedDrug.0").replace("?", seatId);

		delQuery[0] = delQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1,
						"delete.ContradictedDrug.cond.0"));
		return delQuery;
	}

	public String getJsFiles() {
		String strJsFile = new String("../../mms/js/mms.js");
		return strJsFile;
	}

	public String getMainQuery(String[] cmb) {

		String strHosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;   httpSession.getAttribute("HOSPITAL_CODE").toString();

		StringBuffer brMainQuery = new StringBuffer();

		brMainQuery.append(
				mms.qryHandler_mms.getQuery(1, "select.ContradictedDrug.0")
						.replace("?", strHosCode)).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.ContradictedDrug.cond.0").replace("?",
								"1"));
		if (cmb != null) {
			if (!cmb[0].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, cmb[0]);
			}
		}

		return brMainQuery.toString();
	}

	public String getMasterName() {
		String strMasterName = "Drug Contradiction Master";
		return strMasterName;
	}

	public String[] getOrderBy() {
		String orderBy[] = { "1", "DRUG_NAME" };
		return orderBy;
	}

	public int getPage_per_block() {

		return 10;
	}

	public int getRecord_per_page() {

		return 10;
	}

	public String[] getSearchField() {
		String search_field[] = { "1", "DRUG_NAME" };
		return search_field;

	}

	public List<String> getViewHeader() {
		return null;
	}

	public String getViewQuery() {
		return null;
	}

	public boolean reportInterFaceRequired() {
		return false;
	}

	public void setHttpSession(HttpSession session) {
		httpSession = session;

	}
	public String isGlobal() {
		return "1";
	}

}
