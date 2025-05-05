package mms.masters.controller.utl;

import hisglobal.hisconfig.Config;
import hisglobal.masterutil.MasterInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class UTLUnitMst implements MasterInterface {

	private static final long serialVersionUID = 02L;

	HttpSession httpSession = null;
	HttpServletRequest hisrequest = null;
	String strModuleId = "";

	/**
	 * returns List pages Buttons Strings.
	 */

	public String[] getColsWidth() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean reportInterFaceRequired() {
		// TODO Auto-generated method stub
		return false;
	}
	public String getButtons() {

		StringBuilder br = new StringBuilder();
		/*
		br.append("<img src='../../hisglobal/images/btn-add.png' style='cursor:pointer;cursor:hand;' title='Click To Add A Record' border=0 tabindex='1' onKeyPress='return callMe(document.forms[0]);' onClick='return callMe(document.forms[0]);'>");
		br.append("<img src='../../hisglobal/images/btn-mo.png' style='cursor:pointer;cursor:hand;' title='Select A Record To Modify'  border=0 tabindex='1' onKeyPress='edit(\"MODIFY\");' onClick='edit(\"MODIFY\");' >");
		br.append("<img src='../../hisglobal/images/btn-del.png' style='cursor:pointer;cursor:hand;' title='Select One Or More CheckBox To Delete Record(s)' border=0  tabindex='1' onKeyPress='return isBaseUnitDelete(document.forms[0]);' onClick='return isBaseUnitDelete(document.forms[0]);'>");
		br.append("<img src='../../hisglobal/images/btn-view.png' style='cursor:pointer;cursor:hand;' title='Select A Record To View' border=0  tabindex='1' onKeyPress='view(\"VIEWDATA\");' onClick='view(\"VIEWDATA\");'>");
		br.append("<img src='../../hisglobal/images/btn-rpt.png' style='cursor:pointer;cursor:hand;' title='Select A Record To Generate Reports' border=0  tabindex='1' onKeyPress='report(\"REPORT\");'  onClick='report(\"REPORT\");'>");
			*/
		
		br.append("<br><a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='return callMe(document.forms[0]);' onClick='return callMe(document.forms[0]);'><span class='add'>Add</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='edit(\"MODIFY\");' onClick='edit(\"MODIFY\");'><span class='modify'>Modify</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id=''  onKeyPress='return isBaseUnitDelete(document.forms[0]);' onClick='return isBaseUnitDelete(document.forms[0]);'><span class='delete'>Delete</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='view(\"VIEWDATA\");' onClick='view(\"VIEWDATA\");'><span class='view'>View</span></a>");
		br.append("<a href='#' class='btn btn-sm btn-primary' id='' onKeyPress='report(\"REPORT\");'  onClick='report(\"REPORT\");'><span class='report'>Report</span></a>");
		return br.toString();
	}

	/**
	 * returns Column Header String Array
	 */
	public String[] getColumnHeader() {

		String strColHeader[] = { "Unit Name", "Base Unit Name",
				"Effective Date" };

		return strColHeader;
	}

	/**
	 * returns Combo Header String Array
	 */
	public String[] getComboHeader() {

		String[] strComboHeader = { "0", "Module Name", "1", "Record Status" };

		return strComboHeader;
	}

	/**
	 * returns Combo Query String Array
	 */
	public String[] getComboQuery() {
		
		//strModuleId = httpSession.getAttribute("USERVALUE").toString();
	
		if(httpSession.getAttribute("USERVALUE").toString() != null){
			strModuleId = httpSession.getAttribute("USERVALUE").toString();
		}else{
			strModuleId = "0";
		}

	//	//System.out.println("utl strModuleId-"+strModuleId);
		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();
		String[] strComboQuery = new String[2];

		strComboQuery[0] = mms.qryHandler_mms.getQuery(1,"select.unitMst.2");
		if(!strModuleId.equals("0"))
		{
		strComboQuery[0] = strComboQuery[0].concat(" AND "
				+ mms.qryHandler_mms.getQuery(1,
						"select.unitMst.cond.2")).replace("?", strModuleId);
		}
		
		strComboQuery[1] = "1^Active#2^In Active";

		////System.out.println("strComboQuery[0] "+strComboQuery[0] );
		return strComboQuery;
	}

	/**
	 * returns Delete Query String Array
	 */
	public String[] getDeleteQuery() {

		String[] strDeleteQuery = new String[2];
		// HttpServletRequest request = new HttpServletRequest();
		String seatId = httpSession.getAttribute("SEATID").toString();

		strDeleteQuery[0] = mms.qryHandler_mms.getQuery(1,
				"delete.unitMst.0").replace("?", seatId);
		strDeleteQuery[0] = strDeleteQuery[0].concat(" where "
				+ mms.qryHandler_mms.getQuery(1,
						"delete.unitMst.cond.0"));

		strDeleteQuery[1] = mms.qryHandler_mms.getQuery(1,
				"delete.unitMst.1").replace("?", seatId);
		strDeleteQuery[1] = strDeleteQuery[1].concat(" where "
				+ mms.qryHandler_mms.getQuery(1,
						"delete.unitMst.cond.1"));

		return strDeleteQuery;
	}

	/**
	 * returns Jsp File Path String
	 */
	public String getJsFiles() {

		String jsFile = new String("../../mms/js/mms.js");
		return jsFile;
		// return null;
	}

	/**
	 * returns Main Query String
	 */
	public String getMainQuery(String[] strCmb) {

		String hosCode = httpSession.getAttribute("HOSPITAL_CODE").toString();

		////  //System.out.println("in utl hos code-->"+hosCode);

		StringBuffer brMainQuery = new StringBuffer(500);
		brMainQuery.append(
				mms.qryHandler_mms.getQuery(1, "select.unitMst.0")
						.replace("?", Config.SUPER_USER_HOSPITAL_CODE)).append(
				" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"select.unitMst.cond.0").replace("?", "9"));

		if (strCmb != null) {

			if (!strCmb[0].equals("0")) {

				brMainQuery.replace(brMainQuery.lastIndexOf("9"), brMainQuery
						.lastIndexOf("9") + 1, strCmb[0]);
				httpSession.setAttribute("strModuleId", strCmb[0]);
			}

			if (!strCmb[1].equals("0")) {

				brMainQuery.append(" AND "
						+ mms.qryHandler_mms.getQuery(1,
								"gbl.unit.cond.4").replace("?", strCmb[1]));

			}
		}

		////System.out.println("brMainQuery.toString()-"+brMainQuery.toString());
		return brMainQuery.toString();
	}

	/**
	 * returns Master Name String
	 */
	public String getMasterName() {

		String strMasterName = "Unit Master";

		return strMasterName;
	}

	/**
	 * returns Order By String Array
	 */
	public String[] getOrderBy() {

		String strOrderBy[] = { "1", "C.GSTR_UNIT_NAME", "2", "C.GSTR_UNIT_NAME" };

		return strOrderBy;
	}

	/**
	 * returns Number of Blocks per Page
	 */
	public int getPage_per_block() {

		return 10;
	}

	/**
	 * returns Number of Record Per Page
	 */
	public int getRecord_per_page() {

		return 10;
	}

	/**
	 * returns Search Field String Array
	 */
	public String[] getSearchField() {

		String strSearchField[] = { "1", "C.GSTR_UNIT_NAME" };

		return strSearchField;
	}

	/**
	 * returns View Header List
	 */
	public List<String> getViewHeader() {

		List<String> listViewHdr = new ArrayList<String>();

		listViewHdr.add("Module Name");
		listViewHdr.add("D");
		listViewHdr.add("Unit Name");
		listViewHdr.add("D");
		listViewHdr.add("Base Unit Name");
		listViewHdr.add("D");
		listViewHdr.add("Decimal Allowed");
		listViewHdr.add("D");
		listViewHdr.add("Effective Date");
		listViewHdr.add("D");
		listViewHdr.add("Remarks");
		listViewHdr.add("D");
		listViewHdr.add("Record Status");
		listViewHdr.add("D");

		return listViewHdr;
	}

	/**
	 * returns View Query String Array
	 */
	public String getViewQuery() {

		String strViewQuery = mms.qryHandler_mms.getQuery(1,
				"select.unitMst.4");

		return strViewQuery;
	}

	/**
	 * sets HttpSession Object.
	 */
	public void setHttpSession(HttpSession session) {

		this.httpSession = session;
	}
	public String isGlobal() {
		return "1";
	}
}
