package dossier.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class DossierMstUTL.
 */
public class DossierMstUTL implements MasterInterface {

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
		br.append("<br><a href='#' class='button' id='' onKeyPress='if(event.keyCode==13) addSupplierMst();' onClick='addSupplierMst();'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='button' id='' onKeyPress='if(event.keyCode==13) modifySupplierMst();' onClick='modifySupplierMst();'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='button' id='' onKeyPress='if(event.keyCode==13) deleteDossierMstRecords(\"DELETE\");' onClick='deleteDossierMstRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='button' id='' onKeyPress='if(event.keyCode==13) dossierView();' onClick='dossierView();'><span class='view'>View</span></a>");
		br.append("<a href='#' class='button' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");' onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
				
 		*/		
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) addSupplierMst();' onClick='addSupplierMst();'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) modifySupplierMst();' onClick='modifySupplierMst();'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteDossierMstRecords(\"DELETE\");' onClick='deleteDossierMstRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) dossierView();' onClick='dossierView();'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");' onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
		
		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {
		String col_header[] = { "Dossier Name","Dossier Short Name", "Service Type", "Effective From" };
		
		return col_header;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getComboHeader()
	 */
	public String[] getComboHeader() {
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[4];
			
			comboHeader[0] = "0";
			comboHeader[1] = "Service Type";
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
		//hosCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		String[] comboQuery = new String[2];
		
		/*comboQuery[0] = dossier.masters.qryHandler_dossier.getQuery(1,"select.dossierService.departmentName.0").replace("?", hosCode);
		*/
		comboQuery[0] = dossier.masters.qryHandler_dossier.getQuery(1,"select.dossierService.dossierServiceType.0");
		
		comboQuery[1] = "1^Active#2^In Active";
				
		return comboQuery;
	}

	/*
	 * 
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {

		String[] deleteQuery = new String[3];
		String seatId = httpSession.getAttribute("SEATID").toString();
		String hosp_code=httpSession.getAttribute("HOSPITAL_CODE").toString();
		
		deleteQuery[0] = dossier.masters.qryHandler_dossier.getQuery(1, "delete.dossier.0")
				.replace("?", seatId);
		deleteQuery[0] = deleteQuery[0].concat(dossier.masters.qryHandler_dossier.getQuery(1,"delete.dossier.cond.0").replace("?", hosp_code));
		deleteQuery[0] = deleteQuery[0].concat(" WHERE "
				+ dossier.masters.qryHandler_dossier.getQuery(1, "delete.dossier.cond.1"));

		deleteQuery[1] = dossier.masters.qryHandler_dossier.getQuery(1, "delete.dossier.1")
				.replace("?", seatId);
		deleteQuery[1] = deleteQuery[1].concat(dossier.masters.qryHandler_dossier.getQuery(1,"delete.dossier.cond.11").replace("?", hosp_code));
		deleteQuery[1] = deleteQuery[1].concat(" AND "+dossier.masters.qryHandler_dossier.getQuery(1,"delete.dossier.cond.12"));
		
		deleteQuery[2] = dossier.masters.qryHandler_dossier.getQuery(1, "delete.dossier.2")
				.replace("?", seatId);
		deleteQuery[2] = deleteQuery[2].concat("  "+dossier.masters.qryHandler_dossier.getQuery(1,"delete.dossier.cond.21")
				.replace("?", hosp_code));
		deleteQuery[2] = deleteQuery[2].concat(" AND "+dossier.masters.qryHandler_dossier.getQuery(1,"delete.dossier.cond.22"));
		
		
		System.out.println("Delete Query 0--->> "+deleteQuery[0]);
		System.out.println("Delete Query 1--->> "+deleteQuery[1]);
		System.out.println("Delete Query 2--->> "+deleteQuery[2]);
		
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
		String hosp_code = httpSession.getAttribute("HOSPITAL_CODE").toString();
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		hosCode	=	MmsConfigUtil.GLOBAL_HOSPITAL_CODE;
		String strTemp = "";

		brMainQuery.append(dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierService.serviceTypeName.0")
				.replace("?", hosp_code));
		brMainQuery.append(" AND " +dossier.masters.qryHandler_dossier.getQuery(1,"select.dossierService.cond.0").replace("?", "1"));
		
		 int nIndex = brMainQuery.lastIndexOf("1");
			
			if (cmb != null) {
				
				if (!cmb[1].equals("1")) {

					brMainQuery.replace(nIndex, nIndex+1, cmb[1]);
				}
				
			}
		
		if (cmb != null) {
			
			/*if (!cmb[0].equals("0")) {
				System.out.println("dept name combo value: >>>>>>>>>>>> "+cmb[0]);
				
				strTemp = dossier.masters.qryHandler_dossier.getQuery(1,
						"select.dossierService.cond.2");
				brMainQuery.append(" AND " + strTemp.replace("?", cmb[0]));
								
			}*/
			if (!cmb[0].equals("0")) {
				System.out.println("service type combo value: >>>>>>>>>>>> "+cmb[0]);
				
				strTemp = dossier.masters.qryHandler_dossier.getQuery(1,
						"select.dossierService.cond.1");
				brMainQuery.append(" AND " + strTemp.replace("?", cmb[0]));
								
			}
			
		}
		
		System.out.println("Main Query==>>  "+brMainQuery.toString());
		return brMainQuery.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getMasterName()
	 */
	public String getMasterName() {

		String masterName = "Dossier  Master";

		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getOrderBy()
	 */
	public String[] getOrderBy() {
		
		String orderBy[] = { "1", "HSTR_DOSSIER_NAME" };

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
		
		String search_field[] = { "1", "HSTR_DOSSIER_NAME" };
		
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
			viewHdr.add("Dossier Name");
			viewHdr.add("D");
			viewHdr.add("Service Type Name");
			viewHdr.add("D");
			viewHdr.add("Dossier Description");
			viewHdr.add("D");
			viewHdr.add("Department Name");
			viewHdr.add("D");
			viewHdr.add("Billing Mode");
			viewHdr.add("D");
			viewHdr.add("Entry Date");
			viewHdr.add("D");
			viewHdr.add("Record Status");
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
