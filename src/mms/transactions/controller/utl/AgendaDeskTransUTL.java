/**
 * 
 */
package mms.transactions.controller.utl;

import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

/**
 * @author Pankaj Kumar Creation Date:- 8-4-2009 Modifying Date:-2-June-2009
 *         Used For:- Agenda Util Page Team Lead By:- Ajay Kumar Gupta Module:-
 *         MMS(HIS Project)
 * 
 */
public class AgendaDeskTransUTL extends TransInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 02L;
	HttpSession httpSession = null;
	String[] cmbVal = null;

	public void setHttpSession(HttpSession session) {
		this.httpSession = session;
	}

	public void setCombo(String[] cmb) {
		this.cmbVal = cmb;
	}

	public String getMasterName() {
		String masterName = "Compilation Desk";
		return masterName;
	}

	public int getRecord_per_page() {
		return 12;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) {
		String strHospCode = (String) httpSession.getAttribute("HOSPITAL_CODE");
		StringBuffer brMainQuery = new StringBuffer(1500);
	 
		MmsConfigUtil mmsConfig = new MmsConfigUtil(strHospCode);
		
		if (cmb != null&& cmbVal!=null) {
			brMainQuery
					.append("SELECT HSTNUM_STORE_ID||'@'||HSTNUM_AGENDA_NO||'@'");
			brMainQuery.append("||SSTNUM_ITEM_CAT_NO||'@'||GNUM_HOSPITAL_CODE");
			brMainQuery
					.append("||'^'||HSTNUM_AGENDA_NO||'^'||to_char(HSTDT_AGENDA_DATE,'DD-Mon-yyyy')||'^'||");
			
			//brMainQuery.append(" MMS_MST.GET_PERIOD_NAME(GNUM_HOSPITAL_CODE,HSTSTR_AGENDA_PERIOD) AS DATA");
			
			brMainQuery.append(" MMS_MST.GET_INDENTTYPE_NAME(1::numeric,GNUM_HOSPITAL_CODE::numeric,SSTNUM_REQTYPE_ID::numeric) || '^' || decode(hstnum_req_no,0,'---',hstnum_req_no) AS DATA");
			
			if (cmb[2].equals("0") || cmb[2].equals("111") )
			{
			brMainQuery.append(" FROM HSTT_AGENDA_DTL A WHERE GNUM_ISVALID = 1 ");
			}
			else
			{
			brMainQuery.append(" FROM HSTT_AGENDA_DTL A WHERE GNUM_ISVALID = 1 AND (");
			}
			
			if(cmb[2].equals("1-39"))
				brMainQuery.append("HSTNUM_AGENDA_STATUS >=1 AND HSTNUM_AGENDA_STATUS <=39");
			
			else if (cmb[2].equals("0") ||  cmb[2].equals("111")) {
				
			}
			else{
				brMainQuery.append("HSTNUM_AGENDA_STATUS = ");
				brMainQuery.append(cmbVal[2]);
			}
			if (cmb[2].equals("0") || cmb[2].equals("111")){
				
				brMainQuery.append(" AND HSTNUM_AGENDA_STATUS <> 50");
			}
			else
			brMainQuery.append(")");
			
			if(cmb[2].equals("111"))
				brMainQuery.append(" and exists (select 'x' from sstt_issue_dtl where hstnum_req_no = a.hstnum_req_no and gnum_isvalid = 1) and not exists (select 'x' from hstt_acknowledge_dtl where hstnum_request_no = a.hstnum_req_no and gnum_isvalid = 1) ");
			if(cmb[0].equals("0"))
			{
			}
			else
			{	
			brMainQuery.append(" AND  HSTNUM_STORE_ID = ");
			brMainQuery.append(cmbVal[0]);
			}
			brMainQuery.append(" AND GNUM_HOSPITAL_CODE = ");
			brMainQuery.append(strHospCode);
			if(cmbVal[1]!=null && !cmbVal[1].equals("0")){
				brMainQuery.append(" AND SSTNUM_ITEM_CAT_NO = ");
				brMainQuery.append(cmbVal[1]);
			}
			if (cmb[2].equals("99") || cmb[2].equals("50")) {
				
				String strFinancialStartDate = mmsConfig.getStrFinancialStartDate(cmbVal[0], strHospCode);
				String strFinancialEndDate = mmsConfig.getStrFinancialEndDate(cmbVal[0], strHospCode);
				
				brMainQuery.append(" AND HSTDT_FINANCIAL_START_DATE = to_date(");
				brMainQuery.append("'"+strFinancialStartDate+"'");
				brMainQuery.append(",'DD-Mon-YYYY')");
				brMainQuery.append(" AND HSTDT_FINANCIAL_END_DATE = to_date(");
				brMainQuery.append("'"+strFinancialEndDate+"'");
				brMainQuery.append(",'DD-Mon-YYYY')");
			}
		} else {
			brMainQuery
					.append("SELECT HSTNUM_STORE_ID||'@'||HSTNUM_AGENDA_NO||'@'");
			brMainQuery.append("||SSTNUM_ITEM_CAT_NO||'@'||GNUM_HOSPITAL_CODE");
			brMainQuery.append("||'^'||HSTNUM_AGENDA_NO||'^'||HSTDT_AGENDA_DATE||'^'||");
			//brMainQuery.append("MMS_MST.GET_PERIOD_NAME(GNUM_HOSPITAL_CODE,HSTSTR_AGENDA_PERIOD) AS DATA");
			brMainQuery.append(" MMS_MST.GET_INDENTTYPE_NAME(1::numeric,GNUM_HOSPITAL_CODE::numeric,SSTNUM_REQTYPE_ID::numeric) || '^' || decode(hstnum_req_no,0,'---',hstnum_req_no) AS DATA");
			brMainQuery.append(" FROM HSTT_AGENDA_DTL WHERE (HSTNUM_AGENDA_STATUS = 0");
			brMainQuery.append(" OR HSTNUM_LST_APPROVE_SEATID IS NULL )");
			//brMainQuery.append("AND  HSTNUM_STORE_ID = 0");
			brMainQuery.append(" AND GNUM_HOSPITAL_CODE =");
			brMainQuery.append(strHospCode);
			//brMainQuery.append(" AND SSTNUM_ITEM_CAT_NO = 0");
		}
		//System.out.println("brMainQuery:::"+brMainQuery);
		return brMainQuery.toString();
	}

	public String[] getSearchField() {
		String search_field[] = { "1", "HSTNUM_AGENDA_NO" };
		return search_field;
	}

	/**
	 * 0^0 0 Means Combo From Query,
	 * 1  Means User Defined Combo,0 After ^ Means Select Value,
	 * 1 Means All,2 Means Default Selected
	 * */
	public String[] getComboHeader() {
		String[] strComboHeader = { "0^1", "Store Name", "0^1", "Item Category",
				"1", "Compilation Status" };

		return strComboHeader;
	}

	public String[] getColumnHeader() {
		String[] strColumnHeader = { "Compilation No.", "Compilation Date", 
				"Indent Type" , " Indent No.(Against Compilation)" };
		return strColumnHeader;
	}

	public String[] getComboQuery() {
		String[] strComboQry = new String[3];
		String strHospCode = (String) httpSession.getAttribute("HOSPITAL_CODE");
		strComboQry[0] = "SELECT HSTNUM_STORE_ID, INITCAP(HSTSTR_STORE_NAME)"
				+ " AS STORE_NAME FROM HSTT_STORE_MST A WHERE GNUM_ISVALID = 1 "
				+ " AND GNUM_HOSPITAL_CODE = '" + strHospCode + "'  "+
				//+ " AND GDT_EFFECTIVE_FRM <= TRUNC(SYSDATE) "+
				" AND EXISTS"+
				   "("+
				    "SELECT 'X'"+
				    "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"+
				    " WHERE P.gnum_metatable_id = q.gnum_metatable_id"+
				  //  " AND P.gnum_hospital_code = q.gnum_hospital_code"+
				    " AND UPPER(p.gstr_table_name) = UPPER('HSTT_STORE_MST')"+
				    " AND UPPER(p.gstr_column_name) = UPPER('HSTNUM_STORE_ID')"+
				    " AND P.gnum_hospital_code = A.gnum_hospital_code"+
				  " AND gnum_column_value = A.HSTNUM_STORE_ID"+
				 " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+				 
				 ",A.GNUM_HOSPITAL_CODE)"+
				") ORDER BY INITCAP(HSTSTR_STORE_NAME)";
		
		strComboQry[1] = "SELECT DISTINCT SSTNUM_ITEM_CAT_NO , "
				+ "Mms_Mst.get_itemcat_dtl(1 , GNUM_HOSPITAL_CODE , SSTNUM_ITEM_CAT_NO ) AS ITEM_CAT "
				+ "FROM HSTT_STORE_CATEGORY_MST A WHERE GNUM_ISVALID = 1 AND "
				+ "TRUNC(SYSDATE) BETWEEN TRUNC(GDT_EFFECTIVE_FRM) AND NVL(GDT_EFFECTIVE_TO , TRUNC(SYSDATE)) "
				+ "AND GNUM_HOSPITAL_CODE = "
				+ strHospCode
				+ " AND HSTNUM_STORE_ID = #1# "
				+ "AND EXISTS (SELECT 'X' FROM HSTT_STORE_REQTYPE_MST WHERE GNUM_ISVALID = 1 "
				+ "AND TRUNC(SYSDATE) BETWEEN TRUNC(GDT_EFFECTIVE_FRM) AND "
				+ "NVL(GDT_EFFECTIVE_TO , TRUNC(SYSDATE)) AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE"
				+ " AND SSTNUM_INDENTTYPE_ID in (61,88) AND "
				+ "SSTNUM_ITEM_CAT_NO = A.SSTNUM_ITEM_CAT_NO AND HSTNUM_STORE_ID = A.HSTNUM_STORE_ID ) "
				+ "ORDER BY ITEM_CAT";
		strComboQry[2] = "0^In Process#50^Processed#111^Items Received";
		
		
		
		return strComboQry;
	}

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {
		//String strButtons = "<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png' style='cursor:pointer' border=0 tabindex='1' onKeyPress='cancelPage();' onClick='cancelPage();' ></a>";
		return "";
	}

	public String[] getDeleteQuery() {
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";

		return deleteQuery;
	}

	public List<String> getDeleteData(String chk) {
		List<String> deleteData = new ArrayList<String>();
		return deleteData;
	}

	public String getJsFiles() {
		String files = "../../mms/js/agendaDesk.js";
		return files;

	}

	public String[] getRowStatus() {
		String[] status = { "", "1", "brown", "Compilation Desk" };
		return status;
	}

	public String getEventState() {
		String str = "";
		return str;
	}

	public String getButtonConfiguration() {
		return "left";
	}

	public String[] getUserDefinedButtons() {
		String[] str = { "Add@buttonClick('ADD')@1@3b5998@glyphicon-plus",
				"Cancel@buttonClick('CANCEL')@1@bb0000@glyphicon-remove",
				"View@buttonClick('VIEW')@1@007bb6@glyphicon-fullscreen" };
		return str;
	}

	public String[] getDbButtons() {
		return null;
	}

	public int getMinPanelButton() {
		return 1;
	}

	public String getMenuOption() {
		String menuType = "Tiles";
		return menuType;
	}

	public String getComboEventState() {
		return "userDefinedOnLoadFunc";
	}

	public String[] getOrderBy() {
		String orderBy[] = {"2", "HSTDT_AGENDA_DATE", "1", "HSTNUM_AGENDA_NO", };
		return orderBy;
	}
	
	@Override
	public String[] getButtonIcons() {
		String[] str={"AddOnDesk.png","CancelOnDesk.png","ViewOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}

}
