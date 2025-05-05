package mms.masters.controller.utl;

import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

public class UTLUnitValueMst implements MasterInterface {

	private static final long serialVersionUID = 02L;

	HttpSession httpSession = null;
	String strModuleId = "";

	public void setHttpSession(HttpSession session) {

		httpSession = session;

	}


	public String[] getColsWidth() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean reportInterFaceRequired() {
		// TODO Auto-generated method stub
		return true;
	}
	public String getMasterName() {

		String masterName = " Unit Value Master ";

		return masterName;
	}

	public String[] getColumnHeader() {

		String[] columnHeader = { "From Unit", "To Unit", "Converted Value",
				"Effective From" };

		return columnHeader;

	}

	public String[] getSearchField() {

		String[] searchField = { "1",
				"BILL_MST.GETUNITNAME(GNUM_HOSPITAL_CODE,GNUM_FRMUNIT_ID)",
				"2", "BILL_MST.GETUNITNAME(GNUM_HOSPITAL_CODE,GNUM_TOUNIT_ID)",
				"3", "GNUM_CONVERTED_UNITVALUE" };

		return searchField;

	}

	public int getRecord_per_page() {

		return 10;
	}

	public int getPage_per_block() {

		return 10;
	}

	public String getMainQuery(String[] strCmb) {
		StringBuffer brMainQuery = new StringBuffer(500);
		brMainQuery.append(
				mms.qryHandler_mms.getQuery(1, "select.unitvalue.7")
						.replace(
								"?",
								MmsConfigUtil.GLOBAL_HOSPITAL_CODE)).append(
				" and "
						+ mms.qryHandler_mms.getQuery(1,
								"select.unitvalue.cond.0").replace("?", "3"));

		if (strCmb != null) {
			// condition first
			if (!strCmb[1].equals("0")) {

				brMainQuery.replace(brMainQuery.lastIndexOf("3"), brMainQuery
						.lastIndexOf("3") + 1, strCmb[1]);
				// httpSession.setAttribute("isValid",strCmb[0]);
			}

			// condition second
			brMainQuery=brMainQuery.append(" AND "
					+ mms.qryHandler_mms.getQuery(1,
							"select.unitvalue.cond.1").replace("?","0"));
			if (!strCmb[0].equals("0"))
				brMainQuery.replace(brMainQuery.lastIndexOf("0"), brMainQuery
						.lastIndexOf("0") + 1, strCmb[0]);
			httpSession.setAttribute("strModuleId", strCmb[0]);
		}

		//System.out.println("brMainQuery.toString()-"+brMainQuery.toString());
		return brMainQuery.toString();

	}

	public String[] getComboHeader() {
		String[] comboHeader = { "0", "Module Name", "1", "Record Status" };
		return comboHeader;
	}

	public String[] getComboQuery() {

		String[] comboQuery = new String[4];
		
		
		if(httpSession.getAttribute("USERVALUE").toString() != null){
			strModuleId = httpSession.getAttribute("USERVALUE").toString();
		}else{
			strModuleId = "0";
		}

	//	//System.out.println("utl strModuleId-"+strModuleId);
		String hosCode = MmsConfigUtil.GLOBAL_HOSPITAL_CODE; //httpSession.getAttribute("HOSPITAL_CODE").toString();
		

		comboQuery[0] = mms.qryHandler_mms.getQuery(1,
		"select.unitvalue.1").replace("?",hosCode);
		
	if(!strModuleId.equals("0"))
		{
		comboQuery[0] = comboQuery[0].concat(" AND "
				+ mms.qryHandler_mms.getQuery(1,
						"select.unitValMst.cond.2")).replace("?", strModuleId);
		}
		
		comboQuery[1] = "1^Active#2^InActive";

	//	//System.out.println("comboQuery[0"+comboQuery[0]);
		return comboQuery;

	}

	public String getViewQuery() {
		return mms.qryHandler_mms.getQuery(1, "select.unitvalue.2");

	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		viewHdr.add("Module Name");
		viewHdr.add("D");
		viewHdr.add("From Unit");
		viewHdr.add("D");
		viewHdr.add("To Unit");
		viewHdr.add("D");
		viewHdr.add("Converted Value");
		viewHdr.add("D");
		viewHdr.add("Effective From");
		viewHdr.add("D");
		viewHdr.add("Remarks");
		viewHdr.add("D");
		viewHdr.add("Record Status");
		viewHdr.add("D");

		return viewHdr;

	}

	public String[] getOrderBy() {
		String orderBy[] = { "1", "GNUM_FRMUNIT_ID" };

		return orderBy;

	}

	public String[] getDeleteQuery() {
		String deleteQuery[] = new String[1];
		String seatId = httpSession.getAttribute("SEATID").toString();
		deleteQuery[0] = mms.qryHandler_mms.getQuery(1,
				"delete.unitvalue.0").replace("?", seatId);
		deleteQuery[0] = deleteQuery[0].concat(" where "
				+ mms.qryHandler_mms.getQuery(1,
						"delete.unitvalue.cond.0"));
		return deleteQuery;

	}

	public String getButtons() {
		StringBuilder br = new StringBuilder();

		/*
		br.append("<img src='../../hisglobal/images/btn-add.png' style='cursor:pointer;cursor:hand;' title='Click To Add A Record' border=0 tabindex='1' onKeyPress='add(\"ADD\");' onClick='add(\"ADD\");' >");
		br.append("<img src='../../hisglobal/images/btn-mo.png' style='cursor:pointer;cursor:hand;' title='Select A Record To Modify' border=0 tabindex='1' onKeyPress='edit(\"MODIFY\");' onClick='edit(\"MODIFY\");' >");
		br.append("<img src='../../hisglobal/images/btn-del.png' style='cursor:pointer;cursor:hand;' title='Select One Or More CheckBox To Delete Record(s)' border=0  tabindex='1' onKeyPress='deleteRecords(\"DELETE\");' onClick='deleteRecords(\"DELETE\");'>");
		br.append("<img src='../../hisglobal/images/btn-view.png' style='cursor:pointer;cursor:hand;' title='Select A Record To View' border=0  tabindex='1' onKeyPress='view(\"VIEWDATA\");' onClick='view(\"VIEWDATA\");'>");
		br.append("<img src='../../hisglobal/images/btn-rpt.png' style='cursor:pointer;cursor:hand;' title='Select A Record To Generate Reoprts' border=0  tabindex='1' onKeyPress='report(\"REPORT\");'  onClick='report(\"REPORT\");'>");
		 */
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' title='Click To Add A Record' tabindex='1' onKeyPress='add(\"ADD\");' onClick='add(\"ADD\");'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' title='Select A Record To Modify' tabindex='1' onKeyPress='edit(\"MODIFY\");' onClick='edit(\"MODIFY\");'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' title='Select One Or More CheckBox To Delete Record(s)' tabindex='1' onKeyPress='deleteRecords(\"DELETE\");' onClick='deleteRecords(\"DELETE\");'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' title='Select A Record To View' tabindex='1' onKeyPress='view(\"VIEWDATA\");' onClick='view(\"VIEWDATA\");'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' title='Select A Record To Generate Reoprts' tabindex='1' onKeyPress='report(\"REPORT\");'  onClick='report(\"REPORT\");'>Report</span></a>");
	
		
		return br.toString();
	}

	public String getJsFiles() {
		String files = "../../billing/js/billing.js";
		return files;

	}
	public String isGlobal() {
		return "1";
	}

}
