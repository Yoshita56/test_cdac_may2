package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class DrugMstUTL.
 */
public class DrugMstUTL implements MasterInterface {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 02L;

	/** The http session. */
	HttpSession httpSession = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() 
	{

		StringBuilder br = new StringBuilder();
		/*br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-add.png' 	tabindex='0' title='Add'	style='cursor: pointer;' 	onKeyPress='if(event.keyCode==13) callDrugAddMode(document.forms[0],1);'	onClick='callDrugAddMode(document.forms[0],1);'		></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-mo.png'  	tabindex='0' title='Modify' style='cursor: pointer;' 	onKeyPress='if(event.keyCode==13) callDrugModifyMode(document.forms[0],1);' onClick='callDrugModifyMode(document.forms[0],1);'	></a>");
		//br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-del.png' 	tabindex='0' title='Delete' style='cursor: pointer;' 	onKeyPress='if(event.keyCode==13) deleteRecordscheck(\"DELETE\");'				onClick='deleteRecordscheck(\"DELETE\");'				></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-view.png'	tabindex='0' title='View'  	style='cursor: pointer;'	onKeyPress='if(event.keyCode==13) drugView();'								onClick='drugView();'								></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-rpt.png' 	tabindex='0' title='Reoprt' style='cursor: pointer;'	onKeyPress='if(event.keyCode==13) report(\"REPORT\");'						onClick='report(\"REPORT\");'						></a>");
		*/
		
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) callDrugAddMode(document.forms[0],1);'	onClick='callDrugAddMode(document.forms[0],1);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) callDrugModifyMode(document.forms[0],1);' onClick='callDrugModifyMode(document.forms[0],1);'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 	onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) drugView();'								onClick='drugView();'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'						onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String col_header[] = { "Drug Name", "Drug Type",
				"Quantifiable","Is Misc.","EDL" };
		return col_header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		String[] comboHeader = { "0", "Group Name", "1", "Record Status" };
		return comboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() 
	{
		String hosCode = "100";
		String[] comboQuery = new String[22];
		comboQuery[0] = mms.qryHandler_mms.getQuery(1,
				"select.drugbrand.group.1").replace("?", hosCode);
		/*
		 * comboQuery[1] = mms.qryHandler_mms.getQuery(1,
		 * "select.drugbrand.item.2").replace("?", hosCode);
		 * 
		 * comboQuery[2] = "1^Branded#2^Non-Branded#3^Reserved";
		 */

		comboQuery[1] = "1^Active#2^In Active";
		return comboQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {
		String[] strDelQuery = new String[2];
		String seatId = httpSession.getAttribute("SEATID").toString();

		strDelQuery[0] = mms.qryHandler_mms.getQuery(1, "delete.drugbrand.0")
				.replace("?", seatId);
		strDelQuery[0] = strDelQuery[0].concat("  where "
				+ mms.qryHandler_mms.getQuery(1, "delete.drugbrand.cond.0"));
		
		strDelQuery[1] = mms.qryHandler_mms.getQuery(1, "delete.drug.billing.1")
				.replace("?", seatId);
		strDelQuery[1] = strDelQuery[1].concat("  where "
				+ mms.qryHandler_mms.getQuery(1, "delete.drug.billing.cond"));
		
		
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
		brMainQuery.append(mms.qryHandler_mms.getQuery(1, "select.drugbrand.0")
				.replace("?", hosCode));
		//
		
		// brMainQuery.append(mms.qryHandler_mms.getQuery(1,"select.drugbrand.cond.1").replace("?",
		// "0"));
		if (cmb != null) 
		{

			if (!cmb[0].equals("0")) 
			{
				brMainQuery
						.append(" and "
								+ mms.qryHandler_mms.getQuery(1,
										"select.drugbrand.cond.5").replace("?",
									cmb[0]));
			}
			
			if (!cmb[1].equals("0")) {
				brMainQuery
						.append(" and "
								+ mms.qryHandler_mms.getQuery(1,
										"select.drugbrand.cond.0").replace("?",
										cmb[1]));
			}
		}
		else
		{
			brMainQuery.append(mms.qryHandler_mms.getQuery(1,"select.drugbrand.cond.1").replace("?", "1"));
		}
		 System.out.println("Drug Mst Main Query---->"+brMainQuery.toString());
		return brMainQuery.toString();
	}
	
	
	public String[] getRowStatus() 
	{
		//                           1                            2           3                            4                             5                                             6                                    7
		//ITEMBRAND_ID @ HOSPITAL_CODE @ ITEMTYPE_ID @ SL_NO ^ ITEM_NAME ^ ITEM_TYPE_NAME ^ IS_QUANTIFIED, 1 , 'No' , 'Yes' ^ IS_MISC, 1 , 'Yes' , 'No' ^  BRAND_RESERVE_FLAG,2,'Non Branded','Branded or Reserved' ^  edl_category
		/*
		 * "1"--->> Value Which we Want to Maaped        1         2    3   4   5    6       7
		 * "7"--->> Column Name Primary Key + 1 e.g. 10@1001@108^Amole^XAS^1000^3^2-Jan-2011^-1
		 * "blue"--->>
		 * "Exp Within"--->>Argument You Want to Show in Footer of Template
		 * 
		 */
		String[] status = 
			     {
		           "7",  "1", "#90EE90", "EDL"
		          ,"7",  "0", "#FFFF4D", "NON-EDL"
		          };
		return status;
		
	}
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {

		String masterName = "Drug Master#5^Branded or Reserved^Branded/Reserved Drug^CAE1FF";

		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "2", "B.HSTSTR_ITEM_NAME" };
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
		String search_field[] = {  "1",
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
		viewHdr.add("Item Name");
		viewHdr.add("D");
		viewHdr.add("Item Make");
		viewHdr.add("D");
		viewHdr.add("Manufacturer Name");
		viewHdr.add("D");
		viewHdr.add("Rate/Unit");
		viewHdr.add("D");
		viewHdr.add("Effective From");
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
