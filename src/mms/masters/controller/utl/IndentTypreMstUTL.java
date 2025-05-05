package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class IndentTypreMstUTL.
 */
public class IndentTypreMstUTL implements MasterInterface {

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

		String masterName = " Indent Type Master ";
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {

		String[] columnHdr = { "Indent Type Name", "Indent Type Time/Unit",
				"Effective From" };
		return columnHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */
	public String[] getSearchField() {

		String search_field[] = { "1", "HSTSTR_INDENTTYPE_NAME" };
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

		//String[] comboHeader = { "0", "Drug Warehouse Type Name ", "1", " Record Status" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[4];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			comboHeader[0]="0";
			comboHeader[1]="Drug Warehouse Type Name";
			
		}else{
			comboHeader[0]="0";
			comboHeader[1]="Store Name";
		}
		comboHeader[2]="1";
		comboHeader[3]="Record Status";
		return comboHeader;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {

		String[] comboQuery = new String[2];
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		comboQuery[0] = mms.qryHandler_mms.getQuery(1,
				"select.Indenttype.storeTypeName.0");
		comboQuery[0] = comboQuery[0].replace("?", hosCode);
		comboQuery[1] = "1^Active#2^In Active";

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
				mms.qryHandler_mms.getQuery(1, "select.IndentType.0").replace(
						"?", hosCode)).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.IndentType.cond.1").replace("?", "1"));

		if (cmb != null) {

			if (!cmb[1].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, cmb[1]);

			}
		}

		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1, "select.IndentType.cond.2")
						.replace("?", "0"));

		if (cmb != null) {

			if (!cmb[0].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[0]);

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

		return mms.qryHandler_mms.getQuery(1, "select.indentType.1");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")){
			viewHdr.add("Drug Warehouse Type Name");
			viewHdr.add("D");
		}else{
			viewHdr.add("Store Type Name");
			viewHdr.add("D");
		}
		
		viewHdr.add("Indent Type Name");
		viewHdr.add("D");
		viewHdr.add("Indent Type Time");
		viewHdr.add("D");
		viewHdr.add("Indent Type Time Unit");
		viewHdr.add("D");
		viewHdr.add("Effective From ");
		viewHdr.add("D");
		viewHdr.add("Remarks ");
		viewHdr.add("D");
		viewHdr.add("Record Status ");
		viewHdr.add("D");

		return viewHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "1", "HSTSTR_INDENTTYPE_NAME" };
		return orderBy;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {

		String[] delQuery = new String[1];
		String seatId = httpSession.getAttribute("SEATID").toString();
		delQuery[0] = mms.qryHandler_mms.getQuery(1, "delete.IndentType.0")
				.replace("?", seatId);

		delQuery[0] = delQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1, "delete.IndentType.cond.0"));
		return delQuery;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() {

		StringBuilder br = new StringBuilder();

		br.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],3);' 	onClick='return callComboAdd(document.forms[0],3);' ><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],3);' onClick='return callComboModify(document.forms[0],3);' ><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");' ><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");' ><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");' ><span class='report'>Report</span></a>");

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
