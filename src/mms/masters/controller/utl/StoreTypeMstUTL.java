package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreTypeMstUTL.
 */
public class StoreTypeMstUTL implements MasterInterface {

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
	/*	br.append("<img src='../../hisglobal/images/btn-add.png'  style='cursor: pointer;' tabindex='0' title='Add' 	onKeyPress='if(event.keyCode==13) add(\"ADD\");' 				onClick='add(\"ADD\");' />");
		br.append("<img src='../../hisglobal/images/btn-mo.png'   style='cursor: pointer;' tabindex='0' title='Modify' 	onKeyPress='if(event.keyCode==13) edit(\"MODIFY\");' 			onClick='edit(\"MODIFY\");' />");
		br.append("<img src='../../hisglobal/images/btn-del.png'  style='cursor: pointer;' tabindex='0' title='Delete' 	onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 	onClick='deleteRecords(\"DELETE\");' />");
		br.append("<img src='../../hisglobal/images/btn-view.png' style='cursor: pointer;' tabindex='0' title='View' 	onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 			onClick='view(\"VIEWDATA\");' />");
		br.append("<img src='../../hisglobal/images/btn-rpt.png'  style='cursor: pointer;' tabindex='0' title='Report' 	onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  		onClick='report(\"REPORT\");' />");
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
		//String columnHdr[] = { "Drug Warehouse Type Name", "Effective From" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] columnHdr = new String[1];
		columnHdr[0]="Store Type Name";
		
		/*if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			columnHdr[0]=" Drug Warehouse Type Name ";
		}else{
			columnHdr[0]=" Store Type Name ";
		}*/
		
		//columnHdr[1]=" Effective From ";
		return columnHdr;
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

		String[] comboQuery = new String[2];
		comboQuery[0] = ("1^Active#2^Inactive");
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
		deleteQuery[0] = mms.qryHandler_mms
				.getQuery(1, "delete.storeTypeMst.0").replace("?", seatId);
		deleteQuery[0] = deleteQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1, "delete.storeTypeMst.cond.0"));

		return deleteQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {

		return null;
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
		brMainQuery
				.append(mms.qryHandler_mms.getQuery(1, "select.storeTypeMst.0")
						.replace("?", MmsConfigUtil.GLOBAL_HOSPITAL_CODE))
				.append(" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.storeTypeMst.cond.1").replace("?", "1"));

		if (cmb != null) {

			if (!cmb[0].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, cmb[0]);
				httpSession.setAttribute("isvalid", cmb[0]);
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
		//String masterName = " Drug Warehouse Type Master ";
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String masterName = null;
		masterName = " Store Type Master ";
		
		/*if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			masterName = " Drug Warehouse Type Master";
		}else{
			masterName = " Store Type Master ";
		}*/
		
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "1", "HSTSTR_STORETYPE_NAME" };
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

		String search_field[] = { "1", "HSTSTR_STORETYPE_NAME" };
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
		
		/*if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			viewHdr.add("Drug Warehouse Type Name");
			viewHdr.add("D");
		}else{
			viewHdr.add("Store Type Name");
			viewHdr.add("D");
		}*/
	
		viewHdr.add("Store Type Name");
		viewHdr.add("D");
		/*viewHdr.add("Effective From");
		viewHdr.add("D");*/
		viewHdr.add("Remarks");
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
				"select.storeTypeMst.1");
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
