package mms.transactions.controller.utl;

import hisglobal.transactionutil.TransInterface;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import mms.MmsConfigUtil;

public class SampleRegisterTransUTL extends TransInterface {
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
		String transactionName = "Sample Register";
		return transactionName;
	}

	public List<?> getViewHeader() {

		List<String> viewHdr = new ArrayList<String>();
		return viewHdr;
	}

	public String getMainQuery(String cmb[]) {
		StringBuffer brMainQuery = new StringBuffer(500);

		if (cmb != null) {
			String strMainQuery = "select c.HSTNUM_SAMPLE_RECNO||'@'||c.HSTNUM_ITEM_ID||'@'||c.HSTNUM_ITEMBRAND_ID||'@'||"
					+

					" c.HSTSTR_BATCH_SL_NO||'@'||c.HSTNUM_APPROVAL_STATUS||'@'||c.HSTSTR_TENDER_NO||'@'||c.HSTSTR_QUOTATION_NO||'@'||c.consumableFlag||'@'||c.GNUM_HOSPITAL_CODE||'^'||"
					+

					" TO_CHAR(c.HSTDT_SAMPLE_RECDATE,'DD-Mon-YYYY')||'^'||c.HSTSTR_TENDER_NO||'^'||c.item_name"
					+

					" ||'^'||c.HSTSTR_BATCH_SL_NO"
					+

					" ||'^'||c.approval_status||'^'||c.suppname||'^'||c.CommiteeType||'^'||c.approval_status  as data from"
					+

					" (SELECT A.HSTNUM_SAMPLE_RECNO, A.HSTNUM_ITEM_ID, A.HSTNUM_ITEMBRAND_ID,"
					+

					" A.HSTSTR_BATCH_SL_NO, A.GNUM_HOSPITAL_CODE ,A.HSTNUM_APPROVAL_STATUS,"
					+

					" b.HSTDT_SAMPLE_RECDATE,b.HSTSTR_TENDER_NO,b.HSTSTR_QUOTATION_NO,"
					+ " mms_mst.get_item_dtl(1,A.GNUM_HOSPITAL_CODE,a.HSTNUM_ITEMBRAND_ID) as item_name,"
					+

					" decode(A.HSTNUM_APPROVAL_STATUS,0,'-',1,'Approved',2,'Rejected') as approval_status,"
					+

					" mms_mst.get_supp_dtl(1,A.GNUM_HOSPITAL_CODE,b.HSTNUM_SUPPLIER_ID) as suppname,b.HSTNUM_STORE_ID"
					+

					", A.HSTNUM_SAMPLE_ITEM_STATUS,B.SSTNUM_ITEM_CAT_NO, NVL(MMS_MST.GET_COMMTYPE_DTL(1,A.GNUM_HOSPITAL_CODE,A.HSTNUM_COMMITEE_TYPE_ID),'-') as CommiteeType, A.HSTNUM_CONSUMABLE_FLAG as consumableFlag from HSTT_SAMPLE_REC_ITEM_DTL A,HSTT_SAMPLE_RECEIVE_DTL B"
					+

					" where A.HSTNUM_SAMPLE_RECNO=B.HSTNUM_SAMPLE_RECNO" +

					" AND A.GNUM_HOSPITAL_CODE=B.GNUM_HOSPITAL_CODE)c";
			String cond1 = "c.GNUM_HOSPITAL_CODE="
					+ httpSession.getAttribute("HOSPITAL_CODE").toString();
			String cond2 = "c.HSTNUM_STORE_ID=SUBSTR('#1#',1,8)";
			String cond3 = "c.HSTNUM_SAMPLE_ITEM_STATUS=#3#";
			String cond4 = "c.SSTNUM_ITEM_CAT_NO=#2#";
			brMainQuery.append(strMainQuery);
			brMainQuery.append(" where " + cond1);
			brMainQuery.append(" and " + cond2);
			brMainQuery.append(" and " + cond3);
			brMainQuery.append(" and " + cond4);
		} else {
			String strMainQuery = "select c.HSTNUM_SAMPLE_RECNO||'@'||c.HSTNUM_ITEM_ID||'@'||c.HSTNUM_ITEMBRAND_ID||'@'||"
					+

					" c.HSTSTR_BATCH_SL_NO||'@'||c.HSTNUM_APPROVAL_STATUS||'@'||c.GNUM_HOSPITAL_CODE||'^'||"
					+

					" TO_CHAR(c.HSTDT_SAMPLE_RECDATE,'DD-Mon-YYYY')||'^'||c.HSTSTR_TENDER_NO||'^'||c.item_name"
					+

					" ||'^'||c.HSTSTR_BATCH_SL_NO"
					+

					" ||'^'||c.approval_status||'^'||c.suppname||'^'||c.CommiteeType||'^'||c.approval_status as  data from"
					+

					" (SELECT A.HSTNUM_SAMPLE_RECNO, A.HSTNUM_ITEM_ID, A.HSTNUM_ITEMBRAND_ID,"
					+

					" A.HSTSTR_BATCH_SL_NO, A.GNUM_HOSPITAL_CODE ,A.HSTNUM_APPROVAL_STATUS,"
					+

					" b.HSTDT_SAMPLE_RECDATE,b.HSTSTR_TENDER_NO,"
					+ " mms_mst.get_item_dtl(1,A.GNUM_HOSPITAL_CODE,a.HSTNUM_ITEM_ID) as item_name,"
					+

					" decode(A.HSTNUM_APPROVAL_STATUS,0,'-',1,'Approved',2,'Rejected') as approval_status,"
					+

					" mms_mst.get_supp_dtl(1,A.GNUM_HOSPITAL_CODE,b.HSTNUM_SUPPLIER_ID) as suppname,b.HSTNUM_STORE_ID"
					+

					", A.HSTNUM_SAMPLE_ITEM_STATUS,B.SSTNUM_ITEM_CAT_NO, NVL(MMS_MST.GET_COMMTYPE_DTL(1,A.GNUM_HOSPITAL_CODE,A.HSTNUM_COMMITEE_TYPE_ID),'-') as CommiteeType from HSTT_SAMPLE_REC_ITEM_DTL A,HSTT_SAMPLE_RECEIVE_DTL B"
					+

					" where A.HSTNUM_SAMPLE_RECNO=B.HSTNUM_SAMPLE_RECNO" +

					" AND A.GNUM_HOSPITAL_CODE=B.GNUM_HOSPITAL_CODE)c";
			brMainQuery.append(strMainQuery);
			brMainQuery.append(" where  c.GNUM_HOSPITAL_CODE=0");
		}
		return brMainQuery.toString();
	}

	public String[] getSearchField() {
		String search_field[] = { "3", "c.item_name", "6", "c.suppname" };
		return search_field;
	}

	public String[] getComboHeader() 
	{
		//String[] strComboHeader = { "0^2", "Drug Warehouse Name", "0^2","Item Category", "1", "Sample Status" };
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] strComboHeader = new String[6];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Drug WareHouse Name";
			strComboHeader[2] = "0^2";
			strComboHeader[3] = "Category";
			strComboHeader[4] = "1";
			strComboHeader[5] = "Sample Status";

		}
		else
		{
			strComboHeader[0] = "0^2";
			strComboHeader[1] = "Store Name";
			strComboHeader[2] = "0^2";
			strComboHeader[3] = "Category";
			strComboHeader[4] = "1";
			strComboHeader[5] = "Sample Status";
		}
		
		
		
		
		return strComboHeader;
	}

	public String[] getColumnHeader() {

		//String[] strColumnHeader = { "Recieved Date", "Tender No.",	"Item Name", "Batch No.", "Approval Status", "Supplier Name","Committee Name" };
		
		MmsConfigUtil mmscofigutil = new  MmsConfigUtil(httpSession.getAttribute("HOSPITAL_CODE").toString());	
		String[] strColumnHeader = new String[7];
		if (mmscofigutil.getStrStoreConfigCatg().equals("10")) 
		{	

			strColumnHeader[0] = "Recieved Date";
			strColumnHeader[1] = "Tendor No.";
			strColumnHeader[2] = "Drug Name";
			strColumnHeader[3] = "Batch No.";
			strColumnHeader[4] = "Approval Status";
			strColumnHeader[5] = "Supplier Name";
			strColumnHeader[6] = "Committee Name";

		}
		else
		{
			strColumnHeader[0] = "Recieved Date";
			strColumnHeader[1] = "Tendor No.";
			strColumnHeader[2] = "Item Name";
			strColumnHeader[3] = "Batch No.";
			strColumnHeader[4] = "Approval Status";
			strColumnHeader[5] = "Supplier Name";
			strColumnHeader[6] = "Committee Name";
		}
		
		
		return strColumnHeader;
	}

	public String[] getComboQuery() {
		String comboQuery[] = new String[3];
		comboQuery[0] = "select HSTNUM_STORE_ID||'/'||HSTNUM_STORETYPE_ID,HSTSTR_STORE_NAME"
				+ " FROM HSTT_STORE_MST A where  GNUM_ISVALID = 1 and  GNUM_HOSPITAL_CODE="
				+ httpSession.getAttribute("HOSPITAL_CODE").toString()
				/*+ " AND EXISTS"
				+ "("
				+ "SELECT 'X'"
				+ "FROM GBLT_ROLE_SEAT_TABLE_DTL P, GBLT_METATABLE_COLUMN_MST q"
				+ " WHERE P.gnum_metatable_id = q.gnum_metatable_id"
				+ " AND P.gnum_hospital_code = q.gnum_hospital_code"
				+ " AND UPPER(gstr_table_name) = UPPER('HSTT_STORE_MST')"
				+ " AND UPPER(gstr_column_name) = UPPER('HSTNUM_STORE_ID')"
				+ " AND P.gnum_hospital_code = A.gnum_hospital_code"
				+ " AND gnum_column_value = A.HSTNUM_STORE_ID"
				+ " AND P.gnum_seatid = Pkg_Usermgmt.fun_getseatid("
				+ httpSession.getAttribute("SEATID").toString()
				+ ",A.GNUM_HOSPITAL_CODE)"
				+ ")*/ +"ORDER BY INITCAP(HSTSTR_STORE_NAME)";

		if (cmbVal == null)
			comboQuery[1] = "SELECT SSTNUM_ITEM_CAT_NO,  mms_mst.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO)"
					+ " FROM HSTT_STORE_CATEGORY_MST"
					+ " WHERE HSTNUM_STORE_ID=0"
					+ " AND GNUM_HOSPITAL_CODE="
					+ httpSession.getAttribute("HOSPITAL_CODE").toString();
		else {

			comboQuery[1] = "SELECT SSTNUM_ITEM_CAT_NO,  mms_mst.GET_ITEMCAT_DTL(1,GNUM_HOSPITAL_CODE,SSTNUM_ITEM_CAT_NO) as ITEM_CAT"
					+ " FROM HSTT_STORE_CATEGORY_MST A"
					+ " WHERE HSTNUM_STORE_ID=SUBSTR('#1#',1,8) AND TRUNC(SYSDATE) BETWEEN TRUNC(GDT_EFFECTIVE_FRM) AND TRUNC(NVL(GDT_EFFECTIVE_TO,SYSDATE))"
					+ " AND GNUM_HOSPITAL_CODE="
					+ httpSession.getAttribute("HOSPITAL_CODE").toString()
				/*	+ " AND EXISTS"
					+ " (SELECT 'X'"
					+ " FROM HSTT_STORE_REQTYPE_MST"
					+ "  WHERE GNUM_ISVALID = 1"
					+ "  AND TRUNC(SYSDATE) BETWEEN TRUNC(GDT_EFFECTIVE_FRM) AND NVL(GDT_EFFECTIVE_TO , TRUNC(SYSDATE)) "
					+ "  AND GNUM_HOSPITAL_CODE = A.GNUM_HOSPITAL_CODE "
					+ "  AND SSTNUM_INDENTTYPE_ID = 53 "
					+ "  AND SSTNUM_ITEM_CAT_NO = A.SSTNUM_ITEM_CAT_NO"
					+ " AND HSTNUM_STORE_ID = A.HSTNUM_STORE_ID"
					+ " )*/ +" ORDER BY ITEM_CAT";

		}
		comboQuery[2] = ("0^Active#1^Returned#2^Disposed");
		return comboQuery;

	}

	public String getViewQuery() {
		return "";
	}

	public String getButtons() {
		String strButtons = "";
		// "<a style=cursor:pointer><img src='../../hisglobal/images/btn-ccl.png' border=0 tabindex='1' onKeyPress='cancelPage();' onClick='cancelPage();' style='cursor: pointer;' ></a>";
		return strButtons;

	}

	public String[] getDeleteQuery() {

		String deleteQuery[] = { "" };
		return deleteQuery;
	}

	/*
	 * chk >> key1@key2|extra_info define the delete data for every delete query
	 * in same order as defined in delete query
	 * 
	 * @see
	 * hisglobal.transactionutil.TransInterface#getDeleteData(java.lang.String)
	 */
	public List<?> getDeleteData(String chk) {
		String a[] = null;
		String b[] = null;
		String key[] = new String[1];

		List<String[]> deleteData = new ArrayList<String[]>();

		// a[0] >> key, a[1] >> extra info
		a = (chk.replace('|', '#')).split("#");
		// split key
		b = (a[0].replace('@', '#')).split("#");

		key[0] = b[0];
		deleteData.add(key);
		// deleteData.add(null);
		// deleteData.add(key);

		return null;
	}

	public String getJsFiles() {
		String files = "../../mms/js/sampleRegister_trans.js";

		return files;

	}

	public String[] getRowStatus() {
		// String[] status = {"Autrin Cap", "2", "brown", "Expired","aLkol",
		// "2", "blue", "Alkol"};
		String[] status = { "Rejected", "6", "#FA6D62", "Rejected", "Approved",
				"9", "#38B647", "Approved" };
		return status;
	}

	public String getEventState() {
		String str = "";
		return str;
	}

	public String getButtonConfiguration() {
		// TODO Auto-generated method stub
		return "left";
	}

	public String[] getUserDefinedButtons() {

		String[] strButtons = {
				"Recieve@validateRecieve(document.forms[0],'RECIEVE')@0@ea4c89@glyphicon-share",
				"Verify@validateVerify(document.forms[0],'VERIFY')@1@00aced@glyphicon-check",
				"Return@validateReturn(document.forms[0],'RETURN')@1@32506d@glyphicon-menu-left",
				"Dispose@validateCondemn(document.forms[0],'CONDEMN')@1@FFC007@glyphicon-compressed" };
		return strButtons;

	}

	public String[] getDbButtons() {
		// TODO Auto-generated method stub
		// String[] str={"1"};
		return null;
	}

	public int getMinPanelButton() {
		// TODO Auto-generated method stub
		return 1;
	}

	/**
	 * Frames option will not work (non-Javadoc)
	 * 
	 * @see hisglobal.transactionutil.TransInterface#getMenuOption()
	 */

	public String getMenuOption() {
		String menuType = "Tiles";
		return menuType;
	}

	@Override
	public String getComboEventState() {
		return "chkCombo";
	}

	// new features
	public String[] getOrderBy() {
		String orderBy[] = { "3", "c.item_name", "6", "c.suppname" };
		// String orderBy[] = {};
		return orderBy;
	}

}
