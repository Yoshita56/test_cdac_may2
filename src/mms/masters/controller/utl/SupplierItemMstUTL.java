package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierItemMstUTL.
 */
public class SupplierItemMstUTL implements MasterInterface {

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

		//String masterName = " Supplier Item Master ";
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String masterName = null;
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			masterName = " Supplier Drug Master ";
		}else{
			masterName = " Supplier Item Master ";
		}
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {

		/*
		 * Generic Drug/Item Name is removed from list page. Change request from
		 * Ajay Gupta. Date: 27th Dec 2010
		 */

		/*
		 * String[] columnHdr = { "Generic Drug/Item Name ", " Drug/Item Name ",
		 * " Effective From" };
		 */

		//String[] columnHdr = { " Drug/Item Name ", " Effective From" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] columnHdr = new String[2];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			columnHdr[0]=" Drug Name ";
		}else{
			columnHdr[0]=" Drug/Item Name ";
		}
		columnHdr[1]=" Effective From ";
		return columnHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */
	public String[] getSearchField() {

		String search_field[] = { "1", "C.BRAND_NAME" };
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

		/*
		 * Change Request: Ajay Sir(Item Category Combo Should be there).
		 */
		/*
		 * String[] comboHdr = { "0", "Supplier ", "1", " Record Status" };
		 */

		//String[] comboHeader = { "0", "Item Category", "0", "Supplier ", "1"," Record Status" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[6];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	
			comboHeader[0] = "0";
			comboHeader[1] = "Category";
			comboHeader[2] = "0";
			comboHeader[3] = "Supplier";
			comboHeader[4] = "1";
			comboHeader[5] = "Record Status";
		}else{
			comboHeader[0] = "0";
			comboHeader[1] = "Item Category";
			comboHeader[2] = "0";
			comboHeader[3] = "Supplier";
			comboHeader[4] = "1";
			comboHeader[5] = "Record Status";
		}
		
		return comboHeader;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {

		String[] comboQuery = new String[3];
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		//String strCatCodes = "0";
		/*if (httpSession.getAttribute("USERVALUE").toString() != null) {
			strCatCodes = httpSession.getAttribute("USERVALUE").toString();
		} else {
			strCatCodes = "0";
		}*/

		comboQuery[0] = mms.qryHandler_mms.getQuery(1,
				"select.SupplierItemCategory.0");
		comboQuery[0] = comboQuery[0].replace("?", hosCode);

		//Aritra
		comboQuery[1] = mms.qryHandler_mms.getQuery(1, "select.SupplierName.0");
		comboQuery[1] = comboQuery[1].replace("?", hosCode);

		comboQuery[1] = comboQuery[1].concat(mms.qryHandler_mms.getQuery(1,
				"select.SupplierName.cond.0"));
		//comboQuery[1] = comboQuery[1].replace("?", strCatCodes);

		// //System.out.println("comboQuery[0]-"+comboQuery[0]);

		/*
		 * comboQuery[1] = mms.qryHandler_mms.getQuery(1,
		 * "select.SupplierItemCategory.0"); comboQuery[1] =
		 * comboQuery[1].replace("?", hosCode);
		 */

		comboQuery[2] = "1^Active#2^Inactive";

		return comboQuery;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb) {

		String temp[] = null;
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		StringBuffer brMainQuery = new StringBuffer();

		brMainQuery
				.append(mms.qryHandler_mms.getQuery(1, "select.SupplierItem.0")
						.replace("?", hosCode))
				.append(" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.SupplierItem.cond.1").replace("?", "1"));

		if (cmb != null) {

			if (!cmb[2].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, cmb[2]);

			}
		}
		
		
		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1, "select.SupplierItem.cond.3")
						.replace("?", "0"));

		if (cmb != null) {

			if (!cmb[0].equals("0")) {
				//temp = cmb[0].replace('^', '#').split("#");
				// //System.out.println("temp[0]"+temp[0]);
				// //System.out.println("temp[2]"+temp[2]);

				/*brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, temp[0]);*/
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[0]);

				/*brMainQuery.append(" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.SupplierItem.cond.3").replace("?",
								temp[2]));*/

			}

		}

		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1, "select.SupplierItem.cond.2")
						.replace("?", "0"));

		if (cmb != null) {

			if (!cmb[1].equals("0")) {
				temp = cmb[1].replace('^', '#').split("#");
				// //System.out.println("temp[0]"+temp[0]);
				// //System.out.println("temp[2]"+temp[2]);

				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, temp[0]);

				/*brMainQuery.append(" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.SupplierItem.cond.3").replace("?",
								temp[2]));
*/
			}

		}
        ////System.out.println("Supplier Item Main Query::::"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {

		return mms.qryHandler_mms.getQuery(1, "select.SupplierItem.1");
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
		
		viewHdr.add("Supplier Name");
		viewHdr.add("D");
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			viewHdr.add("Category Name");
			viewHdr.add("D");
			viewHdr.add("Group Name");
			viewHdr.add("D");
			viewHdr.add("SubGroup Name");
			viewHdr.add("D");
			viewHdr.add("Generic Drug Name");
			viewHdr.add("D");
			viewHdr.add("Drug Name");
			viewHdr.add("D");
		}else{
			viewHdr.add("Item Category Name");
			viewHdr.add("D");
			viewHdr.add("Store Group Name");
			viewHdr.add("D");
			viewHdr.add("Store SubGroup Name");
			viewHdr.add("D");
			viewHdr.add("Generic Drug/Item Name");
			viewHdr.add("D");
			viewHdr.add("Drug/Item Name");
			viewHdr.add("D");
		}
		
		
		viewHdr.add("Effective From ");
		viewHdr.add("D");
		viewHdr.add("Remarks ");
		viewHdr.add("D");
		viewHdr.add("Record Status ");
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

		String orderBy[] = { "1", "ITEM_NAME" };
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
		delQuery[0] = mms.qryHandler_mms.getQuery(1, "delete.SupplierItem.0")
				.replace("?", seatId);

		delQuery[0] = delQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1, "delete.SupplierItem.cond.0"));
		return delQuery;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() {

		StringBuilder br = new StringBuilder();

		br.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],7);' 		onClick='return callComboAdd(document.forms[0],7);' ><span class='add'>Add</span></a>");
		br.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],7);' 	onClick='return callComboModify(document.forms[0],7);' ><span class='modify'>Modify</span></a>");
		br.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 						onClick='deleteRecords(\"DELETE\");' ><span class='delete'>Delete</span></a>");
		br.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");' ><span class='view'>View</span></a>");
		br.append("<br><a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  							onClick='report(\"REPORT\");' ><span class='report'>Report</span></a>");

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
