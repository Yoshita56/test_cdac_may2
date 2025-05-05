package dossier.masters.controller.utl;

import hisglobal.hisconfig.Config;
import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class DossierItemMstUTL.
 */
public class DossierItemMstUTL implements MasterInterface {

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

		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String masterName = null;
		
			masterName = "Dossier Item Master";
		
		return masterName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getColumnHeader()
	 */
	public String[] getColumnHeader() {

		//String[] columnHdr = { "Drug Name", "Drug Type", "Reorder Level","Max Level", "Effective From" };
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] columnHdr = new String[3];
		
		columnHdr[0]=" Dossier Name ";
		columnHdr[1]=" Service Type Name ";
		columnHdr[2]="  Dossier Cost ";
		//columnHdr[3]=" Store Name";
		
		return columnHdr;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getSearchField()
	 */
	public String[] getSearchField() {
		String arrStrSearch_field[] = { "1",
				"dossier_mst.get_dossier_name(HNUM_DOSSIER_ID,GNUM_HOSPITAL_CODE)" };

		return arrStrSearch_field;
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

		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] comboHeader = new String[6];
		/*
		comboHeader[0] = "0";
		comboHeader[1] = "Dossier Name";
		comboHeader[2] = "0";
		comboHeader[3] = "Store Name";
		comboHeader[4] = "1";
		comboHeader[5] = "Record Status";
		*/
		
		comboHeader[0] = "0";
		comboHeader[1] = "Service Type Name";
		comboHeader[2] = "0";
		comboHeader[3] = "Dossier Name";
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

		String[] comboQuery = new String[3];
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		String strSeatId = httpSession.getAttribute("SEATID").toString();

		System.out.println("hospital code --->>>>>>>>... "+hosCode);
		System.out.println("seat id --->>>>>>>>... "+strSeatId);

		/*comboQuery[0] = dossier.masters.qryHandler_dossier.getQuery(1,"select.dossierService.departmentName.0").replace("?", hosCode);
		*/
		comboQuery[0] = dossier.masters.qryHandler_dossier.getQuery(1,"select.dossierService.dossierServiceType.0");
		
		comboQuery[1] = dossier.masters.qryHandler_dossier.getQuery(1,"select.dossierItem.dossierName.0").replace("?", hosCode);
		/*comboQuery[1] =  comboQuery[1].concat(" AND "
				+ dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItem.dossierName.1").replace("?", "#1#"));
		*/
		comboQuery[1] =  comboQuery[1].concat(" AND "
				+ dossier.masters.qryHandler_dossier.getQuery(1, "select.dossierItem.dossierName.2")
				.replace("?", "#1#"));
		comboQuery[1] =  comboQuery[1].concat(" ORDER BY HSTR_DOSSIER_NAME ");
			
		/*comboQuery[0] = dossier.masters.qryHandler_dossier.getQuery(1,
				"select.dossierItem.dossierName.0");
		comboQuery[0] = comboQuery[0].replace("?", hosCode);

		comboQuery[1] = dossier.masters.qryHandler_dossier.getQuery(1,
				"select.DossierStoreItemCategory.0").replace("?", hosCode);*/

		comboQuery[2] = "1^Active#2^In Active";

		System.out.println("service type Combo Query::::->>>"+comboQuery[0]);
		System.out.println("dossier name Combo Query::::->>>"+comboQuery[1]);
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
		String strTemp="";
		StringBuffer brMainQuery = new StringBuffer();

		brMainQuery.append(
				dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItem.0").replace(
						"?", hosCode));
		
		brMainQuery.append(" AND " +dossier.masters.qryHandler_dossier.getQuery(1,"select.dossierService.cond.0").replace("?", "1"));
		
		 int nIndex = brMainQuery.lastIndexOf("1");
			
		if (cmb != null) {
			
			if (!cmb[2].equals("1")) {

				brMainQuery.replace(nIndex, nIndex+1, cmb[2]);
			}
			
		}
		if (cmb != null) {
			/*if (!cmb[0].equals("0")) {
				System.out.println("dossier name combo value: >>>>>>>>>>>> "+cmb[0]);
				
				strTemp = dossier.masters.qryHandler_dossier.getQuery(1,
						"select.dossierItem.cond.2");
				brMainQuery.append(" AND " + strTemp.replace("?", cmb[0]));
								
			}*/
			if (!cmb[0].equals("0")) {
				System.out.println("service type name combo value: >>>>>>>>>>>> "+cmb[0]);
				
				strTemp = dossier.masters.qryHandler_dossier.getQuery(1,
						"select.dossierItem.cond.1");
				brMainQuery.append(" AND " + strTemp.replace("?", cmb[0]));
								
			}
			if (!cmb[1].equals("0")) {
				strTemp = dossier.masters.qryHandler_dossier.getQuery(1,
						"select.dossierItem.cond.3");
				brMainQuery.append(" AND " + strTemp.replace("?", cmb[1]));
			}

		}	
		
		System.out.println("Store Item Main Qry:::"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewQuery()
	 */
	public String getViewQuery() {

		String[] viewQuery = new String[1];
		String seatId = httpSession.getAttribute("SEATID").toString();
		String hosp_code=httpSession.getAttribute("HOSPITAL_CODE").toString();
		
		viewQuery[0] = dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItemView.0");
		viewQuery[0] = viewQuery[0].concat(dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItemView.1").replace("?",hosp_code));
		viewQuery[0] = viewQuery[0].concat(dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItemView.2"));
		viewQuery[0] = viewQuery[0].concat(dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItemView.3").replace("?",hosp_code));
		viewQuery[0] = viewQuery[0].concat(dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItemView.4"));
		viewQuery[0] = viewQuery[0].concat(dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItemView.5"));
		viewQuery[0] = viewQuery[0].concat(dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItemView.6").replace("?",hosp_code));
		viewQuery[0] = viewQuery[0].concat(dossier.masters.qryHandler_dossier.getQuery(1, "select.DossierItemView.7").replace("?", seatId));
		
		System.out.println("view query ------>>>>>> "+viewQuery[0]);
		return viewQuery[0]; 
		

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getViewHeader()
	 */
	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());
		
			viewHdr.add("Dossier Name");
			viewHdr.add("D");
			viewHdr.add("Store Name");
			viewHdr.add("D");
			viewHdr.add("Item Name");
			viewHdr.add("D");
			viewHdr.add("Record Status");
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
		String arrOrderBy[] = {
				"1",
				"dossier_mst.get_dossier_name(HNUM_DOSSIER_ID,GNUM_HOSPITAL_CODE)",
				"3",
				"(SELECT DISTINCT HNUM_DOSSIER_PRICE FROM HGDT_DOSSIER_MST WHERE HNUM_DOSSIER_ID\\=B.HNUM_DOSSIER_ID)",
				/*"4",
				"UPPER(dossier_mst.get_store_name(HNUM_STORE_ID,?)) "*/
				};

		return arrOrderBy;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getDeleteQuery()
	 */
	public String[] getDeleteQuery() {

		String[] delQuery = new String[2];
		String seatId = httpSession.getAttribute("SEATID").toString();
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		delQuery[0] = dossier.masters.qryHandler_dossier.getQuery(1, "delete.DossierItem.0")
				.replace("?", seatId);

		delQuery[0] = delQuery[0].concat(" WHERE "
				+ dossier.masters.qryHandler_dossier.getQuery(1, "delete.DossierItem.cond.0"));
		
		delQuery[0] = delQuery[0].concat(dossier.masters.qryHandler_dossier.getQuery(1, "delete.DossierItem.cond.1")
				.replace("?", hosCode));

		delQuery[1] = dossier.masters.qryHandler_dossier.getQuery(1, "delete.DossierItem.1");
		
		delQuery[1] = delQuery[1].concat(dossier.masters.qryHandler_dossier.getQuery(1, "delete.DossierItem.cond.2")
				.replace("?", hosCode));

		System.out.println("delete query 0----->>>>> "+delQuery[0]);
		System.out.println("delete query 1----->>>>> "+delQuery[1]);
		
		return delQuery;
		// return null;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getButtons()
	 */
	public String getButtons() {

		StringBuilder br = new StringBuilder();
		/*
		br.append("<img src='../../hisglobal/images/btn-add.png'		tabindex='0' 		style='cursor: pointer;' title='Add' 			onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],4);' 	onClick='return callComboAdd(document.forms[0],4);' />");
		br.append("<img src='../../hisglobal/images/btn-mo.png'			tabindex='0'		style='cursor: pointer;' title='Modify' 		onKeyPress='if(event.keyCode==13) return callComboModify(document.forms[0],4);' onClick='return callComboModify(document.forms[0],4);' />");
		br.append("<img src='../../hisglobal/images/btn-del.png'		tabindex='0'		style='cursor: pointer;' title='Delete' 		onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' 					onClick='deleteRecords(\"DELETE\");' />");
		br.append("<img src='../../hisglobal/images/btn-view.png'		tabindex='0'		style='cursor: pointer;' title='View' 			onKeyPress='if(event.keyCode==13) view(\"VIEWDATA\");' 							onClick='view(\"VIEWDATA\");' />");
		br.append("<img src='../../hisglobal/images/btn-rpt.png' 		tabindex='0'		style='cursor: pointer;' title='Report' 		onKeyPress='if(event.keyCode==13) report(\"REPORT\");'  						onClick='report(\"REPORT\");' />");
		br.append("<img src='../../hisglobal/images/btn-batchupdate.png'	tabindex='0'	style='cursor: pointer;' title='Batch Update' 	onKeyPress='if(event.keyCode==13) return callBatchUpdate(document.forms[0]);'  	onClick='return callBatchUpdate(document.forms[0]);' />");
		*/
		/*
		br.append("<br><a href='#' class='button' id='dossierItemMstAdd' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],4);' onClick='return callComboAdd(document.forms[0],4);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='button' id='' onKeyPress='if(event.keyCode==13) modifyDossierItemMst();' onClick='modifyDossierItemMst();'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='button' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='button' id='' onKeyPress='if(event.keyCode==13) dossierItemView();' onClick='dossierItemView();'><span class='view'>View</span></a>");
		br.append("<a href='#' class='button' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");' onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
		*/
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='dossierItemMstAdd' onKeyPress='if(event.keyCode==13) return callComboAdd(document.forms[0],4);' onClick='return callComboAdd(document.forms[0],4);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) modifyDossierItemMst();' onClick='modifyDossierItemMst();'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) deleteRecords(\"DELETE\");' onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) dossierItemView();' onClick='dossierItemView();'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='if(event.keyCode==13) report(\"REPORT\");' onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");


		return br.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see hisglobal.masterutil.MasterInterface#getJsFiles()
	 */
	public String getJsFiles() {

		String jsFile = new String("/INVMGM/dossier/masters/DossierMaster.js");
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
