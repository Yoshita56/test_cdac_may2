/**
 * 
 */
package mms.masters.controller.utl;

import hisglobal.hisconfig.Config;
import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * Developer : Tanvi Sappal Version : 1.0 Date : 15/May/2009
 */
public class ItemMstForBMEDUTIL implements MasterInterface {

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
		/*br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-add.png'	title='Add' 	style='cursor: pointer;' 	tabindex='0' 	onKeyPress='if(event.keyCode==13) itemBrandMstComboAdd(document.forms[0]);'		onClick='itemBrandMstComboAdd(document.forms[0]);' ></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-mo.png'		title='Modify'	style='cursor: pointer;'  	tabindex='0' 	onKeyPress='if(event.keyCode==13) itemBrandMstComboModify(document.forms[0]);'	onClick='itemBrandMstComboModify(document.forms[0]);' ></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-del.png'	title='Delete'	style='cursor: pointer;'  	tabindex='0' 	onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");'					onClick='deleteRecords(\"DELETE\");'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-view.png'	title='View' 	style='cursor: pointer;' 	tabindex='0' 	onKeyPress='if(event.keyCode==13) itemView();'									onClick='itemView();'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-rpt.png'	title='Report' 	style='cursor: pointer;' 	tabindex='0' 	onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");'></a>");
		*/
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) itemBrandMstComboAdd(document.forms[0]);'		onClick='itemBrandMstComboAdd(document.forms[0]);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) itemBrandMstComboModify(document.forms[0]);'	onClick='itemBrandMstComboModify(document.forms[0]);'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");'					onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) itemView();'	onClick='itemView();'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String col_header[] = { "Item Name", "Item Type","Is Quantifiable","Is Misc"};
		return col_header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		String[] comboHeader = { "0", "Item Category", "0", "Group Name", "1",	"Record Status" };
		return comboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		String strSeatId = httpSession.getAttribute("SEATID").toString();

		String[] comboQuery = new String[3];

		String strCatCodes = "";
		if (httpSession.getAttribute("USERVALUE").toString() != null) {
			strCatCodes = httpSession.getAttribute("USERVALUE").toString();
			//System.out.println("strCatCodes"+strCatCodes);
		} else {
			strCatCodes = "0";
		}

		comboQuery[0] = mms.qryHandler_mms.getQuery(1,
				"select.itemBrandMstCat.0").replace("?", Config.SUPER_USER_HOSPITAL_CODE);



		comboQuery[1] = mms.qryHandler_mms.getQuery(1,
				"select.itemBrandMstGrp.0").replace("?", Config.SUPER_USER_HOSPITAL_CODE);

		comboQuery[2] = "1^Active#2^In Active";
//		//System.out.println(" Combo [0] -->>"+comboQuery[0]);
//		//System.out.println(" Combo [1] -->>"+comboQuery[1]);
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
				.getQuery(1, "delete.itemBrandMst.0").replace("?", seatId);
		deleteQuery[0] = deleteQuery[0].concat("  where "
				+ mms.qryHandler_mms.getQuery(1, "delete.itemBrandMst.cond.0"));
		// deleteQuery[0] =
		// mms.qryHandler_mms.getQuery(1,"delete.LetterTypeMst.0");
		return deleteQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {

		String jsFile = "../../mms/js/mmsBs.js";
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

		brMainQuery.append(mms.qryHandler_mms.getQuery(1,
				"select.itemBrandMst.0").replace("?", hosCode));

		// brMainQuery.append(" and " + mms.qryHandler_mms.getQuery(1,
		// "select.itemBrandMst.cond.2").replace("?", "0"));
		if (cmb != null) {

			if (!cmb[0].equals("0")) {
				brMainQuery.append(" and "
						+ mms.qryHandler_mms.getQuery(1,
								"select.itemBrandMst.cond.4").replace("?",
								cmb[0]));
			}

			if (!cmb[1].equals("0")) {
				brMainQuery.append(" and "
						+ mms.qryHandler_mms.getQuery(1,
								"select.itemBrandMst.cond.3").replace("?",
								cmb[1]));
			}

			
			if (!cmb[2].equals("0")) {
				brMainQuery.append(" and "
						+ mms.qryHandler_mms.getQuery(1,
								"select.itemBrandMst.cond.0").replace("?",
								cmb[2]));
			}

		}
		else
		{
			brMainQuery.append(" and "
					+ mms.qryHandler_mms.getQuery(1,
							"select.itemBrandMst.cond.4").replace("?","0"));
		}
        System.out.println("Item Mst Main Query----"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {

		String masterName = "Item  Master";

		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "2", "B.HSTSTR_ITEM_NAME","3","MMS_MST.GET_ITEMTYPE_DTL(1 , GNUM_HOSPITAL_CODE , HSTNUM_ITEMTYPE_ID )" };
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
		String search_field[] = { "1",
				"B.HSTSTR_ITEM_NAME" };
		return search_field;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {
		
		  List<String> viewHdr = new ArrayList<String>(); 
		  viewHdr.add("Item Category"); 
		  viewHdr.add("D"); 
		  viewHdr.add("Group Name");
		  viewHdr.add("D"); 
		/*
		 * viewHdr.add("Generic Item"); viewHdr.add("D"); viewHdr.add("Item Type");
		 * viewHdr.add("D"); viewHdr.add("Item Name"); viewHdr.add("D");
		 * viewHdr.add("Manufacturer"); viewHdr.add("D"); viewHdr.add("Rate/Unit");
		 * viewHdr.add("D"); viewHdr.add("Approved
		 * Type"); viewHdr.add("D"); viewHdr.add("Issue Type"); viewHdr.add("D");
		 * viewHdr.add("Item Make"); viewHdr.add("D");
		 * viewHdr.add("Item is Spare Part"); viewHdr.add("D");
		 * viewHdr.add("Item is Sachet"); viewHdr.add("D"); viewHdr.add("Item is
		 * Quantifiable"); viewHdr.add("D"); viewHdr.add("Specification");
		 * viewHdr.add("D"); viewHdr.add("Effective from"); viewHdr.add("D");
		 * viewHdr.add("Record Status"); viewHdr.add("D"); return viewHdr;
		 */
		 
		return viewHdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {
		/*
		 * String viewQuery = mms.qryHandler_mms.getQuery(1,
		 * "select.LetterTypeMst.1"); return viewQuery;
		 */
		return null;
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
