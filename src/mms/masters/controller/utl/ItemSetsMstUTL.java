package mms.masters.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

import hisglobal.masterutil.MasterInterface;

// TODO: Auto-generated Javadoc
/**
 * The Class ItemSetsMstUTL.
 */
public class ItemSetsMstUTL implements MasterInterface {

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
		br.append("<a  href='#' class='btn btn-sm btn-primary' 	onKeyPress='if(event.keyCode==13) return callMe5(document.forms[0]);'	onClick='return callMe5(document.forms[0]);'	><span class='add'>Add</span>");
		br.append("<a  href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return callMe6(document.forms[0]);'	onClick='return callMe6(document.forms[0]);'	><span class='modify'>Modify</span></a>");
		br.append("<a  href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");'			onClick='deleteRecords(\"DELETE\");'			><span class='delete'>Delete</span></a>");
		br.append("<a  href='#' class='btn btn-sm btn-primary' 	onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");'					onClick='view(\"VIEWDATA\");'					><span class='view'>View</span></a>");
		br.append("<a  href='#' class='btn btn-sm btn-primary' 	onKeyPress='if(event.keyCode==13) report(\"REPORT\");'					onClick='report(\"REPORT\");'					><span class='report'>Report</span></a>");

		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		// String col_header[] = { "Item Name","Brand Name","Item Quantity(With
		// Unit)","Effective From","Record Status" };
		//String columnHdr[] = { "Drug Name", "Quantity","Effective From", "Record Status" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] columnHdr = new String[4];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) {
			columnHdr[0]= "Drug Name";
		}else{
			columnHdr[0]= "Store Name";
		}
		columnHdr[1]= "Quantity";
		columnHdr[2]= "Effective From";
		columnHdr[3]= "Record Status";
		
		return columnHdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		/*
		 * Changed by Aritra
		 * Reason: Change Request from Ajay Sir.(Remove Generic Combo.)
		 */
		/*String[] comboHeader = { "0", "Set Item Category", "0",
				"Generic Item Name", "0", "Set Name" };*/
		
		
		//String[] comboHeader = { "0", "Set Drug Category","0", "Set Name" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[4];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")){
			comboHeader[0]="0";
			comboHeader[1]="Set Category";
		}else{
			comboHeader[0]="0";
			comboHeader[1]="Set Item Category";
		}
		comboHeader[2]="0";
		comboHeader[3]="Set Name";
		return comboHeader;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		String[] comboQuery = new String[3];

		String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		String strSeatId = httpSession.getAttribute("SEATID").toString();

		String strCatCodes = "";
		if (httpSession.getAttribute("USERVALUE").toString() != null) 
		{
			strCatCodes = httpSession.getAttribute("USERVALUE").toString();
		}
		else
		{
			strCatCodes = "0";
		}

		comboQuery[0] = mms.qryHandler_mms.getQuery(1,"select.SetItemCategoryCombo.0").replace("?", hosCode);

//		comboQuery[0] = comboQuery[0].concat(mms.qryHandler_mms.getQuery(1,"select.SetItemCategoryCombo.cond.0"));
//		comboQuery[0] = comboQuery[0].replace("?", strSeatId);

		/*comboQuery[0] = comboQuery[0].concat(mms.qryHandler_mms.getQuery(1,"select.SetItemCategoryCombo.cond.1"));
		comboQuery[0] = comboQuery[0].replace("?", strCatCodes);*/

		////System.out.println("comboQuery[0]-"+comboQuery[0]);

		/*
		 * This portion is commented by Aritra on 22nd Dec, 2010 Reason: Change
		 * request from Ajay Sir:
		 * "In List Page, no need to display Generic Item Name."
		 */
		/*
		 * comboQuery[1] = mms.qryHandler_mms.getQuery(1,
		 * "select.comboNotSelected.0");
		 * 
		 * comboQuery[2] = mms.qryHandler_mms.getQuery(1,
		 * "select.comboNotSelected.0");
		 * 
		 * String[] cmbValue = (String[]) httpSession.getAttribute("MSTCOMBO");
		 * 
		 * if (cmbValue != null) {
		 * 
		 * if (cmbValue[0] != null && !cmbValue[0].equals("0")) {
		 * 
		 * String[] temp = cmbValue[0].replace('^', '#').split("#");
		 * 
		 * comboQuery[1] = mms.qryHandler_mms .getQuery(1,
		 * "select.GItemNameCombo.0") .replace("?", temp[1]) .concat( " AND " +
		 * mms.qryHandler_mms .getQuery(1, "select.GItemNameCombo.cond.0")
		 * .replace("?", hosCode) .concat( " AND " + mms.qryHandler_mms
		 * .getQuery( 1, "select.GItemNameCombo.cond.1") .replace( "?",
		 * temp[0])).concat( " AND " + mms.qryHandler_mms .getQuery( 1,
		 * "select.GItemNameCombo.cond.2") .replace( "?", temp[2])));
		 * 
		 * comboQuery[2] = mms.qryHandler_mms.getQuery(1,
		 * "select.comboNotSelected.0");
		 * 
		 * if (cmbValue[1] != null && !cmbValue[1].equals("0")) {
		 * 
		 * String[] temp1 = cmbValue[1].replace("^", "#").split("#");
		 * comboQuery[2] = mms.qryHandler_mms .getQuery(1,
		 * "select.SetNameCombo.0") .replace("?", temp1[1]) .concat( " " +
		 * mms.qryHandler_mms .getQuery(1, "select.SetNameCombo.cond.1")
		 * .replace("?", temp1[0])) .concat( " AND " + mms.qryHandler_mms
		 * .getQuery(1, "select.SetNameCombo.cond.0") .replace("?", hosCode));
		 * 
		 * } }
		 * 
		 * }
		 */// //System.out.println(comboQuery[1]);

		/*comboQuery[1] = mms.qryHandler_mms.getQuery(1,
				"select.comboNotSelected.0");
*/
		
		/*comboQuery[1] = mms.qryHandler_mms.getQuery(1,
				"select.comboNotSelected.0");*/
		comboQuery[1] = mms.qryHandler_mms
		.getQuery(1, "select.SetNameCombo.0")
		.replace("?", "HSTT_ITEMBRAND_MST") // temp[2] is the table for corresponding item.
		.concat(" "
				+ mms.qryHandler_mms.getQuery(1,
						"select.SetNameCombo.cond.1")
						)
		.concat(" AND "
				+ mms.qryHandler_mms.getQuery(1,
						"select.SetNameCombo.cond.0")
						.replace("?", hosCode));
		

		String[] cmbValue = (String[]) httpSession.getAttribute("MSTCOMBO");

		if (cmbValue != null) {

			if (cmbValue[0] != null && !cmbValue[0].equals("0")) {

				String[] temp = cmbValue[0].replace('^', '#').split("#"); //tem[0]=>item category

				/*comboQuery[1] = mms.qryHandler_mms
						.getQuery(1, "select.GItemNameCombo.0")
						.replace("?", temp[1])
						.concat(" AND "
								+ mms.qryHandler_mms
										.getQuery(1,
												"select.GItemNameCombo.cond.0")
										.replace("?", hosCode)
										.concat(" AND "
												+ mms.qryHandler_mms
														.getQuery(1,
																"select.GItemNameCombo.cond.1")
														.replace("?", temp[0]))
										.concat(" AND "
												+ mms.qryHandler_mms
														.getQuery(1,
																"select.GItemNameCombo.cond.2")
														.replace("?", temp[2])));
*/
				//String[] temp1 = cmbValue[1].replace("^", "#").split("#");
				comboQuery[1] = mms.qryHandler_mms
						.getQuery(1, "select.SetNameCombo.0")
						.replace("?", temp[2]) // temp[2] is the table for corresponding item.
						.concat(" "
								+ mms.qryHandler_mms.getQuery(1,
										"select.SetNameCombo.cond.1")
										)
						.concat(" AND "
								+ mms.qryHandler_mms.getQuery(1,
										"select.SetNameCombo.cond.0")
										.replace("?", hosCode));

			
			}

		}
		////System.out.println("Combop[1]  -->>"+comboQuery[1]);

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
		deleteQuery[0] = mms.qryHandler_mms.getQuery(1, "delete.ItemSetsMst.0")
				.replace("?", seatId);
		deleteQuery[0] = deleteQuery[0].concat("  where "
				+ mms.qryHandler_mms.getQuery(1, "delete.ItemSetsMst.cond.0"));
		// deleteQuery[0] =
		// mms.qryHandler_mms.getQuery(1,"delete.ItemSetsMst.0");
		return deleteQuery;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb) {
		String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		StringBuffer brMainQuery = new StringBuffer(500);
		brMainQuery.append(
				mms.qryHandler_mms.getQuery(1, "select.ItemSetsMst.0").replace(
						"?", hosCode)).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.ItemSetsMst.cond.0").replace("?", "0"));

		if (cmb != null) {
			if (!cmb[0].equals("0")) {

				String[] strTemp = cmb[0].replace("^", "#").split("#");

				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, strTemp[0]);
			}
		}
		/*
		 * brMainQuery.append(" AND "+
		 * mms.qryHandler_mms.getQuery(1,"select.ItemSetsMst.cond.1"
		 * ).replace("?","0")); if (cmb != null) { if (!cmb[1].equals("0")) {
		 * String[] strTemp1 = cmb[1].replace("^", "#").split("#");
		 * brMainQuery.replace(brMainQuery.lastIndexOf("0"),
		 * brMainQuery.lastIndexOf("0")+1,strTemp1[0]); } }
		 */
		brMainQuery.append(" AND "
				+ mms.qryHandler_mms.getQuery(1, "select.ItemSetsMst.cond.1")
						.replace("?", "0"));
		if (cmb != null) {
			if (!cmb[1].equals("0")) {

				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[1]);
			}
		}
		////System.out.println("Item Set Main Query-->"+brMainQuery.toString());

		return brMainQuery.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String masterName = null;
//		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
//		{	
//		   
//		   masterName = "Drug Sets Master";	
//		}
//		else
//		{
			masterName = "Item Sets Master";
//		}
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {
		String orderBy[] = { "1", "C.ITEM_NAME" };
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
		String search_field[] = { "1", "C.ITEM_NAME" };
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
		
		viewHdr.add("Set Category Name");
		viewHdr.add("D");
		viewHdr.add("Set Name");
		viewHdr.add("D");
		
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) {
			viewHdr.add("Category Name");
			viewHdr.add("D");
			viewHdr.add("Generic Drug Name");
			viewHdr.add("D");
			viewHdr.add("Drug Name");
			viewHdr.add("D");
			viewHdr.add("Drug Quantity");
			viewHdr.add("D");
		}else{
			viewHdr.add("Item Category Name");
			viewHdr.add("D");
			viewHdr.add("Generic Item Name");
			viewHdr.add("D");
			viewHdr.add("Item Name");
			viewHdr.add("D");
			viewHdr.add("Item Quantity");
			viewHdr.add("D");
		}
		
		viewHdr.add("Unit");
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
		String viewQuery = mms.qryHandler_mms.getQuery(1,
				"select.ItemSetsMst.1");
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
		return true;
	}
	public String isGlobal() {
		return "1";
	}

}
