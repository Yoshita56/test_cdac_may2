package mms.masters.controller.utl;

import hisglobal.hisconfig.Config;
import hisglobal.masterutil.MasterInterface;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreItemMstUTL.
 */
public class StoreItemMstUTL implements MasterInterface {

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

		//String masterName = " Drug WareHouse Drug mapping Master ";
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String masterName = null;
		
		//following code commented by shalini
		//if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		//{
		//	masterName = " Drug WareHouse Drug mapping Master ";
		//}else{
			masterName = "Store Item Master";
		//}
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {

		//String[] columnHdr = { "Drug Name", "Drug Type", "Reorder Level","Max Level", "Effective From" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] columnHdr = new String[4];
//		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
//		{
//			columnHdr[0]=" Drug Name ";
//			columnHdr[1]=" Drug Type ";
//		}else{
			columnHdr[0]=" Item Name ";
			columnHdr[1]=" Item Type ";
		//}
		columnHdr[2]=" Reorder Level ";
		columnHdr[3]=" Is Returnable ";
		//columnHdr[4]=" Effective From ";
		return columnHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */
	public String[] getSearchField() {
		String arrStrSearch_field[] = { "1",
				" MMS_MST.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID) " };

		return arrStrSearch_field;
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

		//String[] comboHeader = { "0", "Drug WareHouse Name ", "0", "Drug Category", "0","Group Name", "1", " Record Status" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[8];
		// following code commented by shalini
//		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
//		{	
//			comboHeader[0] = "0";
//			comboHeader[1] = "Drug WareHouse Name";
//			comboHeader[2] = "0";
//			comboHeader[3] = "Drug Category";
//			comboHeader[4] = "0";
//			comboHeader[5] = "Group Name";
//			comboHeader[6] = "1";
//			comboHeader[7] = "Record Status";
//		}else{
			comboHeader[0] = "0";
			comboHeader[1] = "Store Name";
			comboHeader[2] = "0";
			comboHeader[3] = "Category";
			comboHeader[4] = "0";
			comboHeader[5] = "Group Name";
			comboHeader[6] = "1";
			comboHeader[7] = "Record Status";
//		}
		
		return comboHeader;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {

		String[] comboQuery = new String[4];
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		String strSeatId = httpSession.getAttribute("SEATID").toString();

		String strCatCodes = "(1,2)";
		if (httpSession.getAttribute("USERVALUE").toString() != null) 
		{
			strCatCodes = httpSession.getAttribute("USERVALUE").toString();
		} 
		else 
		{
			strCatCodes = "0";
		}

		comboQuery[0] = mms.qryHandler_mms.getQuery(1,"select.storeitem.storeName1.0");
		comboQuery[0] = comboQuery[0].replace("?", hosCode);

		comboQuery[1] = mms.qryHandler_mms.getQuery(1,"select.StoreItemCategory.0");
		comboQuery[1] = comboQuery[1].concat(mms.qryHandler_mms.getQuery(1,"select.StoreItemCategory.cond.0")).replace("?",	hosCode);

		comboQuery[3] = "1^Active#2^In Active";

		comboQuery[2] = mms.qryHandler_mms.getQuery(1,"select.StoreItemGroup.0");
		comboQuery[2] = comboQuery[2].replace("?", "100");

		comboQuery[2] = comboQuery[2].concat(mms.qryHandler_mms.getQuery(1,"select.StoreItemGroup.cond.0"));

		System.out.println("Store Name Combo::::->>>"+comboQuery[0]);
		System.out.println("cATG Name Combo::::->>>"+comboQuery[1]);
		System.out.println("gROUP Name Combo::::->>>"+comboQuery[2]);
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
				mms.qryHandler_mms.getQuery(1, "select.StoreItem.0").replace(
						"?", hosCode)).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.StoreItem.cond.1").replace("?", "1"));

		if (cmb != null) {
			if (!cmb[3].equals("0")) // Status
			{

				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, cmb[3]);

			}
		}

		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1, "select.StoreItem.cond.2")
						.replace("?", "0"));

		if (cmb != null) {
			if (!cmb[0].equals("0")) // Store Id
			{
				String temp[] = null;
				temp = cmb[0].replace('@', '#').split("#");
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, temp[0]);

			}

		}

		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1, "select.StoreItem.cond.3")
						.replace("?", "0"));

		if (cmb != null) {
			if (!cmb[1].equals("0")) // Item Catg
			{
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[1]);

			}

		}
		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1, "select.StoreItem.cond.4")
						.replace("?", "0"));
		if (cmb != null) {
			if (!cmb[2].equals("0")) // Group Name
			{
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[2]);

			}

		}
		System.out.println("Store Item Main Qry:::"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {

		return mms.qryHandler_mms.getQuery(1, "select.StoreItem.1");
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
			viewHdr.add("Drug WareHouse Name");
			viewHdr.add("D");
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
			viewHdr.add("Drug Short Time");
			viewHdr.add("D");
			viewHdr.add("Drug Category(VED)");
			viewHdr.add("D");
		}else{
			viewHdr.add("Store Name");
			viewHdr.add("D");
			viewHdr.add("Item Category Name");
			viewHdr.add("D");
			viewHdr.add("Store Group Name");
			viewHdr.add("D");
			viewHdr.add("SubGroup Name");
			viewHdr.add("D");
			viewHdr.add("Generic Item Name");
			viewHdr.add("D");
			viewHdr.add("Item Name");
			viewHdr.add("D");
			viewHdr.add("Item Short Time");
			viewHdr.add("D");
			viewHdr.add("Item Category(VED)");
			viewHdr.add("D");
		}
		
		viewHdr.add("Forecast");
		viewHdr.add("D");
		viewHdr.add("Reserved Qty (%)");
		viewHdr.add("D");
		viewHdr.add("Tolerance Limit (%)");
		viewHdr.add("D");
		viewHdr.add("Reorder Level");
		viewHdr.add("D");
		viewHdr.add("Max Level");
		viewHdr.add("D");
		viewHdr.add("Max Indent Qty");
		viewHdr.add("D");
		//viewHdr.add("Level Unit");
	//	viewHdr.add("D");

		viewHdr.add("Is Issuable");
		viewHdr.add("D");
		viewHdr.add("Is Returnable");
		viewHdr.add("D");
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
		String arrOrderBy[] = {
				"1",
				" UPPER(MMS_MST.get_item_dtl(1,GNUM_HOSPITAL_CODE,HSTNUM_ITEMBRAND_ID)) ",
				"3", "HSTNUM_REORDER_QTY" };

		return arrOrderBy;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {

		String[] delQuery = new String[1];
		String seatId = httpSession.getAttribute("SEATID").toString();

		delQuery[0] = mms.qryHandler_mms.getQuery(1, "delete.StoreItem.0")
				.replace("?", seatId);

		delQuery[0] = delQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1, "delete.StoreItem.cond.0"));

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
		/*
		br.append("<img src='../../hisglobal/images/btn-add.png'		tabindex='0' 		style='cursor: pointer;' title='Add' 			onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],4);' 	onClick='return callComboAdd(document.forms[0],4);' />");
		br.append("<img src='../../hisglobal/images/btn-mo.png'			tabindex='0'		style='cursor: pointer;' title='Modify' 		onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],4);' onClick='return callComboModify(document.forms[0],4);' />");
		br.append("<img src='../../hisglobal/images/btn-del.png'		tabindex='0'		style='cursor: pointer;' title='Delete' 		onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");' />");
		br.append("<img src='../../hisglobal/images/btn-view.png'		tabindex='0'		style='cursor: pointer;' title='View' 			onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");' />");
		br.append("<img src='../../hisglobal/images/btn-rpt.png' 		tabindex='0'		style='cursor: pointer;' title='Report' 		onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");' />");
		br.append("<img src='../../hisglobal/images/btn-batchupdate.png'	tabindex='0'	style='cursor: pointer;' title='Batch Update' 	onKeyPress='if(event.keyCode==13) return callBatchUpdate(document.forms[0]);'  	onClick='return callBatchUpdate(document.forms[0]);' />");
		*/
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],4);' 	onClick='return callComboAdd(document.forms[0],4);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],4);' onClick='return callComboModify(document.forms[0],4);'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' data-toggle='modal' data-target='#viewModal1' onKeyPress='if(event.keyCode==13)  viewBS(\"VIEWDATABS\");' 							onClick='viewBS(\"VIEWDATABS\");'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
		//br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) return callBatchUpdate(document.forms[0]);'  	onClick='return callBatchUpdate(document.forms[0]);'><span class='modify'>Update</span></a>");		
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
		return false;
	}
	public String isGlobal() {
		return "0";
	}

}
