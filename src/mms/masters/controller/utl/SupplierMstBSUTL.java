package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class SupplierMstBSUTL.
 */
public class SupplierMstBSUTL implements MasterInterface {

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
		/*br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-add.png' 	tabindex='0' style='cursor: pointer;'	title='Add'		onKeyPress='if(event.keyCode==13) addSupplierMst();'			onClick='addSupplierMst();'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-mo.png'  	tabindex='0' style='cursor: pointer;'  	title='Modify'	onKeyPress='if(event.keyCode==13) edit(\"MODIFY\");'			onClick='edit(\"MODIFY\");' ></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-del.png' 	tabindex='0' style='cursor: pointer;' 	title='Delete' 	onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 	onClick='deleteRecords(\"DELETE\");' ></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-view.png'	tabindex='0' style='cursor: pointer;'	title='View'  	onKeyPress='if(event.keyCode==13) supplierView();'  			onClick='supplierView();'></a>");
		br.append("<a style=cursor:pointer><img src='../../hisglobal/images/btn-rpt.png' 	tabindex='0' style='cursor: pointer;'	title='Report'	onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  		onClick='report(\"REPORT\");'></a>");
		*/
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) addSupplierMst();' onClick='addSupplierMst();'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) edit(\"MODIFY\");' onClick='edit(\"MODIFY\");'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' data-toggle='modal' data-target='#viewModal'onKeyPress='if(event.keyCode==13) supplierViewBS();' onClick='supplierViewBS();'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");' onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
				
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String col_header[] = { "Supplier Name", "Supplier Status",
				"Whether Black Listed" };
		return col_header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		//String[] comboHeader = { "0", "Drug Category Name", "1","Record Status" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[4];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	
			comboHeader[0] = "0";
			comboHeader[1] = "Category Name";
		}else{
			comboHeader[0] = "0";
			comboHeader[1] = "Item Category Name";
		}
		comboHeader[2] = "1";
		comboHeader[3] = "Record Status";
		return comboHeader;// comboHeader;
	}

	/*
	 * 
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboQuery()
	 */
	public String[] getComboQuery() 
	{
		
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		hosCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		String[] comboQuery = new String[2];

		String strCatCodes = "";
		
		if (httpSession.getAttribute("USERVALUE").toString() != null) 
		{
			strCatCodes = httpSession.getAttribute("USERVALUE").toString();
		} 
		else 
		{
			strCatCodes = "0";
		}
		comboQuery[0] = mms.qryHandler_mms.getQuery(1,"select.supplier.ItemCategory.0").replace("?", hosCode);

		//comboQuery[0] = comboQuery[0].concat(mms.qryHandler_mms.getQuery(1,"select.supplier.ItemCategory.cond.1"));
		//comboQuery[0] = comboQuery[0].replace("?", strCatCodes);

		comboQuery[1] = "1^Active#2^In Active";
		return comboQuery;
	}

	/*
	 * 
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {

		String[] deleteQuery = new String[2];
		String seatId = httpSession.getAttribute("SEATID").toString();
		
		deleteQuery[0] = mms.qryHandler_mms.getQuery(1, "delete.supply.0")
				.replace("?", seatId);
		deleteQuery[0] = deleteQuery[0].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1, "delete.supply.cond.0"));

		
		
		deleteQuery[1] = mms.qryHandler_mms.getQuery(1, "delete.supply.1")
				.replace("?", seatId);
		deleteQuery[1] = deleteQuery[1].concat(" WHERE "
				+ mms.qryHandler_mms.getQuery(1, "delete.supply.cond.1"));
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
		hosCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		
		String strTemp = "";

		brMainQuery.append(mms.qryHandler_mms.getQuery(1, "select.supplier.0")
				.replace("?", hosCode));
		brMainQuery.append(mms.qryHandler_mms.getQuery(1,
				"select.supplier.cond.1").replace("?", "0"));

		if (cmb != null) {

			if (!cmb[0].equals("0")) {
				brMainQuery.replace(brMainQuery.lastIndexOf("0"),
						brMainQuery.lastIndexOf("0") + 1, cmb[0]);

			}
			if (!cmb[1].equals("0")) {
				strTemp = mms.qryHandler_mms.getQuery(1,
						"select.supplier.cond.0");
				brMainQuery.append(" and " + strTemp.replace("?", cmb[1]));
			}

		}

		return brMainQuery.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {

		String masterName = "Supplier  Master";

		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "1", "HSTSTR_SUPPLIER_NAME" };
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

		String search_field[] = { "1", "HSTSTR_SUPPLIER_NAME" };
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
		viewHdr.add("Ward Type");
		viewHdr.add("D");
		viewHdr.add("Ward Name");
		viewHdr.add("D");
		viewHdr.add("Bed No");
		viewHdr.add("D");
		viewHdr.add("Building");
		viewHdr.add("D");
		viewHdr.add("Building");
		viewHdr.add("D");
		viewHdr.add("Block");
		viewHdr.add("D");
		viewHdr.add("Effective From");
		viewHdr.add("D");
		viewHdr.add("Effective To");
		viewHdr.add("D");
		viewHdr.add("Remark");
		viewHdr.add("D");
		viewHdr.add("Record Status");
		viewHdr.add("D");
		// return null;
		return viewHdr;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {

		// String viewQuery = "";
		// return viewQuery;
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
