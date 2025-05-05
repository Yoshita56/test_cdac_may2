package mms.masters.controller.utl;

import hisglobal.hisconfig.Config;
import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreSubGroupMstUTL.
 */
public class StoreSubGroupMstBSUTL implements MasterInterface {

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

		/*br.append("<img src='../../hisglobal/images/btn-add.png'	tabindex='0' style='cursor: pointer;' title='Add' 	 onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],6);' 		onClick='return callComboAdd(document.forms[0],6);' />");
		br.append("<img src='../../hisglobal/images/btn-mo.png'		tabindex='0' style='cursor: pointer;' title='Modify' onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],6);' 	onClick='return callComboModify(document.forms[0],6);' />");
		br.append("<img src='../../hisglobal/images/btn-del.png'	tabindex='0' style='cursor: pointer;' title='Delete' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 						onClick='deleteRecords(\"DELETE\");' />");
		br.append("<img src='../../hisglobal/images/btn-view.png'	tabindex='0' style='cursor: pointer;' title='View' 	 onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");' />");
		br.append("<img src='../../hisglobal/images/btn-rpt.png'	tabindex='0' style='cursor: pointer;' title='Report' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  							onClick='report(\"REPORT\");' />");
		*/
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],6);' 		onClick='return callComboAdd(document.forms[0],6);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],6);' 	onClick='return callComboModify(document.forms[0],6);'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 	onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' data-toggle='modal' data-target='#viewModal' onKeyPress='if(event.keyCode==13) viewBS(\"VIEWDATABS\");' 							onClick='viewBS(\"VIEWDATABS\");'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		//String columnHdr[] = { " Sub Group Name", "Effective From" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] columnHdr = new String[2];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			columnHdr[0]=" Sub Group Name ";
		}else{
			columnHdr[0]=" Store Sub Group Name ";
		}
		columnHdr[1]=" Effective From ";
		return columnHdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		//String[] comboHeader = { "0", "Drug Category", "0", "Group Name", "1","Record Status" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[6];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	
			comboHeader[0] = "0";
			comboHeader[1] = "Category";
			comboHeader[2] = "0";
			comboHeader[3] = "Group Name";
		}else{
			comboHeader[0] = "0";
			comboHeader[1] = "Item Category";
			comboHeader[2] = "0";
			comboHeader[3] = "Store Group Name";
		}
		comboHeader[4] = "1";
		comboHeader[5] = "Record Status";
		
		return comboHeader;
		// return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {

		String[] comboQuery = new String[3];

		String strCatCodes = "";
		String strSeatId = httpSession.getAttribute("SEATID").toString();
		String strHospCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		
		if (httpSession.getAttribute("USERVALUE").toString() != null) {
			strCatCodes = httpSession.getAttribute("USERVALUE").toString();
		} else {
			strCatCodes = "0";
		}

		comboQuery[0] = mms.qryHandler_mms.getQuery(1,
				"select.subgroup.itemCatName.0").replace("?",strHospCode);

//		comboQuery[0] = comboQuery[0].concat(mms.qryHandler_mms.getQuery(1,
//				"select.subgroup.itemCatName.cond.0"));
//		comboQuery[0] = comboQuery[0].replace("?", strSeatId);
/*
		comboQuery[0] = comboQuery[0].concat(mms.qryHandler_mms.getQuery(1,
				"select.subgroup.itemCatName.cond.1"));
		comboQuery[0] = comboQuery[0].replace("?", strCatCodes);*/

		// //System.out.println("comboQuery[0]-"+comboQuery[0]);
		comboQuery[1] = mms.qryHandler_mms.getQuery(1, "select.groupName.0")
				.replace("?",Config.SUPER_USER_HOSPITAL_CODE);

		comboQuery[2] = "1^Active#2^In Active";
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

		deleteQuery[0] = mms.qryHandler_mms.getQuery(1, "delete.subGroup.0")
				.replace("?", seatId);

		deleteQuery[0] = deleteQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1, "delete.subGroup.cond.0"));

		return deleteQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {
		String files = "../../mms/js/mmsBs.js";
		return files;
		// return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String cmb[]) {
		StringBuffer brMainQuery = new StringBuffer(500);
		String strHospCode =  MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		
		brMainQuery.append(
				mms.qryHandler_mms.getQuery(1, "select.subGroup.0").replace(
						"?",strHospCode))
				.append(" and "
						+ mms.qryHandler_mms.getQuery(1,
								"select.subGroup.cond.0").replace("?", "1"));

		if (cmb != null) {
			if (!cmb[2].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, cmb[2]);

			}
		}
		// brMainQuery.append(" AND "
		// + mms.qryHandler_mms.getQuery(1,
		// "select.subGroup.cond.1").replace("?", "1"));
		// if (cmb != null) {
		// if (!cmb[0].equals("0"))
		// brMainQuery.replace(brMainQuery.lastIndexOf("1"), brMainQuery
		// .lastIndexOf("1") + 1, cmb[0]);

		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1, "select.subGroup.cond.2")
						.replace("?", "0"));

		// }

		if (cmb != null) {
			if (!cmb[1].equals("0"))
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[1]);

		}
		//System.out.println("brMainQuery.toString():::::"+brMainQuery.toString());
		
		return brMainQuery.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {
		//String masterName = "Sub Group Master";
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String masterName = null;
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			masterName = " Sub Group Master ";
		}else{
			masterName = " Store Sub Group Master ";
		}
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {
		String orderBy[] = { "1", "HSTSTR_SUBGROUP_NAME" };
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

		String search_field[] = { "1", "HSTSTR_SUBGROUP_NAME" };
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
			viewHdr.add("Group Name");
			viewHdr.add("D");
			viewHdr.add("Sub Group Name");
			viewHdr.add("D");
		}else{
			viewHdr.add("Store Group Name");
			viewHdr.add("D");
			viewHdr.add("Store Sub Group Name");
			viewHdr.add("D");
		}
		
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
		String viewQuery = mms.qryHandler_mms.getQuery(1, "select.subGroup.1");
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
