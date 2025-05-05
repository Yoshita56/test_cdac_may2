package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemParameterMstUTL.
 */
public class ItemParameterMstUTL implements MasterInterface {

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

		/*
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-add.png' 	style='cursor:pointer;' title='Add' 	tabindex='0' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],10);' 		onClick='return callComboAdd(document.forms[0],10);'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-mo.png' 	style='cursor:pointer;' title='Modify'  tabindex='0' onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],10);' 	onClick='return callComboModify(document.forms[0],10);' ></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-del.png' 	style='cursor:pointer;' title='Delete'  tabindex='0' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 				        onClick='deleteRecords(\"DELETE\");'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-view.png' 	style='cursor:pointer;' title='View'  	tabindex='0' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-rpt.png' 	style='cursor:pointer;' title='Report'  tabindex='0' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  							onClick='report(\"REPORT\");'></a>");
			*/
		
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],10);' 		onClick='return callComboAdd(document.forms[0],10);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],10);' 	onClick='return callComboModify(document.forms[0],10);' ><span class='modify'>Modify</span></a>");
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
		String strColHeader[] = { "  Parameter Name", " Parent Parameter Name",
				"Effective From" };

		return strColHeader;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {

		String comboHeader[] = { "0", "Item Category", "1", "Record Status" };
		return comboHeader;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {

		String comboQuery[] = new String[2];
		String strHospitalCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		//String strSeatId = httpSession.getAttribute("SEATID").toString();

		String strCatCodes = "";
		if (httpSession.getAttribute("USERVALUE").toString() != null) {
			strCatCodes = httpSession.getAttribute("USERVALUE").toString();
		} else {
			strCatCodes = "0";
		}

		comboQuery[0] = mms.qryHandler_mms.getQuery(1,
				"select.itemparameter.ItemCategory.0").replace("?",
				strHospitalCode);

		/*comboQuery[0] = comboQuery[0].concat(mms.qryHandler_mms.getQuery(1,
				"select.itemparameter.ItemCategory.cond.0"));
		comboQuery[0] = comboQuery[0].replace("?", strSeatId);*/

	/*	comboQuery[0] = comboQuery[0].concat(mms.qryHandler_mms.getQuery(1,
				"select.itemparameter.ItemCategory.cond.1"));
		comboQuery[0] = comboQuery[0].replace("?", strCatCodes);*/

		////System.out.println("comboQuery[0]-"+comboQuery[0]);

		comboQuery[1] = "1^Active#2^Inactive";

		return comboQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {
		//String deleteQuery[] = new String[2];
		String deleteQuery[] = new String[1];
		String seatId = httpSession.getAttribute("SEATID").toString();
		// String seatId = "107";
		deleteQuery[0] = mms.qryHandler_mms.getQuery(1,
				"delete.itemparameter.0").replace("?", seatId);
		deleteQuery[0] = deleteQuery[0]
				.concat("  where "
						+ mms.qryHandler_mms.getQuery(1,
								"delete.itemparameter.cond.0"));

		/*deleteQuery[1] = mms.qryHandler_mms.getQuery(1,
				"delete.itemparameter.0").replace("?", seatId);
		deleteQuery[1] = deleteQuery[1]
				.concat("  where "
						+ mms.qryHandler_mms.getQuery(1,
								"delete.itemparameter.cond.1"));*/
		//System.out.println("deleteQuery item param mst-->"+deleteQuery[0]);
		////System.out.println("deleteQuery item param mst-->"+deleteQuery[1]);
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

		// String strHospitalCode = "108";

		String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;

		StringBuffer brMainQuery = new StringBuffer(500);
		brMainQuery.append(
				mms.qryHandler_mms.getQuery(1, "select.itemparameter.0")
						.replace("?", hosCode)).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.itemparameter.cond.1")
								.replace("?", "1"));

		if (strCmb != null) {
			if (!strCmb[1].equals("0")) {

				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, strCmb[1]);
				// httpSession.setAttribute("strStoreTypeId", strCmb[1]);
			}
		}
		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1, "select.itemparameter.cond.0")
						.replace("?", "0"));

		if (strCmb != null) {

			if (!strCmb[0].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, strCmb[0]);

			}
		}
		/*
		 * if (!strCmb[0].equals("0")) {
		 * 
		 * //// //System.out.println("cmb : "+strCmb[0]);
		 * 
		 * String str[] = strCmb[0].replace("^", "#").split("#");
		 * 
		 * brMainQuery.replace(brMainQuery.lastIndexOf("1"), brMainQuery
		 * .lastIndexOf("1") + 1, str[0]); }
		 */
		////System.out.println("main query item parameter :: "+brMainQuery.toString());
		return brMainQuery.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {
		String strMasterName = "Item Parameter Master";

		return strMasterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "1", "HSTNUM_ITEM_PARAM_NAME" };
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

		String search_field[] = { "1", "HSTNUM_ITEM_PARAM_NAME" };
		return search_field;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {
		List<String> viewHdr = new ArrayList<String>();

		viewHdr.add("Item Category Name");
		viewHdr.add("D");
		viewHdr.add("Parameter Name");
		viewHdr.add("D");
		viewHdr.add("Parent Parameter Name");
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

		return mms.qryHandler_mms.getQuery(1, "select.itemparameter.3");
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
