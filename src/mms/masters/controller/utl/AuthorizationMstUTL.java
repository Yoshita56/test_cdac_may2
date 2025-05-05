package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class AuthorizationMstUTL.
 */
public class AuthorizationMstUTL implements MasterInterface {

	public String[] getColsWidth() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean reportInterFaceRequired() {
		// TODO Auto-generated method stub
		return true;
	}

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

		br.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],1);' onClick='return callComboAdd(document.forms[0],1);'><span class='add'>Add</span></a>");
		br.append("<a href='#'  class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],1);' onClick='return callComboModify(document.forms[0],1);' ><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary'  onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' onClick='view(\"VIEWDATA\");'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) report(\"REPORT\");' onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");

		return br.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String strColHeader[] = { "Auth Type", "User Name", "Auth Level","Effective From" };

		return strColHeader;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		//String comboHeader[] = { "0", "Drug Warehouse Name", "1", "Record Status" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[4];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			comboHeader[0] = "0";
			comboHeader[2] = "Drug WareHouse Name";
			comboHeader[3] = "1";
			comboHeader[4] = "Record Status";
			

		}
		else
		{
			comboHeader[0] = "0";
			comboHeader[2] = "Store Name";
			comboHeader[3] = "1";
			comboHeader[4] = "Record Status";
		}
		return comboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		String comboQuery[] = new String[2];
		String strHospitalCode = httpSession.getAttribute("HOSPITAL_CODE")
				.toString();

		comboQuery[0] = mms.qryHandler_mms
				.getQuery(1, "select.authorization.2").replace("?",
						strHospitalCode);
		comboQuery[1] = "1^Active#2^Inactive";

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
				"delete.authorization.0").replace("?", seatId);
		deleteQuery[0] = deleteQuery[0]
				.concat("  where "
						+ mms.qryHandler_mms.getQuery(1,
								"delete.authorization.cond.0"));
		// deleteQuery[0] =
		// mms.qryHandler_mms.getQuery(1,"delete.authorization.0");
		return deleteQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {
		String js = "../../mms/js/mms.js";
		return js;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String strCmb[]) {

		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		StringBuffer brMainQuery = new StringBuffer(500);
		brMainQuery.append(
				mms.qryHandler_mms.getQuery(1, "select.authorization.0")
						.replace("?", hosCode)).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.authorization.cond.0")
								.replace("?", "1"));

		if (strCmb != null) {

			if (!strCmb[0].equals("0")) {

				String str[] = strCmb[0].replace("^", "#").split("#");

				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, str[0]);

			}

			if (!strCmb[1].equals("0")) {

				brMainQuery.append(" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.authorization.cond.1").replace("?",
								strCmb[1]));

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
		String strMasterName = "Authorization Master";

		return strMasterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "1", "C.AUTH_TYPE_NAME", "2", "C.USER_NAME" };
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
		String search_field[] = { "1", "C.AUTH_TYPE_NAME", "2", "C.USER_NAME" };
		return search_field;

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
		}else{
			viewHdr.add("Store Name");
			viewHdr.add("D");
		}
		
		viewHdr.add("Authorization Name");
		viewHdr.add("D");
		viewHdr.add("Authorization Level");
		viewHdr.add("D");
		viewHdr.add("User Name");
		viewHdr.add("D");
		viewHdr.add("Effective From");
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
				"select.authorization.1");
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
	public String isGlobal() {
		return "1";
	}

}
