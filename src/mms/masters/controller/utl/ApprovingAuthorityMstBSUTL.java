package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * Developer : Pramod Kumar Mehta
 * Version : 1.0
 * Date : 14/April/2009
 * Module:MMS
 * Unit:Approving Authority Master
 */

/**
 * Developer : Anshul Jindal Version : 1.0 Modify Date : 22/May/2009
 * 
 */

public class ApprovingAuthorityMstBSUTL implements MasterInterface {
	public String[] getColsWidth() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean reportInterFaceRequired() {
		// TODO Auto-generated method stub
		return false;
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
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) callComboAppAuthAdd(document.forms[0],1);' 	onClick='callComboAppAuthAdd(document.forms[0],1);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) callComboAppAuthModify(document.forms[0],1);' onClick='callComboAppAuthModify(document.forms[0],1);'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' data-toggle='modal' data-target='#viewModal1' onKeyPress='if(event.keyCode==13) viewBS(\"VIEWDATABS\");' 							onClick='viewBS(\"VIEWDATABS\");'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
		/*br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-add.png'	tabindex='0' style='cursor: pointer;' title='Add'		onKeyPress='if(event.keyCode==13) callComboAppAuthAdd(document.forms[0],1);' 	onClick='callComboAppAuthAdd(document.forms[0],1);'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-mo.png'		tabindex='0' style='cursor: pointer;' title='Modify' 	onKeyPress='if(event.keyCode==13) callComboAppAuthModify(document.forms[0],1);' onClick='callComboAppAuthModify(document.forms[0],1);'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-del.png'	tabindex='0' style='cursor: pointer;' title='Delete'	onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-view.png'	tabindex='0' style='cursor: pointer;' title='View'		onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-rpt.png'	tabindex='0' style='cursor: pointer;' title='Reoprt'	onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");'></a>");
		*/
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String col_header[] = { "Approving Id", "Authority Name",
				"Effective Date" };
		return col_header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		//String[] comboHeader = { "1", "Approving Type", "0", "Drug WareHouse Name", "1","Record Status " };
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[6];
		comboHeader[0] = "1";
		comboHeader[1] = "Approving Type";
		comboHeader[2] = "0";
	/* commented by shefali garg on 30_oct_2014
	 * 	if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	
			comboHeader[3] = "Drug WareHouse Name";
		}
		else
		{
			comboHeader[3] = "Store Name";
		}*/
		comboHeader[3] = "Store Name";
		comboHeader[4] = "1";
		comboHeader[5] = "Record Status";
		return comboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		String[] comboQuery = new String[5];
		comboQuery[0] = "1^Store#2^Administrative";
		comboQuery[1] = mms.qryHandler_mms.getQuery(1,
				"select.storeCombo.app_auth.0").replace("?", hosCode);
		comboQuery[2] = "1^Active#2^InActive";
		String[] cmbValue = (String[]) httpSession.getAttribute("MSTCOMBO");

		if (cmbValue != null) {

			if (cmbValue[0] != null && cmbValue[0].equals("1")) {
				comboQuery[1] = mms.qryHandler_mms.getQuery(1,
						"select.storeCombo.app_auth.0").replace("?", hosCode);

			} else {
				comboQuery[1] = mms.qryHandler_mms.getQuery(1,
						"select.storeCombo.app_auth.1").replace("?", hosCode);
			}

		}

		return comboQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {
		// //System.out.println("in UTL");

		String[] delQuery = new String[1];
		String seatId = httpSession.getAttribute("SEATID").toString();
		// //System.out.println("seatId-------------"+seatId);
		delQuery[0] = mms.qryHandler_mms.getQuery(1, "delete.app_auth.0")
				.replace("?", seatId);

		delQuery[0] = delQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1, "delete.app_auth.cond.0"));
		return delQuery;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {

		String jsFile = "../../mms/js/mms.js";
		return jsFile;
		// return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb) {

		StringBuffer brMainQuery = new StringBuffer(500);
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		brMainQuery.append(
				mms.qryHandler_mms.getQuery(1, "select.app_auth.0").replace(
						"?", hosCode)).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.app_auth.cond.0").replace("?", "1"));

		if (cmb != null) {

			if (!cmb[2].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, cmb[2]);
				// //System.out.println(" cmb[2]====="+ cmb[2]);
			}
		}

		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1, "select.app_auth.cond.1")
						.replace("?", "1"));

		if (cmb != null) {

			if (!cmb[0].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("1"),
						brMainQuery.lastIndexOf("1") + 1, cmb[0]);
				// //System.out.println(" cmb[0]====="+ cmb[0]);
			}

		}

		if (cmb != null) {

			if (!cmb[1].equals("0")) {
				brMainQuery.append(" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.app_auth.cond.2").replace("?", "0"));
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[1]);
				// //System.out.println(" cmb[1]====="+ cmb[1]);
			}
		}

		// //System.out.println("main qry--------->"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {

		String masterName = "Approving Authority Master#5^1^Committee^CC6666";

		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "1", "C.HSTNUM_APP_ID" };
		// return null;
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

		String search_field[] = { "1", "C.HSTNUM_APP_ID", "2", "C.USER_NAME" };

		// return null;
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
		
		
		viewHdr.add("Approving Type ");
		viewHdr.add("D");
		
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			viewHdr.add("Drug WareHouse Name ");
			

		}
		else
		{
			viewHdr.add("Store Name ");
		}
		
		viewHdr.add("D");
		viewHdr.add("User Name");
		viewHdr.add("D");
		viewHdr.add("Effective Date ");
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
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {

		return mms.qryHandler_mms.getQuery(1, "select.app_auth.4");

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
