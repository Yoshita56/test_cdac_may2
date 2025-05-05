package mms.masters.controller.utl;

import hisglobal.hisconfig.Config;
import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class GenericItemMstUTL.
 */
public class GenericItemMstBSUTL implements MasterInterface {

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
		/*
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-add.png'	title='Add'		tabindex='0' style='cursor: pointer;'	onKeyPress='if(event.keyCode==13) addItemMst();'				onClick='addItemMst();'				></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-mo.png'		title='Modify'	tabindex='0' style='cursor: pointer;'	onKeyPress='if(event.keyCode==13) ModifyItemMst();'				onClick='ModifyItemMst();' 			></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-del.png'	title='Delete'	tabindex='0' style='cursor: pointer;'	onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");'	onClick='deleteRecords(\"DELETE\");'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-view.png'	title='View'	tabindex='0' style='cursor: pointer;'	onKeyPress='if(event.keyCode==13) genericItemView();'			onClick='genericItemView();'		></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-rpt.png'	title='Reoprt'	tabindex='0' style='cursor: pointer;'	onKeyPress='if(event.keyCode==13) report(\"REPORT\");'			onClick='report(\"REPORT\");'		></a>");
		 */
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) addItemMst();'				onClick='addItemMst();'>Add</a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) ModifyItemMst();'				onClick='ModifyItemMst();'>Modify</a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");'	onClick='deleteRecords(\"DELETE\");'>Delete</a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' data-toggle='modal' data-target='#viewModal'  onKeyPress='if(event.keyCode==13) genericItemViewBS();'	onClick='genericItemViewBS();'>View</a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");'			onClick='report(\"REPORT\");'>Report</a>");
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String col_header[] = {"Generic Item Name",
				"Inventroy Unit", "Effective From" };
		return col_header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		String[] comboHeader = { "0", "Item Category", "0", "Group Name", "0",
				"SubGroupName", "1", "Record Status" };
		return comboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() 
	{
		String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		String strSeatId = httpSession.getAttribute("SEATID").toString();
		String[] comboQuery = new String[4];
		String strCatCodes = "";
		if (httpSession.getAttribute("USERVALUE").toString() != null) 
		{
			strCatCodes = httpSession.getAttribute("USERVALUE").toString();
		}
		else 
		{
			strCatCodes = "0";
		}
		

		comboQuery[0] = mms.qryHandler_mms.getQuery(1, "select.item.10")
				.replace("?", Config.SUPER_USER_HOSPITAL_CODE);

		//comboQuery[0] = comboQuery[0].concat(mms.qryHandler_mms.getQuery(1,	"select.item.CatCodes.cond.0"));
		//comboQuery[0] = comboQuery[0].replace("?", strSeatId);

	//	comboQuery[0] = comboQuery[0].concat(mms.qryHandler_mms.getQuery(1,"select.item.CatCodes.cond.1"));
	//	comboQuery[0] = comboQuery[0].replace("?", strCatCodes);

		 //System.out.println("comboQuery[0]-"+comboQuery[0]);

		comboQuery[1] = mms.qryHandler_mms.getQuery(1, "select.item.1")
				.replace("?", Config.SUPER_USER_HOSPITAL_CODE);
		comboQuery[2] = mms.qryHandler_mms.getQuery(1, "select.item.2")
				.replace("?", Config.SUPER_USER_HOSPITAL_CODE);
		comboQuery[3] = "1^Active#0^In Active";
		return comboQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery()
	{
		String[] strDelQuery = new String[1];
		strDelQuery[0] = mms.qryHandler_mms.getQuery(1, "delete.item.0");
		// strDelQuery[1]=mms.qryHandler_mms.getQuery(1,
		// "delete.item.brandItem.0");
		//strDelQuery[1] = mms.qryHandler_mms.getQuery(1,	"delete.item.parameter.1");
		return strDelQuery;
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
	public String getMainQuery(String[] cmb) 
	{
		StringBuffer brMainQuery = new StringBuffer(500);
		String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		brMainQuery.append(mms.qryHandler_mms.getQuery(1, "select.item.0")
				.replace("?", hosCode));
		brMainQuery.append(mms.qryHandler_mms.getQuery(1, "select.item.cond.0")
				.replace("?", "100"));

		if (cmb != null) 
		{

			if (!cmb[0].equals("0")) 
			{

				brMainQuery.replace(brMainQuery.lastIndexOf("100"),
						brMainQuery.lastIndexOf("100") + 3, cmb[0]);

			}
			if (!cmb[1].equals("0")) {

				brMainQuery.append("   and "
						+ mms.qryHandler_mms.getQuery(1, "select.item.cond.1")
								.replace("?", cmb[1]));

			}

			if (!cmb[2].equals("0")) {
				brMainQuery.append(" and "
						+ mms.qryHandler_mms.getQuery(1, "select.item.cond.2")
								.replace("?", cmb[2]));

			}
		//	if (!cmb[3].equals("0")) {
				brMainQuery.append(" and "
						+ mms.qryHandler_mms.getQuery(1, "select.item.cond.5")
								.replace("?", cmb[3]));

			//}
		}

		////System.out.println("Generic Item master::::"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {

		String masterName = "Generic Item  Master";

		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "2", "hststr_item_name" };
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
		String search_field[] = { "1", "hststr_item_name" };
		return search_field;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {
		List<String> viewHdr = new ArrayList<String>();

		viewHdr.add("Generic Item Name");
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
		viewHdr.add("Serial No. Required");
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
		viewHdr.add("Whether Item has Specific Parameter");
		viewHdr.add("D");
		viewHdr.add("Remarks");
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
		return mms.qryHandler_mms.getQuery(1, "select.item.11");
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
