package mms.transactions.controller.utl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;
import hisglobal.transactionutil.TransInterface;

public class CondemnationRegisterTransUTL extends TransInterface {

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
		String masterName = "Condemnation Register";
		return masterName;
	}

	public List<String> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) {
		StringBuffer brMainQuery = new StringBuffer(500);
		String strHospitalCode = httpSession.getAttribute("HOSPITAL_CODE")
				.toString();
		if (cmb != null) {
			String cond1 = "HSTNUM_STORE_ID=#1#";
			String cond2 = " AND SSTNUM_ITEM_CAT_NO=#2#";
			String cond3 = " HSTNUM_AGENDA_STATUS =#3#";
			brMainQuery.append("select HSTNUM_AGENDA_NO||'@'||HSTNUM_CONDEMNATION_TYPE||'@'||to_char(HSTDT_AGENDA_DATE,'dd-Mon-yyyy')||'@'||GNUM_HOSPITAL_CODE||'^'||HSTNUM_AGENDA_NO||'^'||to_char(HSTDT_AGENDA_DATE,'dd-Mon-yyyy')||'^'||DECODE(HSTNUM_CONDEMNATION_TYPE,1,'Crushed',2,'Burn',3,'Auction','-') DATA FROM HSTT_AGENDA_DTL");
			brMainQuery.append(" where " + cond3 + " AND GNUM_HOSPITAL_CODE="
					+ strHospitalCode);
			// brMainQuery.append(" "+cond3);
			brMainQuery.append("  AND GNUM_ISVALID=1");
			brMainQuery.append(" AND " + cond1);
			brMainQuery.append("  " + cond2);
			
			} else {
			
				String cond3 = " HSTNUM_AGENDA_STATUS =0";
				brMainQuery.append("select HSTNUM_STORE_ID||'@'||A.HSTNUM_AGENDA_NO||'@'||GNUM_HOSPITAL_CODE||'@'||to_char(HSTDT_AGENDA_DATE,'dd-Mon-yyyy')||'^'||HSTNUM_AGENDA_NO||'^'||to_char(HSTDT_AGENDA_DATE,'dd-Mon-yyyy')||'^'||mms_mst.get_itemcat_dtl('1',GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) DATA FROM HSTT_AGENDA_DTL A");
				brMainQuery.append(" where " + cond3 + " AND GNUM_HOSPITAL_CODE=0");
			}
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
	public String[] getComboHeader() 
	{
	
//		String[] strComboHeader = { "0^2", "Drug Warehouse Name", "0^2", "Item Category",
//				"1", "Status" };
		
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] strComboHeader = new String[6];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Drug Warehouse Name";
			strComboHeader[2] = "0^2";
			strComboHeader[3] = "Drug Category";
			strComboHeader[4] = "1";
			strComboHeader[5] = "Status";

		}
		else
		{
			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "0^2";
			strComboHeader[3] = "Item Category";
			strComboHeader[4] = "1";
			strComboHeader[5] = "Status";

		}
		
		
		return strComboHeader;
	}

	public String[] getColumnHeader() 
	{
		String[] strColumnHeader = { "Lots No.", "Lot Date",
				"Condemnation Type" };
		return strColumnHeader;
	}

	public String[] getComboQuery() {

		String[] comboQuery = new String[3];
		comboQuery[0] = "select HSTNUM_STORE_ID,HSTSTR_STORE_NAME"
			+ " FROM HSTT_STORE_MST A where  GNUM_ISVALID = 1 and  GNUM_HOSPITAL_CODE="
			+ httpSession.getAttribute("HOSPITAL_CODE").toString()+" AND GDT_EFFECTIVE_FRM<=TRUNC(SYSDATE)"+
			" AND EXISTS"+
			   "("+
			    "SELECT 'X'"+
			    "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"+
			    " WHERE P.gnum_metatable_id = q.gnum_metatable_id"+
			    " AND P.gnum_hospital_code = q.gnum_hospital_code"+
			    " AND UPPER(gstr_table_name) = UPPER('HSTT_STORE_MST')"+
			    " AND UPPER(gstr_column_name) = UPPER('HSTNUM_STORE_ID')"+
			    " AND P.gnum_hospital_code = A.gnum_hospital_code"+
			  " AND gnum_column_value = A.HSTNUM_STORE_ID"+
			 " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("+httpSession.getAttribute("SEATID").toString()+				 
			 ",A.GNUM_HOSPITAL_CODE)"+
			") ORDER BY INITCAP(HSTSTR_STORE_NAME)";
		
		if (cmbVal == null)
				comboQuery[1] = "SELECT SSTNUM_ITEM_CAT_NO,  mms_mst.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO)"
				+ " FROM HSTT_STORE_CATEGORY_MST"
				+ " WHERE HSTNUM_STORE_ID=0"
				+ " AND GNUM_HOSPITAL_CODE="
				+ httpSession.getAttribute("HOSPITAL_CODE").toString();
		else {
				 comboQuery[1] = "SELECT SSTNUM_ITEM_CAT_NO,  mms_mst.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) as ITEM_CAT" +
				 " FROM HSTT_STORE_CATEGORY_MST A"+
				 " WHERE HSTNUM_STORE_ID=#1# AND TRUNC(SYSDATE) BETWEEN TRUNC(GDT_EFFECTIVE_FRM) AND TRUNC(NVL(GDT_EFFECTIVE_TO,SYSDATE))"+
			       " AND GNUM_HOSPITAL_CODE="+httpSession.getAttribute("HOSPITAL_CODE").toString()+
			       " AND EXISTS"+
					  " (SELECT 'X'"+
					" FROM HSTT_STORE_REQTYPE_MST" +
					"  WHERE GNUM_ISVALID = 1"+
					"  AND TRUNC(SYSDATE) BETWEEN TRUNC(GDT_EFFECTIVE_FRM) AND NVL(GDT_EFFECTIVE_TO , TRUNC(SYSDATE)) "+
					"  AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE "+ 
					"  AND SSTNUM_INDENTTYPE_ID = 59 "+
					"  AND SSTNUM_ITEM_CAT_NO = A.SSTNUM_ITEM_CAT_NO"+
					 " AND HSTNUM_STORE_ID = A.HSTNUM_STORE_ID"+
					" ) ORDER BY ITEM_CAT";
		
	}

		comboQuery[2] = "0^Active#50^Processed";

		return comboQuery;

	}

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {
		String strButtons = "";
			//"<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png' border=0 tabindex='1' onKeyPress='cancelPage();' onClick='cancelPage();' style='cursor: pointer;' ></a>";
		return strButtons;
	}

	public String[] getDeleteQuery() {
		String deleteQuery[] = new String[1];
		deleteQuery[0] = "";

		return deleteQuery;
	}

	public List<String> getDeleteData(String chk) {
		String a[] = null;
		String b[] = null;
		String key[] = new String[1];

	//	List deleteData = new ArrayList();
		a = (chk.replace('|', '#')).split("#");
		b = (a[0].replace('@', '#')).split("#");

		key[0] = b[0];
		
		
		return null;
	}

	public String getJsFiles() {
		String files = "../../mms/js/condemnRegister.js";
		return files;

	}

	public String[] getRowStatus() {
		String[] status = { "Autrin Cap", "2", "brown", "Expired", "aLkol",
				"2", "blue", "Alkol" };
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
		String[] strButtons = { "Condemn@validateCondemn()@1@FFC007@glyphicon-compressed",
				"View@viewCondemn()@1@007bb6@glyphicon-fullscreen" };
		return strButtons;
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
		return "";
	}

	public String[] getOrderBy() {
		String orderBy[] = { "1", "HSTNUM_AGENDA_NO" };
		return orderBy;
	}

	@Override
	public String[] getButtonIcons() {
		String[] str={"CancelOnDesk.png","ViewOnDesk.png"};
		// TODO Auto-generated method stub
		return str;
	}
}
