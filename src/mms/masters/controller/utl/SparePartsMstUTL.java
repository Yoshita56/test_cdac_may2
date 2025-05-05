package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class SparePartsMstUTL.
 */
public class SparePartsMstUTL implements MasterInterface {

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

		String masterName = " Spare Part Master ";
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {

		String[] columnHdr = { "Spare Part Category Name", "Spare Part Name",
				"Effective From" };
		return columnHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */
	public String[] getSearchField() {

		String search_field[] = { "1", "C.SPAREPART_CATEGORY_NAME" };
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

		String[] comboHdr = { "0", "Category", "0", "Item Name" };
		return comboHdr;

		// return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() {
		/*
		 * String[] comboQuery = new String[2]; String hosCode =
		 * httpSession.getAttribute("HOSPITAL_CODE").toString(); comboQuery[0] =
		 * mms
		 * .qryHandler_mms.getQuery(1,"select.sparePart.ItemName.0").replace("?"
		 * , hosCode); return comboQuery;
		 */
		String[] comboQuery = new String[2];
		//String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		String hosCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
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
				
		comboQuery[0] = mms.qryHandler_mms.getQuery(1,
				"select.ItemCategoryCombo.0").replace("?", hosCode);

//		comboQuery[0] = comboQuery[0].concat(mms.qryHandler_mms.getQuery(1,
//				"select.ItemCategoryCombo.cond.0"));
	//	comboQuery[0] = comboQuery[0].replace("?", strSeatId);

	//	comboQuery[0] = comboQuery[0].concat(mms.qryHandler_mms.getQuery(1,
//				"select.ItemCategoryCombo.cond.1"));
//		comboQuery[0] = comboQuery[0].replace("?", strCatCodes);

		 //System.out.println("category comboQuery[0]-"+comboQuery[0]);

		String[] cmbValue = (String[]) httpSession.getAttribute("MSTCOMBO");
		if (cmbValue != null) {
			String[] temp = cmbValue[0].replace('^', '#').split("#");
			if (!temp[0].equalsIgnoreCase("0")) {
				comboQuery[1] = mms.qryHandler_mms
						.getQuery(1, "select.ItemName.0")
						.replace("?", temp[1])
						.concat(" AND "
								+ mms.qryHandler_mms.getQuery(1,
										"select.ItemName.cond.0").replace("?",
										hosCode));
			}
		} else {
			comboQuery[1] = mms.qryHandler_mms.getQuery(1, "select.ItemName.1");
		}
		//System.out.println("Combo query spare part ::"+comboQuery[1]);
		return comboQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * hisglobal.masterutil.MasterInterface#getMainQuery(java.lang.String[])
	 */
	public String getMainQuery(String[] cmb) {
		//String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		StringBuffer brMainQuery = new StringBuffer(500);
		String hosCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		
		/*
		 * brMainQuery.append(mms.qryHandler_mms.getQuery(1,"select.sparePartMst.0"
		 * ).replace("?",""+hosCode+"")) .append(" AND "+
		 * mms.qryHandler_mms.getQuery
		 * (1,"select.sparePartMst.cond.0").replace("?","1")); if (cmb != null)
		 * { if (!cmb[0].equals("0")) {
		 * brMainQuery.replace(brMainQuery.lastIndexOf
		 * ("1"),brMainQuery.lastIndexOf("1")+ 1,cmb[0]); } }
		 */

		brMainQuery
				.append(mms.qryHandler_mms.getQuery(1, "select.sparePartMst.0")
						.replace("?", hosCode))
				.append(" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.sparePartMst.cond.0").replace("?", "0"));

		if (cmb != null)
		{
			if (!cmb[0].equals("0")) 
			{

				String[] strTemp = cmb[0].replace("^", "#").split("#");

				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, strTemp[0]);
			}
		}
		brMainQuery.append(" AND "	+ mms.qryHandler_mms.getQuery(1, "select.sparePartMst.cond.1")	.replace("?", "0"));
		if (cmb != null) 
		{
			if (!cmb[1].equals("0")) 
			{
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),brMainQuery.lastIndexOf("0") + 1, cmb[1]);
			}
		}
		//System.out.println("MainQuery Spare Part :::"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {

		return mms.qryHandler_mms.getQuery(1, "view.sparePartMst.3");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();

		viewHdr.add("Item Category Name");
		viewHdr.add("D");
		viewHdr.add("Item Name");
		viewHdr.add("D");
		viewHdr.add("Spare Part Category Name");
		viewHdr.add("D");
		viewHdr.add("Spare Part Name");
		viewHdr.add("D");
		viewHdr.add("Effective From");
		viewHdr.add("D");
		return viewHdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "1", "C.SPAREPART_CATEGORY_NAME" };
		return orderBy;
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
				.getQuery(1, "delete.sparePartMst.0").replace("?", seatId);
		deleteQuery[0] = deleteQuery[0].concat("  where "
				+ mms.qryHandler_mms.getQuery(1, "delete.sparePartMst.cond.0"));

		return deleteQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() {
		StringBuilder br = new StringBuilder();
		br.append("<a  href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],5);'	onClick='return callComboAdd(document.forms[0],5);'><span class='add'>Add</span>");
		br.append("<a  href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],5);' onClick='return callComboModify(document.forms[0],5);' ><span class='modify'>Modify</span></a>");
		br.append("<a  href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");'	onClick='view(\"VIEWDATA\");'><span class='view'>View</span></a>");
		br.append("<a  href='#' class='btn btn-sm btn-primary' onKeyPress='if(event.keyCode==13) report(\"REPORT\");' onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");

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
		// return null;

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
