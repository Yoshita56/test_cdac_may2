package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericDrugMstUTL.
 */
public class GenericDrugMstUTL implements MasterInterface {

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
		/*br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-add.png'	tabindex='0' title='Add'	style='cursor: pointer;' onKeyPress='if(event.keyCode==13) addDrugMst();'				onClick='addDrugMst();'				></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-mo.png'		tabindex='0' title='Modify' style='cursor: pointer;' onKeyPress='if(event.keyCode==13) ModifyDrugMst();'			onClick='ModifyDrugMst();' 			></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-del.png'	tabindex='0' title='Delete'	style='cursor: pointer;' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");'	onClick='deleteRecords(\"DELETE\");'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-view.png'	tabindex='0' title='View'	style='cursor: pointer;' onKeyPress='if(event.keyCode==13) genericDrugView();'			onClick='genericDrugView();'		></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-rpt.png'	tabindex='0' title='Reoprt'	style='cursor: pointer;' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'			onClick='report(\"REPORT\");'		></a>");
*/
		
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) addDrugMst();'				onClick='addDrugMst();'	'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) ModifyDrugMst();'			onClick='ModifyDrugMst();' 	><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");'	onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) genericDrugView();'			onClick='genericDrugView();'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'			onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String col_header[] = {  "Generic Drug Name",
				"Inventory Unit", "Effective From" };
		return col_header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		String[] comboHeader = { "0", "Group Name", "0", "SubGroupName", "1",
				"Record Status" };
		return comboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		String[] comboQuery = new String[3];
		comboQuery[0] = mms.qryHandler_mms.getQuery(1, "select.drug.1");
		comboQuery[1] = mms.qryHandler_mms.getQuery(1, "select.drug.2");
		comboQuery[2] = "1^Active#0^In Active";
		return comboQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {
		String[] strDelQuery = new String[2];
		strDelQuery[0] = mms.qryHandler_mms.getQuery(1, "delete.drug.0");
		String seatId = httpSession.getAttribute("SEATID").toString();
		////System.out.println(strDelQuery);
	//	strDelQuery[1] = mms.qryHandler_mms.getQuery(1, "delete.drug.billing");
		
		strDelQuery[1] = mms.qryHandler_mms.getQuery(1, "delete.drug.billing.2")
				.replace("?", seatId);
		strDelQuery[1] = strDelQuery[1].concat("  where "
				+ mms.qryHandler_mms.getQuery(1, "delete.drug.billing.cond.1"));
		
		
		
	//System.out.println(strDelQuery[1]);
		return strDelQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {

		String jsFile = "../../mms/js/mms.js";
		return jsFile;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb) {
		StringBuffer brMainQuery = new StringBuffer(500);
		String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		brMainQuery.append(mms.qryHandler_mms.getQuery(1, "select.drug.0")
				.replace("?", hosCode));
		brMainQuery.append(mms.qryHandler_mms.getQuery(1, "select.drug.cond.1")
				.replace("?", "0"));
		if (cmb != null) {
			if (!cmb[0].equals("0")) {
				/*
				 * brMainQuery.replace(brMainQuery.lastIndexOf("0"), brMainQuery
				 * .lastIndexOf("0") + 1, "0");
				 */
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[0]);
			}
			if (!cmb[1].equals("0")) {
				/*
				 * brMainQuery.replace(brMainQuery.lastIndexOf("0"), brMainQuery
				 * .lastIndexOf("0") + 1, cmb[0]);
				 */
				brMainQuery.append("   and "
						+ mms.qryHandler_mms.getQuery(1, "select.drug.cond.2")
								.replace("?", cmb[1]));
			}

			//if (!cmb[2].equals("0")) {
				brMainQuery.append(" and "
						+ mms.qryHandler_mms.getQuery(1, "select.drug.cond.0")
								.replace("?", cmb[2]));
			//}
		}
		 //System.out.println("brMainQuery.toString()--"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {

		String masterName = "Generic Drug  Master";

		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "2", "HSTSTR_ITEM_NAME" };
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
		String search_field[] = { "1", "HSTSTR_ITEM_NAME" };
		return search_field;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {
		List<String> viewHdr = new ArrayList<String>();
		viewHdr.add("Generic Drug Name");
		viewHdr.add("D");
		viewHdr.add("Generic Drug Code");
		viewHdr.add("D");
		viewHdr.add("Group Name");
		viewHdr.add("D");
		viewHdr.add("Sub Group Name");
		viewHdr.add("D");
		viewHdr.add("Item Category");
		viewHdr.add("D");
		viewHdr.add("Managed By Batch No.");
		viewHdr.add("D");
		viewHdr.add("Managed By Expiry Date");
		viewHdr.add("D");
		viewHdr.add("Shelf Life");
		viewHdr.add("D");
		viewHdr.add("Shelf Life Unit");
		viewHdr.add("D");
		viewHdr.add("Inventory Unit");
		viewHdr.add("D");
		viewHdr.add("Purchase Lead Time");
		viewHdr.add("D");
		viewHdr.add("Purchase Lead Time unit");
		viewHdr.add("D");
		viewHdr.add("Consumable Type");
		viewHdr.add("D");
		viewHdr.add("Is Narotic");
		viewHdr.add("D");
		viewHdr.add("Remarks");
		viewHdr.add("D");
		viewHdr.add("Effective From");
		viewHdr.add("D");
		viewHdr.add("Record Status");
		viewHdr.add("D");
		viewHdr.add("Is Consent Required");
		viewHdr.add("D");

		return viewHdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {
		return mms.qryHandler_mms.getQuery(1, "select.drug.11");

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
