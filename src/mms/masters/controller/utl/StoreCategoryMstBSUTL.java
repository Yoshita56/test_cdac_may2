package mms.masters.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

import hisglobal.masterutil.MasterInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class StoreCategoryMstUTL.
 * 
 * @author Baisakhi Roy
 */
public class StoreCategoryMstBSUTL implements MasterInterface {

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

		//String masterName = " Drug Warehouse Category Master ";
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String masterName = null;
//		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
//		{
//			masterName = " Drug Warehouse Category Master ";
//		}else{
			masterName = "Store Category Master";
//		}
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {

		//String[] columnHdr = { " Drug Category ", "Whether Drug Bounded"," Effective From " };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] columnHdr = new String[3];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{
			columnHdr[0]=" Category ";
		}else{
			columnHdr[0]=" Item Category ";
		}
		columnHdr[1]=" Whether Drug Bounded ";
		columnHdr[2]=" Effective From ";
		return columnHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */
	public String[] getSearchField() {

		String search_field[] = { "1", "C.STORE_CATEGORY" };
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

		//String[] comboHeader = { "0", "Drug Warehouse Name  ", "1", " Record Status" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[4];
//		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
//		{	
//			comboHeader[0] = "0";
//			comboHeader[1] = "Drug WareHouse Name";
//		}else{
			comboHeader[0] = "0";
			comboHeader[1] = "Store Name";
//		}
		comboHeader[2] = "1";
		comboHeader[3] = "Record Status";
		
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
		String strSeatId = httpSession.getAttribute("SEATID").toString();

		comboQuery[0] = mms.qryHandler_mms.getQuery(1,
				"select.storeName..storeCategoryMst.0");
		comboQuery[0] = comboQuery[0].replace("?", hosCode);

		/*comboQuery[0] = comboQuery[0].concat(mms.qryHandler_mms.getQuery(1,
				"select.storeName.storeCategoryMst.cond.0"));
		comboQuery[0] = comboQuery[0].replace("?", strSeatId);*/

		comboQuery[1] = "1^Active#2^Inactive";

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
				mms.qryHandler_mms.getQuery(1, "select.storeCategoryMst.0")
						.replace("?", hosCode)).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.storeCategoryMst.cond.1").replace("?",
								"1"));

		if (cmb != null) {

			if (!cmb[1].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, cmb[1]);

			}
		}

		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1,
						"select.storeCategoryMst.cond.2").replace("?", "0"));

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

		return mms.qryHandler_mms.getQuery(1, "select.storeCategoryMst.4");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
		
//		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
//		{
//			viewHdr.add("Drug Warehouse Name");
//			viewHdr.add("D");
//			viewHdr.add("Drug Warehouse Category");
//			viewHdr.add("D");
//		}else{
			viewHdr.add("Store Name");
			viewHdr.add("D");
			viewHdr.add("Store Category");
			viewHdr.add("D");
//		}
		
		viewHdr.add("Effective From ");
		viewHdr.add("D");
		viewHdr.add("Remarks ");
		viewHdr.add("D");
		viewHdr.add("Record Status ");
		viewHdr.add("D");
		viewHdr.add("Bounded With Drugs");
		viewHdr.add("D");
		viewHdr.add("Allow to add new Drug");
		viewHdr.add("D");

		return viewHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "1", "C.STORE_CATEGORY" };
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
		delQuery[0] = mms.qryHandler_mms.getQuery(1,
				"delete.storeCategoryMst.0").replace("?", seatId);

		delQuery[0] = delQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1,
						"delete.storeCategoryMst.cond.0"));
		return delQuery;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() {

		StringBuilder br = new StringBuilder();
		/*
		br.append("<img src='../../hisglobal/images/btn-add.png'	style='cursor: pointer;' tabindex='0' title='Add' 		onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],1);' 	onClick='return callComboAdd(document.forms[0],1);' />");
		br.append("<img src='../../hisglobal/images/btn-mo.png'		style='cursor: pointer;' tabindex='0' title='Modify' 	onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],1);' onClick='return callComboModify(document.forms[0],1);' />");
		br.append("<img src='../../hisglobal/images/btn-del.png'	style='cursor: pointer;' tabindex='0' title='Delete' 	onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");' />");
		br.append("<img src='../../hisglobal/images/btn-view.png'	style='cursor: pointer;' tabindex='0' title='View' 		onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");' />");
		br.append("<img src='../../hisglobal/images/btn-rpt.png'	style='cursor: pointer;' tabindex='0' title='Report' 	onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");' />");
		*/
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],1);' 	onClick='return callComboAdd(document.forms[0],1);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' style='cursor: pointer;' tabindex='0' title='Modify' 	onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],1);' onClick='return callComboModify(document.forms[0],1);'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' data-toggle='modal' data-target='#viewModal1' onKeyPress='if(event.keyCode==13) viewBS(\"VIEWDATABS\");' onClick='viewBS(\"VIEWDATABS\");'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");' onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
				
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {

		String jsFile = new String("../../mms/js/mmsBs.js");
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
