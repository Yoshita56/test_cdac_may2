package mms.masters.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

import hisglobal.hisconfig.Config;
import hisglobal.masterutil.MasterInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentAuthorizationMstUTL.
 */
public class IndentAuthorizationMstUTL implements MasterInterface {

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

		String masterName = " Indent Authorization Master ";
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {

		String[] columnHdr = { "Authorization No", "Employee Name", "Level",
				"Effective Date" };
		return columnHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */
	public String[] getSearchField() {

		String search_field[] = { "1", "HSTNUM_AUTH_NO" };
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

		//String[] comboHeader = { "0", "Drug Warehouse Name ", "0", "Item Category", "0","Authorization For", "0", "Type", "1", " Record Status" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[10];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	
			comboHeader[0] = "0";
			comboHeader[1] = "Drug Warehouse Name";
			comboHeader[2] = "0";
			comboHeader[3] = "Drug Category";
		}
		else
		{
			comboHeader[0] = "0";
			comboHeader[1] = "Store Name";
			comboHeader[2] = "0";
			comboHeader[3] = "Item Category";
		}
		comboHeader[4] = "0";
		comboHeader[5] = "Authorization For";
		comboHeader[6] = "0";
		comboHeader[7] = "Type";
		comboHeader[8] = "1";
		comboHeader[9] = "Record Status";
		
		
		return comboHeader;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {

		String[] comboQuery = new String[5];
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		comboQuery[0] = mms.qryHandler_mms.getQuery(1,
				"select.indentauthorization.storeName.0");
		comboQuery[0] = comboQuery[0].replace("?", hosCode);
		comboQuery[1] = mms.qryHandler_mms.getQuery(1,
				"select.indentauthorization.ItemCategory.0");
		comboQuery[1] = comboQuery[1].replace("?", Config.SUPER_USER_HOSPITAL_CODE);
		comboQuery[2] = mms.qryHandler_mms.getQuery(1,
				"select.indentauthorization.AuthorizationFor.0");
		comboQuery[2] = comboQuery[2].replace("?", hosCode);
		comboQuery[3] = mms.qryHandler_mms.getQuery(1,
				"select.indentauthorization.type.0");
		comboQuery[3] = comboQuery[3].replace("?", hosCode);
		comboQuery[4] = "1^Active#2^InActive";

		return comboQuery;

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
				mms.qryHandler_mms.getQuery(1, "select.IndentAuthorization.0")
						.replace("?", hosCode)).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.IndentAuthorization.cond.1").replace(
								"?", "1"));

		if (cmb != null) {

			if (!cmb[4].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, cmb[4]);

			}
		}

		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1,
						"select.IndentAuthorization.cond.2").replace("?", "0"));

		if (cmb != null) {

			if (!cmb[0].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[0]);

			}

		}

		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1,
						"select.IndentAuthorization.cond.3").replace("?", "0"));

		if (cmb != null) {

			if (!cmb[1].equals("0")) {

				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[1]);

			}

		}
		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1,
						"select.IndentAuthorization.cond.4").replace("?", "0"));

		if (cmb != null) {

			if (!cmb[2].equals("0")) {

				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[2]);

			}

		}
		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1,
						"select.IndentAuthorization.cond.5").replace("?", "0"));

		if (cmb != null) {

			if (!cmb[3].equals("0")) {

				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[3]);

			}

		}

		return brMainQuery.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {

		return mms.qryHandler_mms.getQuery(1, "select.IndentAuthorization.1");
		// return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			viewHdr.add("Drug Warehouse Name");
			viewHdr.add("D");
			viewHdr.add("Category ");
			viewHdr.add("D");
		}else{
			viewHdr.add("Store");
			viewHdr.add("D");
			viewHdr.add("Item Category ");
			viewHdr.add("D");
		}
		
		viewHdr.add("Authorization For");
		viewHdr.add("D");
		viewHdr.add("Type");
		viewHdr.add("D");
		viewHdr.add("Authorization No.");
		viewHdr.add("D");
		viewHdr.add("Employee Name");
		viewHdr.add("D");
		viewHdr.add("Level");
		viewHdr.add("D");
		viewHdr.add("Remarks");
		viewHdr.add("D");
		viewHdr.add("Effective From");
		viewHdr.add("D");
		viewHdr.add("Record Status");
		viewHdr.add("D");

		return viewHdr;
		// return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "1", "HSTNUM_AUTH_NO", "2", "EMPLOYEE_NAME" };
		return orderBy;
		// return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {

		String[] delQuery = new String[1];
		String seatId = httpSession.getAttribute("SEATID").toString();

		delQuery[0] = mms.qryHandler_mms.getQuery(1,
				"delete.indentauthorization.0").replace("?", seatId);

		delQuery[0] = delQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1,
						"delete.indentauthorization.cond.0"));

		return delQuery;
		// return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() {

		StringBuilder br = new StringBuilder();

		br.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return indentAuthorizationComboAdd(document.forms[0]);' 		onClick='return indentAuthorizationComboAdd(document.forms[0]);' ><span class='add'>Add</span></a>");
		br.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return indentAuthorizationComboModify(document.forms[0]);'	onClick='return indentAuthorizationComboModify(document.forms[0]);' ><span class='modify'>Modify</span></a>");
		br.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 									onClick='deleteRecords(\"DELETE\");' ><span class='delete'>Delete</span></a>");
		br.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 											onClick='view(\"VIEWDATA\");' ><span class='view'>View</span></a>");
		br.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  										onClick='report(\"REPORT\");' ><span class='report'>Report</span></a>");

		return br.toString();
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
