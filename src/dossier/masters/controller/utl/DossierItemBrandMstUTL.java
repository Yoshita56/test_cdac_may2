package dossier.masters.controller.utl;

import hisglobal.hisconfig.Config;
import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

public class DossierItemBrandMstUTL implements MasterInterface {

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
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) itemBrandMstComboAdd(document.forms[0]);' onClick='itemBrandMstComboAdd(document.forms[0]);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) edit(\"MODIFY\");' onClick='edit(\"MODIFY\");'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) itemView();' onClick='itemView();'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");' onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String col_header[] = { "Item Kit Name","Default Rate", "Department Name" };
		return col_header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		String[] comboHeader = { "0", "Department Name", "1",
				"Record Status" };
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
		String hosp_code = httpSession.getAttribute("HOSPITAL_CODE").toString();

		String[] comboQuery = new String[2];

		String strCatCodes = "";
		if (httpSession.getAttribute("USERVALUE").toString() != null) {
			strCatCodes = httpSession.getAttribute("USERVALUE").toString();
			System.out.println("strCatCodes"+strCatCodes);
		} else {
			strCatCodes = "0";
		}

		/*comboQuery[0] = dossier.masters.qryHandler_dossier.getQuery(1,
				"select.DossierItemBrandMstCat.0").replace("?", hosp_code);
		comboQuery[0] = comboQuery[0].concat(" AND "
				+ dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItemBrandMstCat.1").replace("?", strSeatId));
		*/
		
		 comboQuery[0] = dossier.masters.qryHandler_dossier.getQuery(1,
				"select.dossierService.departmentName.0").replace("?", hosp_code);
		
		comboQuery[1] = "1^Active#2^In Active";
		
		return comboQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {
		String[] deleteQuery = new String[3];
		String seatId = httpSession.getAttribute("SEATID").toString();
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		deleteQuery[0] = dossier.masters.qryHandler_dossier.getQuery(1, "delete.dossierItemBrandMiscMst.0").replace("?",seatId);
		deleteQuery[0] = deleteQuery[0].concat(" WHERE "
				+ dossier.masters.qryHandler_dossier.getQuery(1, "delete.dossierItemBrandMiscMst.cond.1"));
		
		deleteQuery[1] = dossier.masters.qryHandler_dossier.getQuery(1, "delete.dossierItemBrandMiscItemMst.0").replace("?",seatId);
		deleteQuery[1] = deleteQuery[1].concat(" WHERE "
				+ dossier.masters.qryHandler_dossier.getQuery(1, "delete.dossierItemBrandMiscItemMst.cond.0"));
		
		deleteQuery[2] = dossier.masters.qryHandler_dossier.getQuery(1, "delete.dossierItemBrandMst.0").replace("?",seatId);
		deleteQuery[2] = deleteQuery[2].concat(" WHERE "
				+ dossier.masters.qryHandler_dossier.getQuery(1, "delete.dossierItemBrandMst.cond.0"));
		
		System.out.println("delete query 0--->> "+deleteQuery[0]);
		System.out.println("delete query 1--->> "+deleteQuery[1]);
		System.out.println("delete query 2--->> "+deleteQuery[2]);
		
		return deleteQuery;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {

		String jsFile = "/INVMGM/dossier/masters/DossierMaster.js";
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

		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		String seatId = httpSession.getAttribute("SEATID").toString();
		
		brMainQuery.append(dossier.masters.qryHandler_dossier.getQuery(1,
				"select.DossierItemBrandMst.0").replace("?", hosCode));
		brMainQuery.append(dossier.masters.qryHandler_dossier.getQuery(1,
				"select.DossierItemBrandMst.1").replace("?", seatId));
		brMainQuery.append(" AND " +dossier.masters.qryHandler_dossier.getQuery(1,"select.DossierItemBrandMst.cond.0").replace("?", "1"));
		
		 int nIndex = brMainQuery.lastIndexOf("1");
			
			if (cmb != null) {
				
				if (!cmb[1].equals("1")) {

					brMainQuery.replace(nIndex, nIndex+1, cmb[1]);
				}
				
			}
		
		if (cmb != null) {

			if (!cmb[0].equals("0")) {
				brMainQuery.append(" and "
						+ dossier.masters.qryHandler_dossier.getQuery(1,
								"select.DossierItemBrandMst.cond.3").replace("?",
								cmb[0]));
			}

		}
		
		
		System.out.println("Main Query"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {

		String masterName = "Miscellaneous Item Kit Master";

		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {

		String orderBy[] = { "1", "HSTR_MISC_NAME" };
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
		String search_field[] = { "1",	"HSTR_MISC_NAME" };
		return search_field;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {
		/*
			 List<String> viewHdr = new ArrayList<String>(); 
			 viewHdr.add("Item Category");
			 viewHdr.add("D"); 
			 viewHdr.add("Group Name");
			 viewHdr.add("D"); 
			 viewHdr.add("Item Name");
			 viewHdr.add("D"); 
			 viewHdr.add("Default Rate");
			 viewHdr.add("D"); 
			 viewHdr.add("Entry Date");
			 viewHdr.add("D"); 
			 viewHdr.add("Record Status");
			 viewHdr.add("D"); 
			 viewHdr.add("Is Miscellaneous");
			 viewHdr.add("D"); 
			 
			 
			 return viewHdr;
		*/
			return null;
		 
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

