package mms.masters.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

import hisglobal.masterutil.MasterInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreHierarchyMstUTL.
 * 
 * @author Anshul Jindal
 */
public class ShortenURLMstUTL1 implements MasterInterface {

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

		System.out.println("-----------ShortenURLMstUTL.getMasterName----------");
		//String masterName = " Drug WareHouse Hierarchy Master ";
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String masterName = null;
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			masterName = "Store Hierarchy Master";
		}else{
			masterName = "Store Hierarchy Master";
		}
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		System.out.println("-----------ShortenURLMstUTL.getColumnHeader----------");
		//String[] columnHdr = { " Request Type ", " Sub Drug WareHouse "," Effective From " };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] columnHdr = new String[3];
		
		columnHdr[0]=" Request Type ";
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			columnHdr[1]="Store";
		}else{
			columnHdr[1]="Store";
		}
		columnHdr[2]=" Effective From ";
		return columnHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */
	public String[] getSearchField() {
		System.out.println("-----------ShortenURLMstUTL.getSearchField----------");
		String search_field[] = { "2", "C.TO_STORE" };
		return search_field;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getRecord_per_page()
	 */
	public int getRecord_per_page() {
		System.out.println("-----------ShortenURLMstUTL.getRecord_per_page----------");
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
		System.out.println("-----------ShortenURLMstUTL.getComboHeader----------");
		//String[] comboHeader = { "0", "From Drug WareHouse ", "0", "Drug Category", "0","Request Type", "1", " Record Status" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[8];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	
			comboHeader[0] = "0";
			comboHeader[1] = "Store Name";
			comboHeader[2] = "0";
			comboHeader[3] = "Item Category";
		}else{
			comboHeader[0] = "0";
			comboHeader[1] = "Store Name";
			comboHeader[2] = "0";
			comboHeader[3] = "Item Category";
		}
		comboHeader[4] = "0";
		comboHeader[5] = "Request Type";
		comboHeader[6] = "1";
		comboHeader[7] = "Record Status";
		
		return comboHeader;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		System.out.println("-----------ShortenURLMstUTL.getComboQuery----------");
		String[] comboQuery = new String[5];
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		
		comboQuery[0] = mms.qryHandler_mms.getQuery(1,"select.storeName.0").replace("?", hosCode);
		comboQuery[1] = mms.qryHandler_mms.getQuery(1,"select.storeHierarchyItemCat.0").replace("?", hosCode);
		comboQuery[2] = mms.qryHandler_mms.getQuery(1,"select.storeHiererchyReqType.0").replace("?", hosCode);
		comboQuery[3] = "1^Active#2^In Active";
		return comboQuery;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb) {
		System.out.println("-----------ShortenURLMstUTL.getMainQuery----------");
		String temp[] = null;
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		StringBuffer brMainQuery = new StringBuffer();

		brMainQuery.append(
				mms.qryHandler_mms.getQuery(1, "select.StoreHierarchy.0")
						.replace("?", hosCode)).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.StoreHierarchy.cond.1").replace("?",
								"1"));

		if (cmb != null) {

			if (!cmb[3].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, cmb[3]);

			}
		}

		brMainQuery.append(" AND "
				+ mms.qryHandler_mms
						.getQuery(1, "select.StoreHierarchy.cond.2").replace(
								"?", "0"));

		if (cmb != null) {

			if (!cmb[0].equals("0")) {
				temp = cmb[0].replace('^', '#').split("#");
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, temp[0]);

			}

		}

		brMainQuery.append(" AND "
				+ mms.qryHandler_mms
						.getQuery(1, "select.StoreHierarchy.cond.4").replace(
								"?", "0"));

		if (cmb != null) {

			if (!cmb[1].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[1]);

			}

		}

		brMainQuery.append(" AND "
				+ mms.qryHandler_mms
						.getQuery(1, "select.StoreHierarchy.cond.3").replace(
								"?", "0"));

		if (cmb != null) {

			if (!cmb[2].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[2]);

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
		System.out.println("-----------ShortenURLMstUTL.getViewQuery----------");
		return mms.qryHandler_mms.getQuery(1, "select.StoreHierarchy.4");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {
		System.out.println("-----------ShortenURLMstUTL.getViewHeader----------");
		List<String> viewHdr = new ArrayList<String>();
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			viewHdr.add("Drug WareHouse");
			viewHdr.add("D");
			viewHdr.add("Category");
			viewHdr.add("D");
		}else{
			viewHdr.add("Store");
			viewHdr.add("D");
			viewHdr.add("Item Category");
			viewHdr.add("D");
		}
		
		viewHdr.add("Request Type");
		viewHdr.add("D");
		viewHdr.add("Drug WareHouse");
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
		System.out.println("-----------ShortenURLMstUTL.getOrderBy----------");
		String orderBy[] = { "2", "C.TO_STORE" };
		return orderBy;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {
		System.out.println("-----------ShortenURLMstUTL.getDeleteQuery----------");
		String[] delQuery = new String[1];
		String seatId = httpSession.getAttribute("SEATID").toString();
		delQuery[0] = mms.qryHandler_mms.getQuery(1, "delete.StoreHierarchy.0")
				.replace("?", seatId);

		delQuery[0] = delQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms
						.getQuery(1, "delete.StoreHierarchy.cond.0"));
		return delQuery;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() {
		System.out.println("-----------ShortenURLMstUTL.getButtons----------");
		StringBuilder br = new StringBuilder();
		/*
		br.append("<img src='../../hisglobal/images/btn-add.png' 	style='cursor: pointer;'	tabindex='0' title='Add' 	onKeyPress='if(event.keyCode==13) return callAddMode(document.forms[0],1);' 	onClick='return callAddMode(document.forms[0],1);' />");
		br.append("<img src='../../hisglobal/images/btn-mo.png' 	style='cursor: pointer;'	tabindex='0' title='Modify' onKeyPress='if(event.keyCode==13) return callModifyMode(document.forms[0],1);' 	onClick='return callModifyMode(document.forms[0],1);' />");
		br.append("<img src='../../hisglobal/images/btn-del.png' 	style='cursor: pointer;'	tabindex='0' title='Delete' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");' />");
		br.append("<img src='../../hisglobal/images/btn-view.png' 	style='cursor: pointer;'	tabindex='0' title='View' 	onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");' />");
		br.append("<img src='../../hisglobal/images/btn-rpt.png' 	style='cursor: pointer;'	tabindex='0' title='Report' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");' />");
		*/
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) return callAddMode(document.forms[0],1);' 	onClick='return callAddMode(document.forms[0],1);'><span class='add'>Add</span></a>");
//		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) return callModifyMode(document.forms[0],1);' 	onClick='return callModifyMode(document.forms[0],1);'><span class='modify'>Modify</span></a>");
//		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
//		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");'><span class='view'>View</span></a>");
//		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
				
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {
		System.out.println("-----------ShortenURLMstUTL.getJsFiles----------");
		String jsFile = new String("../../mms/js/mms2.js");
		return jsFile;

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
		return "0";
	}
	
}
